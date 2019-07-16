package co.jp.aoyama.macchinetta.domain.repository.maker;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Maker;

public interface MakerRepository {

	List<Maker> findAll();

	List<Maker> fuzzyQuery(@Param("makerCode") String makerCode,@Param("makerName") String makerName);

	void deleteMakerByKey(@Param("makerDelList") List<Maker> makerDelList);

	void updateMakerByKey(@Param("makerUpdList")List<Maker> makerUpdList);

	void insertMakerByKey(@Param("makerInsertList")List<Maker> makerInsertList);

	Maker findOne(String makerCode); 
	
}
