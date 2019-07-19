package co.jp.aoyama.macchinetta.domain.service.generalcode;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.GeneralCode;
import co.jp.aoyama.macchinetta.domain.repository.generalcode.GeneralCodeRepository;

/**
 * 納期管理
 * @author wuzhengyang
 *
 */
@Service
@Transactional
public class GeneralCodeServiceImpl implements GeneralCodeService {

	@Inject
	GeneralCodeRepository GeneralCodeRepository;
	
	/**
	 * 主キーからオブジェクトが存在するかどうかを調べる
	 */
	@Override
	public List<GeneralCode> selectGeneralCodeByCodeType(GeneralCode generalCode) {
		List<GeneralCode> selectGeneralCodeByCodeType = GeneralCodeRepository.selectGeneralCodeByCodeType(generalCode);
		return selectGeneralCodeByCodeType;
	}
}
