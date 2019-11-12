package co.jp.aoyama.macchinetta.app.order;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.groups.Default;

import org.dozer.util.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.google.gson.Gson;

import co.jp.aoyama.macchinetta.app.order.OrderForm.EmbroideredItem;
import co.jp.aoyama.macchinetta.app.order.OrderForm.GiletItem;
import co.jp.aoyama.macchinetta.app.order.OrderForm.JkItem;
import co.jp.aoyama.macchinetta.app.order.OrderForm.Op2HemUpItem;
import co.jp.aoyama.macchinetta.app.order.OrderForm.OpHemUpItem;
import co.jp.aoyama.macchinetta.app.order.OrderForm.Pt2Item;
import co.jp.aoyama.macchinetta.app.order.OrderForm.PtItem;
import co.jp.aoyama.macchinetta.app.order.OrderForm.ShippingDestinationItem;
import co.jp.aoyama.macchinetta.app.order.OrderForm.ShopItem;
import co.jp.aoyama.macchinetta.app.order.enums.AdjustClassEnum;
import co.jp.aoyama.macchinetta.app.order.enums.ItemClassStandardEnum;
import co.jp.aoyama.macchinetta.app.order.enums.ItemTypeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.adjust.JacketAdjustCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.adjust.Pants2AdjustCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.adjust.PantsAdjustCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionDetailStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionDetailStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.info.AdjustGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Item;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Model;
import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;
import co.jp.aoyama.macchinetta.domain.model.OptionBranch;
import co.jp.aoyama.macchinetta.domain.model.OptionBranchDetail;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.SizeFigure;
import co.jp.aoyama.macchinetta.domain.model.SizeNumber;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.model.Yield;

public class OrderHelper {
	
	// 在庫チェックなし
	private static final String IS_NOT_THEORETICAL_STOCKCECK = "0";
	
	// 工場ステータス 生産開始前
	private static final String FACTORY_STATUSF0 = "F0";
	
	// 取り消しフラグ 取り消しではない
	private static final String IS_NOT_CANCELLED = "0";
	
	// 工場自動連携ステータス 送信前
	private static final String SEND2FACTORY_STATUS0 = "0";

	private static final Logger logger = LoggerFactory.getLogger(OrderHelper.class);
	
	
	
	/**
	 * 画面の入力チェック
	 * @param form
	 * @param result
	 * @param smartValidator 
	 * @param sessionContent 
	 */
	public void extractedItem(OrderForm orderForm, BindingResult result, SmartValidator smartValidator, SessionContent sessionContent) {
		List<Class<?>> validationGroup = new ArrayList<Class<?>>();
		// ITEM
		String productItem = orderForm.getProductItem();
		// ３Piece
		String productIs3Piece = orderForm.getProductIs3Piece();
		// スペアパンツ
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		// 刺繍入れ
		String productEmbroideryNecessity = orderForm.getProductEmbroideryNecessity();
		// 出荷先
		String custShippingDestination = orderForm.getCustomerMessageInfo().getCustShippingDestination();
		
		String authority = sessionContent.getAuthority();
		if(!"02".equals(authority)) {
			validationGroup.add(ShopItem.class);
		}
		
		//SUIT
		if ("01".equals(productItem)) {
			validationGroup.add(Default.class);
			validationGroup.add(JkItem.class);
			validationGroup.add(PtItem.class);
			//PANTSの裾上げがダブル糸とダブルスナップの場合
			//ダブル糸：0001702、ダブルスナップ：0001703
			String opHemUp = orderForm.getOptionPantsStandardInfo().getOpHemUp();
			if("0001702".equals(opHemUp)||"0001703".equals(opHemUp)) {
				validationGroup.add(OpHemUpItem.class);
			}
			//3Piece
			if("0009902".equals(productIs3Piece)) {
				validationGroup.add(GiletItem.class);
			}
			//スペアパンツが有りの場合
			if("0009902".equals(productSparePantsClass)) {
				validationGroup.add(Pt2Item.class);
				//2PANTSの裾上げがダブル糸とダブルスナップの場合
				//ダブル糸：0001702、ダブルスナップ：0001703
				String op2HemUp = orderForm.getOptionPants2StandardInfo().getOp2HemUp();
				if("0001702".equals(op2HemUp)||"0001703".equals(op2HemUp)) {
					validationGroup.add(Op2HemUpItem.class);
				}
			}
		}
		//JACKET
		else if("02".equals(productItem)) {
			validationGroup.add(Default.class);
			validationGroup.add(JkItem.class);
		}
		//PANTS
		else if("03".equals(productItem)) {
			validationGroup.add(Default.class);
			validationGroup.add(PtItem.class);
			String opHemUp = orderForm.getOptionPantsStandardInfo().getOpHemUp();
			if("0001702".equals(opHemUp)||"0001703".equals(opHemUp)) {
				validationGroup.add(OpHemUpItem.class);
			}
		}
		//GILET
		else if("04".equals(productItem)) {
			validationGroup.add(Default.class);
			validationGroup.add(GiletItem.class);
		}
		
		// 刺繍入れが有りの場合
		if ("1".equals(productEmbroideryNecessity)) {
			validationGroup.add(EmbroideredItem.class);
		}

		// 出荷先れが他店舗の場合
		if ("05".equals(custShippingDestination)) {
			validationGroup.add(ShippingDestinationItem.class);
		}
		
		smartValidator.validate(orderForm, result, validationGroup.toArray());
	}
	
	/**
	 * 画面の入力チェック出荷先
	 * @param form
	 * @param result
	 * @param smartValidator 
	 */
	public void extractedCustShippingDestination(OrderForm form, BindingResult result,
			SmartValidator smartValidator) {
		Class<?>[] validationGroup = {ShippingDestinationItem.class};
		smartValidator.validate(form, result, validationGroup);
	}
	
	/**
	 * 画面の入力チェック刺繍入れ
	 * @param form
	 * @param result
	 * @param smartValidator 
	 */
	public void extractedEmbroidery(OrderForm form, BindingResult result, SmartValidator smartValidator) {
		Class<?>[] validationGroup = {EmbroideredItem.class};
		smartValidator.validate(form, result, validationGroup);
	}
	/**
	 * 画面の入力チェックSuit
	 * @param form
	 * @param result
	 * @param smartValidator 
	 */
	public void extractedSuit(OrderForm form, final BindingResult result, SmartValidator smartValidator) {
		Class<?>[] validationGroup = {Default.class, JkItem.class, PtItem.class};
		smartValidator.validate(form, result, validationGroup);
	}
	
	/**
	 * 画面の入力チェックJacket
	 * @param form
	 * @param result
	 */
	public void extractedJacket(OrderForm form, final BindingResult result, SmartValidator smartValidator) {
		Class<?>[] validationGroup = {Default.class, JkItem.class};
		smartValidator.validate(form, result, validationGroup);
	}
	
	/**
	 * 画面の入力チェックPants
	 * @param form
	 * @param result
	 */
	public void extractedPants(OrderForm form, final BindingResult result, SmartValidator smartValidator) {
		Class<?>[] validationGroup = {Default.class, PtItem.class};
		smartValidator.validate(form, result, validationGroup);
	}
	
	/**
	 * 画面の入力チェックGilet
	 * @param form
	 * @param result
	 */
	public void extractedGilet(OrderForm form, final BindingResult result, SmartValidator smartValidator) {
		Class<?>[] validationGroup = {Default.class, GiletItem.class};
		smartValidator.validate(form, result, validationGroup);
	}
	
	/**
	 * 画面の入力チェックSuit3p
	 * @param form
	 * @param result
	 */
	public void extractedSuit3p(OrderForm form, final BindingResult result, SmartValidator smartValidator) {
		Class<?>[] validationGroup = {Default.class, JkItem.class,PtItem.class,GiletItem.class};
		smartValidator.validate(form, result, validationGroup);
	}
	
	/**
	 * 画面の入力チェックSuit2Pants
	 * @param form
	 * @param result
	 */
	public void extractedSuit2Pants(OrderForm form, final BindingResult result, SmartValidator smartValidator) {
		Class<?>[] validationGroup = {Default.class, JkItem.class,PtItem.class,Pt2Item.class};
		smartValidator.validate(form, result, validationGroup);
	}
	
	/**
	 * 画面の入力チェックSuit3p2Pants
	 * @param form
	 * @param result
	 */
	public void extractedSuit3p2Pants(OrderForm form, final BindingResult result, SmartValidator smartValidator) {
		Class<?>[] validationGroup = {Default.class, JkItem.class,PtItem.class,Pt2Item.class,GiletItem.class};
		smartValidator.validate(form, result, validationGroup);
	}
	
	/**
	 * 標準のオプション内容処理
	 * 
	 * @param standardOptionList
	 * @param orderForm
	 */
	public void getOptionStandardData(List<OptionBranch> standardOptionList, OrderForm orderForm) throws Exception {
		try {

			// ITEMの値
			ItemClassStandardEnum[] itemClassStandardEnum = ItemClassStandardEnum.values();
			// クラス名
			String classPath = "";
			// ITEMコードの種類
			String subItemCodeType = "";
			for (ItemClassStandardEnum one : itemClassStandardEnum) {
				// サブアイテムコード
				subItemCodeType = one.getKey();
				classPath = ItemClassStandardEnum.getValue(one.getKey());
				if (!classPath.isEmpty()) {
					// 標準可のデーター
					optionStandardData(classPath, orderForm, subItemCodeType, standardOptionList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 列挙によって標準のオプションデーターを設定
	 * 
	 * @param classPath
	 * @param orderForm
	 * @param subItemCode
	 * @param standardOptionList
	 * @throws Exception
	 */
	public void optionStandardData(String classPath, OrderForm orderForm, String subItemCode,
			List<OptionBranch> standardOptionList) throws Exception {
		try {
			// getClass
			Class<?> cls = Class.forName(classPath);

			OptionJacketStandardInfo optionJacketStandardInfo = new OptionJacketStandardInfo();
			OptionPantsStandardInfo optionStandardPantsInfo = new OptionPantsStandardInfo();
			OptionPants2StandardInfo optionPants2StandardInfo = new OptionPants2StandardInfo();
			OptionGiletStandardInfo optionGiletStandardInfo = new OptionGiletStandardInfo();

			List<OptionBranch> ptStandardList = new ArrayList<OptionBranch>();
			List<OptionBranch> jkStandardList = new ArrayList<OptionBranch>();
			List<OptionBranch> glStandardList = new ArrayList<OptionBranch>();
			List<OptionBranch> pt2StandardList = new ArrayList<OptionBranch>();

			for (OptionBranch optionBranch : standardOptionList) {
				// SUIT
				if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_SUIT.getKey())) {

				}
				// JACKET
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
					jkStandardList.add(optionBranch);
				}
				// PANTS
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
					ptStandardList.add(optionBranch);
				}
				// GILET
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
					glStandardList.add(optionBranch);
				}
				// 2PANTS
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
					pt2StandardList.add(optionBranch);
				}
			}

			if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_SUIT.getKey())) {

			}
			// JACKET
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				if (!jkStandardList.isEmpty()) {
					JacketOptionStandardCodeEnum[] jacketOptionStandardEnum = JacketOptionStandardCodeEnum.values();
					for (JacketOptionStandardCodeEnum one : jacketOptionStandardEnum) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, jkStandardList, cls, optionJacketStandardInfo);
					}
					JacketOptionStandardColorEnum[] jkOptionColors = JacketOptionStandardColorEnum.values();
					for (JacketOptionStandardColorEnum one : jkOptionColors) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢色コード ⇒ オプション選択肢色名
						optionBranchColorData(codeVules, jkStandardList, cls, optionJacketStandardInfo);
					}
					orderForm.setOptionJacketStandardInfo(optionJacketStandardInfo);
				}
			}
			// PANTS
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				if (!ptStandardList.isEmpty()) {
					PantsOptionStandardCodeEnum[] pantsOptionCodes = PantsOptionStandardCodeEnum.values();
					for (PantsOptionStandardCodeEnum one : pantsOptionCodes) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, ptStandardList, cls, optionStandardPantsInfo);
					}
					PantsOptionStandardColorEnum[] pantsOptionColors = PantsOptionStandardColorEnum.values();
					for (PantsOptionStandardColorEnum one : pantsOptionColors) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢色コード ⇒ オプション選択肢色名
						optionBranchColorData(codeVules, ptStandardList, cls, optionStandardPantsInfo);
					}
					orderForm.setOptionPantsStandardInfo(optionStandardPantsInfo);
				}
			}
			// GILET
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				if (!glStandardList.isEmpty()) {
					GiletOptionStandardCodeEnum[] giletOptionCodes = GiletOptionStandardCodeEnum.values();
					for (GiletOptionStandardCodeEnum one : giletOptionCodes) {

						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, glStandardList, cls, optionGiletStandardInfo);
					}
					GiletOptionStandardColorEnum[] giletOptionColors = GiletOptionStandardColorEnum.values();
					for (GiletOptionStandardColorEnum one : giletOptionColors) {

						String[] codeVules = one.toString().split(",");
						// オプション選択肢色コード ⇒ オプション選択肢色名
						optionBranchColorData(codeVules, glStandardList, cls, optionGiletStandardInfo);
					}
					orderForm.setOptionGiletStandardInfo(optionGiletStandardInfo);
				}
			}
			// 2PANTS
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				if (!pt2StandardList.isEmpty()) {
					Pants2OptionStandardCodeEnum[] pants2OptionStandardCodeEnum = Pants2OptionStandardCodeEnum.values();
					for (Pants2OptionStandardCodeEnum one : pants2OptionStandardCodeEnum) {

						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, pt2StandardList, cls, optionPants2StandardInfo);
					}
					Pants2OptionStandardColorEnum[] pants2OptionColors = Pants2OptionStandardColorEnum.values();
					for (Pants2OptionStandardColorEnum one : pants2OptionColors) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢色コード ⇒ オプション選択肢色名
						optionBranchColorData(codeVules, pt2StandardList, cls, optionPants2StandardInfo);
					}
					orderForm.setOptionPants2StandardInfo(optionPants2StandardInfo);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * オプション選択肢コードとオプション選択肢名を設定する
	 * 
	 * @param codeVules
	 * @param optionBranchList
	 * @param cls
	 * @param obj
	 */
	private void optionBranchNameData(String[] codeVules, List<OptionBranch> optionBranchList, Class<?> cls,
			Object obj) {
		// 選択肢名Map
		Map<String, String> optionBranchNameMap = new LinkedHashMap<String, String>();

		for (OptionBranch detail : optionBranchList) {
			// 列挙のkeyがオプションコードの場合
			if (codeVules[0].equals(detail.getOptionCode())) {
				optionBranchNameMap.put(detail.getOptionBranchCode(), detail.getOptionBranchName());
			}
		}
		// オプションコード対応方法を取得
		Method myMethod = getMethod(cls, codeVules[1]);
		Object[] args = { optionBranchNameMap };
		if (myMethod != null) {
			ReflectionUtils.invoke(myMethod, obj, args);
		}

	}

	/**
	 * オプション選択肢色コードとオプション選択肢色名を設定する
	 * 
	 * @param codeVules
	 * @param optionBranchList
	 * @param cls
	 * @param obj
	 */
	private void optionBranchColorData(String[] codeVules, List<OptionBranch> optionBranchList, Class<?> cls,
			Object obj) {
		// 選択肢名Map
		Map<String, String> optionBranchNameMap = new LinkedHashMap<String, String>();

		for (OptionBranch detail : optionBranchList) {
			if (codeVules[0].equals(detail.getOptionCode())) {
				optionBranchNameMap.put(detail.getOptionBranchCode(), detail.getOptionBranchName());
			}
		}
		// get OptionCode method
		Method myMethod = getMethod(cls, codeVules[1]);
		Object[] args = { optionBranchNameMap };
		if (myMethod != null) {
			// use OptionCode method
			ReflectionUtils.invoke(myMethod, obj, args);
		}

	}

	/**
	 * オプション選択肢とオプション選択肢詳細の料金を取得
	 * 
	 * @param priceList
	 * @return
	 */
	public List<OrderCodePrice> optionBranchPriceData(List<OrderPrice> priceList) {

		// オプション価格List
		List<OrderCodePrice> optionCodePriceList = new ArrayList<OrderCodePrice>();

		if (priceList.size() > 0) {

			for (OrderPrice detail : priceList) {

				OrderCodePrice price = new OrderCodePrice();
				// オプション選択肢:item_code
				String branchItemCode = detail.getBranchItemCode();
				// オプション選択肢:sub_item_code
				String branchSubItemCode = detail.getBranchSubItemCode();
				// オプション選択肢:model_code
				String branchModelCode = detail.getBranchModelCode();
				// オプション選択肢:option_code
				String branchOptionCode = detail.getBranchOptionCode();
				// オプション選択肢:option_branch_code
				String optinBranchCode = detail.getOptinBranchCode();

				String key = branchItemCode.concat(branchSubItemCode).concat(branchModelCode).concat(branchOptionCode)
						.concat(optinBranchCode);
				// branchItemCode + branchSubItemCode + branchModelCode + branchOptionCode +
				// optinBranchCode;

				price.setOrderKeyCode(key);
				price.setOrderBranchPrice(detail.getOptionBranchPrice().toString());
				price.setOrderBranchDoublePrice(detail.getOptionBranchDoublePrice().toString());

				// オプション選択肢詳細:item_code
				String detailItemCode = detail.getDetailItemCode();
				// オプション選択肢詳細:sub_item_code
				String detailSubItemCode = detail.getDetailSubItemCode();
				// オプション選択肢詳細:option_code
				String detailOptionCode = detail.getDetailOptionCode();
				// オプション選択肢詳細:option_branch_code
				String detailOptionBranchCode = detail.getDetailOptionBranchCode();
				// オプション選択肢詳細:option_branch_detail_code
				String optionBranchDetailCode = detail.getOptionBranchDetailCode();

				if (detailItemCode != null && detailSubItemCode != null && detailOptionCode != null
						&& detailOptionBranchCode != null && optionBranchDetailCode != null) {

					String detailKey = detailItemCode.concat(detailSubItemCode).concat(branchModelCode)
							.concat(detailOptionCode).concat(detailOptionBranchCode).concat(optionBranchDetailCode);

//					detailItemCode + detailSubItemCode + branchModelCode + detailOptionCode + detailOptionBranchCode
//							+ optionBranchDetailCode;

					price.setOrderDetailKeyCode(detailKey);
					price.setOrderBranchDetailPrice(detail.getDetailBranchPrice().toString());
					price.setOrderBranchDetailDoublePrice(detail.getDetailBranchDoublePrice().toString());
				}

				optionCodePriceList.add(price);
			}

		}
		return optionCodePriceList;

	}

	/**
	 * クラスと列挙の方法名によって、方法を取得
	 * 
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	private Method getMethod(Class<?> clazz, String methodName) {
		Method[] methods = clazz.getMethods();
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
	 * 素材品番を処理
	 * 
	 * @param buttonsList
	 * @return
	 */
	public LinkedHashMap<String, String> getButtons(List<OptionBranchDetail> buttonsList) {
		LinkedHashMap<String, String> buttonsMap = new LinkedHashMap<String, String>();
		for (OptionBranchDetail optionBranchDetail : buttonsList) {
			buttonsMap.put(optionBranchDetail.getOptionBranchDetailCode(),
					optionBranchDetail.getOptionBranchDetailName());
		}
		return buttonsMap;
	}

	/**
	 * 補正の体型と号数を取得
	 * 
	 * @param figureList
	 * @param numberList
	 * @param orderForm
	 */
	public void getFigureNumberMap(List<SizeFigure> figureList, List<SizeNumber> numberList, OrderForm orderForm) {

		LinkedHashMap<String, String> jkFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> ptFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> glFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> pt2FigureMap = new LinkedHashMap<String, String>();

		// 体型
		for (SizeFigure sizeFigure : figureList) {
			// JACKET
			if (sizeFigure.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				jkFigureMap.put("", "選択　　　");
				// jkFigureMap.put(sizeFigure.getFigure(), sizeFigure.getFigure());
			}
			// PANTS
			else if (sizeFigure.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				ptFigureMap.put("", "選択　　　");
				// ptFigureMap.put(sizeFigure.getFigure(), sizeFigure.getFigure());
			}
			// GILET
			else if (sizeFigure.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				glFigureMap.put("", "選択　　　");
				// glFigureMap.put(sizeFigure.getFigure(), sizeFigure.getFigure());
			}
			// 2PANTS
			else if (sizeFigure.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				pt2FigureMap.put("", "選択　　　");
				// pt2FigureMap.put(sizeFigure.getFigure(), sizeFigure.getFigure());
			}
		}

		// 号数
		LinkedHashMap<String, String> jkNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> ptNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> glNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> pt2NumberMap = new LinkedHashMap<String, String>();

		for (SizeNumber sizeNumber : numberList) {
			// JACKET
			if (sizeNumber.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				jkNumberMap.put("", "選択　　　");
				// jkNumberMap.put(sizeNumber.getSizeNumber(), sizeNumber.getSizeNumber());
			}
			// PANTS
			else if (sizeNumber.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				ptNumberMap.put("", "選択　　　");
				// ptNumberMap.put(sizeNumber.getSizeNumber(), sizeNumber.getSizeNumber());
			}
			// GILET
			else if (sizeNumber.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				glNumberMap.put("", "選択　　　");
				// glNumberMap.put(sizeNumber.getSizeNumber(), sizeNumber.getSizeNumber());
			}
			// 2PANTS
			else if (sizeNumber.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				pt2NumberMap.put("", "選択　　　");
				// pt2NumberMap.put(sizeNumber.getSizeNumber(), sizeNumber.getSizeNumber());
			}
		}

		AdjustJacketStandardInfo adjustJacketStandardInfo = new AdjustJacketStandardInfo();
		adjustJacketStandardInfo.setSizeFigureMap(jkFigureMap);
		adjustJacketStandardInfo.setSizeNumberMap(jkNumberMap);
		orderForm.setAdjustJacketStandardInfo(adjustJacketStandardInfo);

		AdjustPantsStandardInfo adjustPantsStandardInfo = new AdjustPantsStandardInfo();
		adjustPantsStandardInfo.setSizeFigureMap(ptFigureMap);
		adjustPantsStandardInfo.setSizeNumberMap(ptNumberMap);
		orderForm.setAdjustPantsStandardInfo(adjustPantsStandardInfo);

		AdjustGiletStandardInfo adjustGiletStandardInfo = new AdjustGiletStandardInfo();
		adjustGiletStandardInfo.setSizeFigureMap(glFigureMap);
		adjustGiletStandardInfo.setSizeNumberMap(glNumberMap);
		orderForm.setAdjustGiletStandardInfo(adjustGiletStandardInfo);

		AdjustPants2StandardInfo adjustPants2StandardInfo = new AdjustPants2StandardInfo();
		adjustPants2StandardInfo.setSizeFigureMap(pt2FigureMap);
		adjustPants2StandardInfo.setSizeNumberMap(pt2NumberMap);
		orderForm.setAdjustPants2StandardInfo(adjustPants2StandardInfo);
	}

	/**
	 * 補正の上限値処理
	 * 
	 * @param adjustList
	 * @param orderForm
	 */
	public void getAdjust(List<Adjust> adjustList, OrderForm orderForm) {
		try {

			// ITEMの値
			AdjustClassEnum[] adjustClassEnum = AdjustClassEnum.values();
			// クラス名
			String classPath = "";
			// ITEMコードの種類
			String subItemCodeType = "";
			for (AdjustClassEnum one : adjustClassEnum) {

				subItemCodeType = one.getKey();
				classPath = AdjustClassEnum.getValue(one.getKey());
				if (!classPath.isEmpty()) {
					//
					changeAdjustData(classPath, orderForm, subItemCodeType, adjustList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 列挙によって補正寸上限値と補正寸下限値のMapを取得
	 * 
	 * @param classPath
	 * @param orderForm
	 * @param subItemCodeType
	 * @param adjustList
	 */
	private void changeAdjustData(String classPath, OrderForm orderForm, String subItemCodeType,
			List<Adjust> adjustList) {
		try {

			// getClass
			Class<?> cls = Class.forName(classPath);

			AdjustJacketStandardInfo adjustJacketStandardInfo = orderForm.getAdjustJacketStandardInfo();
			AdjustPantsStandardInfo adjustPantsStandardInfo = orderForm.getAdjustPantsStandardInfo();
			AdjustPants2StandardInfo adjustPants2StandardInfo = orderForm.getAdjustPants2StandardInfo();

			List<Adjust> jkAdjustList = new ArrayList<Adjust>();
			List<Adjust> ptAdjustList = new ArrayList<Adjust>();
			List<Adjust> pt2AdjustList = new ArrayList<Adjust>();

			for (Adjust adjust : adjustList) {
				// JACKET
				if (adjust.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
					jkAdjustList.add(adjust);
				}
				// PANTS
				else if (adjust.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
					ptAdjustList.add(adjust);
				}
				// 2PANTS
				else if (adjust.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
					pt2AdjustList.add(adjust);
				}
			}

			// JACKET
			if (subItemCodeType.equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				JacketAdjustCodeEnum[] jacketAdjustCodeEnum = JacketAdjustCodeEnum.values();
				for (JacketAdjustCodeEnum one : jacketAdjustCodeEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					adjustData(codeVules, jkAdjustList, cls, adjustJacketStandardInfo);
				}
				orderForm.setAdjustJacketStandardInfo(adjustJacketStandardInfo);
			}
			// PANTS
			else if (subItemCodeType.equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				PantsAdjustCodeEnum[] pantsAdjustCodeEnum = PantsAdjustCodeEnum.values();
				for (PantsAdjustCodeEnum one : pantsAdjustCodeEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					adjustData(codeVules, ptAdjustList, cls, adjustPantsStandardInfo);
				}
				orderForm.setAdjustPantsStandardInfo(adjustPantsStandardInfo);
			}
			// 2PANTS
			else if (subItemCodeType.equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				Pants2AdjustCodeEnum[] pants2AdjustCodeEnum = Pants2AdjustCodeEnum.values();
				for (Pants2AdjustCodeEnum one : pants2AdjustCodeEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					adjustData(codeVules, pt2AdjustList, cls, adjustPants2StandardInfo);
				}
				orderForm.setAdjustPants2StandardInfo(adjustPants2StandardInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 補正寸上限値と補正寸下限値を設定
	 * 
	 * @param codeVules
	 * @param adjustList
	 * @param cls
	 * @param obj
	 */
	private void adjustData(String[] codeVules, List<Adjust> adjustList, Class<?> cls, Object obj) {
		// max min map
		Map<String, String> adjectMap = new LinkedHashMap<String, String>();

		for (Adjust detail : adjustList) {
			// 列挙のkeyが補正区分の場合
			if (codeVules[0].equals(detail.getAdjusteClass())) {
				adjectMap.put(detail.getAdjusteMin().toString(), detail.getAdjusteMax().toString());
			}
		}
		Method myMethod = getMethod(cls, codeVules[1]);
		Object[] args = { adjectMap };
		if (myMethod != null) {
			ReflectionUtils.invoke(myMethod, obj, args);
		}

	}

	/**
	 * 「オーダー登録」画面、商品のサブアイテムコードの処理
	 * 
	 * @param itemList
	 * @param orderForm
	 */
	public void getItem(List<Item> itemList, OrderForm orderForm) {
		Map<String, String> itemMap = new LinkedHashMap<String, String>();
		for (Item item : itemList) {
			itemMap.put(item.getItemCode(), item.getItemName());
		}
		orderForm.setProductItemMap(itemMap);
	}

	/**
	 * 「オーダー登録」画面、オプションのモデルコードの処理
	 * 
	 * @param modelList
	 * @param orderForm
	 */
	public void getModel(List<Model> modelList, OrderForm orderForm) {
		Map<String, String> ojJacketModelMap = new LinkedHashMap<String, String>();
		Map<String, String> opPantsModelMap = new LinkedHashMap<String, String>();
		Map<String, String> op2PantsModelMap = new LinkedHashMap<String, String>();
		Map<String, String> ogGiletModelMap = new LinkedHashMap<String, String>();

		for (Model model : modelList) {
			if (model.getSubItemCode().equals("02")) {
				ojJacketModelMap.put("", "モデル選択");
				ojJacketModelMap.put(model.getModelCode(), model.getModelName());
			} else if (model.getSubItemCode().equals("03")) {
				opPantsModelMap.put("", "モデル選択");
				opPantsModelMap.put(model.getModelCode(), model.getModelName());
			} else if (model.getSubItemCode().equals("04")) {
				ogGiletModelMap.put("", "モデル選択");
				ogGiletModelMap.put(model.getModelCode(), model.getModelName());
			} else if (model.getSubItemCode().equals("07")) {
				op2PantsModelMap.put("", "モデル選択");
				op2PantsModelMap.put(model.getModelCode(), model.getModelName());
			}
		}
		orderForm.getOptionGiletStandardInfo().setOgGiletModelMap(ogGiletModelMap);
		orderForm.getOptionJacketStandardInfo().setOjJacketModelMap(ojJacketModelMap);
		orderForm.getOptionPantsStandardInfo().setOpPantsModelMap(opPantsModelMap);
		orderForm.getOptionPants2StandardInfo().setOp2PantsModelMap(op2PantsModelMap);

	}

	/**
	 * オーダー内容確認画面JACKEのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderJacketMappingPo(OrderForm orderForm, Order order) {

		// JACKET_フロント釦数_名
		order.setJkFrtBtnNm(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCntMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt()));
		// JACKET_ラペルデザイン_名
		order.setJkLapelDesignNm(orderForm.getOptionJacketStandardInfo().getOjLapelDesignMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjLapelDesign()));
		// JACKET_台場_名
		order.setJkDaibaNm(orderForm.getOptionJacketStandardInfo().getOjFortMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjFort()));
		// JACKET_裏仕様 _名
		order.setJkInnerClothNm(orderForm.getOptionJacketStandardInfo().getOjGackSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjGackSpec()));
		// JACKET_腰ポケット_名
		order.setJkWaistPktNm(orderForm.getOptionJacketStandardInfo().getOjWaistPktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjWaistPkt()));
		// JACKET_チェンジポケット_名
		order.setJkChgPktNm(orderForm.getOptionJacketStandardInfo().getOjChangePktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjChangePkt()));
		// JACKET_スランテッドポケット_名
		order.setJkSlantedPktNm(orderForm.getOptionJacketStandardInfo().getOjSlantedPktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjSlantedPkt()));
		// JACKET_袖口_名
		order.setJkCuffNm(orderForm.getOptionJacketStandardInfo().getOjCuffSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjCuffSpec()));
		// JACKET_ステッチ種類_名
		order.setJkStitchTypeNm(orderForm.getOptionJacketStandardInfo().getOjStitchMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjStitch()));
		// JACKET_ベント_名
		order.setJkVentNm(orderForm.getOptionJacketStandardInfo().getOjVentSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjVentSpec()));

		// JACKET_Drop
		order.setCorJkDrop(orderForm.getAdjustGiletStandardInfo().getSizeFigureMap()
				.get(orderForm.getAdjustGiletStandardInfo().getSizeFigure()));
		// JACKET_号数
		order.setCorJkSize(orderForm.getAdjustGiletStandardInfo().getSizeNumberMap()
				.get(orderForm.getAdjustGiletStandardInfo().getSizeNumber()));
	}

//	/**
//	 * オーダー内容確認画面JACKEのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoStandardJacketMapping(OrderForm orderForm, Order order) {
//
//		// JACKET_フロント釦数_名
//		order.setJkFrtBtnNm(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCntMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt()));
//		// JACKET_ラペルデザイン_名
//		order.setJkLapelDesignNm(orderForm.getOptionJacketStandardInfo().getOjLapelDesignMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjLapelDesign()));
//		// JACKET_グレード_名
//		order.setJkGradeNm(orderForm.getOptionJacketStandardInfo().getOjGradeMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjGrade()));
//		// JACKET_裏仕様 _名
//		order.setJkInnerClothNm(orderForm.getOptionJacketStandardInfo().getOjGackSpecMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjGackSpec()));
//		// JACKET_台場_名
//		order.setJkDaibaNm(orderForm.getOptionJacketStandardInfo().getOjFortMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjFort()));
//		// JACKET_襟裏 _名
//		order.setJkCollarInnerNm(orderForm.getOptionJacketStandardInfo().getOjBackCollarMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjBackCollar()));
//		// JACKET_襟吊_名
//		order.setJkCollarHangNm(orderForm.getOptionJacketStandardInfo().getOjChainHangeMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjChainHange()));
//		// JACKET_ラペル幅 _名
//		order.setJkLapelWidthNm(orderForm.getOptionJacketStandardInfo().getOjLapelWidthMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjLapelWidth()));
//		// JACKET_フラワーホール_名
//		order.setJkFlowerHoleNm(orderForm.getOptionJacketStandardInfo().getOjFlowerHoleMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjFlowerHole()));
//		// JACKET_胸ポケット _名
//		order.setJkBreastPktNm(orderForm.getOptionJacketStandardInfo().getOjBreastPktMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjBreastPkt()));
//		// JACKET_腰ポケット_名
//		order.setJkWaistPktNm(orderForm.getOptionJacketStandardInfo().getOjWaistPktMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjWaistPkt()));
//		// JACKET_チェンジポケット_名
//		order.setJkChgPktNm(orderForm.getOptionJacketStandardInfo().getOjChangePktMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjChangePkt()));
//		// JACKET_スランテッドポケット_名
//		order.setJkSlantedPktNm(orderForm.getOptionJacketStandardInfo().getOjSlantedPktMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjSlantedPkt()));
//		// JACKET_忍びポケット_名
//		order.setJkShinobiPktNm(orderForm.getOptionJacketStandardInfo().getOjCoinPktMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjCoinPkt()));
//		// JACKET_袖仕様_名
//		order.setJkSleeveTypeNm(orderForm.getOptionJacketStandardInfo().getOjSleeveSpecMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjSleeveSpec()));
//		// JACKET_マニカ_名
//		order.setJkManicaNm(orderForm.getOptionJacketStandardInfo().getOjManicaMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjManica()));
//		// JACKET_袖口_名
//		order.setJkCuffNm(orderForm.getOptionJacketStandardInfo().getOjCuffSpecMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjCuffSpec()));
//		// JACKET_下前胸内ポケット仕様_名
//		order.setJkRightInnerPktTypeNm(orderForm.getOptionJacketStandardInfo().getOjBreastInnerPktMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjBreastInnerPkt()));
//		// JACKET_ステッチ種類_名
//		order.setJkStitchTypeNm(orderForm.getOptionJacketStandardInfo().getOjStitchMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjStitch()));
//		// JACKET_ベント_名
//		order.setJkVentNm(orderForm.getOptionJacketStandardInfo().getOjVentSpecMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjVentSpec()));
//		// JACKET_形状記憶_名
//		order.setJkShapeMemoryNm(orderForm.getOptionJacketStandardInfo().getOjShapeMemoryMap()
//				.get(orderForm.getOptionJacketStandardInfo().getOjShapeMemory()));
//	}
//
//	/**
//	 * オーダー内容確認画面JACKEのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoTuxedoJacketMapping(OrderForm orderForm, Order order) {
//
//		// JACKET_フロント釦数_名
//		order.setJkFrtBtnNm(orderForm.getOptionJacketTuxedoInfo().getTjFrontBtnCntMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjFrontBtnCnt()));
//		// JACKET_ラペルデザイン_名
//		order.setJkLapelDesignNm(orderForm.getOptionJacketTuxedoInfo().getTjLapelDesignMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjLapelDesign()));
//		// JACKET_グレード_名
//		order.setJkGradeNm(orderForm.getOptionJacketTuxedoInfo().getTjGradeMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjGrade()));
//		// JACKET_裏仕様 _名
//		order.setJkInnerClothNm(orderForm.getOptionJacketTuxedoInfo().getTjBackSpecMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjBackSpec()));
//		// JACKET_台場_名
//		order.setJkDaibaNm(orderForm.getOptionJacketTuxedoInfo().getTjFortMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjFort()));
//		// JACKET_拝見地_名
//		order.setJkLookClothNm(orderForm.getOptionJacketTuxedoInfo().getTjGlossFablicMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjGlossFablic()));
//		// JACKET_襟裏 _名
//		order.setJkCollarInnerNm(orderForm.getOptionJacketTuxedoInfo().getTjBackCollarMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjBackCollar()));
//		// JACKET_襟吊_名
//		order.setJkCollarHangNm(orderForm.getOptionJacketTuxedoInfo().getTjChainHangeMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjChainHange()));
//		// JACKET_ラペル幅 _名
//		order.setJkLapelWidthNm(orderForm.getOptionJacketTuxedoInfo().getTjLapelWidthMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjLapelWidth()));
//		// JACKET_フラワーホール_名
//		order.setJkFlowerHoleNm(orderForm.getOptionJacketTuxedoInfo().getTjFlowerHoleMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjFlowerHole()));
//		// JACKET_胸ポケット _名
//		order.setJkBreastPktNm(orderForm.getOptionJacketTuxedoInfo().getTjBreastPktMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjBreastPkt()));
//		// JACKET_腰ポケット_名
//		order.setJkWaistPktNm(orderForm.getOptionJacketTuxedoInfo().getTjWaistPktMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjWaistPkt()));
//		// JACKET_チェンジポケット_名
//		order.setJkChgPktNm(orderForm.getOptionJacketTuxedoInfo().getTjChangePktMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjChangePkt()));
//		// JACKET_スランテッドポケット_名
//		order.setJkSlantedPktNm(orderForm.getOptionJacketTuxedoInfo().getTjSlantedPktMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjSlantedPkt()));
//		// JACKET_忍びポケット_名
//		order.setJkShinobiPktNm(orderForm.getOptionJacketTuxedoInfo().getTjCoinPktMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjCoinPkt()));
//		// JACKET_袖仕様_名
//		order.setJkSleeveTypeNm(orderForm.getOptionJacketTuxedoInfo().getTjSleeveSpecMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjSleeveSpec()));
//		// JACKET_マニカ_名
//		order.setJkManicaNm(orderForm.getOptionJacketTuxedoInfo().getTjManicaMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjManica()));
//		// JACKET_袖口_名
//		order.setJkCuffNm(orderForm.getOptionJacketTuxedoInfo().getTjCuffSpecMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjCuffSpec()));
//		// JACKET_内ポケット変更_名
//		order.setJkInnerPktNm(orderForm.getOptionJacketTuxedoInfo().getTjInsidePktChangeMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjInsidePktChange()));
//		// JACKET_下前胸内ポケット仕様_名
//		order.setJkRightInnerPktTypeNm(orderForm.getOptionJacketTuxedoInfo().getTjBreastInnerPktMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjBreastInnerPkt()));
//		// JACKET_ベント_名
//		order.setJkVentNm(orderForm.getOptionJacketTuxedoInfo().getTjVentSpecMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjVentSpec()));
//		// JACKET_形状記憶_名
//		order.setJkShapeMemoryNm(orderForm.getOptionJacketTuxedoInfo().getTjShapeMemoryMap()
//				.get(orderForm.getOptionJacketTuxedoInfo().getTjShapeMemory()));
//	}
//
//	/**
//	 * オーダー内容確認画面JACKEのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoWashableJacketMapping(OrderForm orderForm, Order order) {
//
//		// JACKET_フロント釦数_名
//		order.setJkFrtBtnNm(orderForm.getOptionJacketWashableInfo().getWjFrontBtnCntMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjFrontBtnCnt()));
//		// JACKET_ラペルデザイン_名
//		order.setJkLapelDesignNm(orderForm.getOptionJacketWashableInfo().getWjLapelDesignMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjLapelDesign()));
//		// JACKET_グレード_名
//		order.setJkGradeNm(orderForm.getOptionJacketWashableInfo().getWjGradeMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjGrade()));
//		// JACKET_裏仕様 _名
//		order.setJkInnerClothNm(orderForm.getOptionJacketWashableInfo().getWjBackSpecMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjBackSpec()));
//		// JACKET_台場_名
//		order.setJkDaibaNm(orderForm.getOptionJacketWashableInfo().getWjFortMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjFort()));
//		// JACKET_襟裏 _名
//		order.setJkCollarInnerNm(orderForm.getOptionJacketWashableInfo().getWjBackCollarMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjBackCollar()));
//		// JACKET_襟吊_名
//		order.setJkCollarHangNm(orderForm.getOptionJacketWashableInfo().getWjChainHangeMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjChainHange()));
//		// JACKET_ラペル幅 _名
//		order.setJkLapelWidthNm(orderForm.getOptionJacketWashableInfo().getWjLapelWidthMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjLapelWidth()));
//		// JACKET_フラワーホール_名
//		order.setJkFlowerHoleNm(orderForm.getOptionJacketWashableInfo().getWjFlowerHoleMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjFlowerHole()));
//		// JACKET_胸ポケット _名
//		order.setJkBreastPktNm(orderForm.getOptionJacketWashableInfo().getWjBreastPktMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjBreastPkt()));
//		// JACKET_腰ポケット_名
//		order.setJkWaistPktNm(orderForm.getOptionJacketWashableInfo().getWjWaistPktMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjWaistPkt()));
//		// JACKET_チェンジポケット_名
//		order.setJkChgPktNm(orderForm.getOptionJacketWashableInfo().getWjChangePktMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjChangePkt()));
//		// JACKET_スランテッドポケット_名
//		order.setJkSlantedPktNm(orderForm.getOptionJacketWashableInfo().getWjSlantedPktMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjSlantedPkt()));
//		// JACKET_忍びポケット_名
//		order.setJkShinobiPktNm(orderForm.getOptionJacketWashableInfo().getWjCoinPktMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjCoinPkt()));
//		// JACKET_袖仕様_名
//		order.setJkSleeveTypeNm(orderForm.getOptionJacketWashableInfo().getWjSleeveSpecMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjSleeveSpec()));
//		// JACKET_マニカ_名
//		order.setJkManicaNm(orderForm.getOptionJacketWashableInfo().getWjManicaMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjManica()));
//		// JACKET_袖口_名
//		order.setJkCuffNm(orderForm.getOptionJacketWashableInfo().getWjCuffSpecMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjCuffSpec()));
//		// JACKET_内ポケット変更_名
//		order.setJkInnerPktNm(orderForm.getOptionJacketWashableInfo().getWjInsidePktChangeMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjInsidePktChange()));
//		// JACKET_下前胸内ポケット仕様_名
//		order.setJkRightInnerPktTypeNm(orderForm.getOptionJacketWashableInfo().getWjBreastInnerPktMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjBreastInnerPkt()));
//		// JACKET_ベント_名
//		order.setJkVentNm(orderForm.getOptionJacketWashableInfo().getWjVentSpecMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjVentSpec()));
//		// JACKET_形状記憶_名
//		order.setJkShapeMemoryNm(orderForm.getOptionJacketWashableInfo().getWjShapeMemoryMap()
//				.get(orderForm.getOptionJacketWashableInfo().getWjShapeMemory()));
//	}

	/**
	 * オーダー内容確認画面GILETのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderGiletMappingPo(OrderForm orderForm, Order order) {

		// GILET_胸ポケット _名
		order.setGlBreastPktNm(orderForm.getOptionGiletStandardInfo().getOgBreastPktMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgBreastPkt()));
		// GILET_AMFステッチ _名
		order.setGlAmfStitchNm(orderForm.getOptionGiletStandardInfo().getOgStitchMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgStitch()));
		// GILET_Drop
		order.setCorGlDrop(orderForm.getAdjustGiletStandardInfo().getSizeFigureMap()
				.get(orderForm.getAdjustGiletStandardInfo().getSizeFigure()));
		// GILET_号数
		order.setCorGlSize(orderForm.getAdjustGiletStandardInfo().getSizeNumberMap()
				.get(orderForm.getAdjustGiletStandardInfo().getSizeNumber()));
	}

//	/**
//	 * オーダー内容確認画面GILETのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoStandardGiletMapping(OrderForm orderForm, Order order) {
//
//		// GILET_胸ポケット _名
//		order.setGlBreastPktNm(orderForm.getOptionGiletStandardInfo().getOgBreastPktMap()
//				.get(orderForm.getOptionGiletStandardInfo().getOgBreastPkt()));
//		// GILET_腰ポケット _名
//		order.setGlWaistPktNm(orderForm.getOptionGiletStandardInfo().getOgWaistPktMap()
//				.get(orderForm.getOptionGiletStandardInfo().getOgWaistPkt()));
//		// GILET_腰ポケット形状 _名
//		order.setGlWaistPktShapeNm(orderForm.getOptionGiletStandardInfo().getOgWaistPktSpecMap()
//				.get(orderForm.getOptionGiletStandardInfo().getOgWaistPktSpec()));
//		// GILET_AMFステッチ _名
//		order.setGlAmfStitchNm(orderForm.getOptionGiletStandardInfo().getOgStitchMap()
//				.get(orderForm.getOptionGiletStandardInfo().getOgStitch()));
//		// GILET_バックベルト _名
//		order.setGlBackBeltNm(orderForm.getOptionGiletStandardInfo().getOgBackBeltMap()
//				.get(orderForm.getOptionGiletStandardInfo().getOgBackBelt()));
//		// GILET_ウォッチチェーン_名
//		order.setGlWatchChainNm(orderForm.getOptionGiletStandardInfo().getOgWatchChainMap()
//				.get(orderForm.getOptionGiletStandardInfo().getOgWatchChain()));
//	}
//
//	/**
//	 * オーダー内容確認画面GILETのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoTuxedoGiletMapping(OrderForm orderForm, Order order) {
//
//		// GILET_胸ポケット _名
//		order.setGlBreastPktNm(orderForm.getOptionGiletTuxedoInfo().getTgBreastPktMap()
//				.get(orderForm.getOptionGiletTuxedoInfo().getTgBreastPkt()));
//		// GILET_腰ポケット _名
//		order.setGlWaistPktNm(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktMap()
//				.get(orderForm.getOptionGiletTuxedoInfo().getTgWaistPkt()));
//		// GILET_腰ポケット形状 _名
//		order.setGlWaistPktShapeNm(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktSpecMap()
//				.get(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktSpec()));
//		// GILET_腰ポケット素材 _名
//		order.setGlWaistPktClothNm(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktMateMap()
//				.get(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktMate()));
//		// GILET_AMFステッチ _名
//		order.setGlAmfStitchNm(orderForm.getOptionGiletTuxedoInfo().getTgStitchMap()
//				.get(orderForm.getOptionGiletTuxedoInfo().getTgStitch()));
//		// GILET_バックベルト _名
//		order.setGlBackBeltNm(orderForm.getOptionGiletTuxedoInfo().getTgBackBeltMap()
//				.get(orderForm.getOptionGiletTuxedoInfo().getTgBackBelt()));
//		// GILET_ウォッチチェーン_名
//		order.setGlWatchChainNm(orderForm.getOptionGiletTuxedoInfo().getTgWatchChainMap()
//				.get(orderForm.getOptionGiletTuxedoInfo().getTgWatchChain()));
//	}
//
//	/**
//	 * オーダー内容確認画面GILETのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoWashableGiletMapping(OrderForm orderForm, Order order) {
//
//		// GILET_胸ポケット _名
//		order.setGlBreastPktNm(orderForm.getOptionGiletWashableInfo().getWgBreastPktMap()
//				.get(orderForm.getOptionGiletWashableInfo().getWgBreastPkt()));
//		// GILET_腰ポケット _名
//		order.setGlWaistPktNm(orderForm.getOptionGiletWashableInfo().getWgWaistPktMap()
//				.get(orderForm.getOptionGiletWashableInfo().getWgWaistPkt()));
//		// GILET_腰ポケット形状 _名
//		order.setGlWaistPktShapeNm(orderForm.getOptionGiletWashableInfo().getWgWaistPktSpecMap()
//				.get(orderForm.getOptionGiletWashableInfo().getWgWaistPktSpec()));
//		// GILET_AMFステッチ _名
//		order.setGlAmfStitchNm(orderForm.getOptionGiletWashableInfo().getWgStitchMap()
//				.get(orderForm.getOptionGiletWashableInfo().getWgStitch()));
//		// GILET_バックベルト _名
//		order.setGlBackBeltNm(orderForm.getOptionGiletWashableInfo().getWgBackBeltMap()
//				.get(orderForm.getOptionGiletWashableInfo().getWgBackBelt()));
//		// GILET_ウォッチチェーン_名
//		order.setGlWatchChainNm(orderForm.getOptionGiletWashableInfo().getWgWatchChainMap()
//				.get(orderForm.getOptionGiletWashableInfo().getWgWatchChain()));
//	}

	/**
	 * オーダー内容確認画面PANTSのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPantsMappingPo(OrderForm orderForm, Order order) {
		// PANTS_タック_名
		order.setPtTackNm(orderForm.getOptionPantsStandardInfo().getOpTackMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpTack()));
		// PANTS_アジャスター_名
		order.setPtAdjusterNm(orderForm.getOptionPantsStandardInfo().getOpAdjusterMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpAdjuster()));
		// PANTS_裾上げ_名
		order.setPtHemUpNm(orderForm.getOptionPantsStandardInfo().getOpHemUpMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpHemUp()));
		// PANTS_ダブル幅_名
		order.setPtDblWidthNm(orderForm.getOptionPantsStandardInfo().getOpDoubleWideMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpDoubleWide()));
		// PANTS_エイト（滑り止め） _名
		order.setPtNonSlipNm(orderForm.getOptionPantsStandardInfo().getOpEightMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpEight()));
		// PANTS_シック（股下補強） _名
		order.setPtChicSlipNm(orderForm.getOptionPantsStandardInfo().getOpThickMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpThick()));
		// PANTS_形状記憶 _名
		order.setPtShapeMemoryNm(orderForm.getOptionPantsStandardInfo().getOpShapeMemoryMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpShapeMemory()));
		// PANTS_靴ずれ _名
		order.setPtShoeSoreNm(orderForm.getOptionPantsStandardInfo().getOpBlisterMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpBlister()));

		// PANTS_Drop
		order.setCorPtDrop(orderForm.getAdjustPantsStandardInfo().getSizeFigureMap()
				.get(orderForm.getAdjustPantsStandardInfo().getSizeFigure()));
		// PANTS_号数
		order.setCorPtSize(orderForm.getAdjustPantsStandardInfo().getSizeNumberMap()
				.get(orderForm.getAdjustPantsStandardInfo().getSizeNumber()));
	}

//	/**
//	 * オーダー内容確認画面PANTSのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoStandardPantsMapping(OrderForm orderForm, Order order) {
//
//		// PANTS_タック_名
//		order.setPtTackNm(orderForm.getOptionPantsStandardInfo().getOpTackMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpTack()));
//		// PANTS_膝裏_名
//		order.setPtKneeinnerTypeNm(orderForm.getOptionPantsStandardInfo().getOpKneeBackMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpKneeBack()));
//		// PANTS_膝裏素材_名
//		order.setPtKneeinnerClothNm(orderForm.getOptionPantsStandardInfo().getOpKneeBackMateMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpKneeBackMate()));
//		// PANTS_フロント仕様_名
//		order.setPtFrtTypeNm(orderForm.getOptionPantsStandardInfo().getOpFrontSpecMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpFrontSpec()));
//		// PANTS_パンチェリーナ_名
//		order.setPtPancherinaNm(orderForm.getOptionPantsStandardInfo().getOpPancherinaMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpPancherina()));
//		// PANTS_アジャスター_名
//		order.setPtAdjusterNm(orderForm.getOptionPantsStandardInfo().getOpAdjusterMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpAdjuster()));
//		// PANTS_ピンループ_名
//		order.setPtPinloopNm(orderForm.getOptionPantsStandardInfo().getOpPinLoopMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpPinLoop()));
//		// PANTS_脇ポケット_名
//		order.setPtSidePktNm(orderForm.getOptionPantsStandardInfo().getOpSidePktMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpSidePkt()));
//		// PANTS_忍びポケット_名
//		order.setPtShinobiPktNm(orderForm.getOptionPantsStandardInfo().getOpSinobiPktMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpSinobiPkt()));
//		// PANTS_コインポケット_名
//		order.setPtCoinPktNm(orderForm.getOptionPantsStandardInfo().getOpCoinPktMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpCoinPkt()));
//		// PANTS_フラップ付コインポケット_名
//		order.setPtFlapcoinPktNm(orderForm.getOptionPantsStandardInfo().getOpFlapCoinPktMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpFlapCoinPkt()));
//		// PANTS_上前ピスポケット_名
//		order.setPtLeftPisPktNm(orderForm.getOptionPantsStandardInfo().getOpPisPktUfMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpPisPktUf()));
//		// PANTS_下前ピスポケット_名
//		order.setPtRightPisPktNm(orderForm.getOptionPantsStandardInfo().getOpPisPktDfMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpPisPktDf()));
//		// PANTS_Vカット_名
//		order.setPtVCutNm(orderForm.getOptionPantsStandardInfo().getOpVCutMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpVCut()));
//		// PANTS_裾上げ_名
//		order.setPtHemUpNm(orderForm.getOptionPantsStandardInfo().getOpHemUpMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpHemUp()));
//		// PANTS_ダブル幅_名
//		order.setPtDblWidthNm(orderForm.getOptionPantsStandardInfo().getOpDoubleWideMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpDoubleWide()));
//		// PANTS_AMFステッチ_名
//		order.setPtAmfStitchNm(orderForm.getOptionPantsStandardInfo().getOpStitchMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpStitch()));
//		// PANTS_サスペンダー釦 _名
//		order.setPtSuspenderBtnNm(orderForm.getOptionPantsStandardInfo().getOpSuspenderBtnMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpSuspenderBtn()));
//		// PANTS_シック（股下補強） _名
//		order.setPtChicSlipNm(orderForm.getOptionPantsStandardInfo().getOpThickMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpThick()));
//		// PANTS_エイト（滑り止め） _名
//		order.setPtNonSlipNm(orderForm.getOptionPantsStandardInfo().getOpEightMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpEight()));
//		// PANTS_形状記憶 _名
//		order.setPtShapeMemoryNm(orderForm.getOptionPantsStandardInfo().getOpShapeMemoryMap()
//				.get(orderForm.getOptionPantsStandardInfo().getOpShapeMemory()));
//	}
//
//	/**
//	 * オーダー内容確認画面PANTSのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoTuxedoPantsMapping(OrderForm orderForm, Order order) {
//
//		// PANTS_タック_名
//		order.setPtTackNm(orderForm.getOptionPantsTuxedoInfo().getTpTackMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpTack()));
//		// PANTS_膝裏_名
//		order.setPtKneeinnerTypeNm(orderForm.getOptionPantsTuxedoInfo().getTpKneeBackMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpKneeBack()));
//		// PANTS_膝裏素材_名
//		order.setPtKneeinnerClothNm(orderForm.getOptionPantsTuxedoInfo().getTpKneeBackMateMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpKneeBackMate()));
//		// PANTS_フロント仕様_名
//		order.setPtFrtTypeNm(orderForm.getOptionPantsTuxedoInfo().getTpFrontSpecMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpFrontSpec()));
//		// PANTS_パンチェリーナ_名
//		order.setPtPancherinaNm(orderForm.getOptionPantsTuxedoInfo().getTpPancherinaMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpPancherina()));
//		// PANTS_アジャスター_名
//		order.setPtAdjusterNm(orderForm.getOptionPantsTuxedoInfo().getTpAdjusterMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpAdjuster()));
//		// PANTS_ピンループ_名
//		order.setPtPinloopNm(orderForm.getOptionPantsTuxedoInfo().getTpPinLoopMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpPinLoop()));
//		// PANTS_脇ポケット_名
//		order.setPtSidePktNm(orderForm.getOptionPantsTuxedoInfo().getTpSidePktMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpSidePkt()));
//		// PANTS_忍びポケット_名
//		order.setPtShinobiPktNm(orderForm.getOptionPantsTuxedoInfo().getTpSinobiPktMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpSinobiPkt()));
//		// PANTS_コインポケット_名
//		order.setPtCoinPktNm(orderForm.getOptionPantsTuxedoInfo().getTpCoinPktMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpCoinPkt()));
//		// PANTS_フラップ付コインポケット_名
//		order.setPtFlapcoinPktNm(orderForm.getOptionPantsTuxedoInfo().getTpFlapCoinPktMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpFlapCoinPkt()));
//		// PANTS_上前ピスポケット_名
//		order.setPtLeftPisPktNm(orderForm.getOptionPantsTuxedoInfo().getTpPisPktUfMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpPisPktUf()));
//		// PANTS_下前ピスポケット_名
//		order.setPtRightPisPktNm(orderForm.getOptionPantsTuxedoInfo().getTpPisPktDfMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpPisPktDf()));
//		// PANTS_Vカット_名
//		order.setPtVCutNm(orderForm.getOptionPantsTuxedoInfo().getTpVCutMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpVCut()));
//		// PANTS_裾上げ_名
//		order.setPtHemUpNm(orderForm.getOptionPantsTuxedoInfo().getTpHemUpMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpHemUp()));
//		// PANTS_ダブル幅_名
//		order.setPtDblWidthNm(orderForm.getOptionPantsTuxedoInfo().getTpDoubleWideMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpDoubleWide()));
//		// PANTS_AMFステッチ_名
//		order.setPtAmfStitchNm(orderForm.getOptionPantsTuxedoInfo().getTpStitchMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpStitch()));
//		// PANTS_サスペンダー釦 _名
//		order.setPtSuspenderBtnNm(orderForm.getOptionPantsTuxedoInfo().getTpSuspenderBtnMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpSuspenderBtn()));
//		// PANTS_シック（股下補強） _名
//		order.setPtChicSlipNm(orderForm.getOptionPantsTuxedoInfo().getTpThickMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpThick()));
//		// PANTS_エイト（滑り止め） _名
//		order.setPtNonSlipNm(orderForm.getOptionPantsTuxedoInfo().getTpEightMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpEight()));
//		// PANTS_形状記憶 _名
//		order.setPtShapeMemoryNm(orderForm.getOptionPantsTuxedoInfo().getTpShapeMemoryMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpShapeMemory()));
//		// PANTS_側章 _名
//		order.setPtSideStripeNm(orderForm.getOptionPantsTuxedoInfo().getTpSideStripeMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpSideStripe()));
//		// PANTS_側章幅 _名
//		order.setPtSideStripeWidthNm(orderForm.getOptionPantsTuxedoInfo().getTpSideStripeWidthMap()
//				.get(orderForm.getOptionPantsTuxedoInfo().getTpSideStripeWidth()));
//	}
//
//	/**
//	 * オーダー内容確認画面PANTSのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoWashablePantsMapping(OrderForm orderForm, Order order) {
//
//		// PANTS_タック_名
//		order.setPtTackNm(orderForm.getOptionPantsWashableInfo().getWpTackMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpTack()));
//		// PANTS_膝裏_名
//		order.setPtKneeinnerTypeNm(orderForm.getOptionPantsWashableInfo().getWpKneeBackMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpKneeBack()));
//		// PANTS_膝裏素材_名
//		order.setPtKneeinnerClothNm(orderForm.getOptionPantsWashableInfo().getWpKneeBackMateMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpKneeBackMate()));
//		// PANTS_フロント仕様_名
//		order.setPtFrtTypeNm(orderForm.getOptionPantsWashableInfo().getWpFrontSpecMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpFrontSpec()));
//		// PANTS_パンチェリーナ_名
//		order.setPtPancherinaNm(orderForm.getOptionPantsWashableInfo().getWpPancherinaMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpPancherina()));
//		// PANTS_アジャスター_名
//		order.setPtAdjusterNm(orderForm.getOptionPantsWashableInfo().getWpAdjusterMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpAdjuster()));
//		// PANTS_ピンループ_名
//		order.setPtPinloopNm(orderForm.getOptionPantsWashableInfo().getWpPinLoopMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpPinLoop()));
//		// PANTS_脇ポケット_名
//		order.setPtSidePktNm(orderForm.getOptionPantsWashableInfo().getWpSidePktMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpSidePkt()));
//		// PANTS_忍びポケット_名
//		order.setPtShinobiPktNm(orderForm.getOptionPantsWashableInfo().getWpSinobiPktMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpSinobiPkt()));
//		// PANTS_コインポケット_名
//		order.setPtCoinPktNm(orderForm.getOptionPantsWashableInfo().getWpCoinPktMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpCoinPkt()));
//		// PANTS_フラップ付コインポケット_名
//		order.setPtFlapcoinPktNm(orderForm.getOptionPantsWashableInfo().getWpFlapCoinPktMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpFlapCoinPkt()));
//		// PANTS_上前ピスポケット_名
//		order.setPtLeftPisPktNm(orderForm.getOptionPantsWashableInfo().getWpPisPktUfMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpPisPktUf()));
//		// PANTS_下前ピスポケット_名
//		order.setPtRightPisPktNm(orderForm.getOptionPantsWashableInfo().getWpPisPktDfMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpPisPktDf()));
//		// PANTS_Vカット_名
//		order.setPtVCutNm(orderForm.getOptionPantsWashableInfo().getWpVCutMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpVCut()));
//		// PANTS_裾上げ_名
//		order.setPtHemUpNm(orderForm.getOptionPantsWashableInfo().getWpHemUpMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpHemUp()));
//		// PANTS_ダブル幅_名
//		order.setPtDblWidthNm(orderForm.getOptionPantsWashableInfo().getWpDoubleWideMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpDoubleWide()));
//		// PANTS_AMFステッチ_名
//		order.setPtAmfStitchNm(orderForm.getOptionPantsWashableInfo().getWpStitchMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpStitch()));
//		// PANTS_サスペンダー釦 _名
//		order.setPtSuspenderBtnNm(orderForm.getOptionPantsWashableInfo().getWpSuspenderBtnMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpSuspenderBtn()));
//		// PANTS_シック（股下補強） _名
//		order.setPtChicSlipNm(orderForm.getOptionPantsWashableInfo().getWpThickMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpThick()));
//		// PANTS_エイト（滑り止め） _名
//		order.setPtNonSlipNm(orderForm.getOptionPantsWashableInfo().getWpEightMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpEight()));
//		// PANTS_形状記憶 _名
//		order.setPtShapeMemoryNm(orderForm.getOptionPantsWashableInfo().getWpShapeMemoryMap()
//				.get(orderForm.getOptionPantsWashableInfo().getWpShapeMemory()));
//	}

	/**
	 * オーダー内容確認画面PANTS2のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPants2MappingPo(OrderForm orderForm, Order order) {

		// 2PANTS_タック_名
		order.setPt2TackNm(orderForm.getOptionPants2StandardInfo().getOp2TackMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Tack()));
		// 2PANTS_アジャスター_名
		order.setPt2AdjusterNm(orderForm.getOptionPants2StandardInfo().getOp2AdjusterMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Adjuster()));
		// 2PANTS_裾上げ_名
		order.setPt2HemUpNm(orderForm.getOptionPants2StandardInfo().getOp2HemUpMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2HemUp()));
		// 2PANTS_ダブル幅_名
		order.setPt2DblWidthNm(orderForm.getOptionPants2StandardInfo().getOp2DoubleWideMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2DoubleWide()));
		// 2PANTS_エイト（滑り止め） _名
		order.setPt2NonSlipNm(orderForm.getOptionPants2StandardInfo().getOp2EightMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Eight()));
		// 2PANTS_シック（股下補強） _名
		order.setPt2ChicSlipNm(orderForm.getOptionPants2StandardInfo().getOp2ThickMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Thick()));
		// 2PANTS_形状記憶 _名
		order.setPt2ShapeMemoryNm(orderForm.getOptionPants2StandardInfo().getOp2ShapeMemoryMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2ShapeMemory()));
		// 2PANTS_靴ずれ _名
		order.setPt2ShoeSoreNm(orderForm.getOptionPants2StandardInfo().getOp2BlisterMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Blister()));

		// 2PANTS_Drop
		order.setCorPt2Drop(orderForm.getAdjustPants2StandardInfo().getSizeFigureMap()
				.get(orderForm.getAdjustPants2StandardInfo().getSizeFigure()));
		// 2PANTS_号数
		order.setCorPt2Size(orderForm.getAdjustPants2StandardInfo().getSizeNumberMap()
				.get(orderForm.getAdjustPants2StandardInfo().getSizeNumber()));
	}

//	/**
//	 * オーダー内容確認画面PANTS2のMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoStandardPants2Mapping(OrderForm orderForm, Order order) {
//
//		// 2PANTS_タック_名
//		order.setPt2TackNm(orderForm.getOptionPants2StandardInfo().getOp2TackMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2Tack()));
//		// 2PANTS_膝裏_名
//		order.setPt2KneeinnerTypeNm(orderForm.getOptionPants2StandardInfo().getOp2KneeBackMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2KneeBack()));
//		// 2PANTS_膝裏素材_名
//		order.setPt2KneeinnerClothNm(orderForm.getOptionPants2StandardInfo().getOp2KneeBackMateMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2KneeBackMate()));
//		// 2PANTS_フロント仕様_名
//		order.setPt2FrtTypeNm(orderForm.getOptionPants2StandardInfo().getOp2FrontSpecMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2FrontSpec()));
//		// 2PANTS_パンチェリーナ_名
//		order.setPt2PancherinaNm(orderForm.getOptionPants2StandardInfo().getOp2PancherinaMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2Pancherina()));
//		// 2PANTS_アジャスター_名
//		order.setPt2AdjusterNm(orderForm.getOptionPants2StandardInfo().getOp2AdjusterMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2Adjuster()));
//		// 2PANTS_ピンループ_名
//		order.setPt2PinloopNm(orderForm.getOptionPants2StandardInfo().getOp2PinLoopMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2PinLoop()));
//		// 2PANTS_脇ポケット_名
//		order.setPt2SidePktNm(orderForm.getOptionPants2StandardInfo().getOp2SidePktMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2SidePkt()));
//		// 2PANTS_忍びポケット_名
//		order.setPt2ShinobiPktNm(orderForm.getOptionPants2StandardInfo().getOp2SinobiPktMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2SinobiPkt()));
//		// 2PANTS_コインポケット_名
//		order.setPt2CoinPktNm(orderForm.getOptionPants2StandardInfo().getOp2CoinPktMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2CoinPkt()));
//		// 2PANTS_フラップ付コインポケット_名
//		order.setPt2FlapcoinPktNm(orderForm.getOptionPants2StandardInfo().getOp2FlapCoinPktMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2FlapCoinPkt()));
//		// 2PANTS_上前ピスポケット_名
//		order.setPt2LeftPisPktNm(orderForm.getOptionPants2StandardInfo().getOp2PisPktUfMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2PisPktUf()));
//		// 2PANTS_下前ピスポケット_名
//		order.setPt2RightPisPktNm(orderForm.getOptionPants2StandardInfo().getOp2PisPktDfMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2PisPktDf()));
//		// 2PANTS_Vカット_名
//		order.setPt2VCutNm(orderForm.getOptionPants2StandardInfo().getOp2VCutMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2VCut()));
//		// 2PANTS_裾上げ_名
//		order.setPt2HemUpNm(orderForm.getOptionPants2StandardInfo().getOp2HemUpMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2HemUp()));
//		// 2PANTS_ダブル幅_名
//		order.setPt2DblWidthNm(orderForm.getOptionPants2StandardInfo().getOp2DoubleWideMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2DoubleWide()));
//		// 2PANTS_AMFステッチ_名
//		order.setPt2AmfStitchNm(orderForm.getOptionPants2StandardInfo().getOp2StitchMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2Stitch()));
//		// 2PANTS_サスペンダー釦 _名
//		order.setPt2SuspenderBtnNm(orderForm.getOptionPants2StandardInfo().getOp2SuspenderBtnMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2SuspenderBtn()));
//		// 2PANTS_シック（股下補強） _名
//		order.setPt2ChicSlipNm(orderForm.getOptionPants2StandardInfo().getOp2ThickMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2Thick()));
//		// 2PANTS_エイト（滑り止め） _名
//		order.setPt2NonSlipNm(orderForm.getOptionPants2StandardInfo().getOp2EightMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2Eight()));
//		// 2PANTS_形状記憶 _名
//		order.setPt2ShapeMemoryNm(orderForm.getOptionPants2StandardInfo().getOp2ShapeMemoryMap()
//				.get(orderForm.getOptionPants2StandardInfo().getOp2ShapeMemory()));
//	}
//
//	/**
//	 * オーダー内容確認画面PANTS2のMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoTuxedoPants2Mapping(OrderForm orderForm, Order order) {
//
//		// 2PANTS_タック_名
//		order.setPt2TackNm(orderForm.getOptionPants2TuxedoInfo().getTp2TackMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Tack()));
//		// 2PANTS_膝裏_名
//		order.setPt2KneeinnerTypeNm(orderForm.getOptionPants2TuxedoInfo().getTp2KneeBackMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2KneeBack()));
//		// 2PANTS_膝裏素材_名
//		order.setPt2KneeinnerClothNm(orderForm.getOptionPants2TuxedoInfo().getTp2KneeBackMateMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2KneeBackMate()));
//		// 2PANTS_フロント仕様_名
//		order.setPt2FrtTypeNm(orderForm.getOptionPants2TuxedoInfo().getTp2FrontSpecMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2FrontSpec()));
//		// 2PANTS_パンチェリーナ_名
//		order.setPt2PancherinaNm(orderForm.getOptionPants2TuxedoInfo().getTp2PancherinaMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Pancherina()));
//		// 2PANTS_アジャスター_名
//		order.setPt2AdjusterNm(orderForm.getOptionPants2TuxedoInfo().getTp2AdjusterMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Adjuster()));
//		// 2PANTS_ピンループ_名
//		order.setPt2PinloopNm(orderForm.getOptionPants2TuxedoInfo().getTp2PinLoopMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2PinLoop()));
//		// 2PANTS_脇ポケット_名
//		order.setPt2SidePktNm(orderForm.getOptionPants2TuxedoInfo().getTp2SidePktMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SidePkt()));
//		// 2PANTS_忍びポケット_名
//		order.setPt2ShinobiPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2SinobiPktMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SinobiPkt()));
//		// 2PANTS_コインポケット_名
//		order.setPt2CoinPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2CoinPktMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2CoinPkt()));
//		// 2PANTS_フラップ付コインポケット_名
//		order.setPt2FlapcoinPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2FlapCoinPktMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2FlapCoinPkt()));
//		// 2PANTS_上前ピスポケット_名
//		order.setPt2LeftPisPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2PisPktUfMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2PisPktUf()));
//		// 2PANTS_下前ピスポケット_名
//		order.setPt2RightPisPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2PisPktDfMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2PisPktDf()));
//		// 2PANTS_Vカット_名
//		order.setPt2VCutNm(orderForm.getOptionPants2TuxedoInfo().getTp2VCutMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2VCut()));
//		// 2PANTS_裾上げ_名
//		order.setPt2HemUpNm(orderForm.getOptionPants2TuxedoInfo().getTp2HemUpMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2HemUp()));
//		// 2PANTS_ダブル幅_名
//		order.setPt2DblWidthNm(orderForm.getOptionPants2TuxedoInfo().getTp2DoubleWideMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2DoubleWide()));
//		// 2PANTS_AMFステッチ_名
//		order.setPt2AmfStitchNm(orderForm.getOptionPants2TuxedoInfo().getTp2StitchMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Stitch()));
//		// 2PANTS_サスペンダー釦 _名
//		order.setPt2SuspenderBtnNm(orderForm.getOptionPants2TuxedoInfo().getTp2SuspenderBtnMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SuspenderBtn()));
//		// 2PANTS_シック（股下補強） _名
//		order.setPt2ChicSlipNm(orderForm.getOptionPants2TuxedoInfo().getTp2ThickMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Thick()));
//		// 2PANTS_エイト（滑り止め） _名
//		order.setPt2NonSlipNm(orderForm.getOptionPants2TuxedoInfo().getTp2EightMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Eight()));
//		// 2PANTS_形状記憶 _名
//		order.setPt2ShapeMemoryNm(orderForm.getOptionPants2TuxedoInfo().getTp2ShapeMemoryMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2ShapeMemory()));
//		// 2PANTS_側章 _名
//		order.setPt2SideStripeNm(orderForm.getOptionPants2TuxedoInfo().getTp2SideStripeMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SideStripe()));
//		// 2PANTS_側章幅 _名
//		order.setPt2SideStripeWidthNm(orderForm.getOptionPants2TuxedoInfo().getTp2SideStripeWidthMap()
//				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SideStripeWidth()));
//	}
//
//	/**
//	 * オーダー内容確認画面PANTS2のMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoWashablePants2Mapping(OrderForm orderForm, Order order) {
//
//		// 2PANTS_タック_名
//		order.setPt2TackNm(orderForm.getOptionPants2WashableInfo().getWp2TackMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2Tack()));
//		// 2PANTS_膝裏_名
//		order.setPt2KneeinnerTypeNm(orderForm.getOptionPants2WashableInfo().getWp2KneeBackMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2KneeBack()));
//		// 2PANTS_膝裏素材_名
//		order.setPt2KneeinnerClothNm(orderForm.getOptionPants2WashableInfo().getWp2KneeBackMateMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2KneeBackMate()));
//		// 2PANTS_フロント仕様_名
//		order.setPt2FrtTypeNm(orderForm.getOptionPants2WashableInfo().getWp2FrontSpecMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2FrontSpec()));
//		// 2PANTS_パンチェリーナ_名
//		order.setPt2PancherinaNm(orderForm.getOptionPants2WashableInfo().getWp2PancherinaMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2Pancherina()));
//		// 2PANTS_アジャスター_名
//		order.setPt2AdjusterNm(orderForm.getOptionPants2WashableInfo().getWp2AdjusterMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2Adjuster()));
//		// 2PANTS_ピンループ_名
//		order.setPt2PinloopNm(orderForm.getOptionPants2WashableInfo().getWp2PinLoopMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2PinLoop()));
//		// 2PANTS_脇ポケット_名
//		order.setPt2SidePktNm(orderForm.getOptionPants2WashableInfo().getWp2SidePktMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2SidePkt()));
//		// 2PANTS_忍びポケット_名
//		order.setPt2ShinobiPktNm(orderForm.getOptionPants2WashableInfo().getWp2SinobiPktMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2SinobiPkt()));
//		// 2PANTS_コインポケット_名
//		order.setPt2CoinPktNm(orderForm.getOptionPants2WashableInfo().getWp2CoinPktMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2CoinPkt()));
//		// 2PANTS_フラップ付コインポケット_名
//		order.setPt2FlapcoinPktNm(orderForm.getOptionPants2WashableInfo().getWp2FlapCoinPktMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2FlapCoinPkt()));
//		// 2PANTS_上前ピスポケット_名
//		order.setPt2LeftPisPktNm(orderForm.getOptionPants2WashableInfo().getWp2PisPktUfMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2PisPktUf()));
//		// 2PANTS_下前ピスポケット_名
//		order.setPt2RightPisPktNm(orderForm.getOptionPants2WashableInfo().getWp2PisPktDfMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2PisPktDf()));
//		// 2PANTS_Vカット_名
//		order.setPt2VCutNm(orderForm.getOptionPants2WashableInfo().getWp2VCutMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2VCut()));
//		// 2PANTS_裾上げ_名
//		order.setPt2HemUpNm(orderForm.getOptionPants2WashableInfo().getWp2HemUpMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2HemUp()));
//		// 2PANTS_ダブル幅_名
//		order.setPt2DblWidthNm(orderForm.getOptionPants2WashableInfo().getWp2DoubleWideMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2DoubleWide()));
//		// 2PANTS_AMFステッチ_名
//		order.setPt2AmfStitchNm(orderForm.getOptionPants2WashableInfo().getWp2StitchMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2Stitch()));
//		// 2PANTS_サスペンダー釦 _名
//		order.setPt2SuspenderBtnNm(orderForm.getOptionPants2WashableInfo().getWp2SuspenderBtnMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2SuspenderBtn()));
//		// 2PANTS_シック（股下補強） _名
//		order.setPt2ChicSlipNm(orderForm.getOptionPants2WashableInfo().getWp2ThickMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2Thick()));
//		// 2PANTS_エイト（滑り止め） _名
//		order.setPt2NonSlipNm(orderForm.getOptionPants2WashableInfo().getWp2EightMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2Eight()));
//		// 2PANTS_形状記憶 _名
//		order.setPt2ShapeMemoryNm(orderForm.getOptionPants2WashableInfo().getWp2ShapeMemoryMap()
//				.get(orderForm.getOptionPants2WashableInfo().getWp2ShapeMemory()));
//	}
//
//	/**
//	 * オーダー内容確認画面SHIRTのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoStandardShirtMapping(OrderForm orderForm, Order order) {
//
//		// SHIRT_襟型_名
//		order.setStCollarTypeNm(orderForm.getOptionShirtStandardInfo().getOsChainModelMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsChainModel()));
//		// SHIRT_カフス_名
//		order.setStCuffsNm(orderForm.getOptionShirtStandardInfo().getOsCuffsMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsCuffs()));
//		// SHIRT_コンバーチブル_名
//		order.setStConvertibleNm(orderForm.getOptionShirtStandardInfo().getOsConvertibleMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsConvertible()));
//		// SHIRT_アジャスト釦_名
//		order.setStAdjusterBtnNm(orderForm.getOptionShirtStandardInfo().getOsAdjustBtnMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsAdjustBtn()));
//		// SHIRT_クレリック仕様_名
//		order.setStClericNm(orderForm.getOptionShirtStandardInfo().getOsClericSpecMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsClericSpec()));
//		// SHIRT_ダブルカフス仕様_名
//		order.setStDblCuffsNm(orderForm.getOptionShirtStandardInfo().getOsDblCuffMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsDblCuff()));
//		// SHIRT_カフスボタン追加_名
//		order.setStCuffsBtnNm(orderForm.getOptionShirtStandardInfo().getOsAddCuffMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsAddCuff()));
//		// SHIRT_タブ釦_名
//		order.setStDblBtnNm(orderForm.getOptionShirtStandardInfo().getOsTabBtnMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsTabBtn()));
//		// SHIRT_ガントレットボタン位置_名
//		order.setStGauntletBtnPosNm(orderForm.getOptionShirtStandardInfo().getOsGaletteBtnPosMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsGaletteBtnPos()));
//		// SHIRT_ピンホールピン_名
//		order.setStPinholePinNm(orderForm.getOptionShirtStandardInfo().getOsPinHolePinMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsPinHolePin()));
//		// SHIRT_胸ポケット置_名
//		order.setStBreastPktNm(orderForm.getOptionShirtStandardInfo().getOsBreastPkMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsBreastPk()));
//		// SHIRT_胸ポケット大きさ_名
//		order.setStBreastSizeNm(orderForm.getOptionShirtStandardInfo().getOsBreastPkSizeMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsBreastPkSize()));
//		// SHIRT_フロントデザイン_名
//		order.setStFrtDesignNm(orderForm.getOptionShirtStandardInfo().getOsFrontDesignMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsFrontDesign()));
//		// SHIRT_ピンタックブザム_名
//		order.setStPintuckBosomNm(orderForm.getOptionShirtStandardInfo().getOsPinTackMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsPinTack()));
//		// SHIRT_ステッチ_名
//		order.setStStitchNm(orderForm.getOptionShirtStandardInfo().getOsStitchMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsStitch()));
//		// SHIRT_カラーキーパー_名
//		order.setStColarKeeperNm(orderForm.getOptionShirtStandardInfo().getOsColorKeeperMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsColorKeeper()));
//		// SHIRT_ボタンホール色変更_名
//		order.setStBtnholeColorNm(orderForm.getOptionShirtStandardInfo().getOsBhColorMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsBhColor()));
//		// SHIRT_ボタン付け糸色変更_名
//		order.setStBtnthreadColorNm(orderForm.getOptionShirtStandardInfo().getOsByColorMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsByColor()));
//		// SHIRT_ボタン位置変更_名
//		order.setStBtnposChgNm(orderForm.getOptionShirtStandardInfo().getOsBtnPosChgMap()
//				.get(orderForm.getOptionShirtStandardInfo().getOsBtnPosChg()));
//		// SHIRT_台襟釦_名
//		order.setStNeckbandBtnChgNm(orderForm.getOptionShirtStandardInfo().getOsBtnPosChgCollar());
//		// SHIRT_フロント第1釦_名
//		order.setStFrtfirstBtnChgNm(orderForm.getOptionShirtStandardInfo().getOsBtnPosChgFront1());
//		// SHIRT_フロント第2釦_名
//		order.setStFrtsecondBtnChgNm(orderForm.getOptionShirtStandardInfo().getOsBtnPosChgFront2());
//	}
//
//	/**
//	 * オーダー内容確認画面COATのMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoStandardCoatMapping(OrderForm orderForm, Order order) {
//
//		// COAT_ラペルデザイン_名
//		order.setCtLapelDesignNm(orderForm.getOptionCoatStandardInfo().getOcLapelDesignMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcLapelDesign()));
//		// COAT_腰ポケット_名
//		order.setCtWaistPktNm(orderForm.getOptionCoatStandardInfo().getOcWaistPktMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcWaistPkt()));
//		// COAT_チェンジポケット_名
//		order.setCtChgPktNm(orderForm.getOptionCoatStandardInfo().getOcChangePktMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcChangePkt()));
//		// COAT_スランテッドポケット_名
//		order.setCtSlantedPktNm(orderForm.getOptionCoatStandardInfo().getOcSlantedPktMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcSlantedPkt()));
//		// COAT_ベント_名
//		order.setCtVentNm(orderForm.getOptionCoatStandardInfo().getOcVentSpecMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcVentSpec()));
//		// COAT_フロント釦数_名
//		order.setCtFrtBtnNm(orderForm.getOptionCoatStandardInfo().getOcFrontBtnCntMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcFrontBtnCnt()));
//		// COAT_袖口_名
//		order.setCtCuffNm(orderForm.getOptionCoatStandardInfo().getOcCuffSpecMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcCuffSpec()));
//		// COAT_袖釦_名
//		order.setCtSleeveBtnNm(orderForm.getOptionCoatStandardInfo().getOcSleeveBtnTypeMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcSleeveBtnType()));
//		// COAT_バックベルト_名
//		order.setCtBackBeltNm(orderForm.getOptionCoatStandardInfo().getOcBackBeltMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcBackBelt()));
//		// COAT_襟吊_名
//		order.setCtCollarHangNm(orderForm.getOptionCoatStandardInfo().getOcChainHangeMap()
//				.get(orderForm.getOptionCoatStandardInfo().getOcChainHange()));
//
//	}

	/**
	 * 
	 * @param productItem
	 * @param productIs3Piece
	 * @param productSparePantsClass
	 * @param ojFrontBtnCnt
	 * @return
	 */
	public String getHostTransmitMakerProductMapKey(String productItem, String productIs3Piece,
			String productSparePantsClass, String ojFrontBtnCnt) {
		// スペアパンツは有り
		String productSparePantsClassYes = "0009902";
		// ３Pieceは有り
		String productIs3PieceYes = "0009902";
		// フロント釦数はダブル
		String ojFrontBtnCntDouble = "0000105";
		// SUIT:01 JACKET:02 PANTS:03 GILET:04
		String suitItemCd = "01";
		String jacketItemCd = "02";

		String itemAnd = "";
		String is3PieceAnd = "";
		String sparePantsClassAnd = "";
		String ojFrontBtnCntAnd = "";

		if (suitItemCd.equals(productItem)) {
			// ２Pシングル
			if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && !productIs3PieceYes.equals(productIs3Piece)
					&& !productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
			}
			// ２Pダブル
			else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && !productIs3PieceYes.equals(productIs3Piece)
					&& !productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				ojFrontBtnCntAnd = "0000105";
			}
			// ２PPシングル
			else if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && !productIs3PieceYes.equals(productIs3Piece)
					&& productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				sparePantsClassAnd = "030009902";
			}
			// ２PPダブル
			else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && !productIs3PieceYes.equals(productIs3Piece)
					&& productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				sparePantsClassAnd = "030009902";
				ojFrontBtnCntAnd = "0000105";
			}
			// ３Pシングル
			else if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && productIs3PieceYes.equals(productIs3Piece)
					&& !productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				is3PieceAnd = "040009902";
			}
			// ３Pダブル
			else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && productIs3PieceYes.equals(productIs3Piece)
					&& !productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				is3PieceAnd = "040009902";
				ojFrontBtnCntAnd = "0000105";
			}
			// ３P２PPシングル
			else if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && productIs3PieceYes.equals(productIs3Piece)
					&& productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				is3PieceAnd = "040009902";
				sparePantsClassAnd = "030009902";
			}
			// ３P２PPダブル
			else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && productIs3PieceYes.equals(productIs3Piece)
					&& productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				is3PieceAnd = "040009902";
				sparePantsClassAnd = "030009902";
				ojFrontBtnCntAnd = "0000105";
			}
		} else if (jacketItemCd.equals(productItem)) {
			// J ジャケット
			if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt)) {
				itemAnd = "02";
			} else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt)) {
				itemAnd = "02";
				ojFrontBtnCntAnd = "0000105";
			}
		} else {
			itemAnd = productItem;
		}
		String hostTransmitMakerProductKey = itemAnd + is3PieceAnd + sparePantsClassAnd + ojFrontBtnCntAnd;
		return hostTransmitMakerProductKey;
	}
	
//	/**
//	 * オーダー内容確認画面のMapの値とorderの対応フィールドのマッピング
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void orderCoMapping(OrderForm orderForm, Order order, String userId, OrderFindFabric findStock,
//			Order orderId) {
//
//		// オーダーパターン
//		order.setOrderPattern(orderForm.getOrderPattern());
//
//		// 注文承り日
//		order.setProductOrderdDate(new Date());
//
//		// TSCステータス
//		order.setTscStatus("T2");
//
//		// 取り消しフラグ
//		order.setIsCancelled("0");
//
//		// 登録者
//		String createdUserId = orderId.getCreatedUserId();
//		order.setCreatedUserId(createdUserId);
//
//		// 登録日時
//		Date createdAt = orderId.getCreatedAt();
//		order.setCreatedAt(createdAt);
//		
//		if("T2".equals(orderForm.getStatus()) || "T3".equals(orderForm.getStatus()) || "T4".equals(orderForm.getStatus()) || "T5".equals(orderForm.getStatus())) {
//			//業態
//			String storeBrandCode = orderId.getStoreBrandCode();
//			order.setStoreBrandCode(storeBrandCode);
//			//店舗コード
//			String shopCode = orderId.getShopCode();
//			order.setShopCode(shopCode);
//		}
//		
//		// 最終更新者
//		order.setUpdatedUserId(userId);
//
//		// 最終更新日時
//		Date updatedAt = new Date();
//		order.setUpdatedAt(updatedAt);
//
//		// 工場ステータス 生産開始前
//		order.setMakerFactoryStatus("F0");
//
//		// tsc stutas
//		order.setTheoreticalStockCheck("1");
//
//		// 商品情報_工場
//		String productFactoryCd = findStock.getFactoryCode();
//		order.setProductFactoryCd(productFactoryCd);
//
//		// 商品情報_メーカーコード
//		String productMakerCode = findStock.getMakerCode();
//		order.setProductMakerCode(productMakerCode);
//
//		// 生地_色
//		String fabricColor = findStock.getColor();
//		order.setFabricColor(fabricColor);
//
//		// 生地_柄
//		String fabricPattern = findStock.getPattern();
//		order.setFabricPattern(fabricPattern);
//		
//		// 商品情報_残布_名
//		String productRemainingClothType = orderForm.getProductRemainingClothType();
//		if("01".equals(productRemainingClothType)) {
//			order.setProductRemainingClothNm("小（通常）"); 
//		}
//		else if("02".equals(productRemainingClothType)) {
//			order.setProductRemainingClothNm("大（タテ15cm×ヨコ15cm）"); 
//		}
////
////		// ホスト連携_店コード
////		order.setHostTransmitStoreCd(order.getShopCode());
////
////		// ホスト連携_品名コード
////		Map<String, String> hostTransmitItemCd03Map = new HashMap<String, String>();
////		Map<String, String> hostTransmitItemCd01Map = new HashMap<String, String>();
////
////		/*
////		 * 業態がTSC(03)の場合 061 スーツ 01 SUIT 062 ジャケット 02 JACKET 063 パンツ 03 PANTS 064 ジレ 04
////		 * GILET
////		 */
////		hostTransmitItemCd03Map.put("01", "061");
////		hostTransmitItemCd03Map.put("02", "062");
////		hostTransmitItemCd03Map.put("03", "063");
////		hostTransmitItemCd03Map.put("04", "064");
////		/*
////		 * 業態がTSC(01)の場合 061 スーツ 01 SUIT 062 ジャケット 02 JACKET 063 パンツ 03 PANTS 067 ジレ 04
////		 * GILET
////		 */
////		hostTransmitItemCd01Map.put("01", "061");
////		hostTransmitItemCd01Map.put("02", "062");
////		hostTransmitItemCd01Map.put("03", "063");
////		hostTransmitItemCd01Map.put("04", "067");
////
////		String hostTransmitItemCdKey = orderForm.getProductItem();
////		String storeBrandCode = order.getStoreBrandCode();
////		if ("01".equals(storeBrandCode)) {
////			String hostTransmitItemCdValue = hostTransmitItemCd01Map.get(hostTransmitItemCdKey);
////			order.setHostTransmitItemCd(hostTransmitItemCdValue);
////		} else if ("03".equals(storeBrandCode)) {
////			String hostTransmitItemCdValue = hostTransmitItemCd03Map.get(hostTransmitItemCdKey);
////			order.setHostTransmitItemCd(hostTransmitItemCdValue);
////		}
////
////		// ホスト連携_メーカーコード
////		order.setHostTransmitMakerCd(findMakerId);
////
////		// ホスト連携_年季
////		String hostTransmitNenkiCd = findStock.getSeason();
////		order.setHostTransmitNenkiCd(hostTransmitNenkiCd);
////
////		// ホスト連携_色
////		String hostTransmitColorCd = findStock.getColorAoyama();
////		String hostTransmitPatternCd = findStock.getPatternAoyama();
////		order.setHostTransmitColorCd(hostTransmitColorCd + hostTransmitPatternCd);
////
////		// 工場自動連携ステータス
////		order.setSend2factoryStatus("0");
////
////		// ホスト連携_サイズ
////		String orderItemCd = orderForm.getProductItem();
////		String suitItemCd = "01";
////		String jacketItemCd = "02";
////		String pantsItemCd = "03";
////		String giletItemCd = "04";
////		if (suitItemCd.equals(orderItemCd) || jacketItemCd.equals(orderItemCd)) {
////			String subStringSizeFigure = "";
////			String subStringSizeNumber = "";
////			String sizeNumber = orderForm.getAdjustJacketStandardInfo().getSizeNumber();
////			if (sizeNumber.indexOf("(") != -1) {
////				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
////			}
////			String sizeFigure = orderForm.getAdjustJacketStandardInfo().getSizeFigure();
////			if (sizeFigure.indexOf("(") != -1) {
////				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
////			}
////			
////			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
////			order.setHostTransmitSize(hostTransmitSize);
////		} else if (pantsItemCd.equals(orderItemCd)) {
////			String subStringSizeFigure = "";
////			String subStringSizeNumber = "";
////			String sizeNumber = orderForm.getAdjustPantsStandardInfo().getSizeNumber();
////			if (sizeNumber.indexOf("(") != -1) {
////				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
////			}
////			String sizeFigure = orderForm.getAdjustPantsStandardInfo().getSizeFigure();
////			if (sizeFigure.indexOf("(") != -1) {
////				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
////			}
////			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
////			order.setHostTransmitSize(hostTransmitSize);
////		} else if (giletItemCd.equals(orderItemCd)) {
////			String subStringSizeFigure = "";
////			String subStringSizeNumber = "";
////			String sizeNumber = orderForm.getAdjustGiletStandardInfo().getSizeNumber();
////			if (sizeNumber.indexOf("(") != -1) {
////				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
////			}
////
////			String sizeFigure = orderForm.getAdjustGiletStandardInfo().getSizeFigure();
////			if (sizeFigure.indexOf("(") != -1) {
////				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
////			}
////			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
////			order.setHostTransmitSize(hostTransmitSize);
////		}
////
////		// ホスト連携_メーカー品番
////		/*
////		 * 生地品番(8)＋色(1)＋柄(1)＋区分(1) 色、柄：TSC表記 区分： SUIT 単品 1 ２Pシングル J ジャケット 2 ２Pダブル W
////		 * ダブルジャケット 3 ２PPシングル G ジレ 4 ２PPダブル V ダブルジレ 5 ３Pシングル P パンツ 6 ３Pダブル D ドレスシャツ 7
////		 * ３P２PPシングル C シングルコート 8 ３P２PPダブル A ダブルコート
////		 */
////		Map<String, String> hostTransmitMakerProductMap = new HashMap<String, String>();
////		// 1 ２Pシングル
////		hostTransmitMakerProductMap.put("01", "1");
////		// 2 ２Pダブル
////		hostTransmitMakerProductMap.put("010000105", "2");
////		// 3 ２PPシングル
////		hostTransmitMakerProductMap.put("01030009902", "3");
////		// 4 ２PPダブル
////		hostTransmitMakerProductMap.put("010300099020000105", "4");
////		// 5 ３Pシングル
////		hostTransmitMakerProductMap.put("01040009902", "5");
////		// 6 ３Pダブル
////		hostTransmitMakerProductMap.put("010400099020000105", "6");
////		// 7 ３P２PPシングル
////		hostTransmitMakerProductMap.put("01040009902030009902", "7");
////		// 8 ３P２PPダブル
////		hostTransmitMakerProductMap.put("010400099020300099020000105", "8");
////		// J ジャケット
////		hostTransmitMakerProductMap.put("02", "J");
////		// W ダブルジャケット
////		hostTransmitMakerProductMap.put("020000105", "W");
////		// G ジレ
////		hostTransmitMakerProductMap.put("04", "G");
////		// P パンツ
////		hostTransmitMakerProductMap.put("03", "P");
////
////		// 商品情報_ITEM
////		String productItem = orderForm.getProductItem();
////		// 商品情報_３Piece
////		String productIs3Piece = orderForm.getProductIs3Piece();
////		// 商品情報_スペアパンツ
////		String productSparePantsClass = orderForm.getProductSparePantsClass();
////		// フロント釦数
////		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
////		String hostTransmitMakerProductMapKey = getHostTransmitMakerProductMapKey(productItem, productIs3Piece,
////				productSparePantsClass, ojFrontBtnCnt);
////
////		String productFabricNo = orderForm.getProductFabricNo();
////		String hostTransmitMakerProductMapValue = hostTransmitMakerProductMap.get(hostTransmitMakerProductMapKey);
////		String hostTransmitMakerProductValue = productFabricNo + fabricColor + fabricPattern
////				+ hostTransmitMakerProductMapValue;
////		order.setHostTransmitMakerProduct(hostTransmitMakerProductValue);
////
////		// 商品情報_刺繍ネーム、商品情報_刺繍書体、商品情報_刺繍糸色はnull値の判定
////		String productEmbroideryNecessity = orderForm.getProductEmbroideryNecessity();
////		if ("0".equals(productEmbroideryNecessity)) {
////			order.setProductEmbroideryNm(null);
////			order.setProductEmbroideryFont(null);
////			order.setProductEmbroideryThreadColor(null);
////		}
////
////		// PANTS_ダブル幅についての項目はnull値の判定
////		String opHemUp = orderForm.getOptionPantsStandardInfo().getOpHemUp();
////		if ("0001701".equals(opHemUp) || "0001704".equals(opHemUp)) {
////			order.setPtDblWidthCd(null);
////			order.setPtDblWidthNm(null);
////			order.setPtDblWidthRtPrice(null);
////			order.setPtDblWidthWsWage(null);
////			order.setPtDblWidthWsPrice(null);
////		}
////
////		// PANTS2_ダブル幅についての項目はnull値の判定
////		String op2HemUp = orderForm.getOptionPants2StandardInfo().getOp2HemUp();
////		if ("0001701".equals(op2HemUp) || "0001704".equals(op2HemUp)) {
////			order.setPt2DblWidthCd(null);
////			order.setPt2DblWidthNm(null);
////			order.setPt2DblWidthRtPrice(null);
////			order.setPt2DblWidthWsWage(null);
////			order.setPt2DblWidthWsPrice(null);
////		}
////
////		if ("01".equals(orderItemCd) || "03".equals(orderItemCd)) {
////
////			// PANTS_股下右_グロス
////			String corPtRightinseamGross = orderForm.getAdjustPantsStandardInfo().getCorPtRightinseamGross();
////			if (corPtRightinseamGross == null || "".equals(corPtRightinseamGross)) {
////				order.setCorPtRightinseamGross(new BigDecimal(0.0));
////			}
////
////			// PANTS_股下左_グロス
////			String corPtLeftinseamGross = orderForm.getAdjustPantsStandardInfo().getCorPtLeftinseamGross();
////			if (corPtLeftinseamGross == null || "".equals(corPtLeftinseamGross)) {
////				order.setCorPtLeftinseamGross(new BigDecimal(0.0));
////			}
////
////		}
////
////		// スペアパンツは有り
////		String productYes = "0009902";
//////		String productSparePantsClass = orderForm.getProductSparePantsClass();
////
////		if ("01".equals(orderItemCd) && productYes.equals(productSparePantsClass)) {
////
////			// 2PANTS_股下右_グロス
////			String corPt2RightinseamGross = orderForm.getAdjustPants2StandardInfo().getCorPt2RightinseamGross();
////			if (corPt2RightinseamGross == null || "".equals(corPt2RightinseamGross)) {
////				order.setCorPt2RightinseamGross(new BigDecimal(0.0));
////			}
////
////			// 2PANTS_股下左_グロス
////			String corPt2LeftinseamGross = orderForm.getAdjustPants2StandardInfo().getCorPt2LeftinseamGross();
////			if (corPt2LeftinseamGross == null || "".equals(corPt2LeftinseamGross)) {
////				order.setCorPt2LeftinseamGross(new BigDecimal(0.0));
////			}
////
////		}
////
////		// JACKET_モデル_上代
////		Integer doubleJacketPrice = retailPriceRelatedMap.get("doubleJACKET");
////		Integer singleDoubleJacketPrice = retailPriceRelatedMap.get("singleDoubleJACKET");
//////		String productItem = orderForm.getProductItem();
//////		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
////		if ("0000105".equals(ojFrontBtnCnt)) {
////			if ("01".equals(productItem)) {
////				if (doubleJacketPrice != null) {
////					order.setJkModelRtPrice(doubleJacketPrice);
////				} else {
////					order.setJkModelRtPrice(0);
////				}
////			} else if ("02".equals(productItem)) {
////				if (singleDoubleJacketPrice != null) {
////					order.setJkModelRtPrice(singleDoubleJacketPrice);
////				} else {
////					order.setJkModelRtPrice(0);
////				}
////			}
////		} else {
////			if ("01".equals(productItem) || "02".equals(productItem)) {
////				order.setJkModelRtPrice(0);
////			}
////
////		}
//		// お客様情報_お客様氏名
//		order.setCustNm(null);
//		// お客様情報_フリガナ
//		order.setCustKanaNm(null);
//		// お客様備考
//		order.setCustRemark(orderForm.getCustomerMessageInfo().getCustRemark().replaceAll("\\n", ""));
////		
////		if(priceCode != null) {
////			// 生地代
////			Integer fabricPrice = priceCode.getFabricPrice();
////			order.setFabricPrice(fabricPrice);
////			// 下代調整金
////			Integer wsPriceAdjust = priceCode.getWsPriceAdjust();
////			order.setWsPriceAdjust(wsPriceAdjust);
////		}
//		
//	}
	
	
	/**
	 * 
	 * @param string
	 * @return
	 */
	public String complete2Digits(String string) {
		String blankSpace = " ";
		if(string.length() < 2) {
			string = string + blankSpace;
		}
		return string;
	}

	/**
	 * オーダー内容確認画面のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderMappingPo(OrderForm orderForm, Order order, String userId, OrderFindFabric findStock,
			Order orderId, String findMakerId, Map<String, Integer> retailPriceRelatedMap,NextGenerationPrice priceCode) {

		// オーダーパターン
		order.setOrderPattern(orderForm.getOrderPattern());

		// 注文承り日
		order.setProductOrderdDate(new Date());

		// TSCステータス
		order.setTscStatus("T2");

		// 取り消しフラグ
		order.setIsCancelled("0");

		// 登録者
		String createdUserId = orderId.getCreatedUserId();
		order.setCreatedUserId(createdUserId);

		// 登録日時
		Date createdAt = orderId.getCreatedAt();
		order.setCreatedAt(createdAt);
		
		if("T2".equals(orderForm.getStatus()) || "T3".equals(orderForm.getStatus()) || "T4".equals(orderForm.getStatus()) || "T5".equals(orderForm.getStatus())) {
			//業態
			String storeBrandCode = orderId.getStoreBrandCode();
			order.setStoreBrandCode(storeBrandCode);
			//店舗コード
			String shopCode = orderId.getShopCode();
			order.setShopCode(shopCode);
		}

		// 最終更新者
		order.setUpdatedUserId(userId);

		// 最終更新日時
		Date updatedAt = new Date();
		order.setUpdatedAt(updatedAt);

		// 工場ステータス 生産開始前
		order.setMakerFactoryStatus("F0");

		// tsc stutas
		order.setTheoreticalStockCheck("1");

		// 商品情報_工場
		String productFactoryCd = findStock.getFactoryCode();
		order.setProductFactoryCd(productFactoryCd);

		// 商品情報_メーカーコード
		String productMakerCode = findStock.getMakerCode();
		order.setProductMakerCode(productMakerCode);

		// 生地_色
		String fabricColor = findStock.getColor();
		order.setFabricColor(fabricColor);

		// 生地_柄
		String fabricPattern = findStock.getPattern();
		order.setFabricPattern(fabricPattern);

		// ホスト連携_店コード
		order.setHostTransmitStoreCd(order.getShopCode());

		// ホスト連携_品名コード
		Map<String, String> hostTransmitItemCd03Map = new HashMap<String, String>();
		Map<String, String> hostTransmitItemCd01Map = new HashMap<String, String>();

		/*
		 * 業態がTSC(03)の場合 061 スーツ 01 SUIT 062 ジャケット 02 JACKET 063 パンツ 03 PANTS 064 ジレ 04
		 * GILET
		 */
		hostTransmitItemCd03Map.put("01", "061");
		hostTransmitItemCd03Map.put("02", "062");
		hostTransmitItemCd03Map.put("03", "063");
		hostTransmitItemCd03Map.put("04", "064");
		/*
		 * 業態がTSC(01)の場合 061 スーツ 01 SUIT 062 ジャケット 02 JACKET 063 パンツ 03 PANTS 067 ジレ 04
		 * GILET
		 */
		hostTransmitItemCd01Map.put("01", "061");
		hostTransmitItemCd01Map.put("02", "062");
		hostTransmitItemCd01Map.put("03", "063");
		hostTransmitItemCd01Map.put("04", "067");

		String hostTransmitItemCdKey = orderForm.getProductItem();
		String storeBrandCode = order.getStoreBrandCode();
		if ("01".equals(storeBrandCode)) {
			String hostTransmitItemCdValue = hostTransmitItemCd01Map.get(hostTransmitItemCdKey);
			order.setHostTransmitItemCd(hostTransmitItemCdValue);
		} else if ("03".equals(storeBrandCode) || "12".equals(storeBrandCode) || "21".equals(storeBrandCode)) {
			String hostTransmitItemCdValue = hostTransmitItemCd03Map.get(hostTransmitItemCdKey);
			order.setHostTransmitItemCd(hostTransmitItemCdValue);
		}

		// ホスト連携_メーカーコード
		order.setHostTransmitMakerCd(findMakerId);

		// ホスト連携_年季
		String hostTransmitNenkiCd = findStock.getSeason();
		order.setHostTransmitNenkiCd(hostTransmitNenkiCd);

		// ホスト連携_色
		String hostTransmitColorCd = findStock.getColorAoyama();
		String hostTransmitPatternCd = findStock.getPatternAoyama();
		order.setHostTransmitColorCd(hostTransmitColorCd + hostTransmitPatternCd);

		// 工場自動連携ステータス
		order.setSend2factoryStatus("0");

		// ホスト連携_サイズ
		String orderItemCd = orderForm.getProductItem();
		String suitItemCd = "01";
		String jacketItemCd = "02";
		String pantsItemCd = "03";
		String giletItemCd = "04";
		if (suitItemCd.equals(orderItemCd) || jacketItemCd.equals(orderItemCd)) {
			String subStringSizeFigure = "";
			String subStringSizeNumber = "";
			String sizeNumber = orderForm.getAdjustJacketStandardInfo().getSizeNumber();
			if (sizeNumber.indexOf("(") != -1) {
				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
			}
			String sizeFigure = orderForm.getAdjustJacketStandardInfo().getSizeFigure();
			if (sizeFigure.indexOf("(") != -1) {
				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
			}
			
			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
			order.setHostTransmitSize(hostTransmitSize);
		} else if (pantsItemCd.equals(orderItemCd)) {
			String subStringSizeFigure = "";
			String subStringSizeNumber = "";
			String sizeNumber = orderForm.getAdjustPantsStandardInfo().getSizeNumber();
			if (sizeNumber.indexOf("(") != -1) {
				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
			}
			String sizeFigure = orderForm.getAdjustPantsStandardInfo().getSizeFigure();
			if (sizeFigure.indexOf("(") != -1) {
				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
			}
			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
			order.setHostTransmitSize(hostTransmitSize);
		} else if (giletItemCd.equals(orderItemCd)) {
			String subStringSizeFigure = "";
			String subStringSizeNumber = "";
			String sizeNumber = orderForm.getAdjustGiletStandardInfo().getSizeNumber();
			if (sizeNumber.indexOf("(") != -1) {
				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
			}

			String sizeFigure = orderForm.getAdjustGiletStandardInfo().getSizeFigure();
			if (sizeFigure.indexOf("(") != -1) {
				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
			}
			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
			order.setHostTransmitSize(hostTransmitSize);
		}

		// ホスト連携_メーカー品番
		/*
		 * 生地品番(8)＋色(1)＋柄(1)＋区分(1) 色、柄：TSC表記 区分： SUIT 単品 1 ２Pシングル J ジャケット 2 ２Pダブル W
		 * ダブルジャケット 3 ２PPシングル G ジレ 4 ２PPダブル V ダブルジレ 5 ３Pシングル P パンツ 6 ３Pダブル D ドレスシャツ 7
		 * ３P２PPシングル C シングルコート 8 ３P２PPダブル A ダブルコート
		 */
		Map<String, String> hostTransmitMakerProductMap = new HashMap<String, String>();
		// 1 ２Pシングル
		hostTransmitMakerProductMap.put("01", "1");
		// 2 ２Pダブル
		hostTransmitMakerProductMap.put("010000105", "2");
		// 3 ２PPシングル
		hostTransmitMakerProductMap.put("01030009902", "3");
		// 4 ２PPダブル
		hostTransmitMakerProductMap.put("010300099020000105", "4");
		// 5 ３Pシングル
		hostTransmitMakerProductMap.put("01040009902", "5");
		// 6 ３Pダブル
		hostTransmitMakerProductMap.put("010400099020000105", "6");
		// 7 ３P２PPシングル
		hostTransmitMakerProductMap.put("01040009902030009902", "7");
		// 8 ３P２PPダブル
		hostTransmitMakerProductMap.put("010400099020300099020000105", "8");
		// J ジャケット
		hostTransmitMakerProductMap.put("02", "J");
		// W ダブルジャケット
		hostTransmitMakerProductMap.put("020000105", "W");
		// G ジレ
		hostTransmitMakerProductMap.put("04", "G");
		// P パンツ
		hostTransmitMakerProductMap.put("03", "P");

		// 商品情報_ITEM
		String productItem = orderForm.getProductItem();
		// 商品情報_３Piece
		String productIs3Piece = orderForm.getProductIs3Piece();
		// 商品情報_スペアパンツ
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		// フロント釦数
		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
		String hostTransmitMakerProductMapKey = getHostTransmitMakerProductMapKey(productItem, productIs3Piece,
				productSparePantsClass, ojFrontBtnCnt);

		String productFabricNo = orderForm.getProductFabricNo();
		String hostTransmitMakerProductMapValue = hostTransmitMakerProductMap.get(hostTransmitMakerProductMapKey);
		String hostTransmitMakerProductValue = productFabricNo + fabricColor + fabricPattern
				+ hostTransmitMakerProductMapValue;
		order.setHostTransmitMakerProduct(hostTransmitMakerProductValue);

		// 商品情報_刺繍ネーム、商品情報_刺繍書体、商品情報_刺繍糸色はnull値の判定
		String productEmbroideryNecessity = orderForm.getProductEmbroideryNecessity();
		if ("0".equals(productEmbroideryNecessity)) {
			order.setProductEmbroideryNm(null);
			order.setProductEmbroideryFont(null);
			order.setProductEmbroideryThreadColor(null);
		}

		// PANTS_ダブル幅についての項目はnull値の判定
		String opHemUp = orderForm.getOptionPantsStandardInfo().getOpHemUp();
		if ("0001701".equals(opHemUp) || "0001704".equals(opHemUp)) {
			order.setPtDblWidthCd(null);
			order.setPtDblWidthNm(null);
			order.setPtDblWidthRtPrice(null);
			order.setPtDblWidthWsWage(null);
			order.setPtDblWidthWsPrice(null);
		}

		// PANTS2_ダブル幅についての項目はnull値の判定
		String op2HemUp = orderForm.getOptionPants2StandardInfo().getOp2HemUp();
		if ("0001701".equals(op2HemUp) || "0001704".equals(op2HemUp)) {
			order.setPt2DblWidthCd(null);
			order.setPt2DblWidthNm(null);
			order.setPt2DblWidthRtPrice(null);
			order.setPt2DblWidthWsWage(null);
			order.setPt2DblWidthWsPrice(null);
		}

		if ("01".equals(orderItemCd) || "03".equals(orderItemCd)) {

			// PANTS_股下右_グロス
			String corPtRightinseamGross = orderForm.getAdjustPantsStandardInfo().getCorPtRightinseamGross();
			if (corPtRightinseamGross == null || "".equals(corPtRightinseamGross)) {
				order.setCorPtRightinseamGross(new BigDecimal(0.0));
			}

			// PANTS_股下左_グロス
			String corPtLeftinseamGross = orderForm.getAdjustPantsStandardInfo().getCorPtLeftinseamGross();
			if (corPtLeftinseamGross == null || "".equals(corPtLeftinseamGross)) {
				order.setCorPtLeftinseamGross(new BigDecimal(0.0));
			}

		}

		// スペアパンツは有り
		String productYes = "0009902";
//		String productSparePantsClass = orderForm.getProductSparePantsClass();

		if ("01".equals(orderItemCd) && productYes.equals(productSparePantsClass)) {

			// 2PANTS_股下右_グロス
			String corPt2RightinseamGross = orderForm.getAdjustPants2StandardInfo().getCorPt2RightinseamGross();
			if (corPt2RightinseamGross == null || "".equals(corPt2RightinseamGross)) {
				order.setCorPt2RightinseamGross(new BigDecimal(0.0));
			}

			// 2PANTS_股下左_グロス
			String corPt2LeftinseamGross = orderForm.getAdjustPants2StandardInfo().getCorPt2LeftinseamGross();
			if (corPt2LeftinseamGross == null || "".equals(corPt2LeftinseamGross)) {
				order.setCorPt2LeftinseamGross(new BigDecimal(0.0));
			}

		}

		// JACKET_モデル_上代
		Integer doubleJacketPrice = retailPriceRelatedMap.get("doubleJACKET");
		Integer singleDoubleJacketPrice = retailPriceRelatedMap.get("singleDoubleJACKET");
//		String productItem = orderForm.getProductItem();
//		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
		if ("0000105".equals(ojFrontBtnCnt)) {
			if ("01".equals(productItem)) {
				if (doubleJacketPrice != null) {
					order.setJkModelRtPrice(doubleJacketPrice);
				} else {
					order.setJkModelRtPrice(0);
				}
			} else if ("02".equals(productItem)) {
				if (singleDoubleJacketPrice != null) {
					order.setJkModelRtPrice(singleDoubleJacketPrice);
				} else {
					order.setJkModelRtPrice(0);
				}
			}
		} else {
			if ("01".equals(productItem) || "02".equals(productItem)) {
				order.setJkModelRtPrice(0);
			}

		}
		// お客様情報_お客様氏名
		order.setCustNm(null);
		// お客様情報_フリガナ
		order.setCustKanaNm(null);
		// お客様備考
		order.setCustRemark(orderForm.getCustomerMessageInfo().getCustRemark().replaceAll("\\n", ""));
		
		if(priceCode != null) {
			// 生地代
			Integer fabricPrice = priceCode.getFabricPrice();
			order.setFabricPrice(fabricPrice);
			// 下代調整金
			Integer wsPriceAdjust = priceCode.getWsPriceAdjust();
			order.setWsPriceAdjust(wsPriceAdjust);
		}
		
	}

	/**
	 * 更新のみのデータ
	 * 
	 * @param selectExistOrder
	 * @param order
	 */
	public void onlyUpdateItem(Order selectExistOrder, Order order,String authority) {
		// 売上金額
		Integer salesAmount = selectExistOrder.getSalesAmount();
		order.setSalesAmount(salesAmount);
		// 会計ID
		String cashId = selectExistOrder.getCashId();
		order.setCashId(cashId);
		// 値引き後金額
		Integer cashDiscountPrice = selectExistOrder.getCashDiscountPrice();
		order.setCashDiscountPrice(cashDiscountPrice);
		// 会計後商品金額（税抜き）
		Integer cashProductPrice = selectExistOrder.getCashProductPrice();
		order.setCashProductPrice(cashProductPrice);
		// 会計後商品金額（税込み）
		Integer cashContailTaxProductPrice = selectExistOrder.getCashContailTaxProductPrice();
		order.setCashContailTaxProductPrice(cashContailTaxProductPrice);
		// 店舗・担当_店舗名
		String storeNm = selectExistOrder.getStoreNm();
		order.setStoreNm(storeNm);
		// 店舗・担当_営業担当者
		String storeStaffNm = selectExistOrder.getStoreStaffNm();
		order.setStoreStaffNm(storeStaffNm);
		// 証紙印字情報_お客様名ローマ字
		String printoutCustRomaNm = selectExistOrder.getPrintoutCustRomaNm();
		order.setPrintoutCustRomaNm(printoutCustRomaNm);
		// 証紙印字情報_営業担当者ローマ字
		String printoutStoreStaffRomaNm = selectExistOrder.getPrintoutStoreStaffRomaNm();
		order.setPrintoutStoreStaffRomaNm(printoutStoreStaffRomaNm);
		// お客様情報_お客様氏名
		String custNm = selectExistOrder.getCustNm();
		order.setCustNm(custNm);
		// お客様情報_フリガナ
		String custKanaNm = selectExistOrder.getCustKanaNm();
		order.setCustKanaNm(custKanaNm);
		// ホスト連携_A行
		String hostTransmitARow = selectExistOrder.getHostTransmitARow();
		order.setHostTransmitARow(hostTransmitARow);
		// 出荷番号
		String shippingNumber = selectExistOrder.getShippingNumber();
		order.setShippingNumber(shippingNumber);
		
		if ("02".equals(authority)) {
			// 業態
			order.setStoreBrandCode(selectExistOrder.getStoreBrandCode());
			// 店舗コード
			order.setShopCode(selectExistOrder.getShopCode());

		}
	}

	/**
	 * オーダー内容確認画面のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 * @param authority
	 */
	public void orderMappingLogOn(OrderForm orderForm, Order order, SessionContent sessionContent, Order orderIsExist) {

		if(orderIsExist!=null) {
			//商品部の場合
			if ("02".equals(sessionContent.getAuthority())) {
				// 業態
				order.setStoreBrandCode(orderIsExist.getStoreBrandCode());
				// 店舗コード
				order.setShopCode(orderIsExist.getShopCode());
				
				order.setStoreNm(orderIsExist.getStoreNm());
			}else {
				order.setStoreBrandCode(sessionContent.getStoreBrandCode());
				
				order.setShopCode(sessionContent.getBelongCode());
				
				order.setStoreNm(sessionContent.getBelongName());
			}
			
			// オーダーパターン
			order.setOrderPattern(orderIsExist.getOrderPattern());
			// 取り消しフラグ
			order.setIsCancelled(orderIsExist.getIsCancelled());

			// 最終更新者
			order.setUpdatedUserId(sessionContent.getUserId());

			// 工場ステータス 生産開始前
			order.setMakerFactoryStatus(orderIsExist.getMakerFactoryStatus());

			// 登録日時
			order.setCreatedAt(orderIsExist.getCreatedAt());

			// 登録者
			order.setCreatedUserId(orderIsExist.getCreatedUserId());

			// 工場自動連携ステータス
			order.setSend2factoryStatus(orderIsExist.getSend2factoryStatus());

			// 理論在庫チェック
			order.setTheoreticalStockCheck(orderIsExist.getTheoreticalStockCheck());
			
			// 最終更新日時
			order.setUpdatedAt(new Date());

			// 最終更新者
			order.setUpdatedUserId(sessionContent.getUserId());
			
		}else {
			// 業態
			order.setStoreBrandCode(sessionContent.getStoreBrandCode());
			
			// 店舗コード
			order.setShopCode(sessionContent.getBelongCode());
			
			order.setStoreNm(sessionContent.getBelongName());
			
			// 理論在庫チェック
			order.setTheoreticalStockCheck(IS_NOT_THEORETICAL_STOCKCECK);
			
			// 工場ステータス
			order.setMakerFactoryStatus(FACTORY_STATUSF0);
			
			// 取り消しフラグ
			order.setIsCancelled(IS_NOT_CANCELLED);
			
			// 工場自動連携ステータス
			order.setSend2factoryStatus(SEND2FACTORY_STATUS0);
			
			order.setCreatedUserId(sessionContent.getUserId());
			order.setCreatedAt(new Date());
			order.setUpdatedAt(new Date());
			order.setUpdatedUserId(sessionContent.getUserId());
			order.setVersion((short)0);
		}
		
		// お客様氏名
		order.setCustNm(null);

		// お客様情報_フリガナ
		order.setCustKanaNm(null);


		// お客様備考
		order.setCustRemark(orderForm.getCustomerMessageInfo().getCustRemark().replaceAll("\\n", ""));

		// 注文承り日
		order.setProductOrderdDate(new Date());


		// 商品情報_刺繍ネーム、商品情報_刺繍書体、商品情報_刺繍糸色はnull値の判定
		String productEmbroideryNecessity = orderForm.getProductEmbroideryNecessity();
		if ("0".equals(productEmbroideryNecessity)) {
			order.setProductEmbroideryNm(null);
			order.setProductEmbroideryFont(null);
			order.setProductEmbroideryThreadColor(null);
		}

		// PANTS_ダブル幅についての項目はnull値の判定
		String opHemUp = orderForm.getOptionPantsStandardInfo().getOpHemUp();
		if ("0001701".equals(opHemUp) || "0001704".equals(opHemUp)) {
			order.setPtDblWidthCd(null);
			order.setPtDblWidthNm(null);
			order.setPtDblWidthRtPrice(null);
			order.setPtDblWidthWsWage(null);
			order.setPtDblWidthWsPrice(null);
		}

		// PANTS2_ダブル幅についての項目はnull値の判定
		String op2HemUp = orderForm.getOptionPants2StandardInfo().getOp2HemUp();
		if ("0001701".equals(op2HemUp) || "0001704".equals(op2HemUp)) {
			order.setPt2DblWidthCd(null);
			order.setPt2DblWidthNm(null);
			order.setPt2DblWidthRtPrice(null);
			order.setPt2DblWidthWsWage(null);
			order.setPt2DblWidthWsPrice(null);
		}
	}

	/**
	 * 空とnullの変換
	 * 
	 * @param measuring
	 * @return
	 */
	public BigDecimal convertBigDecimal(String measuring) {
		BigDecimal result = new BigDecimal(0.0);
		if ("".equals(measuring) || measuring == null) {
			return result;
		}
		return new BigDecimal(measuring);
	}

	/**
	 * オーダー内容確認画面のメジャーリングの値とmeasuringの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param measuring
	 * @param userId
	 */
	public void measuringMapping(OrderForm orderForm, Measuring measuring, String userId) {

		// 注文ID
		measuring.setOrderId(orderForm.getCustomerMessageInfo().getOrderId());
		// フルレングス
		measuring.setFullLength(convertBigDecimal(orderForm.getMeasuringInfo().getFullLength()));
		// ショルダー
		measuring.setShoulder(convertBigDecimal(orderForm.getMeasuringInfo().getShoulder()));
		// リーチ（右）
		measuring.setReachRight(convertBigDecimal(orderForm.getMeasuringInfo().getReachRight()));
		// リーチ（左）
		measuring.setReachLeft(convertBigDecimal(orderForm.getMeasuringInfo().getReachLeft()));
		// アウトバスト
		measuring.setOutBust(convertBigDecimal(orderForm.getMeasuringInfo().getOutBust()));
		// バスト
		measuring.setBust(convertBigDecimal(orderForm.getMeasuringInfo().getBust()));
		// JKウエスト
		measuring.setJacketWaist(convertBigDecimal(orderForm.getMeasuringInfo().getJacketWaist()));
		// PTウエスト
		measuring.setPantsWaist(convertBigDecimal(orderForm.getMeasuringInfo().getPantsWaist()));
		// ヒップ
		measuring.setHip(convertBigDecimal(orderForm.getMeasuringInfo().getHip()));
		// ワタリ（右）
		measuring.setSpanRight(convertBigDecimal(orderForm.getMeasuringInfo().getSpanRight()));
		// ワタリ（左）
		measuring.setSpanLeft(convertBigDecimal(orderForm.getMeasuringInfo().getSpanLeft()));
		// ふくらはぎ（右）
		measuring.setCalfRight(convertBigDecimal(orderForm.getMeasuringInfo().getCalfRight()));
		// ふくらはぎ（左）
		measuring.setCalfLeft(convertBigDecimal(orderForm.getMeasuringInfo().getCalfLeft()));
		// ネック
		measuring.setNeck(convertBigDecimal(orderForm.getMeasuringInfo().getNeck()));

		measuring.setUpdatedUserId(userId);

		measuring.setUpdatedAt(new Date());
	}

	/**
	 * 素材品番のMapを取得
	 * 
	 * @param orderForm
	 * @param detailList
	 */
	public void dealWithDetailCode(OrderForm orderForm, List<OptionBranchDetail> detailList) {
		Map<String, String> jkMateMap = new HashMap<String, String>();
		Map<String, String> ptMateMap = new HashMap<String, String>();
		Map<String, String> pt2MateMap = new HashMap<String, String>();
		Map<String, String> glMateMap = new HashMap<String, String>();

		for (OptionBranchDetail optionBranchDetail : detailList) {
			if (optionBranchDetail.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				jkMateMap.put(optionBranchDetail.getSubItemCode() + optionBranchDetail.getOptionCode()
						+ optionBranchDetail.getOptionBranchCode() + optionBranchDetail.getOptionBranchDetailCode(),
						optionBranchDetail.getOptionBranchDetailName());
			} else if (optionBranchDetail.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				ptMateMap.put(optionBranchDetail.getSubItemCode() + optionBranchDetail.getOptionCode()
						+ optionBranchDetail.getOptionBranchCode() + optionBranchDetail.getOptionBranchDetailCode(),
						optionBranchDetail.getOptionBranchDetailName());
			} else if (optionBranchDetail.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				glMateMap.put(optionBranchDetail.getSubItemCode() + optionBranchDetail.getOptionCode()
						+ optionBranchDetail.getOptionBranchCode() + optionBranchDetail.getOptionBranchDetailCode(),
						optionBranchDetail.getOptionBranchDetailName());
			} else if (optionBranchDetail.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				pt2MateMap.put(optionBranchDetail.getSubItemCode() + optionBranchDetail.getOptionCode()
						+ optionBranchDetail.getOptionBranchCode() + optionBranchDetail.getOptionBranchDetailCode(),
						optionBranchDetail.getOptionBranchDetailName());
			}
		}
		orderForm.getOptionJacketStandardInfo().setJacketMateMap(jkMateMap);
		orderForm.getOptionPantsStandardInfo().setPantsMateMap(ptMateMap);
		orderForm.getOptionPants2StandardInfo().setPants2MateMap(pt2MateMap);
		orderForm.getOptionGiletStandardInfo().setGiletMateMap(glMateMap);
	}

	/**
	 * オーダー内容確認画面JACKETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderJkNameMappingPo(OrderForm orderForm, Order order) {

		// subItemCode
		String jacketSubItemCode = "02";

		// JACKETの胴裏素材Name表示
		String ojBodyBackMateOptionCode = "00038";
		String ojBodyBackMateCode = orderForm.getOptionJacketStandardInfo().getOjBodyBackMate();
		String ojBodyBackMateStkNoCode = orderForm.getOptionJacketStandardInfo().getOjBodyBackMateStkNo();

		String jkInnerBodyClothNmCode = jacketSubItemCode + ojBodyBackMateOptionCode + ojBodyBackMateCode
				+ ojBodyBackMateStkNoCode;
		String jkInnerClothNm = orderForm.getOptionJacketStandardInfo().getOjBodyBackMateMap().get(ojBodyBackMateCode);
		String jkInnerBodyClothNm = orderForm.getOptionJacketStandardInfo().getJacketMateMap()
				.get(jkInnerBodyClothNmCode);
		order.setJkInnerBodyClothNm(jkInnerClothNm + " " + jkInnerBodyClothNm);

		// JACKETの袖裏素材Name表示
		String ojCuffBackMateOptionCode = "00040";
		String ojCuffBackMateCode = orderForm.getOptionJacketStandardInfo().getOjCuffBackMate();
		String ojCuffBackMateStkNoCode = orderForm.getOptionJacketStandardInfo().getOjCuffBackMateStkNo();

		String jkInnerSleeveClothNmCode = jacketSubItemCode + ojCuffBackMateOptionCode + ojCuffBackMateCode
				+ ojCuffBackMateStkNoCode;
		String jkInnerSleeveBodyClothNm = orderForm.getOptionJacketStandardInfo().getOjCuffBackMateMap()
				.get(ojCuffBackMateCode);
		String jkInnerSleeveClothNm = orderForm.getOptionJacketStandardInfo().getJacketMateMap()
				.get(jkInnerSleeveClothNmCode);
		order.setJkInnerSleeveClothNm(jkInnerSleeveBodyClothNm + " " + jkInnerSleeveClothNm);

		// JACKETの釦素材Name表示
		String ojBtnMateOptionCode = "00042";
		String ojBtnMateCode = orderForm.getOptionJacketStandardInfo().getOjBtnMate();
		String ojBtnMateStkNoCode = orderForm.getOptionJacketStandardInfo().getOjBtnMateStkNo();

		String jkBtnMaterialNmCode = jacketSubItemCode + ojBtnMateOptionCode + ojBtnMateCode + ojBtnMateStkNoCode;
		String jkBtnMaterialBodyNm = orderForm.getOptionJacketStandardInfo().getOjBtnMateMap().get(ojBtnMateCode);
		String jkBtnMaterialNm = orderForm.getOptionJacketStandardInfo().getJacketMateMap().get(jkBtnMaterialNmCode);
		order.setJkBtnMaterialNm(jkBtnMaterialBodyNm + " " + jkBtnMaterialNm);
	}
	
//	/**
//	 * オーダーCO内容確認画面標準JACKETのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectStandardMaterialName
//	 * @param order
//	 */
//	public void orderCoStandardJkNameMapping(Map<String, String> selectStandardMaterialName,Order order) {
//
//		// JACKETの胴裏素材Name表示
//		String ojBodyBackMateName = selectStandardMaterialName.get("ojBodyBackMateStkNo");
//		order.setJkInnerBodyClothNm(ojBodyBackMateName);
//		
//		// JACKETの袖裏素材Name表示
//		String ojCuffBackMateName = selectStandardMaterialName.get("ojCuffBackMateStkNo");
//		order.setJkInnerSleeveClothNm(ojCuffBackMateName);
//
//		// JACKETの釦素材Name表示
//		String ojBtnMateName = selectStandardMaterialName.get("ojBtnMateStkNo");
//		order.setJkBtnMaterialNm(ojBtnMateName);
//	}
//	
//	/**
//	 * オーダーCO内容確認画面タキシードJACKETのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectTuxedoMaterialName
//	 * @param order
//	 */
//	public void orderCoTuxedoJkNameMapping(Map<String, String> selectTuxedoMaterialName,Order order) {
//
//		// JACKETの胴裏素材Name表示
//		String tjBodyBackMateName = selectTuxedoMaterialName.get("tjBodyBackMateStkNo");
//		order.setJkInnerBodyClothNm(tjBodyBackMateName);
//		
//		// JACKETの袖裏素材Name表示
//		String tjCuffBackMateName = selectTuxedoMaterialName.get("tjCuffBackMateStkNo");
//		order.setJkInnerSleeveClothNm(tjCuffBackMateName);
//
//		// JACKETの釦素材Name表示
//		String tjBtnMateName = selectTuxedoMaterialName.get("tjBtnMateStkNo");
//		order.setJkBtnMaterialNm(tjBtnMateName);
//	}
//	
//	/**
//	 * オーダーCO内容確認画面ウォッシャブルJACKETのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectWashableMaterialName
//	 * @param order
//	 */
//	public void orderCoWashableJkNameMapping(Map<String, String> selectWashableMaterialName,Order order) {
//
//		// JACKETの胴裏素材Name表示
//		String wjBodyBackMateName = selectWashableMaterialName.get("wjBodyBackMateStkNo");
//		order.setJkInnerBodyClothNm(wjBodyBackMateName);
//		
//		// JACKETの袖裏素材Name表示
//		String wjCuffBackMateName = selectWashableMaterialName.get("wjCuffBackMateStkNo");
//		order.setJkInnerSleeveClothNm(wjCuffBackMateName);
//
//		// JACKETの釦素材Name表示
//		String wjBtnMateName = selectWashableMaterialName.get("wjBtnMateStkNo");
//		order.setJkBtnMaterialNm(wjBtnMateName);
//	}

	/**
	 * オーダー内容確認画面GILETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderGlNameMappingPo(OrderForm orderForm, Order order) {

		// subItemCode
		String giletSubItemCode = "04";

		// GILETの背裏地素材Name表示
		String ogBackLiningMateOptionCode = "00017";
		String ogBackLiningMateCode = orderForm.getOptionGiletStandardInfo().getOgBackLiningMate();
		String ogBackLiningMateStkNoCode = orderForm.getOptionGiletStandardInfo().getOgBackLiningMateStkNo();

		String glBackClothNmCode = giletSubItemCode + ogBackLiningMateOptionCode + ogBackLiningMateCode
				+ ogBackLiningMateStkNoCode;
		String glBackBodyClothNm = orderForm.getOptionGiletStandardInfo().getOgBackLiningMateMap()
				.get(ogBackLiningMateCode);
		String glBackClothNm = orderForm.getOptionGiletStandardInfo().getGiletMateMap().get(glBackClothNmCode);
		order.setGlBackClothNm(glBackBodyClothNm + " " + glBackClothNm);

		// GILETの内側裏地素材Name表示
		String ogInsideLiningMateOptionCode = "00019";
		String ogInsideLiningMateCode = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMate();
		String ogInsideLiningMateStkNoCode = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMateStkNo();

		String glInnnerClothNmCode = giletSubItemCode + ogInsideLiningMateOptionCode + ogInsideLiningMateCode
				+ ogInsideLiningMateStkNoCode;
		String glInnnerBodyClothNm = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMateMap()
				.get(ogInsideLiningMateCode);
		String glInnnerClothNm = orderForm.getOptionGiletStandardInfo().getGiletMateMap().get(glInnnerClothNmCode);
		order.setGlInnnerClothNm(glInnnerBodyClothNm + " " + glInnnerClothNm);

		// GILETのフロント釦Name表示
		String ogFrontBtnMateOptionCode = "00021";
		String ogFrontBtnMateCode = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMate();
		String ogFrontBtnMateStkNoCode = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMateStkNo();

		String glFrtBtnNmCode = giletSubItemCode + ogFrontBtnMateOptionCode + ogFrontBtnMateCode
				+ ogFrontBtnMateStkNoCode;
		String glFrtBodyBtnNm = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMateMap().get(ogFrontBtnMateCode);
		String glFrtBtnNm = orderForm.getOptionGiletStandardInfo().getGiletMateMap().get(glFrtBtnNmCode);
		order.setGlFrtBtnNm(glFrtBodyBtnNm + " " + glFrtBtnNm);
	}
	
//	/**
//	 * オーダーCO内容確認画面標準GILETのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectStandardMaterialName
//	 * @param order
//	 */
//	public void orderCoStandardGlNameMapping(Map<String, String> selectStandardMaterialName,Order order) {
//
//		// GILETの背裏地素材Name表示
//		String ogBackLiningMateName = selectStandardMaterialName.get("ogBackLiningMateStkNo");
//		order.setGlBackClothNm(ogBackLiningMateName);
//
//		// GILETの内側裏地素材Name表示
//		String ogInsideLiningMateName = selectStandardMaterialName.get("ogInsideLiningMateStkNo");
//		order.setGlInnnerClothNm(ogInsideLiningMateName);
//
//		// GILETのフロント釦Name表示
//		String ogFrontBtnMateName = selectStandardMaterialName.get("ogFrontBtnMateStkNo");
//		order.setGlFrtBtnNm(ogFrontBtnMateName);
//	}
//	
//	/**
//	 * オーダーCO内容確認画面タキシードGILETのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectTuxedoMaterialName
//	 * @param order
//	 */
//	public void orderCoTuxedoGlNameMapping(Map<String, String> selectTuxedoMaterialName,Order order) {
//
//		// GILETの背裏地素材Name表示
//		String tgBackLiningMateName = selectTuxedoMaterialName.get("tgBackLiningMateStkNo");
//		order.setGlBackClothNm(tgBackLiningMateName);
//
//		// GILETの内側裏地素材Name表示
//		String tgInsideLiningMateName = selectTuxedoMaterialName.get("tgInsideLiningMateStkNo");
//		order.setGlInnnerClothNm(tgInsideLiningMateName);
//
//		// GILETのフロント釦Name表示
//		String tgFrontBtnMateName = selectTuxedoMaterialName.get("tgFrontBtnMateStkNo");
//		order.setGlFrtBtnNm(tgFrontBtnMateName);
//	}
//	
//	/**
//	 * オーダーCO内容確認画面ウォッシャブルGILETのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectWashableMaterialName
//	 * @param order
//	 */
//	public void orderCoWashableGlNameMapping(Map<String, String> selectWashableMaterialName,Order order) {
//
//		// GILETの背裏地素材Name表示
//		String wgBackLiningMateName = selectWashableMaterialName.get("wgBackLiningMateStkNo");
//		order.setGlBackClothNm(wgBackLiningMateName);
//
//		// GILETの内側裏地素材Name表示
//		String wgInsideLiningMateName = selectWashableMaterialName.get("wgInsideLiningMateStkNo");
//		order.setGlInnnerClothNm(wgInsideLiningMateName);
//
//		// GILETのフロント釦Name表示
//		String wgFrontBtnMateName = selectWashableMaterialName.get("wgFrontBtnMateStkNo");
//		order.setGlFrtBtnNm(wgFrontBtnMateName);
//	}

	/**
	 * オーダー内容確認画面PNATSのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPtNameMappingPo(OrderForm orderForm, Order order) {

		// subItemCode
		String pantsSubItemCode = "03";

		// PANTSの釦素材Name表示
		String opButtonOptionCode = "00033";
		String opButtonCode = orderForm.getOptionPantsStandardInfo().getOpButton();
		String opBtnMateStkNoCode = orderForm.getOptionPantsStandardInfo().getOpBtnMateStkNo();

		String ptBtnMaterialNmCode = pantsSubItemCode + opButtonOptionCode + opButtonCode + opBtnMateStkNoCode;
		String ptBtnMaterialBodyNm = orderForm.getOptionPantsStandardInfo().getOpButtonMap().get(opButtonCode);
		String ptBtnMaterialNm = orderForm.getOptionPantsStandardInfo().getPantsMateMap().get(ptBtnMaterialNmCode);
		order.setPtBtnMaterialNm(ptBtnMaterialBodyNm + " " + ptBtnMaterialNm);
	}
	
//	/**
//	 * オーダーCO内容確認画面標準PNATSのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectStandardMaterialName
//	 * @param order
//	 */
//	public void orderCoStandardPtNameMapping(Map<String, String> selectStandardMaterialName,Order order) {
//
//		// PANTSの釦素材Name表示
//		String opBtnMateName = selectStandardMaterialName.get("opBtnMateStkNo");
//		order.setPtBtnMaterialNm(opBtnMateName);
//	}
//	
//	/**
//	 * オーダーCO内容確認画面タキシードPNATSのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectTuxedoMaterialName
//	 * @param order
//	 */
//	public void orderCoTuxedoPtNameMapping(Map<String, String> selectTuxedoMaterialName,Order order) {
//
//		// PANTSの釦素材Name表示
//		String tpBtnMateName = selectTuxedoMaterialName.get("tpBtnMateStkNo");
//		order.setPtBtnMaterialNm(tpBtnMateName);
//	}
//	
//	/**
//	 * オーダーCO内容確認画面ウォッシャブルPNATSのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectWashableMaterialName
//	 * @param order
//	 */
//	public void orderCoWashablePtNameMapping(Map<String, String> selectWashableMaterialName,Order order) {
//
//		// PANTSの釦素材Name表示
//		String wpBtnMateName = selectWashableMaterialName.get("wpBtnMateStkNo");
//		order.setPtBtnMaterialNm(wpBtnMateName);
//	}
	

	/**
	 * オーダー内容確認画面PNATS2のoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPt2NameMappingPo(OrderForm orderForm, Order order) {

		// subItemCode
		String pants2SubItemCode = "07";

		// PANTS（2本目）の釦素材Name表示
		String op2ButtonOptionCode = "00033";
		String op2ButtonCode = orderForm.getOptionPants2StandardInfo().getOp2Button();
		String op2BtnMateStkNoCode = orderForm.getOptionPants2StandardInfo().getOp2BtnMateStkNo();

		String pt2BtnMaterialNmCode = pants2SubItemCode + op2ButtonOptionCode + op2ButtonCode + op2BtnMateStkNoCode;
		String pt2BtnMaterialBodyNm = orderForm.getOptionPants2StandardInfo().getOp2ButtonMap().get(op2ButtonCode);
		String pt2BtnMaterialNm = orderForm.getOptionPants2StandardInfo().getPants2MateMap().get(pt2BtnMaterialNmCode);
		order.setPt2BtnMaterialNm(pt2BtnMaterialBodyNm + " " + pt2BtnMaterialNm);

	}
	
//	/**
//	 * オーダーCO内容確認画面標準PNATS2のoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectStandardMaterialName
//	 * @param order
//	 */
//	public void orderCoStandardPt2NameMapping(Map<String, String> selectStandardMaterialName,Order order) {
//
//		// PANTS（2本目）の釦素材Name表示
//		String op2BtnMateName = selectStandardMaterialName.get("op2BtnMateStkNo");
//		order.setPt2BtnMaterialNm(op2BtnMateName);
//	}
//	
//	/**
//	 * オーダーCO内容確認画面タキシードPNATS2のoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectTuxedoMaterialName
//	 * @param order
//	 */
//	public void orderCoTuxedoPt2NameMapping(Map<String, String> selectTuxedoMaterialName,Order order) {
//
//		// PANTS（2本目）の釦素材Name表示
//		String tp2BtnMateName = selectTuxedoMaterialName.get("tp2BtnMateStkNo");
//		order.setPt2BtnMaterialNm(tp2BtnMateName);
//	}
//	
//	/**
//	 * オーダーCO内容確認画面ウォッシャブルPNATS2のoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectWashableMaterialName
//	 * @param order
//	 */
//	public void orderCoWashablePt2NameMapping(Map<String, String> selectWashableMaterialName,Order order) {
//
//		// PANTS（2本目）の釦素材Name表示
//		String wp2BtnMateName = selectWashableMaterialName.get("wp2BtnMateStkNo");
//		order.setPt2BtnMaterialNm(wp2BtnMateName);
//	}
//	
//	/**
//	 * オーダーCO内容確認画面標準COATのoption_branch_detail_nameとorderの対応フィールドのマッピング
//	 * 
//	 * @param selectStandardMaterialName
//	 * @param order
//	 */
//	public void orderCoStandardCtNameMapping(Map<String, String> selectStandardMaterialName,Order order) {
//
//		// COATの胴裏地Name表示
//		String ocBodyBackMateName = selectStandardMaterialName.get("ocBodyBackMateStkNo");
//		order.setCtInnerBodyClothNm(ocBodyBackMateName);
//
//		// COATの袖裏地Name表示
//		String ocCuffBackMateName = selectStandardMaterialName.get("ocCuffBackMateStkNo");
//		order.setCtInnerSleeveClothNm(ocCuffBackMateName);
//				
//		// COATの釦素材Name表示
//		String ocFrontBtnMateName = selectStandardMaterialName.get("ocFrontBtnMateStkNo");
//		order.setCtBtnMaterialNm(ocFrontBtnMateName);
//	}

	/**
	 * JACKETの上代価額をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @return
	 */
	public void orderJacketPrice(OrderForm orderForm, Order order) {

		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_JACKET.getValue();
		String branchModelCode = orderForm.getOptionJacketStandardInfo().getOjJacketModel();

		JacketOptionStandardPriceEnum[] priceEnum = JacketOptionStandardPriceEnum.values();

		for (JacketOptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValue();
			String valueTwo = price.getValue2();
			String valueThree = price.getValue3();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object result = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					result = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketStandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + result;

				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + result + resultTwo;

				List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
				for (OrderCodePrice orderCodePrice : orderCodePriceList) {
					if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { 0 };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice()) };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null
									&& orderCodePrice.getOrderBranchDetailDoublePrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Object[] argsDetailValue = { 0 };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailDoublePrice());
								Object[] argsDetailValue = { OrderDoublePrice };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							}
							break;
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
					} else {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchPrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { 0 };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchPrice()) };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchPrice() == null
									&& orderCodePrice.getOrderBranchDetailPrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Object[] argsDetailValue = { 0 };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
								Object[] argsDetailValue = { OrderDoublePrice };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							}
							break;
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * GILETの上代価額をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderGiletPrice(OrderForm orderForm, Order order) {

		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_GILET.getValue();
		String branchModelCode = orderForm.getOptionGiletStandardInfo().getOgGiletModel();

		GiletOptionStandardPriceEnum[] priceEnum = GiletOptionStandardPriceEnum.values();
		for (GiletOptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletStandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + resultOne;
				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + resultOne + resultTwo;

				List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
				for (OrderCodePrice orderCodePrice : orderCodePriceList) {
					if ("CH14-D".equals(orderForm.getOptionGiletStandardInfo().getOgGiletModel())) {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { 0 };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice()) };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null
									&& orderCodePrice.getOrderBranchDetailDoublePrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Object[] argsDetailValue = { 0 };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailDoublePrice());
								Object[] argsDetailValue = { OrderDoublePrice };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							}
							break;
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
					} else {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchPrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { 0 };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchPrice()) };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchPrice() == null
									&& orderCodePrice.getOrderBranchDetailPrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Object[] argsDetailValue = { 0 };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
								Object[] argsDetailValue = { OrderDoublePrice };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							}
							break;
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTSの上代価額をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPantsPrice(OrderForm orderForm, Order order) {

		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS.getValue();
		String branchModelCode = orderForm.getOptionPantsStandardInfo().getOpPantsModel();

		PantsOptionStandardPriceEnum[] priceEnum = PantsOptionStandardPriceEnum.values();
		for (PantsOptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPantsStandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + resultOne;
				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + resultOne + resultTwo;

				List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
				for (OrderCodePrice orderCodePrice : orderCodePriceList) {
					if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderCodePrice.getOrderDetailKeyCode() == null) {
						if (orderCodePrice.getOrderBranchPrice() == null) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethod = getMethod(cls, valueThree);
							Object[] argsValue = { 0 };
							if (myMethod != null) {
								ReflectionUtils.invoke(myMethod, order, argsValue);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethod = getMethod(cls, valueThree);
							Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchPrice()) };
							if (myMethod != null) {
								ReflectionUtils.invoke(myMethod, order, argsValue);
							}
						}
						break;
					} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if (orderCodePrice.getOrderBranchPrice() == null
								&& orderCodePrice.getOrderBranchDetailPrice() == null) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
									+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
							Object[] argsDetailValue = { OrderDoublePrice };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodT = getMethod(cls, valueThree);
						Object[] argsDetailValue = { 0 };
						if (myMethodT != null) {
							ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTS2の上代価額をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPants2Price(OrderForm orderForm, Order order) {

		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS2.getValue();
		String branchModelCode = orderForm.getOptionPants2StandardInfo().getOp2PantsModel();

		Pants2OptionStandardPriceEnum[] priceEnum = Pants2OptionStandardPriceEnum.values();
		for (Pants2OptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2StandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPants2StandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + resultOne;
				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + resultOne + resultTwo;

				List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
				for (OrderCodePrice orderCodePrice : orderCodePriceList) {
					if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderCodePrice.getOrderDetailKeyCode() == null) {
						if (orderCodePrice.getOrderBranchPrice() == null) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethod = getMethod(cls, valueThree);
							Object[] argsValue = { 0 };
							if (myMethod != null) {
								ReflectionUtils.invoke(myMethod, order, argsValue);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethod = getMethod(cls, valueThree);
							Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchPrice()) };
							if (myMethod != null) {
								ReflectionUtils.invoke(myMethod, order, argsValue);
							}
						}
						break;
					} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if (orderCodePrice.getOrderBranchPrice() == null
								&& orderCodePrice.getOrderBranchDetailPrice() == null) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
									+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
							Object[] argsDetailValue = { OrderDoublePrice };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodT = getMethod(cls, valueThree);
						Object[] argsDetailValue = { 0 };
						if (myMethodT != null) {
							ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * オーダーのitemCodeとsubItemCode
	 * 
	 * @param orderForm
	 * @param jkSubItemCode
	 * @param gtSubItemCode
	 * @param ptSubItemCode
	 * @param pt2SubItemCode
	 * @return
	 */
	public Map<String, String> subItemCodeValue(OrderForm orderForm, String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode) {
		String itemCode = orderForm.getProductItem();
		String productIs3Piece = orderForm.getProductIs3Piece();
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		Map<String, String> valueSubItemCodeMap = new HashMap<String, String>();
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";
		// 01:SUIT
		String suitCode = "01";
		// 02:JACKET
		String jacketCode = "02";
		// 03:PANTS
		String pantsCode = "03";
		// 04:GILET
		String giletCode = "04";
		// 07:PANTS2
		String pants2Code = "07";
		if (itemCode.equals(suitCode)) {
			if (productIs3Piece.equals(productYes) && productSparePantsClass.equals(productYes)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = giletCode;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = pants2Code;
			} else if (productIs3Piece.equals(productYes) && productSparePantsClass.equals(productNo)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = giletCode;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = null;
			} else if (productIs3Piece.equals(productNo) && productSparePantsClass.equals(productYes)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = null;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = pants2Code;
			} else if (productIs3Piece.equals(productNo) && productSparePantsClass.equals(productNo)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = null;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = null;
			}
		} else if (itemCode.equals(jacketCode)) {
			jkSubItemCode = jacketCode;
			gtSubItemCode = null;
			ptSubItemCode = null;
			pt2SubItemCode = null;
		} else if (itemCode.equals(pantsCode)) {
			jkSubItemCode = null;
			gtSubItemCode = null;
			ptSubItemCode = pantsCode;
			pt2SubItemCode = null;
		} else if (itemCode.equals(giletCode)) {
			jkSubItemCode = null;
			gtSubItemCode = giletCode;
			ptSubItemCode = null;
			pt2SubItemCode = null;
		}
		valueSubItemCodeMap.put("jkSubItemCode", jkSubItemCode);
		valueSubItemCodeMap.put("gtSubItemCode", gtSubItemCode);
		valueSubItemCodeMap.put("ptSubItemCode", ptSubItemCode);
		valueSubItemCodeMap.put("pt2SubItemCode", pt2SubItemCode);
		return valueSubItemCodeMap;
	}

	/**
	 * オーダーのitemCodeとsubItemCode
	 * 
	 * @param order
	 * @param jkSubItemCode
	 * @param gtSubItemCode
	 * @param ptSubItemCode
	 * @param pt2SubItemCode
	 * @return
	 */
	public Map<String, String> subItemCodeValue(Order order, String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode) {
		String itemCode = order.getProductItem();
		String productIs3Piece = order.getProductIs3piece();
		String productSparePantsClass = order.getProductSparePantsClass();
		Map<String, String> valueSubItemCodeMap = new HashMap<String, String>();
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";
		// 01:SUIT
		String suitCode = "01";
		// 02:JACKET
		String jacketCode = "02";
		// 03:PANTS
		String pantsCode = "03";
		// 04:GILET
		String giletCode = "04";
		// 07:PANTS2
		String pants2Code = "07";
		if (itemCode.equals(suitCode)) {
			if (productIs3Piece.equals(productYes) && productSparePantsClass.equals(productYes)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = giletCode;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = pants2Code;
			} else if (productIs3Piece.equals(productYes) && productSparePantsClass.equals(productNo)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = giletCode;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = null;
			} else if (productIs3Piece.equals(productNo) && productSparePantsClass.equals(productYes)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = null;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = pants2Code;
			} else if (productIs3Piece.equals(productNo) && productSparePantsClass.equals(productNo)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = null;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = null;
			}
		} else if (itemCode.equals(jacketCode)) {
			jkSubItemCode = jacketCode;
			gtSubItemCode = null;
			ptSubItemCode = null;
			pt2SubItemCode = null;
		} else if (itemCode.equals(pantsCode)) {
			jkSubItemCode = null;
			gtSubItemCode = null;
			ptSubItemCode = pantsCode;
			pt2SubItemCode = null;
		} else if (itemCode.equals(giletCode)) {
			jkSubItemCode = null;
			gtSubItemCode = giletCode;
			ptSubItemCode = null;
			pt2SubItemCode = null;
		}
		valueSubItemCodeMap.put("jkSubItemCode", jkSubItemCode);
		valueSubItemCodeMap.put("gtSubItemCode", gtSubItemCode);
		valueSubItemCodeMap.put("ptSubItemCode", ptSubItemCode);
		valueSubItemCodeMap.put("pt2SubItemCode", pt2SubItemCode);
		return valueSubItemCodeMap;
	}

	/**
	 * 基本工賃価格の取得
	 * 
	 * @param itemCode
	 * @param subItemCode
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public BigDecimal getWage(String itemCode, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String keyItemCode = itemCode;
		BigDecimal mbwWage = null;
		for (NextGenerationPrice basicNextGenerationPrice : basicNextGenerationPriceList) {
			if (keyItemCode.equals(basicNextGenerationPrice.getKeyItemCode().substring(0, 2))) {
				mbwWage = basicNextGenerationPrice.getMbwWage();
				break;
			} else {
				mbwWage = new BigDecimal(0.0);
			}
		}
		return mbwWage;
	}

	/**
	 * ダブルブレスト工賃価格の取得
	 * 
	 * @param itemCode
	 * @param subItemCode
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public BigDecimal getDoubleWage(String itemCode, String subItemCode,
			List<NextGenerationPrice> basicNextGenerationPriceList) {
		String keyItemCode = itemCode + subItemCode;
		BigDecimal mdbwWage = null;
		for (NextGenerationPrice basicNextGenerationPrice : basicNextGenerationPriceList) {
			if (keyItemCode.equals(basicNextGenerationPrice.getKeyItemCode())) {
				mdbwWage = basicNextGenerationPrice.getMdbwWage();
				break;
			} else {
				mdbwWage = new BigDecimal(0.0);
			}
		}
		return mdbwWage;
	}

	/**
	 * 基本付属価格の取得
	 * 
	 * @param itemCode
	 * @param subItemCode
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public Integer getPrice(String itemCode, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String keyItemCode = itemCode;
		Integer mnapPrice = null;
		for (NextGenerationPrice basicNextGenerationPrice : basicNextGenerationPriceList) {
			if (keyItemCode.equals(basicNextGenerationPrice.getKeyItemCode().substring(0, 2))) {
				mnapPrice = basicNextGenerationPrice.getMnapPrice();
				break;
			} else {
				mnapPrice = 0;
			}
		}
		return mnapPrice;
	}

	/**
	 * ダブルブレスト付属価格
	 * 
	 * @param itemCode
	 * @param subItemCode
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public Integer getDoublePrice(String itemCode, String subItemCode,
			List<NextGenerationPrice> basicNextGenerationPriceList) {
		String keyItemCode = itemCode + subItemCode;
		Integer mdbapPrice = null;
		for (NextGenerationPrice basicNextGenerationPrice : basicNextGenerationPriceList) {
			if (keyItemCode.equals(basicNextGenerationPrice.getKeyItemCode())) {
				mdbapPrice = basicNextGenerationPrice.getMdbapPrice();
				break;
			} else {
				mdbapPrice = 0;
			}
		}
		return mdbapPrice;
	}

	/**
	 * JACKET_下代工賃とJACKET_下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param optionNextGenerationPriceList
	 * @param basicNextGenerationPriceList
	 */
	public void getJkNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> optionNextGenerationPriceList,
			List<NextGenerationPrice> basicNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_JACKET.getValue();

		JacketOptionStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = JacketOptionStandardNextGenerationPriceEnum
				.values();
		for (JacketOptionStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Object[] args = {};
				Object resultOne = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketStandardInfo(), args);
				}

				String keyCode = itemCode + subItemCode + key + resultOne;

				for (NextGenerationPrice jkNextGenerationPrice : optionNextGenerationPriceList) {
					if (keyCode.equals(jkNextGenerationPrice.getKeyCode())) {
						// フロント釦数はダブル6つボタンの場合、該当itemはダブル
						if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodTwo = getMethod(cls, valueTwo);
							Method myMethodThree = getMethod(cls, valueThree);
							// オプション工賃
							BigDecimal optionWage = jkNextGenerationPrice.getMowWage();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属
							Integer optionDoublePrice = jkNextGenerationPrice.getMoapDoublePrice();
							Integer nextGenerationPriceValue = optionDoublePrice;
							Object[] argsValueTwo = { nextGenerationWageValue };
							Object[] argsValueThree = { nextGenerationPriceValue };
							if (myMethodTwo != null) {
								ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
							}
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
						}
						// 該当itemはダブル以外の場合
						else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodTwo = getMethod(cls, valueTwo);
							Method myMethodThree = getMethod(cls, valueThree);
							// オプション工賃
							BigDecimal optionWage = jkNextGenerationPrice.getMowWage();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属
							Integer optionPrice = jkNextGenerationPrice.getMoapPrice();
							Integer nextGenerationPriceValue = optionPrice;
							Object[] argsValueTwo = { nextGenerationWageValue };
							Object[] argsValueThree = { nextGenerationPriceValue };
							if (myMethodTwo != null) {
								ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
							}
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						Object[] argsValueTwo = { new BigDecimal(0.0) };
						Object[] argsValueThree = { 0 };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * GILET_下代工賃とGILET_下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param optionNextGenerationPriceList
	 * @param basicNextGenerationPriceList
	 */
	public void getGlNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> optionNextGenerationPriceList,
			List<NextGenerationPrice> basicNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_GILET.getValue();

		GiletOptionStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = GiletOptionStandardNextGenerationPriceEnum
				.values();
		for (GiletOptionStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Object[] args = {};
				Object resultOne = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletStandardInfo(), args);
				}

				String keyCode = itemCode + subItemCode + key + resultOne;

				for (NextGenerationPrice glNextGenerationPrice : optionNextGenerationPriceList) {
					if (keyCode.equals(glNextGenerationPrice.getKeyCode())) {
						if ("CH14-D".equals(orderForm.getOptionGiletStandardInfo().getOgGiletModel())) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodTwo = getMethod(cls, valueTwo);
							Method myMethodThree = getMethod(cls, valueThree);
							// オプション工賃
							BigDecimal optionWage = glNextGenerationPrice.getMowWage();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属
							Integer optionDoublePrice = glNextGenerationPrice.getMoapDoublePrice();
							Integer nextGenerationPriceValue = optionDoublePrice;
							Object[] argsValueTwo = { nextGenerationWageValue };
							Object[] argsValueThree = { nextGenerationPriceValue };
							if (myMethodTwo != null) {
								ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
							}
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodTwo = getMethod(cls, valueTwo);
							Method myMethodThree = getMethod(cls, valueThree);
							// オプション工賃
							BigDecimal optionWage = glNextGenerationPrice.getMowWage();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属
							Integer optionPrice = glNextGenerationPrice.getMoapPrice();
							Integer nextGenerationPriceValue = optionPrice;
							Object[] argsValueTwo = { nextGenerationWageValue };
							Object[] argsValueThree = { nextGenerationPriceValue };
							if (myMethodTwo != null) {
								ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
							}
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						Object[] argsValueTwo = { new BigDecimal(0.0) };
						Object[] argsValueThree = { 0 };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTS_下代工賃とPANTS_下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param optionNextGenerationPriceList
	 * @param basicNextGenerationPriceList
	 */
	public void getPtNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> optionNextGenerationPriceList,
			List<NextGenerationPrice> basicNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS.getValue();

		PantsOptionStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = PantsOptionStandardNextGenerationPriceEnum
				.values();
		for (PantsOptionStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Object[] args = {};
				Object resultOne = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsStandardInfo(), args);
				}

				String keyCode = itemCode + subItemCode + key + resultOne;

				for (NextGenerationPrice ptNextGenerationPrice : optionNextGenerationPriceList) {
					if (keyCode.equals(ptNextGenerationPrice.getKeyCode())) {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						// オプション工賃
						BigDecimal optionWage = ptNextGenerationPrice.getMowWage();
						BigDecimal nextGenerationWageValue = optionWage;
						// オプション付属
						Integer optionPrice = ptNextGenerationPrice.getMoapPrice();
						Integer nextGenerationPriceValue = optionPrice;
						Object[] argsValueTwo = { nextGenerationWageValue };
						Object[] argsValueThree = { nextGenerationPriceValue };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						Object[] argsValueTwo = { new BigDecimal(0.0) };
						Object[] argsValueThree = { 0 };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTS2_下代工賃とPANTS2_下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param optionNextGenerationPriceList
	 * @param basicNextGenerationPriceList
	 * 
	 */
	public void getPt2NextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> optionNextGenerationPriceList,
			List<NextGenerationPrice> basicNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS2.getValue();

		Pants2OptionStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = Pants2OptionStandardNextGenerationPriceEnum
				.values();
		for (Pants2OptionStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Object[] args = {};
				Object resultOne = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2StandardInfo(), args);
				}

				String keyCode = itemCode + subItemCode + key + resultOne;

				for (NextGenerationPrice pt2NextGenerationPrice : optionNextGenerationPriceList) {
					if (keyCode.equals(pt2NextGenerationPrice.getKeyCode())) {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						// オプション工賃
						BigDecimal optionWage = pt2NextGenerationPrice.getMowWage();
						BigDecimal nextGenerationWageValue = optionWage;
						// オプション付属
						Integer optionPrice = pt2NextGenerationPrice.getMoapPrice();
						Integer nextGenerationPriceValue = optionPrice;
						Object[] argsValueTwo = { nextGenerationWageValue };
						Object[] argsValueThree = { nextGenerationPriceValue };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						Object[] argsValueTwo = { new BigDecimal(0.0) };
						Object[] argsValueThree = { 0 };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * JACKETのオプション付属詳細価格
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param detailNextGenerationPriceList
	 */
	public void getJkDetailNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> detailNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_JACKET.getValue();

		JacketOptionDetailStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = JacketOptionDetailStandardNextGenerationPriceEnum
				.values();

		for (JacketOptionDetailStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();
			String valueFour = nextGenerationPrice.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketStandardInfo(), args);
				}

				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketStandardInfo(), argsTwo);
				}

				String keyDetailCode = itemCode + subItemCode + key + resultOne + resultTwo;
				for (NextGenerationPrice detailNextGenerationPrice : detailNextGenerationPriceList) {
					if (keyDetailCode.equals(detailNextGenerationPrice.getKeyDetailCode())) {
						// フロント釦数はダブル6つボタンの場合、該当itemはダブル
						if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodThree = getMethod(cls, valueThree);
							Method myMethodFour = getMethod(cls, valueFour);
							// オプション工賃
							BigDecimal optionWage = detailNextGenerationPrice.getMowWageT();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属 + オプション付属詳細
							Integer optionDoublePrice = detailNextGenerationPrice.getMoapDoublePriceT();
							Integer optionDetailDoublePrice = detailNextGenerationPrice.getMoadpDoublePrice();
							Integer nextGenerationPriceValue = optionDoublePrice + optionDetailDoublePrice;
							Object[] argsValueThree = { nextGenerationWageValue };
							Object[] argsValueFour = { nextGenerationPriceValue };
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
							if (myMethodFour != null) {
								ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodThree = getMethod(cls, valueThree);
							Method myMethodFour = getMethod(cls, valueFour);
							// オプション工賃
							BigDecimal optionWage = detailNextGenerationPrice.getMowWageT();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属 + オプション付属詳細
							Integer optionPrice = detailNextGenerationPrice.getMoapPriceT();
							Integer optionDetailPrice = detailNextGenerationPrice.getMoadpPrice();
							Integer nextGenerationPriceValue = optionPrice + optionDetailPrice;
							Object[] argsValueThree = { nextGenerationWageValue };
							Object[] argsValueFour = { nextGenerationPriceValue };
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
							if (myMethodFour != null) {
								ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodThree = getMethod(cls, valueThree);
						Method myMethodFour = getMethod(cls, valueFour);
						Object[] argsValueThree = { new BigDecimal(0.0) };
						Object[] argsValueFour = { 0 };
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
						if (myMethodFour != null) {
							ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
						}
					}
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * GILETのオプション付属詳細価格
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param detailNextGenerationPriceList
	 */
	public void getGlDetailNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> detailNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_GILET.getValue();

		GiletOptionDetailStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = GiletOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (GiletOptionDetailStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {
			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();
			String valueFour = nextGenerationPrice.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletStandardInfo(), args);
				}

				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletStandardInfo(), argsTwo);
				}

				String keyDetailCode = itemCode + subItemCode + key + resultOne + resultTwo;
				for (NextGenerationPrice detailNextGenerationPrice : detailNextGenerationPriceList) {
					if (keyDetailCode.equals(detailNextGenerationPrice.getKeyDetailCode())) {
						// GILETモデルはCH14-Dの場合、該当itemはダブル
						if ("CH14-D".equals(orderForm.getOptionGiletStandardInfo().getOgGiletModel())) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodThree = getMethod(cls, valueThree);
							Method myMethodFour = getMethod(cls, valueFour);
							// オプション工賃
							BigDecimal optionWage = detailNextGenerationPrice.getMowWageT();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属 + オプション付属詳細
							Integer optionDoublePrice = detailNextGenerationPrice.getMoapDoublePriceT();
							Integer optionDetailDoublePrice = detailNextGenerationPrice.getMoadpDoublePrice();
							Integer nextGenerationPriceValue = optionDoublePrice + optionDetailDoublePrice;
							Object[] argsValueThree = { nextGenerationWageValue };
							Object[] argsValueFour = { nextGenerationPriceValue };
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
							if (myMethodFour != null) {
								ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodThree = getMethod(cls, valueThree);
							Method myMethodFour = getMethod(cls, valueFour);
							// オプション工賃
							BigDecimal optionWage = detailNextGenerationPrice.getMowWageT();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属 + オプション付属詳細
							Integer optionPrice = detailNextGenerationPrice.getMoapPriceT();
							Integer optionDetailPrice = detailNextGenerationPrice.getMoadpPrice();
							Integer nextGenerationPriceValue = optionPrice + optionDetailPrice;
							Object[] argsValueThree = { nextGenerationWageValue };
							Object[] argsValueFour = { nextGenerationPriceValue };
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
							if (myMethodFour != null) {
								ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodThree = getMethod(cls, valueThree);
						Method myMethodFour = getMethod(cls, valueFour);
						Object[] argsValueThree = { new BigDecimal(0.0) };
						Object[] argsValueFour = { 0 };
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
						if (myMethodFour != null) {
							ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
						}
					}
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTSのオプション付属詳細価格
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param detailNextGenerationPriceList
	 */
	public void getPtDetailNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> detailNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();

		String optionCode = "00033";
		String optionBranchCode = orderForm.getOptionPantsStandardInfo().getOpButton();
		String optionBranchDetailCode = orderForm.getOptionPantsStandardInfo().getOpBtnMateStkNo();

		String keyDetailCode = itemCode + subItemCode + optionCode + optionBranchCode + optionBranchDetailCode;
		for (NextGenerationPrice detailNextGenerationPrice : detailNextGenerationPriceList) {
			if (keyDetailCode.equals(detailNextGenerationPrice.getKeyDetailCode())) {
				// オプション工賃
				BigDecimal mowWageT = detailNextGenerationPrice.getMowWageT();
				BigDecimal nextGenerationWageValue = mowWageT;
				// オプション付属 + オプション付属詳細
				Integer moapPriceT = detailNextGenerationPrice.getMoapPriceT();
				Integer moadpPrice = detailNextGenerationPrice.getMoadpPrice();
				Integer nextGenerationPriceValue = moapPriceT + moadpPrice;
				order.setPtBtnMaterialWsWage(nextGenerationWageValue);
				order.setPtBtnMaterialWsPrice(nextGenerationPriceValue);
				break;
			} else {
				order.setPtBtnMaterialWsWage(new BigDecimal(0.0));
				order.setPtBtnMaterialWsPrice(0);
			}
		}
	}

	/**
	 * PANTS2のオプション付属詳細価格
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param detailNextGenerationPriceList
	 */
	public void getPt2DetailNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> detailNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		String optionCode = "00033";
		String optionBranchCode = orderForm.getOptionPants2StandardInfo().getOp2Button();
		String optionBranchDetailCode = orderForm.getOptionPants2StandardInfo().getOp2BtnMateStkNo();

		String keyDetailCode = itemCode + subItemCode + optionCode + optionBranchCode + optionBranchDetailCode;
		for (NextGenerationPrice detailNextGenerationPrice : detailNextGenerationPriceList) {
			if (keyDetailCode.equals(detailNextGenerationPrice.getKeyDetailCode())) {
				// オプション工賃
				BigDecimal mowWageT = detailNextGenerationPrice.getMowWageT();
				BigDecimal nextGenerationWageValue = mowWageT;
				// オプション付属 + オプション付属詳細
				Integer moapPriceT = detailNextGenerationPrice.getMoapPriceT();
				Integer moadpPrice = detailNextGenerationPrice.getMoadpPrice();
				Integer nextGenerationPriceValue = moapPriceT + moadpPrice;
				order.setPt2BtnMaterialWsWage(nextGenerationWageValue);
				order.setPt2BtnMaterialWsPrice(nextGenerationPriceValue);
				break;
			} else {
				order.setPt2BtnMaterialWsWage(new BigDecimal(0.0));
				order.setPt2BtnMaterialWsPrice(0);
			}
		}
	}

	/**
	 * ３Pieceの上代をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * 
	 */
	public void order3PiecePrice(OrderForm orderForm, Order order,Map<String, Integer> retailPriceRelatedMap) {
		
		String productIs3Piece = orderForm.getProductIs3Piece();
		String productIs3PieceYes = "0009902";
		if(productIs3PieceYes.equals(productIs3Piece)) {
			Integer single3PieceRetailPrice = retailPriceRelatedMap.get("price3Piece");
			order.setProductIs3pieceRtPrice(single3PieceRetailPrice);
		}
		else {
			Integer price = 0;
			order.setProductIs3pieceRtPrice(price);
		}
		
	}

	/**
	 * スペアパンツの上代をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderSparePantsPrice(OrderForm orderForm, Order order,Map<String, Integer> retailPriceRelatedMap) {
		
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		String productSparePantsClassYes = "0009902";
		
		if(productSparePantsClassYes.equals(productSparePantsClass)) {
			Integer sparePantsPrice = retailPriceRelatedMap.get("sparePants");
			order.setProductSparePantsRtPrice(sparePantsPrice);
		}
		else {
			Integer price = 0;
			order.setProductSparePantsRtPrice(price);
		}
	}

	/**
	 * 商品情報_３Piece_下代工賃と下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param optionNextGenerationPriceList
	 */
	public void getGl3PieceNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> optionNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();

		String optionCode = "00099";
		String optionBranchCode = orderForm.getProductIs3Piece();

		String keyCode = itemCode + subItemCode + optionCode + optionBranchCode;
		for (NextGenerationPrice optionNextGenerationPrice : optionNextGenerationPriceList) {
			if (keyCode.equals(optionNextGenerationPrice.getKeyCode())) {
				if ("CH14-D".equals(orderForm.getOptionGiletStandardInfo().getOgGiletModel())) {
					BigDecimal mowWage = optionNextGenerationPrice.getMowWage();
					BigDecimal nextGenerationWageValue = mowWage;

					Integer moapDoublePrice = optionNextGenerationPrice.getMoapDoublePrice();
					Integer nextGenerationPriceValue = moapDoublePrice;
					order.setProductIs3pieceWsWage(nextGenerationWageValue);
					order.setProductIs3pieceWsPrice(nextGenerationPriceValue);
				} else {
					Integer moapPrice = optionNextGenerationPrice.getMoapPrice();
					BigDecimal mowWage = optionNextGenerationPrice.getMowWage();
					BigDecimal nextGenerationWageValue = mowWage;
					Integer nextGenerationPriceValue = moapPrice;
					order.setProductIs3pieceWsWage(nextGenerationWageValue);
					order.setProductIs3pieceWsPrice(nextGenerationPriceValue);
				}
				break;
			} else {
				order.setProductIs3pieceWsWage(new BigDecimal(0.0));
				order.setProductIs3pieceWsPrice(0);
			}
		}
	}

	/**
	 * 商品情報_スペアパンツ_下代工賃と下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param optionNextGenerationPriceList
	 */
	public void getSparePantsNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> optionNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();

		String optionCode = "00099";
		String optionBranchCode = orderForm.getProductSparePantsClass();

		String keyCode = itemCode + subItemCode + optionCode + optionBranchCode;
		for (NextGenerationPrice optionNextGenerationPrice : optionNextGenerationPriceList) {
			if (keyCode.equals(optionNextGenerationPrice.getKeyCode())) {

				BigDecimal mowWage = optionNextGenerationPrice.getMowWage();
				BigDecimal nextGenerationWageValue = mowWage;

				Integer moapPrice = optionNextGenerationPrice.getMoapPrice();
				Integer nextGenerationPriceValue = moapPrice;
				order.setProductSparePantsWsWage(nextGenerationWageValue);
				order.setProductSparePantsWsPrice(nextGenerationPriceValue);
				break;
			} else {
				order.setProductSparePantsWsWage(new BigDecimal(0.0));
				order.setProductSparePantsWsPrice(0);
			}
		}
	}

	/**
	 * 商品情報_ITEM表示用をデータベースに入力する
	 * 
	 * @param
	 *
	 */
	public void setProductItemDisplayCode(OrderForm orderForm, Order order) {
		// 商品情報_ITEM
		String itemCode = orderForm.getProductItem();
		// 商品情報_３Piece
		String product3Piece = orderForm.getProductIs3Piece();
		// 商品情報_スペアパンツ
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		// 01:SUIT
		String suitCode = "01";
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";
		// SUIT(2p)：21
		String item2p = "21";
		// SUIT(2pp)：22
		String item2pp = "22";
		// SUIT(3p)：31
		String item3p = "31";
		// SUIT(3p2pp)：32
		String item3p2pp = "32";
		if (itemCode.equals(suitCode)) {
			if (productYes.equals(product3Piece) && productYes.equals(productSparePantsClass)) {
				order.setProductItemDisplaycode(item3p2pp);
			} else if (productYes.equals(product3Piece) && productNo.equals(productSparePantsClass)) {
				order.setProductItemDisplaycode(item3p);
			} else if (productNo.equals(product3Piece) && productYes.equals(productSparePantsClass)) {
				order.setProductItemDisplaycode(item2pp);
			} else if (productNo.equals(product3Piece) && productNo.equals(productSparePantsClass)) {
				order.setProductItemDisplaycode(item2p);
			}
		} else {
			order.setProductItemDisplaycode(null);
		}
	}

	/**
	 * Integerの変換
	 * 
	 * @param result
	 * @return
	 */
	public Integer commonTransfer(Object result) {
		Integer resultReturn = 0;
		if (result == null || "".equals(result)) {
			return resultReturn;
		}
		resultReturn = Integer.parseInt(result.toString());
		return resultReturn;
	}

	/**
	 * BigDecimalの変換
	 * 
	 * @param result
	 * @return
	 */
	public BigDecimal BigDecimalCommonTransfer(Object result) {
		BigDecimal resultReturn = new BigDecimal(0.0);
		if (result == null || "".equals(result)) {
			return resultReturn;
		}
		resultReturn = new BigDecimal(result.toString());
		return resultReturn;
	}

	/**
	 * JACKET_下代工賃合計
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal jkNextGenerationWageTotal(Order order) {

		BigDecimal jkWageTotal = new BigDecimal(0.0);
		JacketOptionStandardNextGenerationPriceEnum[] priceEnum = JacketOptionStandardNextGenerationPriceEnum.values();
		for (JacketOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFour = price.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFour = getMethod(cls, valueFour);
				Object[] args = {};
				Object resultFour = null;

				if (myMethodFour != null) {
					resultFour = ReflectionUtils.invoke(myMethodFour, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFour);
				jkWageTotal = result.add(jkWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return jkWageTotal;
	}

	/**
	 * JACKET_下代付属合計
	 * 
	 * @param order
	 * @return
	 */
	public Integer jkNextGenerationPriceTotal(Order order) {

		Integer jkPriceTotal = 0;
		JacketOptionStandardNextGenerationPriceEnum[] priceEnum = JacketOptionStandardNextGenerationPriceEnum.values();
		for (JacketOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] argsTwo = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, argsTwo);
				}

				Integer result = commonTransfer(resultFive);
				jkPriceTotal = result + jkPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return jkPriceTotal;
	}

	/**
	 * JACKET_下代工賃合計 (オプション付属詳細価格を含む)
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal jkNextGenerationDetailWageTotal(Order order) {

		BigDecimal jkDetailWageTotal = new BigDecimal(0.0);
		JacketOptionDetailStandardNextGenerationPriceEnum[] priceEnum = JacketOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (JacketOptionDetailStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFive);
				jkDetailWageTotal = result.add(jkDetailWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return jkDetailWageTotal;
	}

	/**
	 * JACKET_下代付属合計 (オプション付属詳細価格を含む)
	 * 
	 * @param order
	 * @return
	 */
	public Integer jkNextGenerationDetailPriceTotal(Order order) {

		Integer jkDetailPriceTotal = 0;
		JacketOptionDetailStandardNextGenerationPriceEnum[] priceEnum = JacketOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (JacketOptionDetailStandardNextGenerationPriceEnum price : priceEnum) {

			String valueSix = price.getValueSix();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodSix = getMethod(cls, valueSix);
				Object[] args = {};
				Object resultSix = null;

				if (myMethodSix != null) {
					resultSix = ReflectionUtils.invoke(myMethodSix, order, args);
				}

				Integer result = commonTransfer(resultSix);
				jkDetailPriceTotal = result + jkDetailPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return jkDetailPriceTotal;
	}

	/**
	 * PANTS_下代工賃合計
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal ptNextGenerationWageTotal(Order order) {

		BigDecimal ptWageTotal = new BigDecimal(0.0);
		PantsOptionStandardNextGenerationPriceEnum[] priceEnum = PantsOptionStandardNextGenerationPriceEnum.values();
		for (PantsOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFour = price.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFour = getMethod(cls, valueFour);
				Object[] args = {};
				Object resultFour = null;

				if (myMethodFour != null) {
					resultFour = ReflectionUtils.invoke(myMethodFour, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFour);
				ptWageTotal = result.add(ptWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		BigDecimal ptBtnMaterialWsWage;
		if (order.getPtBtnMaterialWsWage() == null) {
			ptBtnMaterialWsWage = new BigDecimal(0.0);
			ptWageTotal = ptBtnMaterialWsWage.add(ptWageTotal);
		} else {
			ptBtnMaterialWsWage = order.getPtBtnMaterialWsWage();
			ptWageTotal = ptBtnMaterialWsWage.add(ptWageTotal);
		}
		return ptWageTotal;
	}

	/**
	 * PANTS_下代付属合計
	 * 
	 * @param order
	 * @return
	 */
	public Integer ptNextGenerationPriceTotal(Order order) {

		Integer ptPriceTotal = 0;
		PantsOptionStandardNextGenerationPriceEnum[] priceEnum = PantsOptionStandardNextGenerationPriceEnum.values();
		for (PantsOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				Integer result = commonTransfer(resultFive);
				ptPriceTotal = result + ptPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		Integer ptBtnMaterialWsPrice;
		if (order.getPtBtnMaterialWsPrice() == null) {
			ptBtnMaterialWsPrice = 0;
			ptPriceTotal = ptBtnMaterialWsPrice + ptPriceTotal;
		} else {
			ptBtnMaterialWsPrice = order.getPtBtnMaterialWsPrice();
			ptPriceTotal = ptBtnMaterialWsPrice + ptPriceTotal;
		}
		return ptPriceTotal;
	}

	/**
	 * GILET_下代工賃合計
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal glNextGenerationWageTotal(Order order) {

		BigDecimal glWageTotal = new BigDecimal(0.0);
		GiletOptionStandardNextGenerationPriceEnum[] priceEnum = GiletOptionStandardNextGenerationPriceEnum.values();
		for (GiletOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFour = price.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFour = getMethod(cls, valueFour);
				Object[] args = {};
				Object resultFour = null;

				if (myMethodFour != null) {
					resultFour = ReflectionUtils.invoke(myMethodFour, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFour);
				glWageTotal = result.add(glWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return glWageTotal;
	}

	/**
	 * GILET_下代付属合計
	 * 
	 * @param order
	 * @return
	 */
	public Integer glNextGenerationPriceTotal(Order order) {

		Integer glPriceTotal = 0;
		GiletOptionStandardNextGenerationPriceEnum[] priceEnum = GiletOptionStandardNextGenerationPriceEnum.values();
		for (GiletOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				Integer result = commonTransfer(resultFive);
				glPriceTotal = result + glPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return glPriceTotal;
	}

	/**
	 * GILET_下代工賃合計 (オプション付属詳細価格を含む)
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal glNextGenerationDetailWageTotal(Order order) {

		BigDecimal glDetailWageTotal = new BigDecimal(0.0);
		GiletOptionDetailStandardNextGenerationPriceEnum[] priceEnum = GiletOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (GiletOptionDetailStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFive);
				glDetailWageTotal = result.add(glDetailWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return glDetailWageTotal;
	}

	/**
	 * GILET_下代付属合計 (オプション付属詳細価格を含む)
	 * 
	 * @param order
	 * @return
	 */
	public Integer glNextGenerationDetailPriceTotal(Order order) {

		Integer glDetailPriceTotal = 0;
		GiletOptionDetailStandardNextGenerationPriceEnum[] priceEnum = GiletOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (GiletOptionDetailStandardNextGenerationPriceEnum price : priceEnum) {

			String valueSix = price.getValueSix();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodSix = getMethod(cls, valueSix);
				Object[] args = {};
				Object resultSix = null;

				if (myMethodSix != null) {
					resultSix = ReflectionUtils.invoke(myMethodSix, order, args);
				}

				Integer result = commonTransfer(resultSix);
				glDetailPriceTotal = result + glDetailPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return glDetailPriceTotal;
	}

	/**
	 * PANTS2_下代工賃合計
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal pt2NextGenerationWageTotal(Order order) {

		BigDecimal pt2WageTotal = new BigDecimal(0.0);
		Pants2OptionStandardNextGenerationPriceEnum[] priceEnum = Pants2OptionStandardNextGenerationPriceEnum.values();
		for (Pants2OptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFour = price.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFour = getMethod(cls, valueFour);
				Object[] args = {};
				Object resultFour = null;

				if (myMethodFour != null) {
					resultFour = ReflectionUtils.invoke(myMethodFour, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFour);
				pt2WageTotal = result.add(pt2WageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		BigDecimal pt2BtnMaterialWsWage;
		if (order.getPt2BtnMaterialWsWage() == null) {
			pt2BtnMaterialWsWage = new BigDecimal(0.0);
			pt2WageTotal = pt2BtnMaterialWsWage.add(pt2WageTotal);
		} else {
			pt2BtnMaterialWsWage = order.getPt2BtnMaterialWsWage();
			pt2WageTotal = pt2BtnMaterialWsWage.add(pt2WageTotal);
		}
		return pt2WageTotal;
	}

	/**
	 * PANTS2_下代付属合計
	 * 
	 * @param order
	 * @return
	 */
	public Integer pt2NextGenerationPriceTotal(Order order) {

		Integer pt2PriceTotal = 0;
		Pants2OptionStandardNextGenerationPriceEnum[] priceEnum = Pants2OptionStandardNextGenerationPriceEnum.values();
		for (Pants2OptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				Integer result = commonTransfer(resultFive);
				pt2PriceTotal = result + pt2PriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		Integer pt2BtnMaterialWsPrice;
		if (order.getPt2BtnMaterialWsPrice() == null) {
			pt2BtnMaterialWsPrice = 0;
			pt2PriceTotal = pt2BtnMaterialWsPrice + pt2PriceTotal;
		} else {
			pt2BtnMaterialWsPrice = order.getPt2BtnMaterialWsPrice();
			pt2PriceTotal = pt2BtnMaterialWsPrice + pt2PriceTotal;
		}
		return pt2PriceTotal;
	}

	/**
	 * JACKET要尺の取得
	 * 
	 * @param orderForm
	 * @param yieldList
	 * @return
	 */
	public Integer getJacketYield(OrderForm orderForm, List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String jkSubItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		String ojFrontBtnCnt = "0000105";
		for (NextGenerationPrice yield : yieldList) {
			if (jkSubItemCode.equals(yield.getSubItemCode())) {
				// フロント釦数はダブル6つボタンの場合、該当itemはダブル
				if (ojFrontBtnCnt.equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
					jkYield = yield.getDoubleBreastedFabricAmount();
					return jkYield;
				} else {
					jkYield = yield.getNomalFabricAmount();
					return jkYield;
				}
			}
		}
		return jkYield;
	}

	/**
	 * JACKET要尺の取得
	 * 
	 * @param orderForm
	 * @param yieldList
	 * @return
	 */
	public Integer getJacketYield(Order order, List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String jkSubItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		String ojFrontBtnCnt = "0000105";
		for (NextGenerationPrice yield : yieldList) {
			if (jkSubItemCode.equals(yield.getSubItemCode())) {
				// フロント釦数はダブル6つボタンの場合、該当itemはダブル
				if (ojFrontBtnCnt.equals(order.getJkFrtBtnCd())) {
					jkYield = yield.getDoubleBreastedFabricAmount();
					return jkYield;
				} else {
					jkYield = yield.getNomalFabricAmount();
					return jkYield;
				}
			}
		}
		return jkYield;
	}

	/**
	 * GILET要尺の取得
	 * 
	 * @param yieldList
	 * @return
	 */
	public Integer getGiletYield(List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String glSubItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		for (NextGenerationPrice yield : yieldList) {
			if (glSubItemCode.equals(yield.getSubItemCode())) {
				jkYield = yield.getNomalFabricAmount();
				return jkYield;
			}
		}
		return jkYield;
	}

	/**
	 * PANTS要尺の取得
	 * 
	 * @param yieldList
	 * @return
	 */
	public Integer getPantsYield(List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String ptSubItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
		for (NextGenerationPrice yield : yieldList) {
			if (ptSubItemCode.equals(yield.getSubItemCode())) {
				jkYield = yield.getNomalFabricAmount();
				return jkYield;
			}
		}
		return jkYield;
	}

	/**
	 * PANTS2要尺の取得
	 * 
	 * @param yieldList
	 * @return
	 */
	public Integer getPants2Yield(List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String pt2SubItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		for (NextGenerationPrice yield : yieldList) {
			if (pt2SubItemCode.equals(yield.getSubItemCode())) {
				jkYield = yield.getNomalFabricAmount();
				return jkYield;
			}
		}
		return jkYield;
	}

	/**
	 * ドル為替の取得
	 * 
	 * @param wholesalePieceList
	 * @return
	 */
	public BigDecimal getDollarExchange(OrderForm orderForm, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = orderForm.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		BigDecimal productDollarExchange = new BigDecimal(0.0);

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productDollarExchange = wholesalePiece.getDollarExchange();
				return productDollarExchange;
			} else {
				productDollarExchange = new BigDecimal(100.0);
			}
		}
		return productDollarExchange;
	}

	/**
	 * ドル為替の取得
	 * 
	 * @param wholesalePieceList
	 * @return
	 */
	public BigDecimal getDollarExchange(Order order, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = order.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		BigDecimal productDollarExchange = new BigDecimal(0.0);

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productDollarExchange = wholesalePiece.getDollarExchange();
				return productDollarExchange;
			} else {
				productDollarExchange = new BigDecimal(100.0);
			}
		}
		return productDollarExchange;
	}

	/**
	 * 製品関税の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Double getProductTariff(OrderForm orderForm, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = orderForm.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Double productTariff = 0.0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productTariff = wholesalePiece.getProductTariff();
				return productTariff;
			} else {
				productTariff = 100.0;
			}
		}
		return productTariff;
	}

	/**
	 * 製品関税の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Double getProductTariff(Order order, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = order.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Double productTariff = 0.0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productTariff = wholesalePiece.getProductTariff();
				return productTariff;
			} else {
				productTariff = 100.0;
			}
		}
		return productTariff;
	}

	/**
	 * 製品運賃の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Integer getProductShipping(OrderForm orderForm, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = orderForm.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Integer productShipping = 0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productShipping = wholesalePiece.getProductShipping();
				return productShipping;
			}
		}
		return productShipping;
	}

	/**
	 * 製品運賃の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Integer getProductShipping(Order order, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = order.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Integer productShipping = 0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productShipping = wholesalePiece.getProductShipping();
				return productShipping;
			}
		}
		return productShipping;
	}

	/**
	 * 運賃誤差の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Integer getShippingError(OrderForm orderForm, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = orderForm.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Integer shippingError = 0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				shippingError = wholesalePiece.getShippingError();
				return shippingError;
			}
		}
		return shippingError;
	}

	/**
	 * 運賃誤差の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Integer getShippingError(Order order, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = order.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Integer shippingError = 0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				shippingError = wholesalePiece.getShippingError();
				return shippingError;
			}
		}
		return shippingError;
	}

	/**
	 * 基本工賃合計
	 * 
	 * @param orderForm
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public BigDecimal baseWageCount(OrderForm orderForm, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String itemCode = orderForm.getProductItem();
		String jkSubItemCode = "02";
		BigDecimal baseWageTotal = new BigDecimal(0.0);

		if ("01".equals(itemCode)) {
			if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				BigDecimal mdbwWage = this.getDoubleWage(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage).add(mdbwWage);
			} else {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage);
			}
		} else if ("02".equals(itemCode)) {
			if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				BigDecimal mdbwWage = this.getDoubleWage(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage).add(mdbwWage);
			} else {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage);
			}

		} else if ("03".equals(itemCode)) {
			BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
			baseWageTotal = baseWageTotal.add(mbwWage);
		} else if ("04".equals(itemCode)) {
			BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
			baseWageTotal = baseWageTotal.add(mbwWage);
		}
		return baseWageTotal;
	}

	/**
	 * 基本工賃合計
	 * 
	 * @param orderForm
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public BigDecimal baseWageCount(Order order, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String itemCode = order.getProductItem();
		String jkSubItemCode = "02";
		BigDecimal baseWageTotal = new BigDecimal(0.0);

		if ("01".equals(itemCode)) {
			if ("0000105".equals(order.getJkFrtBtnCd())) {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				BigDecimal mdbwWage = this.getDoubleWage(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage).add(mdbwWage);
			} else {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage);
			}
		} else if ("02".equals(itemCode)) {
			if ("0000105".equals(order.getJkFrtBtnCd())) {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				BigDecimal mdbwWage = this.getDoubleWage(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage).add(mdbwWage);
			} else {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage);
			}

		} else if ("03".equals(itemCode)) {
			BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
			baseWageTotal = baseWageTotal.add(mbwWage);
		} else if ("04".equals(itemCode)) {
			BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
			baseWageTotal = baseWageTotal.add(mbwWage);
		}
		return baseWageTotal;
	}

	/**
	 * 基本付属合計
	 * 
	 * @param orderForm
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public Integer basePriceCount(OrderForm orderForm, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String itemCode = orderForm.getProductItem();
		String jkSubItemCode = "02";
		Integer basePriceTotal = 0;

		if ("01".equals(itemCode)) {
			if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				Integer mdbapPrice = this.getDoublePrice(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice + mdbapPrice;
			} else {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice;
			}
		} else if ("02".equals(itemCode)) {
			if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				Integer mdbapPrice = this.getDoublePrice(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice + mdbapPrice;
			} else {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice;
			}

		} else if ("03".equals(itemCode)) {
			Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
			basePriceTotal = basePriceTotal + mnapPrice;
		} else if ("04".equals(itemCode)) {
			Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
			basePriceTotal = basePriceTotal + mnapPrice;
		}
		return basePriceTotal;
	}

	/**
	 * 基本付属合計
	 * 
	 * @param orderForm
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public Integer basePriceCount(Order order, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String itemCode = order.getProductItem();
		String jkSubItemCode = "02";
		Integer basePriceTotal = 0;

		if ("01".equals(itemCode)) {
			if ("0000105".equals(order.getJkFrtBtnCd())) {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				Integer mdbapPrice = this.getDoublePrice(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice + mdbapPrice;
			} else {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice;
			}
		} else if ("02".equals(itemCode)) {
			if ("0000105".equals(order.getJkFrtBtnCd())) {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				Integer mdbapPrice = this.getDoublePrice(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice + mdbapPrice;
			} else {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice;
			}

		} else if ("03".equals(itemCode)) {
			Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
			basePriceTotal = basePriceTotal + mnapPrice;
		} else if ("04".equals(itemCode)) {
			Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
			basePriceTotal = basePriceTotal + mnapPrice;
		}
		return basePriceTotal;
	}

	/**
	 * 下代関連計算方法
	 * 
	 * @param order
	 * @param yieldList
	 * @param wholesalePieceList
	 * @param priceCode
	 * @param marginRate
	 * @return
	 */
	public Integer nextGenerationRelationCount(Order order, List<NextGenerationPrice> yieldList,
			List<NextGenerationPrice> wholesalePieceList, List<NextGenerationPrice> basicNextGenerationPriceList,
			NextGenerationPrice priceCode, NextGenerationPrice marginRate) {
		// 下代関連計算方法の オプション工賃
		BigDecimal jkNextGenerationWageTotal = this.jkNextGenerationWageTotal(order);
		BigDecimal jkNextGenerationDetailWageTotal = this.jkNextGenerationDetailWageTotal(order);
		BigDecimal glNextGenerationWageTotal = this.glNextGenerationWageTotal(order);
		BigDecimal glNextGenerationDetailWageTotal = this.glNextGenerationDetailWageTotal(order);
		BigDecimal ptNextGenerationWageTotal = this.ptNextGenerationWageTotal(order);
		BigDecimal pt2NextGenerationWageTotal = this.pt2NextGenerationWageTotal(order);

		// 基本工賃
		BigDecimal baseWageCount = this.baseWageCount(order, basicNextGenerationPriceList);
		// 商品情報_３Piece下代工賃
		BigDecimal productIs3pieceWsWage = order.getProductIs3pieceWsWage();
		// 商品情報_スペアパンツ下代工賃
		BigDecimal productSparePantsWsWage = order.getProductSparePantsWsWage();
		// 基本工賃 + オプション工賃合計
		BigDecimal NextGenerationWageTotal = baseWageCount.add(jkNextGenerationWageTotal)
				.add(jkNextGenerationDetailWageTotal).add(glNextGenerationWageTotal)
				.add(glNextGenerationDetailWageTotal).add(ptNextGenerationWageTotal).add(pt2NextGenerationWageTotal)
				.add(productIs3pieceWsWage).add(productSparePantsWsWage);

		// 下代関連計算方法の オプション付属
		Integer jkNextGenerationPriceTotal = this.jkNextGenerationPriceTotal(order);
		Integer jkNextGenerationDetailPriceTotal = this.jkNextGenerationDetailPriceTotal(order);
		Integer glNextGenerationPriceTotal = this.glNextGenerationPriceTotal(order);
		Integer glNextGenerationDetailPriceTotal = this.glNextGenerationDetailPriceTotal(order);
		Integer ptNextGenerationPriceTotal = this.ptNextGenerationPriceTotal(order);
		Integer pt2NextGenerationPriceTotal = this.pt2NextGenerationPriceTotal(order);

		// 基本付属代
		Integer basePriceCount = this.basePriceCount(order, basicNextGenerationPriceList);
		// 商品情報_３Piece_下代付属
		Integer productIs3pieceWsPrice = order.getProductIs3pieceWsPrice();
		// 商品情報_スペアパンツ下代付属
		Integer productSparePantsWsPrice = order.getProductSparePantsWsPrice();
		// オプション付属合計
		Integer NextGenerationPriceTotal = basePriceCount + jkNextGenerationPriceTotal
				+ jkNextGenerationDetailPriceTotal + glNextGenerationPriceTotal + glNextGenerationDetailPriceTotal
				+ ptNextGenerationPriceTotal + pt2NextGenerationPriceTotal + productIs3pieceWsPrice
				+ productSparePantsWsPrice;

		// 下代関連計算方法の要尺
		Integer jacketYield = this.getJacketYield(order, yieldList);
		Integer giletYield = this.getGiletYield(yieldList);
		Integer pants2Yield = this.getPants2Yield(yieldList);
		Integer pantsYield = this.getPantsYield(yieldList);
		// 要尺合計
		Double yieldTotal = (double) (jacketYield + giletYield + pantsYield + pants2Yield) / 1000;

		// 下代関連計算方法の生地代
		Integer fabricPrice = priceCode.getFabricPrice();

		// 下代関連計算方法の下代調整金
		Integer wsPriceAdjust = priceCode.getWsPriceAdjust();

		// 下代関連計算方法の為替
		BigDecimal dollarExchange = this.getDollarExchange(order, wholesalePieceList, priceCode);

		// 下代関連計算方法の製品関税
		Double productTariff = this.getProductTariff(order, wholesalePieceList, priceCode);

		// 下代関連計算方法の製品運賃
		Integer productShipping = this.getProductShipping(order, wholesalePieceList, priceCode);

		// 下代関連計算方法の運賃誤差
		Integer shippingError = this.getShippingError(order, wholesalePieceList, priceCode);

		// 下代関連計算方法のメーカーマージン
		Double makerMarginRate = marginRate.getMarginRate();

		/*
		 * ( ( ( (生地代×要尺) + (基本工賃 + オプション工賃) * 為替 + (基本付属代 ＋ オプション付属) )*製品関税 ) ＋
		 * 製品運賃＋運賃誤差 )*メーカーマージン+ 下代調整金
		 */

		// 生地代×要尺
		BigDecimal fabricPriceYieldTotal = BigDecimalCommonTransfer((fabricPrice * yieldTotal));
		// (基本付属代 ＋ オプション付属)
		BigDecimal NextGenerationPriceTotalTransfer = BigDecimalCommonTransfer(NextGenerationPriceTotal);
		// 製品関税
		BigDecimal productTariffTransfer = BigDecimalCommonTransfer((productTariff / 100));
		// 製品運賃＋運賃誤差
		BigDecimal productShippingShippingError = BigDecimalCommonTransfer(productShipping + shippingError);
		// メーカーマージン
		BigDecimal makerMarginRateTransfer = BigDecimalCommonTransfer((makerMarginRate / 100));
		// 下代調整金
		BigDecimal wsPriceAdjustTransfer = BigDecimalCommonTransfer(wsPriceAdjust);

		BigDecimal nextGenerationRelationCount = (((fabricPriceYieldTotal
				.add(NextGenerationWageTotal.multiply(dollarExchange)).add(NextGenerationPriceTotalTransfer))
						.multiply(productTariffTransfer)).add(productShippingShippingError))
								.multiply(makerMarginRateTransfer).add(wsPriceAdjustTransfer);
		Integer convertNumber = this.convertNumber(nextGenerationRelationCount);
		return convertNumber;
	}

	/**
	 * 下代関連計算方法
	 * 
	 * @param orderForm
	 * @param order
	 * @param yieldList
	 * @param wholesalePieceList
	 * @param priceCode
	 * @param marginRate
	 */
	public void nextGenerationRelationCount(OrderForm orderForm, Order order, List<NextGenerationPrice> yieldList,
			List<NextGenerationPrice> wholesalePieceList, List<NextGenerationPrice> basicNextGenerationPriceList,
			NextGenerationPrice priceCode, NextGenerationPrice marginRate) {
		// 下代関連計算方法のオプション工賃
		BigDecimal jkNextGenerationWageTotal = this.jkNextGenerationWageTotal(order);
		BigDecimal jkNextGenerationDetailWageTotal = this.jkNextGenerationDetailWageTotal(order);
		BigDecimal glNextGenerationWageTotal = this.glNextGenerationWageTotal(order);
		BigDecimal glNextGenerationDetailWageTotal = this.glNextGenerationDetailWageTotal(order);
		BigDecimal ptNextGenerationWageTotal = this.ptNextGenerationWageTotal(order);
		BigDecimal pt2NextGenerationWageTotal = this.pt2NextGenerationWageTotal(order);
		// 基本工賃
		BigDecimal baseWageCount = this.baseWageCount(orderForm, basicNextGenerationPriceList);
		// 商品情報_３Piece下代工賃
		BigDecimal productIs3pieceWsWage = order.getProductIs3pieceWsWage();
		// 商品情報_スペアパンツ下代工賃
		BigDecimal productSparePantsWsWage = order.getProductSparePantsWsWage();
		// 基本工賃 + オプション工賃合計
		BigDecimal NextGenerationWageTotal = baseWageCount.add(jkNextGenerationWageTotal)
				.add(jkNextGenerationDetailWageTotal).add(glNextGenerationWageTotal)
				.add(glNextGenerationDetailWageTotal).add(ptNextGenerationWageTotal).add(pt2NextGenerationWageTotal)
				.add(productIs3pieceWsWage).add(productSparePantsWsWage);

		// 下代関連計算方法のオプション付属
		Integer jkNextGenerationPriceTotal = this.jkNextGenerationPriceTotal(order);
		Integer jkNextGenerationDetailPriceTotal = this.jkNextGenerationDetailPriceTotal(order);
		Integer glNextGenerationPriceTotal = this.glNextGenerationPriceTotal(order);
		Integer glNextGenerationDetailPriceTotal = this.glNextGenerationDetailPriceTotal(order);
		Integer ptNextGenerationPriceTotal = this.ptNextGenerationPriceTotal(order);
		Integer pt2NextGenerationPriceTotal = this.pt2NextGenerationPriceTotal(order);

		// 基本付属代
		Integer basePriceCount = this.basePriceCount(orderForm, basicNextGenerationPriceList);
		// 商品情報_３Piece_下代付属
		Integer productIs3pieceWsPrice = order.getProductIs3pieceWsPrice();
		// 商品情報_スペアパンツ下代付属
		Integer productSparePantsWsPrice = order.getProductSparePantsWsPrice();
		// 基本付属代 ＋ オプション付属合計
		Integer NextGenerationPriceTotal = basePriceCount + jkNextGenerationPriceTotal
				+ jkNextGenerationDetailPriceTotal + glNextGenerationPriceTotal + glNextGenerationDetailPriceTotal
				+ ptNextGenerationPriceTotal + pt2NextGenerationPriceTotal + productIs3pieceWsPrice
				+ productSparePantsWsPrice;

		// 下代関連計算方法の要尺
		Integer jacketYield = this.getJacketYield(orderForm, yieldList);
		Integer giletYield = this.getGiletYield(yieldList);
		Integer pants2Yield = this.getPants2Yield(yieldList);
		Integer pantsYield = this.getPantsYield(yieldList);
		// 要尺合計
		Double yieldTotal = (double) (jacketYield + giletYield + pantsYield + pants2Yield) / 1000;

		// 下代関連計算方法の生地代
		Integer fabricPrice = priceCode.getFabricPrice();

		// 下代関連計算方法の下代調整金
		Integer wsPriceAdjust = priceCode.getWsPriceAdjust();

		// 下代関連計算方法の為替
		BigDecimal dollarExchange = this.getDollarExchange(orderForm, wholesalePieceList, priceCode);

		// 下代関連計算方法の製品関税
		Double productTariff = this.getProductTariff(orderForm, wholesalePieceList, priceCode);

		// 下代関連計算方法の製品運賃
		Integer productShipping = this.getProductShipping(orderForm, wholesalePieceList, priceCode);

		// 下代関連計算方法の運賃誤差
		Integer shippingError = this.getShippingError(orderForm, wholesalePieceList, priceCode);

		// 下代関連計算方法のメーカーマージン
		Double makerMarginRate = marginRate.getMarginRate();

		/*
		 * ( ( ( (生地代×要尺) + (基本工賃 + オプション工賃) * 為替 + (基本付属代 ＋ オプション付属) )*製品関税 ) ＋
		 * 製品運賃＋運賃誤差 )*メーカーマージン + 下代調整金
		 */

		// (生地代×要尺)
		BigDecimal fabricPriceYieldTotal = BigDecimalCommonTransfer((fabricPrice * yieldTotal));
		// (基本付属代 ＋ オプション付属)
		BigDecimal NextGenerationPriceTotalTransfer = BigDecimalCommonTransfer(NextGenerationPriceTotal);
		// 製品関税
		BigDecimal productTariffTransfer = BigDecimalCommonTransfer((productTariff / 100));
		// 製品運賃＋運賃誤差
		BigDecimal productShippingShippingError = BigDecimalCommonTransfer(productShipping + shippingError);
		// メーカーマージン
		BigDecimal makerMarginRateTransfer = BigDecimalCommonTransfer((makerMarginRate / 100));
		// 下代調整金
		BigDecimal wsPriceAdjustTransfer = BigDecimalCommonTransfer(wsPriceAdjust);
		BigDecimal nextGenerationRelationCount = (((fabricPriceYieldTotal
				.add(NextGenerationWageTotal.multiply(dollarExchange)).add(NextGenerationPriceTotalTransfer))
						.multiply(productTariffTransfer)).add(productShippingShippingError))
								.multiply(makerMarginRateTransfer).add(wsPriceAdjustTransfer);
		Integer convertNumber = this.convertNumber(nextGenerationRelationCount);
		order.setWsPrice(convertNumber);
	}

	/**
	 * 計算結果の1円の桁は切り捨て
	 * 
	 * @return
	 */
	public Integer convertNumber(BigDecimal nextGenerationRelationCount) {
		BigDecimal nextGenerationCount = nextGenerationRelationCount.setScale(0, RoundingMode.DOWN);
		Integer nextGeneration = Integer.parseInt(nextGenerationCount.toString());
		nextGeneration = nextGeneration - (nextGeneration % 10);
		return nextGeneration;
	}

	/**
	 * 再補正値が「お渡し時再補正入力」画面からオーダー詳細画面に伝わる
	 * 
	 * @param orderForm
	 * @param order
	 * @param userId
	 */
	public void dealWithCorrectAgain(OrderForm orderForm, Order order, String userId) {
		String suitItemCode = "01";
		String jacketItemCode = "02";
		String pantsItemCode = "03";
		String giletItemCode = "04";
		String suit2PP = "22";
		String suit3P2PP = "32";
		String productItemDisplaycode = order.getProductItemDisplaycode();
		String productItem = order.getProductItem();
		if (suitItemCode.equals(productItem)) {
			// JACKET_着丈_再補正値
			String corJkBodylengthCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkBodylengthCorrectAgain();
			BigDecimal corJkBodylengthCorrectA = convertBigDecimal(corJkBodylengthCorrectAgain);
			// JACKET_着丈_再補正値フラッグ
			String corJkBodylengthCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkBodylengthCorrectAgainFlag();
			BigDecimal corJkBodylengthCorrectAgainF = new BigDecimal(corJkBodylengthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkBodylengthCorrect = corJkBodylengthCorrectA.multiply(corJkBodylengthCorrectAgainF);
			// JACKET_着丈_再補正値
			order.setCorJkBodylengthCorrectAgain(corJkBodylengthCorrect);

			// JACKET_ウエスト_再補正値
			String corJkWaistCorrectAgain = orderForm.getAdjustJacketStandardInfo().getCorJkWaistCorrectAgain();
			BigDecimal corJkWaistCorrectA = convertBigDecimal(corJkWaistCorrectAgain);
			// JACKET_ウエスト_再補正値フラッグ
			String corJkWaistCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo().getCorJkWaistCorrectAgainFlag();
			BigDecimal corJkWaistCorrectAgainF = new BigDecimal(corJkWaistCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkWaistCorrect = corJkWaistCorrectA.multiply(corJkWaistCorrectAgainF);
			// JACKET_ウエスト_再補正値
			order.setCorJkWaistCorrectAgain(corJkWaistCorrect);

			// JACKET_袖丈右_再補正値
			String corJkRightsleeveCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkRightsleeveCorrectAgain();
			BigDecimal corJkRightsleeveCorrectA = convertBigDecimal(corJkRightsleeveCorrectAgain);
			// JACKET_袖丈右_再補正値フラッグ
			String corJkRightsleeveCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkRightsleeveCorrectAgainFlag();
			BigDecimal corJkRightsleeveCorrectAgainF = new BigDecimal(corJkRightsleeveCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkRightsleeveCorrect = corJkRightsleeveCorrectA.multiply(corJkRightsleeveCorrectAgainF);
			// JACKET_袖丈右_再補正値
			order.setCorJkRightsleeveCorrectAgain(corJkRightsleeveCorrect);

			// JACKET_袖丈左_再補正値
			String corJkLeftsleeveCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkLeftsleeveCorrectAgain();
			BigDecimal corJkLeftsleeveCorrectA = convertBigDecimal(corJkLeftsleeveCorrectAgain);
			// JACKET_袖丈左_再補正値フラッグ
			String corJkLeftsleeveCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkLeftsleeveCorrectAgainFlag();
			BigDecimal corJkLeftsleeveCorrectAgainF = new BigDecimal(corJkLeftsleeveCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkLeftsleeveCorrect = corJkLeftsleeveCorrectA.multiply(corJkLeftsleeveCorrectAgainF);
			// JACKET_袖丈左_再補正値
			order.setCorJkLeftsleeveCorrectAgain(corJkLeftsleeveCorrect);

			// PANTS_ウエスト_再補正値
			String corPtWaistCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtWaistCorrectAgain();
			BigDecimal corPtWaistCorrectA = convertBigDecimal(corPtWaistCorrectAgain);
			// PANTS_ウエスト_再補正値フラッグ
			String corPtWaistCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo().getCorPtWaistCorrectAgainFlag();
			BigDecimal corPtWaistCorrectAgainF = new BigDecimal(corPtWaistCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtWaistCorrect = corPtWaistCorrectA.multiply(corPtWaistCorrectAgainF);
			// PANTS_ウエスト_再補正値
			order.setCorPtWaistCorrectAgain(corPtWaistCorrect);

			// PANTS_ワタリ_再補正値
			String corPtThighwidthCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtThighwidthCorrectAgain();
			BigDecimal corPtThighwidthCorrectA = convertBigDecimal(corPtThighwidthCorrectAgain);
			// PANTS_ワタリ_再補正値フラッグ
			String corPtThighwidthCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtThighwidthCorrectAgainFlag();
			BigDecimal corPtThighwidthCorrectAgainF = new BigDecimal(corPtThighwidthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtThighwidthCorrect = corPtThighwidthCorrectA.multiply(corPtThighwidthCorrectAgainF);
			// PANTS_ワタリ_再補正値
			order.setCorPtThighwidthCorrectAgain(corPtThighwidthCorrect);
			
			// PANTS_ヒップ_再補正値
			String corPtHipCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtHipCorrectAgain();
			BigDecimal corPtHipCorrectAgainA = convertBigDecimal(corPtHipCorrectAgain);
			// PANTS_ヒップ_再補正値フラッグ
			String corPtHipCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtHipCorrectAgainFlag();
			BigDecimal corPtHipCorrectAgainF = new BigDecimal(corPtHipCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtHipCorrect = corPtHipCorrectAgainA.multiply(corPtHipCorrectAgainF);
			// PANTS_ヒップ_再補正値
			order.setCorPtHipCorrectAgain(corPtHipCorrect);

			// PANTS_裾幅_修正_再補正値
			String corPtHemwidthCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtHemwidthCorrectAgain();
			BigDecimal corPtHemwidthCorrectA = convertBigDecimal(corPtHemwidthCorrectAgain);
			// PANTS_裾幅_修正_再補正値フラッグ
			String corPtHemwidthCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtHemwidthCorrectAgainFlag();
			BigDecimal corPtHemwidthCorrectAgainF = new BigDecimal(corPtHemwidthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtHemwidthCorrect = corPtHemwidthCorrectA.multiply(corPtHemwidthCorrectAgainF);
			// PANTS_裾幅_修正_再補正値
			order.setCorPtHemwidthCorrectAgain(corPtHemwidthCorrect);

			// PANTS_股下右_再補正値
			String corPtRightinseamCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtRightinseamCorrectAgain();
			BigDecimal corPtRightinseamCorrectA = convertBigDecimal(corPtRightinseamCorrectAgain);
			// PANTS_股下右_再補正値フラッグ
			String corPtRightinseamCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtRightinseamCorrectAgainFlag();
			BigDecimal corPtRightinseamCorrectAgainF = new BigDecimal(corPtRightinseamCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtRightinseamCorrect = corPtRightinseamCorrectA.multiply(corPtRightinseamCorrectAgainF);
			// PANTS_股下右_再補正値
			order.setCorPtRightinseamCorrectAgain(corPtRightinseamCorrect);

			// PANTS_股下左_再補正値
			String corPtLeftinseamCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtLeftinseamCorrectAgain();
			BigDecimal corPtLeftinseamCorrectA = convertBigDecimal(corPtLeftinseamCorrectAgain);
			// PANTS_股下左_再補正値フラッグ
			String corPtLeftinseamCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtLeftinseamCorrectAgainFlag();
			BigDecimal corPtLeftinseamCorrectAgainF = new BigDecimal(corPtLeftinseamCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtLeftinseamCorrect = corPtLeftinseamCorrectA.multiply(corPtLeftinseamCorrectAgainF);
			// PANTS_股下左_再補正値
			order.setCorPtLeftinseamCorrectAgain(corPtLeftinseamCorrect);

			if (suit2PP.equals(productItemDisplaycode) || suit3P2PP.equals(productItemDisplaycode)) {
				// ２PANTS_ウエスト_再補正値
				String corPt2WaistCorrectAgain = orderForm.getAdjustPants2StandardInfo().getCorPt2WaistCorrectAgain();
				BigDecimal corPt2WaistCorrectA = convertBigDecimal(corPt2WaistCorrectAgain);
				// ２PANTS_ウエスト_再補正値フラッグ
				String corPt2WaistCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2WaistCorrectAgainFlag();
				BigDecimal corPt2WaistCorrectAgainF = new BigDecimal(corPt2WaistCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2WaistCorrect = corPt2WaistCorrectA.multiply(corPt2WaistCorrectAgainF);
				// ２PANTS_ウエスト_再補正値
				order.setCorPt2WaistCorrectAgain(corPt2WaistCorrect);
				
				// 2PANTS_ヒップ_再補正値
				String corPt2HipCorrectAgain = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2HipCorrectAgain();
				BigDecimal corPt2HipCorrectAgainA = convertBigDecimal(corPt2HipCorrectAgain);
				// 2PANTS_ヒップ_再補正値フラッグ
				String corPt2HipCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2HipCorrectAgainFlag();
				BigDecimal corPt2HipCorrectAgainF = new BigDecimal(corPt2HipCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2HipCorrect = corPt2HipCorrectAgainA.multiply(corPt2HipCorrectAgainF);
				// 2PANTS_ヒップ_再補正値
				order.setCorPt2HipCorrectAgain(corPt2HipCorrect);

				// 2PANTS_ワタリ_再補正値
				String corPt2ThighwidthCorrectAgain = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2ThighwidthCorrectAgain();
				BigDecimal corPt2ThighwidthCorrectA = convertBigDecimal(corPt2ThighwidthCorrectAgain);
				// 2PANTS_ワタリ_再補正値フラッグ
				String corPt2ThighwidthCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2ThighwidthCorrectAgainFlag();
				BigDecimal corPt2ThighwidthCorrectAgainF = new BigDecimal(corPt2ThighwidthCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2ThighwidthCorrect = corPt2ThighwidthCorrectA.multiply(corPt2ThighwidthCorrectAgainF);
				// 2PANTS_ワタリ_再補正値
				order.setCorPt2ThighwidthCorrectAgain(corPt2ThighwidthCorrect);

				// 2PANTS_裾幅_修正_再補正値
				String corPt2HemwidthCorrectAgain = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2HemwidthCorrectAgain();
				BigDecimal corPt2HemwidthCorrectA = convertBigDecimal(corPt2HemwidthCorrectAgain);
				// 2PANTS_裾幅_修正_再補正値フラッグ
				String corPt2HemwidthCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2HemwidthCorrectAgainFlag();
				BigDecimal corPt2HemwidthCorrectAgainF = new BigDecimal(corPt2HemwidthCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2HemwidthCorrect = corPt2HemwidthCorrectA.multiply(corPt2HemwidthCorrectAgainF);
				// 2PANTS_裾幅_修正_再補正値
				order.setCorPt2HemwidthCorrectAgain(corPt2HemwidthCorrect);

				// 2PANTS_股下右_再補正値
				String corPt2RightinseamCorrectAgain = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2RightinseamCorrectAgain();
				BigDecimal corPt2RightinseamCorrectA = convertBigDecimal(corPt2RightinseamCorrectAgain);
				// 2PANTS_股下右_再補正値フラッグ
				String corPt2RightinseamCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2RightinseamCorrectAgainFlag();
				BigDecimal corPt2RightinseamCorrectAgainF = new BigDecimal(corPt2RightinseamCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2RightinseamCorrect = corPt2RightinseamCorrectA
						.multiply(corPt2RightinseamCorrectAgainF);
				// 2PANTS_股下右_再補正値
				order.setCorPt2RightinseamCorrectAgain(corPt2RightinseamCorrect);

				// 2PANTS_股下左_再補正値
				String corPt2LeftinseamCorrectAgain = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2LeftinseamCorrectAgain();
				BigDecimal corPt2LeftinseamCorrectA = convertBigDecimal(corPt2LeftinseamCorrectAgain);
				// 2PANTS_股下左_再補正値フラッグ
				String corPt2LeftinseamCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2LeftinseamCorrectAgainFlag();
				BigDecimal corPt2LeftinseamCorrectAgainF = new BigDecimal(corPt2LeftinseamCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2LeftinseamCorrect = corPt2LeftinseamCorrectA.multiply(corPt2LeftinseamCorrectAgainF);
				// 2PANTS_股下左_再補正値
				order.setCorPt2LeftinseamCorrectAgain(corPt2LeftinseamCorrect);
			}
		} else if (jacketItemCode.equals(productItem)) {
			// JACKET_着丈_再補正値
			String corJkBodylengthCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkBodylengthCorrectAgain();
			BigDecimal corJkBodylengthCorrectA = convertBigDecimal(corJkBodylengthCorrectAgain);
			// JACKET_着丈_再補正値フラッグ
			String corJkBodylengthCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkBodylengthCorrectAgainFlag();
			BigDecimal corJkBodylengthCorrectAgainF = new BigDecimal(corJkBodylengthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkBodylengthCorrect = corJkBodylengthCorrectA.multiply(corJkBodylengthCorrectAgainF);
			// JACKET_着丈_再補正値
			order.setCorJkBodylengthCorrectAgain(corJkBodylengthCorrect);

			// JACKET_ウエスト_再補正値
			String corJkWaistCorrectAgain = orderForm.getAdjustJacketStandardInfo().getCorJkWaistCorrectAgain();
			BigDecimal corJkWaistCorrectA = convertBigDecimal(corJkWaistCorrectAgain);
			// JACKET_ウエスト_再補正値フラッグ
			String corJkWaistCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo().getCorJkWaistCorrectAgainFlag();
			BigDecimal corJkWaistCorrectAgainF = new BigDecimal(corJkWaistCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkWaistCorrect = corJkWaistCorrectA.multiply(corJkWaistCorrectAgainF);
			// JACKET_ウエスト_再補正値
			order.setCorJkWaistCorrectAgain(corJkWaistCorrect);

			// JACKET_袖丈右_再補正値
			String corJkRightsleeveCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkRightsleeveCorrectAgain();
			BigDecimal corJkRightsleeveCorrectA = convertBigDecimal(corJkRightsleeveCorrectAgain);
			// JACKET_袖丈右_再補正値フラッグ
			String corJkRightsleeveCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkRightsleeveCorrectAgainFlag();
			BigDecimal corJkRightsleeveCorrectAgainF = new BigDecimal(corJkRightsleeveCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkRightsleeveCorrect = corJkRightsleeveCorrectA.multiply(corJkRightsleeveCorrectAgainF);
			// JACKET_袖丈右_再補正値
			order.setCorJkRightsleeveCorrectAgain(corJkRightsleeveCorrect);

			// JACKET_袖丈左_再補正値
			String corJkLeftsleeveCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkLeftsleeveCorrectAgain();
			BigDecimal corJkLeftsleeveCorrectA = convertBigDecimal(corJkLeftsleeveCorrectAgain);
			// JACKET_袖丈左_再補正値フラッグ
			String corJkLeftsleeveCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkLeftsleeveCorrectAgainFlag();
			BigDecimal corJkLeftsleeveCorrectAgainF = new BigDecimal(corJkLeftsleeveCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkLeftsleeveCorrect = corJkLeftsleeveCorrectA.multiply(corJkLeftsleeveCorrectAgainF);
			// JACKET_袖丈左_再補正値
			order.setCorJkLeftsleeveCorrectAgain(corJkLeftsleeveCorrect);
		} else if (pantsItemCode.equals(productItem)) {
			// PANTS_ウエスト_再補正値
			String corPtWaistCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtWaistCorrectAgain();
			BigDecimal corPtWaistCorrectA = convertBigDecimal(corPtWaistCorrectAgain);
			// PANTS_ウエスト_再補正値フラッグ
			String corPtWaistCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo().getCorPtWaistCorrectAgainFlag();
			BigDecimal corPtWaistCorrectAgainF = new BigDecimal(corPtWaistCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtWaistCorrect = corPtWaistCorrectA.multiply(corPtWaistCorrectAgainF);
			// PANTS_ウエスト_再補正値
			order.setCorPtWaistCorrectAgain(corPtWaistCorrect);

			// PANTS_ワタリ_再補正値
			String corPtThighwidthCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtThighwidthCorrectAgain();
			BigDecimal corPtThighwidthCorrectA = convertBigDecimal(corPtThighwidthCorrectAgain);
			// PANTS_ワタリ_再補正値フラッグ
			String corPtThighwidthCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtThighwidthCorrectAgainFlag();
			BigDecimal corPtThighwidthCorrectAgainF = new BigDecimal(corPtThighwidthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtThighwidthCorrect = corPtThighwidthCorrectA.multiply(corPtThighwidthCorrectAgainF);
			// PANTS_ワタリ_再補正値
			order.setCorPtThighwidthCorrectAgain(corPtThighwidthCorrect);

			// PANTS_裾幅_修正_再補正値
			String corPtHemwidthCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtHemwidthCorrectAgain();
			BigDecimal corPtHemwidthCorrectA = convertBigDecimal(corPtHemwidthCorrectAgain);
			// PANTS_裾幅_修正_再補正値フラッグ
			String corPtHemwidthCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtHemwidthCorrectAgainFlag();
			BigDecimal corPtHemwidthCorrectAgainF = new BigDecimal(corPtHemwidthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtHemwidthCorrect = corPtHemwidthCorrectA.multiply(corPtHemwidthCorrectAgainF);
			// PANTS_裾幅_修正_再補正値
			order.setCorPtHemwidthCorrectAgain(corPtHemwidthCorrect);

			// PANTS_股下右_再補正値
			String corPtRightinseamCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtRightinseamCorrectAgain();
			BigDecimal corPtRightinseamCorrectA = convertBigDecimal(corPtRightinseamCorrectAgain);
			// PANTS_股下右_再補正値フラッグ
			String corPtRightinseamCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtRightinseamCorrectAgainFlag();
			BigDecimal corPtRightinseamCorrectAgainF = new BigDecimal(corPtRightinseamCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtRightinseamCorrect = corPtRightinseamCorrectA.multiply(corPtRightinseamCorrectAgainF);
			// PANTS_股下右_再補正値
			order.setCorPtRightinseamCorrectAgain(corPtRightinseamCorrect);

			// PANTS_股下左_再補正値
			String corPtLeftinseamCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtLeftinseamCorrectAgain();
			BigDecimal corPtLeftinseamCorrectA = convertBigDecimal(corPtLeftinseamCorrectAgain);
			// PANTS_股下左_再補正値フラッグ
			String corPtLeftinseamCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtLeftinseamCorrectAgainFlag();
			BigDecimal corPtLeftinseamCorrectAgainF = new BigDecimal(corPtLeftinseamCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtLeftinseamCorrect = corPtLeftinseamCorrectA.multiply(corPtLeftinseamCorrectAgainF);
			// PANTS_股下左_再補正値
			order.setCorPtLeftinseamCorrectAgain(corPtLeftinseamCorrect);
		} else if (giletItemCode.equals(productItem)) {
			
			//GILET_着丈_再補正値
			String corGlBodylengthCorrectAgain = orderForm.getAdjustGiletStandardInfo().getCorGlBodylengthCorrectAgain();
			BigDecimal corGlBodylengthCorrectA = convertBigDecimal(corGlBodylengthCorrectAgain);
			//GILET_着丈_再補正値フラッグ
			String corGlBodylengthCorrectAgainFlag = orderForm.getAdjustGiletStandardInfo().getCorGlBodylengthCorrectAgainFlag();
			BigDecimal corGlBodylengthCorrectAgainF = new BigDecimal(corGlBodylengthCorrectAgainFlag);
			//再補正値*再補正値フラッグ
			BigDecimal corGlBodylengthCorrect = corGlBodylengthCorrectA.multiply(corGlBodylengthCorrectAgainF);
			//GILET_着丈_再補正値
			order.setCorGlBodylengthCorrectAgain(corGlBodylengthCorrect);
			
			//GILET_バスト_再補正値
			String corGlBustCorrectAgain = orderForm.getAdjustGiletStandardInfo().getCorGlBustCorrectAgain();
			BigDecimal corGlBustCorrectA = convertBigDecimal(corGlBustCorrectAgain);
			//GILET_バスト_再補正値フラッグ
			String corGlBustCorrectAgainFlag = orderForm.getAdjustGiletStandardInfo().getCorGlBustCorrectAgainFlag();
			BigDecimal corGlBustCorrectAgainF = new BigDecimal(corGlBustCorrectAgainFlag);
			//再補正値*再補正値フラッグ
			BigDecimal corGlBustCorrect = corGlBustCorrectA.multiply(corGlBustCorrectAgainF);
			//GILET_バスト_再補正値
			order.setCorGlBustCorrectAgain(corGlBustCorrect);
			
			//GILET_ウエスト_再補正値
			String corGlWaistCorrectAgain = orderForm.getAdjustGiletStandardInfo().getCorGlWaistCorrectAgain();
			BigDecimal corGlWaistCorrectA = convertBigDecimal(corGlWaistCorrectAgain);
			//GILET_ウエスト_再補正値フラッグ
			String corGlWaistCorrectAgainFlag = orderForm.getAdjustGiletStandardInfo().getCorGlWaistCorrectAgainFlag();
			BigDecimal corGlWaistCorrectAgainF = new BigDecimal(corGlWaistCorrectAgainFlag);
			//再補正値*再補正値フラッグ
			BigDecimal corGlWaistCorrect = corGlWaistCorrectA.multiply(corGlWaistCorrectAgainF);
			//GILET_ウエスト_再補正値
			order.setCorGlWaistCorrectAgain(corGlWaistCorrect);
			
		}
		order.setUpdatedUserId(userId);
		order.setUpdatedAt(new Date());
		String corStoreCorrectionMemoAgain = orderForm.getCorStoreCorrectionMemoAgain().replaceAll("\\n", "");
		order.setCorStoreCorrectionMemoAgain(corStoreCorrectionMemoAgain);
	}

	/**
	 * 消費税を取得
	 * 
	 * @param taxRate
	 * @param orderForm
	 */
	public void getTaxRate(int taxRate, OrderForm orderForm) {
		String taxRateStr = String.valueOf(taxRate);
		orderForm.setTaxRate(taxRateStr);
	}

	/**
	 * 要尺を取得
	 * 
	 * @param taxRate
	 * @param orderForm
	 */
	public void getYield(List<Yield> yieldList, OrderForm orderForm) {
		orderForm.setYield(new Gson().toJson(yieldList));
	}

	/**
	 * 
	 * @param orderFabric
	 * @return
	 */
	public Map<String, Integer> getRetailPriceRelated(OrderFindFabric orderFabric) {

		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		// 上代
		Integer retailPrice = orderFabric.getRetailPrice();
		// ダブルJACKET増額率
		Integer additionalDoubleJacketRate = orderFabric.getAdditionalDoubleJacketRate();
		// シングルGILET追加増額率
		Integer additionalSingleGiletRate = orderFabric.getAdditionalSingleGiletRate();
		// PANTS追加増額率
		Integer additionalPantsRate = orderFabric.getAdditionalPantsRate();
		// 上代*シングルGILET追加増額率/100
		Integer single3PieceRetailPrice = retailPrice * additionalSingleGiletRate / 100;
		// 上代*PANTS追加増額率/100
		Integer sparePantsPrice = retailPrice * additionalPantsRate / 100;
		// ダブルJACKET単品率
		Integer doubleJacketOnlyRate = orderFabric.getDoubleJacketOnlyRate();
		// ダブルJacketの単品購買追加金額
		Integer jkDoubleOnlyPlusAlphaPrice = orderFabric.getJkDoubleOnlyPlusAlphaPrice();
		// シングルJACKET単品率
		Integer singleJacketOnlyRate = orderFabric.getSingleJacketOnlyRate();
		// シングルJacketの単品購買追加金額
		Integer jkSingleOnlyPlusAlphaPrice = orderFabric.getJkSingleOnlyPlusAlphaPrice();
		// (上代*ダブルJACKET単品率/100+「ダブルJacketの単品購買追加金額」) -
		// (上代*シングルJACKET単品率/100+「シングルJacketの単品購買追加金額」)
		Integer singleJacketDoublePrice = (retailPrice * doubleJacketOnlyRate / 100 + jkDoubleOnlyPlusAlphaPrice)
				- (retailPrice * singleJacketOnlyRate / 100 + jkSingleOnlyPlusAlphaPrice);

		priceMap.put("doubleJACKET", additionalDoubleJacketRate);
		priceMap.put("price3Piece", single3PieceRetailPrice);
		priceMap.put("sparePants", sparePantsPrice);
		priceMap.put("singleDoubleJACKET", singleJacketDoublePrice);

		return priceMap;

	}

	/**
	 * 
	 * @param orderFabric
	 * @return
	 */
	public Map<String, Integer> getCoRetailPriceRelated(OrderFindFabric orderFabric) {

		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		// 上代
		Integer retailPrice = orderFabric.getRetailPrice();
		// ダブルJACKET増額率
		Integer additionalDoubleJacketRate = orderFabric.getAdditionalDoubleJacketRate();
		// シングルGILET追加増額率
		Integer additionalSingleGiletRate = orderFabric.getAdditionalSingleGiletRate();
		// ダブルGILET追加増額率
		Integer additionalDoubleGiletRate = orderFabric.getAdditionalDoubleGiletRate();
		// PANTS追加増額率
		Integer additionalPantsRate = orderFabric.getAdditionalPantsRate();
		// 上代*ダブルJACKET増額率/100
		Integer doubleJacketRtPrice = retailPrice * additionalDoubleJacketRate / 100;
		// 上代*シングルGILET追加増額率/100
		Integer single3PieceRetailPrice = retailPrice * additionalSingleGiletRate / 100;
		// 上代*ダブルGILET追加増額率/100 - 上代*シングルGILET追加増額率/100
		Integer doubleGiletModelRtPrice = retailPrice * additionalDoubleGiletRate / 100
				- retailPrice * additionalSingleGiletRate / 100;
		// 上代*PANTS追加増額率/100
		Integer sparePantsPrice = retailPrice * additionalPantsRate / 100;

		// ダブルJACKET単品率
		Integer doubleJacketOnlyRate = orderFabric.getDoubleJacketOnlyRate();
		// ダブルJacketの単品購買追加金額
		Integer jkDoubleOnlyPlusAlphaPrice = orderFabric.getJkDoubleOnlyPlusAlphaPrice();
		// シングルJACKET単品率
		Integer singleJacketOnlyRate = orderFabric.getSingleJacketOnlyRate();
		// シングルJacketの単品購買追加金額
		Integer jkSingleOnlyPlusAlphaPrice = orderFabric.getJkSingleOnlyPlusAlphaPrice();
		// (上代*ダブルJACKET単品率/100+「ダブルJacketの単品購買追加金額」) -
		// (上代*シングルJACKET単品率/100+「シングルJacketの単品購買追加金額」)
		Integer singleJacketDoublePrice = (retailPrice * doubleJacketOnlyRate / 100 + jkDoubleOnlyPlusAlphaPrice)
				- (retailPrice * singleJacketOnlyRate / 100 + jkSingleOnlyPlusAlphaPrice);

		// シングルGILET単品率
		Integer singleGiletOnlyRate = orderFabric.getSingleGiletOnlyRate();
		// ダブルGILET単品率
		Integer doubleGiletOnlyRate = orderFabric.getDoubleGiletOnlyRate();
		// シングルGILETの単品購買追加金額
		Integer glSingleOnlyPlusAlphaPrice = orderFabric.getGlSingleOnlyPlusAlphaPrice();
		// ダブルGILETの単品購買追加金額
		Integer glDoubleOnlyPlusAlphaPrice = orderFabric.getGlDoubleOnlyPlusAlphaPrice();
		// (上代*ダブルGILET単品率/100+「ダブルGILETの単品購買追加金額」) -
		// (上代*シングルGILET単品率/100+「シングルGILETの単品購買追加金額」)
		Integer singleGiletDoublePrice = (retailPrice * doubleGiletOnlyRate / 100 + glDoubleOnlyPlusAlphaPrice)
				- (retailPrice * singleGiletOnlyRate / 100 + glSingleOnlyPlusAlphaPrice);

		// シングルコート単品率
		Integer coatSingleOnlyRate = orderFabric.getCoatSingleOnlyRate();
		// ダブルコート単品率
		Integer coatDoubleOnlyRate = orderFabric.getCoatDoubleOnlyRate();
		// シングルCoatの単品購買追加金額
		Integer ctSingleOnlyPlusAlphaPrice = orderFabric.getCtSingleOnlyPlusAlphaPrice();
		// ダブルCoatの単品購買追加金額
		Integer ctDoubleOnlyPlusAlphaPrice = orderFabric.getCtDoubleOnlyPlusAlphaPrice();
		// (上代*ダブルコート単品率/100＋「ダブルCoatの単品購買追加金額」) -
		// (上代*シングルコート単品率/100＋「シングルCoatの単品購買追加金額」)
		Integer singleCoatDoublePrice = (retailPrice * coatDoubleOnlyRate / 100 + ctDoubleOnlyPlusAlphaPrice)
				- (retailPrice * coatSingleOnlyRate / 100 + ctSingleOnlyPlusAlphaPrice);

		priceMap.put("price3Piece", single3PieceRetailPrice);
		priceMap.put("sparePants", sparePantsPrice);
		priceMap.put("doubleJacketRtPrice", doubleJacketRtPrice);
		priceMap.put("doubleGiletModelRtPrice", doubleGiletModelRtPrice);
		priceMap.put("singleDoubleJACKET", singleJacketDoublePrice);
		priceMap.put("singleGiletDoublePrice", singleGiletDoublePrice);
		priceMap.put("singleCoatDoublePrice", singleCoatDoublePrice);

		return priceMap;
	}

	public void getFigureNumberMap(OrderForm orderForm) {
		LinkedHashMap<String, String> jkFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> ptFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> glFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> pt2FigureMap = new LinkedHashMap<String, String>();

		// 体型
		// JACKET
		jkFigureMap.put("", "選択　　　");
		// PANTS
		ptFigureMap.put("", "選択　　　");
		// GILET
		glFigureMap.put("", "選択　　　");
		// 2PANTS
		pt2FigureMap.put("", "選択　　　");

		// 号数
		LinkedHashMap<String, String> jkNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> ptNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> glNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> pt2NumberMap = new LinkedHashMap<String, String>();

		// JACKET
		jkNumberMap.put("", "選択　　　");
		// PANTS
		ptNumberMap.put("", "選択　　　");
		// GILET
		glNumberMap.put("", "選択　　　");
		// 2PANTS
		pt2NumberMap.put("", "選択　　　");
		AdjustJacketStandardInfo adjustJacketStandardInfo = new AdjustJacketStandardInfo();
		adjustJacketStandardInfo.setSizeFigureMap(jkFigureMap);
		adjustJacketStandardInfo.setSizeNumberMap(jkNumberMap);
		orderForm.setAdjustJacketStandardInfo(adjustJacketStandardInfo);

		AdjustPantsStandardInfo adjustPantsStandardInfo = new AdjustPantsStandardInfo();
		adjustPantsStandardInfo.setSizeFigureMap(ptFigureMap);
		adjustPantsStandardInfo.setSizeNumberMap(ptNumberMap);
		orderForm.setAdjustPantsStandardInfo(adjustPantsStandardInfo);

		AdjustGiletStandardInfo adjustGiletStandardInfo = new AdjustGiletStandardInfo();
		adjustGiletStandardInfo.setSizeFigureMap(glFigureMap);
		adjustGiletStandardInfo.setSizeNumberMap(glNumberMap);
		orderForm.setAdjustGiletStandardInfo(adjustGiletStandardInfo);

		AdjustPants2StandardInfo adjustPants2StandardInfo = new AdjustPants2StandardInfo();
		adjustPants2StandardInfo.setSizeFigureMap(pt2FigureMap);
		adjustPants2StandardInfo.setSizeNumberMap(pt2NumberMap);
		orderForm.setAdjustPants2StandardInfo(adjustPants2StandardInfo);

	}

	public void orderMappingLogOn(OrderForm orderForm, Order order, SessionContent sessionContent) {
		// 業態
		order.setStoreBrandCode(sessionContent.getStoreBrandCode());

		// 店舗コード
		order.setShopCode(sessionContent.getBelongCode());
		
		order.setStoreNm(sessionContent.getBelongName());

		// 理論在庫チェック
		order.setTheoreticalStockCheck(IS_NOT_THEORETICAL_STOCKCECK);

		// 工場ステータス
		order.setMakerFactoryStatus(FACTORY_STATUSF0);

		// 取り消しフラグ
		order.setIsCancelled(IS_NOT_CANCELLED);

		// 工場自動連携ステータス
		order.setSend2factoryStatus(SEND2FACTORY_STATUS0);

		order.setCreatedUserId(sessionContent.getUserId());
		order.setCreatedAt(new Date());
		order.setUpdatedAt(new Date());
		order.setUpdatedUserId(sessionContent.getUserId());
		order.setVersion((short) 0);

		// お客様氏名
		order.setCustNm(null);

		// お客様情報_フリガナ
		order.setCustKanaNm(null);

		// お客様備考
		order.setCustRemark(orderForm.getCustomerMessageInfo().getCustRemark().replaceAll("\\n", ""));

		// 注文承り日
		order.setProductOrderdDate(new Date());

		// 商品情報_刺繍ネーム、商品情報_刺繍書体、商品情報_刺繍糸色はnull値の判定
		String productEmbroideryNecessity = orderForm.getProductEmbroideryNecessity();
		if ("0".equals(productEmbroideryNecessity)) {
			order.setProductEmbroideryNm(null);
			order.setProductEmbroideryFont(null);
			order.setProductEmbroideryThreadColor(null);
		}

		// PANTS_ダブル幅についての項目はnull値の判定
		String opHemUp = orderForm.getOptionPantsStandardInfo().getOpHemUp();
		if ("0001701".equals(opHemUp) || "0001704".equals(opHemUp)) {
			order.setPtDblWidthCd(null);
			order.setPtDblWidthNm(null);
			order.setPtDblWidthRtPrice(null);
			order.setPtDblWidthWsWage(null);
			order.setPtDblWidthWsPrice(null);
		}

		// PANTS2_ダブル幅についての項目はnull値の判定
		String op2HemUp = orderForm.getOptionPants2StandardInfo().getOp2HemUp();
		if ("0001701".equals(op2HemUp) || "0001704".equals(op2HemUp)) {
			order.setPt2DblWidthCd(null);
			order.setPt2DblWidthNm(null);
			order.setPt2DblWidthRtPrice(null);
			order.setPt2DblWidthWsWage(null);
			order.setPt2DblWidthWsPrice(null);
		}
	}

	public void orderModelPrice(OrderForm orderForm, Map<String, Integer> retailPriceRelatedMap, Order order) {
		// 商品情報_ITEM
		String productItem = orderForm.getProductItem();
		// フロント釦数
		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();

		// JACKET_モデル_上代
		Integer doubleJacketPrice = retailPriceRelatedMap.get("doubleJACKET");
		Integer singleDoubleJacketPrice = retailPriceRelatedMap.get("singleDoubleJACKET");
		
		if ("0000105".equals(ojFrontBtnCnt)) {
			if ("01".equals(productItem)) {
				if (doubleJacketPrice != null) {
					order.setJkModelRtPrice(doubleJacketPrice);
				} else {
					order.setJkModelRtPrice(0);
				}
			} else if ("02".equals(productItem)) {
				if (singleDoubleJacketPrice != null) {
					order.setJkModelRtPrice(singleDoubleJacketPrice);
				} else {
					order.setJkModelRtPrice(0);
				}
			}
		} else {
			if ("01".equals(productItem) || "02".equals(productItem)) {
				order.setJkModelRtPrice(0);
			}

		}

	}

	public List<TypeSizeOptimization> getPoTypeSizeOptimization(List<TypeSize> poTypeSizeList) {
		List<TypeSizeOptimization> typeSizeList = new ArrayList<TypeSizeOptimization>();
		for (TypeSize typeSize : poTypeSizeList) {
			TypeSizeOptimization typeSizeOptimization = new TypeSizeOptimization();
			typeSizeOptimization.setAdjustClass(typeSize.getAdjustClass());
			typeSizeOptimization.setTypeSize(typeSize.getTypeSize().toString());
			typeSizeOptimization.setTypeSize1Intack(typeSize.getTypeSize1Intack().toString());
			typeSizeOptimization.setTypeSize1Outtack(typeSize.getTypeSize1Outtack().toString());
			typeSizeOptimization.setTypeSize2Intack(typeSize.getTypeSize2Intack().toString());
			typeSizeOptimization.setTypeSize2Outtack(typeSize.getTypeSize2Outtack().toString());
			typeSizeList.add(typeSizeOptimization);
		}
		return typeSizeList;
	}

//	/**
//	 * 標準JACKET素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectStandardJkMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> standardJkMaterialMap = new HashMap<String,String>();
//		//JK胴裏素材
//		String ojBodyBackMateStkNo = orderForm.getOptionJacketStandardInfo().getOjBodyBackMateStkNo();
//		String ojBodyBackMateName = orderForm.getOptionJacketStandardInfo().getOjBodyBackMateMap().get(orderForm.getOptionJacketStandardInfo().getOjBodyBackMate());
//		//JK袖裏素材
//		String ojCuffBackMateStkNo = orderForm.getOptionJacketStandardInfo().getOjCuffBackMateStkNo();
//		String ojCuffBackMateName = orderForm.getOptionJacketStandardInfo().getOjCuffBackMateMap().get(orderForm.getOptionJacketStandardInfo().getOjCuffBackMate());
//		//JK釦素材
//		String ojBtnMateStkNo = orderForm.getOptionJacketStandardInfo().getOjBtnMateStkNo();
//		String ojBtnMateName = orderForm.getOptionJacketStandardInfo().getOjBtnMateMap().get(orderForm.getOptionJacketStandardInfo().getOjBtnMate());
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(ojBodyBackMateStkNo != null && ojBodyBackMateStkNo.equals(optionBranchDetailCode)) {
//				standardJkMaterialMap.put("ojBodyBackMateStkNo",ojBodyBackMateName + " " + optionBranchDetailName);
//			}
//			else if(ojCuffBackMateStkNo != null && ojCuffBackMateStkNo.equals(optionBranchDetailCode)) {
//				standardJkMaterialMap.put("ojCuffBackMateStkNo",ojCuffBackMateName + " " + optionBranchDetailName);
//			}
//			else if(ojBtnMateStkNo != null && ojBtnMateStkNo.equals(optionBranchDetailCode)) {
//				standardJkMaterialMap.put("ojBtnMateStkNo",ojBtnMateName + " " + optionBranchDetailName);
//			}
//		}
//		return standardJkMaterialMap;
//	}
//	
//	/**
//	 * 標準GILET素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectStandardGlMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> standardGlMaterialMap = new HashMap<String,String>();
//		//GL背裏地素材
//		String ogBackLiningMateStkNo = orderForm.getOptionGiletStandardInfo().getOgBackLiningMateStkNo();
//		String ogBackLiningMateName = orderForm.getOptionGiletStandardInfo().getOgBackLiningMateMap().get(orderForm.getOptionGiletStandardInfo().getOgBackLiningMate());
//		//GL内側裏地素材
//		String ogInsideLiningMateStkNo = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMateStkNo();
//		String ogInsideLiningMateName = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMateMap().get(orderForm.getOptionGiletStandardInfo().getOgInsideLiningMate());
//		//GLフロント釦
//		String ogFrontBtnMateStkNo = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMateStkNo();
//		String ogFrontBtnMateName = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMateMap().get(orderForm.getOptionGiletStandardInfo().getOgFrontBtnMate());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(ogBackLiningMateStkNo != null && ogBackLiningMateStkNo.equals(optionBranchDetailCode)) {
//				standardGlMaterialMap.put("ogBackLiningMateStkNo",ogBackLiningMateName + " " + optionBranchDetailName);
//			}
//			if(ogInsideLiningMateStkNo != null && ogInsideLiningMateStkNo.equals(optionBranchDetailCode)) {
//				standardGlMaterialMap.put("ogInsideLiningMateStkNo",ogInsideLiningMateName + " " + optionBranchDetailName);
//			}
//			if(ogFrontBtnMateStkNo != null && ogFrontBtnMateStkNo.equals(optionBranchDetailCode)) {
//				standardGlMaterialMap.put("ogFrontBtnMateStkNo",ogFrontBtnMateName + " " + optionBranchDetailName);
//			}
//		}
//		return standardGlMaterialMap;
//	}
//	
//	/**
//	 * 標準COAT素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectStandardCtMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> standardCtMaterialMap = new HashMap<String,String>();
//		//CT胴裏素材
//		String ocBodyBackMateStkNo = orderForm.getOptionCoatStandardInfo().getOcBodyBackMateStkNo();
//		String ocBodyBackMateName = orderForm.getOptionCoatStandardInfo().getOcBodyBackMateMap().get(orderForm.getOptionCoatStandardInfo().getOcBodyBackMate());
//		//CT袖裏素材
//		String ocCuffBackMateStkNo = orderForm.getOptionCoatStandardInfo().getOcCuffBackMateStkNo();
//		String ocCuffBackMateName = orderForm.getOptionCoatStandardInfo().getOcCuffBackMateMap().get(orderForm.getOptionCoatStandardInfo().getOcCuffBackMate());
//		//CT釦素材
//		String ocFrontBtnMateStkNo = orderForm.getOptionCoatStandardInfo().getOcFrontBtnMateStkNo();
//		String OcFrontBtnMateName = orderForm.getOptionCoatStandardInfo().getOcFrontBtnMateMap().get(orderForm.getOptionCoatStandardInfo().getOcFrontBtnMate());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(ocBodyBackMateStkNo != null && ocBodyBackMateStkNo.equals(optionBranchDetailCode)) {
//				standardCtMaterialMap.put("ocBodyBackMateStkNo",ocBodyBackMateName + " " + optionBranchDetailName);
//			}
//			else if(ocCuffBackMateStkNo != null && ocCuffBackMateStkNo.equals(optionBranchDetailCode)) {
//				standardCtMaterialMap.put("ocCuffBackMateStkNo",ocCuffBackMateName + " " + optionBranchDetailName);
//			}
//			else if(ocFrontBtnMateStkNo != null && ocFrontBtnMateStkNo.equals(optionBranchDetailCode)) {
//				standardCtMaterialMap.put("ocFrontBtnMateStkNo",OcFrontBtnMateName + " " + optionBranchDetailName);
//			}
//		}
//		return standardCtMaterialMap;
//	}
//	
//	/**
//	 * 標準PANTS素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectStandardPtMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> standardPtMaterialMap = new HashMap<String,String>();
//		//PT釦素材
//		String opBtnMateStkNo = orderForm.getOptionPantsStandardInfo().getOpBtnMateStkNo();
//		String opButtonName = orderForm.getOptionPantsStandardInfo().getOpButtonMap().get(orderForm.getOptionPantsStandardInfo().getOpButton());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(opBtnMateStkNo != null && opBtnMateStkNo.equals(optionBranchDetailCode)) {
//				standardPtMaterialMap.put("opBtnMateStkNo",opButtonName + " " + optionBranchDetailName);
//				break;
//			}
//		}
//		return standardPtMaterialMap;
//	}
//	
//	/**
//	 * 標準2PANTS素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectStandardPt2MaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> standardPt2MaterialMap = new HashMap<String,String>();
//		//PT2釦素材
//		String op2BtnMateStkNo = orderForm.getOptionPants2StandardInfo().getOp2BtnMateStkNo();
//		String op2ButtonName = orderForm.getOptionPants2StandardInfo().getOp2ButtonMap().get(orderForm.getOptionPants2StandardInfo().getOp2Button());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(op2BtnMateStkNo != null && op2BtnMateStkNo.equals(optionBranchDetailCode)) {
//				standardPt2MaterialMap.put("op2BtnMateStkNo",op2ButtonName + " " + optionBranchDetailName);
//				break;
//			}
//		}
//		return standardPt2MaterialMap;
//	}
//	
//	/**
//	 * タキシードJACKET素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectTuxedoJkMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> tuxedoJkMaterialMap = new HashMap<String,String>();
//		//JK胴裏素材
//		String tjBodyBackMateStkNo = orderForm.getOptionJacketTuxedoInfo().getTjBodyBackMateStkNo();
//		String tjBodyBackMateName = orderForm.getOptionJacketTuxedoInfo().getTjBodyBackMateMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBodyBackMate());
//		//JK袖裏素材
//		String tjCuffBackMateStkNo = orderForm.getOptionJacketTuxedoInfo().getTjCuffBackMateStkNo();
//		String tjCuffBackMateName = orderForm.getOptionJacketTuxedoInfo().getTjCuffBackMateMap().get(orderForm.getOptionJacketTuxedoInfo().getTjCuffBackMate());
//		//JK釦素材
//		String tjBtnMateStkNo = orderForm.getOptionJacketTuxedoInfo().getTjBtnMateStkNo();
//		String tjBtnMateName = orderForm.getOptionJacketTuxedoInfo().getTjBtnMateMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBtnMate());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(tjBodyBackMateStkNo != null && tjBodyBackMateStkNo.equals(optionBranchDetailCode)) {
//				tuxedoJkMaterialMap.put("tjBodyBackMateStkNo",tjBodyBackMateName + " " + optionBranchDetailName);
//			}
//			else if(tjCuffBackMateStkNo != null && tjCuffBackMateStkNo.equals(optionBranchDetailCode)) {
//				tuxedoJkMaterialMap.put("tjCuffBackMateStkNo",tjCuffBackMateName + " " + optionBranchDetailName);
//			}
//			else if(tjBtnMateStkNo != null && tjBtnMateStkNo.equals(optionBranchDetailCode)) {
//				tuxedoJkMaterialMap.put("tjBtnMateStkNo",tjBtnMateName + " " + optionBranchDetailName);
//			}
//		}
//		return tuxedoJkMaterialMap;
//	}
//	
//	/**
//	 * タキシードGILET素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectTuxedoGlMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> tuxedoGlMaterialMap = new HashMap<String,String>();
//		//GL背裏地素材
//		String tgBackLiningMateStkNo = orderForm.getOptionGiletTuxedoInfo().getTgBackLiningMateStkNo();
//		String tgBackLiningMateName = orderForm.getOptionGiletTuxedoInfo().getTgBackLiningMateMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBackLiningMate());
//		//GL内側裏地素材
//		String tgInsideLiningMateStkNo = orderForm.getOptionGiletTuxedoInfo().getTgInsideLiningMateStkNo();
//		String tgInsideLiningMateName = orderForm.getOptionGiletTuxedoInfo().getTgInsideLiningMateMap().get(orderForm.getOptionGiletTuxedoInfo().getTgInsideLiningMate());
//		//GLフロント釦
//		String tgFrontBtnMateStkNo = orderForm.getOptionGiletTuxedoInfo().getTgFrontBtnMateStkNo();
//		String tgFrontBtnMateName = orderForm.getOptionGiletTuxedoInfo().getTgFrontBtnMateMap().get(orderForm.getOptionGiletTuxedoInfo().getTgFrontBtnMate());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(tgBackLiningMateStkNo != null && tgBackLiningMateStkNo.equals(optionBranchDetailCode)) {
//				tuxedoGlMaterialMap.put("tgBackLiningMateStkNo",tgBackLiningMateName + " " + optionBranchDetailName);
//			}
//			if(tgInsideLiningMateStkNo != null && tgInsideLiningMateStkNo.equals(optionBranchDetailCode)) {
//				tuxedoGlMaterialMap.put("tgInsideLiningMateStkNo",tgInsideLiningMateName + " " + optionBranchDetailName);
//			}
//			if(tgFrontBtnMateStkNo != null && tgFrontBtnMateStkNo.equals(optionBranchDetailCode)) {
//				tuxedoGlMaterialMap.put("tgFrontBtnMateStkNo",tgFrontBtnMateName + " " + optionBranchDetailName);
//			}
//		}
//		return tuxedoGlMaterialMap;
//	}
//	
//	/**
//	 * タキシードPANTS素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectTuxedoPtMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> tuxedoPtMaterialMap = new HashMap<String,String>();
//		//PT釦素材
//		String tpBtnMateStkNo = orderForm.getOptionPantsTuxedoInfo().getTpBtnMateStkNo();
//		String tpButtonName = orderForm.getOptionPantsTuxedoInfo().getTpButtonMap().get(orderForm.getOptionPantsTuxedoInfo().getTpButton());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(tpBtnMateStkNo != null && tpBtnMateStkNo.equals(optionBranchDetailCode)) {
//				tuxedoPtMaterialMap.put("tpBtnMateStkNo",tpButtonName + " " + optionBranchDetailName);
//				break;
//			}
//		}
//		return tuxedoPtMaterialMap;
//	}
//	
//	/**
//	 * タキシード2PANTS素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectTuxedoPt2MaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> tuxedoPt2MaterialMap = new HashMap<String,String>();
//		//PT2釦素材
//		String tp2BtnMateStkNo = orderForm.getOptionPants2TuxedoInfo().getTp2BtnMateStkNo();
//		String tp2ButtonName = orderForm.getOptionPants2TuxedoInfo().getTp2ButtonMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2Button());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(tp2BtnMateStkNo != null && tp2BtnMateStkNo.equals(optionBranchDetailCode)) {
//				tuxedoPt2MaterialMap.put("tp2BtnMateStkNo",tp2ButtonName + " " + optionBranchDetailName);
//				break;
//			}
//			
//		}
//		return tuxedoPt2MaterialMap;
//	}
//		
//	/**
//	 *  ウォッシャブルJACKET素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectWashableJkMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> washableJkMaterialMap = new HashMap<String,String>();
//		//JK胴裏素材
//		String wjBodyBackMateStkNo = orderForm.getOptionJacketWashableInfo().getWjBodyBackMateStkNo();
//		String wjBodyBackMateName = orderForm.getOptionJacketWashableInfo().getWjBodyBackMateMap().get(orderForm.getOptionJacketWashableInfo().getWjBodyBackMate());
//		//JK袖裏素材
//		String wjCuffBackMateStkNo = orderForm.getOptionJacketWashableInfo().getWjCuffBackMateStkNo();
//		String wjCuffBackMateName = orderForm.getOptionJacketWashableInfo().getWjCuffBackMateMap().get(orderForm.getOptionJacketWashableInfo().getWjCuffBackMate());
//		//JK釦素材
//		String wjBtnMateStkNo = orderForm.getOptionJacketWashableInfo().getWjBtnMateStkNo();
//		String wjBtnMateName = orderForm.getOptionJacketWashableInfo().getWjBtnMateMap().get(orderForm.getOptionJacketWashableInfo().getWjBtnMate());
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(wjBodyBackMateStkNo != null && wjBodyBackMateStkNo.equals(optionBranchDetailCode)) {
//				washableJkMaterialMap.put("wjBodyBackMateStkNo",wjBodyBackMateName + " " + optionBranchDetailName);
//			}
//			else if(wjCuffBackMateStkNo != null && wjCuffBackMateStkNo.equals(optionBranchDetailCode)) {
//				washableJkMaterialMap.put("wjCuffBackMateStkNo",wjCuffBackMateName + " " + optionBranchDetailName);
//			}
//			else if(wjBtnMateStkNo != null && wjBtnMateStkNo.equals(optionBranchDetailCode)) {
//				washableJkMaterialMap.put("wjBtnMateStkNo",wjBtnMateName + " " + optionBranchDetailName);
//			}
//		}
//		return washableJkMaterialMap;
//	}
//	
//	/**
//	 * ウォッシャブルGILET素材名
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectWashableGlMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> washableGlMaterialMap = new HashMap<String,String>();
//		//GL背裏地素材
//		String wgBackLiningMateStkNo = orderForm.getOptionGiletWashableInfo().getWgBackLiningMateStkNo();
//		String wgBackLiningMateName = orderForm.getOptionGiletWashableInfo().getWgBackLiningMateMap().get(orderForm.getOptionGiletWashableInfo().getWgBackLiningMate());
//		//GL内側裏地素材
//		String wgInsideLiningMateStkNo = orderForm.getOptionGiletWashableInfo().getWgInsideLiningMateStkNo();
//		String wgInsideLiningMateName = orderForm.getOptionGiletWashableInfo().getWgInsideLiningMateMap().get(orderForm.getOptionGiletWashableInfo().getWgInsideLiningMate());
//		//GLフロント釦
//		String wgFrontBtnMateStkNo = orderForm.getOptionGiletWashableInfo().getWgFrontBtnMateStkNo();
//		String wgFrontBtnMateName = orderForm.getOptionGiletWashableInfo().getWgFrontBtnMateMap().get(orderForm.getOptionGiletWashableInfo().getWgFrontBtnMate());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(wgBackLiningMateStkNo != null && wgBackLiningMateStkNo.equals(optionBranchDetailCode)) {
//				washableGlMaterialMap.put("wgBackLiningMateStkNo",wgBackLiningMateName + " " + optionBranchDetailName);
//			}
//			if(wgInsideLiningMateStkNo != null && wgInsideLiningMateStkNo.equals(optionBranchDetailCode)) {
//				washableGlMaterialMap.put("wgInsideLiningMateStkNo",wgInsideLiningMateName + " " + optionBranchDetailName);
//			}
//			if(wgFrontBtnMateStkNo != null && wgFrontBtnMateStkNo.equals(optionBranchDetailCode)) {
//				washableGlMaterialMap.put("wgFrontBtnMateStkNo",wgFrontBtnMateName + " " + optionBranchDetailName);
//			}
//		}
//		return washableGlMaterialMap;
//	}
//	
//	/**
//	 *ウォッシャブルPANTS素材名 
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectWashablePtMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> washablePtMaterialMap = new HashMap<String,String>();
//		//PT釦素材
//		String wpBtnMateStkNo = orderForm.getOptionPantsWashableInfo().getWpBtnMateStkNo();
//		String wpButtonName = orderForm.getOptionPantsWashableInfo().getWpButtonMap().get(orderForm.getOptionPantsWashableInfo().getWpButton());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(wpBtnMateStkNo != null && wpBtnMateStkNo.equals(optionBranchDetailCode)) {
//				washablePtMaterialMap.put("wpBtnMateStkNo",wpButtonName + " " + optionBranchDetailName);
//			}
//		}
//		return washablePtMaterialMap;
//	}
//	
//	/**
//	 * ウォッシャブル2PANTS素材名 
//	 * @param mateList
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String, String> selectWashablePt2MaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
//		Map<String,String> washablePt2MaterialMap = new HashMap<String,String>();
//		//PT2釦素材
//		String wp2BtnMateStkNo = orderForm.getOptionPants2WashableInfo().getWp2BtnMateStkNo();
//		String wp2ButtonName = orderForm.getOptionPants2WashableInfo().getWp2ButtonMap().get(orderForm.getOptionPants2WashableInfo().getWp2Button());
//		
//		for(OptionBranchDetail mate : mateList) {
//			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
//			String optionBranchDetailName = mate.getOptionBranchDetailName();
//			if(wp2BtnMateStkNo != null && wp2BtnMateStkNo.equals(optionBranchDetailCode)) {
//				washablePt2MaterialMap.put("wp2BtnMateStkNo",wp2ButtonName + " " + optionBranchDetailName);
//			}
//		}
//		return washablePt2MaterialMap;
//	}

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
	
//	/**
//	 * オーダー内容確認画面標準のPANTS上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> standardPantsUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// PANTSのsubItemCodeの取得
//		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
//		//PANTSのmodelCodeの取得
//		String modelCode = orderForm.getOptionPantsStandardInfo().getOpPantsModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
//		String className = ItemClassStandardEnum.ITEM_CODE_PANTS.getValue();
//		
//		Map<String,String> pantsUpperPriceMap = new HashMap<String,String>();
//				
//		PantsCoOptionStandardUpperPriceEnum[] pantsCoOptionStandardUpperPriceEnum = PantsCoOptionStandardUpperPriceEnum.values();
//		
//		for(PantsCoOptionStandardUpperPriceEnum PantsCoOptionStandardUpperPrice : pantsCoOptionStandardUpperPriceEnum) {
//			String optionCode = PantsCoOptionStandardUpperPrice.getKey();
//			String optionBranchCode = PantsCoOptionStandardUpperPrice.getValueOne();
//			String optionBranchDetailCode = PantsCoOptionStandardUpperPrice.getValueTwo();
//			String mapOfKey = PantsCoOptionStandardUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsStandardInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPantsStandardInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//							pantsUpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							pantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//						}
//						break;
//					}
//					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//							pantsUpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							pantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//						}
//						break;
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return pantsUpperPriceMap;
//	}
//	
//	/**
//	 * オーダー内容確認画面標準の2PANTS上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> standardPants2UpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// 2PANTSのsubItemCodeの取得
//		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
//		//2PANTSのmodelCodeの取得
//		String modelCode = orderForm.getOptionPants2StandardInfo().getOp2PantsModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfoの取得
//		String className = ItemClassStandardEnum.ITEM_CODE_PANTS2.getValue();
//		
//		Map<String,String> pants2UpperPriceMap = new HashMap<String,String>();
//				
//		Pants2CoOptionStandardUpperPriceEnum[] pants2CoOptionStandardUpperPriceEnum = Pants2CoOptionStandardUpperPriceEnum.values();
//		
//		for(Pants2CoOptionStandardUpperPriceEnum pants2CoOptionStandardUpperPrice : pants2CoOptionStandardUpperPriceEnum) {
//			String optionCode = pants2CoOptionStandardUpperPrice.getKey();
//			String optionBranchCode = pants2CoOptionStandardUpperPrice.getValueOne();
//			String optionBranchDetailCode = pants2CoOptionStandardUpperPrice.getValueTwo();
//			String mapOfKey = pants2CoOptionStandardUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2StandardInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPants2StandardInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//							pants2UpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							pants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//						}
//						break;
//					}
//					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//							pants2UpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							pants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//						}
//						break;
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return pants2UpperPriceMap;
//	}
//	
//	/**
//	 * オーダー内容確認画面標準のjacket上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> standardJacketUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		
//		Map<String,String> jacketUpperPriceMap = new HashMap<String,String>();
//		
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// JACKETのsubItemCodeの取得
//		String subItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
//		//JACKETのmodelCodeの取得
//		String modelCode = orderForm.getOptionJacketStandardInfo().getOjJacketModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
//		String className = ItemClassStandardEnum.ITEM_CODE_JACKET.getValue();
//		//フロント釦数
//		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
//		//0000105(ダブル6つボタン)
//		String ojFrontBtnCntdoubleSixButton = "0000105";
//		//0000106(ダブル4つボタン)
//		String ojFrontBtnCntdoubleFourButton = "0000106";
//				
//		JacketCoOptionStandardUpperPriceEnum[] jacketCoOptionStandardUpperPriceEnum = JacketCoOptionStandardUpperPriceEnum.values();
//		
//		for(JacketCoOptionStandardUpperPriceEnum jacketCoOptionStandardUpperPrice : jacketCoOptionStandardUpperPriceEnum) {
//			String optionCode = jacketCoOptionStandardUpperPrice.getKey();
//			String optionBranchCode = jacketCoOptionStandardUpperPrice.getValueOne();
//			String OptionBranchDetailCode = jacketCoOptionStandardUpperPrice.getValueTwo();
//			String mapOfKey = jacketCoOptionStandardUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, OptionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketStandardInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketStandardInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(ojFrontBtnCntdoubleSixButton.equals(ojFrontBtnCnt) || ojFrontBtnCntdoubleFourButton.equals(ojFrontBtnCnt)) {
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
//								jacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								jacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
//								jacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								jacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
//							}
//							break;
//						}
//					}
//					else{
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//								jacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								jacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//								jacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								jacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//							}
//							break;
//						}
//					}
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return jacketUpperPriceMap;
//	}
//	
//	/**
//	 * オーダー内容確認画面標準のGILET上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> standardGiletUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// GILETのsubItemCodeの取得
//		String subItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
//		//GILETのmodelCodeの取得
//		String modelCode = orderForm.getOptionGiletStandardInfo().getOgGiletModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
//		String className = ItemClassStandardEnum.ITEM_CODE_GILET.getValue();
//		//GILETモデル
//		String OgGiletModel = orderForm.getOptionGiletStandardInfo().getOgGiletModelMap().get(orderForm.getOptionGiletStandardInfo().getOgGiletModel());
//		//BS01-D
//		String bs01dModel = "BS01-D";
//		//ET15-D
//		String et15dModel = "ET15-D";
//		
//		Map<String,String> giletUpperPriceMap = new HashMap<String,String>();
//				
//		GiletCoOptionStandardNextUpperPriceEnum[] giletCoOptionStandardNextUpperPriceEnum = GiletCoOptionStandardNextUpperPriceEnum.values();
//		
//		for(GiletCoOptionStandardNextUpperPriceEnum giletCoOptionStandardNextUpperPrice : giletCoOptionStandardNextUpperPriceEnum) {
//			String optionCode = giletCoOptionStandardNextUpperPrice.getKey();
//			String optionBranchCode = giletCoOptionStandardNextUpperPrice.getValueOne();
//			String optionBranchDetailCode = giletCoOptionStandardNextUpperPrice.getValueTwo();
//			String mapOfKey = giletCoOptionStandardNextUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletStandardInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletStandardInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo !=null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(bs01dModel.equals(OgGiletModel) || et15dModel.equals(OgGiletModel)) {
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
//								giletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								giletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
//								giletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								giletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
//							}
//							break;
//						}
//					}
//					else{
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//								giletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								giletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//								giletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								giletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//							}
//							break;
//						}
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return giletUpperPriceMap;
//	}
//	
//	/**
//	 * オーダー内容確認画面標準のCOAT上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> standardCoatUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// COATのsubItemCodeの取得
//		String subItemCode = ItemClassStandardEnum.ITEM_CODE_COAT.getKey();
//		//COATのmodelCodeの取得
//		String modelCode = orderForm.getOptionCoatStandardInfo().getCoatModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionCoatStandardInfoの取得
//		String className = ItemClassStandardEnum.ITEM_CODE_COAT.getValue();
//		//DoubleChester(ダブルチェスター)
//		String DoubleChester = "DoubleChester";
//		//DoublePolo(ダブルポロ)
//		String DoublePolo = "DoublePolo";
//		
//		Map<String,String> coatUpperPriceMap = new HashMap<String,String>();
//				
//		CoatCoOptionStandardUpperPriceEnum[] coatCoOptionStandardUpperPriceEnum = CoatCoOptionStandardUpperPriceEnum.values();
//		
//		for(CoatCoOptionStandardUpperPriceEnum coatCoOptionStandardUpperPrice : coatCoOptionStandardUpperPriceEnum) {
//			String optionCode = coatCoOptionStandardUpperPrice.getKey();
//			String optionBranchCode = coatCoOptionStandardUpperPrice.getValueOne();
//			String optionBranchDetailCode = coatCoOptionStandardUpperPrice.getValueTwo();
//			String mapOfKey = coatCoOptionStandardUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionCoatStandardInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionCoatStandardInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(DoubleChester.equals(modelCode) || DoublePolo.equals(modelCode)) {
//						if(priceKeyCode.equals(orderCodePrice.getOrderBranchDoublePrice())) {
//							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//								coatUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								coatUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
//								coatUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								coatUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
//							}
//							break;
//						}
//					}
//					else {
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//								coatUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								coatUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//								coatUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								coatUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//							}
//							break;
//						}
//						
//					}
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//		}
//		return coatUpperPriceMap;
//	}

	
//	/**
//	 * オーダー内容確認画面標準のSHIRT上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> standardShirtUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// SHIRTのsubItemCodeの取得
//		String subItemCode = ItemClassStandardEnum.ITEM_CODE_SHIRTS.getKey();
//		//SHIRTのmodelCodeの取得
//		String modelCode = orderForm.getOptionShirtStandardInfo().getOsShirtModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionShirtStandardInfoの取得
//		String className = ItemClassStandardEnum.ITEM_CODE_SHIRTS.getValue();
//		
//		Map<String,String> shirtUpperPriceMap = new HashMap<String,String>();
//				
//		ShirtCoOptionStandardUpperPriceEnum[] shirtCoOptionStandardUpperPriceEnum = ShirtCoOptionStandardUpperPriceEnum.values();
//		
//		for(ShirtCoOptionStandardUpperPriceEnum shirtCoOptionStandardUpperPrice : shirtCoOptionStandardUpperPriceEnum) {
//			String optionCode = shirtCoOptionStandardUpperPrice.getKey();
//			String optionBranchCode = shirtCoOptionStandardUpperPrice.getValueOne();
//			String mapOfKey = shirtCoOptionStandardUpperPrice.getValueTwo();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Object[] args = {};
//				Object resultOne = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionShirtStandardInfo(), args);
//				}
//				
//				String priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//							shirtUpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							shirtUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//						}
//						break;
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return shirtUpperPriceMap;
//	}
//	
//	/**
//	 * オーダー内容確認画面タキシードのjacket上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> tuxedoJacketUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		
//		Map<String,String> tuxedoJacketUpperPriceMap = new HashMap<String,String>();
//		
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// JACKETのsubItemCodeの取得
//		String subItemCode = ItemClassTuxedoEnum.ITEM_CODE_JACKET.getKey();
//		//JACKETのmodelCodeの取得
//		String modelCode = orderForm.getOptionJacketTuxedoInfo().getTjJacketModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
//		String className = ItemClassTuxedoEnum.ITEM_CODE_JACKET.getValue();
//		//フロント釦数
//		String tjFrontBtnCnt = orderForm.getOptionJacketTuxedoInfo().getTjFrontBtnCnt();
//		//0000105(ダブル6つボタン)
//		String tjFrontBtnCntdoubleSixButton = "0000105";
//		//0000106(ダブル4つボタン)
//		String tjFrontBtnCntdoubleFourButton = "0000106";
//				
//		JacketCoOptionTuxedoUpperPriceEnum[] jacketCoOptionTuxedoUpperPriceEnum = JacketCoOptionTuxedoUpperPriceEnum.values();
//		
//		for(JacketCoOptionTuxedoUpperPriceEnum jacketCoOptionTuxedoUpperPrice : jacketCoOptionTuxedoUpperPriceEnum) {
//			String optionCode = jacketCoOptionTuxedoUpperPrice.getKey();
//			String optionBranchCode = jacketCoOptionTuxedoUpperPrice.getValueOne();
//			String optionBranchDetailCode = jacketCoOptionTuxedoUpperPrice.getValueTwo();
//			String mapOfKey = jacketCoOptionTuxedoUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketTuxedoInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketTuxedoInfo(), argsT);
//				}
//				
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(tjFrontBtnCntdoubleSixButton.equals(tjFrontBtnCnt) || tjFrontBtnCntdoubleFourButton.equals(tjFrontBtnCnt)) {
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
//								tuxedoJacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								tuxedoJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())){
//							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
//								tuxedoJacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								tuxedoJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
//							}
//							break;
//						}
//					}
//					else{
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//								tuxedoJacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								tuxedoJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())){
//							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//								tuxedoJacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								tuxedoJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//							}
//							break;
//						}
//					}
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return tuxedoJacketUpperPriceMap;
//	}
//	
//	
//	/**
//	 * オーダー内容確認画面タキシードのGILET上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> tuxedoGiletUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// GILETのsubItemCodeの取得
//		String subItemCode = ItemClassTuxedoEnum.ITEM_CODE_GILET.getKey();
//		//GILETのmodelCodeの取得
//		String modelCode = orderForm.getOptionGiletTuxedoInfo().getTgGiletModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
//		String className = ItemClassTuxedoEnum.ITEM_CODE_GILET.getValue();
//		//GILETモデル
//		String tgGiletModel = orderForm.getOptionGiletTuxedoInfo().getTgGiletModelMap().get(orderForm.getOptionGiletTuxedoInfo().getTgGiletModel());
//		//BS01-D
//		String bs01dModel = "BS01-D";
//		//ET15-D
//		String et15dModel = "ET15-D";
//		
//		Map<String,String> tuxedoGiletUpperPriceMap = new HashMap<String,String>();
//				
//		GiletCoOptionTuxedoUpperPriceEnum[] giletCoOptionTuxedoUpperPriceEnum = GiletCoOptionTuxedoUpperPriceEnum.values();
//		
//		for(GiletCoOptionTuxedoUpperPriceEnum giletCoOptionTuxedoUpperPrice : giletCoOptionTuxedoUpperPriceEnum) {
//			String optionCode = giletCoOptionTuxedoUpperPrice.getKey();
//			String optionBranchCode = giletCoOptionTuxedoUpperPrice.getValueOne();
//			String optionBranchDetailCode = giletCoOptionTuxedoUpperPrice.getValueTwo();
//			String mapOfKey = giletCoOptionTuxedoUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletTuxedoInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletTuxedoInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(bs01dModel.equals(tgGiletModel) || et15dModel.equals(tgGiletModel)) {
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
//								tuxedoGiletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								tuxedoGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
//								tuxedoGiletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								tuxedoGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
//							}
//							break;
//						}
//					}
//					else{
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//								tuxedoGiletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								tuxedoGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//								tuxedoGiletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								tuxedoGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//							}
//							break;
//						}
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return tuxedoGiletUpperPriceMap;
//	}
	
//	/**
//	 * オーダー内容確認画面タキシードのPANTS上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> tuxedoPantsUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// PANTSのsubItemCodeの取得
//		String subItemCode = ItemClassTuxedoEnum.ITEM_CODE_PANTS.getKey();
//		//PANTSのmodelCodeの取得
//		String modelCode = orderForm.getOptionPantsTuxedoInfo().getTpPantsModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
//		String className = ItemClassTuxedoEnum.ITEM_CODE_PANTS.getValue();
//		
//		Map<String,String> tuxedoPantsUpperPriceMap = new HashMap<String,String>();
//				
//		PantsCoOptionTuxedoUpperPriceEnum[] pantsCoOptionTuxedoUpperPriceEnum = PantsCoOptionTuxedoUpperPriceEnum.values();
//		
//		for(PantsCoOptionTuxedoUpperPriceEnum pantsCoOptionTuxedoUpperPrice : pantsCoOptionTuxedoUpperPriceEnum) {
//			String optionCode = pantsCoOptionTuxedoUpperPrice.getKey();
//			String optionBranchCode = pantsCoOptionTuxedoUpperPrice.getValueOne();
//			String optionBranchDetailCode = pantsCoOptionTuxedoUpperPrice.getValueTwo();
//			String mapOfKey = pantsCoOptionTuxedoUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsTuxedoInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPantsTuxedoInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//							tuxedoPantsUpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							tuxedoPantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//						}
//						break;
//					}
//					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//							tuxedoPantsUpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							tuxedoPantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//						}
//						break;
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return tuxedoPantsUpperPriceMap;
//	}
//	
//	/**
//	 * オーダー内容確認画面タキシードの2PANTS上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> tuxedoPants2UpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// PANTSのsubItemCodeの取得
//		String subItemCode = ItemClassTuxedoEnum.ITEM_CODE_PANTS2.getKey();
//		//PANTSのmodelCodeの取得
//		String modelCode = orderForm.getOptionPants2TuxedoInfo().getTp2PantsModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
//		String className = ItemClassTuxedoEnum.ITEM_CODE_PANTS2.getValue();
//		
//		Map<String,String> tuxedoPants2UpperPriceMap = new HashMap<String,String>();
//				
//		Pants2CoOptionTuxedoUpperPriceEnum[] pants2CoOptionTuxedoUpperPriceEnum = Pants2CoOptionTuxedoUpperPriceEnum.values();
//		
//		for(Pants2CoOptionTuxedoUpperPriceEnum pants2CoOptionTuxedoUpperPrice : pants2CoOptionTuxedoUpperPriceEnum) {
//			String optionCode = pants2CoOptionTuxedoUpperPrice.getKey();
//			String optionBranchCode = pants2CoOptionTuxedoUpperPrice.getValueOne();
//			String optionBranchDetailCode = pants2CoOptionTuxedoUpperPrice.getValueTwo();
//			String mapOfKey = pants2CoOptionTuxedoUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2TuxedoInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPants2TuxedoInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//							tuxedoPants2UpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							tuxedoPants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//						}
//						break;
//					}
//					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//							tuxedoPants2UpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							tuxedoPants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//						}
//						break;
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return tuxedoPants2UpperPriceMap;
//	}
//	
//	/**
//	 * オーダー内容確認画面ウォッシャブルのjacket上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> washableJacketUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		
//		Map<String,String> washableJacketUpperPriceMap = new HashMap<String,String>();
//		
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// JACKETのsubItemCodeの取得
//		String subItemCode = ItemClassWashableEnum.ITEM_CODE_JACKET.getKey();
//		//JACKETのmodelCodeの取得
//		String modelCode = orderForm.getOptionJacketWashableInfo().getWjJacketModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
//		String className = ItemClassWashableEnum.ITEM_CODE_JACKET.getValue();
//		//フロント釦数
//		String WjFrontBtnCnt = orderForm.getOptionJacketWashableInfo().getWjFrontBtnCnt();
//		//0000105(ダブル6つボタン)
//		String wjFrontBtnCntdoubleSixButton = "0000105";
//		//0000106(ダブル4つボタン)
//		String wjFrontBtnCntdoubleFourButton = "0000106";
//				
//		JacketCoOptionWashableUpperPriceEnum[] jacketCoOptionWashableUpperPriceEnum = JacketCoOptionWashableUpperPriceEnum.values();
//		
//		for(JacketCoOptionWashableUpperPriceEnum jacketCoOptionWashableUpperPrice : jacketCoOptionWashableUpperPriceEnum) {
//			String optionCode = jacketCoOptionWashableUpperPrice.getKey();
//			String optionBranchCode = jacketCoOptionWashableUpperPrice.getValueOne();
//			String optionBranchDetailCode = jacketCoOptionWashableUpperPrice.getValueTwo();
//			String mapOfKey = jacketCoOptionWashableUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketWashableInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketWashableInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(wjFrontBtnCntdoubleSixButton.equals(WjFrontBtnCnt) || wjFrontBtnCntdoubleFourButton.equals(WjFrontBtnCnt)) {
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
//								washableJacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								washableJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
//								washableJacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								washableJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
//							}
//							break;
//						}
//					}
//					else{
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//								washableJacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								washableJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//								washableJacketUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								washableJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//							}
//							break;
//						}
//					}
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return washableJacketUpperPriceMap;
//	}
//	
//	
//	/**
//	 * オーダー内容確認画面ウォッシャブルのGILET上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> washableGiletUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// GILETのsubItemCodeの取得
//		String subItemCode = ItemClassWashableEnum.ITEM_CODE_GILET.getKey();
//		//GILETのmodelCodeの取得
//		String modelCode = orderForm.getOptionGiletWashableInfo().getWgGiletModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
//		String className = ItemClassWashableEnum.ITEM_CODE_GILET.getValue();
//		//GILETモデル
//		String wgGiletModel = orderForm.getOptionGiletWashableInfo().getWgGiletModelMap().get(orderForm.getOptionGiletWashableInfo().getWgGiletModel());
//		//BS01-D
//		String bs01dModel = "BS01-D";
//		//ET15-D
//		String et15dModel = "ET15-D";
//		
//		Map<String,String> washableGiletUpperPriceMap = new HashMap<String,String>();
//				
//		GiletCoOptionWashableUpperPriceEnum[] giletCoOptionWashableUpperPriceEnum = GiletCoOptionWashableUpperPriceEnum.values();
//		
//		for(GiletCoOptionWashableUpperPriceEnum giletCoOptionWashableUpperPrice : giletCoOptionWashableUpperPriceEnum) {
//			String optionCode = giletCoOptionWashableUpperPrice.getKey();
//			String optionBranchCode = giletCoOptionWashableUpperPrice.getValueOne();
//			String optionBranchDetailCode = giletCoOptionWashableUpperPrice.getValueTwo();
//			String mapOfKey = giletCoOptionWashableUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletWashableInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletWashableInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(bs01dModel.equals(wgGiletModel) || et15dModel.equals(wgGiletModel)) {
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
//								washableGiletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								washableGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
//								washableGiletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								washableGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
//							}
//							break;
//						}
//					}
//					else{
//						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//								washableGiletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								washableGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//							}
//							break;
//						}
//						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//								washableGiletUpperPriceMap.put(mapOfKey, "無料");
//							}
//							else {
//								washableGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//							}
//							break;
//						}
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return washableGiletUpperPriceMap;
//	}
//	
//	/**
//	 * オーダー内容確認画面ウォッシャブルのPANTS上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> washablePantsUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// PANTSのsubItemCodeの取得
//		String subItemCode = ItemClassWashableEnum.ITEM_CODE_PANTS.getKey();
//		//PANTSのmodelCodeの取得
//		String modelCode = orderForm.getOptionPantsWashableInfo().getWpPantsModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
//		String className = ItemClassWashableEnum.ITEM_CODE_PANTS.getValue();
//		
//		Map<String,String> washablePantsUpperPriceMap = new HashMap<String,String>();
//				
//		PantsCoOptionWashableUpperPriceEnum[] pantsCoOptionWashableUpperPriceEnum = PantsCoOptionWashableUpperPriceEnum.values();
//		
//		for(PantsCoOptionWashableUpperPriceEnum pantsCoOptionWashableUpperPrice : pantsCoOptionWashableUpperPriceEnum) {
//			String optionCode = pantsCoOptionWashableUpperPrice.getKey();
//			String optionBranchCode = pantsCoOptionWashableUpperPrice.getValueOne();
//			String optionBranchDetailCode = pantsCoOptionWashableUpperPrice.getValueTwo();
//			String mapOfKey = pantsCoOptionWashableUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsWashableInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPantsWashableInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//							washablePantsUpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							washablePantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//						}
//						break;
//					}
//					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//							washablePantsUpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							washablePantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//						}
//						break;
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return washablePantsUpperPriceMap;
//	}
//	
//	/**
//	 * オーダー内容確認画面ウォッシャブルの2PANTS上代
//	 * @param orderForm
//	 * @param optionBranchPriceList
//	 * @return
//	 */
//	public Map<String,String> washablePants2UpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
//		// itemCodeの取得
//		String itemCode = orderForm.getProductItem();
//		// PANTSのsubItemCodeの取得
//		String subItemCode = ItemClassWashableEnum.ITEM_CODE_PANTS2.getKey();
//		//PANTSのmodelCodeの取得
//		String modelCode = orderForm.getOptionPants2WashableInfo().getWp2PantsModel();
//		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
//		String className = ItemClassWashableEnum.ITEM_CODE_PANTS2.getValue();
//		
//		Map<String,String> washablePants2UpperPriceMap = new HashMap<String,String>();
//				
//		Pants2CoOptionWashableUpperPriceEnum[] pants2CoOptionWashableUpperPriceEnum = Pants2CoOptionWashableUpperPriceEnum.values();
//		
//		for(Pants2CoOptionWashableUpperPriceEnum pants2CoOptionWashableUpperPrice : pants2CoOptionWashableUpperPriceEnum) {
//			String optionCode = pants2CoOptionWashableUpperPrice.getKey();
//			String optionBranchCode = pants2CoOptionWashableUpperPrice.getValueOne();
//			String optionBranchDetailCode = pants2CoOptionWashableUpperPrice.getValueTwo();
//			String mapOfKey = pants2CoOptionWashableUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName(className);
//				Method myMethodOne = getMethod(cls, optionBranchCode);
//				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
//				Object[] args = {};
//				Object[] argsT = {};
//				Object resultOne = null;
//				Object resultTwo = null;
//				if (myMethodOne != null) {
//					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2WashableInfo(), args);
//				}
//				if (myMethodTwo != null) {
//					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPants2WashableInfo(), argsT);
//				}
//				String priceKeyCode = null;
//				if(resultTwo != null) {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
//				}
//				else {
//					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
//				}
//				
//				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
//					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
//							washablePants2UpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							washablePants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
//						}
//						break;
//					}
//					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
//						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
//							washablePants2UpperPriceMap.put(mapOfKey, "無料");
//						}
//						else {
//							washablePants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
//						}
//						break;
//					}
//				}
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//			
//		}
//		return washablePants2UpperPriceMap;
//	}
	
//	/**
//	 * 
//	 * @param InDbList
//	 * @return
//	 */
//	public String severalCodeInDb(List<String> InDbList) {
//		StringBuffer stringbufferCodeValue = new StringBuffer();
//		for(String simpleCodeValue : InDbList) {
//			stringbufferCodeValue.append(",").append(simpleCodeValue);
//		}
//		String stringCode = stringbufferCodeValue.toString();
//		String substrCode = null;
//		if(stringCode != null && !stringCode.isEmpty()) {
//			substrCode = stringCode.substring(1);
//		}
//		return substrCode;
//	}
//	
//	/**
//	 * 
//	 * @param InDbList
//	 * @param ojInsidePktPlaceMap
//	 * @return
//	 */
//	public String severalNameInDb(List<String> InDbList,Map<String, String> ojInsidePktPlaceMap) {
//		StringBuffer stringbufferNameValue = new StringBuffer();
//		for(String simpleNameValue : InDbList) {
//			String simpleName = ojInsidePktPlaceMap.get(simpleNameValue);
//			stringbufferNameValue.append(",").append(simpleName);
//		}
//		String stringName = stringbufferNameValue.toString();
//		String substrName = null;
//		if(stringName != null && !stringName.isEmpty()) {
//			substrName= stringName.substring(1);
//		}
//		return substrName;
//	}
	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void aboutJacketCheckBoxInDb(OrderForm orderForm,Order order) {
//		
//		//標準JACKETの内ポケット変更
//		String ojInsidePktPlace1 = orderForm.getOptionJacketStandardInfo().getOjInsidePktPlace1();
//		String ojInsidePktPlace2 = orderForm.getOptionJacketStandardInfo().getOjInsidePktPlace2();
//		String ojInsidePktPlace3 = orderForm.getOptionJacketStandardInfo().getOjInsidePktPlace3();
//		String ojInsidePktPlace4 = orderForm.getOptionJacketStandardInfo().getOjInsidePktPlace4();
//		
//		List<String> ojInsidePktPlaceList = new ArrayList<>();
//		ojInsidePktPlaceList.add(ojInsidePktPlace1);
//		ojInsidePktPlaceList.add(ojInsidePktPlace2);
//		ojInsidePktPlaceList.add(ojInsidePktPlace3);
//		ojInsidePktPlaceList.add(ojInsidePktPlace4);
//		ojInsidePktPlaceList.removeAll(Collections.singleton(null));
//		if(!ojInsidePktPlaceList.isEmpty()) {
//			//JACKET_内ポケット変更_コード
//			String severalCodeInDb = severalCodeInDb(ojInsidePktPlaceList);
//			order.setJkInnerPktCd(severalCodeInDb);
//			//JACKET_内ポケット変更_名
//			Map<String, String> ojInsidePktPlaceMap = orderForm.getOptionJacketStandardInfo().getOjInsidePktPlaceMap();
//			String severalNameInDb = severalNameInDb(ojInsidePktPlaceList, ojInsidePktPlaceMap);
//			order.setJkInnerPktNm(severalNameInDb);
//		}
//		
//		//標準JACKETのステッチ箇所変更
//		String ojStitchModifyPlace1 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace1();
//		String ojStitchModifyPlace2 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace2();
//		String ojStitchModifyPlace3 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace3();
//		String ojStitchModifyPlace4 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace4();
//		String ojStitchModifyPlace5 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace5();
//		String ojStitchModifyPlace6 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace6();
//		String ojStitchModifyPlace7 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace7();
//		String ojStitchModifyPlace8 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace8();
//		String ojStitchModifyPlace9 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace9();
//		
//		List<String> ojStitchModifyPlaceList = new ArrayList<>();
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace1);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace2);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace3);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace4);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace5);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace6);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace7);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace8);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace9);
//		ojStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		
//		//JACKET_ステッチ箇所変更_コード
//		String ojStitchModifyPlaceCodeInDb = severalCodeInDb(ojStitchModifyPlaceList);
//		order.setJkStitchPlcCd(ojStitchModifyPlaceCodeInDb);
//		//JACKET_ステッチ箇所変更_名
//		Map<String, String> ojStitchModifyPlaceMap = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlaceMap();
//		String ojStitchModifyPlaceNameInDb= severalNameInDb(ojStitchModifyPlaceList, ojStitchModifyPlaceMap);
//		order.setJkStitchPlcNm(ojStitchModifyPlaceNameInDb);
//		
//		//標準JACKETのダブルステッチ変更
//		String ojDStitchModifyPlace1 = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlace1();
//		String ojDStitchModifyPlace2 = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlace2();
//		String ojDStitchModifyPlace3 = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlace3();
//		String ojDStitchModifyPlace4 = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlace4();
//		String ojDStitchModifyPlace5 = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlace5();
//		String ojDStitchModifyPlace6 = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlace6();
//		String ojDStitchModifyPlace7 = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlace7();
//		String ojDStitchModifyPlace8 = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlace8();
//		String ojDStitchModifyPlace9 = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlace9();
//		
//		List<String> ojDStitchModifyPlaceList = new ArrayList<>();
//		ojDStitchModifyPlaceList.add(ojDStitchModifyPlace1);
//		ojDStitchModifyPlaceList.add(ojDStitchModifyPlace2);
//		ojDStitchModifyPlaceList.add(ojDStitchModifyPlace3);
//		ojDStitchModifyPlaceList.add(ojDStitchModifyPlace4);
//		ojDStitchModifyPlaceList.add(ojDStitchModifyPlace5);
//		ojDStitchModifyPlaceList.add(ojDStitchModifyPlace6);
//		ojDStitchModifyPlaceList.add(ojDStitchModifyPlace7);
//		ojDStitchModifyPlaceList.add(ojDStitchModifyPlace8);
//		ojDStitchModifyPlaceList.add(ojDStitchModifyPlace9);
//		ojDStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		if(!ojDStitchModifyPlaceList.isEmpty()) {
//			//JACKET_ダブルステッチ_コード
//			String ojDStitchModifyPlaceCodeInDb = severalCodeInDb(ojDStitchModifyPlaceList);
//			order.setJkDblstitchPlcCd(ojDStitchModifyPlaceCodeInDb);
//			//JACKET_ダブルステッチ_名
//			Map<String, String> ojDStitchModifyPlaceMap = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyPlaceMap();
//			String ojDStitchModifyPlaceNameInDb = severalNameInDb(ojDStitchModifyPlaceList, ojDStitchModifyPlaceMap);
//			order.setJkDblstitchPlcNm(ojDStitchModifyPlaceNameInDb);
//		}
//		
//		//標準JACKETのAMF色指定
//		String ojAmfColorPlace1 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace1();
//		String ojAmfColorPlace2 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace2();
//		String ojAmfColorPlace3 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace3();
//		String ojAmfColorPlace4 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace4();
//		String ojAmfColorPlace5 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace5();
//		String ojAmfColorPlace6 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace6();
//		String ojAmfColorPlace7 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace7();
//		String ojAmfColorPlace8 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace8();
//		String ojAmfColorPlace9 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace9();
//		
//		List<String> ojAmfColorPlaceList = new ArrayList<>();
//		ojAmfColorPlaceList.add(ojAmfColorPlace1);
//		ojAmfColorPlaceList.add(ojAmfColorPlace2);
//		ojAmfColorPlaceList.add(ojAmfColorPlace3);
//		ojAmfColorPlaceList.add(ojAmfColorPlace4);
//		ojAmfColorPlaceList.add(ojAmfColorPlace5);
//		ojAmfColorPlaceList.add(ojAmfColorPlace6);
//		ojAmfColorPlaceList.add(ojAmfColorPlace7);
//		ojAmfColorPlaceList.add(ojAmfColorPlace8);
//		ojAmfColorPlaceList.add(ojAmfColorPlace9);
//		ojAmfColorPlaceList.removeAll(Collections.singleton(null));
//		if(!ojAmfColorPlaceList.isEmpty()) {
//			//JACKET_AMF色指定_箇所コード
//			String ojAmfColorPlaceCodeInDb = severalCodeInDb(ojAmfColorPlaceList);
//			order.setJkAmfColorPlcCd(ojAmfColorPlaceCodeInDb);
//			//JACKET_AMF色指定_箇所名
//			Map<String, String> ojAmfColorPlaceMap = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlaceMap();
//			String ojAmfColorPlaceNameInDb = severalNameInDb(ojAmfColorPlaceList, ojAmfColorPlaceMap);
//			order.setJkAmfColorPlcNm(ojAmfColorPlaceNameInDb);
//		}
//		
//		String ojAmfColor1 = orderForm.getOptionJacketStandardInfo().getOjAmfColor1();
//		String ojAmfColor2 = orderForm.getOptionJacketStandardInfo().getOjAmfColor2();
//		String ojAmfColor3 = orderForm.getOptionJacketStandardInfo().getOjAmfColor3();
//		String ojAmfColor4 = orderForm.getOptionJacketStandardInfo().getOjAmfColor4();
//		String ojAmfColor5 = orderForm.getOptionJacketStandardInfo().getOjAmfColor5();
//		String ojAmfColor6 = orderForm.getOptionJacketStandardInfo().getOjAmfColor6();
//		String ojAmfColor7 = orderForm.getOptionJacketStandardInfo().getOjAmfColor7();
//		String ojAmfColor8 = orderForm.getOptionJacketStandardInfo().getOjAmfColor8();
//		String ojAmfColor9 = orderForm.getOptionJacketStandardInfo().getOjAmfColor9();
//		
//		List<String> ojAmfColorsList = new ArrayList<>();
//		ojAmfColorsList.add(ojAmfColor1);
//		ojAmfColorsList.add(ojAmfColor2);
//		ojAmfColorsList.add(ojAmfColor3);
//		ojAmfColorsList.add(ojAmfColor4);
//		ojAmfColorsList.add(ojAmfColor5);
//		ojAmfColorsList.add(ojAmfColor6);
//		ojAmfColorsList.add(ojAmfColor7);
//		ojAmfColorsList.add(ojAmfColor8);
//		ojAmfColorsList.add(ojAmfColor9);
//		ojAmfColorsList.removeAll(Collections.singleton(null));
//		if(!ojAmfColorsList.isEmpty()) {
//			//JACKET_AMF色指定_色コード
//			String ojAmfColorsCodeInDb = severalCodeInDb(ojAmfColorsList);
//			order.setJkAmfColorCd(ojAmfColorsCodeInDb);
//			//JACKET_AMF色指定_色名
//			Map<String, String> ojAmfColorsMap = orderForm.getOptionJacketStandardInfo().getOjAmfColorsMap();
//			String ojAmfColorsNameInDb2 = severalNameInDb(ojAmfColorsList, ojAmfColorsMap);
//			order.setJkAmfColorNm(ojAmfColorsNameInDb2);
//		}
//		
//		//標準JACKETのボタンホール色指定
//		String ojBhColorPlace1 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace1();
//		String ojBhColorPlace2 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace2();
//		String ojBhColorPlace3 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace3();
//		String ojBhColorPlace4 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace4();
//		String ojBhColorPlace5 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace5();
//		String ojBhColorPlace6 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace6();
//		String ojBhColorPlace7 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace7();
//		String ojBhColorPlace8 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace8();
//		String ojBhColorPlace9 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace9();
//		String ojBhColorPlace10 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace10();
//		String ojBhColorPlace11 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace11();
//		String ojBhColorPlace12 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace12();
//		String ojBhColorPlace13 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace13();
//		String ojBhColorPlace14 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace14();
//		String ojBhColorPlace15 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace15();
//		String ojBhColorPlace16 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace16();
//		String ojBhColorPlace17 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace17();
//		
//		List<String> ojBhColorPlaceList = new ArrayList<>();
//		ojBhColorPlaceList.add(ojBhColorPlace1);
//		ojBhColorPlaceList.add(ojBhColorPlace2);
//		ojBhColorPlaceList.add(ojBhColorPlace3);
//		ojBhColorPlaceList.add(ojBhColorPlace4);
//		ojBhColorPlaceList.add(ojBhColorPlace5);
//		ojBhColorPlaceList.add(ojBhColorPlace6);
//		ojBhColorPlaceList.add(ojBhColorPlace7);
//		ojBhColorPlaceList.add(ojBhColorPlace8);
//		ojBhColorPlaceList.add(ojBhColorPlace9);
//		ojBhColorPlaceList.add(ojBhColorPlace10);
//		ojBhColorPlaceList.add(ojBhColorPlace11);
//		ojBhColorPlaceList.add(ojBhColorPlace12);
//		ojBhColorPlaceList.add(ojBhColorPlace13);
//		ojBhColorPlaceList.add(ojBhColorPlace14);
//		ojBhColorPlaceList.add(ojBhColorPlace15);
//		ojBhColorPlaceList.add(ojBhColorPlace16);
//		ojBhColorPlaceList.add(ojBhColorPlace17);
//		ojBhColorPlaceList.removeAll(Collections.singleton(null));
//		if(!ojBhColorPlaceList.isEmpty()) {
//			//JACKET_ボタンホール色指定_箇所コード
//			String ojBhColorPlaceCodeInDb = severalCodeInDb(ojBhColorPlaceList);
//			order.setJkBtnholeColorPlcCd(ojBhColorPlaceCodeInDb);
//			//JACKET_ボタンホール色指定_箇所名
//			Map<String, String> ojBhColorPlaceMap = orderForm.getOptionJacketStandardInfo().getOjBhColorPlaceMap();
//			String ojBhColorPlaceNameInDb = severalNameInDb(ojBhColorPlaceList, ojBhColorPlaceMap);
//			order.setJkBtnholeColorPlcN(ojBhColorPlaceNameInDb);
//		}
//		
//		String ojBhColor1 = orderForm.getOptionJacketStandardInfo().getOjBhColor1();
//		String ojBhColor2 = orderForm.getOptionJacketStandardInfo().getOjBhColor2();
//		String ojBhColor3 = orderForm.getOptionJacketStandardInfo().getOjBhColor3();
//		String ojBhColor4 = orderForm.getOptionJacketStandardInfo().getOjBhColor4();
//		String ojBhColor5 = orderForm.getOptionJacketStandardInfo().getOjBhColor5();
//		String ojBhColor6 = orderForm.getOptionJacketStandardInfo().getOjBhColor6();
//		String ojBhColor7 = orderForm.getOptionJacketStandardInfo().getOjBhColor7();
//		String ojBhColor8 = orderForm.getOptionJacketStandardInfo().getOjBhColor8();
//		String ojBhColor9 = orderForm.getOptionJacketStandardInfo().getOjBhColor9();
//		String ojBhColor10 = orderForm.getOptionJacketStandardInfo().getOjBhColor10();
//		String ojBhColor11 = orderForm.getOptionJacketStandardInfo().getOjBhColor11();
//		String ojBhColor12 = orderForm.getOptionJacketStandardInfo().getOjBhColor12();
//		String ojBhColor13 = orderForm.getOptionJacketStandardInfo().getOjBhColor13();
//		String ojBhColor14 = orderForm.getOptionJacketStandardInfo().getOjBhColor14();
//		String ojBhColor15 = orderForm.getOptionJacketStandardInfo().getOjBhColor15();
//		String ojBhColor16 = orderForm.getOptionJacketStandardInfo().getOjBhColor16();
//		String ojBhColor17 = orderForm.getOptionJacketStandardInfo().getOjBhColor17();
//
//		List<String> ojBhColorsList = new ArrayList<>();
//		ojBhColorsList.add(ojBhColor1);
//		ojBhColorsList.add(ojBhColor2);
//		ojBhColorsList.add(ojBhColor3);
//		ojBhColorsList.add(ojBhColor4);
//		ojBhColorsList.add(ojBhColor5);
//		ojBhColorsList.add(ojBhColor6);
//		ojBhColorsList.add(ojBhColor7);
//		ojBhColorsList.add(ojBhColor8);
//		ojBhColorsList.add(ojBhColor9);
//		ojBhColorsList.add(ojBhColor10);
//		ojBhColorsList.add(ojBhColor11);
//		ojBhColorsList.add(ojBhColor12);
//		ojBhColorsList.add(ojBhColor13);
//		ojBhColorsList.add(ojBhColor14);
//		ojBhColorsList.add(ojBhColor15);
//		ojBhColorsList.add(ojBhColor16);
//		ojBhColorsList.add(ojBhColor17);
//		ojBhColorsList.removeAll(Collections.singleton(null));
//		if(!ojBhColorsList.isEmpty()) {
//			//JACKET_ボタンホール色指定_色コード
//			String ojBhColorsCodeInDb = severalCodeInDb(ojBhColorsList);
//			order.setJkBtnholeColorCd(ojBhColorsCodeInDb);
//			//JACKET_ボタンホール色指定_色名
//			Map<String, String> ojBhColorsMap = orderForm.getOptionJacketStandardInfo().getOjBhColorsMap();
//			String ojBhColorsNameInDb = severalNameInDb(ojBhColorsList, ojBhColorsMap);
//			order.setJkBtnholeColorNm(ojBhColorsNameInDb);
//		}
//		
//		//標準JACKETのボタン付け糸指定
//		String ojByColorPlace1 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace1();
//		String ojByColorPlace2 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace2();
//		String ojByColorPlace3 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace3();
//		String ojByColorPlace4 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace4();
//		String ojByColorPlace5 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace5();
//		String ojByColorPlace6 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace6();
//		String ojByColorPlace7 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace7();
//		String ojByColorPlace8 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace8();
//		String ojByColorPlace9 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace9();
//		String ojByColorPlace10 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace10();
//		String ojByColorPlace11 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace11();
//		String ojByColorPlace12 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace12();
//		String ojByColorPlace13 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace13();
//		String ojByColorPlace14 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace14();
//		String ojByColorPlace15 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace15();
//		String ojByColorPlace16 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace16();
//
//		List<String> ojByColorPlaceList = new ArrayList<>();
//		ojByColorPlaceList.add(ojByColorPlace1);
//		ojByColorPlaceList.add(ojByColorPlace2);
//		ojByColorPlaceList.add(ojByColorPlace3);
//		ojByColorPlaceList.add(ojByColorPlace4);
//		ojByColorPlaceList.add(ojByColorPlace5);
//		ojByColorPlaceList.add(ojByColorPlace6);
//		ojByColorPlaceList.add(ojByColorPlace7);
//		ojByColorPlaceList.add(ojByColorPlace8);
//		ojByColorPlaceList.add(ojByColorPlace9);
//		ojByColorPlaceList.add(ojByColorPlace10);
//		ojByColorPlaceList.add(ojByColorPlace11);
//		ojByColorPlaceList.add(ojByColorPlace12);
//		ojByColorPlaceList.add(ojByColorPlace13);
//		ojByColorPlaceList.add(ojByColorPlace14);
//		ojByColorPlaceList.add(ojByColorPlace15);
//		ojByColorPlaceList.add(ojByColorPlace16);
//		ojByColorPlaceList.removeAll(Collections.singleton(null));
//		if(!ojByColorPlaceList.isEmpty()) {
//			//JACKET_ボタン付け糸指定_箇所コード
//			String ojByColorPlaceCodeInDb = severalCodeInDb(ojByColorPlaceList);
//			order.setJkBtnthreadColorPlcCd(ojByColorPlaceCodeInDb);
//			//JACKET_ボタン付け糸指定_箇所名
//			Map<String, String> ojByColorPlaceMap = orderForm.getOptionJacketStandardInfo().getOjByColorPlaceMap();
//			String ojByColorPlaceNameInDb = severalNameInDb(ojByColorPlaceList, ojByColorPlaceMap);
//			order.setJkBtnthreadColorPlcN(ojByColorPlaceNameInDb);
//		}
//		
//		String ojByColor1 = orderForm.getOptionJacketStandardInfo().getOjByColor1();
//		String ojByColor2 = orderForm.getOptionJacketStandardInfo().getOjByColor2();
//		String ojByColor3 = orderForm.getOptionJacketStandardInfo().getOjByColor3();
//		String ojByColor4 = orderForm.getOptionJacketStandardInfo().getOjByColor4();
//		String ojByColor5 = orderForm.getOptionJacketStandardInfo().getOjByColor5();
//		String ojByColor6 = orderForm.getOptionJacketStandardInfo().getOjByColor6();
//		String ojByColor7 = orderForm.getOptionJacketStandardInfo().getOjByColor7();
//		String ojByColor8 = orderForm.getOptionJacketStandardInfo().getOjByColor8();
//		String ojByColor9 = orderForm.getOptionJacketStandardInfo().getOjByColor9();
//		String ojByColor10 = orderForm.getOptionJacketStandardInfo().getOjByColor10();
//		String ojByColor11 = orderForm.getOptionJacketStandardInfo().getOjByColor11();
//		String ojByColor12 = orderForm.getOptionJacketStandardInfo().getOjByColor12();
//		String ojByColor13 = orderForm.getOptionJacketStandardInfo().getOjByColor13();
//		String ojByColor14 = orderForm.getOptionJacketStandardInfo().getOjByColor14();
//		String ojByColor15 = orderForm.getOptionJacketStandardInfo().getOjByColor15();
//		String ojByColor16 = orderForm.getOptionJacketStandardInfo().getOjByColor16();
//
//		List<String> ojByColorsList = new ArrayList<>();
//		ojByColorsList.add(ojByColor1);
//		ojByColorsList.add(ojByColor2);
//		ojByColorsList.add(ojByColor3);
//		ojByColorsList.add(ojByColor4);
//		ojByColorsList.add(ojByColor5);
//		ojByColorsList.add(ojByColor6);
//		ojByColorsList.add(ojByColor7);
//		ojByColorsList.add(ojByColor8);
//		ojByColorsList.add(ojByColor9);
//		ojByColorsList.add(ojByColor10);
//		ojByColorsList.add(ojByColor11);
//		ojByColorsList.add(ojByColor12);
//		ojByColorsList.add(ojByColor13);
//		ojByColorsList.add(ojByColor14);
//		ojByColorsList.add(ojByColor15);
//		ojByColorsList.add(ojByColor16);
//		ojByColorsList.removeAll(Collections.singleton(null));
//		if(!ojByColorsList.isEmpty()) {
//			//JACKET_ボタン付け糸指定_色コード
//			String ojByColorsCodeInDb = severalCodeInDb(ojByColorsList);
//			order.setJkBtnthreadColorCd(ojByColorsCodeInDb);
//			//JACKET_ボタン付け糸指定_色名
//			Map<String, String> ojByColorsMap = orderForm.getOptionJacketStandardInfo().getOjByColorsMap();
//			String ojByColorsNameInDb = severalNameInDb(ojByColorsList, ojByColorsMap);
//			order.setJkBtnthreadColorNm(ojByColorsNameInDb);
//		}
//	}
//	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void aboutGiletCheckBoxInDb(OrderForm orderForm,Order order) {
//		
//		//標準GILETのステッチ箇所変更
//		String ogStitchModifyPlace1 = orderForm.getOptionGiletStandardInfo().getOgStitchModifyPlace1();
//		String ogStitchModifyPlace2 = orderForm.getOptionGiletStandardInfo().getOgStitchModifyPlace2();
//		String ogStitchModifyPlace3 = orderForm.getOptionGiletStandardInfo().getOgStitchModifyPlace3();
//
//		List<String> ogStitchModifyPlaceList = new ArrayList<>();
//		ogStitchModifyPlaceList.add(ogStitchModifyPlace1);
//		ogStitchModifyPlaceList.add(ogStitchModifyPlace2);
//		ogStitchModifyPlaceList.add(ogStitchModifyPlace3);
//		ogStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		if(!ogStitchModifyPlaceList.isEmpty()) {
//			//GILET_ステッチ箇所変更 _コード
//			String ogStitchModifyPlaceCodeInDb = severalCodeInDb(ogStitchModifyPlaceList);
//			order.setGlStitchPlcCd(ogStitchModifyPlaceCodeInDb);
//			//GILET_ステッチ箇所変更 _名
//			Map<String, String> ogStitchModifyPlaceMap = orderForm.getOptionGiletStandardInfo().getOgStitchModifyPlaceMap();
//			String ogStitchModifyPlaceNameInDb = severalNameInDb(ogStitchModifyPlaceList, ogStitchModifyPlaceMap);
//			order.setGlStitchPlcNm(ogStitchModifyPlaceNameInDb);
//		}
//		
//		//標準GILETのダブルステッチ
//		String ogDStitchModifyPlace1 = orderForm.getOptionGiletStandardInfo().getOgDStitchModifyPlace1();
//		String ogDStitchModifyPlace2 = orderForm.getOptionGiletStandardInfo().getOgDStitchModifyPlace2();
//		String ogDStitchModifyPlace3 = orderForm.getOptionGiletStandardInfo().getOgDStitchModifyPlace3();
//		
//		List<String> ogDStitchModifyPlaceList = new ArrayList<>();
//		ogDStitchModifyPlaceList.add(ogDStitchModifyPlace1);
//		ogDStitchModifyPlaceList.add(ogDStitchModifyPlace2);
//		ogDStitchModifyPlaceList.add(ogDStitchModifyPlace3);
//		ogDStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		if(!ogDStitchModifyPlaceList.isEmpty()) {
//			//GILET_ダブルステッチ変更_コード
//			String ogDStitchModifyPlaceCodeInDb = severalCodeInDb(ogDStitchModifyPlaceList);
//			order.setGlDblstitchPlcCd(ogDStitchModifyPlaceCodeInDb);
//			//GILET_ダブルステッチ変更_名
//			Map<String, String> ogDStitchModifyPlaceMap = orderForm.getOptionGiletStandardInfo().getOgDStitchModifyPlaceMap();
//			String ogDStitchModifyPlaceNameInDb = severalNameInDb(ogDStitchModifyPlaceList, ogDStitchModifyPlaceMap);
//			order.setGlDblstitchPlcNm(ogDStitchModifyPlaceNameInDb);
//		}
//		
//		//標準GILETのAMF色指定
//		String ogAmfColorPlace1 = orderForm.getOptionGiletStandardInfo().getOgAmfColorPlace1();
//		String ogAmfColorPlace2 = orderForm.getOptionGiletStandardInfo().getOgAmfColorPlace2();
//		String ogAmfColorPlace3 = orderForm.getOptionGiletStandardInfo().getOgAmfColorPlace3();
//		
//		List<String> ogAmfColorPlaceList = new ArrayList<>();
//		ogAmfColorPlaceList.add(ogAmfColorPlace1);
//		ogAmfColorPlaceList.add(ogAmfColorPlace2);
//		ogAmfColorPlaceList.add(ogAmfColorPlace3);
//		ogAmfColorPlaceList.removeAll(Collections.singleton(null));
//		if(!ogAmfColorPlaceList.isEmpty()) {
//			//GILET_AMF色指定_箇所コード
//			String ogAmfColorPlaceCodeInDb = severalCodeInDb(ogAmfColorPlaceList);
//			order.setGlAmfColorPlcCd(ogAmfColorPlaceCodeInDb);
//			//GILET_AMF色指定_箇所名
//			Map<String, String> ogAmfColorPlaceMap = orderForm.getOptionGiletStandardInfo().getOgAmfColorPlaceMap();
//			String ogAmfColorPlaceNameInDb = severalNameInDb(ogAmfColorPlaceList, ogAmfColorPlaceMap);
//			order.setGlAmfColorPlcNm(ogAmfColorPlaceNameInDb);
//		}
//		
//		String ogAmfColor1 = orderForm.getOptionGiletStandardInfo().getOgAmfColor1();
//		String ogAmfColor2 = orderForm.getOptionGiletStandardInfo().getOgAmfColor2();
//		String ogAmfColor3 = orderForm.getOptionGiletStandardInfo().getOgAmfColor3();
//		List<String> ogAmfColorList = new ArrayList<>();
//		ogAmfColorList.add(ogAmfColor1);
//		ogAmfColorList.add(ogAmfColor2);
//		ogAmfColorList.add(ogAmfColor3);
//		ogAmfColorList.removeAll(Collections.singleton(null));
//		if(!ogAmfColorList.isEmpty()) {
//			//GILET_AMF色指定_色コード
//			String ogAmfColorsCodeInDb = severalCodeInDb(ogAmfColorList);
//			order.setGlAmfColorCd(ogAmfColorsCodeInDb);
//			//GILET_AMF色指定_色名
//			Map<String, String> ogAmfColorsMap = orderForm.getOptionGiletStandardInfo().getOgAmfColorsMap();
//			String ogAmfColorsNameInDb = severalNameInDb(ogAmfColorList, ogAmfColorsMap);
//			order.setGlAmfColorNm(ogAmfColorsNameInDb);
//		}
//	
//		//標準GILETのボタンホール色指定
//		String ogBhColorPlace1 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace1();
//		String ogBhColorPlace2 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace2();
//		String ogBhColorPlace3 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace3();
//		String ogBhColorPlace4 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace4();
//		String ogBhColorPlace5 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace5();
//		String ogBhColorPlace6 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace6();
//		
//		List<String> ogBhColorPlaceList = new ArrayList<>();
//		ogBhColorPlaceList.add(ogBhColorPlace1);
//		ogBhColorPlaceList.add(ogBhColorPlace2);
//		ogBhColorPlaceList.add(ogBhColorPlace3);
//		ogBhColorPlaceList.add(ogBhColorPlace4);
//		ogBhColorPlaceList.add(ogBhColorPlace5);
//		ogBhColorPlaceList.add(ogBhColorPlace6);
//		ogBhColorPlaceList.removeAll(Collections.singleton(null));
//		if(!ogBhColorPlaceList.isEmpty()) {
//			//GILET_ボタンホール色指定_箇所コード
//			String ogBhColorPlaceCodeInDb = severalCodeInDb(ogBhColorPlaceList);
//			order.setGlBtnholeColorPlcCd(ogBhColorPlaceCodeInDb);
//			//GILET_ボタンホール色指定_箇所名
//			Map<String, String> ogBhColorPlaceMap = orderForm.getOptionGiletStandardInfo().getOgBhColorPlaceMap();
//			String ogBhColorPlaceNameInDb = severalNameInDb(ogBhColorPlaceList, ogBhColorPlaceMap);
//			order.setGlBtnholeColorPlcNm(ogBhColorPlaceNameInDb);
//		}
//		
//		String ogBhColor1 = orderForm.getOptionGiletStandardInfo().getOgBhColor1();
//		String ogBhColor2 = orderForm.getOptionGiletStandardInfo().getOgBhColor2();
//		String ogBhColor3 = orderForm.getOptionGiletStandardInfo().getOgBhColor3();
//		String ogBhColor4 = orderForm.getOptionGiletStandardInfo().getOgBhColor4();
//		String ogBhColor5 = orderForm.getOptionGiletStandardInfo().getOgBhColor5();
//		String ogBhColor6 = orderForm.getOptionGiletStandardInfo().getOgBhColor6();
//		
//		List<String> ogBhColorsList = new ArrayList<>();
//		ogBhColorsList.add(ogBhColor1);
//		ogBhColorsList.add(ogBhColor2);
//		ogBhColorsList.add(ogBhColor3);
//		ogBhColorsList.add(ogBhColor4);
//		ogBhColorsList.add(ogBhColor5);
//		ogBhColorsList.add(ogBhColor6);
//		ogBhColorsList.removeAll(Collections.singleton(null));
//		if(!ogBhColorsList.isEmpty()) {
//			//GILET_ボタンホール色指定_色コード
//			String ogBhColorsCodeInDb = severalCodeInDb(ogBhColorsList);
//			order.setGlBtnholeColorCd(ogBhColorsCodeInDb);
//			//GILET_ボタンホール色指定_色名
//			Map<String, String> ogBhColorsMap = orderForm.getOptionGiletStandardInfo().getOgBhColorsMap();
//			String ogBhColorsNameInDb = severalNameInDb(ogBhColorsList, ogBhColorsMap);
//			order.setGlBtnholeColorNm(ogBhColorsNameInDb);
//		}
//		
//		//標準GILETのボタン付け糸指定
//		String ogByColorPlace1 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace1();
//		String ogByColorPlace2 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace2();
//		String ogByColorPlace3 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace3();
//		String ogByColorPlace4 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace4();
//		String ogByColorPlace5 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace5();
//		String ogByColorPlace6 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace6();
//		String ogByColorPlace7 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace7();
//		String ogByColorPlace8 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace8();
//		String ogByColorPlace9 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace9();
//		String ogByColorPlace10 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace10();
//		
//		List<String> ogByColorPlaceList = new ArrayList<>();
//		ogByColorPlaceList.add(ogByColorPlace1);
//		ogByColorPlaceList.add(ogByColorPlace2);
//		ogByColorPlaceList.add(ogByColorPlace3);
//		ogByColorPlaceList.add(ogByColorPlace4);
//		ogByColorPlaceList.add(ogByColorPlace5);
//		ogByColorPlaceList.add(ogByColorPlace6);
//		ogByColorPlaceList.add(ogByColorPlace7);
//		ogByColorPlaceList.add(ogByColorPlace8);
//		ogByColorPlaceList.add(ogByColorPlace9);
//		ogByColorPlaceList.add(ogByColorPlace10);
//		ogByColorPlaceList.removeAll(Collections.singleton(null));
//		if(!ogByColorPlaceList.isEmpty()) {
//			//GILET_ボタン付け糸指定_箇所コード
//			String ogByColorPlaceCodeInDb = severalCodeInDb(ogByColorPlaceList);
//			order.setGlBtnthreadColorPlcCd(ogByColorPlaceCodeInDb);
//			//GILET_ボタン付け糸指定_箇所名
//			Map<String, String> ogByColorPlaceMap = orderForm.getOptionGiletStandardInfo().getOgByColorPlaceMap();
//			String ogByColorPlaceNameInDb = severalNameInDb(ogByColorPlaceList, ogByColorPlaceMap);
//			order.setGlBtnthreadColorPlcNm(ogByColorPlaceNameInDb);
//		}
//		
//		String ogByColor1 = orderForm.getOptionGiletStandardInfo().getOgByColor1();
//		String ogByColor2 = orderForm.getOptionGiletStandardInfo().getOgByColor2();
//		String ogByColor3 = orderForm.getOptionGiletStandardInfo().getOgByColor3();
//		String ogByColor4 = orderForm.getOptionGiletStandardInfo().getOgByColor4();
//		String ogByColor5 = orderForm.getOptionGiletStandardInfo().getOgByColor5();
//		String ogByColor6 = orderForm.getOptionGiletStandardInfo().getOgByColor6();
//		String ogByColor7 = orderForm.getOptionGiletStandardInfo().getOgByColor7();
//		String ogByColor8 = orderForm.getOptionGiletStandardInfo().getOgByColor8();
//		String ogByColor9 = orderForm.getOptionGiletStandardInfo().getOgByColor9();
//		String ogByColor10 = orderForm.getOptionGiletStandardInfo().getOgByColor10();
//		
//		List<String> ogByColorsList = new ArrayList<>();
//		ogByColorsList.add(ogByColor1);
//		ogByColorsList.add(ogByColor2);
//		ogByColorsList.add(ogByColor3);
//		ogByColorsList.add(ogByColor4);
//		ogByColorsList.add(ogByColor5);
//		ogByColorsList.add(ogByColor6);
//		ogByColorsList.add(ogByColor7);
//		ogByColorsList.add(ogByColor8);
//		ogByColorsList.add(ogByColor9);
//		ogByColorsList.add(ogByColor10);
//		ogByColorsList.removeAll(Collections.singleton(null));
//		if(!ogByColorsList.isEmpty()) {
//			//GILET_ボタン付け糸指定_色コード
//			String ogByColorsCodeInDb = severalCodeInDb(ogByColorsList);
//			order.setGlBtnthreadColorCd(ogByColorsCodeInDb);
//			//GILET_ボタン付け糸指定_色名
//			Map<String, String> ogByColorsMap = orderForm.getOptionGiletStandardInfo().getOgByColorsMap();
//			String ogByColorsNameInDb = severalNameInDb(ogByColorsList, ogByColorsMap);
//			order.setGlBtnthreadColorNm(ogByColorsNameInDb);
//		}
//	}
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void aboutPantsCheckBoxInDb(OrderForm orderForm,Order order) {
//		//標準PANTSのベルトループ
//		String opBeltLoopPlace1 = orderForm.getOptionPantsStandardInfo().getOpBeltLoopPlace1();
//		String opBeltLoopPlace2 = orderForm.getOptionPantsStandardInfo().getOpBeltLoopPlace2();
//		String opBeltLoopPlace3 = orderForm.getOptionPantsStandardInfo().getOpBeltLoopPlace3();
//		String opBeltLoopPlace4 = orderForm.getOptionPantsStandardInfo().getOpBeltLoopPlace4();
//		String opBeltLoopPlace5 = orderForm.getOptionPantsStandardInfo().getOpBeltLoopPlace5();
//		String opBeltLoopPlace6 = orderForm.getOptionPantsStandardInfo().getOpBeltLoopPlace6();
//		String opBeltLoopPlace7 = orderForm.getOptionPantsStandardInfo().getOpBeltLoopPlace7();
//		List<String> opBeltLoopPlaceList = new ArrayList<>();
//		opBeltLoopPlaceList.add(opBeltLoopPlace1);
//		opBeltLoopPlaceList.add(opBeltLoopPlace2);
//		opBeltLoopPlaceList.add(opBeltLoopPlace3);
//		opBeltLoopPlaceList.add(opBeltLoopPlace4);
//		opBeltLoopPlaceList.add(opBeltLoopPlace5);
//		opBeltLoopPlaceList.add(opBeltLoopPlace6);
//		opBeltLoopPlaceList.add(opBeltLoopPlace7);
//		opBeltLoopPlaceList.removeAll(Collections.singleton(null));
//		if(!opBeltLoopPlaceList.isEmpty()) {
//			//PANTS_ベルトループ_コード
//			String opBeltLoopPlaceCodeInDb = severalCodeInDb(opBeltLoopPlaceList);
//			order.setPtBeltloopCd(opBeltLoopPlaceCodeInDb);
//			//PANTS_ベルトループ_名
//			Map<String, String> opBeltLoopPlaceMap = orderForm.getOptionPantsStandardInfo().getOpBeltLoopPlaceMap();
//			String opBeltLoopPlaceNameInDb = severalNameInDb(opBeltLoopPlaceList, opBeltLoopPlaceMap);
//			order.setPtBeltloopNm(opBeltLoopPlaceNameInDb);
//		}
//		
//		//標準PANTSのステッチ箇所変更
//		String opStitchModifyPlace1 = orderForm.getOptionPantsStandardInfo().getOpStitchModifyPlace1();
//		String opStitchModifyPlace2 = orderForm.getOptionPantsStandardInfo().getOpStitchModifyPlace2();
//		String opStitchModifyPlace3 = orderForm.getOptionPantsStandardInfo().getOpStitchModifyPlace3();
//		String opStitchModifyPlace4 = orderForm.getOptionPantsStandardInfo().getOpStitchModifyPlace4();
//		List<String> opStitchModifyPlaceList = new ArrayList<>();
//		opStitchModifyPlaceList.add(opStitchModifyPlace1);
//		opStitchModifyPlaceList.add(opStitchModifyPlace2);
//		opStitchModifyPlaceList.add(opStitchModifyPlace3);
//		opStitchModifyPlaceList.add(opStitchModifyPlace4);
//		opStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		if(!opStitchModifyPlaceList.isEmpty()) {
//			//PANTS_ステッチ箇所変更_コード
//			String opStitchModifyPlaceCodeInDb = severalCodeInDb(opStitchModifyPlaceList);
//			order.setPtStitchPlcCd(opStitchModifyPlaceCodeInDb);
//			//PANTS_ステッチ箇所変更_名
//			Map<String, String> opStitchModifyPlaceMap = orderForm.getOptionPantsStandardInfo().getOpStitchModifyPlaceMap();
//			String opStitchModifyPlaceNameInDb = severalNameInDb(opStitchModifyPlaceList, opStitchModifyPlaceMap);
//			order.setPtStitchPlcNm(opStitchModifyPlaceNameInDb);
//		}
//		
//		//標準PANTSのダブルステッチ
//		String opDStitchPlace1 = orderForm.getOptionPantsStandardInfo().getOpDStitchPlace1();
//		String opDStitchPlace2 = orderForm.getOptionPantsStandardInfo().getOpDStitchPlace2();
//		String opDStitchPlace3 = orderForm.getOptionPantsStandardInfo().getOpDStitchPlace3();
//		String opDStitchPlace4 = orderForm.getOptionPantsStandardInfo().getOpDStitchPlace4();
//		List<String> opDStitchPlaceList = new ArrayList<>();
//		opDStitchPlaceList.add(opDStitchPlace1);
//		opDStitchPlaceList.add(opDStitchPlace2);
//		opDStitchPlaceList.add(opDStitchPlace3);
//		opDStitchPlaceList.add(opDStitchPlace4);
//		opDStitchPlaceList.removeAll(Collections.singleton(null));
//		if(!opDStitchPlaceList.isEmpty()) {
//			//PANTS_ダブルステッチ_コード
//			String opDStitchPlaceCodeInDb = severalCodeInDb(opDStitchPlaceList);
//			order.setPtDblstitchPlcCd(opDStitchPlaceCodeInDb);
//			//PANTS_ダブルステッチ_名
//			Map<String, String> opDStitchPlaceMap = orderForm.getOptionPantsStandardInfo().getOpDStitchPlaceMap();
//			String opDStitchPlaceNameInDb = severalNameInDb(opDStitchPlaceList, opDStitchPlaceMap);
//			order.setPtDblstitchPlcNm(opDStitchPlaceNameInDb);
//		}
//		
//		//標準PANTSのAMF色指定
//		String opAmfColorPlace1 = orderForm.getOptionPantsStandardInfo().getOpAmfColorPlace1();
//		String opAmfColorPlace2 = orderForm.getOptionPantsStandardInfo().getOpAmfColorPlace2();
//		String opAmfColorPlace3 = orderForm.getOptionPantsStandardInfo().getOpAmfColorPlace3();
//		String opAmfColorPlace4 = orderForm.getOptionPantsStandardInfo().getOpAmfColorPlace4();
//		List<String> opAmfColorPlaceList = new ArrayList<>();
//		opAmfColorPlaceList.add(opAmfColorPlace1);
//		opAmfColorPlaceList.add(opAmfColorPlace2);
//		opAmfColorPlaceList.add(opAmfColorPlace3);
//		opAmfColorPlaceList.add(opAmfColorPlace4);
//		opAmfColorPlaceList.removeAll(Collections.singleton(null));
//		if(!opAmfColorPlaceList.isEmpty()) {
//			//PANTS_AMF色指定_箇所コード
//			String opAmfColorPlaceCodeInDb = severalCodeInDb(opAmfColorPlaceList);
//			order.setPtAmfColorPlcCd(opAmfColorPlaceCodeInDb);
//			//PANTS_AMF色指定_箇所名
//			Map<String, String> opAmfColorPlaceMap = orderForm.getOptionPantsStandardInfo().getOpAmfColorPlaceMap();
//			String opAmfColorPlaceNameInDb = severalNameInDb(opAmfColorPlaceList, opAmfColorPlaceMap);
//			order.setPtAmfColorPlcNm(opAmfColorPlaceNameInDb);
//		}
//		
//		String opAmfColor1 = orderForm.getOptionPantsStandardInfo().getOpAmfColor1();
//		String opAmfColor2 = orderForm.getOptionPantsStandardInfo().getOpAmfColor2();
//		String opAmfColor3 = orderForm.getOptionPantsStandardInfo().getOpAmfColor3();
//		String opAmfColor4 = orderForm.getOptionPantsStandardInfo().getOpAmfColor4();
//		List<String> opAmfColorsList = new ArrayList<>();
//		opAmfColorsList.add(opAmfColor1);
//		opAmfColorsList.add(opAmfColor2);
//		opAmfColorsList.add(opAmfColor3);
//		opAmfColorsList.add(opAmfColor4);
//		opAmfColorsList.removeAll(Collections.singleton(null));
//		if(!opAmfColorsList.isEmpty()) {
//			//PANTS_AMF色指定_色コード
//			String opAmfColorsCodeInDb = severalCodeInDb(opAmfColorsList);
//			order.setPtAmfColorCd(opAmfColorsCodeInDb);
//			//PANTS_AMF色指定_色名
//			Map<String, String> opAmfColorsMap = orderForm.getOptionPantsStandardInfo().getOpAmfColorsMap();
//			String opAmfColorsNameInDb = severalNameInDb(opAmfColorsList, opAmfColorsMap);
//			order.setPtAmfColorNm(opAmfColorsNameInDb);
//		}
//		
//		//標準PANTSのボタンホール色指定
//		String opBhColorPlace1 = orderForm.getOptionPantsStandardInfo().getOpBhColorPlace1();
//		String opBhColorPlace2 = orderForm.getOptionPantsStandardInfo().getOpBhColorPlace2();
//		String opBhColorPlace3 = orderForm.getOptionPantsStandardInfo().getOpBhColorPlace3();
//		String opBhColorPlace4 = orderForm.getOptionPantsStandardInfo().getOpBhColorPlace4();
//		List<String> opBhColorPlaceList = new ArrayList<>();
//		opBhColorPlaceList.add(opBhColorPlace1);
//		opBhColorPlaceList.add(opBhColorPlace2);
//		opBhColorPlaceList.add(opBhColorPlace3);
//		opBhColorPlaceList.add(opBhColorPlace4);
//		opBhColorPlaceList.removeAll(Collections.singleton(null));
//		if(!opBhColorPlaceList.isEmpty()) {
//			//PANTS_ボタンホール色指定_箇所コード
//			String opBhColorPlaceCodeInDb = severalCodeInDb(opBhColorPlaceList);
//			order.setPtBtnholeColorPlcCd(opBhColorPlaceCodeInDb);
//			//PANTS_ボタンホール色指定_箇所名
//			Map<String, String> opBhColorPlaceMap = orderForm.getOptionPantsStandardInfo().getOpBhColorPlaceMap();
//			String opBhColorPlaceNameInDb = severalNameInDb(opBhColorPlaceList, opBhColorPlaceMap);
//			order.setPtBtnholeColorPlcNm(opBhColorPlaceNameInDb);
//		}
//		
//		String opBhColor1 = orderForm.getOptionPantsStandardInfo().getOpBhColor1();
//		String opBhColor2 = orderForm.getOptionPantsStandardInfo().getOpBhColor2();
//		String opBhColor3 = orderForm.getOptionPantsStandardInfo().getOpBhColor3();
//		String opBhColor4 = orderForm.getOptionPantsStandardInfo().getOpBhColor4();
//		List<String> opBhColorsList = new ArrayList<>();
//		opBhColorsList.add(opBhColor1);
//		opBhColorsList.add(opBhColor2);
//		opBhColorsList.add(opBhColor3);
//		opBhColorsList.add(opBhColor4);
//		opBhColorsList.removeAll(Collections.singleton(null));
//		if(!opBhColorsList.isEmpty()) {
//			//PANTS_ボタンホール色指定_色コード
//			String opBhColorsCodeInDb = severalCodeInDb(opBhColorsList);
//			order.setPtBtnholeColorCd(opBhColorsCodeInDb);
//			//PANTS_ボタンホール色指定_色名
//			Map<String, String> opBhColorsMap = orderForm.getOptionPantsStandardInfo().getOpBhColorsMap();
//			String opBhColorsNameInDb = severalNameInDb(opBhColorsList, opBhColorsMap);
//			order.setPtBtnholeColorNm(opBhColorsNameInDb);
//		}
//		
//		//標準PANTSのボタン付け糸指定
//		String opByColorPlace1 = orderForm.getOptionPantsStandardInfo().getOpByColorPlace1();
//		String opByColorPlace2 = orderForm.getOptionPantsStandardInfo().getOpByColorPlace2();
//		String opByColorPlace3 = orderForm.getOptionPantsStandardInfo().getOpByColorPlace3();
//		String opByColorPlace4 = orderForm.getOptionPantsStandardInfo().getOpByColorPlace4();
//		List<String> opByColorPlaceList = new ArrayList<>();
//		opByColorPlaceList.add(opByColorPlace1);
//		opByColorPlaceList.add(opByColorPlace2);
//		opByColorPlaceList.add(opByColorPlace3);
//		opByColorPlaceList.add(opByColorPlace4);
//		opByColorPlaceList.removeAll(Collections.singleton(null));
//		if(!opByColorPlaceList.isEmpty()) {
//			//PANTS_ボタン付け糸指定_箇所コード
//			String opByColorPlaceCodeInDb = severalCodeInDb(opByColorPlaceList);
//			order.setPtBtnthreadColorPlcNm(opByColorPlaceCodeInDb);
//			//PANTS_ボタン付け糸指定_箇所名
//			Map<String, String> opByColorPlaceMap = orderForm.getOptionPantsStandardInfo().getOpByColorPlaceMap();
//			String opByColorPlaceNameInDb = severalNameInDb(opByColorPlaceList, opByColorPlaceMap);
//			order.setPtBtnthreadColorPlcNm(opByColorPlaceNameInDb);
//		}
//		
//		String opByColor1 = orderForm.getOptionPantsStandardInfo().getOpByColor1();
//		String opByColor2 = orderForm.getOptionPantsStandardInfo().getOpByColor2();
//		String opByColor3 = orderForm.getOptionPantsStandardInfo().getOpByColor3();
//		String opByColor4 = orderForm.getOptionPantsStandardInfo().getOpByColor4();
//		List<String> opByColorsList = new ArrayList<>();
//		opByColorsList.add(opByColor1);
//		opByColorsList.add(opByColor2);
//		opByColorsList.add(opByColor3);
//		opByColorsList.add(opByColor4);
//		opByColorsList.removeAll(Collections.singleton(null));
//		if(!opByColorsList.isEmpty()) {
//			//PANTS_ボタン付け糸指定_色コード
//			String opByColorsCodeInDb = severalCodeInDb(opByColorsList);
//			order.setPtBtnthreadColorCd(opByColorsCodeInDb);
//			//PANTS_ボタン付け糸指定_色名
//			Map<String, String> opByColorsMap = orderForm.getOptionPantsStandardInfo().getOpByColorsMap();
//			String opByColorsNameInDb = severalNameInDb(opByColorsList,opByColorsMap);
//			order.setPtBtnthreadColorNm(opByColorsNameInDb);
//		}
//	}
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 */
//	public void aboutPants2CheckBoxInDb(OrderForm orderForm,Order order) {
//		//標準2PANTSのベルトループ 
//		String op2BeltLoopPlace1 = orderForm.getOptionPants2StandardInfo().getOp2BeltLoopPlace1();
//		String op2BeltLoopPlace2 = orderForm.getOptionPants2StandardInfo().getOp2BeltLoopPlace2();
//		String op2BeltLoopPlace3 = orderForm.getOptionPants2StandardInfo().getOp2BeltLoopPlace3();
//		String op2BeltLoopPlace4 = orderForm.getOptionPants2StandardInfo().getOp2BeltLoopPlace4();
//		List<String> op2BeltLoopPlaceList = new ArrayList<>();
//		op2BeltLoopPlaceList.add(op2BeltLoopPlace1);
//		op2BeltLoopPlaceList.add(op2BeltLoopPlace2);
//		op2BeltLoopPlaceList.add(op2BeltLoopPlace3);
//		op2BeltLoopPlaceList.add(op2BeltLoopPlace4);
//		op2BeltLoopPlaceList.removeAll(Collections.singleton(null));
//		if(!op2BeltLoopPlaceList.isEmpty()) {
//			//2PANTS_ベルトループ_コード
//			String op2BeltLoopPlaceCodeInDb = severalCodeInDb(op2BeltLoopPlaceList);
//			order.setPt2BeltloopCd(op2BeltLoopPlaceCodeInDb);
//			//2PANTS_ベルトループ_名
//			Map<String, String> op2BeltLoopPlaceMap = orderForm.getOptionPants2StandardInfo().getOp2BeltLoopPlaceMap();
//			String op2BeltLoopPlaceNameInDb = severalNameInDb(op2BeltLoopPlaceList, op2BeltLoopPlaceMap);
//			order.setPt2BeltloopNm(op2BeltLoopPlaceNameInDb);
//		}
//		
//		//標準2PANTSのステッチ箇所変更
//		String op2StitchModifyPlace1 = orderForm.getOptionPants2StandardInfo().getOp2StitchModifyPlace1();
//		String op2StitchModifyPlace2 = orderForm.getOptionPants2StandardInfo().getOp2StitchModifyPlace2();
//		String op2StitchModifyPlace3 = orderForm.getOptionPants2StandardInfo().getOp2StitchModifyPlace3();
//		String op2StitchModifyPlace4 = orderForm.getOptionPants2StandardInfo().getOp2StitchModifyPlace4();
//		List<String> op2StitchModifyPlaceList = new ArrayList<>();
//		op2StitchModifyPlaceList.add(op2StitchModifyPlace1);
//		op2StitchModifyPlaceList.add(op2StitchModifyPlace2);
//		op2StitchModifyPlaceList.add(op2StitchModifyPlace3);
//		op2StitchModifyPlaceList.add(op2StitchModifyPlace4);
//		op2StitchModifyPlaceList.removeAll(Collections.singleton(null));
//		if(!op2StitchModifyPlaceList.isEmpty()) {
//			//2PANTS_ステッチ箇所変更_コード
//			String op2StitchModifyPlaceCodeInDb = severalCodeInDb(op2StitchModifyPlaceList);
//			order.setPt2StitchPlcCd(op2StitchModifyPlaceCodeInDb);
//			//2PANTS_ステッチ箇所変更_名
//			Map<String, String> op2StitchModifyPlaceMap = orderForm.getOptionPants2StandardInfo().getOp2StitchModifyPlaceMap();
//			String op2StitchModifyPlaceNameInDb = severalNameInDb(op2StitchModifyPlaceList, op2StitchModifyPlaceMap);
//			order.setPt2StitchPlcNm(op2StitchModifyPlaceNameInDb);
//		}
//		
//		//標準2PANTSのダブルステッチ
//		String op2dStitchPlace1 = orderForm.getOptionPants2StandardInfo().getOp2DStitchPlace1();
//		String op2dStitchPlace2 = orderForm.getOptionPants2StandardInfo().getOp2DStitchPlace2();
//		String op2dStitchPlace3 = orderForm.getOptionPants2StandardInfo().getOp2DStitchPlace3();
//		String op2dStitchPlace4 = orderForm.getOptionPants2StandardInfo().getOp2DStitchPlace4();
//		List<String> p2dStitchPlaceList = new ArrayList<>();
//		p2dStitchPlaceList.add(op2dStitchPlace1);
//		p2dStitchPlaceList.add(op2dStitchPlace2);
//		p2dStitchPlaceList.add(op2dStitchPlace3);
//		p2dStitchPlaceList.add(op2dStitchPlace4);
//		p2dStitchPlaceList.removeAll(Collections.singleton(null));
//		if(!p2dStitchPlaceList.isEmpty()) {
//			//2PANTS_ダブルステッチ_コード
//			String p2dStitchPlaceCodeInDb = severalCodeInDb(p2dStitchPlaceList);
//			order.setPt2DblstitchPlcCd(p2dStitchPlaceCodeInDb);
//			//2PANTS_ダブルステッチ_名
//			Map<String, String> op2dStitchPlaceMap = orderForm.getOptionPants2StandardInfo().getOp2DStitchPlaceMap();
//			String op2dStitchPlaceNameInDb = severalNameInDb(p2dStitchPlaceList, op2dStitchPlaceMap);
//			order.setPt2DblstitchPlcNm(op2dStitchPlaceNameInDb);
//		}
//		
//		//標準2PANTSのAMF色指定
//		String op2AmfColorPlace1 = orderForm.getOptionPants2StandardInfo().getOp2AmfColorPlace1();
//		String op2AmfColorPlace2 = orderForm.getOptionPants2StandardInfo().getOp2AmfColorPlace2();
//		String op2AmfColorPlace3 = orderForm.getOptionPants2StandardInfo().getOp2AmfColorPlace3();
//		String op2AmfColorPlace4 = orderForm.getOptionPants2StandardInfo().getOp2AmfColorPlace4();
//		List<String> op2AmfColorPlaceList = new ArrayList<>();
//		op2AmfColorPlaceList.add(op2AmfColorPlace1);
//		op2AmfColorPlaceList.add(op2AmfColorPlace2);
//		op2AmfColorPlaceList.add(op2AmfColorPlace3);
//		op2AmfColorPlaceList.add(op2AmfColorPlace4);
//		op2AmfColorPlaceList.removeAll(Collections.singleton(null));
//		if(!op2AmfColorPlaceList.isEmpty()) {
//			//2PANTS_AMF色指定_箇所コード
//			String op2AmfColorPlaceCodeInDb = severalCodeInDb(op2AmfColorPlaceList);
//			order.setPt2AmfColorPlcCd(op2AmfColorPlaceCodeInDb);
//			//2PANTS_AMF色指定_箇所名
//			Map<String, String> op2AmfColorPlaceMap = orderForm.getOptionPants2StandardInfo().getOp2AmfColorPlaceMap();
//			String op2AmfColorPlaceNameInDb = severalNameInDb(op2AmfColorPlaceList, op2AmfColorPlaceMap);
//			order.setPt2AmfColorPlcCd(op2AmfColorPlaceNameInDb);
//		}
//		
//		String op2AmfColor1 = orderForm.getOptionPants2StandardInfo().getOp2AmfColor1();
//		String op2AmfColor2 = orderForm.getOptionPants2StandardInfo().getOp2AmfColor2();
//		String op2AmfColor3 = orderForm.getOptionPants2StandardInfo().getOp2AmfColor3();
//		String op2AmfColor4 = orderForm.getOptionPants2StandardInfo().getOp2AmfColor4();
//		List<String> op2AmfColorsList = new ArrayList<>();
//		op2AmfColorsList.add(op2AmfColor1);
//		op2AmfColorsList.add(op2AmfColor2);
//		op2AmfColorsList.add(op2AmfColor3);
//		op2AmfColorsList.add(op2AmfColor4);
//		op2AmfColorsList.removeAll(Collections.singleton(null));
//		if(!op2AmfColorsList.isEmpty()) {
//			//2PANTS_AMF色指定_色コード
//			String op2AmfColorsCodeInDb = severalCodeInDb(op2AmfColorsList);
//			order.setPt2AmfColorCd(op2AmfColorsCodeInDb);
//			//2PANTS_AMF色指定_色名
//			Map<String, String> op2AmfColorsMap = orderForm.getOptionPants2StandardInfo().getOp2AmfColorsMap();
//			String op2AmfColorsNameInDb = severalNameInDb(op2AmfColorsList, op2AmfColorsMap);
//			order.setPt2AmfColorNm(op2AmfColorsNameInDb);
//		}
//		
//		//標準2PANTSのボタンホール色指定
//		String op2BhColorPlace1 = orderForm.getOptionPants2StandardInfo().getOp2BhColorPlace1();
//		String op2BhColorPlace2 = orderForm.getOptionPants2StandardInfo().getOp2BhColorPlace2();
//		String op2BhColorPlace3 = orderForm.getOptionPants2StandardInfo().getOp2BhColorPlace3();
//		String op2BhColorPlace4 = orderForm.getOptionPants2StandardInfo().getOp2BhColorPlace4();
//		List<String> op2BhColorPlaceList = new ArrayList<>();
//		op2BhColorPlaceList.add(op2BhColorPlace1);
//		op2BhColorPlaceList.add(op2BhColorPlace2);
//		op2BhColorPlaceList.add(op2BhColorPlace3);
//		op2BhColorPlaceList.add(op2BhColorPlace4);
//		op2BhColorPlaceList.removeAll(Collections.singleton(null));
//		if(!op2BhColorPlaceList.isEmpty()) {
//			//2PANTS_ボタンホール色指定_箇所コード
//			String op2BhColorPlaceCodeInDb = severalCodeInDb(op2BhColorPlaceList);
//			order.setPt2BtnholeColorPlcCd(op2BhColorPlaceCodeInDb);
//			//2PANTS_ボタンホール色指定_箇所名
//			Map<String, String> op2BhColorPlaceMap = orderForm.getOptionPants2StandardInfo().getOp2BhColorPlaceMap();
//			String op2BhColorPlaceNameInDb = severalNameInDb(op2BhColorPlaceList, op2BhColorPlaceMap);
//			order.setPt2BtnholeColorPlcNm(op2BhColorPlaceNameInDb);
//		}
//		
//		String op2BhColor1 = orderForm.getOptionPants2StandardInfo().getOp2BhColor1();
//		String op2BhColor2 = orderForm.getOptionPants2StandardInfo().getOp2BhColor2();
//		String op2BhColor3 = orderForm.getOptionPants2StandardInfo().getOp2BhColor3();
//		String op2BhColor4 = orderForm.getOptionPants2StandardInfo().getOp2BhColor4();
//		List<String> op2BhColorsList = new ArrayList<>();
//		op2BhColorsList.add(op2BhColor1);
//		op2BhColorsList.add(op2BhColor2);
//		op2BhColorsList.add(op2BhColor3);
//		op2BhColorsList.add(op2BhColor4);
//		op2BhColorsList.removeAll(Collections.singleton(null));
//		if(!op2BhColorsList.isEmpty()) {
//			//2PANTS_ボタンホール色指定_色コード
//			String op2BhColorsCodeInDb = severalCodeInDb(op2BhColorsList);
//			order.setPt2BtnholeColorCd(op2BhColorsCodeInDb);
//			//2PANTS_ボタンホール色指定_色名
//			Map<String, String> op2BhColorsMap = orderForm.getOptionPants2StandardInfo().getOp2BhColorsMap();
//			String op2BhColorsNameInDb = severalNameInDb(op2BhColorsList, op2BhColorsMap);
//			order.setPt2BtnholeColorNm(op2BhColorsNameInDb);
//		}
//		
//		//標準2PANTSのボタン付け糸指定
//		String op2ByColorPlace1 = orderForm.getOptionPants2StandardInfo().getOp2ByColorPlace1();
//		String op2ByColorPlace2 = orderForm.getOptionPants2StandardInfo().getOp2ByColorPlace2();
//		String op2ByColorPlace3 = orderForm.getOptionPants2StandardInfo().getOp2ByColorPlace3();
//		String op2ByColorPlace4 = orderForm.getOptionPants2StandardInfo().getOp2ByColorPlace4();
//		List<String> op2ByColorPlaceList = new ArrayList<>();
//		op2ByColorPlaceList.add(op2ByColorPlace1);
//		op2ByColorPlaceList.add(op2ByColorPlace2);
//		op2ByColorPlaceList.add(op2ByColorPlace3);
//		op2ByColorPlaceList.add(op2ByColorPlace4);
//		op2ByColorPlaceList.removeAll(Collections.singleton(null));
//		if(!op2ByColorPlaceList.isEmpty()) {
//			//2PANTS_ボタン付け糸指定_箇所コード
//			String op2ByColorPlaceCodeInDb = severalCodeInDb(op2ByColorPlaceList);
//			order.setPt2BtnthreadColorPlcCd(op2ByColorPlaceCodeInDb);
//			//2PANTS_ボタン付け糸指定_箇所名
//			Map<String, String> op2ByColorPlaceMap = orderForm.getOptionPants2StandardInfo().getOp2ByColorPlaceMap();
//			String op2ByColorPlaceNameInDb = severalNameInDb(op2ByColorPlaceList, op2ByColorPlaceMap);
//			order.setPt2BtnthreadColorPlcNm(op2ByColorPlaceNameInDb);
//		}
//		
//		String op2ByColor1 = orderForm.getOptionPants2StandardInfo().getOp2ByColor1();
//		String op2ByColor2 = orderForm.getOptionPants2StandardInfo().getOp2ByColor2();
//		String op2ByColor3 = orderForm.getOptionPants2StandardInfo().getOp2ByColor3();
//		String op2ByColor4 = orderForm.getOptionPants2StandardInfo().getOp2ByColor4();
//		List<String> op2ByColorsList = new ArrayList<>();
//		op2ByColorsList.add(op2ByColor1);
//		op2ByColorsList.add(op2ByColor2);
//		op2ByColorsList.add(op2ByColor3);
//		op2ByColorsList.add(op2ByColor4);
//		op2ByColorsList.removeAll(Collections.singleton(null));
//		if(!op2ByColorsList.isEmpty()) {
//			//2PANTS_ボタン付け糸指定_色コード
//			String op2ByColorsCodeInDb = severalCodeInDb(op2ByColorsList);
//			order.setPt2BtnthreadColorCd(op2ByColorsCodeInDb);
//			//2PANTS_ボタン付け糸指定_色名
//			Map<String, String> op2ByColorsMap = orderForm.getOptionPants2StandardInfo().getOp2ByColorsMap();
//			String op2ByColorsNameInDb = severalNameInDb(op2ByColorsList, op2ByColorsMap);
//			order.setPt2BtnthreadColorNm(op2ByColorsNameInDb);
//		}
//		
//	}
	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 * @param jacketUpperPrice
//	 */
//	public void standardJacketUpperPriceInDb(OrderForm orderForm,Order order,Map<String, String> jacketUpperPrice) {
//		JacketCoOptionStandardUpperPriceEnum[] jacketCoOptionStandardUpperPriceEnum = JacketCoOptionStandardUpperPriceEnum.values();
//		for(JacketCoOptionStandardUpperPriceEnum jacketCoOptionStandardUpperPrice : jacketCoOptionStandardUpperPriceEnum) {
//			String keyValue = jacketCoOptionStandardUpperPrice.getValueThree();
//			String valueFour = jacketCoOptionStandardUpperPrice.getValueFour();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
//				Method myMethodT = getMethod(cls, valueFour);
//				String jacketUpperPriceValue = deteleSomeSysmbol(jacketUpperPrice.get(keyValue));
//				int jacketUpperPriceParseInt = 0;
//				if(!"無料".equals(jacketUpperPriceValue)) {
//					jacketUpperPriceParseInt = Integer.parseInt(jacketUpperPriceValue);
//				}
//				Object[] argsDetailValue = {jacketUpperPriceParseInt};
//				if (myMethodT != null) {
//					ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//		}
//	}
//	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 * @param giletUpperPrice
//	 */
//	public void standardGiletUpperPriceInDb(OrderForm orderForm,Order order,Map<String, String> giletUpperPrice) {
//		GiletCoOptionStandardNextUpperPriceEnum[] giletCoOptionStandardNextUpperPriceEnum = GiletCoOptionStandardNextUpperPriceEnum.values();
//		for(GiletCoOptionStandardNextUpperPriceEnum giletCoOptionStandardNextUpperPrice : giletCoOptionStandardNextUpperPriceEnum) {
//			String keyValue = giletCoOptionStandardNextUpperPrice.getValueThree();
//			String valueFour = giletCoOptionStandardNextUpperPrice.getValueFour();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
//				Method myMethodT = getMethod(cls, valueFour);
//				String giletUpperPriceValue = deteleSomeSysmbol(giletUpperPrice.get(keyValue));
//				int giletUpperPriceParseInt = 0;
//				if(!"無料".equals(giletUpperPriceValue)) {
//					giletUpperPriceParseInt = Integer.parseInt(giletUpperPriceValue);
//				}
//				Object[] argsDetailValue = {giletUpperPriceParseInt};
//				if (myMethodT != null) {
//					ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//		}
//	}
//	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 * @param pantsUpperPrice
//	 */
//	public void standardPants2UpperPriceInDb(OrderForm orderForm,Order order,Map<String, String> pants2UpperPrice) {
//		Pants2CoOptionStandardUpperPriceEnum[] pants2CoOptionStandardUpperPriceEnum = Pants2CoOptionStandardUpperPriceEnum.values();
//		for(Pants2CoOptionStandardUpperPriceEnum pants2CoOptionStandardUpperPrice : pants2CoOptionStandardUpperPriceEnum) {
//			String keyValue = pants2CoOptionStandardUpperPrice.getValueThree();
//			String valueFour = pants2CoOptionStandardUpperPrice.getValueFour();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
//				Method myMethodT = getMethod(cls, valueFour);
//				String pants2UpperPriceValue = deteleSomeSysmbol(pants2UpperPrice.get(keyValue));
//				int pants2UpperPriceParseInt = 0;
//				if(!"無料".equals(pants2UpperPriceValue)) {
//					pants2UpperPriceParseInt = Integer.parseInt(pants2UpperPriceValue);
//				}
//				Object[] argsDetailValue = {pants2UpperPriceParseInt};
//				if (myMethodT != null) {
//					ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//		}
//	}
//	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 * @param pantsUpperPrice
//	 */
//	public void standardPantsUpperPriceInDb(OrderForm orderForm,Order order,Map<String, String> pantsUpperPrice) {
//		PantsCoOptionStandardUpperPriceEnum[] pantsCoOptionStandardUpperPriceEnum = PantsCoOptionStandardUpperPriceEnum.values();
//		for(PantsCoOptionStandardUpperPriceEnum pantsCoOptionStandardUpperPrice : pantsCoOptionStandardUpperPriceEnum) {
//			String keyValue = pantsCoOptionStandardUpperPrice.getValueThree();
//			String valueFour = pantsCoOptionStandardUpperPrice.getValueFour();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
//				Method myMethodT = getMethod(cls, valueFour);
//				String pantsUpperPriceValue = deteleSomeSysmbol(pantsUpperPrice.get(keyValue));
//				int pantsUpperPriceParseInt = 0;
//				if(!"無料".equals(pantsUpperPriceValue)) {
//					pantsUpperPriceParseInt = Integer.parseInt(pantsUpperPriceValue);
//				}
//				Object[] argsDetailValue = {pantsUpperPriceParseInt};
//				if (myMethodT != null) {
//					ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//		}
//	}
//	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 * @param shirtUpperPrice
//	 */
//	public void standardShirtUpperPriceInDb(OrderForm orderForm,Order order,Map<String, String> shirtUpperPrice) {
//		ShirtCoOptionStandardUpperPriceEnum[] shirtCoOptionStandardUpperPriceEnum = ShirtCoOptionStandardUpperPriceEnum.values();
//		for(ShirtCoOptionStandardUpperPriceEnum shirtCoOptionStandardUpperPrice : shirtCoOptionStandardUpperPriceEnum) {
//			String keyValue = shirtCoOptionStandardUpperPrice.getValueTwo();
//			String valueThree = shirtCoOptionStandardUpperPrice.getValueThree();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
//				Method myMethodT = getMethod(cls, valueThree);
//				String shirtUpperPriceValue = deteleSomeSysmbol(shirtUpperPrice.get(keyValue));
//				int shirtUpperPriceParseInt = 0;
//				if(!"無料".equals(shirtUpperPriceValue)) {
//					shirtUpperPriceParseInt = Integer.parseInt(shirtUpperPriceValue);
//				}
//				Object[] argsDetailValue = {shirtUpperPriceParseInt};
//				if (myMethodT != null) {
//					ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//		}
//	}
//	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 * @param coatUpperPrice
//	 */
//	public void standardCoatUpperPriceInDb(OrderForm orderForm,Order order,Map<String, String> coatUpperPrice) {
//		CoatCoOptionStandardUpperPriceEnum[] coatCoOptionStandardUpperPriceEnum = CoatCoOptionStandardUpperPriceEnum.values();
//		for(CoatCoOptionStandardUpperPriceEnum coatCoOptionStandardUpperPrice : coatCoOptionStandardUpperPriceEnum) {
//			String keyValue = coatCoOptionStandardUpperPrice.getValueThree();
//			String valueFour = coatCoOptionStandardUpperPrice.getValueFour();
//			
//			Class<?> cls;
//			try {
//				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
//				Method myMethodT = getMethod(cls, valueFour);
//				String coatUpperPriceValue = deteleSomeSysmbol(coatUpperPrice.get(keyValue));
//				int coatUpperPriceParseInt = 0;
//				if(!"無料".equals(coatUpperPriceValue)) {
//					coatUpperPriceParseInt = Integer.parseInt(coatUpperPriceValue);
//				}
//				Object[] argsDetailValue = {coatUpperPriceParseInt};
//				if (myMethodT != null) {
//					ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//			}
//		}
//	}
//	
//	/**
//	 * 
//	 * @param changString
//	 * @return
//	 */
//	public String deteleSomeSysmbol(String changString) {
//		String replaceAfter = null;
//		if(!"無料".equals(changString)) {
//			if(changString.indexOf("￥") != -1) {
//				replaceAfter = changString.replace("￥", "");
//			}
//			if(replaceAfter.indexOf(",") != -1) {
//				replaceAfter = replaceAfter.replaceAll(",", "");
//			}
//		}
//		if(replaceAfter == null) {
//			replaceAfter = "0";
//		}
//		return replaceAfter;
//	}
	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param standardSomePriceList
//	 * @return
//	 */
//	public Map<String, String> standardJkOjStitchModifyPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardSomePriceList) {
//		
//		//フロント釦数
//		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
//		//0000105(ダブル6つボタン)
//		String ojFrontBtnCntdoubleSixButton = "0000105";
//		//0000106(ダブル4つボタン)
//		String ojFrontBtnCntdoubleFourButton = "0000106";
//		//標準JACKETのステッチ箇所変更
//		String ojStitchModifyPlace1 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace1();
//		String ojStitchModifyPlace2 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace2();
//		String ojStitchModifyPlace3 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace3();
//		String ojStitchModifyPlace4 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace4();
//		String ojStitchModifyPlace5 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace5();
//		String ojStitchModifyPlace6 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace6();
//		String ojStitchModifyPlace7 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace7();
//		String ojStitchModifyPlace8 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace8();
//		String ojStitchModifyPlace9 = orderForm.getOptionJacketStandardInfo().getOjStitchModifyPlace9();
//		
//		List<String> ojStitchModifyPlaceList = new ArrayList<>();
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace1);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace2);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace3);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace4);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace5);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace6);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace7);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace8);
//		ojStitchModifyPlaceList.add(ojStitchModifyPlace9);
//		ojStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  ojStitchModifyPlaceMap = new HashMap<String,String>();
//		for(String ojStitchModifyPlace : ojStitchModifyPlaceList) {
//			
//			for(OrderPrice orderPrice : standardSomePriceList) {
//				if(ojStitchModifyPlace.equals(orderPrice.getOptinBranchCode())) {
//					if(ojFrontBtnCntdoubleSixButton.equals(ojFrontBtnCnt) || ojFrontBtnCntdoubleFourButton.equals(ojFrontBtnCnt)) {
//						optionBranchDoubleorPrice += orderPrice.getOptionBranchDoublePrice();
//					}
//					else {
//						optionBranchDoubleorPrice += orderPrice.getOptionBranchPrice();
//					}
//				}
//			}
//		}
//		if(optionBranchDoubleorPrice == 0) {
//			ojStitchModifyPlaceMap.put("ojStitchModifyPlaceMap", "無料");
//		}
//		else {
//			ojStitchModifyPlaceMap.put("ojStitchModifyPlaceMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return ojStitchModifyPlaceMap;
//	}
	
//	/**
//	 * AMF色指定の上代
//	 * @param orderForm
//	 * @param standardSomePriceList
//	 * @return
//	 */
//	public Map<String, String> standardJkOjAmfColorUpperCount(OrderForm orderForm,List<OrderPrice> standardOjAmfColorPriceList) {
//		
//		//フロント釦数
//		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
//		//0000105(ダブル6つボタン)
//		String ojFrontBtnCntdoubleSixButton = "0000105";
//		//0000106(ダブル4つボタン)
//		String ojFrontBtnCntdoubleFourButton = "0000106";
//		
//		List<String> ojAmfColorsList = new ArrayList<>();
//		//標準JACKETのAMF色指定
//		String ojAmfColorPlace1 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace1();
//		String ojAmfColorPlace2 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace2();
//		String ojAmfColorPlace3 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace3();
//		String ojAmfColorPlace4 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace4();
//		String ojAmfColorPlace5 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace5();
//		String ojAmfColorPlace6 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace6();
//		String ojAmfColorPlace7 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace7();
//		String ojAmfColorPlace8 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace8();
//		String ojAmfColorPlace9 = orderForm.getOptionJacketStandardInfo().getOjAmfColorPlace9();
//		
//		String ojAmfColor1 = orderForm.getOptionJacketStandardInfo().getOjAmfColor1();
//		String ojAmfColor2 = orderForm.getOptionJacketStandardInfo().getOjAmfColor2();
//		String ojAmfColor3 = orderForm.getOptionJacketStandardInfo().getOjAmfColor3();
//		String ojAmfColor4 = orderForm.getOptionJacketStandardInfo().getOjAmfColor4();
//		String ojAmfColor5 = orderForm.getOptionJacketStandardInfo().getOjAmfColor5();
//		String ojAmfColor6 = orderForm.getOptionJacketStandardInfo().getOjAmfColor6();
//		String ojAmfColor7 = orderForm.getOptionJacketStandardInfo().getOjAmfColor7();
//		String ojAmfColor8 = orderForm.getOptionJacketStandardInfo().getOjAmfColor8();
//		String ojAmfColor9 = orderForm.getOptionJacketStandardInfo().getOjAmfColor9();
//		List<String> deteleRepeatValue = deteleRepeatValue(ojAmfColorPlace1, ojAmfColor1, ojAmfColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(ojAmfColorPlace2, ojAmfColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(ojAmfColorPlace3, ojAmfColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(ojAmfColorPlace4, ojAmfColor4, deteleRepeatValue3);
//		List<String> deteleRepeatValue5 = deteleRepeatValue(ojAmfColorPlace5, ojAmfColor5, deteleRepeatValue4);
//		List<String> deteleRepeatValue6 = deteleRepeatValue(ojAmfColorPlace6, ojAmfColor6, deteleRepeatValue5);
//		List<String> deteleRepeatValue7 = deteleRepeatValue(ojAmfColorPlace7, ojAmfColor7, deteleRepeatValue6);
//		List<String> deteleRepeatValue8 = deteleRepeatValue(ojAmfColorPlace8, ojAmfColor8, deteleRepeatValue7);
//		List<String> deteleRepeatValue9 = deteleRepeatValue(ojAmfColorPlace9, ojAmfColor9, deteleRepeatValue8);
//		Integer optionBranchDoubleorPrice = 0;
//		int ojAmfColorSize = deteleRepeatValue9.size();
//		if(ojFrontBtnCntdoubleSixButton.equals(ojFrontBtnCnt) || ojFrontBtnCntdoubleFourButton.equals(ojFrontBtnCnt)) {
//			Integer optionBranchDoublePrice = standardOjAmfColorPriceList.get(0).getOptionBranchDoublePrice();
//			optionBranchDoubleorPrice = ojAmfColorSize * optionBranchDoublePrice;
//		}
//		else {
//			Integer optionBranchPrice = standardOjAmfColorPriceList.get(0).getOptionBranchPrice();
//			optionBranchDoubleorPrice = ojAmfColorSize * optionBranchPrice;
//		}
//		
//		Map<String,String>  ojAmfColorsMap = new HashMap<String,String>();
//		if(optionBranchDoubleorPrice == 0) {
//			ojAmfColorsMap.put("ojAmfColorsMap", "無料");
//		}
//		else {
//			ojAmfColorsMap.put("ojAmfColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return ojAmfColorsMap;
//	}
	
	/**
	 * 削除重複したデータ
	 * @param ojAmfColorPlace
	 * @param ojAmfColor
	 * @param ojAmfColorsList
	 * @return
	 */
	public List<String> deteleRepeatValue(String ojAmfColorPlace,String ojAmfColor,List<String> ojAmfColorsList){
		if(ojAmfColorPlace != null) {
			if(!ojAmfColorsList.contains(ojAmfColor)) {
				ojAmfColorsList.add(ojAmfColor);
			}
		}
		return ojAmfColorsList;
	}
	
//	/**
//	 * ボタン付け糸指定の上代
//	 * @param orderForm
//	 * @param standardOjBhColorPriceList
//	 * @return
//	 */
//	public Map<String, String> standardJkOjByColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOjByColorPriceList) {
//		
//		//フロント釦数
//		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
//		//0000105(ダブル6つボタン)
//		String ojFrontBtnCntdoubleSixButton = "0000105";
//		//0000106(ダブル4つボタン)
//		String ojFrontBtnCntdoubleFourButton = "0000106";
//		
//		List<String> ojAmfColorsList = new ArrayList<>();
//		//標準JACKETのボタンホール色指定
//		String ojByColorPlace1 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace1();
//		String ojByColorPlace2 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace2();
//		String ojByColorPlace3 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace3();
//		String ojByColorPlace4 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace4();
//		String ojByColorPlace5 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace5();
//		String ojByColorPlace6 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace6();
//		String ojByColorPlace7 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace7();
//		String ojByColorPlace8 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace8();
//		String ojByColorPlace9 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace9();
//		String ojByColorPlace10 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace10();
//		String ojByColorPlace11 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace11();
//		String ojByColorPlace12 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace12();
//		String ojByColorPlace13 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace13();
//		String ojByColorPlace14 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace14();
//		String ojByColorPlace15 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace15();
//		String ojByColorPlace16 = orderForm.getOptionJacketStandardInfo().getOjByColorPlace16();
//		
//		String ojByColor1 = orderForm.getOptionJacketStandardInfo().getOjByColor1();
//		String ojByColor2 = orderForm.getOptionJacketStandardInfo().getOjByColor2();
//		String ojByColor3 = orderForm.getOptionJacketStandardInfo().getOjByColor3();
//		String ojByColor4 = orderForm.getOptionJacketStandardInfo().getOjByColor4();
//		String ojByColor5 = orderForm.getOptionJacketStandardInfo().getOjByColor5();
//		String ojByColor6 = orderForm.getOptionJacketStandardInfo().getOjByColor6();
//		String ojByColor7 = orderForm.getOptionJacketStandardInfo().getOjByColor7();
//		String ojByColor8 = orderForm.getOptionJacketStandardInfo().getOjByColor8();
//		String ojByColor9 = orderForm.getOptionJacketStandardInfo().getOjByColor9();
//		String ojByColor10 = orderForm.getOptionJacketStandardInfo().getOjByColor10();
//		String ojByColor11 = orderForm.getOptionJacketStandardInfo().getOjByColor11();
//		String ojByColor12 = orderForm.getOptionJacketStandardInfo().getOjByColor12();
//		String ojByColor13 = orderForm.getOptionJacketStandardInfo().getOjByColor13();
//		String ojByColor14 = orderForm.getOptionJacketStandardInfo().getOjByColor14();
//		String ojByColor15 = orderForm.getOptionJacketStandardInfo().getOjByColor15();
//		String ojByColor16 = orderForm.getOptionJacketStandardInfo().getOjByColor16();
//		
//		List<String> deteleRepeatValue = deteleRepeatValue(ojByColorPlace1, ojByColor1, ojAmfColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(ojByColorPlace2, ojByColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(ojByColorPlace3, ojByColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(ojByColorPlace4, ojByColor4, deteleRepeatValue3);
//		List<String> deteleRepeatValue5 = deteleRepeatValue(ojByColorPlace5, ojByColor5, deteleRepeatValue4);
//		List<String> deteleRepeatValue6 = deteleRepeatValue(ojByColorPlace6, ojByColor6, deteleRepeatValue5);
//		List<String> deteleRepeatValue7 = deteleRepeatValue(ojByColorPlace7, ojByColor7, deteleRepeatValue6);
//		List<String> deteleRepeatValue8 = deteleRepeatValue(ojByColorPlace8, ojByColor8, deteleRepeatValue7);
//		List<String> deteleRepeatValue9 = deteleRepeatValue(ojByColorPlace9, ojByColor9, deteleRepeatValue8);
//		List<String> deteleRepeatValue10 = deteleRepeatValue(ojByColorPlace10, ojByColor10, deteleRepeatValue9);
//		List<String> deteleRepeatValue11 = deteleRepeatValue(ojByColorPlace11, ojByColor11, deteleRepeatValue10);
//		List<String> deteleRepeatValue12 = deteleRepeatValue(ojByColorPlace12, ojByColor12, deteleRepeatValue11);
//		List<String> deteleRepeatValue13 = deteleRepeatValue(ojByColorPlace13, ojByColor13, deteleRepeatValue12);
//		List<String> deteleRepeatValue14 = deteleRepeatValue(ojByColorPlace14, ojByColor14, deteleRepeatValue13);
//		List<String> deteleRepeatValue15 = deteleRepeatValue(ojByColorPlace15, ojByColor15, deteleRepeatValue14);
//		List<String> deteleRepeatValue16 = deteleRepeatValue(ojByColorPlace16, ojByColor16, deteleRepeatValue15);
//		Integer optionBranchDoubleorPrice = 0;
//		int ojByColorSize = deteleRepeatValue16.size();
//		if(ojFrontBtnCntdoubleSixButton.equals(ojFrontBtnCnt) || ojFrontBtnCntdoubleFourButton.equals(ojFrontBtnCnt)) {
//			Integer optionBranchDoublePrice = standardOjByColorPriceList.get(0).getOptionBranchDoublePrice();
//			optionBranchDoubleorPrice = ojByColorSize * optionBranchDoublePrice;
//		}
//		else {
//			Integer optionBranchPrice = standardOjByColorPriceList.get(0).getOptionBranchPrice();
//			optionBranchDoubleorPrice = ojByColorSize * optionBranchPrice;
//		}
//		
//		Map<String,String>  ojByColorsMap = new HashMap<String,String>();
//		if(optionBranchDoubleorPrice == 0) {
//			ojByColorsMap.put("ojByColorsMap", "無料");
//		}
//		else {
//			ojByColorsMap.put("ojByColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return ojByColorsMap;
//	}
	
//	/**
//	 * ボタンホール色指定の上代
//	 * @param orderForm
//	 * @param standardOjBhColorPriceList
//	 * @return
//	 */
//	public Map<String, String> standardJkOjBhColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOjBhColorPriceList) {
//		
//		//フロント釦数
//		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
//		//0000105(ダブル6つボタン)
//		String ojFrontBtnCntdoubleSixButton = "0000105";
//		//0000106(ダブル4つボタン)
//		String ojFrontBtnCntdoubleFourButton = "0000106";
//		
//		List<String> ojAmfColorsList = new ArrayList<>();
//		//標準JACKETのボタン付け糸指定
//		String ojBhColorPlace1 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace1();
//		String ojBhColorPlace2 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace2();
//		String ojBhColorPlace3 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace3();
//		String ojBhColorPlace4 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace4();
//		String ojBhColorPlace5 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace5();
//		String ojBhColorPlace6 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace6();
//		String ojBhColorPlace7 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace7();
//		String ojBhColorPlace8 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace8();
//		String ojBhColorPlace9 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace9();
//		String ojBhColorPlace10 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace10();
//		String ojBhColorPlace11 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace11();
//		String ojBhColorPlace12 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace12();
//		String ojBhColorPlace13 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace13();
//		String ojBhColorPlace14 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace14();
//		String ojBhColorPlace15 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace15();
//		String ojBhColorPlace16 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace16();
//		String ojBhColorPlace17 = orderForm.getOptionJacketStandardInfo().getOjBhColorPlace17();
//		
//		String ojBhColor1 = orderForm.getOptionJacketStandardInfo().getOjBhColor1();
//		String ojBhColor2 = orderForm.getOptionJacketStandardInfo().getOjBhColor2();
//		String ojBhColor3 = orderForm.getOptionJacketStandardInfo().getOjBhColor3();
//		String ojBhColor4 = orderForm.getOptionJacketStandardInfo().getOjBhColor4();
//		String ojBhColor5 = orderForm.getOptionJacketStandardInfo().getOjBhColor5();
//		String ojBhColor6 = orderForm.getOptionJacketStandardInfo().getOjBhColor6();
//		String ojBhColor7 = orderForm.getOptionJacketStandardInfo().getOjBhColor7();
//		String ojBhColor8 = orderForm.getOptionJacketStandardInfo().getOjBhColor8();
//		String ojBhColor9 = orderForm.getOptionJacketStandardInfo().getOjBhColor9();
//		String ojBhColor10 = orderForm.getOptionJacketStandardInfo().getOjBhColor10();
//		String ojBhColor11 = orderForm.getOptionJacketStandardInfo().getOjBhColor11();
//		String ojBhColor12 = orderForm.getOptionJacketStandardInfo().getOjBhColor12();
//		String ojBhColor13 = orderForm.getOptionJacketStandardInfo().getOjBhColor13();
//		String ojBhColor14 = orderForm.getOptionJacketStandardInfo().getOjBhColor14();
//		String ojBhColor15 = orderForm.getOptionJacketStandardInfo().getOjBhColor15();
//		String ojBhColor16 = orderForm.getOptionJacketStandardInfo().getOjBhColor16();
//		String ojBhColor17 = orderForm.getOptionJacketStandardInfo().getOjBhColor17();
//		
//		List<String> deteleRepeatValue = deteleRepeatValue(ojBhColorPlace1, ojBhColor1, ojAmfColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(ojBhColorPlace2, ojBhColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(ojBhColorPlace3, ojBhColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(ojBhColorPlace4, ojBhColor4, deteleRepeatValue3);
//		List<String> deteleRepeatValue5 = deteleRepeatValue(ojBhColorPlace5, ojBhColor5, deteleRepeatValue4);
//		List<String> deteleRepeatValue6 = deteleRepeatValue(ojBhColorPlace6, ojBhColor6, deteleRepeatValue5);
//		List<String> deteleRepeatValue7 = deteleRepeatValue(ojBhColorPlace7, ojBhColor7, deteleRepeatValue6);
//		List<String> deteleRepeatValue8 = deteleRepeatValue(ojBhColorPlace8, ojBhColor8, deteleRepeatValue7);
//		List<String> deteleRepeatValue9 = deteleRepeatValue(ojBhColorPlace9, ojBhColor9, deteleRepeatValue8);
//		List<String> deteleRepeatValue10 = deteleRepeatValue(ojBhColorPlace10, ojBhColor10, deteleRepeatValue9);
//		List<String> deteleRepeatValue11 = deteleRepeatValue(ojBhColorPlace11, ojBhColor11, deteleRepeatValue10);
//		List<String> deteleRepeatValue12 = deteleRepeatValue(ojBhColorPlace12, ojBhColor12, deteleRepeatValue11);
//		List<String> deteleRepeatValue13 = deteleRepeatValue(ojBhColorPlace13, ojBhColor13, deteleRepeatValue12);
//		List<String> deteleRepeatValue14 = deteleRepeatValue(ojBhColorPlace14, ojBhColor14, deteleRepeatValue13);
//		List<String> deteleRepeatValue15 = deteleRepeatValue(ojBhColorPlace15, ojBhColor15, deteleRepeatValue14);
//		List<String> deteleRepeatValue16 = deteleRepeatValue(ojBhColorPlace16, ojBhColor16, deteleRepeatValue15);
//		List<String> deteleRepeatValue17 = deteleRepeatValue(ojBhColorPlace17, ojBhColor17, deteleRepeatValue16);
//		Integer optionBranchDoubleorPrice = 0;
//		int ojBhColorSize = deteleRepeatValue17.size();
//		if(ojFrontBtnCntdoubleSixButton.equals(ojFrontBtnCnt) || ojFrontBtnCntdoubleFourButton.equals(ojFrontBtnCnt)) {
//			Integer optionBranchDoublePrice = standardOjBhColorPriceList.get(0).getOptionBranchDoublePrice();
//			optionBranchDoubleorPrice = ojBhColorSize * optionBranchDoublePrice;
//		}
//		else {
//			Integer optionBranchPrice = standardOjBhColorPriceList.get(0).getOptionBranchPrice();
//			optionBranchDoubleorPrice = ojBhColorSize * optionBranchPrice;
//		}
//		
//		Map<String,String>  ojBhColorsMap = new HashMap<String,String>();
//		if(optionBranchDoubleorPrice == 0) {
//			ojBhColorsMap.put("ojBhColorsMap", "無料");
//		}
//		else {
//			ojBhColorsMap.put("ojBhColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return ojBhColorsMap;
//	}
	
//	/**
//	 * ステッチ箇所変更の上代
//	 * @param orderForm
//	 * @param standardOgStitchModifyPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardGlOgStitchModifyPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOgStitchModifyPlacePriceList) {
//		
//		//GILETモデル
//		String OgGiletModel = orderForm.getOptionGiletStandardInfo().getOgGiletModelMap().get(orderForm.getOptionGiletStandardInfo().getOgGiletModel());
//		//BS01-D
//		String bs01dModel = "BS01-D";
//		//ET15-D
//		String et15dModel = "ET15-D";
//		//標準JACKETのステッチ箇所変更
//		String ogStitchModifyPlace1 = orderForm.getOptionGiletStandardInfo().getOgStitchModifyPlace1();
//		String ogStitchModifyPlace2 = orderForm.getOptionGiletStandardInfo().getOgStitchModifyPlace2();
//		String ogStitchModifyPlace3 = orderForm.getOptionGiletStandardInfo().getOgStitchModifyPlace3();
//		
//		List<String> ogStitchModifyPlaceList = new ArrayList<>();
//		ogStitchModifyPlaceList.add(ogStitchModifyPlace1);
//		ogStitchModifyPlaceList.add(ogStitchModifyPlace2);
//		ogStitchModifyPlaceList.add(ogStitchModifyPlace3);
//		ogStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  ogStitchModifyPlaceMap = new HashMap<String,String>();
//		for(String ogStitchModifyPlace : ogStitchModifyPlaceList) {
//			for(OrderPrice orderPrice : standardOgStitchModifyPlacePriceList) {
//				if(ogStitchModifyPlace.equals(orderPrice.getOptinBranchCode())) {
//					if(bs01dModel.equals(OgGiletModel) || et15dModel.equals(OgGiletModel)) {
//						optionBranchDoubleorPrice += orderPrice.getOptionBranchDoublePrice();
//					}
//					else {
//						optionBranchDoubleorPrice += orderPrice.getOptionBranchPrice();
//					}
//				}
//			}
//		}
//		if(optionBranchDoubleorPrice == 0) {
//			ogStitchModifyPlaceMap.put("ogStitchModifyPlaceMap", "無料");
//		}
//		else {
//			ogStitchModifyPlaceMap.put("ogStitchModifyPlaceMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return ogStitchModifyPlaceMap;
//	}
	
//	/**
//	 * AMF色指定の上代
//	 * @param orderForm
//	 * @param standardOgAmfColorPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardGlOgAmfColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOgAmfColorPlacePriceList) {
//		
//		//GILETモデル
//		String OgGiletModel = orderForm.getOptionGiletStandardInfo().getOgGiletModelMap().get(orderForm.getOptionGiletStandardInfo().getOgGiletModel());
//		//BS01-D
//		String bs01dModel = "BS01-D";
//		//ET15-D
//		String et15dModel = "ET15-D";
//		//標準JACKETのAMF色指定
//		String ogAmfColorPlace1 = orderForm.getOptionGiletStandardInfo().getOgAmfColorPlace1();
//		String ogAmfColorPlace2 = orderForm.getOptionGiletStandardInfo().getOgAmfColorPlace2();
//		String ogAmfColorPlace3 = orderForm.getOptionGiletStandardInfo().getOgAmfColorPlace3();
//		
//		String ogAmfColor1 = orderForm.getOptionGiletStandardInfo().getOgAmfColor1();
//		String ogAmfColor2 = orderForm.getOptionGiletStandardInfo().getOgAmfColor2();
//		String ogAmfColor3 = orderForm.getOptionGiletStandardInfo().getOgAmfColor3();
//		
//		List<String> ogAmfColorPlaceList = new ArrayList<>();
//		List<String> deteleRepeatValue = deteleRepeatValue(ogAmfColorPlace1, ogAmfColor1, ogAmfColorPlaceList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(ogAmfColorPlace2, ogAmfColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(ogAmfColorPlace3, ogAmfColor3, deteleRepeatValue2);
//		
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  ogAmfColorPlaceMap = new HashMap<String,String>();
//		int ogAmfColorSize = deteleRepeatValue3.size();
//		
//		if(bs01dModel.equals(OgGiletModel) || et15dModel.equals(OgGiletModel)) {
//			Integer optionBranchDoublePrice = standardOgAmfColorPlacePriceList.get(0).getOptionBranchDoublePrice();
//			optionBranchDoubleorPrice = ogAmfColorSize * optionBranchDoublePrice;
//		}
//		else {
//			Integer optionBranchDoublePrice = standardOgAmfColorPlacePriceList.get(0).getOptionBranchPrice();
//			optionBranchDoubleorPrice = ogAmfColorSize * optionBranchDoublePrice;
//		}
//		if(optionBranchDoubleorPrice == 0) {
//			ogAmfColorPlaceMap.put("ogAmfColorPlaceMap", "無料");
//		}
//		else {
//			ogAmfColorPlaceMap.put("ogAmfColorPlaceMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return ogAmfColorPlaceMap;
//	}
	
//	/**
//	 * ボタンホール色指定の上代
//	 * @param orderForm
//	 * @param standardOgBhColorPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardGlOgBhColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOgBhColorPlacePriceList) {
//		
//		//GILETモデル
//		String OgGiletModel = orderForm.getOptionGiletStandardInfo().getOgGiletModelMap().get(orderForm.getOptionGiletStandardInfo().getOgGiletModel());
//		//BS01-D
//		String bs01dModel = "BS01-D";
//		//ET15-D
//		String et15dModel = "ET15-D";
//		//標準JACKETのボタンホール色指定
//		String ogBhColorPlace1 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace1();
//		String ogBhColorPlace2 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace2();
//		String ogBhColorPlace3 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace3();
//		String ogBhColorPlace4 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace4();
//		String ogBhColorPlace5 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace5();
//		String ogBhColorPlace6 = orderForm.getOptionGiletStandardInfo().getOgBhColorPlace6();
//		
//		String ogBhColor1 = orderForm.getOptionGiletStandardInfo().getOgBhColor1();
//		String ogBhColor2 = orderForm.getOptionGiletStandardInfo().getOgBhColor2();
//		String ogBhColor3 = orderForm.getOptionGiletStandardInfo().getOgBhColor3();
//		String ogBhColor4 = orderForm.getOptionGiletStandardInfo().getOgBhColor4();
//		String ogBhColor5 = orderForm.getOptionGiletStandardInfo().getOgBhColor5();
//		String ogBhColor6 = orderForm.getOptionGiletStandardInfo().getOgBhColor6();
//		
//		List<String> ogBhColorsList = new ArrayList<>();
//		List<String> deteleRepeatValue = deteleRepeatValue(ogBhColorPlace1, ogBhColor1, ogBhColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(ogBhColorPlace2, ogBhColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(ogBhColorPlace3, ogBhColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(ogBhColorPlace4, ogBhColor4, deteleRepeatValue3);
//		List<String> deteleRepeatValue5 = deteleRepeatValue(ogBhColorPlace5, ogBhColor5, deteleRepeatValue4);
//		List<String> deteleRepeatValue6 = deteleRepeatValue(ogBhColorPlace6, ogBhColor6, deteleRepeatValue5);
//		
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  ogBhColorsMap = new HashMap<String,String>();
//		int ogBhColorSize = deteleRepeatValue6.size();
//		
//		if(bs01dModel.equals(OgGiletModel) || et15dModel.equals(OgGiletModel)) {
//			Integer optionBranchDoublePrice = standardOgBhColorPlacePriceList.get(0).getOptionBranchDoublePrice();
//			optionBranchDoubleorPrice = ogBhColorSize * optionBranchDoublePrice;
//		}
//		else {
//			Integer optionBranchDoublePrice = standardOgBhColorPlacePriceList.get(0).getOptionBranchPrice();
//			optionBranchDoubleorPrice = ogBhColorSize * optionBranchDoublePrice;
//		}
//		if(optionBranchDoubleorPrice == 0) {
//			ogBhColorsMap.put("ogBhColorsMap", "無料");
//		}
//		else {
//			ogBhColorsMap.put("ogBhColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return ogBhColorsMap;
//	}
	
//	/**
//	 * ボタン付け糸指定の上代
//	 * @param orderForm
//	 * @param standardOgByColorPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardGlOgByColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOgByColorPlacePriceList) {
//		
//		//GILETモデル
//		String OgGiletModel = orderForm.getOptionGiletStandardInfo().getOgGiletModelMap().get(orderForm.getOptionGiletStandardInfo().getOgGiletModel());
//		//BS01-D
//		String bs01dModel = "BS01-D";
//		//ET15-D
//		String et15dModel = "ET15-D";
//		//標準JACKETのボタンホール色指定
//		String ogByColorPlace1 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace1();
//		String ogByColorPlace2 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace2();
//		String ogByColorPlace3 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace3();
//		String ogByColorPlace4 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace4();
//		String ogByColorPlace5 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace5();
//		String ogByColorPlace6 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace6();
//		String ogByColorPlace7 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace7();
//		String ogByColorPlace8 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace8();
//		String ogByColorPlace9 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace9();
//		String ogByColorPlace10 = orderForm.getOptionGiletStandardInfo().getOgByColorPlace10();
//		
//		String ogByColor1 = orderForm.getOptionGiletStandardInfo().getOgByColor1();
//		String ogByColor2 = orderForm.getOptionGiletStandardInfo().getOgByColor2();
//		String ogByColor3 = orderForm.getOptionGiletStandardInfo().getOgByColor3();
//		String ogByColor4 = orderForm.getOptionGiletStandardInfo().getOgByColor4();
//		String ogByColor5 = orderForm.getOptionGiletStandardInfo().getOgByColor5();
//		String ogByColor6 = orderForm.getOptionGiletStandardInfo().getOgByColor6();
//		String ogByColor7 = orderForm.getOptionGiletStandardInfo().getOgByColor7();
//		String ogByColor8 = orderForm.getOptionGiletStandardInfo().getOgByColor8();
//		String ogByColor9 = orderForm.getOptionGiletStandardInfo().getOgByColor9();
//		String ogByColor10 = orderForm.getOptionGiletStandardInfo().getOgByColor10();
//		
//		List<String> ogBhColorsList = new ArrayList<>();
//		List<String> deteleRepeatValue = deteleRepeatValue(ogByColorPlace1, ogByColor1, ogBhColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(ogByColorPlace2, ogByColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(ogByColorPlace3, ogByColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(ogByColorPlace4, ogByColor4, deteleRepeatValue3);
//		List<String> deteleRepeatValue5 = deteleRepeatValue(ogByColorPlace5, ogByColor5, deteleRepeatValue4);
//		List<String> deteleRepeatValue6 = deteleRepeatValue(ogByColorPlace6, ogByColor6, deteleRepeatValue5);
//		List<String> deteleRepeatValue7 = deteleRepeatValue(ogByColorPlace7, ogByColor7, deteleRepeatValue6);
//		List<String> deteleRepeatValue8 = deteleRepeatValue(ogByColorPlace8, ogByColor8, deteleRepeatValue7);
//		List<String> deteleRepeatValue9 = deteleRepeatValue(ogByColorPlace9, ogByColor9, deteleRepeatValue8);
//		List<String> deteleRepeatValue10 = deteleRepeatValue(ogByColorPlace10, ogByColor10, deteleRepeatValue9);
//		
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  ogByColorsMap = new HashMap<String,String>();
//		int ogBhColorSize = deteleRepeatValue10.size();
//		
//		if(bs01dModel.equals(OgGiletModel) || et15dModel.equals(OgGiletModel)) {
//			Integer optionBranchDoublePrice = standardOgByColorPlacePriceList.get(0).getOptionBranchDoublePrice();
//			optionBranchDoubleorPrice = ogBhColorSize * optionBranchDoublePrice;
//		}
//		else {
//			Integer optionBranchDoublePrice = standardOgByColorPlacePriceList.get(0).getOptionBranchPrice();
//			optionBranchDoubleorPrice = ogBhColorSize * optionBranchDoublePrice;
//		}
//		if(optionBranchDoubleorPrice == 0) {
//			ogByColorsMap.put("ogByColorsMap", "無料");
//		}
//		else {
//			ogByColorsMap.put("ogByColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return ogByColorsMap;
//	}
	
//	/**
//	 * ステッチ箇所変更の上代
//	 * @param orderForm
//	 * @param standardOpStitchModifyPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardPtOgStitchModifyPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOpStitchModifyPlacePriceList) {
//		
//		//標準JACKETのステッチ箇所変更
//		String opStitchModifyPlace1 = orderForm.getOptionPantsStandardInfo().getOpStitchModifyPlace1();
//		String opStitchModifyPlace2 = orderForm.getOptionPantsStandardInfo().getOpStitchModifyPlace2();
//		String opStitchModifyPlace3 = orderForm.getOptionPantsStandardInfo().getOpStitchModifyPlace3();
//		String opStitchModifyPlace4 = orderForm.getOptionPantsStandardInfo().getOpStitchModifyPlace4();
//		
//		List<String> opStitchModifyPlaceList = new ArrayList<>();
//		opStitchModifyPlaceList.add(opStitchModifyPlace1);
//		opStitchModifyPlaceList.add(opStitchModifyPlace2);
//		opStitchModifyPlaceList.add(opStitchModifyPlace3);
//		opStitchModifyPlaceList.add(opStitchModifyPlace4);
//		opStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  opStitchModifyPlaceMap = new HashMap<String,String>();
//		for(String opStitchModifyPlace : opStitchModifyPlaceList) {
//			for(OrderPrice orderPrice : standardOpStitchModifyPlacePriceList) {
//				if(opStitchModifyPlace.equals(orderPrice.getOptinBranchCode())) {
//					optionBranchDoubleorPrice += orderPrice.getOptionBranchPrice();
//				}
//			}
//		}
//		if(optionBranchDoubleorPrice == 0) {
//			opStitchModifyPlaceMap.put("opStitchModifyPlaceMap", "無料");
//		}
//		else {
//			opStitchModifyPlaceMap.put("opStitchModifyPlaceMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return opStitchModifyPlaceMap;
//	}
//	
//	/**
//	 * AMF色指定の上代
//	 * @param orderForm
//	 * @param standardOgByColorPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardPtOpAmfColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOpAmfColorPlacePriceList) {
//		
//		//標準PANTSのAMF色指定
//		String opAmfColorPlace1 = orderForm.getOptionPantsStandardInfo().getOpAmfColorPlace1();
//		String opAmfColorPlace2 = orderForm.getOptionPantsStandardInfo().getOpAmfColorPlace2();
//		String opAmfColorPlace3 = orderForm.getOptionPantsStandardInfo().getOpAmfColorPlace3();
//		String opAmfColorPlace4 = orderForm.getOptionPantsStandardInfo().getOpAmfColorPlace4();
//		
//		String opAmfColor1 = orderForm.getOptionPantsStandardInfo().getOpAmfColor1();
//		String opAmfColor2 = orderForm.getOptionPantsStandardInfo().getOpAmfColor2();
//		String opAmfColor3 = orderForm.getOptionPantsStandardInfo().getOpAmfColor3();
//		String opAmfColor4 = orderForm.getOptionPantsStandardInfo().getOpAmfColor4();
//		
//		List<String> opAmfColorsList = new ArrayList<>();
//		List<String> deteleRepeatValue = deteleRepeatValue(opAmfColorPlace1, opAmfColor1, opAmfColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(opAmfColorPlace2, opAmfColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(opAmfColorPlace3, opAmfColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(opAmfColorPlace4, opAmfColor4, deteleRepeatValue3);
//		
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  opAmfColorsMap = new HashMap<String,String>();
//		int opAmfColorSize = deteleRepeatValue4.size();
//		
//		Integer optionBranchDoublePrice = standardOpAmfColorPlacePriceList.get(0).getOptionBranchDoublePrice();
//		optionBranchDoubleorPrice = opAmfColorSize * optionBranchDoublePrice;
//
//		if(optionBranchDoubleorPrice == 0) {
//			opAmfColorsMap.put("opAmfColorsMap", "無料");
//		}
//		else {
//			opAmfColorsMap.put("opAmfColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		return opAmfColorsMap;
//	}
//	
//	/**
//	 * ボタンホール色指定の上代
//	 * @param orderForm
//	 * @param standardOpBhColorPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardPtOpBhColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOpBhColorPlacePriceList) {
//		
//		//標準PANTSのボタンホール色指定
//		String opBhColorPlace1 = orderForm.getOptionPantsStandardInfo().getOpBhColorPlace1();
//		String opBhColorPlace2 = orderForm.getOptionPantsStandardInfo().getOpBhColorPlace2();
//		String opBhColorPlace3 = orderForm.getOptionPantsStandardInfo().getOpBhColorPlace3();
//		String opBhColorPlace4 = orderForm.getOptionPantsStandardInfo().getOpBhColorPlace4();
//		
//		String opBhColor1 = orderForm.getOptionPantsStandardInfo().getOpBhColor1();
//		String opBhColor2 = orderForm.getOptionPantsStandardInfo().getOpBhColor2();
//		String opBhColor3 = orderForm.getOptionPantsStandardInfo().getOpBhColor3();
//		String opBhColor4 = orderForm.getOptionPantsStandardInfo().getOpBhColor4();
//		
//		List<String> opBhColorsList = new ArrayList<>();
//		List<String> deteleRepeatValue = deteleRepeatValue(opBhColorPlace1, opBhColor1, opBhColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(opBhColorPlace2, opBhColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(opBhColorPlace3, opBhColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(opBhColorPlace4, opBhColor4, deteleRepeatValue3);
//		
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  opBhColorsMap = new HashMap<String,String>();
//		int opBhColorSize = deteleRepeatValue4.size();
//		
//		Integer optionBranchDoublePrice = standardOpBhColorPlacePriceList.get(0).getOptionBranchDoublePrice();
//		optionBranchDoubleorPrice = opBhColorSize * optionBranchDoublePrice;
//
//		if(optionBranchDoubleorPrice == 0) {
//			opBhColorsMap.put("opBhColorsMap", "無料");
//		}
//		else {
//			opBhColorsMap.put("opBhColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		return opBhColorsMap;
//	}
//	
//	/**
//	 * ボタン付け糸指定の上代
//	 * @param orderForm
//	 * @param standardOpByColorPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardPtOpByColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOpByColorPlacePriceList) {
//		
//		//標準PANTSのボタン付け糸指定
//		String opByColorPlace1 = orderForm.getOptionPantsStandardInfo().getOpByColorPlace1();
//		String opByColorPlace2 = orderForm.getOptionPantsStandardInfo().getOpByColorPlace2();
//		String opByColorPlace3 = orderForm.getOptionPantsStandardInfo().getOpByColorPlace3();
//		String opByColorPlace4 = orderForm.getOptionPantsStandardInfo().getOpByColorPlace4();
//		
//		String opByColor1 = orderForm.getOptionPantsStandardInfo().getOpByColor1();
//		String opByColor2 = orderForm.getOptionPantsStandardInfo().getOpByColor2();
//		String opByColor3 = orderForm.getOptionPantsStandardInfo().getOpByColor3();
//		String opByColor4 = orderForm.getOptionPantsStandardInfo().getOpByColor4();
//		
//		List<String> opByColorsList = new ArrayList<>();
//		List<String> deteleRepeatValue = deteleRepeatValue(opByColorPlace1, opByColor1, opByColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(opByColorPlace2, opByColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(opByColorPlace3, opByColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(opByColorPlace4, opByColor4, deteleRepeatValue3);
//		
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  opByColorsMap = new HashMap<String,String>();
//		int opByColorSize = deteleRepeatValue4.size();
//		
//		Integer optionBranchDoublePrice = standardOpByColorPlacePriceList.get(0).getOptionBranchDoublePrice();
//		optionBranchDoubleorPrice = opByColorSize * optionBranchDoublePrice;
//
//		if(optionBranchDoubleorPrice == 0) {
//			opByColorsMap.put("opByColorsMap", "無料");
//		}
//		else {
//			opByColorsMap.put("opByColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		return opByColorsMap;
//	}
	
//	/**
//	 * ステッチ箇所変更の上代
//	 * @param orderForm
//	 * @param standardOp2StitchModifyPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardPt2Op2StitchModifyPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOp2StitchModifyPlacePriceList) {
//		
//		//標準JACKETのステッチ箇所変更
//		String op2StitchModifyPlace1 = orderForm.getOptionPants2StandardInfo().getOp2StitchModifyPlace1();
//		String op2StitchModifyPlace2 = orderForm.getOptionPants2StandardInfo().getOp2StitchModifyPlace2();
//		String op2StitchModifyPlace3 = orderForm.getOptionPants2StandardInfo().getOp2StitchModifyPlace3();
//		String op2StitchModifyPlace4 = orderForm.getOptionPants2StandardInfo().getOp2StitchModifyPlace4();
//		
//		List<String> op2StitchModifyPlaceList = new ArrayList<>();
//		op2StitchModifyPlaceList.add(op2StitchModifyPlace1);
//		op2StitchModifyPlaceList.add(op2StitchModifyPlace2);
//		op2StitchModifyPlaceList.add(op2StitchModifyPlace3);
//		op2StitchModifyPlaceList.add(op2StitchModifyPlace4);
//		op2StitchModifyPlaceList.removeAll(Collections.singleton(null));
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  op2StitchModifyPlaceMap = new HashMap<String,String>();
//		for(String op2StitchModifyPlace : op2StitchModifyPlaceList) {
//			for(OrderPrice orderPrice : standardOp2StitchModifyPlacePriceList) {
//				if(op2StitchModifyPlace.equals(orderPrice.getOptinBranchCode())) {
//					optionBranchDoubleorPrice += orderPrice.getOptionBranchPrice();
//				}
//			}
//		}
//		if(optionBranchDoubleorPrice == 0) {
//			op2StitchModifyPlaceMap.put("op2StitchModifyPlaceMap", "無料");
//		}
//		else {
//			op2StitchModifyPlaceMap.put("op2StitchModifyPlaceMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		
//		return op2StitchModifyPlaceMap;
//	}
//	
//	/**
//	 * AMF色指定の上代
//	 * @param orderForm
//	 * @param standardOp2AmfColorPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardPt2Op2AmfColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOp2AmfColorPlacePriceList) {
//		
//		//標準PANTSのAMF色指定
//		String op2AmfColorPlace1 = orderForm.getOptionPants2StandardInfo().getOp2AmfColorPlace1();
//		String op2AmfColorPlace2 = orderForm.getOptionPants2StandardInfo().getOp2AmfColorPlace2();
//		String op2AmfColorPlace3 = orderForm.getOptionPants2StandardInfo().getOp2AmfColorPlace3();
//		String op2AmfColorPlace4 = orderForm.getOptionPants2StandardInfo().getOp2AmfColorPlace4();
//		
//		String op2AmfColor1 = orderForm.getOptionPants2StandardInfo().getOp2AmfColor1();
//		String op2AmfColor2 = orderForm.getOptionPants2StandardInfo().getOp2AmfColor2();
//		String op2AmfColor3 = orderForm.getOptionPants2StandardInfo().getOp2AmfColor3();
//		String op2AmfColor4 = orderForm.getOptionPants2StandardInfo().getOp2AmfColor4();
//		
//		List<String> op2AmfColorsList = new ArrayList<>();
//		List<String> deteleRepeatValue = deteleRepeatValue(op2AmfColorPlace1, op2AmfColor1, op2AmfColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(op2AmfColorPlace2, op2AmfColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(op2AmfColorPlace3, op2AmfColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(op2AmfColorPlace4, op2AmfColor4, deteleRepeatValue3);
//		
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  op2AmfColorsMap = new HashMap<String,String>();
//		int op2AmfColorSize = deteleRepeatValue4.size();
//		
//		Integer optionBranchDoublePrice = standardOp2AmfColorPlacePriceList.get(0).getOptionBranchDoublePrice();
//		optionBranchDoubleorPrice = op2AmfColorSize * optionBranchDoublePrice;
//
//		if(optionBranchDoubleorPrice == 0) {
//			op2AmfColorsMap.put("op2AmfColorsMap", "無料");
//		}
//		else {
//			op2AmfColorsMap.put("op2AmfColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		return op2AmfColorsMap;
//	}
//	
//	/**
//	 * ボタンホール色指定の上代
//	 * @param orderForm
//	 * @param standardOp2BhColorPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardPt2Op2BhColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOp2BhColorPlacePriceList) {
//		
//		//標準PANTSのボタンホール色指定
//		String op2BhColorPlace1 = orderForm.getOptionPants2StandardInfo().getOp2BhColorPlace1();
//		String op2BhColorPlace2 = orderForm.getOptionPants2StandardInfo().getOp2BhColorPlace2();
//		String op2BhColorPlace3 = orderForm.getOptionPants2StandardInfo().getOp2BhColorPlace3();
//		String op2BhColorPlace4 = orderForm.getOptionPants2StandardInfo().getOp2BhColorPlace4();
//		
//		String op2BhColor1 = orderForm.getOptionPants2StandardInfo().getOp2BhColor1();
//		String op2BhColor2 = orderForm.getOptionPants2StandardInfo().getOp2BhColor2();
//		String op2BhColor3 = orderForm.getOptionPants2StandardInfo().getOp2BhColor3();
//		String op2BhColor4 = orderForm.getOptionPants2StandardInfo().getOp2BhColor4();
//		
//		List<String> op2BhColorsList = new ArrayList<>();
//		List<String> deteleRepeatValue = deteleRepeatValue(op2BhColorPlace1, op2BhColor1, op2BhColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(op2BhColorPlace2, op2BhColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(op2BhColorPlace3, op2BhColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(op2BhColorPlace4, op2BhColor4, deteleRepeatValue3);
//		
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  op2BhColorsMap = new HashMap<String,String>();
//		int op2BhColorSize = deteleRepeatValue4.size();
//		
//		Integer optionBranchDoublePrice = standardOp2BhColorPlacePriceList.get(0).getOptionBranchDoublePrice();
//		optionBranchDoubleorPrice = op2BhColorSize * optionBranchDoublePrice;
//
//		if(optionBranchDoubleorPrice == 0) {
//			op2BhColorsMap.put("op2BhColorsMap", "無料");
//		}
//		else {
//			op2BhColorsMap.put("op2BhColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		return op2BhColorsMap;
//	}
//	
//	/**
//	 * ボタン付け糸指定の上代
//	 * @param orderForm
//	 * @param standardOp2ByColorPlacePriceList
//	 * @return
//	 */
//	public Map<String, String> standardPt2Op2ByColorPlaceUpperCount(OrderForm orderForm,List<OrderPrice> standardOp2ByColorPlacePriceList) {
//		
//		//標準PANTSのボタン付け糸指定
//		String op2ByColorPlace1 = orderForm.getOptionPants2StandardInfo().getOp2ByColorPlace1();
//		String op2ByColorPlace2 = orderForm.getOptionPants2StandardInfo().getOp2ByColorPlace2();
//		String op2ByColorPlace3 = orderForm.getOptionPants2StandardInfo().getOp2ByColorPlace3();
//		String op2ByColorPlace4 = orderForm.getOptionPants2StandardInfo().getOp2ByColorPlace4();
//		
//		String op2ByColor1 = orderForm.getOptionPants2StandardInfo().getOp2ByColor1();
//		String op2ByColor2 = orderForm.getOptionPants2StandardInfo().getOp2ByColor2();
//		String op2ByColor3 = orderForm.getOptionPants2StandardInfo().getOp2ByColor3();
//		String op2ByColor4 = orderForm.getOptionPants2StandardInfo().getOp2ByColor4();
//		
//		List<String> op2ByColorsList = new ArrayList<>();
//		List<String> deteleRepeatValue = deteleRepeatValue(op2ByColorPlace1, op2ByColor1, op2ByColorsList);
//		List<String> deteleRepeatValue2 = deteleRepeatValue(op2ByColorPlace2, op2ByColor2, deteleRepeatValue);
//		List<String> deteleRepeatValue3 = deteleRepeatValue(op2ByColorPlace3, op2ByColor3, deteleRepeatValue2);
//		List<String> deteleRepeatValue4 = deteleRepeatValue(op2ByColorPlace4, op2ByColor4, deteleRepeatValue3);
//		
//		Integer optionBranchDoubleorPrice = 0;
//		Map<String,String>  op2ByColorsMap = new HashMap<String,String>();
//		int op2ByColorSize = deteleRepeatValue4.size();
//		
//		Integer optionBranchDoublePrice = standardOp2ByColorPlacePriceList.get(0).getOptionBranchDoublePrice();
//		optionBranchDoubleorPrice = op2ByColorSize * optionBranchDoublePrice;
//
//		if(optionBranchDoubleorPrice == 0) {
//			op2ByColorsMap.put("op2ByColorsMap", "無料");
//		}
//		else {
//			op2ByColorsMap.put("op2ByColorsMap", "￥" + formatPrice(optionBranchDoubleorPrice.toString()));
//		}
//		return op2ByColorsMap;
//	}

	public void setGoodsPrice(OrderFindFabric orderFindFabric, OrderForm orderForm) {
		//上代
		Integer retailPrice = orderFindFabric.getRetailPrice();
		
		String productItem = orderForm.getProductItem();
		if("01".equals(productItem)) {
			orderFindFabric.setProductPrice(String.valueOf(retailPrice));
		}else if("02".equals(productItem)) {
			//シングルJACKET単品率
			Integer singleJacketOnlyRate = orderFindFabric.getSingleJacketOnlyRate();
			//シングルJacketの単品購買追加金額
			Integer jkSingleOnlyPlusAlphaPrice = orderFindFabric.getJkSingleOnlyPlusAlphaPrice();
			//JACKET単品Single
			BigDecimal jkSinglePice = new BigDecimal(retailPrice).multiply((new BigDecimal(singleJacketOnlyRate).divide(new BigDecimal("100")))).add(new BigDecimal(jkSingleOnlyPlusAlphaPrice));
			orderFindFabric.setProductPrice(String.valueOf(jkSinglePice));
		}else if("03".equals(productItem)) {
			//PANTS単品率
			Integer pantOnlyRate = orderFindFabric.getPantOnlyRate();
			Integer ptOnlyPlusAlphaPrice = orderFindFabric.getPtOnlyPlusAlphaPrice();
			BigDecimal ptProductPrice = new BigDecimal(retailPrice).multiply((new BigDecimal(pantOnlyRate).divide(new BigDecimal("100")))).add(new BigDecimal(ptOnlyPlusAlphaPrice));
			orderFindFabric.setProductPrice(String.valueOf(ptProductPrice));
		}else if("04".equals(productItem)) {
			Integer singleGiletOnlyRate = orderFindFabric.getSingleGiletOnlyRate();
			Integer glSingleOnlyPlusAlphaPrice = orderFindFabric.getGlSingleOnlyPlusAlphaPrice();
			BigDecimal glProductPrice = new BigDecimal(retailPrice).multiply((new BigDecimal(singleGiletOnlyRate).divide(new BigDecimal("100")))).add(new BigDecimal(glSingleOnlyPlusAlphaPrice));
			orderFindFabric.setProductPrice(String.valueOf(glProductPrice));
		}else if("05".equals(productItem)) {
			orderFindFabric.setProductPrice(String.valueOf(retailPrice));
		}else if("06".equals(productItem)) {
			Integer coatSingleOnlyRate = orderFindFabric.getCoatSingleOnlyRate();
			Integer ctSingleOnlyPlusAlphaPrice = orderFindFabric.getCtSingleOnlyPlusAlphaPrice();
			BigDecimal ctProductPrice = new BigDecimal(retailPrice).multiply((new BigDecimal(coatSingleOnlyRate).divide(new BigDecimal("100")))).add(new BigDecimal(ctSingleOnlyPlusAlphaPrice));
			orderFindFabric.setProductPrice(String.valueOf(ctProductPrice));
		}
	}
//	/**
//	 * 標準JACKET
//	 * @param orderForm
//	 * @param order
//	 * @param ojStitchModifyPlaceMap
//	 * @param jacketUpperPrice
//	 * @param ojAmfColorsMap
//	 * @param ojBhColorsMap
//	 * @param ojByColorsMap
//	 */
//	public void setJkCheckBoxInDb(OrderForm orderForm,Order order,Map<String, String> ojStitchModifyPlaceMap,Map<String, String> jacketUpperPrice,
//			Map<String, String> ojAmfColorsMap,Map<String, String> ojBhColorsMap,Map<String, String> ojByColorsMap) {
//		//袖釦
//		order.setJkSleeveBtnRtPrice(0);
//		//内ポケット変更
//		order.setJkInnerPktRtPrice(0);
//		//ステッチ箇所変更
//		String ojStitchModifyPlace = deteleSomeSysmbol(ojStitchModifyPlaceMap.get("ojStitchModifyPlaceMap"));
//		Integer ojStitchModifyPlaceValue = 0;
//		if(!"無料".equals(ojStitchModifyPlace)) {
//			ojStitchModifyPlaceValue = Integer.parseInt(ojStitchModifyPlace);
//		}
//		order.setJkStitchPlcRtPrice(ojStitchModifyPlaceValue);
//		//ダブルステッチ変更
//		String ojDStitchModify = deteleSomeSysmbol(jacketUpperPrice.get("ojDStitchModifyPrice"));
//		String ojDStitchModifyYes = orderForm.getOptionJacketStandardInfo().getOjDStitchModifyMap().get(orderForm.getOptionJacketStandardInfo().getOjDStitchModify());
//		Integer ojDStitchModifyValue = 0;
//		if("有り".equals(ojDStitchModifyYes)) {
//			ojDStitchModifyValue = Integer.parseInt(ojDStitchModify);
//		}
//		order.setJkDblstitchPlcRtPrice(ojDStitchModifyValue);
//		//AMF色指定
//		String ojAmfColor = deteleSomeSysmbol(ojAmfColorsMap.get("ojAmfColorsMap"));
//		Integer ojAmfColorValue = 0;
//		if(!"無料".equals(ojAmfColor)) {
//			ojAmfColorValue = Integer.parseInt(ojAmfColor);
//		}
//		order.setJkAmfColorRtPrice(ojAmfColorValue);
//		//ボタンホール色指定
//		String ojBhColor = deteleSomeSysmbol(ojBhColorsMap.get("ojBhColorsMap"));
//		Integer ojBhColorValue = 0;
//		if(!"無料".equals(ojBhColor)) {
//			ojBhColorValue = Integer.parseInt(ojBhColor);
//		}
//		order.setJkBtnholePlcColorRtPrice(ojBhColorValue);
//		//ボタン付け糸指定
//		String ojByColor = ojByColorsMap.get("ojByColorsMap");
//		Integer ojByColorValue = 0;
//		if(!"無料".equals(ojByColor)) {
//			ojByColorValue = Integer.parseInt(ojByColor);
//		}
//		order.setJkBtnthreadPlcColorRtPrice(ojByColorValue);
//	}

	
	/**
	 * 
	 * @param order
	 * @return 
	 */
	public void checkBasicValue(Order order) {
		ResultMessages messages = ResultMessages.error(); 

		int i = 0; 

		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";

		String productItem = order.getProductItem();
		String productSparePantsClass = order.getProductSparePantsClass();

		if ("01".equals(productItem)) {
			// JACKET_着丈_型サイズ
			BigDecimal corJkBodylengthSize = order.getCorJkBodylengthSize();
			// JACKET_ウエスト_型サイズ
			BigDecimal corJkWaistSize = order.getCorJkWaistSize();
			// JACKET_袖丈右_型サイズ
			BigDecimal corJkRightsleeveSize = order.getCorJkRightsleeveSize();
			// JACKET_袖丈左_型サイズ
			BigDecimal corJkLeftsleeveSize = order.getCorJkLeftsleeveSize();

			// PANTS_ウエスト_型サイズ
			BigDecimal corPtWaistSize = order.getCorPtWaistSize();
			// PANTS_ワタリ_型サイズ
			BigDecimal corPtThighwidthSize = order.getCorPtThighwidthSize();
			// PANTS_裾幅_修正_型サイズ
			BigDecimal corPtHemwidthSize = order.getCorPtHemwidthSize();

			if (corJkBodylengthSize == null || corJkBodylengthSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "JACKETの着丈修正");
				i += 1;
			} else if (corJkWaistSize == null || corJkWaistSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "JACKETのウエスト修正");
				i += 1;
			} else if (corJkRightsleeveSize == null || corJkRightsleeveSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "JACKETの袖丈右修正");
				i += 1;
			} else if (corJkLeftsleeveSize == null || corJkLeftsleeveSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "JACKETの袖丈左修正");
				i += 1;
			} else if (corPtWaistSize == null || corPtWaistSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "PANTSのウエスト修正");
				i += 1;
			} else if (corPtThighwidthSize == null || corPtThighwidthSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "PANTSのワタリ幅修正");
				i += 1;
			} else if (corPtHemwidthSize == null || corPtHemwidthSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "PANTSの裾幅修正");
				i += 1;
			}

			if (productYes.equals(productSparePantsClass)) {
				// 2PANTS_ウエスト_型サイズ
				BigDecimal corPt2WaistSize = order.getCorPt2WaistSize();
				// 2PANTS_ワタリ_型サイズ
				BigDecimal corPt2ThighwidthSize = order.getCorPt2ThighwidthSize();
				// 2PANTS_裾幅_修正_型サイズ
				BigDecimal corPt2HemwidthSize = order.getCorPt2HemwidthSize();
				if (corPt2WaistSize == null || corPt2WaistSize.compareTo(BigDecimal.ZERO) == 0) {
					messages.add("E034", "2PANTSウエスト修正");
					i += 1;
				} else if (corPt2ThighwidthSize == null || corPt2ThighwidthSize.compareTo(BigDecimal.ZERO) == 0) {
					messages.add("E034", "2PANTSワタリ幅修正");
					i += 1;
				} else if (corPt2HemwidthSize == null || corPt2HemwidthSize.compareTo(BigDecimal.ZERO) == 0) {
					messages.add("E034", "2PANTS裾幅修正");
					i += 1;
				}
			}
		} else if ("02".equals(productItem)) {
			// JACKET_着丈_型サイズ
			BigDecimal corJkBodylengthSize = order.getCorJkBodylengthSize();
			// JACKET_ウエスト_型サイズ
			BigDecimal corJkWaistSize = order.getCorJkWaistSize();
			// JACKET_袖丈右_型サイズ
			BigDecimal corJkRightsleeveSize = order.getCorJkRightsleeveSize();
			// JACKET_袖丈左_型サイズ
			BigDecimal corJkLeftsleeveSize = order.getCorJkLeftsleeveSize();

			if (corJkBodylengthSize == null || corJkBodylengthSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "JACKETの着丈修正");
				i += 1;
			} else if (corJkWaistSize == null || corJkWaistSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "JACKETのウエスト修正");
				i += 1;
			} else if (corJkRightsleeveSize == null || corJkRightsleeveSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "JACKETの袖丈右修正");
				i += 1;
			} else if (corJkLeftsleeveSize == null || corJkLeftsleeveSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "JACKETの袖丈左修正");
				i += 1;
			}
		} else if ("03".equals(productItem)) {
			// PANTS_ウエスト_型サイズ
			BigDecimal corPtWaistSize = order.getCorPtWaistSize();
			// PANTS_ワタリ_型サイズ
			BigDecimal corPtThighwidthSize = order.getCorPtThighwidthSize();
			// PANTS_裾幅_修正_型サイズ
			BigDecimal corPtHemwidthSize = order.getCorPtHemwidthSize();

			if (corPtWaistSize == null || corPtWaistSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "PANTSのウエスト修正");
				i += 1;
			} else if (corPtThighwidthSize == null || corPtThighwidthSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "PANTSのワタリ幅修正");
				i += 1;
			} else if (corPtHemwidthSize == null || corPtHemwidthSize.compareTo(BigDecimal.ZERO) == 0) {
				messages.add("E034", "PANTSの裾幅修正");
				i += 1;
			}
		}
		
		if(i != 0) {
			logger.error(messages.toString());
            throw new ResourceNotFoundException(messages);
		}
	}
	
	/**
	 * 
	 * @param adjustByItem
	 * @param orderForm
	 */
	public void checkAbsolutelyAdjust(List<Adjust> adjustByItem,Order order) {
		ResultMessages messages = ResultMessages.error();
		int j = 0;
		
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		
		String productItem = order.getProductItem();
		String productSparePantsClass = order.getProductSparePantsClass();
		
		// JACKET_着丈_型サイズ
		BigDecimal corJkBodylengthSize = order.getCorJkBodylengthSize();
		// JACKET_着丈_グロス
		BigDecimal corJkBodylengthGross = order.getCorJkBodylengthGross();
		
		// JACKET_ウエスト_型サイズ
		BigDecimal corJkWaistSize = order.getCorJkWaistSize();
		// JACKET_ウエスト_グロス
		BigDecimal corJkWaistGross = order.getCorJkWaistGross();
				
		// JACKET_袖丈右_型サイズ
		BigDecimal corJkRightsleeveSize = order.getCorJkRightsleeveSize();
		// JACKET_袖丈右_グロス
		BigDecimal corJkRightsleeveGross = order.getCorJkRightsleeveGross();
		
		// JACKET_袖丈左_型サイズ
		BigDecimal corJkLeftsleeveSize = order.getCorJkLeftsleeveSize();
		// JACKET_袖丈左_グロス
		BigDecimal corJkLeftsleeveGross = order.getCorJkLeftsleeveGross();
		
		// PANTS_ウエスト_型サイズ
		BigDecimal corPtWaistSize = order.getCorPtWaistSize();
		// PANTS_ウエスト_グロス
		BigDecimal corPtWaistGross = order.getCorPtWaistGross();
		
		// PANTS_ワタリ_型サイズ
		BigDecimal corPtThighwidthSize = order.getCorPtThighwidthSize();
		// PANTS_ワタリ_グロス
		BigDecimal corPtThighwidthGross = order.getCorPtThighwidthGross();
		
		// PANTS_裾幅_修正_型サイズ
		BigDecimal corPtHemwidthSize = order.getCorPtHemwidthSize();
		// PANTS_裾幅_修正_グロス
		BigDecimal corPtHemwidthGross = order.getCorPtHemwidthGross();
		
		// 2PANTS_ウエスト_型サイズ
		BigDecimal corPt2WaistSize = order.getCorPt2WaistSize();
		// 2PANTS_ウエスト_グロス
		BigDecimal corPt2WaistGross = order.getCorPt2WaistGross();
		
		// 2PANTS_ワタリ_型サイズ
		BigDecimal corPt2ThighwidthSize = order.getCorPt2ThighwidthSize();
		// 2PANTS_ワタリ_グロス
		BigDecimal corPt2ThighwidthGross = order.getCorPt2ThighwidthGross();
		
		// 2PANTS_裾幅_修正_型サイズ
		BigDecimal corPt2HemwidthSize = order.getCorPt2HemwidthSize();
		// 2PANTS_裾幅_修正_グロス
		BigDecimal corPt2HemwidthGross = order.getCorPt2HemwidthGross();
		
		for(Adjust adjust : adjustByItem) {
			if("01".equals(productItem)) {
				if("01".equals(adjust.getItemCode())) {
					if("02".equals(adjust.getSubItemCode())) {
						// 着丈修正
						if("01".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corJkBodylengthSize);
							BigDecimal addMax = adjusteMax.add(corJkBodylengthSize);
							if(corJkBodylengthGross.compareTo(addMin) == -1 || corJkBodylengthGross.compareTo(addMax) == 1) {
								messages.add("E035","JACKETの着丈修正");
								j += 1;
								break;
							}
						}
						// ウエスト修正
						if("02".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corJkWaistSize);
							BigDecimal addMax = adjusteMax.add(corJkWaistSize);
							if(corJkWaistGross.compareTo(addMin) == -1 || corJkWaistGross.compareTo(addMax) == 1) {
								messages.add("E035","JACKETのウエスト修正");
								j += 1;
								break;
							}
						}
						// 袖丈右修正
						if("03".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corJkRightsleeveSize);
							BigDecimal addMax = adjusteMax.add(corJkRightsleeveSize);
							if(corJkRightsleeveGross.compareTo(addMin) == -1 || corJkRightsleeveGross.compareTo(addMax) == 1) {
								messages.add("E035","JACKETの袖丈右修正");
								j += 1;
								break;
							}
						}
						// 袖丈左修正
						if("04".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corJkLeftsleeveSize);
							BigDecimal addMax = adjusteMax.add(corJkLeftsleeveSize);
							if(corJkLeftsleeveGross.compareTo(addMin) == -1 || corJkLeftsleeveGross.compareTo(addMax) == 1) {
								messages.add("E035","JACKETの袖丈左修正");
								j += 1;
								break;
							}
						}
					}
					if("03".equals(adjust.getSubItemCode())) {
						// ウエスト修正
						if("06".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corPtWaistSize);
							BigDecimal addMax = adjusteMax.add(corPtWaistSize);
							if(corPtWaistGross.compareTo(addMin) == -1 || corPtWaistGross.compareTo(addMax) == 1) {
								messages.add("E035","PANTSのウエスト修正");
								j += 1;
								break;
							}
						}
						// ワタリ修正
						if("07".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corPtThighwidthSize);
							BigDecimal addMax = adjusteMax.add(corPtThighwidthSize);
							if(corPtThighwidthGross.compareTo(addMin) == -1 || corPtThighwidthGross.compareTo(addMax) == 1) {
								messages.add("E035","PANTSのワタリ修正");
								j += 1;
								break;
							}
						}
						// 裾幅修正
						if("08".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corPtHemwidthSize);
							BigDecimal addMax = adjusteMax.add(corPtHemwidthSize);
							if(corPtHemwidthGross.compareTo(addMin) == -1 || corPtHemwidthGross.compareTo(addMax) == 1) {
								messages.add("E035","PANTSのワタリ修正");
								j += 1;
								break;
							}
						}
					}
					if(productYes.equals(productSparePantsClass)) {
						if("07".equals(adjust.getSubItemCode())) {
							// ウエスト修正2
							if("06".equals(adjust.getAdjusteClass())) {
								BigDecimal adjusteMax = adjust.getAdjusteMax();
								BigDecimal adjusteMin = adjust.getAdjusteMin();
								BigDecimal addMin = adjusteMin.add(corPt2WaistSize);
								BigDecimal addMax = adjusteMax.add(corPt2WaistSize);
								if(corPt2WaistGross.compareTo(addMin) == -1 || corPt2WaistGross.compareTo(addMax) == 1) {
									messages.add("E035","2PANTSのウエスト修正2");
									j += 1;
									break;
								}
							}
							// ワタリ修正2
							if("07".equals(adjust.getAdjusteClass())) {
								BigDecimal adjusteMax = adjust.getAdjusteMax();
								BigDecimal adjusteMin = adjust.getAdjusteMin();
								BigDecimal addMin = adjusteMin.add(corPt2ThighwidthSize);
								BigDecimal addMax = adjusteMax.add(corPt2ThighwidthSize);
								if(corPt2ThighwidthGross.compareTo(addMin) == -1 || corPt2ThighwidthGross.compareTo(addMax) == 1) {
									messages.add("E035","2PANTSのワタリ修正2");
									j += 1;
									break;
								}
							}
							// 裾幅修正2
							if("08".equals(adjust.getAdjusteClass())) {
								BigDecimal adjusteMax = adjust.getAdjusteMax();
								BigDecimal adjusteMin = adjust.getAdjusteMin();
								BigDecimal addMin = adjusteMin.add(corPt2HemwidthSize);
								BigDecimal addMax = adjusteMax.add(corPt2HemwidthSize);
								if(corPt2HemwidthGross.compareTo(addMin) == -1 || corPt2HemwidthGross.compareTo(addMax) == 1) {
									messages.add("E035","2PANTSの裾幅修正2");
									j += 1;
									break;
								}
							}
						}
					}
				}
			}
			else if("02".equals(productItem)) {
				if("02".equals(adjust.getItemCode())) {
					if("02".equals(adjust.getSubItemCode())) {
						// 着丈修正
						if("01".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corJkBodylengthSize);
							BigDecimal addMax = adjusteMax.add(corJkBodylengthSize);
							if(corJkBodylengthGross.compareTo(addMin) == -1 || corJkBodylengthGross.compareTo(addMax) == 1) {
								messages.add("E035","JACKETの着丈修正");
								j += 1;
								break;
							}
						}
						// ウエスト修正
						if("02".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corJkWaistSize);
							BigDecimal addMax = adjusteMax.add(corJkWaistSize);
							if(corJkWaistGross.compareTo(addMin) == -1 || corJkWaistGross.compareTo(addMax) == 1) {
								messages.add("E035","JACKETのウエスト修正");
								j += 1;
								break;
							}
						}
						// 袖丈右修正
						if("03".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corJkRightsleeveSize);
							BigDecimal addMax = adjusteMax.add(corJkRightsleeveSize);
							if(corJkRightsleeveGross.compareTo(addMin) == -1 || corJkRightsleeveGross.compareTo(addMax) == 1) {
								messages.add("E035","JACKETの袖丈右修正");
								j += 1;
								break;
							}
						}
						// 袖丈左修正
						if("04".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corJkLeftsleeveSize);
							BigDecimal addMax = adjusteMax.add(corJkLeftsleeveSize);
							if(corJkLeftsleeveGross.compareTo(addMin) == -1 || corJkLeftsleeveGross.compareTo(addMax) == 1) {
								messages.add("E035","JACKETの袖丈左修正");
								j += 1;
								break;
							}
						}
					}
				}
			}
			else if("03".equals(productItem)) {
				if("03".equals(adjust.getItemCode())) {
					if("03".equals(adjust.getSubItemCode())) {
						// ウエスト修正
						if("06".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corPtWaistSize);
							BigDecimal addMax = adjusteMax.add(corPtWaistSize);
							if(corPtWaistGross.compareTo(addMin) == -1 || corPtWaistGross.compareTo(addMax) == 1) {
								messages.add("E035","PANTSのウエスト修正");
								j += 1;
								break;
							}
						}
						// ワタリ修正
						if("07".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corPtThighwidthSize);
							BigDecimal addMax = adjusteMax.add(corPtThighwidthSize);
							if(corPtThighwidthGross.compareTo(addMin) == -1 || corPtThighwidthGross.compareTo(addMax) == 1) {
								messages.add("E035","PANTSのワタリ修正");
								j += 1;
								break;
							}
						}
						// 裾幅修正
						if("08".equals(adjust.getAdjusteClass())) {
							BigDecimal adjusteMax = adjust.getAdjusteMax();
							BigDecimal adjusteMin = adjust.getAdjusteMin();
							BigDecimal addMin = adjusteMin.add(corPtHemwidthSize);
							BigDecimal addMax = adjusteMax.add(corPtHemwidthSize);
							if(corPtHemwidthGross.compareTo(addMin) == -1 || corPtHemwidthGross.compareTo(addMax) == 1) {
								messages.add("E035","PANTSのワタリ修正");
								j += 1;
								break;
							}
						}
					}
				}
			}
		}
		
		if(j != 0) {
			logger.error(messages.toString());
            throw new ResourceNotFoundException(messages);
		}
	}
	
	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 * @param ogStitchModifyPlaceMap
//	 * @param giletUpperPriceMap
//	 * @param ogAmfColorPlaceMap
//	 * @param ogBhColorsMap
//	 * @param ogByColorsMap
//	 */
//	public void setGlCheckBoxInDb(OrderForm orderForm,Order order,Map<String, String> ogStitchModifyPlaceMap,Map<String, String> giletUpperPriceMap,
//			Map<String, String> ogAmfColorPlaceMap,Map<String, String> ogBhColorsMap,Map<String, String> ogByColorsMap) {
//		
//		//ステッチ箇所変更
//		String ogStitchModifyPlace = deteleSomeSysmbol(ogStitchModifyPlaceMap.get("ogStitchModifyPlaceMap"));
//		Integer ogStitchModifyPlaceValue = 0;
//		if(!"無料".equals(ogStitchModifyPlace)) {
//			ogStitchModifyPlaceValue = Integer.parseInt(ogStitchModifyPlace);
//		}
//		order.setGlStitchPlcRtPrice(ogStitchModifyPlaceValue);
//		//ダブルステッチ変更
//		String ogDStitchModify = deteleSomeSysmbol(giletUpperPriceMap.get("ogDStitchModifyPrice"));
//		String ogDStitchModifyYes = orderForm.getOptionGiletStandardInfo().getOgDStitchModifyMap().get(orderForm.getOptionGiletStandardInfo().getOgDStitchModify());
//		Integer ogDStitchModifyValue = 0;
//		if("有り".equals(ogDStitchModifyYes)) {
//			if(!"無料".equals(ogDStitchModify)) {
//				ogDStitchModifyValue = Integer.parseInt(ogDStitchModify);
//			}
//		}
//		order.setGlDblstitchPlcRtPrice(ogDStitchModifyValue);
//		//AMF色指定
//		String ogAmfColorPlace = deteleSomeSysmbol(ogAmfColorPlaceMap.get("ogAmfColorPlaceMap"));
//		Integer ogAmfColorValue = 0;
//		if(!"無料".equals(ogAmfColorPlace)) {
//			ogAmfColorValue = Integer.parseInt(ogAmfColorPlace);
//		}
//		order.setGlAmfColorRtPrice(ogAmfColorValue);
//		//ボタンホール色指定
//		String ogBhColor = ogBhColorsMap.get("ogBhColorsMap");
//		Integer ogBhColorValue = 0;
//		if(!"無料".equals(ogBhColor)) {
//			ogBhColorValue = Integer.parseInt(ogBhColor);
//		}
//		order.setGlBtnholeColorRtPrice(ogBhColorValue);
//		//ボタン付け糸指定
//		String ogByColor = deteleSomeSysmbol(ogByColorsMap.get("ogByColorsMap"));
//		Integer ogByColorValue = 0;
//		if(!"無料".equals(ogByColor)) {
//			ogByColorValue = Integer.parseInt(ogByColor);
//		}
//		order.setGlBtnthreadColorRtPrice(ogByColorValue);
//	}
//	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 * @param opStitchModifyPlaceMap
//	 * @param pantsUpperPriceMap
//	 * @param opAmfColorsMap
//	 * @param opBhColorsMap
//	 * @param opByColorsMap
//	 */
//	public void setPtCheckBoxInDb(OrderForm orderForm,Order order,Map<String, String> opStitchModifyPlaceMap,Map<String, String> pantsUpperPriceMap,
//			Map<String, String> opAmfColorsMap,Map<String, String> opBhColorsMap,Map<String, String> opByColorsMap) {
//		//ベルトループ
//		order.setPtBeltloopRtPrice(0);
//		//ステッチ箇所変更
//		String opStitchModifyPlace = deteleSomeSysmbol(opStitchModifyPlaceMap.get("opStitchModifyPlaceMap"));
//		Integer opStitchModifyPlaceValue = 0;
//		if(!"無料".equals(opStitchModifyPlace)) {
//			opStitchModifyPlaceValue = Integer.parseInt(opStitchModifyPlace);
//		}
//		order.setPtStitchPlcRtPrice(opStitchModifyPlaceValue);
//		//ダブルステッチ
//		String opDStitch = deteleSomeSysmbol(pantsUpperPriceMap.get("opDStitchPrice"));
//		String opDStitchYes = orderForm.getOptionPantsStandardInfo().getOpDStitchMap().get(orderForm.getOptionPantsStandardInfo().getOpDStitch());
//		Integer opDStitchValue = 0;
//		if("有り".equals(opDStitchYes)) {
//			if(!"無料".equals(opDStitch)) {
//				opDStitchValue = Integer.parseInt(opDStitch);
//			}
//		}
//		order.setPtDblstitchPlcRtPrice(opDStitchValue);
//		//AMF色指定
//		String opAmfColor = deteleSomeSysmbol(opAmfColorsMap.get("opAmfColorsMap"));
//		Integer opAmfColorValue = 0;
//		if(!"無料".equals(opAmfColor)) {
//			opAmfColorValue = Integer.parseInt(opAmfColor);
//		}
//		order.setPtAmfColorRtPrice(opAmfColorValue);
//		//ボタンホール色指定
//		String opBhColor = deteleSomeSysmbol(opBhColorsMap.get("opBhColorsMap"));
//		Integer opBhColorValue = 0;
//		if(!"無料".equals(opBhColor)) {
//			opBhColorValue = Integer.parseInt(opBhColor);
//		}
//		order.setPtBtnholeColorRtPrice(opBhColorValue);
//		//ボタン付け糸指定
//		String opByColor = deteleSomeSysmbol(opByColorsMap.get("opByColorsMap"));
//		Integer opByColorValue = 0;
//		if(!"無料".equals(opByColor)) {
//			opByColorValue = Integer.parseInt(opByColor);
//		}
//		order.setPtBtnthreadColorRtPrice(opByColorValue);
//	}
//	
//	/**
//	 * 
//	 * @param orderForm
//	 * @param order
//	 * @param op2StitchModifyPlaceMap
//	 * @param pants2UpperPriceMap
//	 * @param op2AmfColorsMap
//	 * @param op2BhColorsMap
//	 * @param op2ByColorsMap
//	 */
//	public void setPt2CheckBoxInDb(OrderForm orderForm,Order order,Map<String, String> op2StitchModifyPlaceMap,Map<String, String> pants2UpperPriceMap,
//			Map<String, String> op2AmfColorsMap,Map<String, String> op2BhColorsMap,Map<String, String> op2ByColorsMap) {
//		//ベルトループ
//		order.setPt2BeltloopRtPrice(0);
//		//ステッチ箇所変更
//		String op2StitchModifyPlace = deteleSomeSysmbol(op2StitchModifyPlaceMap.get("op2StitchModifyPlaceMap"));
//		Integer op2StitchModifyPlaceValue = 0;
//		if(!"無料".equals(op2StitchModifyPlace)) {
//			op2StitchModifyPlaceValue = Integer.parseInt(op2StitchModifyPlace);
//		}
//		order.setPt2StitchPlcRtPrice(op2StitchModifyPlaceValue);
//		//ダブルステッチ
//		String op2DStitch = deteleSomeSysmbol(pants2UpperPriceMap.get("op2DStitchPrice"));
//		String op2DStitchYes = orderForm.getOptionPants2StandardInfo().getOp2DStitchMap().get(orderForm.getOptionPants2StandardInfo().getOp2DStitch());
//		Integer op2DStitchValue = 0;
//		if("有り".equals(op2DStitchYes)) {
//			if(!"無料".equals(op2DStitch)) {
//				op2DStitchValue = Integer.parseInt(op2DStitch);
//			}
//		}
//		order.setPt2DblstitchPlcRtPrice(op2DStitchValue);
//		//AMF色指定
//		String op2AmfColor = deteleSomeSysmbol(op2AmfColorsMap.get("op2AmfColorsMap"));
//		Integer op2AmfColorValue = 0;
//		if(!"無料".equals(op2AmfColor)) {
//			op2AmfColorValue = Integer.parseInt(op2AmfColor);
//		}
//		order.setPt2AmfColorRtPrice(op2AmfColorValue);
//		//ボタンホール色指定
//		String op2BhColor = deteleSomeSysmbol(op2BhColorsMap.get("op2BhColorsMap"));
//		Integer op2BhColorValue = 0;
//		if(!"無料".equals(op2BhColor)) {
//			op2BhColorValue = Integer.parseInt(op2BhColor);
//		}
//		order.setPt2BtnholeColorRtPrice(op2BhColorValue);
//		//ボタン付け糸指定
//		String op2ByColor = deteleSomeSysmbol(op2ByColorsMap.get("op2ByColorsMap"));
//		Integer op2ByColorValue = 0;
//		if(!"無料".equals(op2ByColor)) {
//			op2ByColorValue = Integer.parseInt(op2ByColor);
//		}
//		order.setPt2BtnthreadColorRtPrice(op2ByColorValue);
//	}
	
	/**
	 * 
	 * @param orderForm
	 * @return
	 */
//	public Map<String,String> tuxedoJkServelItemShow(OrderForm orderForm) {
//		
//		Map<String,String> jacketCompositeProjectsMap = new HashMap<String,String>();
//		//ボタンホール色指定箇所
//		String tjBhColor = orderForm.getOptionJacketTuxedoInfo().getTjBhColorMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor());
//		
//		String tjBhColorPlace1 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace1());
//		String tjBhColorPlace2 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace2());
//		String tjBhColorPlace3 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace3());
//		String tjBhColorPlace4 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace4());
//		String tjBhColorPlace5 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace5());
//		String tjBhColorPlace6 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace6());
//		String tjBhColorPlace7 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace7());
//		String tjBhColorPlace8 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace8());
//		String tjBhColorPlace9 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace9());
//		String tjBhColorPlace10 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace10());
//		String tjBhColorPlace11 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace11());
//		String tjBhColorPlace12 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace12());
//		String tjBhColorPlace13 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace13());
//		String tjBhColorPlace14 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace14());
//		String tjBhColorPlace15 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace15());
//		String tjBhColorPlace16 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace16());
//		String tjBhColorPlace17 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace17());
//		
//		String tjBhColor1 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor1());
//		String tjBhColor2 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor2());
//		String tjBhColor3 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor3());
//		String tjBhColor4 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor4());
//		String tjBhColor5 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor5());
//		String tjBhColor6 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor6());
//		String tjBhColor7 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor7());
//		String tjBhColor8 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor8());
//		String tjBhColor9 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor9());
//		String tjBhColor10 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor10());
//		String tjBhColor11 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor11());
//		String tjBhColor12 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor12());
//		String tjBhColor13 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor13());
//		String tjBhColor14 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor14());
//		String tjBhColor15 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor15());
//		String tjBhColor16 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor16());
//		String tjBhColor17 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBhColor17());	
//		
//		Map<String,String> tjBhColorPlaceAndColorMap = new HashMap<String,String>();
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace1, tjBhColor1);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace2, tjBhColor2);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace3, tjBhColor3);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace4, tjBhColor4);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace5, tjBhColor5);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace6, tjBhColor6);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace7, tjBhColor7);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace8, tjBhColor8);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace9, tjBhColor9);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace10, tjBhColor10);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace11, tjBhColor11);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace12, tjBhColor12);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace13, tjBhColor13);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace14, tjBhColor14);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace15, tjBhColor15);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace16, tjBhColor16);
//		tjBhColorPlaceAndColorMap.put(tjBhColorPlace17, tjBhColor17);
//		StringBuffer tjBhColorPlaceAndColorString = new StringBuffer();
//		tjBhColorPlaceAndColorString.append(tjBhColor + "　　");
//		int tjBhColorPlaceAndColorFlag = 0;
//		for(String key : tjBhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				
//				String value = tjBhColorPlaceAndColorMap.get(key);
//				if(tjBhColorPlaceAndColorFlag == 0 || tjBhColorPlaceAndColorFlag % 3 != 0) {
//					tjBhColorPlaceAndColorString = tjBhColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(tjBhColorPlaceAndColorFlag != 0 && tjBhColorPlaceAndColorFlag % 3 == 0){
//					tjBhColorPlaceAndColorString = tjBhColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				tjBhColorPlaceAndColorFlag += 1;
//			}
//		}
//		
//		jacketCompositeProjectsMap.put("tjBhColorPlaceAndColor", tjBhColorPlaceAndColorString.toString());
//		
//		//ボタン付け糸指定
//		String tjByColor = orderForm.getOptionJacketTuxedoInfo().getTjByColorMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor());
//		
//		String tjByColorPlace1 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace1());
//		String tjByColorPlace2 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace2());
//		String tjByColorPlace3 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace3());
//		String tjByColorPlace4 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace4());
//		String tjByColorPlace5 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace5());
//		String tjByColorPlace6 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace6());
//		String tjByColorPlace7 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace7());
//		String tjByColorPlace8 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace8());
//		String tjByColorPlace9 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace9());
//		String tjByColorPlace10 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace10());
//		String tjByColorPlace11 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace11());
//		String tjByColorPlace12 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace12());
//		String tjByColorPlace13 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace13());
//		String tjByColorPlace14 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace14());
//		String tjByColorPlace15 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace15());
//		String tjByColorPlace16 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace16());
//		
//		String tjByColor1 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor1());
//		String tjByColor2 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor2());
//		String tjByColor3 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor3());
//		String tjByColor4 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor4());
//		String tjByColor5 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor5());
//		String tjByColor6 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor6());
//		String tjByColor7 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor7());
//		String tjByColor8 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor8());
//		String tjByColor9 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor9());
//		String tjByColor10 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor10());
//		String tjByColor11 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor11());
//		String tjByColor12 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor12());
//		String tjByColor13 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor13());
//		String tjByColor14 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor14());
//		String tjByColor15 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor15());
//		String tjByColor16 = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap().get(orderForm.getOptionJacketTuxedoInfo().getTjByColor16());
//		
//		Map<String,String> tjByColorPlaceAndColorMap = new HashMap<String,String>();
//		tjByColorPlaceAndColorMap.put(tjByColorPlace1,tjByColor1);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace2,tjByColor2);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace3,tjByColor3);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace4,tjByColor4);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace5,tjByColor5);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace6,tjByColor6);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace7,tjByColor7);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace8,tjByColor8);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace9,tjByColor9);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace10,tjByColor10);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace11,tjByColor11);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace12,tjByColor12);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace13,tjByColor13);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace14,tjByColor14);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace15,tjByColor15);
//		tjByColorPlaceAndColorMap.put(tjByColorPlace16,tjByColor16);
//		
//		StringBuffer tjByColorPlaceAndColorString = new StringBuffer();
//		tjByColorPlaceAndColorString.append(tjByColor + "　　");
//		int tjByColorPlaceAndColorFlag = 0;
//		for(String key : tjByColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				
//				String value = tjByColorPlaceAndColorMap.get(key);
//				if(tjByColorPlaceAndColorFlag == 0 || tjByColorPlaceAndColorFlag % 3 != 0) {
//					tjByColorPlaceAndColorString = tjByColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(tjByColorPlaceAndColorFlag != 0 && tjByColorPlaceAndColorFlag % 3 == 0){
//					tjByColorPlaceAndColorString = tjByColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				tjByColorPlaceAndColorFlag += 1;
//			}
//		}
//		
//		jacketCompositeProjectsMap.put("tjByColorPlaceAndColor", tjByColorPlaceAndColorString.toString());
//		
//		return jacketCompositeProjectsMap;
//	}
	
	/**
	 * 
	 * @param orderForm
	 * @return
	 */
//	public Map<String,String> tuxedoGlServelItemShow(OrderForm orderForm){
//		Map<String,String> giletCompositeProjectsMap = new HashMap<String,String>();
//		
//		//ボタンホール色指定
//		String tgBhColor = orderForm.getOptionGiletTuxedoInfo().getTgBhColorMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColor());  
//		
//		String tgBhColorPlace1 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace1());
//		String tgBhColorPlace2 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace2());
//		String tgBhColorPlace3 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace3());
//		String tgBhColorPlace4 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace4());
//		String tgBhColorPlace5 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace5());
//		String tgBhColorPlace6 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace6());
//		
//		String tgBhColor1 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColor1());
//		String tgBhColor2 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColor2());
//		String tgBhColor3 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColor3());
//		String tgBhColor4 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColor4());
//		String tgBhColor5 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColor5());
//		String tgBhColor6 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBhColor6());
//		
//		Map<String,String> tgBhColorPlaceAndColorMap = new HashMap<String,String>();
//		tgBhColorPlaceAndColorMap.put(tgBhColorPlace1, tgBhColor1);
//		tgBhColorPlaceAndColorMap.put(tgBhColorPlace2, tgBhColor2);
//		tgBhColorPlaceAndColorMap.put(tgBhColorPlace3, tgBhColor3);
//		tgBhColorPlaceAndColorMap.put(tgBhColorPlace4, tgBhColor4);
//		tgBhColorPlaceAndColorMap.put(tgBhColorPlace5, tgBhColor5);
//		tgBhColorPlaceAndColorMap.put(tgBhColorPlace6, tgBhColor6);
//		
//		StringBuffer tgBhColorPlaceAndColorString = new StringBuffer();
//		tgBhColorPlaceAndColorString.append(tgBhColor + "　　");
//		int tgBhColorPlaceAndColorFlag = 0;
//		for(String key : tgBhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				
//				String value = tgBhColorPlaceAndColorMap.get(key);
//				if(tgBhColorPlaceAndColorFlag == 0 || tgBhColorPlaceAndColorFlag % 3 != 0) {
//					tgBhColorPlaceAndColorString = tgBhColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(tgBhColorPlaceAndColorFlag != 0 && tgBhColorPlaceAndColorFlag % 3 == 0){
//					tgBhColorPlaceAndColorString = tgBhColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				tgBhColorPlaceAndColorFlag += 1;
//			}
//		}
//		
//		giletCompositeProjectsMap.put("tgBhColorPlaceAndColor", tgBhColorPlaceAndColorString.toString());
//		//ボタン付け糸指定
//		String tgByColor = orderForm.getOptionGiletTuxedoInfo().getTgByColorMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor());
//		
//		String tgByColorPlace1 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace1());
//		String tgByColorPlace2 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace2());
//		String tgByColorPlace3 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace3());
//		String tgByColorPlace4 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace4());
//		String tgByColorPlace5 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace5());
//		String tgByColorPlace6 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace6());
//		String tgByColorPlace7 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace7());
//		String tgByColorPlace8 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace8());
//		String tgByColorPlace9 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace9());
//		String tgByColorPlace10 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace10());
//		
//		String tgByColor1 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor1());
//		String tgByColor2 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor2());
//		String tgByColor3 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor3());
//		String tgByColor4 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor4());
//		String tgByColor5 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor5());
//		String tgByColor6 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor6());
//		String tgByColor7 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor7());
//		String tgByColor8 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor8());
//		String tgByColor9 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor9());
//		String tgByColor10 = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap().get(orderForm.getOptionGiletTuxedoInfo().getTgByColor10());
//		
//		Map<String,String> tgByColorPlaceAndColorMap = new HashMap<String,String>();
//		tgByColorPlaceAndColorMap.put(tgByColorPlace1,tgByColor1);
//		tgByColorPlaceAndColorMap.put(tgByColorPlace2,tgByColor2);
//		tgByColorPlaceAndColorMap.put(tgByColorPlace3,tgByColor3);
//		tgByColorPlaceAndColorMap.put(tgByColorPlace4,tgByColor4);
//		tgByColorPlaceAndColorMap.put(tgByColorPlace5,tgByColor5);
//		tgByColorPlaceAndColorMap.put(tgByColorPlace6,tgByColor6);
//		tgByColorPlaceAndColorMap.put(tgByColorPlace7,tgByColor7);
//		tgByColorPlaceAndColorMap.put(tgByColorPlace8,tgByColor8);
//		tgByColorPlaceAndColorMap.put(tgByColorPlace9,tgByColor9);
//		tgByColorPlaceAndColorMap.put(tgByColorPlace10,tgByColor10);
//		
//		StringBuffer tgByColorPlaceAndColorString = new StringBuffer();
//		tgByColorPlaceAndColorString.append(tgByColor + "　　");
//		int tgByColorPlaceAndColorFlag = 0;
//		for(String key : tgByColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				
//				String value = tgByColorPlaceAndColorMap.get(key);
//				if(tgByColorPlaceAndColorFlag == 0 || tgByColorPlaceAndColorFlag % 3 != 0) {
//					tgByColorPlaceAndColorString = tgByColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(tgByColorPlaceAndColorFlag != 0 && tgByColorPlaceAndColorFlag % 3 == 0){
//					tgByColorPlaceAndColorString = tgByColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				tgByColorPlaceAndColorFlag += 1;
//			}
//		}
//		
//		giletCompositeProjectsMap.put("tgByColorPlaceAndColor", tgByColorPlaceAndColorString.toString());
//		
//		return giletCompositeProjectsMap;
//	}
	
	/**
	 * 
	 * @param orderForm
	 * @return
	 */
//	public Map<String,String> tuxedoPtServelItemShow(OrderForm orderForm){
//		Map<String,String> pantsCompositeProjectsMap = new HashMap<String,String>();
//		//ベルトループ
//		String tpBeltLoop = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBeltLoop());
//		
//		String tpBeltLoopPlace1 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace1());
//		String tpBeltLoopPlace2 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace2());
//		String tpBeltLoopPlace3 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace3());
//		String tpBeltLoopPlace4 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace4());
//		String tpBeltLoopPlace5 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace5());
//		String tpBeltLoopPlace6 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace6());
//		String tpBeltLoopPlace7 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace7());
//		StringBuffer tpBeltLoopPlace = new StringBuffer();
//		
//		tpBeltLoopPlace = tpBeltLoopPlace.append(tpBeltLoop + "　　").append(tpBeltLoopPlace1).append(tpBeltLoopPlace2).append(tpBeltLoopPlace3).append(tpBeltLoopPlace4).append(tpBeltLoopPlace5).append(tpBeltLoopPlace6).append(tpBeltLoopPlace7);
//		
//		pantsCompositeProjectsMap.put("tpBeltLoopPlace", tpBeltLoopPlace.toString());
//		//ボタンホール色指定
//		String tpBhColor = orderForm.getOptionPantsTuxedoInfo().getTpBhColorMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBhColor());
//		
//		String tpBhColorPlace1 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlace1());
//		String tpBhColorPlace2 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlace2());
//		String tpBhColorPlace3 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlace3());
//		String tpBhColorPlace4 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlace4());
//		
//		String tpBhColor1 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorsMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBhColor1());
//		String tpBhColor2 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorsMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBhColor2());
//		String tpBhColor3 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorsMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBhColor3());
//		String tpBhColor4 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorsMap().get(orderForm.getOptionPantsTuxedoInfo().getTpBhColor4());
//		
//		Map<String,String> tpBhColorPlaceAndColorMap = new HashMap<String,String>();
//		tpBhColorPlaceAndColorMap.put(tpBhColorPlace1, tpBhColor1);
//		tpBhColorPlaceAndColorMap.put(tpBhColorPlace2, tpBhColor2);
//		tpBhColorPlaceAndColorMap.put(tpBhColorPlace3, tpBhColor3);
//		tpBhColorPlaceAndColorMap.put(tpBhColorPlace4, tpBhColor4);
//		
//		StringBuffer tpBhColorPlaceAndColorString = new StringBuffer();
//		tpBhColorPlaceAndColorString.append(tpBhColor + "　　");
//		int tpBhColorPlaceAndColorFlag = 0;
//		for(String key : tpBhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				
//				String value = tpBhColorPlaceAndColorMap.get(key);
//				if(tpBhColorPlaceAndColorFlag == 0 || tpBhColorPlaceAndColorFlag % 3 != 0) {
//					tpBhColorPlaceAndColorString = tpBhColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(tpBhColorPlaceAndColorFlag != 0 && tpBhColorPlaceAndColorFlag % 3 == 0){
//					tpBhColorPlaceAndColorString = tpBhColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				tpBhColorPlaceAndColorFlag += 1;
//			}
//		}
//		
//		pantsCompositeProjectsMap.put("tpBhColorPlaceAndColor", tpBhColorPlaceAndColorString.toString());
//		//ボタン付け糸指定
//		String tpByColor = orderForm.getOptionPantsTuxedoInfo().getTpByColorMap().get(orderForm.getOptionPantsTuxedoInfo().getTpByColor());
//		
//		String tpByColorPlace1 = orderForm.getOptionPantsTuxedoInfo().getTpByColorPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpByColorPlace1());
//		String tpByColorPlace2 = orderForm.getOptionPantsTuxedoInfo().getTpByColorPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpByColorPlace2());
//		String tpByColorPlace3 = orderForm.getOptionPantsTuxedoInfo().getTpByColorPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpByColorPlace3());
//		String tpByColorPlace4 = orderForm.getOptionPantsTuxedoInfo().getTpByColorPlaceMap().get(orderForm.getOptionPantsTuxedoInfo().getTpByColorPlace4());
//		
//		String tpByColor1 = orderForm.getOptionPantsTuxedoInfo().getTpByColorsMap().get(orderForm.getOptionPantsTuxedoInfo().getTpByColor1());
//		String tpByColor2 = orderForm.getOptionPantsTuxedoInfo().getTpByColorsMap().get(orderForm.getOptionPantsTuxedoInfo().getTpByColor2());
//		String tpByColor3 = orderForm.getOptionPantsTuxedoInfo().getTpByColorsMap().get(orderForm.getOptionPantsTuxedoInfo().getTpByColor3());
//		String tpByColor4 = orderForm.getOptionPantsTuxedoInfo().getTpByColorsMap().get(orderForm.getOptionPantsTuxedoInfo().getTpByColor4());
//		
//		Map<String,String> tpByColorPlaceAndColorMap = new HashMap<String,String>();
//		tpByColorPlaceAndColorMap.put(tpByColorPlace1, tpByColor1);
//		tpByColorPlaceAndColorMap.put(tpByColorPlace2, tpByColor2);
//		tpByColorPlaceAndColorMap.put(tpByColorPlace3, tpByColor3);
//		tpByColorPlaceAndColorMap.put(tpByColorPlace4, tpByColor4);
//		
//		StringBuffer tpByColorPlaceAndColorString = new StringBuffer();
//		tpByColorPlaceAndColorString.append(tpByColor + "　　");
//		int tpByColorPlaceAndColorFlag = 0;
//		for(String key : tpBhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				
//				String value = tpBhColorPlaceAndColorMap.get(key);
//				if(tpByColorPlaceAndColorFlag == 0 || tpByColorPlaceAndColorFlag % 3 != 0) {
//					tpByColorPlaceAndColorString = tpByColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(tpByColorPlaceAndColorFlag != 0 && tpByColorPlaceAndColorFlag % 3 == 0){
//					tpByColorPlaceAndColorString = tpByColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				tpByColorPlaceAndColorFlag += 1;
//			}
//		}
//		
//		pantsCompositeProjectsMap.put("tpByColorPlaceAndColor", tpByColorPlaceAndColorString.toString());
//		
//		return pantsCompositeProjectsMap;
//	}
	
//	/**
//	 * 
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String,String> tuxedoPt2ServelItemShow(OrderForm orderForm){
//		Map<String,String> pants2CompositeProjectsMap = new HashMap<String,String>();
//		//ベルトループ
//		String tp2BeltLoop = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoop());
//		
//		String tp2BeltLoopPlace1 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace1());
//		String tp2BeltLoopPlace2 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace2());
//		String tp2BeltLoopPlace3 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace3());
//		String tp2BeltLoopPlace4 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace4());
//		String tp2BeltLoopPlace5 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace5());
//		String tp2BeltLoopPlace6 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace6());
//		String tp2BeltLoopPlace7 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace7());
//		StringBuffer tp2BeltLoopPlace = new StringBuffer();
//		
//		tp2BeltLoopPlace = tp2BeltLoopPlace.append(tp2BeltLoop + "　　").append(tp2BeltLoopPlace1).append(tp2BeltLoopPlace2).append(tp2BeltLoopPlace3).append(tp2BeltLoopPlace4).append(tp2BeltLoopPlace5).append(tp2BeltLoopPlace6).append(tp2BeltLoopPlace7);
//		
//		pants2CompositeProjectsMap.put("tp2BeltLoopPlace", tp2BeltLoopPlace.toString());
//		//ボタンホール色指定
//		String tp2BhColor = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BhColor());
//		
//		String tp2BhColorPlace1 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlace1());
//		String tp2BhColorPlace2 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlace2());
//		String tp2BhColorPlace3 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlace3());
//		String tp2BhColorPlace4 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlace4());
//		
//		String tp2BhColor1 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlaceAllMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BhColor1());
//		String tp2BhColor2 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlaceAllMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BhColor2());
//		String tp2BhColor3 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlaceAllMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BhColor3());
//		String tp2BhColor4 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlaceAllMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2BhColor4());
//		
//		Map<String,String> tp2BhColorPlaceAndColorMap = new HashMap<String,String>();
//		tp2BhColorPlaceAndColorMap.put(tp2BhColorPlace1, tp2BhColor1);
//		tp2BhColorPlaceAndColorMap.put(tp2BhColorPlace2, tp2BhColor2);
//		tp2BhColorPlaceAndColorMap.put(tp2BhColorPlace3, tp2BhColor3);
//		tp2BhColorPlaceAndColorMap.put(tp2BhColorPlace4, tp2BhColor4);
//		
//		StringBuffer tp2BhColorPlaceAndColorString = new StringBuffer();
//		tp2BhColorPlaceAndColorString.append(tp2BhColor + "　　");
//		int tp2BhColorPlaceAndColorFlag = 0;
//		for(String key : tp2BhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				
//				String value = tp2BhColorPlaceAndColorMap.get(key);
//				if(tp2BhColorPlaceAndColorFlag == 0 || tp2BhColorPlaceAndColorFlag % 3 != 0) {
//					tp2BhColorPlaceAndColorString = tp2BhColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(tp2BhColorPlaceAndColorFlag != 0 && tp2BhColorPlaceAndColorFlag % 3 == 0){
//					tp2BhColorPlaceAndColorString = tp2BhColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				tp2BhColorPlaceAndColorFlag += 1;
//			}
//		}
//		
//		pants2CompositeProjectsMap.put("tp2BhColorPlaceAndColor", tp2BhColorPlaceAndColorString.toString());
//		//ボタン付け糸指定
//		String tp2ByColor = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2ByColor());
//		
//		String tp2ByColorPlace1 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlace1());
//		String tp2ByColorPlace2 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlace2());
//		String tp2ByColorPlace3 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlace3());
//		String tp2ByColorPlace4 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlaceMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlace4());
//		
//		String tp2ByColor1 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlaceAllMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2ByColor1());
//		String tp2ByColor2 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlaceAllMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2ByColor2());
//		String tp2ByColor3 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlaceAllMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2ByColor3());
//		String tp2ByColor4 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlaceAllMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2ByColor4());
//		
//		Map<String,String> tp2ByColorPlaceAndColorMap = new HashMap<String,String>();
//		tp2ByColorPlaceAndColorMap.put(tp2ByColorPlace1, tp2ByColor1);
//		tp2ByColorPlaceAndColorMap.put(tp2ByColorPlace2, tp2ByColor2);
//		tp2ByColorPlaceAndColorMap.put(tp2ByColorPlace3, tp2ByColor3);
//		tp2ByColorPlaceAndColorMap.put(tp2ByColorPlace4, tp2ByColor4);
//		
//		StringBuffer tp2ByColorPlaceAndColorString = new StringBuffer();
//		tp2ByColorPlaceAndColorString.append(tp2ByColor + "　　");
//		int tp2ByColorPlaceAndColorFlag = 0;
//		for(String key : tp2BhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				
//				String value = tp2BhColorPlaceAndColorMap.get(key);
//				if(tp2ByColorPlaceAndColorFlag == 0 || tp2ByColorPlaceAndColorFlag % 3 != 0) {
//					tp2ByColorPlaceAndColorString = tp2ByColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(tp2ByColorPlaceAndColorFlag != 0 && tp2ByColorPlaceAndColorFlag % 3 == 0){
//					tp2ByColorPlaceAndColorString = tp2ByColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				tp2ByColorPlaceAndColorFlag += 1;
//			}
//		}
//		
//		pants2CompositeProjectsMap.put("tp2ByColorPlaceAndColor", tp2ByColorPlaceAndColorString.toString());
//		
//		return pants2CompositeProjectsMap;
//	}
	
//	/**
//	 * 
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String,String> washableJkServelItemShow(OrderForm orderForm){
//		Map<String,String> jacketWashableCompositeProjectsMap = new HashMap<String,String>();
//		//ステッチ箇所変更
//		String wjStitchModify = orderForm.getOptionJacketWashableInfo().getWjStitchModifyMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModify());
//		
//		String wjStitchModifyPlace1 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace1());
//		String wjStitchModifyPlace2 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace2());
//		String wjStitchModifyPlace3 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace3());
//		String wjStitchModifyPlace4 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace4());
//		String wjStitchModifyPlace5 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace5());
//		String wjStitchModifyPlace6 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace6());
//		String wjStitchModifyPlace7 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace7());
//		String wjStitchModifyPlace8 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace8());
//		String wjStitchModifyPlace9 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace9());  
//		Map<String,String> wjStitchModifyPlaceMap = new HashMap<String,String>();
//		wjStitchModifyPlaceMap.put(wjStitchModifyPlace1, wjStitchModifyPlace1);
//		wjStitchModifyPlaceMap.put(wjStitchModifyPlace2, wjStitchModifyPlace2);
//		wjStitchModifyPlaceMap.put(wjStitchModifyPlace3, wjStitchModifyPlace3);
//		wjStitchModifyPlaceMap.put(wjStitchModifyPlace4, wjStitchModifyPlace4);
//		wjStitchModifyPlaceMap.put(wjStitchModifyPlace5, wjStitchModifyPlace5);
//		wjStitchModifyPlaceMap.put(wjStitchModifyPlace6, wjStitchModifyPlace6);
//		wjStitchModifyPlaceMap.put(wjStitchModifyPlace7, wjStitchModifyPlace7);
//		wjStitchModifyPlaceMap.put(wjStitchModifyPlace8, wjStitchModifyPlace8);
//		wjStitchModifyPlaceMap.put(wjStitchModifyPlace9, wjStitchModifyPlace9);
//		
//		StringBuffer wjStitchModifyPlaceString = new StringBuffer();
//		wjStitchModifyPlaceString.append(wjStitchModify + "　　");
//		for(String key : wjStitchModifyPlaceMap.keySet()) {
//			String value = wjStitchModifyPlaceMap.get(key);
//			if(key != null ) {
//				wjStitchModifyPlaceString.append(value + "　");
//			}
//		}
//		
//		jacketWashableCompositeProjectsMap.put("wjStitchModifyPlace", wjStitchModifyPlaceString.toString());
//		//ダブルステッチ変更
//		String wjDStitchModify = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModify());
//		
//		String wjDStitchModifyPlace1 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace1());
//		String wjDStitchModifyPlace2 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace2());
//		String wjDStitchModifyPlace3 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace3());
//		String wjDStitchModifyPlace4 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace4());
//		String wjDStitchModifyPlace5 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace5());
//		String wjDStitchModifyPlace6 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace6());
//		String wjDStitchModifyPlace7 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace7());
//		String wjDStitchModifyPlace8 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace8());
//		String wjDStitchModifyPlace9 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace9());
//		Map<String,String> wjDStitchModifyPlaceMap = new HashMap<String,String>();
//		wjDStitchModifyPlaceMap.put(wjDStitchModifyPlace1, wjDStitchModifyPlace1);
//		wjDStitchModifyPlaceMap.put(wjDStitchModifyPlace2, wjDStitchModifyPlace2);
//		wjDStitchModifyPlaceMap.put(wjDStitchModifyPlace3, wjDStitchModifyPlace3);
//		wjDStitchModifyPlaceMap.put(wjDStitchModifyPlace4, wjDStitchModifyPlace4);
//		wjDStitchModifyPlaceMap.put(wjDStitchModifyPlace5, wjDStitchModifyPlace5);
//		wjDStitchModifyPlaceMap.put(wjDStitchModifyPlace6, wjDStitchModifyPlace6);
//		wjDStitchModifyPlaceMap.put(wjDStitchModifyPlace7, wjDStitchModifyPlace7);
//		wjDStitchModifyPlaceMap.put(wjDStitchModifyPlace8, wjDStitchModifyPlace8);
//		wjDStitchModifyPlaceMap.put(wjDStitchModifyPlace9, wjDStitchModifyPlace9);
//		
//		StringBuffer wjDStitchModifyPlaceString = new StringBuffer();
//		wjDStitchModifyPlaceString.append(wjDStitchModify + "　　");
//		for(String key : wjDStitchModifyPlaceMap.keySet()) {
//			String value = wjDStitchModifyPlaceMap.get(key);
//			if(key != null) {
//				wjDStitchModifyPlaceString.append(value + "　");
//			}
//		}
//		
//		jacketWashableCompositeProjectsMap.put("wjDStitchModifyPlace", wjDStitchModifyPlaceString.toString());
//		//AMF色指定
//		String wjAmfColor = orderForm.getOptionJacketWashableInfo().getWjAmfColorMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor());
//		
//		String wjAmfColorPlace1 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace1());
//		String wjAmfColorPlace2 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace2());
//		String wjAmfColorPlace3 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace3());
//		String wjAmfColorPlace4 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace4());
//		String wjAmfColorPlace5 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace5());
//		String wjAmfColorPlace6 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace6());
//		String wjAmfColorPlace7 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace7());
//		String wjAmfColorPlace8 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace8());
//		String wjAmfColorPlace9 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace9());
//		String wjAmfColorPlace10 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace10());
//		
//		String wjAmfColor1 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor1());
//		String wjAmfColor2 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor2());
//		String wjAmfColor3 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor3());
//		String wjAmfColor4 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor4());
//		String wjAmfColor5 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor5());
//		String wjAmfColor6 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor6());
//		String wjAmfColor7 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor7());
//		String wjAmfColor8 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor8());
//		String wjAmfColor9 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor9());
//		String wjAmfColor10 = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjAmfColor10());
//		
//		Map<String,String> wjAmfColorPlaceAndColorMap = new HashMap<String,String>();
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace1, wjAmfColor1);
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace2, wjAmfColor2);
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace3, wjAmfColor3);
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace4, wjAmfColor4);
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace5, wjAmfColor5);
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace6, wjAmfColor6);
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace7, wjAmfColor7);
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace8, wjAmfColor8);
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace9, wjAmfColor9);
//		wjAmfColorPlaceAndColorMap.put(wjAmfColorPlace10, wjAmfColor10);
//		
//		StringBuffer wjAmfColorPlaceAndColorString = new StringBuffer();
//		wjAmfColorPlaceAndColorString.append(wjAmfColor + "　　");
//		int wjAmfColorPlaceAndColorFlag = 0;
//		for(String key : wjAmfColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wjAmfColorPlaceAndColorMap.get(key);
//				if(wjAmfColorPlaceAndColorFlag == 0 || wjAmfColorPlaceAndColorFlag % 3 != 0) {
//					wjAmfColorPlaceAndColorString = wjAmfColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wjAmfColorPlaceAndColorFlag != 0 && wjAmfColorPlaceAndColorFlag % 3 == 0){
//					wjAmfColorPlaceAndColorString = wjAmfColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wjAmfColorPlaceAndColorFlag += 1;
//			}
//		}
//		jacketWashableCompositeProjectsMap.put("wjAmfColorPlaceAndColor", wjAmfColorPlaceAndColorString.toString());
//		//ボタンホール色指定
//		String wjBhColor = orderForm.getOptionJacketWashableInfo().getWjBhColorMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor());
//		
//		String wjBhColorPlace1 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace1());
//		String wjBhColorPlace2 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace2());
//		String wjBhColorPlace3 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace3());
//		String wjBhColorPlace4 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace4());
//		String wjBhColorPlace5 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace5());
//		String wjBhColorPlace6 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace6());
//		String wjBhColorPlace7 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace7());
//		String wjBhColorPlace8 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace8());
//		String wjBhColorPlace9 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace9());
//		String wjBhColorPlace10 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace10());
//		String wjBhColorPlace11 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace11());
//		String wjBhColorPlace12 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace12());
//		String wjBhColorPlace13 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace13());
//		String wjBhColorPlace14 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace14());
//		String wjBhColorPlace15 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace15());
//		String wjBhColorPlace16 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace16());
//		String wjBhColorPlace17 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColorPlace17());
//		
//		String wjBhColor1 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor1());
//		String wjBhColor2 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor2());
//		String wjBhColor3 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor3());
//		String wjBhColor4 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor4());
//		String wjBhColor5 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor5());
//		String wjBhColor6 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor6());
//		String wjBhColor7 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor7());
//		String wjBhColor8 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor8());
//		String wjBhColor9 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor9());
//		String wjBhColor10 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor10());
//		String wjBhColor11 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor11());
//		String wjBhColor12 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor12());
//		String wjBhColor13 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor13());
//		String wjBhColor14 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor14());
//		String wjBhColor15 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor15());
//		String wjBhColor16 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor16());
//		String wjBhColor17 = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap().get(orderForm.getOptionJacketWashableInfo().getWjBhColor17());
//		
//		Map<String,String> wjBhColorPlaceAndColorMap = new HashMap<String,String>();
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace1, wjBhColor1);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace2, wjBhColor2);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace3, wjBhColor3);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace4, wjBhColor4);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace5, wjBhColor5);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace6, wjBhColor6);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace7, wjBhColor7);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace8, wjBhColor8);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace9, wjBhColor9);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace10, wjBhColor10);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace11, wjBhColor11);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace12, wjBhColor12);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace13, wjBhColor13);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace14, wjBhColor14);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace15, wjBhColor15);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace16, wjBhColor16);
//		wjBhColorPlaceAndColorMap.put(wjBhColorPlace17, wjBhColor17);
//		StringBuffer wjBhColorPlaceAndColorString = new StringBuffer();
//		wjBhColorPlaceAndColorString.append(wjBhColor + "　　");
//		int wjBhColorPlaceAndColorFlag = 0;
//		for(String key : wjBhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wjBhColorPlaceAndColorMap.get(key);
//				if(wjBhColorPlaceAndColorFlag == 0 || wjBhColorPlaceAndColorFlag % 3 != 0) {
//					wjBhColorPlaceAndColorString = wjBhColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wjBhColorPlaceAndColorFlag != 0 && wjBhColorPlaceAndColorFlag % 3 == 0){
//					wjBhColorPlaceAndColorString = wjBhColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wjBhColorPlaceAndColorFlag += 1;
//			}
//		}
//		jacketWashableCompositeProjectsMap.put("wjBhColorPlaceAndColor", wjBhColorPlaceAndColorString.toString());
//		//ボタン付け糸指定
////		String wjByColor = orderForm.getOptionJacketWashableInfo().getWjByColorMap().get(orderForm.getOptionJacketWashableInfo().getWjByColor());
//		
//		
//		
//		return jacketWashableCompositeProjectsMap;
//	}
	
//	/**
//	 * 
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String,String> washableGlServelItemShow(OrderForm orderForm){
//		Map<String,String> giletWashableCompositeProjectsMap = new HashMap<String,String>();
//		//ステッチ箇所変更
//		String wgStitchModify = orderForm.getOptionGiletWashableInfo().getWgStitchModifyMap().get(orderForm.getOptionGiletWashableInfo().getWgStitchModify());
//		
//		String wgStitchModifyPlace1 = orderForm.getOptionGiletWashableInfo().getWgStitchModifyPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgStitchModifyPlace1());
//		String wgStitchModifyPlace2 = orderForm.getOptionGiletWashableInfo().getWgStitchModifyPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgStitchModifyPlace2());
//		String wgStitchModifyPlace3 = orderForm.getOptionGiletWashableInfo().getWgStitchModifyPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgStitchModifyPlace3());
//		
//		Map<String,String> wgStitchModifyPlaceMap = new HashMap<String,String>();
//		wgStitchModifyPlaceMap.put(wgStitchModifyPlace1, wgStitchModifyPlace1);
//		wgStitchModifyPlaceMap.put(wgStitchModifyPlace2, wgStitchModifyPlace2);
//		wgStitchModifyPlaceMap.put(wgStitchModifyPlace3, wgStitchModifyPlace3);
//		StringBuffer wgStitchModifyPlaceString = new StringBuffer();
//		wgStitchModifyPlaceString.append(wgStitchModify + "　　");
//		
//		for(String key : wgStitchModifyPlaceMap.keySet()) {
//			String value = wgStitchModifyPlaceMap.get(key);
//			if(key != null) {
//				wgStitchModifyPlaceString.append(value + "　");
//			}
//		}
//		giletWashableCompositeProjectsMap.put("wgStitchModifyPlace", wgStitchModifyPlaceString.toString());
//		//ダブルステッチ変更
//		String wgDStitchModify = orderForm.getOptionGiletWashableInfo().getWgDStitchModifyMap().get(orderForm.getOptionGiletWashableInfo().getWgDStitchModify());
//		
//		String wgDStitchModifyPlace1 = orderForm.getOptionGiletWashableInfo().getWgDStitchModifyPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgDStitchModifyPlace1());
//		String wgDStitchModifyPlace2 = orderForm.getOptionGiletWashableInfo().getWgDStitchModifyPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgDStitchModifyPlace2());
//		String wgDStitchModifyPlace3 = orderForm.getOptionGiletWashableInfo().getWgDStitchModifyPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgDStitchModifyPlace3());
//		Map<String,String> wgDStitchModifyPlaceMap = new HashMap<String,String>();
//		wgDStitchModifyPlaceMap.put(wgDStitchModifyPlace1, wgDStitchModifyPlace1);
//		wgDStitchModifyPlaceMap.put(wgDStitchModifyPlace2, wgDStitchModifyPlace2);
//		wgDStitchModifyPlaceMap.put(wgDStitchModifyPlace3, wgDStitchModifyPlace3);
//		StringBuffer wgDStitchModifyPlaceString = new StringBuffer();
//		wgDStitchModifyPlaceString.append(wgDStitchModify + "　　");
//		
//		for(String key : wgDStitchModifyPlaceMap.keySet()) {
//			String value = wgDStitchModifyPlaceMap.get(key);
//			if(key != null) {
//				wgDStitchModifyPlaceString.append(value + "　");
//			}
//		}
//		giletWashableCompositeProjectsMap.put("wgDStitchModifyPlace", wgDStitchModifyPlaceString.toString());
//		//AMF色指定
//		String wgAmfColor = orderForm.getOptionGiletWashableInfo().getWgAmfColorMap().get(orderForm.getOptionGiletWashableInfo().getWgAmfColor());
//		
//		String wgAmfColorPlace1 = orderForm.getOptionGiletWashableInfo().getWgAmfColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgAmfColorPlace1());
//		String wgAmfColorPlace2 = orderForm.getOptionGiletWashableInfo().getWgAmfColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgAmfColorPlace2());
//		String wgAmfColorPlace3 = orderForm.getOptionGiletWashableInfo().getWgAmfColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgAmfColorPlace3());
//		
//		String wgAmfColor1 = orderForm.getOptionGiletWashableInfo().getWgAmfColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgAmfColor1());
//		String wgAmfColor2 = orderForm.getOptionGiletWashableInfo().getWgAmfColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgAmfColor2());
//		String wgAmfColor3 = orderForm.getOptionGiletWashableInfo().getWgAmfColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgAmfColor3());
//		
//		Map<String,String> wgAmfColorPlaceAndColorMap = new HashMap<String,String>();
//		wgAmfColorPlaceAndColorMap.put(wgAmfColorPlace1, wgAmfColor1);
//		wgAmfColorPlaceAndColorMap.put(wgAmfColorPlace2, wgAmfColor2);
//		wgAmfColorPlaceAndColorMap.put(wgAmfColorPlace3, wgAmfColor3);
//		
//		StringBuffer wgAmfColorPlaceAndColorString = new StringBuffer();
//		wgAmfColorPlaceAndColorString.append(wgAmfColor + "　　");
//		int wgAmfColorPlaceAndColorFlag = 0;
//		for(String key : wgAmfColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wgAmfColorPlaceAndColorMap.get(key);
//				if(wgAmfColorPlaceAndColorFlag == 0 || wgAmfColorPlaceAndColorFlag % 3 != 0) {
//					wgAmfColorPlaceAndColorString = wgAmfColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wgAmfColorPlaceAndColorFlag != 0 && wgAmfColorPlaceAndColorFlag % 3 == 0){
//					wgAmfColorPlaceAndColorString = wgAmfColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wgAmfColorPlaceAndColorFlag += 1;
//			}
//		}
//		giletWashableCompositeProjectsMap.put("wgAmfColorPlaceAndColor", wgAmfColorPlaceAndColorString.toString());
//		//ボタンホール色指定
//		String wgBhColor = orderForm.getOptionGiletWashableInfo().getWgBhColorMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColor());
//		
//		String wgBhColorPlace1 = orderForm.getOptionGiletWashableInfo().getWgBhColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColorPlace1());
//		String wgBhColorPlace2 = orderForm.getOptionGiletWashableInfo().getWgBhColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColorPlace2());
//		String wgBhColorPlace3 = orderForm.getOptionGiletWashableInfo().getWgBhColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColorPlace3());
//		String wgBhColorPlace4 = orderForm.getOptionGiletWashableInfo().getWgBhColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColorPlace4());
//		String wgBhColorPlace5 = orderForm.getOptionGiletWashableInfo().getWgBhColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColorPlace5());
//		String wgBhColorPlace6 = orderForm.getOptionGiletWashableInfo().getWgBhColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColorPlace6());
//		
//		String wgBhColor1 = orderForm.getOptionGiletWashableInfo().getWgBhColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColor1());
//		String wgBhColor2 = orderForm.getOptionGiletWashableInfo().getWgBhColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColor2());
//		String wgBhColor3 = orderForm.getOptionGiletWashableInfo().getWgBhColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColor3());
//		String wgBhColor4 = orderForm.getOptionGiletWashableInfo().getWgBhColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColor4());
//		String wgBhColor5 = orderForm.getOptionGiletWashableInfo().getWgBhColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColor5());
//		String wgBhColor6 = orderForm.getOptionGiletWashableInfo().getWgBhColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgBhColor6());
//		
//		Map<String,String> wgBhColorPlaceAndColorMap = new HashMap<String,String>();
//		wgBhColorPlaceAndColorMap.put(wgBhColorPlace1, wgBhColor1);
//		wgBhColorPlaceAndColorMap.put(wgBhColorPlace2, wgBhColor2);
//		wgBhColorPlaceAndColorMap.put(wgBhColorPlace3, wgBhColor3);
//		wgBhColorPlaceAndColorMap.put(wgBhColorPlace4, wgBhColor4);
//		wgBhColorPlaceAndColorMap.put(wgBhColorPlace5, wgBhColor5);
//		wgBhColorPlaceAndColorMap.put(wgBhColorPlace6, wgBhColor6);
//		StringBuffer wgBhColorPlaceAndColorString = new StringBuffer();
//		wgBhColorPlaceAndColorString.append(wgBhColor + "　　");
//		int wgBhColorPlaceAndColorFlag = 0;
//		for(String key : wgBhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wgBhColorPlaceAndColorMap.get(key);
//				if(wgBhColorPlaceAndColorFlag == 0 || wgBhColorPlaceAndColorFlag % 3 != 0) {
//					wgBhColorPlaceAndColorString = wgBhColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wgBhColorPlaceAndColorFlag != 0 && wgBhColorPlaceAndColorFlag % 3 == 0){
//					wgBhColorPlaceAndColorString = wgBhColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wgBhColorPlaceAndColorFlag += 1;
//			}
//		}
//		giletWashableCompositeProjectsMap.put("wgBhColorPlaceAndColor", wgBhColorPlaceAndColorString.toString());
//		//ボタン付け糸指定
//		String wgByColor = orderForm.getOptionGiletWashableInfo().getWgByColorMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor());
//		
//		String wgByColorPlace1 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace1());
//		String wgByColorPlace2 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace2());
//		String wgByColorPlace3 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace3());
//		String wgByColorPlace4 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace4());
//		String wgByColorPlace5 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace5());
//		String wgByColorPlace6 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace6());
//		String wgByColorPlace7 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace7());
//		String wgByColorPlace8 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace8());
//		String wgByColorPlace9 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace9());
//		String wgByColorPlace10 = orderForm.getOptionGiletWashableInfo().getWgByColorPlaceMap().get(orderForm.getOptionGiletWashableInfo().getWgByColorPlace10());
//		
//		String wgByColor1 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor1());
//		String wgByColor2 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor2());
//		String wgByColor3 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor3());
//		String wgByColor4 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor4());
//		String wgByColor5 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor5());
//		String wgByColor6 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor6());
//		String wgByColor7 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor7());
//		String wgByColor8 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor8());
//		String wgByColor9 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor9());
//		String wgByColor10 = orderForm.getOptionGiletWashableInfo().getWgByColorsMap().get(orderForm.getOptionGiletWashableInfo().getWgByColor10());
//		
//		Map<String,String> wgByColorPlaceAndColorMap = new HashMap<String,String>();
//		wgByColorPlaceAndColorMap.put(wgByColorPlace1, wgByColor1);
//		wgByColorPlaceAndColorMap.put(wgByColorPlace2, wgByColor2);
//		wgByColorPlaceAndColorMap.put(wgByColorPlace3, wgByColor3);
//		wgByColorPlaceAndColorMap.put(wgByColorPlace4, wgByColor4);
//		wgByColorPlaceAndColorMap.put(wgByColorPlace5, wgByColor5);
//		wgByColorPlaceAndColorMap.put(wgByColorPlace6, wgByColor6);
//		wgByColorPlaceAndColorMap.put(wgByColorPlace7, wgByColor7);
//		wgByColorPlaceAndColorMap.put(wgByColorPlace8, wgByColor8);
//		wgByColorPlaceAndColorMap.put(wgByColorPlace9, wgByColor9);
//		wgByColorPlaceAndColorMap.put(wgByColorPlace10, wgByColor10);
//		StringBuffer wgByColorPlaceAndColorString = new StringBuffer();
//		wgByColorPlaceAndColorString.append(wgByColor + "　　");
//		int wgByColorPlaceAndColorFlag = 0;
//		for(String key : wgByColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wgByColorPlaceAndColorMap.get(key);
//				if(wgByColorPlaceAndColorFlag == 0 || wgByColorPlaceAndColorFlag % 3 != 0) {
//					wgByColorPlaceAndColorString = wgByColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wgByColorPlaceAndColorFlag != 0 && wgByColorPlaceAndColorFlag % 3 == 0){
//					wgByColorPlaceAndColorString = wgByColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wgBhColorPlaceAndColorFlag += 1;
//			}
//		}
//		giletWashableCompositeProjectsMap.put("wgByColorPlaceAndColor", wgByColorPlaceAndColorString.toString());
//		return giletWashableCompositeProjectsMap;
//	}
	
//	/**
//	 * 
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String,String> washablePtServelItemShow(OrderForm orderForm){
//		Map<String,String> pantsWashableCompositeProjectsMap = new HashMap<String,String>();
//		
//		//ベルトループ箇所 
//		String wpBeltLoop = orderForm.getOptionPantsWashableInfo().getWpBeltLoopMap().get(orderForm.getOptionPantsWashableInfo().getWpBeltLoop());
//		
//		String wpBeltLoopPlace1 = orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlace1());
//		String wpBeltLoopPlace2 = orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlace2());
//		String wpBeltLoopPlace3 = orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlace3());
//		String wpBeltLoopPlace4 = orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlace4());
//		String wpBeltLoopPlace5 = orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlace5());
//		String wpBeltLoopPlace6 = orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlace6());
//		String wpBeltLoopPlace7 = orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBeltLoopPlace7());
//		Map<String,String> wpBeltLoopPlaceMap = new HashMap<String,String>();
//		wpBeltLoopPlaceMap.put(wpBeltLoopPlace1, wpBeltLoopPlace1);
//		wpBeltLoopPlaceMap.put(wpBeltLoopPlace1, wpBeltLoopPlace2);
//		wpBeltLoopPlaceMap.put(wpBeltLoopPlace1, wpBeltLoopPlace3);
//		wpBeltLoopPlaceMap.put(wpBeltLoopPlace1, wpBeltLoopPlace4);
//		wpBeltLoopPlaceMap.put(wpBeltLoopPlace1, wpBeltLoopPlace5);
//		wpBeltLoopPlaceMap.put(wpBeltLoopPlace1, wpBeltLoopPlace6);
//		wpBeltLoopPlaceMap.put(wpBeltLoopPlace1, wpBeltLoopPlace7);
//		StringBuffer wpBeltLoopPlaceString = new StringBuffer();
//		wpBeltLoopPlaceString.append(wpBeltLoop + "　　");
//		
//		for(String key : wpBeltLoopPlaceMap.keySet()) {
//			String value = wpBeltLoopPlaceMap.get(key);
//			if(key != null) {
//				wpBeltLoopPlaceString.append(value + "　");
//			}
//		}
//		pantsWashableCompositeProjectsMap.put("wpBeltLoopPlace", wpBeltLoopPlaceString.toString());
//		//ステッチ箇所変更
//		String wpStitchModify = orderForm.getOptionPantsWashableInfo().getWpStitchModifyMap().get(orderForm.getOptionPantsWashableInfo().getWpStitchModify());
//		
//		String wpStitchModifyPlace1 = orderForm.getOptionPantsWashableInfo().getWpStitchModifyPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpStitchModifyPlace1());
//		String wpStitchModifyPlace2 = orderForm.getOptionPantsWashableInfo().getWpStitchModifyPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpStitchModifyPlace2());
//		String wpStitchModifyPlace3 = orderForm.getOptionPantsWashableInfo().getWpStitchModifyPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpStitchModifyPlace3());
//		String wpStitchModifyPlace4 = orderForm.getOptionPantsWashableInfo().getWpStitchModifyPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpStitchModifyPlace4());
//		Map<String,String> wpStitchModifyPlaceMap = new HashMap<String,String>();
//		wpStitchModifyPlaceMap.put(wpStitchModifyPlace1, wpStitchModifyPlace1);
//		wpStitchModifyPlaceMap.put(wpStitchModifyPlace2, wpStitchModifyPlace2);
//		wpStitchModifyPlaceMap.put(wpStitchModifyPlace3, wpStitchModifyPlace3);
//		wpStitchModifyPlaceMap.put(wpStitchModifyPlace4, wpStitchModifyPlace4);
//		
//		StringBuffer wpStitchModifyPlaceString = new StringBuffer();
//		wpStitchModifyPlaceString.append(wpStitchModify + "　　");
//		for(String key : wpStitchModifyPlaceMap.keySet()) {
//			String value = wpStitchModifyPlaceMap.get(key);
//			if(key != null) {
//				wpStitchModifyPlaceString.append(value + "　");
//			}
//		}
//		pantsWashableCompositeProjectsMap.put("wpStitchModifyPlace", wpStitchModifyPlaceString.toString());
//		//ダブルステッチ
//		String wpDStitch = orderForm.getOptionPantsWashableInfo().getWpDStitchMap().get(orderForm.getOptionPantsWashableInfo().getWpDStitch());
//		
//		String wpDStitchPlace1 = orderForm.getOptionPantsWashableInfo().getWpDStitchPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpDStitchPlace1());
//		String wpDStitchPlace2 = orderForm.getOptionPantsWashableInfo().getWpDStitchPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpDStitchPlace2());
//		String wpDStitchPlace3 = orderForm.getOptionPantsWashableInfo().getWpDStitchPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpDStitchPlace3());
//		String wpDStitchPlace4 = orderForm.getOptionPantsWashableInfo().getWpDStitchPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpDStitchPlace4());
//		Map<String,String> wpDStitchPlaceMap = new HashMap<String,String>();
//		wpDStitchPlaceMap.put(wpDStitchPlace1, wpDStitchPlace1);
//		wpDStitchPlaceMap.put(wpDStitchPlace1, wpDStitchPlace2);
//		wpDStitchPlaceMap.put(wpDStitchPlace1, wpDStitchPlace3);
//		wpDStitchPlaceMap.put(wpDStitchPlace1, wpDStitchPlace4);
//		
//		StringBuffer wpDStitchPlaceString = new StringBuffer();
//		wpDStitchPlaceString.append(wpDStitch + "　　");
//		for(String key : wpDStitchPlaceMap.keySet()) {
//			String value = wpDStitchPlaceMap.get(key);
//			if(key != null) {
//				wpDStitchPlaceString.append(value + "　");
//			}
//		}
//		pantsWashableCompositeProjectsMap.put("wpDStitchPlace", wpDStitchPlaceString.toString());
//		//AMF色指定
//		String wpAmfColor = orderForm.getOptionPantsWashableInfo().getWpAmfColorMap().get(orderForm.getOptionPantsWashableInfo().getWpAmfColor());
//		
//		String wpAmfColorPlace1 = orderForm.getOptionPantsWashableInfo().getWpAmfColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpAmfColorPlace1());
//		String wpAmfColorPlace2 = orderForm.getOptionPantsWashableInfo().getWpAmfColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpAmfColorPlace2());
//		String wpAmfColorPlace3 = orderForm.getOptionPantsWashableInfo().getWpAmfColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpAmfColorPlace3());
//		String wpAmfColorPlace4 = orderForm.getOptionPantsWashableInfo().getWpAmfColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpAmfColorPlace4());
//		
//		String wpAmfColor1 = orderForm.getOptionPantsWashableInfo().getWpAmfColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpAmfColor1());
//		String wpAmfColor2 = orderForm.getOptionPantsWashableInfo().getWpAmfColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpAmfColor2());
//		String wpAmfColor3 = orderForm.getOptionPantsWashableInfo().getWpAmfColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpAmfColor3());
//		String wpAmfColor4 = orderForm.getOptionPantsWashableInfo().getWpAmfColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpAmfColor4());
//		Map<String,String> wpAmfColorPlaceAndColorMap = new HashMap<String,String>();
//		wpAmfColorPlaceAndColorMap.put(wpAmfColorPlace1, wpAmfColor1);
//		wpAmfColorPlaceAndColorMap.put(wpAmfColorPlace2, wpAmfColor2);
//		wpAmfColorPlaceAndColorMap.put(wpAmfColorPlace3, wpAmfColor3);
//		wpAmfColorPlaceAndColorMap.put(wpAmfColorPlace4, wpAmfColor4);
//		
//		StringBuffer wpAmfColorPlaceAndColorString = new StringBuffer();
//		wpAmfColorPlaceAndColorString.append(wpAmfColor + "　　");
//		int wpAmfColorPlaceAndColorFlag = 0;
//		for(String key : wpAmfColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wpAmfColorPlaceAndColorMap.get(key);
//				if(wpAmfColorPlaceAndColorFlag == 0 || wpAmfColorPlaceAndColorFlag % 3 != 0) {
//					wpAmfColorPlaceAndColorString = wpAmfColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wpAmfColorPlaceAndColorFlag != 0 && wpAmfColorPlaceAndColorFlag % 3 == 0){
//					wpAmfColorPlaceAndColorString = wpAmfColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wpAmfColorPlaceAndColorFlag += 1;
//			}
//		}
//		pantsWashableCompositeProjectsMap.put("wpAmfColorPlaceAndColor", wpAmfColorPlaceAndColorString.toString());
//		//ボタンホール色指定
//		String wpBhColor = orderForm.getOptionPantsWashableInfo().getWpBhColorMap().get(orderForm.getOptionPantsWashableInfo().getWpBhColor());
//		
//		String wpBhColorPlace1 = orderForm.getOptionPantsWashableInfo().getWpBhColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBhColorPlace1());
//		String wpBhColorPlace2 = orderForm.getOptionPantsWashableInfo().getWpBhColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBhColorPlace2());
//		String wpBhColorPlace3 = orderForm.getOptionPantsWashableInfo().getWpBhColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBhColorPlace3());
//		String wpBhColorPlace4 = orderForm.getOptionPantsWashableInfo().getWpBhColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpBhColorPlace4());
//		
//		String wpBhColor1 = orderForm.getOptionPantsWashableInfo().getWpBhColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpBhColor1());
//		String wpBhColor2 = orderForm.getOptionPantsWashableInfo().getWpBhColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpBhColor2());
//		String wpBhColor3 = orderForm.getOptionPantsWashableInfo().getWpBhColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpBhColor3());
//		String wpBhColor4 = orderForm.getOptionPantsWashableInfo().getWpBhColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpBhColor4());
//		Map<String,String> wpBhColorPlaceAndColorMap = new HashMap<String,String>();
//		wpBhColorPlaceAndColorMap.put(wpBhColorPlace1, wpBhColor1);
//		wpBhColorPlaceAndColorMap.put(wpBhColorPlace2, wpBhColor2);
//		wpBhColorPlaceAndColorMap.put(wpBhColorPlace3, wpBhColor3);
//		wpBhColorPlaceAndColorMap.put(wpBhColorPlace4, wpBhColor4);
//		
//		StringBuffer wpBhColorPlaceAndColorString = new StringBuffer();
//		wpBhColorPlaceAndColorString.append(wpBhColor + "　　");
//		int wpBhColorPlaceAndColorFlag = 0;
//		for(String key : wpBhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wpBhColorPlaceAndColorMap.get(key);
//				if(wpBhColorPlaceAndColorFlag == 0 || wpBhColorPlaceAndColorFlag % 3 != 0) {
//					wpBhColorPlaceAndColorString = wpBhColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wpBhColorPlaceAndColorFlag != 0 && wpBhColorPlaceAndColorFlag % 3 == 0){
//					wpBhColorPlaceAndColorString = wpBhColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wpBhColorPlaceAndColorFlag += 1;
//			}
//		}
//		pantsWashableCompositeProjectsMap.put("wpBhColorPlaceAndColor", wpBhColorPlaceAndColorString.toString());
//		//ボタン付け糸指定
//		String wpByColor = orderForm.getOptionPantsWashableInfo().getWpByColorMap().get(orderForm.getOptionPantsWashableInfo().getWpByColor());
//		
//		String wpByColorPlace1 = orderForm.getOptionPantsWashableInfo().getWpByColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpByColorPlace1());
//		String wpByColorPlace2 = orderForm.getOptionPantsWashableInfo().getWpByColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpByColorPlace2());
//		String wpByColorPlace3 = orderForm.getOptionPantsWashableInfo().getWpByColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpByColorPlace3());
//		String wpByColorPlace4 = orderForm.getOptionPantsWashableInfo().getWpByColorPlaceMap().get(orderForm.getOptionPantsWashableInfo().getWpByColorPlace4());
//		
//		String wpByColor1 = orderForm.getOptionPantsWashableInfo().getWpByColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpByColor1());
//		String wpByColor2 = orderForm.getOptionPantsWashableInfo().getWpByColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpByColor2());
//		String wpByColor3 = orderForm.getOptionPantsWashableInfo().getWpByColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpByColor3());
//		String wpByColor4 = orderForm.getOptionPantsWashableInfo().getWpByColorsMap().get(orderForm.getOptionPantsWashableInfo().getWpByColor4());
//		Map<String,String> wpByColorPlaceAndColorMap = new HashMap<String,String>();
//		wpByColorPlaceAndColorMap.put(wpByColorPlace1, wpByColor1);
//		wpByColorPlaceAndColorMap.put(wpByColorPlace2, wpByColor2);
//		wpByColorPlaceAndColorMap.put(wpByColorPlace3, wpByColor3);
//		wpByColorPlaceAndColorMap.put(wpByColorPlace4, wpByColor4);
//		StringBuffer wpByColorPlaceAndColorString = new StringBuffer();
//		wpByColorPlaceAndColorString.append(wpByColor + "　　");
//		int wpByColorPlaceAndColorFlag = 0;
//		for(String key : wpByColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wpByColorPlaceAndColorMap.get(key);
//				if(wpByColorPlaceAndColorFlag == 0 || wpByColorPlaceAndColorFlag % 3 != 0) {
//					wpByColorPlaceAndColorString = wpByColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wpByColorPlaceAndColorFlag != 0 && wpByColorPlaceAndColorFlag % 3 == 0){
//					wpByColorPlaceAndColorString = wpByColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wpByColorPlaceAndColorFlag += 1;
//			}
//		}
//		pantsWashableCompositeProjectsMap.put("wpByColorPlaceAndColor", wpByColorPlaceAndColorString.toString());
//		
//		return pantsWashableCompositeProjectsMap;
//	}
	
//	/**
//	 * 
//	 * @param orderForm
//	 * @return
//	 */
//	public Map<String,String> washablePt2ServelItemShow(OrderForm orderForm){
//		Map<String,String> pants2WashableCompositeProjectsMap = new HashMap<String,String>();
//		
//		//ベルトループ箇所 
//		String wp2BeltLoop = orderForm.getOptionPants2WashableInfo().getWp2BeltLoopMap().get(orderForm.getOptionPants2WashableInfo().getWp2BeltLoop());
//		
//		String wp2BeltLoopPlace1 = orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlace1());
//		String wp2BeltLoopPlace2 = orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlace2());
//		String wp2BeltLoopPlace3 = orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlace3());
//		String wp2BeltLoopPlace4 = orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlace4());
//		String wp2BeltLoopPlace5 = orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlace5());
//		String wp2BeltLoopPlace6 = orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlace6());
//		String wp2BeltLoopPlace7 = orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BeltLoopPlace7());
//		Map<String,String> wp2BeltLoopPlaceMap = new HashMap<String,String>();
//		wp2BeltLoopPlaceMap.put(wp2BeltLoopPlace1, wp2BeltLoopPlace1);
//		wp2BeltLoopPlaceMap.put(wp2BeltLoopPlace1, wp2BeltLoopPlace2);
//		wp2BeltLoopPlaceMap.put(wp2BeltLoopPlace1, wp2BeltLoopPlace3);
//		wp2BeltLoopPlaceMap.put(wp2BeltLoopPlace1, wp2BeltLoopPlace4);
//		wp2BeltLoopPlaceMap.put(wp2BeltLoopPlace1, wp2BeltLoopPlace5);
//		wp2BeltLoopPlaceMap.put(wp2BeltLoopPlace1, wp2BeltLoopPlace6);
//		wp2BeltLoopPlaceMap.put(wp2BeltLoopPlace1, wp2BeltLoopPlace7);
//		StringBuffer wp2BeltLoopPlaceString = new StringBuffer();
//		wp2BeltLoopPlaceString.append(wp2BeltLoop + "　　");
//		
//		for(String key : wp2BeltLoopPlaceMap.keySet()) {
//			String value = wp2BeltLoopPlaceMap.get(key);
//			if(key != null) {
//				wp2BeltLoopPlaceString.append(value + "　");
//			}
//		}
//		pants2WashableCompositeProjectsMap.put("wp2BeltLoopPlace", wp2BeltLoopPlaceString.toString());
//		//ステッチ箇所変更
//		String wp2StitchModify = orderForm.getOptionPants2WashableInfo().getWp2StitchModifyMap().get(orderForm.getOptionPants2WashableInfo().getWp2StitchModify());
//		
//		String wp2StitchModifyPlace1 = orderForm.getOptionPants2WashableInfo().getWp2StitchModifyPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2StitchModifyPlace1());
//		String wp2StitchModifyPlace2 = orderForm.getOptionPants2WashableInfo().getWp2StitchModifyPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2StitchModifyPlace2());
//		String wp2StitchModifyPlace3 = orderForm.getOptionPants2WashableInfo().getWp2StitchModifyPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2StitchModifyPlace3());
//		String wp2StitchModifyPlace4 = orderForm.getOptionPants2WashableInfo().getWp2StitchModifyPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2StitchModifyPlace4());
//		Map<String,String> wp2StitchModifyPlaceMap = new HashMap<String,String>();
//		wp2StitchModifyPlaceMap.put(wp2StitchModifyPlace1, wp2StitchModifyPlace1);
//		wp2StitchModifyPlaceMap.put(wp2StitchModifyPlace2, wp2StitchModifyPlace2);
//		wp2StitchModifyPlaceMap.put(wp2StitchModifyPlace3, wp2StitchModifyPlace3);
//		wp2StitchModifyPlaceMap.put(wp2StitchModifyPlace4, wp2StitchModifyPlace4);
//		
//		StringBuffer wp2StitchModifyPlaceString = new StringBuffer();
//		wp2StitchModifyPlaceString.append(wp2StitchModify + "　　");
//		for(String key : wp2StitchModifyPlaceMap.keySet()) {
//			String value = wp2StitchModifyPlaceMap.get(key);
//			if(key != null) {
//				wp2StitchModifyPlaceString.append(value + "　");
//			}
//		}
//		pants2WashableCompositeProjectsMap.put("wp2StitchModifyPlace", wp2StitchModifyPlaceString.toString());
//		//ダブルステッチ
//		String wp2DStitch = orderForm.getOptionPants2WashableInfo().getWp2DStitchMap().get(orderForm.getOptionPants2WashableInfo().getWp2DStitch());
//		
//		String wp2DStitchPlace1 = orderForm.getOptionPants2WashableInfo().getWp2DStitchPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2DStitchPlace1());
//		String wp2DStitchPlace2 = orderForm.getOptionPants2WashableInfo().getWp2DStitchPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2DStitchPlace2());
//		String wp2DStitchPlace3 = orderForm.getOptionPants2WashableInfo().getWp2DStitchPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2DStitchPlace3());
//		String wp2DStitchPlace4 = orderForm.getOptionPants2WashableInfo().getWp2DStitchPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2DStitchPlace4());
//		Map<String,String> wp2DStitchPlaceMap = new HashMap<String,String>();
//		wp2DStitchPlaceMap.put(wp2DStitchPlace1, wp2DStitchPlace1);
//		wp2DStitchPlaceMap.put(wp2DStitchPlace1, wp2DStitchPlace2);
//		wp2DStitchPlaceMap.put(wp2DStitchPlace1, wp2DStitchPlace3);
//		wp2DStitchPlaceMap.put(wp2DStitchPlace1, wp2DStitchPlace4);
//		
//		StringBuffer wp2DStitchPlaceString = new StringBuffer();
//		wp2DStitchPlaceString.append(wp2DStitch + "　　");
//		for(String key : wp2DStitchPlaceMap.keySet()) {
//			String value = wp2DStitchPlaceMap.get(key);
//			if(key != null) {
//				wp2DStitchPlaceString.append(value + "　");
//			}
//		}
//		pants2WashableCompositeProjectsMap.put("wp2DStitchPlace", wp2DStitchPlaceString.toString());
//		//AMF色指定
//		String wp2AmfColor = orderForm.getOptionPants2WashableInfo().getWp2AmfColorMap().get(orderForm.getOptionPants2WashableInfo().getWp2AmfColor());
//		
//		String wp2AmfColorPlace1 = orderForm.getOptionPants2WashableInfo().getWp2AmfColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2AmfColorPlace1());
//		String wp2AmfColorPlace2 = orderForm.getOptionPants2WashableInfo().getWp2AmfColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2AmfColorPlace2());
//		String wp2AmfColorPlace3 = orderForm.getOptionPants2WashableInfo().getWp2AmfColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2AmfColorPlace3());
//		String wp2AmfColorPlace4 = orderForm.getOptionPants2WashableInfo().getWp2AmfColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2AmfColorPlace4());
//		
//		String wp2AmfColor1 = orderForm.getOptionPants2WashableInfo().getWp2AmfColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2AmfColor1());
//		String wp2AmfColor2 = orderForm.getOptionPants2WashableInfo().getWp2AmfColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2AmfColor2());
//		String wp2AmfColor3 = orderForm.getOptionPants2WashableInfo().getWp2AmfColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2AmfColor3());
//		String wp2AmfColor4 = orderForm.getOptionPants2WashableInfo().getWp2AmfColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2AmfColor4());
//		Map<String,String> wp2AmfColorPlaceAndColorMap = new HashMap<String,String>();
//		wp2AmfColorPlaceAndColorMap.put(wp2AmfColorPlace1, wp2AmfColor1);
//		wp2AmfColorPlaceAndColorMap.put(wp2AmfColorPlace2, wp2AmfColor2);
//		wp2AmfColorPlaceAndColorMap.put(wp2AmfColorPlace3, wp2AmfColor3);
//		wp2AmfColorPlaceAndColorMap.put(wp2AmfColorPlace4, wp2AmfColor4);
//		
//		StringBuffer wp2AmfColorPlaceAndColorString = new StringBuffer();
//		wp2AmfColorPlaceAndColorString.append(wp2AmfColor + "　　");
//		int wp2AmfColorPlaceAndColorFlag = 0;
//		for(String key : wp2AmfColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wp2AmfColorPlaceAndColorMap.get(key);
//				if(wp2AmfColorPlaceAndColorFlag == 0 || wp2AmfColorPlaceAndColorFlag % 3 != 0) {
//					wp2AmfColorPlaceAndColorString = wp2AmfColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wp2AmfColorPlaceAndColorFlag != 0 && wp2AmfColorPlaceAndColorFlag % 3 == 0){
//					wp2AmfColorPlaceAndColorString = wp2AmfColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wp2AmfColorPlaceAndColorFlag += 1;
//			}
//		}
//		pants2WashableCompositeProjectsMap.put("wp2AmfColorPlaceAndColor", wp2AmfColorPlaceAndColorString.toString());
//		//ボタンホール色指定
//		String wp2BhColor = orderForm.getOptionPants2WashableInfo().getWp2BhColorMap().get(orderForm.getOptionPants2WashableInfo().getWp2BhColor());
//		
//		String wp2BhColorPlace1 = orderForm.getOptionPants2WashableInfo().getWp2BhColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BhColorPlace1());
//		String wp2BhColorPlace2 = orderForm.getOptionPants2WashableInfo().getWp2BhColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BhColorPlace2());
//		String wp2BhColorPlace3 = orderForm.getOptionPants2WashableInfo().getWp2BhColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BhColorPlace3());
//		String wp2BhColorPlace4 = orderForm.getOptionPants2WashableInfo().getWp2BhColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2BhColorPlace4());
//		
//		String wp2BhColor1 = orderForm.getOptionPants2WashableInfo().getWp2BhColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2BhColor1());
//		String wp2BhColor2 = orderForm.getOptionPants2WashableInfo().getWp2BhColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2BhColor2());
//		String wp2BhColor3 = orderForm.getOptionPants2WashableInfo().getWp2BhColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2BhColor3());
//		String wp2BhColor4 = orderForm.getOptionPants2WashableInfo().getWp2BhColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2BhColor4());
//		Map<String,String> wp2BhColorPlaceAndColorMap = new HashMap<String,String>();
//		wp2BhColorPlaceAndColorMap.put(wp2BhColorPlace1, wp2BhColor1);
//		wp2BhColorPlaceAndColorMap.put(wp2BhColorPlace2, wp2BhColor2);
//		wp2BhColorPlaceAndColorMap.put(wp2BhColorPlace3, wp2BhColor3);
//		wp2BhColorPlaceAndColorMap.put(wp2BhColorPlace4, wp2BhColor4);
//		
//		StringBuffer wp2BhColorPlaceAndColorString = new StringBuffer();
//		wp2BhColorPlaceAndColorString.append(wp2BhColor + "　　");
//		int wp2BhColorPlaceAndColorFlag = 0;
//		for(String key : wp2BhColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wp2BhColorPlaceAndColorMap.get(key);
//				if(wp2BhColorPlaceAndColorFlag == 0 || wp2BhColorPlaceAndColorFlag % 3 != 0) {
//					wp2BhColorPlaceAndColorString = wp2BhColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wp2BhColorPlaceAndColorFlag != 0 && wp2BhColorPlaceAndColorFlag % 3 == 0){
//					wp2BhColorPlaceAndColorString = wp2BhColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wp2BhColorPlaceAndColorFlag += 1;
//			}
//		}
//		pants2WashableCompositeProjectsMap.put("wp2BhColorPlaceAndColor", wp2BhColorPlaceAndColorString.toString());
//		//ボタン付け糸指定
//		String wp2ByColor = orderForm.getOptionPants2WashableInfo().getWp2ByColorMap().get(orderForm.getOptionPants2WashableInfo().getWp2ByColor());
//		
//		String wp2ByColorPlace1 = orderForm.getOptionPants2WashableInfo().getWp2ByColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2ByColorPlace1());
//		String wp2ByColorPlace2 = orderForm.getOptionPants2WashableInfo().getWp2ByColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2ByColorPlace2());
//		String wp2ByColorPlace3 = orderForm.getOptionPants2WashableInfo().getWp2ByColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2ByColorPlace3());
//		String wp2ByColorPlace4 = orderForm.getOptionPants2WashableInfo().getWp2ByColorPlaceMap().get(orderForm.getOptionPants2WashableInfo().getWp2ByColorPlace4());
//		
//		String wp2ByColor1 = orderForm.getOptionPants2WashableInfo().getWp2ByColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2ByColor1());
//		String wp2ByColor2 = orderForm.getOptionPants2WashableInfo().getWp2ByColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2ByColor2());
//		String wp2ByColor3 = orderForm.getOptionPants2WashableInfo().getWp2ByColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2ByColor3());
//		String wp2ByColor4 = orderForm.getOptionPants2WashableInfo().getWp2ByColorsMap().get(orderForm.getOptionPants2WashableInfo().getWp2ByColor4());
//		Map<String,String> wp2ByColorPlaceAndColorMap = new HashMap<String,String>();
//		wp2ByColorPlaceAndColorMap.put(wp2ByColorPlace1, wp2ByColor1);
//		wp2ByColorPlaceAndColorMap.put(wp2ByColorPlace2, wp2ByColor2);
//		wp2ByColorPlaceAndColorMap.put(wp2ByColorPlace3, wp2ByColor3);
//		wp2ByColorPlaceAndColorMap.put(wp2ByColorPlace4, wp2ByColor4);
//		StringBuffer wp2ByColorPlaceAndColorString = new StringBuffer();
//		wp2ByColorPlaceAndColorString.append(wp2ByColor + "　　");
//		int wp2ByColorPlaceAndColorFlag = 0;
//		for(String key : wp2ByColorPlaceAndColorMap.keySet()) {
//			if(key != null) {
//				String value = wp2ByColorPlaceAndColorMap.get(key);
//				if(wp2ByColorPlaceAndColorFlag == 0 || wp2ByColorPlaceAndColorFlag % 3 != 0) {
//					wp2ByColorPlaceAndColorString = wp2ByColorPlaceAndColorString.append(key + "　" + value + "　　");
//				}
//				else if(wp2ByColorPlaceAndColorFlag != 0 && wp2ByColorPlaceAndColorFlag % 3 == 0){
//					wp2ByColorPlaceAndColorString = wp2ByColorPlaceAndColorString.append("<br>　　　　" + key + "　" + value + "　　");
//				}
//				wp2ByColorPlaceAndColorFlag += 1;
//			}
//		}
//		pants2WashableCompositeProjectsMap.put("wp2ByColorPlaceAndColor", wp2ByColorPlaceAndColorString.toString());
//		
//		return pants2WashableCompositeProjectsMap;
//	}

//	/**
//	 * タキシードJACKETのグループ項目名とコード
//	 * @param orderForm
//	 * @param order
//	 */
//	public void aboutTuxedoJacketCheckBoxInDb(OrderForm orderForm,Order order) {
//		//タキシードJACKETのボタンホール色指定
//		String tjBhColorPlace1 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace1();
//		String tjBhColorPlace2 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace2();
//		String tjBhColorPlace3 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace3();
//		String tjBhColorPlace4 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace4();
//		String tjBhColorPlace5 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace5();
//		String tjBhColorPlace6 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace6();
//		String tjBhColorPlace7 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace7();
//		String tjBhColorPlace8 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace8();
//		String tjBhColorPlace9 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace9();
//		String tjBhColorPlace10 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace10();
//		String tjBhColorPlace11 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace11();
//		String tjBhColorPlace12 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace12();
//		String tjBhColorPlace13 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace13();
//		String tjBhColorPlace14 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace14();
//		String tjBhColorPlace15 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace15();
//		String tjBhColorPlace16 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace16();
//		String tjBhColorPlace17 = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlace17();
//		
//		List<String> tjBhColorPlaceList = new ArrayList<>();
//		tjBhColorPlaceList.add(tjBhColorPlace1);
//		tjBhColorPlaceList.add(tjBhColorPlace2);
//		tjBhColorPlaceList.add(tjBhColorPlace3);
//		tjBhColorPlaceList.add(tjBhColorPlace4);
//		tjBhColorPlaceList.add(tjBhColorPlace5);
//		tjBhColorPlaceList.add(tjBhColorPlace6);
//		tjBhColorPlaceList.add(tjBhColorPlace7);
//		tjBhColorPlaceList.add(tjBhColorPlace8);
//		tjBhColorPlaceList.add(tjBhColorPlace9);
//		tjBhColorPlaceList.add(tjBhColorPlace10);
//		tjBhColorPlaceList.add(tjBhColorPlace11);
//		tjBhColorPlaceList.add(tjBhColorPlace12);
//		tjBhColorPlaceList.add(tjBhColorPlace13);
//		tjBhColorPlaceList.add(tjBhColorPlace14);
//		tjBhColorPlaceList.add(tjBhColorPlace15);
//		tjBhColorPlaceList.add(tjBhColorPlace16);
//		tjBhColorPlaceList.add(tjBhColorPlace17);
//		tjBhColorPlaceList.removeAll(Collections.singleton(null));
//		if(!tjBhColorPlaceList.isEmpty()) {
//			//JACKET_ボタンホール色指定_箇所コード
//			String tjBhColorPlaceCodeInDb = severalCodeInDb(tjBhColorPlaceList);
//			order.setJkBtnholeColorPlcCd(tjBhColorPlaceCodeInDb);
//			//JACKET_ボタンホール色指定_箇所名
//			Map<String, String> tjBhColorPlaceMap = orderForm.getOptionJacketTuxedoInfo().getTjBhColorPlaceMap();
//			String tjBhColorPlaceNameInDb = severalNameInDb(tjBhColorPlaceList, tjBhColorPlaceMap);
//			order.setJkBtnholeColorPlcN(tjBhColorPlaceNameInDb);
//		}
//		
//		String tjBhColor1 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor1();
//		String tjBhColor2 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor2();
//		String tjBhColor3 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor3();
//		String tjBhColor4 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor4();
//		String tjBhColor5 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor5();
//		String tjBhColor6 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor6();
//		String tjBhColor7 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor7();
//		String tjBhColor8 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor8();
//		String tjBhColor9 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor9();
//		String tjBhColor10 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor10();
//		String tjBhColor11 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor11();
//		String tjBhColor12 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor12();
//		String tjBhColor13 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor13();
//		String tjBhColor14 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor14();
//		String tjBhColor15 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor15();
//		String tjBhColor16 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor16();
//		String tjBhColor17 = orderForm.getOptionJacketTuxedoInfo().getTjBhColor17();
//		
//		List<String> tjBhColorsList = new ArrayList<>();
//		tjBhColorsList.add(tjBhColor1);
//		tjBhColorsList.add(tjBhColor2);
//		tjBhColorsList.add(tjBhColor3);
//		tjBhColorsList.add(tjBhColor4);
//		tjBhColorsList.add(tjBhColor5);
//		tjBhColorsList.add(tjBhColor6);
//		tjBhColorsList.add(tjBhColor7);
//		tjBhColorsList.add(tjBhColor8);
//		tjBhColorsList.add(tjBhColor9);
//		tjBhColorsList.add(tjBhColor10);
//		tjBhColorsList.add(tjBhColor11);
//		tjBhColorsList.add(tjBhColor12);
//		tjBhColorsList.add(tjBhColor13);
//		tjBhColorsList.add(tjBhColor14);
//		tjBhColorsList.add(tjBhColor15);
//		tjBhColorsList.add(tjBhColor16);
//		tjBhColorsList.add(tjBhColor17);
//		tjBhColorsList.removeAll(Collections.singleton(null));
//		if(!tjBhColorsList.isEmpty()) {
//			//JACKET_ボタンホール色指定_色コード
//			String tjBhColorsCodeInDb = severalCodeInDb(tjBhColorsList);
//			order.setJkBtnholeColorCd(tjBhColorsCodeInDb);
//			//JACKET_ボタンホール色指定_色名
//			Map<String, String> tjBhColorsMap = orderForm.getOptionJacketTuxedoInfo().getTjBhColorsMap();
//			String tjBhColorsNameInDb = severalNameInDb(tjBhColorsList, tjBhColorsMap);
//			order.setJkBtnholeColorNm(tjBhColorsNameInDb);
//		}
//		
//		//タキシードJACKETのボタン付け糸指定
//		String tjByColorPlace1 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace1();
//		String tjByColorPlace2 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace2();
//		String tjByColorPlace3 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace3();
//		String tjByColorPlace4 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace4();
//		String tjByColorPlace5 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace5();
//		String tjByColorPlace6 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace6();
//		String tjByColorPlace7 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace7();
//		String tjByColorPlace8 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace8();
//		String tjByColorPlace9 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace9();
//		String tjByColorPlace10 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace10();
//		String tjByColorPlace11 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace11();
//		String tjByColorPlace12 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace12();
//		String tjByColorPlace13 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace13();
//		String tjByColorPlace14 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace14();
//		String tjByColorPlace15 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace15();
//		String tjByColorPlace16 = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlace16();
//
//		List<String> tjByColorPlaceList = new ArrayList<>();
//		tjByColorPlaceList.add(tjByColorPlace1);
//		tjByColorPlaceList.add(tjByColorPlace2);
//		tjByColorPlaceList.add(tjByColorPlace3);
//		tjByColorPlaceList.add(tjByColorPlace4);
//		tjByColorPlaceList.add(tjByColorPlace5);
//		tjByColorPlaceList.add(tjByColorPlace6);
//		tjByColorPlaceList.add(tjByColorPlace7);
//		tjByColorPlaceList.add(tjByColorPlace8);
//		tjByColorPlaceList.add(tjByColorPlace9);
//		tjByColorPlaceList.add(tjByColorPlace10);
//		tjByColorPlaceList.add(tjByColorPlace11);
//		tjByColorPlaceList.add(tjByColorPlace12);
//		tjByColorPlaceList.add(tjByColorPlace13);
//		tjByColorPlaceList.add(tjByColorPlace14);
//		tjByColorPlaceList.add(tjByColorPlace15);
//		tjByColorPlaceList.add(tjByColorPlace16);
//		tjByColorPlaceList.removeAll(Collections.singleton(null));
//		if(!tjByColorPlaceList.isEmpty()) {
//			//JACKET_ボタン付け糸指定_箇所コード
//			String tjByColorPlaceCodeInDb = severalCodeInDb(tjByColorPlaceList);
//			order.setJkBtnthreadColorPlcCd(tjByColorPlaceCodeInDb);
//			//JACKET_ボタン付け糸指定_箇所名
//			Map<String, String> tjByColorPlaceMap = orderForm.getOptionJacketTuxedoInfo().getTjByColorPlaceMap();
//			String tjByColorPlaceNameInDb = severalNameInDb(tjByColorPlaceList, tjByColorPlaceMap);
//			order.setJkBtnthreadColorPlcN(tjByColorPlaceNameInDb);
//		}
//		
//		String tjByColor1 = orderForm.getOptionJacketTuxedoInfo().getTjByColor1();
//		String tjByColor2 = orderForm.getOptionJacketTuxedoInfo().getTjByColor2();
//		String tjByColor3 = orderForm.getOptionJacketTuxedoInfo().getTjByColor3();
//		String tjByColor4 = orderForm.getOptionJacketTuxedoInfo().getTjByColor4();
//		String tjByColor5 = orderForm.getOptionJacketTuxedoInfo().getTjByColor5();
//		String tjByColor6 = orderForm.getOptionJacketTuxedoInfo().getTjByColor6();
//		String tjByColor7 = orderForm.getOptionJacketTuxedoInfo().getTjByColor7();
//		String tjByColor8 = orderForm.getOptionJacketTuxedoInfo().getTjByColor8();
//		String tjByColor9 = orderForm.getOptionJacketTuxedoInfo().getTjByColor9();
//		String tjByColor10 = orderForm.getOptionJacketTuxedoInfo().getTjByColor10();
//		String tjByColor11 = orderForm.getOptionJacketTuxedoInfo().getTjByColor11();
//		String tjByColor12 = orderForm.getOptionJacketTuxedoInfo().getTjByColor12();
//		String tjByColor13 = orderForm.getOptionJacketTuxedoInfo().getTjByColor13();
//		String tjByColor14 = orderForm.getOptionJacketTuxedoInfo().getTjByColor14();
//		String tjByColor15 = orderForm.getOptionJacketTuxedoInfo().getTjByColor15();
//		String tjByColor16 = orderForm.getOptionJacketTuxedoInfo().getTjByColor16();
//
//		List<String> tjByColorsList = new ArrayList<>();
//		tjByColorsList.add(tjByColor1);
//		tjByColorsList.add(tjByColor2);
//		tjByColorsList.add(tjByColor3);
//		tjByColorsList.add(tjByColor4);
//		tjByColorsList.add(tjByColor5);
//		tjByColorsList.add(tjByColor6);
//		tjByColorsList.add(tjByColor7);
//		tjByColorsList.add(tjByColor8);
//		tjByColorsList.add(tjByColor9);
//		tjByColorsList.add(tjByColor10);
//		tjByColorsList.add(tjByColor11);
//		tjByColorsList.add(tjByColor12);
//		tjByColorsList.add(tjByColor13);
//		tjByColorsList.add(tjByColor14);
//		tjByColorsList.add(tjByColor15);
//		tjByColorsList.add(tjByColor16);
//		tjByColorsList.removeAll(Collections.singleton(null));
//		if(!tjByColorsList.isEmpty()) {
//			//JACKET_ボタン付け糸指定_色コード
//			String tjByColorsCodeInDb = severalCodeInDb(tjByColorsList);
//			order.setJkBtnthreadColorCd(tjByColorsCodeInDb);
//			//JACKET_ボタン付け糸指定_色名
//			Map<String, String> tjByColorsMap = orderForm.getOptionJacketTuxedoInfo().getTjByColorsMap();
//			String tjByColorsNameInDb = severalNameInDb(tjByColorsList, tjByColorsMap);
//			order.setJkBtnthreadColorNm(tjByColorsNameInDb);
//		}
//	}
//	
//	/**
//	 * タキシードGILETのグループ項目名とコード
//	 * @param orderForm
//	 * @param order
//	 */
//	public void aboutTuxedoGiletCheckBoxInDb(OrderForm orderForm,Order order) {
//		//タキシードGILETのボタンホール色指定
//		String tgBhColorPlace1 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace1();
//		String tgBhColorPlace2 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace2();
//		String tgBhColorPlace3 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace3();
//		String tgBhColorPlace4 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace4();
//		String tgBhColorPlace5 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace5();
//		String tgBhColorPlace6 = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlace6();
//		
//		List<String> tgBhColorPlaceList = new ArrayList<>();
//		tgBhColorPlaceList.add(tgBhColorPlace1);
//		tgBhColorPlaceList.add(tgBhColorPlace2);
//		tgBhColorPlaceList.add(tgBhColorPlace3);
//		tgBhColorPlaceList.add(tgBhColorPlace4);
//		tgBhColorPlaceList.add(tgBhColorPlace5);
//		tgBhColorPlaceList.add(tgBhColorPlace6);
//		tgBhColorPlaceList.removeAll(Collections.singleton(null));
//		if(!tgBhColorPlaceList.isEmpty()) {
//			//GILET_ボタンホール色指定_箇所コード
//			String tgBhColorPlaceCodeInDb = severalCodeInDb(tgBhColorPlaceList);
//			order.setGlBtnholeColorPlcCd(tgBhColorPlaceCodeInDb);
//			//GILET_ボタンホール色指定_箇所名
//			Map<String, String> tgBhColorPlaceMap = orderForm.getOptionGiletTuxedoInfo().getTgBhColorPlaceMap();
//			String tjBhColorPlaceNameInDb = severalNameInDb(tgBhColorPlaceList, tgBhColorPlaceMap);
//			order.setGlBtnholeColorPlcNm(tjBhColorPlaceNameInDb);
//		}
//		
//		String tgBhColor1 = orderForm.getOptionGiletTuxedoInfo().getTgBhColor1();
//		String tgBhColor2 = orderForm.getOptionGiletTuxedoInfo().getTgBhColor2();
//		String tgBhColor3 = orderForm.getOptionGiletTuxedoInfo().getTgBhColor3();
//		String tgBhColor4 = orderForm.getOptionGiletTuxedoInfo().getTgBhColor4();
//		String tgBhColor5 = orderForm.getOptionGiletTuxedoInfo().getTgBhColor5();
//		String tgBhColor6 = orderForm.getOptionGiletTuxedoInfo().getTgBhColor6();
//		
//		List<String> tgBhColorsList = new ArrayList<>();
//		tgBhColorsList.add(tgBhColor1);
//		tgBhColorsList.add(tgBhColor2);
//		tgBhColorsList.add(tgBhColor3);
//		tgBhColorsList.add(tgBhColor4);
//		tgBhColorsList.add(tgBhColor5);
//		tgBhColorsList.add(tgBhColor6);
//		tgBhColorsList.removeAll(Collections.singleton(null));
//		if(!tgBhColorsList.isEmpty()) {
//			//GILET_ボタンホール色指定_色コード
//			String tgBhColorsCodeInDb = severalCodeInDb(tgBhColorsList);
//			order.setGlBtnholeColorCd(tgBhColorsCodeInDb);
//			//GILET_ボタンホール色指定_色名
//			Map<String, String> tjBhColorsMap = orderForm.getOptionGiletTuxedoInfo().getTgBhColorsMap();
//			String tjBhColorsNameInDb = severalNameInDb(tgBhColorsList, tjBhColorsMap);
//			order.setGlBtnholeColorNm(tjBhColorsNameInDb);
//		}
//		
//		//タキシードGILETのボタン付け糸指定
//		String tgByColorPlace1 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace1();
//		String tgByColorPlace2 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace2();
//		String tgByColorPlace3 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace3();
//		String tgByColorPlace4 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace4();
//		String tgByColorPlace5 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace5();
//		String tgByColorPlace6 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace6();
//		String tgByColorPlace7 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace7();
//		String tgByColorPlace8 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace8();
//		String tgByColorPlace9 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace9();
//		String tgByColorPlace10 = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlace10();
//
//		List<String> tgByColorPlaceList = new ArrayList<>();
//		tgByColorPlaceList.add(tgByColorPlace1);
//		tgByColorPlaceList.add(tgByColorPlace2);
//		tgByColorPlaceList.add(tgByColorPlace3);
//		tgByColorPlaceList.add(tgByColorPlace4);
//		tgByColorPlaceList.add(tgByColorPlace5);
//		tgByColorPlaceList.add(tgByColorPlace6);
//		tgByColorPlaceList.add(tgByColorPlace7);
//		tgByColorPlaceList.add(tgByColorPlace8);
//		tgByColorPlaceList.add(tgByColorPlace9);
//		tgByColorPlaceList.add(tgByColorPlace10);
//		tgByColorPlaceList.removeAll(Collections.singleton(null));
//		if(!tgByColorPlaceList.isEmpty()) {
//			//GILET_ボタン付け糸指定_箇所コード
//			String tgByColorPlaceCodeInDb = severalCodeInDb(tgByColorPlaceList);
//			order.setGlBtnthreadColorPlcCd(tgByColorPlaceCodeInDb);
//			//GILET_ボタン付け糸指定_箇所名
//			Map<String, String> tgByColorPlaceMap = orderForm.getOptionGiletTuxedoInfo().getTgByColorPlaceMap();
//			String tgByColorPlaceNameInDb = severalNameInDb(tgByColorPlaceList, tgByColorPlaceMap);
//			order.setGlBtnthreadColorPlcNm(tgByColorPlaceNameInDb);
//		}
//		
//		String tgByColor1 = orderForm.getOptionGiletTuxedoInfo().getTgByColor1();
//		String tgByColor2 = orderForm.getOptionGiletTuxedoInfo().getTgByColor2();
//		String tgByColor3 = orderForm.getOptionGiletTuxedoInfo().getTgByColor3();
//		String tgByColor4 = orderForm.getOptionGiletTuxedoInfo().getTgByColor4();
//		String tgByColor5 = orderForm.getOptionGiletTuxedoInfo().getTgByColor5();
//		String tgByColor6 = orderForm.getOptionGiletTuxedoInfo().getTgByColor6();
//		String tgByColor7 = orderForm.getOptionGiletTuxedoInfo().getTgByColor7();
//		String tgByColor8 = orderForm.getOptionGiletTuxedoInfo().getTgByColor8();
//		String tgByColor9 = orderForm.getOptionGiletTuxedoInfo().getTgByColor9();
//		String tgByColor10 = orderForm.getOptionGiletTuxedoInfo().getTgByColor10();
//		
//		List<String> tgByColorsList = new ArrayList<>();
//		tgByColorsList.add(tgByColor1);
//		tgByColorsList.add(tgByColor2);
//		tgByColorsList.add(tgByColor3);
//		tgByColorsList.add(tgByColor4);
//		tgByColorsList.add(tgByColor5);
//		tgByColorsList.add(tgByColor6);
//		tgByColorsList.add(tgByColor7);
//		tgByColorsList.add(tgByColor8);
//		tgByColorsList.add(tgByColor9);
//		tgByColorsList.add(tgByColor10);
//		tgByColorsList.removeAll(Collections.singleton(null));
//		if(!tgByColorsList.isEmpty()) {
//			//GILET_ボタン付け糸指定_色コード
//			String tgByColorsCodeInDb = severalCodeInDb(tgByColorsList);
//			order.setGlBtnthreadColorCd(tgByColorsCodeInDb);
//			//GILET_ボタン付け糸指定_色名
//			Map<String, String> tgByColorsMap = orderForm.getOptionGiletTuxedoInfo().getTgByColorsMap();
//			String tgByColorsNameInDb = severalNameInDb(tgByColorsList, tgByColorsMap);
//			order.setGlBtnthreadColorNm(tgByColorsNameInDb);
//		}
//	}
//	
//	/**
//	 * タキシードPANTSのグループ項目名とコード
//	 * @param orderForm
//	 * @param order
//	 */
//	public void aboutTuxedoPantsCheckBoxInDb(OrderForm orderForm,Order order) {
//		//タキシードPANTSのベルトループ箇所 
//		String tpBeltLoopPlace1 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace1();
//		String tpBeltLoopPlace2 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace1();
//		String tpBeltLoopPlace3 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace1();
//		String tpBeltLoopPlace4 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace1();
//		String tpBeltLoopPlace5 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace1();
//		String tpBeltLoopPlace6 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace1();
//		String tpBeltLoopPlace7 = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlace1();
//		
//		List<String> tpBeltLoopPlaceList = new ArrayList<>();
//		tpBeltLoopPlaceList.add(tpBeltLoopPlace1);
//		tpBeltLoopPlaceList.add(tpBeltLoopPlace2);
//		tpBeltLoopPlaceList.add(tpBeltLoopPlace3);
//		tpBeltLoopPlaceList.add(tpBeltLoopPlace4);
//		tpBeltLoopPlaceList.add(tpBeltLoopPlace5);
//		tpBeltLoopPlaceList.add(tpBeltLoopPlace6);
//		tpBeltLoopPlaceList.add(tpBeltLoopPlace7);
//		tpBeltLoopPlaceList.removeAll(Collections.singleton(null));
//		if(!tpBeltLoopPlaceList.isEmpty()) {
//			//PANTS_ベルトループ_コード
//			String tpBeltLoopPlaceCodeInDb = severalCodeInDb(tpBeltLoopPlaceList);
//			order.setPtBeltloopCd(tpBeltLoopPlaceCodeInDb);
//			//PANTS_ベルトループ_名
//			Map<String, String> tpBeltLoopPlaceMap = orderForm.getOptionPantsTuxedoInfo().getTpBeltLoopPlaceMap();
//			String tpBeltLoopPlaceNameInDb = severalNameInDb(tpBeltLoopPlaceList, tpBeltLoopPlaceMap);
//			order.setPtBeltloopNm(tpBeltLoopPlaceNameInDb);
//		}
//		
//		//タキシードPANTSのボタンホール色指定箇所
//		String tpBhColorPlace1 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlace1();
//		String tpBhColorPlace2 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlace2();
//		String tpBhColorPlace3 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlace3();
//		String tpBhColorPlace4 = orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlace4();
//		
//		List<String> tpBhColorPlaceList = new ArrayList<>();
//		tpBhColorPlaceList.add(tpBhColorPlace1);
//		tpBhColorPlaceList.add(tpBhColorPlace2);
//		tpBhColorPlaceList.add(tpBhColorPlace3);
//		tpBhColorPlaceList.add(tpBhColorPlace4);
//		tpBhColorPlaceList.removeAll(Collections.singleton(null));
//		if(!tpBhColorPlaceList.isEmpty()) {
//			//PANTS_ボタンホール色指定_箇所コード
//			String tpBhColorPlaceCodeInDb = severalCodeInDb(tpBhColorPlaceList);
//			order.setPtBtnholeColorPlcCd(tpBhColorPlaceCodeInDb);
//			//PANTS_ボタンホール色指定_箇所名
//			Map<String, String> tpBhColorPlaceMap = orderForm.getOptionPantsTuxedoInfo().getTpBhColorPlaceMap();
//			String tpBhColorPlaceNameInDb = severalNameInDb(tpBhColorPlaceList, tpBhColorPlaceMap);
//			order.setPtBtnholeColorPlcNm(tpBhColorPlaceNameInDb);
//		}
//		
//		String tpBhColor1 = orderForm.getOptionPantsTuxedoInfo().getTpBhColor1();
//		String tpBhColor2 = orderForm.getOptionPantsTuxedoInfo().getTpBhColor2();
//		String tpBhColor3 = orderForm.getOptionPantsTuxedoInfo().getTpBhColor3();
//		String tpBhColor4 = orderForm.getOptionPantsTuxedoInfo().getTpBhColor4();
//		
//		List<String> tpBhColorsList = new ArrayList<>();
//		tpBhColorsList.add(tpBhColor1);
//		tpBhColorsList.add(tpBhColor2);
//		tpBhColorsList.add(tpBhColor3);
//		tpBhColorsList.add(tpBhColor4);
//		tpBhColorsList.removeAll(Collections.singleton(null));
//		if(!tpBhColorsList.isEmpty()) {
//			//PANTS_ボタンホール色指定_色コード
//			String tpBhColorsCodeInDb = severalCodeInDb(tpBhColorsList);
//			order.setPtBtnholeColorCd(tpBhColorsCodeInDb);
//			//PANTS_ボタンホール色指定_色名
//			Map<String, String> tpBhColorsMap = orderForm.getOptionPantsTuxedoInfo().getTpBhColorsMap();
//			String tpBhColorsNameInDb = severalNameInDb(tpBhColorsList, tpBhColorsMap);
//			order.setPtBtnholeColorNm(tpBhColorsNameInDb);
//		}
//		
//		//タキシードPANTSのボタン付け糸指定箇所
//		String tpByColorPlace1 = orderForm.getOptionPantsTuxedoInfo().getTpByColorPlace1();
//		String tpByColorPlace2 = orderForm.getOptionPantsTuxedoInfo().getTpByColorPlace2();
//		String tpByColorPlace3 = orderForm.getOptionPantsTuxedoInfo().getTpByColorPlace3();
//		String tpByColorPlace4 = orderForm.getOptionPantsTuxedoInfo().getTpByColorPlace4();
//		
//		List<String> tpByColorPlaceList = new ArrayList<>();
//		tpByColorPlaceList.add(tpByColorPlace1);
//		tpByColorPlaceList.add(tpByColorPlace2);
//		tpByColorPlaceList.add(tpByColorPlace3);
//		tpByColorPlaceList.add(tpByColorPlace4);
//		tpByColorPlaceList.removeAll(Collections.singleton(null));
//		if(!tpByColorPlaceList.isEmpty()) {
//			//PANTS_ボタン付け糸指定_箇所コード
//			String tpByColorPlaceCodeInDb = severalCodeInDb(tpByColorPlaceList);
//			order.setPtBtnthreadColorPlcCd(tpByColorPlaceCodeInDb);
//			//PANTS_ボタン付け糸指定_箇所名
//			Map<String, String> tpByColorPlaceMap = orderForm.getOptionPantsTuxedoInfo().getTpByColorPlaceMap();
//			String tpByColorPlaceNameInDb = severalNameInDb(tpByColorPlaceList, tpByColorPlaceMap);
//			order.setPtBtnthreadColorPlcNm(tpByColorPlaceNameInDb);
//		}
//		
//		String tpByColor1 = orderForm.getOptionPantsTuxedoInfo().getTpByColor1();
//		String tpByColor2 = orderForm.getOptionPantsTuxedoInfo().getTpByColor2();
//		String tpByColor3 = orderForm.getOptionPantsTuxedoInfo().getTpByColor3();
//		String tpByColor4 = orderForm.getOptionPantsTuxedoInfo().getTpByColor4();
//		List<String> tpByColorsList = new ArrayList<>();
//		tpByColorsList.add(tpByColor1);
//		tpByColorsList.add(tpByColor2);
//		tpByColorsList.add(tpByColor3);
//		tpByColorsList.add(tpByColor4);
//		tpByColorsList.removeAll(Collections.singleton(null));
//		if(!tpByColorsList.isEmpty()) {
//			//PANTS_ボタン付け糸指定_色コード
//			String tpByColorsCodeInDb = severalCodeInDb(tpByColorsList);
//			order.setPtBtnthreadColorCd(tpByColorsCodeInDb);
//			//PANTS_ボタン付け糸指定_色名
//			Map<String, String> tpByColorsMap = orderForm.getOptionPantsTuxedoInfo().getTpByColorsMap();
//			String tpByColorsNameInDb = severalNameInDb(tpByColorsList, tpByColorsMap);
//			order.setPtBtnthreadColorNm(tpByColorsNameInDb);
//		}
//	}
//	
//	/**
//	 * タキシードPANTS2のグループ項目名とコード
//	 * @param orderForm
//	 * @param order
//	 */
//	public void aboutTuxedoPants2CheckBoxInDb(OrderForm orderForm,Order order) {
//		//タキシードPANTSのベルトループ箇所 
//		String tp2BeltLoopPlace1 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace1();
//		String tp2BeltLoopPlace2 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace1();
//		String tp2BeltLoopPlace3 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace1();
//		String tp2BeltLoopPlace4 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace1();
//		String tp2BeltLoopPlace5 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace1();
//		String tp2BeltLoopPlace6 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace1();
//		String tp2BeltLoopPlace7 = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlace1();
//		
//		List<String> tp2BeltLoopPlaceList = new ArrayList<>();
//		tp2BeltLoopPlaceList.add(tp2BeltLoopPlace1);
//		tp2BeltLoopPlaceList.add(tp2BeltLoopPlace2);
//		tp2BeltLoopPlaceList.add(tp2BeltLoopPlace3);
//		tp2BeltLoopPlaceList.add(tp2BeltLoopPlace4);
//		tp2BeltLoopPlaceList.add(tp2BeltLoopPlace5);
//		tp2BeltLoopPlaceList.add(tp2BeltLoopPlace6);
//		tp2BeltLoopPlaceList.add(tp2BeltLoopPlace7);
//		tp2BeltLoopPlaceList.removeAll(Collections.singleton(null));
//		if(!tp2BeltLoopPlaceList.isEmpty()) {
//			//PANTS_ベルトループ_コード
//			String tp2BeltLoopPlaceCodeInDb = severalCodeInDb(tp2BeltLoopPlaceList);
//			order.setPt2BeltloopCd(tp2BeltLoopPlaceCodeInDb);
//			//PANTS_ベルトループ_名
//			Map<String, String> tp2BeltLoopPlaceMap = orderForm.getOptionPants2TuxedoInfo().getTp2BeltLoopPlaceMap();
//			String tp2BeltLoopPlaceNameInDb = severalNameInDb(tp2BeltLoopPlaceList, tp2BeltLoopPlaceMap);
//			order.setPt2BeltloopNm(tp2BeltLoopPlaceNameInDb);
//		}
//		
//		//タキシードPANTSのボタンホール色指定箇所
//		String tp2BhColorPlace1 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlace1();
//		String tp2BhColorPlace2 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlace2();
//		String tp2BhColorPlace3 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlace3();
//		String tp2BhColorPlace4 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlace4();
//		
//		List<String> tp2BhColorPlaceList = new ArrayList<>();
//		tp2BhColorPlaceList.add(tp2BhColorPlace1);
//		tp2BhColorPlaceList.add(tp2BhColorPlace2);
//		tp2BhColorPlaceList.add(tp2BhColorPlace3);
//		tp2BhColorPlaceList.add(tp2BhColorPlace4);
//		tp2BhColorPlaceList.removeAll(Collections.singleton(null));
//		if(!tp2BhColorPlaceList.isEmpty()) {
//			//PANTS_ボタンホール色指定_箇所コード
//			String tp2BhColorPlaceCodeInDb = severalCodeInDb(tp2BhColorPlaceList);
//			order.setPt2BtnholeColorPlcCd(tp2BhColorPlaceCodeInDb);
//			//PANTS_ボタンホール色指定_箇所名
//			Map<String, String> tp2BhColorPlaceMap = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorPlaceMap();
//			String tp2BhColorPlaceNameInDb = severalNameInDb(tp2BhColorPlaceList, tp2BhColorPlaceMap);
//			order.setPt2BtnholeColorPlcNm(tp2BhColorPlaceNameInDb);
//		}
//		
//		String tp2BhColor1 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColor1();
//		String tp2BhColor2 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColor2();
//		String tp2BhColor3 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColor3();
//		String tp2BhColor4 = orderForm.getOptionPants2TuxedoInfo().getTp2BhColor4();
//		
//		List<String> tp2BhColorsList = new ArrayList<>();
//		tp2BhColorsList.add(tp2BhColor1);
//		tp2BhColorsList.add(tp2BhColor2);
//		tp2BhColorsList.add(tp2BhColor3);
//		tp2BhColorsList.add(tp2BhColor4);
//		tp2BhColorsList.removeAll(Collections.singleton(null));
//		if(!tp2BhColorsList.isEmpty()) {
//			//PANTS_ボタンホール色指定_色コード
//			String tp2BhColorsCodeInDb = severalCodeInDb(tp2BhColorsList);
//			order.setPt2BtnholeColorCd(tp2BhColorsCodeInDb);
//			//PANTS_ボタンホール色指定_色名
//			Map<String, String> tp2BhColorsMap = orderForm.getOptionPants2TuxedoInfo().getTp2BhColorsMap();
//			String tp2BhColorsNameInDb = severalNameInDb(tp2BhColorsList, tp2BhColorsMap);
//			order.setPt2BtnholeColorNm(tp2BhColorsNameInDb);
//		}
//		
//		//タキシードPANTSのボタン付け糸指定箇所
//		String tp2ByColorPlace1 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlace1();
//		String tp2ByColorPlace2 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlace2();
//		String tp2ByColorPlace3 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlace3();
//		String tp2ByColorPlace4 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlace4();
//		
//		List<String> tp2ByColorPlaceList = new ArrayList<>();
//		tp2ByColorPlaceList.add(tp2ByColorPlace1);
//		tp2ByColorPlaceList.add(tp2ByColorPlace2);
//		tp2ByColorPlaceList.add(tp2ByColorPlace3);
//		tp2ByColorPlaceList.add(tp2ByColorPlace4);
//		tp2ByColorPlaceList.removeAll(Collections.singleton(null));
//		if(!tp2ByColorPlaceList.isEmpty()) {
//			//PANTS_ボタン付け糸指定_箇所コード
//			String tp2ByColorPlaceCodeInDb = severalCodeInDb(tp2ByColorPlaceList);
//			order.setPtBtnthreadColorPlcCd(tp2ByColorPlaceCodeInDb);
//			//PANTS_ボタン付け糸指定_箇所名
//			Map<String, String> tp2ByColorPlaceMap = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorPlaceMap();
//			String tp2ByColorPlaceNameInDb = severalNameInDb(tp2ByColorPlaceList, tp2ByColorPlaceMap);
//			order.setPt2BtnthreadColorPlcNm(tp2ByColorPlaceNameInDb);
//		}
//		
//		String tp2ByColor1 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColor1();
//		String tp2ByColor2 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColor2();
//		String tp2ByColor3 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColor3();
//		String tp2ByColor4 = orderForm.getOptionPants2TuxedoInfo().getTp2ByColor4();
//		List<String> tp2ByColorsList = new ArrayList<>();
//		tp2ByColorsList.add(tp2ByColor1);
//		tp2ByColorsList.add(tp2ByColor2);
//		tp2ByColorsList.add(tp2ByColor3);
//		tp2ByColorsList.add(tp2ByColor4);
//		tp2ByColorsList.removeAll(Collections.singleton(null));
//		if(!tp2ByColorsList.isEmpty()) {
//			//PANTS_ボタン付け糸指定_色コード
//			String tp2ByColorsCodeInDb = severalCodeInDb(tp2ByColorsList);
//			order.setPt2BtnthreadColorCd(tp2ByColorsCodeInDb);
//			//PANTS_ボタン付け糸指定_色名
//			Map<String, String> tp2ByColorsMap = orderForm.getOptionPants2TuxedoInfo().getTp2ByColorsMap();
//			String tp2ByColorsNameInDb = severalNameInDb(tp2ByColorsList, tp2ByColorsMap);
//			order.setPt2BtnthreadColorNm(tp2ByColorsNameInDb);
//		}
//	}
//	
//	public void aboutWashableJacketCheckBoxInDb(OrderForm orderForm,Order order) {
//		//ウォッシャブルJACKETのステッチ変更箇所
//		String wjStitchModifyPlace1 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace1();
//		String wjStitchModifyPlace2 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace2();
//		String wjStitchModifyPlace3 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace3();
//		String wjStitchModifyPlace4 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace4();
//		String wjStitchModifyPlace5 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace5();
//		String wjStitchModifyPlace6 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace6();
//		String wjStitchModifyPlace7 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace7();
//		String wjStitchModifyPlace8 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace8();
//		String wjStitchModifyPlace9 = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlace9();
//		
//		List<String> wjStitchModifyPlaceList = new ArrayList<>();
//		wjStitchModifyPlaceList.add(wjStitchModifyPlace1);
//		wjStitchModifyPlaceList.add(wjStitchModifyPlace2);
//		wjStitchModifyPlaceList.add(wjStitchModifyPlace3);
//		wjStitchModifyPlaceList.add(wjStitchModifyPlace4);
//		wjStitchModifyPlaceList.add(wjStitchModifyPlace5);
//		wjStitchModifyPlaceList.add(wjStitchModifyPlace6);
//		wjStitchModifyPlaceList.add(wjStitchModifyPlace7);
//		wjStitchModifyPlaceList.add(wjStitchModifyPlace8);
//		wjStitchModifyPlaceList.add(wjStitchModifyPlace9);
//		wjStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		if(!wjStitchModifyPlaceList.isEmpty()) {
//			//JACKET_ステッチ箇所変更_コード
//			String wjStitchModifyPlaceCodeInDb = severalCodeInDb(wjStitchModifyPlaceList);
//			order.setJkStitchPlcCd(wjStitchModifyPlaceCodeInDb);
//			//JACKET_ステッチ箇所変更_名
//			Map<String, String> wjStitchModifyPlaceMap = orderForm.getOptionJacketWashableInfo().getWjStitchModifyPlaceMap();
//			String wjStitchModifyPlaceNameInDb = severalNameInDb(wjStitchModifyPlaceList, wjStitchModifyPlaceMap);
//			order.setJkStitchPlcNm(wjStitchModifyPlaceNameInDb);
//		}
//		
//		//ウォッシャブルJACKETのダブルステッチ変更箇所
//		String wjDStitchModifyPlace1 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace1();
//		String wjDStitchModifyPlace2 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace2();
//		String wjDStitchModifyPlace3 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace3();
//		String wjDStitchModifyPlace4 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace4();
//		String wjDStitchModifyPlace5 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace5();
//		String wjDStitchModifyPlace6 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace6();
//		String wjDStitchModifyPlace7 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace7();
//		String wjDStitchModifyPlace8 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace8();
//		String wjDStitchModifyPlace9 = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlace9();
//		
//		List<String> wjDStitchModifyPlaceList = new ArrayList<>();
//		wjDStitchModifyPlaceList.add(wjDStitchModifyPlace1);
//		wjDStitchModifyPlaceList.add(wjDStitchModifyPlace2);
//		wjDStitchModifyPlaceList.add(wjDStitchModifyPlace3);
//		wjDStitchModifyPlaceList.add(wjDStitchModifyPlace4);
//		wjDStitchModifyPlaceList.add(wjDStitchModifyPlace5);
//		wjDStitchModifyPlaceList.add(wjDStitchModifyPlace6);
//		wjDStitchModifyPlaceList.add(wjDStitchModifyPlace7);
//		wjDStitchModifyPlaceList.add(wjDStitchModifyPlace8);
//		wjDStitchModifyPlaceList.add(wjDStitchModifyPlace9);
//		wjDStitchModifyPlaceList.removeAll(Collections.singleton(null));
//		if(!wjDStitchModifyPlaceList.isEmpty()) {
//			//JACKET_ダブルステッチ_コード
//			String wjDStitchModifyPlaceCodeInDb = severalCodeInDb(wjDStitchModifyPlaceList);
//			order.setJkDblstitchPlcCd(wjDStitchModifyPlaceCodeInDb);
//			//JACKET_ダブルステッチ_名
//			Map<String, String> wjDStitchModifyPlaceMap = orderForm.getOptionJacketWashableInfo().getWjDStitchModifyPlaceMap();
//			String wjDStitchModifyPlaceNameInDb = severalNameInDb(wjDStitchModifyPlaceList, wjDStitchModifyPlaceMap);
//			order.setJkDblstitchPlcNm(wjDStitchModifyPlaceNameInDb);
//		}
//		
//		//ウォッシャブルJACKETのAMF色指定箇所
//		String wjAmfColorPlace1 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace1();
//		String wjAmfColorPlace2 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace2();
//		String wjAmfColorPlace3 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace3();
//		String wjAmfColorPlace4 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace4();
//		String wjAmfColorPlace5 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace5();
//		String wjAmfColorPlace6 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace6();
//		String wjAmfColorPlace7 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace7();
//		String wjAmfColorPlace8 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace8();
//		String wjAmfColorPlace9 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace9();
//		String wjAmfColorPlace10 = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlace10();
//		
//		List<String> wjAmfColorPlaceList = new ArrayList<>();
//		wjAmfColorPlaceList.add(wjAmfColorPlace1);
//		wjAmfColorPlaceList.add(wjAmfColorPlace2);
//		wjAmfColorPlaceList.add(wjAmfColorPlace3);
//		wjAmfColorPlaceList.add(wjAmfColorPlace4);
//		wjAmfColorPlaceList.add(wjAmfColorPlace5);
//		wjAmfColorPlaceList.add(wjAmfColorPlace6);
//		wjAmfColorPlaceList.add(wjAmfColorPlace7);
//		wjAmfColorPlaceList.add(wjAmfColorPlace8);
//		wjAmfColorPlaceList.add(wjAmfColorPlace9);
//		wjAmfColorPlaceList.add(wjAmfColorPlace10);
//		wjAmfColorPlaceList.removeAll(Collections.singleton(null));
//		if(!wjAmfColorPlaceList.isEmpty()) {
//			//JACKET_AMF色指定_箇所コード
//			String wjAmfColorPlaceCodeInDb = severalCodeInDb(wjAmfColorPlaceList);
//			order.setJkAmfColorPlcCd(wjAmfColorPlaceCodeInDb);
//			//JACKET_AMF色指定_箇所名
//			Map<String, String> wjAmfColorPlaceMap = orderForm.getOptionJacketWashableInfo().getWjAmfColorPlaceMap();
//			String wjAmfColorPlaceNameInDb = severalNameInDb(wjAmfColorPlaceList, wjAmfColorPlaceMap);
//			order.setJkAmfColorPlcNm(wjAmfColorPlaceNameInDb);
//		}
//		
//		String wjAmfColor1 = orderForm.getOptionJacketWashableInfo().getWjAmfColor1();
//		String wjAmfColor2 = orderForm.getOptionJacketWashableInfo().getWjAmfColor2();
//		String wjAmfColor3 = orderForm.getOptionJacketWashableInfo().getWjAmfColor3();
//		String wjAmfColor4 = orderForm.getOptionJacketWashableInfo().getWjAmfColor4();
//		String wjAmfColor5 = orderForm.getOptionJacketWashableInfo().getWjAmfColor5();
//		String wjAmfColor6 = orderForm.getOptionJacketWashableInfo().getWjAmfColor6();
//		String wjAmfColor7 = orderForm.getOptionJacketWashableInfo().getWjAmfColor7();
//		String wjAmfColor8 = orderForm.getOptionJacketWashableInfo().getWjAmfColor8();
//		String wjAmfColor9 = orderForm.getOptionJacketWashableInfo().getWjAmfColor9();
//		String wjAmfColor10 = orderForm.getOptionJacketWashableInfo().getWjAmfColor10();
//		
//		List<String> wjAmfColorsList = new ArrayList<>();
//		wjAmfColorsList.add(wjAmfColor1);
//		wjAmfColorsList.add(wjAmfColor2);
//		wjAmfColorsList.add(wjAmfColor3);
//		wjAmfColorsList.add(wjAmfColor4);
//		wjAmfColorsList.add(wjAmfColor5);
//		wjAmfColorsList.add(wjAmfColor6);
//		wjAmfColorsList.add(wjAmfColor7);
//		wjAmfColorsList.add(wjAmfColor8);
//		wjAmfColorsList.add(wjAmfColor9);
//		wjAmfColorsList.add(wjAmfColor10);
//		wjAmfColorsList.removeAll(Collections.singleton(null));
//		if(!wjAmfColorsList.isEmpty()) {
//			//JACKET_AMF色指定_色コード
//			String wjAmfColorsCodeInDb = severalCodeInDb(wjAmfColorsList);
//			order.setJkAmfColorCd(wjAmfColorsCodeInDb);
//			//JACKET_AMF色指定_色名
//			Map<String, String> wjAmfColorsMap = orderForm.getOptionJacketWashableInfo().getWjAmfColorsMap();
//			String wjAmfColorsNameInDb = severalNameInDb(wjAmfColorsList, wjAmfColorsMap);
//			order.setJkAmfColorNm(wjAmfColorsNameInDb);
//		}
//		
//		//ウォッシャブルJACKETのボタンホール色指定箇所
//		String wjBhColorPlace1 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace1();
//		String wjBhColorPlace2 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace2();
//		String wjBhColorPlace3 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace3();
//		String wjBhColorPlace4 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace4();
//		String wjBhColorPlace5 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace5();
//		String wjBhColorPlace6 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace6();
//		String wjBhColorPlace7 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace7();
//		String wjBhColorPlace8 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace8();
//		String wjBhColorPlace9 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace9();
//		String wjBhColorPlace10 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace10();
//		String wjBhColorPlace11 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace11();
//		String wjBhColorPlace12 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace12();
//		String wjBhColorPlace13 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace13();
//		String wjBhColorPlace14 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace14();
//		String wjBhColorPlace15 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace15();
//		String wjBhColorPlace16 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace16();
//		String wjBhColorPlace17 = orderForm.getOptionJacketWashableInfo().getWjBhColorPlace17();
//
//		List<String> wjBhColorPlaceList = new ArrayList<>();
//		wjBhColorPlaceList.add(wjBhColorPlace1);
//		wjBhColorPlaceList.add(wjBhColorPlace2);
//		wjBhColorPlaceList.add(wjBhColorPlace3);
//		wjBhColorPlaceList.add(wjBhColorPlace4);
//		wjBhColorPlaceList.add(wjBhColorPlace5);
//		wjBhColorPlaceList.add(wjBhColorPlace6);
//		wjBhColorPlaceList.add(wjBhColorPlace7);
//		wjBhColorPlaceList.add(wjBhColorPlace8);
//		wjBhColorPlaceList.add(wjBhColorPlace9);
//		wjBhColorPlaceList.add(wjBhColorPlace10);
//		wjBhColorPlaceList.add(wjBhColorPlace11);
//		wjBhColorPlaceList.add(wjBhColorPlace12);
//		wjBhColorPlaceList.add(wjBhColorPlace13);
//		wjBhColorPlaceList.add(wjBhColorPlace14);
//		wjBhColorPlaceList.add(wjBhColorPlace15);
//		wjBhColorPlaceList.add(wjBhColorPlace16);
//		wjBhColorPlaceList.add(wjBhColorPlace17);
//		wjBhColorPlaceList.removeAll(Collections.singleton(null));
//		if(!wjBhColorPlaceList.isEmpty()) {
//			//JACKET_ボタンホール色指定_箇所コード
//			String wjBhColorPlaceCodeInDb = severalCodeInDb(wjBhColorPlaceList);
//			order.setJkBtnholeColorPlcCd(wjBhColorPlaceCodeInDb);
//			//JACKET_ボタンホール色指定_箇所名
//			Map<String, String> wjBhColorPlaceMap = orderForm.getOptionJacketWashableInfo().getWjBhColorPlaceMap();
//			String wjBhColorPlaceNameInDb = severalNameInDb(wjBhColorPlaceList, wjBhColorPlaceMap);
//			order.setJkBtnholeColorPlcN(wjBhColorPlaceNameInDb);
//		}
//		
//		String wjBhColor1 = orderForm.getOptionJacketWashableInfo().getWjBhColor1();
//		String wjBhColor2 = orderForm.getOptionJacketWashableInfo().getWjBhColor2();
//		String wjBhColor3 = orderForm.getOptionJacketWashableInfo().getWjBhColor3();
//		String wjBhColor4 = orderForm.getOptionJacketWashableInfo().getWjBhColor4();
//		String wjBhColor5 = orderForm.getOptionJacketWashableInfo().getWjBhColor5();
//		String wjBhColor6 = orderForm.getOptionJacketWashableInfo().getWjBhColor6();
//		String wjBhColor7 = orderForm.getOptionJacketWashableInfo().getWjBhColor7();
//		String wjBhColor8 = orderForm.getOptionJacketWashableInfo().getWjBhColor8();
//		String wjBhColor9 = orderForm.getOptionJacketWashableInfo().getWjBhColor9();
//		String wjBhColor10 = orderForm.getOptionJacketWashableInfo().getWjBhColor10();
//		String wjBhColor11 = orderForm.getOptionJacketWashableInfo().getWjBhColor11();
//		String wjBhColor12 = orderForm.getOptionJacketWashableInfo().getWjBhColor12();
//		String wjBhColor13 = orderForm.getOptionJacketWashableInfo().getWjBhColor13();
//		String wjBhColor14 = orderForm.getOptionJacketWashableInfo().getWjBhColor14();
//		String wjBhColor15 = orderForm.getOptionJacketWashableInfo().getWjBhColor15();
//		String wjBhColor16 = orderForm.getOptionJacketWashableInfo().getWjBhColor16();
//		String wjBhColor17 = orderForm.getOptionJacketWashableInfo().getWjBhColor17();
//		
//		List<String> wjBhColorsList = new ArrayList<>();
//		wjBhColorsList.add(wjBhColor1);
//		wjBhColorsList.add(wjBhColor2);
//		wjBhColorsList.add(wjBhColor3);
//		wjBhColorsList.add(wjBhColor4);
//		wjBhColorsList.add(wjBhColor5);
//		wjBhColorsList.add(wjBhColor6);
//		wjBhColorsList.add(wjBhColor7);
//		wjBhColorsList.add(wjBhColor8);
//		wjBhColorsList.add(wjBhColor9);
//		wjBhColorsList.add(wjBhColor10);
//		wjBhColorsList.add(wjBhColor11);
//		wjBhColorsList.add(wjBhColor12);
//		wjBhColorsList.add(wjBhColor13);
//		wjBhColorsList.add(wjBhColor14);
//		wjBhColorsList.add(wjBhColor15);
//		wjBhColorsList.add(wjBhColor16);
//		wjBhColorsList.add(wjBhColor17);
//		wjBhColorsList.removeAll(Collections.singleton(null));
//		if(!wjBhColorsList.isEmpty()) {
//			//JACKET_ボタンホール色指定_色コード
//			String wjBhColorsCodeInDb = severalCodeInDb(wjBhColorsList);
//			order.setJkBtnholeColorCd(wjBhColorsCodeInDb);
//			//JACKET_ボタンホール色指定_色名
//			Map<String, String> wjBhColorsMap = orderForm.getOptionJacketWashableInfo().getWjBhColorsMap();
//			String wjBhColorsNameInDb = severalNameInDb(wjBhColorsList, wjBhColorsMap);
//			order.setJkBtnholeColorNm(wjBhColorsNameInDb);
//		}
//		
//		
//		
//	}
	
	/**
	 * JACKETの上代価額合計
	 * 
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return 
	 * @return
	 */
	public int orderJacketPriceCount(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList) {

		int jkPriceCount = 0;
		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_JACKET.getValue();
		String branchModelCode = orderForm.getOptionJacketStandardInfo().getOjJacketModel();

		JacketOptionStandardPriceEnum[] priceEnum = JacketOptionStandardPriceEnum.values();

		for (JacketOptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValue();
			String valueTwo = price.getValue2();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object result = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					result = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketStandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + result;

				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + result + resultTwo;

				for (OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null) {
								jkPriceCount += 0;
								
							} else {
								jkPriceCount += Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice());
								 
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null
									&& orderCodePrice.getOrderBranchDetailDoublePrice() == null) {
								jkPriceCount += 0;
								
							} else {
								
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailDoublePrice());
								jkPriceCount += OrderDoublePrice;
								
							}
							break;
						}
					} else {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchPrice() == null) {
								jkPriceCount += 0;
							} else {
								jkPriceCount += Integer.parseInt(orderCodePrice.getOrderBranchPrice());
								
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchPrice() == null
									&& orderCodePrice.getOrderBranchDetailPrice() == null) {
								jkPriceCount += 0;
							} else {
								
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
								jkPriceCount += OrderDoublePrice;
								
							}
							break;
						} 
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return jkPriceCount;
	}
	
	/**
	 * GILETの上代価額合計
	 * 
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return 
	 */
	public int orderGiletPriceCount(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList) {

		int glPriceCount = 0;
		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_GILET.getValue();
		String branchModelCode = orderForm.getOptionGiletStandardInfo().getOgGiletModel();

		GiletOptionStandardPriceEnum[] priceEnum = GiletOptionStandardPriceEnum.values();
		for (GiletOptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletStandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + resultOne;
				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + resultOne + resultTwo;

				for (OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if ("CH14-D".equals(orderForm.getOptionGiletStandardInfo().getOgGiletModel())) {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null) {
								glPriceCount += 0;
							} else {
								glPriceCount += Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice());
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null
									&& orderCodePrice.getOrderBranchDetailDoublePrice() == null) {
								glPriceCount += 0;
							} else {
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailDoublePrice());
								glPriceCount += OrderDoublePrice;
							}
							break;
						}
					} else {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchPrice() == null) {
								glPriceCount += 0;
							} else {
								glPriceCount += Integer.parseInt(orderCodePrice.getOrderBranchPrice());
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchPrice() == null
									&& orderCodePrice.getOrderBranchDetailPrice() == null) {
								glPriceCount += 0;
							} else {
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
								glPriceCount += OrderDoublePrice;
							}
							break;
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return glPriceCount;
	}

	/**
	 * PANTSの上代価額合計
	 * 
	 * @param orderForm
	 * @param order
	 */
	public int orderPantsPriceCount(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList) {

		int ptPriceCount = 0;
		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS.getValue();
		String branchModelCode = orderForm.getOptionPantsStandardInfo().getOpPantsModel();

		PantsOptionStandardPriceEnum[] priceEnum = PantsOptionStandardPriceEnum.values();
		for (PantsOptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPantsStandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + resultOne;
				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + resultOne + resultTwo;

				for (OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderCodePrice.getOrderDetailKeyCode() == null) {
						if (orderCodePrice.getOrderBranchPrice() == null) {
							ptPriceCount += 0;
						} else {
							ptPriceCount += Integer.parseInt(orderCodePrice.getOrderBranchPrice());
						}
						break;
					} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if (orderCodePrice.getOrderBranchPrice() == null
								&& orderCodePrice.getOrderBranchDetailPrice() == null) {
							ptPriceCount += 0;
						} else {
							Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
									+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
							ptPriceCount += OrderDoublePrice;
						}
						break;
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return ptPriceCount;
	}

	/**
	 * PANTS2の上代価額合計
	 * 
	 * @param orderForm
	 * @param optionBranchPriceList
	 */
	public int orderPants2PriceCount(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList) {

		int pt2PriceCount = 0;
		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS2.getValue();
		String branchModelCode = orderForm.getOptionPants2StandardInfo().getOp2PantsModel();

		Pants2OptionStandardPriceEnum[] priceEnum = Pants2OptionStandardPriceEnum.values();
		for (Pants2OptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2StandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPants2StandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + resultOne;
				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + resultOne + resultTwo;

				for (OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderCodePrice.getOrderDetailKeyCode() == null) {
						if (orderCodePrice.getOrderBranchPrice() == null) {
							pt2PriceCount += 0;
						} else {
							pt2PriceCount += Integer.parseInt(orderCodePrice.getOrderBranchPrice());
						}
						break;
					} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if (orderCodePrice.getOrderBranchPrice() == null
								&& orderCodePrice.getOrderBranchDetailPrice() == null) {
							pt2PriceCount += 0;
						} else {
							Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
									+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
							pt2PriceCount += OrderDoublePrice;
						}
						break;
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return pt2PriceCount;
	}
	
	/**
	 * 
	 * @param orderForm
	 * @param retailPriceRelatedProjects
	 */
	public int set3Piece2PantsPrice(OrderForm orderForm,Map<String, Integer> retailPriceRelatedProjects) {
		String productItem = orderForm.getProductItem();
		String productIs3Piece = orderForm.getProductIs3Piece();
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
		int count3Piece2PantsPrice = 0;
		if("01".equals(productItem)) {
			// JACKETのダブルについて
			if("0000105".equals(ojFrontBtnCnt)) {
				Integer doubleJACKET = retailPriceRelatedProjects.get("doubleJACKET");
				count3Piece2PantsPrice = count3Piece2PantsPrice + doubleJACKET;
			}
			if("0009901".equals(productIs3Piece)&&"0009902".equals(productSparePantsClass)) {
				Integer sparePantsPrice = retailPriceRelatedProjects.get("sparePants");
				count3Piece2PantsPrice = count3Piece2PantsPrice + sparePantsPrice;
			}else if("0009902".equals(productIs3Piece)&&"0009901".equals(productSparePantsClass)) {
				Integer price3PiecePrice = retailPriceRelatedProjects.get("price3Piece");
				count3Piece2PantsPrice = count3Piece2PantsPrice + price3PiecePrice;
			}
			else if("0009902".equals(productIs3Piece)&&"0009902".equals(productSparePantsClass)) {
				Integer price3PiecePrice = retailPriceRelatedProjects.get("price3Piece");
				Integer sparePantsPrice = retailPriceRelatedProjects.get("sparePants");
				count3Piece2PantsPrice = count3Piece2PantsPrice + price3PiecePrice + sparePantsPrice;
			}
		}
		else if("02".equals(productItem)) {
			// JACKETのダブルについて
			if("0000105".equals(ojFrontBtnCnt)) {
				Integer singleDoubleJACKET = retailPriceRelatedProjects.get("singleDoubleJACKET");
				count3Piece2PantsPrice = count3Piece2PantsPrice + singleDoubleJACKET;
			}
		}
		return count3Piece2PantsPrice;
	}
	
	/**
	 * 
	 * @param orderFindFabric
	 * @param orderCoForm
	 * @return
	 */
	public int getGoodsPrice(OrderFindFabric orderFindFabric, OrderForm orderForm) {
		int dataBaseProductPrice = 0;
		// 上代
		Integer retailPrice = orderFindFabric.getRetailPrice();

		String productItem = orderForm.getProductItem();
		if ("01".equals(productItem)) {
			dataBaseProductPrice = Integer.parseInt(String.valueOf(retailPrice));
		} else if ("02".equals(productItem)) {
			// シングルJACKET単品率
			Integer singleJacketOnlyRate = orderFindFabric.getSingleJacketOnlyRate();
			// シングルJacketの単品購買追加金額
			Integer jkSingleOnlyPlusAlphaPrice = orderFindFabric.getJkSingleOnlyPlusAlphaPrice();
			// JACKET単品Single
			BigDecimal jkSinglePice = new BigDecimal(retailPrice)
					.multiply((new BigDecimal(singleJacketOnlyRate).divide(new BigDecimal("100"))))
					.add(new BigDecimal(jkSingleOnlyPlusAlphaPrice));
			dataBaseProductPrice = Integer.parseInt(String.valueOf(jkSinglePice.setScale(0)));
		} else if ("03".equals(productItem)) {
			// PANTS単品率
			Integer pantOnlyRate = orderFindFabric.getPantOnlyRate();
			Integer ptOnlyPlusAlphaPrice = orderFindFabric.getPtOnlyPlusAlphaPrice();
			BigDecimal ptProductPrice = new BigDecimal(retailPrice)
					.multiply((new BigDecimal(pantOnlyRate).divide(new BigDecimal("100"))))
					.add(new BigDecimal(ptOnlyPlusAlphaPrice));
			dataBaseProductPrice = Integer.parseInt(String.valueOf(ptProductPrice.setScale(0)));
		} else if ("04".equals(productItem)) {
			Integer singleGiletOnlyRate = orderFindFabric.getSingleGiletOnlyRate();
			Integer glSingleOnlyPlusAlphaPrice = orderFindFabric.getGlSingleOnlyPlusAlphaPrice();
			BigDecimal glProductPrice = new BigDecimal(retailPrice)
					.multiply((new BigDecimal(singleGiletOnlyRate).divide(new BigDecimal("100"))))
					.add(new BigDecimal(glSingleOnlyPlusAlphaPrice));
			dataBaseProductPrice = Integer.parseInt(String.valueOf(glProductPrice.setScale(0)));
		}
		return dataBaseProductPrice;
	}
	
}	
