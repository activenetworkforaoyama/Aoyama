package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionWashableCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	JK_Washabi_OPTION_CODE01("00001","setWjFrontBtnCntMap"),
	JK_Washabi_OPTION_CODE02("00002","setWjLapelDesignMap"),
	JK_Washabi_OPTION_CODE03("00003","setWjGradeMap"),
	JK_Washabi_OPTION_CODE04("00004","setWjBackSpecMap"),
	JK_Washabi_OPTION_CODE05("00005","setWjFortMap"),
	JK_Washabi_OPTION_CODE07("00007","setWjBackCollarMap"),
	JK_Washabi_OPTION_CODE08("00008","setWjChainHangeMap"),
	JK_Washabi_OPTION_CODE09("00009","setWjLapelWidthMap"),
	JK_Washabi_OPTION_CODE10("00010","setWjFlowerHoleMap"),
	JK_Washabi_OPTION_CODE11("00011","setWjBreastPktMap"),
	JK_Washabi_OPTION_CODE12("00012","setWjWaistPktMap"),
	JK_Washabi_OPTION_CODE13("00013","setWjChangePktMap"),
	JK_Washabi_OPTION_CODE14("00014","setWjSlantedPktMap"),
	JK_Washabi_OPTION_CODE15("00015","setWjCoinPktMap"),
	JK_Washabi_OPTION_CODE16("00016","setWjSleeveSpecMap"),
	JK_Washabi_OPTION_CODE17("00017","setWjManicaMap"),
	JK_Washabi_OPTION_CODE18("00018","setWjSleeveBtnTypeMap"),
	JK_Washabi_OPTION_CODE19("00019","setWjCuffSpecMap"),
	JK_Washabi_OPTION_CODE20("00020","setWjInsidePktChangeMap"),
	JK_Washabi_OPTION_CODE22("00022","setWjBreastInnerPktMap"),
	JK_Washabi_OPTION_CODE23("00023","setWjStitchMap"),
	JK_Washabi_OPTION_CODE24("00024","setWjStitchModifyMap"),
	JK_Washabi_OPTION_CODE25("00025","setWjStitchModifyPlaceMap"),
	JK_Washabi_OPTION_CODE26("00026","setWjDStitchModifyMap"),
	JK_Washabi_OPTION_CODE27("00027","setWjDStitchModifyPlaceMap"),
	JK_Washabi_OPTION_CODE28("00028","setWjAmfColorMap"),
	JK_Washabi_OPTION_CODE29("00029","setWjAmfColorPlaceMap"),
	JK_Washabi_OPTION_CODE30("00030","setWjAmfColorPlaceAllMap"),
	JK_Washabi_OPTION_CODE31("00031","setWjBhColorMap"),
	JK_Washabi_OPTION_CODE32("00032","setWjBhColorPlaceMap"),
	JK_Washabi_OPTION_CODE33("00033","setWjBhColorPlaceAllMap"),
	JK_Washabi_OPTION_CODE34("00034","setWjByColorMap"),
	JK_Washabi_OPTION_CODE35("00035","setWjByColorPlaceMap"),
	JK_Washabi_OPTION_CODE36("00036","setWjByColorPlaceAllMap"),
	JK_Washabi_OPTION_CODE37("00037","setWjVentSpecMap"),
	JK_Washabi_OPTION_CODE38("00038","setWjBodyBackMateMap"),
	JK_Washabi_OPTION_CODE40("00040","setWjCuffBackMateMap"),
	JK_Washabi_OPTION_CODE42("00042","setWjBtnMateMap"),
	JK_Washabi_OPTION_CODE44("00044","setWjShapeMemoryMap");
	
	
	private final String key;
	private final String value;
    
    private JacketOptionWashableCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static JacketOptionWashableCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionWashableCodeEnum get(String str) {
        for (JacketOptionWashableCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
