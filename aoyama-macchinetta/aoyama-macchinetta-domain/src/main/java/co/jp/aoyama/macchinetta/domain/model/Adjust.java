package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Adjust implements Serializable {
	private static final long serialVersionUID = 2217633469451001521L;

	private String orderPattern;

    private String itemCode;

    private String subItemCode;

    private String adjusteClass;

    private BigDecimal adjusteMax;

    private BigDecimal adjusteMin;

    private String description;

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getSubItemCode() {
        return subItemCode;
    }

    public void setSubItemCode(String subItemCode) {
        this.subItemCode = subItemCode == null ? null : subItemCode.trim();
    }

    public String getAdjusteClass() {
        return adjusteClass;
    }

    public void setAdjusteClass(String adjusteClass) {
        this.adjusteClass = adjusteClass == null ? null : adjusteClass.trim();
    }

    public BigDecimal getAdjusteMax() {
        return adjusteMax;
    }

    public void setAdjusteMax(BigDecimal adjusteMax) {
        this.adjusteMax = adjusteMax;
    }

    public BigDecimal getAdjusteMin() {
        return adjusteMin;
    }

    public void setAdjusteMin(BigDecimal adjusteMin) {
        this.adjusteMin = adjusteMin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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