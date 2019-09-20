package co.jp.aoyama.macchinetta.order;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
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
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.jp.aoyama.macchinetta.app.rest.api.consts.WebConst;
import co.jp.aoyama.macchinetta.app.rest.api.model.Fabric;
import co.jp.aoyama.macchinetta.app.rest.api.model.Lining;
import co.jp.aoyama.macchinetta.app.rest.api.model.Measurement;
import co.jp.aoyama.macchinetta.app.rest.api.model.Option;
import co.jp.aoyama.macchinetta.app.rest.api.model.Order;
import co.jp.aoyama.macchinetta.app.rest.api.model.OrderDetail;
import co.jp.aoyama.macchinetta.app.rest.api.model.Orders;
import co.jp.aoyama.macchinetta.app.rest.api.model.ReturnReceiveOrderShanghaiFuliangCo;
import co.jp.aoyama.macchinetta.app.rest.api.model.ReturnResultShanghaiFuliangCo;
import co.jp.aoyama.macchinetta.app.rest.api.util.AESEncrypt;
import co.jp.aoyama.macchinetta.app.rest.api.util.HttpUtil;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;
import co.jp.aoyama.macchinetta.domain.model.MtbErrorContent;
import co.jp.aoyama.macchinetta.domain.model.MtbLiningEnum;
import co.jp.aoyama.macchinetta.domain.model.MtbMeasurementEnum;
import co.jp.aoyama.macchinetta.domain.model.MtbOptionEnum;
import co.jp.aoyama.macchinetta.domain.model.MtbOrderDetailEnum;
import co.jp.aoyama.macchinetta.domain.service.errorcontent.MtbErrorContentService;
import co.jp.aoyama.macchinetta.domain.service.liningenum.MtbLiningEnumService;
import co.jp.aoyama.macchinetta.domain.service.measurementenum.MtbMeasurementEnumService;
import co.jp.aoyama.macchinetta.domain.service.optionenum.MtbOptionEnumService;
import co.jp.aoyama.macchinetta.domain.service.order.DtbOrderService;
import co.jp.aoyama.macchinetta.domain.service.orderdetailenum.MtbOrderDetailEnumService;

/**
 * 
 * @author liufeng
 *
 */
@Component
public class ReceiveOrderControllerShanghaiFuliangCo {

	@Inject
	DtbOrderService orderService;

	@Inject
	MtbOrderDetailEnumService mtbOrderDetailEnumService;

	@Inject
	MtbLiningEnumService mtbLiningEnumService;

	@Inject
	MtbMeasurementEnumService mtbMeasurementEnumService;

	@Inject
	MtbOptionEnumService mtbOptionEnumService;

	@Inject
	MtbErrorContentService mtbErrorContentService;

	@Inject
	RestTemplate restTemplate;

	@Value("${fuliang.api.url.GetAccessToken}")
	String tokenUrl;

	@Value("${fuliang.api.url.ReceiveOrder}")
	String receiveOrderUrl;

	@Value("${fuliang.api.url.AESDecrypt}")
	String aesDecryptUrl;

	@Value("${fuliang.api.appsecrets}")
	String appSecrets;

	@Value("${fuliang.api.accesstoken.appsecrets}")
	String accessTokenAppSecrets;

	@Value("${fuliang.api.accesstoken.token}")
	String accessTokenToken;

	@Value("${api.timeout.connect}")
	int connectTimeout;

	@Value("${api.timeout.read}")
	int readTimeout;

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(ReceiveOrderControllerShanghaiFuliangCo.class);

	/** JACKET */
	public static final String ITEM_JACKET = "02";
	/** PANTS */
	public static final String ITEM_PANTS = "03";
	/** GILET */
	public static final String ITEM_GILET = "04";
	/** COAT */
	public static final String ITEM_COAT = "06";
	/** 2P (JACKET + PANTS) */
	public static final String ITEM_2P = "21";
	/** 2PP (JACKET + PANTS + 2PANTS) */
	public static final String ITEM_2PP = "22";
	/** 3P (JACKET + PANTS + GILET) */
	public static final String ITEM_3P = "31";
	/** 3P2PP (JACKET + PANTS + GILET + 2PANTS) */
	public static final String ITEM_3P2PP = "32";

	/** STYLE_NO */
	public static final String STYLE_NO_01 = "01";
	public static final String STYLE_NO_02 = "02";
	public static final String STYLE_NO_03 = "03";
	public static final String STYLE_NO_04 = "04";

	/** SUB_NO */
	public static final String SUB_NO_EMPTY = "";
	public static final String SUB_NO_01 = "01";
	public static final String SUB_NO_02 = "02";
	public static final String SUB_NO_03 = "03";
	public static final String SUB_NO_04 = "04";

	/** CLASS_TYPE:JACKET */
	public static final String CLASS_TYPE_JACKET = "01";
	/** CLASS_TYPE:PANTS */
	public static final String CLASS_TYPE_PANTS = "02";
	/** CLASS_TYPE:GILET */
	public static final String CLASS_TYPE_GILET = "03";
	/** CLASS_TYPE:COAT */
	public static final String CLASS_TYPE_COAT = "05";

	/** 工場コード：上海服良 */
	public static final String FACTORY_CODE = "F00002";
	/** 注文パターン：カスタムオーダー */
	public static final String ORDER_PATTERN = "CO";

	/** 注文オブジェクトのパッケージ */
	public static final String ORDER_PACKAGE = "co.jp.aoyama.macchinetta.domain.model.DtbOrder";

	/** エラーコードマップ */
	private Map<String, String> errorCodeMap = null;
	/** ジャケット用列挙体 */
	List<MtbOptionEnum> optionJacketEnums = null;
	/** パンツ用列挙体 */
	List<MtbOptionEnum> optionPantsEnums = null;
	/** Gilet用列挙体 */
	List<MtbOptionEnum> optionGiletEnums = null;
	/** パンツ２用列挙体 */
	List<MtbOptionEnum> option2PantsEnums = null;
	/** Coat用列挙体 */
	List<MtbOptionEnum> optionCoatEnums = null;

