package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

public class CoOptionGiletStandardInfo implements Serializable {
	private static final long serialVersionUID = -6022359138897696244L;

	// 3Piece
	private Map<String, String> threePieceMap;

	// GILETモデル
	private String ogGiletModel;

	private Map<String, String> ogGiletModelMap;

	// 胸ポケット
	private String ogBreastPkt;

	private Map<String, String> ogBreastPktMap;
	
	private String glBreastPktRtPrice;
	
	// 腰ポケット
	private String ogWaistPkt;

	private Map<String, String> ogWaistPktMap;
	
	private String glWaistPktRtPrice;

	// 腰ポケット形状
	private String ogWaistPktSpec;

	private Map<String, String> ogWaistPktSpecMap;
	
	private String glWaistPktShapeRtPrice;

	// AMFステッチ
	private String ogStitch;

	private Map<String, String> ogStitchMap;
	
	private String glAmfStitchRtPrice;

	// ステッチ箇所変更
	private String ogStitchModify;

	private Map<String, String> ogStitchModifyMap;

	// ステッチ箇所変更箇所
	private String ogStitchModifyPlace;
	private String ogStitchModifyPlace1;
	private String ogStitchModifyPlace2;
	private String ogStitchModifyPlace3;

	private Map<String, String> ogStitchModifyPlaceMap;
	
	private String glStitchPlcRtPrice;

	// ダブルステッチ変更
	private String ogDStitchModify;

	private Map<String, String> ogDStitchModifyMap;
	
	// ダブルステッチ変更箇所
	private String ogDStitchModifyPlace;
	private String ogDStitchModifyPlace1;
	private String ogDStitchModifyPlace2;
	private String ogDStitchModifyPlace3;

	private Map<String, String> ogDStitchModifyPlaceMap;
	
	private String glDblstitchPlcRtPrice;

	// AMF色指定
	private String ogAmfColor;

	private Map<String, String> ogAmfColorMap;
	
	private String glAmfColorRtPrice;

	// AMF糸色
	private String ogAmfColorPlaceAll;

	private Map<String, String> ogAmfColorPlaceAllMap;

	// AMF色指定箇所
	private String ogAmfColorPlace;
	private String ogAmfColorPlace1;
	private String ogAmfColorPlace2;
	private String ogAmfColorPlace3;

	private Map<String, String> ogAmfColorPlaceMap;

	// AMF糸色 襟・ラペル・フロント
	private String ogAmfColor1;

	// AMF糸色 胸ポケット
	private String ogAmfColor2;

	// AMF糸色 腰ポケット
	private String ogAmfColor3;

	// AMF色 key&value
	private Map<String, String> ogAmfColorsMap;

	// ボタンホール色指定
	private String ogBhColor;

	private Map<String, String> ogBhColorMap;
	
	private String glBtnholeColorRtPrice;
	
	// ボタンホール色指定 糸色
	private String ogBhColorPlaceAll;

	private Map<String, String> ogBhColorPlaceAllMap;

	// ボタンホール色指定 箇所
	private String ogBhColorPlace;
	private String ogBhColorPlace1;
	private String ogBhColorPlace2;
	private String ogBhColorPlace3;
	private String ogBhColorPlace4;
	private String ogBhColorPlace5;
	private String ogBhColorPlace6;

	private Map<String, String> ogBhColorPlaceMap;

	// ボタンホール色指定 フロント1
	private String ogBhColor1;

	// ボタンホール色指定 フロント2
	private String ogBhColor2;

	// ボタンホール色指定 フロント3
	private String ogBhColor3;

	// ボタンホール色指定 フロント4
	private String ogBhColor4;

	// ボタンホール色指定 フロント5
	private String ogBhColor5;

	// ボタンホール色指定 フロント6
	private String ogBhColor6;

	// ボタンホール色指定色 key&value
	private Map<String, String> ogBhColorsMap;

	// ボタン付け糸指定
	private String ogByColor;

	private Map<String, String> ogByColorMap;
	
	private String glBtnthreadColorRtPrice;

	// ボタンホール色指定 糸色
	private String ogByColorPlaceAll;

