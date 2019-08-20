package co.jp.aoyama.macchinetta.domain.repository.accounting;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Accounting;

public interface AccountingRepository {
	List<Accounting> fuzzyQuery(@Param("accounting") Accounting accounting);
}
