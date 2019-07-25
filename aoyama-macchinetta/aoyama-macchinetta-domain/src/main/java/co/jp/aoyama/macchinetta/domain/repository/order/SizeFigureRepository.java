package co.jp.aoyama.macchinetta.domain.repository.order;

import co.jp.aoyama.macchinetta.domain.model.SizeFigure;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SizeFigureRepository {
    int deleteByPrimaryKey(@Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode, @Param("figure") String figure);

    int insert(SizeFigure record);

    SizeFigure selectByPrimaryKey(@Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode, @Param("figure") String figure);

    List<SizeFigure> selectAll();

    int updateByPrimaryKey(SizeFigure record);

	List<SizeFigure> getFigureList(String poType);

	List<SizeFigure> getSizeFigureByItem(
			@Param("orderPattern")String orderPattern, 
			@Param("itemCode")String itemCode, 
			@Param("subItemCode")String subItemCode, 
			@Param("modelCode")String modelCode);
}