package co.jp.aoyama.macchinetta.app.rest.api.model;

import java.io.Serializable;
import java.util.List;

public class OrderDetail  implements Serializable {

	private static final long serialVersionUID = 5137775505641208580L;
	
	private String orderdetailid;
	private String order;
	private String combination;
	private String mode;
	private List<Fabric> fabric;
	private List<Lining> lining;
	private String cl_flag;
	private String styleno;
	private String ptype;
	private String class_item;
	private String made;
	private String tryon;
	private String fit;
	private String remark;
	private String vendor;
	private String previous_order;
	private String provious_vendor;
	private String order_urgent;
	private String urgent_days;
	private String mark_type;

	public String getOrderdetailid() {
		return orderdetailid;
	}
	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getCombination() {
		return combination;
	}
	public void setCombination(String combination) {
		this.combination = combination;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public List<Fabric> getFabric() {
		return fabric;
	}
	public void setFabric(List<Fabric> fabric) {
		this.fabric = fabric;
	}
	public List<Lining> getLining() {
		return lining;
	}
	public void setLining(List<Lining> lining) {
		this.lining = lining;
	}
	public String getCl_flag() {
		return cl_flag;
	}
	public void setCl_flag(String cl_flag) {
		this.cl_flag = cl_flag;
	}
	public String getStyleno() {
		return styleno;
	}
	public void setStyleno(String styleno) {
		this.styleno = styleno;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getClass_item() {
		return class_item;
	}
	public void setClass_item(String class_item) {
		this.class_item = class_item;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public String getTryon() {
		return tryon;
	}
	public void setTryon(String tryon) {
		this.tryon = tryon;
	}
	public String getFit() {
		return fit;
	}
	public void setFit(String fit) {
		this.fit = fit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getPrevious_order() {
		return previous_order;
	}
	public void setPrevious_order(String previous_order) {
		this.previous_order = previous_order;
	}
	public String getProvious_vendor() {
		return provious_vendor;
	}
	public void setProvious_vendor(String provious_vendor) {
		this.provious_vendor = provious_vendor;
	}
	public String getOrder_urgent() {
		return order_urgent;
	}
	public void setOrder_urgent(String order_urgent) {
		this.order_urgent = order_urgent;
	}
	public String getUrgent_days() {
		return urgent_days;
	}
	public void setUrgent_days(String urgent_days) {
		this.urgent_days = urgent_days;
	}
	public String getMark_type() {
		return mark_type;
	}
	public void setMark_type(String mark_type) {
		this.mark_type = mark_type;
	}
	

}
