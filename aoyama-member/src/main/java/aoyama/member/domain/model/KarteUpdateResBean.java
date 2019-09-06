package aoyama.member.domain.model;

public class KarteUpdateResBean {
    
    /** 顧客No */
    private long kokNo = 0;
    /** 更新日 */
    private String updYmd = "";
    /** 更新時刻 */
    private String updHms = "";

    public String getUpdYmd() {
        return updYmd;
    }
    public void setUpdYmd(String updYmd) {
        this.updYmd = updYmd;
    }
    public String getUpdHms() {
        return updHms;
    }
    public void setUpdHms(String updHms) {
        this.updHms = updHms;
    }
    public long getKokNo() {
        return kokNo;
    }
    public void setKokNo(long kokNo) {
        this.kokNo = kokNo;
    }
}
