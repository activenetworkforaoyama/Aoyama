package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionCoTuxedoPriceEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	// valueOne:OptionFormのmethod,OptionGiletTuxedoInfo->メソッドに対応のget方法
	// valueTwo:OptionGiletTuxedoInfo>二次プロジェクトのGetメソッド
	// valueThree:OptionGiletTuxedoInfo->金額関連アイテムの入金
	// valueFour:Optionのjspページ->オプションのID
	// valueFive:Optionのjspページ->二次オプションのID
	// valueSix:OptionGiletTuxedoInfo->金額関連アイテムの価値
	
	GILET_TUXEDO_OPTION_CODE01("00001","getTgBreastPkt","","setGlBreastPktRtPrice","tg_breastPkt_id","","getGlBreastPktRtPrice"),//胸ポケット
	GILET_TUXEDO_OPTION_CODE02("00002","getTgWaistPkt","","setGlWaistPktRtPrice","tg_waistPkt_id","","getGlWaistPktRtPrice"),//腰ポケット
	GILET_TUXEDO_OPTION_CODE03("00003","getTgWaistPktSpec","","setGlWaistPktShapeRtPrice","tg_waistPktSpec_id","","getGlWaistPktShapeRtPrice"),//腰ポケット形状
	GILET_TUXEDO_OPTION_CODE04("00004","getTgWaistPktMate","","setGlWaistPktClothRtPrice","tg_waistPktMate_id","","getGlWaistPktClothRtPrice"),//腰ポケット素材
	GILET_TUXEDO_OPTION_CODE05("00051","getTgStitch","","setGlAmfStitchRtPrice","tg_stitch_id","","getGlAmfStitchRtPrice"),//ステッチ種類
	GILET_TUXEDO_OPTION_CODE11("00011","getTgBhColor","","setGlBtnholeColorRtPrice","tg_bhColor_id","","getGlBtnholeColorRtPrice"),//ボタンホール色指定
	GILET_TUXEDO_OPTION_CODE14("00014","getTgByColor","","setGlBtnthreadColorRtPrice","tg_byColor_id","","getGlBtnthreadColorRtPrice"),//ボタン付け糸指定
	GILET_TUXEDO_OPTION_CODE17("00017","getTgBackLiningMate","getTgBackLiningMateStkNo","setGlBackClothRtPrice","tg_backLiningMate","tg_backLiningMateStkNo","getGlBackClothRtPrice"),//背裏地素材
	GILET_TUXEDO_OPTION_CODE19("00019","getTgInsideLiningMate","getTgInsideLiningMateStkNo","setGlInnnerClothRtPrice","tg_insideLiningMate","tg_insideLiningMateStkNo","getGlInnnerClothRtPrice"),//内側裏地素材
	GILET_TUXEDO_OPTION_CODE21("00021","getTgFrontBtnMate","getTgFrontBtnMateStkNo","setGlFrtBtnRtPrice","tg_frontBtnMate","tg_frontBtnMateStkNo","getGlFrtBtnRtPrice"),//釦素材
	GILET_TUXEDO_OPTION_CODE23("00023","getTgBackBelt","","setGlBackBeltRtPrice","tg_backBelt","","getGlBackBeltRtPrice"),//バックベルト
	GILET_TUXEDO_OPTION_CODE24("00024","getTgWatchChain","","setGlWatchChainRtPrice","tg_watchChain_id","","getGlWatchChainRtPrice"),//ウォッチチェーン
	GILET_TUXEDO_OPTION_CODE50("00050","getTgGlossFablic","","setGlLookClothRtPrice","tg_GlossFablic","","getGlLookClothRtPrice");//拝絹地
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
    
    private GiletOptionCoTuxedoPriceEnum(String key, String valueOne, String valueTwo, String valueThree,
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
  
    public static GiletOptionCoTuxedoPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionCoTuxedoPriceEnum get(String str) {
        for (GiletOptionCoTuxedoPriceEnum e : values()) {
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
