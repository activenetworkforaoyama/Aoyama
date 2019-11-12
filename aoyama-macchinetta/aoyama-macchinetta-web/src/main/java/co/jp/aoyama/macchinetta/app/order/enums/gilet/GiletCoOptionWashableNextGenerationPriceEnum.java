package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletCoOptionWashableNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionGiletWashableInfoのoption_code
	// Value1:OptionGiletWashableInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	GILET_WASHABLE_OPTION_CODE01("00001","getWgBreastPkt","setGlBreastPktWsWage","setGlBreastPktWsPrice","getGlBreastPktWsWage","getGlBreastPktWsPrice"),//胸ポケット
	GILET_WASHABLE_OPTION_CODE02("00002","getWgWaistPkt","setGlWaistPktWsWage","setGlWaistPktWsPrice","getGlWaistPktWsWage","getGlWaistPktWsPrice"),//腰ポケット
	GILET_WASHABLE_OPTION_CODE03("00003","getWgWaistPktSpec","setGlWaistPktShapeWsWage","setGlWaistPktShapeWsPrice","getGlWaistPktShapeWsWage","getGlWaistPktShapeWsPrice"),//腰ポケット形状
	GILET_WASHABLE_OPTION_CODE05("00051","getWgStitch","setGlAmfStitchWsWage","setGlAmfStitchWsPrice","getGlAmfStitchWsWage","getGlAmfStitchWsPrice"),//ステッチ種類
	GILET_WASHABLE_OPTION_CODE06("00006","getWgStitchModify","setGlStitchPlcWsWage","setGlStitchPlcWsPrice","getGlStitchPlcWsWage","getGlStitchPlcWsPrice"),//ステッチ箇所変更
	GILET_WASHABLE_OPTION_CODE07("00026","getWgDStitchModify","setGlDblstitchPlcWsWage","setGlDblstitchPlcWsPrice","getGlDblstitchPlcWsWage","getGlDblstitchPlcWsPrice"),//ダブルステッチ変更
	GILET_WASHABLE_OPTION_CODE08("00008","getWgAmfColor","setGlAmfColorWsWage","setGlAmfColorWsPrice","getGlAmfColorWsWage","getGlAmfColorWsPrice"),//AMF色指定
	GILET_WASHABLE_OPTION_CODE11("00011","getWgBhColor","setGlBtnholeColorWsWage","setGlBtnholeColorWsPrice","getGlBtnholeColorWsWage","getGlBtnholeColorWsPrice"),//ボタンホール色指定
	GILET_WASHABLE_OPTION_CODE14("00014","getWgByColor","setGlBtnthreadColorWsWage","setGlBtnthreadColorWsPrice","getGlBtnthreadColorWsWage","getGlBtnthreadColorWsPrice"),//ボタン付け糸指定
	GILET_WASHABLE_OPTION_CODE23("00023","getWgBackBelt","setGlBackBeltWsWage","setGlBackBeltWsPrice","getGlBackBeltWsWage","getGlBackBeltWsPrice"),//バックベルト
	GILET_WASHABLE_OPTION_CODE24("00024","getWgWatchChain","setGlWatchChainWsWage","setGlWatchChainWsPrice","getGlWatchChainWsWage","getGlWatchChainWsPrice");//ウォッチチェーン
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	
    private GiletCoOptionWashableNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5) {
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
  
    public static GiletCoOptionWashableNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletCoOptionWashableNextGenerationPriceEnum get(String str) {
        for (GiletCoOptionWashableNextGenerationPriceEnum e : values()) {
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
