package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionTuxedoCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	PANTS_TUXEDO_OPTION_CODE01("00001","setTpTackMap"),
	PANTS_TUXEDO_OPTION_CODE02("00002","setTpKneeBackMap"),
	PANTS_TUXEDO_OPTION_CODE03("00003","setTpKneeBackMateMap"),
	PANTS_TUXEDO_OPTION_CODE04("00004","setTpFrontSpecMap"),
	PANTS_TUXEDO_OPTION_CODE05("00005","setTpPancherinaMap"),
	PANTS_TUXEDO_OPTION_CODE06("00006","setTpAdjusterMap"),
	PANTS_TUXEDO_OPTION_CODE07("00007","setTpBeltLoopMap"),
	PANTS_TUXEDO_OPTION_CODE08("00008","setTpBeltLoopPlaceMap"),
	PANTS_TUXEDO_OPTION_CODE09("00009","setTpPinLoopMap"),
	PANTS_TUXEDO_OPTION_CODE10("00010","setTpSidePktMap"),
	PANTS_TUXEDO_OPTION_CODE11("00011","setTpSinobiPktMap"),
	PANTS_TUXEDO_OPTION_CODE12("00012","setTpCoinPktMap"),
	PANTS_TUXEDO_OPTION_CODE13("00013","setTpFlapCoinPktMap"),
	PANTS_TUXEDO_OPTION_CODE14("00014","setTpPisPktUfMap"),
	PANTS_TUXEDO_OPTION_CODE15("00015","setTpPisPktDfMap"),
	PANTS_TUXEDO_OPTION_CODE16("00016","setTpVCutMap"),
	PANTS_TUXEDO_OPTION_CODE17("00017","setTpHemUpMap"),
	PANTS_TUXEDO_OPTION_CODE18("00018","setTpDoubleWideMap"),
	PANTS_TUXEDO_OPTION_CODE19("00019","setTpStitchMap"),
	PANTS_TUXEDO_OPTION_CODE27("00027","setTpBhColorMap"),
	PANTS_TUXEDO_OPTION_CODE28("00028","setTpBhColorPlaceAllMap"),
	PANTS_TUXEDO_OPTION_CODE29("00029","setTpBhColorPlaceMap"),
	PANTS_TUXEDO_OPTION_CODE30("00030","setTpByColorMap"),
	PANTS_TUXEDO_OPTION_CODE31("00031","setTpByColorPlaceAllMap"),
	PANTS_TUXEDO_OPTION_CODE32("00032","setTpByColorPlaceMap"),
	PANTS_TUXEDO_OPTION_CODE33("00033","setTpButtonMap"),
	PANTS_TUXEDO_OPTION_CODE35("00035","setTpSuspenderBtnMap"),
	PANTS_TUXEDO_OPTION_CODE36("00036","setTpEightMap"),
	PANTS_TUXEDO_OPTION_CODE37("00037","setTpShapeMemoryMap"),
	PANTS_TUXEDO_OPTION_CODE38("00038","setTpBlisterMap"),
	PANTS_TUXEDO_OPTION_CODE39("00039","setTpSideStripeMap"),
	PANTS_TUXEDO_OPTION_CODE40("00040","setTpSideStripeWidthMap");
	
	
	private final String key;
	private final String value;
    
    private PantsOptionTuxedoCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static PantsOptionTuxedoCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionTuxedoCodeEnum get(String str) {
        for (PantsOptionTuxedoCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