	/**
	 * DB ステータス を変更
	 * 
	 * @return void
	 */
	public void changeDbStatus(List<DtbOrder> dtbOrders) {
		logger.info("ReceiveOrder:上海服良へCo注文データの送信処理開始");

		List<ReturnReceiveOrderShanghaiFuliangCo> messageList = getMsgJson(dtbOrders);
		if (null != messageList) {

			// ReceiveOrderの戻る値に対して、SuccessとFailがある、下記判断により、受注表の工場自動連携ステータスや工場ステータス設定する。
			if (messageList.size() == 1 && WebConst.RECEIVE_ORDER_SUCCESS.equals(messageList.get(0).getResult())) {
				logger.info("送信正常終了の更新処理開始");
				// ReceiveOrderの戻るはSuccessの場合、SuccessのResultは03100の場合、送信成功として、
				// 受注表で工場自動連携ステータスを「送信済み」に設定する
				orderService.receiveSuccess(dtbOrders);
				logger.info("送信正常終了の更新処理終了");
			} else if (messageList.size() == 1
					&& (WebConst.RECEIVE_ORDER_FAILED_TOKEN_FORMAT.equals(messageList.get(0).getResult())
							|| WebConst.RECEIVE_ORDER_FAILED_TOKEN_CHECK.equals(messageList.get(0).getResult())
							|| WebConst.RECEIVE_ORDER_FAILED_PARAM.equals(messageList.get(0).getResult()))) {
				logger.info("送信失敗の更新処理開始");
				// ReceiveOrderの戻るはFailの場合、FailのResultは0301、0302、0337の場合、すなわち、転送データタイプエラーがあるの場合、
				// 受注表で工場自動連携ステータスを「送信失敗データタイプエラー]に設定する。
				orderService.receiveException(dtbOrders);
				logger.info("送信失敗の更新処理終了");
			} else {
				logger.info("送信結果エラーありの更新処理開始");
				// ReceiveOrderの戻るはFailの場合、FailのResultがない、ordernoがあるの場合、すなわち、注文データエラーがあるの場合
				// エラーコードマップを作成する
				getErrorCodeInfo();

				orderService.receiveErrorShanghaiFuliangCo(messageList, dtbOrders, errorCodeMap);
				logger.info("送信結果エラーありの更新処理終了");
			}
		}
		logger.info("ReceiveOrder:上海服良へCo注文データの送信処理終了");
	}

	/**
	 * エラーコードマップを作成する
	 */
	private void getErrorCodeInfo() {
		logger.info("エラー情報取得処理開始");
		if (null == this.errorCodeMap) {
			List<MtbErrorContent> errorCodeInfoList = mtbErrorContentService.selectByFactoryPattern(FACTORY_CODE,
					ORDER_PATTERN);
			logger.info("エラー情報リスト:{}", JSON.toJSONString(errorCodeInfoList));

			this.errorCodeMap = new HashMap<String, String>(16);
			for (MtbErrorContent errorCodeInfo : errorCodeInfoList) {
				this.errorCodeMap.put(errorCodeInfo.getErrCode(), errorCodeInfo.getRemark());
			}
		}
		logger.info("エラー情報取得処理終了");
	}

