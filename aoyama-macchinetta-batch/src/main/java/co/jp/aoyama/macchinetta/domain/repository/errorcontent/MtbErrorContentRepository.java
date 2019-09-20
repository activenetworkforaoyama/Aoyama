package co.jp.aoyama.macchinetta.domain.repository.errorcontent;

import co.jp.aoyama.macchinetta.domain.model.MtbErrorContent;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbErrorContentRepository {
	int insert(MtbErrorContent record);

	List<MtbErrorContent> selectAll();

	/**
	 * エラーメッセージオブジェクトリストを取得
	 * 
	 * @param factory 工場コード
	 * @param pattern オーダーパターン
	 * @return エラーメッセージオブジェクトリスト
	 */
	List<MtbErrorContent> selectByFactoryPattern(@Param("factory") String factory, @Param("pattern") String pattern);
}