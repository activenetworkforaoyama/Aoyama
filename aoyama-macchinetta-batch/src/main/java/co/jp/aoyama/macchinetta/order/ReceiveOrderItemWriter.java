package co.jp.aoyama.macchinetta.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import co.jp.aoyama.macchinetta.domain.model.DtbOrder;

/**
 * 
 * @author liufeng
 *
 * @param <DtbOrder>
 */
@Component("receiveOrderWriter")
public class ReceiveOrderItemWriter<T> implements ItemWriter<DtbOrder> {

	@Inject
	ReceiveOrderController controller;

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends DtbOrder> dtbOrders) throws Exception {
		controller.changeDbStatus((List<DtbOrder>) dtbOrders);
	}

}
