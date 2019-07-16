package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionStandardCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	JK_Standard_OPTION_CODE01("00001","setOjFrontBtnCntMap"),
	JK_Standard_OPTION_CODE02("00002","setOjLapelDesignMap"),
	JK_Standard_OPTION_CODE03("00003","setOjGradeMap"),
	JK_Standard_OPTION_CODE04("00004","setOjGackSpecMap"),
	JK_Standard_OPTION_CODE05("00005","setOjFortMap"),
	JK_Standard_OPTION_CODE07("00007","setOjBackCollarMap"),
	JK_Standard_OPTION_CODE08("00008","setOjChainHangeMap"),
	JK_Standard_OPTION_CODE09("00009","setOjLapelWidthMap"),
	JK_Standard_OPTION_CODE10("00010","setOjFlowerHoleMap"),
	JK_Standard_OPTION_CODE11("00011","setOjBreastPktMap"),
	JK_Standard_OPTION_CODE12("00012","setOjWaistPktMap"),
	JK_Standard_OPTION_CODE13("00013","setOjChangePktMap"),
	JK_Standard_OPTION_CODE14("00014","setOjSlantedPktMap"),
	JK_Standard_OPTION_CODE15("00015","setOjCoinPktMap"),
	JK_Standard_OPTION_CODE16("00016","setOjSleeveSpecMap"),
	JK_Standard_OPTION_CODE17("00017","setOjManicaMap"),
	JK_Standard_OPTION_CODE18("00018","setOjSleeveBtnTypeMap"),
	JK_Standard_OPTION_CODE19("00019","setOjCuffSpecMap"),
	JK_Standard_OPTION_CODE20("00020","setOjInsidePktChangeMap"),
	JK_Standard_OPTION_CODE21("00021","setOjInsidePktPlaceMap"),
	JK_Standard_OPTION_CODE22("00022","setOjBreastInnerPktMap"),
	JK_Standard_OPTION_CODE23("00023","setOjStitchMap"),
	JK_Standard_OPTION_CODE24("00024","setOjStitchModifyMap"),
	JK_Standard_OPTION_CODE25("00025","setOjStitchModifyPlaceMap"),
	JK_Standard_OPTION_CODE26("00026","setOjDStitchModifyMap"),
	JK_Standard_OPTION_CODE27("00027","setOjDStitchModifyPlaceMap"),
	JK_Standard_OPTION_CODE28("00028","setOjAmfColorMap"),
	JK_Standard_OPTION_CODE29("00029","setOjAmfColorPlaceMap"),
	JK_Standard_OPTION_CODE30("00030","setOjAmfColorPlaceAllMap"),
	JK_Standard_OPTION_CODE31("00031","setOjBhColorMap"),
	JK_Standard_OPTION_CODE32("00032","setOjBhColorPlaceMap"),
	JK_Standard_OPTION_CODE33("00033","setOjBhColorPlaceAllMap"),
	JK_Standard_OPTION_CODE34("00034","setOjByColorMap"),
	JK_Standard_OPTION_CODE35("00035","setOjByColorPlaceMap"),
	JK_Standard_OPTION_CODE36("00036","setOjByColorPlaceAllMap"),
	JK_Standard_OPTION_CODE37("00037","setOjVentSpecMap"),
	JK_Standard_OPTION_CODE38("00038","setOjBodyBackMateMap"),
	JK_Standard_OPTION_CODE40("00040","setOjCuffBackMateMap"),
	JK_Standard_OPTION_CODE42("00042","setOjBtnMateMap"),
	JK_Standard_OPTION_CODE44("00044","setOjShapeMemoryMap");
	
	private final String key;
	private final String value;
    
    private JacketOptionStandardCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static JacketOptionStandardCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionStandardCodeEnum get(String str) {
        for (JacketOptionStandardCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
