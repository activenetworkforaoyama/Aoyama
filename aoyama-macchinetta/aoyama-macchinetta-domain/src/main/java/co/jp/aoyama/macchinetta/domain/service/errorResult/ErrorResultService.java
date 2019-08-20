package co.jp.aoyama.macchinetta.domain.service.errorResult;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.ErrorResult;

public interface ErrorResultService {
	int insert(ErrorResult record);

    List<ErrorResult> selectAllErrorResultByOrderId(String orderId);
	
}
