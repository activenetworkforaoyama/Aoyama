package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketCoOptionStandardUpperPriceEnum {

	// OptionForm
	// Key:OptionJacketStandardInfo option_code
	// Value1:OptionJacketStandardInfoのmethod
	
	JK_Standard_OPTION_CODE01("00001","getOjFrontBtnCnt","","ojFrontBtnCntPrice","setJkFrtBtnRtPrice"),//フロント釦数
	JK_Standard_OPTION_CODE02("00002","getOjLapelDesign","","ojLapelDesignPrice","setJkLapelDesignRtPrice"),//ラペルデザイン
	JK_Standard_OPTION_CODE03("00003","getOjGrade","","ojGradePrice","setJkGradeRtPrice"),//グレード
	JK_Standard_OPTION_CODE04("00004","getOjGackSpec","","ojGackSpecPrice","setJkInnerClothRtPrice"),//裏仕様
	JK_Standard_OPTION_CODE05("00005","getOjFort","","ojFortPrice","setJkDaibaRtPrice"),//台場
	JK_Standard_OPTION_CODE07("00007","getOjBackCollar","","ojBackCollarPrice","setJkCollarInnerRtPrice"),//襟裏（ヒゲ）
	JK_Standard_OPTION_CODE08("00008","getOjChainHange","","ojChainHangePrice","setJkCollarHangRtPrice"),//襟吊
	JK_Standard_OPTION_CODE09("00009","getOjLapelWidth","","ojLapelWidthPrice","setJkLapelWidthRtPrice"),//ラペル幅
	JK_Standard_OPTION_CODE10("00010","getOjFlowerHole","","ojFlowerHolePrice","setJkFlowerHoleRtPrice"),//フラワーホール
	JK_Standard_OPTION_CODE11("00011","getOjBreastPkt","","ojBreastPktPrice","setJkBreastPktRtPrice"),//胸ポケット
	JK_Standard_OPTION_CODE12("00012","getOjWaistPkt","","ojWaistPktPrice","setJkWaistPktRtPrice"),//腰ポケット
	JK_Standard_OPTION_CODE13("00013","getOjChangePkt","","ojChangePktPrice","setJkChgPktRtPrice"),//チェンジポケット
	JK_Standard_OPTION_CODE14("00014","getOjSlantedPkt","","ojSlantedPktPrice","setJkSlantedPktRtPrice"),//スランテッドポケット
	JK_Standard_OPTION_CODE15("00015","getOjCoinPkt","","ojCoinPktPrice","setJkShinobiPktRtPrice"),//忍びポケット
	JK_Standard_OPTION_CODE16("00016","getOjSleeveSpec","","ojSleeveSpecPrice","setJkSleeveTypeRtPrice"),//袖仕様
	JK_Standard_OPTION_CODE17("00017","getOjManica","","ojManicaPrice","setJkManicaRtPrice"),//マニカ
//	JK_Standard_OPTION_CODE18("00018","getOjSleeveBtnType","","ojSleeveBtnTypePrice","setJkSleeveBtnRtPrice"),//袖釦
	JK_Standard_OPTION_CODE19("00019","getOjCuffSpec","","ojCuffSpecPrice","setJkCuffRtPrice"),//袖口
//	JK_Standard_OPTION_CODE20("00020","getOjInsidePktChange","","ojInsidePktChangePrice","setJkInnerPktRtPrice"),//内ポケット変更
	JK_Standard_OPTION_CODE22("00022","getOjBreastInnerPkt","","ojBreastInnerPktPrice","setJkRightInnerPktTypeRtPrice"),//下前胸内ポケット仕様
	JK_Standard_OPTION_CODE23("00023","getOjStitch","","ojStitchPrice","setJkStitchTypeRtPrice"),//ステッチ種類
//	JK_Standard_OPTION_CODE24("00024","getOjStitchModify","","ojStitchModifyPrice","setJkStitchPlcRtPrice"),//ステッチ箇所変更
	JK_Standard_OPTION_CODE26("00026","getOjDStitchModify","","ojDStitchModifyPrice","setJkDblstitchPlcRtPrice"),//ダブルステッチ変更
//	JK_Standard_OPTION_CODE28("00028","getOjAmfColor","","ojAmfColorPrice","setJkAmfColorRtPrice"),//AMF色指定
//	JK_Standard_OPTION_CODE31("00031","getOjBhColor","","ojBhColorPrice","setJkBtnholePlcColorRtPrice"),//ボタンホール色指定
//	JK_Standard_OPTION_CODE34("00034","getOjByColor","","ojByColorPrice","setJkBtnthreadPlcColorRtPrice"),//ボタン付け糸指定
	JK_Standard_OPTION_CODE37("00037","getOjVentSpec","","ojVentSpecPrice","setJkVentRtPrice"),//ベント
	JK_Standard_OPTION_CODE38("00038","getOjBodyBackMate","getOjBodyBackMateStkNo","ojBodyBackMateStkNoPrice","setJkInnerBodyClothRtPrice"),//胴裏素材
	JK_Standard_OPTION_CODE40("00040","getOjCuffBackMate","getOjCuffBackMateStkNo","ojCuffBackMateStkNoPrice","setJkInnerSleeveClothRtPrice"),//袖裏素材
	JK_Standard_OPTION_CODE42("00042","getOjBtnMate","getOjBtnMateStkNo","ojBtnMateStkNoPrice","setJkBtnMaterialRtPrice"),//釦素材
	JK_Standard_OPTION_CODE44("00044","getOjShapeMemory","","ojShapeMemoryPrice","setJkShapeMemoryRtPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	
    
    private JacketCoOptionStandardUpperPriceEnum(String k ,String v1 , String v2, String v3, String v4) {
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
