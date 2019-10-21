package co.jp.aoyama.macchinetta.app.order;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.order.coHelper.CoGiletHelper;
import co.jp.aoyama.macchinetta.app.common.BaseCheckUtil;
import co.jp.aoyama.macchinetta.app.common.CoTypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.coHelper.CoCoatHelper;
import co.jp.aoyama.macchinetta.app.order.coHelper.CoJakcetHelper;
import co.jp.aoyama.macchinetta.app.order.coHelper.CoPants1Helper;
import co.jp.aoyama.macchinetta.app.order.coHelper.CoPants2Helper;
import co.jp.aoyama.macchinetta.app.order.coHelper.CoShirtHelper;
import co.jp.aoyama.macchinetta.app.order.enums.CoProductPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.LogItemClassEnum;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.app.shop.ShopForm;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.Item;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.OptionBranch;
import co.jp.aoyama.macchinetta.domain.model.OptionBranchDetail;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.Shop;
import co.jp.aoyama.macchinetta.domain.model.SizeFigure;
import co.jp.aoyama.macchinetta.domain.model.SizeNumber;
import co.jp.aoyama.macchinetta.domain.model.Stock;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.model.Yield;
import co.jp.aoyama.macchinetta.domain.service.cash.CashService;
import co.jp.aoyama.macchinetta.domain.service.consumption.ConsumptionService;
import co.jp.aoyama.macchinetta.domain.service.measuring.MeasuringService;
import co.jp.aoyama.macchinetta.domain.service.order.AdjustService;
import co.jp.aoyama.macchinetta.domain.service.order.ItemService;
import co.jp.aoyama.macchinetta.domain.service.order.ModelService;
import co.jp.aoyama.macchinetta.domain.service.order.OptionBranchDeailService;
import co.jp.aoyama.macchinetta.domain.service.order.OptionBranchService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.order.SizeFigureService;
import co.jp.aoyama.macchinetta.domain.service.order.SizeNumberService;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;
import co.jp.aoyama.macchinetta.domain.service.shop.ShopService;
import co.jp.aoyama.macchinetta.domain.service.stock.StockService;
import co.jp.aoyama.macchinetta.domain.service.yield.YieldService;

@Controller
@RequestMapping("/orderCo")
@SessionAttributes(value = { "orderCoForm" })
public class OrderCoController {
	private static final Logger logger = LoggerFactory.getLogger(OrderCoController.class);
	@Inject
	SmartValidator smartValidator;
	@Inject
	OptionBranchService optionBranchService;
	@Inject
	OptionBranchDeailService optionBranchDeailService;
	@Inject
	AdjustService adjustService;
	@Inject
	SizeFigureService sizeFigureService;
	@Inject
	SizeNumberService sizeNumberService;
	@Inject
	ShopService shopService;
	@Inject 
	TypeSizeService typeSizeService;
	@Inject
	OrderListService orderListService;
	@Inject
	ItemService itemService;
	@Inject
	ModelService modelService;
	@Inject
	Mapper beanMapper;
	@Inject
	Mapper standardBeanMapper;
	@Inject
	Mapper tuxedoBeanMapper;
	@Inject
	Mapper washableBeanMapper;
	@Inject
	OrderService orderService;
	@Inject
	SessionContent sessionContent;
	@Inject
	MeasuringService measuringService;
	@Inject
	ConsumptionService consumptionService;
	@Inject
	YieldService yieldService;
	@Inject
	StockService stockService;
	@Inject
	CashService cashService;

	CoTypeSizeOptimization coTypeSizeOptimization = new CoTypeSizeOptimization();
	
	OrderCoHelper orderCoHelper = new OrderCoHelper();
	
	CoJakcetHelper coJakcetHelper = new CoJakcetHelper();
	
	CoPants1Helper coPants1Helper = new CoPants1Helper();
	
	CoPants2Helper coPants2Helper = new CoPants2Helper();
	
	CoCoatHelper coCoatHelper = new CoCoatHelper();

	CoGiletHelper coGiletHelper = new CoGiletHelper();
	
	CoShirtHelper coShirtHelper = new CoShirtHelper();

	private static final String CO_TYPE = "CO";

	// 在庫チェックなし
	private static final String IS_NOT_THEORETICAL_STOCKCECK = "0";

	// 在庫チェックあり
	private static final String IS_THEORETICAL_STOCKCECK = "1";

	// TSCステータス 一時保存
	private static final String TSC_STATUST0 = "T0";

	// TSCステータス 取り置き
	private static final String TSC_STATUST1 = "T1";

	// 取り消しフラグ 取り消し
	private static final String IS_CANCELLED = "1";

	// 会計ステータス 会計取消
	private static final String CASH_STATUS02 = "02";

	// 会計ステータス 会計再確認要
	private static final String CASH_STATUS03 = "03";

	// オーダー更新
	private static final String IS_UPDATE1 = "1";

	// 注文削除
	private static final String IS_UPDATE2 = "2";

	// 注文取消
	private static final String IS_UPDATE3 = "3";

	// 注文情報が変更されています。もう一度、オーダー一覧へ戻って最新の注文情報を選んでください。
	private static final String IS_UPDATE6 = "6";

	private static final String JACKET_SUBITEM = "02";

	private static final String PANTS_SUBITEM = "03";

	private static final String GILET_SUBITEM = "04";

	private static final String SHIRT_SUBITEM = "05";

	private static final String COAT_SUBITEM = "06";
	
	private static final String PANTS2_SUBITEM = "07";

	@ModelAttribute(value = "orderCoForm")
	public OrderCoForm setupForm() {
		return new OrderCoForm();
	}

	@RequestMapping("toOrderCoInit")
	public String toOrderCo(Model model) {
		try {
			OrderCoForm orderCoForm = new OrderCoForm();
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(CO_TYPE);
			List<OptionBranch> tuxedoOptionList = optionBranchService.getTuxedoOption(CO_TYPE);
			List<OptionBranch> washableOptionList = optionBranchService.getWashableOption(CO_TYPE);
			List<OptionBranch> productList = optionBranchService.getProduct(CO_TYPE);
			
			// 要尺を取得
			List<Yield> yieldList = yieldService.getYield();
			// 消費税を取得
			int taxRate = consumptionService.getTaxRate(new Date());
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(CO_TYPE);
			
			orderCoHelper.getFigureNumberMap(orderCoForm);
			orderCoHelper.getOptionStandardData(standardOptionList, orderCoForm);
			orderCoHelper.getOptionTuxedoData(tuxedoOptionList, orderCoForm);
			orderCoHelper.getOptionWashableData(washableOptionList, orderCoForm);
			orderCoHelper.getProductDate(productList,orderCoForm);
			orderCoHelper.getItem(itemList, orderCoForm);
			orderCoHelper.getTaxRate(taxRate, orderCoForm);
			orderCoHelper.getYield(yieldList, orderCoForm);
			List<OrderPrice> priceList = orderService.getOrderPriceNotCate(CO_TYPE);
			List<OrderCodePrice> optionBranchPriceList = orderCoHelper.optionBranchPriceData(priceList);
			orderCoForm.setOrderCodePriceList(optionBranchPriceList);
			orderCoForm.setFabricFlag("");
			String orderFlag = "orderCo";
			orderCoForm.setOrderFlag(orderFlag);
			orderCoForm.setStatus("");
			// デフォルト値設定
			orderCoHelper.customerAndProductDefaultValue(orderCoForm,sessionContent);
			coJakcetHelper.jacketDefaultValue(orderCoForm);
			coGiletHelper.giletDefaultValue(orderCoForm);
			coCoatHelper.coatDefaultValue(orderCoForm);

			model.addAttribute("orderCoForm", orderCoForm);
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return "order/orderCoForm";
	}

	@RequestMapping(value = "orderCoUpdate")
	public String toOrderPoUpdate(Model model,HttpServletRequest req) {
		try {
			Order orderReq = (Order) req.getAttribute("order");
			String orderFlag = (String) req.getAttribute("orderFlag");
			String orderId = orderReq.getOrderId();
			Order order= orderListService.findOrderProductByPk(orderId);
			
			OrderCoForm orderCoForm = new OrderCoForm();
			orderCoForm.setAuthority(sessionContent.getAuthority());
			
			// オプションデーターを取得
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(CO_TYPE);
			List<OptionBranch> tuxedoOptionList = optionBranchService.getTuxedoOption(CO_TYPE);
			List<OptionBranch> washableOptionList = optionBranchService.getWashableOption(CO_TYPE);
			List<OptionBranch> productList = optionBranchService.getProduct(CO_TYPE);
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(CO_TYPE);
			// 要尺を取得
			List<Yield> yieldList = yieldService.getYield();
			// 消費税を取得
			int taxRate = consumptionService.getTaxRate(new Date());
			// 素材品番のMapを取得
			List<OrderPrice> priceList = orderService.getOrderPrice(CO_TYPE);

			orderCoHelper.getOptionStandardData(standardOptionList, orderCoForm);
			orderCoHelper.getOptionTuxedoData(tuxedoOptionList, orderCoForm);
			orderCoHelper.getOptionWashableData(washableOptionList, orderCoForm);
			orderCoHelper.getProductDate(productList,orderCoForm);
			orderCoHelper.getItem(itemList, orderCoForm);
			orderCoHelper.getFigureNumberMap(orderCoForm);
			orderCoHelper.getTaxRate(taxRate, orderCoForm);
			orderCoHelper.getYield(yieldList, orderCoForm);
			List<OrderCodePrice> optionBranchPriceData = orderCoHelper.optionBranchPriceData(priceList);
			orderCoForm.setOrderCodePriceList(optionBranchPriceData);
			if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag)) {
				orderCoHelper.setCustomerMessageAndProductOrderLink(order,orderCoForm);
				orderCoHelper.setDbDefaultValue(order,orderCoForm,orderListService,modelService,orderService,orderFlag);
				orderCoForm.setFabricFlag("0");
			}else if("orderDivert".equals(orderFlag)) {
				orderCoHelper.setCustomerMessageAndProductOrderDivert(order,orderCoForm,sessionContent);
				orderCoHelper.setDbDefaultValue(order,orderCoForm,orderListService,modelService,orderService,orderFlag);
				orderCoForm.setFabricFlag("");
			}
			orderCoForm.setOrderFlag(orderFlag);
			orderCoForm.setStatus("");
			model.addAttribute("orderCoForm", orderCoForm);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return "order/orderCoForm";
	}

	@RequestMapping(value = "orderCoBack")
	public String orderPoBack(HttpServletRequest request, OrderCoForm orderCoForm, Model model) {
		orderCoForm.setAuthority(sessionContent.getAuthority());
		String orderFlag = "orderBack";
		orderCoForm.setOrderFlag(orderFlag);
		model.addAttribute("orderFlag", "");
		return "order/orderCoForm";
	}

	/**
	 * 「オーダー確認画面」に遷移する。
	 * 
	 * @param orderCoForm
	 * @param model
	 * @param request
	 * 
	 */
	@RequestMapping(value = "orderCoReconfirm")
	public String toOrderCoReconfirm(HttpServletRequest request,OrderCoForm orderCoForm, final BindingResult result,Model model) {
		orderCoHelper.extractedItem(orderCoForm, result,smartValidator);
		
		if (result.hasErrors()) {
			orderCoForm.setOrderFlag("orderCheck");
			model.addAttribute("orderCoForm",orderCoForm);
			model.addAttribute("orderFlag", "");
			return "order/orderCoForm";
		}
		
		String item = orderCoForm.getProductItem();
		String productCategory = orderCoForm.getProductCategory();
		String threePiece = orderCoForm.getProductIs3Piece();
		String twoPants = orderCoForm.getProductSparePantsClass();
		Map<String, List<Adjust>> adjustByItem = this.getAdjustByItem(orderCoForm);
		// SUITチェック
		if ("01".equals(item)) {
			ResultMessages messages = ResultMessages.error();
			boolean jacketFlag = coJakcetHelper.jacketCheck(messages, orderCoForm, productCategory, item, adjustByItem,
					typeSizeService);
			boolean pantsFlag = coPants1Helper.pantsCheck(messages, orderCoForm, productCategory, item, adjustByItem,
					typeSizeService);
			
			boolean pants2Flag = false;
			if (OptionCodeKeys.TWO_PANTS.equals(twoPants)) {
				    pants2Flag = coPants2Helper.pants2Check(messages, orderCoForm, productCategory, item, adjustByItem,
						typeSizeService);	
			}
	
			boolean giletFlag = false;
			if (OptionCodeKeys.THREE_PIECE.equals(threePiece)) {
				// GILETチェック
				giletFlag = coGiletHelper.giletCheckHelper(messages, orderCoForm, productCategory, item, adjustByItem,
						typeSizeService);
			}
			
			if (!jacketFlag && !pantsFlag && !giletFlag && !pants2Flag) {
			} else {
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm", orderCoForm);
				model.addAttribute("resultMessages", messages);
				return "order/orderCoForm";
			}
		}
		//JACKETチェック
		if("02".equals(item)) {
			ResultMessages messages = ResultMessages.error();
			boolean jacketFlag = coJakcetHelper.jacketCheck(messages,orderCoForm,productCategory,item,adjustByItem,typeSizeService);
			if (jacketFlag) {
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm",orderCoForm);
				model.addAttribute("resultMessages",messages);
				return "order/orderCoForm";
			}
		}
		//PANTSチェック
		if("03".equals(item)) {
		  ResultMessages messages = ResultMessages.error();
		  boolean pantsFlag = coPants1Helper.pantsCheck(messages,orderCoForm,productCategory,item,adjustByItem,typeSizeService);
		  if (pantsFlag) {
			 orderCoForm.setOrderFlag("orderCheck");
			 model.addAttribute("orderCoForm",orderCoForm);
			 model.addAttribute("resultMessages",messages);
			 return "order/orderCoForm";
			}
		}
		// GILETチェック
		if ("04".equals(item)) {
			ResultMessages messages = ResultMessages.error();
			boolean giletFlag = coGiletHelper.giletCheckHelper(messages,orderCoForm,productCategory,item,adjustByItem,typeSizeService);
		
			if (giletFlag) {
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm", orderCoForm);
				model.addAttribute("resultMessages", messages);
				return "order/orderCoForm";
			}
		}
		//SHIRTチェック
		if ("05".equals(orderCoForm.getProductItem())) {

			ResultMessages messages = ResultMessages.error();
			boolean shirtFlag = false;
			List<Adjust> stAdjustList = adjustByItem.get("05");
			List<TypeSizeOptimization> coStTypeSizeOptimization = coShirtHelper.getCoStTypeSizeOptimization(orderCoForm,typeSizeService);
			
			//SHIRTチェック
			shirtFlag = coShirtHelper.shirtCheck(orderCoForm, messages,stAdjustList,coStTypeSizeOptimization);

			// エラーがある場合、注文画面へ遷移
			if (shirtFlag) {
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm", orderCoForm);
				model.addAttribute("resultMessages", messages);
				return "order/orderCoForm";
			}
		}
		//COATチェック
		if("06".equals(item)) {
			ResultMessages messages = ResultMessages.error();
			boolean coatFlag = coCoatHelper.coatCheck(messages,orderCoForm,item,adjustByItem,typeSizeService);
			if(coatFlag) {
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm",orderCoForm);
				model.addAttribute("resultMessages",messages);
		        return "order/orderCoForm";
			}
		}
		return "forward:/orderCoConfirm/orderCoReForm";
	}

