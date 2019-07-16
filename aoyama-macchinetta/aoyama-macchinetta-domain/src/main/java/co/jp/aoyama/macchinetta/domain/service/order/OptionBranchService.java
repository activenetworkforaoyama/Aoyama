package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.OptionBranch;

public interface OptionBranchService {

	List<OptionBranch> selectAll();
	
	List<OptionBranch> getStandardOption(String type);
	
	List<OptionBranch> getTuxedoOption(String type);
	
	List<OptionBranch> getWashableOption(String type);

	List<OptionBranch> getAllOption(String orderPattern);
}
