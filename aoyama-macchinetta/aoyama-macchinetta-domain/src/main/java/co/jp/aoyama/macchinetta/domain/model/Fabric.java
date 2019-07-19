package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Fabric implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5179047345861032110L;
    private String orderPattern;
    private String fabricNo;
    private String materialNo;
    private String fablicBrandNo;
    private String storeBrand;
    private String season;
    private String color;
    private String pattern;
    private String colorAoyama;
    private String patternAoyama;
    private String materialName;
    private String itemClass;
    private String coatAvailable;
    private String compositionLabel;
    private String factoryCode;
    private String makerCode;
    private String lcrSewingAvailable;
    private Integer retailPrice;
    private Integer additionalPantsRate;
    private Integer additionalSingleGiletRate;
    private Integer additionalDoubleGiletRate;
    private Integer additionalDoubleJacketRate;
    private Integer singleJacketOnlyRate;
    private Integer doubleJacketOnlyRate;
    private Integer pantOnlyRate;
    private Integer singleGiletOnlyRate;
    private Integer doubleGiletOnlyRate;
    private Integer coatSingleOnlyRate;
    private Integer coatDoubleOnlyRate;
    private Integer jkSingleOnlyPlusAlphaPrice;
    private Integer jkDoubleOnlyPlusAlphaPrice;
    private Integer glSingleOnlyPlusAlphaPrice;
    private Integer glDoubleOnlyPlusAlphaPrice;
    private Integer ptOnlyPlusAlphaPrice;
    private Integer ctSingleOnlyPlusAlphaPrice;
    private Integer ctDoubleOnlyPlusAlphaPrice;
    private Integer fabricPrice;
    private String washableAvailable;
    private String tuxedoAvailable;
    private Integer wsPriceAdjust;
    private String contractNo;
    private Date spinningLimitDate;
    private String fablicImporter;
    private String fullHairclothAvailable;
    private String shirtSleeveAvailable;
    private String storeDelvNormal;
    private String storeDelvEarly;
    private String storeDelvCoat;
    private String handlingCaution;
    private String fabricNameExist;
    private String createdUserId;
    private Date createdAt;
    private String updatedUserId;
    private Date updatedAt;
    
    private Short fabricVersion;
    private Short stockVersion;
    
    private BigDecimal theoreticalStock;
    private BigDecimal reservationStock;
    private String handleDiscriminate;
    private String[] errorArr;
    
    private Boolean delType;
	private String optionType;
	private String updateFailure;
	private String num;
    private String isNewData;

    public String getOrderPattern() {
        return orderPattern;
    }

    public void setOrderPattern(String orderPattern) {
        this.orderPattern = orderPattern == null ? null : orderPattern.trim();
    }

    public String getFabricNo() {
        return fabricNo;
    }

    public void setFabricNo(String fabricNo) {
        this.fabricNo = fabricNo == null ? null : fabricNo.trim();
    }

    public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getFablicBrandNo() {
        return fablicBrandNo;
    }

    public void setFablicBrandNo(String fablicBrandNo) {
        this.fablicBrandNo = fablicBrandNo == null ? null : fablicBrandNo.trim();
    }

    public String getStoreBrand() {
        return storeBrand;
    }

    public void setStoreBrand(String storeBrand) {
        this.storeBrand = storeBrand == null ? null : storeBrand.trim();
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season == null ? null : season.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
    }

    public String getColorAoyama() {
        return colorAoyama;
    }

    public void setColorAoyama(String colorAoyama) {
        this.colorAoyama = colorAoyama == null ? null : colorAoyama.trim();
    }

    public String getPatternAoyama() {
        return patternAoyama;
    }

    public void setPatternAoyama(String patternAoyama) {
        this.patternAoyama = patternAoyama == null ? null : patternAoyama.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass == null ? null : itemClass.trim();
    }

    public String getCoatAvailable() {
        return coatAvailable;
    }

    public void setCoatAvailable(String coatAvailable) {
        this.coatAvailable = coatAvailable == null ? null : coatAvailable.trim();
    }

    public String getCompositionLabel() {
        return compositionLabel;
    }

    public void setCompositionLabel(String compositionLabel) {
        this.compositionLabel = compositionLabel == null ? null : compositionLabel.trim();
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode == null ? null : factoryCode.trim();
    }

    public String getMakerCode() {
        return makerCode;
    }

    public void setMakerCode(String makerCode) {
        this.makerCode = makerCode == null ? null : makerCode.trim();
    }

    public String getLcrSewingAvailable() {
        return lcrSewingAvailable;
    }

    public void setLcrSewingAvailable(String lcrSewingAvailable) {
        this.lcrSewingAvailable = lcrSewingAvailable == null ? null : lcrSewingAvailable.trim();
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getAdditionalPantsRate() {
        return additionalPantsRate;
    }

    public void setAdditionalPantsRate(Integer additionalPantsRate) {
        this.additionalPantsRate = additionalPantsRate;
    }

    public Integer getAdditionalSingleGiletRate() {
        return additionalSingleGiletRate;
    }

    public void setAdditionalSingleGiletRate(Integer additionalSingleGiletRate) {
        this.additionalSingleGiletRate = additionalSingleGiletRate;
    }

    public Integer getAdditionalDoubleGiletRate() {
        return additionalDoubleGiletRate;
    }

    public void setAdditionalDoubleGiletRate(Integer additionalDoubleGiletRate) {
        this.additionalDoubleGiletRate = additionalDoubleGiletRate;
    }

    public Integer getAdditionalDoubleJacketRate() {
        return additionalDoubleJacketRate;
    }

    public void setAdditionalDoubleJacketRate(Integer additionalDoubleJacketRate) {
        this.additionalDoubleJacketRate = additionalDoubleJacketRate;
    }

    public Integer getSingleJacketOnlyRate() {
        return singleJacketOnlyRate;
    }

    public void setSingleJacketOnlyRate(Integer singleJacketOnlyRate) {
        this.singleJacketOnlyRate = singleJacketOnlyRate;
    }

    public Integer getDoubleJacketOnlyRate() {
        return doubleJacketOnlyRate;
    }

    public void setDoubleJacketOnlyRate(Integer doubleJacketOnlyRate) {
        this.doubleJacketOnlyRate = doubleJacketOnlyRate;
    }

    public Integer getPantOnlyRate() {
        return pantOnlyRate;
    }

    public void setPantOnlyRate(Integer pantOnlyRate) {
        this.pantOnlyRate = pantOnlyRate;
    }

    public Integer getSingleGiletOnlyRate() {
        return singleGiletOnlyRate;
    }

    public void setSingleGiletOnlyRate(Integer singleGiletOnlyRate) {
        this.singleGiletOnlyRate = singleGiletOnlyRate;
    }

    public Integer getDoubleGiletOnlyRate() {
        return doubleGiletOnlyRate;
    }

    public void setDoubleGiletOnlyRate(Integer doubleGiletOnlyRate) {
        this.doubleGiletOnlyRate = doubleGiletOnlyRate;
    }

    public Integer getCoatSingleOnlyRate() {
        return coatSingleOnlyRate;
    }

    public void setCoatSingleOnlyRate(Integer coatSingleOnlyRate) {
        this.coatSingleOnlyRate = coatSingleOnlyRate;
    }

    public Integer getCoatDoubleOnlyRate() {
        return coatDoubleOnlyRate;
    }

    public void setCoatDoubleOnlyRate(Integer coatDoubleOnlyRate) {
        this.coatDoubleOnlyRate = coatDoubleOnlyRate;
    }

    public Integer getJkSingleOnlyPlusAlphaPrice() {
        return jkSingleOnlyPlusAlphaPrice;
    }

    public void setJkSingleOnlyPlusAlphaPrice(Integer jkSingleOnlyPlusAlphaPrice) {
        this.jkSingleOnlyPlusAlphaPrice = jkSingleOnlyPlusAlphaPrice;
    }

    public Integer getJkDoubleOnlyPlusAlphaPrice() {
        return jkDoubleOnlyPlusAlphaPrice;
    }

    public void setJkDoubleOnlyPlusAlphaPrice(Integer jkDoubleOnlyPlusAlphaPrice) {
        this.jkDoubleOnlyPlusAlphaPrice = jkDoubleOnlyPlusAlphaPrice;
    }

    public Integer getGlSingleOnlyPlusAlphaPrice() {
        return glSingleOnlyPlusAlphaPrice;
    }

    public void setGlSingleOnlyPlusAlphaPrice(Integer glSingleOnlyPlusAlphaPrice) {
        this.glSingleOnlyPlusAlphaPrice = glSingleOnlyPlusAlphaPrice;
    }

    public Integer getGlDoubleOnlyPlusAlphaPrice() {
        return glDoubleOnlyPlusAlphaPrice;
    }

    public void setGlDoubleOnlyPlusAlphaPrice(Integer glDoubleOnlyPlusAlphaPrice) {
        this.glDoubleOnlyPlusAlphaPrice = glDoubleOnlyPlusAlphaPrice;
    }

    public Integer getPtOnlyPlusAlphaPrice() {
        return ptOnlyPlusAlphaPrice;
    }

    public void setPtOnlyPlusAlphaPrice(Integer ptOnlyPlusAlphaPrice) {
        this.ptOnlyPlusAlphaPrice = ptOnlyPlusAlphaPrice;
    }

    public Integer getCtSingleOnlyPlusAlphaPrice() {
        return ctSingleOnlyPlusAlphaPrice;
    }

    public void setCtSingleOnlyPlusAlphaPrice(Integer ctSingleOnlyPlusAlphaPrice) {
        this.ctSingleOnlyPlusAlphaPrice = ctSingleOnlyPlusAlphaPrice;
    }

    public Integer getCtDoubleOnlyPlusAlphaPrice() {
        return ctDoubleOnlyPlusAlphaPrice;
    }

    public void setCtDoubleOnlyPlusAlphaPrice(Integer ctDoubleOnlyPlusAlphaPrice) {
        this.ctDoubleOnlyPlusAlphaPrice = ctDoubleOnlyPlusAlphaPrice;
    }

    public Integer getFabricPrice() {
        return fabricPrice;
    }

    public void setFabricPrice(Integer fabricPrice) {
        this.fabricPrice = fabricPrice;
    }

    public String getWashableAvailable() {
        return washableAvailable;
    }

    public void setWashableAvailable(String washableAvailable) {
        this.washableAvailable = washableAvailable == null ? null : washableAvailable.trim();
    }

    public String getTuxedoAvailable() {
        return tuxedoAvailable;
    }

    public void setTuxedoAvailable(String tuxedoAvailable) {
        this.tuxedoAvailable = tuxedoAvailable == null ? null : tuxedoAvailable.trim();
    }

    public Integer getWsPriceAdjust() {
        return wsPriceAdjust;
    }

    public void setWsPriceAdjust(Integer wsPriceAdjust) {
        this.wsPriceAdjust = wsPriceAdjust;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Date getSpinningLimitDate() {
        return spinningLimitDate;
    }

    public void setSpinningLimitDate(Date spinningLimitDate) {
        this.spinningLimitDate = spinningLimitDate;
    }

    public String getFablicImporter() {
        return fablicImporter;
    }

    public void setFablicImporter(String fablicImporter) {
        this.fablicImporter = fablicImporter == null ? null : fablicImporter.trim();
    }

    public String getFullHairclothAvailable() {
        return fullHairclothAvailable;
    }

    public void setFullHairclothAvailable(String fullHairclothAvailable) {
        this.fullHairclothAvailable = fullHairclothAvailable == null ? null : fullHairclothAvailable.trim();
    }

    public String getShirtSleeveAvailable() {
        return shirtSleeveAvailable;
    }

    public void setShirtSleeveAvailable(String shirtSleeveAvailable) {
        this.shirtSleeveAvailable = shirtSleeveAvailable == null ? null : shirtSleeveAvailable.trim();
    }

    public String getStoreDelvNormal() {
        return storeDelvNormal;
    }

    public void setStoreDelvNormal(String storeDelvNormal) {
        this.storeDelvNormal = storeDelvNormal == null ? null : storeDelvNormal.trim();
    }

    public String getStoreDelvEarly() {
        return storeDelvEarly;
    }

    public void setStoreDelvEarly(String storeDelvEarly) {
        this.storeDelvEarly = storeDelvEarly == null ? null : storeDelvEarly.trim();
    }

    public String getStoreDelvCoat() {
        return storeDelvCoat;
    }

    public void setStoreDelvCoat(String storeDelvCoat) {
        this.storeDelvCoat = storeDelvCoat == null ? null : storeDelvCoat.trim();
    }

    public String getHandlingCaution() {
        return handlingCaution;
    }

    public void setHandlingCaution(String handlingCaution) {
        this.handlingCaution = handlingCaution == null ? null : handlingCaution.trim();
    }

    public String getFabricNameExist() {
        return fabricNameExist;
    }

    public void setFabricNameExist(String fabricNameExist) {
        this.fabricNameExist = fabricNameExist == null ? null : fabricNameExist.trim();
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId == null ? null : updatedUserId.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

	public Short getFabricVersion() {
		return fabricVersion;
	}

	public void setFabricVersion(Short fabricVersion) {
		this.fabricVersion = fabricVersion;
	}

	public Short getStockVersion() {
		return stockVersion;
	}

	public void setStockVersion(Short stockVersion) {
		this.stockVersion = stockVersion;
	}

	public BigDecimal getTheoreticalStock() {
		return theoreticalStock;
	}

	public void setTheoreticalStock(BigDecimal theoreticalStock) {
		this.theoreticalStock = theoreticalStock;
	}

	public BigDecimal getReservationStock() {
		return reservationStock;
	}

	public void setReservationStock(BigDecimal reservationStock) {
		this.reservationStock = reservationStock;
	}

	public String getHandleDiscriminate() {
		return handleDiscriminate;
	}

	public void setHandleDiscriminate(String handleDiscriminate) {
		this.handleDiscriminate = handleDiscriminate;
	}

	public String[] getErrorArr() {
		return errorArr;
	}

	public void setErrorArr(String[] errorArr) {
		this.errorArr = errorArr;
	}

	public Boolean getDelType() {
		return delType;
	}

	public void setDelType(Boolean delType) {
		this.delType = delType;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getUpdateFailure() {
		return updateFailure;
	}

	public void setUpdateFailure(String updateFailure) {
		this.updateFailure = updateFailure;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getIsNewData() {
		return isNewData;
	}

	public void setIsNewData(String isNewData) {
		this.isNewData = isNewData;
	}
}