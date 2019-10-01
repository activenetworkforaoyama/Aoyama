package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

public class CoOptionPantsTuxedoInfo implements Serializable{
	private static final long serialVersionUID = -4505963757793347479L;
	
	//PANTSモデル
	private String tpPantsModel;
	
	private Map<String,String> tpPantsModelMap;
	
	//タック
    private String tpTack;
    
    private Map<String,String> tpTackMap;
    
    private String ptTackRtPrice;
    
    //膝裏
    private String tpKneeBack;
    
    private Map<String,String> tpKneeBackMap;
    
    private String ptKneeinnerTypeRtPrice;
    
    //膝裏素材
    private String tpKneeBackMate;

    private Map<String,String> tpKneeBackMateMap;
 
    private String ptKneeinnerClothRtPrice;
    
    //フロント仕様
  	private String tpFrontSpec;
      
    private Map<String,String> tpFrontSpecMap;

    private String ptFrtTypeRtPrice;
    
    //パンチェリーナ
    private String tpPancherina;
    
    private Map<String,String> tpPancherinaMap;
    
    private String ptPancherinaRtPrice;
    
    //アジャスター仕様
    private String tpAdjuster;
    
    private Map<String,String> tpAdjusterMap;
    
    private String ptAdjusterRtPrice;
    
    //ベルトループ
    private String tpBeltLoop;
    
    private Map<String,String> tpBeltLoopMap;
    
    private String ptBeltLoopRtPrice;
    
    //ベルトループ箇所 
    private String tpBeltLoopPlace;
    
    private String tpBeltLoopPlace1;
    
    private String tpBeltLoopPlace2;
    
    private String tpBeltLoopPlace3;
    
    private String tpBeltLoopPlace4;
    
    private String tpBeltLoopPlace5;
    
    private String tpBeltLoopPlace6;
    
    private String tpBeltLoopPlace7;
    
    private Map<String,String> tpBeltLoopPlaceMap;
    
    //ピンループ
    private String tpPinLoop;
    
    private Map<String,String> tpPinLoopMap;
    
    private String ptPinLoopRtPrice;
    
    //脇ポケット
    private String tpSidePkt;
    
    private Map<String,String> tpSidePktMap;
    
    private String ptSidePktRtPrice;
    
    //忍びポケット
    private String tpSinobiPkt;
    
    private Map<String,String> tpSinobiPktMap;
    
    private String ptShinobiPktRtPrice;
    
    //コインポケット
    private String tpCoinPkt;
    
    private Map<String,String> tpCoinPktMap;
    
    private String ptCoinPktRtPrice;
    
    //フラップ付コインポケット
    private String tpFlapCoinPkt;
    
    private Map<String,String> tpFlapCoinPktMap;
    
    private String ptFlapcoinPktRtPrice;
    
    //上前ピスポケット
    private String tpPisPktUf;
    
    private Map<String,String> tpPisPktUfMap;
    
    private String ptLeftPisPktRtPrice;
    
    //下前ピスポケット
    private String tpPisPktDf;
    
    private Map<String,String> tpPisPktDfMap;
    
    private String ptRightPisPktRtPrice;
    
    //Vカット
    private String tpVCut;
    
    private Map<String,String> tpVCutMap;
    
    private String ptVCutRtPrice;
    
    //裾上げ
    private String tpHemUp;
    
    private Map<String,String> tpHemUpMap;
    
    private String ptHemUpRtPrice;
    
    //ダブル幅
    private String tpDoubleWide;
    
    private Map<String,String> tpDoubleWideMap;
    
    private String ptDblWidthRtPrice;
    
    // ステッチ種類
 	private String tpStitch;

 	private Map<String, String> tpStitchMap;
 	
 	private String  ptAmfStitchRtPrice;
 	
    // ステッチ箇所変更
 	private String tpStitchModify = "0002001";
 	
 	// ダブルステッチ変更
 	private String tpDStitchPlace = "0002201";
 	
 	// AMF色指定
 	private String tpAmfColor = "0002401";
    
    //ボタンホール色指定
    private String tpBhColor;
    
    private Map<String,String> tpBhColorMap;
    
    private String ptBtnholeColorRtPrice;
    
    //ボタンホール色指定糸色,ボタンホール色指定糸色(プルダウン)
    private String tpBhColorPlaceAll;
    
    private Map<String,String> tpBhColorPlaceAllMap;
    
    //ボタンホール色指定箇所
    private String tpBhColorPlace;
    
    private String tpBhColorPlace1;
    
    private String tpBhColorPlace2;
    
    private String tpBhColorPlace3;
    
    private String tpBhColorPlace4;
    
