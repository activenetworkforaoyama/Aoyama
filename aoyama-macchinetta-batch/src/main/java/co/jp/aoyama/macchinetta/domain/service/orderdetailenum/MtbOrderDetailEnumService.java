package co.jp.aoyama.macchinetta.domain.service.orderdetailenum;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.MtbOrderDetailEnum;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbOrderDetailEnumService {

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
	List<MtbOrderDetailEnum> selectByFactoryPattern(String factory, String pattern);
}
