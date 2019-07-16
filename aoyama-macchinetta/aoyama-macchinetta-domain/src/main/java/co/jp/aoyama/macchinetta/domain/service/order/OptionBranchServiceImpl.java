package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.OptionBranch;
import co.jp.aoyama.macchinetta.domain.repository.order.OptionBranchRepository;


@Service
@Transactional
public class OptionBranchServiceImpl implements OptionBranchService{
	@Inject
	OptionBranchRepository optionBranchRepository;

	@Override
	public List<OptionBranch> selectAll() {
		List<OptionBranch> selectAll = optionBranchRepository.selectAll();
		return selectAll;
	}

	@Override
	public List<OptionBranch> getStandardOption(String type) {
		List<OptionBranch> pantsOptionList = optionBranchRepository.getStandardOption(type);
		return pantsOptionList;
	}

	@Override
	public List<OptionBranch> getTuxedoOption(String type) {
		List<OptionBranch> pantsTuOptionList = optionBranchRepository.getTuxedoOption(type);
		return pantsTuOptionList;
	}

	@Override
	public List<OptionBranch> getWashableOption(String type) {
		List<OptionBranch> pantsWaOptionList = optionBranchRepository.getWashableOption(type);
		return pantsWaOptionList;
	}

	@Override
	public List<OptionBranch> getAllOption(String orderPattern) {
		List<OptionBranch> allOptionList = optionBranchRepository.getAllOption(orderPattern);
		return allOptionList;
	}
}
