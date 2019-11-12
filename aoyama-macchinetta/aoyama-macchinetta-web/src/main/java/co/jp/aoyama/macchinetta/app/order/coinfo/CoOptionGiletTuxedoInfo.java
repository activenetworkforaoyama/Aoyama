package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.GlTuBackLiningMateItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.GlTuFrontBtnMateItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.GlTuItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.GlTuWaistPktSpecItem;


public class CoOptionGiletTuxedoInfo implements Serializable {

	private static final long serialVersionUID = -4934283279616821245L;

	// GILETモデル
	@NotBlank(groups = { GlTuItem.class }, message = "Giletのモデルを入力して下さい。")
	private String tgGiletModel;

	private Map<String, String> tgGiletModelMap;

	// 胸ポケット
	@NotBlank(groups = { GlTuItem.class }, message = "Giletの胸ポケットを入力して下さい。")
	private String tgBreastPkt;

	private Map<String, String> tgBreastPktMap;
	
	private String glBreastPktRtPrice;

	// 腰ポケット
	@NotBlank(groups = { GlTuItem.class }, message = "Giletの腰ポケットを入力して下さい。")
	private String tgWaistPkt;

	private Map<String, String> tgWaistPktMap;
	
	private String glWaistPktRtPrice;

	// 腰ポケット形状
	@NotBlank(groups = { GlTuWaistPktSpecItem.class }, message = "Giletの腰ポケット形状を入力して下さい。")
	private String tgWaistPktSpec;

	private Map<String, String> tgWaistPktSpecMap;
	
	private String glWaistPktShapeRtPrice;

	// 腰ポケット素材
	@NotBlank(groups = { GlTuWaistPktSpecItem.class }, message = "Giletの腰ポケット素材を入力して下さい。")
	private String tgWaistPktMate;

	private Map<String, String> tgWaistPktMateMap;
	
	private String glWaistPktClothRtPrice;
	
	// 拝絹地
	@NotBlank(groups = { GlTuItem.class }, message = "Giletの拝絹地を入力して下さい。")
	private String tgGlossFablic;

	private Map<String, String> tgGlossFablicMap;

	private String glLookClothRtPrice;

	// ステッチ種類
	@NotBlank(groups = { GlTuItem.class }, message = "Giletのステッチ種類を入力して下さい。")
	private String tgStitch;

	private Map<String, String> tgCoStitchMap;
	
	private String glAmfStitchRtPrice;
	
	// ステッチ箇所変更
	private String tgStitchModify = "0000601";
	
	// ダブルステッチ変更
	private String tgDblstitchPlc = "0002601";
	
	// AMF色指定
	private String tgAmfColor = "0000801";

	// ボタンホール色指定
	@NotBlank(groups = { GlTuItem.class }, message = "Giletのボタンホール色指定を入力して下さい。")
	private String tgBhColor;

	private Map<String, String> tgBhColorMap;
	
	private String glBtnholeColorRtPrice;

	// ボタンホール色指定 糸色,ボタンホール色指定糸色(プルダウン)
	private String tgBhColorPlaceAll;

	private Map<String, String> tgBhColorPlaceAllMap;

	// ボタンホール色指定 箇所
	private String tgBhColorPlace;
	private String tgBhColorPlace1;
	private String tgBhColorPlace2;
	private String tgBhColorPlace3;
	private String tgBhColorPlace4;
	private String tgBhColorPlace5;
	private String tgBhColorPlace6;

	private Map<String, String> tgBhColorPlaceMap;

	private String tgBhAllColor;
	// ボタンホール色指定 フロント1
	private String tgBhColor1;
	// ボタンホール色指定 フロント2
	private String tgBhColor2;
	// ボタンホール色指定 フロント3
	private String tgBhColor3;
	// ボタンホール色指定 フロント4
	private String tgBhColor4;
	// ボタンホール色指定 フロント5
	private String tgBhColor5;
	// ボタンホール色指定 フロント6
	private String tgBhColor6;

	// ボタンホール色指定色 key&value
	private Map<String, String> tgBhColorsMap;

	// ボタン付け糸指定
	@NotBlank(groups = { GlTuItem.class }, message = "Giletのボタン付け糸指定を入力して下さい。")
	private String tgByColor;

	private Map<String, String> tgByColorMap;
	
	private String glBtnthreadColorRtPrice;

