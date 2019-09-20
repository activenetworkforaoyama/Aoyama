package co.jp.aoyama.macchinetta.domain.repository.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.dto.OrderStatusOutput;
import co.jp.aoyama.macchinetta.domain.dto.OrderUpdateCondition;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;

public interface DtbOrderRepository {

//	int insert(DtbOrder record);
//	DtbOrder selectByPrimaryKey(String orderId);

	/**
	 * 大連大楊へ送信要PO注文データを取得する
	 * 
	 * @param selectFlag 選択フラグ 0：工場自動連携ステータス＝「0：送信前」； 2：工場自動連携ステータス IN (「2：送信失敗
	 *                   エラーなし」、 「3：送信失敗 データタイプエラー」、 「4：送信失敗 データエラー」)
	 * @return 送信要注文データリスト
	 */
	List<DtbOrder> selectByCondition(@Param("selectFlag") String selectFlag);

	/**
	 * 大連大楊のPO注文IDリストにより、注文データを更新する
	 * 
	 * @param condition 更新オブジェクト
	 * @param list      注文IDリスト
	 * @return 件数
	 */
	int updateByOrderIds(@Param("condition") OrderUpdateCondition condition, @Param("list") List<String> list);

	/**
	 * 大連大楊の受信結果リストにより、PO注文出荷日を更新する
	 * 
	 * @param updatedUserId 更新ユーザID
	 * @param prefix        大楊プレフィックス
	 * @param list          受信結果リスト
	 */
	int updateShippingDateByOrderIds(@Param("updated_user_id") String updatedUserId, @Param("prefix") String prefix,
			@Param("list") List<OrderStatusOutput> list);

	/**
	 * 大連大楊のステータス確認要のPO注文IDを取得する
	 * 
	 * @param makerFactoryStatus 工場ステータス F0 ：生産開始前 F1 ：生産開始
	 * @return ステータス確認要の注文IDリスト
	 */
	List<String> selectConfrimOrderId(@Param("makerFactoryStatus") String makerFactoryStatus);

	/**
	 * 大連大楊へ送信タイムアウトPO注文データを取得する
	 * 
	 * @return 送信要注文データリスト
	 */
	List<DtbOrder> selectDaliangDayangPoTimeoutOrders();

	/**
	 * 上海服良へ送信タイムアウトCO注文データを取得する
	 * 
	 * @return 送信要注文データリスト
	 */
	List<DtbOrder> selectShanghaiFuliangCoTimeoutOrders();

	/**
	 * 上海服良へ送信要CO注文データを取得する
	 * 
	 * @return 送信要注文データリスト
	 */
	List<DtbOrder> selectShanghaiFuliangCoOrders();

	/**
	 * 上海服良のステータス確認要のCO注文IDを取得する
	 * 
	 * @return ステータス確認要の注文IDリスト
	 */
	List<String> selectShanghaiFuliangCoConfrimOrderId();
}