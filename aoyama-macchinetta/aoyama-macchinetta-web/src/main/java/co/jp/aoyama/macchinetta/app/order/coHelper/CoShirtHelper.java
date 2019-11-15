package co.jp.aoyama.macchinetta.app.order.coHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dozer.util.ReflectionUtils;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.common.BaseCheckUtil;
import co.jp.aoyama.macchinetta.app.common.CoContorllerPublicMethodUtil;
import co.jp.aoyama.macchinetta.app.common.CoTypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.OptionCodeKeys;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm;
import co.jp.aoyama.macchinetta.app.order.TypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustShirtStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionShirtStandardInfo;
import co.jp.aoyama.macchinetta.app.order.enums.shirt.ShirtCoOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Model;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.ModelService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;

public class CoShirtHelper {

	CoTypeSizeOptimization coTypeSizeOptimization = new CoTypeSizeOptimization();
	
	/**
	 * モデル選択の設定
	 * @param orderCoForm
	 * @param modelList
	 */
	public void getShirtModelMap(OrderCoForm orderCoForm, List<Model> modelList) {
		LinkedHashMap<String, String> modelMap = new LinkedHashMap<String, String>();
		for (Model model : modelList) {
			modelMap.put("", "モデル選択");
			modelMap.put(model.getModelCode(), model.getModelName());
		}
		orderCoForm.getCoOptionShirtStandardInfo().setOsShirtModelMap(modelMap);

	}

