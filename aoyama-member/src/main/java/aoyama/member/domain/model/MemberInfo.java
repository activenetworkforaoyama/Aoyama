package aoyama.member.domain.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class MemberInfo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    // 名前 姓
    private String lastName;
    
    // 名前 名
    private String firstName;
    
    // フリガナ セイ
    private String lastNameKana;
    
    // フリガナ メイ
    private String firstNameKana;
    
    // メンバーズID
    private String membersId;
    
    // カード種別
    private String cardType;
    
    // 郵便番号
    private String zipCode;
    
    // 都道府県
    private String prefectures;
    
    // 市区町村
    private String city;
    
    // 生年月日 年
    private String birthYear;
    
    // 生年月日 月
    private String birthMonth;
    
    // 生年月日 日
    private String birthDate;
    
    // ポイント
    private int ownedPoints;
    
    // 年度末失効ポイント
    private int losePoints;
    
    // 商品情報メールマガジン
    private String[] itemMailMagazine;
    
    // 店舗情報メールマガジン
    private String[] storeMailMagazine;
    
    // 青山業態メールマガジン
    private String[] businessTypeMailMagazine;
    
    // スマホアプリ登録
    private String appRegistration;
    
    // メジャーリング 最終更新日
    private String measuringLatestDm;
    
    // メジャーリング フルレングス
    private String measuringFullLength;
    
    // メジャーリング ショルダー
    private String measuringShoulder;
    
    // メジャーリング PTウエスト
    private String measuringPtWeist;
    
    // メジャーリング アウトバスト
    private String measuringOutBust;
    
    // メジャーリング リーチ左
    private String measuringReachLeft;
    
    // メジャーリング リーチ右
    private String measuringReachRight;
    
    // メジャーリング ヒップ
    private String measuringHip;
    
    // メジャーリング バスト
    private String measuringBust;
    
    // メジャーリング JKウエスト
    private String measuringJkWeist;
    
    // メジャーリング ネック
    private String measuringNeck;
    
    // メジャーリング 腿幅（右）
    private String measuringThighWidthRight;
    
    // メジャーリング 腿幅（左）
    private String measuringThighWidthLeft;

    // メジャーリング ふくらはぎ（右）
    private String measuringCalfWidthRight;
    
    // メジャーリング ふくらはぎ（左）
    private String measuringCalfWidthLeft;

    // 職業
    private String job;
    
    // 業種
    private String industry;
    
    // 職種
    private String jobCategory;
    
    // 役職
    private String position;
    
    // 最寄駅
    @Size(max=30)
    private String nearestStation;
    
    // 既婚/未婚
    private String marriageFlg;
    
    // 子供の人数
    private String children;
    
    // 自社EC利用状況
    private String ecUsage;
    
    // 他社利用状況
    private String[] otherUsage;
    
    // オーダー経験
    private String[] orderExp;
    
    // 素材・生地の好み
    @Size(max=100)
    private String clothPre;
    
    // 補正情報・着用の好み
    @Size(max=100)
    private String correctionInfo;
    
    // 趣味・嗜好
    private String[] hobby;
    
    // 備考
    @Size(max=200)
    private String note;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public void setLastNameKana(String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public String getFirstNameKana() {
        return firstNameKana;
    }

    public void setFirstNameKana(String firstNameKana) {
        this.firstNameKana = firstNameKana;
    }

    public String getMembersId() {
        return membersId;
    }

    public void setMembersId(String membersId) {
        this.membersId = membersId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPrefectures() {
        return prefectures;
    }

    public void setPrefectures(String prefectures) {
        this.prefectures = prefectures;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOwnedPoints() {
        return ownedPoints;
    }

    public void setOwnedPoints(int ownedPoints) {
        this.ownedPoints = ownedPoints;
    }

    public int getLosePoints() {
        return losePoints;
    }

    public void setLosePoints(int losePoints) {
        this.losePoints = losePoints;
    }

    public String[] getItemMailMagazine() {
        return itemMailMagazine;
    }

    public void setItemMailMagazine(String[] itemMailMagazine) {
        this.itemMailMagazine = itemMailMagazine;
    }

    public String[] getStoreMailMagazine() {
        return storeMailMagazine;
    }

    public void setStoreMailMagazine(String[] storeMailMagazine) {
        this.storeMailMagazine = storeMailMagazine;
    }

    public String[] getBusinessTypeMailMagazine() {
        return businessTypeMailMagazine;
    }

    public void setBusinessTypeMailMagazine(String[] businessTypeMailMagazine) {
        this.businessTypeMailMagazine = businessTypeMailMagazine;
    }

    public String getAppRegistration() {
        return appRegistration;
    }

    public void setAppRegistration(String appRegistration) {
        this.appRegistration = appRegistration;
    }

    public String getMeasuringLatestDm() {
        return measuringLatestDm;
    }

    public void setMeasuringLatestDm(String measuringLatestDm) {
        this.measuringLatestDm = measuringLatestDm;
    }

    public String getMeasuringFullLength() {
        return measuringFullLength;
    }

    public void setMeasuringFullLength(String measuringFullLength) {
        this.measuringFullLength = measuringFullLength;
    }

    public String getMeasuringShoulder() {
        return measuringShoulder;
    }

    public void setMeasuringShoulder(String measuringShoulder) {
        this.measuringShoulder = measuringShoulder;
    }

    public String getMeasuringPtWeist() {
        return measuringPtWeist;
    }

    public void setMeasuringPtWeist(String measuringPtWeist) {
        this.measuringPtWeist = measuringPtWeist;
    }

    public String getMeasuringOutBust() {
        return measuringOutBust;
    }

    public void setMeasuringOutBust(String measuringOutBust) {
        this.measuringOutBust = measuringOutBust;
    }

    public String getMeasuringReachLeft() {
        return measuringReachLeft;
    }

    public void setMeasuringReachLeft(String measuringReachLeft) {
        this.measuringReachLeft = measuringReachLeft;
    }
    
    public String getMeasuringThighWidthRight() {
        return measuringThighWidthRight;
    }

    public void setMeasuringThighWidthRight(String measuringThighWidthRight) {
        this.measuringThighWidthRight = measuringThighWidthRight;
    }
    
    public String getMeasuringThighWidthLeft() {
        return measuringThighWidthLeft;
    }

    public void setMeasuringThighWidthLeft(String measuringThighWidthLeft) {
        this.measuringThighWidthLeft = measuringThighWidthLeft;
    }
    
    public String getMeasuringCalfWidthRight() {
        return measuringCalfWidthRight;
    }

    public void setMeasuringCalfWidthRight(String measuringCalfWidthRight) {
        this.measuringCalfWidthRight = measuringCalfWidthRight;
    }
    
    public String getMeasuringCalfWidthLeft() {
        return measuringCalfWidthLeft;
    }

    public void setMeasuringCalfWidthLeft(String measuringCalfWidthLeft) {
        this.measuringCalfWidthLeft = measuringCalfWidthLeft;
    }
    
    public String getMeasuringReachRight() {
        return measuringReachRight;
    }

    public void setMeasuringReachRight(String measuringReachRight) {
        this.measuringReachRight = measuringReachRight;
    }

    public String getMeasuringHip() {
        return measuringHip;
    }

    public void setMeasuringHip(String measuringHip) {
        this.measuringHip = measuringHip;
    }

    public String getMeasuringBust() {
        return measuringBust;
    }

    public void setMeasuringBust(String measuringBust) {
        this.measuringBust = measuringBust;
    }

    public String getMeasuringJkWeist() {
        return measuringJkWeist;
    }

    public void setMeasuringJkWeist(String measuringJkWeist) {
        this.measuringJkWeist = measuringJkWeist;
    }

    public String getMeasuringNeck() {
        return measuringNeck;
    }

    public void setMeasuringNeck(String measuringNeck) {
        this.measuringNeck = measuringNeck;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(String nearestStation) {
        this.nearestStation = nearestStation;
    }

    public String getMarriageFlg() {
        return marriageFlg;
    }

    public void setMarriageFlg(String marriageFlg) {
        this.marriageFlg = marriageFlg;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getEcUsage() {
        return ecUsage;
    }

    public void setEcUsage(String ecUsage) {
        this.ecUsage = ecUsage;
    }

    public String[] getOtherUsage() {
        return otherUsage;
    }

    public void setOtherUsage(String[] otherUsage) {
        this.otherUsage = otherUsage;
    }

    public String[] getOrderExp() {
        return orderExp;
    }

    public void setOrderExp(String[] orderExp) {
        this.orderExp = orderExp;
    }

    public String getClothPre() {
        return clothPre;
    }

    public void setClothPre(String clothPre) {
        this.clothPre = clothPre;
    }

    public String getCorrectionInfo() {
        return correctionInfo;
    }

    public void setCorrectionInfo(String correctionInfo) {
        this.correctionInfo = correctionInfo;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    /**
     * 受け取った生年月日を表示用に年/月/日に分けて格納する
     * @param birthday
     */
    public void setBirthDay(String birthday) {
        
        if (birthday == null || "".equals(birthday)) {
            return;
        }
        
        // 年
        setBirthYear(birthday.substring(0, 4));
        // 月
        setBirthMonth(birthday.substring(4, 6));
        // 日
        setBirthDate(birthday.substring(6, 8));
    }
}
