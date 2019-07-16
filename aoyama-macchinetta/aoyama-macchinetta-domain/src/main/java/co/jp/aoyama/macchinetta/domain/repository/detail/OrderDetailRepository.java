package co.jp.aoyama.macchinetta.domain.repository.detail;

import java.math.BigDecimal;
import java.util.Date;

import co.jp.aoyama.macchinetta.domain.model.OrderDetail;

public interface OrderDetailRepository {

	OrderDetail selectActualStock(String fabricNo);
	
	void updateActualStock(String fabricId,BigDecimal remainActualStock,String updatedUserId,Date updatedAt);
	
}