	// ボタンホール色指定 糸色,ボタン付け糸指定糸色(プルダウン)
	private String tgByColorPlaceAll;

	private Map<String, String> tgByColorPlaceAllMap;

	// ボタンホール色指定 箇所
	private String tgByColorPlace;
	private String tgByColorPlace1;
	private String tgByColorPlace2;
	private String tgByColorPlace3;
	private String tgByColorPlace4;
	private String tgByColorPlace5;
	private String tgByColorPlace6;
	private String tgByColorPlace7;
	private String tgByColorPlace8;
	private String tgByColorPlace9;
	private String tgByColorPlace10;

	private Map<String, String> tgByColorPlaceMap;

	private String tgByAllColor;
	// ボタンホール色指定 フロント下前1
	private String tgByColor1;
	// ボタンホール色指定 フロント下前2
	private String tgByColor2;
	// ボタンホール色指定 フロント下前3
	private String tgByColor3;
	// ボタンホール色指定 フロント下前4
	private String tgByColor4;
	// ボタンホール色指定 フロント下前5
	private String tgByColor5;
	// ボタンホール色指定 フロント下前6
	private String tgByColor6;
	// ボタンホール色指定 フロント上前1
	private String tgByColor7;
	// ボタンホール色指定 フロント上前2
	private String tgByColor8;
	// ボタンホール色指定 フロント上前3
	private String tgByColor9;
	// ボタンホール色指定 フロント上前4
	private String tgByColor10;

	// ボタン付け糸指定糸色 key&value
	private Map<String, String> tgByColorsMap;

	// 背裏地素材
	@NotBlank(groups = { GlTuItem.class }, message = "Giletの背裏地素材を入力して下さい。")
	private String tgBackLiningMate;

	private Map<String, String> tgBackLiningMateMap;
	
	private String glBackClothRtPrice;
	
	// 背裏地素材品番
	@NotBlank(groups = { GlTuBackLiningMateItem.class }, message = "Giletの背裏地素材品番を入力して下さい。")
	private String tgBackLiningMateStkNo;

	// 内側裏地素材
	@NotBlank(groups = { GlTuItem.class }, message = "Giletの内側裏地素材を入力して下さい。")
	private String tgInsideLiningMate;

	private Map<String, String> tgInsideLiningMateMap;
	
	private String glInnnerClothRtPrice;
	
	// 内側裏地素材品番
	@NotBlank(groups = { GlTuItem.class }, message = "Giletの内側裏地素材品番を入力して下さい。")
	private String tgInsideLiningMateStkNo;

	// 釦素材
	@NotBlank(groups = { GlTuItem.class }, message = "Giletの釦素材を入力して下さい。")
	private String tgFrontBtnMate;

	private Map<String, String> tgFrontBtnMateMap;
	
	private String glFrtBtnRtPrice;
	
	// 釦素材品番
	@NotBlank(groups = { GlTuFrontBtnMateItem.class }, message = "Giletの釦素材品番を入力して下さい。")
	private String tgFrontBtnMateStkNo;

	// バックベルト
	@NotBlank(groups = { GlTuItem.class }, message = "Giletのバックベルトを入力して下さい。")
	private String tgBackBelt;

	private Map<String, String> tgBackBeltMap;
	
	private String glBackBeltRtPrice;

	// ウォッチチェーン
	@NotBlank(groups = { GlTuItem.class }, message = "Giletのウォッチチェーンを入力して下さい。")
	private String tgWatchChain;

	private Map<String, String> tgWatchChainMap;
	
	private String glWatchChainRtPrice;

	public String getTgGlossFablic() {
		return tgGlossFablic;
	}

	public void setTgGlossFablic(String tgGlossFablic) {
		this.tgGlossFablic = tgGlossFablic;
	}

	public Map<String, String> getTgGlossFablicMap() {
		return tgGlossFablicMap;
	}

	public void setTgGlossFablicMap(Map<String, String> tgGlossFablicMap) {
		this.tgGlossFablicMap = tgGlossFablicMap;
	}

	public String getGlLookClothRtPrice() {
		return glLookClothRtPrice;
	}

	public void setGlLookClothRtPrice(String glLookClothRtPrice) {
		this.glLookClothRtPrice = glLookClothRtPrice;
	}

	public String getTgBreastPkt() {
		return tgBreastPkt;
	}

