package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class DtbCash implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public String getCashId() {
        return cashId;
    }

    public void setCashId(String cashId) {
        this.cashId = cashId == null ? null : cashId.trim();
    }

    public String getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(String cashStatus) {
        this.cashStatus = cashStatus == null ? null : cashStatus.trim();
    }

    public String getOrderPattern() {
        return orderPattern;
    }

    public void setOrderPattern(String orderPattern) {
        this.orderPattern = orderPattern == null ? null : orderPattern.trim();
    }

    public String getStoreBrandCode() {
        return storeBrandCode;
    }

    public void setStoreBrandCode(String storeBrandCode) {
        this.storeBrandCode = storeBrandCode == null ? null : storeBrandCode.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getStoreStaffNm() {
        return storeStaffNm;
    }

    public void setStoreStaffNm(String storeStaffNm) {
        this.storeStaffNm = storeStaffNm == null ? null : storeStaffNm.trim();
    }

    public String getCustCd() {
        return custCd;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd == null ? null : custCd.trim();
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
}