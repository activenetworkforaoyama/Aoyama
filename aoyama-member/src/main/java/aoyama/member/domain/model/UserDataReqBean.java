package aoyama.member.domain.model;

/**
 * 顧客情報参照リクエストBean
 */
public class UserDataReqBean {
    /** 顧客No. */
    private long kokNo = 0;
    /** 電話番号 */
    private String telNo = "";

    public long getKokNo() {
        return kokNo;
    }
    public void setKokNo(long kokNo) {
        this.kokNo = kokNo;
    }
    public String getTelNo() {
        return telNo;
    }
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
}