	private Map<String, String> ogByColorPlaceAllMap;

	// ボタンホール色指定 箇所
	private String ogByColorPlace;
	private String ogByColorPlace1;
	private String ogByColorPlace2;
	private String ogByColorPlace3;
	private String ogByColorPlace4;
	private String ogByColorPlace5;
	private String ogByColorPlace6;
	private String ogByColorPlace7;
	private String ogByColorPlace8;
	private String ogByColorPlace9;
	private String ogByColorPlace10;

	private Map<String, String> ogByColorPlaceMap;

	// ボタンホール色指定 フロント下前1
	private String ogByColor1;

	// ボタンホール色指定 フロント下前2
	private String ogByColor2;

	// ボタンホール色指定 フロント下前3
	private String ogByColor3;

	// ボタンホール色指定 フロント下前4
	private String ogByColor4;

	// ボタンホール色指定 フロント下前5
	private String ogByColor5;

	// ボタンホール色指定 フロント下前6
	private String ogByColor6;

	// ボタンホール色指定 フロント上前1
	private String ogByColor7;

	// ボタンホール色指定 フロント上前2
	private String ogByColor8;

	// ボタンホール色指定 フロント上前3
	private String ogByColor9;

	// ボタンホール色指定 フロント上前4
	private String ogByColor10;

	// ボタン付け糸指定糸色 key&value
	private Map<String, String> ogByColorsMap;

	// 背裏地素材
	private String ogBackLiningMate;

	private Map<String, String> ogBackLiningMateMap;
	
	// 背裏地素材品番
	private String ogBackLiningMateStkNo;
	
	private String glBackClothRtPrice;

	// 内側裏地素材
	private String ogInsideLiningMate;

	private Map<String, String> ogInsideLiningMateMap;

	// 内側裏地素材品番
	private String ogInsideLiningMateStkNo;
	
	private String glInnnerClothRtPrice;

	// フロント釦
	private String ogFrontBtnMate;

	private Map<String, String> ogFrontBtnMateMap;

	// フロント釦品番
	private String ogFrontBtnMateStkNo;
	
	private String glFrtBtnRtPrice;

	// バックベルト
	private String ogBackBelt;

	private Map<String, String> ogBackBeltMap;
	
	private String glBackBeltRtPrice;
	
	// ウォッチチェーン
	private String ogWatchChain;

	private Map<String, String> ogWatchChainMap;
	
	private String glWatchChainRtPrice;

	// 品番Map
	private Map<String, String> giletMateMap;

	public Map<String, String> getGiletMateMap() {
		return giletMateMap;
	}

	public void setGiletMateMap(Map<String, String> giletMateMap) {
		this.giletMateMap = giletMateMap;
	}

	public String getOgBreastPkt() {
		return ogBreastPkt;
	}

	public void setOgBreastPkt(String ogBreastPkt) {
		this.ogBreastPkt = ogBreastPkt;
	}

	public Map<String, String> getOgBreastPktMap() {
		return ogBreastPktMap;
	}

	public void setOgBreastPktMap(Map<String, String> ogBreastPktMap) {
		this.ogBreastPktMap = ogBreastPktMap;
	}

	public String getOgWaistPkt() {
		return ogWaistPkt;
	}

	public void setOgWaistPkt(String ogWaistPkt) {
		this.ogWaistPkt = ogWaistPkt;
	}

	public Map<String, String> getOgWaistPktMap() {
		return ogWaistPktMap;
	}

	public void setOgWaistPktMap(Map<String, String> ogWaistPktMap) {
		this.ogWaistPktMap = ogWaistPktMap;
	}

	public String getOgWaistPktSpec() {
		return ogWaistPktSpec;
	}

	public void setOgWaistPktSpec(String ogWaistPktSpec) {
		this.ogWaistPktSpec = ogWaistPktSpec;
	}

	public Map<String, String> getOgWaistPktSpecMap() {
		return ogWaistPktSpecMap;
	}

	public void setOgWaistPktSpecMap(Map<String, String> ogWaistPktSpecMap) {
		this.ogWaistPktSpecMap = ogWaistPktSpecMap;
	}

	public String getOgStitch() {
		return ogStitch;
	}

