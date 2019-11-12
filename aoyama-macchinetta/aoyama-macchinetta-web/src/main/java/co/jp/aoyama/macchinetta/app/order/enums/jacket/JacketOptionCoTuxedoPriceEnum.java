package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionCoTuxedoPriceEnum {

	// OptionForm
	// Key:OptionJacketTuxedoInfo option_code
	// ValueOne:OptionJacketTuxedoInfoのmethod
	// ValueTow:OptionJacketTuxedoInfoのmethod
	// ValueThree:Orderのmethod
	
	JK_Tuxedo_OPTION_CODE01("00001","getTjFrontBtnCnt","","setJkFrtBtnRtPrice","tj_frontBtnCnt","","getJkFrtBtnRtPrice"),//フロント釦数
	JK_Tuxedo_OPTION_CODE02("00002","getTjLapelDesign","","setJkLapelDesignRtPrice","tj_lapelDesign_id","","getJkLapelDesignRtPrice"),//ラペルデザイン
	JK_Tuxedo_OPTION_CODE03("00003","getTjGrade","","setJkGradeRtPrice","tj_grade_id","","getJkGradeRtPrice"),//グレード
	JK_Tuxedo_OPTION_CODE04("00004","getTjBackSpec","","setJkInnerClothRtPrice","tj_backSpec","","getJkInnerClothRtPrice"),//裏仕様
	JK_Tuxedo_OPTION_CODE05("00005","getTjFort","","setJkDaibaRtPrice","tj_fort","","getJkDaibaRtPrice"),//台場
	JK_Tuxedo_OPTION_CODE06("00050","getTjGlossFablic","","setJkLookClothRtPrice","tj_GlossFablic","","getJkLookClothRtPrice"),//拝見地
	JK_Tuxedo_OPTION_CODE07("00007","getTjBackCollar","","setJkCollarInnerRtPrice","tj_backCollar_id","","getJkCollarInnerRtPrice"),//襟裏（ヒゲ）
	JK_Tuxedo_OPTION_CODE08("00008","getTjChainHange","","setJkCollarHangRtPrice","tj_chainHange_id","","getJkCollarHangRtPrice"),//襟吊
	JK_Tuxedo_OPTION_CODE09("00009","getTjLapelWidth","","setJkLapelWidthRtPrice","tj_lapelWidth_id","","getJkLapelWidthRtPrice"),//ラペル幅
	JK_Tuxedo_OPTION_CODE10("00010","getTjFlowerHole","","setJkFlowerHoleRtPrice","tj_flowerHole","","getJkFlowerHoleRtPrice"),//フラワーホール
	JK_Tuxedo_OPTION_CODE11("00011","getTjBreastPkt","","setJkBreastPktRtPrice","tj_breastPkt_id","","getJkBreastPktRtPrice"),//胸ポケット
	JK_Tuxedo_OPTION_CODE12("00012","getTjWaistPkt","","setJkWaistPktRtPrice","tj_waistPkt","","getJkWaistPktRtPrice"),//腰ポケット
	JK_Tuxedo_OPTION_CODE13("00013","getTjChangePkt","","setJkChgPktRtPrice","tj_changePkt_id","","getJkChgPktRtPrice"),//チェンジポケット
	JK_Tuxedo_OPTION_CODE14("00014","getTjSlantedPkt","","setJkSlantedPktRtPrice","tj_slantedPkt_id","","getJkSlantedPktRtPrice"),//スランテッドポケット
	JK_Tuxedo_OPTION_CODE15("00015","getTjCoinPkt","","setJkShinobiPktRtPrice","tj_coinPkt","","getJkShinobiPktRtPrice"),//忍びポケット
	JK_Tuxedo_OPTION_CODE16("00016","getTjSleeveSpec","","setJkSleeveTypeRtPrice","tj_sleeveSpec_id","","getJkSleeveTypeRtPrice"),//袖仕様
	JK_Tuxedo_OPTION_CODE17("00017","getTjManica","","setJkManicaRtPrice","tj_manica_id","","getJkManicaRtPrice"),//マニカ
	JK_Tuxedo_OPTION_CODE18("00018","getTjSleeveBtnType","","setJkSleeveBtnRtPrice","tj_sleeveBtnType_id","","getJkSleeveBtnRtPrice"),//袖釦
	JK_Tuxedo_OPTION_CODE19("00019","getTjCuffSpec","","setJkCuffRtPrice","tj_cuffSpec_id","","getJkCuffRtPrice"),//袖口
	JK_Tuxedo_OPTION_CODE20("00020","getTjInsidePktChange","","setJkInnerPktRtPrice","tj_insidePktChange_id","","getJkInnerPktRtPrice"),//内ポケット変更
	JK_Tuxedo_OPTION_CODE22("00022","getTjBreastInnerPkt","","setJkRightInnerPktTypeRtPrice","tj_breastInnerPkt_id","","getJkRightInnerPktTypeRtPrice"),//下前胸内ポケット仕様
	JK_Tuxedo_OPTION_CODE23("00051","getTjStitch","","setJkStitchTypeRtPrice","tj_stitch_id","","getJkStitchTypeRtPrice"),//ステッチ種類
	JK_Tuxedo_OPTION_CODE31("00031","getTjBhColor","","setJkBtnholePlcColorRtPrice","tj_bhColor_id","","getJkBtnholePlcColorRtPrice"),//ボタンホール色指定
	JK_Tuxedo_OPTION_CODE34("00034","getTjByColor","","setJkBtnthreadPlcColorRtPrice","tj_byColor_id","","getJkBtnthreadPlcColorRtPrice"),//ボタン付け糸指定
	JK_Tuxedo_OPTION_CODE37("00037","getTjVentSpec","","setJkVentRtPrice","tj_ventSpec_id","","getJkVentRtPrice"),//ベント
	JK_Tuxedo_OPTION_CODE38("00038","getTjBodyBackMate","getTjBodyBackMateStkNo","setJkInnerBodyClothRtPrice","tj_bodyBackMate","tj_bodyBackMateStkNo","getJkInnerBodyClothRtPrice"),//胴裏素材
	JK_Tuxedo_OPTION_CODE40("00040","getTjCuffBackMate","getTjCuffBackMateStkNo","setJkInnerSleeveClothRtPrice","tj_cuffBackMate","tj_cuffBackMateStkNo","getJkInnerSleeveClothRtPrice"),//袖裏素材
	JK_Tuxedo_OPTION_CODE42("00042","getTjBtnMate","getTjBtnMateStkNo","setJkBtnMaterialRtPrice","tj_btnMate","tj_btnMateStkNo","getJkBtnMaterialRtPrice"),//釦素材
	JK_Tuxedo_OPTION_CODE44("00044","getTjShapeMemory","","setJkShapeMemoryRtPrice","tj_shapeMemory_id","","getJkShapeMemoryRtPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
    
    private JacketOptionCoTuxedoPriceEnum(String key ,String valueOne , String valueTwo, String valueThree,
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
  
    public static JacketOptionCoTuxedoPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionCoTuxedoPriceEnum get(String str) {
        for (JacketOptionCoTuxedoPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
