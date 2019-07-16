package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;

public class OptionJacketStandardInfo implements Serializable{
	private static final long serialVersionUID = 545856920818855386L;

	//JACKETモデル
	private String ojJacketModel;
	
	private Map<String,String> ojJacketModelMap;
	
	//フロント釦数
    private String ojFrontBtnCnt;
    
    private Map<String,String> ojFrontBtnCntMap;
    
    //ラペルデザイン
    private String ojLapelDesign;
    
    private Map<String,String> ojLapelDesignMap;
    
    //グレード
    private String ojGrade;

    private Map<String,String> ojGradeMap;
    //裏仕様
  	private String ojGackSpec;
      
    private Map<String,String> ojGackSpecMap;
    
    //台場
    private String ojFort;
    
    private Map<String,String> ojFortMap;
    //襟裏（ヒゲ）
    private String ojBackCollar;
    
    private Map<String,String> ojBackCollarMap;
    
    //襟吊
    private String ojChainHange;
    
    private Map<String,String> ojChainHangeMap;
    
    //ラペル幅
    private String ojLapelWidth;
    
    private Map<String,String> ojLapelWidthMap;
    
    //フラワーホール
    private String ojFlowerHole;
    
    private Map<String,String> ojFlowerHoleMap;
    
    //胸ポケット
    private String ojBreastPkt;
    
    private Map<String,String> ojBreastPktMap;
    
    //腰ポケット
    private String ojWaistPkt;
    
    private Map<String,String> ojWaistPktMap;
    
    //チェンジポケット
    private String ojChangePkt;
    
    private Map<String,String> ojChangePktMap;
    
    //スランテッドポケット
    private String ojSlantedPkt;
    
    private Map<String,String> ojSlantedPktMap;
    
    //忍びポケット
    private String ojCoinPkt;
    
    private Map<String,String> ojCoinPktMap;
    
    //袖仕様
    private String ojSleeveSpec;
    
    private Map<String,String> ojSleeveSpecMap;
    
    //マニカ
    private String ojManica;
    
    private Map<String,String> ojManicaMap;
    
    //袖釦
    private String ojSleeveBtnType;
    
    private Map<String,String> ojSleeveBtnTypeMap;
    
    //袖口
    private String ojCuffSpec;
    
    private Map<String,String> ojCuffSpecMap;
    
    //内ポケット変更
    private String ojInsidePktChange;
    
    private Map<String,String> ojInsidePktChangeMap;
    
    //内ポケット変更箇所
    private String ojInsidePktPlace;
    
    private Map<String,String> ojInsidePktPlaceMap;
    
    //下前胸内ポケット仕様
    private String ojBreastInnerPkt;
    
    private Map<String,String> ojBreastInnerPktMap;
    
    //ステッチ種類
    private String ojStitch;
    
    private Map<String,String> ojStitchMap;
    
    //ステッチ変更
    private String ojStitchModify;
    
    private Map<String,String> ojStitchModifyMap;
    
    //ステッチ変更箇所
    private String ojStitchModifyPlace;
    
    private Map<String,String> ojStitchModifyPlaceMap;
    
    //ダブルステッチ変更
    private String ojDStitchModify;
    
    private Map<String,String> ojDStitchModifyMap;
    
    //ダブルステッチ変更箇所
    private String ojDStitchModifyPlace;
    
    private Map<String,String> ojDStitchModifyPlaceMap;
    
    //AMF色指定
    private String ojAmfColor;
    
    private Map<String,String> ojAmfColorMap;
    
    //AMF糸色 
    private String ojAmfColorPlaceAll;
    
    private Map<String,String> ojAmfColorPlaceAllMap;
    
    //AMF色指定箇所
    private String ojAmfColorPlace;
    
    private Map<String,String> ojAmfColorPlaceMap;
    
    //AMF糸色  ラペル・フロント
    private String ojAmfColor1;
    
    //AMF糸色  胸ポケット
    private String ojAmfColor2;
    
    //AMF糸色  腰ポケット
    private String ojAmfColor3;
  
    //AMF糸色  ダーツ
    private String ojAmfColor4;
    
    //AMF糸色  肩線
    private String ojAmfColor5;
    
    //AMF糸色  外袖
    private String ojAmfColor6;
    
    //AMF糸色  袖開き
    private String ojAmfColor7;
    
    //AMF糸色  背中心
    private String ojAmfColor8;
    
    //AMF糸色  ベント
    private String ojAmfColor9;
    
    //AMF色 key&value
    private Map<String,String> ojAmfColorsMap;
    
    //ボタンホール色指定
    private String ojBhColor;
    
    private Map<String,String> ojBhColorMap;
    
    //ボタンホール色指定糸色
    private String ojBhColorPlaceAll;
    
    private Map<String,String> ojBhColorPlaceAllMap;
    
