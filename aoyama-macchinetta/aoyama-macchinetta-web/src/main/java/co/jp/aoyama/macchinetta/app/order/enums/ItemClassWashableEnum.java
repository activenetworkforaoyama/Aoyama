package co.jp.aoyama.macchinetta.app.order.enums;

public enum ItemClassWashableEnum {
	
	// key: item_code
	// value: class
	
	ITEM_CODE_SUIT("01",""),
	ITEM_CODE_JACKET("02","co.jp.aoyama.macchinetta.app.order.info.OptionJacketWashableInfo"),
	ITEM_CODE_PANTS("03","co.jp.aoyama.macchinetta.app.order.info.OptionPantsWashableInfo"),
	ITEM_CODE_GILET("04","co.jp.aoyama.macchinetta.app.order.info.OptionGiletWashableInfo"),
	ITEM_CODE_PANTS2("07","co.jp.aoyama.macchinetta.app.order.info.OptionPants2WashableInfo");
	
	private final String key;
	private final String value;
    
	private ItemClassWashableEnum(String k ,String v ) {
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
		for (ItemClassWashableEnum e : values()) {
            if(e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return "";
	}
  
    public static ItemClassWashableEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static ItemClassWashableEnum get(String str) {
        for (ItemClassWashableEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
