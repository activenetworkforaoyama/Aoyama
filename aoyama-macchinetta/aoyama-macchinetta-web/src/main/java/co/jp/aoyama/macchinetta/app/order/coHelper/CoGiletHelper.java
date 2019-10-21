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
import co.jp.aoyama.macchinetta.app.order.OrderCoController;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm;
import co.jp.aoyama.macchinetta.app.order.TypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionCoStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionCoTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionCoWashablePriceEnum;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Model;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.ModelService;
import co.jp.aoyama.macchinetta.domain.service.order.OrderService;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;

public class CoGiletHelper {
	
	@Inject
	TypeSizeService typeSizeService;
	
	CoTypeSizeOptimization coTypeSizeOptimization = new CoTypeSizeOptimization();

	public boolean giletCheckHelper(ResultMessages messages ,OrderCoForm orderCoForm, String productCategory, String item, Map<String, List<Adjust>> adjustByItem, TypeSizeService typeSizeService) {
		boolean giletFlag = false;
		
		if ("9000101".equals(productCategory)) {
			// GILETモデル未選択の場合
			CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
			String ogGiletModel = coOptionGiletStandardInfo.getOgGiletModel();
			if ("".equals(ogGiletModel) || null == ogGiletModel) {
				messages.add("E031", "GILET モデル");
				giletFlag = true;
			}
			//GILET ステッチ箇所変更
			String ogStitchModify = coOptionGiletStandardInfo.getOgStitchModify();
			if (OptionCodeKeys.GL_0000602.equals(ogStitchModify)) {
				String ogStitchModifyPlace1 = coOptionGiletStandardInfo.getOgStitchModifyPlace1();
				String ogStitchModifyPlace2 = coOptionGiletStandardInfo.getOgStitchModifyPlace2();
				String ogStitchModifyPlace3 = coOptionGiletStandardInfo.getOgStitchModifyPlace3();

				if (BaseCheckUtil.isEmpty(ogStitchModifyPlace1) && BaseCheckUtil.isEmpty(ogStitchModifyPlace2) && BaseCheckUtil.isEmpty(ogStitchModifyPlace3)) {
					messages.add("E033", "GILET ステッチ箇所変更");
					giletFlag = true;
				}
			}
			//GILET ダブルステッチ
			String ogDStitchModify = coOptionGiletStandardInfo.getOgDStitchModify();
			if (OptionCodeKeys.GL_0002602.equals(ogDStitchModify)) {
				String ogDStitchModifyPlace1 = coOptionGiletStandardInfo.getOgDStitchModifyPlace1();
				String ogDStitchModifyPlace2 = coOptionGiletStandardInfo.getOgDStitchModifyPlace2();
				String ogDStitchModifyPlace3 = coOptionGiletStandardInfo.getOgDStitchModifyPlace3();

				if (BaseCheckUtil.isEmpty(ogDStitchModifyPlace1) && BaseCheckUtil.isEmpty(ogDStitchModifyPlace2) && BaseCheckUtil.isEmpty(ogDStitchModifyPlace3)) {
					messages.add("E033", "GILET ダブルステッチ");
					giletFlag = true;
				}
			}
			//GILET AMF色指定
			String ogAmfColor = coOptionGiletStandardInfo.getOgAmfColor();
			if (OptionCodeKeys.GL_0000802.equals(ogAmfColor)) {
				String ogAmfColorPlace1 = coOptionGiletStandardInfo.getOgAmfColorPlace1();
				String ogAmfColorPlace2 = coOptionGiletStandardInfo.getOgAmfColorPlace2();
				String ogAmfColorPlace3 = coOptionGiletStandardInfo.getOgAmfColorPlace3();

				String ogAmfColor1 = coOptionGiletStandardInfo.getOgAmfColor1();
				String ogAmfColor2 = coOptionGiletStandardInfo.getOgAmfColor2();
				String ogAmfColor3 = coOptionGiletStandardInfo.getOgAmfColor3();
				if (BaseCheckUtil.isEmpty(ogAmfColorPlace1) && BaseCheckUtil.isEmpty(ogAmfColorPlace2) && BaseCheckUtil.isEmpty(ogAmfColorPlace3)) {
					messages.add("E032", "GILET AMF色指定");
					giletFlag = true;
				}
				if(BaseCheckUtil.isNotEmpty(ogAmfColorPlace1)&&BaseCheckUtil.isEmpty(ogAmfColor1)||BaseCheckUtil.isNotEmpty(ogAmfColorPlace2)&&BaseCheckUtil.isEmpty(ogAmfColor2)||
						BaseCheckUtil.isNotEmpty(ogAmfColorPlace3)&&BaseCheckUtil.isEmpty(ogAmfColor3)) {
					messages.add("E032", "GILET AMF色指定");
					giletFlag = true;
				}
			}
			//GILET ボタンホール色指定
			String ogBhColor = coOptionGiletStandardInfo.getOgBhColor();
			if (OptionCodeKeys.GL_0001102.equals(ogBhColor)) {
				String ogBhColorPlace1 = coOptionGiletStandardInfo.getOgBhColorPlace1();
				String ogBhColorPlace2 = coOptionGiletStandardInfo.getOgBhColorPlace2();
				String ogBhColorPlace3 = coOptionGiletStandardInfo.getOgBhColorPlace3();
				String ogBhColorPlace4 = coOptionGiletStandardInfo.getOgBhColorPlace4();
				String ogBhColorPlace5 = coOptionGiletStandardInfo.getOgBhColorPlace5();
				String ogBhColorPlace6 = coOptionGiletStandardInfo.getOgBhColorPlace6();

				String ogBhColor1 = coOptionGiletStandardInfo.getOgBhColor1();
				String ogBhColor2 = coOptionGiletStandardInfo.getOgBhColor2();
				String ogBhColor3 = coOptionGiletStandardInfo.getOgBhColor3();
				String ogBhColor4 = coOptionGiletStandardInfo.getOgBhColor4();
				String ogBhColor5 = coOptionGiletStandardInfo.getOgBhColor5();
				String ogBhColor6 = coOptionGiletStandardInfo.getOgBhColor6();
				
				if (BaseCheckUtil.isEmpty(ogBhColorPlace1) && BaseCheckUtil.isEmpty(ogBhColorPlace2) && BaseCheckUtil.isEmpty(ogBhColorPlace3)
						&& BaseCheckUtil.isEmpty(ogBhColorPlace4) && BaseCheckUtil.isEmpty(ogBhColorPlace5) && BaseCheckUtil.isEmpty(ogBhColorPlace6)) {
					messages.add("E032", "GILET ボタンホール色指定");
					giletFlag = true;
				}
				if(BaseCheckUtil.isNotEmpty(ogBhColorPlace1)&&BaseCheckUtil.isEmpty(ogBhColor1)||BaseCheckUtil.isNotEmpty(ogBhColorPlace2)&&BaseCheckUtil.isEmpty(ogBhColor2)||
						BaseCheckUtil.isNotEmpty(ogBhColorPlace3)&&BaseCheckUtil.isEmpty(ogBhColor3)||BaseCheckUtil.isNotEmpty(ogBhColorPlace4)&&BaseCheckUtil.isEmpty(ogBhColor4)||
						BaseCheckUtil.isNotEmpty(ogBhColorPlace5)&&BaseCheckUtil.isEmpty(ogBhColor5)||BaseCheckUtil.isNotEmpty(ogBhColorPlace6)&&BaseCheckUtil.isEmpty(ogBhColor6)) {
					messages.add("E032", "GILET ボタンホール色指定");
					giletFlag = true;
				}
			}
			//GILET ボタン付け糸指定
			String ogByColor = coOptionGiletStandardInfo.getOgByColor();
			if (OptionCodeKeys.GL_0001402.equals(ogByColor)) {
				String ogByColorPlace1 = coOptionGiletStandardInfo.getOgByColorPlace1();
				String ogByColorPlace2 = coOptionGiletStandardInfo.getOgByColorPlace2();
				String ogByColorPlace3 = coOptionGiletStandardInfo.getOgByColorPlace3();
				String ogByColorPlace4 = coOptionGiletStandardInfo.getOgByColorPlace4();
				String ogByColorPlace5 = coOptionGiletStandardInfo.getOgByColorPlace5();
				String ogByColorPlace6 = coOptionGiletStandardInfo.getOgByColorPlace6();
				String ogByColorPlace7 = coOptionGiletStandardInfo.getOgByColorPlace7();
				String ogByColorPlace8 = coOptionGiletStandardInfo.getOgByColorPlace8();
				String ogByColorPlace9 = coOptionGiletStandardInfo.getOgByColorPlace9();
				String ogByColorPlace10 = coOptionGiletStandardInfo.getOgByColorPlace10();

				String ogByColor1 = coOptionGiletStandardInfo.getOgByColor1();
				String ogByColor2 = coOptionGiletStandardInfo.getOgByColor2();
				String ogByColor3 = coOptionGiletStandardInfo.getOgByColor3();
				String ogByColor4 = coOptionGiletStandardInfo.getOgByColor4();
				String ogByColor5 = coOptionGiletStandardInfo.getOgByColor5();
				String ogByColor6 = coOptionGiletStandardInfo.getOgByColor6();
				String ogByColor7 = coOptionGiletStandardInfo.getOgByColor7();
				String ogByColor8 = coOptionGiletStandardInfo.getOgByColor8();
				String ogByColor9 = coOptionGiletStandardInfo.getOgByColor9();
				String ogByColor10 = coOptionGiletStandardInfo.getOgByColor10();
				if (BaseCheckUtil.isEmpty(ogByColorPlace1) && BaseCheckUtil.isEmpty(ogByColorPlace2) && BaseCheckUtil.isEmpty(ogByColorPlace3)
						&& BaseCheckUtil.isEmpty(ogByColorPlace4) && BaseCheckUtil.isEmpty(ogByColorPlace5) && BaseCheckUtil.isEmpty(ogByColorPlace6)
						&& BaseCheckUtil.isEmpty(ogByColorPlace7) && BaseCheckUtil.isEmpty(ogByColorPlace8) && BaseCheckUtil.isEmpty(ogByColorPlace9)
						&& BaseCheckUtil.isEmpty(ogByColorPlace10)) {
					messages.add("E032", "GILET ボタン付け糸指定");
					giletFlag = true;
				}
				if(BaseCheckUtil.isNotEmpty(ogByColorPlace1)&&BaseCheckUtil.isEmpty(ogByColor1)||BaseCheckUtil.isNotEmpty(ogByColorPlace2)&&BaseCheckUtil.isEmpty(ogByColor2)||
						BaseCheckUtil.isNotEmpty(ogByColorPlace3)&&BaseCheckUtil.isEmpty(ogByColor3)||BaseCheckUtil.isNotEmpty(ogByColorPlace4)&&BaseCheckUtil.isEmpty(ogByColor4)||
						BaseCheckUtil.isNotEmpty(ogByColorPlace5)&&BaseCheckUtil.isEmpty(ogByColor5)||BaseCheckUtil.isNotEmpty(ogByColorPlace6)&&BaseCheckUtil.isEmpty(ogByColor6)||
						BaseCheckUtil.isNotEmpty(ogByColorPlace7)&&BaseCheckUtil.isEmpty(ogByColor7)||BaseCheckUtil.isNotEmpty(ogByColorPlace8)&&BaseCheckUtil.isEmpty(ogByColor8)||
						BaseCheckUtil.isNotEmpty(ogByColorPlace9)&&BaseCheckUtil.isEmpty(ogByColor9)||BaseCheckUtil.isNotEmpty(ogByColorPlace10)&&BaseCheckUtil.isEmpty(ogByColor10)) {
					messages.add("E032", "GILET ボタン付け糸指定");
					giletFlag = true;
				}
			}
			
		}else if ("9000102".equals(productCategory)) {
			// GILET モデル未選択の場合
			CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
			String tgGiletModel = coOptionGiletTuxedoInfo.getTgGiletModel();
			if ("".equals(tgGiletModel) || null == tgGiletModel) {
				messages.add("E031", "GILET モデル");
				giletFlag = true;
			}
			//GILET ボタンホール色指定
			String tgBhColor = coOptionGiletTuxedoInfo.getTgBhColor();
			if (OptionCodeKeys.GL_0001102.equals(tgBhColor)) {
				String tgBhColorPlace1 = coOptionGiletTuxedoInfo.getTgBhColorPlace1();
				String tgBhColorPlace2 = coOptionGiletTuxedoInfo.getTgBhColorPlace2();
				String tgBhColorPlace3 = coOptionGiletTuxedoInfo.getTgBhColorPlace3();
				String tgBhColorPlace4 = coOptionGiletTuxedoInfo.getTgBhColorPlace4();
				String tgBhColorPlace5 = coOptionGiletTuxedoInfo.getTgBhColorPlace5();
				String tgBhColorPlace6 = coOptionGiletTuxedoInfo.getTgBhColorPlace6();

				String tgBhColor1 = coOptionGiletTuxedoInfo.getTgBhColor1();
				String tgBhColor2 = coOptionGiletTuxedoInfo.getTgBhColor2();
				String tgBhColor3 = coOptionGiletTuxedoInfo.getTgBhColor3();
				String tgBhColor4 = coOptionGiletTuxedoInfo.getTgBhColor4();
				String tgBhColor5 = coOptionGiletTuxedoInfo.getTgBhColor5();
				String tgBhColor6 = coOptionGiletTuxedoInfo.getTgBhColor6();
				
				if (BaseCheckUtil.isEmpty(tgBhColorPlace1) && BaseCheckUtil.isEmpty(tgBhColorPlace2) && BaseCheckUtil.isEmpty(tgBhColorPlace3)
						&& BaseCheckUtil.isEmpty(tgBhColorPlace4) && BaseCheckUtil.isEmpty(tgBhColorPlace5) && BaseCheckUtil.isEmpty(tgBhColorPlace6)) {
					messages.add("E032", "GILET ボタンホール色指定");
					giletFlag = true;
				}
				if(BaseCheckUtil.isNotEmpty(tgBhColorPlace1)&&BaseCheckUtil.isEmpty(tgBhColor1)||BaseCheckUtil.isNotEmpty(tgBhColorPlace2)&&BaseCheckUtil.isEmpty(tgBhColor2)||
						BaseCheckUtil.isNotEmpty(tgBhColorPlace3)&&BaseCheckUtil.isEmpty(tgBhColor3)||BaseCheckUtil.isNotEmpty(tgBhColorPlace4)&&BaseCheckUtil.isEmpty(tgBhColor4)||
						BaseCheckUtil.isNotEmpty(tgBhColorPlace5)&&BaseCheckUtil.isEmpty(tgBhColor5)||BaseCheckUtil.isNotEmpty(tgBhColorPlace6)&&BaseCheckUtil.isEmpty(tgBhColor6)) {
					messages.add("E032", "GILET ボタンホール色指定");
					giletFlag = true;
				}
			}
			//GILET ボタン付け糸指定
			String tgByColor = coOptionGiletTuxedoInfo.getTgByColor();
			if (OptionCodeKeys.GL_0001402.equals(tgByColor)) {
				String tgByColorPlace1 = coOptionGiletTuxedoInfo.getTgByColorPlace1();
				String tgByColorPlace2 = coOptionGiletTuxedoInfo.getTgByColorPlace2();
				String tgByColorPlace3 = coOptionGiletTuxedoInfo.getTgByColorPlace3();
				String tgByColorPlace4 = coOptionGiletTuxedoInfo.getTgByColorPlace4();
				String tgByColorPlace5 = coOptionGiletTuxedoInfo.getTgByColorPlace5();
				String tgByColorPlace6 = coOptionGiletTuxedoInfo.getTgByColorPlace6();
				String tgByColorPlace7 = coOptionGiletTuxedoInfo.getTgByColorPlace7();
				String tgByColorPlace8 = coOptionGiletTuxedoInfo.getTgByColorPlace8();
				String tgByColorPlace9 = coOptionGiletTuxedoInfo.getTgByColorPlace9();
				String tgByColorPlace10 = coOptionGiletTuxedoInfo.getTgByColorPlace10();

				String tgByColor1 = coOptionGiletTuxedoInfo.getTgByColor1();
				String tgByColor2 = coOptionGiletTuxedoInfo.getTgByColor2();
				String tgByColor3 = coOptionGiletTuxedoInfo.getTgByColor3();
				String tgByColor4 = coOptionGiletTuxedoInfo.getTgByColor4();
				String tgByColor5 = coOptionGiletTuxedoInfo.getTgByColor5();
				String tgByColor6 = coOptionGiletTuxedoInfo.getTgByColor6();
				String tgByColor7 = coOptionGiletTuxedoInfo.getTgByColor7();
				String tgByColor8 = coOptionGiletTuxedoInfo.getTgByColor8();
				String tgByColor9 = coOptionGiletTuxedoInfo.getTgByColor9();
				String tgByColor10 = coOptionGiletTuxedoInfo.getTgByColor10();
				if (BaseCheckUtil.isEmpty(tgByColorPlace1) && BaseCheckUtil.isEmpty(tgByColorPlace2) && BaseCheckUtil.isEmpty(tgByColorPlace3)
						&& BaseCheckUtil.isEmpty(tgByColorPlace4) && BaseCheckUtil.isEmpty(tgByColorPlace5) && BaseCheckUtil.isEmpty(tgByColorPlace6)
						&& BaseCheckUtil.isEmpty(tgByColorPlace7) && BaseCheckUtil.isEmpty(tgByColorPlace8) && BaseCheckUtil.isEmpty(tgByColorPlace9)
						&& BaseCheckUtil.isEmpty(tgByColorPlace10)) {
					messages.add("E032", "GILET ボタン付け糸指定");
					giletFlag = true;
				}
				if(BaseCheckUtil.isNotEmpty(tgByColorPlace1)&&BaseCheckUtil.isEmpty(tgByColor1)||BaseCheckUtil.isNotEmpty(tgByColorPlace2)&&BaseCheckUtil.isEmpty(tgByColor2)||
						BaseCheckUtil.isNotEmpty(tgByColorPlace3)&&BaseCheckUtil.isEmpty(tgByColor3)||BaseCheckUtil.isNotEmpty(tgByColorPlace4)&&BaseCheckUtil.isEmpty(tgByColor4)||
						BaseCheckUtil.isNotEmpty(tgByColorPlace5)&&BaseCheckUtil.isEmpty(tgByColor5)||BaseCheckUtil.isNotEmpty(tgByColorPlace6)&&BaseCheckUtil.isEmpty(tgByColor6)||
						BaseCheckUtil.isNotEmpty(tgByColorPlace7)&&BaseCheckUtil.isEmpty(tgByColor7)||BaseCheckUtil.isNotEmpty(tgByColorPlace8)&&BaseCheckUtil.isEmpty(tgByColor8)||
						BaseCheckUtil.isNotEmpty(tgByColorPlace9)&&BaseCheckUtil.isEmpty(tgByColor9)||BaseCheckUtil.isNotEmpty(tgByColorPlace10)&&BaseCheckUtil.isEmpty(tgByColor10)) {
					messages.add("E032", "GILET ボタン付け糸指定");
					giletFlag = true;
				}
			}
		} else if ("9000103".equals(productCategory)) {
			// GILET モデル未選択の場合
			CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
			String wgGiletModel = coOptionGiletWashableInfo.getWgGiletModel();
			if ("".equals(wgGiletModel) || null == wgGiletModel) {
				messages.add("E031", "GILET モデル");
				giletFlag = true;
			}
			
			//GILET ステッチ箇所変更
			String wgStitchModify = coOptionGiletWashableInfo.getWgStitchModify();
			if (OptionCodeKeys.GL_0000602.equals(wgStitchModify)) {
				String wgStitchModifyPlace1 = coOptionGiletWashableInfo.getWgStitchModifyPlace1();
				String wgStitchModifyPlace2 = coOptionGiletWashableInfo.getWgStitchModifyPlace2();
				String wgStitchModifyPlace3 = coOptionGiletWashableInfo.getWgStitchModifyPlace3();

				if (BaseCheckUtil.isEmpty(wgStitchModifyPlace1) && BaseCheckUtil.isEmpty(wgStitchModifyPlace2) && BaseCheckUtil.isEmpty(wgStitchModifyPlace3)) {
					messages.add("E033", "GILET ステッチ箇所変更");
					giletFlag = true;
				}
			}
			//GILET ダブルステッチ
			String wgDStitchModify = coOptionGiletWashableInfo.getWgDStitchModify();
			if (OptionCodeKeys.GL_0002602.equals(wgDStitchModify)) {
				String wgDStitchModifyPlace1 = coOptionGiletWashableInfo.getWgDStitchModifyPlace1();
				String wgDStitchModifyPlace2 = coOptionGiletWashableInfo.getWgDStitchModifyPlace2();
				String wgDStitchModifyPlace3 = coOptionGiletWashableInfo.getWgDStitchModifyPlace3();

				if (BaseCheckUtil.isEmpty(wgDStitchModifyPlace1) && BaseCheckUtil.isEmpty(wgDStitchModifyPlace2) && BaseCheckUtil.isEmpty(wgDStitchModifyPlace3)) {
					messages.add("E033", "GILET ダブルステッチ");
					giletFlag = true;
				}
			}
			//GILET AMF色指定
			String wgAmfColor = coOptionGiletWashableInfo.getWgAmfColor();
			if (OptionCodeKeys.GL_0000802.equals(wgAmfColor)) {
				String wgAmfColorPlace1 = coOptionGiletWashableInfo.getWgAmfColorPlace1();
				String wgAmfColorPlace2 = coOptionGiletWashableInfo.getWgAmfColorPlace2();
				String wgAmfColorPlace3 = coOptionGiletWashableInfo.getWgAmfColorPlace3();

				String wgAmfColor1 = coOptionGiletWashableInfo.getWgAmfColor1();
				String wgAmfColor2 = coOptionGiletWashableInfo.getWgAmfColor2();
				String wgAmfColor3 = coOptionGiletWashableInfo.getWgAmfColor3();
				if (BaseCheckUtil.isEmpty(wgAmfColorPlace1) && BaseCheckUtil.isEmpty(wgAmfColorPlace2) && BaseCheckUtil.isEmpty(wgAmfColorPlace3)) {
					messages.add("E032", "GILET AMF色指定");
					giletFlag = true;
				}
				if(BaseCheckUtil.isNotEmpty(wgAmfColorPlace1)&&BaseCheckUtil.isEmpty(wgAmfColor1)||BaseCheckUtil.isNotEmpty(wgAmfColorPlace2)&&BaseCheckUtil.isEmpty(wgAmfColor2)||
						BaseCheckUtil.isNotEmpty(wgAmfColorPlace3)&&BaseCheckUtil.isEmpty(wgAmfColor3)) {
					messages.add("E032", "GILET AMF色指定");
					giletFlag = true;
				}
			}
			//GILET ボタンホール色指定
			String wgBhColor = coOptionGiletWashableInfo.getWgBhColor();
			if (OptionCodeKeys.GL_0001102.equals(wgBhColor)) {
				String wgBhColorPlace1 = coOptionGiletWashableInfo.getWgBhColorPlace1();
				String wgBhColorPlace2 = coOptionGiletWashableInfo.getWgBhColorPlace2();
				String wgBhColorPlace3 = coOptionGiletWashableInfo.getWgBhColorPlace3();
				String wgBhColorPlace4 = coOptionGiletWashableInfo.getWgBhColorPlace4();
				String wgBhColorPlace5 = coOptionGiletWashableInfo.getWgBhColorPlace5();
				String wgBhColorPlace6 = coOptionGiletWashableInfo.getWgBhColorPlace6();

				String wgBhColor1 = coOptionGiletWashableInfo.getWgBhColor1();
				String wgBhColor2 = coOptionGiletWashableInfo.getWgBhColor2();
				String wgBhColor3 = coOptionGiletWashableInfo.getWgBhColor3();
				String wgBhColor4 = coOptionGiletWashableInfo.getWgBhColor4();
				String wgBhColor5 = coOptionGiletWashableInfo.getWgBhColor5();
				String wgBhColor6 = coOptionGiletWashableInfo.getWgBhColor6();
				
				if (BaseCheckUtil.isEmpty(wgBhColorPlace1) && BaseCheckUtil.isEmpty(wgBhColorPlace2) && BaseCheckUtil.isEmpty(wgBhColorPlace3)
						&& BaseCheckUtil.isEmpty(wgBhColorPlace4) && BaseCheckUtil.isEmpty(wgBhColorPlace5) && BaseCheckUtil.isEmpty(wgBhColorPlace6)) {
					messages.add("E032", "GILET ボタンホール色指定");
					giletFlag = true;
				}
				if(BaseCheckUtil.isNotEmpty(wgBhColorPlace1)&&BaseCheckUtil.isEmpty(wgBhColor1)||BaseCheckUtil.isNotEmpty(wgBhColorPlace2)&&BaseCheckUtil.isEmpty(wgBhColor2)||
						BaseCheckUtil.isNotEmpty(wgBhColorPlace3)&&BaseCheckUtil.isEmpty(wgBhColor3)||BaseCheckUtil.isNotEmpty(wgBhColorPlace4)&&BaseCheckUtil.isEmpty(wgBhColor4)||
						BaseCheckUtil.isNotEmpty(wgBhColorPlace5)&&BaseCheckUtil.isEmpty(wgBhColor5)||BaseCheckUtil.isNotEmpty(wgBhColorPlace6)&&BaseCheckUtil.isEmpty(wgBhColor6)) {
					messages.add("E032", "GILET ボタンホール色指定");
					giletFlag = true;
				}
			}
			//GILET ボタン付け糸指定
			String wgByColor = coOptionGiletWashableInfo.getWgByColor();
			if (OptionCodeKeys.GL_0001402.equals(wgByColor)) {
				String wgByColorPlace1 = coOptionGiletWashableInfo.getWgByColorPlace1();
				String wgByColorPlace2 = coOptionGiletWashableInfo.getWgByColorPlace2();
				String wgByColorPlace3 = coOptionGiletWashableInfo.getWgByColorPlace3();
				String wgByColorPlace4 = coOptionGiletWashableInfo.getWgByColorPlace4();
				String wgByColorPlace5 = coOptionGiletWashableInfo.getWgByColorPlace5();
				String wgByColorPlace6 = coOptionGiletWashableInfo.getWgByColorPlace6();
				String wgByColorPlace7 = coOptionGiletWashableInfo.getWgByColorPlace7();
				String wgByColorPlace8 = coOptionGiletWashableInfo.getWgByColorPlace8();
				String wgByColorPlace9 = coOptionGiletWashableInfo.getWgByColorPlace9();
				String wgByColorPlace10 = coOptionGiletWashableInfo.getWgByColorPlace10();

				String wgByColor1 = coOptionGiletWashableInfo.getWgByColor1();
				String wgByColor2 = coOptionGiletWashableInfo.getWgByColor2();
				String wgByColor3 = coOptionGiletWashableInfo.getWgByColor3();
				String wgByColor4 = coOptionGiletWashableInfo.getWgByColor4();
				String wgByColor5 = coOptionGiletWashableInfo.getWgByColor5();
				String wgByColor6 = coOptionGiletWashableInfo.getWgByColor6();
				String wgByColor7 = coOptionGiletWashableInfo.getWgByColor7();
				String wgByColor8 = coOptionGiletWashableInfo.getWgByColor8();
				String wgByColor9 = coOptionGiletWashableInfo.getWgByColor9();
				String wgByColor10 = coOptionGiletWashableInfo.getWgByColor10();
				if (BaseCheckUtil.isEmpty(wgByColorPlace1) && BaseCheckUtil.isEmpty(wgByColorPlace2) && BaseCheckUtil.isEmpty(wgByColorPlace3)
						&& BaseCheckUtil.isEmpty(wgByColorPlace4) && BaseCheckUtil.isEmpty(wgByColorPlace5) && BaseCheckUtil.isEmpty(wgByColorPlace6)
						&& BaseCheckUtil.isEmpty(wgByColorPlace7) && BaseCheckUtil.isEmpty(wgByColorPlace8) && BaseCheckUtil.isEmpty(wgByColorPlace9)
						&& BaseCheckUtil.isEmpty(wgByColorPlace10)) {
					messages.add("E032", "GILET ボタン付け糸指定");
					giletFlag = true;
				}
				if(BaseCheckUtil.isNotEmpty(wgByColorPlace1)&&BaseCheckUtil.isEmpty(wgByColor1)||BaseCheckUtil.isNotEmpty(wgByColorPlace2)&&BaseCheckUtil.isEmpty(wgByColor2)||
						BaseCheckUtil.isNotEmpty(wgByColorPlace3)&&BaseCheckUtil.isEmpty(wgByColor3)||BaseCheckUtil.isNotEmpty(wgByColorPlace4)&&BaseCheckUtil.isEmpty(wgByColor4)||
						BaseCheckUtil.isNotEmpty(wgByColorPlace5)&&BaseCheckUtil.isEmpty(wgByColor5)||BaseCheckUtil.isNotEmpty(wgByColorPlace6)&&BaseCheckUtil.isEmpty(wgByColor6)||
						BaseCheckUtil.isNotEmpty(wgByColorPlace7)&&BaseCheckUtil.isEmpty(wgByColor7)||BaseCheckUtil.isNotEmpty(wgByColorPlace8)&&BaseCheckUtil.isEmpty(wgByColor8)||
						BaseCheckUtil.isNotEmpty(wgByColorPlace9)&&BaseCheckUtil.isEmpty(wgByColor9)||BaseCheckUtil.isNotEmpty(wgByColorPlace10)&&BaseCheckUtil.isEmpty(wgByColor10)) {
					messages.add("E032", "GILET ボタン付け糸指定");
					giletFlag = true;
				}
			}
		}
		
		// 補正
		CoAdjustGiletStandardInfo coAdjustGiletStandardInfo = orderCoForm.getCoAdjustGiletStandardInfo();
		if (coAdjustGiletStandardInfo == null) {
			messages.add("E031", "GILET サイズ");
			giletFlag = true;
		} else {
			String sizeFigure = coAdjustGiletStandardInfo.getSizeFigure();
			if ("".equals(sizeFigure) || null == sizeFigure) {
				messages.add("E031", "GILET サイズ体型");
				giletFlag = true;
			}
			String sizeNumber = coAdjustGiletStandardInfo.getSizeNumber();
			if ("".equals(sizeNumber) || null == sizeNumber) {
				messages.add("E031", "GILET サイズ号数");
				giletFlag = true;
			}
			
			if(BaseCheckUtil.isNotEmpty(sizeFigure)&&BaseCheckUtil.isNotEmpty(sizeNumber)) {
				String corGlBodySize = coAdjustGiletStandardInfo.getCorGlBodySize();
				if("".equals(corGlBodySize)||"0".equals(corGlBodySize)||corGlBodySize == null) {
					messages.add("E034", "GILETの着丈修正");
					giletFlag = true;
				}
				
				String corGlBustSize = coAdjustGiletStandardInfo.getCorGlBustSize();
				if("".equals(corGlBustSize)||"0".equals(corGlBustSize)||corGlBustSize == null) {
					messages.add("E034", "GILETのバスト修正");
					giletFlag = true;
				}
				
				String corGlWaistSize = coAdjustGiletStandardInfo.getCorGlWaistSize();
				if("".equals(corGlWaistSize)||"0".equals(corGlWaistSize)||corGlWaistSize == null) {
					messages.add("E034", "GILETのウエスト修正");
					giletFlag = true;
				}
				
				List<TypeSizeOptimization> coGlTypeSizeOptimization = this.getCoGlTypeSizeOptimization(orderCoForm,typeSizeService);
				List<Adjust> glAdjustList = adjustByItem.get("04");
				if(!glAdjustList.isEmpty()&&!coGlTypeSizeOptimization.isEmpty()) {
					for (Adjust adjust : glAdjustList) {
						Map<String, String> glStandardValue = this
								.getGlStandardValue(coGlTypeSizeOptimization);

						// GILET_着丈_型サイズ
						String stringCorGlBodylengthSize = glStandardValue.get("corGlBodylengthSize");
						BigDecimal corGlBodylengthSize = new BigDecimal(stringCorGlBodylengthSize);

						// GILET_バスト_型サイズ
						String stringCorGlBustSize = glStandardValue.get("corGlBustSize");
						BigDecimal corGlBustlengthSize = new BigDecimal(stringCorGlBustSize);

						// GILET_ウエスト_型サイズ
						String stringCorGlWaistSize = glStandardValue.get("corGlWaistSize");
						BigDecimal corGlWaistlengthSize = new BigDecimal(stringCorGlWaistSize);

						// GILET_着丈_グロス
						BigDecimal corGlBodylengthGross = new BigDecimal(coAdjustGiletStandardInfo.getCorGlBodyGross());

						// GILET_バスト_グロス
						BigDecimal corGlBustGross = new BigDecimal(coAdjustGiletStandardInfo.getCorGlBustGross());

						// GILET_ウエスト_グロス
						BigDecimal corGlWaistGross = new BigDecimal(coAdjustGiletStandardInfo.getCorGlWaistGross());
						if(item.equals(adjust.getItemCode())) {
							if("04".equals(adjust.getSubItemCode())) {
								// 着丈修正
								if ("01".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corGlBodylengthSize);
									BigDecimal addMax = adjusteMax.add(corGlBodylengthSize);
									if (corGlBodylengthGross.compareTo(addMin) == -1
											|| corGlBodylengthGross.compareTo(addMax) == 1) {
										messages.add("E035", "GILETの着丈修正");
										giletFlag = true;
									}
								}
								// バスト修正
								if ("14".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corGlBustlengthSize);
									BigDecimal addMax = adjusteMax.add(corGlBustlengthSize);
									if (corGlBustGross.compareTo(addMin) == -1 || corGlBustGross.compareTo(addMax) == 1) {
										messages.add("E035", "GILETのバスト修正");
										giletFlag = true;
									}
								}
								// ウエスト修正
								if ("02".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corGlWaistlengthSize);
									BigDecimal addMax = adjusteMax.add(corGlWaistlengthSize);
									if (corGlWaistGross.compareTo(addMin) == -1 || corGlWaistGross.compareTo(addMax) == 1) {
										messages.add("E035", "GILETのウエスト修正");
										giletFlag = true;
									}
								}
							}
						}
					}
				}
			}
		}
		
		return giletFlag;
		
	}
	
	/**
	 *GILETの標準値取得
	 * @param orderCoForm
	 * @return
	 */
	public List<TypeSizeOptimization> getCoGlTypeSizeOptimization(OrderCoForm orderCoForm, TypeSizeService typeSizeService) {
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
	 * GILETの補正標準値
	 * @param coJkTypeSizeOptimization
	 * @return
	 */
	public Map<String, String> getGlStandardValue(List<TypeSizeOptimization> coGlTypeSizeOptimization) {
		Map<String,String> adjustGlStandardValue = new HashMap<String,String>();
		for(TypeSizeOptimization typeSizeOptimization : coGlTypeSizeOptimization) {
			// 着丈修正
			if("01".equals(typeSizeOptimization.getAdjustClass())) {
				String corGlBodylengthSize = typeSizeOptimization.getTypeSize();
				adjustGlStandardValue.put("corGlBodylengthSize", corGlBodylengthSize);
			}
			// バスト修正
			else if("14".equals(typeSizeOptimization.getAdjustClass())) {
				String corGlBustSize = typeSizeOptimization.getTypeSize();
				adjustGlStandardValue.put("corGlBustSize", corGlBustSize);
			}
			// ウエスト修正
			else if("02".equals(typeSizeOptimization.getAdjustClass())) {
				String corGlWaistSize = typeSizeOptimization.getTypeSize();
				adjustGlStandardValue.put("corGlWaistSize", corGlWaistSize);
			}
		}
		return adjustGlStandardValue;
	}
	
	public void optionGiletDbToOrder(String productItem, String productCategory, OrderCoController orderCoController,
			Order order, OrderCoForm orderCoForm, OrderListService orderListService, ModelService modelService,
			OrderService orderService, String orderFlag) {
		Order orderGl = orderListService.findOrderGlOptionByOrderId(order.getOrderId());
		if(orderGl !=null ) {
			this.giletDefaultValueFromDb(orderCoForm, orderGl);
		}else {
			this.giletDefaultValue(orderCoForm);
		}
		
		Order orderGlAd = orderListService.findOrderGlByPk(order.getOrderId());
		CoAdjustGiletStandardInfo coAdjustGiletStandardInfo = orderCoForm.getCoAdjustGiletStandardInfo();
		if(coAdjustGiletStandardInfo == null ) {
			coAdjustGiletStandardInfo = new CoAdjustGiletStandardInfo();
			orderCoForm.setCoAdjustGiletStandardInfo(coAdjustGiletStandardInfo);
		}
		if (orderGlAd != null) {
			this.giletAdjustFromDb(orderCoForm, orderGlAd);
		}
		
		if ("9000101".equals(productCategory)) {
			CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
			String ogGiletModel = coOptionGiletStandardInfo.getOgGiletModel();
			if (ogGiletModel != null && !"".equals(ogGiletModel)) {
				String code = productItem.concat("04").concat(ogGiletModel);
				orderCoController.getOrderPriceForGiletStandardModel(orderCoForm, code,orderFlag);
				// ステッチ箇所変更
				String stitchModifyValue = coOptionGiletStandardInfo.getOgStitchModify();
				String stitchModifyCountArr = coOptionGiletStandardInfo.getOgStitchModifyPlace();
				if ("0000602".equals(stitchModifyValue)&&BaseCheckUtil.isNotEmpty(stitchModifyCountArr)) {
//					String stitchModifyCode = productItem.concat("02").concat(ogGiletModel).concat("00006");
					String stitchModifyCode = productItem.concat("04").concat(ogGiletModel);
					String stitchModifyValueName = "og_stitchModify_id";
					if(!stitchModifyCountArr.startsWith("/")) {
						orderCoController.getOrderPriceForGiletStandardProject(orderCoForm, stitchModifyCode,
								stitchModifyValueName, "", "", stitchModifyCountArr, stitchModifyValue, "");
					}
				}
				// ダブルステッチ変更
				String dSitchModifyValue = coOptionGiletStandardInfo.getOgDStitchModify();
				String dSitchModifyCountArr = coOptionGiletStandardInfo.getOgDStitchModifyPlace();
				if ("0002602".equals(dSitchModifyValue)&&BaseCheckUtil.isNotEmpty(dSitchModifyCountArr)) {
//					String dStitchModifyCode = productItem.concat("02").concat(ogGiletModel).concat("00027");
					String dStitchModifyCode = productItem.concat("04").concat(ogGiletModel);
					String dSitchModifyValueName = "og_dStitchModify_id";
					if(!dSitchModifyCountArr.startsWith("/")) {
						orderCoController.getOrderPriceForGiletStandardProject(orderCoForm, dStitchModifyCode,
								dSitchModifyValueName, "", "", dSitchModifyCountArr, dSitchModifyValue, "");
					}
				}
				// AMF色指定
				String glAmfColorCd = coOptionGiletStandardInfo.getOgAmfAllColor();
				if (glAmfColorCd != null && !"".equals(glAmfColorCd)&&!glAmfColorCd.startsWith("/")) {
				String amfValueName = "og_amfColor_id";
				String amfCode = productItem.concat("04").concat(ogGiletModel);
				Map<String, String> amfColorMap = new HashMap<String, String>();
				
					String[] glAmfColorSplit = glAmfColorCd.split("/");
					for (String amfColor : glAmfColorSplit) {
						amfColorMap.put(amfColor, amfColor);
					}
				
				String amfColorCount = String.valueOf(amfColorMap.size());
				List<String> amfValuesList = new ArrayList<String>(amfColorMap.values());
				String amfColorCode = "00010".concat(amfValuesList.get(0));
				orderCoController.getOrderPriceForGiletStandardProject(orderCoForm, amfCode, amfValueName, amfColorCode,
						amfColorCount, "", "", "");
				}
				// ボタンホール色指定
				String glBtnholeColorCd = coOptionGiletStandardInfo.getOgBhAllColor();
				if (glBtnholeColorCd != null && !"".equals(glBtnholeColorCd)&&!glBtnholeColorCd.startsWith("/")) {
				String bhValueName = "og_bhColor_id";
				String bhCode = productItem.concat("04").concat(ogGiletModel);
				Map<String, String> bhColorMap = new HashMap<String, String>();
				
					String[] glBtnholeColorSplit = glBtnholeColorCd.split("/");
					for (String btnholeColor : glBtnholeColorSplit) {
						bhColorMap.put(btnholeColor, btnholeColor);
					}
				
				String bhColorCount = String.valueOf(bhColorMap.size());
				List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
				String bhColorCode = "00013".concat(bhValuesList.get(0));
				orderCoController.getOrderPriceForGiletStandardProject(orderCoForm, bhCode, bhValueName, bhColorCode,
						bhColorCount, "", "", "");
				}
				// ボタン付け糸指定
				String glBtnthreadColorCd = coOptionGiletStandardInfo.getOgByAllColor();
				if (glBtnthreadColorCd != null && !"".equals(glBtnthreadColorCd)&&!glBtnthreadColorCd.startsWith("/")) {
				String byValueName = "og_byColor_id";
				String byCode = productItem.concat("04").concat(ogGiletModel);
				Map<String, String> byColorMap = new HashMap<String, String>();
				
					String[] glBtnthreadColorSplit = glBtnthreadColorCd.split("/");
					for (String btnthreadColor : glBtnthreadColorSplit) {
						byColorMap.put(btnthreadColor, btnthreadColor);
					}
				
				String byColorCount = String.valueOf(byColorMap.size());
				List<String> byValuesList = new ArrayList<String>(byColorMap.values());
				String byColorCode = "00016".concat(byValuesList.get(0));
				orderCoController.getOrderPriceForGiletStandardProject(orderCoForm, byCode, byValueName, byColorCode,
						byColorCount, "", "", "");
				}
			}else {
				orderCoForm.setGlOptionPrice("0");
			}
		}else if("9000102".equals(productCategory)) {
			CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
			String tgGiletModel = coOptionGiletTuxedoInfo.getTgGiletModel();
			if (tgGiletModel != null && !"".equals(tgGiletModel)) {
				String code = productItem.concat("04").concat(tgGiletModel);
				orderCoController.getOrderPriceForGiletTuxedoModel(orderCoForm, code,orderFlag);
				// ボタンホール色指定
				String glBtnholeColorCd = coOptionGiletTuxedoInfo.getTgBhAllColor();
				if (glBtnholeColorCd != null && !"".equals(glBtnholeColorCd)&&!glBtnholeColorCd.startsWith("/")) {
				String bhValueName = "tg_bhColor_id";
				String bhCode = productItem.concat("04").concat(tgGiletModel);
				Map<String, String> bhColorMap = new HashMap<String, String>();
				
					String[] glBtnholeColorSplit = glBtnholeColorCd.split("/");
					for (String btnholeColor : glBtnholeColorSplit) {
						bhColorMap.put(btnholeColor, btnholeColor);
					}
				
				String bhColorCount = String.valueOf(bhColorMap.size());
				List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
				String bhColorCode = "00013".concat(bhValuesList.get(0));
				orderCoController.getOrderPriceForGiletTuxedoProject(orderCoForm, bhCode, bhValueName, bhColorCode,
						bhColorCount, "", "", "");
				}
				// ボタン付け糸指定
				String glBtnthreadColorCd = coOptionGiletTuxedoInfo.getTgByAllColor();
				if (glBtnthreadColorCd != null && !"".equals(glBtnthreadColorCd)&&!glBtnthreadColorCd.startsWith("/")) {
				String byValueName = "tg_byColor_id";
				String byCode = productItem.concat("04").concat(tgGiletModel);
				Map<String, String> byColorMap = new HashMap<String, String>();
				
					String[] glBtnthreadColorSplit = glBtnthreadColorCd.split("/");
					for (String btnthreadColor : glBtnthreadColorSplit) {
						byColorMap.put(btnthreadColor, btnthreadColor);
					}
				
				String byColorCount = String.valueOf(byColorMap.size());
				List<String> byValuesList = new ArrayList<String>(byColorMap.values());
				String byColorCode = "00016".concat(byValuesList.get(0));
				orderCoController.getOrderPriceForGiletTuxedoProject(orderCoForm, byCode, byValueName, byColorCode,
						byColorCount, "", "", "");
				}
			}else {
				orderCoForm.setGlOptionPrice("0");
			}
		}else if("9000103".equals(productCategory)) {
			CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
			String wgGiletModel = coOptionGiletWashableInfo.getWgGiletModel();
			if (wgGiletModel != null && !"".equals(wgGiletModel)) {
				String code = productItem.concat("04").concat(wgGiletModel);
				orderCoController.getOrderPriceForGiletWashableModel(orderCoForm, code,orderFlag);
				// ステッチ箇所変更
				String stitchModifyValue = coOptionGiletWashableInfo.getWgStitchModify();
				String stitchModifyCountArr = coOptionGiletWashableInfo.getWgStitchModifyPlace();
				if ("0000602".equals(stitchModifyValue)&&BaseCheckUtil.isNotEmpty(stitchModifyCountArr)) {
//					String stitchModifyCode = productItem.concat("02").concat(ogGiletModel).concat("00006");
					String stitchModifyCode = productItem.concat("04").concat(wgGiletModel);
					String stitchModifyValueName = "wg_stitchModify_id";
					if(!stitchModifyCountArr.startsWith("/")) {
						orderCoController.getOrderPriceForGiletWashableProject(orderCoForm, stitchModifyCode,
								stitchModifyValueName, "", "", stitchModifyCountArr, stitchModifyValue, "");
					}
				}
				// ダブルステッチ変更
				String dSitchModifyValue = coOptionGiletWashableInfo.getWgDStitchModify();
				String dSitchModifyCountArr = coOptionGiletWashableInfo.getWgDStitchModifyPlace();
				if ("0002602".equals(dSitchModifyValue)&&BaseCheckUtil.isNotEmpty(dSitchModifyCountArr)) {
//					String dStitchModifyCode = productItem.concat("02").concat(ogGiletModel).concat("00027");
					String dStitchModifyCode = productItem.concat("04").concat(wgGiletModel);
					String dSitchModifyValueName = "wg_dStitchModify_id";
					if(!dSitchModifyCountArr.startsWith("/")) {
						orderCoController.getOrderPriceForGiletWashableProject(orderCoForm, dStitchModifyCode,
								dSitchModifyValueName, "", "", dSitchModifyCountArr, dSitchModifyValue, "");
					}
				}
				// AMF色指定
				String glAmfColorCd = coOptionGiletWashableInfo.getWgAmfAllColor();
				if (glAmfColorCd != null && !"".equals(glAmfColorCd)&&!glAmfColorCd.startsWith("/")) {
				String amfValueName = "wg_amfColor_id";
				String amfCode = productItem.concat("04").concat(wgGiletModel);
				Map<String, String> colorMap = new HashMap<String, String>();
				
					String[] glAmfColorSplit = glAmfColorCd.split("/");
					for (String amfColor : glAmfColorSplit) {
						colorMap.put(amfColor, amfColor);
					}
				
				String amfColorCount = String.valueOf(colorMap.size());
				List<String> valuesList = new ArrayList<String>(colorMap.values());
				String amfColorCode = "00010".concat(valuesList.get(0));
				orderCoController.getOrderPriceForGiletWashableProject(orderCoForm, amfCode, amfValueName, amfColorCode,
						amfColorCount, "", "", "");
				}
				// ボタンホール色指定
				String glBtnholeColorCd = coOptionGiletWashableInfo.getWgBhAllColor();
				if (glBtnholeColorCd != null && !"".equals(glBtnholeColorCd)&&!glBtnholeColorCd.startsWith("/")) {
				String bhValueName = "wg_bhColor_id";
				String bhCode = productItem.concat("04").concat(wgGiletModel);
				Map<String, String> bhColorMap = new HashMap<String, String>();
				
					String[] glBtnholeColorSplit = glBtnholeColorCd.split("/");
					for (String btnholeColor : glBtnholeColorSplit) {
						bhColorMap.put(btnholeColor, btnholeColor);
					}
				
				String bhColorCount = String.valueOf(bhColorMap.size());
				List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
				String bhColorCode = "00013".concat(bhValuesList.get(0));
				orderCoController.getOrderPriceForGiletWashableProject(orderCoForm, bhCode, bhValueName, bhColorCode,
						bhColorCount, "", "", "");
				}
				// ボタン付け糸指定
				String glBtnthreadColorCd = coOptionGiletWashableInfo.getWgByAllColor();
				if (glBtnthreadColorCd != null && !"".equals(glBtnthreadColorCd)&&!glBtnthreadColorCd.startsWith("/")) {
				String byValueName = "wg_byColor_id";
				String byCode = productItem.concat("04").concat(wgGiletModel);
				Map<String, String> byColorMap = new HashMap<String, String>();
				
					String[] glBtnthreadColorSplit = glBtnthreadColorCd.split("/");
					for (String btnthreadColor : glBtnthreadColorSplit) {
						byColorMap.put(btnthreadColor, btnthreadColor);
					}
				
				String byColorCount = String.valueOf(byColorMap.size());
				List<String> byValuesList = new ArrayList<String>(byColorMap.values());
				String byColorCode = "00016".concat(byValuesList.get(0));
				orderCoController.getOrderPriceForGiletWashableProject(orderCoForm, byCode, byValueName, byColorCode,
						byColorCount, "", "", "");
				}
			}else {
				orderCoForm.setGlOptionPrice("0");
			}
		}
		
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getItemModel(order.getOrderPattern(), 
				productItem, "04");
		this.getGiletModelMap(orderCoForm, modelList);
	}
	
	public void getGiletModelMap(OrderCoForm orderCoForm, List<Model> modelList) {
		LinkedHashMap<String, String> modelMap = new LinkedHashMap<String, String>();
		for (Model model : modelList) {
			modelMap.put("", "モデル選択");
			modelMap.put(model.getModelCode(), model.getModelName());
		}
		orderCoForm.getCoOptionGiletStandardInfo().setOgGiletModelMap(modelMap);
		orderCoForm.getCoOptionGiletTuxedoInfo().setTgGiletModelMap(modelMap);
		orderCoForm.getCoOptionGiletWashableInfo().setWgGiletModelMap(modelMap);
	}
	
	public void giletDefaultValue(OrderCoForm orderCoForm) {
		// 標準
		CoOptionGiletStandardInfo optionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
		optionGiletStandardInfo.setOgGiletModel("");
		optionGiletStandardInfo.setOgBreastPkt(OptionCodeKeys.GL_0000101);
		optionGiletStandardInfo.setOgWaistPkt(OptionCodeKeys.GL_0000201);
		optionGiletStandardInfo.setOgWaistPktSpec(OptionCodeKeys.GL_0000301);
		optionGiletStandardInfo.setOgStitch(OptionCodeKeys.GL_0000504);
		optionGiletStandardInfo.setOgStitchModify(OptionCodeKeys.GL_0000601);
		optionGiletStandardInfo.setOgDStitchModify(OptionCodeKeys.GL_0002601);
		optionGiletStandardInfo.setOgAmfColor(OptionCodeKeys.GL_0000801);
		optionGiletStandardInfo.setOgBhColor(OptionCodeKeys.GL_0001101);
		optionGiletStandardInfo.setOgByColor(OptionCodeKeys.GL_0001401);
		optionGiletStandardInfo.setOgBackLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletStandardInfo.setOgBackLiningMateStkNo(null);
		optionGiletStandardInfo.setOgInsideLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletStandardInfo.setOgInsideLiningMateStkNo(null);
		if("1".equals(orderCoForm.getOjBtnMatePtFlag())) {
		}else {
			optionGiletStandardInfo.setOgFrontBtnMate(OptionCodeKeys.GL_3000800);
			optionGiletStandardInfo.setOgFrontBtnMateStkNo(null);
		}
		optionGiletStandardInfo.setOgBackBelt(OptionCodeKeys.GL_0002302);
		optionGiletStandardInfo.setOgWatchChain(OptionCodeKeys.GL_0002401);

		// タキシード
		CoOptionGiletTuxedoInfo optionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
		optionGiletTuxedoInfo.setTgGiletModel("");
		optionGiletTuxedoInfo.setTgBreastPkt(OptionCodeKeys.GL_0000101);
		optionGiletTuxedoInfo.setTgWaistPkt(OptionCodeKeys.GL_0000201);
		optionGiletTuxedoInfo.setTgWaistPktSpec(OptionCodeKeys.GL_0000301);
		optionGiletTuxedoInfo.setTgWaistPktMate(OptionCodeKeys.GL_0000401);
		optionGiletTuxedoInfo.setTgStitch(OptionCodeKeys.GL_0000503);
		optionGiletTuxedoInfo.setTgBhColor(OptionCodeKeys.GL_0001101);
		optionGiletTuxedoInfo.setTgByColor(OptionCodeKeys.GL_0001401);
		optionGiletTuxedoInfo.setTgBackLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletTuxedoInfo.setTgBackLiningMateStkNo(null);
		optionGiletTuxedoInfo.setTgInsideLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletTuxedoInfo.setTgInsideLiningMateStkNo(null);
		if("1".equals(orderCoForm.getOjBtnMatePtFlag())) {
		}else {
			optionGiletTuxedoInfo.setTgFrontBtnMate(OptionCodeKeys.GL_3000800);
			optionGiletTuxedoInfo.setTgFrontBtnMateStkNo(null);
		}
		optionGiletTuxedoInfo.setTgBackBelt(OptionCodeKeys.GL_0002302);
		optionGiletTuxedoInfo.setTgWatchChain(OptionCodeKeys.GL_0002401);

		// ウォッシャブル
		CoOptionGiletWashableInfo optionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
		optionGiletWashableInfo.setWgGiletModel("");
		optionGiletWashableInfo.setWgBreastPkt(OptionCodeKeys.GL_0000101);
		optionGiletWashableInfo.setWgWaistPkt(OptionCodeKeys.GL_0000201);
		optionGiletWashableInfo.setWgWaistPktSpec(OptionCodeKeys.GL_0000301);
		optionGiletWashableInfo.setWgStitch(OptionCodeKeys.GL_0000504);
		optionGiletWashableInfo.setWgStitchModify(OptionCodeKeys.GL_0000601);
		optionGiletWashableInfo.setWgDStitchModify(OptionCodeKeys.GL_0002601);
		optionGiletWashableInfo.setWgAmfColor(OptionCodeKeys.GL_0000801);
		optionGiletWashableInfo.setWgBhColor(OptionCodeKeys.GL_0001101);
		optionGiletWashableInfo.setWgByColor(OptionCodeKeys.GL_0001401);
		optionGiletWashableInfo.setWgBackLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletWashableInfo.setWgBackLiningMateStkNo(null);
		optionGiletWashableInfo.setWgInsideLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletWashableInfo.setWgInsideLiningMateStkNo(null);
		if("1".equals(orderCoForm.getOjBtnMatePtFlag())) {
		}else {
			optionGiletWashableInfo.setWgFrontBtnMate(OptionCodeKeys.GL_3000800);
			optionGiletWashableInfo.setWgFrontBtnMateStkNo(null);
		}
		optionGiletWashableInfo.setWgBackBelt(OptionCodeKeys.GL_0002302);
		optionGiletWashableInfo.setWgWatchChain(OptionCodeKeys.GL_0002401);
	}
	
	public void giletDefaultValueFromDb(OrderCoForm orderCoForm, Order orderGl) {
		String productCategory = orderCoForm.getProductCategory();
	
		if ("9000101".equals(productCategory)) {
			CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
			coOptionGiletStandardInfo.setOgGiletModel(orderGl.getGlModelCd());
			coOptionGiletStandardInfo.setOgBreastPkt(orderGl.getGlBreastPktCd());
			coOptionGiletStandardInfo.setOgWaistPkt(orderGl.getGlWaistPktCd());
			coOptionGiletStandardInfo.setOgWaistPktSpec(orderGl.getGlWaistPktShapeCd());
			coOptionGiletStandardInfo.setOgStitch(orderGl.getGlAmfStitchCd());
			coOptionGiletStandardInfo.setOgStitchModify(orderGl.getGlStitchPlcType());
			coOptionGiletStandardInfo.setOgStitchModifyPlace(orderGl.getGlStitchPlcCd());
			coOptionGiletStandardInfo.setOgDStitchModify(orderGl.getGlDblstitchPlcType());
			coOptionGiletStandardInfo.setOgDStitchModifyPlace(orderGl.getGlDblstitchPlcCd());
			coOptionGiletStandardInfo.setOgAmfColor(orderGl.getGlAmfColorType());
			coOptionGiletStandardInfo.setOgAmfColorPlace(orderGl.getGlAmfColorPlcCd());
			coOptionGiletStandardInfo.setOgAmfAllColor(orderGl.getGlAmfColorCd());
			coOptionGiletStandardInfo.setOgBhColor(orderGl.getGlBtnholeColorType());
			coOptionGiletStandardInfo.setOgBhColorPlace(orderGl.getGlBtnholeColorPlcCd());
			coOptionGiletStandardInfo.setOgBhAllColor(orderGl.getGlBtnholeColorCd());
			coOptionGiletStandardInfo.setOgByColor(orderGl.getGlBtnthreadColorType());
			coOptionGiletStandardInfo.setOgByColorPlace(orderGl.getGlBtnthreadColorPlcCd());
			coOptionGiletStandardInfo.setOgByAllColor(orderGl.getGlBtnthreadColorCd());
			coOptionGiletStandardInfo.setOgBackLiningMate(orderGl.getGlBackClothType());
			coOptionGiletStandardInfo.setOgBackLiningMateStkNo(orderGl.getGlBackClothCd());
			coOptionGiletStandardInfo.setOgInsideLiningMate(orderGl.getGlInnnerClothType());
			coOptionGiletStandardInfo.setOgInsideLiningMateStkNo(orderGl.getGlInnnerClothCd());
			coOptionGiletStandardInfo.setOgFrontBtnMate(orderGl.getGlFrtBtnType());
			coOptionGiletStandardInfo.setOgFrontBtnMateStkNo(orderGl.getGlFrtBtnCd());
			coOptionGiletStandardInfo.setOgBackBelt(orderGl.getGlBackBeltCd());
			coOptionGiletStandardInfo.setOgWatchChain(orderGl.getGlWatchChainCd());
			
			pluralGlStandardOptionItem(coOptionGiletStandardInfo, orderGl);
			
		}else if ("9000102".equals(productCategory)) {
			CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
			coOptionGiletTuxedoInfo.setTgGiletModel(orderGl.getGlModelCd());
			coOptionGiletTuxedoInfo.setTgBreastPkt(orderGl.getGlBreastPktCd());
			coOptionGiletTuxedoInfo.setTgWaistPkt(orderGl.getGlWaistPktCd());
			coOptionGiletTuxedoInfo.setTgWaistPktSpec(orderGl.getGlWaistPktShapeCd());
			coOptionGiletTuxedoInfo.setTgStitch(orderGl.getGlAmfStitchCd());
			coOptionGiletTuxedoInfo.setTgStitchModify(orderGl.getGlStitchPlcType());
			coOptionGiletTuxedoInfo.setTgDblstitchPlc(orderGl.getGlDblstitchPlcType());
			coOptionGiletTuxedoInfo.setTgBhColor(orderGl.getGlBtnholeColorType());
			coOptionGiletTuxedoInfo.setTgBhColorPlace(orderGl.getGlBtnholeColorPlcCd());
			coOptionGiletTuxedoInfo.setTgBhAllColor(orderGl.getGlBtnholeColorCd());
			coOptionGiletTuxedoInfo.setTgByColor(orderGl.getGlBtnthreadColorType());
			coOptionGiletTuxedoInfo.setTgByColorPlace(orderGl.getGlBtnthreadColorPlcCd());
			coOptionGiletTuxedoInfo.setTgByAllColor(orderGl.getGlBtnthreadColorCd());
			coOptionGiletTuxedoInfo.setTgBackLiningMate(orderGl.getGlBackClothType());
			coOptionGiletTuxedoInfo.setTgBackLiningMateStkNo(orderGl.getGlBackClothCd());
			coOptionGiletTuxedoInfo.setTgInsideLiningMate(orderGl.getGlInnnerClothType());
			coOptionGiletTuxedoInfo.setTgInsideLiningMateStkNo(orderGl.getGlInnnerClothCd());
			coOptionGiletTuxedoInfo.setTgFrontBtnMate(orderGl.getGlFrtBtnType());
			coOptionGiletTuxedoInfo.setTgFrontBtnMateStkNo(orderGl.getGlFrtBtnCd());
			coOptionGiletTuxedoInfo.setTgBackBelt(orderGl.getGlBackBeltCd());
			coOptionGiletTuxedoInfo.setTgWatchChain(orderGl.getGlWatchChainCd());
			
			pluralGlTuxedoOptionItem(coOptionGiletTuxedoInfo, orderGl);
			
		}else if ("9000103".equals(productCategory)) {
			CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
			coOptionGiletWashableInfo.setWgGiletModel(orderGl.getGlModelCd());
			coOptionGiletWashableInfo.setWgBreastPkt(orderGl.getGlBreastPktCd());
			coOptionGiletWashableInfo.setWgWaistPkt(orderGl.getGlWaistPktCd());
			coOptionGiletWashableInfo.setWgWaistPktSpec(orderGl.getGlWaistPktShapeCd());
			coOptionGiletWashableInfo.setWgStitch(orderGl.getGlAmfStitchCd());
			coOptionGiletWashableInfo.setWgStitchModify(orderGl.getGlStitchPlcType());
			coOptionGiletWashableInfo.setWgStitchModifyPlace(orderGl.getGlStitchPlcCd());
			coOptionGiletWashableInfo.setWgDStitchModify(orderGl.getGlDblstitchPlcType());
			coOptionGiletWashableInfo.setWgDStitchModifyPlace(orderGl.getGlDblstitchPlcCd());
			coOptionGiletWashableInfo.setWgAmfColor(orderGl.getGlAmfColorType());
			coOptionGiletWashableInfo.setWgAmfColorPlace(orderGl.getGlAmfColorPlcCd());
			coOptionGiletWashableInfo.setWgAmfAllColor(orderGl.getGlAmfColorCd());
			coOptionGiletWashableInfo.setWgBhColor(orderGl.getGlBtnholeColorType());
			coOptionGiletWashableInfo.setWgBhColorPlace(orderGl.getGlBtnholeColorPlcCd());
			coOptionGiletWashableInfo.setWgBhAllColor(orderGl.getGlBtnholeColorCd());
			coOptionGiletWashableInfo.setWgByColor(orderGl.getGlBtnthreadColorType());
			coOptionGiletWashableInfo.setWgByColorPlace(orderGl.getGlBtnthreadColorPlcCd());
			coOptionGiletWashableInfo.setWgByAllColor(orderGl.getGlBtnthreadColorCd());
			coOptionGiletWashableInfo.setWgBackLiningMate(orderGl.getGlBackClothType());
			coOptionGiletWashableInfo.setWgBackLiningMateStkNo(orderGl.getGlBackClothCd());
			coOptionGiletWashableInfo.setWgInsideLiningMate(orderGl.getGlInnnerClothType());
			coOptionGiletWashableInfo.setWgInsideLiningMateStkNo(orderGl.getGlInnnerClothCd());
			coOptionGiletWashableInfo.setWgFrontBtnMate(orderGl.getGlFrtBtnType());
			coOptionGiletWashableInfo.setWgFrontBtnMateStkNo(orderGl.getGlFrtBtnCd());
			coOptionGiletWashableInfo.setWgBackBelt(orderGl.getGlBackBeltCd());
			coOptionGiletWashableInfo.setWgWatchChain(orderGl.getGlWatchChainCd());
			
			pluralGlWashableOptionItem(coOptionGiletWashableInfo, orderGl);
		}
	}
	
	private void pluralGlStandardOptionItem(CoOptionGiletStandardInfo coOptionGiletStandardInfo, Order orderGl) {
		String regex = "/";
		//ステッチ箇所変更
		String glStitchPlcCd = orderGl.getGlStitchPlcCd();
		if(glStitchPlcCd != null && !"".equals(glStitchPlcCd)&&!glStitchPlcCd.startsWith(regex)) {
			String[] glStitchPlcCdStr = glStitchPlcCd.split(regex);
			for (String glStitchPlcCdInner : glStitchPlcCdStr) {
				if("0000701".equals(glStitchPlcCdInner)) {
					coOptionGiletStandardInfo.setOgStitchModifyPlace1(glStitchPlcCdInner);
				}else if("0000704".equals(glStitchPlcCdInner)) {
					coOptionGiletStandardInfo.setOgStitchModifyPlace2(glStitchPlcCdInner);
				}else if("0000705".equals(glStitchPlcCdInner)) {
					coOptionGiletStandardInfo.setOgStitchModifyPlace3(glStitchPlcCdInner);
				}
			}
		}
		
		//ダブルステッチ
		String glDblstitchPlcCd = orderGl.getGlDblstitchPlcCd();
		if(glDblstitchPlcCd != null && !"".equals(glDblstitchPlcCd)&&!glDblstitchPlcCd.startsWith(regex)) {
			String[] glDblstitchPlcCdStr = glDblstitchPlcCd.split(regex);
			for (String glDblstitchPlcCdInner : glDblstitchPlcCdStr) {
				if("0002701".equals(glDblstitchPlcCdInner)) {
					coOptionGiletStandardInfo.setOgDStitchModifyPlace1(glDblstitchPlcCdInner);
				}else if("0002702".equals(glDblstitchPlcCdInner)) {
					coOptionGiletStandardInfo.setOgDStitchModifyPlace2(glDblstitchPlcCdInner);
				}else if("0002703".equals(glDblstitchPlcCdInner)) {
					coOptionGiletStandardInfo.setOgDStitchModifyPlace3(glDblstitchPlcCdInner);
				}
			}
		}
		
		//AMF色指定
		String glAmfColorPlcCd = orderGl.getGlAmfColorPlcCd();
		String glAmfColorCd = orderGl.getGlAmfColorCd();
		if(glAmfColorPlcCd!=null && !"".equals(glAmfColorPlcCd) 
				&& glAmfColorCd !=null && !"".equals(glAmfColorCd)
				&&!glAmfColorPlcCd.startsWith(regex)
				&&!glAmfColorCd.startsWith(regex)) {
			String[] glAmfColorPlcCdStr = glAmfColorPlcCd.split(regex);
			String[] glAmfColorCdStr = glAmfColorCd.split(regex);
			for (int i = 0;i<glAmfColorPlcCdStr.length;i++) {
				if("0000901".equals(glAmfColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgAmfColorPlace1(glAmfColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgAmfColor1(glAmfColorCdStr[i]);
				}else if("0000902".equals(glAmfColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgAmfColorPlace2(glAmfColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgAmfColor2(glAmfColorCdStr[i]);
				}else if("0000903".equals(glAmfColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgAmfColorPlace3(glAmfColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgAmfColor3(glAmfColorCdStr[i]);
				}
			}
		}
		
		//ボタンホール色指定
		String glBtnholeColorPlcCd = orderGl.getGlBtnholeColorPlcCd();
		String glBtnholeColorCd = orderGl.getGlBtnholeColorCd();
		if(!"".equals(glBtnholeColorPlcCd) && glBtnholeColorPlcCd!=null 
				&& !"".equals(glBtnholeColorCd) && glBtnholeColorCd!=null
				&&!glBtnholeColorPlcCd.startsWith(regex)
				&&!glBtnholeColorCd.startsWith(regex)) {
			String[] glBtnholeColorPlcCdStr = glBtnholeColorPlcCd.split(regex);
			String[] glBtnholeColorCdStr = glBtnholeColorCd.split(regex);
			for (int i = 0; i < glBtnholeColorPlcCdStr.length; i++) {
				if("0001201".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgBhColorPlace1(glBtnholeColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgBhColor1(glBtnholeColorCdStr[i]);
				}else if("0001202".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgBhColorPlace2(glBtnholeColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgBhColor2(glBtnholeColorCdStr[i]);
				}else if("0001203".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgBhColorPlace3(glBtnholeColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgBhColor3(glBtnholeColorCdStr[i]);
				}else if("0001204".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgBhColorPlace4(glBtnholeColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgBhColor4(glBtnholeColorCdStr[i]);
				}else if("0001205".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgBhColorPlace5(glBtnholeColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgBhColor5(glBtnholeColorCdStr[i]);
				}else if("0001206".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgBhColorPlace6(glBtnholeColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgBhColor6(glBtnholeColorCdStr[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String glBtnthreadColorPlcCd = orderGl.getGlBtnthreadColorPlcCd();
		String glBtnthreadColorCd = orderGl.getGlBtnthreadColorCd();
		if(!"".equals(glBtnthreadColorPlcCd) && glBtnthreadColorPlcCd!=null 
				&& !"".equals(glBtnthreadColorCd) && glBtnthreadColorCd!=null
				&&!glBtnthreadColorPlcCd.startsWith(regex)
				&&!glBtnthreadColorCd.startsWith(regex)) {
			String[] glBtnthreadColorPlcCdStr = glBtnthreadColorPlcCd.split(regex);
			String[] glBtnthreadColorCdStr = glBtnthreadColorCd.split(regex);
			for (int i = 0; i < glBtnthreadColorPlcCdStr.length; i++) {
				if("0001501".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace1(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor1(glBtnthreadColorCdStr[i]);
				}else if("0001502".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace2(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor2(glBtnthreadColorCdStr[i]);
				}else if("0001503".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace3(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor3(glBtnthreadColorCdStr[i]);
				}else if("0001504".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace4(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor4(glBtnthreadColorCdStr[i]);
				}else if("0001505".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace5(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor5(glBtnthreadColorCdStr[i]);
				}else if("0001506".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace6(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor6(glBtnthreadColorCdStr[i]);
				}else if("0001507".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace7(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor7(glBtnthreadColorCdStr[i]);
				}else if("0001508".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace8(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor8(glBtnthreadColorCdStr[i]);
				}else if("0001509".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace9(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor9(glBtnthreadColorCdStr[i]);
				}else if("0001510".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletStandardInfo.setOgByColorPlace10(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletStandardInfo.setOgByColor10(glBtnthreadColorCdStr[i]);
				}
			}
		}
	}
	
	private void pluralGlTuxedoOptionItem(CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo, Order orderGl) {
		String regex = "/";
		//ボタンホール色指定
		String glBtnholeColorPlcCd = orderGl.getGlBtnholeColorPlcCd();
		String glBtnholeColorCd = orderGl.getGlBtnholeColorCd();
		if(!"".equals(glBtnholeColorPlcCd) && glBtnholeColorPlcCd!=null 
				&& !"".equals(glBtnholeColorCd) && glBtnholeColorCd!=null
				&&!glBtnholeColorPlcCd.startsWith(regex)&&!glBtnholeColorCd.startsWith(regex)) {
			String[] glBtnholeColorPlcCdStr = glBtnholeColorPlcCd.split(regex);
			String[] glBtnholeColorCdStr = glBtnholeColorCd.split(regex);
			for (int i = 0; i < glBtnholeColorPlcCdStr.length; i++) {
				if("0001201".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgBhColorPlace1(glBtnholeColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgBhColor1(glBtnholeColorCdStr[i]);
				}else if("0001202".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgBhColorPlace2(glBtnholeColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgBhColor2(glBtnholeColorCdStr[i]);
				}else if("0001203".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgBhColorPlace3(glBtnholeColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgBhColor3(glBtnholeColorCdStr[i]);
				}else if("0001204".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgBhColorPlace4(glBtnholeColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgBhColor4(glBtnholeColorCdStr[i]);
				}else if("0001205".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgBhColorPlace5(glBtnholeColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgBhColor5(glBtnholeColorCdStr[i]);
				}else if("0001206".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgBhColorPlace6(glBtnholeColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgBhColor6(glBtnholeColorCdStr[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String glBtnthreadColorPlcCd = orderGl.getGlBtnthreadColorPlcCd();
		String glBtnthreadColorCd = orderGl.getGlBtnthreadColorCd();
		if(!"".equals(glBtnthreadColorPlcCd) && glBtnthreadColorPlcCd!=null 
				&& !"".equals(glBtnthreadColorCd) && glBtnthreadColorCd!=null
				&&!glBtnthreadColorPlcCd.startsWith(regex)&&!glBtnthreadColorCd.startsWith(regex)) {
			String[] glBtnthreadColorPlcCdStr = glBtnthreadColorPlcCd.split(regex);
			String[] glBtnthreadColorCdStr = glBtnthreadColorCd.split(regex);
			for (int i = 0; i < glBtnthreadColorPlcCdStr.length; i++) {
				if("0001501".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace1(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor1(glBtnthreadColorCdStr[i]);
				}else if("0001502".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace2(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor2(glBtnthreadColorCdStr[i]);
				}else if("0001503".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace3(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor3(glBtnthreadColorCdStr[i]);
				}else if("0001504".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace4(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor4(glBtnthreadColorCdStr[i]);
				}else if("0001505".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace5(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor5(glBtnthreadColorCdStr[i]);
				}else if("0001506".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace6(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor6(glBtnthreadColorCdStr[i]);
				}else if("0001507".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace7(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor7(glBtnthreadColorCdStr[i]);
				}else if("0001508".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace8(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor8(glBtnthreadColorCdStr[i]);
				}else if("0001509".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace9(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor9(glBtnthreadColorCdStr[i]);
				}else if("0001510".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletTuxedoInfo.setTgByColorPlace10(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletTuxedoInfo.setTgByColor10(glBtnthreadColorCdStr[i]);
				}
			}
		}
	}
	
	private void pluralGlWashableOptionItem(CoOptionGiletWashableInfo coOptionGiletWashableInfo, Order orderGl) {
		String regex = "/";
		//ステッチ箇所変更
		String glStitchPlcCd = orderGl.getGlStitchPlcCd();
		if(glStitchPlcCd != null && !"".equals(glStitchPlcCd)&&!glStitchPlcCd.startsWith(regex)) {
			String[] glStitchPlcCdStr = glStitchPlcCd.split(regex);
			for (String glStitchPlcCdInner : glStitchPlcCdStr) {
				if("0000701".equals(glStitchPlcCdInner)) {
					coOptionGiletWashableInfo.setWgStitchModifyPlace1(glStitchPlcCdInner);
				}else if("0000704".equals(glStitchPlcCdInner)) {
					coOptionGiletWashableInfo.setWgStitchModifyPlace2(glStitchPlcCdInner);
				}else if("0000705".equals(glStitchPlcCdInner)) {
					coOptionGiletWashableInfo.setWgStitchModifyPlace3(glStitchPlcCdInner);
				}
			}
		}
		
		//ダブルステッチ
		String glDblstitchPlcCd = orderGl.getGlDblstitchPlcCd();
		if(glDblstitchPlcCd != null && !"".equals(glDblstitchPlcCd)&&!glStitchPlcCd.startsWith(regex)) {
			String[] glDblstitchPlcCdStr = glDblstitchPlcCd.split(regex);
			for (String glDblstitchPlcCdInner : glDblstitchPlcCdStr) {
				if("0002701".equals(glDblstitchPlcCdInner)) {
					coOptionGiletWashableInfo.setWgDStitchModifyPlace1(glDblstitchPlcCdInner);
				}else if("0002702".equals(glDblstitchPlcCdInner)) {
					coOptionGiletWashableInfo.setWgDStitchModifyPlace2(glDblstitchPlcCdInner);
				}else if("0002703".equals(glDblstitchPlcCdInner)) {
					coOptionGiletWashableInfo.setWgDStitchModifyPlace3(glDblstitchPlcCdInner);
				}
			}
		}
		
		//AMF色指定
		String glAmfColorPlcCd = orderGl.getGlAmfColorPlcCd();
		String glAmfColorCd = orderGl.getGlAmfColorCd();
		if(glAmfColorPlcCd!=null && !"".equals(glAmfColorPlcCd) 
				&& glAmfColorCd !=null && !"".equals(glAmfColorCd)
				&&!glAmfColorPlcCd.startsWith(regex)
				&&!glAmfColorCd.startsWith(regex)) {
			String[] glAmfColorPlcCdStr = glAmfColorPlcCd.split(regex);
			String[] glAmfColorCdStr = glAmfColorCd.split(regex);
			for (int i = 0;i<glAmfColorPlcCdStr.length;i++) {
				if("0000901".equals(glAmfColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgAmfColorPlace1(glAmfColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgAmfColor1(glAmfColorCdStr[i]);
				}else if("0000902".equals(glAmfColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgAmfColorPlace2(glAmfColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgAmfColor2(glAmfColorCdStr[i]);
				}else if("0000903".equals(glAmfColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgAmfColorPlace3(glAmfColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgAmfColor3(glAmfColorCdStr[i]);
				}
			}
		}
		
		//ボタンホール色指定
		String glBtnholeColorPlcCd = orderGl.getGlBtnholeColorPlcCd();
		String glBtnholeColorCd = orderGl.getGlBtnholeColorCd();
		if(!"".equals(glBtnholeColorPlcCd) && glBtnholeColorPlcCd!=null 
				&& !"".equals(glBtnholeColorCd) && glBtnholeColorCd!=null
				&&!glBtnholeColorPlcCd.startsWith(regex)
				&&!glBtnholeColorCd.startsWith(regex)) {
			String[] glBtnholeColorPlcCdStr = glBtnholeColorPlcCd.split(regex);
			String[] glBtnholeColorCdStr = glBtnholeColorCd.split(regex);
			for (int i = 0; i < glBtnholeColorPlcCdStr.length; i++) {
				if("0001201".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgBhColorPlace1(glBtnholeColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgBhColor1(glBtnholeColorCdStr[i]);
				}else if("0001202".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgBhColorPlace2(glBtnholeColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgBhColor2(glBtnholeColorCdStr[i]);
				}else if("0001203".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgBhColorPlace3(glBtnholeColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgBhColor3(glBtnholeColorCdStr[i]);
				}else if("0001204".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgBhColorPlace4(glBtnholeColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgBhColor4(glBtnholeColorCdStr[i]);
				}else if("0001205".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgBhColorPlace5(glBtnholeColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgBhColor5(glBtnholeColorCdStr[i]);
				}else if("0001206".equals(glBtnholeColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgBhColorPlace6(glBtnholeColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgBhColor6(glBtnholeColorCdStr[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String glBtnthreadColorPlcCd = orderGl.getGlBtnthreadColorPlcCd();
		String glBtnthreadColorCd = orderGl.getGlBtnthreadColorCd();
		if(!"".equals(glBtnthreadColorPlcCd) && glBtnthreadColorPlcCd!=null 
				&& !"".equals(glBtnthreadColorCd) && glBtnthreadColorCd!=null
				&&!glBtnthreadColorPlcCd.startsWith(regex)
				&&!glBtnthreadColorCd.startsWith(regex)) {
			String[] glBtnthreadColorPlcCdStr = glBtnthreadColorPlcCd.split(regex);
			String[] glBtnthreadColorCdStr = glBtnthreadColorCd.split(regex);
			for (int i = 0; i < glBtnthreadColorPlcCdStr.length; i++) {
				if("0001501".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace1(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor1(glBtnthreadColorCdStr[i]);
				}else if("0001502".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace2(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor2(glBtnthreadColorCdStr[i]);
				}else if("0001503".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace3(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor3(glBtnthreadColorCdStr[i]);
				}else if("0001504".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace4(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor4(glBtnthreadColorCdStr[i]);
				}else if("0001505".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace5(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor5(glBtnthreadColorCdStr[i]);
				}else if("0001506".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace6(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor6(glBtnthreadColorCdStr[i]);
				}else if("0001507".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace7(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor7(glBtnthreadColorCdStr[i]);
				}else if("0001508".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace8(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor8(glBtnthreadColorCdStr[i]);
				}else if("0001509".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace9(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor9(glBtnthreadColorCdStr[i]);
				}else if("0001510".equals(glBtnthreadColorPlcCdStr[i])) {
					coOptionGiletWashableInfo.setWgByColorPlace10(glBtnthreadColorPlcCdStr[i]);
					coOptionGiletWashableInfo.setWgByColor10(glBtnthreadColorCdStr[i]);
				}
			}
		}
	}
	
	public void giletAdjustFromDb(OrderCoForm orderCoForm, Order order) {
		
//		if("9000101".equals(order.getProductCategory())) {
//			orderCoForm.getCoOptionGiletStandardInfo().setOgGiletModel(order.getGlModelCd());
//		}else if("9000102".equals(order.getProductCategory())) {
//			orderCoForm.getCoOptionGiletTuxedoInfo().setTgGiletModel(order.getGlModelCd());
//		}else if("9000103".equals(order.getProductCategory())) {
//			orderCoForm.getCoOptionGiletWashableInfo().setWgGiletModel(order.getGlModelCd());
//		}
		orderCoForm.getCoAdjustGiletStandardInfo().setSizeFigure(order.getCorGlDrop());
		orderCoForm.getCoAdjustGiletStandardInfo().setSizeNumber(order.getCorGlSize());

		orderCoForm.getCoAdjustGiletStandardInfo().setCorGlBodySize(order.getCorGlBodylengthSize().toString());
		orderCoForm.getCoAdjustGiletStandardInfo().setCorGlBodyGross(order.getCorGlBodylengthGross().toString());
		orderCoForm.getCoAdjustGiletStandardInfo().setCorGlBodyCorrect(order.getCorGlBodylengthCorrect().toString());

		orderCoForm.getCoAdjustGiletStandardInfo().setCorGlBustSize(order.getCorGlBustSize().toString());
		orderCoForm.getCoAdjustGiletStandardInfo().setCorGlBustGross(order.getCorGlBustGross().toString());
		orderCoForm.getCoAdjustGiletStandardInfo().setCorGlBustCorrect(order.getCorGlBustCorrect().toString());

		orderCoForm.getCoAdjustGiletStandardInfo().setCorGlWaistSize(order.getCorGlWaistSize().toString());
		orderCoForm.getCoAdjustGiletStandardInfo().setCorGlWaistCorrect(order.getCorGlWaistCorrect().toString());
		orderCoForm.getCoAdjustGiletStandardInfo().setCorGlWaistGross(order.getCorGlWaistGross().toString());
		
		orderCoForm.setCorStoreCorrectionMemoAgain(order.getCorStoreCorrectionMemo());

	}
	
	public Map<String, Object> getOrderPriceForGiletStandardModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
		String ogGiletModel = coOptionGiletStandardInfo.getOgGiletModel();
		
		GiletOptionCoStandardPriceEnum[] priceEnum = GiletOptionCoStandardPriceEnum.values();
		for (GiletOptionCoStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour(); 
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = coOptionGiletStandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionGiletStandardInfo);
				Object invokeTwo = "";
				String orderPrice = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionGiletStandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionGiletStandardInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if( "og_stitchModify_id".equals(valueFour)) {
						List<String> stitchModifyList = new ArrayList<String>();
						String ogStitchModifyPlace1 = coOptionGiletStandardInfo.getOgStitchModifyPlace1();
						stitchModifyList.add(ogStitchModifyPlace1);
						String ogStitchModifyPlace2 = coOptionGiletStandardInfo.getOgStitchModifyPlace2();
						stitchModifyList.add(ogStitchModifyPlace2);
						String ogStitchModifyPlace3 = coOptionGiletStandardInfo.getOgStitchModifyPlace3();
						stitchModifyList.add(ogStitchModifyPlace3);
						
						stitchModifyList.removeAll(Collections.singleton(null)); 

						if(stitchModifyList.isEmpty() || OptionCodeKeys.GL_0000601.equals(invokeOne)) { 
							splicingCodeForFindUniquePrice = code + key + invokeOne; 
						} else { 
							Integer orderPriceInt = 0; 
							for (int i = 0; i < stitchModifyList.size(); i++) { 
								String projectPriceCode = code + "00007" + stitchModifyList.get(i); 
								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm); 
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner); 
							} 
							orderPrice = String.valueOf(orderPriceInt); 
						} 
					} 

					if( "og_dStitchModify_id".equals(valueFour)) { 
						List<String> dStitchModifyList = new ArrayList<String>(); 
						String ogStitchModifyPlace1 = coOptionGiletStandardInfo.getOgDStitchModifyPlace1(); 
						dStitchModifyList.add(ogStitchModifyPlace1); 
						String ogStitchModifyPlace2 = coOptionGiletStandardInfo.getOgDStitchModifyPlace2(); 
						dStitchModifyList.add(ogStitchModifyPlace2); 
						String ogStitchModifyPlace3 = coOptionGiletStandardInfo.getOgDStitchModifyPlace3(); 
						dStitchModifyList.add(ogStitchModifyPlace3); 

						dStitchModifyList.removeAll(Collections.singleton(null)); 

						if(dStitchModifyList.isEmpty() || OptionCodeKeys.GL_0002601.equals(invokeOne)) { 
							splicingCodeForFindUniquePrice = code + key + invokeOne; 
						} else { 
							Integer orderPriceInt = 0; 
							for (int i = 0; i < dStitchModifyList.size(); i++) { 
								String projectPriceCode = code + "00027" + dStitchModifyList.get(i); 
								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm); 
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner); 
							} 
							orderPrice = String.valueOf(orderPriceInt); 
						} 
					} 
					
					if ("og_amfColor_id".equals(valueFour)) {
						HashSet<String> amfColorSet = new HashSet<String>();
						String ogAmfColor1 = coOptionGiletStandardInfo.getOgAmfColor1();
						amfColorSet.add(ogAmfColor1);
						String ogAmfColor2 = coOptionGiletStandardInfo.getOgAmfColor2();
						amfColorSet.add(ogAmfColor2);
						String ogAmfColor3 = coOptionGiletStandardInfo.getOgAmfColor3();
						amfColorSet.add(ogAmfColor3);
						
						amfColorSet.removeAll(Collections.singleton(null));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						
						if (OptionCodeKeys.GL_0000801.equals(invokeOne)||(OptionCodeKeys.GL_0000802.equals(invokeOne)&&amfColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00010" + amfColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(amfColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("og_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String ogBhColor1 = coOptionGiletStandardInfo.getOgBhColor1();
						bhColorSet.add(ogBhColor1);
						String ogBhColor2 = coOptionGiletStandardInfo.getOgBhColor2();
						bhColorSet.add(ogBhColor2);
						String ogBhColor3 = coOptionGiletStandardInfo.getOgBhColor3();
						bhColorSet.add(ogBhColor3);
						String ogBhColor4 = coOptionGiletStandardInfo.getOgBhColor4();
						bhColorSet.add(ogBhColor4);
						String ogBhColor5 = coOptionGiletStandardInfo.getOgBhColor5();
						bhColorSet.add(ogBhColor5);
						String ogBhColor6 = coOptionGiletStandardInfo.getOgBhColor6();
						bhColorSet.add(ogBhColor6);
						
						bhColorSet.removeAll(Collections.singleton(null));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						
						if (OptionCodeKeys.GL_0001101.equals(invokeOne)||(OptionCodeKeys.GL_0001102.equals(invokeOne)&&bhColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00013" + bhColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("og_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String ogByColor1 = coOptionGiletStandardInfo.getOgByColor1();
						byColorSet.add(ogByColor1);
						String ogByColor2 = coOptionGiletStandardInfo.getOgByColor2();
						byColorSet.add(ogByColor2);
						String ogByColor3 = coOptionGiletStandardInfo.getOgByColor3();
						byColorSet.add(ogByColor3);
						String ogByColor4 = coOptionGiletStandardInfo.getOgByColor4();
						byColorSet.add(ogByColor4);
						String ogByColor5 = coOptionGiletStandardInfo.getOgByColor5();
						byColorSet.add(ogByColor5);
						String ogByColor6 = coOptionGiletStandardInfo.getOgByColor6();
						byColorSet.add(ogByColor6);
						String ogByColor7 = coOptionGiletStandardInfo.getOgByColor7();
						byColorSet.add(ogByColor7);
						String ogByColor8 = coOptionGiletStandardInfo.getOgByColor8();
						byColorSet.add(ogByColor8);
						String ogByColor9 = coOptionGiletStandardInfo.getOgByColor9();
						byColorSet.add(ogByColor9);
						String ogByColor10 = coOptionGiletStandardInfo.getOgByColor10();
						byColorSet.add(ogByColor10);
						
						byColorSet.removeAll(Collections.singleton(null));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						
						if (OptionCodeKeys.GL_0001401.equals(invokeOne)||(OptionCodeKeys.GL_0001402.equals(invokeOne)&&byColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00016" + byColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				
				
				if("BS01-D".equals(ogGiletModel) || "ET15-D".equals(ogGiletModel)) {
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
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletStandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (GiletOptionCoStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletStandardInfo);
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
		orderCoForm.setGlOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}
	
	public Map<String, Object> getOrderPriceForGiletTuxedoModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
		String tgGiletModel = coOptionGiletTuxedoInfo.getTgGiletModel();
		
		GiletOptionCoTuxedoPriceEnum[] priceEnum = GiletOptionCoTuxedoPriceEnum.values();
		for (GiletOptionCoTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = coOptionGiletTuxedoInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionGiletTuxedoInfo);
				Object invokeTwo = "";
				String orderPrice = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionGiletTuxedoInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionGiletTuxedoInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if ("tg_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String tgBhColor1 = coOptionGiletTuxedoInfo.getTgBhColor1();
						bhColorSet.add(tgBhColor1);
						String tgBhColor2 = coOptionGiletTuxedoInfo.getTgBhColor2();
						bhColorSet.add(tgBhColor2);
						String tgBhColor3 = coOptionGiletTuxedoInfo.getTgBhColor3();
						bhColorSet.add(tgBhColor3);
						String tgBhColor4 = coOptionGiletTuxedoInfo.getTgBhColor4();
						bhColorSet.add(tgBhColor4);
						String tgBhColor5 = coOptionGiletTuxedoInfo.getTgBhColor5();
						bhColorSet.add(tgBhColor5);
						String tgBhColor6 = coOptionGiletTuxedoInfo.getTgBhColor6();
						bhColorSet.add(tgBhColor6);
						
						bhColorSet.removeAll(Collections.singleton(null));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						
						if (OptionCodeKeys.GL_0001101.equals(invokeOne)||(OptionCodeKeys.GL_0001102.equals(invokeOne)&&bhColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00013" + bhColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("tg_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String tgByColor1 = coOptionGiletTuxedoInfo.getTgByColor1();
						byColorSet.add(tgByColor1);
						String tgByColor2 = coOptionGiletTuxedoInfo.getTgByColor2();
						byColorSet.add(tgByColor2);
						String tgByColor3 = coOptionGiletTuxedoInfo.getTgByColor3();
						byColorSet.add(tgByColor3);
						String tgByColor4 = coOptionGiletTuxedoInfo.getTgByColor4();
						byColorSet.add(tgByColor4);
						String tgByColor5 = coOptionGiletTuxedoInfo.getTgByColor5();
						byColorSet.add(tgByColor5);
						String tgByColor6 = coOptionGiletTuxedoInfo.getTgByColor6();
						byColorSet.add(tgByColor6);
						String tgByColor7 = coOptionGiletTuxedoInfo.getTgByColor7();
						byColorSet.add(tgByColor7);
						String tgByColor8 = coOptionGiletTuxedoInfo.getTgByColor8();
						byColorSet.add(tgByColor8);
						String tgByColor9 = coOptionGiletTuxedoInfo.getTgByColor9();
						byColorSet.add(tgByColor9);
						String tgByColor10 = coOptionGiletTuxedoInfo.getTgByColor10();
						byColorSet.add(tgByColor10);
						
						byColorSet.removeAll(Collections.singleton(null));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						
						if (OptionCodeKeys.GL_0001401.equals(invokeOne)||(OptionCodeKeys.GL_0001402.equals(invokeOne)&&byColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00016" + byColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				
				
				if("BS01-D".equals(tgGiletModel) || "ET15-D".equals(tgGiletModel)) {
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
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletTuxedoInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (GiletOptionCoTuxedoPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletTuxedoInfo);
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
		orderCoForm.setGlOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	public Map<String, Object> getOrderPriceForGiletWashableModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
		String wgGiletModel = coOptionGiletWashableInfo.getWgGiletModel();
		
		GiletOptionCoWashablePriceEnum[] priceEnum = GiletOptionCoWashablePriceEnum.values();
		for (GiletOptionCoWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			try {
				Method methodOne = coOptionGiletWashableInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionGiletWashableInfo);
				Object invokeTwo = "";
				String orderPrice = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionGiletWashableInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionGiletWashableInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if( "wg_stitchModify_id".equals(valueFour)) {
						List<String> stitchModifyList = new ArrayList<String>();
						String wgStitchModifyPlace1 = coOptionGiletWashableInfo.getWgStitchModifyPlace1();
						stitchModifyList.add(wgStitchModifyPlace1);
						String wgStitchModifyPlace2 = coOptionGiletWashableInfo.getWgStitchModifyPlace2();
						stitchModifyList.add(wgStitchModifyPlace2);
						String wgStitchModifyPlace3 = coOptionGiletWashableInfo.getWgStitchModifyPlace3();
						stitchModifyList.add(wgStitchModifyPlace3);
						
						stitchModifyList.removeAll(Collections.singleton(null)); 

						if(stitchModifyList.isEmpty() || OptionCodeKeys.GL_0000601.equals(invokeOne)) { 
							splicingCodeForFindUniquePrice = code + key + invokeOne; 
						} else { 
							Integer orderPriceInt = 0; 
							for (int i = 0; i < stitchModifyList.size(); i++) { 
								String projectPriceCode = code + "00007" + stitchModifyList.get(i); 
								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm); 
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner); 
							} 
							orderPrice = String.valueOf(orderPriceInt); 
						} 
					} 

					if( "wg_dStitchModify_id".equals(valueFour)) { 
						List<String> dStitchModifyList = new ArrayList<String>(); 
						String wgStitchModifyPlace1 = coOptionGiletWashableInfo.getWgDStitchModifyPlace1(); 
						dStitchModifyList.add(wgStitchModifyPlace1); 
						String wgStitchModifyPlace2 = coOptionGiletWashableInfo.getWgDStitchModifyPlace2(); 
						dStitchModifyList.add(wgStitchModifyPlace2); 
						String wgStitchModifyPlace3 = coOptionGiletWashableInfo.getWgDStitchModifyPlace3(); 
						dStitchModifyList.add(wgStitchModifyPlace3); 

						dStitchModifyList.removeAll(Collections.singleton(null)); 

						if(dStitchModifyList.isEmpty() || OptionCodeKeys.GL_0002601.equals(invokeOne)) { 
							splicingCodeForFindUniquePrice = code + key + invokeOne; 
						} else { 
							Integer orderPriceInt = 0; 
							for (int i = 0; i < dStitchModifyList.size(); i++) { 
								String projectPriceCode = code + "00027" + dStitchModifyList.get(i); 
								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm); 
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner); 
							} 
							orderPrice = String.valueOf(orderPriceInt); 
						} 
					} 
					
					if ("wg_amfColor_id".equals(valueFour)) {
						HashSet<String> amfColorSet = new HashSet<String>();
						String wgAmfColor1 = coOptionGiletWashableInfo.getWgAmfColor1();
						amfColorSet.add(wgAmfColor1);
						String wgAmfColor2 = coOptionGiletWashableInfo.getWgAmfColor2();
						amfColorSet.add(wgAmfColor2);
						String wgAmfColor3 = coOptionGiletWashableInfo.getWgAmfColor3();
						amfColorSet.add(wgAmfColor3);
						
						amfColorSet.removeAll(Collections.singleton(null));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						
						if (OptionCodeKeys.GL_0000801.equals(invokeOne)||(OptionCodeKeys.GL_0000802.equals(invokeOne)&&amfColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00010" + amfColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(amfColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("wg_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String wgBhColor1 = coOptionGiletWashableInfo.getWgBhColor1();
						bhColorSet.add(wgBhColor1);
						String wgBhColor2 = coOptionGiletWashableInfo.getWgBhColor2();
						bhColorSet.add(wgBhColor2);
						String wgBhColor3 = coOptionGiletWashableInfo.getWgBhColor3();
						bhColorSet.add(wgBhColor3);
						String wgBhColor4 = coOptionGiletWashableInfo.getWgBhColor4();
						bhColorSet.add(wgBhColor4);
						String wgBhColor5 = coOptionGiletWashableInfo.getWgBhColor5();
						bhColorSet.add(wgBhColor5);
						String wgBhColor6 = coOptionGiletWashableInfo.getWgBhColor6();
						bhColorSet.add(wgBhColor6);
						
						bhColorSet.removeAll(Collections.singleton(null));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						
						if (OptionCodeKeys.GL_0001101.equals(invokeOne)||(OptionCodeKeys.GL_0001102.equals(invokeOne)&&bhColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00013" + bhColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("wg_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String wgByColor1 = coOptionGiletWashableInfo.getWgByColor1();
						byColorSet.add(wgByColor1);
						String wgByColor2 = coOptionGiletWashableInfo.getWgByColor2();
						byColorSet.add(wgByColor2);
						String wgByColor3 = coOptionGiletWashableInfo.getWgByColor3();
						byColorSet.add(wgByColor3);
						String wgByColor4 = coOptionGiletWashableInfo.getWgByColor4();
						byColorSet.add(wgByColor4);
						String wgByColor5 = coOptionGiletWashableInfo.getWgByColor5();
						byColorSet.add(wgByColor5);
						String wgByColor6 = coOptionGiletWashableInfo.getWgByColor6();
						byColorSet.add(wgByColor6);
						String wgByColor7 = coOptionGiletWashableInfo.getWgByColor7();
						byColorSet.add(wgByColor7);
						String wgByColor8 = coOptionGiletWashableInfo.getWgByColor8();
						byColorSet.add(wgByColor8);
						String wgByColor9 = coOptionGiletWashableInfo.getWgByColor9();
						byColorSet.add(wgByColor9);
						String wgByColor10 = coOptionGiletWashableInfo.getWgByColor10();
						byColorSet.add(wgByColor10);
						
						byColorSet.removeAll(Collections.singleton(null));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						
						if (OptionCodeKeys.GL_0001401.equals(invokeOne)||(OptionCodeKeys.GL_0001402.equals(invokeOne)&&byColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00016" + byColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				
				if("BS01-D".equals(wgGiletModel) || "ET15-D".equals(wgGiletModel)) {
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
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletWashableInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (GiletOptionCoWashablePriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletWashableInfo);
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
		orderCoForm.setGlOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	public Map<String, String> getOrderPriceForGiletStandardProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionGiletStandardInfo coOptionGiletStandardInfo = orderCoForm.getCoOptionGiletStandardInfo();
		String ogGiletModel = coOptionGiletStandardInfo.getOgGiletModel();
		
		GiletOptionCoStandardPriceEnum[] priceEnum = GiletOptionCoStandardPriceEnum.values();
		String orderPrice = "";
		for (GiletOptionCoStandardPriceEnum price : priceEnum) {
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
					Method methodOne = coOptionGiletStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletStandardInfo);
					Object invokeTwo = null;
					if(!("".equals(valueTwo))) {
						Method methodTwo = coOptionGiletStandardInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionGiletStandardInfo);
					}
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					if(invokeTwo != null) {
						splicingCodeDetail = code + key + invokeOne + invokeTwo;
					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionGiletStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletStandardInfo);
					Method methodTwo = coOptionGiletStandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionGiletStandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && "og_stitch_id".equals(idValueName)) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					if("BS01-D".equals(ogGiletModel) || "ET15-D".equals(ogGiletModel)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && ("og_breastPkt_id".equals(idValueName) 
						|| "og_waistPktSpec_id".equals(idValueName) || "og_watchChain_id".equals(idValueName))) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					if("BS01-D".equals(ogGiletModel) || "ET15-D".equals(ogGiletModel)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && "og_waistPkt_id".equals(idValueName)) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					if("BS01-D".equals(ogGiletModel) || "ET15-D".equals(ogGiletModel)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					
					if("000020000202".equals(jspOptionCodeAndBranchCode)) {
						try {
							Class<?> cls;
							Object[] args = {"0"};
							cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo");
							Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, "setGlWaistPktShapeRtPrice");
							ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletStandardInfo(), args);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && ("og_amfColor_id".equals(idValueName) 
						|| "og_bhColor_id".equals(idValueName) || "og_byColor_id".equals(idValueName))) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = "";
					if("BS01-D".equals(ogGiletModel) || "ET15-D".equals(ogGiletModel)) {
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					
					if("-1".equals(colorCount)) {
						orderPrice = orderPriceInner;
					}else {
						Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
						orderPrice = String.valueOf(colorPrice);
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && ("og_stitchModify_id".equals(idValueName) 
						|| "og_dStitchModify_id".equals(idValueName))) {
					Integer orderPriceInt = 0;
					String[] strArr = countArr.split("/");
					for (int i = 0; i < strArr.length; i++) {
						String projectPriceCode = code + strArr[i];
						String orderPriceInner = "";
						if("BS01-D".equals(ogGiletModel) || "ET15-D".equals(ogGiletModel)) {
							orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
						}else{
							orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
						}
						
						orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
					}
					orderPrice = String.valueOf(orderPriceInt);
					hasIdvalueName = true;
				}
				
				if((idValueName.equals(valueFour) || idValueName.equals(valueFive)) 
						&& ("og_backLiningMate".equals(idValueName) || "og_backLiningMateStkNo".equals(idValueName) 
						|| "og_insideLiningMate".equals(idValueName) || "og_insideLiningMateStkNo".equals(idValueName) 
						|| "og_frontBtnMate".equals(idValueName) || "og_frontBtnMateStkNo".equals(idValueName) 
						|| "og_backBelt".equals(idValueName))) {
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}else {
						splicingCodeDetail = "";
					}
					
					hasIdvalueName = true;
				}
				
				if(hasIdvalueName == true) {
					if("BS01-D".equals(ogGiletModel) || "ET15-D".equals(ogGiletModel)) {
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
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletStandardInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (GiletOptionCoStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletStandardInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf))) {
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
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setGlOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	@SuppressWarnings("unused")
	public Map<String, String> getOrderPriceForGiletTuxedoProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionGiletTuxedoInfo coOptionGiletTuxedoInfo = orderCoForm.getCoOptionGiletTuxedoInfo();
		String tgGiletModel = coOptionGiletTuxedoInfo.getTgGiletModel();
		
		GiletOptionCoTuxedoPriceEnum[] priceEnum = GiletOptionCoTuxedoPriceEnum.values();
		String orderPrice = "";
		for (GiletOptionCoTuxedoPriceEnum price : priceEnum) {
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
					Method methodOne = coOptionGiletTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletTuxedoInfo);
					Object invokeTwo = null;
					if(!("".equals(valueTwo))) {
						Method methodTwo = coOptionGiletTuxedoInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionGiletTuxedoInfo);
					}
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					if(invokeTwo != null) {
						splicingCodeDetail = code + key + invokeOne + invokeTwo;
					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionGiletTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletTuxedoInfo);
					Method methodTwo = coOptionGiletTuxedoInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionGiletTuxedoInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && ("tg_breastPkt_id".equals(idValueName) 
						|| "tg_waistPktSpec_id".equals(idValueName) || "tg_waistPktMate_id".equals(idValueName) 
						|| "tg_watchChain_id".equals(idValueName))) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					if("BS01-D".equals(tgGiletModel) || "ET15-D".equals(tgGiletModel)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && "tg_waistPkt_id".equals(idValueName)) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					if("BS01-D".equals(tgGiletModel) || "ET15-D".equals(tgGiletModel)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					if("000020000202".equals(jspOptionCodeAndBranchCode)) {
						try {
							Class<?> cls;
							Object[] args = {"0"};
							cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo");
							Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, "setGlWaistPktShapeRtPrice");
							ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletTuxedoInfo(), args);
							
							Class<?> clsTwo;
							clsTwo = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo");
							Method methodThreeIsTwo = CoContorllerPublicMethodUtil.getMethod(cls, "setGlWaistPktClothRtPrice");
							ReflectionUtils.invoke(methodThreeIsTwo, orderCoForm.getCoOptionGiletTuxedoInfo(), args);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && ("tg_bhColor_id".equals(idValueName) 
						|| "tg_byColor_id".equals(idValueName))) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = "";
					if("BS01-D".equals(tgGiletModel) || "ET15-D".equals(tgGiletModel)) {
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					if("-1".equals(colorCount)) {
						orderPrice = orderPriceInner;
					}else {
						Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
						orderPrice = String.valueOf(colorPrice);
					}
					hasIdvalueName = true;
				}
				
				if((idValueName.equals(valueFour) || idValueName.equals(valueFive)) 
						&& ("tg_backLiningMate".equals(idValueName) || "tg_backLiningMateStkNo".equals(idValueName) 
						|| "tg_insideLiningMate".equals(idValueName) || "tg_insideLiningMateStkNo".equals(idValueName) 
						|| "tg_frontBtnMate".equals(idValueName) || "tg_frontBtnMateStkNo".equals(idValueName) 
						|| "tg_backBelt".equals(idValueName))) {
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}else {
						splicingCodeDetail = "";
					}
					hasIdvalueName = true;
				}
				
				if(hasIdvalueName == true) {
					if("BS01-D".equals(tgGiletModel) || "ET15-D".equals(tgGiletModel)) {
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
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletTuxedoInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (GiletOptionCoTuxedoPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletTuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf))) {
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
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setGlOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
	public Map<String, String> getOrderPriceForGiletWashableProject(OrderCoForm orderCoForm, String code,String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr,String thisVal,String thisValStkNo) {
		CoOptionGiletWashableInfo coOptionGiletWashableInfo = orderCoForm.getCoOptionGiletWashableInfo();
		String wgGiletModel = coOptionGiletWashableInfo.getWgGiletModel();
		
		GiletOptionCoWashablePriceEnum[] priceEnum = GiletOptionCoWashablePriceEnum.values();
		String orderPrice = ""; 
		for (GiletOptionCoWashablePriceEnum price : priceEnum) {
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
					Method methodOne = coOptionGiletWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletWashableInfo);
					Object invokeTwo = null;
					if(!("".equals(thisValStkNo)) && thisValStkNo != null) {
						Method methodTwo = coOptionGiletWashableInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionGiletWashableInfo);
					}
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					if(invokeTwo != null) {
						splicingCodeDetail = code + key + invokeOne + invokeTwo;
					}
					hasIdvalueName = true;
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionGiletWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionGiletWashableInfo);
					Method methodTwo = coOptionGiletWashableInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionGiletWashableInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && "wg_stitch_id".equals(idValueName)) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					if("BS01-D".equals(wgGiletModel) || "ET15-D".equals(wgGiletModel)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && ("wg_breastPkt_id".equals(idValueName) 
						|| "wg_waistPktSpec_id".equals(idValueName) || "wg_watchChain_id".equals(idValueName))) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					if("BS01-D".equals(wgGiletModel) || "ET15-D".equals(wgGiletModel)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && "wg_waistPkt_id".equals(idValueName)) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					if("BS01-D".equals(wgGiletModel) || "ET15-D".equals(wgGiletModel)) {
						orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					if("000020000202".equals(jspOptionCodeAndBranchCode)) {
						try {
							Class<?> cls;
							Object[] args = {"0"};
							cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo");
							Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, "setGlWaistPktShapeRtPrice");
							ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletWashableInfo(), args);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && ("wg_amfColor_id".equals(idValueName) 
						|| "wg_bhColor_id".equals(idValueName) || "wg_byColor_id".equals(idValueName))) {
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = "";
					if("BS01-D".equals(wgGiletModel) || "ET15-D".equals(wgGiletModel)) {
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
					}else{
						orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					}
					if("-1".equals(colorCount)) {
						orderPrice = orderPriceInner;
					}else {
						Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
						orderPrice = String.valueOf(colorPrice);
					}
					hasIdvalueName = true;
				}
				
				if(idValueName.equals(valueFour) && ("wg_stitchModify_id".equals(idValueName) 
						|| "wg_dStitchModify_id".equals(idValueName))) {
					Integer orderPriceInt = 0;
					String[] strArr = countArr.split("/");
					for (int i = 0; i < strArr.length; i++) {
						String projectPriceCode = code + strArr[i];
						String orderPriceInner = "";
						if("BS01-D".equals(wgGiletModel) || "ET15-D".equals(wgGiletModel)) {
							orderPriceInner = CoContorllerPublicMethodUtil.getOrderDoublePrice(projectPriceCode, "", orderCoForm);
						}else{
							orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
						}
						
						orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
					}
					orderPrice = String.valueOf(orderPriceInt);
					hasIdvalueName = true;
				}
				
				if((idValueName.equals(valueFour) || idValueName.equals(valueFive)) 
						&& ("wg_backLiningMate".equals(idValueName) || "wg_backLiningMateStkNo".equals(idValueName) 
						|| "wg_insideLiningMate".equals(idValueName) || "wg_insideLiningMateStkNo".equals(idValueName) 
						|| "wg_frontBtnMate".equals(idValueName) || "wg_frontBtnMateStkNo".equals(idValueName) 
						|| "wg_backBelt".equals(idValueName))) {
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}else {
						splicingCodeDetail = "";
					}
					hasIdvalueName = true;
				}
				
				if(hasIdvalueName == true) {
					if("BS01-D".equals(wgGiletModel) || "ET15-D".equals(wgGiletModel)) {
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
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionGiletWashableInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (GiletOptionCoWashablePriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionGiletWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionGiletWashableInfo);
				String valueOf = String.valueOf(invokeSix);
				if(!("0".equals(valueOf))) {
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
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setGlOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
		
	}
	
}
