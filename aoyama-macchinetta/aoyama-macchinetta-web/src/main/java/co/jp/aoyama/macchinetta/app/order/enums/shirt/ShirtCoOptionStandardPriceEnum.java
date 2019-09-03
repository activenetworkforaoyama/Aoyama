package co.jp.aoyama.macchinetta.app.order.enums.shirt;

public enum ShirtCoOptionStandardPriceEnum {

	// OptionForm
	// Key:OptionSHIRTStandardInfo option_code
	// Value:OptionSHIRTStandardInfo method
	// Value:OptionSHIRTStandardInfo method
	// Value:order method
	
	SHIRT_STANDARD_OPTION_CODE01("00001","getOsChainModel","","setStCollarTypeRtPrice"),//襟型
	SHIRT_STANDARD_OPTION_CODE02("00002","getOsCuffs","","setStCuffsRtPrice"),//カフス
	SHIRT_STANDARD_OPTION_CODE03("00003","getOsConvertible","","setStConvertibleRtPrice"),//コンバーチブル
	SHIRT_STANDARD_OPTION_CODE04("00004","getOsAdjustBtn","","setStAdjusterBtnRtPrice"),//アジャスト釦
	SHIRT_STANDARD_OPTION_CODE05("00005","getOsClericSpec","","setStClericRtPrice"),//クレリック仕様
	SHIRT_STANDARD_OPTION_CODE06("00006","getOsDblCuff","","setStDblCuffsRtPrice"),//ダブルカフス仕様
	SHIRT_STANDARD_OPTION_CODE07("00007","getOsAddCuff","","setStCuffsBtnRtPrice"),//カフスボタン追加
	SHIRT_STANDARD_OPTION_CODE08("00008","getOsBtnMate","","setStBtnMaterialRtPrice"),//釦素材
	SHIRT_STANDARD_OPTION_CODE09("00009","getOsTabBtn","","setStDblBtnRtPrice"),//タブ釦
	SHIRT_STANDARD_OPTION_CODE10("00010","getOsGaletteBtnPos","","setStGauntletBtnPosRtPrice"),//ガントレットボタン位置
	SHIRT_STANDARD_OPTION_CODE11("00011","getOsPinHolePin","","setStPinholePinRtPrice"),//ピンホールピン
	SHIRT_STANDARD_OPTION_CODE12("00012","getOsBreastPk","","setStBreastPktRtPrice"),//胸ポケット
	SHIRT_STANDARD_OPTION_CODE13("00013","getOsBreastPkSize","","setStBreastSizeRtPrice"),//胸ポケット大きさ
	SHIRT_STANDARD_OPTION_CODE14("00014","getOsFrontDesign","","setStFrtDesignRtPrice"),//フロントデザイン
	SHIRT_STANDARD_OPTION_CODE15("00015","getOsPinTack","","setStPintuckBosomRtPrice"),//ピンタックブザム
	SHIRT_STANDARD_OPTION_CODE16("00016","getOsStitch","","setStStitchRtPrice"),//ステッチ
	SHIRT_STANDARD_OPTION_CODE17("00017","getOsColorKeeper","","setStColarKeeperRtPrice"),//カラーキーパー
	SHIRT_STANDARD_OPTION_CODE18("00018","getOsByColor","","setStBtnthreadColorRtPrice"),//ボタン付け糸色変更
	SHIRT_STANDARD_OPTION_CODE19("00019","getOsBhColor","","setStBtnholeColorRtPrice"),//ボタンホール色変更
	SHIRT_STANDARD_OPTION_CODE20("00020","getOsCasHemLine","","setStCasualHemlineRtPrice"),//カジュアルヘムライン仕様
	SHIRT_STANDARD_OPTION_CODE21("00021","getOsBtnPosChg","","setStBtnposChgRtPrice");//ボタン位置変更
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private ShirtCoOptionStandardPriceEnum(String k ,String v1 , String v2 , String v3) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static ShirtCoOptionStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static ShirtCoOptionStandardPriceEnum get(String str) {
        for (ShirtCoOptionStandardPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
    
    public String getKey() {
    	return key;
    }
    
    public String getValueOne() {
    	return valueOne;
    }
    
    public String getValueTwo() {
    	return valueTwo;
    }
    
    public String getValueThree() {
    	return valueThree;
    }
}
