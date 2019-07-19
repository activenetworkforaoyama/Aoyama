package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.Date;
import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.Stock;

public interface OrderService {
	
	OrderFindFabric getOrderFabric(String fabricNo, String orderPattern);

	List<OrderPrice> getOrderPrice(String orderPattern);

	void insertOrder(Order order);

	Order selectByOrderId(String orderId);

	void updateOrder(Order order);

	String selectMaxOrderId(String belongCode, String type);

	Stock getStock(String productFabricNo);

	void updateStockByPk(Stock stock);

	String getShopDeliveryOn(Date nowDate, String storeDelvNormal);

	void deletOrderByOrderId(String orderId, Short version);

	int getSameCash(String cashId);

	String getFactories(String orderPattern,String itemCode, String jkModel, String subItemCode);

	void deletOrderByOrderId(String orderId);

	void updateCash(Cash cash);

	void insertMeasuring(Measuring measuring);

	void deleteByOrderId(String orderId);

	Short findOrderVersion(String orderId);


}
