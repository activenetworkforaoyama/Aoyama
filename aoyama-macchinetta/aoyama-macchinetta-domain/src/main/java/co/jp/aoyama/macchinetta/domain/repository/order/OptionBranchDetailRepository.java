package co.jp.aoyama.macchinetta.domain.repository.order;

import co.jp.aoyama.macchinetta.domain.model.OptionBranchDetail;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionBranchDetailRepository {
    int deleteByPrimaryKey(@Param("orderPattern") String orderPattern, @Param("subItemCode") String subItemCode, @Param("optionCode") String optionCode, @Param("optionBranchCode") String optionBranchCode, @Param("optionBranchDetailCode") String optionBranchDetailCode);

    int insert(OptionBranchDetail record);

    OptionBranchDetail selectByPrimaryKey(@Param("orderPattern") String orderPattern, @Param("subItemCode") String subItemCode, @Param("optionCode") String optionCode, @Param("optionBranchCode") String optionBranchCode, @Param("optionBranchDetailCode") String optionBranchDetailCode);

    List<OptionBranchDetail> selectAll();

    int updateByPrimaryKey(OptionBranchDetail record);
    
    List<OptionBranchDetail> getStandardButtons(@Param("itemCode")String itemCode,@Param("subItemCode") String subItemCode,@Param("optionBranchCode") String optionBranchCode,@Param("orderPattern") String orderPattern,@Param("optionCode") String optionCode);

	List<OptionBranchDetail> getTuxedoButtons(@Param("itemCode")String itemCode,@Param("subItemCode") String subItemCode,@Param("optionBranchCode") String optionBranchCode,@Param("orderPattern") String orderPattern);

	List<OptionBranchDetail> getWashableButtons(@Param("itemCode")String itemCode,@Param("subItemCode") String subItemCode,@Param("optionBranchCode") String optionBranchCode,@Param("orderPattern") String orderPattern);

	List<OptionBranchDetail> getAllOption(@Param("orderPattern")String orderPattern);

    
}