package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionStandardNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionGiletStandardInfoのoption_code
	// Value1:OptionGiletStandardInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	GILET_STANDARD_OPTION_CODE04("00001","getOgBreastPkt","setGlBreastPktWsWage","setGlBreastPktWsPrice","getGlBreastPktWsWage","getGlBreastPktWsPrice"),
	GILET_STANDARD_OPTION_CODE05("00005","getOgStitch","setGlAmfStitchWsWage","setGlAmfStitchWsPrice","getGlAmfStitchWsWage","getGlAmfStitchWsPrice");
//	GILET_STANDARD_OPTION_CODE17("00017","getOgBackLiningMate","setGlBackClothWsWage","setGlBackClothWsPrice","getGlBackClothWsWage","getGlBackClothWsPrice"),
//	GILET_STANDARD_OPTION_CODE19("00019","getOgInsideLiningMate","setGlInnnerClothWsWage","setGlInnnerClothWsPrice","getGlInnnerClothWsWage","getGlInnnerClothWsPrice"),
//	GILET_STANDARD_OPTION_CODE21("00021","getOgFrontBtnMate","setGlFrtBtnWsWage","setGlFrtBtnWsPrice","getGlFrtBtnWsWage","getGlFrtBtnWsPrice");
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	
    private GiletOptionStandardNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour =v4;
        this.valueFive =v5;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour).concat(",").concat(this.valueFive);
    }  
  
    public static GiletOptionStandardNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionStandardNextGenerationPriceEnum get(String str) {
        for (GiletOptionStandardNextGenerationPriceEnum e : values()) {
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
	
	public String getValueFour() {
		return valueFour;
	}
	
	public String getValueFive() {
		return valueFive;
	}

}
