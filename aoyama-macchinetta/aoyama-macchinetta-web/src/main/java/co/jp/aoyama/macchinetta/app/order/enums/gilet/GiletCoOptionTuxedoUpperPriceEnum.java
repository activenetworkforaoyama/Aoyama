package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletCoOptionTuxedoUpperPriceEnum {

	// OptionForm
	// Key:OptionGiletTuxedoInfoのoption_code
	// Value1:OptionGiletTuxedoInfoのmethod
	
	GILET_TUXEDO_OPTION_CODE01("00001","getTgBreastPkt","","tgBreastPktPrice","setGlBreastPktRtPrice"),//胸ポケット
	GILET_TUXEDO_OPTION_CODE02("00002","getTgWaistPkt","","tgWaistPktPrice","setGlWaistPktRtPrice"),//腰ポケット
	GILET_TUXEDO_OPTION_CODE03("00003","getTgWaistPktSpec","","tgWaistPktSpecPrice","setGlWaistPktShapeRtPrice"),//腰ポケット形状
	GILET_TUXEDO_OPTION_CODE04("00004","getTgWaistPktMate","","tgWaistPktMatePrice","setGlWaistPktClothRtPrice"),//腰ポケット素材
	GILET_TUXEDO_OPTION_CODE05("00005","getTgStitch","","tgStitchPrice","setGlAmfStitchRtPrice"),//ステッチ種類
	GILET_TUXEDO_OPTION_CODE11("00011","getTgBhColor","","tgBhColorPrice","setGlBtnholeColorRtPrice"),//ボタンホール色指定
	GILET_TUXEDO_OPTION_CODE14("00014","getTgByColor","","tgByColorPrice","setGlBtnthreadColorRtPrice"),//ボタン付け糸指定
	GILET_TUXEDO_OPTION_CODE17("00017","getTgBackLiningMate","getTgBackLiningMateStkNo","tgBackLiningMateStkNoPrice","setGlBackClothRtPrice"),//背裏地素材
	GILET_TUXEDO_OPTION_CODE19("00019","getTgInsideLiningMate","getTgInsideLiningMateStkNo","tgInsideLiningMateStkNoPrice","setGlInnnerClothRtPrice"),//内側裏地素材
	GILET_TUXEDO_OPTION_CODE21("00021","getTgFrontBtnMate","getTgFrontBtnMateStkNo","tgFrontBtnMateStkNoPrice","setGlFrtBtnRtPrice"),//釦素材
	GILET_TUXEDO_OPTION_CODE23("00023","getTgBackBelt","","tgBackBeltPrice","setGlBackBeltRtPrice"),//バックベルト
	GILET_TUXEDO_OPTION_CODE24("00024","getTgWatchChain","","tgWatchChainPrice","setGlWatchChainRtPrice");//ウォッチチェーン
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	
    private GiletCoOptionTuxedoUpperPriceEnum(String k ,String v1 , String v2 , String v3 , String v4) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour = v4;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour);
    }  
  
    public static GiletCoOptionTuxedoUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletCoOptionTuxedoUpperPriceEnum get(String str) {
        for (GiletCoOptionTuxedoUpperPriceEnum e : values()) {
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
