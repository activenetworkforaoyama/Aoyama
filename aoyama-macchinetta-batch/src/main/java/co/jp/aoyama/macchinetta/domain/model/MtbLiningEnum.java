package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;

public class MtbLiningEnum implements Serializable {
    private String jkInnerBodyClothCd;

    private String sku;

    private String mode;

    private String vendor;

    private String description;

    private String composition;

    private String length;

    private String productFactoryCd;

    private String orderPattern;

    private static final long serialVersionUID = 1L;

    public String getJkInnerBodyClothCd() {
        return jkInnerBodyClothCd;
    }

    public void setJkInnerBodyClothCd(String jkInnerBodyClothCd) {
        this.jkInnerBodyClothCd = jkInnerBodyClothCd == null ? null : jkInnerBodyClothCd.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor == null ? null : vendor.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition == null ? null : composition.trim();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public String getProductFactoryCd() {
        return productFactoryCd;
    }

    public void setProductFactoryCd(String productFactoryCd) {
        this.productFactoryCd = productFactoryCd == null ? null : productFactoryCd.trim();
    }

    public String getOrderPattern() {
        return orderPattern;
    }

    public void setOrderPattern(String orderPattern) {
        this.orderPattern = orderPattern == null ? null : orderPattern.trim();
    }
}