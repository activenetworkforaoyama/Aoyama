package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.consts.DomainConst;
import co.jp.aoyama.macchinetta.domain.dto.CashUpdateCondition;
import co.jp.aoyama.macchinetta.domain.dto.Message;
import co.jp.aoyama.macchinetta.domain.dto.OrderCondition;
import co.jp.aoyama.macchinetta.domain.dto.OrderStatusOutput;
import co.jp.aoyama.macchinetta.domain.dto.OrderUpdateCondition;
import co.jp.aoyama.macchinetta.domain.model.DtbOrder;
import co.jp.aoyama.macchinetta.domain.model.MtbErrorResult;
import co.jp.aoyama.macchinetta.domain.repository.cash.DtbCashRepository;
import co.jp.aoyama.macchinetta.domain.repository.error_result.MtbErrorResultRepository;
import co.jp.aoyama.macchinetta.domain.repository.order.DtbOrderRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class DtbOrderServiceImpl implements DtbOrderService {

	@Inject
	DtbOrderRepository orderRepository;

	@Inject
	MtbErrorResultRepository errorResultRepository;

	@Inject
	DtbCashRepository cashRepository;

	@Value("${api.prefix}")
	String prefix;

	@Override
	@Transactional(readOnly = true)
	public DtbOrder selectByPrimaryKey(String orderId) {
		return orderRepository.selectByPrimaryKey(orderId);
	}

	@Override
	public List<DtbOrder> selectByCondition(OrderCondition orderCondition) {
		// 全部検索
		return orderRepository.selectByCondition(orderCondition);
	}

	@Override
	public int updateByPrimaryKey(DtbOrder dtbOrder) {

		return orderRepository.updateByPrimaryKey(dtbOrder);
	}

	@Override
	public void receiveSuccess(List<DtbOrder> dtbOrders) {
		if (null != dtbOrders && 0 < dtbOrders.size()) {
			// エラー記録クリアの注文IDリスト
			List<String> errDelOrderIdList = new ArrayList<String>();
			// 注文ステータス変更の注文IDリスト
			List<String> orderIdList = new ArrayList<String>();

			for (DtbOrder dtbOrder : dtbOrders) {
				if (dtbOrder.getSend2factoryStatus().equals(DomainConst.SEND2FACTORY_STATUS_4)
						|| dtbOrder.getSend2factoryStatus().equals(DomainConst.SEND2FACTORY_STATUS_5)) {
					errDelOrderIdList.add(dtbOrder.getOrderId());
				}
				orderIdList.add(dtbOrder.getOrderId());
			}

			if (0 < errDelOrderIdList.size()) {
				errorResultRepository.deleteByOrderIds(errDelOrderIdList);
			}

			if (0 < orderIdList.size()) {
				OrderUpdateCondition condition = new OrderUpdateCondition();

				condition.setOrderIds(orderIdList);
				condition.setSend2factoryStatus(DomainConst.SEND2FACTORY_STATUS_1);
				condition.setMakerFactoryStatus(DomainConst.MAKER_FACTORY_STATUS_F1);

				orderRepository.updateByOrderIds(condition, condition.getOrderIds());
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
				OrderUpdateCondition condition = new OrderUpdateCondition();

				condition.setOrderIds(orderIdList);
				condition.setSend2factoryStatus(DomainConst.SEND2FACTORY_STATUS_3);

				orderRepository.updateByOrderIds(condition, condition.getOrderIds());
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
			if (message.getOrderno().substring(0, 2).equals("QS")) {
				errorOrderNo = message.getOrderno().substring(2);
			}
			String errorCode = message.getError_code();

			errorResult.setOrderId(errorOrderNo);
			errorResult.setErrorCode(errorCode);
			errorResult.setRemark(errorCodeMap.get(errorCode));
			errorResult.setCreatedAt(new Date());
			errorResult.setUpdatedAt(new Date());

			// insert to DB
			errorResultRepository.insert(errorResult);

			// Failの全部ordernoを重複を除く
			if (!errorOrderNoList.contains(errorOrderNo)) {
				errorOrderNoList.add(errorOrderNo);
			}
		}

		OrderUpdateCondition condition = new OrderUpdateCondition();

		condition.setOrderIds(errorOrderNoList);
		// 工場自動連携ステータスを「送信失敗 データエラー]に設定する
		condition.setSend2factoryStatus(DomainConst.SEND2FACTORY_STATUS_4);
		// 当注文のTSCステータスを「登録済]に設定する
		condition.setTscStatus(DomainConst.TSC_STATUS_T2);

		orderRepository.updateByOrderIds(condition, condition.getOrderIds());

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
			condition = new OrderUpdateCondition();

			condition.setOrderIds(noErrorOrderNoList);
			// 工場自動連携ステータスを「送信失敗 エラーなし」に設定する
			condition.setSend2factoryStatus(DomainConst.SEND2FACTORY_STATUS_2);

			orderRepository.updateByOrderIds(condition, condition.getOrderIds());
		}

		if (0 < errorCashIdList.size()) {
			CashUpdateCondition cashCondition = new CashUpdateCondition();

			cashCondition.setCashIds(errorCashIdList);
			// 当注文の会計IDにより、会計（dtb_cash）マスタの会計ステータスを「会計再確認要」に設定する
			cashCondition.setCashStatus(DomainConst.CASH_STATUS_03);

			cashRepository.updateByCashIds(cashCondition, cashCondition.getCashIds());
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

	@Override
	public int insert(DtbOrder record) {
		return orderRepository.insert(record);
	}

}
