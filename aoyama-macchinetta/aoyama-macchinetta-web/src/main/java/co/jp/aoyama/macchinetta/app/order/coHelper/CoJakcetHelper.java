package co.jp.aoyama.macchinetta.app.order.coHelper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.common.BaseCheckUtil;
import co.jp.aoyama.macchinetta.app.order.OptionCodeKeys;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm;
import co.jp.aoyama.macchinetta.app.order.OrderCoHelper;
import co.jp.aoyama.macchinetta.app.order.TypeSizeOptimization;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionJacketWashableInfo;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;

public class CoJakcetHelper {

	@Inject
	TypeSizeService typeSizeService;
	
	OrderCoHelper orderCoHelper = new OrderCoHelper();
	
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
					messages.add("E032", "AMF色指定");
					jacketFlag = true;
				}
				
				if(BaseCheckUtil.isNotEmpty(ojAmfColorPlace1)&&BaseCheckUtil.isEmpty(ojAmfColor1)||BaseCheckUtil.isNotEmpty(ojAmfColorPlace2)&&BaseCheckUtil.isEmpty(ojAmfColor2)||
				   BaseCheckUtil.isNotEmpty(ojAmfColorPlace3)&&BaseCheckUtil.isEmpty(ojAmfColor3)||BaseCheckUtil.isNotEmpty(ojAmfColorPlace4)&&BaseCheckUtil.isEmpty(ojAmfColor4)||
				   BaseCheckUtil.isNotEmpty(ojAmfColorPlace5)&&BaseCheckUtil.isEmpty(ojAmfColor5)||BaseCheckUtil.isNotEmpty(ojAmfColorPlace6)&&BaseCheckUtil.isEmpty(ojAmfColor6)||
				   BaseCheckUtil.isNotEmpty(ojAmfColorPlace7)&&BaseCheckUtil.isEmpty(ojAmfColor7)||BaseCheckUtil.isNotEmpty(ojAmfColorPlace8)&&BaseCheckUtil.isEmpty(ojAmfColor8)||
				   BaseCheckUtil.isNotEmpty(ojAmfColorPlace9)&&BaseCheckUtil.isEmpty(ojAmfColor9)) {
					messages.add("E032", "AMF色指定");
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
					messages.add("E032", "ボタンホール色指定");
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
					messages.add("E032", "ボタンホール色指定");
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
					messages.add("E032", "ボタン付け糸指定");
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
					messages.add("E032", "ボタン付け糸指定");
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
					messages.add("E032", "ボタンホール色指定");
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
					messages.add("E032", "ボタンホール色指定");
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
						messages.add("E032", "ボタン付け糸指定");
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
						messages.add("E032", "ボタン付け糸指定");
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
					messages.add("E032", "AMF色指定");
					jacketFlag = true;
				}
				
				if(BaseCheckUtil.isNotEmpty(wjAmfColorPlace1)&&BaseCheckUtil.isEmpty(wjAmfColor1)||BaseCheckUtil.isNotEmpty(wjAmfColorPlace2)&&BaseCheckUtil.isEmpty(wjAmfColor2)||
				   BaseCheckUtil.isNotEmpty(wjAmfColorPlace3)&&BaseCheckUtil.isEmpty(wjAmfColor3)||BaseCheckUtil.isNotEmpty(wjAmfColorPlace4)&&BaseCheckUtil.isEmpty(wjAmfColor4)||
				   BaseCheckUtil.isNotEmpty(wjAmfColorPlace5)&&BaseCheckUtil.isEmpty(wjAmfColor5)||BaseCheckUtil.isNotEmpty(wjAmfColorPlace6)&&BaseCheckUtil.isEmpty(wjAmfColor6)||
				   BaseCheckUtil.isNotEmpty(wjAmfColorPlace7)&&BaseCheckUtil.isEmpty(wjAmfColor7)||BaseCheckUtil.isNotEmpty(wjAmfColorPlace8)&&BaseCheckUtil.isEmpty(wjAmfColor8)||
				   BaseCheckUtil.isNotEmpty(wjAmfColorPlace9)&&BaseCheckUtil.isEmpty(wjAmfColor9)) {
					messages.add("E032", "AMF色指定");
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
					messages.add("E032", "ボタンホール色指定");
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
					messages.add("E032", "ボタンホール色指定");
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
					messages.add("E032", "ボタン付け糸指定");
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
					messages.add("E032", "ボタン付け糸指定");
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
		List<TypeSizeOptimization> coJkTypeSizeOptimization = orderCoHelper.getCoTypeSizeOptimization(coTypeSizeList);
		return coJkTypeSizeOptimization;
	}
}
