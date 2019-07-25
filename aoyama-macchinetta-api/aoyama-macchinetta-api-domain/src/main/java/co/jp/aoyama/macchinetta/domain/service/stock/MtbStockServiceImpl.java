package co.jp.aoyama.macchinetta.domain.service.stock;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.consts.DomainConst;
import co.jp.aoyama.macchinetta.domain.dto.Stock;
import co.jp.aoyama.macchinetta.domain.repository.stock.MtbStockRepository;

@Service
public class MtbStockServiceImpl implements MtbStockService {
	@Inject
	MtbStockRepository mtbStockRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Stock> updateActualStockByFabricNo(List<Stock> stockList) {

		List<String> fabricNoList = mtbStockRepository.selectfabricNoList();

		List<Stock> fabricNoListOut = new ArrayList<Stock>();
		fabricNoListOut.addAll(stockList);
		for (int i = 0; i < fabricNoListOut.size(); i++) {
			for (int j = 0; j < fabricNoList.size(); j++) {
				if (fabricNoListOut.get(i).getFtno().equals(fabricNoList.get(j))) {
					fabricNoListOut.remove(fabricNoListOut.get(i));
				}
			}
		}

		mtbStockRepository.updateActualStockByFabricNo(stockList, DomainConst.BATCH_UPDATE_USERID);

		return fabricNoListOut;
	}
}
