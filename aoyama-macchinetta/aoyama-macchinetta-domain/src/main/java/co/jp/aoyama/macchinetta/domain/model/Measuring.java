package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Measuring implements Serializable {
	
	private static final long serialVersionUID = 4069252255712771419L;

	private String orderId;

    private BigDecimal fullLength;

    private BigDecimal shoulder;

    private BigDecimal reachRight;

    private BigDecimal reachLeft;

    private BigDecimal outBust;

    private BigDecimal bust;

    private BigDecimal jacketWaist;

    private BigDecimal pantsWaist;

    private BigDecimal hip;

    private BigDecimal spanRight;

    private BigDecimal spanLeft;

    private BigDecimal calfRight;

    private BigDecimal calfLeft;

    private BigDecimal neck;

    private String createdUserId;

    private Date createdAt;

    private String updatedUserId;

    private Date updatedAt;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public BigDecimal getFullLength() {
        return fullLength;
    }

    public void setFullLength(BigDecimal fullLength) {
        this.fullLength = fullLength;
    }

    public BigDecimal getShoulder() {
        return shoulder;
    }

    public void setShoulder(BigDecimal shoulder) {
        this.shoulder = shoulder;
    }

    public BigDecimal getReachRight() {
        return reachRight;
    }

    public void setReachRight(BigDecimal reachRight) {
        this.reachRight = reachRight;
    }

    public BigDecimal getReachLeft() {
        return reachLeft;
    }

    public void setReachLeft(BigDecimal reachLeft) {
        this.reachLeft = reachLeft;
    }

    public BigDecimal getOutBust() {
        return outBust;
    }

    public void setOutBust(BigDecimal outBust) {
        this.outBust = outBust;
    }

    public BigDecimal getBust() {
        return bust;
    }

    public void setBust(BigDecimal bust) {
        this.bust = bust;
    }

    public BigDecimal getJacketWaist() {
        return jacketWaist;
    }

    public void setJacketWaist(BigDecimal jacketWaist) {
        this.jacketWaist = jacketWaist;
    }

    public BigDecimal getPantsWaist() {
        return pantsWaist;
    }

    public void setPantsWaist(BigDecimal pantsWaist) {
        this.pantsWaist = pantsWaist;
    }

    public BigDecimal getHip() {
        return hip;
    }

    public void setHip(BigDecimal hip) {
        this.hip = hip;
    }

    public BigDecimal getSpanRight() {
        return spanRight;
    }

    public void setSpanRight(BigDecimal spanRight) {
        this.spanRight = spanRight;
    }

    public BigDecimal getSpanLeft() {
        return spanLeft;
    }

    public void setSpanLeft(BigDecimal spanLeft) {
        this.spanLeft = spanLeft;
    }

    public BigDecimal getCalfRight() {
        return calfRight;
    }

    public void setCalfRight(BigDecimal calfRight) {
        this.calfRight = calfRight;
    }

    public BigDecimal getCalfLeft() {
        return calfLeft;
    }

    public void setCalfLeft(BigDecimal calfLeft) {
        this.calfLeft = calfLeft;
    }

    public BigDecimal getNeck() {
        return neck;
    }

    public void setNeck(BigDecimal neck) {
        this.neck = neck;
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