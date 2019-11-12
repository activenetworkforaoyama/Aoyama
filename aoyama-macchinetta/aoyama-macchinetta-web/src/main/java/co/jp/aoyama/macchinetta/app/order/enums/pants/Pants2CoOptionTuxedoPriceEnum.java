package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2CoOptionTuxedoPriceEnum {

	// OptionForm
	// Key:OptionPants2TUXEDOInfo option_code
	// Value:OptionPants2TUXEDOInfo method
	// Value:OptionPants2TUXEDOInfo method
	// Value:order method
	
	PANTS_TUXEDO_OPTION_CODE01("00001","getTp2Tack","","setPt2TackRtPrice","tp2_tack","","getPt2TackRtPrice"),//タック
	PANTS_TUXEDO_OPTION_CODE02("00002","getTp2KneeBack","","setPt2KneeinnerTypeRtPrice","tp2_kneeBack_id","","getPt2KneeinnerTypeRtPrice"),//膝裏
	PANTS_TUXEDO_OPTION_CODE03("00003","getTp2KneeBackMate","","setPt2KneeinnerClothRtPrice","tp2_kneeBackMate_id","","getPt2KneeinnerClothRtPrice"),//膝裏素材
	PANTS_TUXEDO_OPTION_CODE04("00004","getTp2FrontSpec","","setPt2FrtTypeRtPrice","tp2_frontSpec_id","","getPt2FrtTypeRtPrice"),//フロント仕様
	PANTS_TUXEDO_OPTION_CODE05("00005","getTp2Pancherina","","setPt2PancherinaRtPrice","tp2_pancherina_id","","getPt2PancherinaRtPrice"),//パンチェリーナ
	PANTS_TUXEDO_OPTION_CODE06("00006","getTp2Adjuster","","setPt2AdjusterRtPrice","tp2_adjuster_id","","getPt2AdjusterRtPrice"),//アジャスター仕様
	PANTS_TUXEDO_OPTION_CODE07("00007","getTp2BeltLoop","","setPt2BeltloopRtPrice","tp2_beltLoop_id","","getPt2BeltloopRtPrice"),//ベルトループ変更
	PANTS_TUXEDO_OPTION_CODE09("00009","getTp2PinLoop","","setPt2PinloopRtPrice","tp2_pinLoop_id","","getPt2PinloopRtPrice"),//ピンループ
	PANTS_TUXEDO_OPTION_CODE10("00010","getTp2SidePkt","","setPt2SidePktRtPrice","tp2_sidePkt_id","","getPt2SidePktRtPrice"),//脇ポケット
	PANTS_TUXEDO_OPTION_CODE11("00011","getTp2SinobiPkt","","setPt2ShinobiPktRtPrice","tp2_sinobiPkt_id","","getPt2ShinobiPktRtPrice"),//忍びポケット
	PANTS_TUXEDO_OPTION_CODE12("00012","getTp2CoinPkt","","setPt2CoinPktRtPrice","tp2_coinPkt_id","","getPt2CoinPktRtPrice"),//コインポケット
	PANTS_TUXEDO_OPTION_CODE13("00013","getTp2FlapCoinPkt","","setPt2FlapcoinPktRtPrice","tp2_flapCoinPkt_id","","getPt2FlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_TUXEDO_OPTION_CODE14("00014","getTp2PisPktUf","","setPt2LeftPisPktRtPrice","tp2_pisPktUf_id","","getPt2LeftPisPktRtPrice"),//上前ピスポケット
	PANTS_TUXEDO_OPTION_CODE15("00015","getTp2PisPktDf","","setPt2RightPisPktRtPrice","tp2_pisPktDf_id","","getPt2RightPisPktRtPrice"),//下前ピスポケット
	PANTS_TUXEDO_OPTION_CODE16("00016","getTp2VCut","","setPt2VCutRtPrice","tp2_vCut_id","","getPt2VCutRtPrice"),//Vカット
	PANTS_TUXEDO_OPTION_CODE17("00017","getTp2HemUp","","setPt2HemUpRtPrice","tp2_hemUp","","getPt2HemUpRtPrice"),//裾上げ
	PANTS_TUXEDO_OPTION_CODE18("00018","getTp2DoubleWide","","setPt2DblWidthRtPrice","tp2_doubleWide","","getPt2DblWidthRtPrice"),//ダブル幅
	PANTS_TUXEDO_OPTION_CODE19("00051","getTp2Stitch","","setPt2AmfStitchRtPrice","tp2_stitch_id","","getPt2AmfStitchRtPrice"),//ステッチ種類
	PANTS_TUXEDO_OPTION_CODE27("00027","getTp2BhColor","","setPt2BtnholeColorRtPrice","tp2_bhColor_id","","getPt2BtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_TUXEDO_OPTION_CODE30("00030","getTp2ByColor","","setPt2BtnthreadColorRtPrice","tp2_byColor_id","","getPt2BtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_TUXEDO_OPTION_CODE33("00033","getTp2Button","getTp2BtnMateStkNo","setPt2BtnMaterialRtPrice","tp2_btnMate","tp2_btnMateStkNo","getPt2BtnMaterialRtPrice"),//釦素材
	PANTS_TUXEDO_OPTION_CODE35("00035","getTp2SuspenderBtn","","setPt2SuspenderBtnRtPrice","tp2_suspenderBtn_id","","getPt2SuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_TUXEDO_OPTION_CODE36("00036","getTp2Eight","","setPt2NonSlipRtPrice","tp2_eight_id","","getPt2NonSlipRtPrice"),//エイト（滑り止め）
	PANTS_TUXEDO_OPTION_CODE41("00041","getTp2Thick","","setPt2ChicSlipRtPrice","tp2_thick_id","","getPt2ChicSlipRtPrice"),//シック（股補強）
	PANTS_TUXEDO_OPTION_CODE37("00037","getTp2ShapeMemory","","setPt2ShapeMemoryRtPrice","tp2_shapeMemory_id","","getPt2ShapeMemoryRtPrice"),//形状記憶
	PANTS_TUXEDO_OPTION_CODE39("00039","getTp2SideStripe","","setPt2SideStripeRtPrice","tp2_sideStripe_id","","getPt2SideStripeRtPrice"),//側章
	PANTS_TUXEDO_OPTION_CODE40("00040","getTp2SideStripeWidth","","setPt2SideStripeWidthRtPrice","tp2_sideStripeWidth_id","","getPt2SideStripeWidthRtPrice"),//側章幅
	PANTS_TUXEDO_OPTION_CODE50("00050","getTp2GlossFablic","","setPt2LookClothRtPrice","tp2_GlossFablic","","getPt2LookClothRtPrice");//拝絹地
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
    
    private Pants2CoOptionTuxedoPriceEnum(String k ,String v1 , String v2 , String v3, String v4, String v5, String v6) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour = v4;
		this.valueFive = v5;
		this.valueSix = v6;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(this.valueFour).concat(",").concat(this.valueFive).concat(",").concat(this.valueSix);
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

	public String getValueFour() {
		return valueFour;
	}

	public String getValueFive() {
		return valueFive;
	}

	public String getValueSix() {
		return valueSix;
	}
    
}
