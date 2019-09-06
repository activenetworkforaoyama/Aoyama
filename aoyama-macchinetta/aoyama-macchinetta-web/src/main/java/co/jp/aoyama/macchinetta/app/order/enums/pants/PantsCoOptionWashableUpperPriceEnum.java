package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsCoOptionWashableUpperPriceEnum {

	// OptionForm
	// Key:OptionPantsWashableInfoのoption_code
	// Value1:OptionPantsWashableInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	PANTS_WASHABLE_OPTION_CODE01("00001","getWpTack","","wpTackPrice","setPtTackRtPrice"),//タック
	PANTS_WASHABLE_OPTION_CODE02("00002","getWpKneeBack","","wpKneeBackPrice","setPtKneeinnerTypeRtPrice"),//膝裏
	PANTS_WASHABLE_OPTION_CODE03("00003","getWpKneeBackMate","","wpKneeBackMatePrice","setPtKneeinnerClothRtPrice"),//膝裏素材
	PANTS_WASHABLE_OPTION_CODE04("00004","getWpFrontSpec","","wpFrontSpecPrice","setPtFrtTypeRtPrice"),//フロント仕様
	PANTS_WASHABLE_OPTION_CODE05("00005","getWpPancherina","","wpPancherinaPrice","setPtPancherinaRtPrice"),//パンチェリーナ
	PANTS_WASHABLE_OPTION_CODE06("00006","getWpAdjuster","","wpAdjusterPrice","setPtAdjusterRtPrice"),//アジャスター仕様
	PANTS_WASHABLE_OPTION_CODE07("00007","getWpBeltLoop","","wpBeltLoopPrice","setPtBeltloopRtPrice"),//ベルトループ変更
	PANTS_WASHABLE_OPTION_CODE08("00009","getWpPinLoop","","wpPinLoopPrice","setPtPinloopRtPrice"),//ピンループ
	PANTS_WASHABLE_OPTION_CODE10("00010","getWpSidePkt","","wpSidePktPrice","setPtSidePktRtPrice"),//脇ポケット
	PANTS_WASHABLE_OPTION_CODE11("00011","getWpSinobiPkt","","wpSinobiPktPrice","setPtShinobiPktRtPrice"),//忍びポケット
	PANTS_WASHABLE_OPTION_CODE12("00012","getWpCoinPkt","","wpCoinPktPrice","setPtCoinPktRtPrice"),//コインポケット
	PANTS_WASHABLE_OPTION_CODE13("00013","getWpFlapCoinPkt","","wpFlapCoinPktPrice","setPtFlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_WASHABLE_OPTION_CODE14("00014","getWpPisPktUf","","wpPisPktUfPrice","setPtLeftPisPktRtPrice"),//上前ピスポケット
	PANTS_WASHABLE_OPTION_CODE15("00015","getWpPisPktDf","","wpPisPktDfPrice","setPtRightPisPktRtPrice"),//下前ピスポケット
	PANTS_WASHABLE_OPTION_CODE16("00016","getWpVCut","","wpVCutPrice","setPtVCutRtPrice"),//Vカット
	PANTS_WASHABLE_OPTION_CODE17("00017","getWpHemUp","","wpHemUpPrice","setPtHemUpRtPrice"),//裾上げ
	PANTS_WASHABLE_OPTION_CODE18("00018","getWpDoubleWide","","wpDoubleWidePrice","setPtDblWidthRtPrice"),//ダブル幅
	PANTS_WASHABLE_OPTION_CODE19("00019","getWpStitch","","wpStitchPrice","setPtAmfStitchRtPrice"),//ステッチ種類
	PANTS_WASHABLE_OPTION_CODE20("00020","getWpStitchModify","","wpStitchModifyPrice","setPtStitchPlcRtPrice"),//ステッチ箇所変更
	PANTS_WASHABLE_OPTION_CODE22("00022","getWpDStitch","","wpDStitchPrice","setPtDblstitchPlcRtPrice"),//ダブルステッチ
	PANTS_WASHABLE_OPTION_CODE24("00024","getWpAmfColor","","wpAmfColorPrice","setPtAmfColorRtPrice"),//AMF色指定
	PANTS_WASHABLE_OPTION_CODE27("00027","getWpBhColor","","wpBhColorPrice","setPtBtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_WASHABLE_OPTION_CODE30("00030","getWpByColor","","wpByColorPrice","setPtBtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_WASHABLE_OPTION_CODE33("00033","getWpButton","getWpBtnMateStkNo","wpBtnMateStkNoPrice","setPtBtnMaterialRtPrice"),//釦素材
	PANTS_WASHABLE_OPTION_CODE35("00035","getWpSuspenderBtn","","wpSuspenderBtnPrice","setPtSuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_WASHABLE_OPTION_CODE36("00036","getWpEight","","wpEightPrice","setPtNonSlipRtPrice"),//エイト（滑り止め）
	PANTS_WASHABLE_OPTION_CODE41("00041","getWpThick","","wpThickPrice","setPtChicSlipRtPrice"),//シック大（股補強）
	PANTS_WASHABLE_OPTION_CODE37("00037","getWpShapeMemory","","wpShapeMemoryPrice","setPtShapeMemoryRtPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
    
    private PantsCoOptionWashableUpperPriceEnum(String k ,String v1 ,String v2 ,String v3 ,String v4) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour = v4;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.getValueThree()).concat(",").concat(this.valueFour);
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

	public String getValueFour() {
		return valueFour;
	}

}
