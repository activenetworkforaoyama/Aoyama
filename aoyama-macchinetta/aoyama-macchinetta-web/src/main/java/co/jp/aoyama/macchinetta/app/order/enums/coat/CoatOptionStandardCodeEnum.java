package co.jp.aoyama.macchinetta.app.order.enums.coat;

public enum CoatOptionStandardCodeEnum {

	// OptionForm
	// Key:mtb_optionのoption_code
	// Value:OptionFormのmethod
	
	COAT_STANDARD_OPTION_CODE01("00001","setOcLapelDesignMap"),
	COAT_STANDARD_OPTION_CODE02("00002","setOcWaistPktMap"),
	COAT_STANDARD_OPTION_CODE03("00003","setOcChangePktMap"),
	COAT_STANDARD_OPTION_CODE04("00004","setOcSlantedPktMap"),
	COAT_STANDARD_OPTION_CODE05("00005","setOcVentSpecMap"),
	COAT_STANDARD_OPTION_CODE06("00006","setOcFrontBtnCntMap"),
	COAT_STANDARD_OPTION_CODE07("00007","setOcCuffSpecMap"),
	COAT_STANDARD_OPTION_CODE08("00008","setOcSleeveBtnTypeMap"),
	COAT_STANDARD_OPTION_CODE09("00009","setOcBackBeltMap"),
	COAT_STANDARD_OPTION_CODE10("00010","setOcChainHangeMap"),
	COAT_STANDARD_OPTION_CODE11("00011","setOcBodyBackMateMap"),
	COAT_STANDARD_OPTION_CODE12("00012","setOcCuffBackMateMap"),
	COAT_STANDARD_OPTION_CODE13("00013","setOcFrontBtnMateMap"),
	COAT_STANDARD_OPTION_CODE14("00014","setOcSleeveSpecMap");
	
	
	private final String key;
	private final String value;
    
    private CoatOptionStandardCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static CoatOptionStandardCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoatOptionStandardCodeEnum get(String str) {
        for (CoatOptionStandardCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