    //ボタンホール色指定箇所
    private String ojBhColorPlace;
    
    private Map<String,String> ojBhColorPlaceMap;
    
    //ボタンホール色指定糸色  フラワーホール(上前1)
    private String ojBhColor1;
    
    //ボタンホール色指定糸色  フラワーホール(上前2)
    private String ojBhColor2;
    
    //ボタンホール色指定糸色 フラワーホール(下前1)
    private String ojBhColor3;
  
    //ボタンホール色指定糸色  フラワーホール(下前2)
    private String ojBhColor4;
    
    //ボタンホール色指定糸色  フロント１
    private String ojBhColor5;
    
    //ボタンホール色指定糸色  フロント２
    private String ojBhColor6;
    
    //ボタンホール色指定糸色  フロント３
    private String ojBhColor7;
  
    //ボタンホール色指定糸色  上前袖口１
    private String ojBhColor8;
    
    //ボタンホール色指定糸色  上前袖口２
    private String ojBhColor9;
    
    //ボタンホール色指定糸色  上前袖口３
    private String ojBhColor10;
    
    //ボタンホール色指定糸色  上前袖口４
    private String ojBhColor11;
  
    //ボタンホール色指定糸色  上前袖口５
    private String ojBhColor12;
    
    //ボタンホール色指定糸色  下前袖口１
    private String ojBhColor13;
    
    //ボタンホール色指定糸色  下前袖口２
    private String ojBhColor14;
    
    //ボタンホール色指定糸色  下前袖口３
    private String ojBhColor15;
    
    //ボタンホール色指定糸色  下前袖口４
    private String ojBhColor16;
  
    //ボタンホール色指定糸色  下前袖口５
    private String ojBhColor17;
    
    //ボタンホール色指定色 key&value
    private Map<String,String> ojBhColorsMap;
    
    //ボタン付け糸指定
    private String ojByColor;
    
    private Map<String,String> ojByColorMap;
    
    //ボタン付け糸指定糸色
    private String ojByColorPlaceAll;
    
    private Map<String,String> ojByColorPlaceAllMap;
    
    //ボタン付け糸指定箇所
    private String ojByColorPlace;
    
    private Map<String,String> ojByColorPlaceMap;
    
    //ボタン付け糸指定糸色   フロント下前1
    private String ojByColor1;
    
    //ボタン付け糸指定糸色 フロント下前2
    private String ojByColor2;
    
    //ボタン付け糸指定糸色  フロント下前3
    private String ojByColor3;
  
    //ボタン付け糸指定糸色   フロント上前1
    private String ojByColor4;
    
    //ボタン付け糸指定糸色   フロント上前2
    private String ojByColor5;
    
    //ボタン付け糸指定糸色   フロント上前3
    private String ojByColor6;
    
    //ボタン付け糸指定糸色   上前袖口１
    private String ojByColor7;
    
    //ボタン付け糸指定糸色  上前袖口２
    private String ojByColor8;
    
    //ボタン付け糸指定糸色   上前袖口３
    private String ojByColor9;
    
    //ボタン付け糸指定糸色   上前袖口４
    private String ojByColor10;
  
    //ボタン付け糸指定糸色   上前袖口５
    private String ojByColor11;
    
    //ボタン付け糸指定糸色   下前袖口１
    private String ojByColor12;
    
    //ボタン付け糸指定糸色   下前袖口２
    private String ojByColor13;
    
    //ボタン付け糸指定糸色   下前袖口３
    private String ojByColor14;
    
    //ボタン付け糸指定糸色   下前袖口４
    private String ojByColor15;
  
    //ボタン付け糸指定糸色   下前袖口５
    private String ojByColor16;
    
    //ボタン付け糸指定糸色 key&value
    private Map<String,String> ojByColorsMap;
    
    //ベント
    private String ojVentSpec;
    
    private Map<String,String> ojVentSpecMap;
    
    //胴裏素材
    private String ojBodyBackMate;
    
    private Map<String,String> ojBodyBackMateMap;
    
    //胴裏素材品番
    private String ojBodyBackMateStkNo;
    
    //袖裏素材
    private String ojCuffBackMate;
    
    private Map<String,String> ojCuffBackMateMap;
    
    //袖裏素材品番
    private String ojCuffBackMateStkNo;
    
    //釦素材
    private String ojBtnMate;
    
    private Map<String,String> ojBtnMateMap;
    
    //釦素材品番
    private String ojBtnMateStkNo;
    
    //形状記憶
    private String ojShapeMemory; 
    
    private Map<String,String> ojShapeMemoryMap;
    
    //品番Map
    private Map<String,String> jacketMateMap;
    

	public Map<String, String> getJacketMateMap() {
		return jacketMateMap;
	}

