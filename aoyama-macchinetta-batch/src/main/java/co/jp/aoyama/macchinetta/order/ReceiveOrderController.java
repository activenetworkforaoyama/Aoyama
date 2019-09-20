package co.jp.aoyama.macchinetta.order;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dozer.util.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.jp.aoyama.macchinetta.app.rest.api.enums.LiningEnum;
import co.jp.aoyama.macchinetta.app.rest.api.enums.MeasurementEnum;
import co.jp.aoyama.macchinetta.app.rest.api.enums.Option2PantsEnum;
import co.jp.aoyama.macchinetta.app.rest.api.enums.OptionGiletEnum;
import co.jp.aoyama.macchinetta.app.rest.api.enums.OptionJackeEnum;
import co.jp.aoyama.macchinetta.app.rest.api.enums.OptionPantsEnum;
import co.jp.aoyama.macchinetta.app.rest.api.enums.OrderDetailEnum;
import co.jp.aoyama.macchinetta.app.rest.api.model.ErrorCode;
import co.jp.aoyama.macchinetta.app.rest.api.model.ErrorCodeInfo;
import co.jp.aoyama.macchinetta.app.rest.api.model.Fabric;
import co.jp.aoyama.macchinetta.app.rest.api.model.Lining;
import co.jp.aoyama.macchinetta.app.rest.api.model.Measurement;
import co.jp.aoyama.macchinetta.app.rest.api.model.Option;
import co.jp.aoyama.macchinetta.app.rest.api.model.Order;
import co.jp.aoyama.macchinetta.app.rest.api.model.OrderDetail;
import co.jp.aoyama.macchinetta.app.rest.api.model.Orders;
import co.jp.aoyama.macchinetta.app.rest.api.model.Token;
import co.jp.aoyama.macchinetta.app.rest.api.util.AESEncrypt;
import co.jp.aoyama.macchinetta.app.rest.api.util.HttpUtil;
import co.jp.aoyama.macchinetta.domain.dto.Message;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;
import co.jp.aoyama.macchinetta.domain.service.order.DtbOrderService;

/**
 * 
 * @author liufeng
 *
 */
@Component
public class ReceiveOrderController {

	@Inject
	DtbOrderService orderService;

//	@Inject
//	MtbOrderDetailEnumService mtbOrderDetailEnumService;
//
//	@Inject
//	MtbLiningEnumService mtbLiningEnumService;
//
//	@Inject
//	MtbMeasurementEnumService mtbMeasurementEnumService;
//
//	@Inject
//	MtbOptionEnumService mtbOptionEnumService;

	@Inject
	RestTemplate restTemplate;

	@Value("${api.url.GetAccessToken:http://qs.dayang.net/QSservice.asmx/GetAccessToken}")
	URI tokenUri;

	@Value("${api.url.ReceiveOrder:http://qs.dayang.net/QSservice.asmx/ReceiveOrder}")
	URI receiveOrderUri;

	@Value("${api.url.GetErrorCode:http://qs.dayang.net/QSservice.asmx/GetErrorCode}")
	URI getErrorCodeUri;

	@Value("${api.appsecrets}")
	String appSecrets;

	@Value("${api.timeout.connect}")
	int connectTimeout;

	@Value("${api.timeout.read}")
	int readTimeout;

	/** 一回送信注文データ件数 */
//	@Value("${api.send.maxcount.ReceiveOrder}")
//	int sendMaxCout;

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(ReceiveOrderController.class);

	/** JACKET */
	public static final String ITEM_02 = "02";
	/** PANTS */
	public static final String ITEM_03 = "03";
	/** GILET */
	public static final String ITEM_04 = "04";
	/** 2P (JACKET + PANTS) */
	public static final String ITEM_21 = "21";
	/** 2PP (JACKET + PANTS + 2PANTS) */
	public static final String ITEM_22 = "22";
	/** 3P (JACKET + PANTS + GILET) */
	public static final String ITEM_31 = "31";
	/** 3P2PP (JACKET + PANTS + GILET + 2PANTS) */
	public static final String ITEM_32 = "32";

	/** STYLE_NO */
	public static final String STYLE_NO_01 = "01";
	public static final String STYLE_NO_02 = "02";
	public static final String STYLE_NO_03 = "03";
	public static final String STYLE_NO_04 = "04";

