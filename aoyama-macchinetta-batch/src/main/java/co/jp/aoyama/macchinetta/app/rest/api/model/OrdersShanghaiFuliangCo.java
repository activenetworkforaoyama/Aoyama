package co.jp.aoyama.macchinetta.app.rest.api.model;

import java.util.List;

/**
 * 
 * @author liufeng
 *
 */
public class OrdersShanghaiFuliangCo {
	List<OrderStatusShanghaiFuliangCoInput> statusMainOrder;

	public List<OrderStatusShanghaiFuliangCoInput> getStatusMainOrder() {
		return statusMainOrder;
	}

	public void setStatusMainOrder(List<OrderStatusShanghaiFuliangCoInput> statusMainOrder) {
		this.statusMainOrder = statusMainOrder;
	}
}