	public void setOgStitch(String ogStitch) {
		this.ogStitch = ogStitch;
	}

	public Map<String, String> getOgStitchMap() {
		return ogStitchMap;
	}

	public void setOgStitchMap(Map<String, String> ogStitchMap) {
		this.ogStitchMap = ogStitchMap;
	}

	public String getOgStitchModify() {
		return ogStitchModify;
	}

	public void setOgStitchModify(String ogStitchModify) {
		this.ogStitchModify = ogStitchModify;
	}

	public Map<String, String> getOgStitchModifyMap() {
		return ogStitchModifyMap;
	}

	public void setOgStitchModifyMap(Map<String, String> ogStitchModifyMap) {
		this.ogStitchModifyMap = ogStitchModifyMap;
	}

	public Map<String, String> getOgStitchModifyPlaceMap() {
		return ogStitchModifyPlaceMap;
	}

	public void setOgStitchModifyPlaceMap(Map<String, String> ogStitchModifyPlaceMap) {
		this.ogStitchModifyPlaceMap = ogStitchModifyPlaceMap;
	}

	public String getOgAmfColor() {
		return ogAmfColor;
	}

	public void setOgAmfColor(String ogAmfColor) {
		this.ogAmfColor = ogAmfColor;
	}

	public Map<String, String> getOgAmfColorMap() {
		return ogAmfColorMap;
	}

	public void setOgAmfColorMap(Map<String, String> ogAmfColorMap) {
		this.ogAmfColorMap = ogAmfColorMap;
	}

	public String getOgAmfColorPlaceAll() {
		return ogAmfColorPlaceAll;
	}

	public void setOgAmfColorPlaceAll(String ogAmfColorPlaceAll) {
		this.ogAmfColorPlaceAll = ogAmfColorPlaceAll;
	}

	public Map<String, String> getOgAmfColorPlaceAllMap() {
		return ogAmfColorPlaceAllMap;
	}

	public void setOgAmfColorPlaceAllMap(Map<String, String> ogAmfColorPlaceAllMap) {
		this.ogAmfColorPlaceAllMap = ogAmfColorPlaceAllMap;
	}

	public Map<String, String> getOgAmfColorPlaceMap() {
		return ogAmfColorPlaceMap;
	}

	public void setOgAmfColorPlaceMap(Map<String, String> ogAmfColorPlaceMap) {
		this.ogAmfColorPlaceMap = ogAmfColorPlaceMap;
	}

	public String getOgAmfColor1() {
		return ogAmfColor1;
	}

	public void setOgAmfColor1(String ogAmfColor1) {
		this.ogAmfColor1 = ogAmfColor1;
	}

	public String getOgAmfColor2() {
		return ogAmfColor2;
	}

	public void setOgAmfColor2(String ogAmfColor2) {
		this.ogAmfColor2 = ogAmfColor2;
	}

	public String getOgAmfColor3() {
		return ogAmfColor3;
	}

	public void setOgAmfColor3(String ogAmfColor3) {
		this.ogAmfColor3 = ogAmfColor3;
	}

	public Map<String, String> getOgAmfColorsMap() {
		return ogAmfColorsMap;
	}

	public void setOgAmfColorsMap(Map<String, String> ogAmfColorsMap) {
		this.ogAmfColorsMap = ogAmfColorsMap;
	}

	public String getOgBhColor() {
		return ogBhColor;
	}

	public void setOgBhColor(String ogBhColor) {
		this.ogBhColor = ogBhColor;
	}

	public Map<String, String> getOgBhColorMap() {
		return ogBhColorMap;
	}

	public void setOgBhColorMap(Map<String, String> ogBhColorMap) {
		this.ogBhColorMap = ogBhColorMap;
	}

	public String getOgBhColorPlaceAll() {
		return ogBhColorPlaceAll;
	}

	public void setOgBhColorPlaceAll(String ogBhColorPlaceAll) {
		this.ogBhColorPlaceAll = ogBhColorPlaceAll;
	}

	public Map<String, String> getOgBhColorPlaceAllMap() {
		return ogBhColorPlaceAllMap;
	}

