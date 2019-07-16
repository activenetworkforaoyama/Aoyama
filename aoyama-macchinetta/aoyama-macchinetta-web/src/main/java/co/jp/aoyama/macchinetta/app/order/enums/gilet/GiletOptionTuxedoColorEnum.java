package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionTuxedoColorEnum {

	// OptionForm
	// Key:mtb_optionのoption_code
	// Value:OptionFormのmethod
	// ラジオボタン選択、（ボタンホール色指定）、（ボタン付け糸指定）
	GILET_TUXEDO_OPTION_COLOR02("00013","setTgBhColorsMap"),
	GILET_TUXEDO_OPTION_COLOR03("00016","setTgByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private GiletOptionTuxedoColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static GiletOptionTuxedoColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionTuxedoColorEnum get(String str) {
        for (GiletOptionTuxedoColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