	public void setJacketMateMap(Map<String, String> jacketMateMap) {
		this.jacketMateMap = jacketMateMap;
	}

	public String getOjFrontBtnCnt() {
		return ojFrontBtnCnt;
	}

	public void setOjFrontBtnCnt(String ojFrontBtnCnt) {
		this.ojFrontBtnCnt = ojFrontBtnCnt;
	}

	public Map<String, String> getOjFrontBtnCntMap() {
		return ojFrontBtnCntMap;
	}

	public void setOjFrontBtnCntMap(Map<String, String> ojFrontBtnCntMap) {
		this.ojFrontBtnCntMap = ojFrontBtnCntMap;
	}

	public String getOjLapelDesign() {
		return ojLapelDesign;
	}

	public void setOjLapelDesign(String ojLapelDesign) {
		this.ojLapelDesign = ojLapelDesign;
	}

	public Map<String, String> getOjLapelDesignMap() {
		return ojLapelDesignMap;
	}

	public void setOjLapelDesignMap(Map<String, String> ojLapelDesignMap) {
		this.ojLapelDesignMap = ojLapelDesignMap;
	}

	public String getOjGrade() {
		return ojGrade;
	}

	public void setOjGrade(String ojGrade) {
		this.ojGrade = ojGrade;
	}

	public Map<String, String> getOjGradeMap() {
		return ojGradeMap;
	}

	public void setOjGradeMap(Map<String, String> ojGradeMap) {
		this.ojGradeMap = ojGradeMap;
	}

	public String getOjGackSpec() {
		return ojGackSpec;
	}

	public void setOjGackSpec(String ojGackSpec) {
		this.ojGackSpec = ojGackSpec;
	}

	public Map<String, String> getOjGackSpecMap() {
		return ojGackSpecMap;
	}

	public void setOjGackSpecMap(Map<String, String> ojGackSpecMap) {
		this.ojGackSpecMap = ojGackSpecMap;
	}

	public String getOjFort() {
		return ojFort;
	}

	public void setOjFort(String ojFort) {
		this.ojFort = ojFort;
	}

	public Map<String, String> getOjFortMap() {
		return ojFortMap;
	}

	public void setOjFortMap(Map<String, String> ojFortMap) {
		this.ojFortMap = ojFortMap;
	}

	public String getOjBackCollar() {
		return ojBackCollar;
	}

	public void setOjBackCollar(String ojBackCollar) {
		this.ojBackCollar = ojBackCollar;
	}

	public Map<String, String> getOjBackCollarMap() {
		return ojBackCollarMap;
	}

	public void setOjBackCollarMap(Map<String, String> ojBackCollarMap) {
		this.ojBackCollarMap = ojBackCollarMap;
	}

	public String getOjChainHange() {
		return ojChainHange;
	}

	public void setOjChainHange(String ojChainHange) {
		this.ojChainHange = ojChainHange;
	}

	public Map<String, String> getOjChainHangeMap() {
		return ojChainHangeMap;
	}

	public void setOjChainHangeMap(Map<String, String> ojChainHangeMap) {
		this.ojChainHangeMap = ojChainHangeMap;
	}

	public String getOjLapelWidth() {
		return ojLapelWidth;
	}

	public void setOjLapelWidth(String ojLapelWidth) {
		this.ojLapelWidth = ojLapelWidth;
	}

	public Map<String, String> getOjLapelWidthMap() {
		return ojLapelWidthMap;
	}

	public void setOjLapelWidthMap(Map<String, String> ojLapelWidthMap) {
		this.ojLapelWidthMap = ojLapelWidthMap;
	}

	public String getOjFlowerHole() {
		return ojFlowerHole;
	}

	public void setOjFlowerHole(String ojFlowerHole) {
		this.ojFlowerHole = ojFlowerHole;
	}

	public Map<String, String> getOjFlowerHoleMap() {
		return ojFlowerHoleMap;
	}

	public void setOjFlowerHoleMap(Map<String, String> ojFlowerHoleMap) {
		this.ojFlowerHoleMap = ojFlowerHoleMap;
	}

	public String getOjBreastPkt() {
		return ojBreastPkt;
	}

	public void setOjBreastPkt(String ojBreastPkt) {
		this.ojBreastPkt = ojBreastPkt;
	}

	public Map<String, String> getOjBreastPktMap() {
		return ojBreastPktMap;
	}

	public void setOjBreastPktMap(Map<String, String> ojBreastPktMap) {
		this.ojBreastPktMap = ojBreastPktMap;
	}

	public String getOjWaistPkt() {
		return ojWaistPkt;
	}

	public void setOjWaistPkt(String ojWaistPkt) {
		this.ojWaistPkt = ojWaistPkt;
	}

	public Map<String, String> getOjWaistPktMap() {
		return ojWaistPktMap;
	}

