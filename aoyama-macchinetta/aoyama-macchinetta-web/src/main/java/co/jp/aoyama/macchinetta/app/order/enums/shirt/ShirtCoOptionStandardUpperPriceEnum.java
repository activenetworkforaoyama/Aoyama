package co.jp.aoyama.macchinetta.app.order.enums.shirt;

public enum ShirtCoOptionStandardUpperPriceEnum {

	// OptionForm
	// Key:OptionShirtStandardInfoのoption_code
	// Value1:OptionShirtStandardInfoのmethod
	
	SHIRT_STANDARD_OPTION_CODE01("00001","getOsChainModel","osChainModelPrice"),//襟型
	SHIRT_STANDARD_OPTION_CODE02("00002","getOsCuffs","osCuffsPrice"),//カフス
	SHIRT_STANDARD_OPTION_CODE03("00003","getOsConvertible","osConvertiblePrice"),//コンバーチブル
	SHIRT_STANDARD_OPTION_CODE04("00004","getOsAdjustBtn","osAdjustBtnPrice"),//アジャスト釦
	SHIRT_STANDARD_OPTION_CODE05("00005","getOsClericSpec","osClericSpecPrice"),//クレリック仕様
	SHIRT_STANDARD_OPTION_CODE06("00006","getOsDblCuff","osDblCuffPrice"),//ダブルカフス仕様
	SHIRT_STANDARD_OPTION_CODE07("00007","getOsAddCuff","osAddCuffPrice"),//カフスボタン追加
	SHIRT_STANDARD_OPTION_CODE08("00008","getOsBtnMate","osBtnMatePrice"),//釦素材
	SHIRT_STANDARD_OPTION_CODE09("00009","getOsTabBtn","osTabBtnPrice"),//タブ釦
	SHIRT_STANDARD_OPTION_CODE10("00010","getOsGaletteBtnPos","osGaletteBtnPosPrice"),//ガントレットボタン位置
	SHIRT_STANDARD_OPTION_CODE11("00011","getOsPinHolePin","osPinHolePinPrice"),//ピンホールピン
	SHIRT_STANDARD_OPTION_CODE12("00012","getOsBreastPk","osBreastPkPrice"),//胸ポケット
	SHIRT_STANDARD_OPTION_CODE13("00013","getOsBreastPkSize","osBreastPkSizePrice"),//胸ポケット大きさ
	SHIRT_STANDARD_OPTION_CODE14("00014","getOsFrontDesign","osFrontDesignPrice"),//フロントデザイン
	SHIRT_STANDARD_OPTION_CODE15("00015","getOsPinTack","osPinTackPrice"),//ピンタックブザム
	SHIRT_STANDARD_OPTION_CODE16("00016","getOsStitch","osStitchPrice"),//ステッチ
	SHIRT_STANDARD_OPTION_CODE17("00017","getOsColorKeeper","osColorKeeperPrice"),//カラーキーパー
	SHIRT_STANDARD_OPTION_CODE18("00018","getOsByColor","osByColorPrice"),//ボタン付け糸色変更
	SHIRT_STANDARD_OPTION_CODE19("00019","getOsBhColor","osBhColorPrice"),//ボタンホール色変更
	SHIRT_STANDARD_OPTION_CODE20("00020","getOsCasHemLine","osCasHemLinePrice"),//カジュアルヘムライン仕様
	SHIRT_STANDARD_OPTION_CODE21("00021","getOsBtnPosChg","osBtnPosChgPrice");//ボタン位置変更
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	
    private ShirtCoOptionStandardUpperPriceEnum(String k ,String v1 , String v2) {
        this.key = k;
        this.valueOne = v1;
        this.valueTwo = v2;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo);
    }  
  
    public static ShirtCoOptionStandardUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static ShirtCoOptionStandardUpperPriceEnum get(String str) {
        for (ShirtCoOptionStandardUpperPriceEnum e : values()) {
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

}
