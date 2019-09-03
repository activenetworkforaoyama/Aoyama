package co.jp.aoyama.macchinetta.app.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.service.maker.MakerService;
import co.jp.aoyama.macchinetta.domain.service.order.NextGenerationService;
import co.jp.aoyama.macchinetta.domain.service.order.OptionBranchDeailService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;

@Controller
@RequestMapping("/orderCoConfirm")
@SessionAttributes(value = {"orderForm"})
public class OrderCoReconfirmController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderCoReconfirmController.class);
	
	@Inject
	OptionBranchDeailService optionBranchDeailService;
	
	@Inject
	NextGenerationService nextGenerationService;
	
	@Inject
	OrderListService orderListService;
	
	@Inject
	OrderService orderService;
	
	@Inject
	MakerService makerService;
	
	@Inject
	Mapper standardBeanMapper;
	
	@Inject
	Mapper tuxedoBeanMapper;
	
	@Inject
	Mapper washableBeanMapper;

	@Inject
	SessionContent sessionContent;
	
	private OrderHelper orderHelper = new OrderHelper();
	
	@ModelAttribute(value = "orderForm")
	public OrderForm setUpOrderForm() {
		return new OrderForm();
	}

	@RequestMapping(value = "orderCoReForm")
	public String toOrderCoReForm(OrderForm orderForm,Model model,Map<String, Map<String, Integer>> map) {
//		String status = orderForm.getStatus();
//		if("T2".equals(status) || "T3".equals(status) || "T4".equals(status) || "T5".equals(status)) {
//			//注文ID
//			String orderId = orderForm.getCustomerMessageInfo().getOrderId();
//			//注文
//			Order order = orderListService.findOrderByPk(orderId);
//			Date productOrderdDate = order.getProductOrderdDate();
//			if(productOrderdDate != null) {
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String productOrderdDateFormat = sdf.format(productOrderdDate);
//				model.addAttribute("productOrderdDateFormat",productOrderdDateFormat);
//			}
//		}
//		Map<String, Integer> retailPriceRelatedProjects = this.retailPriceRelatedCoProjects(orderForm);
//		OrderFindFabric findStock = this.findStock(orderForm);
//		String color = findStock.getColor();
//		String pattern = findStock.getPattern();
//		model.addAttribute("color",color);
//		model.addAttribute("pattern",pattern);
//		map.put("priceMap", retailPriceRelatedProjects);
		String productCategory = orderForm.getProductCategory();
		if("0".equals(productCategory)) {
			String productItem = orderForm.getProductItem();
			List<OptionBranchDetail> mateList = this.getMateList(orderForm);
			List<OrderCodePrice> optionBranchPriceList = this.getOptionBranchPriceList(orderForm);
			if("01".equals(productItem)) {
				String productIs3Piece = orderForm.getProductIs3Piece();
				String productSparePantsClass = orderForm.getProductSparePantsClass();
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				
				Map<String, String> standardJkMateSelectMap = this.standardJkMateSelect(mateList, orderForm);
				Map<String, String> standardPtMateSelectMap = this.standardPtMateSelect(mateList, orderForm);
				model.addAttribute("standardJkMateSelectMap",standardJkMateSelectMap);
				model.addAttribute("standardPtMateSelectMap",standardPtMateSelectMap);
				
				Map<String, String> pantsUpperPrice = this.getPantsUpperPrice(orderForm,optionBranchPriceList);
				Map<String, String> jacketUpperPrice = this.getJacketUpperPrice(orderForm, optionBranchPriceList);
				model.addAttribute("pantsUpperPrice",pantsUpperPrice);
				model.addAttribute("jacketUpperPrice",jacketUpperPrice);
				if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					Map<String, String> standardGlMateSelectMap = this.standardGlMateSelect(mateList, orderForm);
					Map<String, String> standardPt2MateSelectMap = this.standardPt2MateSelect(mateList, orderForm);
					model.addAttribute("standardGlMateSelectMap",standardGlMateSelectMap);
					model.addAttribute("standardPt2MateSelectMap",standardPt2MateSelectMap);
					
					Map<String, String> pants2UpperPrice = this.getPants2UpperPrice(orderForm,optionBranchPriceList);
					Map<String, String> giletUpperPrice = this.getGiletUpperPrice(orderForm, optionBranchPriceList);
					model.addAttribute("pants2UpperPrice",pants2UpperPrice);
					model.addAttribute("giletUpperPrice", giletUpperPrice);
				}
				else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					Map<String, String> standardPt2MateSelectMap = this.standardPt2MateSelect(mateList, orderForm);
					model.addAttribute("standardPt2MateSelectMap",standardPt2MateSelectMap);
					
					Map<String, String> pants2UpperPrice = this.getPants2UpperPrice(orderForm,optionBranchPriceList);
					model.addAttribute("pants2UpperPrice",pants2UpperPrice);
				}
				else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					Map<String, String> standardGlMateSelectMap = this.standardGlMateSelect(mateList, orderForm);
					model.addAttribute("standardGlMateSelectMap",standardGlMateSelectMap);
					
					Map<String, String> giletUpperPrice = this.getGiletUpperPrice(orderForm, optionBranchPriceList);
					model.addAttribute("giletUpperPrice", giletUpperPrice);
				}
			}
			else if("02".equals(productItem)) {
				Map<String, String> standardJkMateSelectMap = this.standardJkMateSelect(mateList, orderForm);
				model.addAttribute("standardJkMateSelectMap",standardJkMateSelectMap);

				Map<String, String> jacketUpperPrice = this.getJacketUpperPrice(orderForm, optionBranchPriceList);
				model.addAttribute("jacketUpperPrice",jacketUpperPrice);
			}
			else if("03".equals(productItem)) {
				Map<String, String> standardPtMateSelectMap = this.standardPtMateSelect(mateList, orderForm);
				model.addAttribute("standardPtMateSelectMap",standardPtMateSelectMap);
				
				Map<String, String> pantsUpperPrice = this.getPantsUpperPrice(orderForm,optionBranchPriceList);
				model.addAttribute("pantsUpperPrice",pantsUpperPrice);
			}
			else if("04".equals(productItem)) {
				Map<String, String> standardGlMateSelectMap = this.standardGlMateSelect(mateList, orderForm);
				model.addAttribute("standardGlMateSelectMap",standardGlMateSelectMap);
				
				Map<String, String> giletUpperPrice = this.getGiletUpperPrice(orderForm, optionBranchPriceList);
				model.addAttribute("giletUpperPrice", giletUpperPrice);
			}
			else if("05".equals(productItem)) {
				Map<String, String> shirtUpperPrice = this.getShirtUpperPrice(orderForm, optionBranchPriceList);
				model.addAttribute("shirtUpperPrice", shirtUpperPrice);
			}
			else if("06".equals(productItem)) {
				Map<String, String> standardCtMateSelectMap = this.standardCtMateSelect(mateList, orderForm);
				model.addAttribute("standardCtMateSelectMap",standardCtMateSelectMap);
				
				Map<String, String> coatUpperPrice = this.getCoatUpperPrice(orderForm, optionBranchPriceList);
				model.addAttribute("coatUpperPrice", coatUpperPrice);
			}
		}
		else if("2".equals(productCategory)) {
			String productItem = orderForm.getProductItem();
			List<OptionBranchDetail> tuxedoMateList = this.getTuxedoMateList(orderForm);
			List<OrderCodePrice> tuxedoOptionBranchPriceList = this.getTuxedoOptionBranchPriceList(orderForm);
			if("01".equals(productItem)) {
				String productIs3Piece = orderForm.getProductIs3Piece();
				String productSparePantsClass = orderForm.getProductSparePantsClass();
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				
				Map<String, String> tuxedoJkMateSelectMap = this.tuxedoJkMateSelect(tuxedoMateList, orderForm);
				Map<String, String> tuxedoPtMateSelectMap = this.tuxedoPtMateSelect(tuxedoMateList, orderForm);
				model.addAttribute("tuxedoJkMateSelectMap",tuxedoJkMateSelectMap);
				model.addAttribute("tuxedoPtMateSelectMap",tuxedoPtMateSelectMap);
				
				Map<String, String> tuxedoJacketUpperPrice = this.getTuxedoJacketUpperPrice(orderForm, tuxedoOptionBranchPriceList);
				Map<String, String> tuxedoPantsUpperPrice = this.getTuxedoPantsUpperPrice(orderForm, tuxedoOptionBranchPriceList);
				model.addAttribute("tuxedoJacketUpperPrice",tuxedoJacketUpperPrice);
				model.addAttribute("tuxedoPantsUpperPrice",tuxedoPantsUpperPrice);
				
				if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					Map<String, String> tuxedoGlMateSelectMap = this.tuxedoGlMateSelect(tuxedoMateList, orderForm);
					Map<String, String> tuxedoPt2MateSelectMap = this.tuxedoPt2MateSelect(tuxedoMateList, orderForm);
					model.addAttribute("tuxedoGlMateSelectMap",tuxedoGlMateSelectMap);
					model.addAttribute("tuxedoPt2MateSelectMap",tuxedoPt2MateSelectMap);
					
					Map<String, String> tuxedoGiletUpperPrice = this.getTuxedoGiletUpperPrice(orderForm, tuxedoOptionBranchPriceList);
					Map<String, String> tuxedoPants2UpperPrice = this.getTuxedoPants2UpperPrice(orderForm, tuxedoOptionBranchPriceList);
					model.addAttribute("tuxedoGiletUpperPrice",tuxedoGiletUpperPrice);
					model.addAttribute("tuxedoPants2UpperPrice",tuxedoPants2UpperPrice);
				}
				else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					Map<String, String> tuxedoPt2MateSelectMap = this.tuxedoPt2MateSelect(tuxedoMateList, orderForm);
					model.addAttribute("tuxedoPt2MateSelectMap",tuxedoPt2MateSelectMap);
					
					Map<String, String> tuxedoPants2UpperPrice = this.getTuxedoPants2UpperPrice(orderForm, tuxedoOptionBranchPriceList);
					model.addAttribute("tuxedoPants2UpperPrice",tuxedoPants2UpperPrice);
				}
				else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					Map<String, String> tuxedoGlMateSelectMap = this.tuxedoGlMateSelect(tuxedoMateList, orderForm);
					model.addAttribute("tuxedoGlMateSelectMap",tuxedoGlMateSelectMap);
					
					Map<String, String> tuxedoGiletUpperPrice = this.getTuxedoGiletUpperPrice(orderForm, tuxedoOptionBranchPriceList);
					model.addAttribute("tuxedoGiletUpperPrice",tuxedoGiletUpperPrice);
				}
			}
			else if("02".equals(productItem)) {
				Map<String, String> tuxedoJkMateSelectMap = this.tuxedoJkMateSelect(tuxedoMateList, orderForm);
				model.addAttribute("tuxedoJkMateSelectMap",tuxedoJkMateSelectMap);
				
				Map<String, String> tuxedoJacketUpperPrice = this.getTuxedoJacketUpperPrice(orderForm, tuxedoOptionBranchPriceList);
				model.addAttribute("tuxedoJacketUpperPrice",tuxedoJacketUpperPrice);

			}
			else if("03".equals(productItem)) {
				Map<String, String> tuxedoPtMateSelectMap = this.tuxedoPtMateSelect(tuxedoMateList, orderForm);
				model.addAttribute("tuxedoPtMateSelectMap",tuxedoPtMateSelectMap);
				
				Map<String, String> tuxedoPantsUpperPrice = this.getTuxedoPantsUpperPrice(orderForm, tuxedoOptionBranchPriceList);
				model.addAttribute("tuxedoPantsUpperPrice",tuxedoPantsUpperPrice);
				
			}
			else if("04".equals(productItem)) {
				Map<String, String> tuxedoGlMateSelectMap = this.tuxedoGlMateSelect(tuxedoMateList, orderForm);
				model.addAttribute("tuxedoGlMateSelectMap",tuxedoGlMateSelectMap);
				
				Map<String, String> tuxedoGiletUpperPrice = this.getTuxedoGiletUpperPrice(orderForm, tuxedoOptionBranchPriceList);
				model.addAttribute("tuxedoGiletUpperPrice",tuxedoGiletUpperPrice);
			}
		}
		else if("1".equals(productCategory)) {
			String productItem = orderForm.getProductItem();
			List<OptionBranchDetail> washableMateList = this.getWashableMateList(orderForm);
			List<OrderCodePrice> washableOptionBranchPriceList = this.getWashableOptionBranchPriceList(orderForm);
			if("01".equals(productItem)) {
				String productIs3Piece = orderForm.getProductIs3Piece();
				String productSparePantsClass = orderForm.getProductSparePantsClass();
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				
				Map<String, String> washableJkMateSelectMap = this.washableJkMateSelect(washableMateList, orderForm);
				Map<String, String> washablePtMateSelectMap = this.washablePtMateSelect(washableMateList, orderForm);
				model.addAttribute("washableJkMateSelectMap",washableJkMateSelectMap);
				model.addAttribute("washablePtMateSelectMap",washablePtMateSelectMap);
				
				Map<String, String> washableJacketUpperPrice = this.getWashableJacketUpperPrice(orderForm, washableOptionBranchPriceList);
				Map<String, String> washablePantsUpperPrice = this.getWashablePantsUpperPrice(orderForm, washableOptionBranchPriceList);
				model.addAttribute("washableJacketUpperPrice",washableJacketUpperPrice);
				model.addAttribute("washablePantsUpperPrice",washablePantsUpperPrice);
				
				if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					Map<String, String> washableGlMateSelectMap = this.washableGlMateSelect(washableMateList, orderForm);
					Map<String, String> washablePt2MateSelectMap = this.washablePt2MateSelect(washableMateList, orderForm);
					model.addAttribute("washableGlMateSelectMap",washableGlMateSelectMap);
					model.addAttribute("washablePt2MateSelectMap",washablePt2MateSelectMap);
					
					Map<String, String> washableGiletUpperPrice = this.getWashableGiletUpperPrice(orderForm, washableOptionBranchPriceList);
					Map<String, String> washablePants2UpperPrice = this.getWashablePants2UpperPrice(orderForm, washableOptionBranchPriceList);
					model.addAttribute("washableGiletUpperPrice",washableGiletUpperPrice);
					model.addAttribute("washablePants2UpperPrice",washablePants2UpperPrice);
				}
				else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					Map<String, String> washablePt2MateSelectMap = this.washablePt2MateSelect(washableMateList, orderForm);
					model.addAttribute("washablePt2MateSelectMap",washablePt2MateSelectMap);
					
					Map<String, String> washablePants2UpperPrice = this.getWashablePants2UpperPrice(orderForm, washableOptionBranchPriceList);
					model.addAttribute("washablePants2UpperPrice",washablePants2UpperPrice);
				}
				else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					Map<String, String> washableGlMateSelectMap = this.washableGlMateSelect(washableMateList, orderForm);
					model.addAttribute("washableGlMateSelectMap",washableGlMateSelectMap);
					
					Map<String, String> washableGiletUpperPrice = this.getWashableGiletUpperPrice(orderForm, washableOptionBranchPriceList);
					model.addAttribute("washableGiletUpperPrice",washableGiletUpperPrice);
				}
			}
			else if("02".equals(productItem)) {
				Map<String, String> washableJkMateSelectMap = this.washableJkMateSelect(washableMateList, orderForm);
				model.addAttribute("washableJkMateSelectMap",washableJkMateSelectMap);
				
				Map<String, String> washableJacketUpperPrice = this.getWashableJacketUpperPrice(orderForm, washableOptionBranchPriceList);
				model.addAttribute("washableJacketUpperPrice",washableJacketUpperPrice);
			}
			else if("03".equals(productItem)) {
				Map<String, String> washablePtMateSelectMap = this.washablePtMateSelect(washableMateList, orderForm);
				model.addAttribute("washablePtMateSelectMap",washablePtMateSelectMap);
				
				Map<String, String> washablePantsUpperPrice = this.getWashablePantsUpperPrice(orderForm, washableOptionBranchPriceList);
				model.addAttribute("washablePantsUpperPrice",washablePantsUpperPrice);
			}
			else if("04".equals(productItem)) {
				Map<String, String> washableGlMateSelectMap = this.washableGlMateSelect(washableMateList, orderForm);
				model.addAttribute("washableGlMateSelectMap",washableGlMateSelectMap);
				
				Map<String, String> washableGiletUpperPrice = this.getWashableGiletUpperPrice(orderForm, washableOptionBranchPriceList);
				model.addAttribute("washableGiletUpperPrice",washableGiletUpperPrice);
			}
		}
		return "order/orderCoReconfirmForm";
	}
	
	/**
	 * メーカーコードによる取得メーカーID
	 * @return
	 */
	public String findMakerId(OrderForm orderForm) throws ResourceNotFoundException{
		String fabricNo = orderForm.getProductFabricNo();
		String orderPattern = orderForm.getOrderPattern();
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		String makerCode = orderFindFabric.getMakerCode();
		Maker findMakerCd = makerService.findOne(makerCode);
		String makerId = findMakerCd.getMakerId();
		return makerId;
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
	
//	/**
//	 * 上代関連項目
//	 * @param orderForm
//	 * @return 
//	 */
//	public Map<String, Integer> retailPriceRelatedProjects(OrderForm orderForm) {
//		OrderHelper orderHelper = new OrderHelper();
//		String fabricNo = orderForm.getProductFabricNo();
//		String orderPattern = orderForm.getOrderPattern();
//		OrderFindFabric orderFabric = orderService.getOrderFabric(fabricNo, orderPattern);
//		Map<String, Integer> retailPriceRelatedMap = orderHelper.getRetailPriceRelated(orderFabric);
//		return retailPriceRelatedMap;
//	}
	
	/**
	 * 生地品番とオーダーパターンによって生地の情報を取得
	 * 
	 * @param fabricNo
	 * @param orderPattern
	 * 
	 */
	public OrderFindFabric findStock(OrderForm orderForm) {
		String fabricNo = orderForm.getProductFabricNo();
		String orderPattern = orderForm.getOrderPattern();
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		return orderFindFabric;
	}
	
	/**
	 * 上代関連項目
	 * @param orderForm
	 * @return 
	 */
	public Map<String, Integer> retailPriceRelatedCoProjects(OrderForm orderForm) {
		String fabricNo = orderForm.getProductFabricNo();
		String orderPattern = orderForm.getOrderPattern();
		OrderFindFabric orderFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		Map<String, Integer> retailPriceRelatedMap = orderHelper.getCoRetailPriceRelated(orderFabric);
		return retailPriceRelatedMap;
	}
	
	/**
	 *データベースで上代を取得
	 * @param orderForm
	 * @return
	 */
	public List<OrderCodePrice> getOptionBranchPriceList(OrderForm orderForm) {
		String orderPattern = orderForm.getOrderPattern();
		List<OrderPrice> priceList = orderService.getOrderPrice(orderPattern);
		List<OrderCodePrice> optionBranchPriceList = orderHelper.optionBranchPriceData(priceList);
		return optionBranchPriceList;
	}
	
	/**
	 * 標準のオーダー内容確認画面PANTSの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getPantsUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> standardPantsUpperPrice = orderHelper.standardPantsUpperPrice(orderForm, optionBranchPriceList);
		return standardPantsUpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面2PANTSの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getPants2UpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> standardPants2UpperPrice = orderHelper.standardPants2UpperPrice(orderForm, optionBranchPriceList);
		return standardPants2UpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面jacketの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getJacketUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> standardJacketUpperPrice = orderHelper.standardJacketUpperPrice(orderForm, optionBranchPriceList);
		return standardJacketUpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面giletの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getGiletUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> standardGiletUpperPrice = orderHelper.standardGiletUpperPrice(orderForm, optionBranchPriceList);
		return standardGiletUpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面coatの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getCoatUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> standardCoatUpperPrice = orderHelper.standardCoatUpperPrice(orderForm, optionBranchPriceList);
		return standardCoatUpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面shirtの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getShirtUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> standardShirtUpperPrice = orderHelper.standardShirtUpperPrice(orderForm, optionBranchPriceList);
		return standardShirtUpperPrice;
	}
	
	/**
	 *データベースでタキシード上代を取得
	 * @param orderForm
	 * @return
	 */
	public List<OrderCodePrice> getTuxedoOptionBranchPriceList(OrderForm orderForm) {
		String orderPattern = orderForm.getOrderPattern();
		List<OrderPrice> TuxedopriceList = orderService.getTuxedoOrderPrice(orderPattern);
		List<OrderCodePrice> optionBranchPriceList = orderHelper.optionBranchPriceData(TuxedopriceList);
		return optionBranchPriceList;
	}
	
	/**
	 * タキシードのオーダー内容確認画面jacketの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getTuxedoJacketUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> tuxedoJacketUpperPrice = orderHelper.tuxedoJacketUpperPrice(orderForm, optionBranchPriceList);
		return tuxedoJacketUpperPrice;
	}
	
	/**
	 * タキシードのオーダー内容確認画面giletの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getTuxedoGiletUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> tuxedoGiletUpperPrice = orderHelper.tuxedoGiletUpperPrice(orderForm, optionBranchPriceList);
		return tuxedoGiletUpperPrice;
	}
	
	/**
	 * タキシードのオーダー内容確認画面pantsの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getTuxedoPantsUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> tuxedoPantsUpperPrice = orderHelper.tuxedoPantsUpperPrice(orderForm, optionBranchPriceList);
		return tuxedoPantsUpperPrice;
	}
	
	/**
	 * タキシードのオーダー内容確認画面2pantsの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getTuxedoPants2UpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> tuxedoPants2UpperPrice = orderHelper.tuxedoPants2UpperPrice(orderForm, optionBranchPriceList);
		return tuxedoPants2UpperPrice;
	}
	
	/**
	 *データベースでウォッシャブル上代を取得
	 * @param orderForm
	 * @return
	 */
	public List<OrderCodePrice> getWashableOptionBranchPriceList(OrderForm orderForm) {
		String orderPattern = orderForm.getOrderPattern();
		List<OrderPrice> TuxedopriceList = orderService.getWashableOrderPrice(orderPattern);
		List<OrderCodePrice> optionBranchPriceList = orderHelper.optionBranchPriceData(TuxedopriceList);
		return optionBranchPriceList;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面jacketの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getWashableJacketUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> washableJacketUpperPrice = orderHelper.washableJacketUpperPrice(orderForm, optionBranchPriceList);
		return washableJacketUpperPrice;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面giletの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getWashableGiletUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> washableGiletUpperPrice = orderHelper.washableGiletUpperPrice(orderForm, optionBranchPriceList);
		return washableGiletUpperPrice;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面pantsの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getWashablePantsUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> washablePantsUpperPrice = orderHelper.washablePantsUpperPrice(orderForm, optionBranchPriceList);
		return washablePantsUpperPrice;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面2pantsの上代表示map
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public  Map<String, String> getWashablePants2UpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		Map<String, String> washablePants2UpperPrice = orderHelper.washablePants2UpperPrice(orderForm, optionBranchPriceList);
		return washablePants2UpperPrice;
	}
	
	/**
	 * 
	 * @param orderForm
	 * @return
	 */
	public List<OptionBranchDetail> getMateList(OrderForm orderForm) {
		
		String productItem = orderForm.getProductItem();
		String orderPattern = orderForm.getOrderPattern();
		List<OptionBranchDetail> mateList = optionBranchDeailService.getStandardButtonsList(productItem,orderPattern);
		return mateList;
	}
	
	/**
	 * 標準のオーダー内容確認画面JACKET素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> standardJkMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm){
		Map<String, String> selectStandardJkMaterialName = orderHelper.selectStandardJkMaterialName(mateList,orderForm);
		return selectStandardJkMaterialName;
	}
	
	/**
	 * 標準のオーダー内容確認画面GILET素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> standardGlMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm){
		Map<String, String> selectStandardGlMaterialName = orderHelper.selectStandardGlMaterialName(mateList,orderForm);
		return selectStandardGlMaterialName;
	}
	
	/**
	 * 標準のオーダー内容確認画面COAT素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> standardCtMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm){
		Map<String, String> selectStandardCtMaterialName = orderHelper.selectStandardCtMaterialName(mateList,orderForm);
		return selectStandardCtMaterialName;
	}
	
	/**
	 * 標準のオーダー内容確認画面PANTS素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> standardPtMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm){
		Map<String, String> selectStandardPtMaterialName = orderHelper.selectStandardPtMaterialName(mateList,orderForm);
		return selectStandardPtMaterialName;
	}
	
	/**
	 * 標準のオーダー内容確認画面2PANTS素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> standardPt2MateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm){
		Map<String, String> selectStandardPt2MaterialName = orderHelper.selectStandardPt2MaterialName(mateList,orderForm);
		return selectStandardPt2MaterialName;
	}
	
	/**
	 * 
	 * @param orderForm
	 * @return
	 */
	public List<OptionBranchDetail> getTuxedoMateList(OrderForm orderForm) {
		String productItem = orderForm.getProductItem();
		String orderPattern = orderForm.getOrderPattern();
		List<OptionBranchDetail> mateList = optionBranchDeailService.getTuxedoButtonsList(productItem,orderPattern);
		return mateList;
	}
	
	/**
	 * タキシードのオーダー内容確認画面JACKETの素材名
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> tuxedoJkMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String, String> selectTuxedoJkMaterialName = orderHelper.selectTuxedoJkMaterialName(mateList, orderForm);
		return selectTuxedoJkMaterialName;
	}
	
	/**
	 * タキシードのオーダー内容確認画面GILETの素材名
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> tuxedoGlMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String, String> selectTuxedoGlMaterialName = orderHelper.selectTuxedoGlMaterialName(mateList, orderForm);
		return selectTuxedoGlMaterialName;
	}
	
	/**
	 * タキシードのオーダー内容確認画面PANTSの素材名
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> tuxedoPtMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String, String> selectTuxedoPtMaterialName = orderHelper.selectTuxedoPtMaterialName(mateList, orderForm);
		return selectTuxedoPtMaterialName;
	}
	
	/**
	 * タキシードのオーダー内容確認画面JACKETの素材名
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> tuxedoPt2MateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String, String> selectTuxedoPt2MaterialName = orderHelper.selectTuxedoPt2MaterialName(mateList, orderForm);
		return selectTuxedoPt2MaterialName;
	}
	
	/**
	 *
	 * @param orderForm
	 * @return
	 */
	public List<OptionBranchDetail> getWashableMateList(OrderForm orderForm) {
		String productItem = orderForm.getProductItem();
		String orderPattern = orderForm.getOrderPattern();
		List<OptionBranchDetail> mateList = optionBranchDeailService.getWashableButtonsList(productItem,orderPattern);
		return mateList;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面のJACKET素材名
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> washableJkMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String, String> selectWashableJkMaterialName = orderHelper.selectWashableJkMaterialName(mateList, orderForm);
		return selectWashableJkMaterialName;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面のGILET素材名
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> washableGlMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String, String> selectWashableGlMaterialName = orderHelper.selectWashableGlMaterialName(mateList, orderForm);
		return selectWashableGlMaterialName;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面のPANTS素材名
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> washablePtMateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String, String> selectWashablePtMaterialName = orderHelper.selectWashablePtMaterialName(mateList, orderForm);
		return selectWashablePtMaterialName;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面のPANTS素材名
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> washablePt2MateSelect(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String, String> selectWashablePt2MaterialName = orderHelper.selectWashablePt2MaterialName(mateList, orderForm);
		return selectWashablePt2MaterialName;
	}
	
	/**
	 * 
	 * @param orderForm
	 * @param sessionStatus
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "orderCoReFormInDb", method = RequestMethod.POST)
	public String orderCoReFormInDb(OrderForm orderForm,SessionStatus sessionStatus,Model model) {
		
		Order order = new Order();
		Measuring measuring = new Measuring();
		//商品情報_ITEM
		String productItem = orderForm.getProductItem();
		//商品情報_３Piece
		String productIs3Piece = orderForm.getProductIs3Piece();
		//商品情報_スペアパンツ
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		//３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		//３Pieceまたはスペアパンツは無し
		String productNo = "0009901";
		try {
			Order orderId = orderListService.findOrderByPk(orderForm.getCustomerMessageInfo().getOrderId());
			OrderFindFabric findStock = this.findStock(orderForm);
//			NextGenerationPrice priceCode = this.getPriceCode(orderForm);
			Order selectExistOrder = this.selectExistOrder(orderForm);
//			Map<String, Integer> retailPriceRelatedMap = this.retailPriceRelatedProjects(orderForm);
			//orderFormの対象とorderの対応フィールドのマッピング
			standardBeanMapper.map(orderForm.getCustomerMessageInfo(),order);
			standardBeanMapper.map(orderForm,order);
			orderHelper.measuringMapping(orderForm, measuring,sessionContent.getUserId());
			//標準の場合
			if("0".equals(orderForm.getProductCategory())) {
				List<OptionBranchDetail> mateList = this.getMateList(orderForm);
				Map<String, String> selectStandardJkMaterialName = this.standardJkMateSelect(mateList, orderForm);
				Map<String, String> standardGlMateSelectName = this.standardGlMateSelect(mateList, orderForm);
				Map<String, String> standardPtMateSelectName = this.standardPtMateSelect(mateList, orderForm);
				Map<String, String> standardPt2MateSelectName = this.standardPt2MateSelect(mateList, orderForm);
				Map<String, String> standardCtMateSelectName = this.standardCtMateSelect(mateList, orderForm);
				//SUITの場合、itemCodeは"01"
				if("01".equals(productItem)) {
					orderHelper.setProductItemDisplayCode(orderForm, order);
					//JACKETについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionJacketStandardInfo(), order);
					orderHelper.orderCoStandardJacketMapping(orderForm, order);
					orderHelper.orderCoStandardJkNameMapping(selectStandardJkMaterialName, order);
					
					//PANTSについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionPantsStandardInfo(), order);
					orderHelper.orderCoStandardPantsMapping(orderForm, order);
					orderHelper.orderCoStandardPtNameMapping(standardPtMateSelectName, order);
					
					//３Pieceは有り、スペアパンツは有りの場合
					if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						standardBeanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
						orderHelper.orderCoStandardGiletMapping(orderForm, order);
						orderHelper.orderCoStandardGlNameMapping(standardGlMateSelectName, order);
						
						//2PANTSについてのマピンッグ
						standardBeanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
						orderHelper.orderCoStandardPants2Mapping(orderForm, order);
						orderHelper.orderCoStandardPt2NameMapping(standardPt2MateSelectName, order);
					}
					//３Pieceは有り、スペアパンツは無しの場合
					else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						standardBeanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
						orderHelper.orderCoStandardGiletMapping(orderForm, order);
						orderHelper.orderCoStandardGlNameMapping(standardGlMateSelectName, order);
					}
					//３Pieceは無し、スペアパンツは有りの場合
					else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//2PANTSについてのマピンッグ
						standardBeanMapper.map(orderForm.getOptionPants2StandardInfo(), order);
						orderHelper.orderCoStandardPants2Mapping(orderForm, order);
						orderHelper.orderCoStandardPt2NameMapping(standardPt2MateSelectName, order);
					}
					else {
						order.setProductIs3pieceRtPrice(0);
						order.setProductIs3pieceWsWage(new BigDecimal(0));
						order.setProductIs3pieceWsPrice(0);
					}
				}
				//JACKETの場合、itemCodeは"02"
				else if("02".equals(productItem)) {
					//JACKETについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionJacketStandardInfo(), order);
					orderHelper.orderCoStandardJacketMapping(orderForm, order);
					orderHelper.orderCoStandardJkNameMapping(selectStandardJkMaterialName, order);
				}
				//PANTSの場合、itemCodeは"03"
				else if("03".equals(productItem)) {
					//PANTSについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionPantsStandardInfo(), order);
					orderHelper.orderCoStandardPantsMapping(orderForm, order);
					orderHelper.orderCoStandardPtNameMapping(standardPtMateSelectName, order);
				}
				//GILETの場合、itemCodeは"04"
				else if("04".equals(productItem)) {
					//GILETについてのマピンッグ
					standardBeanMapper.map(orderForm.getOptionGiletStandardInfo(), order);
					orderHelper.orderCoStandardGiletMapping(orderForm, order);
					orderHelper.orderCoStandardGlNameMapping(standardGlMateSelectName, order);
				}
				//SHIRTの場合、itemCodeは"05"
				else if("05".equals(productItem)) {
					standardBeanMapper.map(orderForm.getOptionShirtStandardInfo(), order);
					orderHelper.orderCoStandardShirtMapping(orderForm, order);
				}
				//COATの場合、itemCodeは"06"
				else if("06".equals(productItem)) {
					standardBeanMapper.map(orderForm.getOptionCoatStandardInfo(), order);
					orderHelper.orderCoStandardCoatMapping(orderForm, order);
					orderHelper.orderCoStandardCtNameMapping(standardCtMateSelectName, order);
				}
			}
			//タキシードの場合
			if("2".equals(orderForm.getProductCategory())) {
				List<OptionBranchDetail> tuxedoMateList = this.getTuxedoMateList(orderForm);
				Map<String, String> selectTuxedoJkMaterialName = this.tuxedoJkMateSelect(tuxedoMateList, orderForm);
				Map<String, String> tuxedoGlMateSelectName = this.tuxedoGlMateSelect(tuxedoMateList, orderForm);
				Map<String, String> tuxedoPtMateSelectName = this.tuxedoPtMateSelect(tuxedoMateList, orderForm);
				Map<String, String> tuxedoPt2MateSelectName = this.tuxedoPt2MateSelect(tuxedoMateList, orderForm);
				//SUITの場合、itemCodeは"01"
				if("01".equals(productItem)) {
					orderHelper.setProductItemDisplayCode(orderForm, order);
					//JACKETについてのマピンッグ
					tuxedoBeanMapper.map(orderForm.getOptionJacketTuxedoInfo(), order);
					orderHelper.orderCoTuxedoJacketMapping(orderForm, order);
					orderHelper.orderCoTuxedoJkNameMapping(selectTuxedoJkMaterialName, order);
					
					//PANTSについてのマピンッグ
					tuxedoBeanMapper.map(orderForm.getOptionPantsTuxedoInfo(), order);
					orderHelper.orderCoTuxedoPantsMapping(orderForm, order);
					orderHelper.orderCoTuxedoPtNameMapping(tuxedoPtMateSelectName, order);
					
					//３Pieceは有り、スペアパンツは有りの場合
					if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						tuxedoBeanMapper.map(orderForm.getOptionGiletTuxedoInfo(), order);
						orderHelper.orderCoTuxedoGiletMapping(orderForm, order);
						orderHelper.orderCoTuxedoGlNameMapping(tuxedoGlMateSelectName, order);
						
						//2PANTSについてのマピンッグ
						tuxedoBeanMapper.map(orderForm.getOptionPants2TuxedoInfo(), order);
						orderHelper.orderCoTuxedoPants2Mapping(orderForm, order);
						orderHelper.orderCoTuxedoPt2NameMapping(tuxedoPt2MateSelectName, order);
					}
					//３Pieceは有り、スペアパンツは無しの場合
					else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						tuxedoBeanMapper.map(orderForm.getOptionGiletTuxedoInfo(), order);
						orderHelper.orderCoTuxedoGiletMapping(orderForm, order);
						orderHelper.orderCoTuxedoGlNameMapping(tuxedoGlMateSelectName, order);
					}
					//３Pieceは無し、スペアパンツは有りの場合
					else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//2PANTSについてのマピンッグ
						tuxedoBeanMapper.map(orderForm.getOptionPants2TuxedoInfo(), order);
						orderHelper.orderCoTuxedoPants2Mapping(orderForm, order);
						orderHelper.orderCoTuxedoPt2NameMapping(tuxedoPt2MateSelectName, order);
					}
					else {
						order.setProductIs3pieceRtPrice(0);
						order.setProductIs3pieceWsWage(new BigDecimal(0));
						order.setProductIs3pieceWsPrice(0);
					}
				}
				//JACKETの場合、itemCodeは"02"
				else if("02".equals(productItem)) {
					//JACKETについてのマピンッグ
					tuxedoBeanMapper.map(orderForm.getOptionJacketTuxedoInfo(), order);
					orderHelper.orderCoTuxedoJacketMapping(orderForm, order);
					orderHelper.orderCoTuxedoJkNameMapping(selectTuxedoJkMaterialName, order);
				}
				//PANTSの場合、itemCodeは"03"
				else if("03".equals(productItem)) {
					//PANTSについてのマピンッグ
					tuxedoBeanMapper.map(orderForm.getOptionPantsTuxedoInfo(), order);
					orderHelper.orderCoTuxedoPantsMapping(orderForm, order);
					orderHelper.orderCoTuxedoPtNameMapping(tuxedoPtMateSelectName, order);
				}
				//GILETの場合、itemCodeは"04"
				else if("04".equals(productItem)) {
					//GILETについてのマピンッグ
					tuxedoBeanMapper.map(orderForm.getOptionGiletTuxedoInfo(), order);
					orderHelper.orderCoTuxedoGiletMapping(orderForm, order);
					orderHelper.orderCoTuxedoGlNameMapping(tuxedoGlMateSelectName, order);
				}
			}
			//ウォッシャブルの場合
			if("1".equals(orderForm.getProductCategory())) {
				List<OptionBranchDetail> washableMateList = this.getWashableMateList(orderForm);
				Map<String, String> selectWashableJkMaterialName = this.washableJkMateSelect(washableMateList,orderForm);
				Map<String, String> washableGlMateSelectName = this.washableGlMateSelect(washableMateList, orderForm);
				Map<String, String> washablePtMateSelectName = this.washablePtMateSelect(washableMateList, orderForm);
				Map<String, String> washablePt2MateSelectName = this.washablePt2MateSelect(washableMateList, orderForm);
				//SUITの場合、itemCodeは"01"
				if("01".equals(productItem)) {
					orderHelper.setProductItemDisplayCode(orderForm, order);
					//JACKETについてのマピンッグ
					washableBeanMapper.map(orderForm.getOptionJacketWashableInfo(), order);
					orderHelper.orderCoWashableJacketMapping(orderForm, order);
					orderHelper.orderCoWashableJkNameMapping(selectWashableJkMaterialName, order);
					
					//PANTSについてのマピンッグ
					washableBeanMapper.map(orderForm.getOptionPantsWashableInfo(), order);
					orderHelper.orderCoWashablePantsMapping(orderForm, order);
					orderHelper.orderCoWashablePtNameMapping(washablePtMateSelectName, order);
					
					//３Pieceは有り、スペアパンツは有りの場合
					if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						washableBeanMapper.map(orderForm.getOptionGiletWashableInfo(), order);
						orderHelper.orderCoWashableGiletMapping(orderForm, order);
						orderHelper.orderCoWashableGlNameMapping(washableGlMateSelectName, order);
						
						//2PANTSについてのマピンッグ
						washableBeanMapper.map(orderForm.getOptionPants2WashableInfo(), order);
						orderHelper.orderCoWashablePants2Mapping(orderForm, order);
						orderHelper.orderCoWashablePt2NameMapping(washablePt2MateSelectName, order);
						
					}
					//３Pieceは有り、スペアパンツは無しの場合
					else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						washableBeanMapper.map(orderForm.getOptionGiletWashableInfo(), order);
						orderHelper.orderCoWashableGiletMapping(orderForm, order);
						orderHelper.orderCoWashableGlNameMapping(washableGlMateSelectName, order);
						
					}
					//３Pieceは無し、スペアパンツは有りの場合
					else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//2PANTSについてのマピンッグ
						washableBeanMapper.map(orderForm.getOptionPants2WashableInfo(), order);
						orderHelper.orderCoWashablePants2Mapping(orderForm, order);
						orderHelper.orderCoWashablePt2NameMapping(washablePt2MateSelectName, order);
					}
					else {
						order.setProductIs3pieceRtPrice(0);
						order.setProductIs3pieceWsWage(new BigDecimal(0));
						order.setProductIs3pieceWsPrice(0);
					}
				}
				//JACKETの場合、itemCodeは"02"
				else if("02".equals(productItem)) {
					//JACKETについてのマピンッグ
					washableBeanMapper.map(orderForm.getOptionJacketWashableInfo(), order);
					orderHelper.orderCoWashableJacketMapping(orderForm, order);
					orderHelper.orderCoWashableJkNameMapping(selectWashableJkMaterialName, order);
					
				}
				//PANTSの場合、itemCodeは"03"
				else if("03".equals(productItem)) {
					//PANTSについてのマピンッグ
					washableBeanMapper.map(orderForm.getOptionPantsWashableInfo(), order);
					orderHelper.orderCoWashablePantsMapping(orderForm, order);
					orderHelper.orderCoWashablePtNameMapping(washablePtMateSelectName, order);
				}
				//GILETの場合、itemCodeは"04"
				else if("04".equals(productItem)) {
					//GILETについてのマピンッグ
					washableBeanMapper.map(orderForm.getOptionGiletWashableInfo(), order);
					orderHelper.orderCoWashableGiletMapping(orderForm, order);
					orderHelper.orderCoWashableGlNameMapping(washableGlMateSelectName, order);
				}
			}
			String userId = sessionContent.getUserId();
//			String findMakerId = this.findMakerId(orderForm);
			orderHelper.onlyUpdateItem(selectExistOrder,order,sessionContent.getAuthority());
			orderHelper.orderCoMapping(orderForm, order, userId, findStock, orderId);
			orderHelper.measuringMapping(orderForm, measuring,sessionContent.getUserId());
			
			//挿入の場合
			if (orderId == null) {
				orderService.insertOrder(order);
			} 
			//更新の場合
			else {
					orderService.updateOrder(order);
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
			
		}catch (ResourceNotFoundException re) {
			re.printStackTrace();
			logger.error(re.toString());
			String isFailure = null;
			if("".equals(orderForm.getStatus()) || "T0".equals(orderForm.getStatus()) || "T1".equals(orderForm.getStatus())) {
				isFailure = "1";
			}
			else {
				isFailure = "2";
			}
			model.addAttribute("messages",re.getResultMessages());
			model.addAttribute("isFailure",isFailure);
			return "order/orderPoLoginResultForm";
		}
		
	}
	
}