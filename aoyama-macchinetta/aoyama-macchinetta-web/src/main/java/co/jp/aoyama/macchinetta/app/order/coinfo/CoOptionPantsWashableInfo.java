package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.PtWaItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.PtWaWpHemUpItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.PtWaWpKneeBackItem;

public class CoOptionPantsWashableInfo implements Serializable{
	private static final long serialVersionUID = -4505963757793347479L;
	
	//PANTSモデル
	@NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のモデルを入力して下さい。")
	private String wpPantsModel;
	
	private Map<String,String> wpPantsModelMap;
	
	//タック
	@NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のタックを入力して下さい。")
    private String wpTack;
    
    private Map<String,String> wpTackMap;
    
    private String ptTackRtPrice;
    
    //膝裏
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）の膝裏を入力して下さい。")
    private String wpKneeBack;
    
    private Map<String,String> wpKneeBackMap;
    
    private String ptKneeinnerTypeRtPrice;
    
    //膝裏素材
    @NotBlank(groups = { PtWaWpKneeBackItem.class }, message = "PANTS（1本目）の膝裏素材を入力して下さい。")
    private String wpKneeBackMate;

    private Map<String,String> wpKneeBackMateMap;
    
    private String ptKneeinnerClothRtPrice;
    
    //フロント仕様
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のフロント仕様を入力して下さい。")
  	private String wpFrontSpec;
      
    private Map<String,String> wpFrontSpecMap;
    
    private String ptFrtTypeRtPrice;
    
    //パンチェリーナ
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のパンチェリーナを入力して下さい。")
    private String wpPancherina;
    
    private Map<String,String> wpPancherinaMap;
    
    private String ptPancherinaRtPrice;
    
    //アジャスター仕様
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のアジャスター仕様を入力して下さい。")
    private String wpAdjuster;
    
    private Map<String,String> wpAdjusterMap;
    
    private String ptAdjusterRtPrice;
    
    //ベルトループ
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のベルトループを入力して下さい。")
    private String wpBeltLoop;
    
    private Map<String,String> wpBeltLoopMap;
    
    private String ptBeltLoopRtPrice;
    
    //ベルトループ箇所 
    private String wpBeltLoopPlace;
    
    private String wpBeltLoopPlace1;
    
    private String wpBeltLoopPlace2;
    
    private String wpBeltLoopPlace3;
    
    private String wpBeltLoopPlace4;
    
    private String wpBeltLoopPlace5;
    
    private String wpBeltLoopPlace6;
    
    private String wpBeltLoopPlace7;
    
    private Map<String,String> wpBeltLoopPlaceMap;
    
    //ピンループ
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のピンループを入力して下さい。")
    private String wpPinLoop;
    
    private Map<String,String> wpPinLoopMap;
    
    private String ptPinLoopRtPrice;
    
    //脇ポケット
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）の脇ポケットを入力して下さい。")
    private String wpSidePkt;
    
    private Map<String,String> wpSidePktMap;
    
    private String ptSidePktRtPrice;
    
    //忍びポケット
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）の忍びポケットを入力して下さい。")
    private String wpSinobiPkt;
    
    private Map<String,String> wpSinobiPktMap;
    
    private String ptShinobiPktRtPrice;
    
    //コインポケット
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のコインポケットを入力して下さい。")
    private String wpCoinPkt;
    
    private Map<String,String> wpCoinPktMap;
    
    private String ptCoinPktRtPrice;
    
    //フラップ付コインポケット
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のフラップ付コインポケットを入力して下さい。")
    private String wpFlapCoinPkt;
    
    private Map<String,String> wpFlapCoinPktMap;
    
    private String ptFlapcoinPktRtPrice;
    
    //上前ピスポケット
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）の上前ピスポケットを入力して下さい。")
    private String wpPisPktUf;
    
    private Map<String,String> wpPisPktUfMap;
    
    private String ptLeftPisPktRtPrice;
    
    //下前ピスポケット
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）の下前ピスポケットを入力して下さい。")
    private String wpPisPktDf;
    
    private Map<String,String> wpPisPktDfMap;
    
    private String ptRightPisPktRtPrice;
    
    //Vカット
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のVカットを入力して下さい。")
    private String wpVCut;
    
    private Map<String,String> wpVCutMap;
    
    private String ptVCutRtPrice;
    
    //裾上げ
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）の裾上げを入力して下さい。")
    private String wpHemUp;
    
    private Map<String,String> wpHemUpMap;
    
    private String ptHemUpRtPrice;
    
    //ダブル幅
    @NotBlank(groups = { PtWaWpHemUpItem.class }, message = "PANTS（1本目）のダブル幅を入力して下さい。")
    private String wpDoubleWide;
    
    private Map<String,String> wpDoubleWideMap;
    
    private String ptDblWidthRtPrice;
    
    //ステッチ種類
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のステッチ種類を入力して下さい。")
    private String wpStitch;
    
