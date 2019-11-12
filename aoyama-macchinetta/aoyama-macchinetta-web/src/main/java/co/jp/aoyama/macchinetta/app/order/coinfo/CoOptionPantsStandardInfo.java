package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.PtStItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.PtStOpHemUpItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.PtStOpKneeBackItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.PtStOpStitchItem;

public class CoOptionPantsStandardInfo implements Serializable{
	private static final long serialVersionUID = -4505963757793347479L;
	
	//2Pants
	private Map<String,String> twoPantsMap;
	
	//PANTSモデル
	@NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のモデルを入力して下さい。")
	private String opPantsModel;
	
	private Map<String,String> opPantsModelMap;
	
	//タック
	@NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のタックを入力して下さい。")
    private String opTack;
    
    private Map<String,String> opTackMap;
    
    private String ptTackRtPrice;
    
    //膝裏
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）の膝裏を入力して下さい。")
    private String opKneeBack;
    
    private Map<String,String> opKneeBackMap;
    
    private String ptKneeinnerTypeRtPrice;
    
    //膝裏素材
    @NotBlank(groups = { PtStOpKneeBackItem.class }, message = "PANTS（1本目）の膝裏素材を入力して下さい。")
    private String opKneeBackMate;

    private Map<String,String> opKneeBackMateMap;
    
    private String ptKneeinnerClothRtPrice;
    
    //フロント仕様
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のフロント仕様を入力して下さい。")
  	private String opFrontSpec;
      
    private Map<String,String> opFrontSpecMap;
    
    private String ptFrtTypeRtPrice;
    
    //パンチェリーナ
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のパンチェリーナを入力して下さい。")
    private String opPancherina;
    
    private Map<String,String> opPancherinaMap;
    
    private String ptPancherinaRtPrice;
    
    //アジャスター仕様
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のアジャスター仕様を入力して下さい。")
    private String opAdjuster;
    
    private Map<String,String> opAdjusterMap;
    
    private String ptAdjusterRtPrice;
    
    //ベルトループ
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のベルトループを入力して下さい。")
    private String opBeltLoop;
    
    private Map<String,String> opBeltLoopMap;
    
    private String ptBeltLoopRtPrice;
    
    //ベルトループ箇所 
    private String opBeltLoopPlace;
    
    private String opBeltLoopPlace1;
    
    private String opBeltLoopPlace2;
    
    private String opBeltLoopPlace3;
    
    private String opBeltLoopPlace4;
    
    private String opBeltLoopPlace5;
    
    private String opBeltLoopPlace6;
    
    private String opBeltLoopPlace7;
    
    private Map<String,String> opBeltLoopPlaceMap;
    
    //ピンループ
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のピンループを入力して下さい。")
    private String opPinLoop;
    
    private Map<String,String> opPinLoopMap;
    
    private String ptPinLoopRtPrice;
    
    //脇ポケット
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）の脇ポケットを入力して下さい。")
    private String opSidePkt;
    
    private Map<String,String> opSidePktMap;
    
    private String ptSidePktRtPrice;
    
    //忍びポケット
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）の忍びポケットを入力して下さい。")
    private String opSinobiPkt;
    
    private Map<String,String> opSinobiPktMap;
    
    private String ptShinobiPktRtPrice;
    
    //コインポケット
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のコインポケットを入力して下さい。")
    private String opCoinPkt;
    
    private Map<String,String> opCoinPktMap;
    
    private String ptCoinPktRtPrice;
    
    //フラップ付コインポケット
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のフラップ付コインポケットを入力して下さい。")
    private String opFlapCoinPkt;
    
    private Map<String,String> opFlapCoinPktMap;
    
    private String ptFlapcoinPktRtPrice;
    
    //上前ピスポケット
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）の上前ピスポケットを入力して下さい。")
    private String opPisPktUf;
    
    private Map<String,String> opPisPktUfMap;
    
    private String ptLeftPisPktRtPrice;
    
    //下前ピスポケット
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）の下前ピスポケットを入力して下さい。")
    private String opPisPktDf;
    
    private Map<String,String> opPisPktDfMap;
    
    private String ptRightPisPktRtPrice;
    
    //Vカット
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のVカットを入力して下さい。")
    private String opVCut;
    
    private Map<String,String> opVCutMap;
    
    private String ptVCutRtPrice;
    
    //裾上げ
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）の裾上げを入力して下さい。")
    private String opHemUp;
    
    private Map<String,String> opHemUpMap;
    
    private String ptHemUpRtPrice;
    
    //ダブル幅
    @NotBlank(groups = { PtStOpHemUpItem.class }, message = "PANTS（1本目）のダブル幅を入力して下さい。")
    private String opDoubleWide;
    
    private Map<String,String> opDoubleWideMap;
    
    private String ptDblWidthRtPrice;
    
    //AMFステッチ
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のステッチ種類を入力して下さい。")
    private String opStitch;
    
    private Map<String,String> opStitchMap;
    
    private String ptAmfStitchRtPrice;
    
    //ステッチ箇所変更
    @NotBlank(groups = { PtStOpStitchItem.class }, message = "PANTS（1本目）のステッチ箇所変更を入力して下さい。")
    private String opStitchModify;
    
    private Map<String,String> opStitchModifyMap;
    
    private String ptStitchPlcRtPrice;
    
    //ステッチ箇所変更箇所
    private String opStitchModifyPlace;
    
    private String opStitchModifyPlace1;
    
    private String opStitchModifyPlace2;
    
    private String opStitchModifyPlace3;
    
    private String opStitchModifyPlace4;
    
    private Map<String,String> opStitchModifyPlaceMap;
    
