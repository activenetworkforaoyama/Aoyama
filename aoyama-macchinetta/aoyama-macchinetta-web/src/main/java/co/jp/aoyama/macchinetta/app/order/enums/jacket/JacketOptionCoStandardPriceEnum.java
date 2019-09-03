package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionCoStandardPriceEnum {

	// OptionForm
	// Key:OptionJacketStandardInfo option_code
	// ValueOne:OptionJacketStandardInfoのmethod
	// ValueTow:OptionJacketStandardInfoのmethod
	// ValueThree:Orderのmethod
	
	JK_Standard_OPTION_CODE01("00001","getOjFrontBtnCnt","","setJkFrtBtnRtPrice"),//フロント釦数
	JK_Standard_OPTION_CODE02("00002","getOjLapelDesign","","setJkLapelDesignRtPrice"),//ラペルデザイン
	JK_Standard_OPTION_CODE03("00003","getOjGrade","","setJkGradeRtPrice"),//グレード
	JK_Standard_OPTION_CODE04("00004","getOjGackSpec","","setJkInnerClothRtPrice"),//裏仕様
	JK_Standard_OPTION_CODE05("00005","getOjFort","","setJkDaibaRtPrice"),//台場
	JK_Standard_OPTION_CODE07("00007","getOjBackCollar","","setJkCollarInnerRtPrice"),//襟裏（ヒゲ）
	JK_Standard_OPTION_CODE08("00008","getOjChainHange","","setJkCollarHangRtPrice"),//襟吊
	JK_Standard_OPTION_CODE09("00009","getOjLapelWidth","","setJkLapelWidthRtPrice"),//ラペル幅
	JK_Standard_OPTION_CODE10("00010","getOjFlowerHole","","setJkFlowerHoleRtPrice"),//フラワーホール
	JK_Standard_OPTION_CODE11("00011","getOjBreastPkt","","setJkBreastPktRtPrice"),//胸ポケット
	JK_Standard_OPTION_CODE12("00012","getOjWaistPkt","","setJkWaistPktRtPrice"),//腰ポケット
	JK_Standard_OPTION_CODE13("00013","getOjChangePkt","","setJkChgPktRtPrice"),//チェンジポケット
	JK_Standard_OPTION_CODE14("00014","getOjSlantedPkt","","setJkSlantedPktRtPrice"),//スランテッドポケット
	JK_Standard_OPTION_CODE15("00015","getOjCoinPkt","","setJkShinobiPktRtPrice"),//忍びポケット
	JK_Standard_OPTION_CODE16("00016","getOjSleeveSpec","","setJkSleeveTypeRtPrice"),//袖仕様
	JK_Standard_OPTION_CODE17("00017","getOjManica","","setJkManicaRtPrice"),//マニカ
	JK_Standard_OPTION_CODE18("00018","getOjSleeveBtnType","","setJkSleeveBtnRtPrice"),//袖釦
	JK_Standard_OPTION_CODE19("00019","getOjCuffSpec","","setJkCuffRtPrice"),//袖口
	JK_Standard_OPTION_CODE20("00020","getOjInsidePktPlace","","setJkInnerPktRtPrice"),//内ポケット変更
	JK_Standard_OPTION_CODE22("00022","getOjBreastInnerPkt","","setJkRightInnerPktTypeRtPrice"),//下前胸内ポケット仕様
	JK_Standard_OPTION_CODE23("00023","getOjStitch","","setJkStitchTypeRtPrice"),//ステッチ種類
	JK_Standard_OPTION_CODE24("00024","getOjStitchModify","","setJkStitchPlcRtPrice"),//ステッチ箇所変更
	JK_Standard_OPTION_CODE26("00026","getOjDStitchModify","","setJkDblstitchPlcRtPrice"),//ダブルステッチ変更
	JK_Standard_OPTION_CODE28("00028","getOjAmfColor","","setJkAmfColorRtPrice"),//AMF色指定
	JK_Standard_OPTION_CODE31("00031","getOjBhColor","","setJkBtnholePlcColorRtPrice"),//ボタンホール色指定
	JK_Standard_OPTION_CODE34("00034","getOjByColor","","setJkBtnthreadPlcColorRtPrice"),//ボタン付け糸指定
	JK_Standard_OPTION_CODE37("00037","getOjVentSpec","","setJkVentRtPrice"),//ベント
	JK_Standard_OPTION_CODE38("00038","getOjBodyBackMate","getOjBodyBackMateStkNo","setJkInnerBodyClothRtPrice"),//胴裏素材
	JK_Standard_OPTION_CODE40("00040","getOjCuffBackMate","getOjCuffBackMateStkNo","setJkInnerSleeveClothRtPrice"),//袖裏素材
	JK_Standard_OPTION_CODE42("00042","getOjBtnMate","getOjBtnMateStkNo","setJkBtnMaterialRtPrice"),//釦素材
	JK_Standard_OPTION_CODE44("00044","getOjShapeMemory","","setJkShapeMemoryRtPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private JacketOptionCoStandardPriceEnum(String k ,String v1 , String v2, String v3) {
    	this.key = k;
    	this.valueOne = v1;
        this.valueTwo = v2;
        this.valueThree =v3;
    }  

	public String getKey() {
		return this.key;
	}
	 
	public String getValue() {
		return this.valueOne;
	}
	
	public String getValue2() {
		return this.valueTwo;
	}
    
	public String getValue3() {
		return this.valueThree;
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
