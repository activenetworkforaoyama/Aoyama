package co.jp.aoyama.macchinetta.domain.service.maker;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Maker;


public interface MakerService {
	
	Maker findOne(String makerCode);

	List<Maker> findAll();

	List<Maker> fuzzyQuery(Maker maker);

	void deleteMakerByKey(List<Maker> makerDelList);

	Boolean updateMakerByKey(List<Maker> makerList);
	
	Boolean makerIsExist(String makerCode);

}
