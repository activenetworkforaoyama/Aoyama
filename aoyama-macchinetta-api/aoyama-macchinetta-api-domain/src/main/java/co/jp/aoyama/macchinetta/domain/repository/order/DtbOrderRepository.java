package co.jp.aoyama.macchinetta.domain.repository.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.dto.OrderCondition;
import co.jp.aoyama.macchinetta.domain.dto.OrderStatusOutput;
import co.jp.aoyama.macchinetta.domain.dto.OrderUpdateCondition;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;

public interface DtbOrderRepository {
	int deleteByPrimaryKey(String orderId);

	int insert(DtbOrder record);

	DtbOrder selectByPrimaryKey(String orderId);

	List<DtbOrder> selectByCondition(@Param("orderCondition") OrderCondition orderCondition);

	int updateByPrimaryKey(DtbOrder record);

	/**
	 * 注文IDリストにより、注文データを更新する
	 * 
	 * @param condition 更新オブジェクト
	 * @param list      注文IDリスト
	 * @return 件数
	 */
	int updateByOrderIds(@Param("condition") OrderUpdateCondition condition, @Param("list") List<String> list);

	/**
	 * 受信結果リストにより、注文出荷日を更新する
	 * 
	 * @param updatedUserId 更新ユーザID
	 * @param prefix        大楊プレフィックス
	 * @param list          受信結果リスト
	 */
	int updateShippingDateByOrderIds(@Param("updated_user_id") String updatedUserId, @Param("prefix") String prefix,
			@Param("list") List<OrderStatusOutput> list);

	/**
	 * ステータス確認要の注文IDを取得する
	 * 
	 * @return ステータス確認要の注文IDリスト
	 */
	List<String> selectConfrimOrderId();
}