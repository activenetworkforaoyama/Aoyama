package co.jp.aoyama.macchinetta.app.order;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.support.SessionStatus;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import co.jp.aoyama.macchinetta.app.order.enums.LogItemClassEnum;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Maker;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;
import co.jp.aoyama.macchinetta.domain.model.OptionBranchDetail;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.Stock;
import co.jp.aoyama.macchinetta.domain.service.cash.CashService;
import co.jp.aoyama.macchinetta.domain.service.maker.MakerService;
import co.jp.aoyama.macchinetta.domain.service.measuring.MeasuringService;
import co.jp.aoyama.macchinetta.domain.service.order.NextGenerationService;
import co.jp.aoyama.macchinetta.domain.service.order.OptionBranchDeailService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;
import co.jp.aoyama.macchinetta.domain.service.stock.StockService;

@Controller
@RequestMapping("/orderConfirm")
@SessionAttributes(value = {"orderForm"})
@TransactionTokenCheck("/orderConfirm")
public class OrderReconfirmController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderReconfirmController.class);
	
	@Inject
	SessionContent sessionContent;
	
	@Inject
	OptionBranchDeailService optionBranchDeailService;
	
	@Inject
	Mapper beanMapper;
	
	@Inject
	MeasuringService measuringService;
	
	@Inject
	OrderListService orderListService;
	
	@Inject
	OrderService orderService;
	
	@Inject
	MakerService makerService;
	
	@Inject
	NextGenerationService nextGenerationService;
	
	@Inject
	CashService cashService;
	
	@Inject
	StockService stockService;
	
	Measuring measuring = new Measuring();
	
	@ModelAttribute(value = "orderForm")
	public OrderForm setUpOrderForm() {
		return new OrderForm();
	}

	@RequestMapping(value = "orderReForm")
	@TransactionTokenCheck(value = "create",type = TransactionTokenType.BEGIN)
	public String toOrderReForm(@ModelAttribute(value = "orderForm")OrderForm orderForm,HttpServletRequest req,Model model,Map<String, Map<String, Integer>> map) {
		String status = orderForm.getStatus();
		if("T2".equals(status) || "T3".equals(status) || "T4".equals(status) || "T5".equals(status)) {
			//注文ID
			String orderId = orderForm.getCustomerMessageInfo().getOrderId();
			//注文
			Order order = orderListService.findOrderByPk(orderId);
			Date productOrderdDate = order.getProductOrderdDate();
			if(productOrderdDate != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String productOrderdDateFormat = sdf.format(productOrderdDate);
				model.addAttribute("productOrderdDateFormat",productOrderdDateFormat);
			}
		}
		Map<String, Integer> retailPriceRelatedProjects = this.retailPriceRelatedProjects(orderForm);
		OrderFindFabric findStock = this.findStock(orderForm);
		String color = findStock.getColor();
		String pattern = findStock.getPattern();
		model.addAttribute("color",color);
		model.addAttribute("pattern",pattern);
		map.put("priceMap", retailPriceRelatedProjects);
		return "order/orderPoReconfirmForm";
	}
	
	/**
	 * オーダー内容確認画面のすべて素材_名の取得
	 * @param itemCode
	 * @param mateChecked
	 * @param orderPattern
	 * @param optionCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "standardMateSelect", method = RequestMethod.POST)
	public Map<String,String> standardMateSelect(String itemCode, String subItemCode,String mateChecked,String orderPattern,String optionCode) {
		OrderHelper orderHelper = new OrderHelper();
		List<OptionBranchDetail> mateList = optionBranchDeailService.getStandardButtons(itemCode ,subItemCode, mateChecked,orderPattern,optionCode);
		LinkedHashMap<String,String> standardMateMap = orderHelper.getButtons(mateList);
		return standardMateMap;
	}
	
	/**
	 * 生地品番とオーダーパターンによって生地の情報を取得
	 * 
	 * @param fabricNo
	 * @param orderPattern
	 * 
	 */
	public OrderFindFabric findStock(OrderForm orderForm) {
		String fabricNo = orderForm.getProductFabricNo();
		String orderPattern = "PO";
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		return orderFindFabric;
	}
	
	/**
	 * メーカーコードによる取得メーカーID
	 * @return
	 */
	public String findMakerId(OrderForm orderForm) throws ResourceNotFoundException{
		String fabricNo = orderForm.getProductFabricNo();
		String orderPattern = "PO";
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		String makerCode = orderFindFabric.getMakerCode();
		Maker findMakerCd = makerService.findOne(makerCode);
		String makerId = findMakerCd.getMakerId();
		return makerId;
	}
	
	/**
	 * オプション対応の下代工賃と下代付属の取得
	 * @param orderForm
	 * @return
	 */
	public List<NextGenerationPrice> optionNextGenerationPrice(OrderForm orderForm) {
		String orderPattern = "PO";
		String itemCode = orderForm.getProductItem();
		String productFabricNo = orderForm.getProductFabricNo();
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderFindFabric.getFactoryCode();
		//JACKETのsubItemCode
		String jkSubItemCode = null;
		//GILETのsubItemCode
		String gtSubItemCode = null;
		//PANTSのsubItemCode
		String ptSubItemCode = null;
		//PANTS2のsubItemCode
		String pt2SubItemCode = null;
		OrderHelper orderHelper = new OrderHelper();
		Map<String, String> subItemCodeValue = orderHelper.subItemCodeValue(orderForm,jkSubItemCode,gtSubItemCode,ptSubItemCode,pt2SubItemCode);
		jkSubItemCode = subItemCodeValue.get("jkSubItemCode");
		gtSubItemCode = subItemCodeValue.get("gtSubItemCode");
		ptSubItemCode = subItemCodeValue.get("ptSubItemCode");
		pt2SubItemCode = subItemCodeValue.get("pt2SubItemCode");
		//該当オプション対応の下代工賃と下代付属の取得
		List<NextGenerationPrice> optionNextGenerationPriceList= nextGenerationService.selectOptionNextGenerationPrice(jkSubItemCode, gtSubItemCode, ptSubItemCode, pt2SubItemCode,factoryCode,itemCode);
		return optionNextGenerationPriceList;
	}
	
	/**
	 * 基本の下代工賃と下代付属の取得
	 * @param orderForm
	 * @return
	 */
	public List<NextGenerationPrice> basicNextGenerationPrice(OrderForm orderForm){
		//生地品番
		String fabricNo = orderForm.getProductFabricNo();
		String itemCode = orderForm.getProductItem();
		//JACKETのsubItemCode
		String jkSubItemCode = null;
		//GILETのsubItemCode
		String gtSubItemCode = null;
		//PANTSのsubItemCode
		String ptSubItemCode = null;
		//PANTS2のsubItemCode
		String pt2SubItemCode = null;
		OrderHelper orderHelper = new OrderHelper();
		Map<String, String> subItemCodeValue = orderHelper.subItemCodeValue(orderForm,jkSubItemCode,gtSubItemCode,ptSubItemCode,pt2SubItemCode);
		jkSubItemCode = subItemCodeValue.get("jkSubItemCode");
		gtSubItemCode = subItemCodeValue.get("gtSubItemCode");
		ptSubItemCode = subItemCodeValue.get("ptSubItemCode");
		pt2SubItemCode = subItemCodeValue.get("pt2SubItemCode");
		//基本下代工賃と基本下代付属の取得
		List<NextGenerationPrice> basicNextGenerationPriceList= nextGenerationService.selectBasicNextGenerationPrice(jkSubItemCode, gtSubItemCode, ptSubItemCode, pt2SubItemCode, itemCode, fabricNo);
		return basicNextGenerationPriceList;
	}
	
	/**
	 * オプション選択肢詳細の下代価額の取得
	 * @param orderForm
	 * @return
	 */
	public List<NextGenerationPrice> detailNextGenerationPrice(OrderForm orderForm){
		String orderPattern = "PO";
		String productFabricNo = orderForm.getProductFabricNo();
		String itemCode = orderForm.getProductItem();
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderFindFabric.getFactoryCode();
		//JACKETのsubItemCode
		String jkSubItemCode = null;
		//GILETのsubItemCode
		String gtSubItemCode = null;
		//PANTSのsubItemCode
		String ptSubItemCode = null;
		//PANTS2のsubItemCode
		String pt2SubItemCode = null;
		OrderHelper orderHelper = new OrderHelper();
		Map<String, String> subItemCodeValue = orderHelper.subItemCodeValue(orderForm,jkSubItemCode,gtSubItemCode,ptSubItemCode,pt2SubItemCode);
		jkSubItemCode = subItemCodeValue.get("jkSubItemCode");
		gtSubItemCode = subItemCodeValue.get("gtSubItemCode");
		ptSubItemCode = subItemCodeValue.get("ptSubItemCode");
		pt2SubItemCode = subItemCodeValue.get("pt2SubItemCode");
		//オプション選択肢詳細の下代工賃と下代付属の取得
		List<NextGenerationPrice> detailNextGenerationPriceList= nextGenerationService.selectDetailNextGenerationPrice(jkSubItemCode, gtSubItemCode, ptSubItemCode, pt2SubItemCode,factoryCode,itemCode);
		return detailNextGenerationPriceList;
	}
	
	/**
	 * 要尺の取得
	 */
	public List<NextGenerationPrice> getYieldList(OrderForm orderForm){
		//JACKETのsubItemCode
		String jkSubItemCode = null;
		//GILETのsubItemCode
		String gtSubItemCode = null;
		//PANTSのsubItemCode
		String ptSubItemCode = null;
		//PANTS2のsubItemCode
		String pt2SubItemCode = null;
		OrderHelper orderHelper = new OrderHelper();
		Map<String, String> subItemCodeValue = orderHelper.subItemCodeValue(orderForm,jkSubItemCode,gtSubItemCode,ptSubItemCode,pt2SubItemCode);
		jkSubItemCode = subItemCodeValue.get("jkSubItemCode");
		gtSubItemCode = subItemCodeValue.get("gtSubItemCode");
		ptSubItemCode = subItemCodeValue.get("ptSubItemCode");
		pt2SubItemCode = subItemCodeValue.get("pt2SubItemCode");
		
		List<NextGenerationPrice> yieldList= nextGenerationService.selectYield(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode);
		return yieldList;
	} 
	
	/**
	 * ドル為替と製品関税と製品運賃と運賃誤差の取得
	 * @param orderForm
	 * @return
	 */
	public  List<NextGenerationPrice> getWholesalePieceList(OrderForm orderForm){
		//生地品番
		String fabricNo = orderForm.getProductFabricNo();
		List<NextGenerationPrice> wholesalePieceList= nextGenerationService.selectWholesalePiece(fabricNo);
		return wholesalePieceList;
	}
	
	/**
	 * マージンの取得
	 * @param orderForm
	 * @return
	 */
	public NextGenerationPrice getMarginRate(OrderForm orderForm) {
		//生地品番
		String fabricNo = orderForm.getProductFabricNo();
		NextGenerationPrice marginRate = nextGenerationService.selectMarginRate(fabricNo);
		return marginRate;
	}
	
	/**
	 * 工場コードと生地代の取得
	 * 
	 */
	public NextGenerationPrice getPriceCode(OrderForm orderForm) {
		//生地品番
		String fabricNo = orderForm.getProductFabricNo();
		NextGenerationPrice mfaFactoryCode = nextGenerationService.selectFactoryCode(fabricNo);
		return mfaFactoryCode;
	}
	
	/**
	 * データベースのorderデータを検索する。
	 * @param orderForm
	 * @return
	 */
	public Order selectExistOrder(OrderForm orderForm) {
		String orderId = orderForm.getCustomerMessageInfo().getOrderId();
		Order order= orderListService.findOrderByPk(orderId);
		return order;
	}
	
	/**
	 * 上代関連項目
	 * @param orderForm
	 * @return 
	 */
	public Map<String, Integer> retailPriceRelatedProjects(OrderForm orderForm) {
		OrderHelper orderHelper = new OrderHelper();
		String fabricNo = orderForm.getProductFabricNo();
		String orderPattern = "PO";
		OrderFindFabric orderFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		Map<String, Integer> retailPriceRelatedMap = orderHelper.getRetailPriceRelated(orderFabric);
		return retailPriceRelatedMap;
	}
	
	/**
	 * オーダー内容確認画面の値をデータベースに入力する
	 * @param orderForm
	 * @return
	 */
	@RequestMapping(value = "orderReFormInDb", method = RequestMethod.POST)
	@TransactionTokenCheck(value = "create",type = TransactionTokenType.IN)
	public String orderReFormInDb(@ModelAttribute(value = "orderForm")OrderForm orderForm,SessionStatus sessionStatus,Model model) {
		
		Order order = new Order();
		OrderHelper orderHelper = new OrderHelper();
		try {
			Order orderId = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
			List<NextGenerationPrice> optionNextGenerationPriceList = this.optionNextGenerationPrice(orderForm);
			List<NextGenerationPrice> basicNextGenerationPriceList = this.basicNextGenerationPrice(orderForm);
			List<NextGenerationPrice> detailNextGenerationPriceList = this.detailNextGenerationPrice(orderForm);
			List<NextGenerationPrice> yieldList = this.getYieldList(orderForm);
			List<NextGenerationPrice> wholesalePieceList = this.getWholesalePieceList(orderForm);
			NextGenerationPrice marginRate = this.getMarginRate(orderForm);
			NextGenerationPrice priceCode = this.getPriceCode(orderForm);
			OrderFindFabric findStock = this.findStock(orderForm);
			Order selectExistOrder = this.selectExistOrder(orderForm);
			Map<String, Integer> retailPriceRelatedMap = this.retailPriceRelatedProjects(orderForm);
		
			
			//商品情報_３Piece上代
			orderHelper.order3PiecePrice(orderForm, order,retailPriceRelatedMap);
			//スペアパンツ上代
			orderHelper.orderSparePantsPrice(orderForm, order,retailPriceRelatedMap);
			// 商品情報_３Pieceとスペアパンツの下代付属と下代工賃
			orderHelper.getGl3PieceNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, optionNextGenerationPriceList);
			orderHelper.getSparePantsNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, optionNextGenerationPriceList);
			
			//SUITの場合、itemCodeは"01"
			if("01".equals(orderForm.getProductItem())) {
				
				orderHelper.setProductItemDisplayCode(orderForm, order);
				
				orderHelper.orderJacketPrice(orderForm, order);
				orderHelper.orderJacketMappingPo(orderForm, order);
				orderHelper.orderJkNameMappingPo(orderForm, order);
				beanMapper.map(orderForm.getOptionJacketStandardInfo(),order);
				beanMapper.map(orderForm.getAdjustJacketStandardInfo(),order);
				orderHelper.getJkNextGenerationPrice(orderForm, order, optionNextGenerationPriceList, basicNextGenerationPriceList);
				orderHelper.getJkDetailNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, detailNextGenerationPriceList);
	
				orderHelper.orderPantsPrice(orderForm, order);
				orderHelper.orderPantsMappingPo(orderForm, order);
				orderHelper.orderPtNameMappingPo(orderForm, order);
				beanMapper.map(orderForm.getOptionPantsStandardInfo(),order);
				beanMapper.map(orderForm.getAdjustPantsStandardInfo(),order);
				orderHelper.getPtNextGenerationPrice(orderForm, order, optionNextGenerationPriceList, basicNextGenerationPriceList);
				orderHelper.getPtDetailNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, detailNextGenerationPriceList);
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				//３Pieceは有り、スペアパンツは有りの場合
				if(productYes.equals(orderForm.getProductIs3Piece()) && productYes.equals(orderForm.getProductSparePantsClass())) {
					
					orderHelper.orderGiletPrice(orderForm, order);
					orderHelper.orderGiletMappingPo(orderForm, order);
					orderHelper.orderGlNameMappingPo(orderForm, order);
					beanMapper.map(orderForm.getOptionGiletStandardInfo(),order);
					beanMapper.map(orderForm.getAdjustGiletStandardInfo(),order);
					orderHelper.getGlNextGenerationPrice(orderForm, order, optionNextGenerationPriceList, basicNextGenerationPriceList);
					orderHelper.getGlDetailNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, detailNextGenerationPriceList);
					
					orderHelper.orderPants2Price(orderForm, order);
					orderHelper.orderPants2MappingPo(orderForm, order);
					orderHelper.orderPt2NameMappingPo(orderForm, order);
					beanMapper.map(orderForm.getOptionPants2StandardInfo(),order);
					beanMapper.map(orderForm.getAdjustPants2StandardInfo(),order);
					orderHelper.getPt2NextGenerationPrice(orderForm, order, optionNextGenerationPriceList, basicNextGenerationPriceList);
					orderHelper.getPt2DetailNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, detailNextGenerationPriceList);
				}
				//３Pieceは有り、スペアパンツは無しの場合
				else if(productYes.equals(orderForm.getProductIs3Piece()) && productNo.equals(orderForm.getProductSparePantsClass())) {
					
					orderHelper.orderGiletPrice(orderForm, order);
					orderHelper.orderGiletMappingPo(orderForm, order);
					orderHelper.orderGlNameMappingPo(orderForm, order);
					beanMapper.map(orderForm.getOptionGiletStandardInfo(),order);
					beanMapper.map(orderForm.getAdjustGiletStandardInfo(),order);
					orderHelper.getGlNextGenerationPrice(orderForm, order, optionNextGenerationPriceList, basicNextGenerationPriceList);
					orderHelper.getGlDetailNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, detailNextGenerationPriceList);
				}
				//３Pieceは無し、スペアパンツは有りの場合
				else if(productNo.equals(orderForm.getProductIs3Piece()) && productYes.equals(orderForm.getProductSparePantsClass())) {
					
					orderHelper.orderPants2Price(orderForm, order);
					orderHelper.orderPants2MappingPo(orderForm, order);
					orderHelper.orderPt2NameMappingPo(orderForm, order);
					beanMapper.map(orderForm.getOptionPants2StandardInfo(),order);
					beanMapper.map(orderForm.getAdjustPants2StandardInfo(),order);
					orderHelper.getPt2NextGenerationPrice(orderForm, order, optionNextGenerationPriceList, basicNextGenerationPriceList);
					orderHelper.getPt2DetailNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, detailNextGenerationPriceList);
					
				}
				else {
					order.setProductIs3pieceRtPrice(0);
					order.setProductIs3pieceWsWage(new BigDecimal(0.0));
					order.setProductIs3pieceWsPrice(0);
				}
			}
			//JACKETの場合、itemCodeは"02"
			else if("02".equals(orderForm.getProductItem())) {
				orderHelper.orderJacketPrice(orderForm, order);
				orderHelper.orderJacketMappingPo(orderForm, order);
				orderHelper.orderJkNameMappingPo(orderForm, order);
				beanMapper.map(orderForm.getOptionJacketStandardInfo(),order);
				beanMapper.map(orderForm.getAdjustJacketStandardInfo(),order);
				orderHelper.getJkNextGenerationPrice(orderForm, order, optionNextGenerationPriceList, basicNextGenerationPriceList);
				orderHelper.getJkDetailNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, detailNextGenerationPriceList);
			}
			//PANTSの場合、itemCodeは"03"
			else if("03".equals(orderForm.getProductItem())) {
				orderHelper.orderPantsPrice(orderForm, order);
				orderHelper.orderPantsMappingPo(orderForm, order);
				orderHelper.orderPtNameMappingPo(orderForm, order);
				beanMapper.map(orderForm.getOptionPantsStandardInfo(),order);
				beanMapper.map(orderForm.getAdjustPantsStandardInfo(),order);
				orderHelper.getPtNextGenerationPrice(orderForm, order, optionNextGenerationPriceList, basicNextGenerationPriceList);
				orderHelper.getPtDetailNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, detailNextGenerationPriceList);
			}
			//GILETの場合、itemCodeは"04"
			else if("04".equals(orderForm.getProductItem())) {
				orderHelper.orderGiletPrice(orderForm, order);
				orderHelper.orderGiletMappingPo(orderForm, order);
				orderHelper.orderGlNameMappingPo(orderForm, order);
				beanMapper.map(orderForm.getOptionGiletStandardInfo(),order);
				beanMapper.map(orderForm.getAdjustGiletStandardInfo(),order);
				orderHelper.getGlNextGenerationPrice(orderForm, order, optionNextGenerationPriceList, basicNextGenerationPriceList);
				orderHelper.getGlDetailNextGenerationPrice(orderForm, order, basicNextGenerationPriceList, detailNextGenerationPriceList);
			}
			
			//orderFormの対象とorderの対応フィールドのマッピング
			beanMapper.map(orderForm.getCustomerMessageInfo(),order);
			beanMapper.map(orderForm,order);
			
			String userId = sessionContent.getUserId();
			String findMakerId = this.findMakerId(orderForm);
			orderHelper.onlyUpdateItem(selectExistOrder,order,sessionContent.getAuthority());
			orderHelper.orderMappingPo(orderForm, order,userId,findStock,orderId,findMakerId,retailPriceRelatedMap,priceCode);
			orderHelper.measuringMapping(orderForm, measuring,sessionContent.getUserId());
			orderHelper.nextGenerationRelationCount(orderForm, order, yieldList, wholesalePieceList,basicNextGenerationPriceList, priceCode, marginRate);
			
			
			measuringService.updateByPrimaryKey(measuring);
			
			//挿入の場合
			if (orderId == null) {
				orderService.insertOrder(order);
			} 
			//更新の場合
			else {
				try {
					//生地品番
					String fabricNo = orderForm.getProductFabricNo();
					//商品情報_ITEM(ログ用)
					String item = LogItemClassEnum.getLogItem(order);
					//ステータス
					String status = orderForm.getStatus();
					
					Stock stock = orderService.getStock(fabricNo,order.getOrderPattern());
					logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。更新前：「注文パターン：" + order.getOrderPattern() 
					+ "、注文ID："+orderForm.getCustomerMessageInfo().getOrderId()  
					+ "、ITEM："+item 
					+ "、生地品番："+fabricNo
					+ "、理論在庫："+stock.getTheoreticalStock() 
					+ "、予約生地量："+stock.getReservationStock() + "」");
					
					orderService.updateOrderConfirm(order,status);
					
					Stock stockAfter = orderService.getStock(fabricNo,order.getOrderPattern());
					logger.info("オーダー登録確認画面で在庫マスタ情報を更新する。更新後：「注文パターン：" + order.getOrderPattern() 
					+ "、注文ID："+orderForm.getCustomerMessageInfo().getOrderId()  
					+ "、ITEM："+item
					+ "、生地品番："+fabricNo
					+ "、理論在庫："+stockAfter.getTheoreticalStock() 
					+ "、予約生地量："+stockAfter.getReservationStock() + "」");
					
				} catch (ResourceNotFoundException e) {
					String status = orderForm.getStatus();
					if("T2".equals(status) || "T3".equals(status) || "T4".equals(status) || "T5".equals(status)) {
						//注文ID
						String orderError = orderForm.getCustomerMessageInfo().getOrderId();
						//注文
						Order orderValue = orderListService.findOrderByPk(orderError);
						Date productOrderdDate = orderValue.getProductOrderdDate();
						if(productOrderdDate != null) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String productOrderdDateFormat = sdf.format(productOrderdDate);
							model.addAttribute("productOrderdDateFormat",productOrderdDateFormat);
						}
					}
					model.addAttribute("resultMessages", e.getResultMessages());
					Map<String, Integer> retailPriceRelatedProjects = this.retailPriceRelatedProjects(orderForm);
					OrderFindFabric findStockOrder = this.findStock(orderForm);
					String color = findStockOrder.getColor();
					String pattern = findStockOrder.getPattern();
					model.addAttribute("color",color);
					model.addAttribute("pattern",pattern);
					model.addAttribute("priceMap", retailPriceRelatedProjects);
					return "order/orderPoReconfirmForm";
				}
			}
			
			if("".equals(orderForm.getStatus()) || "T0".equals(orderForm.getStatus()) || "T1".equals(orderForm.getStatus())) {
				String isLogin = "8";
				model.addAttribute("isLogin",isLogin);
			}
			else {
				String orderFormIsUpdate = "9";
				model.addAttribute("orderFormIsUpdate",orderFormIsUpdate);
			}
			
			sessionStatus.setComplete();
			return "order/orderPoLoginResultForm";
				
			} catch (ResourceNotFoundException e) {
				String isFailure = null;
				if("".equals(orderForm.getStatus()) || "T0".equals(orderForm.getStatus()) || "T1".equals(orderForm.getStatus())) {
					isFailure = "1";
				}
				else {
					isFailure = "2";
				}
				model.addAttribute("messages",e.getResultMessages());
				model.addAttribute("isFailure",isFailure);
				return "order/orderPoLoginResultForm";
			}
		}
}
