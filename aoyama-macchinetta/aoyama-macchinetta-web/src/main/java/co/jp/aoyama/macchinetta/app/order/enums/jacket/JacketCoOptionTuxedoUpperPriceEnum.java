package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketCoOptionTuxedoUpperPriceEnum {

	// OptionForm
	// Key:OptionJacketTuxedoInfo option_code
	// Value1:OptionJacketTuxedoInfoのmethod
	
	JK_Tuxedo_OPTION_CODE01("00001","getTjFrontBtnCnt","","tjFrontBtnCntPrice"),//フロント釦数
	JK_Tuxedo_OPTION_CODE02("00002","getTjLapelDesign","","tjLapelDesignPrice"),//ラペルデザイン
	JK_Tuxedo_OPTION_CODE03("00003","getTjGrade","","tjGradePrice"),//グレード
	JK_Tuxedo_OPTION_CODE04("00004","getTjBackSpec","","tjBackSpecPrice"),//裏仕様
	JK_Tuxedo_OPTION_CODE05("00005","getTjFort","","tjFortPrice"),//台場
	JK_Tuxedo_OPTION_CODE06("00006","getTjGlossFablic","","tjGlossFablicPrice"),//拝見地
	JK_Tuxedo_OPTION_CODE07("00007","getTjBackSpec","","tjBackSpecPrice"),//襟裏（ヒゲ）
	JK_Tuxedo_OPTION_CODE08("00008","getTjChainHange","","tjChainHangePrice"),//襟吊
	JK_Tuxedo_OPTION_CODE09("00009","getTjLapelWidth","","tjLapelWidthPrice"),//ラペル幅
	JK_Tuxedo_OPTION_CODE10("00010","getTjFlowerHole","","tjFlowerHolePrice"),//フラワーホール
	JK_Tuxedo_OPTION_CODE11("00011","getTjBreastPkt","","tjBreastPktPrice"),//胸ポケット
	JK_Tuxedo_OPTION_CODE12("00012","getTjWaistPkt","","tjWaistPktPrice"),//腰ポケット
	JK_Tuxedo_OPTION_CODE13("00013","getTjChangePkt","","tjChangePktPrice"),//チェンジポケット
	JK_Tuxedo_OPTION_CODE14("00014","getTjSlantedPkt","","tjSlantedPktPrice"),//スランテッドポケット
	JK_Tuxedo_OPTION_CODE15("00015","getTjCoinPkt","","tjCoinPktPrice"),//忍びポケット
	JK_Tuxedo_OPTION_CODE16("00016","getTjSleeveSpec","","tjSleeveSpecPrice"),//袖仕様
	JK_Tuxedo_OPTION_CODE17("00017","getTjManica","","tjManicaPrice"),//マニカ
	JK_Tuxedo_OPTION_CODE18("00018","getTjSleeveBtnType","","tjSleeveBtnTypePrice"),//袖釦
	JK_Tuxedo_OPTION_CODE19("00019","getTjCuffSpec","","tjCuffSpecPrice"),//袖口
	JK_Tuxedo_OPTION_CODE20("00020","getTjInsidePktChange","","tjInsidePktChangePrice"),//内ポケット変更
	JK_Tuxedo_OPTION_CODE22("00022","getTjBreastInnerPkt","","tjBreastInnerPktPrice"),//下前胸内ポケット仕様
	JK_Tuxedo_OPTION_CODE23("00023","getTjStitch","","tjStitchPrice"),//ステッチ種類
	JK_Tuxedo_OPTION_CODE31("00031","getTjBhColor","","tjBhColorPrice"),//ボタンホール色指定
	JK_Tuxedo_OPTION_CODE34("00034","getTjByColor","","tjByColorPrice"),//ボタン付け糸指定
	JK_Tuxedo_OPTION_CODE37("00037","getTjVentSpec","","tjVentSpecPrice"),//ベント
	JK_Tuxedo_OPTION_CODE38("00038","getTjBodyBackMate","getTjBodyBackMateStkNo","tjBodyBackMateStkNoPrice"),//胴裏素材
	JK_Tuxedo_OPTION_CODE40("00040","getTjCuffBackMate","getTjCuffBackMateStkNo","tjCuffBackMateStkNoPrice"),//袖裏素材
	JK_Tuxedo_OPTION_CODE42("00042","getTjBtnMate","getTjBtnMateStkNo","tjBtnMateStkNoPrice"),//釦素材
	JK_Tuxedo_OPTION_CODE44("00044","getTjShapeMemory","","tjShapeMemoryPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private JacketCoOptionTuxedoUpperPriceEnum(String k ,String v1 , String v2 , String v3) {
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
  
    public static JacketCoOptionTuxedoUpperPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketCoOptionTuxedoUpperPriceEnum get(String str) {
        for (JacketCoOptionTuxedoUpperPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
