package co.jp.aoyama.macchinetta.domain.service.generalcode;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.GeneralCode;

public interface GeneralCodeService {
	
	List<GeneralCode> selectGeneralCodeByCodeType(GeneralCode generalCode);

}
