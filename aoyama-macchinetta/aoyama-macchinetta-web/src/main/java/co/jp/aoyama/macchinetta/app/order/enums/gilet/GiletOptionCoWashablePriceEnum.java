package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionCoWashablePriceEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	// valueOne:OptionFormのmethod,OptionGiletWashableInfo->メソッドに対応のget方法
	// valueTwo:OptionGiletWashableInfo>二次プロジェクトのGetメソッド
	// valueThree:OptionGiletWashableInfo->金額関連アイテムの入金
	// valueFour:Optionのjspページ->オプションのID
	// valueFive:Optionのjspページ->二次オプションのID
	// valueSix:OptionGiletWashableInfo->金額関連アイテムの価値
	
	GILET_WASHABLE_OPTION_CODE01("00001","getWgBreastPkt","","setGlBreastPktRtPrice","wg_breastPkt_id","","getGlBreastPktRtPrice"),//胸ポケット
	GILET_WASHABLE_OPTION_CODE02("00002","getWgWaistPkt","","setGlWaistPktRtPrice","wg_waistPkt_id","","getGlWaistPktRtPrice"),//腰ポケット
	GILET_WASHABLE_OPTION_CODE03("00003","getWgWaistPktSpec","","setGlWaistPktShapeRtPrice","wg_waistPktSpec_id","","getGlWaistPktShapeRtPrice"),//腰ポケット形状
	GILET_WASHABLE_OPTION_CODE05("00051","getWgStitch","","setGlAmfStitchRtPrice","wg_stitch_id","","getGlAmfStitchRtPrice"),//ステッチ種類
	GILET_WASHABLE_OPTION_CODE06("00006","getWgStitchModify","","setGlStitchPlcRtPrice","wg_stitchModify_id","","getGlStitchPlcRtPrice"),//ステッチ箇所変更
	GILET_WASHABLE_OPTION_CODE07("00026","getWgDStitchModify","","setGlDblstitchPlcRtPrice","wg_dStitchModify_id","","getGlDblstitchPlcRtPrice"),//ダブルステッチ変更
	GILET_WASHABLE_OPTION_CODE08("00008","getWgAmfColor","","setGlAmfColorRtPrice","wg_amfColor_id","","getGlAmfColorRtPrice"),//AMF色指定
	GILET_WASHABLE_OPTION_CODE11("00011","getWgBhColor","","setGlBtnholeColorRtPrice","wg_bhColor_id","","getGlBtnholeColorRtPrice"),//ボタンホール色指定
	GILET_WASHABLE_OPTION_CODE14("00014","getWgByColor","","setGlBtnthreadColorRtPrice","wg_byColor_id","","getGlBtnthreadColorRtPrice"),//ボタン付け糸指定
	GILET_WASHABLE_OPTION_CODE17("00017","getWgBackLiningMate","getWgBackLiningMateStkNo","setGlBackClothRtPrice","wg_backLiningMate","wg_backLiningMateStkNo","getGlBackClothRtPrice"),//背裏地素材
	GILET_WASHABLE_OPTION_CODE19("00019","getWgInsideLiningMate","getWgInsideLiningMateStkNo","setGlInnnerClothRtPrice","wg_insideLiningMate","wg_insideLiningMateStkNo","getGlInnnerClothRtPrice"),//内側裏地素材
	GILET_WASHABLE_OPTION_CODE21("00021","getWgFrontBtnMate","getWgFrontBtnMateStkNo","setGlFrtBtnRtPrice","wg_frontBtnMate","wg_frontBtnMateStkNo","getGlFrtBtnRtPrice"),//釦素材
	GILET_WASHABLE_OPTION_CODE23("00023","getWgBackBelt","","setGlBackBeltRtPrice","wg_backBelt","","getGlBackBeltRtPrice"),//バックベルト
	GILET_WASHABLE_OPTION_CODE24("00024","getWgWatchChain","","setGlWatchChainRtPrice","wg_watchChain_id","","getGlWatchChainRtPrice");//ウォッチチェーン
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
    
    private GiletOptionCoWashablePriceEnum(String key, String valueOne, String valueTwo, String valueThree,
			String valueFour, String valueFive, String valueSix) {
    	this.key = key;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
		this.valueThree = valueThree;
		this.valueFour = valueFour;
		this.valueFive = valueFive;
		this.valueSix = valueSix;
    }  

	public String toString() {
		 return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree)
	        		.concat(",").concat(this.valueFour).concat(",").concat(this.valueFive).concat(",").concat(this.valueSix);
    }  
  
    public static GiletOptionCoWashablePriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionCoWashablePriceEnum get(String str) {
        for (GiletOptionCoWashablePriceEnum e : values()) {
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

	public String getValueSix() {
		return valueSix;
	}

}
