package co.jp.aoyama.macchinetta.app.order.enums.coat;

public enum CoatCoOptionStandardPriceEnum {

	// OptionForm
	// Key:OptionCOATStandardInfo option_code
	// Value:OptionCOATStandardInfo method
	// Value:OptionCOATStandardInfo method
	// Value:order method
	
	COAT_STANDARD_OPTION_CODE01("00001","getOcLapelDesign","","setCtLapelDesignRtPrice","oc_lapelDesign","","getCtLapelDesignRtPrice"),//ラペルデザイン
	COAT_STANDARD_OPTION_CODE02("00002","getOcWaistPkt","","setCtWaistPktRtPrice","oc_waistPkt","","getCtWaistPktRtPrice"),//腰ポケット
	COAT_STANDARD_OPTION_CODE03("00003","getOcChangePkt","","setCtChgPktRtPrice","oc_changePkt_id","","getCtChgPktRtPrice"),//チェンジポケット
	COAT_STANDARD_OPTION_CODE04("00004","getOcSlantedPkt","","setCtSlantedPktRtPrice","oc_slantedPkt_id","","getCtSlantedPktRtPrice"),//スランテッドポケット
	COAT_STANDARD_OPTION_CODE05("00005","getOcVentSpec","","setCtVentRtPrice","oc_ventSpec_id","","getCtVentRtPrice"),//ベント
	COAT_STANDARD_OPTION_CODE06("00006","getOcFrontBtnCnt","","setCtFrtBtnRtPrice","oc_frontBtnCnt","","getCtFrtBtnRtPrice"),//フロント釦数
	COAT_STANDARD_OPTION_CODE07("00007","getOcCuffSpec","","setCtCuffRtPrice","oc_cuffSpec","","getCtCuffRtPrice"),//袖口
	COAT_STANDARD_OPTION_CODE08("00008","getOcSleeveBtnType","","setCtSleeveBtnRtPrice","oc_sleeveBtnType","","getCtSleeveBtnRtPrice"),//袖釦
	COAT_STANDARD_OPTION_CODE09("00009","getOcBackBelt","","setCtBackBeltRtPrice","oc_backBelt_id","","getCtBackBeltRtPrice"),//バックベルト
	COAT_STANDARD_OPTION_CODE10("00010","getOcChainHange","","setCtCollarHangRtPrice","oc_chainHange_id","","getCtCollarHangRtPrice"),//襟吊
	COAT_STANDARD_OPTION_CODE11("00011","getOcBodyBackMate","getOcBodyBackMateStkNo","setCtInnerBodyClothRtPrice","oc_bodyBackMate","oc_bodyBackMateStkNo","getCtInnerBodyClothRtPrice"),//胴裏素材
	COAT_STANDARD_OPTION_CODE12("00012","getOcCuffBackMate","getOcCuffBackMateStkNo","setCtInnerSleeveClothRtPrice","oc_cuffBackMate","oc_cuffBackMateStkNo","getCtInnerSleeveClothRtPrice"),//袖裏素材
	COAT_STANDARD_OPTION_CODE13("00013","getOcFrontBtnMate","getOcFrontBtnMateStkNo","setCtBtnMaterialRtPrice","oc_frontBtnMate","oc_frontBtnMateStkNo","getCtBtnMaterialRtPrice");//釦素材
	//仕様変更　「袖仕様」画面削除
//	COAT_STANDARD_OPTION_CODE14("00014","getOcSleeveSpec","","setCtSleeveTypeRtPrice","oc_sleeveSpec_id","","getCtSleeveTypeRtPrice");//袖仕様
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
    
    private CoatCoOptionStandardPriceEnum(String k ,String v1 , String v2 , String v3 , String v4 , String v5 , String v6) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour = v4;
        this.valueFive = v5;
        this.valueSix = v6;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour).concat(",").concat(this.valueFive).concat(",").concat(this.valueSix);
    }  
  
    public static CoatCoOptionStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static CoatCoOptionStandardPriceEnum get(String str) {
        for (CoatCoOptionStandardPriceEnum e : values()) {
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
