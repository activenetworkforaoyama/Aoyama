package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletCoOptionStandardNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionGiletStandardInfoのoption_code
	// Value1:OptionGiletStandardInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	GILET_STANDARD_OPTION_CODE01("00001","getOgBreastPkt","setGlBreastPktWsWage","setGlBreastPktWsPrice","getGlBreastPktWsWage","getGlBreastPktWsPrice"),//胸ポケット
	GILET_STANDARD_OPTION_CODE02("00002","getOgWaistPkt","setGlWaistPktWsWage","setGlWaistPktWsPrice","getGlWaistPktWsWage","getGlWaistPktWsPrice"),//腰ポケット
	GILET_STANDARD_OPTION_CODE03("00003","getOgWaistPktSpec","setGlWaistPktShapeWsWage","setGlWaistPktShapeWsPrice","getGlWaistPktShapeWsWage","getGlWaistPktShapeWsPrice"),//腰ポケット形状
	GILET_STANDARD_OPTION_CODE05("00051","getOgStitch","setGlAmfStitchWsWage","setGlAmfStitchWsPrice","getGlAmfStitchWsWage","getGlAmfStitchWsPrice"),//ステッチ種類
	GILET_STANDARD_OPTION_CODE06("00006","getOgStitchModify","setGlStitchPlcWsWage","setGlStitchPlcWsPrice","getGlStitchPlcWsWage","getGlStitchPlcWsPrice"),//ステッチ箇所変更
	GILET_STANDARD_OPTION_CODE07("00026","getOgDStitchModify","setGlDblstitchPlcWsWage","setGlDblstitchPlcWsPrice","getGlDblstitchPlcWsWage","getGlDblstitchPlcWsPrice"),//ダブルステッチ変更
	GILET_STANDARD_OPTION_CODE08("00008","getOgAmfColor","setGlAmfColorWsWage","setGlAmfColorWsPrice","getGlAmfColorWsWage","getGlAmfColorWsPrice"),//AMF色指定
	GILET_STANDARD_OPTION_CODE11("00011","getOgBhColor","setGlBtnholeColorWsWage","setGlBtnholeColorWsPrice","getGlBtnholeColorWsWage","getGlBtnholeColorWsPrice"),//ボタンホール色指定
	GILET_STANDARD_OPTION_CODE14("00014","getOgByColor","setGlBtnthreadColorWsWage","setGlBtnthreadColorWsPrice","getGlBtnthreadColorWsWage","getGlBtnthreadColorWsPrice"),//ボタン付け糸指定
	GILET_STANDARD_OPTION_CODE17("00017","getOgBackLiningMate","setGlBackClothWsWage","setGlBackClothWsPrice","getGlBackClothWsWage","getGlBackClothWsPrice"),//背裏地素材
	GILET_STANDARD_OPTION_CODE23("00023","getOgBackBelt","setGlBackBeltWsWage","setGlBackBeltWsPrice","getGlBackBeltWsWage","getGlBackBeltWsPrice"),//バックベルト
	GILET_STANDARD_OPTION_CODE24("00024","getOgWatchChain","setGlWatchChainWsWage","setGlWatchChainWsPrice","getGlWatchChainWsWage","getGlWatchChainWsPrice");//ウォッチチェーン
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	
    private GiletCoOptionStandardNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5) {
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
  
    public static GiletCoOptionStandardNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletCoOptionStandardNextGenerationPriceEnum get(String str) {
        for (GiletCoOptionStandardNextGenerationPriceEnum e : values()) {
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
