package co.jp.aoyama.macchinetta.app.order.enums.adjust;

public enum PantsAdjustCodeEnum {

	// OptionForm
	// Key:mtb_optionのoption_code
	// Value:OptionFormのmethod
	
	PANTS_ADJUST_CODE01("06","setCorPtWaistMap"),
	PANTS_ADJUST_CODE02("07","setCorPtThighMap"),
	PANTS_ADJUST_CODE03("08","setCorPtHemwidthMap");
	
	
	private final String key;
	private final String value;
    
    private PantsAdjustCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static PantsAdjustCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsAdjustCodeEnum get(String str) {
        for (PantsAdjustCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
