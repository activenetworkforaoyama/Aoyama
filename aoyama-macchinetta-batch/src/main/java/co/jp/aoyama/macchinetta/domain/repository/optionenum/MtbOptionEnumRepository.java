package co.jp.aoyama.macchinetta.domain.repository.optionenum;

import co.jp.aoyama.macchinetta.domain.model.MtbOptionEnum;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbOptionEnumRepository {
	int insert(MtbOptionEnum record);

	/**
	 * オプション列挙体オブジェクトリストを取得
	 * 
	 * @return オプション列挙体オブジェクトリスト
	 */
	List<MtbOptionEnum> selectAll();

	/**
	 * オプション列挙体オブジェクトリストを取得
	 * 
	 * @param type    洋服タイプ
	 * @param factory 工場コード
	 * @param pattern オーダーパターン
	 * @return オプション列挙体オブジェクトリスト
	 */
	List<MtbOptionEnum> selectByTypeFactoryPattern(@Param("type") String type, @Param("factory") String factory,
			@Param("pattern") String pattern);
}