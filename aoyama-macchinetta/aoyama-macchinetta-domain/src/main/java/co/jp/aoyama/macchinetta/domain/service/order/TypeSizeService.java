package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.TypeSize;

public interface TypeSizeService {

	List<TypeSize> getPoTypeSize(String orderPattern);

}
