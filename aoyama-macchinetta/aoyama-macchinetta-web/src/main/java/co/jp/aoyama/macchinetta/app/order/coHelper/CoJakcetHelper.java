package co.jp.aoyama.macchinetta.app.order.coHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dozer.util.ReflectionUtils;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.common.BaseCheckUtil;
import co.jp.aoyama.macchinetta.app.common.CoContorllerPublicMethodUtil;
import co.jp.aoyama.macchinetta.app.common.CoTypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.OptionCodeKeys;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm;
import co.jp.aoyama.macchinetta.app.order.TypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketWashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionCoStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionCoTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionCoWashablePriceEnum;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Model;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.ModelService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;

public class CoJakcetHelper {
	CoPants1Helper coPants1Helper = new CoPants1Helper();
	CoGiletHelper coGiletHelper = new CoGiletHelper();
	CoPants2Helper coPants2Helper = new CoPants2Helper();
	@Inject
	TypeSizeService typeSizeService;
	
	CoTypeSizeOptimization coTypeSizeOptimization = new CoTypeSizeOptimization();
	
	public void getJacketModelMap(OrderCoForm orderCoForm, List<Model> modelList) {
		LinkedHashMap<String, String> modelMap = new LinkedHashMap<String, String>();
		for (Model model : modelList) {
			modelMap.put("", "モデル選択");
			modelMap.put(model.getModelCode(), model.getModelName());
		}
		orderCoForm.getCoOptionJacketStandardInfo().setOjJacketModelMap(modelMap);
		orderCoForm.getCoOptionJacketTuxedoInfo().setTjJacketModelMap(modelMap);
		orderCoForm.getCoOptionJacketWashableInfo().setWjJacketModelMap(modelMap);
	}
	
