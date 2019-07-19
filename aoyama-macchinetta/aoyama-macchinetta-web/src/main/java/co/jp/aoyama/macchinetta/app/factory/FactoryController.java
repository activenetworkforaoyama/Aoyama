package co.jp.aoyama.macchinetta.app.factory;

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
import co.jp.aoyama.macchinetta.domain.model.Factory;
import co.jp.aoyama.macchinetta.domain.service.factory.FactoryService;
import co.jp.aoyama.macchinetta.domain.service.maker.MakerService;

@Controller
@RequestMapping(value = "/factory")
public class FactoryController {

	@Inject
	SessionContent sessionContent;
	
	@Inject
	FactoryService factoryService;
	
	@Inject
	MakerService makerService;

	private FactoryForm factoryForm = new FactoryForm();

	@Inject
	Mapper beanMapper;

	@ModelAttribute
	public FactoryForm setupForm() {
		return factoryForm;
	}

	// 实际用
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String PageSearch2(Model model) {

		return "factory/factoryForm";
	}

	@RequestMapping(value = "selectall", method = RequestMethod.GET)
	@ResponseBody
	public List<FactoryForm> selectall() {
		List<FactoryForm> factoryFormList = new ArrayList<FactoryForm>();
		List<Factory> factorylist = factoryService.findAll();
		for (Factory factory : factorylist) {
			FactoryForm factoryForm = beanMapper.map(factory, FactoryForm.class);
			factoryFormList.add(factoryForm);
		}
		return factoryFormList;
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String createForm() {

		return "factory/factoryForm";
	}
	
	public String versionIncrease(String version) {
		short versionToShort = Short.parseShort(version);
		short versionAdd = 1;
		Short versionResult = (short)(versionToShort + versionAdd);
		String returnVersion = versionResult.toString();
		return returnVersion;
	}
	
	// 複数データを更新する
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<FactoryForm> updateFactoryBykey(@RequestBody List<FactoryForm> factoryFormList) {
		List<Factory> factoryList = new ArrayList<Factory>();
		List<Factory> factoryDelList = new ArrayList<Factory>();
		// 更新失敗flag
		boolean updateSuccess = true;
		for (int i = 0; i < factoryFormList.size(); i++) {
			
			String makerCode = factoryFormList.get(i).getMakerCode();
			Boolean makerIsExist = makerService.makerIsExist(makerCode);
			if (factoryFormList.get(i).getFactoryCode() == null || "".equals(factoryFormList.get(i).getFactoryCode())) {
				
				//updateFlag  0 : 更新成功          1 :更新失敗(その他)    2 : 更新失敗(一意制約 ＆ null)  3 : 更新失敗(null)  4: 更新失敗(null)  5: 更新失敗(null)
				factoryFormList.get(i).setUpdateFlag("3");
				//nullのせいで、更新失敗
				updateSuccess = false;
				
			}
			else if (factoryFormList.get(i).getMakerCode() == null || "".equals(factoryFormList.get(i).getMakerCode())) {
				
				//updateFlag  0 : 更新成功          1 :更新失敗(その他)    2 : 更新失敗(一意制約 ＆ null)  3 : 更新失敗(null)  4: 更新失敗(null)  5: 更新失敗(null)
				factoryFormList.get(i).setUpdateFlag("4");
				//nullのせいで、更新失敗
				updateSuccess = false;
				
			}
			else if (factoryFormList.get(i).getFactoryName() == null || "".equals(factoryFormList.get(i).getFactoryName())) {
				
				//updateFlag  0 : 更新成功          1 :更新失敗(その他)    2 : 更新失敗(一意制約 ＆ null)  3 : 更新失敗(null)  4: 更新失敗(null)  5: 更新失敗(null)
				factoryFormList.get(i).setUpdateFlag("5");
				//nullのせいで、更新失敗
				updateSuccess = false;
				
			}
			else if(!makerIsExist && "2".equals(factoryFormList.get(i).getOptionType())) {
				
				//updateFlag  7 : 入力されたメーカーコードはメーカーマスタに存在しません
				factoryFormList.get(i).setUpdateFlag("7");
				//nullのせいで、更新失敗
				updateSuccess = false;
			}
			else {
				if (factoryFormList.get(i).getDelType()) {
					// 削除の場合
					Factory factory = beanMapper.map(factoryFormList.get(i), Factory.class);
					factoryDelList.add(factory);
				} else {
					// 更新、挿入の場合
					Factory factory = beanMapper.map(factoryFormList.get(i), Factory.class);
					factory.setUpdatedAt(new Date());
					factory.setUpdatedUserId(sessionContent.getUserId());
					factoryList.add(factory);

					// 更新する前のチェック
					Boolean factoryIsExist = factoryService.factoryIsExist(factoryFormList.get(i).getFactoryCode());
					try {
						Factory findOne = factoryService.findOne(factoryFormList.get(i).getFactoryCode());
						String version = findOne.getVersion().toString();
						if(findOne != null && !version.equals(factoryFormList.get(i).getVersion())) {
							//updateFlag  0 : 更新成功       1 :更新失敗(その他)  2 : 更新失敗(一意制約)  6: 更新失敗(バージョン不正) 
							factoryFormList.get(i).setUpdateFlag("6");
							//更新失敗
							updateSuccess = false;
						}
					} catch (ResourceNotFoundException e) {
						e.printStackTrace();
					}
					
					//データなし、OptionTypeは「更新」の場合
					if (!factoryIsExist && "1".equals(factory.getOptionType())) {
						//updateFlag  0 : 更新成功       1 :更新失敗(その他)       2 : 更新失敗(一意制約)  6: 更新失敗(バージョン不正) 
						factoryFormList.get(i).setUpdateFlag("1");
						//更新失敗
						updateSuccess = false;
					}
					//データがあり、OptionTypeは「挿入」の場合
					if (factoryIsExist && "2".equals(factory.getOptionType())) {
						//updateFlag  0 : 更新成功       1 :更新失敗(その他)       2 : 更新失敗(一意制約)  6: 更新失敗(バージョン不正) 
						factoryFormList.get(i).setUpdateFlag("2");
						//一意制約のせいで、更新失敗
						updateSuccess = false;
					}
					//データが無し、OptionTypeは「挿入」の場合
					if (!factoryIsExist && "2".equals(factory.getOptionType())) {
						//updateFlag  0 : 更新成功       1 :更新失敗(その他)       2 : 更新失敗(一意制約)  3: 更新失敗(バージョン不正) 
						factoryFormList.get(i).setUpdateFlag("0");
						factoryFormList.get(i).setDisplayIdentify(true);
					}
				}
				
			}
			
		}
		if (updateSuccess) {
			if (factoryDelList.size() != 0) {
				factoryService.deleteFactoryBykey(factoryDelList);
				// 削除したテータをshopFormListに除去する
				for (int i = 0, length = factoryFormList.size(); i < length; i++) {
					if (factoryFormList.get(i).getDelType()) {
						factoryFormList.remove(factoryFormList.get(i));
						length--;
						i--;
					}
				}
			}
			Boolean updateFactoryByKey = factoryService.updateFactoryByKey(factoryList);
			if(updateFactoryByKey) {
				for(int j = 0;j<factoryFormList.size();j++) {
					if(!"2".equals(factoryFormList.get(j).getOptionType())) {
						String version = factoryFormList.get(j).getVersion();
						String versionIncrease = versionIncrease(version);
						factoryFormList.get(j).setVersion(versionIncrease);	
					}
				}
			}
		}
		return factoryFormList;
	}

	@RequestMapping(value = "/fuzzyQuery", method = RequestMethod.GET)
	@ResponseBody
	public List<FactoryForm> fuzzyQuery(FactoryForm factoryForm) {
		Factory factory = beanMapper.map(factoryForm, Factory.class);
		List<Factory> factoryList = factoryService.fuzzyQuery(factory);
		List<FactoryForm> factoryFormList = new ArrayList<FactoryForm>();
		for (Factory factoryl : factoryList) {
			FactoryForm factoryForml = beanMapper.map(factoryl, FactoryForm.class);
			factoryFormList.add(factoryForml);
		}
		return factoryFormList;
	}
}
