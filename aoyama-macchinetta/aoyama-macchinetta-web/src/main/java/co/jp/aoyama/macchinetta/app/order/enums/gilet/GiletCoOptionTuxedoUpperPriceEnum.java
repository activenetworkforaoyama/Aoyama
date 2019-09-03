package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletCoOptionTuxedoUpperPriceEnum {

	// OptionForm
	// Key:OptionGiletTuxedoInfoのoption_code
	// Value1:OptionGiletTuxedoInfoのmethod
	
	GILET_TUXEDO_OPTION_CODE01("00001","getTgBreastPkt","","tgBreastPktPrice"),//胸ポケット
	GILET_TUXEDO_OPTION_CODE02("00002","getTgWaistPkt","","tgWaistPktPrice"),//腰ポケット
	GILET_TUXEDO_OPTION_CODE03("00003","getTgWaistPktSpec","","tgWaistPktSpecPrice"),//腰ポケット形状
	GILET_TUXEDO_OPTION_CODE04("00004","getTgWaistPktMate","","tgWaistPktMatePrice"),//腰ポケット素材
	GILET_TUXEDO_OPTION_CODE05("00005","getTgStitch","","tgStitchPrice"),//ステッチ種類
	GILET_TUXEDO_OPTION_CODE11("00011","getTgBhColor","","tgBhColorPrice"),//ボタンホール色指定
	GILET_TUXEDO_OPTION_CODE14("00014","getTgByColor","","tgByColorPrice"),//ボタン付け糸指定
	GILET_TUXEDO_OPTION_CODE17("00017","getTgBackLiningMate","getTgBackLiningMateStkNo","tgBackLiningMateStkNoPrice"),//背裏地素材
	GILET_TUXEDO_OPTION_CODE19("00019","getTgInsideLiningMate","getTgInsideLiningMateStkNo","tgInsideLiningMateStkNoPrice"),//内側裏地素材
	GILET_TUXEDO_OPTION_CODE21("00021","getTgFrontBtnMate","getTgFrontBtnMateStkNo","tgFrontBtnMateStkNoPrice"),//釦素材
	GILET_TUXEDO_OPTION_CODE23("00023","getTgBackBelt","","tgBackBeltPrice"),//バックベルト
	GILET_TUXEDO_OPTION_CODE24("00024","getTgWatchChain","","tgWatchChainPrice");//ウォッチチェーン
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	
    private GiletCoOptionTuxedoUpperPriceEnum(String k ,String v1 , String v2 , String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
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

}
