package co.jp.aoyama.macchinetta.domain.repository.order;

import co.jp.aoyama.macchinetta.domain.model.Item;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemRepository {
    int deleteByPrimaryKey(@Param("orderPattern") String orderPattern, @Param("itemCode") String itemCode);

    int insert(Item record);

    Item selectByPrimaryKey(@Param("orderPattern") String orderPattern, @Param("itemCode") String itemCode);

    List<Item> selectAll();

    int updateByPrimaryKey(Item record);

	List<Item> getAllItem(@Param("orderPattern") String type);
}