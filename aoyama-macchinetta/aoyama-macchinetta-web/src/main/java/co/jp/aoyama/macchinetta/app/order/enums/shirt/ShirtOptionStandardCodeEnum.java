package co.jp.aoyama.macchinetta.app.order.enums.shirt;

public enum ShirtOptionStandardCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	SHIRT_STANDARD_OPTION_CODE01("00001","setOsChainModelMap"),
	SHIRT_STANDARD_OPTION_CODE02("00002","setOsCuffsMap"),
	SHIRT_STANDARD_OPTION_CODE03("00003","setOsConvertibleMap"),
	SHIRT_STANDARD_OPTION_CODE04("00004","setOsAdjustBtnMap"),
	SHIRT_STANDARD_OPTION_CODE05("00005","setOsClericSpecMap"),
	SHIRT_STANDARD_OPTION_CODE06("00006","setOsDblCuffMap"),
	SHIRT_STANDARD_OPTION_CODE07("00007","setOsAddCuffMap"),
	SHIRT_STANDARD_OPTION_CODE08("00008","setOsBtnMateMap"),
	SHIRT_STANDARD_OPTION_CODE09("00009","setOsTabBtnMap"),
	SHIRT_STANDARD_OPTION_CODE10("00010","setOsGaletteBtnPosMap"),
	SHIRT_STANDARD_OPTION_CODE11("00011","setOsPinHolePinMap"),
	SHIRT_STANDARD_OPTION_CODE12("00012","setOsBreastPkMap"),
	SHIRT_STANDARD_OPTION_CODE13("00013","setOsBreastPkSizeMap"),
	SHIRT_STANDARD_OPTION_CODE14("00014","setOsFrontDesignMap"),
	SHIRT_STANDARD_OPTION_CODE15("00015","setOsPinTackMap"),
	SHIRT_STANDARD_OPTION_CODE16("00016","setOsStitchMap"),
	SHIRT_STANDARD_OPTION_CODE17("00017","setOsColorKeeperMap"),
	SHIRT_STANDARD_OPTION_CODE18("00018","setOsByColorMap"),
	SHIRT_STANDARD_OPTION_CODE19("00019","setOsBhColorMap"),
	SHIRT_STANDARD_OPTION_CODE20("00020","setOsCasHemLineMap"),
	SHIRT_STANDARD_OPTION_CODE21("00021","setOsBtnPosChgMap");
	
	
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
