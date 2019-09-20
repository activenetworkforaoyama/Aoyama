package co.jp.aoyama.macchinetta.domain.repository.stock;

import co.jp.aoyama.macchinetta.domain.dto.Stock;
import co.jp.aoyama.macchinetta.domain.model.MtbStock;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author liufeng
 *
 */
public interface MtbStockRepository {
	int deleteByPrimaryKey(String fabricId);

	int insert(MtbStock record);

	MtbStock selectByPrimaryKey(String fabricId);

	List<MtbStock> selectAll();

	int updateByPrimaryKey(MtbStock record);

	/**
	 * 実在庫を更新する
	 * 
	 * @param stockList         在庫オブジェクトリスト
	 * @param batchUpdateUserid バッチ更新ユーザコード
	 * @param orderPattern      オーダーパターン
	 * @return 更新結果 １：成功
	 */
	Integer updateActualStockByFabricNo(@Param("stockList") List<Stock> stockList,
			@Param("batchUpdateUserid") String batchUpdateUserid, @Param("order_pattern") String orderPattern);

	/**
	 * 大連大楊Po用生地品番リストを取得する
	 * 
	 * @return 大連大楊Po用生地品番リスト
	 */
	List<String> selectfabricNoList();

	/**
	 * 上海服良Co用生地品番リストを取得する
	 * 
	 * @return 上海服良Co用生地品番リスト
	 */
	List<String> selectShanghaiFuliangCoFabricNoList();
}