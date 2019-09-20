package co.jp.aoyama.macchinetta.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liufeng
 *
 * @param <String>
 */
@Component("getOrderStatusWriterShanghaiFuliangCo")
public class GetOrderStatusItemWriterShanghaiFuliangCo<T> implements ItemWriter<String> {

	@Inject
	GetOrderStatusControllerShanghaiFuliangCo controller;

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends String> dtbOrders) throws Exception {
		controller.changeDbStatus((List<String>) dtbOrders);
	}

}
