package co.jp.aoyama.macchinetta.app.order.coHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm;
import co.jp.aoyama.macchinetta.app.order.OrderCoHelper;
import co.jp.aoyama.macchinetta.app.order.TypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustCoatStandardInfo;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;

public class CoCoatHelper {
	
	@Inject
	TypeSizeService typeSizeService;
	
	OrderCoHelper orderCoHelper = new OrderCoHelper();
	
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
				String corCtPktposSize = typeSizeOptimization.getTypeSize();
				adjustCtStandardValue.put("corCtPktposSize", corCtPktposSize);
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
		List<TypeSizeOptimization> coCtTypeSizeOptimization = this.getCoTypeSizeOptimization(coTypeSizeList);
		return coCtTypeSizeOptimization;
	}

	public List<TypeSizeOptimization> getCoTypeSizeOptimization(List<TypeSize> coTypeSizeList) {
		List<TypeSizeOptimization> typeSizeList = new ArrayList<TypeSizeOptimization>();
		for (TypeSize typeSize : coTypeSizeList) {
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

}
