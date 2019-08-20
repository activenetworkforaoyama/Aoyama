package co.jp.aoyama.macchinetta.domain.repository.stock;

import co.jp.aoyama.macchinetta.domain.dto.Stock;
import co.jp.aoyama.macchinetta.domain.model.MtbStock;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MtbStockRepository {
	int deleteByPrimaryKey(String fabricId);

	int insert(MtbStock record);

	MtbStock selectByPrimaryKey(String fabricId);

	List<MtbStock> selectAll();

	int updateByPrimaryKey(MtbStock record);

	Integer updateActualStockByFabricNo(@Param("stockList") List<Stock> stockList,@Param("batchUpdateUserid") String batchUpdateUserid);

	List<String> selectfabricNoList();
}