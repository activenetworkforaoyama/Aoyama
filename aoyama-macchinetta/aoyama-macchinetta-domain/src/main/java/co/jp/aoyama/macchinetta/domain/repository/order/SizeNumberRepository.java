package co.jp.aoyama.macchinetta.domain.repository.order;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.SizeNumber;

public interface SizeNumberRepository {
    int deleteByPrimaryKey(@Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode, @Param("sizeNumber") String sizeNumber);

    int insert(SizeNumber record);

    SizeNumber selectByPrimaryKey(@Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode, @Param("sizeNumber") String sizeNumber);

    List<SizeNumber> selectAll();

    int updateByPrimaryKey(SizeNumber record);

	List<SizeNumber> getNumberList(String poType);

	List<SizeNumber> getSizeNumberByItem(@Param("orderPattern")String orderPattern, 
			@Param("itemCode")String itemCode, 
			@Param("subItemCode")String subItemCode, 
			@Param("modelCode")String modelCode);
}