	public void setOgBhColorPlaceAllMap(Map<String, String> ogBhColorPlaceAllMap) {
		this.ogBhColorPlaceAllMap = ogBhColorPlaceAllMap;
	}

	public Map<String, String> getOgBhColorPlaceMap() {
		return ogBhColorPlaceMap;
	}

	public void setOgBhColorPlaceMap(Map<String, String> ogBhColorPlaceMap) {
		this.ogBhColorPlaceMap = ogBhColorPlaceMap;
	}

	public String getOgBhColor1() {
		return ogBhColor1;
	}

	public void setOgBhColor1(String ogBhColor1) {
		this.ogBhColor1 = ogBhColor1;
	}

	public String getOgBhColor2() {
		return ogBhColor2;
	}

	public void setOgBhColor2(String ogBhColor2) {
		this.ogBhColor2 = ogBhColor2;
	}

	public String getOgBhColor3() {
		return ogBhColor3;
	}

	public void setOgBhColor3(String ogBhColor3) {
		this.ogBhColor3 = ogBhColor3;
	}

	public String getOgBhColor4() {
		return ogBhColor4;
	}

	public void setOgBhColor4(String ogBhColor4) {
		this.ogBhColor4 = ogBhColor4;
	}

	public String getOgBhColor5() {
		return ogBhColor5;
	}

	public void setOgBhColor5(String ogBhColor5) {
		this.ogBhColor5 = ogBhColor5;
	}

	public String getOgBhColor6() {
		return ogBhColor6;
	}

	public void setOgBhColor6(String ogBhColor6) {
		this.ogBhColor6 = ogBhColor6;
	}

	public Map<String, String> getOgBhColorsMap() {
		return ogBhColorsMap;
	}

	public void setOgBhColorsMap(Map<String, String> ogBhColorsMap) {
		this.ogBhColorsMap = ogBhColorsMap;
	}

	public String getOgByColor() {
		return ogByColor;
	}

	public void setOgByColor(String ogByColor) {
		this.ogByColor = ogByColor;
	}

	public Map<String, String> getOgByColorMap() {
		return ogByColorMap;
	}

	public void setOgByColorMap(Map<String, String> ogByColorMap) {
		this.ogByColorMap = ogByColorMap;
	}

	public String getOgByColorPlaceAll() {
		return ogByColorPlaceAll;
	}

	public void setOgByColorPlaceAll(String ogByColorPlaceAll) {
		this.ogByColorPlaceAll = ogByColorPlaceAll;
	}

	public Map<String, String> getOgByColorPlaceAllMap() {
		return ogByColorPlaceAllMap;
	}

	public void setOgByColorPlaceAllMap(Map<String, String> ogByColorPlaceAllMap) {
		this.ogByColorPlaceAllMap = ogByColorPlaceAllMap;
	}

	public Map<String, String> getOgByColorPlaceMap() {
		return ogByColorPlaceMap;
	}

	public void setOgByColorPlaceMap(Map<String, String> ogByColorPlaceMap) {
		this.ogByColorPlaceMap = ogByColorPlaceMap;
	}

	public String getOgByColor1() {
		return ogByColor1;
	}

	public void setOgByColor1(String ogByColor1) {
		this.ogByColor1 = ogByColor1;
	}

	public String getOgByColor2() {
		return ogByColor2;
	}

	public void setOgByColor2(String ogByColor2) {
		this.ogByColor2 = ogByColor2;
	}

	public String getOgByColor3() {
		return ogByColor3;
	}

	public void setOgByColor3(String ogByColor3) {
		this.ogByColor3 = ogByColor3;
	}

	public String getOgByColor4() {
		return ogByColor4;
	}

	public void setOgByColor4(String ogByColor4) {
		this.ogByColor4 = ogByColor4;
	}

	public String getOgByColor5() {
		return ogByColor5;
	}

	public void setOgByColor5(String ogByColor5) {
		this.ogByColor5 = ogByColor5;
	}

	public String getOgByColor6() {
		return ogByColor6;
	}

	public void setOgByColor6(String ogByColor6) {
		this.ogByColor6 = ogByColor6;
	}