    private Map<String,String> tpBhColorPlaceMap;
    
    private String tpBhAllColor;
    
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
    
    private String ptBtnthreadColorRtPrice;
    
    //ボタン付け糸指定糸色,ボタン付け糸指定糸色(プルダウン)
    private String tpByColorPlaceAll;
    
    private Map<String,String> tpByColorPlaceAllMap;
    
    //ボタン付け糸指定箇所
    private String tpByColorPlace;
    
    private String tpByColorPlace1;
    
    private String tpByColorPlace2;
    
    private String tpByColorPlace3;
    
    private String tpByColorPlace4;
    
    private Map<String,String> tpByColorPlaceMap;
    
    private String tpByAllColor;
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
    
    private String ptBtnMaterialRtPrice;
    
    //釦素材品番
    private String tpBtnMateStkNo;
    
    //サスペンダー釦
    private String tpSuspenderBtn;
    
    private Map<String,String> tpSuspenderBtnMap;
    
    private String ptSuspenderBtnRtPrice;
    
    //エイト（滑り止め）
    private String tpEight;
    
    private Map<String,String> tpEightMap;
    
    private String PtNonSlipRtPrice;
    
    //シック（股補強）
    private String tpThick;
    
    private Map<String,String> tpThickMap;
    
    private String ptChicSlipRtPrice;
    
    //形状記憶
    private String tpShapeMemory; 
    
    private Map<String,String> tpShapeMemoryMap;
    
    private String ptShapeMemoryRtPrice;
    //側章
    private String tpSideStripe;
    
    private Map<String,String> tpSideStripeMap;
    
    private String ptSideStripeRtPrice;
    
    //側章幅
    private String tpSideStripeWidth;
    
    private Map<String,String> tpSideStripeWidthMap;
    
    private String ptSideStripeWidthRtPrice;

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

	public String getTpByColorPlace1() {
		return tpByColorPlace1;
	}

	public void setTpByColorPlace1(String tpByColorPlace1) {
		this.tpByColorPlace1 = tpByColorPlace1;
	}

	public String getTpByColorPlace2() {
		return tpByColorPlace2;
	}

	public void setTpByColorPlace2(String tpByColorPlace2) {
		this.tpByColorPlace2 = tpByColorPlace2;
	}

	public String getTpByColorPlace3() {
		return tpByColorPlace3;
	}

	public void setTpByColorPlace3(String tpByColorPlace3) {
		this.tpByColorPlace3 = tpByColorPlace3;
	}

	public String getTpByColorPlace4() {
		return tpByColorPlace4;
	}

	public void setTpByColorPlace4(String tpByColorPlace4) {
		this.tpByColorPlace4 = tpByColorPlace4;
	}

	public String getTpBeltLoopPlace1() {
		return tpBeltLoopPlace1;
	}

	public void setTpBeltLoopPlace1(String tpBeltLoopPlace1) {
		this.tpBeltLoopPlace1 = tpBeltLoopPlace1;
	}

	public String getTpBeltLoopPlace2() {
		return tpBeltLoopPlace2;
	}

	public void setTpBeltLoopPlace2(String tpBeltLoopPlace2) {
		this.tpBeltLoopPlace2 = tpBeltLoopPlace2;
	}

	public String getTpBeltLoopPlace3() {
		return tpBeltLoopPlace3;
	}

	public void setTpBeltLoopPlace3(String tpBeltLoopPlace3) {
		this.tpBeltLoopPlace3 = tpBeltLoopPlace3;
	}

	public String getTpBeltLoopPlace4() {
		return tpBeltLoopPlace4;
	}

	public void setTpBeltLoopPlace4(String tpBeltLoopPlace4) {
		this.tpBeltLoopPlace4 = tpBeltLoopPlace4;
	}

	public String getTpBeltLoopPlace5() {
		return tpBeltLoopPlace5;
	}

	public void setTpBeltLoopPlace5(String tpBeltLoopPlace5) {
		this.tpBeltLoopPlace5 = tpBeltLoopPlace5;
	}

	public String getTpBeltLoopPlace6() {
		return tpBeltLoopPlace6;
	}

	public void setTpBeltLoopPlace6(String tpBeltLoopPlace6) {
		this.tpBeltLoopPlace6 = tpBeltLoopPlace6;
	}

	public String getTpBeltLoopPlace7() {
		return tpBeltLoopPlace7;
	}

	public void setTpBeltLoopPlace7(String tpBeltLoopPlace7) {
		this.tpBeltLoopPlace7 = tpBeltLoopPlace7;
	}

	public String getTpBhColorPlace1() {
		return tpBhColorPlace1;
	}

