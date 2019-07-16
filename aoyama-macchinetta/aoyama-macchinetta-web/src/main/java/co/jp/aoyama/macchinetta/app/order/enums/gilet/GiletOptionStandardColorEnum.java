package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionStandardColorEnum {

	// OptionForm
	// Key:mtb_optionのoption_code
	// Value:OptionFormのmethod
	// ラジオボタン選択（AMF色指定）、（ボタンホール色指定）、（ボタン付け糸指定）
	GILET_STANDARD_OPTION_COLOR01("00010","setOgAmfColorsMap"),
	GILET_STANDARD_OPTION_COLOR02("00013","setOgBhColorsMap"),
	GILET_STANDARD_OPTION_COLOR03("00016","setOgByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private GiletOptionStandardColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static GiletOptionStandardColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionStandardColorEnum get(String str) {
        for (GiletOptionStandardColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
