package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletCoOptionWashableUpperPriceEnum {

	// OptionForm
	// Key:OptionGiletWashableInfoのoption_code
	// Value1:OptionGiletWashableInfoのmethod
	
	GILET_WASHABLE_OPTION_CODE01("00001","getWgBreastPkt","","wgBreastPktPrice","setGlBreastPktRtPrice"),//胸ポケット
	GILET_WASHABLE_OPTION_CODE02("00002","getWgWaistPkt","","wgWaistPktPrice","setGlWaistPktRtPrice"),//腰ポケット
	GILET_WASHABLE_OPTION_CODE03("00003","getWgWaistPktSpec","","wgWaistPktSpecPrice","setGlWaistPktShapeRtPrice"),//腰ポケット形状
	GILET_WASHABLE_OPTION_CODE05("00005","getWgStitch","","wgStitchPrice","setGlAmfStitchRtPrice"),//ステッチ種類
	GILET_WASHABLE_OPTION_CODE06("00006","getWgStitchModify","","wgStitchModifyPrice","setGlStitchPlcRtPrice"),//ステッチ箇所変更
	GILET_WASHABLE_OPTION_CODE07("00026","getWgDStitchModify","","wgDStitchModifyPrice","setGlDblstitchPlcRtPrice"),//ダブルステッチ変更
	GILET_WASHABLE_OPTION_CODE08("00008","getWgAmfColor","","wgAmfColorPrice","setGlAmfColorRtPrice"),//AMF色指定
	GILET_WASHABLE_OPTION_CODE11("00011","getWgBhColor","","wgBhColorPrice","setGlBtnholeColorRtPrice"),//ボタンホール色指定
	GILET_WASHABLE_OPTION_CODE14("00014","getWgByColor","","wgByColorPrice","setGlBtnthreadColorRtPrice"),//ボタン付け糸指定
	GILET_WASHABLE_OPTION_CODE17("00017","getWgBackLiningMate","getWgBackLiningMateStkNo","wgBackLiningMateStkNoPrice","setGlBackClothRtPrice"),//背裏地素材
	GILET_WASHABLE_OPTION_CODE19("00019","getWgInsideLiningMate","getWgInsideLiningMate","wgInsideLiningMatePrice","setGlInnnerClothRtPrice"),//内側裏地素材
	GILET_WASHABLE_OPTION_CODE21("00021","getWgFrontBtnMate","getWgFrontBtnMateStkNo","wgFrontBtnMateStkNoPrice","setGlFrtBtnRtPrice"),//釦素材
	GILET_WASHABLE_OPTION_CODE23("00023","getWgBackBelt","","wgBackBeltPrice","setGlBackBeltRtPrice"),//バックベルト
	GILET_WASHABLE_OPTION_CODE24("00024","getWgWatchChain","","wgWatchChainPrice","setGlWatchChainRtPrice");//ウォッチチェーン
	

	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	
    private GiletCoOptionWashableUpperPriceEnum(String k ,String v1 , String v2 , String v3 , String v4) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour = v4;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour);
    }  
  
    public static GiletCoOptionWashableUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletCoOptionWashableUpperPriceEnum get(String str) {
        for (GiletCoOptionWashableUpperPriceEnum e : values()) {
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
