package co.jp.aoyama.macchinetta.domain.service.detail;

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

}
