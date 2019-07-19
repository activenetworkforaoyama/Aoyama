package co.jp.aoyama.macchinetta.domain.service.delivery;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.ShopDelivery;
import co.jp.aoyama.macchinetta.domain.repository.delivery.ShopDeliveryRepository;

/**
 * 納期管理
 * @author wuzhengyang
 *
 */
@Service
@Transactional
public class ShopDeliveryServiceImpl implements ShopDeliveryService {

	@Inject
	ShopDeliveryRepository shopDeliveryRepository;
	
	/**
	 * 主キーからオブジェクトが存在するかどうかを調べる
	 */
	@Override
	public ShopDelivery shopDeliveryQueryByPrimaryKey(ShopDelivery shopDelivery) {
		ShopDelivery shopDeliveryQueryByPrimaryKey = shopDeliveryRepository.shopDeliveryQueryByPrimaryKey(
				shopDelivery.getShopDeliveryClass(), shopDelivery.getOrderOnStartDate(), 
				shopDelivery.getOrderOnEndDate());
		
		return shopDeliveryQueryByPrimaryKey;
	}
	
	/**
	 * 主キーによる新規
	 */
	@Override
	public Boolean insertShopDeliveryByPrimaryKey(List<ShopDelivery> shopDeliveryInsertList) {
		shopDeliveryRepository.insertShopDeliveryByPrimaryKey(shopDeliveryInsertList);
		return true;
	}
	
	/**
	 * 主キーによる修正
	 */
	@Override
	public Boolean updateShopDeliveryByPrimaryKey(List<ShopDelivery> shopDeliveryUpdateList) {
		shopDeliveryRepository.updateShopDeliveryByPrimaryKey(shopDeliveryUpdateList);
		return true;
	}

	/**
	 * 主キーによる削除
	 */
	@Override
	public Boolean deleteShopDeliveryByPrimaryKey(List<ShopDelivery> shopDeliveryDeleteList) {
		shopDeliveryRepository.deleteShopDeliveryByPrimaryKey(shopDeliveryDeleteList);
		return true;
	}
	
	/**
	 * 曖昧なクエリ
	 */
	@Override
	public List<ShopDelivery> shopDeliveryQueryFuzzy(ShopDelivery shopDelivery) {
		List<ShopDelivery> shopDeliveryList = shopDeliveryRepository.shopDeliveryQueryFuzzy(shopDelivery.getShopDeliveryClass(),
				shopDelivery.getOrderOnStartDate(), shopDelivery.getOrderOnEndDate());
		return shopDeliveryList;
	}
	
	/**
	 * 承り日に共通点があるかどうか
	 */
	@Override
	public Integer shopDeliveryQueryIntersection(ShopDelivery shopDelivery) {
		Integer shopDeliveryQueryIntersection = shopDeliveryRepository.shopDeliveryQueryIntersection(shopDelivery.getShopDeliveryClass(),
				shopDelivery.getOrderOnStartDate(), shopDelivery.getOrderOnEndDate());
		return shopDeliveryQueryIntersection;
	}
	
	/**
	 * 承り日FROMより早く、承り日FROMから一番近い合法な日付を設定します 
	 */
	@Override
	public List<Date> orderOnStartDateQuery(ShopDelivery shopDelivery) {
		List<Date> orderOnStartDateQuery = shopDeliveryRepository.orderOnStartDateQuery(shopDelivery);
		return orderOnStartDateQuery;
	}
	
	/**
	 *承り日TOより遅く、承り日TOから一番近い合法な日付を設定します
	 */
	@Override
	public List<Date> orderOnEndDateQuery(ShopDelivery shopDelivery) {
		List<Date> orderOnEndDateQuery = shopDeliveryRepository.orderOnEndDateQuery(shopDelivery);
		return orderOnEndDateQuery;
	}
	
}
