package co.jp.aoyama.macchinetta.domain.service.errorResult;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.ErrorResult;
import co.jp.aoyama.macchinetta.domain.repository.errorResult.ErrorResultRepository;

@Service
@Transactional
public class ErrorResultServiceImpl implements ErrorResultService {
	@Inject
	ErrorResultRepository errorResultRepository;

	@Override
	public int insert(ErrorResult record) {
		return 0;
	}

	@Override
	public List<ErrorResult> selectAllErrorResultByOrderId(String orderId) {
		List<ErrorResult> errorResultList = errorResultRepository.selectAllErrorResultByOrderId(orderId);
		return errorResultList;
	}
	
	
}