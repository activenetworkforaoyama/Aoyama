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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

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
@SessionAttributes(value = { "orderForm" })
public class OrderCoController {
	private static final Logger logger = LoggerFactory.getLogger(OrderCoController.class);
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

	private OrderHelper orderHelper = new OrderHelper();

	private static final String PO_TYPE = "PO";

	private static final String CO_TYPE = "CO";

	// 在庫チェックなし
	private static final String IS_NOT_THEORETICAL_STOCKCECK = "0";

	// 在庫チェックあり
	private static final String IS_THEORETICAL_STOCKCECK = "1";

	// TSCステータス 一時保存
	private static final String TSC_STATUST0 = "T0";

	// TSCステータス 取り置き
	private static final String TSC_STATUST1 = "T1";

	// 取り消しフラグ 取り消しではない
	private static final String IS_NOT_CANCELLED = "0";

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

	// 工場ステータス 生産開始前
	private static final String FACTORY_STATUSF0 = "F0";

	// 工場自動連携ステータス 送信前
	private static final String SEND2FACTORY_STATUS0 = "0";

	private static final String JACKET_SUBITEM = "02";

	private static final String PANTS_SUBITEM = "03";

	private static final String GILET_SUBITEM = "04";

	private static final String SHIRT_SUBITEM = "05";

	private static final String COAT_SUBITEM = "06";
	
	private static final String PANTS2_SUBITEM = "07";

	@ModelAttribute(value = "orderForm")
	public OrderForm setupForm() {
		return new OrderForm();
	}

