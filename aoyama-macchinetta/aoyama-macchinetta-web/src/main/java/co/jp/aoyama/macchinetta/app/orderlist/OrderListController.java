package co.jp.aoyama.macchinetta.app.orderlist;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.common.CsvUtil;
import co.jp.aoyama.macchinetta.app.detail.OrderDetailCoHelper;
import co.jp.aoyama.macchinetta.app.message.MessageKeys;
import co.jp.aoyama.macchinetta.app.order.enums.HeaderTitleEnum;
import co.jp.aoyama.macchinetta.app.order.enums.HeaderTitleMakerUseEnum;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.OrderCondition;
import co.jp.aoyama.macchinetta.domain.model.OrderDetailFormat;
import co.jp.aoyama.macchinetta.domain.model.OrderMakerUse;
import co.jp.aoyama.macchinetta.domain.model.ErrorResult;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.MemberName;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.service.errorResult.ErrorResultService;
import co.jp.aoyama.macchinetta.domain.service.measuring.MeasuringService;
import co.jp.aoyama.macchinetta.domain.service.member.MemberNameService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;

@Controller
@RequestMapping(value = "/orderlist")
@SessionAttributes(value = {"orderListForm"})
public class OrderListController {
	
	@Value("${member.url:http://202.214.88.88/member/api/v1/memname}")
	String memberUrl;

	@Inject
	OrderListService orderListService;
	
	@Inject
	MemberNameService memberNameService;
    @Inject
    SessionContent sessionContent;
    
    @Inject
    MeasuringService measuringService;
	
    @Inject
	OrderService orderService;
    
    @Inject
    ErrorResultService errorResultService;
    
	@Inject
	Mapper beanMapper;
	//店舗
	public static final String AUTHORITY_01 = "01";
	//商品部
	public static final String AUTHORITY_02 = "02";
	//メーカー
	public static final String AUTHORITY_03 = "03";
	//工場
	public static final String AUTHORITY_04 = "04";
	//倉庫
	public static final String AUTHORITY_05 = "05";
	
	//TSCステータス   一時保存
	public static final String TSC_STATUS_T0 = "T0";
	//TSCステータス  取り置き
	public static final String TSC_STATUS_T1 = "T1";
	//TSCステータス   登録済
	public static final String TSC_STATUS_T2 = "T2";
	//TSCステータス   会計済
	public static final String TSC_STATUS_T3 = "T3";
	//TSCステータス   商品部承認済
	public static final String TSC_STATUS_T4 = "T4";
	//TSCステータス  メーカー承認済
	public static final String TSC_STATUS_T5 = "T5";
	//TSCステータス   仕入済
	public static final String TSC_STATUS_T6 = "T6";
	//TSCステータス  お渡し済
	public static final String TSC_STATUS_T7 = "T7";

	//工場ステータス   生産開始前
	public static final String MAKER_FACTORY_STATUS_F0 = "F0";
	//工場ステータス   生産開始
	public static final String MAKER_FACTORY_STATUS_F1 = "F1";
	//工場ステータス   生産終了
	public static final String MAKER_FACTORY_STATUS_F2 = "F2";
	
	// 工場自動連携ステータス 送信前
	private static final String SEND2FACTORY_STATUS0 = "0";
	
	// 工場自動連携ステータス送信済み
	private static final String SEND2FACTORY_STATUS1 = "1";
	
	// 工場自動連携ステータス送信失敗 データエラー
	private static final String SEND2FACTORY_STATUS4 = "4";
	
	// 取り消しフラグ 取り消しではない
	private static final String IS_NOT_CANCELLED = "0";
	
	// 在庫チェックなし
	private static final String IS_NOT_THEORETICAL_STOCKCECK = "0";
	
    private static final Logger logger = LoggerFactory
            .getLogger(OrderListController.class);
    
	@ModelAttribute(value = "orderListForm")
	  public OrderListForm setupForm() {
	    OrderListForm orderListForm = new OrderListForm();
	    return orderListForm;
	  }
	  
