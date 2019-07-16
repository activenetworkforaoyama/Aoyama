package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.OptionBranchDetail;
import co.jp.aoyama.macchinetta.domain.repository.order.OptionBranchDetailRepository;;


@Service
@Transactional
public class OptionBranchDeteilServiceImpl implements OptionBranchDeailService {
	@Inject
	OptionBranchDetailRepository optionBranchDetailRepository;

	@Override
	public List<OptionBranchDetail> getStandardButtons(String subItemCode, String opButton, String orderPattern,String optionCode) {
		
		return optionBranchDetailRepository.getStandardButtons(subItemCode,opButton,orderPattern,optionCode);
	}

	@Override
	public List<OptionBranchDetail> getTuxedoButtons(String subItemCode, String tpButton, String orderPattern) {
		return optionBranchDetailRepository.getTuxedoButtons(subItemCode,tpButton,orderPattern);
	}

	@Override
	public List<OptionBranchDetail> getWashableButtons(String subItemCode, String wpButton, String orderPattern) {
		return optionBranchDetailRepository.getWashableButtons(subItemCode,wpButton,orderPattern);
	}

	@Override
	public List<OptionBranchDetail> getAllOption(String orderPattern) {
		List<OptionBranchDetail> detailList =  optionBranchDetailRepository.getAllOption(orderPattern);
		return detailList;
	}

}
