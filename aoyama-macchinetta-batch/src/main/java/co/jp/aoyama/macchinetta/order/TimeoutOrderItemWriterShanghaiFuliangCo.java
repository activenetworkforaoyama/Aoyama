package co.jp.aoyama.macchinetta.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liufeng
 *
 * @param <DtbOrder>
 */
@Component("timeoutOrderWriterShanghaiFuliangCo")
public class TimeoutOrderItemWriterShanghaiFuliangCo<T> implements ItemWriter<String> {

	@Inject
	GetOrderStatusControllerShanghaiFuliangCo controller;

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends String> dtbOrders) throws Exception {
		controller.doTimeoutOrderConfirm((List<String>) dtbOrders);
	}

}
