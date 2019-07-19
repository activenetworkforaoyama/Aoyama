package co.jp.aoyama.macchinetta.domain.service.shop;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Shop;

public interface ShopService {

	List<Shop> findAllShop();
	
	Shop findShopByPk(String shopCode);

	Boolean updateShopByPk(List<Shop> shopList);

	void deleteShopByPk(List<Shop> shopList);

	List<Shop> fuzzyQuery(Shop shop);
	
	public Boolean shopIsExist(String shopCode);

	List<Shop> findUnlessShop(String belongCode);
}
