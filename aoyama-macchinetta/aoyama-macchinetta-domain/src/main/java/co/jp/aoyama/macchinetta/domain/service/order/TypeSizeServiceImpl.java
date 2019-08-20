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
	public List<TypeSize> getPoTypeSize(String orderPattern,String subItemCode,String modelCode) {
		List<TypeSize> poTypeSizeList = typeSizeRepository.getPoTypeSize(orderPattern,subItemCode,modelCode);
		return poTypeSizeList;
	}
	@Override
	public List<TypeSize> getPoTypeSizeOptimization(String orderPattern, String subItemCode, String modelCode,
			String figure, String number) {
		List<TypeSize> poTypeSizeList = typeSizeRepository.getPoTypeSizeOptimization(orderPattern,subItemCode,modelCode,figure,number);
		return poTypeSizeList;
	}

}
