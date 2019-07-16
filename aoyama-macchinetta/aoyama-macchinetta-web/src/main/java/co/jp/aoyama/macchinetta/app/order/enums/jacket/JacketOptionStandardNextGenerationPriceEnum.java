package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionStandardNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionJacketStandardInfo option_code
	// Value1:OptionJacketStandardInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	JK_Standard_OPTION_CODE01("00001","getOjFrontBtnCnt","setJkFrtBtnWsWage","setJkFrtBtnWsPrice","getJkFrtBtnWsWage","getJkFrtBtnWsPrice"),
	JK_Standard_OPTION_CODE02("00002","getOjLapelDesign","setJkLapelDesignWsWage","setJkLapelDesignWsPrice","getJkLapelDesignWsWage","getJkLapelDesignWsPrice"),
	JK_Standard_OPTION_CODE04("00004","getOjGackSpec","setJkInnerClothWsWage","setJkInnerClothWsPrice","getJkInnerClothWsWage","getJkInnerClothWsPrice"),
	JK_Standard_OPTION_CODE05("00005","getOjFort","setJkDaibaWsWage","setJkDaibaWsPrice","getJkDaibaWsWage","getJkDaibaWsPrice"),
	JK_Standard_OPTION_CODE12("00012","getOjWaistPkt","setJkWaistPktWsWage","setJkWaistPktWsPrice","getJkWaistPktWsWage","getJkWaistPktWsPrice"),
	JK_Standard_OPTION_CODE13("00013","getOjChangePkt","setJkChgPktWsWage","setJkChgPktWsPrice","getJkChgPktWsWage","getJkChgPktWsPrice"),
	JK_Standard_OPTION_CODE14("00014","getOjSlantedPkt","setJkSlantedPktWsWage","setJkSlantedPktWsPrice","getJkSlantedPktWsWage","getJkSlantedPktWsPrice"),
	JK_Standard_OPTION_CODE19("00019","getOjCuffSpec","setJkCuffWsWage","setJkCuffWsPrice","getJkCuffWsWage","getJkCuffWsPrice"),
	JK_Standard_OPTION_CODE23("00023","getOjStitch","setJkStitchTypeWsWage","setJkStitchTypeWsPrice","getJkStitchTypeWsWage","getJkStitchTypeWsPrice"),
	JK_Standard_OPTION_CODE37("00037","getOjVentSpec","setJkVentWsWage","setJkVentWsPrice","getJkVentWsWage","getJkVentWsPrice");
//	JK_Standard_OPTION_CODE38("00038","getOjBodyBackMate","setJkInnerBodyClothWsWage","setJkInnerBodyClothWsPrice","getJkInnerBodyClothWsWage","getJkInnerBodyClothWsPrice"),
//	JK_Standard_OPTION_CODE40("00040","getOjCuffBackMate","setJkInnerSleeveClothWsWage","setJkInnerSleeveClothWsPrice","getJkInnerSleeveClothWsWage","getJkInnerSleeveClothWsPrice"),
//	JK_Standard_OPTION_CODE42("00042","getOjBtnMate","setJkBtnMaterialWsWage","setJkBtnMaterialWsPrice","getJkBtnMaterialWsWage","getJkBtnMaterialWsPrice"),
//	JK_Standard_OPTION_CODE44("00044","getOjShapeMemory","setJkShapeMemoryWsWage","setJkShapeMemoryWsPrice","getJkShapeMemoryWsWage","getJkShapeMemoryWsPrice");
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	
    
    private JacketOptionStandardNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5) {
    	this.key = k;
    	this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree =v3;
        this.valueFour =v4;
        this.valueFive =v5;
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
	
	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour).concat(",").concat(this.valueFive);
    }  
  
    public static JacketOptionStandardNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionStandardNextGenerationPriceEnum get(String str) {
        for (JacketOptionStandardNextGenerationPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
