package co.jp.aoyama.macchinetta.app.order.enums.jacket;

public enum JacketOptionTuxedoCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	JK_Tuxedo_OPTION_CODE01("00001","setTjFrontBtnCntMap"),
	JK_Tuxedo_OPTION_CODE02("00002","setTjLapelDesignMap"),
	JK_Tuxedo_OPTION_CODE03("00003","setTjGradeMap"),
	JK_Tuxedo_OPTION_CODE04("00004","setTjBackSpecMap"),
	JK_Tuxedo_OPTION_CODE05("00005","setTjFortMap"),
	JK_Tuxedo_OPTION_CODE06("00050","setTjGlossFablicMap"),
	JK_Tuxedo_OPTION_CODE07("00007","setTjBackCollarMap"),
	JK_Tuxedo_OPTION_CODE08("00008","setTjChainHangeMap"),
	JK_Tuxedo_OPTION_CODE09("00009","setTjLapelWidthMap"),
	JK_Tuxedo_OPTION_CODE10("00010","setTjFlowerHoleMap"),
	JK_Tuxedo_OPTION_CODE11("00011","setTjBreastPktMap"),
	JK_Tuxedo_OPTION_CODE12("00012","setTjWaistPktMap"),
	JK_Tuxedo_OPTION_CODE13("00013","setTjChangePktMap"),
	JK_Tuxedo_OPTION_CODE14("00014","setTjSlantedPktMap"),
	JK_Tuxedo_OPTION_CODE15("00015","setTjCoinPktMap"),
	JK_Tuxedo_OPTION_CODE16("00016","setTjSleeveSpecMap"),
	JK_Tuxedo_OPTION_CODE17("00017","setTjManicaMap"),
	JK_Tuxedo_OPTION_CODE18("00018","setTjSleeveBtnTypeMap"),
	JK_Tuxedo_OPTION_CODE19("00019","setTjCuffSpecMap"),
	JK_Tuxedo_OPTION_CODE20("00020","setTjInsidePktChangeMap"),
	JK_Tuxedo_OPTION_CODE22("00022","setTjBreastInnerPktMap"),
	JK_Tuxedo_OPTION_CODE23("00023","setTjStitchMap"),
	JK_Tuxedo_OPTION_CODE31("00031","setTjBhColorMap"),
	JK_Tuxedo_OPTION_CODE32("00032","setTjBhColorPlaceMap"),
	JK_Tuxedo_OPTION_CODE33("00033","setTjBhColorPlaceAllMap"),
	JK_Tuxedo_OPTION_CODE34("00034","setTjByColorMap"),
	JK_Tuxedo_OPTION_CODE35("00035","setTjByColorPlaceMap"),
	JK_Tuxedo_OPTION_CODE36("00036","setTjByColorPlaceAllMap"),
	JK_Tuxedo_OPTION_CODE37("00037","setTjVentSpecMap"),
	JK_Tuxedo_OPTION_CODE38("00038","setTjBodyBackMateMap"),
	JK_Tuxedo_OPTION_CODE40("00040","setTjCuffBackMateMap"),
	JK_Tuxedo_OPTION_CODE42("00042","setTjBtnMateMap"),
	JK_Tuxedo_OPTION_CODE44("00044","setTjShapeMemoryMap"),
	JK_Tuxedo_OPTION_CODE51("00051","setTjCoStitchMap");
	
	
	private final String key;
	private final String value;
    
    private JacketOptionTuxedoCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static JacketOptionTuxedoCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static JacketOptionTuxedoCodeEnum get(String str) {
        for (JacketOptionTuxedoCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
