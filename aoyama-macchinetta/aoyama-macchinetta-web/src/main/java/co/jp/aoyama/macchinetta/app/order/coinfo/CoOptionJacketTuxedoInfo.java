package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

public class CoOptionJacketTuxedoInfo implements Serializable{
	private static final long serialVersionUID = -7241990558389021265L;
	
	//JACKETモデル
	private String tjJacketModel;
	
	private Map<String,String> tjJacketModelMap;

	//フロント釦数
    private String tjFrontBtnCnt;
    
    private Map<String,String> tjFrontBtnCntMap;
    
    private String jkFrtBtnRtPrice;
    
    //ラペルデザイン
    private String tjLapelDesign;
    
    private Map<String,String> tjLapelDesignMap;
    
    private String jkLapelDesignRtPrice;
    
    //ラペルモデル
    private String tjJacketLapelModel;
    
    //グレード
    private String tjGrade;

    private Map<String,String> tjGradeMap;
    
    private String jkGradeRtPrice;
    
    //裏仕様
  	private String tjBackSpec;
      
    private Map<String,String> tjBackSpecMap;
    
    private String jkInnerClothRtPrice;
    
    //台場
    private String tjFort;
    
    private Map<String,String> tjFortMap;
    
    private String jkDaibaRtPrice;
    
    //拝見地
    private String tjGlossFablic;
    
    private Map<String,String> tjGlossFablicMap;
    
    private String jkLookClothRtPrice;
    
    //襟裏（ヒゲ）
    private String tjBackCollar;
    
    private Map<String,String> tjBackCollarMap;
    
    private String jkCollarInnerRtPrice;
    
    //襟吊
    private String tjChainHange;
    
    private Map<String,String> tjChainHangeMap;
    
    private String jkCollarHangRtPrice;
    
    //ラペル幅
    private String tjLapelWidth;
    
    private Map<String,String> tjLapelWidthMap;
    
    private String jkLapelWidthRtPrice;
    
    //フラワーホール
    private String tjFlowerHole;
    
    private Map<String,String> tjFlowerHoleMap;
    
    private String jkFlowerHoleRtPrice;
    
    //胸ポケット
    private String tjBreastPkt;
    
    private Map<String,String> tjBreastPktMap;
    
    private String jkBreastPktRtPrice;
    
    //腰ポケット
    private String tjWaistPkt;
    
    private Map<String,String> tjWaistPktMap;
    
    private String jkWaistPktRtPrice;
    
    //チェンジポケット
    private String tjChangePkt;
    
    private Map<String,String> tjChangePktMap;
    
    private String jkChgPktRtPrice;
    
    //スランテッドポケット
    private String tjSlantedPkt;
    
    private Map<String,String> tjSlantedPktMap;

    private String jkSlantedPktRtPrice;
    
    //忍びポケット
    private String tjCoinPkt;
    
    private Map<String,String> tjCoinPktMap;
    
    private String jkShinobiPktRtPrice;
    
    //袖仕様
    private String tjSleeveSpec;
    
    private Map<String,String> tjSleeveSpecMap;
    
    private String jkSleeveTypeRtPrice;
    
    //マニカ
    private String tjManica;
    
    private Map<String,String> tjManicaMap;
    
    private String jkManicaRtPrice;
    
    //袖釦
    private String tjSleeveBtnType;
    
    private Map<String,String> tjSleeveBtnTypeMap;
    
    private String jkSleeveBtnRtPrice;
    
    //袖釦数
    private String tjSleeveBtnCnt;
    
    //袖口
    private String tjCuffSpec;
    
    private Map<String,String> tjCuffSpecMap;
    
    private String jkCuffRtPrice;
    
    //内ポケット変更
    private String tjInsidePktChange;
    
    private Map<String,String> tjInsidePktChangeMap;
    
    private String jkInnerPktRtPrice;
    
    //下前胸内ポケット仕様
    private String tjBreastInnerPkt;
    
    private Map<String,String> tjBreastInnerPktMap;

    private String jkRightInnerPktTypeRtPrice;
    
    //ステッチ種類
    private String tjStitch;
    
    private Map<String,String> tjStitchMap;
    
    private String jkStitchTypeRtPrice;
    
    //ステッチ箇所変更
    private String tjStitchModify = "0002401";
    
    private String jkStitchPlcRtPrice;
    
    //ダブルステッチ変更
    private String tjDStitchModify = "0002601";
    
    private String jkDblstitchPlcRtPrice;
    
    //AMF色指定
    private String tjAmfColor = "0002801";
    
    private String jkAmfColorRtPrice;
    
    //ボタンホール色指定
    private String tjBhColor;
    
    private Map<String,String> tjBhColorMap;
    
    private String jkBtnholePlcColorRtPrice;
    
    //ボタンホール色指定糸色,ボタンホール色指定糸色(プルダウン)
    private String tjBhColorPlaceAll;
    
    private Map<String,String> tjBhColorPlaceAllMap;
    
    private String tjBhColorPlace;
    
    //ボタンホール色指定箇所
    private String tjBhColorPlace1;
    
    private String tjBhColorPlace2;
    
    private String tjBhColorPlace3;
    
    private String tjBhColorPlace4;
    
    private String tjBhColorPlace5;
    
    private String tjBhColorPlace6;
    
    private String tjBhColorPlace7;
    
    private String tjBhColorPlace8;
    
    private String tjBhColorPlace9;
    
    private String tjBhColorPlace10;
    
    private String tjBhColorPlace11;
    
    private String tjBhColorPlace12;
    
    private String tjBhColorPlace13;
    
    private String tjBhColorPlace14;
    
    private String tjBhColorPlace15;
    
    private String tjBhColorPlace16;
    
    private String tjBhColorPlace17;
    
    private Map<String,String> tjBhColorPlaceMap;
    
    private String tjAllBhColor;
    
    //ボタンホール色指定糸色  フラワーホール上前1
    private String tjBhColor1;
    
    //ボタンホール色指定糸色  フラワーホール上前2
    private String tjBhColor2;
    
    //ボタンホール色指定糸色 フラワーホール下前1
    private String tjBhColor3;
  
    //ボタンホール色指定糸色  フラワーホール下前2
    private String tjBhColor4;
    
    //ボタンホール色指定糸色  フロント１
    private String tjBhColor5;
    
    //ボタンホール色指定糸色  フロント２
    private String tjBhColor6;
    
    //ボタンホール色指定糸色  フロント３
    private String tjBhColor7;
  
