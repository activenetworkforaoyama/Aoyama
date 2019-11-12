package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.Pt2WaItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.Pt2WaWpHemUpItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.Pt2WaWpKneeBackItem;

public class CoOptionPants2WashableInfo implements Serializable{
	private static final long serialVersionUID = -4505963757793347479L;
	
	//PANTSモデル
	@NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のモデルを入力して下さい。")
	private String wp2PantsModel;
	
	private Map<String,String> wp2PantsModelMap;
	
	//タック
	@NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のタックを入力して下さい。")
    private String wp2Tack;
    
    private Map<String,String> wp2TackMap;
    
    //膝裏
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）の膝裏を入力して下さい。")
    private String wp2KneeBack;
    
    private Map<String,String> wp2KneeBackMap;
    
    //膝裏素材
    @NotBlank(groups = { Pt2WaWpKneeBackItem.class }, message = "PANTS（2本目）の膝裏素材を入力して下さい。")
    private String wp2KneeBackMate;

    private Map<String,String> wp2KneeBackMateMap;
    
    //フロント仕様
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のフロント仕様を入力して下さい。")
  	private String wp2FrontSpec;
      
    private Map<String,String> wp2FrontSpecMap;
    
    //パンチェリーナ
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のパンチェリーナを入力して下さい。")
    private String wp2Pancherina;
    
    private Map<String,String> wp2PancherinaMap;
    
    //アジャスター仕様
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のアジャスター仕様を入力して下さい。")
    private String wp2Adjuster;
    
    private Map<String,String> wp2AdjusterMap;
    
    //ベルトループ
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のベルトループを入力して下さい。")
    private String wp2BeltLoop;
    
    private Map<String,String> wp2BeltLoopMap;
    
    //ベルトループ箇所 
    private String wp2BeltLoopPlace;
    
    private String wp2BeltLoopPlace1;
    
    private String wp2BeltLoopPlace2;
    
    private String wp2BeltLoopPlace3;
    
    private String wp2BeltLoopPlace4;
    
    private String wp2BeltLoopPlace5;
    
    private String wp2BeltLoopPlace6;
    
    private String wp2BeltLoopPlace7;
    
    private Map<String,String> wp2BeltLoopPlaceMap;
    
    //ピンループ
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のピンループを入力して下さい。")
    private String wp2PinLoop;
    
    private Map<String,String> wp2PinLoopMap;
    
    //脇ポケット
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）の脇ポケットを入力して下さい。")
    private String wp2SidePkt;
    
    private Map<String,String> wp2SidePktMap;
    
    //忍びポケット
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）の忍びポケットを入力して下さい。")
    private String wp2SinobiPkt;
    
    private Map<String,String> wp2SinobiPktMap;
    
    //コインポケット
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のコインポケットを入力して下さい。")
    private String wp2CoinPkt;
    
    private Map<String,String> wp2CoinPktMap;
    
    //フラップ付コインポケット
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のフラップ付コインポケットを入力して下さい。")
    private String wp2FlapCoinPkt;
    
    private Map<String,String> wp2FlapCoinPktMap;
    
    //上前ピスポケット
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）の上前ピスポケットを入力して下さい。")
    private String wp2PisPktUf;
    
    private Map<String,String> wp2PisPktUfMap;
    
    //下前ピスポケット
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）の下前ピスポケットを入力して下さい。")
    private String wp2PisPktDf;
    
    private Map<String,String> wp2PisPktDfMap;
    
    //Vカット
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のVカットを入力して下さい。")
    private String wp2VCut;
    
    private Map<String,String> wp2VCutMap;
    
    //裾上げ
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）の裾上げを入力して下さい。")
    private String wp2HemUp;
    
    private Map<String,String> wp2HemUpMap;
    
    //ダブル幅
    @NotBlank(groups = { Pt2WaWpHemUpItem.class }, message = "PANTS（2本目）のダブル幅を入力して下さい。")
    private String wp2DoubleWide;
    
    private Map<String,String> wp2DoubleWideMap;
    
    //ステッチ種類
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のステッチ種類を入力して下さい。")
    private String wp2Stitch;
    
    private Map<String,String> wp2StitchMap;
    
    //ステッチ箇所変更
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のステッチ箇所変更を入力して下さい。")
    private String wp2StitchModify;
    
    private Map<String,String> wp2StitchModifyMap;
    
    //ステッチ箇所変更箇所
    private String wp2StitchModifyPlace;
    
    private String wp2StitchModifyPlace1;
    
    private String wp2StitchModifyPlace2;
    
    private String wp2StitchModifyPlace3;
    
    private String wp2StitchModifyPlace4;
    
    private Map<String,String> wp2StitchModifyPlaceMap;
    
    //ダブルステッチ
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のダブルステッチを入力して下さい。")
    private String wp2DStitch;
    
    private Map<String,String> wp2DStitchMap;
    
    //ダブルステッチ箇所
    private String wp2DStitchPlace;
    
    private String wp2DStitchPlace1;
    
    private String wp2DStitchPlace2;
    
    private String wp2DStitchPlace3;
    
    private Map<String,String> wp2DStitchPlaceMap;
    
    //AMF色指定
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のAMF色指定を入力して下さい。")
    private String wp2AmfColor;
    
    private Map<String,String> wp2AmfColorMap;
    
    //AMF糸色 ,AMF色指定糸色(プルダウン)
    private String wp2AmfColorPlaceAll;
    
    private Map<String,String> wp2AmfColorPlaceAllMap;
    
    //AMF色指定箇所
    private String wp2AmfColorPlace;
    
    private String wp2AmfColorPlace1;
    
    private String wp2AmfColorPlace2;
    
    private String wp2AmfColorPlace3;
    
    private String wp2AmfColorPlace4;
    
    private Map<String,String> wp2AmfColorPlaceMap;
    
    private String wp2AmfAllColor;
    //AMF糸色  脇ポケット
    private String wp2AmfColor1;
    
    //AMF糸色  サイドシーム
    private String wp2AmfColor2;
    
    //AMF糸色  ダーツ
    private String wp2AmfColor3;
  
    //AMF糸色  ピスフラップ
    private String wp2AmfColor4;
    
