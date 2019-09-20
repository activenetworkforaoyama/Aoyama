package co.jp.aoyama.macchinetta.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.jp.aoyama.macchinetta.app.rest.api.consts.WebConst;
import co.jp.aoyama.macchinetta.app.rest.api.model.OrderStatusShanghaiFuliangCoInput;
import co.jp.aoyama.macchinetta.app.rest.api.model.OrderStatusShanghaiFuliangCoOutput;
import co.jp.aoyama.macchinetta.app.rest.api.model.OrdersShanghaiFuliangCo;
import co.jp.aoyama.macchinetta.app.rest.api.model.ReturnResultShanghaiFuliangCo;
import co.jp.aoyama.macchinetta.app.rest.api.util.HttpUtil;
import co.jp.aoyama.macchinetta.domain.dto.OrderStatusOutput;
import co.jp.aoyama.macchinetta.domain.dto.ReturnGetOrderStatusShanghaiFuliangCo;
import co.jp.aoyama.macchinetta.domain.service.order.DtbOrderService;

/**
 * 
 * @author liufeng
 *
 */
@Component
public class GetOrderStatusControllerShanghaiFuliangCo {

	/** 格式：年－月－日 */
	private static final String LONG_DATE_FORMAT = "yyyy/MM/dd";

	/** 注文ステータス：生産中 */
	private static final String ORDER_STATUS_IN_PRODUCTION = "OS0502";

	/** 注文ステータス：生産中 */
	private static final String ORDER_STATUS_IN_TRANSIT = "OS0504";

	@Inject
	DtbOrderService orderService;

	@Inject
	RestTemplate restTemplate;

	@Value("${fuliang.api.url.GetAccessToken}")
	String tokenUrl;

	@Value("${fuliang.api.url.getOrderStatus}")
	String getOrderStatusUrl;

	@Value("${fuliang.api.appsecrets}")
	String appSecrets;

	@Value("${api.prefix}")
	String prefix;

	@Value("${fuliang.api.url.AESDecrypt}")
	String aesDecryptUrl;

	@Value("${fuliang.api.accesstoken.appsecrets}")
	String accessTokenAppSecrets;

	@Value("${fuliang.api.accesstoken.token}")
	String accessTokenToken;

	@Value("${api.timeout.connect}")
	int connectTimeout;

	@Value("${api.timeout.read}")
	int readTimeout;

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(GetOrderStatusControllerShanghaiFuliangCo.class);

	/**
	 * タイムアウト注文の確認
	 * 
	 * @param orderIds
	 */
	public void doTimeoutOrderConfirm(List<String> orderIds) {
		logger.info("GetOrderStatus:受注マスタのタイムアウト注文を確認する処理開始");
		// タイムアウト注文リスト
		List<OrderStatusOutput> resultList = getMsgJson(orderIds);
		List<String> successOrderIds = new ArrayList<String>();
		List<String> sendOrderIds = new ArrayList<String>();

		for (OrderStatusOutput orderStatusOutput : resultList) {
			String receivedOrderId = orderStatusOutput.getOrderno();
			receivedOrderId = receivedOrderId.substring(0, 12);

			if (!successOrderIds.contains(receivedOrderId)) {
				successOrderIds.add(receivedOrderId);
			}
		}

		for (String timeoutOrder : orderIds) {
			if (!successOrderIds.contains(timeoutOrder)) {
				sendOrderIds.add(timeoutOrder);
			}
		}

		orderService.updateSendSuccessOrderIds(successOrderIds, sendOrderIds);

		logger.info("GetOrderStatus:受注マスタのタイムアウト注文を確認する処理終了");
	}

