package co.jp.aoyama.macchinetta.domain.service.order;


import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.Stock;
import co.jp.aoyama.macchinetta.domain.repository.order.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl  implements OrderService {
	
	@Inject
	OrderRepository orderRepository;


	@Override
	public OrderFindFabric getOrderFabric(String fabricNo, String orderPattern) {
		OrderFindFabric OrderFindFabric = orderRepository.getOrderFabric(fabricNo,orderPattern);
		return OrderFindFabric;
	}


	@Override
	public List<OrderPrice> getOrderPrice(String orderPattern) {
		List<OrderPrice> orderList = orderRepository.getOrderPrice(orderPattern);
		return orderList;
	}


	@Override
	public void insertOrder(Order order) {
		orderRepository.insertOrder(order);
	}


	@Override
	public Order selectByOrderId(String orderId) {
		Order order = orderRepository.selectByOrderId(orderId);
		return order;
	}


	@Override
	public void updateOrder(Order order) {
		orderRepository.updateOrder(order);
	}


	@Override
	public String selectMaxOrderId(String belongCode,String type) {
		String orderId = orderRepository.selectMaxOrderId(belongCode,type);
		return orderId;
	}


	@Override
	public Stock getStock(String productFabricNo, String orderPattern) {
		Stock stock = orderRepository.getStock(productFabricNo,orderPattern);
		return stock;
	}


	@Override
	public void updateStockByPk(Stock stock) {
		orderRepository.updateStockByPk(stock);
	}


	@Override
	public String getShopDeliveryOn(Date nowDate, String storeDelvNormal) {
		String shopDeliveryOn = orderRepository.getShopDeliveryOn(nowDate,storeDelvNormal);
		return shopDeliveryOn;
	}


	@Override
	public void deletOrderByOrderId(String orderId) {
		orderRepository.deletOrderByOrderId(orderId);
	}


	@Override
	public int getSameCash(String cashId) {
		int cashCount = orderRepository.getSameCash(cashId);
		return cashCount;
	}

	
}
