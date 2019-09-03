package co.jp.aoyama.macchinetta.app.order.enums.coat;

public enum CoatCoOptionDetailStandardNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionCoatStandardInfoのoption_code
	// Value1:OptionCoatStandardInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	// Value6:orderのmethod
	
	COAT_STANDARD_OPTION_CODE11("00011","getOcBodyBackMate","getOcBodyBackMateStkNo","setGlBackClothWsWage","setGlBackClothWsPrice","getGlBackClothWsWage","getGlBackClothWsPrice"),//胴裏地素材
	COAT_STANDARD_OPTION_CODE12("00012","getOcCuffBackMate","getOcCuffBackMateStkNo","setGlInnnerClothWsWage","setGlInnnerClothWsPrice","getGlInnnerClothWsWage","getGlInnnerClothWsPrice"),//袖裏地素材
	COAT_STANDARD_OPTION_CODE13("00013","getOcFrontBtnMate","getOcFrontBtnMateStkNo","setGlFrtBtnWsWage","setGlFrtBtnWsPrice","getGlFrtBtnWsWage","getGlFrtBtnWsPrice");//釦素材
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
	
    private CoatCoOptionDetailStandardNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5,String v6) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour =v4;
        this.valueFive =v5;
        this.valueSix =v6;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour).concat(",").concat(this.valueFive).concat(",").concat(this.valueSix);
    }  
  
    public static CoatCoOptionDetailStandardNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoatCoOptionDetailStandardNextGenerationPriceEnum get(String str) {
        for (CoatCoOptionDetailStandardNextGenerationPriceEnum e : values()) {
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
	
	public String getValueSix() {
		return valueSix;
	}

}
