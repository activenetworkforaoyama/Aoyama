package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionWashableColorEnum {

	// OptionForm
	// Key:mtb_optionのoption_code
	// Value:OptionFormのmethod
	// ラジオボタン選択（AMF色指定）、（ボタンホール色指定）、（ボタン付け糸指定）
	GILET_WASHABLE_OPTION_COLOR01("00010","setWgAmfColorsMap"),
	GILET_WASHABLE_OPTION_COLOR02("00013","setWgBhColorsMap"),
	GILET_WASHABLE_OPTION_COLOR03("00016","setWgByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private GiletOptionWashableColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static GiletOptionWashableColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionWashableColorEnum get(String str) {
        for (GiletOptionWashableColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