	/**
	 * DB ステータス を変更
	 * 
	 * @return void
	 */
	public void changeDbStatus(List<String> orderIds) {

		// ステータスが生産終了としてのリスト
		List<String> completeStatus = new ArrayList<String>();
		// 生産中
		completeStatus.add(ORDER_STATUS_IN_PRODUCTION);
		// 千葉へ運送中
		completeStatus.add(ORDER_STATUS_IN_TRANSIT);

		logger.info("GetOrderStatus:受注マスタの出荷日、工場ステータス、出荷連携ステータスを更新する処理開始");
		// 受信結果リスト
		List<OrderStatusOutput> resultList = getMsgJson(orderIds);
		// DB更新対象リスト
		List<OrderStatusOutput> updateList = new ArrayList<OrderStatusOutput>();
		// サブ注文ID有りの注文マップ
		Map<String, List<OrderStatusOutput>> orderMap = new HashMap<String, List<OrderStatusOutput>>();
		// サブ注文IDリスト
		List<OrderStatusOutput> subOrderList = new ArrayList<OrderStatusOutput>();

		for (OrderStatusOutput output : resultList) {
			// 注文ID
			String orderId = output.getOrderno();
			// 受信結果のステータス
			String orderStatus = output.getOrder_status();

			if (14 == orderId.length()) {
				// サブ注文IDの場合
				// メイン注文IDを取得する
				String mainOrderId = orderId.substring(0, 12);

				if (null == orderMap) {
					orderMap = new HashMap<String, List<OrderStatusOutput>>();
				}

				if (orderMap.containsKey(mainOrderId)) {
					// マップで登録済の場合

					// 既存のサブ注文IDリストを取得する
					subOrderList = orderMap.get(mainOrderId);
					// マップから、既存のサブ注文IDリストをクリアする
					orderMap.remove(mainOrderId);
				} else {
					// マップで未登録の場合

					// サブ注文IDリストを新規する
					subOrderList = new ArrayList<OrderStatusOutput>();
				}
				// サブ注文IDリストへ受信結果を追加する
				subOrderList.add(output);
				// マップへサブ注文IDリストを追加する
				orderMap.put(mainOrderId, subOrderList);

			} else {
				// サブ注文ID以外の場合

				// 受信結果のステータスを確認する
				if (!completeStatus.contains(orderStatus)) {
					// 生産終了ステータスリストの中で含まないの場合、次のデータへ飛び
					continue;
				}
				// DB更新対象リストへ受信結果を追加する
				updateList.add(output);
			}
		}

		if (0 < orderMap.keySet().size()) {
			OrderStatusOutput mainOrder = null;
			for (Iterator<String> iterator = orderMap.keySet().iterator(); iterator.hasNext();) {
				// メイン注文ID
				String mainOrderId = (String) iterator.next();

				// サブ注文IDリストを取得する
				subOrderList = orderMap.get(mainOrderId);

				// 全部サブ注文の出荷日が設置していたというフラグ
				boolean isAllSetShukkaDate = true;
				// 注文が生産中になったというフラグ
				boolean isInProduction = false;
				// 全部サブ注文の中で、最新の出荷日
				String lastShukkaDate = "";
				// 受信結果のステータス
				String orderStatus = "";

				for (OrderStatusOutput subOrder : subOrderList) {
					// 出荷日
					String shukkaDate = subOrder.getDeliver_date();
					// 受信結果のステータス
					orderStatus = subOrder.getOrder_status();

					if (ORDER_STATUS_IN_PRODUCTION.equals(orderStatus)) {
						// 全部サブ注文の出荷日が設置していなかったとして
						isAllSetShukkaDate = false;
						// 注文が生産中になったとして
						isInProduction = true;
						// 確認中止
						break;
					} else {
						if (!completeStatus.contains(orderStatus) || null == shukkaDate || "".equals(shukkaDate)) {
							// 生産終了ステータスリストの中で含まない または 出荷日が未設置の場合
							// 全部サブ注文の出荷日が設置していなかったとして
							isAllSetShukkaDate = false;
						} else {
							// 出荷日が設置したの場合
							if ("".equals(lastShukkaDate)) {
								// 最新の出荷日が未設置の場合
								lastShukkaDate = shukkaDate;
							} else {
								// 最新の出荷日が設置したの場合
								lastShukkaDate = getMaxDate(lastShukkaDate, shukkaDate);
							}
						}
					}
				}

				if (isAllSetShukkaDate || isInProduction) {
					// 全部サブ注文の出荷日が設置していた場合 または 注文が生産中になった場合

					// メイン注文受信結果を新規する
					mainOrder = new OrderStatusOutput();

					mainOrder.setOrderno(mainOrderId);
					mainOrder.setOrder_status(orderStatus);
					mainOrder.setDeliver_date(lastShukkaDate);

					// DB更新対象リストへ受信結果を追加する
					updateList.add(mainOrder);
				}
			}
		}
		logger.info("更新対象件数:{}", updateList.size());
		logger.info("更新対象:{}", JSON.toJSONString(updateList));

		if (0 < updateList.size()) {
			if (null != updateList.get(0) && null == updateList.get(0).getResult()) {
				orderService.updateShippingDateByOrderIds(updateList);
			}
		}
		logger.info("GetOrderStatus:受注マスタの出荷日、工場ステータス、出荷連携ステータスを更新する処理終了");
	}

