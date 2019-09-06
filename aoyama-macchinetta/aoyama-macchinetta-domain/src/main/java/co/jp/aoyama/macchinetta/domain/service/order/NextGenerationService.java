package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;

public interface NextGenerationService {
	
	List<NextGenerationPrice> selectOptionNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String factoryCode,String itemCode);
	
	List<NextGenerationPrice> selectBasicNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String itemCode,String fabricNo);
	
	List<NextGenerationPrice> selectDetailNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String factoryCode,String itemCode);

	List<NextGenerationPrice> selectYield(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode);
	
	List<NextGenerationPrice> selectWholesalePiece(String fabricNo);
	
	NextGenerationPrice selectMarginRate(String fabricNo);
	
	NextGenerationPrice selectFactoryCode(String fabricNo);
	
	List<NextGenerationPrice> selectCoYield(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String shirtSubItemCode, String coatSubItemCode);
	
	List<NextGenerationPrice> selectCoWholesalePiece(String fabricNo);
	
	List<NextGenerationPrice> selectCoBasicNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String shirtSubItemCode,String coatSubItemCode,String itemCode,String fabricNo);
	
	NextGenerationPrice selectCoMarginRate(String fabricNo);
	
	NextGenerationPrice selectCoFactoryCode(String fabricNo);
}
