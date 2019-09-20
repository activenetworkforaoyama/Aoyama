package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class CoOptionShirtStandardInfo implements Serializable {
	private static final long serialVersionUID = -3593141126900298826L;

	// SHIRTモデル
	private String osShirtModel;

	private Map<String, String> osShirtModelMap;

	// 襟型
	private String osChainModel;

	private Map<String, String> osChainModelMap;

	private String stCollarTypeRtPrice;

	// カフス
	private String osCuffs;

	private Map<String, String> osCuffsMap;

	private String stCuffsRtPrice;

	// コンバーチブル
	private String osConvertible;

	private Map<String, String> osConvertibleMap;

	private String stConvertibleRtPrice;

	// アジャスト釦
	private String osAdjustBtn;

	private Map<String, String> osAdjustBtnMap;

	private String stAdjusterBtnRtPrice;

	// クレリック仕様
	private String osClericSpec;

	private Map<String, String> osClericSpecMap;

	private String stClericRtPrice;

	// ダブルカフス仕様
	private String osDblCuff;

	private Map<String, String> osDblCuffMap;

	private String stDblCuffsRtPrice;

	// カフスボタン追加
	private String osAddCuff;

	private Map<String, String> osAddCuffMap;

	private String stCuffsBtnRtPrice;

	// 釦素材
	private String osBtnMate;

	private Map<String, String> osBtnMateMap;

	private String stBtnMaterialRtPrice;

	// タブ釦
	private String osTabBtn;

	private Map<String, String> osTabBtnMap;

	private String stDblBtnRtPrice;

	// ガントレットボタン位置
	private String osGaletteBtnPos;

	private Map<String, String> osGaletteBtnPosMap;

	private String stGauntletBtnPosRtPrice;

	// ピンホールピン
	private String osPinHolePin;

	private Map<String, String> osPinHolePinMap;

	private String stPinholePinRtPrice;

	// 胸ポケット
	private String osBreastPk;

	private Map<String, String> osBreastPkMap;

	private String stBreastPktRtPrice;

	// 胸ポケット大きさ
	private String osBreastPkSize;

	private Map<String, String> osBreastPkSizeMap;

	private String stBreastSizeRtPrice;

	// フロントデザイン
	private String osFrontDesign;

	private Map<String, String> osFrontDesignMap;

	private String stFrtDesignRtPrice;

	// ピンタックブザム
	private String osPinTack;

	private Map<String, String> osPinTackMap;

	private String stPintuckBosomRtPrice;

	// ステッチ
	private String osStitch;

	private Map<String, String> osStitchMap;

	private String stStitchRtPrice;

	// カラーキーパー
	private String osColorKeeper;

	private Map<String, String> osColorKeeperMap;

	private String stColarKeeperRtPrice;

	// ボタン付け糸色変更
	private String osByColor;

	private Map<String, String> osByColorMap;

	private String stBtnthreadColorRtPrice;

	// ボタンホール色変更
	private String osBhColor;

	private Map<String, String> osBhColorMap;

	private String stBtnholeColorRtPrice;

	// カジュアルヘムライン仕様
	private String osCasHemLine;

	private Map<String, String> osCasHemLineMap;

	private String stCasualHemlineRtPrice;

	// ボタン位置変更
	private String osBtnPosChg;

	private Map<String, String> osBtnPosChgMap;

	private String stBtnposChgRtPrice;

	// ボタン位置変更 台襟釦
	private String osBtnPosChgCollar;

	// ボタン位置変更 フロント第1釦
	private String osBtnPosChgFront1;

	// ボタン位置変更 フロント第2釦
	private String osBtnPosChgFront2;

	// カジュアルヘムライン値
	private BigDecimal stCasualHemlineSize;

	// ボタン位置変更 台襟釦値
	private BigDecimal stNeckbandBtnPosChg;

	// ボタン位置変更 フロント第1釦値
	private BigDecimal stFrtfirstBtnPosChg;

	// ボタン位置変更 フロント第2釦値
	private BigDecimal stFrtsecondBtnPosChg;
	
	//刺繍箇所
	private Map<String, String> productEmbroideryNmPosMap;
	
	//ガゼット刺繍
	private Map<String, String> productEmbroideryGazetteMap;
	
	//刺繍糸色
	private Map<String, String> stProductEmbroideryThreadColorMap;
	
	//背ダーツ出し
	private Map<String, String> corStBackdartsUnpackCorrectMap;
	
	public Map<String, String> getCorStBackdartsUnpackCorrectMap() {
		return corStBackdartsUnpackCorrectMap;
	}

	public void setCorStBackdartsUnpackCorrectMap(Map<String, String> corStBackdartsUnpackCorrectMap) {
		this.corStBackdartsUnpackCorrectMap = corStBackdartsUnpackCorrectMap;
	}

	public Map<String, String> getProductEmbroideryNmPosMap() {
		return productEmbroideryNmPosMap;
	}

	public void setProductEmbroideryNmPosMap(Map<String, String> productEmbroideryNmPosMap) {
		this.productEmbroideryNmPosMap = productEmbroideryNmPosMap;
	}

	public Map<String, String> getProductEmbroideryGazetteMap() {
		return productEmbroideryGazetteMap;
	}

	public void setProductEmbroideryGazetteMap(Map<String, String> productEmbroideryGazetteMap) {
		this.productEmbroideryGazetteMap = productEmbroideryGazetteMap;
	}

	public Map<String, String> getStProductEmbroideryThreadColorMap() {
		return stProductEmbroideryThreadColorMap;
	}

	public void setStProductEmbroideryThreadColorMap(Map<String, String> stProductEmbroideryThreadColorMap) {
		this.stProductEmbroideryThreadColorMap = stProductEmbroideryThreadColorMap;
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

	public String getStCollarTypeRtPrice() {
		return stCollarTypeRtPrice;
	}

	public void setStCollarTypeRtPrice(String stCollarTypeRtPrice) {
		this.stCollarTypeRtPrice = stCollarTypeRtPrice;
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

	public String getStCuffsRtPrice() {
		return stCuffsRtPrice;
	}

	public void setStCuffsRtPrice(String stCuffsRtPrice) {
		this.stCuffsRtPrice = stCuffsRtPrice;
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

	public String getStConvertibleRtPrice() {
		return stConvertibleRtPrice;
	}

	public void setStConvertibleRtPrice(String stConvertibleRtPrice) {
		this.stConvertibleRtPrice = stConvertibleRtPrice;
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

	public String getStAdjusterBtnRtPrice() {
		return stAdjusterBtnRtPrice;
	}

	public void setStAdjusterBtnRtPrice(String stAdjusterBtnRtPrice) {
		this.stAdjusterBtnRtPrice = stAdjusterBtnRtPrice;
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

	public String getStClericRtPrice() {
		return stClericRtPrice;
	}

	public void setStClericRtPrice(String stClericRtPrice) {
		this.stClericRtPrice = stClericRtPrice;
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

	public String getStDblCuffsRtPrice() {
		return stDblCuffsRtPrice;
	}

	public void setStDblCuffsRtPrice(String stDblCuffsRtPrice) {
		this.stDblCuffsRtPrice = stDblCuffsRtPrice;
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

	public String getStCuffsBtnRtPrice() {
		return stCuffsBtnRtPrice;
	}

	public void setStCuffsBtnRtPrice(String stCuffsBtnRtPrice) {
		this.stCuffsBtnRtPrice = stCuffsBtnRtPrice;
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

	public String getStBtnMaterialRtPrice() {
		return stBtnMaterialRtPrice;
	}

	public void setStBtnMaterialRtPrice(String stBtnMaterialRtPrice) {
		this.stBtnMaterialRtPrice = stBtnMaterialRtPrice;
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

	public String getStDblBtnRtPrice() {
		return stDblBtnRtPrice;
	}

	public void setStDblBtnRtPrice(String stDblBtnRtPrice) {
		this.stDblBtnRtPrice = stDblBtnRtPrice;
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

	public String getStGauntletBtnPosRtPrice() {
		return stGauntletBtnPosRtPrice;
	}

	public void setStGauntletBtnPosRtPrice(String stGauntletBtnPosRtPrice) {
		this.stGauntletBtnPosRtPrice = stGauntletBtnPosRtPrice;
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

	public String getStPinholePinRtPrice() {
		return stPinholePinRtPrice;
	}

	public void setStPinholePinRtPrice(String stPinholePinRtPrice) {
		this.stPinholePinRtPrice = stPinholePinRtPrice;
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

	public String getStBreastPktRtPrice() {
		return stBreastPktRtPrice;
	}

	public void setStBreastPktRtPrice(String stBreastPktRtPrice) {
		this.stBreastPktRtPrice = stBreastPktRtPrice;
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

	public String getStBreastSizeRtPrice() {
		return stBreastSizeRtPrice;
	}

	public void setStBreastSizeRtPrice(String stBreastSizeRtPrice) {
		this.stBreastSizeRtPrice = stBreastSizeRtPrice;
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

	public String getStFrtDesignRtPrice() {
		return stFrtDesignRtPrice;
	}

	public void setStFrtDesignRtPrice(String stFrtDesignRtPrice) {
		this.stFrtDesignRtPrice = stFrtDesignRtPrice;
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

	public String getStPintuckBosomRtPrice() {
		return stPintuckBosomRtPrice;
	}

	public void setStPintuckBosomRtPrice(String stPintuckBosomRtPrice) {
		this.stPintuckBosomRtPrice = stPintuckBosomRtPrice;
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

	public String getStStitchRtPrice() {
		return stStitchRtPrice;
	}

	public void setStStitchRtPrice(String stStitchRtPrice) {
		this.stStitchRtPrice = stStitchRtPrice;
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

	public String getStColarKeeperRtPrice() {
		return stColarKeeperRtPrice;
	}

	public void setStColarKeeperRtPrice(String stColarKeeperRtPrice) {
		this.stColarKeeperRtPrice = stColarKeeperRtPrice;
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

	public String getStBtnthreadColorRtPrice() {
		return stBtnthreadColorRtPrice;
	}

	public void setStBtnthreadColorRtPrice(String stBtnthreadColorRtPrice) {
		this.stBtnthreadColorRtPrice = stBtnthreadColorRtPrice;
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

	public String getStBtnholeColorRtPrice() {
		return stBtnholeColorRtPrice;
	}

	public void setStBtnholeColorRtPrice(String stBtnholeColorRtPrice) {
		this.stBtnholeColorRtPrice = stBtnholeColorRtPrice;
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

	public String getStCasualHemlineRtPrice() {
		return stCasualHemlineRtPrice;
	}

	public void setStCasualHemlineRtPrice(String stCasualHemlineRtPrice) {
		this.stCasualHemlineRtPrice = stCasualHemlineRtPrice;
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

	public String getStBtnposChgRtPrice() {
		return stBtnposChgRtPrice;
	}

	public void setStBtnposChgRtPrice(String stBtnposChgRtPrice) {
		this.stBtnposChgRtPrice = stBtnposChgRtPrice;
	}

	public BigDecimal getStCasualHemlineSize() {
		return stCasualHemlineSize;
	}

	public void setStCasualHemlineSize(BigDecimal stCasualHemlineSize) {
		this.stCasualHemlineSize = stCasualHemlineSize;
	}

	public BigDecimal getStNeckbandBtnPosChg() {
		return stNeckbandBtnPosChg;
	}

	public void setStNeckbandBtnPosChg(BigDecimal stNeckbandBtnPosChg) {
		this.stNeckbandBtnPosChg = stNeckbandBtnPosChg;
	}

	public BigDecimal getStFrtfirstBtnPosChg() {
		return stFrtfirstBtnPosChg;
	}

	public void setStFrtfirstBtnPosChg(BigDecimal stFrtfirstBtnPosChg) {
		this.stFrtfirstBtnPosChg = stFrtfirstBtnPosChg;
	}

	public BigDecimal getStFrtsecondBtnPosChg() {
		return stFrtsecondBtnPosChg;
	}

	public void setStFrtsecondBtnPosChg(BigDecimal stFrtsecondBtnPosChg) {
		this.stFrtsecondBtnPosChg = stFrtsecondBtnPosChg;
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

}
