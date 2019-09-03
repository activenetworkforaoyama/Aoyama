package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsCoOptionWashableNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionPantsWashableInfoのoption_code
	// Value1:OptionPantsWashableInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	PANTS_WASHABLE_OPTION_CODE01("00001","getWpTack","setPtTackWsWage","setPtTackWsPrice","getPtTackWsWage","getPtTackWsPrice"),//タック
	PANTS_WASHABLE_OPTION_CODE02("00002","getWpKneeBack","setPtKneeinnerTypeWsWage","setPtKneeinnerTypeWsPrice","getPtKneeinnerTypeWsWage","getPtKneeinnerTypeWsPrice"),//膝裏
	PANTS_WASHABLE_OPTION_CODE03("00003","getWpKneeBackMate","setPtKneeinnerClothWsWage","setPtKneeinnerClothWsPrice","getPtKneeinnerClothWsWage","getPtKneeinnerClothWsPrice"),//膝裏素材
	PANTS_WASHABLE_OPTION_CODE04("00004","getWpFrontSpec","setPtFrtTypeWsWage","setPtFrtTypeWsPrice","getPtFrtTypeWsWage","getPtFrtTypeWsPrice"),//フロント仕様
	PANTS_WASHABLE_OPTION_CODE05("00005","getWpPancherina","setPtPancherinaWsWage","setPtPancherinaWsPrice","getPtPancherinaWsWage","getPtPancherinaWsPrice"),//パンチェリーナ
	PANTS_WASHABLE_OPTION_CODE06("00006","getWpAdjuster","setPtAdjusterWsWage","setPtAdjusterWsPrice","getPtAdjusterWsWage","getPtAdjusterWsPrice"),//アジャスター仕様
	PANTS_WASHABLE_OPTION_CODE07("00007","getWpBeltLoop","setPtBeltloopWsWage","setPtBeltloopWsPrice","getPtBeltloopWsWage","getPtBeltloopWsPrice"),//ベルトループ変更
	PANTS_WASHABLE_OPTION_CODE08("00009","getWpPinLoop","setPtPinloopWsWage","setPtPinloopWsPrice","getPtPinloopWsWage","getPtPinloopWsPrice"),//ピンループ
	PANTS_WASHABLE_OPTION_CODE10("00010","getWpSidePkt","setPtSidePktWsWage","setPtSidePktWsPrice","getPtSidePktWsWage","getPtSidePktWsPrice"),//脇ポケット
	PANTS_WASHABLE_OPTION_CODE11("00011","getWpSinobiPkt","setPtShinobiPktWsWage","setPtShinobiPktWsPrice","getPtShinobiPktWsWage","getPtShinobiPktWsPrice"),//忍びポケット
	PANTS_WASHABLE_OPTION_CODE12("00012","getWpCoinPkt","setPtCoinPktWsWage","setPtCoinPktWsPrice","getPtCoinPktWsWage","getPtCoinPktWsPrice"),//コインポケット
	PANTS_WASHABLE_OPTION_CODE13("00013","getWpFlapCoinPkt","setPtFlapcoinPktWsWage","setPtFlapcoinPktWsPrice","getPtFlapcoinPktWsWage","getPtFlapcoinPktWsPrice"),//フラップ付コインポケット
	PANTS_WASHABLE_OPTION_CODE14("00014","getWpPisPktUf","setPtLeftPisPktWsWage","setPtLeftPisPktWsPrice","getPtLeftPisPktWsWage","getPtLeftPisPktWsPrice"),//上前ピスポケット
	PANTS_WASHABLE_OPTION_CODE15("00015","getWpPisPktDf","setPtRightPisPktWsWage","setPtRightPisPktWsPrice","getPtRightPisPktWsWage","getPtRightPisPktWsPrice"),//下前ピスポケット
	PANTS_WASHABLE_OPTION_CODE16("00016","getWpVCut","setPtVCutWsWage","setPtVCutWsPrice","getPtVCutWsWage","getPtVCutWsPrice"),//Vカット
	PANTS_WASHABLE_OPTION_CODE17("00017","getWpHemUp","setPtHemUpWsWage","setPtHemUpWsPrice","getPtHemUpWsWage","getPtHemUpWsPrice"),//裾上げ
	PANTS_WASHABLE_OPTION_CODE18("00018","getWpDoubleWide","setPtDblWidthWsWage","setPtDblWidthWsPrice","getPtDblWidthWsWage","getPtDblWidthWsPrice"),//ダブル幅
	PANTS_WASHABLE_OPTION_CODE19("00019","getWpStitch","setPtAmfStitchWsWage","setPtAmfStitchWsPrice","getPtAmfStitchWsWage","getPtAmfStitchWsPrice"),//ステッチ種類
	PANTS_WASHABLE_OPTION_CODE20("00020","getWpStitchModify","setPtStitchPlcWsWage","setPtStitchPlcWsPrice","getPtStitchPlcWsWage","getPtStitchPlcWsPrice"),//ステッチ箇所変更
	PANTS_WASHABLE_OPTION_CODE22("00022","getWpDStitch","setPtDblstitchPlcWsWage","setPtDblstitchPlcWsPrice","getPtDblstitchPlcWsWage","getPtDblstitchPlcWsPrice"),//ダブルステッチ
	PANTS_WASHABLE_OPTION_CODE24("00024","getWpAmfColor","setPtAmfColorWsWage","setPtAmfColorWsPrice","getPtAmfColorWsWage","getPtAmfColorWsPrice"),//AMF色指定
	PANTS_WASHABLE_OPTION_CODE27("00027","getWpBhColor","setPtBtnholeColorWsWage","setPtBtnholeColorWsPrice","getPtBtnholeColorWsWage","getPtBtnholeColorWsPrice"),//ボタンホール色指定
	PANTS_WASHABLE_OPTION_CODE30("00030","getWpByColor","setPtBtnthreadColorWsWage","setPtBtnthreadColorWsPrice","getPtBtnthreadColorWsWage","getPtBtnthreadColorWsPrice"),//ボタン付け糸指定
	PANTS_WASHABLE_OPTION_CODE35("00035","getWpSuspenderBtn","setPtSuspenderBtnWsWage","setPtSuspenderBtnWsPrice","getPtSuspenderBtnWsWage","getPtSuspenderBtnWsPrice"),//サスペンダー釦
	PANTS_WASHABLE_OPTION_CODE36("00036","getWpEight","setPtNonSlipWsWage","setPtNonSlipWsPrice","getPtNonSlipWsWage","getPtNonSlipWsPrice"),//エイト（滑り止め）
	PANTS_WASHABLE_OPTION_CODE41("00041","getWpThick","setPtChicSlipWsWage","setPtChicSlipWsPrice","getPtChicSlipWsWage","getPtChicSlipWsPrice"),//シック大（股補強）
	PANTS_WASHABLE_OPTION_CODE37("00037","getWpShapeMemory","setPtShapeMemoryWsWage","setPtShapeMemoryWsPrice","getPtShapeMemoryWsWage","getPtShapeMemoryWsPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
    
    private PantsCoOptionWashableNextGenerationPriceEnum(String k ,String v1 ,String v2 , String v3, String v4, String v5 ) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour =v4;
        this.valueFive =v5;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour).concat(",").concat(this.valueFive);
    }  
  
    public static PantsCoOptionWashableNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsCoOptionWashableNextGenerationPriceEnum get(String str) {
        for (PantsCoOptionWashableNextGenerationPriceEnum e : values()) {
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
		return this.valueFour;
	}
	
	public String getValueFive() {
		return this.valueFive;
	}

}
