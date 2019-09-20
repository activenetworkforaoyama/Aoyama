package co.jp.aoyama.macchinetta.app.order.enums.coat;

public enum CoatCoOptionStandardNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionCoatStandardInfoのoption_code
	// Value1:OptionCoatStandardInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	COAT_STANDARD_OPTION_CODE01("00001","getOcLapelDesign","setCtLapelDesignWsWage","setCtLapelDesignWsPrice","getCtLapelDesignWsWage","getCtLapelDesignWsPrice"),//ラペルデザイン
	COAT_STANDARD_OPTION_CODE02("00002","getOcWaistPkt","setCtWaistPktWsWage","setCtWaistPktWsPrice","getCtWaistPktWsWage","getCtWaistPktWsPrice"),//腰ポケット
	COAT_STANDARD_OPTION_CODE03("00003","getOcChangePkt","setCtChgPktWsWage","setCtChgPktWsPrice","getCtChgPktWsWage","getCtChgPktWsPrice"),//チェンジポケット
	COAT_STANDARD_OPTION_CODE04("00004","getOcSlantedPkt","setCtSlantedPktWsWage","setCtSlantedPktWsPrice","getCtSlantedPktWsWage","getCtSlantedPktWsPrice"),//スランテッドポケット
	COAT_STANDARD_OPTION_CODE05("00005","getOcVentSpec","setCtVentWsWage","setCtVentWsPrice","getCtVentWsWage","getCtVentWsPrice"),//ベント
	COAT_STANDARD_OPTION_CODE06("00006","getOcFrontBtnCnt","setCtFrtBtnWsWage","setCtFrtBtnWsPrice","getCtFrtBtnWsWage","getCtFrtBtnWsPrice"),//フロント釦数
	COAT_STANDARD_OPTION_CODE07("00007","getOcCuffSpec","setCtCuffWsWage","setCtCuffWsPrice","getCtCuffWsWage","getCtCuffWsPrice"),//袖口
	COAT_STANDARD_OPTION_CODE08("00008","getOcSleeveBtnType","setCtSleeveBtnWsWage","setCtSleeveBtnWsPrice","getCtSleeveBtnWsWage","getCtSleeveBtnWsPrice"),//袖釦
	COAT_STANDARD_OPTION_CODE09("00009","getOcBackBelt","setCtBackBeltWsWage","setCtBackBeltWsPrice","getCtBackBeltWsWage","getCtBackBeltWsPrice"),//バックベルト
	COAT_STANDARD_OPTION_CODE10("00010","getOcChainHange","setCtCollarHangWsWage","setCtCollarHangWsPrice","getCtCollarHangWsWage","getCtCollarHangWsPrice"),//襟吊
	COAT_STANDARD_OPTION_CODE14("00014","getOcSleeveSpec","setCtSleeveTypeWsWage","setCtSleeveTypeWsPrice","getCtSleeveTypeWsWage","getCtSleeveTypeWsPrice");//袖仕様
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	
    private CoatCoOptionStandardNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5) {
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
  
    public static CoatCoOptionStandardNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoatCoOptionStandardNextGenerationPriceEnum get(String str) {
        for (CoatCoOptionStandardNextGenerationPriceEnum e : values()) {
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
