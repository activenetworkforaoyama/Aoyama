package co.jp.aoyama.macchinetta.app.rest.api.model;

import java.io.Serializable;

public class Option implements Serializable {
	
	
	private static final long serialVersionUID = -6504656592177104621L;
	
	private String orderdetailid;
	private String styleno;
	private String classType;
	private String option_type;
	private String option_code;
	
	
	public String getOrderdetailid() {
		return orderdetailid;
	}
	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid;
	}
	public String getStyleno() {
		return styleno;
	}
	public void setStyleno(String styleno) {
		this.styleno = styleno;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getOption_type() {
		return option_type;
	}
	public void setOption_type(String option_type) {
		this.option_type = option_type;
	}
	public String getOption_code() {
		return option_code;
	}
	public void setOption_code(String option_code) {
		this.option_code = option_code;
	}
	
	@Override
	public String toString() {
		return "Options [orderdetailid=" + orderdetailid + ", styleno=" + styleno + ", class=" + classType
				+ ", option_type=" + option_type + ", option_code=" + option_code + "]";
	}

}
