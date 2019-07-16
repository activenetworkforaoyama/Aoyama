package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionStandardNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionPantsStandardInfoのoption_code
	// Value1:OptionPantsStandardInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	PANTS_STANDARD_OPTION_CODE01("00001","getOpTack","setPtTackWsWage","setPtTackWsPrice","getPtTackWsWage","getPtTackWsPrice"),
	PANTS_STANDARD_OPTION_CODE06("00006","getOpAdjuster","setPtAdjusterWsWage","setPtAdjusterWsPrice","getPtAdjusterWsWage","getPtAdjusterWsPrice"),
	PANTS_STANDARD_OPTION_CODE17("00017","getOpHemUp","setPtHemUpWsWage","setPtHemUpWsPrice","getPtHemUpWsWage","getPtHemUpWsPrice"),
	PANTS_STANDARD_OPTION_CODE18("00018","getOpDoubleWide","setPtDblWidthWsWage","setPtDblWidthWsPrice","getPtDblWidthWsWage","getPtDblWidthWsPrice"),
//	PANTS_STANDARD_OPTION_CODE19("00019","getOpStitch","setPtAmfStitchWsWage","setPtAmfStitchWsPrice","getPtAmfStitchWsWage","getPtAmfStitchWsPrice"),
//	PANTS_STANDARD_OPTION_CODE33("00033","getOpButton","setPtBtnMaterialWsWage","setPtBtnMaterialWsPrice","getPtBtnMaterialWsWage","getPtBtnMaterialWsPrice"),
	PANTS_STANDARD_OPTION_CODE36("00036","getOpEight","setPtNonSlipWsWage","setPtNonSlipWsPrice","getPtNonSlipWsWage","getPtNonSlipWsPrice"),
	PANTS_STANDARD_OPTION_CODE41("00041","getOpThick","setPtChicSlipWsWage","setPtChicSlipWsPrice","getPtChicSlipWsWage","getPtChicSlipWsPrice"),
	PANTS_STANDARD_OPTION_CODE37("00037","getOpShapeMemory","setPtShapeMemoryWsWage","setPtShapeMemoryWsPrice","getPtShapeMemoryWsWage","getPtShapeMemoryWsPrice"),
	PANTS_STANDARD_OPTION_CODE38("00038","getOpBlister","setPtShoeSoreWsWage","setPtShoeSoreWsPrice","getPtShoeSoreWsWage","getPtShoeSoreWsPrice");
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
    
    private PantsOptionStandardNextGenerationPriceEnum(String k ,String v1 ,String v2 , String v3, String v4, String v5 ) {
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
  
    public static PantsOptionStandardNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionStandardNextGenerationPriceEnum get(String str) {
        for (PantsOptionStandardNextGenerationPriceEnum e : values()) {
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