    //ダブルステッチ
    @NotBlank(groups = { PtStOpStitchItem.class }, message = "PANTS（1本目）のダブルステッチを入力して下さい。")
    private String opDStitch;
    
    private Map<String,String> opDStitchMap;
    
    private String ptDblstitchPlcRtPrice;
    
    //ダブルステッチ箇所
    private String opDStitchPlace;
    
    private String opDStitchPlace1;

    private String opDStitchPlace2;
    
    private String opDStitchPlace3;
    
    private Map<String,String> opDStitchPlaceMap;

	//AMF色指定
    @NotBlank(groups = { PtStOpStitchItem.class }, message = "PANTS（1本目）のAMF色指定を入力して下さい。")
    private String opAmfColor;
    
    private Map<String,String> opAmfColorMap;
    
    private String ptAmfColorRtPrice;
    
    //AMF糸色 
    private String opAmfColorPlaceAll;
    
    private Map<String,String> opAmfColorPlaceAllMap;
    
    //AMF色指定箇所
    private String opAmfColorPlace;
    
    private String opAmfColorPlace1;
    
    private String opAmfColorPlace2;
    
    private String opAmfColorPlace3;
    
    private String opAmfColorPlace4;
    
    private Map<String,String> opAmfColorPlaceMap;
    
    private String opAmfAllColor;
    //AMF糸色  脇ポケット
    private String opAmfColor1;
    
    //AMF糸色  サイドシーム
    private String opAmfColor2;
    
    //AMF糸色  ダーツ
    private String opAmfColor3;
  
    //AMF糸色  ピスフラップ
    private String opAmfColor4;
    
    //AMF色 key&value
    private Map<String,String> opAmfColorsMap;
    
    //ボタンホール色指定
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のボタンホール色指定を入力して下さい。")
    private String opBhColor;
    
    private Map<String,String> opBhColorMap;
    
    private String ptBtnholeColorRtPrice;
    
    //ボタンホール色指定糸色
    private String opBhColorPlaceAll;
    
    private Map<String,String> opBhColorPlaceAllMap;
    
    //ボタンホール色指定箇所
    private String opBhColorPlace;
    
    private String opBhColorPlace1;
    
    private String opBhColorPlace2;
    
    private String opBhColorPlace3;
    
    private String opBhColorPlace4;
    
    private Map<String,String> opBhColorPlaceMap;
    
    private String opBhAllColor;
    //ボタンホール色指定糸色  フロント
    private String opBhColor1;
    
    //ボタンホール色指定糸色  上前ピスポケット
    private String opBhColor2;
    
    //ボタンホール色指定糸色  下前ピスポケット
    private String opBhColor3;
  
    //ボタンホール色指定糸色  フラップ付コインポケット
    private String opBhColor4;
    
    //ボタンホール色指定色 key&value
    private Map<String,String> opBhColorsMap;
    
    //ボタン付け糸指定
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のボタン付け糸指定を入力して下さい。")
    private String opByColor;
    
    private Map<String,String> opByColorMap;
    
    private String ptBtnthreadColorRtPrice;
    
    //ボタン付け糸指定糸色
    private String opByColorPlaceAll;
    
    private Map<String,String> opByColorPlaceAllMap;
    
    //ボタン付け糸指定箇所
    private String opByColorPlace;
    
    private String opByColorPlace1;
    
    private String opByColorPlace2;
    
    private String opByColorPlace3;
    
    private String opByColorPlace4;
    
    private Map<String,String> opByColorPlaceMap;
    
    private String opByAllColor;
    //ボタン付け糸指定糸色  フロント
    private String opByColor1;
    
    //ボタン付け糸指定糸色  上前ピスポケット
    private String opByColor2;
    
    //ボタン付け糸指定糸色  下前ピスポケット
    private String opByColor3;
  
    //ボタン付け糸指定糸色  フラップ付コインポケット
    private String opByColor4;
    
    //ボタン付け糸指定糸色 key&value
    private Map<String,String> opByColorsMap;
    
    //釦素材
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）の釦素材を入力して下さい。")
    private String opButton;
    
    private Map<String,String> opButtonMap;
    
    private String ptBtnMaterialRtPrice;
    
    //釦素材品番
    private String opBtnMateStkNo;
    
    //サスペンダー釦
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のサスペンダー釦を入力して下さい。")
    private String opSuspenderBtn;
    
    private Map<String,String> opSuspenderBtnMap;
    
    private String ptSuspenderBtnRtPrice;
    
    //エイト（滑り止め）
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のエイト（滑り止め）を入力して下さい。")
    private String opEight;
    
    private Map<String,String> opEightMap;
    
    private String PtNonSlipRtPrice;
    
    //形状記憶
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）の形状記憶を入力して下さい。")
    private String opShapeMemory; 
    
    private Map<String,String> opShapeMemoryMap;
    
    private String ptShapeMemoryRtPrice;
    
    //靴ずれ
    private String opBlister;
    
    private Map<String,String> opBlisterMap;
 

    //シック（股補強）
    @NotBlank(groups = { PtStItem.class }, message = "PANTS（1本目）のシック（股補強）を入力して下さい。")
    private String opThick;
    
    private Map<String,String> opThickMap;
    
    private String ptChicSlipRtPrice;
    
    //品番Map
    private Map<String,String> pantsMateMap;
    
    
	public Map<String, String> getPantsMateMap() {
		return pantsMateMap;
	}

	public void setPantsMateMap(Map<String, String> pantsMateMap) {
		this.pantsMateMap = pantsMateMap;
	}

	public String getOpThick() {
		return opThick;
	}

	public void setOpThick(String opThick) {
		this.opThick = opThick;
	}

	public Map<String, String> getOpThickMap() {
		return opThickMap;
	}

	public void setOpThickMap(Map<String, String> opThickMap) {
		this.opThickMap = opThickMap;
	}