	/** SUB_NO */
	public static final String SUB_NO_EMPTY = "";
	public static final String SUB_NO_01 = "_01";
	public static final String SUB_NO_02 = "_02";
	public static final String SUB_NO_03 = "_03";
	public static final String SUB_NO_04 = "_04";

	/** CLASS_TYPE */
	public static final String CLASS_TYPE_02 = "02";
	public static final String CLASS_TYPE_05 = "05";
	public static final String CLASS_TYPE_17 = "17";

	/** 注文送信結果：成功 */
	public static final String RECEIVE_RESULT_SUCCESS = "100";

	/** 工場コード：大連大楊 */
	public static final String FACTORY_CODE = "F00005";
	/** 注文パターン：パターンオーダー */
	public static final String ORDER_PATTERN = "PO";

	/** エラーコードマップ */
	private Map<String, String> errorCodeMap = null;
//	/** ジャケット用列挙体 */
//	List<MtbOptionEnum> optionJacketEnums = null;
//	/** パンツ用列挙体 */
//	List<MtbOptionEnum> optionPantsEnums = null;
//	/** Gilet用列挙体 */
//	List<MtbOptionEnum> optionGiletEnums = null;
//	/** パンツ２用列挙体 */
//	List<MtbOptionEnum> option2PantsEnums = null;

	/**
	 * DB ステータス を変更
	 * 
	 * @return void
	 */
	public void changeDbStatus(List<DtbOrder> dtbOrders) {
		logger.info("ReceiveOrder:大楊へ注文データの送信処理開始");

		List<Message> messageList = getMsgJson(dtbOrders);

		if (null != messageList) {
			// ReceiveOrderの戻る値に対して、SuccessとFailがある、下記判断により、受注表の工場自動連携ステータスや工場ステータス設定する。
			if (messageList.get(0).getResult() != null) {

				if (RECEIVE_RESULT_SUCCESS.equals(messageList.get(0).getResult())) {
					logger.info("送信正常終了の更新処理開始");
					// 100
					// ReceiveOrderの戻るはSuccessの場合、SuccessのResultは100の場合、送信成功として、
					// 受注表で工場自動連携ステータスを「送信済み」に設定して、工場ステータスを「生産開始」に設定する
					orderService.receiveSuccess(dtbOrders);
					logger.info("送信正常終了の更新処理終了");
				} else {
					logger.info("送信失敗の更新処理開始");
					// ReceiveOrderの戻るはFailの場合、FailのResultは100以外、すなわち、転送データタイプエラーがあるの場合、
					// 受注表で工場自動連携ステータスを「送信失敗データタイプエラー]に設定する。
					orderService.receiveException(dtbOrders);
					logger.info("送信失敗の更新処理終了");
				}
			} else {
				logger.info("送信結果エラーありの更新処理開始");
				// ReceiveOrderの戻るはFailの場合、FailのResultがない、ordernoがあるの場合、すなわち、注文データエラーがあるの場合
				// エラーコードマップを作成する
				getErrorCodeInfo();

				orderService.receiveError(messageList, dtbOrders, errorCodeMap);
				logger.info("送信結果エラーありの更新処理終了");
			}
		}
		logger.info("ReceiveOrder:大楊へ注文データの送信処理終了");
	}

	/**
	 * エラーコードマップを作成する
	 */
	private void getErrorCodeInfo() {
		logger.info("エラー情報取得処理開始");
		if (null == this.errorCodeMap) {

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
			HttpEntity<String> requestErrorCode = new HttpEntity<String>(headers);
			ErrorCode errorCodeList = restTemplate.postForObject(getErrorCodeUri, requestErrorCode, ErrorCode.class);

			Gson gson = new Gson();
			List<ErrorCodeInfo> errorCodeInfoList = gson.fromJson(errorCodeList.getD(),
					new TypeToken<List<ErrorCodeInfo>>() {
					}.getType());

			logger.info("エラー情報リスト:{}", JSON.toJSONString(errorCodeInfoList));

			this.errorCodeMap = new HashMap<String, String>(16);
			for (ErrorCodeInfo errorCodeInfo : errorCodeInfoList) {
				this.errorCodeMap.put(errorCodeInfo.getError_code(), errorCodeInfo.getRemark());
			}
		}
		logger.info("エラー情報取得処理終了");
	}