	public void setTpBhColorPlace1(String tpBhColorPlace1) {
		this.tpBhColorPlace1 = tpBhColorPlace1;
	}

	public String getTpBhColorPlace2() {
		return tpBhColorPlace2;
	}

	public void setTpBhColorPlace2(String tpBhColorPlace2) {
		this.tpBhColorPlace2 = tpBhColorPlace2;
	}

	public String getTpBhColorPlace3() {
		return tpBhColorPlace3;
	}

	public void setTpBhColorPlace3(String tpBhColorPlace3) {
		this.tpBhColorPlace3 = tpBhColorPlace3;
	}

	public String getTpBhColorPlace4() {
		return tpBhColorPlace4;
	}

	public void setTpBhColorPlace4(String tpBhColorPlace4) {
		this.tpBhColorPlace4 = tpBhColorPlace4;
	}

	public String getTpBeltLoopPlace() {
		return tpBeltLoopPlace;
	}

	public void setTpBeltLoopPlace(String tpBeltLoopPlace) {
		this.tpBeltLoopPlace = tpBeltLoopPlace;
	}

	public String getTpBhColorPlace() {
		return tpBhColorPlace;
	}

	public void setTpBhColorPlace(String tpBhColorPlace) {
		this.tpBhColorPlace = tpBhColorPlace;
	}

	public String getTpByColorPlace() {
		return tpByColorPlace;
	}

	public void setTpByColorPlace(String tpByColorPlace) {
		this.tpByColorPlace = tpByColorPlace;
	}

	public String getPtTackRtPrice() {
		return ptTackRtPrice;
	}

	public void setPtTackRtPrice(String ptTackRtPrice) {
		this.ptTackRtPrice = ptTackRtPrice;
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

	public String getPtChicSlipRtPrice() {
		return ptChicSlipRtPrice;
	}

	public void setPtChicSlipRtPrice(String ptChicSlipRtPrice) {
		this.ptChicSlipRtPrice = ptChicSlipRtPrice;
	}

	public String getPtShapeMemoryRtPrice() {
		return ptShapeMemoryRtPrice;
	}

	public void setPtShapeMemoryRtPrice(String ptShapeMemoryRtPrice) {
		this.ptShapeMemoryRtPrice = ptShapeMemoryRtPrice;
	}

	public Map<String, String> getTpKneeBackMateMap() {
		return tpKneeBackMateMap;
	}

	public void setTpKneeBackMateMap(Map<String, String> tpKneeBackMateMap) {
		this.tpKneeBackMateMap = tpKneeBackMateMap;
	}

	public String getPtKneeinnerClothRtPrice() {
		return ptKneeinnerClothRtPrice;
	}

	public void setPtKneeinnerClothRtPrice(String ptKneeinnerClothRtPrice) {
		this.ptKneeinnerClothRtPrice = ptKneeinnerClothRtPrice;
	}

	public String getPtKneeinnerTypeRtPrice() {
		return ptKneeinnerTypeRtPrice;
	}

	public void setPtKneeinnerTypeRtPrice(String ptKneeinnerTypeRtPrice) {
		this.ptKneeinnerTypeRtPrice = ptKneeinnerTypeRtPrice;
	}

	public String getPtBeltLoopRtPrice() {
		return ptBeltLoopRtPrice;
	}

	public void setPtBeltLoopRtPrice(String ptBeltLoopRtPrice) {
		this.ptBeltLoopRtPrice = ptBeltLoopRtPrice;
	}

	public String getPtAmfStitchRtPrice() {
		return ptAmfStitchRtPrice;
	}

	public void setPtAmfStitchRtPrice(String ptAmfStitchRtPrice) {
		this.ptAmfStitchRtPrice = ptAmfStitchRtPrice;
	}

	public String getPtSideStripeRtPrice() {
		return ptSideStripeRtPrice;
	}

	public void setPtSideStripeRtPrice(String ptSideStripeRtPrice) {
		this.ptSideStripeRtPrice = ptSideStripeRtPrice;
	}

	public String getPtSideStripeWidthRtPrice() {
		return ptSideStripeWidthRtPrice;
	}

	public void setPtSideStripeWidthRtPrice(String ptSideStripeWidthRtPrice) {
		this.ptSideStripeWidthRtPrice = ptSideStripeWidthRtPrice;
	}

	public String getTpBhAllColor() {
		return tpBhAllColor;
	}

	public void setTpBhAllColor(String tpBhAllColor) {
		this.tpBhAllColor = tpBhAllColor;
	}

	public String getTpByAllColor() {
		return tpByAllColor;
	}

	public void setTpByAllColor(String tpByAllColor) {
		this.tpByAllColor = tpByAllColor;
	}

	
	
	
}
	