package co.jp.aoyama.macchinetta.app.order.enums.coat;

public enum CoatCoOptionStandardPriceEnum {

	// OptionForm
	// Key:OptionCOATStandardInfo option_code
	// Value:OptionCOATStandardInfo method
	// Value:OptionCOATStandardInfo method
	// Value:order method
	
	COAT_STANDARD_OPTION_CODE01("00001","getOcLapelDesign","","setCtLapelDesignRtPrice"),//ラペルデザイン
	COAT_STANDARD_OPTION_CODE02("00002","getOcWaistPkt","","setCtWaistPktRtPrice"),//腰ポケット
	COAT_STANDARD_OPTION_CODE03("00003","getOcChangePkt","","setCtChgPktRtPrice"),//チェンジポケット
	COAT_STANDARD_OPTION_CODE04("00004","getOcSlantedPkt","","setCtSlantedPktRtPrice"),//スランテッドポケット
	COAT_STANDARD_OPTION_CODE05("00005","getOcVentSpec","","setCtVentRtPrice"),//ベント
	COAT_STANDARD_OPTION_CODE06("00006","getOcFrontBtnCnt","","setCtFrtBtnRtPrice"),//フロント釦数
	COAT_STANDARD_OPTION_CODE07("00007","getOcCuffSpec","","setCtCuffRtPrice"),//袖口
	COAT_STANDARD_OPTION_CODE08("00008","getOcSleeveBtnType","","setCtSleeveBtnRtPrice"),//袖釦
	COAT_STANDARD_OPTION_CODE09("00009","getOcBackBelt","","setCtBackBeltRtPrice"),//バックベルト
	COAT_STANDARD_OPTION_CODE10("00010","getOcChainHange","","setCtCollarHangRtPrice"),//襟吊
	COAT_STANDARD_OPTION_CODE11("00011","getOcBodyBackMate","getOcBodyBackMateStkNo","setCtInnerBodyClothRtPrice"),//胴裏素材
	COAT_STANDARD_OPTION_CODE12("00012","getOcCuffBackMate","getOcCuffBackMateStkNo","setCtInnerSleeveClothRtPrice"),//袖裏素材
	COAT_STANDARD_OPTION_CODE13("00013","getOcFrontBtnMate","getOcFrontBtnMateStkNo","setCtBtnMaterialRtPrice");//釦素材
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private CoatCoOptionStandardPriceEnum(String k ,String v1 , String v2 , String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
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
}
