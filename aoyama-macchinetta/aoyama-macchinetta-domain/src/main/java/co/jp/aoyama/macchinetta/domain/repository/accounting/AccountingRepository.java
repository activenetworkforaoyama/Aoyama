package co.jp.aoyama.macchinetta.domain.repository.accounting;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Accounting;

public interface AccountingRepository {
	List<Accounting> fuzzyQuery(@Param("custCd")String custCd,@Param("storeStaffNm")String storeStaffNm,@Param("productOrderdDateFrom")Date productOrderdDateFrom,
			@Param("productOrderdDateTo")Date productOrderdDateTo,@Param("storeBrandCode")String storeBrandCode,@Param("cashStatus")String cashStatus,@Param("shopCode")String shopCode);

}
