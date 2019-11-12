package co.jp.aoyama.macchinetta.domain.repository.order;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.CoSizeNumber;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;

public interface TypeSizeRepository {
    int deleteByPrimaryKey(@Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode, @Param("figure") String figure, @Param("sizeNumber") String sizeNumber, @Param("adjustClass") String adjustClass);

    int insert(TypeSize record);

    TypeSize selectByPrimaryKey(@Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode, @Param("figure") String figure, @Param("sizeNumber") String sizeNumber, @Param("adjustClass") String adjustClass);

    List<TypeSize> selectAll();

    int updateByPrimaryKey(TypeSize record);

	List<TypeSize> getPoTypeSize(String orderPattern, String subItemCode, String modelCode);

	List<TypeSize> getPoTypeSizeOptimization(@Param("orderPattern")String orderPattern, @Param("subItemCode")String subItemCode,@Param("modelCode")String modelCode, @Param("figure")String figure,
			@Param("sizeNumber") String sizeNumber);
	
	List<CoSizeNumber> getCoSizeNumberByItem(@Param("orderPattern")String orderPattern, @Param("subItemCode")String subItemCode, @Param("figure")String figure,@Param("modelCode")String modelCode);

}