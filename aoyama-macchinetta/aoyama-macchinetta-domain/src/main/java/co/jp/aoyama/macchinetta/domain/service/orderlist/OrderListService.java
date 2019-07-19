package co.jp.aoyama.macchinetta.domain.service.orderlist;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.OrderCondition;
import co.jp.aoyama.macchinetta.domain.model.Order;

public interface OrderListService {

	List<Order> findAllOrder();
    
    List<Order> findOrderByCondition(OrderCondition condition);

	Order findOrderByPk(String orderId);
	
	void updateTscStatus(String orderId,String changeTscStatus,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateSaveValue(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateSaveOrChangeValue(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String makerFactoryStatus,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateNextGeneration(String orderId,Integer nextGenerationP,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateActualStock(String fabricNo,BigDecimal remainActualStock,String updatedUserId,Date updatedAt);
	
}
