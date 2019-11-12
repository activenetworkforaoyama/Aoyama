package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketCoOptionWashableUpperPriceEnum {

	// OptionForm
	// Key:OptionJacketWashableInfo option_code
	// Value1:OptionJacketWashableInfoのmethod
	
	JK_Washable_OPTION_CODE01("00001","getWjFrontBtnCnt","","wjFrontBtnCntPrice","setJkFrtBtnRtPrice"),//フロント釦数
	JK_Washable_OPTION_CODE02("00002","getWjLapelDesign","","wjLapelDesignPrice","setJkLapelDesignRtPrice"),//ラペルデザイン
	JK_Washable_OPTION_CODE03("00003","getWjGrade","","wjGradePrice","setJkGradeRtPrice"),//グレード
	JK_Washable_OPTION_CODE04("00004","getWjBackSpec","","wjBackSpecPrice","setJkInnerClothRtPrice"),//裏仕様
	JK_Washable_OPTION_CODE05("00005","getWjFort","","wjFortPrice","setJkDaibaRtPrice"),//台場
	JK_Washable_OPTION_CODE07("00007","getWjBackCollar","","wjBackCollarPrice","setJkCollarInnerRtPrice"),//襟裏（ヒゲ）
	JK_Washable_OPTION_CODE08("00008","getWjChainHange","","wjChainHangePrice","setJkCollarHangRtPrice"),//襟吊
	JK_Washable_OPTION_CODE09("00009","getWjLapelWidth","","wjLapelWidthPrice","setJkLapelWidthRtPrice"),//ラペル幅
	JK_Washable_OPTION_CODE10("00010","getWjFlowerHole","","wjFlowerHolePrice","setJkFlowerHoleRtPrice"),//フラワーホール
	JK_Washable_OPTION_CODE11("00011","getWjBreastPkt","","wjBreastPktPrice","setJkBreastPktRtPrice"),//胸ポケット
	JK_Washable_OPTION_CODE12("00012","getWjWaistPkt","","wjWaistPktPrice","setJkWaistPktRtPrice"),//腰ポケット
	JK_Washable_OPTION_CODE13("00013","getWjChangePkt","","wjChangePktPrice","setJkChgPktRtPrice"),//チェンジポケット
	JK_Washable_OPTION_CODE14("00014","getWjSlantedPkt","","wjSlantedPktPrice","setJkSlantedPktRtPrice"),//スランテッドポケット
	JK_Washable_OPTION_CODE15("00015","getWjCoinPkt","","wjCoinPktPrice","setJkShinobiPktRtPrice"),//忍びポケット
	JK_Washable_OPTION_CODE16("00016","getWjSleeveSpec","","wSleeveSpecPrice","setJkSleeveTypeRtPrice"),//袖仕様
	JK_Washable_OPTION_CODE17("00017","getWjManica","","wjManicaPrice","setJkManicaRtPrice"),//マニカ
	JK_Washable_OPTION_CODE18("00018","getWjSleeveBtnType","","wjSleeveBtnTypePrice","setJkSleeveBtnRtPrice"),//袖釦
	JK_Washable_OPTION_CODE19("00019","getWjCuffSpec","","wjCuffSpecPrice","setJkCuffRtPrice"),//袖口
	JK_Washable_OPTION_CODE20("00020","getWjInsidePktChange","","wjInsidePktChangePrice","setJkInnerPktRtPrice"),//内ポケット変更
	JK_Washable_OPTION_CODE22("00022","getWjBreastInnerPkt","","wjBreastInnerPktPrice","setJkRightInnerPktTypeRtPrice"),//下前胸内ポケット仕様
	JK_Washable_OPTION_CODE23("00051","getWjStitch","","wjStitchPrice","setJkStitchTypeRtPrice"),//ステッチ種類
//	JK_Washable_OPTION_CODE24("00024","getWjStitchModify","","wjStitchModifyPrice","setJkStitchPlcRtPrice"),//ステッチ箇所変更
	JK_Washable_OPTION_CODE26("00026","getWjDStitchModify","","wjDStitchModifyPrice","setJkDblstitchPlcRtPrice"),//ダブルステッチ変更
//	JK_Washable_OPTION_CODE28("00028","getWjAmfColor","","wjAmfColorPrice","setJkAmfColorRtPrice"),//AMF色指定
//	JK_Washable_OPTION_CODE31("00031","getWjBhColor","","wjBhColorPrice","setJkBtnholePlcColorRtPrice"),//ボタンホール色指定
//	JK_Washable_OPTION_CODE34("00034","getWjByColor","","wjByColorPrice","setJkBtnthreadPlcColorRtPrice"),//ボタン付け糸指定
	JK_Washable_OPTION_CODE37("00037","getWjVentSpec","","wjVentSpecPrice","setJkVentRtPrice"),//ベント
	JK_Washable_OPTION_CODE38("00038","getWjBodyBackMate","getWjBodyBackMateStkNo","wjBodyBackMateStkNoPrice","setJkInnerBodyClothRtPrice"),//胴裏素材
	JK_Washable_OPTION_CODE40("00040","getWjCuffBackMate","getWjCuffBackMateStkNo","wjCuffBackMateStkNoPrice","setJkInnerSleeveClothRtPrice"),//袖裏素材
	JK_Washable_OPTION_CODE42("00042","getWjBtnMate","getWjBtnMateStkNo","wjBtnMateStkNoPrice","setJkBtnMaterialRtPrice"),//釦素材
	JK_Washable_OPTION_CODE44("00044","getWjShapeMemory","","wjShapeMemoryPrice","setJkShapeMemoryRtPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	
    
    private JacketCoOptionWashableUpperPriceEnum(String k ,String v1 , String v2 , String v3,  String v4) {
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
