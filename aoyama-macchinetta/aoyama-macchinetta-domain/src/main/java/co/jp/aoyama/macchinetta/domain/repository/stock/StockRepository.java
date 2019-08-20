package co.jp.aoyama.macchinetta.domain.repository.stock;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Stock;

public interface StockRepository {
	 
	List<Stock> findAllStock();  
	
	Stock findStockByPk(@Param("orderPattern")String orderPattern,@Param("fabricNo")String fabricNo);

	void updateStockByPk(@Param("stockUpd") List<Stock> stockUpd);
	
	List<Stock> fuzzyQuery(@Param("orderPattern")String orderPattern,@Param("fabricNo")String fabricNo,@Param("color")String color,@Param("pattern")String pattern,@Param("brandName")String brandName,@Param("retailPrice")Integer retailPrice,@Param("retailPriceTo")Integer retailPriceTo,@Param("makerName")String makerName,@Param("factoryName")String factoryName);
    
	void updateStockValue(String fabricId,BigDecimal theoreticalStockUpdate,BigDecimal reservationStockUpdate);
	
	void updateTheoreticalStock(String fabricId,BigDecimal theoreticalStockUpdate);
}