package co.jp.aoyama.macchinetta.app.order.enums;

public enum ItemClassStandardEnum {
	
	// key: item_code
	// value: optionInfo class
	
	ITEM_CODE_SUIT("01",""),
	ITEM_CODE_JACKET("02","co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfo"),
	ITEM_CODE_PANTS("03","co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfo"),
	ITEM_CODE_GILET("04","co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfo"),
	ITEM_CODE_SHIRTS("05","co.jp.aoyama.macchinetta.app.order.info.OptionShirtStandardInfo"),
	ITEM_CODE_COAT("06","co.jp.aoyama.macchinetta.app.order.info.OptionCoatStandardInfo"),
	ITEM_CODE_PANTS2("07","co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfo");
	
	private final String key;
	private final String value;
    
	private ItemClassStandardEnum(String k ,String v ) {
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
		for (ItemClassStandardEnum e : values()) {
            if(e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return "";
	}
  
    public static ItemClassStandardEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static ItemClassStandardEnum get(String str) {
        for (ItemClassStandardEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
