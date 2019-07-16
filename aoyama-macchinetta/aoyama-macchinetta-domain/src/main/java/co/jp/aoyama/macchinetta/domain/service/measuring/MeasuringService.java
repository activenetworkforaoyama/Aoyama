package co.jp.aoyama.macchinetta.domain.service.measuring;

import co.jp.aoyama.macchinetta.domain.model.Measuring;

public interface MeasuringService {

	Measuring selectByPrimaryKey(String orderId);
	
	boolean updateByPrimaryKey(Measuring record);

	void insertMeasuring(Measuring measuring);

	void deleteByOrderId(String orderId);


}
