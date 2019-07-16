package co.jp.aoyama.macchinetta.domain.repository.order;

import co.jp.aoyama.macchinetta.domain.model.Adjust;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdjustRepository {
    int deleteByPrimaryKey(@Param("orderPattern") String orderPattern, @Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("adjusteClass") String adjusteClass);

    int insert(Adjust record);

    Adjust selectByPrimaryKey(@Param("orderPattern") String orderPattern, @Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("adjusteClass") String adjusteClass);

    List<Adjust> selectAll();

    int updateByPrimaryKey(Adjust record);

	List<Adjust> getAllAdjust(@Param("orderPattern") String type);
}