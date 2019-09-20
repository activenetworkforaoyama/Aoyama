package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;

public class MtbErrorContent implements Serializable {
    private String errCode;

    private String remark;

    private String productFactoryCd;

    private String orderPattern;

    private static final long serialVersionUID = 1L;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode == null ? null : errCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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