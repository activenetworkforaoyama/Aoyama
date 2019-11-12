package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

public class CoProductInfo implements Serializable{
	
	private static final long serialVersionUID = -1260068973607973173L;
	//カテゴリ
	private Map<String, String> productCategoryMap;
	//LCR縫製
	private Map<String, String> productLcrSewingMap;
	//ブランドネーム
	private Map<String, String> productBrandNmMap;
	//生地ネーム
	private Map<String, String> productFabricNmNecessityMap;
	//刺繍入れ
	private Map<String, String> productEmbroideryNecessityMap;
	//刺繍書体
	private Map<String, String> productEmbroideryFontMap;
	//残布
	private Map<String, String> productRemainingClothTypeMap;
	//納期短縮
	private Map<String, String> custIsDeliverShortningMap;
	//早割
	private Map<String, String> custIsEarlyDiscountMap;
	//拝絹地
	private Map<String, String> GlossFablicMap;
	
	public Map<String, String> getGlossFablicMap() {
		return GlossFablicMap;
	}
	public void setGlossFablicMap(Map<String, String> glossFablicMap) {
		GlossFablicMap = glossFablicMap;
	}
	public Map<String, String> getProductCategoryMap() {
		return productCategoryMap;
	}
	public void setProductCategoryMap(Map<String, String> productCategoryMap) {
		this.productCategoryMap = productCategoryMap;
	}
	public Map<String, String> getProductLcrSewingMap() {
		return productLcrSewingMap;
	}
	public void setProductLcrSewingMap(Map<String, String> productLcrSewingMap) {
		this.productLcrSewingMap = productLcrSewingMap;
	}
	public Map<String, String> getProductBrandNmMap() {
		return productBrandNmMap;
	}
	public void setProductBrandNmMap(Map<String, String> productBrandNmMap) {
		this.productBrandNmMap = productBrandNmMap;
	}
	public Map<String, String> getProductFabricNmNecessityMap() {
		return productFabricNmNecessityMap;
	}
	public void setProductFabricNmNecessityMap(Map<String, String> productFabricNmNecessityMap) {
		this.productFabricNmNecessityMap = productFabricNmNecessityMap;
	}
	public Map<String, String> getProductEmbroideryNecessityMap() {
		return productEmbroideryNecessityMap;
	}
	public void setProductEmbroideryNecessityMap(Map<String, String> productEmbroideryNecessityMap) {
		this.productEmbroideryNecessityMap = productEmbroideryNecessityMap;
	}
	public Map<String, String> getProductEmbroideryFontMap() {
		return productEmbroideryFontMap;
	}
	public void setProductEmbroideryFontMap(Map<String, String> productEmbroideryFontMap) {
		this.productEmbroideryFontMap = productEmbroideryFontMap;
	}
	public Map<String, String> getProductRemainingClothTypeMap() {
		return productRemainingClothTypeMap;
	}
	public void setProductRemainingClothTypeMap(Map<String, String> productRemainingClothTypeMap) {
		this.productRemainingClothTypeMap = productRemainingClothTypeMap;
	}
	public Map<String, String> getCustIsDeliverShortningMap() {
		return custIsDeliverShortningMap;
	}
	public void setCustIsDeliverShortningMap(Map<String, String> custIsDeliverShortningMap) {
		this.custIsDeliverShortningMap = custIsDeliverShortningMap;
	}
	public Map<String, String> getCustIsEarlyDiscountMap() {
		return custIsEarlyDiscountMap;
	}
	public void setCustIsEarlyDiscountMap(Map<String, String> custIsEarlyDiscountMap) {
		this.custIsEarlyDiscountMap = custIsEarlyDiscountMap;
	}
	
}
