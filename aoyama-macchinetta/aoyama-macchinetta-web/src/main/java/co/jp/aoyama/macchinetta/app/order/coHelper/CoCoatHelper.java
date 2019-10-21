package co.jp.aoyama.macchinetta.app.order.coHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dozer.util.ReflectionUtils;
import org.springframework.ui.Model;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.common.CoContorllerPublicMethodUtil;
import co.jp.aoyama.macchinetta.app.common.CoTypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.OptionCodeKeys;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm;
import co.jp.aoyama.macchinetta.app.order.TypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.enums.coat.CoatCoOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;

public class CoCoatHelper {
	
	@Inject
	TypeSizeService typeSizeService;
	
	CoTypeSizeOptimization coTypeSizeOptimization = new CoTypeSizeOptimization();
	
	public boolean coatCheck(ResultMessages messages, OrderCoForm orderCoForm, String item,
			Map<String, List<Adjust>> adjustByItem, TypeSizeService typeSizeService) {
		boolean coatFlag = false;
		String coatModel = orderCoForm.getCoOptionCoatStandardInfo().getCoatModel();
		List<TypeSizeOptimization> coCtTypeSizeOptimization = this.getCoCtTypeSizeOptimization(orderCoForm,typeSizeService);
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
			}else {
				String corCtBodySize = coAdjustCoatStandardInfo.getCorCtBodylengthSize();
				if("".equals(corCtBodySize)||"0".equals(corCtBodySize)||corCtBodySize == null) {
					messages.add("E034", "COATの着丈修正");
					coatFlag = true;
				}
				
				String corCtWaistSize = coAdjustCoatStandardInfo.getCorCtWaistSize();
				if("".equals(corCtWaistSize)||"0".equals(corCtWaistSize)||corCtWaistSize == null) {
					messages.add("E034", "COATのウエスト修正");
					coatFlag = true;
				}
				
				String corCtRightsleeveSize = coAdjustCoatStandardInfo.getCorCtRightsleeveSize();
				if("".equals(corCtRightsleeveSize)||"0".equals(corCtRightsleeveSize)||corCtRightsleeveSize == null) {
					messages.add("E034", "COATの袖丈右修正");
					coatFlag = true;
				}
				
				String corCtLeftsleeveSize = coAdjustCoatStandardInfo.getCorCtLeftsleeveSize();
				if("".equals(corCtLeftsleeveSize)||"0".equals(corCtLeftsleeveSize)||corCtLeftsleeveSize == null) {
					messages.add("E034", "COATの袖丈左修正");
					coatFlag = true;
				}
				
				String corCtVenthightSize = coAdjustCoatStandardInfo.getCorCtVenthightSize();
				if("".equals(corCtVenthightSize)||"0".equals(corCtVenthightSize)||corCtVenthightSize == null) {
					messages.add("E034", "COATのベント修正（高さ）");
					coatFlag = true;
				}
				
				String corCtPktposSize = coAdjustCoatStandardInfo.getCorCtPktposSize();
				if("".equals(corCtPktposSize)||"0".equals(corCtPktposSize)||corCtPktposSize == null) {
					messages.add("E034", "COATのポケット位置");
					coatFlag = true;
				}
				
				List<Adjust> glAdjustList = adjustByItem.get("06");
				if(!glAdjustList.isEmpty()&&!coCtTypeSizeOptimization.isEmpty()) {
					for (Adjust adjust : glAdjustList) {
						Map<String, String> ctStandardValue = this.getCtStandardValue(coCtTypeSizeOptimization);
						// COAT_着丈_型サイズ
						String stringCorCtBodylengthSize = ctStandardValue.get("corCtBodylengthSize");
						BigDecimal corCtBodylengthSize = new BigDecimal(stringCorCtBodylengthSize);
						
						// COAT_ウエスト_型サイズ
						String stringCorCtWaistSize = ctStandardValue.get("corCtWaistSize");
						BigDecimal corCtWaistlengthSize = new BigDecimal(stringCorCtWaistSize);
						
						// COAT_袖丈右_型サイズ
						String stringCorCtRightsleeveSize = ctStandardValue.get("corCtRightsleeveSize");
						BigDecimal corCtRightlengthsleeveSize = new BigDecimal(stringCorCtRightsleeveSize);
						
						// COAT_袖丈左_型サイズ
						String stringCorCtLeftsleeveSize = ctStandardValue.get("corCtLeftsleeveSize");
						BigDecimal corCtLeftlengthsleeveSize = new BigDecimal(stringCorCtLeftsleeveSize);
						
						// COAT_ベント修正（高さ）_型サイズ
						String stringCorCtVenthightSize = ctStandardValue.get("corCtVenthightSize");
						BigDecimal corCtVenthightlengthSize = new BigDecimal(stringCorCtVenthightSize);
						
						// COAT_ポケット位置_型サイズ
						String stringCorCtPktposSize = ctStandardValue.get("corCtPktposSize");
						BigDecimal corCtPktposlengthSize = new BigDecimal(stringCorCtPktposSize);
						
						// COAT_着丈_グロス
						BigDecimal corCtBodylengthGross = new BigDecimal(coAdjustCoatStandardInfo.getCorCtBodylengthGross());
						
						// COAT_ウエスト_グロス
						BigDecimal corCtWaistGross = new BigDecimal(coAdjustCoatStandardInfo.getCorCtWaistGross());
						
						// COAT_袖丈右_グロス
						BigDecimal corCtRightsleeveGross = new BigDecimal(coAdjustCoatStandardInfo.getCorCtRightsleeveGross());
						
						// COAT_袖丈左_グロス
						BigDecimal corCtLeftsleeveGross = new BigDecimal(coAdjustCoatStandardInfo.getCorCtLeftsleeveGross());
						
						// COAT_ベント修正（高さ）_グロス
						BigDecimal corCtVenthightGross = new BigDecimal(coAdjustCoatStandardInfo.getCorCtVenthightGross());
						
						// COAT_ポケット位置_グロス
						BigDecimal corCtPktposGross = new BigDecimal(coAdjustCoatStandardInfo.getCorCtPktposGross());
						
						if("06".equals(adjust.getItemCode())) {
							if("06".equals(adjust.getSubItemCode())) {
								// 着丈修正
								if("01".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corCtBodylengthSize);
									BigDecimal addMax = adjusteMax.add(corCtBodylengthSize);
									if(corCtBodylengthGross.compareTo(addMin) == -1 || corCtBodylengthGross.compareTo(addMax) == 1) {
										messages.add("E035","COATの着丈修正");
										coatFlag = true;
									}
								}
								// ウエスト修正
								if("02".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corCtWaistlengthSize);
									BigDecimal addMax = adjusteMax.add(corCtWaistlengthSize);
									if(corCtWaistGross.compareTo(addMin) == -1 || corCtWaistGross.compareTo(addMax) == 1) {
										messages.add("E035","COATのウエスト修正");
										coatFlag = true;
									}
								}
								// 袖丈右修正
								if("03".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corCtRightlengthsleeveSize);
									BigDecimal addMax = adjusteMax.add(corCtRightlengthsleeveSize);
									if(corCtRightsleeveGross.compareTo(addMin) == -1 || corCtRightsleeveGross.compareTo(addMax) == 1) {
										messages.add("E035","COATの袖丈右修正");
										coatFlag = true;
									}
								}
								// 袖丈左修正
								if("04".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corCtLeftlengthsleeveSize);
									BigDecimal addMax = adjusteMax.add(corCtLeftlengthsleeveSize);
									if(corCtLeftsleeveGross.compareTo(addMin) == -1 || corCtLeftsleeveGross.compareTo(addMax) == 1) {
										messages.add("E035","COATの袖丈左修正");
										coatFlag = true;
									}
								}
								// ベント修正（高さ）
								if("17".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corCtVenthightlengthSize);
									BigDecimal addMax = adjusteMax.add(corCtVenthightlengthSize);
									if(corCtVenthightGross.compareTo(addMin) == -1 || corCtVenthightGross.compareTo(addMax) == 1) {
										messages.add("E035","COATのベント修正（高さ）");
										coatFlag = true;
									}
								}
								// ポケット位置
								if("18".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corCtPktposlengthSize);
									BigDecimal addMax = adjusteMax.add(corCtPktposlengthSize);
									if(corCtPktposGross.compareTo(addMin) == -1 || corCtPktposGross.compareTo(addMax) == 1) {
										messages.add("E035","COATのポケット位置");
										coatFlag = true;
									}
								}
							}
						}
					}
				}	
			}
		}
		return coatFlag;
	}

	/**
	 * COATの補正標準値
	 * @param coJkTypeSizeOptimization
	 * @return
	 */
	public Map<String, String> getCtStandardValue(List<TypeSizeOptimization> coCtTypeSizeOptimization) {
		Map<String,String> adjustCtStandardValue = new HashMap<String,String>();
		for(TypeSizeOptimization typeSizeOptimization : coCtTypeSizeOptimization) {
			// 着丈修正
			if("01".equals(typeSizeOptimization.getAdjustClass())) {
				String corCtBodylengthSize = typeSizeOptimization.getTypeSize();
				adjustCtStandardValue.put("corCtBodylengthSize", corCtBodylengthSize);
			}
			// ウエスト修正
			else if("02".equals(typeSizeOptimization.getAdjustClass())) {
				String corCtWaistSize = typeSizeOptimization.getTypeSize();
				adjustCtStandardValue.put("corCtWaistSize", corCtWaistSize);
			}
			// 袖丈右修正
			else if("03".equals(typeSizeOptimization.getAdjustClass())) {
				String corCtRightsleeveSize = typeSizeOptimization.getTypeSize();
				adjustCtStandardValue.put("corCtRightsleeveSize", corCtRightsleeveSize);
			}
			// 袖丈左修正
			else if("04".equals(typeSizeOptimization.getAdjustClass())) {
				String corCtLeftsleeveSize = typeSizeOptimization.getTypeSize();
				adjustCtStandardValue.put("corCtLeftsleeveSize", corCtLeftsleeveSize);
			}
			// ベント修正（高さ）
			else if("17".equals(typeSizeOptimization.getAdjustClass())) {
				String corCtVenthightSize = typeSizeOptimization.getTypeSize();
				adjustCtStandardValue.put("corCtVenthightSize", corCtVenthightSize);
			}
			// ポケット位置
			else if("18".equals(typeSizeOptimization.getAdjustClass())) {
				String corCtPktposSize = typeSizeOptimization.getTypeSize();
				adjustCtStandardValue.put("corCtPktposSize", corCtPktposSize);
			}
		}
		return adjustCtStandardValue;
	}

	public List<TypeSizeOptimization> getCoCtTypeSizeOptimization(OrderCoForm orderCoForm, TypeSizeService typeSizeService) {
		String orderPattern = orderCoForm.getOrderPattern();
		String subItemCode = "06";
		String modelCode = orderCoForm.getCoOptionCoatStandardInfo().getCoatModel();	
		String figure = null;
		String number = orderCoForm.getCoAdjustCoatStandardInfo().getCorCtSize();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coCtTypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return coCtTypeSizeOptimization;
	}

	public void coatDefaultValueFromDb(OrderCoForm orderCoForm, Order orderCt) {
		CoOptionCoatStandardInfo optionCoatStandardInfo = orderCoForm.getCoOptionCoatStandardInfo();
		optionCoatStandardInfo.setCoatModel(orderCt.getCtModelCd());
		optionCoatStandardInfo.setOcLapelDesign(orderCt.getCtLapelDesignCd());
		optionCoatStandardInfo.setOcWaistPkt(orderCt.getCtWaistPktCd());
		optionCoatStandardInfo.setOcChangePkt(orderCt.getCtChgPktCd());
		optionCoatStandardInfo.setOcSlantedPkt(orderCt.getCtSlantedPktCd());
		optionCoatStandardInfo.setOcVentSpec(orderCt.getCtVentCd());
		optionCoatStandardInfo.setOcFrontBtnCnt(orderCt.getCtFrtBtnCd());
		optionCoatStandardInfo.setOcCuffSpec(orderCt.getCtCuffCd());
		optionCoatStandardInfo.setOcSleeveBtnType(orderCt.getCtSleeveBtnCd());
		optionCoatStandardInfo.setOcBackBelt(orderCt.getCtBackBeltCd());
		optionCoatStandardInfo.setOcChainHange(orderCt.getCtCollarHangCd());
		optionCoatStandardInfo.setOcBodyBackMate(orderCt.getCtInnerBodyClothType());
		optionCoatStandardInfo.setOcBodyBackMateStkNo(orderCt.getCtInnerBodyClothCd());
		optionCoatStandardInfo.setOcCuffBackMate(orderCt.getCtInnerSleeveClothType());
		optionCoatStandardInfo.setOcCuffBackMateStkNo(orderCt.getCtInnerSleeveClothCd());
		optionCoatStandardInfo.setOcFrontBtnMate(orderCt.getCtBtnMaterialType());
		optionCoatStandardInfo.setOcFrontBtnMateStkNo(orderCt.getCtBtnMaterialCd());
		optionCoatStandardInfo.setOcSleeveSpec(orderCt.getCtSleeveTypeCd());
	}
	
	public void coatDefaultValue(OrderCoForm orderCoForm) {
		CoOptionCoatStandardInfo optionCoatStandardInfo = orderCoForm.getCoOptionCoatStandardInfo();
		optionCoatStandardInfo.setCoatModel("");
		optionCoatStandardInfo.setOcLapelDesign(OptionCodeKeys.CT_0000101);
		optionCoatStandardInfo.setOcWaistPkt(OptionCodeKeys.CT_0000201);
		optionCoatStandardInfo.setOcChangePkt(OptionCodeKeys.CT_0000301);
		optionCoatStandardInfo.setOcSlantedPkt(OptionCodeKeys.CT_0000401);
		optionCoatStandardInfo.setOcVentSpec(OptionCodeKeys.CT_0000501);
		optionCoatStandardInfo.setOcFrontBtnCnt(OptionCodeKeys.CT_0000601);
		optionCoatStandardInfo.setOcCuffSpec(OptionCodeKeys.CT_0000701);
		optionCoatStandardInfo.setOcSleeveBtnType(OptionCodeKeys.CT_0000801);
		optionCoatStandardInfo.setOcBackBelt(OptionCodeKeys.CT_0000901);
		optionCoatStandardInfo.setOcChainHange(OptionCodeKeys.CT_0001001);
		optionCoatStandardInfo.setOcBodyBackMate(OptionCodeKeys.CT_4000100);
		optionCoatStandardInfo.setOcBodyBackMateStkNo(null);
		optionCoatStandardInfo.setOcCuffBackMate(OptionCodeKeys.CT_5000100);
		optionCoatStandardInfo.setOcCuffBackMateStkNo(null);
		optionCoatStandardInfo.setOcFrontBtnMate(OptionCodeKeys.CT_6000100);
		optionCoatStandardInfo.setOcFrontBtnMateStkNo(null);
		optionCoatStandardInfo.setOcSleeveSpec(OptionCodeKeys.CT_0001401);
	}
	
	public void coatAdjustFromDb(OrderCoForm orderCoForm, Order order) {
		orderCoForm.getCoOptionCoatStandardInfo().setCoatModel(order.getCtModelCd());
		
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtSize(order.getCorCtSize());

		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtBodylengthSize(order.getCorCtBodylengthSize().toString());
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtBodylengthGross(order.getCorCtBodylengthGross().toString());
		orderCoForm.getCoAdjustCoatStandardInfo()
				.setCorCtBodylengthCorrect(order.getCorCtBodylengthCorrect().toString());

		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtWaistSize(order.getCorCtWaistSize().toString());
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtWaistGross(order.getCorCtWaistGross().toString());
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtWaistCorrect(order.getCorCtWaistCorrect().toString());

		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtRightsleeveSize(order.getCorCtRightsleeveSize().toString());
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtRightsleeveGross(order.getCorCtRightsleeveGross().toString());
		orderCoForm.getCoAdjustCoatStandardInfo()
				.setCorCtRightsleeveCorrect(order.getCorCtRightsleeveCorrect().toString());

		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtLeftsleeveSize(order.getCorCtLeftsleeveSize().toString());
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtLeftsleeveGross(order.getCorCtLeftsleeveGross().toString());
		orderCoForm.getCoAdjustCoatStandardInfo()
				.setCorCtLeftsleeveCorrect(order.getCorCtLeftsleeveCorrect().toString());

		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtVenthightSize(order.getCorCtVenthightSize().toString());
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtVenthightGross(order.getCorCtVenthightGross().toString());
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtVenthightCorrect(order.getCorCtVenthightCorrect().toString());

		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtPktposSize(order.getCorCtPktposSize().toString());
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtPktposGross(order.getCorCtPktposGross().toString());
		orderCoForm.getCoAdjustCoatStandardInfo().setCorCtPktposCorrect(order.getCorCtPktposCorrect().toString());
		
		orderCoForm.setCorStoreCorrectionMemoAgain(order.getCorStoreCorrectionMemo());
	}

	public Map<String, String> getOrderPriceForCoatProject(OrderCoForm orderCoForm, String code, Model model,
			String idValue, String thisVal, String thisValStkNo) {
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
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}else if("SingleChester".equals(coatModel) || "SoutienCollar".equals(coatModel)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
					
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionCoatStandardInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
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
		orderCoForm.setCtOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, Object> getOrderPriceForCoatModel(OrderCoForm orderCoForm, String code) {
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
					orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}else if("SingleChester".equals(coatModel) || "SoutienCollar".equals(coatModel)) {
					orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionCoatStandardInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
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
		            priceMap.put(valueFour, "￥" + CoContorllerPublicMethodUtil.formatPrice(valueOf));
		         }

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", optionPriceInt);
		orderCoForm.setCtOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}
}
