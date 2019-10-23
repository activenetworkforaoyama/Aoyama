package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.Pt2StItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.Pt2StOpHemUpItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.Pt2StOpKneeBackItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.Pt2StOpStitchItem;


public class CoOptionPants2StandardInfo implements Serializable{
	private static final long serialVersionUID = -4505963757793347479L;
	
	//PANTS（2本目）モデル
	@NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のモデルを入力して下さい。")
	private String op2PantsModel;
	
	private Map<String,String> op2PantsModelMap;
	
	//タック
	@NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のタックを入力して下さい。")
    private String op2Tack;
    
    private Map<String,String> op2TackMap;
    
    //膝裏
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）の膝裏を入力して下さい。")
    private String op2KneeBack;
    
    private Map<String,String> op2KneeBackMap;
    
    //膝裏素材
    @NotBlank(groups = { Pt2StOpKneeBackItem.class }, message = "PANTS（2本目）の膝裏素材を入力して下さい。")
    private String op2KneeBackMate;

    private Map<String,String> op2KneeBackMateMap;
    
    //フロント仕様
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のフロント仕様を入力して下さい。")
  	private String op2FrontSpec;
      
    private Map<String,String> op2FrontSpecMap;
    
    //パンチェリーナ
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のパンチェリーナを入力して下さい。")
    private String op2Pancherina;
    
    private Map<String,String> op2PancherinaMap;
    
    //アジャスター仕様
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のアジャスター仕様を入力して下さい。")
    private String op2Adjuster;
    
    private Map<String,String> op2AdjusterMap;
    
    //ベルトループ
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のベルトループを入力して下さい。")
    private String op2BeltLoop;
    
    private Map<String,String> op2BeltLoopMap;
    
    //ベルトループ箇所 
    private String op2BeltLoopPlace;
    
    private String op2BeltLoopPlace1;
    
    private String op2BeltLoopPlace2;
    
    private String op2BeltLoopPlace3;
    
    private String op2BeltLoopPlace4;
    
    private String op2BeltLoopPlace5;
    
    private String op2BeltLoopPlace6;
    
    private String op2BeltLoopPlace7;
    
    private Map<String,String> op2BeltLoopPlaceMap;
    
    //ピンループ
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のピンループを入力して下さい。")
    private String op2PinLoop;
    
    private Map<String,String> op2PinLoopMap;
    
    //脇ポケット
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）の脇ポケットを入力して下さい。")
    private String op2SidePkt;
    
    private Map<String,String> op2SidePktMap;
    
    //忍びポケット
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）の忍びポケットを入力して下さい。")
    private String op2SinobiPkt;
    
    private Map<String,String> op2SinobiPktMap;
    
    //コインポケット
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のコインポケットを入力して下さい。")
    private String op2CoinPkt;
    
    private Map<String,String> op2CoinPktMap;
    
    //フラップ付コインポケット
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のフラップ付コインポケットを入力して下さい。")
    private String op2FlapCoinPkt;
    
    private Map<String,String> op2FlapCoinPktMap;
    
    //上前ピスポケット
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）の上前ピスポケットを入力して下さい。")
    private String op2PisPktUf;
    
    private Map<String,String> op2PisPktUfMap;
    
    //下前ピスポケット
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）の下前ピスポケットを入力して下さい。")
    private String op2PisPktDf;
    
    private Map<String,String> op2PisPktDfMap;
    
    //Vカット
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のVカットを入力して下さい。")
    private String op2VCut;
    
    private Map<String,String> op2VCutMap;
    
    //裾上げ
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）の裾上げを入力して下さい。")
    private String op2HemUp;
    
    private Map<String,String> op2HemUpMap;
    
    //ダブル幅
    @NotBlank(groups = { Pt2StOpHemUpItem.class }, message = "PANTS（2本目）のダブル幅を入力して下さい。")
    private String op2DoubleWide;
    
    private Map<String,String> op2DoubleWideMap;
    
    //ステッチ種類
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のステッチ種類を入力して下さい。")
    private String op2Stitch;
    
    private Map<String,String> op2StitchMap;
    
    //ステッチ箇所変更
    @NotBlank(groups = { Pt2StOpStitchItem.class }, message = "PANTS（2本目）のステッチ種類を入力して下さい。")
    private String op2StitchModify;
    
    private Map<String,String> op2StitchModifyMap;
    
    //ステッチ箇所変更箇所
    private String op2StitchModifyPlace;
    
    private String op2StitchModifyPlace1;
    
    private String op2StitchModifyPlace2;
    
    private String op2StitchModifyPlace3;
    
    private String op2StitchModifyPlace4;
    
    private Map<String,String> op2StitchModifyPlaceMap;
    
    //ダブルステッチ
    @NotBlank(groups = { Pt2StOpStitchItem.class }, message = "PANTS（2本目）のダブルステッチを入力して下さい。")
    private String op2DStitch;
    
    private Map<String,String> op2DStitchMap;
    
