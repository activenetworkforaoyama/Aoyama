package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionStandardColorEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	// ラジオボタン選択（AMF色指定）、（ボタンホール色指定）、（ボタン付け糸指定）
	
	JACKET_STANDARD_OPTION_COLOR01("00030","setOjAmfColorsMap"),
	JACKET_STANDARD_OPTION_COLOR02("00033","setOjBhColorsMap"),
	JACKET_STANDARD_OPTION_COLOR03("00036","setOjByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private JacketOptionStandardColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static JacketOptionStandardColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionStandardColorEnum get(String str) {
        for (JacketOptionStandardColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
