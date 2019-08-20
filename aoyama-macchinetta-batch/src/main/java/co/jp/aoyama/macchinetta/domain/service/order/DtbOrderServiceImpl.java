package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import co.jp.aoyama.macchinetta.domain.consts.DomainConst;
import co.jp.aoyama.macchinetta.domain.dto.CashUpdateCondition;
import co.jp.aoyama.macchinetta.domain.dto.Message;
import co.jp.aoyama.macchinetta.domain.dto.OrderStatusOutput;
import co.jp.aoyama.macchinetta.domain.dto.OrderUpdateCondition;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;
import co.jp.aoyama.macchinetta.domain.model.MtbErrorResult;
import co.jp.aoyama.macchinetta.domain.repository.cash.DtbCashRepository;
import co.jp.aoyama.macchinetta.domain.repository.errorresult.MtbErrorResultRepository;
import co.jp.aoyama.macchinetta.domain.repository.order.DtbOrderRepository;

/**
 * 
 * @author liufeng
 *
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class DtbOrderServiceImpl implements DtbOrderService {

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(DtbOrderServiceImpl.class);

	@Inject
	DtbOrderRepository orderRepository;

	@Inject
	MtbErrorResultRepository errorResultRepository;

	@Inject
	DtbCashRepository cashRepository;

	@Value("${api.prefix}")
	String prefix;

	@Override
	public List<DtbOrder> selectByCondition(String selectFlag) {
		// 全部検索
		return orderRepository.selectByCondition(selectFlag);
	}

	@Override
	public void receiveSuccess(List<DtbOrder> dtbOrders) {
		if (null != dtbOrders && 0 < dtbOrders.size()) {
			// エラー記録クリアの注文IDリスト
			List<String> errDelOrderIdList = new ArrayList<String>();
			// 注文ステータス変更の注文IDリスト
			List<String> orderIdList = new ArrayList<String>();

			for (DtbOrder dtbOrder : dtbOrders) {
				if (dtbOrder.getSend2factoryStatus().equals(DomainConst.SEND2FACTORY_STATUS_4)) {
					errDelOrderIdList.add(dtbOrder.getOrderId());
				}
				orderIdList.add(dtbOrder.getOrderId());
			}

			if (0 < errDelOrderIdList.size()) {
				logger.info("クリア要の送信エラー注文IDリスト:{}", JSON.toJSONString(errDelOrderIdList));
				errorResultRepository.deleteByOrderIds(errDelOrderIdList);
				logger.info("mtb_error_result(エラー結果一覧マスタ)で、以上の再送信成功の送信エラー情報をクリアしました");
			}

			if (0 < orderIdList.size()) {
				logger.info("送信成功の注文IDリスト:{}", JSON.toJSONString(orderIdList));
				OrderUpdateCondition condition = new OrderUpdateCondition();

				condition.setOrderIds(orderIdList);
				condition.setSend2factoryStatus(DomainConst.SEND2FACTORY_STATUS_1);
				condition.setMakerFactoryStatus(DomainConst.MAKER_FACTORY_STATUS_F1);

				orderRepository.updateByOrderIds(condition, condition.getOrderIds());
				logger.info("dtb_order(受注)で、以上の送信成功の注文情報を更新しました。");
				logger.info("更新内容：工場自動連携ステータスを「1:送信済み」に設定して、工場ステータスを「F1:生産開始」に設定する");
			}
		}
	}

	@Override
	public void receiveException(List<DtbOrder> dtbOrders) {
		if (null != dtbOrders && 0 < dtbOrders.size()) {
			// 注文ステータス変更の注文IDリスト
			List<String> orderIdList = new ArrayList<String>();

			for (DtbOrder dtbOrder : dtbOrders) {
				orderIdList.add(dtbOrder.getOrderId());
			}

			if (0 < orderIdList.size()) {
				logger.info("送信失敗の注文IDリスト:{}", JSON.toJSONString(orderIdList));
				OrderUpdateCondition condition = new OrderUpdateCondition();

				condition.setOrderIds(orderIdList);
				condition.setSend2factoryStatus(DomainConst.SEND2FACTORY_STATUS_3);

				orderRepository.updateByOrderIds(condition, condition.getOrderIds());
				logger.info("dtb_order(受注)で、以上の送信失敗の注文情報を更新しました。");
				logger.info("更新内容：工場自動連携ステータスを「3:送信失敗 データタイプエラー]に設定する");
			}
		}
	}

	@Override
	public void receiveError(List<Message> messageList, List<DtbOrder> dtbOrders, Map<String, String> errorCodeMap) {

		// ReceiveOrderの戻るはFailの場合、FailのResultがない、ordernoがあるの場合、すなわち、注文データエラーがあるの場合
		List<String> errorOrderNoList = new ArrayList<String>();

		// mtb_error_result
		// Failのorderno及びerror_codeをエラー結果一覧マスタに登録する。

		MtbErrorResult errorResult = null;
		for (Message message : messageList) {

			errorResult = new MtbErrorResult();
			String errorOrderNo = message.getOrderno();
			// 枝番
			String subId = message.getOrderno();
			if (12 < errorOrderNo.length()) {
				if (errorOrderNo.substring(0, 2).equals("QS")) {
					errorOrderNo = errorOrderNo.substring(2);
				}
				if (12 < errorOrderNo.length()) {
					errorOrderNo = errorOrderNo.substring(0, 12);
				}
			}
			String errorCode = message.getError_code();

			errorResult.setOrderId(errorOrderNo);
			errorResult.setOrderSubId(subId);
			errorResult.setErrorCode(errorCode);
			errorResult.setRemark(errorCodeMap.get(errorCode));
			errorResult.setCreatedAt(new Date());
			errorResult.setUpdatedAt(new Date());
			logger.info("送信エラー情報作成:{}", JSON.toJSONString(errorResult));

			// insert to DB
			errorResultRepository.insert(errorResult);
			logger.info("mtb_error_result(エラー結果一覧マスタ)で、以上の送信エラー情報を登録しました");

			// Failの全部ordernoを重複を除く
			if (!errorOrderNoList.contains(errorOrderNo)) {
				errorOrderNoList.add(errorOrderNo);
			}
		}
		logger.info("送信エラーの注文IDリスト:{}", JSON.toJSONString(errorOrderNoList));

		OrderUpdateCondition condition = new OrderUpdateCondition();

		condition.setOrderIds(errorOrderNoList);
		// 工場自動連携ステータスを「送信失敗 データエラー]に設定する
		condition.setSend2factoryStatus(DomainConst.SEND2FACTORY_STATUS_4);
		// 当注文のTSCステータスを「登録済]に設定する
		condition.setTscStatus(DomainConst.TSC_STATUS_T2);

		orderRepository.updateByOrderIds(condition, condition.getOrderIds());
		logger.info("dtb_order(受注)で、以上の送信エラーの注文情報を更新しました。");
		logger.info("更新内容：工場自動連携ステータスを「4:送信失敗 データエラー]に設定して、TSCステータスを「T2:登録済]に設定する");

		// 一緒に送信した注文には、エラーしないの注文の工場自動連携ステータスを「送信失敗 エラーなし」に設定する
		List<String> noErrorOrderNoList = new ArrayList<String>();

		List<String> errorCashIdList = new ArrayList<String>();

		for (DtbOrder dtbOrder : dtbOrders) {

			if (!errorOrderNoList.contains(dtbOrder.getOrderId())) {
				noErrorOrderNoList.add(dtbOrder.getOrderId());
			} else {
				errorCashIdList.add(dtbOrder.getCashId());
			}
		}

		if (0 < noErrorOrderNoList.size()) {
			logger.info("送信した注文で、エラーなしの注文IDリスト:{}", JSON.toJSONString(noErrorOrderNoList));
			condition = new OrderUpdateCondition();

			condition.setOrderIds(noErrorOrderNoList);
			// 工場自動連携ステータスを「送信失敗 エラーなし」に設定する
			condition.setSend2factoryStatus(DomainConst.SEND2FACTORY_STATUS_2);

			orderRepository.updateByOrderIds(condition, condition.getOrderIds());
			logger.info("dtb_order(受注)で、以上の送信エラーの注文情報を更新しました。");
			logger.info("更新内容：工場自動連携ステータスを「2:送信失敗 エラーなし」に設定する");
		}

		if (0 < errorCashIdList.size()) {
			logger.info("送信エラーの注文の会計IDリスト:{}", JSON.toJSONString(errorCashIdList));
			CashUpdateCondition cashCondition = new CashUpdateCondition();

			cashCondition.setCashIds(errorCashIdList);
			// 当注文の会計IDにより、会計（dtb_cash）マスタの会計ステータスを「会計再確認要」に設定する
			cashCondition.setCashStatus(DomainConst.CASH_STATUS_03);

			cashRepository.updateByCashIds(cashCondition, cashCondition.getCashIds());
			logger.info("dtb_cash(会計)で、以上の送信エラーの注文の会計情報を更新しました。");
			logger.info("更新内容：会計ステータスを「03:会計再確認要」に設定する");
		}
	}

	@Override
	public int updateShippingDateByOrderIds(List<OrderStatusOutput> list) {
		return orderRepository.updateShippingDateByOrderIds(DomainConst.BATCH_UPDATE_USERID, prefix, list);
	}

	@Override
	public List<String> selectConfrimOrderId() {
		return orderRepository.selectConfrimOrderId();
	}

//	@Override
//	public int insert(DtbOrder record) {
//		return orderRepository.insert(record);
//	}
//	@Override
//	public DtbOrder selectByPrimaryKey(String orderId) {
//		return orderRepository.selectByPrimaryKey(orderId);
//	}

}
