package aoyama.member.domain.model;

import java.util.Map;

/**
 * 顧客情報参照レスポンスBean
 */
public class UserDataResBean {
    /** 顧客No. */
    private long kokno = 0;
    /** 姓 */
    private String seij = null;
    /** 名 */
    private String meij = null;
    /** 住所１ */
    private String addr1 =null;
    /** 住所２ */
    private String addr2 = null;
    /** 電話番号 */
    private String telno = null;
    /** 生年月日 */
    private String birthday = null;
    /** 姓（カナ） */
    private String sei = null;
    /** 名（カナ） */
    private String mei = null;
    /** 郵便番号 */
    private String yubinno = null;
    /** 性別 */
    private String seibetu = null;
    /** カード種別 */
    private int cardsyu = 0;
    /** 年制 */
    private int nensei = 0;
    /** 年月 */
    private int nengetu = 0;
    /** DM停止区分 */
    private int dmstpkbn = 0;
    /** DM停止理由 */
    private int dmstpriyu = 0;
    /** 生協コード */
    private int seikyocd = 0;
    /** 入会店コード */
    private int nyumisecd = 0;
    /** 最終買上店舗コード１ */
    private int lastkaitencd1 = 0;
    /** 入会日 */
    private String nyudate = null;
    /** 最終買上日 */
    private String lstkaiymd = null;
    /** 業態 */
    private int gyotai = 0;
    /** 退会日 */
    private String dakaiymd = null;
    /** 状態区分 */
    private String jyotaiikbn = null;
    /** 更新日付 */
    private String updymd = null;
    /** 更新時刻 */
    private String updhms = null;
    /** 累計ポイント(マスタ) */
    private int ruikpoint_mst = 0;
    /** 消滅年度　年度別残ポイント */
    private int nen_zan_p4 = 0;
    /** PCメールアドレス */
    private String pcmail = null;
    /** PCメールマガジン配信区分 */
    private int pcmailflg = 0;
    /** 携帯メールアドレス */
    private String mobilemail = null;
    /** 携帯メールマガジン配信区分 */
    private int mobilemailflg = 0;
    /** 携帯メールマガジン配信停止区分 */
    private int mobilemailstopflg = 0;
    /** 携帯メールマガジン配信停止日 */
    private String mobilemailstopdate = null;
    /** 通知メール配信区分 */
    private int infomailflg = 0;
    /** WEB顧客ID（TSC）*/
    private String webkokId = null;
    /** WEB顧客パスワード（TSC） */
    private String webkokpass = null;
    /** WEB登録区分 */
    private int webkbn = 0;
    /** WEB登録日 */
    private String webtourokuymd = null;
    /** WEB登録時刻 */
    private String webtourokuhms = null;
    /** PCメールマガジン詳細区分 */
    private String pcmailkbn = null;
    /** 携帯メールマガジン詳細区分 */
    private String mobilmailkbn = null;
    /** QCMA区分 */
    private int qcmaKbn = 0;
    /** WEB退会日 */
    private String webdakaiymd = null;
    /** WEB退会時刻 */
    private String webdakaihms = null;
    /** ECサイトで使われる項目 */
    private Map<String, String> kokInfo = null;
    /** ユーザが変更可能な項目 */
    private Map<String, String> dataInfo = null;