    //ダブルステッチ箇所
    //private String op2DStitchPlace;
    private String op2DStitchPlace;
    
    private String op2DStitchPlace1;

    private String op2DStitchPlace2;
    
    private String op2DStitchPlace3;
    
    private String op2DStitchPlace4;
    
    private Map<String,String> op2DStitchPlaceMap;

	//AMF色指定
    @NotBlank(groups = { Pt2StOpStitchItem.class }, message = "PANTS（2本目）のAMF色指定を入力して下さい。")
    private String op2AmfColor;
    
    private Map<String,String> op2AmfColorMap;
    
    //AMF糸色 
    private String op2AmfColorPlaceAll;
    
    private Map<String,String> op2AmfColorPlaceAllMap;
    
    //AMF色指定箇所
    //private String op2AmfColorPlace;
    private String op2AmfColorPlace;
    
    private String op2AmfColorPlace1;
    
    private String op2AmfColorPlace2;
    
    private String op2AmfColorPlace3;
    
    private String op2AmfColorPlace4;
    
    private Map<String,String> op2AmfColorPlaceMap;
    
    private String op2AmfAllColor;
    //AMF糸色  脇ポケット
    private String op2AmfColor1;
    
    //AMF糸色  サイドシーム
    private String op2AmfColor2;
    
    //AMF糸色  ダーツ
    private String op2AmfColor3;
  
    //AMF糸色  ピスフラップ
    private String op2AmfColor4;
    
    //AMF色 key&value
    private Map<String,String> op2AmfColorsMap;
    
    //ボタンホール色指定
    @NotBlank(groups = { Pt2StOpStitchItem.class }, message = "PANTS（2本目）のボタンホール色指定を入力して下さい。")
    private String op2BhColor;
    
    private Map<String,String> op2BhColorMap;
    
    //ボタンホール色指定糸色
    private String op2BhColorPlaceAll;
    
    private Map<String,String> op2BhColorPlaceAllMap;
    
    //ボタンホール色指定箇所
    private String op2BhColorPlace;
   
    private String op2BhColorPlace1;
    
    private String op2BhColorPlace2;
    
    private String op2BhColorPlace3;
    
    private String op2BhColorPlace4;
    
    private Map<String,String> op2BhColorPlaceMap;
    
    private String op2BhAllColor;
    //ボタンホール色指定糸色  フロント
    private String op2BhColor1;
    
    //ボタンホール色指定糸色  上前ピスポケット
    private String op2BhColor2;
    
    //ボタンホール色指定糸色  下前ピスポケット
    private String op2BhColor3;
  
    //ボタンホール色指定糸色  フラップ付コインポケット
    private String op2BhColor4;
    
    //ボタンホール色指定色 key&value
    private Map<String,String> op2BhColorsMap;
    
    //ボタン付け糸指定
    @NotBlank(groups = { Pt2StOpStitchItem.class }, message = "PANTS（2本目）のボタン付け糸指定を入力して下さい。")
    private String op2ByColor;
    
    private Map<String,String> op2ByColorMap;
    
    //ボタン付け糸指定糸色
    private String op2ByColorPlaceAll;
    
    private Map<String,String> op2ByColorPlaceAllMap;
    
    //ボタン付け糸指定箇所
    //private String op2ByColorPlace;
    private String op2ByColorPlace;
    
    private String op2ByColorPlace1;
    
    private String op2ByColorPlace2;
    
    private String op2ByColorPlace3;
    
    private String op2ByColorPlace4;
    
    private Map<String,String> op2ByColorPlaceMap;
    
    private String op2ByAllColor;
    //ボタン付け糸指定糸色  フロント
    private String op2ByColor1;
    
    //ボタン付け糸指定糸色  上前ピスポケット
    private String op2ByColor2;
    
    //ボタン付け糸指定糸色  下前ピスポケット
    private String op2ByColor3;
  
    //ボタン付け糸指定糸色  フラップ付コインポケット
    private String op2ByColor4;
    
    //ボタン付け糸指定糸色 key&value
    private Map<String,String> op2ByColorsMap;
    
    //釦素材
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）の釦素材を入力して下さい。")
    private String op2Button;
    
    private Map<String,String> op2ButtonMap;
    
    //釦素材品番
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）の釦素材品番を入力して下さい。")
    private String op2BtnMateStkNo;
    
    //サスペンダー釦
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のサスペンダー釦を入力して下さい。")
    private String op2SuspenderBtn;
    
    private Map<String,String> op2SuspenderBtnMap;
    
    //エイト（滑り止め）
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のエイト（滑り止め）を入力して下さい。")
    private String op2Eight;
    
    private Map<String,String> op2EightMap;
    
    //形状記憶
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）の形状記憶を入力して下さい。")
    private String op2ShapeMemory; 
    
    private Map<String,String> op2ShapeMemoryMap;
    
    //靴ずれ
    private String op2Blister;
    
    private Map<String,String> op2BlisterMap;

