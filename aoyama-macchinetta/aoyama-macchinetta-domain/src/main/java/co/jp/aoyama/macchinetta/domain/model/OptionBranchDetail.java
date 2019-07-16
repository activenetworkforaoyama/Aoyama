package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class OptionBranchDetail implements Serializable {
	
	private static final long serialVersionUID = 6926254434264410116L;

	private String orderPattern;

    private String subItemCode;

    private String optionCode;

    private String optionBranchCode;

    private String optionBranchDetailCode;

    private String standardAvailable;

    private String tuxedoAvailable;

    private String washableAvailable;

    private String optionBranchName;

    private String optionBranchDetailName;

    private Integer optionBranchPrice;

    private Integer optionBranchDoublePrice;

    private Short displayOrder;

    private String createdUserId;

    private Date createdAt;

    private String updatedUserId;

    private Date updatedAt;


    public String getOrderPattern() {
        return orderPattern;
    }

    public void setOrderPattern(String orderPattern) {
        this.orderPattern = orderPattern == null ? null : orderPattern.trim();
    }

    public String getSubItemCode() {
        return subItemCode;
    }

    public void setSubItemCode(String subItemCode) {
        this.subItemCode = subItemCode == null ? null : subItemCode.trim();
    }

    public String getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(String optionCode) {
        this.optionCode = optionCode == null ? null : optionCode.trim();
    }

    public String getOptionBranchCode() {
        return optionBranchCode;
    }

    public void setOptionBranchCode(String optionBranchCode) {
        this.optionBranchCode = optionBranchCode == null ? null : optionBranchCode.trim();
    }

    public String getOptionBranchDetailCode() {
        return optionBranchDetailCode;
    }

    public void setOptionBranchDetailCode(String optionBranchDetailCode) {
        this.optionBranchDetailCode = optionBranchDetailCode == null ? null : optionBranchDetailCode.trim();
    }

    public String getStandardAvailable() {
        return standardAvailable;
    }

    public void setStandardAvailable(String standardAvailable) {
        this.standardAvailable = standardAvailable == null ? null : standardAvailable.trim();
    }

    public String getTuxedoAvailable() {
        return tuxedoAvailable;
    }

    public void setTuxedoAvailable(String tuxedoAvailable) {
        this.tuxedoAvailable = tuxedoAvailable == null ? null : tuxedoAvailable.trim();
    }

    public String getWashableAvailable() {
        return washableAvailable;
    }

    public void setWashableAvailable(String washableAvailable) {
        this.washableAvailable = washableAvailable == null ? null : washableAvailable.trim();
    }

    public String getOptionBranchName() {
        return optionBranchName;
    }

    public void setOptionBranchName(String optionBranchName) {
        this.optionBranchName = optionBranchName == null ? null : optionBranchName.trim();
    }

    public String getOptionBranchDetailName() {
        return optionBranchDetailName;
    }

    public void setOptionBranchDetailName(String optionBranchDetailName) {
        this.optionBranchDetailName = optionBranchDetailName == null ? null : optionBranchDetailName.trim();
    }

    public Integer getOptionBranchPrice() {
        return optionBranchPrice;
    }

    public void setOptionBranchPrice(Integer optionBranchPrice) {
        this.optionBranchPrice = optionBranchPrice;
    }

    public Integer getOptionBranchDoublePrice() {
        return optionBranchDoublePrice;
    }

    public void setOptionBranchDoublePrice(Integer optionBranchDoublePrice) {
        this.optionBranchDoublePrice = optionBranchDoublePrice;
    }

    public Short getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Short displayOrder) {
        this.displayOrder = displayOrder;
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