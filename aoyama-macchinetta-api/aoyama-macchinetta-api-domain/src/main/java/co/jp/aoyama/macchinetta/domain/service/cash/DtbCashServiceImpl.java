package co.jp.aoyama.macchinetta.domain.service.cash;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.DtbCash;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;
import co.jp.aoyama.macchinetta.domain.repository.cash.DtbCashRepository;
import co.jp.aoyama.macchinetta.domain.repository.order.DtbOrderRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class DtbCashServiceImpl implements DtbCashService {

	
	@Inject
	DtbCashRepository dtbCashRepository;

	@Override
	public int deleteByPrimaryKey(String cashId) {
		return dtbCashRepository.deleteByPrimaryKey(cashId);
	}

	@Override
	public int insert(DtbCash dtbCash) {
		
		return dtbCashRepository.insert(dtbCash);
	}

	@Override
	public DtbCash selectByPrimaryKey(String cashId) {
		
		return dtbCashRepository.selectByPrimaryKey(cashId);
	}

	@Override
	public List<DtbCash> selectAll() {
		
		return dtbCashRepository.selectAll();
	}

	@Override
	public int updateByPrimaryKey(DtbCash dtbCash) {
		
		return dtbCashRepository.updateByPrimaryKey(dtbCash);
	}


	
}
