package co.jp.aoyama.macchinetta.app.order.enums;


public enum CoProductEnum {
	PRODUCT_CODE01("90001","setProductCategoryMap"),
	PRODUCT_CODE02("90002","setProductLcrSewingMap"),
	PRODUCT_CODE03("90003","setProductBrandNmMap"),
	PRODUCT_CODE04("90004","setProductFabricNmNecessityMap"),
	PRODUCT_CODE05("90005","setProductEmbroideryNecessityMap"),
	PRODUCT_CODE06("90006","setProductEmbroideryFontMap"),
	PRODUCT_CODE07("90008","setProductRemainingClothTypeMap"),
	PRODUCT_CODE08("90009","setCustIsDeliverShortningMap"),
	PRODUCT_CODE09("90010","setCustIsEarlyDiscountMap"),
	PRODUCT_CODE10("90011","setGlossFablicMap");
	
	private final String key;
	private final String value;
	
	private CoProductEnum(String key ,String value ) {
        this.value = value;
        this.key = key;
    }
	
	public String toString() {
        return this.key.concat(",").concat(this.value);
    }
	
	public static CoProductEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoProductEnum get(String str) {
        for (CoProductEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
