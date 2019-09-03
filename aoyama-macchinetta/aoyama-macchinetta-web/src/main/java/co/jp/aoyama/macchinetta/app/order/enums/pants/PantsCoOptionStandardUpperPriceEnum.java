package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsCoOptionStandardUpperPriceEnum {

	// OptionForm
	// Key:OptionPantsStandardInfoのoption_code
	// Value1:OptionPantsStandardInfoのmethod
	
	PANTS_STANDARD_OPTION_CODE01("00001","getOpTack","","opTackPrice"),//タック
	PANTS_STANDARD_OPTION_CODE02("00002","getOpKneeBack","","opKneeBackPrice"),//膝裏
	PANTS_STANDARD_OPTION_CODE03("00003","getOpKneeBackMate","","opKneeBackMatePrice"),//膝裏素材
	PANTS_STANDARD_OPTION_CODE04("00004","getOpFrontSpec","","opFrontSpecPrice"),//フロント仕様
	PANTS_STANDARD_OPTION_CODE05("00005","getOpPancherina","","opPancherinaPrice"),//パンチェリーナ
	PANTS_STANDARD_OPTION_CODE06("00006","getOpAdjuster","","opAdjusterPrice"),//アジャスター仕様
	PANTS_STANDARD_OPTION_CODE07("00007","getOpBeltLoop","","opBeltLoopPrice"),//ベルトループ変更
	PANTS_STANDARD_OPTION_CODE08("00009","getOpPinLoop","","opPinLoopPrice"),//ピンループ
	PANTS_STANDARD_OPTION_CODE10("00010","getOpSidePkt","","opSidePktPrice"),//脇ポケット
	PANTS_STANDARD_OPTION_CODE11("00011","getOpSinobiPkt","","opSinobiPktPrice"),//忍びポケット
	PANTS_STANDARD_OPTION_CODE12("00012","getOpCoinPkt","","opCoinPktPrice"),//コインポケット
	PANTS_STANDARD_OPTION_CODE13("00013","getOpFlapCoinPkt","","opFlapCoinPktPrice"),//フラップ付コインポケット
	PANTS_STANDARD_OPTION_CODE14("00014","getOpPisPktUf","","opPisPktUfPrice"),//上前ピスポケット
	PANTS_STANDARD_OPTION_CODE15("00015","getOpPisPktDf","","opPisPktDfPrice"),//下前ピスポケット
	PANTS_STANDARD_OPTION_CODE16("00016","getOpVCut","","opVCutPrice"),//Vカット
	PANTS_STANDARD_OPTION_CODE17("00017","getOpHemUp","","opHemUpPrice"),//裾上げ
	PANTS_STANDARD_OPTION_CODE18("00018","getOpDoubleWide","","opDoubleWidePrice"),//ダブル幅
	PANTS_STANDARD_OPTION_CODE19("00019","getOpStitch","","opStitchPrice"),//ステッチ種類
	PANTS_STANDARD_OPTION_CODE20("00020","getOpStitchModify","","opStitchModifyPrice"),//ステッチ箇所変更
	PANTS_STANDARD_OPTION_CODE22("00022","getOpDStitch","","opDStitchPrice"),//ダブルステッチ
	PANTS_STANDARD_OPTION_CODE24("00024","getOpAmfColor","","opAmfColorPrice"),//AMF色指定
	PANTS_STANDARD_OPTION_CODE27("00027","getOpBhColor","","opBhColorPrice"),//ボタンホール色指定
	PANTS_STANDARD_OPTION_CODE30("00030","getOpByColor","","opByColorPrice"),//ボタン付け糸指定
	PANTS_STANDARD_OPTION_CODE33("00033","getOpButton","getOpBtnMateStkNo","opBtnMateStkNoPrice"),//釦素材
	PANTS_STANDARD_OPTION_CODE35("00035","getOpSuspenderBtn","","opSuspenderBtnPrice"),//サスペンダー釦
	PANTS_STANDARD_OPTION_CODE36("00036","getOpEight","","opEightPrice"),//エイト（滑り止め）
	PANTS_STANDARD_OPTION_CODE41("00041","getOpThick","","opThickPrice"),//シック大（股補強）
	PANTS_STANDARD_OPTION_CODE37("00037","getOpShapeMemory","","opShapeMemoryPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private PantsCoOptionStandardUpperPriceEnum(String k ,String v1 ,String v2 ,String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.getValueThree());
    }  
  
    public static PantsCoOptionStandardUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsCoOptionStandardUpperPriceEnum get(String str) {
        for (PantsCoOptionStandardUpperPriceEnum e : values()) {
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