	public String getOgByColor7() {
		return ogByColor7;
	}

	public void setOgByColor7(String ogByColor7) {
		this.ogByColor7 = ogByColor7;
	}

	public String getOgByColor8() {
		return ogByColor8;
	}

	public void setOgByColor8(String ogByColor8) {
		this.ogByColor8 = ogByColor8;
	}

	public String getOgByColor9() {
		return ogByColor9;
	}

	public void setOgByColor9(String ogByColor9) {
		this.ogByColor9 = ogByColor9;
	}

	public String getOgByColor10() {
		return ogByColor10;
	}

	public void setOgByColor10(String ogByColor10) {
		this.ogByColor10 = ogByColor10;
	}

	public Map<String, String> getOgByColorsMap() {
		return ogByColorsMap;
	}

	public void setOgByColorsMap(Map<String, String> ogByColorsMap) {
		this.ogByColorsMap = ogByColorsMap;
	}

	public String getOgBackLiningMate() {
		return ogBackLiningMate;
	}

	public void setOgBackLiningMate(String ogBackLiningMate) {
		this.ogBackLiningMate = ogBackLiningMate;
	}

	public Map<String, String> getOgBackLiningMateMap() {
		return ogBackLiningMateMap;
	}

	public void setOgBackLiningMateMap(Map<String, String> ogBackLiningMateMap) {
		this.ogBackLiningMateMap = ogBackLiningMateMap;
	}

	public String getOgInsideLiningMate() {
		return ogInsideLiningMate;
	}

	public void setOgInsideLiningMate(String ogInsideLiningMate) {
		this.ogInsideLiningMate = ogInsideLiningMate;
	}

	public Map<String, String> getOgInsideLiningMateMap() {
		return ogInsideLiningMateMap;
	}

	public void setOgInsideLiningMateMap(Map<String, String> ogInsideLiningMateMap) {
		this.ogInsideLiningMateMap = ogInsideLiningMateMap;
	}

	public String getOgFrontBtnMate() {
		return ogFrontBtnMate;
	}

	public void setOgFrontBtnMate(String ogFrontBtnMate) {
		this.ogFrontBtnMate = ogFrontBtnMate;
	}

	public Map<String, String> getOgFrontBtnMateMap() {
		return ogFrontBtnMateMap;
	}

	public void setOgFrontBtnMateMap(Map<String, String> ogFrontBtnMateMap) {
		this.ogFrontBtnMateMap = ogFrontBtnMateMap;
	}

	public String getOgBackBelt() {
		return ogBackBelt;
	}

	public void setOgBackBelt(String ogBackBelt) {
		this.ogBackBelt = ogBackBelt;
	}

	public Map<String, String> getOgBackBeltMap() {
		return ogBackBeltMap;
	}

	public void setOgBackBeltMap(Map<String, String> ogBackBeltMap) {
		this.ogBackBeltMap = ogBackBeltMap;
	}

	public String getOgWatchChain() {
		return ogWatchChain;
	}

	public void setOgWatchChain(String ogWatchChain) {
		this.ogWatchChain = ogWatchChain;
	}

	public Map<String, String> getOgWatchChainMap() {
		return ogWatchChainMap;
	}

	public void setOgWatchChainMap(Map<String, String> ogWatchChainMap) {
		this.ogWatchChainMap = ogWatchChainMap;
	}

	public String getOgGiletModel() {
		return ogGiletModel;
	}

	public void setOgGiletModel(String ogGiletModel) {
		this.ogGiletModel = ogGiletModel;
	}

	public Map<String, String> getOgGiletModelMap() {
		return ogGiletModelMap;
	}

	public void setOgGiletModelMap(Map<String, String> ogGiletModelMap) {
		this.ogGiletModelMap = ogGiletModelMap;
	}

	public String getOgBackLiningMateStkNo() {
		return ogBackLiningMateStkNo;
	}

	public void setOgBackLiningMateStkNo(String ogBackLiningMateStkNo) {
		this.ogBackLiningMateStkNo = ogBackLiningMateStkNo;
	}

	public String getOgInsideLiningMateStkNo() {
		return ogInsideLiningMateStkNo;
	}

