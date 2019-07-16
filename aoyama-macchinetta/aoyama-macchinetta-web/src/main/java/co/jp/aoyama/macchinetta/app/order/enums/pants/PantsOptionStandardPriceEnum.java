package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionStandardPriceEnum {

	// OptionForm
	// Key:OptionPantsStandardInfo option_code
	// ValueOne:OptionPantsStandardInfo method
	// ValueTwo:OptionPantsStandardInfo method
	// ValueThree:order method
	
	PANTS_STANDARD_OPTION_CODE01("00001","getOpTack","","setPtTackRtPrice"),
//	PANTS_STANDARD_OPTION_CODE02("00002","setOpKneeBackMap","",""),
//	PANTS_STANDARD_OPTION_CODE03("00003","setOpKneeBackMateMap","",""),
//	PANTS_STANDARD_OPTION_CODE04("00004","setOpFrontSpecMap","",""),
//	PANTS_STANDARD_OPTION_CODE05("00005","setOpPancherinaMap","",""),
	PANTS_STANDARD_OPTION_CODE06("00006","getOpAdjuster","","setPtAdjusterRtPrice"),
//	PANTS_STANDARD_OPTION_CODE07("00007","setOpBeltLoopMap","",""),
//	PANTS_STANDARD_OPTION_CODE08("00008","setOpBeltLoopPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE09("00009","setOpPinLoopMap","",""),
//	PANTS_STANDARD_OPTION_CODE10("00010","setOpSidePktMap","",""),
//	PANTS_STANDARD_OPTION_CODE11("00011","setOpSinobiPktMap","",""),
//	PANTS_STANDARD_OPTION_CODE12("00012","setOpCoinPktMap","",""),
//	PANTS_STANDARD_OPTION_CODE13("00013","setOpFlapCoinPktMap","",""),
//	PANTS_STANDARD_OPTION_CODE14("00014","setOpPisPktUfMap","",""),
//	PANTS_STANDARD_OPTION_CODE15("00015","setOpPisPktDfMap","",""),
//	PANTS_STANDARD_OPTION_CODE16("00016","setOpVCutMap","",""),
	PANTS_STANDARD_OPTION_CODE17("00017","getOpHemUp","","setPtHemUpRtPrice"),
	PANTS_STANDARD_OPTION_CODE18("00018","getOpDoubleWide","","setPtDblWidthRtPrice"),
//	PANTS_STANDARD_OPTION_CODE19("00019","getOpStitch","","setPtAmfStitchRtPrice"),
//	PANTS_STANDARD_OPTION_CODE20("00020","setOpStitchModifyMap","",""),
//	PANTS_STANDARD_OPTION_CODE21("00021","setOpStitchModifyPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE22("00022","setOpDStitchMap","",""),
//	PANTS_STANDARD_OPTION_CODE23("00023","setOpDStitchPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE24("00024","setOpAmfColorMap","",""),
//	PANTS_STANDARD_OPTION_CODE25("00025","setOpAmfColorPlaceAllMap","",""),
//	PANTS_STANDARD_OPTION_CODE26("00026","setOpAmfColorPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE27("00027","setOpBhColorMap","",""),
//	PANTS_STANDARD_OPTION_CODE28("00028","setOpBhColorPlaceAllMap","",""),
//	PANTS_STANDARD_OPTION_CODE29("00029","setOpBhColorPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE30("00030","setOpByColorMap","",""),
//	PANTS_STANDARD_OPTION_CODE31("00031","setOpByColorPlaceAllMap","",""),
//	PANTS_STANDARD_OPTION_CODE32("00032","setOpByColorPlaceMap","",""),
	PANTS_STANDARD_OPTION_CODE33("00033","getOpButton","getOpBtnMateStkNo","setPtBtnMaterialRtPrice"),
//	PANTS_STANDARD_OPTION_CODE35("00035","setOpSuspenderBtnMap","",""),
	PANTS_STANDARD_OPTION_CODE36("00036","getOpEight","","setPtNonSlipRtPrice"),
//	PANTS_STANDARD_OPTION_CODE39("00039","setOpSideStripeMap","",""),
//	PANTS_STANDARD_OPTION_CODE40("00040","setOpSideStripeWidthMap","",""),
	PANTS_STANDARD_OPTION_CODE41("00041","getOpThick","","setPtChicSlipRtPrice"),
	PANTS_STANDARD_OPTION_CODE37("00037","getOpShapeMemory","","setPtShapeMemoryRtPrice"),
	PANTS_STANDARD_OPTION_CODE38("00038","getOpBlister","","setPtShoeSoreRtPrice");
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private PantsOptionStandardPriceEnum(String k ,String v1 ,String v2 , String v3 ) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static PantsOptionStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionStandardPriceEnum get(String str) {
        for (PantsOptionStandardPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
    
    public String getKey() {
    	return key;
    }
    
    public String getValueOne() {
    	return valueOne;
    }
    
    public String getValueTwo() {
    	return valueTwo;
    }
    
    public String getValueThree() {
    	return valueThree;
    }

}
