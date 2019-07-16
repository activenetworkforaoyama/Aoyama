package co.jp.aoyama.macchinetta.app.cash;

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

import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.CashInfo;
import co.jp.aoyama.macchinetta.domain.service.cash.CashInfoService;
import co.jp.aoyama.macchinetta.domain.service.cash.CashService;
@Controller
@RequestMapping("/cashConfirm")
@SessionAttributes(value = {"cashForm"})
public class CashReconfirmController {
	@Inject
	SessionContent sessionContent;
	
	@Inject
	Mapper beanMapper;
	
	@Inject
	CashService cashService;
	
	@Inject
	CashInfoService cashInfoService;
	
	Cash cash = new Cash();
	
	private CashForm cashForm = new  CashForm();
		

	@ModelAttribute(value = "cashForm")
	public CashForm setupCashForm() {
		return cashForm;
	}

	@RequestMapping(value = "cashReForm")
	public String toCashReForm(@ModelAttribute(value = "cashForm")CashForm cashForm,Model model,HttpServletRequest req) {
		this.cashForm = (CashForm) req.getSession().getAttribute("cashForm");
		return "cash/cashReconfirmForm";
		
	}
	@RequestMapping(value = "cashReFormInDb", method = RequestMethod.POST)
	public String cashReFormInDb(@ModelAttribute(value = "cashForm")CashForm cashForm,Model model, HttpServletRequest request) {
		this.cashForm = (CashForm)request.getSession().getAttribute("cashForm");
		cash.setCashId(this.cashForm.getCashId());
		cash.setShopCode(this.cashForm.getShopCode());
		String cashTotalPrice = cashForm.getCashTotalPrice().replace(",","");
		cash.setCashTotalPrice(Integer.parseInt(cashTotalPrice));
		String cashExceptTaxPrice = cashForm.getCashExceptTaxPrice().replace(",","");
		cash.setCashExceptTaxPrice(Integer.parseInt(cashExceptTaxPrice));
		String cashTaxAmount = cashForm.getCashTaxAmount().replace(",","");
		cash.setCashTaxAmount(Integer.parseInt(cashTaxAmount));
		cash.setOrderPattern(this.cashForm.getOrderPattern());
		cash.setStoreBrandCode(this.cashForm.getStoreBrandCode());
		cash.setStoreStaffNm(this.cashForm.getCustStaff());
		cash.setProductOrderdDate(this.cashForm.getProductOrderdDate());
		cash.setCustCd(this.cashForm.getCustCd());
		cash.setOrderAmount(this.cashForm.getOrderAmount());
		List<CashInfo> cashInfoList = this.cashForm.getHelpCashForm();
		long totalPrice= Long.parseLong(cashTotalPrice);
		long discountPrice = 0;
		for(int i = 0;i<cashInfoList.size();i++) {
			discountPrice += cashInfoList.get(i).getCashDiscountPrice();
		}
		Cash cashId = cashService.selectByPrimaryKey(this.cashForm.getCashId());
		// 新規会計の場合
		if(cashId == null) {
			// 01：会計済
			cash.setCreatedAt(new Date());
			cash.setCreatedUserId(sessionContent.getUserId());
			cash.setUpdatedAt(new Date());
			cash.setUpdatedUserId(sessionContent.getUserId());
			cash.setCashStatus("01");
			cashService.insertCash(cash);
			for(int i = 0;i<cashForm.getHelpCashForm().size();i++) {
				CashInfo cashInfo = cashInfoService.selectOrderByOrderId(cashInfoList.get(i).getOrderId());
				long cashDiscountPrice = cashInfoList.get(i).getCashDiscountPrice();
				if(discountPrice != 0) {
					long discount = Math.round((totalPrice*cashDiscountPrice) / (discountPrice));
					cashInfo.setCashContailTaxProductPrice((Integer.parseInt(String.valueOf(discount))));
				}else {
					cashInfo.setCashContailTaxProductPrice(0);
				}
				//long discount = Math.round((totalPrice*cashDiscountPrice) / (discountPrice));
				cashInfo.setCashDiscountPrice(cashInfoList.get(i).getCashDiscountPrice());
				cashInfo.setCashId(cash.getCashId());
				cashInfo.setCashProductPrice(cashInfoList.get(i).getCashProductPrice());
				// T3 ：会計済
				cashInfo.setTscStatus("T3");
				cashInfo.setUpdatedAt(new Date());
				cashInfo.setUpdatedUserId(sessionContent.getUserId());
				//cashInfo.setCashContailTaxProductPrice((Integer.parseInt(String.valueOf(discount))));
				cashInfoService.updateOrderByOrderId(cashInfo);
			}
			model.addAttribute("status","fromOrderList");
		}else {
			cashId.setUpdatedAt(new Date());
			cashId.setUpdatedUserId(sessionContent.getUserId());
			cashId.setCashTotalPrice(Integer.parseInt(cashTotalPrice));
			cashId.setCashExceptTaxPrice(Integer.parseInt(cashExceptTaxPrice));
			cashId.setCashTaxAmount(Integer.parseInt(cashTaxAmount));
			cashService.updateCash(cashId);
			for(int i = 0;i<cashForm.getHelpCashForm().size();i++) {
				CashInfo cashInfo = cashInfoService.selectOrderByOrderId(cashInfoList.get(i).getOrderId());
				long cashDiscountPrice = cashInfoList.get(i).getCashDiscountPrice();
				if(discountPrice != 0) {
					long discount = Math.round((totalPrice*cashDiscountPrice) / (discountPrice));
					cashInfo.setCashContailTaxProductPrice((Integer.parseInt(String.valueOf(discount))));
				}else {
					cashInfo.setCashContailTaxProductPrice(0);
				}
				cashInfo.setCashDiscountPrice(cashInfoList.get(i).getCashDiscountPrice());
				cashInfo.setCashId(cash.getCashId());
				cashInfo.setCashProductPrice(cashInfoList.get(i).getCashProductPrice());
				cashInfo.setUpdatedAt(new Date());
				cashInfo.setUpdatedUserId(sessionContent.getUserId());
				//cashInfo.setCashContailTaxProductPrice((Integer.parseInt(String.valueOf(discount))));
				cashInfoService.updateOrderByOrderId(cashInfo);
			}
			model.addAttribute("status","fromAccounting");
		}
		return "forward:/cashResult/cashResultForm";
	}
	
