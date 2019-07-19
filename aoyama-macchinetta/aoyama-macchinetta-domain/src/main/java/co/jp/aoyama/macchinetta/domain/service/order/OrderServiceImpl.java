package co.jp.aoyama.macchinetta.domain.service.order;


import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.Stock;
import co.jp.aoyama.macchinetta.domain.repository.cash.CashRepository;
import co.jp.aoyama.macchinetta.domain.repository.measuring.MeasuringRepository;
import co.jp.aoyama.macchinetta.domain.repository.order.OrderRepository;
import co.jp.aoyama.macchinetta.domain.repository.orderlist.OrderListRepository;

@Service
@Transactional
public class OrderServiceImpl  implements OrderService {
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Inject
	OrderRepository orderRepository;
	
	@Inject
	OrderListRepository orderListRepository;
	
	@Inject
	CashRepository cashRepository;
	
	@Inject
	MeasuringRepository measuringRepository;


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
		Order findOrderByPk = orderListRepository.findOrderByPk(order.getOrderId());
		Short version = findOrderByPk.getVersion();
		Short orderVersion = order.getVersion();
		if(orderVersion.equals(version)) {
			orderRepository.updateOrder(order);
		}
		else {
			ResultMessages resultMessages = ResultMessages.error();
				resultMessages.add("E023", order.getOrderId());
	            logger.error(resultMessages.toString());
	            throw new ResourceNotFoundException(resultMessages);
		}
	}


	@Override
	public String selectMaxOrderId(String belongCode,String type) {
		String orderId = orderRepository.selectMaxOrderId(belongCode,type);
		return orderId;
	}


	@Override
	public Stock getStock(String productFabricNo) {
		Stock stock = orderRepository.getStock(productFabricNo);
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
	public void deletOrderByOrderId(String orderId,Short version) {
		Order order = orderListRepository.findOrderByPk(orderId);
		Short orderVersion = order.getVersion();
		if(version.equals(orderVersion)) {
			orderRepository.deletOrderByOrderId(orderId);
		}else {
			//BusinessException businessException = new BusinessException();
			ResultMessages messages = ResultMessages.error();
            messages.add("E023");
            logger.error(messages.toString());
            throw new ResourceNotFoundException(messages);
		}
		
	}


	@Override
	public int getSameCash(String cashId) {
		int cashCount = orderRepository.getSameCash(cashId);
		return cashCount;
	}


	@Override
	public String getFactories(String orderPattern,String itemCode, String jkModel, String subItemCode) {
		String factories = orderRepository.getFactories(orderPattern,itemCode,jkModel,subItemCode);
		return factories;
	}


	@Override
	public void deletOrderByOrderId(String orderId) {
		orderRepository.deletOrderByOrderId(orderId);
	}


	@Override
	public void updateCash(Cash cash) {
		cashRepository.updateCash(cash);
	}


	@Override
	public void insertMeasuring(Measuring measuring) {
		measuringRepository.insert(measuring);
	}


	@Override
	public void deleteByOrderId(String orderId) {
		measuringRepository.deleteByPrimaryKey(orderId);
	}


	@Override
	public Short findOrderVersion(String orderId) {
		Short version = orderRepository.findOrderVersion(orderId);
		return version;
	}


}