    //シック（股補強）
    @NotBlank(groups = { Pt2StItem.class }, message = "PANTS（2本目）のシック（股補強）を入力して下さい。")
    private String op2Thick;
    
    private Map<String,String> op2ThickMap;
    
    //品番Map
    private Map<String,String> pants2MateMap;
    
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


	public Map<String, String> getPants2MateMap() {
		return pants2MateMap;
	}

	public void setPants2MateMap(Map<String, String> pants2MateMap) {
		this.pants2MateMap = pants2MateMap;
	}

	public String getOp2Tack() {
		return op2Tack;
	}

	public void setOp2Tack(String op2Tack) {
		this.op2Tack = op2Tack;
	}

	public Map<String, String> getOp2TackMap() {
		return op2TackMap;
	}

	public void setOp2TackMap(Map<String, String> op2TackMap) {
		this.op2TackMap = op2TackMap;
	}

	public String getOp2KneeBack() {
		return op2KneeBack;
	}

	public void setOp2KneeBack(String op2KneeBack) {
		this.op2KneeBack = op2KneeBack;
	}

	public Map<String, String> getOp2KneeBackMap() {
		return op2KneeBackMap;
	}

	public void setOp2KneeBackMap(Map<String, String> op2KneeBackMap) {
		this.op2KneeBackMap = op2KneeBackMap;
	}

	public String getOp2KneeBackMate() {
		return op2KneeBackMate;
	}

	public void setOp2KneeBackMate(String op2KneeBackMate) {
		this.op2KneeBackMate = op2KneeBackMate;
	}

	public Map<String, String> getOp2KneeBackMateMap() {
		return op2KneeBackMateMap;
	}

	public void setOp2KneeBackMateMap(Map<String, String> op2KneeBackMateMap) {
		this.op2KneeBackMateMap = op2KneeBackMateMap;
	}

	public String getOp2FrontSpec() {
		return op2FrontSpec;
	}

	public void setOp2FrontSpec(String op2FrontSpec) {
		this.op2FrontSpec = op2FrontSpec;
	}

	public Map<String, String> getOp2FrontSpecMap() {
		return op2FrontSpecMap;
	}

	public void setOp2FrontSpecMap(Map<String, String> op2FrontSpecMap) {
		this.op2FrontSpecMap = op2FrontSpecMap;
	}

	public String getOp2Pancherina() {
		return op2Pancherina;
	}

	public void setOp2Pancherina(String op2Pancherina) {
		this.op2Pancherina = op2Pancherina;
	}

	public Map<String, String> getOp2PancherinaMap() {
		return op2PancherinaMap;
	}

	public void setOp2PancherinaMap(Map<String, String> op2PancherinaMap) {
		this.op2PancherinaMap = op2PancherinaMap;
	}

	public String getOp2Adjuster() {
		return op2Adjuster;
	}

	public void setOp2Adjuster(String op2Adjuster) {
		this.op2Adjuster = op2Adjuster;
	}

	public Map<String, String> getOp2AdjusterMap() {
		return op2AdjusterMap;
	}

	public void setOp2AdjusterMap(Map<String, String> op2AdjusterMap) {
		this.op2AdjusterMap = op2AdjusterMap;
	}

	public String getOp2BeltLoop() {
		return op2BeltLoop;
	}

	public void setOp2BeltLoop(String op2BeltLoop) {
		this.op2BeltLoop = op2BeltLoop;
	}

	public Map<String, String> getOp2BeltLoopMap() {
		return op2BeltLoopMap;
	}

	public void setOp2BeltLoopMap(Map<String, String> op2BeltLoopMap) {
		this.op2BeltLoopMap = op2BeltLoopMap;
	}

	public Map<String, String> getOp2BeltLoopPlaceMap() {
		return op2BeltLoopPlaceMap;
	}

	public void setOp2BeltLoopPlaceMap(Map<String, String> op2BeltLoopPlaceMap) {
		this.op2BeltLoopPlaceMap = op2BeltLoopPlaceMap;
	}

	public String getOp2PinLoop() {
		return op2PinLoop;
	}

	public void setOp2PinLoop(String op2PinLoop) {
		this.op2PinLoop = op2PinLoop;
	}

	public Map<String, String> getOp2PinLoopMap() {
		return op2PinLoopMap;
	}

	public void setOp2PinLoopMap(Map<String, String> op2PinLoopMap) {
		this.op2PinLoopMap = op2PinLoopMap;
	}

	public String getOp2SidePkt() {
		return op2SidePkt;
	}

	public void setOp2SidePkt(String op2SidePkt) {
		this.op2SidePkt = op2SidePkt;
	}

	public Map<String, String> getOp2SidePktMap() {
		return op2SidePktMap;
	}

	public void setOp2SidePktMap(Map<String, String> op2SidePktMap) {
		this.op2SidePktMap = op2SidePktMap;
	}

	public String getOp2SinobiPkt() {
		return op2SinobiPkt;
	}

