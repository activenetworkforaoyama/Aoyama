package co.jp.aoyama.macchinetta.domain.repository.errorResult;

import co.jp.aoyama.macchinetta.domain.model.ErrorResult;
import java.util.List;

public interface ErrorResultRepository {
    int insert(ErrorResult record);

    List<ErrorResult> selectAllErrorResultByOrderId(String orderId);
}