package co.jp.aoyama.macchinetta.app.rest.api.model;

import java.io.Serializable;
import java.util.List;

public class Order  implements Serializable {
	
	private static final long serialVersionUID = -8674086236249300427L;
	
	private String brand;
	private String mainorder;
	private String shop;
	private String cdate;
	private String deliver_date;
	private String import_time;
	private String remark;
	private String customer;
	private String receiver;
	private String country;
	private String province;
	private String address;
	private String postcode;
	private String contactnumber;
	private String front;
	private String back;
	private String sideLeft;
	private String sideRight;
	
	private List<OrderDetail> OrderDetails;
	private List<Measurement> Measurements;
	private List<Option> Options;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMainorder() {
		return mainorder;
	}
	public void setMainorder(String mainorder) {
		this.mainorder = mainorder;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getDeliver_date() {
		return deliver_date;
	}
	public void setDeliver_date(String deliver_date) {
		this.deliver_date = deliver_date;
	}
	public String getImport_time() {
		return import_time;
	}
	public void setImport_time(String import_time) {
		this.import_time = import_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getFront() {
		return front;
	}
	public void setFront(String front) {
		this.front = front;
	}
	public String getBack() {
		return back;
	}
	public void setBack(String back) {
		this.back = back;
	}
	public String getSideLeft() {
		return sideLeft;
	}
	public void setSideLeft(String sideLeft) {
		this.sideLeft = sideLeft;
	}
	public String getSideRight() {
		return sideRight;
	}
	public void setSideRight(String sideRight) {
		this.sideRight = sideRight;
	}
	public List<OrderDetail> getOrderDetails() {
		return OrderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		OrderDetails = orderDetails;
	}
	public List<Measurement> getMeasurements() {
		return Measurements;
	}
	public void setMeasurements(List<Measurement> measurements) {
		Measurements = measurements;
	}
	public List<Option> getOptions() {
		return Options;
	}
	public void setOptions(List<Option> options) {
		Options = options;
	}

}
