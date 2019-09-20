package co.jp.aoyama.macchinetta.domain.service.stock;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import co.jp.aoyama.macchinetta.domain.consts.DomainConst;
import co.jp.aoyama.macchinetta.domain.dto.Stock;
import co.jp.aoyama.macchinetta.domain.repository.stock.MtbStockRepository;

@Component
public class MtbStockServiceImpl implements MtbStockService {

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(MtbStockServiceImpl.class);

	@Inject
	MtbStockRepository mtbStockRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateActualStockByFabricNo(List<Stock> factoryStockList, List<String> localFabricNoList,
			String orderPattern) {

		List<Stock> notExsitInDbStocks = new ArrayList<Stock>();
		notExsitInDbStocks.addAll(factoryStockList);

		List<String> notExsitInDaiyoList = new ArrayList<String>();
		notExsitInDaiyoList.addAll(localFabricNoList);

		List<String> factoryFabricNoList = new ArrayList<String>();

		for (int i = (notExsitInDbStocks.size() - 1); 0 <= i; i--) {
			String fabricNo = notExsitInDbStocks.get(i).getFtcode();

			for (int j = 0; j < localFabricNoList.size(); j++) {
				if (fabricNo.equals(localFabricNoList.get(j))) {
					notExsitInDbStocks.remove(notExsitInDbStocks.get(i));
					break;
				}
			}

			factoryFabricNoList.add(fabricNo);
		}
		logger.info("在庫マスタで存在する生地品番リスト件数:" + localFabricNoList.size());
		logger.info("在庫マスタで存在する生地品番リスト:" + JSON.toJSONString(localFabricNoList));
		logger.info("工場から受信結果の生地品番リスト件数:" + factoryFabricNoList.size());
		logger.info("工場から受信結果の生地品番リスト:" + JSON.toJSONString(factoryFabricNoList));

		if (0 < notExsitInDbStocks.size()) {
			logger.info("工場から受信結果で存在、在庫マスタで存在しない件数:" + notExsitInDbStocks.size());
			logger.info("工場から受信結果で存在、在庫マスタで存在しない:" + JSON.toJSONString(notExsitInDbStocks));
		}

		for (int i = (notExsitInDaiyoList.size() - 1); 0 <= i; i--) {
			String localFabricNo = notExsitInDaiyoList.get(i);
			for (int j = 0; j < factoryFabricNoList.size(); j++) {
				String daiyoFabricNo = factoryFabricNoList.get(j);
				if (daiyoFabricNo.equals(localFabricNo)) {
					notExsitInDaiyoList.remove(localFabricNo);
					break;
				}
			}
		}

		if (0 < notExsitInDaiyoList.size()) {
			logger.info("在庫マスタで存在、工場から受信結果で存在しない件数:" + notExsitInDaiyoList.size());
			logger.info("在庫マスタで存在、工場から受信結果で存在しない:" + JSON.toJSONString(notExsitInDaiyoList));
		}

//		List<Stock> exsitInDbStocks = new ArrayList<Stock>();
//
//		for (int i = 0; i < daiyoStockList.size(); i++) {
//			String fabricNo = daiyoStockList.get(i).getFtcode();
//			for (int j = 0; j < localFabricNoList.size(); j++) {
//				if (fabricNo.equals(localFabricNoList.get(j))) {
//					exsitInDbStocks.add(daiyoStockList.get(i));
//				}
//			}
//
//		}
//		logger.info("これ受信結果は、在庫マスタで存在する件数:" + exsitInDbStocks.size());
//		logger.info("これ受信結果は、在庫マスタで存在する:" + JSON.toJSONString(exsitInDbStocks));
//
//		List<String> exsitInDaiyoList = new ArrayList<String>();
//
//		for (int i = 0; i < localFabricNoList.size(); i++) {
//			String localFabricNo = localFabricNoList.get(i);
//			for (int j = 0; j < daiyoFabricNoList.size(); j++) {
//				String daiyoFabricNo = daiyoFabricNoList.get(j);
//				if (daiyoFabricNo.equals(localFabricNo)) {
//					exsitInDaiyoList.add(localFabricNo);
//				}
//			}
//		}
//		logger.info("これ生地品番は、大楊から受信結果で存在する件数:" + exsitInDaiyoList.size());
//		logger.info("これ生地品番は、大楊から受信結果で存在する:" + JSON.toJSONString(exsitInDaiyoList));

		mtbStockRepository.updateActualStockByFabricNo(factoryStockList, DomainConst.BATCH_UPDATE_USERID, orderPattern);

//		logger.info("在庫マスタデータ更新件数:" + updateCount);
	}
}
