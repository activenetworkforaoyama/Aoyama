package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionStandardColorEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	// ラジオボタン選択（AMF色指定）、（ボタンホール色指定）、（ボタン付け糸指定）
	
	PANTS_STANDARD_OPTION_COLOR01("00025","setOpAmfColorsMap"),
	PANTS_STANDARD_OPTION_COLOR02("00028","setOpBhColorsMap"),
	PANTS_STANDARD_OPTION_COLOR03("00031","setOpByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private PantsOptionStandardColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static PantsOptionStandardColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionStandardColorEnum get(String str) {
        for (PantsOptionStandardColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
