package co.jp.aoyama.macchinetta.app.rest.api.enums;

public enum LiningEnum {
	//LINING (   胴裏编号    ,mode, "", "", "", "")
	
	
	
	/*
	 * LINING01("100010002","TR330","01","","","",""),
	 * LINING02("100010007","TR330","01","","","",""),
	 * LINING03("100010001","TR330","01","","","",""),
	 * LINING04("100010006","TR330","01","","","",""),
	 * LINING05("100010003","TR330","01","","","",""),
	 * LINING06("100010004","TR330","01","","","",""),
	 * LINING07("100010005","TR330","01","","","",""),
	 * LINING08("100020001","TR330","01","","","",""),
	 * LINING09("100020002","TR330","01","","","",""),
	 * LINING10("100020003","TR330","01","","","",""),
	 * LINING11("100020004","TR330","01","","","",""),
	 * LINING12("100020005","TR330","01","","","",""),
	 * LINING13("100020006","TR330","01","","","",""),
	 * LINING14("100020007","TR330","01","","","",""),
	 * LINING15("100020008","TR330","01","","","",""),
	 * LINING16("100020009","TR330","01","","","","");
	 */

	  LINING01("100010002","QSL-001","01","","","",""),
	  LINING02("100010007","QSL-002","01","","","",""),
	  LINING03("100010001","QSL-003","01","","","",""),
	  LINING04("100010006","QSL-004","01","","","",""),
	  LINING05("100010003","QSL-005","01","","","",""),
	  LINING06("100010004","QSL-006","01","","","",""),
	  LINING07("100010005","QSL-007","01","","","",""),
	  LINING08("100020001","QSL-008","01","","","",""),
	  LINING09("100020002","QSL-009","01","","","",""),
	  LINING10("100020003","QSL-010","01","","","",""),
	  LINING11("100020004","QSL-011","01","","","",""),
	  LINING12("100020005","QSL-012","01","","","",""),
	  LINING13("100020006","QSL-013","01","","","",""),
	  LINING14("100020007","QSL-014","01","","","",""),
	  LINING15("100020008","QSL-015","01","","","",""),
	  LINING16("100020009","QSL-016","01","","","","");
	 
	 
	 
	 
	 
	
	private final String jkInnerBodyClothCd;
	private final String sku;
	private final String mode;
	private final String vendor;
	private final String description;
	private final String composition;
	private final String length;
    
    private LiningEnum(String jkInnerBodyClothCd, String sku, String mode, String vendor, String description, String composition, String length) {
    	this.jkInnerBodyClothCd = jkInnerBodyClothCd;
    	this.sku = sku;
    	this.mode = mode;
        this.vendor = vendor;
        this.description = description;
        this.composition = composition;
        this.length = length;
    }  

	public String getJkInnerBodyClothCd() {
		return jkInnerBodyClothCd;
	}

	public String getSku() {
		return sku;
	}

	public String getMode() {
		return mode;
	}

	public String getVendor() {
		return vendor;
	}

	public String getDescription() {
		return description;
	}

	public String getComposition() {
		return composition;
	}

	public String getLength() {
		return length;
	} 

    public static LiningEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static LiningEnum get(String str) {
        for (LiningEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
