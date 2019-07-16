package co.jp.aoyama.macchinetta.domain.repository.delivery;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.ShopDelivery;

public interface ShopDeliveryRepository {
	
	ShopDelivery shopDeliveryQueryByPrimaryKey(@Param("shopDeliveryClass") String shopDeliveryClass, 
			@Param("orderOnStartDate") Date orderOnStartDate, @Param("orderOnEndDate") Date orderOnEndDate);
	
	List<ShopDelivery> shopDeliveryQueryFuzzy(@Param("shopDeliveryClass") String shopDeliveryClass, 
			@Param("orderOnStartDate") Date orderOnStartDate, @Param("orderOnEndDate") Date orderOnEndDate);
	
	Integer shopDeliveryQueryIntersection(@Param("shopDeliveryClass") String shopDeliveryClass, 
			@Param("orderOnStartDate") Date orderOnStartDate, @Param("orderOnEndDate") Date orderOnEndDate);
	
	void insertShopDeliveryByPrimaryKey(@Param("shopDeliveryInsertList") List<ShopDelivery> shopDeliveryInsertList);

	void updateShopDeliveryByPrimaryKey(@Param("shopDeliveryUpdateList") List<ShopDelivery> shopDeliveryUpdateList);

	void deleteShopDeliveryByPrimaryKey(@Param("shopDeliveryDeleteList") List<ShopDelivery> shopDeliveryDeleteList);
	
	List<Date> orderOnStartDateQuery(@Param("shopDeliveryStartOnStartDate") ShopDelivery shopDeliveryStartOnStartDate);
	
	List<Date> orderOnEndDateQuery(@Param("shopDeliveryStartOnEndDate") ShopDelivery shopDeliveryStartOnEndDate);
}
