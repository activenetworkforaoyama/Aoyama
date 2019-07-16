package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2OptionStandardNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionPants2StandardInfoのoption_code
	// Value1:OptionPants2StandardInfoの method
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	PANTS_STANDARD_OPTION_CODE01("00001","getOp2Tack","setPt2TackWsWage","setPt2TackWsPrice","getPt2TackWsWage","getPt2TackWsPrice"),
	PANTS_STANDARD_OPTION_CODE06("00006","getOp2Adjuster","setPt2AdjusterWsWage","setPt2AdjusterWsPrice","getPt2AdjusterWsWage","getPt2AdjusterWsPrice"),
	PANTS_STANDARD_OPTION_CODE17("00017","getOp2HemUp","setPt2HemUpWsWage","setPt2HemUpWsPrice","getPt2HemUpWsWage","getPt2HemUpWsPrice"),
	PANTS_STANDARD_OPTION_CODE18("00018","getOp2DoubleWide","setPt2DblWidthWsWage","setPt2DblWidthWsPrice","getPt2DblWidthWsWage","getPt2DblWidthWsPrice"),
//	PANTS_STANDARD_OPTION_CODE19("00019","getOp2Stitch","setPt2AmfStitchWsWage","setPt2AmfStitchWsPrice","getPt2AmfStitchWsWage","getPt2AmfStitchWsPrice"),
//	PANTS_STANDARD_OPTION_CODE33("00033","getOp2Button","setPt2BtnMaterialWsWage","setPt2BtnMaterialWsPrice","getPt2BtnMaterialWsWage","getPt2BtnMaterialWsPrice"),
	PANTS_STANDARD_OPTION_CODE36("00036","getOp2Eight","setPt2NonSlipWsWage","setPt2NonSlipWsPrice","getPt2NonSlipWsWage","getPt2NonSlipWsPrice"),
	PANTS_STANDARD_OPTION_CODE41("00041","getOp2Thick","setPt2ChicSlipWsWage","setPt2ChicSlipWsPrice","getPt2ChicSlipWsWage","getPt2ChicSlipWsPrice"),
	PANTS_STANDARD_OPTION_CODE37("00037","getOp2ShapeMemory","setPt2ShapeMemoryWsWage","setPt2ShapeMemoryWsPrice","getPt2ShapeMemoryWsWage","getPt2ShapeMemoryWsPrice"),
	PANTS_STANDARD_OPTION_CODE38("00038","getOp2Blister","setPt2ShoeSoreWsWage","setPt2ShoeSoreWsPrice","getPt2ShoeSoreWsWage","getPt2ShoeSoreWsPrice");
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
    
    private Pants2OptionStandardNextGenerationPriceEnum(String k ,String v1 , String v2 , String v3, String v4, String v5 ) {
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
  
    public static Pants2OptionStandardNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2OptionStandardNextGenerationPriceEnum get(String str) {
        for (Pants2OptionStandardNextGenerationPriceEnum e : values()) {
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
		return this.valueFour;
	}
	
	public String getValueFive() {
		return this.valueFive;
	}
}
