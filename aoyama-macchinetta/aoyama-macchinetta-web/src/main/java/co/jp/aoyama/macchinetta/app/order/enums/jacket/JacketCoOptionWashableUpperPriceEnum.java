package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketCoOptionWashableUpperPriceEnum {

	// OptionForm
	// Key:OptionJacketWashableInfo option_code
	// Value1:OptionJacketWashableInfoのmethod
	
	JK_Washable_OPTION_CODE01("00001","getWjFrontBtnCnt","","wjFrontBtnCntPrice"),//フロント釦数
	JK_Washable_OPTION_CODE02("00002","getWjLapelDesign","","wjLapelDesignPrice"),//ラペルデザイン
	JK_Washable_OPTION_CODE03("00003","getWjGrade","","wjGradePrice"),//グレード
	JK_Washable_OPTION_CODE04("00004","getWjBackSpec","","wjBackSpecPrice"),//裏仕様
	JK_Washable_OPTION_CODE05("00005","getWjFort","","wjFortPrice"),//台場
	JK_Washable_OPTION_CODE07("00007","getWjBackCollar","","wjBackCollarPrice"),//襟裏（ヒゲ）
	JK_Washable_OPTION_CODE08("00008","getWjChainHange","","wjChainHangePrice"),//襟吊
	JK_Washable_OPTION_CODE09("00009","getWjLapelWidth","","wjLapelWidthPrice"),//ラペル幅
	JK_Washable_OPTION_CODE10("00010","getWjFlowerHole","","wjFlowerHolePrice"),//フラワーホール
	JK_Washable_OPTION_CODE11("00011","getWjBreastPkt","","wjBreastPktPrice"),//胸ポケット
	JK_Washable_OPTION_CODE12("00012","getWjWaistPkt","","wjWaistPktPrice"),//腰ポケット
	JK_Washable_OPTION_CODE13("00013","getWjChangePkt","","wjChangePktPrice"),//チェンジポケット
	JK_Washable_OPTION_CODE14("00014","getWjSlantedPkt","","wjSlantedPktPrice"),//スランテッドポケット
	JK_Washable_OPTION_CODE15("00015","getWjCoinPkt","","wjCoinPktPrice"),//忍びポケット
	JK_Washable_OPTION_CODE16("00016","getWjSleeveSpec","","wSleeveSpecPrice"),//袖仕様
	JK_Washable_OPTION_CODE17("00017","getWjManica","","wjManicaPrice"),//マニカ
	JK_Washable_OPTION_CODE18("00018","getWjSleeveBtnType","","wjSleeveBtnTypePrice"),//袖釦
	JK_Washable_OPTION_CODE19("00019","getWjCuffSpec","","wjCuffSpecPrice"),//袖口
	JK_Washable_OPTION_CODE20("00020","getWjInsidePktChange","","wjInsidePktChangePrice"),//内ポケット変更
	JK_Washable_OPTION_CODE22("00022","getWjBreastInnerPkt","","wjBreastInnerPktPrice"),//下前胸内ポケット仕様
	JK_Washable_OPTION_CODE23("00023","getWjStitch","","wjStitchPrice"),//ステッチ種類
	JK_Washable_OPTION_CODE24("00024","getWjStitchModify","","wjStitchModifyPrice"),//ステッチ箇所変更
	JK_Washable_OPTION_CODE26("00026","getWjDStitchModify","","wjDStitchModifyPrice"),//ダブルステッチ変更
	JK_Washable_OPTION_CODE28("00028","getWjAmfColor","","wjAmfColorPrice"),//AMF色指定
	JK_Washable_OPTION_CODE31("00031","getWjBhColor","","wjBhColorPrice"),//ボタンホール色指定
	JK_Washable_OPTION_CODE34("00034","getWjByColor","","wjByColorPrice"),//ボタン付け糸指定
	JK_Washable_OPTION_CODE37("00037","getWjVentSpec","","wjVentSpecPrice"),//ベント
	JK_Washable_OPTION_CODE38("00038","getWjBodyBackMate","getWjBodyBackMateStkNo","wjBodyBackMateStkNoPrice"),//胴裏素材
	JK_Washable_OPTION_CODE40("00040","getWjCuffBackMate","getWjCuffBackMateStkNo","wjCuffBackMateStkNoPrice"),//袖裏素材
	JK_Washable_OPTION_CODE42("00042","getWjBtnMate","getWjBtnMateStkNo","wjBtnMateStkNoPrice"),//釦素材
	JK_Washable_OPTION_CODE44("00044","getWjShapeMemory","","wjShapeMemoryPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	
    
    private JacketCoOptionWashableUpperPriceEnum(String k ,String v1 , String v2 , String v3) {
    	this.key = k;
    	this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
    }  

	public String getKey() {
		return this.key;
	}
	 
	public String getValueOne() {
		return this.valueOne;
	}
	
	public String getValueTwo() {
		return this.valueTwo;
	}
	
	public String getValueThree() {
		return valueThree;
	}
	
	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo);
    }  
  
    public static JacketCoOptionWashableUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketCoOptionWashableUpperPriceEnum get(String str) {
        for (JacketCoOptionWashableUpperPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