	public String getOpTack() {
		return opTack;
	}

	
	public String getOpBtnMateStkNo() {
		return opBtnMateStkNo;
	}

	public void setOpBtnMateStkNo(String opBtnMateStkNo) {
		this.opBtnMateStkNo = opBtnMateStkNo;
	}

	public void setOpTack(String opTack) {
		this.opTack = opTack;
	}

	public Map<String, String> getOpTackMap() {
		return opTackMap;
	}

	public void setOpTackMap(Map<String, String> opTackMap) {
		this.opTackMap = opTackMap;
	}

	public String getOpKneeBack() {
		return opKneeBack;
	}

	public void setOpKneeBack(String opKneeBack) {
		this.opKneeBack = opKneeBack;
	}

	public Map<String, String> getOpKneeBackMap() {
		return opKneeBackMap;
	}

	public void setOpKneeBackMap(Map<String, String> opKneeBackMap) {
		this.opKneeBackMap = opKneeBackMap;
	}

	public String getOpKneeBackMate() {
		return opKneeBackMate;
	}

	public void setOpKneeBackMate(String opKneeBackMate) {
		this.opKneeBackMate = opKneeBackMate;
	}

	public Map<String, String> getOpKneeBackMateMap() {
		return opKneeBackMateMap;
	}

	public void setOpKneeBackMateMap(Map<String, String> opKneeBackMateMap) {
		this.opKneeBackMateMap = opKneeBackMateMap;
	}

	public String getOpFrontSpec() {
		return opFrontSpec;
	}

	public void setOpFrontSpec(String opFrontSpec) {
		this.opFrontSpec = opFrontSpec;
	}

	public Map<String, String> getOpFrontSpecMap() {
		return opFrontSpecMap;
	}

	public void setOpFrontSpecMap(Map<String, String> opFrontSpecMap) {
		this.opFrontSpecMap = opFrontSpecMap;
	}

	public String getOpPancherina() {
		return opPancherina;
	}

	public void setOpPancherina(String opPancherina) {
		this.opPancherina = opPancherina;
	}

	public Map<String, String> getOpPancherinaMap() {
		return opPancherinaMap;
	}

	public void setOpPancherinaMap(Map<String, String> opPancherinaMap) {
		this.opPancherinaMap = opPancherinaMap;
	}

	public String getOpAdjuster() {
		return opAdjuster;
	}

	public void setOpAdjuster(String opAdjuster) {
		this.opAdjuster = opAdjuster;
	}

	public Map<String, String> getOpAdjusterMap() {
		return opAdjusterMap;
	}

	public void setOpAdjusterMap(Map<String, String> opAdjusterMap) {
		this.opAdjusterMap = opAdjusterMap;
	}

	public String getOpBeltLoop() {
		return opBeltLoop;
	}

	public void setOpBeltLoop(String opBeltLoop) {
		this.opBeltLoop = opBeltLoop;
	}

	public Map<String, String> getOpBeltLoopMap() {
		return opBeltLoopMap;
	}

	public void setOpBeltLoopMap(Map<String, String> opBeltLoopMap) {
		this.opBeltLoopMap = opBeltLoopMap;
	}

	public Map<String, String> getOpBeltLoopPlaceMap() {
		return opBeltLoopPlaceMap;
	}

	public void setOpBeltLoopPlaceMap(Map<String, String> opBeltLoopPlaceMap) {
		this.opBeltLoopPlaceMap = opBeltLoopPlaceMap;
	}

	public String getOpPinLoop() {
		return opPinLoop;
	}

	public void setOpPinLoop(String opPinLoop) {
		this.opPinLoop = opPinLoop;
	}

	public Map<String, String> getOpPinLoopMap() {
		return opPinLoopMap;
	}

	public void setOpPinLoopMap(Map<String, String> opPinLoopMap) {
		this.opPinLoopMap = opPinLoopMap;
	}

	public String getOpSidePkt() {
		return opSidePkt;
	}

	public void setOpSidePkt(String opSidePkt) {
		this.opSidePkt = opSidePkt;
	}

	public Map<String, String> getOpSidePktMap() {
		return opSidePktMap;
	}

	public void setOpSidePktMap(Map<String, String> opSidePktMap) {
		this.opSidePktMap = opSidePktMap;
	}

	public String getOpSinobiPkt() {
		return opSinobiPkt;
	}

	public void setOpSinobiPkt(String opSinobiPkt) {
		this.opSinobiPkt = opSinobiPkt;
	}

	public Map<String, String> getOpSinobiPktMap() {
		return opSinobiPktMap;
	}

	public void setOpSinobiPktMap(Map<String, String> opSinobiPktMap) {
		this.opSinobiPktMap = opSinobiPktMap;
	}

	public String getOpCoinPkt() {
		return opCoinPkt;
	}

	public void setOpCoinPkt(String opCoinPkt) {
		this.opCoinPkt = opCoinPkt;
	}

	public Map<String, String> getOpCoinPktMap() {
		return opCoinPktMap;
	}

	public void setOpCoinPktMap(Map<String, String> opCoinPktMap) {
		this.opCoinPktMap = opCoinPktMap;
	}

	public String getOpFlapCoinPkt() {
		return opFlapCoinPkt;
	}

	public void setOpFlapCoinPkt(String opFlapCoinPkt) {
		this.opFlapCoinPkt = opFlapCoinPkt;
	}

	public Map<String, String> getOpFlapCoinPktMap() {
		return opFlapCoinPktMap;
	}

	public void setOpFlapCoinPktMap(Map<String, String> opFlapCoinPktMap) {
		this.opFlapCoinPktMap = opFlapCoinPktMap;
	}

