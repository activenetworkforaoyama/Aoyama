package co.jp.aoyama.macchinetta.app.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

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
public class OrderReconfirmController {
	
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
	public String toOrderReForm(@ModelAttribute(value = "orderForm")OrderForm orderForm,HttpServletRequest req,Model model,Map<String, Map<String, Integer>> map) {
		
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
	public List<NextGenerationPrice> getYieldList(){
		//JACKETのsubItemCode
		String jkSubItemCode = "02";
		//GILETのsubItemCode
		String gtSubItemCode = "04";
		//PANTSのsubItemCode
		String ptSubItemCode = "03";
		//PANTS2のsubItemCode
		String pt2SubItemCode = "07";
		
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
	 * 会計ステータスを更新
	 * @param orderForm
	 * @return
	 */
	public boolean updateCashStatus(OrderForm orderForm) {
		//注文ID
		String orderId = orderForm.getCustomerMessageInfo().getOrderId();
		//注文
		Order order = orderListService.findOrderByPk(orderId);
		//会計ID
		String cashId = order.getCashId();
		//TSCステータス
		String orderStatus = orderForm.getStatus();
		//最終更新者
		String updatedUserId = sessionContent.getUserId();
		//最終更新日時
		Date updatedAt = new Date();
		//03：会計再確認要
		String cashStatus = "03";
		boolean updateFlag = false;
		if(order.getCashId() == null || "".equals(order.getCashId())) {
			return updateFlag;
		}
		else if("T3".equals(orderStatus) || "T4".equals(orderStatus) || "T5".equals(orderStatus)) {
			if(order.getCashId() != null || !("".equals(order.getCashId()))) {
				cashService.updateCashStatus(cashId, cashStatus, updatedUserId, updatedAt);
				updateFlag = true;
			}
		}
		return updateFlag;
	}
	
	/**
	 * 在庫チェック
	 * @param orderForm
	 */
	public void updateFabric(OrderForm orderForm) {
		//生地品番
		String fabricNo = orderForm.getProductFabricNo();
		//TSCステータス
		String status = orderForm.getStatus();
		//注文ID
		String orderId = orderForm.getCustomerMessageInfo().getOrderId();
		//注文
		Order order = orderListService.findOrderByPk(orderId);
		//オーダーマスタに生地品番
		String productFabricNo = order.getProductFabricNo();
		//オーダーマスタに理論生地使用量
		BigDecimal theoryFabricUsedMountOrder = order.getTheoryFabricUsedMount();
		//予約生地量
		String orderFormReservationStock = orderForm.getTheoryFabricUsedMount();
		BigDecimal reservationStockValue = new BigDecimal(orderFormReservationStock);
		
		//TSCステータスは空、T0（一時保存）、T1（取り置き）の場合
		if("".equals(status) || "T0".equals(status) || "T1".equals(status)) {
			if(fabricNo != null && reservationStockValue != null) {
				Stock stock = orderService.getStock(fabricNo);
				BigDecimal theoreticalStock = stock.getTheoreticalStock();
				BigDecimal stockReservationStock = stock.getReservationStock();
				BigDecimal theoreticalStockUpdate = theoreticalStock.subtract(reservationStockValue);
				BigDecimal reservationStockUpdate = stockReservationStock.subtract(reservationStockValue);
				stockService.updateStockValue(fabricNo,theoreticalStockUpdate,reservationStockUpdate);
			}
		}
		else {
			if(productFabricNo != null && fabricNo != null && theoryFabricUsedMountOrder != null && reservationStockValue != null) {
				if(productFabricNo.equals(fabricNo)) {
					if(theoryFabricUsedMountOrder.compareTo(reservationStockValue)!=0) {
						Stock stock = orderService.getStock(fabricNo);
						BigDecimal theoreticalStock = stock.getTheoreticalStock();
						BigDecimal oldTheoreticalStockUpdate = theoreticalStock.add(theoryFabricUsedMountOrder);
						BigDecimal newTheoreticalStockUpdate = oldTheoreticalStockUpdate.subtract(reservationStockValue);
						stockService.updateTheoreticalStock(fabricNo,newTheoreticalStockUpdate);
					}
				}
				else if(!productFabricNo.equals(fabricNo)) {
					//古い理論在庫を修正する
					Stock oldStock = orderService.getStock(productFabricNo);
					BigDecimal oldTheoreticalStock = oldStock.getTheoreticalStock();
					BigDecimal oldTheoreticalStockUpdate = oldTheoreticalStock.add(theoryFabricUsedMountOrder);
					stockService.updateTheoreticalStock(fabricNo,oldTheoreticalStockUpdate);
					
					//新しい理論在庫を修正する
					Stock newStock = orderService.getStock(fabricNo);
					BigDecimal newTheoreticalStock = newStock.getTheoreticalStock();
					BigDecimal newTheoreticalStockUpdate = newTheoreticalStock.subtract(reservationStockValue);
					stockService.updateTheoreticalStock(fabricNo,newTheoreticalStockUpdate);
				}
			}
		}
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
	public String orderReFormInDb(@ModelAttribute(value = "orderForm")OrderForm orderForm,SessionStatus sessionStatus,Model model) {
		
		Order order = new Order();
		OrderHelper orderHelper = new OrderHelper();
		try {
			Order orderId = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
			List<NextGenerationPrice> optionNextGenerationPriceList = this.optionNextGenerationPrice(orderForm);
			List<NextGenerationPrice> basicNextGenerationPriceList = this.basicNextGenerationPrice(orderForm);
			List<NextGenerationPrice> detailNextGenerationPriceList = this.detailNextGenerationPrice(orderForm);
			List<NextGenerationPrice> yieldList = this.getYieldList();
			List<NextGenerationPrice> wholesalePieceList = this.getWholesalePieceList(orderForm);
			NextGenerationPrice marginRate = this.getMarginRate(orderForm);
			NextGenerationPrice priceCode = this.getPriceCode(orderForm);
			OrderFindFabric findStock = this.findStock(orderForm);
			Order selectExistOrder = this.selectExistOrder(orderForm);
			Map<String, Integer> retailPriceRelatedMap = this.retailPriceRelatedProjects(orderForm);
		
			
			//商品情報_３Piece上代
			orderHelper.order3PiecePrice(orderForm, order);
			//スペアパンツ上代
			orderHelper.orderSparePantsPrice(orderForm, order);
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
			orderHelper.orderMappingPo(orderForm, order,userId,findStock,orderId,findMakerId,retailPriceRelatedMap);
			orderHelper.measuringMapping(orderForm, measuring,sessionContent.getUserId());
			orderHelper.nextGenerationRelationCount(orderForm, order, yieldList, wholesalePieceList,basicNextGenerationPriceList, priceCode, marginRate);
			orderHelper.onlyUpdateItem(selectExistOrder,order);
			
			measuringService.updateByPrimaryKey(measuring);
			
			//挿入の場合
			if (orderId == null) {
				orderService.insertOrder(order);
			} 
			//更新の場合
			else {
				try {
					orderService.updateOrder(order);
					//在庫チェック
					this.updateFabric(orderForm);
					//会計ステータスを更新
					this.updateCashStatus(orderForm);
				} catch (ResourceNotFoundException e) {
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
