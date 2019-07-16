package co.jp.aoyama.macchinetta.app.order;

import java.io.Serializable;

public class OrderCodePrice implements Serializable{
	
	private static final long serialVersionUID = 8751146029606408730L;
	private String orderKeyCode;
	private String orderBranchPrice;
	private String orderBranchDoublePrice;
	private String orderDetailKeyCode;
	private String orderBranchDetailPrice;
	private String orderBranchDetailDoublePrice;
	public String getOrderKeyCode() {
		return orderKeyCode;
	}
	public void setOrderKeyCode(String orderKeyCode) {
		this.orderKeyCode = orderKeyCode;
	}
	public String getOrderBranchPrice() {
		return orderBranchPrice;
	}
	public void setOrderBranchPrice(String orderBranchPrice) {
		this.orderBranchPrice = orderBranchPrice;
	}
	public String getOrderBranchDoublePrice() {
		return orderBranchDoublePrice;
	}
	public void setOrderBranchDoublePrice(String orderBranchDoublePrice) {
		this.orderBranchDoublePrice = orderBranchDoublePrice;
	}
	public String getOrderDetailKeyCode() {
		return orderDetailKeyCode;
	}
	public void setOrderDetailKeyCode(String orderDetailKeyCode) {
		this.orderDetailKeyCode = orderDetailKeyCode;
	}
	public String getOrderBranchDetailPrice() {
		return orderBranchDetailPrice;
	}
	public void setOrderBranchDetailPrice(String orderBranchDetailPrice) {
		this.orderBranchDetailPrice = orderBranchDetailPrice;
	}
	public String getOrderBranchDetailDoublePrice() {
		return orderBranchDetailDoublePrice;
	}
	public void setOrderBranchDetailDoublePrice(String orderBranchDetailDoublePrice) {
		this.orderBranchDetailDoublePrice = orderBranchDetailDoublePrice;
	}
}
