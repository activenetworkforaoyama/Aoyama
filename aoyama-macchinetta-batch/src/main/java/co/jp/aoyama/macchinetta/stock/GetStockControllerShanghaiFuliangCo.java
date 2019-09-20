package co.jp.aoyama.macchinetta.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.jp.aoyama.macchinetta.app.rest.api.consts.WebConst;
import co.jp.aoyama.macchinetta.app.rest.api.model.ReturnResultShanghaiFuliangCo;
import co.jp.aoyama.macchinetta.app.rest.api.util.HttpUtil;
import co.jp.aoyama.macchinetta.domain.dto.ReturnGetStockShanghaiFuliangCo;
import co.jp.aoyama.macchinetta.domain.dto.Stock;
import co.jp.aoyama.macchinetta.domain.service.stock.MtbStockService;

@RestController
public class GetStockControllerShanghaiFuliangCo {
	/** log */
	private static final Logger logger = LoggerFactory.getLogger(GetStockControllerShanghaiFuliangCo.class);

	@Inject
	RestTemplate restTemplate;

	@Inject
	MtbStockService mtbStockService;

	@Value("${fuliang.api.url.GetAccessToken}")
	String tokenUrl;

	@Value("${fuliang.api.url.getStock}")
	String getStockUrl;

	@Value("${fuliang.api.appsecrets}")
	String appSecrets;

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

	/** 注文パターン：カスタムオーダー */
	public static final String ORDER_PATTERN = "CO";

	/**
	 * 在庫マスタの更新
	 */
	public void updateStock(List<String> fabricNoList) {
		logger.info("GetStock:在庫マスタの実在庫を更新する処理開始");

		// Token取得
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
			return;
		}

		Gson gson = new Gson();

		ReturnResultShanghaiFuliangCo returnResult = gson.fromJson(resultString,
				new TypeToken<ReturnResultShanghaiFuliangCo>() {
				}.getType());

		if (!WebConst.GET_ACCESS_TOKEN_SUCCESS.equals(returnResult.getResult())) {
			logger.info("受信用Token取得失敗:" + returnResult.getResult());
			return;
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
			return;
		}

		gson = new Gson();

		returnResult = gson.fromJson(resultString, new TypeToken<ReturnResultShanghaiFuliangCo>() {
		}.getType());

		if (WebConst.AES_DECRYPT_FAILED_TOKEN.equals(returnResult.getResult())) {
			logger.info("受信用Token復号失敗:" + returnResult.getResult());
			return;
		} else if (WebConst.AES_DECRYPT_SUCCESS.equals(returnResult.getResult())) {
			accessToken = returnResult.getMsgid();
			logger.info("受信用Token(復号後):" + accessToken);
		} else {
			logger.info("受信用Token復号失敗(その他原因):" + returnResult.getResult());
			return;
		}

		List<ReturnGetStockShanghaiFuliangCo> returnGetStocks = null;

		param = new HashMap<String, String>(1, 1);
		param.put("accessToken", accessToken);
		logger.info("上海服良Coから受信パラメータ:{}", param);

		try {
			resultString = new HttpUtil(connectTimeout, readTimeout).post(getStockUrl, param, null);

			logger.info("上海服良Coから受信結果文字列:{}", resultString);

			resultString = getVaildResult(resultString);

			logger.info("上海服良Coから受信結果文字列(無効内容抜き):{}", resultString);
		} catch (Exception e) {
			e.getStackTrace();
			logger.info("上海服良Coから受信異常:{}", e.getMessage());
			return;
		}

		gson = new Gson();

		returnGetStocks = gson.fromJson(resultString, new TypeToken<List<ReturnGetStockShanghaiFuliangCo>>() {
		}.getType());
		logger.info("上海服良Coから受信結果内容:" + JSON.toJSONString(returnGetStocks));

		List<Stock> updateStockList = new ArrayList<Stock>();

		for (ReturnGetStockShanghaiFuliangCo returnStock : returnGetStocks) {
			if (WebConst.GET_STOCK_FAILED_TOKEN.equals(returnStock.getResult())) {
				// エラーの場合
				logger.info("受信異常終了:[{}]トークンが存在しない", returnStock.getFtno());
			} else if (WebConst.GET_STOCK_FAILED_PARAM.equals(returnStock.getResult())) {
				// エラーの場合
				logger.info("受信異常終了:[{}]パラメータが不足", returnStock.getFtno());
			} else if (WebConst.GET_STOCK_FAILED_FABRIC.equals(returnStock.getResult())) {
				// エラーの場合
				logger.info("受信異常終了:[{}]生地が存在しない", returnStock.getFtno());
			} else if (WebConst.GET_STOCK_SUCCESS.equals(returnStock.getResult())) {
				logger.info("受信正常終了:[{}]", returnStock.getFtno());

				if (null != returnStock.getFactory_stock()) {
					updateStockList.add(convertToStock(returnStock));
				}
			}
		}
		if (0 < updateStockList.size()) {
			logger.info("有効結果内容:" + JSON.toJSONString(updateStockList));
			// 受信結果により、在庫マスタを更新する
			mtbStockService.updateActualStockByFabricNo(updateStockList, fabricNoList, ORDER_PATTERN);
		}
		logger.info("GetStock:在庫マスタの実在庫を更新する処理終了");
	}

	/**
	 * 
	 * @param returnGetStock
	 * @return Stock
	 */
	private Stock convertToStock(ReturnGetStockShanghaiFuliangCo returnGetStock) {
		Stock stock = new Stock();
		if (null != returnGetStock) {
			stock.setFtno(returnGetStock.getFtno());
			stock.setFtcode(returnGetStock.getFtcode());
			stock.setFactory_stock(returnGetStock.getFactory_stock());
			stock.setMaterial_status(returnGetStock.getMaterial_status());
			stock.setOrder_stock(returnGetStock.getOrder_stock());
		}
		return stock;
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
