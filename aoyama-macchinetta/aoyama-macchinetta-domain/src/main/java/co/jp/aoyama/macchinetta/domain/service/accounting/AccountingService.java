package co.jp.aoyama.macchinetta.domain.service.accounting;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Accounting;

public interface AccountingService {
	List<Accounting> fuzzyQuery(Accounting accounting);
}