	public void setTgBreastPkt(String tgBreastPkt) {
		this.tgBreastPkt = tgBreastPkt;
	}

	public Map<String, String> getTgBreastPktMap() {
		return tgBreastPktMap;
	}

	public void setTgBreastPktMap(Map<String, String> tgBreastPktMap) {
		this.tgBreastPktMap = tgBreastPktMap;
	}

	public String getTgWaistPkt() {
		return tgWaistPkt;
	}

	public void setTgWaistPkt(String tgWaistPkt) {
		this.tgWaistPkt = tgWaistPkt;
	}

	public Map<String, String> getTgWaistPktMap() {
		return tgWaistPktMap;
	}

	public void setTgWaistPktMap(Map<String, String> tgWaistPktMap) {
		this.tgWaistPktMap = tgWaistPktMap;
	}

	public String getTgWaistPktSpec() {
		return tgWaistPktSpec;
	}

	public void setTgWaistPktSpec(String tgWaistPktSpec) {
		this.tgWaistPktSpec = tgWaistPktSpec;
	}

	public Map<String, String> getTgWaistPktSpecMap() {
		return tgWaistPktSpecMap;
	}

	public void setTgWaistPktSpecMap(Map<String, String> tgWaistPktSpecMap) {
		this.tgWaistPktSpecMap = tgWaistPktSpecMap;
	}

	public String getTgWaistPktMate() {
		return tgWaistPktMate;
	}

	public void setTgWaistPktMate(String tgWaistPktMate) {
		this.tgWaistPktMate = tgWaistPktMate;
	}

	public Map<String, String> getTgWaistPktMateMap() {
		return tgWaistPktMateMap;
	}

	public void setTgWaistPktMateMap(Map<String, String> tgWaistPktMateMap) {
		this.tgWaistPktMateMap = tgWaistPktMateMap;
	}

	public String getTgStitch() {
		return tgStitch;
	}

	public void setTgStitch(String tgStitch) {
		this.tgStitch = tgStitch;
	}

	public Map<String, String> getTgCoStitchMap() {
		return tgCoStitchMap;
	}

	public void setTgCoStitchMap(Map<String, String> tgCoStitchMap) {
		this.tgCoStitchMap = tgCoStitchMap;
	}

	public String getTgBhColor() {
		return tgBhColor;
	}

	public void setTgBhColor(String tgBhColor) {
		this.tgBhColor = tgBhColor;
	}

	public Map<String, String> getTgBhColorMap() {
		return tgBhColorMap;
	}

	public void setTgBhColorMap(Map<String, String> tgBhColorMap) {
		this.tgBhColorMap = tgBhColorMap;
	}

	public String getTgBhColorPlaceAll() {
		return tgBhColorPlaceAll;
	}

	public void setTgBhColorPlaceAll(String tgBhColorPlaceAll) {
		this.tgBhColorPlaceAll = tgBhColorPlaceAll;
	}

	public Map<String, String> getTgBhColorPlaceAllMap() {
		return tgBhColorPlaceAllMap;
	}

	public void setTgBhColorPlaceAllMap(Map<String, String> tgBhColorPlaceAllMap) {
		this.tgBhColorPlaceAllMap = tgBhColorPlaceAllMap;
	}

	public Map<String, String> getTgBhColorPlaceMap() {
		return tgBhColorPlaceMap;
	}

	public void setTgBhColorPlaceMap(Map<String, String> tgBhColorPlaceMap) {
		this.tgBhColorPlaceMap = tgBhColorPlaceMap;
	}

	public String getTgBhColor1() {
		return tgBhColor1;
	}

	public void setTgBhColor1(String tgBhColor1) {
		this.tgBhColor1 = tgBhColor1;
	}

	public String getTgBhColor2() {
		return tgBhColor2;
	}

	public void setTgBhColor2(String tgBhColor2) {
		this.tgBhColor2 = tgBhColor2;
	}

	public String getTgBhColor3() {
		return tgBhColor3;
	}

	public void setTgBhColor3(String tgBhColor3) {
		this.tgBhColor3 = tgBhColor3;
	}

	public String getTgBhColor4() {
		return tgBhColor4;
	}

	public void setTgBhColor4(String tgBhColor4) {
		this.tgBhColor4 = tgBhColor4;
	}

	public String getTgBhColor5() {
		return tgBhColor5;
	}

