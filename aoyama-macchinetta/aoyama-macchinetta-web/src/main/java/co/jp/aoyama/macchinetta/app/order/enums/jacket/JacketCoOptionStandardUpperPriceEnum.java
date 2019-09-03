package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketCoOptionStandardUpperPriceEnum {

	// OptionForm
	// Key:OptionJacketStandardInfo option_code
	// Value1:OptionJacketStandardInfoのmethod
	
	JK_Standard_OPTION_CODE01("00001","getOjFrontBtnCnt","","ojFrontBtnCntPrice"),//フロント釦数
	JK_Standard_OPTION_CODE02("00002","getOjLapelDesign","","ojLapelDesignPrice"),//ラペルデザイン
	JK_Standard_OPTION_CODE03("00003","getOjGrade","","ojGradePrice"),//グレード
	JK_Standard_OPTION_CODE04("00004","getOjGackSpec","","ojGackSpecPrice"),//裏仕様
	JK_Standard_OPTION_CODE05("00005","getOjFort","","ojFortPrice"),//台場
	JK_Standard_OPTION_CODE07("00007","getOjBackCollar","","ojBackCollarPrice"),//襟裏（ヒゲ）
	JK_Standard_OPTION_CODE08("00008","getOjChainHange","","ojChainHangePrice"),//襟吊
	JK_Standard_OPTION_CODE09("00009","getOjLapelWidth","","ojLapelWidthPrice"),//ラペル幅
	JK_Standard_OPTION_CODE10("00010","getOjFlowerHole","","ojFlowerHolePrice"),//フラワーホール
	JK_Standard_OPTION_CODE11("00011","getOjBreastPkt","","ojBreastPktPrice"),//胸ポケット
	JK_Standard_OPTION_CODE12("00012","getOjWaistPkt","","ojWaistPktPrice"),//腰ポケット
	JK_Standard_OPTION_CODE13("00013","getOjChangePkt","","ojChangePktPrice"),//チェンジポケット
	JK_Standard_OPTION_CODE14("00014","getOjSlantedPkt","","ojSlantedPktPrice"),//スランテッドポケット
	JK_Standard_OPTION_CODE15("00015","getOjCoinPkt","","ojCoinPktPrice"),//忍びポケット
	JK_Standard_OPTION_CODE16("00016","getOjSleeveSpec","","ojSleeveSpecPrice"),//袖仕様
	JK_Standard_OPTION_CODE17("00017","getOjManica","","ojManicaPrice"),//マニカ
	JK_Standard_OPTION_CODE18("00018","getOjSleeveBtnType","","ojSleeveBtnTypePrice"),//袖釦
	JK_Standard_OPTION_CODE19("00019","getOjCuffSpec","","ojCuffSpecPrice"),//袖口
	JK_Standard_OPTION_CODE20("00020","getOjInsidePktChange","","ojInsidePktChangePrice"),//内ポケット変更
	JK_Standard_OPTION_CODE22("00022","getOjBreastInnerPkt","","ojBreastInnerPktPrice"),//下前胸内ポケット仕様
	JK_Standard_OPTION_CODE23("00023","getOjStitch","","ojStitchPrice"),//ステッチ種類
	JK_Standard_OPTION_CODE24("00024","getOjStitchModify","","ojStitchModifyPrice"),//ステッチ箇所変更
	JK_Standard_OPTION_CODE26("00026","getOjDStitchModify","","ojDStitchModifyPrice"),//ダブルステッチ変更
	JK_Standard_OPTION_CODE28("00028","getOjAmfColor","","ojAmfColorPrice"),//AMF色指定
	JK_Standard_OPTION_CODE31("00031","getOjBhColor","","ojBhColorPrice"),//ボタンホール色指定
	JK_Standard_OPTION_CODE34("00034","getOjByColor","","ojByColorPrice"),//ボタン付け糸指定
	JK_Standard_OPTION_CODE37("00037","getOjVentSpec","","ojVentSpecPrice"),//ベント
	JK_Standard_OPTION_CODE38("00038","getOjBodyBackMate","getOjBodyBackMateStkNo","ojBodyBackMateStkNoPrice"),//胴裏素材
	JK_Standard_OPTION_CODE40("00040","getOjCuffBackMate","getOjCuffBackMateStkNo","ojCuffBackMateStkNoPrice"),//袖裏素材
	JK_Standard_OPTION_CODE42("00042","getOjBtnMate","getOjBtnMateStkNo","ojBtnMateStkNoPrice"),//釦素材
	JK_Standard_OPTION_CODE44("00044","getOjShapeMemory","","ojShapeMemoryPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	
    
    private JacketCoOptionStandardUpperPriceEnum(String k ,String v1 , String v2, String v3) {
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
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static JacketCoOptionStandardUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketCoOptionStandardUpperPriceEnum get(String str) {
        for (JacketCoOptionStandardUpperPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
