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
@Component("getStockWriter")
public class GetStockItemWriter<T> implements ItemWriter<String> {

	@Inject
	GetStockController controller;

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends String> fabricNoList) throws Exception {
		controller.updateStock((List<String>) fabricNoList);
	}

}
