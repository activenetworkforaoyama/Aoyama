package co.jp.aoyama.macchinetta.app.cash;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.CashInfo;

public class CashForm implements Serializable {

	private static final long serialVersionUID = -9011201610612287040L;
	
	private String orderId;

	private String totalPrice;
	
	private String cashDiscountPrice;
	
	private String cashProductPrice;
	
	private String consumptionTaxAmount;
	
	private String productPrice;
	
	private String cashId;

    private String cashStatus;

    private String orderPattern;

    private String storeBrandCode;

    private String shopCode;

    private String storeStaffNm;

    private String custNm;
    
    private String custCd;

    private Date productOrderdDate;

    private Short orderAmount;

    private String cashTotalPrice;

    private String cashExceptTaxPrice;

    private String cashTaxAmount;

    private String createdUserId;

    private Date createdAt;

    private String updatedUserId;

    private Date updatedAt;
    
    private String custStaff;
    
    private String tscStatus;
    
    private String makerFactoryStatus;
    
    private List<CashInfo> helpCashForm;
    
    private List<CashInfo> orderIdList;
    
    private String backFlag;
    
    private String version;

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

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
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

	public String getCashTotalPrice() {
		return cashTotalPrice;
	}

	public void setCashTotalPrice(String cashTotalPrice) {
		this.cashTotalPrice = cashTotalPrice;
	}

	public String getCashExceptTaxPrice() {
		return cashExceptTaxPrice;
	}

	public void setCashExceptTaxPrice(String cashExceptTaxPrice) {
		this.cashExceptTaxPrice = cashExceptTaxPrice;
	}

	public String getCashTaxAmount() {
		return cashTaxAmount;
	}

	public void setCashTaxAmount(String cashTaxAmount) {
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

	public List<CashInfo> getHelpCashForm() {
		return helpCashForm;
	}

	public void setHelpCashForm(List<CashInfo> helpCashForm) {
		this.helpCashForm = helpCashForm;
	}

	public String getBackFlag() {
		return backFlag;
	}

	public void setBackFlag(String backFlag) {
		this.backFlag = backFlag;
	}

	public List<CashInfo> getOrderIdList() {
		return orderIdList;
	}

	public void setOrderIdList(List<CashInfo> orderIdList) {
		this.orderIdList = orderIdList;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
