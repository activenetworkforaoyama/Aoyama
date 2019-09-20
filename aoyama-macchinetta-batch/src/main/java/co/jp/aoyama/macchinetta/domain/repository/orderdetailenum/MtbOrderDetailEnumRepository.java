package co.jp.aoyama.macchinetta.domain.repository.orderdetailenum;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.MtbOrderDetailEnum;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbOrderDetailEnumRepository {
	int insert(MtbOrderDetailEnum record);

	/**
	 * 注文明細列挙体オブジェクトリストを取得する
	 * 
	 * @return 注文明細列挙体オブジェクトリスト
	 */
	List<MtbOrderDetailEnum> selectAll();

	/**
	 * 注文明細列挙体オブジェクトリストを取得
	 * 
	 * @param factory 工場コード
	 * @param pattern オーダーパターン
	 * @return 注文明細列挙体オブジェクトリスト
	 */
	List<MtbOrderDetailEnum> selectByFactoryPattern(@Param("factory") String factory, @Param("pattern") String pattern);
}