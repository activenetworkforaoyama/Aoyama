package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;

public class OptionPantsTuxedoInfo implements Serializable{
	private static final long serialVersionUID = -4505963757793347479L;
	
	//PANTSモデル
	private String tpPantsModel;
	
	private Map<String,String> tpPantsModelMap;
	
	//タック
    private String tpTack;
    
    private Map<String,String> tpTackMap;
    
    //膝裏
    private String tpKneeBack;
    
    private Map<String,String> tpKneeBackMap;
    
    //膝裏素材
    private String tpKneeBackMate;

    private Map<String,String> tpKneeBackMateMap;
    
    //フロント仕様
  	private String tpFrontSpec;
      
    private Map<String,String> tpFrontSpecMap;
    
    //パンチェリーナ
    private String tpPancherina;
    
    private Map<String,String> tpPancherinaMap;
    
    //アジャスター仕様
    private String tpAdjuster;
    
    private Map<String,String> tpAdjusterMap;
    
    //ベルトループ
    private String tpBeltLoop;
    
    private Map<String,String> tpBeltLoopMap;
    
    //ベルトループ箇所 
    private String tpBeltLoopPlace;
    
    private Map<String,String> tpBeltLoopPlaceMap;
    
    //ピンループ
    private String tpPinLoop;
    
    private Map<String,String> tpPinLoopMap;
    
    //脇ポケット
    private String tpSidePkt;
    
    private Map<String,String> tpSidePktMap;
    
    //忍びポケット
    private String tpSinobiPkt;
    
    private Map<String,String> tpSinobiPktMap;
    
    //コインポケット
    private String tpCoinPkt;
    
    private Map<String,String> tpCoinPktMap;
    
    //フラップ付コインポケット
    private String tpFlapCoinPkt;
    
    private Map<String,String> tpFlapCoinPktMap;
    
    //上前ピスポケット
    private String tpPisPktUf;
    
    private Map<String,String> tpPisPktUfMap;
    
    //下前ピスポケット
    private String tpPisPktDf;
    
    private Map<String,String> tpPisPktDfMap;
    
    //Vカット
    private String tpVCut;
    
    private Map<String,String> tpVCutMap;
    
    //裾上げ
    private String tpHemUp;
    
    private Map<String,String> tpHemUpMap;
    
    //ダブル幅
    private String tpDoubleWide;
    
    private Map<String,String> tpDoubleWideMap;
    
    // ステッチ種類
 	private String tpStitch;

 	private Map<String, String> tpStitchMap;
 	
    // ステッチ箇所変更
 	private String tpStitchModify;
 	
 	// ダブルステッチ変更
 	private String tpDStitchPlace;
 	
 	// AMF色指定
 	private String tpAmfColor;
    
    //ボタンホール色指定
    private String tpBhColor;
    
    private Map<String,String> tpBhColorMap;
    
    //ボタンホール色指定糸色,ボタンホール色指定糸色(プルダウン)
    private String tpBhColorPlaceAll;
    
    private Map<String,String> tpBhColorPlaceAllMap;
    
    //ボタンホール色指定箇所
    private String tpBhColorPlace;
    
    private Map<String,String> tpBhColorPlaceMap;
    
    //ボタンホール色指定糸色  フロント
    private String tpBhColor1;
    
    //ボタンホール色指定糸色  上前ピスポケット
    private String tpBhColor2;
    
    //ボタンホール色指定糸色  下前ピスポケット
    private String tpBhColor3;
  
    //ボタンホール色指定糸色  フラップ付コインポケット
    private String tpBhColor4;
    
    //ボタンホール色指定色 key&value
    private Map<String,String> tpBhColorsMap;
    
    //ボタン付け糸指定
    private String tpByColor;
    
    private Map<String,String> tpByColorMap;
    
    //ボタン付け糸指定糸色,ボタン付け糸指定糸色(プルダウン)
    private String tpByColorPlaceAll;
    
    private Map<String,String> tpByColorPlaceAllMap;
    
    //ボタン付け糸指定箇所
    private String tpByColorPlace;
    
    private Map<String,String> tpByColorPlaceMap;
    
    //ボタン付け糸指定糸色  フロント
    private String tpByColor1;
    
    //ボタン付け糸指定糸色  上前ピスポケット
    private String tpByColor2;
    
    //ボタン付け糸指定糸色  下前ピスポケット
    private String tpByColor3;
  
    //ボタン付け糸指定糸色  フラップ付コインポケット
    private String tpByColor4;
    
    //ボタン付け糸指定糸色 key&value
    private Map<String,String> tpByColorsMap;
    
