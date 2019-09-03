package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionCoTuxedoPriceEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	GILET_TUXEDO_OPTION_CODE01("00001","getTgBreastPkt","","setGlBreastPktRtPrice"),//胸ポケット
	GILET_TUXEDO_OPTION_CODE02("00002","getTgWaistPkt","","setGlWaistPktRtPrice"),//腰ポケット
	GILET_TUXEDO_OPTION_CODE03("00003","getTgWaistPktSpec","","setGlWaistPktShapeRtPrice"),//腰ポケット形状
	GILET_TUXEDO_OPTION_CODE04("00004","getTgWaistPktMate","","setGlWaistPktClothRtPrice"),//腰ポケット素材
	GILET_TUXEDO_OPTION_CODE05("00005","getTgStitch","","setGlAmfStitchRtPrice"),//ステッチ種類
	GILET_TUXEDO_OPTION_CODE11("00011","getTgBhColor","","setGlBtnholeColorRtPrice"),//ボタンホール色指定
	GILET_TUXEDO_OPTION_CODE14("00014","getTgByColor","","setGlBtnthreadColorRtPrice"),//ボタン付け糸指定
	GILET_TUXEDO_OPTION_CODE17("00017","getTgBackLiningMate","getTgBackLiningMateStkNo","setGlBackClothRtPrice"),//背裏地素材
	GILET_TUXEDO_OPTION_CODE19("00019","getTgInsideLiningMate","getTgInsideLiningMateStkNo","setGlInnnerClothRtPrice"),//内側裏地素材
	GILET_TUXEDO_OPTION_CODE21("00021","getTgFrontBtnMate","getTgFrontBtnMateStkNo","setGlFrtBtnRtPrice"),//釦素材
	GILET_TUXEDO_OPTION_CODE23("00023","getTgBackBelt","","setGlBackBeltRtPrice"),//バックベルト
	GILET_TUXEDO_OPTION_CODE24("00024","getTgWatchChain","","setGlWatchChainRtPrice");//ウォッチチェーン
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private GiletOptionCoTuxedoPriceEnum(String k ,String v1 ,String v2, String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
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

}
