package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.Model;


public interface ModelService {

	List<Model> getAllModel(String type);

	List<Model> getModel(String orderPattern, String itemCode);

	List<Model> getItemModel(String orderPattern, String itemCode, String subitemCode);


}
