package co.jp.aoyama.macchinetta.domain.repository.order;

import co.jp.aoyama.macchinetta.domain.model.Model;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelRepository {
    int deleteByPrimaryKey(@Param("orderPattern") String orderPattern, @Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode);

    int insert(Model record);

    Model selectByPrimaryKey(@Param("orderPattern") String orderPattern, @Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode);

    List<Model> selectAll();

    int updateByPrimaryKey(Model record);

	List<Model> getAllModel(@Param("orderPattern") String type);
}