    //AMF色 key&value
    private Map<String,String> wp2AmfColorsMap;
    
    //ボタンホール色指定
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のボタンホール色指定を入力して下さい。")
    private String wp2BhColor;
    
    private Map<String,String> wp2BhColorMap;
    
    //ボタンホール色指定糸色,ボタンホール色指定糸色(プルダウン)
    private String wp2BhColorPlaceAll;
    
    private Map<String,String> wp2BhColorPlaceAllMap;
    
    //ボタンホール色指定箇所
    private String wp2BhColorPlace;
    
    private String wp2BhColorPlace1;
    
    private String wp2BhColorPlace2;
    
    private String wp2BhColorPlace3;
    
    private String wp2BhColorPlace4;
    
    private Map<String,String> wp2BhColorPlaceMap;
    
    private String wp2BhAllColor;
    //ボタンホール色指定糸色  フロント
    private String wp2BhColor1;
    
    //ボタンホール色指定糸色  上前ピスポケット
    private String wp2BhColor2;
    
    //ボタンホール色指定糸色  下前ピスポケット
    private String wp2BhColor3;
  
    //ボタンホール色指定糸色  フラップ付コインポケット
    private String wp2BhColor4;
    
    //ボタンホール色指定色 key&value
    private Map<String,String> wp2BhColorsMap;
    
    //ボタン付け糸指定
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のボタン付け糸指定を入力して下さい。")
    private String wp2ByColor;
    
    private Map<String,String> wp2ByColorMap;
    
    //ボタン付け糸指定糸色,ボタン付け糸指定糸色(プルダウン)
    private String wp2ByColorPlaceAll;
    
    private Map<String,String> wp2ByColorPlaceAllMap;
    
    //ボタン付け糸指定箇所
    private String wp2ByColorPlace;
    
    private String wp2ByColorPlace1;
    
    private String wp2ByColorPlace2;
    
    private String wp2ByColorPlace3;
    
    private String wp2ByColorPlace4;
    
    private Map<String,String> wp2ByColorPlaceMap;
    
    private String wp2ByAllColor;
    //ボタン付け糸指定糸色  フロント
    private String wp2ByColor1;
    
    //ボタン付け糸指定糸色  上前ピスポケット
    private String wp2ByColor2;
    
    //ボタン付け糸指定糸色  下前ピスポケット
    private String wp2ByColor3;
  
    //ボタン付け糸指定糸色  フラップ付コインポケット
    private String wp2ByColor4;
    
    //ボタン付け糸指定糸色 key&value
    private Map<String,String> wp2ByColorsMap;
    
    //釦素材
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）の釦素材を入力して下さい。")
    private String wp2Button;
    
    private Map<String,String> wp2ButtonMap;
    
    //釦素材品番
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）の釦素材品番を入力して下さい。")
    private String wp2BtnMateStkNo;
    
    //サスペンダー釦
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のサスペンダー釦を入力して下さい。")
    private String wp2SuspenderBtn;
    
    private Map<String,String> wp2SuspenderBtnMap;
    
    //エイト（滑り止め）
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のエイト（滑り止め）を入力して下さい。")
    private String wp2Eight;
    
    private Map<String,String> wp2EightMap;
    
    //シック（股補強）
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）のシック（股補強）を入力して下さい。")
    private String wp2Thick;
    
    private Map<String,String> wp2ThickMap;
    
    //形状記憶
    @NotBlank(groups = { Pt2WaItem.class }, message = "PANTS（2本目）の形状記憶を入力して下さい。")
    private String wp2ShapeMemory; 
    
    private Map<String,String> wp2ShapeMemoryMap;
    
    //靴ずれ
    private String wp2Blister;
    
    private Map<String,String> wp2BlisterMap;
    
    private String pt2TackRtPrice;
    private String pt2KneeinnerTypeRtPrice;
    private String pt2KneeinnerClothRtPrice;
    private String pt2FrtTypeRtPrice;
    private String pt2PancherinaRtPrice;
    private String pt2AdjusterRtPrice;
    private String pt2BeltloopRtPrice;
    private String pt2PinloopRtPrice;
    private String pt2SidePktRtPrice;
    private String pt2ShinobiPktRtPrice;
    private String pt2CoinPktRtPrice;
    private String pt2FlapcoinPktRtPrice;
    private String pt2LeftPisPktRtPrice;
    private String pt2RightPisPktRtPrice;
    private String pt2VCutRtPrice;
    private String pt2HemUpRtPrice;
    private String pt2DblWidthRtPrice;
    private String pt2AmfStitchRtPrice;
    private String pt2StitchPlcRtPrice;
    private String pt2DblstitchPlcRtPrice;
    private String pt2AmfColorRtPrice;
    private String pt2BtnholeColorRtPrice;
    private String pt2BtnthreadColorRtPrice;
    private String pt2BtnMaterialRtPrice;
    private String pt2SuspenderBtnRtPrice;
    private String pt2NonSlipRtPrice;
    private String pt2ChicSlipRtPrice;
    private String pt2ShapeMemoryRtPrice;


	public String getWp2Tack() {
		return wp2Tack;
	}

	public void setWp2Tack(String wp2Tack) {
		this.wp2Tack = wp2Tack;
	}

	public Map<String, String> getWp2TackMap() {
		return wp2TackMap;
	}

	public void setWp2TackMap(Map<String, String> wp2TackMap) {
		this.wp2TackMap = wp2TackMap;
	}

	public String getWp2KneeBack() {
		return wp2KneeBack;
	}

	public void setWp2KneeBack(String wp2KneeBack) {
		this.wp2KneeBack = wp2KneeBack;
	}

	public Map<String, String> getWp2KneeBackMap() {
		return wp2KneeBackMap;
	}

	public void setWp2KneeBackMap(Map<String, String> wp2KneeBackMap) {
		this.wp2KneeBackMap = wp2KneeBackMap;
	}

	public String getWp2KneeBackMate() {
		return wp2KneeBackMate;
	}

	public void setWp2KneeBackMate(String wp2KneeBackMate) {
		this.wp2KneeBackMate = wp2KneeBackMate;
	}

	public Map<String, String> getWp2KneeBackMateMap() {
		return wp2KneeBackMateMap;
	}