	public String getOpPisPktUf() {
		return opPisPktUf;
	}

	public void setOpPisPktUf(String opPisPktUf) {
		this.opPisPktUf = opPisPktUf;
	}

	public Map<String, String> getOpPisPktUfMap() {
		return opPisPktUfMap;
	}

	public void setOpPisPktUfMap(Map<String, String> opPisPktUfMap) {
		this.opPisPktUfMap = opPisPktUfMap;
	}

	public String getOpPisPktDf() {
		return opPisPktDf;
	}

	public void setOpPisPktDf(String opPisPktDf) {
		this.opPisPktDf = opPisPktDf;
	}

	public Map<String, String> getOpPisPktDfMap() {
		return opPisPktDfMap;
	}

	public void setOpPisPktDfMap(Map<String, String> opPisPktDfMap) {
		this.opPisPktDfMap = opPisPktDfMap;
	}

	public String getOpVCut() {
		return opVCut;
	}

	public void setOpVCut(String opVCut) {
		this.opVCut = opVCut;
	}

	public Map<String, String> getOpVCutMap() {
		return opVCutMap;
	}

	public void setOpVCutMap(Map<String, String> opVCutMap) {
		this.opVCutMap = opVCutMap;
	}

	public String getOpHemUp() {
		return opHemUp;
	}

	public void setOpHemUp(String opHemUp) {
		this.opHemUp = opHemUp;
	}

	public Map<String, String> getOpHemUpMap() {
		return opHemUpMap;
	}

	public void setOpHemUpMap(Map<String, String> opHemUpMap) {
		this.opHemUpMap = opHemUpMap;
	}

	public String getOpDoubleWide() {
		return opDoubleWide;
	}

	public void setOpDoubleWide(String opDoubleWide) {
		this.opDoubleWide = opDoubleWide;
	}

	public Map<String, String> getOpDoubleWideMap() {
		return opDoubleWideMap;
	}

	public void setOpDoubleWideMap(Map<String, String> opDoubleWideMap) {
		this.opDoubleWideMap = opDoubleWideMap;
	}

	public String getOpStitch() {
		return opStitch;
	}

	public void setOpStitch(String opStitch) {
		this.opStitch = opStitch;
	}

	public Map<String, String> getOpStitchMap() {
		return opStitchMap;
	}

	public void setOpStitchMap(Map<String, String> opStitchMap) {
		this.opStitchMap = opStitchMap;
	}

	public String getOpStitchModify() {
		return opStitchModify;
	}

	public void setOpStitchModify(String opStitchModify) {
		this.opStitchModify = opStitchModify;
	}

	public Map<String, String> getOpStitchModifyMap() {
		return opStitchModifyMap;
	}

	public void setOpStitchModifyMap(Map<String, String> opStitchModifyMap) {
		this.opStitchModifyMap = opStitchModifyMap;
	}

	public Map<String, String> getOpStitchModifyPlaceMap() {
		return opStitchModifyPlaceMap;
	}

	public void setOpStitchModifyPlaceMap(Map<String, String> opStitchModifyPlaceMap) {
		this.opStitchModifyPlaceMap = opStitchModifyPlaceMap;
	}

	public String getOpDStitch() {
		return opDStitch;
	}

	public void setOpDStitch(String opDStitch) {
		this.opDStitch = opDStitch;
	}

	public Map<String, String> getOpDStitchMap() {
		return opDStitchMap;
	}

	public void setOpDStitchMap(Map<String, String> opDStitchMap) {
		this.opDStitchMap = opDStitchMap;
	}

	public Map<String, String> getOpDStitchPlaceMap() {
		return opDStitchPlaceMap;
	}

	public void setOpDStitchPlaceMap(Map<String, String> opDStitchPlaceMap) {
		this.opDStitchPlaceMap = opDStitchPlaceMap;
	}

	public String getOpAmfColor() {
		return opAmfColor;
	}

	public void setOpAmfColor(String opAmfColor) {
		this.opAmfColor = opAmfColor;
	}

	public Map<String, String> getOpAmfColorMap() {
		return opAmfColorMap;
	}

	public void setOpAmfColorMap(Map<String, String> opAmfColorMap) {
		this.opAmfColorMap = opAmfColorMap;
	}

	public String getOpAmfColorPlaceAll() {
		return opAmfColorPlaceAll;
	}

	public void setOpAmfColorPlaceAll(String opAmfColorPlaceAll) {
		this.opAmfColorPlaceAll = opAmfColorPlaceAll;
	}

	public Map<String, String> getOpAmfColorPlaceAllMap() {
		return opAmfColorPlaceAllMap;
	}

	public void setOpAmfColorPlaceAllMap(Map<String, String> opAmfColorPlaceAllMap) {
		this.opAmfColorPlaceAllMap = opAmfColorPlaceAllMap;
	}

	public Map<String, String> getOpAmfColorPlaceMap() {
		return opAmfColorPlaceMap;
	}

	public void setOpAmfColorPlaceMap(Map<String, String> opAmfColorPlaceMap) {
		this.opAmfColorPlaceMap = opAmfColorPlaceMap;
	}

	public String getOpAmfColor1() {
		return opAmfColor1;
	}

	public void setOpAmfColor1(String opAmfColor1) {
		this.opAmfColor1 = opAmfColor1;
	}

	public String getOpAmfColor2() {
		return opAmfColor2;
	}

	public void setOpAmfColor2(String opAmfColor2) {
		this.opAmfColor2 = opAmfColor2;
	}

	public String getOpAmfColor3() {
		return opAmfColor3;
	}

	public void setOpAmfColor3(String opAmfColor3) {
		this.opAmfColor3 = opAmfColor3;
	}

	public String getOpAmfColor4() {
		return opAmfColor4;
	}

