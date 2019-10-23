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

import co.jp.aoyama.macchinetta.app.order.info.AdjustGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.CustomerMessageInfo;
import co.jp.aoyama.macchinetta.app.order.info.MeasuringInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfo;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderForm implements Serializable {

	private static final long serialVersionUID = -1277900263857619780L;

	// グループ:Jacket
    public static interface JkItem {
    };

    // グループ:Pants
    public static interface PtItem {
    };

    // グループ:Gilet
    public static interface GiletItem {
    };
    
    // グループ:2Pants
    public static interface Pt2Item {
    };
    
    // グループ:店舗コード 業態  店舗名
    public static interface ShopItem {
    };
    
    // グループ:EmbroideredItem（刺繍入れ）
    public static interface EmbroideredItem {
    };
    
    // グループ:opHemUp（裾上げ）
    public static interface OpHemUpItem {
    };
    
    // グループ:op2HemUp（裾上げ）
    public static interface Op2HemUpItem {
    };
    
    // グループ:shippingDestination（出荷先）
    public static interface ShippingDestinationItem {
    };
    
	// メジャーリング
	private MeasuringInfo measuringInfo;

	// お客様情報
    @Valid
	private CustomerMessageInfo customerMessageInfo;

	// PANTS Standard
    @Valid
	private OptionPantsStandardInfo optionPantsStandardInfo;

	// 2PANTS Standard
    @Valid
	private OptionPants2StandardInfo optionPants2StandardInfo;

	// JACKET Standard
    @Valid
	private OptionJacketStandardInfo optionJacketStandardInfo;

	// GILET Standard
    @Valid
	private OptionGiletStandardInfo optionGiletStandardInfo;

	// JACKET補正
    @Valid
	private AdjustJacketStandardInfo adjustJacketStandardInfo;

	// PANTS補正
    @Valid
	private AdjustPantsStandardInfo adjustPantsStandardInfo;

	// PANTS2補正
    @Valid
	private AdjustPants2StandardInfo adjustPants2StandardInfo;

	// GILET補正
    @Valid
	private AdjustGiletStandardInfo adjustGiletStandardInfo;
	
	// オプション価格
	private List<OrderCodePrice> orderCodePriceList;
	
	//店舗コード TSC/UMLと青山で異なる店舗ｺｰﾄを登録
	@NotBlank(groups = {ShopItem.class},message = "店舗コード が不正です。")
	private String shopCode;
	
	//業態
	@NotBlank(groups = {ShopItem.class},message = "業態コード が不正です。")
	private String storeBrandCode;
	
	//店舗・担当_店舗名
	@NotBlank(groups = {ShopItem.class},message = "店舗名が不正です。")
	private String storeNm;

	//商品情報_ITEM
	@NotBlank(groups = {Default.class},message = "アイテムを入力して下さい。")
	private String productItem;
	
	private Map<String,String> productItemMap;

	//商品情報_３Piece
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
	@NotBlank(groups = {Default.class},message = "ブランドネームを入力して下さい。")
	private String productBrandType;

	// 商品情報_ブランドネーム
	private String productBrandNm;

	// 商品情報_生地ネーム
	@NotBlank(groups = {Default.class},message = "生地ネームを入力して下さい。")
	private String productFabricNmNecessity;

	// 商品情報_刺繍入れ
	@NotBlank(groups = {Default.class},message = "刺繍入れを入力して下さい。")
	private String productEmbroideryNecessity;

	// 商品情報_刺繍ネーム
	@NotBlank(groups = {EmbroideredItem.class},message = "刺繍ネームを入力して下さい。")
	private String productEmbroideryNm;

	// 商品情報_刺繍書体
	@NotBlank(groups = {EmbroideredItem.class},message = "刺繍書体を入力して下さい。")
	private String productEmbroideryFont;

	// 商品情報_刺繍糸色
	@NotBlank(groups = {EmbroideredItem.class},message = "刺繍糸色を入力して下さい。")
	private String productEmbroideryThreadColor;

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
	@NotBlank(groups = {JkItem.class,GiletItem.class},message = "組成表示　胴裏地が不正です。")
	private String productComposBodyLiner;

	// 商品情報_組成表示_袖裏地
	@NotBlank(groups = {JkItem.class},message = "組成表示　袖裏地が不正です。")
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
	
	//オーダーパターン
	@NotBlank(groups = {Default.class},message = "オーダーパターンが不正です。")
	private String orderPattern;
	
	//理論生地使用量
	@NotBlank(groups = {Default.class},message = "理論生地使用量が不正です。")
	private String theoryFabricUsedMount;
	
	// 権限
	private String authority;
	
	//店舗再補正入力欄
	private String corStoreCorrectionMemoAgain;
	
	// 消費税
	private String taxRate;
	
	// 要尺
	private String yield;
	
	//更新確認
	private String isUpdate;
	
	//生地_色
	@NotBlank(groups = {Default.class},message = "生地品番　色が不正です。")
	private String fabricColor;
	
	//生地_柄
	@NotBlank(groups = {Default.class},message = "生地品番　柄が不正です。")
	private String fabricPattern;
	
	//商品情報_工場
	@NotBlank(groups = {Default.class},message = "工場コードが不正です。")
	private String productFactoryCd;
		
	//商品情報_メーカーコード
	@NotBlank(groups = {Default.class},message = "メーカーコードが不正です。")
	private String productMakerCode;
	
	//保存flag
	private String saveFlag;
	
	private String orderFlag;
	
	private String version;
	
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

	public MeasuringInfo getMeasuringInfo() {
		return measuringInfo;
	}

	public void setMeasuringInfo(MeasuringInfo measuringInfo) {
		this.measuringInfo = measuringInfo;
	}

	public CustomerMessageInfo getCustomerMessageInfo() {
		return customerMessageInfo;
	}

	public void setCustomerMessageInfo(CustomerMessageInfo customerMessageInfo) {
		this.customerMessageInfo = customerMessageInfo;
	}

	public OptionPantsStandardInfo getOptionPantsStandardInfo() {
		return optionPantsStandardInfo;
	}

	public void setOptionPantsStandardInfo(OptionPantsStandardInfo optionPantsStandardInfo) {
		this.optionPantsStandardInfo = optionPantsStandardInfo;
	}

	public OptionPants2StandardInfo getOptionPants2StandardInfo() {
		return optionPants2StandardInfo;
	}

	public void setOptionPants2StandardInfo(OptionPants2StandardInfo optionPants2StandardInfo) {
		this.optionPants2StandardInfo = optionPants2StandardInfo;
	}

	public OptionJacketStandardInfo getOptionJacketStandardInfo() {
		return optionJacketStandardInfo;
	}

	public void setOptionJacketStandardInfo(OptionJacketStandardInfo optionJacketStandardInfo) {
		this.optionJacketStandardInfo = optionJacketStandardInfo;
	}

	public OptionGiletStandardInfo getOptionGiletStandardInfo() {
		return optionGiletStandardInfo;
	}

	public void setOptionGiletStandardInfo(OptionGiletStandardInfo optionGiletStandardInfo) {
		this.optionGiletStandardInfo = optionGiletStandardInfo;
	}

	public List<OrderCodePrice> getOrderCodePriceList() {
		return orderCodePriceList;
	}

	public void setOrderCodePriceList(List<OrderCodePrice> orderCodePriceList) {
		this.orderCodePriceList = orderCodePriceList;
	}

	public AdjustJacketStandardInfo getAdjustJacketStandardInfo() {
		return adjustJacketStandardInfo;
	}

	public void setAdjustJacketStandardInfo(AdjustJacketStandardInfo adjustJacketStandardInfo) {
		this.adjustJacketStandardInfo = adjustJacketStandardInfo;
	}

	public AdjustPantsStandardInfo getAdjustPantsStandardInfo() {
		return adjustPantsStandardInfo;
	}

	public void setAdjustPantsStandardInfo(AdjustPantsStandardInfo adjustPantsStandardInfo) {
		this.adjustPantsStandardInfo = adjustPantsStandardInfo;
	}

	public AdjustGiletStandardInfo getAdjustGiletStandardInfo() {
		return adjustGiletStandardInfo;
	}

	public void setAdjustGiletStandardInfo(AdjustGiletStandardInfo adjustGiletStandardInfo) {
		this.adjustGiletStandardInfo = adjustGiletStandardInfo;
	}

	public AdjustPants2StandardInfo getAdjustPants2StandardInfo() {
		return adjustPants2StandardInfo;
	}

	public void setAdjustPants2StandardInfo(AdjustPants2StandardInfo adjustPants2StandardInfo) {
		this.adjustPants2StandardInfo = adjustPants2StandardInfo;
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

	public String getProductEmbroideryThreadColor() {
		return productEmbroideryThreadColor;
	}

	public void setProductEmbroideryThreadColor(String productEmbroideryThreadColor) {
		this.productEmbroideryThreadColor = productEmbroideryThreadColor;
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
}
