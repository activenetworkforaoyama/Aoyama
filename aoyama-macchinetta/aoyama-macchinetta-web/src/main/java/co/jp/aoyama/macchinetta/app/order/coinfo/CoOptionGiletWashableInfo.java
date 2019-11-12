package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.GlWaBackLiningMateItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.GlWaItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.GlWaWaistPktSpecItem;


public class CoOptionGiletWashableInfo implements Serializable {
	private static final long serialVersionUID = -4719132036199041997L;
	
	//GILETモデル
	@NotBlank(groups = { GlWaItem.class }, message = "Giletのモデルを入力して下さい。")
	private String wgGiletModel;
	
	private Map<String, String> wgGiletModelMap;
	
	// 胸ポケット
	@NotBlank(groups = { GlWaItem.class }, message = "Giletの胸ポケットを入力して下さい。")
	private String wgBreastPkt;

	private Map<String, String> wgBreastPktMap;
	
	private String glBreastPktRtPrice;

	// 腰ポケット
	@NotBlank(groups = { GlWaItem.class }, message = "Giletの腰ポケットを入力して下さい。")
	private String wgWaistPkt;

	private Map<String, String> wgWaistPktMap;
	
	private String glWaistPktRtPrice;

	// 腰ポケット形状
	@NotBlank(groups = { GlWaWaistPktSpecItem.class }, message = "Giletの腰ポケット形状を入力して下さい。")
	private String wgWaistPktSpec;

	private Map<String, String> wgWaistPktSpecMap;
	
	private String glWaistPktShapeRtPrice;

	// ステッチ種類
	@NotBlank(groups = { GlWaItem.class }, message = "Giletのステッチ種類を入力して下さい。")
	private String wgStitch;

	private Map<String, String> wgCoStitchMap;
	
	private String glAmfStitchRtPrice;

	// ステッチ箇所変更
	@NotBlank(groups = { GlWaItem.class }, message = "Giletのステッチ種類を入力して下さい。")
	private String wgStitchModify;

	private Map<String, String> wgStitchModifyMap;
	
	private String glStitchPlcRtPrice;

	// ステッチ変更箇所
	private String wgStitchModifyPlace;
	private String wgStitchModifyPlace1;
	private String wgStitchModifyPlace2;
	private String wgStitchModifyPlace3;

	private Map<String, String> wgStitchModifyPlaceMap;
	
	//ダブルステッチ変更
	@NotBlank(groups = { GlWaItem.class }, message = "Giletのダブルステッチ変更を入力して下さい。")
	private String wgDStitchModify;
	
	private Map<String, String> wgDStitchModifyMap;
	
	private String glDblstitchPlcRtPrice;
	
	//ダブルステッチ変更箇所
	private String wgDStitchModifyPlace;
	private String wgDStitchModifyPlace1;
	private String wgDStitchModifyPlace2;
	private String wgDStitchModifyPlace3;
	
	private Map<String, String> wgDStitchModifyPlaceMap;

	// AMF色指定
	@NotBlank(groups = { GlWaItem.class }, message = "GiletのAMF色指定を入力して下さい。")
	private String wgAmfColor;

	private Map<String, String> wgAmfColorMap;
	
	private String glAmfColorRtPrice;

	// AMF糸色,AMF色指定糸色(プルダウン)
	private String wgAmfColorPlaceAll;

	private Map<String, String> wgAmfColorPlaceAllMap;

	// AMF色指定箇所
	private String wgAmfColorPlace;
	private String wgAmfColorPlace1;
	private String wgAmfColorPlace2;
	private String wgAmfColorPlace3;
	
	private Map<String, String> wgAmfColorPlaceMap;

	private String wgAmfAllColor;
	// AMF糸色 襟・ラペル・フロント
	private String wgAmfColor1;
	// AMF糸色 胸ポケット
	private String wgAmfColor2;
	// AMF糸色 腰ポケット
	private String wgAmfColor3;

	// AMF色 key&value
	private Map<String, String> wgAmfColorsMap;