	public void setOjWaistPktMap(Map<String, String> ojWaistPktMap) {
		this.ojWaistPktMap = ojWaistPktMap;
	}

	public String getOjChangePkt() {
		return ojChangePkt;
	}

	public void setOjChangePkt(String ojChangePkt) {
		this.ojChangePkt = ojChangePkt;
	}

	public Map<String, String> getOjChangePktMap() {
		return ojChangePktMap;
	}

	public void setOjChangePktMap(Map<String, String> ojChangePktMap) {
		this.ojChangePktMap = ojChangePktMap;
	}

	public String getOjSlantedPkt() {
		return ojSlantedPkt;
	}

	public void setOjSlantedPkt(String ojSlantedPkt) {
		this.ojSlantedPkt = ojSlantedPkt;
	}

	public Map<String, String> getOjSlantedPktMap() {
		return ojSlantedPktMap;
	}

	public void setOjSlantedPktMap(Map<String, String> ojSlantedPktMap) {
		this.ojSlantedPktMap = ojSlantedPktMap;
	}

	public String getOjCoinPkt() {
		return ojCoinPkt;
	}

	public void setOjCoinPkt(String ojCoinPkt) {
		this.ojCoinPkt = ojCoinPkt;
	}

	public Map<String, String> getOjCoinPktMap() {
		return ojCoinPktMap;
	}

	public void setOjCoinPktMap(Map<String, String> ojCoinPktMap) {
		this.ojCoinPktMap = ojCoinPktMap;
	}

	public String getOjSleeveSpec() {
		return ojSleeveSpec;
	}

	public void setOjSleeveSpec(String ojSleeveSpec) {
		this.ojSleeveSpec = ojSleeveSpec;
	}

	public Map<String, String> getOjSleeveSpecMap() {
		return ojSleeveSpecMap;
	}

	public void setOjSleeveSpecMap(Map<String, String> ojSleeveSpecMap) {
		this.ojSleeveSpecMap = ojSleeveSpecMap;
	}

	public String getOjManica() {
		return ojManica;
	}

	public void setOjManica(String ojManica) {
		this.ojManica = ojManica;
	}

	public Map<String, String> getOjManicaMap() {
		return ojManicaMap;
	}

	public void setOjManicaMap(Map<String, String> ojManicaMap) {
		this.ojManicaMap = ojManicaMap;
	}

	public String getOjSleeveBtnType() {
		return ojSleeveBtnType;
	}

	public void setOjSleeveBtnType(String ojSleeveBtnType) {
		this.ojSleeveBtnType = ojSleeveBtnType;
	}

	public Map<String, String> getOjSleeveBtnTypeMap() {
		return ojSleeveBtnTypeMap;
	}

	public void setOjSleeveBtnTypeMap(Map<String, String> ojSleeveBtnTypeMap) {
		this.ojSleeveBtnTypeMap = ojSleeveBtnTypeMap;
	}

	public String getOjCuffSpec() {
		return ojCuffSpec;
	}

	public void setOjCuffSpec(String ojCuffSpec) {
		this.ojCuffSpec = ojCuffSpec;
	}

	public Map<String, String> getOjCuffSpecMap() {
		return ojCuffSpecMap;
	}

	public void setOjCuffSpecMap(Map<String, String> ojCuffSpecMap) {
		this.ojCuffSpecMap = ojCuffSpecMap;
	}

	public String getOjInsidePktChange() {
		return ojInsidePktChange;
	}

	public void setOjInsidePktChange(String ojInsidePktChange) {
		this.ojInsidePktChange = ojInsidePktChange;
	}

	public Map<String, String> getOjInsidePktChangeMap() {
		return ojInsidePktChangeMap;
	}

	public void setOjInsidePktChangeMap(Map<String, String> ojInsidePktChangeMap) {
		this.ojInsidePktChangeMap = ojInsidePktChangeMap;
	}

	public String getOjInsidePktPlace() {
		return ojInsidePktPlace;
	}

	public void setOjInsidePktPlace(String ojInsidePktPlace) {
		this.ojInsidePktPlace = ojInsidePktPlace;
	}

	public Map<String, String> getOjInsidePktPlaceMap() {
		return ojInsidePktPlaceMap;
	}

	public void setOjInsidePktPlaceMap(Map<String, String> ojInsidePktPlaceMap) {
		this.ojInsidePktPlaceMap = ojInsidePktPlaceMap;
	}

	public String getOjBreastInnerPkt() {
		return ojBreastInnerPkt;
	}

	public void setOjBreastInnerPkt(String ojBreastInnerPkt) {
		this.ojBreastInnerPkt = ojBreastInnerPkt;
	}

	public Map<String, String> getOjBreastInnerPktMap() {
		return ojBreastInnerPktMap;
	}

