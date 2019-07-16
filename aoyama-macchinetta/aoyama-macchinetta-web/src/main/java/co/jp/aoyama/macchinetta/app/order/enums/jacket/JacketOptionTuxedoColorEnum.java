package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionTuxedoColorEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	// ラジオボタン選択（ボタンホール色指定）、（ボタン付け糸指定）
	
	JACKET_TUXEDO_OPTION_COLOR02("00033","setTjBhColorsMap"),
	JACKET_TUXEDO_OPTION_COLOR03("00036","setTjByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private JacketOptionTuxedoColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static JacketOptionTuxedoColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionTuxedoColorEnum get(String str) {
        for (JacketOptionTuxedoColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
