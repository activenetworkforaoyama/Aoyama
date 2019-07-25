package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.repository.order.AdjustRepository;

@Service
@Transactional
public class AdjustServiceImpl implements AdjustService{
	@Inject
	AdjustRepository adjustRepository;
	@Override
	public List<Adjust> getAllAdjust(String type) {
		List<Adjust> allAdjust = adjustRepository.getAllAdjust(type);
		return allAdjust;
	}
	@Override
	public List<Adjust> getAdjustByItem(String orderPattern, String itemCode) {
		List<Adjust> adjustList = adjustRepository.getAdjustByItem(orderPattern,itemCode);
		return adjustList;
	}

}
