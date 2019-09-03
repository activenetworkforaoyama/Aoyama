package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsCoOptionWashableUpperPriceEnum {

	// OptionForm
	// Key:OptionPantsWashableInfoのoption_code
	// Value1:OptionPantsWashableInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	PANTS_WASHABLE_OPTION_CODE01("00001","getWpTack","","wpTackPrice"),//タック
	PANTS_WASHABLE_OPTION_CODE02("00002","getWpKneeBack","","wpKneeBackPrice"),//膝裏
	PANTS_WASHABLE_OPTION_CODE03("00003","getWpKneeBackMate","","wpKneeBackMatePrice"),//膝裏素材
	PANTS_WASHABLE_OPTION_CODE04("00004","getWpFrontSpec","","wpFrontSpecPrice"),//フロント仕様
	PANTS_WASHABLE_OPTION_CODE05("00005","getWpPancherina","","wpPancherinaPrice"),//パンチェリーナ
	PANTS_WASHABLE_OPTION_CODE06("00006","getWpAdjuster","","wpAdjusterPrice"),//アジャスター仕様
	PANTS_WASHABLE_OPTION_CODE07("00007","getWpBeltLoop","","wpBeltLoopPrice"),//ベルトループ変更
	PANTS_WASHABLE_OPTION_CODE08("00009","getWpPinLoop","","wpPinLoopPrice"),//ピンループ
	PANTS_WASHABLE_OPTION_CODE10("00010","getWpSidePkt","","wpSidePktPrice"),//脇ポケット
	PANTS_WASHABLE_OPTION_CODE11("00011","getWpSinobiPkt","","wpSinobiPktPrice"),//忍びポケット
	PANTS_WASHABLE_OPTION_CODE12("00012","getWpCoinPkt","","wpCoinPktPrice"),//コインポケット
	PANTS_WASHABLE_OPTION_CODE13("00013","getWpFlapCoinPkt","","wpFlapCoinPktPrice"),//フラップ付コインポケット
	PANTS_WASHABLE_OPTION_CODE14("00014","getWpPisPktUf","","wpPisPktUfPrice"),//上前ピスポケット
	PANTS_WASHABLE_OPTION_CODE15("00015","getWpPisPktDf","","wpPisPktDfPrice"),//下前ピスポケット
	PANTS_WASHABLE_OPTION_CODE16("00016","getWpVCut","","wpVCutPrice"),//Vカット
	PANTS_WASHABLE_OPTION_CODE17("00017","getWpHemUp","","wpHemUpPrice"),//裾上げ
	PANTS_WASHABLE_OPTION_CODE18("00018","getWpDoubleWide","","wpDoubleWidePrice"),//ダブル幅
	PANTS_WASHABLE_OPTION_CODE19("00019","getWpStitch","","wpStitchPrice"),//ステッチ種類
	PANTS_WASHABLE_OPTION_CODE20("00020","getWpStitchModify","","wpStitchModifyPrice"),//ステッチ箇所変更
	PANTS_WASHABLE_OPTION_CODE22("00022","getWpDStitch","","wpDStitchPrice"),//ダブルステッチ
	PANTS_WASHABLE_OPTION_CODE24("00024","getWpAmfColor","","wpAmfColorPrice"),//AMF色指定
	PANTS_WASHABLE_OPTION_CODE27("00027","getWpBhColor","","wpBhColorPrice"),//ボタンホール色指定
	PANTS_WASHABLE_OPTION_CODE30("00030","getWpByColor","","wpByColorPrice"),//ボタン付け糸指定
	PANTS_WASHABLE_OPTION_CODE33("00033","getWpButton","getWpBtnMateStkNo","wpBtnMateStkNoPrice"),//ボタン付け糸指定
	PANTS_WASHABLE_OPTION_CODE35("00035","getWpSuspenderBtn","","wpSuspenderBtnPrice"),//サスペンダー釦
	PANTS_WASHABLE_OPTION_CODE36("00036","getWpEight","","wpEightPrice"),//エイト（滑り止め）
	PANTS_WASHABLE_OPTION_CODE41("00041","getWpThick","","wpThickPrice"),//シック大（股補強）
	PANTS_WASHABLE_OPTION_CODE37("00037","getWpShapeMemory","","wpShapeMemoryPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private PantsCoOptionWashableUpperPriceEnum(String k ,String v1 ,String v2 ,String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.getValueThree());
    }  
  
    public static PantsCoOptionWashableUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsCoOptionWashableUpperPriceEnum get(String str) {
        for (PantsCoOptionWashableUpperPriceEnum e : values()) {
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
