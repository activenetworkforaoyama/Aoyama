package co.jp.aoyama.macchinetta.domain.service.measurementenum;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.MtbMeasurementEnum;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbMeasurementEnumService {

	/**
	 * 補正列挙体オブジェクトリストを取得
	 * 
	 * @return 補正列挙体オブジェクトリスト
	 */
	List<MtbMeasurementEnum> selectAll();

	/**
	 * 補正列挙体オブジェクトリストを取得
	 * 
	 * @param factory 工場コード
	 * @param pattern オーダーパターン
	 * @return 補正列挙体オブジェクトリスト
	 */
	List<MtbMeasurementEnum> selectByFactoryPattern(String factory, String pattern);
}