	// ボタンホール色指定
	@NotBlank(groups = { GlWaItem.class }, message = "Giletのボタンホール色指定を入力して下さい。")
	private String wgBhColor;

	private Map<String, String> wgBhColorMap;
	
	private String glBtnholeColorRtPrice;

	// ボタンホール色指定 糸色,ボタンホール色指定糸色(プルダウン)
	private String wgBhColorPlaceAll;

	private Map<String, String> wgBhColorPlaceAllMap;

	// ボタンホール色指定 箇所
	private String wgBhColorPlace;
	private String wgBhColorPlace1;
	private String wgBhColorPlace2;
	private String wgBhColorPlace3;
	private String wgBhColorPlace4;
	private String wgBhColorPlace5;
	private String wgBhColorPlace6;

	private Map<String, String> wgBhColorPlaceMap;

	private String wgBhAllColor;
	// ボタンホール色指定 フロント1
	private String wgBhColor1;
	// ボタンホール色指定 フロント2
	private String wgBhColor2;
	// ボタンホール色指定 フロント3
	private String wgBhColor3;
	// ボタンホール色指定 フロント4
	private String wgBhColor4;
	// ボタンホール色指定 フロント5
	private String wgBhColor5;
	// ボタンホール色指定 フロント6
	private String wgBhColor6;

	// ボタンホール色指定色 key&value
	private Map<String, String> wgBhColorsMap;

	// ボタン付け糸指定
	@NotBlank(groups = { GlWaItem.class }, message = "Giletのボタン付け糸指定を入力して下さい。")
	private String wgByColor;

	private Map<String, String> wgByColorMap;
	
	private String glBtnthreadColorRtPrice;

	// ボタンホール色指定 糸色,ボタン付け糸指定糸色(プルダウン)
	private String wgByColorPlaceAll;

	private Map<String, String> wgByColorPlaceAllMap;

	// ボタンホール色指定 箇所
	private String wgByColorPlace;
	private String wgByColorPlace1;
	private String wgByColorPlace2;
	private String wgByColorPlace3;
	private String wgByColorPlace4;
	private String wgByColorPlace5;
	private String wgByColorPlace6;
	private String wgByColorPlace7;
	private String wgByColorPlace8;
	private String wgByColorPlace9;
	private String wgByColorPlace10;

	private Map<String, String> wgByColorPlaceMap;

	private String wgByAllColor;
	// ボタンホール色指定 フロント下前1
	private String wgByColor1;
	// ボタンホール色指定 フロント下前2
	private String wgByColor2;
	// ボタンホール色指定 フロント下前3
	private String wgByColor3;
	// ボタンホール色指定 フロント下前4
	private String wgByColor4;
	// ボタンホール色指定 フロント下前5
	private String wgByColor5;
	// ボタンホール色指定 フロント下前6
	private String wgByColor6;
	// ボタンホール色指定 フロント上前1
	private String wgByColor7;
	// ボタンホール色指定 フロント上前2
	private String wgByColor8;
	// ボタンホール色指定 フロント上前3
	private String wgByColor9;
	// ボタンホール色指定 フロント上前4
	private String wgByColor10;

	// ボタン付け糸指定糸色 key&value
	private Map<String, String> wgByColorsMap;

	// 背裏地素材
	@NotBlank(groups = { GlWaItem.class }, message = "Giletの背裏地素材を入力して下さい。")
	private String wgBackLiningMate;

	private Map<String, String> wgBackLiningMateMap;
	
	private String glBackClothRtPrice;
	
	// 背裏地素材品番
	@NotBlank(groups = { GlWaBackLiningMateItem.class }, message = "Giletの背裏地素材品番を入力して下さい。")
	private String wgBackLiningMateStkNo;

	// 内側裏地素材
	@NotBlank(groups = { GlWaItem.class }, message = "Giletの内側裏地素材を入力して下さい。")
	private String wgInsideLiningMate;

	private Map<String, String> wgInsideLiningMateMap;
	
	private String glInnnerClothRtPrice;
	