	public void setTgBhColor5(String tgBhColor5) {
		this.tgBhColor5 = tgBhColor5;
	}

	public String getTgBhColor6() {
		return tgBhColor6;
	}

	public void setTgBhColor6(String tgBhColor6) {
		this.tgBhColor6 = tgBhColor6;
	}

	public Map<String, String> getTgBhColorsMap() {
		return tgBhColorsMap;
	}

	public void setTgBhColorsMap(Map<String, String> tgBhColorsMap) {
		this.tgBhColorsMap = tgBhColorsMap;
	}

	public String getTgByColor() {
		return tgByColor;
	}

	public void setTgByColor(String tgByColor) {
		this.tgByColor = tgByColor;
	}

	public Map<String, String> getTgByColorMap() {
		return tgByColorMap;
	}

	public void setTgByColorMap(Map<String, String> tgByColorMap) {
		this.tgByColorMap = tgByColorMap;
	}

	public String getTgByColorPlaceAll() {
		return tgByColorPlaceAll;
	}

	public void setTgByColorPlaceAll(String tgByColorPlaceAll) {
		this.tgByColorPlaceAll = tgByColorPlaceAll;
	}

	public Map<String, String> getTgByColorPlaceAllMap() {
		return tgByColorPlaceAllMap;
	}

	public void setTgByColorPlaceAllMap(Map<String, String> tgByColorPlaceAllMap) {
		this.tgByColorPlaceAllMap = tgByColorPlaceAllMap;
	}

	public Map<String, String> getTgByColorPlaceMap() {
		return tgByColorPlaceMap;
	}

	public void setTgByColorPlaceMap(Map<String, String> tgByColorPlaceMap) {
		this.tgByColorPlaceMap = tgByColorPlaceMap;
	}

	public String getTgByColor1() {
		return tgByColor1;
	}

	public void setTgByColor1(String tgByColor1) {
		this.tgByColor1 = tgByColor1;
	}

	public String getTgByColor2() {
		return tgByColor2;
	}

	public void setTgByColor2(String tgByColor2) {
		this.tgByColor2 = tgByColor2;
	}

	public String getTgByColor3() {
		return tgByColor3;
	}

	public void setTgByColor3(String tgByColor3) {
		this.tgByColor3 = tgByColor3;
	}

	public String getTgByColor4() {
		return tgByColor4;
	}

	public void setTgByColor4(String tgByColor4) {
		this.tgByColor4 = tgByColor4;
	}

	public String getTgByColor5() {
		return tgByColor5;
	}

	public void setTgByColor5(String tgByColor5) {
		this.tgByColor5 = tgByColor5;
	}

	public String getTgByColor6() {
		return tgByColor6;
	}

	public void setTgByColor6(String tgByColor6) {
		this.tgByColor6 = tgByColor6;
	}

	public String getTgByColor7() {
		return tgByColor7;
	}

	public void setTgByColor7(String tgByColor7) {
		this.tgByColor7 = tgByColor7;
	}

	public String getTgByColor8() {
		return tgByColor8;
	}

	public void setTgByColor8(String tgByColor8) {
		this.tgByColor8 = tgByColor8;
	}

	public String getTgByColor9() {
		return tgByColor9;
	}

	public void setTgByColor9(String tgByColor9) {
		this.tgByColor9 = tgByColor9;
	}

	public String getTgByColor10() {
		return tgByColor10;
	}

	public void setTgByColor10(String tgByColor10) {
		this.tgByColor10 = tgByColor10;
	}

	public Map<String, String> getTgByColorsMap() {
		return tgByColorsMap;
	}

	public void setTgByColorsMap(Map<String, String> tgByColorsMap) {
		this.tgByColorsMap = tgByColorsMap;
	}

	public String getTgBackLiningMate() {
		return tgBackLiningMate;
	}

	public void setTgBackLiningMate(String tgBackLiningMate) {
		this.tgBackLiningMate = tgBackLiningMate;
	}

	public Map<String, String> getTgBackLiningMateMap() {
		return tgBackLiningMateMap;
	}

	public void setTgBackLiningMateMap(Map<String, String> tgBackLiningMateMap) {
		this.tgBackLiningMateMap = tgBackLiningMateMap;
	}

	public String getTgInsideLiningMate() {
		return tgInsideLiningMate;
	}