	public void setWp2KneeBackMateMap(Map<String, String> wp2KneeBackMateMap) {
		this.wp2KneeBackMateMap = wp2KneeBackMateMap;
	}

	public String getWp2FrontSpec() {
		return wp2FrontSpec;
	}

	public void setWp2FrontSpec(String wp2FrontSpec) {
		this.wp2FrontSpec = wp2FrontSpec;
	}

	public Map<String, String> getWp2FrontSpecMap() {
		return wp2FrontSpecMap;
	}

	public void setWp2FrontSpecMap(Map<String, String> wp2FrontSpecMap) {
		this.wp2FrontSpecMap = wp2FrontSpecMap;
	}

	public String getWp2Pancherina() {
		return wp2Pancherina;
	}

	public void setWp2Pancherina(String wp2Pancherina) {
		this.wp2Pancherina = wp2Pancherina;
	}

	public Map<String, String> getWp2PancherinaMap() {
		return wp2PancherinaMap;
	}

	public void setWp2PancherinaMap(Map<String, String> wp2PancherinaMap) {
		this.wp2PancherinaMap = wp2PancherinaMap;
	}

	public String getWp2Adjuster() {
		return wp2Adjuster;
	}

	public void setWp2Adjuster(String wp2Adjuster) {
		this.wp2Adjuster = wp2Adjuster;
	}

	public Map<String, String> getWp2AdjusterMap() {
		return wp2AdjusterMap;
	}

	public void setWp2AdjusterMap(Map<String, String> wp2AdjusterMap) {
		this.wp2AdjusterMap = wp2AdjusterMap;
	}

	public String getWp2BeltLoop() {
		return wp2BeltLoop;
	}

	public void setWp2BeltLoop(String wp2BeltLoop) {
		this.wp2BeltLoop = wp2BeltLoop;
	}

	public Map<String, String> getWp2BeltLoopMap() {
		return wp2BeltLoopMap;
	}

	public void setWp2BeltLoopMap(Map<String, String> wp2BeltLoopMap) {
		this.wp2BeltLoopMap = wp2BeltLoopMap;
	}


	public Map<String, String> getWp2BeltLoopPlaceMap() {
		return wp2BeltLoopPlaceMap;
	}

	public void setWp2BeltLoopPlaceMap(Map<String, String> wp2BeltLoopPlaceMap) {
		this.wp2BeltLoopPlaceMap = wp2BeltLoopPlaceMap;
	}

	public String getWp2PinLoop() {
		return wp2PinLoop;
	}

	public void setWp2PinLoop(String wp2PinLoop) {
		this.wp2PinLoop = wp2PinLoop;
	}

	public Map<String, String> getWp2PinLoopMap() {
		return wp2PinLoopMap;
	}

	public void setWp2PinLoopMap(Map<String, String> wp2PinLoopMap) {
		this.wp2PinLoopMap = wp2PinLoopMap;
	}

	public String getWp2SidePkt() {
		return wp2SidePkt;
	}

	public void setWp2SidePkt(String wp2SidePkt) {
		this.wp2SidePkt = wp2SidePkt;
	}

	public Map<String, String> getWp2SidePktMap() {
		return wp2SidePktMap;
	}

	public void setWp2SidePktMap(Map<String, String> wp2SidePktMap) {
		this.wp2SidePktMap = wp2SidePktMap;
	}

	public String getWp2SinobiPkt() {
		return wp2SinobiPkt;
	}

	public void setWp2SinobiPkt(String wp2SinobiPkt) {
		this.wp2SinobiPkt = wp2SinobiPkt;
	}

	public Map<String, String> getWp2SinobiPktMap() {
		return wp2SinobiPktMap;
	}

	public void setWp2SinobiPktMap(Map<String, String> wp2SinobiPktMap) {
		this.wp2SinobiPktMap = wp2SinobiPktMap;
	}

	public String getWp2CoinPkt() {
		return wp2CoinPkt;
	}

	public void setWp2CoinPkt(String wp2CoinPkt) {
		this.wp2CoinPkt = wp2CoinPkt;
	}

	public Map<String, String> getWp2CoinPktMap() {
		return wp2CoinPktMap;
	}

	public void setWp2CoinPktMap(Map<String, String> wp2CoinPktMap) {
		this.wp2CoinPktMap = wp2CoinPktMap;
	}

	public String getWp2FlapCoinPkt() {
		return wp2FlapCoinPkt;
	}

	public void setWp2FlapCoinPkt(String wp2FlapCoinPkt) {
		this.wp2FlapCoinPkt = wp2FlapCoinPkt;
	}

	public Map<String, String> getWp2FlapCoinPktMap() {
		return wp2FlapCoinPktMap;
	}

	public void setWp2FlapCoinPktMap(Map<String, String> wp2FlapCoinPktMap) {
		this.wp2FlapCoinPktMap = wp2FlapCoinPktMap;
	}

	public String getWp2PisPktUf() {
		return wp2PisPktUf;
	}

	public void setWp2PisPktUf(String wp2PisPktUf) {
		this.wp2PisPktUf = wp2PisPktUf;
	}

	public Map<String, String> getWp2PisPktUfMap() {
		return wp2PisPktUfMap;
	}

	public void setWp2PisPktUfMap(Map<String, String> wp2PisPktUfMap) {
		this.wp2PisPktUfMap = wp2PisPktUfMap;
	}

	public String getWp2PisPktDf() {
		return wp2PisPktDf;
	}

	public void setWp2PisPktDf(String wp2PisPktDf) {
		this.wp2PisPktDf = wp2PisPktDf;
	}

	public Map<String, String> getWp2PisPktDfMap() {
		return wp2PisPktDfMap;
	}

	public void setWp2PisPktDfMap(Map<String, String> wp2PisPktDfMap) {
		this.wp2PisPktDfMap = wp2PisPktDfMap;
	}

	public String getWp2VCut() {
		return wp2VCut;
	}

	public void setWp2VCut(String wp2VCut) {
		this.wp2VCut = wp2VCut;
	}

	public Map<String, String> getWp2VCutMap() {
		return wp2VCutMap;
	}

