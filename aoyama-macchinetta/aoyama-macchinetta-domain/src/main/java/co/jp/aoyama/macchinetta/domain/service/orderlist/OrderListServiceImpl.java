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

import co.jp.aoyama.macchinetta.domain.model.OrderCondition;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.repository.orderlist.OrderListRepository;
import co.jp.aoyama.macchinetta.domain.service.user.MineUserServiceImpl;

@Service
@Transactional
public class OrderListServiceImpl implements OrderListService {
	@Inject
	OrderListRepository orderListRepository;

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
            // 該当ユーザーのデータがありません。(userid={0})
            messages.add("E020", order);
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
        }
		return order;
	}

	@Override
	public void updateTscStatus(String orderId, String changeTscStatus,String updatedUserId,Date updatedAt) {
		orderListRepository.updateTscStatus(orderId, changeTscStatus,updatedUserId,updatedAt);
	}

	@Override
	public void updateSaveValue(String orderId, BigDecimal fabricUsedMount, Date shippingDate, Date loadingDate,String updatedUserId,Date updatedAt) {
		orderListRepository.updateSaveValue(orderId, fabricUsedMount, shippingDate, loadingDate,updatedUserId,updatedAt);
	}

	@Override
	public void updateSaveOrChangeValue(String orderId, BigDecimal fabricUsedMount, Date shippingDate, Date loadingDate,
			String makerFactoryStatus,String updatedUserId,Date updatedAt) {
		orderListRepository.updateSaveOrChangeValue(orderId, fabricUsedMount, shippingDate, loadingDate, makerFactoryStatus,updatedUserId,updatedAt);
	}

	@Override
	public void updateNextGeneration(String orderId, Integer nextGenerationP,String updatedUserId,Date updatedAt) {
		orderListRepository.updateNextGeneration(orderId, nextGenerationP,updatedUserId,updatedAt);
	}
	


}
