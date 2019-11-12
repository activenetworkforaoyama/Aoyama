package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.OptionBranchDetail;;

public interface OptionBranchDeailService {

	List<OptionBranchDetail> getStandardButtons(String itemCode,String subItemCode, String opButton, String orderPattern, String optionCode);

	List<OptionBranchDetail> getTuxedoButtons(String itemCode,String subItemCode, String tpButton, String orderPattern, String optionCode);

	List<OptionBranchDetail> getWashableButtons(String itemCode,String subItemCode, String wpButton, String orderPattern, String optionCode);

	List<OptionBranchDetail> getAllOption(String orderPattern);
	
	List<OptionBranchDetail> getStandardButtonsList(String productItem,String orderPattern);
	
	List<OptionBranchDetail> getTuxedoButtonsList(String productItem,String orderPattern);
	
	List<OptionBranchDetail> getWashableButtonsList(String productItem,String orderPattern);


}
