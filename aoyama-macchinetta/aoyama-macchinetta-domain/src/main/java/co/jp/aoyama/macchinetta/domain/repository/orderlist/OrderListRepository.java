package co.jp.aoyama.macchinetta.domain.repository.orderlist;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.FactoryOrder;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderCondition;

public interface OrderListRepository {

    List<Order> findAllOrder();
    
    List<Order> findOrderByCondition(@Param("condition") OrderCondition condition);
    
    long countOrderByCondition(@Param("condition") OrderCondition condition);

	Order findOrderByPk(String orderId);
	
	void updateTscStatus(String orderId,String changeTscStatus,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateSaveValue(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String updatedUserId,Date updatedAt,Short orderVersion);

	void updateSaveValueAndStatus(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String updatedUserId,Date updatedAt,Short orderVersion,String shippingTransmitStatus);
	
	void updateSaveOrChangeValue(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String makerFactoryStatus,String updatedUserId,Date updatedAt,Short orderVersion);

	void updateSaveOrChangeValueAndStatus(String orderId,BigDecimal fabricUsedMount,Date shippingDate,Date loadingDate,String makerFactoryStatus,String updatedUserId,Date updatedAt,Short orderVersion,String shippingTransmitStatus);
	
	void updateNextGeneration(String orderId,Integer nextGenerationP,String updatedUserId,Date updatedAt,Short orderVersion);
	
	void updateNextGenerationAndStatus(String orderId,Integer nextGenerationP,String updatedUserId,Date updatedAt,Short orderVersion,String scheduleDataTransmitStatus);
	
	void updateActualStock(String fabricNo,BigDecimal remainActualStock,String updatedUserId,Date updatedAt,String orderPattern);
	
	List<Order> fuzzyQuery(@Param("condition") OrderCondition condition);

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
	
	Order findOrderByPkChinese(String orderId);

	Order findDnpOrderByPk(String orderId);

	Order findDnpOrderProductByPk(String orderId);

	Order findDnpOrderJkOptionByOrderId(String orderId);

	Order findDnpOrderJkByPk(String orderId);

	Order findDnpOrderPtOptionByOrderId(String orderId);

	Order findDnpOrderPtByPk(String orderId);

	Order findDnpOrderGlOptionByOrderId(String orderId);

	Order findDnpOrderGlByPk(String orderId);

	Order findDnpOrderPt2OptionByOrderId(String orderId);

	Order findDnpOrderPt2ByPk(String orderId);

	Order findDnpOrderStOptionByOrderId(String orderId);

	Order findDnpOrderStByPk(String orderId);

	Order findDnpOrderCtOptionByOrderId(String orderId);

	Order findDnpOrderCtByPk(String orderId);

	List<Order> fuzzyQueryDnp(@Param("condition") OrderCondition condition, @Param("memberList")List<String> memberList);

	List<Order> findDnpOrderByCondition(@Param("condition") OrderCondition condition, @Param("memberList")List<String> memberList);
	
	void updateDtbPdfManageStatus(List<String> updatePrintList);
	
	List<FactoryOrder> fuzzyFactoryQuery(@Param(value = "condition") OrderCondition condition);
	
	List<FactoryOrder> findPrintStatus(List<FactoryOrder> orderIdList);
}