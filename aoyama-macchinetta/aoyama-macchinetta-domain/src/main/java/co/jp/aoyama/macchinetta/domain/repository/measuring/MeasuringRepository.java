package co.jp.aoyama.macchinetta.domain.repository.measuring;

import co.jp.aoyama.macchinetta.domain.model.Measuring;
import java.util.List;

public interface MeasuringRepository {
    int deleteByPrimaryKey(String orderId);

    void insert(Measuring record);

    Measuring selectByPrimaryKey(String orderId);

    List<Measuring> selectAll();

    boolean updateByPrimaryKey(Measuring measuring);
}