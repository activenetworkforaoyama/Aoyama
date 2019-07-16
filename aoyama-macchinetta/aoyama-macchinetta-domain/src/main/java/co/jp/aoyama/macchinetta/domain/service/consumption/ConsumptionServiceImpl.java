package co.jp.aoyama.macchinetta.domain.service.consumption;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.repository.consumption.ConsumptionRepository;

@Service
@Transactional
public class ConsumptionServiceImpl implements ConsumptionService {
	@Inject
	ConsumptionRepository consumptionRepository;

	@Override
	public int getTaxRate(Date date) {
		int taxRate = consumptionRepository.getTaxRate(date);
		return taxRate;
	}
}
