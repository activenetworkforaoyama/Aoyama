package co.jp.aoyama.macchinetta.domain.repository.orderlist;

import co.jp.aoyama.macchinetta.domain.model.ShopTel;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ShopTelRepository {
	List<ShopTel> findShopTel(@Param("category")String category);
}