	public void setWp2VCutMap(Map<String, String> wp2VCutMap) {
		this.wp2VCutMap = wp2VCutMap;
	}

	public String getWp2HemUp() {
		return wp2HemUp;
	}

	public void setWp2HemUp(String wp2HemUp) {
		this.wp2HemUp = wp2HemUp;
	}

	public Map<String, String> getWp2HemUpMap() {
		return wp2HemUpMap;
	}

	public void setWp2HemUpMap(Map<String, String> wp2HemUpMap) {
		this.wp2HemUpMap = wp2HemUpMap;
	}

	public String getWp2DoubleWide() {
		return wp2DoubleWide;
	}

	public void setWp2DoubleWide(String wp2DoubleWide) {
		this.wp2DoubleWide = wp2DoubleWide;
	}

	public Map<String, String> getWp2DoubleWideMap() {
		return wp2DoubleWideMap;
	}

	public void setWp2DoubleWideMap(Map<String, String> wp2DoubleWideMap) {
		this.wp2DoubleWideMap = wp2DoubleWideMap;
	}

	public String getWp2Stitch() {
		return wp2Stitch;
	}

	public void setWp2Stitch(String wp2Stitch) {
		this.wp2Stitch = wp2Stitch;
	}

	public Map<String, String> getWp2StitchMap() {
		return wp2StitchMap;
	}

	public void setWp2StitchMap(Map<String, String> wp2StitchMap) {
		this.wp2StitchMap = wp2StitchMap;
	}

	public String getWp2StitchModify() {
		return wp2StitchModify;
	}

	public void setWp2StitchModify(String wp2StitchModify) {
		this.wp2StitchModify = wp2StitchModify;
	}

	public Map<String, String> getWp2StitchModifyMap() {
		return wp2StitchModifyMap;
	}

	public void setWp2StitchModifyMap(Map<String, String> wp2StitchModifyMap) {
		this.wp2StitchModifyMap = wp2StitchModifyMap;
	}


	public Map<String, String> getWp2StitchModifyPlaceMap() {
		return wp2StitchModifyPlaceMap;
	}

	public void setWp2StitchModifyPlaceMap(Map<String, String> wp2StitchModifyPlaceMap) {
		this.wp2StitchModifyPlaceMap = wp2StitchModifyPlaceMap;
	}

	public String getWp2DStitch() {
		return wp2DStitch;
	}

	public void setWp2DStitch(String wp2DStitch) {
		this.wp2DStitch = wp2DStitch;
	}

	public Map<String, String> getWp2DStitchMap() {
		return wp2DStitchMap;
	}

	public void setWp2DStitchMap(Map<String, String> wp2DStitchMap) {
		this.wp2DStitchMap = wp2DStitchMap;
	}

	public Map<String, String> getWp2DStitchPlaceMap() {
		return wp2DStitchPlaceMap;
	}

	public void setWp2DStitchPlaceMap(Map<String, String> wp2DStitchPlaceMap) {
		this.wp2DStitchPlaceMap = wp2DStitchPlaceMap;
	}

	public String getWp2AmfColor() {
		return wp2AmfColor;
	}

	public void setWp2AmfColor(String wp2AmfColor) {
		this.wp2AmfColor = wp2AmfColor;
	}

	public Map<String, String> getWp2AmfColorMap() {
		return wp2AmfColorMap;
	}

	public void setWp2AmfColorMap(Map<String, String> wp2AmfColorMap) {
		this.wp2AmfColorMap = wp2AmfColorMap;
	}

	public String getWp2AmfColorPlaceAll() {
		return wp2AmfColorPlaceAll;
	}

	public void setWp2AmfColorPlaceAll(String wp2AmfColorPlaceAll) {
		this.wp2AmfColorPlaceAll = wp2AmfColorPlaceAll;
	}

	public Map<String, String> getWp2AmfColorPlaceAllMap() {
		return wp2AmfColorPlaceAllMap;
	}

	public void setWp2AmfColorPlaceAllMap(Map<String, String> wp2AmfColorPlaceAllMap) {
		this.wp2AmfColorPlaceAllMap = wp2AmfColorPlaceAllMap;
	}

	

	public Map<String, String> getWp2AmfColorPlaceMap() {
		return wp2AmfColorPlaceMap;
	}

	public void setWp2AmfColorPlaceMap(Map<String, String> wp2AmfColorPlaceMap) {
		this.wp2AmfColorPlaceMap = wp2AmfColorPlaceMap;
	}

	public String getWp2AmfColor1() {
		return wp2AmfColor1;
	}

	public void setWp2AmfColor1(String wp2AmfColor1) {
		this.wp2AmfColor1 = wp2AmfColor1;
	}

	public String getWp2AmfColor2() {
		return wp2AmfColor2;
	}

	public void setWp2AmfColor2(String wp2AmfColor2) {
		this.wp2AmfColor2 = wp2AmfColor2;
	}

	public String getWp2AmfColor3() {
		return wp2AmfColor3;
	}

	public void setWp2AmfColor3(String wp2AmfColor3) {
		this.wp2AmfColor3 = wp2AmfColor3;
	}

	public String getWp2AmfColor4() {
		return wp2AmfColor4;
	}

	public void setWp2AmfColor4(String wp2AmfColor4) {
		this.wp2AmfColor4 = wp2AmfColor4;
	}

	public Map<String, String> getWp2AmfColorsMap() {
		return wp2AmfColorsMap;
	}

	public void setWp2AmfColorsMap(Map<String, String> wp2AmfColorsMap) {
		this.wp2AmfColorsMap = wp2AmfColorsMap;
	}

	public String getWp2BhColor() {
		return wp2BhColor;
	}

	public void setWp2BhColor(String wp2BhColor) {
		this.wp2BhColor = wp2BhColor;
	}

	public Map<String, String> getWp2BhColorMap() {
		return wp2BhColorMap;
	}

	public void setWp2BhColorMap(Map<String, String> wp2BhColorMap) {
		this.wp2BhColorMap = wp2BhColorMap;
	}

	public String getWp2BhColorPlaceAll() {
		return wp2BhColorPlaceAll;
	}

