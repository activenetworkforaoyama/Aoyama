package co.jp.aoyama.macchinetta.domain.service.cash;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.CashInfo;
import co.jp.aoyama.macchinetta.domain.repository.cash.CashInfoRepository;
import co.jp.aoyama.macchinetta.domain.repository.cash.CashRepository;

@Service
@Transactional
public class CashServiceImpl implements CashService {
	
	@Inject
	CashRepository cashRepository;
	
	@Inject
	CashInfoRepository cashInfoRepository;

	@Override
	public Cash selectByPrimaryKey(String cashId) {
		Cash cash = cashRepository.selectByPrimaryKey(cashId);
		return cash;
	}

	@Override
	public List<Cash> selectAll() {
		List<Cash> cashList = cashRepository.selectAll();
		return cashList;
	}

	@Override
	public void insertCash(Cash cash) {
		cashRepository.insertCash(cash);
	}

	@Override
	public List<Cash> selectOrderByCashId(String cashId) {
		List<Cash> cashList = cashRepository.selectOrderByCashId(cashId);
		return cashList;
	}

	@Override
	public void updateCash(Cash cash) {
		// TODO Auto-generated method stub
		cashRepository.updateCash(cash);
	}

	@Override
	public Cash selectOrderByOrderId(String orderId) {
		Cash cash = cashRepository.selectOrderByOrderId(orderId);
		return cash;
	}
	
	@Override
	public void updateCashStatus(String cashId, String cashStatus, String updatedUserId, Date updatedAt) {
		cashRepository.updateCashStatus(cashId, cashStatus, updatedUserId, updatedAt);
	}
	
	@Override
	public Boolean updateCashInfoByPrimaryKey(List<CashInfo> cashInfoList) {
		// TODO Auto-generated method stub
		if(cashInfoList.size() != 0) {
			cashInfoRepository.updateCashInfoByPrimaryKey(cashInfoList);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void updateAll(List<CashInfo> cashInfoList, Cash cash) {
		// TODO Auto-generated method stub
		cashRepository.updateCash(cash);
		cashInfoRepository.updateCashInfoByPrimaryKey(cashInfoList);
		
	}

	@Override
	public void insertCashUpdateCashInfo(List<CashInfo> cashInfoList, Cash cash) {
		// TODO Auto-generated method stub
		cashRepository.insertCash(cash);
		cashInfoRepository.updateCashInfoByPrimaryKey(cashInfoList);
		
	}
	
}
