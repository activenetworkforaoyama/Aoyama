package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;
import java.util.Map;

import co.jp.aoyama.macchinetta.domain.dto.Message;
import co.jp.aoyama.macchinetta.domain.dto.OrderStatusOutput;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;

/**
 * 
 * @author liufeng
 *
 */
public interface DtbOrderService {

	/**
	 * 送信要注文データを取得する
	 * 
	 * @param selectFlag 選択フラグ 0：工場自動連携ステータス＝「0：送信前」； 2：工場自動連携ステータス IN (「2：送信失敗
	 *                   エラーなし」、 「3：送信失敗 データタイプエラー」、 「4：送信失敗 データエラー」)
	 * @return 送信要注文データリスト
	 */
	List<DtbOrder> selectByCondition(String selectFlag);

	/**
	 * 送信成功の注文データ更新
	 * 
	 * @param dtbOrders 送信成功の注文データ
	 */
	void receiveSuccess(List<DtbOrder> dtbOrders);

	/**
	 * 送信異常の注文データ更新
	 * 
	 * @param dtbOrders 送信異常の注文データ
	 */
	void receiveException(List<DtbOrder> dtbOrders);

	/**
	 * 送信エラーの注文データ更新
	 * 
	 * @param messageList  送信結果リスト
	 * @param dtbOrders    送信エラーの注文データ
	 * @param errorCodeMap エラーコードマップ
	 */
	void receiveError(List<Message> messageList, List<DtbOrder> dtbOrders, Map<String, String> errorCodeMap);

	/**
	 * 受信結果リストにより、注文出荷日を更新する
	 * 
	 * @param list 受信結果リスト
	 */
	int updateShippingDateByOrderIds(List<OrderStatusOutput> list);

	/**
	 * ステータス確認要の注文IDを取得する
	 * 
	 * @return ステータス確認要の注文IDリスト
	 */
	List<String> selectConfrimOrderId();

//	int insert(DtbOrder record);
//	DtbOrder selectByPrimaryKey(String orderId);

}
