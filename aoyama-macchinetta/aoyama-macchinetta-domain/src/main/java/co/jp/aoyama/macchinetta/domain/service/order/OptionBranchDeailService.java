package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.OptionBranchDetail;;

public interface OptionBranchDeailService {

	List<OptionBranchDetail> getStandardButtons(String subItemCode, String opButton, String orderPattern, String optionCode);

	List<OptionBranchDetail> getTuxedoButtons(String itemCode, String tpButton, String orderPattern);

	List<OptionBranchDetail> getWashableButtons(String itemCode, String wpButton, String orderPattern);

	List<OptionBranchDetail> getAllOption(String orderPattern);


}