	// 内側裏地素材品番
	@NotBlank(groups = { GlWaItem.class }, message = "Giletの内側裏地素材品番を入力して下さい。")
	private String wgInsideLiningMateStkNo;

	// 釦素材
	@NotBlank(groups = { GlWaItem.class }, message = "Giletの釦素材を入力して下さい。")
	private String wgFrontBtnMate;

	private Map<String, String> wgFrontBtnMateMap;
	
	private String glFrtBtnRtPrice;
	
	//釦素材品番
	@NotBlank(groups = { GlWaItem.class }, message = "Giletの釦素材品番を入力して下さい。")
	private String wgFrontBtnMateStkNo;

	// バックベルト
	@NotBlank(groups = { GlWaItem.class }, message = "Giletのバックベルトを入力して下さい。")
	private String wgBackBelt;

	private Map<String, String> wgBackBeltMap;
	
	private String glBackBeltRtPrice;

	// ウォッチチェーン
	@NotBlank(groups = { GlWaItem.class }, message = "Giletのウォッチチェーンを入力して下さい。")
	private String wgWatchChain;

	private Map<String, String> wgWatchChainMap;
	
	private String glWatchChainRtPrice;

	public String getWgBreastPkt() {
		return wgBreastPkt;
	}

	public void setWgBreastPkt(String wgBreastPkt) {
		this.wgBreastPkt = wgBreastPkt;
	}

	public Map<String, String> getWgBreastPktMap() {
		return wgBreastPktMap;
	}

	public void setWgBreastPktMap(Map<String, String> wgBreastPktMap) {
		this.wgBreastPktMap = wgBreastPktMap;
	}

	public String getWgWaistPkt() {
		return wgWaistPkt;
	}

	public void setWgWaistPkt(String wgWaistPkt) {
		this.wgWaistPkt = wgWaistPkt;
	}

	public Map<String, String> getWgWaistPktMap() {
		return wgWaistPktMap;
	}

	public void setWgWaistPktMap(Map<String, String> wgWaistPktMap) {
		this.wgWaistPktMap = wgWaistPktMap;
	}

	public String getWgWaistPktSpec() {
		return wgWaistPktSpec;
	}

	public void setWgWaistPktSpec(String wgWaistPktSpec) {
		this.wgWaistPktSpec = wgWaistPktSpec;
	}

	public Map<String, String> getWgWaistPktSpecMap() {
		return wgWaistPktSpecMap;
	}

	public void setWgWaistPktSpecMap(Map<String, String> wgWaistPktSpecMap) {
		this.wgWaistPktSpecMap = wgWaistPktSpecMap;
	}

	public String getWgStitch() {
		return wgStitch;
	}

	public void setWgStitch(String wgStitch) {
		this.wgStitch = wgStitch;
	}

	public Map<String, String> getWgCoStitchMap() {
		return wgCoStitchMap;
	}

	public void setWgCoStitchMap(Map<String, String> wgCoStitchMap) {
		this.wgCoStitchMap = wgCoStitchMap;
	}

	public String getWgStitchModify() {
		return wgStitchModify;
	}

	public void setWgStitchModify(String wgStitchModify) {
		this.wgStitchModify = wgStitchModify;
	}

	public Map<String, String> getWgStitchModifyMap() {
		return wgStitchModifyMap;
	}

	public void setWgStitchModifyMap(Map<String, String> wgStitchModifyMap) {
		this.wgStitchModifyMap = wgStitchModifyMap;
	}

	public Map<String, String> getWgStitchModifyPlaceMap() {
		return wgStitchModifyPlaceMap;
	}

	public void setWgStitchModifyPlaceMap(Map<String, String> wgStitchModifyPlaceMap) {
		this.wgStitchModifyPlaceMap = wgStitchModifyPlaceMap;
	}

	public String getWgAmfColor() {
		return wgAmfColor;
	}

	public void setWgAmfColor(String wgAmfColor) {
		this.wgAmfColor = wgAmfColor;
	}

	public Map<String, String> getWgAmfColorMap() {
		return wgAmfColorMap;
	}

