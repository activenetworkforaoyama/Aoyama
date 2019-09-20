package co.jp.aoyama.macchinetta.app.cash;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.google.gson.Gson;

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
	
	//TSCステータス 会計済
	private static final String TSC_STATUST2 = "T2";
	//TSCステータス 会計済
	private static final String TSC_STATUST3 = "T3";
	//01:会計済
	private static final String CASH_STATUST01 = "01";
	//02:会計取消
	private static final String CASH_STATUST02 = "02";
	
	Cash cash = new Cash();
	
	//private CashForm cashForm = new  CashForm();
		

	@ModelAttribute(value = "cashForm")
	public CashForm setupCashForm() {
		return new  CashForm();
	}

	@RequestMapping(value = "cashReForm")
	public String toCashReForm(Model model,HttpServletRequest req) {
		CashForm cashForm = (CashForm) req.getSession().getAttribute("cashForm");
		return "cash/cashReconfirmForm";
		
	}
	
	/**
	 * 新規会計 会計修正
	 * @param cashForm
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "cashReFormInDb", method = RequestMethod.POST)
	public String cashReFormInDb(CashForm cashForm,Model model, HttpServletRequest request) {
//		CashForm cashForm = new CashForm();
		cashForm = (CashForm)request.getSession().getAttribute("cashForm");
		//JSPversion
		String cashFormVersion = cashForm.getVersion();
		cash.setCashId(cashForm.getCashId());
		cash.setShopCode(cashForm.getShopCode());
		//注文合計
		String cashTotalPrice = cashForm.getCashTotalPrice().replace(",","");
		cash.setCashTotalPrice(Integer.parseInt(cashTotalPrice));
		//内商品合計
		String cashExceptTaxPrice = cashForm.getCashExceptTaxPrice().replace(",","");
		cash.setCashExceptTaxPrice(Integer.parseInt(cashExceptTaxPrice));
		//内消費税
		String cashTaxAmount = cashForm.getCashTaxAmount().replace(",","");
		cash.setCashTaxAmount(Integer.parseInt(cashTaxAmount));
		//オーダーパターン
		cash.setOrderPattern(cashForm.getOrderPattern());
		//業態
		cash.setStoreBrandCode(cashForm.getStoreBrandCode());
		//営業担当者
		cash.setStoreStaffNm(cashForm.getCustStaff());
		cash.setProductOrderdDate(cashForm.getProductOrderdDate());
		cash.setCustCd(cashForm.getCustCd());
		cash.setOrderAmount(cashForm.getOrderAmount());
		List<CashInfo> cashInfoList = cashForm.getHelpCashForm();
		List<CashInfo> orderList = cashForm.getOrderIdList();
		String json = new Gson().toJson(cashInfoList);
		List<CashInfo> cashInfoUpdList = new ArrayList<CashInfo>();
		long totalPrice= Long.parseLong(cashTotalPrice);
		long discountPrice = 0;
		int lastMount = 0;
		//バージョン管理用
		short version = 1;
		for(int i = 0;i<cashInfoList.size();i++) {
			discountPrice += cashInfoList.get(i).getCashDiscountPrice();
		}
		Cash cashId = cashService.selectByPrimaryKey(cashForm.getCashId());
		// 新規会計の場合
		if(cashId == null) {
			for(int i = 0;i<cashForm.getHelpCashForm().size();i++) {
				CashInfo cashInfo = cashInfoService.selectOrderByOrderId(cashInfoList.get(i).getOrderId());
				long cashDiscountPrice = cashInfoList.get(i).getCashDiscountPrice();
				//会計後商品金額（税込み）
				if(i == cashForm.getHelpCashForm().size() -1 ) {
					if(discountPrice != 0) {
						long discount = totalPrice - lastMount;
						cashInfo.setCashContailTaxProductPrice((Integer.parseInt(String.valueOf(discount))));
					}else {
						cashInfo.setCashContailTaxProductPrice(0);
					}
				}else {
					if(discountPrice != 0) {
						long discount = (totalPrice*cashDiscountPrice) / (discountPrice);
						cashInfo.setCashContailTaxProductPrice((Integer.parseInt(String.valueOf(discount))));
						lastMount += Integer.parseInt(String.valueOf(discount));
					}else {
						cashInfo.setCashContailTaxProductPrice(0);
					}
				}
				if(cashInfo.getVersion().equals(cashInfoList.get(i).getVersion())) {
					//値引き後金額
					cashInfo.setCashDiscountPrice(cashInfoList.get(i).getCashDiscountPrice());
					//会計ID
					cashInfo.setCashId(cash.getCashId());
					//会計後商品金額（税抜き）
					cashInfo.setCashProductPrice(cashInfoList.get(i).getCashProductPrice());
					// T3 ：会計済
					cashInfo.setTscStatus(TSC_STATUST3);
					cashInfo.setUpdatedAt(new Date());
					cashInfo.setUpdatedUserId(sessionContent.getUserId());
					cashInfoUpdList.add(cashInfo);
					//cashInfoService.updateOrderByOrderId(cashInfo);
				}else {
					ResultMessages messages = ResultMessages.error();
		            messages.add("E023", cashInfo.getVersion());
		            model.addAttribute("resultMessages",messages);
		            model.addAttribute("json", json);
		            return "cash/cashReconfirmForm";
				}
			}
			if(cashInfoUpdList.size() == cashInfoList.size()) {
				//cashService.updateCashInfoByPrimaryKey(cashInfoUpdList);
				// 01：会計済
				cash.setCreatedAt(new Date());
				cash.setCreatedUserId(sessionContent.getUserId());
				cash.setUpdatedAt(new Date());
				cash.setUpdatedUserId(sessionContent.getUserId());
				cash.setCashStatus(CASH_STATUST01);
				cash.setVersion(version);
				//cashService.insertCash(cash);
				cashService.insertCashUpdateCashInfo(cashInfoUpdList, cash);
			}
			model.addAttribute("status","fromOrderList");
			model.addAttribute("cashId",cashForm.getCashId());
		}
		//会計修正更新の場合
		else {
			String nowVersion = String.valueOf(cashId.getVersion());
			if(orderList.size() != 0) {
				for(int i = 0; i < orderList.size(); i ++) {
					CashInfo orderInfo = cashInfoService.selectOrderByOrderId(orderList.get(i).getOrderId());
					orderInfo.setCashId("");
					orderInfo.setUpdatedAt(new Date());
					orderInfo.setUpdatedUserId(sessionContent.getUserId());
					cashInfoUpdList.add(orderInfo);
				}
			}

			for(int i = 0;i<cashForm.getHelpCashForm().size();i++) {
				CashInfo cashInfo = cashInfoService.selectOrderByOrderId(cashInfoList.get(i).getOrderId());
				long cashDiscountPrice = cashInfoList.get(i).getCashDiscountPrice();
				//会計後商品金額（税込み）
				if(i == cashForm.getHelpCashForm().size() -1 ) {
					if(discountPrice != 0) {
						long discount = totalPrice - lastMount;
						cashInfo.setCashContailTaxProductPrice((Integer.parseInt(String.valueOf(discount))));
					}else {
						cashInfo.setCashContailTaxProductPrice(0);
					}
				}else {
					if(discountPrice != 0) {
						long discount = (totalPrice*cashDiscountPrice) / (discountPrice);
						cashInfo.setCashContailTaxProductPrice((Integer.parseInt(String.valueOf(discount))));
						lastMount += Integer.parseInt(String.valueOf(discount));
					}else {
						cashInfo.setCashContailTaxProductPrice(0);
					}
				}
				if(cashInfo.getVersion().equals(cashInfoList.get(i).getVersion())) {
					//値引き後金額
					cashInfo.setCashDiscountPrice(cashInfoList.get(i).getCashDiscountPrice());
					//会計ID
					cashInfo.setCashId(cash.getCashId());
					//会計後商品金額（税抜き）
					cashInfo.setCashProductPrice(cashInfoList.get(i).getCashProductPrice());
					// T3 ：会計済
					cashInfo.setTscStatus(TSC_STATUST3);
					cashInfo.setUpdatedAt(new Date());
					cashInfo.setUpdatedUserId(sessionContent.getUserId());
					cashInfoUpdList.add(cashInfo);
				}else {
					ResultMessages messages = ResultMessages.error();
		            messages.add("E025", cashInfo.getVersion());
		            model.addAttribute("resultMessages",messages);
		            model.addAttribute("json", json);
		            return "cash/cashReconfirmForm";
				}
				//cashInfoService.updateOrderByOrderId(cashInfo);
			}
			//排他制御
			if(cashFormVersion.equals(nowVersion) && cashInfoUpdList.size() != 0) {
				//cashService.updateCashInfoByPrimaryKey(cashInfoUpdList);
				// 01：会計済
				cashId.setCashStatus(CASH_STATUST01);
				cashId.setOrderAmount(cashForm.getOrderAmount());
				cashId.setUpdatedAt(new Date());
				cashId.setUpdatedUserId(sessionContent.getUserId());
				//注文合計
				cashId.setCashTotalPrice(Integer.parseInt(cashTotalPrice));
				//内商品合計
				cashId.setCashExceptTaxPrice(Integer.parseInt(cashExceptTaxPrice));
				//内消費税
				cashId.setCashTaxAmount(Integer.parseInt(cashTaxAmount));
				//cashService.updateCash(cashId);
				cashService.updateAll(cashInfoUpdList, cashId);
			}else {
				ResultMessages messages = ResultMessages.error();
	            messages.add("E025", cashId.getVersion());
	            model.addAttribute("resultMessages",messages);
	            model.addAttribute("json", json);
	            return "cash/cashReconfirmForm";
			}
			model.addAttribute("cashId",cashForm.getCashId());
			model.addAttribute("status","fromAccounting");
		}
		return "forward:/cashResult/cashResultForm";
	}
	/**
	 * 会計取消。
	 * @param cashId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateCash", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateCashByPrimaryKey(String cashId, String version, Model model) {
		// 会計IDによって 会計を取得
		Cash cash = cashService.selectByPrimaryKey(cashId);
		String versionDb = String.valueOf(cash.getVersion());
		// 会計IDによって 注文を取得
		List<CashInfo> CashInfoList = cashInfoService.selectOrderByCashId(cashId);
		String json = new Gson().toJson(CashInfoList);
		List<CashInfo> cashInfoUpdList = new ArrayList<CashInfo>();
		for(int i = 0; i < CashInfoList.size(); i ++) {
			CashInfo cashInfo = cashInfoService.selectOrderByOrderId(CashInfoList.get(i).getOrderId());
			if(cashInfo.getVersion().equals(CashInfoList.get(i).getVersion())) {
				// T2 ：登録済（会計済->登録済)
				cashInfo.setTscStatus(TSC_STATUST2);
				cashInfo.setUpdatedAt(new Date());
				//受注テーブルの値引き後金額
				cashInfo.setCashDiscountPrice(0);
				//受注テーブルの会計ID
				cashInfo.setCashId(null);
				//受注テーブルの会計後商品金額（税抜き）
				cashInfo.setCashProductPrice(0);
				//受注テーブルの会計後商品金額（税込み）
				cashInfo.setCashContailTaxProductPrice(0);
				cashInfo.setUpdatedUserId(sessionContent.getUserId());
				cashInfoUpdList.add(cashInfo);
			}else {
				ResultMessages messages = ResultMessages.error();
	            messages.add("E025", cashInfo.getVersion());
	            model.addAttribute("resultMessages",messages);
	            model.addAttribute("json", json);
	            return "cash/cashReconfirmForm";
			}
			
		}
		if(version.equals(versionDb) && cashInfoUpdList.size() == CashInfoList.size()) {
			// 02 ：会計取消
			cash.setCashStatus(CASH_STATUST02);
			cash.setUpdatedAt(new Date());
			cash.setUpdatedUserId(sessionContent.getUserId());
//			cashService.updateCash(cash);
//			cashService.updateCashInfoByPrimaryKey(cashInfoUpdList);
			cashService.updateAll(cashInfoUpdList, cash);
		}else {
			ResultMessages messages = ResultMessages.error();
            messages.add("E025", cash.getVersion());
            model.addAttribute("resultMessages",messages);
            model.addAttribute("json", json);
            return "cash/cashReconfirmForm";
		}
		String status = cash.getCashStatus();
		model.addAttribute("status",status);
		model.addAttribute("cashId",cashId);
		return "forward:/cashResult/cashResultForm";
	}
}
