package co.jp.aoyama.macchinetta.app.rest.api.model;

import java.io.Serializable;

public class Measurement  implements Serializable {

	private static final long serialVersionUID = -8288916732194662606L;
	
	private String orderdetailid;
	private String styleno;
	private String classType;
	private String item_code;
	private String tryon_adjustment;
	private String value;

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
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getTryon_adjustment() {
		return tryon_adjustment;
	}
	public void setTryon_adjustment(String tryon_adjustment) {
		this.tryon_adjustment = tryon_adjustment;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Measurements [orderdetailid=" + orderdetailid + ", styleno=" + styleno + ", class=" + classType
				+ ", item_code=" + item_code + ", tryon_adjustment=" + tryon_adjustment + ", value=" + value + "]";
	}


}
