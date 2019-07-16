package co.jp.aoyama.macchinetta.domain.service.measuring;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.repository.measuring.MeasuringRepository;

@Service
@Transactional
public class MeasuringServiceImpl implements MeasuringService{
	@Inject
	MeasuringRepository measuringRepository;

	@Override
	public Measuring selectByPrimaryKey(String orderId) {
		Measuring measuring = measuringRepository.selectByPrimaryKey(orderId);
		return measuring;
	}

	@Override
	public boolean updateByPrimaryKey(Measuring measuring) {
		Measuring isExist = measuringRepository.selectByPrimaryKey(measuring.getOrderId());
		if(isExist != null) {
			measuringRepository.updateByPrimaryKey(measuring);
		}
		else{
			measuringRepository.insert(measuring);
		}
		return true;
	}

	@Override
	public void insertMeasuring(Measuring measuring) {
		measuringRepository.insert(measuring);
	}

	@Override
	public void deleteByOrderId(String orderId) {
		measuringRepository.deleteByPrimaryKey(orderId);
	}
}
