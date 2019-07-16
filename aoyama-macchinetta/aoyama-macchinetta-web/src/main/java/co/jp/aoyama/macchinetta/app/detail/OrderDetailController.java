package co.jp.aoyama.macchinetta.app.detail;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.jp.aoyama.macchinetta.app.order.OrderHelper;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderDetail;
import co.jp.aoyama.macchinetta.domain.model.Shop;
import co.jp.aoyama.macchinetta.domain.service.detail.OrderDetailService;
import co.jp.aoyama.macchinetta.domain.service.measuring.MeasuringService;
import co.jp.aoyama.macchinetta.domain.service.order.NextGenerationService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;
import co.jp.aoyama.macchinetta.domain.service.shop.ShopService;

@Controller
@RequestMapping(value = "/orderDetail")
public class OrderDetailController {
	
	private static final Logger logger = LoggerFactory
            .getLogger(OrderDetailController.class);
	
	@Inject
	NextGenerationService nextGenerationService;
	@Inject
	OrderListService orderListService;
	
	@Inject
	OrderDetailService orderDetailService;
	
    @Inject
    SessionContent sessionContent;
    
    @Inject
    MeasuringService measuringService;
	
    @Inject
	OrderService orderService;
    
	@Inject
	Mapper beanMapper;
	
	@Inject
	ShopService shopService;
	
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
	

	//工場ステータス   生産開始前
	public static final String MAKER_FACTORY_STATUS_F0 = "F0";
	//工場ステータス   生産開始
	public static final String MAKER_FACTORY_STATUS_F1 = "F1";
	//工場ステータス   生産終了
	public static final String MAKER_FACTORY_STATUS_F2 = "F2";
	
			
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
	 * @param order
	 * @return
	 */
	public  List<NextGenerationPrice> getWholesalePieceList(Order order){
		//生地品番
		String fabricNo = order.getProductFabricNo();
		List<NextGenerationPrice> wholesalePieceList= nextGenerationService.selectWholesalePiece(fabricNo);
		return wholesalePieceList;
	}
	
	/**
	 * 基本の下代工賃と下代付属の取得
	 * @param orderForm
	 * @return
	 */
	public List<NextGenerationPrice> basicNextGenerationPrice(Order order){
		//生地品番
		String fabricNo = order.getProductFabricNo();
		String itemCode = order.getProductItem();
		//JACKETのsubItemCode
		String jkSubItemCode = null;
		//GILETのsubItemCode
		String gtSubItemCode = null;
		//PANTSのsubItemCode
		String ptSubItemCode = null;
		//PANTS2のsubItemCode
		String pt2SubItemCode = null;
		OrderHelper orderHelper = new OrderHelper();
		Map<String, String> subItemCodeValue = orderHelper.subItemCodeValue(order,jkSubItemCode,gtSubItemCode,ptSubItemCode,pt2SubItemCode);
		jkSubItemCode = subItemCodeValue.get("jkSubItemCode");
		gtSubItemCode = subItemCodeValue.get("gtSubItemCode");
		ptSubItemCode = subItemCodeValue.get("ptSubItemCode");
		pt2SubItemCode = subItemCodeValue.get("pt2SubItemCode");
		//基本下代工賃と基本下代付属の取得
		List<NextGenerationPrice> basicNextGenerationPriceList= nextGenerationService.selectBasicNextGenerationPrice(jkSubItemCode, gtSubItemCode, ptSubItemCode, pt2SubItemCode, itemCode, fabricNo);
		return basicNextGenerationPriceList;
	}
	
	/**
	 * マージンの取得
	 * @param order
	 * @return
	 */
	public NextGenerationPrice getMarginRate(Order order) {
		//生地品番
		String fabricNo = order.getProductFabricNo();
		NextGenerationPrice marginRate = nextGenerationService.selectMarginRate(fabricNo);
		return marginRate;
	}
	
	/**
	 * 工場コードと生地代の取得
	 * @param order
	 */
	public NextGenerationPrice getPriceCode(Order order) {
		//生地品番
		String fabricNo = order.getProductFabricNo();
		NextGenerationPrice mfaFactoryCode = nextGenerationService.selectFactoryCode(fabricNo);
		return mfaFactoryCode;
	}

    /**
   	* 全部注文を条件検索.
     * @param form 画面Form
     * @return 注文情報リスト
     */
	@RequestMapping(value = "/orderDetail")
	public String FindAllOrderByCondition(Model model,Map<String, Object> map) {
		// 店舗を取得
		List<Shop> shopList = shopService.findAllShop();
		
		Map<String, String> mapShop = new HashMap<String,String>();
		for (Shop shop : shopList) {
			mapShop.put(shop.getShopCode(), shop.getShopName());
		}
		map.put("mapShop", mapShop);
		return "detail/orderDetail";
	}
	