    //ボタンホール色指定糸色  上前袖口１
    private String tjBhColor8;
    
    //ボタンホール色指定糸色  上前袖口２
    private String tjBhColor9;
    
    //ボタンホール色指定糸色  上前袖口３
    private String tjBhColor10;
    
    //ボタンホール色指定糸色  上前袖口４
    private String tjBhColor11;
  
    //ボタンホール色指定糸色  上前袖口５
    private String tjBhColor12;
    
    //ボタンホール色指定糸色  下前袖口１
    private String tjBhColor13;
    
    //ボタンホール色指定糸色  下前袖口２
    private String tjBhColor14;
    
    //ボタンホール色指定糸色  下前袖口３
    private String tjBhColor15;
    
    //ボタンホール色指定糸色  下前袖口４
    private String tjBhColor16;
  
    //ボタンホール色指定糸色  下前袖口５
    private String tjBhColor17;
    
    //ボタンホール色指定色 key&value
    private Map<String,String> tjBhColorsMap;
    
    //ボタン付け糸指定
    private String tjByColor;
    
    private Map<String,String> tjByColorMap;
    
    private String jkBtnthreadPlcColorRtPrice;
    
    //ボタン付け糸指定糸色,ボタン付け糸指定糸色(プルダウン)
    private String tjByColorPlaceAll;
    
    private Map<String,String> tjByColorPlaceAllMap;
    
    //ボタン付け糸指定箇所
    private String tjByColorPlace;
    
    private String tjByColorPlace1;
    
    private String tjByColorPlace2;
    
    private String tjByColorPlace3;
    
    private String tjByColorPlace4;
    
    private String tjByColorPlace5;
    
    private String tjByColorPlace6;
    
    private String tjByColorPlace7;
    
    private String tjByColorPlace8;
    
    private String tjByColorPlace9;
    
    private String tjByColorPlace10;
    
    private String tjByColorPlace11;
    
    private String tjByColorPlace12;
    
    private String tjByColorPlace13;
    
    private String tjByColorPlace14;
    
    private String tjByColorPlace15;
    
    private String tjByColorPlace16;
    
    private String tjByColorPlace17;
    
    private Map<String,String> tjByColorPlaceMap;
    
    private String tjAllByColor;
    
    //ボタン付け糸指定糸色   フロント下前1
    private String tjByColor1;
    
    //ボタン付け糸指定糸色 フロント下前2
    private String tjByColor2;
    
    //ボタン付け糸指定糸色  フロント下前3
    private String tjByColor3;
  
    //ボタン付け糸指定糸色   フロント上前1
    private String tjByColor4;
    
    //ボタン付け糸指定糸色   フロント上前2
    private String tjByColor5;
    
    //ボタン付け糸指定糸色   フロント上前3
    private String tjByColor6;
    
    //ボタン付け糸指定糸色   上前袖口１
    private String tjByColor7;
    
    //ボタン付け糸指定糸色  上前袖口２
    private String tjByColor8;
    
    //ボタン付け糸指定糸色   上前袖口３
    private String tjByColor9;
    
    //ボタン付け糸指定糸色   上前袖口４
    private String tjByColor10;
  
    //ボタン付け糸指定糸色   上前袖口５
    private String tjByColor11;
    
    //ボタン付け糸指定糸色   下前袖口１
    private String tjByColor12;
    
    //ボタン付け糸指定糸色   下前袖口２
    private String tjByColor13;
    
    //ボタン付け糸指定糸色   下前袖口３
    private String tjByColor14;
    
    //ボタン付け糸指定糸色   下前袖口４
    private String tjByColor15;
  
    //ボタン付け糸指定糸色   下前袖口５
    private String tjByColor16;
    
    //ボタン付け糸指定糸色 key&value
    private Map<String,String> tjByColorsMap;
    
    //ベント
    private String tjVentSpec;
    
    private Map<String,String> tjVentSpecMap;
    
    private String jkVentRtPrice;
    
    //胴裏素材
    private String tjBodyBackMate;
    
    private Map<String,String> tjBodyBackMateMap;
    
    private String jkInnerBodyClothRtPrice;
    
    //胴裏素材品番
    private String tjBodyBackMateStkNo;
    
    //袖裏素材
    private String tjCuffBackMate;
    
    private Map<String,String> tjCuffBackMateMap;
    
    private String jkInnerSleeveClothRtPrice;
    
    //袖裏素材品番
    private String tjCuffBackMateStkNo;
    
    //釦素材
    private String tjBtnMate;
    
    private Map<String,String> tjBtnMateMap;
    
    private String jkBtnMaterialRtPrice;
    
    //釦素材品番
    private String tjBtnMateStkNo;
    
    //形状記憶
    private String tjShapeMemory; 
    
    private Map<String,String> tjShapeMemoryMap;
    
    private String jkShapeMemoryRtPrice;

	public String getTjFrontBtnCnt() {
		return tjFrontBtnCnt;
	}

	public void setTjFrontBtnCnt(String tjFrontBtnCnt) {
		this.tjFrontBtnCnt = tjFrontBtnCnt;
	}

	public Map<String, String> getTjFrontBtnCntMap() {
		return tjFrontBtnCntMap;
	}

	public void setTjFrontBtnCntMap(Map<String, String> tjFrontBtnCntMap) {
		this.tjFrontBtnCntMap = tjFrontBtnCntMap;
	}

	public String getTjLapelDesign() {
		return tjLapelDesign;
	}

	public void setTjLapelDesign(String tjLapelDesign) {
		this.tjLapelDesign = tjLapelDesign;
	}

	public Map<String, String> getTjLapelDesignMap() {
		return tjLapelDesignMap;
	}

	public void setTjLapelDesignMap(Map<String, String> tjLapelDesignMap) {
		this.tjLapelDesignMap = tjLapelDesignMap;
	}

	public String getTjGrade() {
		return tjGrade;
	}

	public void setTjGrade(String tjGrade) {
		this.tjGrade = tjGrade;
	}

	public Map<String, String> getTjGradeMap() {
		return tjGradeMap;
	}

	public void setTjGradeMap(Map<String, String> tjGradeMap) {
		this.tjGradeMap = tjGradeMap;
	}

	public String getTjBackSpec() {
		return tjBackSpec;
	}

	public void setTjBackSpec(String tjBackSpec) {
		this.tjBackSpec = tjBackSpec;
	}

	public Map<String, String> getTjBackSpecMap() {
		return tjBackSpecMap;
	}

