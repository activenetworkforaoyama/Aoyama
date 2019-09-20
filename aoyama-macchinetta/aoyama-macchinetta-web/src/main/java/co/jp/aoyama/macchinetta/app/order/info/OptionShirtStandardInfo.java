package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class OptionShirtStandardInfo implements Serializable {
	private static final long serialVersionUID = -3593141126900298826L;

	// SHIRTモデル
	private String osShirtModel;

	private Map<String, String> osShirtModelMap;

	// 襟型
	private String osChainModel;

	private Map<String, String> osChainModelMap;

	// カフス
	private String osCuffs;

	private Map<String, String> osCuffsMap;

	// コンバーチブル
	private String osConvertible;

	private Map<String, String> osConvertibleMap;

	// アジャスト釦
	private String osAdjustBtn;

	private Map<String, String> osAdjustBtnMap;

	// クレリック仕様
	private String osClericSpec;

	private Map<String, String> osClericSpecMap;

	// ダブルカフス仕様
	private String osDblCuff;

	private Map<String, String> osDblCuffMap;
	
	//カフスボタン追加
	private String osAddCuff;
	
	private Map<String, String> osAddCuffMap;

	// 釦素材
	private String osBtnMate;

	private Map<String, String> osBtnMateMap;
	
	//タブ釦
	private String osTabBtn;
	
	private Map<String, String> osTabBtnMap;

	// ガントレットボタン位置
	private String osGaletteBtnPos;

	private Map<String, String> osGaletteBtnPosMap;

	// ピンホールピン
	private String osPinHolePin;

	private Map<String, String> osPinHolePinMap;

	// 胸ポケット
	private String osBreastPk;

	private Map<String, String> osBreastPkMap;
	
	//胸ポケット大きさ
	private String osBreastPkSize;
	
	private Map<String, String> osBreastPkSizeMap;

	// フロントデザイン
	private String osFrontDesign;

	private Map<String, String> osFrontDesignMap;

	// ピンタックブザム
	private String osPinTack;

	private Map<String, String> osPinTackMap;

	// ステッチ
	private String osStitch;

	private Map<String, String> osStitchMap;

	// カラーキーパー
	private String osColorKeeper;

	private Map<String, String> osColorKeeperMap;

	// ボタン付け糸色変更
	private String osByColor;

	private Map<String, String> osByColorMap;

	// ボタンホール色変更
	private String osBhColor;

	private Map<String, String> osBhColorMap;

	//カジュアルヘムライン仕様
	private String osCasHemLine;
	
	private Map<String, String> osCasHemLineMap;
	
	//ボタン位置変更
	private String osBtnPosChg;
	
	private Map<String, String> osBtnPosChgMap;
	
	// ボタン位置変更 台襟釦
	private String osBtnPosChgCollar;

	// ボタン位置変更 フロント第1釦
	private String osBtnPosChgFront1;

	// ボタン位置変更 フロント第2釦
	private String osBtnPosChgFront2;
	
	//カジュアルヘムライン値
	private BigDecimal stCasualHemlineSize;

	public String getOsChainModel() {
		return osChainModel;
	}

	public void setOsChainModel(String osChainModel) {
		this.osChainModel = osChainModel;
	}

	public Map<String, String> getOsChainModelMap() {
		return osChainModelMap;
	}

	public void setOsChainModelMap(Map<String, String> osChainModelMap) {
		this.osChainModelMap = osChainModelMap;
	}

	public String getOsCuffs() {
		return osCuffs;
	}

	public void setOsCuffs(String osCuffs) {
		this.osCuffs = osCuffs;
	}

	public Map<String, String> getOsCuffsMap() {
		return osCuffsMap;
	}

	public void setOsCuffsMap(Map<String, String> osCuffsMap) {
		this.osCuffsMap = osCuffsMap;
	}

	public String getOsConvertible() {
		return osConvertible;
	}

	public void setOsConvertible(String osConvertible) {
		this.osConvertible = osConvertible;
	}

	public Map<String, String> getOsConvertibleMap() {
		return osConvertibleMap;
	}

	public void setOsConvertibleMap(Map<String, String> osConvertibleMap) {
		this.osConvertibleMap = osConvertibleMap;
	}

	public String getOsAdjustBtn() {
		return osAdjustBtn;
	}

	public void setOsAdjustBtn(String osAdjustBtn) {
		this.osAdjustBtn = osAdjustBtn;
	}

	public Map<String, String> getOsAdjustBtnMap() {
		return osAdjustBtnMap;
	}

	public void setOsAdjustBtnMap(Map<String, String> osAdjustBtnMap) {
		this.osAdjustBtnMap = osAdjustBtnMap;
	}

	public String getOsDblCuff() {
		return osDblCuff;
	}

	public void setOsDblCuff(String osDblCuff) {
		this.osDblCuff = osDblCuff;
	}

	public Map<String, String> getOsDblCuffMap() {
		return osDblCuffMap;
	}

	public void setOsDblCuffMap(Map<String, String> osDblCuffMap) {
		this.osDblCuffMap = osDblCuffMap;
	}

	public String getOsClericSpec() {
		return osClericSpec;
	}

	public void setOsClericSpec(String osClericSpec) {
		this.osClericSpec = osClericSpec;
	}

	public Map<String, String> getOsClericSpecMap() {
		return osClericSpecMap;
	}

	public void setOsClericSpecMap(Map<String, String> osClericSpecMap) {
		this.osClericSpecMap = osClericSpecMap;
	}

	public String getOsBtnMate() {
		return osBtnMate;
	}

	public void setOsBtnMate(String osBtnMate) {
		this.osBtnMate = osBtnMate;
	}

	public Map<String, String> getOsBtnMateMap() {
		return osBtnMateMap;
	}

	public void setOsBtnMateMap(Map<String, String> osBtnMateMap) {
		this.osBtnMateMap = osBtnMateMap;
	}

	public String getOsGaletteBtnPos() {
		return osGaletteBtnPos;
	}

	public void setOsGaletteBtnPos(String osGaletteBtnPos) {
		this.osGaletteBtnPos = osGaletteBtnPos;
	}

	public Map<String, String> getOsGaletteBtnPosMap() {
		return osGaletteBtnPosMap;
	}

	public void setOsGaletteBtnPosMap(Map<String, String> osGaletteBtnPosMap) {
		this.osGaletteBtnPosMap = osGaletteBtnPosMap;
	}

	public String getOsPinHolePin() {
		return osPinHolePin;
	}

	public void setOsPinHolePin(String osPinHolePin) {
		this.osPinHolePin = osPinHolePin;
	}

	public Map<String, String> getOsPinHolePinMap() {
		return osPinHolePinMap;
	}

	public void setOsPinHolePinMap(Map<String, String> osPinHolePinMap) {
		this.osPinHolePinMap = osPinHolePinMap;
	}

	public String getOsBreastPk() {
		return osBreastPk;
	}

	public void setOsBreastPk(String osBreastPk) {
		this.osBreastPk = osBreastPk;
	}

	public Map<String, String> getOsBreastPkMap() {
		return osBreastPkMap;
	}

	public void setOsBreastPkMap(Map<String, String> osBreastPkMap) {
		this.osBreastPkMap = osBreastPkMap;
	}

	public String getOsFrontDesign() {
		return osFrontDesign;
	}

	public void setOsFrontDesign(String osFrontDesign) {
		this.osFrontDesign = osFrontDesign;
	}

	public Map<String, String> getOsFrontDesignMap() {
		return osFrontDesignMap;
	}

	public void setOsFrontDesignMap(Map<String, String> osFrontDesignMap) {
		this.osFrontDesignMap = osFrontDesignMap;
	}

	public String getOsPinTack() {
		return osPinTack;
	}

	public void setOsPinTack(String osPinTack) {
		this.osPinTack = osPinTack;
	}

	public Map<String, String> getOsPinTackMap() {
		return osPinTackMap;
	}

	public void setOsPinTackMap(Map<String, String> osPinTackMap) {
		this.osPinTackMap = osPinTackMap;
	}

	public String getOsStitch() {
		return osStitch;
	}

	public void setOsStitch(String osStitch) {
		this.osStitch = osStitch;
	}

	public Map<String, String> getOsStitchMap() {
		return osStitchMap;
	}

	public void setOsStitchMap(Map<String, String> osStitchMap) {
		this.osStitchMap = osStitchMap;
	}

	public String getOsColorKeeper() {
		return osColorKeeper;
	}

	public void setOsColorKeeper(String osColorKeeper) {
		this.osColorKeeper = osColorKeeper;
	}

	public Map<String, String> getOsColorKeeperMap() {
		return osColorKeeperMap;
	}

	public void setOsColorKeeperMap(Map<String, String> osColorKeeperMap) {
		this.osColorKeeperMap = osColorKeeperMap;
	}

	public String getOsByColor() {
		return osByColor;
	}

	public void setOsByColor(String osByColor) {
		this.osByColor = osByColor;
	}

	public Map<String, String> getOsByColorMap() {
		return osByColorMap;
	}

	public void setOsByColorMap(Map<String, String> osByColorMap) {
		this.osByColorMap = osByColorMap;
	}

	public String getOsBhColor() {
		return osBhColor;
	}

	public void setOsBhColor(String osBhColor) {
		this.osBhColor = osBhColor;
	}

	public Map<String, String> getOsBhColorMap() {
		return osBhColorMap;
	}

	public void setOsBhColorMap(Map<String, String> osBhColorMap) {
		this.osBhColorMap = osBhColorMap;
	}

	public String getOsBtnPosChgCollar() {
		return osBtnPosChgCollar;
	}

	public void setOsBtnPosChgCollar(String osBtnPosChgCollar) {
		this.osBtnPosChgCollar = osBtnPosChgCollar;
	}

	public String getOsBtnPosChgFront1() {
		return osBtnPosChgFront1;
	}

	public void setOsBtnPosChgFront1(String osBtnPosChgFront1) {
		this.osBtnPosChgFront1 = osBtnPosChgFront1;
	}

	public String getOsBtnPosChgFront2() {
		return osBtnPosChgFront2;
	}

	public void setOsBtnPosChgFront2(String osBtnPosChgFront2) {
		this.osBtnPosChgFront2 = osBtnPosChgFront2;
	}

	public String getOsShirtModel() {
		return osShirtModel;
	}

	public void setOsShirtModel(String osShirtModel) {
		this.osShirtModel = osShirtModel;
	}

	public Map<String, String> getOsShirtModelMap() {
		return osShirtModelMap;
	}

	public void setOsShirtModelMap(Map<String, String> osShirtModelMap) {
		this.osShirtModelMap = osShirtModelMap;
	}

	public String getOsAddCuff() {
		return osAddCuff;
	}

	public void setOsAddCuff(String osAddCuff) {
		this.osAddCuff = osAddCuff;
	}

	public Map<String, String> getOsAddCuffMap() {
		return osAddCuffMap;
	}

	public void setOsAddCuffMap(Map<String, String> osAddCuffMap) {
		this.osAddCuffMap = osAddCuffMap;
	}

	public String getOsTabBtn() {
		return osTabBtn;
	}

	public void setOsTabBtn(String osTabBtn) {
		this.osTabBtn = osTabBtn;
	}

	public Map<String, String> getOsTabBtnMap() {
		return osTabBtnMap;
	}

	public void setOsTabBtnMap(Map<String, String> osTabBtnMap) {
		this.osTabBtnMap = osTabBtnMap;
	}

	public String getOsBreastPkSize() {
		return osBreastPkSize;
	}

	public void setOsBreastPkSize(String osBreastPkSize) {
		this.osBreastPkSize = osBreastPkSize;
	}

	public Map<String, String> getOsBreastPkSizeMap() {
		return osBreastPkSizeMap;
	}

	public void setOsBreastPkSizeMap(Map<String, String> osBreastPkSizeMap) {
		this.osBreastPkSizeMap = osBreastPkSizeMap;
	}

	public String getOsCasHemLine() {
		return osCasHemLine;
	}

	public void setOsCasHemLine(String osCasHemLine) {
		this.osCasHemLine = osCasHemLine;
	}

	public Map<String, String> getOsCasHemLineMap() {
		return osCasHemLineMap;
	}

	public void setOsCasHemLineMap(Map<String, String> osCasHemLineMap) {
		this.osCasHemLineMap = osCasHemLineMap;
	}

	public String getOsBtnPosChg() {
		return osBtnPosChg;
	}

	public void setOsBtnPosChg(String osBtnPosChg) {
		this.osBtnPosChg = osBtnPosChg;
	}

	public Map<String, String> getOsBtnPosChgMap() {
		return osBtnPosChgMap;
	}

	public void setOsBtnPosChgMap(Map<String, String> osBtnPosChgMap) {
		this.osBtnPosChgMap = osBtnPosChgMap;
	}

	public BigDecimal getStCasualHemlineSize() {
		return stCasualHemlineSize;
	}

	public void setStCasualHemlineSize(BigDecimal stCasualHemlineSize) {
		this.stCasualHemlineSize = stCasualHemlineSize;
	}
	
}
