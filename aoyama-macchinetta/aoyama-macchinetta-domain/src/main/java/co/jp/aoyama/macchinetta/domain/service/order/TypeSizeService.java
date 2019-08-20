package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.TypeSize;

public interface TypeSizeService {

	List<TypeSize> getPoTypeSize(String orderPattern, String subItemCode, String modelCode);

	List<TypeSize> getPoTypeSizeOptimization(String orderPattern, String subItemCode, String modelCode, String figure,
			String number);

}