	/**
	 * APIを伝送する
	 * 
	 * @return 注文情報リスト
	 */
	private List<Message> getMsgJson(List<DtbOrder> dtbOrders) {

		Orders orders = getOrders(dtbOrders);

		logger.info("送信処理開始");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		HttpEntity<String> requestToken = new HttpEntity<String>(headers);
		Token token = restTemplate.postForObject(tokenUri, requestToken, Token.class);
		logger.info("送信用token:{}", token.getD());

		JSONObject orderJson = new JSONObject();
		orderJson.put("Action", "CreateOrder");
		orderJson.put("orders", orders);
		String orderString = new Gson().toJson(orderJson);

		orderString = orderString.replace("class_item", "class");
		orderString = orderString.replace("classType", "class");

		logger.info("暗号化前の送信文字列:{}", orderString);
		String encryptOrder = AESEncrypt.encrypt1(orderString, appSecrets, token.getD());

		logger.info("暗号化後の送信文字列:{}", encryptOrder);

		String res = "";

		Map<String, String> param = new HashMap<String, String>(3, 1);
		param.put("orders", encryptOrder);
		param.put("AccessToken", token.getD());
		param.put("Brand", "QS");
		logger.info("送信パラメータ:{}", param);

		try {
			res = new HttpUtil(connectTimeout, readTimeout).post(receiveOrderUri.toString(), param, null);

			logger.info("大連大楊PO送信結果文字列:{}", res);
			res = res.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
			res = res.replace("<string xmlns=\"http://tempuri.org/\">", "");
			res = res.replace("</string>", "");

			if (null != res && 0 < res.length() && !res.substring(0, 1).equals("[")) {
				res = "[" + res + "]";
			}

			logger.info("大連大楊PO送信結果文字列(無効内容抜き):{}", res);
		} catch (SocketTimeoutException e) {
			e.getStackTrace();
			logger.info("大連大楊PO送信タイムアウト:{}", e.getMessage());
			orderService.receiveTimeout(dtbOrders);
			return null;
		} catch (Exception e) {
			e.getStackTrace();
			logger.info("大連大楊PO送信結果異常:{}", e.getMessage());
			return null;
		}

		Gson gson = new Gson();

		List<Message> messageList = gson.fromJson(res, new TypeToken<List<Message>>() {
		}.getType());

		logger.info("送信結果リスト:{}", JSON.toJSONString(messageList));

		logger.info("送信処理終了");
		return messageList;
	}

