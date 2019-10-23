package co.jp.aoyama.macchinetta.app.order;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import co.jp.aoyama.macchinetta.app.order.OrderForm.ShopItem;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustShirtStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoCustomerMessageInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoMeasuringInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketWashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionShirtStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoProductInfo;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.Yield;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderCoForm implements Serializable {

	private static final long serialVersionUID = -5104739132232852696L;

	// グループ:Jacket 標準
    public static interface JkStItem {
    };

    // グループ:Jacket 標準ステッチ
    public static interface JkStStitchItem {
    };
    
    // グループ:Jacket 標準袖裏素材
    public static interface JkStCuffBackMateItem {
    };
    
    // グループ:Jacket タキシード
    public static interface JkTuItem {
    };
    
    // グループ:Jacket タキシード 釦素材
    public static interface JkTuBtnMateItem {
    };
    
    // グループ:Jacket ウォッシャブル
    public static interface JkWaItem {
    };
    
    // グループ:Jacket 補正
    public static interface JkAdItem {
    };
    
    // グループ:Pants 標準
    public static interface PtStItem {
    };
    
 	// グループ:Pants 標準膝裏
    public static interface PtStOpKneeBackItem {
    };
    
    // グループ:Pants 標準裾上げ
    public static interface PtStOpHemUpItem {
    };
    
    // グループ:Pants 標準AMFステッチ
    public static interface PtStOpStitchItem {
    };
    
    // グループ:Pants タキシード
    public static interface PtTuItem {
    };
    
    // グループ:Pants タキシード膝裏
    public static interface PtTuTpKneeBackItem {
    };
    
    // グループ:Pants タキシード裾上げ
    public static interface PtTuTpHemUpItem {
    };
    
    // グループ:Pants ウォッシャブル
    public static interface PtWaItem {
    };
    
    // グループ:Pants ウォッシャブル膝裏
    public static interface PtWaWpKneeBackItem {
    };

    // グループ:Pants ウォッシャブル裾上げ
    public static interface PtWaWpHemUpItem {
    };
    
    // グループ:Pants 補正
    public static interface PtAdItem {
    };
    
    // グループ:Pants モデル
    public static interface PtThreeModelItem {
    };
    
    public static interface HemwidthPtAdItem {
    };
    
    public static interface HemwidthDegignatePtAdItem {
    };
    
    // グループ:Gilet 標準
    public static interface GlStItem {
    };
    
    // グループ:Gilet 腰ポケット形状
    public static interface GlStWaistPktSpecItem {
    };
    
    // グループ:Gilet 標準ステッチ
    public static interface GlStStitchItem {
    };
    
    // グループ:Gilet 標準背裏地素材
    public static interface GlBackLiningMateItem {
    };
    
    // グループ:Gilet タキシード
    public static interface GlTuItem {
    };
    
    // グループ:Gilet タキシード背裏地素材
    public static interface GlTuBackLiningMateItem {
    };
    
    // グループ:Gilet タキシード釦素材
    public static interface GlTuFrontBtnMateItem {
    };
    
    // グループ:Gilet 腰ポケット形状
    public static interface GlTuWaistPktSpecItem {
    };
    
    // グループ:Gilet ウォッシャブル
    public static interface GlWaItem {
    };
    
    // グループ:Gilet 腰ポケット形状
    public static interface GlWaWaistPktSpecItem {
    };
    
    // グループ:Gilet 背裏地素材
    public static interface GlWaBackLiningMateItem {
    };
    
    // グループ:Gilet 補正
    public static interface GlAdItem {
    };
    
    // グループ:2Pants 標準
    public static interface Pt2StItem {
    };
    
    // グループ:2Pants 標準膝裏
    public static interface Pt2StOpKneeBackItem {
    };
    
    // グループ:2Pants 標準裾上げ
    public static interface Pt2StOpHemUpItem {
    };
    
    // グループ:2Pants 標準AMFステッチ
    public static interface Pt2StOpStitchItem {
    };
    
    // グループ:2Pants タキシード
    public static interface Pt2TuItem {
    };
    
    // グループ:2Pants タキシード膝裏
    public static interface Pt2TuTpKneeBackItem {
    };
    
    // グループ:2Pants タキシード裾上げ
    public static interface Pt2TuTpHemUpItem {
    };
    
    // グループ:2Pants ウォッシャブル
    public static interface Pt2WaItem {
    };
    
    // グループ:2Pants ウォッシャブル膝裏
    public static interface Pt2WaWpKneeBackItem {
    };

    // グループ:2Pants ウォッシャブル裾上げ
    public static interface Pt2WaWpHemUpItem {
    };
    
    // グループ:2Pants 補正
    public static interface Pt2AdItem {
    };
    
    // グループ:2Pants モデル
    public static interface Pt2ThreeModelItem {
    };
    
    public static interface HemwidthPt2AdItem {
    };
    
    public static interface HemwidthDegignatePt2AdItem {
    };
    
    // グループ:Shirt 標準
    public static interface ShirtItem {
    };
    
    // グループ:Shirt 補正
    public static interface ShirtAdItem {
    };
    
    // グループ: 胸ポケット-> 胸ポケット大きさ
    public static interface StBreastPkSizeItem {
    };
    
	// グループ: カジュアルヘムライン仕様 無し -> 有り
    public static interface StCasualHemlineSizeItem {
    };
    
    // グループ: ボタン位置変更  無し -> 有り
    public static interface StBtnPosChgItem {
    };
    
    // グループ:Coat 標準
    public static interface CoatItem {
    };
    
    // グループ:Coat 補正
    public static interface CoatAdItem {
    };
    
    // グループ:shippingDestination（出荷先）
    public static interface ShippingDestinationItem {
    };
    
    // グループ:EmbroideredItem（刺繍入れ）
    public static interface EmbroideredItem {
    };
    
    // グループ:EmbroideredItem（刺繍入れ）
    public static interface EmbroideredShirtItem {
    };
    
    // グループ:残布
    public static interface RemainingClothItem {
    };
    
    // グループ:店舗コード 業態  店舗名
    public static interface ShopItem {
    };
	// メジャーリング
    @Valid
	private CoMeasuringInfo coMeasuringInfo;

	// お客様情報
    @Valid
	private CoCustomerMessageInfo coCustomerMessageInfo;

	// PANTS Standard
    @Valid
	private CoOptionPantsStandardInfo coOptionPantsStandardInfo;

	// 2PANTS Standard
    @Valid
	private CoOptionPants2StandardInfo coOptionPants2StandardInfo;

	// PANTS Tuxedo
    @Valid
	private CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo;

	// 2PANTS Tuxedo
    @Valid
	private CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo;

	// PANTS Washable
    @Valid
	private CoOptionPantsWashableInfo coOptionPantsWashableInfo;

	// 2PANTS Washable
    @Valid
	private CoOptionPants2WashableInfo coOptionPants2WashableInfo;

	// JACKET Standard
    @Valid
	private CoOptionJacketStandardInfo coOptionJacketStandardInfo;

	// JACKET Tuxedo
    @Valid
	private CoOptionJacketTuxedoInfo coOptionJacketTuxedoInfo;

	// JACKET Washable
    @Valid
	private CoOptionJacketWashableInfo coOptionJacketWashableInfo;

	// GILET Standard
    @Valid
	private CoOptionGiletStandardInfo coOptionGiletStandardInfo;

	// GILET Tuxedo
    @Valid
	private CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo;

	// GILET Washable
    @Valid
	private CoOptionGiletWashableInfo coOptionGiletWashableInfo;

	// SHIRT Standard
    @Valid
	private CoOptionShirtStandardInfo coOptionShirtStandardInfo;

	// COAT Standard
    @Valid
	private CoOptionCoatStandardInfo coOptionCoatStandardInfo;

	// Product
	private CoProductInfo coProductInfo;
 
	// オプション価格
	private List<OrderCodePrice> orderCodePriceList;

	// JACKET補正
	@Valid
	private CoAdjustJacketStandardInfo coAdjustJacketStandardInfo;

	// PANTS補正
	@Valid
	private CoAdjustPantsStandardInfo coAdjustPantsStandardInfo;

	// PANTS2補正
	@Valid
	private CoAdjustPants2StandardInfo coAdjustPants2StandardInfo;

	// GILET補正
	@Valid
	private CoAdjustGiletStandardInfo coAdjustGiletStandardInfo;

	// Shirt補正
	@Valid
	private CoAdjustShirtStandardInfo coAdjustShirtStandardInfo;

	// Coat補正
	@Valid
	private CoAdjustCoatStandardInfo coAdjustCoatStandardInfo;

	//店舗コード TSC/UMLと青山で異なる店舗ｺｰﾄを登録
	@NotBlank(groups = {ShopItem.class},message = "店舗コード が不正です。")
	private String shopCode;
		
	//業態
	@NotBlank(groups = {ShopItem.class},message = "業態コード が不正です。")
	private String storeBrandCode;
		
	//店舗・担当_店舗名
	@NotBlank(groups = {ShopItem.class},message = "店舗名が不正です。")
	private String storeNm;

	// 商品情報_ITEM
	@NotBlank(groups = {Default.class},message = "アイテムを入力して下さい。")
	private String productItem;

	private Map<String, String> productItemMap;

	// 商品情報_３Piece
	@NotBlank(groups = {Default.class},message = "３Pieceを入力して下さい。")
	private String productIs3Piece;

	// 商品情報_スペアパンツ
	@NotBlank(groups = {Default.class},message = "スペアパンツを入力して下さい。")
	private String productSparePantsClass;

	// 商品情報_生地番号
	@NotBlank(groups = {Default.class},message = "生地番号を入力して下さい。")
	private String productFabricNo;

	// 商品情報_カテゴリ
	@NotBlank(groups = {Default.class},message = "カテゴリを入力して下さい。")
	private String productCategory;

	// 商品情報_ブランド区分
	private String productBrandType;

	// 商品情報_ブランドネーム
	@NotBlank(groups = {Default.class},message = "ブランドネームを入力して下さい。")
	private String productBrandNm;

	// 商品情報_生地ネーム
	@NotBlank(groups = {Default.class},message = "生地ネームを入力して下さい。")
	private String productFabricNmNecessity;

	// 商品情報_刺繍入れ
	@NotBlank(groups = {Default.class},message = "刺繍入れを入力して下さい。")
	private String productEmbroideryNecessity;

	// 商品情報_刺繍ネーム
	@NotBlank(groups = {EmbroideredItem.class,EmbroideredShirtItem.class},message = "刺繍ネームを入力して下さい。")
	private String productEmbroideryNm;

	// 商品情報_刺繍書体
	@NotBlank(groups = {EmbroideredItem.class,EmbroideredShirtItem.class},message = "刺繍書体を入力して下さい。")
	private String productEmbroideryFont;

	// 商品情報_刺繍糸色
	@NotBlank(groups = {EmbroideredItem.class},message = "刺繍糸色を入力して下さい。")
	private String jkProductEmbroideryThreadColor;
	
	// 商品情報_刺繍糸色
	@NotBlank(groups = {EmbroideredShirtItem.class},message = "刺繍糸色を入力して下さい。")
	private String stProductEmbroideryThreadColor;

	// 商品情報_ガゼット刺繍
	@NotBlank(groups = {EmbroideredShirtItem.class},message = "ガゼット刺繍を入力して下さい。")
	private String productEmbroideryGazette;

	// 商品情報_ネーム刺繍位置
	@NotBlank(groups = {EmbroideredShirtItem.class},message = "刺繍箇所を入力して下さい。")
	private String productEmbroideryNmPos;

	// 商品情報_刺繍サイズ（縦）
	@NotBlank(groups = {EmbroideredShirtItem.class},message = "刺繍サイズ（縦）を入力して下さい。")
	private String productEmbroideryLength;

	// 商品情報_刺繍サイズ（横）
	@NotBlank(groups = {EmbroideredShirtItem.class},message = "刺繍サイズ（横）を入力して下さい。")
	private String productEmbroideryWidth;

	// 商品情報_残布_type
	@NotBlank(groups = {RemainingClothItem.class},message = "残布を入力して下さい。")
	private String productRemainingClothType;

	// 商品情報_残布_名
	private String productRemainingClothNm;

	// 商品情報_生地ブランド
	@NotBlank(groups = {Default.class},message = "生地ブランドが不正です。")
	private String productFabricBrandNm;

	// 商品情報_サービスネーム
	@NotBlank(groups = {Default.class},message = "素材名をが不正です。")
	private String productServiceNm;
	
	// 商品情報_組成表示_表地
	@NotBlank(groups = {Default.class},message = "組成表示　表地が不正です。")
	private String productComposFrtFabric;

	// 商品情報_組成表示_胴裏地
	@NotBlank(groups = {JkStItem.class,JkTuItem.class,JkWaItem.class,GlStItem.class,GlTuItem.class,GlWaItem.class,CoatItem.class},message = "組成表示　胴裏地が不正です。")
	private String productComposBodyLiner;

	// 商品情報_組成表示_袖裏地
	@NotBlank(groups = {JkStItem.class,JkTuItem.class,JkWaItem.class,CoatItem.class},message = "組成表示　袖裏地が不正です。")
	private String productComposSleeveLiner;

	// 商品情報_取扱注意
	private String productNotice;

	// ステータス
	private String status;

	// ご請求金額
	@NotBlank(groups = {Default.class},message = "ご請求金額が不正です。")
	private String billingAmount;

	// 商品金額
	@NotBlank(groups = {Default.class},message = "商品金額が不正です。")
	private String productPrice;

	// オプション金額
	@NotBlank(groups = {Default.class},message = "オプション金額が不正です。")
	private String optionPrice;

	// 合計金額
	@NotBlank(groups = {Default.class},message = "合計金額が不正です。")
	private String totalPrice;

	// 内消費税
	@NotBlank(groups = {Default.class},message = "内消費税が不正です。")
	private String consumptionTaxAmount;
	
	private String is3PiecePrice;
	
	private String is2PantsPrice;

	// オーダーパターン
	@NotBlank(groups = {Default.class},message = "オーダーパターンが不正です。")
	private String orderPattern;

	// 理論生地使用量
	@NotBlank(groups = {Default.class},message = "理論生地使用量が不正です。")
	private String theoryFabricUsedMount;

	// 権限
	private String authority;

	// 店舗再補正入力欄
	private String corStoreCorrectionMemoAgain;
	private String corStoreCorrectionMemo;
	// 消費税
	private String taxRate;

	// 要尺
	private String yield;

	// 更新確認
	private String isUpdate;

	// 生地_色
	@NotBlank(groups = {Default.class},message = "生地品番　色が不正です。")
	private String fabricColor;

	// 生地_柄
	@NotBlank(groups = {Default.class},message = "生地品番　柄が不正です。")
	private String fabricPattern;

	// 商品情報_工場
	@NotBlank(groups = {Default.class},message = "工場コードが不正です。")
	private String productFactoryCd;

	// 商品情報_メーカーコード
	@NotBlank(groups = {Default.class},message = "メーカーコードが不正です。")
	private String productMakerCode;

	// 商品情報_LCR縫製
	private String productLcrSewing;

	// 納期短縮
	@NotBlank(groups = {Default.class},message = "納期短縮を入力して下さい。")
	private String custIsDeliverShortning;

	// 早割
	@NotBlank(groups = {Default.class},message = "早割を入力して下さい。")
	private String custIsEarlyDiscount;
	
	private List<Yield> yieldList;
	
	private String expediteDeliveryPrice;
	
	private String lcrSewingPrice;

	// 保存flag
	private String saveFlag;

	private String orderFlag;

	private String version;

	private String jacketItemFlag;

	private String pantsItemFlag;

	private String giletItemFlag;

	private String shirtItemFlag;

	private String coatItemFlag;

	private String pants2ItemFlag;

	private String jacketFlag;

	private String pantsFlag;
	
	private String pants2Flag;

	private String giletFlag;

	private String coatFlag;

	private String shirtFlag;

	private String fabricFlag;

	// 補正
	private String jacketAdFlag;

	private String pantsAdFlag;

	private String pants2AdFlag;

	private String giletAdFlag;

	private String coatAdFlag;

	private String shirtAdFlag;
	
	private String itemCoFlag;
	
	private String itemCoChangeFlag;
	
	private String ojBtnMatePtFlag;
	
	private String ojBtnMatePt2Flag;
	
	private String jacketBtnMateGlFlag;
	
	
	private String osCasHemLineIdFlag;
	
	private String orderTscStatus;

	//
	private OrderFindFabric orderFindFabric;

	private String orderFindFabricStr;

	private String jkOptionPrice;

	private String ptOptionPrice;

	private String pt2OptionPrice;

	private String glOptionPrice;

	private String ctOptionPrice;

	private String stOptionPrice;
	
	private String embroideryNmPosPrice;
	
	private String gadgetPrice;

	// ModelDoublePrice
	private String jkDoubleModelPrice;

	private String ctDoubleModelPrice;

	private String glDoubleModelPrice;
	
	
	public String getGadgetPrice() {
		return gadgetPrice;
	}

	public void setGadgetPrice(String gadgetPrice) {
		this.gadgetPrice = gadgetPrice;
	}

	public String getEmbroideryNmPosPrice() {
		return embroideryNmPosPrice;
	}

	public void setEmbroideryNmPosPrice(String embroideryNmPosPrice) {
		this.embroideryNmPosPrice = embroideryNmPosPrice;
	}

	public String getJacketFlag() {
		return jacketFlag;
	}

	public void setJacketFlag(String jacketFlag) {
		this.jacketFlag = jacketFlag;
	}

	public String getCustIsDeliverShortning() {
		return custIsDeliverShortning;
	}

	public void setCustIsDeliverShortning(String custIsDeliverShortning) {
		this.custIsDeliverShortning = custIsDeliverShortning;
	}

	public String getCustIsEarlyDiscount() {
		return custIsEarlyDiscount;
	}

	public void setCustIsEarlyDiscount(String custIsEarlyDiscount) {
		this.custIsEarlyDiscount = custIsEarlyDiscount;
	}

	public String getStOptionPrice() {
		return stOptionPrice;
	}

	public void setStOptionPrice(String stOptionPrice) {
		this.stOptionPrice = stOptionPrice;
	}

	public String getPantsFlag() {
		return pantsFlag;
	}

	public void setPantsFlag(String pantsFlag) {
		this.pantsFlag = pantsFlag;
	}

	public String getGiletFlag() {
		return giletFlag;
	}

	public void setGiletFlag(String giletFlag) {
		this.giletFlag = giletFlag;
	}

	public String getCoatFlag() {
		return coatFlag;
	}

	public void setCoatFlag(String coatFlag) {
		this.coatFlag = coatFlag;
	}

	public String getShirtFlag() {
		return shirtFlag;
	}

	public void setShirtFlag(String shirtFlag) {
		this.shirtFlag = shirtFlag;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}

	public String getSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}

	public String getStoreNm() {
		return storeNm;
	}

	public void setStoreNm(String storeNm) {
		this.storeNm = storeNm;
	}

	public String getProductFactoryCd() {
		return productFactoryCd;
	}

	public void setProductFactoryCd(String productFactoryCd) {
		this.productFactoryCd = productFactoryCd;
	}

	public String getProductMakerCode() {
		return productMakerCode;
	}

	public void setProductMakerCode(String productMakerCode) {
		this.productMakerCode = productMakerCode;
	}

	public String getTheoryFabricUsedMount() {
		return theoryFabricUsedMount;
	}

	public void setTheoryFabricUsedMount(String theoryFabricUsedMount) {
		this.theoryFabricUsedMount = theoryFabricUsedMount;
	}

	public String getOrderPattern() {
		return orderPattern;
	}

	public void setOrderPattern(String orderPattern) {
		this.orderPattern = orderPattern;
	}

	public List<OrderCodePrice> getOrderCodePriceList() {
		return orderCodePriceList;
	}

	public void setOrderCodePriceList(List<OrderCodePrice> orderCodePriceList) {
		this.orderCodePriceList = orderCodePriceList;
	}

	public String getProductItem() {
		return productItem;
	}

	public void setProductItem(String productItem) {
		this.productItem = productItem;
	}

	public String getProductIs3Piece() {
		return productIs3Piece;
	}

	public void setProductIs3Piece(String productIs3Piece) {
		this.productIs3Piece = productIs3Piece;
	}

	public String getProductSparePantsClass() {
		return productSparePantsClass;
	}

	public void setProductSparePantsClass(String productSparePantsClass) {
		this.productSparePantsClass = productSparePantsClass;
	}

	public String getProductFabricNo() {
		return productFabricNo;
	}

	public void setProductFabricNo(String productFabricNo) {
		this.productFabricNo = productFabricNo;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductBrandType() {
		return productBrandType;
	}

	public void setProductBrandType(String productBrandType) {
		this.productBrandType = productBrandType;
	}

	public String getProductFabricNmNecessity() {
		return productFabricNmNecessity;
	}

	public void setProductFabricNmNecessity(String productFabricNmNecessity) {
		this.productFabricNmNecessity = productFabricNmNecessity;
	}

	public String getProductEmbroideryNecessity() {
		return productEmbroideryNecessity;
	}

	public void setProductEmbroideryNecessity(String productEmbroideryNecessity) {
		this.productEmbroideryNecessity = productEmbroideryNecessity;
	}

	public String getProductEmbroideryNm() {
		return productEmbroideryNm;
	}

	public void setProductEmbroideryNm(String productEmbroideryNm) {
		this.productEmbroideryNm = productEmbroideryNm;
	}

	public String getProductEmbroideryFont() {
		return productEmbroideryFont;
	}

	public void setProductEmbroideryFont(String productEmbroideryFont) {
		this.productEmbroideryFont = productEmbroideryFont;
	}

//	public String getProductEmbroideryThreadColor() {
//		return productEmbroideryThreadColor;
//	}
//
//	public void setProductEmbroideryThreadColor(String productEmbroideryThreadColor) {
//		this.productEmbroideryThreadColor = productEmbroideryThreadColor;
//	}

	public String getProductEmbroideryGazette() {
		return productEmbroideryGazette;
	}

	public void setProductEmbroideryGazette(String productEmbroideryGazette) {
		this.productEmbroideryGazette = productEmbroideryGazette;
	}

	public String getProductEmbroideryNmPos() {
		return productEmbroideryNmPos;
	}

	public void setProductEmbroideryNmPos(String productEmbroideryNmPos) {
		this.productEmbroideryNmPos = productEmbroideryNmPos;
	}

	public String getProductRemainingClothType() {
		return productRemainingClothType;
	}

	public void setProductRemainingClothType(String productRemainingClothType) {
		this.productRemainingClothType = productRemainingClothType;
	}

	public String getProductRemainingClothNm() {
		return productRemainingClothNm;
	}

	public void setProductRemainingClothNm(String productRemainingClothNm) {
		this.productRemainingClothNm = productRemainingClothNm;
	}

	public String getProductFabricBrandNm() {
		return productFabricBrandNm;
	}

	public void setProductFabricBrandNm(String productFabricBrandNm) {
		this.productFabricBrandNm = productFabricBrandNm;
	}

	public String getProductServiceNm() {
		return productServiceNm;
	}

	public void setProductServiceNm(String productServiceNm) {
		this.productServiceNm = productServiceNm;
	}

	public String getProductComposFrtFabric() {
		return productComposFrtFabric;
	}

	public void setProductComposFrtFabric(String productComposFrtFabric) {
		this.productComposFrtFabric = productComposFrtFabric;
	}

	public String getProductComposBodyLiner() {
		return productComposBodyLiner;
	}

	public void setProductComposBodyLiner(String productComposBodyLiner) {
		this.productComposBodyLiner = productComposBodyLiner;
	}

	public String getProductComposSleeveLiner() {
		return productComposSleeveLiner;
	}

	public void setProductComposSleeveLiner(String productComposSleeveLiner) {
		this.productComposSleeveLiner = productComposSleeveLiner;
	}

	public String getProductNotice() {
		return productNotice;
	}

	public void setProductNotice(String productNotice) {
		this.productNotice = productNotice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, String> getProductItemMap() {
		return productItemMap;
	}

	public void setProductItemMap(Map<String, String> productItemMap) {
		this.productItemMap = productItemMap;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getProductBrandNm() {
		return productBrandNm;
	}

	public void setProductBrandNm(String productBrandNm) {
		this.productBrandNm = productBrandNm;
	}

	public String getStoreBrandCode() {
		return storeBrandCode;
	}

	public void setStoreBrandCode(String storeBrandCode) {
		this.storeBrandCode = storeBrandCode;
	}

	public String getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(String billingAmount) {
		this.billingAmount = billingAmount;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(String optionPrice) {
		this.optionPrice = optionPrice;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getConsumptionTaxAmount() {
		return consumptionTaxAmount;
	}

	public void setConsumptionTaxAmount(String consumptionTaxAmount) {
		this.consumptionTaxAmount = consumptionTaxAmount;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getCorStoreCorrectionMemoAgain() {
		return corStoreCorrectionMemoAgain;
	}

	public void setCorStoreCorrectionMemoAgain(String corStoreCorrectionMemoAgain) {
		this.corStoreCorrectionMemoAgain = corStoreCorrectionMemoAgain;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getYield() {
		return yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public String getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getFabricColor() {
		return fabricColor;
	}

	public void setFabricColor(String fabricColor) {
		this.fabricColor = fabricColor;
	}

	public String getFabricPattern() {
		return fabricPattern;
	}

	public void setFabricPattern(String fabricPattern) {
		this.fabricPattern = fabricPattern;
	}

	public String getProductEmbroideryLength() {
		return productEmbroideryLength;
	}

	public void setProductEmbroideryLength(String productEmbroideryLength) {
		this.productEmbroideryLength = productEmbroideryLength;
	}

	public String getProductEmbroideryWidth() {
		return productEmbroideryWidth;
	}

	public void setProductEmbroideryWidth(String productEmbroideryWidth) {
		this.productEmbroideryWidth = productEmbroideryWidth;
	}

	public String getJacketAdFlag() {
		return jacketAdFlag;
	}

	public void setJacketAdFlag(String jacketAdFlag) {
		this.jacketAdFlag = jacketAdFlag;
	}

	public String getPantsAdFlag() {
		return pantsAdFlag;
	}

	public void setPantsAdFlag(String pantsAdFlag) {
		this.pantsAdFlag = pantsAdFlag;
	}

	public String getPants2AdFlag() {
		return pants2AdFlag;
	}

	public void setPants2AdFlag(String pants2AdFlag) {
		this.pants2AdFlag = pants2AdFlag;
	}

	public String getGiletAdFlag() {
		return giletAdFlag;
	}

	public void setGiletAdFlag(String giletAdFlag) {
		this.giletAdFlag = giletAdFlag;
	}

	public String getCoatAdFlag() {
		return coatAdFlag;
	}

	public void setCoatAdFlag(String coatAdFlag) {
		this.coatAdFlag = coatAdFlag;
	}

	public String getShirtAdFlag() {
		return shirtAdFlag;
	}

	public void setShirtAdFlag(String shirtAdFlag) {
		this.shirtAdFlag = shirtAdFlag;
	}

	public String getJacketItemFlag() {
		return jacketItemFlag;
	}

	public void setJacketItemFlag(String jacketItemFlag) {
		this.jacketItemFlag = jacketItemFlag;
	}

	public String getPantsItemFlag() {
		return pantsItemFlag;
	}

	public void setPantsItemFlag(String pantsItemFlag) {
		this.pantsItemFlag = pantsItemFlag;
	}

	public String getGiletItemFlag() {
		return giletItemFlag;
	}

	public void setGiletItemFlag(String giletItemFlag) {
		this.giletItemFlag = giletItemFlag;
	}

	public String getShirtItemFlag() {
		return shirtItemFlag;
	}

	public void setShirtItemFlag(String shirtItemFlag) {
		this.shirtItemFlag = shirtItemFlag;
	}

	public String getCoatItemFlag() {
		return coatItemFlag;
	}

	public void setCoatItemFlag(String coatItemFlag) {
		this.coatItemFlag = coatItemFlag;
	}

	public String getPants2ItemFlag() {
		return pants2ItemFlag;
	}

	public void setPants2ItemFlag(String pants2ItemFlag) {
		this.pants2ItemFlag = pants2ItemFlag;
	}

	public String getProductLcrSewing() {
		return productLcrSewing;
	}

	public void setProductLcrSewing(String productLcrSewing) {
		this.productLcrSewing = productLcrSewing;
	}

	public CoMeasuringInfo getCoMeasuringInfo() {
		return coMeasuringInfo;
	}

	public void setCoMeasuringInfo(CoMeasuringInfo coMeasuringInfo) {
		this.coMeasuringInfo = coMeasuringInfo;
	}

	public CoCustomerMessageInfo getCoCustomerMessageInfo() {
		return coCustomerMessageInfo;
	}

	public void setCoCustomerMessageInfo(CoCustomerMessageInfo coCustomerMessageInfo) {
		this.coCustomerMessageInfo = coCustomerMessageInfo;
	}

	public CoOptionPantsStandardInfo getCoOptionPantsStandardInfo() {
		return coOptionPantsStandardInfo;
	}

	public void setCoOptionPantsStandardInfo(CoOptionPantsStandardInfo coOptionPantsStandardInfo) {
		this.coOptionPantsStandardInfo = coOptionPantsStandardInfo;
	}

	public CoOptionPants2StandardInfo getCoOptionPants2StandardInfo() {
		return coOptionPants2StandardInfo;
	}

	public void setCoOptionPants2StandardInfo(CoOptionPants2StandardInfo coOptionPants2StandardInfo) {
		this.coOptionPants2StandardInfo = coOptionPants2StandardInfo;
	}

	public CoOptionPantsTuxedoInfo getCoOptionPantsTuxedoInfo() {
		return coOptionPantsTuxedoInfo;
	}

	public void setCoOptionPantsTuxedoInfo(CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo) {
		this.coOptionPantsTuxedoInfo = coOptionPantsTuxedoInfo;
	}

	public CoOptionPants2TuxedoInfo getCoOptionPants2TuxedoInfo() {
		return coOptionPants2TuxedoInfo;
	}

	public void setCoOptionPants2TuxedoInfo(CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo) {
		this.coOptionPants2TuxedoInfo = coOptionPants2TuxedoInfo;
	}

	public CoOptionPantsWashableInfo getCoOptionPantsWashableInfo() {
		return coOptionPantsWashableInfo;
	}

	public void setCoOptionPantsWashableInfo(CoOptionPantsWashableInfo coOptionPantsWashableInfo) {
		this.coOptionPantsWashableInfo = coOptionPantsWashableInfo;
	}

	public CoOptionPants2WashableInfo getCoOptionPants2WashableInfo() {
		return coOptionPants2WashableInfo;
	}

	public void setCoOptionPants2WashableInfo(CoOptionPants2WashableInfo coOptionPants2WashableInfo) {
		this.coOptionPants2WashableInfo = coOptionPants2WashableInfo;
	}

	public CoOptionJacketStandardInfo getCoOptionJacketStandardInfo() {
		return coOptionJacketStandardInfo;
	}

	public void setCoOptionJacketStandardInfo(CoOptionJacketStandardInfo coOptionJacketStandardInfo) {
		this.coOptionJacketStandardInfo = coOptionJacketStandardInfo;
	}

	public CoOptionJacketTuxedoInfo getCoOptionJacketTuxedoInfo() {
		return coOptionJacketTuxedoInfo;
	}

	public void setCoOptionJacketTuxedoInfo(CoOptionJacketTuxedoInfo coOptionJacketTuxedoInfo) {
		this.coOptionJacketTuxedoInfo = coOptionJacketTuxedoInfo;
	}

	public CoOptionJacketWashableInfo getCoOptionJacketWashableInfo() {
		return coOptionJacketWashableInfo;
	}

	public void setCoOptionJacketWashableInfo(CoOptionJacketWashableInfo coOptionJacketWashableInfo) {
		this.coOptionJacketWashableInfo = coOptionJacketWashableInfo;
	}

	public CoOptionGiletStandardInfo getCoOptionGiletStandardInfo() {
		return coOptionGiletStandardInfo;
	}

	public void setCoOptionGiletStandardInfo(CoOptionGiletStandardInfo coOptionGiletStandardInfo) {
		this.coOptionGiletStandardInfo = coOptionGiletStandardInfo;
	}

	public CoOptionGiletTuxedoInfo getCoOptionGiletTuxedoInfo() {
		return coOptionGiletTuxedoInfo;
	}

	public void setCoOptionGiletTuxedoInfo(CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo) {
		this.coOptionGiletTuxedoInfo = coOptionGiletTuxedoInfo;
	}

	public CoOptionGiletWashableInfo getCoOptionGiletWashableInfo() {
		return coOptionGiletWashableInfo;
	}

	public void setCoOptionGiletWashableInfo(CoOptionGiletWashableInfo coOptionGiletWashableInfo) {
		this.coOptionGiletWashableInfo = coOptionGiletWashableInfo;
	}

	public CoOptionShirtStandardInfo getCoOptionShirtStandardInfo() {
		return coOptionShirtStandardInfo;
	}

	public void setCoOptionShirtStandardInfo(CoOptionShirtStandardInfo coOptionShirtStandardInfo) {
		this.coOptionShirtStandardInfo = coOptionShirtStandardInfo;
	}

	public CoOptionCoatStandardInfo getCoOptionCoatStandardInfo() {
		return coOptionCoatStandardInfo;
	}

	public void setCoOptionCoatStandardInfo(CoOptionCoatStandardInfo coOptionCoatStandardInfo) {
		this.coOptionCoatStandardInfo = coOptionCoatStandardInfo;
	}

	public CoAdjustJacketStandardInfo getCoAdjustJacketStandardInfo() {
		return coAdjustJacketStandardInfo;
	}

	public void setCoAdjustJacketStandardInfo(CoAdjustJacketStandardInfo coAdjustJacketStandardInfo) {
		this.coAdjustJacketStandardInfo = coAdjustJacketStandardInfo;
	}

	public CoAdjustPantsStandardInfo getCoAdjustPantsStandardInfo() {
		return coAdjustPantsStandardInfo;
	}

	public void setCoAdjustPantsStandardInfo(CoAdjustPantsStandardInfo coAdjustPantsStandardInfo) {
		this.coAdjustPantsStandardInfo = coAdjustPantsStandardInfo;
	}

	public CoAdjustPants2StandardInfo getCoAdjustPants2StandardInfo() {
		return coAdjustPants2StandardInfo;
	}

	public void setCoAdjustPants2StandardInfo(CoAdjustPants2StandardInfo coAdjustPants2StandardInfo) {
		this.coAdjustPants2StandardInfo = coAdjustPants2StandardInfo;
	}

	public CoAdjustGiletStandardInfo getCoAdjustGiletStandardInfo() {
		return coAdjustGiletStandardInfo;
	}

	public void setCoAdjustGiletStandardInfo(CoAdjustGiletStandardInfo coAdjustGiletStandardInfo) {
		this.coAdjustGiletStandardInfo = coAdjustGiletStandardInfo;
	}

	public CoAdjustShirtStandardInfo getCoAdjustShirtStandardInfo() {
		return coAdjustShirtStandardInfo;
	}

	public void setCoAdjustShirtStandardInfo(CoAdjustShirtStandardInfo coAdjustShirtStandardInfo) {
		this.coAdjustShirtStandardInfo = coAdjustShirtStandardInfo;
	}

	public CoAdjustCoatStandardInfo getCoAdjustCoatStandardInfo() {
		return coAdjustCoatStandardInfo;
	}

	public void setCoAdjustCoatStandardInfo(CoAdjustCoatStandardInfo coAdjustCoatStandardInfo) {
		this.coAdjustCoatStandardInfo = coAdjustCoatStandardInfo;
	}

	public String getJkDoubleModelPrice() {
		return jkDoubleModelPrice;
	}

	public void setJkDoubleModelPrice(String jkDoubleModelPrice) {
		this.jkDoubleModelPrice = jkDoubleModelPrice;
	}

	public OrderFindFabric getOrderFindFabric() {
		return orderFindFabric;
	}

	public void setOrderFindFabric(OrderFindFabric orderFindFabric) {
		this.orderFindFabric = orderFindFabric;
	}

	public String getOrderFindFabricStr() {
		return orderFindFabricStr;
	}

	public void setOrderFindFabricStr(String orderFindFabricStr) {
		this.orderFindFabricStr = orderFindFabricStr;
	}

	public String getFabricFlag() {
		return fabricFlag;
	}

	public void setFabricFlag(String fabricFlag) {
		this.fabricFlag = fabricFlag;
	}

	public String getJkOptionPrice() {
		return jkOptionPrice;
	}

	public void setJkOptionPrice(String jkOptionPrice) {
		this.jkOptionPrice = jkOptionPrice;
	}

	public String getPtOptionPrice() {
		return ptOptionPrice;
	}

	public void setPtOptionPrice(String ptOptionPrice) {
		this.ptOptionPrice = ptOptionPrice;
	}

	public String getPt2OptionPrice() {
		return pt2OptionPrice;
	}

	public void setPt2OptionPrice(String pt2OptionPrice) {
		this.pt2OptionPrice = pt2OptionPrice;
	}

	public String getGlOptionPrice() {
		return glOptionPrice;
	}

	public void setGlOptionPrice(String glOptionPrice) {
		this.glOptionPrice = glOptionPrice;
	}

	public String getCtOptionPrice() {
		return ctOptionPrice;
	}

	public void setCtOptionPrice(String ctOptionPrice) {
		this.ctOptionPrice = ctOptionPrice;
	}

	public String getCtDoubleModelPrice() {
		return ctDoubleModelPrice;
	}

	public void setCtDoubleModelPrice(String ctDoubleModelPrice) {
		this.ctDoubleModelPrice = ctDoubleModelPrice;
	}

	public String getGlDoubleModelPrice() {
		return glDoubleModelPrice;
	}

	public void setGlDoubleModelPrice(String glDoubleModelPrice) {
		this.glDoubleModelPrice = glDoubleModelPrice;
	}

	public CoProductInfo getCoProductInfo() {
		return coProductInfo;
	}

	public void setCoProductInfo(CoProductInfo coProductInfo) {
		this.coProductInfo = coProductInfo;
	}

	public String getJkProductEmbroideryThreadColor() {
		return jkProductEmbroideryThreadColor;
	}

	public void setJkProductEmbroideryThreadColor(String jkProductEmbroideryThreadColor) {
		this.jkProductEmbroideryThreadColor = jkProductEmbroideryThreadColor;
	}

	public String getStProductEmbroideryThreadColor() {
		return stProductEmbroideryThreadColor;
	}

	public void setStProductEmbroideryThreadColor(String stProductEmbroideryThreadColor) {
		this.stProductEmbroideryThreadColor = stProductEmbroideryThreadColor;
	}

	public String getExpediteDeliveryPrice() {
		return expediteDeliveryPrice;
	}

	public void setExpediteDeliveryPrice(String expediteDeliveryPrice) {
		this.expediteDeliveryPrice = expediteDeliveryPrice;
	}

	public String getLcrSewingPrice() {
		return lcrSewingPrice;
	}

	public void setLcrSewingPrice(String lcrSewingPrice) {
		this.lcrSewingPrice = lcrSewingPrice;
	}

	public String getPants2Flag() {
		return pants2Flag;
	}

	public void setPants2Flag(String pants2Flag) {
		this.pants2Flag = pants2Flag;
	}

	public String getIs3PiecePrice() {
		return is3PiecePrice;
	}

	public void setIs3PiecePrice(String is3PiecePrice) {
		this.is3PiecePrice = is3PiecePrice;
	}

	public String getIs2PantsPrice() {
		return is2PantsPrice;
	}

	public void setIs2PantsPrice(String is2PantsPrice) {
		this.is2PantsPrice = is2PantsPrice;
	}

	public String getOjBtnMatePtFlag() {
		return ojBtnMatePtFlag;
	}

	public void setOjBtnMatePtFlag(String ojBtnMatePtFlag) {
		this.ojBtnMatePtFlag = ojBtnMatePtFlag;
	}

	public String getJacketBtnMateGlFlag() {
		return jacketBtnMateGlFlag;
	}

	public void setJacketBtnMateGlFlag(String jacketBtnMateGlFlag) {
		this.jacketBtnMateGlFlag = jacketBtnMateGlFlag;
	}

	public String getOjBtnMatePt2Flag() {
		return ojBtnMatePt2Flag;
	}

	public void setOjBtnMatePt2Flag(String ojBtnMatePt2Flag) {
		this.ojBtnMatePt2Flag = ojBtnMatePt2Flag;
	}

	public String getCorStoreCorrectionMemo() {
		return corStoreCorrectionMemo;
	}

	public void setCorStoreCorrectionMemo(String corStoreCorrectionMemo) {
		this.corStoreCorrectionMemo = corStoreCorrectionMemo;
	}

	public List<Yield> getYieldList() {
		return yieldList;
	}

	public void setYieldList(List<Yield> yieldList) {
		this.yieldList = yieldList;
	}

	public String getOsCasHemLineIdFlag() {
		return osCasHemLineIdFlag;
	}

	public void setOsCasHemLineIdFlag(String osCasHemLineIdFlag) {
		this.osCasHemLineIdFlag = osCasHemLineIdFlag;
	}

	public String getItemCoFlag() {
		return itemCoFlag;
	}

	public void setItemCoFlag(String itemCoFlag) {
		this.itemCoFlag = itemCoFlag;
	}

	public String getItemCoChangeFlag() {
		return itemCoChangeFlag;
	}

	public void setItemCoChangeFlag(String itemCoChangeFlag) {
		this.itemCoChangeFlag = itemCoChangeFlag;
	}

	public String getOrderTscStatus() {
		return orderTscStatus;
	}

	public void setOrderTscStatus(String orderTscStatus) {
		this.orderTscStatus = orderTscStatus;
	}
}
