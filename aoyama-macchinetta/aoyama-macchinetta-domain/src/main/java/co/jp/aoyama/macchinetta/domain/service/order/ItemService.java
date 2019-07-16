package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Item;

public interface ItemService {

	List<Item> getAllItem(String type);

}
