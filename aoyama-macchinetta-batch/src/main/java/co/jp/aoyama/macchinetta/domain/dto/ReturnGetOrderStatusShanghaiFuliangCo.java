package co.jp.aoyama.macchinetta.domain.dto;

/**
 * 
 * @author liufeng
 *
 */
public class ReturnGetOrderStatusShanghaiFuliangCo extends OrderStatus {

	/** サブ注文ID */
	private String orderdetailid;

	public String getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

}
