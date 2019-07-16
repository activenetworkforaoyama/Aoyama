package co.jp.aoyama.macchinetta.app.orderlist;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import co.jp.aoyama.macchinetta.app.message.MessageKeys;
import co.jp.aoyama.macchinetta.app.order.enums.HeaderTitleEnum;
import co.jp.aoyama.macchinetta.app.order.enums.HeaderTitleMakerUseEnum;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.OrderCondition;
import co.jp.aoyama.macchinetta.domain.model.OrderMakerUse;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.service.measuring.MeasuringService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;

@Controller
@RequestMapping(value = "/orderlist")
@SessionAttributes(value = {"orderListForm"})
public class OrderListController {
	
	@Inject
	OrderListService orderListService;
	
    @Inject
    SessionContent sessionContent;
    
    @Inject
    MeasuringService measuringService;
	
    @Inject
	OrderService orderService;
    
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
	@RequestMapping(value = "init", method = RequestMethod.GET)
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
		//検索条件bean
		OrderCondition orderCondition = beanMapper.map(orderListForm,OrderCondition.class);
		//検索結果list
    	List<Order> orderList = orderListService.findOrderByCondition(orderCondition);
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
	@RequestMapping(value = "/goToOrderLink/{orderId}",method =RequestMethod.GET) 
	public String goToOrderLink(@PathVariable(value ="orderId") String orderId,
	                            Model model) {
		String authority = sessionContent.getAuthority();
		String shopCode = sessionContent.getBelongCode();
		
		try {
		
			Order order= orderListService.findOrderByPk(orderId);
			Measuring measuring = measuringService.selectByPrimaryKey(orderId);

			if (measuring == null) {
				return "redirect:/orderlist/gotoOrderlistError";
			}

			model.addAttribute("order", order);
			model.addAttribute("measuring", measuring);
			model.addAttribute("authority", authority);
			String orderFlag = "orderLink";
			model.addAttribute("orderFlag", orderFlag);
			//本店オーダー 、商品部の場合
			//店舗の場合
			if (authority.equals(AUTHORITY_01)) {
				//本店の生産開始前の場合、登録画面へ遷移
				if (order.getMakerFactoryStatus() != null && order.getShopCode() != null && order.getIsCancelled() != null) {
					if (order.getShopCode().equals(shopCode) && 
						order.getMakerFactoryStatus().equals(MAKER_FACTORY_STATUS_F0) && 
						order.getIsCancelled().equals("0")) {
						return "forward:/order/orderPoUpdate"; 
					}
				}else {
					return "redirect:/orderlist/gotoOrderlistError";
				}
			}
			//商品部の場合
			if (authority.equals(AUTHORITY_02)) {
				//会計前の場合、登録画面へ遷移
				if (order.getTscStatus() != null && order.getIsCancelled() != null) {
					if (order.getTscStatus().equals(TSC_STATUS_T0) 
						|| order.getTscStatus().equals(TSC_STATUS_T1) 
						|| order.getTscStatus().equals(TSC_STATUS_T2)
						&& order.getIsCancelled().equals("0")) {
						return "forward:/order/orderPoUpdate"; 
					}
				}else {
					return "redirect:/orderlist/gotoOrderlistError";
				}
			}
			//明細画面へ遷移
			return "forward:/orderDetail/orderDetail";
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
		String type = "PO";
		Order order= orderListService.findOrderByPk(orderId);
		Measuring measuring = measuringService.selectByPrimaryKey(orderId);
		String belongCode = sessionContent.getBelongCode();
		String maxOrderId = orderService.selectMaxOrderId(belongCode, type);
		if (maxOrderId == null) {
			orderId = belongCode + "00000001";
		} else {
			long parseLong = Long.parseLong(maxOrderId)+1;
			orderId = String.format("%012d",parseLong);
		}
		order.setOrderId(orderId);
		model.addAttribute("order", order);
		model.addAttribute("measuring", measuring);
		String orderFlag = "orderDivert";
		model.addAttribute("orderFlag", orderFlag);
		return "forward:/order/orderPoUpdate";
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
		
		ServletContext servletContext = request.getSession().getServletContext();
		String path = servletContext.getRealPath("/");
		
		//ダウンロードファイル名を定義する
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		
		String fileName = "orderlist_"+simpleDateFormat.format(date) + ".txt";
		
		List<Order> orderList = orderListForm.getOrderList();
		
		String authority = orderListForm.getAuthority();
		
		if(authority.equals(AUTHORITY_02)) {
		
			//表示項目名を定義する
			HeaderTitleEnum[] headerTitleEnum = HeaderTitleEnum.values();
			String[] title = new String[headerTitleEnum.length];
			DecimalFormat df=new DecimalFormat("0000");
			
			for (int i = 0; i < headerTitleEnum.length; i++) {
				title[i] = "\"" + HeaderTitleEnum.getValue(df.format(i)) + "\"";
			}
			
			String[] content = new String[orderList.size()];
			for (int i = 0; i < orderList.size(); i++) {
				Order order = orderList.get(i);
				content[i] = order.toString();
			}
			
			try {
				CsvUtil.createCSVFile(title, content, path, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			
			//表示項目名を定義する
			HeaderTitleMakerUseEnum[] headerTitleMakerUseEnum = HeaderTitleMakerUseEnum.values();
			String[] title = new String[headerTitleMakerUseEnum.length];
			DecimalFormat df=new DecimalFormat("0000");
			
			for (int i = 0; i < headerTitleMakerUseEnum.length; i++) {
				title[i] = "\"" + HeaderTitleMakerUseEnum.getValue(df.format(i)) + "\"";
			}

			String[] content = new String[orderList.size()];
			for (int i = 0; i < orderList.size(); i++) {
				Order order = orderList.get(i);
				OrderMakerUse orderMakerUse = beanMapper.map(order,
						OrderMakerUse.class);
				content[i] = orderMakerUse.toString();
			}
			
			try {
				CsvUtil.createCSVFile(title, content, path, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		//デフォルトのダウンロードファイル名
		String fileNameDefault = "orderlist_"+simpleDateFormat.format(date) + ".txt";
        fileName = new String(fileName.getBytes("UTF-8"),"UTF-8");
        response.setContentType("application/octet-stream");
        //デフォルトのダウンロードファイル名を設定する
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileNameDefault.getBytes("UTF-8"),"ISO8859-1"));
		
		//ファイルオブジェクトの作成
		File file = new File(path+fileName);
        response.setHeader("Content-Length", String.valueOf(file.length()));
        //内容を書きこむ
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(file);
        byte[] b = new byte[102400];
        int n;
        while((n = in.read(b)) != -1){
            out.write(b, 0, n);
        }
        in.close();
        out.close();
		
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
}