	public void setOp2SinobiPkt(String op2SinobiPkt) {
		this.op2SinobiPkt = op2SinobiPkt;
	}

	public Map<String, String> getOp2SinobiPktMap() {
		return op2SinobiPktMap;
	}

	public void setOp2SinobiPktMap(Map<String, String> op2SinobiPktMap) {
		this.op2SinobiPktMap = op2SinobiPktMap;
	}

	public String getOp2CoinPkt() {
		return op2CoinPkt;
	}

	public void setOp2CoinPkt(String op2CoinPkt) {
		this.op2CoinPkt = op2CoinPkt;
	}

	public Map<String, String> getOp2CoinPktMap() {
		return op2CoinPktMap;
	}

	public void setOp2CoinPktMap(Map<String, String> op2CoinPktMap) {
		this.op2CoinPktMap = op2CoinPktMap;
	}

	public String getOp2FlapCoinPkt() {
		return op2FlapCoinPkt;
	}

	public void setOp2FlapCoinPkt(String op2FlapCoinPkt) {
		this.op2FlapCoinPkt = op2FlapCoinPkt;
	}

	public Map<String, String> getOp2FlapCoinPktMap() {
		return op2FlapCoinPktMap;
	}

	public void setOp2FlapCoinPktMap(Map<String, String> op2FlapCoinPktMap) {
		this.op2FlapCoinPktMap = op2FlapCoinPktMap;
	}

	public String getOp2PisPktUf() {
		return op2PisPktUf;
	}

	public void setOp2PisPktUf(String op2PisPktUf) {
		this.op2PisPktUf = op2PisPktUf;
	}

	public Map<String, String> getOp2PisPktUfMap() {
		return op2PisPktUfMap;
	}

	public void setOp2PisPktUfMap(Map<String, String> op2PisPktUfMap) {
		this.op2PisPktUfMap = op2PisPktUfMap;
	}

	public String getOp2PisPktDf() {
		return op2PisPktDf;
	}

	public void setOp2PisPktDf(String op2PisPktDf) {
		this.op2PisPktDf = op2PisPktDf;
	}

	public Map<String, String> getOp2PisPktDfMap() {
		return op2PisPktDfMap;
	}

	public void setOp2PisPktDfMap(Map<String, String> op2PisPktDfMap) {
		this.op2PisPktDfMap = op2PisPktDfMap;
	}

	public String getOp2VCut() {
		return op2VCut;
	}

	public void setOp2VCut(String op2vCut) {
		op2VCut = op2vCut;
	}

	public Map<String, String> getOp2VCutMap() {
		return op2VCutMap;
	}

	public void setOp2VCutMap(Map<String, String> op2vCutMap) {
		op2VCutMap = op2vCutMap;
	}

	public String getOp2HemUp() {
		return op2HemUp;
	}

	public void setOp2HemUp(String op2HemUp) {
		this.op2HemUp = op2HemUp;
	}

	public Map<String, String> getOp2HemUpMap() {
		return op2HemUpMap;
	}

	public void setOp2HemUpMap(Map<String, String> op2HemUpMap) {
		this.op2HemUpMap = op2HemUpMap;
	}

	public String getOp2DoubleWide() {
		return op2DoubleWide;
	}

	public void setOp2DoubleWide(String op2DoubleWide) {
		this.op2DoubleWide = op2DoubleWide;
	}

	public Map<String, String> getOp2DoubleWideMap() {
		return op2DoubleWideMap;
	}

	public void setOp2DoubleWideMap(Map<String, String> op2DoubleWideMap) {
		this.op2DoubleWideMap = op2DoubleWideMap;
	}

	public String getOp2Stitch() {
		return op2Stitch;
	}

	public void setOp2Stitch(String op2Stitch) {
		this.op2Stitch = op2Stitch;
	}

	public Map<String, String> getOp2StitchMap() {
		return op2StitchMap;
	}

	public void setOp2StitchMap(Map<String, String> op2StitchMap) {
		this.op2StitchMap = op2StitchMap;
	}

	public String getOp2StitchModify() {
		return op2StitchModify;
	}

	public void setOp2StitchModify(String op2StitchModify) {
		this.op2StitchModify = op2StitchModify;
	}

	public Map<String, String> getOp2StitchModifyMap() {
		return op2StitchModifyMap;
	}

	public void setOp2StitchModifyMap(Map<String, String> op2StitchModifyMap) {
		this.op2StitchModifyMap = op2StitchModifyMap;
	}

	public Map<String, String> getOp2StitchModifyPlaceMap() {
		return op2StitchModifyPlaceMap;
	}

	public void setOp2StitchModifyPlaceMap(Map<String, String> op2StitchModifyPlaceMap) {
		this.op2StitchModifyPlaceMap = op2StitchModifyPlaceMap;
	}

	public String getOp2DStitch() {
		return op2DStitch;
	}

	public void setOp2DStitch(String op2dStitch) {
		op2DStitch = op2dStitch;
	}

