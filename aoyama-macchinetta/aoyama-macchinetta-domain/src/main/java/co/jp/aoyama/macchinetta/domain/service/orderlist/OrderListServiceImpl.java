package co.jp.aoyama.macchinetta.domain.service.orderlist;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.FactoryOrder;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderCondition;
import co.jp.aoyama.macchinetta.domain.model.OrderDetail;
import co.jp.aoyama.macchinetta.domain.model.ShopTel;
import co.jp.aoyama.macchinetta.domain.repository.detail.OrderDetailRepository;
import co.jp.aoyama.macchinetta.domain.repository.orderlist.OrderListRepository;
import co.jp.aoyama.macchinetta.domain.repository.orderlist.ShopTelRepository;

@Service
@Transactional
public class OrderListServiceImpl implements OrderListService {
	@Inject
	OrderListRepository orderListRepository;
	
	@Inject
	OrderDetailRepository orderDetailRepository;

	@Inject
	ShopTelRepository shopTelRepository;
	
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
            messages.add("E020", orderId);
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
        }
		return order;
	}
	
	@Override
	public List<Order> findOrderByPkList(List<String> orderIdList) {
		List<Order> orderList = new ArrayList<Order>();
		for (int i = 0; i < orderIdList.size(); i++) {
			Order order = orderListRepository.findOrderByPk(orderIdList.get(i));
			orderList.add(order);
			if (order == null) {
				
				ResultMessages messages = ResultMessages.error();
				// 該当ユーザーのデータがありません。(orderid={0})
				messages.add("E020", order);
				logger.error(messages.toString());
				
				throw new ResourceNotFoundException(messages);
			}
		}
		return orderList;
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
		String orderPattern = order.getOrderPattern();
		BigDecimal fabricUsedMountOld = order.getFabricUsedMount();
		Short version = order.getVersion();
		if(version.equals(orderVersion)) {
			orderListRepository.updateSaveValue(orderId, fabricUsedMount, shippingDate, loadingDate,updatedUserId,updatedAt,orderVersion);
			OrderDetail selectActualStock = orderDetailRepository.selectActualStock(productFabricNo, orderPattern);
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
			this.updateActualStock(productFabricNo,remainActualStock,updatedUserId,updatedAt,orderPattern);
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
		String orderPattern = order.getOrderPattern();
		BigDecimal fabricUsedMountOld = order.getFabricUsedMount();
		Short version = order.getVersion();
		if(version.equals(orderVersion)) {
			orderListRepository.updateSaveValueAndStatus(orderId, fabricUsedMount, shippingDate, loadingDate,updatedUserId,updatedAt,orderVersion,shippingTransmitStatus);
			OrderDetail selectActualStock = orderDetailRepository.selectActualStock(productFabricNo, orderPattern);
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
			this.updateActualStock(productFabricNo,remainActualStock,updatedUserId,updatedAt,orderPattern);
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
		String orderPattern = order.getOrderPattern();
		BigDecimal fabricUsedMountOld = order.getFabricUsedMount();
		if(version.equals(orderVersion)) {
			orderListRepository.updateSaveOrChangeValue(orderId, fabricUsedMount, shippingDate, loadingDate, makerFactoryStatus,updatedUserId,updatedAt,orderVersion);
			OrderDetail selectActualStock = orderDetailRepository.selectActualStock(productFabricNo, orderPattern);
			BigDecimal actualStock = selectActualStock.getActualStock();
			BigDecimal remainActualStock;
			if(fabricUsedMountOld == null) {
				remainActualStock = actualStock.subtract(fabricUsedMount);
			}
			else {
				remainActualStock = actualStock.add(fabricUsedMountOld).subtract(fabricUsedMount);
			}
			
			this.updateActualStock(productFabricNo,remainActualStock,updatedUserId,updatedAt,orderPattern);
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
		String orderPattern = order.getOrderPattern();
		BigDecimal fabricUsedMountOld = order.getFabricUsedMount();
		if(version.equals(orderVersion)) {
			orderListRepository.updateSaveOrChangeValueAndStatus(orderId, fabricUsedMount, shippingDate, loadingDate, makerFactoryStatus,updatedUserId,updatedAt,orderVersion,shippingTransmitStatus);
			OrderDetail selectActualStock = orderDetailRepository.selectActualStock(productFabricNo, orderPattern);
			BigDecimal actualStock = selectActualStock.getActualStock();
			BigDecimal remainActualStock;
			if(fabricUsedMountOld == null) {
				remainActualStock = actualStock.subtract(fabricUsedMount);
			}
			else {
				remainActualStock = actualStock.add(fabricUsedMountOld).subtract(fabricUsedMount);
			}
			
			this.updateActualStock(productFabricNo,remainActualStock,updatedUserId,updatedAt,orderPattern);
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
	public void updateActualStock(String fabricNo,BigDecimal remainActualStock,String updatedUserId,Date updatedAt,String orderPattern) {
		
		orderListRepository.updateActualStock(fabricNo,remainActualStock,updatedUserId,updatedAt,orderPattern);
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

	@Override
	public Order findOrderPtOptionByOrderId(String orderId) {
		Order order = orderListRepository.findOrderPtOptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findOrderPt2OptionByOrderId(String orderId) {
		Order order = orderListRepository.findOrderPt2OptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findOrderCtOptionByOrderId(String orderId) {
		Order order = orderListRepository.findOrderCtOptionByOrderId(orderId);
		return order;
	}
	
	@Override
	public Order findOrderGlOptionByOrderId(String orderId) {
		Order order = orderListRepository.findOrderGlOptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findOrderStOptionByOrderId(String orderId) {
		Order order = orderListRepository.findOrderStOptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findOrderProductByPk(String orderId) {
		Order order = orderListRepository.findOrderProductByPk(orderId);
		return order;
	}

	@Override
	public Order findOrderByPkChinese(String orderId) {
		Order order = orderListRepository.findOrderByPkChinese(orderId);
		return order;
	}
	
	@Override
	public List<Order> fuzzyQueryDnp(OrderCondition orderCondition, List<String> memberList) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String productOrderDnpDateFrom = orderCondition.getProductOrderDnpDateFrom();
		String productOrderDnpDateTo = orderCondition.getProductOrderDnpDateTo();
		Date productOrderDnpDateFromDate = null;
		Date productOrderDnpDateFromToDate = null;
		try {
			if ( !"".equals(productOrderDnpDateFrom) && productOrderDnpDateFrom != null) {
				productOrderDnpDateFromDate = format.parse(productOrderDnpDateFrom.replaceAll("/", "-"));
				orderCondition.setProductOrderDnpDateFromDate(productOrderDnpDateFromDate);
			}
			if ( !"".equals(productOrderDnpDateTo) && productOrderDnpDateTo != null) {
				productOrderDnpDateFromToDate = format.parse(productOrderDnpDateTo.replaceAll("/", "-"));
				orderCondition.setProductOrderDnpDateToDate(productOrderDnpDateFromToDate);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		}
		
		List<Order> orderList = orderListRepository.fuzzyQueryDnp(orderCondition,memberList);
		
		return orderList;
	}

	@Override
	public Order findDnpOrderByPk(String orderId) {
		Order order = orderListRepository.findDnpOrderByPk(orderId);
        if (order == null) {
            
            ResultMessages messages = ResultMessages.error();
            // 該当ユーザーのデータがありません。(orderid={0})
            messages.add("E020", orderId);
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
        }
		return order;
	}

	@Override
	public Order findDnpOrderProductByPk(String orderId) {
		Order order = orderListRepository.findDnpOrderProductByPk(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderJkOptionByOrderId(String orderId) {
		Order order = orderListRepository.findDnpOrderJkOptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderJkByPk(String orderId) {
		Order order = orderListRepository.findDnpOrderJkByPk(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderPtOptionByOrderId(String orderId) {
		Order order = orderListRepository.findDnpOrderPtOptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderPtByPk(String orderId) {
		Order order=orderListRepository.findDnpOrderPtByPk(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderGlOptionByOrderId(String orderId) {
		Order order = orderListRepository.findDnpOrderGlOptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderGlByPk(String orderId) {
		Order order = orderListRepository.findDnpOrderGlByPk(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderPt2OptionByOrderId(String orderId) {
		Order order = orderListRepository.findDnpOrderPt2OptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderPt2ByPk(String orderId) {
		Order order=orderListRepository.findDnpOrderPt2ByPk(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderStOptionByOrderId(String orderId) {
		Order order = orderListRepository.findDnpOrderStOptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderStByPk(String orderId) {
		Order order = orderListRepository.findDnpOrderStByPk(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderCtOptionByOrderId(String orderId) {
		Order order = orderListRepository.findDnpOrderCtOptionByOrderId(orderId);
		return order;
	}

	@Override
	public Order findDnpOrderCtByPk(String orderId) {
		Order order=orderListRepository.findDnpOrderCtByPk(orderId);
		return order;
	}

	@Override
	public Map<String, String> findShopTel(String category) {
		List<ShopTel> shopTelList = shopTelRepository.findShopTel(category);
		Map<String, String> shopTelMap = new LinkedHashMap<String, String>();
		if(!shopTelList.isEmpty()) {
			for (ShopTel shopTelTest : shopTelList) {
				shopTelMap.put("","");
				shopTelMap.put(shopTelTest.getShopTel() + shopTelTest.getGyotai(), shopTelTest.getShopName()+"（"+shopTelTest.getShopTel()+"）");
			}
		}
		return shopTelMap;
	}

	@Override
	public List<Order> findDnpOrderByCondition(OrderCondition condition,List<String> memberList) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String productOrderDnpDateFrom = condition.getProductOrderDnpDateFrom();
		String productOrderDnpDateTo = condition.getProductOrderDnpDateTo();
		Date productOrderDnpDateFromDate = null;
		Date productOrderDnpDateFromToDate = null;
		try {
			if ( !"".equals(productOrderDnpDateFrom) && productOrderDnpDateFrom != null) {
				productOrderDnpDateFromDate = format.parse(productOrderDnpDateFrom.replaceAll("/", "-"));
				condition.setProductOrderDnpDateFromDate(productOrderDnpDateFromDate);
			}
			if ( !"".equals(productOrderDnpDateTo) && productOrderDnpDateTo != null) {
				productOrderDnpDateFromToDate = format.parse(productOrderDnpDateTo.replaceAll("/", "-"));
				condition.setProductOrderDnpDateToDate(productOrderDnpDateFromToDate);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		}
		
        List<Order> orderList = orderListRepository.findDnpOrderByCondition(condition,memberList);
        return orderList;
	}
	
	@Override
	public void updateDtbPdfManageStatus(List<String> updatePrintList) {
		orderListRepository.updateDtbPdfManageStatus(updatePrintList);
	}

	@Override
	public List<FactoryOrder> fuzzyFactoryQuery(OrderCondition condition) {
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
        List<FactoryOrder> orderList;
        if (0 < total) {
        	orderList = orderListRepository.fuzzyFactoryQuery(condition);
        } else {
        	orderList = Collections.emptyList();
        }
        return orderList;
	}

	@Override
	public List<FactoryOrder> findPrintStatus(List<FactoryOrder> orderIdList) {
		List<FactoryOrder> findPrintStatus = orderListRepository.findPrintStatus(orderIdList);
		return findPrintStatus;
	}

}
