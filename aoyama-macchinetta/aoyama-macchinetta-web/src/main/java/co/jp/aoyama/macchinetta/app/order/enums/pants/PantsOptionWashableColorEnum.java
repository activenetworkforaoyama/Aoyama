package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionWashableColorEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	// ラジオボタン選択（AMF色指定）、（ボタンホール色指定）、（ボタン付け糸指定）
	PANTS_WASHABLE_OPTION_COLOR01("00025","setWpAmfColorsMap"),
	PANTS_WASHABLE_OPTION_COLOR02("00028","setWpBhColorsMap"),
	PANTS_WASHABLE_OPTION_COLOR03("00031","setWpByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private PantsOptionWashableColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static PantsOptionWashableColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionWashableColorEnum get(String str) {
        for (PantsOptionWashableColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
