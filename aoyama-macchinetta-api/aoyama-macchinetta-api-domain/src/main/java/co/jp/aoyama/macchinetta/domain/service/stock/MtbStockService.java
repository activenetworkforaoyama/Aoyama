package co.jp.aoyama.macchinetta.domain.service.stock;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.dto.Stock;

public interface MtbStockService {

	List<Stock> updateActualStockByFabricNo(List<Stock> stockList);

}
