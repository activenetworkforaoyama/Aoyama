package co.jp.aoyama.macchinetta.app.order;

import java.math.BigDecimal;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import co.jp.aoyama.macchinetta.app.order.info.CustomerMessageInfo;
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
@RequestMapping("/order")
@SessionAttributes(value = { "orderForm" })
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
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

	// private OrderForm orderForm = new OrderForm();

	private final String poType = "PO";

	private final String coType = "CO";

	// チェックなし
	private final String isNotTheoreticalStockCheck = "0";

	// チェックあり
	private final String isTheoreticalStockCheck = "1";

	// TSCステータス 一時保存
	private final String tscStatusT0 = "T0";

	// TSCステータス 取り置き
	private final String tscStatusT1 = "T1";

	// 取り消しフラグ 取り消しではない
	private final String isNotCancelled = "0";

	// 取り消しフラグ 取り消し
	private final String isCancelled = "1";

	// 会計ステータス 会計取消
	private final String cashStatus02 = "02";

	// 会計ステータス 会計再確認要
	private final String cashStatus03 = "03";

	// オーダー更新
	private final String isUpdate1 = "1";

	// 注文削除
	private final String isUpdate2 = "2";

	// 注文取消
	private final String isUpdate3 = "3";

	// 工場ステータス 生産開始前
	private final String factoryStatus0 = "F0";

	// 工場自動連携ステータス 送信前
	private final String send2factoryStatus0 = "0";

	@ModelAttribute(value = "orderForm")
	public OrderForm setupForm() {
		return new OrderForm();
	}

	@RequestMapping("orderCo")
	public String toOrderCo(HttpServletRequest request) {
		try {
			OrderForm orderForm = (OrderForm) request.getSession().getAttribute("orderForm");
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(coType);
			List<OptionBranch> tuxedoOptionList = optionBranchService.getTuxedoOption(coType);
			List<OptionBranch> washableOptionList = optionBranchService.getWashableOption(coType);

			orderHelper.getOptionStandardData(standardOptionList, orderForm);
			orderHelper.getOptionTuxedoData(tuxedoOptionList, orderForm);
			orderHelper.getOptionWashableData(washableOptionList, orderForm);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/orderCoForm";
	}

	/**
	 * PO画面初期化
	 * 
	 * @param model
	 * @param req
	 * 
	 */
	@RequestMapping(value = "orderPo")
	public String toOrderPo(SessionStatus sessionStatus, OrderForm orderForm, Model model) {
		// sessionStatus.setComplete();
		try {
			// 注文ID
			String orderId = null;
			// 店舗コード
			String belongCode = sessionContent.getBelongCode();
			String maxOrderId = orderService.selectMaxOrderId(belongCode, poType);
			if (maxOrderId == null) {
				orderId = belongCode + "00000001";
			} else {
				long parseLong = Long.parseLong(maxOrderId) + 1;
				orderId = String.format("%012d", parseLong);
			}

			CustomerMessageInfo customerMessageInfo = new CustomerMessageInfo();
			customerMessageInfo.setOrderId(orderId);
			orderForm.setCustomerMessageInfo(customerMessageInfo);
			orderForm.setAuthority(sessionContent.getAuthority());

			// オプションデーターを取得
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(poType);
			// 補正:体型を取得
			List<SizeFigure> figureList = sizeFigureService.getFigureList(poType);
			// 補正:号数を取得
			List<SizeNumber> numberList = sizeNumberService.getNumberList(poType);
			// 補正を取得
			List<Adjust> adjustList = adjustService.getAllAdjust(poType);
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(poType);
			// モデルを取得
			List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getAllModel(poType);
			// 要尺を取得
			List<Yield> yieldList = yieldService.getYield();
			// 消費税を取得
			Date date = new Date();
			int taxRate = consumptionService.getTaxRate(date);

			// List<OrderPrice> priceList = orderService.getOrderPrice(poType);

			orderHelper.getOptionStandardData(standardOptionList, orderForm);
			orderHelper.getFigureNumberMap(figureList, numberList, orderForm);
			orderHelper.getAdjust(adjustList, orderForm);
			orderHelper.getItem(itemList, orderForm);
			orderHelper.getModel(modelList, orderForm);
			orderHelper.getTaxRate(taxRate, orderForm);
			orderHelper.getYield(yieldList, orderForm);
			// orderHelper.optionBranchPriceData(priceList,orderForm);
			String orderFlag = "orderPo";
			orderForm.setOrderFlag(orderFlag);
			orderForm.setStatus("");
			// 初期化のとき注文 データを挿入
			Order orderNew = new Order();
			// 注文ID
			orderNew.setOrderId(orderId);
			// オーダーパターン
			orderNew.setOrderPattern(poType);
			// 業態
			orderNew.setStoreBrandCode(sessionContent.getStoreBrandCode());
			// 店舗コード
			orderNew.setShopCode(belongCode);
			// 理論在庫チェック
			orderNew.setTheoreticalStockCheck(isNotTheoreticalStockCheck);
			// 工場ステータス
			orderNew.setMakerFactoryStatus(factoryStatus0);
			// 取り消しフラグ
			orderNew.setIsCancelled(isNotCancelled);
			// 工場自動連携ステータス
			orderNew.setSend2factoryStatus(send2factoryStatus0);
			orderNew.setCreatedUserId(sessionContent.getUserId());
			orderNew.setCreatedAt(new Date());
			orderNew.setUpdatedAt(new Date());
			orderNew.setUpdatedUserId(sessionContent.getUserId());
			orderService.insertOrder(orderNew);

			// 初期化のときメジャーリング データを挿入
			Measuring measuring = new Measuring();
			measuring.setOrderId(orderId);
			measuring.setCreatedAt(new Date());
			measuring.setCreatedUserId(sessionContent.getUserId());
			measuring.setUpdatedAt(new Date());
			measuring.setUpdatedUserId(sessionContent.getUserId());
			measuringService.insertMeasuring(measuring);

			model.addAttribute("orderFlag", "");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return "order/orderPoForm";
	}

	@RequestMapping(value = "orderPoUpdate")
	public String toOrderPoUpdate(Model model, OrderForm orderForm, SessionStatus sessionStatus) {
		// sessionStatus.setComplete();
		try {
			orderForm.setAuthority(sessionContent.getAuthority());

			// オプションデーターを取得
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(poType);
			// 補正:体型を取得
			List<SizeFigure> figureList = sizeFigureService.getFigureList(poType);
			// 補正:号数を取得
			List<SizeNumber> numberList = sizeNumberService.getNumberList(poType);
			// 補正を取得
			List<Adjust> adjustList = adjustService.getAllAdjust(poType);
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(poType);
			// モデルを取得
			List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getAllModel(poType);
			// 要尺を取得
			List<Yield> yieldList = yieldService.getYield();
			// 消費税を取得
			Date date = new Date();
			int taxRate = consumptionService.getTaxRate(date);

			orderHelper.getOptionStandardData(standardOptionList, orderForm);
			orderHelper.getFigureNumberMap(figureList, numberList, orderForm);
			orderHelper.getAdjust(adjustList, orderForm);
			orderHelper.getItem(itemList, orderForm);
			orderHelper.getModel(modelList, orderForm);
			orderHelper.getTaxRate(taxRate, orderForm);
			orderHelper.getYield(yieldList, orderForm);
			orderForm.setOrderFlag("");
			orderForm.setStatus("");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/orderPoForm";
	}

	@RequestMapping(value = "orderPoBack")
	public String orderPoBack(HttpServletRequest request, OrderForm orderForm, Model model) {
		// OrderForm orderForm =
		// (OrderForm)request.getSession().getAttribute("orderForm");
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

		// 素材品番のMapを取得
		List<OptionBranchDetail> detailList = optionBranchDeailService.getAllOption(poType);
		orderHelper.dealWithDetailCode(orderForm, detailList);

		// 店舗を取得
		List<Shop> shopList = shopService.findAllShop();

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
	public String orderPoEntry(OrderForm orderForm, Model model, SessionStatus sessionStatus) {
		// 注文ID
		String orderId = orderForm.getCustomerMessageInfo().getOrderId();
		// 注文を取得
		Order order = orderListService.findOrderByPk(orderId);
		orderHelper.dealWithCorrectAgain(orderForm, order, sessionContent.getUserId());
		orderService.updateOrder(order);
		model.addAttribute("isUpdate", isUpdate1);
		sessionStatus.setComplete();
		return "order/orderPoLoginResultForm";
	}

	/**
	 * 物理削除した「オーダー一覧」へ遷移する。
	 * 
	 * @param orderId
	 * 
	 */
	@RequestMapping(value = "/physicalDelete/{orderId}", method = RequestMethod.GET)
	public String physicalDelete(@PathVariable(value = "orderId") String orderId, Model model) {
		// 注文IDによって 注文を取得
		Order order = orderListService.findOrderByPk(orderId);
		// tscステータスが無しの場合 注文物理削除
		if ("".equals(order.getTscStatus()) || order.getTscStatus() == null) {
			if (isNotTheoreticalStockCheck.equals(order.getTheoreticalStockCheck())) {
				orderService.deletOrderByOrderId(orderId);
				measuringService.deleteByOrderId(orderId);
			}else if(isTheoreticalStockCheck.equals(order.getTheoreticalStockCheck())) {
				// 生地の論理在庫を戻る
				Stock stock = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
				BigDecimal reservationStock = stock.getReservationStock();
				BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
				stock.setReservationStock(reservationStock.subtract(theoryFabricUsedMount));
				stock.setUpdatedUserId(sessionContent.getUserId());
				stock.setUpdatedAt(new Date());
				orderService.updateStockByPk(stock);
				orderService.deletOrderByOrderId(order.getOrderId());
				measuringService.deleteByOrderId(order.getOrderId());
			}
			
		} else {
			// tscステータスが「一時保存、取り置き」の場合、物理削除
			if (tscStatusT0.equals(order.getTscStatus()) || tscStatusT1.equals(order.getTscStatus())) {
				// 理論在庫チェックなしの場合
				if (isNotTheoreticalStockCheck.equals(order.getTheoreticalStockCheck())) {
					orderService.deletOrderByOrderId(orderId);
					measuringService.deleteByOrderId(orderId);
					// 理論在庫チェックありの場合
				} else if (isTheoreticalStockCheck.equals(order.getTheoreticalStockCheck())) {
					// 生地の論理在庫を戻る
					Stock stock = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
					BigDecimal reservationStock = stock.getReservationStock();
					BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
					stock.setReservationStock(reservationStock.subtract(theoryFabricUsedMount));
					stock.setUpdatedUserId(sessionContent.getUserId());
					stock.setUpdatedAt(new Date());
					orderService.updateStockByPk(stock);
					orderService.deletOrderByOrderId(order.getOrderId());
					measuringService.deleteByOrderId(order.getOrderId());
				}
			}
		}
		model.addAttribute("isUpdate", isUpdate2);
		return "order/orderPoLoginResultForm";
	}

	/**
	 * 論理削除した「オーダー一覧」へ遷移する。
	 * 
	 * @param orderId
	 * 
	 */
	@RequestMapping(value = "/logicalDeletion/{orderId}", method = RequestMethod.GET)
	public String logicalDeletion(@PathVariable(value = "orderId") String orderId, Model model) {

		Order order = orderListService.findOrderByPk(orderId);
		String cashId = order.getCashId();
		// 会計IDが有りの場合
		if (!"".equals(cashId) && cashId != null) {
			int cashCount = orderService.getSameCash(cashId);
			// 該当会計ID一つの場合
			if (cashCount == 1) {
				// ステータスは「会計取消」を設定する
				Cash cash = cashService.selectByPrimaryKey(order.getCashId());
				cash.setCashStatus(cashStatus02);
				cashService.updateCash(cash);
			} else {
				// ステータスは「会計再確認要」を設定する
				Cash cash = cashService.selectByPrimaryKey(order.getCashId());
				cash.setCashStatus(cashStatus03);
				cashService.updateCash(cash);
			}
		}

		if (!"".equals(order.getProductFabricNo()) || order.getProductFabricNo() != null) {
			// 生地の論理在庫を戻る
			BigDecimal stockNum = order.getTheoryFabricUsedMount();
			Stock stockDb = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
			stockDb.setTheoreticalStock(stockDb.getTheoreticalStock().add(stockNum));
			stockDb.setUpdatedUserId(sessionContent.getUserId());
			stockDb.setUpdatedAt(new Date());
			orderService.updateStockByPk(stockDb);
		}
		//取り消しフラグ:0
		order.setIsCancelled(isCancelled);
		orderService.updateOrder(order);
		model.addAttribute("isUpdate", isUpdate3);
		return "order/orderPoLoginResultForm";
	}

	/**
	 * 一時保存、取り置き
	 * 
	 * @param orderForm
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "orderPoLogOn", method = RequestMethod.GET)
	public String orderPoLogOn(OrderForm orderForm) {
		Order order = new Order();
		Measuring measuring = new Measuring();
		beanMapper.map(orderForm.getOptionJacketStandardInfo(), order);
		beanMapper.map(orderForm.getAdjustJacketStandardInfo(), order);
		beanMapper.map(orderForm.getOptionPantsStandardInfo(), order);
		beanMapper.map(orderForm.getAdjustPantsStandardInfo(), order);
		orderHelper.setProductItemDisplayCode(orderForm, order);
		orderHelper.measuringMapping(orderForm, measuring);
		// orderFormの対象とorderの対応フィールドのマッピング
		beanMapper.map(orderForm.getCustomerMessageInfo(), order);
		beanMapper.map(orderForm, order);

		Order orderIsExist = orderListService.findOrderByPk(order.getOrderId());
		order.setCreatedAt(orderIsExist.getCreatedAt());
		order.setCreatedUserId(orderIsExist.getCreatedUserId());
		order.setUpdatedAt(new Date());
		order.setUpdatedUserId(sessionContent.getUserId());
		order.setSend2factoryStatus(orderIsExist.getSend2factoryStatus());
		order.setMakerFactoryStatus(orderIsExist.getMakerFactoryStatus());
		// 取り消しフラグ
		order.setIsCancelled(orderIsExist.getIsCancelled());
		orderService.deletOrderByOrderId(order.getOrderId());
		measuringService.deleteByOrderId(order.getOrderId());
		order.setTheoreticalStockCheck(isNotTheoreticalStockCheck);
		orderService.insertOrder(order);
		measuringService.insertMeasuring(measuring);

		return "true";
	}

	/**
	 * 生地チェク完了在庫を計算
	 * @param orderForm
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "stockDecrease", method = RequestMethod.GET)
	public String stockDecrease(OrderForm orderForm) {
		Order order = new Order();

		Measuring measuring = new Measuring();

		Order orderIsExist = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
		
		orderFormToOrder(orderForm, order, measuring, orderIsExist);
		
		stockCheck(order, orderIsExist, measuring);

		return "true";
	}
	
	/**
	 * 一時保存、取り置き、自動保存
	 * @param orderForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "orderPoTemporarySave", method = RequestMethod.GET)
	public String orderPoTemporarySave(OrderForm orderForm) {
		
		Order order = new Order();

		Measuring measuring = new Measuring();

		Order orderIsExist = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
		
		orderFormToOrder(orderForm, order, measuring, orderIsExist);
		
		orderService.deletOrderByOrderId(order.getOrderId());
		
		orderService.insertOrder(order);

		return "true";
	}
	

	/**
	 * 
	 * 
	 * @param orderForm
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "stockRecovery", method = RequestMethod.GET)
	public void stockRecovery(String orderId) {
		Order order = orderListService.findOrderByPk(orderId);
		if (isTheoreticalStockCheck.equals(order.getTheoreticalStockCheck())) {
			BigDecimal stockNum = order.getTheoryFabricUsedMount();
			Stock stockDb = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
			BigDecimal reservationStock = stockDb.getReservationStock();
			stockDb.setReservationStock(reservationStock.subtract(stockNum));
			stockDb.setUpdatedUserId(sessionContent.getUserId());
			stockDb.setUpdatedAt(new Date());
			orderService.updateStockByPk(stockDb);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "stockErrorRecovery", method = RequestMethod.GET)
	public void stockErrorRecovery(String orderId) {
		Order order = orderListService.findOrderByPk(orderId);
		if (isTheoreticalStockCheck.equals(order.getTheoreticalStockCheck())) {
			BigDecimal stockNum = order.getTheoryFabricUsedMount();
			Stock stockDb = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
			BigDecimal reservationStock = stockDb.getReservationStock();
			stockDb.setReservationStock(reservationStock.add(stockNum));
			stockDb.setUpdatedUserId(sessionContent.getUserId());
			stockDb.setUpdatedAt(new Date());
			orderService.updateStockByPk(stockDb);
		}
	}

	private void orderFormToOrder(OrderForm orderForm, Order order, Measuring measuring, Order orderIsExist) {
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

		orderHelper.setProductItemDisplayCode(orderForm, order);
		orderHelper.orderMappingLogOn(orderForm, order, sessionContent.getUserId());
		orderHelper.measuringMapping(orderForm, measuring);

		// orderFormの対象とorderの対応フィールドのマッピング
		beanMapper.map(orderForm.getCustomerMessageInfo(), order);
		beanMapper.map(orderForm, order);

		// 更新の場合
		order.setCreatedAt(orderIsExist.getCreatedAt());
		order.setCreatedUserId(orderIsExist.getCreatedUserId());
		order.setSend2factoryStatus(orderIsExist.getSend2factoryStatus());
		order.setTheoreticalStockCheck(orderIsExist.getTheoreticalStockCheck());
		
		// 保存flag
		if ("1".equals(orderForm.getSaveFlag())) {
			String tscStatus = orderIsExist.getTscStatus();
			if ("".equals(tscStatus) || tscStatus == null) {
				order.setTscStatus(tscStatusT0);
			} else {
				order.setTscStatus(tscStatus);
			}
		}
		if ("2".equals(orderForm.getSaveFlag())) {
			String tscStatus = orderIsExist.getTscStatus();
			if ("".equals(tscStatus) || tscStatus == null) {
				order.setTscStatus("");
			} else {
				order.setTscStatus(tscStatus);
			}
		}

	}

	/**
	 * 理論在庫チェック
	 * 
	 * @param orderForm
	 * @param order
	 * @param measuring
	 */
	private void stockCheck(Order order, Order orderIsExist, Measuring measuring) {

		// 理論在庫チェック値を取得
		String isCheck = orderIsExist.getTheoreticalStockCheck();
		// 理論在庫チェック値が0の場合
		if (isNotTheoreticalStockCheck.equals(isCheck)) {
			if("".equals(order.getProductFabricNo())||order.getProductFabricNo()==null){
				order.setTheoreticalStockCheck(isNotTheoreticalStockCheck);
				orderService.deletOrderByOrderId(order.getOrderId());
				measuringService.deleteByOrderId(order.getOrderId());
				orderService.insertOrder(order);
				measuringService.insertMeasuring(measuring);
			}else {
				Stock stock = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
				BigDecimal reservationStock = stock.getReservationStock();
				BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
				stock.setReservationStock(reservationStock.add(theoryFabricUsedMount));
				stock.setUpdatedUserId(sessionContent.getUserId());
				stock.setUpdatedAt(new Date());
				orderService.updateStockByPk(stock);

				order.setTheoreticalStockCheck(isTheoreticalStockCheck);
				orderService.deletOrderByOrderId(order.getOrderId());
				measuringService.deleteByOrderId(order.getOrderId());
				orderService.insertOrder(order);
				measuringService.insertMeasuring(measuring);
			}
			// 理論在庫チェック値が１の場合
		} else if (isTheoreticalStockCheck.equals(isCheck)) {
			
			if("".equals(order.getProductFabricNo())||order.getProductFabricNo()==null){

				orderService.deletOrderByOrderId(order.getOrderId());
				measuringService.deleteByOrderId(order.getOrderId());
				order.setTheoreticalStockCheck(isNotTheoreticalStockCheck);
				orderService.insertOrder(order);
				measuringService.insertMeasuring(measuring);
			}else {
				Stock stock = orderService.getStock(order.getProductFabricNo(), order.getOrderPattern());
				BigDecimal reservationStock = stock.getReservationStock();
				BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
				stock.setReservationStock(reservationStock.add(theoryFabricUsedMount));
				stock.setUpdatedUserId(sessionContent.getUserId());
				stock.setUpdatedAt(new Date());
				orderService.updateStockByPk(stock);

				orderService.deletOrderByOrderId(order.getOrderId());
				measuringService.deleteByOrderId(order.getOrderId());
				order.setTheoreticalStockCheck(isTheoreticalStockCheck);
				orderService.insertOrder(order);
				measuringService.insertMeasuring(measuring);
			}
		}
	}

	/**
	 * 生地品番とオーダーパターンによって生地の情報を取得
	 * 
	 * @param fabricNo
	 * @param orderPattern
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "findStock")
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
	@RequestMapping(value = "standardMateSelect", method = RequestMethod.POST)
	public Map<String, String> standardMateSelect(String itemCode, String mateChecked, String orderPattern,
			String optionCode) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getStandardButtons(itemCode, mateChecked,
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
	@RequestMapping(value = "tuxdoMateSelect", method = RequestMethod.POST)
	public Map<String, String> tuxdoMateSelect(String itemCode, String mateChecked, String orderPattern) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getTuxedoButtons(itemCode, mateChecked,
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
	@RequestMapping(value = "washabiMateSelect", method = RequestMethod.POST)
	public Map<String, String> washabiMateSelect(String itemCode, String mateChecked, String orderPattern) {
		List<OptionBranchDetail> mateList = optionBranchDeailService.getWashableButtons(itemCode, mateChecked,
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
		List<Shop> shopList = shopService.findAllShop();
		List<ShopForm> shopFormList = new ArrayList<ShopForm>();
		for (Shop shop : shopList) {
			ShopForm shopForm = beanMapper.map(shop, ShopForm.class);
			shopFormList.add(shopForm);
		}
		return shopFormList;
	}

	/**
	 * 
	 * 補正型サイズを取得
	 */
	@ResponseBody
	@RequestMapping(value = "getPoTypeSize", method = RequestMethod.GET)
	public List<TypeSizeForm> getPoTypeSize(String orderPattern) {
		List<TypeSize> poTypeSizeList = typeSizeService.getPoTypeSize(orderPattern);
		List<TypeSizeForm> typeSizeFormList = orderHelper.getPoTypeSizeList(poTypeSizeList);
		return typeSizeFormList;
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
}