	/**
	 *「お渡し時再補正入力」画面へ遷移する
	 * @param orderId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/orderDetailToPo/{orderId}")
	public String toOrderPo(@PathVariable(value ="orderId") String orderId,Model model) {
		String orderFlag = "orderDetail";
		Order order= orderListService.findOrderByPk(orderId);
		model.addAttribute("order", order);
		model.addAttribute("orderFlag", orderFlag);
		return "forward:/order/orderPoUpdate"; 
	}
	
	/**
	 * TSCステータスを「お渡し済」に変更する、保存完了後、「オーダー登録結果」画面へ遷移する
	 * @param orderId
	 * @param changeTscStatus
	 * @return
	 */
	@RequestMapping(value = "/changeStatus/{orderId}/{changeTscStatus}")
	public String changeStatus(@PathVariable(value ="orderId") String orderId,
							   @PathVariable(value ="changeTscStatus") String changeTscStatus,Model model) {
		
		//最終更新者
		String updatedUserId = sessionContent.getUserId();
		//最終更新日時
		Date updatedAt = new Date();
		orderListService.updateTscStatus(orderId,changeTscStatus,updatedUserId,updatedAt);
		
		String isUpdate = "1";
		model.addAttribute("isUpdate",isUpdate);
		return "order/orderPoLoginResultForm";
	}
	