	/**
	 * 注文APIを取得
	 * 
	 * @return 注文情報リスト
	 */
	private Orders getOrders(List<DtbOrder> dtbOrders) {
		logger.info("送信文字列作成開始");

		List<Order> orderList = new ArrayList<Order>();
//		List<MtbOrderDetailEnum> orderDetailEnums = mtbOrderDetailEnumService.selectByFactoryPattern(FACTORY_CODE,
//				ORDER_PATTERN);
//		List<MtbLiningEnum> liningEnums = mtbLiningEnumService.selectByFactoryPattern(FACTORY_CODE, ORDER_PATTERN);
//		List<MtbMeasurementEnum> measurementEnums = mtbMeasurementEnumService.selectByFactoryPattern(FACTORY_CODE,
//				ORDER_PATTERN);
//		optionJacketEnums = mtbOptionEnumService.selectByTypeFactoryPattern("jacket", FACTORY_CODE, ORDER_PATTERN);
//		optionPantsEnums = mtbOptionEnumService.selectByTypeFactoryPattern("pants", FACTORY_CODE, ORDER_PATTERN);
//		optionGiletEnums = mtbOptionEnumService.selectByTypeFactoryPattern("gilet", FACTORY_CODE, ORDER_PATTERN);
//		option2PantsEnums = mtbOptionEnumService.selectByTypeFactoryPattern("pants2", FACTORY_CODE, ORDER_PATTERN);

		Object[] args = {};
		Date nowDate = new Date();
		SimpleDateFormat formatter_ymd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter_ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (DtbOrder dtbOrder : dtbOrders) {
			Order order = new Order();

			// orderその他
			order.setBrand("QS");
			order.setMainorder(dtbOrder.getOrderId());
			logger.info("送信注文ID:{}", dtbOrder.getOrderId());

			order.setShop(dtbOrder.getShopCode());

			if (dtbOrder.getProductOrderdDate() != null) {
				String productOrderdDate = formatter_ymd.format(dtbOrder.getProductOrderdDate());
				order.setCdate(productOrderdDate);
			}

			if (dtbOrder.getCustShopDeliveryDate() != null) {
				String deliverDate = formatter_ymd.format(dtbOrder.getCustShopDeliveryDate());
				order.setDeliver_date(deliverDate);
			}
			order.setImport_time(formatter_ymdhms.format(nowDate));
			order.setRemark("");
			order.setCustomer("");
			order.setReceiver("");
			order.setCountry("");
			order.setProvince("");
			order.setAddress("");
			order.setPostcode("");
			order.setContactnumber("");
			order.setFront("");
			order.setBack("");
			order.setSideLeft("");
			order.setSideRight("");

			// OrderDetails
			List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			String productItem = dtbOrder.getProductItem();
			String productItemDisplaycode = dtbOrder.getProductItemDisplaycode();

			OrderDetailEnum[] orderDetailEnums = OrderDetailEnum.values();
			for (OrderDetailEnum orderDetailEnum : orderDetailEnums) {
//			for (MtbOrderDetailEnum orderDetailEnum : orderDetailEnums) {
				OrderDetail orderDetail = new OrderDetail();
				if (productItem == null) {
					productItem = "";
				}
				if (productItemDisplaycode == null) {

					productItemDisplaycode = "";
				}
				if (productItem.equals(orderDetailEnum.getItem())
						|| productItemDisplaycode.equals(orderDetailEnum.getItem())) {

					orderDetail.setOrder(dtbOrder.getOrderId());
					orderDetail.setOrderdetailid(dtbOrder.getOrderId() + orderDetailEnum.getSubNo());
					orderDetail.setCombination(orderDetailEnum.getCombination());
					orderDetail.setMode("02");
//					orderDetail.setStyleno(orderDetailEnum.getStyleNo());
					orderDetail.setStyleno(orderDetailEnum.getStyleno());
					orderDetail.setClass_item(orderDetailEnum.getClassType());
					// Fabric
					List<Fabric> fabrics = new ArrayList<Fabric>();

					Fabric fabric = new Fabric();
					fabric.setSku(dtbOrder.getProductFabricNo());
					fabric.setMode("01");
					fabric.setVendor("");
					fabric.setDescription("");
					fabric.setComposition("");
					fabric.setLength("");
					fabrics.add(fabric);

					orderDetail.setFabric(fabrics);

					// Lining
					List<Lining> Linings = new ArrayList<Lining>();
					LiningEnum[] liningEnums = LiningEnum.values();

					for (LiningEnum liningEnum : liningEnums) {
//					for (MtbLiningEnum liningEnum : liningEnums) {
						if (liningEnum.getJkInnerBodyClothCd().equals(dtbOrder.getJkInnerBodyClothCd())
								&& !orderDetail.getClass_item().equals(CLASS_TYPE_05)) {
							Lining lining = new Lining();
							lining.setSku(liningEnum.getSku());
							lining.setMode(liningEnum.getMode());
							lining.setVendor(liningEnum.getVendor());
							lining.setDescription(liningEnum.getDescription());
							lining.setComposition(liningEnum.getComposition());
							lining.setLength(liningEnum.getLength());
							Linings.add(lining);
						}
					}

					orderDetail.setLining(Linings);
					orderDetail.setCl_flag("0");
					orderDetail.setPtype("01");
					orderDetail.setMade("Half Canvas");

					try {
						Class<?> cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.DtbOrder");
						Method getDrop = getMethod(cls, orderDetailEnum.getGetDrop());
						Method getSize = getMethod(cls, orderDetailEnum.getGetSize());
						String drop = (String) ReflectionUtils.invoke(getDrop, dtbOrder, args);
						String size = (String) ReflectionUtils.invoke(getSize, dtbOrder, args);
						if (drop == null || size == null || drop.equals("") || size.equals("")) {
							orderDetail.setTryon("");
						} else {
							orderDetail.setTryon(
									drop.substring(0, drop.indexOf("(")) + "" + size.substring(0, size.indexOf("(")));

						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						logger.error(e.toString());
					}

					orderDetail.setFit("");
					orderDetail.setRemark("");
					orderDetail.setVendor("");
					orderDetail.setPrevious_order("");
					orderDetail.setProvious_vendor("");
					orderDetail.setOrder_urgent("0");
					orderDetail.setUrgent_days("0");
					orderDetail.setMark_type("");

					orderDetails.add(orderDetail);

				}
			}
			order.setOrderDetails(orderDetails);

			// Measurements
			List<Measurement> measurements = new ArrayList<Measurement>();
			MeasurementEnum[] measurementEnums = MeasurementEnum.values();
			for (MeasurementEnum measurementEnum : measurementEnums) {
//			for (MtbMeasurementEnum measurementEnum : measurementEnums) {
				if (productItem.equals(measurementEnum.getItem())
						|| productItemDisplaycode.equals(measurementEnum.getItem())) {
					Measurement measurement = new Measurement();

					measurement.setOrderdetailid(dtbOrder.getOrderId() + measurementEnum.getSubNo());
//					measurement.setStyleno(measurementEnum.getStyleNo());
					measurement.setStyleno(measurementEnum.getStyleno());
					measurement.setClassType(measurementEnum.getClassType());
//					measurement.setItem_code(measurementEnum.getItemCode());
					measurement.setItem_code(measurementEnum.getItem_code());
					measurement.setTryon_adjustment("0");
					try {
						Class<?> cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.DtbOrder");
//						Method getGet_gross = getMethod(cls, measurementEnum.getGetGross());
						Method getGet_gross = getMethod(cls, measurementEnum.getGet_gross());
						BigDecimal grossValue = (BigDecimal) ReflectionUtils.invoke(getGet_gross, dtbOrder, args);
						if (grossValue == null) {
							measurement.setValue("");
						} else {
							measurement.setValue(grossValue.toString());
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						logger.error(e.toString());
					}
					measurements.add(measurement);
				}
			}
			order.setMeasurements(measurements);

			// Options
			List<Option> options = new ArrayList<Option>();
			// JACKETの場合
			if (productItem.equals(ITEM_02) || productItemDisplaycode.equals(ITEM_02)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_02, dtbOrder, SUB_NO_EMPTY);
				options.addAll(jacketOptions);
			}
			// PANTSの場合
			if (productItem.equals(ITEM_03) || productItemDisplaycode.equals(ITEM_03)) {
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_01, CLASS_TYPE_05, dtbOrder, SUB_NO_EMPTY);
				options.addAll(pantsOptions);
			}
			// GILETの場合
			if (productItem.equals(ITEM_04) || productItemDisplaycode.equals(ITEM_04)) {
				List<Option> giletOptions = getGiletOptions(STYLE_NO_01, CLASS_TYPE_17, dtbOrder, SUB_NO_EMPTY);
				options.addAll(giletOptions);
			}
			// 2P (JACKET + PANTS)の場合
			if (productItem.equals(ITEM_21) || productItemDisplaycode.equals(ITEM_21)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_02, dtbOrder, SUB_NO_EMPTY);
				options.addAll(jacketOptions);
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_02, CLASS_TYPE_05, dtbOrder, SUB_NO_EMPTY);
				options.addAll(pantsOptions);
			}
			// 2PP (JACKET + PANTS + 2PANTS)の場合
			if (productItem.equals(ITEM_22) || productItemDisplaycode.equals(ITEM_22)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_02, dtbOrder, SUB_NO_01);
				options.addAll(jacketOptions);
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_02, CLASS_TYPE_05, dtbOrder, SUB_NO_01);
				options.addAll(pantsOptions);
				List<Option> pants2Options = getPants2Options(STYLE_NO_01, CLASS_TYPE_05, dtbOrder, SUB_NO_02);
				options.addAll(pants2Options);
			}
			// 3P (JACKET + PANTS + GILET)の場合
			if (productItem.equals(ITEM_31) || productItemDisplaycode.equals(ITEM_31)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_02, dtbOrder, SUB_NO_EMPTY);
				options.addAll(jacketOptions);
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_02, CLASS_TYPE_05, dtbOrder, SUB_NO_EMPTY);
				options.addAll(pantsOptions);
				List<Option> giletOptions = getGiletOptions(STYLE_NO_03, CLASS_TYPE_17, dtbOrder, SUB_NO_EMPTY);
				options.addAll(giletOptions);
			}
			// 3P2PP (JACKET + PANTS + GILET + 2PANTS)の場合
			if (productItem.equals(ITEM_32) || productItemDisplaycode.equals(ITEM_32)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_02, dtbOrder, SUB_NO_01);
				options.addAll(jacketOptions);
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_02, CLASS_TYPE_05, dtbOrder, SUB_NO_01);
				options.addAll(pantsOptions);
				List<Option> giletOptions = getGiletOptions(STYLE_NO_03, CLASS_TYPE_17, dtbOrder, SUB_NO_01);
				options.addAll(giletOptions);
				List<Option> pants2Options = getPants2Options(STYLE_NO_01, CLASS_TYPE_05, dtbOrder, SUB_NO_02);
				options.addAll(pants2Options);
			}

			order.setOptions(options);

			orderList.add(order);
		}

		Orders orders = new Orders();
		orders.setOrder(orderList);

		logger.info("送信文字列作成終了");
		return orders;
	}

	/**
	 * jacketOptionsを取得
	 * 
	 * @param String   style_no
	 * @param String   class_type
	 * @param DtbOrder dtbOrder
	 * @param String   subNo
	 * @return jacketOptions
	 */
	private List<Option> getJacketOptions(String style_no, String class_type, DtbOrder dtbOrder, String subNo) {
		Object[] args = {};
		List<Option> jacketOptions = new ArrayList<Option>();
		OptionJackeEnum[] optionJacketEnums = OptionJackeEnum.values();
		for (OptionJackeEnum optionJacketEnum : optionJacketEnums) {
//		for (MtbOptionEnum optionJacketEnum : optionJacketEnums) {
			try {
				Class<?> cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.DtbOrder");
				Method getCode = getMethod(cls, optionJacketEnum.getGetCode());

				String optionCode = (String) ReflectionUtils.invoke(getCode, dtbOrder, args);
				if (optionCode == null) {
					optionCode = "";
				}
				if (optionJacketEnum.getCode().equals(optionCode)) {
					Option option = new Option();
					option.setOrderdetailid(dtbOrder.getOrderId() + subNo);
					option.setStyleno(style_no);
					option.setClassType(class_type);
					option.setOption_type(optionJacketEnum.getOptionType());
					option.setOption_code(optionJacketEnum.getOptionCode());
					jacketOptions.add(option);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		// 商品情報_刺繍入れ 有り
		if (dtbOrder.getProductEmbroideryNecessity().equals("1")) {

			// 刺繍書体
			Option option_embroidery_font = new Option();
			option_embroidery_font.setOrderdetailid(dtbOrder.getOrderId() + subNo);
			option_embroidery_font.setStyleno(style_no);
			option_embroidery_font.setClassType(class_type);
			option_embroidery_font.setOption_type("S010234");
			if (("48（ブロック）").equals(dtbOrder.getProductEmbroideryFont())) {
				option_embroidery_font.setOption_code("S01023401");
			}
			if (("14（花文字）").equals(dtbOrder.getProductEmbroideryFont())) {
				option_embroidery_font.setOption_code("S01023402");
			}
			jacketOptions.add(option_embroidery_font);

			// 刺繍糸色
			Option option_embroidery_color = new Option();
			option_embroidery_color.setOrderdetailid(dtbOrder.getOrderId() + subNo);
			option_embroidery_color.setStyleno(style_no);
			option_embroidery_color.setClassType(class_type);
			option_embroidery_color.setOption_type("S010236");
			if (("110（金茶）").equals(dtbOrder.getProductEmbroideryThreadColor())) {
				option_embroidery_color.setOption_code("S01023601");
			}
			if (("401（白）").equals(dtbOrder.getProductEmbroideryThreadColor())) {
				option_embroidery_color.setOption_code("S01023602");
			}
			jacketOptions.add(option_embroidery_color);

			// 刺繍ネーム
			if (dtbOrder.getProductEmbroideryNm() == null) {
				dtbOrder.setProductEmbroideryNm("");
			}
			Option option_embroidery_nm = new Option();
			option_embroidery_nm.setOrderdetailid(dtbOrder.getOrderId() + subNo);
			option_embroidery_nm.setStyleno(style_no);
			option_embroidery_nm.setClassType(class_type);
			option_embroidery_nm.setOption_type("S010237");
			option_embroidery_nm.setOption_code(dtbOrder.getProductEmbroideryNm());
			jacketOptions.add(option_embroidery_nm);

		}
		return jacketOptions;
	}

	/**
	 * pantsOptionsを取得
	 * 
	 * @param String   style_no
	 * @param String   class_type
	 * @param DtbOrder dtbOrder
	 * @param String   subNo
	 * @return pantsOptions
	 */
	private List<Option> getPantsOptions(String style_no, String class_type, DtbOrder dtbOrder, String subNo) {
		Object[] args = {};
		List<Option> pantsOptions = new ArrayList<Option>();
		OptionPantsEnum[] optionPantsEnums = OptionPantsEnum.values();
		for (OptionPantsEnum optionPantsEnum : optionPantsEnums) {
//		for (MtbOptionEnum optionPantsEnum : optionPantsEnums) {
			try {
				Class<?> cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.DtbOrder");
				Method getCode = getMethod(cls, optionPantsEnum.getGetCode());

				String optionCode = (String) ReflectionUtils.invoke(getCode, dtbOrder, args);
				if (optionCode == null) {
					optionCode = "";
				}
				if (optionPantsEnum.getCode().equals(optionCode)) {
					Option option = new Option();
					option.setOrderdetailid(dtbOrder.getOrderId() + subNo);
					option.setStyleno(style_no);
					option.setClassType(class_type);
					option.setOption_type(optionPantsEnum.getOptionType());
					option.setOption_code(optionPantsEnum.getOptionCode());
					pantsOptions.add(option);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return pantsOptions;
	}

	/**
	 * giletOptionsを取得
	 * 
	 * @param String   style_no
	 * @param String   class_type
	 * @param DtbOrder dtbOrder
	 * @param String   subNo
	 * @return giletOptions
	 */
	private List<Option> getGiletOptions(String style_no, String class_type, DtbOrder dtbOrder, String subNo) {
		Object[] args = {};
		List<Option> giletOptions = new ArrayList<Option>();
		OptionGiletEnum[] optionGiletEnums = OptionGiletEnum.values();
		for (OptionGiletEnum optionGiletEnum : optionGiletEnums) {
//		for (MtbOptionEnum optionGiletEnum : optionGiletEnums) {
			try {
				Class<?> cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.DtbOrder");
				Method getCode = getMethod(cls, optionGiletEnum.getGetCode());

				String optionCode = (String) ReflectionUtils.invoke(getCode, dtbOrder, args);
				if (optionCode == null) {
					optionCode = "";
				}
				if (optionGiletEnum.getCode().equals(optionCode)) {
					Option option = new Option();
					option.setOrderdetailid(dtbOrder.getOrderId() + subNo);
					option.setStyleno(style_no);
					option.setClassType(class_type);
					option.setOption_type(optionGiletEnum.getOptionType());
					option.setOption_code(optionGiletEnum.getOptionCode());
					giletOptions.add(option);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return giletOptions;
	}

	/**
	 * pants2Optionsを取得
	 * 
	 * @param String   style_no
	 * @param String   class_type
	 * @param DtbOrder dtbOrder
	 * @param String   subNo
	 * @return pants2Options
	 */
	private List<Option> getPants2Options(String style_no, String class_type, DtbOrder dtbOrder, String subNo) {
		Object[] args = {};
		List<Option> pants2Options = new ArrayList<Option>();
		Option2PantsEnum[] option2PantsEnums = Option2PantsEnum.values();
		for (Option2PantsEnum option2PantsEnum : option2PantsEnums) {
//		for (MtbOptionEnum option2PantsEnum : option2PantsEnums) {
			try {
				Class<?> cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.DtbOrder");
				Method getCode = getMethod(cls, option2PantsEnum.getGetCode());

				String optionCode = (String) ReflectionUtils.invoke(getCode, dtbOrder, args);
				if (optionCode == null) {
					optionCode = "";
				}
				if (option2PantsEnum.getCode().equals(optionCode)) {
					Option option = new Option();
					option.setOrderdetailid(dtbOrder.getOrderId() + subNo);
					option.setStyleno(style_no);
					option.setClassType(class_type);
					option.setOption_type(option2PantsEnum.getOptionType());
					option.setOption_code(option2PantsEnum.getOptionCode());
					pants2Options.add(option);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return pants2Options;
	}

	/**
	 * クラスと列挙の方法名によって、方法を取得
	 * 
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	private Method getMethod(Class<?> clazz, String methodName) {
		Method[] methods = clazz.getMethods();
		Method result = null;
		for (Method method : methods) {

			if (method.getName().equals(methodName)) {
				result = method;
				break;
			}
		}
		return result;
	}

}
