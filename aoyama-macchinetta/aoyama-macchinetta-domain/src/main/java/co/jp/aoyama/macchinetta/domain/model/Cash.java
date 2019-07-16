package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Cash implements Serializable {

	private static final long serialVersionUID = -5457007221259933325L;
	
	private String cashId;

    private String cashStatus;

    private String orderPattern;

    private String storeBrandCode;

    private String shopCode;

    private String storeStaffNm;

    private String custCd;

    private Date productOrderdDate;

    private Short orderAmount;

    private Integer cashTotalPrice;

    private Integer cashExceptTaxPrice;

    private Integer cashTaxAmount;

    private String createdUserId;

    private Date createdAt;

    private String updatedUserId;

    private Date updatedAt;
    
    private String optionType;
    
	private String orderId;

	private String totalPrice;
	
	private String cashDiscountPrice;
	
	private String cashProductPrice;
	
	private String consumptionTaxAmount;
	
	private String productPrice;

    private String custNm;
    
    private String custStaff;
    
    private String tscStatus;
    
    private String makerFactoryStatus;

	public String getCashId() {
		return cashId;
	}

	public void setCashId(String cashId) {
		this.cashId = cashId;
	}

	public String getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(String cashStatus) {
		this.cashStatus = cashStatus;
	}

	public String getOrderPattern() {
		return orderPattern;
	}

	public void setOrderPattern(String orderPattern) {
		this.orderPattern = orderPattern;
	}

	public String getStoreBrandCode() {
		return storeBrandCode;
	}

	public void setStoreBrandCode(String storeBrandCode) {
		this.storeBrandCode = storeBrandCode;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getStoreStaffNm() {
		return storeStaffNm;
	}

	public void setStoreStaffNm(String storeStaffNm) {
		this.storeStaffNm = storeStaffNm;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public Date getProductOrderdDate() {
		return productOrderdDate;
	}

	public void setProductOrderdDate(Date productOrderdDate) {
		this.productOrderdDate = productOrderdDate;
	}

	public Short getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Short orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getCashTotalPrice() {
		return cashTotalPrice;
	}

	public void setCashTotalPrice(Integer cashTotalPrice) {
		this.cashTotalPrice = cashTotalPrice;
	}

	public Integer getCashExceptTaxPrice() {
		return cashExceptTaxPrice;
	}

	public void setCashExceptTaxPrice(Integer cashExceptTaxPrice) {
		this.cashExceptTaxPrice = cashExceptTaxPrice;
	}

	public Integer getCashTaxAmount() {
		return cashTaxAmount;
	}

	public void setCashTaxAmount(Integer cashTaxAmount) {
		this.cashTaxAmount = cashTaxAmount;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
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
		this.updatedUserId = updatedUserId;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCashDiscountPrice() {
		return cashDiscountPrice;
	}

	public void setCashDiscountPrice(String cashDiscountPrice) {
		this.cashDiscountPrice = cashDiscountPrice;
	}

	public String getCashProductPrice() {
		return cashProductPrice;
	}

	public void setCashProductPrice(String cashProductPrice) {
		this.cashProductPrice = cashProductPrice;
	}

	public String getConsumptionTaxAmount() {
		return consumptionTaxAmount;
	}

	public void setConsumptionTaxAmount(String consumptionTaxAmount) {
		this.consumptionTaxAmount = consumptionTaxAmount;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getCustStaff() {
		return custStaff;
	}

	public void setCustStaff(String custStaff) {
		this.custStaff = custStaff;
	}

	public String getTscStatus() {
		return tscStatus;
	}

	public void setTscStatus(String tscStatus) {
		this.tscStatus = tscStatus;
	}

	public String getMakerFactoryStatus() {
		return makerFactoryStatus;
	}

	public void setMakerFactoryStatus(String makerFactoryStatus) {
		this.makerFactoryStatus = makerFactoryStatus;
	}

}
