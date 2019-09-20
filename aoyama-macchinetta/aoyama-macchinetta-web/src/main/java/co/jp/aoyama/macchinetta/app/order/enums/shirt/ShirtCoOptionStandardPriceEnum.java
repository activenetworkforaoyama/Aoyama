package co.jp.aoyama.macchinetta.app.order.enums.shirt;

public enum ShirtCoOptionStandardPriceEnum {

	// OptionForm
	// Key:OptionSHIRTStandardInfo option_code
	// Value:OptionSHIRTStandardInfo method
	// Value:OptionSHIRTStandardInfo method
	// Value:order method
	
	SHIRT_STANDARD_OPTION_CODE01("00001","getOsChainModel","","setStCollarTypeRtPrice","os_chainModel","","getStCollarTypeRtPrice"),//襟型
	SHIRT_STANDARD_OPTION_CODE02("00002","getOsCuffs","","setStCuffsRtPrice","os_cuffs","","getStCuffsRtPrice"),//カフス
	SHIRT_STANDARD_OPTION_CODE03("00003","getOsConvertible","","setStConvertibleRtPrice","os_convertible","","getStConvertibleRtPrice"),//コンバーチブル
	SHIRT_STANDARD_OPTION_CODE04("00004","getOsAdjustBtn","","setStAdjusterBtnRtPrice","os_adjustBtn","","getStAdjusterBtnRtPrice"),//アジャスト釦
	SHIRT_STANDARD_OPTION_CODE05("00005","getOsClericSpec","","setStClericRtPrice","os_clericSpec_id","","getStClericRtPrice"),//クレリック仕様
	SHIRT_STANDARD_OPTION_CODE06("00006","getOsDblCuff","","setStDblCuffsRtPrice","os_dblCuff_id","","getStDblCuffsRtPrice"),//ダブルカフス仕様
	SHIRT_STANDARD_OPTION_CODE07("00007","getOsAddCuff","","setStCuffsBtnRtPrice","os_AddCuff_id","","getStCuffsBtnRtPrice"),//カフスボタン追加
	SHIRT_STANDARD_OPTION_CODE08("00008","getOsBtnMate","","setStBtnMaterialRtPrice","os_btnMate","","getStBtnMaterialRtPrice"),//釦素材
	SHIRT_STANDARD_OPTION_CODE09("00009","getOsTabBtn","","setStDblBtnRtPrice","os_tabBtn_id","","getStDblBtnRtPrice"),//タブ釦
	SHIRT_STANDARD_OPTION_CODE10("00010","getOsGaletteBtnPos","","setStGauntletBtnPosRtPrice","os_galetteBtnPos_nomal_id","","getStGauntletBtnPosRtPrice"),//ガントレットボタン位置
	SHIRT_STANDARD_OPTION_CODE11("00011","getOsPinHolePin","","setStPinholePinRtPrice","os_pinHolePin_id","","getStPinholePinRtPrice"),//ピンホールピン
	SHIRT_STANDARD_OPTION_CODE12("00012","getOsBreastPk","","setStBreastPktRtPrice","os_breastPk_yes_id","","getStBreastPktRtPrice"),//胸ポケット
	SHIRT_STANDARD_OPTION_CODE13("00013","getOsBreastPkSize","","setStBreastSizeRtPrice","os_breastPkSize_normal_id","","getStBreastSizeRtPrice"),//胸ポケット大きさ
	SHIRT_STANDARD_OPTION_CODE14("00014","getOsFrontDesign","","setStFrtDesignRtPrice","os_frontDesign","","getStFrtDesignRtPrice"),//フロントデザイン
	SHIRT_STANDARD_OPTION_CODE15("00015","getOsPinTack","","setStPintuckBosomRtPrice","os_pinTack_no_id","","getStPintuckBosomRtPrice"),//ピンタックブザム
	SHIRT_STANDARD_OPTION_CODE16("00016","getOsStitch","","setStStitchRtPrice","os_stitch_nomal_id","","getStStitchRtPrice"),//ステッチ
	SHIRT_STANDARD_OPTION_CODE17("00017","getOsColorKeeper","","setStColarKeeperRtPrice","os_colorKeeper_id","","getStColarKeeperRtPrice"),//カラーキーパー
	SHIRT_STANDARD_OPTION_CODE18("00018","getOsByColor","","setStBtnthreadColorRtPrice","os_byColor","","getStBtnthreadColorRtPrice"),//ボタン付け糸色変更
	SHIRT_STANDARD_OPTION_CODE19("00019","getOsBhColor","","setStBtnholeColorRtPrice","os_bhColor","","getStBtnholeColorRtPrice"),//ボタンホール色変更
	SHIRT_STANDARD_OPTION_CODE20("00020","getOsCasHemLine","","setStCasualHemlineRtPrice","os_casHemLine_id","","getStCasualHemlineRtPrice"),//カジュアルヘムライン仕様
	SHIRT_STANDARD_OPTION_CODE21("00021","getOsBtnPosChg","","setStBtnposChgRtPrice","os_btnPosChg_id","","getStBtnposChgRtPrice");//ボタン位置変更
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
    
    private ShirtCoOptionStandardPriceEnum(String k ,String v1 , String v2 , String v3, String v4, String v5, String v6) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour = v4;
		this.valueFive = v5;
		this.valueSix = v6;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",")
        		.concat(this.valueFour).concat(",").concat(this.valueFive).concat(",").concat(this.valueSix);
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

	public String getValueFour() {
		return valueFour;
	}

	public String getValueFive() {
		return valueFive;
	}

	public String getValueSix() {
		return valueSix;
	}
    
}
