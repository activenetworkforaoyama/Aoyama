package co.jp.aoyama.macchinetta.domain.service.fabric;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Fabric;

public interface FabricService {
	
	List<Fabric> fabricQueryByCoOrPo(String orderPattern);
	
	String[] fabricUpdate(List<Fabric> fabricList);
	
	boolean fabricCheckExistence(String orderPattern, String fabricId);

	boolean fablicBrandNoCheckExistence(String fablicBrandNo);
}
