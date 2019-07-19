package co.jp.aoyama.macchinetta.domain.repository.generalcode;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.GeneralCode;

public interface GeneralCodeRepository {
    List<GeneralCode> selectGeneralCodeByCodeType(@Param("generalCode") GeneralCode generalCode);
}