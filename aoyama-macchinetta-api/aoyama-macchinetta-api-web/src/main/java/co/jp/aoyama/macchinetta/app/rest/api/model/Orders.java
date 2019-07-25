package co.jp.aoyama.macchinetta.app.rest.api.model;

import java.io.Serializable;
import java.util.List;

public class Orders implements Serializable {

	private static final long serialVersionUID = -5700514464523543184L;
	private List<Order> Order;

	public List<Order> getOrder() {
		return Order;
	}

	public void setOrder(List<Order> order) {
		this.Order = order;
	}

}