	@RequestMapping(value = "/updateCash/{cashId}", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateCashByPrimaryKey(@PathVariable(value ="cashId") String cashId,Model model) {
		Cash cash = cashService.selectByPrimaryKey(cashId);
		
		// 02 ：会計取消
		cash.setCashStatus("02");
		cash.setUpdatedAt(new Date());
		cash.setUpdatedUserId(sessionContent.getUserId());
		cashService.updateCash(cash);
		List<CashInfo> CashInfoList = cashInfoService.selectOrderByCashId(cashId);
		for(int i = 0; i < CashInfoList.size(); i ++) {
			CashInfo cashInfo = cashInfoService.selectOrderByOrderId(CashInfoList.get(i).getOrderId());
			// T2 ：登録済
			cashInfo.setTscStatus("T2");
			cashInfo.setUpdatedAt(new Date());
			cashInfo.setCashDiscountPrice(0);
			cashInfo.setCashId("");
			cashInfo.setCashProductPrice(0);
			cashInfo.setCashContailTaxProductPrice(0);
			cashInfo.setUpdatedUserId(sessionContent.getUserId());
			cashInfoService.updateOrderByOrderId(cashInfo);
		}
		String status = cash.getCashStatus();
		model.addAttribute("status",status);
		return "forward:/cashResult/cashResultForm";
	}
}