	public void setOpAmfColor4(String opAmfColor4) {
		this.opAmfColor4 = opAmfColor4;
	}

	public Map<String, String> getOpAmfColorsMap() {
		return opAmfColorsMap;
	}

	public void setOpAmfColorsMap(Map<String, String> opAmfColorsMap) {
		this.opAmfColorsMap = opAmfColorsMap;
	}

	public String getOpBhColor() {
		return opBhColor;
	}

	public void setOpBhColor(String opBhColor) {
		this.opBhColor = opBhColor;
	}

	public Map<String, String> getOpBhColorMap() {
		return opBhColorMap;
	}

	public void setOpBhColorMap(Map<String, String> opBhColorMap) {
		this.opBhColorMap = opBhColorMap;
	}

	public String getOpBhColorPlaceAll() {
		return opBhColorPlaceAll;
	}

	public void setOpBhColorPlaceAll(String opBhColorPlaceAll) {
		this.opBhColorPlaceAll = opBhColorPlaceAll;
	}

	public Map<String, String> getOpBhColorPlaceAllMap() {
		return opBhColorPlaceAllMap;
	}

	public void setOpBhColorPlaceAllMap(Map<String, String> opBhColorPlaceAllMap) {
		this.opBhColorPlaceAllMap = opBhColorPlaceAllMap;
	}

	public Map<String, String> getOpBhColorPlaceMap() {
		return opBhColorPlaceMap;
	}

	public void setOpBhColorPlaceMap(Map<String, String> opBhColorPlaceMap) {
		this.opBhColorPlaceMap = opBhColorPlaceMap;
	}

	public String getOpBhColor1() {
		return opBhColor1;
	}

	public void setOpBhColor1(String opBhColor1) {
		this.opBhColor1 = opBhColor1;
	}

	public String getOpBhColor2() {
		return opBhColor2;
	}

	public void setOpBhColor2(String opBhColor2) {
		this.opBhColor2 = opBhColor2;
	}

	public String getOpBhColor3() {
		return opBhColor3;
	}

	public void setOpBhColor3(String opBhColor3) {
		this.opBhColor3 = opBhColor3;
	}

	public String getOpBhColor4() {
		return opBhColor4;
	}

	public void setOpBhColor4(String opBhColor4) {
		this.opBhColor4 = opBhColor4;
	}

	public Map<String, String> getOpBhColorsMap() {
		return opBhColorsMap;
	}

	public void setOpBhColorsMap(Map<String, String> opBhColorsMap) {
		this.opBhColorsMap = opBhColorsMap;
	}

	public String getOpByColor() {
		return opByColor;
	}

	public void setOpByColor(String opByColor) {
		this.opByColor = opByColor;
	}

	public Map<String, String> getOpByColorMap() {
		return opByColorMap;
	}

	public void setOpByColorMap(Map<String, String> opByColorMap) {
		this.opByColorMap = opByColorMap;
	}

	public String getOpByColorPlaceAll() {
		return opByColorPlaceAll;
	}

	public void setOpByColorPlaceAll(String opByColorPlaceAll) {
		this.opByColorPlaceAll = opByColorPlaceAll;
	}

	public Map<String, String> getOpByColorPlaceAllMap() {
		return opByColorPlaceAllMap;
	}

	public void setOpByColorPlaceAllMap(Map<String, String> opByColorPlaceAllMap) {
		this.opByColorPlaceAllMap = opByColorPlaceAllMap;
	}

	public Map<String, String> getOpByColorPlaceMap() {
		return opByColorPlaceMap;
	}

	public void setOpByColorPlaceMap(Map<String, String> opByColorPlaceMap) {
		this.opByColorPlaceMap = opByColorPlaceMap;
	}

	public String getOpByColor1() {
		return opByColor1;
	}

	public void setOpByColor1(String opByColor1) {
		this.opByColor1 = opByColor1;
	}

	public String getOpByColor2() {
		return opByColor2;
	}

	public void setOpByColor2(String opByColor2) {
		this.opByColor2 = opByColor2;
	}

	public String getOpByColor3() {
		return opByColor3;
	}

	public void setOpByColor3(String opByColor3) {
		this.opByColor3 = opByColor3;
	}

	public String getOpByColor4() {
		return opByColor4;
	}

	public void setOpByColor4(String opByColor4) {
		this.opByColor4 = opByColor4;
	}

	public Map<String, String> getOpByColorsMap() {
		return opByColorsMap;
	}

	public void setOpByColorsMap(Map<String, String> opByColorsMap) {
		this.opByColorsMap = opByColorsMap;
	}

	public String getOpButton() {
		return opButton;
	}

	public void setOpButton(String opButton) {
		this.opButton = opButton;
	}

	public Map<String, String> getOpButtonMap() {
		return opButtonMap;
	}

	public void setOpButtonMap(Map<String, String> opButtonMap) {
		this.opButtonMap = opButtonMap;
	}

	public String getOpSuspenderBtn() {
		return opSuspenderBtn;
	}

	public void setOpSuspenderBtn(String opSuspenderBtn) {
		this.opSuspenderBtn = opSuspenderBtn;
	}

	public Map<String, String> getOpSuspenderBtnMap() {
		return opSuspenderBtnMap;
	}

	public void setOpSuspenderBtnMap(Map<String, String> opSuspenderBtnMap) {
		this.opSuspenderBtnMap = opSuspenderBtnMap;
	}

	public String getOpEight() {
		return opEight;
	}

	public void setOpEight(String opEight) {
		this.opEight = opEight;
	}

	public Map<String, String> getOpEightMap() {
		return opEightMap;
	}

	public void setOpEightMap(Map<String, String> opEightMap) {
		this.opEightMap = opEightMap;
	}

