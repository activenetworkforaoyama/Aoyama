package co.jp.aoyama.macchinetta.app.accounting;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountingForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5785944606669500229L;
	
	private String cashId;

    private String cashStatus;

    private String orderPattern;

    private String storeBrandCode;

    private String shopCode;

    private String storeStaffNm;
    
    private String shopName;

    private String custCd;

    private String productOrderdDate;
    
    private Date productOrderdDateFrom;
    
    private Date productOrderdDateTo;
    
    private String productOrderdDateFromStr;
    
    private String productOrderdDateToStr;

    private Short orderAmount;

    private Integer cashTotalPrice;

    private Integer cashExceptTaxPrice;

    private Integer cashTaxAmount;

    private String createdUserId;

    private Date createdAt;

    private String updatedUserId;

    private Date updatedAt;
    
    private String authority;
    
    private String belongCode;
    
    private boolean isAccount;

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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	public String getProductOrderdDate() {
		return productOrderdDate;
	}

	public void setProductOrderdDate(String productOrderdDate) {
		this.productOrderdDate = productOrderdDate;
	}

	public Date getProductOrderdDateFrom() {
		return productOrderdDateFrom;
	}

	public void setProductOrderdDateFrom(Date productOrderdDateFrom) {
		this.productOrderdDateFrom = productOrderdDateFrom;
	}

	public Date getProductOrderdDateTo() {
		return productOrderdDateTo;
	}

	public void setProductOrderdDateTo(Date productOrderdDateTo) {
		this.productOrderdDateTo = productOrderdDateTo;
	}

	public String getProductOrderdDateFromStr() {
		return productOrderdDateFromStr;
	}

	public void setProductOrderdDateFromStr(String productOrderdDateFromStr) {
		this.productOrderdDateFromStr = productOrderdDateFromStr;
	}

	public String getProductOrderdDateToStr() {
		return productOrderdDateToStr;
	}

	public void setProductOrderdDateToStr(String productOrderdDateToStr) {
		this.productOrderdDateToStr = productOrderdDateToStr;
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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getBelongCode() {
		return belongCode;
	}

	public void setBelongCode(String belongCode) {
		this.belongCode = belongCode;
	}
	
	public boolean getIsAccount() {
		return isAccount;
	}

	public void setIsAccount(boolean isAccount) {
		this.isAccount = isAccount;
	}
}
