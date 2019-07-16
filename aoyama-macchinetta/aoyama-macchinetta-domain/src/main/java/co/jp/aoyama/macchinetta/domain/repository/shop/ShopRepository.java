package co.jp.aoyama.macchinetta.domain.repository.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Shop;

public interface ShopRepository {

	List<Shop> findAllShop();

	Shop findShopByPk(@Param("shopCode")String shopCode);

	void insertAllShopByPk(@Param("shopList") List<Shop> shopList);

	void updateAllShopByPk(@Param("shopUpdList")List<Shop> shopUpdList);

	void deleteAllShopByPk(@Param("shopDelList")List<Shop> shopDelList);

	List<Shop> fuzzyQuery(@Param("shopCode")String shopCode, @Param("shopName")String shopName, @Param("storeBrandCode")String storeBrandCode);

}