	public Map<String, String> getOp2DStitchMap() {
		return op2DStitchMap;
	}

	public void setOp2DStitchMap(Map<String, String> op2dStitchMap) {
		op2DStitchMap = op2dStitchMap;
	}

	public Map<String, String> getOp2DStitchPlaceMap() {
		return op2DStitchPlaceMap;
	}

	public void setOp2DStitchPlaceMap(Map<String, String> op2dStitchPlaceMap) {
		op2DStitchPlaceMap = op2dStitchPlaceMap;
	}

	public String getOp2AmfColor() {
		return op2AmfColor;
	}

	public void setOp2AmfColor(String op2AmfColor) {
		this.op2AmfColor = op2AmfColor;
	}

	public Map<String, String> getOp2AmfColorMap() {
		return op2AmfColorMap;
	}

	public void setOp2AmfColorMap(Map<String, String> op2AmfColorMap) {
		this.op2AmfColorMap = op2AmfColorMap;
	}

	public String getOp2AmfColorPlaceAll() {
		return op2AmfColorPlaceAll;
	}

	public void setOp2AmfColorPlaceAll(String op2AmfColorPlaceAll) {
		this.op2AmfColorPlaceAll = op2AmfColorPlaceAll;
	}

	public Map<String, String> getOp2AmfColorPlaceAllMap() {
		return op2AmfColorPlaceAllMap;
	}

	public void setOp2AmfColorPlaceAllMap(Map<String, String> op2AmfColorPlaceAllMap) {
		this.op2AmfColorPlaceAllMap = op2AmfColorPlaceAllMap;
	}

	public Map<String, String> getOp2AmfColorPlaceMap() {
		return op2AmfColorPlaceMap;
	}

	public void setOp2AmfColorPlaceMap(Map<String, String> op2AmfColorPlaceMap) {
		this.op2AmfColorPlaceMap = op2AmfColorPlaceMap;
	}

	public String getOp2AmfColor1() {
		return op2AmfColor1;
	}

	public void setOp2AmfColor1(String op2AmfColor1) {
		this.op2AmfColor1 = op2AmfColor1;
	}

	public String getOp2AmfColor2() {
		return op2AmfColor2;
	}

	public void setOp2AmfColor2(String op2AmfColor2) {
		this.op2AmfColor2 = op2AmfColor2;
	}

	public String getOp2AmfColor3() {
		return op2AmfColor3;
	}

	public void setOp2AmfColor3(String op2AmfColor3) {
		this.op2AmfColor3 = op2AmfColor3;
	}

	public String getOp2AmfColor4() {
		return op2AmfColor4;
	}

	public void setOp2AmfColor4(String op2AmfColor4) {
		this.op2AmfColor4 = op2AmfColor4;
	}

	public Map<String, String> getOp2AmfColorsMap() {
		return op2AmfColorsMap;
	}

	public void setOp2AmfColorsMap(Map<String, String> op2AmfColorsMap) {
		this.op2AmfColorsMap = op2AmfColorsMap;
	}

	public String getOp2BhColor() {
		return op2BhColor;
	}

	public void setOp2BhColor(String op2BhColor) {
		this.op2BhColor = op2BhColor;
	}

	public Map<String, String> getOp2BhColorMap() {
		return op2BhColorMap;
	}

	public void setOp2BhColorMap(Map<String, String> op2BhColorMap) {
		this.op2BhColorMap = op2BhColorMap;
	}

	public String getOp2BhColorPlaceAll() {
		return op2BhColorPlaceAll;
	}

	public void setOp2BhColorPlaceAll(String op2BhColorPlaceAll) {
		this.op2BhColorPlaceAll = op2BhColorPlaceAll;
	}

	public Map<String, String> getOp2BhColorPlaceAllMap() {
		return op2BhColorPlaceAllMap;
	}

	public void setOp2BhColorPlaceAllMap(Map<String, String> op2BhColorPlaceAllMap) {
		this.op2BhColorPlaceAllMap = op2BhColorPlaceAllMap;
	}

	public Map<String, String> getOp2BhColorPlaceMap() {
		return op2BhColorPlaceMap;
	}

	public void setOp2BhColorPlaceMap(Map<String, String> op2BhColorPlaceMap) {
		this.op2BhColorPlaceMap = op2BhColorPlaceMap;
	}

	public String getOp2BhColor1() {
		return op2BhColor1;
	}

	public void setOp2BhColor1(String op2BhColor1) {
		this.op2BhColor1 = op2BhColor1;
	}

	public String getOp2BhColor2() {
		return op2BhColor2;
	}

	public void setOp2BhColor2(String op2BhColor2) {
		this.op2BhColor2 = op2BhColor2;
	}

	public String getOp2BhColor3() {
		return op2BhColor3;
	}

	public void setOp2BhColor3(String op2BhColor3) {
		this.op2BhColor3 = op2BhColor3;
	}

	public String getOp2BhColor4() {
		return op2BhColor4;
	}

