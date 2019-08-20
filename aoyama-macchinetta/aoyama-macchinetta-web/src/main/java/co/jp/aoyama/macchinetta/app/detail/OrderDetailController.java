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
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.order.OrderHelper;
import co.jp.aoyama.macchinetta.app.order.enums.LogItemClassEnum;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderDetail;
import co.jp.aoyama.macchinetta.domain.model.Shop;
import co.jp.aoyama.macchinetta.domain.model.Stock;
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
	public List<NextGenerationPrice> getYieldList(Order order){
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
	@RequestMapping(value = "/orderPoDetail")
	public String orderPoDetail(Model model,Map<String, Object> map) {
		// 店舗を取得
		List<Shop> shopList = shopService.findAllShop();
		
		Map<String, String> mapShop = new HashMap<String,String>();
		for (Shop shop : shopList) {
			mapShop.put(shop.getShopCode(), shop.getShopName());
		}
		map.put("mapShop", mapShop);
		return "detail/orderPoDetail";
	}
	
    /**
   	* 全部注文を条件検索.
     * @param form 画面Form
     * @return 注文情報リスト
     */
	@RequestMapping(value = "/orderCoDetail")
	public String orderCoDetail(Model model,Map<String, Object> map) {
		// 店舗を取得
		List<Shop> shopList = shopService.findAllShop();
		
		Map<String, String> mapShop = new HashMap<String,String>();
		for (Shop shop : shopList) {
			mapShop.put(shop.getShopCode(), shop.getShopName());
		}
		map.put("mapShop", mapShop);
		return "detail/orderCoDetail";
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//名簿納期
		Date custDeliverDate = order.getCustDeliverDate();
		if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
			String custDeliverDateFormat = sdf.format(custDeliverDate);
			Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
			order.setCustDeliverDate(custDeliverDateParse);
		}
		//お渡し日
		Date custShopDeliveryDate = order.getCustShopDeliveryDate();
		if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
			String custShopDeliveryDateFormat = sdf.format(custShopDeliveryDate);
			Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
			order.setCustShopDeliveryDate(custShopDeliveryDateParse);
		}
		//出荷日
		Date shippingDate = order.getShippingDate();
		if(shippingDate != null && !"".equals(shippingDate.toString())) {
			String shippingDateFormat = sdf.format(shippingDate);
			Date shippingDateParse = java.sql.Date.valueOf(shippingDateFormat);
			order.setShippingDate(shippingDateParse);
		}
		//積載日
		Date loadingDate = order.getLoadingDate();
		if(loadingDate != null && !"".equals(loadingDate.toString())) {
			String loadingDateFormat = sdf.format(loadingDate);
			Date loadingDateParse = java.sql.Date.valueOf(loadingDateFormat);
			order.setLoadingDate(loadingDateParse);
		}
		//注文承り日
		Date productOrderdDate = order.getProductOrderdDate();
		if(productOrderdDate != null && !"".equals(productOrderdDate.toString())) {
			String productOrderdDateFormat = sdf.format(productOrderdDate);
			Date productOrderdDateParse = java.sql.Date.valueOf(productOrderdDateFormat);
			order.setProductOrderdDate(productOrderdDateParse);
		}
		model.addAttribute("order", order);
		model.addAttribute("orderFlag", orderFlag);
		return "forward:/order/orderPoUpdate"; 
	}
	
	
	/**
	 *「オーダー登録」画面へ遷移する
	 * @param orderId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/orderDetailToOrderPo/{orderId}")
	public String orderDetailToOrderPo(@PathVariable(value ="orderId") String orderId,Model model) {
		String orderFlag = "orderLink";
		model.addAttribute("orderFlag", orderFlag);
		Order order= orderListService.findOrderByPk(orderId);
		Measuring measuring = measuringService.selectByPrimaryKey(orderId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//名簿納期
		Date custDeliverDate = order.getCustDeliverDate();
		if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
			String custDeliverDateFormat = sdf.format(custDeliverDate);
			Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
			order.setCustDeliverDate(custDeliverDateParse);
		}
		//お渡し日
		Date custShopDeliveryDate = order.getCustShopDeliveryDate();
		if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
			String custShopDeliveryDateFormat = sdf.format(custShopDeliveryDate);
			Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
			order.setCustShopDeliveryDate(custShopDeliveryDateParse);
		}
		//出荷日
		Date shippingDate = order.getShippingDate();
		if(shippingDate != null && !"".equals(shippingDate.toString())) {
			String shippingDateFormat = sdf.format(shippingDate);
			Date shippingDateParse = java.sql.Date.valueOf(shippingDateFormat);
			order.setShippingDate(shippingDateParse);
		}
		//積載日
		Date loadingDate = order.getLoadingDate();
		if(loadingDate != null && !"".equals(loadingDate.toString())) {
			String loadingDateFormat = sdf.format(loadingDate);
			Date loadingDateParse = java.sql.Date.valueOf(loadingDateFormat);
			order.setLoadingDate(loadingDateParse);
		}
		//注文承り日
		Date productOrderdDate = order.getProductOrderdDate();
		if(productOrderdDate != null && !"".equals(productOrderdDate.toString())) {
			String productOrderdDateFormat = sdf.format(productOrderdDate);
			Date productOrderdDateParse = java.sql.Date.valueOf(productOrderdDateFormat);
			order.setProductOrderdDate(productOrderdDateParse);
		}
		model.addAttribute("order", order);
		model.addAttribute("measuring", measuring);
		return "forward:/order/orderPoUpdate"; 
	}
	
	
	/**
	 * TSCステータスを「お渡し済」に変更する、保存完了後、「オーダー登録結果」画面へ遷移する
	 * @param orderId
	 * @param changeTscStatus
	 * @return
	 */
	@RequestMapping(value = "/changeStatus/{orderId}/{changeTscStatus}/{orderVersion}")
	public String changeStatus(@PathVariable(value ="orderId") String orderId,
							   @PathVariable(value ="changeTscStatus") String changeTscStatus,
							   @PathVariable(value = "orderVersion") String orderVersion,Model model) {
		
		//最終更新者
		String updatedUserId = sessionContent.getUserId();
		//最終更新日時
		Date updatedAt = new Date();
		Short orderVersionS = Short.parseShort(orderVersion);
		try {
			orderListService.updateTscStatus(orderId,changeTscStatus,updatedUserId,updatedAt,orderVersionS);
			String isUpdate = "1";
			model.addAttribute("isUpdate",isUpdate);
			return "order/orderPoLoginResultForm";
		} catch (ResourceNotFoundException e) {
			String authority = sessionContent.getAuthority();
			Order order= orderListService.findOrderByPk(orderId);
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			//名簿納期
			Date custDeliverDate = order.getCustDeliverDate();
			if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
				String custDeliverDateFormat = sdformat.format(custDeliverDate);
				Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
				order.setCustDeliverDate(custDeliverDateParse);
			}
			//お渡し日
			Date custShopDeliveryDate = order.getCustShopDeliveryDate();
			if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
				String custShopDeliveryDateFormat = sdformat.format(custShopDeliveryDate);
				Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
				order.setCustShopDeliveryDate(custShopDeliveryDateParse);
			}
			//出荷日
			Date shippingDateOrder = order.getShippingDate();
			if(shippingDateOrder != null && !"".equals(shippingDateOrder.toString())) {
				String shippingDateFormat = sdformat.format(shippingDateOrder);
				Date shippingDateParse = java.sql.Date.valueOf(shippingDateFormat);
				order.setShippingDate(shippingDateParse);
			}
			//積載日
			Date loadingDateOrder = order.getLoadingDate();
			if(loadingDateOrder != null && !"".equals(loadingDateOrder.toString())) {
				String loadingDateFormat = sdformat.format(loadingDateOrder);
				Date loadingDateParse = java.sql.Date.valueOf(loadingDateFormat);
				order.setLoadingDate(loadingDateParse);
			}
			//注文承り日
			Date productOrderdDate = order.getProductOrderdDate();
			if(productOrderdDate != null && !"".equals(productOrderdDate.toString())) {
				String productOrderdDateFormat = sdformat.format(productOrderdDate);
				Date productOrderdDateParse = java.sql.Date.valueOf(productOrderdDateFormat);
				order.setProductOrderdDate(productOrderdDateParse);
			}
			Measuring measuring = measuringService.selectByPrimaryKey(orderId);
			model.addAttribute("resultMessages", e.getResultMessages());
			model.addAttribute("order",order);
			model.addAttribute("measuring", measuring);
			model.addAttribute("userId", updatedUserId);
			model.addAttribute("authority", authority);
			return "detail/orderPoDetail";
		}
		
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
	public String saveValue(String orderId,String fabricNo,String fabricUsedMount,String shippingDate,String loadingDate,String orderVersion,Model model) {
		
		BigDecimal fabricUsedMountD;
		if(fabricUsedMount == null || "".equals(fabricUsedMount)) {
			fabricUsedMountD = null;
		}else {
			fabricUsedMountD =  new BigDecimal(fabricUsedMount);
		}
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy/MM/dd");
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
			Order order= orderListService.findOrderByPk(orderId);
			Date oldShippingDate = order.getShippingDate();
			//出荷連携ステータス　0：未送信
			String shippingTransmitStatus0 = "0";
			//出荷連携ステータス　2：再送信
			String shippingTransmitStatus2 = "2";
			//最終更新者
			String updatedUserId = sessionContent.getUserId();
			//最終更新日時
			Date updatedAt = new Date();
			Short orderVersionS = Short.parseShort(orderVersion);
			
			//商品情報_ITEM(ログ用)
			String item = LogItemClassEnum.getLogItem(order);
			Stock stock = orderService.getStock(fabricNo,order.getOrderPattern());
			logger.info("オーダー登録確認明細で在庫マスタ情報を更新する。更新前：「注文パターン：" + order.getOrderPattern() 
			+ "、注文ID："+order.getOrderId()  
			+ "、ITEM："+item 
			+ "、生地品番："+fabricNo
			+ "、実在庫："+stock.getActualStock() + "」");
			
			if(oldShippingDate == null && shippingDateD != null) {
				orderListService.updateSaveValueAndStatus(orderId,fabricUsedMountD,shippingDateD,loadingDateD,updatedUserId,updatedAt,orderVersionS,shippingTransmitStatus0);
			}
			else if(oldShippingDate != null && shippingDateD != null && oldShippingDate.compareTo(shippingDateD) != 0) {
				orderListService.updateSaveValueAndStatus(orderId,fabricUsedMountD,shippingDateD,loadingDateD,updatedUserId,updatedAt,orderVersionS,shippingTransmitStatus2);
			}
			else if(oldShippingDate != null && shippingDateD != null && oldShippingDate.compareTo(shippingDateD) == 0) {
				orderListService.updateSaveValue(orderId,fabricUsedMountD,shippingDateD,loadingDateD,updatedUserId,updatedAt,orderVersionS);
			}
			else if(oldShippingDate == null && shippingDateD == null) {
				orderListService.updateSaveValue(orderId,fabricUsedMountD,shippingDateD,loadingDateD,updatedUserId,updatedAt,orderVersionS);
			}
			
			Stock stockAfter = orderService.getStock(fabricNo,order.getOrderPattern());
			logger.info("オーダー登録確認明細で在庫マスタ情報を更新する。更新後：「注文パターン：" + order.getOrderPattern() 
			+ "、注文ID："+order.getOrderId()  
			+ "、ITEM："+item 
			+ "、生地品番："+fabricNo
			+ "、実在庫："+stockAfter.getActualStock() + "」");
			
			
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error(e.toString());
		} catch (ResourceNotFoundException e) {
			String authority = sessionContent.getAuthority();
			Order order= orderListService.findOrderByPk(orderId);
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			//名簿納期
			Date custDeliverDate = order.getCustDeliverDate();
			if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
				String custDeliverDateFormat = sdformat.format(custDeliverDate);
				Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
				order.setCustDeliverDate(custDeliverDateParse);
			}
			//お渡し日
			Date custShopDeliveryDate = order.getCustShopDeliveryDate();
			if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
				String custShopDeliveryDateFormat = sdformat.format(custShopDeliveryDate);
				Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
				order.setCustShopDeliveryDate(custShopDeliveryDateParse);
			}
			//出荷日
			Date shippingDateOrder = order.getShippingDate();
			if(shippingDateOrder != null && !"".equals(shippingDateOrder.toString())) {
				String shippingDateFormat = sdformat.format(shippingDateOrder);
				Date shippingDateParse = java.sql.Date.valueOf(shippingDateFormat);
				order.setShippingDate(shippingDateParse);
			}
			//積載日
			Date loadingDateOrder = order.getLoadingDate();
			if(loadingDateOrder != null && !"".equals(loadingDateOrder.toString())) {
				String loadingDateFormat = sdformat.format(loadingDateOrder);
				Date loadingDateParse = java.sql.Date.valueOf(loadingDateFormat);
				order.setLoadingDate(loadingDateParse);
			}
			//注文承り日
			Date productOrderdDate = order.getProductOrderdDate();
			if(productOrderdDate != null && !"".equals(productOrderdDate.toString())) {
				String productOrderdDateFormat = sdformat.format(productOrderdDate);
				Date productOrderdDateParse = java.sql.Date.valueOf(productOrderdDateFormat);
				order.setProductOrderdDate(productOrderdDateParse);
			}
			Measuring measuring = measuringService.selectByPrimaryKey(orderId);
			model.addAttribute("resultMessages", e.getResultMessages());
			model.addAttribute("order",order);
			model.addAttribute("measuring", measuring);
			model.addAttribute("authority", authority);
			return "detail/orderPoDetail";
		}
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
	@RequestMapping(value = "/saveOrChangeValue")
	public String saveOrChangeValue(String orderId, String fabricNo, String fabricUsedMount, String shippingDate, String loadingDate, String makerFactoryStatus,
									 String orderVersion,Model model) {
		
		BigDecimal fabricUsedMountD = new BigDecimal(fabricUsedMount);
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date shippingDateD;
		Date loadingDateD;
		try {
			shippingDateD = sdf.parse(shippingDate);
			loadingDateD = sdf.parse(loadingDate);
			Order order= orderListService.findOrderByPk(orderId);
			Date oldShippingDate = order.getShippingDate();
			//出荷連携ステータス　0：未送信
			String shippingTransmitStatus0 = "0";
			//出荷連携ステータス　2：再送信
			String shippingTransmitStatus2 = "2";
			//最終更新者
			String updatedUserId = sessionContent.getUserId();
			//最終更新日時
			Date updatedAt = new Date();
			Short orderVersionS = Short.parseShort(orderVersion);
			
			//商品情報_ITEM(ログ用)
			String item = LogItemClassEnum.getLogItem(order);
			Stock stock = orderService.getStock(fabricNo,order.getOrderPattern());
			logger.info("オーダー登録確認明細で在庫マスタ情報を更新する。更新前：「注文パターン：" + order.getOrderPattern() 
			+ "、注文ID："+order.getOrderId()  
			+ "、ITEM："+item 
			+ "、生地品番："+fabricNo
			+ "、実在庫："+stock.getActualStock() + "」");
			
			if(oldShippingDate == null) {
				orderListService.updateSaveOrChangeValueAndStatus(orderId,fabricUsedMountD,shippingDateD,loadingDateD,makerFactoryStatus,updatedUserId,updatedAt,orderVersionS,shippingTransmitStatus0);
			}
			else if(oldShippingDate != null && oldShippingDate.compareTo(shippingDateD) != 0) {
				orderListService.updateSaveOrChangeValueAndStatus(orderId,fabricUsedMountD,shippingDateD,loadingDateD,makerFactoryStatus,updatedUserId,updatedAt,orderVersionS,shippingTransmitStatus2);
			}
			else if(oldShippingDate != null && oldShippingDate.compareTo(shippingDateD) == 0) {
				orderListService.updateSaveOrChangeValue(orderId,fabricUsedMountD,shippingDateD,loadingDateD,makerFactoryStatus,updatedUserId,updatedAt,orderVersionS);
			}
			
			Stock stockAfter = orderService.getStock(fabricNo,order.getOrderPattern());
			logger.info("オーダー登録確認明細で在庫マスタ情報を更新する。更新後：「注文パターン：" + order.getOrderPattern() 
			+ "、注文ID："+order.getOrderId()  
			+ "、ITEM："+item 
			+ "、生地品番："+fabricNo
			+ "、実在庫："+stockAfter.getActualStock() + "」");
			
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}catch(ResourceNotFoundException e) {
			String authority = sessionContent.getAuthority();
			Order order= orderListService.findOrderByPk(orderId);
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			//名簿納期
			Date custDeliverDate = order.getCustDeliverDate();
			if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
				String custDeliverDateFormat = sdformat.format(custDeliverDate);
				Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
				order.setCustDeliverDate(custDeliverDateParse);
			}
			//お渡し日
			Date custShopDeliveryDate = order.getCustShopDeliveryDate();
			if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
				String custShopDeliveryDateFormat = sdformat.format(custShopDeliveryDate);
				Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
				order.setCustShopDeliveryDate(custShopDeliveryDateParse);
			}
			//出荷日
			Date shippingDateOrder = order.getShippingDate();
			if(shippingDateOrder != null && !"".equals(shippingDateOrder.toString())) {
				String shippingDateFormat = sdformat.format(shippingDateOrder);
				Date shippingDateParse = java.sql.Date.valueOf(shippingDateFormat);
				order.setShippingDate(shippingDateParse);
			}
			//積載日
			Date loadingDateOrder = order.getLoadingDate();
			if(loadingDateOrder != null && !"".equals(loadingDateOrder.toString())) {
				String loadingDateFormat = sdformat.format(loadingDateOrder);
				Date loadingDateParse = java.sql.Date.valueOf(loadingDateFormat);
				order.setLoadingDate(loadingDateParse);
			}
			//注文承り日
			Date productOrderdDate = order.getProductOrderdDate();
			if(productOrderdDate != null && !"".equals(productOrderdDate.toString())) {
				String productOrderdDateFormat = sdformat.format(productOrderdDate);
				Date productOrderdDateParse = java.sql.Date.valueOf(productOrderdDateFormat);
				order.setProductOrderdDate(productOrderdDateParse);
			}
			Measuring measuring = measuringService.selectByPrimaryKey(orderId);
			model.addAttribute("resultMessages", e.getResultMessages());
			model.addAttribute("order",order);
			model.addAttribute("measuring", measuring);
			model.addAttribute("authority", authority);
			return "detail/orderPoDetail";
		}
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
	public String saveOrChangeValue(String orderId, Model model) {
		OrderHelper orderHelper = new OrderHelper();
		ResultMessages resultMessages = null;
		try {
			Order order= orderListService.findOrderByPk(orderId);
			List<NextGenerationPrice> yieldList = this.getYieldList(order);
			List<NextGenerationPrice> wholesalePieceList = this.getWholesalePieceList(order);
			List<NextGenerationPrice> basicNextGenerationPriceList = this.basicNextGenerationPrice(order);
			NextGenerationPrice marginRate = this.getMarginRate(order);
			NextGenerationPrice priceCode = this.getPriceCode(order);
			
			String nextGenerationRelationCount = orderHelper.nextGenerationRelationCount(order, yieldList, wholesalePieceList,basicNextGenerationPriceList, priceCode, marginRate).toString();
			return nextGenerationRelationCount;
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			resultMessages = e.getResultMessages();
		}
		
		if(resultMessages==null) {
			return "";
		}else {
			String code = resultMessages.getList().get(0).getCode();
			if("E020".equals(code)) {
				return "1";
			}else {
				return "2";
			}
		}
		
	}
	
	/**
	 * 下代価格を保存する、保存完了後、「オーダー登録結果」画面へ遷移する
	 * @param orderId
	 * @param nextGenerationPrice
	 * @return
	 */
	@RequestMapping(value = "/nextGenerationPrice/{orderId}/{nextGenerationPrice}/{orderVersion}/{status}")
	public String nextGenerationSave(@PathVariable(value ="orderId") String orderId,
									 @PathVariable(value ="nextGenerationPrice") String nextGenerationPrice,
									 @PathVariable(value = "orderVersion") String orderVersion,
									 @PathVariable(value = "status")String status,Model model) {
		
		Integer nextGenerationP = Integer.parseInt(nextGenerationPrice);
		//最終更新者
		String updatedUserId = sessionContent.getUserId();
		//最終更新日時
		Date updatedAt = new Date();
		Short orderVersionS = Short.parseShort(orderVersion);
		try {
			Order order= orderListService.findOrderByPk(orderId);
			Integer wsPrice = order.getWsPrice();
			String scheduleDataTransmitStatus = "2";
			if("T5".equals(status)) {
				if(!wsPrice.equals(nextGenerationP)) {
					orderListService.updateNextGenerationAndStatus(orderId,nextGenerationP,updatedUserId,updatedAt,orderVersionS,scheduleDataTransmitStatus);
				}
			}
			else {
				orderListService.updateNextGeneration(orderId,nextGenerationP,updatedUserId,updatedAt,orderVersionS);
			}
			
			String isUpdate = "1";
			model.addAttribute("isUpdate",isUpdate);
			return "order/orderPoLoginResultForm";
		} catch (ResourceNotFoundException e) {
			String authority = sessionContent.getAuthority();
			Order order= orderListService.findOrderByPk(orderId);
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			//名簿納期
			Date custDeliverDate = order.getCustDeliverDate();
			if(custDeliverDate!=null && !"".equals(custDeliverDate.toString())) {
				String custDeliverDateFormat = sdformat.format(custDeliverDate);
				Date custDeliverDateParse = java.sql.Date.valueOf(custDeliverDateFormat);
				order.setCustDeliverDate(custDeliverDateParse);
			}
			//お渡し日
			Date custShopDeliveryDate = order.getCustShopDeliveryDate();
			if(custShopDeliveryDate != null && !"".equals(custShopDeliveryDate.toString())) {
				String custShopDeliveryDateFormat = sdformat.format(custShopDeliveryDate);
				Date custShopDeliveryDateParse = java.sql.Date.valueOf(custShopDeliveryDateFormat);
				order.setCustShopDeliveryDate(custShopDeliveryDateParse);
			}
			//出荷日
			Date shippingDateOrder = order.getShippingDate();
			if(shippingDateOrder != null && !"".equals(shippingDateOrder.toString())) {
				String shippingDateFormat = sdformat.format(shippingDateOrder);
				Date shippingDateParse = java.sql.Date.valueOf(shippingDateFormat);
				order.setShippingDate(shippingDateParse);
			}
			//積載日
			Date loadingDateOrder = order.getLoadingDate();
			if(loadingDateOrder != null && !"".equals(loadingDateOrder.toString())) {
				String loadingDateFormat = sdformat.format(loadingDateOrder);
				Date loadingDateParse = java.sql.Date.valueOf(loadingDateFormat);
				order.setLoadingDate(loadingDateParse);
			}
			//注文承り日
			Date productOrderdDate = order.getProductOrderdDate();
			if(productOrderdDate != null && !"".equals(productOrderdDate.toString())) {
				String productOrderdDateFormat = sdformat.format(productOrderdDate);
				Date productOrderdDateParse = java.sql.Date.valueOf(productOrderdDateFormat);
				order.setProductOrderdDate(productOrderdDateParse);
			}
			Measuring measuring = measuringService.selectByPrimaryKey(orderId);
			model.addAttribute("resultMessages", e.getResultMessages());
			model.addAttribute("order",order);
			model.addAttribute("measuring", measuring);
			model.addAttribute("authority", authority);
			return "detail/orderPoDetail";
			
		}
		
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
			BigDecimal fabricUsedMount = new BigDecimal(fabricUsedMountValue);
			int compareTo = actualStockAddOrder.compareTo(fabricUsedMount);
			if(compareTo > 0) {
				return true;
			}
		}
		
	return false;
	}
}