    //釦素材
    private String tpButton;
    
    private Map<String,String> tpButtonMap;
    
    //釦素材品番
    private String tpBtnMateStkNo;
    
    //サスペンダー釦
    private String tpSuspenderBtn;
    
    private Map<String,String> tpSuspenderBtnMap;
    
    //エイト（滑り止め）
    private String tpEight;
    
    private Map<String,String> tpEightMap;
    
    //シック（股補強）
    private String tpThick;
    
    private Map<String,String> tpThickMap;
    
    //形状記憶
    private String tpShapeMemory; 
    
    private Map<String,String> tpShapeMemoryMap;
    
    //側章
    private String tpSideStripe;
    
    private Map<String,String> tpSideStripeMap;
    
    //側章幅
    private String tpSideStripeWidth;
    
    private Map<String,String> tpSideStripeWidthMap;

	public String getTpPantsModel() {
		return tpPantsModel;
	}

	public void setTpPantsModel(String tpPantsModel) {
		this.tpPantsModel = tpPantsModel;
	}

	public Map<String, String> getTpPantsModelMap() {
		return tpPantsModelMap;
	}

	public void setTpPantsModelMap(Map<String, String> tpPantsModelMap) {
		this.tpPantsModelMap = tpPantsModelMap;
	}

	public String getTpTack() {
		return tpTack;
	}

	public void setTpTack(String tpTack) {
		this.tpTack = tpTack;
	}

	public Map<String, String> getTpTackMap() {
		return tpTackMap;
	}

	public void setTpTackMap(Map<String, String> tpTackMap) {
		this.tpTackMap = tpTackMap;
	}

	public String getTpKneeBack() {
		return tpKneeBack;
	}

	public void setTpKneeBack(String tpKneeBack) {
		this.tpKneeBack = tpKneeBack;
	}

	public Map<String, String> getTpKneeBackMap() {
		return tpKneeBackMap;
	}

	public void setTpKneeBackMap(Map<String, String> tpKneeBackMap) {
		this.tpKneeBackMap = tpKneeBackMap;
	}

	public String getTpKneeBackMate() {
		return tpKneeBackMate;
	}

	public void setTpKneeBackMate(String tpKneeBackMate) {
		this.tpKneeBackMate = tpKneeBackMate;
	}

	public Map<String, String> getTpKneeBackMateMap() {
		return tpKneeBackMateMap;
	}

	public void setTpKneeBackMateMap(Map<String, String> tpKneeBackMateMap) {
		this.tpKneeBackMateMap = tpKneeBackMateMap;
	}

	public String getTpFrontSpec() {
		return tpFrontSpec;
	}

	public void setTpFrontSpec(String tpFrontSpec) {
		this.tpFrontSpec = tpFrontSpec;
	}

	public Map<String, String> getTpFrontSpecMap() {
		return tpFrontSpecMap;
	}

	public void setTpFrontSpecMap(Map<String, String> tpFrontSpecMap) {
		this.tpFrontSpecMap = tpFrontSpecMap;
	}

	public String getTpPancherina() {
		return tpPancherina;
	}

	public void setTpPancherina(String tpPancherina) {
		this.tpPancherina = tpPancherina;
	}

	public Map<String, String> getTpPancherinaMap() {
		return tpPancherinaMap;
	}

	public void setTpPancherinaMap(Map<String, String> tpPancherinaMap) {
		this.tpPancherinaMap = tpPancherinaMap;
	}

	public String getTpAdjuster() {
		return tpAdjuster;
	}

	public void setTpAdjuster(String tpAdjuster) {
		this.tpAdjuster = tpAdjuster;
	}

	public Map<String, String> getTpAdjusterMap() {
		return tpAdjusterMap;
	}

	public void setTpAdjusterMap(Map<String, String> tpAdjusterMap) {
		this.tpAdjusterMap = tpAdjusterMap;
	}

	public String getTpBeltLoop() {
		return tpBeltLoop;
	}

	public void setTpBeltLoop(String tpBeltLoop) {
		this.tpBeltLoop = tpBeltLoop;
	}

	public Map<String, String> getTpBeltLoopMap() {
		return tpBeltLoopMap;
	}

	public void setTpBeltLoopMap(Map<String, String> tpBeltLoopMap) {
		this.tpBeltLoopMap = tpBeltLoopMap;
	}

	public String getTpBeltLoopPlace() {
		return tpBeltLoopPlace;
	}

	public void setTpBeltLoopPlace(String tpBeltLoopPlace) {
		this.tpBeltLoopPlace = tpBeltLoopPlace;
	}

