package co.jp.aoyama.macchinetta.app.rest.api.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
public class OrderStatusController {

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
	@Value("${api.send.maxcount.GetOrderStatus}")
	int sendMaxCount;

	@Value("${api.prefix}")
	String prefix;

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(OrderStatusController.class);

	/**
	 * 注文の ステータス確認処理を行う
	 * 
	 * @param selectFlag 選択フラグ 1：工場自動連携ステータス＝「1：送信済み」
	 */
	@RequestMapping(value = "/updateOrderStatus", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseStatus(HttpStatus.OK)
	public void updateOrderStatus() {

//		DtbOrder order = orderService.selectByPrimaryKey("076110000001");
//
//		order.setMakerFactoryStatus("F1");
//		order.setIsCancelled("0");
//		order.setSend2factoryStatus("1");
//
//		String[] testOrderIds = { "077110000043", "077110000044", "077110000040", "077110000041", "077110000042",
//				"077110000045", "077110000046", "077110000154", "077110000155", "077110000156", "077110000157",
//				"077110000158", "077110000159", "077110000160", "077110000161", "077110000162", "077110000151",
//				"077110000152", "077110000153", "077110000163", "077110000164", "077110000165" };
//
//		for (String testOrderId : testOrderIds) {
//			order.setOrderId(testOrderId);
//			orderService.insert(order);
//		}

		List<String> orderIdList = orderService.selectConfrimOrderId();

		List<String> orderIds = new ArrayList<String>();

		for (String dtbOrder : orderIdList) {

			orderIds.add(dtbOrder);

			if (sendMaxCount == orderIds.size()) {
				changeDbStatus(orderIds);
				orderIds.clear();
			}
		}

		if (0 < orderIds.size()) {
			changeDbStatus(orderIds);
		}
	}

	/**
	 * DB ステータス を変更
	 * 
	 * @return void
	 */
	private void changeDbStatus(List<String> orderIds) {

		List<OrderStatusOutput> list = getMsgJson(orderIds);

		if (0 < list.size()) {
			if (null != list.get(0) && null == list.get(0).getResult()) {
				orderService.updateShippingDateByOrderIds(list);
			}
		}
	}

	/**
	 * APIを伝送する
	 * 
	 * @return 注文情報リスト
	 */
	private List<OrderStatusOutput> getMsgJson(List<String> orderIds) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		HttpEntity<String> requestToken = new HttpEntity<String>(headers);
		Token token = restTemplate.postForObject(tokenUrl, requestToken, Token.class);

		List<OrderStatusInput> orders = new ArrayList<OrderStatusInput>();

		OrderStatusInput input = null;
		for (String orderId : orderIds) {
			input = new OrderStatusInput();
			input.setOrderno(prefix + orderId);
			orders.add(input);
		}

		JSONObject receiveOrderJson = new JSONObject();
		receiveOrderJson.put("orders", JSON.toJSONString(orders));
		receiveOrderJson.put("AccessToken", token.getD());
		receiveOrderJson.put("appsecrets", appSecrets);

		logger.info("receiveOrderJson:{}", receiveOrderJson.toString());

		HttpEntity<String> receiveOrderRequest = new HttpEntity<String>(receiveOrderJson.toString(), headers);
		ReturnMessage returnMessage = restTemplate.postForObject(getOrderStatusUrl, receiveOrderRequest,
				ReturnMessage.class);

		List<OrderStatusOutput> resultList = new ArrayList<OrderStatusOutput>();
		if (null != returnMessage) {
			logger.info("returnMessage.getD():{}", returnMessage.getD());

			if (null != returnMessage.getD() && !"".equals(returnMessage.getD())) {
				Gson gson = new Gson();
				resultList = gson.fromJson(returnMessage.getD(), new TypeToken<List<OrderStatusOutput>>() {
				}.getType());
			}

			logger.info("resultList:{}", resultList);
		}

		return resultList;
	}

}
