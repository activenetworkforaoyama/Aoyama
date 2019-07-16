package co.jp.aoyama.macchinetta.domain.repository.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;

public interface NextGenerationRepository {
	
	List<NextGenerationPrice> selectOptionNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode);
	
	List<NextGenerationPrice> selectBasicNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String itemCode,String fabricNo);

	List<NextGenerationPrice> selectDetailNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode);
	
	List<NextGenerationPrice> selectYield(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode);
	
	List<NextGenerationPrice> selectWholesalePiece(String fabricNo);
	
	NextGenerationPrice selectMarginRate(String fabricNo);
	
	NextGenerationPrice selectFactoryCode(String fabricNo);
}