	public boolean jacketCheck(ResultMessages messages ,OrderCoForm orderCoForm, String productCategory, String item, Map<String, List<Adjust>> adjustByItem, TypeSizeService typeSizeService) {
		boolean jacketFlag = false;
		//標準の場合
		if("9000101".equals(productCategory)) {
			//JACKET モデル未選択の場合
			CoOptionJacketStandardInfo coOptionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
			String ojJacketModel = coOptionJacketStandardInfo.getOjJacketModel();
			if("".equals(ojJacketModel)  ||  null == ojJacketModel) {
				 messages.add("E031", "JACKET モデル");
				 jacketFlag = true;
			}
			//内ポケット変更
			String ojInsidePktChange = coOptionJacketStandardInfo.getOjInsidePktChange();
			if(OptionCodeKeys.JK_0002002.equals(ojInsidePktChange)) {
				String ojInsidePktPlace1 = coOptionJacketStandardInfo.getOjInsidePktPlace1();
				String ojInsidePktPlace2 = coOptionJacketStandardInfo.getOjInsidePktPlace2();
				String ojInsidePktPlace3 = coOptionJacketStandardInfo.getOjInsidePktPlace3();
				String ojInsidePktPlace4 = coOptionJacketStandardInfo.getOjInsidePktPlace4();
				if (BaseCheckUtil.isEmpty(ojInsidePktPlace1) && BaseCheckUtil.isEmpty(ojInsidePktPlace2)
						&& BaseCheckUtil.isEmpty(ojInsidePktPlace3) && BaseCheckUtil.isEmpty(ojInsidePktPlace4)) {
					messages.add("E033", "JACKET 内ポケット変更");
					jacketFlag = true;
				}
			}
			
			//ステッチ箇所変更
			String ojStitchModify = coOptionJacketStandardInfo.getOjStitchModify();
			if(OptionCodeKeys.JK_0002402.equals(ojStitchModify)) {
				String ojStitchModifyPlace1 = coOptionJacketStandardInfo.getOjStitchModifyPlace1();
				String ojStitchModifyPlace2 = coOptionJacketStandardInfo.getOjStitchModifyPlace2();
				String ojStitchModifyPlace3 = coOptionJacketStandardInfo.getOjStitchModifyPlace3();
				String ojStitchModifyPlace4 = coOptionJacketStandardInfo.getOjStitchModifyPlace4();
				String ojStitchModifyPlace5 = coOptionJacketStandardInfo.getOjStitchModifyPlace5();
				String ojStitchModifyPlace6 = coOptionJacketStandardInfo.getOjStitchModifyPlace6();
				String ojStitchModifyPlace7 = coOptionJacketStandardInfo.getOjStitchModifyPlace7();
				String ojStitchModifyPlace8 = coOptionJacketStandardInfo.getOjStitchModifyPlace8();
				String ojStitchModifyPlace9 = coOptionJacketStandardInfo.getOjStitchModifyPlace9();
				
				if (BaseCheckUtil.isEmpty(ojStitchModifyPlace1) && BaseCheckUtil.isEmpty(ojStitchModifyPlace2)
						&& BaseCheckUtil.isEmpty(ojStitchModifyPlace3) && BaseCheckUtil.isEmpty(ojStitchModifyPlace4)
						&& BaseCheckUtil.isEmpty(ojStitchModifyPlace5) && BaseCheckUtil.isEmpty(ojStitchModifyPlace6)
						&& BaseCheckUtil.isEmpty(ojStitchModifyPlace7) && BaseCheckUtil.isEmpty(ojStitchModifyPlace8)
						&& BaseCheckUtil.isEmpty(ojStitchModifyPlace9)) {
					messages.add("E033", "JACKET ステッチ箇所変更");
					jacketFlag = true;
				}
			}
			
			//ダブルステッチ変更
			String ojDStitchModify = coOptionJacketStandardInfo.getOjDStitchModify();
			if(OptionCodeKeys.JK_0002602.equals(ojDStitchModify)) {
				String ojDStitchModifyPlace1 = coOptionJacketStandardInfo.getOjDStitchModifyPlace1();
				String ojDStitchModifyPlace2 = coOptionJacketStandardInfo.getOjDStitchModifyPlace2();
				String ojDStitchModifyPlace3 = coOptionJacketStandardInfo.getOjDStitchModifyPlace3();
				String ojDStitchModifyPlace4 = coOptionJacketStandardInfo.getOjDStitchModifyPlace4();
				String ojDStitchModifyPlace5 = coOptionJacketStandardInfo.getOjDStitchModifyPlace5();
				String ojDStitchModifyPlace6 = coOptionJacketStandardInfo.getOjDStitchModifyPlace6();
				String ojDStitchModifyPlace7 = coOptionJacketStandardInfo.getOjDStitchModifyPlace7();
				String ojDStitchModifyPlace8 = coOptionJacketStandardInfo.getOjDStitchModifyPlace8();
				if (BaseCheckUtil.isEmpty(ojDStitchModifyPlace1) && BaseCheckUtil.isEmpty(ojDStitchModifyPlace2)
						&& BaseCheckUtil.isEmpty(ojDStitchModifyPlace3) && BaseCheckUtil.isEmpty(ojDStitchModifyPlace4)
						&& BaseCheckUtil.isEmpty(ojDStitchModifyPlace5) && BaseCheckUtil.isEmpty(ojDStitchModifyPlace6)
						&& BaseCheckUtil.isEmpty(ojDStitchModifyPlace7) && BaseCheckUtil.isEmpty(ojDStitchModifyPlace8)) {
					messages.add("E033", "JACKET ダブルステッチ変更");
					jacketFlag = true;
				}
			}
			
			//AMF色指定
			String ojAmfColor = coOptionJacketStandardInfo.getOjAmfColor();
			if(OptionCodeKeys.JK_0002802.equals(ojAmfColor)) {
				String ojAmfColorPlace1 = coOptionJacketStandardInfo.getOjAmfColorPlace1();
				String ojAmfColorPlace2 = coOptionJacketStandardInfo.getOjAmfColorPlace2();
				String ojAmfColorPlace3 = coOptionJacketStandardInfo.getOjAmfColorPlace3();
				String ojAmfColorPlace4 = coOptionJacketStandardInfo.getOjAmfColorPlace4();
				String ojAmfColorPlace5 = coOptionJacketStandardInfo.getOjAmfColorPlace5();
				String ojAmfColorPlace6 = coOptionJacketStandardInfo.getOjAmfColorPlace6();
				String ojAmfColorPlace7 = coOptionJacketStandardInfo.getOjAmfColorPlace7();
				String ojAmfColorPlace8 = coOptionJacketStandardInfo.getOjAmfColorPlace8();
				String ojAmfColorPlace9 = coOptionJacketStandardInfo.getOjAmfColorPlace9();
				
				String ojAmfColor1 = coOptionJacketStandardInfo.getOjAmfColor1();
				String ojAmfColor2 = coOptionJacketStandardInfo.getOjAmfColor2();
				String ojAmfColor3 = coOptionJacketStandardInfo.getOjAmfColor3();
				String ojAmfColor4 = coOptionJacketStandardInfo.getOjAmfColor4();
				String ojAmfColor5 = coOptionJacketStandardInfo.getOjAmfColor5();
				String ojAmfColor6 = coOptionJacketStandardInfo.getOjAmfColor6();
				String ojAmfColor7 = coOptionJacketStandardInfo.getOjAmfColor7();
				String ojAmfColor8 = coOptionJacketStandardInfo.getOjAmfColor8();
				String ojAmfColor9 = coOptionJacketStandardInfo.getOjAmfColor9();
				
				if(BaseCheckUtil.isEmpty(ojAmfColorPlace1)&&BaseCheckUtil.isEmpty(ojAmfColorPlace2)&&BaseCheckUtil.isEmpty(ojAmfColorPlace3)&&BaseCheckUtil.isEmpty(ojAmfColorPlace4)&&
				   BaseCheckUtil.isEmpty(ojAmfColorPlace5)&&BaseCheckUtil.isEmpty(ojAmfColorPlace6)&&BaseCheckUtil.isEmpty(ojAmfColorPlace7)&&BaseCheckUtil.isEmpty(ojAmfColorPlace8)&&BaseCheckUtil.isEmpty(ojAmfColorPlace9)) {
					messages.add("E032", "JACKET AMF色指定");
					jacketFlag = true;
				}
				
				if(BaseCheckUtil.isNotEmpty(ojAmfColorPlace1)&&BaseCheckUtil.isEmpty(ojAmfColor1)||BaseCheckUtil.isNotEmpty(ojAmfColorPlace2)&&BaseCheckUtil.isEmpty(ojAmfColor2)||
				   BaseCheckUtil.isNotEmpty(ojAmfColorPlace3)&&BaseCheckUtil.isEmpty(ojAmfColor3)||BaseCheckUtil.isNotEmpty(ojAmfColorPlace4)&&BaseCheckUtil.isEmpty(ojAmfColor4)||
				   BaseCheckUtil.isNotEmpty(ojAmfColorPlace5)&&BaseCheckUtil.isEmpty(ojAmfColor5)||BaseCheckUtil.isNotEmpty(ojAmfColorPlace6)&&BaseCheckUtil.isEmpty(ojAmfColor6)||
				   BaseCheckUtil.isNotEmpty(ojAmfColorPlace7)&&BaseCheckUtil.isEmpty(ojAmfColor7)||BaseCheckUtil.isNotEmpty(ojAmfColorPlace8)&&BaseCheckUtil.isEmpty(ojAmfColor8)||
				   BaseCheckUtil.isNotEmpty(ojAmfColorPlace9)&&BaseCheckUtil.isEmpty(ojAmfColor9)) {
					messages.add("E032", "JACKET AMF色指定");
					jacketFlag = true;
				}
				
				
			}
			//ボタンホール色指定
			String ojBhColor = coOptionJacketStandardInfo.getOjBhColor();
			if (OptionCodeKeys.JK_0003102.equals(ojBhColor)) {
				String ojBhColorPlace1 = coOptionJacketStandardInfo.getOjBhColorPlace1();
				String ojBhColorPlace2 = coOptionJacketStandardInfo.getOjBhColorPlace2();
				String ojBhColorPlace3 = coOptionJacketStandardInfo.getOjBhColorPlace3();
				String ojBhColorPlace4 = coOptionJacketStandardInfo.getOjBhColorPlace4();
				String ojBhColorPlace5 = coOptionJacketStandardInfo.getOjBhColorPlace5();
				String ojBhColorPlace6 = coOptionJacketStandardInfo.getOjBhColorPlace6();
				String ojBhColorPlace7 = coOptionJacketStandardInfo.getOjBhColorPlace7();
				String ojBhColorPlace8 = coOptionJacketStandardInfo.getOjBhColorPlace8();
				String ojBhColorPlace9 = coOptionJacketStandardInfo.getOjBhColorPlace9();
				String ojBhColorPlace10 = coOptionJacketStandardInfo.getOjBhColorPlace10();
				String ojBhColorPlace11 = coOptionJacketStandardInfo.getOjBhColorPlace11();
				String ojBhColorPlace12 = coOptionJacketStandardInfo.getOjBhColorPlace12();
				String ojBhColorPlace13 = coOptionJacketStandardInfo.getOjBhColorPlace13();
				String ojBhColorPlace14 = coOptionJacketStandardInfo.getOjBhColorPlace14();
				String ojBhColorPlace15 = coOptionJacketStandardInfo.getOjBhColorPlace15();
				String ojBhColorPlace16 = coOptionJacketStandardInfo.getOjBhColorPlace16();
				String ojBhColorPlace17 = coOptionJacketStandardInfo.getOjBhColorPlace17();
				
				String ojBhColor1 = coOptionJacketStandardInfo.getOjBhColor1();
				String ojBhColor2 = coOptionJacketStandardInfo.getOjBhColor2();
				String ojBhColor3 = coOptionJacketStandardInfo.getOjBhColor3();
				String ojBhColor4 = coOptionJacketStandardInfo.getOjBhColor4();
				String ojBhColor5 = coOptionJacketStandardInfo.getOjBhColor5();
				String ojBhColor6 = coOptionJacketStandardInfo.getOjBhColor6();
				String ojBhColor7 = coOptionJacketStandardInfo.getOjBhColor7();
				String ojBhColor8 = coOptionJacketStandardInfo.getOjBhColor8();
				String ojBhColor9 = coOptionJacketStandardInfo.getOjBhColor9();
				String ojBhColor10 = coOptionJacketStandardInfo.getOjBhColor10();
				String ojBhColor11 = coOptionJacketStandardInfo.getOjBhColor11();
				String ojBhColor12 = coOptionJacketStandardInfo.getOjBhColor12();
				String ojBhColor13 = coOptionJacketStandardInfo.getOjBhColor13();
				String ojBhColor14 = coOptionJacketStandardInfo.getOjBhColor14();
				String ojBhColor15 = coOptionJacketStandardInfo.getOjBhColor15();
				String ojBhColor16 = coOptionJacketStandardInfo.getOjBhColor16();
				String ojBhColor17 = coOptionJacketStandardInfo.getOjBhColor17();
				
				if (BaseCheckUtil.isEmpty(ojBhColorPlace1) && BaseCheckUtil.isEmpty(ojBhColorPlace2) && BaseCheckUtil.isEmpty(ojBhColorPlace3)
						&& BaseCheckUtil.isEmpty(ojBhColorPlace4) && BaseCheckUtil.isEmpty(ojBhColorPlace5) && BaseCheckUtil.isEmpty(ojBhColorPlace6)
						&& BaseCheckUtil.isEmpty(ojBhColorPlace7) && BaseCheckUtil.isEmpty(ojBhColorPlace8) && BaseCheckUtil.isEmpty(ojBhColorPlace9)
						&& BaseCheckUtil.isEmpty(ojBhColorPlace10)&& BaseCheckUtil.isEmpty(ojBhColorPlace11)&& BaseCheckUtil.isEmpty(ojBhColorPlace12)
						&& BaseCheckUtil.isEmpty(ojBhColorPlace13)&& BaseCheckUtil.isEmpty(ojBhColorPlace14)&& BaseCheckUtil.isEmpty(ojBhColorPlace15)
						&& BaseCheckUtil.isEmpty(ojBhColorPlace16)&& BaseCheckUtil.isEmpty(ojBhColorPlace17)) {
					messages.add("E032", "JACKET ボタンホール色指定");
					jacketFlag = true;
				}
				
				if(BaseCheckUtil.isNotEmpty(ojBhColorPlace1)&&BaseCheckUtil.isEmpty(ojBhColor1)||BaseCheckUtil.isNotEmpty(ojBhColorPlace2)&&BaseCheckUtil.isEmpty(ojBhColor2)||
				   BaseCheckUtil.isNotEmpty(ojBhColorPlace3)&&BaseCheckUtil.isEmpty(ojBhColor3)||BaseCheckUtil.isNotEmpty(ojBhColorPlace4)&&BaseCheckUtil.isEmpty(ojBhColor4)||
				   BaseCheckUtil.isNotEmpty(ojBhColorPlace5)&&BaseCheckUtil.isEmpty(ojBhColor5)||BaseCheckUtil.isNotEmpty(ojBhColorPlace6)&&BaseCheckUtil.isEmpty(ojBhColor6)||
				   BaseCheckUtil.isNotEmpty(ojBhColorPlace7)&&BaseCheckUtil.isEmpty(ojBhColor7)||BaseCheckUtil.isNotEmpty(ojBhColorPlace8)&&BaseCheckUtil.isEmpty(ojBhColor8)||
				   BaseCheckUtil.isNotEmpty(ojBhColorPlace9)&&BaseCheckUtil.isEmpty(ojBhColor9)||BaseCheckUtil.isNotEmpty(ojBhColorPlace10)&&BaseCheckUtil.isEmpty(ojBhColor10)||
				   BaseCheckUtil.isNotEmpty(ojBhColorPlace11)&&BaseCheckUtil.isEmpty(ojBhColor11)||BaseCheckUtil.isNotEmpty(ojBhColorPlace12)&&BaseCheckUtil.isEmpty(ojBhColor12)||
				   BaseCheckUtil.isNotEmpty(ojBhColorPlace13)&&BaseCheckUtil.isEmpty(ojBhColor13)||BaseCheckUtil.isNotEmpty(ojBhColorPlace14)&&BaseCheckUtil.isEmpty(ojBhColor14)||
				   BaseCheckUtil.isNotEmpty(ojBhColorPlace15)&&BaseCheckUtil.isEmpty(ojBhColor15)||BaseCheckUtil.isNotEmpty(ojBhColorPlace16)&&BaseCheckUtil.isEmpty(ojBhColor16)||
				   BaseCheckUtil.isNotEmpty(ojBhColorPlace17)&&BaseCheckUtil.isEmpty(ojBhColor17)) {
					messages.add("E032", "JACKET ボタンホール色指定");
					jacketFlag = true;
				}
			}
			
			//ボタン付け糸指定
			String ojByColor = coOptionJacketStandardInfo.getOjByColor();
			if (OptionCodeKeys.JK_0003402.equals(ojByColor)) {
				String ojByColorPlace1 = coOptionJacketStandardInfo.getOjByColorPlace1();
				String ojByColorPlace2 = coOptionJacketStandardInfo.getOjByColorPlace2();
				String ojByColorPlace3 = coOptionJacketStandardInfo.getOjByColorPlace3();
				String ojByColorPlace4 = coOptionJacketStandardInfo.getOjByColorPlace4();
				String ojByColorPlace5 = coOptionJacketStandardInfo.getOjByColorPlace5();
				String ojByColorPlace6 = coOptionJacketStandardInfo.getOjByColorPlace6();
				String ojByColorPlace7 = coOptionJacketStandardInfo.getOjByColorPlace7();
				String ojByColorPlace8 = coOptionJacketStandardInfo.getOjByColorPlace8();
				String ojByColorPlace9 = coOptionJacketStandardInfo.getOjByColorPlace9();
				String ojByColorPlace10 = coOptionJacketStandardInfo.getOjByColorPlace10();
				String ojByColorPlace11 = coOptionJacketStandardInfo.getOjByColorPlace11();
				String ojByColorPlace12 = coOptionJacketStandardInfo.getOjByColorPlace12();
				String ojByColorPlace13 = coOptionJacketStandardInfo.getOjByColorPlace13();
				String ojByColorPlace14 = coOptionJacketStandardInfo.getOjByColorPlace14();
				String ojByColorPlace15 = coOptionJacketStandardInfo.getOjByColorPlace15();
				String ojByColorPlace16 = coOptionJacketStandardInfo.getOjByColorPlace16();
				
				String ojByColor1 = coOptionJacketStandardInfo.getOjByColor1();
				String ojByColor2 = coOptionJacketStandardInfo.getOjByColor2();
				String ojByColor3 = coOptionJacketStandardInfo.getOjByColor3();
				String ojByColor4 = coOptionJacketStandardInfo.getOjByColor4();
				String ojByColor5 = coOptionJacketStandardInfo.getOjByColor5();
				String ojByColor6 = coOptionJacketStandardInfo.getOjByColor6();
				String ojByColor7 = coOptionJacketStandardInfo.getOjByColor7();
				String ojByColor8 = coOptionJacketStandardInfo.getOjByColor8();
				String ojByColor9 = coOptionJacketStandardInfo.getOjByColor9();
				String ojByColor10 = coOptionJacketStandardInfo.getOjByColor10();
				String ojByColor11 = coOptionJacketStandardInfo.getOjByColor11();
				String ojByColor12 = coOptionJacketStandardInfo.getOjByColor12();
				String ojByColor13 = coOptionJacketStandardInfo.getOjByColor13();
				String ojByColor14 = coOptionJacketStandardInfo.getOjByColor14();
				String ojByColor15 = coOptionJacketStandardInfo.getOjByColor15();
				String ojByColor16 = coOptionJacketStandardInfo.getOjByColor16();
				
				if (BaseCheckUtil.isEmpty(ojByColorPlace1) && BaseCheckUtil.isEmpty(ojByColorPlace2) && BaseCheckUtil.isEmpty(ojByColorPlace3)
						&& BaseCheckUtil.isEmpty(ojByColorPlace4) && BaseCheckUtil.isEmpty(ojByColorPlace5) && BaseCheckUtil.isEmpty(ojByColorPlace6)
						&& BaseCheckUtil.isEmpty(ojByColorPlace7) && BaseCheckUtil.isEmpty(ojByColorPlace8) && BaseCheckUtil.isEmpty(ojByColorPlace9)
						&& BaseCheckUtil.isEmpty(ojByColorPlace10)&& BaseCheckUtil.isEmpty(ojByColorPlace11)&& BaseCheckUtil.isEmpty(ojByColorPlace12)
						&& BaseCheckUtil.isEmpty(ojByColorPlace13)&& BaseCheckUtil.isEmpty(ojByColorPlace14)&& BaseCheckUtil.isEmpty(ojByColorPlace15)
						&& BaseCheckUtil.isEmpty(ojByColorPlace16)) {
					messages.add("E032", "JACKET ボタン付け糸指定");
					jacketFlag = true;
				}
				
				if(BaseCheckUtil.isNotEmpty(ojByColorPlace1)&&BaseCheckUtil.isEmpty(ojByColor1)||BaseCheckUtil.isNotEmpty(ojByColorPlace2)&&BaseCheckUtil.isEmpty(ojByColor2)||
				   BaseCheckUtil.isNotEmpty(ojByColorPlace3)&&BaseCheckUtil.isEmpty(ojByColor3)||BaseCheckUtil.isNotEmpty(ojByColorPlace4)&&BaseCheckUtil.isEmpty(ojByColor4)||
				   BaseCheckUtil.isNotEmpty(ojByColorPlace5)&&BaseCheckUtil.isEmpty(ojByColor5)||BaseCheckUtil.isNotEmpty(ojByColorPlace6)&&BaseCheckUtil.isEmpty(ojByColor6)||
				   BaseCheckUtil.isNotEmpty(ojByColorPlace7)&&BaseCheckUtil.isEmpty(ojByColor7)||BaseCheckUtil.isNotEmpty(ojByColorPlace8)&&BaseCheckUtil.isEmpty(ojByColor8)||
				   BaseCheckUtil.isNotEmpty(ojByColorPlace9)&&BaseCheckUtil.isEmpty(ojByColor9)||BaseCheckUtil.isNotEmpty(ojByColorPlace10)&&BaseCheckUtil.isEmpty(ojByColor10)||
				   BaseCheckUtil.isNotEmpty(ojByColorPlace11)&&BaseCheckUtil.isEmpty(ojByColor11)||BaseCheckUtil.isNotEmpty(ojByColorPlace12)&&BaseCheckUtil.isEmpty(ojByColor12)||
				   BaseCheckUtil.isNotEmpty(ojByColorPlace13)&&BaseCheckUtil.isEmpty(ojByColor13)||BaseCheckUtil.isNotEmpty(ojByColorPlace14)&&BaseCheckUtil.isEmpty(ojByColor14)||
				   BaseCheckUtil.isNotEmpty(ojByColorPlace15)&&BaseCheckUtil.isEmpty(ojByColor15)||BaseCheckUtil.isNotEmpty(ojByColorPlace16)&&BaseCheckUtil.isEmpty(ojByColor16)) {
					messages.add("E032", "JACKET ボタン付け糸指定");
					jacketFlag = true;
				}
				
			}
		//タキシードの場合
		}else if("9000102".equals(productCategory)) {
			//JACKET モデル未選択の場合
			CoOptionJacketTuxedoInfo coOptionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
			String tjJacketModel = coOptionJacketTuxedoInfo.getTjJacketModel();
			if("".equals(tjJacketModel)  ||  null == tjJacketModel) {
				 messages.add("E031", "JACKET モデル");
				 jacketFlag = true;
			}
			
			// ボタンホール色指定
			String ojBhColor = coOptionJacketTuxedoInfo.getTjBhColor();
			if (OptionCodeKeys.JK_0003102.equals(ojBhColor)) {
				String tjBhColorPlace1 = coOptionJacketTuxedoInfo.getTjBhColorPlace1();
				String tjBhColorPlace2 = coOptionJacketTuxedoInfo.getTjBhColorPlace2();
				String tjBhColorPlace3 = coOptionJacketTuxedoInfo.getTjBhColorPlace3();
				String tjBhColorPlace4 = coOptionJacketTuxedoInfo.getTjBhColorPlace4();
				String tjBhColorPlace5 = coOptionJacketTuxedoInfo.getTjBhColorPlace5();
				String tjBhColorPlace6 = coOptionJacketTuxedoInfo.getTjBhColorPlace6();
				String tjBhColorPlace7 = coOptionJacketTuxedoInfo.getTjBhColorPlace7();
				String tjBhColorPlace8 = coOptionJacketTuxedoInfo.getTjBhColorPlace8();
				String tjBhColorPlace9 = coOptionJacketTuxedoInfo.getTjBhColorPlace9();
				String tjBhColorPlace10 = coOptionJacketTuxedoInfo.getTjBhColorPlace10();
				String tjBhColorPlace11 = coOptionJacketTuxedoInfo.getTjBhColorPlace11();
				String tjBhColorPlace12 = coOptionJacketTuxedoInfo.getTjBhColorPlace12();
				String tjBhColorPlace13 = coOptionJacketTuxedoInfo.getTjBhColorPlace13();
				String tjBhColorPlace14 = coOptionJacketTuxedoInfo.getTjBhColorPlace14();
				String tjBhColorPlace15 = coOptionJacketTuxedoInfo.getTjBhColorPlace15();
				String tjBhColorPlace16 = coOptionJacketTuxedoInfo.getTjBhColorPlace16();
				String tjBhColorPlace17 = coOptionJacketTuxedoInfo.getTjBhColorPlace17();
				
				String tjBhColor1 = coOptionJacketTuxedoInfo.getTjBhColor1();
				String tjBhColor2 = coOptionJacketTuxedoInfo.getTjBhColor2();
				String tjBhColor3 = coOptionJacketTuxedoInfo.getTjBhColor3();
				String tjBhColor4 = coOptionJacketTuxedoInfo.getTjBhColor4();
				String tjBhColor5 = coOptionJacketTuxedoInfo.getTjBhColor5();
				String tjBhColor6 = coOptionJacketTuxedoInfo.getTjBhColor6();
				String tjBhColor7 = coOptionJacketTuxedoInfo.getTjBhColor7();
				String tjBhColor8 = coOptionJacketTuxedoInfo.getTjBhColor8();
				String tjBhColor9 = coOptionJacketTuxedoInfo.getTjBhColor9();
				String tjBhColor10 = coOptionJacketTuxedoInfo.getTjBhColor10();
				String tjBhColor11 = coOptionJacketTuxedoInfo.getTjBhColor11();
				String tjBhColor12 = coOptionJacketTuxedoInfo.getTjBhColor12();
				String tjBhColor13 = coOptionJacketTuxedoInfo.getTjBhColor13();
				String tjBhColor14 = coOptionJacketTuxedoInfo.getTjBhColor14();
				String tjBhColor15 = coOptionJacketTuxedoInfo.getTjBhColor15();
				String tjBhColor16 = coOptionJacketTuxedoInfo.getTjBhColor16();
				String tjBhColor17 = coOptionJacketTuxedoInfo.getTjBhColor17();

				if (BaseCheckUtil.isEmpty(tjBhColorPlace1) && BaseCheckUtil.isEmpty(tjBhColorPlace2) && BaseCheckUtil.isEmpty(tjBhColorPlace3)
						&& BaseCheckUtil.isEmpty(tjBhColorPlace4) && BaseCheckUtil.isEmpty(tjBhColorPlace5) && BaseCheckUtil.isEmpty(tjBhColorPlace6)
						&& BaseCheckUtil.isEmpty(tjBhColorPlace7) && BaseCheckUtil.isEmpty(tjBhColorPlace8) && BaseCheckUtil.isEmpty(tjBhColorPlace9)
						&& BaseCheckUtil.isEmpty(tjBhColorPlace10) && BaseCheckUtil.isEmpty(tjBhColorPlace11) && BaseCheckUtil.isEmpty(tjBhColorPlace12)
						&& BaseCheckUtil.isEmpty(tjBhColorPlace13) && BaseCheckUtil.isEmpty(tjBhColorPlace14) && BaseCheckUtil.isEmpty(tjBhColorPlace15)
						&& BaseCheckUtil.isEmpty(tjBhColorPlace16) && BaseCheckUtil.isEmpty(tjBhColorPlace17)) {
					messages.add("E032", "JACKET ボタンホール色指定");
					jacketFlag = true;
				}

				if(BaseCheckUtil.isNotEmpty(tjBhColorPlace1)&&BaseCheckUtil.isEmpty(tjBhColor1)||BaseCheckUtil.isNotEmpty(tjBhColorPlace2)&&BaseCheckUtil.isEmpty(tjBhColor2)||
				   BaseCheckUtil.isNotEmpty(tjBhColorPlace3)&&BaseCheckUtil.isEmpty(tjBhColor3)||BaseCheckUtil.isNotEmpty(tjBhColorPlace4)&&BaseCheckUtil.isEmpty(tjBhColor4)||
				   BaseCheckUtil.isNotEmpty(tjBhColorPlace5)&&BaseCheckUtil.isEmpty(tjBhColor5)||BaseCheckUtil.isNotEmpty(tjBhColorPlace6)&&BaseCheckUtil.isEmpty(tjBhColor6)||
				   BaseCheckUtil.isNotEmpty(tjBhColorPlace7)&&BaseCheckUtil.isEmpty(tjBhColor7)||BaseCheckUtil.isNotEmpty(tjBhColorPlace8)&&BaseCheckUtil.isEmpty(tjBhColor8)||
				   BaseCheckUtil.isNotEmpty(tjBhColorPlace9)&&BaseCheckUtil.isEmpty(tjBhColor9)||BaseCheckUtil.isNotEmpty(tjBhColorPlace10)&&BaseCheckUtil.isEmpty(tjBhColor10)||
				   BaseCheckUtil.isNotEmpty(tjBhColorPlace11)&&BaseCheckUtil.isEmpty(tjBhColor11)||BaseCheckUtil.isNotEmpty(tjBhColorPlace12)&&BaseCheckUtil.isEmpty(tjBhColor12)||
				   BaseCheckUtil.isNotEmpty(tjBhColorPlace13)&&BaseCheckUtil.isEmpty(tjBhColor13)||BaseCheckUtil.isNotEmpty(tjBhColorPlace14)&&BaseCheckUtil.isEmpty(tjBhColor14)||
				   BaseCheckUtil.isNotEmpty(tjBhColorPlace15)&&BaseCheckUtil.isEmpty(tjBhColor15)||BaseCheckUtil.isNotEmpty(tjBhColorPlace16)&&BaseCheckUtil.isEmpty(tjBhColor16)||
				   BaseCheckUtil.isNotEmpty(tjBhColorPlace17)&&BaseCheckUtil.isEmpty(tjBhColor17)) {
					messages.add("E032", "JACKET ボタンホール色指定");
					jacketFlag = true;
				}
				
				// ボタン付け糸指定
				String tjByColor = coOptionJacketTuxedoInfo.getTjByColor();
				if (OptionCodeKeys.JK_0003402.equals(tjByColor)) {
					String tjByColorPlace1 = coOptionJacketTuxedoInfo.getTjByColorPlace1();
					String tjByColorPlace2 = coOptionJacketTuxedoInfo.getTjByColorPlace2();
					String tjByColorPlace3 = coOptionJacketTuxedoInfo.getTjByColorPlace3();
					String tjByColorPlace4 = coOptionJacketTuxedoInfo.getTjByColorPlace4();
					String tjByColorPlace5 = coOptionJacketTuxedoInfo.getTjByColorPlace5();
					String tjByColorPlace6 = coOptionJacketTuxedoInfo.getTjByColorPlace6();
					String tjByColorPlace7 = coOptionJacketTuxedoInfo.getTjByColorPlace7();
					String tjByColorPlace8 = coOptionJacketTuxedoInfo.getTjByColorPlace8();
					String tjByColorPlace9 = coOptionJacketTuxedoInfo.getTjByColorPlace9();
					String tjByColorPlace10 = coOptionJacketTuxedoInfo.getTjByColorPlace10();
					String tjByColorPlace11 = coOptionJacketTuxedoInfo.getTjByColorPlace11();
					String tjByColorPlace12 = coOptionJacketTuxedoInfo.getTjByColorPlace12();
					String tjByColorPlace13 = coOptionJacketTuxedoInfo.getTjByColorPlace13();
					String tjByColorPlace14 = coOptionJacketTuxedoInfo.getTjByColorPlace14();
					String tjByColorPlace15 = coOptionJacketTuxedoInfo.getTjByColorPlace15();
					String tjByColorPlace16 = coOptionJacketTuxedoInfo.getTjByColorPlace16();
					
					String tjByColor1 = coOptionJacketTuxedoInfo.getTjByColor1();
					String tjByColor2 = coOptionJacketTuxedoInfo.getTjByColor2();
					String tjByColor3 = coOptionJacketTuxedoInfo.getTjByColor3();
					String tjByColor4 = coOptionJacketTuxedoInfo.getTjByColor4();
					String tjByColor5 = coOptionJacketTuxedoInfo.getTjByColor5();
					String tjByColor6 = coOptionJacketTuxedoInfo.getTjByColor6();
					String tjByColor7 = coOptionJacketTuxedoInfo.getTjByColor7();
					String tjByColor8 = coOptionJacketTuxedoInfo.getTjByColor8();
					String tjByColor9 = coOptionJacketTuxedoInfo.getTjByColor9();
					String tjByColor10 = coOptionJacketTuxedoInfo.getTjByColor10();
					String tjByColor11 = coOptionJacketTuxedoInfo.getTjByColor11();
					String tjByColor12 = coOptionJacketTuxedoInfo.getTjByColor12();
					String tjByColor13 = coOptionJacketTuxedoInfo.getTjByColor13();
					String tjByColor14 = coOptionJacketTuxedoInfo.getTjByColor14();
					String tjByColor15 = coOptionJacketTuxedoInfo.getTjByColor15();
					String tjByColor16 = coOptionJacketTuxedoInfo.getTjByColor16();
					
					if (BaseCheckUtil.isEmpty(tjByColorPlace1) && BaseCheckUtil.isEmpty(tjByColorPlace2) && BaseCheckUtil.isEmpty(tjByColorPlace3)
							&& BaseCheckUtil.isEmpty(tjByColorPlace4) && BaseCheckUtil.isEmpty(tjByColorPlace5) && BaseCheckUtil.isEmpty(tjByColorPlace6)
							&& BaseCheckUtil.isEmpty(tjByColorPlace7) && BaseCheckUtil.isEmpty(tjByColorPlace8) && BaseCheckUtil.isEmpty(tjByColorPlace9)
							&& BaseCheckUtil.isEmpty(tjByColorPlace10) && BaseCheckUtil.isEmpty(tjByColorPlace11) && BaseCheckUtil.isEmpty(tjByColorPlace12)
							&& BaseCheckUtil.isEmpty(tjByColorPlace13) && BaseCheckUtil.isEmpty(tjByColorPlace14) && BaseCheckUtil.isEmpty(tjByColorPlace15)
							&& BaseCheckUtil.isEmpty(tjByColorPlace16)) {
						messages.add("E032", "JACKET ボタン付け糸指定");
						jacketFlag = true;
					}
					
					if(BaseCheckUtil.isNotEmpty(tjByColorPlace1)&&BaseCheckUtil.isEmpty(tjByColor1)||BaseCheckUtil.isNotEmpty(tjByColorPlace2)&&BaseCheckUtil.isEmpty(tjByColor2)||
					   BaseCheckUtil.isNotEmpty(tjByColorPlace3)&&BaseCheckUtil.isEmpty(tjByColor3)||BaseCheckUtil.isNotEmpty(tjByColorPlace4)&&BaseCheckUtil.isEmpty(tjByColor4)||
					   BaseCheckUtil.isNotEmpty(tjByColorPlace5)&&BaseCheckUtil.isEmpty(tjByColor5)||BaseCheckUtil.isNotEmpty(tjByColorPlace6)&&BaseCheckUtil.isEmpty(tjByColor6)||
					   BaseCheckUtil.isNotEmpty(tjByColorPlace7)&&BaseCheckUtil.isEmpty(tjByColor7)||BaseCheckUtil.isNotEmpty(tjByColorPlace8)&&BaseCheckUtil.isEmpty(tjByColor8)||
					   BaseCheckUtil.isNotEmpty(tjByColorPlace9)&&BaseCheckUtil.isEmpty(tjByColor9)||BaseCheckUtil.isNotEmpty(tjByColorPlace10)&&BaseCheckUtil.isEmpty(tjByColor10)||
					   BaseCheckUtil.isNotEmpty(tjByColorPlace11)&&BaseCheckUtil.isEmpty(tjByColor11)||BaseCheckUtil.isNotEmpty(tjByColorPlace12)&&BaseCheckUtil.isEmpty(tjByColor12)||
					   BaseCheckUtil.isNotEmpty(tjByColorPlace13)&&BaseCheckUtil.isEmpty(tjByColor13)||BaseCheckUtil.isNotEmpty(tjByColorPlace14)&&BaseCheckUtil.isEmpty(tjByColor14)||
					   BaseCheckUtil.isNotEmpty(tjByColorPlace15)&&BaseCheckUtil.isEmpty(tjByColor15)||BaseCheckUtil.isNotEmpty(tjByColorPlace16)&&BaseCheckUtil.isEmpty(tjByColor16)) {
						messages.add("E032", "JACKET ボタン付け糸指定");
						jacketFlag = true;
					}
				}
			}
		}else if("9000103".equals(productCategory)) {
			//JACKET モデル未選択の場合
			CoOptionJacketWashableInfo coOptionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
			String wjJacketModel = coOptionJacketWashableInfo.getWjJacketModel();
			if("".equals(wjJacketModel)  ||  null == wjJacketModel) {
				 messages.add("E031", "JACKET モデル");
				 jacketFlag = true;
			}
			
			//ステッチ箇所変更
			String wjStitchModify = coOptionJacketWashableInfo.getWjStitchModify();
			if(OptionCodeKeys.JK_0002402.equals(wjStitchModify)) {
				String wjStitchModifyPlace1 = coOptionJacketWashableInfo.getWjStitchModifyPlace1();
				String wjStitchModifyPlace2 = coOptionJacketWashableInfo.getWjStitchModifyPlace2();
				String wjStitchModifyPlace3 = coOptionJacketWashableInfo.getWjStitchModifyPlace3();
				String wjStitchModifyPlace4 = coOptionJacketWashableInfo.getWjStitchModifyPlace4();
				String wjStitchModifyPlace5 = coOptionJacketWashableInfo.getWjStitchModifyPlace5();
				String wjStitchModifyPlace6 = coOptionJacketWashableInfo.getWjStitchModifyPlace6();
				String wjStitchModifyPlace7 = coOptionJacketWashableInfo.getWjStitchModifyPlace7();
				String wjStitchModifyPlace8 = coOptionJacketWashableInfo.getWjStitchModifyPlace8();
				String wjStitchModifyPlace9 = coOptionJacketWashableInfo.getWjStitchModifyPlace9();
				
				if (BaseCheckUtil.isEmpty(wjStitchModifyPlace1) && BaseCheckUtil.isEmpty(wjStitchModifyPlace2)
						&& BaseCheckUtil.isEmpty(wjStitchModifyPlace3) && BaseCheckUtil.isEmpty(wjStitchModifyPlace4)
						&& BaseCheckUtil.isEmpty(wjStitchModifyPlace5) && BaseCheckUtil.isEmpty(wjStitchModifyPlace6)
						&& BaseCheckUtil.isEmpty(wjStitchModifyPlace7) && BaseCheckUtil.isEmpty(wjStitchModifyPlace8)
						&& BaseCheckUtil.isEmpty(wjStitchModifyPlace9)) {
					messages.add("E033", "JACKET ステッチ箇所変更");
					jacketFlag = true;
				}
			}
			
			//ダブルステッチ変更
			String wjDStitchModify = coOptionJacketWashableInfo.getWjDStitchModify();
			if(OptionCodeKeys.JK_0002602.equals(wjDStitchModify)) {
				String wjDStitchModifyPlace1 = coOptionJacketWashableInfo.getWjDStitchModifyPlace1();
				String wjDStitchModifyPlace2 = coOptionJacketWashableInfo.getWjDStitchModifyPlace2();
				String wjDStitchModifyPlace3 = coOptionJacketWashableInfo.getWjDStitchModifyPlace3();
				String wjDStitchModifyPlace4 = coOptionJacketWashableInfo.getWjDStitchModifyPlace4();
				String wjDStitchModifyPlace5 = coOptionJacketWashableInfo.getWjDStitchModifyPlace5();
				String wjDStitchModifyPlace6 = coOptionJacketWashableInfo.getWjDStitchModifyPlace6();
				String wjDStitchModifyPlace7 = coOptionJacketWashableInfo.getWjDStitchModifyPlace7();
				String wjDStitchModifyPlace8 = coOptionJacketWashableInfo.getWjDStitchModifyPlace8();
				if (BaseCheckUtil.isEmpty(wjDStitchModifyPlace1) && BaseCheckUtil.isEmpty(wjDStitchModifyPlace2)
						&& BaseCheckUtil.isEmpty(wjDStitchModifyPlace3) && BaseCheckUtil.isEmpty(wjDStitchModifyPlace4)
						&& BaseCheckUtil.isEmpty(wjDStitchModifyPlace5) && BaseCheckUtil.isEmpty(wjDStitchModifyPlace6)
						&& BaseCheckUtil.isEmpty(wjDStitchModifyPlace7) && BaseCheckUtil.isEmpty(wjDStitchModifyPlace8)) {
					messages.add("E033", "JACKET ダブルステッチ変更");
					jacketFlag = true;
				}
			}
			 
			//AMF色指定
			String wjamfColor = coOptionJacketWashableInfo.getWjAmfColor();
			if(OptionCodeKeys.JK_0002802.equals(wjamfColor)) {
				String wjAmfColorPlace1 = coOptionJacketWashableInfo.getWjAmfColorPlace1();
				String wjAmfColorPlace2 = coOptionJacketWashableInfo.getWjAmfColorPlace2();
				String wjAmfColorPlace3 = coOptionJacketWashableInfo.getWjAmfColorPlace3();
				String wjAmfColorPlace4 = coOptionJacketWashableInfo.getWjAmfColorPlace4();
				String wjAmfColorPlace5 = coOptionJacketWashableInfo.getWjAmfColorPlace5();
				String wjAmfColorPlace6 = coOptionJacketWashableInfo.getWjAmfColorPlace6();
				String wjAmfColorPlace7 = coOptionJacketWashableInfo.getWjAmfColorPlace7();
				String wjAmfColorPlace8 = coOptionJacketWashableInfo.getWjAmfColorPlace8();
				String wjAmfColorPlace9 = coOptionJacketWashableInfo.getWjAmfColorPlace9();
				
				String wjAmfColor1 = coOptionJacketWashableInfo.getWjAmfColor1();
				String wjAmfColor2 = coOptionJacketWashableInfo.getWjAmfColor2();
				String wjAmfColor3 = coOptionJacketWashableInfo.getWjAmfColor3();
				String wjAmfColor4 = coOptionJacketWashableInfo.getWjAmfColor4();
				String wjAmfColor5 = coOptionJacketWashableInfo.getWjAmfColor5();
				String wjAmfColor6 = coOptionJacketWashableInfo.getWjAmfColor6();
				String wjAmfColor7 = coOptionJacketWashableInfo.getWjAmfColor7();
				String wjAmfColor8 = coOptionJacketWashableInfo.getWjAmfColor8();
				String wjAmfColor9 = coOptionJacketWashableInfo.getWjAmfColor9();
				
				if(BaseCheckUtil.isEmpty(wjAmfColorPlace1)&&BaseCheckUtil.isEmpty(wjAmfColorPlace2)&&BaseCheckUtil.isEmpty(wjAmfColorPlace3)&&BaseCheckUtil.isEmpty(wjAmfColorPlace4)&&
				   BaseCheckUtil.isEmpty(wjAmfColorPlace5)&&BaseCheckUtil.isEmpty(wjAmfColorPlace6)&&BaseCheckUtil.isEmpty(wjAmfColorPlace7)&&BaseCheckUtil.isEmpty(wjAmfColorPlace8)&&BaseCheckUtil.isEmpty(wjAmfColorPlace9)) {
					messages.add("E032", "JACKET AMF色指定");
					jacketFlag = true;
				}
				
				if(BaseCheckUtil.isNotEmpty(wjAmfColorPlace1)&&BaseCheckUtil.isEmpty(wjAmfColor1)||BaseCheckUtil.isNotEmpty(wjAmfColorPlace2)&&BaseCheckUtil.isEmpty(wjAmfColor2)||
				   BaseCheckUtil.isNotEmpty(wjAmfColorPlace3)&&BaseCheckUtil.isEmpty(wjAmfColor3)||BaseCheckUtil.isNotEmpty(wjAmfColorPlace4)&&BaseCheckUtil.isEmpty(wjAmfColor4)||
				   BaseCheckUtil.isNotEmpty(wjAmfColorPlace5)&&BaseCheckUtil.isEmpty(wjAmfColor5)||BaseCheckUtil.isNotEmpty(wjAmfColorPlace6)&&BaseCheckUtil.isEmpty(wjAmfColor6)||
				   BaseCheckUtil.isNotEmpty(wjAmfColorPlace7)&&BaseCheckUtil.isEmpty(wjAmfColor7)||BaseCheckUtil.isNotEmpty(wjAmfColorPlace8)&&BaseCheckUtil.isEmpty(wjAmfColor8)||
				   BaseCheckUtil.isNotEmpty(wjAmfColorPlace9)&&BaseCheckUtil.isEmpty(wjAmfColor9)) {
					messages.add("E032", "JACKET AMF色指定");
					jacketFlag = true;
				}
				
			}
			
			//ボタンホール色指定
			String wjBhColor = coOptionJacketWashableInfo.getWjBhColor();
			if (OptionCodeKeys.JK_0003102.equals(wjBhColor)) {
				String wjBhColorPlace1 = coOptionJacketWashableInfo.getWjBhColorPlace1();
				String wjBhColorPlace2 = coOptionJacketWashableInfo.getWjBhColorPlace2();
				String wjBhColorPlace3 = coOptionJacketWashableInfo.getWjBhColorPlace3();
				String wjBhColorPlace4 = coOptionJacketWashableInfo.getWjBhColorPlace4();
				String wjBhColorPlace5 = coOptionJacketWashableInfo.getWjBhColorPlace5();
				String wjBhColorPlace6 = coOptionJacketWashableInfo.getWjBhColorPlace6();
				String wjBhColorPlace7 = coOptionJacketWashableInfo.getWjBhColorPlace7();
				String wjBhColorPlace8 = coOptionJacketWashableInfo.getWjBhColorPlace8();
				String wjBhColorPlace9 = coOptionJacketWashableInfo.getWjBhColorPlace9();
				String wjBhColorPlace10 = coOptionJacketWashableInfo.getWjBhColorPlace10();
				String wjBhColorPlace11 = coOptionJacketWashableInfo.getWjBhColorPlace11();
				String wjBhColorPlace12 = coOptionJacketWashableInfo.getWjBhColorPlace12();
				String wjBhColorPlace13 = coOptionJacketWashableInfo.getWjBhColorPlace13();
				String wjBhColorPlace14 = coOptionJacketWashableInfo.getWjBhColorPlace14();
				String wjBhColorPlace15 = coOptionJacketWashableInfo.getWjBhColorPlace15();
				String wjBhColorPlace16 = coOptionJacketWashableInfo.getWjBhColorPlace16();
				String wjBhColorPlace17 = coOptionJacketWashableInfo.getWjBhColorPlace17();
				
				String wjBhColor1 = coOptionJacketWashableInfo.getWjBhColor1();
				String wjBhColor2 = coOptionJacketWashableInfo.getWjBhColor2();
				String wjBhColor3 = coOptionJacketWashableInfo.getWjBhColor3();
				String wjBhColor4 = coOptionJacketWashableInfo.getWjBhColor4();
				String wjBhColor5 = coOptionJacketWashableInfo.getWjBhColor5();
				String wjBhColor6 = coOptionJacketWashableInfo.getWjBhColor6();
				String wjBhColor7 = coOptionJacketWashableInfo.getWjBhColor7();
				String wjBhColor8 = coOptionJacketWashableInfo.getWjBhColor8();
				String wjBhColor9 = coOptionJacketWashableInfo.getWjBhColor9();
				String wjBhColor10 = coOptionJacketWashableInfo.getWjBhColor10();
				String wjBhColor11 = coOptionJacketWashableInfo.getWjBhColor11();
				String wjBhColor12 = coOptionJacketWashableInfo.getWjBhColor12();
				String wjBhColor13 = coOptionJacketWashableInfo.getWjBhColor13();
				String wjBhColor14 = coOptionJacketWashableInfo.getWjBhColor14();
				String wjBhColor15 = coOptionJacketWashableInfo.getWjBhColor15();
				String wjBhColor16 = coOptionJacketWashableInfo.getWjBhColor16();
				String wjBhColor17 = coOptionJacketWashableInfo.getWjBhColor17();

				if (BaseCheckUtil.isEmpty(wjBhColorPlace1) && BaseCheckUtil.isEmpty(wjBhColorPlace2) && BaseCheckUtil.isEmpty(wjBhColorPlace3)
						&& BaseCheckUtil.isEmpty(wjBhColorPlace4) && BaseCheckUtil.isEmpty(wjBhColorPlace5) && BaseCheckUtil.isEmpty(wjBhColorPlace6)
						&& BaseCheckUtil.isEmpty(wjBhColorPlace7) && BaseCheckUtil.isEmpty(wjBhColorPlace8) && BaseCheckUtil.isEmpty(wjBhColorPlace9)
						&& BaseCheckUtil.isEmpty(wjBhColorPlace10)&& BaseCheckUtil.isEmpty(wjBhColorPlace11)&& BaseCheckUtil.isEmpty(wjBhColorPlace12)
						&& BaseCheckUtil.isEmpty(wjBhColorPlace13)&& BaseCheckUtil.isEmpty(wjBhColorPlace14)&& BaseCheckUtil.isEmpty(wjBhColorPlace15)
						&& BaseCheckUtil.isEmpty(wjBhColorPlace16)&& BaseCheckUtil.isEmpty(wjBhColorPlace17)) {
					messages.add("E032", "JACKET ボタンホール色指定");
					jacketFlag = true;
				}
				
				if(BaseCheckUtil.isNotEmpty(wjBhColorPlace1)&&BaseCheckUtil.isEmpty(wjBhColor1)||BaseCheckUtil.isNotEmpty(wjBhColorPlace2)&&BaseCheckUtil.isEmpty(wjBhColor2)||
				   BaseCheckUtil.isNotEmpty(wjBhColorPlace3)&&BaseCheckUtil.isEmpty(wjBhColor3)||BaseCheckUtil.isNotEmpty(wjBhColorPlace4)&&BaseCheckUtil.isEmpty(wjBhColor4)||
				   BaseCheckUtil.isNotEmpty(wjBhColorPlace5)&&BaseCheckUtil.isEmpty(wjBhColor5)||BaseCheckUtil.isNotEmpty(wjBhColorPlace6)&&BaseCheckUtil.isEmpty(wjBhColor6)||
				   BaseCheckUtil.isNotEmpty(wjBhColorPlace7)&&BaseCheckUtil.isEmpty(wjBhColor7)||BaseCheckUtil.isNotEmpty(wjBhColorPlace8)&&BaseCheckUtil.isEmpty(wjBhColor8)||
				   BaseCheckUtil.isNotEmpty(wjBhColorPlace9)&&BaseCheckUtil.isEmpty(wjBhColor9)||BaseCheckUtil.isNotEmpty(wjBhColorPlace10)&&BaseCheckUtil.isEmpty(wjBhColor10)||
				   BaseCheckUtil.isNotEmpty(wjBhColorPlace11)&&BaseCheckUtil.isEmpty(wjBhColor11)||BaseCheckUtil.isNotEmpty(wjBhColorPlace12)&&BaseCheckUtil.isEmpty(wjBhColor12)||
				   BaseCheckUtil.isNotEmpty(wjBhColorPlace13)&&BaseCheckUtil.isEmpty(wjBhColor13)||BaseCheckUtil.isNotEmpty(wjBhColorPlace14)&&BaseCheckUtil.isEmpty(wjBhColor14)||
				   BaseCheckUtil.isNotEmpty(wjBhColorPlace15)&&BaseCheckUtil.isEmpty(wjBhColor15)||BaseCheckUtil.isNotEmpty(wjBhColorPlace16)&&BaseCheckUtil.isEmpty(wjBhColor16)||
				   BaseCheckUtil.isNotEmpty(wjBhColorPlace17)&&BaseCheckUtil.isEmpty(wjBhColor17)) {
					messages.add("E032", "JACKET ボタンホール色指定");
					jacketFlag = true;
				}
			}
			
			//ボタン付け糸指定
			String wjByColor = coOptionJacketWashableInfo.getWjByColor();
			if (OptionCodeKeys.JK_0003402.equals(wjByColor)) {
				String wjByColorPlace1 = coOptionJacketWashableInfo.getWjByColorPlace1();
				String wjByColorPlace2 = coOptionJacketWashableInfo.getWjByColorPlace2();
				String wjByColorPlace3 = coOptionJacketWashableInfo.getWjByColorPlace3();
				String wjByColorPlace4 = coOptionJacketWashableInfo.getWjByColorPlace4();
				String wjByColorPlace5 = coOptionJacketWashableInfo.getWjByColorPlace5();
				String wjByColorPlace6 = coOptionJacketWashableInfo.getWjByColorPlace6();
				String wjByColorPlace7 = coOptionJacketWashableInfo.getWjByColorPlace7();
				String wjByColorPlace8 = coOptionJacketWashableInfo.getWjByColorPlace8();
				String wjByColorPlace9 = coOptionJacketWashableInfo.getWjByColorPlace9();
				String wjByColorPlace10 = coOptionJacketWashableInfo.getWjByColorPlace10();
				String wjByColorPlace11 = coOptionJacketWashableInfo.getWjByColorPlace11();
				String wjByColorPlace12 = coOptionJacketWashableInfo.getWjByColorPlace12();
				String wjByColorPlace13 = coOptionJacketWashableInfo.getWjByColorPlace13();
				String wjByColorPlace14 = coOptionJacketWashableInfo.getWjByColorPlace14();
				String wjByColorPlace15 = coOptionJacketWashableInfo.getWjByColorPlace15();
				String wjByColorPlace16 = coOptionJacketWashableInfo.getWjByColorPlace16();
				
				String wjByColor1 = coOptionJacketWashableInfo.getWjByColor1();
				String wjByColor2 = coOptionJacketWashableInfo.getWjByColor2();
				String wjByColor3 = coOptionJacketWashableInfo.getWjByColor3();
				String wjByColor4 = coOptionJacketWashableInfo.getWjByColor4();
				String wjByColor5 = coOptionJacketWashableInfo.getWjByColor5();
				String wjByColor6 = coOptionJacketWashableInfo.getWjByColor6();
				String wjByColor7 = coOptionJacketWashableInfo.getWjByColor7();
				String wjByColor8 = coOptionJacketWashableInfo.getWjByColor8();
				String wjByColor9 = coOptionJacketWashableInfo.getWjByColor9();
				String wjByColor10 = coOptionJacketWashableInfo.getWjByColor10();
				String wjByColor11 = coOptionJacketWashableInfo.getWjByColor11();
				String wjByColor12 = coOptionJacketWashableInfo.getWjByColor12();
				String wjByColor13 = coOptionJacketWashableInfo.getWjByColor13();
				String wjByColor14 = coOptionJacketWashableInfo.getWjByColor14();
				String wjByColor15 = coOptionJacketWashableInfo.getWjByColor15();
				String wjByColor16 = coOptionJacketWashableInfo.getWjByColor16();
				
				if (BaseCheckUtil.isEmpty(wjByColorPlace1) && BaseCheckUtil.isEmpty(wjByColorPlace2) && BaseCheckUtil.isEmpty(wjByColorPlace3)
						&& BaseCheckUtil.isEmpty(wjByColorPlace4) && BaseCheckUtil.isEmpty(wjByColorPlace5) && BaseCheckUtil.isEmpty(wjByColorPlace6)
						&& BaseCheckUtil.isEmpty(wjByColorPlace7) && BaseCheckUtil.isEmpty(wjByColorPlace8) && BaseCheckUtil.isEmpty(wjByColorPlace9)
						&& BaseCheckUtil.isEmpty(wjByColorPlace10)&& BaseCheckUtil.isEmpty(wjByColorPlace11)&& BaseCheckUtil.isEmpty(wjByColorPlace12)
						&& BaseCheckUtil.isEmpty(wjByColorPlace13)&& BaseCheckUtil.isEmpty(wjByColorPlace14)&& BaseCheckUtil.isEmpty(wjByColorPlace15)
						&& BaseCheckUtil.isEmpty(wjByColorPlace16)) {
					messages.add("E032", "JACKET ボタン付け糸指定");
					jacketFlag = true;
				}
				
				if(BaseCheckUtil.isNotEmpty(wjByColorPlace1)&&BaseCheckUtil.isEmpty(wjByColor1)||BaseCheckUtil.isNotEmpty(wjByColorPlace2)&&BaseCheckUtil.isEmpty(wjByColor2)||
				   BaseCheckUtil.isNotEmpty(wjByColorPlace3)&&BaseCheckUtil.isEmpty(wjByColor3)||BaseCheckUtil.isNotEmpty(wjByColorPlace4)&&BaseCheckUtil.isEmpty(wjByColor4)||
				   BaseCheckUtil.isNotEmpty(wjByColorPlace5)&&BaseCheckUtil.isEmpty(wjByColor5)||BaseCheckUtil.isNotEmpty(wjByColorPlace6)&&BaseCheckUtil.isEmpty(wjByColor6)||
				   BaseCheckUtil.isNotEmpty(wjByColorPlace7)&&BaseCheckUtil.isEmpty(wjByColor7)||BaseCheckUtil.isNotEmpty(wjByColorPlace8)&&BaseCheckUtil.isEmpty(wjByColor8)||
				   BaseCheckUtil.isNotEmpty(wjByColorPlace9)&&BaseCheckUtil.isEmpty(wjByColor9)||BaseCheckUtil.isNotEmpty(wjByColorPlace10)&&BaseCheckUtil.isEmpty(wjByColor10)||
				   BaseCheckUtil.isNotEmpty(wjByColorPlace11)&&BaseCheckUtil.isEmpty(wjByColor11)||BaseCheckUtil.isNotEmpty(wjByColorPlace12)&&BaseCheckUtil.isEmpty(wjByColor12)||
				   BaseCheckUtil.isNotEmpty(wjByColorPlace13)&&BaseCheckUtil.isEmpty(wjByColor13)||BaseCheckUtil.isNotEmpty(wjByColorPlace14)&&BaseCheckUtil.isEmpty(wjByColor14)||
				   BaseCheckUtil.isNotEmpty(wjByColorPlace15)&&BaseCheckUtil.isEmpty(wjByColor15)||BaseCheckUtil.isNotEmpty(wjByColorPlace16)&&BaseCheckUtil.isEmpty(wjByColor16)) {
					messages.add("E032", "JACKET ボタン付け糸指定");
					jacketFlag = true;
				}
			}
		}
		
		//補正
		CoAdjustJacketStandardInfo coAdjustJacketStandardInfo = orderCoForm.getCoAdjustJacketStandardInfo();
		if(coAdjustJacketStandardInfo == null) {
			 messages.add("E031", "JACKETサイズ");
			 jacketFlag = true;
		}else {
			String sizeFigure = coAdjustJacketStandardInfo.getSizeFigure();
			if("".equals(sizeFigure)||null == sizeFigure) {
				messages.add("E031", "JACKETサイズ体型");
				jacketFlag = true;
			}
			String sizeNumber = coAdjustJacketStandardInfo.getSizeNumber();
			if("".equals(sizeNumber)||null == sizeNumber) {
				messages.add("E031", "JACKETサイズ号数");
				jacketFlag = true;
			}
			if(!jacketFlag) {
				if(BaseCheckUtil.isNotEmpty(sizeFigure)&&BaseCheckUtil.isNotEmpty(sizeNumber)) {
					
					String corJkBodySize = coAdjustJacketStandardInfo.getCorJkBodySize();
					if("".equals(corJkBodySize)||"0".equals(corJkBodySize)||corJkBodySize == null) {
						messages.add("E034", "JACKETの着丈修正");
						jacketFlag = true;
					}
					
					String corJkWaistSize = coAdjustJacketStandardInfo.getCorJkWaistSize();
					if("".equals(corJkWaistSize)||"0".equals(corJkWaistSize)||corJkWaistSize == null) {
						messages.add("E034", "JACKETのウエスト修正");
						jacketFlag = true;
					}
					
					String corJkRightsleeveSize = coAdjustJacketStandardInfo.getCorJkRightsleeveSize();
					if("".equals(corJkRightsleeveSize)||"0".equals(corJkRightsleeveSize)||corJkRightsleeveSize == null) {
						messages.add("E034", "JACKETの袖丈右修正");
						jacketFlag = true;
					}
					
					String corJkLeftsleeveSize = coAdjustJacketStandardInfo.getCorJkLeftsleeveSize();
					if("".equals(corJkLeftsleeveSize)||"0".equals(corJkLeftsleeveSize)||corJkLeftsleeveSize == null) {
						messages.add("E034", "JACKETの袖丈左修正");
						jacketFlag = true;
					}
					
					List<TypeSizeOptimization> coJkTypeSizeOptimization = this.getCoJkTypeSizeOptimization(orderCoForm,typeSizeService);
					List<Adjust> jkAdjustList = adjustByItem.get("02");
					if(!jkAdjustList.isEmpty()&&!coJkTypeSizeOptimization.isEmpty()) {
						for (Adjust adjust : jkAdjustList) {
							Map<String, String> jkStandardValue = this
									.getJkStandardValue(coJkTypeSizeOptimization);
							// JACKET_着丈_型サイズ
							String stringCorJkBodylengthSize = jkStandardValue.get("corJkBodylengthSize");
							BigDecimal corJkBodylengthSize = new BigDecimal(stringCorJkBodylengthSize);

							// JACKET_ウエスト_型サイズ
							String stringCorJkWaistSize = jkStandardValue.get("corJkWaistSize");
							BigDecimal corJkWaistlengthSize = new BigDecimal(stringCorJkWaistSize);

							// JACKET_袖丈右_型サイズ
							String stringCorJkRightsleeveSize = jkStandardValue.get("corJkRightsleeveSize");
							BigDecimal corJkRightlengthsleeveSize = new BigDecimal(stringCorJkRightsleeveSize);

							// JACKET_袖丈左_型サイズ
							String stringCorJkLeftsleeveSize = jkStandardValue.get("corJkLeftsleeveSize");
							BigDecimal corJkLeftlengthsleeveSize = new BigDecimal(stringCorJkLeftsleeveSize);

							// JACKET_着丈_グロス
							BigDecimal corJkBodylengthGross = new BigDecimal(
									coAdjustJacketStandardInfo.getCorJkBodyGross());

							// JACKET_ウエスト_グロス
							BigDecimal corJkWaistGross = new BigDecimal(coAdjustJacketStandardInfo.getCorJkWaistGross());

							// JACKET_袖丈右_グロス
							BigDecimal corJkRightsleeveGross = new BigDecimal(
									coAdjustJacketStandardInfo.getCorJkRightsleeveGross());

							// JACKET_袖丈左_グロス
							BigDecimal corJkLeftsleeveGross = new BigDecimal(
									coAdjustJacketStandardInfo.getCorJkLeftsleeveGross());

							if (item.equals(adjust.getItemCode())) {
								if ("02".equals(adjust.getSubItemCode())) {
									// 着丈修正
									if ("01".equals(adjust.getAdjusteClass())) {
										BigDecimal adjusteMax = adjust.getAdjusteMax();
										BigDecimal adjusteMin = adjust.getAdjusteMin();
										BigDecimal addMin = adjusteMin.add(corJkBodylengthSize);
										BigDecimal addMax = adjusteMax.add(corJkBodylengthSize);
										if (corJkBodylengthGross.compareTo(addMin) == -1
												|| corJkBodylengthGross.compareTo(addMax) == 1) {
											messages.add("E035", "JACKETの着丈修正");
											jacketFlag = true;
										}
									}
									// ウエスト修正
									if ("02".equals(adjust.getAdjusteClass())) {
										BigDecimal adjusteMax = adjust.getAdjusteMax();
										BigDecimal adjusteMin = adjust.getAdjusteMin();
										BigDecimal addMin = adjusteMin.add(corJkWaistlengthSize);
										BigDecimal addMax = adjusteMax.add(corJkWaistlengthSize);
										if (corJkWaistGross.compareTo(addMin) == -1
												|| corJkWaistGross.compareTo(addMax) == 1) {
											messages.add("E035", "JACKETのウエスト修正");
											jacketFlag = true;
										}
									}
									// 袖丈右修正
									if ("03".equals(adjust.getAdjusteClass())) {
										BigDecimal adjusteMax = adjust.getAdjusteMax();
										BigDecimal adjusteMin = adjust.getAdjusteMin();
										BigDecimal addMin = adjusteMin.add(corJkRightlengthsleeveSize);
										BigDecimal addMax = adjusteMax.add(corJkRightlengthsleeveSize);
										if (corJkRightsleeveGross.compareTo(addMin) == -1
												|| corJkRightsleeveGross.compareTo(addMax) == 1) {
											messages.add("E035", "JACKETの袖丈右修正");
											jacketFlag = true;
										}
									}
									// 袖丈左修正
									if ("04".equals(adjust.getAdjusteClass())) {
										BigDecimal adjusteMax = adjust.getAdjusteMax();
										BigDecimal adjusteMin = adjust.getAdjusteMin();
										BigDecimal addMin = adjusteMin.add(corJkLeftlengthsleeveSize);
										BigDecimal addMax = adjusteMax.add(corJkLeftlengthsleeveSize);
										if (corJkLeftsleeveGross.compareTo(addMin) == -1
												|| corJkLeftsleeveGross.compareTo(addMax) == 1) {
											messages.add("E035", "JACKETの袖丈左修正");
											jacketFlag = true;
										}
									}
								}
							}
						}
					}
				}	
			}
			
		}
		return jacketFlag;
	}

