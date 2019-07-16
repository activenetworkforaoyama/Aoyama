package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionStandardPriceEnum {

	// OptionForm
	// Key:OptionJacketStandardInfo option_code
	// ValueOne:OptionJacketStandardInfoのmethod
	// ValueTow:OptionJacketStandardInfoのmethod
	// ValueThree:Orderのmethod
	
	JK_Standard_OPTION_CODE01("00001","getOjFrontBtnCnt","","setJkFrtBtnRtPrice"),
	JK_Standard_OPTION_CODE02("00002","getOjLapelDesign","","setJkLapelDesignRtPrice"),
//	JK_Standard_OPTION_CODE03("00003","getOjGrade","","setJkGradeRtPrice"),
	JK_Standard_OPTION_CODE04("00004","getOjGackSpec","","setJkInnerClothRtPrice"),
	JK_Standard_OPTION_CODE05("00005","getOjFort","","setJkDaibaRtPrice"),
//	JK_Standard_OPTION_CODE07("00007","getOjBackCollar","","setJkCollarInnerRtPrice"),
//	JK_Standard_OPTION_CODE08("00008","getOjChainHange","","setJkCollarHangRtPrice"),
//	JK_Standard_OPTION_CODE09("00009","getOjLapelWidth","","setJkLapelWidthRtPrice"),
//	JK_Standard_OPTION_CODE10("00010","getOjFlowerHole","","setJkFlowerHoleRtPrice"),
//	JK_Standard_OPTION_CODE11("00011","getOjBreastPkt","","setJkBreastPktRtPrice"),
	JK_Standard_OPTION_CODE12("00012","getOjWaistPkt","","setJkWaistPktRtPrice"),
	JK_Standard_OPTION_CODE13("00013","getOjChangePkt","","setJkChgPktRtPrice"),
	JK_Standard_OPTION_CODE14("00014","getOjSlantedPkt","","setJkSlantedPktRtPrice"),
//	JK_Standard_OPTION_CODE15("00015","getOjCoinPkt","","setJkShinobiPktRtPrice"),
//	JK_Standard_OPTION_CODE16("00016","getOjSleeveSpec","","setJkSleeveTypeRtPrice"),
//	JK_Standard_OPTION_CODE17("00017","getOjManica","","setJkManicaRtPrice"),
//	JK_Standard_OPTION_CODE18("00018","getOjSleeveBtnType","","setJkSleeveBtnRtPrice"),
	JK_Standard_OPTION_CODE19("00019","getOjCuffSpec","","setJkCuffRtPrice"),
//	JK_Standard_OPTION_CODE20("00020","getOjInsidePktChange","","setJkInnerPktRtPrice"),
//	JK_Standard_OPTION_CODE21("00021","setOjInsidePktPlaceMap","","getOjInsidePktPlace"),
//	JK_Standard_OPTION_CODE22("00022","getOjBreastInnerPkt","","setJkRightInnerPktTypeRtPrice"),
	JK_Standard_OPTION_CODE23("00023","getOjStitch","","setJkStitchTypeRtPrice"),
//	JK_Standard_OPTION_CODE24("00024","getOjStitchModify","",""),
//	JK_Standard_OPTION_CODE25("00025","getOjStitchModifyPlace","","setJkStitchPlcRtPrice"),
//	JK_Standard_OPTION_CODE26("00026","getOjDStitchModify","",""),
//	JK_Standard_OPTION_CODE27("00027","getOjDStitchModifyPlace","","setJkDblstitchPlcRtPrice"),
//	JK_Standard_OPTION_CODE28("00028","setOjAmfColorMap","",""),
//	JK_Standard_OPTION_CODE29("00029","setOjAmfColorPlaceMap","",""),
//	JK_Standard_OPTION_CODE30("00030","setOjAmfColorPlaceAllMap","",""),
//	JK_Standard_OPTION_CODE31("00031","setOjBhColorMap","",""),
//	JK_Standard_OPTION_CODE32("00032","setOjBhColorPlaceMap","",""),
//	JK_Standard_OPTION_CODE33("00033","setOjBhColorPlaceAllMap","",""),
//	JK_Standard_OPTION_CODE34("00034","setOjByColorMap","",""),
//	JK_Standard_OPTION_CODE35("00035","setOjByColorPlaceMap","",""),
//	JK_Standard_OPTION_CODE36("00036","setOjByColorPlaceAllMap","",""),
	JK_Standard_OPTION_CODE37("00037","getOjVentSpec","","setJkVentRtPrice"),
	JK_Standard_OPTION_CODE38("00038","getOjBodyBackMate","getOjBodyBackMateStkNo","setJkInnerBodyClothRtPrice"),
	JK_Standard_OPTION_CODE40("00040","getOjCuffBackMate","getOjCuffBackMateStkNo","setJkInnerSleeveClothRtPrice"),
	JK_Standard_OPTION_CODE42("00042","getOjBtnMate","getOjBtnMateStkNo","setJkBtnMaterialRtPrice");
//	JK_Standard_OPTION_CODE44("00044","getOjShapeMemory","","setJkShapeMemoryRtPrice");
	
	
	private final String key;
	private final String valueOne;
	private final String valueTwo;
	private final String valueThree;
    
    private JacketOptionStandardPriceEnum(String k ,String v1 , String v2, String v3) {
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
  
    public static JacketOptionStandardPriceEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionStandardPriceEnum get(String str) {
        for (JacketOptionStandardPriceEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
