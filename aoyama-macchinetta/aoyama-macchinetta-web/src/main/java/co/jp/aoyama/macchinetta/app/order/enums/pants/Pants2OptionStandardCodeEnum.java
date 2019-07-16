package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2OptionStandardCodeEnum {

	// OptionForm
	// Key:mtb_option option_code
	// Value:OptionForm method
	
	PANTS_STANDARD_OPTION_CODE01("00001","setOp2TackMap"),
	PANTS_STANDARD_OPTION_CODE02("00002","setOp2KneeBackMap"),
	PANTS_STANDARD_OPTION_CODE03("00003","setOp2KneeBackMateMap"),
	PANTS_STANDARD_OPTION_CODE04("00004","setOp2FrontSpecMap"),
	PANTS_STANDARD_OPTION_CODE05("00005","setOp2PancherinaMap"),
	PANTS_STANDARD_OPTION_CODE06("00006","setOp2AdjusterMap"),
	PANTS_STANDARD_OPTION_CODE07("00007","setOp2BeltLoopMap"),
	PANTS_STANDARD_OPTION_CODE08("00008","setOp2BeltLoopPlaceMap"),
	PANTS_STANDARD_OPTION_CODE09("00009","setOp2PinLoopMap"),
	PANTS_STANDARD_OPTION_CODE10("00010","setOp2SidePktMap"),
	PANTS_STANDARD_OPTION_CODE11("00011","setOp2SinobiPktMap"),
	PANTS_STANDARD_OPTION_CODE12("00012","setOp2CoinPktMap"),
	PANTS_STANDARD_OPTION_CODE13("00013","setOp2FlapCoinPktMap"),
	PANTS_STANDARD_OPTION_CODE14("00014","setOp2PisPktUfMap"),
	PANTS_STANDARD_OPTION_CODE15("00015","setOp2PisPktDfMap"),
	PANTS_STANDARD_OPTION_CODE16("00016","setOp2VCutMap"),
	PANTS_STANDARD_OPTION_CODE17("00017","setOp2HemUpMap"),
	PANTS_STANDARD_OPTION_CODE18("00018","setOp2DoubleWideMap"),
	PANTS_STANDARD_OPTION_CODE19("00019","setOp2StitchMap"),
	PANTS_STANDARD_OPTION_CODE20("00020","setOp2StitchModifyMap"),
	PANTS_STANDARD_OPTION_CODE21("00021","setOp2StitchModifyPlaceMap"),
	PANTS_STANDARD_OPTION_CODE22("00022","setOp2DStitchMap"),
	PANTS_STANDARD_OPTION_CODE23("00023","setOp2DStitchPlaceMap"),
	PANTS_STANDARD_OPTION_CODE24("00024","setOp2AmfColorMap"),
	PANTS_STANDARD_OPTION_CODE25("00025","setOp2AmfColorPlaceAllMap"),
	PANTS_STANDARD_OPTION_CODE26("00026","setOp2AmfColorPlaceMap"),
	PANTS_STANDARD_OPTION_CODE27("00027","setOp2BhColorMap"),
	PANTS_STANDARD_OPTION_CODE28("00028","setOp2BhColorPlaceAllMap"),
	PANTS_STANDARD_OPTION_CODE29("00029","setOp2BhColorPlaceMap"),
	PANTS_STANDARD_OPTION_CODE30("00030","setOp2ByColorMap"),
	PANTS_STANDARD_OPTION_CODE31("00031","setOp2ByColorPlaceAllMap"),
	PANTS_STANDARD_OPTION_CODE32("00032","setOp2ByColorPlaceMap"),
	PANTS_STANDARD_OPTION_CODE33("00033","setOp2ButtonMap"),
	PANTS_STANDARD_OPTION_CODE35("00035","setOp2SuspenderBtnMap"),
	PANTS_STANDARD_OPTION_CODE36("00036","setOp2EightMap"),
	PANTS_STANDARD_OPTION_CODE37("00037","setOp2ShapeMemoryMap"),
	PANTS_STANDARD_OPTION_CODE38("00038","setOp2BlisterMap"),
	PANTS_STANDARD_OPTION_CODE39("00039","setOp2SideStripeMap"),
	PANTS_STANDARD_OPTION_CODE40("00040","setOp2SideStripeWidthMap"),
	PANTS_STANDARD_OPTION_CODE41("00041","setOp2ThickMap");
	
	private final String key;
	private final String value;
    
    private Pants2OptionStandardCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static Pants2OptionStandardCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2OptionStandardCodeEnum get(String str) {
        for (Pants2OptionStandardCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