    private Map<String,String> wpStitchMap;
    
    private String ptAmfStitchRtPrice;
    
    //ステッチ箇所変更
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のステッチ箇所変更を入力して下さい。")
    private String wpStitchModify;
    
    private Map<String,String> wpStitchModifyMap;
    
    private String ptStitchPlcRtPrice;
    
    //ステッチ箇所変更箇所
    private String wpStitchModifyPlace;
    
    private String wpStitchModifyPlace1;
    
    private String wpStitchModifyPlace2;
    
    private String wpStitchModifyPlace3;
    
    private String wpStitchModifyPlace4;
    
    private Map<String,String> wpStitchModifyPlaceMap;
    
    //ダブルステッチ
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のダブルステッチを入力して下さい。")
    private String wpDStitch;
    
    private Map<String,String> wpDStitchMap;
    
    private String ptDblstitchPlcRtPrice;
    
    //ダブルステッチ箇所
    private String wpDStitchPlace;
    
    private String wpDStitchPlace1;
    
    private String wpDStitchPlace2;
    
    private String wpDStitchPlace3;
    
    private Map<String,String> wpDStitchPlaceMap;
    
    //AMF色指定
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のAMF色指定を入力して下さい。")
    private String wpAmfColor;
    
    private Map<String,String> wpAmfColorMap;
    
    private String ptAmfColorRtPrice;
    
    //AMF糸色 ,AMF色指定糸色(プルダウン)
    private String wpAmfColorPlaceAll;
    
    private Map<String,String> wpAmfColorPlaceAllMap;
    
    //AMF色指定箇所
    private String wpAmfColorPlace;
    
    private String wpAmfColorPlace1;
    
    private String wpAmfColorPlace2;
    
    private String wpAmfColorPlace3;
    
    private String wpAmfColorPlace4;
    
    private Map<String,String> wpAmfColorPlaceMap;
    
    private String wpAmfAllColor;
    //AMF糸色  脇ポケット
    private String wpAmfColor1;
    
    //AMF糸色  サイドシーム
    private String wpAmfColor2;
    
    //AMF糸色  ダーツ
    private String wpAmfColor3;
  
    //AMF糸色  ピスフラップ
    private String wpAmfColor4;
    
    //AMF色 key&value
    private Map<String,String> wpAmfColorsMap;
    
    //ボタンホール色指定
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のボタンホール色指定を入力して下さい。")
    private String wpBhColor;
    
    private Map<String,String> wpBhColorMap;
    
    private String ptBtnholeColorRtPrice;
    
    //ボタンホール色指定糸色,ボタンホール色指定糸色(プルダウン)
    private String wpBhColorPlaceAll;
    
    private Map<String,String> wpBhColorPlaceAllMap;
    
    //ボタンホール色指定箇所
    private String wpBhColorPlace;
    
    private String wpBhColorPlace1;
    
    private String wpBhColorPlace2;
    
    private String wpBhColorPlace3;
    
    private String wpBhColorPlace4;
    
    private Map<String,String> wpBhColorPlaceMap;
    
    private String wpBhAllColor;
    //ボタンホール色指定糸色  フロント
    private String wpBhColor1;
    
    //ボタンホール色指定糸色  上前ピスポケット
    private String wpBhColor2;
    
    //ボタンホール色指定糸色  下前ピスポケット
    private String wpBhColor3;
  
    //ボタンホール色指定糸色  フラップ付コインポケット
    private String wpBhColor4;
    
    //ボタンホール色指定色 key&value
    private Map<String,String> wpBhColorsMap;
    
    //ボタン付け糸指定
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のボタン付け糸指定を入力して下さい。")
    private String wpByColor;
    
    private Map<String,String> wpByColorMap;
    
    private String ptBtnthreadColorRtPrice;
    
    //ボタン付け糸指定糸色,ボタン付け糸指定糸色(プルダウン)
    private String wpByColorPlaceAll;
    
    private Map<String,String> wpByColorPlaceAllMap;
    
    //ボタン付け糸指定箇所
    private String wpByColorPlace;
    
    private String wpByColorPlace1;
    
    private String wpByColorPlace2;
    
    private String wpByColorPlace3;
    
    private String wpByColorPlace4;
    
    private Map<String,String> wpByColorPlaceMap;
    
    private String wpByAllColor;
    //ボタン付け糸指定糸色  フロント
    private String wpByColor1;
    
    //ボタン付け糸指定糸色  上前ピスポケット
    private String wpByColor2;
    
    //ボタン付け糸指定糸色  下前ピスポケット
    private String wpByColor3;
  
    //ボタン付け糸指定糸色  フラップ付コインポケット
    private String wpByColor4;
    
    //ボタン付け糸指定糸色 key&value
    private Map<String,String> wpByColorsMap;
    
    //釦素材
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）の釦素材を入力して下さい。")
    private String wpButton;
    
    private Map<String,String> wpButtonMap;
    
