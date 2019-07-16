package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Yield implements Serializable {
	
	private static final long serialVersionUID = -3135094602433074906L;

	private String subItemCode;

    private Short nomalFabricAmount;

    private Short doubleBreastedFabricAmount;

    private String createdUserId;

    private Date createdAt;

    private String updatedUserId;

    private Date updatedAt;

    public String getSubItemCode() {
        return subItemCode;
    }

    public void setSubItemCode(String subItemCode) {
        this.subItemCode = subItemCode == null ? null : subItemCode.trim();
    }

    public Short getNomalFabricAmount() {
        return nomalFabricAmount;
    }

    public void setNomalFabricAmount(Short nomalFabricAmount) {
        this.nomalFabricAmount = nomalFabricAmount;
    }

    public Short getDoubleBreastedFabricAmount() {
        return doubleBreastedFabricAmount;
    }

    public void setDoubleBreastedFabricAmount(Short doubleBreastedFabricAmount) {
        this.doubleBreastedFabricAmount = doubleBreastedFabricAmount;
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