	public void setWp2BhColorPlaceAll(String wp2BhColorPlaceAll) {
		this.wp2BhColorPlaceAll = wp2BhColorPlaceAll;
	}

	public Map<String, String> getWp2BhColorPlaceAllMap() {
		return wp2BhColorPlaceAllMap;
	}

	public void setWp2BhColorPlaceAllMap(Map<String, String> wp2BhColorPlaceAllMap) {
		this.wp2BhColorPlaceAllMap = wp2BhColorPlaceAllMap;
	}

	public Map<String, String> getWp2BhColorPlaceMap() {
		return wp2BhColorPlaceMap;
	}

	public void setWp2BhColorPlaceMap(Map<String, String> wp2BhColorPlaceMap) {
		this.wp2BhColorPlaceMap = wp2BhColorPlaceMap;
	}

	public String getWp2BhColor1() {
		return wp2BhColor1;
	}

	public void setWp2BhColor1(String wp2BhColor1) {
		this.wp2BhColor1 = wp2BhColor1;
	}

	public String getWp2BhColor2() {
		return wp2BhColor2;
	}

	public void setWp2BhColor2(String wp2BhColor2) {
		this.wp2BhColor2 = wp2BhColor2;
	}

	public String getWp2BhColor3() {
		return wp2BhColor3;
	}

	public void setWp2BhColor3(String wp2BhColor3) {
		this.wp2BhColor3 = wp2BhColor3;
	}

	public String getWp2BhColor4() {
		return wp2BhColor4;
	}

	public void setWp2BhColor4(String wp2BhColor4) {
		this.wp2BhColor4 = wp2BhColor4;
	}

	public Map<String, String> getWp2BhColorsMap() {
		return wp2BhColorsMap;
	}

	public void setWp2BhColorsMap(Map<String, String> wp2BhColorsMap) {
		this.wp2BhColorsMap = wp2BhColorsMap;
	}

	public String getWp2ByColor() {
		return wp2ByColor;
	}

	public void setWp2ByColor(String wp2ByColor) {
		this.wp2ByColor = wp2ByColor;
	}

	public Map<String, String> getWp2ByColorMap() {
		return wp2ByColorMap;
	}

	public void setWp2ByColorMap(Map<String, String> wp2ByColorMap) {
		this.wp2ByColorMap = wp2ByColorMap;
	}

	public String getWp2ByColorPlaceAll() {
		return wp2ByColorPlaceAll;
	}

	public void setWp2ByColorPlaceAll(String wp2ByColorPlaceAll) {
		this.wp2ByColorPlaceAll = wp2ByColorPlaceAll;
	}

	public Map<String, String> getWp2ByColorPlaceAllMap() {
		return wp2ByColorPlaceAllMap;
	}

	public void setWp2ByColorPlaceAllMap(Map<String, String> wp2ByColorPlaceAllMap) {
		this.wp2ByColorPlaceAllMap = wp2ByColorPlaceAllMap;
	}

	public Map<String, String> getWp2ByColorPlaceMap() {
		return wp2ByColorPlaceMap;
	}

	public void setWp2ByColorPlaceMap(Map<String, String> wp2ByColorPlaceMap) {
		this.wp2ByColorPlaceMap = wp2ByColorPlaceMap;
	}

	public String getWp2ByColor1() {
		return wp2ByColor1;
	}

	public void setWp2ByColor1(String wp2ByColor1) {
		this.wp2ByColor1 = wp2ByColor1;
	}

	public String getWp2ByColor2() {
		return wp2ByColor2;
	}

	public void setWp2ByColor2(String wp2ByColor2) {
		this.wp2ByColor2 = wp2ByColor2;
	}

	public String getWp2ByColor3() {
		return wp2ByColor3;
	}

	public void setWp2ByColor3(String wp2ByColor3) {
		this.wp2ByColor3 = wp2ByColor3;
	}

	public String getWp2ByColor4() {
		return wp2ByColor4;
	}

	public void setWp2ByColor4(String wp2ByColor4) {
		this.wp2ByColor4 = wp2ByColor4;
	}

	public Map<String, String> getWp2ByColorsMap() {
		return wp2ByColorsMap;
	}

	public void setWp2ByColorsMap(Map<String, String> wp2ByColorsMap) {
		this.wp2ByColorsMap = wp2ByColorsMap;
	}

	public String getWp2Button() {
		return wp2Button;
	}

	public void setWp2Button(String wp2Button) {
		this.wp2Button = wp2Button;
	}

	public Map<String, String> getWp2ButtonMap() {
		return wp2ButtonMap;
	}

	public void setWp2ButtonMap(Map<String, String> wp2ButtonMap) {
		this.wp2ButtonMap = wp2ButtonMap;
	}

	public String getWp2SuspenderBtn() {
		return wp2SuspenderBtn;
	}

	public void setWp2SuspenderBtn(String wp2SuspenderBtn) {
		this.wp2SuspenderBtn = wp2SuspenderBtn;
	}

	public Map<String, String> getWp2SuspenderBtnMap() {
		return wp2SuspenderBtnMap;
	}

	public void setWp2SuspenderBtnMap(Map<String, String> wp2SuspenderBtnMap) {
		this.wp2SuspenderBtnMap = wp2SuspenderBtnMap;
	}

	public String getWp2Eight() {
		return wp2Eight;
	}

	public void setWp2Eight(String wp2Eight) {
		this.wp2Eight = wp2Eight;
	}

	public Map<String, String> getWp2EightMap() {
		return wp2EightMap;
	}

	public void setWp2EightMap(Map<String, String> wp2EightMap) {
		this.wp2EightMap = wp2EightMap;
	}

	public String getWp2Thick() {
		return wp2Thick;
	}

	public void setWp2Thick(String wp2Thick) {
		this.wp2Thick = wp2Thick;
	}

	public Map<String, String> getWp2ThickMap() {
		return wp2ThickMap;
	}

	public void setWp2ThickMap(Map<String, String> wp2ThickMap) {
		this.wp2ThickMap = wp2ThickMap;
	}

	public String getWp2ShapeMemory() {
		return wp2ShapeMemory;
	}

	public void setWp2ShapeMemory(String wp2ShapeMemory) {
		this.wp2ShapeMemory = wp2ShapeMemory;
	}