    private String ptBtnMaterialRtPrice;
    
    //釦素材品番
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）の釦素材品番を入力して下さい。")
    private String wpBtnMateStkNo;
    
    //サスペンダー釦
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のサスペンダー釦を入力して下さい。")
    private String wpSuspenderBtn;
    
    private Map<String,String> wpSuspenderBtnMap;
    
    private String ptSuspenderBtnRtPrice;
    
    //エイト（滑り止め）
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のエイト（滑り止め）を入力して下さい。")
    private String wpEight;
    
    private Map<String,String> wpEightMap;
    
    private String PtNonSlipRtPrice;
    
    //シック（股補強）
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）のシック（股補強）を入力して下さい。")
    private String wpThick;
    
    private Map<String,String> wpThickMap;
    
    private String ptChicSlipRtPrice;
    
    //形状記憶
    @NotBlank(groups = { PtWaItem.class }, message = "PANTS（1本目）の形状記憶を入力して下さい。")
    private String wpShapeMemory; 
    
    private Map<String,String> wpShapeMemoryMap;
    
    private String ptShapeMemoryRtPrice;
    
    //靴ずれ
    private String wpBlister;
    
    private Map<String,String> wpBlisterMap;

	public String getWpPantsModel() {
		return wpPantsModel;
	}

	public void setWpPantsModel(String wpPantsModel) {
		this.wpPantsModel = wpPantsModel;
	}

	public Map<String, String> getWpPantsModelMap() {
		return wpPantsModelMap;
	}

	public void setWpPantsModelMap(Map<String, String> wpPantsModelMap) {
		this.wpPantsModelMap = wpPantsModelMap;
	}

	public String getWpTack() {
		return wpTack;
	}

	public void setWpTack(String wpTack) {
		this.wpTack = wpTack;
	}

	public Map<String, String> getWpTackMap() {
		return wpTackMap;
	}

	public void setWpTackMap(Map<String, String> wpTackMap) {
		this.wpTackMap = wpTackMap;
	}

	public String getWpKneeBack() {
		return wpKneeBack;
	}

	public void setWpKneeBack(String wpKneeBack) {
		this.wpKneeBack = wpKneeBack;
	}

	public Map<String, String> getWpKneeBackMap() {
		return wpKneeBackMap;
	}

	public void setWpKneeBackMap(Map<String, String> wpKneeBackMap) {
		this.wpKneeBackMap = wpKneeBackMap;
	}

	public String getWpKneeBackMate() {
		return wpKneeBackMate;
	}

	public void setWpKneeBackMate(String wpKneeBackMate) {
		this.wpKneeBackMate = wpKneeBackMate;
	}

	public Map<String, String> getWpKneeBackMateMap() {
		return wpKneeBackMateMap;
	}

	public void setWpKneeBackMateMap(Map<String, String> wpKneeBackMateMap) {
		this.wpKneeBackMateMap = wpKneeBackMateMap;
	}

	public String getWpFrontSpec() {
		return wpFrontSpec;
	}

	public void setWpFrontSpec(String wpFrontSpec) {
		this.wpFrontSpec = wpFrontSpec;
	}

	public Map<String, String> getWpFrontSpecMap() {
		return wpFrontSpecMap;
	}

	public void setWpFrontSpecMap(Map<String, String> wpFrontSpecMap) {
		this.wpFrontSpecMap = wpFrontSpecMap;
	}

	public String getWpPancherina() {
		return wpPancherina;
	}

	public void setWpPancherina(String wpPancherina) {
		this.wpPancherina = wpPancherina;
	}

	public Map<String, String> getWpPancherinaMap() {
		return wpPancherinaMap;
	}

	public void setWpPancherinaMap(Map<String, String> wpPancherinaMap) {
		this.wpPancherinaMap = wpPancherinaMap;
	}

	public String getWpAdjuster() {
		return wpAdjuster;
	}

	public void setWpAdjuster(String wpAdjuster) {
		this.wpAdjuster = wpAdjuster;
	}

	public Map<String, String> getWpAdjusterMap() {
		return wpAdjusterMap;
	}

	public void setWpAdjusterMap(Map<String, String> wpAdjusterMap) {
		this.wpAdjusterMap = wpAdjusterMap;
	}

	public String getWpBeltLoop() {
		return wpBeltLoop;
	}

	public void setWpBeltLoop(String wpBeltLoop) {
		this.wpBeltLoop = wpBeltLoop;
	}

	public Map<String, String> getWpBeltLoopMap() {
		return wpBeltLoopMap;
	}

	public void setWpBeltLoopMap(Map<String, String> wpBeltLoopMap) {
		this.wpBeltLoopMap = wpBeltLoopMap;
	}

	public Map<String, String> getWpBeltLoopPlaceMap() {
		return wpBeltLoopPlaceMap;
	}

	public void setWpBeltLoopPlaceMap(Map<String, String> wpBeltLoopPlaceMap) {
		this.wpBeltLoopPlaceMap = wpBeltLoopPlaceMap;
	}

