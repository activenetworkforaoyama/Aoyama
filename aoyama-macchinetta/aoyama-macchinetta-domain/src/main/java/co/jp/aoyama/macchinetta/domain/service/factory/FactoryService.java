package co.jp.aoyama.macchinetta.domain.service.factory;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Factory;

public interface FactoryService {
	
	Factory findOne(String factoryCode);
	
    List<Factory> findAll();
    
    //複数のデータ更新
	Boolean updateFactoryByKey(List<Factory> factoryList);
	//複数のデータ削除
	void deleteFactoryBykey(List<Factory> factoryList);
	
	List<Factory> fuzzyQuery(Factory factory);
	
	public Boolean factoryIsExist(String factoryCode);
}