	public void setOp2BhColor4(String op2BhColor4) {
		this.op2BhColor4 = op2BhColor4;
	}

	public Map<String, String> getOp2BhColorsMap() {
		return op2BhColorsMap;
	}

	public void setOp2BhColorsMap(Map<String, String> op2BhColorsMap) {
		this.op2BhColorsMap = op2BhColorsMap;
	}

	public String getOp2ByColor() {
		return op2ByColor;
	}

	public void setOp2ByColor(String op2ByColor) {
		this.op2ByColor = op2ByColor;
	}

	public Map<String, String> getOp2ByColorMap() {
		return op2ByColorMap;
	}

	public void setOp2ByColorMap(Map<String, String> op2ByColorMap) {
		this.op2ByColorMap = op2ByColorMap;
	}

	public String getOp2ByColorPlaceAll() {
		return op2ByColorPlaceAll;
	}

	public void setOp2ByColorPlaceAll(String op2ByColorPlaceAll) {
		this.op2ByColorPlaceAll = op2ByColorPlaceAll;
	}

	public Map<String, String> getOp2ByColorPlaceAllMap() {
		return op2ByColorPlaceAllMap;
	}

	public void setOp2ByColorPlaceAllMap(Map<String, String> op2ByColorPlaceAllMap) {
		this.op2ByColorPlaceAllMap = op2ByColorPlaceAllMap;
	}

	public Map<String, String> getOp2ByColorPlaceMap() {
		return op2ByColorPlaceMap;
	}

	public void setOp2ByColorPlaceMap(Map<String, String> op2ByColorPlaceMap) {
		this.op2ByColorPlaceMap = op2ByColorPlaceMap;
	}

	public String getOp2ByColor1() {
		return op2ByColor1;
	}

	public void setOp2ByColor1(String op2ByColor1) {
		this.op2ByColor1 = op2ByColor1;
	}

	public String getOp2ByColor2() {
		return op2ByColor2;
	}

	public void setOp2ByColor2(String op2ByColor2) {
		this.op2ByColor2 = op2ByColor2;
	}

	public String getOp2ByColor3() {
		return op2ByColor3;
	}

	public void setOp2ByColor3(String op2ByColor3) {
		this.op2ByColor3 = op2ByColor3;
	}

	public String getOp2ByColor4() {
		return op2ByColor4;
	}

	public void setOp2ByColor4(String op2ByColor4) {
		this.op2ByColor4 = op2ByColor4;
	}

	public Map<String, String> getOp2ByColorsMap() {
		return op2ByColorsMap;
	}

	public void setOp2ByColorsMap(Map<String, String> op2ByColorsMap) {
		this.op2ByColorsMap = op2ByColorsMap;
	}

	public String getOp2Button() {
		return op2Button;
	}

	public void setOp2Button(String op2Button) {
		this.op2Button = op2Button;
	}

	public Map<String, String> getOp2ButtonMap() {
		return op2ButtonMap;
	}

	public void setOp2ButtonMap(Map<String, String> op2ButtonMap) {
		this.op2ButtonMap = op2ButtonMap;
	}

	public String getOp2SuspenderBtn() {
		return op2SuspenderBtn;
	}

	public void setOp2SuspenderBtn(String op2SuspenderBtn) {
		this.op2SuspenderBtn = op2SuspenderBtn;
	}

	public Map<String, String> getOp2SuspenderBtnMap() {
		return op2SuspenderBtnMap;
	}

	public void setOp2SuspenderBtnMap(Map<String, String> op2SuspenderBtnMap) {
		this.op2SuspenderBtnMap = op2SuspenderBtnMap;
	}

	public String getOp2Eight() {
		return op2Eight;
	}

	public void setOp2Eight(String op2Eight) {
		this.op2Eight = op2Eight;
	}

	public Map<String, String> getOp2EightMap() {
		return op2EightMap;
	}

	public void setOp2EightMap(Map<String, String> op2EightMap) {
		this.op2EightMap = op2EightMap;
	}

	public String getOp2ShapeMemory() {
		return op2ShapeMemory;
	}

	public void setOp2ShapeMemory(String op2ShapeMemory) {
		this.op2ShapeMemory = op2ShapeMemory;
	}

	public Map<String, String> getOp2ShapeMemoryMap() {
		return op2ShapeMemoryMap;
	}

	public void setOp2ShapeMemoryMap(Map<String, String> op2ShapeMemoryMap) {
		this.op2ShapeMemoryMap = op2ShapeMemoryMap;
	}

	public String getOp2Blister() {
		return op2Blister;
	}

	public void setOp2Blister(String op2Blister) {
		this.op2Blister = op2Blister;
	}

	public Map<String, String> getOp2BlisterMap() {
		return op2BlisterMap;
	}

	public void setOp2BlisterMap(Map<String, String> op2BlisterMap) {
		this.op2BlisterMap = op2BlisterMap;
	}

	public String getOp2Thick() {
		return op2Thick;
	}