	public void setTgInsideLiningMate(String tgInsideLiningMate) {
		this.tgInsideLiningMate = tgInsideLiningMate;
	}

	public Map<String, String> getTgInsideLiningMateMap() {
		return tgInsideLiningMateMap;
	}

	public void setTgInsideLiningMateMap(Map<String, String> tgInsideLiningMateMap) {
		this.tgInsideLiningMateMap = tgInsideLiningMateMap;
	}

	public String getTgFrontBtnMate() {
		return tgFrontBtnMate;
	}

	public void setTgFrontBtnMate(String tgFrontBtnMate) {
		this.tgFrontBtnMate = tgFrontBtnMate;
	}

	public Map<String, String> getTgFrontBtnMateMap() {
		return tgFrontBtnMateMap;
	}

	public void setTgFrontBtnMateMap(Map<String, String> tgFrontBtnMateMap) {
		this.tgFrontBtnMateMap = tgFrontBtnMateMap;
	}

	public String getTgBackBelt() {
		return tgBackBelt;
	}

	public void setTgBackBelt(String tgBackBelt) {
		this.tgBackBelt = tgBackBelt;
	}

	public Map<String, String> getTgBackBeltMap() {
		return tgBackBeltMap;
	}

	public void setTgBackBeltMap(Map<String, String> tgBackBeltMap) {
		this.tgBackBeltMap = tgBackBeltMap;
	}

	public String getTgWatchChain() {
		return tgWatchChain;
	}

	public void setTgWatchChain(String tgWatchChain) {
		this.tgWatchChain = tgWatchChain;
	}

	public Map<String, String> getTgWatchChainMap() {
		return tgWatchChainMap;
	}

	public void setTgWatchChainMap(Map<String, String> tgWatchChainMap) {
		this.tgWatchChainMap = tgWatchChainMap;
	}

	public String getTgGiletModel() {
		return tgGiletModel;
	}

	public void setTgGiletModel(String tgGiletModel) {
		this.tgGiletModel = tgGiletModel;
	}

	public Map<String, String> getTgGiletModelMap() {
		return tgGiletModelMap;
	}

	public void setTgGiletModelMap(Map<String, String> tgGiletModelMap) {
		this.tgGiletModelMap = tgGiletModelMap;
	}

	public String getTgBackLiningMateStkNo() {
		return tgBackLiningMateStkNo;
	}

	public void setTgBackLiningMateStkNo(String tgBackLiningMateStkNo) {
		this.tgBackLiningMateStkNo = tgBackLiningMateStkNo;
	}

	public String getTgInsideLiningMateStkNo() {
		return tgInsideLiningMateStkNo;
	}

	public void setTgInsideLiningMateStkNo(String tgInsideLiningMateStkNo) {
		this.tgInsideLiningMateStkNo = tgInsideLiningMateStkNo;
	}

	public String getTgFrontBtnMateStkNo() {
		return tgFrontBtnMateStkNo;
	}

	public void setTgFrontBtnMateStkNo(String tgFrontBtnMateStkNo) {
		this.tgFrontBtnMateStkNo = tgFrontBtnMateStkNo;
	}

	public String getTgStitchModify() {
		return tgStitchModify;
	}

	public void setTgStitchModify(String tgStitchModify) {
		this.tgStitchModify = tgStitchModify;
	}

	public String getTgDblstitchPlc() {
		return tgDblstitchPlc;
	}

	public void setTgDblstitchPlc(String tgDblstitchPlc) {
		this.tgDblstitchPlc = tgDblstitchPlc;
	}

	public String getTgAmfColor() {
		return tgAmfColor;
	}

