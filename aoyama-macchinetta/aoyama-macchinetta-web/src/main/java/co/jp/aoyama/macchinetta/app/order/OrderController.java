package co.jp.aoyama.macchinetta.app.order;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.order.enums.LogItemClassEnum;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.app.shop.ShopForm;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Cash;
import co.jp.aoyama.macchinetta.domain.model.Item;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.MemberName;
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
import co.jp.aoyama.macchinetta.domain.service.member.MemberNameService;
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
@RequestMapping("/order")
@SessionAttributes(value = { "orderForm" })
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Value("${member.url:http://202.214.88.88/member/api/v1/memname}")
	String memberUrl;
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
	MemberNameService memberNameService;
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

	private OrderHelper orderHelper = new OrderHelper();
	
	private static final String PO_TYPE = "PO";

	private static final String ONE = "1";
	
	private static final String MIN_CODE = "10000001";
	
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
	
	//注文情報が変更されています。もう一度、オーダー一覧へ戻って最新の注文情報を選んでください。
	private static final String IS_UPDATE6 = "6";
	
	@ModelAttribute(value = "orderForm")
	public OrderForm setupForm() {
		return new OrderForm();
	}

	/**
	 * PO登録画面初期化
	 * 
	 * @param model
	 * @param req
	 * 
	 */
	@RequestMapping(value = "orderPo")
	public String toOrderPo(OrderForm orderForm, Model model) {
		try {
			orderForm.setAuthority(sessionContent.getAuthority());

			// オプションデーターを取得
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(PO_TYPE);
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(PO_TYPE);
			// モデルを取得
			List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getAllModel(PO_TYPE);
			// 要尺を取得
			List<Yield> yieldList = yieldService.getYield();
			// 消費税を取得
			Date date = new Date();
			int taxRate = consumptionService.getTaxRate(date);
			// 素材品番のMapを取得
			List<OptionBranchDetail> detailList = optionBranchDeailService.getAllOption(PO_TYPE);
			
			List<OrderPrice> priceList = orderService.getOrderPrice(PO_TYPE);

			orderHelper.getOptionStandardData(standardOptionList, orderForm);
			orderHelper.getFigureNumberMap(orderForm);
			orderHelper.getItem(itemList, orderForm);
			orderHelper.getModel(modelList, orderForm);
			orderHelper.getTaxRate(taxRate, orderForm);
			orderHelper.getYield(yieldList, orderForm);
			orderHelper.dealWithDetailCode(orderForm, detailList);
			List<OrderCodePrice> optionBranchPriceData = orderHelper.optionBranchPriceData(priceList);
			orderForm.setOrderCodePriceList(optionBranchPriceData);
			//登録フラッグ
			String orderFlag = "orderPo";
			orderForm.setOrderFlag(orderFlag);
			
			orderForm.setStatus("");
			model.addAttribute("orderFlag", "");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return "order/orderPoForm";
	}

	@RequestMapping(value = "orderPoUpdate")
	public String toOrderPoUpdate(Model model) {
		try {
			OrderForm orderForm = new OrderForm();
			orderForm.setAuthority(sessionContent.getAuthority());

			// オプションデーターを取得
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(PO_TYPE);
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(PO_TYPE);
			// モデルを取得
			List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getAllModel(PO_TYPE);
			// 要尺を取得
			List<Yield> yieldList = yieldService.getYield();
			// 消費税を取得
			Date date = new Date();
			int taxRate = consumptionService.getTaxRate(date);
			// 素材品番のMapを取得
			List<OptionBranchDetail> detailList = optionBranchDeailService.getAllOption(PO_TYPE);
			List<OrderPrice> priceList = orderService.getOrderPrice(PO_TYPE);
			

			orderHelper.getOptionStandardData(standardOptionList, orderForm);
			orderHelper.getFigureNumberMap(orderForm);
			orderHelper.getItem(itemList, orderForm);
			orderHelper.getModel(modelList, orderForm);
			orderHelper.getTaxRate(taxRate, orderForm);
			orderHelper.getYield(yieldList, orderForm);
			orderHelper.dealWithDetailCode(orderForm, detailList);
			List<OrderCodePrice> optionBranchPriceData = orderHelper.optionBranchPriceData(priceList);
			orderForm.setOrderCodePriceList(optionBranchPriceData);
			orderForm.setOrderFlag("");
			orderForm.setStatus("");
			model.addAttribute("orderForm", orderForm);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return "order/orderPoForm";
	}

	@RequestMapping(value = "orderPoBack")
	public String orderPoBack(HttpServletRequest request, OrderForm orderForm, Model model) {
		orderForm.setAuthority(sessionContent.getAuthority());
		String orderFlag = "orderBack";
		orderForm.setOrderFlag(orderFlag);
		model.addAttribute("orderFlag", "");
		return "order/orderPoForm";
	}

	/**
	 * 「オーダー確認画面」に遷移する。
	 * 
	 * @param orderForm
	 * @param model
	 * @param request
	 * 
	 */
	@RequestMapping(value = "orderPoReconfirm")
	public String toOrderPoReconfirm(HttpServletRequest request, OrderForm orderForm) {

//		Order order = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
//		
//		orderForm.setVersion(order.getVersion().toString());
		
		// 素材品番のMapを取得
		List<OptionBranchDetail> detailList = optionBranchDeailService.getAllOption(PO_TYPE);
		orderHelper.dealWithDetailCode(orderForm, detailList);

		// 店舗を取得
		List<Shop> shopList = shopService.findUnlessShop(sessionContent.getBelongCode());

		Map<String, String> map = new HashMap<String, String>();
		for (Shop shop : shopList) {
			map.put(shop.getShopCode(), shop.getShopName());
		}
		request.getSession().setAttribute("map", map);

		return "forward:/orderConfirm/orderReForm";
	}

	/**
	 * 「オーダー詳細」に遷移する。
	 * 
	 * @param orderForm
	 * @param model
	 * 
	 */
	@RequestMapping(value = "orderPoEntry")
	public String orderPoEntry(OrderForm orderForm, Model model) {
		// 注文ID
		String orderId = orderForm.getCustomerMessageInfo().getOrderId();
		// 注文を取得
		Order order = orderListService.findOrderByPk(orderId);
		orderHelper.dealWithCorrectAgain(orderForm, order, sessionContent.getUserId());
		ResultMessages resultMessages = null;
		try {
			orderService.updateOrder(order);
		}catch(ResourceNotFoundException re) {
			resultMessages = re.getResultMessages();
			logger.error(re.toString());
		}
		if(resultMessages == null) {
			model.addAttribute("isUpdate", IS_UPDATE1);
		}else {
			model.addAttribute("isUpdate", IS_UPDATE6);
		}
		
		return "order/orderPoLoginResultForm";
	}

	/**
	 * 生地チェク完了在庫を計算
	 * 
	 * @param orderForm
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "stockDecrease", method = RequestMethod.POST)
	public OrderMessage stockDecrease(OrderForm orderForm) {
		Order order = new Order();

		Measuring measuring = new Measuring();
		
		OrderMessage orderMessage = new OrderMessage();

		String orderIdImage = orderForm.getCustomerMessageInfo().getOrderId();

		String version = null;

		if (orderIdImage == null || "".equals(orderIdImage)) {
			// 注文ID
			String orderId = null;
			// 店舗コード
			String belongCode = sessionContent.getBelongCode();

			String last8digits = orderService.selectOrderIdBySequence();

			orderId = belongCode.concat(last8digits);
			
			// オーダーのデーター → orderForm
			orderFormToOrder(orderForm, order, measuring);

			order.setOrderId(orderId);

			measuring.setOrderId(orderId);

			String stockCheck = stockCheck(order, measuring);
			
			orderMessage.setOrderId(stockCheck);
			orderMessage.setOrderMsg("");
			orderMessage.setOrderMsgFlag(true);
			return orderMessage;
		} else {
			version = orderForm.getVersion();
			Order orderIsExist = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
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
						.selectByPrimaryKey(orderForm.getCustomerMessageInfo().getOrderId());

				// オーダーのデーター → orderForm
				orderFormToOrder(orderForm, order, measuring, orderIsExist, measuringIsExist);

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
			orderService.deleteOrder(order);
			orderService.deleteMeasuring(measuring);
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
	 * 一時保存、取り置き、自動保存
	 * 
	 * @param orderForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "orderPoTemporarySave", method = RequestMethod.POST)
	public OrderMessage orderPoTemporarySave(OrderForm orderForm, Model model) {

		Order order = new Order();

		Measuring measuring = new Measuring();
		
		OrderMessage orderMessage = new OrderMessage();

		String orderIdImage = orderForm.getCustomerMessageInfo().getOrderId();

		if (orderIdImage == null || "".equals(orderIdImage)) {
			// 注文ID
			String orderId = null;
			// 店舗コード
			String belongCode = sessionContent.getBelongCode();
			
			String last8digits = orderService.selectOrderIdBySequence();
			
			orderId = belongCode.concat(last8digits);
			
			// オーダーのデーター → orderForm
			orderFormToOrder(orderForm, order, measuring);

			order.setOrderId(orderId);

			measuring.setOrderId(orderId);
			
			orderMessage.setOrderId(orderId);
			orderMessage.setOrderMsg("");
			orderMessage.setOrderMsgFlag(true);
		} else {
			Order orderIsExist = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
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
						.selectByPrimaryKey(orderForm.getCustomerMessageInfo().getOrderId());

				// オーダーのデーター → orderForm
				orderFormToOrder(orderForm, order, measuring, orderIsExist, measuringIsExist);

				order.setVersion(orderIsExist.getVersion());
				orderMessage.setOrderId("true");
				orderMessage.setOrderMsg("");
				orderMessage.setOrderMsgFlag(true);
			}
		}

		Boolean orderMsgFlag = orderMessage.getOrderMsgFlag();
		
		if(orderMsgFlag) {
			String saveFlag = orderForm.getSaveFlag();

			// 保存flag 1：自動保存
			if ("1".equals(saveFlag)) {
				orderService.deletOrderWithNotVersion(order);
				orderService.deleteMeasuring(measuring);
			} else {
				orderService.deletOrderisExistence(order);
				orderService.deleteMeasuring(measuring);
			}
		}else {
			
		}
		return orderMessage;
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
	 * @param orderForm
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
				return theoryFabricUsedMount.toString();
			} else {
				return "0";
			}
		} else {
			return "0";
		}
	}
	
	
	
	private void orderFormToOrder(OrderForm orderForm, Order order, Measuring measuring) {
		
		// SUITの場合、itemCodeは"01"
		if ("01".equals(orderForm.getProductItem())) {

			beanMapper.map(orderForm.getOptionJacketStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustJacketStandardInfo(), order);
			
			beanMapper.map(orderForm.getOptionPantsStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustPantsStandardInfo(), order);

			// ３Pieceまたはスペアパンツは有り
			String productYes = "0009902";
			// ３Pieceまたはスペアパンツは無し
			String productNo = "0009901";
			// ３Pieceは有り、スペアパンツは有りの場合
			if (productYes.equals(orderForm.getProductIs3Piece())
					&& productYes.equals(orderForm.getProductSparePantsClass())) {

				beanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
				beanMapper.map(orderForm.getAdjustGiletStandardInfo(), order);

				beanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
				beanMapper.map(orderForm.getAdjustPants2StandardInfo(), order);
			}
			// ３Pieceは有り、スペアパンツは無しの場合
			else if (productYes.equals(orderForm.getProductIs3Piece())
					&& productNo.equals(orderForm.getProductSparePantsClass())) {

				beanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
				beanMapper.map(orderForm.getAdjustGiletStandardInfo(), order);
			}
			// ３Pieceは無し、スペアパンツは有りの場合
			else if (productNo.equals(orderForm.getProductIs3Piece())
					&& productYes.equals(orderForm.getProductSparePantsClass())) {

				beanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
				beanMapper.map(orderForm.getAdjustPants2StandardInfo(), order);

			}
		}
		// JACKETの場合、itemCodeは"02"
		else if ("02".equals(orderForm.getProductItem())) {
			beanMapper.map(orderForm.getOptionJacketStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustJacketStandardInfo(), order);
		}
		// PANTSの場合、itemCodeは"03"
		else if ("03".equals(orderForm.getProductItem())) {
			beanMapper.map(orderForm.getOptionPantsStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustPantsStandardInfo(), order);
		}
		// GILETの場合、itemCodeは"04"
		else if ("04".equals(orderForm.getProductItem())) {
			beanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustGiletStandardInfo(), order);
		}

		// orderFormの対象とorderの対応フィールドのマッピング
		beanMapper.map(orderForm.getCustomerMessageInfo(), order);
		beanMapper.map(orderForm, order);
		orderHelper.setProductItemDisplayCode(orderForm, order);
		orderHelper.orderMappingLogOn(orderForm, order, sessionContent);
		orderHelper.measuringMapping(orderForm, measuring, sessionContent.getUserId());
		measuring.setCreatedUserId(sessionContent.getUserId());
		measuring.setCreatedAt(new Date());
		
		String saveFlag = orderForm.getSaveFlag();
		if ("0".equals(saveFlag)) {
			order.setTscStatus(orderForm.getStatus());
			// 保存flag 1：自動保存
			// ステータスなし→「一時保存」、「一時保存」→「一時保存」、「取り置き」→「取り置き」
		} 
		else if ("1".equals(saveFlag)) {
			String tscStatus = orderForm.getStatus();
			if ("".equals(tscStatus) || tscStatus == null) {
				order.setTscStatus(TSC_STATUST0);
			} else {
				order.setTscStatus(tscStatus);
			}
		}
	}

	/**
	 * オーダーのデーター → orderForm
	 * 
	 * @param orderForm
	 * @param order
	 * @param measuring
	 * @param orderIsExist
	 * @throws ParseException 
	 */
	private void orderFormToOrder(OrderForm orderForm, Order order, Measuring measuring, Order orderIsExist,
			Measuring measuringIsExist){
		// SUITの場合、itemCodeは"01"
		if ("01".equals(orderForm.getProductItem())) {

			beanMapper.map(orderForm.getOptionJacketStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustJacketStandardInfo(), order);
			
			beanMapper.map(orderForm.getOptionPantsStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustPantsStandardInfo(), order);

			// ３Pieceまたはスペアパンツは有り
			String productYes = "0009902";
			// ３Pieceまたはスペアパンツは無し
			String productNo = "0009901";
			// ３Pieceは有り、スペアパンツは有りの場合
			if (productYes.equals(orderForm.getProductIs3Piece())
					&& productYes.equals(orderForm.getProductSparePantsClass())) {

				beanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
				beanMapper.map(orderForm.getAdjustGiletStandardInfo(), order);

				beanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
				beanMapper.map(orderForm.getAdjustPants2StandardInfo(), order);
			}
			// ３Pieceは有り、スペアパンツは無しの場合
			else if (productYes.equals(orderForm.getProductIs3Piece())
					&& productNo.equals(orderForm.getProductSparePantsClass())) {

				beanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
				beanMapper.map(orderForm.getAdjustGiletStandardInfo(), order);
			}
			// ３Pieceは無し、スペアパンツは有りの場合
			else if (productNo.equals(orderForm.getProductIs3Piece())
					&& productYes.equals(orderForm.getProductSparePantsClass())) {

				beanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
				beanMapper.map(orderForm.getAdjustPants2StandardInfo(), order);

			}
		}
		// JACKETの場合、itemCodeは"02"
		else if ("02".equals(orderForm.getProductItem())) {
			beanMapper.map(orderForm.getOptionJacketStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustJacketStandardInfo(), order);
		}
		// PANTSの場合、itemCodeは"03"
		else if ("03".equals(orderForm.getProductItem())) {
			beanMapper.map(orderForm.getOptionPantsStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustPantsStandardInfo(), order);
		}
		// GILETの場合、itemCodeは"04"
		else if ("04".equals(orderForm.getProductItem())) {
			beanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
			beanMapper.map(orderForm.getAdjustGiletStandardInfo(), order);
		}

		// orderFormの対象とorderの対応フィールドのマッピング
		beanMapper.map(orderForm.getCustomerMessageInfo(), order);
		beanMapper.map(orderForm, order);
		orderHelper.setProductItemDisplayCode(orderForm, order);
		orderHelper.orderMappingLogOn(orderForm, order, sessionContent, orderIsExist);
		orderHelper.measuringMapping(orderForm, measuring, sessionContent.getUserId());
		measuring.setCreatedAt(measuringIsExist.getCreatedAt());
		measuring.setCreatedUserId(measuringIsExist.getUpdatedUserId());
		
		String saveFlag = orderForm.getSaveFlag();
		if ("0".equals(saveFlag)) {
			order.setTscStatus(orderForm.getStatus());
			// 保存flag 1：自動保存
			// ステータスなし→「一時保存」、「一時保存」→「一時保存」、「取り置き」→「取り置き」
		} else if ("1".equals(saveFlag)) {
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
	 * @param orderForm
	 * @param order
	 * @param measuring
	 */
	private String stockCheck(Order order, Order orderIsExist, Measuring measuring) throws ResourceNotFoundException {

		// 商品情報_ITEM(ログ用)
		String item = LogItemClassEnum.getLogItem(order);

		// 在庫を戻る
		stockRecovery(orderIsExist);

		// 理論在庫チェック値を取得
		String isCheck = orderIsExist.getTheoreticalStockCheck();
		// 理論在庫チェック値が0の場合
		if (IS_NOT_THEORETICAL_STOCKCECK.equals(isCheck)) {
			// 生地品番が無しの場合
			if ("".equals(order.getProductFabricNo()) || order.getProductFabricNo() == null) {
				order.setTheoreticalStockCheck(IS_NOT_THEORETICAL_STOCKCECK);
				orderService.deleteOrder(order);
				orderService.deleteMeasuring(measuring);
			}
			// 生地品番が有りの場合
			else {
				Stock stock = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
				logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫更新前：「注文パターン：" + order.getOrderPattern() + "、注文ID："
						+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
						+ stock.getTheoreticalStock() + "、予約生地量：" + stock.getReservationStock() + "」");
				BigDecimal reservationStock = stock.getReservationStock();
				BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
				stock.setReservationStock(reservationStock.add(theoryFabricUsedMount));
				stock.setUpdatedUserId(sessionContent.getUserId());
				stock.setUpdatedAt(new Date());
				order.setTheoreticalStockCheck(IS_THEORETICAL_STOCKCECK);
				orderService.deleteOrderAndStock(order, stock, measuring);

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
				orderService.deleteOrder(order);
				orderService.deleteMeasuring(measuring);
			}
			// 生地品番が有りの場合
			else {
				Stock stock = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
				logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫更新前：「注文パターン：" + order.getOrderPattern() + "、注文ID："
						+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo() + "、理論在庫："
						+ stock.getTheoreticalStock() + "、予約生地量：" + stock.getReservationStock() + "」");
				BigDecimal reservationStock = stock.getReservationStock();
				BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
				stock.setReservationStock(reservationStock.add(theoryFabricUsedMount));
				stock.setUpdatedUserId(sessionContent.getUserId());
				stock.setUpdatedAt(new Date());
				order.setTheoreticalStockCheck(IS_THEORETICAL_STOCKCECK);
				orderService.deleteOrderAndStock(order, stock, measuring);

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
	public String physicalDelete(String orderId,String version ,Model model) {
		String orderVersion = this.getOrderVersion(orderId);
		
		if(orderVersion != null&& !"".equals(orderVersion)) {
			// 注文IDによって 注文を取得
			Order order = orderListService.findOrderByPk(orderId);
			
			//商品情報_ITEM(ログ用)
			String item = LogItemClassEnum.getLogItem(order);
			
			String versionDb = String.valueOf(order.getVersion());
			if(version.equals(versionDb)) {
				// tscステータスが無しの場合 注文物理削除
				if ("".equals(order.getTscStatus()) || order.getTscStatus() == null) {
					if (IS_NOT_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
						orderService.deleteMeasuringBothOrder(orderId);
					} else if (IS_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
						// 生地の論理在庫を戻る
						Stock stock = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+item 
						+ "、生地品番："+order.getProductFabricNo() 
						+ "、理論在庫："+stock.getTheoreticalStock() 
						+ "、予約生地量："+stock.getReservationStock() + "」");
						BigDecimal reservationStock = stock.getReservationStock();
						BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
						stock.setReservationStock(reservationStock.subtract(theoryFabricUsedMount));
						stock.setUpdatedUserId(sessionContent.getUserId());
						stock.setUpdatedAt(new Date());
						orderService.physicalDeleteOrder(stock,orderId);
						Stock stockAfter = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() 
						+ "、注文ID："+order.getOrderId()  
						+ "、ITEM："+item
						+ "、生地品番："+order.getProductFabricNo() 
						+ "、理論在庫："+stockAfter.getTheoreticalStock() 
						+ "、予約生地量："+stockAfter.getReservationStock() + "」");
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
							Stock stock = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
							logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() 
							+ "、注文ID："+order.getOrderId()  
							+ "、ITEM："+item 
							+ "、生地品番："+order.getProductFabricNo() 
							+ "、理論在庫："+stock.getTheoreticalStock() 
							+ "、予約生地量："+stock.getReservationStock() + "」");
							BigDecimal reservationStock = stock.getReservationStock();
							BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
							stock.setReservationStock(reservationStock.subtract(theoryFabricUsedMount));
							stock.setUpdatedUserId(sessionContent.getUserId());
							stock.setUpdatedAt(new Date());
							orderService.physicalDeleteOrder(stock,orderId);
							Stock stockAfter = orderService.getStock(order.getProductFabricNo(),order.getOrderPattern());
							logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() 
							+ "、注文ID："+order.getOrderId()  
							+ "、ITEM："+item
							+ "、生地品番："+order.getProductFabricNo() 
							+ "、理論在庫："+stockAfter.getTheoreticalStock() 
							+ "、予約生地量："+stockAfter.getReservationStock() + "」");
						}
					}
				}
				model.addAttribute("isUpdate", IS_UPDATE2);
			}else {
				model.addAttribute("isUpdate", IS_UPDATE6);
			}
		}else {
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
	public String logicalDeletion(String orderId,String version, Model model) {

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
	public String getShopDeliveryOn(String storeDelvNormal) {
		Date nowDate = new Date();
		String shopDeliveryOn = orderService.getShopDeliveryOn(nowDate, storeDelvNormal);
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
	public OrderFindFabric findStock(String fabricNo, String orderPattern) {

		OrderFindFabric orderFindFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		
		if(orderFindFabric != null) {
			BigDecimal theoretical = new BigDecimal(orderFindFabric.getTheoreticalStock());
			BigDecimal reservation = new BigDecimal(orderFindFabric.getReservationStock());
			BigDecimal result = theoretical.subtract(reservation);
			
			orderFindFabric.setStockResult(String.valueOf(result));
		}
		
		return orderFindFabric;
	}

	/**
	 * オプション選択肢とオプション選択肢詳細の料金を取得
	 * 
	 * @param orderPattern
	 */
	@ResponseBody
	@RequestMapping(value = "getBranchPrice", method = RequestMethod.GET)
	public List<OrderCodePrice> getBranchPrice(String orderPattern, OrderForm orderForm) {

		List<OrderPrice> priceList = orderService.getOrderPrice(orderPattern);
		List<OrderCodePrice> optionBranchPriceList = orderHelper.optionBranchPriceData(priceList);
		orderForm.setOrderCodePriceList(optionBranchPriceList);
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
	public Map<String, String> standardMateSelect(String itemCode, String subItemCode, String mateChecked, String orderPattern,
			String optionCode) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getStandardButtons(itemCode,subItemCode, mateChecked,
				orderPattern, optionCode);
		LinkedHashMap<String, String> standardMateMap = orderHelper.getButtons(mateList);
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
	public Map<String, String> tuxdoMateSelect(String itemCode,String subItemCode, String mateChecked, String orderPattern) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getTuxedoButtons(itemCode,subItemCode, mateChecked,
				orderPattern);
		LinkedHashMap<String, String> tuxedoMateMap = orderHelper.getButtons(mateList);
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
	public Map<String, String> washabiMateSelect(String itemCode,String subItemCode, String mateChecked, String orderPattern) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getWashableButtons(itemCode ,subItemCode, mateChecked,
				orderPattern);
		LinkedHashMap<String, String> washabiMateMap = orderHelper.getButtons(mateList);
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
	 * @param modelCode
	 * @param productFabricNo
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkModel", method = RequestMethod.GET)
	public Boolean checkModel(String modelCode, String productFabricNo, String orderPattern, String itemCode,String subItemCode) {
		Boolean checkFlag = true;
		OrderFindFabric orderFindFabric = findStock(productFabricNo, orderPattern);
		String factoryCode = orderFindFabric.getFactoryCode();
		String factories = orderService.getFactories(orderPattern, itemCode, modelCode,subItemCode);
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
		if(version == null) {
			return "";
		}else {
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
	public List<co.jp.aoyama.macchinetta.domain.model.Model> getModel(String orderPattern,String itemCode) {
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getModel(orderPattern,itemCode);
		return modelList;
	}
	
	/**
	 * 
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSizeFigureByItem", method = RequestMethod.GET)
	public List<SizeFigure> getSizeFigureByItem(String orderPattern,String itemCode,String subItemCode,String modelCode) {
		List<SizeFigure> figureList = sizeFigureService.getSizeFigureByItem(orderPattern,itemCode,subItemCode,modelCode);
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
	public List<SizeNumber> getSizeNumberByItem(String orderPattern,String itemCode,String subItemCode,String modelCode) {
		List<SizeNumber> NumberList = sizeNumberService.getSizeNumberByItem(orderPattern,itemCode,subItemCode,modelCode);
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
	public List<Adjust> getAdjustByItem(String orderPattern,String itemCode) {
		List<Adjust> adjustList = adjustService.getAdjustByItem(orderPattern,itemCode);
		return adjustList;
	}
	
	@ResponseBody
	@RequestMapping(value = "getOrderPrice", method = RequestMethod.GET)
	public String getOrderPrice (String code,String codeDetail,OrderForm orderForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderDetailKeyCode = orderCodePrice.getOrderDetailKeyCode();
			String orderBranchPrice = orderCodePrice.getOrderBranchPrice();
			String orderBranchDetailPrice = orderCodePrice.getOrderBranchDetailPrice();
			if(orderKeyCode.equals(code)&&orderDetailKeyCode.equals(codeDetail)) {
				if(orderBranchPrice.equals("0")&&orderBranchDetailPrice.equals("0")) {
					resultPrice = "0";
					break;
				}else {
					BigDecimal branchPrice = new BigDecimal(orderBranchPrice);
					BigDecimal branchDetailPrice = new BigDecimal(orderBranchDetailPrice);
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
	
	@ResponseBody
	@RequestMapping(value = "getOrderNormalPrice", method = RequestMethod.GET)
	public String getOrderNormalPrice (String code,String codeDetail,OrderForm orderForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderBranchPrice = orderCodePrice.getOrderBranchPrice();
			if(orderKeyCode.equals(code)) {
				if(orderBranchPrice.equals("0")) {
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
	
	
	@ResponseBody
	@RequestMapping(value = "getOrderDoublePrice", method = RequestMethod.GET)
	public String getOrderDoublePrice (String code,String codeDetail,OrderForm orderForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderDetailKeyCode = orderCodePrice.getOrderDetailKeyCode();
			String orderBranchDoublePrice = orderCodePrice.getOrderBranchDoublePrice();
			String orderBranchDetailDoublePrice = orderCodePrice.getOrderBranchDetailDoublePrice();
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
	
	@ResponseBody
	@RequestMapping(value = "getOrderDoubleNormalPrice", method = RequestMethod.GET)
	public String getOrderDoubleNormalPrice (String code,String codeDetail,OrderForm orderForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderBranchDoublePrice = orderCodePrice.getOrderBranchDoublePrice();
			if(orderKeyCode.equals(code)) {
				if(orderBranchDoublePrice.equals("0")) {
					resultPrice = "0";
					break;
				}else {
					BigDecimal branchPrice = new BigDecimal(orderBranchDoublePrice);
					resultPrice = String.valueOf(branchPrice);
					break;
				}
			}else {
				resultPrice = "0";
			}
		}
		return resultPrice;
	}
	
	@ResponseBody
	@RequestMapping(value = "getPoTypeSizeOptimization", method = RequestMethod.GET)
	public List<TypeSizeOptimization> getPoTypeSizeOptimization (String orderPattern,String subItemCode,String modelCode,String figure,String number) {
		List<TypeSize> poTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern,subItemCode,modelCode,figure,number);
		List<TypeSizeOptimization> poTypeSizeOptimization = orderHelper.getPoTypeSizeOptimization(poTypeSizeList);
		return poTypeSizeOptimization;
	}
	
	public String getCountUsage (String theoreticalStock,String reservationStock) {
		BigDecimal theoretical = new BigDecimal(theoreticalStock);
		BigDecimal reservation = new BigDecimal(reservationStock);
		BigDecimal result = theoretical.subtract(reservation);
		return String.valueOf(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMemberMessage", method = RequestMethod.GET)
	public MemberName getMemberMessage (String membersId,String gyotaiCd) {
		MemberName execute = memberNameService.execute(memberUrl, membersId, gyotaiCd);
		return execute;
	}
	
	
}
