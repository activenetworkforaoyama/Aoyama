package co.jp.aoyama.macchinetta.app.order.enums.adjust;

public enum Pants2AdjustCodeEnum {

	// OptionForm
	// Key:mtb_optionのoption_code
	// Value:OptionFormのmethod
	
	PANTS_ADJUST_CODE01("06","setCorPt2WaistMap"),
	PANTS_ADJUST_CODE02("07","setCorPt2ThighMap"),
	PANTS_ADJUST_CODE03("08","setCorPt2HemwidthMap");
	
	
	private final String key;
	private final String value;
    
    private Pants2AdjustCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static Pants2AdjustCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2AdjustCodeEnum get(String str) {
        for (Pants2AdjustCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
