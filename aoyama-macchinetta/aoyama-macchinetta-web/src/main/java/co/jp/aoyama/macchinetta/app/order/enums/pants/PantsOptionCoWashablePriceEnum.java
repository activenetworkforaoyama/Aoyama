package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionCoWashablePriceEnum {

	// OptionForm
	// Key:OptionPantsWASHABLEInfo option_code
	// ValueOne:OptionPantsWASHABLEInfo method
	// ValueTwo:OptionPantsWASHABLEInfo method
	// ValueThree:order method
	
	PANTS_WASHABLE_OPTION_CODE01("00001","getWpTack","","setPtTackRtPrice"),//タック
	PANTS_WASHABLE_OPTION_CODE02("00002","getWpKneeBack","","setPtKneeinnerTypeRtPrice"),//膝裏
	PANTS_WASHABLE_OPTION_CODE03("00003","getWpKneeBackMate","","setPtKneeinnerClothRtPrice"),//膝裏素材
	PANTS_WASHABLE_OPTION_CODE04("00004","getWpFrontSpec","","setPtFrtTypeRtPrice"),//フロント仕様
	PANTS_WASHABLE_OPTION_CODE05("00005","getWpPancherina","","setPtPancherinaRtPrice"),//パンチェリーナ
	PANTS_WASHABLE_OPTION_CODE06("00006","getWpAdjuster","","setPtAdjusterRtPrice"),//アジャスター仕様
	PANTS_WASHABLE_OPTION_CODE07("00007","getWpBeltLoop","","setPtBeltloopRtPrice"),//ベルトループ変更
	PANTS_WASHABLE_OPTION_CODE08("00009","getWpPinLoop","","setPtPinloopRtPrice"),//ピンループ
	PANTS_WASHABLE_OPTION_CODE10("00010","getWpSidePkt","","setPtSidePktRtPrice"),//脇ポケット
	PANTS_WASHABLE_OPTION_CODE11("00011","getWpSinobiPkt","","setPtShinobiPktRtPrice"),//忍びポケット
	PANTS_WASHABLE_OPTION_CODE12("00012","getWpCoinPkt","","setPtCoinPktRtPrice"),//コインポケット
	PANTS_WASHABLE_OPTION_CODE13("00013","getWpFlapCoinPkt","","setPtFlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_WASHABLE_OPTION_CODE14("00014","getWpPisPktUf","","setPtLeftPisPktRtPrice"),//上前ピスポケット
	PANTS_WASHABLE_OPTION_CODE15("00015","getWpPisPktDf","","setPtRightPisPktRtPrice"),//下前ピスポケット
	PANTS_WASHABLE_OPTION_CODE16("00016","getWpVCut","","setPtVCutRtPrice"),//Vカット
	PANTS_WASHABLE_OPTION_CODE17("00017","getWpHemUp","","setPtHemUpRtPrice"),//裾上げ
	PANTS_WASHABLE_OPTION_CODE18("00018","getWpDoubleWide","","setPtDblWidthRtPrice"),//ダブル幅
	PANTS_WASHABLE_OPTION_CODE19("00019","getWpStitch","","setPtAmfStitchRtPrice"),//ステッチ種類
	PANTS_WASHABLE_OPTION_CODE20("00020","getWpStitchModify","","setPtStitchPlcRtPrice"),//ステッチ箇所変更
	PANTS_WASHABLE_OPTION_CODE22("00022","getWpDStitch","","setPtDblstitchPlcRtPrice"),//ダブルステッチ
	PANTS_WASHABLE_OPTION_CODE24("00024","getWpAmfColor","","setPtAmfColorRtPrice"),//AMF色指定
	PANTS_WASHABLE_OPTION_CODE27("00027","getWpBhColor","","setPtBtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_WASHABLE_OPTION_CODE30("00030","getWpByColor","","setPtBtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_WASHABLE_OPTION_CODE33("00033","getWpButton","getWpBtnMateStkNo","setPtBtnMaterialRtPrice"),//釦素材
	PANTS_WASHABLE_OPTION_CODE35("00035","getWpSuspenderBtn","","setPtSuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_WASHABLE_OPTION_CODE36("00036","getWpEight","","setPtNonSlipRtPrice"),//エイト（滑り止め）
	PANTS_WASHABLE_OPTION_CODE41("00041","getWpThick","","setPtChicSlipRtPrice"),//シック大（股補強）
	PANTS_WASHABLE_OPTION_CODE37("00037","getWpShapeMemory","","setPtShapeMemoryRtPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private PantsOptionCoWashablePriceEnum(String k ,String v1 ,String v2 , String v3 ) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static PantsOptionCoWashablePriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionCoWashablePriceEnum get(String str) {
        for (PantsOptionCoWashablePriceEnum e : values()) {
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
