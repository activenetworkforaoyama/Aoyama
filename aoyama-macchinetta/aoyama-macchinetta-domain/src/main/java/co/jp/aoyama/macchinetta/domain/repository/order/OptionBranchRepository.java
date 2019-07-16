package co.jp.aoyama.macchinetta.domain.repository.order;

import co.jp.aoyama.macchinetta.domain.model.OptionBranch;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionBranchRepository {
    int deleteByPrimaryKey(@Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode, @Param("optionCode") String optionCode, @Param("optionBranchCode") String optionBranchCode);

    int insert(OptionBranch record);

    OptionBranch selectByPrimaryKey(@Param("itemCode") String itemCode, @Param("subItemCode") String subItemCode, @Param("modelCode") String modelCode, @Param("optionCode") String optionCode, @Param("optionBranchCode") String optionBranchCode);

    List<OptionBranch> selectAll();

    int updateByPrimaryKey(OptionBranch record);

	List<OptionBranch> getStandardOption(@Param("orderPattern") String type);

	List<OptionBranch> getTuxedoOption(@Param("orderPattern") String type);

	List<OptionBranch> getWashableOption(@Param("orderPattern") String type);

	List<OptionBranch> getAllOption(@Param("orderPattern") String orderPattern);
}