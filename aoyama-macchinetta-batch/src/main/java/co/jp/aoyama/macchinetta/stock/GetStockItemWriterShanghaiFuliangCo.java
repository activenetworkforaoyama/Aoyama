package co.jp.aoyama.macchinetta.stock;

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
@Component("getStockWriterShanghaiFuliangCo")
public class GetStockItemWriterShanghaiFuliangCo<T> implements ItemWriter<String> {

	@Inject
	GetStockControllerShanghaiFuliangCo controller;

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends String> fabricNoList) throws Exception {
		controller.updateStock((List<String>) fabricNoList);
	}

}