	public void setTjBackSpecMap(Map<String, String> tjBackSpecMap) {
		this.tjBackSpecMap = tjBackSpecMap;
	}

	public String getTjFort() {
		return tjFort;
	}

	public void setTjFort(String tjFort) {
		this.tjFort = tjFort;
	}

	public Map<String, String> getTjFortMap() {
		return tjFortMap;
	}

	public void setTjFortMap(Map<String, String> tjFortMap) {
		this.tjFortMap = tjFortMap;
	}

	public String getTjGlossFablic() {
		return tjGlossFablic;
	}

	public void setTjGlossFablic(String tjGlossFablic) {
		this.tjGlossFablic = tjGlossFablic;
	}

	public Map<String, String> getTjGlossFablicMap() {
		return tjGlossFablicMap;
	}

	public void setTjGlossFablicMap(Map<String, String> tjGlossFablicMap) {
		this.tjGlossFablicMap = tjGlossFablicMap;
	}

	public String getTjBackCollar() {
		return tjBackCollar;
	}

	public void setTjBackCollar(String tjBackCollar) {
		this.tjBackCollar = tjBackCollar;
	}

	public Map<String, String> getTjBackCollarMap() {
		return tjBackCollarMap;
	}

	public void setTjBackCollarMap(Map<String, String> tjBackCollarMap) {
		this.tjBackCollarMap = tjBackCollarMap;
	}

	public String getTjChainHange() {
		return tjChainHange;
	}

	public void setTjChainHange(String tjChainHange) {
		this.tjChainHange = tjChainHange;
	}

	public Map<String, String> getTjChainHangeMap() {
		return tjChainHangeMap;
	}

	public void setTjChainHangeMap(Map<String, String> tjChainHangeMap) {
		this.tjChainHangeMap = tjChainHangeMap;
	}

	public String getTjLapelWidth() {
		return tjLapelWidth;
	}

	public void setTjLapelWidth(String tjLapelWidth) {
		this.tjLapelWidth = tjLapelWidth;
	}

	public Map<String, String> getTjLapelWidthMap() {
		return tjLapelWidthMap;
	}

	public void setTjLapelWidthMap(Map<String, String> tjLapelWidthMap) {
		this.tjLapelWidthMap = tjLapelWidthMap;
	}

	public String getTjFlowerHole() {
		return tjFlowerHole;
	}

	public void setTjFlowerHole(String tjFlowerHole) {
		this.tjFlowerHole = tjFlowerHole;
	}

	public Map<String, String> getTjFlowerHoleMap() {
		return tjFlowerHoleMap;
	}

	public void setTjFlowerHoleMap(Map<String, String> tjFlowerHoleMap) {
		this.tjFlowerHoleMap = tjFlowerHoleMap;
	}

	public String getTjBreastPkt() {
		return tjBreastPkt;
	}

	public void setTjBreastPkt(String tjBreastPkt) {
		this.tjBreastPkt = tjBreastPkt;
	}

	public Map<String, String> getTjBreastPktMap() {
		return tjBreastPktMap;
	}

	public void setTjBreastPktMap(Map<String, String> tjBreastPktMap) {
		this.tjBreastPktMap = tjBreastPktMap;
	}

	public String getTjWaistPkt() {
		return tjWaistPkt;
	}

	public void setTjWaistPkt(String tjWaistPkt) {
		this.tjWaistPkt = tjWaistPkt;
	}

	public Map<String, String> getTjWaistPktMap() {
		return tjWaistPktMap;
	}

	public void setTjWaistPktMap(Map<String, String> tjWaistPktMap) {
		this.tjWaistPktMap = tjWaistPktMap;
	}

	public String getTjChangePkt() {
		return tjChangePkt;
	}

	public void setTjChangePkt(String tjChangePkt) {
		this.tjChangePkt = tjChangePkt;
	}

	public Map<String, String> getTjChangePktMap() {
		return tjChangePktMap;
	}

	public void setTjChangePktMap(Map<String, String> tjChangePktMap) {
		this.tjChangePktMap = tjChangePktMap;
	}

	public String getTjSlantedPkt() {
		return tjSlantedPkt;
	}

	public void setTjSlantedPkt(String tjSlantedPkt) {
		this.tjSlantedPkt = tjSlantedPkt;
	}

	public Map<String, String> getTjSlantedPktMap() {
		return tjSlantedPktMap;
	}

	public void setTjSlantedPktMap(Map<String, String> tjSlantedPktMap) {
		this.tjSlantedPktMap = tjSlantedPktMap;
	}

	public String getTjCoinPkt() {
		return tjCoinPkt;
	}

	public void setTjCoinPkt(String tjCoinPkt) {
		this.tjCoinPkt = tjCoinPkt;
	}

	public Map<String, String> getTjCoinPktMap() {
		return tjCoinPktMap;
	}

	public void setTjCoinPktMap(Map<String, String> tjCoinPktMap) {
		this.tjCoinPktMap = tjCoinPktMap;
	}

	public String getTjSleeveSpec() {
		return tjSleeveSpec;
	}

	public void setTjSleeveSpec(String tjSleeveSpec) {
		this.tjSleeveSpec = tjSleeveSpec;
	}

	public Map<String, String> getTjSleeveSpecMap() {
		return tjSleeveSpecMap;
	}

	public void setTjSleeveSpecMap(Map<String, String> tjSleeveSpecMap) {
		this.tjSleeveSpecMap = tjSleeveSpecMap;
	}

	public String getTjManica() {
		return tjManica;
	}

	public void setTjManica(String tjManica) {
		this.tjManica = tjManica;
	}

	public Map<String, String> getTjManicaMap() {
		return tjManicaMap;
	}

	public void setTjManicaMap(Map<String, String> tjManicaMap) {
		this.tjManicaMap = tjManicaMap;
	}

	public String getTjSleeveBtnType() {
		return tjSleeveBtnType;
	}

	public void setTjSleeveBtnType(String tjSleeveBtnType) {
		this.tjSleeveBtnType = tjSleeveBtnType;
	}

	public Map<String, String> getTjSleeveBtnTypeMap() {
		return tjSleeveBtnTypeMap;
	}

	public void setTjSleeveBtnTypeMap(Map<String, String> tjSleeveBtnTypeMap) {
		this.tjSleeveBtnTypeMap = tjSleeveBtnTypeMap;
	}

	public String getTjSleeveBtnCnt() {
		return tjSleeveBtnCnt;
	}

