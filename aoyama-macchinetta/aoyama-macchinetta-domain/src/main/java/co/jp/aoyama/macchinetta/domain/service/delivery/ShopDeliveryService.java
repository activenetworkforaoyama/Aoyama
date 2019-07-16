package co.jp.aoyama.macchinetta.domain.service.delivery;

import java.util.Date;
import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.ShopDelivery;

public interface ShopDeliveryService {

	ShopDelivery shopDeliveryQueryByPrimaryKey(ShopDelivery shopDelivery);

	Boolean insertShopDeliveryByPrimaryKey(List<ShopDelivery> shopDeliveryInsertList);

	Boolean updateShopDeliveryByPrimaryKey(List<ShopDelivery> shopDeliveryUpdateList);
	
	Boolean deleteShopDeliveryByPrimaryKey(List<ShopDelivery> shopDeliveryDeleteList);
	
	List<ShopDelivery> shopDeliveryQueryFuzzy(ShopDelivery shopDelivery);

	Integer shopDeliveryQueryIntersection(ShopDelivery shopDelivery);

	List<Date> orderOnStartDateQuery(ShopDelivery shopDelivery);

	List<Date> orderOnEndDateQuery(ShopDelivery shopDelivery);

}
