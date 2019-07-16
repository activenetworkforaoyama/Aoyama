package co.jp.aoyama.macchinetta.domain.repository.consumption;

import co.jp.aoyama.macchinetta.domain.model.Consumption;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ConsumptionRepository {
    int deleteByPrimaryKey(Date startDate);

    int insert(Consumption record);

    Consumption selectByPrimaryKey(Date startDate);

    List<Consumption> selectAll();

    int updateByPrimaryKey(Consumption record);

	int getTaxRate(@Param("date") Date date);
}