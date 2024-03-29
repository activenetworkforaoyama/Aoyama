package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletCoOptionDetailWashableNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionGiletWashableInfoのoption_code
	// Value1:OptionGiletWashableInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	// Value6:orderのmethod
	
	GILET_WASHABLE_OPTION_CODE17("00017","getWgBackLiningMate","getWgBackLiningMateStkNo","setGlBackClothWsWage","setGlBackClothWsPrice","getGlBackClothWsWage","getGlBackClothWsPrice"),//背裏地素材
	GILET_WASHABLE_OPTION_CODE19("00019","getWgInsideLiningMate","getWgInsideLiningMateStkNo","setGlInnnerClothWsWage","setGlInnnerClothWsPrice","getGlInnnerClothWsWage","getGlInnnerClothWsPrice"),//内側裏地素材
	GILET_WASHABLE_OPTION_CODE21("00021","getWgFrontBtnMate","getWgFrontBtnMateStkNo","setGlFrtBtnWsWage","setGlFrtBtnWsPrice","getGlFrtBtnWsWage","getGlFrtBtnWsPrice");//釦素材
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
	
    private GiletCoOptionDetailWashableNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5,String v6) {
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
  
    public static GiletCoOptionDetailWashableNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletCoOptionDetailWashableNextGenerationPriceEnum get(String str) {
        for (GiletCoOptionDetailWashableNextGenerationPriceEnum e : values()) {
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
