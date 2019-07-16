package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionWashableColorEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	// ラジオボタン選択（AMF色指定）、（ボタンホール色指定）、（ボタン付け糸指定）
	JACKET_WASHABLE_OPTION_COLOR01("00030","setWjAmfColorsMap"),
	JACKET_WASHABLE_OPTION_COLOR02("00033","setWjBhColorsMap"),
	JACKET_WASHABLE_OPTION_COLOR03("00036","setWjByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private JacketOptionWashableColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static JacketOptionWashableColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionWashableColorEnum get(String str) {
        for (JacketOptionWashableColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
