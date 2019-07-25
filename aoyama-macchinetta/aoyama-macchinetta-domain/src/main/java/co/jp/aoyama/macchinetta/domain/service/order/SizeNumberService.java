package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.SizeNumber;

public interface SizeNumberService {

	List<SizeNumber> getNumberList(String poType);

	List<SizeNumber> getSizeNumberByItem(String orderPattern, String itemCode, String subItemCode, String modelCode);

}
