package co.jp.aoyama.macchinetta.domain.repository.cash;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Cash;

public interface CashRepository {

    Cash selectByPrimaryKey(@Param("cashId")String cashId);

    List<Cash> selectAll();
    
    List<Cash> selectOrderByCashId(String cashId);
    
    Cash selectOrderByOrderId(String orderId);

    void insertCash(Cash cash);
    
    void updateCash(Cash cash);

    void updateCashByPrimaryKey(@Param("cashUpdList")List<Cash> cashUpdList);
    
    void updateCashStatus(String cashId,String cashStatus,String updatedUserId,Date updatedAt);

}
