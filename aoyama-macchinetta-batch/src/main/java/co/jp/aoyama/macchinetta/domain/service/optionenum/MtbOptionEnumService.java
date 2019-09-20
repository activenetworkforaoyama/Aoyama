package co.jp.aoyama.macchinetta.domain.service.optionenum;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.MtbOptionEnum;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbOptionEnumService {

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
	List<MtbOptionEnum> selectByTypeFactoryPattern(String type, String factory, String pattern);
}
