package co.jp.aoyama.macchinetta.domain.service.stock;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.dto.Stock;

public interface MtbStockService {
	/**
	 * 実在庫更新処理
	 * 
	 * @param stockList    大楊から取得する在庫情報リスト
	 * @param fabricNoList 生地マスタ（mtb_fabric）から取得する更新要「生地品番」リスト
	 */
	void updateActualStockByFabricNo(List<Stock> stockList, List<String> fabricNoList);

}