	public void setWgAmfColorMap(Map<String, String> wgAmfColorMap) {
		this.wgAmfColorMap = wgAmfColorMap;
	}

	public String getWgAmfColorPlaceAll() {
		return wgAmfColorPlaceAll;
	}

	public void setWgAmfColorPlaceAll(String wgAmfColorPlaceAll) {
		this.wgAmfColorPlaceAll = wgAmfColorPlaceAll;
	}

	public Map<String, String> getWgAmfColorPlaceAllMap() {
		return wgAmfColorPlaceAllMap;
	}

	public void setWgAmfColorPlaceAllMap(Map<String, String> wgAmfColorPlaceAllMap) {
		this.wgAmfColorPlaceAllMap = wgAmfColorPlaceAllMap;
	}

	public Map<String, String> getWgAmfColorPlaceMap() {
		return wgAmfColorPlaceMap;
	}

	public void setWgAmfColorPlaceMap(Map<String, String> wgAmfColorPlaceMap) {
		this.wgAmfColorPlaceMap = wgAmfColorPlaceMap;
	}

	public String getWgAmfColor1() {
		return wgAmfColor1;
	}

	public void setWgAmfColor1(String wgAmfColor1) {
		this.wgAmfColor1 = wgAmfColor1;
	}

	public String getWgAmfColor2() {
		return wgAmfColor2;
	}

	public void setWgAmfColor2(String wgAmfColor2) {
		this.wgAmfColor2 = wgAmfColor2;
	}

	public String getWgAmfColor3() {
		return wgAmfColor3;
	}

	public void setWgAmfColor3(String wgAmfColor3) {
		this.wgAmfColor3 = wgAmfColor3;
	}

	public Map<String, String> getWgAmfColorsMap() {
		return wgAmfColorsMap;
	}

	public void setWgAmfColorsMap(Map<String, String> wgAmfColorsMap) {
		this.wgAmfColorsMap = wgAmfColorsMap;
	}

	public String getWgBhColor() {
		return wgBhColor;
	}

	public void setWgBhColor(String wgBhColor) {
		this.wgBhColor = wgBhColor;
	}

	public Map<String, String> getWgBhColorMap() {
		return wgBhColorMap;
	}

	public void setWgBhColorMap(Map<String, String> wgBhColorMap) {
		this.wgBhColorMap = wgBhColorMap;
	}

	public String getWgBhColorPlaceAll() {
		return wgBhColorPlaceAll;
	}

	public void setWgBhColorPlaceAll(String wgBhColorPlaceAll) {
		this.wgBhColorPlaceAll = wgBhColorPlaceAll;
	}

	public Map<String, String> getWgBhColorPlaceAllMap() {
		return wgBhColorPlaceAllMap;
	}

	public void setWgBhColorPlaceAllMap(Map<String, String> wgBhColorPlaceAllMap) {
		this.wgBhColorPlaceAllMap = wgBhColorPlaceAllMap;
	}

	public Map<String, String> getWgBhColorPlaceMap() {
		return wgBhColorPlaceMap;
	}

	public void setWgBhColorPlaceMap(Map<String, String> wgBhColorPlaceMap) {
		this.wgBhColorPlaceMap = wgBhColorPlaceMap;
	}

	public String getWgBhColor1() {
		return wgBhColor1;
	}

	public void setWgBhColor1(String wgBhColor1) {
		this.wgBhColor1 = wgBhColor1;
	}

	public String getWgBhColor2() {
		return wgBhColor2;
	}

	public void setWgBhColor2(String wgBhColor2) {
		this.wgBhColor2 = wgBhColor2;
	}

	public String getWgBhColor3() {
		return wgBhColor3;
	}

	public void setWgBhColor3(String wgBhColor3) {
		this.wgBhColor3 = wgBhColor3;
	}

	public String getWgBhColor4() {
		return wgBhColor4;
	}

	public void setWgBhColor4(String wgBhColor4) {
		this.wgBhColor4 = wgBhColor4;
	}