	public void setTjSleeveBtnCnt(String tjSleeveBtnCnt) {
		this.tjSleeveBtnCnt = tjSleeveBtnCnt;
	}

	public String getTjCuffSpec() {
		return tjCuffSpec;
	}

	public void setTjCuffSpec(String tjCuffSpec) {
		this.tjCuffSpec = tjCuffSpec;
	}

	public Map<String, String> getTjCuffSpecMap() {
		return tjCuffSpecMap;
	}

	public void setTjCuffSpecMap(Map<String, String> tjCuffSpecMap) {
		this.tjCuffSpecMap = tjCuffSpecMap;
	}

	public String getTjInsidePktChange() {
		return tjInsidePktChange;
	}

	public void setTjInsidePktChange(String tjInsidePktChange) {
		this.tjInsidePktChange = tjInsidePktChange;
	}

	public Map<String, String> getTjInsidePktChangeMap() {
		return tjInsidePktChangeMap;
	}

	public void setTjInsidePktChangeMap(Map<String, String> tjInsidePktChangeMap) {
		this.tjInsidePktChangeMap = tjInsidePktChangeMap;
	}

	public String getTjBreastInnerPkt() {
		return tjBreastInnerPkt;
	}

	public void setTjBreastInnerPkt(String tjBreastInnerPkt) {
		this.tjBreastInnerPkt = tjBreastInnerPkt;
	}

	public Map<String, String> getTjBreastInnerPktMap() {
		return tjBreastInnerPktMap;
	}

	public void setTjBreastInnerPktMap(Map<String, String> tjBreastInnerPktMap) {
		this.tjBreastInnerPktMap = tjBreastInnerPktMap;
	}

	public String getTjStitch() {
		return tjStitch;
	}

	public void setTjStitch(String tjStitch) {
		this.tjStitch = tjStitch;
	}

	public Map<String, String> getTjStitchMap() {
		return tjStitchMap;
	}

	public void setTjStitchMap(Map<String, String> tjStitchMap) {
		this.tjStitchMap = tjStitchMap;
	}

	public String getTjBhColor() {
		return tjBhColor;
	}

	public void setTjBhColor(String tjBhColor) {
		this.tjBhColor = tjBhColor;
	}

	public Map<String, String> getTjBhColorMap() {
		return tjBhColorMap;
	}

	public void setTjBhColorMap(Map<String, String> tjBhColorMap) {
		this.tjBhColorMap = tjBhColorMap;
	}

	public String getTjBhColorPlaceAll() {
		return tjBhColorPlaceAll;
	}

	public void setTjBhColorPlaceAll(String tjBhColorPlaceAll) {
		this.tjBhColorPlaceAll = tjBhColorPlaceAll;
	}

	public Map<String, String> getTjBhColorPlaceAllMap() {
		return tjBhColorPlaceAllMap;
	}

	public void setTjBhColorPlaceAllMap(Map<String, String> tjBhColorPlaceAllMap) {
		this.tjBhColorPlaceAllMap = tjBhColorPlaceAllMap;
	}

	public Map<String, String> getTjBhColorPlaceMap() {
		return tjBhColorPlaceMap;
	}

	public void setTjBhColorPlaceMap(Map<String, String> tjBhColorPlaceMap) {
		this.tjBhColorPlaceMap = tjBhColorPlaceMap;
	}

	public String getTjBhColor1() {
		return tjBhColor1;
	}

	public void setTjBhColor1(String tjBhColor1) {
		this.tjBhColor1 = tjBhColor1;
	}

	public String getTjBhColor2() {
		return tjBhColor2;
	}

	public void setTjBhColor2(String tjBhColor2) {
		this.tjBhColor2 = tjBhColor2;
	}

	public String getTjBhColor3() {
		return tjBhColor3;
	}

	public void setTjBhColor3(String tjBhColor3) {
		this.tjBhColor3 = tjBhColor3;
	}

	public String getTjBhColor4() {
		return tjBhColor4;
	}

	public void setTjBhColor4(String tjBhColor4) {
		this.tjBhColor4 = tjBhColor4;
	}

	public String getTjBhColor5() {
		return tjBhColor5;
	}

	public void setTjBhColor5(String tjBhColor5) {
		this.tjBhColor5 = tjBhColor5;
	}

	public String getTjBhColor6() {
		return tjBhColor6;
	}

	public void setTjBhColor6(String tjBhColor6) {
		this.tjBhColor6 = tjBhColor6;
	}

	public String getTjBhColor7() {
		return tjBhColor7;
	}

	public void setTjBhColor7(String tjBhColor7) {
		this.tjBhColor7 = tjBhColor7;
	}

	public String getTjBhColor8() {
		return tjBhColor8;
	}

	public void setTjBhColor8(String tjBhColor8) {
		this.tjBhColor8 = tjBhColor8;
	}

	public String getTjBhColor9() {
		return tjBhColor9;
	}

	public void setTjBhColor9(String tjBhColor9) {
		this.tjBhColor9 = tjBhColor9;
	}

	public String getTjBhColor10() {
		return tjBhColor10;
	}

	public void setTjBhColor10(String tjBhColor10) {
		this.tjBhColor10 = tjBhColor10;
	}

	public String getTjBhColor11() {
		return tjBhColor11;
	}

	public void setTjBhColor11(String tjBhColor11) {
		this.tjBhColor11 = tjBhColor11;
	}

	public String getTjBhColor12() {
		return tjBhColor12;
	}

	public void setTjBhColor12(String tjBhColor12) {
		this.tjBhColor12 = tjBhColor12;
	}

	public String getTjBhColor13() {
		return tjBhColor13;
	}

	public void setTjBhColor13(String tjBhColor13) {
		this.tjBhColor13 = tjBhColor13;
	}

	public String getTjBhColor14() {
		return tjBhColor14;
	}

	public void setTjBhColor14(String tjBhColor14) {
		this.tjBhColor14 = tjBhColor14;
	}

	public String getTjBhColor15() {
		return tjBhColor15;
	}

	public void setTjBhColor15(String tjBhColor15) {
		this.tjBhColor15 = tjBhColor15;
	}

	public String getTjBhColor16() {
		return tjBhColor16;
	}

	public void setTjBhColor16(String tjBhColor16) {
		this.tjBhColor16 = tjBhColor16;
	}

	public String getTjBhColor17() {
		return tjBhColor17;
	}

	public void setTjBhColor17(String tjBhColor17) {
		this.tjBhColor17 = tjBhColor17;
	}

	public Map<String, String> getTjBhColorsMap() {
		return tjBhColorsMap;
	}