	public String getWpPinLoop() {
		return wpPinLoop;
	}

	public void setWpPinLoop(String wpPinLoop) {
		this.wpPinLoop = wpPinLoop;
	}

	public Map<String, String> getWpPinLoopMap() {
		return wpPinLoopMap;
	}

	public void setWpPinLoopMap(Map<String, String> wpPinLoopMap) {
		this.wpPinLoopMap = wpPinLoopMap;
	}

	public String getWpSidePkt() {
		return wpSidePkt;
	}

	public void setWpSidePkt(String wpSidePkt) {
		this.wpSidePkt = wpSidePkt;
	}

	public Map<String, String> getWpSidePktMap() {
		return wpSidePktMap;
	}

	public void setWpSidePktMap(Map<String, String> wpSidePktMap) {
		this.wpSidePktMap = wpSidePktMap;
	}

	public String getWpSinobiPkt() {
		return wpSinobiPkt;
	}

	public void setWpSinobiPkt(String wpSinobiPkt) {
		this.wpSinobiPkt = wpSinobiPkt;
	}

	public Map<String, String> getWpSinobiPktMap() {
		return wpSinobiPktMap;
	}

	public void setWpSinobiPktMap(Map<String, String> wpSinobiPktMap) {
		this.wpSinobiPktMap = wpSinobiPktMap;
	}

	public String getWpCoinPkt() {
		return wpCoinPkt;
	}

	public void setWpCoinPkt(String wpCoinPkt) {
		this.wpCoinPkt = wpCoinPkt;
	}

	public Map<String, String> getWpCoinPktMap() {
		return wpCoinPktMap;
	}

	public void setWpCoinPktMap(Map<String, String> wpCoinPktMap) {
		this.wpCoinPktMap = wpCoinPktMap;
	}

	public String getWpFlapCoinPkt() {
		return wpFlapCoinPkt;
	}

	public void setWpFlapCoinPkt(String wpFlapCoinPkt) {
		this.wpFlapCoinPkt = wpFlapCoinPkt;
	}

	public Map<String, String> getWpFlapCoinPktMap() {
		return wpFlapCoinPktMap;
	}

	public void setWpFlapCoinPktMap(Map<String, String> wpFlapCoinPktMap) {
		this.wpFlapCoinPktMap = wpFlapCoinPktMap;
	}

	public String getWpPisPktUf() {
		return wpPisPktUf;
	}

	public void setWpPisPktUf(String wpPisPktUf) {
		this.wpPisPktUf = wpPisPktUf;
	}

	public Map<String, String> getWpPisPktUfMap() {
		return wpPisPktUfMap;
	}

	public void setWpPisPktUfMap(Map<String, String> wpPisPktUfMap) {
		this.wpPisPktUfMap = wpPisPktUfMap;
	}

	public String getWpPisPktDf() {
		return wpPisPktDf;
	}

	public void setWpPisPktDf(String wpPisPktDf) {
		this.wpPisPktDf = wpPisPktDf;
	}

	public Map<String, String> getWpPisPktDfMap() {
		return wpPisPktDfMap;
	}

	public void setWpPisPktDfMap(Map<String, String> wpPisPktDfMap) {
		this.wpPisPktDfMap = wpPisPktDfMap;
	}

	public String getWpVCut() {
		return wpVCut;
	}

	public void setWpVCut(String wpVCut) {
		this.wpVCut = wpVCut;
	}

	public Map<String, String> getWpVCutMap() {
		return wpVCutMap;
	}

	public void setWpVCutMap(Map<String, String> wpVCutMap) {
		this.wpVCutMap = wpVCutMap;
	}

	public String getWpHemUp() {
		return wpHemUp;
	}

	public void setWpHemUp(String wpHemUp) {
		this.wpHemUp = wpHemUp;
	}

	public Map<String, String> getWpHemUpMap() {
		return wpHemUpMap;
	}

	public void setWpHemUpMap(Map<String, String> wpHemUpMap) {
		this.wpHemUpMap = wpHemUpMap;
	}

	public String getWpDoubleWide() {
		return wpDoubleWide;
	}

	public void setWpDoubleWide(String wpDoubleWide) {
		this.wpDoubleWide = wpDoubleWide;
	}

	public Map<String, String> getWpDoubleWideMap() {
		return wpDoubleWideMap;
	}

	public void setWpDoubleWideMap(Map<String, String> wpDoubleWideMap) {
		this.wpDoubleWideMap = wpDoubleWideMap;
	}

	public String getWpStitch() {
		return wpStitch;
	}

	public void setWpStitch(String wpStitch) {
		this.wpStitch = wpStitch;
	}

	public Map<String, String> getWpStitchMap() {
		return wpStitchMap;
	}

	public void setWpStitchMap(Map<String, String> wpStitchMap) {
		this.wpStitchMap = wpStitchMap;
	}

