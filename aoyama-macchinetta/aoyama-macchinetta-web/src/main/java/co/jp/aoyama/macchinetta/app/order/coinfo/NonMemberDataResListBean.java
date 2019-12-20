package co.jp.aoyama.macchinetta.app.order.coinfo;

/**
 * 非会員情報参照レスポンスBean
 */
public class NonMemberDataResListBean {
    /** 顧客No. */
    private long kokno = 0;
    /** 業態 */
    private int gyotai = 0;
    /** 電話番号 */
    private String telno = null;
    /** メールアドレス */
    private String email = null;
    /** 姓 */
    private String seij = null;
    /** 名 */
    private String meij = null;
    /** 姓（カナ） */
    private String sei = null;
    /** 名（カナ） */
    private String mei = null;
    /** 登録店舗コード */
    private int crttencd = 0;
    /** 登録社員№ */
    private int crtsyainno = 0;
    /** 登録日付 */
    private String crtymd = null;
    /** 登録時刻 */
    private String crthms = null;
    /** 更新店舗コード */
    private int updtencd = 0;
    /** 更新社員№ */
    private int updsyainno = 0;
    /** 更新日付 */
    private String updymd = null;
    /** 更新時刻 */
    private String updhms = null;

    public long getKokno() {
        return kokno;
    }
    public void setKokno(long kokno) {
        this.kokno = kokno;
    }
    public int getGyotai() {
        return gyotai;
    }
    public void setGyotai(int gyotai) {
        this.gyotai = gyotai;
    }
    public String getTelno() {
        return telno;
    }
    public void setTelno(String telno) {
        this.telno = telno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
	public String getSeij() {
        return seij;
    }
    public void setSeij(String seij) {
        this.seij = seij;
    }
    public String getMeij() {
        return meij;
    }
    public void setMeij(String meij) {
        this.meij = meij;
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
    public int getCrttencd() {
        return crttencd;
    }
    public void setCrttencd(int crttencd) {
        this.crttencd = crttencd;
    }
    public int getCrtsyainno() {
        return crtsyainno;
    }
    public void setCrtsyainno(int crtsyainno) {
        this.crtsyainno = crtsyainno;
    }
    public String getCrtymd() {
        return crtymd;
    }
    public void setCrtymd(String crtymd) {
        this.crtymd = crtymd;
    }
    public String getCrthms() {
        return crthms;
    }
    public void setCrthms(String crthms) {
        this.crthms = crthms;
    }
    public int getUpdtencd() {
        return updtencd;
    }
    public void setUpdtencd(int updtencd) {
        this.updtencd = updtencd;
    }
    public int getUpdsyainno() {
        return updsyainno;
    }
    public void setUpdsyainno(int updsyainno) {
        this.updsyainno = updsyainno;
    }
    public String getUpdymd() {
        return updymd;
    }
    public void setUpdymd(String updymd) {
        this.updymd = updymd;
    }
    public String getUpdhms() {
        return updhms;
    }
    public void setUpdhms(String updhms) {
        this.updhms = updhms;
    }
    
	@Override
	public String toString() {
		return "NonMemberDataResListBean [kokno=" + kokno + ", gyotai=" + gyotai + ", telno=" + telno + ", email="
				+ email + ", seij=" + seij + ", meij=" + meij + ", sei=" + sei + ", mei=" + mei + ", crttencd="
				+ crttencd + ", crtsyainno=" + crtsyainno + ", crtymd=" + crtymd + ", crthms=" + crthms + ", updtencd="
				+ updtencd + ", updsyainno=" + updsyainno + ", updymd=" + updymd + ", updhms=" + updhms + "]";
	}
    
}
