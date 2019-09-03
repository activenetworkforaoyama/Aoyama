package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2OptionTuxedoCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	PANTS_TUXEDO_OPTION_CODE01("00001","setTp2TackMap"),
	PANTS_TUXEDO_OPTION_CODE02("00002","setTp2KneeBackMap"),
	PANTS_TUXEDO_OPTION_CODE03("00003","setTp2KneeBackMateMap"),
	PANTS_TUXEDO_OPTION_CODE04("00004","setTp2FrontSpecMap"),
	PANTS_TUXEDO_OPTION_CODE05("00005","setTp2PancherinaMap"),
	PANTS_TUXEDO_OPTION_CODE06("00006","setTp2AdjusterMap"),
	PANTS_TUXEDO_OPTION_CODE07("00007","setTp2BeltLoopMap"),
	PANTS_TUXEDO_OPTION_CODE08("00008","setTp2BeltLoopPlaceMap"),
	PANTS_TUXEDO_OPTION_CODE09("00009","setTp2PinLoopMap"),
	PANTS_TUXEDO_OPTION_CODE10("00010","setTp2SidePktMap"),
	PANTS_TUXEDO_OPTION_CODE11("00011","setTp2SinobiPktMap"),
	PANTS_TUXEDO_OPTION_CODE12("00012","setTp2CoinPktMap"),
	PANTS_TUXEDO_OPTION_CODE13("00013","setTp2FlapCoinPktMap"),
	PANTS_TUXEDO_OPTION_CODE14("00014","setTp2PisPktUfMap"),
	PANTS_TUXEDO_OPTION_CODE15("00015","setTp2PisPktDfMap"),
	PANTS_TUXEDO_OPTION_CODE16("00016","setTp2VCutMap"),
	PANTS_TUXEDO_OPTION_CODE17("00017","setTp2HemUpMap"),
	PANTS_TUXEDO_OPTION_CODE18("00018","setTp2DoubleWideMap"),
	PANTS_TUXEDO_OPTION_CODE19("00019","setTp2StitchMap"),
	PANTS_TUXEDO_OPTION_CODE27("00027","setTp2BhColorMap"),
	PANTS_TUXEDO_OPTION_CODE28("00028","setTp2BhColorPlaceAllMap"),
	PANTS_TUXEDO_OPTION_CODE29("00029","setTp2BhColorPlaceMap"),
	PANTS_TUXEDO_OPTION_CODE30("00030","setTp2ByColorMap"),
	PANTS_TUXEDO_OPTION_CODE31("00031","setTp2ByColorPlaceAllMap"),
	PANTS_TUXEDO_OPTION_CODE32("00032","setTp2ByColorPlaceMap"),
	PANTS_TUXEDO_OPTION_CODE33("00033","setTp2ButtonMap"),
	PANTS_TUXEDO_OPTION_CODE35("00035","setTp2SuspenderBtnMap"),
	PANTS_TUXEDO_OPTION_CODE36("00036","setTp2EightMap"),
	PANTS_TUXEDO_OPTION_CODE37("00037","setTp2ShapeMemoryMap"),
	PANTS_TUXEDO_OPTION_CODE39("00039","setTp2SideStripeMap"),
	PANTS_TUXEDO_OPTION_CODE40("00040","setTp2SideStripeWidthMap"),
	PANTS_TUXEDO_OPTION_CODE41("00041","setTp2ThickMap");
	
	
	private final String key;
	private final String value;
    
    private Pants2OptionTuxedoCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static Pants2OptionTuxedoCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2OptionTuxedoCodeEnum get(String str) {
        for (Pants2OptionTuxedoCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