	/**
	 * 生地使用量・出荷日・船積日の保存を行う、保存完了後、「オーダー登録結果」画面へ遷移する
	 * @param orderId
	 * @param fabricNo
	 * @param fabricUsedMount
	 * @param shippingDate
	 * @param loadingDate
	 * @return
	 */
	@RequestMapping(value = "/saveValue")
	public String saveValue(String orderId,String fabricNo,String fabricUsedMount,String shippingDate,String loadingDate,Model model) {
		
		BigDecimal fabricUsedMountD;
		if(fabricUsedMount == null || "".equals(fabricUsedMount)) {
			fabricUsedMountD = null;
		}else {
			fabricUsedMountD =  new BigDecimal(fabricUsedMount);
		}
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date shippingDateD;
		Date loadingDateD;
		try {
			if(shippingDate == null || "".equals(shippingDate)) {
				shippingDateD = null;
			}
			else {
				shippingDateD = sdf.parse(shippingDate);
			}
			if(loadingDate == null || "".equals(loadingDate)) {
				loadingDateD = null;
			}
			else {
				loadingDateD = sdf.parse(loadingDate);
			}
			
			//最終更新者
			String updatedUserId = sessionContent.getUserId();
			//最終更新日時
			Date updatedAt = new Date();
			orderListService.updateSaveValue(orderId,fabricUsedMountD,shippingDateD,loadingDateD,updatedUserId,updatedAt);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		
		OrderDetail selectActualStock = orderDetailService.selectActualStock(fabricNo);
		BigDecimal actualStock = selectActualStock.getActualStock();
		String fabricId = selectActualStock.getFabricId();
		BigDecimal remainActualStock;
		if(fabricUsedMountD == null || "".equals(fabricUsedMount)) {
			remainActualStock =actualStock.subtract(new BigDecimal(0.0));
		}
		else {
			remainActualStock =actualStock.subtract(fabricUsedMountD);
		}
		
		//最終更新者
		String updatedUserId = sessionContent.getUserId();
		//最終更新日時
		Date updatedAt = new Date();
		orderDetailService.updateActualStock(fabricId, remainActualStock,updatedUserId,updatedAt);
		
		String isUpdate = "1";
		model.addAttribute("isUpdate",isUpdate);
		return "order/orderPoLoginResultForm";
	}
	
	/**
	 * ステータスを「生産終了」に変更する、生地使用量・出荷日・船積日の保存を行う、保存完了後、「オーダー登録結果」画面へ遷移する
	 * @param orderId
	 * @param fabricUsedMount
	 * @param shippingDate
	 * @param loadingDate
	 * @param makerFactoryStatus
	 * @return
	 */
	@RequestMapping(value = "/saveOrChangeValue/{orderId}/{fabricNo}/{fabricUsedMount}/{shippingDate}/{loadingDate}/{makerFactoryStatus}")
	public String saveOrChangeValue(@PathVariable(value ="orderId") String orderId,
									@PathVariable(value ="fabricNo") String fabricNo,
									@PathVariable(value ="fabricUsedMount") String fabricUsedMount,
									@PathVariable(value ="shippingDate") String shippingDate,
									@PathVariable(value ="loadingDate") String loadingDate,
									@PathVariable(value ="makerFactoryStatus") String makerFactoryStatus,Model model) {
		
		BigDecimal fabricUsedMountD = new BigDecimal(fabricUsedMount);
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date shippingDateD;
		Date loadingDateD;
		try {
			shippingDateD = sdf.parse(shippingDate);
			loadingDateD = sdf.parse(loadingDate);
			//最終更新者
			String updatedUserId = sessionContent.getUserId();
			//最終更新日時
			Date updatedAt = new Date();
			orderListService.updateSaveOrChangeValue(orderId,fabricUsedMountD,shippingDateD,loadingDateD,makerFactoryStatus,updatedUserId,updatedAt);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		
		OrderDetail selectActualStock = orderDetailService.selectActualStock(fabricNo);
		BigDecimal actualStock = selectActualStock.getActualStock();
		String fabricId = selectActualStock.getFabricId();
		BigDecimal remainActualStock =actualStock.subtract(fabricUsedMountD);
		//最終更新者
		String updatedUserId = sessionContent.getUserId();
		//最終更新日時
		Date updatedAt = new Date();
		orderDetailService.updateActualStock(fabricId, remainActualStock,updatedUserId,updatedAt);
		
		String isUpdate = "1";
		model.addAttribute("isUpdate",isUpdate);
		return "order/orderPoLoginResultForm";
	}
	
	/**
	 *下代自動計算
	 * @param orderId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "nextGenerationCount")
	public Integer saveOrChangeValue(String orderId) {
		OrderHelper orderHelper = new OrderHelper();
		Order order= orderListService.findOrderByPk(orderId);
		
		List<NextGenerationPrice> yieldList = this.getYieldList();
		List<NextGenerationPrice> wholesalePieceList = this.getWholesalePieceList(order);
		List<NextGenerationPrice> basicNextGenerationPriceList = this.basicNextGenerationPrice(order);
		NextGenerationPrice marginRate = this.getMarginRate(order);
		NextGenerationPrice priceCode = this.getPriceCode(order);
		
		Integer nextGenerationRelationCount = orderHelper.nextGenerationRelationCount(order, yieldList, wholesalePieceList,basicNextGenerationPriceList, priceCode, marginRate);
		return nextGenerationRelationCount;
	}
	
	/**
	 * 下代価格を保存する、保存完了後、「オーダー登録結果」画面へ遷移する
	 * @param orderId
	 * @param nextGenerationPrice
	 * @return
	 */
	@RequestMapping(value = "/nextGenerationPrice/{orderId}/{nextGenerationPrice}")
	public String nextGenerationSave(@PathVariable(value ="orderId") String orderId,
									 @PathVariable(value ="nextGenerationPrice") String nextGenerationPrice,Model model) {
		
		Integer nextGenerationP = Integer.parseInt(nextGenerationPrice);
		//最終更新者
		String updatedUserId = sessionContent.getUserId();
		//最終更新日時
		Date updatedAt = new Date();
		orderListService.updateNextGeneration(orderId,nextGenerationP,updatedUserId,updatedAt);
		
		String isUpdate = "1";
		model.addAttribute("isUpdate",isUpdate);
		return "order/orderPoLoginResultForm";
	}
	
	/**
	 * 
	 * @param productFabricNo
	 * @param fabricUsedMountValue
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "decideFabricUsedMount")
	public boolean decideFabricUsedMount(String productFabricNo,String fabricUsedMountValue,String orderId) {
		Order order= orderListService.findOrderByPk(orderId);
		BigDecimal fabricUsedMountOrder = order.getFabricUsedMount();
		if(fabricUsedMountOrder == null) {
			OrderDetail selectActualStock = orderDetailService.selectActualStock(productFabricNo);
			BigDecimal actualStock = selectActualStock.getActualStock();
			BigDecimal fabricUsedMount = new BigDecimal(fabricUsedMountValue);
			int compareTo = actualStock.compareTo(fabricUsedMount);
			if(compareTo > 0) {
				return true;
			}
		}
		else{
			//実在庫を修正する
			OrderDetail selectActualStock = orderDetailService.selectActualStock(productFabricNo);
			BigDecimal actualStock = selectActualStock.getActualStock();
			BigDecimal actualStockAddOrder = actualStock.add(fabricUsedMountOrder);
			String fabricId = selectActualStock.getFabricId();
			String updatedUserId = sessionContent.getUserId();
			Date updatedAt = new Date();
			orderDetailService.updateActualStock(fabricId,actualStockAddOrder,updatedUserId,updatedAt);
			
			OrderDetail selectRecoveryActualStock = orderDetailService.selectActualStock(productFabricNo);
			BigDecimal recoveryActualStock = selectRecoveryActualStock.getActualStock();
			BigDecimal fabricUsedMount = new BigDecimal(fabricUsedMountValue);
			int compareTo = recoveryActualStock.compareTo(fabricUsedMount);
			if(compareTo > 0) {
				return true;
			}
		}
		
	return false;
	}
}
