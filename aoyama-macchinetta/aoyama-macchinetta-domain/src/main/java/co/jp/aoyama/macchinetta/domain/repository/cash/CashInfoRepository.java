package co.jp.aoyama.macchinetta.domain.repository.cash;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.CashInfo;

public interface CashInfoRepository {

	CashInfo selectOrderByOrderId(String orderId);
	
	List<CashInfo> selectOrderByCashId(String cashId);
	
	void updateOrderByOrderId(CashInfo cashInfo);
}