	public String getOpShapeMemory() {
		return opShapeMemory;
	}

	public void setOpShapeMemory(String opShapeMemory) {
		this.opShapeMemory = opShapeMemory;
	}

	public Map<String, String> getOpShapeMemoryMap() {
		return opShapeMemoryMap;
	}

	public void setOpShapeMemoryMap(Map<String, String> opShapeMemoryMap) {
		this.opShapeMemoryMap = opShapeMemoryMap;
	}

	public String getOpBlister() {
		return opBlister;
	}

	public void setOpBlister(String opBlister) {
		this.opBlister = opBlister;
	}

	public Map<String, String> getOpBlisterMap() {
		return opBlisterMap;
	}

	public void setOpBlisterMap(Map<String, String> opBlisterMap) {
		this.opBlisterMap = opBlisterMap;
	}

	public String getOpPantsModel() {
		return opPantsModel;
	}

	public void setOpPantsModel(String opPantsModel) {
		this.opPantsModel = opPantsModel;
	}

	public Map<String, String> getOpPantsModelMap() {
		return opPantsModelMap;
	}

	public void setOpPantsModelMap(Map<String, String> opPantsModelMap) {
		this.opPantsModelMap = opPantsModelMap;
	}

	public Map<String, String> getTwoPantsMap() {
		return twoPantsMap;
	}

	public void setTwoPantsMap(Map<String, String> twoPantsMap) {
		this.twoPantsMap = twoPantsMap;
	}

	public String getOpBeltLoopPlace1() {
		return opBeltLoopPlace1;
	}

	public void setOpBeltLoopPlace1(String opBeltLoopPlace1) {
		this.opBeltLoopPlace1 = opBeltLoopPlace1;
	}

	public String getOpBeltLoopPlace2() {
		return opBeltLoopPlace2;
	}

	public void setOpBeltLoopPlace2(String opBeltLoopPlace2) {
		this.opBeltLoopPlace2 = opBeltLoopPlace2;
	}

	public String getOpBeltLoopPlace3() {
		return opBeltLoopPlace3;
	}

	public void setOpBeltLoopPlace3(String opBeltLoopPlace3) {
		this.opBeltLoopPlace3 = opBeltLoopPlace3;
	}

	public String getOpBeltLoopPlace4() {
		return opBeltLoopPlace4;
	}

	public void setOpBeltLoopPlace4(String opBeltLoopPlace4) {
		this.opBeltLoopPlace4 = opBeltLoopPlace4;
	}

	public String getOpBeltLoopPlace5() {
		return opBeltLoopPlace5;
	}

	public void setOpBeltLoopPlace5(String opBeltLoopPlace5) {
		this.opBeltLoopPlace5 = opBeltLoopPlace5;
	}

	public String getOpBeltLoopPlace6() {
		return opBeltLoopPlace6;
	}

	public void setOpBeltLoopPlace6(String opBeltLoopPlace6) {
		this.opBeltLoopPlace6 = opBeltLoopPlace6;
	}

	public String getOpBeltLoopPlace7() {
		return opBeltLoopPlace7;
	}

	public void setOpBeltLoopPlace7(String opBeltLoopPlace7) {
		this.opBeltLoopPlace7 = opBeltLoopPlace7;
	}

	public String getOpStitchModifyPlace1() {
		return opStitchModifyPlace1;
	}

	public void setOpStitchModifyPlace1(String opStitchModifyPlace1) {
		this.opStitchModifyPlace1 = opStitchModifyPlace1;
	}

	public String getOpStitchModifyPlace2() {
		return opStitchModifyPlace2;
	}

	public void setOpStitchModifyPlace2(String opStitchModifyPlace2) {
		this.opStitchModifyPlace2 = opStitchModifyPlace2;
	}

	public String getOpStitchModifyPlace3() {
		return opStitchModifyPlace3;
	}

	public void setOpStitchModifyPlace3(String opStitchModifyPlace3) {
		this.opStitchModifyPlace3 = opStitchModifyPlace3;
	}

	public String getOpStitchModifyPlace4() {
		return opStitchModifyPlace4;
	}

	public void setOpStitchModifyPlace4(String opStitchModifyPlace4) {
		this.opStitchModifyPlace4 = opStitchModifyPlace4;
	}

	public String getOpDStitchPlace1() {
		return opDStitchPlace1;
	}

	public void setOpDStitchPlace1(String opDStitchPlace1) {
		this.opDStitchPlace1 = opDStitchPlace1;
	}

	public String getOpDStitchPlace2() {
		return opDStitchPlace2;
	}

	public void setOpDStitchPlace2(String opDStitchPlace2) {
		this.opDStitchPlace2 = opDStitchPlace2;
	}

	public String getOpDStitchPlace3() {
		return opDStitchPlace3;
	}

	public void setOpDStitchPlace3(String opDStitchPlace3) {
		this.opDStitchPlace3 = opDStitchPlace3;
	}

	public String getOpAmfColorPlace1() {
		return opAmfColorPlace1;
	}

	public void setOpAmfColorPlace1(String opAmfColorPlace1) {
		this.opAmfColorPlace1 = opAmfColorPlace1;
	}

	public String getOpAmfColorPlace2() {
		return opAmfColorPlace2;
	}

	public void setOpAmfColorPlace2(String opAmfColorPlace2) {
		this.opAmfColorPlace2 = opAmfColorPlace2;
	}

	public String getOpAmfColorPlace3() {
		return opAmfColorPlace3;
	}

	public void setOpAmfColorPlace3(String opAmfColorPlace3) {
		this.opAmfColorPlace3 = opAmfColorPlace3;
	}

	public String getOpAmfColorPlace4() {
		return opAmfColorPlace4;
	}

