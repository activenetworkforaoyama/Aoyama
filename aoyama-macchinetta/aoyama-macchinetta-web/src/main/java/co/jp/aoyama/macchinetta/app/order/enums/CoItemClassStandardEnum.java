package co.jp.aoyama.macchinetta.app.order.enums;

public enum CoItemClassStandardEnum {
	
	// key: item_code
	// value: optionInfo class
	
	ITEM_CODE_SUIT("01",""),
	ITEM_CODE_JACKET("02","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketStandardInfo"),
	ITEM_CODE_PANTS("03","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo"),
	ITEM_CODE_GILET("04","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo"),
	ITEM_CODE_SHIRTS("05","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionShirtStandardInfo"),
	ITEM_CODE_COAT("06","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionCoatStandardInfo"),
	ITEM_CODE_PANTS2("07","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo");
	
	private final String key;
	private final String value;
    
	private CoItemClassStandardEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
	
	public String getKey() {
		return this.key;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static String getValue(String key) {
		for (CoItemClassStandardEnum e : values()) {
            if(e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return "";
	}
  
    public static CoItemClassStandardEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoItemClassStandardEnum get(String str) {
        for (CoItemClassStandardEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
