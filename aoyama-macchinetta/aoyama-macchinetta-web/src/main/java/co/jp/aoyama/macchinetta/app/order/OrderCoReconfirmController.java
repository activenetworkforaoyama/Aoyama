package co.jp.aoyama.macchinetta.app.order;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import org.terasoluna.gfw.common.message.ResultMessages;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import co.jp.aoyama.macchinetta.app.common.CoTypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.enums.LogItemClassEnum;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Maker;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;
import co.jp.aoyama.macchinetta.domain.model.OptionBranchDetail;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.Shop;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.maker.MakerService;
import co.jp.aoyama.macchinetta.domain.service.measuring.MeasuringService;
import co.jp.aoyama.macchinetta.domain.service.order.AdjustService;
import co.jp.aoyama.macchinetta.domain.service.order.NextGenerationService;
import co.jp.aoyama.macchinetta.domain.service.order.OptionBranchDeailService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;
import co.jp.aoyama.macchinetta.domain.service.shop.ShopService;

@Controller
@RequestMapping("/orderCoConfirm")
@TransactionTokenCheck("/orderCoConfirm")
@SessionAttributes(value = {"orderCoForm"})
public class OrderCoReconfirmController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderCoReconfirmController.class);
	
	@Inject
	OptionBranchDeailService optionBranchDeailService;
	
	@Inject
	NextGenerationService nextGenerationService;
	
	@Inject
	OrderListService orderListService;
	
	@Inject
	MeasuringService measuringService;
	
	@Inject
	TypeSizeService typeSizeService;
	
	@Inject
	OrderService orderService;
	
	@Inject
	MakerService makerService;
	
	@Inject
	AdjustService adjustService;
	
	@Inject
	Mapper standardBeanMapper;
	
	@Inject
	Mapper tuxedoBeanMapper;
	
	@Inject
	Mapper washableBeanMapper;

	@Inject
	SessionContent sessionContent;
	
	@Inject
	ShopService shopService;
	
	private OrderCoHelper orderCoHelper = new OrderCoHelper();
	
	CoTypeSizeOptimization coTypeSizeOptimization = new CoTypeSizeOptimization();
	
	@ModelAttribute(value = "orderCoForm")
	public OrderCoForm setUpOrderCoForm() {
		return new OrderCoForm();
	}

	@RequestMapping(value = "orderCoReForm")
	@TransactionTokenCheck(value = "create",type = TransactionTokenType.BEGIN)
	public String toOrderCoReForm(OrderCoForm orderCoForm,Model model,Map<String, Map<String, Integer>> map) {
		
		String productItem = orderCoForm.getProductItem();
		String productCategory = orderCoForm.getProductCategory();
		List<OrderPrice> priceList = orderService.getOrderPriceNotCate("CO");
		List<OrderCodePrice> optionBranchPriceList = orderCoHelper.optionBranchPriceData(priceList);
		Map<String, Integer> retailPriceRelatedCoProjects = this.retailPriceRelatedCoProjects(orderCoForm);
		OrderFindFabric findStock = this.findStock(orderCoForm);
		int optionPrice = Integer.parseInt(orderCoForm.getOptionPrice());
		int productPrice = Integer.parseInt(orderCoForm.getProductPrice());
		int setSomeProductPrice = orderCoHelper.setSomeProductPrice(orderCoForm);
		int coOptionCountVal = 0;
		coOptionCountVal = coOptionCountVal + setSomeProductPrice;
		if("9000101".equals(productCategory)) {
			if("01".equals(productItem)) {
				String productIs3Piece = orderCoForm.getProductIs3Piece();
				String productSparePantsClass = orderCoForm.getProductSparePantsClass();
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				int setStandard3Piece2PantsPrice = orderCoHelper.setStandard3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int jacketStandardPriceConfirm = orderCoHelper.jacketStandardPriceConfirm(orderCoForm);
				int standardJkUpperPriceCount = orderCoHelper.standardJkUpperPriceCount(orderCoForm, optionBranchPriceList);
				int pantsStandardPriceConfirm = orderCoHelper.pantsStandardPriceConfirm(orderCoForm);
				int standardPtUpperPriceCount = orderCoHelper.standardPtUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + setStandard3Piece2PantsPrice 
						+ standardJkUpperPriceCount + jacketStandardPriceConfirm
						+ standardPtUpperPriceCount + pantsStandardPriceConfirm;
				
				if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					int giletStandardPriceConfirm = orderCoHelper.giletStandardPriceConfirm(orderCoForm);
					int standardGlUpperPriceCount = orderCoHelper.standardGlUpperPriceCount(orderCoForm, optionBranchPriceList);
					int pants2StandardPriceConfirm = orderCoHelper.pants2StandardPriceConfirm(orderCoForm);
					int standardPt2UpperPriceCount = orderCoHelper.standardPt2UpperPriceCount(orderCoForm, optionBranchPriceList);
					coOptionCountVal = coOptionCountVal + standardGlUpperPriceCount + giletStandardPriceConfirm
							+ standardPt2UpperPriceCount + pants2StandardPriceConfirm;
				}
				else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					int pants2StandardPriceConfirm = orderCoHelper.pants2StandardPriceConfirm(orderCoForm);
					int standardPt2UpperPriceCount = orderCoHelper.standardPt2UpperPriceCount(orderCoForm, optionBranchPriceList);
					coOptionCountVal = coOptionCountVal + standardPt2UpperPriceCount + pants2StandardPriceConfirm;
				}
				else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					int giletStandardPriceConfirm = orderCoHelper.giletStandardPriceConfirm(orderCoForm);
					int standardGlUpperPriceCount = orderCoHelper.standardGlUpperPriceCount(orderCoForm, optionBranchPriceList);
					coOptionCountVal = coOptionCountVal + standardGlUpperPriceCount + giletStandardPriceConfirm;
				}
			}
			else if("02".equals(productItem)) {
				int jacketStandardPriceConfirm = orderCoHelper.jacketStandardPriceConfirm(orderCoForm);
				int setStandard3Piece2PantsPrice = orderCoHelper.setStandard3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int standardJkUpperPriceCount = orderCoHelper.standardJkUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + standardJkUpperPriceCount 
						+ setStandard3Piece2PantsPrice + jacketStandardPriceConfirm;
			}
			else if("03".equals(productItem)) {
				int pantsStandardPriceConfirm = orderCoHelper.pantsStandardPriceConfirm(orderCoForm);
				int standardPtUpperPriceCount = orderCoHelper.standardPtUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + standardPtUpperPriceCount + pantsStandardPriceConfirm;
			}
			else if("04".equals(productItem)) {
				int giletStandardPriceConfirm = orderCoHelper.giletStandardPriceConfirm(orderCoForm);
				int setStandard3Piece2PantsPrice = orderCoHelper.setStandard3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int standardGlUpperPriceCount = orderCoHelper.standardGlUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + standardGlUpperPriceCount 
						+ setStandard3Piece2PantsPrice + giletStandardPriceConfirm;
			}
			else if("05".equals(productItem)) {
				int standardStUpperPriceCount = orderCoHelper.standardStUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + standardStUpperPriceCount;
			}
			else if("06".equals(productItem)) {
				int setStandard3Piece2PantsPrice = orderCoHelper.setStandard3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int standardCtUpperPriceCount = orderCoHelper.standardCtUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + standardCtUpperPriceCount + setStandard3Piece2PantsPrice;
			}
			
			//データベースでオプション金額合計
			if(coOptionCountVal != optionPrice) {
				ResultMessages resultMessages = ResultMessages.error();
				resultMessages.add("E037");
				model.addAttribute("resultMessages",resultMessages);
				return "forward:/orderCo/orderCoBack";
			}
			
		}
		else if("9000102".equals(productCategory)) {
			if("01".equals(productItem)) {
				String productIs3Piece = orderCoForm.getProductIs3Piece();
				String productSparePantsClass = orderCoForm.getProductSparePantsClass();
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				int setTuxedo3Piece2PantsPrice = orderCoHelper.setTuxedo3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int jacketTuexdoPriceConfirm = orderCoHelper.jacketTuexdoPriceConfirm(orderCoForm);
				int tuxedoJkUpperPriceCount = orderCoHelper.tuxedoJkUpperPriceCount(orderCoForm, optionBranchPriceList);
				int pantsTuxedoPriceConfirm = orderCoHelper.pantsTuxedoPriceConfirm(orderCoForm);
				int tuxedoPtUpperPriceCount = orderCoHelper.tuxedoPtUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + setTuxedo3Piece2PantsPrice 
						+ tuxedoJkUpperPriceCount + jacketTuexdoPriceConfirm 
						+ tuxedoPtUpperPriceCount + pantsTuxedoPriceConfirm;
				if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					int giletTuxedoPriceConfirm = orderCoHelper.giletTuxedoPriceConfirm(orderCoForm);
					int tuxedoGlUpperPriceCount = orderCoHelper.tuxedoGlUpperPriceCount(orderCoForm, optionBranchPriceList);
					int pants2TuexdoPriceConfirm = orderCoHelper.pants2TuexdoPriceConfirm(orderCoForm);
					int tuxedoPt2UpperPriceCount = orderCoHelper.tuxedoPt2UpperPriceCount(orderCoForm, optionBranchPriceList);
					coOptionCountVal = coOptionCountVal + tuxedoGlUpperPriceCount + giletTuxedoPriceConfirm
							+ tuxedoPt2UpperPriceCount + pants2TuexdoPriceConfirm;
				}
				else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					int pants2TuexdoPriceConfirm = orderCoHelper.pants2TuexdoPriceConfirm(orderCoForm);
					int tuxedoPt2UpperPriceCount = orderCoHelper.tuxedoPt2UpperPriceCount(orderCoForm, optionBranchPriceList);
					coOptionCountVal = coOptionCountVal + tuxedoPt2UpperPriceCount + pants2TuexdoPriceConfirm;
				}
				else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					int giletTuxedoPriceConfirm = orderCoHelper.giletTuxedoPriceConfirm(orderCoForm);
					int tuxedoGlUpperPriceCount = orderCoHelper.tuxedoGlUpperPriceCount(orderCoForm, optionBranchPriceList);
					coOptionCountVal = coOptionCountVal + tuxedoGlUpperPriceCount + giletTuxedoPriceConfirm;
				}
			}
			else if("02".equals(productItem)) {
				int setTuxedo3Piece2PantsPrice = orderCoHelper.setTuxedo3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int jacketTuexdoPriceConfirm = orderCoHelper.jacketTuexdoPriceConfirm(orderCoForm);
				int tuxedoJkUpperPriceCount = orderCoHelper.tuxedoJkUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + tuxedoJkUpperPriceCount + jacketTuexdoPriceConfirm + setTuxedo3Piece2PantsPrice;
			}
			else if("03".equals(productItem)) {
				int pantsTuxedoPriceConfirm = orderCoHelper.pantsTuxedoPriceConfirm(orderCoForm);
				int tuxedoPtUpperPriceCount = orderCoHelper.tuxedoPtUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + tuxedoPtUpperPriceCount + pantsTuxedoPriceConfirm;
			}
			else if("04".equals(productItem)) {
				int setTuxedo3Piece2PantsPrice = orderCoHelper.setTuxedo3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int giletTuxedoPriceConfirm = orderCoHelper.giletTuxedoPriceConfirm(orderCoForm);
				int tuxedoGlUpperPriceCount = orderCoHelper.tuxedoGlUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + tuxedoGlUpperPriceCount + giletTuxedoPriceConfirm + setTuxedo3Piece2PantsPrice;
			}
			
			if(coOptionCountVal != optionPrice) {
				ResultMessages resultMessages = ResultMessages.error();
				resultMessages.add("E037");
				model.addAttribute("resultMessages",resultMessages);
				return "forward:/orderCo/orderCoBack";
			}
		}
		else if("9000103".equals(productCategory)) {
			if("01".equals(productItem)) {
				String productIs3Piece = orderCoForm.getProductIs3Piece();
				String productSparePantsClass = orderCoForm.getProductSparePantsClass();
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				
				int setWashable3Piece2PantsPrice = orderCoHelper.setWashable3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int jacketWashablePriceConfirm = orderCoHelper.jacketWashablePriceConfirm(orderCoForm);
				int washableJkUpperPriceCount = orderCoHelper.washableJkUpperPriceCount(orderCoForm, optionBranchPriceList);
				int pantsWashablePriceConfirm = orderCoHelper.pantsWashablePriceConfirm(orderCoForm);
				int washablePtUpperPriceCount = orderCoHelper.washablePtUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + setWashable3Piece2PantsPrice 
						+ washableJkUpperPriceCount + jacketWashablePriceConfirm
						+ washablePtUpperPriceCount + pantsWashablePriceConfirm;
				
				if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					int giletWashablePriceConfirm = orderCoHelper.giletWashablePriceConfirm(orderCoForm);
					int washableGlUpperPriceCount = orderCoHelper.washableGlUpperPriceCount(orderCoForm, optionBranchPriceList);
					int pants2WashablePriceConfirm = orderCoHelper.pants2WashablePriceConfirm(orderCoForm);
					int washablePt2UpperPriceCount = orderCoHelper.washablePt2UpperPriceCount(orderCoForm, optionBranchPriceList);
					coOptionCountVal = coOptionCountVal + washableGlUpperPriceCount + giletWashablePriceConfirm
							+ washablePt2UpperPriceCount + pants2WashablePriceConfirm;
				}
				else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					int pants2WashablePriceConfirm = orderCoHelper.pants2WashablePriceConfirm(orderCoForm);
					int washablePt2UpperPriceCount = orderCoHelper.washablePt2UpperPriceCount(orderCoForm, optionBranchPriceList);
					coOptionCountVal = coOptionCountVal + washablePt2UpperPriceCount + pants2WashablePriceConfirm;
				}
				else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					int giletWashablePriceConfirm = orderCoHelper.giletWashablePriceConfirm(orderCoForm);
					int washableGlUpperPriceCount = orderCoHelper.washableGlUpperPriceCount(orderCoForm, optionBranchPriceList);
					coOptionCountVal = coOptionCountVal + washableGlUpperPriceCount + giletWashablePriceConfirm;
				}
			}
			else if("02".equals(productItem)) {
				int setWashable3Piece2PantsPrice = orderCoHelper.setWashable3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int jacketWashablePriceConfirm = orderCoHelper.jacketWashablePriceConfirm(orderCoForm);
				int washableJkUpperPriceCount = orderCoHelper.washableJkUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + setWashable3Piece2PantsPrice + jacketWashablePriceConfirm + washableJkUpperPriceCount;
			}
			else if("03".equals(productItem)) {
				int setWashable3Piece2PantsPrice = orderCoHelper.setWashable3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int pantsWashablePriceConfirm = orderCoHelper.pantsWashablePriceConfirm(orderCoForm);
				int washablePtUpperPriceCount = orderCoHelper.washablePtUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + setWashable3Piece2PantsPrice + pantsWashablePriceConfirm + washablePtUpperPriceCount;
			}
			else if("04".equals(productItem)) {
				int setWashable3Piece2PantsPrice = orderCoHelper.setWashable3Piece2PantsPrice(orderCoForm, retailPriceRelatedCoProjects);
				int giletWashablePriceConfirm = orderCoHelper.giletWashablePriceConfirm(orderCoForm);
				int washableGlUpperPriceCount = orderCoHelper.washableGlUpperPriceCount(orderCoForm, optionBranchPriceList);
				coOptionCountVal = coOptionCountVal + washableGlUpperPriceCount + giletWashablePriceConfirm + setWashable3Piece2PantsPrice;
			}
			
			if(coOptionCountVal != optionPrice) {
				ResultMessages resultMessages = ResultMessages.error();
				resultMessages.add("E037");
				model.addAttribute("resultMessages",resultMessages);
				return "forward:/orderCo/orderCoBack";
			}
		}
		
		// データベースで商品金額合計
		int goodsPrice = orderCoHelper.getGoodsPrice(findStock, orderCoForm);
		if(productPrice != goodsPrice) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E037");
			model.addAttribute("resultMessages",resultMessages);
			return "forward:/orderCo/orderCoBack";
		}
		
		String status = orderCoForm.getStatusInput();
		if("T2".equals(status) || "T3".equals(status) || "T4".equals(status) || "T5".equals(status)) {
			//注文ID
			String orderId = orderCoForm.getCoCustomerMessageInfo().getOrderId();
			//注文
			Order order = orderListService.findOrderByPk(orderId);
			Date productOrderdDate = order.getProductOrderdDate();
			if(productOrderdDate != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String productOrderdDateFormat = sdf.format(productOrderdDate);
				model.addAttribute("productOrderdDateFormat",productOrderdDateFormat);
			}
		}
		
		String color = findStock.getColor();
		String pattern = findStock.getPattern();
		model.addAttribute("color",color);
		model.addAttribute("pattern",pattern);
		//モデルダブル価格
		Map<String, String> modelDoublePriceShow = orderCoHelper.modelDoublePriceShow(orderCoForm);
		model.addAttribute("modelDoublePriceShow",modelDoublePriceShow);
		// 商品情報金額
		Map<String, String> productAboutPrice = orderCoHelper.productAboutPrice(orderCoForm);
		model.addAttribute("productAboutPrice",productAboutPrice);
		
		// 店舗を取得
		List<Shop> shopList = shopService.findUnlessShop(sessionContent.getBelongCode());
		Map<String, String> mapShop = new HashMap<String, String>();
		for (Shop shop : shopList) {
			mapShop.put(shop.getShopCode(), shop.getShopName());
		}
		model.addAttribute("mapShop",mapShop);
		
		if("9000101".equals(productCategory)) {
			List<OptionBranchDetail> mateList = this.getMateList(orderCoForm);
			
			if("01".equals(productItem)) {
				String productIs3Piece = orderCoForm.getProductIs3Piece();
				String productSparePantsClass = orderCoForm.getProductSparePantsClass();
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				
				//標準のオーダー内容確認画面JACKET素材名
				Map<String, String> standardJkMateSelectMap = this.standardJkMateSelect(mateList, orderCoForm);
				model.addAttribute("standardJkMateSelectMap",standardJkMateSelectMap);
				
				//標準のオーダー内容確認画面JACKET上代
				Map<String, String> standardFrameJkDisplayUpperPrice = this.standardFrameJkDisplayUpperPrice(orderCoForm);
				model.addAttribute("standardFrameJkDisplayUpperPrice",standardFrameJkDisplayUpperPrice);
				
				//標準のオーダー内容確認画面PANTS素材名
				Map<String, String> standardPtMateSelectMap = this.standardPtMateSelect(mateList, orderCoForm);
				model.addAttribute("standardPtMateSelectMap",standardPtMateSelectMap);
				
				//標準のオーダー内容確認画面PANTS上代
				Map<String, String> standardFramePtDisplayUpperPrice = this.standardFramePtDisplayUpperPrice(orderCoForm);
				model.addAttribute("standardFramePtDisplayUpperPrice",standardFramePtDisplayUpperPrice);
				
				if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// 標準のオーダー内容確認画面GILET素材名
					Map<String, String> standardGlMateSelectMap = this.standardGlMateSelect(mateList, orderCoForm);
					model.addAttribute("standardGlMateSelectMap",standardGlMateSelectMap);
					
					// 標準のオーダー内容確認画面GILET上代
					Map<String, String> standardFrameGlDisplayUpperPrice = this.standardFrameGlDisplayUpperPrice(orderCoForm);
					model.addAttribute("standardFrameGlDisplayUpperPrice",standardFrameGlDisplayUpperPrice);
					
					//標準のオーダー内容確認画面2PANTS素材名
					Map<String, String> standardPt2MateSelectMap = this.standardPt2MateSelect(mateList, orderCoForm);
					model.addAttribute("standardPt2MateSelectMap",standardPt2MateSelectMap);
					
					//標準のオーダー内容確認画面2PANTS上代
					Map<String, String> standardFramePt2DisplayUpperPrice = this.standardFramePt2DisplayUpperPrice(orderCoForm);
					model.addAttribute("standardFramePt2DisplayUpperPrice",standardFramePt2DisplayUpperPrice);
				}
				else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					//標準のオーダー内容確認画面2PANTS素材名
					Map<String, String> standardPt2MateSelectMap = this.standardPt2MateSelect(mateList, orderCoForm);
					model.addAttribute("standardPt2MateSelectMap",standardPt2MateSelectMap);
					
					//標準のオーダー内容確認画面2PANTS上代
					Map<String, String> standardFramePt2DisplayUpperPrice = this.standardFramePt2DisplayUpperPrice(orderCoForm);
					model.addAttribute("standardFramePt2DisplayUpperPrice",standardFramePt2DisplayUpperPrice);
				}
				else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// 標準のオーダー内容確認画面GILET素材名
					Map<String, String> standardGlMateSelectMap = this.standardGlMateSelect(mateList, orderCoForm);
					model.addAttribute("standardGlMateSelectMap",standardGlMateSelectMap);
					
					// 標準のオーダー内容確認画面GILET上代
					Map<String, String> standardFrameGlDisplayUpperPrice = this.standardFrameGlDisplayUpperPrice(orderCoForm);
					model.addAttribute("standardFrameGlDisplayUpperPrice",standardFrameGlDisplayUpperPrice);
				}
			}
			else if("02".equals(productItem)) {
				//標準のオーダー内容確認画面JACKET素材名
				Map<String, String> standardJkMateSelectMap = this.standardJkMateSelect(mateList, orderCoForm);
				model.addAttribute("standardJkMateSelectMap",standardJkMateSelectMap);
				
				//標準のオーダー内容確認画面JACKET上代
				Map<String, String> standardFrameJkDisplayUpperPrice = this.standardFrameJkDisplayUpperPrice(orderCoForm);
				model.addAttribute("standardFrameJkDisplayUpperPrice",standardFrameJkDisplayUpperPrice);
			}
			else if("03".equals(productItem)) {
				//標準のオーダー内容確認画面PANTS素材名
				Map<String, String> standardPtMateSelectMap = this.standardPtMateSelect(mateList, orderCoForm);
				model.addAttribute("standardPtMateSelectMap",standardPtMateSelectMap);
				
				//標準のオーダー内容確認画面PANTS上代
				Map<String, String> standardFramePtDisplayUpperPrice = this.standardFramePtDisplayUpperPrice(orderCoForm);
				model.addAttribute("standardFramePtDisplayUpperPrice",standardFramePtDisplayUpperPrice);
			}
			else if("04".equals(productItem)) {
				// 標準のオーダー内容確認画面GILET素材名
				Map<String, String> standardGlMateSelectMap = this.standardGlMateSelect(mateList, orderCoForm);
				model.addAttribute("standardGlMateSelectMap",standardGlMateSelectMap);

				// 標準のオーダー内容確認画面GILET上代
				Map<String, String> standardFrameGlDisplayUpperPrice = this.standardFrameGlDisplayUpperPrice(orderCoForm);
				model.addAttribute("standardFrameGlDisplayUpperPrice",standardFrameGlDisplayUpperPrice);
			}
			else if("05".equals(productItem)) {
				// 標準のオーダー内容確認画面SHIRT上代
				Map<String, String> standardFrameStDisplayUpperPrice = this.standardFrameStDisplayUpperPrice(orderCoForm);
				model.addAttribute("standardFrameStDisplayUpperPrice",standardFrameStDisplayUpperPrice);
			}
			else if("06".equals(productItem)) {
				// 標準のオーダー内容確認画面COAT素材名
				Map<String, String> standardCtMateSelectMap = this.standardCtMateSelect(mateList, orderCoForm);
				model.addAttribute("standardCtMateSelectMap",standardCtMateSelectMap);
				
				Map<String, String> standardFrameCtDisplayUpperPrice = this.standardFrameCtDisplayUpperPrice(orderCoForm);
				model.addAttribute("standardFrameCtDisplayUpperPrice",standardFrameCtDisplayUpperPrice);
			}
		}
		else if("9000102".equals(productCategory)) {
			List<OptionBranchDetail> tuxedoMateList = this.getTuxedoMateList(orderCoForm);
			if("01".equals(productItem)) {
				String productIs3Piece = orderCoForm.getProductIs3Piece();
				String productSparePantsClass = orderCoForm.getProductSparePantsClass();
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				// タキシードのオーダー内容確認画面JACKETの素材名
				Map<String, String> tuxedoJkMateSelectMap = this.tuxedoJkMateSelect(tuxedoMateList, orderCoForm);
				model.addAttribute("tuxedoJkMateSelectMap",tuxedoJkMateSelectMap);
				
				//タキシードのオーダー内容確認画面JACKETの複数の項目名
				Map<String, String> tuxedoServelItemShow = orderCoHelper.tuxedoJkServelItemShow(orderCoForm);
				model.addAttribute("tuxedoServelItemShow",tuxedoServelItemShow);
				
				//タキシードのオーダー内容確認画面JACKETの上代
				Map<String, String> tuxedoFrameJkDisplayUpperPrice = this.tuxedoFrameJkDisplayUpperPrice(orderCoForm);
				model.addAttribute("tuxedoFrameJkDisplayUpperPrice",tuxedoFrameJkDisplayUpperPrice);
				
				//タキシードのオーダー内容確認画面PANTSの素材名
				Map<String, String> tuxedoPtMateSelectMap = this.tuxedoPtMateSelect(tuxedoMateList, orderCoForm);
				model.addAttribute("tuxedoPtMateSelectMap",tuxedoPtMateSelectMap);
				
				//タキシードのオーダー内容確認画面PANTSの複数の項目名
				Map<String, String> tuxedoPtServelItemShow = orderCoHelper.tuxedoPtServelItemShow(orderCoForm);
				model.addAttribute("tuxedoPtServelItemShow",tuxedoPtServelItemShow);
				
				//タキシードのオーダー内容確認画面PANTSの上代
				Map<String, String> tuxedoFramePtDisplayUpperPrice = this.tuxedoFramePtDisplayUpperPrice(orderCoForm);
				model.addAttribute("tuxedoFramePtDisplayUpperPrice",tuxedoFramePtDisplayUpperPrice);
				
				if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// タキシードのオーダー内容確認画面GILETの素材名
					Map<String, String> tuxedoGlMateSelectMap = this.tuxedoGlMateSelect(tuxedoMateList, orderCoForm);
					model.addAttribute("tuxedoGlMateSelectMap",tuxedoGlMateSelectMap);
					
					// タキシードのオーダー内容確認画面GILETの複数の項目名
					Map<String, String> tuxedoGlServelItemShow = orderCoHelper.tuxedoGlServelItemShow(orderCoForm);
					model.addAttribute("tuxedoGlServelItemShow",tuxedoGlServelItemShow);
					
					// タキシードのオーダー内容確認画面GILET上代
					Map<String, String> tuxedoFrameGlDisplayUpperPrice = this.tuxedoFrameGlDisplayUpperPrice(orderCoForm);
					model.addAttribute("tuxedoFrameGlDisplayUpperPrice",tuxedoFrameGlDisplayUpperPrice);
					
					// タキシードのオーダー内容確認画面PANTS2の素材名
					Map<String, String> tuxedoPt2MateSelectMap = this.tuxedoPt2MateSelect(tuxedoMateList, orderCoForm);
					model.addAttribute("tuxedoPt2MateSelectMap",tuxedoPt2MateSelectMap);
					
					// タキシードのオーダー内容確認画面PANTS2の複数の項目名
					Map<String, String> tuxedoPt2ServelItemShow = orderCoHelper.tuxedoPt2ServelItemShow(orderCoForm);
					model.addAttribute("tuxedoPt2ServelItemShow",tuxedoPt2ServelItemShow);
					
					//タキシードのオーダー内容確認画面PANTS2上代
					Map<String, String> tuxedoFramePt2DisplayUpperPrice = this.tuxedoFramePt2DisplayUpperPrice(orderCoForm);
					model.addAttribute("tuxedoFramePt2DisplayUpperPrice",tuxedoFramePt2DisplayUpperPrice);
					
				}
				else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					// タキシードのオーダー内容確認画面PANTS2の素材名
					Map<String, String> tuxedoPt2MateSelectMap = this.tuxedoPt2MateSelect(tuxedoMateList, orderCoForm);
					model.addAttribute("tuxedoPt2MateSelectMap",tuxedoPt2MateSelectMap);
					
					// タキシードのオーダー内容確認画面PANTS2の複数の項目名
					Map<String, String> tuxedoPt2ServelItemShow = orderCoHelper.tuxedoPt2ServelItemShow(orderCoForm);
					model.addAttribute("tuxedoPt2ServelItemShow",tuxedoPt2ServelItemShow);
					
					//タキシードのオーダー内容確認画面PANTS2上代
					Map<String, String> tuxedoFramePt2DisplayUpperPrice = this.tuxedoFramePt2DisplayUpperPrice(orderCoForm);
					model.addAttribute("tuxedoFramePt2DisplayUpperPrice",tuxedoFramePt2DisplayUpperPrice);
				}
				else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					// タキシードのオーダー内容確認画面GILETの素材名
					Map<String, String> tuxedoGlMateSelectMap = this.tuxedoGlMateSelect(tuxedoMateList, orderCoForm);
					model.addAttribute("tuxedoGlMateSelectMap",tuxedoGlMateSelectMap);
					
					// タキシードのオーダー内容確認画面GILETの複数の項目名
					Map<String, String> tuxedoGlServelItemShow = orderCoHelper.tuxedoGlServelItemShow(orderCoForm);
					model.addAttribute("tuxedoGlServelItemShow",tuxedoGlServelItemShow);
					
					// タキシードのオーダー内容確認画面GILET上代
					Map<String, String> tuxedoFrameGlDisplayUpperPrice = this.tuxedoFrameGlDisplayUpperPrice(orderCoForm);
					model.addAttribute("tuxedoFrameGlDisplayUpperPrice",tuxedoFrameGlDisplayUpperPrice);
				}
			}
			else if("02".equals(productItem)) {
				//タキシードのオーダー内容確認画面JACKETの素材名
				Map<String, String> tuxedoJkMateSelectMap = this.tuxedoJkMateSelect(tuxedoMateList, orderCoForm);
				model.addAttribute("tuxedoJkMateSelectMap",tuxedoJkMateSelectMap);
				
				//タキシードのオーダー内容確認画面JACKETの複数の項目名
				Map<String, String> tuxedoServelItemShow = orderCoHelper.tuxedoJkServelItemShow(orderCoForm);
				model.addAttribute("tuxedoServelItemShow",tuxedoServelItemShow);
				
				//タキシードのオーダー内容確認画面JACKETの上代
				Map<String, String> tuxedoFrameJkDisplayUpperPrice = this.tuxedoFrameJkDisplayUpperPrice(orderCoForm);
				model.addAttribute("tuxedoFrameJkDisplayUpperPrice",tuxedoFrameJkDisplayUpperPrice);
				
			}
			else if("03".equals(productItem)) {
				// タキシードのオーダー内容確認画面PANTSの素材名
				Map<String, String> tuxedoPtMateSelectMap = this.tuxedoPtMateSelect(tuxedoMateList, orderCoForm);
				model.addAttribute("tuxedoPtMateSelectMap",tuxedoPtMateSelectMap);
				
				//タキシードのオーダー内容確認画面PANTSの複数の項目名
				Map<String, String> tuxedoPtServelItemShow = orderCoHelper.tuxedoPtServelItemShow(orderCoForm);
				model.addAttribute("tuxedoPtServelItemShow",tuxedoPtServelItemShow);
				
				//タキシードのオーダー内容確認画面PANTSの上代
				Map<String, String> tuxedoFramePtDisplayUpperPrice = this.tuxedoFramePtDisplayUpperPrice(orderCoForm);
				model.addAttribute("tuxedoFramePtDisplayUpperPrice",tuxedoFramePtDisplayUpperPrice);
			}
			else if("04".equals(productItem)) {
				// タキシードのオーダー内容確認画面GILETの素材名
				Map<String, String> tuxedoGlMateSelectMap = this.tuxedoGlMateSelect(tuxedoMateList, orderCoForm);
				model.addAttribute("tuxedoGlMateSelectMap",tuxedoGlMateSelectMap);
				
				// タキシードのオーダー内容確認画面GILETの複数の項目名
				Map<String, String> tuxedoGlServelItemShow = orderCoHelper.tuxedoGlServelItemShow(orderCoForm);
				model.addAttribute("tuxedoGlServelItemShow",tuxedoGlServelItemShow);
				
				// タキシードのオーダー内容確認画面GILET上代
				Map<String, String> tuxedoFrameGlDisplayUpperPrice = this.tuxedoFrameGlDisplayUpperPrice(orderCoForm);
				model.addAttribute("tuxedoFrameGlDisplayUpperPrice",tuxedoFrameGlDisplayUpperPrice);
			}
		}
		else if("9000103".equals(productCategory)) {
			List<OptionBranchDetail> washableMateList = this.getWashableMateList(orderCoForm);
			if("01".equals(productItem)) {
				String productIs3Piece = orderCoForm.getProductIs3Piece();
				String productSparePantsClass = orderCoForm.getProductSparePantsClass();
				
				//３Pieceまたはスペアパンツは有り
				String productYes = "0009902";
				//３Pieceまたはスペアパンツは無し
				String productNo = "0009901";
				//ウォッシャブルのオーダー内容確認画面のJACKET素材名
				Map<String, String> washableJkMateSelectMap = this.washableJkMateSelect(washableMateList, orderCoForm);
				model.addAttribute("washableJkMateSelectMap",washableJkMateSelectMap);
				
				//ウォッシャブルのオーダー内容確認画面のJACKETの複数の項目名
				Map<String, String> washableJkServelItemShow = orderCoHelper.washableJkServelItemShow(orderCoForm);
				model.addAttribute("washableJkServelItemShow",washableJkServelItemShow);
				
				//ウォッシャブルのオーダー内容確認画面のJACKET上代
				Map<String, String> washableFrameJkDisplayUpperPrice = this.washableFrameJkDisplayUpperPrice(orderCoForm);
				model.addAttribute("washableFrameJkDisplayUpperPrice",washableFrameJkDisplayUpperPrice);
				
				//ウォッシャブルのオーダー内容確認画面のPANTS素材名
				Map<String, String> washablePtMateSelectMap = this.washablePtMateSelect(washableMateList, orderCoForm);
				model.addAttribute("washablePtMateSelectMap",washablePtMateSelectMap);
				
				//ウォッシャブルのオーダー内容確認画面のPANTSの複数の項目名
				Map<String, String> washablePtServelItemShow = orderCoHelper.washablePtServelItemShow(orderCoForm);
				model.addAttribute("washablePtServelItemShow",washablePtServelItemShow);
				
				//ウォッシャブルのオーダー内容確認画面のPANTS上代
				Map<String, String> washableFramePtDisplayUpperPrice = this.washableFramePtDisplayUpperPrice(orderCoForm);
				model.addAttribute("washableFramePtDisplayUpperPrice",washableFramePtDisplayUpperPrice);
				
				if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					//ウォッシャブルのオーダー内容確認画面のGILET素材名
					Map<String, String> washableGlMateSelectMap = this.washableGlMateSelect(washableMateList, orderCoForm);
					model.addAttribute("washableGlMateSelectMap",washableGlMateSelectMap);
					
					//ウォッシャブルのオーダー内容確認画面のGILETの複数の項目名
					Map<String, String> washableGlServelItemShow = orderCoHelper.washableGlServelItemShow(orderCoForm);
					model.addAttribute("washableGlServelItemShow",washableGlServelItemShow);
					
					//ウォッシャブルのオーダー内容確認画面のGILET上代
					Map<String, String> washableFrameGlDisplayUpperPrice = this.washableFrameGlDisplayUpperPrice(orderCoForm);
					model.addAttribute("washableFrameGlDisplayUpperPrice",washableFrameGlDisplayUpperPrice);
					
					//ウォッシャブルのオーダー内容確認画面のPANTS2素材名
					Map<String, String> washablePt2MateSelectMap = this.washablePt2MateSelect(washableMateList, orderCoForm);
					model.addAttribute("washablePt2MateSelectMap",washablePt2MateSelectMap);
					
					//ウォッシャブルのオーダー内容確認画面のPANTS2の複数の項目名
					Map<String, String> washablePt2ServelItemShow = orderCoHelper.washablePt2ServelItemShow(orderCoForm);
					model.addAttribute("washablePt2ServelItemShow",washablePt2ServelItemShow);
					
					//ウォッシャブルのオーダー内容確認画面のPANTS2上代
					Map<String, String> washableFramePt2DisplayUpperPrice = this.washableFramePt2DisplayUpperPrice(orderCoForm);
					model.addAttribute("washableFramePt2DisplayUpperPrice",washableFramePt2DisplayUpperPrice);
				}
				else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
					//ウォッシャブルのオーダー内容確認画面のPANTS2素材名
					Map<String, String> washablePt2MateSelectMap = this.washablePt2MateSelect(washableMateList, orderCoForm);
					model.addAttribute("washablePt2MateSelectMap",washablePt2MateSelectMap);
					
					//ウォッシャブルのオーダー内容確認画面のPANTS2の複数の項目名
					Map<String, String> washablePt2ServelItemShow = orderCoHelper.washablePt2ServelItemShow(orderCoForm);
					model.addAttribute("washablePt2ServelItemShow",washablePt2ServelItemShow);
					
					//ウォッシャブルのオーダー内容確認画面のPANTS2上代
					Map<String, String> washableFramePt2DisplayUpperPrice = this.washableFramePt2DisplayUpperPrice(orderCoForm);
					model.addAttribute("washableFramePt2DisplayUpperPrice",washableFramePt2DisplayUpperPrice);
				}
				else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
					//ウォッシャブルのオーダー内容確認画面のGILET素材名
					Map<String, String> washableGlMateSelectMap = this.washableGlMateSelect(washableMateList, orderCoForm);
					model.addAttribute("washableGlMateSelectMap",washableGlMateSelectMap);
					
					//ウォッシャブルのオーダー内容確認画面のGILETの複数の項目名
					Map<String, String> washableGlServelItemShow = orderCoHelper.washableGlServelItemShow(orderCoForm);
					model.addAttribute("washableGlServelItemShow",washableGlServelItemShow);
					
					//ウォッシャブルのオーダー内容確認画面のGILET上代
					Map<String, String> washableFrameGlDisplayUpperPrice = this.washableFrameGlDisplayUpperPrice(orderCoForm);
					model.addAttribute("washableFrameGlDisplayUpperPrice",washableFrameGlDisplayUpperPrice);
				}
			}
			else if("02".equals(productItem)) {
				//ウォッシャブルのオーダー内容確認画面のJACKET素材名
				Map<String, String> washableJkMateSelectMap = this.washableJkMateSelect(washableMateList, orderCoForm);
				model.addAttribute("washableJkMateSelectMap",washableJkMateSelectMap);
				
				//ウォッシャブルのオーダー内容確認画面のJACKETの複数の項目名
				Map<String, String> washableJkServelItemShow = orderCoHelper.washableJkServelItemShow(orderCoForm);
				model.addAttribute("washableJkServelItemShow",washableJkServelItemShow);
				
				//ウォッシャブルのオーダー内容確認画面のJACKET上代
				Map<String, String> washableFrameJkDisplayUpperPrice = this.washableFrameJkDisplayUpperPrice(orderCoForm);
				model.addAttribute("washableFrameJkDisplayUpperPrice",washableFrameJkDisplayUpperPrice);
				
			}
			else if("03".equals(productItem)) {
				//ウォッシャブルのオーダー内容確認画面のPANTS素材名
				Map<String, String> washablePtMateSelectMap = this.washablePtMateSelect(washableMateList, orderCoForm);
				model.addAttribute("washablePtMateSelectMap",washablePtMateSelectMap);
				
				//ウォッシャブルのオーダー内容確認画面のPANTSの複数の項目名
				Map<String, String> washablePtServelItemShow = orderCoHelper.washablePtServelItemShow(orderCoForm);
				model.addAttribute("washablePtServelItemShow",washablePtServelItemShow);
				
				//ウォッシャブルのオーダー内容確認画面のPANTS上代
				Map<String, String> washableFramePtDisplayUpperPrice = this.washableFramePtDisplayUpperPrice(orderCoForm);
				model.addAttribute("washableFramePtDisplayUpperPrice",washableFramePtDisplayUpperPrice);
				
			}
			else if("04".equals(productItem)) {
				//ウォッシャブルのオーダー内容確認画面のGILET素材名
				Map<String, String> washableGlMateSelectMap = this.washableGlMateSelect(washableMateList, orderCoForm);
				model.addAttribute("washableGlMateSelectMap",washableGlMateSelectMap);
				
				//ウォッシャブルのオーダー内容確認画面のGILETの複数の項目名
				Map<String, String> washableGlServelItemShow = orderCoHelper.washableGlServelItemShow(orderCoForm);
				model.addAttribute("washableGlServelItemShow",washableGlServelItemShow);
				
				//ウォッシャブルのオーダー内容確認画面のGILET上代
				Map<String, String> washableFrameGlDisplayUpperPrice = this.washableFrameGlDisplayUpperPrice(orderCoForm);
				model.addAttribute("washableFrameGlDisplayUpperPrice",washableFrameGlDisplayUpperPrice);
			}
		}
		return "order/orderCoReconfirmForm";
	}
	
	/**
	 * メーカーコードによる取得メーカーID
	 * @return
	 */
	public String findMakerId(OrderCoForm orderCoForm) throws ResourceNotFoundException{
		String fabricNo = orderCoForm.getProductFabricNo();
		String orderPattern = orderCoForm.getOrderPattern();
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
	public NextGenerationPrice getPriceCode(OrderCoForm orderCoForm) {
		//生地品番
		String fabricNo = orderCoForm.getProductFabricNo();
		NextGenerationPrice mfaFactoryCode = nextGenerationService.selectCoFactoryCode(fabricNo);
		return mfaFactoryCode;
	}
	
	/**
	 * データベースのorderデータを検索する。
	 * @param orderCoForm
	 * @return
	 */
	public Order selectExistOrder(OrderCoForm orderCoForm) {
		String orderId = orderCoForm.getCoCustomerMessageInfo().getOrderId();
		Order order= orderListService.findOrderByPk(orderId);
		return order;
	}
	
	/**
	 * 生地品番とオーダーパターンによって生地の情報を取得
	 * 
	 * @param fabricNo
	 * @param orderPattern
	 * 
	 */
	public OrderFindFabric findStock(OrderCoForm orderCoForm) {
		String fabricNo = orderCoForm.getProductFabricNo();
		String orderPattern = orderCoForm.getOrderPattern();
		OrderFindFabric orderFindFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		return orderFindFabric;
	}
	
	/**
	 * 上代関連項目
	 * @param orderCoForm
	 * @return 
	 */
	public Map<String, Integer> retailPriceRelatedCoProjects(OrderCoForm orderCoForm) {
		String fabricNo = orderCoForm.getProductFabricNo();
		String orderPattern = orderCoForm.getOrderPattern();
		OrderFindFabric orderFabric = orderService.getOrderFabric(fabricNo, orderPattern);
		Map<String, Integer> retailPriceRelatedMap = orderCoHelper.getCoRetailPriceRelated(orderFabric);
		return retailPriceRelatedMap;
	}
	
	/**
	 * 標準のオーダー内容確認画面JACKETの上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardFrameJkDisplayUpperPrice(OrderCoForm orderCoForm) {
		Map<String, String> standardFrameJkDisplayUpperPrice = orderCoHelper.standardFrameJkDisplayUpperPrice(orderCoForm);
		return standardFrameJkDisplayUpperPrice;
	}
	
	/**
	 * タキシードのオーダー内容確認画面JACKETの上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> tuxedoFrameJkDisplayUpperPrice(OrderCoForm orderCoForm) {
		Map<String, String> tuxedoFrameJkDisplayUpperPrice = orderCoHelper.tuxedoFrameJkDisplayUpperPrice(orderCoForm);
		return tuxedoFrameJkDisplayUpperPrice;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面JACKETの上代
	 * @param orderCoForm
	 * @return 
	 * @return
	 */
	public Map<String, String> washableFrameJkDisplayUpperPrice(OrderCoForm orderCoForm) {
		Map<String, String> washableFrameJkDisplayUpperPrice = orderCoHelper.washableFrameJkDisplayUpperPrice(orderCoForm);
		return washableFrameJkDisplayUpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面GILET上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardFrameGlDisplayUpperPrice(OrderCoForm orderCoForm){
		Map<String, String> standardFrameGlDisplayUpperPrice = orderCoHelper.standardFrameGlDisplayUpperPrice(orderCoForm);
		return standardFrameGlDisplayUpperPrice;
	}
	
	/**
	 * タキシードのオーダー内容確認画面GILET上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> tuxedoFrameGlDisplayUpperPrice(OrderCoForm orderCoForm) {
		Map<String, String> tuxedoFrameGlDisplayUpperPrice = orderCoHelper.tuxedoFrameGlDisplayUpperPrice(orderCoForm);
		return tuxedoFrameGlDisplayUpperPrice;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面GILET上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> washableFrameGlDisplayUpperPrice(OrderCoForm orderCoForm){
		Map<String, String> washableFrameGlDisplayUpperPrice = orderCoHelper.washableFrameGlDisplayUpperPrice(orderCoForm);
		return washableFrameGlDisplayUpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面PANTS上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardFramePtDisplayUpperPrice(OrderCoForm orderCoForm){
		Map<String, String> standardFramePtDisplayUpperPrice = orderCoHelper.standardFramePtDisplayUpperPrice(orderCoForm);
		return standardFramePtDisplayUpperPrice;
	}
	
	/**
	 * タキシードのオーダー内容確認画面PANTS上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> tuxedoFramePtDisplayUpperPrice(OrderCoForm orderCoForm){
		Map<String, String> tuxedoFramePtDisplayUpperPrice = orderCoHelper.tuxedoFramePtDisplayUpperPrice(orderCoForm);
		return tuxedoFramePtDisplayUpperPrice;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面PANTS上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> washableFramePtDisplayUpperPrice(OrderCoForm orderCoForm) {
		Map<String, String> washableFramePtDisplayUpperPrice = orderCoHelper.washableFramePtDisplayUpperPrice(orderCoForm);
		return washableFramePtDisplayUpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面PANTS2上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardFramePt2DisplayUpperPrice(OrderCoForm orderCoForm){
		Map<String, String> standardFramePt2DisplayUpperPrice = orderCoHelper.standardFramePt2DisplayUpperPrice(orderCoForm);
		return standardFramePt2DisplayUpperPrice;
	}
	
	/**
	 * タキシードのオーダー内容確認画面PANTS2上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> tuxedoFramePt2DisplayUpperPrice(OrderCoForm orderCoForm) {
		Map<String, String> tuxedoFramePt2DisplayUpperPrice = orderCoHelper.tuxedoFramePt2DisplayUpperPrice(orderCoForm);
		return tuxedoFramePt2DisplayUpperPrice;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面PANTS2上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> washableFramePt2DisplayUpperPrice(OrderCoForm orderCoForm) {
		Map<String, String> washableFramePt2DisplayUpperPrice = orderCoHelper.washableFramePt2DisplayUpperPrice(orderCoForm);
		return washableFramePt2DisplayUpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面SHIRT上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardFrameStDisplayUpperPrice(OrderCoForm orderCoForm) {
		Map<String, String> standardFrameStDisplayUpperPrice = orderCoHelper.standardFrameStDisplayUpperPrice(orderCoForm);
		return standardFrameStDisplayUpperPrice;
	}
	
	/**
	 * 標準のオーダー内容確認画面COAT上代
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardFrameCtDisplayUpperPrice(OrderCoForm orderCoForm) {
		Map<String, String> standardFrameCtDisplayUpperPrice = orderCoHelper.standardFrameCtDisplayUpperPrice(orderCoForm);
		return standardFrameCtDisplayUpperPrice;
	}
	
	/**
	 * 
	 * @param orderCoForm
	 * @return
	 */
	public List<OptionBranchDetail> getMateList(OrderCoForm orderCoForm) {
		
		String productItem = orderCoForm.getProductItem();
		String orderPattern = orderCoForm.getOrderPattern();
		List<OptionBranchDetail> mateList = optionBranchDeailService.getStandardButtonsList(productItem,orderPattern);
		return mateList;
	}
	
	/**
	 * 標準のオーダー内容確認画面JACKET素材名
	 * @param mateList
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardJkMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm){
		Map<String, String> selectStandardJkMaterialName = orderCoHelper.selectStandardJkMaterialName(mateList,orderCoForm);
		return selectStandardJkMaterialName;
	}
	
	/**
	 * 標準のオーダー内容確認画面GILET素材名
	 * @param mateList
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardGlMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm){
		Map<String, String> selectStandardGlMaterialName = orderCoHelper.selectStandardGlMaterialName(mateList,orderCoForm);
		return selectStandardGlMaterialName;
	}
	
	/**
	 * 標準のオーダー内容確認画面COAT素材名
	 * @param mateList
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardCtMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm){
		Map<String, String> selectStandardCtMaterialName = orderCoHelper.selectStandardCtMaterialName(mateList,orderCoForm);
		return selectStandardCtMaterialName;
	}
	
	/**
	 * 標準のオーダー内容確認画面PANTS素材名
	 * @param mateList
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardPtMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm){
		Map<String, String> selectStandardPtMaterialName = orderCoHelper.selectStandardPtMaterialName(mateList,orderCoForm);
		return selectStandardPtMaterialName;
	}
	
	/**
	 * 標準のオーダー内容確認画面2PANTS素材名
	 * @param mateList
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> standardPt2MateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm){
		Map<String, String> selectStandardPt2MaterialName = orderCoHelper.selectStandardPt2MaterialName(mateList,orderCoForm);
		return selectStandardPt2MaterialName;
	}
	
	/**
	 * 
	 * @param orderCoForm
	 * @return
	 */
	public List<OptionBranchDetail> getTuxedoMateList(OrderCoForm orderCoForm) {
		String productItem = orderCoForm.getProductItem();
		String orderPattern = orderCoForm.getOrderPattern();
		List<OptionBranchDetail> mateList = optionBranchDeailService.getTuxedoButtonsList(productItem,orderPattern);
		return mateList;
	}
	
	/**
	 * タキシードのオーダー内容確認画面JACKETの素材名
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> tuxedoJkMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm) {
		Map<String, String> selectTuxedoJkMaterialName = orderCoHelper.selectTuxedoJkMaterialName(mateList, orderCoForm);
		return selectTuxedoJkMaterialName;
	}
	
	/**
	 * タキシードのオーダー内容確認画面GILETの素材名
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> tuxedoGlMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm) {
		Map<String, String> selectTuxedoGlMaterialName = orderCoHelper.selectTuxedoGlMaterialName(mateList, orderCoForm);
		return selectTuxedoGlMaterialName;
	}
	
	/**
	 * タキシードのオーダー内容確認画面PANTSの素材名
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> tuxedoPtMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm) {
		Map<String, String> selectTuxedoPtMaterialName = orderCoHelper.selectTuxedoPtMaterialName(mateList, orderCoForm);
		return selectTuxedoPtMaterialName;
	}
	
	/**
	 * タキシードのオーダー内容確認画面PANTS2の素材名
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> tuxedoPt2MateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm) {
		Map<String, String> selectTuxedoPt2MaterialName = orderCoHelper.selectTuxedoPt2MaterialName(mateList, orderCoForm);
		return selectTuxedoPt2MaterialName;
	}
	
	/**
	 *
	 * @param orderCoForm
	 * @return
	 */
	public List<OptionBranchDetail> getWashableMateList(OrderCoForm orderCoForm) {
		String productItem = orderCoForm.getProductItem();
		String orderPattern = orderCoForm.getOrderPattern();
		List<OptionBranchDetail> mateList = optionBranchDeailService.getWashableButtonsList(productItem,orderPattern);
		return mateList;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面のJACKET素材名
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> washableJkMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm) {
		Map<String, String> selectWashableJkMaterialName = orderCoHelper.selectWashableJkMaterialName(mateList, orderCoForm);
		return selectWashableJkMaterialName;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面のGILET素材名
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> washableGlMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm) {
		Map<String, String> selectWashableGlMaterialName = orderCoHelper.selectWashableGlMaterialName(mateList, orderCoForm);
		return selectWashableGlMaterialName;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面のPANTS素材名
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> washablePtMateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm) {
		Map<String, String> selectWashablePtMaterialName = orderCoHelper.selectWashablePtMaterialName(mateList, orderCoForm);
		return selectWashablePtMaterialName;
	}
	
	/**
	 * ウォッシャブルのオーダー内容確認画面のPANTS2素材名
	 * @param orderCoForm
	 * @return
	 */
	public Map<String, String> washablePt2MateSelect(List<OptionBranchDetail> mateList,OrderCoForm orderCoForm) {
		Map<String, String> selectWashablePt2MaterialName = orderCoHelper.selectWashablePt2MaterialName(mateList, orderCoForm);
		return selectWashablePt2MaterialName;
	}
	
	/**
	 * JACKETのステッチ箇所変更下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectJkOjInsidePktPlaceList(OrderCoForm orderCoForm) {
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "02";
		String optionCode = "00025";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * JACKETのステッチ箇所変更下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectCoComplexItemsWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "02";
		String optionCode = "00025";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * JACKETのAMF色指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectJkOjAmfColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "02";
		String optionCode = "00030";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * JACKETのAMF色指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectJkOjAmfColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "02";
		String optionCode = "00030";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * JACKETのボタンホール色指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectJkOjBhColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "02";
		String optionCode = "00033";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * JACKETのボタンホール色指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectJkOjBhColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "02";
		String optionCode = "00033";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * JACKETのボタン付け糸指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectJkOjByColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "02";
		String optionCode = "00036";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * JACKETのボタン付け糸指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectJkOjByColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "02";
		String optionCode = "00036";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * GILETのステッチ箇所変更下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectGlOgStitchModifyPriceList(OrderCoForm orderCoForm) {
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "04";
		String optionCode = "00007";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * GILETのステッチ箇所変更下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectGlOgStitchModifyWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "04";
		String optionCode = "00007";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * GILETのAMF色指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectGlOjAmfColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "04";
		String optionCode = "00010";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * GILETのAMF色指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectGlOjAmfColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "04";
		String optionCode = "00010";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * GILETのボタンホール色指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectGlOjBhColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "04";
		String optionCode = "00013";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * GILETのボタンホール色指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectGlOjBhColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "04";
		String optionCode = "00013";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * GILETのボタン付け糸指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectGlOjByColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "04";
		String optionCode = "00016";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * GILETのボタン付け糸指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectGlOjByColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "04";
		String optionCode = "00016";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	
	
	/**
	 * PANTSのステッチ箇所変更下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPtOgStitchModifyPriceList(OrderCoForm orderCoForm) {
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "03";
		String optionCode = "00021";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * PANTSのステッチ箇所変更下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPtOgStitchModifyWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "03";
		String optionCode = "00021";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * PANTSのAMF色指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPtOjAmfColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "03";
		String optionCode = "00025";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * PANTSのAMF色指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPtOjAmfColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "03";
		String optionCode = "00025";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * PANTSのボタンホール色指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPtOjBhColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "03";
		String optionCode = "00028";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * PANTSのボタンホール色指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPtOjBhColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "03";
		String optionCode = "00028";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * PANTSのボタン付け糸指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPtOjByColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "03";
		String optionCode = "00031";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * PANTSのボタン付け糸指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPtOjByColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "03";
		String optionCode = "00031";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * PANTS2のステッチ箇所変更下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPt2OgStitchModifyPriceList(OrderCoForm orderCoForm) {
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "07";
		String optionCode = "00021";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * PANTS2のステッチ箇所変更下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPt2OgStitchModifyWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "07";
		String optionCode = "00021";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * PANTS2のAMF色指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPt2OjAmfColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "07";
		String optionCode = "00025";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * PANTS2のAMF色指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPt2OjAmfColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "07";
		String optionCode = "00025";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * PANTS2のボタンホール色指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPt2OjBhColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "07";
		String optionCode = "00028";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * PANTS2のボタンホール色指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPt2OjBhColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "07";
		String optionCode = "00028";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	/**
	 * PANTS2のボタン付け糸指定下代付属
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPt2OjByColorPriceList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "07";
		String optionCode = "00031";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList = nextGenerationService.selectCoComplexItemsAccessoryPriceList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsAccessoryPriceList;
	}
	
	/**
	 * PANTS2のボタン付け糸指定下代工賃
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectPt2OjByColorWageList(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		String subItem = "07";
		String optionCode = "00031";
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationService.selectCoComplexItemsWageList(factoryCode, itemCode, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}
	
	
	/**
	 * オプション対応の下代工賃と下代付属の取得
	 * @param orderForm
	 * @return
	 */
	public List<NextGenerationPrice> optionNextGenerationPrice(OrderCoForm orderCoForm) {
//		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
//		String productFabricNo = orderCoForm.getProductFabricNo();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		//JACKETのsubItemCode
		String jkSubItemCode = null;
		//GILETのsubItemCode
		String gtSubItemCode = null;
		//PANTSのsubItemCode
		String ptSubItemCode = null;
		//PANTS2のsubItemCode
		String pt2SubItemCode = null;
		//SHIRTのsubItemCode
		String stSubItemCode = null;
		//COATのsubItemCode
		String ctSubItemCode = null;
		Map<String, String> subItemCodeValue = orderCoHelper.subItemCoCodeValue(orderCoForm, jkSubItemCode, gtSubItemCode, ptSubItemCode, pt2SubItemCode, stSubItemCode, ctSubItemCode);
		jkSubItemCode = subItemCodeValue.get("jkSubItemCode");
		gtSubItemCode = subItemCodeValue.get("gtSubItemCode");
		ptSubItemCode = subItemCodeValue.get("ptSubItemCode");
		pt2SubItemCode = subItemCodeValue.get("pt2SubItemCode");
		stSubItemCode = subItemCodeValue.get("shirtSubItemCode");
		ctSubItemCode = subItemCodeValue.get("coatSubItemCode");
		//該当オプション対応の下代工賃と下代付属の取得
		List<NextGenerationPrice> optionNextGenerationPriceList= nextGenerationService.selectCoOptionNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode, factoryCode, itemCode, stSubItemCode, ctSubItemCode);
		return optionNextGenerationPriceList;
	}
	
	/**
	 * オプション選択肢詳細の下代価額の取得
	 * @param orderForm
	 * @return
	 */
	public List<NextGenerationPrice> detailNextGenerationPrice(OrderCoForm orderCoForm){
//		String orderPattern = orderCoForm.getOrderPattern();
//		String productFabricNo = orderCoForm.getProductFabricNo();
		String itemCode = orderCoForm.getProductItem();
//		OrderFindFabric orderFindFabric = orderService.getOrderFabric(productFabricNo, orderPattern);
		String factoryCode = orderCoForm.getProductFactoryCd();
		//JACKETのsubItemCode
		String jkSubItemCode = null;
		//GILETのsubItemCode
		String gtSubItemCode = null;
		//PANTSのsubItemCode
		String ptSubItemCode = null;
		//PANTS2のsubItemCode
		String pt2SubItemCode = null;
		//SHIRTのsubItemCode
		String stSubItemCode = null;
		//COATのsubItemCode
		String ctSubItemCode = null;
		Map<String, String> subItemCodeValue = orderCoHelper.subItemCoCodeValue(orderCoForm, jkSubItemCode, gtSubItemCode, ptSubItemCode, pt2SubItemCode, stSubItemCode, ctSubItemCode);
		jkSubItemCode = subItemCodeValue.get("jkSubItemCode");
		gtSubItemCode = subItemCodeValue.get("gtSubItemCode");
		ptSubItemCode = subItemCodeValue.get("ptSubItemCode");
		pt2SubItemCode = subItemCodeValue.get("pt2SubItemCode");
		stSubItemCode = subItemCodeValue.get("shirtSubItemCode");
		ctSubItemCode = subItemCodeValue.get("coatSubItemCode");
		//オプション選択肢詳細の下代工賃と下代付属の取得
		List<NextGenerationPrice> detailNextGenerationPriceList= nextGenerationService.selectCoDetailNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode, factoryCode, itemCode, stSubItemCode, ctSubItemCode);
		return detailNextGenerationPriceList;
	}
	
	/**
	 * 基本価格についての取得
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectCoBasicNextGenerationPrice(OrderCoForm orderCoForm){
		String fabricNo = orderCoForm.getProductFabricNo();
		String itemCode = orderCoForm.getProductItem();
		String factoryCd = orderCoForm.getProductFactoryCd();
		//JACKETのsubItemCode
		String jkSubItemCode = null;
		//GILETのsubItemCode
		String gtSubItemCode = null;
		//PANTSのsubItemCode
		String ptSubItemCode = null;
		//PANTS2のsubItemCode
		String pt2SubItemCode = null;
		//SHIRTのsubItemCode
		String stSubItemCode = null;
		//COATのsubItemCode
		String ctSubItemCode = null;
		Map<String, String> subItemCodeValue = orderCoHelper.subItemCoCodeValue(orderCoForm, jkSubItemCode, gtSubItemCode, ptSubItemCode, pt2SubItemCode, stSubItemCode, ctSubItemCode);
		jkSubItemCode = subItemCodeValue.get("jkSubItemCode");
		gtSubItemCode = subItemCodeValue.get("gtSubItemCode");
		ptSubItemCode = subItemCodeValue.get("ptSubItemCode");
		pt2SubItemCode = subItemCodeValue.get("pt2SubItemCode");
		stSubItemCode = subItemCodeValue.get("shirtSubItemCode");
		ctSubItemCode = subItemCodeValue.get("coatSubItemCode");
		List<NextGenerationPrice> selectCoBasicNextGenerationPriceList = nextGenerationService.selectCoBasicNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode, stSubItemCode, ctSubItemCode, itemCode, fabricNo,factoryCd);
		return selectCoBasicNextGenerationPriceList;
	}
	
	/**
	 * 要尺の取得
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectCoYield(OrderCoForm orderCoForm){
		//JACKETのsubItemCode
		String jkSubItemCode = null;
		//GILETのsubItemCode
		String gtSubItemCode = null;
		//PANTSのsubItemCode
		String ptSubItemCode = null;
		//PANTS2のsubItemCode
		String pt2SubItemCode = null;
		//SHIRTのsubItemCode
		String stSubItemCode = null;
		//COATのsubItemCode
		String ctSubItemCode = null;
		Map<String, String> subItemCodeValue = orderCoHelper.subItemCoCodeValue(orderCoForm, jkSubItemCode, gtSubItemCode, ptSubItemCode, pt2SubItemCode, stSubItemCode, ctSubItemCode);
		jkSubItemCode = subItemCodeValue.get("jkSubItemCode");
		gtSubItemCode = subItemCodeValue.get("gtSubItemCode");
		ptSubItemCode = subItemCodeValue.get("ptSubItemCode");
		pt2SubItemCode = subItemCodeValue.get("pt2SubItemCode");
		stSubItemCode = subItemCodeValue.get("shirtSubItemCode");
		ctSubItemCode = subItemCodeValue.get("coatSubItemCode");
		List<NextGenerationPrice> selectCoYield = nextGenerationService.selectCoYield(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode, stSubItemCode, ctSubItemCode);
		return selectCoYield;
	}
	/**
	 * 下代価格テーブルーについての項目
	 * @param orderCoForm
	 * @return
	 */
	public List<NextGenerationPrice> selectCoWholesalePiece(OrderCoForm orderCoForm){
		String fabricNo = orderCoForm.getProductFabricNo();
		String factoryCd = orderCoForm.getProductFactoryCd();
		List<NextGenerationPrice> selectCoWholesalePiece = nextGenerationService.selectCoWholesalePiece(fabricNo,factoryCd);
		return selectCoWholesalePiece;
	}
	
	/**
	 * マージンの取得
	 * @param orderCoForm
	 * @return
	 */
	public NextGenerationPrice selectCoMarginRate(OrderCoForm orderCoForm) {
		String fabricNo = orderCoForm.getProductFabricNo();
		String makerCode = orderCoForm.getProductMakerCode();
		NextGenerationPrice selectCoMarginRate = nextGenerationService.selectCoMarginRate(fabricNo,makerCode);
		return selectCoMarginRate;
	}
	
	/**
	 * 
	 * @param orderPattern
	 * @param itemCode
	 * @return
	 */
	public List<Adjust> getAdjustByItem(OrderCoForm orderCoForm) {
		String orderPattern = orderCoForm.getOrderPattern();
		String itemCode = orderCoForm.getProductItem();
		List<Adjust> adjustList = adjustService.getAdjustByItem(orderPattern,itemCode);
		return adjustList;
	}
	
	/**
	 * JACKETの標準値取得
	 * @param orderCoForm
	 * @return
	 */
	public List<TypeSizeOptimization> getCoJkTypeSizeOptimization(OrderCoForm orderCoForm) {
		String orderPattern = orderCoForm.getOrderPattern();
		String productCategory = orderCoForm.getProductCategory();
		String subItemCode = "02";
		String modelCode = null;
		if("9000101".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionJacketStandardInfo().getOjJacketModel();	
		}
		else if("9000102".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionJacketTuxedoInfo().getTjJacketModel();
		}
		else if("9000103".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionJacketWashableInfo().getWjJacketModel();
		}
		 
		String figure = orderCoForm.getCoAdjustJacketStandardInfo().getSizeFigure();
		String number = orderCoForm.getCoAdjustJacketStandardInfo().getSizeNumber();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coJkTypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return coJkTypeSizeOptimization;
	}

	/**
	 *GILETの標準値取得
	 * @param orderCoForm
	 * @return
	 */
	public List<TypeSizeOptimization> getCoGlTypeSizeOptimization(OrderCoForm orderCoForm) {
		String orderPattern = orderCoForm.getOrderPattern();
		String productCategory = orderCoForm.getProductCategory();
		String subItemCode = "04";
		String modelCode = null;
		if("9000101".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionGiletStandardInfo().getOgGiletModel();	
		}
		else if("9000102".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionGiletTuxedoInfo().getTgGiletModel();
		}
		else if("9000103".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionGiletWashableInfo().getWgGiletModel();
		}
		 
		String figure = orderCoForm.getCoAdjustGiletStandardInfo().getSizeFigure();
		String number = orderCoForm.getCoAdjustGiletStandardInfo().getSizeNumber();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coGlTypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return coGlTypeSizeOptimization;
	}
	
	/**
	 *PANTSの標準値取得
	 * @param orderCoForm
	 * @return
	 */
	public List<TypeSizeOptimization> getCoPtTypeSizeOptimization(OrderCoForm orderCoForm) {
		String orderPattern = orderCoForm.getOrderPattern();
		String productCategory = orderCoForm.getProductCategory();
		String subItemCode = "03";
		String modelCode = null;
		if("9000101".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPantsStandardInfo().getOpPantsModel();	
		}
		else if("9000102".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPantsTuxedoInfo().getTpPantsModel();
		}
		else if("9000103".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPantsWashableInfo().getWpPantsModel();
		}
		 
		String figure = orderCoForm.getCoAdjustPantsStandardInfo().getSizeFigure();
		String number = orderCoForm.getCoAdjustPantsStandardInfo().getSizeNumber();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coPtTypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return coPtTypeSizeOptimization;
	}
	
	/**
	 *2PANTSの標準値取得
	 * @param orderCoForm
	 * @return
	 */
	public List<TypeSizeOptimization> getCoPt2TypeSizeOptimization(OrderCoForm orderCoForm) {
		String orderPattern = orderCoForm.getOrderPattern();
		String productCategory = orderCoForm.getProductCategory();
		String subItemCode = "07";
		String modelCode = null;
		if("9000101".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPants2StandardInfo().getOp2PantsModel();	
		}
		else if("9000102".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPants2TuxedoInfo().getTp2PantsModel();
		}
		else if("9000103".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPants2WashableInfo().getWp2PantsModel();
		}
		 
		String figure = orderCoForm.getCoAdjustPants2StandardInfo().getSizeFigure();
		String number = orderCoForm.getCoAdjustPants2StandardInfo().getSizeNumber();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coPt2TypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return coPt2TypeSizeOptimization;
	}
	
	/**
	 *SHIRTの標準値取得
	 * @param orderCoForm
	 * @return
	 */
	public List<TypeSizeOptimization> getCoStTypeSizeOptimization(OrderCoForm orderCoForm) {
		String orderPattern = orderCoForm.getOrderPattern();
		String subItemCode = "05";
		String modelCode = orderCoForm.getCoOptionShirtStandardInfo().getOsShirtModel();	
		String figure = "";
		String number = orderCoForm.getCoAdjustShirtStandardInfo().getCorStSize();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coStTypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return coStTypeSizeOptimization;
	}
	
	/**
	 *COATの標準値取得
	 * @param orderCoForm
	 * @return
	 */
	public List<TypeSizeOptimization> getCoCtTypeSizeOptimization(OrderCoForm orderCoForm) {
		String orderPattern = orderCoForm.getOrderPattern();
		String subItemCode = "06";
		String modelCode = orderCoForm.getCoOptionCoatStandardInfo().getCoatModel();	
		String figure = "";
		String number = orderCoForm.getCoAdjustCoatStandardInfo().getCorCtSize();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coCtTypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return coCtTypeSizeOptimization;
	}
	
	/**
	 * 
	 * @param orderCoForm
	 * @param sessionStatus
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "orderCoReFormInDb", method = RequestMethod.POST)
	@TransactionTokenCheck(value = "create",type = TransactionTokenType.IN)
	public String orderCoReFormInDb(OrderCoForm orderCoForm,SessionStatus sessionStatus,Model model,Map<String, Map<String, Integer>> map) {
		
		Order order = new Order();
		Measuring measuring = new Measuring();
		//商品情報_ITEM
		String productItem = orderCoForm.getProductItem();
		//商品情報_３Piece
		String productIs3Piece = orderCoForm.getProductIs3Piece();
		//商品情報_スペアパンツ
		String productSparePantsClass = orderCoForm.getProductSparePantsClass();
		//３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		//３Pieceまたはスペアパンツは無し
		String productNo = "0009901";
		try {
			Order orderId = orderListService.findOrderByPk(orderCoForm.getCoCustomerMessageInfo().getOrderId());
			OrderFindFabric findStock = this.findStock(orderCoForm);
			NextGenerationPrice priceCode = this.getPriceCode(orderCoForm);
			priceCode.setMfaFactoryCode(orderCoForm.getProductFactoryCd());
			Order selectExistOrder = this.selectExistOrder(orderCoForm);
			List<NextGenerationPrice> selectCoYield = this.selectCoYield(orderCoForm);
			List<NextGenerationPrice> selectCoWholesalePiece = this.selectCoWholesalePiece(orderCoForm);
			List<NextGenerationPrice> selectCoBasicNextGenerationPrice = this.selectCoBasicNextGenerationPrice(orderCoForm);
			NextGenerationPrice selectCoMarginRate = this.selectCoMarginRate(orderCoForm);
			Map<String, Integer> retailPriceRelatedMap = this.retailPriceRelatedCoProjects(orderCoForm);
			List<Adjust> adjustByItem = this.getAdjustByItem(orderCoForm);
			//JACKETのステッチ箇所変更下代付属
//			List<NextGenerationPrice> selectJkOjInsidePktPlaceList = this.selectJkOjInsidePktPlaceList(orderCoForm);
			//JACKETのステッチ箇所変更下代工賃
//			List<NextGenerationPrice> selectCoComplexItemsWageList = this.selectCoComplexItemsWageList(orderCoForm);
			//JACKETのAMF色指定下代付属
			List<NextGenerationPrice> selectJkOjAmfColorPriceList = this.selectJkOjAmfColorPriceList(orderCoForm);
			//JACKETのAMF色指定下代工賃
			List<NextGenerationPrice> selectJkOjAmfColorWageList = this.selectJkOjAmfColorWageList(orderCoForm);
			//JACKETのボタンホール色指定下代付属
			List<NextGenerationPrice> selectJkOjBhColorPriceList = this.selectJkOjBhColorPriceList(orderCoForm);
			//JACKETのボタンホール色指定下代工賃
			List<NextGenerationPrice> selectJkOjBhColorWageList = this.selectJkOjBhColorWageList(orderCoForm);
			//JACKETのボタン付け糸指定下代付属
			List<NextGenerationPrice> selectJkOjByColorPriceList = this.selectJkOjByColorPriceList(orderCoForm);
			//JACKETのボタン付け糸指定下代工賃
			List<NextGenerationPrice> selectJkOjByColorWageList = this.selectJkOjByColorWageList(orderCoForm);
			
			//GILETのステッチ箇所変更下代付属
//			List<NextGenerationPrice> selectGlOgStitchModifyPriceList = this.selectGlOgStitchModifyPriceList(orderCoForm);
			//GILETのステッチ箇所変更下代工賃
//			List<NextGenerationPrice> selectGlOgStitchModifyWageList = this.selectGlOgStitchModifyWageList(orderCoForm);
			//GILETのAMF色指定下代付属
			List<NextGenerationPrice> selectGlOjAmfColorPriceList = this.selectGlOjAmfColorPriceList(orderCoForm);
			//GILETのAMF色指定下代工賃
			List<NextGenerationPrice> selectGlOjAmfColorWageList = this.selectGlOjAmfColorWageList(orderCoForm);
			//GILETのボタンホール色指定下代付属
			List<NextGenerationPrice> selectGlOjBhColorPriceList = this.selectGlOjBhColorPriceList(orderCoForm);
			//GILETのボタンホール色指定下代工賃
			List<NextGenerationPrice> selectGlOjBhColorWageList = this.selectGlOjBhColorWageList(orderCoForm);
			//GILETのボタン付け糸指定下代付属
			List<NextGenerationPrice> selectGlOjByColorPriceList = this.selectGlOjByColorPriceList(orderCoForm);
			//GILETのボタン付け糸指定下代工賃
			List<NextGenerationPrice> selectGlOjByColorWageList = this.selectGlOjByColorWageList(orderCoForm);
			
			//PANTSのステッチ箇所変更下代付属
//			List<NextGenerationPrice> selectPtOgStitchModifyPriceList = this.selectPtOgStitchModifyPriceList(orderCoForm);
			//PANTSのステッチ箇所変更下代工賃
//			List<NextGenerationPrice> selectPtOgStitchModifyWageList = this.selectPtOgStitchModifyWageList(orderCoForm);
			//PANTSのAMF色指定下代付属
			List<NextGenerationPrice> selectPtOjAmfColorPriceList = this.selectPtOjAmfColorPriceList(orderCoForm);
			//PANTSのAMF色指定下代工賃
			List<NextGenerationPrice> selectPtOjAmfColorWageList = this.selectPtOjAmfColorWageList(orderCoForm);
			//PANTSのボタンホール色指定下代付属
			List<NextGenerationPrice> selectPtOjBhColorPriceList = this.selectPtOjBhColorPriceList(orderCoForm);
			//PANTSのボタンホール色指定下代工賃
			List<NextGenerationPrice> selectPtOjBhColorWageList = this.selectPtOjBhColorWageList(orderCoForm);
			//PANTSのボタン付け糸指定下代付属
			List<NextGenerationPrice> selectPtOjByColorPriceList = this.selectPtOjByColorPriceList(orderCoForm);
			//PANTSのボタン付け糸指定下代工賃
			List<NextGenerationPrice> selectPtOjByColorWageList = this.selectPtOjByColorWageList(orderCoForm);
			
			//PANTS2のステッチ箇所変更下代付属
//			List<NextGenerationPrice> selectPt2OgStitchModifyPriceList = this.selectPt2OgStitchModifyPriceList(orderCoForm);
			//PANTS2のステッチ箇所変更下代工賃
//			List<NextGenerationPrice> selectPt2OgStitchModifyWageList = this.selectPt2OgStitchModifyWageList(orderCoForm);
			//PANTS2のAMF色指定下代付属
			List<NextGenerationPrice> selectPt2OjAmfColorPriceList = this.selectPt2OjAmfColorPriceList(orderCoForm);
			//PANTS2のAMF色指定下代工賃
			List<NextGenerationPrice> selectPt2OjAmfColorWageList = this.selectPt2OjAmfColorWageList(orderCoForm);
			//PANTS2のボタンホール色指定下代付属
			List<NextGenerationPrice> selectPt2OjBhColorPriceList = this.selectPt2OjBhColorPriceList(orderCoForm);
			//PANTS2のボタンホール色指定下代工賃
			List<NextGenerationPrice> selectPt2OjBhColorWageList = this.selectPt2OjBhColorWageList(orderCoForm);
			//PANTS2のボタン付け糸指定下代付属
			List<NextGenerationPrice> selectPt2OjByColorPriceList = this.selectPt2OjByColorPriceList(orderCoForm);
			//PANTS2のボタン付け糸指定下代工賃
			List<NextGenerationPrice> selectPt2OjByColorWageList = this.selectPt2OjByColorWageList(orderCoForm);
			
			//orderCoFormの対象とorderの対応フィールドのマッピング
			standardBeanMapper.map(orderCoForm.getCoCustomerMessageInfo(),order);
			standardBeanMapper.map(orderCoForm,order);
			orderCoHelper.measuringMapping(orderCoForm, measuring,sessionContent.getUserId());
			
			//標準の場合
			if("9000101".equals(orderCoForm.getProductCategory())) {
				List<OptionBranchDetail> mateList = this.getMateList(orderCoForm);
				
				List<NextGenerationPrice> optionNextGenerationPriceList = this.optionNextGenerationPrice(orderCoForm);
				List<NextGenerationPrice> pants2OptionTypeList = optionNextGenerationPriceList.stream().filter(a -> a.getMobSubItemCode().equals("07")).collect(Collectors.toList());
				List<NextGenerationPrice> pantsOptionTypeList = optionNextGenerationPriceList.stream().filter(a -> a.getMobSubItemCode().equals("03")).collect(Collectors.toList());
				List<NextGenerationPrice> giletOptionTypeList = optionNextGenerationPriceList.stream().filter(a -> a.getMobSubItemCode().equals("04")).collect(Collectors.toList());
				
				//商品情報_３Piece_下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getGl3PieceNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				//商品情報_スペアパンツ_下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getSparePantsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				//商品情報_LCR縫製下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getProductLcrSewingWsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				//お客様情報_納期短縮下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getCustIsDeliverShortningWsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				
				//SUITの場合、itemCodeは"01"
				if("01".equals(productItem)) {
					List<NextGenerationPrice> detailNextGenerationPriceList = this.detailNextGenerationPrice(orderCoForm);	
					orderCoHelper.setProductItemDisplayCode(orderCoForm, order);
					//標準JACKET　素材名
					Map<String, String> selectStandardJkMaterialName = this.standardJkMateSelect(mateList, orderCoForm);
					//JACKETについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionJacketStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
					//JACKETの項目名表示
					orderCoHelper.orderCoStandardJacketMapping(orderCoForm, order);
					//JACKETの素材Name表示
					orderCoHelper.orderCoStandardJkNameMapping(selectStandardJkMaterialName, order);
					//JACKETのグループ項目名とコード
					orderCoHelper.aboutJacketCheckBoxInDb(orderCoForm, order);
					//JACKET項目の下代工賃とJACKET_下代付属をデータベースに入力する
					orderCoHelper.getCoStandardJkNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
					//JACKETオプション付属詳細項目の下代工賃とJACKET_下代付属をデータベースに入力する
					orderCoHelper.getCoStandardJkDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//JACKETのステッチ箇所変更下代工賃
//					orderCoHelper.standardJkOjStitchModifyPlaceNextWageCount(orderCoForm, order, selectCoComplexItemsWageList);
					//JACKETのステッチ箇所変更下代付属
//					orderCoHelper.standardJkOjStitchModifyPlaceNextPriceCount(orderCoForm, order, selectJkOjInsidePktPlaceList);
					//JACKETのAMF色指定下代工賃
					orderCoHelper.standardJkOjAmfColorNextWageCount(orderCoForm, order, selectJkOjAmfColorWageList);
					//JACKETのAMF色指定下代付属
					orderCoHelper.standardJkOjAmfColorNextPriceCount(orderCoForm, order, selectJkOjAmfColorPriceList);
					//JACKETのボタンホール色指定下代工賃
					orderCoHelper.standardJkOjBhColorPlaceNextWageCount(orderCoForm, order, selectJkOjBhColorWageList);
					//JACKETのボタンホール色指定下代付属
					orderCoHelper.standardJkOjBhColorPlaceNextPriceCount(orderCoForm, order, selectJkOjBhColorPriceList);
					//JACKETのボタン付け糸指定の下代工賃
					orderCoHelper.standardJkOjByColorPlaceNextWageCount(orderCoForm, order, selectJkOjByColorWageList);
					//JACKETのボタン付け糸指定の下代付属
					orderCoHelper.standardJkOjByColorPlaceNextPriceCount(orderCoForm, order, selectJkOjByColorPriceList);
					
					//標準PANTS素材名
					Map<String, String> standardPtMateSelectName = this.standardPtMateSelect(mateList, orderCoForm);
					//PANTSについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionPantsStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
					//PANTSの項目名表示
					orderCoHelper.orderCoStandardPantsMapping(orderCoForm, order);
					//PANTSの素材Name表示
					orderCoHelper.orderCoStandardPtNameMapping(standardPtMateSelectName, order);
					//PANTSのグループ項目名とコード
					orderCoHelper.aboutPantsCheckBoxInDb(orderCoForm, order);
					//PANTS項目の下代工賃とPANTS_下代付属をデータベースに入力する
					orderCoHelper.getCoStandardPtNextGenerationPrice(orderCoForm, order, pantsOptionTypeList);
					//PANTSオプション付属詳細項目の下代工賃とPANTS_下代付属をデータベースに入力する
					orderCoHelper.getCoStandardPtDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//PANTSのステッチ箇所変更下代工賃
//					orderCoHelper.standardPtOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectPtOgStitchModifyWageList);
					//PANTSのステッチ箇所変更下代付属
//					orderCoHelper.standardPtOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectPtOgStitchModifyPriceList);
					//PANTSのAMF色指定の下代工賃
					orderCoHelper.standardPtOpAmfColorPlaceNextWageCount(orderCoForm, order, selectPtOjAmfColorWageList);
					//PANTSのAMF色指定の下代付属
					orderCoHelper.standardPtOpAmfColorPlaceNextPriceCount(orderCoForm, order, selectPtOjAmfColorPriceList);
					//PANTSのボタンホール色指定の下代工賃
					orderCoHelper.standardPtOpBhColorPlaceNextWageCount(orderCoForm, order, selectPtOjBhColorWageList);
					//PANTSのボタンホール色指定の下代付属
					orderCoHelper.standardPtOpBhColorPlaceNextPriceCount(orderCoForm, order, selectPtOjBhColorPriceList);
					//PANTSのボタン付け糸指定の下代工賃
					orderCoHelper.standardPtOpByColorPlaceNextWageCount(orderCoForm, order, selectPtOjByColorWageList);
					//PANTSのボタン付け糸指定の下代付属
					orderCoHelper.standardPtOpByColorPlaceNextPriceCount(orderCoForm, order, selectPtOjByColorPriceList);
					
					//３Pieceは有り、スペアパンツは有りの場合
					if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//標準GILET素材名
						Map<String, String> standardGlMateSelectName = this.standardGlMateSelect(mateList, orderCoForm);
						//GILETについてのマピンッグ
						standardBeanMapper.map(orderCoForm.getCoOptionGiletStandardInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
						//GILETの項目名表示
						orderCoHelper.orderCoStandardGiletMapping(orderCoForm, order);
						//GILETの素材Name表示
						orderCoHelper.orderCoStandardGlNameMapping(standardGlMateSelectName, order);
						//GILETのグループ項目名とコード
						orderCoHelper.aboutGiletCheckBoxInDb(orderCoForm, order);
						//GILET項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoStandardGlNextGenerationPrice(orderCoForm, order, giletOptionTypeList);
						//GILETオプション付属詳細項目の下代工賃とGILET_下代付属をデータベースに入力する
						orderCoHelper.getCoStandardGlDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//GILETのステッチ箇所変更下代工賃
//						orderCoHelper.standardGlOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectGlOgStitchModifyWageList);
						//GILETのステッチ箇所変更下代付属
//						orderCoHelper.standardGlOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectGlOgStitchModifyPriceList);
						//GILETのAMF色指定の下代工賃
						orderCoHelper.standardGlOgAmfColorPlaceNextWageCount(orderCoForm, order, selectGlOjAmfColorWageList);
						//GILETのAMF色指定の下代付属
						orderCoHelper.standardGlOgAmfColorPlaceNextPriceCount(orderCoForm, order, selectGlOjAmfColorPriceList);
						//GILETのボタンホール色指定の下代工賃
						orderCoHelper.standardGlOgBhColorPlaceNextWageCount(orderCoForm, order, selectGlOjBhColorWageList);
						//GILETのボタンホール色指定の下代付属
						orderCoHelper.standardGlOgBhColorPlaceNextPriceCount(orderCoForm, order, selectGlOjBhColorPriceList);
						//GILETのボタン付け糸指定の下代工賃
						orderCoHelper.standardGlOgByColorPlaceNextWageCount(orderCoForm, order, selectGlOjByColorWageList);
						//GILETのボタン付け糸指定の下代付属
						orderCoHelper.standardGlOgByColorPlaceNextPriceCount(orderCoForm, order, selectGlOjByColorPriceList);
						
						//標準2PANTS素材名
						Map<String, String> standardPt2MateSelectName = this.standardPt2MateSelect(mateList, orderCoForm);
						//2PANTSについてのマピンッグ
						standardBeanMapper.map(orderCoForm.getCoOptionPants2StandardInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
						//PANTS2の項目名表示
						orderCoHelper.orderCoStandardPants2Mapping(orderCoForm, order);
						//PANTS2の素材Name表示
						orderCoHelper.orderCoStandardPt2NameMapping(standardPt2MateSelectName, order);
						//PANTS2のグループ項目名とコード
						orderCoHelper.aboutPants2CheckBoxInDb(orderCoForm, order);
						//PANTS2項目の下代工賃とPANTS2下代付属をデータベースに入力する
						orderCoHelper.getCoStandardPt2NextGenerationPrice(orderCoForm, order, pants2OptionTypeList);
						//PANTS2オプション付属詳細項目の下代工賃とPANTS2_下代付属をデータベースに入力する
						orderCoHelper.getCoStandardPt2DetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//PANTS2のステッチ箇所変更の下代工賃
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextWageCount(orderCoForm, order, selectPt2OgStitchModifyWageList);
						//PANTS2のステッチ箇所変更の下代付属
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextPriceCount(orderCoForm, order, selectPt2OgStitchModifyPriceList);
						//PANTS2のAMF色指定の下代工賃
						orderCoHelper.standardPt2Op2AmfColorPlaceNextWageCount(orderCoForm, order, selectPt2OjAmfColorWageList);
						//PANTS2のAMF色指定の下代付属
						orderCoHelper.standardPt2Op2AmfColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjAmfColorPriceList);
						//PANTS2のボタンホール色指定の下代工賃
						orderCoHelper.standardPt2Op2BhColorPlaceNextWageCount(orderCoForm, order, selectPt2OjBhColorWageList);
						//PANTS2のボタンホール色指定の下代付属
						orderCoHelper.standardPt2Op2BhColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjBhColorPriceList);
						//PANTS2のボタン付け糸指定の下代工賃
						orderCoHelper.standardPt2Op2ByColorPlaceNextWageCount(orderCoForm, order, selectPt2OjByColorWageList);
						//PANTS2のボタン付け糸指定の下代付属
						orderCoHelper.standardPt2Op2ByColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjByColorPriceList);
						
					}
					//３Pieceは有り、スペアパンツは無しの場合
					else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
						//標準GILET素材名
						Map<String, String> standardGlMateSelectName = this.standardGlMateSelect(mateList, orderCoForm);
						//GILETについてのマピンッグ
						standardBeanMapper.map(orderCoForm.getCoOptionGiletStandardInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
						//GILETの項目名表示
						orderCoHelper.orderCoStandardGiletMapping(orderCoForm, order);
						//GILETの素材Name表示
						orderCoHelper.orderCoStandardGlNameMapping(standardGlMateSelectName, order);
						//GILETのグループ項目名とコード
						orderCoHelper.aboutGiletCheckBoxInDb(orderCoForm, order);
						//GILET項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoStandardGlNextGenerationPrice(orderCoForm, order, giletOptionTypeList);
						//GILETオプション付属詳細項目の下代工賃とGILET_下代付属をデータベースに入力する
						orderCoHelper.getCoStandardGlDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//GILETのステッチ箇所変更下代工賃
//						orderCoHelper.standardGlOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectGlOgStitchModifyWageList);
						//GILETのステッチ箇所変更下代付属
//						orderCoHelper.standardGlOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectGlOgStitchModifyPriceList);
						//GILETのAMF色指定の下代工賃
						orderCoHelper.standardGlOgAmfColorPlaceNextWageCount(orderCoForm, order, selectGlOjAmfColorWageList);
						//GILETのAMF色指定の下代付属
						orderCoHelper.standardGlOgAmfColorPlaceNextPriceCount(orderCoForm, order, selectGlOjAmfColorPriceList);
						//GILETのボタンホール色指定の下代工賃
						orderCoHelper.standardGlOgBhColorPlaceNextWageCount(orderCoForm, order, selectGlOjBhColorWageList);
						//GILETのボタンホール色指定の下代付属
						orderCoHelper.standardGlOgBhColorPlaceNextPriceCount(orderCoForm, order, selectGlOjBhColorPriceList);
						//GILETのボタン付け糸指定の下代工賃
						orderCoHelper.standardGlOgByColorPlaceNextWageCount(orderCoForm, order, selectGlOjByColorWageList);
						//GILETのボタン付け糸指定の下代付属
						orderCoHelper.standardGlOgByColorPlaceNextPriceCount(orderCoForm, order, selectGlOjByColorPriceList);
						
					}
					//３Pieceは無し、スペアパンツは有りの場合
					else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//標準2PANTS素材名
						Map<String, String> standardPt2MateSelectName = this.standardPt2MateSelect(mateList, orderCoForm);
						//2PANTSについてのマピンッグ
						standardBeanMapper.map(orderCoForm.getCoOptionPants2StandardInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
						//PANTS2の項目名表示
						orderCoHelper.orderCoStandardPants2Mapping(orderCoForm, order);
						//PANTS2の素材Name表示
						orderCoHelper.orderCoStandardPt2NameMapping(standardPt2MateSelectName, order);
						//PANTS2のグループ項目名とコード
						orderCoHelper.aboutPants2CheckBoxInDb(orderCoForm, order);
						//PANTS2項目の下代工賃とPANTS2下代付属をデータベースに入力する
						orderCoHelper.getCoStandardPt2NextGenerationPrice(orderCoForm, order, pants2OptionTypeList);
						//PANTS2オプション付属詳細項目の下代工賃とPANTS2_下代付属をデータベースに入力する
						orderCoHelper.getCoStandardPt2DetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//PANTS2のステッチ箇所変更の下代工賃
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextWageCount(orderCoForm, order, selectPt2OgStitchModifyWageList);
						//PANTS2のステッチ箇所変更の下代付属
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextPriceCount(orderCoForm, order, selectPt2OgStitchModifyPriceList);
						//PANTS2のAMF色指定の下代工賃
						orderCoHelper.standardPt2Op2AmfColorPlaceNextWageCount(orderCoForm, order, selectPt2OjAmfColorWageList);
						//PANTS2のAMF色指定の下代付属
						orderCoHelper.standardPt2Op2AmfColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjAmfColorPriceList);
						//PANTS2のボタンホール色指定の下代工賃
						orderCoHelper.standardPt2Op2BhColorPlaceNextWageCount(orderCoForm, order, selectPt2OjBhColorWageList);
						//PANTS2のボタンホール色指定の下代付属
						orderCoHelper.standardPt2Op2BhColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjBhColorPriceList);
						//PANTS2のボタン付け糸指定の下代工賃
						orderCoHelper.standardPt2Op2ByColorPlaceNextWageCount(orderCoForm, order, selectPt2OjByColorWageList);
						//PANTS2のボタン付け糸指定の下代付属
						orderCoHelper.standardPt2Op2ByColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjByColorPriceList);
					}
					else {
						order.setProductIs3pieceRtPrice(0);
						order.setProductIs3pieceWsWage(new BigDecimal(0));
						order.setProductIs3pieceWsPrice(0);
					}
				}
				//JACKETの場合、itemCodeは"02"
				else if("02".equals(productItem)) {
					List<NextGenerationPrice> detailNextGenerationPriceList = this.detailNextGenerationPrice(orderCoForm);	
					
					//標準JACKET素材名
					Map<String, String> selectStandardJkMaterialName = this.standardJkMateSelect(mateList, orderCoForm);
					//JACKETについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionJacketStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
					//JACKETの項目名表示
					orderCoHelper.orderCoStandardJacketMapping(orderCoForm, order);
					//JACKETの素材Name表示
					orderCoHelper.orderCoStandardJkNameMapping(selectStandardJkMaterialName, order);
					//JACKETのグループ項目名とコード
					orderCoHelper.aboutJacketCheckBoxInDb(orderCoForm, order);
					//JACKET項目の下代工賃とJACKET_下代付属をデータベースに入力する
					orderCoHelper.getCoStandardJkNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
					//JACKETオプション付属詳細項目の下代工賃とJACKET_下代付属をデータベースに入力する
					orderCoHelper.getCoStandardJkDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//JACKETのステッチ箇所変更下代工賃
//					orderCoHelper.standardJkOjStitchModifyPlaceNextWageCount(orderCoForm, order, selectCoComplexItemsWageList);
					//JACKETのステッチ箇所変更下代付属
//					orderCoHelper.standardJkOjStitchModifyPlaceNextPriceCount(orderCoForm, order, selectJkOjInsidePktPlaceList);
					//JACKETのAMF色指定下代工賃
					orderCoHelper.standardJkOjAmfColorNextWageCount(orderCoForm, order, selectJkOjAmfColorWageList);
					//JACKETのAMF色指定下代付属
					orderCoHelper.standardJkOjAmfColorNextPriceCount(orderCoForm, order, selectJkOjAmfColorPriceList);
					//JACKETのボタンホール色指定下代工賃
					orderCoHelper.standardJkOjBhColorPlaceNextWageCount(orderCoForm, order, selectJkOjBhColorWageList);
					//JACKETのボタンホール色指定下代付属
					orderCoHelper.standardJkOjBhColorPlaceNextPriceCount(orderCoForm, order, selectJkOjBhColorPriceList);
					//JACKETのボタン付け糸指定の下代工賃
					orderCoHelper.standardJkOjByColorPlaceNextWageCount(orderCoForm, order, selectJkOjByColorWageList);
					//JACKETのボタン付け糸指定の下代付属
					orderCoHelper.standardJkOjByColorPlaceNextPriceCount(orderCoForm, order, selectJkOjByColorPriceList);
				}
				//PANTSの場合、itemCodeは"03"
				else if("03".equals(productItem)) {
					List<NextGenerationPrice> detailNextGenerationPriceList = this.detailNextGenerationPrice(orderCoForm);	
					//標準PANTS素材名
					Map<String, String> standardPtMateSelectName = this.standardPtMateSelect(mateList, orderCoForm);
					//PANTSについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionPantsStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
					//PANTSの項目名表示
					orderCoHelper.orderCoStandardPantsMapping(orderCoForm, order);
					//PANTSの素材Name表示
					orderCoHelper.orderCoStandardPtNameMapping(standardPtMateSelectName, order);
					//PANTSのグループ項目名とコード
					orderCoHelper.aboutPantsCheckBoxInDb(orderCoForm, order);
					//PANTS項目の下代工賃とPANTS_下代付属をデータベースに入力する
					orderCoHelper.getCoStandardPtNextGenerationPrice(orderCoForm, order, pantsOptionTypeList);
					//PANTSオプション付属詳細項目の下代工賃とPANTS_下代付属をデータベースに入力する
					orderCoHelper.getCoStandardPtDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//PANTSのステッチ箇所変更下代工賃
//					orderCoHelper.standardPtOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectPtOgStitchModifyWageList);
					//PANTSのステッチ箇所変更下代付属
//					orderCoHelper.standardPtOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectPtOgStitchModifyPriceList);
					//PANTSのAMF色指定の下代工賃
					orderCoHelper.standardPtOpAmfColorPlaceNextWageCount(orderCoForm, order, selectPtOjAmfColorWageList);
					//PANTSのAMF色指定の下代付属
					orderCoHelper.standardPtOpAmfColorPlaceNextPriceCount(orderCoForm, order, selectPtOjAmfColorPriceList);
					//PANTSのボタンホール色指定の下代工賃
					orderCoHelper.standardPtOpBhColorPlaceNextWageCount(orderCoForm, order, selectPtOjBhColorWageList);
					//PANTSのボタンホール色指定の下代付属
					orderCoHelper.standardPtOpBhColorPlaceNextPriceCount(orderCoForm, order, selectPtOjBhColorPriceList);
					//PANTSのボタン付け糸指定の下代工賃
					orderCoHelper.standardPtOpByColorPlaceNextWageCount(orderCoForm, order, selectPtOjByColorWageList);
					//PANTSのボタン付け糸指定の下代付属
					orderCoHelper.standardPtOpByColorPlaceNextPriceCount(orderCoForm, order, selectPtOjByColorPriceList);
				}
				//GILETの場合、itemCodeは"04"
				else if("04".equals(productItem)) {
					List<NextGenerationPrice> detailNextGenerationPriceList = this.detailNextGenerationPrice(orderCoForm);	
					//標準GILET素材名
					Map<String, String> standardGlMateSelectName = this.standardGlMateSelect(mateList, orderCoForm);
					//GILETについてのマピンッグ
					standardBeanMapper.map(orderCoForm.getCoOptionGiletStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					//GILETの項目名表示
					orderCoHelper.orderCoStandardGiletMapping(orderCoForm, order);
					//GILETの素材Name表示
					orderCoHelper.orderCoStandardGlNameMapping(standardGlMateSelectName, order);
					//GILETのグループ項目名とコード
					orderCoHelper.aboutGiletCheckBoxInDb(orderCoForm, order);
					//GILET項目の下代工賃とGILET下代付属をデータベースに入力する
					orderCoHelper.getCoStandardGlNextGenerationPrice(orderCoForm, order, giletOptionTypeList);
					//GILETオプション付属詳細項目の下代工賃とGILET_下代付属をデータベースに入力する
					orderCoHelper.getCoStandardGlDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//GILETのステッチ箇所変更下代工賃
//					orderCoHelper.standardGlOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectGlOgStitchModifyWageList);
					//GILETのステッチ箇所変更下代付属
//					orderCoHelper.standardGlOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectGlOgStitchModifyPriceList);
					//GILETのAMF色指定の下代工賃
					orderCoHelper.standardGlOgAmfColorPlaceNextWageCount(orderCoForm, order, selectGlOjAmfColorWageList);
					//GILETのAMF色指定の下代付属
					orderCoHelper.standardGlOgAmfColorPlaceNextPriceCount(orderCoForm, order, selectGlOjAmfColorPriceList);
					//GILETのボタンホール色指定の下代工賃
					orderCoHelper.standardGlOgBhColorPlaceNextWageCount(orderCoForm, order, selectGlOjBhColorWageList);
					//GILETのボタンホール色指定の下代付属
					orderCoHelper.standardGlOgBhColorPlaceNextPriceCount(orderCoForm, order, selectGlOjBhColorPriceList);
					//GILETのボタン付け糸指定の下代工賃
					orderCoHelper.standardGlOgByColorPlaceNextWageCount(orderCoForm, order, selectGlOjByColorWageList);
					//GILETのボタン付け糸指定の下代付属
					orderCoHelper.standardGlOgByColorPlaceNextPriceCount(orderCoForm, order, selectGlOjByColorPriceList);
				}
				//SHIRTの場合、itemCodeは"05"
				else if("05".equals(productItem)) {
					standardBeanMapper.map(orderCoForm.getCoOptionShirtStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustShirtStandardInfo(), order);
					//SHIRTの項目名表示
					orderCoHelper.orderCoStandardShirtMapping(orderCoForm, order);
					//SHIRT項目の下代工賃とSHIRT下代付属をデータベースに入力する
					orderCoHelper.getCoStandardStNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
					String productEmbroideryNecessity = orderCoForm.getProductEmbroideryNecessity();
					
					if("9000502".equals(productEmbroideryNecessity)) {
						//商品情報_ガゼット刺繍下代工賃と下代付属をデータベースに入力する
						orderCoHelper.getProductEmbroideryGazetteNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
						//商品情報_刺繍箇所下代工賃と下代付属をデータベースに入力する
						orderCoHelper.getProductEmbroideryNmPosWsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
					}
					
				}
				//COATの場合、itemCodeは"06"
				else if("06".equals(productItem)) {
					List<NextGenerationPrice> detailNextGenerationPriceList = this.detailNextGenerationPrice(orderCoForm);	
					//標準COAT素材名
					Map<String, String> standardCtMateSelectName = this.standardCtMateSelect(mateList, orderCoForm);
					standardBeanMapper.map(orderCoForm.getCoOptionCoatStandardInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustCoatStandardInfo(), order);
					//COATの項目名表示
					orderCoHelper.orderCoStandardCoatMapping(orderCoForm, order);
					//COATの素材Name表示
					orderCoHelper.orderCoStandardCtNameMapping(standardCtMateSelectName, order);
					//COAT項目の下代工賃とCOAT下代付属をデータベースに入力する
					orderCoHelper.getCoStandardCtNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
					//COATオプション付属詳細項目の下代工賃とCOAT下代付属をデータベースに入力する
					orderCoHelper.getCoStandardCtDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
				}
			}
			//タキシードの場合
			if("9000102".equals(orderCoForm.getProductCategory())) {
				
				List<NextGenerationPrice> optionNextGenerationPriceList = this.optionNextGenerationPrice(orderCoForm);
				List<NextGenerationPrice> pants2OptionTypeList = optionNextGenerationPriceList.stream().filter(a -> a.getMobSubItemCode().equals("07")).collect(Collectors.toList());
				List<NextGenerationPrice> pantsOptionTypeList = optionNextGenerationPriceList.stream().filter(a -> a.getMobSubItemCode().equals("03")).collect(Collectors.toList());
				List<NextGenerationPrice> giletOptionTypeList = optionNextGenerationPriceList.stream().filter(a -> a.getMobSubItemCode().equals("04")).collect(Collectors.toList());
				List<NextGenerationPrice> detailNextGenerationPriceList = this.detailNextGenerationPrice(orderCoForm);
				
				//商品情報_３Piece_下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getGl3PieceNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				//商品情報_スペアパンツ_下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getSparePantsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				//商品情報_LCR縫製下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getProductLcrSewingWsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				//お客様情報_納期短縮下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getCustIsDeliverShortningWsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				
				List<OptionBranchDetail> tuxedoMateList = this.getTuxedoMateList(orderCoForm);
				//タキシードPANTS素材名
				Map<String, String> selectTuxedoJkMaterialName = this.tuxedoJkMateSelect(tuxedoMateList, orderCoForm);
				//タキシードGILET素材名
				Map<String, String> tuxedoGlMateSelectName = this.tuxedoGlMateSelect(tuxedoMateList, orderCoForm);
				//タキシードJACKET素材名
				Map<String, String> tuxedoPtMateSelectName = this.tuxedoPtMateSelect(tuxedoMateList, orderCoForm);
				//タキシードPANTS2素材名
				Map<String, String> tuxedoPt2MateSelectName = this.tuxedoPt2MateSelect(tuxedoMateList, orderCoForm);
				//SUITの場合、itemCodeは"01"
				if("01".equals(productItem)) {
					orderCoHelper.setProductItemDisplayCode(orderCoForm, order);
					//JACKETについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionJacketTuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
					//JACKETの項目名
					orderCoHelper.orderCoTuxedoJacketMapping(orderCoForm, order);
					//JACKETの素材名表示
					orderCoHelper.orderCoTuxedoJkNameMapping(selectTuxedoJkMaterialName, order);
					//JACKETのグループ項目名とコード
					orderCoHelper.aboutTuxedoJacketCheckBoxInDb(orderCoForm, order);
					//JACKET項目の下代工賃とJACKET下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoJkNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
					//JACKETオプション付属詳細項目の下代工賃とJACKET下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoJkDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//JACKETのステッチ箇所変更下代工賃
//					orderCoHelper.standardJkOjStitchModifyPlaceNextWageCount(orderCoForm, order, selectCoComplexItemsWageList);
					//JACKETのステッチ箇所変更下代付属
//					orderCoHelper.standardJkOjStitchModifyPlaceNextPriceCount(orderCoForm, order, selectJkOjInsidePktPlaceList);
					//JACKETのAMF色指定下代工賃
					orderCoHelper.standardJkOjAmfColorNextWageCount(orderCoForm, order, selectJkOjAmfColorWageList);
					//JACKETのAMF色指定下代付属
					orderCoHelper.standardJkOjAmfColorNextPriceCount(orderCoForm, order, selectJkOjAmfColorPriceList);
					//JACKETのボタンホール色指定下代工賃
					orderCoHelper.standardJkOjBhColorPlaceNextWageCount(orderCoForm, order, selectJkOjBhColorWageList);
					//JACKETのボタンホール色指定下代付属
					orderCoHelper.standardJkOjBhColorPlaceNextPriceCount(orderCoForm, order, selectJkOjBhColorPriceList);
					//JACKETのボタン付け糸指定の下代工賃
					orderCoHelper.standardJkOjByColorPlaceNextWageCount(orderCoForm, order, selectJkOjByColorWageList);
					//JACKETのボタン付け糸指定の下代付属
					orderCoHelper.standardJkOjByColorPlaceNextPriceCount(orderCoForm, order, selectJkOjByColorPriceList);
					
					//PANTSについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionPantsTuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
					//PANTSの項目名
					orderCoHelper.orderCoTuxedoPantsMapping(orderCoForm, order);
					//PANTSの素材名表示
					orderCoHelper.orderCoTuxedoPtNameMapping(tuxedoPtMateSelectName, order);
					//PANTSのグループ項目名とコード
					orderCoHelper.aboutTuxedoPantsCheckBoxInDb(orderCoForm, order);
					//PANTS項目の下代工賃とPANTS下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoPtNextGenerationPrice(orderCoForm, order, pantsOptionTypeList);
					//PANTSオプション付属詳細項目の下代工賃とPANTS下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoPtDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//PANTSのステッチ箇所変更下代工賃
//					orderCoHelper.standardPtOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectPtOgStitchModifyWageList);
					//PANTSのステッチ箇所変更下代付属
//					orderCoHelper.standardPtOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectPtOgStitchModifyPriceList);
					//PANTSのAMF色指定の下代工賃
					orderCoHelper.standardPtOpAmfColorPlaceNextWageCount(orderCoForm, order, selectPtOjAmfColorWageList);
					//PANTSのAMF色指定の下代付属
					orderCoHelper.standardPtOpAmfColorPlaceNextPriceCount(orderCoForm, order, selectPtOjAmfColorPriceList);
					//PANTSのボタンホール色指定の下代工賃
					orderCoHelper.standardPtOpBhColorPlaceNextWageCount(orderCoForm, order, selectPtOjBhColorWageList);
					//PANTSのボタンホール色指定の下代付属
					orderCoHelper.standardPtOpBhColorPlaceNextPriceCount(orderCoForm, order, selectPtOjBhColorPriceList);
					//PANTSのボタン付け糸指定の下代工賃
					orderCoHelper.standardPtOpByColorPlaceNextWageCount(orderCoForm, order, selectPtOjByColorWageList);
					//PANTSのボタン付け糸指定の下代付属
					orderCoHelper.standardPtOpByColorPlaceNextPriceCount(orderCoForm, order, selectPtOjByColorPriceList);
					
					//３Pieceは有り、スペアパンツは有りの場合
					if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						tuxedoBeanMapper.map(orderCoForm.getCoOptionGiletTuxedoInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
						//GILETの項目名
						orderCoHelper.orderCoTuxedoGiletMapping(orderCoForm, order);
						//GILETの素材名表示
						orderCoHelper.orderCoTuxedoGlNameMapping(tuxedoGlMateSelectName, order);
						//GILETのグループ項目名とコード
						orderCoHelper.aboutTuxedoGiletCheckBoxInDb(orderCoForm, order);
						//GILET項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoTuxedoGlNextGenerationPrice(orderCoForm, order, giletOptionTypeList);
						//GILETオプション付属詳細項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoTuxedoGlDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//GILETのステッチ箇所変更下代工賃
//						orderCoHelper.standardGlOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectGlOgStitchModifyWageList);
						//GILETのステッチ箇所変更下代付属
//						orderCoHelper.standardGlOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectGlOgStitchModifyPriceList);
						//GILETのAMF色指定の下代工賃
						orderCoHelper.standardGlOgAmfColorPlaceNextWageCount(orderCoForm, order, selectGlOjAmfColorWageList);
						//GILETのAMF色指定の下代付属
						orderCoHelper.standardGlOgAmfColorPlaceNextPriceCount(orderCoForm, order, selectGlOjAmfColorPriceList);
						//GILETのボタンホール色指定の下代工賃
						orderCoHelper.standardGlOgBhColorPlaceNextWageCount(orderCoForm, order, selectGlOjBhColorWageList);
						//GILETのボタンホール色指定の下代付属
						orderCoHelper.standardGlOgBhColorPlaceNextPriceCount(orderCoForm, order, selectGlOjBhColorPriceList);
						//GILETのボタン付け糸指定の下代工賃
						orderCoHelper.standardGlOgByColorPlaceNextWageCount(orderCoForm, order, selectGlOjByColorWageList);
						//GILETのボタン付け糸指定の下代付属
						orderCoHelper.standardGlOgByColorPlaceNextPriceCount(orderCoForm, order, selectGlOjByColorPriceList);
						
						//2PANTSについてのマピンッグ
						tuxedoBeanMapper.map(orderCoForm.getCoOptionPants2TuxedoInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
						//2PANTSの項目名
						orderCoHelper.orderCoTuxedoPants2Mapping(orderCoForm, order);
						//2PANTSの素材名表示
						orderCoHelper.orderCoTuxedoPt2NameMapping(tuxedoPt2MateSelectName, order);
						//2PANTSのグループ項目名とコード
						orderCoHelper.aboutTuxedoPants2CheckBoxInDb(orderCoForm, order);
						//2PANTS項目の下代工賃と2PANTS下代付属をデータベースに入力する
						orderCoHelper.getCoTuxedoPt2NextGenerationPrice(orderCoForm, order, pants2OptionTypeList);
						//2PANTSオプション付属詳細項目の下代工賃と2PANTS下代付属をデータベースに入力する
						orderCoHelper.getCoTuxedoPt2DetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//PANTS2のステッチ箇所変更の下代工賃
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextWageCount(orderCoForm, order, selectPt2OgStitchModifyWageList);
						//PANTS2のステッチ箇所変更の下代付属
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextPriceCount(orderCoForm, order, selectPt2OgStitchModifyPriceList);
						//PANTS2のAMF色指定の下代工賃
						orderCoHelper.standardPt2Op2AmfColorPlaceNextWageCount(orderCoForm, order, selectPt2OjAmfColorWageList);
						//PANTS2のAMF色指定の下代付属
						orderCoHelper.standardPt2Op2AmfColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjAmfColorPriceList);
						//PANTS2のボタンホール色指定の下代工賃
						orderCoHelper.standardPt2Op2BhColorPlaceNextWageCount(orderCoForm, order, selectPt2OjBhColorWageList);
						//PANTS2のボタンホール色指定の下代付属
						orderCoHelper.standardPt2Op2BhColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjBhColorPriceList);
						//PANTS2のボタン付け糸指定の下代工賃
						orderCoHelper.standardPt2Op2ByColorPlaceNextWageCount(orderCoForm, order, selectPt2OjByColorWageList);
						//PANTS2のボタン付け糸指定の下代付属
						orderCoHelper.standardPt2Op2ByColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjByColorPriceList);
					}
					//３Pieceは有り、スペアパンツは無しの場合
					else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						tuxedoBeanMapper.map(orderCoForm.getCoOptionGiletTuxedoInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
						//GILETの項目名
						orderCoHelper.orderCoTuxedoGiletMapping(orderCoForm, order);
						//GILETの素材名表示
						orderCoHelper.orderCoTuxedoGlNameMapping(tuxedoGlMateSelectName, order);
						//GILETのグループ項目名とコード
						orderCoHelper.aboutTuxedoGiletCheckBoxInDb(orderCoForm, order);
						//GILET項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoTuxedoGlNextGenerationPrice(orderCoForm, order, giletOptionTypeList);
						//GILETオプション付属詳細項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoTuxedoGlDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//GILETのステッチ箇所変更下代工賃
//						orderCoHelper.standardGlOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectGlOgStitchModifyWageList);
						//GILETのステッチ箇所変更下代付属
//						orderCoHelper.standardGlOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectGlOgStitchModifyPriceList);
						//GILETのAMF色指定の下代工賃
						orderCoHelper.standardGlOgAmfColorPlaceNextWageCount(orderCoForm, order, selectGlOjAmfColorWageList);
						//GILETのAMF色指定の下代付属
						orderCoHelper.standardGlOgAmfColorPlaceNextPriceCount(orderCoForm, order, selectGlOjAmfColorPriceList);
						//GILETのボタンホール色指定の下代工賃
						orderCoHelper.standardGlOgBhColorPlaceNextWageCount(orderCoForm, order, selectGlOjBhColorWageList);
						//GILETのボタンホール色指定の下代付属
						orderCoHelper.standardGlOgBhColorPlaceNextPriceCount(orderCoForm, order, selectGlOjBhColorPriceList);
						//GILETのボタン付け糸指定の下代工賃
						orderCoHelper.standardGlOgByColorPlaceNextWageCount(orderCoForm, order, selectGlOjByColorWageList);
						//GILETのボタン付け糸指定の下代付属
						orderCoHelper.standardGlOgByColorPlaceNextPriceCount(orderCoForm, order, selectGlOjByColorPriceList);
					}
					//３Pieceは無し、スペアパンツは有りの場合
					else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//2PANTSについてのマピンッグ
						tuxedoBeanMapper.map(orderCoForm.getCoOptionPants2TuxedoInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
						//2PANTSの項目名
						orderCoHelper.orderCoTuxedoPants2Mapping(orderCoForm, order);
						//2PANTSの素材名表示
						orderCoHelper.orderCoTuxedoPt2NameMapping(tuxedoPt2MateSelectName, order);
						//2PANTSのグループ項目名とコード
						orderCoHelper.aboutTuxedoPants2CheckBoxInDb(orderCoForm, order);
						//2PANTS項目の下代工賃と2PANTS下代付属をデータベースに入力する
						orderCoHelper.getCoTuxedoPt2NextGenerationPrice(orderCoForm, order, pants2OptionTypeList);
						//2PANTSオプション付属詳細項目の下代工賃と2PANTS下代付属をデータベースに入力する
						orderCoHelper.getCoTuxedoPt2DetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//PANTS2のステッチ箇所変更の下代工賃
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextWageCount(orderCoForm, order, selectPt2OgStitchModifyWageList);
						//PANTS2のステッチ箇所変更の下代付属
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextPriceCount(orderCoForm, order, selectPt2OgStitchModifyPriceList);
						//PANTS2のAMF色指定の下代工賃
						orderCoHelper.standardPt2Op2AmfColorPlaceNextWageCount(orderCoForm, order, selectPt2OjAmfColorWageList);
						//PANTS2のAMF色指定の下代付属
						orderCoHelper.standardPt2Op2AmfColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjAmfColorPriceList);
						//PANTS2のボタンホール色指定の下代工賃
						orderCoHelper.standardPt2Op2BhColorPlaceNextWageCount(orderCoForm, order, selectPt2OjBhColorWageList);
						//PANTS2のボタンホール色指定の下代付属
						orderCoHelper.standardPt2Op2BhColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjBhColorPriceList);
						//PANTS2のボタン付け糸指定の下代工賃
						orderCoHelper.standardPt2Op2ByColorPlaceNextWageCount(orderCoForm, order, selectPt2OjByColorWageList);
						//PANTS2のボタン付け糸指定の下代付属
						orderCoHelper.standardPt2Op2ByColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjByColorPriceList);
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
					tuxedoBeanMapper.map(orderCoForm.getCoOptionJacketTuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
					//JACKETの項目名
					orderCoHelper.orderCoTuxedoJacketMapping(orderCoForm, order);
					//JACKETの素材名表示
					orderCoHelper.orderCoTuxedoJkNameMapping(selectTuxedoJkMaterialName, order);
					//JACKETのグループ項目名とコード
					orderCoHelper.aboutTuxedoJacketCheckBoxInDb(orderCoForm, order);
					//JACKET項目の下代工賃とJACKET下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoJkNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
					//JACKETオプション付属詳細項目の下代工賃とJACKET下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoJkDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//JACKETのステッチ箇所変更下代工賃
//					orderCoHelper.standardJkOjStitchModifyPlaceNextWageCount(orderCoForm, order, selectCoComplexItemsWageList);
					//JACKETのステッチ箇所変更下代付属
//					orderCoHelper.standardJkOjStitchModifyPlaceNextPriceCount(orderCoForm, order, selectJkOjInsidePktPlaceList);
					//JACKETのAMF色指定下代工賃
					orderCoHelper.standardJkOjAmfColorNextWageCount(orderCoForm, order, selectJkOjAmfColorWageList);
					//JACKETのAMF色指定下代付属
					orderCoHelper.standardJkOjAmfColorNextPriceCount(orderCoForm, order, selectJkOjAmfColorPriceList);
					//JACKETのボタンホール色指定下代工賃
					orderCoHelper.standardJkOjBhColorPlaceNextWageCount(orderCoForm, order, selectJkOjBhColorWageList);
					//JACKETのボタンホール色指定下代付属
					orderCoHelper.standardJkOjBhColorPlaceNextPriceCount(orderCoForm, order, selectJkOjBhColorPriceList);
					//JACKETのボタン付け糸指定の下代工賃
					orderCoHelper.standardJkOjByColorPlaceNextWageCount(orderCoForm, order, selectJkOjByColorWageList);
					//JACKETのボタン付け糸指定の下代付属
					orderCoHelper.standardJkOjByColorPlaceNextPriceCount(orderCoForm, order, selectJkOjByColorPriceList);
				}
				//PANTSの場合、itemCodeは"03"
				else if("03".equals(productItem)) {
					//PANTSについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionPantsTuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
					//PANTSの項目名
					orderCoHelper.orderCoTuxedoPantsMapping(orderCoForm, order);
					//PANTSの素材名表示
					orderCoHelper.orderCoTuxedoPtNameMapping(tuxedoPtMateSelectName, order);
					//PANTSのグループ項目名とコード
					orderCoHelper.aboutTuxedoPantsCheckBoxInDb(orderCoForm, order);
					//PANTS項目の下代工賃とPANTS下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoPtNextGenerationPrice(orderCoForm, order, pantsOptionTypeList);
					//PANTSオプション付属詳細項目の下代工賃とPANTS下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoPtDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//PANTSのステッチ箇所変更下代工賃
//					orderCoHelper.standardPtOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectPtOgStitchModifyWageList);
					//PANTSのステッチ箇所変更下代付属
//					orderCoHelper.standardPtOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectPtOgStitchModifyPriceList);
					//PANTSのAMF色指定の下代工賃
					orderCoHelper.standardPtOpAmfColorPlaceNextWageCount(orderCoForm, order, selectPtOjAmfColorWageList);
					//PANTSのAMF色指定の下代付属
					orderCoHelper.standardPtOpAmfColorPlaceNextPriceCount(orderCoForm, order, selectPtOjAmfColorPriceList);
					//PANTSのボタンホール色指定の下代工賃
					orderCoHelper.standardPtOpBhColorPlaceNextWageCount(orderCoForm, order, selectPtOjBhColorWageList);
					//PANTSのボタンホール色指定の下代付属
					orderCoHelper.standardPtOpBhColorPlaceNextPriceCount(orderCoForm, order, selectPtOjBhColorPriceList);
					//PANTSのボタン付け糸指定の下代工賃
					orderCoHelper.standardPtOpByColorPlaceNextWageCount(orderCoForm, order, selectPtOjByColorWageList);
					//PANTSのボタン付け糸指定の下代付属
					orderCoHelper.standardPtOpByColorPlaceNextPriceCount(orderCoForm, order, selectPtOjByColorPriceList);
				}
				//GILETの場合、itemCodeは"04"
				else if("04".equals(productItem)) {
					//GILETについてのマピンッグ
					tuxedoBeanMapper.map(orderCoForm.getCoOptionGiletTuxedoInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					//GILETの項目名
					orderCoHelper.orderCoTuxedoGiletMapping(orderCoForm, order);
					//GILETの素材名表示
					orderCoHelper.orderCoTuxedoGlNameMapping(tuxedoGlMateSelectName, order);
					//GILETのグループ項目名とコード
					orderCoHelper.aboutTuxedoGiletCheckBoxInDb(orderCoForm, order);
					//GILET項目の下代工賃とGILET下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoGlNextGenerationPrice(orderCoForm, order, giletOptionTypeList);
					//GILETオプション付属詳細項目の下代工賃とGILET下代付属をデータベースに入力する
					orderCoHelper.getCoTuxedoGlDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//GILETのステッチ箇所変更下代工賃
//					orderCoHelper.standardGlOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectGlOgStitchModifyWageList);
					//GILETのステッチ箇所変更下代付属
//					orderCoHelper.standardGlOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectGlOgStitchModifyPriceList);
					//GILETのAMF色指定の下代工賃
					orderCoHelper.standardGlOgAmfColorPlaceNextWageCount(orderCoForm, order, selectGlOjAmfColorWageList);
					//GILETのAMF色指定の下代付属
					orderCoHelper.standardGlOgAmfColorPlaceNextPriceCount(orderCoForm, order, selectGlOjAmfColorPriceList);
					//GILETのボタンホール色指定の下代工賃
					orderCoHelper.standardGlOgBhColorPlaceNextWageCount(orderCoForm, order, selectGlOjBhColorWageList);
					//GILETのボタンホール色指定の下代付属
					orderCoHelper.standardGlOgBhColorPlaceNextPriceCount(orderCoForm, order, selectGlOjBhColorPriceList);
					//GILETのボタン付け糸指定の下代工賃
					orderCoHelper.standardGlOgByColorPlaceNextWageCount(orderCoForm, order, selectGlOjByColorWageList);
					//GILETのボタン付け糸指定の下代付属
					orderCoHelper.standardGlOgByColorPlaceNextPriceCount(orderCoForm, order, selectGlOjByColorPriceList);
				}
			}
			//ウォッシャブルの場合
			if("9000103".equals(orderCoForm.getProductCategory())) {
				
				List<NextGenerationPrice> optionNextGenerationPriceList = this.optionNextGenerationPrice(orderCoForm);
				List<NextGenerationPrice> pants2OptionTypeList = optionNextGenerationPriceList.stream().filter(a -> a.getMobSubItemCode().equals("07")).collect(Collectors.toList());
				List<NextGenerationPrice> pantsOptionTypeList = optionNextGenerationPriceList.stream().filter(a -> a.getMobSubItemCode().equals("03")).collect(Collectors.toList());
				List<NextGenerationPrice> giletOptionTypeList = optionNextGenerationPriceList.stream().filter(a -> a.getMobSubItemCode().equals("04")).collect(Collectors.toList());
				List<NextGenerationPrice> detailNextGenerationPriceList = this.detailNextGenerationPrice(orderCoForm);
				
				//商品情報_３Piece_下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getGl3PieceNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				//商品情報_スペアパンツ_下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getSparePantsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				//商品情報_LCR縫製下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getProductLcrSewingWsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				//お客様情報_納期短縮下代工賃と下代付属をデータベースに入力する
				orderCoHelper.getCustIsDeliverShortningWsNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
				
				List<OptionBranchDetail> washableMateList = this.getWashableMateList(orderCoForm);
				Map<String, String> selectWashableJkMaterialName = this.washableJkMateSelect(washableMateList,orderCoForm);
				Map<String, String> washableGlMateSelectName = this.washableGlMateSelect(washableMateList, orderCoForm);
				Map<String, String> washablePtMateSelectName = this.washablePtMateSelect(washableMateList, orderCoForm);
				Map<String, String> washablePt2MateSelectName = this.washablePt2MateSelect(washableMateList, orderCoForm);
				//SUITの場合、itemCodeは"01"
				if("01".equals(productItem)) {
					orderCoHelper.setProductItemDisplayCode(orderCoForm, order);
					//JACKETについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionJacketWashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
					//JACKETの項目名
					orderCoHelper.orderCoWashableJacketMapping(orderCoForm, order);
					//JACKETの素材名表示
					orderCoHelper.orderCoWashableJkNameMapping(selectWashableJkMaterialName, order);
					//JACKETのグループ項目名とコード
					orderCoHelper.aboutWashableJacketCheckBoxInDb(orderCoForm, order);
					//JACKET項目の下代工賃とJACKET下代付属をデータベースに入力する
					orderCoHelper.getCoWashableJkNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
					//JACKETオプション付属詳細項目の下代工賃とJACKET下代付属をデータベースに入力する
					orderCoHelper.getCoWashableJkDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//JACKETのステッチ箇所変更下代工賃
//					orderCoHelper.standardJkOjStitchModifyPlaceNextWageCount(orderCoForm, order, selectCoComplexItemsWageList);
					//JACKETのステッチ箇所変更下代付属
//					orderCoHelper.standardJkOjStitchModifyPlaceNextPriceCount(orderCoForm, order, selectJkOjInsidePktPlaceList);
					//JACKETのAMF色指定下代工賃
					orderCoHelper.standardJkOjAmfColorNextWageCount(orderCoForm, order, selectJkOjAmfColorWageList);
					//JACKETのAMF色指定下代付属
					orderCoHelper.standardJkOjAmfColorNextPriceCount(orderCoForm, order, selectJkOjAmfColorPriceList);
					//JACKETのボタンホール色指定下代工賃
					orderCoHelper.standardJkOjBhColorPlaceNextWageCount(orderCoForm, order, selectJkOjBhColorWageList);
					//JACKETのボタンホール色指定下代付属
					orderCoHelper.standardJkOjBhColorPlaceNextPriceCount(orderCoForm, order, selectJkOjBhColorPriceList);
					//JACKETのボタン付け糸指定の下代工賃
					orderCoHelper.standardJkOjByColorPlaceNextWageCount(orderCoForm, order, selectJkOjByColorWageList);
					//JACKETのボタン付け糸指定の下代付属
					orderCoHelper.standardJkOjByColorPlaceNextPriceCount(orderCoForm, order, selectJkOjByColorPriceList);
					
					//PANTSについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionPantsWashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
					//PANTSの項目名
					orderCoHelper.orderCoWashablePantsMapping(orderCoForm, order);
					//PANTSの素材名表示
					orderCoHelper.orderCoWashablePtNameMapping(washablePtMateSelectName, order);
					//PANTSのグループ項目名とコード
					orderCoHelper.aboutWashablePantsCheckBoxInDb(orderCoForm, order);
					//PANTS項目の下代工賃とPANTS下代付属をデータベースに入力する
					orderCoHelper.getCoWashablePtNextGenerationPrice(orderCoForm, order, pantsOptionTypeList);
					//PANTSオプション付属詳細項目の下代工賃とPANTS下代付属をデータベースに入力する
					orderCoHelper.getCoWashablePtDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//PANTSのステッチ箇所変更下代工賃
//					orderCoHelper.standardPtOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectPtOgStitchModifyWageList);
					//PANTSのステッチ箇所変更下代付属
//					orderCoHelper.standardPtOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectPtOgStitchModifyPriceList);
					//PANTSのAMF色指定の下代工賃
					orderCoHelper.standardPtOpAmfColorPlaceNextWageCount(orderCoForm, order, selectPtOjAmfColorWageList);
					//PANTSのAMF色指定の下代付属
					orderCoHelper.standardPtOpAmfColorPlaceNextPriceCount(orderCoForm, order, selectPtOjAmfColorPriceList);
					//PANTSのボタンホール色指定の下代工賃
					orderCoHelper.standardPtOpBhColorPlaceNextWageCount(orderCoForm, order, selectPtOjBhColorWageList);
					//PANTSのボタンホール色指定の下代付属
					orderCoHelper.standardPtOpBhColorPlaceNextPriceCount(orderCoForm, order, selectPtOjBhColorPriceList);
					//PANTSのボタン付け糸指定の下代工賃
					orderCoHelper.standardPtOpByColorPlaceNextWageCount(orderCoForm, order, selectPtOjByColorWageList);
					//PANTSのボタン付け糸指定の下代付属
					orderCoHelper.standardPtOpByColorPlaceNextPriceCount(orderCoForm, order, selectPtOjByColorPriceList);
					
					//３Pieceは有り、スペアパンツは有りの場合
					if(productYes.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						washableBeanMapper.map(orderCoForm.getCoOptionGiletWashableInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
						//GILETの項目名
						orderCoHelper.orderCoWashableGiletMapping(orderCoForm, order);
						//GILETの素材名表示
						orderCoHelper.orderCoWashableGlNameMapping(washableGlMateSelectName, order);
						//GILETのグループ項目名とコード
						orderCoHelper.aboutWashableGiletCheckBoxInDb(orderCoForm, order);
						//GILET項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoWashableGlNextGenerationPrice(orderCoForm, order, giletOptionTypeList);
						//GILETオプション付属詳細項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoWashableGlDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//GILETのステッチ箇所変更下代工賃
//						orderCoHelper.standardGlOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectGlOgStitchModifyWageList);
						//GILETのステッチ箇所変更下代付属
//						orderCoHelper.standardGlOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectGlOgStitchModifyPriceList);
						//GILETのAMF色指定の下代工賃
						orderCoHelper.standardGlOgAmfColorPlaceNextWageCount(orderCoForm, order, selectGlOjAmfColorWageList);
						//GILETのAMF色指定の下代付属
						orderCoHelper.standardGlOgAmfColorPlaceNextPriceCount(orderCoForm, order, selectGlOjAmfColorPriceList);
						//GILETのボタンホール色指定の下代工賃
						orderCoHelper.standardGlOgBhColorPlaceNextWageCount(orderCoForm, order, selectGlOjBhColorWageList);
						//GILETのボタンホール色指定の下代付属
						orderCoHelper.standardGlOgBhColorPlaceNextPriceCount(orderCoForm, order, selectGlOjBhColorPriceList);
						//GILETのボタン付け糸指定の下代工賃
						orderCoHelper.standardGlOgByColorPlaceNextWageCount(orderCoForm, order, selectGlOjByColorWageList);
						//GILETのボタン付け糸指定の下代付属
						orderCoHelper.standardGlOgByColorPlaceNextPriceCount(orderCoForm, order, selectGlOjByColorPriceList);
						
						//2PANTSについてのマピンッグ
						washableBeanMapper.map(orderCoForm.getCoOptionPants2WashableInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
						//2PANTSの項目名
						orderCoHelper.orderCoWashablePants2Mapping(orderCoForm, order);
						//2PANTSの素材名表示
						orderCoHelper.orderCoWashablePt2NameMapping(washablePt2MateSelectName, order);
						//2PANTSのグループ項目名とコード
						orderCoHelper.aboutWashablePants2CheckBoxInDb(orderCoForm, order);
						//2PANTS項目の下代工賃と2PANTS下代付属をデータベースに入力する
						orderCoHelper.getCoWashablePt2NextGenerationPrice(orderCoForm, order, pants2OptionTypeList);
						//2PANTSオプション付属詳細項目の下代工賃と2PANTS下代付属をデータベースに入力する
						orderCoHelper.getCoWashablePt2DetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//PANTS2のステッチ箇所変更の下代工賃
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextWageCount(orderCoForm, order, selectPt2OgStitchModifyWageList);
						//PANTS2のステッチ箇所変更の下代付属
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextPriceCount(orderCoForm, order, selectPt2OgStitchModifyPriceList);
						//PANTS2のAMF色指定の下代工賃
						orderCoHelper.standardPt2Op2AmfColorPlaceNextWageCount(orderCoForm, order, selectPt2OjAmfColorWageList);
						//PANTS2のAMF色指定の下代付属
						orderCoHelper.standardPt2Op2AmfColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjAmfColorPriceList);
						//PANTS2のボタンホール色指定の下代工賃
						orderCoHelper.standardPt2Op2BhColorPlaceNextWageCount(orderCoForm, order, selectPt2OjBhColorWageList);
						//PANTS2のボタンホール色指定の下代付属
						orderCoHelper.standardPt2Op2BhColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjBhColorPriceList);
						//PANTS2のボタン付け糸指定の下代工賃
						orderCoHelper.standardPt2Op2ByColorPlaceNextWageCount(orderCoForm, order, selectPt2OjByColorWageList);
						//PANTS2のボタン付け糸指定の下代付属
						orderCoHelper.standardPt2Op2ByColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjByColorPriceList);
					}
					//３Pieceは有り、スペアパンツは無しの場合
					else if(productYes.equals(productIs3Piece) && productNo.equals(productSparePantsClass)) {
						//GILETについてのマピンッグ
						washableBeanMapper.map(orderCoForm.getCoOptionGiletWashableInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
						//GILETの項目名
						orderCoHelper.orderCoWashableGiletMapping(orderCoForm, order);
						//GILETの素材名表示
						orderCoHelper.orderCoWashableGlNameMapping(washableGlMateSelectName, order);
						//GILETのグループ項目名とコード
						orderCoHelper.aboutWashableGiletCheckBoxInDb(orderCoForm, order);
						//GILET項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoWashableGlNextGenerationPrice(orderCoForm, order, giletOptionTypeList);
						//GILETオプション付属詳細項目の下代工賃とGILET下代付属をデータベースに入力する
						orderCoHelper.getCoWashableGlDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//GILETのステッチ箇所変更下代工賃
//						orderCoHelper.standardGlOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectGlOgStitchModifyWageList);
						//GILETのステッチ箇所変更下代付属
//						orderCoHelper.standardGlOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectGlOgStitchModifyPriceList);
						//GILETのAMF色指定の下代工賃
						orderCoHelper.standardGlOgAmfColorPlaceNextWageCount(orderCoForm, order, selectGlOjAmfColorWageList);
						//GILETのAMF色指定の下代付属
						orderCoHelper.standardGlOgAmfColorPlaceNextPriceCount(orderCoForm, order, selectGlOjAmfColorPriceList);
						//GILETのボタンホール色指定の下代工賃
						orderCoHelper.standardGlOgBhColorPlaceNextWageCount(orderCoForm, order, selectGlOjBhColorWageList);
						//GILETのボタンホール色指定の下代付属
						orderCoHelper.standardGlOgBhColorPlaceNextPriceCount(orderCoForm, order, selectGlOjBhColorPriceList);
						//GILETのボタン付け糸指定の下代工賃
						orderCoHelper.standardGlOgByColorPlaceNextWageCount(orderCoForm, order, selectGlOjByColorWageList);
						//GILETのボタン付け糸指定の下代付属
						orderCoHelper.standardGlOgByColorPlaceNextPriceCount(orderCoForm, order, selectGlOjByColorPriceList);
						
					}
					//３Pieceは無し、スペアパンツは有りの場合
					else if(productNo.equals(productIs3Piece) && productYes.equals(productSparePantsClass)) {
						//2PANTSについてのマピンッグ
						washableBeanMapper.map(orderCoForm.getCoOptionPants2WashableInfo(), order);
						standardBeanMapper.map(orderCoForm.getCoAdjustPants2StandardInfo(), order);
						//2PANTSの項目名
						orderCoHelper.orderCoWashablePants2Mapping(orderCoForm, order);
						//2PANTSの素材名表示
						orderCoHelper.orderCoWashablePt2NameMapping(washablePt2MateSelectName, order);
						//2PANTSのグループ項目名とコード
						orderCoHelper.aboutWashablePants2CheckBoxInDb(orderCoForm, order);
						//2PANTS項目の下代工賃と2PANTS下代付属をデータベースに入力する
						orderCoHelper.getCoWashablePt2NextGenerationPrice(orderCoForm, order, pants2OptionTypeList);
						//2PANTSオプション付属詳細項目の下代工賃と2PANTS下代付属をデータベースに入力する
						orderCoHelper.getCoWashablePt2DetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
						//2PANTSのステッチ箇所変更の下代工賃
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextWageCount(orderCoForm, order, selectPt2OgStitchModifyWageList);
						//2PANTSのステッチ箇所変更の下代付属
//						orderCoHelper.standardPt2Op2StitchModifyPlaceNextPriceCount(orderCoForm, order, selectPt2OgStitchModifyPriceList);
						//PANTS2のAMF色指定の下代工賃
						orderCoHelper.standardPt2Op2AmfColorPlaceNextWageCount(orderCoForm, order, selectPt2OjAmfColorWageList);
						//PANTS2のAMF色指定の下代付属
						orderCoHelper.standardPt2Op2AmfColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjAmfColorPriceList);
						//PANTS2のボタンホール色指定の下代工賃
						orderCoHelper.standardPt2Op2BhColorPlaceNextWageCount(orderCoForm, order, selectPt2OjBhColorWageList);
						//PANTS2のボタンホール色指定の下代付属
						orderCoHelper.standardPt2Op2BhColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjBhColorPriceList);
						//PANTS2のボタン付け糸指定の下代工賃
						orderCoHelper.standardPt2Op2ByColorPlaceNextWageCount(orderCoForm, order, selectPt2OjByColorWageList);
						//PANTS2のボタン付け糸指定の下代付属
						orderCoHelper.standardPt2Op2ByColorPlaceNextPriceCount(orderCoForm, order, selectPt2OjByColorPriceList);
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
					washableBeanMapper.map(orderCoForm.getCoOptionJacketWashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustJacketStandardInfo(), order);
					//JACKETの項目名
					orderCoHelper.orderCoWashableJacketMapping(orderCoForm, order);
					//JACKETの素材名表示
					orderCoHelper.orderCoWashableJkNameMapping(selectWashableJkMaterialName, order);
					//JACKETのグループ項目名とコード
					orderCoHelper.aboutWashableJacketCheckBoxInDb(orderCoForm, order);
					//JACKET項目の下代工賃とJACKET下代付属をデータベースに入力する
					orderCoHelper.getCoWashableJkNextGenerationPrice(orderCoForm, order, optionNextGenerationPriceList);
					//JACKETオプション付属詳細項目の下代工賃とJACKET下代付属をデータベースに入力する
					orderCoHelper.getCoWashableJkDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//JACKETのステッチ箇所変更下代工賃
//					orderCoHelper.standardJkOjStitchModifyPlaceNextWageCount(orderCoForm, order, selectCoComplexItemsWageList);
					//JACKETのステッチ箇所変更下代付属
//					orderCoHelper.standardJkOjStitchModifyPlaceNextPriceCount(orderCoForm, order, selectJkOjInsidePktPlaceList);
					//JACKETのAMF色指定下代工賃
					orderCoHelper.standardJkOjAmfColorNextWageCount(orderCoForm, order, selectJkOjAmfColorWageList);
					//JACKETのAMF色指定下代付属
					orderCoHelper.standardJkOjAmfColorNextPriceCount(orderCoForm, order, selectJkOjAmfColorPriceList);
					//JACKETのボタンホール色指定下代工賃
					orderCoHelper.standardJkOjBhColorPlaceNextWageCount(orderCoForm, order, selectJkOjBhColorWageList);
					//JACKETのボタンホール色指定下代付属
					orderCoHelper.standardJkOjBhColorPlaceNextPriceCount(orderCoForm, order, selectJkOjBhColorPriceList);
					//JACKETのボタン付け糸指定の下代工賃
					orderCoHelper.standardJkOjByColorPlaceNextWageCount(orderCoForm, order, selectJkOjByColorWageList);
					//JACKETのボタン付け糸指定の下代付属
					orderCoHelper.standardJkOjByColorPlaceNextPriceCount(orderCoForm, order, selectJkOjByColorPriceList);
					
				}
				//PANTSの場合、itemCodeは"03"
				else if("03".equals(productItem)) {
					//PANTSについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionPantsWashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustPantsStandardInfo(), order);
					//PANTSの項目名
					orderCoHelper.orderCoWashablePantsMapping(orderCoForm, order);
					//PANTSの素材名表示
					orderCoHelper.orderCoWashablePtNameMapping(washablePtMateSelectName, order);
					//PANTSのグループ項目名とコード
					orderCoHelper.aboutWashablePantsCheckBoxInDb(orderCoForm, order);
					//PANTS項目の下代工賃とPANTS下代付属をデータベースに入力する
					orderCoHelper.getCoWashablePtNextGenerationPrice(orderCoForm, order, pantsOptionTypeList);
					//PANTSオプション付属詳細項目の下代工賃とPANTS下代付属をデータベースに入力する
					orderCoHelper.getCoWashablePtDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//PANTSのステッチ箇所変更下代工賃
//					orderCoHelper.standardPtOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectPtOgStitchModifyWageList);
					//PANTSのステッチ箇所変更下代付属
//					orderCoHelper.standardPtOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectPtOgStitchModifyPriceList);
					//PANTSのAMF色指定の下代工賃
					orderCoHelper.standardPtOpAmfColorPlaceNextWageCount(orderCoForm, order, selectPtOjAmfColorWageList);
					//PANTSのAMF色指定の下代付属
					orderCoHelper.standardPtOpAmfColorPlaceNextPriceCount(orderCoForm, order, selectPtOjAmfColorPriceList);
					//PANTSのボタンホール色指定の下代工賃
					orderCoHelper.standardPtOpBhColorPlaceNextWageCount(orderCoForm, order, selectPtOjBhColorWageList);
					//PANTSのボタンホール色指定の下代付属
					orderCoHelper.standardPtOpBhColorPlaceNextPriceCount(orderCoForm, order, selectPtOjBhColorPriceList);
					//PANTSのボタン付け糸指定の下代工賃
					orderCoHelper.standardPtOpByColorPlaceNextWageCount(orderCoForm, order, selectPtOjByColorWageList);
					//PANTSのボタン付け糸指定の下代付属
					orderCoHelper.standardPtOpByColorPlaceNextPriceCount(orderCoForm, order, selectPtOjByColorPriceList);
				}
				//GILETの場合、itemCodeは"04"
				else if("04".equals(productItem)) {
					//GILETについてのマピンッグ
					washableBeanMapper.map(orderCoForm.getCoOptionGiletWashableInfo(), order);
					standardBeanMapper.map(orderCoForm.getCoAdjustGiletStandardInfo(), order);
					//GILETの項目名
					orderCoHelper.orderCoWashableGiletMapping(orderCoForm, order);
					//GILETの素材名表示
					orderCoHelper.orderCoWashableGlNameMapping(washableGlMateSelectName, order);
					//GILETのグループ項目名とコード
					orderCoHelper.aboutWashableGiletCheckBoxInDb(orderCoForm, order);
					//GILET項目の下代工賃とGILET下代付属をデータベースに入力する
					orderCoHelper.getCoWashableGlNextGenerationPrice(orderCoForm, order, giletOptionTypeList);
					//GILETオプション付属詳細項目の下代工賃とGILET下代付属をデータベースに入力する
					orderCoHelper.getCoWashableGlDetailNextGenerationPrice(orderCoForm, order, detailNextGenerationPriceList);
					//GILETのステッチ箇所変更下代工賃
//					orderCoHelper.standardGlOgStitchModifyPlaceNextWageCount(orderCoForm, order, selectGlOgStitchModifyWageList);
					//GILETのステッチ箇所変更下代付属
//					orderCoHelper.standardGlOgStitchModifyPlaceNextPriceCount(orderCoForm, order, selectGlOgStitchModifyPriceList);
					//GILETのAMF色指定の下代工賃
					orderCoHelper.standardGlOgAmfColorPlaceNextWageCount(orderCoForm, order, selectGlOjAmfColorWageList);
					//GILETのAMF色指定の下代付属
					orderCoHelper.standardGlOgAmfColorPlaceNextPriceCount(orderCoForm, order, selectGlOjAmfColorPriceList);
					//GILETのボタンホール色指定の下代工賃
					orderCoHelper.standardGlOgBhColorPlaceNextWageCount(orderCoForm, order, selectGlOjBhColorWageList);
					//GILETのボタンホール色指定の下代付属
					orderCoHelper.standardGlOgBhColorPlaceNextPriceCount(orderCoForm, order, selectGlOjBhColorPriceList);
					//GILETのボタン付け糸指定の下代工賃
					orderCoHelper.standardGlOgByColorPlaceNextWageCount(orderCoForm, order, selectGlOjByColorWageList);
					//GILETのボタン付け糸指定の下代付属
					orderCoHelper.standardGlOgByColorPlaceNextPriceCount(orderCoForm, order, selectGlOjByColorPriceList);
				}
			}
			String userId = sessionContent.getUserId();
			String findMakerId = this.findMakerId(orderCoForm);
			orderCoHelper.onlyUpdateItem(selectExistOrder,order,sessionContent.getAuthority());
			orderCoHelper.orderCoMapping(orderCoForm, order, userId, findStock, orderId,findMakerId,retailPriceRelatedMap,priceCode);
			orderCoHelper.measuringMapping(orderCoForm, measuring,sessionContent.getUserId());
			//下代計算
			orderCoHelper.nextGenerationValueRelationCount(order, selectCoYield, selectCoWholesalePiece, selectCoBasicNextGenerationPrice, priceCode, selectCoMarginRate);
			
			// メジャーリングをデータベースに入力する
			measuringService.updateByPrimaryKey(measuring);
			
			//挿入の場合
			if (orderId == null) {
				orderService.insertOrder(order);
			} 
			//更新の場合
			else {
				try {
					List<TypeSizeOptimization> coJkTypeSizeOptimization = this.getCoJkTypeSizeOptimization(orderCoForm);
					List<TypeSizeOptimization> coGlTypeSizeOptimization = this.getCoGlTypeSizeOptimization(orderCoForm);
					List<TypeSizeOptimization> coPtTypeSizeOptimization = this.getCoPtTypeSizeOptimization(orderCoForm);
					List<TypeSizeOptimization> coPt2TypeSizeOptimization = this.getCoPt2TypeSizeOptimization(orderCoForm);
					List<TypeSizeOptimization> coStTypeSizeOptimization = this.getCoStTypeSizeOptimization(orderCoForm);
					List<TypeSizeOptimization> coCtTypeSizeOptimization = this.getCoCtTypeSizeOptimization(orderCoForm);
					// 補正標準値
					orderCoHelper.checkBasicValue(order);
					// 補正絶対値
					orderCoHelper.checkAbsolutelyAdjust(adjustByItem, order, orderCoForm,
							coJkTypeSizeOptimization, coGlTypeSizeOptimization, coPtTypeSizeOptimization,
							coPt2TypeSizeOptimization, coStTypeSizeOptimization, coCtTypeSizeOptimization);
					//回復ITEM
					String itemBefore = LogItemClassEnum.getLogItem(selectExistOrder);
					//更新ITEM
					String itemAfter = LogItemClassEnum.getLogItem(order);
					//ステータス
					String status = orderCoForm.getStatusInput();
					
					orderService.updateOrderConfirm(order,status,itemBefore,itemAfter);
					
				} catch (ResourceNotFoundException e) {
					String status = orderCoForm.getOrderTscStatus();
					if("T2".equals(status) || "T3".equals(status) || "T4".equals(status) || "T5".equals(status)) {
						//注文ID
						String orderError = orderCoForm.getCoCustomerMessageInfo().getOrderId();
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
					this.toOrderCoReForm(orderCoForm, model, map);
					return "order/orderCoReconfirmForm";
				}
			}
			if("".equals(orderCoForm.getOrderTscStatus()) || "T0".equals(orderCoForm.getOrderTscStatus()) || "T1".equals(orderCoForm.getOrderTscStatus())) {
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
			if("".equals(orderCoForm.getOrderTscStatus()) || "T0".equals(orderCoForm.getOrderTscStatus()) || "T1".equals(orderCoForm.getOrderTscStatus())) {
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