    /**
                  * 初期表示.
     * @return
     */
	@RequestMapping(value = "init")
	public String initSearch(SessionStatus sessionStatus, Model model) {
	    OrderListForm orderListForm = new OrderListForm();
	    model.addAttribute(orderListForm);
		model.addAttribute("initFlag", "0");
		return "orderlist/orderList";
	}
	
    /**
                  * 初期表示. 一覧へ戻る
     * @return
     */
	@RequestMapping(value = "gotoOrderlist", method = RequestMethod.GET)	
	public String returnInitSearch(SessionStatus sessionStatus, Model model) {
		model.addAttribute("initFlag", "1");
		return "orderlist/orderList";
	}
	
    /**
                  * 初期表示. error
     * @return
     */
	@RequestMapping(value = "gotoOrderlistError", method = RequestMethod.GET)
	public String returnInitSearchError(SessionStatus sessionStatus, Model model) {
		model.addAttribute("initFlag", "2");
		return "orderlist/orderList";
	}
	
    /**
     * 全部注文を条件検索.
     * @param form 画面Form
     * @return 注文情報リスト
     */
	@RequestMapping(value = "/FindAllOrderByCondition", method = RequestMethod.GET)
	@ResponseBody
	public List<Order> FindAllOrderByCondition(@Validated OrderListForm orderListForm,
            BindingResult result,
            Model model) {

		orderListForm.setAuthority(sessionContent.getAuthority());
		orderListForm.setBelongCode(sessionContent.getBelongCode());
		orderListForm.setCategory(sessionContent.getCategory());
		//検索条件bean
		OrderCondition orderCondition = beanMapper.map(orderListForm,OrderCondition.class);
		//検索結果list
    	List<Order> orderList = orderListService.fuzzyQuery(orderCondition);
    	orderListForm.setOrderList(orderList);
		return orderList;
	}
	