	public void setOpAmfColorPlace4(String opAmfColorPlace4) {
		this.opAmfColorPlace4 = opAmfColorPlace4;
	}

	public String getOpBhColorPlace1() {
		return opBhColorPlace1;
	}

	public void setOpBhColorPlace1(String opBhColorPlace1) {
		this.opBhColorPlace1 = opBhColorPlace1;
	}

	public String getOpBhColorPlace2() {
		return opBhColorPlace2;
	}

	public void setOpBhColorPlace2(String opBhColorPlace2) {
		this.opBhColorPlace2 = opBhColorPlace2;
	}

	public String getOpBhColorPlace3() {
		return opBhColorPlace3;
	}

	public void setOpBhColorPlace3(String opBhColorPlace3) {
		this.opBhColorPlace3 = opBhColorPlace3;
	}

	public String getOpBhColorPlace4() {
		return opBhColorPlace4;
	}

	public void setOpBhColorPlace4(String opBhColorPlace4) {
		this.opBhColorPlace4 = opBhColorPlace4;
	}

	public String getOpByColorPlace1() {
		return opByColorPlace1;
	}

	public void setOpByColorPlace1(String opByColorPlace1) {
		this.opByColorPlace1 = opByColorPlace1;
	}

	public String getOpByColorPlace2() {
		return opByColorPlace2;
	}

	public void setOpByColorPlace2(String opByColorPlace2) {
		this.opByColorPlace2 = opByColorPlace2;
	}

	public String getOpByColorPlace3() {
		return opByColorPlace3;
	}

	public void setOpByColorPlace3(String opByColorPlace3) {
		this.opByColorPlace3 = opByColorPlace3;
	}

	public String getOpByColorPlace4() {
		return opByColorPlace4;
	}

	public void setOpByColorPlace4(String opByColorPlace4) {
		this.opByColorPlace4 = opByColorPlace4;
	}

	public String getOpBeltLoopPlace() {
		return opBeltLoopPlace;
	}

	public void setOpBeltLoopPlace(String opBeltLoopPlace) {
		this.opBeltLoopPlace = opBeltLoopPlace;
	}

	public String getOpStitchModifyPlace() {
		return opStitchModifyPlace;
	}

	public void setOpStitchModifyPlace(String opStitchModifyPlace) {
		this.opStitchModifyPlace = opStitchModifyPlace;
	}

	public String getOpDStitchPlace() {
		return opDStitchPlace;
	}

	public void setOpDStitchPlace(String opDStitchPlace) {
		this.opDStitchPlace = opDStitchPlace;
	}

	public String getOpAmfColorPlace() {
		return opAmfColorPlace;
	}

	public void setOpAmfColorPlace(String opAmfColorPlace) {
		this.opAmfColorPlace = opAmfColorPlace;
	}

	public String getOpBhColorPlace() {
		return opBhColorPlace;
	}

	public void setOpBhColorPlace(String opBhColorPlace) {
		this.opBhColorPlace = opBhColorPlace;
	}

	public String getOpByColorPlace() {
		return opByColorPlace;
	}

	public void setOpByColorPlace(String opByColorPlace) {
		this.opByColorPlace = opByColorPlace;
	}

	public String getPtTackRtPrice() {
		return ptTackRtPrice;
	}

	public void setPtTackRtPrice(String ptTackRtPrice) {
		this.ptTackRtPrice = ptTackRtPrice;
	}

	public String getPtKneeinnerTypeRtPrice() {
		return ptKneeinnerTypeRtPrice;
	}

	public void setPtKneeinnerTypeRtPrice(String ptKneeinnerTypeRtPrice) {
		this.ptKneeinnerTypeRtPrice = ptKneeinnerTypeRtPrice;
	}

	public String getPtKneeinnerClothRtPrice() {
		return ptKneeinnerClothRtPrice;
	}

	public void setPtKneeinnerClothRtPrice(String ptKneeinnerClothRtPrice) {
		this.ptKneeinnerClothRtPrice = ptKneeinnerClothRtPrice;
	}

	public String getPtFrtTypeRtPrice() {
		return ptFrtTypeRtPrice;
	}

	public void setPtFrtTypeRtPrice(String ptFrtTypeRtPrice) {
		this.ptFrtTypeRtPrice = ptFrtTypeRtPrice;
	}

	public String getPtPancherinaRtPrice() {
		return ptPancherinaRtPrice;
	}

	public void setPtPancherinaRtPrice(String ptPancherinaRtPrice) {
		this.ptPancherinaRtPrice = ptPancherinaRtPrice;
	}

	public String getPtAdjusterRtPrice() {
		return ptAdjusterRtPrice;
	}

	public void setPtAdjusterRtPrice(String ptAdjusterRtPrice) {
		this.ptAdjusterRtPrice = ptAdjusterRtPrice;
	}

	public String getPtBeltLoopRtPrice() {
		return ptBeltLoopRtPrice;
	}

	public void setPtBeltLoopRtPrice(String ptBeltLoopRtPrice) {
		this.ptBeltLoopRtPrice = ptBeltLoopRtPrice;
	}

	public String getPtPinLoopRtPrice() {
		return ptPinLoopRtPrice;
	}

	public void setPtPinLoopRtPrice(String ptPinLoopRtPrice) {
		this.ptPinLoopRtPrice = ptPinLoopRtPrice;
	}

	public String getPtSidePktRtPrice() {
		return ptSidePktRtPrice;
	}

	public void setPtSidePktRtPrice(String ptSidePktRtPrice) {
		this.ptSidePktRtPrice = ptSidePktRtPrice;
	}

	public String getPtShinobiPktRtPrice() {
		return ptShinobiPktRtPrice;
	}

