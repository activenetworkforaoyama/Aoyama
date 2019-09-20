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
@Component("timeoutOrderWriter")
public class TimeoutOrderItemWriter<T> implements ItemWriter<String> {

	@Inject
	GetOrderStatusController controller;

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends String> dtbOrders) throws Exception {
		controller.doTimeoutOrderConfirm((List<String>) dtbOrders);
	}

}
