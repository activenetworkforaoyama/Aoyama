package co.jp.aoyama.macchinetta.domain.repository.measurementenum;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.MtbMeasurementEnum;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbMeasurementEnumRepository {
	int insert(MtbMeasurementEnum record);

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
	List<MtbMeasurementEnum> selectByFactoryPattern(@Param("factory") String factory, @Param("pattern") String pattern);
}