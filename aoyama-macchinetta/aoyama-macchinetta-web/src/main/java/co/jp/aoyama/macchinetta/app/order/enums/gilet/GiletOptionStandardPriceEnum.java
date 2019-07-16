package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionStandardPriceEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
//	GILET_STANDARD_OPTION_CODE01("00001","","","setOgBreastPktMap"),
//	GILET_STANDARD_OPTION_CODE02("00002","","","setOgWaistPktMap"),
//	GILET_STANDARD_OPTION_CODE03("00003","","","setOgWaistPktSpecMap"),
	GILET_STANDARD_OPTION_CODE04("00001","getOgBreastPkt","","setGlBreastPktRtPrice"),
	GILET_STANDARD_OPTION_CODE05("00005","getOgStitch","","setGlAmfStitchRtPrice"),
//	GILET_STANDARD_OPTION_CODE06("00006","","","setOgStitchModifyMap"),
//	GILET_STANDARD_OPTION_CODE07("00007","","","setOgStitchModifyPlaceMap"),
//	GILET_STANDARD_OPTION_CODE08("00008","","","setOgAmfColorMap"),
//	GILET_STANDARD_OPTION_CODE09("00009","","","setOgAmfColorPlaceMap"),
//	GILET_STANDARD_OPTION_CODE10("00010","","","setOgAmfColorPlaceAllMap"),
//	GILET_STANDARD_OPTION_CODE11("00011","","","setOgBhColorMap"),
//	GILET_STANDARD_OPTION_CODE12("00012","","","setOgBhColorPlaceMap"),
//	GILET_STANDARD_OPTION_CODE13("00013","","","setOgBhColorPlaceAllMap"),
//	GILET_STANDARD_OPTION_CODE14("00014","","","setOgByColorMap"),
//	GILET_STANDARD_OPTION_CODE15("00015","","","setOgByColorPlaceMap"),
//	GILET_STANDARD_OPTION_CODE16("00016","","","setOgByColorPlaceAllMap"),
	GILET_STANDARD_OPTION_CODE17("00017","getOgBackLiningMate","getOgBackLiningMateStkNo","setGlBackClothRtPrice"),
	GILET_STANDARD_OPTION_CODE19("00019","getOgInsideLiningMate","getOgInsideLiningMateStkNo","setGlInnnerClothRtPrice"),
	GILET_STANDARD_OPTION_CODE21("00021","getOgFrontBtnMate","getOgFrontBtnMateStkNo","setGlFrtBtnRtPrice");
//	GILET_STANDARD_OPTION_CODE23("00023","","","setOgBackBeltMap"),
//	GILET_STANDARD_OPTION_CODE24("00024","","","setOgWatchChainMap");
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private GiletOptionStandardPriceEnum(String k ,String v1 ,String v2, String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static GiletOptionStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionStandardPriceEnum get(String str) {
        for (GiletOptionStandardPriceEnum e : values()) {
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
