package co.jp.aoyama.macchinetta.domain.service.cash;


import java.util.Date;
import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Cash;

public interface CashService {

	Cash selectByPrimaryKey(String cashId);
	
	List<Cash> selectAll();
	
	List<Cash> selectOrderByCashId(String cashId);
	
	Cash selectOrderByOrderId(String orderId);
	
	Boolean updateCashByPrimaryKey(List<Cash> cashList);
	
	void insertCash(Cash cash);
	
	void updateCash(Cash cash);
	
	void updateCashStatus(String cashId,String cashStatus,String updatedUserId,Date updatedAt);
}