	/**
	 * SHIRTの入力チェック
	 * @param orderCoForm
	 * @param messages
	 * @param coStTypeSizeOptimization 
	 * @param stAdjustList 
	 * @return
	 */
	public boolean shirtCheck(OrderCoForm orderCoForm, ResultMessages messages, List<Adjust> stAdjustList, List<TypeSizeOptimization> coStTypeSizeOptimization) {
		
		boolean shirtFlag = false;
		
		//「刺繍入れ」が「有り」、かつ、「刺繍箇所」が「無し」の場合
		String productEmbroideryNecessity = orderCoForm.getProductEmbroideryNecessity();
		String productEmbroideryNmPos = orderCoForm.getProductEmbroideryNmPos();
		if ("9000502".equals(productEmbroideryNecessity)  && "0002201".equals(productEmbroideryNmPos)) {
	        messages.add("E031", "刺繍箇所");
	        shirtFlag = true;
		}

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
		
		if ("0002102".equals(osBtnPosChg) && (BigDecimal.ZERO.equals(stNeckbandBtnPosChg) || null == stNeckbandBtnPosChg)
				&& (BigDecimal.ZERO.equals(stFrtfirstBtnPosChg) || null == stFrtfirstBtnPosChg)
				&& (BigDecimal.ZERO.equals(stFrtsecondBtnPosChg) || null == stFrtsecondBtnPosChg)) {
			messages.add("E029", "ボタン位置変更値");
	        shirtFlag = true;
		}
		
		//カジュアルヘムライン値未選択の場合
		String osCasHemLine = orderCoForm.getCoOptionShirtStandardInfo().getOsCasHemLine();
		BigDecimal stCasualHemlineSize = orderCoForm.getCoOptionShirtStandardInfo().getStCasualHemlineSize();
		if ("0002002".equals(osCasHemLine) && ((BigDecimal.ZERO).equals(stCasualHemlineSize) || null == stCasualHemlineSize || (new BigDecimal("0.0")).equals(stCasualHemlineSize) )) {
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
			}else {
				if(corStSize != null) {
					String corStNeckSize = coAdjustShirtStandardInfo.getCorStNeckSize();
					if("".equals(corStNeckSize)||"0".equals(corStNeckSize)||corStNeckSize==null) {
						messages.add("E034", "SHIRTのネック修正");
						shirtFlag = true;
					}
					
					String corStBodylengthSize = coAdjustShirtStandardInfo.getCorStBodylengthSize();
					if("".equals(corStBodylengthSize)||"0".equals(corStBodylengthSize)||corStBodylengthSize==null) {
						messages.add("E034", "SHIRTの着丈修正");
						shirtFlag = true;
					}
					
					String corStRightsleeveSize = coAdjustShirtStandardInfo.getCorStRightsleeveSize();
					if("".equals(corStRightsleeveSize)||"0".equals(corStRightsleeveSize)||corStRightsleeveSize==null) {
						messages.add("E034", "SHIRTの袖丈右修正");
						shirtFlag = true;
					}
					
					String corStLeftsleeveSize = coAdjustShirtStandardInfo.getCorStLeftsleeveSize();
					if("".equals(corStLeftsleeveSize)||"0".equals(corStLeftsleeveSize)||corStLeftsleeveSize==null) {
						messages.add("E034", "SHIRTの袖丈左修正");
						shirtFlag = true;
					}
					
					String corStRightcuffsSurroundingSize = coAdjustShirtStandardInfo.getCorStRightcuffsSurroundingSize();
					if("".equals(corStRightcuffsSurroundingSize)||"0".equals(corStRightcuffsSurroundingSize)||corStRightcuffsSurroundingSize==null) {
						messages.add("E034", "SHIRTのカフス周り右修正");
						shirtFlag = true;
					}
					
					String corStLeftcuffsSurroundingSize = coAdjustShirtStandardInfo.getCorStLeftcuffsSurroundingSize();
					if("".equals(corStLeftcuffsSurroundingSize)||"0".equals(corStLeftcuffsSurroundingSize)||corStLeftcuffsSurroundingSize==null) {
						messages.add("E034", "SHIRTのカフス周り左修正");
						shirtFlag = true;
					}	
				}
				if(!stAdjustList.isEmpty()&&!coStTypeSizeOptimization.isEmpty()) {
					// SHIRT_カジュアルヘムライン仕様_コード
					String stCasualHemlineCd = orderCoForm.getCoOptionShirtStandardInfo().getOsCasHemLine();
					// SHIRTS_ネック_グロス
					BigDecimal corStNeckGross = new BigDecimal(coAdjustShirtStandardInfo.getCorStNeckGross());
					// SHIRTS_着丈_グロス
					BigDecimal corStBodylengthGross = new BigDecimal(coAdjustShirtStandardInfo.getCorStBodylengthGross());
					
					// SHIRTS_袖丈右_グロス
					BigDecimal corStRightsleeveGross = new BigDecimal(coAdjustShirtStandardInfo.getCorStRightsleeveGross());
					
					// SHIRTS_袖丈左_グロス
					BigDecimal corStLeftsleeveGross = new BigDecimal(coAdjustShirtStandardInfo.getCorStLeftsleeveGross());
					
					// SHIRTS_カフス周り右_グロス
					BigDecimal corStRightcuffsSurroundingGross = new BigDecimal(coAdjustShirtStandardInfo.getCorStRightcuffsSurroundingGross());
					
					// SHIRTS_カフス周り左_グロス
					BigDecimal corStLeftcuffsSurroundingGross = new BigDecimal(coAdjustShirtStandardInfo.getCorStLeftcuffsSurroundingGross());
				
					Map<String, String> stStandardValue = this.getStStandardValue(coStTypeSizeOptimization);
					
					// SHIRTS_ネック_型サイズ
					String stringCorStNeckSize = stStandardValue.get("corStNeckSize");
					BigDecimal corStNeckSize = new BigDecimal(stringCorStNeckSize);
					
					// SHIRTS_着丈_型サイズ
					String stringCorStBodylengthSize = stStandardValue.get("corStBodylengthSize");
					BigDecimal corStBodylengthSize = new BigDecimal(stringCorStBodylengthSize);
					
					// SHIRTS_袖丈右_型サイズ
					String stringCorStRightsleeveSize = stStandardValue.get("corStRightsleeveSize");
					BigDecimal corStRightsleeveSize = new BigDecimal(stringCorStRightsleeveSize);
					
					// SHIRTS_袖丈左_型サイズ
					String stringCorStLeftsleeveSize = stStandardValue.get("corStLeftsleeveSize");
					BigDecimal corStLeftsleeveSize = new BigDecimal(stringCorStLeftsleeveSize);
					
					// SHIRTS_カフス周り右_型サイズ
					String stringCorStRightcuffsSurroundingSize = stStandardValue.get("corStRightcuffsSurroundingSize");
					BigDecimal corStRightcuffsSurroundingSize = new BigDecimal(stringCorStRightcuffsSurroundingSize);
					
					// SHIRTS_カフス周り左_型サイズ
					String stringCorStLeftcuffsSurroundingSize = stStandardValue.get("corStLeftcuffsSurroundingSize");
					BigDecimal corStLeftcuffsSurroundingSize = new BigDecimal(stringCorStLeftcuffsSurroundingSize);
					
					for(Adjust adjust:stAdjustList) {
						if("05".equals(adjust.getItemCode())) {
							if("05".equals(adjust.getSubItemCode())) {
								// ネック
								if("11".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corStNeckSize);
									BigDecimal addMax = adjusteMax.add(corStNeckSize);
									if(corStNeckGross.compareTo(addMin) == -1 || corStNeckGross.compareTo(addMax) == 1) {
										messages.add("E035","GILETのネック");
										 shirtFlag = true;
									}
								}
								if(!"0002002".equals(stCasualHemlineCd)) {
									// 着丈修正
									if("01".equals(adjust.getAdjusteClass())) {
										BigDecimal adjusteMax = adjust.getAdjusteMax();
										BigDecimal adjusteMin = adjust.getAdjusteMin();
										BigDecimal addMin = adjusteMin.add(corStBodylengthSize);
										BigDecimal addMax = adjusteMax.add(corStBodylengthSize);
										if(corStBodylengthGross.compareTo(addMin) == -1 || corStBodylengthGross.compareTo(addMax) == 1) {
											messages.add("E035","GILETの着丈修正");
											shirtFlag = true;
										}
									}
								}
								// 袖丈右修正
								if("03".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corStRightsleeveSize);
									BigDecimal addMax = adjusteMax.add(corStRightsleeveSize);
									if(corStRightsleeveGross.compareTo(addMin) == -1 || corStRightsleeveGross.compareTo(addMax) == 1) {
										messages.add("E035","GILETの袖丈右修正");
										shirtFlag = true;
									}
								}
								// 袖丈左修正
								if("04".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corStLeftsleeveSize);
									BigDecimal addMax = adjusteMax.add(corStLeftsleeveSize);
									if(corStLeftsleeveGross.compareTo(addMin) == -1 || corStLeftsleeveGross.compareTo(addMax) == 1) {
										messages.add("E035","GILETの袖丈左修正");
										shirtFlag = true;
									}
								}
								// カフス周り右
								if("12".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corStRightcuffsSurroundingSize);
									BigDecimal addMax = adjusteMax.add(corStRightcuffsSurroundingSize);
									if(corStRightcuffsSurroundingGross.compareTo(addMin) == -1 || corStRightcuffsSurroundingGross.compareTo(addMax) == 1) {
										messages.add("E035","GILETのカフス周り右");
										shirtFlag = true;
									}
								}
								// カフス周り左
								if("13".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corStLeftcuffsSurroundingSize);
									BigDecimal addMax = adjusteMax.add(corStLeftcuffsSurroundingSize);
									if(corStLeftcuffsSurroundingGross.compareTo(addMin) == -1 || corStLeftcuffsSurroundingGross.compareTo(addMax) == 1) {
										messages.add("E035","GILETのカフス周り左");
										shirtFlag = true;
									}
								}
							}
						}
					}
				}
			}	
		}
		return shirtFlag;
	}
	
	/**
	 * SHIRTの補正標準値
	 * @param coJkTypeSizeOptimization
	 * @return
	 */
	public Map<String, String> getStStandardValue(List<TypeSizeOptimization> coStTypeSizeOptimization) {
		Map<String,String> adjustStStandardValue = new HashMap<String,String>();
		for(TypeSizeOptimization typeSizeOptimization : coStTypeSizeOptimization) {
			// ネック
			if("11".equals(typeSizeOptimization.getAdjustClass())) {
				String corStNeckSize = typeSizeOptimization.getTypeSize();
				adjustStStandardValue.put("corStNeckSize", corStNeckSize);
			}
			// 着丈修正
			else if("01".equals(typeSizeOptimization.getAdjustClass())) {
				String corStBodylengthSize = typeSizeOptimization.getTypeSize();
				adjustStStandardValue.put("corStBodylengthSize", corStBodylengthSize);
			}
			// 袖丈右修正
			else if("03".equals(typeSizeOptimization.getAdjustClass())) {
				String corStRightsleeveSize = typeSizeOptimization.getTypeSize();
				adjustStStandardValue.put("corStRightsleeveSize", corStRightsleeveSize);
			}
			// 袖丈左修正
			else if("04".equals(typeSizeOptimization.getAdjustClass())) {
				String corStLeftsleeveSize = typeSizeOptimization.getTypeSize();
				adjustStStandardValue.put("corStLeftsleeveSize", corStLeftsleeveSize);
			}
			// カフス周り右
			else if("12".equals(typeSizeOptimization.getAdjustClass())) {
				String corStRightcuffsSurroundingSize = typeSizeOptimization.getTypeSize();
				adjustStStandardValue.put("corStRightcuffsSurroundingSize", corStRightcuffsSurroundingSize);
			}
			// カフス周り左
			else if("13".equals(typeSizeOptimization.getAdjustClass())) {
				String corStLeftcuffsSurroundingSize = typeSizeOptimization.getTypeSize();
				adjustStStandardValue.put("corStLeftcuffsSurroundingSize", corStLeftcuffsSurroundingSize);
			}
		}
		return adjustStStandardValue;
	}
	
	/**
	 *SHIRTの標準値取得
	 * @param orderCoForm
	 * @return
	 */
	public List<TypeSizeOptimization> getCoStTypeSizeOptimization(OrderCoForm orderCoForm, TypeSizeService typeSizeService) {
		String orderPattern = orderCoForm.getOrderPattern();
		String subItemCode = "05";
		String modelCode = orderCoForm.getCoOptionShirtStandardInfo().getOsShirtModel();	
		String figure = null;
		String number = orderCoForm.getCoAdjustShirtStandardInfo().getCorStSize();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coStTypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return coStTypeSizeOptimization;
	}
	
	public void shirtDefaultValueFromDb(CoOptionShirtStandardInfo coOptionShirtStandardInfo, Order orderSt) {
		
		// SHIRTモデル
		coOptionShirtStandardInfo.setOsShirtModel(orderSt.getStModelCd());
		// 襟型
		coOptionShirtStandardInfo.setOsChainModel(orderSt.getStCollarTypeCd());
		// カフス
		coOptionShirtStandardInfo.setOsCuffs(orderSt.getStCuffsCd());
		// コンバーチブル
		coOptionShirtStandardInfo.setOsConvertible(orderSt.getStConvertibleCd());
		// アジャスト釦
		coOptionShirtStandardInfo.setOsAdjustBtn(orderSt.getStAdjusterBtnCd());
		// クレリック仕様
		coOptionShirtStandardInfo.setOsClericSpec(orderSt.getStClericCd());
		// ダブルカフス仕様
		coOptionShirtStandardInfo.setOsDblCuff(orderSt.getStDblCuffsCd());
		//カフスボタン追加
		coOptionShirtStandardInfo.setOsAddCuff(orderSt.getStCuffsBtnCd());
		// 釦素材
		coOptionShirtStandardInfo.setOsBtnMate(orderSt.getStBtnMaterialCd());
		//タブ釦
		coOptionShirtStandardInfo.setOsTabBtn(orderSt.getStDblBtnCd());
		// ガントレットボタン位置
		coOptionShirtStandardInfo.setOsGaletteBtnPos(orderSt.getStGauntletBtnPosCd());
		// ピンホールピン
		coOptionShirtStandardInfo.setOsPinHolePin(orderSt.getStPinholePinCd());
		// 胸ポケット
		coOptionShirtStandardInfo.setOsBreastPk(orderSt.getStBreastPktCd());
		//胸ポケット大きさ
		if ("0001202".equals(orderSt.getStBreastPktCd())) {
			coOptionShirtStandardInfo.setOsBreastPkSize("0001301");
		} else {
			coOptionShirtStandardInfo.setOsBreastPkSize(orderSt.getStBreastSizeCd());
		}
		// フロントデザイン
		coOptionShirtStandardInfo.setOsFrontDesign(orderSt.getStFrtDesignCd());
		// ピンタックブザム
		coOptionShirtStandardInfo.setOsPinTack(orderSt.getStPintuckBosomCd());
		// ステッチ
		coOptionShirtStandardInfo.setOsStitch(orderSt.getStStitchCd());
		// カラーキーパー
		coOptionShirtStandardInfo.setOsColorKeeper(orderSt.getStColarKeeperCd());
		// ボタン付け糸色変更
		coOptionShirtStandardInfo.setOsByColor(orderSt.getStBtnthreadColorCd());
		// ボタンホール色変更
		coOptionShirtStandardInfo.setOsBhColor(orderSt.getStBtnholeColorCd());
		//カジュアルヘムライン仕様
		coOptionShirtStandardInfo.setOsCasHemLine(orderSt.getStCasualHemlineCd());
		//カジュアルヘムライン仕様_サイズ
		coOptionShirtStandardInfo.setStCasualHemlineSize(orderSt.getStCasualHemlineSize());
		//ボタン位置変更
		coOptionShirtStandardInfo.setOsBtnPosChg(orderSt.getStBtnposChgCd());
		// ボタン位置変更 台襟釦
		coOptionShirtStandardInfo.setOsBtnPosChgCollar(orderSt.getStNeckbandBtnChgCd());
		// ボタン位置変更 フロント第1釦
		coOptionShirtStandardInfo.setOsBtnPosChgFront1(orderSt.getStFrtfirstBtnChgCd());
		// ボタン位置変更 フロント第2釦
		coOptionShirtStandardInfo.setOsBtnPosChgFront2(orderSt.getStFrtsecondBtnChgCd());
		
		// ボタン位置変更 台襟釦値
		coOptionShirtStandardInfo.setStNeckbandBtnPosChg(orderSt.getStNeckbandBtnPosChg());
		// ボタン位置変更 フロント第1釦値
		coOptionShirtStandardInfo.setStFrtfirstBtnPosChg(orderSt.getStFrtfirstBtnPosChg());
		// ボタン位置変更 フロント第2釦値
		coOptionShirtStandardInfo.setStFrtsecondBtnPosChg(orderSt.getStFrtsecondBtnPosChg());
	}
	
	public void shirtDefaultValue(OrderCoForm orderCoForm) {
		// 標準
		CoOptionShirtStandardInfo optionShirtStandardInfo = orderCoForm.getCoOptionShirtStandardInfo();
		optionShirtStandardInfo.setOsShirtModel("");
		//襟型は選択（デフォルト）(0000100)
		optionShirtStandardInfo.setOsChainModel(OptionCodeKeys.sht_0000100);
		optionShirtStandardInfo.setOsCuffs(OptionCodeKeys.sht_0000200);
		optionShirtStandardInfo.setOsConvertible(OptionCodeKeys.sht_0000301);
		optionShirtStandardInfo.setOsAdjustBtn(OptionCodeKeys.sht_0000401);
		optionShirtStandardInfo.setOsClericSpec(OptionCodeKeys.sht_0000501);
		optionShirtStandardInfo.setOsDblCuff(OptionCodeKeys.sht_0000601);
		optionShirtStandardInfo.setOsAddCuff(OptionCodeKeys.sht_0000701);
		optionShirtStandardInfo.setOsBtnMate(OptionCodeKeys.sht_0000801);
		//襟型「タブカラー(0000111)・ラウンドタブカラ-(0000112)」以外の場合、タブ釦は「無し」固定。
		optionShirtStandardInfo.setOsTabBtn(OptionCodeKeys.sht_0000903);
		optionShirtStandardInfo.setOsGaletteBtnPos(OptionCodeKeys.sht_0001001);
		optionShirtStandardInfo.setOsPinHolePin(OptionCodeKeys.sht_0001101);
		optionShirtStandardInfo.setOsBreastPk(OptionCodeKeys.sht_0001201);
		optionShirtStandardInfo.setOsBreastPkSize(OptionCodeKeys.sht_0001301);
		optionShirtStandardInfo.setOsFrontDesign(OptionCodeKeys.sht_0001401);
		optionShirtStandardInfo.setOsPinTack(OptionCodeKeys.sht_0001501);
		optionShirtStandardInfo.setOsStitch(OptionCodeKeys.sht_0001601);
		optionShirtStandardInfo.setOsColorKeeper(OptionCodeKeys.sht_0001701);
		optionShirtStandardInfo.setOsBhColor(OptionCodeKeys.sht_0001901);
		optionShirtStandardInfo.setOsByColor(OptionCodeKeys.sht_0001801);
		optionShirtStandardInfo.setOsCasHemLine(OptionCodeKeys.sht_0002001);
		optionShirtStandardInfo.setOsBtnPosChg(OptionCodeKeys.sht_0002101);

	}
	
	public void shirtAdjustFromDb(OrderCoForm orderCoForm, Order order) {
		
		//orderCoForm.getCoOptionShirtStandardInfo().setOsShirtModel(order.getStModelCd());
		//orderCoForm.getCoOptionShirtStandardInfo().setOsCasHemLine(order.getStCasualHemlineCd());
		
		orderCoForm.getCoAdjustShirtStandardInfo().setCorStSize(order.getCorStSize());

		orderCoForm.getCoAdjustShirtStandardInfo().setCorStNeckSize(order.getCorStNeckSize().toString());
		orderCoForm.getCoAdjustShirtStandardInfo().setCorStNeckGross(order.getCorStNeckGross().toString());
		orderCoForm.getCoAdjustShirtStandardInfo().setCorStNeckCorrect(order.getCorStNeckCorrect().toString());

		orderCoForm.getCoAdjustShirtStandardInfo().setCorStBodylengthSize(order.getCorStBodylengthSize().toString());
		orderCoForm.getCoAdjustShirtStandardInfo().setCorStBodylengthGross(order.getCorStBodylengthGross().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStBodylengthCorrect(order.getCorStBodylengthCorrect().toString());

		orderCoForm.getCoAdjustShirtStandardInfo().setCorStRightsleeveSize(order.getCorStRightsleeveSize().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStRightsleeveGross(order.getCorStRightsleeveGross().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStRightsleeveCorrect(order.getCorStRightsleeveCorrect().toString());

		orderCoForm.getCoAdjustShirtStandardInfo().setCorStLeftsleeveSize(order.getCorStLeftsleeveSize().toString());
		orderCoForm.getCoAdjustShirtStandardInfo().setCorStLeftsleeveGross(order.getCorStLeftsleeveGross().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStLeftsleeveCorrect(order.getCorStLeftsleeveCorrect().toString());

//		orderCoForm.getCoAdjustShirtStandardInfo()
//				.setCorStBackdartsPackSize(order.getCorStBackdartsPackSize().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStBackdartsPackGross(order.getCorStBackdartsPackGross().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStBackdartsPackCorrect(order.getCorStBackdartsPackCorrect().toString());

//		orderCoForm.getCoAdjustShirtStandardInfo()
//				.setCorStBackdartsUnpackSize(order.getCorStBackdartsUnpackSize().toString());
//		orderCoForm.getCoAdjustShirtStandardInfo()
//				.setCorStBackdartsUnpackGross(order.getCorStBackdartsUnpackGross().toString());
//		orderCoForm.getCoAdjustShirtStandardInfo()
//				.setCorStBackdartsUnpackCorrect(order.getCorStBackdartsUnpackCorrect().toString());

		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStRightcuffsSurroundingSize(order.getCorStRightcuffsSurroundingSize().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStRightcuffsSurroundingGross(order.getCorStRightcuffsSurroundingGross().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStRightcuffsSurroundingCorrect(order.getCorStRightcuffsSurroundingCorrect().toString());

		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStLeftcuffsSurroundingSize(order.getCorStLeftcuffsSurroundingSize().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStLeftcuffsSurroundingGross(order.getCorStLeftcuffsSurroundingGross().toString());
		orderCoForm.getCoAdjustShirtStandardInfo()
				.setCorStLeftcuffsSurroundingCorrect(order.getCorStLeftcuffsSurroundingCorrect().toString());
		orderCoForm.getCoAdjustShirtStandardInfo().setCorStBackdartsUnpackCd(order.getCorStBackdartsUnpackCd());
		
		//orderCoForm.setCorStoreCorrectionMemoAgain(order.getCorStoreCorrectionMemo());
		
	}

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
			String orderPrice = "";
			try {
				Method methodOne = optionShirtStandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(optionShirtStandardInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = optionShirtStandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(optionShirtStandardInfo);
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne + invokeTwo;
				
				String breastPk = orderCoForm.getCoOptionShirtStandardInfo().getOsBreastPk();
				if(("00013".equals(key) && "0001202".equals(breastPk))) {
					orderPrice = "0";
				} else {
					orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
				}
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionShirtStandardInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
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
					priceMap.put(valueFour, "￥" + CoContorllerPublicMethodUtil.formatPrice(valueOf));
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("priceMap", priceMap);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setStOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForShirtProject(OrderCoForm orderCoForm, String code,
			org.springframework.ui.Model model, String idValueName, String valueBreastPk, String thisVal) {

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
					if(("00013".equals(key) && "0001202".equals(valueBreastPk))) {
						orderPrice = "0";
					} else {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionShirtStandardInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
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
				if(!("0".equals(valueOf) || "null".equals(valueOf)) && BaseCheckUtil.isNotEmpty(valueOf)) {
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
			orderPrice = "￥" + CoContorllerPublicMethodUtil.formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setStOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public void optionShirtDbToOrder(String productItem, Order order, OrderCoForm orderCoForm, OrderListService orderListService, ModelService modelService, OrderService orderService) {
		//SHIRTのオプション情報を取得
		Order orderSt = orderListService.findOrderStOptionByOrderId(order.getOrderId());
		
		//初期化設定
		CoOptionShirtStandardInfo coOptionShirtStandardInfo = orderCoForm.getCoOptionShirtStandardInfo();
		//オプション情報が存在する場合、レコード値を設定
		if(orderSt !=null ) {
			this.shirtDefaultValueFromDb(coOptionShirtStandardInfo, orderSt);
		//オプション情報が存在しない場合、初期値を設定
		}else {
			this.shirtDefaultValue(orderCoForm);
		}
		
		//SHIRTの補正情報を取得
		Order orderStAd = orderListService.findOrderStByPk(order.getOrderId());
		
		//初期化設定
		CoAdjustShirtStandardInfo coAdjustShirtStandardInfo = orderCoForm.getCoAdjustShirtStandardInfo();
		if(coAdjustShirtStandardInfo == null ) {
			coAdjustShirtStandardInfo = new CoAdjustShirtStandardInfo();
			orderCoForm.setCoAdjustShirtStandardInfo(coAdjustShirtStandardInfo);
		}
		if (orderStAd != null) {
			this.shirtAdjustFromDb(orderCoForm, orderStAd);
		}
		
		String osShirtModel = coOptionShirtStandardInfo.getOsShirtModel();
		if(osShirtModel!=null&&!"".equals(osShirtModel)) {
			String code = productItem.concat("05").concat(osShirtModel);
			this.getOrderPriceForShirtModel(orderCoForm, code);
		}else {
			orderCoForm.setStOptionPrice("0");
		}
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getItemModel(order.getOrderPattern(), productItem,
				"05");
		this.getShirtModelMap(orderCoForm, modelList);
	}
}
