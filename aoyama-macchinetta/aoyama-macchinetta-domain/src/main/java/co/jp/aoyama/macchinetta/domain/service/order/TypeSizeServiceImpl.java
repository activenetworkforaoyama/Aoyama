package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.repository.order.TypeSizeRepository;

@Service
@Transactional
public class TypeSizeServiceImpl implements TypeSizeService{
	@Inject
	TypeSizeRepository typeSizeRepository;
	@Override
	public List<TypeSize> getPoTypeSize(String orderPattern) {
		List<TypeSize> poTypeSizeList = typeSizeRepository.getPoTypeSize(orderPattern);
		return poTypeSizeList;
	}

}
