package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2CoOptionStandardUpperPriceEnum {

	// OptionForm
	// Key:OptionPants2StandardInfoのoption_code
	// Value1:OptionPants2StandardInfoの method
	
	PANTS_STANDARD_OPTION_CODE01("00001","getOp2Tack","","op2TackPrice"),//タック
	PANTS_STANDARD_OPTION_CODE02("00002","getOp2KneeBack","","op2KneeBackPrice"),//膝裏
	PANTS_STANDARD_OPTION_CODE03("00003","getOp2KneeBackMate","","op2KneeBackMatePrice"),//膝裏素材
	PANTS_STANDARD_OPTION_CODE04("00004","getOp2FrontSpec","","op2FrontSpecPrice"),//フロント仕様
	PANTS_STANDARD_OPTION_CODE05("00005","getOp2Pancherina","","op2PancherinaPrice"),//パンチェリーナ
	PANTS_STANDARD_OPTION_CODE06("00006","getOp2Adjuster","","op2AdjusterPrice"),//アジャスター仕様
	PANTS_STANDARD_OPTION_CODE07("00007","getOp2BeltLoop","","op2BeltLoopPrice"),//ベルトループ変更
	PANTS_STANDARD_OPTION_CODE09("00009","getOp2PinLoop","","op2PinLoopPrice"),//ピンループ
	PANTS_STANDARD_OPTION_CODE10("00010","getOp2SidePkt","","op2SidePktPrice"),//脇ポケット
	PANTS_STANDARD_OPTION_CODE11("00011","getOp2SinobiPkt","","op2SinobiPktPrice"),//忍びポケット
	PANTS_STANDARD_OPTION_CODE12("00012","getOp2CoinPkt","","op2CoinPktPrice"),//コインポケット
	PANTS_STANDARD_OPTION_CODE13("00013","getOp2FlapCoinPkt","","op2FlapCoinPktPrice"),//フラップ付コインポケット
	PANTS_STANDARD_OPTION_CODE14("00014","getOp2PisPktUf","","op2PisPktUfPrice"),//上前ピスポケット
	PANTS_STANDARD_OPTION_CODE15("00015","getOp2PisPktDf","","op2PisPktDfPrice"),//下前ピスポケット
	PANTS_STANDARD_OPTION_CODE16("00016","getOp2VCut","","op2VCutPrice"),//Vカット
	PANTS_STANDARD_OPTION_CODE17("00017","getOp2HemUp","","op2HemUpPrice"),//裾上げ
	PANTS_STANDARD_OPTION_CODE18("00018","getOp2DoubleWide","","op2DoubleWidePrice"),//ダブル幅
	PANTS_STANDARD_OPTION_CODE19("00019","getOp2Stitch","","op2StitchPrice"),//ステッチ種類
	PANTS_STANDARD_OPTION_CODE20("00020","getOp2StitchModify","","op2StitchModifyPrice"),//ステッチ箇所変更
	PANTS_STANDARD_OPTION_CODE22("00022","getOp2DStitch","","op2DStitchPrice"),//ダブルステッチ
	PANTS_STANDARD_OPTION_CODE24("00024","getOp2AmfColor","","op2AmfColorPrice"),//AMF色指定
	PANTS_STANDARD_OPTION_CODE27("00027","getOp2BhColor","","op2BhColorPrice"),//ボタンホール色指定
	PANTS_STANDARD_OPTION_CODE30("00030","getOp2ByColor","","op2ByColorPrice"),//ボタン付け糸指定
	PANTS_STANDARD_OPTION_CODE33("00033","getOp2Button","getOp2BtnMateStkNo","op2BtnMateStkNoPrice"),//釦素材
	PANTS_STANDARD_OPTION_CODE35("00035","getOp2SuspenderBtn","","op2SuspenderBtnPrice"),//サスペンダー釦
	PANTS_STANDARD_OPTION_CODE36("00036","getOp2Eight","","op2EightPrice"),//エイト（滑り止め）
	PANTS_STANDARD_OPTION_CODE41("00041","getOp2Thick","","op2ThickPrice"),//シック（股補強）
	PANTS_STANDARD_OPTION_CODE37("00037","getOp2ShapeMemory","","op2ShapeMemoryPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private Pants2CoOptionStandardUpperPriceEnum(String k ,String v1 , String v2 , String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static Pants2CoOptionStandardUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2CoOptionStandardUpperPriceEnum get(String str) {
        for (Pants2CoOptionStandardUpperPriceEnum e : values()) {
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
