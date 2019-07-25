package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;
import java.util.Map;

import co.jp.aoyama.macchinetta.domain.dto.Message;
import co.jp.aoyama.macchinetta.domain.dto.OrderCondition;
import co.jp.aoyama.macchinetta.domain.dto.OrderStatusOutput;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;

public interface DtbOrderService {

	DtbOrder selectByPrimaryKey(String orderId);

	List<DtbOrder> selectByCondition(OrderCondition orderCondition);

	int updateByPrimaryKey(DtbOrder record);

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

	int insert(DtbOrder record);

}