	public Map<String, String> getWp2ShapeMemoryMap() {
		return wp2ShapeMemoryMap;
	}

	public void setWp2ShapeMemoryMap(Map<String, String> wp2ShapeMemoryMap) {
		this.wp2ShapeMemoryMap = wp2ShapeMemoryMap;
	}

	public String getWp2Blister() {
		return wp2Blister;
	}

	public void setWp2Blister(String wp2Blister) {
		this.wp2Blister = wp2Blister;
	}

	public Map<String, String> getWp2BlisterMap() {
		return wp2BlisterMap;
	}

	public void setWp2BlisterMap(Map<String, String> wp2BlisterMap) {
		this.wp2BlisterMap = wp2BlisterMap;
	}

	public String getWp2PantsModel() {
		return wp2PantsModel;
	}

	public void setWp2PantsModel(String wp2PantsModel) {
		this.wp2PantsModel = wp2PantsModel;
	}

	public Map<String, String> getWp2PantsModelMap() {
		return wp2PantsModelMap;
	}

	public void setWp2PantsModelMap(Map<String, String> wp2PantsModelMap) {
		this.wp2PantsModelMap = wp2PantsModelMap;
	}

	public String getWp2BtnMateStkNo() {
		return wp2BtnMateStkNo;
	}

	public void setWp2BtnMateStkNo(String wp2BtnMateStkNo) {
		this.wp2BtnMateStkNo = wp2BtnMateStkNo;
	}

	public String getWp2BeltLoopPlace1() {
		return wp2BeltLoopPlace1;
	}

	public void setWp2BeltLoopPlace1(String wp2BeltLoopPlace1) {
		this.wp2BeltLoopPlace1 = wp2BeltLoopPlace1;
	}

	public String getWp2BeltLoopPlace2() {
		return wp2BeltLoopPlace2;
	}

	public void setWp2BeltLoopPlace2(String wp2BeltLoopPlace2) {
		this.wp2BeltLoopPlace2 = wp2BeltLoopPlace2;
	}

	public String getWp2BeltLoopPlace3() {
		return wp2BeltLoopPlace3;
	}

	public void setWp2BeltLoopPlace3(String wp2BeltLoopPlace3) {
		this.wp2BeltLoopPlace3 = wp2BeltLoopPlace3;
	}

	public String getWp2BeltLoopPlace4() {
		return wp2BeltLoopPlace4;
	}

	public void setWp2BeltLoopPlace4(String wp2BeltLoopPlace4) {
		this.wp2BeltLoopPlace4 = wp2BeltLoopPlace4;
	}

	public String getWp2BeltLoopPlace5() {
		return wp2BeltLoopPlace5;
	}

	public void setWp2BeltLoopPlace5(String wp2BeltLoopPlace5) {
		this.wp2BeltLoopPlace5 = wp2BeltLoopPlace5;
	}

	public String getWp2BeltLoopPlace6() {
		return wp2BeltLoopPlace6;
	}

	public void setWp2BeltLoopPlace6(String wp2BeltLoopPlace6) {
		this.wp2BeltLoopPlace6 = wp2BeltLoopPlace6;
	}

	public String getWp2BeltLoopPlace7() {
		return wp2BeltLoopPlace7;
	}

	public void setWp2BeltLoopPlace7(String wp2BeltLoopPlace7) {
		this.wp2BeltLoopPlace7 = wp2BeltLoopPlace7;
	}

	public String getWp2StitchModifyPlace1() {
		return wp2StitchModifyPlace1;
	}

	public void setWp2StitchModifyPlace1(String wp2StitchModifyPlace1) {
		this.wp2StitchModifyPlace1 = wp2StitchModifyPlace1;
	}

	public String getWp2StitchModifyPlace2() {
		return wp2StitchModifyPlace2;
	}

	public void setWp2StitchModifyPlace2(String wp2StitchModifyPlace2) {
		this.wp2StitchModifyPlace2 = wp2StitchModifyPlace2;
	}

	public String getWp2StitchModifyPlace3() {
		return wp2StitchModifyPlace3;
	}

	public void setWp2StitchModifyPlace3(String wp2StitchModifyPlace3) {
		this.wp2StitchModifyPlace3 = wp2StitchModifyPlace3;
	}

	public String getWp2StitchModifyPlace4() {
		return wp2StitchModifyPlace4;
	}

	public void setWp2StitchModifyPlace4(String wp2StitchModifyPlace4) {
		this.wp2StitchModifyPlace4 = wp2StitchModifyPlace4;
	}

	public String getWp2DStitchPlace1() {
		return wp2DStitchPlace1;
	}

	public void setWp2DStitchPlace1(String wp2dStitchPlace1) {
		wp2DStitchPlace1 = wp2dStitchPlace1;
	}

	public String getWp2DStitchPlace2() {
		return wp2DStitchPlace2;
	}

	public void setWp2DStitchPlace2(String wp2dStitchPlace2) {
		wp2DStitchPlace2 = wp2dStitchPlace2;
	}

	public String getWp2DStitchPlace3() {
		return wp2DStitchPlace3;
	}

	public void setWp2DStitchPlace3(String wp2dStitchPlace3) {
		wp2DStitchPlace3 = wp2dStitchPlace3;
	}

	public String getWp2BhColorPlace1() {
		return wp2BhColorPlace1;
	}

	public void setWp2BhColorPlace1(String wp2BhColorPlace1) {
		this.wp2BhColorPlace1 = wp2BhColorPlace1;
	}

	public String getWp2BhColorPlace2() {
		return wp2BhColorPlace2;
	}

	public void setWp2BhColorPlace2(String wp2BhColorPlace2) {
		this.wp2BhColorPlace2 = wp2BhColorPlace2;
	}

	public String getWp2BhColorPlace3() {
		return wp2BhColorPlace3;
	}

	public void setWp2BhColorPlace3(String wp2BhColorPlace3) {
		this.wp2BhColorPlace3 = wp2BhColorPlace3;
	}

	public String getWp2BhColorPlace4() {
		return wp2BhColorPlace4;
	}

	public void setWp2BhColorPlace4(String wp2BhColorPlace4) {
		this.wp2BhColorPlace4 = wp2BhColorPlace4;
	}

