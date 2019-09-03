package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsOptionCoTuxedoPriceEnum {

	// OptionForm
	// Key:OptionPantsTUXEDOInfo option_code
	// ValueOne:OptionPantsTUXEDOInfo method
	// ValueTwo:OptionPantsTUXEDOInfo method
	// ValueThree:order method
	
	PANTS_TUXEDO_OPTION_CODE01("00001","getTpTack","","setPtTackRtPrice"),//タック
	PANTS_TUXEDO_OPTION_CODE02("00002","getTpKneeBack","","setPtKneeinnerTypeRtPrice"),//膝裏
	PANTS_TUXEDO_OPTION_CODE03("00003","getTpKneeBackMate","","setPtKneeinnerClothRtPrice"),//膝裏素材
	PANTS_TUXEDO_OPTION_CODE04("00004","getTpFrontSpec","","setPtFrtTypeRtPrice"),//フロント仕様
	PANTS_TUXEDO_OPTION_CODE05("00005","getTpPancherina","","setPtPancherinaRtPrice"),//パンチェリーナ
	PANTS_TUXEDO_OPTION_CODE06("00006","getTpAdjuster","","setPtAdjusterRtPrice"),//アジャスター仕様
	PANTS_TUXEDO_OPTION_CODE07("00007","getTpBeltLoop","","setPtBeltloopRtPrice"),//ベルトループ変更
	PANTS_TUXEDO_OPTION_CODE08("00009","getTpPinLoop","","setPtPinloopRtPrice"),//ピンループ
	PANTS_TUXEDO_OPTION_CODE10("00010","getTpSidePkt","","setPtSidePktRtPrice"),//脇ポケット
	PANTS_TUXEDO_OPTION_CODE11("00011","getTpSinobiPkt","","setPtShinobiPktRtPrice"),//忍びポケット
	PANTS_TUXEDO_OPTION_CODE12("00012","getTpCoinPkt","","setPtCoinPktRtPrice"),//コインポケット
	PANTS_TUXEDO_OPTION_CODE13("00013","getTpFlapCoinPkt","","setPtFlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_TUXEDO_OPTION_CODE14("00014","getTpPisPktUf","","setPtLeftPisPktRtPrice"),//上前ピスポケット
	PANTS_TUXEDO_OPTION_CODE15("00015","getTpPisPktDf","","setPtRightPisPktRtPrice"),//下前ピスポケット
	PANTS_TUXEDO_OPTION_CODE16("00016","getTpVCut","","setPtVCutRtPrice"),//Vカット
	PANTS_TUXEDO_OPTION_CODE17("00017","getTpHemUp","","setPtHemUpRtPrice"),//裾上げ
	PANTS_TUXEDO_OPTION_CODE18("00018","getTpDoubleWide","","setPtDblWidthRtPrice"),//ダブル幅
	PANTS_TUXEDO_OPTION_CODE19("00019","getTpStitch","","setPtAmfStitchRtPrice"),//ステッチ種類
	PANTS_TUXEDO_OPTION_CODE27("00027","getTpBhColor","","setPtBtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_TUXEDO_OPTION_CODE30("00030","getTpByColor","","setPtBtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_TUXEDO_OPTION_CODE33("00033","getTpButton","getTpBtnMateStkNo","setPtBtnMaterialRtPrice"),//釦素材
	PANTS_TUXEDO_OPTION_CODE35("00035","getTpSuspenderBtn","","setPtSuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_TUXEDO_OPTION_CODE36("00036","getTpEight","","setPtNonSlipRtPrice"),//エイト（滑り止め）
	PANTS_TUXEDO_OPTION_CODE41("00041","getTpThick","","setPtChicSlipRtPrice"),//シック大（股補強）
	PANTS_TUXEDO_OPTION_CODE37("00037","getTpShapeMemory","","setPtShapeMemoryRtPrice"),//形状記憶
	PANTS_TUXEDO_OPTION_CODE39("00039","getTpSideStripe","","setPtSideStripeRtPrice"),//側章
	PANTS_TUXEDO_OPTION_CODE40("00040","getTpSideStripeWidth","","setPtSideStripeWidthRtPrice");//側章幅
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private PantsOptionCoTuxedoPriceEnum(String k ,String v1 ,String v2 , String v3 ) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static PantsOptionCoTuxedoPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsOptionCoTuxedoPriceEnum get(String str) {
        for (PantsOptionCoTuxedoPriceEnum e : values()) {
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
