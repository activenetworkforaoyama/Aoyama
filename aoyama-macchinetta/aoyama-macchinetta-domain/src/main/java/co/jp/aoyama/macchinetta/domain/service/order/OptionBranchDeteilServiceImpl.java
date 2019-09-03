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
	public List<OptionBranchDetail> getStandardButtons(String itemCode,String subItemCode, String opButton, String orderPattern,String optionCode) {
		
		return optionBranchDetailRepository.getStandardButtons(itemCode,subItemCode,opButton,orderPattern,optionCode);
	}

	@Override
	public List<OptionBranchDetail> getTuxedoButtons(String itemCode,String subItemCode, String tpButton, String orderPattern) {
		return optionBranchDetailRepository.getTuxedoButtons(itemCode,subItemCode,tpButton,orderPattern);
	}

	@Override
	public List<OptionBranchDetail> getWashableButtons(String itemCode,String subItemCode, String wpButton, String orderPattern) {
		return optionBranchDetailRepository.getWashableButtons(itemCode,subItemCode,wpButton,orderPattern);
	}

	@Override
	public List<OptionBranchDetail> getAllOption(String orderPattern) {
		List<OptionBranchDetail> detailList =  optionBranchDetailRepository.getAllOption(orderPattern);
		return detailList;
	}

	@Override
	public List<OptionBranchDetail> getStandardButtonsList(String productItem, String orderPattern) {
		List<OptionBranchDetail> detailList = optionBranchDetailRepository.getStandardButtonsList(productItem, orderPattern);
		return detailList;
	}

	@Override
	public List<OptionBranchDetail> getTuxedoButtonsList(String productItem, String orderPattern) {
		List<OptionBranchDetail> tuxedoDetailList = optionBranchDetailRepository.getTuxedoButtonsList(productItem, orderPattern);
		return tuxedoDetailList;
	}

	@Override
	public List<OptionBranchDetail> getWashableButtonsList(String productItem, String orderPattern) {
		List<OptionBranchDetail> washableDetailList = optionBranchDetailRepository.getWashableButtonsList(productItem, orderPattern);
		return washableDetailList;
	}

}
