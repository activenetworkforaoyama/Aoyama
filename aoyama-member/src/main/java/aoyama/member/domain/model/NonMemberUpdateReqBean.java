package aoyama.member.domain.model;

public class NonMemberUpdateReqBean {
    
    // 既存項目（連携に必須の値）
    /** 顧客No */
    private long kokNo = 0;
    
    /** 業態 */
    private int gyotai = 1;
    /** 電話番号 */
    private String telNo = "";
    /** メールアドレス */
    private String email = "";
    /** 姓 */
    private String seiJ = "";
    /** 名 */
    private String meiJ = "";
    /** 姓（カナ） */
    private String sei = "";
    /** 名（カナ） */
    private String mei = "";
    /** 登録店舗コード */
    private int crtTenCd = 0;
    /** 登録社員コード */
    private int crtSyainNo = 0;
    /** 登録日付 */
    private String crtYmd = "";
    /** 登録時刻 */
    private String crtHms = "";
    /** 更新店舗コード */
    private int updTenCd = 0;
    /** 更新社員コード */
    private int updSyainNo = 0;
    /** 更新日付 */
    private String updYmd = "";
    /** 更新時刻 */
    private String updHms = "";
    
    
    // getter/setter
    public long getKokNo() {
        return kokNo;
    }
    public void setKokNo(long kokNo) {
        this.kokNo = kokNo;
    }
    public int getGyotai() {
        return gyotai;
    }
    public void setGyotai(int gyotai) {
        this.gyotai = gyotai;
    }
    public String getTelNo() {
        return telNo;
    }
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSeiJ() {
        return seiJ;
    }
    public void setSeiJ(String seiJ) {
        this.seiJ = seiJ;
    }
    public String getMeiJ() {
        return meiJ;
    }
    public void setMeiJ(String meiJ) {
        this.meiJ = meiJ;
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
    public int getCrtTenCd() {
        return crtTenCd;
    }
    public void setCrtTenCd(int crtTenCd) {
        this.crtTenCd = crtTenCd;
    }
    public int getCrtSyainNo() {
        return crtSyainNo;
    }
    public void setCrtSyainNo(int crtSyainNo) {
        this.crtSyainNo = crtSyainNo;
    }
    public String getCrtYmd() {
        return crtYmd;
    }
    public void setCrtYmd(String crtYmd) {
        this.crtYmd = crtYmd;
    }
    public String getCrtHms() {
        return crtHms;
    }
    public void setCrtHms(String crtHms) {
        this.updHms = crtHms;
    }
    public int getUpdTenCd() {
        return updTenCd;
    }
    public void setUpdTenCd(int updTenCd) {
        this.updTenCd = updTenCd;
    }
    public int getUpdSyainNo() {
        return updSyainNo;
    }
    public void setUpdSyainNo(int updSyainNo) {
        this.updSyainNo = updSyainNo;
    }
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
}
