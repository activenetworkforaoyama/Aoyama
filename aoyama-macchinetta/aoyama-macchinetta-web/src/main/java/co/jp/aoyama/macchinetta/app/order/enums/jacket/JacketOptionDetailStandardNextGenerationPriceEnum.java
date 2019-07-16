package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionDetailStandardNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionJacketStandardInfo option_code
	// Value1:OptionJacketStandardInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	// Value6:orderのmethod
	
	
	JK_Standard_OPTION_CODE38("00038","getOjBodyBackMate","getOjBodyBackMateStkNo","setJkInnerBodyClothWsWage","setJkInnerBodyClothWsPrice","getJkInnerBodyClothWsWage","getJkInnerBodyClothWsPrice"),
	JK_Standard_OPTION_CODE40("00040","getOjCuffBackMate","getOjCuffBackMateStkNo","setJkInnerSleeveClothWsWage","setJkInnerSleeveClothWsPrice","getJkInnerSleeveClothWsWage","getJkInnerSleeveClothWsPrice"),
	JK_Standard_OPTION_CODE42("00042","getOjBtnMate","getOjBtnMateStkNo","setJkBtnMaterialWsWage","setJkBtnMaterialWsPrice","getJkBtnMaterialWsWage","getJkBtnMaterialWsPrice");
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
	
    
    private JacketOptionDetailStandardNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5,String v6) {
    	this.key = k;
    	this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree =v3;
        this.valueFour =v4;
        this.valueFive =v5;
        this.valueSix =v6;
    }  

	public String getKey() {
		return this.key;
	}
	 
	public String getValueOne() {
		return this.valueOne;
	}
	
	public String getValueTwo() {
		return this.valueTwo;
	}
    
	public String getValueThree() {
		return this.valueThree;
	}
	
	public String getValueFour() {
		return this.valueFour;
	}
	
	public String getValueFive() {
		return this.valueFive;
	}
	
	public String getValueSix() {
		return this.valueSix;
	}
	
	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour).concat(",").concat(this.valueFive).concat(",").concat(this.valueSix);
    }  
  
    public static JacketOptionDetailStandardNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionDetailStandardNextGenerationPriceEnum get(String str) {
        for (JacketOptionDetailStandardNextGenerationPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
