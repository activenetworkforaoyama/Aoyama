package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketCoOptionDetailWashableNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionJacketWashableInfo option_code
	// Value1:OptionJacketWashableInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	// Value6:orderのmethod
	
	
	JK_Washable_OPTION_CODE38("00038","getWjBodyBackMate","getWjBodyBackMateStkNo","setJkInnerBodyClothWsWage","setJkInnerBodyClothWsPrice","getJkInnerBodyClothWsWage","getJkInnerBodyClothWsPrice"),//胴裏素材
	JK_Washable_OPTION_CODE40("00040","getWjCuffBackMate","getWjCuffBackMateStkNo","setJkInnerSleeveClothWsWage","setJkInnerSleeveClothWsPrice","getJkInnerSleeveClothWsWage","getJkInnerSleeveClothWsPrice"),//袖裏素材
	JK_Washable_OPTION_CODE42("00042","getWjBtnMate","getWjBtnMateStkNo","setJkBtnMaterialWsWage","setJkBtnMaterialWsPrice","getJkBtnMaterialWsWage","getJkBtnMaterialWsPrice");//釦素材
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
	
    
    private JacketCoOptionDetailWashableNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5,String v6) {
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
  
    public static JacketCoOptionDetailWashableNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketCoOptionDetailWashableNextGenerationPriceEnum get(String str) {
        for (JacketCoOptionDetailWashableNextGenerationPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
