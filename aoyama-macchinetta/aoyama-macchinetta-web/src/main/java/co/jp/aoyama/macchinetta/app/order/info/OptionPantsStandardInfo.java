package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;

public class OptionPantsStandardInfo implements Serializable{
	private static final long serialVersionUID = -4505963757793347479L;
	
	//2Pants
	private Map<String,String> twoPantsMap;
	
	//PANTSモデル
	private String opPantsModel;
	
	private Map<String,String> opPantsModelMap;
	
	//タック
    private String opTack;
    
    private Map<String,String> opTackMap;
    
    //膝裏
    private String opKneeBack;
    
    private Map<String,String> opKneeBackMap;
    //膝裏素材
    private String opKneeBackMate;

    private Map<String,String> opKneeBackMateMap;
    //フロント仕様
  	private String opFrontSpec;
      
    private Map<String,String> opFrontSpecMap;
    //パンチェリーナ
    private String opPancherina;
    
    private Map<String,String> opPancherinaMap;
    //アジャスター仕様
    private String opAdjuster;
    
    private Map<String,String> opAdjusterMap;
    
    //ベルトループ
    private String opBeltLoop;
    
    private Map<String,String> opBeltLoopMap;
    
    //ベルトループ箇所 
    private String opBeltLoopPlace;
    
    private Map<String,String> opBeltLoopPlaceMap;
    
    //ピンループ
    private String opPinLoop;
    
    private Map<String,String> opPinLoopMap;
    
    //脇ポケット
    private String opSidePkt;
    
    private Map<String,String> opSidePktMap;
    
    //忍びポケット
    private String opSinobiPkt;
    
    private Map<String,String> opSinobiPktMap;
    
    //コインポケット
    private String opCoinPkt;
    
    private Map<String,String> opCoinPktMap;
    
    //フラップ付コインポケット
    private String opFlapCoinPkt;
    
    private Map<String,String> opFlapCoinPktMap;
    
    //上前ピスポケット
    private String opPisPktUf;
    
    private Map<String,String> opPisPktUfMap;
    
    //下前ピスポケット
    private String opPisPktDf;
    
    private Map<String,String> opPisPktDfMap;
    
    //Vカット
    private String opVCut;
    
    private Map<String,String> opVCutMap;
    
    //裾上げ
    private String opHemUp;
    
    private Map<String,String> opHemUpMap;
    
    //ダブル幅
    private String opDoubleWide;
    
    private Map<String,String> opDoubleWideMap;
    
    //AMFステッチ
    private String opStitch;
    
    private Map<String,String> opStitchMap;
    
    //ステッチ箇所変更
    private String opStitchModify;
    
    private Map<String,String> opStitchModifyMap;
    
    //ステッチ箇所変更箇所
    private String opStitchModifyPlace;
    
    private Map<String,String> opStitchModifyPlaceMap;
    
    //ダブルステッチ
    private String opDStitch;
    
    private Map<String,String> opDStitchMap;
    
    //ダブルステッチ箇所
    private String opDStitchPlace;
    
    private Map<String,String> opDStitchPlaceMap;

	//AMF色指定
    private String opAmfColor;
    
    private Map<String,String> opAmfColorMap;
    
    //AMF糸色 
    private String opAmfColorPlaceAll;
    
    private Map<String,String> opAmfColorPlaceAllMap;
    
    //AMF色指定箇所
    private String opAmfColorPlace;
    
    private Map<String,String> opAmfColorPlaceMap;
    
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
    private String opBhColor;
    
    private Map<String,String> opBhColorMap;
    
    //ボタンホール色指定糸色
    private String opBhColorPlaceAll;
    
    private Map<String,String> opBhColorPlaceAllMap;
    
    //ボタンホール色指定箇所
    private String opBhColorPlace;
    
    private Map<String,String> opBhColorPlaceMap;
    
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
    private String opByColor;
    
    private Map<String,String> opByColorMap;
    
    //ボタン付け糸指定糸色
    private String opByColorPlaceAll;
    
    private Map<String,String> opByColorPlaceAllMap;
    
    //ボタン付け糸指定箇所
    private String opByColorPlace;
    
    private Map<String,String> opByColorPlaceMap;
    
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
    private String opButton;
    
    private Map<String,String> opButtonMap;
    
    //釦素材品番
    private String opBtnMateStkNo;
    
    //サスペンダー釦
    private String opSuspenderBtn;
    
    private Map<String,String> opSuspenderBtnMap;
    
    //エイト（滑り止め）
    private String opEight;
    
    private Map<String,String> opEightMap;
    
    //形状記憶
    private String opShapeMemory; 
    
    private Map<String,String> opShapeMemoryMap;
    
    //靴ずれ
    private String opBlister;
    
    private Map<String,String> opBlisterMap;

    //シック（股補強）
    private String opThick;
    
    private Map<String,String> opThickMap;
    
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

	public String getOpBeltLoopPlace() {
		return opBeltLoopPlace;
	}

	public void setOpBeltLoopPlace(String opBeltLoopPlace) {
		this.opBeltLoopPlace = opBeltLoopPlace;
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

	public String getOpStitchModifyPlace() {
		return opStitchModifyPlace;
	}

	public void setOpStitchModifyPlace(String opStitchModifyPlace) {
		this.opStitchModifyPlace = opStitchModifyPlace;
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

	public String getOpDStitchPlace() {
		return opDStitchPlace;
	}

	public void setOpDStitchPlace(String opDStitchPlace) {
		this.opDStitchPlace = opDStitchPlace;
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

	public String getOpAmfColorPlace() {
		return opAmfColorPlace;
	}

	public void setOpAmfColorPlace(String opAmfColorPlace) {
		this.opAmfColorPlace = opAmfColorPlace;
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

	public String getOpBhColorPlace() {
		return opBhColorPlace;
	}

	public void setOpBhColorPlace(String opBhColorPlace) {
		this.opBhColorPlace = opBhColorPlace;
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

	public String getOpByColorPlace() {
		return opByColorPlace;
	}

	public void setOpByColorPlace(String opByColorPlace) {
		this.opByColorPlace = opByColorPlace;
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

}
