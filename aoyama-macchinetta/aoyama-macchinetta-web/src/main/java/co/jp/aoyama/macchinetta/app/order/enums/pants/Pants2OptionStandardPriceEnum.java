package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2OptionStandardPriceEnum {

	// OptionForm
	// Key:OptionPants2StandardInfo option_code
	// Value:OptionPants2StandardInfo method
	// Value:OptionPants2StandardInfo method
	// Value:order method
	
	PANTS_STANDARD_OPTION_CODE01("00001","getOp2Tack","","setPt2TackRtPrice"),
//	PANTS_STANDARD_OPTION_CODE02("00002","setOp2KneeBackMap","",""),
//	PANTS_STANDARD_OPTION_CODE03("00003","setOp2KneeBackMateMap","",""),
//	PANTS_STANDARD_OPTION_CODE04("00004","setOp2FrontSpecMap","",""),
//	PANTS_STANDARD_OPTION_CODE05("00005","setOp2PancherinaMap","",""),
	PANTS_STANDARD_OPTION_CODE06("00006","getOp2Adjuster","","setPt2AdjusterRtPrice"),
//	PANTS_STANDARD_OPTION_CODE07("00007","setOp2BeltLoopMap","",""),
//	PANTS_STANDARD_OPTION_CODE08("00008","setOp2BeltLoopPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE09("00009","setOp2PinLoopMap","",""),
//	PANTS_STANDARD_OPTION_CODE10("00010","setOp2SidePktMap","",""),
//	PANTS_STANDARD_OPTION_CODE11("00011","setOp2SinobiPktMap","",""),
//	PANTS_STANDARD_OPTION_CODE12("00012","setOp2CoinPktMap","",""),
//	PANTS_STANDARD_OPTION_CODE13("00013","setOp2FlapCoinPktMap","",""),
//	PANTS_STANDARD_OPTION_CODE14("00014","setOp2PisPktUfMap","",""),
//	PANTS_STANDARD_OPTION_CODE15("00015","setOp2PisPktDfMap","",""),
//	PANTS_STANDARD_OPTION_CODE16("00016","setOp2VCutMap","",""),
	PANTS_STANDARD_OPTION_CODE17("00017","getOp2HemUp","","setPt2HemUpRtPrice"),
	PANTS_STANDARD_OPTION_CODE18("00018","getOp2DoubleWide","","setPt2DblWidthRtPrice"),
//	PANTS_STANDARD_OPTION_CODE19("00019","getOp2Stitch","","setPt2AmfStitchRtPrice"),
//	PANTS_STANDARD_OPTION_CODE20("00020","setOp2StitchModifyMap","",""),
//	PANTS_STANDARD_OPTION_CODE21("00021","setOp2StitchModifyPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE22("00022","setOp2DStitchMap","",""),
//	PANTS_STANDARD_OPTION_CODE23("00023","setOp2DStitchPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE24("00024","setOp2AmfColorMap","",""),
//	PANTS_STANDARD_OPTION_CODE25("00025","setOp2AmfColorPlaceAllMap","",""),
//	PANTS_STANDARD_OPTION_CODE26("00026","setOp2AmfColorPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE27("00027","setOp2BhColorMap","",""),
//	PANTS_STANDARD_OPTION_CODE28("00028","setOp2BhColorPlaceAllMap","",""),
//	PANTS_STANDARD_OPTION_CODE29("00029","setOp2BhColorPlaceMap","",""),
//	PANTS_STANDARD_OPTION_CODE30("00030","setOp2ByColorMap","",""),
//	PANTS_STANDARD_OPTION_CODE31("00031","setOp2ByColorPlaceAllMap","",""),
//	PANTS_STANDARD_OPTION_CODE32("00032","setOp2ByColorPlaceMap","",""),
	PANTS_STANDARD_OPTION_CODE33("00033","getOp2Button","getOp2BtnMateStkNo","setPt2BtnMaterialRtPrice"),
//	PANTS_STANDARD_OPTION_CODE35("00035","setOp2SuspenderBtnMap","",""),
	PANTS_STANDARD_OPTION_CODE36("00036","getOp2Eight","","setPt2NonSlipRtPrice"),
//	PANTS_STANDARD_OPTION_CODE39("00039","setOp2SideStripeMap","",""),
//	PANTS_STANDARD_OPTION_CODE40("00040","setOp2SideStripeWidthMap","",""),
	PANTS_STANDARD_OPTION_CODE41("00041","getOp2Thick","","setPt2ChicSlipRtPrice"),
	PANTS_STANDARD_OPTION_CODE37("00037","getOp2ShapeMemory","","setPt2ShapeMemoryRtPrice"),
	PANTS_STANDARD_OPTION_CODE38("00038","getOp2Blister","","setPt2ShoeSoreRtPrice");
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private Pants2OptionStandardPriceEnum(String k ,String v1 , String v2 , String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static Pants2OptionStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2OptionStandardPriceEnum get(String str) {
        for (Pants2OptionStandardPriceEnum e : values()) {
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
