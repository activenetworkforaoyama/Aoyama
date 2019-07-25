package co.jp.aoyama.macchinetta.app.rest.api.enums;

public enum OrderDetailEnum {

	//ORDERDETAIL (item, combination, styleno, classType, DtbOrder getDrop Method , tbOrder getSize Method),
	ORDERDETAIL01("02","QS0102","01","02","getCorJkDrop","getCorJkSize"),
	ORDERDETAIL02("03","QS0103","01","05","getCorPtDrop","getCorPtSize"),
	ORDERDETAIL03("04","QS0104","01","17","getCorGlDrop","getCorGlSize"),
	ORDERDETAIL04("21","QS0101","01","02","getCorJkDrop","getCorJkSize"),
	ORDERDETAIL05("21","QS0101","02","05","getCorPtDrop","getCorPtSize"),
	ORDERDETAIL06("22","QS0107","01","02","getCorJkDrop","getCorJkSize"),
	ORDERDETAIL07("22","QS0107","02","05","getCorPtDrop","getCorPtSize"),
	ORDERDETAIL08("22","QS0107","03","05","getCorPt2Drop","getCorPt2Size"),
	ORDERDETAIL09("31","QS0105","01","02","getCorJkDrop","getCorJkSize"),
	ORDERDETAIL10("31","QS0105","02","05","getCorPtDrop","getCorPtSize"),
	ORDERDETAIL11("31","QS0105","03","17","getCorGlDrop","getCorGlSize"),
	ORDERDETAIL12("32","QS0110","01","02","getCorJkDrop","getCorJkSize"),
	ORDERDETAIL13("32","QS0110","02","05","getCorPtDrop","getCorPtSize"),
	ORDERDETAIL14("32","QS0110","03","05","getCorPt2Drop","getCorPt2Size"),
	ORDERDETAIL15("32","QS0110","04","17","getCorGlDrop","getCorGlSize");

	private final String item;
	private final String combination;
	private final String styleno;
	private final String classType;
	private final String getDrop;
	private final String getSize;
	
    private OrderDetailEnum(String item, String combination, String styleno, String classType, String getDrop, String getSize) {
    	this.item = item;
    	this.combination = combination;
        this.styleno = styleno;
        this.classType = classType;
        this.getDrop = getDrop;
        this.getSize = getSize;
    }  

	public String getItem() {
		return item;
	}

	public String getCombination() {
		return combination;
	}

	public String getStyleno() {
		return styleno;
	}

	public String getClassType() {
		return classType;
	}

	public String getGetDrop() {
		return getDrop;
	}

	public String getGetSize() {
		return getSize;
	}

	public static OrderDetailEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static OrderDetailEnum get(String str) {
        for (OrderDetailEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
