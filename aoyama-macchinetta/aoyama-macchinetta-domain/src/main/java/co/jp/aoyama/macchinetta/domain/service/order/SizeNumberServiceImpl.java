package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.SizeNumber;
import co.jp.aoyama.macchinetta.domain.repository.order.SizeNumberRepository;

@Service
@Transactional
public class SizeNumberServiceImpl implements SizeNumberService{
	@Inject
	SizeNumberRepository sizeNumberRepository;
	@Override
	public List<SizeNumber> getNumberList(String poType) {
		List<SizeNumber> numberList = sizeNumberRepository.getNumberList(poType);
		return numberList;
	}

}
