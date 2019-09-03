package co.jp.aoyama.macchinetta.app.order.enums.shirt;

public enum ShirtCoOptionStandardNextGenerationPriceEnum {

	// OptionForm
	// Key:OptionShirtStandardInfoのoption_code
	// Value1:OptionShirtStandardInfoのmethod
	// Value2:orderのmethod
	// Value3:orderのmethod
	// Value4:orderのmethod
	// Value5:orderのmethod
	
	SHIRT_STANDARD_OPTION_CODE01("00001","getOsChainModel","setStCollarTypeWsWage","setStCollarTypeWsPrice","getStCollarTypeWsWage","getStCollarTypeWsPrice"),//襟型
	SHIRT_STANDARD_OPTION_CODE02("00002","getOsCuffs","setStCuffsWsWage","setStCuffsWsPrice","getStCuffsWsWage","getStCuffsWsPrice"),//カフス
	SHIRT_STANDARD_OPTION_CODE03("00003","getOsConvertible","setStConvertibleWsWage","setStConvertibleWsPrice","getStConvertibleWsWage","getStConvertibleWsPrice"),//コンバーチブル
	SHIRT_STANDARD_OPTION_CODE04("00004","getOsAdjustBtn","setStAdjusterBtnWsWage","setStAdjusterBtnWsPrice","getStAdjusterBtnWsWage","getStAdjusterBtnWsPrice"),//アジャスト釦
	SHIRT_STANDARD_OPTION_CODE05("00005","getOsClericSpec","setStClericWsWage","setStClericWsPrice","getStClericWsWage","getStClericWsPrice"),//クレリック仕様
	SHIRT_STANDARD_OPTION_CODE06("00006","getOsDblCuff","setStDblCuffsWsWage","setStDblCuffsWsPrice","getStDblCuffsWsWage","getStDblCuffsWsPrice"),//ダブルカフス仕様
	SHIRT_STANDARD_OPTION_CODE07("00007","getOsAddCuff","setStCuffsBtnWsWage","setStCuffsBtnWsPrice","getStCuffsBtnWsWage","getStCuffsBtnWsPrice"),//カフスボタン追加
	SHIRT_STANDARD_OPTION_CODE08("00008","getOsBtnMate","setStBtnMaterialWsWage","setStBtnMaterialWsPrice","getStBtnMaterialWsWage","getStBtnMaterialWsPrice"),//釦素材
	SHIRT_STANDARD_OPTION_CODE09("00009","getOsTabBtn","setStDblBtnWsWage","setStDblBtnWsPrice","getStDblBtnWsWage","getStDblBtnWsPrice"),//タブ釦
	SHIRT_STANDARD_OPTION_CODE10("00010","getOsGaletteBtnPos","setStGauntletBtnPosWsWage","setStGauntletBtnPosWsPrice","getStGauntletBtnPosWsWage","getStGauntletBtnPosWsPrice"),//ガントレットボタン位置
	SHIRT_STANDARD_OPTION_CODE11("00011","getOsPinHolePin","setStPinholePinWsWage","setStPinholePinWsPrice","getStPinholePinWsWage","getStPinholePinWsPrice"),//ピンホールピン
	SHIRT_STANDARD_OPTION_CODE12("00012","getOsBreastPk","setStBreastPktWsWage","setStBreastPktWsPrice","getStBreastPktWsWage","getStBreastPktWsPrice"),//胸ポケット
	SHIRT_STANDARD_OPTION_CODE13("00013","getOsBreastPkSize","setStBreastSizeWsWage","setStBreastSizeWsPrice","getStBreastSizeWsWage","getStBreastSizeWsPrice"),//胸ポケット大きさ
	SHIRT_STANDARD_OPTION_CODE14("00014","getOsFrontDesign","setStFrtDesignWsWage","setStFrtDesignWsPrice","getStFrtDesignWsWage","getStFrtDesignWsPrice"),//フロントデザイン
	SHIRT_STANDARD_OPTION_CODE15("00015","getOsPinTack","setStPintuckBosomWsWage","setStPintuckBosomWsPrice","getStPintuckBosomWsWage","getStPintuckBosomWsPrice"),//ピンタックブザム
	SHIRT_STANDARD_OPTION_CODE16("00016","getOsStitch","setStStitchWsWage","setStStitchWsPrice","getStStitchWsWage","getStStitchWsPrice"),//ステッチ
	SHIRT_STANDARD_OPTION_CODE17("00017","getOsColorKeeper","setStColarKeeperWsWage","setStColarKeeperWsPrice","getStColarKeeperWsWage","getStColarKeeperWsPrice"),//カラーキーパー
	SHIRT_STANDARD_OPTION_CODE18("00018","getOsByColor","setStBtnthreadColorWsWage","setStBtnthreadColorWsPrice","getStBtnthreadColorWsWage","getStBtnthreadColorWsPrice"),//ボタン付け糸色変更
	SHIRT_STANDARD_OPTION_CODE19("00019","getOsBhColor","setStBtnholeColorWsWage","setStBtnholeColorWsPrice","getStBtnholeColorWsWage","getStBtnholeColorWsPrice"),//ボタンホール色変更
	SHIRT_STANDARD_OPTION_CODE20("00020","getOsCasHemLine","setStCasualHemlineWsWage","setStCasualHemlineWsPrice","getStCasualHemlineWsWage","getStCasualHemlineWsPrice"),//カジュアルヘムライン仕様
	SHIRT_STANDARD_OPTION_CODE21("00021","getOsBtnPosChg","setStBtnposChgWsWage","setStBtnposChgWsPrice","getStBtnposChgWsWage","getStBtnposChgWsPrice");//ボタン位置変更
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	
    private ShirtCoOptionStandardNextGenerationPriceEnum(String k ,String v1 , String v2, String v3, String v4, String v5) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour =v4;
        this.valueFive =v5;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour).concat(",").concat(this.valueFive);
    }  
  
    public static ShirtCoOptionStandardNextGenerationPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static ShirtCoOptionStandardNextGenerationPriceEnum get(String str) {
        for (ShirtCoOptionStandardNextGenerationPriceEnum e : values()) {
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

}
