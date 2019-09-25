package co.jp.aoyama.macchinetta.app.order;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import org.dozer.util.ReflectionUtils;
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


import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustShirtStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketWashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionShirtStandardInfo;
import co.jp.aoyama.macchinetta.app.order.enums.CoProductPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.LogItemClassEnum;
import co.jp.aoyama.macchinetta.app.order.enums.coat.CoatCoOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionCoStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionCoTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionCoWashablePriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionCoStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionCoTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionCoWashablePriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionWashablePriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsCoOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsCoOptionTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsCoOptionWashablePriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.shirt.ShirtCoOptionStandardPriceEnum;
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

	//private OrderHelper orderHelper = new OrderHelper();
	
	private OrderCoHelper orderCoHelper = new OrderCoHelper();

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
			orderCoHelper.customerAndProductDefaultValue(orderCoForm);
			orderCoHelper.jacketDefaultValue(orderCoForm);
			orderCoHelper.giletDefaultValue(orderCoForm);
			orderCoHelper.coatDefaultValue(orderCoForm);

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
			
//			String productItem = order.getProductItem();
//			String productIs3piece = order.getProductIs3piece();
//			String productSparePantsClass = order.getProductSparePantsClass();
			
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
			if("orderLink".equals(orderFlag)) {
				orderCoHelper.setCustomerMessageAndProductOrderLink(order,orderCoForm);
				orderCoHelper.setDbDefaultValue(order,orderCoForm,orderListService,modelService);
				orderCoForm.setFabricFlag("0");
			}else if("orderDivert".equals(orderFlag)) {
				orderCoHelper.setCustomerMessageAndProductOrderDivert(order,orderCoForm);
				orderCoHelper.setDbDefaultValue(order,orderCoForm,orderListService,modelService);
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
	public String toOrderPoReconfirm(HttpServletRequest request, OrderCoForm orderCoForm, Model model) {
		String item = orderCoForm.getProductItem();
		String productCategory = orderCoForm.getProductCategory();
		String threePiece = orderCoForm.getProductIs3Piece();
		String twoPants = orderCoForm.getProductSparePantsClass();

		//SUITチェック
		if("01".equals(item)) {
			boolean jacketFlag = false;
			String itemFlag = orderCoForm.getJacketItemFlag();
			ResultMessages messages = ResultMessages.error();
			//標準の場合
			if("9000101".equals(productCategory)) {
				//JACKET モデル未選択の場合
				CoOptionJacketStandardInfo coOptionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
				String ojJacketModel = coOptionJacketStandardInfo.getOjJacketModel();
				if("".equals(ojJacketModel)  ||  null == ojJacketModel) {
					 messages.add("E031", "JACKET モデル");
					 jacketFlag = true;
				}
				//AMF色指定
				String ojAmfColor = coOptionJacketStandardInfo.getOjAmfColor();
				if(OptionCodeKeys.JK_0002802.equals(ojAmfColor)) {
					String ojAmfColorPlace1 = coOptionJacketStandardInfo.getOjAmfColorPlace1();
					String ojAmfColorPlace2 = coOptionJacketStandardInfo.getOjAmfColorPlace2();
					String ojAmfColorPlace3 = coOptionJacketStandardInfo.getOjAmfColorPlace3();
					String ojAmfColorPlace4 = coOptionJacketStandardInfo.getOjAmfColorPlace4();
					String ojAmfColorPlace5 = coOptionJacketStandardInfo.getOjAmfColorPlace5();
					String ojAmfColorPlace6 = coOptionJacketStandardInfo.getOjAmfColorPlace6();
					String ojAmfColorPlace7 = coOptionJacketStandardInfo.getOjAmfColorPlace7();
					String ojAmfColorPlace8 = coOptionJacketStandardInfo.getOjAmfColorPlace8();
					String ojAmfColorPlace9 = coOptionJacketStandardInfo.getOjAmfColorPlace9();
					
					String ojAmfColor1 = coOptionJacketStandardInfo.getOjAmfColor1();
					String ojAmfColor2 = coOptionJacketStandardInfo.getOjAmfColor2();
					String ojAmfColor3 = coOptionJacketStandardInfo.getOjAmfColor3();
					String ojAmfColor4 = coOptionJacketStandardInfo.getOjAmfColor4();
					String ojAmfColor5 = coOptionJacketStandardInfo.getOjAmfColor5();
					String ojAmfColor6 = coOptionJacketStandardInfo.getOjAmfColor6();
					String ojAmfColor7 = coOptionJacketStandardInfo.getOjAmfColor7();
					String ojAmfColor8 = coOptionJacketStandardInfo.getOjAmfColor8();
					String ojAmfColor9 = coOptionJacketStandardInfo.getOjAmfColor9();
					
					if(isEmpty(ojAmfColorPlace1)&&isEmpty(ojAmfColorPlace2)&&isEmpty(ojAmfColorPlace3)&&isEmpty(ojAmfColorPlace4)&&
					   isEmpty(ojAmfColorPlace5)&&isEmpty(ojAmfColorPlace6)&&isEmpty(ojAmfColorPlace7)&&isEmpty(ojAmfColorPlace8)&&isEmpty(ojAmfColorPlace9)) {
						messages.add("E032", "AMF色指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(ojAmfColorPlace1)&&isEmpty(ojAmfColor1)||isNotEmpty(ojAmfColorPlace2)&&isEmpty(ojAmfColor2)||
					   isNotEmpty(ojAmfColorPlace3)&&isEmpty(ojAmfColor3)||isNotEmpty(ojAmfColorPlace4)&&isEmpty(ojAmfColor4)||
					   isNotEmpty(ojAmfColorPlace5)&&isEmpty(ojAmfColor5)||isNotEmpty(ojAmfColorPlace6)&&isEmpty(ojAmfColor6)||
					   isNotEmpty(ojAmfColorPlace7)&&isEmpty(ojAmfColor7)||isNotEmpty(ojAmfColorPlace8)&&isEmpty(ojAmfColor8)||
					   isNotEmpty(ojAmfColorPlace9)&&isEmpty(ojAmfColor9)) {
						messages.add("E032", "AMF色指定");
						jacketFlag = true;
					}
					
					
				}
				//ボタンホール色指定
				String ojBhColor = coOptionJacketStandardInfo.getOjBhColor();
				if (OptionCodeKeys.JK_0003102.equals(ojBhColor)) {
					String ojBhColorPlace1 = coOptionJacketStandardInfo.getOjBhColorPlace1();
					String ojBhColorPlace2 = coOptionJacketStandardInfo.getOjBhColorPlace2();
					String ojBhColorPlace3 = coOptionJacketStandardInfo.getOjBhColorPlace3();
					String ojBhColorPlace4 = coOptionJacketStandardInfo.getOjBhColorPlace4();
					String ojBhColorPlace5 = coOptionJacketStandardInfo.getOjBhColorPlace5();
					String ojBhColorPlace6 = coOptionJacketStandardInfo.getOjBhColorPlace6();
					String ojBhColorPlace7 = coOptionJacketStandardInfo.getOjBhColorPlace7();
					String ojBhColorPlace8 = coOptionJacketStandardInfo.getOjBhColorPlace8();
					String ojBhColorPlace9 = coOptionJacketStandardInfo.getOjBhColorPlace9();
					String ojBhColorPlace10 = coOptionJacketStandardInfo.getOjBhColorPlace10();
					String ojBhColorPlace11 = coOptionJacketStandardInfo.getOjBhColorPlace11();
					String ojBhColorPlace12 = coOptionJacketStandardInfo.getOjBhColorPlace12();
					String ojBhColorPlace13 = coOptionJacketStandardInfo.getOjBhColorPlace13();
					String ojBhColorPlace14 = coOptionJacketStandardInfo.getOjBhColorPlace14();
					String ojBhColorPlace15 = coOptionJacketStandardInfo.getOjBhColorPlace15();
					String ojBhColorPlace16 = coOptionJacketStandardInfo.getOjBhColorPlace16();
					String ojBhColorPlace17 = coOptionJacketStandardInfo.getOjBhColorPlace17();
					
					String ojBhColor1 = coOptionJacketStandardInfo.getOjBhColor1();
					String ojBhColor2 = coOptionJacketStandardInfo.getOjBhColor2();
					String ojBhColor3 = coOptionJacketStandardInfo.getOjBhColor3();
					String ojBhColor4 = coOptionJacketStandardInfo.getOjBhColor4();
					String ojBhColor5 = coOptionJacketStandardInfo.getOjBhColor5();
					String ojBhColor6 = coOptionJacketStandardInfo.getOjBhColor6();
					String ojBhColor7 = coOptionJacketStandardInfo.getOjBhColor7();
					String ojBhColor8 = coOptionJacketStandardInfo.getOjBhColor8();
					String ojBhColor9 = coOptionJacketStandardInfo.getOjBhColor9();
					String ojBhColor10 = coOptionJacketStandardInfo.getOjBhColor10();
					String ojBhColor11 = coOptionJacketStandardInfo.getOjBhColor11();
					String ojBhColor12 = coOptionJacketStandardInfo.getOjBhColor12();
					String ojBhColor13 = coOptionJacketStandardInfo.getOjBhColor13();
					String ojBhColor14 = coOptionJacketStandardInfo.getOjBhColor14();
					String ojBhColor15 = coOptionJacketStandardInfo.getOjBhColor15();
					String ojBhColor16 = coOptionJacketStandardInfo.getOjBhColor16();
					String ojBhColor17 = coOptionJacketStandardInfo.getOjBhColor17();
					
					if (isEmpty(ojBhColorPlace1) && isEmpty(ojBhColorPlace2) && isEmpty(ojBhColorPlace3)
							&& isEmpty(ojBhColorPlace4) && isEmpty(ojBhColorPlace5) && isEmpty(ojBhColorPlace6)
							&& isEmpty(ojBhColorPlace7) && isEmpty(ojBhColorPlace8) && isEmpty(ojBhColorPlace9)
							&& isEmpty(ojBhColorPlace10)&& isEmpty(ojBhColorPlace11)&& isEmpty(ojBhColorPlace12)
							&& isEmpty(ojBhColorPlace13)&& isEmpty(ojBhColorPlace14)&& isEmpty(ojBhColorPlace15)
							&& isEmpty(ojBhColorPlace16)&& isEmpty(ojBhColorPlace17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(ojBhColorPlace1)&&isEmpty(ojBhColor1)||isNotEmpty(ojBhColorPlace2)&&isEmpty(ojBhColor2)||
					   isNotEmpty(ojBhColorPlace3)&&isEmpty(ojBhColor3)||isNotEmpty(ojBhColorPlace4)&&isEmpty(ojBhColor4)||
					   isNotEmpty(ojBhColorPlace5)&&isEmpty(ojBhColor5)||isNotEmpty(ojBhColorPlace6)&&isEmpty(ojBhColor6)||
					   isNotEmpty(ojBhColorPlace7)&&isEmpty(ojBhColor7)||isNotEmpty(ojBhColorPlace8)&&isEmpty(ojBhColor8)||
					   isNotEmpty(ojBhColorPlace9)&&isEmpty(ojBhColor9)||isNotEmpty(ojBhColorPlace10)&&isEmpty(ojBhColor10)||
					   isNotEmpty(ojBhColorPlace11)&&isEmpty(ojBhColor11)||isNotEmpty(ojBhColorPlace12)&&isEmpty(ojBhColor12)||
					   isNotEmpty(ojBhColorPlace13)&&isEmpty(ojBhColor13)||isNotEmpty(ojBhColorPlace14)&&isEmpty(ojBhColor14)||
					   isNotEmpty(ojBhColorPlace15)&&isEmpty(ojBhColor15)||isNotEmpty(ojBhColorPlace16)&&isEmpty(ojBhColor16)||
					   isNotEmpty(ojBhColorPlace17)&&isEmpty(ojBhColor17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
				}
				
				//ボタン付け糸指定
				String ojByColor = coOptionJacketStandardInfo.getOjByColor();
				if (OptionCodeKeys.JK_0003402.equals(ojByColor)) {
					String ojByColorPlace1 = coOptionJacketStandardInfo.getOjByColorPlace1();
					String ojByColorPlace2 = coOptionJacketStandardInfo.getOjByColorPlace2();
					String ojByColorPlace3 = coOptionJacketStandardInfo.getOjByColorPlace3();
					String ojByColorPlace4 = coOptionJacketStandardInfo.getOjByColorPlace4();
					String ojByColorPlace5 = coOptionJacketStandardInfo.getOjByColorPlace5();
					String ojByColorPlace6 = coOptionJacketStandardInfo.getOjByColorPlace6();
					String ojByColorPlace7 = coOptionJacketStandardInfo.getOjByColorPlace7();
					String ojByColorPlace8 = coOptionJacketStandardInfo.getOjByColorPlace8();
					String ojByColorPlace9 = coOptionJacketStandardInfo.getOjByColorPlace9();
					String ojByColorPlace10 = coOptionJacketStandardInfo.getOjByColorPlace10();
					String ojByColorPlace11 = coOptionJacketStandardInfo.getOjByColorPlace11();
					String ojByColorPlace12 = coOptionJacketStandardInfo.getOjByColorPlace12();
					String ojByColorPlace13 = coOptionJacketStandardInfo.getOjByColorPlace13();
					String ojByColorPlace14 = coOptionJacketStandardInfo.getOjByColorPlace14();
					String ojByColorPlace15 = coOptionJacketStandardInfo.getOjByColorPlace15();
					String ojByColorPlace16 = coOptionJacketStandardInfo.getOjByColorPlace16();
					
					String ojByColor1 = coOptionJacketStandardInfo.getOjByColor1();
					String ojByColor2 = coOptionJacketStandardInfo.getOjByColor2();
					String ojByColor3 = coOptionJacketStandardInfo.getOjByColor3();
					String ojByColor4 = coOptionJacketStandardInfo.getOjByColor4();
					String ojByColor5 = coOptionJacketStandardInfo.getOjByColor5();
					String ojByColor6 = coOptionJacketStandardInfo.getOjByColor6();
					String ojByColor7 = coOptionJacketStandardInfo.getOjByColor7();
					String ojByColor8 = coOptionJacketStandardInfo.getOjByColor8();
					String ojByColor9 = coOptionJacketStandardInfo.getOjByColor9();
					String ojByColor10 = coOptionJacketStandardInfo.getOjByColor10();
					String ojByColor11 = coOptionJacketStandardInfo.getOjByColor11();
					String ojByColor12 = coOptionJacketStandardInfo.getOjByColor12();
					String ojByColor13 = coOptionJacketStandardInfo.getOjByColor13();
					String ojByColor14 = coOptionJacketStandardInfo.getOjByColor14();
					String ojByColor15 = coOptionJacketStandardInfo.getOjByColor15();
					String ojByColor16 = coOptionJacketStandardInfo.getOjByColor16();
					
					if (isEmpty(ojByColorPlace1) && isEmpty(ojByColorPlace2) && isEmpty(ojByColorPlace3)
							&& isEmpty(ojByColorPlace4) && isEmpty(ojByColorPlace5) && isEmpty(ojByColorPlace6)
							&& isEmpty(ojByColorPlace7) && isEmpty(ojByColorPlace8) && isEmpty(ojByColorPlace9)
							&& isEmpty(ojByColorPlace10)&& isEmpty(ojByColorPlace11)&& isEmpty(ojByColorPlace12)
							&& isEmpty(ojByColorPlace13)&& isEmpty(ojByColorPlace14)&& isEmpty(ojByColorPlace15)
							&& isEmpty(ojByColorPlace16)) {
						messages.add("E032", "ボタン付け糸指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(ojByColorPlace1)&&isEmpty(ojByColor1)||isNotEmpty(ojByColorPlace2)&&isEmpty(ojByColor2)||
					   isNotEmpty(ojByColorPlace3)&&isEmpty(ojByColor3)||isNotEmpty(ojByColorPlace4)&&isEmpty(ojByColor4)||
					   isNotEmpty(ojByColorPlace5)&&isEmpty(ojByColor5)||isNotEmpty(ojByColorPlace6)&&isEmpty(ojByColor6)||
					   isNotEmpty(ojByColorPlace7)&&isEmpty(ojByColor7)||isNotEmpty(ojByColorPlace8)&&isEmpty(ojByColor8)||
					   isNotEmpty(ojByColorPlace9)&&isEmpty(ojByColor9)||isNotEmpty(ojByColorPlace10)&&isEmpty(ojByColor10)||
					   isNotEmpty(ojByColorPlace11)&&isEmpty(ojByColor11)||isNotEmpty(ojByColorPlace12)&&isEmpty(ojByColor12)||
					   isNotEmpty(ojByColorPlace13)&&isEmpty(ojByColor13)||isNotEmpty(ojByColorPlace14)&&isEmpty(ojByColor14)||
					   isNotEmpty(ojByColorPlace15)&&isEmpty(ojByColor15)||isNotEmpty(ojByColorPlace16)&&isEmpty(ojByColor16)) {
						messages.add("E032", "ボタン付け糸指定");
						jacketFlag = true;
					}
					
				}
			//タキシードの場合
			}else if("9000102".equals(productCategory)) {
				//JACKET モデル未選択の場合
				CoOptionJacketTuxedoInfo coOptionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
				String tjJacketModel = coOptionJacketTuxedoInfo.getTjJacketModel();
				if("".equals(tjJacketModel)  ||  null == tjJacketModel) {
					 messages.add("E031", "JACKET モデル");
					 jacketFlag = true;
				}
				
				// ボタンホール色指定
				String ojBhColor = coOptionJacketTuxedoInfo.getTjBhColor();
				if (OptionCodeKeys.JK_0003102.equals(ojBhColor)) {
					String tjBhColorPlace1 = coOptionJacketTuxedoInfo.getTjBhColorPlace1();
					String tjBhColorPlace2 = coOptionJacketTuxedoInfo.getTjBhColorPlace2();
					String tjBhColorPlace3 = coOptionJacketTuxedoInfo.getTjBhColorPlace3();
					String tjBhColorPlace4 = coOptionJacketTuxedoInfo.getTjBhColorPlace4();
					String tjBhColorPlace5 = coOptionJacketTuxedoInfo.getTjBhColorPlace5();
					String tjBhColorPlace6 = coOptionJacketTuxedoInfo.getTjBhColorPlace6();
					String tjBhColorPlace7 = coOptionJacketTuxedoInfo.getTjBhColorPlace7();
					String tjBhColorPlace8 = coOptionJacketTuxedoInfo.getTjBhColorPlace8();
					String tjBhColorPlace9 = coOptionJacketTuxedoInfo.getTjBhColorPlace9();
					String tjBhColorPlace10 = coOptionJacketTuxedoInfo.getTjBhColorPlace10();
					String tjBhColorPlace11 = coOptionJacketTuxedoInfo.getTjBhColorPlace11();
					String tjBhColorPlace12 = coOptionJacketTuxedoInfo.getTjBhColorPlace12();
					String tjBhColorPlace13 = coOptionJacketTuxedoInfo.getTjBhColorPlace13();
					String tjBhColorPlace14 = coOptionJacketTuxedoInfo.getTjBhColorPlace14();
					String tjBhColorPlace15 = coOptionJacketTuxedoInfo.getTjBhColorPlace15();
					String tjBhColorPlace16 = coOptionJacketTuxedoInfo.getTjBhColorPlace16();
					String tjBhColorPlace17 = coOptionJacketTuxedoInfo.getTjBhColorPlace17();
					
					String tjBhColor1 = coOptionJacketTuxedoInfo.getTjBhColor1();
					String tjBhColor2 = coOptionJacketTuxedoInfo.getTjBhColor2();
					String tjBhColor3 = coOptionJacketTuxedoInfo.getTjBhColor3();
					String tjBhColor4 = coOptionJacketTuxedoInfo.getTjBhColor4();
					String tjBhColor5 = coOptionJacketTuxedoInfo.getTjBhColor5();
					String tjBhColor6 = coOptionJacketTuxedoInfo.getTjBhColor6();
					String tjBhColor7 = coOptionJacketTuxedoInfo.getTjBhColor7();
					String tjBhColor8 = coOptionJacketTuxedoInfo.getTjBhColor8();
					String tjBhColor9 = coOptionJacketTuxedoInfo.getTjBhColor9();
					String tjBhColor10 = coOptionJacketTuxedoInfo.getTjBhColor10();
					String tjBhColor11 = coOptionJacketTuxedoInfo.getTjBhColor11();
					String tjBhColor12 = coOptionJacketTuxedoInfo.getTjBhColor12();
					String tjBhColor13 = coOptionJacketTuxedoInfo.getTjBhColor13();
					String tjBhColor14 = coOptionJacketTuxedoInfo.getTjBhColor14();
					String tjBhColor15 = coOptionJacketTuxedoInfo.getTjBhColor15();
					String tjBhColor16 = coOptionJacketTuxedoInfo.getTjBhColor16();
					String tjBhColor17 = coOptionJacketTuxedoInfo.getTjBhColor17();

					if (isEmpty(tjBhColorPlace1) && isEmpty(tjBhColorPlace2) && isEmpty(tjBhColorPlace3)
							&& isEmpty(tjBhColorPlace4) && isEmpty(tjBhColorPlace5) && isEmpty(tjBhColorPlace6)
							&& isEmpty(tjBhColorPlace7) && isEmpty(tjBhColorPlace8) && isEmpty(tjBhColorPlace9)
							&& isEmpty(tjBhColorPlace10) && isEmpty(tjBhColorPlace11) && isEmpty(tjBhColorPlace12)
							&& isEmpty(tjBhColorPlace13) && isEmpty(tjBhColorPlace14) && isEmpty(tjBhColorPlace15)
							&& isEmpty(tjBhColorPlace16) && isEmpty(tjBhColorPlace17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}

					if(isNotEmpty(tjBhColorPlace1)&&isEmpty(tjBhColor1)||isNotEmpty(tjBhColorPlace2)&&isEmpty(tjBhColor2)||
					   isNotEmpty(tjBhColorPlace3)&&isEmpty(tjBhColor3)||isNotEmpty(tjBhColorPlace4)&&isEmpty(tjBhColor4)||
					   isNotEmpty(tjBhColorPlace5)&&isEmpty(tjBhColor5)||isNotEmpty(tjBhColorPlace6)&&isEmpty(tjBhColor6)||
					   isNotEmpty(tjBhColorPlace7)&&isEmpty(tjBhColor7)||isNotEmpty(tjBhColorPlace8)&&isEmpty(tjBhColor8)||
					   isNotEmpty(tjBhColorPlace9)&&isEmpty(tjBhColor9)||isNotEmpty(tjBhColorPlace10)&&isEmpty(tjBhColor10)||
					   isNotEmpty(tjBhColorPlace11)&&isEmpty(tjBhColor11)||isNotEmpty(tjBhColorPlace12)&&isEmpty(tjBhColor12)||
					   isNotEmpty(tjBhColorPlace13)&&isEmpty(tjBhColor13)||isNotEmpty(tjBhColorPlace14)&&isEmpty(tjBhColor14)||
					   isNotEmpty(tjBhColorPlace15)&&isEmpty(tjBhColor15)||isNotEmpty(tjBhColorPlace16)&&isEmpty(tjBhColor16)||
					   isNotEmpty(tjBhColorPlace17)&&isEmpty(tjBhColor17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
					
					// ボタン付け糸指定
					String tjByColor = coOptionJacketTuxedoInfo.getTjByColor();
					if (OptionCodeKeys.JK_0003402.equals(tjByColor)) {
						String tjByColorPlace1 = coOptionJacketTuxedoInfo.getTjByColorPlace1();
						String tjByColorPlace2 = coOptionJacketTuxedoInfo.getTjByColorPlace2();
						String tjByColorPlace3 = coOptionJacketTuxedoInfo.getTjByColorPlace3();
						String tjByColorPlace4 = coOptionJacketTuxedoInfo.getTjByColorPlace4();
						String tjByColorPlace5 = coOptionJacketTuxedoInfo.getTjByColorPlace5();
						String tjByColorPlace6 = coOptionJacketTuxedoInfo.getTjByColorPlace6();
						String tjByColorPlace7 = coOptionJacketTuxedoInfo.getTjByColorPlace7();
						String tjByColorPlace8 = coOptionJacketTuxedoInfo.getTjByColorPlace8();
						String tjByColorPlace9 = coOptionJacketTuxedoInfo.getTjByColorPlace9();
						String tjByColorPlace10 = coOptionJacketTuxedoInfo.getTjByColorPlace10();
						String tjByColorPlace11 = coOptionJacketTuxedoInfo.getTjByColorPlace11();
						String tjByColorPlace12 = coOptionJacketTuxedoInfo.getTjByColorPlace12();
						String tjByColorPlace13 = coOptionJacketTuxedoInfo.getTjByColorPlace13();
						String tjByColorPlace14 = coOptionJacketTuxedoInfo.getTjByColorPlace14();
						String tjByColorPlace15 = coOptionJacketTuxedoInfo.getTjByColorPlace15();
						String tjByColorPlace16 = coOptionJacketTuxedoInfo.getTjByColorPlace16();
						
						String tjByColor1 = coOptionJacketTuxedoInfo.getTjByColor1();
						String tjByColor2 = coOptionJacketTuxedoInfo.getTjByColor2();
						String tjByColor3 = coOptionJacketTuxedoInfo.getTjByColor3();
						String tjByColor4 = coOptionJacketTuxedoInfo.getTjByColor4();
						String tjByColor5 = coOptionJacketTuxedoInfo.getTjByColor5();
						String tjByColor6 = coOptionJacketTuxedoInfo.getTjByColor6();
						String tjByColor7 = coOptionJacketTuxedoInfo.getTjByColor7();
						String tjByColor8 = coOptionJacketTuxedoInfo.getTjByColor8();
						String tjByColor9 = coOptionJacketTuxedoInfo.getTjByColor9();
						String tjByColor10 = coOptionJacketTuxedoInfo.getTjByColor10();
						String tjByColor11 = coOptionJacketTuxedoInfo.getTjByColor11();
						String tjByColor12 = coOptionJacketTuxedoInfo.getTjByColor12();
						String tjByColor13 = coOptionJacketTuxedoInfo.getTjByColor13();
						String tjByColor14 = coOptionJacketTuxedoInfo.getTjByColor14();
						String tjByColor15 = coOptionJacketTuxedoInfo.getTjByColor15();
						String tjByColor16 = coOptionJacketTuxedoInfo.getTjByColor16();
						
						if (isEmpty(tjByColorPlace1) && isEmpty(tjByColorPlace2) && isEmpty(tjByColorPlace3)
								&& isEmpty(tjByColorPlace4) && isEmpty(tjByColorPlace5) && isEmpty(tjByColorPlace6)
								&& isEmpty(tjByColorPlace7) && isEmpty(tjByColorPlace8) && isEmpty(tjByColorPlace9)
								&& isEmpty(tjByColorPlace10) && isEmpty(tjByColorPlace11) && isEmpty(tjByColorPlace12)
								&& isEmpty(tjByColorPlace13) && isEmpty(tjByColorPlace14) && isEmpty(tjByColorPlace15)
								&& isEmpty(tjByColorPlace16)) {
							messages.add("E032", "ボタン付け糸指定");
							jacketFlag = true;
						}
						
						if(isNotEmpty(tjByColorPlace1)&&isEmpty(tjByColor1)||isNotEmpty(tjByColorPlace2)&&isEmpty(tjByColor2)||
						   isNotEmpty(tjByColorPlace3)&&isEmpty(tjByColor3)||isNotEmpty(tjByColorPlace4)&&isEmpty(tjByColor4)||
						   isNotEmpty(tjByColorPlace5)&&isEmpty(tjByColor5)||isNotEmpty(tjByColorPlace6)&&isEmpty(tjByColor6)||
						   isNotEmpty(tjByColorPlace7)&&isEmpty(tjByColor7)||isNotEmpty(tjByColorPlace8)&&isEmpty(tjByColor8)||
						   isNotEmpty(tjByColorPlace9)&&isEmpty(tjByColor9)||isNotEmpty(tjByColorPlace10)&&isEmpty(tjByColor10)||
						   isNotEmpty(tjByColorPlace11)&&isEmpty(tjByColor11)||isNotEmpty(tjByColorPlace12)&&isEmpty(tjByColor12)||
						   isNotEmpty(tjByColorPlace13)&&isEmpty(tjByColor13)||isNotEmpty(tjByColorPlace14)&&isEmpty(tjByColor14)||
						   isNotEmpty(tjByColorPlace15)&&isEmpty(tjByColor15)||isNotEmpty(tjByColorPlace16)&&isEmpty(tjByColor16)) {
							messages.add("E032", "ボタン付け糸指定");
							jacketFlag = true;
						}
					}
				}
			}else if("9000103".equals(productCategory)) {
				//JACKET モデル未選択の場合
				CoOptionJacketWashableInfo coOptionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
				String wjJacketModel = coOptionJacketWashableInfo.getWjJacketModel();
				if("".equals(wjJacketModel)  ||  null == wjJacketModel) {
					 messages.add("E031", "JACKET モデル");
					 jacketFlag = true;
				}
				 
				//AMF色指定
				String wjamfColor = coOptionJacketWashableInfo.getWjAmfColor();
				if(OptionCodeKeys.JK_0002802.equals(wjamfColor)) {
					String wjAmfColorPlace1 = coOptionJacketWashableInfo.getWjAmfColorPlace1();
					String wjAmfColorPlace2 = coOptionJacketWashableInfo.getWjAmfColorPlace2();
					String wjAmfColorPlace3 = coOptionJacketWashableInfo.getWjAmfColorPlace3();
					String wjAmfColorPlace4 = coOptionJacketWashableInfo.getWjAmfColorPlace4();
					String wjAmfColorPlace5 = coOptionJacketWashableInfo.getWjAmfColorPlace5();
					String wjAmfColorPlace6 = coOptionJacketWashableInfo.getWjAmfColorPlace6();
					String wjAmfColorPlace7 = coOptionJacketWashableInfo.getWjAmfColorPlace7();
					String wjAmfColorPlace8 = coOptionJacketWashableInfo.getWjAmfColorPlace8();
					String wjAmfColorPlace9 = coOptionJacketWashableInfo.getWjAmfColorPlace9();
					
					String wjAmfColor1 = coOptionJacketWashableInfo.getWjAmfColor1();
					String wjAmfColor2 = coOptionJacketWashableInfo.getWjAmfColor2();
					String wjAmfColor3 = coOptionJacketWashableInfo.getWjAmfColor3();
					String wjAmfColor4 = coOptionJacketWashableInfo.getWjAmfColor4();
					String wjAmfColor5 = coOptionJacketWashableInfo.getWjAmfColor5();
					String wjAmfColor6 = coOptionJacketWashableInfo.getWjAmfColor6();
					String wjAmfColor7 = coOptionJacketWashableInfo.getWjAmfColor7();
					String wjAmfColor8 = coOptionJacketWashableInfo.getWjAmfColor8();
					String wjAmfColor9 = coOptionJacketWashableInfo.getWjAmfColor9();
					
					if(isEmpty(wjAmfColorPlace1)&&isEmpty(wjAmfColorPlace2)&&isEmpty(wjAmfColorPlace3)&&isEmpty(wjAmfColorPlace4)&&
					   isEmpty(wjAmfColorPlace5)&&isEmpty(wjAmfColorPlace6)&&isEmpty(wjAmfColorPlace7)&&isEmpty(wjAmfColorPlace8)&&isEmpty(wjAmfColorPlace9)) {
						messages.add("E032", "AMF色指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(wjAmfColorPlace1)&&isEmpty(wjAmfColor1)||isNotEmpty(wjAmfColorPlace2)&&isEmpty(wjAmfColor2)||
					   isNotEmpty(wjAmfColorPlace3)&&isEmpty(wjAmfColor3)||isNotEmpty(wjAmfColorPlace4)&&isEmpty(wjAmfColor4)||
					   isNotEmpty(wjAmfColorPlace5)&&isEmpty(wjAmfColor5)||isNotEmpty(wjAmfColorPlace6)&&isEmpty(wjAmfColor6)||
					   isNotEmpty(wjAmfColorPlace7)&&isEmpty(wjAmfColor7)||isNotEmpty(wjAmfColorPlace8)&&isEmpty(wjAmfColor8)||
					   isNotEmpty(wjAmfColorPlace9)&&isEmpty(wjAmfColor9)) {
						messages.add("E032", "AMF色指定");
						jacketFlag = true;
					}
					
				}
				
				//ボタンホール色指定
				String wjBhColor = coOptionJacketWashableInfo.getWjBhColor();
				if (OptionCodeKeys.JK_0003102.equals(wjBhColor)) {
					String wjBhColorPlace1 = coOptionJacketWashableInfo.getWjBhColorPlace1();
					String wjBhColorPlace2 = coOptionJacketWashableInfo.getWjBhColorPlace2();
					String wjBhColorPlace3 = coOptionJacketWashableInfo.getWjBhColorPlace3();
					String wjBhColorPlace4 = coOptionJacketWashableInfo.getWjBhColorPlace4();
					String wjBhColorPlace5 = coOptionJacketWashableInfo.getWjBhColorPlace5();
					String wjBhColorPlace6 = coOptionJacketWashableInfo.getWjBhColorPlace6();
					String wjBhColorPlace7 = coOptionJacketWashableInfo.getWjBhColorPlace7();
					String wjBhColorPlace8 = coOptionJacketWashableInfo.getWjBhColorPlace8();
					String wjBhColorPlace9 = coOptionJacketWashableInfo.getWjBhColorPlace9();
					String wjBhColorPlace10 = coOptionJacketWashableInfo.getWjBhColorPlace10();
					String wjBhColorPlace11 = coOptionJacketWashableInfo.getWjBhColorPlace11();
					String wjBhColorPlace12 = coOptionJacketWashableInfo.getWjBhColorPlace12();
					String wjBhColorPlace13 = coOptionJacketWashableInfo.getWjBhColorPlace13();
					String wjBhColorPlace14 = coOptionJacketWashableInfo.getWjBhColorPlace14();
					String wjBhColorPlace15 = coOptionJacketWashableInfo.getWjBhColorPlace15();
					String wjBhColorPlace16 = coOptionJacketWashableInfo.getWjBhColorPlace16();
					String wjBhColorPlace17 = coOptionJacketWashableInfo.getWjBhColorPlace17();
					
					String wjBhColor1 = coOptionJacketWashableInfo.getWjBhColor1();
					String wjBhColor2 = coOptionJacketWashableInfo.getWjBhColor2();
					String wjBhColor3 = coOptionJacketWashableInfo.getWjBhColor3();
					String wjBhColor4 = coOptionJacketWashableInfo.getWjBhColor4();
					String wjBhColor5 = coOptionJacketWashableInfo.getWjBhColor5();
					String wjBhColor6 = coOptionJacketWashableInfo.getWjBhColor6();
					String wjBhColor7 = coOptionJacketWashableInfo.getWjBhColor7();
					String wjBhColor8 = coOptionJacketWashableInfo.getWjBhColor8();
					String wjBhColor9 = coOptionJacketWashableInfo.getWjBhColor9();
					String wjBhColor10 = coOptionJacketWashableInfo.getWjBhColor10();
					String wjBhColor11 = coOptionJacketWashableInfo.getWjBhColor11();
					String wjBhColor12 = coOptionJacketWashableInfo.getWjBhColor12();
					String wjBhColor13 = coOptionJacketWashableInfo.getWjBhColor13();
					String wjBhColor14 = coOptionJacketWashableInfo.getWjBhColor14();
					String wjBhColor15 = coOptionJacketWashableInfo.getWjBhColor15();
					String wjBhColor16 = coOptionJacketWashableInfo.getWjBhColor16();
					String wjBhColor17 = coOptionJacketWashableInfo.getWjBhColor17();

					if (isEmpty(wjBhColorPlace1) && isEmpty(wjBhColorPlace2) && isEmpty(wjBhColorPlace3)
							&& isEmpty(wjBhColorPlace4) && isEmpty(wjBhColorPlace5) && isEmpty(wjBhColorPlace6)
							&& isEmpty(wjBhColorPlace7) && isEmpty(wjBhColorPlace8) && isEmpty(wjBhColorPlace9)
							&& isEmpty(wjBhColorPlace10)&& isEmpty(wjBhColorPlace11)&& isEmpty(wjBhColorPlace12)
							&& isEmpty(wjBhColorPlace13)&& isEmpty(wjBhColorPlace14)&& isEmpty(wjBhColorPlace15)
							&& isEmpty(wjBhColorPlace16)&& isEmpty(wjBhColorPlace17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(wjBhColorPlace1)&&isEmpty(wjBhColor1)||isNotEmpty(wjBhColorPlace2)&&isEmpty(wjBhColor2)||
					   isNotEmpty(wjBhColorPlace3)&&isEmpty(wjBhColor3)||isNotEmpty(wjBhColorPlace4)&&isEmpty(wjBhColor4)||
					   isNotEmpty(wjBhColorPlace5)&&isEmpty(wjBhColor5)||isNotEmpty(wjBhColorPlace6)&&isEmpty(wjBhColor6)||
					   isNotEmpty(wjBhColorPlace7)&&isEmpty(wjBhColor7)||isNotEmpty(wjBhColorPlace8)&&isEmpty(wjBhColor8)||
					   isNotEmpty(wjBhColorPlace9)&&isEmpty(wjBhColor9)||isNotEmpty(wjBhColorPlace10)&&isEmpty(wjBhColor10)||
					   isNotEmpty(wjBhColorPlace11)&&isEmpty(wjBhColor11)||isNotEmpty(wjBhColorPlace12)&&isEmpty(wjBhColor12)||
					   isNotEmpty(wjBhColorPlace13)&&isEmpty(wjBhColor13)||isNotEmpty(wjBhColorPlace14)&&isEmpty(wjBhColor14)||
					   isNotEmpty(wjBhColorPlace15)&&isEmpty(wjBhColor15)||isNotEmpty(wjBhColorPlace16)&&isEmpty(wjBhColor16)||
					   isNotEmpty(wjBhColorPlace17)&&isEmpty(wjBhColor17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
				}
				
				//ボタン付け糸指定
				String wjByColor = coOptionJacketWashableInfo.getWjByColor();
				if (OptionCodeKeys.JK_0003402.equals(wjByColor)) {
					String wjByColorPlace1 = coOptionJacketWashableInfo.getWjByColorPlace1();
					String wjByColorPlace2 = coOptionJacketWashableInfo.getWjByColorPlace2();
					String wjByColorPlace3 = coOptionJacketWashableInfo.getWjByColorPlace3();
					String wjByColorPlace4 = coOptionJacketWashableInfo.getWjByColorPlace4();
					String wjByColorPlace5 = coOptionJacketWashableInfo.getWjByColorPlace5();
					String wjByColorPlace6 = coOptionJacketWashableInfo.getWjByColorPlace6();
					String wjByColorPlace7 = coOptionJacketWashableInfo.getWjByColorPlace7();
					String wjByColorPlace8 = coOptionJacketWashableInfo.getWjByColorPlace8();
					String wjByColorPlace9 = coOptionJacketWashableInfo.getWjByColorPlace9();
					String wjByColorPlace10 = coOptionJacketWashableInfo.getWjByColorPlace10();
					String wjByColorPlace11 = coOptionJacketWashableInfo.getWjByColorPlace11();
					String wjByColorPlace12 = coOptionJacketWashableInfo.getWjByColorPlace12();
					String wjByColorPlace13 = coOptionJacketWashableInfo.getWjByColorPlace13();
					String wjByColorPlace14 = coOptionJacketWashableInfo.getWjByColorPlace14();
					String wjByColorPlace15 = coOptionJacketWashableInfo.getWjByColorPlace15();
					String wjByColorPlace16 = coOptionJacketWashableInfo.getWjByColorPlace16();
					
					String wjByColor1 = coOptionJacketWashableInfo.getWjByColor1();
					String wjByColor2 = coOptionJacketWashableInfo.getWjByColor2();
					String wjByColor3 = coOptionJacketWashableInfo.getWjByColor3();
					String wjByColor4 = coOptionJacketWashableInfo.getWjByColor4();
					String wjByColor5 = coOptionJacketWashableInfo.getWjByColor5();
					String wjByColor6 = coOptionJacketWashableInfo.getWjByColor6();
					String wjByColor7 = coOptionJacketWashableInfo.getWjByColor7();
					String wjByColor8 = coOptionJacketWashableInfo.getWjByColor8();
					String wjByColor9 = coOptionJacketWashableInfo.getWjByColor9();
					String wjByColor10 = coOptionJacketWashableInfo.getWjByColor10();
					String wjByColor11 = coOptionJacketWashableInfo.getWjByColor11();
					String wjByColor12 = coOptionJacketWashableInfo.getWjByColor12();
					String wjByColor13 = coOptionJacketWashableInfo.getWjByColor13();
					String wjByColor14 = coOptionJacketWashableInfo.getWjByColor14();
					String wjByColor15 = coOptionJacketWashableInfo.getWjByColor15();
					String wjByColor16 = coOptionJacketWashableInfo.getWjByColor16();
					
					if (isEmpty(wjByColorPlace1) && isEmpty(wjByColorPlace2) && isEmpty(wjByColorPlace3)
							&& isEmpty(wjByColorPlace4) && isEmpty(wjByColorPlace5) && isEmpty(wjByColorPlace6)
							&& isEmpty(wjByColorPlace7) && isEmpty(wjByColorPlace8) && isEmpty(wjByColorPlace9)
							&& isEmpty(wjByColorPlace10)&& isEmpty(wjByColorPlace11)&& isEmpty(wjByColorPlace12)
							&& isEmpty(wjByColorPlace13)&& isEmpty(wjByColorPlace14)&& isEmpty(wjByColorPlace15)
							&& isEmpty(wjByColorPlace16)) {
						messages.add("E032", "ボタン付け糸指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(wjByColorPlace1)&&isEmpty(wjByColor1)||isNotEmpty(wjByColorPlace2)&&isEmpty(wjByColor2)||
					   isNotEmpty(wjByColorPlace3)&&isEmpty(wjByColor3)||isNotEmpty(wjByColorPlace4)&&isEmpty(wjByColor4)||
					   isNotEmpty(wjByColorPlace5)&&isEmpty(wjByColor5)||isNotEmpty(wjByColorPlace6)&&isEmpty(wjByColor6)||
					   isNotEmpty(wjByColorPlace7)&&isEmpty(wjByColor7)||isNotEmpty(wjByColorPlace8)&&isEmpty(wjByColor8)||
					   isNotEmpty(wjByColorPlace9)&&isEmpty(wjByColor9)||isNotEmpty(wjByColorPlace10)&&isEmpty(wjByColor10)||
					   isNotEmpty(wjByColorPlace11)&&isEmpty(wjByColor11)||isNotEmpty(wjByColorPlace12)&&isEmpty(wjByColor12)||
					   isNotEmpty(wjByColorPlace13)&&isEmpty(wjByColor13)||isNotEmpty(wjByColorPlace14)&&isEmpty(wjByColor14)||
					   isNotEmpty(wjByColorPlace15)&&isEmpty(wjByColor15)||isNotEmpty(wjByColorPlace16)&&isEmpty(wjByColor16)) {
						messages.add("E032", "ボタン付け糸指定");
						jacketFlag = true;
					}
				}
			}
			
			//補正
			CoAdjustJacketStandardInfo coAdjustJacketStandardInfo = orderCoForm.getCoAdjustJacketStandardInfo();
			if(coAdjustJacketStandardInfo == null) {
				 messages.add("E031", "JACKETサイズ");
				 jacketFlag = true;
			}else {
				String sizeFigure = coAdjustJacketStandardInfo.getSizeFigure();
				if("".equals(sizeFigure)||null == sizeFigure) {
					messages.add("E031", "JACKETサイズ体型");
					jacketFlag = true;
				}
				String sizeNumber = coAdjustJacketStandardInfo.getSizeNumber();
				if("".equals(sizeNumber)||null == sizeNumber) {
					messages.add("E031", "JACKETサイズ号数");
					jacketFlag = true;
				}
			}
			
			// 標準の場合
			if ("9000101".equals(productCategory)) {
				// PANTS モデル未選択の場合
				CoOptionPantsStandardInfo coOptionPantsStandardInfo = orderCoForm.getCoOptionPantsStandardInfo();
				String opPantsModel = coOptionPantsStandardInfo.getOpPantsModel();
				if ("".equals(opPantsModel) || null == opPantsModel) {
					messages.add("E031", "PANTS モデル");
					jacketFlag = true;
				}
				// ベルトループ
				String opBeltLoop = coOptionPantsStandardInfo.getOpBeltLoop();
				if (OptionCodeKeys.PT_0000701.equals(opBeltLoop)) {
					String opBeltLoopPlace1 = coOptionPantsStandardInfo.getOpBeltLoopPlace1();
					String opBeltLoopPlace2 = coOptionPantsStandardInfo.getOpBeltLoopPlace2();
					String opBeltLoopPlace3 = coOptionPantsStandardInfo.getOpBeltLoopPlace3();
					String opBeltLoopPlace4 = coOptionPantsStandardInfo.getOpBeltLoopPlace4();
					String opBeltLoopPlace5 = coOptionPantsStandardInfo.getOpBeltLoopPlace5();
					String opBeltLoopPlace6 = coOptionPantsStandardInfo.getOpBeltLoopPlace6();

					if (isEmpty(opBeltLoopPlace1) && isEmpty(opBeltLoopPlace2) && isEmpty(opBeltLoopPlace3)
							&& isEmpty(opBeltLoopPlace4) && isEmpty(opBeltLoopPlace5) && isEmpty(opBeltLoopPlace6)) {
						messages.add("E033", "PANTS ベルトループ");
						jacketFlag = true;
					}
				}
				// ステッチ箇所変更
				String opStitchModify = coOptionPantsStandardInfo.getOpStitchModify();
				if (OptionCodeKeys.PT_0002002.equals(opStitchModify)) {
					String opStitchModifyPlace1 = coOptionPantsStandardInfo.getOpStitchModifyPlace1();
					String opStitchModifyPlace2 = coOptionPantsStandardInfo.getOpStitchModifyPlace2();
					String opStitchModifyPlace3 = coOptionPantsStandardInfo.getOpStitchModifyPlace3();
					String opStitchModifyPlace4 = coOptionPantsStandardInfo.getOpStitchModifyPlace4();

					if (isEmpty(opStitchModifyPlace1) && isEmpty(opStitchModifyPlace2) && isEmpty(opStitchModifyPlace3)
							&& isEmpty(opStitchModifyPlace4)) {
						messages.add("E033", "PANTS ステッチ箇所変更");
						jacketFlag = true;
					}
				}
				// ダブルステッチ
				String opDStitch = coOptionPantsStandardInfo.getOpDStitch();
				if (OptionCodeKeys.PT_0002202.equals(opDStitch)) {
					String opDStitchPlace1 = coOptionPantsStandardInfo.getOpDStitchPlace1();
					String opDStitchPlace2 = coOptionPantsStandardInfo.getOpDStitchPlace2();
					String opDStitchPlace3 = coOptionPantsStandardInfo.getOpDStitchPlace3();
					String opDStitchPlace4 = coOptionPantsStandardInfo.getOpDStitchPlace4();

					if (isEmpty(opDStitchPlace1) && isEmpty(opDStitchPlace2) && isEmpty(opDStitchPlace3)
							&& isEmpty(opDStitchPlace4)) {
						messages.add("E033", "PANTS ダブルステッチ");
						jacketFlag = true;
					}
				}
				// AMF色指定
				String opAmfColor = coOptionPantsStandardInfo.getOpAmfColor();
				if (OptionCodeKeys.PT_0002402.equals(opAmfColor)) {
					String opAmfColorPlace1 = coOptionPantsStandardInfo.getOpAmfColorPlace1();
					String opAmfColorPlace2 = coOptionPantsStandardInfo.getOpAmfColorPlace2();
					String opAmfColorPlace3 = coOptionPantsStandardInfo.getOpAmfColorPlace3();
					String opAmfColorPlace4 = coOptionPantsStandardInfo.getOpAmfColorPlace4();
					
					String opAmfColor1 = coOptionPantsStandardInfo.getOpAmfColor1();
					String opAmfColor2 = coOptionPantsStandardInfo.getOpAmfColor2();
					String opAmfColor3 = coOptionPantsStandardInfo.getOpAmfColor3();
					String opAmfColor4 = coOptionPantsStandardInfo.getOpAmfColor4();

					if (isEmpty(opAmfColorPlace1) && isEmpty(opAmfColorPlace2) && isEmpty(opAmfColorPlace3)
							&& isEmpty(opAmfColorPlace4)) {
						messages.add("E033", "PANTS AMF色指定");
						jacketFlag = true;
					}
					if(isNotEmpty(opAmfColorPlace1)&&isEmpty(opAmfColor1)||isNotEmpty(opAmfColorPlace2)&&isEmpty(opAmfColor2)||
					   isNotEmpty(opAmfColorPlace3)&&isEmpty(opAmfColor3)||isNotEmpty(opAmfColorPlace4)&&isEmpty(opAmfColor4)) {
							messages.add("E033", "PANTS AMF色指定");
							jacketFlag = true;
					}
				}
				// ボタンホール色指定
				String opBhColor = coOptionPantsStandardInfo.getOpBhColor();
				if (OptionCodeKeys.PT_0002702.equals(opBhColor)) {
					String opBhColorPlace1 = coOptionPantsStandardInfo.getOpBhColorPlace1();
					String opBhColorPlace2 = coOptionPantsStandardInfo.getOpBhColorPlace2();
					String opBhColorPlace3 = coOptionPantsStandardInfo.getOpBhColorPlace3();
					String opBhColorPlace4 = coOptionPantsStandardInfo.getOpBhColorPlace4();

					String opBhColor1 = coOptionPantsStandardInfo.getOpBhColor1();
					String opBhColor2 = coOptionPantsStandardInfo.getOpBhColor2();
					String opBhColor3 = coOptionPantsStandardInfo.getOpBhColor3();
					String opBhColor4 = coOptionPantsStandardInfo.getOpBhColor4();
					if (isEmpty(opBhColorPlace1) && isEmpty(opBhColorPlace2) && isEmpty(opBhColorPlace3)
							&& isEmpty(opBhColorPlace4)) {
						messages.add("E033", "PANTS ボタンホール色指定");
						jacketFlag = true;
					}
					if(isNotEmpty(opBhColorPlace1)&&isEmpty(opBhColor1)||isNotEmpty(opBhColorPlace2)&&isEmpty(opBhColor2)||
					   isNotEmpty(opBhColorPlace3)&&isEmpty(opBhColor3)||isNotEmpty(opBhColorPlace4)&&isEmpty(opBhColor4)) {
					    messages.add("E033", "PANTS ボタンホール色指定");
					    jacketFlag = true;
					}
				}

				//PANTS  ボタン付け糸指定
				String opByColor = coOptionPantsStandardInfo.getOpByColor();
				if (OptionCodeKeys.PT_0003002.equals(opByColor)) {
					String opByColorPlace1 = coOptionPantsStandardInfo.getOpByColorPlace1();
					String opByColorPlace2 = coOptionPantsStandardInfo.getOpByColorPlace2();
					String opByColorPlace3 = coOptionPantsStandardInfo.getOpByColorPlace3();
					String opByColorPlace4 = coOptionPantsStandardInfo.getOpByColorPlace4();

					String opByColor1 = coOptionPantsStandardInfo.getOpByColor1();
					String opByColor2 = coOptionPantsStandardInfo.getOpByColor2();
					String opByColor3 = coOptionPantsStandardInfo.getOpByColor3();
					String opByColor4 = coOptionPantsStandardInfo.getOpByColor4();
					if (isEmpty(opByColorPlace1) && isEmpty(opByColorPlace2) && isEmpty(opByColorPlace3)
							&& isEmpty(opByColorPlace4)) {
						messages.add("E033", "PANTS ボタン付け糸指定");
						jacketFlag = true;
					}
					if(isNotEmpty(opByColorPlace1)&&isEmpty(opByColor1)||isNotEmpty(opByColorPlace2)&&isEmpty(opByColor2)||
					   isNotEmpty(opByColorPlace3)&&isEmpty(opByColor3)||isNotEmpty(opByColorPlace4)&&isEmpty(opByColor4)) {
						messages.add("E033", "PANTS ボタン付け糸指定");
						jacketFlag = true;
					}
				}
				// タキシードの場合
			} else if ("9000102".equals(productCategory)) {
				// PANTS モデル未選択の場合
				CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo = orderCoForm.getCoOptionPantsTuxedoInfo();
				String tpPantsModel = coOptionPantsTuxedoInfo.getTpPantsModel();
				if ("".equals(tpPantsModel) || null == tpPantsModel) {
					messages.add("E031", "PANTS モデル");
					jacketFlag = true;
				}
				//PANTS  ベルトループ
				String tpBeltLoop = coOptionPantsTuxedoInfo.getTpBeltLoop();
				if (OptionCodeKeys.PT_0000701.equals(tpBeltLoop)) {
					String tpBeltLoopPlace1 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace1();
					String tpBeltLoopPlace2 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace2();
					String tpBeltLoopPlace3 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace3();
					String tpBeltLoopPlace4 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace4();
					String tpBeltLoopPlace5 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace5();
					String tpBeltLoopPlace6 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace6();
					String tpBeltLoopPlace7 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace7();

					if (isEmpty(tpBeltLoopPlace1) && isEmpty(tpBeltLoopPlace2) && isEmpty(tpBeltLoopPlace3)
							&& isEmpty(tpBeltLoopPlace4) && isEmpty(tpBeltLoopPlace5) && isEmpty(tpBeltLoopPlace6)
							&& isEmpty(tpBeltLoopPlace7)) {
						messages.add("E033", "PANTS ベルトループ");
						jacketFlag = true;
					}
					//PANTS  ボタンホール色指定
					String opBhColor = coOptionPantsTuxedoInfo.getTpBhColor();
					if (OptionCodeKeys.PT_0002702.equals(opBhColor)) {
						String tpBhColorPlace1 = coOptionPantsTuxedoInfo.getTpBhColorPlace1();
						String tpBhColorPlace2 = coOptionPantsTuxedoInfo.getTpBhColorPlace2();
						String tpBhColorPlace3 = coOptionPantsTuxedoInfo.getTpBhColorPlace3();
						String tpBhColorPlace4 = coOptionPantsTuxedoInfo.getTpBhColorPlace4();

						String tpBhColor1 = coOptionPantsTuxedoInfo.getTpBhColor1();
						String tpBhColor2 = coOptionPantsTuxedoInfo.getTpBhColor2();
						String tpBhColor3 = coOptionPantsTuxedoInfo.getTpBhColor3();
						String tpBhColor4 = coOptionPantsTuxedoInfo.getTpBhColor4();
						
						if (isEmpty(tpBhColorPlace1) && isEmpty(tpBhColorPlace2) && isEmpty(tpBhColorPlace3)
								&& isEmpty(tpBhColorPlace4)) {
							messages.add("E033", "PANTS ボタンホール色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(tpBhColorPlace1)&&isEmpty(tpBhColor1)||isNotEmpty(tpBhColorPlace2)&&isEmpty(tpBhColor2)||
						   isNotEmpty(tpBhColorPlace3)&&isEmpty(tpBhColor3)||isNotEmpty(tpBhColorPlace4)&&isEmpty(tpBhColor4)) {
							 messages.add("E033", "PANTS ボタンホール色指定");
							 jacketFlag = true;
						}
					}
						//PANTS  ボタン付け糸指定
						String tpByColor = coOptionPantsTuxedoInfo.getTpByColor();
						if (OptionCodeKeys.PT_0003002.equals(tpByColor)) {
							String tpByColorPlace1 = coOptionPantsTuxedoInfo.getTpByColorPlace1();
							String tpByColorPlace2 = coOptionPantsTuxedoInfo.getTpByColorPlace2();
							String tpByColorPlace3 = coOptionPantsTuxedoInfo.getTpByColorPlace3();
							String tpByColorPlace4 = coOptionPantsTuxedoInfo.getTpByColorPlace4();

							String tpByColor1 = coOptionPantsTuxedoInfo.getTpByColor1();
							String tpByColor2 = coOptionPantsTuxedoInfo.getTpByColor2();
							String tpByColor3 = coOptionPantsTuxedoInfo.getTpByColor3();
							String tpByColor4 = coOptionPantsTuxedoInfo.getTpByColor4();
							
							if (isEmpty(tpByColorPlace1) && isEmpty(tpByColorPlace2) && isEmpty(tpByColorPlace3)
									&& isEmpty(tpByColorPlace4)) {
								messages.add("E033", "PANTS ボタン付け糸指定");
								jacketFlag = true;
							}
							
							if(isNotEmpty(tpByColorPlace1)&&isEmpty(tpByColor1)||isNotEmpty(tpByColorPlace2)&&isEmpty(tpByColor2)||
								isNotEmpty(tpByColorPlace3)&&isEmpty(tpByColor3)||isNotEmpty(tpByColorPlace4)&&isEmpty(tpByColor4)) {
								messages.add("E033", "PANTS ボタン付け糸指定");
							    jacketFlag = true;
							}
						}
					
				}
			} else if ("9000103".equals(productCategory)) {
				// PANTS モデル未選択の場合
				CoOptionPantsWashableInfo coOptionPantsWashableInfo = orderCoForm.getCoOptionPantsWashableInfo();
				String wpPantsModel = coOptionPantsWashableInfo.getWpPantsModel();
				if ("".equals(wpPantsModel) || null == wpPantsModel) {
					messages.add("E031", "PANTS モデル");
					jacketFlag = true;
				}
				//PANTS  ステッチ箇所変更
				String wpStitchModify = coOptionPantsWashableInfo.getWpStitchModify();
				if (OptionCodeKeys.PT_0002002.equals(wpStitchModify)) {
					String wpStitchModifyPlace1 = coOptionPantsWashableInfo.getWpStitchModifyPlace1();
					String wpStitchModifyPlace2 = coOptionPantsWashableInfo.getWpStitchModifyPlace2();
					String wpStitchModifyPlace3 = coOptionPantsWashableInfo.getWpStitchModifyPlace3();
					String wpStitchModifyPlace4 = coOptionPantsWashableInfo.getWpStitchModifyPlace4();
					if (isEmpty(wpStitchModifyPlace1) && isEmpty(wpStitchModifyPlace2) && isEmpty(wpStitchModifyPlace3)
							&& isEmpty(wpStitchModifyPlace4)) {
						messages.add("E033", "PANTS ステッチ箇所変更");
						jacketFlag = true;
					}
				}
				//PANTS  ダブルステッチ
				String wpDStitch = coOptionPantsWashableInfo.getWpDStitch();
				if (OptionCodeKeys.PT_0002202.equals(wpDStitch)) {
					String wpDStitchPlace1 = coOptionPantsWashableInfo.getWpDStitchPlace1();
					String wpDStitchPlace2 = coOptionPantsWashableInfo.getWpDStitchPlace2();
					String wpDStitchPlace3 = coOptionPantsWashableInfo.getWpDStitchPlace3();
					String wpDStitchPlace4 = coOptionPantsWashableInfo.getWpDStitchPlace4();
					if (isEmpty(wpDStitchPlace1) && isEmpty(wpDStitchPlace2) && isEmpty(wpDStitchPlace3)
							&& isEmpty(wpDStitchPlace4)) {
						messages.add("E033", "PANTS ダブルステッチ");
						jacketFlag = true;
					}
				}

				//PANTS  AMF色指定
				String wpamfColor = coOptionPantsWashableInfo.getWpAmfColor();
				if (OptionCodeKeys.PT_0002402.equals(wpamfColor)) {
					String wpamfColorPlace1 = coOptionPantsWashableInfo.getWpAmfColorPlace1();
					String wpamfColorPlace2 = coOptionPantsWashableInfo.getWpAmfColorPlace2();
					String wpamfColorPlace3 = coOptionPantsWashableInfo.getWpAmfColorPlace3();
					String wpamfColorPlace4 = coOptionPantsWashableInfo.getWpAmfColorPlace4();
					
					String wpamfColor1 = coOptionPantsWashableInfo.getWpAmfColor1();
					String wpamfColor2 = coOptionPantsWashableInfo.getWpAmfColor2();
					String wpamfColor3 = coOptionPantsWashableInfo.getWpAmfColor3();
					String wpamfColor4 = coOptionPantsWashableInfo.getWpAmfColor4();
					
					if (isEmpty(wpamfColorPlace1) && isEmpty(wpamfColorPlace2) && isEmpty(wpamfColorPlace3)
							&& isEmpty(wpamfColorPlace4)) {
						messages.add("E033", "PANTS AMF色指定");
						jacketFlag = true;
					}
					if(isNotEmpty(wpamfColorPlace1)&&isEmpty(wpamfColor1)||isNotEmpty(wpamfColorPlace2)&&isEmpty(wpamfColor2)||
					   isNotEmpty(wpamfColorPlace3)&&isEmpty(wpamfColor3)||isNotEmpty(wpamfColorPlace4)&&isEmpty(wpamfColor4)) {
						messages.add("E033", "PANTS AMF色指定");
						jacketFlag = true;
					}
				}

				//PANTS  ボタンホール色指定
				String wpBhColor = coOptionPantsWashableInfo.getWpBhColor();
				if (OptionCodeKeys.PT_0002702.equals(wpBhColor)) {
					String wpBhColorPlace1 = coOptionPantsWashableInfo.getWpBhColorPlace1();
					String wpBhColorPlace2 = coOptionPantsWashableInfo.getWpBhColorPlace2();
					String wpBhColorPlace3 = coOptionPantsWashableInfo.getWpBhColorPlace3();
					String wpBhColorPlace4 = coOptionPantsWashableInfo.getWpBhColorPlace4();

					String wpBhColor1 = coOptionPantsWashableInfo.getWpBhColor1();
					String wpBhColor2 = coOptionPantsWashableInfo.getWpBhColor2();
					String wpBhColor3 = coOptionPantsWashableInfo.getWpBhColor3();
					String wpBhColor4 = coOptionPantsWashableInfo.getWpBhColor4();
					
					if (isEmpty(wpBhColorPlace1) && isEmpty(wpBhColorPlace2) && isEmpty(wpBhColorPlace3)
							&& isEmpty(wpBhColorPlace4)) {
						messages.add("E033", "PANTS ボタンホール色指定");
						jacketFlag = true;
					}
					if(isNotEmpty(wpBhColorPlace1)&&isEmpty(wpBhColor1)||isNotEmpty(wpBhColorPlace2)&&isEmpty(wpBhColor2)||
					   isNotEmpty(wpBhColorPlace3)&&isEmpty(wpBhColor3)||isNotEmpty(wpBhColorPlace4)&&isEmpty(wpBhColor4)) {
						messages.add("E033", "PANTS ボタンホール色指定");
					    jacketFlag = true;
					}
				}

				// ボタン付け糸指定
				String wpByColor = coOptionPantsWashableInfo.getWpByColor();
				if (OptionCodeKeys.PT_0003002.equals(wpByColor)) {
					String wpByColorPlace1 = coOptionPantsWashableInfo.getWpByColorPlace1();
					String wpByColorPlace2 = coOptionPantsWashableInfo.getWpByColorPlace2();
					String wpByColorPlace3 = coOptionPantsWashableInfo.getWpByColorPlace3();
					String wpByColorPlace4 = coOptionPantsWashableInfo.getWpByColorPlace4();
					
					String wpByColor1 = coOptionPantsWashableInfo.getWpByColor1();
					String wpByColor2 = coOptionPantsWashableInfo.getWpByColor2();
					String wpByColor3 = coOptionPantsWashableInfo.getWpByColor3();
					String wpByColor4 = coOptionPantsWashableInfo.getWpByColor4();
					if (isEmpty(wpByColorPlace1) && isEmpty(wpByColorPlace2) && isEmpty(wpByColorPlace3)
							&& isEmpty(wpByColorPlace4)) {
						messages.add("E033", "ボタン付け糸指定");
						jacketFlag = true;
					}
					if(isNotEmpty(wpByColorPlace1)&&isEmpty(wpByColor1)||isNotEmpty(wpByColorPlace2)&&isEmpty(wpByColor2)||
					   isNotEmpty(wpByColorPlace3)&&isEmpty(wpByColor3)||isNotEmpty(wpByColorPlace4)&&isEmpty(wpByColor4)) {
						messages.add("E033", "PANTS  ボタン付け糸指定");
						jacketFlag = true;
					}
				}
			}

			// 補正
			CoAdjustPantsStandardInfo coAdjustPantsStandardInfo = orderCoForm.getCoAdjustPantsStandardInfo();
			if (coAdjustPantsStandardInfo == null) {
				messages.add("E031", "PANTSサイズ");
				jacketFlag = true;
			} else {
				String sizeFigure = coAdjustPantsStandardInfo.getSizeFigure();
				if ("".equals(sizeFigure) || null == sizeFigure) {
					messages.add("E031", "PANTSサイズ体型");
					jacketFlag = true;
				}
				String sizeNumber = coAdjustPantsStandardInfo.getSizeNumber();
				if ("".equals(sizeNumber) || null == sizeNumber) {
					messages.add("E031", "PANTSサイズ号数");
					jacketFlag = true;
				}
				String corPtLeftinseamGross = coAdjustPantsStandardInfo.getCorPtLeftinseamGross();
				boolean falg=GrossCompareTo(corPtLeftinseamGross,messages,"PANTS（1本目）左股下");
				if(falg) {
					jacketFlag = true;
				}
				String corPtRightinseamGross = coAdjustPantsStandardInfo.getCorPtRightinseamGross();
				falg=GrossCompareTo(corPtRightinseamGross,messages,"PANTS（1本目）右股下");
				if(falg) {
					jacketFlag = true;
				}
				
			}
			if(OptionCodeKeys.TWO_PANTS.equals(twoPants)) {
				// 標準の場合
				if ("9000101".equals(productCategory)) {
					// PANTS2 モデル未選択の場合
					CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
					String op2PantsModel = coOptionPants2StandardInfo.getOp2PantsModel();
					if ("".equals(op2PantsModel) || null == op2PantsModel) {
						messages.add("E031", "PANTS（2本目） モデル");
						jacketFlag = true;
					}
					// ベルトループ
					String op2BeltLoop = coOptionPants2StandardInfo.getOp2BeltLoop();
					if (OptionCodeKeys.PT2_0000701.equals(op2BeltLoop)) {
						String op2BeltLoopPlace1 = coOptionPants2StandardInfo.getOp2BeltLoopPlace1();
						String op2BeltLoopPlace2 = coOptionPants2StandardInfo.getOp2BeltLoopPlace2();
						String op2BeltLoopPlace3 = coOptionPants2StandardInfo.getOp2BeltLoopPlace3();
						String op2BeltLoopPlace4 = coOptionPants2StandardInfo.getOp2BeltLoopPlace4();
						String op2BeltLoopPlace5 = coOptionPants2StandardInfo.getOp2BeltLoopPlace5();
						String op2BeltLoopPlace6 = coOptionPants2StandardInfo.getOp2BeltLoopPlace6();

						if (isEmpty(op2BeltLoopPlace1) && isEmpty(op2BeltLoopPlace2) && isEmpty(op2BeltLoopPlace3)
								&& isEmpty(op2BeltLoopPlace4) && isEmpty(op2BeltLoopPlace5) && isEmpty(op2BeltLoopPlace6)) {
							messages.add("E033", "PANTS（2本目）    ベルトループ");
							jacketFlag = true;
						}
					}
					// ステッチ箇所変更
					String op2StitchModify = coOptionPants2StandardInfo.getOp2StitchModify();
					if (OptionCodeKeys.PT2_0002002.equals(op2StitchModify)) {
						String op2StitchModifyPlace1 = coOptionPants2StandardInfo.getOp2StitchModifyPlace1();
						String op2StitchModifyPlace2 = coOptionPants2StandardInfo.getOp2StitchModifyPlace2();
						String op2StitchModifyPlace3 = coOptionPants2StandardInfo.getOp2StitchModifyPlace3();
						String op2StitchModifyPlace4 = coOptionPants2StandardInfo.getOp2StitchModifyPlace4();

						if (isEmpty(op2StitchModifyPlace1) && isEmpty(op2StitchModifyPlace2) && isEmpty(op2StitchModifyPlace3)
								&& isEmpty(op2StitchModifyPlace4)) {
							messages.add("E033", "PANTS（2本目）   ステッチ箇所変更");
							jacketFlag = true;
						}
					}
					// ダブルステッチ
					String op2DStitch = coOptionPants2StandardInfo.getOp2DStitch();
					if (OptionCodeKeys.PT2_0002202.equals(op2DStitch)) {
						String op2DStitchPlace1 = coOptionPants2StandardInfo.getOp2DStitchPlace1();
						String op2DStitchPlace2 = coOptionPants2StandardInfo.getOp2DStitchPlace2();
						String op2DStitchPlace3 = coOptionPants2StandardInfo.getOp2DStitchPlace3();
						String op2DStitchPlace4 = coOptionPants2StandardInfo.getOp2DStitchPlace4();

						if (isEmpty(op2DStitchPlace1) && isEmpty(op2DStitchPlace2) && isEmpty(op2DStitchPlace3)
								&& isEmpty(op2DStitchPlace4)) {
							messages.add("E033", "PANTS（2本目）  ダブルステッチ");
							jacketFlag = true;
						}
					}
					// AMF色指定
					String op2AmfColor = coOptionPants2StandardInfo.getOp2AmfColor();
					if (OptionCodeKeys.PT2_0002402.equals(op2AmfColor)) {
						String op2AmfColorPlace1 = coOptionPants2StandardInfo.getOp2AmfColorPlace1();
						String op2AmfColorPlace2 = coOptionPants2StandardInfo.getOp2AmfColorPlace2();
						String op2AmfColorPlace3 = coOptionPants2StandardInfo.getOp2AmfColorPlace3();
						String op2AmfColorPlace4 = coOptionPants2StandardInfo.getOp2AmfColorPlace4();

						String op2AmfColor1 = coOptionPants2StandardInfo.getOp2AmfColor1();
						String op2AmfColor2 = coOptionPants2StandardInfo.getOp2AmfColor2();
						String op2AmfColor3 = coOptionPants2StandardInfo.getOp2AmfColor3();
						String op2AmfColor4 = coOptionPants2StandardInfo.getOp2AmfColor4();
						if (isEmpty(op2AmfColorPlace1) && isEmpty(op2AmfColorPlace2) && isEmpty(op2AmfColorPlace3)
								&& isEmpty(op2AmfColorPlace4)) {
							messages.add("E033", "PANTS（2本目） AMF色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(op2AmfColorPlace1)&&isEmpty(op2AmfColor1)||isNotEmpty(op2AmfColorPlace2)&&isEmpty(op2AmfColor2)||
						   isNotEmpty(op2AmfColorPlace3)&&isEmpty(op2AmfColor3)||isNotEmpty(op2AmfColorPlace4)&&isEmpty(op2AmfColor4)) {
							messages.add("E033", "PANTS（2本目） AMF色指定");
							jacketFlag = true;
						}
					}
					//PANTS2  ボタンホール色指定
					String op2BhColor = coOptionPants2StandardInfo.getOp2BhColor();
					if (OptionCodeKeys.PT2_0002702.equals(op2BhColor)) {
						String op2BhColorPlace1 = coOptionPants2StandardInfo.getOp2BhColorPlace1();
						String op2BhColorPlace2 = coOptionPants2StandardInfo.getOp2BhColorPlace2();
						String op2BhColorPlace3 = coOptionPants2StandardInfo.getOp2BhColorPlace3();
						String op2BhColorPlace4 = coOptionPants2StandardInfo.getOp2BhColorPlace4();

						String op2BhColor1 = coOptionPants2StandardInfo.getOp2BhColor1();
						String op2BhColor2 = coOptionPants2StandardInfo.getOp2BhColor2();
						String op2BhColor3 = coOptionPants2StandardInfo.getOp2BhColor3();
						String op2BhColor4 = coOptionPants2StandardInfo.getOp2BhColor4();
						
						if (isEmpty(op2BhColorPlace1) && isEmpty(op2BhColorPlace2) && isEmpty(op2BhColorPlace3)
								&& isEmpty(op2BhColorPlace4)) {
							messages.add("E033", "PANTS（2本目）   ボタンホール色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(op2BhColorPlace1)&&isEmpty(op2BhColor1)||isNotEmpty(op2BhColorPlace2)&&isEmpty(op2BhColor2)||
						   isNotEmpty(op2BhColorPlace3)&&isEmpty(op2BhColor3)||isNotEmpty(op2BhColorPlace4)&&isEmpty(op2BhColor4)) {
							messages.add("E033", "PANTS（2本目）   ボタンホール色指定");
							jacketFlag = true;
						}
					}

					// ボタン付け糸指定
					String op2ByColor = coOptionPants2StandardInfo.getOp2ByColor();
					if (OptionCodeKeys.PT2_0003002.equals(op2ByColor)) {
						String op2ByColorPlace1 = coOptionPants2StandardInfo.getOp2ByColorPlace1();
						String op2ByColorPlace2 = coOptionPants2StandardInfo.getOp2ByColorPlace2();
						String op2ByColorPlace3 = coOptionPants2StandardInfo.getOp2ByColorPlace3();
						String op2ByColorPlace4 = coOptionPants2StandardInfo.getOp2ByColorPlace4();

						String op2ByColor1 = coOptionPants2StandardInfo.getOp2ByColor1();
						String op2ByColor2 = coOptionPants2StandardInfo.getOp2ByColor2();
						String op2ByColor3 = coOptionPants2StandardInfo.getOp2ByColor3();
						String op2ByColor4 = coOptionPants2StandardInfo.getOp2ByColor4();
						if (isEmpty(op2ByColorPlace1) && isEmpty(op2ByColorPlace2) && isEmpty(op2ByColorPlace3)
								&& isEmpty(op2ByColorPlace4)) {
							messages.add("E033", "PANTS（2本目）   ボタン付け糸指定");
							jacketFlag = true;
						}
						if(isNotEmpty(op2ByColorPlace1)&&isEmpty(op2ByColor1)||isNotEmpty(op2ByColorPlace2)&&isEmpty(op2ByColor2)||
						   isNotEmpty(op2ByColorPlace3)&&isEmpty(op2ByColor3)||isNotEmpty(op2ByColorPlace4)&&isEmpty(op2ByColor4)) {
							messages.add("E033", "PANTS（2本目）   ボタン付け糸指定");
							jacketFlag = true;
						}
					}
					//PANTS  タキシードの場合
				} else if ("9000102".equals(productCategory)) {
					// PANTS モデル未選択の場合
					CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
					String tp2PantsModel = coOptionPants2TuxedoInfo.getTp2PantsModel();
					if ("".equals(tp2PantsModel) || null == tp2PantsModel) {
						messages.add("E031", "PANTS（2本目） モデル");
						jacketFlag = true;
					}
					//PANTS  ベルトループ
					String tp2BeltLoop = coOptionPants2TuxedoInfo.getTp2BeltLoop();
					if (OptionCodeKeys.PT2_0000701.equals(tp2BeltLoop)) {
						String tp2BeltLoopPlace1 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace1();
						String tp2BeltLoopPlace2 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace2();
						String tp2BeltLoopPlace3 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace3();
						String tp2BeltLoopPlace4 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace4();
						String tp2BeltLoopPlace5 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace5();
						String tp2BeltLoopPlace6 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace6();
						String tp2BeltLoopPlace7 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace7();

						if (isEmpty(tp2BeltLoopPlace1) && isEmpty(tp2BeltLoopPlace2) && isEmpty(tp2BeltLoopPlace3)
								&& isEmpty(tp2BeltLoopPlace4) && isEmpty(tp2BeltLoopPlace5) && isEmpty(tp2BeltLoopPlace6)
								&& isEmpty(tp2BeltLoopPlace7)) {
							messages.add("E033", "PANTS（2本目）   ベルトループ");
							jacketFlag = true;
						}
						// ボタンホール色指定
						String op2BhColor = coOptionPants2TuxedoInfo.getTp2BhColor();
						if (OptionCodeKeys.PT2_0002702.equals(op2BhColor)) {
							String tp2BhColorPlace1 = coOptionPants2TuxedoInfo.getTp2BhColorPlace1();
							String tp2BhColorPlace2 = coOptionPants2TuxedoInfo.getTp2BhColorPlace2();
							String tp2BhColorPlace3 = coOptionPants2TuxedoInfo.getTp2BhColorPlace3();
							String tp2BhColorPlace4 = coOptionPants2TuxedoInfo.getTp2BhColorPlace4();

							String tp2BhColor1 = coOptionPants2TuxedoInfo.getTp2BhColor1();
							String tp2BhColor2 = coOptionPants2TuxedoInfo.getTp2BhColor2();
							String tp2BhColor3 = coOptionPants2TuxedoInfo.getTp2BhColor3();
							String tp2BhColor4 = coOptionPants2TuxedoInfo.getTp2BhColor4();
							
							if (isEmpty(tp2BhColorPlace1) && isEmpty(tp2BhColorPlace2) && isEmpty(tp2BhColorPlace3)
									&& isEmpty(tp2BhColorPlace4)) {
								messages.add("E033", "PANTS（2本目）  ボタンホール色指定");
								jacketFlag = true;
							}
							if(isNotEmpty(tp2BhColorPlace1)&&isEmpty(tp2BhColor1)||isNotEmpty(tp2BhColorPlace2)&&isEmpty(tp2BhColor2)||
							   isNotEmpty(tp2BhColorPlace3)&&isEmpty(tp2BhColor3)||isNotEmpty(tp2BhColorPlace4)&&isEmpty(tp2BhColor4)) {
								messages.add("E033", "PANTS（2本目）  ボタンホール色指定");
								jacketFlag = true;
							}
						}
							// ボタン付け糸指定
							String tp2ByColor = coOptionPants2TuxedoInfo.getTp2ByColor();
							if (OptionCodeKeys.PT2_0003002.equals(tp2ByColor)) {
								String tp2ByColorPlace1 = coOptionPants2TuxedoInfo.getTp2ByColorPlace1();
								String tp2ByColorPlace2 = coOptionPants2TuxedoInfo.getTp2ByColorPlace2();
								String tp2ByColorPlace3 = coOptionPants2TuxedoInfo.getTp2ByColorPlace3();
								String tp2ByColorPlace4 = coOptionPants2TuxedoInfo.getTp2ByColorPlace4();

								String tp2ByColor1 = coOptionPants2TuxedoInfo.getTp2ByColor1();
								String tp2ByColor2 = coOptionPants2TuxedoInfo.getTp2ByColor2();
								String tp2ByColor3 = coOptionPants2TuxedoInfo.getTp2ByColor3();
								String tp2ByColor4 = coOptionPants2TuxedoInfo.getTp2ByColor4();
								if (isEmpty(tp2ByColorPlace1) && isEmpty(tp2ByColorPlace2) && isEmpty(tp2ByColorPlace3)
										&& isEmpty(tp2ByColorPlace4)) {
									messages.add("E033", "PANTS（2本目）   ボタン付け糸指定");
									jacketFlag = true;
								}
								if(isNotEmpty(tp2ByColorPlace1)&&isEmpty(tp2ByColor1)||isNotEmpty(tp2ByColorPlace2)&&isEmpty(tp2ByColor2)||
								   isNotEmpty(tp2ByColorPlace3)&&isEmpty(tp2ByColor3)||isNotEmpty(tp2ByColorPlace4)&&isEmpty(tp2ByColor4)) {
									messages.add("E033", "PANTS（2本目）   ボタン付け糸指定");
									jacketFlag = true;
								}
							}
						
					}
				} else if ("9000103".equals(productCategory)) {
					// PANTS モデル未選択の場合
					CoOptionPants2WashableInfo coOptionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
					String wp2PantsModel = coOptionPants2WashableInfo.getWp2PantsModel();
					if ("".equals(wp2PantsModel) || null == wp2PantsModel) {
						messages.add("E031", "PANTS（2本目） モデル");
						jacketFlag = true;
					}
					//PANTS2    ステッチ箇所変更
					String wp2StitchModify = coOptionPants2WashableInfo.getWp2StitchModify();
					if (OptionCodeKeys.PT2_0002002.equals(wp2StitchModify)) {
						String wp2StitchModifyPlace1 = coOptionPants2WashableInfo.getWp2StitchModifyPlace1();
						String wp2StitchModifyPlace2 = coOptionPants2WashableInfo.getWp2StitchModifyPlace2();
						String wp2StitchModifyPlace3 = coOptionPants2WashableInfo.getWp2StitchModifyPlace3();
						String wp2StitchModifyPlace4 = coOptionPants2WashableInfo.getWp2StitchModifyPlace4();
						if (isEmpty(wp2StitchModifyPlace1) && isEmpty(wp2StitchModifyPlace2) && isEmpty(wp2StitchModifyPlace3)
								&& isEmpty(wp2StitchModifyPlace4)) {
							messages.add("E033", "PANTS（2本目）   ステッチ箇所変更");
							jacketFlag = true;
						}
					}
					//PANTS2    ダブルステッチ
					String wp2DStitch = coOptionPants2WashableInfo.getWp2DStitch();
					if (OptionCodeKeys.PT2_0002202.equals(wp2DStitch)) {
						String wp2DStitchPlace1 = coOptionPants2WashableInfo.getWp2DStitchPlace1();
						String wp2DStitchPlace2 = coOptionPants2WashableInfo.getWp2DStitchPlace2();
						String wp2DStitchPlace3 = coOptionPants2WashableInfo.getWp2DStitchPlace3();
						String wp2DStitchPlace4 = coOptionPants2WashableInfo.getWp2DStitchPlace4();
						if (isEmpty(wp2DStitchPlace1) && isEmpty(wp2DStitchPlace2) && isEmpty(wp2DStitchPlace3)
								&& isEmpty(wp2DStitchPlace4)) {
							messages.add("E033", "PANTS（2本目）   ダブルステッチ");
							jacketFlag = true;
						}
					}

					//PANTS2  AMF色指定
					String wp2amfColor = coOptionPants2WashableInfo.getWp2AmfColor();
					if (OptionCodeKeys.PT2_0002402.equals(wp2amfColor)) {
						String wp2amfColorPlace1 = coOptionPants2WashableInfo.getWp2AmfColorPlace1();
						String wp2amfColorPlace2 = coOptionPants2WashableInfo.getWp2AmfColorPlace2();
						String wp2amfColorPlace3 = coOptionPants2WashableInfo.getWp2AmfColorPlace3();
						String wp2amfColorPlace4 = coOptionPants2WashableInfo.getWp2AmfColorPlace4();
						
						String wp2amfColor1 = coOptionPants2WashableInfo.getWp2AmfColor1();
						String wp2amfColor2 = coOptionPants2WashableInfo.getWp2AmfColor2();
						String wp2amfColor3 = coOptionPants2WashableInfo.getWp2AmfColor3();
						String wp2amfColor4 = coOptionPants2WashableInfo.getWp2AmfColor4();
						if (isEmpty(wp2amfColorPlace1) && isEmpty(wp2amfColorPlace2) && isEmpty(wp2amfColorPlace3)
								&& isEmpty(wp2amfColorPlace4)) {
							messages.add("E033", "PANTS（2本目）   AMF色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(wp2amfColorPlace1)&&isEmpty(wp2amfColor1)||isNotEmpty(wp2amfColorPlace2)&&isEmpty(wp2amfColor2)||
						   isNotEmpty(wp2amfColorPlace3)&&isEmpty(wp2amfColor3)||isNotEmpty(wp2amfColorPlace4)&&isEmpty(wp2amfColor4)) {
							messages.add("E033", "PANTS（2本目）   AMF色指定");
							jacketFlag = true;
						}
					}

					// ボタンホール色指定
					String wp2BhColor = coOptionPants2WashableInfo.getWp2BhColor();
					if (OptionCodeKeys.PT2_0002702.equals(wp2BhColor)) {
						String wp2BhColorPlace1 = coOptionPants2WashableInfo.getWp2BhColorPlace1();
						String wp2BhColorPlace2 = coOptionPants2WashableInfo.getWp2BhColorPlace2();
						String wp2BhColorPlace3 = coOptionPants2WashableInfo.getWp2BhColorPlace3();
						String wp2BhColorPlace4 = coOptionPants2WashableInfo.getWp2BhColorPlace4();
						
						String wp2BhColor1 = coOptionPants2WashableInfo.getWp2BhColor1();
						String wp2BhColor2 = coOptionPants2WashableInfo.getWp2BhColor2();
						String wp2BhColor3 = coOptionPants2WashableInfo.getWp2BhColor3();
						String wp2BhColor4 = coOptionPants2WashableInfo.getWp2BhColor4();

						if (isEmpty(wp2BhColorPlace1) && isEmpty(wp2BhColorPlace2) && isEmpty(wp2BhColorPlace3)
								&& isEmpty(wp2BhColorPlace4)) {
							messages.add("E033", "PANTS（2本目）   ボタンホール色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(wp2BhColorPlace1)&&isEmpty(wp2BhColor1)||isNotEmpty(wp2BhColorPlace2)&&isEmpty(wp2BhColor2)||
						   isNotEmpty(wp2BhColorPlace3)&&isEmpty(wp2BhColor3)||isNotEmpty(wp2BhColorPlace4)&&isEmpty(wp2BhColor4)) {
							messages.add("E033", "PANTS（2本目）   ボタンホール色指定");
							jacketFlag = true;
						}
					}

					// ボタン付け糸指定
					String wp2ByColor = coOptionPants2WashableInfo.getWp2ByColor();
					if (OptionCodeKeys.PT2_0003002.equals(wp2ByColor)) {
						String wp2ByColorPlace1 = coOptionPants2WashableInfo.getWp2ByColorPlace1();
						String wp2ByColorPlace2 = coOptionPants2WashableInfo.getWp2ByColorPlace2();
						String wp2ByColorPlace3 = coOptionPants2WashableInfo.getWp2ByColorPlace3();
						String wp2ByColorPlace4 = coOptionPants2WashableInfo.getWp2ByColorPlace4();
						
						String wp2ByColor1 = coOptionPants2WashableInfo.getWp2ByColor1();
						String wp2ByColor2 = coOptionPants2WashableInfo.getWp2ByColor2();
						String wp2ByColor3 = coOptionPants2WashableInfo.getWp2ByColor3();
						String wp2ByColor4 = coOptionPants2WashableInfo.getWp2ByColor4();
						if (isEmpty(wp2ByColorPlace1) && isEmpty(wp2ByColorPlace2) && isEmpty(wp2ByColorPlace3)
								&& isEmpty(wp2ByColorPlace4)) {
							messages.add("E033", "PANTS（2本目）   ボタン付け糸指定");
							jacketFlag = true;
						}
						if(isNotEmpty(wp2ByColorPlace1)&&isEmpty(wp2ByColor1)||isNotEmpty(wp2ByColorPlace2)&&isEmpty(wp2ByColor2)||
						   isNotEmpty(wp2ByColorPlace3)&&isEmpty(wp2ByColor3)||isNotEmpty(wp2ByColorPlace4)&&isEmpty(wp2ByColor4)) {
							messages.add("E033", "PANTS（2本目）   ボタン付け糸指定");
							jacketFlag = true;
						}
					}
				}

				// 補正
				CoAdjustPants2StandardInfo coAdjustPants2StandardInfo = orderCoForm.getCoAdjustPants2StandardInfo();
				if (coAdjustPantsStandardInfo == null) {
					messages.add("E031", "PANTS（2本目）サイズ");
					jacketFlag = true;
				} else {
					String sizeFigure = coAdjustPants2StandardInfo.getSizeFigure();
					if ("".equals(sizeFigure) || null == sizeFigure) {
						messages.add("E031", "PANTS（2本目）サイズ体型");
						jacketFlag = true;
					}
					String sizeNumber = coAdjustPants2StandardInfo.getSizeNumber();
					if ("".equals(sizeNumber) || null == sizeNumber) {
						messages.add("E031", "PANTS（2本目）サイズ号数");
						jacketFlag = true;
					}
	
				}
				String orPt2LeftinseamGross = coAdjustPants2StandardInfo.getCorPt2LeftinseamGross();
				boolean falg=GrossCompareTo(orPt2LeftinseamGross,messages,"PANTS（2本目）左股下");
				if(falg) {
					jacketFlag = true;
				}
				String corPt2RightinseamGross = coAdjustPants2StandardInfo.getCorPt2RightinseamGross();
				falg=GrossCompareTo(corPt2RightinseamGross,messages,"PANTS（2本目）右股下");
				if(falg) {
					jacketFlag = true;
				}
				
			}
			
			if(OptionCodeKeys.THREE_PIECE.equals(threePiece)) {
				// 標準の場合
				if ("9000101".equals(productCategory)) {
					// GILETモデル未選択の場合
					CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
					String ogGiletModel = coOptionGiletStandardInfo.getOgGiletModel();
					if ("".equals(ogGiletModel) || null == ogGiletModel) {
						messages.add("E031", "GILET モデル");
						jacketFlag = true;
					}
					//ステッチ箇所変更
					String ogStitchModify = coOptionGiletStandardInfo.getOgStitchModify();
					if (OptionCodeKeys.GL_0000602.equals(ogStitchModify)) {
						String ogStitchModifyPlace1 = coOptionGiletStandardInfo.getOgStitchModifyPlace1();
						String ogStitchModifyPlace2 = coOptionGiletStandardInfo.getOgStitchModifyPlace2();
						String ogStitchModifyPlace3 = coOptionGiletStandardInfo.getOgStitchModifyPlace3();

						if (isEmpty(ogStitchModifyPlace1) && isEmpty(ogStitchModifyPlace2) && isEmpty(ogStitchModifyPlace3)) {
							messages.add("E033", "GILET ステッチ箇所変更");
							jacketFlag = true;
						}
					}
					// ダブルステッチ
					String ogDStitchModify = coOptionGiletStandardInfo.getOgDStitchModify();
					if (OptionCodeKeys.GL_0002602.equals(ogDStitchModify)) {
						String ogDStitchModifyPlace1 = coOptionGiletStandardInfo.getOgDStitchModifyPlace1();
						String ogDStitchModifyPlace2 = coOptionGiletStandardInfo.getOgDStitchModifyPlace2();
						String ogDStitchModifyPlace3 = coOptionGiletStandardInfo.getOgDStitchModifyPlace3();

						if (isEmpty(ogDStitchModifyPlace1) && isEmpty(ogDStitchModifyPlace2) && isEmpty(ogDStitchModifyPlace3)) {
							messages.add("E033", "GILET ダブルステッチ");
							jacketFlag = true;
						}
					}
					// AMF色指定
					String ogAmfColor = coOptionGiletStandardInfo.getOgAmfColor();
					if (OptionCodeKeys.GL_0000802.equals(ogAmfColor)) {
						String ogAmfColorPlace1 = coOptionGiletStandardInfo.getOgAmfColorPlace1();
						String ogAmfColorPlace2 = coOptionGiletStandardInfo.getOgAmfColorPlace2();
						String ogAmfColorPlace3 = coOptionGiletStandardInfo.getOgAmfColorPlace3();

						String ogAmfColor1 = coOptionGiletStandardInfo.getOgAmfColor1();
						String ogAmfColor2 = coOptionGiletStandardInfo.getOgAmfColor2();
						String ogAmfColor3 = coOptionGiletStandardInfo.getOgAmfColor3();
						if (isEmpty(ogAmfColorPlace1) && isEmpty(ogAmfColorPlace2) && isEmpty(ogAmfColorPlace3)) {
							messages.add("E033", "GILET AMF色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(ogAmfColorPlace1)&&isEmpty(ogAmfColor1)||isNotEmpty(ogAmfColorPlace2)&&isEmpty(ogAmfColor2)||
						   isNotEmpty(ogAmfColorPlace3)&&isEmpty(ogAmfColor3)) {
							messages.add("E033", "GILET AMF色指定");
							jacketFlag = true;
						}
					}
					//ボタンホール色指定
					String ogBhColor = coOptionGiletStandardInfo.getOgBhColor();
					if (OptionCodeKeys.GL_0001102.equals(ogBhColor)) {
						String ogBhColorPlace1 = coOptionGiletStandardInfo.getOgBhColorPlace1();
						String ogBhColorPlace2 = coOptionGiletStandardInfo.getOgBhColorPlace2();
						String ogBhColorPlace3 = coOptionGiletStandardInfo.getOgBhColorPlace3();
						String ogBhColorPlace4 = coOptionGiletStandardInfo.getOgBhColorPlace4();
						String ogBhColorPlace5 = coOptionGiletStandardInfo.getOgBhColorPlace5();
						String ogBhColorPlace6 = coOptionGiletStandardInfo.getOgBhColorPlace6();

						String ogBhColor1 = coOptionGiletStandardInfo.getOgBhColor1();
						String ogBhColor2 = coOptionGiletStandardInfo.getOgBhColor2();
						String ogBhColor3 = coOptionGiletStandardInfo.getOgBhColor3();
						String ogBhColor4 = coOptionGiletStandardInfo.getOgBhColor4();
						String ogBhColor5 = coOptionGiletStandardInfo.getOgBhColor5();
						String ogBhColor6 = coOptionGiletStandardInfo.getOgBhColor6();
						
						if (isEmpty(ogBhColorPlace1) && isEmpty(ogBhColorPlace2) && isEmpty(ogBhColorPlace3)
								&& isEmpty(ogBhColorPlace4) && isEmpty(ogBhColorPlace5) && isEmpty(ogBhColorPlace6)) {
							messages.add("E033", "GILET ボタンホール色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(ogBhColorPlace1)&&isEmpty(ogBhColor1)||isNotEmpty(ogBhColorPlace2)&&isEmpty(ogBhColor2)||
						   isNotEmpty(ogBhColorPlace3)&&isEmpty(ogBhColor3)||isNotEmpty(ogBhColorPlace4)&&isEmpty(ogBhColor4)||
						   isNotEmpty(ogBhColorPlace5)&&isEmpty(ogBhColor5)||isNotEmpty(ogBhColorPlace6)&&isEmpty(ogBhColor6)) {
							messages.add("E033", "GILET ボタンホール色指定");
							jacketFlag = true;
						}
					}
					// ボタン付け糸指定
					String ogByColor = coOptionGiletStandardInfo.getOgByColor();
					if (OptionCodeKeys.GL_0001402.equals(ogByColor)) {
						String ogByColorPlace1 = coOptionGiletStandardInfo.getOgByColorPlace1();
						String ogByColorPlace2 = coOptionGiletStandardInfo.getOgByColorPlace2();
						String ogByColorPlace3 = coOptionGiletStandardInfo.getOgByColorPlace3();
						String ogByColorPlace4 = coOptionGiletStandardInfo.getOgByColorPlace4();
						String ogByColorPlace5 = coOptionGiletStandardInfo.getOgByColorPlace5();
						String ogByColorPlace6 = coOptionGiletStandardInfo.getOgByColorPlace6();
						String ogByColorPlace7 = coOptionGiletStandardInfo.getOgByColorPlace7();
						String ogByColorPlace8 = coOptionGiletStandardInfo.getOgByColorPlace8();
						String ogByColorPlace9 = coOptionGiletStandardInfo.getOgByColorPlace9();
						String ogByColorPlace10 = coOptionGiletStandardInfo.getOgByColorPlace10();

						String ogByColor1 = coOptionGiletStandardInfo.getOgByColor1();
						String ogByColor2 = coOptionGiletStandardInfo.getOgByColor2();
						String ogByColor3 = coOptionGiletStandardInfo.getOgByColor3();
						String ogByColor4 = coOptionGiletStandardInfo.getOgByColor4();
						String ogByColor5 = coOptionGiletStandardInfo.getOgByColor5();
						String ogByColor6 = coOptionGiletStandardInfo.getOgByColor6();
						String ogByColor7 = coOptionGiletStandardInfo.getOgByColor7();
						String ogByColor8 = coOptionGiletStandardInfo.getOgByColor8();
						String ogByColor9 = coOptionGiletStandardInfo.getOgByColor9();
						String ogByColor10 = coOptionGiletStandardInfo.getOgByColor10();
						if (isEmpty(ogByColorPlace1) && isEmpty(ogByColorPlace2) && isEmpty(ogByColorPlace3)
								&& isEmpty(ogByColorPlace4) && isEmpty(ogByColorPlace5) && isEmpty(ogByColorPlace6)
								&& isEmpty(ogByColorPlace7) && isEmpty(ogByColorPlace8) && isEmpty(ogByColorPlace9)
								&& isEmpty(ogByColorPlace10)) {
							messages.add("E033", "GILET ボタン付け糸指定");
							jacketFlag = true;
						}
						if(isNotEmpty(ogByColorPlace1)&&isEmpty(ogByColor1)||isNotEmpty(ogByColorPlace2)&&isEmpty(ogByColor2)||
						   isNotEmpty(ogByColorPlace3)&&isEmpty(ogByColor3)||isNotEmpty(ogByColorPlace4)&&isEmpty(ogByColor4)||
						   isNotEmpty(ogByColorPlace5)&&isEmpty(ogByColor5)||isNotEmpty(ogByColorPlace6)&&isEmpty(ogByColor6)||
						   isNotEmpty(ogByColorPlace7)&&isEmpty(ogByColor7)||isNotEmpty(ogByColorPlace8)&&isEmpty(ogByColor8)||
						   isNotEmpty(ogByColorPlace9)&&isEmpty(ogByColor9)||isNotEmpty(ogByColorPlace10)&&isEmpty(ogByColor10)) {
							messages.add("E033", "GILET ボタン付け糸指定");
							jacketFlag = true;
						}
					}
					//GILET  タキシードの場合
				} else if ("9000102".equals(productCategory)) {
					// GILET モデル未選択の場合
					CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
					String tgGiletModel = coOptionGiletTuxedoInfo.getTgGiletModel();
					if ("".equals(tgGiletModel) || null == tgGiletModel) {
						messages.add("E031", "GILET モデル");
						jacketFlag = true;
					}
					// ボタンホール色指定
					String tgBhColor = coOptionGiletTuxedoInfo.getTgBhColor();
					if (OptionCodeKeys.GL_0001102.equals(tgBhColor)) {
						String tgBhColorPlace1 = coOptionGiletTuxedoInfo.getTgBhColorPlace1();
						String tgBhColorPlace2 = coOptionGiletTuxedoInfo.getTgBhColorPlace2();
						String tgBhColorPlace3 = coOptionGiletTuxedoInfo.getTgBhColorPlace3();
						String tgBhColorPlace4 = coOptionGiletTuxedoInfo.getTgBhColorPlace4();
						String tgBhColorPlace5 = coOptionGiletTuxedoInfo.getTgBhColorPlace5();
						String tgBhColorPlace6 = coOptionGiletTuxedoInfo.getTgBhColorPlace6();

						String tgBhColor1 = coOptionGiletTuxedoInfo.getTgBhColor1();
						String tgBhColor2 = coOptionGiletTuxedoInfo.getTgBhColor2();
						String tgBhColor3 = coOptionGiletTuxedoInfo.getTgBhColor3();
						String tgBhColor4 = coOptionGiletTuxedoInfo.getTgBhColor4();
						String tgBhColor5 = coOptionGiletTuxedoInfo.getTgBhColor5();
						String tgBhColor6 = coOptionGiletTuxedoInfo.getTgBhColor6();
						
						if (isEmpty(tgBhColorPlace1) && isEmpty(tgBhColorPlace2) && isEmpty(tgBhColorPlace3)
								&& isEmpty(tgBhColorPlace4) && isEmpty(tgBhColorPlace5) && isEmpty(tgBhColorPlace6)) {
							messages.add("E033", "GILET ボタンホール色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(tgBhColorPlace1)&&isEmpty(tgBhColor1)||isNotEmpty(tgBhColorPlace2)&&isEmpty(tgBhColor2)||
						   isNotEmpty(tgBhColorPlace3)&&isEmpty(tgBhColor3)||isNotEmpty(tgBhColorPlace4)&&isEmpty(tgBhColor4)||
						   isNotEmpty(tgBhColorPlace5)&&isEmpty(tgBhColor5)||isNotEmpty(tgBhColorPlace6)&&isEmpty(tgBhColor6)) {
							messages.add("E033", "GILET ボタンホール色指定");
							jacketFlag = true;
						}
					}
					// ボタン付け糸指定
					String tgByColor = coOptionGiletTuxedoInfo.getTgByColor();
					if (OptionCodeKeys.GL_0001402.equals(tgByColor)) {
						String tgByColorPlace1 = coOptionGiletTuxedoInfo.getTgByColorPlace1();
						String tgByColorPlace2 = coOptionGiletTuxedoInfo.getTgByColorPlace2();
						String tgByColorPlace3 = coOptionGiletTuxedoInfo.getTgByColorPlace3();
						String tgByColorPlace4 = coOptionGiletTuxedoInfo.getTgByColorPlace4();
						String tgByColorPlace5 = coOptionGiletTuxedoInfo.getTgByColorPlace5();
						String tgByColorPlace6 = coOptionGiletTuxedoInfo.getTgByColorPlace6();
						String tgByColorPlace7 = coOptionGiletTuxedoInfo.getTgByColorPlace7();
						String tgByColorPlace8 = coOptionGiletTuxedoInfo.getTgByColorPlace8();
						String tgByColorPlace9 = coOptionGiletTuxedoInfo.getTgByColorPlace9();
						String tgByColorPlace10 = coOptionGiletTuxedoInfo.getTgByColorPlace10();

						String tgByColor1 = coOptionGiletTuxedoInfo.getTgByColor1();
						String tgByColor2 = coOptionGiletTuxedoInfo.getTgByColor2();
						String tgByColor3 = coOptionGiletTuxedoInfo.getTgByColor3();
						String tgByColor4 = coOptionGiletTuxedoInfo.getTgByColor4();
						String tgByColor5 = coOptionGiletTuxedoInfo.getTgByColor5();
						String tgByColor6 = coOptionGiletTuxedoInfo.getTgByColor6();
						String tgByColor7 = coOptionGiletTuxedoInfo.getTgByColor7();
						String tgByColor8 = coOptionGiletTuxedoInfo.getTgByColor8();
						String tgByColor9 = coOptionGiletTuxedoInfo.getTgByColor9();
						String tgByColor10 = coOptionGiletTuxedoInfo.getTgByColor10();
						if (isEmpty(tgByColorPlace1) && isEmpty(tgByColorPlace2) && isEmpty(tgByColorPlace3)
								&& isEmpty(tgByColorPlace4) && isEmpty(tgByColorPlace5) && isEmpty(tgByColorPlace6)
								&& isEmpty(tgByColorPlace7) && isEmpty(tgByColorPlace8) && isEmpty(tgByColorPlace9)
								&& isEmpty(tgByColorPlace10)) {
							messages.add("E033", "GILET ボタン付け糸指定");
							jacketFlag = true;
						}
						if(isNotEmpty(tgByColorPlace1)&&isEmpty(tgByColor1)||isNotEmpty(tgByColorPlace2)&&isEmpty(tgByColor2)||
						   isNotEmpty(tgByColorPlace3)&&isEmpty(tgByColor3)||isNotEmpty(tgByColorPlace4)&&isEmpty(tgByColor4)||
						   isNotEmpty(tgByColorPlace5)&&isEmpty(tgByColor5)||isNotEmpty(tgByColorPlace6)&&isEmpty(tgByColor6)||
						   isNotEmpty(tgByColorPlace7)&&isEmpty(tgByColor7)||isNotEmpty(tgByColorPlace8)&&isEmpty(tgByColor8)||
						   isNotEmpty(tgByColorPlace9)&&isEmpty(tgByColor9)||isNotEmpty(tgByColorPlace10)&&isEmpty(tgByColor10)) {
							messages.add("E033", "GILET ボタン付け糸指定");
							jacketFlag = true;
						}
					}
				} else if ("9000103".equals(productCategory)) {
					// GILET モデル未選択の場合
					CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
					String wgGiletModel = coOptionGiletWashableInfo.getWgGiletModel();
					if ("".equals(wgGiletModel) || null == wgGiletModel) {
						messages.add("E031", "GILET モデル");
						jacketFlag = true;
					}
					//ステッチ箇所変更
					String wgStitchModify = coOptionGiletWashableInfo.getWgStitchModify();
					if (OptionCodeKeys.GL_0000602.equals(wgStitchModify)) {
						String wgStitchModifyPlace1 = coOptionGiletWashableInfo.getWgStitchModifyPlace1();
						String wgStitchModifyPlace2 = coOptionGiletWashableInfo.getWgStitchModifyPlace2();
						String wgStitchModifyPlace3 = coOptionGiletWashableInfo.getWgStitchModifyPlace3();

						if (isEmpty(wgStitchModifyPlace1) && isEmpty(wgStitchModifyPlace2) && isEmpty(wgStitchModifyPlace3)) {
							messages.add("E033", "GILET ステッチ箇所変更");
							jacketFlag = true;
						}
					}
					// ダブルステッチ
					String wgDStitchModify = coOptionGiletWashableInfo.getWgDStitchModify();
					if (OptionCodeKeys.GL_0002602.equals(wgDStitchModify)) {
						String wgDStitchModifyPlace1 = coOptionGiletWashableInfo.getWgDStitchModifyPlace1();
						String wgDStitchModifyPlace2 = coOptionGiletWashableInfo.getWgDStitchModifyPlace2();
						String wgDStitchModifyPlace3 = coOptionGiletWashableInfo.getWgDStitchModifyPlace3();

						if (isEmpty(wgDStitchModifyPlace1) && isEmpty(wgDStitchModifyPlace2) && isEmpty(wgDStitchModifyPlace3)) {
							messages.add("E033", "GILET ダブルステッチ");
							jacketFlag = true;
						}
					}
					// AMF色指定
					String wgAmfColor = coOptionGiletWashableInfo.getWgAmfColor();
					if (OptionCodeKeys.GL_0000802.equals(wgAmfColor)) {
						String wgAmfColorPlace1 = coOptionGiletWashableInfo.getWgAmfColorPlace1();
						String wgAmfColorPlace2 = coOptionGiletWashableInfo.getWgAmfColorPlace2();
						String wgAmfColorPlace3 = coOptionGiletWashableInfo.getWgAmfColorPlace3();

						String wgAmfColor1 = coOptionGiletWashableInfo.getWgAmfColor1();
						String wgAmfColor2 = coOptionGiletWashableInfo.getWgAmfColor2();
						String wgAmfColor3 = coOptionGiletWashableInfo.getWgAmfColor3();
						if (isEmpty(wgAmfColorPlace1) && isEmpty(wgAmfColorPlace2) && isEmpty(wgAmfColorPlace3)) {
							messages.add("E033", "GILET AMF色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(wgAmfColorPlace1)&&isEmpty(wgAmfColor1)||isNotEmpty(wgAmfColorPlace2)&&isEmpty(wgAmfColor2)||
						   isNotEmpty(wgAmfColorPlace3)&&isEmpty(wgAmfColor3)) {
							messages.add("E033", "GILET AMF色指定");
							jacketFlag = true;
						}
					}
					//ボタンホール色指定
					String wgBhColor = coOptionGiletWashableInfo.getWgBhColor();
					if (OptionCodeKeys.GL_0001102.equals(wgBhColor)) {
						String wgBhColorPlace1 = coOptionGiletWashableInfo.getWgBhColorPlace1();
						String wgBhColorPlace2 = coOptionGiletWashableInfo.getWgBhColorPlace2();
						String wgBhColorPlace3 = coOptionGiletWashableInfo.getWgBhColorPlace3();
						String wgBhColorPlace4 = coOptionGiletWashableInfo.getWgBhColorPlace4();
						String wgBhColorPlace5 = coOptionGiletWashableInfo.getWgBhColorPlace5();
						String wgBhColorPlace6 = coOptionGiletWashableInfo.getWgBhColorPlace6();

						String wgBhColor1 = coOptionGiletWashableInfo.getWgBhColor1();
						String wgBhColor2 = coOptionGiletWashableInfo.getWgBhColor2();
						String wgBhColor3 = coOptionGiletWashableInfo.getWgBhColor3();
						String wgBhColor4 = coOptionGiletWashableInfo.getWgBhColor4();
						String wgBhColor5 = coOptionGiletWashableInfo.getWgBhColor5();
						String wgBhColor6 = coOptionGiletWashableInfo.getWgBhColor6();
						
						if (isEmpty(wgBhColorPlace1) && isEmpty(wgBhColorPlace2) && isEmpty(wgBhColorPlace3)
								&& isEmpty(wgBhColorPlace4) && isEmpty(wgBhColorPlace5) && isEmpty(wgBhColorPlace6)) {
							messages.add("E033", "GILET ボタンホール色指定");
							jacketFlag = true;
						}
						if(isNotEmpty(wgBhColorPlace1)&&isEmpty(wgBhColor1)||isNotEmpty(wgBhColorPlace2)&&isEmpty(wgBhColor2)||
						   isNotEmpty(wgBhColorPlace3)&&isEmpty(wgBhColor3)||isNotEmpty(wgBhColorPlace4)&&isEmpty(wgBhColor4)||
						   isNotEmpty(wgBhColorPlace5)&&isEmpty(wgBhColor5)||isNotEmpty(wgBhColorPlace6)&&isEmpty(wgBhColor6)) {
							messages.add("E033", "GILET ボタンホール色指定");
							jacketFlag = true;
						}
					}
					// ボタン付け糸指定
					String wgByColor = coOptionGiletWashableInfo.getWgByColor();
					if (OptionCodeKeys.GL_0001402.equals(wgByColor)) {
						String wgByColorPlace1 = coOptionGiletWashableInfo.getWgByColorPlace1();
						String wgByColorPlace2 = coOptionGiletWashableInfo.getWgByColorPlace2();
						String wgByColorPlace3 = coOptionGiletWashableInfo.getWgByColorPlace3();
						String wgByColorPlace4 = coOptionGiletWashableInfo.getWgByColorPlace4();
						String wgByColorPlace5 = coOptionGiletWashableInfo.getWgByColorPlace5();
						String wgByColorPlace6 = coOptionGiletWashableInfo.getWgByColorPlace6();
						String wgByColorPlace7 = coOptionGiletWashableInfo.getWgByColorPlace7();
						String wgByColorPlace8 = coOptionGiletWashableInfo.getWgByColorPlace8();
						String wgByColorPlace9 = coOptionGiletWashableInfo.getWgByColorPlace9();
						String wgByColorPlace10 = coOptionGiletWashableInfo.getWgByColorPlace10();

						String wgByColor1 = coOptionGiletWashableInfo.getWgByColor1();
						String wgByColor2 = coOptionGiletWashableInfo.getWgByColor2();
						String wgByColor3 = coOptionGiletWashableInfo.getWgByColor3();
						String wgByColor4 = coOptionGiletWashableInfo.getWgByColor4();
						String wgByColor5 = coOptionGiletWashableInfo.getWgByColor5();
						String wgByColor6 = coOptionGiletWashableInfo.getWgByColor6();
						String wgByColor7 = coOptionGiletWashableInfo.getWgByColor7();
						String wgByColor8 = coOptionGiletWashableInfo.getWgByColor8();
						String wgByColor9 = coOptionGiletWashableInfo.getWgByColor9();
						String wgByColor10 = coOptionGiletWashableInfo.getWgByColor10();
						if (isEmpty(wgByColorPlace1) && isEmpty(wgByColorPlace2) && isEmpty(wgByColorPlace3)
								&& isEmpty(wgByColorPlace4) && isEmpty(wgByColorPlace5) && isEmpty(wgByColorPlace6)
								&& isEmpty(wgByColorPlace7) && isEmpty(wgByColorPlace8) && isEmpty(wgByColorPlace9)
								&& isEmpty(wgByColorPlace10)) {
							messages.add("E033", "GILET ボタン付け糸指定");
							jacketFlag = true;
						}
						if(isNotEmpty(wgByColorPlace1)&&isEmpty(wgByColor1)||isNotEmpty(wgByColorPlace2)&&isEmpty(wgByColor2)||
						   isNotEmpty(wgByColorPlace3)&&isEmpty(wgByColor3)||isNotEmpty(wgByColorPlace4)&&isEmpty(wgByColor4)||
						   isNotEmpty(wgByColorPlace5)&&isEmpty(wgByColor5)||isNotEmpty(wgByColorPlace6)&&isEmpty(wgByColor6)||
						   isNotEmpty(wgByColorPlace7)&&isEmpty(wgByColor7)||isNotEmpty(wgByColorPlace8)&&isEmpty(wgByColor8)||
						   isNotEmpty(wgByColorPlace9)&&isEmpty(wgByColor9)||isNotEmpty(wgByColorPlace10)&&isEmpty(wgByColor10)) {
							messages.add("E033", "GILET ボタン付け糸指定");
							jacketFlag = true;
						}
					}
				}

				// 補正
				CoAdjustGiletStandardInfo coAdjustGiletStandardInfo = orderCoForm.getCoAdjustGiletStandardInfo();
				if (coAdjustPantsStandardInfo == null) {
					messages.add("E031", "GILET サイズ");
					jacketFlag = true;
				} else {
					String sizeFigure = coAdjustGiletStandardInfo.getSizeFigure();
					if ("".equals(sizeFigure) || null == sizeFigure) {
						messages.add("E031", "GILET サイズ体型");
						jacketFlag = true;
					}
					String sizeNumber = coAdjustGiletStandardInfo.getSizeNumber();
					if ("".equals(sizeNumber) || null == sizeNumber) {
						messages.add("E031", "GILET サイズ号数");
						jacketFlag = true;
					}
				}
				
			}
			
			if (jacketFlag) {
//				if ("0".equals(itemFlag)) {
//					orderCoHelper.jacketDefaultValue(orderCoForm);
//				}
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm",orderCoForm);
				model.addAttribute("resultMessages",messages);
		        return "order/orderCoForm";
			}
		}
		
		//JACKETチェック
		if("02".equals(item)) {
			boolean jacketFlag = false;
			//String itemFlag = orderCoForm.getJacketItemFlag();
			ResultMessages messages = ResultMessages.error();
			//標準の場合
			if("9000101".equals(productCategory)) {
				//JACKET モデル未選択の場合
				CoOptionJacketStandardInfo coOptionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
				String ojJacketModel = coOptionJacketStandardInfo.getOjJacketModel();
				if("".equals(ojJacketModel)  ||  null == ojJacketModel) {
					 messages.add("E031", "JACKET モデル");
					 jacketFlag = true;
				}
				//AMF色指定
				String ojAmfColor = coOptionJacketStandardInfo.getOjAmfColor();
				if(OptionCodeKeys.JK_0002802.equals(ojAmfColor)) {
					String ojAmfColorPlace1 = coOptionJacketStandardInfo.getOjAmfColorPlace1();
					String ojAmfColorPlace2 = coOptionJacketStandardInfo.getOjAmfColorPlace2();
					String ojAmfColorPlace3 = coOptionJacketStandardInfo.getOjAmfColorPlace3();
					String ojAmfColorPlace4 = coOptionJacketStandardInfo.getOjAmfColorPlace4();
					String ojAmfColorPlace5 = coOptionJacketStandardInfo.getOjAmfColorPlace5();
					String ojAmfColorPlace6 = coOptionJacketStandardInfo.getOjAmfColorPlace6();
					String ojAmfColorPlace7 = coOptionJacketStandardInfo.getOjAmfColorPlace7();
					String ojAmfColorPlace8 = coOptionJacketStandardInfo.getOjAmfColorPlace8();
					String ojAmfColorPlace9 = coOptionJacketStandardInfo.getOjAmfColorPlace9();
					
					String ojAmfColor1 = coOptionJacketStandardInfo.getOjAmfColor1();
					String ojAmfColor2 = coOptionJacketStandardInfo.getOjAmfColor2();
					String ojAmfColor3 = coOptionJacketStandardInfo.getOjAmfColor3();
					String ojAmfColor4 = coOptionJacketStandardInfo.getOjAmfColor4();
					String ojAmfColor5 = coOptionJacketStandardInfo.getOjAmfColor5();
					String ojAmfColor6 = coOptionJacketStandardInfo.getOjAmfColor6();
					String ojAmfColor7 = coOptionJacketStandardInfo.getOjAmfColor7();
					String ojAmfColor8 = coOptionJacketStandardInfo.getOjAmfColor8();
					String ojAmfColor9 = coOptionJacketStandardInfo.getOjAmfColor9();
					
					if(isEmpty(ojAmfColorPlace1)&&isEmpty(ojAmfColorPlace2)&&isEmpty(ojAmfColorPlace3)&&isEmpty(ojAmfColorPlace4)&&
					   isEmpty(ojAmfColorPlace5)&&isEmpty(ojAmfColorPlace6)&&isEmpty(ojAmfColorPlace7)&&isEmpty(ojAmfColorPlace8)&&isEmpty(ojAmfColorPlace9)) {
						messages.add("E032", "AMF色指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(ojAmfColorPlace1)&&isEmpty(ojAmfColor1)||isNotEmpty(ojAmfColorPlace2)&&isEmpty(ojAmfColor2)||
					   isNotEmpty(ojAmfColorPlace3)&&isEmpty(ojAmfColor3)||isNotEmpty(ojAmfColorPlace4)&&isEmpty(ojAmfColor4)||
					   isNotEmpty(ojAmfColorPlace5)&&isEmpty(ojAmfColor5)||isNotEmpty(ojAmfColorPlace6)&&isEmpty(ojAmfColor6)||
					   isNotEmpty(ojAmfColorPlace7)&&isEmpty(ojAmfColor7)||isNotEmpty(ojAmfColorPlace8)&&isEmpty(ojAmfColor8)||
					   isNotEmpty(ojAmfColorPlace9)&&isEmpty(ojAmfColor9)) {
						messages.add("E032", "AMF色指定");
						jacketFlag = true;
					}
					
					
				}
				//ボタンホール色指定
				String ojBhColor = coOptionJacketStandardInfo.getOjBhColor();
				if (OptionCodeKeys.JK_0003102.equals(ojBhColor)) {
					String ojBhColorPlace1 = coOptionJacketStandardInfo.getOjBhColorPlace1();
					String ojBhColorPlace2 = coOptionJacketStandardInfo.getOjBhColorPlace2();
					String ojBhColorPlace3 = coOptionJacketStandardInfo.getOjBhColorPlace3();
					String ojBhColorPlace4 = coOptionJacketStandardInfo.getOjBhColorPlace4();
					String ojBhColorPlace5 = coOptionJacketStandardInfo.getOjBhColorPlace5();
					String ojBhColorPlace6 = coOptionJacketStandardInfo.getOjBhColorPlace6();
					String ojBhColorPlace7 = coOptionJacketStandardInfo.getOjBhColorPlace7();
					String ojBhColorPlace8 = coOptionJacketStandardInfo.getOjBhColorPlace8();
					String ojBhColorPlace9 = coOptionJacketStandardInfo.getOjBhColorPlace9();
					String ojBhColorPlace10 = coOptionJacketStandardInfo.getOjBhColorPlace10();
					String ojBhColorPlace11 = coOptionJacketStandardInfo.getOjBhColorPlace11();
					String ojBhColorPlace12 = coOptionJacketStandardInfo.getOjBhColorPlace12();
					String ojBhColorPlace13 = coOptionJacketStandardInfo.getOjBhColorPlace13();
					String ojBhColorPlace14 = coOptionJacketStandardInfo.getOjBhColorPlace14();
					String ojBhColorPlace15 = coOptionJacketStandardInfo.getOjBhColorPlace15();
					String ojBhColorPlace16 = coOptionJacketStandardInfo.getOjBhColorPlace16();
					String ojBhColorPlace17 = coOptionJacketStandardInfo.getOjBhColorPlace17();
					
					String ojBhColor1 = coOptionJacketStandardInfo.getOjBhColor1();
					String ojBhColor2 = coOptionJacketStandardInfo.getOjBhColor2();
					String ojBhColor3 = coOptionJacketStandardInfo.getOjBhColor3();
					String ojBhColor4 = coOptionJacketStandardInfo.getOjBhColor4();
					String ojBhColor5 = coOptionJacketStandardInfo.getOjBhColor5();
					String ojBhColor6 = coOptionJacketStandardInfo.getOjBhColor6();
					String ojBhColor7 = coOptionJacketStandardInfo.getOjBhColor7();
					String ojBhColor8 = coOptionJacketStandardInfo.getOjBhColor8();
					String ojBhColor9 = coOptionJacketStandardInfo.getOjBhColor9();
					String ojBhColor10 = coOptionJacketStandardInfo.getOjBhColor10();
					String ojBhColor11 = coOptionJacketStandardInfo.getOjBhColor11();
					String ojBhColor12 = coOptionJacketStandardInfo.getOjBhColor12();
					String ojBhColor13 = coOptionJacketStandardInfo.getOjBhColor13();
					String ojBhColor14 = coOptionJacketStandardInfo.getOjBhColor14();
					String ojBhColor15 = coOptionJacketStandardInfo.getOjBhColor15();
					String ojBhColor16 = coOptionJacketStandardInfo.getOjBhColor16();
					String ojBhColor17 = coOptionJacketStandardInfo.getOjBhColor17();
					
					if (isEmpty(ojBhColorPlace1) && isEmpty(ojBhColorPlace2) && isEmpty(ojBhColorPlace3)
							&& isEmpty(ojBhColorPlace4) && isEmpty(ojBhColorPlace5) && isEmpty(ojBhColorPlace6)
							&& isEmpty(ojBhColorPlace7) && isEmpty(ojBhColorPlace8) && isEmpty(ojBhColorPlace9)
							&& isEmpty(ojBhColorPlace10)&& isEmpty(ojBhColorPlace11)&& isEmpty(ojBhColorPlace12)
							&& isEmpty(ojBhColorPlace13)&& isEmpty(ojBhColorPlace14)&& isEmpty(ojBhColorPlace15)
							&& isEmpty(ojBhColorPlace16)&& isEmpty(ojBhColorPlace17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(ojBhColorPlace1)&&isEmpty(ojBhColor1)||isNotEmpty(ojBhColorPlace2)&&isEmpty(ojBhColor2)||
					   isNotEmpty(ojBhColorPlace3)&&isEmpty(ojBhColor3)||isNotEmpty(ojBhColorPlace4)&&isEmpty(ojBhColor4)||
					   isNotEmpty(ojBhColorPlace5)&&isEmpty(ojBhColor5)||isNotEmpty(ojBhColorPlace6)&&isEmpty(ojBhColor6)||
					   isNotEmpty(ojBhColorPlace7)&&isEmpty(ojBhColor7)||isNotEmpty(ojBhColorPlace8)&&isEmpty(ojBhColor8)||
					   isNotEmpty(ojBhColorPlace9)&&isEmpty(ojBhColor9)||isNotEmpty(ojBhColorPlace10)&&isEmpty(ojBhColor10)||
					   isNotEmpty(ojBhColorPlace11)&&isEmpty(ojBhColor11)||isNotEmpty(ojBhColorPlace12)&&isEmpty(ojBhColor12)||
					   isNotEmpty(ojBhColorPlace13)&&isEmpty(ojBhColor13)||isNotEmpty(ojBhColorPlace14)&&isEmpty(ojBhColor14)||
					   isNotEmpty(ojBhColorPlace15)&&isEmpty(ojBhColor15)||isNotEmpty(ojBhColorPlace16)&&isEmpty(ojBhColor16)||
					   isNotEmpty(ojBhColorPlace17)&&isEmpty(ojBhColor17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
				}
				
				//ボタン付け糸指定
				String ojByColor = coOptionJacketStandardInfo.getOjByColor();
				if (OptionCodeKeys.JK_0003402.equals(ojByColor)) {
					String ojByColorPlace1 = coOptionJacketStandardInfo.getOjByColorPlace1();
					String ojByColorPlace2 = coOptionJacketStandardInfo.getOjByColorPlace2();
					String ojByColorPlace3 = coOptionJacketStandardInfo.getOjByColorPlace3();
					String ojByColorPlace4 = coOptionJacketStandardInfo.getOjByColorPlace4();
					String ojByColorPlace5 = coOptionJacketStandardInfo.getOjByColorPlace5();
					String ojByColorPlace6 = coOptionJacketStandardInfo.getOjByColorPlace6();
					String ojByColorPlace7 = coOptionJacketStandardInfo.getOjByColorPlace7();
					String ojByColorPlace8 = coOptionJacketStandardInfo.getOjByColorPlace8();
					String ojByColorPlace9 = coOptionJacketStandardInfo.getOjByColorPlace9();
					String ojByColorPlace10 = coOptionJacketStandardInfo.getOjByColorPlace10();
					String ojByColorPlace11 = coOptionJacketStandardInfo.getOjByColorPlace11();
					String ojByColorPlace12 = coOptionJacketStandardInfo.getOjByColorPlace12();
					String ojByColorPlace13 = coOptionJacketStandardInfo.getOjByColorPlace13();
					String ojByColorPlace14 = coOptionJacketStandardInfo.getOjByColorPlace14();
					String ojByColorPlace15 = coOptionJacketStandardInfo.getOjByColorPlace15();
					String ojByColorPlace16 = coOptionJacketStandardInfo.getOjByColorPlace16();
					
					String ojByColor1 = coOptionJacketStandardInfo.getOjByColor1();
					String ojByColor2 = coOptionJacketStandardInfo.getOjByColor2();
					String ojByColor3 = coOptionJacketStandardInfo.getOjByColor3();
					String ojByColor4 = coOptionJacketStandardInfo.getOjByColor4();
					String ojByColor5 = coOptionJacketStandardInfo.getOjByColor5();
					String ojByColor6 = coOptionJacketStandardInfo.getOjByColor6();
					String ojByColor7 = coOptionJacketStandardInfo.getOjByColor7();
					String ojByColor8 = coOptionJacketStandardInfo.getOjByColor8();
					String ojByColor9 = coOptionJacketStandardInfo.getOjByColor9();
					String ojByColor10 = coOptionJacketStandardInfo.getOjByColor10();
					String ojByColor11 = coOptionJacketStandardInfo.getOjByColor11();
					String ojByColor12 = coOptionJacketStandardInfo.getOjByColor12();
					String ojByColor13 = coOptionJacketStandardInfo.getOjByColor13();
					String ojByColor14 = coOptionJacketStandardInfo.getOjByColor14();
					String ojByColor15 = coOptionJacketStandardInfo.getOjByColor15();
					String ojByColor16 = coOptionJacketStandardInfo.getOjByColor16();
					
					if (isEmpty(ojByColorPlace1) && isEmpty(ojByColorPlace2) && isEmpty(ojByColorPlace3)
							&& isEmpty(ojByColorPlace4) && isEmpty(ojByColorPlace5) && isEmpty(ojByColorPlace6)
							&& isEmpty(ojByColorPlace7) && isEmpty(ojByColorPlace8) && isEmpty(ojByColorPlace9)
							&& isEmpty(ojByColorPlace10)&& isEmpty(ojByColorPlace11)&& isEmpty(ojByColorPlace12)
							&& isEmpty(ojByColorPlace13)&& isEmpty(ojByColorPlace14)&& isEmpty(ojByColorPlace15)
							&& isEmpty(ojByColorPlace16)) {
						messages.add("E032", "ボタン付け糸指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(ojByColorPlace1)&&isEmpty(ojByColor1)||isNotEmpty(ojByColorPlace2)&&isEmpty(ojByColor2)||
					   isNotEmpty(ojByColorPlace3)&&isEmpty(ojByColor3)||isNotEmpty(ojByColorPlace4)&&isEmpty(ojByColor4)||
					   isNotEmpty(ojByColorPlace5)&&isEmpty(ojByColor5)||isNotEmpty(ojByColorPlace6)&&isEmpty(ojByColor6)||
					   isNotEmpty(ojByColorPlace7)&&isEmpty(ojByColor7)||isNotEmpty(ojByColorPlace8)&&isEmpty(ojByColor8)||
					   isNotEmpty(ojByColorPlace9)&&isEmpty(ojByColor9)||isNotEmpty(ojByColorPlace10)&&isEmpty(ojByColor10)||
					   isNotEmpty(ojByColorPlace11)&&isEmpty(ojByColor11)||isNotEmpty(ojByColorPlace12)&&isEmpty(ojByColor12)||
					   isNotEmpty(ojByColorPlace13)&&isEmpty(ojByColor13)||isNotEmpty(ojByColorPlace14)&&isEmpty(ojByColor14)||
					   isNotEmpty(ojByColorPlace15)&&isEmpty(ojByColor15)||isNotEmpty(ojByColorPlace16)&&isEmpty(ojByColor16)) {
						messages.add("E032", "ボタン付け糸指定");
						jacketFlag = true;
					}
					
				}
			//タキシードの場合
			}else if("9000102".equals(productCategory)) {
				//JACKET モデル未選択の場合
				CoOptionJacketTuxedoInfo coOptionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
				String tjJacketModel = coOptionJacketTuxedoInfo.getTjJacketModel();
				if("".equals(tjJacketModel)  ||  null == tjJacketModel) {
					 messages.add("E031", "JACKET モデル");
					 jacketFlag = true;
				}
				
				// ボタンホール色指定
				String ojBhColor = coOptionJacketTuxedoInfo.getTjBhColor();
				if (OptionCodeKeys.JK_0003102.equals(ojBhColor)) {
					String tjBhColorPlace1 = coOptionJacketTuxedoInfo.getTjBhColorPlace1();
					String tjBhColorPlace2 = coOptionJacketTuxedoInfo.getTjBhColorPlace2();
					String tjBhColorPlace3 = coOptionJacketTuxedoInfo.getTjBhColorPlace3();
					String tjBhColorPlace4 = coOptionJacketTuxedoInfo.getTjBhColorPlace4();
					String tjBhColorPlace5 = coOptionJacketTuxedoInfo.getTjBhColorPlace5();
					String tjBhColorPlace6 = coOptionJacketTuxedoInfo.getTjBhColorPlace6();
					String tjBhColorPlace7 = coOptionJacketTuxedoInfo.getTjBhColorPlace7();
					String tjBhColorPlace8 = coOptionJacketTuxedoInfo.getTjBhColorPlace8();
					String tjBhColorPlace9 = coOptionJacketTuxedoInfo.getTjBhColorPlace9();
					String tjBhColorPlace10 = coOptionJacketTuxedoInfo.getTjBhColorPlace10();
					String tjBhColorPlace11 = coOptionJacketTuxedoInfo.getTjBhColorPlace11();
					String tjBhColorPlace12 = coOptionJacketTuxedoInfo.getTjBhColorPlace12();
					String tjBhColorPlace13 = coOptionJacketTuxedoInfo.getTjBhColorPlace13();
					String tjBhColorPlace14 = coOptionJacketTuxedoInfo.getTjBhColorPlace14();
					String tjBhColorPlace15 = coOptionJacketTuxedoInfo.getTjBhColorPlace15();
					String tjBhColorPlace16 = coOptionJacketTuxedoInfo.getTjBhColorPlace16();
					String tjBhColorPlace17 = coOptionJacketTuxedoInfo.getTjBhColorPlace17();
					
					String tjBhColor1 = coOptionJacketTuxedoInfo.getTjBhColor1();
					String tjBhColor2 = coOptionJacketTuxedoInfo.getTjBhColor2();
					String tjBhColor3 = coOptionJacketTuxedoInfo.getTjBhColor3();
					String tjBhColor4 = coOptionJacketTuxedoInfo.getTjBhColor4();
					String tjBhColor5 = coOptionJacketTuxedoInfo.getTjBhColor5();
					String tjBhColor6 = coOptionJacketTuxedoInfo.getTjBhColor6();
					String tjBhColor7 = coOptionJacketTuxedoInfo.getTjBhColor7();
					String tjBhColor8 = coOptionJacketTuxedoInfo.getTjBhColor8();
					String tjBhColor9 = coOptionJacketTuxedoInfo.getTjBhColor9();
					String tjBhColor10 = coOptionJacketTuxedoInfo.getTjBhColor10();
					String tjBhColor11 = coOptionJacketTuxedoInfo.getTjBhColor11();
					String tjBhColor12 = coOptionJacketTuxedoInfo.getTjBhColor12();
					String tjBhColor13 = coOptionJacketTuxedoInfo.getTjBhColor13();
					String tjBhColor14 = coOptionJacketTuxedoInfo.getTjBhColor14();
					String tjBhColor15 = coOptionJacketTuxedoInfo.getTjBhColor15();
					String tjBhColor16 = coOptionJacketTuxedoInfo.getTjBhColor16();
					String tjBhColor17 = coOptionJacketTuxedoInfo.getTjBhColor17();

					if (isEmpty(tjBhColorPlace1) && isEmpty(tjBhColorPlace2) && isEmpty(tjBhColorPlace3)
							&& isEmpty(tjBhColorPlace4) && isEmpty(tjBhColorPlace5) && isEmpty(tjBhColorPlace6)
							&& isEmpty(tjBhColorPlace7) && isEmpty(tjBhColorPlace8) && isEmpty(tjBhColorPlace9)
							&& isEmpty(tjBhColorPlace10) && isEmpty(tjBhColorPlace11) && isEmpty(tjBhColorPlace12)
							&& isEmpty(tjBhColorPlace13) && isEmpty(tjBhColorPlace14) && isEmpty(tjBhColorPlace15)
							&& isEmpty(tjBhColorPlace16) && isEmpty(tjBhColorPlace17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}

					if(isNotEmpty(tjBhColorPlace1)&&isEmpty(tjBhColor1)||isNotEmpty(tjBhColorPlace2)&&isEmpty(tjBhColor2)||
					   isNotEmpty(tjBhColorPlace3)&&isEmpty(tjBhColor3)||isNotEmpty(tjBhColorPlace4)&&isEmpty(tjBhColor4)||
					   isNotEmpty(tjBhColorPlace5)&&isEmpty(tjBhColor5)||isNotEmpty(tjBhColorPlace6)&&isEmpty(tjBhColor6)||
					   isNotEmpty(tjBhColorPlace7)&&isEmpty(tjBhColor7)||isNotEmpty(tjBhColorPlace8)&&isEmpty(tjBhColor8)||
					   isNotEmpty(tjBhColorPlace9)&&isEmpty(tjBhColor9)||isNotEmpty(tjBhColorPlace10)&&isEmpty(tjBhColor10)||
					   isNotEmpty(tjBhColorPlace11)&&isEmpty(tjBhColor11)||isNotEmpty(tjBhColorPlace12)&&isEmpty(tjBhColor12)||
					   isNotEmpty(tjBhColorPlace13)&&isEmpty(tjBhColor13)||isNotEmpty(tjBhColorPlace14)&&isEmpty(tjBhColor14)||
					   isNotEmpty(tjBhColorPlace15)&&isEmpty(tjBhColor15)||isNotEmpty(tjBhColorPlace16)&&isEmpty(tjBhColor16)||
					   isNotEmpty(tjBhColorPlace17)&&isEmpty(tjBhColor17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
					
					// ボタン付け糸指定
					String tjByColor = coOptionJacketTuxedoInfo.getTjByColor();
					if (OptionCodeKeys.JK_0003402.equals(tjByColor)) {
						String tjByColorPlace1 = coOptionJacketTuxedoInfo.getTjByColorPlace1();
						String tjByColorPlace2 = coOptionJacketTuxedoInfo.getTjByColorPlace2();
						String tjByColorPlace3 = coOptionJacketTuxedoInfo.getTjByColorPlace3();
						String tjByColorPlace4 = coOptionJacketTuxedoInfo.getTjByColorPlace4();
						String tjByColorPlace5 = coOptionJacketTuxedoInfo.getTjByColorPlace5();
						String tjByColorPlace6 = coOptionJacketTuxedoInfo.getTjByColorPlace6();
						String tjByColorPlace7 = coOptionJacketTuxedoInfo.getTjByColorPlace7();
						String tjByColorPlace8 = coOptionJacketTuxedoInfo.getTjByColorPlace8();
						String tjByColorPlace9 = coOptionJacketTuxedoInfo.getTjByColorPlace9();
						String tjByColorPlace10 = coOptionJacketTuxedoInfo.getTjByColorPlace10();
						String tjByColorPlace11 = coOptionJacketTuxedoInfo.getTjByColorPlace11();
						String tjByColorPlace12 = coOptionJacketTuxedoInfo.getTjByColorPlace12();
						String tjByColorPlace13 = coOptionJacketTuxedoInfo.getTjByColorPlace13();
						String tjByColorPlace14 = coOptionJacketTuxedoInfo.getTjByColorPlace14();
						String tjByColorPlace15 = coOptionJacketTuxedoInfo.getTjByColorPlace15();
						String tjByColorPlace16 = coOptionJacketTuxedoInfo.getTjByColorPlace16();
						
						String tjByColor1 = coOptionJacketTuxedoInfo.getTjByColor1();
						String tjByColor2 = coOptionJacketTuxedoInfo.getTjByColor2();
						String tjByColor3 = coOptionJacketTuxedoInfo.getTjByColor3();
						String tjByColor4 = coOptionJacketTuxedoInfo.getTjByColor4();
						String tjByColor5 = coOptionJacketTuxedoInfo.getTjByColor5();
						String tjByColor6 = coOptionJacketTuxedoInfo.getTjByColor6();
						String tjByColor7 = coOptionJacketTuxedoInfo.getTjByColor7();
						String tjByColor8 = coOptionJacketTuxedoInfo.getTjByColor8();
						String tjByColor9 = coOptionJacketTuxedoInfo.getTjByColor9();
						String tjByColor10 = coOptionJacketTuxedoInfo.getTjByColor10();
						String tjByColor11 = coOptionJacketTuxedoInfo.getTjByColor11();
						String tjByColor12 = coOptionJacketTuxedoInfo.getTjByColor12();
						String tjByColor13 = coOptionJacketTuxedoInfo.getTjByColor13();
						String tjByColor14 = coOptionJacketTuxedoInfo.getTjByColor14();
						String tjByColor15 = coOptionJacketTuxedoInfo.getTjByColor15();
						String tjByColor16 = coOptionJacketTuxedoInfo.getTjByColor16();
						
						if (isEmpty(tjByColorPlace1) && isEmpty(tjByColorPlace2) && isEmpty(tjByColorPlace3)
								&& isEmpty(tjByColorPlace4) && isEmpty(tjByColorPlace5) && isEmpty(tjByColorPlace6)
								&& isEmpty(tjByColorPlace7) && isEmpty(tjByColorPlace8) && isEmpty(tjByColorPlace9)
								&& isEmpty(tjByColorPlace10) && isEmpty(tjByColorPlace11) && isEmpty(tjByColorPlace12)
								&& isEmpty(tjByColorPlace13) && isEmpty(tjByColorPlace14) && isEmpty(tjByColorPlace15)
								&& isEmpty(tjByColorPlace16)) {
							messages.add("E032", "ボタン付け糸指定");
							jacketFlag = true;
						}
						
						if(isNotEmpty(tjByColorPlace1)&&isEmpty(tjByColor1)||isNotEmpty(tjByColorPlace2)&&isEmpty(tjByColor2)||
						   isNotEmpty(tjByColorPlace3)&&isEmpty(tjByColor3)||isNotEmpty(tjByColorPlace4)&&isEmpty(tjByColor4)||
						   isNotEmpty(tjByColorPlace5)&&isEmpty(tjByColor5)||isNotEmpty(tjByColorPlace6)&&isEmpty(tjByColor6)||
						   isNotEmpty(tjByColorPlace7)&&isEmpty(tjByColor7)||isNotEmpty(tjByColorPlace8)&&isEmpty(tjByColor8)||
						   isNotEmpty(tjByColorPlace9)&&isEmpty(tjByColor9)||isNotEmpty(tjByColorPlace10)&&isEmpty(tjByColor10)||
						   isNotEmpty(tjByColorPlace11)&&isEmpty(tjByColor11)||isNotEmpty(tjByColorPlace12)&&isEmpty(tjByColor12)||
						   isNotEmpty(tjByColorPlace13)&&isEmpty(tjByColor13)||isNotEmpty(tjByColorPlace14)&&isEmpty(tjByColor14)||
						   isNotEmpty(tjByColorPlace15)&&isEmpty(tjByColor15)||isNotEmpty(tjByColorPlace16)&&isEmpty(tjByColor16)) {
							messages.add("E032", "ボタン付け糸指定");
							jacketFlag = true;
						}
					}
				}
			}else if("9000103".equals(productCategory)) {
				//JACKET モデル未選択の場合
				CoOptionJacketWashableInfo coOptionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
				String wjJacketModel = coOptionJacketWashableInfo.getWjJacketModel();
				if("".equals(wjJacketModel)  ||  null == wjJacketModel) {
					 messages.add("E031", "JACKET モデル");
					 jacketFlag = true;
				}
				 
				//AMF色指定
				String wjamfColor = coOptionJacketWashableInfo.getWjAmfColor();
				if(OptionCodeKeys.JK_0002802.equals(wjamfColor)) {
					String wjAmfColorPlace1 = coOptionJacketWashableInfo.getWjAmfColorPlace1();
					String wjAmfColorPlace2 = coOptionJacketWashableInfo.getWjAmfColorPlace2();
					String wjAmfColorPlace3 = coOptionJacketWashableInfo.getWjAmfColorPlace3();
					String wjAmfColorPlace4 = coOptionJacketWashableInfo.getWjAmfColorPlace4();
					String wjAmfColorPlace5 = coOptionJacketWashableInfo.getWjAmfColorPlace5();
					String wjAmfColorPlace6 = coOptionJacketWashableInfo.getWjAmfColorPlace6();
					String wjAmfColorPlace7 = coOptionJacketWashableInfo.getWjAmfColorPlace7();
					String wjAmfColorPlace8 = coOptionJacketWashableInfo.getWjAmfColorPlace8();
					String wjAmfColorPlace9 = coOptionJacketWashableInfo.getWjAmfColorPlace9();
					
					String wjAmfColor1 = coOptionJacketWashableInfo.getWjAmfColor1();
					String wjAmfColor2 = coOptionJacketWashableInfo.getWjAmfColor2();
					String wjAmfColor3 = coOptionJacketWashableInfo.getWjAmfColor3();
					String wjAmfColor4 = coOptionJacketWashableInfo.getWjAmfColor4();
					String wjAmfColor5 = coOptionJacketWashableInfo.getWjAmfColor5();
					String wjAmfColor6 = coOptionJacketWashableInfo.getWjAmfColor6();
					String wjAmfColor7 = coOptionJacketWashableInfo.getWjAmfColor7();
					String wjAmfColor8 = coOptionJacketWashableInfo.getWjAmfColor8();
					String wjAmfColor9 = coOptionJacketWashableInfo.getWjAmfColor9();
					
					if(isEmpty(wjAmfColorPlace1)&&isEmpty(wjAmfColorPlace2)&&isEmpty(wjAmfColorPlace3)&&isEmpty(wjAmfColorPlace4)&&
					   isEmpty(wjAmfColorPlace5)&&isEmpty(wjAmfColorPlace6)&&isEmpty(wjAmfColorPlace7)&&isEmpty(wjAmfColorPlace8)&&isEmpty(wjAmfColorPlace9)) {
						messages.add("E032", "AMF色指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(wjAmfColorPlace1)&&isEmpty(wjAmfColor1)||isNotEmpty(wjAmfColorPlace2)&&isEmpty(wjAmfColor2)||
					   isNotEmpty(wjAmfColorPlace3)&&isEmpty(wjAmfColor3)||isNotEmpty(wjAmfColorPlace4)&&isEmpty(wjAmfColor4)||
					   isNotEmpty(wjAmfColorPlace5)&&isEmpty(wjAmfColor5)||isNotEmpty(wjAmfColorPlace6)&&isEmpty(wjAmfColor6)||
					   isNotEmpty(wjAmfColorPlace7)&&isEmpty(wjAmfColor7)||isNotEmpty(wjAmfColorPlace8)&&isEmpty(wjAmfColor8)||
					   isNotEmpty(wjAmfColorPlace9)&&isEmpty(wjAmfColor9)) {
						messages.add("E032", "AMF色指定");
						jacketFlag = true;
					}
					
				}
				
				//ボタンホール色指定
				String wjBhColor = coOptionJacketWashableInfo.getWjBhColor();
				if (OptionCodeKeys.JK_0003102.equals(wjBhColor)) {
					String wjBhColorPlace1 = coOptionJacketWashableInfo.getWjBhColorPlace1();
					String wjBhColorPlace2 = coOptionJacketWashableInfo.getWjBhColorPlace2();
					String wjBhColorPlace3 = coOptionJacketWashableInfo.getWjBhColorPlace3();
					String wjBhColorPlace4 = coOptionJacketWashableInfo.getWjBhColorPlace4();
					String wjBhColorPlace5 = coOptionJacketWashableInfo.getWjBhColorPlace5();
					String wjBhColorPlace6 = coOptionJacketWashableInfo.getWjBhColorPlace6();
					String wjBhColorPlace7 = coOptionJacketWashableInfo.getWjBhColorPlace7();
					String wjBhColorPlace8 = coOptionJacketWashableInfo.getWjBhColorPlace8();
					String wjBhColorPlace9 = coOptionJacketWashableInfo.getWjBhColorPlace9();
					String wjBhColorPlace10 = coOptionJacketWashableInfo.getWjBhColorPlace10();
					String wjBhColorPlace11 = coOptionJacketWashableInfo.getWjBhColorPlace11();
					String wjBhColorPlace12 = coOptionJacketWashableInfo.getWjBhColorPlace12();
					String wjBhColorPlace13 = coOptionJacketWashableInfo.getWjBhColorPlace13();
					String wjBhColorPlace14 = coOptionJacketWashableInfo.getWjBhColorPlace14();
					String wjBhColorPlace15 = coOptionJacketWashableInfo.getWjBhColorPlace15();
					String wjBhColorPlace16 = coOptionJacketWashableInfo.getWjBhColorPlace16();
					String wjBhColorPlace17 = coOptionJacketWashableInfo.getWjBhColorPlace17();
					
					String wjBhColor1 = coOptionJacketWashableInfo.getWjBhColor1();
					String wjBhColor2 = coOptionJacketWashableInfo.getWjBhColor2();
					String wjBhColor3 = coOptionJacketWashableInfo.getWjBhColor3();
					String wjBhColor4 = coOptionJacketWashableInfo.getWjBhColor4();
					String wjBhColor5 = coOptionJacketWashableInfo.getWjBhColor5();
					String wjBhColor6 = coOptionJacketWashableInfo.getWjBhColor6();
					String wjBhColor7 = coOptionJacketWashableInfo.getWjBhColor7();
					String wjBhColor8 = coOptionJacketWashableInfo.getWjBhColor8();
					String wjBhColor9 = coOptionJacketWashableInfo.getWjBhColor9();
					String wjBhColor10 = coOptionJacketWashableInfo.getWjBhColor10();
					String wjBhColor11 = coOptionJacketWashableInfo.getWjBhColor11();
					String wjBhColor12 = coOptionJacketWashableInfo.getWjBhColor12();
					String wjBhColor13 = coOptionJacketWashableInfo.getWjBhColor13();
					String wjBhColor14 = coOptionJacketWashableInfo.getWjBhColor14();
					String wjBhColor15 = coOptionJacketWashableInfo.getWjBhColor15();
					String wjBhColor16 = coOptionJacketWashableInfo.getWjBhColor16();
					String wjBhColor17 = coOptionJacketWashableInfo.getWjBhColor17();

					if (isEmpty(wjBhColorPlace1) && isEmpty(wjBhColorPlace2) && isEmpty(wjBhColorPlace3)
							&& isEmpty(wjBhColorPlace4) && isEmpty(wjBhColorPlace5) && isEmpty(wjBhColorPlace6)
							&& isEmpty(wjBhColorPlace7) && isEmpty(wjBhColorPlace8) && isEmpty(wjBhColorPlace9)
							&& isEmpty(wjBhColorPlace10)&& isEmpty(wjBhColorPlace11)&& isEmpty(wjBhColorPlace12)
							&& isEmpty(wjBhColorPlace13)&& isEmpty(wjBhColorPlace14)&& isEmpty(wjBhColorPlace15)
							&& isEmpty(wjBhColorPlace16)&& isEmpty(wjBhColorPlace17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(wjBhColorPlace1)&&isEmpty(wjBhColor1)||isNotEmpty(wjBhColorPlace2)&&isEmpty(wjBhColor2)||
					   isNotEmpty(wjBhColorPlace3)&&isEmpty(wjBhColor3)||isNotEmpty(wjBhColorPlace4)&&isEmpty(wjBhColor4)||
					   isNotEmpty(wjBhColorPlace5)&&isEmpty(wjBhColor5)||isNotEmpty(wjBhColorPlace6)&&isEmpty(wjBhColor6)||
					   isNotEmpty(wjBhColorPlace7)&&isEmpty(wjBhColor7)||isNotEmpty(wjBhColorPlace8)&&isEmpty(wjBhColor8)||
					   isNotEmpty(wjBhColorPlace9)&&isEmpty(wjBhColor9)||isNotEmpty(wjBhColorPlace10)&&isEmpty(wjBhColor10)||
					   isNotEmpty(wjBhColorPlace11)&&isEmpty(wjBhColor11)||isNotEmpty(wjBhColorPlace12)&&isEmpty(wjBhColor12)||
					   isNotEmpty(wjBhColorPlace13)&&isEmpty(wjBhColor13)||isNotEmpty(wjBhColorPlace14)&&isEmpty(wjBhColor14)||
					   isNotEmpty(wjBhColorPlace15)&&isEmpty(wjBhColor15)||isNotEmpty(wjBhColorPlace16)&&isEmpty(wjBhColor16)||
					   isNotEmpty(wjBhColorPlace17)&&isEmpty(wjBhColor17)) {
						messages.add("E032", "ボタンホール色指定");
						jacketFlag = true;
					}
				}
				
				//ボタン付け糸指定
				String wjByColor = coOptionJacketWashableInfo.getWjByColor();
				if (OptionCodeKeys.JK_0003402.equals(wjByColor)) {
					String wjByColorPlace1 = coOptionJacketWashableInfo.getWjByColorPlace1();
					String wjByColorPlace2 = coOptionJacketWashableInfo.getWjByColorPlace2();
					String wjByColorPlace3 = coOptionJacketWashableInfo.getWjByColorPlace3();
					String wjByColorPlace4 = coOptionJacketWashableInfo.getWjByColorPlace4();
					String wjByColorPlace5 = coOptionJacketWashableInfo.getWjByColorPlace5();
					String wjByColorPlace6 = coOptionJacketWashableInfo.getWjByColorPlace6();
					String wjByColorPlace7 = coOptionJacketWashableInfo.getWjByColorPlace7();
					String wjByColorPlace8 = coOptionJacketWashableInfo.getWjByColorPlace8();
					String wjByColorPlace9 = coOptionJacketWashableInfo.getWjByColorPlace9();
					String wjByColorPlace10 = coOptionJacketWashableInfo.getWjByColorPlace10();
					String wjByColorPlace11 = coOptionJacketWashableInfo.getWjByColorPlace11();
					String wjByColorPlace12 = coOptionJacketWashableInfo.getWjByColorPlace12();
					String wjByColorPlace13 = coOptionJacketWashableInfo.getWjByColorPlace13();
					String wjByColorPlace14 = coOptionJacketWashableInfo.getWjByColorPlace14();
					String wjByColorPlace15 = coOptionJacketWashableInfo.getWjByColorPlace15();
					String wjByColorPlace16 = coOptionJacketWashableInfo.getWjByColorPlace16();
					
					String wjByColor1 = coOptionJacketWashableInfo.getWjByColor1();
					String wjByColor2 = coOptionJacketWashableInfo.getWjByColor2();
					String wjByColor3 = coOptionJacketWashableInfo.getWjByColor3();
					String wjByColor4 = coOptionJacketWashableInfo.getWjByColor4();
					String wjByColor5 = coOptionJacketWashableInfo.getWjByColor5();
					String wjByColor6 = coOptionJacketWashableInfo.getWjByColor6();
					String wjByColor7 = coOptionJacketWashableInfo.getWjByColor7();
					String wjByColor8 = coOptionJacketWashableInfo.getWjByColor8();
					String wjByColor9 = coOptionJacketWashableInfo.getWjByColor9();
					String wjByColor10 = coOptionJacketWashableInfo.getWjByColor10();
					String wjByColor11 = coOptionJacketWashableInfo.getWjByColor11();
					String wjByColor12 = coOptionJacketWashableInfo.getWjByColor12();
					String wjByColor13 = coOptionJacketWashableInfo.getWjByColor13();
					String wjByColor14 = coOptionJacketWashableInfo.getWjByColor14();
					String wjByColor15 = coOptionJacketWashableInfo.getWjByColor15();
					String wjByColor16 = coOptionJacketWashableInfo.getWjByColor16();
					
					if (isEmpty(wjByColorPlace1) && isEmpty(wjByColorPlace2) && isEmpty(wjByColorPlace3)
							&& isEmpty(wjByColorPlace4) && isEmpty(wjByColorPlace5) && isEmpty(wjByColorPlace6)
							&& isEmpty(wjByColorPlace7) && isEmpty(wjByColorPlace8) && isEmpty(wjByColorPlace9)
							&& isEmpty(wjByColorPlace10)&& isEmpty(wjByColorPlace11)&& isEmpty(wjByColorPlace12)
							&& isEmpty(wjByColorPlace13)&& isEmpty(wjByColorPlace14)&& isEmpty(wjByColorPlace15)
							&& isEmpty(wjByColorPlace16)) {
						messages.add("E032", "ボタン付け糸指定");
						jacketFlag = true;
					}
					
					if(isNotEmpty(wjByColorPlace1)&&isEmpty(wjByColor1)||isNotEmpty(wjByColorPlace2)&&isEmpty(wjByColor2)||
					   isNotEmpty(wjByColorPlace3)&&isEmpty(wjByColor3)||isNotEmpty(wjByColorPlace4)&&isEmpty(wjByColor4)||
					   isNotEmpty(wjByColorPlace5)&&isEmpty(wjByColor5)||isNotEmpty(wjByColorPlace6)&&isEmpty(wjByColor6)||
					   isNotEmpty(wjByColorPlace7)&&isEmpty(wjByColor7)||isNotEmpty(wjByColorPlace8)&&isEmpty(wjByColor8)||
					   isNotEmpty(wjByColorPlace9)&&isEmpty(wjByColor9)||isNotEmpty(wjByColorPlace10)&&isEmpty(wjByColor10)||
					   isNotEmpty(wjByColorPlace11)&&isEmpty(wjByColor11)||isNotEmpty(wjByColorPlace12)&&isEmpty(wjByColor12)||
					   isNotEmpty(wjByColorPlace13)&&isEmpty(wjByColor13)||isNotEmpty(wjByColorPlace14)&&isEmpty(wjByColor14)||
					   isNotEmpty(wjByColorPlace15)&&isEmpty(wjByColor15)||isNotEmpty(wjByColorPlace16)&&isEmpty(wjByColor16)) {
						messages.add("E032", "ボタン付け糸指定");
						jacketFlag = true;
					}
				}
			}
			
			//補正
			CoAdjustJacketStandardInfo coAdjustJacketStandardInfo = orderCoForm.getCoAdjustJacketStandardInfo();
			if(coAdjustJacketStandardInfo == null) {
				 messages.add("E031", "JACKETサイズ");
				 jacketFlag = true;
			}else {
				String sizeFigure = coAdjustJacketStandardInfo.getSizeFigure();
				if("".equals(sizeFigure)||null == sizeFigure) {
					messages.add("E031", "JACKETサイズ体型");
					jacketFlag = true;
				}
				String sizeNumber = coAdjustJacketStandardInfo.getSizeNumber();
				if("".equals(sizeNumber)||null == sizeNumber) {
					messages.add("E031", "JACKETサイズ号数");
					jacketFlag = true;
				}
			}
			
			if (jacketFlag) {
//				if ("0".equals(itemFlag)) {
//					orderCoHelper.jacketDefaultValue(orderCoForm);
//				}
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm",orderCoForm);
				model.addAttribute("resultMessages",messages);
		        //return "forward:/orderCo/orderCoBack";
				return "order/orderCoForm";
			}
		}
		// PANTSチェック
		if ("03".equals(item)) {
			boolean pantstFlag = false;
			String itemFlag = orderCoForm.getPantsItemFlag();
			ResultMessages messages = ResultMessages.error();
			// 標準の場合
			if ("9000101".equals(productCategory)) {
				// PANTS モデル未選択の場合
				CoOptionPantsStandardInfo coOptionPantsStandardInfo = orderCoForm.getCoOptionPantsStandardInfo();
				String opPantsModel = coOptionPantsStandardInfo.getOpPantsModel();
				if ("".equals(opPantsModel) || null == opPantsModel) {
					messages.add("E031", "PANTS モデル");
					pantstFlag = true;
				}
				//PANTS ベルトループ
				String opBeltLoop = coOptionPantsStandardInfo.getOpBeltLoop();
				if (OptionCodeKeys.PT_0000701.equals(opBeltLoop)) {
					String opBeltLoopPlace1 = coOptionPantsStandardInfo.getOpBeltLoopPlace1();
					String opBeltLoopPlace2 = coOptionPantsStandardInfo.getOpBeltLoopPlace2();
					String opBeltLoopPlace3 = coOptionPantsStandardInfo.getOpBeltLoopPlace3();
					String opBeltLoopPlace4 = coOptionPantsStandardInfo.getOpBeltLoopPlace4();
					String opBeltLoopPlace5 = coOptionPantsStandardInfo.getOpBeltLoopPlace5();
					String opBeltLoopPlace6 = coOptionPantsStandardInfo.getOpBeltLoopPlace6();

					if (isEmpty(opBeltLoopPlace1) && isEmpty(opBeltLoopPlace2) && isEmpty(opBeltLoopPlace3)
							&& isEmpty(opBeltLoopPlace4) && isEmpty(opBeltLoopPlace5) && isEmpty(opBeltLoopPlace6)) {
						messages.add("E033", "PANTS ベルトループ");
						pantstFlag = true;
					}
				}
				//PANTS ステッチ箇所変更
				String opStitchModify = coOptionPantsStandardInfo.getOpStitchModify();
				if (OptionCodeKeys.PT_0002002.equals(opStitchModify)) {
					String opStitchModifyPlace1 = coOptionPantsStandardInfo.getOpStitchModifyPlace1();
					String opStitchModifyPlace2 = coOptionPantsStandardInfo.getOpStitchModifyPlace2();
					String opStitchModifyPlace3 = coOptionPantsStandardInfo.getOpStitchModifyPlace3();
					String opStitchModifyPlace4 = coOptionPantsStandardInfo.getOpStitchModifyPlace4();

					if (isEmpty(opStitchModifyPlace1) && isEmpty(opStitchModifyPlace2) && isEmpty(opStitchModifyPlace3)
							&& isEmpty(opStitchModifyPlace4)) {
						messages.add("E033", "PANTS ステッチ箇所変更");
						pantstFlag = true;
					}
				}
				//PANTS  ダブルステッチ
				String opDStitch = coOptionPantsStandardInfo.getOpDStitch();
				if (OptionCodeKeys.PT_0002202.equals(opDStitch)) {
					String opDStitchPlace1 = coOptionPantsStandardInfo.getOpDStitchPlace1();
					String opDStitchPlace2 = coOptionPantsStandardInfo.getOpDStitchPlace2();
					String opDStitchPlace3 = coOptionPantsStandardInfo.getOpDStitchPlace3();
					String opDStitchPlace4 = coOptionPantsStandardInfo.getOpDStitchPlace4();

					if (isEmpty(opDStitchPlace1) && isEmpty(opDStitchPlace2) && isEmpty(opDStitchPlace3)
							&& isEmpty(opDStitchPlace4)) {
						messages.add("E033", "PANTS ダブルステッチ");
						pantstFlag = true;
					}
				}
				//PANTS AMF色指定
				String opAmfColor = coOptionPantsStandardInfo.getOpAmfColor();
				if (OptionCodeKeys.PT_0002402.equals(opAmfColor)) {
					String opAmfColorPlace1 = coOptionPantsStandardInfo.getOpAmfColorPlace1();
					String opAmfColorPlace2 = coOptionPantsStandardInfo.getOpAmfColorPlace2();
					String opAmfColorPlace3 = coOptionPantsStandardInfo.getOpAmfColorPlace3();
					String opAmfColorPlace4 = coOptionPantsStandardInfo.getOpAmfColorPlace4();

					String opAmfColor1 = coOptionPantsStandardInfo.getOpAmfColor1();
					String opAmfColor2 = coOptionPantsStandardInfo.getOpAmfColor2();
					String opAmfColor3 = coOptionPantsStandardInfo.getOpAmfColor3();
					String opAmfColor4 = coOptionPantsStandardInfo.getOpAmfColor4();
					if (isEmpty(opAmfColorPlace1) && isEmpty(opAmfColorPlace2) && isEmpty(opAmfColorPlace3)
							&& isEmpty(opAmfColorPlace4)) {
						messages.add("E033", "PANTS AMF色指定");
						pantstFlag = true;
					}
					if(isNotEmpty(opAmfColorPlace1)&&isEmpty(opAmfColor1)||isNotEmpty(opAmfColorPlace2)&&isEmpty(opAmfColor2)||
					   isNotEmpty(opAmfColorPlace3)&&isEmpty(opAmfColor3)||isNotEmpty(opAmfColorPlace4)&&isEmpty(opAmfColor4)) {
						 messages.add("E033", "PANTS AMF色指定");
						 pantstFlag = true;
					}
				}
				// ボタンホール色指定
				String opBhColor = coOptionPantsStandardInfo.getOpBhColor();
				if (OptionCodeKeys.PT_0002702.equals(opBhColor)) {
					String opBhColorPlace1 = coOptionPantsStandardInfo.getOpBhColorPlace1();
					String opBhColorPlace2 = coOptionPantsStandardInfo.getOpBhColorPlace2();
					String opBhColorPlace3 = coOptionPantsStandardInfo.getOpBhColorPlace3();
					String opBhColorPlace4 = coOptionPantsStandardInfo.getOpBhColorPlace4();

					String opBhColor1 = coOptionPantsStandardInfo.getOpBhColor1();
					String opBhColor2 = coOptionPantsStandardInfo.getOpBhColor2();
					String opBhColor3 = coOptionPantsStandardInfo.getOpBhColor3();
					String opBhColor4 = coOptionPantsStandardInfo.getOpBhColor4();
					
					if (isEmpty(opBhColorPlace1) && isEmpty(opBhColorPlace2) && isEmpty(opBhColorPlace3)
							&& isEmpty(opBhColorPlace4)) {
						messages.add("E033", "ボタンホール色指定");
						pantstFlag = true;
					}
					
					if(isNotEmpty(opBhColorPlace1)&&isEmpty(opBhColor1)||isNotEmpty(opBhColorPlace2)&&isEmpty(opBhColor2)||
					isNotEmpty(opBhColorPlace3)&&isEmpty(opBhColor3)||isNotEmpty(opBhColorPlace4)&&isEmpty(opBhColor4)) {
						messages.add("E033", "PANTS ボタンホール色指定");
						pantstFlag = true;
					}
				}

				// ボタン付け糸指定
				String opByColor = coOptionPantsStandardInfo.getOpByColor();
				if (OptionCodeKeys.PT_0003002.equals(opByColor)) {
					String opByColorPlace1 = coOptionPantsStandardInfo.getOpByColorPlace1();
					String opByColorPlace2 = coOptionPantsStandardInfo.getOpByColorPlace2();
					String opByColorPlace3 = coOptionPantsStandardInfo.getOpByColorPlace3();
					String opByColorPlace4 = coOptionPantsStandardInfo.getOpByColorPlace4();

					String opByColor1 = coOptionPantsStandardInfo.getOpByColor1();
					String opByColor2 = coOptionPantsStandardInfo.getOpByColor2();
					String opByColor3 = coOptionPantsStandardInfo.getOpByColor3();
					String opByColor4 = coOptionPantsStandardInfo.getOpByColor4();
					if (isEmpty(opByColorPlace1) && isEmpty(opByColorPlace2) && isEmpty(opByColorPlace3)
							&& isEmpty(opByColorPlace4)) {
						messages.add("E033", "ボタン付け糸指定");
						pantstFlag = true;
					}
					if(isNotEmpty(opByColorPlace1)&&isEmpty(opByColor1)||isNotEmpty(opByColorPlace2)&&isEmpty(opByColor2)||
					   isNotEmpty(opByColorPlace3)&&isEmpty(opByColor3)||isNotEmpty(opByColorPlace4)&&isEmpty(opByColor4)) {
						messages.add("E033", "PANTS ボタン付け糸指定");
						pantstFlag = true;
					}
				}
				//PANTS  タキシードの場合
			} else if ("9000102".equals(productCategory)) {
				// PANTS モデル未選択の場合
				CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo = orderCoForm.getCoOptionPantsTuxedoInfo();
				String tpPantsModel = coOptionPantsTuxedoInfo.getTpPantsModel();
				if ("".equals(tpPantsModel) || null == tpPantsModel) {
					messages.add("E031", "PANTS モデル");
					pantstFlag = true;
				}
				//PANTS  ベルトループ
				String tpBeltLoop = coOptionPantsTuxedoInfo.getTpBeltLoop();
				if (OptionCodeKeys.PT_0000701.equals(tpBeltLoop)) {
					String tpBeltLoopPlace1 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace1();
					String tpBeltLoopPlace2 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace2();
					String tpBeltLoopPlace3 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace3();
					String tpBeltLoopPlace4 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace4();
					String tpBeltLoopPlace5 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace5();
					String tpBeltLoopPlace6 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace6();
					String tpBeltLoopPlace7 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace7();

					if (isEmpty(tpBeltLoopPlace1) && isEmpty(tpBeltLoopPlace2) && isEmpty(tpBeltLoopPlace3)
							&& isEmpty(tpBeltLoopPlace4) && isEmpty(tpBeltLoopPlace5) && isEmpty(tpBeltLoopPlace6)
							&& isEmpty(tpBeltLoopPlace7)) {
						messages.add("E033", "PANTS ベルトループ");
						pantstFlag = true;
					}
					//PANTS  ボタンホール色指定
					String opBhColor = coOptionPantsTuxedoInfo.getTpBhColor();
					if (OptionCodeKeys.PT_0002702.equals(opBhColor)) {
						String tpBhColorPlace1 = coOptionPantsTuxedoInfo.getTpBhColorPlace1();
						String tpBhColorPlace2 = coOptionPantsTuxedoInfo.getTpBhColorPlace2();
						String tpBhColorPlace3 = coOptionPantsTuxedoInfo.getTpBhColorPlace3();
						String tpBhColorPlace4 = coOptionPantsTuxedoInfo.getTpBhColorPlace4();

						String tpBhColor1 = coOptionPantsTuxedoInfo.getTpBhColor1();
						String tpBhColor2 = coOptionPantsTuxedoInfo.getTpBhColor2();
						String tpBhColor3 = coOptionPantsTuxedoInfo.getTpBhColor3();
						String tpBhColor4 = coOptionPantsTuxedoInfo.getTpBhColor4();
						
						if (isEmpty(tpBhColorPlace1) && isEmpty(tpBhColorPlace2) && isEmpty(tpBhColorPlace3)
								&& isEmpty(tpBhColorPlace4)) {
							messages.add("E033", "PANTS ボタンホール色指定");
							pantstFlag = true;
						}
						if(isNotEmpty(tpBhColorPlace1)&&isEmpty(tpBhColor1)||isNotEmpty(tpBhColorPlace2)&&isEmpty(tpBhColor2)||
						   isNotEmpty(tpBhColorPlace3)&&isEmpty(tpBhColor3)||isNotEmpty(tpBhColorPlace4)&&isEmpty(tpBhColor4)) {
							 messages.add("E033", "PANTS ボタンホール色指定");
							 pantstFlag = true;
						}
					}
						// ボタン付け糸指定
						String tpByColor = coOptionPantsTuxedoInfo.getTpByColor();
						if (OptionCodeKeys.PT_0003002.equals(tpByColor)) {
							String tpByColorPlace1 = coOptionPantsTuxedoInfo.getTpByColorPlace1();
							String tpByColorPlace2 = coOptionPantsTuxedoInfo.getTpByColorPlace2();
							String tpByColorPlace3 = coOptionPantsTuxedoInfo.getTpByColorPlace3();
							String tpByColorPlace4 = coOptionPantsTuxedoInfo.getTpByColorPlace4();
							
							String tpByColor1 = coOptionPantsTuxedoInfo.getTpByColor1();
							String tpByColor2 = coOptionPantsTuxedoInfo.getTpByColor2();
							String tpByColor3 = coOptionPantsTuxedoInfo.getTpByColor3();
							String tpByColor4 = coOptionPantsTuxedoInfo.getTpByColor4();

							if (isEmpty(tpByColorPlace1) && isEmpty(tpByColorPlace2) && isEmpty(tpByColorPlace3)
									&& isEmpty(tpByColorPlace4)) {
								messages.add("E033", "ボタン付け糸指定");
								pantstFlag = true;
							}
							if(isNotEmpty(tpByColorPlace1)&&isEmpty(tpByColor1)||isNotEmpty(tpByColorPlace2)&&isEmpty(tpByColor2)||
							   isNotEmpty(tpByColorPlace3)&&isEmpty(tpByColor3)||isNotEmpty(tpByColorPlace4)&&isEmpty(tpByColor4)) {
								messages.add("E033", "PANTS ボタン付け糸指定");
								pantstFlag = true;
							}
						}
					
				}
			} else if ("9000103".equals(productCategory)) {
				// PANTS モデル未選択の場合
				CoOptionPantsWashableInfo coOptionPantsWashableInfo = orderCoForm.getCoOptionPantsWashableInfo();
				String wpPantsModel = coOptionPantsWashableInfo.getWpPantsModel();
				if ("".equals(wpPantsModel) || null == wpPantsModel) {
					messages.add("E031", "PANTS モデル");
					pantstFlag = true;
				}
				//PANTS ステッチ箇所変更
				String wpStitchModify = coOptionPantsWashableInfo.getWpStitchModify();
				if (OptionCodeKeys.PT_0002002.equals(wpStitchModify)) {
					String wpStitchModifyPlace1 = coOptionPantsWashableInfo.getWpStitchModifyPlace1();
					String wpStitchModifyPlace2 = coOptionPantsWashableInfo.getWpStitchModifyPlace2();
					String wpStitchModifyPlace3 = coOptionPantsWashableInfo.getWpStitchModifyPlace3();
					String wpStitchModifyPlace4 = coOptionPantsWashableInfo.getWpStitchModifyPlace4();
					if (isEmpty(wpStitchModifyPlace1) && isEmpty(wpStitchModifyPlace2) && isEmpty(wpStitchModifyPlace3)
							&& isEmpty(wpStitchModifyPlace4)) {
						messages.add("E033", "PANTS ステッチ箇所変更");
						pantstFlag = true;
					}
				}
				//PANTS ダブルステッチ
				String wpDStitch = coOptionPantsWashableInfo.getWpDStitch();
				if (OptionCodeKeys.PT_0002202.equals(wpDStitch)) {
					String wpDStitchPlace1 = coOptionPantsWashableInfo.getWpDStitchPlace1();
					String wpDStitchPlace2 = coOptionPantsWashableInfo.getWpDStitchPlace2();
					String wpDStitchPlace3 = coOptionPantsWashableInfo.getWpDStitchPlace3();
					String wpDStitchPlace4 = coOptionPantsWashableInfo.getWpDStitchPlace4();
					if (isEmpty(wpDStitchPlace1) && isEmpty(wpDStitchPlace2) && isEmpty(wpDStitchPlace3)
							&& isEmpty(wpDStitchPlace4)) {
						messages.add("E033", "PANTS ダブルステッチ");
						pantstFlag = true;
					}
				}

				//PANTS AMF色指定
				String wpamfColor = coOptionPantsWashableInfo.getWpAmfColor();
				if (OptionCodeKeys.PT_0002402.equals(wpamfColor)) {
					String wpamfColorPlace1 = coOptionPantsWashableInfo.getWpAmfColorPlace1();
					String wpamfColorPlace2 = coOptionPantsWashableInfo.getWpAmfColorPlace2();
					String wpamfColorPlace3 = coOptionPantsWashableInfo.getWpAmfColorPlace3();
					String wpamfColorPlace4 = coOptionPantsWashableInfo.getWpAmfColorPlace4();
					
					String wpamfColor1 = coOptionPantsWashableInfo.getWpAmfColor1();
					String wpamfColor2 = coOptionPantsWashableInfo.getWpAmfColor2();
					String wpamfColor3 = coOptionPantsWashableInfo.getWpAmfColor3();
					String wpamfColor4 = coOptionPantsWashableInfo.getWpAmfColor4();
					
					if (isEmpty(wpamfColorPlace1) && isEmpty(wpamfColorPlace2) && isEmpty(wpamfColorPlace3)
							&& isEmpty(wpamfColorPlace4)) {
						messages.add("E033", "PANTS AMF色指定");
						pantstFlag = true;
					}
					if(isNotEmpty(wpamfColorPlace1)&&isEmpty(wpamfColor1)||isNotEmpty(wpamfColorPlace2)&&isEmpty(wpamfColor2)||
					  isNotEmpty(wpamfColorPlace3)&&isEmpty(wpamfColor3)||isNotEmpty(wpamfColorPlace4)&&isEmpty(wpamfColor4)) {
						messages.add("E033", "PANTS AMF色指定");
						pantstFlag = true;
					}
				}

				//PANTS  ボタンホール色指定
				String wpBhColor = coOptionPantsWashableInfo.getWpBhColor();
				if (OptionCodeKeys.PT_0002702.equals(wpBhColor)) {
					String wpBhColorPlace1 = coOptionPantsWashableInfo.getWpBhColorPlace1();
					String wpBhColorPlace2 = coOptionPantsWashableInfo.getWpBhColorPlace2();
					String wpBhColorPlace3 = coOptionPantsWashableInfo.getWpBhColorPlace3();
					String wpBhColorPlace4 = coOptionPantsWashableInfo.getWpBhColorPlace4();

					String wpBhColor1 = coOptionPantsWashableInfo.getWpBhColor1();
					String wpBhColor2 = coOptionPantsWashableInfo.getWpBhColor2();
					String wpBhColor3 = coOptionPantsWashableInfo.getWpBhColor3();
					String wpBhColor4 = coOptionPantsWashableInfo.getWpBhColor4();
					
					if (isEmpty(wpBhColorPlace1) && isEmpty(wpBhColorPlace2) && isEmpty(wpBhColorPlace3)
							&& isEmpty(wpBhColorPlace4)) {
						messages.add("E033", "ボタンホール色指定");
						pantstFlag = true;
					}
					if(isNotEmpty(wpBhColorPlace1)&&isEmpty(wpBhColor1)||isNotEmpty(wpBhColorPlace2)&&isEmpty(wpBhColor2)||
					   isNotEmpty(wpBhColorPlace3)&&isEmpty(wpBhColor3)||isNotEmpty(wpBhColorPlace4)&&isEmpty(wpBhColor4)) {
						messages.add("E033", "PANTS ボタンホール色指定");
						pantstFlag = true;
							}
				}

				// ボタン付け糸指定
				String wpByColor = coOptionPantsWashableInfo.getWpByColor();
				if (OptionCodeKeys.PT_0003002.equals(wpByColor)) {
					String wpByColorPlace1 = coOptionPantsWashableInfo.getWpByColorPlace1();
					String wpByColorPlace2 = coOptionPantsWashableInfo.getWpByColorPlace2();
					String wpByColorPlace3 = coOptionPantsWashableInfo.getWpByColorPlace3();
					String wpByColorPlace4 = coOptionPantsWashableInfo.getWpByColorPlace4();
					
					String wpByColor1 = coOptionPantsWashableInfo.getWpByColor1();
					String wpByColor2 = coOptionPantsWashableInfo.getWpByColor2();
					String wpByColor3 = coOptionPantsWashableInfo.getWpByColor3();
					String wpByColor4 = coOptionPantsWashableInfo.getWpByColor4();
					
					if (isEmpty(wpByColorPlace1) && isEmpty(wpByColorPlace2) && isEmpty(wpByColorPlace3)
							&& isEmpty(wpByColorPlace4)) {
						messages.add("E033", "ボタン付け糸指定");
						pantstFlag = true;
					}
					if(isNotEmpty(wpByColorPlace1)&&isEmpty(wpByColor1)||isNotEmpty(wpByColorPlace2)&&isEmpty(wpByColor2)||
					   isNotEmpty(wpByColorPlace3)&&isEmpty(wpByColor3)||isNotEmpty(wpByColorPlace4)&&isEmpty(wpByColor4)) {
						 messages.add("E033", "PANTS  ボタン付け糸指定");
						 pantstFlag = true;
					}
				}
			}

			// 補正
			CoAdjustPantsStandardInfo coAdjustPantsStandardInfo = orderCoForm.getCoAdjustPantsStandardInfo();
			if (coAdjustPantsStandardInfo == null) {
				messages.add("E031", "PANTSサイズ");
				pantstFlag = true;
			} else {
				String sizeFigure = coAdjustPantsStandardInfo.getSizeFigure();
				if ("".equals(sizeFigure) || null == sizeFigure) {
					messages.add("E031", "PANTSサイズ体型");
					pantstFlag = true;
				}
				String sizeNumber = coAdjustPantsStandardInfo.getSizeNumber();
				if ("".equals(sizeNumber) || null == sizeNumber) {
					messages.add("E031", "PANTSサイズ号数");
					pantstFlag = true;
				}
			}
			String corPtLeftinseamGross = coAdjustPantsStandardInfo.getCorPtLeftinseamGross();
			
			boolean falg=GrossCompareTo(corPtLeftinseamGross,messages,"PANTS（1本目）左股下");
			if(falg) {
				pantstFlag = true;
			}
			String corPtRightinseamGross = coAdjustPantsStandardInfo.getCorPtRightinseamGross();
			falg=GrossCompareTo(corPtRightinseamGross,messages,"PANTS（1本目）右股下");
			if(falg) {
				pantstFlag = true;
			}

			if (pantstFlag) {
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm", orderCoForm);
				model.addAttribute("resultMessages", messages);
				return "forward:/orderCo/orderCoBack";
			}
		}
		
		
		// GILETチェック
		if ("04".equals(item)) {
			boolean giletFlag = false;
//			String itemFlag = orderCoForm.getGiletItemFlag();
			ResultMessages messages = ResultMessages.error();
			
			if ("9000101".equals(productCategory)) {
				// GILETモデル未選択の場合
				CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
				String ogGiletModel = coOptionGiletStandardInfo.getOgGiletModel();
				if ("".equals(ogGiletModel) || null == ogGiletModel) {
					messages.add("E031", "GILET モデル");
					giletFlag = true;
				}
				//ステッチ箇所変更
				String ogStitchModify = coOptionGiletStandardInfo.getOgStitchModify();
				if (OptionCodeKeys.GL_0000602.equals(ogStitchModify)) {
					String ogStitchModifyPlace1 = coOptionGiletStandardInfo.getOgStitchModifyPlace1();
					String ogStitchModifyPlace2 = coOptionGiletStandardInfo.getOgStitchModifyPlace2();
					String ogStitchModifyPlace3 = coOptionGiletStandardInfo.getOgStitchModifyPlace3();

					if (isEmpty(ogStitchModifyPlace1) && isEmpty(ogStitchModifyPlace2) && isEmpty(ogStitchModifyPlace3)) {
						messages.add("E033", "GILET ステッチ箇所変更");
						giletFlag = true;
					}
				}
				// ダブルステッチ
				String ogDStitchModify = coOptionGiletStandardInfo.getOgDStitchModify();
				if (OptionCodeKeys.GL_0002602.equals(ogDStitchModify)) {
					String ogDStitchModifyPlace1 = coOptionGiletStandardInfo.getOgDStitchModifyPlace1();
					String ogDStitchModifyPlace2 = coOptionGiletStandardInfo.getOgDStitchModifyPlace2();
					String ogDStitchModifyPlace3 = coOptionGiletStandardInfo.getOgDStitchModifyPlace3();

					if (isEmpty(ogDStitchModifyPlace1) && isEmpty(ogDStitchModifyPlace2) && isEmpty(ogDStitchModifyPlace3)) {
						messages.add("E033", "GILET ダブルステッチ");
						giletFlag = true;
					}
				}
				// AMF色指定
				String ogAmfColor = coOptionGiletStandardInfo.getOgAmfColor();
				if (OptionCodeKeys.GL_0000802.equals(ogAmfColor)) {
					String ogAmfColorPlace1 = coOptionGiletStandardInfo.getOgAmfColorPlace1();
					String ogAmfColorPlace2 = coOptionGiletStandardInfo.getOgAmfColorPlace2();
					String ogAmfColorPlace3 = coOptionGiletStandardInfo.getOgAmfColorPlace3();

					String ogAmfColor1 = coOptionGiletStandardInfo.getOgAmfColor1();
					String ogAmfColor2 = coOptionGiletStandardInfo.getOgAmfColor2();
					String ogAmfColor3 = coOptionGiletStandardInfo.getOgAmfColor3();
					if (isEmpty(ogAmfColorPlace1) && isEmpty(ogAmfColorPlace2) && isEmpty(ogAmfColorPlace3)) {
						messages.add("E033", "GILET AMF色指定");
						giletFlag = true;
					}
					if(isNotEmpty(ogAmfColorPlace1)&&isEmpty(ogAmfColor1)||isNotEmpty(ogAmfColorPlace2)&&isEmpty(ogAmfColor2)||
					   isNotEmpty(ogAmfColorPlace3)&&isEmpty(ogAmfColor3)) {
						messages.add("E033", "GILET AMF色指定");
						giletFlag = true;
					}
				}
				//ボタンホール色指定
				String ogBhColor = coOptionGiletStandardInfo.getOgBhColor();
				if (OptionCodeKeys.GL_0001102.equals(ogBhColor)) {
					String ogBhColorPlace1 = coOptionGiletStandardInfo.getOgBhColorPlace1();
					String ogBhColorPlace2 = coOptionGiletStandardInfo.getOgBhColorPlace2();
					String ogBhColorPlace3 = coOptionGiletStandardInfo.getOgBhColorPlace3();
					String ogBhColorPlace4 = coOptionGiletStandardInfo.getOgBhColorPlace4();
					String ogBhColorPlace5 = coOptionGiletStandardInfo.getOgBhColorPlace5();
					String ogBhColorPlace6 = coOptionGiletStandardInfo.getOgBhColorPlace6();

					String ogBhColor1 = coOptionGiletStandardInfo.getOgBhColor1();
					String ogBhColor2 = coOptionGiletStandardInfo.getOgBhColor2();
					String ogBhColor3 = coOptionGiletStandardInfo.getOgBhColor3();
					String ogBhColor4 = coOptionGiletStandardInfo.getOgBhColor4();
					String ogBhColor5 = coOptionGiletStandardInfo.getOgBhColor5();
					String ogBhColor6 = coOptionGiletStandardInfo.getOgBhColor6();
					
					if (isEmpty(ogBhColorPlace1) && isEmpty(ogBhColorPlace2) && isEmpty(ogBhColorPlace3)
							&& isEmpty(ogBhColorPlace4) && isEmpty(ogBhColorPlace5) && isEmpty(ogBhColorPlace6)) {
						messages.add("E033", "GILET ボタンホール色指定");
						giletFlag = true;
					}
					if(isNotEmpty(ogBhColorPlace1)&&isEmpty(ogBhColor1)||isNotEmpty(ogBhColorPlace2)&&isEmpty(ogBhColor2)||
					   isNotEmpty(ogBhColorPlace3)&&isEmpty(ogBhColor3)||isNotEmpty(ogBhColorPlace4)&&isEmpty(ogBhColor4)||
					   isNotEmpty(ogBhColorPlace5)&&isEmpty(ogBhColor5)||isNotEmpty(ogBhColorPlace6)&&isEmpty(ogBhColor6)) {
						messages.add("E033", "GILET ボタンホール色指定");
						giletFlag = true;
					}
				}
				// ボタン付け糸指定
				String ogByColor = coOptionGiletStandardInfo.getOgByColor();
				if (OptionCodeKeys.GL_0001402.equals(ogByColor)) {
					String ogByColorPlace1 = coOptionGiletStandardInfo.getOgByColorPlace1();
					String ogByColorPlace2 = coOptionGiletStandardInfo.getOgByColorPlace2();
					String ogByColorPlace3 = coOptionGiletStandardInfo.getOgByColorPlace3();
					String ogByColorPlace4 = coOptionGiletStandardInfo.getOgByColorPlace4();
					String ogByColorPlace5 = coOptionGiletStandardInfo.getOgByColorPlace5();
					String ogByColorPlace6 = coOptionGiletStandardInfo.getOgByColorPlace6();
					String ogByColorPlace7 = coOptionGiletStandardInfo.getOgByColorPlace7();
					String ogByColorPlace8 = coOptionGiletStandardInfo.getOgByColorPlace8();
					String ogByColorPlace9 = coOptionGiletStandardInfo.getOgByColorPlace9();
					String ogByColorPlace10 = coOptionGiletStandardInfo.getOgByColorPlace10();

					String ogByColor1 = coOptionGiletStandardInfo.getOgByColor1();
					String ogByColor2 = coOptionGiletStandardInfo.getOgByColor2();
					String ogByColor3 = coOptionGiletStandardInfo.getOgByColor3();
					String ogByColor4 = coOptionGiletStandardInfo.getOgByColor4();
					String ogByColor5 = coOptionGiletStandardInfo.getOgByColor5();
					String ogByColor6 = coOptionGiletStandardInfo.getOgByColor6();
					String ogByColor7 = coOptionGiletStandardInfo.getOgByColor7();
					String ogByColor8 = coOptionGiletStandardInfo.getOgByColor8();
					String ogByColor9 = coOptionGiletStandardInfo.getOgByColor9();
					String ogByColor10 = coOptionGiletStandardInfo.getOgByColor10();
					if (isEmpty(ogByColorPlace1) && isEmpty(ogByColorPlace2) && isEmpty(ogByColorPlace3)
							&& isEmpty(ogByColorPlace4) && isEmpty(ogByColorPlace5) && isEmpty(ogByColorPlace6)
							&& isEmpty(ogByColorPlace7) && isEmpty(ogByColorPlace8) && isEmpty(ogByColorPlace9)
							&& isEmpty(ogByColorPlace10)) {
						messages.add("E033", "GILET ボタン付け糸指定");
						giletFlag = true;
					}
					if(isNotEmpty(ogByColorPlace1)&&isEmpty(ogByColor1)||isNotEmpty(ogByColorPlace2)&&isEmpty(ogByColor2)||
					   isNotEmpty(ogByColorPlace3)&&isEmpty(ogByColor3)||isNotEmpty(ogByColorPlace4)&&isEmpty(ogByColor4)||
					   isNotEmpty(ogByColorPlace5)&&isEmpty(ogByColor5)||isNotEmpty(ogByColorPlace6)&&isEmpty(ogByColor6)||
					   isNotEmpty(ogByColorPlace7)&&isEmpty(ogByColor7)||isNotEmpty(ogByColorPlace8)&&isEmpty(ogByColor8)||
					   isNotEmpty(ogByColorPlace9)&&isEmpty(ogByColor9)||isNotEmpty(ogByColorPlace10)&&isEmpty(ogByColor10)) {
						messages.add("E033", "GILET ボタン付け糸指定");
						giletFlag = true;
					}
				}
				
			}else if ("9000102".equals(productCategory)) {
				// GILET モデル未選択の場合
				CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
				String tgGiletModel = coOptionGiletTuxedoInfo.getTgGiletModel();
				if ("".equals(tgGiletModel) || null == tgGiletModel) {
					messages.add("E031", "GILET モデル");
					giletFlag = true;
				}
				// ボタンホール色指定
				String tgBhColor = coOptionGiletTuxedoInfo.getTgBhColor();
				if (OptionCodeKeys.GL_0001102.equals(tgBhColor)) {
					String tgBhColorPlace1 = coOptionGiletTuxedoInfo.getTgBhColorPlace1();
					String tgBhColorPlace2 = coOptionGiletTuxedoInfo.getTgBhColorPlace2();
					String tgBhColorPlace3 = coOptionGiletTuxedoInfo.getTgBhColorPlace3();
					String tgBhColorPlace4 = coOptionGiletTuxedoInfo.getTgBhColorPlace4();
					String tgBhColorPlace5 = coOptionGiletTuxedoInfo.getTgBhColorPlace5();
					String tgBhColorPlace6 = coOptionGiletTuxedoInfo.getTgBhColorPlace6();

					String tgBhColor1 = coOptionGiletTuxedoInfo.getTgBhColor1();
					String tgBhColor2 = coOptionGiletTuxedoInfo.getTgBhColor2();
					String tgBhColor3 = coOptionGiletTuxedoInfo.getTgBhColor3();
					String tgBhColor4 = coOptionGiletTuxedoInfo.getTgBhColor4();
					String tgBhColor5 = coOptionGiletTuxedoInfo.getTgBhColor5();
					String tgBhColor6 = coOptionGiletTuxedoInfo.getTgBhColor6();
					
					if (isEmpty(tgBhColorPlace1) && isEmpty(tgBhColorPlace2) && isEmpty(tgBhColorPlace3)
							&& isEmpty(tgBhColorPlace4) && isEmpty(tgBhColorPlace5) && isEmpty(tgBhColorPlace6)) {
						messages.add("E033", "GILET ボタンホール色指定");
						giletFlag = true;
					}
					if(isNotEmpty(tgBhColorPlace1)&&isEmpty(tgBhColor1)||isNotEmpty(tgBhColorPlace2)&&isEmpty(tgBhColor2)||
					   isNotEmpty(tgBhColorPlace3)&&isEmpty(tgBhColor3)||isNotEmpty(tgBhColorPlace4)&&isEmpty(tgBhColor4)||
					   isNotEmpty(tgBhColorPlace5)&&isEmpty(tgBhColor5)||isNotEmpty(tgBhColorPlace6)&&isEmpty(tgBhColor6)) {
						messages.add("E033", "GILET ボタンホール色指定");
						giletFlag = true;
					}
				}
				// ボタン付け糸指定
				String tgByColor = coOptionGiletTuxedoInfo.getTgByColor();
				if (OptionCodeKeys.GL_0001402.equals(tgByColor)) {
					String tgByColorPlace1 = coOptionGiletTuxedoInfo.getTgByColorPlace1();
					String tgByColorPlace2 = coOptionGiletTuxedoInfo.getTgByColorPlace2();
					String tgByColorPlace3 = coOptionGiletTuxedoInfo.getTgByColorPlace3();
					String tgByColorPlace4 = coOptionGiletTuxedoInfo.getTgByColorPlace4();
					String tgByColorPlace5 = coOptionGiletTuxedoInfo.getTgByColorPlace5();
					String tgByColorPlace6 = coOptionGiletTuxedoInfo.getTgByColorPlace6();
					String tgByColorPlace7 = coOptionGiletTuxedoInfo.getTgByColorPlace7();
					String tgByColorPlace8 = coOptionGiletTuxedoInfo.getTgByColorPlace8();
					String tgByColorPlace9 = coOptionGiletTuxedoInfo.getTgByColorPlace9();
					String tgByColorPlace10 = coOptionGiletTuxedoInfo.getTgByColorPlace10();

					String tgByColor1 = coOptionGiletTuxedoInfo.getTgByColor1();
					String tgByColor2 = coOptionGiletTuxedoInfo.getTgByColor2();
					String tgByColor3 = coOptionGiletTuxedoInfo.getTgByColor3();
					String tgByColor4 = coOptionGiletTuxedoInfo.getTgByColor4();
					String tgByColor5 = coOptionGiletTuxedoInfo.getTgByColor5();
					String tgByColor6 = coOptionGiletTuxedoInfo.getTgByColor6();
					String tgByColor7 = coOptionGiletTuxedoInfo.getTgByColor7();
					String tgByColor8 = coOptionGiletTuxedoInfo.getTgByColor8();
					String tgByColor9 = coOptionGiletTuxedoInfo.getTgByColor9();
					String tgByColor10 = coOptionGiletTuxedoInfo.getTgByColor10();
					if (isEmpty(tgByColorPlace1) && isEmpty(tgByColorPlace2) && isEmpty(tgByColorPlace3)
							&& isEmpty(tgByColorPlace4) && isEmpty(tgByColorPlace5) && isEmpty(tgByColorPlace6)
							&& isEmpty(tgByColorPlace7) && isEmpty(tgByColorPlace8) && isEmpty(tgByColorPlace9)
							&& isEmpty(tgByColorPlace10)) {
						messages.add("E033", "GILET ボタン付け糸指定");
						giletFlag = true;
					}
					if(isNotEmpty(tgByColorPlace1)&&isEmpty(tgByColor1)||isNotEmpty(tgByColorPlace2)&&isEmpty(tgByColor2)||
					   isNotEmpty(tgByColorPlace3)&&isEmpty(tgByColor3)||isNotEmpty(tgByColorPlace4)&&isEmpty(tgByColor4)||
					   isNotEmpty(tgByColorPlace5)&&isEmpty(tgByColor5)||isNotEmpty(tgByColorPlace6)&&isEmpty(tgByColor6)||
					   isNotEmpty(tgByColorPlace7)&&isEmpty(tgByColor7)||isNotEmpty(tgByColorPlace8)&&isEmpty(tgByColor8)||
					   isNotEmpty(tgByColorPlace9)&&isEmpty(tgByColor9)||isNotEmpty(tgByColorPlace10)&&isEmpty(tgByColor10)) {
						messages.add("E033", "GILET ボタン付け糸指定");
						giletFlag = true;
					}
				}
			} else if ("9000103".equals(productCategory)) {
				// GILET モデル未選択の場合
				CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
				String wgGiletModel = coOptionGiletWashableInfo.getWgGiletModel();
				if ("".equals(wgGiletModel) || null == wgGiletModel) {
					messages.add("E031", "GILET モデル");
					giletFlag = true;
				}
				
				//ステッチ箇所変更
				String wgStitchModify = coOptionGiletWashableInfo.getWgStitchModify();
				if (OptionCodeKeys.GL_0000602.equals(wgStitchModify)) {
					String wgStitchModifyPlace1 = coOptionGiletWashableInfo.getWgStitchModifyPlace1();
					String wgStitchModifyPlace2 = coOptionGiletWashableInfo.getWgStitchModifyPlace2();
					String wgStitchModifyPlace3 = coOptionGiletWashableInfo.getWgStitchModifyPlace3();

					if (isEmpty(wgStitchModifyPlace1) && isEmpty(wgStitchModifyPlace2) && isEmpty(wgStitchModifyPlace3)) {
						messages.add("E033", "GILET ステッチ箇所変更");
						giletFlag = true;
					}
				}
				// ダブルステッチ
				String wgDStitchModify = coOptionGiletWashableInfo.getWgDStitchModify();
				if (OptionCodeKeys.GL_0002602.equals(wgDStitchModify)) {
					String wgDStitchModifyPlace1 = coOptionGiletWashableInfo.getWgDStitchModifyPlace1();
					String wgDStitchModifyPlace2 = coOptionGiletWashableInfo.getWgDStitchModifyPlace2();
					String wgDStitchModifyPlace3 = coOptionGiletWashableInfo.getWgDStitchModifyPlace3();

					if (isEmpty(wgDStitchModifyPlace1) && isEmpty(wgDStitchModifyPlace2) && isEmpty(wgDStitchModifyPlace3)) {
						messages.add("E033", "GILET ダブルステッチ");
						giletFlag = true;
					}
				}
				// AMF色指定
				String wgAmfColor = coOptionGiletWashableInfo.getWgAmfColor();
				if (OptionCodeKeys.GL_0000802.equals(wgAmfColor)) {
					String wgAmfColorPlace1 = coOptionGiletWashableInfo.getWgAmfColorPlace1();
					String wgAmfColorPlace2 = coOptionGiletWashableInfo.getWgAmfColorPlace2();
					String wgAmfColorPlace3 = coOptionGiletWashableInfo.getWgAmfColorPlace3();

					String wgAmfColor1 = coOptionGiletWashableInfo.getWgAmfColor1();
					String wgAmfColor2 = coOptionGiletWashableInfo.getWgAmfColor2();
					String wgAmfColor3 = coOptionGiletWashableInfo.getWgAmfColor3();
					if (isEmpty(wgAmfColorPlace1) && isEmpty(wgAmfColorPlace2) && isEmpty(wgAmfColorPlace3)) {
						messages.add("E033", "GILET AMF色指定");
						giletFlag = true;
					}
					if(isNotEmpty(wgAmfColorPlace1)&&isEmpty(wgAmfColor1)||isNotEmpty(wgAmfColorPlace2)&&isEmpty(wgAmfColor2)||
					   isNotEmpty(wgAmfColorPlace3)&&isEmpty(wgAmfColor3)) {
						messages.add("E033", "GILET AMF色指定");
						giletFlag = true;
					}
				}
				//ボタンホール色指定
				String wgBhColor = coOptionGiletWashableInfo.getWgBhColor();
				if (OptionCodeKeys.GL_0001102.equals(wgBhColor)) {
					String wgBhColorPlace1 = coOptionGiletWashableInfo.getWgBhColorPlace1();
					String wgBhColorPlace2 = coOptionGiletWashableInfo.getWgBhColorPlace2();
					String wgBhColorPlace3 = coOptionGiletWashableInfo.getWgBhColorPlace3();
					String wgBhColorPlace4 = coOptionGiletWashableInfo.getWgBhColorPlace4();
					String wgBhColorPlace5 = coOptionGiletWashableInfo.getWgBhColorPlace5();
					String wgBhColorPlace6 = coOptionGiletWashableInfo.getWgBhColorPlace6();

					String wgBhColor1 = coOptionGiletWashableInfo.getWgBhColor1();
					String wgBhColor2 = coOptionGiletWashableInfo.getWgBhColor2();
					String wgBhColor3 = coOptionGiletWashableInfo.getWgBhColor3();
					String wgBhColor4 = coOptionGiletWashableInfo.getWgBhColor4();
					String wgBhColor5 = coOptionGiletWashableInfo.getWgBhColor5();
					String wgBhColor6 = coOptionGiletWashableInfo.getWgBhColor6();
					
					if (isEmpty(wgBhColorPlace1) && isEmpty(wgBhColorPlace2) && isEmpty(wgBhColorPlace3)
							&& isEmpty(wgBhColorPlace4) && isEmpty(wgBhColorPlace5) && isEmpty(wgBhColorPlace6)) {
						messages.add("E033", "GILET ボタンホール色指定");
						giletFlag = true;
					}
					if(isNotEmpty(wgBhColorPlace1)&&isEmpty(wgBhColor1)||isNotEmpty(wgBhColorPlace2)&&isEmpty(wgBhColor2)||
					   isNotEmpty(wgBhColorPlace3)&&isEmpty(wgBhColor3)||isNotEmpty(wgBhColorPlace4)&&isEmpty(wgBhColor4)||
					   isNotEmpty(wgBhColorPlace5)&&isEmpty(wgBhColor5)||isNotEmpty(wgBhColorPlace6)&&isEmpty(wgBhColor6)) {
						messages.add("E033", "GILET ボタンホール色指定");
						giletFlag = true;
					}
				}
				// ボタン付け糸指定
				String wgByColor = coOptionGiletWashableInfo.getWgByColor();
				if (OptionCodeKeys.GL_0001402.equals(wgByColor)) {
					String wgByColorPlace1 = coOptionGiletWashableInfo.getWgByColorPlace1();
					String wgByColorPlace2 = coOptionGiletWashableInfo.getWgByColorPlace2();
					String wgByColorPlace3 = coOptionGiletWashableInfo.getWgByColorPlace3();
					String wgByColorPlace4 = coOptionGiletWashableInfo.getWgByColorPlace4();
					String wgByColorPlace5 = coOptionGiletWashableInfo.getWgByColorPlace5();
					String wgByColorPlace6 = coOptionGiletWashableInfo.getWgByColorPlace6();
					String wgByColorPlace7 = coOptionGiletWashableInfo.getWgByColorPlace7();
					String wgByColorPlace8 = coOptionGiletWashableInfo.getWgByColorPlace8();
					String wgByColorPlace9 = coOptionGiletWashableInfo.getWgByColorPlace9();
					String wgByColorPlace10 = coOptionGiletWashableInfo.getWgByColorPlace10();

					String wgByColor1 = coOptionGiletWashableInfo.getWgByColor1();
					String wgByColor2 = coOptionGiletWashableInfo.getWgByColor2();
					String wgByColor3 = coOptionGiletWashableInfo.getWgByColor3();
					String wgByColor4 = coOptionGiletWashableInfo.getWgByColor4();
					String wgByColor5 = coOptionGiletWashableInfo.getWgByColor5();
					String wgByColor6 = coOptionGiletWashableInfo.getWgByColor6();
					String wgByColor7 = coOptionGiletWashableInfo.getWgByColor7();
					String wgByColor8 = coOptionGiletWashableInfo.getWgByColor8();
					String wgByColor9 = coOptionGiletWashableInfo.getWgByColor9();
					String wgByColor10 = coOptionGiletWashableInfo.getWgByColor10();
					if (isEmpty(wgByColorPlace1) && isEmpty(wgByColorPlace2) && isEmpty(wgByColorPlace3)
							&& isEmpty(wgByColorPlace4) && isEmpty(wgByColorPlace5) && isEmpty(wgByColorPlace6)
							&& isEmpty(wgByColorPlace7) && isEmpty(wgByColorPlace8) && isEmpty(wgByColorPlace9)
							&& isEmpty(wgByColorPlace10)) {
						messages.add("E033", "GILET ボタン付け糸指定");
						giletFlag = true;
					}
					if(isNotEmpty(wgByColorPlace1)&&isEmpty(wgByColor1)||isNotEmpty(wgByColorPlace2)&&isEmpty(wgByColor2)||
					   isNotEmpty(wgByColorPlace3)&&isEmpty(wgByColor3)||isNotEmpty(wgByColorPlace4)&&isEmpty(wgByColor4)||
					   isNotEmpty(wgByColorPlace5)&&isEmpty(wgByColor5)||isNotEmpty(wgByColorPlace6)&&isEmpty(wgByColor6)||
					   isNotEmpty(wgByColorPlace7)&&isEmpty(wgByColor7)||isNotEmpty(wgByColorPlace8)&&isEmpty(wgByColor8)||
					   isNotEmpty(wgByColorPlace9)&&isEmpty(wgByColor9)||isNotEmpty(wgByColorPlace10)&&isEmpty(wgByColor10)) {
						messages.add("E033", "GILET ボタン付け糸指定");
						giletFlag = true;
					}
				}
			}

			// 補正
			CoAdjustGiletStandardInfo coAdjustGiletStandardInfo = orderCoForm.getCoAdjustGiletStandardInfo();
			if (coAdjustGiletStandardInfo == null) {
				messages.add("E031", "GILET サイズ");
				giletFlag = true;
			} else {
				String sizeFigure = coAdjustGiletStandardInfo.getSizeFigure();
				if ("".equals(sizeFigure) || null == sizeFigure) {
					messages.add("E031", "GILET サイズ体型");
					giletFlag = true;
				}
				String sizeNumber = coAdjustGiletStandardInfo.getSizeNumber();
				if ("".equals(sizeNumber) || null == sizeNumber) {
					messages.add("E031", "GILET サイズ号数");
					giletFlag = true;
				}
			}
		
			if (giletFlag) {
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm", orderCoForm);
				model.addAttribute("resultMessages", messages);
				return "forward:/orderCo/orderCoBack";
			}
		}
		
		
		
		//SHIRTチェック
		if ("05".equals(orderCoForm.getProductItem())) {

			ResultMessages messages = ResultMessages.error();
			boolean shirtFlag = false;
			
			String orderFlag = orderCoForm.getOrderFlag();
			String osClericSpec = "";
			String osDblCuff  = "";
			String osAddCuff  = "";
			
			if ("orderLink".equals(orderFlag)) {
				Order orderST = orderListService.findOrderStOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
//				//受注テーブルにレコードがある、レコード値を設定する
//				if (!(null == orderST || "".equals(orderST))) {
////					orderCoHelper.shirtDefaultValueFromDb(orderCoForm.getCoOptionShirtStandardInfo(), orderST);
////					osClericSpec = orderCoForm.getCoOptionShirtStandardInfo().getOsClericSpec();
////					osDblCuff = orderCoForm.getCoOptionShirtStandardInfo().getOsDblCuff();
////					osAddCuff = orderCoForm.getCoOptionShirtStandardInfo().getOsAddCuff();
//					
//					//SHIRTチェック
//					shirtFlag = shirtCheck(orderCoForm, messages);
//					
//					// 受注テーブルにレコードがなし、初期値を設定
//				} else if (null == orderST || "".equals(orderST)) {
//					
//					//SHIRTチェック
//					shirtFlag = shirtCheck(orderCoForm, messages);
//					
//					orderCoHelper.shirtDefaultValue(orderCoForm);
//				}
				
				//SHIRTチェック
				shirtFlag = shirtCheck(orderCoForm, messages);
				
				if (null == orderST || "".equals(orderST)) {
					orderCoHelper.shirtDefaultValue(orderCoForm);
				}
			} else {
				//SHIRTチェック
				shirtFlag = shirtCheck(orderCoForm, messages);
				
				osClericSpec = orderCoForm.getCoOptionShirtStandardInfo().getOsClericSpec();
				osDblCuff = orderCoForm.getCoOptionShirtStandardInfo().getOsDblCuff();
				osAddCuff = orderCoForm.getCoOptionShirtStandardInfo().getOsAddCuff();
				
				if ("".equals(osClericSpec) || "".equals(osDblCuff) || "".equals(osAddCuff) || null == osClericSpec
						|| null == osDblCuff || null == osAddCuff) {
					orderCoHelper.shirtDefaultValue(orderCoForm);
				}
			}
				
			if (shirtFlag) {
			orderCoForm.setOrderFlag("orderCheck");
			model.addAttribute("orderCoForm",orderCoForm);
			model.addAttribute("resultMessages",messages);
	        return "order/orderCoForm";
		}
		}
		//COATチェック
		if("06".equals(item)) {
			boolean coatFlag = false;
			ResultMessages messages = ResultMessages.error();
			String coatModel = orderCoForm.getCoOptionCoatStandardInfo().getCoatModel();
			if("".equals(coatModel) || coatModel == null) {
	            messages.add("E031", "COAT モデル");
	            coatFlag = true;
			}
			CoAdjustCoatStandardInfo coAdjustCoatStandardInfo = orderCoForm.getCoAdjustCoatStandardInfo();
			if(coAdjustCoatStandardInfo == null) {
	            messages.add("E031", "COATサイズ");
	            coatFlag = true;
			}else {
				String corCtSize = coAdjustCoatStandardInfo.getCorCtSize();
				if("".equals(corCtSize) || corCtSize == null) {
		            messages.add("E031", "COATサイズ");
		            coatFlag = true;
				}
			}
			if(coatFlag) {
				orderCoForm.setOrderFlag("orderCheck");
				model.addAttribute("orderCoForm",orderCoForm);
				model.addAttribute("resultMessages",messages);
		        return "order/orderCoForm";
			}
		}
		return "forward:/orderCoConfirm/orderCoReForm";
	}

	public boolean shirtCheck(OrderCoForm orderCoForm, ResultMessages messages) {
		
		boolean shirtFlag = false;
		
		//SHIRT モデル未選択の場合
		String osShirtModel = orderCoForm.getCoOptionShirtStandardInfo().getOsShirtModel();
		if ("".equals(osShirtModel)  || null == osShirtModel) {
	        messages.add("E031", "SHIRT モデル");
	        shirtFlag = true;
		}

		//襟型未選択の場合
		String osChainModel = orderCoForm.getCoOptionShirtStandardInfo().getOsChainModel();
		if ("0000100".equals(osChainModel)  || null == osChainModel || "".equals(osChainModel) ) {
	        messages.add("E031", "襟型");
	        shirtFlag = true;
		}

		//カフス未選択の場合
		String osCuffs = orderCoForm.getCoOptionShirtStandardInfo().getOsCuffs();
		if ("0000200".equals(osCuffs)  || null == osCuffs || "".equals(osCuffs) ) {
	        messages.add("E031", "カフス");
	        shirtFlag = true;
		}
		
		//ボタン位置変更未選択の場合
		String osBtnPosChg = orderCoForm.getCoOptionShirtStandardInfo().getOsBtnPosChg();
		BigDecimal stNeckbandBtnPosChg = orderCoForm.getCoOptionShirtStandardInfo().getStNeckbandBtnPosChg();
		BigDecimal stFrtfirstBtnPosChg = orderCoForm.getCoOptionShirtStandardInfo().getStFrtfirstBtnPosChg();
		BigDecimal stFrtsecondBtnPosChg = orderCoForm.getCoOptionShirtStandardInfo().getStFrtsecondBtnPosChg();
		
		if ("0002102".equals(osBtnPosChg) && (BigDecimal.ZERO.equals(stNeckbandBtnPosChg) || "".equals(stNeckbandBtnPosChg) || null == stNeckbandBtnPosChg)
				&& (BigDecimal.ZERO.equals(stFrtfirstBtnPosChg) || "".equals(stFrtfirstBtnPosChg) || null == stFrtfirstBtnPosChg)
				&& (BigDecimal.ZERO.equals(stFrtsecondBtnPosChg) || "".equals(stFrtsecondBtnPosChg) || null == stFrtsecondBtnPosChg)) {
			messages.add("E029", "ボタン位置変更値");
	        shirtFlag = true;
		}
		
		//カジュアルヘムライン値未選択の場合
		String osCasHemLine = orderCoForm.getCoOptionShirtStandardInfo().getOsCasHemLine();
		BigDecimal stCasualHemlineSize = orderCoForm.getCoOptionShirtStandardInfo().getStCasualHemlineSize();
		if ("0002002".equals(osCasHemLine) && ((BigDecimal.ZERO).equals(stCasualHemlineSize) || "".equals(stCasualHemlineSize) || null == stCasualHemlineSize)) {
	        messages.add("E029", "カジュアルヘムライン値");
	        shirtFlag = true;
		}
		
		//SHIRTサイズ
		CoAdjustShirtStandardInfo coAdjustShirtStandardInfo = orderCoForm.getCoAdjustShirtStandardInfo();
		if(coAdjustShirtStandardInfo == null) {
            messages.add("E031", "SHIRTサイズ");
            shirtFlag = true;
		}else {
			String corStSize = coAdjustShirtStandardInfo.getCorStSize();
			if("".equals(corStSize) || corStSize == null) {
	            messages.add("E031", "SHIRTサイズ");
	            shirtFlag = true;
			}
		}
		
		return shirtFlag;
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
	public String stockDecrease(OrderCoForm orderCoForm) {
		Order order = new Order();

		Measuring measuring = new Measuring();

		String orderIdImage = orderCoForm.getCoCustomerMessageInfo().getOrderId();
		
		String productFabricNo = orderCoForm.getProductFabricNo();
		
		if(isEmpty(productFabricNo)) {
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
			
//			String orderIdCheckCd = belongCode.concat(ONE);
//			String maxOrderId = orderService.selectMaxOrderId(orderIdCheckCd, PO_TYPE);
//			if (maxOrderId == null) {
//				orderId = belongCode.concat(MIN_CODE);
//			} else {
//				long parseLong = Long.parseLong(maxOrderId) + 1;
//				orderId = String.format("%012d", parseLong);
//			}

			// オーダーのデーター → orderCoForm
			orderCoFormToOrder(orderCoForm, order, measuring);

			order.setOrderId(orderId);

			measuring.setOrderId(orderId);

			String stockCheck = stockCheck(order, measuring);

			return stockCheck;
		} else {
			version = orderCoForm.getVersion();
			Order orderIsExist = orderListService.findOrderByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());

			Measuring measuringIsExist = measuringService
					.selectByPrimaryKey(orderCoForm.getCoCustomerMessageInfo().getOrderId());

			// オーダーのデーター → orderCoForm
			orderCoFormToOrder(orderCoForm, order, measuring, orderIsExist, measuringIsExist);

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
		
		if(isEmpty(productFabricNo)) {
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
			if ("1".equals(saveFlag)) {
				orderService.deletOrderWithNotVersion(order);
				orderService.deleteMeasuring(measuring);
			} else {
				orderService.deletOrderisExistence(order);
				orderService.deleteMeasuring(measuring);
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
		if ("0".equals(saveFlag)) {
			order.setTscStatus(orderCoForm.getStatus());
		}
		// 保存flag 1：自動保存
		// ステータスなし→「一時保存」、「一時保存」→「一時保存」、「取り置き」→「取り置き」
		else if ("1".equals(saveFlag)) {
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
		if ("0".equals(saveFlag)) {
			order.setTscStatus(orderCoForm.getStatus());
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
	 * @param orderCoForm
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
			BigDecimal theoretical = new BigDecimal(orderFindFabric.getTheoreticalStock());
			BigDecimal reservation = new BigDecimal(orderFindFabric.getReservationStock());
			BigDecimal result = theoretical.subtract(reservation);
			orderFindFabric.setStockResult(String.valueOf(result));
			
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
					if("0009902".equals(productIs3Piece)) {
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
					if("0009902".equals(productSparePantsClass)) {
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
					if("0009902".equals(productIs3Piece)) {
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
					if("0009902".equals(productSparePantsClass)) {
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
					
					if("0009902".equals(productIs3Piece)) {
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
					if("0009902".equals(productSparePantsClass)) {
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

	@RequestMapping(value = "/goToJacketOption", method = RequestMethod.GET)
	public @ResponseBody ModelAndView jacketStandardJsp(OrderCoForm orderCoForm, ModelAndView m) {
		String orderFlag = orderCoForm.getOrderFlag();
		String productItem = orderCoForm.getProductItem();
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = this.getItemModel(CO_TYPE, productItem,
				JACKET_SUBITEM);
		orderCoHelper.getJacketModelMap(orderCoForm, modelList);
		
		if("orderCo".equals(orderFlag)) {
			String itemFlag = orderCoForm.getJacketItemFlag();
			if ("0".equals(itemFlag)) {
				orderCoHelper.jacketDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {

			}
		}else if("orderLink".equals(orderFlag)||"orderDivert".equals(orderFlag)) {
			String itemFlag = orderCoForm.getJacketItemFlag();
			if ("0".equals(itemFlag)) {
				Order orderJK = orderListService.findOrderJkOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
				if(orderJK == null) {
//				//フロント釦数
//				String jkFrtBtnCd = orderJK.getJkFrtBtnCd();
//				//ラペルデザイン
//				String jkLapelDesignCd = orderJK.getJkLapelDesignCd();
//				//裏仕様 
//				String jkInnerClothCd = orderJK.getJkInnerClothCd();
//				if((jkFrtBtnCd == null||"".equals(jkFrtBtnCd))&&(jkLapelDesignCd == null||"".equals(jkLapelDesignCd))&&
//				   (jkInnerClothCd == null||"".equals(jkInnerClothCd))) {
					orderCoHelper.jacketDefaultValue(orderCoForm);
				}else {
					//orderCoHelper.jacketDefaultValueFromDb(orderCoForm,orderJK);
				}
			}else {
				
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
		if("orderCo".equals(orderFlag)) {
			String itemFlag = orderCoForm.getPantsItemFlag();
			if ("0".equals(itemFlag)) {
				orderCoHelper.pantsDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {
			}
			
		}else if("orderLink".equals(orderFlag)) {
			String itemFlag = orderCoForm.getPantsItemFlag();
			if ("0".equals(itemFlag)) {
				Order orderPt = orderListService.findOrderPtOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
				//タック
				String ptTackCd = orderPt.getPtTackCd();
				//膝裏
				String ptKneeinnerTypeCd = orderPt.getPtKneeinnerTypeCd();
				//フロント仕様
				String ptFrtTypeCd = orderPt.getPtFrtTypeCd();
				if((ptTackCd == null||"".equals(ptTackCd))&&(ptKneeinnerTypeCd == null||"".equals(ptKneeinnerTypeCd))&&
				   (ptFrtTypeCd == null||"".equals(ptFrtTypeCd))) {
					orderCoHelper.pantsDefaultValue(orderCoForm);
				}else {
					orderCoHelper.pantsDefaultValueFromDb(orderCoForm,orderPt);
				}
			}else {
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
			
		}else if("orderLink".equals(orderFlag)) {
			String itemFlag = orderCoForm.getPants2ItemFlag();
			if ("0".equals(itemFlag)) {
				Order orderPt2 = orderListService.findOrderPt2OptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
				//タック
				String pt2TackCd = orderPt2.getPt2TackCd();
				//膝裏
				String pt2KneeinnerTypeCd = orderPt2.getPt2KneeinnerTypeCd();
				//フロント仕様
				String pt2FrtTypeCd = orderPt2.getPt2FrtTypeCd();
				if((pt2TackCd == null||"".equals(pt2TackCd))&&(pt2KneeinnerTypeCd == null||"".equals(pt2KneeinnerTypeCd))&&
				   (pt2FrtTypeCd == null||"".equals(pt2FrtTypeCd))) {
					orderCoHelper.pants2DefaultValue(orderCoForm);
				}else {
					orderCoHelper.pants2DefaultValueFromDb(orderCoForm,orderPt2);
				}
			}else {
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
		orderCoHelper.getGiletModelMap(orderCoForm, modelList);

		if("orderCo".equals(orderFlag)) {
			String itemFlag = orderCoForm.getGiletItemFlag();
			if ("0".equals(itemFlag)) {
				orderCoHelper.giletDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {

			}
		}else if("orderLink".equals(orderFlag)) {
			String itemFlag = orderCoForm.getGiletItemFlag();
			if ("0".equals(itemFlag)) {
				Order orderGl = orderListService.findOrderGlOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
//				//フロント釦数
//				String glFrtBtnCd = orderGl.getGlFrtBtnCd();
//				//ラペルデザイン
//				String glLapelDesignCd = orderGl.getGlLapelDesignCd();
//				//裏仕様
//				String glInnerClothCd = orderGl.getGlInnerClothCd();
//				if((glFrtBtnCd == null||"".equals(glFrtBtnCd))&&(glLapelDesignCd == null||"".equals(glLapelDesignCd))&&
//				   (glInnerClothCd == null||"".equals(glInnerClothCd))) {
				if(orderGl != null) {
					orderCoHelper.giletDefaultValue(orderCoForm);
				}else {
					orderCoHelper.giletDefaultValueFromDb(orderCoForm,orderGl);
				}
			}else {
				
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
		orderCoHelper.getShirtModelMap(orderCoForm, modelList);
		if("orderCo".equals(orderFlag)) {
			if ("0".equals(itemFlag)) {
				orderCoHelper.shirtDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {

			}
		} else if("orderLink".equals(orderFlag)) {
//			if ("0".equals(itemFlag)) {
//				Order orderST = orderListService.findOrderStOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
//				if (!(null == orderST || "".equals(orderST))) {
////					//クレリック仕様
////					String stClericCd = orderST.getStClericCd();
////					//ダブルカフス仕様
////					String stDblCuffsCd = orderST.getStDblCuffsCd();
////					//カフスボタン追加
////					String stCuffsBtnCd = orderST.getStCuffsBtnCd();
////					
////					if ((stClericCd == null || "".equals(stClericCd))
////							&& (stDblCuffsCd == null || "".equals(stDblCuffsCd))
////							&& (stCuffsBtnCd == null || "".equals(stCuffsBtnCd))) {
////						orderCoHelper.shirtDefaultValue(orderCoForm);
////					} else {
//					orderCoHelper.shirtDefaultValueFromDb(orderCoForm.getCoOptionShirtStandardInfo(), orderST);
////					}
//				} else {
//					orderCoHelper.shirtDefaultValue(orderCoForm);
//				}
//			}else {
//				
//			}
			
			Order orderST = orderListService.findOrderStOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			//一覧画面から注文画面へ遷移
			//受注テーブルにレコードがある、一回目オプション画面をクリック場合、レコード値を設定する
			if (!(null == orderST || "".equals(orderST)) && ("".equals(itemFlag) || "0".equals(itemFlag))) {
				//orderCoHelper.shirtDefaultValueFromDb(orderCoForm.getCoOptionShirtStandardInfo(), orderST);
				
			//受注テーブルにレコードがなし、初期値を設定
			} else if (null == orderST || "".equals(orderST)) {
				orderCoHelper.shirtDefaultValue(orderCoForm);
			}
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
				orderCoHelper.coatDefaultValue(orderCoForm);
			} else if ("1".equals(itemFlag)) {

			}
		}else if("orderLink".equals(orderFlag)) {
			String itemFlag = orderCoForm.getCoatItemFlag();
			if ("0".equals(itemFlag)) {
				Order orderCt = orderListService.findOrderCtOptionByOrderId(orderCoForm.getCoCustomerMessageInfo().getOrderId());
				//ベント
				String ctVentCd = orderCt.getCtVentCd();
				//ラペルデザイン
				String ctLapelDesignCd = orderCt.getCtLapelDesignCd();
				//袖仕様
				String ctSleeveTypeCd = orderCt.getCtSleeveTypeCd();
				if((ctVentCd == null || "".equals(ctVentCd)) && (ctLapelDesignCd == null || "".equals(ctLapelDesignCd)) &&
				   (ctSleeveTypeCd == null || "".equals(ctSleeveTypeCd))) {
					orderCoHelper.coatDefaultValue(orderCoForm);
				}else {
					orderCoHelper.coatDefaultValueFromDb(orderCoForm,orderCt);
				}
			}else {
				
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
		List<TypeSizeOptimization> poTypeSizeOptimization = orderCoHelper.getCoTypeSizeOptimization(coTypeSizeList);
		return poTypeSizeOptimization;
	}

	@RequestMapping(value = "/jacketJsp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView jacketJsp(OrderCoForm orderCoForm, ModelAndView m) {
		
		String orderFlag = orderCoForm.getOrderFlag();
		if("orderLink".equals(orderFlag)) {	
			Order orderJK = orderListService.findOrderJkByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			if (!(null == orderJK || "".equals(orderJK))) {
				orderCoHelper.jacketAdjustFromDb(orderCoForm,orderJK);
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
			if (!(null == orderPT || "".equals(orderPT))) {
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
			if (!(null == orderPT2 || "".equals(orderPT2))) {
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
			if (!(null == orderGL || "".equals(orderGL))) {
				orderCoHelper.giletAdjustFromDb(orderCoForm, orderGL);
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
			if (!(null == orderST || "".equals(orderST))) {
				orderCoHelper.shirtAdjustFromDb(orderCoForm, orderST);
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
			if (!(null == orderCT || "".equals(orderCT))) {
				orderCoHelper.coatAdjustFromDb(orderCoForm, orderCT);
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
		orderCoHelper.jacketAdjustFromDb(orderCoForm,order);
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
		orderCoHelper.giletAdjustFromDb(orderCoForm,order);
	}

	@RequestMapping(value = "/shirtAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void shirtAdjustFormDb(OrderCoForm orderCoForm) {
		Order order = orderListService.findOrderStByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
		orderCoHelper.shirtAdjustFromDb(orderCoForm,order);
	}

	@RequestMapping(value = "/coatAdjustFormDb", method = RequestMethod.GET)
	@ResponseBody
	public void coatAdjustFormDb(OrderCoForm orderCoForm) {
		Order order = orderListService.findOrderCtByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
		orderCoHelper.coatAdjustFromDb(orderCoForm,order);
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
			if(isEmpty(productCode)) {
				String osShirtModel = orderCoForm.getCoOptionShirtStandardInfo().getOsShirtModel();
				if(isNotEmpty(osShirtModel)) {
					if(isNotEmpty(valueTwo)) {
						if(valueTwo.equals(valueName)) {
							proCode = "05".concat("05").concat(osShirtModel).concat(key).concat(valueCode);
							resultPrice = getOrderPrice(proCode,orderCoForm);
						}
					}
				}else {
					resultPrice = "0";
				}
			}else {
				if(isNotEmpty(valueTwo)) {
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
	public Map<String, Object> getOrderPriceForJacketModel(OrderCoForm orderCoForm, String code) {
		CoOptionJacketStandardInfo optionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
		
		JacketOptionCoStandardPriceEnum[] priceEnum = JacketOptionCoStandardPriceEnum.values();
		
		String ojFrontBtnCnt = optionJacketStandardInfo.getOjFrontBtnCnt();
		
		for (JacketOptionCoStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = optionJacketStandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(optionJacketStandardInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = optionJacketStandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(optionJacketStandardInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				
				if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
					orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}else{
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketStandardInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketStandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (JacketOptionCoStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = optionJacketStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(optionJacketStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForJacketTuxedoModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForJacketTuxedoModel(OrderCoForm orderCoForm, String code, Model model) {
		CoOptionJacketTuxedoInfo optionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
		
		JacketOptionCoTuxedoPriceEnum[] priceEnum = JacketOptionCoTuxedoPriceEnum.values();
		
		String tjFrontBtnCnt = optionJacketTuxedoInfo.getTjFrontBtnCnt();
		
		for (JacketOptionCoTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = optionJacketTuxedoInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(optionJacketTuxedoInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = optionJacketTuxedoInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(optionJacketTuxedoInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
					orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}else{
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketTuxedoInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketTuxedoInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (JacketOptionCoTuxedoPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = optionJacketTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(optionJacketTuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForJacketWashableModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForJacketWashableModel(OrderCoForm orderCoForm, String code, Model model) {
		CoOptionJacketWashableInfo optionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
		
		JacketOptionCoWashablePriceEnum[] priceEnum = JacketOptionCoWashablePriceEnum.values();
		
		String wjFrontBtnCnt = optionJacketWashableInfo.getWjFrontBtnCnt();
		
		for (JacketOptionCoWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = optionJacketWashableInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(optionJacketWashableInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = optionJacketWashableInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(optionJacketWashableInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
					orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}else{
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketWashableInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketWashableInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (JacketOptionCoWashablePriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = optionJacketWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(optionJacketWashableInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
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
		CoOptionJacketStandardInfo coOptionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
		String ojFrontBtnCnt = coOptionJacketStandardInfo.getOjFrontBtnCnt();
		JacketOptionCoStandardPriceEnum[] priceEnum = JacketOptionCoStandardPriceEnum.values();
		String orderPrice = "";
		for (JacketOptionCoStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			boolean hasIdvalueName = false;
			try {
				if (idValueName.equals(valueFour)) {
					Method methodOne = coOptionJacketStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketStandardInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionJacketStandardInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionJacketStandardInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionJacketStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketStandardInfo);
					Method methodTwo = coOptionJacketStandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionJacketStandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				if(("stitchModify_id".equals(idValueName) && "stitchModify_id".equals(valueFour))|| ("dStitchModify_id".equals(idValueName) &&"dStitchModify_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split(",");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("amfColor_id".equals(idValueName)&&"amfColor_id".equals(valueFour))||
					("bhColor_id".equals(idValueName)&&"bhColor_id".equals(valueFour))||
					("byColor_id".equals(idValueName))&&"byColor_id".equals(valueFour)) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
					Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
					orderPrice = String.valueOf(colorPrice);
				}

				if (hasIdvalueName == true) {
					if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketStandardInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketStandardInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (JacketOptionCoStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionJacketStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionJacketStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf)) && valueOf!=null && !"null".equals(valueOf)) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		 
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
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
	public Map<String, String> getOrderPriceForJacketTuxedoProject(OrderCoForm orderCoForm, String code, Model model,
			String idValueName, String colorCount,String thisVal,String thisValStkNo) {
		CoOptionJacketTuxedoInfo coOptionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
		String tjFrontBtnCnt = coOptionJacketTuxedoInfo.getTjFrontBtnCnt();
		JacketOptionCoTuxedoPriceEnum[] priceEnum = JacketOptionCoTuxedoPriceEnum.values();
		String orderPrice = "";
		for (JacketOptionCoTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			boolean hasIdvalueName = false;
			try {
				if (idValueName.equals(valueFour)) {
					Method methodOne = coOptionJacketTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketTuxedoInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionJacketTuxedoInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionJacketTuxedoInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionJacketTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketTuxedoInfo);
					Method methodTwo = coOptionJacketTuxedoInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionJacketTuxedoInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}

				if (hasIdvalueName == true) {
					if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
						orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}else{
						orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketTuxedoInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketTuxedoInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (JacketOptionCoTuxedoPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionJacketTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionJacketTuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf)) && valueOf!=null && !"null".equals(valueOf)) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		 
		if("tj_bhColor_id".equals(idValueName)||"tj_byColor_id".equals(idValueName)) {
			Integer colorPrice = 0;
			for (int i = 0; i < Integer.valueOf(colorCount); i++) {
				colorPrice = colorPrice + 100;
			}
			orderPrice = String.valueOf(colorPrice);
		}
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
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
	@RequestMapping(value = "/getOrderPriceForJacketWashableProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForJacketWashableProject(OrderCoForm orderCoForm, String code, Model model,
			String idValueName, String colorCount,String thisVal,String thisValStkNo) {
		CoOptionJacketWashableInfo coOptionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
		String wjFrontBtnCnt = coOptionJacketWashableInfo.getWjFrontBtnCnt();
		JacketOptionCoWashablePriceEnum[] priceEnum = JacketOptionCoWashablePriceEnum.values();
		String orderPrice = "";
		for (JacketOptionCoWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			boolean hasIdvalueName = false;
			try {
				if (idValueName.equals(valueFour)) {
					Method methodOne = coOptionJacketWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketWashableInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionJacketWashableInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionJacketWashableInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionJacketWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketWashableInfo);
					Method methodTwo = coOptionJacketWashableInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionJacketWashableInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}

				if (hasIdvalueName == true) {
					if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
						orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}else{
						orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketWashableInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketWashableInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (JacketOptionCoWashablePriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionJacketWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionJacketWashableInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf)) && valueOf!=null && !"null".equals(valueOf)) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		 
		if("wj_bhColor_id".equals(idValueName)||"wj_byColor_id".equals(idValueName)||"wj_amfColor_id".equals(idValueName)) {
			Integer colorPrice = 0;
			for (int i = 0; i < Integer.valueOf(colorCount); i++) {
				colorPrice = colorPrice + 100;
			}
			orderPrice = String.valueOf(colorPrice);
		}
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;

	}
	
	@RequestMapping(value = "/getOrderPriceForGiletStandardModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForGiletStandardModel(OrderCoForm orderCoForm, String code) {
		CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
		
		GiletOptionCoStandardPriceEnum[] priceEnum = GiletOptionCoStandardPriceEnum.values();
		for (GiletOptionCoStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = coOptionGiletStandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionGiletStandardInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionGiletStandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionGiletStandardInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				String orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletStandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (GiletOptionCoStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletTuxedoModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForGiletTuxedoModel(OrderCoForm orderCoForm, String code, Model model) {
		CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
		
		GiletOptionCoTuxedoPriceEnum[] priceEnum = GiletOptionCoTuxedoPriceEnum.values();
		for (GiletOptionCoTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = coOptionGiletTuxedoInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionGiletTuxedoInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionGiletTuxedoInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionGiletTuxedoInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				String orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletTuxedoInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (GiletOptionCoTuxedoPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletTuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletWashableModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForGiletWashableModel(OrderCoForm orderCoForm, String code, Model model) {
		CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
		
		GiletOptionCoWashablePriceEnum[] priceEnum = GiletOptionCoWashablePriceEnum.values();
		for (GiletOptionCoWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = coOptionGiletWashableInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionGiletWashableInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionGiletWashableInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionGiletWashableInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				String orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletWashableInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (GiletOptionCoWashablePriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletWashableInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletStandardProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForGiletStandardProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
		
		GiletOptionCoStandardPriceEnum[] priceEnum = GiletOptionCoStandardPriceEnum.values();
		String orderPrice = "";
		for (GiletOptionCoStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			
			boolean hasIdvalueName = false;
			try {
				if("og_waistPkt_id".equals(idValueName)) {
					try {
						Class<?> cls;
						Object[] args = {"0"};
						cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo");
						Method methodThree = getMethod(cls, "setGlWaistPktShapeRtPrice");
						ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletStandardInfo(), args);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				
				if("og_amfColor_id".equals(idValueName) || "og_bhColor_id".equals(idValueName) || "og_byColor_id".equals(idValueName)) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
					Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
					orderPrice = String.valueOf(colorPrice);
				}
				
				if("og_stitchModify_id".equals(idValueName) || "og_dStitchModify_id".equals(idValueName)) {
					Integer orderPriceInt = 0;
					String[] strArr = countArr.split(",");
					for (int i = 0; i < strArr.length; i++) {
						String projectPriceCode = code + strArr[i];
						String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
						orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
					}
					orderPrice = String.valueOf(orderPriceInt);
				}
				
				if(idValueName.equals(valueFour)) {
					Method methodOne = coOptionGiletStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletStandardInfo);
					Object invokeTwo = null;
					if(!("".equals(valueTwo))) {
						Method methodTwo = coOptionGiletStandardInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionGiletStandardInfo);
					}
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					if(invokeTwo != null) {
						splicingCodeDetail = code + key + invokeOne + invokeTwo;
					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionGiletStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletStandardInfo);
					Method methodTwo = coOptionGiletStandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionGiletStandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				
				if((idValueName.equals(valueFour) || idValueName.equals(valueFive)) 
						&& ("og_backLiningMate".equals(idValueName) || "og_backLiningMateStkNo".equals(idValueName) 
						|| "og_insideLiningMate".equals(idValueName) || "og_insideLiningMateStkNo".equals(idValueName) 
						|| "og_frontBtnMate".equals(idValueName) || "og_frontBtnMateStkNo".equals(idValueName) 
						|| "og_backBelt".equals(idValueName))) {
					hasIdvalueName = true;
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				}
				
				if(hasIdvalueName == true) {
					if("".equals(orderPrice)) {
						orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletStandardInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (GiletOptionCoStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf))) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletTuxedoProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForGiletTuxedoProject(OrderCoForm orderCoForm, String code, Model model, 
			String idValueName, String colorCount) {
		CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
		
		GiletOptionCoTuxedoPriceEnum[] priceEnum = GiletOptionCoTuxedoPriceEnum.values();
		String orderPrice = "";
		for (GiletOptionCoTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			
			boolean hasIdvalueName = false;
			try {
				if(idValueName.equals(valueFour)) {
					Method methodOne = coOptionGiletTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletTuxedoInfo);
					Object invokeTwo = null;
					if(!("".equals(valueTwo))) {
						Method methodTwo = coOptionGiletTuxedoInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionGiletTuxedoInfo);
					}
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					if(invokeTwo != null) {
						splicingCodeDetail = code + key + invokeOne + invokeTwo;
					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionGiletTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletTuxedoInfo);
					Method methodTwo = coOptionGiletTuxedoInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionGiletTuxedoInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				
				if(hasIdvalueName == true) {
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletTuxedoInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		if("tg_waistPkt_id".equals(idValueName)) {
			try {
				Class<?> cls;
				Object[] args = {"0"};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo");
				Method methodThree = getMethod(cls, "setGlWaistPktShapeRtPrice");
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletTuxedoInfo(), args);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (GiletOptionCoTuxedoPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletTuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf))) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		if("tg_bhColor_id".equals(idValueName) || "tg_byColor_id".equals(idValueName)) {
			Integer colorPrice = 0;
			for (int i = 0; i < Integer.valueOf(colorCount); i++) {
				colorPrice = colorPrice + 100;
			}
			orderPrice = String.valueOf(colorPrice);
		}
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForGiletWashableProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForGiletWashableProject(OrderCoForm orderCoForm, String code, Model model, 
			String idValueName, String colorCount) {
		CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
		
		GiletOptionCoWashablePriceEnum[] priceEnum = GiletOptionCoWashablePriceEnum.values();
		String orderPrice = "";
		for (GiletOptionCoWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			
			boolean hasIdvalueName = false;
			try {
				if(idValueName.equals(valueFour)) {
					Method methodOne = coOptionGiletWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletWashableInfo);
					Object invokeTwo = null;
					if(!("".equals(valueTwo))) {
						Method methodTwo = coOptionGiletWashableInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionGiletWashableInfo);
					}
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					if(invokeTwo != null) {
						splicingCodeDetail = code + key + invokeOne + invokeTwo;
					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionGiletWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletWashableInfo);
					Method methodTwo = coOptionGiletWashableInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionGiletWashableInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				
				if(hasIdvalueName == true) {
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletWashableInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		if("wg_waistPkt_id".equals(idValueName)) {
			try {
				Class<?> cls;
				Object[] args = {"0"};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo");
				Method methodThree = getMethod(cls, "setGlWaistPktShapeRtPrice");
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletWashableInfo(), args);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (GiletOptionCoWashablePriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletWashableInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf))) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		if("wg_amfColor_id".equals(idValueName) || "wg_bhColor_id".equals(idValueName) || "wg_byColor_id".equals(idValueName)) {
			Integer colorPrice = 0;
			for (int i = 0; i < Integer.valueOf(colorCount); i++) {
				colorPrice = colorPrice + 100;
			}
			orderPrice = String.valueOf(colorPrice);
		}
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForShirtModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForShirtModel(OrderCoForm orderCoForm, String code) {
		CoOptionShirtStandardInfo optionShirtStandardInfo = orderCoForm.getCoOptionShirtStandardInfo();
		
		ShirtCoOptionStandardPriceEnum[] priceEnum = ShirtCoOptionStandardPriceEnum.values();
		for (ShirtCoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = optionShirtStandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(optionShirtStandardInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = optionShirtStandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(optionShirtStandardInfo);
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne + invokeTwo;
				String orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionShirtStandardInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionShirtStandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (ShirtCoOptionStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = optionShirtStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(optionShirtStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForShirtProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForShirtProject(OrderCoForm orderCoForm, String code, Model model, 
			String idValueName, String colorCount,String thisVal) {
		CoOptionShirtStandardInfo optionShirtStandardInfo = orderCoForm.getCoOptionShirtStandardInfo();
		
		ShirtCoOptionStandardPriceEnum[] priceEnum = ShirtCoOptionStandardPriceEnum.values();
		String orderPrice = "";
		for (ShirtCoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			
			boolean hasIdvalueName = false;
			try {
				if(idValueName.equals(valueFour)) {
//					Method methodOne = optionShirtStandardInfo.getClass().getMethod(valueOne);
//					Object invokeOne = methodOne.invoke(optionShirtStandardInfo);
//					Object invokeTwo = null;
//					if(!("".equals(valueTwo))) {
//						Method methodTwo = optionShirtStandardInfo.getClass().getMethod(valueTwo);
//						invokeTwo = methodTwo.invoke(optionShirtStandardInfo);
//					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
//					if(invokeTwo != null) {
//						splicingCodeDetail = code + key + thisVal + invokeTwo;
//					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = optionShirtStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(optionShirtStandardInfo);
					Method methodTwo = optionShirtStandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(optionShirtStandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				
				if(hasIdvalueName == true) {
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					if("0".equals(orderPrice)) {
						//orderPrice = "無料";
					}
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionShirtStandardInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionShirtStandardInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (ShirtCoOptionStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = optionShirtStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(optionShirtStandardInfo);
				String valueOf = String.valueOf(invokeSix);
//				if(!("0".equals(valueOf))) {
				if(!("0".equals(valueOf) || "null".equals(valueOf))) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
//		if("og_amfColor_id".equals(idValueName)) {
//			Integer colorPrice = 0;
//			for (int i = 0; i < Integer.valueOf(colorCount); i++) {
//				colorPrice = colorPrice + 100;
//			}
//			orderPrice = String.valueOf(colorPrice);
//		}
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2Model", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPants2Model(OrderCoForm orderCoForm, String code, Model model) {
		CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
		
		Pants2CoOptionStandardPriceEnum[] priceEnum = Pants2CoOptionStandardPriceEnum.values();
		for (Pants2CoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = coOptionPants2StandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPants2StandardInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPants2StandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPants2StandardInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				String orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2StandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (Pants2CoOptionStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2StandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2StandardInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2tModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPants2tModel(OrderCoForm orderCoForm, String code, Model model) {
		CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
		
		Pants2CoOptionTuxedoPriceEnum[] priceEnum = Pants2CoOptionTuxedoPriceEnum.values();
		for (Pants2CoOptionTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = coOptionPants2TuxedoInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPants2TuxedoInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPants2TuxedoInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPants2TuxedoInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				String orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2TuxedoInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (Pants2CoOptionTuxedoPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2TuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2TuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2wModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPants2wModel(OrderCoForm orderCoForm, String code, Model model) {
		CoOptionPants2WashableInfo coOptionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
		
		Pants2CoOptionWashablePriceEnum[] priceEnum = Pants2CoOptionWashablePriceEnum.values();
		for (Pants2CoOptionWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = coOptionPants2WashableInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPants2WashableInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPants2WashableInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPants2WashableInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				String orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2WashableInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (Pants2CoOptionWashablePriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2WashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2WashableInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2Project", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPants2Project(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
		
		Pants2CoOptionStandardPriceEnum[] priceEnum = Pants2CoOptionStandardPriceEnum.values();
		String orderPrice = "";
		for (Pants2CoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			
			boolean hasIdvalueName = false;
			try {
				if(idValueName.equals(valueFour)) {
					Method methodOne = coOptionPants2StandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPants2StandardInfo);
					Object invokeTwo = null;
					if(!("".equals(valueTwo))) {
						Method methodTwo = coOptionPants2StandardInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPants2StandardInfo);
					}
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					if(invokeTwo != null) {
						splicingCodeDetail = code + key + invokeOne + invokeTwo;
					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionPants2StandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPants2StandardInfo);
					Method methodTwo = coOptionPants2StandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPants2StandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				if(("op2_stitchModify_id".equals(idValueName) && "op2_stitchModify_id".equals(valueFour))|| ("op2_dStitch_id".equals(idValueName) &&"op2_dStitch_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split(",");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("op2_amfColor_id".equals(idValueName)&&"op2_amfColor_id".equals(valueFour))||
					("op2_bhColor_id".equals(idValueName)&&"op2_bhColor_id".equals(valueFour))||
					("op2_byColor_id".equals(idValueName))&&"op2_byColor_id".equals(valueFour)) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
					Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
					orderPrice = String.valueOf(colorPrice);
				}
				
				if(hasIdvalueName == true) {
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					if("0".equals(orderPrice)) {
						//orderPrice = "無料";
					}
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2StandardInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (Pants2CoOptionStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2StandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2StandardInfo);
				String valueOf = String.valueOf(invokeSix);
//				if(!("0".equals(valueOf))) {
				if(!("0".equals(valueOf) || "null".equals(valueOf))) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
//		if("og_amfColor_id".equals(idValueName)) {
//			Integer colorPrice = 0;
//			for (int i = 0; i < Integer.valueOf(colorCount); i++) {
//				colorPrice = colorPrice + 100;
//			}
//			orderPrice = String.valueOf(colorPrice);
//		}
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
	}
	
	@RequestMapping(value = "/getOrderPriceForPants2tProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPants2tProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
		
		Pants2CoOptionTuxedoPriceEnum[] priceEnum = Pants2CoOptionTuxedoPriceEnum.values();
		String orderPrice = "";
		for (Pants2CoOptionTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			
			boolean hasIdvalueName = false;
			try {
				if(idValueName.equals(valueFour)) {
					Method methodOne = coOptionPants2TuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPants2TuxedoInfo);
					Object invokeTwo = null;
					if(!("".equals(valueTwo))) {
						Method methodTwo = coOptionPants2TuxedoInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPants2TuxedoInfo);
					}
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					if(invokeTwo != null) {
						splicingCodeDetail = code + key + invokeOne + invokeTwo;
					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionPants2TuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPants2TuxedoInfo);
					Method methodTwo = coOptionPants2TuxedoInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPants2TuxedoInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				if(("tp2_stitchModify_id".equals(idValueName) && "tp2_stitchModify_id".equals(valueFour))|| ("tp2_dStitch_id".equals(idValueName) &&"tp2_dStitch_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split(",");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("tp2_amfColor_id".equals(idValueName)&&"tp2_amfColor_id".equals(valueFour))||
					("tp2_bhColor_id".equals(idValueName)&&"tp2_bhColor_id".equals(valueFour))||
					("tp2_byColor_id".equals(idValueName))&&"tp2_byColor_id".equals(valueFour)) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
					Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
					orderPrice = String.valueOf(colorPrice);
				}
				if(hasIdvalueName == true) {
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					if("0".equals(orderPrice)) {
						//orderPrice = "無料";
					}
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2TuxedoInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (Pants2CoOptionTuxedoPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2TuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2TuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
//				if(!("0".equals(valueOf))) {
				if(!("0".equals(valueOf) || "null".equals(valueOf))) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
//		if("og_amfColor_id".equals(idValueName)) {
//			Integer colorPrice = 0;
//			for (int i = 0; i < Integer.valueOf(colorCount); i++) {
//				colorPrice = colorPrice + 100;
//			}
//			orderPrice = String.valueOf(colorPrice);
//		}
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
	}

	@RequestMapping(value = "/getOrderPriceForPants2wProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPants2wProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionPants2WashableInfo coOptionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
		
		Pants2CoOptionWashablePriceEnum[] priceEnum = Pants2CoOptionWashablePriceEnum.values();
		String orderPrice = "";
		for (Pants2CoOptionWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			
			boolean hasIdvalueName = false;
			try {
				if(idValueName.equals(valueFour)) {
					Method methodOne = coOptionPants2WashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPants2WashableInfo);
					Object invokeTwo = null;
					if(!("".equals(valueTwo))) {
						Method methodTwo = coOptionPants2WashableInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPants2WashableInfo);
					}
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					if(invokeTwo != null) {
						splicingCodeDetail = code + key + invokeOne + invokeTwo;
					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionPants2WashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPants2WashableInfo);
					Method methodTwo = coOptionPants2WashableInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPants2WashableInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				if(("wp2_stitchModify_id".equals(idValueName) && "wp2_stitchModify_id".equals(valueFour))|| ("wp2_dStitch_id".equals(idValueName) &&"wp2_dStitch_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split(",");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("wp2_amfColor_id".equals(idValueName)&&"wp2_amfColor_id".equals(valueFour))||
					("wp2_bhColor_id".equals(idValueName)&&"wp2_bhColor_id".equals(valueFour))||
					("wp2_byColor_id".equals(idValueName))&&"wp2_byColor_id".equals(valueFour)) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
					Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
					orderPrice = String.valueOf(colorPrice);
				}
				
				if(hasIdvalueName == true) {
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					if("0".equals(orderPrice)) {
						//orderPrice = "無料";
					}
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2WashableInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (Pants2CoOptionWashablePriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2WashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2WashableInfo);
				String valueOf = String.valueOf(invokeSix);
//				if(!("0".equals(valueOf))) {
				if(!("0".equals(valueOf) || "null".equals(valueOf))) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
//		if("og_amfColor_id".equals(idValueName)) {
//			Integer colorPrice = 0;
//			for (int i = 0; i < Integer.valueOf(colorCount); i++) {
//				colorPrice = colorPrice + 100;
//			}
//			orderPrice = String.valueOf(colorPrice);
//		}
		
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
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
		// orderHelper.coatDefaultValue(orderCoForm);
		// String ogBackLiningMateStkNo =
		// orderCoForm.getCoOptionGiletStandardInfo().getOgBackLiningMateStkNo();
		String coatModel = orderCoForm.getCoOptionCoatStandardInfo().getCoatModel();
		CoOptionCoatStandardInfo coOptionCoatStandardInfo = orderCoForm.getCoOptionCoatStandardInfo();
		CoatCoOptionStandardPriceEnum[] priceEnum = CoatCoOptionStandardPriceEnum.values();
		for (CoatCoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionCoatStandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionCoatStandardInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionCoatStandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionCoatStandardInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				//orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				if("DoubleChester".equals(coatModel) || "DoublePolo".equals(coatModel)) {
					orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}else if("SingleChester".equals(coatModel) || "SoutienCollar".equals(coatModel)) {
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionCoatStandardInfo");
				Method methodThree = getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionCoatStandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (CoatCoOptionStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();

			try {
				Method methodSix = coOptionCoatStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionCoatStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				optionPriceInt = optionPriceInt + Integer.parseInt(valueOf);
				if("0".equals(valueOf)) {
		            priceMap.put(valueFour, "無料");
		         }else {
		            priceMap.put(valueFour, "￥" + formatPrice(valueOf));
		         }

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", optionPriceInt);
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
		String coatModel = orderCoForm.getCoOptionCoatStandardInfo().getCoatModel();
		CoOptionCoatStandardInfo coOptionCoatStandardInfo = orderCoForm.getCoOptionCoatStandardInfo();
		CoatCoOptionStandardPriceEnum[] priceEnum = CoatCoOptionStandardPriceEnum.values();
		String orderPrice = "";
		for (CoatCoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			boolean hasIdvalueName = false;
			try {
				if (idValue.equals(valueFour)) {
					Method methodOne = coOptionCoatStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionCoatStandardInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
//					if (!("".equals(valueTwo))) {
//						Method methodTwo = coOptionCoatStandardInfo.getClass().getMethod(valueTwo);
//						invokeTwo = methodTwo.invoke(coOptionCoatStandardInfo);
//					}
//					splicingCodeForFindUniquePrice = code + key + invokeOne;
//					if (invokeTwo != null) {
//						splicingCodeDetail = code + key + invokeOne + invokeTwo;
//					}
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionCoatStandardInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionCoatStandardInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValue.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionCoatStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionCoatStandardInfo);
					Method methodTwo = coOptionCoatStandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionCoatStandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}

				if (hasIdvalueName == true) {
					if("DoubleChester".equals(coatModel) || "DoublePolo".equals(coatModel)) {
						orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}else if("SingleChester".equals(coatModel) || "SoutienCollar".equals(coatModel)) {
						orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
					
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionCoatStandardInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionCoatStandardInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Integer optionPriceInt = 0;
		for (CoatCoOptionStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();

			try {
				Method methodSix = coOptionCoatStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionCoatStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				if (!("無料".equals(valueOf)) &&  !("null".equals(valueOf)))  {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
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
	public void allOptionInit(OrderCoForm orderCoForm,String oldItem) {
		// デフォルト値設定
		if("01".equals(oldItem)) {
			orderCoHelper.jacketDefaultValue(orderCoForm);
			orderCoHelper.pantsDefaultValue(orderCoForm);
			String productIs3Piece = orderCoForm.getProductIs3Piece();
			String productSparePantsClass = orderCoForm.getProductSparePantsClass();
			if("0009902".equals(productIs3Piece)) {
				orderCoHelper.giletDefaultValue(orderCoForm);
			}
			if("0009902".equals(productSparePantsClass)) {
				orderCoHelper.pants2DefaultValue(orderCoForm);
			}
		}else if("02".equals(oldItem)) {
			orderCoHelper.jacketDefaultValue(orderCoForm);
		}else if("03".equals(oldItem)) {
			orderCoHelper.pantsDefaultValue(orderCoForm);
		}else if("04".equals(oldItem)) {
			orderCoHelper.giletDefaultValue(orderCoForm);
		}else if("05".equals(oldItem)) {
			orderCoHelper.shirtDefaultValue(orderCoForm);
		}else if("06".equals(oldItem)) {
			orderCoHelper.coatDefaultValue(orderCoForm);
		}else if("07".equals(oldItem)) {
			orderCoHelper.pants2DefaultValue(orderCoForm);
		}
	}
	/**
	 * クラスと列挙の方法名によって、方法を取得
	 * 
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	private Method getMethod(Class<?> classOne, String methodName) {
		Method[] methods = classOne.getMethods();
		Method result = null;
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				result = method;
				break;
			}
		}
		return result;
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
	public Map<String, Object> getOrderPriceForPantsModel(OrderCoForm orderCoForm, String code) {
		CoOptionPantsStandardInfo coOptionPantsStandardInfo =orderCoForm.getCoOptionPantsStandardInfo();
		PantsCoOptionStandardPriceEnum[] priceEnum = PantsCoOptionStandardPriceEnum.values();
		
		String opTack = coOptionPantsStandardInfo.getOpTack();
		
		for (PantsCoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionPantsStandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPantsStandardInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPantsStandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPantsStandardInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("0000105".equals(opTack) || "0000106".equals(opTack)) {
					orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}else{
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo");
				Method methodThree = getMethod(cls, valueThree);				
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsStandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (PantsCoOptionStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPantsStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForPantsSProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPantsSProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionPantsStandardInfo coOptionPantsStandardInfo =orderCoForm.getCoOptionPantsStandardInfo();
		String opTack = coOptionPantsStandardInfo.getOpTack();
		PantsCoOptionStandardPriceEnum[] priceEnum = PantsCoOptionStandardPriceEnum.values();
		
		String orderPrice = "";
		for (PantsCoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			boolean hasIdvalueName = false;
			try {
				if (idValueName.equals(valueFour)) {
					Method methodOne = coOptionPantsStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsStandardInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionPantsStandardInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPantsStandardInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionPantsStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsStandardInfo);
					Method methodTwo = coOptionPantsStandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPantsStandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				
				if(("op_stitchModify_id".equals(idValueName) && "op_stitchModify_id".equals(valueFour))|| ("op_dStitch_id".equals(idValueName) &&"op_dStitch_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split(",");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("op_amfColor_id".equals(idValueName)&&"op_amfColor_id".equals(valueFour))||
					("op_bhColor_id".equals(idValueName)&&"op_bhColor_id".equals(valueFour))||
					("op_byColor_id".equals(idValueName))&&"op_byColor_id".equals(valueFour)) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
					Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
					orderPrice = String.valueOf(colorPrice);
				}

				if (hasIdvalueName == true) {
					if("0000105".equals(opTack) || "0000106".equals(opTack)) {
						orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}else{
						orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsStandardInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Integer optionPriceInt = 0;
		for (PantsCoOptionStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();

			try {
				Method methodSix = coOptionPantsStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				if (!("無料".equals(valueOf)) &&  !("null".equals(valueOf)))  {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;

	}
	
	@RequestMapping(value = "/getOrderPriceForPantsTuModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPantsTuModel(OrderCoForm orderCoForm, String code, Model model) {
		CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo =orderCoForm.getCoOptionPantsTuxedoInfo();
		PantsCoOptionTuxedoPriceEnum[] priceEnum = PantsCoOptionTuxedoPriceEnum.values();
		
		String tpTack = coOptionPantsTuxedoInfo.getTpTack();
		
		for (PantsCoOptionTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionPantsTuxedoInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPantsTuxedoInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPantsTuxedoInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPantsTuxedoInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("0000105".equals(tpTack) || "0000106".equals(tpTack)) {
					orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}else{
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}
				
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo");
				Method methodThree = getMethod(cls, valueThree);				
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsTuxedoInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (PantsCoOptionTuxedoPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPantsTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsTuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForPantsSTuProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPantsSTuProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo =orderCoForm.getCoOptionPantsTuxedoInfo();
		String tpTack = coOptionPantsTuxedoInfo.getTpTack();
		PantsCoOptionTuxedoPriceEnum[] priceEnum = PantsCoOptionTuxedoPriceEnum.values();
		
		String orderPrice = "";
		for (PantsCoOptionTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			boolean hasIdvalueName = false;
			try {
				if (idValueName.equals(valueFour)) {
					Method methodOne = coOptionPantsTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsTuxedoInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionPantsTuxedoInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPantsTuxedoInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionPantsTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsTuxedoInfo);
					Method methodTwo = coOptionPantsTuxedoInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPantsTuxedoInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				if(("tp_stitchModify_id".equals(idValueName) && "tp_stitchModify_id".equals(valueFour))|| ("tp_dStitch_id".equals(idValueName) &&"tp_dStitch_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split(",");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("tp_amfColor_id".equals(idValueName)&&"tp_amfColor_id".equals(valueFour))||
					("tp_bhColor_id".equals(idValueName)&&"tp_bhColor_id".equals(valueFour))||
					("tp_byColor_id".equals(idValueName))&&"tp_byColor_id".equals(valueFour)) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
					Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
					orderPrice = String.valueOf(colorPrice);
				}
				if (hasIdvalueName == true) {
					if("0000105".equals(tpTack) || "0000106".equals(tpTack)) {
						orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}else{
						orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsTuxedoInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Integer optionPriceInt = 0;
		for (PantsCoOptionTuxedoPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			try {
				Method methodSix = coOptionPantsTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsTuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
				if (!("無料".equals(valueOf)) &&  !("null".equals(valueOf)))  {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;

	}
	
	@RequestMapping(value = "/getOrderPriceForPantsWPModel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrderPriceForPantsWPModel(OrderCoForm orderCoForm, String code, Model model) {
		CoOptionPantsWashableInfo coOptionPantsWashableInfo =orderCoForm.getCoOptionPantsWashableInfo();
		PantsCoOptionWashablePriceEnum[] priceEnum = PantsCoOptionWashablePriceEnum.values();
		
		String wpTack = coOptionPantsWashableInfo.getWpTack();
		
		for (PantsCoOptionWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionPantsWashableInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPantsWashableInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPantsWashableInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPantsWashableInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("0000105".equals(wpTack) || "0000106".equals(wpTack)) {
					orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}else{
					orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}
				
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo");
				Method methodThree = getMethod(cls, valueThree);				
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsWashableInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (PantsCoOptionWashablePriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPantsWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsWashableInfo);
				String valueOf = String.valueOf(invokeSix);
				
				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				}else {
					priceMap.put(valueFour, "￥" + formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@RequestMapping(value = "/getOrderPriceForPantsSWPProject", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getOrderPriceForPantsSWPProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionPantsWashableInfo coOptionPantsWashableInfo =orderCoForm.getCoOptionPantsWashableInfo();
		PantsCoOptionWashablePriceEnum[] priceEnum = PantsCoOptionWashablePriceEnum.values();
		
		String wpTack = coOptionPantsWashableInfo.getWpTack();
		
		String orderPrice = "";
		for (PantsCoOptionWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String valueFive = price.getValueFive();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			boolean hasIdvalueName = false;
			try {
				if (idValueName.equals(valueFour)) {
					Method methodOne = coOptionPantsWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsWashableInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionPantsWashableInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPantsWashableInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionPantsWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsWashableInfo);
					Method methodTwo = coOptionPantsWashableInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPantsWashableInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				if(("wp_stitchModify_id".equals(idValueName) && "wp_stitchModify_id".equals(valueFour))|| ("wp_dStitch_id".equals(idValueName) &&"wp_dStitch_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split(",");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("wp_amfColor_id".equals(idValueName)&&"wp_amfColor_id".equals(valueFour))||
					("wp_bhColor_id".equals(idValueName)&&"wp_bhColor_id".equals(valueFour))||
					("wp_byColor_id".equals(idValueName))&&"wp_byColor_id".equals(valueFour)) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = getOrderPrice(projectPriceCode, "", orderCoForm);
					Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
					orderPrice = String.valueOf(colorPrice);
				}

				if (hasIdvalueName == true) {
					if("0000105".equals(wpTack) || "0000106".equals(wpTack)) {
						orderPrice = getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}else{
						orderPrice = getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo");
					Method methodThree = getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsWashableInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Integer optionPriceInt = 0;
		for (PantsCoOptionWashablePriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			try {
				Method methodSix = coOptionPantsWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsWashableInfo);
				String valueOf = String.valueOf(invokeSix);
				if (!("無料".equals(valueOf)) &&  !("null".equals(valueOf)))  {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		return resultMap;

	}
	
	public Boolean isEmpty(String value) {
		if("".equals(value)||null == value) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean isNotEmpty(String value) {
		  if (value == "" || value == null) {
		    return false;
		  }
		  return true;
	}
	private boolean GrossCompareTo(String gross, ResultMessages messages, String msg) {
		if(gross==null||gross=="") {
			messages.add("E036", msg);
			return true;
		}
		String maxGross = "110";
		String minGross = "50";
		BigDecimal maxGross1 = new BigDecimal(maxGross);
		BigDecimal minGross1 = new BigDecimal(minGross);
		BigDecimal gross1 = new BigDecimal(gross);

		if (gross1.compareTo(minGross1) == -1) {
			messages.add("E036", msg);
			return true;
		}
		if (gross1.compareTo(maxGross1) == 1) {
			messages.add("E036", msg);
			return true;
		}
		return false;

	}
	
}
