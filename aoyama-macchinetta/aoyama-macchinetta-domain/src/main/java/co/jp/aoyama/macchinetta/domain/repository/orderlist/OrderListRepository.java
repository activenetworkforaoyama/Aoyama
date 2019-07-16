package co.jp.aoyama.macchinetta.domain.repository.orderlist;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderCondition;

public interface OrderListRepository {

    List<Order> findAllOrder();
    
    List<Order> findOrderByCondition(@Param("condition") OrderCondition condition);
    
    long countOrderByCondition(@Param("condition") OrderCondition condition);

	Order findOrderByPk(String orderId);
	
	void updateTscStatus(String orderId,String changeTscStatus,String updatedUserId,Date updatedAt);
	
	void updateSaveValue(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String updatedUserId,Date updatedAt);

	void updateSaveOrChangeValue(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String makerFactoryStatus,String updatedUserId,Date updatedAt);

	void updateNextGeneration(String orderId,Integer nextGenerationP,String updatedUserId,Date updatedAt);
}