package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsCoOptionTuxedoPriceEnum {

	// OptionForm
	// Key:OptionPantsTUXEDOInfo option_code
	// ValueOne:OptionPantsTUXEDOInfo method
	// ValueTwo:OptionPantsTUXEDOInfo method
	// ValueThree:order method
	
	PANTS_TUXEDO_OPTION_CODE01("00001","getTpTack","","setPtTackRtPrice","tp_tack","","getPtTackRtPrice"),//タック
	PANTS_TUXEDO_OPTION_CODE02("00002","getTpKneeBack","","setPtKneeinnerTypeRtPrice","tp_kneeBack_id","","getPtKneeinnerTypeRtPrice"),//膝裏
	PANTS_TUXEDO_OPTION_CODE03("00003","getTpKneeBackMate","","setPtKneeinnerClothRtPrice","tp_kneeBackMate_id","","getPtKneeinnerClothRtPrice"),//膝裏素材
	PANTS_TUXEDO_OPTION_CODE04("00004","getTpFrontSpec","","setPtFrtTypeRtPrice","tp_frontSpec_id","","getPtFrtTypeRtPrice"),//フロント仕様
	PANTS_TUXEDO_OPTION_CODE05("00005","getTpPancherina","","setPtPancherinaRtPrice","tp_pancherina_id","","getPtPancherinaRtPrice"),//パンチェリーナ
	PANTS_TUXEDO_OPTION_CODE06("00006","getTpAdjuster","","setPtAdjusterRtPrice","tp_adjuster_id","","getPtAdjusterRtPrice"),//アジャスター仕様
	PANTS_TUXEDO_OPTION_CODE07("00007","getTpBeltLoop","","setPtBeltLoopRtPrice","tp_beltLoop_id","","getPtBeltLoopRtPrice"),//ベルトループ変更
	PANTS_TUXEDO_OPTION_CODE08("00009","getTpPinLoop","","setPtPinLoopRtPrice","tp_pinLoop_id","","getPtPinLoopRtPrice"),//ピンループ
	PANTS_TUXEDO_OPTION_CODE10("00010","getTpSidePkt","","setPtSidePktRtPrice","tp_sidePkt_id","","getPtSidePktRtPrice"),//脇ポケット
	PANTS_TUXEDO_OPTION_CODE11("00011","getTpSinobiPkt","","setPtShinobiPktRtPrice","tp_sinobiPkt_id","","getPtShinobiPktRtPrice"),//忍びポケット
	PANTS_TUXEDO_OPTION_CODE12("00012","getTpCoinPkt","","setPtCoinPktRtPrice","tp_coinPkt","","getPtCoinPktRtPrice"),//コインポケット
	PANTS_TUXEDO_OPTION_CODE13("00013","getTpFlapCoinPkt","","setPtFlapcoinPktRtPrice","tp_flapCoinPkt_id","","getPtFlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_TUXEDO_OPTION_CODE14("00014","getTpPisPktUf","","setPtLeftPisPktRtPrice","tp_pisPktUf_id","","getPtLeftPisPktRtPrice"),//上前ピスポケット
	PANTS_TUXEDO_OPTION_CODE15("00015","getTpPisPktDf","","setPtRightPisPktRtPrice","tp_pisPktDf_id","","getPtRightPisPktRtPrice"),//下前ピスポケット
	PANTS_TUXEDO_OPTION_CODE16("00016","getTpVCut","","setPtVCutRtPrice","tp_vCut_id","","getPtVCutRtPrice"),//Vカット
	PANTS_TUXEDO_OPTION_CODE17("00017","getTpHemUp","","setPtHemUpRtPrice","tp_hemUp","","getPtHemUpRtPrice"),//裾上げ
	PANTS_TUXEDO_OPTION_CODE18("00018","getTpDoubleWide","","setPtDblWidthRtPrice","tp_doubleWide","","getPtDblWidthRtPrice"),//ダブル幅
	PANTS_TUXEDO_OPTION_CODE19("00051","getTpStitch","","setPtAmfStitchRtPrice","tp_stitch_id","","getPtAmfStitchRtPrice"),//ステッチ種類
	PANTS_TUXEDO_OPTION_CODE27("00027","getTpBhColor","","setPtBtnholeColorRtPrice","tp_bhColor_id","","getPtBtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_TUXEDO_OPTION_CODE30("00030","getTpByColor","","setPtBtnthreadColorRtPrice","tp_byColor_id","","getPtBtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_TUXEDO_OPTION_CODE33("00033","getTpButton","getTpBtnMateStkNo","setPtBtnMaterialRtPrice","tp_btnMate","tp_btnMateStkNo","getPtBtnMaterialRtPrice"),//釦素材
	PANTS_TUXEDO_OPTION_CODE35("00035","getTpSuspenderBtn","","setPtSuspenderBtnRtPrice","tp_suspenderBtn_id","","getPtSuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_TUXEDO_OPTION_CODE36("00036","getTpEight","","setPtNonSlipRtPrice","tp_eight_id","","getPtNonSlipRtPrice"),//エイト（滑り止め）
	PANTS_TUXEDO_OPTION_CODE41("00041","getTpThick","","setPtChicSlipRtPrice","tp_thick_id","","getPtChicSlipRtPrice"),//シック大（股補強）
	PANTS_TUXEDO_OPTION_CODE37("00037","getTpShapeMemory","","setPtShapeMemoryRtPrice","tp_shapeMemory_id","","getPtShapeMemoryRtPrice"),//形状記憶
	PANTS_TUXEDO_OPTION_CODE39("00039","getTpSideStripe","","setPtSideStripeRtPrice","tp_sideStripe_id","","getPtSideStripeRtPrice"),//側章
	PANTS_TUXEDO_OPTION_CODE40("00040","getTpSideStripeWidth","","setPtSideStripeWidthRtPrice","tp_sideStripeWidth_id","","getPtSideStripeWidthRtPrice"),//側章幅
	PANTS_TUXEDO_OPTION_CODE50("00050","getTpGlossFablic","","setPtLookClothRtPrice","tp_GlossFablic","","getPtLookClothRtPrice");//拝絹地
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;

	private PantsCoOptionTuxedoPriceEnum(String k, String v1, String v2, String v3, String v4, String v5, String v6) {
		this.key = k;
		this.valueOne = v1;
		this.valueTwo = v2;
		this.valueThree = v3;
		this.valueFour = v4;
		this.valueFive = v5;
		this.valueSix = v6;
	}

	@Override
	public String toString() {
		return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",")
				.concat(this.valueThree).concat(",").concat(this.valueFour).concat(",").concat(this.valueFive)
				.concat(",").concat(this.valueSix);
	}  
  
    public static PantsCoOptionTuxedoPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsCoOptionTuxedoPriceEnum get(String str) {
        for (PantsCoOptionTuxedoPriceEnum e : values()) {
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
