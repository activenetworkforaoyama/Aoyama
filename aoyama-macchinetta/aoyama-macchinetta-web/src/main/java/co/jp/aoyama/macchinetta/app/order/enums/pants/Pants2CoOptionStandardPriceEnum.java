package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum Pants2CoOptionStandardPriceEnum {

	// OptionForm
	// Key:OptionPants2StandardInfo option_code
	// Value:OptionPants2StandardInfo method
	// Value:OptionPants2StandardInfo method
	// Value:order method
	
	PANTS_STANDARD_OPTION_CODE01("00001","getOp2Tack","","setPt2TackRtPrice","op2_tack","","getPt2TackRtPrice"),//タック
	PANTS_STANDARD_OPTION_CODE02("00002","getOp2KneeBack","","setPt2KneeinnerTypeRtPrice","op2_kneeBack_id","","getPt2KneeinnerTypeRtPrice"),//膝裏
	PANTS_STANDARD_OPTION_CODE03("00003","getOp2KneeBackMate","","setPt2KneeinnerClothRtPrice","op2_kneeBackMate_id","","getPt2KneeinnerClothRtPrice"),//膝裏素材
	PANTS_STANDARD_OPTION_CODE04("00004","getOp2FrontSpec","","setPt2FrtTypeRtPrice","op2_frontSpec_id","","getPt2FrtTypeRtPrice"),//フロント仕様
	PANTS_STANDARD_OPTION_CODE05("00005","getOp2Pancherina","","setPt2PancherinaRtPrice","op2_pancherina_id","","getPt2PancherinaRtPrice"),//パンチェリーナ
	PANTS_STANDARD_OPTION_CODE06("00006","getOp2Adjuster","","setPt2AdjusterRtPrice","op2_adjuster_id","","getPt2AdjusterRtPrice"),//アジャスター仕様
	PANTS_STANDARD_OPTION_CODE07("00007","getOp2BeltLoop","","setPt2BeltloopRtPrice","op2_beltLoop_id","","getPt2BeltloopRtPrice"),//ベルトループ変更
	PANTS_STANDARD_OPTION_CODE09("00009","getOp2PinLoop","","setPt2PinloopRtPrice","op2_pinLoop_id","","getPt2PinloopRtPrice"),//ピンループ
	PANTS_STANDARD_OPTION_CODE10("00010","getOp2SidePkt","","setPt2SidePktRtPrice","op2_sidePkt_id","","getPt2SidePktRtPrice"),//脇ポケット
	PANTS_STANDARD_OPTION_CODE11("00011","getOp2SinobiPkt","","setPt2ShinobiPktRtPrice","op2_sinobiPkt_id","","getPt2ShinobiPktRtPrice"),//忍びポケット
	PANTS_STANDARD_OPTION_CODE12("00012","getOp2CoinPkt","","setPt2CoinPktRtPrice","op2_coinPkt","","getPt2CoinPktRtPrice"),//コインポケット
	PANTS_STANDARD_OPTION_CODE13("00013","getOp2FlapCoinPkt","","setPt2FlapcoinPktRtPrice","op2_flapCoinPkt_id","","getPt2FlapcoinPktRtPrice"),//フラップ付コインポケット
	PANTS_STANDARD_OPTION_CODE14("00014","getOp2PisPktUf","","setPt2LeftPisPktRtPrice","op2_pisPktUf_id","","getPt2LeftPisPktRtPrice"),//上前ピスポケット
	PANTS_STANDARD_OPTION_CODE15("00015","getOp2PisPktDf","","setPt2RightPisPktRtPrice","op2_pisPktDf_id","","getPt2RightPisPktRtPrice"),//下前ピスポケット
	PANTS_STANDARD_OPTION_CODE16("00016","getOp2VCut","","setPt2VCutRtPrice","op2_vCut_id","","getPt2VCutRtPrice"),//Vカット
	PANTS_STANDARD_OPTION_CODE17("00017","getOp2HemUp","","setPt2HemUpRtPrice","op2_hemUp","","getPt2HemUpRtPrice"),//裾上げ
	PANTS_STANDARD_OPTION_CODE18("00018","getOp2DoubleWide","","setPt2DblWidthRtPrice","op2_doubleWide","","getPt2DblWidthRtPrice"),//ダブル幅
	PANTS_STANDARD_OPTION_CODE19("00051","getOp2Stitch","","setPt2AmfStitchRtPrice","op2_stitch_id","","getPt2AmfStitchRtPrice"),//ステッチ種類
	PANTS_STANDARD_OPTION_CODE20("00020","getOp2StitchModify","","setPt2StitchPlcRtPrice","op2_stitchModify_id","","getPt2StitchPlcRtPrice"),//ステッチ箇所変更
	PANTS_STANDARD_OPTION_CODE22("00022","getOp2DStitch","","setPt2DblstitchPlcRtPrice","op2_dStitch_id","","getPt2DblstitchPlcRtPrice"),//ダブルステッチ
	PANTS_STANDARD_OPTION_CODE24("00024","getOp2AmfColor","","setPt2AmfColorRtPrice","op2_amfColor_id","","getPt2AmfColorRtPrice"),//AMF色指定
	PANTS_STANDARD_OPTION_CODE27("00027","getOp2BhColor","","setPt2BtnholeColorRtPrice","op2_bhColor_id","","getPt2BtnholeColorRtPrice"),//ボタンホール色指定
	PANTS_STANDARD_OPTION_CODE30("00030","getOp2ByColor","","setPt2BtnthreadColorRtPrice","op2_byColor_id","","getPt2BtnthreadColorRtPrice"),//ボタン付け糸指定
	PANTS_STANDARD_OPTION_CODE33("00033","getOp2Button","getOp2BtnMateStkNo","setPt2BtnMaterialRtPrice","op2_btnMate","op2_btnMateStkNo","getPt2BtnMaterialRtPrice"),//釦素材
	PANTS_STANDARD_OPTION_CODE35("00035","getOp2SuspenderBtn","","setPt2SuspenderBtnRtPrice","op2_suspenderBtn_id","","getPt2SuspenderBtnRtPrice"),//サスペンダー釦
	PANTS_STANDARD_OPTION_CODE36("00036","getOp2Eight","","setPt2NonSlipRtPrice","op2_eight_id","","getPt2NonSlipRtPrice"),//エイト（滑り止め）
	PANTS_STANDARD_OPTION_CODE41("00041","getOp2Thick","","setPt2ChicSlipRtPrice","op2_thick_id","","getPt2ChicSlipRtPrice"),//シック（股補強）
	PANTS_STANDARD_OPTION_CODE37("00037","getOp2ShapeMemory","","setPt2ShapeMemoryRtPrice","op2_shapeMemory_id","","getPt2ShapeMemoryRtPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
    
    private Pants2CoOptionStandardPriceEnum(String k ,String v1 , String v2 , String v3, String v4, String v5, String v6) {
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
  
    public static Pants2CoOptionStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Pants2CoOptionStandardPriceEnum get(String str) {
        for (Pants2CoOptionStandardPriceEnum e : values()) {
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