	public String getWpStitchModify() {
		return wpStitchModify;
	}

	public void setWpStitchModify(String wpStitchModify) {
		this.wpStitchModify = wpStitchModify;
	}

	public Map<String, String> getWpStitchModifyMap() {
		return wpStitchModifyMap;
	}

	public void setWpStitchModifyMap(Map<String, String> wpStitchModifyMap) {
		this.wpStitchModifyMap = wpStitchModifyMap;
	}

	public Map<String, String> getWpStitchModifyPlaceMap() {
		return wpStitchModifyPlaceMap;
	}

	public void setWpStitchModifyPlaceMap(Map<String, String> wpStitchModifyPlaceMap) {
		this.wpStitchModifyPlaceMap = wpStitchModifyPlaceMap;
	}

	public String getWpDStitch() {
		return wpDStitch;
	}

	public void setWpDStitch(String wpDStitch) {
		this.wpDStitch = wpDStitch;
	}

	public Map<String, String> getWpDStitchMap() {
		return wpDStitchMap;
	}

	public void setWpDStitchMap(Map<String, String> wpDStitchMap) {
		this.wpDStitchMap = wpDStitchMap;
	}

	public Map<String, String> getWpDStitchPlaceMap() {
		return wpDStitchPlaceMap;
	}

	public void setWpDStitchPlaceMap(Map<String, String> wpDStitchPlaceMap) {
		this.wpDStitchPlaceMap = wpDStitchPlaceMap;
	}

	public String getWpAmfColor() {
		return wpAmfColor;
	}

	public void setWpAmfColor(String wpAmfColor) {
		this.wpAmfColor = wpAmfColor;
	}

	public Map<String, String> getWpAmfColorMap() {
		return wpAmfColorMap;
	}

	public void setWpAmfColorMap(Map<String, String> wpAmfColorMap) {
		this.wpAmfColorMap = wpAmfColorMap;
	}

	public String getWpAmfColorPlaceAll() {
		return wpAmfColorPlaceAll;
	}

	public void setWpAmfColorPlaceAll(String wpAmfColorPlaceAll) {
		this.wpAmfColorPlaceAll = wpAmfColorPlaceAll;
	}

	public Map<String, String> getWpAmfColorPlaceAllMap() {
		return wpAmfColorPlaceAllMap;
	}

	public void setWpAmfColorPlaceAllMap(Map<String, String> wpAmfColorPlaceAllMap) {
		this.wpAmfColorPlaceAllMap = wpAmfColorPlaceAllMap;
	}

	public Map<String, String> getWpAmfColorPlaceMap() {
		return wpAmfColorPlaceMap;
	}

	public void setWpAmfColorPlaceMap(Map<String, String> wpAmfColorPlaceMap) {
		this.wpAmfColorPlaceMap = wpAmfColorPlaceMap;
	}

	public String getWpAmfColor1() {
		return wpAmfColor1;
	}

	public void setWpAmfColor1(String wpAmfColor1) {
		this.wpAmfColor1 = wpAmfColor1;
	}

	public String getWpAmfColor2() {
		return wpAmfColor2;
	}

	public void setWpAmfColor2(String wpAmfColor2) {
		this.wpAmfColor2 = wpAmfColor2;
	}

	public String getWpAmfColor3() {
		return wpAmfColor3;
	}

	public void setWpAmfColor3(String wpAmfColor3) {
		this.wpAmfColor3 = wpAmfColor3;
	}

	public String getWpAmfColor4() {
		return wpAmfColor4;
	}

	public void setWpAmfColor4(String wpAmfColor4) {
		this.wpAmfColor4 = wpAmfColor4;
	}

	public Map<String, String> getWpAmfColorsMap() {
		return wpAmfColorsMap;
	}

	public void setWpAmfColorsMap(Map<String, String> wpAmfColorsMap) {
		this.wpAmfColorsMap = wpAmfColorsMap;
	}

	public String getWpBhColor() {
		return wpBhColor;
	}

	public void setWpBhColor(String wpBhColor) {
		this.wpBhColor = wpBhColor;
	}

	public Map<String, String> getWpBhColorMap() {
		return wpBhColorMap;
	}

	public void setWpBhColorMap(Map<String, String> wpBhColorMap) {
		this.wpBhColorMap = wpBhColorMap;
	}

	public String getWpBhColorPlaceAll() {
		return wpBhColorPlaceAll;
	}

	public void setWpBhColorPlaceAll(String wpBhColorPlaceAll) {
		this.wpBhColorPlaceAll = wpBhColorPlaceAll;
	}

	public Map<String, String> getWpBhColorPlaceAllMap() {
		return wpBhColorPlaceAllMap;
	}

	public void setWpBhColorPlaceAllMap(Map<String, String> wpBhColorPlaceAllMap) {
		this.wpBhColorPlaceAllMap = wpBhColorPlaceAllMap;
	}

