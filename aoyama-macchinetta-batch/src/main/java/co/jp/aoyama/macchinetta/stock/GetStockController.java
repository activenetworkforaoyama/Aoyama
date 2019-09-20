package co.jp.aoyama.macchinetta.stock;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.jp.aoyama.macchinetta.app.rest.api.consts.WebConst;
import co.jp.aoyama.macchinetta.app.rest.api.model.Token;
import co.jp.aoyama.macchinetta.domain.dto.Stock;
import co.jp.aoyama.macchinetta.domain.service.stock.MtbStockService;

@RestController
public class GetStockController {
	/** log */
	private static final Logger logger = LoggerFactory.getLogger(GetStockController.class);

	@Inject
	RestTemplate restTemplate;

	@Inject
	MtbStockService mtbStockService;

	@Value("${api.url.GetAccessToken:http://qs.dayang.net/QSservice.asmx/GetAccessToken}")
	URI tokenUrl;

	@Value("${api.url.getStock:http://qs.dayang.net/QSservice.asmx/GetStock}")
	URI getStockUrl;

	@Value("${api.appsecrets}")
	String appSecrets;
	/** 注文パターン：カスタムオーダー */
	public static final String ORDER_PATTERN = "PO";

	/**
	 * 在庫マスタの更新
	 */
	public void updateStock(List<String> fabricNoList) {
		logger.info("GetStock:在庫マスタの実在庫を更新する処理開始");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		// Token取得
		HttpEntity<String> requestToken = new HttpEntity<String>(headers);
		Token token = restTemplate.postForObject(tokenUrl, requestToken, Token.class);
		logger.info("受信用Token:" + token.getD());

		String stockUrl = getStockUrl + "?AccessToken=" + token.getD() + "&appsecrets=" + appSecrets;
		logger.info("受信URL:" + stockUrl);

		logger.info("大連大楊Poから受信結果");
		String result = restTemplate.getForObject(stockUrl, String.class);
		logger.info("大連大楊Poから受信結果文字列:" + result);

		if (result.indexOf(WebConst.STOCK_ERROR) != -1) {
			// エラーの場合
			logger.info("受信異常終了");
		} else {
			logger.info("受信正常終了");
			result = result.substring(result.indexOf("["), result.indexOf("]") + 1);
			Gson gson = new Gson();
			List<Stock> stockList = gson.fromJson(result, new TypeToken<List<Stock>>() {
			}.getType());

			logger.info("大連大楊Poから受信結果");
			if (stockList == null) {
				logger.info("受信結果異常");
			} else {
				logger.info("　　件数:" + stockList.size());
				logger.info("　　結果内容:" + JSON.toJSONString(stockList));

				List<Stock> updateStockList = new ArrayList<Stock>();

				for (Stock stock : stockList) {
					if (null != stock && null != stock.getFactory_stock()) {
						updateStockList.add(stock);
					}
				}

				if (0 < updateStockList.size()) {
					logger.info("　　有効件数:" + updateStockList.size());
					logger.info("　　有効結果内容:" + JSON.toJSONString(updateStockList));
					// 受信結果により、在庫マスタを更新する
					mtbStockService.updateActualStockByFabricNo(updateStockList, fabricNoList, ORDER_PATTERN);
				}
			}
		}
		logger.info("GetStock:在庫マスタの実在庫を更新する処理終了");
	}
}
