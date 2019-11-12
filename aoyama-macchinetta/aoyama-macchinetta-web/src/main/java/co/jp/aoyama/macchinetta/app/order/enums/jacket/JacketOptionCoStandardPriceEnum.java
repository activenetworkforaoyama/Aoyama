package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionCoStandardPriceEnum {

	// OptionForm
	// Key:OptionJacketStandardInfo option_code
	// ValueOne:OptionJacketStandardInfoのmethod
	// ValueTow:OptionJacketStandardInfoのmethod
	// ValueThree:Orderのmethod
	
	JK_Standard_OPTION_CODE01("00001","getOjFrontBtnCnt","","setJkFrtBtnRtPrice","oj_frontBtnCnt","","getJkFrtBtnRtPrice"),//フロント釦数
	JK_Standard_OPTION_CODE02("00002","getOjLapelDesign","","setJkLapelDesignRtPrice","lapelDesign_id","","getJkLapelDesignRtPrice"),//ラペルデザイン
	JK_Standard_OPTION_CODE03("00003","getOjGrade","","setJkGradeRtPrice","grade_id","","getJkGradeRtPrice"),//グレード
	JK_Standard_OPTION_CODE04("00004","getOjGackSpec","","setJkInnerClothRtPrice","backSpec","","getJkInnerClothRtPrice"),//裏仕様
	JK_Standard_OPTION_CODE05("00005","getOjFort","","setJkDaibaRtPrice","fort","","getJkDaibaRtPrice"),//台場
	JK_Standard_OPTION_CODE07("00007","getOjBackCollar","","setJkCollarInnerRtPrice","backCollar_id","","getJkCollarInnerRtPrice"),//襟裏（ヒゲ）
	JK_Standard_OPTION_CODE08("00008","getOjChainHange","","setJkCollarHangRtPrice","chainHange_id","","getJkCollarHangRtPrice"),//襟吊
	JK_Standard_OPTION_CODE09("00009","getOjLapelWidth","","setJkLapelWidthRtPrice","lapelWidth_id","","getJkLapelWidthRtPrice"),//ラペル幅
	JK_Standard_OPTION_CODE10("00010","getOjFlowerHole","","setJkFlowerHoleRtPrice","flowerHole","","getJkFlowerHoleRtPrice"),//フラワーホール
	JK_Standard_OPTION_CODE11("00011","getOjBreastPkt","","setJkBreastPktRtPrice","breastPkt_id","","getJkBreastPktRtPrice"),//胸ポケット
	JK_Standard_OPTION_CODE12("00012","getOjWaistPkt","","setJkWaistPktRtPrice","waistPkt","","getJkWaistPktRtPrice"),//腰ポケット
	JK_Standard_OPTION_CODE13("00013","getOjChangePkt","","setJkChgPktRtPrice","changePkt_id","","getJkChgPktRtPrice"),//チェンジポケット
	JK_Standard_OPTION_CODE14("00014","getOjSlantedPkt","","setJkSlantedPktRtPrice","slantedPkt_id","","getJkSlantedPktRtPrice"),//スランテッドポケット
	JK_Standard_OPTION_CODE15("00015","getOjCoinPkt","","setJkShinobiPktRtPrice","coinPkt","","getJkShinobiPktRtPrice"),//忍びポケット
	JK_Standard_OPTION_CODE16("00016","getOjSleeveSpec","","setJkSleeveTypeRtPrice","sleeveSpec_id","","getJkSleeveTypeRtPrice"),//袖仕様
	JK_Standard_OPTION_CODE17("00017","getOjManica","","setJkManicaRtPrice","manica_id","","getJkManicaRtPrice"),//マニカ
	JK_Standard_OPTION_CODE18("00018","getOjSleeveBtnType","","setJkSleeveBtnRtPrice","sleeveBtnType_id","","getJkSleeveBtnRtPrice"),//袖釦
	JK_Standard_OPTION_CODE19("00019","getOjCuffSpec","","setJkCuffRtPrice","cuffSpec_id","","getJkCuffRtPrice"),//袖口
	JK_Standard_OPTION_CODE20("00020","getOjInsidePktChange","","setJkInnerPktRtPrice","insidePktChange_id","","getJkInnerPktRtPrice"),//内ポケット変更
	JK_Standard_OPTION_CODE22("00022","getOjBreastInnerPkt","","setJkRightInnerPktTypeRtPrice","breastInnerPkt_id","","getJkRightInnerPktTypeRtPrice"),//下前胸内ポケット仕様
	JK_Standard_OPTION_CODE23("00051","getOjStitch","","setJkStitchTypeRtPrice","stitch_id","","getJkStitchTypeRtPrice"),//ステッチ種類
	JK_Standard_OPTION_CODE24("00024","getOjStitchModify","","setJkStitchPlcRtPrice","stitchModify_id","","getJkStitchPlcRtPrice"),//ステッチ箇所変更
	JK_Standard_OPTION_CODE26("00026","getOjDStitchModify","","setJkDblstitchPlcRtPrice","dStitchModify_id","","getJkDblstitchPlcRtPrice"),//ダブルステッチ変更
	JK_Standard_OPTION_CODE28("00028","getOjAmfColor","","setJkAmfColorRtPrice","amfColor_id","","getJkAmfColorRtPrice"),//AMF色指定
	JK_Standard_OPTION_CODE31("00031","getOjBhColor","","setJkBtnholePlcColorRtPrice","bhColor_id","","getJkBtnholePlcColorRtPrice"),//ボタンホール色指定
	JK_Standard_OPTION_CODE34("00034","getOjByColor","","setJkBtnthreadPlcColorRtPrice","byColor_id","","getJkBtnthreadPlcColorRtPrice"),//ボタン付け糸指定
	JK_Standard_OPTION_CODE37("00037","getOjVentSpec","","setJkVentRtPrice","ventSpec_id","","getJkVentRtPrice"),//ベント
	JK_Standard_OPTION_CODE38("00038","getOjBodyBackMate","getOjBodyBackMateStkNo","setJkInnerBodyClothRtPrice","bodyBackMate","bodyBackMateStkNo","getJkInnerBodyClothRtPrice"),//胴裏素材
	JK_Standard_OPTION_CODE40("00040","getOjCuffBackMate","getOjCuffBackMateStkNo","setJkInnerSleeveClothRtPrice","cuffBackMate","cuffBackMateStkNo","getJkInnerSleeveClothRtPrice"),//袖裏素材
	JK_Standard_OPTION_CODE42("00042","getOjBtnMate","getOjBtnMateStkNo","setJkBtnMaterialRtPrice","btnMate","btnMateStkNo","getJkBtnMaterialRtPrice"),//釦素材
	JK_Standard_OPTION_CODE44("00044","getOjShapeMemory","","setJkShapeMemoryRtPrice","shapeMemory_id","","getJkShapeMemoryRtPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
	private final String valueFour;
	private final String valueFive;
	private final String valueSix;
    
    private JacketOptionCoStandardPriceEnum(String key ,String valueOne , String valueTwo, String valueThree,
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
  
    public static JacketOptionCoStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionCoStandardPriceEnum get(String str) {
        for (JacketOptionCoStandardPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
