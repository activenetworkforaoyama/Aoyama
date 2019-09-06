package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletCoOptionStandardNextUpperPriceEnum {

	// OptionForm
	// Key:OptionGiletStandardInfoのoption_code
	// Value1:OptionGiletStandardInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	GILET_STANDARD_OPTION_CODE01("00001","getOgBreastPkt","","ogBreastPktPrice","setGlBreastPktRtPrice"),//胸ポケット
	GILET_STANDARD_OPTION_CODE02("00002","getOgWaistPkt","","ogWaistPktPrice","setGlWaistPktRtPrice"),//腰ポケット
	GILET_STANDARD_OPTION_CODE03("00003","getOgWaistPktSpec","","ogWaistPktSpecPrice","setGlWaistPktShapeRtPrice"),//腰ポケット形状
	GILET_STANDARD_OPTION_CODE05("00005","getOgStitch","","ogStitchPrice","setGlAmfStitchRtPrice"),//ステッチ種類
//	GILET_STANDARD_OPTION_CODE06("00006","getOgStitchModify","","ogStitchModifyPrice","setGlStitchPlcRtPrice"),//ステッチ箇所変更
	GILET_STANDARD_OPTION_CODE07("00026","getOgDStitchModify","","ogDStitchModifyPrice","setGlDblstitchPlcRtPrice"),//ダブルステッチ変更
//	GILET_STANDARD_OPTION_CODE08("00008","getOgAmfColor","","ogAmfColorPrice","setGlAmfColorRtPrice"),//AMF色指定
//	GILET_STANDARD_OPTION_CODE11("00011","getOgBhColor","","ogBhColorPrice","setGlBtnholeColorRtPrice"),//ボタンホール色指定
//	GILET_STANDARD_OPTION_CODE14("00014","getOgByColor","","ogByColorPrice","setGlBtnthreadColorRtPrice"),//ボタン付け糸指定
	GILET_STANDARD_OPTION_CODE17("00017","getOgBackLiningMate","getOgBackLiningMateStkNo","ogBackLiningMateStkNoPrice","setGlBackClothRtPrice"),//背裏地素材
	GILET_STANDARD_OPTION_CODE19("00019","getOgInsideLiningMate","getOgInsideLiningMateStkNo","ogInsideLiningMateStkNoPrice","setGlInnnerClothRtPrice"),//内側裏地素材
	GILET_STANDARD_OPTION_CODE21("00021","getOgFrontBtnMate","getOgFrontBtnMateStkNo","ogFrontBtnMateStkNoPrice","setGlFrtBtnRtPrice"),//釦素材
	GILET_STANDARD_OPTION_CODE23("00023","getOgBackBelt","","ogBackBeltPrice","setGlBackBeltRtPrice"),//バックベルト
	GILET_STANDARD_OPTION_CODE24("00024","getOgWatchChain","","ogWatchChainPrice","setGlWatchChainRtPrice");//ウォッチチェーン
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	
    private GiletCoOptionStandardNextUpperPriceEnum(String k ,String v1 , String v2 , String v3 , String v4) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour = v4;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour);
    }  
  
    public static GiletCoOptionStandardNextUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletCoOptionStandardNextUpperPriceEnum get(String str) {
        for (GiletCoOptionStandardNextUpperPriceEnum e : values()) {
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

}
