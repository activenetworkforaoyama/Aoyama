package co.jp.aoyama.macchinetta.domain.service.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.Shop;
import co.jp.aoyama.macchinetta.domain.repository.shop.ShopRepository;
import co.jp.aoyama.macchinetta.domain.service.factory.FactoryServiceImpl;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {
	@Inject
    ShopRepository shopRepository;

	private static final Logger logger = LoggerFactory
            .getLogger(ShopServiceImpl.class);
	
	@Override
	public Shop findShopByPk(String shopCode) {
		Shop shop = shopRepository.findShopByPk(shopCode);
        if (shop == null) {
            ResultMessages messages = ResultMessages.error();
            messages.add("E018", shopCode);
            logger.error(messages.toString());
            
            throw new ResourceNotFoundException(messages);
        }
		return shop;
	}

	@Override
	public List<Shop> findAllShop() {
		List<Shop> shopList = shopRepository.findAllShop();
		return shopList;
	}

	@Override
	public Boolean updateShopByPk(List<Shop> shopList) {
		List<Shop> shopInsertList = new ArrayList<Shop>();
		List<Shop> shopUpdList = new ArrayList<Shop>();
		for (Shop shop : shopList) {
			// "1"は更新区分
			if("1".equals(shop.getOptionType())) {
					shop.setUpdatedAt(new Date());
					shopUpdList.add(shop);
			}
			//　"2"は挿入区分
			else if("2".equals(shop.getOptionType())) {
					shop.setCreatedAt(new Date()); 
					shop.setUpdatedAt(new Date());
					shop.setCreatedUserId(shop.getUpdatedUserId());
					shopInsertList.add(shop);
			}
					
		}
		if(shopInsertList.size()!=0) {
			shopRepository.insertAllShopByPk(shopInsertList);
		}
		
		if(shopUpdList.size()!=0) {
			shopRepository.updateAllShopByPk(shopUpdList);
		}
		
		return true;
	}

	@Override
	public void deleteShopByPk(List<Shop> shopAllList) {
		shopRepository.deleteAllShopByPk(shopAllList);
	}

	@Override
	public List<Shop> fuzzyQuery(Shop shop) {
		List<Shop> shopList = shopRepository.fuzzyQuery(shop.getShopCode(),shop.getShopName(),shop.getStoreBrandCode());
		return shopList;
	}
	@Override
	public Boolean shopIsExist(String shopCode) {
		Shop shop = shopRepository.findShopByPk(shopCode);
        if (shop == null) {
            ResultMessages messages = ResultMessages.error();
            messages.add("E018", shopCode);
            logger.error(messages.toString());
        	return false;
        }
		return true;
	}

	@Override
	public List<Shop> findUnlessShop(String belongCode) {
		List<Shop> shopList = shopRepository.findUnlessShop(belongCode);
		return shopList;
	}

}
