package co.jp.aoyama.macchinetta.domain.repository.cash;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.dto.CashUpdateCondition;
import co.jp.aoyama.macchinetta.domain.model.DtbCash;

public interface DtbCashRepository {
	int deleteByPrimaryKey(String cashId);

	int insert(DtbCash record);

	DtbCash selectByPrimaryKey(String cashId);

	List<DtbCash> selectAll();

	int updateByPrimaryKey(DtbCash record);

	/**
	 * 会計IDリストにより、会計データを更新する
	 * 
	 * @param condition 会計IDリストを含む更新オブジェクト
	 * @return 件数
	 */
	int updateByCashIds(@Param("condition") CashUpdateCondition condition, @Param("list") List<String> list);
}