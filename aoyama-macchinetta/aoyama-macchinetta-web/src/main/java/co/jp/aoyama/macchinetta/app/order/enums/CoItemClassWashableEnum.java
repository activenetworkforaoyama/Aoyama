package co.jp.aoyama.macchinetta.app.order.enums;

public enum CoItemClassWashableEnum {
	
	// key: item_code
	// value: class
	
	ITEM_CODE_SUIT("01",""),
	ITEM_CODE_JACKET("02","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketWashableInfo"),
	ITEM_CODE_PANTS("03","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo"),
	ITEM_CODE_GILET("04","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo"),
	ITEM_CODE_PANTS2("07","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo");
	
	private final String key;
	private final String value;
    
	private CoItemClassWashableEnum(String k ,String v ) {
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
		for (CoItemClassWashableEnum e : values()) {
            if(e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return "";
	}
  
    public static CoItemClassWashableEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoItemClassWashableEnum get(String str) {
        for (CoItemClassWashableEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
