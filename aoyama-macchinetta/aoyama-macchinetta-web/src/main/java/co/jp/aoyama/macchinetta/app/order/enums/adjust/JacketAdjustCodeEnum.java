package co.jp.aoyama.macchinetta.app.order.enums.adjust;

public enum JacketAdjustCodeEnum {

	// OptionForm
	// Key:mtb_optionのoption_code
	// Value:OptionFormのmethod
	
	JACKET_ADJUST_CODE01("01","setCorJkBodyMap"),
	JACKET_ADJUST_CODE02("02","setCorJkWaistMap"),
	JACKET_ADJUST_CODE03("03","setCorJkRightsleeveMap"),
	JACKET_ADJUST_CODE04("04","setCorJkLeftsleeveMap");
	
	
	private final String key;
	private final String value;
    
    private JacketAdjustCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static JacketAdjustCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketAdjustCodeEnum get(String str) {
        for (JacketAdjustCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
