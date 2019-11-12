package co.jp.aoyama.macchinetta.app.order.enums.gilet;

public enum GiletOptionTuxedoCodeEnum {

	// OptionForm
	// Key:mtb_option的option_code
	// Value:OptionFormのmethod
	
	GILET_TUXEDO_OPTION_CODE01("00001","setTgBreastPktMap"),
	GILET_TUXEDO_OPTION_CODE02("00002","setTgWaistPktMap"),
	GILET_TUXEDO_OPTION_CODE03("00003","setTgWaistPktSpecMap"),
	GILET_TUXEDO_OPTION_CODE04("00004","setTgWaistPktMateMap"),
	GILET_TUXEDO_OPTION_CODE05("00005","setTgStitchMap"),
	GILET_TUXEDO_OPTION_CODE11("00011","setTgBhColorMap"),
	GILET_TUXEDO_OPTION_CODE12("00012","setTgBhColorPlaceMap"),
	GILET_TUXEDO_OPTION_CODE13("00013","setTgBhColorPlaceAllMap"),
	GILET_TUXEDO_OPTION_CODE14("00014","setTgByColorMap"),
	GILET_TUXEDO_OPTION_CODE15("00015","setTgByColorPlaceMap"),
	GILET_TUXEDO_OPTION_CODE16("00016","setTgByColorPlaceAllMap"),
	GILET_TUXEDO_OPTION_CODE17("00017","setTgBackLiningMateMap"),
	GILET_TUXEDO_OPTION_CODE19("00019","setTgInsideLiningMateMap"),
	GILET_TUXEDO_OPTION_CODE21("00021","setTgFrontBtnMateMap"),
	GILET_TUXEDO_OPTION_CODE23("00023","setTgBackBeltMap"),
	GILET_TUXEDO_OPTION_CODE24("00024","setTgWatchChainMap"),
	GILET_TUXEDO_OPTION_CODE33("00033","setTgBtnHoleColorMap"),
	GILET_TUXEDO_OPTION_CODE36("00036","setTgBtnThreadColorMap"),
	GILET_TUXEDO_OPTION_CODE50("00050","setTgGlossFablicMap"),
	GILET_TUXEDO_OPTION_CODE51("00051","setTgCoStitchMap");
	
	
	private final String key;
	private final String value;
    
    private GiletOptionTuxedoCodeEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
  
    public static GiletOptionTuxedoCodeEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static GiletOptionTuxedoCodeEnum get(String str) {
        for (GiletOptionTuxedoCodeEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
