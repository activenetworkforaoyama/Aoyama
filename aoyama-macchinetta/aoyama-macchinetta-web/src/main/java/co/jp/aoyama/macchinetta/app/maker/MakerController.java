package co.jp.aoyama.macchinetta.app.maker;

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

import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Maker;
import co.jp.aoyama.macchinetta.domain.service.maker.MakerService;

@Controller
@RequestMapping(value = "/maker")
public class MakerController {

    @Inject
    SessionContent sessionContent;
    
	@Inject
	MakerService makerService;

	private MakerForm makerForm = new MakerForm();

	@Inject
	Mapper beanMapper;

	@ModelAttribute
	public MakerForm setupForm() {
		return makerForm;
	}

	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String pageSerch(Model model) {
		return "maker/makerForm";
	}

	@RequestMapping(value = "selectall", method = RequestMethod.GET)
	@ResponseBody
	public List<MakerForm> selectall() {
		List<MakerForm> makerFormList = new ArrayList<MakerForm>();
		List<Maker> makerList = makerService.findAll();
		for (Maker maker : makerList) {
			MakerForm makerForm = beanMapper.map(maker, MakerForm.class);
			makerFormList.add(makerForm);
		}
		return makerFormList;
	}

	@RequestMapping(value = "fuzzyQuery", method = RequestMethod.GET)
	@ResponseBody
	public List<MakerForm> fuzzyQuery(MakerForm makerForm) {
		Maker maker = beanMapper.map(makerForm, Maker.class);
		List<Maker> makerList = makerService.fuzzyQuery(maker);
		List<MakerForm> makerFormList = new ArrayList<MakerForm>();
		for (Maker makerl : makerList) {
			MakerForm makerForml = beanMapper.map(makerl, MakerForm.class);
			makerFormList.add(makerForml);
		}
		return makerFormList;

	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public List<MakerForm> updateMakerByKey(@RequestBody List<MakerForm> makerFormList){
		List<Maker> makerList = new ArrayList<Maker>();
		List<Maker> makerDelList = new ArrayList<Maker>();
		//更新失敗flag
		boolean updateSuccess = true;
		for(int i = 0 ; i < makerFormList.size() ; i++) {
			if (makerFormList.get(i).getMakerCode() == null || "".equals(makerFormList.get(i).getMakerCode()) ||
					makerFormList.get(i).getMakerName() == null || "".equals(makerFormList.get(i).getMakerName()) ||
					makerFormList.get(i).getMakerId() == null || "".equals(makerFormList.get(i).getMakerId())) {
				
					//updateFlag  0 : 更新成功          1 :更新失敗(その他)    2 : 更新失敗(一意制約 ＆ null)     3 : 更新失敗(null) 
					makerFormList.get(i).setUpdateFlag("3");
					//nullのせいで、更新失敗
					updateSuccess = false;
		}else {
			if(makerFormList.get(i).getDelType()) {
				//削除の場合
				Maker maker = beanMapper.map(makerFormList.get(i), Maker.class);
				makerDelList.add(maker);
			}else {
				//更新、挿入の場合
				Maker maker = beanMapper.map(makerFormList.get(i), Maker.class);
				maker.setCreatedAt(new Date());
				maker.setUpdatedAt(new Date());
				maker.setUpdatedUserId(sessionContent.getUserId());
				makerList.add(maker);
				
				//更新する前のチェック
				boolean makerIsExist = makerService.makerIsExist(makerFormList.get(i).getMakerCode());
				//データなし、OptionTypeは「更新」の場合
				if (!makerIsExist && "1".equals(maker.getOptionType())) {
					//updateFlag  0 : 更新成功       1 :更新失敗(その他)       2 : 更新失敗(一意制約) 
					makerFormList.get(i).setUpdateFlag("1");
					//更新失敗
					updateSuccess = false;
				}
				//データがあり、OptionTypeは「挿入」の場合
				if (makerIsExist && "2".equals(maker.getOptionType())) {
					//updateFlag  0 : 更新成功       1 :更新失敗(その他)       2 : 更新失敗(一意制約) 
					makerFormList.get(i).setUpdateFlag("2");
					//一意制約のせいで、更新失敗
					updateSuccess = false;
				}
				//データがなし、OptionTypeは「挿入」の場合
				if (!makerIsExist && "2".equals(maker.getOptionType())) {
					//updateFlag  0 : 更新成功       1 :更新失敗(その他)       2 : 更新失敗(一意制約) 
					makerFormList.get(i).setUpdateFlag("0");
					makerFormList.get(i).setDisplayIdentify(true);
				}
			}
			
		}
	}
		if (updateSuccess) {
			if(makerDelList.size() != 0) {
				makerService.deleteMakerByKey(makerDelList);
				//削除したテータをshopFormListに除去する
				for (int i = 0, length = makerFormList.size(); i < length; i++) {
					if(makerFormList.get(i).getDelType()) {
						makerFormList.remove(makerFormList.get(i));
			            length--;
			            i--;
					}
				}
			}
			makerService.updateMakerByKey(makerList);
		}
		
		
		return makerFormList;
	}
}