	public Map<String, String> getWpBhColorPlaceMap() {
		return wpBhColorPlaceMap;
	}

	public void setWpBhColorPlaceMap(Map<String, String> wpBhColorPlaceMap) {
		this.wpBhColorPlaceMap = wpBhColorPlaceMap;
	}

	public String getWpBhColor1() {
		return wpBhColor1;
	}

	public void setWpBhColor1(String wpBhColor1) {
		this.wpBhColor1 = wpBhColor1;
	}

	public String getWpBhColor2() {
		return wpBhColor2;
	}

	public void setWpBhColor2(String wpBhColor2) {
		this.wpBhColor2 = wpBhColor2;
	}

	public String getWpBhColor3() {
		return wpBhColor3;
	}

	public void setWpBhColor3(String wpBhColor3) {
		this.wpBhColor3 = wpBhColor3;
	}

	public String getWpBhColor4() {
		return wpBhColor4;
	}

	public void setWpBhColor4(String wpBhColor4) {
		this.wpBhColor4 = wpBhColor4;
	}

	public Map<String, String> getWpBhColorsMap() {
		return wpBhColorsMap;
	}

	public void setWpBhColorsMap(Map<String, String> wpBhColorsMap) {
		this.wpBhColorsMap = wpBhColorsMap;
	}

	public String getWpByColor() {
		return wpByColor;
	}

	public void setWpByColor(String wpByColor) {
		this.wpByColor = wpByColor;
	}

	public Map<String, String> getWpByColorMap() {
		return wpByColorMap;
	}

	public void setWpByColorMap(Map<String, String> wpByColorMap) {
		this.wpByColorMap = wpByColorMap;
	}

	public String getWpByColorPlaceAll() {
		return wpByColorPlaceAll;
	}

	public void setWpByColorPlaceAll(String wpByColorPlaceAll) {
		this.wpByColorPlaceAll = wpByColorPlaceAll;
	}

	public Map<String, String> getWpByColorPlaceAllMap() {
		return wpByColorPlaceAllMap;
	}

	public void setWpByColorPlaceAllMap(Map<String, String> wpByColorPlaceAllMap) {
		this.wpByColorPlaceAllMap = wpByColorPlaceAllMap;
	}

	public Map<String, String> getWpByColorPlaceMap() {
		return wpByColorPlaceMap;
	}

	public void setWpByColorPlaceMap(Map<String, String> wpByColorPlaceMap) {
		this.wpByColorPlaceMap = wpByColorPlaceMap;
	}

	public String getWpByColor1() {
		return wpByColor1;
	}

	public void setWpByColor1(String wpByColor1) {
		this.wpByColor1 = wpByColor1;
	}

	public String getWpByColor2() {
		return wpByColor2;
	}

	public void setWpByColor2(String wpByColor2) {
		this.wpByColor2 = wpByColor2;
	}

	public String getWpByColor3() {
		return wpByColor3;
	}

	public void setWpByColor3(String wpByColor3) {
		this.wpByColor3 = wpByColor3;
	}

	public String getWpByColor4() {
		return wpByColor4;
	}

	public void setWpByColor4(String wpByColor4) {
		this.wpByColor4 = wpByColor4;
	}

	public Map<String, String> getWpByColorsMap() {
		return wpByColorsMap;
	}

	public void setWpByColorsMap(Map<String, String> wpByColorsMap) {
		this.wpByColorsMap = wpByColorsMap;
	}

	public String getWpButton() {
		return wpButton;
	}

	public void setWpButton(String wpButton) {
		this.wpButton = wpButton;
	}

	public Map<String, String> getWpButtonMap() {
		return wpButtonMap;
	}

	public void setWpButtonMap(Map<String, String> wpButtonMap) {
		this.wpButtonMap = wpButtonMap;
	}

	public String getWpBtnMateStkNo() {
		return wpBtnMateStkNo;
	}

	public void setWpBtnMateStkNo(String wpBtnMateStkNo) {
		this.wpBtnMateStkNo = wpBtnMateStkNo;
	}

	public String getWpSuspenderBtn() {
		return wpSuspenderBtn;
	}

	public void setWpSuspenderBtn(String wpSuspenderBtn) {
		this.wpSuspenderBtn = wpSuspenderBtn;
	}

	public Map<String, String> getWpSuspenderBtnMap() {
		return wpSuspenderBtnMap;
	}

	public void setWpSuspenderBtnMap(Map<String, String> wpSuspenderBtnMap) {
		this.wpSuspenderBtnMap = wpSuspenderBtnMap;
	}

	public String getWpEight() {
		return wpEight;
	}

	public void setWpEight(String wpEight) {
		this.wpEight = wpEight;
	}

	public Map<String, String> getWpEightMap() {
		return wpEightMap;
	}

	public void setWpEightMap(Map<String, String> wpEightMap) {
		this.wpEightMap = wpEightMap;
	}

	public String getWpThick() {
		return wpThick;
	}

