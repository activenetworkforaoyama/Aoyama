package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketCoOptionTuxedoUpperPriceEnum {

	// OptionForm
	// Key:OptionJacketTuxedoInfo option_code
	// Value1:OptionJacketTuxedoInfoのmethod
	
	JK_Tuxedo_OPTION_CODE01("00001","getTjFrontBtnCnt","","tjFrontBtnCntPrice","setJkFrtBtnRtPrice"),//フロント釦数
	JK_Tuxedo_OPTION_CODE02("00002","getTjLapelDesign","","tjLapelDesignPrice","setJkLapelDesignRtPrice"),//ラペルデザイン
	JK_Tuxedo_OPTION_CODE03("00003","getTjGrade","","tjGradePrice","setJkGradeRtPrice"),//グレード
	JK_Tuxedo_OPTION_CODE04("00004","getTjBackSpec","","tjBackSpecPrice","setJkInnerClothRtPrice"),//裏仕様
	JK_Tuxedo_OPTION_CODE05("00005","getTjFort","","tjFortPrice","setJkDaibaRtPrice"),//台場
	JK_Tuxedo_OPTION_CODE06("00006","getTjGlossFablic","","tjGlossFablicPrice","setJkLookClothRtPrice"),//拝見地
	JK_Tuxedo_OPTION_CODE07("00007","getTjBackSpec","","tjBackSpecPrice","setJkCollarInnerRtPrice"),//襟裏（ヒゲ）
	JK_Tuxedo_OPTION_CODE08("00008","getTjChainHange","","tjChainHangePrice","setJkCollarHangRtPrice"),//襟吊
	JK_Tuxedo_OPTION_CODE09("00009","getTjLapelWidth","","tjLapelWidthPrice","setJkLapelWidthRtPrice"),//ラペル幅
	JK_Tuxedo_OPTION_CODE10("00010","getTjFlowerHole","","tjFlowerHolePrice","setJkFlowerHoleRtPrice"),//フラワーホール
	JK_Tuxedo_OPTION_CODE11("00011","getTjBreastPkt","","tjBreastPktPrice","setJkBreastPktRtPrice"),//胸ポケット
	JK_Tuxedo_OPTION_CODE12("00012","getTjWaistPkt","","tjWaistPktPrice","setJkWaistPktRtPrice"),//腰ポケット
	JK_Tuxedo_OPTION_CODE13("00013","getTjChangePkt","","tjChangePktPrice","setJkChgPktRtPrice"),//チェンジポケット
	JK_Tuxedo_OPTION_CODE14("00014","getTjSlantedPkt","","tjSlantedPktPrice","setJkSlantedPktRtPrice"),//スランテッドポケット
	JK_Tuxedo_OPTION_CODE15("00015","getTjCoinPkt","","tjCoinPktPrice","setJkShinobiPktRtPrice"),//忍びポケット
	JK_Tuxedo_OPTION_CODE16("00016","getTjSleeveSpec","","tjSleeveSpecPrice","setJkSleeveTypeRtPrice"),//袖仕様
	JK_Tuxedo_OPTION_CODE17("00017","getTjManica","","tjManicaPrice","setJkManicaRtPrice"),//マニカ
	JK_Tuxedo_OPTION_CODE18("00018","getTjSleeveBtnType","","tjSleeveBtnTypePrice","setJkSleeveBtnRtPrice"),//袖釦
	JK_Tuxedo_OPTION_CODE19("00019","getTjCuffSpec","","tjCuffSpecPrice","setJkCuffRtPrice"),//袖口
	JK_Tuxedo_OPTION_CODE20("00020","getTjInsidePktChange","","tjInsidePktChangePrice","setJkInnerPktRtPrice"),//内ポケット変更
	JK_Tuxedo_OPTION_CODE22("00022","getTjBreastInnerPkt","","tjBreastInnerPktPrice","setJkRightInnerPktTypeRtPrice"),//下前胸内ポケット仕様
	JK_Tuxedo_OPTION_CODE23("00023","getTjStitch","","tjStitchPrice","setJkStitchTypeRtPrice"),//ステッチ種類
	JK_Tuxedo_OPTION_CODE31("00031","getTjBhColor","","tjBhColorPrice","setJkBtnholePlcColorRtPrice"),//ボタンホール色指定
	JK_Tuxedo_OPTION_CODE34("00034","getTjByColor","","tjByColorPrice","setJkBtnthreadPlcColorRtPrice"),//ボタン付け糸指定
	JK_Tuxedo_OPTION_CODE37("00037","getTjVentSpec","","tjVentSpecPrice","setJkVentRtPrice"),//ベント
	JK_Tuxedo_OPTION_CODE38("00038","getTjBodyBackMate","getTjBodyBackMateStkNo","tjBodyBackMateStkNoPrice","setJkInnerBodyClothRtPrice"),//胴裏素材
	JK_Tuxedo_OPTION_CODE40("00040","getTjCuffBackMate","getTjCuffBackMateStkNo","tjCuffBackMateStkNoPrice","setJkInnerSleeveClothRtPrice"),//袖裏素材
	JK_Tuxedo_OPTION_CODE42("00042","getTjBtnMate","getTjBtnMateStkNo","tjBtnMateStkNoPrice","setJkBtnMaterialRtPrice"),//釦素材
	JK_Tuxedo_OPTION_CODE44("00044","getTjShapeMemory","","tjShapeMemoryPrice","setJkShapeMemoryRtPrice");//形状記憶
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
    
    private JacketCoOptionTuxedoUpperPriceEnum(String k ,String v1 , String v2 , String v3,  String v4) {
    	this.key = k;
    	this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree = v3;
        this.valueFour = v4;
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
	
	public String getValueFour() {
		return valueFour;
	}

	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree).concat(",").concat(this.valueFour);
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