	public String getWgBhColor5() {
		return wgBhColor5;
	}

	public void setWgBhColor5(String wgBhColor5) {
		this.wgBhColor5 = wgBhColor5;
	}

	public String getWgBhColor6() {
		return wgBhColor6;
	}

	public void setWgBhColor6(String wgBhColor6) {
		this.wgBhColor6 = wgBhColor6;
	}

	public Map<String, String> getWgBhColorsMap() {
		return wgBhColorsMap;
	}

	public void setWgBhColorsMap(Map<String, String> wgBhColorsMap) {
		this.wgBhColorsMap = wgBhColorsMap;
	}

	public String getWgByColor() {
		return wgByColor;
	}

	public void setWgByColor(String wgByColor) {
		this.wgByColor = wgByColor;
	}

	public Map<String, String> getWgByColorMap() {
		return wgByColorMap;
	}

	public void setWgByColorMap(Map<String, String> wgByColorMap) {
		this.wgByColorMap = wgByColorMap;
	}

	public String getWgByColorPlaceAll() {
		return wgByColorPlaceAll;
	}

	public void setWgByColorPlaceAll(String wgByColorPlaceAll) {
		this.wgByColorPlaceAll = wgByColorPlaceAll;
	}

	public Map<String, String> getWgByColorPlaceAllMap() {
		return wgByColorPlaceAllMap;
	}

	public void setWgByColorPlaceAllMap(Map<String, String> wgByColorPlaceAllMap) {
		this.wgByColorPlaceAllMap = wgByColorPlaceAllMap;
	}

	public Map<String, String> getWgByColorPlaceMap() {
		return wgByColorPlaceMap;
	}

	public void setWgByColorPlaceMap(Map<String, String> wgByColorPlaceMap) {
		this.wgByColorPlaceMap = wgByColorPlaceMap;
	}

	public String getWgByColor1() {
		return wgByColor1;
	}

	public void setWgByColor1(String wgByColor1) {
		this.wgByColor1 = wgByColor1;
	}

	public String getWgByColor2() {
		return wgByColor2;
	}

	public void setWgByColor2(String wgByColor2) {
		this.wgByColor2 = wgByColor2;
	}

	public String getWgByColor3() {
		return wgByColor3;
	}

	public void setWgByColor3(String wgByColor3) {
		this.wgByColor3 = wgByColor3;
	}

	public String getWgByColor4() {
		return wgByColor4;
	}

	public void setWgByColor4(String wgByColor4) {
		this.wgByColor4 = wgByColor4;
	}

	public String getWgByColor5() {
		return wgByColor5;
	}

	public void setWgByColor5(String wgByColor5) {
		this.wgByColor5 = wgByColor5;
	}

	public String getWgByColor6() {
		return wgByColor6;
	}

	public void setWgByColor6(String wgByColor6) {
		this.wgByColor6 = wgByColor6;
	}

	public String getWgByColor7() {
		return wgByColor7;
	}

	public void setWgByColor7(String wgByColor7) {
		this.wgByColor7 = wgByColor7;
	}

	public String getWgByColor8() {
		return wgByColor8;
	}

	public void setWgByColor8(String wgByColor8) {
		this.wgByColor8 = wgByColor8;
	}

	public String getWgByColor9() {
		return wgByColor9;
	}

	public void setWgByColor9(String wgByColor9) {
		this.wgByColor9 = wgByColor9;
	}

	public String getWgByColor10() {
		return wgByColor10;
	}

	public void setWgByColor10(String wgByColor10) {
		this.wgByColor10 = wgByColor10;
	}

	public Map<String, String> getWgByColorsMap() {
		return wgByColorsMap;
	}

	public void setWgByColorsMap(Map<String, String> wgByColorsMap) {
		this.wgByColorsMap = wgByColorsMap;
	}

	public String getWgBackLiningMate() {
		return wgBackLiningMate;
	}

	public void setWgBackLiningMate(String wgBackLiningMate) {
		this.wgBackLiningMate = wgBackLiningMate;
	}

