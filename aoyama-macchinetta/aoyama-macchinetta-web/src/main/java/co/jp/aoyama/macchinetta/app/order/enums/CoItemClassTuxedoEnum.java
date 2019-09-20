package co.jp.aoyama.macchinetta.app.order.enums;

public enum CoItemClassTuxedoEnum {
	
	// key: item_code
	// value: class
	
	ITEM_CODE_SUIT("01",""),
	ITEM_CODE_JACKET("02","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketTuxedoInfo"),
	ITEM_CODE_PANTS("03","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo"),
	ITEM_CODE_GILET("04","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo"),
	ITEM_CODE_PANTS2("07","co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo");
	
	private final String key;
	private final String value;
    
	private CoItemClassTuxedoEnum(String k ,String v ) {
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
		for (CoItemClassTuxedoEnum e : values()) {
            if(e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return "";
	}
  
    public static CoItemClassTuxedoEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoItemClassTuxedoEnum get(String str) {
        for (CoItemClassTuxedoEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
