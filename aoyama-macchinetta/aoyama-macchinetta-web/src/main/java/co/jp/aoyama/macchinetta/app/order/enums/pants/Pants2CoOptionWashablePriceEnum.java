package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2CoOptionWashablePriceEnum {

	// OptionForm
	// Key:OptionPants2WASHABLEInfo option_code
	// Value:OptionPants2WASHABLEInfo method
	// Value:OptionPants2WASHABLEInfo method
	// Value:order method
	
	PANTS_WASHABLE_OPTION_CODE01("00001","getWp2Tack","","setPt2TackRtPrice"),//タック
	PANTS_WASHABLE_OPTION_CODE02("00002","getWp2KneeBack","","setPt2KneeinnerTypeRtPrice"),//膝裏
	PANTS_WASHABLE_OPTION_CODE03("00003","getWp2KneeBackMate","","setPt2KneeinnerClothRtPrice"),//膝裏素材
	PANTS_WASHABLE_OPTION_CODE04("00004","getWp2FrontSpec","","setPt2FrtTypeRtPrice"),//フロント仕様
	PANTS_WASHABLE_OPTION_CODE05("00005","getWp2Pancherina","","setPt2PancherinaRtPrice"),//パンチェリーナ
	PANTS_WASHABLE_OPTION_CODE06("00006","getWp2Adjuster","","setPt2AdjusterRtPrice"),//アジャスター仕様
	PANTS_WASHABLE_OPTION_CODE07("00007","getWp2BeltLoop","","setPt2AdjusterRtPrice"),//ベルトループ変更
	PANTS_WASHABLE_OPTION_CODE09("00009","getWp2PinLoop","","setPt2PinloopRtPrice"),//ピンループ
	PANTS_WASHABLE_OPTION_CODE10("00010","getWp2SidePkt","","setPt2SidePktRtPrice"),//脇ポケット
	PANTS_WASHABLE_OPTION_CODE11("00011","getWp2SinobiPkt","","setPt2ShinobiPktRtPrice"),//忍びポケット
	PANTS_WASHABLE_OPTION_CODE12("00012","getWp2CoinPkt","","setPt2CoinPktRtPrice"),//コインポケット
	PANTS_WASHABLE_OPTION_CODE13("00013","getWp2FlapCoinPkt","","setPt2FlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_WASHABLE_OPTION_CODE14("00014","getWp2PisPktUf","","setPt2LeftPisPktRtPrice"),//上前ピスポケット
	PANTS_WASHABLE_OPTION_CODE15("00015","getWp2PisPktDf","","setPt2RightPisPktRtPrice"),//下前ピスポケット
	PANTS_WASHABLE_OPTION_CODE16("00016","getWp2VCut","","setPt2VCutRtPrice"),//Vカット
	PANTS_WASHABLE_OPTION_CODE17("00017","getWp2HemUp","","setPt2HemUpRtPrice"),//裾上げ
	PANTS_WASHABLE_OPTION_CODE18("00018","getWp2DoubleWide","","setPt2DblWidthRtPrice"),//ダブル幅
	PANTS_WASHABLE_OPTION_CODE19("00019","getWp2Stitch","","setPt2AmfStitchRtPrice"),//ステッチ種類
	PANTS_WASHABLE_OPTION_CODE20("00020","getWp2StitchModify","","setPt2StitchPlcRtPrice"),//ステッチ箇所変更
	PANTS_WASHABLE_OPTION_CODE22("00022","getWp2DStitch","","setPt2DblstitchPlcRtPrice"),//ダブルステッチ
	PANTS_WASHABLE_OPTION_CODE24("00024","getWp2AmfColor","","setPt2AmfColorRtPrice"),//AMF色指定
	PANTS_WASHABLE_OPTION_CODE27("00027","getWp2BhColor","","setPt2BtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_WASHABLE_OPTION_CODE30("00030","getWp2ByColor","","setPt2BtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_WASHABLE_OPTION_CODE33("00033","getWp2Button","getWp2BtnMateStkNo","setPt2BtnMaterialRtPrice"),//釦素材
	PANTS_WASHABLE_OPTION_CODE35("00035","getWp2SuspenderBtn","","setPt2SuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_WASHABLE_OPTION_CODE36("00036","getWp2Eight","","setPt2NonSlipRtPrice"),//エイト（滑り止め）
	PANTS_WASHABLE_OPTION_CODE41("00041","getWp2Thick","","setPt2ChicSlipRtPrice"),//シック（股補強）
	PANTS_WASHABLE_OPTION_CODE37("00037","getWp2ShapeMemory","","setPt2ShapeMemoryRtPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private Pants2CoOptionWashablePriceEnum(String k ,String v1 , String v2 , String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static Pants2CoOptionWashablePriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2CoOptionWashablePriceEnum get(String str) {
        for (Pants2CoOptionWashablePriceEnum e : values()) {
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
