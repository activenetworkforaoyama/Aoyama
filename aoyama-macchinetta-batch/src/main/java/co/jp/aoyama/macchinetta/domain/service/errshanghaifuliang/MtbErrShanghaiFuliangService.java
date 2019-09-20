package co.jp.aoyama.macchinetta.domain.service.errshanghaifuliang;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.MtbErrShanghaiFuliang;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbErrShanghaiFuliangService {

	/**
	 * 上海服良エラーメッセージオブジェクトリストを取得
	 * 
	 * @return 上海服良エラーメッセージオブジェクトリスト
	 */
	List<MtbErrShanghaiFuliang> selectAll();
}