	/**
	 * 二つ日付のうち、最新の日付を検出する
	 * 
	 * @param dateOne 日付
	 * @param dateTwo 日付
	 * @return 最新の日付
	 */
	private String getMaxDate(String dateOne, String dateTwo) {
		String maxDate = "";
		Date dateA = stringtoDate(dateOne, LONG_DATE_FORMAT);
		Date dateB = stringtoDate(dateTwo, LONG_DATE_FORMAT);

		if (null != dateA && null != dateB) {
			if (dateA.compareTo(dateB) < 0) {
				maxDate = dateTwo;
			} else {
				maxDate = dateOne;
			}
		}

		return maxDate;
	}

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 */
	private Date stringtoDate(String dateStr, String format) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);
			d = formater.parse(dateStr);
		} catch (Exception e) {
			d = null;
		}
		return d;
	}

	/**
	 * APIを伝送する
	 * 
	 * @return 注文情報リスト
	 */
	private List<OrderStatusOutput> getMsgJson(List<String> orderIds) {
		logger.info("受信処理開始");

		String resultString = "";
		Map<String, String> param = new HashMap<String, String>(1, 1);
		param.put("1", "1");
		try {
			resultString = new HttpUtil(connectTimeout, readTimeout).post(tokenUrl, param, null);
			logger.info("受信用Token取得結果文字列:{}", resultString);

			resultString = getVaildResult(resultString);

			logger.info("受信用Token取得結果文字列(無効内容抜き):{}", resultString);
		} catch (Exception e) {
			e.getStackTrace();
			logger.info("受信Token取得異常:{}", e.getMessage());
			return new ArrayList<OrderStatusOutput>();
		}

		Gson gson = new Gson();

		ReturnResultShanghaiFuliangCo returnResult = gson.fromJson(resultString,
				new TypeToken<ReturnResultShanghaiFuliangCo>() {
				}.getType());

		if (!WebConst.GET_ACCESS_TOKEN_SUCCESS.equals(returnResult.getResult())) {
			logger.info("受信用Token取得失敗:" + returnResult.getResult());
			return new ArrayList<OrderStatusOutput>();
		}

		String accessToken = returnResult.getMsgid();
		logger.info("受信用Token(復号前):" + accessToken);

		param = new HashMap<String, String>(3, 1);
		param.put("encryptStr", accessToken);
		param.put("access_token", accessTokenToken);
		param.put("appsecret", accessTokenAppSecrets);
		logger.info("受信用Token復号パラメータ:{}", param);

		try {
			resultString = new HttpUtil(connectTimeout, readTimeout).post(aesDecryptUrl, param, null);
			logger.info("受信用Token復号結果文字列:{}", resultString);

			resultString = getVaildResult(resultString);

			logger.info("受信用Token復号結果文字列(無効内容抜き):{}", resultString);
		} catch (Exception e) {
			e.getStackTrace();
			logger.info("受信Token復号異常:{}", e.getMessage());
			return new ArrayList<OrderStatusOutput>();
		}

		gson = new Gson();

		returnResult = gson.fromJson(resultString, new TypeToken<ReturnResultShanghaiFuliangCo>() {
		}.getType());

		if (WebConst.AES_DECRYPT_FAILED_TOKEN.equals(returnResult.getResult())) {
			logger.info("受信用Token復号失敗:" + returnResult.getResult());
			return new ArrayList<OrderStatusOutput>();
		} else if (WebConst.AES_DECRYPT_SUCCESS.equals(returnResult.getResult())) {
			accessToken = returnResult.getMsgid();
			logger.info("受信用Token(復号後):" + accessToken);
		} else {
			logger.info("受信用Token復号失敗(その他原因):" + returnResult.getResult());
			return new ArrayList<OrderStatusOutput>();
		}

		List<OrderStatusShanghaiFuliangCoOutput> returnOrderStatus = null;
		List<OrderStatusOutput> resultList = new ArrayList<OrderStatusOutput>();

		List<OrderStatusShanghaiFuliangCoInput> inputs = new ArrayList<OrderStatusShanghaiFuliangCoInput>();

		OrderStatusShanghaiFuliangCoInput input = null;
		for (String orderId : orderIds) {
			input = new OrderStatusShanghaiFuliangCoInput();
			input.setMainOrder(orderId);
			inputs.add(input);
		}

		OrdersShanghaiFuliangCo orders = new OrdersShanghaiFuliangCo();
		orders.setStatusMainOrder(inputs);

		String mainorder = JSON.toJSONString(orders);
		logger.info("受信注文ID:{}", mainorder);

		param = new HashMap<String, String>(3, 1);
		param.put("mainorder", mainorder);
		param.put("accessToken", accessToken);
		param.put("appsecret", appSecrets);

		logger.info("受信パラメータ:{}", JSON.toJSONString(param));

		try {
			resultString = new HttpUtil(connectTimeout, readTimeout).post(getOrderStatusUrl, param, null);
			logger.info("上海服良Coから受信結果文字列:{}", resultString);

			resultString = getVaildResult(resultString);

			logger.info("上海服良Coから受信結果文字列(無効内容抜き):{}", resultString);
		} catch (Exception e) {
			e.getStackTrace();
			logger.info("上海服良Coから受信異常:{}", e.getMessage());
			return new ArrayList<OrderStatusOutput>();
		}

		gson = new Gson();

		returnOrderStatus = gson.fromJson(resultString, new TypeToken<List<OrderStatusShanghaiFuliangCoOutput>>() {
		}.getType());

		for (OrderStatusShanghaiFuliangCoOutput orderStatus : returnOrderStatus) {
			if (WebConst.GET_ORDER_STATUS_SUCCESS.equals(orderStatus.getResult())) {

				for (ReturnGetOrderStatusShanghaiFuliangCo returnOrder : orderStatus.getListMainorder()) {

					resultList.add(convertToOrderStatusOutput(returnOrder));

				}
			} else if (WebConst.GET_ORDER_STATUS_FAILED_TOKEN.equals(orderStatus.getResult())) {

				logger.info("注文[{}]の受信結果が異常:トークンが存在しない", orderStatus.getMainorder());

			} else if (WebConst.GET_ORDER_STATUS_FAILED_PARAM.equals(orderStatus.getResult())) {

				logger.info("注文[{}]の受信結果が異常:パラメータが不足 ", orderStatus.getMainorder());

			} else if (WebConst.GET_ORDER_STATUS_FAILED_ORDER.equals(orderStatus.getResult())) {

				logger.info("注文[{}]の受信結果が異常:注文IDが存在しない", orderStatus.getMainorder());

			}
		}

		logger.info("受信結果リスト:{}", JSON.toJSONString(resultList));

		logger.info("受信処理終了");
		return resultList;
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private OrderStatusOutput convertToOrderStatusOutput(ReturnGetOrderStatusShanghaiFuliangCo input) {
		OrderStatusOutput output = new OrderStatusOutput();

		output.setOrderno(input.getOrderdetailid());
		output.setDeliver_date(input.getDeliver_date());
		output.setOrder_status(input.getOrder_status());

		return output;
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

}