    public long getKokno() {
        return kokno;
    }
    public void setKokno(long kokno) {
        this.kokno = kokno;
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
    public String getAddr1() {
        return addr1;
    }
    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }
    public String getAddr2() {
        return addr2;
    }
    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }
    public String getTelno() {
        return telno;
    }
    public void setTelno(String telno) {
        this.telno = telno;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
    public String getYubinno() {
        return yubinno;
    }
    public void setYubinno(String yubinno) {
        this.yubinno = yubinno;
    }
    public String getSeibetu() {
        return seibetu;
    }
    public void setSeibetu(String seibetu) {
        this.seibetu = seibetu;
    }
    public int getCardsyu() {
        return cardsyu;
    }
    public void setCardsyu(int cardsyu) {
        this.cardsyu = cardsyu;
    }
    public int getNensei() {
        return nensei;
    }
    public void setNensei(int nensei) {
        this.nensei = nensei;
    }
    public int getNengetu() {
        return nengetu;
    }
    public void setNengetu(int nengetu) {
        this.nengetu = nengetu;
    }
    public int getDmstpkbn() {
        return dmstpkbn;
    }
    public void setDmstpkbn(int dmstpkbn) {
        this.dmstpkbn = dmstpkbn;
    }
    public int getDmstpriyu() {
        return dmstpriyu;
    }
    public void setDmstpriyu(int dmstpriyu) {
        this.dmstpriyu = dmstpriyu;
    }
    public int getSeikyocd() {
        return seikyocd;
    }
    public void setSeikyocd(int seikyocd) {
        this.seikyocd = seikyocd;
    }
    public int getNyumisecd() {
        return nyumisecd;
    }
    public void setNyumisecd(int nyumisecd) {
        this.nyumisecd = nyumisecd;
    }
    public int getLastkaitencd1() {
        return lastkaitencd1;
    }
    public void setLastkaitencd1(int lastkaitencd1) {
        this.lastkaitencd1 = lastkaitencd1;
    }
    public String getNyudate() {
        return nyudate;
    }
    public void setNyudate(String nyudate) {
        this.nyudate = nyudate;
    }
    public String getLstkaiymd() {
        return lstkaiymd;
    }
    public void setLstkaiymd(String lstkaiymd) {
        this.lstkaiymd = lstkaiymd;
    }
    public int getGyotai() {
        return gyotai;
    }
    public void setGyotai(int gyotai) {
        this.gyotai = gyotai;
    }
    public String getDakaiymd() {
        return dakaiymd;
    }
    public void setDakaiymd(String dakaiymd) {
        this.dakaiymd = dakaiymd;
    }
    public String getJyotaiikbn() {
        return jyotaiikbn;
    }
    public void setJyotaiikbn(String jyotaiikbn) {
        this.jyotaiikbn = jyotaiikbn;
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
    public int getRuikpoint_mst() {
        return ruikpoint_mst;
    }
    public void setRuikpoint_mst(int ruikpoint_mst) {
        this.ruikpoint_mst = ruikpoint_mst;
    }
    public int getNen_zan_p4() {
        return nen_zan_p4;
    }
    public void setNen_zan_p4(int nen_zan_p4) {
        this.nen_zan_p4 = nen_zan_p4;
    }
    public String getPcmail() {
        return pcmail;
    }
    public void setPcmail(String pcmail) {
        this.pcmail = pcmail;
    }
    public int getPcmailflg() {
        return pcmailflg;
    }
    public void setPcmailflg(int pcmailflg) {
        this.pcmailflg = pcmailflg;
    }
    public String getMobilemail() {
        return mobilemail;
    }
    public void setMobilemail(String mobilemail) {
        this.mobilemail = mobilemail;
    }
    public int getMobilemailflg() {
        return mobilemailflg;
    }
    public void setMobilemailflg(int mobilemailflg) {
        this.mobilemailflg = mobilemailflg;
    }
    public int getMobilemailstopflg() {
        return mobilemailstopflg;
    }
    public void setMobilemailstopflg(int mobilemailstopflg) {
        this.mobilemailstopflg = mobilemailstopflg;
    }
    public String getMobilemailstopdate() {
        return mobilemailstopdate;
    }
    public void setMobilemailstopdate(String mobilemailstopdate) {
        this.mobilemailstopdate = mobilemailstopdate;
    }
    public int getInfomailflg() {
        return infomailflg;
    }
    public void setInfomailflg(int infomailflg) {
        this.infomailflg = infomailflg;
    }
    public String getWebkokId() {
        return webkokId;
    }
    public void setWebkokId(String webkokId) {
        this.webkokId = webkokId;
    }
    public String getWebkokpass() {
        return webkokpass;
    }
    public void setWebkokpass(String webkokpass) {
        this.webkokpass = webkokpass;
    }
    public int getWebkbn() {
        return webkbn;
    }
    public void setWebkbn(int webkbn) {
        this.webkbn = webkbn;
    }
    public String getWebtourokuymd() {
        return webtourokuymd;
    }
    public void setWebtourokuymd(String webtourokuymd) {
        this.webtourokuymd = webtourokuymd;
    }
    public String getWebtourokuhms() {
        return webtourokuhms;
    }
    public void setWebtourokuhms(String webtourokuhms) {
        this.webtourokuhms = webtourokuhms;
    }
    public String getPcmailkbn() {
        return pcmailkbn;
    }
    public void setPcmailkbn(String pcmailkbn) {
        this.pcmailkbn = pcmailkbn;
    }
    public String getMobilmailkbn() {
        return mobilmailkbn;
    }
    public void setMobilmailkbn(String mobilmailkbn) {
        this.mobilmailkbn = mobilmailkbn;
    }
    public int getQcmaKbn() {
        return qcmaKbn;
    }
    public void setQcmaKbn(int qcmaKbn) {
        this.qcmaKbn = qcmaKbn;
    }
    public String getWebdakaiymd() {
        return webdakaiymd;
    }
    public void setWebdakaiymd(String webdakaiymd) {
        this.webdakaiymd = webdakaiymd;
    }
    public String getWebdakaihms() {
        return webdakaihms;
    }
    public void setWebdakaihms(String webdakaihms) {
        this.webdakaihms = webdakaihms;
    }
    /**
     * ECサイトで使われる項目を取得します。
     * @return kokInfo ECサイトで使われる項目
     */
    public Map<String, String> getKokInfo() {
        return kokInfo;
    }
    /**
     * ECサイトで使われる項目をセットします。
     * @param kokInfo ECサイトで使われる項目
     */
    public void setKokInfo(Map<String, String> kokInfo) {
        this.kokInfo = kokInfo;
    }
    /**
     * ユーザが変更可能な項目を取得します。
     * @return dataInfo ユーザが変更可能な項目
     */
    public Map<String, String> getDataInfo() {
        return dataInfo;
    }
    /**
     * ユーザが変更可能な項目をセットします。
     * @param dataInfo ユーザが変更可能な項目
     */
    public void setDataInfo(Map<String, String> dataInfo) {
        this.dataInfo = dataInfo;
    }
    /** 既存会員のメールアドレス状況 */
    private String isMailAddrStat = null;
    /**
     * 既存会員のメールアドレス登録状況を取得します。
     */
    public String getIsMailAddrStat() {
        return isMailAddrStat;
    }
    /**
     * 既存会員のメールアドレス登録状況をセットします。
     * @param isMailAddrStat 既存会員のメールアドレス登録状況
     */
    public void setIsMailAddrStat(String isMailAddrStat) {
        this.isMailAddrStat = isMailAddrStat;
    }
}
