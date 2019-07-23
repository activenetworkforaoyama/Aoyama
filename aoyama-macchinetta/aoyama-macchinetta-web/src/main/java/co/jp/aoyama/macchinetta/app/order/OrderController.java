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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

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
	
	private static final String PO_TYPE = "PO";

	private static final String CO_TYPE = "CO";

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
	
	//注文情報が変更されています。もう一度、オーダー一覧へ戻って最新の注文情報を選んでください。
	private static final String IS_UPDATE6 = "6";
	
	// 工場ステータス 生産開始前
	private static final String FACTORY_STATUSF0 = "F0";

	// 工場自動連携ステータス 送信前
	private static final String SEND2FACTORY_STATUS0 = "0";

	@ModelAttribute(value = "orderForm")
	public OrderForm setupForm() {
		return new OrderForm();
	}

	@RequestMapping("orderCo")
	public String toOrderCo(HttpServletRequest request) {
		try {
			OrderForm orderForm = (OrderForm) request.getSession().getAttribute("orderForm");
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(CO_TYPE);
			List<OptionBranch> tuxedoOptionList = optionBranchService.getTuxedoOption(CO_TYPE);
			List<OptionBranch> washableOptionList = optionBranchService.getWashableOption(CO_TYPE);

			orderHelper.getOptionStandardData(standardOptionList, orderForm);
			orderHelper.getOptionTuxedoData(tuxedoOptionList, orderForm);
			orderHelper.getOptionWashableData(washableOptionList, orderForm);

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return "order/orderCoForm";
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
			// 注文ID
			String orderId = null;
			// 店舗コード
			String belongCode = sessionContent.getBelongCode();
			String orderIdCheckCd = belongCode.concat(ONE);
			String maxOrderId = orderService.selectMaxOrderId(orderIdCheckCd, PO_TYPE);
			if (maxOrderId == null) {
				orderId = belongCode.concat(MIN_CODE);
			} else {
				long parseLong = Long.parseLong(maxOrderId) + 1;
				orderId = String.format("%012d", parseLong);
			}

			CustomerMessageInfo customerMessageInfo = new CustomerMessageInfo();
			customerMessageInfo.setOrderId(orderId);
			orderForm.setCustomerMessageInfo(customerMessageInfo);
			orderForm.setAuthority(sessionContent.getAuthority());

			// オプションデーターを取得
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(PO_TYPE);
			// 補正:体型を取得
			List<SizeFigure> figureList = sizeFigureService.getFigureList(PO_TYPE);
			// 補正:号数を取得
			List<SizeNumber> numberList = sizeNumberService.getNumberList(PO_TYPE);
			// 補正を取得
			List<Adjust> adjustList = adjustService.getAllAdjust(PO_TYPE);
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(PO_TYPE);
			// モデルを取得
			List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getAllModel(PO_TYPE);
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
			
			//登録フラッグ
			String orderFlag = "orderPo";
			orderForm.setOrderFlag(orderFlag);
			
			orderForm.setStatus("");
			// 初期化のとき注文 データを挿入
			Order orderNew = new Order();
			// 注文ID
			orderNew.setOrderId(orderId);
			// オーダーパターン
			orderNew.setOrderPattern(PO_TYPE);
			// 業態
			orderNew.setStoreBrandCode(sessionContent.getStoreBrandCode());
			// 店舗コード
			orderNew.setShopCode(belongCode);
			// 理論在庫チェック
			orderNew.setTheoreticalStockCheck(IS_NOT_THEORETICAL_STOCKCECK);
			// 工場ステータス
			orderNew.setMakerFactoryStatus(FACTORY_STATUSF0);
			// 取り消しフラグ
			orderNew.setIsCancelled(IS_NOT_CANCELLED);
			// 工場自動連携ステータス
			orderNew.setSend2factoryStatus(SEND2FACTORY_STATUS0);
			orderNew.setCreatedUserId(sessionContent.getUserId());
			orderNew.setCreatedAt(new Date());
			orderNew.setUpdatedAt(new Date());
			orderNew.setUpdatedUserId(sessionContent.getUserId());
			orderNew.setVersion((short)0);
			orderService.insertOrder(orderNew);

			// 初期化のときメジャーリング データを挿入
			Measuring measuring = new Measuring();
			measuring.setOrderId(orderId);
			measuring.setCreatedAt(new Date());
			measuring.setCreatedUserId(sessionContent.getUserId());
			measuring.setUpdatedAt(new Date());
			measuring.setUpdatedUserId(sessionContent.getUserId());
			orderService.insertMeasuring(measuring);

			model.addAttribute("orderFlag", "");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return "order/orderPoForm";
	}

	@RequestMapping(value = "orderPoUpdate")
	public String toOrderPoUpdate(Model model, OrderForm orderForm) {
		try {
			orderForm.setAuthority(sessionContent.getAuthority());

			// オプションデーターを取得
			List<OptionBranch> standardOptionList = optionBranchService.getStandardOption(PO_TYPE);
			// 補正:体型を取得
			List<SizeFigure> figureList = sizeFigureService.getFigureList(PO_TYPE);
			// 補正:号数を取得
			List<SizeNumber> numberList = sizeNumberService.getNumberList(PO_TYPE);
			// 補正を取得
			List<Adjust> adjustList = adjustService.getAllAdjust(PO_TYPE);
			// アイテムを取得
			List<Item> itemList = itemService.getAllItem(PO_TYPE);
			// モデルを取得
			List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getAllModel(PO_TYPE);
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

		Order order = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
		
		orderForm.setVersion(order.getVersion().toString());
		
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
	 * オーダー登録画面読み込み完了のとき、オーダーのデーターを挿入
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
		orderHelper.measuringMapping(orderForm, measuring, sessionContent.getUserId());
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
		order.setProductOrderdDate(new Date());
		order.setVersion(orderIsExist.getVersion());
		// 取り消しフラグ
		order.setIsCancelled(orderIsExist.getIsCancelled());
		// 在庫チェック
		order.setTheoreticalStockCheck(orderIsExist.getTheoreticalStockCheck());
		orderService.updateOrder(order);
		String orderVersion = getOrderVersion(order.getOrderId());
		return orderVersion;
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

		Order orderIsExist = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());

		Measuring measuringIsExist = measuringService
				.selectByPrimaryKey(orderForm.getCustomerMessageInfo().getOrderId());

		// オーダーのデーター → orderForm
		orderFormToOrder(orderForm, order, measuring, orderIsExist, measuringIsExist);
		
		String version = orderForm.getVersion();
		
		order.setVersion(Short.parseShort(version));

		ResultMessages resultMessages = null;
		// 理論在庫チェック、在庫戻る
		try {
			String stockCheck = stockCheck(order, orderIsExist, measuring);
			if("true".equals(stockCheck)) {
				return stockCheck;
			}
		}
		catch(ResourceNotFoundException re) {
			resultMessages = re.getResultMessages();
			logger.error(re.toString());
		}
		
		String codeVa = null;
		
		if(resultMessages!=null) {
			String code = resultMessages.getList().get(0).getCode();
			codeVa =  code.toString();
			if("E023".equals(codeVa)) {
				return "1";
			}else {
				return "2";
			}
		}else {
			codeVa = "0";
			return codeVa;
		}
		
	}

	/**
	 * 一時保存、取り置き、自動保存
	 * 
	 * @param orderForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "orderPoTemporarySave", method = RequestMethod.POST)
	public String orderPoTemporarySave(OrderForm orderForm,Model model) {

		Order order = new Order();

		Measuring measuring = new Measuring();
		
		Order orderIsExist = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
		
		Short version = Short.parseShort(orderForm.getVersion());
		

		Measuring measuringIsExist = measuringService
				.selectByPrimaryKey(orderForm.getCustomerMessageInfo().getOrderId());

		// オーダーのデーター → orderForm
		orderFormToOrder(orderForm, order, measuring, orderIsExist, measuringIsExist);
		
		order.setVersion(version);

		ResultMessages resultMessages = null;
		try {
			orderService.deletOrder(order,version);
			orderService.deleteMeasuring(measuring);
			return "true";
		}catch(ResourceNotFoundException re) {
			resultMessages = re.getResultMessages();
			logger.error(re.toString());
		}
		if(resultMessages!=null) {
			String errorCode = resultMessages.getList().get(0).getCode();
			if("E023".equals(errorCode)) {
				return "1";
			}else {
				return "0";
			}
		}else {
			return "true";
		}
		
	}

	/**
	 * 在庫を戻る
	 * 
	 * @param order
	 */
	private void stockRecovery(Order order) {
		// 在庫チェク成功の場合
		if (IS_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
			BigDecimal stockNum = order.getTheoryFabricUsedMount();
			Stock stockDb = orderService.getStock(order.getProductFabricNo());
			BigDecimal reservationStock = stockDb.getReservationStock();
			stockDb.setReservationStock(reservationStock.subtract(stockNum));
			stockDb.setUpdatedUserId(sessionContent.getUserId());
			stockDb.setUpdatedAt(new Date());
			orderService.updateStockByPk(stockDb);
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
	 * オーダーのデーター → orderForm
	 * 
	 * @param orderForm
	 * @param order
	 * @param measuring
	 * @param orderIsExist
	 */
	private void orderFormToOrder(OrderForm orderForm, Order order, Measuring measuring, Order orderIsExist,
			Measuring measuringIsExist) {
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
		orderHelper.orderMappingLogOn(orderForm, order, sessionContent.getUserId(), orderIsExist,sessionContent.getAuthority());
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
		
		if(order.getVersion().equals(orderIsExist.getVersion())) {
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
					Stock stock = orderService.getStock(order.getProductFabricNo());
					BigDecimal reservationStock = stock.getReservationStock();
					BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
					stock.setReservationStock(reservationStock.add(theoryFabricUsedMount));
					stock.setUpdatedUserId(sessionContent.getUserId());
					stock.setUpdatedAt(new Date());
					order.setTheoreticalStockCheck(IS_THEORETICAL_STOCKCECK);
					orderService.deleteOrderAndStock(order,stock,measuring);
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
					Stock stock = orderService.getStock(order.getProductFabricNo());
					BigDecimal reservationStock = stock.getReservationStock();
					BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
					stock.setReservationStock(reservationStock.add(theoryFabricUsedMount));
					stock.setUpdatedUserId(sessionContent.getUserId());
					stock.setUpdatedAt(new Date());
					order.setTheoreticalStockCheck(IS_THEORETICAL_STOCKCECK);
					orderService.deleteOrderAndStock(order,stock,measuring);
				}
			}
			return "true";
		}else {
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
	public String physicalDelete(String orderId,String version ,Model model) {
		// 注文IDによって 注文を取得
		Order order = orderListService.findOrderByPk(orderId);
		
		String versionDb = String.valueOf(order.getVersion());
		
		if(version.equals(versionDb)) {
			// tscステータスが無しの場合 注文物理削除
			if ("".equals(order.getTscStatus()) || order.getTscStatus() == null) {
				if (IS_NOT_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
					orderService.deleteMeasuringBothOrder(orderId);
				} else if (IS_THEORETICAL_STOCKCECK.equals(order.getTheoreticalStockCheck())) {
					// 生地の論理在庫を戻る
					Stock stock = orderService.getStock(order.getProductFabricNo());
					BigDecimal reservationStock = stock.getReservationStock();
					BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
					stock.setReservationStock(reservationStock.subtract(theoryFabricUsedMount));
					stock.setUpdatedUserId(sessionContent.getUserId());
					stock.setUpdatedAt(new Date());
					orderService.physicalDeleteOrder(stock,orderId);
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
						Stock stock = orderService.getStock(order.getProductFabricNo());
						BigDecimal reservationStock = stock.getReservationStock();
						BigDecimal theoryFabricUsedMount = order.getTheoryFabricUsedMount();
						stock.setReservationStock(reservationStock.subtract(theoryFabricUsedMount));
						stock.setUpdatedUserId(sessionContent.getUserId());
						stock.setUpdatedAt(new Date());
						orderService.physicalDeleteOrder(stock,orderId);
					}
				}
			}
			model.addAttribute("isUpdate", IS_UPDATE2);
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
					orderService.updateCash(cash);
				} else {
					// ステータスは「会計再確認要」を設定する
					Cash cash = cashService.selectByPrimaryKey(order.getCashId());
					cash.setCashStatus(CASH_STATUS03);
					orderService.updateCash(cash);
				}
			}

			if (!"".equals(order.getProductFabricNo()) || order.getProductFabricNo() != null) {
				// 生地の論理在庫を戻る
				BigDecimal stockNum = order.getTheoryFabricUsedMount();
				Stock stockDb = orderService.getStock(order.getProductFabricNo());
				stockDb.setTheoreticalStock(stockDb.getTheoreticalStock().add(stockNum));
				stockDb.setUpdatedUserId(sessionContent.getUserId());
				stockDb.setUpdatedAt(new Date());
				orderService.updateStockByPk(stockDb);
			}
			// 取り消しフラグ:0
			order.setIsCancelled(IS_CANCELLED);
			order.setVersion(order.getVersion());
			orderService.updateOrder(order);
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
	 * モデルチェク
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
}
