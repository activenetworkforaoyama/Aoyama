package co.jp.aoyama.macchinetta.domain.service.accounting;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Accounting;
import co.jp.aoyama.macchinetta.domain.repository.accounting.AccountingRepository;

@Service
@Transactional
public class AccountingServiceImpl implements AccountingService {

	@Inject
	AccountingRepository accountingRepository;
	@Override
	public List<Accounting> fuzzyQuery(Accounting accounting) {
		List<Accounting> accountingList = accountingRepository.fuzzyQuery(accounting.getCustCd(), accounting.getStoreStaffNm(), 
				accounting.getProductOrderdDateFrom(), accounting.getProductOrderdDateTo(), accounting.getStoreBrandCode(), accounting.getCashStatus(), accounting.getShopCode());
		return accountingList;
	}

}
