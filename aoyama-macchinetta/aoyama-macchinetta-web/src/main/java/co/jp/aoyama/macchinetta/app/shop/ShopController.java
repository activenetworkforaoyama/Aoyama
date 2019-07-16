package co.jp.aoyama.macchinetta.app.shop;

import java.util.ArrayList;
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

import co.jp.aoyama.macchinetta.domain.model.Shop;
import co.jp.aoyama.macchinetta.domain.service.shop.ShopService;

@Controller
@RequestMapping(value = "/shop")
public class ShopController {
	@Inject
	ShopService shopService;
	@Inject
	Mapper beanMapper;
	private ShopForm shopForm = new ShopForm();

	@ModelAttribute
	public ShopForm setupForm() {
		return shopForm;
	}
    /**
     * 初期表示.
     * @return
     */
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String PageSearch2(Model model) {
		return "shop/shopForm";
	}

    /**
     * 全部店舗を検索.
     * @return 店舗情報リスト
     */
	@RequestMapping(value = "shopDataFind", method = RequestMethod.GET)
	@ResponseBody
	public List<ShopForm> PageDataFind() {
		List<ShopForm> ShopFormList = new ArrayList<ShopForm>();
		List<Shop> shopList = shopService.findAllShop();
		for (Shop shop : shopList) {
			ShopForm shopForm = beanMapper.map(shop, ShopForm.class);
			ShopFormList.add(shopForm);
		}
		return ShopFormList;
	}
	
    /**
     * 店舗更新.
     * @param shopFormList 画面Form
     * @param model model
     * @return result　結果Form
     */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public List<ShopForm> updateShopByPk(@RequestBody List<ShopForm> shopFormList) {
		List<Shop> shopList = new ArrayList<Shop>();
		List<Shop> shopDelList = new ArrayList<Shop>();
		//更新成功flag
		boolean updateSuccess = true;
		for (int i = 0; i < shopFormList.size(); i++) {
			
			if (shopFormList.get(i).getShopCode() == null || "".equals(shopFormList.get(i).getShopCode()) ||
					shopFormList.get(i).getShopName() == null || "".equals(shopFormList.get(i).getShopName()) ||
					shopFormList.get(i).getStoreBrandCode() == null || "".equals(shopFormList.get(i).getStoreBrandCode())) {
				
					//updateFlag  0 : 更新成功          1 :更新失敗(その他)    2 : 更新失敗(一意制約 )     3 : 更新失敗(null)
					shopFormList.get(i).setUpdateFlag("3");
					//nullのせいで、更新失敗
					updateSuccess = false;

			}else {
				
				if(shopFormList.get(i).getDelType()) {
					//削除の場合
					Shop shop = beanMapper.map(shopFormList.get(i), Shop.class);
					shopDelList.add(shop);
				}else {

						//更新、挿入の場合
						Shop shop = beanMapper.map(shopFormList.get(i), Shop.class);
						shopList.add(shop);
		
						//更新する前のチェック
						boolean shopIsExist = shopService.shopIsExist(shopFormList.get(i).getShopCode());
						//データなし、OptionTypeは「更新」の場合
						if (!shopIsExist && "1".equals(shop.getOptionType())) {
							//updateFlag  0 : 更新成功       1 :更新失敗(その他)       2 : 更新失敗(一意制約) 
							shopFormList.get(i).setUpdateFlag("1");
							//更新失敗
							updateSuccess = false;
						}
						//データがあり、OptionTypeは「挿入」の場合
						if (shopIsExist && "2".equals(shop.getOptionType())) {
							//updateFlag  0 : 更新成功       1 :更新失敗(その他)       2 : 更新失敗(一意制約) 
							shopFormList.get(i).setUpdateFlag("2");
							//一意制約のせいで、更新失敗
							updateSuccess = false;
						}
						//データがなし、OptionTypeは「挿入」の場合
						if (!shopIsExist && "2".equals(shop.getOptionType())) {
							//updateFlag  0 : 更新成功       1 :更新失敗(その他)       2 : 更新失敗(一意制約) 
							shopFormList.get(i).setUpdateFlag("0");
							shopFormList.get(i).setDisplayIdentify(true);
						}
				}

			}

		}
		if (updateSuccess) {
			if(shopDelList.size()!=0) {
				shopService.deleteShopByPk(shopDelList);
				//削除したテータをshopFormListに除去する
				for (int i = 0, length = shopFormList.size(); i < length; i++) {
					if(shopFormList.get(i).getDelType()) {
						shopFormList.remove(shopFormList.get(i));
			            length--;
			            i--;
					}
				}
			}
			shopService.updateShopByPk(shopList);
		}

		return shopFormList;

	}
	
    /**
     * 条件検索.
     * @param shopForm 画面Form
     * @param model model
     * @return shopFormList　検索結果list
     */
	@RequestMapping(value = "/fuzzyQuery" , method = RequestMethod.GET)
	@ResponseBody
	public List<ShopForm> fuzzyQuery(ShopForm shopForm){
		//検索条件bean
		Shop shop = beanMapper.map(shopForm, Shop.class);
		List<Shop> shopList = shopService.fuzzyQuery(shop);
		List<ShopForm> shopFormList = new ArrayList<ShopForm>();
		for (Shop shopL : shopList) {
			ShopForm shopFormL = beanMapper.map(shopL, ShopForm.class);
			shopFormList.add(shopFormL);
		}
		//検索結果list
		return shopFormList;
	}
	
	
}