	/**
	 * JACKETの補正標準値
	 * @param coJkTypeSizeOptimization
	 * @return
	 */
	public Map<String, String> getJkStandardValue(List<TypeSizeOptimization> coJkTypeSizeOptimization) {
		Map<String,String> adjustJkStandardValue = new HashMap<String,String>();
		for(TypeSizeOptimization typeSizeOptimization : coJkTypeSizeOptimization) {
			// 着丈修正
			if("01".equals(typeSizeOptimization.getAdjustClass())) {
				String corJkBodylengthSize = typeSizeOptimization.getTypeSize();
				adjustJkStandardValue.put("corJkBodylengthSize", corJkBodylengthSize);
			}
			// ウエスト修正
			else if("02".equals(typeSizeOptimization.getAdjustClass())) {
				String corJkWaistSize = typeSizeOptimization.getTypeSize();
				adjustJkStandardValue.put("corJkWaistSize", corJkWaistSize);
			}
			// 袖丈右修正
			else if("03".equals(typeSizeOptimization.getAdjustClass())) {
				String corJkRightsleeveSize = typeSizeOptimization.getTypeSize();
				adjustJkStandardValue.put("corJkRightsleeveSize", corJkRightsleeveSize);
			}
			// 袖丈左修正
			else if("04".equals(typeSizeOptimization.getAdjustClass())) {
				String corJkLeftsleeveSize = typeSizeOptimization.getTypeSize();
				adjustJkStandardValue.put("corJkLeftsleeveSize", corJkLeftsleeveSize);
			}
		}
		return adjustJkStandardValue;
	}

