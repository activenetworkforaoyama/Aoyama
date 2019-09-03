package co.jp.aoyama.macchinetta.app.order;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import co.jp.aoyama.macchinetta.app.order.info.AdjustCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustShirtStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.CustomerMessageInfo;
import co.jp.aoyama.macchinetta.app.order.info.MeasuringInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletWashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketWashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPants2TuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPants2WashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsWashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionShirtStandardInfo;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderForm implements Serializable {

	private static final long serialVersionUID = -1277900263857619780L;

	// メジャーリング
	private MeasuringInfo measuringInfo;

	// お客様情報
	private CustomerMessageInfo customerMessageInfo;

	// PANTS Standard
	private OptionPantsStandardInfo optionPantsStandardInfo;

	// 2PANTS Standard
	private OptionPants2StandardInfo optionPants2StandardInfo;

	// PANTS Tuxedo
	private OptionPantsTuxedoInfo optionPantsTuxedoInfo;
	
	// 2PANTS Tuxedo
	private OptionPants2TuxedoInfo optionPants2TuxedoInfo;

	// PANTS Washable
	private OptionPantsWashableInfo optionPantsWashableInfo;
	
	// 2PANTS Washable
	private OptionPants2WashableInfo optionPants2WashableInfo;

	// JACKET Standard
	private OptionJacketStandardInfo optionJacketStandardInfo;

	// JACKET Tuxedo
	private OptionJacketTuxedoInfo optionJacketTuxedoInfo;

	// JACKET Washable
	private OptionJacketWashableInfo optionJacketWashableInfo;

	// GILET Standard
	private OptionGiletStandardInfo optionGiletStandardInfo;

	// GILET Tuxedo
	private OptionGiletTuxedoInfo optionGiletTuxedoInfo;

	// GILET Washable
	private OptionGiletWashableInfo optionGiletWashableInfo;

	// SHIRT Standard
	private OptionShirtStandardInfo optionShirtStandardInfo;

	// COAT Standard
	private OptionCoatStandardInfo optionCoatStandardInfo;

	// オプション価格
	private List<OrderCodePrice> orderCodePriceList;

	// JACKET補正
	private AdjustJacketStandardInfo adjustJacketStandardInfo;

	// PANTS補正
	private AdjustPantsStandardInfo adjustPantsStandardInfo;

	// PANTS2補正
	private AdjustPants2StandardInfo adjustPants2StandardInfo;

	// GILET補正
	private AdjustGiletStandardInfo adjustGiletStandardInfo;
	
	//Shirt補正
	private AdjustShirtStandardInfo adjustShirtStandardInfo;
	
	//Coat補正
	private AdjustCoatStandardInfo adjustCoatStandardInfo;
	
	//店舗コード TSC/UMLと青山で異なる店舗ｺｰﾄを登録
	private String shopCode;
	
	//業態
	private String storeBrandCode;

	// 商品情報_ITEM
	private String productItem;
	
	private Map<String,String> productItemMap;

	// 商品情報_３Piece
	private String productIs3Piece;

	// 商品情報_スペアパンツ
	private String productSparePantsClass;

	// 商品情報_生地番号
	private String productFabricNo;

	// 商品情報_カテゴリ
	private String productCategory;

	// 商品情報_ブランド区分
	private String productBrandType;

	// 商品情報_ブランドネーム
	private String productBrandNm;

	// 商品情報_生地ネーム
	private String productFabricNmNecessity;

	// 商品情報_刺繍入れ
	private String productEmbroideryNecessity;

	// 商品情報_刺繍ネーム
	private String productEmbroideryNm;

	// 商品情報_刺繍書体
	private String productEmbroideryFont;

	// 商品情報_刺繍糸色
	private String productEmbroideryThreadColor;

	// 商品情報_ガゼット刺繍
	private String productEmbroideryGazette;

	// 商品情報_ネーム刺繍位置
	private String productEmbroideryNmPos;
	
	//商品情報_刺繍サイズ（縦）
	private String productEmbroideryLength;
	
	//商品情報_刺繍サイズ（横）
	private String productEmbroideryWidth;

	// 商品情報_残布_type
	private String productRemainingClothType;

	// 商品情報_残布_名
	private String productRemainingClothNm;

	// 商品情報_生地ブランド
	private String productFabricBrandNm;

	// 商品情報_サービスネーム
	private String productServiceNm;

	// 商品情報_組成表示_表地
	private String productComposFrtFabric;

	// 商品情報_組成表示_胴裏地
	private String productComposBodyLiner;

	// 商品情報_組成表示_袖裏地
	private String productComposSleeveLiner;

	// 商品情報_取扱注意
	private String productNotice;

	// ステータス
	private String status;
	
	// ご請求金額
	private String billingAmount;
	
	// 商品金額
	private String productPrice;
	
	// オプション金額
	private String optionPrice;
	
	// 合計金額
	private String totalPrice;
	
	// 内消費税
	private String consumptionTaxAmount;
	
	//オーダーパターン
	private String orderPattern;
	
	//理論生地使用量
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
	private String fabricColor;
	
	//生地_柄
	private String fabricPattern;
	
	//商品情報_工場
	private String productFactoryCd;
		
	//商品情報_メーカーコード
	private String productMakerCode;
	
	//商品情報_LCR縫製
	private String productLcrSewing;
	
	//保存flag
	private String saveFlag;
	
	private String orderFlag;
	
	private String version;
	
	//店舗・担当_店舗名
	private String storeNm;
	
	private String jacketItemFlag;
	
	private String pantsItemFlag;
	
	private String giletItemFlag;
	
	private String shirtItemFlag;
	
	private String coatItemFlag;
	
	private String pants2ItemFlag;
	
	private String jacketFlag;
	
	private String pantsFlag;
	
	private String giletFlag;
	
	private String coatFlag;
	
	private String shirtFlag;
	
	//補正
	private String jacketAdFlag;
	
	private String pantsAdFlag;
	
	private String pants2AdFlag;
	
	private String giletAdFlag;
	
	private String coatAdFlag;
	
	private String shirtAdFlag;
	
	public String getJacketFlag() {
		return jacketFlag;
	}

	public void setJacketFlag(String jacketFlag) {
		this.jacketFlag = jacketFlag;
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

	public OptionPantsTuxedoInfo getOptionPantsTuxedoInfo() {
		return optionPantsTuxedoInfo;
	}

	public void setOptionPantsTuxedoInfo(OptionPantsTuxedoInfo optionPantsTuxedoInfo) {
		this.optionPantsTuxedoInfo = optionPantsTuxedoInfo;
	}
	
	public OptionPants2TuxedoInfo getOptionPants2TuxedoInfo() {
		return optionPants2TuxedoInfo;
	}

	public void setOptionPants2TuxedoInfo(OptionPants2TuxedoInfo optionPants2TuxedoInfo) {
		this.optionPants2TuxedoInfo = optionPants2TuxedoInfo;
	}

	public OptionPantsWashableInfo getOptionPantsWashableInfo() {
		return optionPantsWashableInfo;
	}

	public OptionPants2WashableInfo getOptionPants2WashableInfo() {
		return optionPants2WashableInfo;
	}

	public void setOptionPants2WashableInfo(OptionPants2WashableInfo optionPants2WashableInfo) {
		this.optionPants2WashableInfo = optionPants2WashableInfo;
	}

	public void setOptionPantsWashableInfo(OptionPantsWashableInfo optionPantsWashableInfo) {
		this.optionPantsWashableInfo = optionPantsWashableInfo;
	}

	public OptionJacketStandardInfo getOptionJacketStandardInfo() {
		return optionJacketStandardInfo;
	}

	public void setOptionJacketStandardInfo(OptionJacketStandardInfo optionJacketStandardInfo) {
		this.optionJacketStandardInfo = optionJacketStandardInfo;
	}

	public OptionJacketTuxedoInfo getOptionJacketTuxedoInfo() {
		return optionJacketTuxedoInfo;
	}

	public void setOptionJacketTuxedoInfo(OptionJacketTuxedoInfo optionJacketTuxedoInfo) {
		this.optionJacketTuxedoInfo = optionJacketTuxedoInfo;
	}

	public OptionJacketWashableInfo getOptionJacketWashableInfo() {
		return optionJacketWashableInfo;
	}

	public void setOptionJacketWashableInfo(OptionJacketWashableInfo optionJacketWashableInfo) {
		this.optionJacketWashableInfo = optionJacketWashableInfo;
	}

	public OptionGiletStandardInfo getOptionGiletStandardInfo() {
		return optionGiletStandardInfo;
	}

	public void setOptionGiletStandardInfo(OptionGiletStandardInfo optionGiletStandardInfo) {
		this.optionGiletStandardInfo = optionGiletStandardInfo;
	}

	public OptionGiletTuxedoInfo getOptionGiletTuxedoInfo() {
		return optionGiletTuxedoInfo;
	}

	public void setOptionGiletTuxedoInfo(OptionGiletTuxedoInfo optionGiletTuxedoInfo) {
		this.optionGiletTuxedoInfo = optionGiletTuxedoInfo;
	}

	public OptionGiletWashableInfo getOptionGiletWashableInfo() {
		return optionGiletWashableInfo;
	}

	public void setOptionGiletWashableInfo(OptionGiletWashableInfo optionGiletWashableInfo) {
		this.optionGiletWashableInfo = optionGiletWashableInfo;
	}

	public OptionShirtStandardInfo getOptionShirtStandardInfo() {
		return optionShirtStandardInfo;
	}

	public void setOptionShirtStandardInfo(OptionShirtStandardInfo optionShirtStandardInfo) {
		this.optionShirtStandardInfo = optionShirtStandardInfo;
	}

	public OptionCoatStandardInfo getOptionCoatStandardInfo() {
		return optionCoatStandardInfo;
	}

	public void setOptionCoatStandardInfo(OptionCoatStandardInfo optionCoatStandardInfo) {
		this.optionCoatStandardInfo = optionCoatStandardInfo;
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

	public AdjustShirtStandardInfo getAdjustShirtStandardInfo() {
		return adjustShirtStandardInfo;
	}

	public void setAdjustShirtStandardInfo(AdjustShirtStandardInfo adjustShirtStandardInfo) {
		this.adjustShirtStandardInfo = adjustShirtStandardInfo;
	}

	public AdjustCoatStandardInfo getAdjustCoatStandardInfo() {
		return adjustCoatStandardInfo;
	}

	public void setAdjustCoatStandardInfo(AdjustCoatStandardInfo adjustCoatStandardInfo) {
		this.adjustCoatStandardInfo = adjustCoatStandardInfo;
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
	
	
}
