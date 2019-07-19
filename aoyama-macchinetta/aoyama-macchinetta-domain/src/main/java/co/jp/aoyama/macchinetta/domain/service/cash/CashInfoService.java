package co.jp.aoyama.macchinetta.domain.service.cash;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.CashInfo;

public interface CashInfoService {

	CashInfo selectOrderByOrderId(String orderId);
	
	List<CashInfo> selectOrderByCashId(String cashId);

	void updateOrderByOrderId(CashInfo cashInfo);
	
	Boolean updateCashInfoByPrimaryKey(List<CashInfo> cashInfoList);
}
