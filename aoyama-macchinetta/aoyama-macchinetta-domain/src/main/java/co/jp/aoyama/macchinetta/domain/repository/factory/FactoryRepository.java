package co.jp.aoyama.macchinetta.domain.repository.factory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Factory;

public interface FactoryRepository {

	Factory findOne(String factoryCode);

	List<Factory> findAll();

	// fieldにより、Factory表を更新する
	void updateFactoryByKey(@Param("factoryUpdList") List<Factory> factoryUpdList);

	// fieldにより、Factory表にはfieldを含めデータを削除する
	void deleteFactoryBykey(@Param("factorydelList") List<Factory> factorydelList);

	void insertFactoryBykey(@Param("factoryInsertList") List<Factory> factoryInsertList);

	List<Factory> fuzzyQuery(@Param("factoryCode") String factoryCode,@Param("factoryName")String factoryName);

}
