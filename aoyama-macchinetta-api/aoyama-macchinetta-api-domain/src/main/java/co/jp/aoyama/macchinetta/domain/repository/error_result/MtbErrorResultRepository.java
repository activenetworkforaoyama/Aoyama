package co.jp.aoyama.macchinetta.domain.repository.error_result;

import co.jp.aoyama.macchinetta.domain.model.MtbErrorResult;

import java.util.List;

public interface MtbErrorResultRepository {
	int insert(MtbErrorResult record);

	List<MtbErrorResult> selectAll();

	int deleteByOrderId(String orderId);

	int deleteByOrderIds(List<String> orderIds);
}