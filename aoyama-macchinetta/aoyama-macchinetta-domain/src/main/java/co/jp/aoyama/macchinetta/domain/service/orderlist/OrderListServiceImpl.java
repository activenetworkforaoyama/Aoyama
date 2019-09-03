package co.jp.aoyama.macchinetta.domain.service.orderlist;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderCondition;
import co.jp.aoyama.macchinetta.domain.model.OrderDetail;
import co.jp.aoyama.macchinetta.domain.repository.orderlist.OrderListRepository;
import co.jp.aoyama.macchinetta.domain.service.detail.OrderDetailService;

@Service
@Transactional
public class OrderListServiceImpl implements OrderListService {
	@Inject
	OrderListRepository orderListRepository;
	@Inject
	OrderDetailService orderDetailService;

	@Override
	public List<Order> findAllOrder() {
		List<Order> orderList = orderListRepository.findAllOrder();
		return orderList;
	}

    private static final Logger logger = LoggerFactory
            .getLogger(OrderListServiceImpl.class);
	
	@Override
	public List<Order> findOrderByCondition(OrderCondition condition) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		try {
			if ( !"".equals(condition.getProductOrderdDateFrom()) && condition.getProductOrderdDateFrom() != null) {
			   condition.setProductOrderdDate2From(format.parse(condition.getProductOrderdDateFrom()));
			}
			if ( !"".equals(condition.getProductOrderdDateTo()) && condition.getProductOrderdDateTo() != null) {
			   condition.setProductOrderdDate2To(format.parse(condition.getProductOrderdDateTo()));
			}
			if ( !"".equals(condition.getCustShopDeliveryDateFrom()) && condition.getCustShopDeliveryDateFrom() != null) {
			   condition.setCustShopDeliveryDate2From(format.parse(condition.getCustShopDeliveryDateFrom()));
			}
			if ( !"".equals(condition.getCustShopDeliveryDateTo()) && condition.getCustShopDeliveryDateTo() != null) {
			   condition.setCustShopDeliveryDate2To(format.parse(condition.getCustShopDeliveryDateTo()));
			}
			if ( !"".equals(condition.getUpdatedAtFrom()) && condition.getUpdatedAtFrom() != null) {
			   condition.setUpdatedAt2From(format.parse(condition.getUpdatedAtFrom()));
			}
			if ( !"".equals(condition.getUpdatedAtTo()) && condition.getUpdatedAtTo() != null) {
				Calendar calendar = new GregorianCalendar(); 
				calendar.setTime(format.parse(condition.getUpdatedAtTo())); 
				calendar.add(5,1);
				calendar.add(14,-1);
				condition.setUpdatedAt2To(calendar.getTime());
			}
			if ( !"".equals(condition.getCustDeliverDateFrom()) && condition.getCustDeliverDateFrom() != null) {
			   condition.setCustDeliverDate2From(format.parse(condition.getCustDeliverDateFrom()));
			}
			if ( !"".equals(condition.getCustDeliverDateTo()) && condition.getCustDeliverDateTo() != null) {
			   condition.setCustDeliverDate2To(format.parse(condition.getCustDeliverDateTo()));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
        long total = orderListRepository.countOrderByCondition(condition);
        List<Order> orderList;
        if (0 < total) {
        	orderList = orderListRepository.findOrderByCondition(condition);
        } else {
        	orderList = Collections.emptyList();
        }
        return orderList;
	}

	@Override
	public Order findOrderByPk(String orderId) {
		Order order = orderListRepository.findOrderByPk(orderId);
        if (order == null) {
            
            ResultMessages messages = ResultMessages.error();
            // 該当ユーザーのデータがありません。(orderid={0})
            messages.add("E020", order);
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
        }
		return order;
	}

	@Override
	public void updateTscStatus(String orderId, String changeTscStatus,String updatedUserId,Date updatedAt,Short orderVersion) {
		Order order = orderListRepository.findOrderByPk(orderId);
		Short version = order.getVersion();
		if(orderVersion.equals(version)) {
			orderListRepository.updateTscStatus(orderId, changeTscStatus,updatedUserId,updatedAt,orderVersion);	
		}
		else {
			ResultMessages resultMessages = ResultMessages.error();
			// 該当ユーザーのデータがありません。(orderid={0})
			resultMessages.add("E023", order.getOrderId());
            logger.error(resultMessages.toString());

            throw new ResourceNotFoundException(resultMessages);
		}
	}

	@Override
	public void updateSaveValue(String orderId, BigDecimal fabricUsedMount, Date shippingDate, Date loadingDate,String updatedUserId,Date updatedAt,Short orderVersion) {
		Order order = orderListRepository.findOrderByPk(orderId);
		String productFabricNo = order.getProductFabricNo();
		BigDecimal fabricUsedMountOld = order.getFabricUsedMount();
		Short version = order.getVersion();
		if(version.equals(orderVersion)) {
			orderListRepository.updateSaveValue(orderId, fabricUsedMount, shippingDate, loadingDate,updatedUserId,updatedAt,orderVersion);
			OrderDetail selectActualStock = orderDetailService.selectActualStock(productFabricNo);
			BigDecimal actualStock = selectActualStock.getActualStock();
			BigDecimal remainActualStock;
			if(fabricUsedMountOld == null) {
				if(fabricUsedMount == null) {
					remainActualStock =actualStock.subtract(new BigDecimal(0.0));
				}
				else {
					remainActualStock =actualStock.subtract(fabricUsedMount);
				}
			}
			else{
				if(fabricUsedMount == null) {
					remainActualStock = actualStock.add(fabricUsedMountOld).subtract(new BigDecimal(0.0));
				}
				else {
					remainActualStock =actualStock.add(fabricUsedMountOld).subtract(fabricUsedMount);
				}
			}
			this.updateActualStock(productFabricNo,remainActualStock,updatedUserId,updatedAt);
		}
		else {
			 ResultMessages messages = ResultMessages.error();
	            messages.add("E023", orderId);
	            logger.error(messages.toString());
	            throw new ResourceNotFoundException(messages);
		}
	}
	
	@Override
	public void updateSaveValueAndStatus(String orderId, BigDecimal fabricUsedMount, Date shippingDate, Date loadingDate,String updatedUserId,Date updatedAt,Short orderVersion,String shippingTransmitStatus) {
		Order order = orderListRepository.findOrderByPk(orderId);
		String productFabricNo = order.getProductFabricNo();
		BigDecimal fabricUsedMountOld = order.getFabricUsedMount();
		Short version = order.getVersion();
		if(version.equals(orderVersion)) {
			orderListRepository.updateSaveValueAndStatus(orderId, fabricUsedMount, shippingDate, loadingDate,updatedUserId,updatedAt,orderVersion,shippingTransmitStatus);
			OrderDetail selectActualStock = orderDetailService.selectActualStock(productFabricNo);
			BigDecimal actualStock = selectActualStock.getActualStock();
			BigDecimal remainActualStock;
			if(fabricUsedMountOld == null) {
				if(fabricUsedMount == null) {
					remainActualStock =actualStock.subtract(new BigDecimal(0.0));
				}
				else {
					remainActualStock =actualStock.subtract(fabricUsedMount);
				}
			}
			else{
				if(fabricUsedMount == null) {
					remainActualStock = actualStock.add(fabricUsedMountOld).subtract(new BigDecimal(0.0));
				}
				else {
					remainActualStock =actualStock.add(fabricUsedMountOld).subtract(fabricUsedMount);
				}
			}
			this.updateActualStock(productFabricNo,remainActualStock,updatedUserId,updatedAt);
		}
		else {
			 ResultMessages messages = ResultMessages.error();
	            messages.add("E023", orderId);
	            logger.error(messages.toString());
	            throw new ResourceNotFoundException(messages);
		}
	}

	@Override
	public void updateSaveOrChangeValue(String orderId, BigDecimal fabricUsedMount, Date shippingDate, Date loadingDate,
			String makerFactoryStatus,String updatedUserId,Date updatedAt,Short orderVersion) {
		
		Order order = orderListRepository.findOrderByPk(orderId);
		Short version = order.getVersion();
		String productFabricNo = order.getProductFabricNo();
		BigDecimal fabricUsedMountOld = order.getFabricUsedMount();
		if(version.equals(orderVersion)) {
			orderListRepository.updateSaveOrChangeValue(orderId, fabricUsedMount, shippingDate, loadingDate, makerFactoryStatus,updatedUserId,updatedAt,orderVersion);
			OrderDetail selectActualStock = orderDetailService.selectActualStock(productFabricNo);
			BigDecimal actualStock = selectActualStock.getActualStock();
			BigDecimal remainActualStock;
			if(fabricUsedMountOld == null) {
				remainActualStock = actualStock.subtract(fabricUsedMount);
			}
			else {
				remainActualStock = actualStock.add(fabricUsedMountOld).subtract(fabricUsedMount);
			}
			
			this.updateActualStock(productFabricNo,remainActualStock,updatedUserId,updatedAt);
		}
		else {
			 ResultMessages messages = ResultMessages.error();
	            messages.add("E023", orderId);
	            logger.error(messages.toString());
	            throw new ResourceNotFoundException(messages);
		}
		
	}
	
	@Override
	public void updateSaveOrChangeValueAndStatus(String orderId, BigDecimal fabricUsedMount, Date shippingDate, Date loadingDate,
			String makerFactoryStatus,String updatedUserId,Date updatedAt,Short orderVersion,String shippingTransmitStatus) {
		
		Order order = orderListRepository.findOrderByPk(orderId);
		Short version = order.getVersion();
		String productFabricNo = order.getProductFabricNo();
		BigDecimal fabricUsedMountOld = order.getFabricUsedMount();
		if(version.equals(orderVersion)) {
			orderListRepository.updateSaveOrChangeValueAndStatus(orderId, fabricUsedMount, shippingDate, loadingDate, makerFactoryStatus,updatedUserId,updatedAt,orderVersion,shippingTransmitStatus);
			OrderDetail selectActualStock = orderDetailService.selectActualStock(productFabricNo);
			BigDecimal actualStock = selectActualStock.getActualStock();
			BigDecimal remainActualStock;
			if(fabricUsedMountOld == null) {
				remainActualStock = actualStock.subtract(fabricUsedMount);
			}
			else {
				remainActualStock = actualStock.add(fabricUsedMountOld).subtract(fabricUsedMount);
			}
			
			this.updateActualStock(productFabricNo,remainActualStock,updatedUserId,updatedAt);
		}
		else {
			 ResultMessages messages = ResultMessages.error();
	            messages.add("E023", orderId);
	            logger.error(messages.toString());
	            throw new ResourceNotFoundException(messages);
		}
		
	}

	@Override
	public void updateNextGeneration(String orderId, Integer nextGenerationP,String updatedUserId,Date updatedAt,Short orderVersion) {
		Order order = orderListRepository.findOrderByPk(orderId);
		Short version = order.getVersion();
		if(version.equals(orderVersion)) {
			orderListRepository.updateNextGeneration(orderId, nextGenerationP,updatedUserId,updatedAt,orderVersion);
		}
		else {
			 ResultMessages messages = ResultMessages.error();
	            messages.add("E023", orderId);
	            logger.error(messages.toString());
	            throw new ResourceNotFoundException(messages);
		}
		
	}
	
	@Override
	public void updateNextGenerationAndStatus(String orderId, Integer nextGenerationP,String updatedUserId,Date updatedAt,Short orderVersion,String scheduleDataTransmitStatus) {
		Order order = orderListRepository.findOrderByPk(orderId);
		Short version = order.getVersion();
		if(version.equals(orderVersion)) {
			orderListRepository.updateNextGenerationAndStatus(orderId, nextGenerationP,updatedUserId,updatedAt,orderVersion,scheduleDataTransmitStatus);
		}
		else {
			 ResultMessages messages = ResultMessages.error();
	            messages.add("E023", orderId);
	            logger.error(messages.toString());
	            throw new ResourceNotFoundException(messages);
		}
		
	}
	
	@Override
	public void updateActualStock(String fabricNo,BigDecimal remainActualStock,String updatedUserId,Date updatedAt) {
		
		orderListRepository.updateActualStock(fabricNo,remainActualStock,updatedUserId,updatedAt);
	}

	@Override
	public List<Order> fuzzyQuery(OrderCondition condition) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		try {
			if ( !"".equals(condition.getProductOrderdDateFrom()) && condition.getProductOrderdDateFrom() != null) {
			   condition.setProductOrderdDate2From(format.parse(condition.getProductOrderdDateFrom().replaceAll("/", "-")));
			}
			if ( !"".equals(condition.getProductOrderdDateTo()) && condition.getProductOrderdDateTo() != null) {
			   condition.setProductOrderdDate2To(format.parse(condition.getProductOrderdDateTo().replaceAll("/", "-")));
			}
			if ( !"".equals(condition.getCustShopDeliveryDateFrom()) && condition.getCustShopDeliveryDateFrom() != null) {
			   condition.setCustShopDeliveryDate2From(format.parse(condition.getCustShopDeliveryDateFrom().replaceAll("/", "-")));
			}
			if ( !"".equals(condition.getCustShopDeliveryDateTo()) && condition.getCustShopDeliveryDateTo() != null) {
			   condition.setCustShopDeliveryDate2To(format.parse(condition.getCustShopDeliveryDateTo().replaceAll("/", "-")));
			}
			if ( !"".equals(condition.getUpdatedAtFrom()) && condition.getUpdatedAtFrom() != null) {
			   condition.setUpdatedAt2From(format.parse(condition.getUpdatedAtFrom().replaceAll("/", "-")));
			}
			if ( !"".equals(condition.getUpdatedAtTo()) && condition.getUpdatedAtTo() != null) {
				Calendar calendar = new GregorianCalendar(); 
				calendar.setTime(format.parse(condition.getUpdatedAtTo().replaceAll("/", "-"))); 
				calendar.add(5,1);
				calendar.add(14,-1);
				condition.setUpdatedAt2To(calendar.getTime());
			}
			if ( !"".equals(condition.getCustDeliverDateFrom()) && condition.getCustDeliverDateFrom() != null) {
			   condition.setCustDeliverDate2From(format.parse(condition.getCustDeliverDateFrom().replaceAll("/", "-")));
			}
			if ( !"".equals(condition.getCustDeliverDateTo()) && condition.getCustDeliverDateTo() != null) {
			   condition.setCustDeliverDate2To(format.parse(condition.getCustDeliverDateTo().replaceAll("/", "-")));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
        long total = orderListRepository.countOrderByCondition(condition);
        List<Order> orderList;
        if (0 < total) {
        	orderList = orderListRepository.fuzzyQuery(condition);
        } else {
        	orderList = Collections.emptyList();
        }
        return orderList;
	}

	@Override
	public Order findOrderJkByPk(String orderId) {
		Order order=orderListRepository.findOrderJkByPk(orderId);
		return order;
	}

	@Override
	public Order findOrderPtByPk(String orderId) {
		Order order=orderListRepository.findOrderPtByPk(orderId);
		return order;
	}

	@Override
	public Order findOrderPt2ByPk(String orderId) {
		Order order=orderListRepository.findOrderPt2ByPk(orderId);
		return order;
	}

	@Override
	public Order findOrderGlByPk(String orderId) {
		Order order=orderListRepository.findOrderGlByPk(orderId);
		return order;
	}

	@Override
	public Order findOrderStByPk(String orderId) {
		Order order=orderListRepository.findOrderStByPk(orderId);
		return order;
	}

	@Override
	public Order findOrderCtByPk(String orderId) {
		Order order=orderListRepository.findOrderCtByPk(orderId);
		return order;
	}

	@Override
	public Order findOrderJkOptionByOrderId(String orderId) {
		Order order = orderListRepository.findOrderJkOptionByOrderId(orderId);
		return order;
	}

}