	public void setOp2Thick(String op2Thick) {
		this.op2Thick = op2Thick;
	}

	public Map<String, String> getOp2ThickMap() {
		return op2ThickMap;
	}

	public void setOp2ThickMap(Map<String, String> op2ThickMap) {
		this.op2ThickMap = op2ThickMap;
	}

	public String getOp2PantsModel() {
		return op2PantsModel;
	}

	public void setOp2PantsModel(String op2PantsModel) {
		this.op2PantsModel = op2PantsModel;
	}

	public Map<String, String> getOp2PantsModelMap() {
		return op2PantsModelMap;
	}

	public void setOp2PantsModelMap(Map<String, String> op2PantsModelMap) {
		this.op2PantsModelMap = op2PantsModelMap;
	}

	public String getOp2BtnMateStkNo() {
		return op2BtnMateStkNo;
	}

	public void setOp2BtnMateStkNo(String op2BtnMateStkNo) {
		this.op2BtnMateStkNo = op2BtnMateStkNo;
	}

	public String getOp2BeltLoopPlace1() {
		return op2BeltLoopPlace1;
	}

	public void setOp2BeltLoopPlace1(String op2BeltLoopPlace1) {
		this.op2BeltLoopPlace1 = op2BeltLoopPlace1;
	}

	public String getOp2BeltLoopPlace2() {
		return op2BeltLoopPlace2;
	}

	public void setOp2BeltLoopPlace2(String op2BeltLoopPlace2) {
		this.op2BeltLoopPlace2 = op2BeltLoopPlace2;
	}

	public String getOp2BeltLoopPlace3() {
		return op2BeltLoopPlace3;
	}

	public void setOp2BeltLoopPlace3(String op2BeltLoopPlace3) {
		this.op2BeltLoopPlace3 = op2BeltLoopPlace3;
	}

	public String getOp2BeltLoopPlace4() {
		return op2BeltLoopPlace4;
	}

	public void setOp2BeltLoopPlace4(String op2BeltLoopPlace4) {
		this.op2BeltLoopPlace4 = op2BeltLoopPlace4;
	}

	public String getOp2BeltLoopPlace5() {
		return op2BeltLoopPlace5;
	}

	public void setOp2BeltLoopPlace5(String op2BeltLoopPlace5) {
		this.op2BeltLoopPlace5 = op2BeltLoopPlace5;
	}

	public String getOp2BeltLoopPlace6() {
		return op2BeltLoopPlace6;
	}

	public void setOp2BeltLoopPlace6(String op2BeltLoopPlace6) {
		this.op2BeltLoopPlace6 = op2BeltLoopPlace6;
	}

	public String getOp2BeltLoopPlace7() {
		return op2BeltLoopPlace7;
	}

	public void setOp2BeltLoopPlace7(String op2BeltLoopPlace7) {
		this.op2BeltLoopPlace7 = op2BeltLoopPlace7;
	}

	public String getOp2StitchModifyPlace1() {
		return op2StitchModifyPlace1;
	}

	public void setOp2StitchModifyPlace1(String op2StitchModifyPlace1) {
		this.op2StitchModifyPlace1 = op2StitchModifyPlace1;
	}

	public String getOp2StitchModifyPlace2() {
		return op2StitchModifyPlace2;
	}

	public void setOp2StitchModifyPlace2(String op2StitchModifyPlace2) {
		this.op2StitchModifyPlace2 = op2StitchModifyPlace2;
	}

	public String getOp2StitchModifyPlace3() {
		return op2StitchModifyPlace3;
	}

	public void setOp2StitchModifyPlace3(String op2StitchModifyPlace3) {
		this.op2StitchModifyPlace3 = op2StitchModifyPlace3;
	}

	public String getOp2StitchModifyPlace4() {
		return op2StitchModifyPlace4;
	}

	public void setOp2StitchModifyPlace4(String op2StitchModifyPlace4) {
		this.op2StitchModifyPlace4 = op2StitchModifyPlace4;
	}

	public String getOp2DStitchPlace1() {
		return op2DStitchPlace1;
	}

	public void setOp2DStitchPlace1(String op2dStitchPlace1) {
		op2DStitchPlace1 = op2dStitchPlace1;
	}

	public String getOp2DStitchPlace2() {
		return op2DStitchPlace2;
	}

	public void setOp2DStitchPlace2(String op2dStitchPlace2) {
		op2DStitchPlace2 = op2dStitchPlace2;
	}

	public String getOp2DStitchPlace3() {
		return op2DStitchPlace3;
	}

	public void setOp2DStitchPlace3(String op2dStitchPlace3) {
		op2DStitchPlace3 = op2dStitchPlace3;
	}

	public String getOp2DStitchPlace4() {
		return op2DStitchPlace4;
	}

	public void setOp2DStitchPlace4(String op2dStitchPlace4) {
		op2DStitchPlace4 = op2dStitchPlace4;
	}

