package co.jp.aoyama.macchinetta.domain.repository.errorresult;

import co.jp.aoyama.macchinetta.domain.model.MtbErrorResult;

import java.util.List;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbErrorResultRepository {

	/**
	 * 
	 * @param record
	 * @return
	 */
	int insert(MtbErrorResult record);

	/**
	 * 
	 * @param orderIds
	 * @return
	 */
	int deleteByOrderIds(List<String> orderIds);
}