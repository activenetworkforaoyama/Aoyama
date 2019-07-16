package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionStandardCodeEnum {

	// OptionForm
	// Key:mtb_option option_code
	// Value:OptionForm method
	
	PANTS_STANDARD_OPTION_CODE01("00001","setOpTackMap"),
	PANTS_STANDARD_OPTION_CODE02("00002","setOpKneeBackMap"),
	PANTS_STANDARD_OPTION_CODE03("00003","setOpKneeBackMateMap"),
	PANTS_STANDARD_OPTION_CODE04("00004","setOpFrontSpecMap"),
	PANTS_STANDARD_OPTION_CODE05("00005","setOpPancherinaMap"),
	PANTS_STANDARD_OPTION_CODE06("00006","setOpAdjusterMap"),
	PANTS_STANDARD_OPTION_CODE07("00007","setOpBeltLoopMap"),
	PANTS_STANDARD_OPTION_CODE08("00008","setOpBeltLoopPlaceMap"),
	PANTS_STANDARD_OPTION_CODE09("00009","setOpPinLoopMap"),
	PANTS_STANDARD_OPTION_CODE10("00010","setOpSidePktMap"),
	PANTS_STANDARD_OPTION_CODE11("00011","setOpSinobiPktMap"),
	PANTS_STANDARD_OPTION_CODE12("00012","setOpCoinPktMap"),
	PANTS_STANDARD_OPTION_CODE13("00013","setOpFlapCoinPktMap"),
	PANTS_STANDARD_OPTION_CODE14("00014","setOpPisPktUfMap"),
	PANTS_STANDARD_OPTION_CODE15("00015","setOpPisPktDfMap"),
	PANTS_STANDARD_OPTION_CODE16("00016","setOpVCutMap"),
	PANTS_STANDARD_OPTION_CODE17("00017","setOpHemUpMap"),
	PANTS_STANDARD_OPTION_CODE18("00018","setOpDoubleWideMap"),
	PANTS_STANDARD_OPTION_CODE19("00019","setOpStitchMap"),
	PANTS_STANDARD_OPTION_CODE20("00020","setOpStitchModifyMap"),
	PANTS_STANDARD_OPTION_CODE21("00021","setOpStitchModifyPlaceMap"),
	PANTS_STANDARD_OPTION_CODE22("00022","setOpDStitchMap"),
	PANTS_STANDARD_OPTION_CODE23("00023","setOpDStitchPlaceMap"),
	PANTS_STANDARD_OPTION_CODE24("00024","setOpAmfColorMap"),
	PANTS_STANDARD_OPTION_CODE25("00025","setOpAmfColorPlaceAllMap"),
	PANTS_STANDARD_OPTION_CODE26("00026","setOpAmfColorPlaceMap"),
	PANTS_STANDARD_OPTION_CODE27("00027","setOpBhColorMap"),
	PANTS_STANDARD_OPTION_CODE28("00028","setOpBhColorPlaceAllMap"),
	PANTS_STANDARD_OPTION_CODE29("00029","setOpBhColorPlaceMap"),
	PANTS_STANDARD_OPTION_CODE30("00030","setOpByColorMap"),
	PANTS_STANDARD_OPTION_CODE31("00031","setOpByColorPlaceAllMap"),
	PANTS_STANDARD_OPTION_CODE32("00032","setOpByColorPlaceMap"),
	PANTS_STANDARD_OPTION_CODE33("00033","setOpButtonMap"),
	PANTS_STANDARD_OPTION_CODE35("00035","setOpSuspenderBtnMap"),
	PANTS_STANDARD_OPTION_CODE36("00036","setOpEightMap"),
	PANTS_STANDARD_OPTION_CODE37("00037","setOpShapeMemoryMap"),
	PANTS_STANDARD_OPTION_CODE38("00038","setOpBlisterMap"),
	PANTS_STANDARD_OPTION_CODE39("00039","setOpSideStripeMap"),
	PANTS_STANDARD_OPTION_CODE40("00040","setOpSideStripeWidthMap"),
	PANTS_STANDARD_OPTION_CODE41("00041","setOpThickMap"),
	PANTS_STANDARD_OPTION_CODE99("00099","setTwoPantsMap");
	
	private final String key;
	private final String value;
    
    private PantsOptionStandardCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static PantsOptionStandardCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionStandardCodeEnum get(String str) {
        for (PantsOptionStandardCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
