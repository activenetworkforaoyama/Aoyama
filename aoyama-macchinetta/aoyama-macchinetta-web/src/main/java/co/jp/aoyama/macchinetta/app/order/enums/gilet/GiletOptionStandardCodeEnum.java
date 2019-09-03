package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionStandardCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	GILET_STANDARD_OPTION_CODE01("00001","setOgBreastPktMap"),
	GILET_STANDARD_OPTION_CODE02("00002","setOgWaistPktMap"),
	GILET_STANDARD_OPTION_CODE03("00003","setOgWaistPktSpecMap"),
	GILET_STANDARD_OPTION_CODE05("00005","setOgStitchMap"),
	GILET_STANDARD_OPTION_CODE06("00006","setOgStitchModifyMap"),
	GILET_STANDARD_OPTION_CODE07("00007","setOgStitchModifyPlaceMap"),
	GILET_STANDARD_OPTION_CODE08("00008","setOgAmfColorMap"),
	GILET_STANDARD_OPTION_CODE09("00009","setOgAmfColorPlaceMap"),
	GILET_STANDARD_OPTION_CODE10("00010","setOgAmfColorPlaceAllMap"),
	GILET_STANDARD_OPTION_CODE11("00011","setOgBhColorMap"),
	GILET_STANDARD_OPTION_CODE12("00012","setOgBhColorPlaceMap"),
	GILET_STANDARD_OPTION_CODE13("00013","setOgBhColorPlaceAllMap"),
	GILET_STANDARD_OPTION_CODE14("00014","setOgByColorMap"),
	GILET_STANDARD_OPTION_CODE15("00015","setOgByColorPlaceMap"),
	GILET_STANDARD_OPTION_CODE16("00016","setOgByColorPlaceAllMap"),
	GILET_STANDARD_OPTION_CODE17("00017","setOgBackLiningMateMap"),
	GILET_STANDARD_OPTION_CODE19("00019","setOgInsideLiningMateMap"),
	GILET_STANDARD_OPTION_CODE21("00021","setOgFrontBtnMateMap"),
	GILET_STANDARD_OPTION_CODE23("00023","setOgBackBeltMap"),
	GILET_STANDARD_OPTION_CODE24("00024","setOgWatchChainMap"),
	GILET_STANDARD_OPTION_CODE26("00026","setOgDStitchModifyMap"),
	GILET_STANDARD_OPTION_CODE27("00027","setOgDStitchModifyPlaceMap"),
	GILET_STANDARD_OPTION_CODE99("00099","setThreePieceMap");	
	
	private final String key;
	private final String value;
    
    private GiletOptionStandardCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static GiletOptionStandardCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionStandardCodeEnum get(String str) {
        for (GiletOptionStandardCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
