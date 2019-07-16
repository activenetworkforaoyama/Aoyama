package co.jp.aoyama.macchinetta.domain.service.detail;

import java.math.BigDecimal;
import java.util.Date;

import co.jp.aoyama.macchinetta.domain.model.OrderDetail;

public interface OrderDetailService {

	OrderDetail selectActualStock(String fabricNo);
	
	void updateActualStock(String fabricId,BigDecimal remainActualStock,String updatedUserId,Date updatedAt);
}