    /**
     * orderIdのリンクのメソッド
     * @param orderId 注文ID
     * @param authority 権限
     * @param shopCode 店舗コード
     * @param Model model
     * @return String　遷移Controller
     */
	@RequestMapping(value = "/gotoOrderPoLink/{orderId}",method =RequestMethod.GET) 
	public String gotoOrderPoLink(@PathVariable(value ="orderId") String orderId,
	                            Model model) {
		String authority = sessionContent.getAuthority();
		String shopCode = sessionContent.getBelongCode();
		String userId = sessionContent.getUserId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
		
			//StringBuffer errorResult;
			String errorResult = "";
			Order order= orderListService.findOrderByPk(orderId);
			String custCd = order.getCustCd();
			String storeBrandCode = order.getStoreBrandCode();
			String gyotaiCd = "1";
			if(storeBrandCode != null && "01".equals(storeBrandCode)) {
				gyotaiCd = "1";
			}
			else if(storeBrandCode != null && ("03".equals(storeBrandCode) || "12".equals(storeBrandCode) || "21".equals(storeBrandCode))) {
				gyotaiCd = "3";
			}
			MemberName MemberName = memberNameService.execute(memberUrl,custCd,gyotaiCd);
			if(MemberName != null) {
				String firstName = MemberName.getFirstName();
				String lastName = MemberName.getLastName();
				if(firstName != null && lastName != null) {
					String custNm = lastName + " " + firstName;
					order.setCustNm(custNm);
				}
				else if(firstName == null && lastName != null) {
					String custNm = lastName;
					order.setCustNm(custNm);
				}
				else if(firstName != null && lastName == null) {
					String custNm = firstName;
					order.setCustNm(custNm);
				}
				String firstNameKana = MemberName.getFirstNameKana();
				String lastNameKana = MemberName.getLastNameKana();
				if(firstNameKana != null && lastNameKana != null) {
					String custKanaNm = lastNameKana + " " + firstNameKana;
					order.setCustKanaNm(custKanaNm);
				}
				else if(firstNameKana == null && lastNameKana != null) {
					String custKanaNm = lastNameKana;
					order.setCustKanaNm(custKanaNm);
				}
				else if(firstName != null && lastNameKana == null) {
					String custKanaNm = firstNameKana;
					order.setCustKanaNm(custKanaNm);
				}
			}
			
			//名簿納期
			Date custDeliverDate = order.getCustDeliverDate();
			if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
				String custDeliverDateFormat = sdf.format(custDeliverDate);
				Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
				order.setCustDeliverDate(custDeliverDateParse);
			}
			//お渡し日
			Date custShopDeliveryDate = order.getCustShopDeliveryDate();
			if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
				String custShopDeliveryDateFormat = sdf.format(custShopDeliveryDate);
				Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
				order.setCustShopDeliveryDate(custShopDeliveryDateParse);
			}
			//出荷日
			Date shippingDate = order.getShippingDate();
			if(shippingDate != null && !"".equals(shippingDate.toString())) {
				String shippingDateFormat = sdf.format(shippingDate);
				Date shippingDateParse = java.sql.Date.valueOf(shippingDateFormat);
				order.setShippingDate(shippingDateParse);
			}
			//積載日
			Date loadingDate = order.getLoadingDate();
			if(loadingDate != null && !"".equals(loadingDate.toString())) {
				String loadingDateFormat = sdf.format(loadingDate);
				Date loadingDateParse = java.sql.Date.valueOf(loadingDateFormat);
				order.setLoadingDate(loadingDateParse);
			}
			//注文承り日
			Date productOrderdDate = order.getProductOrderdDate();
			if(productOrderdDate != null && !"".equals(productOrderdDate.toString())) {
				String productOrderdDateFormat = sdf.format(productOrderdDate);
				Date productOrderdDateParse = java.sql.Date.valueOf(productOrderdDateFormat);
				order.setProductOrderdDate(productOrderdDateParse);
			}
			
			Measuring measuring = measuringService.selectByPrimaryKey(orderId);
			if("02".equals(authority)) {
				String send2factoryStatus = order.getSend2factoryStatus();
				if("4".equals(send2factoryStatus)) {
					List<ErrorResult> errorResultList = errorResultService.selectAllErrorResultByOrderId(order.getOrderId());
					if(errorResultList.size() == 1) {
						errorResult = "「" + errorResultList.get(0).getRemark() + "」";
					}else {
						for (int i = 0; i < errorResultList.size(); i++) {
							if(i == errorResultList.size()-1) {
								errorResult = errorResult.concat("「" + errorResultList.get(i).getRemark()+ "」");
							}else {
								errorResult = errorResult.concat("「" + errorResultList.get(i).getRemark()+ "」、");
							}
						}
					}
				}
				model.addAttribute("errorResult", errorResult);
			}
			
			/*
			 * if (measuring == null) { return "redirect:/orderlist/gotoOrderlistError"; }
			 */
			model.addAttribute("order", order);
			model.addAttribute("measuring", measuring);
			model.addAttribute("authority", authority);
			model.addAttribute("userId", userId);
			String orderFlag = "orderLink";
			model.addAttribute("orderFlag", orderFlag);
			//本店オーダー 、商品部の場合
			//店舗の場合
			if (order.getMakerFactoryStatus() != null &&
				order.getShopCode() != null && 
				order.getIsCancelled() != null) {
				if (authority.equals(AUTHORITY_01)) {
					//本店の生産開始前の場合、登録画面へ遷移
					if (order.getShopCode().equals(shopCode) && 
							order.getMakerFactoryStatus().equals(MAKER_FACTORY_STATUS_F0) && 
							(order.getSend2factoryStatus().equals(SEND2FACTORY_STATUS0) || order.getSend2factoryStatus().equals(SEND2FACTORY_STATUS4)) &&
							order.getIsCancelled().equals("0")) {
						if(TSC_STATUS_T2.equals(order.getTscStatus()) ||
								TSC_STATUS_T3.equals(order.getTscStatus()) ||
								TSC_STATUS_T4.equals(order.getTscStatus()) ||
								TSC_STATUS_T5.equals(order.getTscStatus())) {
							
							return "forward:/orderDetail/orderPoDetail"; 
							
						}else if(TSC_STATUS_T0.equals(order.getTscStatus()) || TSC_STATUS_T1.equals(order.getTscStatus()) || "".equals(order.getTscStatus()) || order.getTscStatus() == null){
							
							return "forward:/order/orderPoUpdate"; 
						}
							
					}
					
				}
				//商品部の場合
				if (authority.equals(AUTHORITY_02)) {
					//会計前の場合、登録画面へ遷移
					if ((order.getTscStatus() == null ||
							order.getTscStatus().equals("") ||
							order.getTscStatus().equals(TSC_STATUS_T0) || 
							order.getTscStatus().equals(TSC_STATUS_T1)) &&
							order.getIsCancelled().equals("0")) {
						return "forward:/order/orderPoUpdate"; 
					}
				}
				//明細画面へ遷移
				return "forward:/orderDetail/orderPoDetail";
			}else {
		    	return "redirect:/orderlist/gotoOrderlistError";
			}
			
		}catch (BusinessException e) {
	    		// メッセージリスト
		    	ResultMessages messages = e.getResultMessages();
		    	messages.add(MessageKeys.E021, orderId);
				// エラーメッセージ
		    	model.addAttribute("resultMessages", messages);
		    	// ログを出力
		    	logger.error(messages.toString());
		    	return "redirect:/orderlist/gotoOrderlistError";
	    } catch (ResourceNotFoundException e) {
	    		// メッセージリスト
		    	ResultMessages messages = e.getResultMessages();
		    	messages.add(MessageKeys.E021, orderId);
				// エラーメッセージ
		    	model.addAttribute("resultMessages", messages);
		    	// ログを出力
		    	logger.error(messages.toString());
		    	return "redirect:/orderlist/gotoOrderlistError";
	    }
	}

    /**
     * orderIdのリンクのメソッド
     * @param orderId 注文ID
     * @param authority 権限
     * @param shopCode 店舗コード
     * @param Model model
     * @return String　遷移Controller
     */
	@RequestMapping(value = "/gotoOrderCoLink/{orderId}",method =RequestMethod.GET) 
	public String gotoOrderCoLink(@PathVariable(value ="orderId") String orderId,
	                            Model model) {
		String authority = sessionContent.getAuthority();
		String shopCode = sessionContent.getBelongCode();
		String userId = sessionContent.getUserId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		OrderDetailFormat orderFm = new OrderDetailFormat();
		
		try {
		
			//StringBuffer errorResult;
			String errorResult = "";
			Order order= orderListService.findOrderByPk(orderId);
			String custCd = order.getCustCd();
			String storeBrandCode = order.getStoreBrandCode();
			String gyotaiCd = "1";
			if(storeBrandCode != null && "01".equals(storeBrandCode)) {
				gyotaiCd = "1";
			}
			else if(storeBrandCode != null && ("03".equals(storeBrandCode) || "12".equals(storeBrandCode) || "21".equals(storeBrandCode))) {
				gyotaiCd = "3";
			}
			MemberName MemberName = memberNameService.execute(memberUrl,custCd,gyotaiCd);
			if(MemberName != null) {
				String firstName = MemberName.getFirstName();
				String lastName = MemberName.getLastName();
				if(firstName != null && lastName != null) {
					String custNm = lastName + " " + firstName;
					order.setCustNm(custNm);
				}
				else if(firstName == null && lastName != null) {
					String custNm = lastName;
					order.setCustNm(custNm);
				}
				else if(firstName != null && lastName == null) {
					String custNm = firstName;
					order.setCustNm(custNm);
				}
				String firstNameKana = MemberName.getFirstNameKana();
				String lastNameKana = MemberName.getLastNameKana();
				if(firstNameKana != null && lastNameKana != null) {
					String custKanaNm = lastNameKana + " " + firstNameKana;
					order.setCustKanaNm(custKanaNm);
				}
				else if(firstNameKana == null && lastNameKana != null) {
					String custKanaNm = lastNameKana;
					order.setCustKanaNm(custKanaNm);
				}
				else if(firstName != null && lastNameKana == null) {
					String custKanaNm = firstNameKana;
					order.setCustKanaNm(custKanaNm);
				}
			}
			
			//名簿納期
			Date custDeliverDate = order.getCustDeliverDate();
			if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
				String custDeliverDateFormat = sdf.format(custDeliverDate);
				Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
				order.setCustDeliverDate(custDeliverDateParse);
			}
			//お渡し日
			Date custShopDeliveryDate = order.getCustShopDeliveryDate();
			if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
				String custShopDeliveryDateFormat = sdf.format(custShopDeliveryDate);
				Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
				order.setCustShopDeliveryDate(custShopDeliveryDateParse);
			}
			//出荷日
			Date shippingDate = order.getShippingDate();
			if(shippingDate != null && !"".equals(shippingDate.toString())) {
				String shippingDateFormat = sdf.format(shippingDate);
				Date shippingDateParse = java.sql.Date.valueOf(shippingDateFormat);
				order.setShippingDate(shippingDateParse);
			}
			//積載日
			Date loadingDate = order.getLoadingDate();
			if(loadingDate != null && !"".equals(loadingDate.toString())) {
				String loadingDateFormat = sdf.format(loadingDate);
				Date loadingDateParse = java.sql.Date.valueOf(loadingDateFormat);
				order.setLoadingDate(loadingDateParse);
			}
			//注文承り日
			Date productOrderdDate = order.getProductOrderdDate();
			if(productOrderdDate != null && !"".equals(productOrderdDate.toString())) {
				String productOrderdDateFormat = sdf.format(productOrderdDate);
				Date productOrderdDateParse = java.sql.Date.valueOf(productOrderdDateFormat);
				order.setProductOrderdDate(productOrderdDateParse);
			}
			
			Measuring measuring = measuringService.selectByPrimaryKey(orderId);
			if("02".equals(authority)) {
				String send2factoryStatus = order.getSend2factoryStatus();
				if("4".equals(send2factoryStatus)) {
					List<ErrorResult> errorResultList = errorResultService.selectAllErrorResultByOrderId(order.getOrderId());
					if(errorResultList.size() == 1) {
						errorResult = "「" + errorResultList.get(0).getRemark() + "」";
					}else {
						for (int i = 0; i < errorResultList.size(); i++) {
							if(i == errorResultList.size()-1) {
								errorResult = errorResult.concat("「" + errorResultList.get(i).getRemark()+ "」");
							}else {
								errorResult = errorResult.concat("「" + errorResultList.get(i).getRemark()+ "」、");
							}
						}
					}
				}
				model.addAttribute("errorResult", errorResult);
			}
			
			/*
			 * if (measuring == null) { return "redirect:/orderlist/gotoOrderlistError"; }
			 */
			OrderDetailCoHelper orderDetailCoHelper = new OrderDetailCoHelper();
			orderDetailCoHelper.getOptionDataFormat(order,orderFm);
			model.addAttribute("order", order);
			model.addAttribute("orderFm", orderFm);
			model.addAttribute("measuring", measuring);
			model.addAttribute("authority", authority);
			model.addAttribute("userId", userId);
			String orderFlag = "orderLink";
			model.addAttribute("orderFlag", orderFlag);
			//本店オーダー 、商品部の場合
			//店舗の場合
			if (order.getMakerFactoryStatus() != null &&
				order.getShopCode() != null && 
				order.getIsCancelled() != null) {
				if (authority.equals(AUTHORITY_01)) {
					//本店の生産開始前の場合、登録画面へ遷移
					if (order.getShopCode().equals(shopCode) && 
							order.getMakerFactoryStatus().equals(MAKER_FACTORY_STATUS_F0) && 
							(order.getSend2factoryStatus().equals(SEND2FACTORY_STATUS0) || order.getSend2factoryStatus().equals(SEND2FACTORY_STATUS4)) &&
							order.getIsCancelled().equals("0")) {
						if(TSC_STATUS_T2.equals(order.getTscStatus()) ||
								TSC_STATUS_T3.equals(order.getTscStatus()) ||
								TSC_STATUS_T4.equals(order.getTscStatus()) ||
								TSC_STATUS_T5.equals(order.getTscStatus())) {
							
							return "forward:/orderCoDetail/orderCoDetail"; 
							
						}else if(TSC_STATUS_T0.equals(order.getTscStatus()) || TSC_STATUS_T1.equals(order.getTscStatus()) || "".equals(order.getTscStatus()) || order.getTscStatus() == null){
							
							return "forward:/orderCo/orderCoUpdate"; 
						}
							
					}
					
				}
				//商品部の場合
				if (authority.equals(AUTHORITY_02)) {
					//会計前の場合、登録画面へ遷移
					if ((order.getTscStatus() == null ||
							order.getTscStatus().equals("") ||
							order.getTscStatus().equals(TSC_STATUS_T0) || 
							order.getTscStatus().equals(TSC_STATUS_T1)) &&
							order.getIsCancelled().equals("0")) {
						return "forward:/orderCo/orderCoUpdate"; 
					}
				}
				//明細画面へ遷移
				return "forward:/orderCoDetail/orderCoDetail";
			}else {
		    	return "redirect:/orderlist/gotoOrderlistError";
			}
			
		}catch (BusinessException e) {
	    		// メッセージリスト
		    	ResultMessages messages = e.getResultMessages();
		    	messages.add(MessageKeys.E021, orderId);
				// エラーメッセージ
		    	model.addAttribute("resultMessages", messages);
		    	// ログを出力
		    	logger.error(messages.toString());
		    	return "redirect:/orderlist/gotoOrderlistError";
	    } catch (ResourceNotFoundException e) {
	    		// メッセージリスト
		    	ResultMessages messages = e.getResultMessages();
		    	messages.add(MessageKeys.E021, orderId);
				// エラーメッセージ
		    	model.addAttribute("resultMessages", messages);
		    	// ログを出力
		    	logger.error(messages.toString());
		    	return "redirect:/orderlist/gotoOrderlistError";
	    }
	}
	
	@RequestMapping(value = "/goToOrderDivert/{orderId}",method =RequestMethod.GET)
	public String goToOrderDivert(@PathVariable(value ="orderId") String orderId,
	                       Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Order order= orderListService.findOrderByPk(orderId);
		Measuring measuring = measuringService.selectByPrimaryKey(orderId);
		//名簿納期
		Date custDeliverDate = order.getCustDeliverDate();
		if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
			String custDeliverDateFormat = sdf.format(custDeliverDate);
			Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
			order.setCustDeliverDate(custDeliverDateParse);
		}
		//お渡し日
		Date custShopDeliveryDate = order.getCustShopDeliveryDate();
		if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
			String custShopDeliveryDateFormat = sdf.format(custShopDeliveryDate);
			Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
			order.setCustShopDeliveryDate(custShopDeliveryDateParse);
		}
		
		//TSCステータス
		order.setTscStatus("");
		
		model.addAttribute("order", order);
		model.addAttribute("measuring", measuring);
		String orderFlag = "orderDivert";
		model.addAttribute("orderFlag", orderFlag);
		return "forward:/order/orderPoUpdate";
	}
	
	@RequestMapping(value = "/goToOrderCoDivert/{orderId}",method =RequestMethod.GET)
	public String goToOrderCoDivert(@PathVariable(value ="orderId") String orderId,
	                       Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Order order= orderListService.findOrderByPk(orderId);
		Measuring measuring = measuringService.selectByPrimaryKey(orderId);
		//名簿納期
		Date custDeliverDate = order.getCustDeliverDate();
		if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
			String custDeliverDateFormat = sdf.format(custDeliverDate);
			Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
			order.setCustDeliverDate(custDeliverDateParse);
		}
		//お渡し日
		Date custShopDeliveryDate = order.getCustShopDeliveryDate();
		if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
			String custShopDeliveryDateFormat = sdf.format(custShopDeliveryDate);
			Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
			order.setCustShopDeliveryDate(custShopDeliveryDateParse);
		}
		
		//TSCステータス
		order.setTscStatus("");
		
		model.addAttribute("order", order);
		model.addAttribute("measuring", measuring);
		String orderFlag = "orderDivert";
		model.addAttribute("orderFlag", orderFlag);
		return "forward:/orderCo/orderCoUpdate";
	}
	
    /**
     * csvファイルをダウンロードする.
     * @param form 画面Form
     * @return
     */
	@RequestMapping(value = "/orderDataCSVOut" , method = RequestMethod.GET)
	public String orderDataCSVOut(@Validated OrderListForm orderListForm,
								  HttpServletRequest request, 
								  HttpServletResponse response,
					              BindingResult result,
					              Model model)throws Exception {
		
		orderListForm.setAuthority(sessionContent.getAuthority());
		orderListForm.setBelongCode(sessionContent.getBelongCode());
		orderListForm.setCategory(sessionContent.getCategory());
		//検索条件bean
		OrderCondition orderCondition = beanMapper.map(orderListForm,OrderCondition.class);
		
		//検索結果list
    	List<Order> orderList = orderListService.findOrderByCondition(orderCondition);

		String authority = orderListForm.getAuthority();
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		if(authority.equals(AUTHORITY_02)) {
		
			//表示項目名を定義する
			HeaderTitleEnum[] headerTitleEnum = HeaderTitleEnum.values();
			String[] title = new String[headerTitleEnum.length];
			DecimalFormat df=new DecimalFormat("0000");
			
			for (int i = 0; i < headerTitleEnum.length; i++) {
				if(i == (headerTitleEnum.length - 1)) {
					title[i] = HeaderTitleEnum.getValue(df.format(i));
				}else {
					title[i] = HeaderTitleEnum.getValue(df.format(i)) + ",";
				}
			}
			
			String[] content = new String[orderList.size()];
			for (int i = 0; i < orderList.size(); i++) {
				Order order = orderList.get(i);
				content[i] = order.toString().replaceAll("\r", "");
			}
			
			try {
				writeByteArrayOutputStream(output, title, content);
//				CsvUtil.createCSVFile(title, content, path, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			
			//表示項目名を定義する
			HeaderTitleMakerUseEnum[] headerTitleMakerUseEnum = HeaderTitleMakerUseEnum.values();
			String[] title = new String[headerTitleMakerUseEnum.length];
			DecimalFormat df=new DecimalFormat("0000");
			
			for (int i = 0; i < headerTitleMakerUseEnum.length; i++) {
				if(i == (headerTitleMakerUseEnum.length - 1)) {
					title[i] = HeaderTitleMakerUseEnum.getValue(df.format(i));
				}else {
					title[i] = HeaderTitleMakerUseEnum.getValue(df.format(i)) + ",";
				}
			}

			String[] content = new String[orderList.size()];
			for (int i = 0; i < orderList.size(); i++) {
				Order order = orderList.get(i);
				OrderMakerUse orderMakerUse = beanMapper.map(order,
						OrderMakerUse.class);
				content[i] = orderMakerUse.toString().replaceAll("\r", "");
			}
			
			try {
				writeByteArrayOutputStream(output, title, content);
//				CsvUtil.createCSVFile(title, content, path, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		//取得時間
		Date dateNow = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateToday = dateFormat.format(dateNow); 
		
		String fileNameDefault = "orderlist_"+dateToday+".csv";
		try {
			response.addHeader("Content-Type", "application/force-download");
			//デフォルトのダウンロードファイル名を設定する
			response.addHeader("Content-Disposition", "attachment; filename=" + new String(fileNameDefault.getBytes("UTF-8"),"ISO8859-1"));
			
			//ByteArrayをbyte配列に変換
			byte[] byteArray = output.toByteArray();
			//byte配列をStringに変換
			String strFromByteArray = new String(byteArray);
			//出力ストリームのエンコード形式を設定します
			response.getOutputStream().write(strFromByteArray.getBytes("Shift_JIS"));
			
			response.setStatus(200);
			logger.info("Download is OK");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.toString());
		}
		
//		//デフォルトのダウンロードファイル名
//		String fileNameDefault = "orderlist_"+simpleDateFormat.format(date) + ".csv";
//        fileName = new String(fileName.getBytes("UTF-8"),"UTF-8");
//        response.setContentType("application/octet-stream");
//        //デフォルトのダウンロードファイル名を設定する
//        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileNameDefault.getBytes("UTF-8"),"ISO8859-1"));
//		
//		//ファイルオブジェクトの作成
//		File file = new File(path+fileName);
//        response.setHeader("Content-Length", String.valueOf(file.length()));
//        //内容を書きこむ
//        OutputStream out = response.getOutputStream();
//        FileInputStream in = new FileInputStream(file);
//        byte[] b = new byte[102400];
//        int n;
//        while((n = in.read(b)) != -1){
//            out.write(b, 0, n);
//        }
//        in.close();
//        out.close();
		
		return null;
	}

    /**
     * 一括承認 
     * @param orderIdArray 
     * @return String　遷移jsp
     */
	@RequestMapping(value = "/gotoConfirm/{orderIdArray}",method = { RequestMethod.POST, RequestMethod.GET }) 
	public String gotoConfirm( @Validated OrderListForm orderListForm, 
							   @PathVariable(value ="orderIdArray") String orderIdArray,
							   Model model) { 
		String authority = sessionContent.getAuthority();
		String[] orderId = orderIdArray.split(",");
		
		if (authority.equals("02")) {
			for(int i = 0; i < orderId.length; i++){
				Order order= orderListService.findOrderByPk(orderId[i]);
				if (order != null) {
					order.setTscStatus("T4");
					order.setUpdatedAt(new Date());
					order.setUpdatedUserId(sessionContent.getUserId());
					orderService.updateOrder(order);
					model.addAttribute("updateFlag", "true");
				}else {
					model.addAttribute("updateFlag", "false");
				}
			}
		}
		if (authority.equals("03")) {
			for(int i = 0; i < orderId.length; i++){
				Order order= orderListService.findOrderByPk(orderId[i]);
				if (order != null) {
					order.setTscStatus("T5");
					order.setScheduleDataTransmitStatus("0");
					order.setUpdatedAt(new Date());
					order.setUpdatedUserId(sessionContent.getUserId());
					orderService.updateOrder(order);
					model.addAttribute("updateFlag", "true");
				}else {
					model.addAttribute("updateFlag", "false");
				}
			}
		}
		return "orderlist/confirmSuccess";

	}
	
	private void writeByteArrayOutputStream(ByteArrayOutputStream output, String[] title, String[] content) throws IOException {
		StringBuffer sbTitle = new StringBuffer();
		for(int i=0;i<title.length;i++) {
			if(i == title.length-1) {
				sbTitle.append(title[i]).append("\r\n");
			}else {
				sbTitle.append(title[i]);
			}
		}
		
		byte[] a = String.valueOf(sbTitle).getBytes();
		output.write(a);
		
		for(int i=0;i<content.length;i++){
			StringBuffer sbBody = new StringBuffer();
			sbBody.append(content[i]).append("\r\n");
			
			byte[] b = String.valueOf(sbBody).getBytes();
			output.write(b);
		}
	}
	
}