	public void setTgAmfColor(String tgAmfColor) {
		this.tgAmfColor = tgAmfColor;
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

	public String getGlWaistPktClothRtPrice() {
		return glWaistPktClothRtPrice;
	}

	public void setGlWaistPktClothRtPrice(String glWaistPktClothRtPrice) {
		this.glWaistPktClothRtPrice = glWaistPktClothRtPrice;
	}

	public String getGlAmfStitchRtPrice() {
		return glAmfStitchRtPrice;
	}

	public void setGlAmfStitchRtPrice(String glAmfStitchRtPrice) {
		this.glAmfStitchRtPrice = glAmfStitchRtPrice;
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

	public String getTgBhColorPlace1() {
		return tgBhColorPlace1;
	}

	public void setTgBhColorPlace1(String tgBhColorPlace1) {
		this.tgBhColorPlace1 = tgBhColorPlace1;
	}

	public String getTgBhColorPlace2() {
		return tgBhColorPlace2;
	}

	public void setTgBhColorPlace2(String tgBhColorPlace2) {
		this.tgBhColorPlace2 = tgBhColorPlace2;
	}

	public String getTgBhColorPlace3() {
		return tgBhColorPlace3;
	}

	public void setTgBhColorPlace3(String tgBhColorPlace3) {
		this.tgBhColorPlace3 = tgBhColorPlace3;
	}

	public String getTgBhColorPlace4() {
		return tgBhColorPlace4;
	}

	public void setTgBhColorPlace4(String tgBhColorPlace4) {
		this.tgBhColorPlace4 = tgBhColorPlace4;
	}

	public String getTgBhColorPlace5() {
		return tgBhColorPlace5;
	}

	public void setTgBhColorPlace5(String tgBhColorPlace5) {
		this.tgBhColorPlace5 = tgBhColorPlace5;
	}

	public String getTgBhColorPlace6() {
		return tgBhColorPlace6;
	}

	public void setTgBhColorPlace6(String tgBhColorPlace6) {
		this.tgBhColorPlace6 = tgBhColorPlace6;
	}

	public String getTgByColorPlace1() {
		return tgByColorPlace1;
	}

	public void setTgByColorPlace1(String tgByColorPlace1) {
		this.tgByColorPlace1 = tgByColorPlace1;
	}

	public String getTgByColorPlace2() {
		return tgByColorPlace2;
	}

	public void setTgByColorPlace2(String tgByColorPlace2) {
		this.tgByColorPlace2 = tgByColorPlace2;
	}

	public String getTgByColorPlace3() {
		return tgByColorPlace3;
	}

	public void setTgByColorPlace3(String tgByColorPlace3) {
		this.tgByColorPlace3 = tgByColorPlace3;
	}

	public String getTgByColorPlace4() {
		return tgByColorPlace4;
	}

	public void setTgByColorPlace4(String tgByColorPlace4) {
		this.tgByColorPlace4 = tgByColorPlace4;
	}

	public String getTgByColorPlace5() {
		return tgByColorPlace5;
	}

	public void setTgByColorPlace5(String tgByColorPlace5) {
		this.tgByColorPlace5 = tgByColorPlace5;
	}

	public String getTgByColorPlace6() {
		return tgByColorPlace6;
	}

	public void setTgByColorPlace6(String tgByColorPlace6) {
		this.tgByColorPlace6 = tgByColorPlace6;
	}

	public String getTgByColorPlace7() {
		return tgByColorPlace7;
	}

	public void setTgByColorPlace7(String tgByColorPlace7) {
		this.tgByColorPlace7 = tgByColorPlace7;
	}

	public String getTgByColorPlace8() {
		return tgByColorPlace8;
	}

	public void setTgByColorPlace8(String tgByColorPlace8) {
		this.tgByColorPlace8 = tgByColorPlace8;
	}

	public String getTgByColorPlace9() {
		return tgByColorPlace9;
	}

	public void setTgByColorPlace9(String tgByColorPlace9) {
		this.tgByColorPlace9 = tgByColorPlace9;
	}

	public String getTgByColorPlace10() {
		return tgByColorPlace10;
	}

	public void setTgByColorPlace10(String tgByColorPlace10) {
		this.tgByColorPlace10 = tgByColorPlace10;
	}

	public String getTgBhColorPlace() {
		return tgBhColorPlace;
	}

	public void setTgBhColorPlace(String tgBhColorPlace) {
		this.tgBhColorPlace = tgBhColorPlace;
	}

	public String getTgByColorPlace() {
		return tgByColorPlace;
	}

	public void setTgByColorPlace(String tgByColorPlace) {
		this.tgByColorPlace = tgByColorPlace;
	}

	public String getTgBhAllColor() {
		return tgBhAllColor;
	}

	public void setTgBhAllColor(String tgBhAllColor) {
		this.tgBhAllColor = tgBhAllColor;
	}

	public String getTgByAllColor() {
		return tgByAllColor;
	}

	public void setTgByAllColor(String tgByAllColor) {
		this.tgByAllColor = tgByAllColor;
	}
	
}