	public void setTjBhColorsMap(Map<String, String> tjBhColorsMap) {
		this.tjBhColorsMap = tjBhColorsMap;
	}

	public String getTjByColor() {
		return tjByColor;
	}

	public void setTjByColor(String tjByColor) {
		this.tjByColor = tjByColor;
	}

	public Map<String, String> getTjByColorMap() {
		return tjByColorMap;
	}

	public void setTjByColorMap(Map<String, String> tjByColorMap) {
		this.tjByColorMap = tjByColorMap;
	}

	public String getTjByColorPlaceAll() {
		return tjByColorPlaceAll;
	}

	public void setTjByColorPlaceAll(String tjByColorPlaceAll) {
		this.tjByColorPlaceAll = tjByColorPlaceAll;
	}

	public Map<String, String> getTjByColorPlaceAllMap() {
		return tjByColorPlaceAllMap;
	}

	public void setTjByColorPlaceAllMap(Map<String, String> tjByColorPlaceAllMap) {
		this.tjByColorPlaceAllMap = tjByColorPlaceAllMap;
	}

	public Map<String, String> getTjByColorPlaceMap() {
		return tjByColorPlaceMap;
	}

	public void setTjByColorPlaceMap(Map<String, String> tjByColorPlaceMap) {
		this.tjByColorPlaceMap = tjByColorPlaceMap;
	}

	public String getTjByColor1() {
		return tjByColor1;
	}

	public void setTjByColor1(String tjByColor1) {
		this.tjByColor1 = tjByColor1;
	}

	public String getTjByColor2() {
		return tjByColor2;
	}

	public void setTjByColor2(String tjByColor2) {
		this.tjByColor2 = tjByColor2;
	}

	public String getTjByColor3() {
		return tjByColor3;
	}

	public void setTjByColor3(String tjByColor3) {
		this.tjByColor3 = tjByColor3;
	}

	public String getTjByColor4() {
		return tjByColor4;
	}

	public void setTjByColor4(String tjByColor4) {
		this.tjByColor4 = tjByColor4;
	}

	public String getTjByColor5() {
		return tjByColor5;
	}

	public void setTjByColor5(String tjByColor5) {
		this.tjByColor5 = tjByColor5;
	}

	public String getTjByColor6() {
		return tjByColor6;
	}

	public void setTjByColor6(String tjByColor6) {
		this.tjByColor6 = tjByColor6;
	}

	public String getTjByColor7() {
		return tjByColor7;
	}

	public void setTjByColor7(String tjByColor7) {
		this.tjByColor7 = tjByColor7;
	}

	public String getTjByColor8() {
		return tjByColor8;
	}

	public void setTjByColor8(String tjByColor8) {
		this.tjByColor8 = tjByColor8;
	}

	public String getTjByColor9() {
		return tjByColor9;
	}

	public void setTjByColor9(String tjByColor9) {
		this.tjByColor9 = tjByColor9;
	}

	public String getTjByColor10() {
		return tjByColor10;
	}

	public void setTjByColor10(String tjByColor10) {
		this.tjByColor10 = tjByColor10;
	}

	public String getTjByColor11() {
		return tjByColor11;
	}

	public void setTjByColor11(String tjByColor11) {
		this.tjByColor11 = tjByColor11;
	}

	public String getTjByColor12() {
		return tjByColor12;
	}

	public void setTjByColor12(String tjByColor12) {
		this.tjByColor12 = tjByColor12;
	}

	public String getTjByColor13() {
		return tjByColor13;
	}

	public void setTjByColor13(String tjByColor13) {
		this.tjByColor13 = tjByColor13;
	}

	public String getTjByColor14() {
		return tjByColor14;
	}

	public void setTjByColor14(String tjByColor14) {
		this.tjByColor14 = tjByColor14;
	}

	public String getTjByColor15() {
		return tjByColor15;
	}

	public void setTjByColor15(String tjByColor15) {
		this.tjByColor15 = tjByColor15;
	}

	public String getTjByColor16() {
		return tjByColor16;
	}

	public void setTjByColor16(String tjByColor16) {
		this.tjByColor16 = tjByColor16;
	}

	public Map<String, String> getTjByColorsMap() {
		return tjByColorsMap;
	}

	public void setTjByColorsMap(Map<String, String> tjByColorsMap) {
		this.tjByColorsMap = tjByColorsMap;
	}

	public String getTjVentSpec() {
		return tjVentSpec;
	}

	public void setTjVentSpec(String tjVentSpec) {
		this.tjVentSpec = tjVentSpec;
	}

	public Map<String, String> getTjVentSpecMap() {
		return tjVentSpecMap;
	}

	public void setTjVentSpecMap(Map<String, String> tjVentSpecMap) {
		this.tjVentSpecMap = tjVentSpecMap;
	}

	public String getTjBodyBackMate() {
		return tjBodyBackMate;
	}

	public void setTjBodyBackMate(String tjBodyBackMate) {
		this.tjBodyBackMate = tjBodyBackMate;
	}

	public Map<String, String> getTjBodyBackMateMap() {
		return tjBodyBackMateMap;
	}

	public void setTjBodyBackMateMap(Map<String, String> tjBodyBackMateMap) {
		this.tjBodyBackMateMap = tjBodyBackMateMap;
	}

	public String getTjCuffBackMate() {
		return tjCuffBackMate;
	}

	public void setTjCuffBackMate(String tjCuffBackMate) {
		this.tjCuffBackMate = tjCuffBackMate;
	}

	public Map<String, String> getTjCuffBackMateMap() {
		return tjCuffBackMateMap;
	}

	public void setTjCuffBackMateMap(Map<String, String> tjCuffBackMateMap) {
		this.tjCuffBackMateMap = tjCuffBackMateMap;
	}

	public String getTjBtnMate() {
		return tjBtnMate;
	}

	public void setTjBtnMate(String tjBtnMate) {
		this.tjBtnMate = tjBtnMate;
	}

	public Map<String, String> getTjBtnMateMap() {
		return tjBtnMateMap;
	}

	public void setTjBtnMateMap(Map<String, String> tjBtnMateMap) {
		this.tjBtnMateMap = tjBtnMateMap;
	}

	public String getTjShapeMemory() {
		return tjShapeMemory;
	}

	public void setTjShapeMemory(String tjShapeMemory) {
		this.tjShapeMemory = tjShapeMemory;
	}

	public Map<String, String> getTjShapeMemoryMap() {
		return tjShapeMemoryMap;
	}