	public void setWpThick(String wpThick) {
		this.wpThick = wpThick;
	}

	public Map<String, String> getWpThickMap() {
		return wpThickMap;
	}

	public void setWpThickMap(Map<String, String> wpThickMap) {
		this.wpThickMap = wpThickMap;
	}

	public String getWpShapeMemory() {
		return wpShapeMemory;
	}

	public void setWpShapeMemory(String wpShapeMemory) {
		this.wpShapeMemory = wpShapeMemory;
	}

	public Map<String, String> getWpShapeMemoryMap() {
		return wpShapeMemoryMap;
	}

	public void setWpShapeMemoryMap(Map<String, String> wpShapeMemoryMap) {
		this.wpShapeMemoryMap = wpShapeMemoryMap;
	}

	public String getWpBlister() {
		return wpBlister;
	}

	public void setWpBlister(String wpBlister) {
		this.wpBlister = wpBlister;
	}

	public Map<String, String> getWpBlisterMap() {
		return wpBlisterMap;
	}

	public void setWpBlisterMap(Map<String, String> wpBlisterMap) {
		this.wpBlisterMap = wpBlisterMap;
	}

	public String getWpBeltLoopPlace1() {
		return wpBeltLoopPlace1;
	}

	public void setWpBeltLoopPlace1(String wpBeltLoopPlace1) {
		this.wpBeltLoopPlace1 = wpBeltLoopPlace1;
	}

	public String getWpBeltLoopPlace2() {
		return wpBeltLoopPlace2;
	}

	public void setWpBeltLoopPlace2(String wpBeltLoopPlace2) {
		this.wpBeltLoopPlace2 = wpBeltLoopPlace2;
	}

	public String getWpBeltLoopPlace3() {
		return wpBeltLoopPlace3;
	}

	public void setWpBeltLoopPlace3(String wpBeltLoopPlace3) {
		this.wpBeltLoopPlace3 = wpBeltLoopPlace3;
	}

	public String getWpBeltLoopPlace4() {
		return wpBeltLoopPlace4;
	}

	public void setWpBeltLoopPlace4(String wpBeltLoopPlace4) {
		this.wpBeltLoopPlace4 = wpBeltLoopPlace4;
	}

	public String getWpBeltLoopPlace5() {
		return wpBeltLoopPlace5;
	}

	public void setWpBeltLoopPlace5(String wpBeltLoopPlace5) {
		this.wpBeltLoopPlace5 = wpBeltLoopPlace5;
	}

	public String getWpBeltLoopPlace6() {
		return wpBeltLoopPlace6;
	}

	public void setWpBeltLoopPlace6(String wpBeltLoopPlace6) {
		this.wpBeltLoopPlace6 = wpBeltLoopPlace6;
	}

	public String getWpBeltLoopPlace7() {
		return wpBeltLoopPlace7;
	}

	public void setWpBeltLoopPlace7(String wpBeltLoopPlace7) {
		this.wpBeltLoopPlace7 = wpBeltLoopPlace7;
	}

	public String getWpStitchModifyPlace1() {
		return wpStitchModifyPlace1;
	}

	public void setWpStitchModifyPlace1(String wpStitchModifyPlace1) {
		this.wpStitchModifyPlace1 = wpStitchModifyPlace1;
	}

	public String getWpStitchModifyPlace2() {
		return wpStitchModifyPlace2;
	}

	public void setWpStitchModifyPlace2(String wpStitchModifyPlace2) {
		this.wpStitchModifyPlace2 = wpStitchModifyPlace2;
	}

	public String getWpStitchModifyPlace3() {
		return wpStitchModifyPlace3;
	}

	public void setWpStitchModifyPlace3(String wpStitchModifyPlace3) {
		this.wpStitchModifyPlace3 = wpStitchModifyPlace3;
	}

	public String getWpStitchModifyPlace4() {
		return wpStitchModifyPlace4;
	}

	public void setWpStitchModifyPlace4(String wpStitchModifyPlace4) {
		this.wpStitchModifyPlace4 = wpStitchModifyPlace4;
	}

	public String getWpDStitchPlace1() {
		return wpDStitchPlace1;
	}

	public void setWpDStitchPlace1(String wpDStitchPlace1) {
		this.wpDStitchPlace1 = wpDStitchPlace1;
	}

	public String getWpDStitchPlace2() {
		return wpDStitchPlace2;
	}

	public void setWpDStitchPlace2(String wpDStitchPlace2) {
		this.wpDStitchPlace2 = wpDStitchPlace2;
	}

	public String getWpDStitchPlace3() {
		return wpDStitchPlace3;
	}

	public void setWpDStitchPlace3(String wpDStitchPlace3) {
		this.wpDStitchPlace3 = wpDStitchPlace3;
	}

	public String getWpAmfColorPlace1() {
		return wpAmfColorPlace1;
	}

