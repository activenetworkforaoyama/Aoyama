package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Item;
import co.jp.aoyama.macchinetta.domain.repository.order.ItemRepository;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	@Inject
	ItemRepository itemRepository;
	@Override
	public List<Item> getAllItem(String type) {
		List<Item> itemList = itemRepository.getAllItem(type);
		return itemList;
	}

}
