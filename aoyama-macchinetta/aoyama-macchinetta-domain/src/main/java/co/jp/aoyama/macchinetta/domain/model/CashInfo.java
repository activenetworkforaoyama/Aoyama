package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class CashInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 209273826490627901L;
	
	private String orderId;

	private Integer totalPrice;
	
	private Integer cashDiscountPrice;
	
	private Integer cashProductPrice;
	
	private Integer cashContailTaxProductPrice;
	
	private String cashId;

    private String orderPattern;

    private String storeBrandCode;

    private String shopCode;

    private String storeStaffNm;

    private String custNm;
    
    private String custCd;
    
    private String custStaff;
    
    private String tscStatus;
    
    private String makerFactoryStatus;
    
    private String isCancelled;
    
    private Short version;
    
    private Date productOrderdDate;
    
    private String updatedUserId;

    private Date updatedAt;
    
    private Integer wsPrice;
    
    private String custType;

	public Integer getWsPrice() {
		return wsPrice;
	}

	public void setWsPrice(Integer wsPrice) {
		this.wsPrice = wsPrice;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getCashDiscountPrice() {
		return cashDiscountPrice;
	}

	public void setCashDiscountPrice(Integer cashDiscountPrice) {
		this.cashDiscountPrice = cashDiscountPrice;
	}

	public Integer getCashProductPrice() {
		return cashProductPrice;
	}

	public void setCashProductPrice(Integer cashProductPrice) {
		this.cashProductPrice = cashProductPrice;
	}

	public Integer getCashContailTaxProductPrice() {
		return cashContailTaxProductPrice;
	}

	public void setCashContailTaxProductPrice(Integer cashContailTaxProductPrice) {
		this.cashContailTaxProductPrice = cashContailTaxProductPrice;
	}

	public String getCashId() {
		return cashId;
	}

	public void setCashId(String cashId) {
		this.cashId = cashId;
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

	public String getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(String isCancelled) {
		this.isCancelled = isCancelled;
	}

	public Short getVersion() {
		return version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	public Date getProductOrderdDate() {
		return productOrderdDate;
	}

	public void setProductOrderdDate(Date productOrderdDate) {
		this.productOrderdDate = productOrderdDate;
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
    
}
