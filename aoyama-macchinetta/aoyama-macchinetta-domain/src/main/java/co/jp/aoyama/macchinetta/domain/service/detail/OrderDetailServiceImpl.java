package co.jp.aoyama.macchinetta.domain.service.detail;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.OrderDetail;
import co.jp.aoyama.macchinetta.domain.repository.detail.OrderDetailRepository;
@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Inject
	OrderDetailRepository orderDetailRepository;
	
	@Override
	public OrderDetail selectActualStock(String fabricNo) {
		
		OrderDetail selectActualStock = orderDetailRepository.selectActualStock(fabricNo);
		return selectActualStock;
	}
	@Override
	public void updateActualStock(String fabricId, BigDecimal remainActualStock,String updatedUserId,Date updatedAt) {
		
		orderDetailRepository.updateActualStock(fabricId, remainActualStock,updatedUserId,updatedAt);
	}

}
