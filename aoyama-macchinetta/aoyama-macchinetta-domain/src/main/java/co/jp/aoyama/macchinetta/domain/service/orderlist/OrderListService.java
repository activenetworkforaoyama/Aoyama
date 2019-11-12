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
	
	List<Order> findOrderByPkList(List<String> orderList);
	
	Order findOrderByPkChinese(String orderId);
	
	void updateTscStatus(String orderId,String changeTscStatus,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateSaveValue(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateSaveValueAndStatus(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String updatedUserId,Date updatedAt,Short orderVersion,String shippingTransmitStatus);
	
	void updateSaveOrChangeValue(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String makerFactoryStatus,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateSaveOrChangeValueAndStatus(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String makerFactoryStatus,String updatedUserId,Date updatedAt,Short orderVersion,String shippingTransmitStatus);
	
	void updateNextGeneration(String orderId,Integer nextGenerationP,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateNextGenerationAndStatus(String orderId, Integer nextGenerationP,String updatedUserId,Date updatedAt,Short orderVersion,String scheduleDataTransmitStatus);
	
	void updateActualStock(String fabricNo,BigDecimal remainActualStock,String updatedUserId,Date updatedAt,String orderPattern);
	
	List<Order> fuzzyQuery(OrderCondition condition);

	Order findOrderJkByPk(String orderId);

	Order findOrderPtByPk(String orderId);

	Order findOrderPt2ByPk(String orderId);

	Order findOrderGlByPk(String orderId);

	Order findOrderStByPk(String orderId);

	Order findOrderCtByPk(String orderId);

	Order findOrderJkOptionByOrderId(String orderId);

	Order findOrderPtOptionByOrderId(String orderId);

	Order findOrderPt2OptionByOrderId(String orderId);
	
	Order findOrderCtOptionByOrderId(String orderId);
	
	Order findOrderGlOptionByOrderId(String orderId);
	
	Order findOrderStOptionByOrderId(String orderId);

	Order findOrderProductByPk(String orderId);

}
