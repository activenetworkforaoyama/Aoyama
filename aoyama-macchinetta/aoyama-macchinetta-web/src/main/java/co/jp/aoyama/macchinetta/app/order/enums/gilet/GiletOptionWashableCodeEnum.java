package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionWashableCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	GILET_WASHABI_OPTION_CODE01("00001","setWgBreastPktMap"),
	GILET_WASHABI_OPTION_CODE02("00002","setWgWaistPktMap"),
	GILET_WASHABI_OPTION_CODE03("00003","setWgWaistPktSpecMap"),
	GILET_WASHABI_OPTION_CODE05("00005","setWgStitchMap"),
	GILET_WASHABI_OPTION_CODE06("00006","setWgStitchModifyMap"),
	GILET_WASHABI_OPTION_CODE07("00007","setWgStitchModifyPlaceMap"),
	GILET_WASHABI_OPTION_CODE08("00008","setWgAmfColorMap"),
	GILET_WASHABI_OPTION_CODE09("00009","setWgAmfColorPlaceMap"),
	GILET_WASHABI_OPTION_CODE10("00010","setWgAmfColorPlaceAllMap"),
	GILET_WASHABI_OPTION_CODE11("00011","setWgBhColorMap"),
	GILET_WASHABI_OPTION_CODE12("00012","setWgBhColorPlaceMap"),
	GILET_WASHABI_OPTION_CODE13("00013","setWgBhColorPlaceAllMap"),
	GILET_WASHABI_OPTION_CODE14("00014","setWgByColorMap"),
	GILET_WASHABI_OPTION_CODE15("00015","setWgByColorPlaceMap"),
	GILET_WASHABI_OPTION_CODE16("00016","setWgByColorPlaceAllMap"),
	GILET_WASHABI_OPTION_CODE17("00017","setWgBackLiningMateMap"),
	GILET_WASHABI_OPTION_CODE19("00019","setWgInsideLiningMateMap"),
	GILET_WASHABI_OPTION_CODE21("00021","setWgFrontBtnMateMap"),
	GILET_WASHABI_OPTION_CODE23("00023","setWgBackBeltMap"),
	GILET_WASHABI_OPTION_CODE24("00024","setWgWatchChainMap");
	
	
	private final String key;
	private final String value;
    
    private GiletOptionWashableCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static GiletOptionWashableCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionWashableCodeEnum get(String str) {
        for (GiletOptionWashableCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