	/**
	 * APIを伝送する
	 * 
	 * @return 注文情報リスト
	 */
	private List<ReturnReceiveOrderShanghaiFuliangCo> getMsgJson(List<DtbOrder> dtbOrders) {

		Orders orders = getOrders(dtbOrders);

		logger.info("送信処理開始");

		String resultString = "";
		Map<String, String> param = new HashMap<String, String>(1, 1);
		param.put("1", "1");
		try {
			resultString = new HttpUtil(connectTimeout, readTimeout).post(tokenUrl, param, null);
			logger.info("送信用Token取得結果文字列:{}", resultString);

			resultString = getVaildResult(resultString);

			logger.info("送信用Token取得結果文字列(無効内容抜き):{}", resultString);
		} catch (SocketTimeoutException e) {
			e.getStackTrace();
			logger.info("送信用Token取得タイムアウト:{}", e.getMessage());
			orderService.receiveTimeout(dtbOrders);
			return null;
		} catch (Exception e) {
			e.getStackTrace();
			logger.info("送信Token取得異常:{}", e.getMessage());
			return null;
		}

		Gson gson = new Gson();

		ReturnResultShanghaiFuliangCo returnResult = gson.fromJson(resultString,
				new TypeToken<ReturnResultShanghaiFuliangCo>() {
				}.getType());

		if (!WebConst.GET_ACCESS_TOKEN_SUCCESS.equals(returnResult.getResult())) {
			logger.info("送信用Token取得失敗:" + returnResult.getResult());
			return null;
		}

		String accessToken = returnResult.getMsgid();
		logger.info("送信用Token(復号前):" + accessToken);

		param = new HashMap<String, String>(3, 1);
		param.put("encryptStr", accessToken);
		param.put("access_token", accessTokenToken);
		param.put("appsecret", accessTokenAppSecrets);
		logger.info("送信用Token復号パラメータ:{}", param);

		try {
			resultString = new HttpUtil(connectTimeout, readTimeout).post(aesDecryptUrl, param, null);
			logger.info("送信用Token復号結果文字列:{}", resultString);

			resultString = getVaildResult(resultString);

			logger.info("送信用Token復号結果文字列(無効内容抜き):{}", resultString);
		} catch (SocketTimeoutException e) {
			e.getStackTrace();
			logger.info("送信用Token復号タイムアウト:{}", e.getMessage());
			orderService.receiveTimeout(dtbOrders);
			return null;
		} catch (Exception e) {
			e.getStackTrace();
			logger.info("送信Token復号異常:{}", e.getMessage());
			return null;
		}

		gson = new Gson();

		returnResult = gson.fromJson(resultString, new TypeToken<ReturnResultShanghaiFuliangCo>() {
		}.getType());

		if (WebConst.AES_DECRYPT_FAILED_TOKEN.equals(returnResult.getResult())) {
			logger.info("送信用Token復号失敗:" + returnResult.getResult());
			return null;
		} else if (WebConst.AES_DECRYPT_SUCCESS.equals(returnResult.getResult())) {
			accessToken = returnResult.getMsgid();
			logger.info("送信用Token(復号後):" + accessToken);
		} else {
			logger.info("送信用Token復号失敗(その他原因):" + returnResult.getResult());
			return null;
		}

		JSONObject orderJson = new JSONObject();
		orderJson.put("Action", "CreateOrder");
		orderJson.put("orders", orders);
		String orderString = new Gson().toJson(orderJson);

		orderString = orderString.replace("class_item", "classNo");
		orderString = orderString.replace("classType", "classNo");

		logger.info("暗号化前の送信文字列:{}", orderString);
//		orderString = "{\"Action\":\"CreateOrder\",\"orders\":{\"Order\":[{\"brand\":\"QS\",\"mainorder\":\"1909040001\",\"shop\":\"QS API Shop\",\"cdate\":\"2019-09-02\",\"deliver_date\":\"2019-10-13\",\"import_time\":\"2019-09-02 13:06:48\",\"remark\":\"测试数据主信息\",\"customer\":\"Dean Wilson \",\"Weight\":80,\"Gender\":\"1\",\"receiver\":\"John Smith\",\"country\":\"Japan \",\"province\":\"Tokyo\",\"address\":\"Benxiang 7-3-1,wenjing district,Tokyo,Japan\",\"postcode\":\"113-8654\",\"contactnumber\":\"Yamamoto lsoroku\",\"front\":\"\",\"back\":\"\",\"sideLeft\":\"\",\"sideRight\":\"\",\"AdvanceDelivery\":\"D0201\",\"DelayDelivery\":\"D0301\",\"ClothingTypes\":\"S0201\",\"OrderDetails\":[{\"orderdetailid\":\"190904000101\",\"order\":\"1909040001\",\"combination\":\"S01010102\",\"mode\":\"01\",\"fabric\":[{\"sku\":\"R717WA\",\"styleno\":\"01\",\"mode\":\"01\",\"Vendor\":\"Gladson\",\"Description\":\"test\",\"Composition\":\"S021602\",\"Length\":\"3.5M\"}],\"lining\":[{\"sku\":\"TR330\",\"styleno\":\"01\",\"mode\":\"01\",\"Vendor\":\"\",\"Description\":\"\",\"Composition\":\"\",\"Length\":\"\"}],\"cl_flag\":\"0\",\"styleno\":\"01\",\"ptype\":\"01\",\"classNo\":\"01\",\"tryon\":\"5:A\",\"fit\":\"Regular\",\"remark\":\"测试数据上衣\",\"vendor\":\"Datian\",\"previous_order\":\"8902675\",\"provious_vendor\":\"Datian\",\"order_urgent\":\"0\",\"urgent_days\":\"0\",\"mark_type\":\"\"},{\"orderdetailid\":\"190904000102\",\"order\":\"1909040001\",\"combination\":\"S01010102\",\"mode\":\"01\",\"fabric\":[{\"sku\":\"TC111W\",\"styleno\":\"01\",\"mode\":\"02\",\"Vendor\":\"Gladson\",\"Description\":\"test\",\"Composition\":\"S021602\",\"Length\":\"3.5M\"}],\"lining\":[{\"sku\":\"TR330\",\"styleno\":\"01\",\"mode\":\"01\",\"Vendor\":\"\",\"Description\":\"\",\"Composition\":\"\",\"Length\":\"\"}],\"cl_flag\":\"0\",\"styleno\":\"02\",\"ptype\":\"01\",\"classNo\":\"02\",\"tryon\":\"5:A\",\"fit\":\"Regular\",\"remark\":\"测试数据裤子\",\"vendor\":\"Datian\",\"previous_order\":\"8902675\",\"provious_vendor\":\"Datian\",\"order_urgent\":\"0\",\"urgent_days\":\"0\",\"mark_type\":\"\"},{\"orderdetailid\":\"190904000103\",\"order\":\"1909040001\",\"combination\":\"S01010102\",\"mode\":\"01\",\"fabric\":[{\"sku\":\"TROC012\",\"styleno\":\"01\",\"mode\":\"01\",\"Vendor\":\"\",\"Description\":\"\",\"Composition\":\"\",\"Length\":\"\"}],\"lining\":[{\"sku\":\"TR330\",\"styleno\":\"01\",\"mode\":\"01\",\"Vendor\":\"\",\"Description\":\"\",\"Composition\":\"\",\"Length\":\"\"}],\"cl_flag\":\"0\",\"styleno\":\"03\",\"ptype\":\"01\",\"classNo\":\"03\",\"tryon\":\"5:A\",\"fit\":\"Regular\",\"remark\":\"测试数据马夹\",\"vendor\":\"Datian\",\"previous_order\":\"84915161\",\"provious_vendor\":\"Datian\",\"order_urgent\":\"0\",\"urgent_days\":\"0\",\"mark_type\":\"\"}],\"Measurements\":[{\"orderdetailid\":\"190904000101\",\"styleno\":\"01\",\"classNo\":\"01\",\"item_code\":\"YC\",\"tryon_adjustment\":\"0.1\",\"value\":\"101\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"02\",\"classNo\":\"01\",\"item_code\":\"XW\",\"tryon_adjustment\":\"0.2\",\"value\":\"102\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"03\",\"classNo\":\"01\",\"item_code\":\"YW\",\"tryon_adjustment\":\"0.3\",\"value\":\"103\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"04\",\"classNo\":\"01\",\"item_code\":\"JK\",\"tryon_adjustment\":\"0.4\",\"value\":\"104\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"05\",\"classNo\":\"01\",\"item_code\":\"XC\",\"tryon_adjustment\":\"0.5\",\"value\":\"105\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"06\",\"classNo\":\"01\",\"item_code\":\"XK\",\"tryon_adjustment\":\"0.6\",\"value\":\"106\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"07\",\"classNo\":\"01\",\"item_code\":\"NJ\",\"tryon_adjustment\":\"0.7\",\"value\":\"107\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"08\",\"classNo\":\"01\",\"item_code\":\"BK\",\"tryon_adjustment\":\"0.8\",\"value\":\"108\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"09\",\"classNo\":\"01\",\"item_code\":\"XF\",\"tryon_adjustment\":\"0.9\",\"value\":\"109\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"10\",\"classNo\":\"01\",\"item_code\":\"JX\",\"tryon_adjustment\":\"1.0\",\"value\":\"110\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"01\",\"classNo\":\"02\",\"item_code\":\"YW\",\"tryon_adjustment\":\"2.1\",\"value\":\"201\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"02\",\"classNo\":\"02\",\"item_code\":\"TW\",\"tryon_adjustment\":\"2.2\",\"value\":\"202\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"03\",\"classNo\":\"02\",\"item_code\":\"GS\",\"tryon_adjustment\":\"2.3\",\"value\":\"203\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"04\",\"classNo\":\"02\",\"item_code\":\"HD\",\"tryon_adjustment\":\"2.4\",\"value\":\"204\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"05\",\"classNo\":\"02\",\"item_code\":\"ZD\",\"tryon_adjustment\":\"2.5\",\"value\":\"205\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"06\",\"classNo\":\"02\",\"item_code\":\"JKK\",\"tryon_adjustment\":\"2.6\",\"value\":\"206\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"07\",\"classNo\":\"02\",\"item_code\":\"GX\",\"tryon_adjustment\":\"2.7\",\"value\":\"207\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"08\",\"classNo\":\"02\",\"item_code\":\"FBK\",\"tryon_adjustment\":\"2.8\",\"value\":\"208\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"01\",\"classNo\":\"03\",\"item_code\":\"YC\",\"tryon_adjustment\":\"3.1\",\"value\":\"301\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"02\",\"classNo\":\"03\",\"item_code\":\"XW\",\"tryon_adjustment\":\"3.2\",\"value\":\"302\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"03\",\"classNo\":\"03\",\"item_code\":\"YW\",\"tryon_adjustment\":\"3.3\",\"value\":\"303\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"04\",\"classNo\":\"03\",\"item_code\":\"JK\",\"tryon_adjustment\":\"3.4\",\"value\":\"304\"}],\"Options\":[{\"orderdetailid\":\"190904000101\",\"styleno\":\"01\",\"classNo\":\"01\",\"option_type\":\"S010224\",\"option_code\":\"S01022402\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"02\",\"classNo\":\"01\",\"option_type\":\"S010244\",\"option_code\":\"S01024401\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"03\",\"classNo\":\"01\",\"option_type\":\"S010204\",\"option_code\":\"S01020402\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"04\",\"classNo\":\"01\",\"option_type\":\"S010206\",\"option_code\":\"S01020602\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"05\",\"classNo\":\"01\",\"option_type\":\"S010207\",\"option_code\":\"S01020702\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"06\",\"classNo\":\"01\",\"option_type\":\"S010208\",\"option_code\":\"S01020801\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"07\",\"classNo\":\"01\",\"option_type\":\"S010212\",\"option_code\":\"S01021201\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"08\",\"classNo\":\"01\",\"option_type\":\"S010213\",\"option_code\":\"S01021302\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"09\",\"classNo\":\"01\",\"option_type\":\"S010243\",\"option_code\":\"S01024302\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"10\",\"classNo\":\"01\",\"option_type\":\"S010215\",\"option_code\":\"S01021501\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"11\",\"classNo\":\"01\",\"option_type\":\"S010216\",\"option_code\":\"S01021601\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"12\",\"classNo\":\"01\",\"option_type\":\"S010217\",\"option_code\":\"S01021701\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"13\",\"classNo\":\"01\",\"option_type\":\"S010240\",\"option_code\":\"QSXL-004\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"14\",\"classNo\":\"01\",\"option_type\":\"S010242\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000101\",\"styleno\":\"15\",\"classNo\":\"01\",\"option_type\":\"S010225\",\"option_code\":\"S01022501\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"01\",\"classNo\":\"02\",\"option_type\":\"S010233\",\"option_code\":\"S01023302\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"02\",\"classNo\":\"02\",\"option_type\":\"S010237\",\"option_code\":\"555555\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"03\",\"classNo\":\"02\",\"option_type\":\"S010518\",\"option_code\":\"S01051802\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"04\",\"classNo\":\"02\",\"option_type\":\"S010529\",\"option_code\":\"S01052901\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"05\",\"classNo\":\"02\",\"option_type\":\"S010502\",\"option_code\":\"S01050201\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"06\",\"classNo\":\"02\",\"option_type\":\"S010505\",\"option_code\":\"S01050502\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"07\",\"classNo\":\"02\",\"option_type\":\"S010510\",\"option_code\":\"S01051001\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"08\",\"classNo\":\"02\",\"option_type\":\"S010511\",\"option_code\":\"S01051108\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"09\",\"classNo\":\"02\",\"option_type\":\"S010512\",\"option_code\":\"S01051201\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"10\",\"classNo\":\"02\",\"option_type\":\"S010513\",\"option_code\":\"S01051301\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"11\",\"classNo\":\"02\",\"option_type\":\"S010521\",\"option_code\":\"S01052102\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"12\",\"classNo\":\"02\",\"option_type\":\"S010524\",\"option_code\":\"S01052402\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"13\",\"classNo\":\"02\",\"option_type\":\"S010526\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"14\",\"classNo\":\"02\",\"option_type\":\"S011710\",\"option_code\":\"S01171002\"},{\"orderdetailid\":\"190904000102\",\"styleno\":\"15\",\"classNo\":\"02\",\"option_type\":\"S011718\",\"option_code\":\"S01171801\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"01\",\"classNo\":\"03\",\"option_type\":\"S011704\",\"option_code\":\"S01170402\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"02\",\"classNo\":\"03\",\"option_type\":\"S011715\",\"option_code\":\"QSL-003\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"03\",\"classNo\":\"03\",\"option_type\":\"S011716\",\"option_code\":\"QSL-003\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"04\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"05\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"06\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"07\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"08\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"09\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"10\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"11\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"12\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"13\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"14\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"},{\"orderdetailid\":\"190904000103\",\"styleno\":\"15\",\"classNo\":\"03\",\"option_type\":\"S011717\",\"option_code\":\"QSB-001\"}]}]}}";
		String encryptOrder = AESEncrypt.encrypt2(orderString, appSecrets, accessToken);

		logger.info("暗号化後の送信文字列:{}", encryptOrder);

		param = new HashMap<String, String>(3, 1);
		param.put("EncryptOrders", encryptOrder);
		param.put("AccessToken", accessToken);
		param.put("appsecret", appSecrets);
		param.put("Brand", "QS");
		logger.info("送信パラメータ:{}", param);

		try {
			resultString = new HttpUtil(connectTimeout, readTimeout).post(receiveOrderUrl, param, null);

			logger.info("上海服良CO送信結果文字列:{}", resultString);
			resultString = getVaildResult(resultString);

			if (null != resultString && 0 < resultString.length() && !resultString.substring(0, 1).equals("[")) {
				resultString = "[" + resultString + "]";
			}

			logger.info("上海服良CO送信結果文字列(無効内容抜き):{}", resultString);
		} catch (SocketTimeoutException e) {
			e.getStackTrace();
			logger.info("上海服良CO送信タイムアウト:{}", e.getMessage());
			orderService.receiveTimeout(dtbOrders);
			return null;
		} catch (Exception e) {
			e.getStackTrace();
			logger.info("上海服良CO送信結果異常:{}", e.getMessage());
			return null;
		}

		gson = new Gson();

		List<ReturnReceiveOrderShanghaiFuliangCo> messageList = gson.fromJson(resultString,
				new TypeToken<List<ReturnReceiveOrderShanghaiFuliangCo>>() {
				}.getType());

		logger.info("送信結果リスト:{}", JSON.toJSONString(messageList));

		logger.info("送信処理終了");
		return messageList;
	}

