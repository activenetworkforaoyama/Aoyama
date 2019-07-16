package co.jp.aoyama.macchinetta.domain.repository.fabric;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.aoyama.macchinetta.domain.model.Fabric;

public interface FabricRepository {
	
	List<Fabric> fabricQueryAll();
	
	Fabric fabricQueryByPrimaryKey(@Param("orderPattern") String orderPattern, @Param("fabricId") String fabricId);
	
	void fabricInsertByPrimaryKey(@Param("fabricInsertList") List<Fabric> fabricInsertList);

	void stockInsertByPrimaryKey(@Param("stockInsertList") List<Fabric> stockInsertList);
	
	void fabricUpdateByPrimaryKey(@Param("fabricUpdateList") List<Fabric> fabricUpdateList);
	
	void stockUpdateByPrimaryKey(@Param("stockUpdateList") List<Fabric> stockUpdateList);

	void fabricDeleteByPrimaryKey(@Param("fabricDeleteList") List<Fabric> fabricDeleteList);
	
	void stockDeleteByPrimaryKey(@Param("stockDeleteList") List<Fabric> stockDeleteList);

	Fabric fablicBrandNoQuery(@Param("fablicBrandNo") String fablicBrandNo);
	
}
