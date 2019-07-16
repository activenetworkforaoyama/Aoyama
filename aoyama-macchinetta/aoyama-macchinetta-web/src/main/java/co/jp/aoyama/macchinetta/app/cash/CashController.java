package co.jp.aoyama.macchinetta.app.cash;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;

import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.CashInfo;
import co.jp.aoyama.macchinetta.domain.service.cash.CashInfoService;
import co.jp.aoyama.macchinetta.domain.service.cash.CashService;
import co.jp.aoyama.macchinetta.domain.service.consumption.ConsumptionService;

@Controller
@RequestMapping(value = "cash")
@SessionAttributes(value = {"cashForm"})
public class CashController {
	@Inject
	SessionContent sessionContent;
	
	@Inject
	CashService cashService;
	
	@Inject
	CashInfoService cashInfoService;
	
	@Inject
	ConsumptionService consumptionService;

	
	private Cash cash = new Cash();
	
	private CashForm cashForm = new  CashForm();
	
	
	@Inject
	Mapper beanMapper;
	
	@ModelAttribute(value = "cashForm")
	public CashForm setupCashForm() {
		return cashForm;
	}
	
	@RequestMapping(value = "init")
	public String PageSearch(Model model) {
		return "cash/cashForm";
	}
	@RequestMapping(value = "goBack")
	public String goBack(@ModelAttribute(value = "cashForm")CashForm cashForm,Model model,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		Date date = new Date();
		// 消費税を取得
		int taxRate = consumptionService.getTaxRate(date);
		String taxRateStr = String.valueOf(taxRate);
		model.addAttribute("taxRateStr", taxRateStr);
		String flag = "cashGoBack";
		cashForm.setBackFlag(flag);
		List<CashInfo> helpCashForm = cashForm.getHelpCashForm();
		String json = new Gson().toJson(helpCashForm);
		model.addAttribute("json", json);
		return "cash/cashForm";
	}
	
	@RequestMapping(value = "/gotoCash/{orderIdArray}",method = { RequestMethod.POST, RequestMethod.GET }) 
	public String gotoCash(@PathVariable(value ="orderIdArray") String orderIdArray, Model model,SessionStatus sessionStatus) { 
		sessionStatus.setComplete();
		String[] strs = orderIdArray.split(",");
		Arrays.sort(strs); 
		List<CashInfo> helpCashForm = new ArrayList<CashInfo>();
		Long[] arr = new Long[strs.length];
		Short amount = (short) strs.length;
		for(int i=0;i<strs.length;i++){
			CashInfo cashinfo = cashInfoService.selectOrderByOrderId(strs[i]);
			arr[i] = Long.parseLong(cashinfo.getOrderId());
			helpCashForm.add(cashinfo);
		}
		Arrays.sort(arr); 
		cashForm.setHelpCashForm(helpCashForm);
		Cash cash = cashService.selectOrderByOrderId(strs[0].toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String cashId = sdf.format(new Date()) + "-" + cash.getShopCode();
		String flag = "orderFrom";
		cashForm.setBackFlag(flag);
		cash.setCashId(cashId);
		cash.setOrderAmount(amount);
		cash.setCashStatus("01");
		//cash.setProductOrderdDate(productOrderdDate);
		beanMapper.map(cash, cashForm);
		Date date = new Date();
		// 消費税を取得
		int taxRate = consumptionService.getTaxRate(date);
		String taxRateStr = String.valueOf(taxRate);
		model.addAttribute("taxRateStr", taxRateStr);
		String json = new Gson().toJson(helpCashForm);
		model.addAttribute("json", json);
		return "cash/cashForm";
	}
	
	@RequestMapping(value = "/goToAccountingLink/{cashId}",method = { RequestMethod.POST, RequestMethod.GET })
	public String goToAccountingLink(@PathVariable(value ="cashId") String cashId,Model model,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		Cash cash = cashService.selectByPrimaryKey(cashId);
		List<Cash> cashList = cashService.selectOrderByCashId(cash.getCashId());
		List<CashInfo> helpCashForm = cashInfoService.selectOrderByCashId(cashId);
		List<String> factoryStatus=new ArrayList<>();
		for(int i = 0;i<cashList.size();i++) {
			factoryStatus.add(cashList.get(i).getMakerFactoryStatus());
		}
		//F0 ：生産開始前
		if(factoryStatus.contains("F0") || factoryStatus.contains("f0")) {
			cashForm.setHelpCashForm(helpCashForm);
			String flag = "cashInit";
			cashForm.setBackFlag(flag);
			cash.setCustNm(cashList.get(0).getCustNm());
			beanMapper.map(cash, cashForm);
			Date date = new Date();
			// 消費税を取得
			int taxRate = consumptionService.getTaxRate(date);
			String taxRateStr = String.valueOf(taxRate);
			model.addAttribute("taxRateStr", taxRateStr);
			String json = new Gson().toJson(helpCashForm);
			model.addAttribute("json", json);
			return "cash/cashForm";
		}else {
			cash.setCustNm(cashList.get(0).getCustNm());
			cashForm.setHelpCashForm(helpCashForm);
			beanMapper.map(cash, cashForm);
			String json = new Gson().toJson(helpCashForm);
			model.addAttribute("json", json);
			return "cash/cashReconfirmForm";
		}
	}
	
	@RequestMapping(value = "cashReconfirm", method ={RequestMethod.POST})
	public String toCashReconfirm(@ModelAttribute(value = "cashForm")CashForm cashForm,Model model, HttpServletRequest request) {
		request.getSession().setAttribute("cashForm", cashForm);
		List<CashInfo> helpCashForm = cashForm.getHelpCashForm();
		String json = new Gson().toJson(helpCashForm);
		model.addAttribute("json", json);
		return "cash/cashReconfirmForm";
	}

}
