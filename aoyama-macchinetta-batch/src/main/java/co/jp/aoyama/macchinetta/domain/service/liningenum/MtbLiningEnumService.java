package co.jp.aoyama.macchinetta.domain.service.liningenum;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.MtbLiningEnum;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbLiningEnumService {

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
	List<MtbLiningEnum> selectByFactoryPattern(String factory, String pattern);
}
