package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionCoWashablePriceEnum {

	// OptionForm
	// Key:OptionJacketWashableInfo option_code
	// ValueOne:OptionJacketWashableInfoのmethod
	// ValueTow:OptionJacketWashableInfoのmethod
	// ValueThree:Orderのmethod
	
	JK_Washable_OPTION_CODE01("00001","getWjFrontBtnCnt","","setJkFrtBtnRtPrice"),//フロント釦数
	JK_Washable_OPTION_CODE02("00002","getWjLapelDesign","","setJkLapelDesignRtPrice"),//ラペルデザイン
	JK_Washable_OPTION_CODE03("00003","getWjGrade","","setJkGradeRtPrice"),//グレード
	JK_Washable_OPTION_CODE04("00004","getWjBackSpec","","setJkInnerClothRtPrice"),//裏仕様
	JK_Washable_OPTION_CODE05("00005","getWjFort","","setJkDaibaRtPrice"),//台場
	JK_Washable_OPTION_CODE07("00007","getWjBackCollar","","setJkCollarInnerRtPrice"),//襟裏（ヒゲ）
	JK_Washable_OPTION_CODE08("00008","getWjChainHange","","setJkCollarHangRtPrice"),//襟吊
	JK_Washable_OPTION_CODE09("00009","getWjLapelWidth","","setJkLapelWidthRtPrice"),//ラペル幅
	JK_Washable_OPTION_CODE10("00010","getWjFlowerHole","","setJkFlowerHoleRtPrice"),//フラワーホール
	JK_Washable_OPTION_CODE11("00011","getWjBreastPkt","","setJkBreastPktRtPrice"),//胸ポケット
	JK_Washable_OPTION_CODE12("00012","getWjWaistPkt","","setJkWaistPktRtPrice"),//腰ポケット
	JK_Washable_OPTION_CODE13("00013","getWjChangePkt","","setJkChgPktRtPrice"),//チェンジポケット
	JK_Washable_OPTION_CODE14("00014","getWjSlantedPkt","","setJkSlantedPktRtPrice"),//スランテッドポケット
	JK_Washable_OPTION_CODE15("00015","getWjCoinPkt","","setJkShinobiPktRtPrice"),//忍びポケット
	JK_Washable_OPTION_CODE16("00016","getWjSleeveSpec","","setJkSleeveTypeRtPrice"),//袖仕様
	JK_Washable_OPTION_CODE17("00017","getWjManica","","setJkManicaRtPrice"),//マニカ
	JK_Washable_OPTION_CODE18("00018","getWjSleeveBtnType","","setJkSleeveBtnRtPrice"),//袖釦
	JK_Washable_OPTION_CODE19("00019","getWjCuffSpec","","setJkCuffRtPrice"),//袖口
	JK_Washable_OPTION_CODE20("00020","getWjInsidePktChange","","setJkInnerPktRtPrice"),//内ポケット変更
	JK_Washable_OPTION_CODE22("00022","getWjBreastInnerPkt","","setJkRightInnerPktTypeRtPrice"),//下前胸内ポケット仕様
	JK_Washable_OPTION_CODE23("00023","getWjStitch","","setJkStitchTypeRtPrice"),//ステッチ種類
	JK_Washable_OPTION_CODE24("00024","getWjStitchModify","","setJkStitchPlcRtPrice"),//ステッチ箇所変更
	JK_Washable_OPTION_CODE26("00026","getWjDStitchModify","","setJkDblstitchPlcRtPrice"),//ダブルステッチ変更
	JK_Washable_OPTION_CODE28("00028","getWjAmfColor","","setJkAmfColorRtPrice"),//AMF色指定
	JK_Washable_OPTION_CODE31("00031","getWjBhColor","","setJkBtnholePlcColorRtPrice"),//ボタンホール色指定
	JK_Washable_OPTION_CODE34("00034","getWjByColor","","setJkBtnthreadPlcColorRtPrice"),//ボタン付け糸指定
	JK_Washable_OPTION_CODE37("00037","getWjVentSpec","","setJkVentRtPrice"),//ベント
	JK_Washable_OPTION_CODE38("00038","getWjBodyBackMate","getWjBodyBackMateStkNo","setJkInnerBodyClothRtPrice"),//胴裏素材
	JK_Washable_OPTION_CODE40("00040","getWjCuffBackMate","getWjCuffBackMateStkNo","setJkInnerSleeveClothRtPrice"),//袖裏素材
	JK_Washable_OPTION_CODE42("00042","getWjBtnMate","getWjBtnMateStkNo","setJkBtnMaterialRtPrice"),//釦素材
	JK_Washable_OPTION_CODE44("00044","getWjShapeMemory","","setJkShapeMemoryRtPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private JacketOptionCoWashablePriceEnum(String k ,String v1 , String v2, String v3) {
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
