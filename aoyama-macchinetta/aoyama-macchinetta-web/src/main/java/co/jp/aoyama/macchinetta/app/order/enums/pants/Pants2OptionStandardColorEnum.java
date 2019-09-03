package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2OptionStandardColorEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	// ラジオボタン選択（AMF色指定）、（ボタンホール色指定）、（ボタン付け糸指定）
	
	PANTS_STANDARD_OPTION_COLOR01("00025","setOp2AmfColorsMap"),
	PANTS_STANDARD_OPTION_COLOR02("00028","setOp2BhColorsMap"),
	PANTS_STANDARD_OPTION_COLOR03("00031","setOp2ByColorsMap");
	
	
	private final String key;
	private final String value;
    
    private Pants2OptionStandardColorEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static Pants2OptionStandardColorEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2OptionStandardColorEnum get(String str) {
        for (Pants2OptionStandardColorEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
