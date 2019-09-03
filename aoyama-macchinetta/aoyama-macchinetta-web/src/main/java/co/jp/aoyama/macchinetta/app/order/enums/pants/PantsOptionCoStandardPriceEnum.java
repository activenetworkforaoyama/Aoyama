package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionCoStandardPriceEnum {

	// OptionForm
	// Key:OptionPantsStandardInfo option_code
	// ValueOne:OptionPantsStandardInfo method
	// ValueTwo:OptionPantsStandardInfo method
	// ValueThree:order method
	
	PANTS_STANDARD_OPTION_CODE01("00001","getOpTack","","setPtTackRtPrice"),//タック
	PANTS_STANDARD_OPTION_CODE02("00002","getOpKneeBack","","setPtKneeinnerTypeRtPrice"),//膝裏
	PANTS_STANDARD_OPTION_CODE03("00003","getOpKneeBackMate","","setPtKneeinnerClothRtPrice"),//膝裏素材
	PANTS_STANDARD_OPTION_CODE04("00004","getOpFrontSpec","","setPtFrtTypeRtPrice"),//フロント仕様
	PANTS_STANDARD_OPTION_CODE05("00005","getOpPancherina","","setPtPancherinaRtPrice"),//パンチェリーナ
	PANTS_STANDARD_OPTION_CODE06("00006","getOpAdjuster","","setPtAdjusterRtPrice"),//アジャスター仕様
	PANTS_STANDARD_OPTION_CODE07("00007","getOpBeltLoop","","setPtBeltloopRtPrice"),//ベルトループ変更
	PANTS_STANDARD_OPTION_CODE08("00009","getOpPinLoop","","setPtPinloopRtPrice"),//ピンループ
	PANTS_STANDARD_OPTION_CODE10("00010","getOpSidePkt","","setPtSidePktRtPrice"),//脇ポケット
	PANTS_STANDARD_OPTION_CODE11("00011","getOpSinobiPkt","","setPtShinobiPktRtPrice"),//忍びポケット
	PANTS_STANDARD_OPTION_CODE12("00012","getOpCoinPkt","","setPtCoinPktRtPrice"),//コインポケット
	PANTS_STANDARD_OPTION_CODE13("00013","getOpFlapCoinPkt","","setPtFlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_STANDARD_OPTION_CODE14("00014","getOpPisPktUf","","setPtLeftPisPktRtPrice"),//上前ピスポケット
	PANTS_STANDARD_OPTION_CODE15("00015","getOpPisPktDf","","setPtRightPisPktRtPrice"),//下前ピスポケット
	PANTS_STANDARD_OPTION_CODE16("00016","getOpVCut","","setPtVCutRtPrice"),//Vカット
	PANTS_STANDARD_OPTION_CODE17("00017","getOpHemUp","","setPtHemUpRtPrice"),//裾上げ
	PANTS_STANDARD_OPTION_CODE18("00018","getOpDoubleWide","","setPtDblWidthRtPrice"),//ダブル幅
	PANTS_STANDARD_OPTION_CODE19("00019","getOpStitch","","setPtAmfStitchRtPrice"),//ステッチ種類
	PANTS_STANDARD_OPTION_CODE20("00020","getOpStitchModify","","setPtStitchPlcRtPrice"),//ステッチ箇所変更
	PANTS_STANDARD_OPTION_CODE22("00022","getOpDStitch","","setPtDblstitchPlcRtPrice"),//ダブルステッチ
	PANTS_STANDARD_OPTION_CODE24("00024","getOpAmfColor","","setPtAmfColorRtPrice"),//AMF色指定
	PANTS_STANDARD_OPTION_CODE27("00027","getOpBhColor","","setPtBtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_STANDARD_OPTION_CODE30("00030","getOpByColor","","setPtBtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_STANDARD_OPTION_CODE33("00033","getOpButton","getOpBtnMateStkNo","setPtBtnMaterialRtPrice"),//釦素材
	PANTS_STANDARD_OPTION_CODE35("00035","getOpSuspenderBtn","","setPtSuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_STANDARD_OPTION_CODE36("00036","getOpEight","","setPtNonSlipRtPrice"),//エイト（滑り止め）
	PANTS_STANDARD_OPTION_CODE41("00041","getOpThick","","setPtChicSlipRtPrice"),//シック大（股補強）
	PANTS_STANDARD_OPTION_CODE37("00037","getOpShapeMemory","","setPtShapeMemoryRtPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private PantsOptionCoStandardPriceEnum(String k ,String v1 ,String v2 , String v3 ) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static PantsOptionCoStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionCoStandardPriceEnum get(String str) {
        for (PantsOptionCoStandardPriceEnum e : values()) {
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