	public void setTjShapeMemoryMap(Map<String, String> tjShapeMemoryMap) {
		this.tjShapeMemoryMap = tjShapeMemoryMap;
	}

	public String getTjJacketModel() {
		return tjJacketModel;
	}

	public void setTjJacketModel(String tjJacketModel) {
		this.tjJacketModel = tjJacketModel;
	}

	public Map<String, String> getTjJacketModelMap() {
		return tjJacketModelMap;
	}

	public void setTjJacketModelMap(Map<String, String> tjJacketModelMap) {
		this.tjJacketModelMap = tjJacketModelMap;
	}

	public String getTjJacketLapelModel() {
		return tjJacketLapelModel;
	}

	public void setTjJacketLapelModel(String tjJacketLapelModel) {
		this.tjJacketLapelModel = tjJacketLapelModel;
	}

	public String getTjStitchModify() {
		return tjStitchModify;
	}

	public void setTjStitchModify(String tjStitchModify) {
		this.tjStitchModify = tjStitchModify;
	}

	public String getTjDStitchModify() {
		return tjDStitchModify;
	}

	public void setTjDStitchModify(String tjDStitchModify) {
		this.tjDStitchModify = tjDStitchModify;
	}

	public String getTjAmfColor() {
		return tjAmfColor;
	}

	public void setTjAmfColor(String tjAmfColor) {
		this.tjAmfColor = tjAmfColor;
	}

	public String getTjBodyBackMateStkNo() {
		return tjBodyBackMateStkNo;
	}

	public void setTjBodyBackMateStkNo(String tjBodyBackMateStkNo) {
		this.tjBodyBackMateStkNo = tjBodyBackMateStkNo;
	}

	public String getTjCuffBackMateStkNo() {
		return tjCuffBackMateStkNo;
	}

	public void setTjCuffBackMateStkNo(String tjCuffBackMateStkNo) {
		this.tjCuffBackMateStkNo = tjCuffBackMateStkNo;
	}

	public String getTjBtnMateStkNo() {
		return tjBtnMateStkNo;
	}

	public void setTjBtnMateStkNo(String tjBtnMateStkNo) {
		this.tjBtnMateStkNo = tjBtnMateStkNo;
	}

	public String getTjBhColorPlace1() {
		return tjBhColorPlace1;
	}

	public void setTjBhColorPlace1(String tjBhColorPlace1) {
		this.tjBhColorPlace1 = tjBhColorPlace1;
	}

	public String getTjBhColorPlace2() {
		return tjBhColorPlace2;
	}

	public void setTjBhColorPlace2(String tjBhColorPlace2) {
		this.tjBhColorPlace2 = tjBhColorPlace2;
	}

	public String getTjBhColorPlace3() {
		return tjBhColorPlace3;
	}

	public void setTjBhColorPlace3(String tjBhColorPlace3) {
		this.tjBhColorPlace3 = tjBhColorPlace3;
	}

	public String getTjBhColorPlace4() {
		return tjBhColorPlace4;
	}

	public void setTjBhColorPlace4(String tjBhColorPlace4) {
		this.tjBhColorPlace4 = tjBhColorPlace4;
	}

	public String getTjBhColorPlace5() {
		return tjBhColorPlace5;
	}

	public void setTjBhColorPlace5(String tjBhColorPlace5) {
		this.tjBhColorPlace5 = tjBhColorPlace5;
	}

	public String getTjBhColorPlace6() {
		return tjBhColorPlace6;
	}

	public void setTjBhColorPlace6(String tjBhColorPlace6) {
		this.tjBhColorPlace6 = tjBhColorPlace6;
	}

	public String getTjBhColorPlace7() {
		return tjBhColorPlace7;
	}

	public void setTjBhColorPlace7(String tjBhColorPlace7) {
		this.tjBhColorPlace7 = tjBhColorPlace7;
	}

	public String getTjBhColorPlace8() {
		return tjBhColorPlace8;
	}

	public void setTjBhColorPlace8(String tjBhColorPlace8) {
		this.tjBhColorPlace8 = tjBhColorPlace8;
	}

	public String getTjBhColorPlace9() {
		return tjBhColorPlace9;
	}

	public void setTjBhColorPlace9(String tjBhColorPlace9) {
		this.tjBhColorPlace9 = tjBhColorPlace9;
	}

	public String getTjBhColorPlace10() {
		return tjBhColorPlace10;
	}

	public void setTjBhColorPlace10(String tjBhColorPlace10) {
		this.tjBhColorPlace10 = tjBhColorPlace10;
	}

	public String getTjBhColorPlace11() {
		return tjBhColorPlace11;
	}

	public void setTjBhColorPlace11(String tjBhColorPlace11) {
		this.tjBhColorPlace11 = tjBhColorPlace11;
	}

	public String getTjBhColorPlace12() {
		return tjBhColorPlace12;
	}

	public void setTjBhColorPlace12(String tjBhColorPlace12) {
		this.tjBhColorPlace12 = tjBhColorPlace12;
	}

	public String getTjBhColorPlace13() {
		return tjBhColorPlace13;
	}

	public void setTjBhColorPlace13(String tjBhColorPlace13) {
		this.tjBhColorPlace13 = tjBhColorPlace13;
	}

	public String getTjBhColorPlace14() {
		return tjBhColorPlace14;
	}

	public void setTjBhColorPlace14(String tjBhColorPlace14) {
		this.tjBhColorPlace14 = tjBhColorPlace14;
	}

	public String getTjBhColorPlace15() {
		return tjBhColorPlace15;
	}

	public void setTjBhColorPlace15(String tjBhColorPlace15) {
		this.tjBhColorPlace15 = tjBhColorPlace15;
	}

	public String getTjBhColorPlace16() {
		return tjBhColorPlace16;
	}

	public void setTjBhColorPlace16(String tjBhColorPlace16) {
		this.tjBhColorPlace16 = tjBhColorPlace16;
	}

	public String getTjBhColorPlace17() {
		return tjBhColorPlace17;
	}

	public void setTjBhColorPlace17(String tjBhColorPlace17) {
		this.tjBhColorPlace17 = tjBhColorPlace17;
	}

	public String getTjByColorPlace1() {
		return tjByColorPlace1;
	}

	public void setTjByColorPlace1(String tjByColorPlace1) {
		this.tjByColorPlace1 = tjByColorPlace1;
	}

	public String getTjByColorPlace2() {
		return tjByColorPlace2;
	}