	public void setOjBreastInnerPktMap(Map<String, String> ojBreastInnerPktMap) {
		this.ojBreastInnerPktMap = ojBreastInnerPktMap;
	}

	public String getOjStitch() {
		return ojStitch;
	}

	public void setOjStitch(String ojStitch) {
		this.ojStitch = ojStitch;
	}

	public Map<String, String> getOjStitchMap() {
		return ojStitchMap;
	}

	public void setOjStitchMap(Map<String, String> ojStitchMap) {
		this.ojStitchMap = ojStitchMap;
	}

	public String getOjStitchModify() {
		return ojStitchModify;
	}

	public void setOjStitchModify(String ojStitchModify) {
		this.ojStitchModify = ojStitchModify;
	}

	public Map<String, String> getOjStitchModifyMap() {
		return ojStitchModifyMap;
	}

	public void setOjStitchModifyMap(Map<String, String> ojStitchModifyMap) {
		this.ojStitchModifyMap = ojStitchModifyMap;
	}

	public String getOjStitchModifyPlace() {
		return ojStitchModifyPlace;
	}

	public void setOjStitchModifyPlace(String ojStitchModifyPlace) {
		this.ojStitchModifyPlace = ojStitchModifyPlace;
	}

	public Map<String, String> getOjStitchModifyPlaceMap() {
		return ojStitchModifyPlaceMap;
	}

	public void setOjStitchModifyPlaceMap(Map<String, String> ojStitchModifyPlaceMap) {
		this.ojStitchModifyPlaceMap = ojStitchModifyPlaceMap;
	}

	public String getOjDStitchModify() {
		return ojDStitchModify;
	}

	public void setOjDStitchModify(String ojDStitchModify) {
		this.ojDStitchModify = ojDStitchModify;
	}

	public Map<String, String> getOjDStitchModifyMap() {
		return ojDStitchModifyMap;
	}

	public void setOjDStitchModifyMap(Map<String, String> ojDStitchModifyMap) {
		this.ojDStitchModifyMap = ojDStitchModifyMap;
	}

	public String getOjDStitchModifyPlace() {
		return ojDStitchModifyPlace;
	}

	public void setOjDStitchModifyPlace(String ojDStitchModifyPlace) {
		this.ojDStitchModifyPlace = ojDStitchModifyPlace;
	}

	public Map<String, String> getOjDStitchModifyPlaceMap() {
		return ojDStitchModifyPlaceMap;
	}

	public void setOjDStitchModifyPlaceMap(Map<String, String> ojDStitchModifyPlaceMap) {
		this.ojDStitchModifyPlaceMap = ojDStitchModifyPlaceMap;
	}

	public String getOjAmfColor() {
		return ojAmfColor;
	}

	public void setOjAmfColor(String ojAmfColor) {
		this.ojAmfColor = ojAmfColor;
	}

	public Map<String, String> getOjAmfColorMap() {
		return ojAmfColorMap;
	}

	public void setOjAmfColorMap(Map<String, String> ojAmfColorMap) {
		this.ojAmfColorMap = ojAmfColorMap;
	}

	public String getOjAmfColorPlaceAll() {
		return ojAmfColorPlaceAll;
	}

	public void setOjAmfColorPlaceAll(String ojAmfColorPlaceAll) {
		this.ojAmfColorPlaceAll = ojAmfColorPlaceAll;
	}

	public Map<String, String> getOjAmfColorPlaceAllMap() {
		return ojAmfColorPlaceAllMap;
	}

	public void setOjAmfColorPlaceAllMap(Map<String, String> ojAmfColorPlaceAllMap) {
		this.ojAmfColorPlaceAllMap = ojAmfColorPlaceAllMap;
	}

	public String getOjAmfColorPlace() {
		return ojAmfColorPlace;
	}

	public void setOjAmfColorPlace(String ojAmfColorPlace) {
		this.ojAmfColorPlace = ojAmfColorPlace;
	}

	public Map<String, String> getOjAmfColorPlaceMap() {
		return ojAmfColorPlaceMap;
	}

	public void setOjAmfColorPlaceMap(Map<String, String> ojAmfColorPlaceMap) {
		this.ojAmfColorPlaceMap = ojAmfColorPlaceMap;
	}

	public String getOjAmfColor1() {
		return ojAmfColor1;
	}

	public void setOjAmfColor1(String ojAmfColor1) {
		this.ojAmfColor1 = ojAmfColor1;
	}

	public String getOjAmfColor2() {
		return ojAmfColor2;
	}

	public void setOjAmfColor2(String ojAmfColor2) {
		this.ojAmfColor2 = ojAmfColor2;
	}

	public String getOjAmfColor3() {
		return ojAmfColor3;
	}

	public void setOjAmfColor3(String ojAmfColor3) {
		this.ojAmfColor3 = ojAmfColor3;
	}

