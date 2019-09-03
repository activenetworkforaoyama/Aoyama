package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionCoTuxedoPriceEnum {

	// OptionForm
	// Key:OptionJacketTuxedoInfo option_code
	// ValueOne:OptionJacketTuxedoInfoのmethod
	// ValueTow:OptionJacketTuxedoInfoのmethod
	// ValueThree:Orderのmethod
	
	JK_Tuxedo_OPTION_CODE01("00001","getTjFrontBtnCnt","","setJkFrtBtnRtPrice"),//フロント釦数
	JK_Tuxedo_OPTION_CODE02("00002","getTjLapelDesign","","setJkLapelDesignRtPrice"),//ラペルデザイン
	JK_Tuxedo_OPTION_CODE03("00003","getTjGrade","","setJkGradeRtPrice"),//グレード
	JK_Tuxedo_OPTION_CODE04("00004","getTjBackSpec","","setJkInnerClothRtPrice"),//裏仕様
	JK_Tuxedo_OPTION_CODE05("00005","getTjFort","","setJkDaibaRtPrice"),//台場
	JK_Tuxedo_OPTION_CODE06("00006","getTjGlossFablic","","setJkLookClothRtPrice"),//拝見地
	JK_Tuxedo_OPTION_CODE07("00007","getTjBackSpec","","setJkCollarInnerRtPrice"),//襟裏（ヒゲ）
	JK_Tuxedo_OPTION_CODE08("00008","getTjChainHange","","setJkCollarHangRtPrice"),//襟吊
	JK_Tuxedo_OPTION_CODE09("00009","getTjLapelWidth","","setJkLapelWidthRtPrice"),//ラペル幅
	JK_Tuxedo_OPTION_CODE10("00010","getTjFlowerHole","","setJkFlowerHoleRtPrice"),//フラワーホール
	JK_Tuxedo_OPTION_CODE11("00011","getTjBreastPkt","","setJkBreastPktRtPrice"),//胸ポケット
	JK_Tuxedo_OPTION_CODE12("00012","getTjWaistPkt","","setJkWaistPktRtPrice"),//腰ポケット
	JK_Tuxedo_OPTION_CODE13("00013","getTjChangePkt","","setJkChgPktRtPrice"),//チェンジポケット
	JK_Tuxedo_OPTION_CODE14("00014","getTjSlantedPkt","","setJkSlantedPktRtPrice"),//スランテッドポケット
	JK_Tuxedo_OPTION_CODE15("00015","getTjCoinPkt","","setJkShinobiPktRtPrice"),//忍びポケット
	JK_Tuxedo_OPTION_CODE16("00016","getTjSleeveSpec","","setJkSleeveTypeRtPrice"),//袖仕様
	JK_Tuxedo_OPTION_CODE17("00017","getTjManica","","setJkManicaRtPrice"),//マニカ
	JK_Tuxedo_OPTION_CODE18("00018","getTjSleeveBtnType","","setJkSleeveBtnRtPrice"),//袖釦
	JK_Tuxedo_OPTION_CODE19("00019","getTjCuffSpec","","setJkCuffRtPrice"),//袖口
	JK_Tuxedo_OPTION_CODE20("00020","getTjInsidePktChange","","setJkInnerPktRtPrice"),//内ポケット変更
	JK_Tuxedo_OPTION_CODE22("00022","getTjBreastInnerPkt","","setJkRightInnerPktTypeRtPrice"),//下前胸内ポケット仕様
	JK_Tuxedo_OPTION_CODE23("00023","getTjStitch","","setJkStitchTypeRtPrice"),//ステッチ種類
	JK_Tuxedo_OPTION_CODE31("00031","getTjBhColor","","setJkBtnholePlcColorRtPrice"),//ボタンホール色指定
	JK_Tuxedo_OPTION_CODE34("00034","getTjByColor","","setJkBtnthreadPlcColorRtPrice"),//ボタン付け糸指定
	JK_Tuxedo_OPTION_CODE37("00037","getTjVentSpec","","setJkVentRtPrice"),//ベント
	JK_Tuxedo_OPTION_CODE38("00038","getTjBodyBackMate","getTjBodyBackMateStkNo","setJkInnerBodyClothRtPrice"),//胴裏素材
	JK_Tuxedo_OPTION_CODE40("00040","getTjCuffBackMate","getTjCuffBackMateStkNo","setJkInnerSleeveClothRtPrice"),//袖裏素材
	JK_Tuxedo_OPTION_CODE42("00042","getTjBtnMate","getTjBtnMateStkNo","setJkBtnMaterialRtPrice"),//釦素材
	JK_Tuxedo_OPTION_CODE44("00044","getTjShapeMemory","","setJkShapeMemoryRtPrice");//形状記憶
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private JacketOptionCoTuxedoPriceEnum(String k ,String v1 , String v2, String v3) {
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
