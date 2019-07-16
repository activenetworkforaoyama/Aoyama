package co.jp.aoyama.macchinetta.app.order.enums;

public enum AdjustClassEnum {
	
	// key: 補正の アイテムコード
	// value: 補正のクラス
	
	ITEM_CODE_SUIT("01",""),
	ITEM_CODE_JACKET("02","co.jp.aoyama.macchinetta.app.order.info.AdjustJacketStandardInfo"),
	ITEM_CODE_PANTS("03","co.jp.aoyama.macchinetta.app.order.info.AdjustPantsStandardInfo"),
	ITEM_CODE_GILET("04",""),
	ITEM_CODE_SHIRTS("05",""),
	ITEM_CODE_COAT("06",""),
	ITEM_CODE_PANTS2("07","co.jp.aoyama.macchinetta.app.order.info.AdjustPants2StandardInfo");
	
	private final String key;
	private final String value;
    
	private AdjustClassEnum(String k ,String v ) {
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
		for (AdjustClassEnum e : values()) {
            if(e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return "";
	}
  
    public static AdjustClassEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static AdjustClassEnum get(String str) {
        for (AdjustClassEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