	public Map<String, String> getTpBeltLoopPlaceMap() {
		return tpBeltLoopPlaceMap;
	}

	public void setTpBeltLoopPlaceMap(Map<String, String> tpBeltLoopPlaceMap) {
		this.tpBeltLoopPlaceMap = tpBeltLoopPlaceMap;
	}

	public String getTpPinLoop() {
		return tpPinLoop;
	}

	public void setTpPinLoop(String tpPinLoop) {
		this.tpPinLoop = tpPinLoop;
	}

	public Map<String, String> getTpPinLoopMap() {
		return tpPinLoopMap;
	}

	public void setTpPinLoopMap(Map<String, String> tpPinLoopMap) {
		this.tpPinLoopMap = tpPinLoopMap;
	}

	public String getTpSidePkt() {
		return tpSidePkt;
	}

	public void setTpSidePkt(String tpSidePkt) {
		this.tpSidePkt = tpSidePkt;
	}

	public Map<String, String> getTpSidePktMap() {
		return tpSidePktMap;
	}

	public void setTpSidePktMap(Map<String, String> tpSidePktMap) {
		this.tpSidePktMap = tpSidePktMap;
	}

	public String getTpSinobiPkt() {
		return tpSinobiPkt;
	}

	public void setTpSinobiPkt(String tpSinobiPkt) {
		this.tpSinobiPkt = tpSinobiPkt;
	}

	public Map<String, String> getTpSinobiPktMap() {
		return tpSinobiPktMap;
	}

	public void setTpSinobiPktMap(Map<String, String> tpSinobiPktMap) {
		this.tpSinobiPktMap = tpSinobiPktMap;
	}

	public String getTpCoinPkt() {
		return tpCoinPkt;
	}

	public void setTpCoinPkt(String tpCoinPkt) {
		this.tpCoinPkt = tpCoinPkt;
	}

	public Map<String, String> getTpCoinPktMap() {
		return tpCoinPktMap;
	}

	public void setTpCoinPktMap(Map<String, String> tpCoinPktMap) {
		this.tpCoinPktMap = tpCoinPktMap;
	}

	public String getTpFlapCoinPkt() {
		return tpFlapCoinPkt;
	}

	public void setTpFlapCoinPkt(String tpFlapCoinPkt) {
		this.tpFlapCoinPkt = tpFlapCoinPkt;
	}

	public Map<String, String> getTpFlapCoinPktMap() {
		return tpFlapCoinPktMap;
	}

	public void setTpFlapCoinPktMap(Map<String, String> tpFlapCoinPktMap) {
		this.tpFlapCoinPktMap = tpFlapCoinPktMap;
	}

	public String getTpPisPktUf() {
		return tpPisPktUf;
	}

	public void setTpPisPktUf(String tpPisPktUf) {
		this.tpPisPktUf = tpPisPktUf;
	}

	public Map<String, String> getTpPisPktUfMap() {
		return tpPisPktUfMap;
	}

	public void setTpPisPktUfMap(Map<String, String> tpPisPktUfMap) {
		this.tpPisPktUfMap = tpPisPktUfMap;
	}

	public String getTpPisPktDf() {
		return tpPisPktDf;
	}

	public void setTpPisPktDf(String tpPisPktDf) {
		this.tpPisPktDf = tpPisPktDf;
	}

	public Map<String, String> getTpPisPktDfMap() {
		return tpPisPktDfMap;
	}

	public void setTpPisPktDfMap(Map<String, String> tpPisPktDfMap) {
		this.tpPisPktDfMap = tpPisPktDfMap;
	}

	public String getTpVCut() {
		return tpVCut;
	}

	public void setTpVCut(String tpVCut) {
		this.tpVCut = tpVCut;
	}

	public Map<String, String> getTpVCutMap() {
		return tpVCutMap;
	}

	public void setTpVCutMap(Map<String, String> tpVCutMap) {
		this.tpVCutMap = tpVCutMap;
	}

	public String getTpHemUp() {
		return tpHemUp;
	}

	public void setTpHemUp(String tpHemUp) {
		this.tpHemUp = tpHemUp;
	}

	public Map<String, String> getTpHemUpMap() {
		return tpHemUpMap;
	}

	public void setTpHemUpMap(Map<String, String> tpHemUpMap) {
		this.tpHemUpMap = tpHemUpMap;
	}

	public String getTpDoubleWide() {
		return tpDoubleWide;
	}

	public void setTpDoubleWide(String tpDoubleWide) {
		this.tpDoubleWide = tpDoubleWide;
	}

	public Map<String, String> getTpDoubleWideMap() {
		return tpDoubleWideMap;
	}

