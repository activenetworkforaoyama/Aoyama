package co.jp.aoyama.macchinetta.domain.repository.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;

public interface NextGenerationRepository {
	
	List<NextGenerationPrice> selectOptionNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String factoryCode,String itemCode);
	
	List<NextGenerationPrice> selectBasicNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String itemCode,String fabricNo);

	List<NextGenerationPrice> selectDetailNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String factoryCode,String itemCode);
	
	List<NextGenerationPrice> selectYield(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode);
	
	List<NextGenerationPrice> selectWholesalePiece(String fabricNo);
	
	NextGenerationPrice selectMarginRate(String fabricNo);
	
	NextGenerationPrice selectFactoryCode(String fabricNo);
	
	List<NextGenerationPrice> selectCoYield(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String shirtSubItemCode, String coatSubItemCode);
	
	List<NextGenerationPrice> selectCoWholesalePiece(String fabricNo,String factoryCd);
	
	List<NextGenerationPrice> selectCoBasicNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String shirtSubItemCode, String coatSubItemCode,String itemCode,String fabricNo,String factoryCd);
	
	NextGenerationPrice selectCoMarginRate(String fabricNo,String makerCode);
	
	NextGenerationPrice selectCoFactoryCode(String fabricNo);
	
	List<NextGenerationPrice> selectCoOptionNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String factoryCode,String itemCode,String stSubItemCode,String ctSubItemCode);
	
	List<NextGenerationPrice> selectCoDetailNextGenerationPrice(String jkSubItemCode,String ptSubItemCode,String gtSubItemCode,String pt2SubItemCode,String factoryCode,String itemCode,String stSubItemCode,String ctSubItemCode);
	
	List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList(String factoryCode,String item,String subItem,String optionCode);
	
	List<NextGenerationPrice> selectCoComplexItemsWageList(String factoryCode,String item,String subItem,String optionCode);
}