	/**
	 * JACKETの標準値取得
	 * @param orderCoForm
	 * @return
	 */
	public List<TypeSizeOptimization> getCoJkTypeSizeOptimization(OrderCoForm orderCoForm , TypeSizeService typeSizeService) {
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

	public void jacketDefaultValue(OrderCoForm orderCoForm) {
		// 標準
		CoOptionJacketStandardInfo optionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
		optionJacketStandardInfo.setOjJacketModel("");
		//フロント釦数
		optionJacketStandardInfo.setOjFrontBtnCnt(OptionCodeKeys.JK_0000101);
		//ラペルデザイン
		optionJacketStandardInfo.setOjLapelDesign(OptionCodeKeys.JK_0000201);
		//グレード
		optionJacketStandardInfo.setOjGrade(OptionCodeKeys.JK_0000301);
		//裏仕様
		optionJacketStandardInfo.setOjGackSpec(OptionCodeKeys.JK_0000401);
		//台場
		optionJacketStandardInfo.setOjFort(OptionCodeKeys.JK_0000501);
		//襟裏（ヒゲ）
		optionJacketStandardInfo.setOjBackCollar(OptionCodeKeys.JK_0000701);
		//襟吊
		optionJacketStandardInfo.setOjChainHange(OptionCodeKeys.JK_0000801);
		//ラペル幅
		optionJacketStandardInfo.setOjLapelWidth(OptionCodeKeys.JK_0000901);
		//フラワーホール
		optionJacketStandardInfo.setOjFlowerHole(OptionCodeKeys.JK_0001001);
		//胸ポケット
		optionJacketStandardInfo.setOjBreastPkt(OptionCodeKeys.JK_0001101);
		//腰ポケット
		optionJacketStandardInfo.setOjWaistPkt(OptionCodeKeys.JK_0001201);
		//チェンジポケット
		optionJacketStandardInfo.setOjChangePkt(OptionCodeKeys.JK_0001301);
		//スランテッドポケット
		optionJacketStandardInfo.setOjSlantedPkt(OptionCodeKeys.JK_0001401);
		//忍びポケット
		optionJacketStandardInfo.setOjCoinPkt(OptionCodeKeys.JK_0001501);
		//袖仕様
		optionJacketStandardInfo.setOjSleeveSpec(OptionCodeKeys.JK_0001601);
		//マニカ
		optionJacketStandardInfo.setOjManica(OptionCodeKeys.JK_0001701);
		//袖釦
		optionJacketStandardInfo.setOjSleeveBtnType(OptionCodeKeys.JK_0001801);
		//袖釦数
		optionJacketStandardInfo.setOjSleeveBtnCnt(OptionCodeKeys.JK_SLEEVE_BTN_CNT4);
		//袖口
		optionJacketStandardInfo.setOjCuffSpec(OptionCodeKeys.JK_0001901);
		//内ポケット変更
		optionJacketStandardInfo.setOjInsidePktChange(OptionCodeKeys.JK_0002001);
		optionJacketStandardInfo.setOjInsidePktPlace(null);
		optionJacketStandardInfo.setOjInsidePktPlace1(null);
		optionJacketStandardInfo.setOjInsidePktPlace2(null);
		optionJacketStandardInfo.setOjInsidePktPlace3(null);
		optionJacketStandardInfo.setOjInsidePktPlace4(null);
		//下前胸内ポケット仕様
		optionJacketStandardInfo.setOjBreastInnerPkt(OptionCodeKeys.JK_0002201);
		//ステッチ種類
		optionJacketStandardInfo.setOjStitch(OptionCodeKeys.JK_0005102);
		//ステッチ箇所変更
		optionJacketStandardInfo.setOjStitchModify(OptionCodeKeys.JK_0002401);
		optionJacketStandardInfo.setOjStitchModifyPlace(null);
		optionJacketStandardInfo.setOjStitchModifyPlace1(null);
		optionJacketStandardInfo.setOjStitchModifyPlace2(null);
		optionJacketStandardInfo.setOjStitchModifyPlace3(null);
		optionJacketStandardInfo.setOjStitchModifyPlace4(null);
		optionJacketStandardInfo.setOjStitchModifyPlace5(null);
		optionJacketStandardInfo.setOjStitchModifyPlace6(null);
		optionJacketStandardInfo.setOjStitchModifyPlace7(null);
		optionJacketStandardInfo.setOjStitchModifyPlace8(null);
		optionJacketStandardInfo.setOjStitchModifyPlace9(null);
		//ダブルステッチ変更
		optionJacketStandardInfo.setOjDStitchModify(OptionCodeKeys.JK_0002601);
		optionJacketStandardInfo.setOjDStitchModifyPlace(null);
		optionJacketStandardInfo.setOjDStitchModifyPlace1(null);
		optionJacketStandardInfo.setOjDStitchModifyPlace2(null);
		optionJacketStandardInfo.setOjDStitchModifyPlace3(null);
		optionJacketStandardInfo.setOjDStitchModifyPlace4(null);
		optionJacketStandardInfo.setOjDStitchModifyPlace5(null);
		optionJacketStandardInfo.setOjDStitchModifyPlace6(null);
		optionJacketStandardInfo.setOjDStitchModifyPlace7(null);
		optionJacketStandardInfo.setOjDStitchModifyPlace8(null);
		optionJacketStandardInfo.setOjDStitchModifyPlace9(null);
		//AMF色指定
		optionJacketStandardInfo.setOjAmfColor(OptionCodeKeys.JK_0002801);
		optionJacketStandardInfo.setOjAmfColorPlace(null);
		optionJacketStandardInfo.setOjAmfColorPlace1(null);
		optionJacketStandardInfo.setOjAmfColorPlace2(null);
		optionJacketStandardInfo.setOjAmfColorPlace3(null);
		optionJacketStandardInfo.setOjAmfColorPlace4(null);
		optionJacketStandardInfo.setOjAmfColorPlace5(null);
		optionJacketStandardInfo.setOjAmfColorPlace6(null);
		optionJacketStandardInfo.setOjAmfColorPlace7(null);
		optionJacketStandardInfo.setOjAmfColorPlace8(null);
		optionJacketStandardInfo.setOjAmfColorPlace9(null);
		optionJacketStandardInfo.setOjAmfColor1(null);
		optionJacketStandardInfo.setOjAmfColor2(null);
		optionJacketStandardInfo.setOjAmfColor3(null);
		optionJacketStandardInfo.setOjAmfColor4(null);
		optionJacketStandardInfo.setOjAmfColor5(null);
		optionJacketStandardInfo.setOjAmfColor6(null);
		optionJacketStandardInfo.setOjAmfColor7(null);
		optionJacketStandardInfo.setOjAmfColor8(null);
		optionJacketStandardInfo.setOjAmfColor9(null);
		optionJacketStandardInfo.setOjAmfAllColor(null);
		//ボタンホール色指定
		optionJacketStandardInfo.setOjBhColor(OptionCodeKeys.JK_0003101);
		optionJacketStandardInfo.setOjBhColorPlace(null);
		optionJacketStandardInfo.setOjBhColorPlace1(null);
		optionJacketStandardInfo.setOjBhColorPlace2(null);
		optionJacketStandardInfo.setOjBhColorPlace3(null);
		optionJacketStandardInfo.setOjBhColorPlace4(null);
		optionJacketStandardInfo.setOjBhColorPlace5(null);
		optionJacketStandardInfo.setOjBhColorPlace6(null);
		optionJacketStandardInfo.setOjBhColorPlace7(null);
		optionJacketStandardInfo.setOjBhColorPlace8(null);
		optionJacketStandardInfo.setOjBhColorPlace9(null);
		optionJacketStandardInfo.setOjBhColorPlace10(null);
		optionJacketStandardInfo.setOjBhColorPlace11(null);
		optionJacketStandardInfo.setOjBhColorPlace12(null);
		optionJacketStandardInfo.setOjBhColorPlace13(null);
		optionJacketStandardInfo.setOjBhColorPlace14(null);
		optionJacketStandardInfo.setOjBhColorPlace15(null);
		optionJacketStandardInfo.setOjBhColorPlace16(null);
		optionJacketStandardInfo.setOjBhColorPlace17(null);
		optionJacketStandardInfo.setOjBhColor1(null);
		optionJacketStandardInfo.setOjBhColor2(null);
		optionJacketStandardInfo.setOjBhColor3(null);
		optionJacketStandardInfo.setOjBhColor4(null);
		optionJacketStandardInfo.setOjBhColor5(null);
		optionJacketStandardInfo.setOjBhColor6(null);
		optionJacketStandardInfo.setOjBhColor7(null);
		optionJacketStandardInfo.setOjBhColor8(null);
		optionJacketStandardInfo.setOjBhColor9(null);
		optionJacketStandardInfo.setOjBhColor10(null);
		optionJacketStandardInfo.setOjBhColor11(null);
		optionJacketStandardInfo.setOjBhColor12(null);
		optionJacketStandardInfo.setOjBhColor13(null);
		optionJacketStandardInfo.setOjBhColor14(null);
		optionJacketStandardInfo.setOjBhColor15(null);
		optionJacketStandardInfo.setOjBhColor16(null);
		optionJacketStandardInfo.setOjBhColor17(null);
		optionJacketStandardInfo.setOjBhAllColor(null);
		//ボタン付け糸指定
		optionJacketStandardInfo.setOjByColor(OptionCodeKeys.JK_0003401);
		optionJacketStandardInfo.setOjByColorPlace(null);
		optionJacketStandardInfo.setOjByColorPlace1(null);
		optionJacketStandardInfo.setOjByColorPlace2(null);
		optionJacketStandardInfo.setOjByColorPlace3(null);
		optionJacketStandardInfo.setOjByColorPlace4(null);
		optionJacketStandardInfo.setOjByColorPlace5(null);
		optionJacketStandardInfo.setOjByColorPlace6(null);
		optionJacketStandardInfo.setOjByColorPlace7(null);
		optionJacketStandardInfo.setOjByColorPlace8(null);
		optionJacketStandardInfo.setOjByColorPlace9(null);
		optionJacketStandardInfo.setOjByColorPlace10(null);
		optionJacketStandardInfo.setOjByColorPlace11(null);
		optionJacketStandardInfo.setOjByColorPlace12(null);
		optionJacketStandardInfo.setOjByColorPlace13(null);
		optionJacketStandardInfo.setOjByColorPlace14(null);
		optionJacketStandardInfo.setOjByColorPlace15(null);
		optionJacketStandardInfo.setOjByColorPlace16(null);
		optionJacketStandardInfo.setOjByColor1(null);
		optionJacketStandardInfo.setOjByColor2(null);
		optionJacketStandardInfo.setOjByColor3(null);
		optionJacketStandardInfo.setOjByColor4(null);
		optionJacketStandardInfo.setOjByColor5(null);
		optionJacketStandardInfo.setOjByColor6(null);
		optionJacketStandardInfo.setOjByColor7(null);
		optionJacketStandardInfo.setOjByColor8(null);
		optionJacketStandardInfo.setOjByColor9(null);
		optionJacketStandardInfo.setOjByColor10(null);
		optionJacketStandardInfo.setOjByColor11(null);
		optionJacketStandardInfo.setOjByColor12(null);
		optionJacketStandardInfo.setOjByColor13(null);
		optionJacketStandardInfo.setOjByColor14(null);
		optionJacketStandardInfo.setOjByColor15(null);
		optionJacketStandardInfo.setOjByColor16(null);
		optionJacketStandardInfo.setOjByAllColor(null);
		//ベント
		optionJacketStandardInfo.setOjVentSpec(OptionCodeKeys.JK_0003701);
		//胴裏素材
		optionJacketStandardInfo.setOjBodyBackMate(OptionCodeKeys.JK_1000100);
		optionJacketStandardInfo.setOjBodyBackMateStkNo(null);
		//袖裏素材
		optionJacketStandardInfo.setOjCuffBackMate(OptionCodeKeys.JK_2000100);
		optionJacketStandardInfo.setOjCuffBackMateStkNo(null);
		//釦素材
		optionJacketStandardInfo.setOjBtnMate(OptionCodeKeys.JK_3000800);
		optionJacketStandardInfo.setOjBtnMateStkNo(null);
		//形状記憶
		optionJacketStandardInfo.setOjShapeMemory(OptionCodeKeys.JK_0004401);

		// タキシード
		CoOptionJacketTuxedoInfo optionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
		optionJacketTuxedoInfo.setTjJacketModel("");
		optionJacketTuxedoInfo.setTjFrontBtnCnt(OptionCodeKeys.JK_0000101);
		optionJacketTuxedoInfo.setTjLapelDesign(OptionCodeKeys.JK_0000201);
		optionJacketTuxedoInfo.setTjGrade(OptionCodeKeys.JK_0000301);
		optionJacketTuxedoInfo.setTjBackSpec(OptionCodeKeys.JK_0000401);
		optionJacketTuxedoInfo.setTjFort(OptionCodeKeys.JK_0000502);
		optionJacketTuxedoInfo.setTjGlossFablic(OptionCodeKeys.JK_0005001);
		optionJacketTuxedoInfo.setTjBackCollar(OptionCodeKeys.JK_0000701);
		optionJacketTuxedoInfo.setTjChainHange(OptionCodeKeys.JK_0000801);
		optionJacketTuxedoInfo.setTjLapelWidth(OptionCodeKeys.JK_0000901);
		optionJacketTuxedoInfo.setTjFlowerHole(OptionCodeKeys.JK_0001001);
		optionJacketTuxedoInfo.setTjBreastPkt(OptionCodeKeys.JK_0001101);
		optionJacketTuxedoInfo.setTjWaistPkt(OptionCodeKeys.JK_0001205);
		optionJacketTuxedoInfo.setTjChangePkt(OptionCodeKeys.JK_0001301);
		optionJacketTuxedoInfo.setTjSlantedPkt(OptionCodeKeys.JK_0001401);
		optionJacketTuxedoInfo.setTjCoinPkt(OptionCodeKeys.JK_0001501);
		optionJacketTuxedoInfo.setTjSleeveSpec(OptionCodeKeys.JK_0001601);
		optionJacketTuxedoInfo.setTjManica(OptionCodeKeys.JK_0001701);
		optionJacketTuxedoInfo.setTjSleeveBtnType(OptionCodeKeys.JK_0001801);
		optionJacketTuxedoInfo.setTjSleeveBtnCnt(OptionCodeKeys.JK_SLEEVE_BTN_CNT4);
		optionJacketTuxedoInfo.setTjCuffSpec(OptionCodeKeys.JK_0001901);
		optionJacketTuxedoInfo.setTjInsidePktChange(OptionCodeKeys.JK_0002001);
		optionJacketTuxedoInfo.setTjBreastInnerPkt(OptionCodeKeys.JK_0002201);
		optionJacketTuxedoInfo.setTjStitch(OptionCodeKeys.JK_0005101);
		optionJacketTuxedoInfo.setTjBhColor(OptionCodeKeys.JK_0003101);
		optionJacketTuxedoInfo.setTjBhColorPlace(null);
		optionJacketTuxedoInfo.setTjBhColorPlace1(null);
		optionJacketTuxedoInfo.setTjBhColorPlace2(null);
		optionJacketTuxedoInfo.setTjBhColorPlace3(null);
		optionJacketTuxedoInfo.setTjBhColorPlace4(null);
		optionJacketTuxedoInfo.setTjBhColorPlace5(null);
		optionJacketTuxedoInfo.setTjBhColorPlace6(null);
		optionJacketTuxedoInfo.setTjBhColorPlace7(null);
		optionJacketTuxedoInfo.setTjBhColorPlace8(null);
		optionJacketTuxedoInfo.setTjBhColorPlace9(null);
		optionJacketTuxedoInfo.setTjBhColorPlace10(null);
		optionJacketTuxedoInfo.setTjBhColorPlace11(null);
		optionJacketTuxedoInfo.setTjBhColorPlace12(null);
		optionJacketTuxedoInfo.setTjBhColorPlace13(null);
		optionJacketTuxedoInfo.setTjBhColorPlace14(null);
		optionJacketTuxedoInfo.setTjBhColorPlace15(null);
		optionJacketTuxedoInfo.setTjBhColorPlace16(null);
		optionJacketTuxedoInfo.setTjBhColorPlace17(null);
		optionJacketTuxedoInfo.setTjBhColor1(null);
		optionJacketTuxedoInfo.setTjBhColor2(null);
		optionJacketTuxedoInfo.setTjBhColor3(null);
		optionJacketTuxedoInfo.setTjBhColor4(null);
		optionJacketTuxedoInfo.setTjBhColor5(null);
		optionJacketTuxedoInfo.setTjBhColor6(null);
		optionJacketTuxedoInfo.setTjBhColor7(null);
		optionJacketTuxedoInfo.setTjBhColor8(null);
		optionJacketTuxedoInfo.setTjBhColor9(null);
		optionJacketTuxedoInfo.setTjBhColor10(null);
		optionJacketTuxedoInfo.setTjBhColor11(null);
		optionJacketTuxedoInfo.setTjBhColor12(null);
		optionJacketTuxedoInfo.setTjBhColor13(null);
		optionJacketTuxedoInfo.setTjBhColor14(null);
		optionJacketTuxedoInfo.setTjBhColor15(null);
		optionJacketTuxedoInfo.setTjBhColor16(null);
		optionJacketTuxedoInfo.setTjBhColor17(null);
		optionJacketTuxedoInfo.setTjAllBhColor(null);
		optionJacketTuxedoInfo.setTjByColor(OptionCodeKeys.JK_0003401);
		optionJacketTuxedoInfo.setTjByColorPlace(null);
		optionJacketTuxedoInfo.setTjByColorPlace1(null);
		optionJacketTuxedoInfo.setTjByColorPlace2(null);
		optionJacketTuxedoInfo.setTjByColorPlace3(null);
		optionJacketTuxedoInfo.setTjByColorPlace4(null);
		optionJacketTuxedoInfo.setTjByColorPlace5(null);
		optionJacketTuxedoInfo.setTjByColorPlace6(null);
		optionJacketTuxedoInfo.setTjByColorPlace7(null);
		optionJacketTuxedoInfo.setTjByColorPlace8(null);
		optionJacketTuxedoInfo.setTjByColorPlace9(null);
		optionJacketTuxedoInfo.setTjByColorPlace10(null);
		optionJacketTuxedoInfo.setTjByColorPlace11(null);
		optionJacketTuxedoInfo.setTjByColorPlace12(null);
		optionJacketTuxedoInfo.setTjByColorPlace13(null);
		optionJacketTuxedoInfo.setTjByColorPlace14(null);
		optionJacketTuxedoInfo.setTjByColorPlace15(null);
		optionJacketTuxedoInfo.setTjByColorPlace16(null);
		optionJacketTuxedoInfo.setTjByColor1(null);
		optionJacketTuxedoInfo.setTjByColor2(null);
		optionJacketTuxedoInfo.setTjByColor3(null);
		optionJacketTuxedoInfo.setTjByColor4(null);
		optionJacketTuxedoInfo.setTjByColor5(null);
		optionJacketTuxedoInfo.setTjByColor6(null);
		optionJacketTuxedoInfo.setTjByColor7(null);
		optionJacketTuxedoInfo.setTjByColor8(null);
		optionJacketTuxedoInfo.setTjByColor9(null);
		optionJacketTuxedoInfo.setTjByColor10(null);
		optionJacketTuxedoInfo.setTjByColor11(null);
		optionJacketTuxedoInfo.setTjByColor12(null);
		optionJacketTuxedoInfo.setTjByColor13(null);
		optionJacketTuxedoInfo.setTjByColor14(null);
		optionJacketTuxedoInfo.setTjByColor15(null);
		optionJacketTuxedoInfo.setTjByColor16(null);
		optionJacketTuxedoInfo.setTjAllByColor(null);
		optionJacketTuxedoInfo.setTjVentSpec(OptionCodeKeys.JK_0003701);
		optionJacketTuxedoInfo.setTjBodyBackMate(OptionCodeKeys.JK_1000100);
		optionJacketTuxedoInfo.setTjBodyBackMateStkNo(null);
		optionJacketTuxedoInfo.setTjCuffBackMate(OptionCodeKeys.JK_2000100);
		optionJacketTuxedoInfo.setTjCuffBackMateStkNo(null);
		optionJacketTuxedoInfo.setTjBtnMate(OptionCodeKeys.JK_3000800);
		optionJacketTuxedoInfo.setTjBtnMateStkNo(null);
		optionJacketTuxedoInfo.setTjShapeMemory(OptionCodeKeys.JK_0004401);

		// ウォッシャブル
		CoOptionJacketWashableInfo optionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
		optionJacketWashableInfo.setWjJacketModel("");
		optionJacketWashableInfo.setWjFrontBtnCnt(OptionCodeKeys.JK_0000101);
		optionJacketWashableInfo.setWjLapelDesign(OptionCodeKeys.JK_0000201);
		optionJacketWashableInfo.setWjGrade(OptionCodeKeys.JK_0000304);
		optionJacketWashableInfo.setWjBackSpec(OptionCodeKeys.JK_0000405);
		optionJacketWashableInfo.setWjFort(OptionCodeKeys.JK_0000503);
		optionJacketWashableInfo.setWjBackCollar(OptionCodeKeys.JK_0000701);
		optionJacketWashableInfo.setWjChainHange(OptionCodeKeys.JK_0000801);
		optionJacketWashableInfo.setWjLapelWidth(OptionCodeKeys.JK_0000901);
		optionJacketWashableInfo.setWjFlowerHole(OptionCodeKeys.JK_0001001);
		optionJacketWashableInfo.setWjBreastPkt(OptionCodeKeys.JK_0001101);
		optionJacketWashableInfo.setWjWaistPkt(OptionCodeKeys.JK_0001201);
		optionJacketWashableInfo.setWjChangePkt(OptionCodeKeys.JK_0001301);
		optionJacketWashableInfo.setWjSlantedPkt(OptionCodeKeys.JK_0001401);
		optionJacketWashableInfo.setWjCoinPkt(OptionCodeKeys.JK_0001501);
		optionJacketWashableInfo.setWjSleeveSpec(OptionCodeKeys.JK_0001601);
		optionJacketWashableInfo.setWjManica(OptionCodeKeys.JK_0001701);
		optionJacketWashableInfo.setWjSleeveBtnType(OptionCodeKeys.JK_0001801);
		optionJacketWashableInfo.setWjSleeveBtnCnt(OptionCodeKeys.JK_SLEEVE_BTN_CNT4);
		optionJacketWashableInfo.setWjCuffSpec(OptionCodeKeys.JK_0001901);
		optionJacketWashableInfo.setWjInsidePktChange(OptionCodeKeys.JK_0002001);
		optionJacketWashableInfo.setWjBreastInnerPkt(OptionCodeKeys.JK_0002201);
		optionJacketWashableInfo.setWjStitch(OptionCodeKeys.JK_0005104);
		optionJacketWashableInfo.setWjStitchModify(OptionCodeKeys.JK_0002401);
		optionJacketWashableInfo.setWjStitchModifyPlace(null);
		optionJacketWashableInfo.setWjStitchModifyPlace1(null);
		optionJacketWashableInfo.setWjStitchModifyPlace2(null);
		optionJacketWashableInfo.setWjStitchModifyPlace3(null);
		optionJacketWashableInfo.setWjStitchModifyPlace4(null);
		optionJacketWashableInfo.setWjStitchModifyPlace5(null);
		optionJacketWashableInfo.setWjStitchModifyPlace6(null);
		optionJacketWashableInfo.setWjStitchModifyPlace7(null);
		optionJacketWashableInfo.setWjStitchModifyPlace8(null);
		optionJacketWashableInfo.setWjStitchModifyPlace9(null);
		optionJacketWashableInfo.setWjDStitchModify(OptionCodeKeys.JK_0002601);
		optionJacketWashableInfo.setWjDStitchModifyPlace(null);
		optionJacketWashableInfo.setWjDStitchModifyPlace1(null);
		optionJacketWashableInfo.setWjDStitchModifyPlace2(null);
		optionJacketWashableInfo.setWjDStitchModifyPlace3(null);
		optionJacketWashableInfo.setWjDStitchModifyPlace4(null);
		optionJacketWashableInfo.setWjDStitchModifyPlace5(null);
		optionJacketWashableInfo.setWjDStitchModifyPlace6(null);
		optionJacketWashableInfo.setWjDStitchModifyPlace7(null);
		optionJacketWashableInfo.setWjDStitchModifyPlace8(null);
		optionJacketWashableInfo.setWjDStitchModifyPlace9(null);
		optionJacketWashableInfo.setWjAmfColor(OptionCodeKeys.JK_0002801);
		optionJacketWashableInfo.setWjAmfColorPlace(null);
		optionJacketWashableInfo.setWjAmfColorPlace1(null);
		optionJacketWashableInfo.setWjAmfColorPlace2(null);
		optionJacketWashableInfo.setWjAmfColorPlace3(null);
		optionJacketWashableInfo.setWjAmfColorPlace4(null);
		optionJacketWashableInfo.setWjAmfColorPlace5(null);
		optionJacketWashableInfo.setWjAmfColorPlace6(null);
		optionJacketWashableInfo.setWjAmfColorPlace7(null);
		optionJacketWashableInfo.setWjAmfColorPlace8(null);
		optionJacketWashableInfo.setWjAmfColorPlace9(null);
		optionJacketWashableInfo.setWjAmfColor1(null);
		optionJacketWashableInfo.setWjAmfColor2(null);
		optionJacketWashableInfo.setWjAmfColor3(null);
		optionJacketWashableInfo.setWjAmfColor4(null);
		optionJacketWashableInfo.setWjAmfColor5(null);
		optionJacketWashableInfo.setWjAmfColor6(null);
		optionJacketWashableInfo.setWjAmfColor7(null);
		optionJacketWashableInfo.setWjAmfColor8(null);
		optionJacketWashableInfo.setWjAmfColor9(null);
		optionJacketWashableInfo.setWjAllAmfColor(null);
		optionJacketWashableInfo.setWjBhColor(OptionCodeKeys.JK_0003101);
		optionJacketWashableInfo.setWjBhColorPlace(null);
		optionJacketWashableInfo.setWjBhColorPlace1(null);
		optionJacketWashableInfo.setWjBhColorPlace2(null);
		optionJacketWashableInfo.setWjBhColorPlace3(null);
		optionJacketWashableInfo.setWjBhColorPlace4(null);
		optionJacketWashableInfo.setWjBhColorPlace5(null);
		optionJacketWashableInfo.setWjBhColorPlace6(null);
		optionJacketWashableInfo.setWjBhColorPlace7(null);
		optionJacketWashableInfo.setWjBhColorPlace8(null);
		optionJacketWashableInfo.setWjBhColorPlace9(null);
		optionJacketWashableInfo.setWjBhColorPlace10(null);
		optionJacketWashableInfo.setWjBhColorPlace12(null);
		optionJacketWashableInfo.setWjBhColorPlace13(null);
		optionJacketWashableInfo.setWjBhColorPlace14(null);
		optionJacketWashableInfo.setWjBhColorPlace15(null);
		optionJacketWashableInfo.setWjBhColorPlace16(null);
		optionJacketWashableInfo.setWjBhColorPlace17(null);
		optionJacketWashableInfo.setWjBhColor1(null);
		optionJacketWashableInfo.setWjBhColor2(null);
		optionJacketWashableInfo.setWjBhColor3(null);
		optionJacketWashableInfo.setWjBhColor4(null);
		optionJacketWashableInfo.setWjBhColor5(null);
		optionJacketWashableInfo.setWjBhColor6(null);
		optionJacketWashableInfo.setWjBhColor7(null);
		optionJacketWashableInfo.setWjBhColor8(null);
		optionJacketWashableInfo.setWjBhColor9(null);
		optionJacketWashableInfo.setWjBhColor10(null);
		optionJacketWashableInfo.setWjBhColor12(null);
		optionJacketWashableInfo.setWjBhColor13(null);
		optionJacketWashableInfo.setWjBhColor14(null);
		optionJacketWashableInfo.setWjBhColor15(null);
		optionJacketWashableInfo.setWjBhColor16(null);
		optionJacketWashableInfo.setWjBhColor17(null);
		optionJacketWashableInfo.setWjAllBhColor(null);
		optionJacketWashableInfo.setWjByColor(OptionCodeKeys.JK_0003401);
		optionJacketWashableInfo.setWjByColorPlace(null);
		optionJacketWashableInfo.setWjByColorPlace1(null);
		optionJacketWashableInfo.setWjByColorPlace2(null);
		optionJacketWashableInfo.setWjByColorPlace3(null);
		optionJacketWashableInfo.setWjByColorPlace4(null);
		optionJacketWashableInfo.setWjByColorPlace5(null);
		optionJacketWashableInfo.setWjByColorPlace6(null);
		optionJacketWashableInfo.setWjByColorPlace7(null);
		optionJacketWashableInfo.setWjByColorPlace8(null);
		optionJacketWashableInfo.setWjByColorPlace9(null);
		optionJacketWashableInfo.setWjByColorPlace10(null);
		optionJacketWashableInfo.setWjByColorPlace11(null);
		optionJacketWashableInfo.setWjByColorPlace12(null);
		optionJacketWashableInfo.setWjByColorPlace13(null);
		optionJacketWashableInfo.setWjByColorPlace14(null);
		optionJacketWashableInfo.setWjByColorPlace15(null);
		optionJacketWashableInfo.setWjByColorPlace16(null);
		optionJacketWashableInfo.setWjByColor1(null);
		optionJacketWashableInfo.setWjByColor2(null);
		optionJacketWashableInfo.setWjByColor3(null);
		optionJacketWashableInfo.setWjByColor4(null);
		optionJacketWashableInfo.setWjByColor5(null);
		optionJacketWashableInfo.setWjByColor6(null);
		optionJacketWashableInfo.setWjByColor7(null);
		optionJacketWashableInfo.setWjByColor8(null);
		optionJacketWashableInfo.setWjByColor9(null);
		optionJacketWashableInfo.setWjByColor10(null);
		optionJacketWashableInfo.setWjByColor11(null);
		optionJacketWashableInfo.setWjByColor12(null);
		optionJacketWashableInfo.setWjByColor13(null);
		optionJacketWashableInfo.setWjByColor14(null);
		optionJacketWashableInfo.setWjByColor15(null);
		optionJacketWashableInfo.setWjByColor16(null);
		optionJacketWashableInfo.setWjAllByColor(null);
		optionJacketWashableInfo.setWjVentSpec(OptionCodeKeys.JK_0003701);
		optionJacketWashableInfo.setWjBodyBackMate(OptionCodeKeys.JK_1000100);
		optionJacketWashableInfo.setWjBodyBackMateStkNo(null);
		optionJacketWashableInfo.setWjCuffBackMate(OptionCodeKeys.JK_2000100);
		optionJacketWashableInfo.setWjCuffBackMateStkNo(null);
		optionJacketWashableInfo.setWjBtnMate(OptionCodeKeys.JK_3000800);
		optionJacketWashableInfo.setWjBtnMateStkNo(null);
		optionJacketWashableInfo.setWjShapeMemory(OptionCodeKeys.JK_0004402);
	}
	
	public void jacketDefaultValueFromDb(OrderCoForm orderCoForm, Order orderJK) {
		String productCategory = orderCoForm.getProductCategory();
		if("9000101".equals(productCategory)) {
			// 標準
			CoOptionJacketStandardInfo optionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
			optionJacketStandardInfo.setOjJacketModel(orderJK.getJkModelCd());
			optionJacketStandardInfo.setOjFrontBtnCnt(orderJK.getJkFrtBtnCd());
			optionJacketStandardInfo.setOjLapelDesign(orderJK.getJkLapelDesignCd());
			optionJacketStandardInfo.setOjGrade(orderJK.getJkGradeCd());
			optionJacketStandardInfo.setOjGackSpec(orderJK.getJkInnerClothCd());
			optionJacketStandardInfo.setOjFort(orderJK.getJkDaibaCd());
			optionJacketStandardInfo.setOjBackCollar(orderJK.getJkCollarInnerCd());
			optionJacketStandardInfo.setOjChainHange(orderJK.getJkCollarHangCd());
			optionJacketStandardInfo.setOjLapelWidth(orderJK.getJkLapelWidthCd());
			optionJacketStandardInfo.setOjFlowerHole(orderJK.getJkFlowerHoleCd());
			optionJacketStandardInfo.setOjBreastPkt(orderJK.getJkBreastPktCd());
			optionJacketStandardInfo.setOjWaistPkt(orderJK.getJkWaistPktCd());
			optionJacketStandardInfo.setOjChangePkt(orderJK.getJkChgPktCd());
			optionJacketStandardInfo.setOjSlantedPkt(orderJK.getJkSlantedPktCd());
			optionJacketStandardInfo.setOjCoinPkt(orderJK.getJkShinobiPktCd());
			optionJacketStandardInfo.setOjSleeveSpec(orderJK.getJkSleeveTypeCd());
			optionJacketStandardInfo.setOjManica(orderJK.getJkManicaCd());
			optionJacketStandardInfo.setOjSleeveBtnType(orderJK.getJkSleeveBtnCd());
			String jkSleeveBtnCd = orderJK.getJkSleeveBtnCd();
			if(BaseCheckUtil.isEmpty(jkSleeveBtnCd)) {
				optionJacketStandardInfo.setOjSleeveBtnCnt(OptionCodeKeys.JK_SLEEVE_BTN_CNT4);
			}else {
				optionJacketStandardInfo.setOjSleeveBtnCnt(String.valueOf(orderJK.getJkSleeveBtnNumber()));
			}
			optionJacketStandardInfo.setOjCuffSpec(orderJK.getJkCuffCd());
			optionJacketStandardInfo.setOjInsidePktChange(orderJK.getJkInnerPktType());
			optionJacketStandardInfo.setOjInsidePktPlace(orderJK.getJkInnerPktCd());
			optionJacketStandardInfo.setOjBreastInnerPkt(orderJK.getJkRightInnerPktTypeCd());
			optionJacketStandardInfo.setOjStitch(orderJK.getJkStitchTypeCd());
			optionJacketStandardInfo.setOjStitchModify(orderJK.getJkStitchPlcType());
			if(OptionCodeKeys.JK_0002401.equals(orderJK.getJkStitchPlcType())) {
				optionJacketStandardInfo.setOjStitchModifyPlace(null);
			}else {
				optionJacketStandardInfo.setOjStitchModifyPlace(orderJK.getJkStitchPlcCd());
			}
			optionJacketStandardInfo.setOjDStitchModify(orderJK.getJkDblstitchPlcType());
			optionJacketStandardInfo.setOjDStitchModifyPlace(orderJK.getJkDblstitchPlcCd());
			optionJacketStandardInfo.setOjAmfColor(orderJK.getJkAmfColorType());
			optionJacketStandardInfo.setOjAmfColorPlace(orderJK.getJkAmfColorPlcCd());
			optionJacketStandardInfo.setOjAmfAllColor(orderJK.getJkAmfColorCd());
			optionJacketStandardInfo.setOjBhColor(orderJK.getJkBtnholeColorType());
			optionJacketStandardInfo.setOjBhColorPlace(orderJK.getJkBtnholeColorPlcCd());
			optionJacketStandardInfo.setOjBhAllColor(orderJK.getJkBtnholeColorCd());
			optionJacketStandardInfo.setOjByColor(orderJK.getJkBtnthreadColorType());
			optionJacketStandardInfo.setOjByColorPlace(orderJK.getJkBtnthreadColorPlcCd());
			optionJacketStandardInfo.setOjByAllColor(orderJK.getJkBtnthreadColorCd());
			optionJacketStandardInfo.setOjVentSpec(orderJK.getJkVentCd());
			optionJacketStandardInfo.setOjBodyBackMate(orderJK.getJkInnerBodyClothType());
			optionJacketStandardInfo.setOjBodyBackMateStkNo(orderJK.getJkInnerBodyClothCd());
			optionJacketStandardInfo.setOjCuffBackMate(orderJK.getJkInnerSleeveClothType());
			optionJacketStandardInfo.setOjCuffBackMateStkNo(orderJK.getJkInnerSleeveClothCd());
			optionJacketStandardInfo.setOjBtnMate(orderJK.getJkBtnMaterialType());
			optionJacketStandardInfo.setOjBtnMateStkNo(orderJK.getJkBtnMaterialCd());
			optionJacketStandardInfo.setOjShapeMemory(orderJK.getJkShapeMemoryCd());
			
			pluralJkStandardOptionItem(optionJacketStandardInfo,orderJK);
			
		}else if("9000102".equals(productCategory)) {
			// タキシード
			CoOptionJacketTuxedoInfo optionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
			optionJacketTuxedoInfo.setTjJacketModel(orderJK.getJkModelCd());
			optionJacketTuxedoInfo.setTjFrontBtnCnt(orderJK.getJkFrtBtnCd());
			optionJacketTuxedoInfo.setTjLapelDesign(orderJK.getJkLapelDesignCd());
			optionJacketTuxedoInfo.setTjGrade(orderJK.getJkGradeCd());
			optionJacketTuxedoInfo.setTjBackSpec(orderJK.getJkInnerClothCd());
			optionJacketTuxedoInfo.setTjFort(orderJK.getJkDaibaCd());
			optionJacketTuxedoInfo.setTjGlossFablic(orderJK.getJkLookClothCd());
			optionJacketTuxedoInfo.setTjBackCollar(orderJK.getJkCollarInnerCd());
			optionJacketTuxedoInfo.setTjChainHange(orderJK.getJkCollarHangCd());
			optionJacketTuxedoInfo.setTjLapelWidth(orderJK.getJkLapelWidthCd());
			optionJacketTuxedoInfo.setTjFlowerHole(orderJK.getJkFlowerHoleCd());
			optionJacketTuxedoInfo.setTjBreastPkt(orderJK.getJkBreastPktCd());
			optionJacketTuxedoInfo.setTjWaistPkt(orderJK.getJkWaistPktCd());
			optionJacketTuxedoInfo.setTjChangePkt(orderJK.getJkChgPktCd());
			optionJacketTuxedoInfo.setTjSlantedPkt(orderJK.getJkSlantedPktCd());
			optionJacketTuxedoInfo.setTjCoinPkt(orderJK.getJkShinobiPktCd());
			optionJacketTuxedoInfo.setTjSleeveSpec(orderJK.getJkSleeveTypeCd());
			optionJacketTuxedoInfo.setTjManica(orderJK.getJkManicaCd());
			optionJacketTuxedoInfo.setTjSleeveBtnType(orderJK.getJkSleeveBtnCd());
			String jkSleeveBtnCd = orderJK.getJkSleeveBtnCd();
			if(BaseCheckUtil.isEmpty(jkSleeveBtnCd)) {
				optionJacketTuxedoInfo.setTjSleeveBtnCnt(OptionCodeKeys.JK_SLEEVE_BTN_CNT4);
			}else {
				optionJacketTuxedoInfo.setTjSleeveBtnCnt(String.valueOf(orderJK.getJkSleeveBtnNumber()));
			}
			optionJacketTuxedoInfo.setTjCuffSpec(orderJK.getJkCuffCd());
			optionJacketTuxedoInfo.setTjInsidePktChange(orderJK.getJkInnerPktType());
			optionJacketTuxedoInfo.setTjBreastInnerPkt(orderJK.getJkRightInnerPktTypeCd());
			optionJacketTuxedoInfo.setTjStitch(orderJK.getJkStitchTypeCd());
			optionJacketTuxedoInfo.setTjBhColor(orderJK.getJkBtnholeColorType());
			optionJacketTuxedoInfo.setTjBhColorPlace(orderJK.getJkBtnholeColorPlcCd());
			optionJacketTuxedoInfo.setTjAllBhColor(orderJK.getJkBtnholeColorCd());
			optionJacketTuxedoInfo.setTjByColor(orderJK.getJkBtnthreadColorType());
			optionJacketTuxedoInfo.setTjByColorPlace(orderJK.getJkBtnthreadColorPlcCd());
			optionJacketTuxedoInfo.setTjAllByColor(orderJK.getJkBtnthreadColorCd());
			optionJacketTuxedoInfo.setTjVentSpec(orderJK.getJkVentCd());
			optionJacketTuxedoInfo.setTjBodyBackMate(orderJK.getJkInnerBodyClothType());
			optionJacketTuxedoInfo.setTjCuffBackMate(orderJK.getJkInnerSleeveClothType());
			optionJacketTuxedoInfo.setTjBtnMate(orderJK.getJkBtnMaterialType());
			optionJacketTuxedoInfo.setTjBodyBackMateStkNo(orderJK.getJkInnerBodyClothCd());
			optionJacketTuxedoInfo.setTjCuffBackMateStkNo(orderJK.getJkInnerSleeveClothCd());
			optionJacketTuxedoInfo.setTjBtnMateStkNo(orderJK.getJkBtnMaterialCd());
			optionJacketTuxedoInfo.setTjShapeMemory(orderJK.getJkShapeMemoryCd());
			
			pluralJkTuxedoOptionItem(optionJacketTuxedoInfo,orderJK);
		}else if("9000103".equals(productCategory)) {
			// ウォッシャブル
			CoOptionJacketWashableInfo optionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
			optionJacketWashableInfo.setWjJacketModel(orderJK.getJkModelCd());
			optionJacketWashableInfo.setWjFrontBtnCnt(orderJK.getJkFrtBtnCd());
			optionJacketWashableInfo.setWjLapelDesign(orderJK.getJkLapelDesignCd());
			optionJacketWashableInfo.setWjGrade(orderJK.getJkGradeCd());
			optionJacketWashableInfo.setWjBackSpec(orderJK.getJkInnerClothCd());
			optionJacketWashableInfo.setWjFort(orderJK.getJkDaibaCd());
			optionJacketWashableInfo.setWjBackCollar(orderJK.getJkCollarInnerCd());
			optionJacketWashableInfo.setWjChainHange(orderJK.getJkCollarHangCd());
			optionJacketWashableInfo.setWjLapelWidth(orderJK.getJkLapelWidthCd());
			optionJacketWashableInfo.setWjFlowerHole(orderJK.getJkFlowerHoleCd());
			optionJacketWashableInfo.setWjBreastPkt(orderJK.getJkBreastPktCd());
			optionJacketWashableInfo.setWjWaistPkt(orderJK.getJkWaistPktCd());
			optionJacketWashableInfo.setWjChangePkt(orderJK.getJkChgPktCd());
			optionJacketWashableInfo.setWjSlantedPkt(orderJK.getJkSlantedPktCd());
			optionJacketWashableInfo.setWjCoinPkt(orderJK.getJkShinobiPktCd());
			optionJacketWashableInfo.setWjSleeveSpec(orderJK.getJkSleeveTypeCd());
			optionJacketWashableInfo.setWjManica(orderJK.getJkManicaCd());
			optionJacketWashableInfo.setWjSleeveBtnType(orderJK.getJkSleeveBtnCd());
			String jkSleeveBtnCd = orderJK.getJkSleeveBtnCd();
			if(BaseCheckUtil.isEmpty(jkSleeveBtnCd)) {
				optionJacketWashableInfo.setWjSleeveBtnCnt(OptionCodeKeys.JK_SLEEVE_BTN_CNT4);
			}else {
				optionJacketWashableInfo.setWjSleeveBtnCnt(String.valueOf(orderJK.getJkSleeveBtnNumber()));
			}
			optionJacketWashableInfo.setWjCuffSpec(orderJK.getJkCuffCd());
			optionJacketWashableInfo.setWjInsidePktChange(orderJK.getJkInnerPktType());
			optionJacketWashableInfo.setWjBreastInnerPkt(orderJK.getJkRightInnerPktTypeCd());
			optionJacketWashableInfo.setWjStitch(orderJK.getJkStitchTypeCd());
			optionJacketWashableInfo.setWjStitchModify(orderJK.getJkStitchPlcType());
			if(OptionCodeKeys.JK_0002401.equals(orderJK.getJkStitchPlcType())) {
				optionJacketWashableInfo.setWjStitchModifyPlace(null);
			}else {
				optionJacketWashableInfo.setWjStitchModifyPlace(orderJK.getJkStitchPlcCd());
			}
			optionJacketWashableInfo.setWjDStitchModify(orderJK.getJkDblstitchPlcType());
			optionJacketWashableInfo.setWjDStitchModifyPlace(orderJK.getJkDblstitchPlcCd());
			optionJacketWashableInfo.setWjAmfColor(orderJK.getJkAmfColorType());
			optionJacketWashableInfo.setWjAmfColorPlace(orderJK.getJkAmfColorPlcCd());
			optionJacketWashableInfo.setWjAllAmfColor(orderJK.getJkAmfColorCd());
			optionJacketWashableInfo.setWjBhColor(orderJK.getJkBtnholeColorType());
			optionJacketWashableInfo.setWjBhColorPlace(orderJK.getJkBtnholeColorPlcCd());
			optionJacketWashableInfo.setWjAllBhColor(orderJK.getJkBtnholeColorCd());
			optionJacketWashableInfo.setWjByColor(orderJK.getJkBtnthreadColorType());
			optionJacketWashableInfo.setWjByColorPlace(orderJK.getJkBtnthreadColorPlcCd());
			optionJacketWashableInfo.setWjAllByColor(orderJK.getJkBtnthreadColorCd());
			optionJacketWashableInfo.setWjVentSpec(orderJK.getJkVentCd());
			optionJacketWashableInfo.setWjBodyBackMate(orderJK.getJkInnerBodyClothType());
			optionJacketWashableInfo.setWjCuffBackMate(orderJK.getJkInnerSleeveClothType());
			optionJacketWashableInfo.setWjBtnMate(orderJK.getJkBtnMaterialType());
			optionJacketWashableInfo.setWjBtnMateStkNo(orderJK.getJkBtnMaterialCd());
			optionJacketWashableInfo.setWjBodyBackMateStkNo(orderJK.getJkInnerBodyClothCd());
			optionJacketWashableInfo.setWjCuffBackMateStkNo(orderJK.getJkInnerSleeveClothCd());
			optionJacketWashableInfo.setWjShapeMemory(orderJK.getJkShapeMemoryCd());
			
			pluralJkWashableOptionItem(optionJacketWashableInfo,orderJK);
		}
		
	}

	private void pluralJkWashableOptionItem(CoOptionJacketWashableInfo optionJacketWashableInfo, Order orderJK) {
		String regex = "/";
		
		//ステッチ箇所変更
		String jkStitchPlcCd = orderJK.getJkStitchPlcCd();
		if (jkStitchPlcCd != null && !"".equals(jkStitchPlcCd) &&!OptionCodeKeys.JK_0002401.equals(orderJK.getJkStitchPlcType())) {
			String[] jkStitchPlcSplit = jkStitchPlcCd.split(regex);
			for (String stitchPlcCode : jkStitchPlcSplit) {
				if("0002501".equals(stitchPlcCode)) {
					optionJacketWashableInfo.setWjStitchModifyPlace1(stitchPlcCode);
				}else if("0002502".equals(stitchPlcCode)) {
					optionJacketWashableInfo.setWjStitchModifyPlace2(stitchPlcCode);
				}else if("0002503".equals(stitchPlcCode)) {
					optionJacketWashableInfo.setWjStitchModifyPlace3(stitchPlcCode);
				}else if("0002504".equals(stitchPlcCode)) {
					optionJacketWashableInfo.setWjStitchModifyPlace4(stitchPlcCode);
				}else if("0002505".equals(stitchPlcCode)) {
					optionJacketWashableInfo.setWjStitchModifyPlace5(stitchPlcCode);
				}else if("0002507".equals(stitchPlcCode)) {
					optionJacketWashableInfo.setWjStitchModifyPlace6(stitchPlcCode);
				}else if("0002508".equals(stitchPlcCode)) {
					optionJacketWashableInfo.setWjStitchModifyPlace7(stitchPlcCode);
				}else if("0002509".equals(stitchPlcCode)) {
					optionJacketWashableInfo.setWjStitchModifyPlace8(stitchPlcCode);
				}else if("0002510".equals(stitchPlcCode)) {
					optionJacketWashableInfo.setWjStitchModifyPlace9(stitchPlcCode);
				}
			}
		}
		
		//ダブルステッチ変更
		String jkDblstitchPlcCd = orderJK.getJkDblstitchPlcCd();
		if (jkDblstitchPlcCd != null && !"".equals(jkDblstitchPlcCd)/* &&!jkDblstitchPlcCd.startsWith(regex) */) {
			String[] jkDblstitchPlcSplit = jkDblstitchPlcCd.split(regex);
			for (String dblstitchPlcCode : jkDblstitchPlcSplit) {
				if("0002701".equals(dblstitchPlcCode)) {
					optionJacketWashableInfo.setWjDStitchModifyPlace1(dblstitchPlcCode);
				}else if("0002702".equals(dblstitchPlcCode)) {
					optionJacketWashableInfo.setWjDStitchModifyPlace2(dblstitchPlcCode);
				}else if("0002703".equals(dblstitchPlcCode)) {
					optionJacketWashableInfo.setWjDStitchModifyPlace3(dblstitchPlcCode);
				}else if("0002705".equals(dblstitchPlcCode)) {
					optionJacketWashableInfo.setWjDStitchModifyPlace4(dblstitchPlcCode);
				}else if("0002707".equals(dblstitchPlcCode)) {
					optionJacketWashableInfo.setWjDStitchModifyPlace5(dblstitchPlcCode);
				}else if("0002708".equals(dblstitchPlcCode)) {
					optionJacketWashableInfo.setWjDStitchModifyPlace6(dblstitchPlcCode);
				}else if("0002709".equals(dblstitchPlcCode)) {
					optionJacketWashableInfo.setWjDStitchModifyPlace7(dblstitchPlcCode);
				}else if("0002710".equals(dblstitchPlcCode)) {
					optionJacketWashableInfo.setWjDStitchModifyPlace8(dblstitchPlcCode);
				}
			}
		}
		
		//AMF色指定
		String jkAmfColorPlcCd = orderJK.getJkAmfColorPlcCd();
		String jkAmfColorCd = orderJK.getJkAmfColorCd();
		if(jkAmfColorPlcCd!=null && !"".equals(jkAmfColorPlcCd) && jkAmfColorCd !=null && !"".equals(jkAmfColorCd)
		/* &&!jkAmfColorPlcCd.startsWith(regex)&&!jkAmfColorCd.startsWith(regex) */) {
			String[] jkAmfColorPlcSplit = jkAmfColorPlcCd.split(regex);
			String[] jkAmfColorSplit = jkAmfColorCd.split(regex);
			jkAmfColorSplit = BaseCheckUtil.placeColorMethod(jkAmfColorPlcSplit.length,jkAmfColorSplit);
			for (int i = 0;i<jkAmfColorPlcSplit.length;i++) {
				if("0002901".equals(jkAmfColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjAmfColorPlace1(jkAmfColorPlcSplit[i]);
					optionJacketWashableInfo.setWjAmfColor1(jkAmfColorSplit[i]);
				}else if("0002902".equals(jkAmfColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjAmfColorPlace2(jkAmfColorPlcSplit[i]);
					optionJacketWashableInfo.setWjAmfColor2(jkAmfColorSplit[i]);
				}else if("0002903".equals(jkAmfColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjAmfColorPlace3(jkAmfColorPlcSplit[i]);
					optionJacketWashableInfo.setWjAmfColor3(jkAmfColorSplit[i]);
				}else if("0002904".equals(jkAmfColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjAmfColorPlace4(jkAmfColorPlcSplit[i]);
					optionJacketWashableInfo.setWjAmfColor4(jkAmfColorSplit[i]);
				}else if("0002905".equals(jkAmfColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjAmfColorPlace5(jkAmfColorPlcSplit[i]);
					optionJacketWashableInfo.setWjAmfColor5(jkAmfColorSplit[i]);
				}else if("0002907".equals(jkAmfColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjAmfColorPlace6(jkAmfColorPlcSplit[i]);
					optionJacketWashableInfo.setWjAmfColor6(jkAmfColorSplit[i]);
				}else if("0002908".equals(jkAmfColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjAmfColorPlace7(jkAmfColorPlcSplit[i]);
					optionJacketWashableInfo.setWjAmfColor7(jkAmfColorSplit[i]);
				}else if("0002909".equals(jkAmfColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjAmfColorPlace8(jkAmfColorPlcSplit[i]);
					optionJacketWashableInfo.setWjAmfColor8(jkAmfColorSplit[i]);
				}else if("0002910".equals(jkAmfColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjAmfColorPlace9(jkAmfColorPlcSplit[i]);
					optionJacketWashableInfo.setWjAmfColor9(jkAmfColorSplit[i]);
				}
			}
		}
		
		//ボタンホール色指定
		String jkBtnholeColorPlcCd = orderJK.getJkBtnholeColorPlcCd();
		String jkBtnholeColorCd = orderJK.getJkBtnholeColorCd();
		if(!"".equals(jkBtnholeColorPlcCd)&&jkBtnholeColorPlcCd!=null&&!"".equals(jkBtnholeColorCd)&&jkBtnholeColorCd!=null
		/*
		 * &&!jkBtnholeColorPlcCd.startsWith(regex)&&!jkBtnholeColorCd.startsWith(regex)
		 */) {
			String[] jkBtnholeColorPlcSplit = jkBtnholeColorPlcCd.split(regex);
			String[] jkBtnholeColorSplit = jkBtnholeColorCd.split(regex);
			jkBtnholeColorSplit = BaseCheckUtil.placeColorMethod(jkBtnholeColorPlcSplit.length,jkBtnholeColorSplit);
			for (int i = 0; i < jkBtnholeColorPlcSplit.length; i++) {
				if("0003201".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace1(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor1(jkBtnholeColorSplit[i]);
				}else if("0003202".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace2(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor2(jkBtnholeColorSplit[i]);
				}else if("0003203".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace3(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor3(jkBtnholeColorSplit[i]);
				}else if("0003204".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace4(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor4(jkBtnholeColorSplit[i]);
				}else if("0003205".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace5(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor5(jkBtnholeColorSplit[i]);
				}else if("0003206".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace6(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor6(jkBtnholeColorSplit[i]);
				}else if("0003207".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace7(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor7(jkBtnholeColorSplit[i]);
				}else if("0003208".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace8(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor8(jkBtnholeColorSplit[i]);
				}else if("0003209".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace9(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor9(jkBtnholeColorSplit[i]);
				}else if("0003210".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace10(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor10(jkBtnholeColorSplit[i]);
				}else if("0003211".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace11(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor11(jkBtnholeColorSplit[i]);
				}else if("0003212".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace12(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor12(jkBtnholeColorSplit[i]);
				}else if("0003213".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace13(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor13(jkBtnholeColorSplit[i]);
				}else if("0003214".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace14(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor14(jkBtnholeColorSplit[i]);
				}else if("0003215".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace15(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor15(jkBtnholeColorSplit[i]);
				}else if("0003216".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace16(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor16(jkBtnholeColorSplit[i]);
				}else if("0003217".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjBhColorPlace17(jkBtnholeColorPlcSplit[i]);
					optionJacketWashableInfo.setWjBhColor17(jkBtnholeColorSplit[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String jkBtnthreadColorPlcCd = orderJK.getJkBtnthreadColorPlcCd();
		String jkBtnthreadColorCd = orderJK.getJkBtnthreadColorCd();
		if(!"".equals(jkBtnthreadColorPlcCd)&&jkBtnthreadColorPlcCd!=null&&!"".equals(jkBtnthreadColorCd)&&jkBtnthreadColorCd!=null
		/*
		 * &&!jkBtnthreadColorPlcCd.startsWith(regex)&&!jkBtnthreadColorCd.startsWith(
		 * regex)
		 */) {
			String[] jkBtnthreadColorPlcSplit = jkBtnthreadColorPlcCd.split(regex);
			String[] jkBtnthreadColorSplit = jkBtnthreadColorCd.split(regex);
			jkBtnthreadColorSplit = BaseCheckUtil.placeColorMethod(jkBtnthreadColorPlcSplit.length,jkBtnthreadColorSplit);
			for (int i = 0; i < jkBtnthreadColorPlcSplit.length; i++) {
				if("0003501".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace1(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor1(jkBtnthreadColorSplit[i]);
				}else if("0003502".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace2(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor2(jkBtnthreadColorSplit[i]);
				}else if("0003503".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace3(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor3(jkBtnthreadColorSplit[i]);
				}else if("0003504".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace4(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor4(jkBtnthreadColorSplit[i]);
				}else if("0003505".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace5(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor5(jkBtnthreadColorSplit[i]);
				}else if("0003506".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace6(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor6(jkBtnthreadColorSplit[i]);
				}else if("0003507".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace7(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor7(jkBtnthreadColorSplit[i]);
				}else if("0003508".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace8(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor8(jkBtnthreadColorSplit[i]);
				}else if("0003509".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace9(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor9(jkBtnthreadColorSplit[i]);
				}else if("0003510".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace10(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor10(jkBtnthreadColorSplit[i]);
				}else if("0003511".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace11(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor11(jkBtnthreadColorSplit[i]);
				}else if("0003512".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace12(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor12(jkBtnthreadColorSplit[i]);
				}else if("0003513".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace13(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor13(jkBtnthreadColorSplit[i]);
				}else if("0003514".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace14(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor14(jkBtnthreadColorSplit[i]);
				}else if("0003515".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace15(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor15(jkBtnthreadColorSplit[i]);
				}else if("0003516".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketWashableInfo.setWjByColorPlace16(jkBtnthreadColorPlcSplit[i]);
					optionJacketWashableInfo.setWjByColor16(jkBtnthreadColorSplit[i]);
				}
			}
		}
	}

	private void pluralJkTuxedoOptionItem(CoOptionJacketTuxedoInfo optionJacketTuxedoInfo, Order orderJK) {
		String regex = "/";
		// ボタンホール色指定
		String jkBtnholeColorPlcCd = orderJK.getJkBtnholeColorPlcCd();
		String jkBtnholeColorCd = orderJK.getJkBtnholeColorCd();
		if (!"".equals(jkBtnholeColorPlcCd) && jkBtnholeColorPlcCd != null && !"".equals(jkBtnholeColorCd)
				&& jkBtnholeColorCd != null/*
											 * &&!jkBtnholeColorPlcCd.startsWith(regex)&&!jkBtnholeColorCd.startsWith(
											 * regex)
											 */) {
			String[] jkBtnholeColorPlcSplit = jkBtnholeColorPlcCd.split(regex);
			String[] jkBtnholeColorSplit = jkBtnholeColorCd.split(regex);
			jkBtnholeColorSplit = BaseCheckUtil.placeColorMethod(jkBtnholeColorPlcSplit.length,jkBtnholeColorSplit);
			for (int i = 0; i < jkBtnholeColorPlcSplit.length; i++) {
				if ("0003201".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace1(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor1(jkBtnholeColorSplit[i]);
				} else if ("0003202".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace2(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor2(jkBtnholeColorSplit[i]);
				} else if ("0003203".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace3(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor3(jkBtnholeColorSplit[i]);
				} else if ("0003204".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace4(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor4(jkBtnholeColorSplit[i]);
				} else if ("0003205".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace5(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor5(jkBtnholeColorSplit[i]);
				} else if ("0003206".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace6(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor6(jkBtnholeColorSplit[i]);
				} else if ("0003207".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace7(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor7(jkBtnholeColorSplit[i]);
				} else if ("0003208".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace8(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor8(jkBtnholeColorSplit[i]);
				} else if ("0003209".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace9(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor9(jkBtnholeColorSplit[i]);
				} else if ("0003210".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace10(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor10(jkBtnholeColorSplit[i]);
				} else if ("0003211".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace11(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor11(jkBtnholeColorSplit[i]);
				} else if ("0003212".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace12(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor12(jkBtnholeColorSplit[i]);
				} else if ("0003213".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace13(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor13(jkBtnholeColorSplit[i]);
				} else if ("0003214".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace14(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor14(jkBtnholeColorSplit[i]);
				} else if ("0003215".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace15(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor15(jkBtnholeColorSplit[i]);
				} else if ("0003216".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace16(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor16(jkBtnholeColorSplit[i]);
				} else if ("0003217".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjBhColorPlace17(jkBtnholeColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjBhColor17(jkBtnholeColorSplit[i]);
				}
			}
		}

		// ボタン付け糸指定
		String jkBtnthreadColorPlcCd = orderJK.getJkBtnthreadColorPlcCd();
		String jkBtnthreadColorCd = orderJK.getJkBtnthreadColorCd();
		if (!"".equals(jkBtnthreadColorPlcCd) && jkBtnthreadColorPlcCd != null && !"".equals(jkBtnthreadColorCd)
				&& jkBtnthreadColorCd != null/*
												 * &&!jkBtnthreadColorPlcCd.startsWith(regex)&&!jkBtnthreadColorCd.
												 * startsWith(regex)
												 */) {
			String[] jkBtnthreadColorPlcSplit = jkBtnthreadColorPlcCd.split(regex);
			String[] jkBtnthreadColorSplit = jkBtnthreadColorCd.split(regex);
			jkBtnthreadColorSplit = BaseCheckUtil.placeColorMethod(jkBtnthreadColorPlcSplit.length,jkBtnthreadColorSplit);
			for (int i = 0; i < jkBtnthreadColorPlcSplit.length; i++) {
				if ("0003501".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace1(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor1(jkBtnthreadColorSplit[i]);
				} else if ("0003502".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace2(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor2(jkBtnthreadColorSplit[i]);
				} else if ("0003503".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace3(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor3(jkBtnthreadColorSplit[i]);
				} else if ("0003504".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace4(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor4(jkBtnthreadColorSplit[i]);
				} else if ("0003505".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace5(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor5(jkBtnthreadColorSplit[i]);
				} else if ("0003506".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace6(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor6(jkBtnthreadColorSplit[i]);
				} else if ("0003507".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace7(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor7(jkBtnthreadColorSplit[i]);
				} else if ("0003508".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace8(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor8(jkBtnthreadColorSplit[i]);
				} else if ("0003509".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace9(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor9(jkBtnthreadColorSplit[i]);
				} else if ("0003510".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace10(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor10(jkBtnthreadColorSplit[i]);
				} else if ("0003511".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace11(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor11(jkBtnthreadColorSplit[i]);
				} else if ("0003512".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace12(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor12(jkBtnthreadColorSplit[i]);
				} else if ("0003513".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace13(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor13(jkBtnthreadColorSplit[i]);
				} else if ("0003514".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace14(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor14(jkBtnthreadColorSplit[i]);
				} else if ("0003515".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace15(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor15(jkBtnthreadColorSplit[i]);
				} else if ("0003516".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketTuxedoInfo.setTjByColorPlace16(jkBtnthreadColorPlcSplit[i]);
					optionJacketTuxedoInfo.setTjByColor16(jkBtnthreadColorSplit[i]);
				}
			}
		}
	}

	private void pluralJkStandardOptionItem(CoOptionJacketStandardInfo optionJacketStandardInfo, Order orderJK) {
		String regex = "/";
		//内ポケット変更
		String jkInnerPktCd = orderJK.getJkInnerPktCd();
		if (jkInnerPktCd != null && !"".equals(jkInnerPktCd)/* &&!jkInnerPktCd.startsWith(regex) */) {
			String[] jkInnerPktSplit = jkInnerPktCd.split(regex);
			for (String innerPktCode : jkInnerPktSplit) {
				if("0002101".equals(innerPktCode)) {
					optionJacketStandardInfo.setOjInsidePktPlace1(innerPktCode);
				}else if("0002102".equals(innerPktCode)) {
					optionJacketStandardInfo.setOjInsidePktPlace2(innerPktCode);
				}else if("0002103".equals(innerPktCode)) {
					optionJacketStandardInfo.setOjInsidePktPlace3(innerPktCode);
				}else if("0002104".equals(innerPktCode)) {
					optionJacketStandardInfo.setOjInsidePktPlace4(innerPktCode);
				}
			}
		}
		
		//ステッチ箇所変更
		String jkStitchPlcCd = orderJK.getJkStitchPlcCd();
		if (jkStitchPlcCd != null && !"".equals(jkStitchPlcCd) && !OptionCodeKeys.JK_0002401.equals(orderJK.getJkStitchPlcType())) {
			String[] jkStitchPlcSplit = jkStitchPlcCd.split(regex);
			for (String stitchPlcCode : jkStitchPlcSplit) {
				if("0002501".equals(stitchPlcCode)) {
					optionJacketStandardInfo.setOjStitchModifyPlace1(stitchPlcCode);
				}else if("0002502".equals(stitchPlcCode)) {
					optionJacketStandardInfo.setOjStitchModifyPlace2(stitchPlcCode);
				}else if("0002503".equals(stitchPlcCode)) {
					optionJacketStandardInfo.setOjStitchModifyPlace3(stitchPlcCode);
				}else if("0002504".equals(stitchPlcCode)) {
					optionJacketStandardInfo.setOjStitchModifyPlace4(stitchPlcCode);
				}else if("0002505".equals(stitchPlcCode)) {
					optionJacketStandardInfo.setOjStitchModifyPlace5(stitchPlcCode);
				}else if("0002507".equals(stitchPlcCode)) {
					optionJacketStandardInfo.setOjStitchModifyPlace6(stitchPlcCode);
				}else if("0002508".equals(stitchPlcCode)) {
					optionJacketStandardInfo.setOjStitchModifyPlace7(stitchPlcCode);
				}else if("0002509".equals(stitchPlcCode)) {
					optionJacketStandardInfo.setOjStitchModifyPlace8(stitchPlcCode);
				}else if("0002510".equals(stitchPlcCode)) {
					optionJacketStandardInfo.setOjStitchModifyPlace9(stitchPlcCode);
				}
			}
		}
		
		//ダブルステッチ変更
		String jkDblstitchPlcCd = orderJK.getJkDblstitchPlcCd();
		if (jkDblstitchPlcCd != null && !"".equals(jkDblstitchPlcCd)/* &&!jkDblstitchPlcCd.startsWith(regex) */) {
			String[] jkDblstitchPlcSplit = jkDblstitchPlcCd.split(regex);
			for (String dblstitchPlcCode : jkDblstitchPlcSplit) {
				if("0002701".equals(dblstitchPlcCode)) {
					optionJacketStandardInfo.setOjDStitchModifyPlace1(dblstitchPlcCode);
				}else if("0002702".equals(dblstitchPlcCode)) {
					optionJacketStandardInfo.setOjDStitchModifyPlace2(dblstitchPlcCode);
				}else if("0002703".equals(dblstitchPlcCode)) {
					optionJacketStandardInfo.setOjDStitchModifyPlace3(dblstitchPlcCode);
				}else if("0002705".equals(dblstitchPlcCode)) {
					optionJacketStandardInfo.setOjDStitchModifyPlace4(dblstitchPlcCode);
				}else if("0002707".equals(dblstitchPlcCode)) {
					optionJacketStandardInfo.setOjDStitchModifyPlace5(dblstitchPlcCode);
				}else if("0002708".equals(dblstitchPlcCode)) {
					optionJacketStandardInfo.setOjDStitchModifyPlace6(dblstitchPlcCode);
				}else if("0002709".equals(dblstitchPlcCode)) {
					optionJacketStandardInfo.setOjDStitchModifyPlace7(dblstitchPlcCode);
				}else if("0002710".equals(dblstitchPlcCode)) {
					optionJacketStandardInfo.setOjDStitchModifyPlace8(dblstitchPlcCode);
				}
			}
		}
		
		//AMF色指定
		String jkAmfColorPlcCd = orderJK.getJkAmfColorPlcCd();
		String jkAmfColorCd = orderJK.getJkAmfColorCd();
		if(jkAmfColorPlcCd!=null && !"".equals(jkAmfColorPlcCd) && jkAmfColorCd !=null && !"".equals(jkAmfColorCd)
		/* &&!jkAmfColorPlcCd.startsWith(regex)&&!jkAmfColorCd.startsWith(regex) */) {
			String[] jkAmfColorPlcSplit = jkAmfColorPlcCd.split(regex);
			String[] jkAmfColorSplit = jkAmfColorCd.split(regex);
			jkAmfColorSplit = BaseCheckUtil.placeColorMethod(jkAmfColorPlcSplit.length,jkAmfColorSplit);
			for (int i = 0;i<jkAmfColorPlcSplit.length;i++) {
				if("0002901".equals(jkAmfColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjAmfColorPlace1(jkAmfColorPlcSplit[i]);
					optionJacketStandardInfo.setOjAmfColor1(jkAmfColorSplit[i]);
				}else if("0002902".equals(jkAmfColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjAmfColorPlace2(jkAmfColorPlcSplit[i]);
					optionJacketStandardInfo.setOjAmfColor2(jkAmfColorSplit[i]);
				}else if("0002903".equals(jkAmfColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjAmfColorPlace3(jkAmfColorPlcSplit[i]);
					optionJacketStandardInfo.setOjAmfColor3(jkAmfColorSplit[i]);
				}else if("0002904".equals(jkAmfColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjAmfColorPlace4(jkAmfColorPlcSplit[i]);
					optionJacketStandardInfo.setOjAmfColor4(jkAmfColorSplit[i]);
				}else if("0002905".equals(jkAmfColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjAmfColorPlace5(jkAmfColorPlcSplit[i]);
					optionJacketStandardInfo.setOjAmfColor5(jkAmfColorSplit[i]);
				}else if("0002907".equals(jkAmfColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjAmfColorPlace6(jkAmfColorPlcSplit[i]);
					optionJacketStandardInfo.setOjAmfColor6(jkAmfColorSplit[i]);
				}else if("0002908".equals(jkAmfColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjAmfColorPlace7(jkAmfColorPlcSplit[i]);
					optionJacketStandardInfo.setOjAmfColor7(jkAmfColorSplit[i]);
				}else if("0002909".equals(jkAmfColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjAmfColorPlace8(jkAmfColorPlcSplit[i]);
					optionJacketStandardInfo.setOjAmfColor8(jkAmfColorSplit[i]);
				}else if("0002910".equals(jkAmfColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjAmfColorPlace9(jkAmfColorPlcSplit[i]);
					optionJacketStandardInfo.setOjAmfColor9(jkAmfColorSplit[i]);
				}
			}
		}
		
		//ボタンホール色指定
		String jkBtnholeColorPlcCd = orderJK.getJkBtnholeColorPlcCd();
		String jkBtnholeColorCd = orderJK.getJkBtnholeColorCd();
		if(!"".equals(jkBtnholeColorPlcCd)&&jkBtnholeColorPlcCd!=null&&!"".equals(jkBtnholeColorCd)&&jkBtnholeColorCd!=null
		/*
		 * &&!jkBtnholeColorPlcCd.startsWith(regex)&&!jkBtnholeColorCd.startsWith(regex)
		 */) {
			String[] jkBtnholeColorPlcSplit = jkBtnholeColorPlcCd.split(regex);
			String[] jkBtnholeColorSplit = jkBtnholeColorCd.split(regex);
			jkBtnholeColorSplit = BaseCheckUtil.placeColorMethod(jkBtnholeColorPlcSplit.length,jkBtnholeColorSplit);
			for (int i = 0; i < jkBtnholeColorPlcSplit.length; i++) {
				if("0003201".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace1(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor1(jkBtnholeColorSplit[i]);
				}else if("0003202".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace2(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor2(jkBtnholeColorSplit[i]);
				}else if("0003203".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace3(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor3(jkBtnholeColorSplit[i]);
				}else if("0003204".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace4(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor4(jkBtnholeColorSplit[i]);
				}else if("0003205".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace5(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor5(jkBtnholeColorSplit[i]);
				}else if("0003206".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace6(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor6(jkBtnholeColorSplit[i]);
				}else if("0003207".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace7(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor7(jkBtnholeColorSplit[i]);
				}else if("0003208".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace8(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor8(jkBtnholeColorSplit[i]);
				}else if("0003209".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace9(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor9(jkBtnholeColorSplit[i]);
				}else if("0003210".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace10(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor10(jkBtnholeColorSplit[i]);
				}else if("0003211".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace11(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor11(jkBtnholeColorSplit[i]);
				}else if("0003212".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace12(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor12(jkBtnholeColorSplit[i]);
				}else if("0003213".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace13(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor13(jkBtnholeColorSplit[i]);
				}else if("0003214".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace14(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor14(jkBtnholeColorSplit[i]);
				}else if("0003215".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace15(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor15(jkBtnholeColorSplit[i]);
				}else if("0003216".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace16(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor16(jkBtnholeColorSplit[i]);
				}else if("0003217".equals(jkBtnholeColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjBhColorPlace17(jkBtnholeColorPlcSplit[i]);
					optionJacketStandardInfo.setOjBhColor17(jkBtnholeColorSplit[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String jkBtnthreadColorPlcCd = orderJK.getJkBtnthreadColorPlcCd();
		String jkBtnthreadColorCd = orderJK.getJkBtnthreadColorCd();
		if(!"".equals(jkBtnthreadColorPlcCd)&&jkBtnthreadColorPlcCd!=null&&!"".equals(jkBtnthreadColorCd)&&jkBtnthreadColorCd!=null
		/*
		 * &&!jkBtnthreadColorPlcCd.startsWith(regex)&&!jkBtnthreadColorCd.startsWith(
		 * regex)
		 */) {
			String[] jkBtnthreadColorPlcSplit = jkBtnthreadColorPlcCd.split(regex);
			String[] jkBtnthreadColorSplit = jkBtnthreadColorCd.split(regex);
			jkBtnthreadColorSplit = BaseCheckUtil.placeColorMethod(jkBtnthreadColorPlcSplit.length,jkBtnthreadColorSplit);
			for (int i = 0; i < jkBtnthreadColorPlcSplit.length; i++) {
				if("0003501".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace1(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor1(jkBtnthreadColorSplit[i]);
				}else if("0003502".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace2(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor2(jkBtnthreadColorSplit[i]);
				}else if("0003503".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace3(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor3(jkBtnthreadColorSplit[i]);
				}else if("0003504".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace4(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor4(jkBtnthreadColorSplit[i]);
				}else if("0003505".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace5(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor5(jkBtnthreadColorSplit[i]);
				}else if("0003506".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace6(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor6(jkBtnthreadColorSplit[i]);
				}else if("0003507".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace7(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor7(jkBtnthreadColorSplit[i]);
				}else if("0003508".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace8(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor8(jkBtnthreadColorSplit[i]);
				}else if("0003509".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace9(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor9(jkBtnthreadColorSplit[i]);
				}else if("0003510".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace10(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor10(jkBtnthreadColorSplit[i]);
				}else if("0003511".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace11(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor11(jkBtnthreadColorSplit[i]);
				}else if("0003512".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace12(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor12(jkBtnthreadColorSplit[i]);
				}else if("0003513".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace13(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor13(jkBtnthreadColorSplit[i]);
				}else if("0003514".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace14(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor14(jkBtnthreadColorSplit[i]);
				}else if("0003515".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace15(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor15(jkBtnthreadColorSplit[i]);
				}else if("0003516".equals(jkBtnthreadColorPlcSplit[i])) {
					optionJacketStandardInfo.setOjByColorPlace16(jkBtnthreadColorPlcSplit[i]);
					optionJacketStandardInfo.setOjByColor16(jkBtnthreadColorSplit[i]);
				}
			}
		}
	}
	
	public void jacketAdjustFromDb(OrderCoForm orderCoForm, Order order) {

		if("9000101".equals(order.getProductCategory())) {
			orderCoForm.getCoOptionJacketStandardInfo().setOjJacketModel(order.getJkModelCd());
		}else if("9000102".equals(order.getProductCategory())) {
			orderCoForm.getCoOptionJacketTuxedoInfo().setTjJacketModel(order.getJkModelCd());
		}else if("9000103".equals(order.getProductCategory())) {
			orderCoForm.getCoOptionJacketWashableInfo().setWjJacketModel(order.getJkModelCd());
		}
		orderCoForm.getCoAdjustJacketStandardInfo().setSizeNumber(order.getCorJkSize());
		orderCoForm.getCoAdjustJacketStandardInfo().setSizeFigure(order.getCorJkDrop());

		BigDecimal corJkBodylengthSize = order.getCorJkBodylengthSize();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkBodylengthSize)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkBodySize(String.valueOf(corJkBodylengthSize));
		}
		BigDecimal corJkBodylengthGross = order.getCorJkBodylengthGross();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkBodylengthGross)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkBodyGross(String.valueOf(corJkBodylengthGross));
		}
		BigDecimal corJkBodylengthCorrect = order.getCorJkBodylengthCorrect();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkBodylengthCorrect)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkBodyCorrect(String.valueOf(corJkBodylengthCorrect));
		}

		BigDecimal corJkWaistSize = order.getCorJkWaistSize();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkWaistSize)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkWaistSize(String.valueOf(corJkWaistSize));
		}
		
		BigDecimal corJkWaistGross = order.getCorJkWaistGross();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkWaistGross)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkWaistGross(String.valueOf(corJkWaistGross));
		}
		
		BigDecimal corJkWaistCorrect = order.getCorJkWaistCorrect();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkWaistCorrect)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkWaistCorrect(String.valueOf(corJkWaistCorrect));
		}
		
		BigDecimal corJkRightsleeveSize = order.getCorJkRightsleeveSize();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkRightsleeveSize)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkRightsleeveSize(String.valueOf(corJkRightsleeveSize));
		}
		
		BigDecimal corJkRightsleeveGross = order.getCorJkRightsleeveGross();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkRightsleeveGross)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkRightsleeveGross(String.valueOf(corJkRightsleeveGross));
		}
		
		BigDecimal corJkRightsleeveCorrect = order.getCorJkRightsleeveCorrect();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkRightsleeveCorrect)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkRightsleeveCorrect(String.valueOf(corJkRightsleeveCorrect));
		}

		BigDecimal corJkLeftsleeveSize = order.getCorJkLeftsleeveSize();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkLeftsleeveSize)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkLeftsleeveSize(String.valueOf(corJkLeftsleeveSize));
		}
		
		BigDecimal corJkLeftsleeveGross = order.getCorJkLeftsleeveGross();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkLeftsleeveGross)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkLeftsleeveGross(String.valueOf(corJkLeftsleeveGross));
		}
		
		BigDecimal corJkLeftsleeveCorrect = order.getCorJkLeftsleeveCorrect();
		if(BaseCheckUtil.isNotBigDecimalNull(corJkLeftsleeveCorrect)) {
			orderCoForm.getCoAdjustJacketStandardInfo().setCorJkLeftsleeveCorrect(String.valueOf(corJkLeftsleeveCorrect));
		}

		orderCoForm.getCoAdjustJacketStandardInfo().setCorJkShoulderPadCd(order.getCorJkShoulderpadCd());
		orderCoForm.getCoAdjustJacketStandardInfo().setCorJkFigureCorrectCd(order.getCorJkFigureCorrectCd());
		
		//orderCoForm.setCorStoreCorrectionMemoAgain(order.getCorStoreCorrectionMemo());

	}
	
	
	public void optionJacketDbToOrder(String productItem, String productCategory,
			Order order, OrderCoForm orderCoForm, OrderListService orderListService, ModelService modelService,
			OrderService orderService, String orderFlag ,String isDnpDivertFlag) {
		Order orderJk = null;
		if("1".equals(isDnpDivertFlag)) {
			orderJk = orderListService.findDnpOrderJkOptionByOrderId(order.getOrderId());
		}else {
			orderJk = orderListService.findOrderJkOptionByOrderId(order.getOrderId());
		}
		
		if (orderJk != null) {
			// JACKET_マニカ
			String jkManicaCd = orderJk.getJkManicaCd();
			// JACKET_腰ポケッ
			String jkWaistPktCd = orderJk.getJkWaistPktCd();
			// JACKET_胸ポケット
			String jkBreastPktCd = orderJk.getJkBreastPktCd();
			if (BaseCheckUtil.isEmpty(jkManicaCd) && BaseCheckUtil.isEmpty(jkBreastPktCd)
					&& BaseCheckUtil.isEmpty(jkWaistPktCd)) {
				this.jacketDefaultValue(orderCoForm);
			}else {
				this.jacketDefaultValueFromDb(orderCoForm, orderJk);
			}
		} else {
			this.jacketDefaultValue(orderCoForm);
		}

		Order orderJkAd = null;
		if("1".equals(isDnpDivertFlag)) {
			orderJkAd = orderListService.findDnpOrderJkByPk(order.getOrderId());
		}else {
			orderJkAd = orderListService.findOrderJkByPk(order.getOrderId());
		}
		
		CoAdjustJacketStandardInfo coAdjustJacketStandardInfo = orderCoForm.getCoAdjustJacketStandardInfo();
		if (coAdjustJacketStandardInfo == null) {
			coAdjustJacketStandardInfo = new CoAdjustJacketStandardInfo();
			orderCoForm.setCoAdjustJacketStandardInfo(coAdjustJacketStandardInfo);
		}
		if (orderJkAd != null) {
			this.jacketAdjustFromDb(orderCoForm, orderJkAd);
		}

		if ("9000101".equals(productCategory)) {
			CoOptionJacketStandardInfo coOptionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
			String ojJacketModel = coOptionJacketStandardInfo.getOjJacketModel();
			if (ojJacketModel != null && !"".equals(ojJacketModel)) {
				String code = productItem.concat("02").concat(ojJacketModel);
				this.getOrderPriceForJacketModel(orderCoForm, code,orderFlag);
				// ステッチ箇所変更
				String stitchModifyValue = coOptionJacketStandardInfo.getOjStitchModify();
				String stitchModifyCountArr = coOptionJacketStandardInfo.getOjStitchModifyPlace();
				if ("0002402".equals(stitchModifyValue)&&BaseCheckUtil.isNotEmpty(stitchModifyCountArr)) {
					String stitchModifyCode = productItem.concat("02").concat(ojJacketModel).concat("00025");
					String stitchModifyValueName = "stitchModify_id";
					//if(!stitchModifyCountArr.startsWith("/")) {
						this.getOrderPriceForJacketProject(orderCoForm, stitchModifyCode,
								stitchModifyValueName, "", "", stitchModifyCountArr, stitchModifyValue, "");
					//}
				}

				// ダブルステッチ変更
//				String dSitchModifyValue = coOptionJacketStandardInfo.getOjDStitchModify();
//				String dSitchModifyCountArr = coOptionJacketStandardInfo.getOjDStitchModifyPlace();
//				if ("0002602".equals(dSitchModifyValue)&&BaseCheckUtil.isNotEmpty(dSitchModifyCountArr)) {
//					String dStitchModifyCode = productItem.concat("02").concat(ojJacketModel).concat("00027");
//					String dSitchModifyValueName = "dStitchModify_id";
//					//if(!dSitchModifyCountArr.startsWith("/")) {
//						this.getOrderPriceForJacketProject(orderCoForm, dStitchModifyCode,
//								dSitchModifyValueName, "", "", dSitchModifyCountArr, dSitchModifyValue, "");
//					//}
//					
//				}

				// AMF色指定
				String jkAmfColorCd = coOptionJacketStandardInfo.getOjAmfAllColor();
				if (jkAmfColorCd != null && !"".equals(jkAmfColorCd)){
					String amfTemp = jkAmfColorCd.replaceAll("/", "");
					if(!"".equals(amfTemp)) {
						String amfValueName = "amfColor_id";
						String amfCode = productItem.concat("02").concat(ojJacketModel);
						Map<String, String> amfColorMap = new HashMap<String, String>();

						String[] jkAmfColorSplit = jkAmfColorCd.split("/");
						for (String amfColor : jkAmfColorSplit) {
							amfColorMap.put(amfColor, amfColor);
						}
						//String amfColorCount = String.valueOf(amfColorMap.size());
						List<String> amfValuesList = new ArrayList<String>(amfColorMap.values());
						amfValuesList.removeAll(Collections.singleton(null));
						amfValuesList.removeAll(Collections.singleton(""));
						String amfColorCount = String.valueOf(amfValuesList.size());
						String amfColorCode = "00030".concat(amfValuesList.get(0));
						this.getOrderPriceForJacketProject(orderCoForm, amfCode, amfValueName, amfColorCode,
								amfColorCount, "", "", "");
					}
				}
				
//				if (jkAmfColorCd != null && !"".equals(jkAmfColorCd)&&!"".equals(amfTemp)/* &&!jkAmfColorCd.startsWith("/") */) {
//					
//				}
				// ボタンホール色指定
				String jkBtnholeColorCd = coOptionJacketStandardInfo.getOjBhAllColor();
				if (jkBtnholeColorCd != null && !"".equals(jkBtnholeColorCd)/* &&!jkBtnholeColorCd.startsWith("/") */) {
					String bhTemp = jkBtnholeColorCd.replaceAll("/", "");
					if(!"".equals(bhTemp)) {
						String bhValueName = "bhColor_id";
						String bhCode = productItem.concat("02").concat(ojJacketModel);
						Map<String, String> bhColorMap = new HashMap<String, String>();

						String[] jkBtnholeColorSplit = jkBtnholeColorCd.split("/");
						for (String btnholeColor : jkBtnholeColorSplit) {
							bhColorMap.put(btnholeColor, btnholeColor);
						}

						//String bhColorCount = String.valueOf(bhColorMap.size());
						List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
						bhValuesList.removeAll(Collections.singleton(null));
						bhValuesList.removeAll(Collections.singleton(""));
						String bhColorCount = String.valueOf(bhValuesList.size());
						String bhColorCode = "00033".concat(bhValuesList.get(0));
						this.getOrderPriceForJacketProject(orderCoForm, bhCode, bhValueName, bhColorCode,
								bhColorCount, "", "", "");
					}
				}
				// ボタン付け糸指定
				String jkBtnthreadColorCd = coOptionJacketStandardInfo.getOjByAllColor();
				if (jkBtnthreadColorCd != null && !"".equals(jkBtnthreadColorCd)/* &&!jkBtnthreadColorCd.startsWith("/") */){
					String byTemp = jkBtnthreadColorCd.replaceAll("/", "");
					if(!"".equals(byTemp)) {
						String byValueName = "byColor_id";
						String byCode = productItem.concat("02").concat(ojJacketModel);
						Map<String, String> byColorMap = new HashMap<String, String>();
						
						String[] jkBtnthreadColorSplit = jkBtnthreadColorCd.split("/");
						for (String btnthreadColor : jkBtnthreadColorSplit) {
							byColorMap.put(btnthreadColor, btnthreadColor);
						}
						//String byColorCount = String.valueOf(byColorMap.size());
						List<String> byValuesList = new ArrayList<String>(byColorMap.values());
						byValuesList.removeAll(Collections.singleton(null));
						byValuesList.removeAll(Collections.singleton(""));
						String byColorCount = String.valueOf(byValuesList.size());
						String byColorCode = "00036".concat(byValuesList.get(0));
						this.getOrderPriceForJacketProject(orderCoForm, byCode, byValueName, byColorCode,
								byColorCount, "", "", "");
					}
				}
			}else {
				orderCoForm.setJkOptionPrice("0");
			}
		} else if ("9000102".equals(productCategory)) {
			CoOptionJacketTuxedoInfo coOptionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
			String tjJacketModel = coOptionJacketTuxedoInfo.getTjJacketModel();
			if (tjJacketModel != null && !"".equals(tjJacketModel)) {
				String code = productItem.concat("02").concat(tjJacketModel);
				this.getOrderPriceForJacketTuxedoModel(orderCoForm, code,orderFlag);
				// ボタンホール色指定
				String jkBtnholeColorCd = coOptionJacketTuxedoInfo.getTjAllBhColor();
				if (jkBtnholeColorCd != null && !"".equals(jkBtnholeColorCd)/* &&!jkBtnholeColorCd.startsWith("/") */) {
					String bhTemp = jkBtnholeColorCd.replaceAll("/", "");
					if(!"".equals(bhTemp)) {
						String bhValueName = "tj_bhColor_id";
						String bhCode = productItem.concat("02").concat(tjJacketModel);
						Map<String, String> bhColorMap = new HashMap<String, String>();
						
						String[] jkBtnholeColorSplit = jkBtnholeColorCd.split("/");
						for (String btnholeColor : jkBtnholeColorSplit) {
							bhColorMap.put(btnholeColor, btnholeColor);
						}
						
						//String bhColorCount = String.valueOf(bhColorMap.size());
						List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
						bhValuesList.removeAll(Collections.singleton(null));
						bhValuesList.removeAll(Collections.singleton(""));
						String bhColorCount = String.valueOf(bhValuesList.size());
						String bhColorCode = "00033".concat(bhValuesList.get(0));
						this.getOrderPriceForJacketTuxedoProject(orderCoForm, bhCode, bhValueName, bhColorCode,
								bhColorCount, "", "", "");
					}
				}
				// ボタン付け糸指定
				String jkBtnthreadColorCd = coOptionJacketTuxedoInfo.getTjAllByColor();
				if (jkBtnthreadColorCd != null && !"".equals(jkBtnthreadColorCd)) {
					String byTemp = jkBtnthreadColorCd.replaceAll("/", "");
					if(!"".equals(byTemp)) {
						String byValueName = "tj_byColor_id";
						String byCode = productItem.concat("02").concat(tjJacketModel);
						Map<String, String> byColorMap = new HashMap<String, String>();
						
						String[] jkBtnthreadColorSplit = jkBtnthreadColorCd.split("/");
						for (String btnthreadColor : jkBtnthreadColorSplit) {
							byColorMap.put(btnthreadColor, btnthreadColor);
						}
						
						//String byColorCount = String.valueOf(byColorMap.size());
						List<String> byValuesList = new ArrayList<String>(byColorMap.values());
						byValuesList.removeAll(Collections.singleton(null));
						byValuesList.removeAll(Collections.singleton(""));
						String byColorCount = String.valueOf(byValuesList.size());
						String byColorCode = "00036".concat(byValuesList.get(0));
						this.getOrderPriceForJacketTuxedoProject(orderCoForm, byCode, byValueName, byColorCode,
								byColorCount, "", "", "");
					}
				}
			}else {
				orderCoForm.setJkOptionPrice("0");
			}
		} else if ("9000103".equals(productCategory)) {
			CoOptionJacketWashableInfo coOptionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
			String wjJacketModel = coOptionJacketWashableInfo.getWjJacketModel();
			if (wjJacketModel != null && !"".equals(wjJacketModel)) {
				String code = productItem.concat("02").concat(coOptionJacketWashableInfo.getWjJacketModel());
				this.getOrderPriceForJacketWashableModel(orderCoForm, code,orderFlag);
				
				// ステッチ箇所変更
				String stitchModifyValue = coOptionJacketWashableInfo.getWjStitchModify();
				String stitchModifyCountArr = coOptionJacketWashableInfo.getWjStitchModifyPlace();
				if ("0002402".equals(stitchModifyValue)&&BaseCheckUtil.isNotEmpty(stitchModifyCountArr)) {
					String stitchModifyCode = productItem.concat("02").concat(coOptionJacketWashableInfo.getWjJacketModel())
							.concat("00025");
					String stitchModifyValueName = "wj_stitchModify_id";
					//if(!stitchModifyCountArr.startsWith("/")) {
						this.getOrderPriceForJacketWashableProject(orderCoForm, stitchModifyCode,
								stitchModifyValueName, "", "", stitchModifyCountArr, stitchModifyValue, "");
					//}
				}
				
				// ダブルステッチ変更
//				String dSitchModifyValue = coOptionJacketWashableInfo.getWjDStitchModify();
//				String dSitchModifyCountArr = coOptionJacketWashableInfo.getWjDStitchModifyPlace();
//				if ("0002602".equals(dSitchModifyValue)&&BaseCheckUtil.isNotEmpty(dSitchModifyCountArr)) {
//					String dStitchModifyCode = productItem.concat("02")
//							.concat(coOptionJacketWashableInfo.getWjJacketModel()).concat("00027");
//					String dSitchModifyValueName = "wj_dStitchModify_id";
//					//if(!dSitchModifyCountArr.startsWith("/")) {
//						this.getOrderPriceForJacketWashableProject(orderCoForm, dStitchModifyCode,
//								dSitchModifyValueName, "", "", dSitchModifyCountArr, dSitchModifyValue, "");
//					//}
//				}
				// AMF色指定
				String jkAmfColorCd = coOptionJacketWashableInfo.getWjAllAmfColor();
				if (jkAmfColorCd != null && !"".equals(jkAmfColorCd)) {
					String amfTemp = jkAmfColorCd.replaceAll("/", "");
					if(!"".equals(amfTemp)) {
						String amfValueName = "wj_amfColor_id";
						String amfCode = productItem.concat("02").concat(coOptionJacketWashableInfo.getWjJacketModel());
						Map<String, String> amfColorMap = new HashMap<String, String>();
						
						String[] jkAmfColorSplit = jkAmfColorCd.split("/");
						for (String amfColor : jkAmfColorSplit) {
							amfColorMap.put(amfColor, amfColor);
						}
						
						//String amfColorCount = String.valueOf(amfColorMap.size());
						List<String> amfValuesList = new ArrayList<String>(amfColorMap.values());
						amfValuesList.removeAll(Collections.singleton(null));
						amfValuesList.removeAll(Collections.singleton(""));
						String amfColorCount = String.valueOf(amfValuesList.size());
						String amfColorCode = "00030".concat(amfValuesList.get(0));
						this.getOrderPriceForJacketWashableProject(orderCoForm, amfCode, amfValueName,
								amfColorCode, amfColorCount, "", "", "");
					}
				}
				// ボタンホール色指定
				String jkBtnholeColorCd = coOptionJacketWashableInfo.getWjAllBhColor();
				if (jkBtnholeColorCd != null && !"".equals(jkBtnholeColorCd)) {
					String bhTemp = jkBtnholeColorCd.replaceAll("/", "");
					if(!"".equals(bhTemp)) {
						String bhValueName = "wj_bhColor_id";
						String bhCode = productItem.concat("02").concat(coOptionJacketWashableInfo.getWjJacketModel());
						Map<String, String> bhColorMap = new HashMap<String, String>();
						
						String[] jkBtnholeColorSplit = jkBtnholeColorCd.split("/");
						for (String btnholeColor : jkBtnholeColorSplit) {
							bhColorMap.put(btnholeColor, btnholeColor);
						}
						
						//String bhColorCount = String.valueOf(bhColorMap.size());
						List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
						bhValuesList.removeAll(Collections.singleton(null));
						bhValuesList.removeAll(Collections.singleton(""));
						String bhColorCount = String.valueOf(bhValuesList.size());
						String bhColorCode = "00033".concat(bhValuesList.get(0));
						this.getOrderPriceForJacketWashableProject(orderCoForm, bhCode, bhValueName, bhColorCode,
								bhColorCount, "", "", "");
					}
				}
				// ボタン付け糸指定
				String jkBtnthreadColorCd = coOptionJacketWashableInfo.getWjAllByColor();
				if (jkBtnthreadColorCd != null && !"".equals(jkBtnthreadColorCd)) {
					String bhTemp = jkBtnthreadColorCd.replaceAll("/", "");
					if(!"".equals(bhTemp)) {
						String byValueName = "wj_byColor_id";
						String byCode = productItem.concat("02").concat(coOptionJacketWashableInfo.getWjJacketModel());
						Map<String, String> byColorMap = new HashMap<String, String>();
						
							String[] jkBtnthreadColorSplit = jkBtnthreadColorCd.split("/");
							for (String btnthreadColor : jkBtnthreadColorSplit) {
								byColorMap.put(btnthreadColor, btnthreadColor);
							}
						
						//String byColorCount = String.valueOf(byColorMap.size());
						List<String> byValuesList = new ArrayList<String>(byColorMap.values());
						String byColorCount = String.valueOf(byValuesList.size());
						String byColorCode = "00036".concat(byValuesList.get(0));
						byValuesList.removeAll(Collections.singleton(null));
						byValuesList.removeAll(Collections.singleton(""));
						this.getOrderPriceForJacketWashableProject(orderCoForm, byCode, byValueName, byColorCode,
								byColorCount, "", "", "");
					}
				}
			}else {
				orderCoForm.setJkOptionPrice("0");
			}
		}
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getItemModel(order.getOrderPattern(),
				productItem, "02");
		this.getJacketModelMap(orderCoForm, modelList);
	}

	public Map<String, Object> getOrderPriceForJacketModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionJacketStandardInfo optionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
		
		JacketOptionCoStandardPriceEnum[] priceEnum = JacketOptionCoStandardPriceEnum.values();
		
		String ojFrontBtnCnt = optionJacketStandardInfo.getOjFrontBtnCnt();
		
		for (JacketOptionCoStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = optionJacketStandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(optionJacketStandardInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = optionJacketStandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(optionJacketStandardInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				//胴裏素材
				if("bodyBackMate".equals(valueFour)&&"1000400".equals(invokeOne)) {
					splicingCodeDetail = "";
				}
				
				//袖裏素材
				if("cuffBackMate".equals(valueFour)&&"2000300".equals(invokeOne)) {
					splicingCodeDetail = "";
				}
				
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if( "stitchModify_id".equals(valueFour)) {
						
						List<String> stitchModifyList = new ArrayList<String>();
						String ojStitchModify = optionJacketStandardInfo.getOjStitchModify();
						if(OptionCodeKeys.JK_0002402.equals(ojStitchModify)) {
							String ojStitchModifyPlace1 = optionJacketStandardInfo.getOjStitchModifyPlace1();
							stitchModifyList.add(ojStitchModifyPlace1);
							String ojStitchModifyPlace2 = optionJacketStandardInfo.getOjStitchModifyPlace2();
							stitchModifyList.add(ojStitchModifyPlace2);
							String ojStitchModifyPlace3 = optionJacketStandardInfo.getOjStitchModifyPlace3();
							stitchModifyList.add(ojStitchModifyPlace3);
							String ojStitchModifyPlace4 = optionJacketStandardInfo.getOjStitchModifyPlace4();
							stitchModifyList.add(ojStitchModifyPlace4);
							String ojStitchModifyPlace5 = optionJacketStandardInfo.getOjStitchModifyPlace5();
							stitchModifyList.add(ojStitchModifyPlace5);
							String ojStitchModifyPlace6 = optionJacketStandardInfo.getOjStitchModifyPlace6();
							stitchModifyList.add(ojStitchModifyPlace6);
							String ojStitchModifyPlace7 = optionJacketStandardInfo.getOjStitchModifyPlace7();
							stitchModifyList.add(ojStitchModifyPlace7);
							String ojStitchModifyPlace8 = optionJacketStandardInfo.getOjStitchModifyPlace8();
							stitchModifyList.add(ojStitchModifyPlace8);
							String ojStitchModifyPlace9 = optionJacketStandardInfo.getOjStitchModifyPlace9();
							stitchModifyList.add(ojStitchModifyPlace9);
						}
						
						
						stitchModifyList.removeAll(Collections.singleton(null));
						stitchModifyList.removeAll(Collections.singleton(""));
						
						if(stitchModifyList.isEmpty()|| OptionCodeKeys.JK_0002401.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne))) {
							splicingCodeForFindUniquePrice = code + key + invokeOne;
							//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
						}else {
							Integer orderPriceInt = 0;
							//String[] strArr = countArr.split(",");
							for (int i = 0; i < stitchModifyList.size(); i++) {
								String projectPriceCode = code + "00025" + stitchModifyList.get(i);
								String orderPriceInner = null;
								if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
									orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
								}else {
									orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
								}
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
							}
							orderPrice = String.valueOf(orderPriceInt);
						}
					}
					
//					if( "dStitchModify_id".equals(valueFour)) {
//						List<String> stitchModifyList = new ArrayList<String>();
//						String ojStitchModifyPlace1 = optionJacketStandardInfo.getOjDStitchModifyPlace1();
//						stitchModifyList.add(ojStitchModifyPlace1);
//						String ojStitchModifyPlace2 = optionJacketStandardInfo.getOjDStitchModifyPlace2();
//						stitchModifyList.add(ojStitchModifyPlace2);
//						String ojStitchModifyPlace3 = optionJacketStandardInfo.getOjDStitchModifyPlace3();
//						stitchModifyList.add(ojStitchModifyPlace3);
//						String ojStitchModifyPlace4 = optionJacketStandardInfo.getOjDStitchModifyPlace4();
//						stitchModifyList.add(ojStitchModifyPlace4);
//						String ojStitchModifyPlace5 = optionJacketStandardInfo.getOjDStitchModifyPlace5();
//						stitchModifyList.add(ojStitchModifyPlace5);
//						String ojStitchModifyPlace6 = optionJacketStandardInfo.getOjDStitchModifyPlace6();
//						stitchModifyList.add(ojStitchModifyPlace6);
//						String ojStitchModifyPlace7 = optionJacketStandardInfo.getOjDStitchModifyPlace7();
//						stitchModifyList.add(ojStitchModifyPlace7);
//						String ojStitchModifyPlace8 = optionJacketStandardInfo.getOjDStitchModifyPlace8();
//						stitchModifyList.add(ojStitchModifyPlace8);
//						String ojStitchModifyPlace9 = optionJacketStandardInfo.getOjDStitchModifyPlace9();
//						stitchModifyList.add(ojStitchModifyPlace9);
//						
//						stitchModifyList.removeAll(Collections.singleton(null));
//						stitchModifyList.removeAll(Collections.singleton(""));
//						
//						if(stitchModifyList.isEmpty() || OptionCodeKeys.JK_0002601.equals(invokeOne)) {
//							splicingCodeForFindUniquePrice = code + key + invokeOne;
//							//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
//						}else {
//							Integer orderPriceInt = 0;
//							//String[] strArr = countArr.split(",");
//							for (int i = 0; i < stitchModifyList.size(); i++) {
//								String projectPriceCode = code + "00027" + stitchModifyList.get(i);
//								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
//								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
//							}
//							orderPrice = String.valueOf(orderPriceInt);
//						}
//					}
					
					if ("amfColor_id".equals(valueFour)) {
						HashSet<String> amfColorSet = new HashSet<String>();
						String ojAmfColor1 = optionJacketStandardInfo.getOjAmfColor1();
						amfColorSet.add(ojAmfColor1);
						String ojAmfColor2 = optionJacketStandardInfo.getOjAmfColor2();
						amfColorSet.add(ojAmfColor2);
						String ojAmfColor3 = optionJacketStandardInfo.getOjAmfColor3();
						amfColorSet.add(ojAmfColor3);
						String ojAmfColor4 = optionJacketStandardInfo.getOjAmfColor4();
						amfColorSet.add(ojAmfColor4);
						String ojAmfColor5 = optionJacketStandardInfo.getOjAmfColor5();
						amfColorSet.add(ojAmfColor5);
						String ojAmfColor6 = optionJacketStandardInfo.getOjAmfColor6();
						amfColorSet.add(ojAmfColor6);
						String ojAmfColor7 = optionJacketStandardInfo.getOjAmfColor7();
						amfColorSet.add(ojAmfColor7);
						String ojAmfColor8 = optionJacketStandardInfo.getOjAmfColor8();
						amfColorSet.add(ojAmfColor8);
						String ojAmfColor9 = optionJacketStandardInfo.getOjAmfColor9();
						amfColorSet.add(ojAmfColor9);
						
						amfColorSet.removeAll(Collections.singleton(null));
						amfColorSet.removeAll(Collections.singleton(""));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						
						if (OptionCodeKeys.JK_0002801.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) || amfColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = null;
							if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00030" + amfColorList.get(0);
							String orderPriceInner = null;
							if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(amfColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String ojBhColor1 = optionJacketStandardInfo.getOjBhColor1();
						bhColorSet.add(ojBhColor1);
						String ojBhColor2 = optionJacketStandardInfo.getOjBhColor2();
						bhColorSet.add(ojBhColor2);
						String ojBhColor3 = optionJacketStandardInfo.getOjBhColor3();
						bhColorSet.add(ojBhColor3);
						String ojBhColor4 = optionJacketStandardInfo.getOjBhColor4();
						bhColorSet.add(ojBhColor4);
						String ojBhColor5 = optionJacketStandardInfo.getOjBhColor5();
						bhColorSet.add(ojBhColor5);
						String ojBhColor6 = optionJacketStandardInfo.getOjBhColor6();
						bhColorSet.add(ojBhColor6);
						String ojBhColor7 = optionJacketStandardInfo.getOjBhColor7();
						bhColorSet.add(ojBhColor7);
						String ojBhColor8 = optionJacketStandardInfo.getOjBhColor8();
						bhColorSet.add(ojBhColor8);
						String ojBhColor9 = optionJacketStandardInfo.getOjBhColor9();
						bhColorSet.add(ojBhColor9);
						String ojBhColor10 = optionJacketStandardInfo.getOjBhColor10();
						bhColorSet.add(ojBhColor10);
						String ojBhColor11 = optionJacketStandardInfo.getOjBhColor11();
						bhColorSet.add(ojBhColor11);
						String ojBhColor12 = optionJacketStandardInfo.getOjBhColor12();
						bhColorSet.add(ojBhColor12);
						String ojBhColor13 = optionJacketStandardInfo.getOjBhColor13();
						bhColorSet.add(ojBhColor13);
						String ojBhColor14 = optionJacketStandardInfo.getOjBhColor14();
						bhColorSet.add(ojBhColor14);
						String ojBhColor15 = optionJacketStandardInfo.getOjBhColor15();
						bhColorSet.add(ojBhColor15);
						String ojBhColor16 = optionJacketStandardInfo.getOjBhColor16();
						bhColorSet.add(ojBhColor16);
						String ojBhColor17 = optionJacketStandardInfo.getOjBhColor17();
						bhColorSet.add(ojBhColor17);
						
						bhColorSet.removeAll(Collections.singleton(null));
						bhColorSet.removeAll(Collections.singleton(""));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						
						if (OptionCodeKeys.JK_0003101.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) ||bhColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = null;
							if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00033" + bhColorList.get(0);
							String orderPriceInner = null;
							if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String ojByColor1 = optionJacketStandardInfo.getOjByColor1();
						byColorSet.add(ojByColor1);
						String ojByColor2 = optionJacketStandardInfo.getOjByColor2();
						byColorSet.add(ojByColor2);
						String ojByColor3 = optionJacketStandardInfo.getOjByColor3();
						byColorSet.add(ojByColor3);
						String ojByColor4 = optionJacketStandardInfo.getOjByColor4();
						byColorSet.add(ojByColor4);
						String ojByColor5 = optionJacketStandardInfo.getOjByColor5();
						byColorSet.add(ojByColor5);
						String ojByColor6 = optionJacketStandardInfo.getOjByColor6();
						byColorSet.add(ojByColor6);
						String ojByColor7 = optionJacketStandardInfo.getOjByColor7();
						byColorSet.add(ojByColor7);
						String ojByColor8 = optionJacketStandardInfo.getOjByColor8();
						byColorSet.add(ojByColor8);
						String ojByColor9 = optionJacketStandardInfo.getOjByColor9();
						byColorSet.add(ojByColor9);
						String ojByColor10 = optionJacketStandardInfo.getOjByColor10();
						byColorSet.add(ojByColor10);
						String ojByColor11 = optionJacketStandardInfo.getOjByColor11();
						byColorSet.add(ojByColor11);
						String ojByColor12 = optionJacketStandardInfo.getOjByColor12();
						byColorSet.add(ojByColor12);
						String ojByColor13 = optionJacketStandardInfo.getOjByColor13();
						byColorSet.add(ojByColor13);
						String ojByColor14 = optionJacketStandardInfo.getOjByColor14();
						byColorSet.add(ojByColor14);
						String ojByColor15 = optionJacketStandardInfo.getOjByColor15();
						byColorSet.add(ojByColor15);
						String ojByColor16 = optionJacketStandardInfo.getOjByColor16();
						byColorSet.add(ojByColor16);
						
						byColorSet.removeAll(Collections.singleton(null));
						byColorSet.removeAll(Collections.singleton(""));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						
						if (OptionCodeKeys.JK_0003401.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) ||byColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = null;
							if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00036" + byColorList.get(0);
							String orderPriceInner = null;
							if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				
				
				if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
					if("".equals(orderPrice)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
				}else{
					if("".equals(orderPrice)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketStandardInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketStandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (JacketOptionCoStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = optionJacketStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(optionJacketStandardInfo);
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
		orderCoForm.setJkOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, Object> getOrderPriceForJacketTuxedoModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionJacketTuxedoInfo optionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
		
		JacketOptionCoTuxedoPriceEnum[] priceEnum = JacketOptionCoTuxedoPriceEnum.values();
		
		String tjFrontBtnCnt = optionJacketTuxedoInfo.getTjFrontBtnCnt();
		
		for (JacketOptionCoTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = optionJacketTuxedoInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(optionJacketTuxedoInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = optionJacketTuxedoInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(optionJacketTuxedoInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("tj_btnMate".equals(valueFour)&&"3000700".equals(invokeOne)) {
					splicingCodeDetail = "";
				}
				
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if ("tj_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String tjBhColor1 = optionJacketTuxedoInfo.getTjBhColor1();
						bhColorSet.add(tjBhColor1);
						String ojBhColor2 = optionJacketTuxedoInfo.getTjBhColor2();
						bhColorSet.add(ojBhColor2);
						String ojBhColor3 = optionJacketTuxedoInfo.getTjBhColor3();
						bhColorSet.add(ojBhColor3);
						String ojBhColor4 = optionJacketTuxedoInfo.getTjBhColor4();
						bhColorSet.add(ojBhColor4);
						String ojBhColor5 = optionJacketTuxedoInfo.getTjBhColor5();
						bhColorSet.add(ojBhColor5);
						String ojBhColor6 = optionJacketTuxedoInfo.getTjBhColor6();
						bhColorSet.add(ojBhColor6);
						String ojBhColor7 = optionJacketTuxedoInfo.getTjBhColor7();
						bhColorSet.add(ojBhColor7);
						String ojBhColor8 = optionJacketTuxedoInfo.getTjBhColor8();
						bhColorSet.add(ojBhColor8);
						String ojBhColor9 = optionJacketTuxedoInfo.getTjBhColor9();
						bhColorSet.add(ojBhColor9);
						String tjBhColor10 = optionJacketTuxedoInfo.getTjBhColor10();
						bhColorSet.add(tjBhColor10);
						String tjBhColor11 = optionJacketTuxedoInfo.getTjBhColor11();
						bhColorSet.add(tjBhColor11);
						String tjBhColor12 = optionJacketTuxedoInfo.getTjBhColor12();
						bhColorSet.add(tjBhColor12);
						String tjBhColor13 = optionJacketTuxedoInfo.getTjBhColor13();
						bhColorSet.add(tjBhColor13);
						String tjBhColor14 = optionJacketTuxedoInfo.getTjBhColor14();
						bhColorSet.add(tjBhColor14);
						String tjBhColor15 = optionJacketTuxedoInfo.getTjBhColor15();
						bhColorSet.add(tjBhColor15);
						String tjBhColor16 = optionJacketTuxedoInfo.getTjBhColor16();
						bhColorSet.add(tjBhColor16);
						String tjBhColor17 = optionJacketTuxedoInfo.getTjBhColor17();
						bhColorSet.add(tjBhColor17);
						
						bhColorSet.removeAll(Collections.singleton(null));
						bhColorSet.removeAll(Collections.singleton(""));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						
						if (OptionCodeKeys.JK_0003101.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) ||bhColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = null;
							if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00033" + bhColorList.get(0);
							String orderPriceInner = null;
							if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("tj_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String tjByColor1 = optionJacketTuxedoInfo.getTjByColor1();
						byColorSet.add(tjByColor1);
						String ojByColor2 = optionJacketTuxedoInfo.getTjByColor2();
						byColorSet.add(ojByColor2);
						String ojByColor3 = optionJacketTuxedoInfo.getTjByColor3();
						byColorSet.add(ojByColor3);
						String ojByColor4 = optionJacketTuxedoInfo.getTjByColor4();
						byColorSet.add(ojByColor4);
						String ojByColor5 = optionJacketTuxedoInfo.getTjByColor5();
						byColorSet.add(ojByColor5);
						String ojByColor6 = optionJacketTuxedoInfo.getTjByColor6();
						byColorSet.add(ojByColor6);
						String ojByColor7 = optionJacketTuxedoInfo.getTjByColor7();
						byColorSet.add(ojByColor7);
						String ojByColor8 = optionJacketTuxedoInfo.getTjByColor8();
						byColorSet.add(ojByColor8);
						String ojByColor9 = optionJacketTuxedoInfo.getTjByColor9();
						byColorSet.add(ojByColor9);
						String tjByColor10 = optionJacketTuxedoInfo.getTjByColor10();
						byColorSet.add(tjByColor10);
						String tjByColor11 = optionJacketTuxedoInfo.getTjByColor11();
						byColorSet.add(tjByColor11);
						String tjByColor12 = optionJacketTuxedoInfo.getTjByColor12();
						byColorSet.add(tjByColor12);
						String tjByColor13 = optionJacketTuxedoInfo.getTjByColor13();
						byColorSet.add(tjByColor13);
						String tjByColor14 = optionJacketTuxedoInfo.getTjByColor14();
						byColorSet.add(tjByColor14);
						String tjByColor15 = optionJacketTuxedoInfo.getTjByColor15();
						byColorSet.add(tjByColor15);
						String tjByColor16 = optionJacketTuxedoInfo.getTjByColor16();
						byColorSet.add(tjByColor16);
						
						byColorSet.removeAll(Collections.singleton(null));
						byColorSet.removeAll(Collections.singleton(""));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						
						if (OptionCodeKeys.JK_0003401.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) ||byColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = null;
							if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00036" + byColorList.get(0);
							String orderPriceInner = null;
							if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				
				
				if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
					if("".equals(orderPrice)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
				}else{
					if("".equals(orderPrice)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketTuxedoInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketTuxedoInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (JacketOptionCoTuxedoPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = optionJacketTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(optionJacketTuxedoInfo);
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
		orderCoForm.setJkOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, Object> getOrderPriceForJacketWashableModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionJacketWashableInfo optionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
		
		JacketOptionCoWashablePriceEnum[] priceEnum = JacketOptionCoWashablePriceEnum.values();
		
		String wjFrontBtnCnt = optionJacketWashableInfo.getWjFrontBtnCnt();
		
		for (JacketOptionCoWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = optionJacketWashableInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(optionJacketWashableInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = optionJacketWashableInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(optionJacketWashableInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if( "wj_stitchModify_id".equals(valueFour)) {
						
						List<String> stitchModifyList = new ArrayList<String>();
						String wjStitchModify = optionJacketWashableInfo.getWjStitchModify();
						if(OptionCodeKeys.JK_0002402.equals(wjStitchModify)) {
							
							String wjStitchModifyPlace1 = optionJacketWashableInfo.getWjStitchModifyPlace1();
							stitchModifyList.add(wjStitchModifyPlace1);
							String wjStitchModifyPlace2 = optionJacketWashableInfo.getWjStitchModifyPlace2();
							stitchModifyList.add(wjStitchModifyPlace2);
							String wjStitchModifyPlace3 = optionJacketWashableInfo.getWjStitchModifyPlace3();
							stitchModifyList.add(wjStitchModifyPlace3);
							String wjStitchModifyPlace4 = optionJacketWashableInfo.getWjStitchModifyPlace4();
							stitchModifyList.add(wjStitchModifyPlace4);
							String wjStitchModifyPlace5 = optionJacketWashableInfo.getWjStitchModifyPlace5();
							stitchModifyList.add(wjStitchModifyPlace5);
							String wjStitchModifyPlace6 = optionJacketWashableInfo.getWjStitchModifyPlace6();
							stitchModifyList.add(wjStitchModifyPlace6);
							String wjStitchModifyPlace7 = optionJacketWashableInfo.getWjStitchModifyPlace7();
							stitchModifyList.add(wjStitchModifyPlace7);
							String wjStitchModifyPlace8 = optionJacketWashableInfo.getWjStitchModifyPlace8();
							stitchModifyList.add(wjStitchModifyPlace8);
							String wjStitchModifyPlace9 = optionJacketWashableInfo.getWjStitchModifyPlace9();
							stitchModifyList.add(wjStitchModifyPlace9);
						}
						
						stitchModifyList.removeAll(Collections.singleton(null));
						stitchModifyList.removeAll(Collections.singleton(""));
						
						if(stitchModifyList.isEmpty()|| OptionCodeKeys.JK_0002401.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) ) {
							splicingCodeForFindUniquePrice = code + key + invokeOne;
						}else {
							Integer orderPriceInt = 0;
							for (int i = 0; i < stitchModifyList.size(); i++) {
								String projectPriceCode = code + "00025" + stitchModifyList.get(i);
								String orderPriceInner = null;
								if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
									orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
								}else {
									orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
								}
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
							}
							orderPrice = String.valueOf(orderPriceInt);
						}
					}
					
//					if( "wj_dStitchModify_id".equals(valueFour)) {
//						List<String> stitchModifyList = new ArrayList<String>();
//						String wjStitchModifyPlace1 = optionJacketWashableInfo.getWjDStitchModifyPlace1();
//						stitchModifyList.add(wjStitchModifyPlace1);
//						String wjStitchModifyPlace2 = optionJacketWashableInfo.getWjDStitchModifyPlace2();
//						stitchModifyList.add(wjStitchModifyPlace2);
//						String wjStitchModifyPlace3 = optionJacketWashableInfo.getWjDStitchModifyPlace3();
//						stitchModifyList.add(wjStitchModifyPlace3);
//						String wjStitchModifyPlace4 = optionJacketWashableInfo.getWjDStitchModifyPlace4();
//						stitchModifyList.add(wjStitchModifyPlace4);
//						String wjStitchModifyPlace5 = optionJacketWashableInfo.getWjDStitchModifyPlace5();
//						stitchModifyList.add(wjStitchModifyPlace5);
//						String wjStitchModifyPlace6 = optionJacketWashableInfo.getWjDStitchModifyPlace6();
//						stitchModifyList.add(wjStitchModifyPlace6);
//						String wjStitchModifyPlace7 = optionJacketWashableInfo.getWjDStitchModifyPlace7();
//						stitchModifyList.add(wjStitchModifyPlace7);
//						String wjStitchModifyPlace8 = optionJacketWashableInfo.getWjDStitchModifyPlace8();
//						stitchModifyList.add(wjStitchModifyPlace8);
//						String wjStitchModifyPlace9 = optionJacketWashableInfo.getWjDStitchModifyPlace9();
//						stitchModifyList.add(wjStitchModifyPlace9);
//						
//						stitchModifyList.removeAll(Collections.singleton(null));
//						stitchModifyList.removeAll(Collections.singleton(""));
//						if(stitchModifyList.isEmpty() || OptionCodeKeys.JK_0002601.equals(invokeOne)) {
//							splicingCodeForFindUniquePrice = code + key + invokeOne;
//						}else {
//							Integer orderPriceInt = 0;
//							for (int i = 0; i < stitchModifyList.size(); i++) {
//								String projectPriceCode = code + "00027" + stitchModifyList.get(i);
//								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
//								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
//							}
//							orderPrice = String.valueOf(orderPriceInt);
//						}
//					}
					
					if ("wj_amfColor_id".equals(valueFour)) {
						HashSet<String> amfColorSet = new HashSet<String>();
						String wjAmfColor1 = optionJacketWashableInfo.getWjAmfColor1();
						amfColorSet.add(wjAmfColor1);
						String wjAmfColor2 = optionJacketWashableInfo.getWjAmfColor2();
						amfColorSet.add(wjAmfColor2);
						String wjAmfColor3 = optionJacketWashableInfo.getWjAmfColor3();
						amfColorSet.add(wjAmfColor3);
						String wjAmfColor4 = optionJacketWashableInfo.getWjAmfColor4();
						amfColorSet.add(wjAmfColor4);
						String wjAmfColor5 = optionJacketWashableInfo.getWjAmfColor5();
						amfColorSet.add(wjAmfColor5);
						String wjAmfColor6 = optionJacketWashableInfo.getWjAmfColor6();
						amfColorSet.add(wjAmfColor6);
						String wjAmfColor7 = optionJacketWashableInfo.getWjAmfColor7();
						amfColorSet.add(wjAmfColor7);
						String wjAmfColor8 = optionJacketWashableInfo.getWjAmfColor8();
						amfColorSet.add(wjAmfColor8);
						String wjAmfColor9 = optionJacketWashableInfo.getWjAmfColor9();
						amfColorSet.add(wjAmfColor9);
						
						amfColorSet.removeAll(Collections.singleton(null));
						amfColorSet.removeAll(Collections.singleton(""));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						
						if (OptionCodeKeys.JK_0002801.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) ||amfColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = null;
							if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00030" + amfColorList.get(0);
							String orderPriceInner = null;
							if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(amfColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("wj_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String wjBhColor1 = optionJacketWashableInfo.getWjBhColor1();
						bhColorSet.add(wjBhColor1);
						String wjBhColor2 = optionJacketWashableInfo.getWjBhColor2();
						bhColorSet.add(wjBhColor2);
						String wjBhColor3 = optionJacketWashableInfo.getWjBhColor3();
						bhColorSet.add(wjBhColor3);
						String wjBhColor4 = optionJacketWashableInfo.getWjBhColor4();
						bhColorSet.add(wjBhColor4);
						String wjBhColor5 = optionJacketWashableInfo.getWjBhColor5();
						bhColorSet.add(wjBhColor5);
						String wjBhColor6 = optionJacketWashableInfo.getWjBhColor6();
						bhColorSet.add(wjBhColor6);
						String wjBhColor7 = optionJacketWashableInfo.getWjBhColor7();
						bhColorSet.add(wjBhColor7);
						String wjBhColor8 = optionJacketWashableInfo.getWjBhColor8();
						bhColorSet.add(wjBhColor8);
						String wjBhColor9 = optionJacketWashableInfo.getWjBhColor9();
						bhColorSet.add(wjBhColor9);
						String wjBhColor10 = optionJacketWashableInfo.getWjBhColor10();
						bhColorSet.add(wjBhColor10);
						String wjBhColor11 = optionJacketWashableInfo.getWjBhColor11();
						bhColorSet.add(wjBhColor11);
						String wjBhColor12 = optionJacketWashableInfo.getWjBhColor12();
						bhColorSet.add(wjBhColor12);
						String wjBhColor13 = optionJacketWashableInfo.getWjBhColor13();
						bhColorSet.add(wjBhColor13);
						String wjBhColor14 = optionJacketWashableInfo.getWjBhColor14();
						bhColorSet.add(wjBhColor14);
						String wjBhColor15 = optionJacketWashableInfo.getWjBhColor15();
						bhColorSet.add(wjBhColor15);
						String wjBhColor16 = optionJacketWashableInfo.getWjBhColor16();
						bhColorSet.add(wjBhColor16);
						String wjBhColor17 = optionJacketWashableInfo.getWjBhColor17();
						bhColorSet.add(wjBhColor17);
						
						bhColorSet.removeAll(Collections.singleton(null));
						bhColorSet.removeAll(Collections.singleton(""));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						
						if (OptionCodeKeys.JK_0003101.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) ||bhColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = null;
							if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00033" + bhColorList.get(0);
							String orderPriceInner = null;
							if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("wj_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String wjByColor1 = optionJacketWashableInfo.getWjByColor1();
						byColorSet.add(wjByColor1);
						String wjByColor2 = optionJacketWashableInfo.getWjByColor2();
						byColorSet.add(wjByColor2);
						String wjByColor3 = optionJacketWashableInfo.getWjByColor3();
						byColorSet.add(wjByColor3);
						String wjByColor4 = optionJacketWashableInfo.getWjByColor4();
						byColorSet.add(wjByColor4);
						String wjByColor5 = optionJacketWashableInfo.getWjByColor5();
						byColorSet.add(wjByColor5);
						String wjByColor6 = optionJacketWashableInfo.getWjByColor6();
						byColorSet.add(wjByColor6);
						String wjByColor7 = optionJacketWashableInfo.getWjByColor7();
						byColorSet.add(wjByColor7);
						String wjByColor8 = optionJacketWashableInfo.getWjByColor8();
						byColorSet.add(wjByColor8);
						String wjByColor9 = optionJacketWashableInfo.getWjByColor9();
						byColorSet.add(wjByColor9);
						String wjByColor10 = optionJacketWashableInfo.getWjByColor10();
						byColorSet.add(wjByColor10);
						String wjByColor11 = optionJacketWashableInfo.getWjByColor11();
						byColorSet.add(wjByColor11);
						String wjByColor12 = optionJacketWashableInfo.getWjByColor12();
						byColorSet.add(wjByColor12);
						String wjByColor13 = optionJacketWashableInfo.getWjByColor13();
						byColorSet.add(wjByColor13);
						String wjByColor14 = optionJacketWashableInfo.getWjByColor14();
						byColorSet.add(wjByColor14);
						String wjByColor15 = optionJacketWashableInfo.getWjByColor15();
						byColorSet.add(wjByColor15);
						String wjByColor16 = optionJacketWashableInfo.getWjByColor16();
						byColorSet.add(wjByColor16);
						
						byColorSet.removeAll(Collections.singleton(null));
						byColorSet.removeAll(Collections.singleton(""));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						
						if (OptionCodeKeys.JK_0003401.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) ||byColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = null;
							if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00036" + byColorList.get(0);
							String orderPriceInner = null;
							if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				
				if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
					if("".equals(orderPrice)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
				}else{
					if("".equals(orderPrice)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
					}
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketWashableInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketWashableInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (JacketOptionCoWashablePriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = optionJacketWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(optionJacketWashableInfo);
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
		orderCoForm.setJkOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForJacketProject(OrderCoForm orderCoForm, String code, String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal,String thisValStkNo) {
		String productIs3Piece = orderCoForm.getProductIs3Piece();
		String productSparePantsClass = orderCoForm.getProductSparePantsClass();
		String productItem = orderCoForm.getProductItem();
		CoOptionJacketStandardInfo coOptionJacketStandardInfo = orderCoForm.getCoOptionJacketStandardInfo();
		String ojFrontBtnCnt = coOptionJacketStandardInfo.getOjFrontBtnCnt();
		JacketOptionCoStandardPriceEnum[] priceEnum = JacketOptionCoStandardPriceEnum.values();
		String orderPrice = "";
		String pantsOptionPrice = "";
		String giletOptionPrice = "";
		String pants2OptionPrice = "";
		for (JacketOptionCoStandardPriceEnum price : priceEnum) {
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
				if (idValueName.equals(valueFour)) {
					Method methodOne = coOptionJacketStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketStandardInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionJacketStandardInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionJacketStandardInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionJacketStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketStandardInfo);
					Method methodTwo = coOptionJacketStandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionJacketStandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				if("stitchModify_id".equals(idValueName) && "stitchModify_id".equals(valueFour)) {
					hasIdvalueName = true;
					if(BaseCheckUtil.isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split("/");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = null;
							if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				
				if("stitch_id".equals(idValueName) && "stitch_id".equals(valueFour)) {
					hasIdvalueName = true;
					splicingCodeForFindUniquePrice = code + key + thisVal;
					
					if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					
					if("01".equals(productItem)) {
						CoOptionPantsStandardInfo coOptionPantsStandardInfo = orderCoForm.getCoOptionPantsStandardInfo();
						String opPantsModel = coOptionPantsStandardInfo.getOpPantsModel();
						if(BaseCheckUtil.isNotEmpty(opPantsModel)) {
							String pantsCode = productItem + "03" + opPantsModel;
							Map<String, Object> orderPriceForPants = coPants1Helper.getOrderPriceForPantsModel(orderCoForm,pantsCode,"");
							pantsOptionPrice = (String) orderPriceForPants.get("optionPrice");
						}else {
							pantsOptionPrice = "0";
						}
						if("0009902".equals(productIs3Piece)) {
							CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
							String ogGiletModel = coOptionGiletStandardInfo.getOgGiletModel();
							if(BaseCheckUtil.isNotEmpty(ogGiletModel)) {
								String giletCode = productItem + "04" + ogGiletModel;
								Map<String, Object> orderPriceForGilet = coGiletHelper.getOrderPriceForGiletStandardModel(orderCoForm, giletCode, "");
								giletOptionPrice = (String) orderPriceForGilet.get("optionPrice");
							}else {
								giletOptionPrice = "0";
							}
						}else {
							giletOptionPrice = "0";
						}
						
						if("0009902".equals(productSparePantsClass)) {
							CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
							String op2PantsModel = coOptionPants2StandardInfo.getOp2PantsModel();
							if(BaseCheckUtil.isNotEmpty(op2PantsModel)) {
								String pants2Code = productItem + "07" + op2PantsModel;
								Map<String, Object> orderPriceForPants2 = coPants2Helper.getOrderPriceForPants2Model(orderCoForm, pants2Code, "");
								pants2OptionPrice = (String) orderPriceForPants2.get("optionPrice");
							}else {
								pants2OptionPrice = "0";
							}
						}else {
							pants2OptionPrice = "0";
						}
					}
				}
				
				if(("amfColor_id".equals(idValueName)&&"amfColor_id".equals(valueFour))||
					("bhColor_id".equals(idValueName)&&"bhColor_id".equals(valueFour))||
					("byColor_id".equals(idValueName))&&"byColor_id".equals(valueFour)) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = null;
					if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else {
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					if("-1".equals(colorCount)) {
						orderPrice = orderPriceInner;
					}else {
						Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
						orderPrice = String.valueOf(colorPrice);
					}
				}
				
				if(("btnMate".equals(idValueName) && "btnMate".equals(valueFour)) || ("btnMateStkNo".equals(idValueName) && "btnMateStkNo".equals(valueFour))) {
					hasIdvalueName = true;
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
					if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					if("01".equals(productItem)) {
						CoOptionPantsStandardInfo coOptionPantsStandardInfo = orderCoForm.getCoOptionPantsStandardInfo();
						String opPantsModel = coOptionPantsStandardInfo.getOpPantsModel();
						if(BaseCheckUtil.isNotEmpty(opPantsModel)) {
							String pantsCode = productItem + "03" + opPantsModel;
							Map<String, Object> orderPriceForPants = coPants1Helper.getOrderPriceForPantsModel(orderCoForm,pantsCode,"");
							pantsOptionPrice = (String) orderPriceForPants.get("optionPrice");
						}else {
							pantsOptionPrice = "0";
						}
						if("0009902".equals(productIs3Piece)) {
							CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
							String ogGiletModel = coOptionGiletStandardInfo.getOgGiletModel();
							if(BaseCheckUtil.isNotEmpty(ogGiletModel)) {
								String giletCode = productItem + "04" + ogGiletModel;
								Map<String, Object> orderPriceForGilet = coGiletHelper.getOrderPriceForGiletStandardModel(orderCoForm, giletCode, "");
								giletOptionPrice = (String) orderPriceForGilet.get("optionPrice");
							}else {
								giletOptionPrice = "0";
							}
						}else {
							giletOptionPrice = "0";
						}
						
						if("0009902".equals(productSparePantsClass)) {
							CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
							String op2PantsModel = coOptionPants2StandardInfo.getOp2PantsModel();
							if(BaseCheckUtil.isNotEmpty(op2PantsModel)) {
								String pants2Code = productItem + "07" + op2PantsModel;
								Map<String, Object> orderPriceForPants2 = coPants2Helper.getOrderPriceForPants2Model(orderCoForm, pants2Code, "");
								pants2OptionPrice = (String) orderPriceForPants2.get("optionPrice");
							}else {
								pants2OptionPrice = "0";
							}
						}else {
							pants2OptionPrice = "0";
						}
					}
				}

				if (hasIdvalueName == true) {
					if("0000105".equals(ojFrontBtnCnt) || "0000106".equals(ojFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketStandardInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketStandardInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (JacketOptionCoStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionJacketStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionJacketStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf)) && BaseCheckUtil.isNotEmpty(valueOf) && !"null".equals(valueOf)) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		 
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + CoContorllerPublicMethodUtil.formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		if("01".equals(productItem)) {
			if("btnMate".equals(idValueName) || "btnMateStkNo".equals(idValueName) || "stitch_id".equals(idValueName)) {
				resultMap.put("optionPtPrice", String.valueOf(pantsOptionPrice));
				if("0009902".equals(productIs3Piece)) {
					resultMap.put("optionGlPrice", String.valueOf(giletOptionPrice));
				}
				if("0009902".equals(productSparePantsClass)) {
					resultMap.put("optionPt2Price", String.valueOf(pants2OptionPrice));
				}
			}
		}
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setJkOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForJacketTuxedoProject(OrderCoForm orderCoForm, String code,
			String idValueName, String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal,String thisValStkNo) {
		CoOptionJacketTuxedoInfo coOptionJacketTuxedoInfo = orderCoForm.getCoOptionJacketTuxedoInfo();
		String tjFrontBtnCnt = coOptionJacketTuxedoInfo.getTjFrontBtnCnt();
		JacketOptionCoTuxedoPriceEnum[] priceEnum = JacketOptionCoTuxedoPriceEnum.values();
		String productItem = orderCoForm.getProductItem();
		String productIs3Piece = orderCoForm.getProductIs3Piece();
		String productSparePantsClass = orderCoForm.getProductSparePantsClass();
		String orderPrice = "";
		String pantsOptionPrice = "";
		String giletOptionPrice = "";
		String pants2OptionPrice = "";
		for (JacketOptionCoTuxedoPriceEnum price : priceEnum) {
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
				if (idValueName.equals(valueFour)) {
					Method methodOne = coOptionJacketTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketTuxedoInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionJacketTuxedoInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionJacketTuxedoInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionJacketTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketTuxedoInfo);
					Method methodTwo = coOptionJacketTuxedoInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionJacketTuxedoInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				
				if(("tj_stitch_id".equals(idValueName) && "tj_stitch_id".equals(valueFour))||
				   ("tj_GlossFablic".equals(idValueName) && "tj_GlossFablic".equals(valueFour))) {
					hasIdvalueName = true;
					splicingCodeForFindUniquePrice = code + key + thisVal;
					
					if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					
					if("01".equals(productItem)) {
						CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo = orderCoForm.getCoOptionPantsTuxedoInfo();
						String tpPantsModel = coOptionPantsTuxedoInfo.getTpPantsModel();
						if(BaseCheckUtil.isNotEmpty(tpPantsModel)) {
							String pantsCode = productItem + "03" + tpPantsModel;
							Map<String, Object> orderPriceForPants = coPants1Helper.getOrderPriceForPantsTuModel(orderCoForm, pantsCode, "");
							pantsOptionPrice = (String) orderPriceForPants.get("optionPrice");
						}else {
							pantsOptionPrice = "0";
						}
						if("0009902".equals(productIs3Piece)) {
							CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
							String tgGiletModel = coOptionGiletTuxedoInfo.getTgGiletModel();
							if(BaseCheckUtil.isNotEmpty(tgGiletModel)) {
								String giletCode = productItem + "04" + tgGiletModel;
								Map<String, Object> orderPriceForGilet = coGiletHelper.getOrderPriceForGiletTuxedoModel(orderCoForm, giletCode, "");
								giletOptionPrice = (String) orderPriceForGilet.get("optionPrice");
							}else {
								giletOptionPrice = "0";
							}
						}else {
							giletOptionPrice = "0";
						}
						
						if("0009902".equals(productSparePantsClass)) {
							CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
							String tp2PantsModel = coOptionPants2TuxedoInfo.getTp2PantsModel();
							if(BaseCheckUtil.isNotEmpty(tp2PantsModel)) {
								String pants2Code = productItem + "07" + tp2PantsModel;
								Map<String, Object> orderPriceForPants2 = coPants2Helper.getOrderPriceForPants2TuxedoModel(orderCoForm, pants2Code, "");
								pants2OptionPrice = (String) orderPriceForPants2.get("optionPrice");
							}else {
								pants2OptionPrice = "0";
							}
						}else {
							pants2OptionPrice = "0";
						}
					}
				}
				
				if(("tj_bhColor_id".equals(idValueName)&&"tj_bhColor_id".equals(valueFour))||
				   ("tj_byColor_id".equals(idValueName))&&"tj_byColor_id".equals(valueFour)) {
						hasIdvalueName = true;
						String projectPriceCode = code + jspOptionCodeAndBranchCode;
						String orderPriceInner = null;
						if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
							orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
						}else {
							orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
						}
						if("-1".equals(colorCount)) {
							orderPrice = orderPriceInner;
						}else {
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
							orderPrice = String.valueOf(colorPrice);
						}
				}
				
				if(("tj_btnMate".equals(idValueName) && "tj_btnMate".equals(valueFour)) || ("tj_btnMateStkNo".equals(idValueName) && "tj_btnMateStkNo".equals(valueFour))) {
					hasIdvalueName = true;
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
					if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					if("01".equals(productItem)) {
						CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo = orderCoForm.getCoOptionPantsTuxedoInfo();
						String tpPantsModel = coOptionPantsTuxedoInfo.getTpPantsModel();
						if(BaseCheckUtil.isNotEmpty(tpPantsModel)) {
							String pantsCode = productItem + "03" + tpPantsModel;
							Map<String, Object> orderPriceForPants = coPants1Helper.getOrderPriceForPantsTuModel(orderCoForm, pantsCode, "");
							pantsOptionPrice = (String) orderPriceForPants.get("optionPrice");
						}else {
							pantsOptionPrice = "0";
						}
						if("0009902".equals(productIs3Piece)) {
							CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
							String tgGiletModel = coOptionGiletTuxedoInfo.getTgGiletModel();
							if(BaseCheckUtil.isNotEmpty(tgGiletModel)) {
								String giletCode = productItem + "04" + tgGiletModel;
								Map<String, Object> orderPriceForGilet = coGiletHelper.getOrderPriceForGiletTuxedoModel(orderCoForm, giletCode, "");
								giletOptionPrice = (String) orderPriceForGilet.get("optionPrice");
							}else {
								giletOptionPrice = "0";
							}
						}else {
							giletOptionPrice = "0";
						}
						
						if("0009902".equals(productSparePantsClass)) {
							CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
							String tp2PantsModel = coOptionPants2TuxedoInfo.getTp2PantsModel();
							if(BaseCheckUtil.isNotEmpty(tp2PantsModel)) {
								String pants2Code = productItem + "07" + tp2PantsModel;
								Map<String, Object> orderPriceForPants2 = coPants2Helper.getOrderPriceForPants2TuxedoModel(orderCoForm, pants2Code, "");
								pants2OptionPrice = (String) orderPriceForPants2.get("optionPrice");
							}else {
								pants2OptionPrice = "0";
							}
						}else {
							pants2OptionPrice = "0";
						}
					}
				}

				if (hasIdvalueName == true) {
					if("0000105".equals(tjFrontBtnCnt) || "0000106".equals(tjFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketTuxedoInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketTuxedoInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (JacketOptionCoTuxedoPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionJacketTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionJacketTuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf)) && BaseCheckUtil.isNotEmpty(valueOf) && !"null".equals(valueOf)) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		 
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + CoContorllerPublicMethodUtil.formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		if("01".equals(productItem)) {
			if("tj_btnMate".equals(idValueName) || "tj_btnMateStkNo".equals(idValueName) || "tj_GlossFablic".equals(idValueName)|| "tj_stitch_id".equals(idValueName)) {
				resultMap.put("optionPtPrice", String.valueOf(pantsOptionPrice));
				if("0009902".equals(productIs3Piece)) {
					resultMap.put("optionGlPrice", String.valueOf(giletOptionPrice));
				}
				if("0009902".equals(productSparePantsClass)) {
					resultMap.put("optionPt2Price", String.valueOf(pants2OptionPrice));
				}
			}
		}
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setJkOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForJacketWashableProject(OrderCoForm orderCoForm, String code,
			String idValueName, String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal,String thisValStkNo) {
		CoOptionJacketWashableInfo coOptionJacketWashableInfo = orderCoForm.getCoOptionJacketWashableInfo();
		String productIs3Piece = orderCoForm.getProductIs3Piece();
		String productSparePantsClass = orderCoForm.getProductSparePantsClass();
		String productItem = orderCoForm.getProductItem();
		String wjFrontBtnCnt = coOptionJacketWashableInfo.getWjFrontBtnCnt();
		JacketOptionCoWashablePriceEnum[] priceEnum = JacketOptionCoWashablePriceEnum.values();
		String orderPrice = "";
		String pantsOptionPrice = "";
		String giletOptionPrice = "";
		String pants2OptionPrice = "";
		for (JacketOptionCoWashablePriceEnum price : priceEnum) {
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
				if (idValueName.equals(valueFour)) {
					Method methodOne = coOptionJacketWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketWashableInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionJacketWashableInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionJacketWashableInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionJacketWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionJacketWashableInfo);
					Method methodTwo = coOptionJacketWashableInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionJacketWashableInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				
				if("wj_stitchModify_id".equals(idValueName) && "wj_stitchModify_id".equals(valueFour)) {
					hasIdvalueName = true;
					if(BaseCheckUtil.isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split("/");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = null;
							if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
							}else {
								orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							}
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				
				if("wj_stitch_id".equals(idValueName) && "wj_stitch_id".equals(valueFour)) {
					hasIdvalueName = true;
					splicingCodeForFindUniquePrice = code + key + thisVal;
					
					if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					
					if("01".equals(productItem)) {
						CoOptionPantsWashableInfo coOptionPantsWashableInfo = orderCoForm.getCoOptionPantsWashableInfo();
						String wpPantsModel = coOptionPantsWashableInfo.getWpPantsModel();
						if(BaseCheckUtil.isNotEmpty(wpPantsModel)) {
							String pantsCode = productItem + "03" + wpPantsModel;
							Map<String, Object> orderPriceForPants = coPants1Helper.getOrderPriceForPantsWPModel(orderCoForm, pantsCode, "");
							pantsOptionPrice = (String) orderPriceForPants.get("optionPrice");
						}else {
							pantsOptionPrice = "0";
						}
						if("0009902".equals(productIs3Piece)) {
							CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
							String wgGiletModel = coOptionGiletWashableInfo.getWgGiletModel();
							if(BaseCheckUtil.isNotEmpty(wgGiletModel)) {
								String giletCode = productItem + "04" + wgGiletModel;
								Map<String, Object> orderPriceForGilet = coGiletHelper.getOrderPriceForGiletWashableModel(orderCoForm, giletCode, "");
								giletOptionPrice = (String) orderPriceForGilet.get("optionPrice");
							}else {
								giletOptionPrice = "0";
							}
						}else {
							giletOptionPrice = "0";
						}
						
						if("0009902".equals(productSparePantsClass)) {
							CoOptionPants2WashableInfo coOptionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
							String wp2PantsModel = coOptionPants2WashableInfo.getWp2PantsModel();
							if(BaseCheckUtil.isNotEmpty(wp2PantsModel)) {
								String pants2Code = productItem + "07" + wp2PantsModel;
								Map<String, Object> orderPriceForPants2 = coPants2Helper.getOrderPriceForPants2WashableModel(orderCoForm, pants2Code, "");
								pants2OptionPrice = (String) orderPriceForPants2.get("optionPrice");
							}else {
								pants2OptionPrice = "0";
							}
						}else {
							pants2OptionPrice = "0";
						}
					}
				}
				
				if(("wj_amfColor_id".equals(idValueName)&&"wj_amfColor_id".equals(valueFour))||
				   ("wj_bhColor_id".equals(idValueName)&&"wj_bhColor_id".equals(valueFour))||
				   ("wj_byColor_id".equals(idValueName))&&"wj_byColor_id".equals(valueFour)) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = null;
					if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else {
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					if("-1".equals(colorCount)) {
						orderPrice = orderPriceInner;
					}else {
						Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
						orderPrice = String.valueOf(colorPrice);
					}
				}
				
				if(("wj_btnMate".equals(idValueName) && "wj_btnMate".equals(valueFour)) || ("wj_btnMateStkNo".equals(idValueName) && "wj_btnMateStkNo".equals(valueFour))) {
					hasIdvalueName = true;
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
					if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					if("01".equals(productItem)) {
						CoOptionPantsWashableInfo coOptionPantsWashableInfo = orderCoForm.getCoOptionPantsWashableInfo();
						String wpPantsModel = coOptionPantsWashableInfo.getWpPantsModel();
						if(BaseCheckUtil.isNotEmpty(wpPantsModel)) {
							String pantsCode = productItem + "03" + wpPantsModel;
							Map<String, Object> orderPriceForPants = coPants1Helper.getOrderPriceForPantsWPModel(orderCoForm, pantsCode, "");
							pantsOptionPrice = (String) orderPriceForPants.get("optionPrice");
						}else {
							pantsOptionPrice = "0";
						}
						if("0009902".equals(productIs3Piece)) {
							CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
							String wgGiletModel = coOptionGiletWashableInfo.getWgGiletModel();
							if(BaseCheckUtil.isNotEmpty(wgGiletModel)) {
								String giletCode = productItem + "04" + wgGiletModel;
								Map<String, Object> orderPriceForGilet = coGiletHelper.getOrderPriceForGiletWashableModel(orderCoForm, giletCode, "");
								giletOptionPrice = (String) orderPriceForGilet.get("optionPrice");
							}else {
								giletOptionPrice = "0";
							}
						}else {
							giletOptionPrice = "0";
						}
						
						if("0009902".equals(productSparePantsClass)) {
							CoOptionPants2WashableInfo coOptionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
							String wp2PantsModel = coOptionPants2WashableInfo.getWp2PantsModel();
							if(BaseCheckUtil.isNotEmpty(wp2PantsModel)) {
								String pants2Code = productItem + "07" + wp2PantsModel;
								Map<String, Object> orderPriceForPants2 = coPants2Helper.getOrderPriceForPants2WashableModel(orderCoForm, pants2Code, "");
								pants2OptionPrice = (String) orderPriceForPants2.get("optionPrice");
							}else {
								pants2OptionPrice = "0";
							}
						}else {
							pants2OptionPrice = "0";
						}
					}
				}
				
				if (hasIdvalueName == true) {
					
					if("0000105".equals(wjFrontBtnCnt) || "0000106".equals(wjFrontBtnCnt)) {
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}else{
						if("".equals(orderPrice)) {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketWashableInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionJacketWashableInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (JacketOptionCoWashablePriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionJacketWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionJacketWashableInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf)) && BaseCheckUtil.isNotEmpty(valueOf) && !"null".equals(valueOf)) {
					optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				}
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		 
		if("0".equals(orderPrice)) {
			orderPrice = "無料";
		}else {
			orderPrice = "￥" + CoContorllerPublicMethodUtil.formatPrice(orderPrice);
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		if("01".equals(productItem)) {
			if("wj_btnMate".equals(idValueName) || "wj_btnMateStkNo".equals(idValueName) || "wj_stitch_id".equals(idValueName)) {
				resultMap.put("optionPtPrice", String.valueOf(pantsOptionPrice));
				if("0009902".equals(productIs3Piece)) {
					resultMap.put("optionGlPrice", String.valueOf(giletOptionPrice));
				}
				if("0009902".equals(productSparePantsClass)) {
					resultMap.put("optionPt2Price", String.valueOf(pants2OptionPrice));
				}
			}
		}
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setJkOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}
	
}