	public Map<String, String> getWgBackLiningMateMap() {
		return wgBackLiningMateMap;
	}

	public void setWgBackLiningMateMap(Map<String, String> wgBackLiningMateMap) {
		this.wgBackLiningMateMap = wgBackLiningMateMap;
	}

	public String getWgInsideLiningMate() {
		return wgInsideLiningMate;
	}

	public void setWgInsideLiningMate(String wgInsideLiningMate) {
		this.wgInsideLiningMate = wgInsideLiningMate;
	}

	public Map<String, String> getWgInsideLiningMateMap() {
		return wgInsideLiningMateMap;
	}

	public void setWgInsideLiningMateMap(Map<String, String> wgInsideLiningMateMap) {
		this.wgInsideLiningMateMap = wgInsideLiningMateMap;
	}

	public String getWgFrontBtnMate() {
		return wgFrontBtnMate;
	}

	public void setWgFrontBtnMate(String wgFrontBtnMate) {
		this.wgFrontBtnMate = wgFrontBtnMate;
	}

	public Map<String, String> getWgFrontBtnMateMap() {
		return wgFrontBtnMateMap;
	}

	public void setWgFrontBtnMateMap(Map<String, String> wgFrontBtnMateMap) {
		this.wgFrontBtnMateMap = wgFrontBtnMateMap;
	}

	public String getWgBackBelt() {
		return wgBackBelt;
	}

	public void setWgBackBelt(String wgBackBelt) {
		this.wgBackBelt = wgBackBelt;
	}

	public Map<String, String> getWgBackBeltMap() {
		return wgBackBeltMap;
	}

	public void setWgBackBeltMap(Map<String, String> wgBackBeltMap) {
		this.wgBackBeltMap = wgBackBeltMap;
	}

	public String getWgWatchChain() {
		return wgWatchChain;
	}

	public void setWgWatchChain(String wgWatchChain) {
		this.wgWatchChain = wgWatchChain;
	}

	public Map<String, String> getWgWatchChainMap() {
		return wgWatchChainMap;
	}

	public void setWgWatchChainMap(Map<String, String> wgWatchChainMap) {
		this.wgWatchChainMap = wgWatchChainMap;
	}

	public String getWgGiletModel() {
		return wgGiletModel;
	}

	public void setWgGiletModel(String wgGiletModel) {
		this.wgGiletModel = wgGiletModel;
	}

	public Map<String, String> getWgGiletModelMap() {
		return wgGiletModelMap;
	}

	public void setWgGiletModelMap(Map<String, String> wgGiletModelMap) {
		this.wgGiletModelMap = wgGiletModelMap;
	}

	public String getWgDStitchModify() {
		return wgDStitchModify;
	}

	public void setWgDStitchModify(String wgDStitchModify) {
		this.wgDStitchModify = wgDStitchModify;
	}

	public Map<String, String> getWgDStitchModifyMap() {
		return wgDStitchModifyMap;
	}

	public void setWgDStitchModifyMap(Map<String, String> wgDStitchModifyMap) {
		this.wgDStitchModifyMap = wgDStitchModifyMap;
	}

	public Map<String, String> getWgDStitchModifyPlaceMap() {
		return wgDStitchModifyPlaceMap;
	}

	public void setWgDStitchModifyPlaceMap(Map<String, String> wgDStitchModifyPlaceMap) {
		this.wgDStitchModifyPlaceMap = wgDStitchModifyPlaceMap;
	}

	public String getWgBackLiningMateStkNo() {
		return wgBackLiningMateStkNo;
	}

	public void setWgBackLiningMateStkNo(String wgBackLiningMateStkNo) {
		this.wgBackLiningMateStkNo = wgBackLiningMateStkNo;
	}

	public String getWgInsideLiningMateStkNo() {
		return wgInsideLiningMateStkNo;
	}

	public void setWgInsideLiningMateStkNo(String wgInsideLiningMateStkNo) {
		this.wgInsideLiningMateStkNo = wgInsideLiningMateStkNo;
	}

