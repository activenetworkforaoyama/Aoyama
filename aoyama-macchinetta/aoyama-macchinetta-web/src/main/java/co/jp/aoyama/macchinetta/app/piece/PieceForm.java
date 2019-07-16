package co.jp.aoyama.macchinetta.app.piece;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class PieceForm implements Serializable {

	private static final long serialVersionUID = -605687266286991360L;

	private String factoryCode;
	private String itemCode;
	private BigDecimal dollarExchange;
	private BigDecimal productTariff;
	private Integer productShipping;
	private Integer shippingError;
	@CreatedDate
	private Date createdAt;
	@LastModifiedDate
	private Date updatedAt;
	private String createdUserId;
    private String updatedUserId;
    
	private Boolean delType;
	private String optionType;
	private String updateFailure;
	private String num;
    private String isNewData;
    
    private Boolean displayIdentify;

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

	public Boolean getDisplayIdentify() {
		return displayIdentify;
	}

	public void setDisplayIdentify(Boolean displayIdentify) {
		this.displayIdentify = displayIdentify;
	}
}