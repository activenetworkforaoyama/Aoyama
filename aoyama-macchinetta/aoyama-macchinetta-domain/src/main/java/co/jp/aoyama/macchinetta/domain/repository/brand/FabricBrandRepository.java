package co.jp.aoyama.macchinetta.domain.repository.brand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.FabricBrand;


public interface FabricBrandRepository {
	
	List<FabricBrand> findAllFabricBrand();
	
	List<FabricBrand> fuzzyQuery(@Param("brandName")String brandName, @Param("countryName")String countryName);
	
	void updateFabricBrandByKey(@Param("fabricBrandUpdList")List<FabricBrand> fabricBrandUpdList);
	
	void insertFabricBrandByKey(@Param("fabricBrandInsertList")List<FabricBrand> fabricBrandInsertList);
	
	void deleteFabricBrandByKey(@Param("fabricBrandDelList")List<FabricBrand> fabricBrandDelList);
	
	FabricBrand findFabricBrandByPk(@Param("fablicBrandNo")String fablicBrandNo);
	
	String findMaxNo();
}
