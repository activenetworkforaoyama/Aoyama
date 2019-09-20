package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsCoOptionWashablePriceEnum {

	// OptionForm
	// Key:OptionPantsWASHABLEInfo option_code
	// ValueOne:OptionPantsWASHABLEInfo method
	// ValueTwo:OptionPantsWASHABLEInfo method
	// ValueThree:order method
	
	PANTS_WASHABLE_OPTION_CODE01("00001","getWpTack","","setPtTackRtPrice","wp_tack","","getPtTackRtPrice"),//タック
	PANTS_WASHABLE_OPTION_CODE02("00002","getWpKneeBack","","setPtKneeinnerTypeRtPrice","wp_kneeBack_id","","getPtKneeinnerTypeRtPrice"),//膝裏
	PANTS_WASHABLE_OPTION_CODE03("00003","getWpKneeBackMate","","setPtKneeinnerClothRtPrice","wp_kneeBackMate_id","","getPtKneeinnerClothRtPrice"),//膝裏素材
	PANTS_WASHABLE_OPTION_CODE04("00004","getWpFrontSpec","","setPtFrtTypeRtPrice","wp_frontSpec_id","","getPtFrtTypeRtPrice"),//フロント仕様
	PANTS_WASHABLE_OPTION_CODE05("00005","getWpPancherina","","setPtPancherinaRtPrice","wp_pancherina_id","","getPtPancherinaRtPrice"),//パンチェリーナ
	PANTS_WASHABLE_OPTION_CODE06("00006","getWpAdjuster","","setPtAdjusterRtPrice","wp_adjuster_id","","getPtAdjusterRtPrice"),//アジャスター仕様
	PANTS_WASHABLE_OPTION_CODE07("00007","getWpBeltLoop","","setPtBeltLoopRtPrice","wp_beltLoop_id","","getPtBeltLoopRtPrice"),//ベルトループ変更
	PANTS_WASHABLE_OPTION_CODE08("00009","getWpPinLoop","","setPtPinLoopRtPrice","wp_pinLoop_id","","getPtPinLoopRtPrice"),//ピンループ
	PANTS_WASHABLE_OPTION_CODE10("00010","getWpSidePkt","","setPtSidePktRtPrice","wp_sidePkt_id","","getPtSidePktRtPrice"),//脇ポケット
	PANTS_WASHABLE_OPTION_CODE11("00011","getWpSinobiPkt","","setPtShinobiPktRtPrice","wp_sinobiPkt_id","","getPtShinobiPktRtPrice"),//忍びポケット
	PANTS_WASHABLE_OPTION_CODE12("00012","getWpCoinPkt","","setPtCoinPktRtPrice","wp_coinPkt","","getPtCoinPktRtPrice"),//コインポケット
	PANTS_WASHABLE_OPTION_CODE13("00013","getWpFlapCoinPkt","","setPtFlapcoinPktRtPrice","wp_flapCoinPkt_id","","getPtFlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_WASHABLE_OPTION_CODE14("00014","getWpPisPktUf","","setPtLeftPisPktRtPrice","wp_pisPktUf_id","","getPtLeftPisPktRtPrice"),//上前ピスポケット
	PANTS_WASHABLE_OPTION_CODE15("00015","getWpPisPktDf","","setPtRightPisPktRtPrice","wp_pisPktDf_id","","getPtRightPisPktRtPrice"),//下前ピスポケット
	PANTS_WASHABLE_OPTION_CODE16("00016","getWpVCut","","setPtVCutRtPrice","wp_vCut_id","","getPtVCutRtPrice"),//Vカット
	PANTS_WASHABLE_OPTION_CODE17("00017","getWpHemUp","","setPtHemUpRtPrice","wp_hemUp","","getPtHemUpRtPrice"),//裾上げ
	PANTS_WASHABLE_OPTION_CODE18("00018","getWpDoubleWide","","setPtDblWidthRtPrice","wp_doubleWide","","getPtDblWidthRtPrice"),//ダブル幅
	PANTS_WASHABLE_OPTION_CODE19("00019","getWpStitch","","setPtAmfStitchRtPrice","wp_stitch_id","","getPtAmfStitchRtPrice"),//ステッチ種類
	PANTS_WASHABLE_OPTION_CODE20("00020","getWpStitchModify","","setPtStitchPlcRtPrice","wp_stitchModify_id","","getPtStitchPlcRtPrice"),//ステッチ箇所変更
	PANTS_WASHABLE_OPTION_CODE22("00022","getWpDStitch","","setPtDblstitchPlcRtPrice","wp_dStitch_id","","getPtDblstitchPlcRtPrice"),//ダブルステッチ
	PANTS_WASHABLE_OPTION_CODE24("00024","getWpAmfColor","","setPtAmfColorRtPrice","wp_amfColor_id","","getPtAmfColorRtPrice"),//AMF色指定
	PANTS_WASHABLE_OPTION_CODE27("00027","getWpBhColor","","setPtBtnholeColorRtPrice","wp_bhColor_id","","getPtBtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_WASHABLE_OPTION_CODE30("00030","getWpByColor","","setPtBtnthreadColorRtPrice","wp_byColor_id","","getPtBtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_WASHABLE_OPTION_CODE33("00033","getWpButton","getWpBtnMateStkNo","setPtBtnMaterialRtPrice","wp_btnMate","wp_btnMateStkNo","getPtBtnMaterialRtPrice"),//釦素材
	PANTS_WASHABLE_OPTION_CODE35("00035","getWpSuspenderBtn","","setPtSuspenderBtnRtPrice","wp_suspenderBtn_id","","getPtSuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_WASHABLE_OPTION_CODE36("00036","getWpEight","","setPtNonSlipRtPrice","wp_eight_id","","getPtNonSlipRtPrice"),//エイト（滑り止め）
	PANTS_WASHABLE_OPTION_CODE41("00041","getWpThick","","setPtChicSlipRtPrice","wp_thick_id","","getPtChicSlipRtPrice"),//シック大（股補強）
	PANTS_WASHABLE_OPTION_CODE37("00037","getWpShapeMemory","","setPtShapeMemoryRtPrice","wp_shapeMemory_id","","getPtShapeMemoryRtPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;

	private PantsCoOptionWashablePriceEnum(String k, String v1, String v2, String v3, String v4, String v5, String v6) {
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
  
    public static PantsCoOptionWashablePriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static PantsCoOptionWashablePriceEnum get(String str) {
        for (PantsCoOptionWashablePriceEnum e : values()) {
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
