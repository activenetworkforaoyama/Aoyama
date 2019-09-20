package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class OrderFindFabric implements Serializable {

	private static final long serialVersionUID = 2138047466949116046L;

	// 生地ネーム有無
	private String fabricNameExis;

	// 手帳(貿易)期限
	private Date spinningLimitDate;

	// 上代
	private Integer retailPrice;

	// PANTS追加増額率
	private Integer additionalPantsRate;

	// シングルGILET追加増額率
	private Integer additionalSingleGiletRate;

	// ダブルGILET追加増額率
	private Integer additionalDoubleGiletRate;

	// ダブルJACKET増額率
	private Integer additionalDoubleJacketRate;

	// シングルJACKET単品率
	private Integer singleJacketOnlyRate;

	// ダブルJACKET単品率
	private Integer doubleJacketOnlyRate;

	// PANTS単品率
	private Integer pantOnlyRate;

	// シングルGILET単品率
	private Integer singleGiletOnlyRate;

	// ダブルGILET単品率
	private Integer doubleGiletOnlyRate;

	// シングルコート単品率
	private Integer coatSingleOnlyRate;

	// ダブルコート単品率
	private Integer coatDoubleOnlyRate;

	// シングルJacketの単品購買追加金額
	private Integer jkSingleOnlyPlusAlphaPrice;

	// ダブルJacketの単品購買追加金額
	private Integer jkDoubleOnlyPlusAlphaPrice;

	// シングルGiletの単品購買追加金額
	private Integer glSingleOnlyPlusAlphaPrice;

	// ダブルGiletの単品購買追加金額
	private Integer glDoubleOnlyPlusAlphaPrice;

	// Pantsの単品購買追加金額
	private Integer ptOnlyPlusAlphaPrice;

	// シングルCoatの単品購買追加金額
	private Integer ctSingleOnlyPlusAlphaPrice;

	// ダブルCoatの単品購買追加金額
	private Integer ctDoubleOnlyPlusAlphaPrice;

	// 素材ネーム
	private String materialName;

	// 組成表示
	private String compositionLabel;

	// 理論在庫
	private String theoreticalStock;

	// 生地ブランド名
	private String brandName;

	// 色
	private String color;

	// 柄
	private String pattern;

	// 取扱注意
	private String handlingCaution;

	// アイテム区分
	private String itemClass;

	// 店着納期区分（通常）
	private String storeDelvNormal;

	// 店着納期区分（コート専用）
	private String storeDelvCoat;

	// 店着納期区分（早割）
	private String storeDelvEarly;

	// 工場コード
	private String factoryCode;

	// メーカーコード
	private String makerCode;

	//LCR縫製可否
	private String lcrSewingAvailable;
	
	//フル毛芯仕様可否
	private String fullHairclothAvailable;
	
	//シャツ仕様可否
	private String shirtSleeveAvailable;
	
	// 年季
	private String season;

	// 色(青山表記)
	private String colorAoyama;

	// 柄(青山表記)
	private String patternAoyama;

	// 予約生地量
	private String reservationStock;

	// ウォッシャブル可否
	private String washableAvailable;

	// タキシード可否
	private String tuxedoAvailable;
	
	//コート可否
	private String coatAvailable;
	
	private String jkDoublePrice;
	
	private String ctDoublePrice;
	
	private String glDoublePrice;
	
	//理論在庫 - 予約生地量
	private String stockResult;
	
	private Boolean jkModelCheck;
	
	private Boolean ptModelCheck; 
	
	private Boolean pt2ModelCheck; 
	
	private Boolean glModelCheck; 
	
	private Boolean ctModelCheck; 
	
	private Boolean shModelCheck; 
	
//	private String suit2PGoodsPrice;
//	
//	private String jkSingleGoodsPrice;
//	
//	private String jkDoubleGoodsPrice;
//	
//	private String glSingleGoodsPrice;
//	
//	private String glDoubleGoodsPrice;
//	
//	private String ptGoodsPrice;
//	
//	//COAT単品
//	private String ctSingleGoodsPrice;
//	
//	private String ctDoubleGoodsPrice;
//	
//	private String shGoodsPrice;.
	
	private String productPrice;
	
	public String getStockResult() {
		return stockResult;
	}

	public void setStockResult(String stockResult) {
		this.stockResult = stockResult;
	}

	public String getFabricNameExis() {
		return fabricNameExis;
	}

	public void setFabricNameExis(String fabricNameExis) {
		this.fabricNameExis = fabricNameExis;
	}

	public String getReservationStock() {
		return reservationStock;
	}

	public void setReservationStock(String reservationStock) {
		this.reservationStock = reservationStock;
	}

	public Date getSpinningLimitDate() {
		return spinningLimitDate;
	}

	public void setSpinningLimitDate(Date spinningLimitDate) {
		this.spinningLimitDate = spinningLimitDate;
	}

	public Integer getRetailPrice() {
		return retailPrice == null ? 0 : retailPrice;
	}

	public void setRetailPrice(Integer retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Integer getAdditionalPantsRate() {
		return additionalPantsRate == null ? 0 : additionalPantsRate;
	}

	public void setAdditionalPantsRate(Integer additionalPantsRate) {
		this.additionalPantsRate = additionalPantsRate;
	}

	public Integer getAdditionalSingleGiletRate() {
		return additionalSingleGiletRate == null ? 0 : additionalSingleGiletRate;
	}

	public void setAdditionalSingleGiletRate(Integer additionalSingleGiletRate) {
		this.additionalSingleGiletRate = additionalSingleGiletRate;
	}

	public Integer getAdditionalDoubleGiletRate() {
		return additionalDoubleGiletRate == null ? 0 : additionalDoubleGiletRate;
	}

	public void setAdditionalDoubleGiletRate(Integer additionalDoubleGiletRate) {
		this.additionalDoubleGiletRate = additionalDoubleGiletRate;
	}

	public Integer getAdditionalDoubleJacketRate() {
		return additionalDoubleJacketRate == null ? 0 : additionalDoubleJacketRate;
	}

	public void setAdditionalDoubleJacketRate(Integer additionalDoubleJacketRate) {
		this.additionalDoubleJacketRate = additionalDoubleJacketRate;
	}

	public Integer getSingleJacketOnlyRate() {
		return singleJacketOnlyRate == null ? 0 : singleJacketOnlyRate;
	}

	public void setSingleJacketOnlyRate(Integer singleJacketOnlyRate) {
		this.singleJacketOnlyRate = singleJacketOnlyRate;
	}

	public Integer getDoubleJacketOnlyRate() {
		return doubleJacketOnlyRate == null ? 0 : doubleJacketOnlyRate;
	}

	public void setDoubleJacketOnlyRate(Integer doubleJacketOnlyRate) {
		this.doubleJacketOnlyRate = doubleJacketOnlyRate;
	}

	public Integer getPantOnlyRate() {
		return pantOnlyRate == null ? 0 : pantOnlyRate;
	}

	public void setPantOnlyRate(Integer pantOnlyRate) {
		this.pantOnlyRate = pantOnlyRate;
	}

	public Integer getSingleGiletOnlyRate() {
		return singleGiletOnlyRate == null ? 0 : singleGiletOnlyRate;
	}

	public void setSingleGiletOnlyRate(Integer singleGiletOnlyRate) {
		this.singleGiletOnlyRate = singleGiletOnlyRate;
	}

	public Integer getDoubleGiletOnlyRate() {
		return doubleGiletOnlyRate == null ? 0 : doubleGiletOnlyRate;
	}

	public void setDoubleGiletOnlyRate(Integer doubleGiletOnlyRate) {
		this.doubleGiletOnlyRate = doubleGiletOnlyRate;
	}

	public Integer getCoatSingleOnlyRate() {
		return coatSingleOnlyRate == null ? 0 : coatSingleOnlyRate;
	}

	public void setCoatSingleOnlyRate(Integer coatSingleOnlyRate) {
		this.coatSingleOnlyRate = coatSingleOnlyRate;
	}

	public Integer getCoatDoubleOnlyRate() {
		return coatDoubleOnlyRate == null ? 0 : coatDoubleOnlyRate;
	}

	public void setCoatDoubleOnlyRate(Integer coatDoubleOnlyRate) {
		this.coatDoubleOnlyRate = coatDoubleOnlyRate;
	}

	public Integer getJkSingleOnlyPlusAlphaPrice() {
		return jkSingleOnlyPlusAlphaPrice == null ? 0 : jkSingleOnlyPlusAlphaPrice;
	}

	public void setJkSingleOnlyPlusAlphaPrice(Integer jkSingleOnlyPlusAlphaPrice) {
		this.jkSingleOnlyPlusAlphaPrice = jkSingleOnlyPlusAlphaPrice;
	}

	public Integer getJkDoubleOnlyPlusAlphaPrice() {
		return jkDoubleOnlyPlusAlphaPrice == null ? 0 : jkDoubleOnlyPlusAlphaPrice;
	}

	public void setJkDoubleOnlyPlusAlphaPrice(Integer jkDoubleOnlyPlusAlphaPrice) {
		this.jkDoubleOnlyPlusAlphaPrice = jkDoubleOnlyPlusAlphaPrice;
	}

	public Integer getGlSingleOnlyPlusAlphaPrice() {
		return glSingleOnlyPlusAlphaPrice == null ? 0 : glSingleOnlyPlusAlphaPrice;
	}

	public void setGlSingleOnlyPlusAlphaPrice(Integer glSingleOnlyPlusAlphaPrice) {
		this.glSingleOnlyPlusAlphaPrice = glSingleOnlyPlusAlphaPrice;
	}

	public Integer getGlDoubleOnlyPlusAlphaPrice() {
		return glDoubleOnlyPlusAlphaPrice == null ? 0 : glDoubleOnlyPlusAlphaPrice;
	}

	public void setGlDoubleOnlyPlusAlphaPrice(Integer glDoubleOnlyPlusAlphaPrice) {
		this.glDoubleOnlyPlusAlphaPrice = glDoubleOnlyPlusAlphaPrice;
	}

	public Integer getPtOnlyPlusAlphaPrice() {
		return ptOnlyPlusAlphaPrice == null ? 0 : ptOnlyPlusAlphaPrice;
	}

	public void setPtOnlyPlusAlphaPrice(Integer ptOnlyPlusAlphaPrice) {
		this.ptOnlyPlusAlphaPrice = ptOnlyPlusAlphaPrice;
	}

	public Integer getCtSingleOnlyPlusAlphaPrice() {
		return ctSingleOnlyPlusAlphaPrice == null ? 0 : ctSingleOnlyPlusAlphaPrice;
	}

	public void setCtSingleOnlyPlusAlphaPrice(Integer ctSingleOnlyPlusAlphaPrice) {
		this.ctSingleOnlyPlusAlphaPrice = ctSingleOnlyPlusAlphaPrice;
	}

	public Integer getCtDoubleOnlyPlusAlphaPrice() {
		return ctDoubleOnlyPlusAlphaPrice == null ? 0 : ctDoubleOnlyPlusAlphaPrice;
	}

	public void setCtDoubleOnlyPlusAlphaPrice(Integer ctDoubleOnlyPlusAlphaPrice) {
		this.ctDoubleOnlyPlusAlphaPrice = ctDoubleOnlyPlusAlphaPrice;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getCompositionLabel() {
		return compositionLabel;
	}

	public void setCompositionLabel(String compositionLabel) {
		this.compositionLabel = compositionLabel;
	}

	public String getTheoreticalStock() {
		return theoreticalStock;
	}

	public void setTheoreticalStock(String theoreticalStock) {
		this.theoreticalStock = theoreticalStock;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getHandlingCaution() {
		return handlingCaution;
	}

	public void setHandlingCaution(String handlingCaution) {
		this.handlingCaution = handlingCaution;
	}

	public String getItemClass() {
		return itemClass;
	}

	public void setItemClass(String itemClass) {
		this.itemClass = itemClass;
	}

	public String getStoreDelvNormal() {
		return storeDelvNormal;
	}

	public void setStoreDelvNormal(String storeDelvNormal) {
		this.storeDelvNormal = storeDelvNormal;
	}

	public String getFactoryCode() {
		return factoryCode;
	}

	public void setFactoryCode(String factoryCode) {
		this.factoryCode = factoryCode;
	}

	public String getMakerCode() {
		return makerCode;
	}

	public void setMakerCode(String makerCode) {
		this.makerCode = makerCode;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getColorAoyama() {
		return colorAoyama;
	}

	public void setColorAoyama(String colorAoyama) {
		this.colorAoyama = colorAoyama;
	}

	public String getPatternAoyama() {
		return patternAoyama;
	}

	public void setPatternAoyama(String patternAoyama) {
		this.patternAoyama = patternAoyama;
	}

	public String getWashableAvailable() {
		return washableAvailable;
	}

	public void setWashableAvailable(String washableAvailable) {
		this.washableAvailable = washableAvailable;
	}

	public String getTuxedoAvailable() {
		return tuxedoAvailable;
	}

	public void setTuxedoAvailable(String tuxedoAvailable) {
		this.tuxedoAvailable = tuxedoAvailable;
	}

	public String getStoreDelvCoat() {
		return storeDelvCoat;
	}

	public void setStoreDelvCoat(String storeDelvCoat) {
		this.storeDelvCoat = storeDelvCoat;
	}

	public String getStoreDelvEarly() {
		return storeDelvEarly;
	}

	public void setStoreDelvEarly(String storeDelvEarly) {
		this.storeDelvEarly = storeDelvEarly;
	}

	public String getLcrSewingAvailable() {
		return lcrSewingAvailable;
	}

	public void setLcrSewingAvailable(String lcrSewingAvailable) {
		this.lcrSewingAvailable = lcrSewingAvailable;
	}

	public Boolean getJkModelCheck() {
		return jkModelCheck;
	}

	public void setJkModelCheck(Boolean jkModelCheck) {
		this.jkModelCheck = jkModelCheck;
	}

	public Boolean getPtModelCheck() {
		return ptModelCheck;
	}

	public void setPtModelCheck(Boolean ptModelCheck) {
		this.ptModelCheck = ptModelCheck;
	}

	public Boolean getPt2ModelCheck() {
		return pt2ModelCheck;
	}

	public void setPt2ModelCheck(Boolean pt2ModelCheck) {
		this.pt2ModelCheck = pt2ModelCheck;
	}

	public Boolean getGlModelCheck() {
		return glModelCheck;
	}

	public void setGlModelCheck(Boolean glModelCheck) {
		this.glModelCheck = glModelCheck;
	}

	public Boolean getCtModelCheck() {
		return ctModelCheck;
	}

	public void setCtModelCheck(Boolean ctModelCheck) {
		this.ctModelCheck = ctModelCheck;
	}

	public Boolean getShModelCheck() {
		return shModelCheck;
	}

	public void setShModelCheck(Boolean shModelCheck) {
		this.shModelCheck = shModelCheck;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getJkDoublePrice() {
		return jkDoublePrice;
	}

	public void setJkDoublePrice(String jkDoublePrice) {
		this.jkDoublePrice = jkDoublePrice;
	}

	public String getCoatAvailable() {
		return coatAvailable;
	}

	public void setCoatAvailable(String coatAvailable) {
		this.coatAvailable = coatAvailable;
	}

	public String getCtDoublePrice() {
		return ctDoublePrice;
	}

	public void setCtDoublePrice(String ctDoublePrice) {
		this.ctDoublePrice = ctDoublePrice;
	}

	public String getFullHairclothAvailable() {
		return fullHairclothAvailable;
	}

	public void setFullHairclothAvailable(String fullHairclothAvailable) {
		this.fullHairclothAvailable = fullHairclothAvailable;
	}

	public String getShirtSleeveAvailable() {
		return shirtSleeveAvailable;
	}

	public void setShirtSleeveAvailable(String shirtSleeveAvailable) {
		this.shirtSleeveAvailable = shirtSleeveAvailable;
	}

	public String getGlDoublePrice() {
		return glDoublePrice;
	}

	public void setGlDoublePrice(String glDoublePrice) {
		this.glDoublePrice = glDoublePrice;
	}
	
}