	public String getWp2ByColorPlace1() {
		return wp2ByColorPlace1;
	}

	public void setWp2ByColorPlace1(String wp2ByColorPlace1) {
		this.wp2ByColorPlace1 = wp2ByColorPlace1;
	}

	public String getWp2ByColorPlace2() {
		return wp2ByColorPlace2;
	}

	public void setWp2ByColorPlace2(String wp2ByColorPlace2) {
		this.wp2ByColorPlace2 = wp2ByColorPlace2;
	}

	public String getWp2ByColorPlace3() {
		return wp2ByColorPlace3;
	}

	public void setWp2ByColorPlace3(String wp2ByColorPlace3) {
		this.wp2ByColorPlace3 = wp2ByColorPlace3;
	}

	public String getWp2ByColorPlace4() {
		return wp2ByColorPlace4;
	}

	public void setWp2ByColorPlace4(String wp2ByColorPlace4) {
		this.wp2ByColorPlace4 = wp2ByColorPlace4;
	}

	public String getWp2AmfColorPlace1() {
		return wp2AmfColorPlace1;
	}

	public void setWp2AmfColorPlace1(String wp2AmfColorPlace1) {
		this.wp2AmfColorPlace1 = wp2AmfColorPlace1;
	}

	public String getWp2AmfColorPlace2() {
		return wp2AmfColorPlace2;
	}

	public void setWp2AmfColorPlace2(String wp2AmfColorPlace2) {
		this.wp2AmfColorPlace2 = wp2AmfColorPlace2;
	}

	public String getWp2AmfColorPlace3() {
		return wp2AmfColorPlace3;
	}

	public void setWp2AmfColorPlace3(String wp2AmfColorPlace3) {
		this.wp2AmfColorPlace3 = wp2AmfColorPlace3;
	}

	public String getWp2AmfColorPlace4() {
		return wp2AmfColorPlace4;
	}

	public void setWp2AmfColorPlace4(String wp2AmfColorPlace4) {
		this.wp2AmfColorPlace4 = wp2AmfColorPlace4;
	}

	public String getWp2BeltLoopPlace() {
		return wp2BeltLoopPlace;
	}

	public void setWp2BeltLoopPlace(String wp2BeltLoopPlace) {
		this.wp2BeltLoopPlace = wp2BeltLoopPlace;
	}

	public String getWp2StitchModifyPlace() {
		return wp2StitchModifyPlace;
	}

	public void setWp2StitchModifyPlace(String wp2StitchModifyPlace) {
		this.wp2StitchModifyPlace = wp2StitchModifyPlace;
	}

	public String getWp2DStitchPlace() {
		return wp2DStitchPlace;
	}

	public void setWp2DStitchPlace(String wp2dStitchPlace) {
		wp2DStitchPlace = wp2dStitchPlace;
	}

	public String getWp2AmfColorPlace() {
		return wp2AmfColorPlace;
	}

	public void setWp2AmfColorPlace(String wp2AmfColorPlace) {
		this.wp2AmfColorPlace = wp2AmfColorPlace;
	}

	public String getWp2BhColorPlace() {
		return wp2BhColorPlace;
	}

	public void setWp2BhColorPlace(String wp2BhColorPlace) {
		this.wp2BhColorPlace = wp2BhColorPlace;
	}

	public String getWp2ByColorPlace() {
		return wp2ByColorPlace;
	}

	public void setWp2ByColorPlace(String wp2ByColorPlace) {
		this.wp2ByColorPlace = wp2ByColorPlace;
	}

	public String getPt2TackRtPrice() {
		return pt2TackRtPrice;
	}

	public void setPt2TackRtPrice(String pt2TackRtPrice) {
		this.pt2TackRtPrice = pt2TackRtPrice;
	}

	public String getPt2KneeinnerTypeRtPrice() {
		return pt2KneeinnerTypeRtPrice;
	}

	public void setPt2KneeinnerTypeRtPrice(String pt2KneeinnerTypeRtPrice) {
		this.pt2KneeinnerTypeRtPrice = pt2KneeinnerTypeRtPrice;
	}

	public String getPt2KneeinnerClothRtPrice() {
		return pt2KneeinnerClothRtPrice;
	}

	public void setPt2KneeinnerClothRtPrice(String pt2KneeinnerClothRtPrice) {
		this.pt2KneeinnerClothRtPrice = pt2KneeinnerClothRtPrice;
	}

	public String getPt2FrtTypeRtPrice() {
		return pt2FrtTypeRtPrice;
	}

	public void setPt2FrtTypeRtPrice(String pt2FrtTypeRtPrice) {
		this.pt2FrtTypeRtPrice = pt2FrtTypeRtPrice;
	}

	public String getPt2PancherinaRtPrice() {
		return pt2PancherinaRtPrice;
	}

	public void setPt2PancherinaRtPrice(String pt2PancherinaRtPrice) {
		this.pt2PancherinaRtPrice = pt2PancherinaRtPrice;
	}

	public String getPt2AdjusterRtPrice() {
		return pt2AdjusterRtPrice;
	}

	public void setPt2AdjusterRtPrice(String pt2AdjusterRtPrice) {
		this.pt2AdjusterRtPrice = pt2AdjusterRtPrice;
	}

	public String getPt2BeltloopRtPrice() {
		return pt2BeltloopRtPrice;
	}

	public void setPt2BeltloopRtPrice(String pt2BeltloopRtPrice) {
		this.pt2BeltloopRtPrice = pt2BeltloopRtPrice;
	}

	public String getPt2PinloopRtPrice() {
		return pt2PinloopRtPrice;
	}

	public void setPt2PinloopRtPrice(String pt2PinloopRtPrice) {
		this.pt2PinloopRtPrice = pt2PinloopRtPrice;
	}

	public String getPt2SidePktRtPrice() {
		return pt2SidePktRtPrice;
	}

	public void setPt2SidePktRtPrice(String pt2SidePktRtPrice) {
		this.pt2SidePktRtPrice = pt2SidePktRtPrice;
	}

	public String getPt2ShinobiPktRtPrice() {
		return pt2ShinobiPktRtPrice;
	}

