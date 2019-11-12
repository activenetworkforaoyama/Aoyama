package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionCoStandardPriceEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// valueOne:OptionFormのmethod,OptionGiletStandardInfo->メソッドに対応のget方法
	// valueTwo:OptionGiletStandardInfo->二次プロジェクトのGetメソッド
	// valueThree:OptionGiletStandardInfo->金額関連アイテムの入金
	// valueFour:Optionのjspページ->オプションのID
	// valueFive:Optionのjspページ->二次オプションのID
	// valueSix:OptionGiletStandardInfo->金額関連アイテムの価値
	
	GILET_STANDARD_OPTION_CODE01("00001","getOgBreastPkt","","setGlBreastPktRtPrice","og_breastPkt_id","","getGlBreastPktRtPrice"),//胸ポケット
	GILET_STANDARD_OPTION_CODE02("00002","getOgWaistPkt","","setGlWaistPktRtPrice","og_waistPkt_id","","getGlWaistPktRtPrice"),//腰ポケット
	GILET_STANDARD_OPTION_CODE03("00003","getOgWaistPktSpec","","setGlWaistPktShapeRtPrice","og_waistPktSpec_id","","getGlWaistPktShapeRtPrice"),//腰ポケット形状
	GILET_STANDARD_OPTION_CODE05("00051","getOgStitch","","setGlAmfStitchRtPrice","og_stitch_id","","getGlAmfStitchRtPrice"),//ステッチ種類
	GILET_STANDARD_OPTION_CODE06("00006","getOgStitchModify","","setGlStitchPlcRtPrice","og_stitchModify_id","","getGlStitchPlcRtPrice"),//ステッチ箇所変更
	GILET_STANDARD_OPTION_CODE07("00026","getOgDStitchModify","","setGlDblstitchPlcRtPrice","og_dStitchModify_id","","getGlDblstitchPlcRtPrice"),//ダブルステッチ変更
	GILET_STANDARD_OPTION_CODE08("00008","getOgAmfColor","","setGlAmfColorRtPrice","og_amfColor_id","","getGlAmfColorRtPrice"),//AMF色指定
	GILET_STANDARD_OPTION_CODE11("00011","getOgBhColor","","setGlBtnholeColorRtPrice","og_bhColor_id","","getGlBtnholeColorRtPrice"),//ボタンホール色指定
	GILET_STANDARD_OPTION_CODE14("00014","getOgByColor","","setGlBtnthreadColorRtPrice","og_byColor_id","","getGlBtnthreadColorRtPrice"),//ボタン付け糸指定
	GILET_STANDARD_OPTION_CODE17("00017","getOgBackLiningMate","getOgBackLiningMateStkNo","setGlBackClothRtPrice","og_backLiningMate","og_backLiningMateStkNo","getGlBackClothRtPrice"),//背裏地素材
	GILET_STANDARD_OPTION_CODE19("00019","getOgInsideLiningMate","getOgInsideLiningMateStkNo","setGlInnnerClothRtPrice","og_insideLiningMate","og_insideLiningMateStkNo","getGlInnnerClothRtPrice"),//内側裏地素材
	GILET_STANDARD_OPTION_CODE21("00021","getOgFrontBtnMate","getOgFrontBtnMateStkNo","setGlFrtBtnRtPrice","og_frontBtnMate","og_frontBtnMateStkNo","getGlFrtBtnRtPrice"),//釦素材
	GILET_STANDARD_OPTION_CODE23("00023","getOgBackBelt","","setGlBackBeltRtPrice","og_backBelt","","getGlBackBeltRtPrice"),//バックベルト
	GILET_STANDARD_OPTION_CODE24("00024","getOgWatchChain","","setGlWatchChainRtPrice","og_watchChain_id","","getGlWatchChainRtPrice");//ウォッチチェーン
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
	
    private GiletOptionCoStandardPriceEnum(String key, String valueOne, String valueTwo, String valueThree,
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

    public static GiletOptionCoStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionCoStandardPriceEnum get(String str) {
        for (GiletOptionCoStandardPriceEnum e : values()) {
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