	public void setWpAmfColorPlace1(String wpAmfColorPlace1) {
		this.wpAmfColorPlace1 = wpAmfColorPlace1;
	}

	public String getWpAmfColorPlace2() {
		return wpAmfColorPlace2;
	}

	public void setWpAmfColorPlace2(String wpAmfColorPlace2) {
		this.wpAmfColorPlace2 = wpAmfColorPlace2;
	}

	public String getWpAmfColorPlace3() {
		return wpAmfColorPlace3;
	}

	public void setWpAmfColorPlace3(String wpAmfColorPlace3) {
		this.wpAmfColorPlace3 = wpAmfColorPlace3;
	}

	public String getWpAmfColorPlace4() {
		return wpAmfColorPlace4;
	}

	public void setWpAmfColorPlace4(String wpAmfColorPlace4) {
		this.wpAmfColorPlace4 = wpAmfColorPlace4;
	}

	public String getWpBhColorPlace1() {
		return wpBhColorPlace1;
	}

	public void setWpBhColorPlace1(String wpBhColorPlace1) {
		this.wpBhColorPlace1 = wpBhColorPlace1;
	}

	public String getWpBhColorPlace2() {
		return wpBhColorPlace2;
	}

	public void setWpBhColorPlace2(String wpBhColorPlace2) {
		this.wpBhColorPlace2 = wpBhColorPlace2;
	}

	public String getWpBhColorPlace3() {
		return wpBhColorPlace3;
	}

	public void setWpBhColorPlace3(String wpBhColorPlace3) {
		this.wpBhColorPlace3 = wpBhColorPlace3;
	}

	public String getWpBhColorPlace4() {
		return wpBhColorPlace4;
	}

	public void setWpBhColorPlace4(String wpBhColorPlace4) {
		this.wpBhColorPlace4 = wpBhColorPlace4;
	}

	public String getWpByColorPlace1() {
		return wpByColorPlace1;
	}

	public void setWpByColorPlace1(String wpByColorPlace1) {
		this.wpByColorPlace1 = wpByColorPlace1;
	}

	public String getWpByColorPlace2() {
		return wpByColorPlace2;
	}

	public void setWpByColorPlace2(String wpByColorPlace2) {
		this.wpByColorPlace2 = wpByColorPlace2;
	}

	public String getWpByColorPlace3() {
		return wpByColorPlace3;
	}

	public void setWpByColorPlace3(String wpByColorPlace3) {
		this.wpByColorPlace3 = wpByColorPlace3;
	}

	public String getWpByColorPlace4() {
		return wpByColorPlace4;
	}

	public void setWpByColorPlace4(String wpByColorPlace4) {
		this.wpByColorPlace4 = wpByColorPlace4;
	}

	public String getWpBeltLoopPlace() {
		return wpBeltLoopPlace;
	}

	public void setWpBeltLoopPlace(String wpBeltLoopPlace) {
		this.wpBeltLoopPlace = wpBeltLoopPlace;
	}

	public String getWpStitchModifyPlace() {
		return wpStitchModifyPlace;
	}

	public void setWpStitchModifyPlace(String wpStitchModifyPlace) {
		this.wpStitchModifyPlace = wpStitchModifyPlace;
	}

	public String getWpDStitchPlace() {
		return wpDStitchPlace;
	}

	public void setWpDStitchPlace(String wpDStitchPlace) {
		this.wpDStitchPlace = wpDStitchPlace;
	}

	public String getWpAmfColorPlace() {
		return wpAmfColorPlace;
	}

	public void setWpAmfColorPlace(String wpAmfColorPlace) {
		this.wpAmfColorPlace = wpAmfColorPlace;
	}

	public String getWpBhColorPlace() {
		return wpBhColorPlace;
	}

	public void setWpBhColorPlace(String wpBhColorPlace) {
		this.wpBhColorPlace = wpBhColorPlace;
	}

	public String getWpByColorPlace() {
		return wpByColorPlace;
	}

	public void setWpByColorPlace(String wpByColorPlace) {
		this.wpByColorPlace = wpByColorPlace;
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

	public String getPtAmfStitchRtPrice() {
		return ptAmfStitchRtPrice;
	}

	public void setPtAmfStitchRtPrice(String ptAmfStitchRtPrice) {
		this.ptAmfStitchRtPrice = ptAmfStitchRtPrice;
	}

	public String getWpAmfAllColor() {
		return wpAmfAllColor;
	}

	public void setWpAmfAllColor(String wpAmfAllColor) {
		this.wpAmfAllColor = wpAmfAllColor;
	}

	public String getWpBhAllColor() {
		return wpBhAllColor;
	}

	public void setWpBhAllColor(String wpBhAllColor) {
		this.wpBhAllColor = wpBhAllColor;
	}

	public String getWpByAllColor() {
		return wpByAllColor;
	}

	public void setWpByAllColor(String wpByAllColor) {
		this.wpByAllColor = wpByAllColor;
	}
    
}
