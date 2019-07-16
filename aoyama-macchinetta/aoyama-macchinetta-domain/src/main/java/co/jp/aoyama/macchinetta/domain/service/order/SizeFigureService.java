package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.SizeFigure;

public interface SizeFigureService {

	List<SizeFigure> getFigureList(String poType);

}
