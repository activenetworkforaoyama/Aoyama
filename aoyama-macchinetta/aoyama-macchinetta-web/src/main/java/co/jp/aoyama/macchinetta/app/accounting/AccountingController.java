package co.jp.aoyama.macchinetta.app.accounting;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.app.shop.ShopForm;
import co.jp.aoyama.macchinetta.domain.model.Accounting;
import co.jp.aoyama.macchinetta.domain.model.Shop;
import co.jp.aoyama.macchinetta.domain.service.accounting.AccountingService;
import co.jp.aoyama.macchinetta.domain.service.cash.CashService;
import co.jp.aoyama.macchinetta.domain.service.shop.ShopService;

@Controller
@RequestMapping(value = "/accounting")
public class AccountingController {
	@Inject
	SessionContent sessionContent;
	
	@Inject
	AccountingService accountingService;
	
	@Inject
	CashService cashService;
	
	@Inject
	ShopService shopService;
	
	@Inject
	Mapper beanMapper;
	
	@RequestMapping(value = "init", method = RequestMethod.GET)
	public String init(Model model) {
		return "accounting/accountingForm";
	}
	
	@RequestMapping(value = "selectShop", method = RequestMethod.GET)
	@ResponseBody
	public List<ShopForm> selectShop(){
		List<ShopForm> shopFormList = new ArrayList<ShopForm>();
		List<Shop> shopList = shopService.findAllShop();
		for(Shop shop : shopList) {
			ShopForm shopForm = beanMapper.map(shop, ShopForm.class);
			shopFormList.add(shopForm);
		}
		return shopFormList;
	}
	
	@RequestMapping(value = "findShopByStoreBrandCode", method = RequestMethod.GET)
	@ResponseBody
	public List<ShopForm> findShopByStoreBrandCode(ShopForm shopForm){
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
	
	@RequestMapping(value = "/fuzzyQuery" , method = RequestMethod.GET)
	@ResponseBody
	public List<AccountingForm> fuzzyQuery(AccountingForm accountingForm) {
		accountingForm = stringToDate(accountingForm);
		Accounting accounting = beanMapper.map(accountingForm, Accounting.class);
		List<Accounting> accountingList = accountingService.fuzzyQuery(accounting);
		List<AccountingForm> accountingFormList = new ArrayList<AccountingForm>();
		for(Accounting accountingL : accountingList) {
			AccountingForm accountingFormL = beanMapper.map(accountingL, AccountingForm.class);
			accountingForm = dateToString(accountingFormL);
			accountingFormList.add(accountingFormL);
		}
		return accountingFormList;
	}
	
	/**
	   * 日付書式の変更:date-->string
	 */
	public AccountingForm dateToString(AccountingForm accountingForm){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		
		//Str形式をDate形式に変更する
		if (accountingForm.getProductOrderdDateFrom() != null) {
			accountingForm.setProductOrderdDateFromStr(format.format(accountingForm.getProductOrderdDateFrom()));
		}
		if (accountingForm.getProductOrderdDateTo() != null) {
			accountingForm.setProductOrderdDateToStr(format.format(accountingForm.getProductOrderdDateTo()));
		}
		return accountingForm;
	}
	
	/**
	   * 日付書式の変更:string-->date
	 */
	public AccountingForm stringToDate(AccountingForm accountingForm){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		
		try {
			//Str形式をDate形式に変更する
			if ((!"".equals(accountingForm.getProductOrderdDateFromStr())) && accountingForm.getProductOrderdDateFromStr() != null) {
				accountingForm.setProductOrderdDateFrom(format.parse(accountingForm.getProductOrderdDateFromStr()));
			}
			if ((!"".equals(accountingForm.getProductOrderdDateToStr())) && accountingForm.getProductOrderdDateToStr() != null) {
				accountingForm.setProductOrderdDateTo(format.parse(accountingForm.getProductOrderdDateToStr()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return accountingForm;
	}

}
