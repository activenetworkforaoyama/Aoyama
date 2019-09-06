package co.jp.aoyama.macchinetta.app.order;

public class OrderMessage {
	private String orderId;
	private String orderMsg;
	private Boolean orderMsgFlag;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderMsg() {
		return orderMsg;
	}
	public void setOrderMsg(String orderMsg) {
		this.orderMsg = orderMsg;
	}
	public Boolean getOrderMsgFlag() {
		return orderMsgFlag;
	}
	public void setOrderMsgFlag(Boolean orderMsgFlag) {
		this.orderMsgFlag = orderMsgFlag;
	}
}