	/**
	 * 「オーダー詳細」に遷移する。
	 * 
	 * @param orderCoForm
	 * @param model
	 * 
	 */
	@RequestMapping(value = "orderCoEntry")
	public String orderPoEntry(OrderCoForm orderCoForm, Model model) {
		// 注文ID
		String orderId = orderCoForm.getCoCustomerMessageInfo().getOrderId();
		// 注文を取得
		Order order = orderListService.findOrderByPk(orderId);
		orderCoHelper.dealWithCorrectAgainCo(orderCoForm, order, sessionContent.getUserId());
		ResultMessages resultMessages = null;
		try {
			orderService.updateOrder(order);
		} catch (ResourceNotFoundException re) {
			resultMessages = re.getResultMessages();
			logger.error(re.toString());
		}
		if (resultMessages == null) {
			model.addAttribute("isUpdate", IS_UPDATE1);
		} else {
			model.addAttribute("isUpdate", IS_UPDATE6);
		}

		return "order/orderPoLoginResultForm";
	}

	/**
	 * 生地チェク完了在庫を計算
	 * 
	 * @param orderCoForm
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "stockDecrease", method = RequestMethod.POST)
	public OrderMessage stockDecrease(OrderCoForm orderCoForm) {
		Order order = new Order();

		Measuring measuring = new Measuring();
		
		OrderMessage orderMessage = new OrderMessage();

		String orderIdImage = orderCoForm.getCoCustomerMessageInfo().getOrderId();
		
		String productFabricNo = orderCoForm.getProductFabricNo();
		
		if(BaseCheckUtil.isEmpty(productFabricNo)) {
			orderCoForm.setOrderFindFabric(null);
		}

		String version = null;

		if (orderIdImage == null || "".equals(orderIdImage)) {
			// 注文ID
			String orderId = null;
			// 店舗コード
			String belongCode = sessionContent.getBelongCode();

			String last8digits = orderService.selectOrderIdBySequence();

			orderId = belongCode.concat(last8digits);
			
			// オーダーのデーター → orderCoForm
			orderCoFormToOrder(orderCoForm, order, measuring);

			order.setOrderId(orderId);

			measuring.setOrderId(orderId);

			String stockCheck = stockCheck(order, measuring);

			orderMessage.setOrderId(stockCheck);
			orderMessage.setOrderMsg("");
			orderMessage.setOrderMsgFlag(true);
			return orderMessage;
		} else {
			version = orderCoForm.getVersion();
			Order orderIsExist = orderListService.findOrderByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			String tscStatus = orderIsExist.getTscStatus();
			if("T2".equals(tscStatus)) {
				orderMessage.setOrderId("");
				orderMessage.setOrderMsg("T2ERROR");
				orderMessage.setOrderMsgFlag(false);
			}else if("T3".equals(tscStatus)) {
				orderMessage.setOrderId("");
				orderMessage.setOrderMsg("T3ERROR");
				orderMessage.setOrderMsgFlag(false);
			}else {
				Measuring measuringIsExist = measuringService
						.selectByPrimaryKey(orderCoForm.getCoCustomerMessageInfo().getOrderId());

				// オーダーのデーター → orderCoForm
				orderCoFormToOrder(orderCoForm, order, measuring, orderIsExist, measuringIsExist);

				order.setVersion(Short.parseShort(version));

				String stockCheck = stockCheck(order, orderIsExist, measuring);
				orderMessage.setOrderId(stockCheck);
				orderMessage.setOrderMsg("");
				orderMessage.setOrderMsgFlag(true);
			}
			return orderMessage;
		}

	}

	private String stockCheck(Order order, Measuring measuring) {
		// 商品情報_ITEM(ログ用)
		String item = LogItemClassEnum.getLogItem(order);

		// 生地品番が無しの場合
		if ("".equals(order.getProductFabricNo()) || order.getProductFabricNo() == null) {
			order.setTheoreticalStockCheck(IS_NOT_THEORETICAL_STOCKCECK);
			orderService.deletOrderWithNotVersionAndMeasuring(order,measuring);
		}
		// 生地品番が有りの場合
		else {
			Stock stock = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
			logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫更新前：「注文パターン：" + order.getOrderPattern() + "、注文ID：" + order.getOrderId()
					+ "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫：" + stock.getTheoreticalStock()
					+ "、予約生地量：" + stock.getReservationStock() + "」");
			BigDecimal reservationStock = stock.getReservationStock();
			BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
			stock.setReservationStock(reservationStock.add(theoryFabricUsedMount));
			stock.setUpdatedUserId(sessionContent.getUserId());
			stock.setUpdatedAt(new Date());
			order.setTheoreticalStockCheck(IS_THEORETICAL_STOCKCECK);
			orderService.deleteOrderAndStock(order, stock, measuring);

			Stock stockAfter = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
			logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫更新後：「注文パターン：" + order.getOrderPattern() + "、注文ID：" + order.getOrderId()
					+ "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
					+ stockAfter.getTheoreticalStock() + "、予約生地量：" + stockAfter.getReservationStock() + "」");
		}
		return order.getOrderId();
	}
	
	/**
	 * 在庫を戻る
	 * 
	 * @param order
	 */
	private void stockRecovery(Order order) {
		//商品情報_ITEM(ログ用)
		String item = LogItemClassEnum.getLogItem(order);
		
		if (IS_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
			BigDecimal stockNum = order.getTheoryFabricUsedMount();
			Stock stockDb = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
			logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() 
			+ "、注文ID："+order.getOrderId()  
			+ "、ITEM："+item 
			+ "、生地品番："+order.getProductFabricNo() 
			+ "、理論在庫："+stockDb.getTheoreticalStock() 
			+ "、予約生地量："+stockDb.getReservationStock() + "」");
			BigDecimal reservationStock = stockDb.getReservationStock();
			stockDb.setReservationStock(reservationStock.subtract(stockNum));
			stockDb.setUpdatedUserId(sessionContent.getUserId());
			stockDb.setUpdatedAt(new Date());
			orderService.updateStockByPk(stockDb);
			Stock stockAfter = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
			logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() 
			+ "、注文ID："+order.getOrderId()  
			+ "、ITEM："+item
			+ "、生地品番："+order.getProductFabricNo() 
			+ "、理論在庫："+stockAfter.getTheoreticalStock() 
			+ "、予約生地量："+stockAfter.getReservationStock() + "」");
		}
	}

	/**
	 * 在庫を戻る
	 * 
	 * @param orderCoForm
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "stockFakeRecovery", method = RequestMethod.GET)
	public String stockFakeRecovery(String orderId, String productFabricNo) {
		Order order = orderListService.findOrderByPk(orderId);
		// 在庫チェク成功の場合
		if (IS_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
			if (productFabricNo.equals(order.getProductFabricNo())) {
				BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
				return CoTypeSizeOptimization.numericalToString(theoryFabricUsedMount);
			} else {
				return "0";
			}
		} else {
			return "0";
		}
	}

	/**
	 * 一時保存、取り置き、自動保存
	 * 
	 * @param orderCoForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "orderCoTemporarySave", method = RequestMethod.POST)
	public OrderMessage orderPoTemporarySave(OrderCoForm orderCoForm, Model model) {
		Order order = new Order();

		Measuring measuring = new Measuring();

		OrderMessage orderMessage = new OrderMessage();
		
		String productFabricNo = orderCoForm.getProductFabricNo();
		
		if(BaseCheckUtil.isEmpty(productFabricNo)) {
			orderCoForm.setOrderFindFabric(null);
		}

		String orderIdImage = orderCoForm.getCoCustomerMessageInfo().getOrderId();

		if (orderIdImage == null || "".equals(orderIdImage)) {
			// 注文ID
			String orderId = null;
			// 店舗コード
			String belongCode = sessionContent.getBelongCode();

			String last8digits = orderService.selectOrderIdBySequence();

			orderId = belongCode.concat(last8digits);

			// オーダーのデーター → orderCoForm
			orderCoFormToOrder(orderCoForm, order, measuring);

			order.setOrderId(orderId);

			measuring.setOrderId(orderId);

			orderMessage.setOrderId(orderId);
			orderMessage.setOrderMsg("");
			orderMessage.setOrderMsgFlag(true);

		} else {
			Order orderIsExist = orderListService.findOrderByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			String tscStatus = orderIsExist.getTscStatus();
			if ("T2".equals(tscStatus)) {
				orderMessage.setOrderId("");
				orderMessage.setOrderMsg("T2ERROR");
				orderMessage.setOrderMsgFlag(false);
			} else if ("T3".equals(tscStatus)) {
				orderMessage.setOrderId("");
				orderMessage.setOrderMsg("T3ERROR");
				orderMessage.setOrderMsgFlag(false);
			} else {
				Measuring measuringIsExist = measuringService
						.selectByPrimaryKey(orderCoForm.getCoCustomerMessageInfo().getOrderId());

				// オーダーのデーター → orderCoForm
				orderCoFormToOrder(orderCoForm, order, measuring, orderIsExist, measuringIsExist);

				order.setVersion(orderIsExist.getVersion());
				orderMessage.setOrderId("true");
				orderMessage.setOrderMsg("");
				orderMessage.setOrderMsgFlag(true);
			}
		}

		Boolean orderMsgFlag = orderMessage.getOrderMsgFlag();

		if (orderMsgFlag) {
			String saveFlag = orderCoForm.getSaveFlag();
			// 保存flag 1：自動保存
			if ("1".equals(saveFlag) || "".equals(saveFlag) || saveFlag == null) {
				orderService.deletOrderWithNotVersionAndMeasuring(order, measuring);
			} else {
				orderService.deletOrderisExistence(order, measuring);
			}
		} else {

		}
		return orderMessage;
	}

	public void orderCoFormToOrder(OrderCoForm orderCoForm, Order order, Measuring measuring) {
		// 商品情報_ITEM
		String productItem = orderCoForm.getProductItem();
		// 商品情報_３Piece
		String productIs3Piece = orderCoForm.getProductIs3Piece();
		// 商品情報_スペアパンツ
		String productSparePantsClass = orderCoForm.getProductSparePantsClass();
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";

		// orderCoFormの対象とorderの対応フィールドのマッピング
		standardBeanMapper.map(orderCoForm.getCoCustomerMessageInfo(), order);
		standardBeanMapper.map(orderCoForm, order);
		orderCoHelper.measuringMapping(orderCoForm, measuring, sessionContent.getUserId());
		orderCoHelper.setProductItemDisplayCode(orderCoForm, order);
		orderCoHelper.orderMappingLogOn(orderCoForm, order, sessionContent);
		measuring.setCreatedUserId(sessionContent.getUserId());
		measuring.setCreatedAt(new Date());
		String saveFlag = orderCoForm.getSaveFlag();
		if ("0".equals(saveFlag)||"".equals(saveFlag)||saveFlag == null) {
			order.setTscStatus(orderCoForm.getStatus());
			// 保存flag 1：自動保存
			// ステータスなし→「一時保存」、「一時保存」→「一時保存」、「取り置き」→「取り置き」
		} 
		else if ("1".equals(saveFlag)||"2".equals(saveFlag)) {
			String tscStatus = orderCoForm.getStatus();
			if ("".equals(tscStatus) || tscStatus == null) {
				order.setTscStatus(TSC_STATUST0);
			} else {
				order.setTscStatus(tscStatus);
			}
		}

		// 標準の場合
		if ("9000101".equals(orderCoForm.getProductCategory())) {
			// SUITの場合、itemCodeは"01"
			if ("01".equals(productItem)) {
				// JACKETについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionJacketStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				orderCoHelper.aboutJacketCheckBoxInDbOnlyCode(orderCoForm, order);

				// PANTSについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionPantsStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				orderCoHelper.aboutPantsCheckBoxInDbOnlyCode(orderCoForm, order);

				// ３Pieceは有り、スペアパンツは有りの場合
				if (productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionGiletStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					orderCoHelper.aboutGiletCheckBoxInDbOnlyCode(orderCoForm, order);
					
					// 2PANTSについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionPants2StandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					orderCoHelper.aboutPants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは有り、スペアパンツは無しの場合
				else if (productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionGiletStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					orderCoHelper.aboutGiletCheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは無し、スペアパンツは有りの場合
				else if (productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// 2PANTSについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionPants2StandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					orderCoHelper.aboutPants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
			}
			// JACKETの場合、itemCodeは"02"
			else if ("02".equals(productItem)) {
				// JACKETについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionJacketStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				orderCoHelper.aboutJacketCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// PANTSの場合、itemCodeは"03"
			else if ("03".equals(productItem)) {
				// PANTSについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionPantsStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				orderCoHelper.aboutPantsCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// GILETの場合、itemCodeは"04"
			else if ("04".equals(productItem)) {
				// GILETについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionGiletStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
				orderCoHelper.aboutGiletCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// SHIRTの場合、itemCodeは"05"
			else if ("05".equals(productItem)) {
				standardBeanMapper.map(orderCoForm.getCoOptionShirtStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustShirtStandardInfo(), order);
			}
			// COATの場合、itemCodeは"06"
			else if ("06".equals(productItem)) {
				standardBeanMapper.map(orderCoForm.getCoOptionCoatStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustCoatStandardInfo(), order);
			}
		}

		// タキシードの場合
		if ("9000102".equals(orderCoForm.getProductCategory())) {
			// SUITの場合、itemCodeは"01"
			if ("01".equals(productItem)) {
				// JACKETについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionJacketTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				// JACKETのグループ項目名とコード
				orderCoHelper.aboutTuxedoJacketCheckBoxInDbOnlyCode(orderCoForm, order);

				// PANTSについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionPantsTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				// PANTSのグループ項目名とコード
				orderCoHelper.aboutTuxedoPantsCheckBoxInDbOnlyCode(orderCoForm, order);

				// ３Pieceは有り、スペアパンツは有りの場合
				if (productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionGiletTuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					// GILETのグループ項目名とコード
					orderCoHelper.aboutTuxedoGiletCheckBoxInDbOnlyCode(orderCoForm, order);

					// 2PANTSについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionPants2TuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					// 2PANTSのグループ項目名とコード
					orderCoHelper.aboutTuxedoPants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは有り、スペアパンツは無しの場合
				else if (productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionGiletTuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					// GILETのグループ項目名とコード
					orderCoHelper.aboutTuxedoGiletCheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは無し、スペアパンツは有りの場合
				else if (productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// 2PANTSについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionPants2TuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					// 2PANTSのグループ項目名とコード
					orderCoHelper.aboutTuxedoPants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
			}
			// JACKETの場合、itemCodeは"02"
			else if ("02".equals(productItem)) {
				// JACKETについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionJacketTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				// JACKETのグループ項目名とコード
				orderCoHelper.aboutTuxedoJacketCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// PANTSの場合、itemCodeは"03"
			else if ("03".equals(productItem)) {
				// PANTSについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionPantsTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				// PANTSのグループ項目名とコード
				orderCoHelper.aboutTuxedoPantsCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// GILETの場合、itemCodeは"04"
			else if ("04".equals(productItem)) {
				// GILETについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionGiletTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
				// GILETのグループ項目名とコード
				orderCoHelper.aboutTuxedoGiletCheckBoxInDbOnlyCode(orderCoForm, order);
			}
		}

		// ウォッシャブルの場合
		if ("9000103".equals(orderCoForm.getProductCategory())) {

			// SUITの場合、itemCodeは"01"
			if ("01".equals(productItem)) {
				// JACKETについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionJacketWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				// JACKETのグループ項目名とコード
				orderCoHelper.aboutWashableJacketCheckBoxInDbOnlyCode(orderCoForm, order);

				// PANTSについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionPantsWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				// PANTSのグループ項目名とコード
				orderCoHelper.aboutWashablePantsCheckBoxInDbOnlyCode(orderCoForm, order);

				// ３Pieceは有り、スペアパンツは有りの場合
				if (productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionGiletWashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					// GILETのグループ項目名とコード
					orderCoHelper.aboutWashableGiletCheckBoxInDbOnlyCode(orderCoForm, order);

					// 2PANTSについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionPants2WashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					// 2PANTSのグループ項目名とコード
					orderCoHelper.aboutWashablePants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは有り、スペアパンツは無しの場合
				else if (productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionGiletWashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					// GILETのグループ項目名とコード
					orderCoHelper.aboutWashableGiletCheckBoxInDbOnlyCode(orderCoForm, order);

				}
				// ３Pieceは無し、スペアパンツは有りの場合
				else if (productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// 2PANTSについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionPants2WashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					// 2PANTSのグループ項目名とコード
					orderCoHelper.aboutWashablePants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
			}
			// JACKETの場合、itemCodeは"02"
			else if ("02".equals(productItem)) {
				// JACKETについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionJacketWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				// JACKETのグループ項目名とコード
				orderCoHelper.aboutWashableJacketCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// PANTSの場合、itemCodeは"03"
			else if ("03".equals(productItem)) {
				// PANTSについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionPantsWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				// PANTSのグループ項目名とコード
				orderCoHelper.aboutWashablePantsCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// GILETの場合、itemCodeは"04"
			else if ("04".equals(productItem)) {
				// GILETについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionGiletWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
				// GILETのグループ項目名とコード
				orderCoHelper.aboutWashableGiletCheckBoxInDbOnlyCode(orderCoForm, order);
			}
		}
	}

	/**
	 * オーダーのデーター → orderCoForm
	 * 
	 * @param orderCoForm
	 * @param order
	 * @param measuring
	 * @param orderIsExist
	 * @throws ParseException
	 */
	private void orderCoFormToOrder(OrderCoForm orderCoForm, Order order, Measuring measuring, Order orderIsExist,
			Measuring measuringIsExist) {

		// 商品情報_ITEM
		String productItem = orderCoForm.getProductItem();
		// 商品情報_３Piece
		String productIs3Piece = orderCoForm.getProductIs3Piece();
		// 商品情報_スペアパンツ
		String productSparePantsClass = orderCoForm.getProductSparePantsClass();
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";

		// orderCoFormの対象とorderの対応フィールドのマッピング
		standardBeanMapper.map(orderCoForm.getCoCustomerMessageInfo(), order);
		standardBeanMapper.map(orderCoForm, order);
		orderCoHelper.measuringMapping(orderCoForm, measuring, sessionContent.getUserId());
		// 標準の場合
		if ("9000101".equals(orderCoForm.getProductCategory())) {
			// SUITの場合、itemCodeは"01"
			if ("01".equals(productItem)) {
				// JACKETについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionJacketStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				orderCoHelper.aboutJacketCheckBoxInDbOnlyCode(orderCoForm, order);

				// PANTSについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionPantsStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				orderCoHelper.aboutPantsCheckBoxInDbOnlyCode(orderCoForm, order);

				// ３Pieceは有り、スペアパンツは有りの場合
				if (productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionGiletStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					orderCoHelper.aboutGiletCheckBoxInDbOnlyCode(orderCoForm, order);

					// 2PANTSについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionPants2StandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					orderCoHelper.aboutPants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは有り、スペアパンツは無しの場合
				else if (productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionGiletStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					orderCoHelper.aboutGiletCheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは無し、スペアパンツは有りの場合
				else if (productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// 2PANTSについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionPants2StandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					orderCoHelper.aboutPants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
			}
			// JACKETの場合、itemCodeは"02"
			else if ("02".equals(productItem)) {
				// JACKETについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionJacketStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				orderCoHelper.aboutJacketCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// PANTSの場合、itemCodeは"03"
			else if ("03".equals(productItem)) {
				// PANTSについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionPantsStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				orderCoHelper.aboutPantsCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// GILETの場合、itemCodeは"04"
			else if ("04".equals(productItem)) {
				// GILETについてのマピンッグ
				standardBeanMapper.map(orderCoForm.getCoOptionGiletStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
				orderCoHelper.aboutGiletCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// SHIRTの場合、itemCodeは"05"
			else if ("05".equals(productItem)) {
				standardBeanMapper.map(orderCoForm.getCoOptionShirtStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustShirtStandardInfo(), order);
			}
			// COATの場合、itemCodeは"06"
			else if ("06".equals(productItem)) {
				standardBeanMapper.map(orderCoForm.getCoOptionCoatStandardInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustCoatStandardInfo(), order);
			}
		}

		// タキシードの場合
		if ("9000102".equals(orderCoForm.getProductCategory())) {
			// SUITの場合、itemCodeは"01"
			if ("01".equals(productItem)) {
				// JACKETについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionJacketTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				// JACKETのグループ項目名とコード
				orderCoHelper.aboutTuxedoJacketCheckBoxInDbOnlyCode(orderCoForm, order);

				// PANTSについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionPantsTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				// PANTSのグループ項目名とコード
				orderCoHelper.aboutTuxedoPantsCheckBoxInDbOnlyCode(orderCoForm, order);

				// ３Pieceは有り、スペアパンツは有りの場合
				if (productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionGiletTuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					// GILETのグループ項目名とコード
					orderCoHelper.aboutTuxedoGiletCheckBoxInDbOnlyCode(orderCoForm, order);

					// 2PANTSについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionPants2TuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					// 2PANTSのグループ項目名とコード
					orderCoHelper.aboutTuxedoPants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは有り、スペアパンツは無しの場合
				else if (productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionGiletTuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					// GILETのグループ項目名とコード
					orderCoHelper.aboutTuxedoGiletCheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは無し、スペアパンツは有りの場合
				else if (productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// 2PANTSについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionPants2TuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					// 2PANTSのグループ項目名とコード
					orderCoHelper.aboutTuxedoPants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
			}
			// JACKETの場合、itemCodeは"02"
			else if ("02".equals(productItem)) {
				// JACKETについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionJacketTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				// JACKETのグループ項目名とコード
				orderCoHelper.aboutTuxedoJacketCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// PANTSの場合、itemCodeは"03"
			else if ("03".equals(productItem)) {
				// PANTSについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionPantsTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				// PANTSのグループ項目名とコード
				orderCoHelper.aboutTuxedoPantsCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// GILETの場合、itemCodeは"04"
			else if ("04".equals(productItem)) {
				// GILETについてのマピンッグ
				tuxedoBeanMapper.map(orderCoForm.getCoOptionGiletTuxedoInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
				// GILETのグループ項目名とコード
				orderCoHelper.aboutTuxedoGiletCheckBoxInDbOnlyCode(orderCoForm, order);
			}
		}

		// ウォッシャブルの場合
		if ("9000103".equals(orderCoForm.getProductCategory())) {

			// SUITの場合、itemCodeは"01"
			if ("01".equals(productItem)) {
				// JACKETについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionJacketWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				// JACKETのグループ項目名とコード
				orderCoHelper.aboutWashableJacketCheckBoxInDbOnlyCode(orderCoForm, order);

				// PANTSについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionPantsWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				// PANTSのグループ項目名とコード
				orderCoHelper.aboutWashablePantsCheckBoxInDbOnlyCode(orderCoForm, order);

				// ３Pieceは有り、スペアパンツは有りの場合
				if (productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionGiletWashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					// GILETのグループ項目名とコード
					orderCoHelper.aboutWashableGiletCheckBoxInDbOnlyCode(orderCoForm, order);

					// 2PANTSについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionPants2WashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					// 2PANTSのグループ項目名とコード
					orderCoHelper.aboutWashablePants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
				// ３Pieceは有り、スペアパンツは無しの場合
				else if (productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionGiletWashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					// GILETのグループ項目名とコード
					orderCoHelper.aboutWashableGiletCheckBoxInDbOnlyCode(orderCoForm, order);

				}
				// ３Pieceは無し、スペアパンツは有りの場合
				else if (productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// 2PANTSについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionPants2WashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
					// 2PANTSのグループ項目名とコード
					orderCoHelper.aboutWashablePants2CheckBoxInDbOnlyCode(orderCoForm, order);
				}
			}
			// JACKETの場合、itemCodeは"02"
			else if ("02".equals(productItem)) {
				// JACKETについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionJacketWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
				// JACKETのグループ項目名とコード
				orderCoHelper.aboutWashableJacketCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// PANTSの場合、itemCodeは"03"
			else if ("03".equals(productItem)) {
				// PANTSについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionPantsWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
				// PANTSのグループ項目名とコード
				orderCoHelper.aboutWashablePantsCheckBoxInDbOnlyCode(orderCoForm, order);
			}
			// GILETの場合、itemCodeは"04"
			else if ("04".equals(productItem)) {
				// GILETについてのマピンッグ
				washableBeanMapper.map(orderCoForm.getCoOptionGiletWashableInfo(), order);
				standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
				// GILETのグループ項目名とコード
				orderCoHelper.aboutWashableGiletCheckBoxInDbOnlyCode(orderCoForm, order);
			}
		}
		
		orderCoHelper.setProductItemDisplayCode(orderCoForm, order);
		orderCoHelper.orderMappingLogOn(orderCoForm, order, sessionContent, orderIsExist);
		measuring.setCreatedAt(measuringIsExist.getCreatedAt());
		measuring.setCreatedUserId(measuringIsExist.getUpdatedUserId());

		String saveFlag = orderCoForm.getSaveFlag();
		if ("0".equals(saveFlag)||"".equals(saveFlag)||saveFlag == null) {
			order.setTscStatus(orderCoForm.getStatus());
			// 保存flag 1：自動保存
			// ステータスなし→「一時保存」、「一時保存」→「一時保存」、「取り置き」→「取り置き」
		} else if ("1".equals(saveFlag)||"2".equals(saveFlag)) {
			String tscStatus = orderIsExist.getTscStatus();
			if ("".equals(tscStatus) || tscStatus == null) {
				order.setTscStatus(TSC_STATUST0);
			} else {
				order.setTscStatus(tscStatus);
			}
		}

	}

	/**
	 * 理論在庫チェック、在庫戻る
	 * 
	 * @param orderCoForm
	 * @param order
	 * @param measuring
	 */
	private String stockCheck(Order order, Order orderIsExist, Measuring measuring) throws ResourceNotFoundException {

		// 商品情報_ITEM(ログ用)
		String item = LogItemClassEnum.getLogItem(order);

		// 在庫を戻る
		// stockRecovery(orderIsExist);

		// 理論在庫チェック値を取得
		String isCheck = orderIsExist.getTheoreticalStockCheck();
		Short version = orderIsExist.getVersion();
		if (version == null) {
			version = 0;
		}
		order.setVersion(version);
		// 理論在庫チェック値が0の場合
		if (IS_NOT_THEORETICAL_STOCKCECK.equals(isCheck)) {
			// 生地品番が無しの場合
			if ("".equals(order.getProductFabricNo()) || order.getProductFabricNo() == null) {
				order.setTheoreticalStockCheck(IS_NOT_THEORETICAL_STOCKCECK);
				orderService.deletOrderWithNotVersionAndMeasuring(order, measuring);
			}
			// 生地品番が有りの場合
			else {
				orderService.deleteOrderAndStock(order, measuring, orderIsExist, item, sessionContent.getUserId());

				Stock stockAfter = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
				logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫更新後：「注文パターン：" + order.getOrderPattern() + "、注文ID："
						+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
						+ stockAfter.getTheoreticalStock() + "、予約生地量：" + stockAfter.getReservationStock() + "」");
			}
			// 理論在庫チェック値が１の場合
		} else if (IS_THEORETICAL_STOCKCECK.equals(isCheck)) {
			// 生地品番が無しの場合
			if ("".equals(order.getProductFabricNo()) || order.getProductFabricNo() == null) {
				order.setTheoreticalStockCheck(IS_NOT_THEORETICAL_STOCKCECK);
				orderService.deletOrderWithNotVersionAndStock(order, orderIsExist, item, sessionContent.getUserId(),
						measuring);
			}
			// 生地品番が有りの場合
			else {
				orderService.deleteOrderAndStock(order, measuring, orderIsExist, item, sessionContent.getUserId());

				Stock stockAfter = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
				logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫更新後：「注文パターン：" + order.getOrderPattern() + "、注文ID："
						+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
						+ stockAfter.getTheoreticalStock() + "、予約生地量：" + stockAfter.getReservationStock() + "」");
			}
		}
		return "true";

	}

	/**
	 * 物理削除した「オーダー一覧」へ遷移する。
	 * 
	 * @param orderId
	 * 
	 */
	@RequestMapping(value = "/physicalDelete", method = RequestMethod.GET)
	public String physicalDelete(String orderId, String version, Model model) {
		// 注文IDによって 注文を取得
		Order order = orderListService.findOrderByPk(orderId);

		// 商品情報_ITEM(ログ用)
		String item = LogItemClassEnum.getLogItem(order);

		String versionDb = String.valueOf(order.getVersion());

		if (version.equals(versionDb)) {
			// tscステータスが無しの場合 注文物理削除
			if ("".equals(order.getTscStatus()) || order.getTscStatus() == null) {
				if (IS_NOT_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
					orderService.deleteMeasuringBothOrder(orderId);
				} else if (IS_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
					// 生地の論理在庫を戻る
					Stock stock = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
					logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() + "、注文ID："
							+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
							+ stock.getTheoreticalStock() + "、予約生地量：" + stock.getReservationStock() + "」");
					BigDecimal reservationStock = stock.getReservationStock();
					BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
					stock.setReservationStock(reservationStock.subtract(theoryFabricUsedMount));
					stock.setUpdatedUserId(sessionContent.getUserId());
					stock.setUpdatedAt(new Date());
					orderService.physicalDeleteOrder(stock, orderId);
					Stock stockAfter = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
					logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() + "、注文ID："
							+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
							+ stockAfter.getTheoreticalStock() + "、予約生地量：" + stockAfter.getReservationStock() + "」");
				}

			} else {
				// tscステータスが「一時保存、取り置き」の場合、物理削除
				if (TSC_STATUST0.equals(order.getTscStatus()) || TSC_STATUST1.equals(order.getTscStatus())) {
					// 理論在庫チェックなしの場合
					if (IS_NOT_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
						orderService.deleteMeasuringBothOrder(orderId);
						// 理論在庫チェックありの場合
					} else if (IS_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
						// 生地の論理在庫を戻る
						Stock stock = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() + "、注文ID："
								+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo()
								+ "、理論在庫：" + stock.getTheoreticalStock() + "、予約生地量：" + stock.getReservationStock()
								+ "」");
						BigDecimal reservationStock = stock.getReservationStock();
						BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
						stock.setReservationStock(reservationStock.subtract(theoryFabricUsedMount));
						stock.setUpdatedUserId(sessionContent.getUserId());
						stock.setUpdatedAt(new Date());
						orderService.physicalDeleteOrder(stock, orderId);
						Stock stockAfter = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() + "、注文ID："
								+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo()
								+ "、理論在庫：" + stockAfter.getTheoreticalStock() + "、予約生地量："
								+ stockAfter.getReservationStock() + "」");
					}
				}
			}
			model.addAttribute("isUpdate", IS_UPDATE2);
		} else {
			model.addAttribute("isUpdate", IS_UPDATE6);
		}

		return "order/orderPoLoginResultForm";
	}

	/**
	 * 論理削除した「オーダー一覧」へ遷移する。
	 * 
	 * @param orderId
	 * 
	 */
	@RequestMapping(value = "/logicalDelete", method = RequestMethod.GET)
	public String logicalDeletion(String orderId, String version, Model model) {

		Order order = orderListService.findOrderByPk(orderId);
		//商品情報_ITEM(ログ用)
		String item = LogItemClassEnum.getLogItem(order);
		String versionDb = String.valueOf(order.getVersion());
		if(version.equals(versionDb)) {
			String cashId = order.getCashId();
			// 会計IDが有りの場合
			if (!"".equals(cashId) && cashId != null) {
				int cashCount = orderService.getSameCash(cashId);
				// 該当会計ID一つの場合
				if (cashCount == 1) {
					// ステータスは「会計取消」を設定する
					Cash cash = cashService.selectByPrimaryKey(order.getCashId());
					cash.setCashStatus(CASH_STATUS02);
					if (!"".equals(order.getProductFabricNo()) || order.getProductFabricNo() != null) {
						// 生地の論理在庫を戻る
						BigDecimal stockNum = order.getTheoryFabricUsedMount();
						Stock stockDb = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+item 
						+ "、生地品番："+order.getProductFabricNo() 
						+ "、理論在庫："+stockDb.getTheoreticalStock() 
						+ "、予約生地量："+stockDb.getReservationStock() + "」");
						stockDb.setTheoreticalStock(stockDb.getTheoreticalStock().add(stockNum));
						stockDb.setUpdatedUserId(sessionContent.getUserId());
						stockDb.setUpdatedAt(new Date());
						order.setIsCancelled(IS_CANCELLED);
						orderService.updateStockByPkAndOrderAndCash(stockDb,order,cash);
						Stock stockAfter = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+item
						+ "、生地品番："+order.getProductFabricNo() 
						+ "、理論在庫："+stockAfter.getTheoreticalStock() 
						+ "、予約生地量："+stockAfter.getReservationStock() + "」");
					}else {
						// 取り消しフラグ:0
						order.setIsCancelled(IS_CANCELLED);
						orderService.updateOrderAndCash(order,cash);
					}
				} else {
					// ステータスは「会計再確認要」を設定する
					Cash cash = cashService.selectByPrimaryKey(order.getCashId());
					cash.setCashStatus(CASH_STATUS03);
					if (!"".equals(order.getProductFabricNo()) || order.getProductFabricNo() != null) {
						// 生地の論理在庫を戻る
						BigDecimal stockNum = order.getTheoryFabricUsedMount();
						Stock stockDb = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+item 
						+ "、生地品番："+order.getProductFabricNo() 
						+ "、理論在庫："+stockDb.getTheoreticalStock() 
						+ "、予約生地量："+stockDb.getReservationStock() + "」");
						stockDb.setTheoreticalStock(stockDb.getTheoreticalStock().add(stockNum));
						stockDb.setUpdatedUserId(sessionContent.getUserId());
						stockDb.setUpdatedAt(new Date());
						order.setIsCancelled(IS_CANCELLED);
						orderService.updateStockByPkAndOrderAndCash(stockDb,order,cash);
						Stock stockAfter = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+item
						+ "、生地品番："+order.getProductFabricNo() 
						+ "、理論在庫："+stockAfter.getTheoreticalStock() 
						+ "、予約生地量："+stockAfter.getReservationStock() + "」");
					}else {
						// 取り消しフラグ:0
						order.setIsCancelled(IS_CANCELLED);
						orderService.updateOrderAndCash(order,cash);
					}
				}
			}else {
				if (!"".equals(order.getProductFabricNo()) || order.getProductFabricNo() != null) {
					// 生地の論理在庫を戻る
					BigDecimal stockNum = order.getTheoryFabricUsedMount();
					Stock stockDb = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
					logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() 
					+ "、注文ID："+order.getOrderId()  
					+ "、ITEM："+item 
					+ "、生地品番："+order.getProductFabricNo() 
					+ "、理論在庫："+stockDb.getTheoreticalStock() 
					+ "、予約生地量："+stockDb.getReservationStock() + "」");
					stockDb.setTheoreticalStock(stockDb.getTheoreticalStock().add(stockNum));
					stockDb.setUpdatedUserId(sessionContent.getUserId());
					stockDb.setUpdatedAt(new Date());
					order.setIsCancelled(IS_CANCELLED);
					orderService.updateStockByPkAndOrder(stockDb,order);
					Stock stockAfter = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
					logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() 
					+ "、注文ID："+order.getOrderId()  
					+ "、ITEM："+item
					+ "、生地品番："+order.getProductFabricNo() 
					+ "、理論在庫："+stockAfter.getTheoreticalStock() 
					+ "、予約生地量："+stockAfter.getReservationStock() + "」");
				}else {
					// 取り消しフラグ:0
					order.setIsCancelled(IS_CANCELLED);
					orderService.updateOrder(order);
				}
			}

			model.addAttribute("isUpdate", IS_UPDATE3);
		}else {
			model.addAttribute("isUpdate", IS_UPDATE6);
		}
		
		return "order/orderPoLoginResultForm";
	}

	/**
	 * 店着日を取得
	 * 
	 * @param storeDelvNormal
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "getShopDeliveryOn", method = RequestMethod.GET)
	public String getShopDeliveryOn(String storeDelv) {
		Date nowDate = new Date();
		String shopDeliveryOn = orderService.getShopDeliveryOn(nowDate, storeDelv);
		return shopDeliveryOn;
	}

	/**
	 * 生地品番とオーダーパターンによって生地の情報を取得
	 * 
	 * @param fabricNo
	 * @param orderPattern
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "findStock", method = RequestMethod.GET)
	public OrderFindFabric findStock(OrderCoForm orderCoForm, String fabricNo, String orderPattern) {
		Boolean checkFlag = true;
		Boolean jkCheckFlag = true;
		Boolean ptCheckFlag = true;
		Boolean pt2CheckFlag = true;
		Boolean glCheckFlag = true;
		
		String itemCode = orderCoForm.getProductItem();
		String category = orderCoForm.getProductCategory();
		String productIs3Piece = orderCoForm.getProductIs3Piece();
		String productSparePantsClass = orderCoForm.getProductSparePantsClass();
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		if(orderFindFabric!=null) {
			orderCoHelper.setGoodsPrice(orderFindFabric,orderCoForm);
			orderCoHelper.findStockModelDoublePrice(orderFindFabric,orderCoForm);
			orderCoHelper.set3Piece2PantsPrice(orderFindFabric, orderCoForm);
			BigDecimal yieldNum = orderCoHelper.getYieldNum(orderCoForm,yieldService);
			BigDecimal theoretical = new BigDecimal(orderFindFabric.getTheoreticalStock());
			BigDecimal reservation = new BigDecimal(orderFindFabric.getReservationStock());
			BigDecimal result = theoretical.subtract(reservation);
			orderFindFabric.setStockResult(String.valueOf(result));
			orderFindFabric.setYieldNum(yieldNum);
			String factoryCode = orderFindFabric.getFactoryCode();
			if ("01".equals(itemCode)) {
				String subItemCode = null;
				if ("9000101".equals(category)) {
					String jacketModel = orderCoForm.getCoOptionJacketStandardInfo().getOjJacketModel();
					subItemCode = "02";
					if("".equals(jacketModel)||jacketModel == null) {
						orderFindFabric.setJkModelCheck(jkCheckFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, jacketModel, subItemCode);
						jkCheckFlag = factories.contains(factoryCode);
						orderFindFabric.setJkModelCheck(jkCheckFlag);
					}
					String pantsModel = orderCoForm.getCoOptionPantsStandardInfo().getOpPantsModel();
					subItemCode = "03";
					if("".equals(pantsModel)||pantsModel==null) {
						orderFindFabric.setPtModelCheck(ptCheckFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, pantsModel, subItemCode);
						ptCheckFlag = factories.contains(factoryCode);
						orderFindFabric.setPtModelCheck(ptCheckFlag);
					}
					if(OptionCodeKeys.THREE_PIECE.equals(productIs3Piece)) {
						String giletModel = orderCoForm.getCoOptionGiletStandardInfo().getOgGiletModel();
						subItemCode = "04";
						if("".equals(giletModel)||giletModel == null) {
							orderFindFabric.setGlModelCheck(glCheckFlag);
						}else {
							String factories = orderService.getFactories(orderPattern, itemCode, giletModel, subItemCode);
							glCheckFlag = factories.contains(factoryCode);
							orderFindFabric.setGlModelCheck(glCheckFlag);
						}
					}else {
						orderFindFabric.setGlModelCheck(glCheckFlag);
					}
					if(OptionCodeKeys.TWO_PANTS.equals(productSparePantsClass)) {
						String pants2Model = orderCoForm.getCoOptionPants2StandardInfo().getOp2PantsModel();
						subItemCode = "07";
						if("".equals(pants2Model)||pants2Model == null) {
							orderFindFabric.setPt2ModelCheck(pt2CheckFlag);
						}else {
							String factories = orderService.getFactories(orderPattern, itemCode, pants2Model, subItemCode);
							pt2CheckFlag = factories.contains(factoryCode);
							orderFindFabric.setPt2ModelCheck(pt2CheckFlag);
						}
					}else {
						orderFindFabric.setPt2ModelCheck(pt2CheckFlag);
					}
				}else if ("9000102".equals(category)) {
					String jacketModel = orderCoForm.getCoOptionJacketTuxedoInfo().getTjJacketModel();
					subItemCode = "02";
					if("".equals(jacketModel)||jacketModel == null) {
						orderFindFabric.setJkModelCheck(jkCheckFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, jacketModel, subItemCode);
						jkCheckFlag = factories.contains(factoryCode);
						orderFindFabric.setJkModelCheck(jkCheckFlag);
					}
					
					String pantsModel = orderCoForm.getCoOptionPantsTuxedoInfo().getTpPantsModel();
					subItemCode = "03";
					if("".equals(pantsModel)||pantsModel==null) {
						orderFindFabric.setPtModelCheck(ptCheckFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, pantsModel, subItemCode);
						ptCheckFlag = factories.contains(factoryCode);
						orderFindFabric.setPtModelCheck(ptCheckFlag);
					}
					if(OptionCodeKeys.THREE_PIECE.equals(productIs3Piece)) {
						String giletModel = orderCoForm.getCoOptionGiletTuxedoInfo().getTgGiletModel();
						subItemCode = "04";
						if("".equals(giletModel)||giletModel == null) {
							orderFindFabric.setGlModelCheck(glCheckFlag);
						}else {
							String factories = orderService.getFactories(orderPattern, itemCode, giletModel, subItemCode);
							glCheckFlag = factories.contains(factoryCode);
							orderFindFabric.setGlModelCheck(glCheckFlag);
						}
					}else {
						orderFindFabric.setGlModelCheck(glCheckFlag);
					}
					if(OptionCodeKeys.TWO_PANTS.equals(productSparePantsClass)) {
						String pants2Model = orderCoForm.getCoOptionPants2TuxedoInfo().getTp2PantsModel();
						subItemCode = "07";
						if("".equals(pants2Model)||pants2Model == null) {
							orderFindFabric.setPt2ModelCheck(pt2CheckFlag);
						}else {
							String factories = orderService.getFactories(orderPattern, itemCode, pants2Model, subItemCode);
							pt2CheckFlag = factories.contains(factoryCode);
							orderFindFabric.setPt2ModelCheck(pt2CheckFlag);
						}
					}else {
						orderFindFabric.setPt2ModelCheck(pt2CheckFlag);
					}
				}else if ("9000103".equals(category)) {
					String jacketModel = orderCoForm.getCoOptionJacketWashableInfo().getWjJacketModel();
					subItemCode = "02";
					if("".equals(jacketModel)||jacketModel == null) {
						orderFindFabric.setJkModelCheck(jkCheckFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, jacketModel, subItemCode);
						jkCheckFlag = factories.contains(factoryCode);
						orderFindFabric.setJkModelCheck(jkCheckFlag);
					}
					
					String pantsModel = orderCoForm.getCoOptionPantsWashableInfo().getWpPantsModel();
					subItemCode = "03";
					if("".equals(pantsModel)||pantsModel==null) {
						orderFindFabric.setPtModelCheck(ptCheckFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, pantsModel, subItemCode);
						ptCheckFlag = factories.contains(factoryCode);
						orderFindFabric.setPtModelCheck(ptCheckFlag);
					}
					
					if(OptionCodeKeys.THREE_PIECE.equals(productIs3Piece)) {
						String giletModel = orderCoForm.getCoOptionGiletWashableInfo().getWgGiletModel();
						subItemCode = "04";
						if("".equals(giletModel)||giletModel == null) {
							orderFindFabric.setGlModelCheck(glCheckFlag);
						}else {
							String factories = orderService.getFactories(orderPattern, itemCode, giletModel, subItemCode);
							glCheckFlag = factories.contains(factoryCode);
							orderFindFabric.setGlModelCheck(glCheckFlag);
						}
					}else {
						orderFindFabric.setGlModelCheck(glCheckFlag);
					}
					if(OptionCodeKeys.TWO_PANTS.equals(productSparePantsClass)) {
						String pants2Model = orderCoForm.getCoOptionPants2WashableInfo().getWp2PantsModel();
						subItemCode = "07";
						if("".equals(pants2Model)||pants2Model == null) {
							orderFindFabric.setPt2ModelCheck(pt2CheckFlag);
						}else {
							String factories = orderService.getFactories(orderPattern, itemCode, pants2Model, subItemCode);
							pt2CheckFlag = factories.contains(factoryCode);
							orderFindFabric.setPt2ModelCheck(pt2CheckFlag);
						}
					}else {
						orderFindFabric.setPt2ModelCheck(pt2CheckFlag);
					}
				}
			} else if ("02".equals(itemCode)) {
				String subItemCode = itemCode;
				if ("9000101".equals(category)) {
					String jacketModel = orderCoForm.getCoOptionJacketStandardInfo().getOjJacketModel();
					if("".equals(jacketModel)||jacketModel == null) {
						orderFindFabric.setJkModelCheck(checkFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, jacketModel, subItemCode);
						checkFlag = factories.contains(factoryCode);
						orderFindFabric.setJkModelCheck(checkFlag);
					}
				} else if ("9000102".equals(category)) {
					String jacketModel = orderCoForm.getCoOptionJacketTuxedoInfo().getTjJacketModel();
					if("".equals(jacketModel)||jacketModel == null) {
						orderFindFabric.setJkModelCheck(checkFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, jacketModel, subItemCode);
						checkFlag = factories.contains(factoryCode);
						orderFindFabric.setJkModelCheck(checkFlag);
					}
				} else if ("9000103".equals(category)) {
					String jacketModel = orderCoForm.getCoOptionJacketWashableInfo().getWjJacketModel();
					if("".equals(jacketModel)||jacketModel == null) {
						orderFindFabric.setJkModelCheck(checkFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, jacketModel, subItemCode);
						checkFlag = factories.contains(factoryCode);
						orderFindFabric.setJkModelCheck(checkFlag);
					}
				}
			} else if ("03".equals(itemCode)) {
				String subItemCode = itemCode;
				if ("9000101".equals(category)) {
					String pantsModel = orderCoForm.getCoOptionPantsStandardInfo().getOpPantsModel();
					if("".equals(pantsModel)||pantsModel==null) {
						orderFindFabric.setPtModelCheck(checkFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, pantsModel, subItemCode);
						checkFlag = factories.contains(factoryCode);
						orderFindFabric.setPtModelCheck(checkFlag);
					}
				} else if ("9000102".equals(category)) {
					String pantsModel = orderCoForm.getCoOptionPantsTuxedoInfo().getTpPantsModel();
					if("".equals(pantsModel)||pantsModel==null) {
						orderFindFabric.setPtModelCheck(checkFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, pantsModel, subItemCode);
						checkFlag = factories.contains(factoryCode);
						orderFindFabric.setPtModelCheck(checkFlag);
					}
				} else if ("9000103".equals(category)) {
					String pantsModel = orderCoForm.getCoOptionPantsWashableInfo().getWpPantsModel();
					if("".equals(pantsModel)||pantsModel==null) {
						orderFindFabric.setPtModelCheck(checkFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, pantsModel, subItemCode);
						checkFlag = factories.contains(factoryCode);
						orderFindFabric.setPtModelCheck(checkFlag);
					}
				}
			} else if ("04".equals(itemCode)) {
				String subItemCode = itemCode;
				if ("9000101".equals(category)) {
					String giletModel = orderCoForm.getCoOptionGiletStandardInfo().getOgGiletModel();
					if("".equals(giletModel)||giletModel == null) {
						orderFindFabric.setGlModelCheck(checkFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, giletModel, subItemCode);
						checkFlag = factories.contains(factoryCode);
						orderFindFabric.setGlModelCheck(checkFlag);
					}
				} else if ("9000102".equals(category)) {
					String giletModel = orderCoForm.getCoOptionGiletTuxedoInfo().getTgGiletModel();
					if("".equals(giletModel)||giletModel == null) {
						orderFindFabric.setGlModelCheck(checkFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, giletModel, subItemCode);
						checkFlag = factories.contains(factoryCode);
						orderFindFabric.setGlModelCheck(checkFlag);
					}
				} else if ("9000103".equals(category)) {
					String giletModel = orderCoForm.getCoOptionGiletWashableInfo().getWgGiletModel();
					if("".equals(giletModel)||giletModel == null) {
						orderFindFabric.setGlModelCheck(checkFlag);
					}else {
						String factories = orderService.getFactories(orderPattern, itemCode, giletModel, subItemCode);
						checkFlag = factories.contains(factoryCode);
						orderFindFabric.setGlModelCheck(checkFlag);
					}
				}
			} else if ("05".equals(itemCode)) {
				String subItemCode = itemCode;
				String shirtModel = orderCoForm.getCoOptionShirtStandardInfo().getOsShirtModel();
				if("".equals(shirtModel)||shirtModel == null) {
					orderFindFabric.setShModelCheck(checkFlag);
				}else {
					String factories = orderService.getFactories(orderPattern, itemCode, shirtModel, subItemCode);
					checkFlag = factories.contains(factoryCode);
					orderFindFabric.setShModelCheck(checkFlag);
				}
			} else if ("06".equals(itemCode)) {
				String subItemCode = itemCode;
				String coatModel = orderCoForm.getCoOptionCoatStandardInfo().getCoatModel();
				if("".equals(coatModel)||coatModel == null) {
					orderFindFabric.setCtModelCheck(checkFlag);
				}else {
					String factories = orderService.getFactories(orderPattern, itemCode, coatModel, subItemCode);
					checkFlag = factories.contains(factoryCode);
					orderFindFabric.setCtModelCheck(checkFlag);
				}
			}

		}
		orderCoForm.setOrderFindFabric(orderFindFabric);
		return orderFindFabric;
	}

	/**
	 * オプション選択肢とオプション選択肢詳細の料金を取得
	 * 
	 * @param orderPattern
	 */
	@ResponseBody
	@RequestMapping(value = "getBranchPrice", method = RequestMethod.GET)
	public List<OrderCodePrice> getBranchPrice(String orderPattern, OrderCoForm orderCoForm) {

		List<OrderPrice> priceList = orderService.getOrderPrice(orderPattern);
		List<OrderCodePrice> optionBranchPriceList = orderCoHelper.optionBranchPriceData(priceList);
		orderCoForm.setOrderCodePriceList(optionBranchPriceList);
		return optionBranchPriceList;
	}

	/**
	 * 標準の素材品番を取得
	 * 
	 * @param itemCode
	 * @param mateChecked
	 * @param orderPattern
	 * @param optionCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "standardMateSelect", method = RequestMethod.GET)
	public Map<String, String> standardMateSelect(String itemCode, String subItemCode, String mateChecked,
			String orderPattern, String optionCode) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getStandardButtons(itemCode, subItemCode,
				mateChecked, orderPattern, optionCode);
		LinkedHashMap<String, String> standardMateMap = orderCoHelper.getButtons(mateList);
		return standardMateMap;
	}

	/**
	 * タキシードの素材品番を取得
	 * 
	 * @param itemCode
	 * @param mateChecked
	 * @param orderPattern
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "tuxdoMateSelect", method = RequestMethod.GET)
	public Map<String, String> tuxdoMateSelect(String itemCode, String subItemCode, String mateChecked,
			String orderPattern) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getTuxedoButtons(itemCode, subItemCode,
				mateChecked, orderPattern);
		LinkedHashMap<String, String> tuxedoMateMap = orderCoHelper.getButtons(mateList);
		return tuxedoMateMap;
	}

	/**
	 * ウォッシャブルの素材品番を取得
	 * 
	 * @param itemCode
	 * @param mateChecked
	 * @param orderPattern
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "washabiMateSelect", method = RequestMethod.GET)
	public Map<String, String> washabiMateSelect(String itemCode, String subItemCode, String mateChecked,
			String orderPattern) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getWashableButtons(itemCode, subItemCode,
				mateChecked, orderPattern);
		LinkedHashMap<String, String> washabiMateMap = orderCoHelper.getButtons(mateList);
		return washabiMateMap;
	}

	/**
	 * 全部の店舗を取得
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "selectAllShop", method = RequestMethod.GET)
	public List<ShopForm> selectAllShop() {
		List<Shop> shopList = shopService.findUnlessShop(sessionContent.getBelongCode());
		List<ShopForm> shopFormList = new ArrayList<ShopForm>();
		for (Shop shop : shopList) {
			ShopForm shopForm = beanMapper.map(shop, ShopForm.class);
			shopFormList.add(shopForm);
		}
		return shopFormList;
	}

	/**
	 * モデルチェク
	 * 
	 * @param modelCode
	 * @param productFabricNo
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkModel", method = RequestMethod.GET)
	public Boolean checkModel(String modelCode, String productFabricNo, String orderPattern, String itemCode,
			String subItemCode) {
		Boolean checkFlag = true;
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderFindFabric.getFactoryCode();
		String factories = orderService.getFactories(orderPattern, itemCode, modelCode, subItemCode);
		checkFlag = factories.contains(factoryCode);
		return checkFlag;
	}

	/**
	 * 
	 * @param modelCode
	 * @param productFabricNo
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getOrderVersion", method = RequestMethod.GET)
	public String getOrderVersion(String orderId) {
		Short version = orderService.findOrderVersion(orderId);
		if (version == null) {
			return "";
		} else {
			String versionStr = String.valueOf(version);
			return versionStr;
		}

	}

	/**
	 * 
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getModel", method = RequestMethod.GET)
	public List<co.jp.aoyama.macchinetta.domain.model.Model> getModel(String orderPattern, String itemCode) {
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getModel(orderPattern, itemCode);
		return modelList;
	}

	/**
	 * 
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getItemModel", method = RequestMethod.GET)
	public List<co.jp.aoyama.macchinetta.domain.model.Model> getItemModel(String orderPattern, String itemCode,
			String subItemCode) {

		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getItemModel(orderPattern, itemCode,
				subItemCode);
		return modelList;
	}

	/**
	 * 
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping(value = "getAdjust", method = RequestMethod.GET)
//	public List<Adjust> getAdjust(String orderPattern,String itemCode) {
//		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getModel(orderPattern,itemCode);
//		return modelList;
//	}

	/**
	 * 
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSizeFigureByItem", method = RequestMethod.GET)
	public List<SizeFigure> getSizeFigureByItem(String orderPattern, String itemCode, String subItemCode,
			String modelCode) {
		List<SizeFigure> figureList = sizeFigureService.getSizeFigureByItem(orderPattern, itemCode, subItemCode,
				modelCode);
		return figureList;
	}

	/**
	 * 
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSizeNumberByItem", method = RequestMethod.GET)
	public List<SizeNumber> getSizeNumberByItem(String orderPattern, String itemCode, String subItemCode,
			String modelCode) {
		List<SizeNumber> NumberList = sizeNumberService.getSizeNumberByItem(orderPattern, itemCode, subItemCode,
				modelCode);
		return NumberList;
	}

	/**
	 * 
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAdjustByItem", method = RequestMethod.GET)
	public List<Adjust> getAdjustByItem(String orderPattern, String itemCode) {
		List<Adjust> adjustList = adjustService.getAdjustByItem(orderPattern, itemCode);
		return adjustList;
	}
	
	/**
	 * 
	 * @return
	 */
	public Map<String,List<Adjust>> getAdjustByItem(OrderCoForm orderCoForm) {
		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		List<Adjust> adjustList = adjustService.getAdjustByItem(orderPattern,itemCode);
		Map<String,List<Adjust>> adjustItemList = orderCoHelper.getAdjustItemList(adjustList);
		return adjustItemList;
	}

	@RequestMapping(value = "/goToJacketOption", method = RequestMethod.GET)
	public @ResponseBody ModelAndView jacketStandardJsp(OrderCoForm orderCoForm, ModelAndView m) {
		String orderFlag = orderCoForm.getOrderFlag();
		String productItem = orderCoForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				JACKET_SUBITEM);
		coJakcetHelper.getJacketModelMap(orderCoForm, modelList);
		
		if("orderCo".equals(orderFlag)) {
			String itemFlag = orderCoForm.getJacketItemFlag();
			if ("0".equals(itemFlag)) {
				coJakcetHelper.jacketDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {

			}
		}else if("orderLink".equals(orderFlag)||"orderDivert".equals(orderFlag)) {
			String itemFlag = orderCoForm.getJacketItemFlag();
			if ("0".equals(itemFlag)) {
				coJakcetHelper.jacketDefaultValue(orderCoForm);
//				coJakcetHelper.jacketDefaultValue(orderCoForm);
//				Order orderJK = orderListService
//						.findOrderJkOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
//				if (orderJK == null) {
//					// フロント釦数
//					String jkFrtBtnCd = orderJK.getJkFrtBtnCd();
//					// ラペルデザイン
//					String jkLapelDesignCd = orderJK.getJkLapelDesignCd();
//					// 裏仕様
//					String jkInnerClothCd = orderJK.getJkInnerClothCd();
//					if ((jkFrtBtnCd == null || "".equals(jkFrtBtnCd))
//							&& (jkLapelDesignCd == null || "".equals(jkLapelDesignCd))
//							&& (jkInnerClothCd == null || "".equals(jkInnerClothCd))) {
//						orderCoHelper.jacketDefaultValue(orderCoForm);
//					} else {
//						orderCoHelper.jacketDefaultValueFromDb(orderCoForm, orderJK);
//					}
//				}
			}
		}
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/orderJsp/optionJacket");
		return m;
	}

	@RequestMapping(value = "/goToPants1Option", method = RequestMethod.GET)
	public @ResponseBody ModelAndView pantsStandardJsp(OrderCoForm orderCoForm, ModelAndView m) {	
		String orderFlag = orderCoForm.getOrderFlag();
		String productItem = orderCoForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				PANTS_SUBITEM);
		orderCoHelper.getPantsModelMap(orderCoForm, modelList);
		if ("orderCo".equals(orderFlag)) {
			String itemFlag = orderCoForm.getPantsItemFlag();
			if ("0".equals(itemFlag)) {
				orderCoHelper.pantsDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {
			}
		}else if("orderLink".equals(orderFlag)||"orderDivert".equals(orderFlag)) {
			String itemFlag = orderCoForm.getPantsItemFlag();
			if ("0".equals(itemFlag)) {
				orderCoHelper.pantsDefaultValue(orderCoForm);
//				orderCoHelper.pantsDefaultValue(orderCoForm);
//				Order orderPt = orderListService.findOrderPtOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
//				//タック
//				String ptTackCd = orderPt.getPtTackCd();
//				//膝裏
//				String ptKneeinnerTypeCd = orderPt.getPtKneeinnerTypeCd();
//				//フロント仕様
//				String ptFrtTypeCd = orderPt.getPtFrtTypeCd();
//				if((ptTackCd == null||"".equals(ptTackCd))&&(ptKneeinnerTypeCd == null||"".equals(ptKneeinnerTypeCd))&&
//				   (ptFrtTypeCd == null||"".equals(ptFrtTypeCd))) {
//					orderCoHelper.pantsDefaultValue(orderCoForm);
//				}else {
//					orderCoHelper.pantsDefaultValueFromDb(orderCoForm,orderPt);
//				}
			}
		}		
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/orderJsp/optionPants1");
		return m;
	}

	@RequestMapping(value = "/goToPants2Option", method = RequestMethod.GET)
	public @ResponseBody ModelAndView pants2StandardJsp(OrderCoForm orderCoForm, ModelAndView m) {
		String orderFlag = orderCoForm.getOrderFlag();
		String productItem = orderCoForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				PANTS2_SUBITEM);
		orderCoHelper.getPants2ModelMap(orderCoForm, modelList);
		if("orderCo".equals(orderFlag)) {
			String itemFlag = orderCoForm.getPants2ItemFlag();
			if ("0".equals(itemFlag)) {
				orderCoHelper.pants2DefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {

			}
		}else if("orderLink".equals(orderFlag)||"orderDivert".equals(orderFlag)) {
			String itemFlag = orderCoForm.getPants2ItemFlag();
			if ("0".equals(itemFlag)) {
				orderCoHelper.pants2DefaultValue(orderCoForm);
//				orderCoHelper.pants2DefaultValue(orderCoForm);
//				Order orderPt2 = orderListService.findOrderPt2OptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
//				//タック
//				String pt2TackCd = orderPt2.getPt2TackCd();
//				//膝裏
//				String pt2KneeinnerTypeCd = orderPt2.getPt2KneeinnerTypeCd();
//				//フロント仕様
//				String pt2FrtTypeCd = orderPt2.getPt2FrtTypeCd();
//				if((pt2TackCd == null||"".equals(pt2TackCd))&&(pt2KneeinnerTypeCd == null||"".equals(pt2KneeinnerTypeCd))&&
//				   (pt2FrtTypeCd == null||"".equals(pt2FrtTypeCd))) {
//					orderCoHelper.pants2DefaultValue(orderCoForm);
//				}else {
//					orderCoHelper.pants2DefaultValueFromDb(orderCoForm,orderPt2);
//				}
			}
		}		
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/orderJsp/optionPants2");
		return m;
	}

	@RequestMapping(value = "/goToGiletOption", method = RequestMethod.GET)
	public @ResponseBody ModelAndView giletStandardJsp(OrderCoForm orderCoForm, ModelAndView m) {
		String orderFlag = orderCoForm.getOrderFlag();
		String productItem = orderCoForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				GILET_SUBITEM);
		coGiletHelper.getGiletModelMap(orderCoForm, modelList);

		if("orderCo".equals(orderFlag)) {
			String itemFlag = orderCoForm.getGiletItemFlag();
			if ("0".equals(itemFlag)) {
				coGiletHelper.giletDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {

			}
		}else if("orderLink".equals(orderFlag)||"orderDivert".equals(orderFlag)) {
			String itemFlag = orderCoForm.getGiletItemFlag();
			if ("0".equals(itemFlag)) {
				coGiletHelper.giletDefaultValue(orderCoForm);
//				orderCoHelper.giletDefaultValue(orderCoForm);
//				Order orderGl = orderListService.findOrderGlOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
//				//フロント釦数
//				String glFrtBtnCd = orderGl.getGlFrtBtnCd();
//				//ラペルデザイン
//				String glLapelDesignCd = orderGl.getGlLapelDesignCd();
//				//裏仕様
//				String glInnerClothCd = orderGl.getGlInnerClothCd();
//				if((glFrtBtnCd == null||"".equals(glFrtBtnCd))&&(glLapelDesignCd == null||"".equals(glLapelDesignCd))&&
//				   (glInnerClothCd == null||"".equals(glInnerClothCd))) {
//				if(orderGl != null) {
//					orderCoHelper.giletDefaultValue(orderCoForm);
//				}else {
//					orderCoHelper.giletDefaultValueFromDb(orderCoForm,orderGl);
//				}
			}
		}
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/orderJsp/optionGilet");
		return m;
	}

	@RequestMapping(value = "/goToShirtOption", method = RequestMethod.GET)
	public @ResponseBody ModelAndView shirtStandardJsp(OrderCoForm orderCoForm, ModelAndView m) {
		String orderFlag = orderCoForm.getOrderFlag();
		String itemFlag = orderCoForm.getShirtItemFlag();
		String productItem = orderCoForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				SHIRT_SUBITEM);
		coShirtHelper.getShirtModelMap(orderCoForm, modelList);
		if("orderCo".equals(orderFlag)) {
			if ("0".equals(itemFlag)) {
				coShirtHelper.shirtDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {

			}
		} else if ("orderLink".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
		if ("0".equals(itemFlag)) {
			coShirtHelper.shirtDefaultValue(orderCoForm);
////		Order orderST = orderListService.findOrderStOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
////		if (!(null == orderST || "".equals(orderST))) {
//////			//クレリック仕様
//////			String stClericCd = orderST.getStClericCd();
//////			//ダブルカフス仕様
//////			String stDblCuffsCd = orderST.getStDblCuffsCd();
//////			//カフスボタン追加
//////			String stCuffsBtnCd = orderST.getStCuffsBtnCd();
//////			
//////			if ((stClericCd == null || "".equals(stClericCd))
//////					&& (stDblCuffsCd == null || "".equals(stDblCuffsCd))
//////					&& (stCuffsBtnCd == null || "".equals(stCuffsBtnCd))) {
//////				orderCoHelper.shirtDefaultValue(orderCoForm);
//////			} else {
////			orderCoHelper.shirtDefaultValueFromDb(orderCoForm.getCoOptionShirtStandardInfo(), orderST);
//////			}
////		} else {
////			orderCoHelper.shirtDefaultValue(orderCoForm);
////		}
	    }
//
//		Order orderST = orderListService
//				.findOrderStOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
//		// 一覧画面から注文画面へ遷移
//		// 受注テーブルにレコードがある、一回目オプション画面をクリック場合、レコード値を設定する
//		if (!(null == orderST) && ("".equals(itemFlag) || "0".equals(itemFlag))) {
//			// orderCoHelper.shirtDefaultValueFromDb(orderCoForm.getCoOptionShirtStandardInfo(),
//			// orderST);
//
//			// 受注テーブルにレコードがなし、初期値を設定
//		} else if (null == orderST) {
//			orderCoHelper.shirtDefaultValue(orderCoForm);
//		}
		}
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/orderJsp/optionShirt");

		return m;

	}

	@RequestMapping(value = "/goToCoatOption", method = RequestMethod.GET)
	public @ResponseBody ModelAndView coatStandardJsp(OrderCoForm orderCoForm, ModelAndView m) {
		String orderFlag = orderCoForm.getOrderFlag();
		String productItem = orderCoForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				COAT_SUBITEM);
		orderCoHelper.getCoatModelMap(orderCoForm, modelList);
		if("orderCo".equals(orderFlag)) {
			String itemFlag = orderCoForm.getCoatItemFlag();
			if ("0".equals(itemFlag)) {
				coCoatHelper.coatDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {

			}
		}else if("orderLink".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
			String itemFlag = orderCoForm.getCoatItemFlag();
			if ("0".equals(itemFlag)) {
				coCoatHelper.coatDefaultValue(orderCoForm);
//				Order orderCt = orderListService.findOrderCtOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
//				//ベント
//				String ctVentCd = orderCt.getCtVentCd();
//				//ラペルデザイン
//				String ctLapelDesignCd = orderCt.getCtLapelDesignCd();
//				//袖仕様
//				String ctSleeveTypeCd = orderCt.getCtSleeveTypeCd();
//				if((ctVentCd == null || "".equals(ctVentCd)) && (ctLapelDesignCd == null || "".equals(ctLapelDesignCd)) &&
//				   (ctSleeveTypeCd == null || "".equals(ctSleeveTypeCd))) {
//					orderCoHelper.coatDefaultValue(orderCoForm);
//				}else {
//					orderCoHelper.coatDefaultValueFromDb(orderCoForm,orderCt);
//				}
			}
		}
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/orderJsp/optionCoat");

		return m;

	}

	@RequestMapping(value = "/saveOptionData", method = RequestMethod.POST)
	@ResponseBody
	public void saveOptionData(OrderCoForm orderCoForm) {

	}

	@ResponseBody
	@RequestMapping(value = "getCoTypeSizeOptimization", method = RequestMethod.GET)
	public List<TypeSizeOptimization> getCoTypeSizeOptimization(String orderPattern, String subItemCode,
			String modelCode, String figure, String number) {
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> poTypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return poTypeSizeOptimization;
	}
	
	@RequestMapping(value = "/orderCoAdjust", method = RequestMethod.GET)
	public @ResponseBody ModelAndView orderCoAdjust(OrderCoForm orderCoForm, ModelAndView m) {
		
		/*
		 * String orderFlag = orderCoForm.getOrderFlag();
		 * if("orderLink".equals(orderFlag)) { String productItem =
		 * orderCoForm.getProductItem(); if("01".equals(productItem)) { Order orderJK =
		 * orderListService.findOrderJkByPk(orderCoForm.getCoCustomerMessageInfo().
		 * getOrderId()); if (!(null == orderJK)) {
		 * orderCoHelper.jacketAdjustFromDb(orderCoForm,orderJK); } Order orderPT =
		 * orderListService.findOrderPtByPk(orderCoForm.getCoCustomerMessageInfo().
		 * getOrderId()); if (!(null == orderPT)) {
		 * orderCoHelper.pantsAdjustFromDb(orderCoForm,orderPT); } String
		 * productIs3Piece = orderCoForm.getProductIs3Piece();
		 * if(OptionCodeKeys.THREE_PIECE.equals(productIs3Piece)) { Order orderGL =
		 * orderListService.findOrderGlByPk(orderCoForm.getCoCustomerMessageInfo().
		 * getOrderId()); if (!(null == orderGL)) {
		 * orderCoHelper.giletAdjustFromDb(orderCoForm, orderGL); } } String
		 * productSparePantsClass = orderCoForm.getProductSparePantsClass();
		 * if(OptionCodeKeys.TWO_PANTS.equals(productSparePantsClass)) { Order orderPT2 =
		 * orderListService.findOrderPt2ByPk(orderCoForm.getCoCustomerMessageInfo().
		 * getOrderId()); if (!(null == orderPT2)) {
		 * orderCoHelper.pants2AdjustFromDb(orderCoForm,orderPT2); } } }else
		 * if("02".equals(productItem)) { Order orderJK =
		 * orderListService.findOrderJkByPk(orderCoForm.getCoCustomerMessageInfo().
		 * getOrderId()); if (!(null == orderJK)) {
		 * orderCoHelper.jacketAdjustFromDb(orderCoForm,orderJK); } }else
		 * if("03".equals(productItem)) { Order orderPT =
		 * orderListService.findOrderPtByPk(orderCoForm.getCoCustomerMessageInfo().
		 * getOrderId()); if (!(null == orderPT)) {
		 * orderCoHelper.pantsAdjustFromDb(orderCoForm,orderPT); } }else
		 * if("04".equals(productItem)) { Order orderGL =
		 * orderListService.findOrderGlByPk(orderCoForm.getCoCustomerMessageInfo().
		 * getOrderId()); if (!(null == orderGL)) {
		 * orderCoHelper.giletAdjustFromDb(orderCoForm, orderGL); } }else
		 * if("05".equals(productItem)) { Order orderST =
		 * orderListService.findOrderStByPk(orderCoForm.getCoCustomerMessageInfo().
		 * getOrderId()); if (!(null == orderST)) {
		 * orderCoHelper.shirtAdjustFromDb(orderCoForm, orderST); } }else
		 * if("06".equals(productItem)) { Order orderCT =
		 * orderListService.findOrderCtByPk(orderCoForm.getCoCustomerMessageInfo().
		 * getOrderId()); if (!(null == orderCT)) {
		 * orderCoHelper.coatAdjustFromDb(orderCoForm, orderCT); } }
		 * 
		 * }
		 */
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/coAdjustJsp/orderCoAdjust");

		return m;

	}

	@RequestMapping(value = "/jacketJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView jacketJsp(OrderCoForm orderCoForm, ModelAndView m) {
		
		String orderFlag = orderCoForm.getOrderFlag();
		if("orderLink".equals(orderFlag)) {	
			Order orderJK = orderListService.findOrderJkByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			if (!(null == orderJK)) {
				coJakcetHelper.jacketAdjustFromDb(orderCoForm,orderJK);
			}
		}
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/coAdjustJsp/jacketAdjust");

		return m;

	}

	@RequestMapping(value = "/pantsJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView pantsJsp(OrderCoForm orderCoForm, ModelAndView m) {
		String orderFlag = orderCoForm.getOrderFlag();
		if("orderLink".equals(orderFlag)) {	
			Order orderPT = orderListService.findOrderPtByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			if (!(null == orderPT)) {
				orderCoHelper.pantsAdjustFromDb(orderCoForm,orderPT);
			}
		}
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/coAdjustJsp/pantsAdjust");

		return m;

	}

	@RequestMapping(value = "/pants2Jsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView pants2Jsp(OrderCoForm orderCoForm, ModelAndView m) {

		String orderFlag = orderCoForm.getOrderFlag();
		if("orderLink".equals(orderFlag)) {	
			Order orderPT2 = orderListService.findOrderPt2ByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			if (!(null == orderPT2)) {
				orderCoHelper.pants2AdjustFromDb(orderCoForm,orderPT2);
			}
		}
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/coAdjustJsp/pants2Adjust");

		return m;

	}

	@RequestMapping(value = "/giletJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView giletJsp(OrderCoForm orderCoForm, ModelAndView m) {

		String orderFlag = orderCoForm.getOrderFlag();
		if("orderLink".equals(orderFlag)) {	
			Order orderGL = orderListService.findOrderGlByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			if (!(null == orderGL)) {
				coGiletHelper.giletAdjustFromDb(orderCoForm, orderGL);
			}
		}
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/coAdjustJsp/giletAdjust");

		return m;

	}

	@RequestMapping(value = "/shirtJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView shirtJsp(OrderCoForm orderCoForm, ModelAndView m) {

		String orderFlag = orderCoForm.getOrderFlag();
		if("orderLink".equals(orderFlag)) {	
			Order orderST = orderListService.findOrderStByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			if (!(null == orderST)) {
				coShirtHelper.shirtAdjustFromDb(orderCoForm, orderST);
			}
		}
		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/coAdjustJsp/shirtAdjust");

		return m;

	}

	@RequestMapping(value = "/coatJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView coatJsp(OrderCoForm orderCoForm, ModelAndView m) {
		
		String orderFlag = orderCoForm.getOrderFlag();
		if("orderLink".equals(orderFlag)) {	
			Order orderCT = orderListService.findOrderCtByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			if (!(null == orderCT)) {
				coCoatHelper.coatAdjustFromDb(orderCoForm, orderCT);
			}
		}

		m.addObject("orderCoForm", orderCoForm);
		m.setViewName("order/coAdjustJsp/coatAdjust");

		return m;

	}
	
	@RequestMapping(value = "/findStockModelDoublePrice", method = RequestMethod.GET)
	@ResponseBody
	public OrderFindFabric findStockModelDoublePrice(String fabricNo,String orderPattern,String doubleCheck,String item,String subItem) {
		
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		
		if(orderFindFabric!=null) {
			orderCoHelper.findStockModelDoublePrice(orderFindFabric,doubleCheck,item,subItem);
		}
		
		return orderFindFabric;
	}
	
	@RequestMapping(value = "/changeJkOptionByStock", method = RequestMethod.GET)
	@ResponseBody
	public OrderFindFabric changeJkOptionByStock(String fabricNo, String orderPattern) {
		
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		
		if(orderFindFabric!=null) {
			
		}
		
		return orderFindFabric;
	}

	@ResponseBody
	@RequestMapping(value = "getOrderPrice", method = RequestMethod.GET)
	public String getOrderPrice(String code, String codeDetail, OrderCoForm orderCoForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderCoForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderDetailKeyCode = orderCodePrice.getOrderDetailKeyCode();
			String orderBranchPrice = orderCodePrice.getOrderBranchPrice();
			String orderBranchDetailPrice = orderCodePrice.getOrderBranchDetailPrice();
			if(orderDetailKeyCode == null) {
				orderDetailKeyCode = "";
			}
			if(orderBranchDetailPrice == null) {
				orderBranchDetailPrice = "0";
			}
			if (orderKeyCode.equals(code) && orderDetailKeyCode.equals(codeDetail)) {
				if (orderBranchPrice.equals("0") && orderBranchDetailPrice.equals("0")) {
					resultPrice = "0";
					break;
				} else {
					BigDecimal branchPrice = new BigDecimal(orderBranchPrice);
					BigDecimal branchDetailPrice = new BigDecimal(orderBranchDetailPrice);
					BigDecimal addPrice = branchPrice.add(branchDetailPrice);
					resultPrice = String.valueOf(addPrice);
					break;
				}
			} else {
				resultPrice = "0";
			}
		}
		return resultPrice;
	}

	@ResponseBody
	@RequestMapping(value = "getOrderNormalPrice", method = RequestMethod.GET)
	public String getOrderNormalPrice(String code, String codeDetail, OrderCoForm orderCoForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderCoForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderBranchPrice = orderCodePrice.getOrderBranchPrice();
			if (orderKeyCode.equals(code)) {
				if (orderBranchPrice.equals("0")) {
					resultPrice = "0";
					break;
				} else {
					BigDecimal branchPrice = new BigDecimal(orderBranchPrice);
					resultPrice = String.valueOf(branchPrice);
					break;
				}
			} else {
				resultPrice = "0";
			}
		}
		return resultPrice;
	}

	@RequestMapping(value = "/jacketAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void jacketAdjustFormDb(OrderCoForm orderCoForm) {
		Order order = orderListService.findOrderJkByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
		coJakcetHelper.jacketAdjustFromDb(orderCoForm,order);
	}

	@RequestMapping(value = "/pantsAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void pantsAdjustFormDb(OrderCoForm orderCoForm) {
		Order order = orderListService.findOrderPtByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
		orderCoHelper.pantsAdjustFromDb(orderCoForm,order);
	}

	@RequestMapping(value = "/pants2AdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void pants2AdjustFormDb(OrderCoForm orderCoForm) {
		Order order = orderListService.findOrderPt2ByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
		orderCoHelper.pants2AdjustFromDb(orderCoForm,order);
	}

	@RequestMapping(value = "/giletAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void giletAdjustFormDb(OrderCoForm orderCoForm) {
		Order order = orderListService.findOrderGlByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
		coGiletHelper.giletAdjustFromDb(orderCoForm,order);
	}

	@RequestMapping(value = "/shirtAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void shirtAdjustFormDb(OrderCoForm orderCoForm) {
		Order order = orderListService.findOrderStByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
		coShirtHelper.shirtAdjustFromDb(orderCoForm,order);
	}

	@RequestMapping(value = "/coatAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void coatAdjustFormDb(OrderCoForm orderCoForm) {
		Order order = orderListService.findOrderCtByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
		coCoatHelper.coatAdjustFromDb(orderCoForm,order);
	}
	
	@RequestMapping(value = "/productPrice", method = RequestMethod.GET)
	@ResponseBody
	public String productPrice(OrderCoForm orderCoForm,String productCode, String valueCode,String valueName) {
		String resultPrice = null;
		CoProductPriceEnum[] values = CoProductPriceEnum.values();
		String proCode = null;
		for (CoProductPriceEnum coProductPriceEnum : values) {
			String key = coProductPriceEnum.getKey();
			String valueTwo = coProductPriceEnum.getValueTwo();
			if(BaseCheckUtil.isEmpty(productCode)) {
				String osShirtModel = orderCoForm.getCoOptionShirtStandardInfo().getOsShirtModel();
				if(BaseCheckUtil.isNotEmpty(osShirtModel)) {
					if(BaseCheckUtil.isNotEmpty(valueTwo)) {
						if(valueTwo.equals(valueName)) {
							proCode = "05".concat("05").concat(osShirtModel).concat(key).concat(valueCode);
							resultPrice = getOrderPrice(proCode,orderCoForm);
						}
					}
				}else {
					resultPrice = "0";
				}
			}else {
				if(BaseCheckUtil.isNotEmpty(valueTwo)) {
					if(valueTwo.equals(valueName)) {
						proCode = productCode.concat(key).concat(valueCode);
						resultPrice = getOrderPrice(proCode,orderCoForm);
					}
				}
			}
		}
		return resultPrice;
	}
	
	private String getOrderPrice(String proCode, OrderCoForm orderCoForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderCoForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderBranchPrice = orderCodePrice.getOrderBranchPrice();
			if(orderKeyCode.equals(proCode)) {
				if("0".equals(orderBranchPrice)) {
					resultPrice = "0";
					break;
				}else {
					BigDecimal branchPrice = new BigDecimal(orderBranchPrice);
					resultPrice = String.valueOf(branchPrice);
					break;
				}
			}else {
				resultPrice = "0";
			}
		}
		return resultPrice;
	}

	@RequestMapping(value = "/getOrderPriceForJacketStandardModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForJacketModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		Map<String, Object> resultMap = coJakcetHelper.getOrderPriceForJacketModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForJacketTuxedoModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForJacketTuxedoModel(OrderCoForm orderCoForm, String code, String orderFlag ) {
		Map<String, Object> resultMap = coJakcetHelper.getOrderPriceForJacketTuxedoModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForJacketWashableModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForJacketWashableModel(OrderCoForm orderCoForm, String code,String orderFlag) {
		Map<String, Object> resultMap = coJakcetHelper.getOrderPriceForJacketWashableModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	/**
	 * 
	 * @param orderCoForm
	 * @param code
	 * @param model
	 * @param idValue
	 * @return
	 */
	@RequestMapping(value = "/getOrderPriceForJacketProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForJacketProject(OrderCoForm orderCoForm, String code,
			String idValueName,String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		Map<String, String> resultMap = coJakcetHelper.getOrderPriceForJacketProject(orderCoForm,code,idValueName,jspOptionCodeAndBranchCode,colorCount,countArr,thisVal,thisValStkNo);
		return resultMap;
	}
	
	/**
	 * 
	 * @param orderCoForm
	 * @param code
	 * @param model
	 * @param idValue
	 * @return
	 */
	@RequestMapping(value = "/getOrderPriceForJacketTuxedoProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForJacketTuxedoProject(OrderCoForm orderCoForm, String code,
			String idValueName,String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		Map<String, String> resultMap = coJakcetHelper.getOrderPriceForJacketTuxedoProject(orderCoForm,code,idValueName,jspOptionCodeAndBranchCode,colorCount,countArr,thisVal,thisValStkNo);
		return resultMap;
	}
	
	/**
	 * @param orderCoForm
	 * @param code
	 * @param model
	 * @param idValue
	 * @return
	 */
	@RequestMapping(value = "/getOrderPriceForJacketWashableProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForJacketWashableProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		Map<String, String> resultMap = coJakcetHelper.getOrderPriceForJacketWashableProject(orderCoForm,code,idValueName,jspOptionCodeAndBranchCode,colorCount,countArr,thisVal,thisValStkNo);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletStandardModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForGiletStandardModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		Map<String, Object> resultMap = coGiletHelper.getOrderPriceForGiletStandardModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletTuxedoModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForGiletTuxedoModel(OrderCoForm orderCoForm, String code,String orderFlag) {
		Map<String, Object> resultMap = coGiletHelper.getOrderPriceForGiletTuxedoModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletWashableModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForGiletWashableModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		Map<String, Object> resultMap = coGiletHelper.getOrderPriceForGiletWashableModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletStandardProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForGiletStandardProject(OrderCoForm orderCoForm, String code, String idValueName, 
			String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal, String thisValStkNo) {
		Map<String, String> resultMap = coGiletHelper.getOrderPriceForGiletStandardProject(orderCoForm, code, idValueName,
				jspOptionCodeAndBranchCode, colorCount, countArr, thisVal, thisValStkNo);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletTuxedoProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForGiletTuxedoProject(OrderCoForm orderCoForm, String code, String idValueName, 
			String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal, String thisValStkNo) {
		Map<String, String> resultMap = coGiletHelper.getOrderPriceForGiletTuxedoProject(orderCoForm, code, idValueName,
				jspOptionCodeAndBranchCode, colorCount, countArr, thisVal, thisValStkNo);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletWashableProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForGiletWashableProject(OrderCoForm orderCoForm, String code, String idValueName, 
			String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal, String thisValStkNo) {
		Map<String, String> resultMap = coGiletHelper.getOrderPriceForGiletWashableProject(orderCoForm, code, idValueName,
				jspOptionCodeAndBranchCode, colorCount, countArr, thisVal, thisValStkNo);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForShirtModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForShirtModel(OrderCoForm orderCoForm, String code) {
		Map<String, Object> resultMap = coShirtHelper.getOrderPriceForShirtModel(orderCoForm,code);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForShirtProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForShirtProject(OrderCoForm orderCoForm, String code, Model model, 
			String idValueName, String colorCount,String thisVal) {
		Map<String, String> resultMap = coShirtHelper.getOrderPriceForShirtProject(orderCoForm, code, model, 
				idValueName, colorCount,thisVal);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2Model", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPants2Model(OrderCoForm orderCoForm, String code, String orderFlag) {
		Map<String, Object> resultMap = coPants2Helper.getOrderPriceForPants2Model(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2tModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPants2tModel(OrderCoForm orderCoForm, String code,String orderFlag) {
		Map<String, Object> resultMap = coPants2Helper.getOrderPriceForPants2TuxedoModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2wModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPants2wModel(OrderCoForm orderCoForm, String code,String orderFlag) {
		Map<String, Object> resultMap = coPants2Helper.getOrderPriceForPants2WashableModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2Project", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPants2Project(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		Map<String, String> resultMap = coPants2Helper.getOrderPriceForPants2Project(orderCoForm, code,idValueName,
				jspOptionCodeAndBranchCode, colorCount, countArr,thisVal,thisValStkNo);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2tProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPants2tProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		Map<String, String> resultMap = coPants2Helper.getOrderPriceForPants2tProject(orderCoForm, code,idValueName,
				jspOptionCodeAndBranchCode, colorCount, countArr,thisVal,thisValStkNo);
		return resultMap;
	}

	@RequestMapping(value = "/getOrderPriceForPants2wProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPants2wProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		Map<String, String> resultMap = coPants2Helper.getOrderPriceForPants2WProject(orderCoForm, code,idValueName,
				jspOptionCodeAndBranchCode, colorCount, countArr,thisVal,thisValStkNo);
		return resultMap;
	}
	
	/**
	 * 
	 * @param orderCoForm
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getOrderPriceForCoatModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForCoatModel(OrderCoForm orderCoForm, String code) {
		Map<String, Object> resultMap = coCoatHelper.getOrderPriceForCoatModel(orderCoForm,code);
		return resultMap;
	}

	/**
	 * 
	 * @param orderCoForm
	 * @param code
	 * @param model
	 * @param idValue
	 * @return
	 */
	@RequestMapping(value = "/getOrderPriceForCoatProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForCoatProject(OrderCoForm orderCoForm, String code, Model model,
			String idValue,String thisVal,String thisValStkNo) {
		Map<String, String> resultMap = coCoatHelper.getOrderPriceForCoatProject(orderCoForm, code, model,
				idValue,thisVal,thisValStkNo);
		return resultMap;
	}

	@RequestMapping(value = "/getComposBodyIiner", method = RequestMethod.POST)
	@ResponseBody
	public ProductCompos getComposBodyIiner(OrderCoForm orderCoForm) {
		ProductCompos productCompos = orderCoHelper.getComposBodyIiner(orderCoForm);
		return productCompos;
	}
	
	@RequestMapping(value = "/optionInit", method = RequestMethod.GET)
	@ResponseBody
	public void allOptionInit(OrderCoForm orderCoForm,String item,String oldItem) {
		// デフォルト値設定
		if("01".equals(oldItem)) {
			coJakcetHelper.jacketDefaultValue(orderCoForm);
			orderCoHelper.pantsDefaultValue(orderCoForm);
			String productIs3Piece = orderCoForm.getProductIs3Piece();
			String productSparePantsClass = orderCoForm.getProductSparePantsClass();
			if(OptionCodeKeys.THREE_PIECE.equals(productIs3Piece)) {
				coGiletHelper.giletDefaultValue(orderCoForm);
			}
			if(OptionCodeKeys.TWO_PANTS.equals(productSparePantsClass)) {
				orderCoHelper.pants2DefaultValue(orderCoForm);
			}
		}else if("02".equals(oldItem)) {
			coJakcetHelper.jacketDefaultValue(orderCoForm);
		}else if("03".equals(oldItem)) {
			orderCoHelper.pantsDefaultValue(orderCoForm);
		}else if("04".equals(oldItem)) {
			coGiletHelper.giletDefaultValue(orderCoForm);
		}else if("05".equals(oldItem)) {
			coShirtHelper.shirtDefaultValue(orderCoForm);
		}else if("06".equals(oldItem)) {
			coCoatHelper.coatDefaultValue(orderCoForm);
		}
		
		if("01".equals(item)) {
			coJakcetHelper.jacketDefaultValue(orderCoForm);
			orderCoHelper.pantsDefaultValue(orderCoForm);
			String productIs3Piece = orderCoForm.getProductIs3Piece();
			String productSparePantsClass = orderCoForm.getProductSparePantsClass();
			if(OptionCodeKeys.THREE_PIECE.equals(productIs3Piece)) {
				coGiletHelper.giletDefaultValue(orderCoForm);
			}
			if(OptionCodeKeys.TWO_PANTS.equals(productSparePantsClass)) {
				orderCoHelper.pants2DefaultValue(orderCoForm);
			}
		}else if("02".equals(item)) {
			coJakcetHelper.jacketDefaultValue(orderCoForm);
		}else if("03".equals(item)) {
			orderCoHelper.pantsDefaultValue(orderCoForm);
		}else if("04".equals(item)) {
			coGiletHelper.giletDefaultValue(orderCoForm);
		}else if("05".equals(item)) {
			coShirtHelper.shirtDefaultValue(orderCoForm);
		}else if("06".equals(item)) {
			coCoatHelper.coatDefaultValue(orderCoForm);
		}
	}
	/**
	 * 
	 * @param price
	 * @return
	 */
	public String formatPrice(String price) {  
		  
        price = new StringBuffer(price).reverse().toString();
        String str2 = "";  
        int size = (price.length() % 3 == 0) ? (price.length() / 3) : (price.length() / 3 + 1);
        if (price.length() < 3) { 
            str2 = price;  
        } else {  
            for (int i = 0; i < size - 1; i++) {// 前n-1段  
                str2 += price.substring(i * 3, i * 3 + 3) + ",";  
            }  
            for (int i = size - 1; i < size; i++) {// 第n段  
                str2 += price.substring(i * 3, price.length());  
            }  
        }  
        str2 = new StringBuffer(str2).reverse().toString();// 再将字符串颠倒顺序  
        return str2;
    } 
	
	/**
	 * 
	 * @param code
	 * @param codeDetail
	 * @param orderForm
	 * @return
	 */
	public String getOrderDoublePrice (String code,String codeDetail,OrderCoForm orderCoForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderCoForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderDetailKeyCode = orderCodePrice.getOrderDetailKeyCode();
			String orderBranchDoublePrice = orderCodePrice.getOrderBranchDoublePrice();
			String orderBranchDetailDoublePrice = orderCodePrice.getOrderBranchDetailDoublePrice();
			if(orderDetailKeyCode == null) {
				orderDetailKeyCode = "";
			}
			if(orderBranchDetailDoublePrice == null) {
				orderBranchDetailDoublePrice = "0";
			}
			if(orderKeyCode.equals(code)&&orderDetailKeyCode.equals(codeDetail)) {
				if(orderBranchDoublePrice.equals("0")&&orderBranchDetailDoublePrice.equals("0")) {
					resultPrice = "0";
					break;
				}else {
					BigDecimal branchPrice = new BigDecimal(orderBranchDoublePrice);
					BigDecimal branchDetailPrice = new BigDecimal(orderBranchDetailDoublePrice);
					BigDecimal addPrice = branchPrice.add(branchDetailPrice);
					resultPrice = String.valueOf(addPrice);
					break;
				}
			}else {
				resultPrice = "0";
			}
		}
		return resultPrice;
	}
	@RequestMapping(value = "/getOrderPriceForPantsModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPantsModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		Map<String, Object> resultMap = CoPants1Helper.getOrderPriceForPantsModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPantsSProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPantsSProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo,String valueHemUpId) {
		Map<String, String> resultMap = coPants1Helper.getOrderPriceForPantsSProject(orderCoForm, code,idValueName,
				jspOptionCodeAndBranchCode, colorCount, countArr,thisVal,thisValStkNo,valueHemUpId);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPantsTuModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPantsTuModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		Map<String, Object> resultMap = coPants1Helper.getOrderPriceForPantsTuModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPantsSTuProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPantsSTuProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo,String valueHemUpId) {
		Map<String, String> resultMap = coPants1Helper.getOrderPriceForPantsSTuProject(orderCoForm, code,idValueName,
				jspOptionCodeAndBranchCode, colorCount, countArr,thisVal,thisValStkNo,valueHemUpId);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPantsWPModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPantsWPModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		Map<String, Object> resultMap = coPants1Helper.getOrderPriceForPantsWPModel(orderCoForm,code,orderFlag);
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPantsSWPProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPantsSWPProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo,String valueHemUpId) {
		Map<String, String> resultMap = coPants1Helper.getOrderPriceForPantsSWPProject(orderCoForm, code,idValueName,
				jspOptionCodeAndBranchCode, colorCount, countArr,thisVal,thisValStkNo,valueHemUpId);
		return resultMap;
	}
}
