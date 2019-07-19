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
	
	/**
	 * 「会計登録画面」に遷移する。
	 * @param cashForm
	 * @param model
	 * @param sessionStatus
	 * @return
	 */
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
	
	/**
	 * 「会計登録画面」に遷移する。
	 * @param orderIdArray
	 * @param model
	 * @param sessionStatus
	 * @return
	 */
	@RequestMapping(value = "/gotoCash/{orderIdArray}",method = { RequestMethod.POST, RequestMethod.GET }) 
	public String gotoCash(@PathVariable(value ="orderIdArray") String orderIdArray, Model model,SessionStatus sessionStatus) { 
		sessionStatus.setComplete();
		String[] strs = orderIdArray.split(",");
		Arrays.sort(strs); 
		List<CashInfo> helpCashForm = new ArrayList<CashInfo>();
		Long[] arr = new Long[strs.length];
		//会計の注文の件数
		Short amount = (short) strs.length;
		for(int i=0;i<strs.length;i++){
			CashInfo cashinfo = cashInfoService.selectOrderByOrderId(strs[i]);
			arr[i] = Long.parseLong(cashinfo.getOrderId());
			helpCashForm.add(cashinfo);
		}
		Arrays.sort(arr); 
		cashForm.setHelpCashForm(helpCashForm);
		Cash cash = cashService.selectOrderByOrderId(strs[0].toString());
		//会計No.採番ルール:YYMMDDhhmmssSSS＋"－"＋店（４桁）
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String cashId = sdf.format(new Date()) + "-" + cash.getShopCode();
		String flag = "orderFrom";
		cashForm.setBackFlag(flag);
		cash.setCashId(cashId);
		cash.setOrderAmount(amount);
		cash.setCashStatus("01");
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
	
	/**
	 * 「会計登録画面」に遷移する。
	 * @param cashId
	 * @param model
	 * @param sessionStatus
	 * @return
	 */
	@RequestMapping(value = "/goToAccountingLink/{cashId}",method = { RequestMethod.POST, RequestMethod.GET })
	public String goToAccountingLink(@PathVariable(value ="cashId") String cashId,Model model,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		// 会計IDによって 会計を取得
		Cash cash = cashService.selectByPrimaryKey(cashId);
		List<Cash> cashList = cashService.selectOrderByCashId(cash.getCashId());
		// 会計IDによって 注文を取得
		List<CashInfo> cashInfoList = cashInfoService.selectOrderByCashId(cashId);
		List<CashInfo> orderIdList = new ArrayList<CashInfo>();
		List<CashInfo> helpCashForm = new ArrayList<CashInfo>();
		for(int i = 0 ;i < cashInfoList.size();i ++) {
			if ("1".equals(cashInfoList.get(i).getIsCancelled())) {
				orderIdList.add(cashInfoList.get(i));
			}
			if ("0".equals(cashInfoList.get(i).getIsCancelled())) {
				helpCashForm.add(cashInfoList.get(i));
			}
		}
		List<String> factoryStatus=new ArrayList<>();
		for(int i = 0;i<cashList.size();i++) {
			factoryStatus.add(cashList.get(i).getMakerFactoryStatus());
		}
		//F0 ：生産開始前
		if(factoryStatus.contains("F0") || factoryStatus.contains("f0")) {
			cashForm.setOrderIdList(orderIdList);
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
	
	/**
	 * 「会計内容確認」画面に遷移する。
	 * @param cashForm
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "cashReconfirm", method ={RequestMethod.POST})
	public String toCashReconfirm(@ModelAttribute(value = "cashForm")CashForm cashForm,Model model, HttpServletRequest request) {
		request.getSession().setAttribute("cashForm", cashForm);
		List<CashInfo> helpCashForm = cashForm.getHelpCashForm();
		String json = new Gson().toJson(helpCashForm);
		model.addAttribute("json", json);
		return "cash/cashReconfirmForm";
	}

}