package co.jp.aoyama.macchinetta.app.order.enums.pants;

public enum PantsCoOptionStandardPriceEnum {

	// OptionForm
	// Key:OptionPants2StandardInfo option_code
	// Value:OptionPants2StandardInfo method
	// Value:OptionPants2StandardInfo method
	// Value:order method

	PANTS_STANDARD_OPTION_CODE01("00001", "getOpTack", "", "setPtTackRtPrice", "op_tack", "", "getPtTackRtPrice"), // タック
	PANTS_STANDARD_OPTION_CODE02("00002", "getOpKneeBack", "", "setPtKneeinnerTypeRtPrice", "op_kneeBack_id", "", "getPtKneeinnerTypeRtPrice"), // 膝裏
	PANTS_STANDARD_OPTION_CODE03("00003", "getOpKneeBackMate", "", "setPtKneeinnerClothRtPrice", "op_kneeBackMate_id", "", "getPtKneeinnerClothRtPrice"), // 膝裏素材
	PANTS_STANDARD_OPTION_CODE04("00004", "getOpFrontSpec", "", "setPtFrtTypeRtPrice", "op_frontSpec_id", "", "getPtFrtTypeRtPrice"), // フロント仕様
	PANTS_STANDARD_OPTION_CODE05("00005", "getOpPancherina", "", "setPtPancherinaRtPrice", "op_pancherina_id", "", "getPtPancherinaRtPrice"), // パンチェリーナ
	PANTS_STANDARD_OPTION_CODE06("00006", "getOpAdjuster", "", "setPtAdjusterRtPrice", "op_adjuster_id", "", "getPtAdjusterRtPrice"), // アジャスター仕様
	PANTS_STANDARD_OPTION_CODE07("00007", "getOpBeltLoop", "", "setPtBeltLoopRtPrice", "op_beltLoop_id", "", "getPtBeltLoopRtPrice"), // ベルトループ変更
	PANTS_STANDARD_OPTION_CODE09("00009", "getOpPinLoop", "", "setPtPinLoopRtPrice", "op_pinLoop_id", "", "getPtPinLoopRtPrice"), // ピンループ
	PANTS_STANDARD_OPTION_CODE10("00010", "getOpSidePkt", "", "setPtSidePktRtPrice", "op_sidePkt_id", "", "getPtSidePktRtPrice"), // 脇ポケット
	PANTS_STANDARD_OPTION_CODE11("00011", "getOpSinobiPkt", "", "setPtShinobiPktRtPrice", "op_sinobiPkt_id", "", "getPtShinobiPktRtPrice"), // 忍びポケット
	PANTS_STANDARD_OPTION_CODE12("00012", "getOpCoinPkt", "", "setPtCoinPktRtPrice", "op_coinPkt", "", "getPtCoinPktRtPrice"), // コインポケット
	PANTS_STANDARD_OPTION_CODE13("00013", "getOpFlapCoinPkt", "", "setPtFlapcoinPktRtPrice", "op_flapCoinPkt_id", "", "getPtFlapcoinPktRtPrice"), // フラップ付コインポケット
	PANTS_STANDARD_OPTION_CODE14("00014", "getOpPisPktUf", "", "setPtLeftPisPktRtPrice", "op_pisPktUf_id", "", "getPtLeftPisPktRtPrice"), // 上前ピスポケット
	PANTS_STANDARD_OPTION_CODE15("00015", "getOpPisPktDf", "", "setPtRightPisPktRtPrice", "op_pisPktDf_id", "", "getPtRightPisPktRtPrice"), // 下前ピスポケット
	PANTS_STANDARD_OPTION_CODE16("00016", "getOpVCut", "", "setPtVCutRtPrice", "op_vCut_id", "", "getPtVCutRtPrice"), // Vカット
	PANTS_STANDARD_OPTION_CODE17("00017", "getOpHemUp", "", "setPtHemUpRtPrice", "op_hemUp", "", "getPtHemUpRtPrice"), // 裾上げ
	PANTS_STANDARD_OPTION_CODE18("00018", "getOpDoubleWide", "", "setPtDblWidthRtPrice", "op_doubleWide", "", "getPtDblWidthRtPrice"), // ダブル幅
	PANTS_STANDARD_OPTION_CODE19("00051", "getOpStitch", "", "setPtAmfStitchRtPrice", "op_stitch_id", "", "getPtAmfStitchRtPrice"), // ステッチ種類
	PANTS_STANDARD_OPTION_CODE20("00020", "getOpStitchModify", "", "setPtStitchPlcRtPrice", "op_stitchModify_id", "", "getPtStitchPlcRtPrice"), // ステッチ箇所変更
	PANTS_STANDARD_OPTION_CODE22("00022", "getOpDStitch", "", "setPtDblstitchPlcRtPrice", "op_dStitch_id", "", "getPtDblstitchPlcRtPrice"), // ダブルステッチ
	PANTS_STANDARD_OPTION_CODE24("00024", "getOpAmfColor", "", "setPtAmfColorRtPrice", "op_amfColor_id", "", "getPtAmfColorRtPrice"), // AMF色指定
	PANTS_STANDARD_OPTION_CODE27("00027", "getOpBhColor", "", "setPtBtnholeColorRtPrice", "op_bhColor_id", "", "getPtBtnholeColorRtPrice"), // ボタンホール色指定
	PANTS_STANDARD_OPTION_CODE30("00030", "getOpByColor", "", "setPtBtnthreadColorRtPrice", "op_byColor_id", "", "getPtBtnthreadColorRtPrice"), // ボタン付け糸指定
	PANTS_STANDARD_OPTION_CODE33("00033", "getOpButton", "getOpBtnMateStkNo", "setPtBtnMaterialRtPrice", "op_btnMate", "op_btnMateStkNo", "getPtBtnMaterialRtPrice"), // 釦素材
	PANTS_STANDARD_OPTION_CODE35("00035", "getOpSuspenderBtn", "", "setPtSuspenderBtnRtPrice", "op_suspenderBtn_id", "", "getPtSuspenderBtnRtPrice"), // サスペンダー釦
	PANTS_STANDARD_OPTION_CODE36("00036", "getOpEight", "", "setPtNonSlipRtPrice", "op_eight_id", "", "getPtNonSlipRtPrice"), // エイト（滑り止め）
	PANTS_STANDARD_OPTION_CODE41("00041", "getOpThick", "", "setPtChicSlipRtPrice", "op_thick_id", "", "getPtChicSlipRtPrice"), // シック（股補強）
	PANTS_STANDARD_OPTION_CODE37("00037", "getOpShapeMemory", "", "setPtShapeMemoryRtPrice", "op_shapeMemory_id", "", "getPtShapeMemoryRtPrice");// 形状記憶

	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;

	private PantsCoOptionStandardPriceEnum(String k, String v1, String v2, String v3, String v4, String v5, String v6) {
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

	public static PantsCoOptionStandardPriceEnum get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	public static PantsCoOptionStandardPriceEnum get(String str) {
		for (PantsCoOptionStandardPriceEnum e : values()) {
			if (e.toString().equals(str)) {
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
