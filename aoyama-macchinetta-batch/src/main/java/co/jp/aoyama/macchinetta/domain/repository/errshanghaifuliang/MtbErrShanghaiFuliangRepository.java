package co.jp.aoyama.macchinetta.domain.repository.errshanghaifuliang;

import co.jp.aoyama.macchinetta.domain.model.MtbErrShanghaiFuliang;
import java.util.List;

public interface MtbErrShanghaiFuliangRepository {
    int insert(MtbErrShanghaiFuliang record);

    List<MtbErrShanghaiFuliang> selectAll();
}