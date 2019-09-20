package co.jp.aoyama.macchinetta.app.order;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

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

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderCoForm implements Serializable {

	private static final long serialVersionUID = -5104739132232852696L;

	// メジャーリング
	private CoMeasuringInfo coMeasuringInfo;

	// お客様情報
	private CoCustomerMessageInfo coCustomerMessageInfo;

	// PANTS Standard
	private CoOptionPantsStandardInfo coOptionPantsStandardInfo;

	// 2PANTS Standard
	private CoOptionPants2StandardInfo coOptionPants2StandardInfo;

	// PANTS Tuxedo
	private CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo;

	// 2PANTS Tuxedo
	private CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo;

	// PANTS Washable
	private CoOptionPantsWashableInfo coOptionPantsWashableInfo;

	// 2PANTS Washable
	private CoOptionPants2WashableInfo coOptionPants2WashableInfo;

	// JACKET Standard
	private CoOptionJacketStandardInfo coOptionJacketStandardInfo;

	// JACKET Tuxedo
	private CoOptionJacketTuxedoInfo coOptionJacketTuxedoInfo;

	// JACKET Washable
	private CoOptionJacketWashableInfo coOptionJacketWashableInfo;

	// GILET Standard
	private CoOptionGiletStandardInfo coOptionGiletStandardInfo;

	// GILET Tuxedo
	private CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo;

	// GILET Washable
	private CoOptionGiletWashableInfo coOptionGiletWashableInfo;

	// SHIRT Standard
	private CoOptionShirtStandardInfo coOptionShirtStandardInfo;

	// COAT Standard
	private CoOptionCoatStandardInfo coOptionCoatStandardInfo;

	// Product
	private CoProductInfo coProductInfo;
 
	// オプション価格
	private List<OrderCodePrice> orderCodePriceList;

	// JACKET補正
	private CoAdjustJacketStandardInfo coAdjustJacketStandardInfo;

	// PANTS補正
	private CoAdjustPantsStandardInfo coAdjustPantsStandardInfo;

	// PANTS2補正
	private CoAdjustPants2StandardInfo coAdjustPants2StandardInfo;

	// GILET補正
	private CoAdjustGiletStandardInfo coAdjustGiletStandardInfo;

	// Shirt補正
	private CoAdjustShirtStandardInfo coAdjustShirtStandardInfo;

	// Coat補正
	private CoAdjustCoatStandardInfo coAdjustCoatStandardInfo;

	// 店舗コード TSC/UMLと青山で異なる店舗ｺｰﾄを登録
	private String shopCode;

	// 業態
	private String storeBrandCode;

	// 商品情報_ITEM
	private String productItem;

	private Map<String, String> productItemMap;

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
	private String jkProductEmbroideryThreadColor;
	
	// 商品情報_刺繍糸色
	private String stProductEmbroideryThreadColor;

	// 商品情報_ガゼット刺繍
	private String productEmbroideryGazette;

	// 商品情報_ネーム刺繍位置
	private String productEmbroideryNmPos;

	// 商品情報_刺繍サイズ（縦）
	private String productEmbroideryLength;

	// 商品情報_刺繍サイズ（横）
	private String productEmbroideryWidth;

	// 商品情報_残布_type
	private String productRemainingClothType;

	// 商品情報_残布_名
	private String productRemainingClothNm;

	// 商品情報_生地ブランド
	private String productFabricBrandNm;

	// 商品情報_サービスネーム
	private String productServiceNm;
	
	private String expediteDeliveryPrice;
	
	private String lcrSewingPrice;

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

	// オーダーパターン
	private String orderPattern;

	// 理論生地使用量
	private String theoryFabricUsedMount;

	// 権限
	private String authority;

	// 店舗再補正入力欄
	private String corStoreCorrectionMemoAgain;

	// 消費税
	private String taxRate;

	// 要尺
	private String yield;

	// 更新確認
	private String isUpdate;

	// 生地_色
	private String fabricColor;

	// 生地_柄
	private String fabricPattern;

	// 商品情報_工場
	private String productFactoryCd;

	// 商品情報_メーカーコード
	private String productMakerCode;

	// 商品情報_LCR縫製
	private String productLcrSewing;

	// 納期短縮
	private String custIsDeliverShortning;

	// 早割
	private String custIsEarlyDiscount;

	// 保存flag
	private String saveFlag;

	private String orderFlag;

	private String version;

	// 店舗・担当_店舗名
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

	private String fabricFlag;

	// 補正
	private String jacketAdFlag;

	private String pantsAdFlag;

	private String pants2AdFlag;

	private String giletAdFlag;

	private String coatAdFlag;

	private String shirtAdFlag;

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
}