	/**
	 * 送信結果文字列から、有効内容を取得する
	 * 
	 * @param result 送信結果文字列
	 * @return 有効内容
	 */
	private String getVaildResult(String result) {
		result = result.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
		result = result.replace("<string xmlns=\"http://fuliang.org/\">", "");
		result = result.replace("</string>", "");
		return result;
	}

	/**
	 * 注文APIを取得
	 * 
	 * @return 注文情報リスト
	 */
	private Orders getOrders(List<DtbOrder> dtbOrders) {
		logger.info("送信文字列作成開始");

		List<Order> orderList = new ArrayList<Order>();
		List<MtbOrderDetailEnum> orderDetailEnums = mtbOrderDetailEnumService.selectByFactoryPattern(FACTORY_CODE,
				ORDER_PATTERN);
		List<MtbLiningEnum> liningEnums = mtbLiningEnumService.selectByFactoryPattern(FACTORY_CODE, ORDER_PATTERN);
		List<MtbMeasurementEnum> measurementEnums = mtbMeasurementEnumService.selectByFactoryPattern(FACTORY_CODE,
				ORDER_PATTERN);
		optionJacketEnums = mtbOptionEnumService.selectByTypeFactoryPattern("jacket", FACTORY_CODE, ORDER_PATTERN);
		optionPantsEnums = mtbOptionEnumService.selectByTypeFactoryPattern("pants", FACTORY_CODE, ORDER_PATTERN);
		optionGiletEnums = mtbOptionEnumService.selectByTypeFactoryPattern("gilet", FACTORY_CODE, ORDER_PATTERN);
		option2PantsEnums = mtbOptionEnumService.selectByTypeFactoryPattern("pants2", FACTORY_CODE, ORDER_PATTERN);
		optionCoatEnums = mtbOptionEnumService.selectByTypeFactoryPattern("coat", FACTORY_CODE, ORDER_PATTERN);

		Object[] args = {};
		Date nowDate = new Date();
		SimpleDateFormat formatter_ymd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter_ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Order order = null;
		OrderDetail orderDetail = null;
		Lining lining = null;
		for (DtbOrder dtbOrder : dtbOrders) {
			order = new Order();

			// orderその他
			order.setBrand("QS");
			order.setMainorder(dtbOrder.getOrderId());
			logger.info("送信注文ID:{}", dtbOrder.getOrderId());

			order.setShop(dtbOrder.getStoreNm());

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
			order.setWeight(0);
			order.setGender("1");
			order.setReceiver("");//
			order.setCountry("");
			order.setProvince("");
			order.setAddress("");
			order.setPostcode("");
			order.setContactnumber("");
			order.setFront("");
			order.setBack("");
			order.setSideLeft("");
			order.setSideRight("");

			String advanceDelivery = "";
			if ("9001202".equals(dtbOrder.getCustIsDeliverShortning())) {
				// 納期短縮 有り
				advanceDelivery = "D0202";
			} else if ("9001201".equals(dtbOrder.getCustIsDeliverShortning())) {
				// 納期短縮 無し
				advanceDelivery = "D0201";
			}
			order.setAdvanceDelivery(advanceDelivery);

			String delayDelivery = "";
			if ("9001302".equals(dtbOrder.getCustIsEarlyDiscount())) {
				// 早割 有り
				delayDelivery = "D0302";
			} else if ("9001301".equals(dtbOrder.getCustIsEarlyDiscount())) {
				// 早割 無し
				delayDelivery = "D0301";
			}
			order.setDelayDelivery(delayDelivery);

			String clothingTypes = "";
			if ("9000101".equals(dtbOrder.getProductCategory())) {
				// 標準、SP
				clothingTypes = "S0201";
			} else if ("9000102".equals(dtbOrder.getProductCategory())) {
				// タキシード
				clothingTypes = "S0202";
			} else if ("9000103".equals(dtbOrder.getProductCategory())) {
				// ウォッシャブル
				clothingTypes = "S0203";
			}
			order.setClothingTypes(clothingTypes);

			// OrderDetails
			List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			String productItem = dtbOrder.getProductItem();
			String productItemDisplaycode = dtbOrder.getProductItemDisplaycode();

			for (MtbOrderDetailEnum orderDetailEnum : orderDetailEnums) {
				orderDetail = new OrderDetail();
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
					orderDetail.setMode("01");
					orderDetail.setStyleno(orderDetailEnum.getStyleNo());
					orderDetail.setClass_item(orderDetailEnum.getClassType());
					// Fabric
					List<Fabric> fabrics = new ArrayList<Fabric>();

					Fabric fabric = new Fabric();
					fabric.setSku(dtbOrder.getProductFabricNo());
					fabric.setStyleno("01");
					fabric.setMode("01");
					fabric.setVendor("");
					fabric.setDescription("");
					fabric.setComposition("");
					fabric.setLength("");
					fabrics.add(fabric);

					orderDetail.setFabric(fabrics);

					// Lining
					List<Lining> linings = new ArrayList<Lining>();

					for (MtbLiningEnum liningEnum : liningEnums) {
						if (liningEnum.getJkInnerBodyClothCd().equals(dtbOrder.getJkInnerBodyClothCd())
								&& orderDetail.getClass_item().equals(CLASS_TYPE_JACKET)) {
							lining = new Lining();
							lining.setSku(liningEnum.getSku());
							lining.setStyleno("01");
							lining.setMode(liningEnum.getMode());
							lining.setVendor(liningEnum.getVendor());
							lining.setDescription(liningEnum.getDescription());
							lining.setComposition(liningEnum.getComposition());
							lining.setLength(liningEnum.getLength());
							linings.add(lining);
						}
					}

					orderDetail.setLining(linings);
					orderDetail.setCl_flag("0");
					orderDetail.setPtype("01");

					try {
						Class<?> cls = Class.forName(ORDER_PACKAGE);
						String drop = "";
						Method getSize = getMethod(cls, orderDetailEnum.getGetSize());
						String size = (String) ReflectionUtils.invoke(getSize, dtbOrder, args);
						// COAT以外の場合
						if (!productItem.equals(ITEM_COAT) && !productItemDisplaycode.equals(ITEM_COAT)) {
							Method getDrop = getMethod(cls, orderDetailEnum.getGetDrop());
							drop = (String) ReflectionUtils.invoke(getDrop, dtbOrder, args);
							drop = drop.substring(0, drop.indexOf("("));
							size = size.substring(0, size.indexOf("("));
						}
						if (size == null || size.equals("")) {
							orderDetail.setTryon("");
						} else {
							orderDetail.setTryon(size + ":" + drop);
						}
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("体型号数取得異常:" + e.toString());
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
			Measurement measurement = null;
			for (MtbMeasurementEnum measurementEnum : measurementEnums) {
				if (productItem.equals(measurementEnum.getItem())
						|| productItemDisplaycode.equals(measurementEnum.getItem())) {
					try {
						Class<?> cls = Class.forName(ORDER_PACKAGE);
						Method getGet_gross = getMethod(cls, measurementEnum.getGetGross());
						BigDecimal grossValue = (BigDecimal) ReflectionUtils.invoke(getGet_gross, dtbOrder, args);
						if (grossValue != null) {
							measurement = new Measurement();

							measurement.setOrderdetailid(dtbOrder.getOrderId() + measurementEnum.getSubNo());
							measurement.setStyleno(measurementEnum.getStyleNo());
							measurement.setClassType(measurementEnum.getClassType());
							measurement.setItem_code(measurementEnum.getItemCode());
							measurement.setTryon_adjustment(grossValue.toPlainString());
							measurement.setValue("0");
							measurements.add(measurement);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						logger.error("補正取得異常:" + e.toString());
					}
				}
			}
			order.setMeasurements(measurements);

			// Options
			List<Option> options = new ArrayList<Option>();
			// JACKETの場合
			if (productItem.equals(ITEM_JACKET) || productItemDisplaycode.equals(ITEM_JACKET)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_JACKET, dtbOrder, SUB_NO_01);
				options.addAll(jacketOptions);
			}
			// PANTSの場合
			if (productItem.equals(ITEM_PANTS) || productItemDisplaycode.equals(ITEM_PANTS)) {
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_01, CLASS_TYPE_PANTS, dtbOrder, SUB_NO_01);
				options.addAll(pantsOptions);
			}
			// GILETの場合
			if (productItem.equals(ITEM_GILET) || productItemDisplaycode.equals(ITEM_GILET)) {
				List<Option> giletOptions = getGiletOptions(STYLE_NO_01, CLASS_TYPE_GILET, dtbOrder, SUB_NO_01);
				options.addAll(giletOptions);
			}
			// COATの場合
			if (productItem.equals(ITEM_COAT) || productItemDisplaycode.equals(ITEM_COAT)) {
				List<Option> coatOptions = getCoatOptions(STYLE_NO_01, CLASS_TYPE_COAT, dtbOrder, SUB_NO_01);
				options.addAll(coatOptions);
			}
			// 2P (JACKET + PANTS)の場合
			if (productItem.equals(ITEM_2P) || productItemDisplaycode.equals(ITEM_2P)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_JACKET, dtbOrder, SUB_NO_01);
				options.addAll(jacketOptions);
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_02, CLASS_TYPE_PANTS, dtbOrder, SUB_NO_02);
				options.addAll(pantsOptions);
			}
			// 2PP (JACKET + PANTS + 2PANTS)の場合
			if (productItem.equals(ITEM_2PP) || productItemDisplaycode.equals(ITEM_2PP)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_JACKET, dtbOrder, SUB_NO_01);
				options.addAll(jacketOptions);
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_02, CLASS_TYPE_PANTS, dtbOrder, SUB_NO_02);
				options.addAll(pantsOptions);
				List<Option> pants2Options = getPants2Options(STYLE_NO_03, CLASS_TYPE_PANTS, dtbOrder, SUB_NO_03);
				options.addAll(pants2Options);
			}
			// 3P (JACKET + PANTS + GILET)の場合
			if (productItem.equals(ITEM_3P) || productItemDisplaycode.equals(ITEM_3P)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_JACKET, dtbOrder, SUB_NO_01);
				options.addAll(jacketOptions);
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_02, CLASS_TYPE_PANTS, dtbOrder, SUB_NO_02);
				options.addAll(pantsOptions);
				List<Option> giletOptions = getGiletOptions(STYLE_NO_03, CLASS_TYPE_GILET, dtbOrder, SUB_NO_03);
				options.addAll(giletOptions);
			}
			// 3P2PP (JACKET + PANTS + GILET + 2PANTS)の場合
			if (productItem.equals(ITEM_3P2PP) || productItemDisplaycode.equals(ITEM_3P2PP)) {
				List<Option> jacketOptions = getJacketOptions(STYLE_NO_01, CLASS_TYPE_JACKET, dtbOrder, SUB_NO_01);
				options.addAll(jacketOptions);
				List<Option> pantsOptions = getPantsOptions(STYLE_NO_02, CLASS_TYPE_PANTS, dtbOrder, SUB_NO_02);
				options.addAll(pantsOptions);
				List<Option> giletOptions = getGiletOptions(STYLE_NO_03, CLASS_TYPE_GILET, dtbOrder, SUB_NO_03);
				options.addAll(giletOptions);
				List<Option> pants2Options = getPants2Options(STYLE_NO_04, CLASS_TYPE_PANTS, dtbOrder, SUB_NO_04);
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
		Option option = null;
		for (MtbOptionEnum optionJacketEnum : optionJacketEnums) {
			try {
				Class<?> cls = Class.forName(ORDER_PACKAGE);
				Method getCode = getMethod(cls, optionJacketEnum.getGetCode());

				String optionCode = String.valueOf(ReflectionUtils.invoke(getCode, dtbOrder, args));
				if (optionCode == null) {
					optionCode = "";
				}
				if (optionJacketEnum.getCode().equals(optionCode)
						|| isExistInArray(optionCode, optionJacketEnum.getCode())) {
					option = new Option();
					option.setOrderdetailid(dtbOrder.getOrderId() + subNo);
					option.setStyleno(style_no);
					option.setClassType(class_type);
					option.setOption_type(optionJacketEnum.getOptionType());
					option.setOption_code(optionJacketEnum.getOptionCode());
					jacketOptions.add(option);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("jacketOptions取得異常:" + e.toString());
			}
		}
		// 商品情報_刺繍入れ 有り
		if (dtbOrder.getProductEmbroideryNecessity().equals("1")) {
//
//			// 刺繍書体
//			Option option_embroidery_font = new Option();
//			option_embroidery_font.setOrderdetailid(dtbOrder.getOrderId() + subNo);
//			option_embroidery_font.setStyleno(style_no);
//			option_embroidery_font.setClassType(class_type);
//			option_embroidery_font.setOption_type("S010234");
//			if (("48（ブロック）").equals(dtbOrder.getProductEmbroideryFont())) {
//				option_embroidery_font.setOption_code("S01023401");
//			}
//			if (("14（花文字）").equals(dtbOrder.getProductEmbroideryFont())) {
//				option_embroidery_font.setOption_code("S01023402");
//			}
//			jacketOptions.add(option_embroidery_font);
//
//			// 刺繍糸色
//			Option option_embroidery_color = new Option();
//			option_embroidery_color.setOrderdetailid(dtbOrder.getOrderId() + subNo);
//			option_embroidery_color.setStyleno(style_no);
//			option_embroidery_color.setClassType(class_type);
//			option_embroidery_color.setOption_type("S010236");
//			if (("110（金茶）").equals(dtbOrder.getProductEmbroideryThreadColor())) {
//				option_embroidery_color.setOption_code("S01023601");
//			}
//			if (("401（白）").equals(dtbOrder.getProductEmbroideryThreadColor())) {
//				option_embroidery_color.setOption_code("S01023602");
//			}
//			jacketOptions.add(option_embroidery_color);

			// 刺繍ネーム
			if (dtbOrder.getProductEmbroideryNm() == null) {
				dtbOrder.setProductEmbroideryNm("");
			}
			Option option_embroidery_nm = new Option();
			option_embroidery_nm.setOrderdetailid(dtbOrder.getOrderId() + subNo);
			option_embroidery_nm.setStyleno(style_no);
			option_embroidery_nm.setClassType(class_type);
			option_embroidery_nm.setOption_type("J48");
			option_embroidery_nm.setOption_code(dtbOrder.getProductEmbroideryNm());
			jacketOptions.add(option_embroidery_nm);

		}
		return jacketOptions;
	}

	/**
	 * DBで格納したコード文字列のなかで、列挙体コードが存在するかどうかどことの判断
	 * 
	 * @param arrayString DBで格納したコード文字列
	 * @param enumCode    列挙体コード
	 * @return true:存在;false:存在しない
	 */
	private boolean isExistInArray(String arrayString, String enumCode) {
		boolean isExistInArray = false;

		String[] codeArray = arrayString.split(",");

		if (1 < codeArray.length) {
			for (String code : codeArray) {
				if (enumCode.equals(code)) {
					isExistInArray = true;
					break;
				}
			}
		}

		return isExistInArray;
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
		Option option = null;
		for (MtbOptionEnum optionPantsEnum : optionPantsEnums) {
			try {
				Class<?> cls = Class.forName(ORDER_PACKAGE);
				Method getCode = getMethod(cls, optionPantsEnum.getGetCode());

				String optionCode = String.valueOf(ReflectionUtils.invoke(getCode, dtbOrder, args));
				if (optionCode == null) {
					optionCode = "";
				}
				if (optionPantsEnum.getCode().equals(optionCode)
						|| isExistInArray(optionCode, optionPantsEnum.getCode())) {
					option = new Option();
					option.setOrderdetailid(dtbOrder.getOrderId() + subNo);
					option.setStyleno(style_no);
					option.setClassType(class_type);
					option.setOption_type(optionPantsEnum.getOptionType());
					option.setOption_code(optionPantsEnum.getOptionCode());
					pantsOptions.add(option);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error("pantsOptions取得異常:" + e.toString());
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
		Option option = null;
		for (MtbOptionEnum optionGiletEnum : optionGiletEnums) {
			try {
				Class<?> cls = Class.forName(ORDER_PACKAGE);
				Method getCode = getMethod(cls, optionGiletEnum.getGetCode());

				String optionCode = String.valueOf(ReflectionUtils.invoke(getCode, dtbOrder, args));
				if (optionCode == null) {
					optionCode = "";
				}
				if (optionGiletEnum.getCode().equals(optionCode)
						|| isExistInArray(optionCode, optionGiletEnum.getCode())) {
					option = new Option();
					option.setOrderdetailid(dtbOrder.getOrderId() + subNo);
					option.setStyleno(style_no);
					option.setClassType(class_type);
					option.setOption_type(optionGiletEnum.getOptionType());
					option.setOption_code(optionGiletEnum.getOptionCode());
					giletOptions.add(option);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error("giletOptions取得異常:" + e.toString());
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
		Option option = null;
		for (MtbOptionEnum option2PantsEnum : option2PantsEnums) {
			try {
				Class<?> cls = Class.forName(ORDER_PACKAGE);
				Method getCode = getMethod(cls, option2PantsEnum.getGetCode());

				String optionCode = String.valueOf(ReflectionUtils.invoke(getCode, dtbOrder, args));
				if (optionCode == null) {
					optionCode = "";
				}
				if (option2PantsEnum.getCode().equals(optionCode)
						|| isExistInArray(optionCode, option2PantsEnum.getCode())) {
					option = new Option();
					option.setOrderdetailid(dtbOrder.getOrderId() + subNo);
					option.setStyleno(style_no);
					option.setClassType(class_type);
					option.setOption_type(option2PantsEnum.getOptionType());
					option.setOption_code(option2PantsEnum.getOptionCode());
					pants2Options.add(option);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error("pants2Options取得異常:" + e.toString());
			}
		}
		return pants2Options;
	}

	/**
	 * coatOptionsを取得
	 * 
	 * @param String   style_no
	 * @param String   class_type
	 * @param DtbOrder dtbOrder
	 * @param String   subNo
	 * @return giletOptions
	 */
	private List<Option> getCoatOptions(String style_no, String class_type, DtbOrder dtbOrder, String subNo) {
		Object[] args = {};
		List<Option> coatOptions = new ArrayList<Option>();
		Option option = null;
		for (MtbOptionEnum optionCoatEnum : optionCoatEnums) {
			try {
				Class<?> cls = Class.forName(ORDER_PACKAGE);
				Method getCode = getMethod(cls, optionCoatEnum.getGetCode());

				String optionCode = String.valueOf(ReflectionUtils.invoke(getCode, dtbOrder, args));
				if (optionCode == null) {
					optionCode = "";
				}
				if (optionCoatEnum.getCode().equals(optionCode)
						|| isExistInArray(optionCode, optionCoatEnum.getCode())) {
					option = new Option();
					option.setOrderdetailid(dtbOrder.getOrderId() + subNo);
					option.setStyleno(style_no);
					option.setClassType(class_type);
					option.setOption_type(optionCoatEnum.getOptionType());
					option.setOption_code(optionCoatEnum.getOptionCode());
					coatOptions.add(option);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error("coatOptions取得異常:" + e.toString());
			}
		}
		// 商品情報_刺繍入れ 有り
		if (dtbOrder.getProductEmbroideryNecessity().equals("1")) {

			// 刺繍ネーム
			if (dtbOrder.getProductEmbroideryNm() == null) {
				dtbOrder.setProductEmbroideryNm("");
			}
			Option option_embroidery_nm = new Option();
			option_embroidery_nm.setOrderdetailid(dtbOrder.getOrderId() + subNo);
			option_embroidery_nm.setStyleno(style_no);
			option_embroidery_nm.setClassType(class_type);
			option_embroidery_nm.setOption_type("C24");
			option_embroidery_nm.setOption_code(dtbOrder.getProductEmbroideryNm());
			coatOptions.add(option_embroidery_nm);
		}
		return coatOptions;
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
