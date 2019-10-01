package co.jp.aoyama.macchinetta.app.order.coHelper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.common.BaseCheckUtil;
import co.jp.aoyama.macchinetta.app.order.OptionCodeKeys;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm;
import co.jp.aoyama.macchinetta.app.order.OrderCoHelper;
import co.jp.aoyama.macchinetta.app.order.TypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionGiletWashableInfo;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;

public class CoGiletHelper {
	
	@Inject
	TypeSizeService typeSizeService;
	
	OrderCoHelper orderCoHelper = new OrderCoHelper();

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
				
				List<TypeSizeOptimization> coGlTypeSizeOptimization = orderCoHelper.getCoGlTypeSizeOptimization(orderCoForm,typeSizeService);
				List<Adjust> glAdjustList = adjustByItem.get("04");
				if(!glAdjustList.isEmpty()&&!coGlTypeSizeOptimization.isEmpty()) {
					for (Adjust adjust : glAdjustList) {
						Map<String, String> glStandardValue = orderCoHelper
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
	
}
