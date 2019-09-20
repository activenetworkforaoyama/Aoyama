package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;

public class MtbErrShanghaiFuliang implements Serializable {
    private String errCode;

    private String remark;

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
}