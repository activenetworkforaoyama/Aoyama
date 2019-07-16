package co.jp.aoyama.macchinetta.domain.service.cash;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.CashInfo;
import co.jp.aoyama.macchinetta.domain.repository.cash.CashRepository;

@Service
@Transactional
public class CashServiceImpl implements CashService {
	
	@Inject
	CashRepository cashRepository;

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
	public Boolean updateCashByPrimaryKey(List<Cash> cashList) {
		List<Cash> cashUpdList = new ArrayList<Cash>();
		for(int i = 0;i<cashList.size();i++) {
			Cash cash =  cashList.get(i);
			if("1".equals(cash.getOptionType())) {
				Cash cashFind = cashRepository.selectByPrimaryKey(cash.getCashId());
				if(cashFind != null) {
					cash.setUpdatedAt(new Date());
					cashUpdList.add(cash);
				}else {
					ResultMessages messages = ResultMessages.error();
		            messages.add("E019", cash.getCashId());
		            throw new ResourceNotFoundException(messages);
				}
			}
		}
		if(cashUpdList.size() != 0) {
			cashRepository.updateCashByPrimaryKey(cashUpdList);
		}
		return true;
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

}
