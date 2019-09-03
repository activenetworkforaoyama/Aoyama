package co.jp.aoyama.macchinetta.domain.repository.order;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.Stock;

public interface OrderRepository {
	
	OrderFindFabric getOrderFabric(String fabricNo, String orderPattern);

	List<OrderPrice> getOrderPrice(String orderPattern);
	
	List<OrderPrice> getTuxedoOrderPrice(String orderPattern);
	
	List<OrderPrice> getWashableOrderPrice(String orderPattern);

	void insertOrder(Order order);

	Order selectByOrderId(@Param("orderId")String orderId);

	void updateOrder(Order order);

	String selectMaxOrderId(@Param("belongCode")String belongCode, @Param("type")String type);

	Stock getStock(String productFabricNo, String orderPattern);

	void updateStockByPk(Stock stock);

	String getShopDeliveryOn(Date nowDate, String storeDelvNormal);

	void deletOrderByOrderId(String orderId);

	int getSameCash(@Param("cashId")String cashId);

	String getFactories(String orderPattern,String itemCode, String jkModel, String subItemCode);

	Short findOrderVersion(String orderId);
	
	void insertOrderWithNotVersion(Order order);

	void insertOrder(Order order, @Param("saveFlag")String saveFlag);

	String selectOrderIdBySequence();
	
	Order selectGiletByOrderId(@Param("orderId")String orderId);
	
	void updateGiletOrder(Order order);

}