	public void setPt2ShinobiPktRtPrice(String pt2ShinobiPktRtPrice) {
		this.pt2ShinobiPktRtPrice = pt2ShinobiPktRtPrice;
	}

	public String getPt2CoinPktRtPrice() {
		return pt2CoinPktRtPrice;
	}

	public void setPt2CoinPktRtPrice(String pt2CoinPktRtPrice) {
		this.pt2CoinPktRtPrice = pt2CoinPktRtPrice;
	}

	public String getPt2FlapcoinPktRtPrice() {
		return pt2FlapcoinPktRtPrice;
	}

	public void setPt2FlapcoinPktRtPrice(String pt2FlapcoinPktRtPrice) {
		this.pt2FlapcoinPktRtPrice = pt2FlapcoinPktRtPrice;
	}

	public String getPt2LeftPisPktRtPrice() {
		return pt2LeftPisPktRtPrice;
	}

	public void setPt2LeftPisPktRtPrice(String pt2LeftPisPktRtPrice) {
		this.pt2LeftPisPktRtPrice = pt2LeftPisPktRtPrice;
	}

	public String getPt2RightPisPktRtPrice() {
		return pt2RightPisPktRtPrice;
	}

	public void setPt2RightPisPktRtPrice(String pt2RightPisPktRtPrice) {
		this.pt2RightPisPktRtPrice = pt2RightPisPktRtPrice;
	}

	public String getPt2VCutRtPrice() {
		return pt2VCutRtPrice;
	}

	public void setPt2VCutRtPrice(String pt2vCutRtPrice) {
		pt2VCutRtPrice = pt2vCutRtPrice;
	}

	public String getPt2HemUpRtPrice() {
		return pt2HemUpRtPrice;
	}

	public void setPt2HemUpRtPrice(String pt2HemUpRtPrice) {
		this.pt2HemUpRtPrice = pt2HemUpRtPrice;
	}

	public String getPt2DblWidthRtPrice() {
		return pt2DblWidthRtPrice;
	}

	public void setPt2DblWidthRtPrice(String pt2DblWidthRtPrice) {
		this.pt2DblWidthRtPrice = pt2DblWidthRtPrice;
	}

	public String getPt2AmfStitchRtPrice() {
		return pt2AmfStitchRtPrice;
	}

	public void setPt2AmfStitchRtPrice(String pt2AmfStitchRtPrice) {
		this.pt2AmfStitchRtPrice = pt2AmfStitchRtPrice;
	}

	public String getPt2StitchPlcRtPrice() {
		return pt2StitchPlcRtPrice;
	}

	public void setPt2StitchPlcRtPrice(String pt2StitchPlcRtPrice) {
		this.pt2StitchPlcRtPrice = pt2StitchPlcRtPrice;
	}

	public String getPt2DblstitchPlcRtPrice() {
		return pt2DblstitchPlcRtPrice;
	}

	public void setPt2DblstitchPlcRtPrice(String pt2DblstitchPlcRtPrice) {
		this.pt2DblstitchPlcRtPrice = pt2DblstitchPlcRtPrice;
	}

	public String getPt2AmfColorRtPrice() {
		return pt2AmfColorRtPrice;
	}

	public void setPt2AmfColorRtPrice(String pt2AmfColorRtPrice) {
		this.pt2AmfColorRtPrice = pt2AmfColorRtPrice;
	}

	public String getPt2BtnholeColorRtPrice() {
		return pt2BtnholeColorRtPrice;
	}

	public void setPt2BtnholeColorRtPrice(String pt2BtnholeColorRtPrice) {
		this.pt2BtnholeColorRtPrice = pt2BtnholeColorRtPrice;
	}

	public String getPt2BtnthreadColorRtPrice() {
		return pt2BtnthreadColorRtPrice;
	}

	public void setPt2BtnthreadColorRtPrice(String pt2BtnthreadColorRtPrice) {
		this.pt2BtnthreadColorRtPrice = pt2BtnthreadColorRtPrice;
	}

	public String getPt2BtnMaterialRtPrice() {
		return pt2BtnMaterialRtPrice;
	}

	public void setPt2BtnMaterialRtPrice(String pt2BtnMaterialRtPrice) {
		this.pt2BtnMaterialRtPrice = pt2BtnMaterialRtPrice;
	}

	public String getPt2SuspenderBtnRtPrice() {
		return pt2SuspenderBtnRtPrice;
	}

	public void setPt2SuspenderBtnRtPrice(String pt2SuspenderBtnRtPrice) {
		this.pt2SuspenderBtnRtPrice = pt2SuspenderBtnRtPrice;
	}

	public String getPt2NonSlipRtPrice() {
		return pt2NonSlipRtPrice;
	}

	public void setPt2NonSlipRtPrice(String pt2NonSlipRtPrice) {
		this.pt2NonSlipRtPrice = pt2NonSlipRtPrice;
	}

	public String getPt2ChicSlipRtPrice() {
		return pt2ChicSlipRtPrice;
	}

	public void setPt2ChicSlipRtPrice(String pt2ChicSlipRtPrice) {
		this.pt2ChicSlipRtPrice = pt2ChicSlipRtPrice;
	}

	public String getPt2ShapeMemoryRtPrice() {
		return pt2ShapeMemoryRtPrice;
	}

	public void setPt2ShapeMemoryRtPrice(String pt2ShapeMemoryRtPrice) {
		this.pt2ShapeMemoryRtPrice = pt2ShapeMemoryRtPrice;
	}

	public String getWp2AmfAllColor() {
		return wp2AmfAllColor;
	}

	public void setWp2AmfAllColor(String wp2AmfAllColor) {
		this.wp2AmfAllColor = wp2AmfAllColor;
	}

	public String getWp2BhAllColor() {
		return wp2BhAllColor;
	}

	public void setWp2BhAllColor(String wp2BhAllColor) {
		this.wp2BhAllColor = wp2BhAllColor;
	}

	public String getWp2ByAllColor() {
		return wp2ByAllColor;
	}

	public void setWp2ByAllColor(String wp2ByAllColor) {
		this.wp2ByAllColor = wp2ByAllColor;
	}
    
}
