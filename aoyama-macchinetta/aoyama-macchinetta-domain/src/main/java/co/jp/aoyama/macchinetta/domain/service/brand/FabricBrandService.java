package co.jp.aoyama.macchinetta.domain.service.brand;

import java.util.List;


import co.jp.aoyama.macchinetta.domain.model.FabricBrand;

public interface FabricBrandService {
	
	List<FabricBrand> findAllFabricBrand();
	
	List<FabricBrand> fuzzyQuery(FabricBrand FabricBrand);
	
	List<FabricBrand> updateFabricBrandByPk(List<FabricBrand> fabricBrandList);
	
	FabricBrand findFabricBrandByPk(String fablicBrandNo);

	void deleteFabricBrandByPk(List<FabricBrand> fabricBrandList);
	
	String findMaxNo();
	
	Boolean fabricBrandIsExist(String fablicBrandNo);
}
