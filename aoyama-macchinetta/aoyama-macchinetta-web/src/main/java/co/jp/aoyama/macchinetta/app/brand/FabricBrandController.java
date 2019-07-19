package co.jp.aoyama.macchinetta.app.brand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.FabricBrand;
import co.jp.aoyama.macchinetta.domain.service.brand.FabricBrandService;

@Controller
@RequestMapping(value = "/brand")
public class FabricBrandController {
	@Inject
	SessionContent sessionContent;
	
	@Inject
	FabricBrandService fabricBrandService;
	
	private FabricBrandForm fabricBrandForm = new FabricBrandForm();
	
	@Inject
	Mapper beanMapper;
	
	@ModelAttribute
	public FabricBrandForm setupForm() {
		return fabricBrandForm;
	}
	
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String PageSearch2(Model model) {

		return "brand/fabricBrandForm";
	}
	
	@RequestMapping(value = "selectall", method = RequestMethod.GET)
	@ResponseBody
	public List<FabricBrandForm> selectall() {
		List<FabricBrandForm> factoryBrandFormList = new ArrayList<FabricBrandForm>();
		List<FabricBrand> factoryBrandlist = fabricBrandService.findAllFabricBrand();
		for (FabricBrand fabricBrand : factoryBrandlist) {
			FabricBrandForm factoryBrandForm = beanMapper.map(fabricBrand, FabricBrandForm.class);
			factoryBrandFormList.add(factoryBrandForm);
		}
		return factoryBrandFormList;
	}
	
	@RequestMapping(value = "fuzzyQuery" , method = RequestMethod.GET)
	@ResponseBody
	public List<FabricBrandForm> fuzzyQuery(FabricBrandForm fabricBrandForm) {
		FabricBrand fabricBrand = beanMapper.map(fabricBrandForm, FabricBrand.class);
		List<FabricBrand> fabricBrandList = fabricBrandService.fuzzyQuery(fabricBrand);
		List<FabricBrandForm> fabricBrandFormList = new ArrayList<FabricBrandForm>();
		for(FabricBrand fabricBrandL : fabricBrandList) {
			FabricBrandForm fabricBrandFormL = beanMapper.map(fabricBrandL, FabricBrandForm.class);
			fabricBrandFormList.add(fabricBrandFormL);
		}
		return fabricBrandFormList;		
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public List<FabricBrand> updateFabricBrandByPk(@RequestBody List<FabricBrandForm> fabricBrandFormList) {
		List<FabricBrand> fabricBrandList = new ArrayList<FabricBrand>();
		List<FabricBrand> fabricBrandDelList = new ArrayList<FabricBrand>();
		for(int i=0; i < fabricBrandFormList.size(); i ++ ) {
			if(fabricBrandFormList.get(i).getDelType()) {
				//削除の場合
				FabricBrand fabricBrand = beanMapper.map(fabricBrandFormList.get(i), FabricBrand.class);
				fabricBrandDelList.add(fabricBrand);
			}else {
				//更新、挿入の場合
				FabricBrand fabricBrand = beanMapper.map(fabricBrandFormList.get(i), FabricBrand.class);
				fabricBrand.setCreatedAt(new Date());
				fabricBrand.setUpdatedAt(new Date());
				fabricBrand.setUpdatedUserId(sessionContent.getUserId());
				fabricBrand.setDisplayIdentify(true);
				fabricBrandList.add(fabricBrand);
			}
		}
		if(fabricBrandDelList.size() != 0) {
			fabricBrandService.deleteFabricBrandByPk(fabricBrandDelList);
			//削除したテータをfabricBrandFormListに除去する
			for(int i = 0,length =fabricBrandFormList.size(); i<length;i++) {
				if(fabricBrandFormList.get(i).getDelType()) {
					fabricBrandFormList.remove(fabricBrandFormList.get(i));
					length--;
					i--;
				}
			}
		}
		List<FabricBrand> fabricBrandNumList = new ArrayList<FabricBrand>();
		try {
			fabricBrandNumList = fabricBrandService.updateFabricBrandByPk(fabricBrandList);
		}
		catch (ResourceNotFoundException e){
			e.getResultMessages();
		}
		return fabricBrandNumList;
	}
	
}
