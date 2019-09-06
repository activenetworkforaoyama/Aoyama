package aoyama.member.domain.model;

public class KarteUpdateReqBean {
    
    // メジャーリングの追加項目
    /** 業態 */
    private int gyotaiCd = 0;
    /** 顧客No */
    private long kokNo = 0;
    /** サイズ01 （フルレングス）*/
    private double size01 = 0;
    /** サイズ02 （ショルダー）*/
    private double size02 = 0;
    /** サイズ03 （リーチ（右））*/
    private double size03 = 0;
    /** サイズ04 （リーチ（左））*/
    private double size04 = 0;
    /** サイズ05 （アウトバスト）*/
    private double size05 = 0;
    /** サイズ06 （バスト）*/
    private double size06 = 0;
    /** サイズ07 （JKウエスト）*/
    private double size07 = 0;
    /** サイズ08 （PTウエスト）*/
    private double size08 = 0;
    /** サイズ09 （ヒップ）*/
    private double size09 = 0;
    /** サイズ10 （ワタリ（右））*/
    private double size10 = 0;
    /** サイズ11 （ワタリ（左））*/
    private double size11 = 0;
    /** サイズ12 （ふくらはぎ（右））*/
    private double size12 = 0;
    /** サイズ13 （ふくらはぎ（左））*/
    private double size13 = 0;
    /** サイズ14 （ネック）*/
    private double size14 = 0;
    /** サイズ15 */
    private double size15 = 0;
    /** サイズ16 */
    private double size16 = 0;
    /** サイズ17 */
    private double size17 = 0;
    /** サイズ18 */
    private double size18 = 0;
    /** サイズ19 */
    private double size19 = 0;
    /** サイズ20 */
    private double size20 = 0;
    /** サイズ更新日時 */
    private String sizeUpdYmd = "";
    /** 備考 */
    private String biko01 = "";
    /** 備考 */
    private String biko02 = "";
    /** 備考 */
    private String biko03 = "";
    /** 更新店舗コード */
    private int updTenCd = 0;
    /** 更新社員コード */
    private int updSyainNo = 0;
    /** 更新日付 */
    private String updYmd = "";
    /** 更新時刻 */
    private String updHms = "";
    
    
    // getter/setter
    public int getGyotaiCd() {
        return gyotaiCd;
    }
    public void setGyotaiCd(int gyotaiCd) {
        this.gyotaiCd = gyotaiCd;
    }
    public long getKokNo() {
        return kokNo;
    }
    public void setKokNo(long kokNo) {
        this.kokNo = kokNo;
    }
    public double getSize01() {
        return size01;
    }
    public void setSize01(double size01) {
        this.size01 = size01;
    }
    public double getSize02() {
        return size02;
    }
    public void setSize02(double size02) {
        this.size02 = size02;
    }
    public double getSize03() {
        return size03;
    }
    public void setSize03(double size03) {
        this.size03 = size03;
    }
    public double getSize04() {
        return size04;
    }
    public void setSize04(double size04) {
        this.size04 = size04;
    }
    public double getSize05() {
        return size05;
    }
    public void setSize05(double size05) {
        this.size05 = size05;
    }
    public double getSize06() {
        return size06;
    }
    public void setSize06(double size06) {
        this.size06 = size06;
    }
    public double getSize07() {
        return size07;
    }
    public void setSize07(double size07) {
        this.size07 = size07;
    }
    public double getSize08() {
        return size08;
    }
    public void setSize08(double size08) {
        this.size08 = size08;
    }
    public double getSize09() {
        return size09;
    }
    public void setSize09(double size09) {
        this.size09 = size09;
    }
    public double getSize10() {
        return size10;
    }
    public void setSize10(double size10) {
        this.size10 = size10;
    }
    public double getSize11() {
        return size11;
    }
    public void setSize11(double size11) {
        this.size11 = size11;
    }
    public double getSize12() {
        return size12;
    }
    public void setSize12(double size12) {
        this.size12 = size12;
    }
    public double getSize13() {
        return size13;
    }
    public void setSize13(double size13) {
        this.size13 = size13;
    }
    public double getSize14() {
        return size14;
    }
    public void setSize14(double size14) {
        this.size14 = size14;
    }
    public double getSize15() {
        return size15;
    }
    public void setSize15(double size15) {
        this.size15 = size15;
    }
    public double getSize16() {
        return size16;
    }
    public void setSize16(double size16) {
        this.size16 = size16;
    }
    public double getSize17() {
        return size17;
    }
    public void setSize17(double size17) {
        this.size17 = size17;
    }
    public double getSize18() {
        return size18;
    }
    public void setSize18(double size18) {
        this.size18 = size18;
    }
    public double getSize19() {
        return size19;
    }
    public void setSize19(double size19) {
        this.size19 = size19;
    }
    public double getSize20() {
        return size20;
    }
    public void setSize20(double size20) {
        this.size20 = size20;
    }
    public String getSizeUpdYmd() {
        return sizeUpdYmd;
    }
    public void setSizeUpdYmd(String sizeUpdYmd) {
        this.sizeUpdYmd = sizeUpdYmd;
    }
    public String getBiko01() {
        return biko01;
    }
    public void setBiko01(String biko01) {
        this.biko01 = biko01;
    }
    public String getBiko02() {
        return biko02;
    }
    public void setBiko02(String biko02) {
        this.biko02 = biko02;
    }
    public String getBiko03() {
        return biko03;
    }
    public void setBiko03(String biko03) {
        this.biko03 = biko03;
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
