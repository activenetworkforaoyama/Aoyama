package co.jp.aoyama.macchinetta.domain.service.cash;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.CashInfo;
import co.jp.aoyama.macchinetta.domain.repository.cash.CashInfoRepository;

@Service
@Transactional
public class CashInfoServiceImpl implements CashInfoService {
	
	@Inject
	CashInfoRepository cashInfoRepository;

	@Override
	public CashInfo selectOrderByOrderId(String orderId) {
		CashInfo cashInfo = cashInfoRepository.selectOrderByOrderId(orderId);
		return cashInfo;
	}

	@Override
	public void updateOrderByOrderId(CashInfo cashInfo) {
		// TODO Auto-generated method stub
		cashInfoRepository.updateOrderByOrderId(cashInfo);
	}

	@Override
	public List<CashInfo> selectOrderByCashId(String cashId) {
		// TODO Auto-generated method stub
		List<CashInfo> cashInfoList = cashInfoRepository.selectOrderByCashId(cashId);
		return cashInfoList;
	}

}
