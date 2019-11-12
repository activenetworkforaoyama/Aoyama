package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionCoWashablePriceEnum {

	// OptionForm
	// Key:OptionJacketWashableInfo option_code
	// ValueOne:OptionJacketWashableInfoのmethod
	// ValueTow:OptionJacketWashableInfoのmethod
	// ValueThree:Orderのmethod
	
	JK_Washable_OPTION_CODE01("00001","getWjFrontBtnCnt","","setJkFrtBtnRtPrice","wj_frontBtnCnt","","getJkFrtBtnRtPrice"),//フロント釦数
	JK_Washable_OPTION_CODE02("00002","getWjLapelDesign","","setJkLapelDesignRtPrice","wj_lapelDesign_id","","getJkLapelDesignRtPrice"),//ラペルデザイン
	JK_Washable_OPTION_CODE03("00003","getWjGrade","","setJkGradeRtPrice","wj_grade_id","","getJkGradeRtPrice"),//グレード
	JK_Washable_OPTION_CODE04("00004","getWjBackSpec","","setJkInnerClothRtPrice","wj_backSpec","","getJkInnerClothRtPrice"),//裏仕様
	JK_Washable_OPTION_CODE05("00005","getWjFort","","setJkDaibaRtPrice","wj_fort","","getJkDaibaRtPrice"),//台場
	JK_Washable_OPTION_CODE07("00007","getWjBackCollar","","setJkCollarInnerRtPrice","wj_backCollar_id","","getJkCollarInnerRtPrice"),//襟裏（ヒゲ）
	JK_Washable_OPTION_CODE08("00008","getWjChainHange","","setJkCollarHangRtPrice","wj_chainHange_id","","getJkCollarHangRtPrice"),//襟吊
	JK_Washable_OPTION_CODE09("00009","getWjLapelWidth","","setJkLapelWidthRtPrice","wj_lapelWidth_id","","getJkLapelWidthRtPrice"),//ラペル幅
	JK_Washable_OPTION_CODE10("00010","getWjFlowerHole","","setJkFlowerHoleRtPrice","wj_flowerHole","","getJkFlowerHoleRtPrice"),//フラワーホール
	JK_Washable_OPTION_CODE11("00011","getWjBreastPkt","","setJkBreastPktRtPrice","wj_breastPkt_id","","getJkBreastPktRtPrice"),//胸ポケット
	JK_Washable_OPTION_CODE12("00012","getWjWaistPkt","","setJkWaistPktRtPrice","wj_waistPkt","","getJkWaistPktRtPrice"),//腰ポケット
	JK_Washable_OPTION_CODE13("00013","getWjChangePkt","","setJkChgPktRtPrice","wj_changePkt_id","","getJkChgPktRtPrice"),//チェンジポケット
	JK_Washable_OPTION_CODE14("00014","getWjSlantedPkt","","setJkSlantedPktRtPrice","wj_slantedPkt_id","","getJkSlantedPktRtPrice"),//スランテッドポケット
	JK_Washable_OPTION_CODE15("00015","getWjCoinPkt","","setJkShinobiPktRtPrice","wj_coinPkt","","getJkShinobiPktRtPrice"),//忍びポケット
	JK_Washable_OPTION_CODE16("00016","getWjSleeveSpec","","setJkSleeveTypeRtPrice","wj_sleeveSpec_id","","getJkSleeveTypeRtPrice"),//袖仕様
	JK_Washable_OPTION_CODE17("00017","getWjManica","","setJkManicaRtPrice","wj_manica_id","","getJkManicaRtPrice"),//マニカ
	JK_Washable_OPTION_CODE18("00018","getWjSleeveBtnType","","setJkSleeveBtnRtPrice","wj_sleeveBtnTypeKasane_id","","getJkSleeveBtnRtPrice"),//袖釦
	JK_Washable_OPTION_CODE19("00019","getWjCuffSpec","","setJkCuffRtPrice","wj_cuffSpec_id","","getJkCuffRtPrice"),//袖口
	JK_Washable_OPTION_CODE20("00020","getWjInsidePktChange","","setJkInnerPktRtPrice","wj_insidePktChange_id","","getJkInnerPktRtPrice"),//内ポケット変更
	JK_Washable_OPTION_CODE22("00022","getWjBreastInnerPkt","","setJkRightInnerPktTypeRtPrice","wj_breastInnerPkt_id","","getJkRightInnerPktTypeRtPrice"),//下前胸内ポケット仕様
	JK_Washable_OPTION_CODE23("00051","getWjStitch","","setJkStitchTypeRtPrice","wj_stitch_id","","getJkStitchTypeRtPrice"),//ステッチ種類
	JK_Washable_OPTION_CODE24("00024","getWjStitchModify","","setJkStitchPlcRtPrice","wj_stitchModify_id","","getJkStitchPlcRtPrice"),//ステッチ箇所変更
	JK_Washable_OPTION_CODE26("00026","getWjDStitchModify","","setJkDblstitchPlcRtPrice","wj_dStitchModify_id","","getJkDblstitchPlcRtPrice"),//ダブルステッチ変更
	JK_Washable_OPTION_CODE28("00028","getWjAmfColor","","setJkAmfColorRtPrice","wj_amfColor_id","","getJkAmfColorRtPrice"),//AMF色指定
	JK_Washable_OPTION_CODE31("00031","getWjBhColor","","setJkBtnholePlcColorRtPrice","wj_bhColor_id","","getJkBtnholePlcColorRtPrice"),//ボタンホール色指定
	JK_Washable_OPTION_CODE34("00034","getWjByColor","","setJkBtnthreadPlcColorRtPrice","wj_byColor_id","","getJkBtnthreadPlcColorRtPrice"),//ボタン付け糸指定
	JK_Washable_OPTION_CODE37("00037","getWjVentSpec","","setJkVentRtPrice","wj_ventSpec_id","","getJkVentRtPrice"),//ベント
	JK_Washable_OPTION_CODE38("00038","getWjBodyBackMate","getWjBodyBackMateStkNo","setJkInnerBodyClothRtPrice","wj_bodyBackMate","wj_bodyBackMateStkNo","getJkInnerBodyClothRtPrice"),//胴裏素材
	JK_Washable_OPTION_CODE40("00040","getWjCuffBackMate","getWjCuffBackMateStkNo","setJkInnerSleeveClothRtPrice","wj_cuffBackMate","wj_cuffBackMateStkNo","getJkInnerSleeveClothRtPrice"),//袖裏素材
	JK_Washable_OPTION_CODE42("00042","getWjBtnMate","getWjBtnMateStkNo","setJkBtnMaterialRtPrice","wj_btnMate","wj_btnMateStkNo","getJkBtnMaterialRtPrice"),//釦素材
	JK_Washable_OPTION_CODE44("00044","getWjShapeMemory","","setJkShapeMemoryRtPrice","wj_shapeMemory_id","","getJkShapeMemoryRtPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
    
    private JacketOptionCoWashablePriceEnum(String key ,String valueOne , String valueTwo, String valueThree,
    		String valueFour,String valueFive,String valueSix) {
    	this.key = key;
    	this.valueOne = valueOne;
        this.valueTwo = valueTwo;
        this.valueThree = valueThree;
        this.valueFour = valueFour;
        this.valueFive = valueFive;
        this.valueSix = valueSix;
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
		return this.valueThree;
	}
	
	public String getValueFour() {
		return this.valueFour;
	}
	
	public String getValueFive() {
		return this.valueFive;
	}
    
	public String getValueSix() {
		return this.valueSix;
	}
    
	public String toString() {
        return this.key.concat(",").concat(this.valueOne).concat(",").concat(this.valueTwo).concat(",").concat(this.valueThree);
    }  
  
    public static JacketOptionCoWashablePriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionCoWashablePriceEnum get(String str) {
        for (JacketOptionCoWashablePriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
