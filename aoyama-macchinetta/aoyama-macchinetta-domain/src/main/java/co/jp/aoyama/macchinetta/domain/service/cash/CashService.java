package co.jp.aoyama.macchinetta.domain.service.cash;


import java.util.Date;
import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.CashInfo;

public interface CashService {

	Cash selectByPrimaryKey(String cashId);
	
	List<Cash> selectAll();
	
	List<Cash> selectOrderByCashId(String cashId);
	
	Cash selectOrderByOrderId(String orderId);
	
	void insertCash(Cash cash);
	
	void updateCash(Cash cash);
	
	void updateCashStatus(String cashId,String cashStatus,String updatedUserId,Date updatedAt);
	
	Boolean updateCashInfoByPrimaryKey(List<CashInfo> cashInfoList);
	
	void updateAll(List<CashInfo> cashInfoList, Cash cash);
	
	void insertCashUpdateCashInfo(List<CashInfo> cashInfoList, Cash cash);
}
