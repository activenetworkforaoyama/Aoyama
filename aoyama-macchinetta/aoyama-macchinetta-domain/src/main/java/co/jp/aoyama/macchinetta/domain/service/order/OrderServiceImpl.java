package co.jp.aoyama.macchinetta.domain.service.order;


import java.math.BigDecimal;
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
import co.jp.aoyama.macchinetta.domain.model.Model;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.Stock;
import co.jp.aoyama.macchinetta.domain.repository.cash.CashRepository;
import co.jp.aoyama.macchinetta.domain.repository.measuring.MeasuringRepository;
import co.jp.aoyama.macchinetta.domain.repository.order.OrderRepository;
import co.jp.aoyama.macchinetta.domain.repository.orderlist.OrderListRepository;
import co.jp.aoyama.macchinetta.domain.repository.stock.StockRepository;

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
	
	@Inject
	StockRepository stockRepository;


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
	public void updateOrderConfirm(Order order,String status,String itemBefore,String itemAfter) {
		Order findOrderByPk = orderListRepository.findOrderByPk(order.getOrderId());
		Short version = findOrderByPk.getVersion();
		Short orderVersion = order.getVersion();
		String orderPattern = order.getOrderPattern();
		//会計ID
		String cashId = findOrderByPk.getCashId();
		//最終更新者
		String updatedUserId = order.getUpdatedUserId();
		//最終更新日時
		Date updatedAt = new Date();
		//03：会計再確認要
		String cashStatus = "03";
		//生地品番
		String productFabricNo = order.getProductFabricNo();
		//オーダーマスタに生地品番
		String productFabricNoExit = findOrderByPk.getProductFabricNo();
		//オーダーマスタに理論生地使用量
		BigDecimal theoryFabricUsedMountOrder = findOrderByPk.getTheoryFabricUsedMount();
		//予約生地量
		BigDecimal reservationStockValue = order.getTheoryFabricUsedMount();
		
		if("T2".equals(status) || "T3".equals(status) || "T4".equals(status) || "T5".equals(status)) {
			if(orderVersion.equals(version)) {
				orderRepository.updateOrder(order);
				
				if(productFabricNoExit != null && productFabricNo != null && theoryFabricUsedMountOrder != null && reservationStockValue != null) {
					if(productFabricNoExit.equals(productFabricNo)) {
						if(theoryFabricUsedMountOrder.compareTo(reservationStockValue)!=0) {
							Stock stock = orderRepository.getStock(productFabricNo,order.getOrderPattern());
							
							BigDecimal theoreticalStock = stock.getTheoreticalStock();
							BigDecimal oldTheoreticalStockUpdate = theoreticalStock.add(theoryFabricUsedMountOrder);
							BigDecimal newTheoreticalStockUpdate = oldTheoreticalStockUpdate.subtract(reservationStockValue);
							
							Stock updateStock = orderRepository.getStock(productFabricNo,order.getOrderPattern());
							logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。更新前：「注文パターン：" + order.getOrderPattern() 
							+ "、注文ID："+order.getOrderId()  
							+ "、ITEM："+itemAfter 
							+ "、生地品番："+productFabricNo
							+ "、理論在庫："+updateStock.getTheoreticalStock() 
							+ "、予約生地量："+updateStock.getReservationStock() + "」");
							
							stockRepository.updateTheoreticalStock(productFabricNo,newTheoreticalStockUpdate,orderPattern);
							
							Stock updateStockAfter = orderRepository.getStock(productFabricNo,order.getOrderPattern());
							logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。更新後：「注文パターン：" + order.getOrderPattern() 
							+ "、注文ID："+order.getOrderId()  
							+ "、ITEM："+itemAfter
							+ "、生地品番："+productFabricNo
							+ "、理論在庫："+updateStockAfter.getTheoreticalStock() 
							+ "、予約生地量："+updateStockAfter.getReservationStock() + "」");
						}
					}
					else if(!productFabricNoExit.equals(productFabricNo)) {
						//古い理論在庫を修正する
						Stock oldStock = orderRepository.getStock(productFabricNoExit,order.getOrderPattern());
						BigDecimal oldTheoreticalStock = oldStock.getTheoreticalStock();
						BigDecimal oldTheoreticalStockUpdate = oldTheoreticalStock.add(theoryFabricUsedMountOrder);
						
						Stock recoveryStock = orderRepository.getStock(productFabricNoExit,order.getOrderPattern());
						logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。回復前：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+itemBefore 
						+ "、生地品番："+productFabricNoExit
						+ "、理論在庫："+recoveryStock.getTheoreticalStock() 
						+ "、予約生地量："+recoveryStock.getReservationStock() + "」");
						
						stockRepository.updateTheoreticalStock(productFabricNoExit,oldTheoreticalStockUpdate,orderPattern);
						
						Stock recoverystockAfter =  orderRepository.getStock(productFabricNoExit,order.getOrderPattern());
						logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。回復後：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+itemBefore
						+ "、生地品番："+productFabricNoExit
						+ "、理論在庫："+recoverystockAfter.getTheoreticalStock() 
						+ "、予約生地量："+recoverystockAfter.getReservationStock() + "」");
						
						//新しい理論在庫を修正する
						Stock newStock = orderRepository.getStock(productFabricNo,order.getOrderPattern());
						BigDecimal newTheoreticalStock = newStock.getTheoreticalStock();
						BigDecimal newTheoreticalStockUpdate = newTheoreticalStock.subtract(reservationStockValue);
						
						Stock updateStock = orderRepository.getStock(productFabricNo,order.getOrderPattern());
						logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。更新前：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+itemAfter 
						+ "、生地品番："+productFabricNo
						+ "、理論在庫："+updateStock.getTheoreticalStock() 
						+ "、予約生地量："+updateStock.getReservationStock() + "」");
						
						stockRepository.updateTheoreticalStock(productFabricNo,newTheoreticalStockUpdate,orderPattern);
						
						Stock updateStockAfter = orderRepository.getStock(productFabricNo,order.getOrderPattern());
						logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。更新後：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+itemAfter
						+ "、生地品番："+productFabricNo
						+ "、理論在庫："+updateStockAfter.getTheoreticalStock() 
						+ "、予約生地量："+updateStockAfter.getReservationStock() + "」");
						
					}
				}
					
				if("T3".equals(status) || "T4".equals(status) || "T5".equals(status)) {
					if(cashId != null || !("".equals(cashId))) {
						cashRepository.updateCashStatus(cashId, cashStatus, updatedUserId, updatedAt);
					}
				}
			}
			else {
				ResultMessages resultMessages = ResultMessages.error();
					resultMessages.add("E023", order.getOrderId());
		            logger.error(resultMessages.toString());
		            throw new ResourceNotFoundException(resultMessages);
			}
			
		}
		else {
			if(orderVersion.equals(version)) {
				orderRepository.updateOrder(order);
				
				//TSCステータスは空、T0（一時保存）、T1（取り置き）の場合
				if("".equals(status) || "T0".equals(status) || "T1".equals(status)) {
					if(productFabricNo != null && reservationStockValue != null) {
						Stock stock = orderRepository.getStock(productFabricNo,order.getOrderPattern());
						BigDecimal theoreticalStock = stock.getTheoreticalStock();
						BigDecimal stockReservationStock = stock.getReservationStock();
						BigDecimal theoreticalStockUpdate = theoreticalStock.subtract(reservationStockValue);
						BigDecimal reservationStockUpdate = stockReservationStock.subtract(reservationStockValue);
						
						Stock updateStock = orderRepository.getStock(productFabricNo,order.getOrderPattern());
						logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。更新前：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+itemAfter 
						+ "、生地品番："+productFabricNo
						+ "、理論在庫："+updateStock.getTheoreticalStock() 
						+ "、予約生地量："+updateStock.getReservationStock() + "」");
						
						stockRepository.updateStockValue(productFabricNo,theoreticalStockUpdate,reservationStockUpdate,orderPattern);
						
						Stock updateStockAfter = orderRepository.getStock(productFabricNo,order.getOrderPattern());
						logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。更新後：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+itemAfter
						+ "、生地品番："+productFabricNo
						+ "、理論在庫："+updateStockAfter.getTheoreticalStock() 
						+ "、予約生地量："+updateStockAfter.getReservationStock() + "」");
					}
				}
			}
			else {
				ResultMessages resultMessages = ResultMessages.error();
				resultMessages.add("E023", order.getOrderId());
	            logger.error(resultMessages.toString());
	            throw new ResourceNotFoundException(resultMessages);
			}
		}
	}

	public void updateOrderNotCheck(Order order) {
		orderRepository.updateOrder(order);
	}

	@Override
	public String selectMaxOrderId(String belongCode,String type) {
		String orderId = orderRepository.selectMaxOrderId(belongCode,type);
		return orderId;
	}


	@Override
	public Stock getStock(String productFabricNo,String orderPattern) {
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
	public void deletOrder(Order order,Short version) {
		Order orderDb = orderListRepository.findOrderByPk(order.getOrderId());
		if(orderDb == null) {
			orderRepository.insertOrder(order);
		}else {
			Short orderDbVersion = orderDb.getVersion();
			if(version.equals(orderDbVersion)) {
				orderRepository.deletOrderByOrderId(order.getOrderId());
				orderRepository.insertOrder(order);
			}else {
				//BusinessException businessException = new BusinessException();
				ResultMessages messages = ResultMessages.error();
	            messages.add("E023");
	            logger.error(messages.toString());
	            throw new ResourceNotFoundException(messages);
			}
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
	public void deleteMeasuring(Measuring measuring) {
		Measuring measuringDb = measuringRepository.selectByPrimaryKey(measuring.getOrderId());
		if(measuringDb == null) {
			measuringRepository.insert(measuring);
		}else {
			measuringRepository.deleteByPrimaryKey(measuring.getOrderId());
			measuringRepository.insert(measuring);
		}
	}


	@Override
	public Short findOrderVersion(String orderId) {
		Short version = orderRepository.findOrderVersion(orderId);
		return version;
	}



	@Override
	public void deleteMeasuringOrderId(String orderId) {
		measuringRepository.deleteByPrimaryKey(orderId);
	}


	@Override
	public void deleteOrderAndStock(Order order, Stock stock,Measuring measuring) {
		orderRepository.updateStockByPk(stock);
		orderRepository.deletOrderByOrderId(order.getOrderId());
		orderRepository.insertOrderWithNotVersion(order);
		this.deleteMeasuring(measuring);
	}
	
	@Override
	public void deleteOrderAddVersionAndStock(Order order, Stock stock,Measuring measuring) {
		orderRepository.updateStockByPk(stock);
		orderRepository.deletOrderByOrderId(order.getOrderId());
		orderRepository.insertOrder(order);
		this.deleteMeasuring(measuring);
	}


	@Override
	public void deleteOrder(Order order) {
		orderRepository.deletOrderByOrderId(order.getOrderId());
		orderRepository.insertOrder(order);
	}


	@Override
	public void physicalDeleteOrder(Stock stock, String orderId) {
		if(stock == null) {
			orderRepository.deletOrderByOrderId(orderId);
			measuringRepository.deleteByPrimaryKey(orderId);
		}else {
			orderRepository.updateStockByPk(stock);
			orderRepository.deletOrderByOrderId(orderId);
			measuringRepository.deleteByPrimaryKey(orderId);
		}
	}


	@Override
	public void deleteMeasuringBothOrder(String orderId) {
		orderRepository.deletOrderByOrderId(orderId);
		measuringRepository.deleteByPrimaryKey(orderId);
	}


	@Override
	public void updateStockByPkAndOrderAndCash(Stock stockDb, Order order, Cash cash) {
		this.updateOrderNotCheck(order);
		this.updateStockByPk(stockDb);
		this.updateCash(cash);
	}


	@Override
	public void updateOrderAndCash(Order order, Cash cash) {
		this.updateOrderNotCheck(order);
		this.updateCash(cash);
	}


	@Override
	public void deletOrderWithNotVersion(Order order) {
		Order orderDb = orderListRepository.findOrderByPk(order.getOrderId());
		if (orderDb == null) {
			orderRepository.insertOrderWithNotVersion(order);
		} else {
			orderRepository.deletOrderByOrderId(order.getOrderId());
			orderRepository.insertOrderWithNotVersion(order);
		}

	}


	@Override
	public void deletOrder(Order order, Short version, String saveFlag) {
		Order orderDb = orderListRepository.findOrderByPk(order.getOrderId());
		Short orderDbVersion = orderDb.getVersion();
		if(version.equals(orderDbVersion)) {
			orderRepository.deletOrderByOrderId(order.getOrderId());
			orderRepository.insertOrder(order,saveFlag);
		}else {
			ResultMessages messages = ResultMessages.error();
            messages.add("E023");
            logger.error(messages.toString());
            throw new ResourceNotFoundException(messages);
		}
	}


	@Override
	public void updateStockByPkAndOrder(Stock stockDb, Order order) {
		this.updateOrderNotCheck(order);
		this.updateStockByPk(stockDb);
	}


	@Override
	public void deletOrderisExistence(Order order) {
		orderRepository.deletOrderByOrderId(order.getOrderId());
		orderRepository.insertOrder(order);
	}


	@Override
	public String selectOrderIdBySequence() {
		String last8digits = orderRepository.selectOrderIdBySequence();
		return last8digits;
	}


	@Override
	public List<OrderPrice> getTuxedoOrderPrice(String orderPattern) {
		List<OrderPrice> orderList = orderRepository.getTuxedoOrderPrice(orderPattern);
		return orderList;
	}


	@Override
	public List<OrderPrice> getWashableOrderPrice(String orderPattern) {
		List<OrderPrice> orderList = orderRepository.getWashableOrderPrice(orderPattern);
		return orderList;
	}

	@Override
	public List<OrderPrice> getStandardSomePrice(String orderPattern,String optionCode,String itemCode,String subItemCode) {
		List<OrderPrice> standardSomePriceList = orderRepository.getStandardSomePrice(orderPattern,optionCode,itemCode,subItemCode);
		return standardSomePriceList;
	}

	@Override
	public List<Model> getFactoriesCo(String orderPattern, String itemCode) {
		List<Model> modelList = orderRepository.getFactoriesCo(orderPattern,itemCode);
		return modelList;
	}


	@Override
	public List<OrderPrice> getOrderPriceNotCate(String coType) {
		List<OrderPrice> orderList = orderRepository.getOrderPriceNotCate(coType);
		return orderList;
	}


	@Override
	public void deletOrderWithNotVersionAndStock(Order order, Order orderIsExist,String item,String userId,Measuring measuring) {
		Order orderDb = orderListRepository.findOrderByPk(order.getOrderId());
		if (orderDb == null) {
			orderRepository.insertOrderWithNotVersion(order);
		} else {
			stockRecovery(orderIsExist,item,userId);
			orderRepository.deletOrderByOrderId(order.getOrderId());
			orderRepository.insertOrderWithNotVersion(order);
			this.deleteMeasuring(measuring);
		}
	}

	@Override
	public void deletOrderAddVersionAndStock(Order order, Order orderIsExist,String item,String userId,Measuring measuring) {
		Order orderDb = orderListRepository.findOrderByPk(order.getOrderId());
		if (orderDb == null) {
			orderRepository.insertOrderWithNotVersion(order);
		} else {
			stockRecovery(orderIsExist,item,userId);
			orderRepository.deletOrderByOrderId(order.getOrderId());
			orderRepository.insertOrderWithNotVersion(order);
			this.deleteMeasuring(measuring);
		}
	}

	private void stockRecovery(Order order,String item,String userId) {
		if ("1".equals(order.getTheoreticalStockCheck())) {
			BigDecimal stockNum = order.getTheoryFabricUsedMount();
			Stock stockDb = this.getStock(order.getProductFabricNo(),order.getOrderPattern());
			logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() 
			+ "、注文ID："+order.getOrderId()  
			+ "、ITEM："+item 
			+ "、生地品番："+order.getProductFabricNo() 
			+ "、理論在庫："+stockDb.getTheoreticalStock() 
			+ "、予約生地量："+stockDb.getReservationStock() + "」");
			BigDecimal reservationStock = stockDb.getReservationStock();
			stockDb.setReservationStock(reservationStock.subtract(stockNum));
			stockDb.setUpdatedUserId(userId);
			stockDb.setUpdatedAt(new Date());
			this.updateStockByPk(stockDb);
			Stock stockAfter = this.getStock(order.getProductFabricNo(),order.getOrderPattern());
			logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() 
			+ "、注文ID："+order.getOrderId()  
			+ "、ITEM："+item
			+ "、生地品番："+order.getProductFabricNo() 
			+ "、理論在庫："+stockAfter.getTheoreticalStock() 
			+ "、予約生地量："+stockAfter.getReservationStock() + "」");
		}
	}


	@Override
	public void deleteOrderAndStock(Order order, Stock stock, Measuring measuring, Order orderIsExist, String item,
			String userId) {
		stockRecovery(orderIsExist,item,userId);
		Stock stockDb = this.getStock(order.getProductFabricNo(), order.getOrderPattern());
		logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫更新前：「注文パターン：" + order.getOrderPattern() + "、注文ID："
				+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
				+ stockDb.getTheoreticalStock() + "、予約生地量：" + stockDb.getReservationStock() + "」");
		orderRepository.updateStockByPk(stock);
		orderRepository.deletOrderByOrderId(order.getOrderId());
		orderRepository.insertOrderWithNotVersion(order);
		this.deleteMeasuring(measuring);
	}


	@Override
	public void deleteOrderAndStock(Order order, Measuring measuring, Order orderIsExist, String item, String userId) {
		stockRecovery(orderIsExist,item,userId);
		Stock stock = this.getStock(order.getProductFabricNo(), order.getOrderPattern());
		logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫更新前：「注文パターン：" + order.getOrderPattern() + "、注文ID："
				+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
				+ stock.getTheoreticalStock() + "、予約生地量：" + stock.getReservationStock() + "」");
		BigDecimal reservationStock = stock.getReservationStock();
		BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
		stock.setReservationStock(reservationStock.add(theoryFabricUsedMount));
		stock.setUpdatedUserId(userId);
		stock.setUpdatedAt(new Date());
		order.setTheoreticalStockCheck("1");
		orderRepository.updateStockByPk(stock);
		orderRepository.deletOrderByOrderId(order.getOrderId());
		orderRepository.insertOrderWithNotVersion(order);
		this.deleteMeasuring(measuring);
	}
	
	@Override
	public void deleteOrderAddVersionAndStock(Order order, Measuring measuring, Order orderIsExist, String item, String userId) {
		stockRecovery(orderIsExist,item,userId);
		Stock stock = this.getStock(order.getProductFabricNo(), order.getOrderPattern());
		logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫更新前：「注文パターン：" + order.getOrderPattern() + "、注文ID："
				+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
				+ stock.getTheoreticalStock() + "、予約生地量：" + stock.getReservationStock() + "」");
		BigDecimal reservationStock = stock.getReservationStock();
		BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
		stock.setReservationStock(reservationStock.add(theoryFabricUsedMount));
		stock.setUpdatedUserId(userId);
		stock.setUpdatedAt(new Date());
		order.setTheoreticalStockCheck("1");
		orderRepository.updateStockByPk(stock);
		orderRepository.deletOrderByOrderId(order.getOrderId());
		orderRepository.insertOrder(order);
		this.deleteMeasuring(measuring);
	}


	@Override
	public void deletOrderWithNotVersionAndMeasuring(Order order, Measuring measuring) {
		Order orderDb = orderListRepository.findOrderByPk(order.getOrderId());
		if (orderDb == null) {
			orderRepository.insertOrderWithNotVersion(order);
		} else {
			orderRepository.deletOrderByOrderId(order.getOrderId());
			orderRepository.insertOrderWithNotVersion(order);
		}
		this.deleteMeasuring(measuring);
	}


	@Override
	public void deletOrderisExistence(Order order, Measuring measuring) {
		Order orderDb = orderListRepository.findOrderByPk(order.getOrderId());
		if (orderDb == null) {
			orderRepository.insertOrder(order);
		} else {
			orderRepository.deletOrderByOrderId(order.getOrderId());
			orderRepository.insertOrder(order);
		}
		this.deleteMeasuring(measuring);
	}

}