	public String getOjAmfColor4() {
		return ojAmfColor4;
	}

	public void setOjAmfColor4(String ojAmfColor4) {
		this.ojAmfColor4 = ojAmfColor4;
	}

	public String getOjAmfColor5() {
		return ojAmfColor5;
	}

	public void setOjAmfColor5(String ojAmfColor5) {
		this.ojAmfColor5 = ojAmfColor5;
	}

	public String getOjAmfColor6() {
		return ojAmfColor6;
	}

	public void setOjAmfColor6(String ojAmfColor6) {
		this.ojAmfColor6 = ojAmfColor6;
	}

	public String getOjAmfColor7() {
		return ojAmfColor7;
	}

	public void setOjAmfColor7(String ojAmfColor7) {
		this.ojAmfColor7 = ojAmfColor7;
	}

	public String getOjAmfColor8() {
		return ojAmfColor8;
	}

	public void setOjAmfColor8(String ojAmfColor8) {
		this.ojAmfColor8 = ojAmfColor8;
	}

	public String getOjAmfColor9() {
		return ojAmfColor9;
	}

	public void setOjAmfColor9(String ojAmfColor9) {
		this.ojAmfColor9 = ojAmfColor9;
	}

	public Map<String, String> getOjAmfColorsMap() {
		return ojAmfColorsMap;
	}

	public void setOjAmfColorsMap(Map<String, String> ojAmfColorsMap) {
		this.ojAmfColorsMap = ojAmfColorsMap;
	}

	public String getOjBhColor() {
		return ojBhColor;
	}

	public void setOjBhColor(String ojBhColor) {
		this.ojBhColor = ojBhColor;
	}

	public Map<String, String> getOjBhColorMap() {
		return ojBhColorMap;
	}

	public void setOjBhColorMap(Map<String, String> ojBhColorMap) {
		this.ojBhColorMap = ojBhColorMap;
	}

	public String getOjBhColorPlaceAll() {
		return ojBhColorPlaceAll;
	}

	public void setOjBhColorPlaceAll(String ojBhColorPlaceAll) {
		this.ojBhColorPlaceAll = ojBhColorPlaceAll;
	}

	public Map<String, String> getOjBhColorPlaceAllMap() {
		return ojBhColorPlaceAllMap;
	}

	public void setOjBhColorPlaceAllMap(Map<String, String> ojBhColorPlaceAllMap) {
		this.ojBhColorPlaceAllMap = ojBhColorPlaceAllMap;
	}

	public String getOjBhColorPlace() {
		return ojBhColorPlace;
	}

	public void setOjBhColorPlace(String ojBhColorPlace) {
		this.ojBhColorPlace = ojBhColorPlace;
	}

	public Map<String, String> getOjBhColorPlaceMap() {
		return ojBhColorPlaceMap;
	}

	public void setOjBhColorPlaceMap(Map<String, String> ojBhColorPlaceMap) {
		this.ojBhColorPlaceMap = ojBhColorPlaceMap;
	}

	public String getOjBhColor1() {
		return ojBhColor1;
	}

	public void setOjBhColor1(String ojBhColor1) {
		this.ojBhColor1 = ojBhColor1;
	}

	public String getOjBhColor2() {
		return ojBhColor2;
	}

	public void setOjBhColor2(String ojBhColor2) {
		this.ojBhColor2 = ojBhColor2;
	}

	public String getOjBhColor3() {
		return ojBhColor3;
	}

	public void setOjBhColor3(String ojBhColor3) {
		this.ojBhColor3 = ojBhColor3;
	}

	public String getOjBhColor4() {
		return ojBhColor4;
	}

	public void setOjBhColor4(String ojBhColor4) {
		this.ojBhColor4 = ojBhColor4;
	}

	public String getOjBhColor5() {
		return ojBhColor5;
	}

	public void setOjBhColor5(String ojBhColor5) {
		this.ojBhColor5 = ojBhColor5;
	}

	public String getOjBhColor6() {
		return ojBhColor6;
	}

	public void setOjBhColor6(String ojBhColor6) {
		this.ojBhColor6 = ojBhColor6;
	}

	public String getOjBhColor7() {
		return ojBhColor7;
	}

	public void setOjBhColor7(String ojBhColor7) {
		this.ojBhColor7 = ojBhColor7;
	}

	public String getOjBhColor8() {
		return ojBhColor8;
	}

	public void setOjBhColor8(String ojBhColor8) {
		this.ojBhColor8 = ojBhColor8;
	}

	public String getOjBhColor9() {
		return ojBhColor9;
	}

	public void setOjBhColor9(String ojBhColor9) {
		this.ojBhColor9 = ojBhColor9;
	}

	public String getOjBhColor10() {
		return ojBhColor10;
	}

	public void setOjBhColor10(String ojBhColor10) {
		this.ojBhColor10 = ojBhColor10;
	}

