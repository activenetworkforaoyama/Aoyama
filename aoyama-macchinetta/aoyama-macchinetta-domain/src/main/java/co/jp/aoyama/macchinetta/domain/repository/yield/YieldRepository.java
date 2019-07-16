package co.jp.aoyama.macchinetta.domain.repository.yield;

import co.jp.aoyama.macchinetta.domain.model.Yield;
import java.util.List;

public interface YieldRepository {
    int insert(Yield record);

    List<Yield> selectAll();

	List<Yield> getYield();
}