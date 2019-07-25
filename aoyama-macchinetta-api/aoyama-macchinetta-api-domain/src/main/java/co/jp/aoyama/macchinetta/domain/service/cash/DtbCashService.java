package co.jp.aoyama.macchinetta.domain.service.cash;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.DtbCash;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;


public interface DtbCashService {
    int deleteByPrimaryKey(String cashId);

    int insert(DtbCash record);

    DtbCash selectByPrimaryKey(String cashId);

    List<DtbCash> selectAll();

    int updateByPrimaryKey(DtbCash record);

}
