package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletCoOptionTuxedoNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionGiletTuxedoInfoのoption_code
	// Value1:OptionGiletTuxedoInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	GILET_TUXEDO_OPTION_CODE01("00001","getTgBreastPkt","setGlBreastPktWsWage","setGlBreastPktWsPrice","getGlBreastPktWsWage","getGlBreastPktWsPrice"),//胸ポケット
	GILET_TUXEDO_OPTION_CODE02("00002","getTgWaistPkt","setGlWaistPktWsWage","setGlWaistPktWsPrice","getGlWaistPktWsWage","getGlWaistPktWsPrice"),//腰ポケット
	GILET_TUXEDO_OPTION_CODE03("00003","getTgWaistPktSpec","setGlWaistPktShapeWsWage","setGlWaistPktShapeWsPrice","getGlWaistPktShapeWsWage","getGlWaistPktShapeWsPrice"),//腰ポケット形状
	GILET_TUXEDO_OPTION_CODE04("00004","getTgWaistPktMate","setGlWaistPktClothWsWage","setGlWaistPktClothWsPrice","getGlWaistPktClothWsWage","getGlWaistPktClothWsPrice"),//腰ポケット素材
	GILET_TUXEDO_OPTION_CODE05("00005","getTgStitch","setGlAmfStitchWsWage","setGlAmfStitchWsPrice","getGlAmfStitchWsWage","getGlAmfStitchWsPrice"),//ステッチ種類
	GILET_TUXEDO_OPTION_CODE11("00011","getTgBhColor","setGlBtnholeColorWsWage","setGlBtnholeColorWsPrice","getGlBtnholeColorWsWage","getGlBtnholeColorWsPrice"),//ボタンホール色指定
	GILET_TUXEDO_OPTION_CODE14("00014","getTgByColor","setGlBtnthreadColorWsWage","setGlBtnthreadColorWsPrice","getGlBtnthreadColorWsWage","getGlBtnthreadColorWsPrice"),//ボタン付け糸指定
	GILET_TUXEDO_OPTION_CODE23("00023","getTgBackBelt","setGlBackBeltWsWage","setGlBackBeltWsPrice","getGlBackBeltWsWage","getGlBackBeltWsPrice"),//バックベルト
	GILET_TUXEDO_OPTION_CODE24("00024","getTgWatchChain","setGlWatchChainWsWage","setGlWatchChainWsPrice","getGlWatchChainWsWage","getGlWatchChainWsPrice");//ウォッチチェーン
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	
    private GiletCoOptionTuxedoNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5) {
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
  
    public static GiletCoOptionTuxedoNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletCoOptionTuxedoNextGenerationPriceEnum get(String str) {
        for (GiletCoOptionTuxedoNextGenerationPriceEnum e : values()) {
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