	public String getWgFrontBtnMateStkNo() {
		return wgFrontBtnMateStkNo;
	}

	public void setWgFrontBtnMateStkNo(String wgFrontBtnMateStkNo) {
		this.wgFrontBtnMateStkNo = wgFrontBtnMateStkNo;
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

	public String getWgStitchModifyPlace1() {
		return wgStitchModifyPlace1;
	}

	public void setWgStitchModifyPlace1(String wgStitchModifyPlace1) {
		this.wgStitchModifyPlace1 = wgStitchModifyPlace1;
	}

	public String getWgStitchModifyPlace2() {
		return wgStitchModifyPlace2;
	}

	public void setWgStitchModifyPlace2(String wgStitchModifyPlace2) {
		this.wgStitchModifyPlace2 = wgStitchModifyPlace2;
	}

	public String getWgStitchModifyPlace3() {
		return wgStitchModifyPlace3;
	}

	public void setWgStitchModifyPlace3(String wgStitchModifyPlace3) {
		this.wgStitchModifyPlace3 = wgStitchModifyPlace3;
	}

	public String getWgDStitchModifyPlace1() {
		return wgDStitchModifyPlace1;
	}

	public void setWgDStitchModifyPlace1(String wgDStitchModifyPlace1) {
		this.wgDStitchModifyPlace1 = wgDStitchModifyPlace1;
	}

	public String getWgDStitchModifyPlace2() {
		return wgDStitchModifyPlace2;
	}

	public void setWgDStitchModifyPlace2(String wgDStitchModifyPlace2) {
		this.wgDStitchModifyPlace2 = wgDStitchModifyPlace2;
	}

	public String getWgDStitchModifyPlace3() {
		return wgDStitchModifyPlace3;
	}

	public void setWgDStitchModifyPlace3(String wgDStitchModifyPlace3) {
		this.wgDStitchModifyPlace3 = wgDStitchModifyPlace3;
	}

	public String getWgAmfColorPlace1() {
		return wgAmfColorPlace1;
	}

	public void setWgAmfColorPlace1(String wgAmfColorPlace1) {
		this.wgAmfColorPlace1 = wgAmfColorPlace1;
	}

	public String getWgAmfColorPlace2() {
		return wgAmfColorPlace2;
	}

	public void setWgAmfColorPlace2(String wgAmfColorPlace2) {
		this.wgAmfColorPlace2 = wgAmfColorPlace2;
	}

	public String getWgAmfColorPlace3() {
		return wgAmfColorPlace3;
	}

	public void setWgAmfColorPlace3(String wgAmfColorPlace3) {
		this.wgAmfColorPlace3 = wgAmfColorPlace3;
	}

	public String getWgBhColorPlace1() {
		return wgBhColorPlace1;
	}

	public void setWgBhColorPlace1(String wgBhColorPlace1) {
		this.wgBhColorPlace1 = wgBhColorPlace1;
	}

	public String getWgBhColorPlace2() {
		return wgBhColorPlace2;
	}

	public void setWgBhColorPlace2(String wgBhColorPlace2) {
		this.wgBhColorPlace2 = wgBhColorPlace2;
	}

	public String getWgBhColorPlace3() {
		return wgBhColorPlace3;
	}

	public void setWgBhColorPlace3(String wgBhColorPlace3) {
		this.wgBhColorPlace3 = wgBhColorPlace3;
	}

	public String getWgBhColorPlace4() {
		return wgBhColorPlace4;
	}

	public void setWgBhColorPlace4(String wgBhColorPlace4) {
		this.wgBhColorPlace4 = wgBhColorPlace4;
	}

	public String getWgBhColorPlace5() {
		return wgBhColorPlace5;
	}

	public void setWgBhColorPlace5(String wgBhColorPlace5) {
		this.wgBhColorPlace5 = wgBhColorPlace5;
	}

	public String getWgBhColorPlace6() {
		return wgBhColorPlace6;
	}

	public void setWgBhColorPlace6(String wgBhColorPlace6) {
		this.wgBhColorPlace6 = wgBhColorPlace6;
	}

	public String getWgByColorPlace1() {
		return wgByColorPlace1;
	}

	public void setWgByColorPlace1(String wgByColorPlace1) {
		this.wgByColorPlace1 = wgByColorPlace1;
	}

	public String getWgByColorPlace2() {
		return wgByColorPlace2;
	}

	public void setWgByColorPlace2(String wgByColorPlace2) {
		this.wgByColorPlace2 = wgByColorPlace2;
	}

	public String getWgByColorPlace3() {
		return wgByColorPlace3;
	}

	public void setWgByColorPlace3(String wgByColorPlace3) {
		this.wgByColorPlace3 = wgByColorPlace3;
	}

	public String getWgByColorPlace4() {
		return wgByColorPlace4;
	}

	public void setWgByColorPlace4(String wgByColorPlace4) {
		this.wgByColorPlace4 = wgByColorPlace4;
	}

	public String getWgByColorPlace5() {
		return wgByColorPlace5;
	}

	public void setWgByColorPlace5(String wgByColorPlace5) {
		this.wgByColorPlace5 = wgByColorPlace5;
	}

	public String getWgByColorPlace6() {
		return wgByColorPlace6;
	}

	public void setWgByColorPlace6(String wgByColorPlace6) {
		this.wgByColorPlace6 = wgByColorPlace6;
	}

	public String getWgByColorPlace7() {
		return wgByColorPlace7;
	}

	public void setWgByColorPlace7(String wgByColorPlace7) {
		this.wgByColorPlace7 = wgByColorPlace7;
	}

	public String getWgByColorPlace8() {
		return wgByColorPlace8;
	}

	public void setWgByColorPlace8(String wgByColorPlace8) {
		this.wgByColorPlace8 = wgByColorPlace8;
	}

	public String getWgByColorPlace9() {
		return wgByColorPlace9;
	}

	public void setWgByColorPlace9(String wgByColorPlace9) {
		this.wgByColorPlace9 = wgByColorPlace9;
	}

	public String getWgByColorPlace10() {
		return wgByColorPlace10;
	}

	public void setWgByColorPlace10(String wgByColorPlace10) {
		this.wgByColorPlace10 = wgByColorPlace10;
	}

	public String getWgStitchModifyPlace() {
		return wgStitchModifyPlace;
	}

	public void setWgStitchModifyPlace(String wgStitchModifyPlace) {
		this.wgStitchModifyPlace = wgStitchModifyPlace;
	}

	public String getWgDStitchModifyPlace() {
		return wgDStitchModifyPlace;
	}

	public void setWgDStitchModifyPlace(String wgDStitchModifyPlace) {
		this.wgDStitchModifyPlace = wgDStitchModifyPlace;
	}

	public String getWgAmfColorPlace() {
		return wgAmfColorPlace;
	}

	public void setWgAmfColorPlace(String wgAmfColorPlace) {
		this.wgAmfColorPlace = wgAmfColorPlace;
	}

	public String getWgBhColorPlace() {
		return wgBhColorPlace;
	}

	public void setWgBhColorPlace(String wgBhColorPlace) {
		this.wgBhColorPlace = wgBhColorPlace;
	}

	public String getWgByColorPlace() {
		return wgByColorPlace;
	}

	public void setWgByColorPlace(String wgByColorPlace) {
		this.wgByColorPlace = wgByColorPlace;
	}

	public String getWgAmfAllColor() {
		return wgAmfAllColor;
	}

	public void setWgAmfAllColor(String wgAmfAllColor) {
		this.wgAmfAllColor = wgAmfAllColor;
	}

	public String getWgBhAllColor() {
		return wgBhAllColor;
	}

	public void setWgBhAllColor(String wgBhAllColor) {
		this.wgBhAllColor = wgBhAllColor;
	}

	public String getWgByAllColor() {
		return wgByAllColor;
	}

	public void setWgByAllColor(String wgByAllColor) {
		this.wgByAllColor = wgByAllColor;
	}
	
}
