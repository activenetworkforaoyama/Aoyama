package co.jp.aoyama.macchinetta.domain.service.yield;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Yield;
import co.jp.aoyama.macchinetta.domain.repository.yield.YieldRepository;
@Service
@Transactional
public class YieldServiceImpl implements YieldService{
	@Inject
	YieldRepository yieldRepository;

	@Override
	public List<Yield> getYield() {
		List<Yield> yieldList = yieldRepository.getYield();
		return yieldList;
	}
}
