package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Piece implements Serializable {

	private static final long serialVersionUID = 2916961973815804281L;

	private String factoryCode;
    private String itemCode;
    private BigDecimal dollarExchange;
    private BigDecimal productTariff;
    private Integer productShipping;
    private Integer shippingError;
    private Date createdAt;
    private Date updatedAt;
    private String createdUserId;
    private String updatedUserId;
    private Short version;
    
    private boolean delType;
    private String optionType;

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode == null ? null : factoryCode.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

	public BigDecimal getDollarExchange() {
        return dollarExchange;
    }

    public void setDollarExchange(BigDecimal dollarExchange) {
        this.dollarExchange = dollarExchange;
    }

    public BigDecimal getProductTariff() {
        return productTariff;
    }

    public void setProductTariff(BigDecimal productTariff) {
        this.productTariff = productTariff;
    }

    public Integer getProductShipping() {
        return productShipping;
    }

    public void setProductShipping(Integer productShipping) {
        this.productShipping = productShipping;
    }

    public Integer getShippingError() {
        return shippingError;
    }

    public void setShippingError(Integer shippingError) {
        this.shippingError = shippingError;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public Short getVersion() {
		return version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	public boolean getDelType() {
		return delType;
	}

	public void setDelType(boolean delType) {
		this.delType = delType;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
}