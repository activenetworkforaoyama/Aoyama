package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.Date;
import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Model;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.Stock;

public interface OrderService {
	
	OrderFindFabric getOrderFabric(String fabricNo, String orderPattern);

	List<OrderPrice> getOrderPrice(String orderPattern);
	
	List<OrderPrice> getStandardSomePrice(String orderPattern,String optionCode,String itemCode,String subItemCode);
	
	List<OrderPrice> getTuxedoOrderPrice(String orderPattern);
	
	List<OrderPrice> getWashableOrderPrice(String orderPattern);

	void insertOrder(Order order);

	Order selectByOrderId(String orderId);

	void updateOrder(Order order);
	
	String selectMaxOrderId(String belongCode, String type);

	Stock getStock(String productFabricNo, String orderPattern);

	void updateStockByPk(Stock stock);

	String getShopDeliveryOn(Date nowDate, String storeDelvNormal);

	int getSameCash(String cashId);

	String getFactories(String orderPattern,String itemCode, String jkModel, String subItemCode);

	void deletOrderByOrderId(String orderId);

	void updateCash(Cash cash);

	void insertMeasuring(Measuring measuring);

	Short findOrderVersion(String orderId);

	void deletOrder(Order order, Short version);

	void deleteMeasuring(Measuring measuring);

	void deleteMeasuringOrderId(String orderId);

	void deleteOrderAndStock(Order order, Stock stock, Measuring measuring);

	void deleteOrder(Order order);

	void physicalDeleteOrder(Stock stock, String orderId);

	void deleteMeasuringBothOrder(String orderId);

	void updateStockByPkAndOrderAndCash(Stock stockDb, Order order, Cash cash);

	void updateOrderAndCash(Order order, Cash cash);

	void deletOrderWithNotVersion(Order order);

	void deletOrder(Order order, Short version, String saveFlag);

	void updateStockByPkAndOrder(Stock stockDb, Order order);

	void deletOrderisExistence(Order order);

	String selectOrderIdBySequence();

	List<Model> getFactoriesCo(String orderPattern, String itemCode);

	List<OrderPrice> getOrderPriceNotCate(String coType);

	void deletOrderWithNotVersionAndStock(Order order, Order orderIsExist,String item, String userId, Measuring measuring);

	void deleteOrderAndStock(Order order, Stock stock, Measuring measuring, Order orderIsExist, String item,
			String userId);

	void deleteOrderAndStock(Order order, Measuring measuring, Order orderIsExist, String item, String userId);

	void deletOrderWithNotVersionAndMeasuring(Order order, Measuring measuring);

	void deletOrderisExistence(Order order, Measuring measuring);

	void updateOrderConfirm(Order order, String status, String itemBefore, String itemAfter);

	void deleteOrderAddVersionAndStock(Order order, Stock stock, Measuring measuring);

	void deleteOrderAddVersionAndStock(Order order, Measuring measuring, Order orderIsExist, String item,
			String userId);

	void deletOrderAddVersionAndStock(Order order, Order orderIsExist, String item, String userId, Measuring measuring);

}
