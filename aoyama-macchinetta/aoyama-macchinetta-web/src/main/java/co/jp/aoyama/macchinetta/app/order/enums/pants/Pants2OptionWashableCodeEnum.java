package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2OptionWashableCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	PANTS_WASHABLE_OPTION_CODE01("00001","setWp2TackMap"),
	PANTS_WASHABLE_OPTION_CODE02("00002","setWp2KneeBackMap"),
	PANTS_WASHABLE_OPTION_CODE03("00003","setWp2KneeBackMateMap"),
	PANTS_WASHABLE_OPTION_CODE04("00004","setWp2FrontSpecMap"),
	PANTS_WASHABLE_OPTION_CODE05("00005","setWp2PancherinaMap"),
	PANTS_WASHABLE_OPTION_CODE06("00006","setWp2AdjusterMap"),
	PANTS_WASHABLE_OPTION_CODE07("00007","setWp2BeltLoopMap"),
	PANTS_WASHABLE_OPTION_CODE08("00008","setWp2BeltLoopPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE09("00009","setWp2PinLoopMap"),
	PANTS_WASHABLE_OPTION_CODE10("00010","setWp2SidePktMap"),
	PANTS_WASHABLE_OPTION_CODE11("00011","setWp2SinobiPktMap"),
	PANTS_WASHABLE_OPTION_CODE12("00012","setWp2CoinPktMap"),
	PANTS_WASHABLE_OPTION_CODE13("00013","setWp2FlapCoinPktMap"),
	PANTS_WASHABLE_OPTION_CODE14("00014","setWp2PisPktUfMap"),
	PANTS_WASHABLE_OPTION_CODE15("00015","setWp2PisPktDfMap"),
	PANTS_WASHABLE_OPTION_CODE16("00016","setWp2VCutMap"),
	PANTS_WASHABLE_OPTION_CODE17("00017","setWp2HemUpMap"),
	PANTS_WASHABLE_OPTION_CODE18("00018","setWp2DoubleWideMap"),
	PANTS_WASHABLE_OPTION_CODE19("00019","setWp2StitchMap"),
	PANTS_WASHABLE_OPTION_CODE20("00020","setWp2StitchModifyMap"),
	PANTS_WASHABLE_OPTION_CODE21("00021","setWp2StitchModifyPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE22("00022","setWp2DStitchMap"),
	PANTS_WASHABLE_OPTION_CODE23("00023","setWp2DStitchPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE24("00024","setWp2AmfColorMap"),
	PANTS_WASHABLE_OPTION_CODE25("00025","setWp2AmfColorPlaceAllMap"),
	PANTS_WASHABLE_OPTION_CODE26("00026","setWp2AmfColorPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE27("00027","setWp2BhColorMap"),
	PANTS_WASHABLE_OPTION_CODE28("00028","setWp2BhColorPlaceAllMap"),
	PANTS_WASHABLE_OPTION_CODE29("00029","setWp2BhColorPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE30("00030","setWp2ByColorMap"),
	PANTS_WASHABLE_OPTION_CODE31("00031","setWp2ByColorPlaceAllMap"),
	PANTS_WASHABLE_OPTION_CODE32("00032","setWp2ByColorPlaceMap"),
	PANTS_WASHABLE_OPTION_CODE33("00033","setWp2ButtonMap"),
	PANTS_WASHABLE_OPTION_CODE35("00035","setWp2SuspenderBtnMap"),
	PANTS_WASHABLE_OPTION_CODE36("00036","setWp2EightMap"),
	PANTS_WASHABLE_OPTION_CODE37("00037","setWp2ShapeMemoryMap"),
	PANTS_WASHABLE_OPTION_CODE38("00038","setWp2BlisterMap"),
	PANTS_WASHABLE_OPTION_CODE39("00039","setWp2SideStripeMap"),
	PANTS_WASHABLE_OPTION_CODE40("00040","setWp2SideStripeWidthMap"),
	PANTS_WASHABLE_OPTION_CODE41("00041","setWp2ThickMap");
	
	
	private final String key;
	private final String value;
    
    private Pants2OptionWashableCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static Pants2OptionWashableCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2OptionWashableCodeEnum get(String str) {
        for (Pants2OptionWashableCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
