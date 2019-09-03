package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionWashableCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	PANTS_WASHABLE_OPTION_CODE01("00001","setWpTackMap"),
	PANTS_WASHABLE_OPTION_CODE02("00002","setWpKneeBackMap"),
	PANTS_WASHABLE_OPTION_CODE03("00003","setWpKneeBackMateMap"),
	PANTS_WASHABLE_OPTION_CODE04("00004","setWpFrontSpecMap"),
	PANTS_WASHABLE_OPTION_CODE05("00005","setWpPancherinaMap"),
	PANTS_WASHABLE_OPTION_CODE06("00006","setWpAdjusterMap"),
	PANTS_WASHABLE_OPTION_CODE07("00007","setWpBeltLoopMap"),
	PANTS_WASHABLE_OPTION_CODE08("00008","setWpBeltLoopPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE09("00009","setWpPinLoopMap"),
	PANTS_WASHABLE_OPTION_CODE10("00010","setWpSidePktMap"),
	PANTS_WASHABLE_OPTION_CODE11("00011","setWpSinobiPktMap"),
	PANTS_WASHABLE_OPTION_CODE12("00012","setWpCoinPktMap"),
	PANTS_WASHABLE_OPTION_CODE13("00013","setWpFlapCoinPktMap"),
	PANTS_WASHABLE_OPTION_CODE14("00014","setWpPisPktUfMap"),
	PANTS_WASHABLE_OPTION_CODE15("00015","setWpPisPktDfMap"),
	PANTS_WASHABLE_OPTION_CODE16("00016","setWpVCutMap"),
	PANTS_WASHABLE_OPTION_CODE17("00017","setWpHemUpMap"),
	PANTS_WASHABLE_OPTION_CODE18("00018","setWpDoubleWideMap"),
	PANTS_WASHABLE_OPTION_CODE19("00019","setWpStitchMap"),
	PANTS_WASHABLE_OPTION_CODE20("00020","setWpStitchModifyMap"),
	PANTS_WASHABLE_OPTION_CODE21("00021","setWpStitchModifyPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE22("00022","setWpDStitchMap"),
	PANTS_WASHABLE_OPTION_CODE23("00023","setWpDStitchPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE24("00024","setWpAmfColorMap"),
	PANTS_WASHABLE_OPTION_CODE25("00025","setWpAmfColorPlaceAllMap"),
	PANTS_WASHABLE_OPTION_CODE26("00026","setWpAmfColorPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE27("00027","setWpBhColorMap"),
	PANTS_WASHABLE_OPTION_CODE28("00028","setWpBhColorPlaceAllMap"),
	PANTS_WASHABLE_OPTION_CODE29("00029","setWpBhColorPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE30("00030","setWpByColorMap"),
	PANTS_WASHABLE_OPTION_CODE31("00031","setWpByColorPlaceAllMap"),
	PANTS_WASHABLE_OPTION_CODE32("00032","setWpByColorPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE33("00033","setWpButtonMap"),
	PANTS_WASHABLE_OPTION_CODE35("00035","setWpSuspenderBtnMap"),
	PANTS_WASHABLE_OPTION_CODE36("00036","setWpEightMap"),
	PANTS_WASHABLE_OPTION_CODE37("00037","setWpShapeMemoryMap"),
	PANTS_WASHABLE_OPTION_CODE38("00038","setWpBlisterMap"),
	PANTS_WASHABLE_OPTION_CODE39("00039","setWpSideStripeMap"),
	PANTS_WASHABLE_OPTION_CODE40("00040","setWpSideStripeWidthMap"),
	PANTS_WASHABLE_OPTION_CODE41("00041","setWpThickMap");
	
	
	private final String key;
	private final String value;
    
    private PantsOptionWashableCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static PantsOptionWashableCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionWashableCodeEnum get(String str) {
        for (PantsOptionWashableCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
