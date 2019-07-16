package co.jp.aoyama.macchinetta.app.order.enums;

public enum ItemTypeEnum {
	
	// key: item_code
	// value: item_name
	
	ITEM_CODE_SUIT("01","SUIT"),
	ITEM_CODE_JACKET("02","JACKET"),
	ITEM_CODE_PANTS("03","PANTS"),
	ITEM_CODE_GILET("04","GILET"),
	ITEM_CODE_SHIRTS("05","SHIRTS"),
	ITEM_CODE_COAT("06","COAT"),
	ITEM_CODE_PANTS2("07","PANTS");
	
	private final String key;
	private final String value;
    
	private ItemTypeEnum(String k ,String v ) {
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
		for (ItemTypeEnum e : values()) {
            if(e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return "";
	}
  
    public static ItemTypeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static ItemTypeEnum get(String str) {
        for (ItemTypeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