	public String getOp2AmfColorPlace1() {
		return op2AmfColorPlace1;
	}

	public void setOp2AmfColorPlace1(String op2AmfColorPlace1) {
		this.op2AmfColorPlace1 = op2AmfColorPlace1;
	}

	public String getOp2AmfColorPlace2() {
		return op2AmfColorPlace2;
	}

	public void setOp2AmfColorPlace2(String op2AmfColorPlace2) {
		this.op2AmfColorPlace2 = op2AmfColorPlace2;
	}

	public String getOp2AmfColorPlace3() {
		return op2AmfColorPlace3;
	}

	public void setOp2AmfColorPlace3(String op2AmfColorPlace3) {
		this.op2AmfColorPlace3 = op2AmfColorPlace3;
	}

	public String getOp2AmfColorPlace4() {
		return op2AmfColorPlace4;
	}

	public void setOp2AmfColorPlace4(String op2AmfColorPlace4) {
		this.op2AmfColorPlace4 = op2AmfColorPlace4;
	}

	public String getOp2BhColorPlace1() {
		return op2BhColorPlace1;
	}

	public void setOp2BhColorPlace1(String op2BhColorPlace1) {
		this.op2BhColorPlace1 = op2BhColorPlace1;
	}

	public String getOp2BhColorPlace2() {
		return op2BhColorPlace2;
	}

	public void setOp2BhColorPlace2(String op2BhColorPlace2) {
		this.op2BhColorPlace2 = op2BhColorPlace2;
	}

	public String getOp2BhColorPlace3() {
		return op2BhColorPlace3;
	}

	public void setOp2BhColorPlace3(String op2BhColorPlace3) {
		this.op2BhColorPlace3 = op2BhColorPlace3;
	}

	public String getOp2BhColorPlace4() {
		return op2BhColorPlace4;
	}

	public void setOp2BhColorPlace4(String op2BhColorPlace4) {
		this.op2BhColorPlace4 = op2BhColorPlace4;
	}

	public String getOp2ByColorPlace1() {
		return op2ByColorPlace1;
	}

	public void setOp2ByColorPlace1(String op2ByColorPlace1) {
		this.op2ByColorPlace1 = op2ByColorPlace1;
	}

	public String getOp2ByColorPlace2() {
		return op2ByColorPlace2;
	}

	public void setOp2ByColorPlace2(String op2ByColorPlace2) {
		this.op2ByColorPlace2 = op2ByColorPlace2;
	}

	public String getOp2ByColorPlace3() {
		return op2ByColorPlace3;
	}

	public void setOp2ByColorPlace3(String op2ByColorPlace3) {
		this.op2ByColorPlace3 = op2ByColorPlace3;
	}

	public String getOp2ByColorPlace4() {
		return op2ByColorPlace4;
	}

	public void setOp2ByColorPlace4(String op2ByColorPlace4) {
		this.op2ByColorPlace4 = op2ByColorPlace4;
	}

	public String getOp2BeltLoopPlace() {
		return op2BeltLoopPlace;
	}

	public void setOp2BeltLoopPlace(String op2BeltLoopPlace) {
		this.op2BeltLoopPlace = op2BeltLoopPlace;
	}

	public String getOp2StitchModifyPlace() {
		return op2StitchModifyPlace;
	}

	public void setOp2StitchModifyPlace(String op2StitchModifyPlace) {
		this.op2StitchModifyPlace = op2StitchModifyPlace;
	}

	public String getOp2DStitchPlace() {
		return op2DStitchPlace;
	}

	public void setOp2DStitchPlace(String op2dStitchPlace) {
		op2DStitchPlace = op2dStitchPlace;
	}

	public String getOp2AmfColorPlace() {
		return op2AmfColorPlace;
	}

	public void setOp2AmfColorPlace(String op2AmfColorPlace) {
		this.op2AmfColorPlace = op2AmfColorPlace;
	}

	public String getOp2BhColorPlace() {
		return op2BhColorPlace;
	}

	public void setOp2BhColorPlace(String op2BhColorPlace) {
		this.op2BhColorPlace = op2BhColorPlace;
	}

	public String getOp2ByColorPlace() {
		return op2ByColorPlace;
	}

	public void setOp2ByColorPlace(String op2ByColorPlace) {
		this.op2ByColorPlace = op2ByColorPlace;
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

	public String getOp2AmfAllColor() {
		return op2AmfAllColor;
	}

	public void setOp2AmfAllColor(String op2AmfAllColor) {
		this.op2AmfAllColor = op2AmfAllColor;
	}

	public String getOp2BhAllColor() {
		return op2BhAllColor;
	}

	public void setOp2BhAllColor(String op2BhAllColor) {
		this.op2BhAllColor = op2BhAllColor;
	}

	public String getOp2ByAllColor() {
		return op2ByAllColor;
	}

	public void setOp2ByAllColor(String op2ByAllColor) {
		this.op2ByAllColor = op2ByAllColor;
	}

	
    
}
    
