package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionTuxedoColorEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	// ラジオボタン選択（ボタンホール色指定）、（ボタン付け糸指定）
	
	PANTS_TUXEDO_OPTION_COLOR02("00028","setTpBhColorsMap"),
	PANTS_TUXEDO_OPTION_COLOR03("00031","setTpByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private PantsOptionTuxedoColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static PantsOptionTuxedoColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionTuxedoColorEnum get(String str) {
        for (PantsOptionTuxedoColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