	public void setTpDoubleWideMap(Map<String, String> tpDoubleWideMap) {
		this.tpDoubleWideMap = tpDoubleWideMap;
	}

	public String getTpStitch() {
		return tpStitch;
	}

	public void setTpStitch(String tpStitch) {
		this.tpStitch = tpStitch;
	}

	public Map<String, String> getTpStitchMap() {
		return tpStitchMap;
	}

	public void setTpStitchMap(Map<String, String> tpStitchMap) {
		this.tpStitchMap = tpStitchMap;
	}

	public String getTpStitchModify() {
		return tpStitchModify;
	}

	public void setTpStitchModify(String tpStitchModify) {
		this.tpStitchModify = tpStitchModify;
	}

	public String getTpDStitchPlace() {
		return tpDStitchPlace;
	}

	public void setTpDStitchPlace(String tpDStitchPlace) {
		this.tpDStitchPlace = tpDStitchPlace;
	}

	public String getTpAmfColor() {
		return tpAmfColor;
	}

	public void setTpAmfColor(String tpAmfColor) {
		this.tpAmfColor = tpAmfColor;
	}

	public String getTpBhColor() {
		return tpBhColor;
	}

	public void setTpBhColor(String tpBhColor) {
		this.tpBhColor = tpBhColor;
	}

	public Map<String, String> getTpBhColorMap() {
		return tpBhColorMap;
	}

	public void setTpBhColorMap(Map<String, String> tpBhColorMap) {
		this.tpBhColorMap = tpBhColorMap;
	}

	public String getTpBhColorPlaceAll() {
		return tpBhColorPlaceAll;
	}

	public void setTpBhColorPlaceAll(String tpBhColorPlaceAll) {
		this.tpBhColorPlaceAll = tpBhColorPlaceAll;
	}

	public Map<String, String> getTpBhColorPlaceAllMap() {
		return tpBhColorPlaceAllMap;
	}

	public void setTpBhColorPlaceAllMap(Map<String, String> tpBhColorPlaceAllMap) {
		this.tpBhColorPlaceAllMap = tpBhColorPlaceAllMap;
	}

	public String getTpBhColorPlace() {
		return tpBhColorPlace;
	}

	public void setTpBhColorPlace(String tpBhColorPlace) {
		this.tpBhColorPlace = tpBhColorPlace;
	}

	public Map<String, String> getTpBhColorPlaceMap() {
		return tpBhColorPlaceMap;
	}

	public void setTpBhColorPlaceMap(Map<String, String> tpBhColorPlaceMap) {
		this.tpBhColorPlaceMap = tpBhColorPlaceMap;
	}

	public String getTpBhColor1() {
		return tpBhColor1;
	}

	public void setTpBhColor1(String tpBhColor1) {
		this.tpBhColor1 = tpBhColor1;
	}

	public String getTpBhColor2() {
		return tpBhColor2;
	}

	public void setTpBhColor2(String tpBhColor2) {
		this.tpBhColor2 = tpBhColor2;
	}

	public String getTpBhColor3() {
		return tpBhColor3;
	}

	public void setTpBhColor3(String tpBhColor3) {
		this.tpBhColor3 = tpBhColor3;
	}

	public String getTpBhColor4() {
		return tpBhColor4;
	}

	public void setTpBhColor4(String tpBhColor4) {
		this.tpBhColor4 = tpBhColor4;
	}

	public Map<String, String> getTpBhColorsMap() {
		return tpBhColorsMap;
	}

	public void setTpBhColorsMap(Map<String, String> tpBhColorsMap) {
		this.tpBhColorsMap = tpBhColorsMap;
	}

	public String getTpByColor() {
		return tpByColor;
	}

	public void setTpByColor(String tpByColor) {
		this.tpByColor = tpByColor;
	}

	public Map<String, String> getTpByColorMap() {
		return tpByColorMap;
	}

	public void setTpByColorMap(Map<String, String> tpByColorMap) {
		this.tpByColorMap = tpByColorMap;
	}

	public String getTpByColorPlaceAll() {
		return tpByColorPlaceAll;
	}

	public void setTpByColorPlaceAll(String tpByColorPlaceAll) {
		this.tpByColorPlaceAll = tpByColorPlaceAll;
	}

	public Map<String, String> getTpByColorPlaceAllMap() {
		return tpByColorPlaceAllMap;
	}

	public void setTpByColorPlaceAllMap(Map<String, String> tpByColorPlaceAllMap) {
		this.tpByColorPlaceAllMap = tpByColorPlaceAllMap;
	}

	public String getTpByColorPlace() {
		return tpByColorPlace;
	}