	public void setOgInsideLiningMateStkNo(String ogInsideLiningMateStkNo) {
		this.ogInsideLiningMateStkNo = ogInsideLiningMateStkNo;
	}

	public String getOgFrontBtnMateStkNo() {
		return ogFrontBtnMateStkNo;
	}

	public void setOgFrontBtnMateStkNo(String ogFrontBtnMateStkNo) {
		this.ogFrontBtnMateStkNo = ogFrontBtnMateStkNo;
	}

	public Map<String, String> getThreePieceMap() {
		return threePieceMap;
	}

	public void setThreePieceMap(Map<String, String> threePieceMap) {
		this.threePieceMap = threePieceMap;
	}

	public String getOgDStitchModify() {
		return ogDStitchModify;
	}

	public void setOgDStitchModify(String ogDStitchModify) {
		this.ogDStitchModify = ogDStitchModify;
	}

	public Map<String, String> getOgDStitchModifyMap() {
		return ogDStitchModifyMap;
	}

	public void setOgDStitchModifyMap(Map<String, String> ogDStitchModifyMap) {
		this.ogDStitchModifyMap = ogDStitchModifyMap;
	}

	public Map<String, String> getOgDStitchModifyPlaceMap() {
		return ogDStitchModifyPlaceMap;
	}

	public void setOgDStitchModifyPlaceMap(Map<String, String> ogDStitchModifyPlaceMap) {
		this.ogDStitchModifyPlaceMap = ogDStitchModifyPlaceMap;
	}
	
	

	public String getGlBreastPktRtPrice() {
		return glBreastPktRtPrice;
	}

	public void setGlBreastPktRtPrice(String glBreastPktRtPrice) {
		this.glBreastPktRtPrice = glBreastPktRtPrice;
	}

	public String getGlWaistPktRtPrice() {
		return glWaistPktRtPrice;
	}

	public void setGlWaistPktRtPrice(String glWaistPktRtPrice) {
		this.glWaistPktRtPrice = glWaistPktRtPrice;
	}

	public String getGlWaistPktShapeRtPrice() {
		return glWaistPktShapeRtPrice;
	}

	public void setGlWaistPktShapeRtPrice(String glWaistPktShapeRtPrice) {
		this.glWaistPktShapeRtPrice = glWaistPktShapeRtPrice;
	}

	public String getGlAmfStitchRtPrice() {
		return glAmfStitchRtPrice;
	}

	public void setGlAmfStitchRtPrice(String glAmfStitchRtPrice) {
		this.glAmfStitchRtPrice = glAmfStitchRtPrice;
	}

	public String getGlStitchPlcRtPrice() {
		return glStitchPlcRtPrice;
	}

	public void setGlStitchPlcRtPrice(String glStitchPlcRtPrice) {
		this.glStitchPlcRtPrice = glStitchPlcRtPrice;
	}

	public String getGlDblstitchPlcRtPrice() {
		return glDblstitchPlcRtPrice;
	}

	public void setGlDblstitchPlcRtPrice(String glDblstitchPlcRtPrice) {
		this.glDblstitchPlcRtPrice = glDblstitchPlcRtPrice;
	}

	public String getGlAmfColorRtPrice() {
		return glAmfColorRtPrice;
	}

	public void setGlAmfColorRtPrice(String glAmfColorRtPrice) {
		this.glAmfColorRtPrice = glAmfColorRtPrice;
	}

	public String getGlBtnholeColorRtPrice() {
		return glBtnholeColorRtPrice;
	}

	public void setGlBtnholeColorRtPrice(String glBtnholeColorRtPrice) {
		this.glBtnholeColorRtPrice = glBtnholeColorRtPrice;
	}

	public String getGlBtnthreadColorRtPrice() {
		return glBtnthreadColorRtPrice;
	}

	public void setGlBtnthreadColorRtPrice(String glBtnthreadColorRtPrice) {
		this.glBtnthreadColorRtPrice = glBtnthreadColorRtPrice;
	}

	public String getGlBackClothRtPrice() {
		return glBackClothRtPrice;
	}

