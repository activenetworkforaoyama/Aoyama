package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2CoOptionTuxedoPriceEnum {

	// OptionForm
	// Key:OptionPants2TUXEDOInfo option_code
	// Value:OptionPants2TUXEDOInfo method
	// Value:OptionPants2TUXEDOInfo method
	// Value:order method
	
	PANTS_TUXEDO_OPTION_CODE01("00001","getTp2Tack","","setPt2TackRtPrice"),//タック
	PANTS_TUXEDO_OPTION_CODE02("00002","getTp2KneeBack","","setPt2KneeinnerTypeRtPrice"),//膝裏
	PANTS_TUXEDO_OPTION_CODE03("00003","getTp2KneeBackMate","","setPt2KneeinnerClothRtPrice"),//膝裏素材
	PANTS_TUXEDO_OPTION_CODE04("00004","getTp2FrontSpec","","setPt2FrtTypeRtPrice"),//フロント仕様
	PANTS_TUXEDO_OPTION_CODE05("00005","getTp2Pancherina","","setPt2PancherinaRtPrice"),//パンチェリーナ
	PANTS_TUXEDO_OPTION_CODE06("00006","getTp2Adjuster","","setPt2AdjusterRtPrice"),//アジャスター仕様
	PANTS_TUXEDO_OPTION_CODE07("00007","getTp2BeltLoop","","setPt2AdjusterRtPrice"),//ベルトループ変更
	PANTS_TUXEDO_OPTION_CODE09("00009","getTp2PinLoop","","setPt2PinloopRtPrice"),//ピンループ
	PANTS_TUXEDO_OPTION_CODE10("00010","getTp2SidePkt","","setPt2SidePktRtPrice"),//脇ポケット
	PANTS_TUXEDO_OPTION_CODE11("00011","getTp2SinobiPkt","","setPt2ShinobiPktRtPrice"),//忍びポケット
	PANTS_TUXEDO_OPTION_CODE12("00012","getTp2CoinPkt","","setPt2CoinPktRtPrice"),//コインポケット
	PANTS_TUXEDO_OPTION_CODE13("00013","getTp2FlapCoinPkt","","setPt2FlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_TUXEDO_OPTION_CODE14("00014","getTp2PisPktUf","","setPt2LeftPisPktRtPrice"),//上前ピスポケット
	PANTS_TUXEDO_OPTION_CODE15("00015","getTp2PisPktDf","","setPt2RightPisPktRtPrice"),//下前ピスポケット
	PANTS_TUXEDO_OPTION_CODE16("00016","getTp2VCut","","setPt2VCutRtPrice"),//Vカット
	PANTS_TUXEDO_OPTION_CODE17("00017","getTp2HemUp","","setPt2HemUpRtPrice"),//裾上げ
	PANTS_TUXEDO_OPTION_CODE18("00018","getTp2DoubleWide","","setPt2DblWidthRtPrice"),//ダブル幅
	PANTS_TUXEDO_OPTION_CODE19("00019","getTp2Stitch","","setPt2AmfStitchRtPrice"),//ステッチ種類
	PANTS_TUXEDO_OPTION_CODE27("00027","getTp2BhColor","","setPt2BtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_TUXEDO_OPTION_CODE30("00030","getTp2ByColor","","setPt2BtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_TUXEDO_OPTION_CODE33("00033","getTp2Button","getTp2BtnMateStkNo","setPt2BtnMaterialRtPrice"),//釦素材
	PANTS_TUXEDO_OPTION_CODE35("00035","getTp2SuspenderBtn","","setPt2SuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_TUXEDO_OPTION_CODE36("00036","getTp2Eight","","setPt2NonSlipRtPrice"),//エイト（滑り止め）
	PANTS_TUXEDO_OPTION_CODE41("00041","getTp2Thick","","setPt2ChicSlipRtPrice"),//シック（股補強）
	PANTS_TUXEDO_OPTION_CODE37("00037","getTp2ShapeMemory","","setPt2ShapeMemoryRtPrice"),//形状記憶
	PANTS_TUXEDO_OPTION_CODE39("00039","getTp2SideStripe","","setPt2SideStripeRtPrice"),//側章
	PANTS_TUXEDO_OPTION_CODE40("00040","getTp2SideStripeWidth","","setPt2SideStripeWidthRtPrice");//側章幅
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private Pants2CoOptionTuxedoPriceEnum(String k ,String v1 , String v2 , String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static Pants2CoOptionTuxedoPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2CoOptionTuxedoPriceEnum get(String str) {
        for (Pants2CoOptionTuxedoPriceEnum e : values()) {
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