	public void setTpByColorPlace(String tpByColorPlace) {
		this.tpByColorPlace = tpByColorPlace;
	}

	public Map<String, String> getTpByColorPlaceMap() {
		return tpByColorPlaceMap;
	}

	public void setTpByColorPlaceMap(Map<String, String> tpByColorPlaceMap) {
		this.tpByColorPlaceMap = tpByColorPlaceMap;
	}

	public String getTpByColor1() {
		return tpByColor1;
	}

	public void setTpByColor1(String tpByColor1) {
		this.tpByColor1 = tpByColor1;
	}

	public String getTpByColor2() {
		return tpByColor2;
	}

	public void setTpByColor2(String tpByColor2) {
		this.tpByColor2 = tpByColor2;
	}

	public String getTpByColor3() {
		return tpByColor3;
	}

	public void setTpByColor3(String tpByColor3) {
		this.tpByColor3 = tpByColor3;
	}

	public String getTpByColor4() {
		return tpByColor4;
	}

	public void setTpByColor4(String tpByColor4) {
		this.tpByColor4 = tpByColor4;
	}

	public Map<String, String> getTpByColorsMap() {
		return tpByColorsMap;
	}

	public void setTpByColorsMap(Map<String, String> tpByColorsMap) {
		this.tpByColorsMap = tpByColorsMap;
	}

	public String getTpButton() {
		return tpButton;
	}

	public void setTpButton(String tpButton) {
		this.tpButton = tpButton;
	}

	public Map<String, String> getTpButtonMap() {
		return tpButtonMap;
	}

	public void setTpButtonMap(Map<String, String> tpButtonMap) {
		this.tpButtonMap = tpButtonMap;
	}

	public String getTpBtnMateStkNo() {
		return tpBtnMateStkNo;
	}

	public void setTpBtnMateStkNo(String tpBtnMateStkNo) {
		this.tpBtnMateStkNo = tpBtnMateStkNo;
	}

	public String getTpSuspenderBtn() {
		return tpSuspenderBtn;
	}

	public void setTpSuspenderBtn(String tpSuspenderBtn) {
		this.tpSuspenderBtn = tpSuspenderBtn;
	}

	public Map<String, String> getTpSuspenderBtnMap() {
		return tpSuspenderBtnMap;
	}

	public void setTpSuspenderBtnMap(Map<String, String> tpSuspenderBtnMap) {
		this.tpSuspenderBtnMap = tpSuspenderBtnMap;
	}

	public String getTpEight() {
		return tpEight;
	}

	public void setTpEight(String tpEight) {
		this.tpEight = tpEight;
	}

	public Map<String, String> getTpEightMap() {
		return tpEightMap;
	}

	public void setTpEightMap(Map<String, String> tpEightMap) {
		this.tpEightMap = tpEightMap;
	}

	public String getTpThick() {
		return tpThick;
	}

	public void setTpThick(String tpThick) {
		this.tpThick = tpThick;
	}

	public Map<String, String> getTpThickMap() {
		return tpThickMap;
	}

	public void setTpThickMap(Map<String, String> tpThickMap) {
		this.tpThickMap = tpThickMap;
	}

	public String getTpShapeMemory() {
		return tpShapeMemory;
	}

	public void setTpShapeMemory(String tpShapeMemory) {
		this.tpShapeMemory = tpShapeMemory;
	}

	public Map<String, String> getTpShapeMemoryMap() {
		return tpShapeMemoryMap;
	}

	public void setTpShapeMemoryMap(Map<String, String> tpShapeMemoryMap) {
		this.tpShapeMemoryMap = tpShapeMemoryMap;
	}

	public String getTpSideStripe() {
		return tpSideStripe;
	}

	public void setTpSideStripe(String tpSideStripe) {
		this.tpSideStripe = tpSideStripe;
	}

	public Map<String, String> getTpSideStripeMap() {
		return tpSideStripeMap;
	}

	public void setTpSideStripeMap(Map<String, String> tpSideStripeMap) {
		this.tpSideStripeMap = tpSideStripeMap;
	}

	public String getTpSideStripeWidth() {
		return tpSideStripeWidth;
	}

	public void setTpSideStripeWidth(String tpSideStripeWidth) {
		this.tpSideStripeWidth = tpSideStripeWidth;
	}

	public Map<String, String> getTpSideStripeWidthMap() {
		return tpSideStripeWidthMap;
	}

	public void setTpSideStripeWidthMap(Map<String, String> tpSideStripeWidthMap) {
		this.tpSideStripeWidthMap = tpSideStripeWidthMap;
	}
}
	