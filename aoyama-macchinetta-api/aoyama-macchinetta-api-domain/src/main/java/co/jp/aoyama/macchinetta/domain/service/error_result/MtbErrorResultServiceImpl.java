package co.jp.aoyama.macchinetta.domain.service.error_result;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;
import co.jp.aoyama.macchinetta.domain.model.MtbErrorResult;
import co.jp.aoyama.macchinetta.domain.repository.error_result.MtbErrorResultRepository;
import co.jp.aoyama.macchinetta.domain.repository.order.DtbOrderRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class MtbErrorResultServiceImpl implements MtbErrorResultService {

	
	@Inject
	MtbErrorResultRepository mtbErrorResultRepository;

	@Override
	public int insert(MtbErrorResult mtbErrorResult) {
		
		return mtbErrorResultRepository.insert(mtbErrorResult);
	}

	@Override
	public List<MtbErrorResult> selectAll() {
		// 全部検索
		return mtbErrorResultRepository.selectAll();
	}

	@Override
	public int deleteByOrderId(String orderId) {

		return mtbErrorResultRepository.deleteByOrderId(orderId);
	}


	
}
