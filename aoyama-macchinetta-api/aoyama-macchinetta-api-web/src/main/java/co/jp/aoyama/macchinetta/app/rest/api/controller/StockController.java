package co.jp.aoyama.macchinetta.app.rest.api.controller;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class StockController {

	private static final Logger logger = LoggerFactory.getLogger(StockController.class);

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

	/**
	 * 在庫マスタの更新
	 */
	@RequestMapping(value = "/updateStock", method = { RequestMethod.POST, RequestMethod.GET })
	// @ResponseStatus(HttpStatus.OK)
	public void updateStock() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		// Token取得
		HttpEntity<String> requestToken = new HttpEntity<String>(headers);
		Token token = restTemplate.postForObject(tokenUrl, requestToken, Token.class);

		String stockUrl = getStockUrl + "?AccessToken=" + token.getD() + "&appsecrets=" + appSecrets;
		String result = restTemplate.getForObject(stockUrl, String.class);

		if (result.indexOf(WebConst.STOCK_ERROR) != -1) {
			// エラーの場合
			logger.info("GetStock:AccessToken=" + token.getD() + "&appsecrets=" + appSecrets);
		} else {
			result = result.substring(result.indexOf("["), result.indexOf("]") + 1);
			Gson gson = new Gson();
			List<Stock> stockList = gson.fromJson(result, new TypeToken<List<Stock>>() {
			}.getType());
			if (stockList.size() > 0) {
				// 受信結果により、在庫マスタを更新する
				List<Stock> fabricNoListOut = mtbStockService.updateActualStockByFabricNo(stockList);

				logger.info("これ受信結果は、在庫マスタで存在しない" + JSON.toJSONString(fabricNoListOut));
			}

		}
	}
}
