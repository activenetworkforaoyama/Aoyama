package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Adjust;

public interface AdjustService {

	List<Adjust> getAllAdjust(String type);

}