	public void setPtShinobiPktRtPrice(String ptShinobiPktRtPrice) {
		this.ptShinobiPktRtPrice = ptShinobiPktRtPrice;
	}

	public String getPtCoinPktRtPrice() {
		return ptCoinPktRtPrice;
	}

	public void setPtCoinPktRtPrice(String ptCoinPktRtPrice) {
		this.ptCoinPktRtPrice = ptCoinPktRtPrice;
	}

	public String getPtFlapcoinPktRtPrice() {
		return ptFlapcoinPktRtPrice;
	}

	public void setPtFlapcoinPktRtPrice(String ptFlapcoinPktRtPrice) {
		this.ptFlapcoinPktRtPrice = ptFlapcoinPktRtPrice;
	}

	public String getPtLeftPisPktRtPrice() {
		return ptLeftPisPktRtPrice;
	}

	public void setPtLeftPisPktRtPrice(String ptLeftPisPktRtPrice) {
		this.ptLeftPisPktRtPrice = ptLeftPisPktRtPrice;
	}

	public String getPtRightPisPktRtPrice() {
		return ptRightPisPktRtPrice;
	}

	public void setPtRightPisPktRtPrice(String ptRightPisPktRtPrice) {
		this.ptRightPisPktRtPrice = ptRightPisPktRtPrice;
	}

	public String getPtVCutRtPrice() {
		return ptVCutRtPrice;
	}

	public void setPtVCutRtPrice(String ptVCutRtPrice) {
		this.ptVCutRtPrice = ptVCutRtPrice;
	}

	public String getPtHemUpRtPrice() {
		return ptHemUpRtPrice;
	}

	public void setPtHemUpRtPrice(String ptHemUpRtPrice) {
		this.ptHemUpRtPrice = ptHemUpRtPrice;
	}

	public String getPtDblWidthRtPrice() {
		return ptDblWidthRtPrice;
	}

	public void setPtDblWidthRtPrice(String ptDblWidthRtPrice) {
		this.ptDblWidthRtPrice = ptDblWidthRtPrice;
	}

	public String getPtAmfStitchRtPrice() {
		return ptAmfStitchRtPrice;
	}

	public void setPtAmfStitchRtPrice(String ptAmfStitchRtPrice) {
		this.ptAmfStitchRtPrice = ptAmfStitchRtPrice;
	}

	public String getPtStitchPlcRtPrice() {
		return ptStitchPlcRtPrice;
	}

	public void setPtStitchPlcRtPrice(String ptStitchPlcRtPrice) {
		this.ptStitchPlcRtPrice = ptStitchPlcRtPrice;
	}

	public String getPtDblstitchPlcRtPrice() {
		return ptDblstitchPlcRtPrice;
	}

	public void setPtDblstitchPlcRtPrice(String ptDblstitchPlcRtPrice) {
		this.ptDblstitchPlcRtPrice = ptDblstitchPlcRtPrice;
	}

	public String getPtAmfColorRtPrice() {
		return ptAmfColorRtPrice;
	}

	public void setPtAmfColorRtPrice(String ptAmfColorRtPrice) {
		this.ptAmfColorRtPrice = ptAmfColorRtPrice;
	}

	public String getPtBtnholeColorRtPrice() {
		return ptBtnholeColorRtPrice;
	}

	public void setPtBtnholeColorRtPrice(String ptBtnholeColorRtPrice) {
		this.ptBtnholeColorRtPrice = ptBtnholeColorRtPrice;
	}

	public String getPtBtnthreadColorRtPrice() {
		return ptBtnthreadColorRtPrice;
	}

	public void setPtBtnthreadColorRtPrice(String ptBtnthreadColorRtPrice) {
		this.ptBtnthreadColorRtPrice = ptBtnthreadColorRtPrice;
	}

	public String getPtBtnMaterialRtPrice() {
		return ptBtnMaterialRtPrice;
	}

	public void setPtBtnMaterialRtPrice(String ptBtnMaterialRtPrice) {
		this.ptBtnMaterialRtPrice = ptBtnMaterialRtPrice;
	}

	public String getPtSuspenderBtnRtPrice() {
		return ptSuspenderBtnRtPrice;
	}

	public void setPtSuspenderBtnRtPrice(String ptSuspenderBtnRtPrice) {
		this.ptSuspenderBtnRtPrice = ptSuspenderBtnRtPrice;
	}

	public String getPtNonSlipRtPrice() {
		return PtNonSlipRtPrice;
	}

	public void setPtNonSlipRtPrice(String ptNonSlipRtPrice) {
		PtNonSlipRtPrice = ptNonSlipRtPrice;
	}

	public String getPtShapeMemoryRtPrice() {
		return ptShapeMemoryRtPrice;
	}

	public void setPtShapeMemoryRtPrice(String ptShapeMemoryRtPrice) {
		this.ptShapeMemoryRtPrice = ptShapeMemoryRtPrice;
	}

	public String getPtChicSlipRtPrice() {
		return ptChicSlipRtPrice;
	}

	public void setPtChicSlipRtPrice(String ptChicSlipRtPrice) {
		this.ptChicSlipRtPrice = ptChicSlipRtPrice;
	}

	public String getOpAmfAllColor() {
		return opAmfAllColor;
	}

	public void setOpAmfAllColor(String opAmfAllColor) {
		this.opAmfAllColor = opAmfAllColor;
	}

	public String getOpBhAllColor() {
		return opBhAllColor;
	}

	public void setOpBhAllColor(String opBhAllColor) {
		this.opBhAllColor = opBhAllColor;
	}

	public String getOpByAllColor() {
		return opByAllColor;
	}

	public void setOpByAllColor(String opByAllColor) {
		this.opByAllColor = opByAllColor;
	}

	

}
