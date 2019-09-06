package co.jp.aoyama.macchinetta.app.order.enums.coat;

public enum CoatCoOptionStandardUpperPriceEnum {

	// OptionForm
	// Key:OptionCoatStandardInfoのoption_code
	// Value1:OptionCoatStandardInfoのmethod
	
	COAT_STANDARD_OPTION_CODE01("00001","getOcLapelDesign","","ocLapelDesignPrice","setCtLapelDesignRtPrice"),//ラペルデザイン
	COAT_STANDARD_OPTION_CODE02("00002","getOcWaistPkt","","ocWaistPktPrice","setCtWaistPktRtPrice"),//腰ポケット
	COAT_STANDARD_OPTION_CODE03("00003","getOcChangePkt","","ocChangePktPrice","setCtChgPktRtPrice"),//チェンジポケット
	COAT_STANDARD_OPTION_CODE04("00004","getOcSlantedPkt","","ocSlantedPktPrice","setCtSlantedPktRtPrice"),//スランテッドポケット
	COAT_STANDARD_OPTION_CODE05("00005","getOcVentSpec","","ocVentSpecPrice","setCtVentRtPrice"),//ベント
	COAT_STANDARD_OPTION_CODE06("00006","getOcFrontBtnCnt","","ocFrontBtnCntPrice","setCtFrtBtnRtPrice"),//フロント釦数
	COAT_STANDARD_OPTION_CODE07("00007","getOcCuffSpec","","ocCuffSpecPrice","setCtCuffRtPrice"),//袖口
	COAT_STANDARD_OPTION_CODE08("00008","getOcSleeveBtnType","","ocSleeveBtnTypePrice","setCtSleeveBtnRtPrice"),//袖釦
	COAT_STANDARD_OPTION_CODE09("00009","getOcBackBelt","","ocBackBeltPrice","setCtBackBeltRtPrice"),//バックベルト
	COAT_STANDARD_OPTION_CODE10("00010","getOcChainHange","","ocChainHangePrice","setCtCollarHangRtPrice"),//襟吊
	COAT_STANDARD_OPTION_CODE11("00011","getOcBodyBackMate","getOcBodyBackMateStkNo","ocBodyBackMateStkNoPrice","setCtInnerBodyClothRtPrice"),//胴裏地素材
	COAT_STANDARD_OPTION_CODE12("00012","getOcCuffBackMate","getOcCuffBackMateStkNo","ocCuffBackMateStkNoPrice","setCtInnerSleeveClothRtPrice"),//袖裏地素材
	COAT_STANDARD_OPTION_CODE13("00013","getOcFrontBtnMate","getOcFrontBtnMateStkNo","ocFrontBtnMateStkNoPrice","setCtBtnMaterialRtPrice");//釦素材
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	
    private CoatCoOptionStandardUpperPriceEnum(String k ,String v1 , String v2 , String v3 , String v4) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour = v4;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour);
    }  
  
    public static CoatCoOptionStandardUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoatCoOptionStandardUpperPriceEnum get(String str) {
        for (CoatCoOptionStandardUpperPriceEnum e : values()) {
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
