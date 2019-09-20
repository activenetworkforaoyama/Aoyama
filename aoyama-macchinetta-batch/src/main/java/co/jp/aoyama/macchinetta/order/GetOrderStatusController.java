package co.jp.aoyama.macchinetta.order;

import java.net.URI;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.jp.aoyama.macchinetta.app.rest.api.model.OrderStatusInput;
import co.jp.aoyama.macchinetta.app.rest.api.model.ReturnMessage;
import co.jp.aoyama.macchinetta.app.rest.api.model.Token;
import co.jp.aoyama.macchinetta.domain.dto.OrderStatusOutput;
import co.jp.aoyama.macchinetta.domain.service.order.DtbOrderService;

/**
 * 
 * @author liufeng
 *
 */
@Component
public class GetOrderStatusController {

	/** 格式：年－月－日 */
	private static final String LONG_DATE_FORMAT = "yyyy-MM-dd";

	@Inject
	DtbOrderService orderService;

	@Inject
	RestTemplate restTemplate;

	@Value("${api.url.GetAccessToken:http://qs.dayang.net/QSservice.asmx/GetAccessToken}")
	URI tokenUrl;

	@Value("${api.url.getOrderStatus:http://qs.dayang.net/QSservice.asmx/GetOrderStatus}")
	URI getOrderStatusUrl;

	@Value("${api.appsecrets}")
	String appSecrets;

	/** 一回送信注文データ件数 */
//	@Value("${api.send.maxcount.GetOrderStatus}")
//	int sendMaxCount;

	@Value("${api.prefix}")
	String prefix;

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(GetOrderStatusController.class);

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
			receivedOrderId = receivedOrderId.substring(2, 14);

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
		completeStatus.add("1004");
		// 千葉へ運送中
		completeStatus.add("1005");
		// 千葉に到着
		completeStatus.add("1006");

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

			if (17 == orderId.length()) {
				// サブ注文IDの場合
				// メイン注文IDを取得する
				String mainOrderId = orderId.substring(2, 14);

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

					if ("1004".equals(orderStatus)) {
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

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		HttpEntity<String> requestToken = new HttpEntity<String>(headers);
		Token token = restTemplate.postForObject(tokenUrl, requestToken, Token.class);
		logger.info("受信用token:{}", token.getD());

		List<OrderStatusInput> orders = new ArrayList<OrderStatusInput>();

		OrderStatusInput input = null;
		for (String orderId : orderIds) {
			input = new OrderStatusInput();
			input.setOrderno(orderId);
			orders.add(input);
		}

		JSONObject json = new JSONObject();
		json.put("orders", JSON.toJSONString(orders));
		json.put("AccessToken", token.getD());
		json.put("appsecrets", appSecrets);

		logger.info("受信パラメータ:{}", json.toString());

		HttpEntity<String> receiveOrderRequest = new HttpEntity<String>(json.toString(), headers);
		ReturnMessage returnMessage = restTemplate.postForObject(getOrderStatusUrl, receiveOrderRequest,
				ReturnMessage.class);

		List<OrderStatusOutput> resultList = new ArrayList<OrderStatusOutput>();
		if (null != returnMessage) {
			logger.info("受信結果:{}", returnMessage.getD());

			if (null != returnMessage.getD() && !"".equals(returnMessage.getD())) {
				Gson gson = new Gson();
				resultList = gson.fromJson(returnMessage.getD(), new TypeToken<List<OrderStatusOutput>>() {
				}.getType());
			}

			logger.info("受信結果リスト:{}", JSON.toJSONString(resultList));
		}

		logger.info("受信処理終了");
		return resultList;
	}

}