	public void setTjByColorPlace2(String tjByColorPlace2) {
		this.tjByColorPlace2 = tjByColorPlace2;
	}

	public String getTjByColorPlace3() {
		return tjByColorPlace3;
	}

	public void setTjByColorPlace3(String tjByColorPlace3) {
		this.tjByColorPlace3 = tjByColorPlace3;
	}

	public String getTjByColorPlace4() {
		return tjByColorPlace4;
	}

	public void setTjByColorPlace4(String tjByColorPlace4) {
		this.tjByColorPlace4 = tjByColorPlace4;
	}

	public String getTjByColorPlace5() {
		return tjByColorPlace5;
	}

	public void setTjByColorPlace5(String tjByColorPlace5) {
		this.tjByColorPlace5 = tjByColorPlace5;
	}

	public String getTjByColorPlace6() {
		return tjByColorPlace6;
	}

	public void setTjByColorPlace6(String tjByColorPlace6) {
		this.tjByColorPlace6 = tjByColorPlace6;
	}

	public String getTjByColorPlace7() {
		return tjByColorPlace7;
	}

	public void setTjByColorPlace7(String tjByColorPlace7) {
		this.tjByColorPlace7 = tjByColorPlace7;
	}

	public String getTjByColorPlace8() {
		return tjByColorPlace8;
	}

	public void setTjByColorPlace8(String tjByColorPlace8) {
		this.tjByColorPlace8 = tjByColorPlace8;
	}

	public String getTjByColorPlace9() {
		return tjByColorPlace9;
	}

	public void setTjByColorPlace9(String tjByColorPlace9) {
		this.tjByColorPlace9 = tjByColorPlace9;
	}

	public String getTjByColorPlace10() {
		return tjByColorPlace10;
	}

	public void setTjByColorPlace10(String tjByColorPlace10) {
		this.tjByColorPlace10 = tjByColorPlace10;
	}

	public String getTjByColorPlace11() {
		return tjByColorPlace11;
	}

	public void setTjByColorPlace11(String tjByColorPlace11) {
		this.tjByColorPlace11 = tjByColorPlace11;
	}

	public String getTjByColorPlace12() {
		return tjByColorPlace12;
	}

	public void setTjByColorPlace12(String tjByColorPlace12) {
		this.tjByColorPlace12 = tjByColorPlace12;
	}

	public String getTjByColorPlace13() {
		return tjByColorPlace13;
	}

	public void setTjByColorPlace13(String tjByColorPlace13) {
		this.tjByColorPlace13 = tjByColorPlace13;
	}

	public String getTjByColorPlace14() {
		return tjByColorPlace14;
	}

	public void setTjByColorPlace14(String tjByColorPlace14) {
		this.tjByColorPlace14 = tjByColorPlace14;
	}

	public String getTjByColorPlace15() {
		return tjByColorPlace15;
	}

	public void setTjByColorPlace15(String tjByColorPlace15) {
		this.tjByColorPlace15 = tjByColorPlace15;
	}

	public String getTjByColorPlace16() {
		return tjByColorPlace16;
	}

	public void setTjByColorPlace16(String tjByColorPlace16) {
		this.tjByColorPlace16 = tjByColorPlace16;
	}

	public String getTjByColorPlace17() {
		return tjByColorPlace17;
	}

	public void setTjByColorPlace17(String tjByColorPlace17) {
		this.tjByColorPlace17 = tjByColorPlace17;
	}

	public String getJkFrtBtnRtPrice() {
		return jkFrtBtnRtPrice;
	}

	public void setJkFrtBtnRtPrice(String jkFrtBtnRtPrice) {
		this.jkFrtBtnRtPrice = jkFrtBtnRtPrice;
	}

	public String getJkLapelDesignRtPrice() {
		return jkLapelDesignRtPrice;
	}

	public void setJkLapelDesignRtPrice(String jkLapelDesignRtPrice) {
		this.jkLapelDesignRtPrice = jkLapelDesignRtPrice;
	}

	public String getJkGradeRtPrice() {
		return jkGradeRtPrice;
	}

	public void setJkGradeRtPrice(String jkGradeRtPrice) {
		this.jkGradeRtPrice = jkGradeRtPrice;
	}

	public String getJkInnerClothRtPrice() {
		return jkInnerClothRtPrice;
	}

	public void setJkInnerClothRtPrice(String jkInnerClothRtPrice) {
		this.jkInnerClothRtPrice = jkInnerClothRtPrice;
	}

	public String getJkDaibaRtPrice() {
		return jkDaibaRtPrice;
	}

	public void setJkDaibaRtPrice(String jkDaibaRtPrice) {
		this.jkDaibaRtPrice = jkDaibaRtPrice;
	}

	public String getJkLookClothRtPrice() {
		return jkLookClothRtPrice;
	}

	public void setJkLookClothRtPrice(String jkLookClothRtPrice) {
		this.jkLookClothRtPrice = jkLookClothRtPrice;
	}

	public String getJkCollarInnerRtPrice() {
		return jkCollarInnerRtPrice;
	}

	public void setJkCollarInnerRtPrice(String jkCollarInnerRtPrice) {
		this.jkCollarInnerRtPrice = jkCollarInnerRtPrice;
	}

	public String getJkCollarHangRtPrice() {
		return jkCollarHangRtPrice;
	}

	public void setJkCollarHangRtPrice(String jkCollarHangRtPrice) {
		this.jkCollarHangRtPrice = jkCollarHangRtPrice;
	}

	public String getJkLapelWidthRtPrice() {
		return jkLapelWidthRtPrice;
	}

	public void setJkLapelWidthRtPrice(String jkLapelWidthRtPrice) {
		this.jkLapelWidthRtPrice = jkLapelWidthRtPrice;
	}

	public String getJkFlowerHoleRtPrice() {
		return jkFlowerHoleRtPrice;
	}

	public void setJkFlowerHoleRtPrice(String jkFlowerHoleRtPrice) {
		this.jkFlowerHoleRtPrice = jkFlowerHoleRtPrice;
	}

	public String getJkBreastPktRtPrice() {
		return jkBreastPktRtPrice;
	}

	public void setJkBreastPktRtPrice(String jkBreastPktRtPrice) {
		this.jkBreastPktRtPrice = jkBreastPktRtPrice;
	}

	public String getJkWaistPktRtPrice() {
		return jkWaistPktRtPrice;
	}

	public void setJkWaistPktRtPrice(String jkWaistPktRtPrice) {
		this.jkWaistPktRtPrice = jkWaistPktRtPrice;
	}

