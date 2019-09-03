package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2CoOptionTuxedoUpperPriceEnum {

	// OptionForm
	// Key:OptionPants2TuxedoInfoのoption_code
	// Value1:OptionPants2TuxedoInfoの method
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	PANTS_TUXEDO_OPTION_CODE01("00001","getTp2Tack","","tp2TackPrice"),//タック
	PANTS_TUXEDO_OPTION_CODE02("00002","getTp2KneeBack","","tp2KneeBackPrice"),//膝裏
	PANTS_TUXEDO_OPTION_CODE03("00003","getTp2KneeBackMate","","tp2KneeBackMatePrice"),//膝裏素材
	PANTS_TUXEDO_OPTION_CODE04("00004","getTp2FrontSpec","","tp2FrontSpecPrice"),//フロント仕様
	PANTS_TUXEDO_OPTION_CODE05("00005","getTp2Pancherina","","tp2PancherinaPrice"),//パンチェリーナ
	PANTS_TUXEDO_OPTION_CODE06("00006","getTp2Adjuster","","tp2AdjusterPrice"),//アジャスター仕様
	PANTS_TUXEDO_OPTION_CODE07("00007","getTp2BeltLoop","","tp2BeltLoopPrice"),//ベルトループ変更
	PANTS_TUXEDO_OPTION_CODE09("00009","getTp2PinLoop","","tp2PinLoopPrice"),//ピンループ
	PANTS_TUXEDO_OPTION_CODE10("00010","getTp2SidePkt","","tp2SidePktPrice"),//脇ポケット
	PANTS_TUXEDO_OPTION_CODE11("00011","getTp2SinobiPkt","","tp2SinobiPktPrice"),//忍びポケット
	PANTS_TUXEDO_OPTION_CODE12("00012","getTp2CoinPkt","","tp2CoinPktPrice"),//コインポケット
	PANTS_TUXEDO_OPTION_CODE13("00013","getTp2FlapCoinPkt","","tp2FlapCoinPktPrice"),//フラップ付コインポケット
	PANTS_TUXEDO_OPTION_CODE14("00014","getTp2PisPktUf","","tp2PisPktUfPrice"),//上前ピスポケット
	PANTS_TUXEDO_OPTION_CODE15("00015","getTp2PisPktDf","","tp2PisPktDfPrice"),//下前ピスポケット
	PANTS_TUXEDO_OPTION_CODE16("00016","getTp2VCut","","tp2VCutPrice"),//Vカット
	PANTS_TUXEDO_OPTION_CODE17("00017","getTp2HemUp","","tp2HemUpPrice"),//裾上げ
	PANTS_TUXEDO_OPTION_CODE18("00018","getTp2DoubleWide","","tp2DoubleWidePrice"),//ダブル幅
	PANTS_TUXEDO_OPTION_CODE19("00019","getTp2Stitch","","tp2StitchPrice"),//ステッチ種類
	PANTS_TUXEDO_OPTION_CODE27("00027","getTp2BhColor","","tp2BhColorPrice"),//ボタンホール色指定
	PANTS_TUXEDO_OPTION_CODE30("00030","getTp2ByColor","","tp2ByColorPrice"),//ボタン付け糸指定
	PANTS_TUXEDO_OPTION_CODE33("00033","getTp2Button","getTp2BtnMateStkNo","tp2BtnMateStkNoPrice"),//釦素材
	PANTS_TUXEDO_OPTION_CODE35("00035","getTp2SuspenderBtn","","tp2SuspenderBtnPrice"),//サスペンダー釦
	PANTS_TUXEDO_OPTION_CODE36("00036","getTp2Eight","","tp2EightPrice"),//エイト（滑り止め）
	PANTS_TUXEDO_OPTION_CODE41("00041","getTp2Thick","","tp2ThickPrice"),//シック（股補強）
	PANTS_TUXEDO_OPTION_CODE37("00037","getTp2ShapeMemory","","tp2ShapeMemoryPrice"),//形状記憶
	PANTS_TUXEDO_OPTION_CODE39("00039","getTp2SideStripe","","tp2SideStripePrice"),//側章
	PANTS_TUXEDO_OPTION_CODE40("00040","getTp2SideStripeWidth","","tp2SideStripeWidthPrice");//側章幅
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private Pants2CoOptionTuxedoUpperPriceEnum(String k ,String v1 , String v2 , String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.getValueThree());
    }  
  
    public static Pants2CoOptionTuxedoUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2CoOptionTuxedoUpperPriceEnum get(String str) {
        for (Pants2CoOptionTuxedoUpperPriceEnum e : values()) {
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
