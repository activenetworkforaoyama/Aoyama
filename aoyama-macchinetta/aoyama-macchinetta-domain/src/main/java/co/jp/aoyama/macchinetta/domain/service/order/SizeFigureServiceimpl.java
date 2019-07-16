package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.SizeFigure;
import co.jp.aoyama.macchinetta.domain.repository.order.SizeFigureRepository;

@Service
@Transactional
public class SizeFigureServiceimpl implements SizeFigureService{
	@Inject
	SizeFigureRepository sizeFigureRepository;
	
	@Override
	public List<SizeFigure> getFigureList(String poType) {
		List<SizeFigure> figureList = sizeFigureRepository.getFigureList(poType);
		return figureList;
	}

}
