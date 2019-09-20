package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;

public class MtbOptionEnum implements Serializable {
    private String type;

    private String code;

    private String getCode;

    private String optionType;

    private String optionCode;

    private String productFactoryCd;

    private String orderPattern;

    private static final long serialVersionUID = 1L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getGetCode() {
        return getCode;
    }

    public void setGetCode(String getCode) {
        this.getCode = getCode == null ? null : getCode.trim();
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType == null ? null : optionType.trim();
    }

    public String getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(String optionCode) {
        this.optionCode = optionCode == null ? null : optionCode.trim();
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