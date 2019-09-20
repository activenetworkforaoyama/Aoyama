package co.jp.aoyama.macchinetta.domain.service.errorcontent;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.MtbErrorContent;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbErrorContentService {

	/**
	 * エラーメッセージオブジェクトリストを取得
	 * 
	 * @param factory 工場コード
	 * @param pattern オーダーパターン
	 * @return エラーメッセージオブジェクトリスト
	 */
	List<MtbErrorContent> selectByFactoryPattern(String factory, String pattern);
}
