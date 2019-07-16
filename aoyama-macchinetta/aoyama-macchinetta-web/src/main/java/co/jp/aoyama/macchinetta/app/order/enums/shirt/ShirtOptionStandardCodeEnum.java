package co.jp.aoyama.macchinetta.app.order.enums.shirt;

public enum ShirtOptionStandardCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	SHIRT_STANDARD_OPTION_CODE01("00001","setOsCasHemLineMap"),
	SHIRT_STANDARD_OPTION_CODE02("00002","setOsChainModelMap"),
	SHIRT_STANDARD_OPTION_CODE03("00003","setOsCuffsMap"),
	SHIRT_STANDARD_OPTION_CODE04("00004","setOsConvertibleMap"),
	SHIRT_STANDARD_OPTION_CODE05("00005","setOsAdjustBtnMap"),
	SHIRT_STANDARD_OPTION_CODE06("00006","setOsDblCuffMap"),
	SHIRT_STANDARD_OPTION_CODE07("00007","setOsClericSpecMap"),
	SHIRT_STANDARD_OPTION_CODE08("00008","setOsCuffClericMap"),
	SHIRT_STANDARD_OPTION_CODE09("00009","setOsBtnMateMap"),
	SHIRT_STANDARD_OPTION_CODE10("00010","setOsGaletteBtnPosMap"),
	SHIRT_STANDARD_OPTION_CODE11("00011","setOsPinHolePinMap"),
	SHIRT_STANDARD_OPTION_CODE12("00012","setOsBreastPkMap"),
	SHIRT_STANDARD_OPTION_CODE13("00013","setOsFrontDesignMap"),
	SHIRT_STANDARD_OPTION_CODE14("00014","setOsPinTackMap"),
	SHIRT_STANDARD_OPTION_CODE15("00015","setOsStitchMap"),
	SHIRT_STANDARD_OPTION_CODE16("00016","setOsColorKeeperMap"),
	SHIRT_STANDARD_OPTION_CODE17("00017","setOsByColorMap"),
	SHIRT_STANDARD_OPTION_CODE18("00018","setOsBhColorMap");
	
	
	private final String key;
	private final String value;
    
    private ShirtOptionStandardCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static ShirtOptionStandardCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static ShirtOptionStandardCodeEnum get(String str) {
        for (ShirtOptionStandardCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