	public void setGlBackClothRtPrice(String glBackClothRtPrice) {
		this.glBackClothRtPrice = glBackClothRtPrice;
	}

	public String getGlInnnerClothRtPrice() {
		return glInnnerClothRtPrice;
	}

	public void setGlInnnerClothRtPrice(String glInnnerClothRtPrice) {
		this.glInnnerClothRtPrice = glInnnerClothRtPrice;
	}

	public String getGlFrtBtnRtPrice() {
		return glFrtBtnRtPrice;
	}

	public void setGlFrtBtnRtPrice(String glFrtBtnRtPrice) {
		this.glFrtBtnRtPrice = glFrtBtnRtPrice;
	}

	public String getGlBackBeltRtPrice() {
		return glBackBeltRtPrice;
	}

	public void setGlBackBeltRtPrice(String glBackBeltRtPrice) {
		this.glBackBeltRtPrice = glBackBeltRtPrice;
	}

	public String getGlWatchChainRtPrice() {
		return glWatchChainRtPrice;
	}

	public void setGlWatchChainRtPrice(String glWatchChainRtPrice) {
		this.glWatchChainRtPrice = glWatchChainRtPrice;
	}

	public String getOgStitchModifyPlace1() {
		return ogStitchModifyPlace1;
	}

	public void setOgStitchModifyPlace1(String ogStitchModifyPlace1) {
		this.ogStitchModifyPlace1 = ogStitchModifyPlace1;
	}

	public String getOgStitchModifyPlace2() {
		return ogStitchModifyPlace2;
	}

	public void setOgStitchModifyPlace2(String ogStitchModifyPlace2) {
		this.ogStitchModifyPlace2 = ogStitchModifyPlace2;
	}

	public String getOgStitchModifyPlace3() {
		return ogStitchModifyPlace3;
	}

	public void setOgStitchModifyPlace3(String ogStitchModifyPlace3) {
		this.ogStitchModifyPlace3 = ogStitchModifyPlace3;
	}

	public String getOgDStitchModifyPlace1() {
		return ogDStitchModifyPlace1;
	}

	public void setOgDStitchModifyPlace1(String ogDStitchModifyPlace1) {
		this.ogDStitchModifyPlace1 = ogDStitchModifyPlace1;
	}

	public String getOgDStitchModifyPlace2() {
		return ogDStitchModifyPlace2;
	}

	public void setOgDStitchModifyPlace2(String ogDStitchModifyPlace2) {
		this.ogDStitchModifyPlace2 = ogDStitchModifyPlace2;
	}

	public String getOgDStitchModifyPlace3() {
		return ogDStitchModifyPlace3;
	}

	public void setOgDStitchModifyPlace3(String ogDStitchModifyPlace3) {
		this.ogDStitchModifyPlace3 = ogDStitchModifyPlace3;
	}

	public String getOgAmfColorPlace1() {
		return ogAmfColorPlace1;
	}

	public void setOgAmfColorPlace1(String ogAmfColorPlace1) {
		this.ogAmfColorPlace1 = ogAmfColorPlace1;
	}

	public String getOgAmfColorPlace2() {
		return ogAmfColorPlace2;
	}

	public void setOgAmfColorPlace2(String ogAmfColorPlace2) {
		this.ogAmfColorPlace2 = ogAmfColorPlace2;
	}

	public String getOgAmfColorPlace3() {
		return ogAmfColorPlace3;
	}

	public void setOgAmfColorPlace3(String ogAmfColorPlace3) {
		this.ogAmfColorPlace3 = ogAmfColorPlace3;
	}

	public String getOgBhColorPlace1() {
		return ogBhColorPlace1;
	}

	public void setOgBhColorPlace1(String ogBhColorPlace1) {
		this.ogBhColorPlace1 = ogBhColorPlace1;
	}

	public String getOgBhColorPlace2() {
		return ogBhColorPlace2;
	}

	public void setOgBhColorPlace2(String ogBhColorPlace2) {
		this.ogBhColorPlace2 = ogBhColorPlace2;
	}

	public String getOgBhColorPlace3() {
		return ogBhColorPlace3;
	}

	public void setOgBhColorPlace3(String ogBhColorPlace3) {
		this.ogBhColorPlace3 = ogBhColorPlace3;
	}