	public String getOjBhColor11() {
		return ojBhColor11;
	}

	public void setOjBhColor11(String ojBhColor11) {
		this.ojBhColor11 = ojBhColor11;
	}

	public String getOjBhColor12() {
		return ojBhColor12;
	}

	public void setOjBhColor12(String ojBhColor12) {
		this.ojBhColor12 = ojBhColor12;
	}

	public String getOjBhColor13() {
		return ojBhColor13;
	}

	public void setOjBhColor13(String ojBhColor13) {
		this.ojBhColor13 = ojBhColor13;
	}

	public String getOjBhColor14() {
		return ojBhColor14;
	}

	public void setOjBhColor14(String ojBhColor14) {
		this.ojBhColor14 = ojBhColor14;
	}

	public String getOjBhColor15() {
		return ojBhColor15;
	}

	public void setOjBhColor15(String ojBhColor15) {
		this.ojBhColor15 = ojBhColor15;
	}

	public String getOjBhColor16() {
		return ojBhColor16;
	}

	public void setOjBhColor16(String ojBhColor16) {
		this.ojBhColor16 = ojBhColor16;
	}

	public String getOjBhColor17() {
		return ojBhColor17;
	}

	public void setOjBhColor17(String ojBhColor17) {
		this.ojBhColor17 = ojBhColor17;
	}

	public Map<String, String> getOjBhColorsMap() {
		return ojBhColorsMap;
	}

	public void setOjBhColorsMap(Map<String, String> ojBhColorsMap) {
		this.ojBhColorsMap = ojBhColorsMap;
	}

	public String getOjByColor() {
		return ojByColor;
	}

	public void setOjByColor(String ojByColor) {
		this.ojByColor = ojByColor;
	}

	public Map<String, String> getOjByColorMap() {
		return ojByColorMap;
	}

	public void setOjByColorMap(Map<String, String> ojByColorMap) {
		this.ojByColorMap = ojByColorMap;
	}

	public String getOjByColorPlaceAll() {
		return ojByColorPlaceAll;
	}

	public void setOjByColorPlaceAll(String ojByColorPlaceAll) {
		this.ojByColorPlaceAll = ojByColorPlaceAll;
	}

	public Map<String, String> getOjByColorPlaceAllMap() {
		return ojByColorPlaceAllMap;
	}

	public void setOjByColorPlaceAllMap(Map<String, String> ojByColorPlaceAllMap) {
		this.ojByColorPlaceAllMap = ojByColorPlaceAllMap;
	}

	public String getOjByColorPlace() {
		return ojByColorPlace;
	}

	public void setOjByColorPlace(String ojByColorPlace) {
		this.ojByColorPlace = ojByColorPlace;
	}

	public Map<String, String> getOjByColorPlaceMap() {
		return ojByColorPlaceMap;
	}

	public void setOjByColorPlaceMap(Map<String, String> ojByColorPlaceMap) {
		this.ojByColorPlaceMap = ojByColorPlaceMap;
	}

	public String getOjByColor1() {
		return ojByColor1;
	}

	public void setOjByColor1(String ojByColor1) {
		this.ojByColor1 = ojByColor1;
	}

	public String getOjByColor2() {
		return ojByColor2;
	}

	public void setOjByColor2(String ojByColor2) {
		this.ojByColor2 = ojByColor2;
	}

	public String getOjByColor3() {
		return ojByColor3;
	}

	public void setOjByColor3(String ojByColor3) {
		this.ojByColor3 = ojByColor3;
	}

	public String getOjByColor4() {
		return ojByColor4;
	}

	public void setOjByColor4(String ojByColor4) {
		this.ojByColor4 = ojByColor4;
	}

	public String getOjByColor5() {
		return ojByColor5;
	}

	public void setOjByColor5(String ojByColor5) {
		this.ojByColor5 = ojByColor5;
	}

	public String getOjByColor6() {
		return ojByColor6;
	}

	public void setOjByColor6(String ojByColor6) {
		this.ojByColor6 = ojByColor6;
	}

	public String getOjByColor7() {
		return ojByColor7;
	}

	public void setOjByColor7(String ojByColor7) {
		this.ojByColor7 = ojByColor7;
	}

	public String getOjByColor8() {
		return ojByColor8;
	}

	public void setOjByColor8(String ojByColor8) {
		this.ojByColor8 = ojByColor8;
	}

	public String getOjByColor9() {
		return ojByColor9;
	}

	public void setOjByColor9(String ojByColor9) {
		this.ojByColor9 = ojByColor9;
	}

	public String getOjByColor10() {
		return ojByColor10;
	}

	public void setOjByColor10(String ojByColor10) {
		this.ojByColor10 = ojByColor10;
	}

	public String getOjByColor11() {
		return ojByColor11;
	}

