package co.jp.aoyama.macchinetta.app.stock;

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

import co.jp.aoyama.macchinetta.app.brand.FabricBrandForm;
import co.jp.aoyama.macchinetta.app.factory.FactoryForm;
import co.jp.aoyama.macchinetta.app.maker.MakerForm;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.FabricBrand;
import co.jp.aoyama.macchinetta.domain.model.Factory;
import co.jp.aoyama.macchinetta.domain.model.Maker;
import co.jp.aoyama.macchinetta.domain.model.Stock;
import co.jp.aoyama.macchinetta.domain.service.brand.FabricBrandService;
import co.jp.aoyama.macchinetta.domain.service.factory.FactoryService;
import co.jp.aoyama.macchinetta.domain.service.maker.MakerService;
import co.jp.aoyama.macchinetta.domain.service.stock.StockService;

@Controller
@RequestMapping(value = "/stock")
public class StockController {

    @Inject
    SessionContent sessionContent;
    
    @Inject
    StockService stockService;
    
    @Inject
	MakerService makerService;
    
    @Inject
	FabricBrandService fabricBrandService;
    
    @Inject
	FactoryService factoryService;
    
    @Inject
    Mapper beanMapper;
	private StockForm stockForm = new StockForm();
	
	@ModelAttribute
	public StockForm setupForm() {
	  return stockForm;
	}
	  
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String PageSearch(Model model) {
		return "stock/stockForm";
	}
	
	@RequestMapping(value = "selectAll", method = RequestMethod.GET)
	@ResponseBody
	public List<StockForm> PageDataFind() {
		List<StockForm> StockFormList = new ArrayList<StockForm>();
		List<Stock> stocklist = stockService.findAllStock();
		for (Stock stock : stocklist) {
			StockForm stockForm = beanMapper.map(stock, StockForm.class);
			StockFormList.add(stockForm);
		}
		return StockFormList;
	}
	
	@RequestMapping(value = "selectMaker", method = RequestMethod.GET)
	@ResponseBody
	public List<MakerForm> selectMaker() {
		List<MakerForm> makerFormList = new ArrayList<MakerForm>();
		List<Maker> makerList = makerService.findAll();
		for (Maker maker : makerList) {
			MakerForm makerForm = beanMapper.map(maker, MakerForm.class);
			makerFormList.add(makerForm);
		}
		return makerFormList;
	}
	
	@RequestMapping(value = "selectBrandName", method = RequestMethod.GET)
	@ResponseBody
	public List<FabricBrandForm> selectBrandName() {
		List<FabricBrandForm> factoryBrandFormList = new ArrayList<FabricBrandForm>();
		List<FabricBrand> factoryBrandlist = fabricBrandService.findAllFabricBrand();
		for (FabricBrand fabricBrand : factoryBrandlist) {
			FabricBrandForm factoryBrandForm = beanMapper.map(fabricBrand, FabricBrandForm.class);
			factoryBrandFormList.add(factoryBrandForm);
		}
		return factoryBrandFormList;
	}
	
	@RequestMapping(value = "selectfactoryName", method = RequestMethod.GET)
	@ResponseBody
	public List<FactoryForm> selectfactoryName() {
		List<FactoryForm> factoryFormList = new ArrayList<FactoryForm>();
		List<Factory> factorylist = factoryService.findAll();
		for (Factory factory : factorylist) {
			FactoryForm factoryForm = beanMapper.map(factory, FactoryForm.class);
			factoryFormList.add(factoryForm);
		}
		return factoryFormList;
	}
  
	@RequestMapping(value = "/fuzzyQuery" , method = RequestMethod.GET)
	@ResponseBody
	public List<StockForm> fuzzyQuery(StockForm stockForm){
		Stock stock = beanMapper.map(stockForm, Stock.class);
		List<Stock> stockList = stockService.fuzzyQuery(stock);
		List<StockForm> stockFormList = new ArrayList<StockForm>();
		for (Stock stockL : stockList) {
			StockForm stockFormL = beanMapper.map(stockL, StockForm.class);
			stockFormList.add(stockFormL);
		}
		return stockFormList;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Boolean updateStockByPk(@RequestBody List<StockForm> stockFormList) {
		List<Stock> stockList = new ArrayList<Stock>();
		for(int i = 0; i < stockFormList.size(); i ++ ) {
			Stock stock = beanMapper.map(stockFormList.get(i), Stock.class);
			stock.setCreatedAt(new Date());
			stock.setUpdatedAt(new Date());
			stock.setUpdatedUserId(sessionContent.getUserId());
			stockList.add(stock);
		}
		Boolean result = false;
		try {
			result = stockService.updateStockByPk(stockList);
		}catch (ResourceNotFoundException e){
			e.printStackTrace();
		}
		return result;
	}
}