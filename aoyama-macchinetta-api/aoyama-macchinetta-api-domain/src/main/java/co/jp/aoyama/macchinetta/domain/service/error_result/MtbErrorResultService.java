package co.jp.aoyama.macchinetta.domain.service.error_result;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.DtbOrder;
import co.jp.aoyama.macchinetta.domain.model.MtbErrorResult;


public interface MtbErrorResultService {
    int insert(MtbErrorResult record);

    List<MtbErrorResult> selectAll();

    int deleteByOrderId(String orderId);
}