	@RequestMapping("toOrderCoInit")
	public String toOrderCo(Model model) {
		try {
			OrderForm orderForm = new OrderForm();
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(CO_TYPE);
			List<OptionBranch> tuxedoOptionList = optionBranchService.getTuxedoOption(CO_TYPE);
			List<OptionBranch> washableOptionList = optionBranchService.getWashableOption(CO_TYPE);
			// 要尺を取得
			List<Yield> yieldList = yieldService.getYield();
			// 消費税を取得
			int taxRate = consumptionService.getTaxRate(new Date());
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(CO_TYPE);
			
			orderHelper.getFigureNumberMap(orderForm);
			orderHelper.getOptionStandardData(standardOptionList, orderForm);
			orderHelper.getOptionTuxedoData(tuxedoOptionList, orderForm);
			orderHelper.getOptionWashableData(washableOptionList, orderForm);
			orderHelper.getItem(itemList, orderForm);
			orderHelper.getTaxRate(taxRate, orderForm);
			orderHelper.getYield(yieldList, orderForm);
			List<OrderPrice> priceList = orderService.getOrderPrice(CO_TYPE);
			List<OrderCodePrice> optionBranchPriceList = orderHelper.optionBranchPriceData(priceList);
			orderForm.setOrderCodePriceList(optionBranchPriceList);
			String orderFlag = "orderCo";
			orderForm.setOrderFlag(orderFlag);
			orderForm.setStatus("");
			// デフォルト値設定
			// orderHelper.setDefaultValue(orderForm);

			model.addAttribute("orderForm", orderForm);
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return "order/orderCoForm";
	}

	@RequestMapping(value = "orderCoUpdate")
	public String toOrderPoUpdate(Model model,HttpServletRequest req) {
		try {
			String orderFlag = (String) req.getAttribute("orderFlag");
			OrderForm orderForm = new OrderForm();
			orderForm.setAuthority(sessionContent.getAuthority());
			
			orderHelper.setCustomerMessageInfo(req,orderForm);
			
//			CustomerMessageInfo customerMessageInfo = new CustomerMessageInfo();
//			customerMessageInfo.setOrderId("1231332132");
//			
//			orderForm.setCustomerMessageInfo(customerMessageInfo);

			// オプションデーターを取得
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(CO_TYPE);
			List<OptionBranch> tuxedoOptionList = optionBranchService.getTuxedoOption(CO_TYPE);
			List<OptionBranch> washableOptionList = optionBranchService.getWashableOption(CO_TYPE);
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(CO_TYPE);
			// 要尺を取得
			List<Yield> yieldList = yieldService.getYield();
			// 消費税を取得
			int taxRate = consumptionService.getTaxRate(new Date());
			// 素材品番のMapを取得
			List<OrderPrice> priceList = orderService.getOrderPrice(CO_TYPE);

			orderHelper.getOptionStandardData(standardOptionList, orderForm);
			orderHelper.getOptionTuxedoData(tuxedoOptionList, orderForm);
			orderHelper.getOptionWashableData(washableOptionList, orderForm);
			orderHelper.getItem(itemList, orderForm);
			orderHelper.getFigureNumberMap(orderForm);
			orderHelper.getTaxRate(taxRate, orderForm);
			orderHelper.getYield(yieldList, orderForm);
			List<OrderCodePrice> optionBranchPriceData = orderHelper.optionBranchPriceData(priceList);
			orderForm.setOrderCodePriceList(optionBranchPriceData);
			
			orderForm.setOrderFlag(orderFlag);
			orderForm.setStatus("");
			model.addAttribute("orderForm", orderForm);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return "order/orderCoForm";
	}

	@RequestMapping(value = "orderCoBack")
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
	@RequestMapping(value = "orderCoReconfirm")
	public String toOrderPoReconfirm(HttpServletRequest request, OrderForm orderForm) {

//		Order order = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
//		
//		orderForm.setVersion(order.getVersion().toString());
//		
//		// 素材品番のMapを取得
//		List<OptionBranchDetail> detailList = optionBranchDeailService.getAllOption(PO_TYPE);
//		orderHelper.dealWithDetailCode(orderForm, detailList);
//
//		// 店舗を取得
//		List<Shop> shopList = shopService.findUnlessShop(sessionContent.getBelongCode());
//
//		Map<String, String> map = new HashMap<String, String>();
//		for (Shop shop : shopList) {
//			map.put(shop.getShopCode(), shop.getShopName());
//		}
//		request.getSession().setAttribute("map", map);

		return "forward:/orderCoConfirm/orderCoReForm";
	}

	/**
	 * 「オーダー詳細」に遷移する。
	 * 
	 * @param orderForm
	 * @param model
	 * 
	 */
	@RequestMapping(value = "orderCoEntry")
	public String orderPoEntry(OrderForm orderForm, Model model) {
		// 注文ID
		String orderId = orderForm.getCustomerMessageInfo().getOrderId();
		// 注文を取得
		Order order = orderListService.findOrderByPk(orderId);
		orderHelper.dealWithCorrectAgain(orderForm, order, sessionContent.getUserId());
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
	 * @param orderForm
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "stockDecrease", method = RequestMethod.POST)
	public String stockDecrease(OrderForm orderForm) {
		Order order = new Order();

		Measuring measuring = new Measuring();

		String orderIdImage = orderForm.getCustomerMessageInfo().getOrderId();

		String version = null;

		if (orderIdImage == null || "".equals(orderIdImage)) {
			// 注文ID
			String orderId = null;
			// 店舗コード
			String belongCode = sessionContent.getBelongCode();

			String last8digits = orderService.selectOrderIdBySequence();

			orderId = belongCode.concat(last8digits);
			
//			String orderIdCheckCd = belongCode.concat(ONE);
//			String maxOrderId = orderService.selectMaxOrderId(orderIdCheckCd, PO_TYPE);
//			if (maxOrderId == null) {
//				orderId = belongCode.concat(MIN_CODE);
//			} else {
//				long parseLong = Long.parseLong(maxOrderId) + 1;
//				orderId = String.format("%012d", parseLong);
//			}

			// オーダーのデーター → orderForm
			orderFormToOrder(orderForm, order, measuring);

			order.setOrderId(orderId);

			measuring.setOrderId(orderId);

			String stockCheck = stockCheck(order, measuring);

			return stockCheck;
		} else {
			version = orderForm.getVersion();
			Order orderIsExist = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());

			Measuring measuringIsExist = measuringService
					.selectByPrimaryKey(orderForm.getCustomerMessageInfo().getOrderId());

			// オーダーのデーター → orderForm
			orderFormToOrder(orderForm, order, measuring, orderIsExist, measuringIsExist);

			order.setVersion(Short.parseShort(version));

			String stockCheck = stockCheck(order, orderIsExist, measuring);

			return stockCheck;
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

	/**
	 * 一時保存、取り置き、自動保存
	 * 
	 * @param orderForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "orderCoTemporarySave", method = RequestMethod.POST)
	public String orderPoTemporarySave(OrderForm orderForm, Model model) {
		Order order = new Order();

		Measuring measuring = new Measuring();

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

		} else {
			Order orderIsExist = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());

			Measuring measuringIsExist = measuringService
					.selectByPrimaryKey(orderForm.getCustomerMessageInfo().getOrderId());

			// オーダーのデーター → orderForm
			orderFormToOrder(orderForm, order, measuring, orderIsExist, measuringIsExist);

			order.setVersion(orderIsExist.getVersion());
		}

		String saveFlag = orderForm.getSaveFlag();

		// 保存flag 1：自動保存
		if ("1".equals(saveFlag)) {
			orderService.deletOrderWithNotVersion(order);
			orderService.deleteMeasuring(measuring);
		} else {
			orderService.deletOrderisExistence(order);
			orderService.deleteMeasuring(measuring);
		}

		if (orderIdImage == null || "".equals(orderIdImage)) {
			return order.getOrderId();
		} else {
			return "true";
		}
	}

	public void orderFormToOrder(OrderForm orderForm, Order order, Measuring measuring) {
		// 商品情報_ITEM
		String productItem = orderForm.getProductItem();
		// 商品情報_３Piece
		String productIs3Piece = orderForm.getProductIs3Piece();
		// 商品情報_スペアパンツ
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";

		// orderFormの対象とorderの対応フィールドのマッピング
		standardBeanMapper.map(orderForm.getCustomerMessageInfo(), order);
		standardBeanMapper.map(orderForm, order);
		orderHelper.measuringMapping(orderForm, measuring, sessionContent.getUserId());
		orderHelper.setProductItemDisplayCode(orderForm, order);
		orderHelper.orderMappingLogOn(orderForm, order, sessionContent);
		measuring.setCreatedUserId(sessionContent.getUserId());
		measuring.setCreatedAt(new Date());
		String saveFlag = orderForm.getSaveFlag();
		if ("0".equals(saveFlag)) {
			order.setTscStatus(orderForm.getStatus());
		}
		// 保存flag 1：自動保存
		// ステータスなし→「一時保存」、「一時保存」→「一時保存」、「取り置き」→「取り置き」
		else if ("1".equals(saveFlag)) {
			String tscStatus = orderForm.getStatus();
			if ("".equals(tscStatus) || tscStatus == null) {
				order.setTscStatus(TSC_STATUST0);
			} else {
				order.setTscStatus(tscStatus);
			}
		}
		
		// 標準の場合
		if ("0".equals(orderForm.getProductCategory())) {
			// SUITの場合、itemCodeは"01"
			if ("01".equals(productItem)) {
				orderHelper.setProductItemDisplayCode(orderForm, order);
				// JACKETについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionJacketStandardInfo(), order);

				// PANTSについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionPantsStandardInfo(), order);

				// ３Pieceは有り、スペアパンツは有りの場合
				if (productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionGiletStandardInfo(), order);

					// 2PANTSについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
				}
				// ３Pieceは有り、スペアパンツは無しの場合
				else if (productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
				}
				// ３Pieceは無し、スペアパンツは有りの場合
				else if (productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// 2PANTSについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
				}
			}
			// JACKETの場合、itemCodeは"02"
			else if ("02".equals(productItem)) {
				// JACKETについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionJacketStandardInfo(), order);
			}
			// PANTSの場合、itemCodeは"03"
			else if ("03".equals(productItem)) {
				// PANTSについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionPantsStandardInfo(), order);
			}
			// GILETの場合、itemCodeは"04"
			else if ("04".equals(productItem)) {
				// GILETについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
			}
			// SHIRTの場合、itemCodeは"05"
			else if ("05".equals(productItem)) {
				standardBeanMapper.map(orderForm.getOptionShirtStandardInfo(), order);
			}
			// COATの場合、itemCodeは"06"
			else if ("06".equals(productItem)) {
				standardBeanMapper.map(orderForm.getOptionCoatStandardInfo(), order);
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
			Measuring measuringIsExist) {

		// 商品情報_ITEM
		String productItem = orderForm.getProductItem();
		// 商品情報_３Piece
		String productIs3Piece = orderForm.getProductIs3Piece();
		// 商品情報_スペアパンツ
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";

		// orderFormの対象とorderの対応フィールドのマッピング
		standardBeanMapper.map(orderForm.getCustomerMessageInfo(), order);
		standardBeanMapper.map(orderForm, order);
		orderHelper.measuringMapping(orderForm, measuring, sessionContent.getUserId());
		// 標準の場合
		if ("0".equals(orderForm.getProductCategory())) {
			// SUITの場合、itemCodeは"01"
			if ("01".equals(productItem)) {
				orderHelper.setProductItemDisplayCode(orderForm, order);
				// JACKETについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionJacketStandardInfo(), order);

				// PANTSについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionPantsStandardInfo(), order);

				// ３Pieceは有り、スペアパンツは有りの場合
				if (productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionGiletStandardInfo(), order);

					// 2PANTSについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
				}
				// ３Pieceは有り、スペアパンツは無しの場合
				else if (productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// GILETについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
				}
				// ３Pieceは無し、スペアパンツは有りの場合
				else if (productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// 2PANTSについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
				}
			}
			// JACKETの場合、itemCodeは"02"
			else if ("02".equals(productItem)) {
				// JACKETについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionJacketStandardInfo(), order);
			}
			// PANTSの場合、itemCodeは"03"
			else if ("03".equals(productItem)) {
				// PANTSについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionPantsStandardInfo(), order);
			}
			// GILETの場合、itemCodeは"04"
			else if ("04".equals(productItem)) {
				// GILETについてのマピンッグ
				standardBeanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
			}
			// SHIRTの場合、itemCodeは"05"
			else if ("05".equals(productItem)) {
				standardBeanMapper.map(orderForm.getOptionShirtStandardInfo(), order);
			}
			// COATの場合、itemCodeは"06"
			else if ("06".equals(productItem)) {
				standardBeanMapper.map(orderForm.getOptionCoatStandardInfo(), order);
			}
		}
		orderHelper.setProductItemDisplayCode(orderForm, order);
		orderHelper.orderMappingLogOn(orderForm, order, sessionContent, orderIsExist);
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
		// 保存flag 2：在庫チェク
		// ステータスなし→ステータスなし、「一時保存」→「一時保存」、「取り置き」→「取り置き」
		else if ("2".equals(saveFlag)) {
			String tscStatus = orderIsExist.getTscStatus();
			if ("".equals(tscStatus) || tscStatus == null) {
				order.setTscStatus("");
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

		if (order.getVersion().equals(orderIsExist.getVersion())) {
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
		} else {
			ResultMessages messages = ResultMessages.error();
			messages.add("E023");
			logger.error(messages.toString());
			throw new ResourceNotFoundException(messages);
		}

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
		// 商品情報_ITEM(ログ用)
		String item = LogItemClassEnum.getLogItem(order);
		String versionDb = String.valueOf(order.getVersion());
		if (version.equals(versionDb)) {
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
						Stock stockDb = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() + "、注文ID："
								+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo()
								+ "、理論在庫：" + stockDb.getTheoreticalStock() + "、予約生地量：" + stockDb.getReservationStock()
								+ "」");
						stockDb.setTheoreticalStock(stockDb.getTheoreticalStock().add(stockNum));
						stockDb.setUpdatedUserId(sessionContent.getUserId());
						stockDb.setUpdatedAt(new Date());
						order.setIsCancelled(IS_CANCELLED);
						order.setVersion(order.getVersion());
						orderService.updateStockByPkAndOrderAndCash(stockDb, order, cash);
						Stock stockAfter = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() + "、注文ID："
								+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo()
								+ "、理論在庫：" + stockAfter.getTheoreticalStock() + "、予約生地量："
								+ stockAfter.getReservationStock() + "」");
					} else {
						// 取り消しフラグ:0
						order.setIsCancelled(IS_CANCELLED);
						order.setVersion(order.getVersion());
						orderService.updateOrderAndCash(order, cash);
					}
				} else {
					// ステータスは「会計再確認要」を設定する
					Cash cash = cashService.selectByPrimaryKey(order.getCashId());
					cash.setCashStatus(CASH_STATUS03);
					if (!"".equals(order.getProductFabricNo()) || order.getProductFabricNo() != null) {
						// 生地の論理在庫を戻る
						BigDecimal stockNum = order.getTheoryFabricUsedMount();
						Stock stockDb = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復前：「注文パターン：" + order.getOrderPattern() + "、注文ID："
								+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo()
								+ "、理論在庫：" + stockDb.getTheoreticalStock() + "、予約生地量：" + stockDb.getReservationStock()
								+ "」");
						stockDb.setTheoreticalStock(stockDb.getTheoreticalStock().add(stockNum));
						stockDb.setUpdatedUserId(sessionContent.getUserId());
						stockDb.setUpdatedAt(new Date());
						order.setIsCancelled(IS_CANCELLED);
						order.setVersion(order.getVersion());
						orderService.updateStockByPkAndOrderAndCash(stockDb, order, cash);
						Stock stockAfter = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
						logger.info("オーダー登録画面で在庫マスタ情報を更新する。在庫を回復後：「注文パターン：" + order.getOrderPattern() + "、注文ID："
								+ order.getOrderId() + "、ITEM：" + item + "、生地品番：" + order.getProductFabricNo()
								+ "、理論在庫：" + stockAfter.getTheoreticalStock() + "、予約生地量："
								+ stockAfter.getReservationStock() + "」");
					} else {
						// 取り消しフラグ:0
						order.setIsCancelled(IS_CANCELLED);
						order.setVersion(order.getVersion());
						orderService.updateOrderAndCash(order, cash);
					}
				}
			}

			model.addAttribute("isUpdate", IS_UPDATE3);
		} else {
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
	public Map<String, String> standardMateSelect(String itemCode, String subItemCode, String mateChecked,
			String orderPattern, String optionCode) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getStandardButtons(itemCode, subItemCode,
				mateChecked, orderPattern, optionCode);
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
	public Map<String, String> tuxdoMateSelect(String itemCode, String subItemCode, String mateChecked,
			String orderPattern) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getTuxedoButtons(itemCode, subItemCode,
				mateChecked, orderPattern);
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
	public Map<String, String> washabiMateSelect(String itemCode, String subItemCode, String mateChecked,
			String orderPattern) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getWashableButtons(itemCode, subItemCode,
				mateChecked, orderPattern);
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
		OrderFindFabric orderFindFabric = findStock(productFabricNo, orderPattern);
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

	@RequestMapping(value = "/goToJacketOption", method = RequestMethod.GET)
	public @ResponseBody ModelAndView jacketStandardJsp(OrderForm orderForm, ModelAndView m) {
		String orderFlag = orderForm.getOrderFlag();
		String productItem = orderForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				JACKET_SUBITEM);
		orderHelper.getJacketModelMap(orderForm, modelList);
		
		if("orderCo".equals(orderFlag)) {
			String itemFlag = orderForm.getJacketItemFlag();
			if ("0".equals(itemFlag)) {
				orderHelper.jacketDefaultValue(orderForm);
			} else if ("1".equals(itemFlag)) {

			}
		}else if("orderLink".equals(orderFlag)) {
			String itemFlag = orderForm.getJacketItemFlag();
			if ("0".equals(itemFlag)) {
				Order orderJK = orderListService.findOrderJkOptionByOrderId(orderForm.getCustomerMessageInfo().getOrderId());
				//フロント釦数
				String jkFrtBtnCd = orderJK.getJkFrtBtnCd();
				//ラペルデザイン
				String jkLapelDesignCd = orderJK.getJkLapelDesignCd();
				//裏仕様
				String jkInnerClothCd = orderJK.getJkInnerClothCd();
				if((jkFrtBtnCd == null||"".equals(jkFrtBtnCd))&&(jkLapelDesignCd == null||"".equals(jkLapelDesignCd))&&
				   (jkInnerClothCd == null||"".equals(jkInnerClothCd))) {
					orderHelper.jacketDefaultValue(orderForm);
				}else {
					orderHelper.jacketDefaultValueFromDb(orderForm,orderJK);
				}
			}else {
				
			}
			
			
		}
		
		
		m.addObject("orderForm", orderForm);
		m.setViewName("order/orderJsp/optionJacket");

		return m;

	}

	@RequestMapping(value = "/goToPants1Option", method = RequestMethod.GET)
	public @ResponseBody ModelAndView pantsStandardJsp(OrderForm orderForm, ModelAndView m) {
		String itemFlag = orderForm.getPantsItemFlag();
		String productItem = orderForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				PANTS_SUBITEM);
		orderHelper.getPantsModelMap(orderForm, modelList);
		if ("0".equals(itemFlag)) {
			orderHelper.pantsDefaultValue(orderForm);
		} else if ("1".equals(itemFlag)) {

		}
		m.addObject("orderForm", orderForm);
		m.setViewName("order/orderJsp/optionPants1");

		return m;

	}

	@RequestMapping(value = "/goToPants2Option", method = RequestMethod.GET)
	public @ResponseBody ModelAndView pants2StandardJsp(OrderForm orderForm, ModelAndView m) {
		String itemFlag = orderForm.getPantsItemFlag();
		String productItem = orderForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				PANTS2_SUBITEM);
		orderHelper.getPants2ModelMap(orderForm, modelList);
		if ("0".equals(itemFlag)) {
			orderHelper.pants2DefaultValue(orderForm);
		} else if ("1".equals(itemFlag)) {

		}
		m.addObject("orderForm", orderForm);
		m.setViewName("order/orderJsp/optionPants2");

		return m;

	}

	@RequestMapping(value = "/goToGiletOption", method = RequestMethod.GET)
	public @ResponseBody ModelAndView giletStandardJsp(OrderForm orderForm, ModelAndView m) {
		String productItem = orderForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				GILET_SUBITEM);
		orderHelper.getGiletModelMap(orderForm, modelList);

		String itemFlag = orderForm.getGiletItemFlag();
		if ("0".equals(itemFlag)) {
			orderHelper.giletDefaultValue(orderForm);
		} else if ("1".equals(itemFlag)) {

		}
		m.addObject("orderForm", orderForm);
		m.setViewName("order/orderJsp/optionGilet");

		return m;

	}

	@RequestMapping(value = "/goToShirtOption", method = RequestMethod.GET)
	public @ResponseBody ModelAndView shirtStandardJsp(OrderForm orderForm, ModelAndView m) {
		String itemFlag = orderForm.getShirtItemFlag();
		String productItem = orderForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				SHIRT_SUBITEM);
		orderHelper.getShirtModelMap(orderForm, modelList);
		if ("0".equals(itemFlag)) {
			orderHelper.shirtDefaultValue(orderForm);
		} else if ("1".equals(itemFlag)) {

		}
		m.addObject("orderForm", orderForm);
		m.setViewName("order/orderJsp/optionShirt");

		return m;

	}

	@RequestMapping(value = "/goToCoatOption", method = RequestMethod.GET)
	public @ResponseBody ModelAndView coatStandardJsp(OrderForm orderForm, ModelAndView m) {
		String productItem = orderForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				COAT_SUBITEM);
		orderHelper.getCoatModelMap(orderForm, modelList);
		String itemFlag = orderForm.getCoatItemFlag();
		if ("0".equals(itemFlag)) {
			orderHelper.coatDefaultValue(orderForm);
		} else if ("1".equals(itemFlag)) {

		}
		m.addObject("orderForm", orderForm);
		m.setViewName("order/orderJsp/optionCoat");

		return m;

	}

	@RequestMapping(value = "/saveOptionData", method = RequestMethod.POST)
	@ResponseBody
	public void saveOptionData(OrderForm orderForm) {

	}

	@ResponseBody
	@RequestMapping(value = "getCoTypeSizeOptimization", method = RequestMethod.GET)
	public List<TypeSizeOptimization> getCoTypeSizeOptimization(String orderPattern, String subItemCode,
			String modelCode, String figure, String number) {
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> poTypeSizeOptimization = orderHelper.getPoTypeSizeOptimization(coTypeSizeList);
		return poTypeSizeOptimization;
	}

	@RequestMapping(value = "/jacketJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView jacketJsp(OrderForm orderForm, ModelAndView m) {
		m.addObject("orderForm", orderForm);
		m.setViewName("order/coAdjustJsp/jacketAdjust");

		return m;

	}

	@RequestMapping(value = "/pantsJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView pantsJsp(OrderForm orderForm, ModelAndView m) {

		m.addObject("orderForm", orderForm);
		m.setViewName("order/coAdjustJsp/pantsAdjust");

		return m;

	}

	@RequestMapping(value = "/pants2Jsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView pants2Jsp(OrderForm orderForm, ModelAndView m) {

		m.addObject("orderForm", orderForm);
		m.setViewName("order/coAdjustJsp/pants2Adjust");

		return m;

	}

	@RequestMapping(value = "/giletJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView giletJsp(OrderForm orderForm, ModelAndView m) {

		m.addObject("orderForm", orderForm);
		m.setViewName("order/coAdjustJsp/giletAdjust");

		return m;

	}

	@RequestMapping(value = "/shirtJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView shirtJsp(OrderForm orderForm, ModelAndView m) {

		m.addObject("orderForm", orderForm);
		m.setViewName("order/coAdjustJsp/shirtAdjust");

		return m;

	}

	@RequestMapping(value = "/coatJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView coatJsp(OrderForm orderForm, ModelAndView m) {

		m.addObject("orderForm", orderForm);
		m.setViewName("order/coAdjustJsp/coatAdjust");

		return m;

	}

	@ResponseBody
	@RequestMapping(value = "getOrderPrice", method = RequestMethod.GET)
	public String getOrderPrice(String code, String codeDetail, OrderForm orderForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderDetailKeyCode = orderCodePrice.getOrderDetailKeyCode();
			String orderBranchPrice = orderCodePrice.getOrderBranchPrice();
			String orderBranchDetailPrice = orderCodePrice.getOrderBranchDetailPrice();
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
	public String getOrderNormalPrice(String code, String codeDetail, OrderForm orderForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderForm.getOrderCodePriceList();
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
	public void jacketAdjustFormDb(OrderForm orderForm) {
		Order order = orderListService.findOrderJkByPk(orderForm.getCustomerMessageInfo().getOrderId());
		orderHelper.jacketAdjustFormDb(orderForm,order);
	}

	@RequestMapping(value = "/pantsAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void pantsAdjustFormDb(OrderForm orderForm) {
		Order order = orderListService.findOrderPtByPk(orderForm.getCustomerMessageInfo().getOrderId());
		orderHelper.pantsAdjustFormDb(orderForm,order);
	}

	@RequestMapping(value = "/pants2AdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void pants2AdjustFormDb(OrderForm orderForm) {
		Order order = orderListService.findOrderPt2ByPk(orderForm.getCustomerMessageInfo().getOrderId());
		orderHelper.pants2AdjustFormDb(orderForm,order);
	}

	@RequestMapping(value = "/giletAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void giletAdjustFormDb(OrderForm orderForm) {
		Order order = orderListService.findOrderGlByPk(orderForm.getCustomerMessageInfo().getOrderId());
		orderHelper.giletAdjustFormDb(orderForm,order);
	}

	@RequestMapping(value = "/shirtAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void shirtAdjustFormDb(OrderForm orderForm) {
		Order order = orderListService.findOrderStByPk(orderForm.getCustomerMessageInfo().getOrderId());
		orderHelper.shirtAdjustFormDb(orderForm,order);
	}

	@RequestMapping(value = "/coatAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void coatAdjustFormDb(OrderForm orderForm) {
		Order order = orderListService.findOrderCtByPk(orderForm.getCustomerMessageInfo().getOrderId());
		orderHelper.coatAdjustFormDb(orderForm,order);
	}

}
