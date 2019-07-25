package co.jp.aoyama.macchinetta.app.rest.api.enums;

public enum MeasurementEnum {

	//MEASUREMENT ( item , styleNo, classType, item_code, DtbOrder get_gross Method)
	MEASUREMENT01("02","01","02","msy_houyichang","getCorJkBodylengthGross"),
	MEASUREMENT02("02","01","02","msy_yaowei","getCorJkWaistGross"),
	MEASUREMENT03("02","01","02","msy_youxiuchang","getCorJkRightsleeveGross"),
	MEASUREMENT04("02","01","02","msy_zuoxiuchang","getCorJkLeftsleeveGross"),
	MEASUREMENT05("03","01","05","mkz_yaowei","getCorPtWaistGross"),
	MEASUREMENT06("03","01","05","mkz_hengdang","getCorPtThighwidthGross"),
	MEASUREMENT07("03","01","05","mkz_jiaokou","getCorPtHemwidthGross"),
	MEASUREMENT08("03","01","05","mkz_youkuchang","getCorPtRightinseamGross"),
	MEASUREMENT09("03","01","05","mkz_zuokuchang","getCorPtLeftinseamGross"),
	MEASUREMENT10("21","01","02","msy_houyichang","getCorJkBodylengthGross"),
	MEASUREMENT11("21","01","02","msy_yaowei","getCorJkWaistGross"),
	MEASUREMENT12("21","01","02","msy_youxiuchang","getCorJkRightsleeveGross"),
	MEASUREMENT13("21","01","02","msy_zuoxiuchang","getCorJkLeftsleeveGross"),
	MEASUREMENT14("21","02","05","mkz_yaowei","getCorPtWaistGross"),
	MEASUREMENT15("21","02","05","mkz_hengdang","getCorPtThighwidthGross"),
	MEASUREMENT16("21","02","05","mkz_jiaokou","getCorPtHemwidthGross"),
	MEASUREMENT17("21","02","05","mkz_youkuchang","getCorPtRightinseamGross"),
	MEASUREMENT18("21","02","05","mkz_zuokuchang","getCorPtLeftinseamGross"),
	MEASUREMENT19("22","01","02","msy_houyichang","getCorJkBodylengthGross"),
	MEASUREMENT20("22","01","02","msy_yaowei","getCorJkWaistGross"),
	MEASUREMENT21("22","01","02","msy_youxiuchang","getCorJkRightsleeveGross"),
	MEASUREMENT22("22","01","02","msy_zuoxiuchang","getCorJkLeftsleeveGross"),
	MEASUREMENT23("22","02","05","mkz_yaowei","getCorPtWaistGross"),
	MEASUREMENT24("22","02","05","mkz_hengdang","getCorPtThighwidthGross"),
	MEASUREMENT25("22","02","05","mkz_jiaokou","getCorPtHemwidthGross"),
	MEASUREMENT26("22","02","05","mkz_youkuchang","getCorPtRightinseamGross"),
	MEASUREMENT27("22","02","05","mkz_zuokuchang","getCorPtLeftinseamGross"),
	MEASUREMENT28("22","03","05","mkz_yaowei","getCorPt2WaistGross"),
	MEASUREMENT29("22","03","05","mkz_hengdang","getCorPt2ThighwidthGross"),
	MEASUREMENT30("22","03","05","mkz_jiaokou","getCorPt2HemwidthGross"),
	MEASUREMENT31("22","03","05","mkz_youkuchang","getCorPt2RightinseamGross"),
	MEASUREMENT32("22","03","05","mkz_zuokuchang","getCorPt2LeftinseamGross"),
	MEASUREMENT33("31","01","02","msy_houyichang","getCorJkBodylengthGross"),
	MEASUREMENT34("31","01","02","msy_yaowei","getCorJkWaistGross"),
	MEASUREMENT35("31","01","02","msy_youxiuchang","getCorJkRightsleeveGross"),
	MEASUREMENT36("31","01","02","msy_zuoxiuchang","getCorJkLeftsleeveGross"),
	MEASUREMENT37("31","02","05","mkz_yaowei","getCorPtWaistGross"),
	MEASUREMENT38("31","02","05","mkz_hengdang","getCorPtThighwidthGross"),
	MEASUREMENT39("31","02","05","mkz_jiaokou","getCorPtHemwidthGross"),
	MEASUREMENT40("31","02","05","mkz_youkuchang","getCorPtRightinseamGross"),
	MEASUREMENT41("31","02","05","mkz_zuokuchang","getCorPtLeftinseamGross"),
	MEASUREMENT42("32","01","02","msy_houyichang","getCorJkBodylengthGross"),
	MEASUREMENT43("32","01","02","msy_yaowei","getCorJkWaistGross"),
	MEASUREMENT44("32","01","02","msy_youxiuchang","getCorJkRightsleeveGross"),
	MEASUREMENT45("32","01","02","msy_zuoxiuchang","getCorJkLeftsleeveGross"),
	MEASUREMENT46("32","02","05","mkz_yaowei","getCorPtWaistGross"),
	MEASUREMENT47("32","02","05","mkz_hengdang","getCorPtThighwidthGross"),
	MEASUREMENT48("32","02","05","mkz_jiaokou","getCorPtHemwidthGross"),
	MEASUREMENT49("32","02","05","mkz_youkuchang","getCorPtRightinseamGross"),
	MEASUREMENT50("32","02","05","mkz_zuokuchang","getCorPtLeftinseamGross"),
	MEASUREMENT51("32","03","05","mkz_yaowei","getCorPt2WaistGross"),
	MEASUREMENT52("32","03","05","mkz_hengdang","getCorPt2ThighwidthGross"),
	MEASUREMENT53("32","03","05","mkz_jiaokou","getCorPt2HemwidthGross"),
	MEASUREMENT54("32","03","05","mkz_youkuchang","getCorPt2RightinseamGross"),
	MEASUREMENT55("32","03","05","mkz_zuokuchang","getCorPt2LeftinseamGross");
	
	private final String item;
	private final String styleno;
	private final String classType;
	private final String item_code;
	private final String get_gross;
	
    private MeasurementEnum(String k, String v1, String v2, String v3, String v4) {
    	this.item = k;
    	this.styleno = v1;
        this.classType = v2;
        this.item_code = v3;
        this.get_gross =v4;
    }  

	public String getItem() {
		return item;
	}

	public String getStyleno() {
		return styleno;
	}

	public String getClassType() {
		return classType;
	}

	public String getItem_code() {
		return item_code;
	}

	public String getGet_gross() {
		return get_gross;
	}

	public static MeasurementEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static MeasurementEnum get(String str) {
        for (MeasurementEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
