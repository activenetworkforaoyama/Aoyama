package co.jp.aoyama.macchinetta.domain.repository.liningenum;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.MtbLiningEnum;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbLiningEnumRepository {
	int insert(MtbLiningEnum record);

	/**
	 * 胴裏列挙体オブジェクトリストを取得
	 * 
	 * @return 胴裏列挙体オブジェクトリスト
	 */
	List<MtbLiningEnum> selectAll();

	/**
	 * 胴裏列挙体オブジェクトリストを取得
	 * 
	 * @param factory 工場コード
	 * @param pattern オーダーパターン
	 * @return 胴裏列挙体オブジェクトリスト
	 */
	List<MtbLiningEnum> selectByFactoryPattern(@Param("factory") String factory, @Param("pattern") String pattern);
}