	public void setOjByColor11(String ojByColor11) {
		this.ojByColor11 = ojByColor11;
	}

	public String getOjByColor12() {
		return ojByColor12;
	}

	public void setOjByColor12(String ojByColor12) {
		this.ojByColor12 = ojByColor12;
	}

	public String getOjByColor13() {
		return ojByColor13;
	}

	public void setOjByColor13(String ojByColor13) {
		this.ojByColor13 = ojByColor13;
	}

	public String getOjByColor14() {
		return ojByColor14;
	}

	public void setOjByColor14(String ojByColor14) {
		this.ojByColor14 = ojByColor14;
	}

	public String getOjByColor15() {
		return ojByColor15;
	}

	public void setOjByColor15(String ojByColor15) {
		this.ojByColor15 = ojByColor15;
	}

	public String getOjByColor16() {
		return ojByColor16;
	}

	public void setOjByColor16(String ojByColor16) {
		this.ojByColor16 = ojByColor16;
	}

	public Map<String, String> getOjByColorsMap() {
		return ojByColorsMap;
	}

	public void setOjByColorsMap(Map<String, String> ojByColorsMap) {
		this.ojByColorsMap = ojByColorsMap;
	}

	public String getOjVentSpec() {
		return ojVentSpec;
	}

	public void setOjVentSpec(String ojVentSpec) {
		this.ojVentSpec = ojVentSpec;
	}

	public Map<String, String> getOjVentSpecMap() {
		return ojVentSpecMap;
	}

	public void setOjVentSpecMap(Map<String, String> ojVentSpecMap) {
		this.ojVentSpecMap = ojVentSpecMap;
	}

	public String getOjBodyBackMate() {
		return ojBodyBackMate;
	}

	public void setOjBodyBackMate(String ojBodyBackMate) {
		this.ojBodyBackMate = ojBodyBackMate;
	}

	public Map<String, String> getOjBodyBackMateMap() {
		return ojBodyBackMateMap;
	}

	public void setOjBodyBackMateMap(Map<String, String> ojBodyBackMateMap) {
		this.ojBodyBackMateMap = ojBodyBackMateMap;
	}

	public String getOjCuffBackMate() {
		return ojCuffBackMate;
	}

	public void setOjCuffBackMate(String ojCuffBackMate) {
		this.ojCuffBackMate = ojCuffBackMate;
	}

	public Map<String, String> getOjCuffBackMateMap() {
		return ojCuffBackMateMap;
	}

	public void setOjCuffBackMateMap(Map<String, String> ojCuffBackMateMap) {
		this.ojCuffBackMateMap = ojCuffBackMateMap;
	}

	public String getOjBtnMate() {
		return ojBtnMate;
	}

	public void setOjBtnMate(String ojBtnMate) {
		this.ojBtnMate = ojBtnMate;
	}

	public Map<String, String> getOjBtnMateMap() {
		return ojBtnMateMap;
	}

	public void setOjBtnMateMap(Map<String, String> ojBtnMateMap) {
		this.ojBtnMateMap = ojBtnMateMap;
	}

	public String getOjShapeMemory() {
		return ojShapeMemory;
	}

	public void setOjShapeMemory(String ojShapeMemory) {
		this.ojShapeMemory = ojShapeMemory;
	}

	public Map<String, String> getOjShapeMemoryMap() {
		return ojShapeMemoryMap;
	}

	public void setOjShapeMemoryMap(Map<String, String> ojShapeMemoryMap) {
		this.ojShapeMemoryMap = ojShapeMemoryMap;
	}

	public String getOjJacketModel() {
		return ojJacketModel;
	}

	public void setOjJacketModel(String ojJacketModel) {
		this.ojJacketModel = ojJacketModel;
	}

	public Map<String, String> getOjJacketModelMap() {
		return ojJacketModelMap;
	}

	public void setOjJacketModelMap(Map<String, String> ojJacketModelMap) {
		this.ojJacketModelMap = ojJacketModelMap;
	}

	public String getOjBodyBackMateStkNo() {
		return ojBodyBackMateStkNo;
	}

	public void setOjBodyBackMateStkNo(String ojBodyBackMateStkNo) {
		this.ojBodyBackMateStkNo = ojBodyBackMateStkNo;
	}

	public String getOjCuffBackMateStkNo() {
		return ojCuffBackMateStkNo;
	}

	public void setOjCuffBackMateStkNo(String ojCuffBackMateStkNo) {
		this.ojCuffBackMateStkNo = ojCuffBackMateStkNo;
	}

	public String getOjBtnMateStkNo() {
		return ojBtnMateStkNo;
	}

	public void setOjBtnMateStkNo(String ojBtnMateStkNo) {
		this.ojBtnMateStkNo = ojBtnMateStkNo;
	}
    
}
