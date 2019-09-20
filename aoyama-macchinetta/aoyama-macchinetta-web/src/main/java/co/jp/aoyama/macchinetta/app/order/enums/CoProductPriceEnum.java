package co.jp.aoyama.macchinetta.app.order.enums;


public enum CoProductPriceEnum {
	PRODUCT_CODE01("90001","getProductCategory",""),
	PRODUCT_CODE02("90002","getProductLcrSewing","lcrSewing"),
	PRODUCT_CODE03("90003","getProductBrandNm",""),
	PRODUCT_CODE04("90004","getProductFabricNmNecessity",""),
	PRODUCT_CODE05("90005","getProductEmbroideryNecessity",""),
	PRODUCT_CODE06("90006","getProductEmbroideryFont",""),
	PRODUCT_CODE07("90008","getProductRemainingClothType",""),
	PRODUCT_CODE08("90009","getCustIsDeliverShortning","expediteDelivery"),
	PRODUCT_CODE09("90010","getCustIsEarlyDiscount",""),
	PRODUCT_CODE10("00022","","productEmbroideryNmPos"),
	PRODUCT_CODE11("00023","","gadget");
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	
	public String getKey() {
		return this.key;
	}
	 
	public String getValueOne() {
		return this.valueOne;
	}
	
	public String getValueTwo() {
		return this.valueTwo;
	}
	
	private CoProductPriceEnum(String key ,String valueOne,String valueTwo ) {
        this.valueOne = valueOne;
        this.key = key;
        this.valueTwo = valueTwo;
    }
	
	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(this.valueTwo);
    }
	
	public static CoProductPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoProductPriceEnum get(String str) {
        for (CoProductPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
