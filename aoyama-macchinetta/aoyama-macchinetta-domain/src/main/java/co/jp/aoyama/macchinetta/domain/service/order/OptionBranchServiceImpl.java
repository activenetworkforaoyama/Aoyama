package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.OptionBranch;
import co.jp.aoyama.macchinetta.domain.repository.order.OptionBranchRepository;


@Service
@Transactional
public class OptionBranchServiceImpl implements OptionBranchService{
	@Inject
	OptionBranchRepository optionBranchRepository;
	
	private static final Logger logger = LoggerFactory
            .getLogger(OptionBranchServiceImpl.class);

	@Override
	public List<OptionBranch> selectAll() {
		List<OptionBranch> selectAll = optionBranchRepository.selectAll();
		return selectAll;
	}

	@Override
	public List<OptionBranch> getStandardOption(String type) {
		List<OptionBranch> standardOptionList = optionBranchRepository.getStandardOption(type);
		if(standardOptionList.isEmpty()) {
			ResultMessages messages = ResultMessages.error();
            
            messages.add("E030");
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
		}
		return standardOptionList;
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

	@Override
	public List<OptionBranch> getProduct(String coType) {
		List<OptionBranch> productList = optionBranchRepository.getProduct(coType);
		return productList;
	}
}