	public String getOgBhColorPlace4() {
		return ogBhColorPlace4;
	}

	public void setOgBhColorPlace4(String ogBhColorPlace4) {
		this.ogBhColorPlace4 = ogBhColorPlace4;
	}

	public String getOgBhColorPlace5() {
		return ogBhColorPlace5;
	}

	public void setOgBhColorPlace5(String ogBhColorPlace5) {
		this.ogBhColorPlace5 = ogBhColorPlace5;
	}

	public String getOgBhColorPlace6() {
		return ogBhColorPlace6;
	}

	public void setOgBhColorPlace6(String ogBhColorPlace6) {
		this.ogBhColorPlace6 = ogBhColorPlace6;
	}

	public String getOgByColorPlace1() {
		return ogByColorPlace1;
	}

	public void setOgByColorPlace1(String ogByColorPlace1) {
		this.ogByColorPlace1 = ogByColorPlace1;
	}

	public String getOgByColorPlace2() {
		return ogByColorPlace2;
	}

	public void setOgByColorPlace2(String ogByColorPlace2) {
		this.ogByColorPlace2 = ogByColorPlace2;
	}

	public String getOgByColorPlace3() {
		return ogByColorPlace3;
	}

	public void setOgByColorPlace3(String ogByColorPlace3) {
		this.ogByColorPlace3 = ogByColorPlace3;
	}

	public String getOgByColorPlace4() {
		return ogByColorPlace4;
	}

	public void setOgByColorPlace4(String ogByColorPlace4) {
		this.ogByColorPlace4 = ogByColorPlace4;
	}

	public String getOgByColorPlace5() {
		return ogByColorPlace5;
	}

	public void setOgByColorPlace5(String ogByColorPlace5) {
		this.ogByColorPlace5 = ogByColorPlace5;
	}

	public String getOgByColorPlace6() {
		return ogByColorPlace6;
	}

	public void setOgByColorPlace6(String ogByColorPlace6) {
		this.ogByColorPlace6 = ogByColorPlace6;
	}

	public String getOgByColorPlace7() {
		return ogByColorPlace7;
	}

	public void setOgByColorPlace7(String ogByColorPlace7) {
		this.ogByColorPlace7 = ogByColorPlace7;
	}

	public String getOgByColorPlace8() {
		return ogByColorPlace8;
	}

	public void setOgByColorPlace8(String ogByColorPlace8) {
		this.ogByColorPlace8 = ogByColorPlace8;
	}

	public String getOgByColorPlace9() {
		return ogByColorPlace9;
	}

	public void setOgByColorPlace9(String ogByColorPlace9) {
		this.ogByColorPlace9 = ogByColorPlace9;
	}

	public String getOgByColorPlace10() {
		return ogByColorPlace10;
	}

	public void setOgByColorPlace10(String ogByColorPlace10) {
		this.ogByColorPlace10 = ogByColorPlace10;
	}

	public String getOgStitchModifyPlace() {
		return ogStitchModifyPlace;
	}

	public void setOgStitchModifyPlace(String ogStitchModifyPlace) {
		this.ogStitchModifyPlace = ogStitchModifyPlace;
	}

	public String getOgDStitchModifyPlace() {
		return ogDStitchModifyPlace;
	}

	public void setOgDStitchModifyPlace(String ogDStitchModifyPlace) {
		this.ogDStitchModifyPlace = ogDStitchModifyPlace;
	}

	public String getOgAmfColorPlace() {
		return ogAmfColorPlace;
	}

	public void setOgAmfColorPlace(String ogAmfColorPlace) {
		this.ogAmfColorPlace = ogAmfColorPlace;
	}

	public String getOgBhColorPlace() {
		return ogBhColorPlace;
	}

	public void setOgBhColorPlace(String ogBhColorPlace) {
		this.ogBhColorPlace = ogBhColorPlace;
	}

	public String getOgByColorPlace() {
		return ogByColorPlace;
	}

	public void setOgByColorPlace(String ogByColorPlace) {
		this.ogByColorPlace = ogByColorPlace;
	}

}