	public String getJkChgPktRtPrice() {
		return jkChgPktRtPrice;
	}

	public void setJkChgPktRtPrice(String jkChgPktRtPrice) {
		this.jkChgPktRtPrice = jkChgPktRtPrice;
	}

	public String getJkSlantedPktRtPrice() {
		return jkSlantedPktRtPrice;
	}

	public void setJkSlantedPktRtPrice(String jkSlantedPktRtPrice) {
		this.jkSlantedPktRtPrice = jkSlantedPktRtPrice;
	}

	public String getJkShinobiPktRtPrice() {
		return jkShinobiPktRtPrice;
	}

	public void setJkShinobiPktRtPrice(String jkShinobiPktRtPrice) {
		this.jkShinobiPktRtPrice = jkShinobiPktRtPrice;
	}

	public String getJkSleeveTypeRtPrice() {
		return jkSleeveTypeRtPrice;
	}

	public void setJkSleeveTypeRtPrice(String jkSleeveTypeRtPrice) {
		this.jkSleeveTypeRtPrice = jkSleeveTypeRtPrice;
	}

	public String getJkManicaRtPrice() {
		return jkManicaRtPrice;
	}

	public void setJkManicaRtPrice(String jkManicaRtPrice) {
		this.jkManicaRtPrice = jkManicaRtPrice;
	}

	public String getJkSleeveBtnRtPrice() {
		return jkSleeveBtnRtPrice;
	}

	public void setJkSleeveBtnRtPrice(String jkSleeveBtnRtPrice) {
		this.jkSleeveBtnRtPrice = jkSleeveBtnRtPrice;
	}

	public String getJkCuffRtPrice() {
		return jkCuffRtPrice;
	}

	public void setJkCuffRtPrice(String jkCuffRtPrice) {
		this.jkCuffRtPrice = jkCuffRtPrice;
	}

	public String getJkInnerPktRtPrice() {
		return jkInnerPktRtPrice;
	}

	public void setJkInnerPktRtPrice(String jkInnerPktRtPrice) {
		this.jkInnerPktRtPrice = jkInnerPktRtPrice;
	}

	public String getJkRightInnerPktTypeRtPrice() {
		return jkRightInnerPktTypeRtPrice;
	}

	public void setJkRightInnerPktTypeRtPrice(String jkRightInnerPktTypeRtPrice) {
		this.jkRightInnerPktTypeRtPrice = jkRightInnerPktTypeRtPrice;
	}

	public String getJkStitchTypeRtPrice() {
		return jkStitchTypeRtPrice;
	}

	public void setJkStitchTypeRtPrice(String jkStitchTypeRtPrice) {
		this.jkStitchTypeRtPrice = jkStitchTypeRtPrice;
	}

	public String getJkStitchPlcRtPrice() {
		return jkStitchPlcRtPrice;
	}

	public void setJkStitchPlcRtPrice(String jkStitchPlcRtPrice) {
		this.jkStitchPlcRtPrice = jkStitchPlcRtPrice;
	}

	public String getJkDblstitchPlcRtPrice() {
		return jkDblstitchPlcRtPrice;
	}

	public void setJkDblstitchPlcRtPrice(String jkDblstitchPlcRtPrice) {
		this.jkDblstitchPlcRtPrice = jkDblstitchPlcRtPrice;
	}

	public String getJkAmfColorRtPrice() {
		return jkAmfColorRtPrice;
	}

	public void setJkAmfColorRtPrice(String jkAmfColorRtPrice) {
		this.jkAmfColorRtPrice = jkAmfColorRtPrice;
	}

	public String getJkBtnholePlcColorRtPrice() {
		return jkBtnholePlcColorRtPrice;
	}

	public void setJkBtnholePlcColorRtPrice(String jkBtnholePlcColorRtPrice) {
		this.jkBtnholePlcColorRtPrice = jkBtnholePlcColorRtPrice;
	}

	public String getJkBtnthreadPlcColorRtPrice() {
		return jkBtnthreadPlcColorRtPrice;
	}

	public void setJkBtnthreadPlcColorRtPrice(String jkBtnthreadPlcColorRtPrice) {
		this.jkBtnthreadPlcColorRtPrice = jkBtnthreadPlcColorRtPrice;
	}

	public String getJkVentRtPrice() {
		return jkVentRtPrice;
	}

	public void setJkVentRtPrice(String jkVentRtPrice) {
		this.jkVentRtPrice = jkVentRtPrice;
	}

	public String getJkInnerBodyClothRtPrice() {
		return jkInnerBodyClothRtPrice;
	}

	public void setJkInnerBodyClothRtPrice(String jkInnerBodyClothRtPrice) {
		this.jkInnerBodyClothRtPrice = jkInnerBodyClothRtPrice;
	}

	public String getJkInnerSleeveClothRtPrice() {
		return jkInnerSleeveClothRtPrice;
	}

	public void setJkInnerSleeveClothRtPrice(String jkInnerSleeveClothRtPrice) {
		this.jkInnerSleeveClothRtPrice = jkInnerSleeveClothRtPrice;
	}

	public String getJkBtnMaterialRtPrice() {
		return jkBtnMaterialRtPrice;
	}

	public void setJkBtnMaterialRtPrice(String jkBtnMaterialRtPrice) {
		this.jkBtnMaterialRtPrice = jkBtnMaterialRtPrice;
	}

	public String getJkShapeMemoryRtPrice() {
		return jkShapeMemoryRtPrice;
	}

	public void setJkShapeMemoryRtPrice(String jkShapeMemoryRtPrice) {
		this.jkShapeMemoryRtPrice = jkShapeMemoryRtPrice;
	}

	public String getTjBhColorPlace() {
		return tjBhColorPlace;
	}

	public void setTjBhColorPlace(String tjBhColorPlace) {
		this.tjBhColorPlace = tjBhColorPlace;
	}

	public String getTjAllBhColor() {
		return tjAllBhColor;
	}

	public void setTjAllBhColor(String tjAllBhColor) {
		this.tjAllBhColor = tjAllBhColor;
	}

	public String getTjByColorPlace() {
		return tjByColorPlace;
	}

	public void setTjByColorPlace(String tjByColorPlace) {
		this.tjByColorPlace = tjByColorPlace;
	}

	public String getTjAllByColor() {
		return tjAllByColor;
	}

	public void setTjAllByColor(String tjAllByColor) {
		this.tjAllByColor = tjAllByColor;
	}
	
}
