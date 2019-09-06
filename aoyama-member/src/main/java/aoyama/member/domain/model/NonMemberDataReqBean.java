package aoyama.member.domain.model;

/**
 * 非会員情報参照リクエストBean
 */
public class NonMemberDataReqBean {
    /** 業態 */
    private int gyotai = 1;
    /** 顧客No. */
    private long kokNo = 0;
    /** 電話番号 */
    private String telNo = "";
    /** 姓（カナ） */
    private String sei = "";
    /** 名（カナ） */
    private String mei = "";

    public int getGyotai() {
        return gyotai;
    }
    public void setGyotai(int gyotai) {
        this.gyotai = gyotai;
    }
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
    public String getSei() {
        return sei;
    }
    public void setSei(String sei) {
        this.sei = sei;
    }
    public String getMei() {
        return mei;
    }
    public void setMei(String mei) {
        this.mei = mei;
    }
}