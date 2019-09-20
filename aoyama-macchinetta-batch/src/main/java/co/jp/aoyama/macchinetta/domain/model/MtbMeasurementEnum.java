package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;

public class MtbMeasurementEnum implements Serializable {
    private String item;

    private String styleNo;

    private String subNo;

    private String classType;

    private String itemCode;

    private String getGross;

    private String productFactoryCd;

    private String orderPattern;

    private static final long serialVersionUID = 1L;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public String getStyleNo() {
        return styleNo;
    }

    public void setStyleNo(String styleNo) {
        this.styleNo = styleNo == null ? null : styleNo.trim();
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo == null ? null : subNo.trim();
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType == null ? null : classType.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getGetGross() {
        return getGross;
    }

    public void setGetGross(String getGross) {
        this.getGross = getGross == null ? null : getGross.trim();
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