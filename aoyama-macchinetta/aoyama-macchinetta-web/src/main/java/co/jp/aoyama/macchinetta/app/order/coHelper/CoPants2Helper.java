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
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionWashablePriceEnum;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Model;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.ModelService;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;

public class CoPants2Helper {
	@Inject
	TypeSizeService typeSizeService;

	CoTypeSizeOptimization coTypeSizeOptimization = new CoTypeSizeOptimization();

	public boolean pants2Check(ResultMessages messages, OrderCoForm orderCoForm, String productCategory, String item,
			Map<String, List<Adjust>> adjustByItem, TypeSizeService typeSizeService) {
		String corPt2HemwidthType = orderCoForm.getCoAdjustPants2StandardInfo().getCorPt2HemwidthType();
		String pants2Model="";
		boolean pants2Flag = false;
		// 標準の場合
		if ("9000101".equals(productCategory)) {
			// PANTS2 モデル未選択の場合
			CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
			String op2PantsModel = coOptionPants2StandardInfo.getOp2PantsModel();
			pants2Model=op2PantsModel;
			if ("".equals(op2PantsModel) || null == op2PantsModel) {
				messages.add("E031", "PANTS（2本目） モデル");
				pants2Flag = true;
			}
			// ベルトループ
			String op2BeltLoop = coOptionPants2StandardInfo.getOp2BeltLoop();
			if (OptionCodeKeys.PT2_0000701.equals(op2BeltLoop)) {
				String op2BeltLoopPlace1 = coOptionPants2StandardInfo.getOp2BeltLoopPlace1();
				String op2BeltLoopPlace2 = coOptionPants2StandardInfo.getOp2BeltLoopPlace2();
				String op2BeltLoopPlace3 = coOptionPants2StandardInfo.getOp2BeltLoopPlace3();
				String op2BeltLoopPlace4 = coOptionPants2StandardInfo.getOp2BeltLoopPlace4();
				String op2BeltLoopPlace5 = coOptionPants2StandardInfo.getOp2BeltLoopPlace5();
				String op2BeltLoopPlace6 = coOptionPants2StandardInfo.getOp2BeltLoopPlace6();
				String op2BeltLoopPlace7 = coOptionPants2StandardInfo.getOp2BeltLoopPlace7();

				if (BaseCheckUtil.isEmpty(op2BeltLoopPlace1) && BaseCheckUtil.isEmpty(op2BeltLoopPlace2)
						&& BaseCheckUtil.isEmpty(op2BeltLoopPlace3) && BaseCheckUtil.isEmpty(op2BeltLoopPlace4)
						&& BaseCheckUtil.isEmpty(op2BeltLoopPlace5) && BaseCheckUtil.isEmpty(op2BeltLoopPlace6)) {
					
					if ("NZ01".equals(op2PantsModel) && BaseCheckUtil.isEmpty(op2BeltLoopPlace7)) {
						messages.add("E033", "PANTS（2本目）   ベルトループ");
						pants2Flag = true;
					} else if (!"NZ01".equals(op2PantsModel)) {
						messages.add("E033", "PANTS（2本目）   ベルトループ");
						pants2Flag = true;
					}
				}
			}
			// ステッチ箇所変更
			String op2StitchModify = coOptionPants2StandardInfo.getOp2StitchModify();
			if (OptionCodeKeys.PT2_0002002.equals(op2StitchModify)) {
				String op2StitchModifyPlace1 = coOptionPants2StandardInfo.getOp2StitchModifyPlace1();
				String op2StitchModifyPlace2 = coOptionPants2StandardInfo.getOp2StitchModifyPlace2();
				String op2StitchModifyPlace3 = coOptionPants2StandardInfo.getOp2StitchModifyPlace3();
				String op2StitchModifyPlace4 = coOptionPants2StandardInfo.getOp2StitchModifyPlace4();

				if (BaseCheckUtil.isEmpty(op2StitchModifyPlace1) && BaseCheckUtil.isEmpty(op2StitchModifyPlace2)
						&& BaseCheckUtil.isEmpty(op2StitchModifyPlace3)
						&& BaseCheckUtil.isEmpty(op2StitchModifyPlace4)) {
					messages.add("E033", "PANTS（2本目）   ステッチ箇所変更");
					pants2Flag = true;
				}
			}
			// ダブルステッチ
			String op2DStitch = coOptionPants2StandardInfo.getOp2DStitch();
			if (OptionCodeKeys.PT2_0002202.equals(op2DStitch)) {
				String op2DStitchPlace1 = coOptionPants2StandardInfo.getOp2DStitchPlace1();
				String op2DStitchPlace2 = coOptionPants2StandardInfo.getOp2DStitchPlace2();
				String op2DStitchPlace3 = coOptionPants2StandardInfo.getOp2DStitchPlace3();

				if (BaseCheckUtil.isEmpty(op2DStitchPlace1) && BaseCheckUtil.isEmpty(op2DStitchPlace2)
						&& BaseCheckUtil.isEmpty(op2DStitchPlace3)) {
					messages.add("E033", "PANTS（2本目）  ダブルステッチ");
					pants2Flag = true;
				}
			}
			// AMF色指定
			String op2AmfColor = coOptionPants2StandardInfo.getOp2AmfColor();
			if (OptionCodeKeys.PT2_0002402.equals(op2AmfColor)) {
				String op2AmfColorPlace1 = coOptionPants2StandardInfo.getOp2AmfColorPlace1();
				String op2AmfColorPlace2 = coOptionPants2StandardInfo.getOp2AmfColorPlace2();
				String op2AmfColorPlace3 = coOptionPants2StandardInfo.getOp2AmfColorPlace3();
				String op2AmfColorPlace4 = coOptionPants2StandardInfo.getOp2AmfColorPlace4();

				String op2AmfColor1 = coOptionPants2StandardInfo.getOp2AmfColor1();
				String op2AmfColor2 = coOptionPants2StandardInfo.getOp2AmfColor2();
				String op2AmfColor3 = coOptionPants2StandardInfo.getOp2AmfColor3();
				String op2AmfColor4 = coOptionPants2StandardInfo.getOp2AmfColor4();
				if (BaseCheckUtil.isEmpty(op2AmfColorPlace1) && BaseCheckUtil.isEmpty(op2AmfColorPlace2)
						&& BaseCheckUtil.isEmpty(op2AmfColorPlace3) && BaseCheckUtil.isEmpty(op2AmfColorPlace4)) {
					messages.add("E032", "PANTS（2本目） AMF色指定");
					pants2Flag = true;
				}
				if (BaseCheckUtil.isNotEmpty(op2AmfColorPlace1) && BaseCheckUtil.isEmpty(op2AmfColor1)
						|| BaseCheckUtil.isNotEmpty(op2AmfColorPlace2) && BaseCheckUtil.isEmpty(op2AmfColor2)
						|| BaseCheckUtil.isNotEmpty(op2AmfColorPlace3) && BaseCheckUtil.isEmpty(op2AmfColor3)
						|| BaseCheckUtil.isNotEmpty(op2AmfColorPlace4) && BaseCheckUtil.isEmpty(op2AmfColor4)) {
					messages.add("E032", "PANTS（2本目） AMF色指定");
					pants2Flag = true;
				}
			}
			// PANTS2 ボタンホール色指定
			String op2BhColor = coOptionPants2StandardInfo.getOp2BhColor();
			if (OptionCodeKeys.PT2_0002702.equals(op2BhColor)) {
				String op2BhColorPlace1 = coOptionPants2StandardInfo.getOp2BhColorPlace1();
				String op2BhColorPlace2 = coOptionPants2StandardInfo.getOp2BhColorPlace2();
				String op2BhColorPlace3 = coOptionPants2StandardInfo.getOp2BhColorPlace3();
				String op2BhColorPlace4 = coOptionPants2StandardInfo.getOp2BhColorPlace4();

				String op2BhColor1 = coOptionPants2StandardInfo.getOp2BhColor1();
				String op2BhColor2 = coOptionPants2StandardInfo.getOp2BhColor2();
				String op2BhColor3 = coOptionPants2StandardInfo.getOp2BhColor3();
				String op2BhColor4 = coOptionPants2StandardInfo.getOp2BhColor4();

				if (BaseCheckUtil.isEmpty(op2BhColorPlace1) && BaseCheckUtil.isEmpty(op2BhColorPlace2)
						&& BaseCheckUtil.isEmpty(op2BhColorPlace3) && BaseCheckUtil.isEmpty(op2BhColorPlace4)) {
					messages.add("E032", "PANTS（2本目）   ボタンホール色指定");
					pants2Flag = true;
				}
				if (BaseCheckUtil.isNotEmpty(op2BhColorPlace1) && BaseCheckUtil.isEmpty(op2BhColor1)
						|| BaseCheckUtil.isNotEmpty(op2BhColorPlace2) && BaseCheckUtil.isEmpty(op2BhColor2)
						|| BaseCheckUtil.isNotEmpty(op2BhColorPlace3) && BaseCheckUtil.isEmpty(op2BhColor3)
						|| BaseCheckUtil.isNotEmpty(op2BhColorPlace4) && BaseCheckUtil.isEmpty(op2BhColor4)) {
					messages.add("E032", "PANTS（2本目）   ボタンホール色指定");
					pants2Flag = true;
				}
			}

			// ボタン付け糸指定
			String op2ByColor = coOptionPants2StandardInfo.getOp2ByColor();
			if (OptionCodeKeys.PT2_0003002.equals(op2ByColor)) {
				String op2ByColorPlace1 = coOptionPants2StandardInfo.getOp2ByColorPlace1();
				String op2ByColorPlace2 = coOptionPants2StandardInfo.getOp2ByColorPlace2();
				String op2ByColorPlace3 = coOptionPants2StandardInfo.getOp2ByColorPlace3();
				String op2ByColorPlace4 = coOptionPants2StandardInfo.getOp2ByColorPlace4();

				String op2ByColor1 = coOptionPants2StandardInfo.getOp2ByColor1();
				String op2ByColor2 = coOptionPants2StandardInfo.getOp2ByColor2();
				String op2ByColor3 = coOptionPants2StandardInfo.getOp2ByColor3();
				String op2ByColor4 = coOptionPants2StandardInfo.getOp2ByColor4();
				if (BaseCheckUtil.isEmpty(op2ByColorPlace1) && BaseCheckUtil.isEmpty(op2ByColorPlace2)
						&& BaseCheckUtil.isEmpty(op2ByColorPlace3) && BaseCheckUtil.isEmpty(op2ByColorPlace4)) {
					messages.add("E032", "PANTS（2本目）   ボタン付け糸指定");
					pants2Flag = true;
				}
				if (BaseCheckUtil.isNotEmpty(op2ByColorPlace1) && BaseCheckUtil.isEmpty(op2ByColor1)
						|| BaseCheckUtil.isNotEmpty(op2ByColorPlace2) && BaseCheckUtil.isEmpty(op2ByColor2)
						|| BaseCheckUtil.isNotEmpty(op2ByColorPlace3) && BaseCheckUtil.isEmpty(op2ByColor3)
						|| BaseCheckUtil.isNotEmpty(op2ByColorPlace4) && BaseCheckUtil.isEmpty(op2ByColor4)) {
					messages.add("E032", "PANTS（2本目）   ボタン付け糸指定");
					pants2Flag = true;
				}
			}
			// PANTS タキシードの場合
		} else if ("9000102".equals(productCategory)) {
			// PANTS モデル未選択の場合
			CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
			String tp2PantsModel = coOptionPants2TuxedoInfo.getTp2PantsModel();
			pants2Model=tp2PantsModel;
			if ("".equals(tp2PantsModel) || null == tp2PantsModel) {
				messages.add("E031", "PANTS（2本目） モデル");
				pants2Flag = true;
			}
			// PANTS ベルトループ
			String tp2BeltLoop = coOptionPants2TuxedoInfo.getTp2BeltLoop();
			if (OptionCodeKeys.PT2_0000701.equals(tp2BeltLoop)) {
				String tp2BeltLoopPlace1 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace1();
				String tp2BeltLoopPlace2 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace2();
				String tp2BeltLoopPlace3 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace3();
				String tp2BeltLoopPlace4 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace4();
				String tp2BeltLoopPlace5 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace5();
				String tp2BeltLoopPlace6 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace6();
				String tp2BeltLoopPlace7 = coOptionPants2TuxedoInfo.getTp2BeltLoopPlace7();

				if (BaseCheckUtil.isEmpty(tp2BeltLoopPlace1) && BaseCheckUtil.isEmpty(tp2BeltLoopPlace2)
						&& BaseCheckUtil.isEmpty(tp2BeltLoopPlace3) && BaseCheckUtil.isEmpty(tp2BeltLoopPlace4)
						&& BaseCheckUtil.isEmpty(tp2BeltLoopPlace5) && BaseCheckUtil.isEmpty(tp2BeltLoopPlace6)) {
					
					if ("NZ01".equals(tp2PantsModel) && BaseCheckUtil.isEmpty(tp2BeltLoopPlace7)) {
						messages.add("E033", "PANTS（2本目）   ベルトループ");
						pants2Flag = true;
					} else if (!"NZ01".equals(tp2PantsModel)) {
						messages.add("E033", "PANTS（2本目）   ベルトループ");
						pants2Flag = true;
					}
				}
			}
			// ボタンホール色指定
			String op2BhColor = coOptionPants2TuxedoInfo.getTp2BhColor();
			if (OptionCodeKeys.PT2_0002702.equals(op2BhColor)) {
				String tp2BhColorPlace1 = coOptionPants2TuxedoInfo.getTp2BhColorPlace1();
				String tp2BhColorPlace2 = coOptionPants2TuxedoInfo.getTp2BhColorPlace2();
				String tp2BhColorPlace3 = coOptionPants2TuxedoInfo.getTp2BhColorPlace3();
				String tp2BhColorPlace4 = coOptionPants2TuxedoInfo.getTp2BhColorPlace4();

				String tp2BhColor1 = coOptionPants2TuxedoInfo.getTp2BhColor1();
				String tp2BhColor2 = coOptionPants2TuxedoInfo.getTp2BhColor2();
				String tp2BhColor3 = coOptionPants2TuxedoInfo.getTp2BhColor3();
				String tp2BhColor4 = coOptionPants2TuxedoInfo.getTp2BhColor4();

				if (BaseCheckUtil.isEmpty(tp2BhColorPlace1) && BaseCheckUtil.isEmpty(tp2BhColorPlace2)
						&& BaseCheckUtil.isEmpty(tp2BhColorPlace3) && BaseCheckUtil.isEmpty(tp2BhColorPlace4)) {
					messages.add("E032", "PANTS（2本目）  ボタンホール色指定");
					pants2Flag = true;
				}
				if (BaseCheckUtil.isNotEmpty(tp2BhColorPlace1) && BaseCheckUtil.isEmpty(tp2BhColor1)
						|| BaseCheckUtil.isNotEmpty(tp2BhColorPlace2) && BaseCheckUtil.isEmpty(tp2BhColor2)
						|| BaseCheckUtil.isNotEmpty(tp2BhColorPlace3) && BaseCheckUtil.isEmpty(tp2BhColor3)
						|| BaseCheckUtil.isNotEmpty(tp2BhColorPlace4) && BaseCheckUtil.isEmpty(tp2BhColor4)) {
					messages.add("E032", "PANTS（2本目）  ボタンホール色指定");
					pants2Flag = true;
				}
			}
			// ボタン付け糸指定
			String tp2ByColor = coOptionPants2TuxedoInfo.getTp2ByColor();
			if (OptionCodeKeys.PT2_0003002.equals(tp2ByColor)) {
				String tp2ByColorPlace1 = coOptionPants2TuxedoInfo.getTp2ByColorPlace1();
				String tp2ByColorPlace2 = coOptionPants2TuxedoInfo.getTp2ByColorPlace2();
				String tp2ByColorPlace3 = coOptionPants2TuxedoInfo.getTp2ByColorPlace3();
				String tp2ByColorPlace4 = coOptionPants2TuxedoInfo.getTp2ByColorPlace4();

				String tp2ByColor1 = coOptionPants2TuxedoInfo.getTp2ByColor1();
				String tp2ByColor2 = coOptionPants2TuxedoInfo.getTp2ByColor2();
				String tp2ByColor3 = coOptionPants2TuxedoInfo.getTp2ByColor3();
				String tp2ByColor4 = coOptionPants2TuxedoInfo.getTp2ByColor4();
				if (BaseCheckUtil.isEmpty(tp2ByColorPlace1) && BaseCheckUtil.isEmpty(tp2ByColorPlace2)
						&& BaseCheckUtil.isEmpty(tp2ByColorPlace3) && BaseCheckUtil.isEmpty(tp2ByColorPlace4)) {
					messages.add("E032", "PANTS（2本目）   ボタン付け糸指定");
					pants2Flag = true;
				}
				if (BaseCheckUtil.isNotEmpty(tp2ByColorPlace1) && BaseCheckUtil.isEmpty(tp2ByColor1)
						|| BaseCheckUtil.isNotEmpty(tp2ByColorPlace2) && BaseCheckUtil.isEmpty(tp2ByColor2)
						|| BaseCheckUtil.isNotEmpty(tp2ByColorPlace3) && BaseCheckUtil.isEmpty(tp2ByColor3)
						|| BaseCheckUtil.isNotEmpty(tp2ByColorPlace4) && BaseCheckUtil.isEmpty(tp2ByColor4)) {
					messages.add("E032", "PANTS（2本目）   ボタン付け糸指定");
					pants2Flag = true;
				}
			}
		} else if ("9000103".equals(productCategory)) {
			// PANTS モデル未選択の場合
			CoOptionPants2WashableInfo coOptionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
			String wp2PantsModel = coOptionPants2WashableInfo.getWp2PantsModel();
			pants2Model=wp2PantsModel;
			if ("".equals(wp2PantsModel) || null == wp2PantsModel) {
				messages.add("E031", "PANTS（2本目） モデル");
				pants2Flag = true;
			}

			// PANTS ベルトループ
			String wp2BeltLoop = coOptionPants2WashableInfo.getWp2BeltLoop();
			if (OptionCodeKeys.PT2_0000701.equals(wp2BeltLoop)) {
				String wp2BeltLoopPlace1 = coOptionPants2WashableInfo.getWp2BeltLoopPlace1();
				String wp2BeltLoopPlace2 = coOptionPants2WashableInfo.getWp2BeltLoopPlace2();
				String wp2BeltLoopPlace3 = coOptionPants2WashableInfo.getWp2BeltLoopPlace3();
				String wp2BeltLoopPlace4 = coOptionPants2WashableInfo.getWp2BeltLoopPlace4();
				String wp2BeltLoopPlace5 = coOptionPants2WashableInfo.getWp2BeltLoopPlace5();
				String wp2BeltLoopPlace6 = coOptionPants2WashableInfo.getWp2BeltLoopPlace6();
				String wp2BeltLoopPlace7 = coOptionPants2WashableInfo.getWp2BeltLoopPlace7();

				if (BaseCheckUtil.isEmpty(wp2BeltLoopPlace1) && BaseCheckUtil.isEmpty(wp2BeltLoopPlace2)
						&& BaseCheckUtil.isEmpty(wp2BeltLoopPlace3) && BaseCheckUtil.isEmpty(wp2BeltLoopPlace4)
						&& BaseCheckUtil.isEmpty(wp2BeltLoopPlace5) && BaseCheckUtil.isEmpty(wp2BeltLoopPlace6)) {
					
					if ("NZ01".equals(wp2PantsModel) && BaseCheckUtil.isEmpty(wp2BeltLoopPlace7)) {
						messages.add("E033", "PANTS（2本目）   ベルトループ");
						pants2Flag = true;
					} else if (!"NZ01".equals(wp2PantsModel)) {
						messages.add("E033", "PANTS（2本目）   ベルトループ");
						pants2Flag = true;
					}
				}

			}
			// PANTS2 ステッチ箇所変更
			String wp2StitchModify = coOptionPants2WashableInfo.getWp2StitchModify();
			if (OptionCodeKeys.PT2_0002002.equals(wp2StitchModify)) {
				String wp2StitchModifyPlace1 = coOptionPants2WashableInfo.getWp2StitchModifyPlace1();
				String wp2StitchModifyPlace2 = coOptionPants2WashableInfo.getWp2StitchModifyPlace2();
				String wp2StitchModifyPlace3 = coOptionPants2WashableInfo.getWp2StitchModifyPlace3();
				String wp2StitchModifyPlace4 = coOptionPants2WashableInfo.getWp2StitchModifyPlace4();
				if (BaseCheckUtil.isEmpty(wp2StitchModifyPlace1) && BaseCheckUtil.isEmpty(wp2StitchModifyPlace2)
						&& BaseCheckUtil.isEmpty(wp2StitchModifyPlace3)
						&& BaseCheckUtil.isEmpty(wp2StitchModifyPlace4)) {
					messages.add("E033", "PANTS（2本目）   ステッチ箇所変更");
					pants2Flag = true;
				}
			}
			// PANTS2 ダブルステッチ
			String wp2DStitch = coOptionPants2WashableInfo.getWp2DStitch();
			if (OptionCodeKeys.PT2_0002202.equals(wp2DStitch)) {
				String wp2DStitchPlace1 = coOptionPants2WashableInfo.getWp2DStitchPlace1();
				String wp2DStitchPlace2 = coOptionPants2WashableInfo.getWp2DStitchPlace2();
				String wp2DStitchPlace3 = coOptionPants2WashableInfo.getWp2DStitchPlace3();
				if (BaseCheckUtil.isEmpty(wp2DStitchPlace1) && BaseCheckUtil.isEmpty(wp2DStitchPlace2)
						&& BaseCheckUtil.isEmpty(wp2DStitchPlace3)) {
					messages.add("E033", "PANTS（2本目）   ダブルステッチ");
					pants2Flag = true;
				}
			}

			// PANTS2 AMF色指定
			String wp2amfColor = coOptionPants2WashableInfo.getWp2AmfColor();
			if (OptionCodeKeys.PT2_0002402.equals(wp2amfColor)) {
				String wp2amfColorPlace1 = coOptionPants2WashableInfo.getWp2AmfColorPlace1();
				String wp2amfColorPlace2 = coOptionPants2WashableInfo.getWp2AmfColorPlace2();
				String wp2amfColorPlace3 = coOptionPants2WashableInfo.getWp2AmfColorPlace3();
				String wp2amfColorPlace4 = coOptionPants2WashableInfo.getWp2AmfColorPlace4();

				String wp2amfColor1 = coOptionPants2WashableInfo.getWp2AmfColor1();
				String wp2amfColor2 = coOptionPants2WashableInfo.getWp2AmfColor2();
				String wp2amfColor3 = coOptionPants2WashableInfo.getWp2AmfColor3();
				String wp2amfColor4 = coOptionPants2WashableInfo.getWp2AmfColor4();
				if (BaseCheckUtil.isEmpty(wp2amfColorPlace1) && BaseCheckUtil.isEmpty(wp2amfColorPlace2)
						&& BaseCheckUtil.isEmpty(wp2amfColorPlace3) && BaseCheckUtil.isEmpty(wp2amfColorPlace4)) {
					messages.add("E032", "PANTS（2本目）   AMF色指定");
					pants2Flag = true;
				}
				if (BaseCheckUtil.isNotEmpty(wp2amfColorPlace1) && BaseCheckUtil.isEmpty(wp2amfColor1)
						|| BaseCheckUtil.isNotEmpty(wp2amfColorPlace2) && BaseCheckUtil.isEmpty(wp2amfColor2)
						|| BaseCheckUtil.isNotEmpty(wp2amfColorPlace3) && BaseCheckUtil.isEmpty(wp2amfColor3)
						|| BaseCheckUtil.isNotEmpty(wp2amfColorPlace4) && BaseCheckUtil.isEmpty(wp2amfColor4)) {
					messages.add("E032", "PANTS（2本目）   AMF色指定");
					pants2Flag = true;
				}
			}

			// ボタンホール色指定
			String wp2BhColor = coOptionPants2WashableInfo.getWp2BhColor();
			if (OptionCodeKeys.PT2_0002702.equals(wp2BhColor)) {
				String wp2BhColorPlace1 = coOptionPants2WashableInfo.getWp2BhColorPlace1();
				String wp2BhColorPlace2 = coOptionPants2WashableInfo.getWp2BhColorPlace2();
				String wp2BhColorPlace3 = coOptionPants2WashableInfo.getWp2BhColorPlace3();
				String wp2BhColorPlace4 = coOptionPants2WashableInfo.getWp2BhColorPlace4();

				String wp2BhColor1 = coOptionPants2WashableInfo.getWp2BhColor1();
				String wp2BhColor2 = coOptionPants2WashableInfo.getWp2BhColor2();
				String wp2BhColor3 = coOptionPants2WashableInfo.getWp2BhColor3();
				String wp2BhColor4 = coOptionPants2WashableInfo.getWp2BhColor4();

				if (BaseCheckUtil.isEmpty(wp2BhColorPlace1) && BaseCheckUtil.isEmpty(wp2BhColorPlace2)
						&& BaseCheckUtil.isEmpty(wp2BhColorPlace3) && BaseCheckUtil.isEmpty(wp2BhColorPlace4)) {
					messages.add("E032", "PANTS（2本目）   ボタンホール色指定");
					pants2Flag = true;
				}
				if (BaseCheckUtil.isNotEmpty(wp2BhColorPlace1) && BaseCheckUtil.isEmpty(wp2BhColor1)
						|| BaseCheckUtil.isNotEmpty(wp2BhColorPlace2) && BaseCheckUtil.isEmpty(wp2BhColor2)
						|| BaseCheckUtil.isNotEmpty(wp2BhColorPlace3) && BaseCheckUtil.isEmpty(wp2BhColor3)
						|| BaseCheckUtil.isNotEmpty(wp2BhColorPlace4) && BaseCheckUtil.isEmpty(wp2BhColor4)) {
					messages.add("E032", "PANTS（2本目）   ボタンホール色指定");
					pants2Flag = true;
				}
			}

			// ボタン付け糸指定
			String wp2ByColor = coOptionPants2WashableInfo.getWp2ByColor();
			if (OptionCodeKeys.PT2_0003002.equals(wp2ByColor)) {
				String wp2ByColorPlace1 = coOptionPants2WashableInfo.getWp2ByColorPlace1();
				String wp2ByColorPlace2 = coOptionPants2WashableInfo.getWp2ByColorPlace2();
				String wp2ByColorPlace3 = coOptionPants2WashableInfo.getWp2ByColorPlace3();
				String wp2ByColorPlace4 = coOptionPants2WashableInfo.getWp2ByColorPlace4();

				String wp2ByColor1 = coOptionPants2WashableInfo.getWp2ByColor1();
				String wp2ByColor2 = coOptionPants2WashableInfo.getWp2ByColor2();
				String wp2ByColor3 = coOptionPants2WashableInfo.getWp2ByColor3();
				String wp2ByColor4 = coOptionPants2WashableInfo.getWp2ByColor4();
				if (BaseCheckUtil.isEmpty(wp2ByColorPlace1) && BaseCheckUtil.isEmpty(wp2ByColorPlace2)
						&& BaseCheckUtil.isEmpty(wp2ByColorPlace3) && BaseCheckUtil.isEmpty(wp2ByColorPlace4)) {
					messages.add("E032", "PANTS（2本目）   ボタン付け糸指定");
					pants2Flag = true;
				}
				if (BaseCheckUtil.isNotEmpty(wp2ByColorPlace1) && BaseCheckUtil.isEmpty(wp2ByColor1)
						|| BaseCheckUtil.isNotEmpty(wp2ByColorPlace2) && BaseCheckUtil.isEmpty(wp2ByColor2)
						|| BaseCheckUtil.isNotEmpty(wp2ByColorPlace3) && BaseCheckUtil.isEmpty(wp2ByColor3)
						|| BaseCheckUtil.isNotEmpty(wp2ByColorPlace4) && BaseCheckUtil.isEmpty(wp2ByColor4)) {
					messages.add("E032", "PANTS（2本目）   ボタン付け糸指定");
					pants2Flag = true;
				}
			}
		}

		// 補正
		CoAdjustPants2StandardInfo coAdjustPants2StandardInfo = orderCoForm.getCoAdjustPants2StandardInfo();
		if (coAdjustPants2StandardInfo == null) {
			messages.add("E031", "PANTS（2本目）サイズ");
			pants2Flag = true;
		} else {
			if(!"".equals(pants2Model) || null != pants2Model) {
                if("RS01".equals(pants2Model) || "JW21".equals(pants2Model) || "AY01".equals(pants2Model)) {
					
				}else {
					String sizeFigure = coAdjustPants2StandardInfo.getSizeFigure();
					if ("".equals(sizeFigure) || null == sizeFigure) {
						messages.add("E031", "PANTS（2本目）サイズ体型");
						pants2Flag = true;
					}
				}
			}
			
			String sizeNumber = coAdjustPants2StandardInfo.getSizeNumber();
			if ("".equals(sizeNumber) || null == sizeNumber) {
				messages.add("E031", "PANTS（2本目）サイズ号数");
				pants2Flag = true;
			}

			String orPt2LeftinseamGross = coAdjustPants2StandardInfo.getCorPt2LeftinseamGross();
			boolean falg = BaseCheckUtil.GrossCompareTo(orPt2LeftinseamGross, messages, "PANTS（2本目）左股下");
			if (falg) {
				pants2Flag = true;
			}
			String corPt2RightinseamGross = coAdjustPants2StandardInfo.getCorPt2RightinseamGross();
			falg = BaseCheckUtil.GrossCompareTo(corPt2RightinseamGross, messages, "PANTS（2本目）右股下");
			if (falg) {
				pants2Flag = true;
			}

			/*
			 * String corPt2HemwidthSize =
			 * coAdjustPants2StandardInfo.getCorPt2HemwidthSize(); if
			 * ("".equals(corPt2HemwidthSize) || "0".equals(corPt2HemwidthSize) ||
			 * corPt2HemwidthSize == null) { messages.add("E034", "PANTS（2本目）の裾幅");
			 * pants2Flag = true; }
			 */
			if(!pants2Flag) {
				if (BaseCheckUtil.isNotEmpty(sizeNumber)) {
					String corPt2WaistSize = coAdjustPants2StandardInfo.getCorPt2WaistSize();
					if ("".equals(corPt2WaistSize) || "0".equals(corPt2WaistSize) || corPt2WaistSize == null) {
						messages.add("E034", "PANTS（2本目）のウエスト修正");
						pants2Flag = true;
					}

					String corPt2HipSize = coAdjustPants2StandardInfo.getCorPt2HipSize();
					if ("".equals(corPt2HipSize) || "0".equals(corPt2HipSize) || corPt2HipSize == null) {
						messages.add("E034", "PANTS（2本目）のヒップ修正");
						pants2Flag = true;
					}

					String corPt2ThighSize = coAdjustPants2StandardInfo.getCorPt2ThighSize();
					if ("".equals(corPt2ThighSize) || "0".equals(corPt2ThighSize) || corPt2ThighSize == null) {
						messages.add("E034", "PANTS（2本目）のワタリ幅修正");
						pants2Flag = true;
					}
					String corPt2HemwidthType2 = coAdjustPants2StandardInfo.getCorPt2HemwidthType();
					if ("".equals(corPt2HemwidthType2) || "0".equals(corPt2HemwidthType2) || corPt2HemwidthType2 == null) {
						messages.add("E034", "PANTS（2本目）の裾幅");
						pants2Flag = true;
					} else {
						if ("1".equals(corPt2HemwidthType2)) {
							String corPt2HemwidthSize = coAdjustPants2StandardInfo.getCorPt2HemwidthSize();
							if ("".equals(corPt2HemwidthSize) || "0".equals(corPt2HemwidthSize) || corPt2HemwidthSize == null) {
								messages.add("E034", "PANTS（2本目）の裾幅");
								pants2Flag = true;
							}
						} else if ("2".equals(corPt2HemwidthType2)) {
							String corPt2HemwidthDegignate = coAdjustPants2StandardInfo.getCorPt2HemwidthDegignate();
							if ("".equals(corPt2HemwidthDegignate) || "0".equals(corPt2HemwidthDegignate)
									|| corPt2HemwidthDegignate == null) {
								messages.add("E034", "PANTS（2本目）の裾幅");
								pants2Flag = true;
							}
						}
					}
					
					List<TypeSizeOptimization> coPt2TypeSizeOptimization = getCoPt2TypeSizeOptimization(orderCoForm,
							typeSizeService);
					List<Adjust> pt2AdjustList = adjustByItem.get("07");
					if (!pt2AdjustList.isEmpty() && !coPt2TypeSizeOptimization.isEmpty()) {
						for (Adjust adjust : pt2AdjustList) {
							// 2PANTS_ウエスト_グロス
							BigDecimal corPt2WaistGross = new BigDecimal(coAdjustPants2StandardInfo.getCorPt2WaistGross());

							// 2PANTS_ヒップ_グロス
							BigDecimal corPt2HipGross = new BigDecimal(coAdjustPants2StandardInfo.getCorPt2HipGross());

							// 2PANTS_ワタリ_グロス
							BigDecimal corPt2ThighwidthGross = new BigDecimal(
									coAdjustPants2StandardInfo.getCorPt2ThighGross());

							// 2PANTS_裾幅_修正_グロス
							BigDecimal corPt2HemwidthGross = null;
							if ("1".equals(corPt2HemwidthType)) {
								corPt2HemwidthGross = new BigDecimal(coAdjustPants2StandardInfo.getCorPt2HemwidthGross());
							}

							Map<String, String> pt2StandardValue = getPt2StandardValue(orderCoForm,
									coPt2TypeSizeOptimization);

							// 2PANTS_ウエスト_型サイズ
							String stringCorPt2WaistSize = pt2StandardValue.get("corPt2WaistSize");
							BigDecimal corPt2WaistlengthSize = new BigDecimal(stringCorPt2WaistSize);

							// 2PANTS_ヒップ_型サイズ
							String stringCorPt2HipSize = pt2StandardValue.get("corPt2HipSize");
							BigDecimal corPt2HiplengthSize = new BigDecimal(stringCorPt2HipSize);

							// 2PANTS_ワタリ_型サイズ
							String stringCorPt2ThighwidthSize = pt2StandardValue.get("corPt2ThighwidthSize");
							BigDecimal corPt2ThighlengthSize = new BigDecimal(stringCorPt2ThighwidthSize);

							// 2PANTS_裾幅_修正_型サイズ
							String stringCorPt2HemwidthSize = pt2StandardValue.get("corPt2HemwidthSize");
							BigDecimal corPt2HemlengthSize = new BigDecimal(stringCorPt2HemwidthSize);
							if (item.equals(adjust.getItemCode())) {
								if ("07".equals(adjust.getSubItemCode())) {
									// ウエスト修正2
									if ("06".equals(adjust.getAdjusteClass())) {
										BigDecimal adjusteMax = adjust.getAdjusteMax();
										BigDecimal adjusteMin = adjust.getAdjusteMin();
										BigDecimal addMin = adjusteMin.add(corPt2WaistlengthSize);
										BigDecimal addMax = adjusteMax.add(corPt2WaistlengthSize);
										if (corPt2WaistGross.compareTo(addMin) == -1
												|| corPt2WaistGross.compareTo(addMax) == 1) {
											messages.add("E035", "PANTS（2本目）のウエスト修正");
											pants2Flag = true;
										}
									}
									// ヒップ修正2
									if ("05".equals(adjust.getAdjusteClass())) {
										BigDecimal adjusteMax = adjust.getAdjusteMax();
										BigDecimal adjusteMin = adjust.getAdjusteMin();
										BigDecimal addMin = adjusteMin.add(corPt2HiplengthSize);
										BigDecimal addMax = adjusteMax.add(corPt2HiplengthSize);
										if (corPt2HipGross.compareTo(addMin) == -1
												|| corPt2HipGross.compareTo(addMax) == 1) {
											messages.add("E035", "PANTS（2本目）のヒップ修正");
											pants2Flag = true;
										}
									}
									// ワタリ修正2
									if ("07".equals(adjust.getAdjusteClass())) {
										BigDecimal adjusteMax = adjust.getAdjusteMax();
										BigDecimal adjusteMin = adjust.getAdjusteMin();
										BigDecimal addMin = adjusteMin.add(corPt2ThighlengthSize);
										BigDecimal addMax = adjusteMax.add(corPt2ThighlengthSize);
										if (corPt2ThighwidthGross.compareTo(addMin) == -1
												|| corPt2ThighwidthGross.compareTo(addMax) == 1) {
											messages.add("E035", "PANTS（2本目）のワタリ修正");
											pants2Flag = true;
										}
									}
									if ("1".equals(corPt2HemwidthType)) {
										// 裾幅修正2
										if ("08".equals(adjust.getAdjusteClass())) {
											BigDecimal adjusteMax = adjust.getAdjusteMax();
											BigDecimal adjusteMin = adjust.getAdjusteMin();
											BigDecimal addMin = adjusteMin.add(corPt2HemlengthSize);
											BigDecimal addMax = adjusteMax.add(corPt2HemlengthSize);
											if (corPt2HemwidthGross.compareTo(addMin) == -1
													|| corPt2HemwidthGross.compareTo(addMax) == 1) {
												messages.add("E035", "PANTS（2本目）の裾幅修正");
												pants2Flag = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}		
		}
		return pants2Flag;
	}

	/**
	 * 2PANTSの補正標準値
	 * 
	 * @param coJkTypeSizeOptimization
	 * @return
	 */
	private Map<String, String> getPt2StandardValue(OrderCoForm orderCoForm,
			List<TypeSizeOptimization> coPt2TypeSizeOptimization) {
		Map<String, String> adjustPt2StandardValue = new HashMap<String, String>();
		String productCategory = orderCoForm.getProductCategory();
		String pt2TackValue = null;
		if ("9000101".equals(productCategory)) {
			pt2TackValue = orderCoForm.getCoOptionPants2StandardInfo().getOp2Tack();
		} else if ("9000102".equals(productCategory)) {
			pt2TackValue = orderCoForm.getCoOptionPants2TuxedoInfo().getTp2Tack();
		} else if ("9000103".equals(productCategory)) {
			pt2TackValue = orderCoForm.getCoOptionPants2WashableInfo().getWp2Tack();
		}
		for (TypeSizeOptimization typeSizeOptimization : coPt2TypeSizeOptimization) {
			// ウエスト修正
			if ("06".equals(typeSizeOptimization.getAdjustClass())) {
				String corPt2WaistSize = "corPt2WaistSize";
				adjustPt2StandardValue=getPt2StandardValueByptTackValue(pt2TackValue,adjustPt2StandardValue,corPt2WaistSize,typeSizeOptimization);
			}
			// ヒップ
			else if ("05".equals(typeSizeOptimization.getAdjustClass())) {
				String corPt2HipSize = "corPt2HipSize";
				adjustPt2StandardValue=getPt2StandardValueByptTackValue(pt2TackValue,adjustPt2StandardValue,corPt2HipSize,typeSizeOptimization);
			}
			// ワタリ修正
			else if ("07".equals(typeSizeOptimization.getAdjustClass())) {
				String corPt2ThighwidthSize = "corPt2ThighwidthSize";
				adjustPt2StandardValue=getPt2StandardValueByptTackValue(pt2TackValue,adjustPt2StandardValue,corPt2ThighwidthSize,typeSizeOptimization);
			}
			// 裾幅修正
			else if ("08".equals(typeSizeOptimization.getAdjustClass())) {
				String corPt2HemwidthSize = "corPt2HemwidthSize";
				adjustPt2StandardValue=getPt2StandardValueByptTackValue(pt2TackValue,adjustPt2StandardValue,corPt2HemwidthSize,typeSizeOptimization);
			}
		}
		return adjustPt2StandardValue;
	}
	
	public Map<String, String> getPt2StandardValueByptTackValue(String pt2TackValue,Map<String, String> adjustPt2StandardValue,String val,
			TypeSizeOptimization typeSizeOptimization){
		String value="";
		if ("0000101".equals(pt2TackValue)) {
			value = typeSizeOptimization.getTypeSize();
		} else if ("0000102".equals(pt2TackValue)) {
			value = typeSizeOptimization.getTypeSize1Outtack();
		} else if ("0000103".equals(pt2TackValue)) {
			value = typeSizeOptimization.getTypeSize1Intack();
		} else if ("0000104".equals(pt2TackValue)) {
			value = typeSizeOptimization.getTypeSize2Outtack();
		} else if ("0000105".equals(pt2TackValue)) {
			value = typeSizeOptimization.getTypeSize2Intack();
		}
		adjustPt2StandardValue.put(val, value);
		return adjustPt2StandardValue;	
	}

	/**
	 * 2PANTSの標準値取得
	 * 
	 * @param orderCoForm
	 * @return
	 */
	private List<TypeSizeOptimization> getCoPt2TypeSizeOptimization(OrderCoForm orderCoForm,
			TypeSizeService typeSizeService) {
		String orderPattern = orderCoForm.getOrderPattern();
		String productCategory = orderCoForm.getProductCategory();
		String subItemCode = "07";
		String modelCode = null;
		if ("9000101".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPants2StandardInfo().getOp2PantsModel();
		} else if ("9000102".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPants2TuxedoInfo().getTp2PantsModel();
		} else if ("9000103".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPants2WashableInfo().getWp2PantsModel();
		}

		String figure = orderCoForm.getCoAdjustPants2StandardInfo().getSizeFigure();
		String number = orderCoForm.getCoAdjustPants2StandardInfo().getSizeNumber();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coPt2TypeSizeOptimization = coTypeSizeOptimization
				.getCoTypeSizeOptimization(coTypeSizeList);
		return coPt2TypeSizeOptimization;
	}

	public Map<String, Object> getOrderPriceForPants2Model(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
		String op2Stitch = coOptionPants2StandardInfo.getOp2Stitch();
		Pants2CoOptionStandardPriceEnum[] priceEnum = Pants2CoOptionStandardPriceEnum.values();
		for (Pants2CoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionPants2StandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPants2StandardInfo);
				Object invokeTwo = "";
				if (!("".equals(valueTwo))) {
					Method methodTwo = coOptionPants2StandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPants2StandardInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;

				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if ("op2_stitchModify_id".equals(valueFour)) {
						if(OptionCodeKeys.PT2_0005101.equals(op2Stitch)) {
							coOptionPants2StandardInfo.setOp2StitchModify(OptionCodeKeys.PT2_0002001);
							coOptionPants2StandardInfo.setOp2StitchModifyPlace(null);
							coOptionPants2StandardInfo.setOp2StitchModifyPlace1(null);
							coOptionPants2StandardInfo.setOp2StitchModifyPlace2(null);
							coOptionPants2StandardInfo.setOp2StitchModifyPlace3(null);
							coOptionPants2StandardInfo.setOp2StitchModifyPlace4(null);
							splicingCodeForFindUniquePrice = code + key + OptionCodeKeys.PT2_0002001;
						}else {
							List<String> stitchModifyList = new ArrayList<String>();
							String op2StitchModify = coOptionPants2StandardInfo.getOp2StitchModify();
							if(OptionCodeKeys.PT2_0002002.equals(op2StitchModify)) {
								
								String op2StitchModifyPlace1 = coOptionPants2StandardInfo.getOp2StitchModifyPlace1();
								stitchModifyList.add(op2StitchModifyPlace1);
								String op2StitchModifyPlace2 = coOptionPants2StandardInfo.getOp2StitchModifyPlace2();
								stitchModifyList.add(op2StitchModifyPlace2);
								String op2StitchModifyPlace3 = coOptionPants2StandardInfo.getOp2StitchModifyPlace3();
								stitchModifyList.add(op2StitchModifyPlace3);
								String op2StitchModifyPlace4 = coOptionPants2StandardInfo.getOp2StitchModifyPlace4();
								stitchModifyList.add(op2StitchModifyPlace4);
							}

							stitchModifyList.removeAll(Collections.singleton(null));
							stitchModifyList.removeAll(Collections.singleton(""));
							if (stitchModifyList.isEmpty()  || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) || OptionCodeKeys.PT2_0002001.equals(invokeOne)) {
								splicingCodeForFindUniquePrice = code + key + invokeOne;
							} else {
								Integer orderPriceInt = 0;
								for (int i = 0; i < stitchModifyList.size(); i++) {
									String projectPriceCode = code + "00021" + stitchModifyList.get(i);
									String orderPriceInner = CoContorllerPublicMethodUtil
											.getOrderPrice(projectPriceCode, "", orderCoForm);
									orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
								}
								orderPrice = String.valueOf(orderPriceInt);
							}
						}
					}

					if ("op2_dStitch_id".equals(valueFour)) {
						if(OptionCodeKeys.PT2_0005101.equals(op2Stitch)||OptionCodeKeys.PT2_0005103.equals(op2Stitch)
								||OptionCodeKeys.PT2_0005104.equals(op2Stitch)) {
							coOptionPants2StandardInfo.setOp2DStitch(OptionCodeKeys.PT2_0002201);
							coOptionPants2StandardInfo.setOp2DStitchPlace(null);
							coOptionPants2StandardInfo.setOp2DStitchPlace1(null);
							coOptionPants2StandardInfo.setOp2DStitchPlace2(null);
							coOptionPants2StandardInfo.setOp2DStitchPlace3(null);
							splicingCodeForFindUniquePrice = code + key + OptionCodeKeys.PT2_0002201;
						}
//						List<String> stitchModifyList = new ArrayList<String>();
//						String op2DStitchPlace1 = coOptionPants2StandardInfo.getOp2DStitchPlace1();
//						stitchModifyList.add(op2DStitchPlace1);
//						String op2DStitchPlace2 = coOptionPants2StandardInfo.getOp2DStitchPlace2();
//						stitchModifyList.add(op2DStitchPlace2);
//						String op2DStitchPlace3 = coOptionPants2StandardInfo.getOp2DStitchPlace3();
//						stitchModifyList.add(op2DStitchPlace3);
//						String op2DStitchPlace4 = coOptionPants2StandardInfo.getOp2DStitchPlace4();
//						stitchModifyList.add(op2DStitchPlace4);
//						stitchModifyList.removeAll(Collections.singleton(null));
//						stitchModifyList.removeAll(Collections.singleton(""));
//						if (stitchModifyList.isEmpty() || OptionCodeKeys.PT2_0002201.equals(invokeOne)) {
//							splicingCodeForFindUniquePrice = code + key + invokeOne;
//						} else {
//							Integer orderPriceInt = 0;
//							for (int i = 0; i < stitchModifyList.size(); i++) {
//								String projectPriceCode = code + "00023" + stitchModifyList.get(i);
//								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
//										orderCoForm);
//								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
//							}
//							orderPrice = String.valueOf(orderPriceInt);
//						}
					}

					if ("op2_amfColor_id".equals(valueFour)) {
						
						if(OptionCodeKeys.PT2_0005101.equals(op2Stitch) || OptionCodeKeys.PT2_0005104.equals(op2Stitch)) {
							coOptionPants2StandardInfo.setOp2AmfColor(OptionCodeKeys.PT_0002401);
							coOptionPants2StandardInfo.setOp2AmfColorPlace1(null);
							coOptionPants2StandardInfo.setOp2AmfColor1(null);
							coOptionPants2StandardInfo.setOp2AmfColorPlace2(null);
							coOptionPants2StandardInfo.setOp2AmfColor2(null);
							coOptionPants2StandardInfo.setOp2AmfColorPlace3(null);
							coOptionPants2StandardInfo.setOp2AmfColor3(null);
							coOptionPants2StandardInfo.setOp2AmfColorPlace4(null);
							coOptionPants2StandardInfo.setOp2AmfColor4(null);
							invokeOne = coOptionPants2StandardInfo.getOp2AmfColor();
						}
						HashSet<String> amfColorSet = new HashSet<String>();
						String op2AmfColor1 = coOptionPants2StandardInfo.getOp2AmfColor1();
						amfColorSet.add(op2AmfColor1);
						String op2AmfColor2 = coOptionPants2StandardInfo.getOp2AmfColor2();
						amfColorSet.add(op2AmfColor2);
						String op2AmfColor3 = coOptionPants2StandardInfo.getOp2AmfColor3();
						amfColorSet.add(op2AmfColor3);
						String op2AmfColor4 = coOptionPants2StandardInfo.getOp2AmfColor4();
						amfColorSet.add(op2AmfColor4);
						amfColorSet.removeAll(Collections.singleton(null));
						amfColorSet.removeAll(Collections.singleton(""));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						if (OptionCodeKeys.PT2_0002401.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne))  || amfColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00025" + amfColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(amfColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}

					if ("op2_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String op2BhColor1 = coOptionPants2StandardInfo.getOp2BhColor1();
						bhColorSet.add(op2BhColor1);
						String op2BhColor2 = coOptionPants2StandardInfo.getOp2BhColor2();
						bhColorSet.add(op2BhColor2);
						String op2BhColor3 = coOptionPants2StandardInfo.getOp2BhColor3();
						bhColorSet.add(op2BhColor3);
						String op2BhColor4 = coOptionPants2StandardInfo.getOp2BhColor4();
						bhColorSet.add(op2BhColor4);
						bhColorSet.removeAll(Collections.singleton(null));
						bhColorSet.removeAll(Collections.singleton(""));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						if (OptionCodeKeys.PT2_0002701.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne))  || bhColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00028" + bhColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}

					if ("op2_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String op2ByColor1 = coOptionPants2StandardInfo.getOp2ByColor1();
						byColorSet.add(op2ByColor1);
						String op2ByColor2 = coOptionPants2StandardInfo.getOp2ByColor2();
						byColorSet.add(op2ByColor2);
						String op2ByColor3 = coOptionPants2StandardInfo.getOp2ByColor3();
						byColorSet.add(op2ByColor3);
						String op2ByColor4 = coOptionPants2StandardInfo.getOp2ByColor4();
						byColorSet.add(op2ByColor4);
						byColorSet.removeAll(Collections.singleton(null));
						byColorSet.removeAll(Collections.singleton(""));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						if (OptionCodeKeys.PT2_0003001.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne))  || byColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00031" + byColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				

				if ("".equals(orderPrice)) {
//					orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice,
//							splicingCodeDetail, orderCoForm);
					String subOptionBranchCode = null;
					int length = splicingCodeForFindUniquePrice.length();
					if(length >= 14) {
						subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
					}
					String op2HemUp = orderCoForm.getCoOptionPants2StandardInfo().getOp2HemUp();
					String op2KneeBack = orderCoForm.getCoOptionPants2StandardInfo().getOp2KneeBack();
					if(("00018".equals(subOptionBranchCode) && !"0001702".equals(op2HemUp) && !"0001703".equals(op2HemUp)) 
						|| ("00003".equals(subOptionBranchCode) && "0000202".equals(op2KneeBack))) {
						orderPrice = "0";
					}
					else {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice,
							splicingCodeDetail, orderCoForm);
					}
				}

				Class<?> cls;
				Object[] args = { orderPrice };
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2StandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (Pants2CoOptionStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();

			try {
				Method methodSix = coOptionPants2StandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2StandardInfo);
				String valueOf = String.valueOf(invokeSix);

				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if ("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				} else {
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
		orderCoForm.setPt2OptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, Object> getOrderPriceForPants2TuxedoModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();

		Pants2CoOptionTuxedoPriceEnum[] priceEnum = Pants2CoOptionTuxedoPriceEnum.values();
		for (Pants2CoOptionTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionPants2TuxedoInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPants2TuxedoInfo);
				Object invokeTwo = "";
				if (!("".equals(valueTwo))) {
					Method methodTwo = coOptionPants2TuxedoInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPants2TuxedoInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("tp2_btnMate".equals(valueFour)&&"3000700".equals(invokeOne)) {
					splicingCodeDetail = "";
				}
				
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if ("tp2_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String tp2BhColor1 = coOptionPants2TuxedoInfo.getTp2BhColor1();
						bhColorSet.add(tp2BhColor1);
						String tp2BhColor2 = coOptionPants2TuxedoInfo.getTp2BhColor2();
						bhColorSet.add(tp2BhColor2);
						String tp2BhColor3 = coOptionPants2TuxedoInfo.getTp2BhColor3();
						bhColorSet.add(tp2BhColor3);
						String tp2BhColor4 = coOptionPants2TuxedoInfo.getTp2BhColor4();
						bhColorSet.add(tp2BhColor4);
						bhColorSet.removeAll(Collections.singleton(null));
						bhColorSet.removeAll(Collections.singleton(""));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						if (OptionCodeKeys.PT2_0002701.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne))  || bhColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00028" + bhColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}

					if ("tp2_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String tp2ByColor1 = coOptionPants2TuxedoInfo.getTp2ByColor1();
						byColorSet.add(tp2ByColor1);
						String tp2ByColor2 = coOptionPants2TuxedoInfo.getTp2ByColor2();
						byColorSet.add(tp2ByColor2);
						String tp2ByColor3 = coOptionPants2TuxedoInfo.getTp2ByColor3();
						byColorSet.add(tp2ByColor3);
						String tp2ByColor4 = coOptionPants2TuxedoInfo.getTp2ByColor4();
						byColorSet.add(tp2ByColor4);
						byColorSet.removeAll(Collections.singleton(null));
						byColorSet.removeAll(Collections.singleton(""));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						if (OptionCodeKeys.PT2_0003001.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne))  || byColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00031" + byColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}

				if ("".equals(orderPrice)) {
//					orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice,
//							splicingCodeDetail, orderCoForm);
					String subOptionBranchCode = null;
					int length = splicingCodeForFindUniquePrice.length();
					if(length >= 14) {
						subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
					}
					String tp2HemUp = orderCoForm.getCoOptionPants2TuxedoInfo().getTp2HemUp();
					String tp2KneeBack = orderCoForm.getCoOptionPants2TuxedoInfo().getTp2KneeBack();
					String tp2SideStripe = orderCoForm.getCoOptionPants2TuxedoInfo().getTp2SideStripe();
					if(("00018".equals(subOptionBranchCode) && !"0001702".equals(tp2HemUp) && !"0001703".equals(tp2HemUp)) 
						|| ("00003".equals(subOptionBranchCode) && "0000202".equals(tp2KneeBack))
						||("00040".equals(subOptionBranchCode) && ("0003901".equals(tp2SideStripe)||BaseCheckUtil.isEmpty(tp2SideStripe)))) {
						orderPrice = "0";
					}
					else {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice,
							splicingCodeDetail, orderCoForm);
					}
				}

				Class<?> cls;
				Object[] args = { orderPrice };
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2TuxedoInfo(), args);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (Pants2CoOptionTuxedoPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();

			try {
				Method methodSix = coOptionPants2TuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2TuxedoInfo);
				String valueOf = String.valueOf(invokeSix);

				optionPriceInt = optionPriceInt + Integer.valueOf(valueOf);
				if ("0".equals(valueOf)) {
					priceMap.put(valueFour, "無料");
				} else {
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
		orderCoForm.setPt2OptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, Object> getOrderPriceForPants2WashableModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionPants2WashableInfo coOptionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
		String wp2Stitch = coOptionPants2WashableInfo.getWp2Stitch();
		Pants2CoOptionWashablePriceEnum[] priceEnum = Pants2CoOptionWashablePriceEnum.values();
		for (Pants2CoOptionWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionPants2WashableInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPants2WashableInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPants2WashableInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPants2WashableInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if ("wp2_stitchModify_id".equals(valueFour)) {
						List<String> stitchModifyList = new ArrayList<String>();
						String wp2StitchModify = coOptionPants2WashableInfo.getWp2StitchModify();
						if(OptionCodeKeys.PT2_0002002.equals(wp2StitchModify)) {
							
							String wp2StitchModifyPlace1 = coOptionPants2WashableInfo.getWp2StitchModifyPlace1();
							stitchModifyList.add(wp2StitchModifyPlace1);
							String wp2StitchModifyPlace2 = coOptionPants2WashableInfo.getWp2StitchModifyPlace2();
							stitchModifyList.add(wp2StitchModifyPlace2);
							String wp2StitchModifyPlace3 = coOptionPants2WashableInfo.getWp2StitchModifyPlace3();
							stitchModifyList.add(wp2StitchModifyPlace3);
							String wp2StitchModifyPlace4 = coOptionPants2WashableInfo.getWp2StitchModifyPlace4();
							stitchModifyList.add(wp2StitchModifyPlace4);
						}

						stitchModifyList.removeAll(Collections.singleton(null));
						stitchModifyList.removeAll(Collections.singleton(""));
						if (stitchModifyList.isEmpty()  || BaseCheckUtil.isEmpty(String.valueOf(invokeOne)) || OptionCodeKeys.PT2_0002001.equals(invokeOne)) {
							splicingCodeForFindUniquePrice = code + key + invokeOne;
						} else {
							Integer orderPriceInt = 0;
							for (int i = 0; i < stitchModifyList.size(); i++) {
								String projectPriceCode = code + "00021" + stitchModifyList.get(i);
								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
										orderCoForm);
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
							}
							orderPrice = String.valueOf(orderPriceInt);
						}
					}

					if ("wp2_dStitchModify_id".equals(valueFour)) {
						if(OptionCodeKeys.PT2_0005103.equals(wp2Stitch) || OptionCodeKeys.PT2_0005104.equals(wp2Stitch)) {
							coOptionPants2WashableInfo.setWp2DStitch(OptionCodeKeys.PT_0002201);
							coOptionPants2WashableInfo.setWp2DStitchPlace(null);
							coOptionPants2WashableInfo.setWp2DStitchPlace1(null);
							coOptionPants2WashableInfo.setWp2DStitchPlace2(null);
							coOptionPants2WashableInfo.setWp2DStitchPlace3(null);
							splicingCodeForFindUniquePrice = code + key + OptionCodeKeys.PT_0002201;
						}
//						List<String> stitchModifyList = new ArrayList<String>();
//						String wp2DStitchPlace1 = coOptionPants2WashableInfo.getWp2DStitchPlace1();
//						stitchModifyList.add(wp2DStitchPlace1);
//						String wp2DStitchPlace2 = coOptionPants2WashableInfo.getWp2DStitchPlace2();
//						stitchModifyList.add(wp2DStitchPlace2);
//						String wp2DStitchPlace3 = coOptionPants2WashableInfo.getWp2DStitchPlace3();
//						stitchModifyList.add(wp2DStitchPlace3);
//						String wp2DStitchPlace4 = coOptionPants2WashableInfo.getWp2DStitchPlace4();
//						stitchModifyList.add(wp2DStitchPlace4);
//						stitchModifyList.removeAll(Collections.singleton(null));
//						stitchModifyList.removeAll(Collections.singleton(""));
//						if (stitchModifyList.isEmpty() || OptionCodeKeys.PT2_0002201.equals(invokeOne)) {
//							splicingCodeForFindUniquePrice = code + key + invokeOne;
//						} else {
//							Integer orderPriceInt = 0;
//							for (int i = 0; i < stitchModifyList.size(); i++) {
//								String projectPriceCode = code + "00023" + stitchModifyList.get(i);
//								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
//										orderCoForm);
//								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
//							}
//							orderPrice = String.valueOf(orderPriceInt);
//						}
					}

					if ("wp2_amfColor_id".equals(valueFour)) {
						if(OptionCodeKeys.PT2_0005104.equals(wp2Stitch)) {
							coOptionPants2WashableInfo.setWp2AmfColor(OptionCodeKeys.PT_0002401);
							coOptionPants2WashableInfo.setWp2AmfColorPlace1(null);
							coOptionPants2WashableInfo.setWp2AmfColor1(null);
							coOptionPants2WashableInfo.setWp2AmfColorPlace2(null);
							coOptionPants2WashableInfo.setWp2AmfColor2(null);
							coOptionPants2WashableInfo.setWp2AmfColorPlace3(null);
							coOptionPants2WashableInfo.setWp2AmfColor3(null);
							coOptionPants2WashableInfo.setWp2AmfColorPlace4(null);
							coOptionPants2WashableInfo.setWp2AmfColor4(null);
							invokeOne = coOptionPants2WashableInfo.getWp2AmfColor();
						}
						HashSet<String> amfColorSet = new HashSet<String>();
						String wp2AmfColor1 = coOptionPants2WashableInfo.getWp2AmfColor1();
						amfColorSet.add(wp2AmfColor1);
						String wp2AmfColor2 = coOptionPants2WashableInfo.getWp2AmfColor2();
						amfColorSet.add(wp2AmfColor2);
						String wp2AmfColor3 = coOptionPants2WashableInfo.getWp2AmfColor3();
						amfColorSet.add(wp2AmfColor3);
						String wp2AmfColor4 = coOptionPants2WashableInfo.getWp2AmfColor4();
						amfColorSet.add(wp2AmfColor4);
						amfColorSet.removeAll(Collections.singleton(null));
						amfColorSet.removeAll(Collections.singleton(""));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						if (OptionCodeKeys.PT2_0002401.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne))  || amfColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00025" + amfColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(amfColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}

					if ("wp2_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String wp2BhColor1 = coOptionPants2WashableInfo.getWp2BhColor1();
						bhColorSet.add(wp2BhColor1);
						String wp2BhColor2 = coOptionPants2WashableInfo.getWp2BhColor2();
						bhColorSet.add(wp2BhColor2);
						String wp2BhColor3 = coOptionPants2WashableInfo.getWp2BhColor3();
						bhColorSet.add(wp2BhColor3);
						String wp2BhColor4 = coOptionPants2WashableInfo.getWp2BhColor4();
						bhColorSet.add(wp2BhColor4);
						bhColorSet.removeAll(Collections.singleton(null));
						bhColorSet.removeAll(Collections.singleton(""));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						if (OptionCodeKeys.PT2_0002701.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne))  || bhColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00028" + bhColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}

					if ("wp2_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String wp2ByColor1 = coOptionPants2WashableInfo.getWp2ByColor1();
						byColorSet.add(wp2ByColor1);
						String wp2ByColor2 = coOptionPants2WashableInfo.getWp2ByColor2();
						byColorSet.add(wp2ByColor2);
						String wp2ByColor3 = coOptionPants2WashableInfo.getWp2ByColor3();
						byColorSet.add(wp2ByColor3);
						String wp2ByColor4 = coOptionPants2WashableInfo.getWp2ByColor4();
						byColorSet.add(wp2ByColor4);
						byColorSet.removeAll(Collections.singleton(null));
						byColorSet.removeAll(Collections.singleton(""));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						if (OptionCodeKeys.PT2_0003001.equals(invokeOne) || BaseCheckUtil.isEmpty(String.valueOf(invokeOne))  || byColorList.isEmpty()) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00031" + byColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
									orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}

				if ("".equals(orderPrice)) {
//					orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice,
//							splicingCodeDetail, orderCoForm);
					String subOptionBranchCode = null;
					int length = splicingCodeForFindUniquePrice.length();
					if(length >= 14) {
						subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
					}
					String wp2HemUp = orderCoForm.getCoOptionPants2WashableInfo().getWp2HemUp();
					String wp2KneeBack = orderCoForm.getCoOptionPants2WashableInfo().getWp2KneeBack();
					if(("00018".equals(subOptionBranchCode) && !"0001702".equals(wp2HemUp) && !"0001703".equals(wp2HemUp)) 
						|| ("00003".equals(subOptionBranchCode) && "0000202".equals(wp2KneeBack))) {
						orderPrice = "0";
					}
					else {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice,
							splicingCodeDetail, orderCoForm);
					}
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2WashableInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (Pants2CoOptionWashablePriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2WashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2WashableInfo);
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
		orderCoForm.setPt2OptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForPants2Project(OrderCoForm orderCoForm, String code, String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal,
			String thisValStkNo,String valueHemUpId) {
		CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
		String op2PantsModel = coOptionPants2StandardInfo.getOp2PantsModel();
		Pants2CoOptionStandardPriceEnum[] priceEnum = Pants2CoOptionStandardPriceEnum.values();
		String orderPrice = "";
		for (Pants2CoOptionStandardPriceEnum price : priceEnum) {
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
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionPants2StandardInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPants2StandardInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionPants2StandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPants2StandardInfo);
					Method methodTwo = coOptionPants2StandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPants2StandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
//				if(("op2_stitchModify_id".equals(idValueName) && "op2_stitchModify_id".equals(valueFour))|| ("op2_dStitch_id".equals(idValueName) &&"op2_dStitch_id".equals(valueFour))) {
				if(("op2_stitchModify_id".equals(idValueName) && "op2_stitchModify_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(BaseCheckUtil.isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split("/");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("op2_amfColor_id".equals(idValueName)&&"op2_amfColor_id".equals(valueFour))||
					("op2_bhColor_id".equals(idValueName)&&"op2_bhColor_id".equals(valueFour))||
					("op2_byColor_id".equals(idValueName)&&"op2_byColor_id".equals(valueFour))) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					if("-1".equals(colorCount)) {
						orderPrice = orderPriceInner;
					}else {
						Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
						orderPrice = String.valueOf(colorPrice);
					}
				}
				
				if(hasIdvalueName == true) {
					
//					if("0000105".equals(op2PantsModel) || "0000106".equals(op2PantsModel)) {
//						if("".equals(orderPrice)) {
//							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
//						}
//					}
					if("".equals(orderPrice)) {
						String subOptionBranchCode = null;
						int length = splicingCodeForFindUniquePrice.length();
						if(length >= 14) {
							subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
						}
						if(("00018".equals(subOptionBranchCode) && !"0001702".equals(valueHemUpId) && !"0001703".equals(valueHemUpId)) 
								|| ("00003".equals(subOptionBranchCode) && "0000202".equals(valueHemUpId))) {
							orderPrice = "0";
						} else {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2StandardInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (Pants2CoOptionStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2StandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2StandardInfo);
				String valueOf = String.valueOf(invokeSix);
//				if(!("0".equals(valueOf))) {
				if(!("0".equals(valueOf) || "null".equals(valueOf))  && BaseCheckUtil.isNotEmpty(valueOf)) {
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
		orderCoForm.setPt2OptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForPants2tProject(OrderCoForm orderCoForm, String code, String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal,
			String thisValStkNo,String valueHemUpId,String valueSideStripe) {
		CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
		String tp2PantsModel = coOptionPants2TuxedoInfo.getTp2PantsModel();
		Pants2CoOptionTuxedoPriceEnum[] priceEnum = Pants2CoOptionTuxedoPriceEnum.values();
		String orderPrice = "";
		for (Pants2CoOptionTuxedoPriceEnum price : priceEnum) {
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
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionPants2TuxedoInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPants2TuxedoInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionPants2TuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPants2TuxedoInfo);
					Method methodTwo = coOptionPants2TuxedoInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPants2TuxedoInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
				if(("tp2_stitchModify_id".equals(idValueName) && "tp2_stitchModify_id".equals(valueFour))|| ("tp2_dStitch_id".equals(idValueName) &&"tp2_dStitch_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(BaseCheckUtil.isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split(",");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("tp2_bhColor_id".equals(idValueName)&&"tp2_bhColor_id".equals(valueFour))||
				   ("tp2_byColor_id".equals(idValueName)&&"tp2_byColor_id".equals(valueFour))) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					if("-1".equals(colorCount)) {
						orderPrice = orderPriceInner;
					}else {
						Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
						orderPrice = String.valueOf(colorPrice);
					}
				}
				if(hasIdvalueName == true) {
//					if("0000105".equals(tp2PantsModel) || "0000106".equals(tp2PantsModel)) {
//						if("".equals(orderPrice)) {
//							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
//						}
//					}else{
//						if("".equals(orderPrice)) {
//							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
//						}
//					}
					if("".equals(orderPrice)) {
						String subOptionBranchCode = null;
						int length = splicingCodeForFindUniquePrice.length();
						if(length >= 14) {
							subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
						}
						if(("00018".equals(subOptionBranchCode) && !"0001702".equals(valueHemUpId) && !"0001703".equals(valueHemUpId)) 
									|| ("00003".equals(subOptionBranchCode) && "0000202".equals(valueHemUpId))
									||("00040".equals(subOptionBranchCode) && "0003901".equals(valueSideStripe))) {
							orderPrice = "0";
						} else {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2TuxedoInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (Pants2CoOptionTuxedoPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2TuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2TuxedoInfo);
				String valueOf = String.valueOf(invokeSix);
//				if(!("0".equals(valueOf))) {
				if(!("0".equals(valueOf) || "null".equals(valueOf))  && BaseCheckUtil.isNotEmpty(valueOf)) {
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
		orderCoForm.setPt2OptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForPants2WProject(OrderCoForm orderCoForm, String code, String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal,
			String thisValStkNo,String valueHemUpId) {
		CoOptionPants2WashableInfo coOptionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
		String wp2PantsModel = coOptionPants2WashableInfo.getWp2PantsModel();
		Pants2CoOptionWashablePriceEnum[] priceEnum = Pants2CoOptionWashablePriceEnum.values();
		String orderPrice = "";
		for (Pants2CoOptionWashablePriceEnum price : priceEnum) {
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
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionPants2WashableInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPants2WashableInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				}else if(idValueName.equals(valueFive)) {
					Method methodOne = coOptionPants2WashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPants2WashableInfo);
					Method methodTwo = coOptionPants2WashableInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPants2WashableInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
					hasIdvalueName = true;
				}
//				if(("wp2_stitchModify_id".equals(idValueName) && "wp2_stitchModify_id".equals(valueFour))|| ("wp2_dStitchModify_id".equals(idValueName) &&"wp2_dStitchModify_id".equals(valueFour))) {
				if(("wp2_stitchModify_id".equals(idValueName) && "wp2_stitchModify_id".equals(valueFour))) {
					hasIdvalueName = true;
					if(BaseCheckUtil.isEmpty(countArr)) {
						splicingCodeForFindUniquePrice = code + thisVal;
						//orderPrice = getOrderPrice(projectPriceCode, "", orderCoForm);
					}else {
						Integer orderPriceInt = 0;
						String[] strArr = countArr.split("/");
						for (int i = 0; i < strArr.length; i++) {
							String projectPriceCode = code + strArr[i];
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
						}
						orderPrice = String.valueOf(orderPriceInt);
					}
				}
				if(("wp2_amfColor_id".equals(idValueName)&&"wp2_amfColor_id".equals(valueFour))||
				   ("wp2_bhColor_id".equals(idValueName)&&"wp2_bhColor_id".equals(valueFour))||
				   ("wp2_byColor_id".equals(idValueName)&&"wp2_byColor_id".equals(valueFour))) {
					hasIdvalueName = true;
					String projectPriceCode = code + jspOptionCodeAndBranchCode;
					String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
					if("-1".equals(colorCount)) {
						orderPrice = orderPriceInner;
					}else {
						Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(colorCount);
						orderPrice = String.valueOf(colorPrice);
					}
				}
				
				if(hasIdvalueName == true) {
//					if("0000105".equals(wp2PantsModel) || "0000106".equals(wp2PantsModel)) {
//						if("".equals(orderPrice)) {
//							orderPrice = CoContorllerPublicMethodUtil.getOrderDoublePrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
//						}
//					}else{
//						if("".equals(orderPrice)) {
//							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
//						}
//					}
					
					if("".equals(orderPrice)) {
						String subOptionBranchCode = null;
						int length = splicingCodeForFindUniquePrice.length();
						if(length >= 14) {
							subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
						}
						if(("00018".equals(subOptionBranchCode) && !"0001702".equals(valueHemUpId) && !"0001703".equals(valueHemUpId)) 
								|| ("00003".equals(subOptionBranchCode) && "0000202".equals(valueHemUpId))) {
							orderPrice = "0";
						} else {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					
					Class<?> cls;
					Object[] args = {orderPrice};
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPants2WashableInfo(), args);
					
					break;
				}
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Integer optionPriceInt = 0;
		for (Pants2CoOptionWashablePriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPants2WashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPants2WashableInfo);
				String valueOf = String.valueOf(invokeSix);
//				if(!("0".equals(valueOf))) {
				if(!("0".equals(valueOf) || "null".equals(valueOf))  && BaseCheckUtil.isNotEmpty(valueOf)) {
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
		orderCoForm.setPt2OptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public void optionPants2DbToOrder(String productItem, String productCategory, Order order, OrderCoForm orderCoForm,
			OrderListService orderListService, ModelService modelService, String orderFlag ,String isDnpDivertFlag) {
		Order orderPt = null;
		if("1".equals(isDnpDivertFlag)) {
			orderPt = orderListService.findDnpOrderPt2OptionByOrderId(order.getOrderId());
		}else {
			orderPt = orderListService.findOrderPt2OptionByOrderId(order.getOrderId());
		}
		if (orderPt != null) {
			// PANTS_パンチェリーナ_コード
			String pt2PancherinaCd = orderPt.getPt2PancherinaCd();
			// PANTS_裾上げ_コード
			String pt2HemUpCd = orderPt.getPt2HemUpCd();
			// PANTS_アジャスター_コード
			String pt2AdjusterCd = orderPt.getPt2AdjusterCd();
			if(BaseCheckUtil.isEmpty(pt2PancherinaCd)&&BaseCheckUtil.isEmpty(pt2HemUpCd)&&BaseCheckUtil.isEmpty(pt2AdjusterCd)) {
				this.pants2DefaultValue(orderCoForm);
			}else {
				this.pants2DefaultValueFromDb(orderCoForm, orderPt);
			}
		} else {
			this.pants2DefaultValue(orderCoForm);
		}
		
		Order orderPtAd = null;
		if("1".equals(isDnpDivertFlag)) {
			orderPtAd = orderListService.findDnpOrderPt2ByPk(order.getOrderId());
		}else {
			orderPtAd = orderListService.findOrderPt2ByPk(order.getOrderId());
		}
		CoAdjustPants2StandardInfo coAdjustPants2StandardInfo = orderCoForm.getCoAdjustPants2StandardInfo();
		if(coAdjustPants2StandardInfo == null ) {
			coAdjustPants2StandardInfo = new CoAdjustPants2StandardInfo();
			orderCoForm.setCoAdjustPants2StandardInfo(coAdjustPants2StandardInfo);
		}
		if (orderPtAd != null) {
			this.pants2AdjustFromDb(orderCoForm, orderPtAd);
		}
		
		if("9000101".equals(productCategory)) {
			CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
			String op2PantsModel = coOptionPants2StandardInfo.getOp2PantsModel();
			if(op2PantsModel!=null&&!"".equals(op2PantsModel)) {
				String code = productItem.concat("07").concat(coOptionPants2StandardInfo.getOp2PantsModel());
				this.getOrderPriceForPants2Model(orderCoForm, code,orderFlag);
				//ステッチ箇所変更
				String stitchModifyValue = coOptionPants2StandardInfo.getOp2StitchModify();
				String stitchModifyCountArr = coOptionPants2StandardInfo.getOp2StitchModifyPlace();
				if(OptionCodeKeys.PT2_0002002.equals(stitchModifyValue)&&BaseCheckUtil.isNotEmpty(stitchModifyCountArr)) {
					String stitchModifyCode = productItem.concat("07").concat(coOptionPants2StandardInfo.getOp2PantsModel()).concat("00021");
					String stitchModifyValueName = "op2_stitchModify_id";
//					if(!stitchModifyCountArr.startsWith("/")) {
						this.getOrderPriceForPants2Project(orderCoForm, stitchModifyCode, stitchModifyValueName, "", "", stitchModifyCountArr, stitchModifyValue, "","");
//					}
				}
				
//				//ダブルステッチ変更
//				String dSitchModifyValue = coOptionPants2StandardInfo.getOp2DStitch();
//				String dSitchModifyCountArr = coOptionPants2StandardInfo.getOp2DStitchPlace();
//				if(OptionCodeKeys.PT2_0002202.equals(dSitchModifyValue)&&BaseCheckUtil.isNotEmpty(dSitchModifyCountArr)) {
//					String dStitchModifyCode = productItem.concat("07").concat(coOptionPants2StandardInfo.getOp2PantsModel()).concat("00023");
//					String dSitchModifyValueName = "op2_dStitch_id";
////					if(!dSitchModifyCountArr.startsWith("/")) {
//						this.getOrderPriceForPants2Project(orderCoForm, dStitchModifyCode, dSitchModifyValueName, "", "", dSitchModifyCountArr, dSitchModifyValue, "","");
////					}
//				}
				
				//AMF色指定
				String ptAmfColorCd = coOptionPants2StandardInfo.getOp2AmfAllColor();
//				if (ptAmfColorCd != null && !"".equals(ptAmfColorCd) && !ptAmfColorCd.startsWith("/")) {
				if (ptAmfColorCd != null && !"".equals(ptAmfColorCd)) {
				String amfValueName = "op2_amfColor_id";
				String amfCode = productItem.concat("07").concat(coOptionPants2StandardInfo.getOp2PantsModel());
				Map<String, String> amfColorMap = new HashMap<String, String>();
				
					String[] ptAmfColorSplit = ptAmfColorCd.split("/");
					for (String amfColor : ptAmfColorSplit) {
						amfColorMap.put(amfColor, amfColor);
					}
				
				String amfColorCount = String.valueOf(amfColorMap.size());
				List<String> amfValuesList = new ArrayList<String>(amfColorMap.values());
				String amfColorCode = "00025".concat(amfValuesList.get(0));
				this.getOrderPriceForPants2Project(orderCoForm, amfCode, amfValueName, amfColorCode,
						amfColorCount, "", "", "","");
				}
				//ボタンホール色指定
				String ptBtnholeColorCd = coOptionPants2StandardInfo.getOp2BhAllColor();
//				if (ptBtnholeColorCd != null && !"".equals(ptBtnholeColorCd) && !ptBtnholeColorCd.startsWith("/")) {
				if (ptBtnholeColorCd != null && !"".equals(ptBtnholeColorCd)) {
				String bhValueName = "op2_bhColor_id";
				String bhCode = productItem.concat("07").concat(coOptionPants2StandardInfo.getOp2PantsModel());
				Map<String, String> bhColorMap = new HashMap<String, String>();
				
					String[] ptBtnholeColorSplit = ptBtnholeColorCd.split("/");
					for (String btnholeColor : ptBtnholeColorSplit) {
						bhColorMap.put(btnholeColor, btnholeColor);
					}
				
				String bhColorCount = String.valueOf(bhColorMap.size());
				List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
				String bhColorCode = "00028".concat(bhValuesList.get(0));
				this.getOrderPriceForPants2Project(orderCoForm, bhCode, bhValueName, bhColorCode, bhColorCount,
						"", "", "","");
				}
				//ボタン付け糸指定
				String ptBtnthreadColorCd = coOptionPants2StandardInfo.getOp2ByAllColor();
//				if (ptBtnthreadColorCd != null && !"".equals(ptBtnthreadColorCd) && !ptBtnthreadColorCd.startsWith("/")) {
				if (ptBtnthreadColorCd != null && !"".equals(ptBtnthreadColorCd)) {
				String byValueName = "op2_byColor_id";
				String byCode = productItem.concat("07").concat(coOptionPants2StandardInfo.getOp2PantsModel());
				Map<String, String> byColorMap = new HashMap<String, String>();
				
					String[] ptBtnthreadColorSplit = ptBtnthreadColorCd.split("/");
					for (String btnthreadColor : ptBtnthreadColorSplit) {
						byColorMap.put(btnthreadColor, btnthreadColor);
					}
				
				String byColorCount = String.valueOf(byColorMap.size());
				List<String> byValuesList = new ArrayList<String>(byColorMap.values());
				String byColorCode = "00031".concat(byValuesList.get(0));
				this.getOrderPriceForPants2Project(orderCoForm, byCode, byValueName, byColorCode, byColorCount,
						"", "", "","");
				}
			}else {
				orderCoForm.setPt2OptionPrice("0");
			}
		}else if("9000102".equals(productCategory)) {
							
			CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
			String tp2PantsModel = coOptionPants2TuxedoInfo.getTp2PantsModel();
			if(tp2PantsModel!=null&&!"".equals(tp2PantsModel)) {
				String code = productItem.concat("07").concat(coOptionPants2TuxedoInfo.getTp2PantsModel());
				this.getOrderPriceForPants2TuxedoModel(orderCoForm, code,orderFlag);
				
				//ボタンホール色指定
				String ptBtnholeColorCd = coOptionPants2TuxedoInfo.getTp2BhAllColor();
//				if(ptBtnholeColorCd!=null&&!"".equals(ptBtnholeColorCd) && !ptBtnholeColorCd.startsWith("/")) {
				if(ptBtnholeColorCd!=null&&!"".equals(ptBtnholeColorCd)) {
					String bhValueName = "tp2_bhColor_id";
					String bhCode = productItem.concat("07").concat(coOptionPants2TuxedoInfo.getTp2PantsModel());
					Map<String,String> bhColorMap = new HashMap<String,String>();
					
					String[] ptBtnholeColorSplit = ptBtnholeColorCd.split("/");
					for (String btnholeColor : ptBtnholeColorSplit) {
						bhColorMap.put(btnholeColor, btnholeColor);
					}
					
					String bhColorCount = String.valueOf(bhColorMap.size());
					List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
					String bhColorCode = "00028".concat(bhValuesList.get(0));
					this.getOrderPriceForPants2tProject(orderCoForm, bhCode, bhValueName, bhColorCode, bhColorCount, "", "", "", "","");
				}
				//ボタン付け糸指定
				String ptBtnthreadColorCd = coOptionPants2TuxedoInfo.getTp2ByAllColor();
//				if (ptBtnthreadColorCd != null && !"".equals(ptBtnthreadColorCd) && !ptBtnthreadColorCd.startsWith("/")) {
				if (ptBtnthreadColorCd != null && !"".equals(ptBtnthreadColorCd)) {
				String byValueName = "tp2_byColor_id";
				String byCode = productItem.concat("07").concat(coOptionPants2TuxedoInfo.getTp2PantsModel());
				Map<String, String> byColorMap = new HashMap<String, String>();
				
					String[] ptBtnthreadColorSplit = ptBtnthreadColorCd.split("/");
					for (String btnthreadColor : ptBtnthreadColorSplit) {
						byColorMap.put(btnthreadColor, btnthreadColor);
					}
				
				String byColorCount = String.valueOf(byColorMap.size());
				List<String> byValuesList = new ArrayList<String>(byColorMap.values());
				String byColorCode = "00031".concat(byValuesList.get(0));
				this.getOrderPriceForPants2tProject(orderCoForm, byCode, byValueName, byColorCode,
						byColorCount, "", "", "", "","");
				}
			}else {
				orderCoForm.setPt2OptionPrice("0");
			}
			
		}else if("9000103".equals(productCategory)) {
			CoOptionPants2WashableInfo coOptionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
			String wp2PantsModel = coOptionPants2WashableInfo.getWp2PantsModel();
			if(wp2PantsModel!=null&&!"".equals(wp2PantsModel)) {
				String code = productItem.concat("07").concat(coOptionPants2WashableInfo.getWp2PantsModel());
				this.getOrderPriceForPants2WashableModel(orderCoForm, code ,orderFlag);
				
				String stitchModifyValue = coOptionPants2WashableInfo.getWp2StitchModify();
				String stitchModifyCountArr = coOptionPants2WashableInfo.getWp2StitchModifyPlace();
				if(OptionCodeKeys.PT2_0002002.equals(stitchModifyValue)&&BaseCheckUtil.isNotEmpty(stitchModifyCountArr)) {
					//ステッチ箇所変更
					String stitchModifyCode = productItem.concat("07").concat(coOptionPants2WashableInfo.getWp2PantsModel()).concat("00021");
					String stitchModifyValueName = "wp2_stitchModify_id";
//					if(!stitchModifyCountArr.startsWith("/")) {
					this.getOrderPriceForPants2WProject(orderCoForm, stitchModifyCode, stitchModifyValueName, "", "", stitchModifyCountArr, stitchModifyValue, "", "");
//					}
				}
//				//ダブルステッチ変更
//				String dSitchModifyValue = coOptionPants2WashableInfo.getWp2DStitch();
//				String dSitchModifyCountArr = coOptionPants2WashableInfo.getWp2DStitchPlace();
//				if(OptionCodeKeys.PT2_0002202.equals(dSitchModifyValue)&&BaseCheckUtil.isNotEmpty(dSitchModifyCountArr)) {
//					String dStitchModifyCode = productItem.concat("07").concat(coOptionPants2WashableInfo.getWp2PantsModel()).concat("00023");
//					String dSitchModifyValueName = "wp2_dStitchModify_id";
////					if(!dSitchModifyCountArr.startsWith("/")) {
//					this.getOrderPriceForPants2WProject(orderCoForm, dStitchModifyCode, dSitchModifyValueName, "", "", dSitchModifyCountArr, dSitchModifyValue, "", "");
////					}
//				}
				
				//AMF色指定
				String ptAmfColorCd = coOptionPants2WashableInfo.getWp2AmfAllColor();
//				if (ptAmfColorCd != null && !"".equals(ptAmfColorCd) && !ptAmfColorCd.startsWith("/")) {
				if (ptAmfColorCd != null && !"".equals(ptAmfColorCd)) {
				String amfValueName = "wp2_amfColor_id";
				String amfCode = productItem.concat("07").concat(coOptionPants2WashableInfo.getWp2PantsModel());
				Map<String, String> amfColorMap = new HashMap<String, String>();
				
					String[] ptAmfColorSplit = ptAmfColorCd.split("/");
					for (String amfColor : ptAmfColorSplit) {
						amfColorMap.put(amfColor, amfColor);
					}
				
				String amfColorCount = String.valueOf(amfColorMap.size());
				List<String> amfValuesList = new ArrayList<String>(amfColorMap.values());
				String amfColorCode = "00025".concat(amfValuesList.get(0));
				this.getOrderPriceForPants2WProject(orderCoForm, amfCode, amfValueName, amfColorCode,
						amfColorCount, "", "", "", "");
				}
				//ボタンホール色指定
				String ptBtnholeColorCd = coOptionPants2WashableInfo.getWp2BhAllColor();
//				if (ptBtnholeColorCd != null && !"".equals(ptBtnholeColorCd) && !ptBtnholeColorCd.startsWith("/")) {
				if (ptBtnholeColorCd != null && !"".equals(ptBtnholeColorCd)) {
				String bhValueName = "wp2_bhColor_id";
				String bhCode = productItem.concat("07").concat(coOptionPants2WashableInfo.getWp2PantsModel());
				Map<String, String> bhColorMap = new HashMap<String, String>();
				
					String[] ptBtnholeColorSplit = ptBtnholeColorCd.split("/");
					for (String btnholeColor : ptBtnholeColorSplit) {
						bhColorMap.put(btnholeColor, btnholeColor);
					}
				
				String bhColorCount = String.valueOf(bhColorMap.size());
				List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
				String bhColorCode = "00028".concat(bhValuesList.get(0));
				this.getOrderPriceForPants2WProject(orderCoForm, bhCode, bhValueName, bhColorCode,
						bhColorCount, "", "", "", "");
				}
				//ボタン付け糸指定
				String ptBtnthreadColorCd = coOptionPants2WashableInfo.getWp2ByAllColor();
//				if (ptBtnthreadColorCd != null && !"".equals(ptBtnthreadColorCd) && !ptBtnthreadColorCd.startsWith("/")) {
				if (ptBtnthreadColorCd != null && !"".equals(ptBtnthreadColorCd)) {
				String byValueName = "wp2_byColor_id";
				String byCode = productItem.concat("07").concat(coOptionPants2WashableInfo.getWp2PantsModel());
				Map<String, String> byColorMap = new HashMap<String, String>();
				
					String[] ptBtnthreadColorSplit = ptBtnthreadColorCd.split("/");
					for (String btnthreadColor : ptBtnthreadColorSplit) {
						byColorMap.put(btnthreadColor, btnthreadColor);
					}
				
				String byColorCount = String.valueOf(byColorMap.size());
				List<String> valuesList = new ArrayList<String>(byColorMap.values());
				String byColorCode = "00031".concat(valuesList.get(0));
				this.getOrderPriceForPants2WProject(orderCoForm, byCode, byValueName, byColorCode,
						byColorCount, "", "", "", "");
				}
			}else {
				orderCoForm.setPt2OptionPrice("0");
			}
		}
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getItemModel(order.getOrderPattern(), productItem,
				"07");
		this.getPants2ModelMap(orderCoForm, modelList);	
	}
	
	public void getPants2ModelMap(OrderCoForm orderCoForm, List<Model> modelList) {
		LinkedHashMap<String, String> modelMap = new LinkedHashMap<String, String>();
		for (Model model : modelList) {
			modelMap.put("", "モデル選択");
			modelMap.put(model.getModelCode(), model.getModelName());
		}
		orderCoForm.getCoOptionPants2StandardInfo().setOp2PantsModelMap(modelMap);
		orderCoForm.getCoOptionPants2TuxedoInfo().setTp2PantsModelMap(modelMap);
		orderCoForm.getCoOptionPants2WashableInfo().setWp2PantsModelMap(modelMap);

	}
	
	public void pants2AdjustFromDb(OrderCoForm orderCoForm, Order order) {
		if("9000101".equals(order.getProductCategory())) {
			orderCoForm.getCoOptionPants2StandardInfo().setOp2PantsModel(order.getPt2ModelCd());
		}else if("9000102".equals(order.getProductCategory())) {
			orderCoForm.getCoOptionPants2TuxedoInfo().setTp2PantsModel(order.getPt2ModelCd());
		}else if("9000103".equals(order.getProductCategory())) {
			orderCoForm.getCoOptionPants2WashableInfo().setWp2PantsModel(order.getPt2ModelCd());
		}
		orderCoForm.getCoAdjustPants2StandardInfo().setSizeFigure(order.getCorPt2Drop());
		orderCoForm.getCoAdjustPants2StandardInfo().setSizeNumber(order.getCorPt2Size());

		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2WaistSize(order.getCorPt2WaistSize().toString());
		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2WaistGross(order.getCorPt2WaistGross().toString());
		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2WaistCorrect(order.getCorPt2WaistCorrect().toString());

		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2ThighSize(order.getCorPt2ThighwidthSize().toString());
		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2ThighGross(order.getCorPt2ThighwidthGross().toString());
		orderCoForm.getCoAdjustPants2StandardInfo()
				.setCorPt2ThighCorrect(order.getCorPt2ThighwidthCorrect().toString());

		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HemwidthType(order.getCorPt2HemwidthType());
		
		if("1".equals(order.getCorPt2HemwidthType())) {
			orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HemwidthSize(order.getCorPt2HemwidthSize().toString());
			orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HemwidthGross(order.getCorPt2HemwidthGross().toString());
			orderCoForm.getCoAdjustPants2StandardInfo()
					.setCorPt2HemwidthCorrect(order.getCorPt2HemwidthCorrect().toString());	
			
			orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HemwidthDegignate(order.getCorPt2HemwidthDegignate().toString());
		}else if("2".equals(order.getCorPt2HemwidthType())) {
			orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HemwidthDegignate(order.getCorPt2HemwidthDegignate().toString());
		
			orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HemwidthSize(order.getCorPt2HemwidthSize().toString());
			orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HemwidthGross(order.getCorPt2HemwidthGross().toString());
			orderCoForm.getCoAdjustPants2StandardInfo()
					.setCorPt2HemwidthCorrect(order.getCorPt2HemwidthCorrect().toString());	
		}

		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HipSize(order.getCorPt2HipSize().toString());
		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HipGross(order.getCorPt2HipGross().toString());
		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2HipCorrect(order.getCorPt2HipCorrect().toString());

		orderCoForm.getCoAdjustPants2StandardInfo()
				.setCorPt2RightinseamSize(order.getCorPt2RightinseamSize().toString());
		orderCoForm.getCoAdjustPants2StandardInfo()
				.setCorPt2RightinseamGross(order.getCorPt2RightinseamGross().toString());
		//orderCoForm.getCoAdjustPants2StandardInfo()
				//.setCorPt2RightinseamCorrect(order.getCorPt2RightinseamCorrect().toString());

		orderCoForm.getCoAdjustPants2StandardInfo().setCorPt2LeftinseamSize(order.getCorPt2LeftinseamSize().toString());
		orderCoForm.getCoAdjustPants2StandardInfo()
				.setCorPt2LeftinseamGross(order.getCorPt2LeftinseamGross().toString());
		//orderCoForm.getCoAdjustPants2StandardInfo()
				//.setCorPt2LeftinseamCorrect(order.getCorPt2LeftinseamCorrect().toString());

		//orderCoForm.setCorStoreCorrectionMemoAgain(order.getCorStoreCorrectionMemo());

	}
	
	public void pants2DefaultValue(OrderCoForm orderCoForm) {
		// 標準
		CoOptionPants2StandardInfo optionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
		// PANTSモデル
		optionPants2StandardInfo.setOp2PantsModel("");
		// タック
		optionPants2StandardInfo.setOp2Tack(OptionCodeKeys.PT2_0000101);
		// 膝裏
		optionPants2StandardInfo.setOp2KneeBack(OptionCodeKeys.PT2_0000201);
		// 膝裏素材
		optionPants2StandardInfo.setOp2KneeBackMate(OptionCodeKeys.PT2_0000301);
		// フロント仕様
		optionPants2StandardInfo.setOp2FrontSpec(OptionCodeKeys.PT2_0000401);
		// パンチェリーナ
		optionPants2StandardInfo.setOp2Pancherina(OptionCodeKeys.PT2_0000501);
		// アジャスター仕様
		optionPants2StandardInfo.setOp2Adjuster(OptionCodeKeys.PT2_0000601);
		// ベルトループ
		optionPants2StandardInfo.setOp2BeltLoop(OptionCodeKeys.PT2_0000701);
		
        optionPants2StandardInfo.setOp2BeltLoopPlace1(OptionCodeKeys.PT2_0000801);
		
		optionPants2StandardInfo.setOp2BeltLoopPlace2(OptionCodeKeys.PT2_0000802);
		
		optionPants2StandardInfo.setOp2BeltLoopPlace3(OptionCodeKeys.PT2_0000803);
		
		optionPants2StandardInfo.setOp2BeltLoopPlace4(OptionCodeKeys.PT2_0000804);
		
		optionPants2StandardInfo.setOp2BeltLoopPlace5(OptionCodeKeys.PT2_0000805);
		
		optionPants2StandardInfo.setOp2BeltLoopPlace6(OptionCodeKeys.PT2_0000806);
		
		optionPants2StandardInfo.setOp2BeltLoopPlace7(null);
		
		optionPants2StandardInfo.setOp2BeltLoopPlace(null);
		// ピンループ
		optionPants2StandardInfo.setOp2PinLoop(OptionCodeKeys.PT2_0000901);
		// 脇ポケット
		optionPants2StandardInfo.setOp2SidePkt(OptionCodeKeys.PT2_0001002);
		// 忍びポケット
		optionPants2StandardInfo.setOp2SinobiPkt(OptionCodeKeys.PT2_0001104);
		// コインポケット
		optionPants2StandardInfo.setOp2CoinPkt(OptionCodeKeys.PT2_0001201);
		// フラップ付コインポケット
		optionPants2StandardInfo.setOp2FlapCoinPkt(OptionCodeKeys.PT2_0001301);
		// 上前ピスポケット
		optionPants2StandardInfo.setOp2PisPktUf(OptionCodeKeys.PT2_0001401);
		// 下前ピスポケット
		optionPants2StandardInfo.setOp2PisPktDf(OptionCodeKeys.PT2_0001501);
		// Vカット
		optionPants2StandardInfo.setOp2VCut(OptionCodeKeys.PT2_0001602);
		// 裾上げ
		optionPants2StandardInfo.setOp2HemUp(OptionCodeKeys.PT2_0001701);
		// ダブル幅
		optionPants2StandardInfo.setOp2DoubleWide(OptionCodeKeys.PT2_4);
		// ステッチ種類
		optionPants2StandardInfo.setOp2Stitch(OptionCodeKeys.PT2_0005102);
		// ステッチ箇所変更
		optionPants2StandardInfo.setOp2StitchModify(OptionCodeKeys.PT2_0002001);
		optionPants2StandardInfo.setOp2StitchModifyPlace(null);
		optionPants2StandardInfo.setOp2StitchModifyPlace1(null);
		optionPants2StandardInfo.setOp2StitchModifyPlace2(null);
		optionPants2StandardInfo.setOp2StitchModifyPlace3(null);
		optionPants2StandardInfo.setOp2StitchModifyPlace4(null);
		// ダブルステッチ
		optionPants2StandardInfo.setOp2DStitch(OptionCodeKeys.PT2_0002201);
		optionPants2StandardInfo.setOp2DStitchPlace(null);
		optionPants2StandardInfo.setOp2DStitchPlace1(null);
		optionPants2StandardInfo.setOp2DStitchPlace2(null);
		optionPants2StandardInfo.setOp2DStitchPlace3(null);
		// AMF色指定
		optionPants2StandardInfo.setOp2AmfColor(OptionCodeKeys.PT2_0002401);
		optionPants2StandardInfo.setOp2AmfColorPlace(null);
		optionPants2StandardInfo.setOp2AmfColorPlace1(null);
		optionPants2StandardInfo.setOp2AmfColorPlace2(null);
		optionPants2StandardInfo.setOp2AmfColorPlace3(null);
		optionPants2StandardInfo.setOp2AmfColorPlace4(null);
		optionPants2StandardInfo.setOp2AmfColor1(null);
		optionPants2StandardInfo.setOp2AmfColor2(null);
		optionPants2StandardInfo.setOp2AmfColor3(null);
		optionPants2StandardInfo.setOp2AmfColor4(null);
		optionPants2StandardInfo.setOp2AmfAllColor(null);
		// ボタンホール色指定
		optionPants2StandardInfo.setOp2BhColor(OptionCodeKeys.PT2_0002701);
		optionPants2StandardInfo.setOp2BhColorPlace(null);
		optionPants2StandardInfo.setOp2BhColorPlace1(null);
		optionPants2StandardInfo.setOp2BhColorPlace2(null);
		optionPants2StandardInfo.setOp2BhColorPlace3(null);
		optionPants2StandardInfo.setOp2BhColorPlace4(null);
		optionPants2StandardInfo.setOp2BhColor1(null);
		optionPants2StandardInfo.setOp2BhColor2(null);
		optionPants2StandardInfo.setOp2BhColor3(null);
		optionPants2StandardInfo.setOp2BhColor4(null);
		optionPants2StandardInfo.setOp2BhAllColor(null);
		// ボタン付け糸指定
		optionPants2StandardInfo.setOp2ByColor(OptionCodeKeys.PT2_0003001);
		optionPants2StandardInfo.setOp2ByColorPlace(null);
		optionPants2StandardInfo.setOp2ByColorPlace1(null);
		optionPants2StandardInfo.setOp2ByColorPlace2(null);
		optionPants2StandardInfo.setOp2ByColorPlace3(null);
		optionPants2StandardInfo.setOp2ByColorPlace4(null);
		optionPants2StandardInfo.setOp2ByColor1(null);
		optionPants2StandardInfo.setOp2ByColor2(null);
		optionPants2StandardInfo.setOp2ByColor3(null);
		optionPants2StandardInfo.setOp2ByColor4(null);
		optionPants2StandardInfo.setOp2ByAllColor(null);
		// 釦素材
        if("1".equals(orderCoForm.getOjBtnMatePt2Flag())) {
			
		}else {
			optionPants2StandardInfo.setOp2Button(OptionCodeKeys.PT2_3000800);
			
			optionPants2StandardInfo.setOp2BtnMateStkNo(null);
		}
		
		// サスペンダー釦
		optionPants2StandardInfo.setOp2SuspenderBtn(OptionCodeKeys.PT2_0003501);
		// シック大（股補強）
		optionPants2StandardInfo.setOp2Thick(OptionCodeKeys.PT2_0004101);
		// エイト（滑り止め）
		optionPants2StandardInfo.setOp2Eight(OptionCodeKeys.PT2_0003601);
		// 形状記憶
		optionPants2StandardInfo.setOp2ShapeMemory(OptionCodeKeys.PT2_0003701);

		// タキシード
		CoOptionPants2TuxedoInfo optionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
		// PANTSモデル
		optionPants2TuxedoInfo.setTp2PantsModel("");
		// タック
		optionPants2TuxedoInfo.setTp2Tack(OptionCodeKeys.PT2_0000101);
		// 膝裏
		optionPants2TuxedoInfo.setTp2KneeBack(OptionCodeKeys.PT2_0000201);
		// 膝裏素材
		optionPants2TuxedoInfo.setTp2KneeBackMate(OptionCodeKeys.PT2_0000301);
		// フロント仕様
		optionPants2TuxedoInfo.setTp2FrontSpec(OptionCodeKeys.PT2_0000401);
		// パンチェリーナ
		optionPants2TuxedoInfo.setTp2Pancherina(OptionCodeKeys.PT2_0000501);
		// アジャスター仕様
		optionPants2TuxedoInfo.setTp2Adjuster(OptionCodeKeys.PT2_0000601);
		// ベルトループ
		optionPants2TuxedoInfo.setTp2BeltLoop(OptionCodeKeys.PT2_0000701);
		
		optionPants2TuxedoInfo.setTp2BeltLoopPlace1(OptionCodeKeys.PT2_0000801);
		
		optionPants2TuxedoInfo.setTp2BeltLoopPlace2(OptionCodeKeys.PT2_0000802);
		
		optionPants2TuxedoInfo.setTp2BeltLoopPlace3(OptionCodeKeys.PT2_0000803);
		
		optionPants2TuxedoInfo.setTp2BeltLoopPlace4(OptionCodeKeys.PT2_0000804);
		
		optionPants2TuxedoInfo.setTp2BeltLoopPlace5(OptionCodeKeys.PT2_0000805);
		
		optionPants2TuxedoInfo.setTp2BeltLoopPlace6(OptionCodeKeys.PT2_0000806);
		
		optionPants2TuxedoInfo.setTp2BeltLoopPlace7(null);
		
		optionPants2TuxedoInfo.setTp2BeltLoopPlace(null);
		// ピンループ
		optionPants2TuxedoInfo.setTp2PinLoop(OptionCodeKeys.PT2_0000901);
		// 脇ポケット
		optionPants2TuxedoInfo.setTp2SidePkt(OptionCodeKeys.PT2_0001002);
		// 忍びポケット
		optionPants2TuxedoInfo.setTp2SinobiPkt(OptionCodeKeys.PT2_0001104);
		// コインポケット
		optionPants2TuxedoInfo.setTp2CoinPkt(OptionCodeKeys.PT2_0001201);
		// フラップ付コインポケット
		optionPants2TuxedoInfo.setTp2FlapCoinPkt(OptionCodeKeys.PT2_0001301);
		// 上前ピスポケット
		optionPants2TuxedoInfo.setTp2PisPktUf(OptionCodeKeys.PT2_0001401);
		// 下前ピスポケット
		optionPants2TuxedoInfo.setTp2PisPktDf(OptionCodeKeys.PT2_0001501);
		// Vカット
		optionPants2TuxedoInfo.setTp2VCut(OptionCodeKeys.PT2_0001602);
		// 裾上げ
		optionPants2TuxedoInfo.setTp2HemUp(OptionCodeKeys.PT2_0001701);
		// ダブル幅
		optionPants2TuxedoInfo.setTp2DoubleWide(OptionCodeKeys.PT2_4);
		// ステッチ種類
		optionPants2TuxedoInfo.setTp2Stitch(OptionCodeKeys.PT2_0005101);
		// ボタンホール色指定
		optionPants2TuxedoInfo.setTp2BhColor(OptionCodeKeys.PT2_0002701);
		optionPants2TuxedoInfo.setTp2BhColorPlace(null);
		optionPants2TuxedoInfo.setTp2BhColorPlace1(null);
		optionPants2TuxedoInfo.setTp2BhColorPlace2(null);
		optionPants2TuxedoInfo.setTp2BhColorPlace3(null);
		optionPants2TuxedoInfo.setTp2BhColorPlace4(null);
		optionPants2TuxedoInfo.setTp2BhColor1(null);
		optionPants2TuxedoInfo.setTp2BhColor2(null);
		optionPants2TuxedoInfo.setTp2BhColor3(null);
		optionPants2TuxedoInfo.setTp2BhColor4(null);
		optionPants2TuxedoInfo.setTp2BhAllColor(null);
		// ボタン付け糸指定
		optionPants2TuxedoInfo.setTp2ByColor(OptionCodeKeys.PT2_0003001);
		optionPants2TuxedoInfo.setTp2ByColorPlace(null);
		optionPants2TuxedoInfo.setTp2ByColorPlace1(null);
		optionPants2TuxedoInfo.setTp2ByColorPlace2(null);
		optionPants2TuxedoInfo.setTp2ByColorPlace3(null);
		optionPants2TuxedoInfo.setTp2ByColorPlace4(null);
		optionPants2TuxedoInfo.setTp2ByColor1(null);
		optionPants2TuxedoInfo.setTp2ByColor2(null);
		optionPants2TuxedoInfo.setTp2ByColor3(null);
		optionPants2TuxedoInfo.setTp2ByColor4(null);
		optionPants2TuxedoInfo.setTp2ByAllColor(null);
		// 釦素材
		if("1".equals(orderCoForm.getOjBtnMatePt2Flag())) {
				
		}else {
			optionPants2TuxedoInfo.setTp2Button(OptionCodeKeys.PT2_3000800);
				
			optionPants2TuxedoInfo.setTp2BtnMateStkNo(null);
		}	
		// サスペンダー釦
		optionPants2TuxedoInfo.setTp2SuspenderBtn(OptionCodeKeys.PT2_0003501);
		// シック大（股補強）
		optionPants2TuxedoInfo.setTp2Thick(OptionCodeKeys.PT2_0004101);
		// エイト（滑り止め）
		optionPants2TuxedoInfo.setTp2Eight(OptionCodeKeys.PT2_0003601);
		// 形状記憶
		optionPants2TuxedoInfo.setTp2ShapeMemory(OptionCodeKeys.PT2_0003701);
		// 側章
		optionPants2TuxedoInfo.setTp2SideStripe(OptionCodeKeys.PT2_0003902);
		// 側章幅
		optionPants2TuxedoInfo.setTp2SideStripeWidth(OptionCodeKeys.PT2_0004001);
		//拝絹地
		optionPants2TuxedoInfo.setTp2GlossFablic(OptionCodeKeys.PT2_0005001);

		// ウォッシャブル
		CoOptionPants2WashableInfo optionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
		// PANTSモデル
		optionPants2WashableInfo.setWp2PantsModel("");
		// タック
		optionPants2WashableInfo.setWp2Tack(OptionCodeKeys.PT2_0000101);
		// 膝裏
		optionPants2WashableInfo.setWp2KneeBack(OptionCodeKeys.PT2_0000201);
		// 膝裏素材
		optionPants2WashableInfo.setWp2KneeBackMate(OptionCodeKeys.PT2_0000301);
		// フロント仕様
		optionPants2WashableInfo.setWp2FrontSpec(OptionCodeKeys.PT2_0000401);
		// パンチェリーナ
		optionPants2WashableInfo.setWp2Pancherina(OptionCodeKeys.PT2_0000501);
		// アジャスター仕様
		optionPants2WashableInfo.setWp2Adjuster(OptionCodeKeys.PT2_0000601);
		// ベルトループ
		optionPants2WashableInfo.setWp2BeltLoop(OptionCodeKeys.PT2_0000701);
		
		optionPants2WashableInfo.setWp2BeltLoopPlace1(OptionCodeKeys.PT2_0000801);
		
		optionPants2WashableInfo.setWp2BeltLoopPlace2(OptionCodeKeys.PT2_0000802);
		
		optionPants2WashableInfo.setWp2BeltLoopPlace3(OptionCodeKeys.PT2_0000803);
		
		optionPants2WashableInfo.setWp2BeltLoopPlace4(OptionCodeKeys.PT2_0000804);
		
		optionPants2WashableInfo.setWp2BeltLoopPlace5(OptionCodeKeys.PT2_0000805);
		
		optionPants2WashableInfo.setWp2BeltLoopPlace6(OptionCodeKeys.PT2_0000806);
		
		optionPants2WashableInfo.setWp2BeltLoopPlace7(null);
		
		optionPants2WashableInfo.setWp2BeltLoopPlace(null);
		// ピンループ
		optionPants2WashableInfo.setWp2PinLoop(OptionCodeKeys.PT2_0000901);
		// 脇ポケット
		optionPants2WashableInfo.setWp2SidePkt(OptionCodeKeys.PT2_0001002);
		// 忍びポケット
		optionPants2WashableInfo.setWp2SinobiPkt(OptionCodeKeys.PT2_0001104);
		// コインポケット
		optionPants2WashableInfo.setWp2CoinPkt(OptionCodeKeys.PT2_0001201);
		// フラップ付コインポケット
		optionPants2WashableInfo.setWp2FlapCoinPkt(OptionCodeKeys.PT2_0001301);
		// 上前ピスポケット
		optionPants2WashableInfo.setWp2PisPktUf(OptionCodeKeys.PT2_0001401);
		// 下前ピスポケット
		optionPants2WashableInfo.setWp2PisPktDf(OptionCodeKeys.PT2_0001501);
		// Vカット
		optionPants2WashableInfo.setWp2VCut(OptionCodeKeys.PT2_0001602);
		// 裾上げ
		optionPants2WashableInfo.setWp2HemUp(OptionCodeKeys.PT2_0001701);
		// ダブル幅
		optionPants2WashableInfo.setWp2DoubleWide(OptionCodeKeys.PT2_4);
		// ステッチ種類
		optionPants2WashableInfo.setWp2Stitch(OptionCodeKeys.PT2_0005104);
		// ステッチ箇所変更
		optionPants2WashableInfo.setWp2StitchModify(OptionCodeKeys.PT2_0002001);
		optionPants2WashableInfo.setWp2StitchModifyPlace(null);
		optionPants2WashableInfo.setWp2StitchModifyPlace1(null);
		optionPants2WashableInfo.setWp2StitchModifyPlace2(null);
		optionPants2WashableInfo.setWp2StitchModifyPlace3(null);
		optionPants2WashableInfo.setWp2StitchModifyPlace4(null);
		// ダブルステッチ
		optionPants2WashableInfo.setWp2DStitch(OptionCodeKeys.PT2_0002201);
		optionPants2WashableInfo.setWp2DStitchPlace(null);
		optionPants2WashableInfo.setWp2DStitchPlace1(null);
		optionPants2WashableInfo.setWp2DStitchPlace2(null);
		optionPants2WashableInfo.setWp2DStitchPlace3(null);
		// AMF色指定
		optionPants2WashableInfo.setWp2AmfColor(OptionCodeKeys.PT2_0002401);
		optionPants2WashableInfo.setWp2AmfColorPlace(null);
		optionPants2WashableInfo.setWp2AmfColorPlace1(null);
		optionPants2WashableInfo.setWp2AmfColorPlace2(null);
		optionPants2WashableInfo.setWp2AmfColorPlace3(null);
		optionPants2WashableInfo.setWp2AmfColorPlace4(null);
		optionPants2WashableInfo.setWp2AmfColor1(null);
		optionPants2WashableInfo.setWp2AmfColor2(null);
		optionPants2WashableInfo.setWp2AmfColor3(null);
		optionPants2WashableInfo.setWp2AmfColor4(null);
		optionPants2WashableInfo.setWp2AmfAllColor(null);
		// ボタンホール色指定
		optionPants2WashableInfo.setWp2BhColor(OptionCodeKeys.PT2_0002701);
		optionPants2WashableInfo.setWp2BhColorPlace(null);
		optionPants2WashableInfo.setWp2BhColorPlace1(null);
		optionPants2WashableInfo.setWp2BhColorPlace2(null);
		optionPants2WashableInfo.setWp2BhColorPlace3(null);
		optionPants2WashableInfo.setWp2BhColorPlace4(null);
		optionPants2WashableInfo.setWp2BhColor1(null);
		optionPants2WashableInfo.setWp2BhColor2(null);
		optionPants2WashableInfo.setWp2BhColor3(null);
		optionPants2WashableInfo.setWp2BhColor4(null);
		optionPants2WashableInfo.setWp2BhAllColor(null);
		// ボタン付け糸指定
		optionPants2WashableInfo.setWp2ByColor(OptionCodeKeys.PT2_0003001);
		optionPants2WashableInfo.setWp2ByColorPlace(null);
		optionPants2WashableInfo.setWp2ByColorPlace1(null);
		optionPants2WashableInfo.setWp2ByColorPlace2(null);
		optionPants2WashableInfo.setWp2ByColorPlace3(null);
		optionPants2WashableInfo.setWp2ByColorPlace4(null);
		optionPants2WashableInfo.setWp2ByColor1(null);
		optionPants2WashableInfo.setWp2ByColor2(null);
		optionPants2WashableInfo.setWp2ByColor3(null);
		optionPants2WashableInfo.setWp2ByColor4(null);
		optionPants2WashableInfo.setWp2ByAllColor(null);
		// 釦素材
		if("1".equals(orderCoForm.getOjBtnMatePt2Flag())) {
			
		}else {
		  optionPants2WashableInfo.setWp2Button(OptionCodeKeys.PT2_3000800);
		
		  optionPants2WashableInfo.setWp2BtnMateStkNo(null);
		}
		// サスペンダー釦
		optionPants2WashableInfo.setWp2SuspenderBtn(OptionCodeKeys.PT2_0003501);
		// シック大（股補強）
		optionPants2WashableInfo.setWp2Thick(OptionCodeKeys.PT2_0004101);
		// エイト（滑り止め）
		optionPants2WashableInfo.setWp2Eight(OptionCodeKeys.PT2_0003601);
		// 形状記憶　仕様変更⇒「形状記憶」のデフォルトは「有り」にする
//		optionPants2WashableInfo.setWp2ShapeMemory(OptionCodeKeys.PT2_0003701);
		optionPants2WashableInfo.setWp2ShapeMemory(OptionCodeKeys.PT2_0003702);

	}
	
	public void pants2DefaultValueFromDb(OrderCoForm orderCoForm, Order orderPt2) {
		String productCategory = orderCoForm.getProductCategory();
		if ("9000101".equals(productCategory)) {
			// 標準
			CoOptionPants2StandardInfo optionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
			optionPants2StandardInfo.setOp2PantsModel(orderPt2.getPt2ModelCd());
			optionPants2StandardInfo.setOp2Tack(orderPt2.getPt2TackCd());
			optionPants2StandardInfo.setOp2KneeBack(orderPt2.getPt2KneeinnerTypeCd());
			if ("0000202".equals(orderPt2.getPt2KneeinnerTypeCd())) {
				optionPants2StandardInfo.setOp2KneeBackMate("0000301");
			} else {
				optionPants2StandardInfo.setOp2KneeBackMate(orderPt2.getPt2KneeinnerClothCd());
			}
			optionPants2StandardInfo.setOp2FrontSpec(orderPt2.getPt2FrtTypeCd());
			optionPants2StandardInfo.setOp2Pancherina(orderPt2.getPt2PancherinaCd());
			optionPants2StandardInfo.setOp2Adjuster(orderPt2.getPt2AdjusterCd());
			optionPants2StandardInfo.setOp2BeltLoop(orderPt2.getPt2BeltloopType());
			optionPants2StandardInfo.setOp2BeltLoopPlace(orderPt2.getPt2BeltloopCd());
			optionPants2StandardInfo.setOp2PinLoop(orderPt2.getPt2PinloopCd());
			optionPants2StandardInfo.setOp2SidePkt(orderPt2.getPt2SidePktCd());
			optionPants2StandardInfo.setOp2SinobiPkt(orderPt2.getPt2ShinobiPktCd());
			optionPants2StandardInfo.setOp2CoinPkt(orderPt2.getPt2CoinPktCd());
			optionPants2StandardInfo.setOp2FlapCoinPkt(orderPt2.getPt2FlapcoinPktCd());
			optionPants2StandardInfo.setOp2PisPktUf(orderPt2.getPt2LeftPisPktCd());
			optionPants2StandardInfo.setOp2PisPktDf(orderPt2.getPt2RightPisPktCd());
			optionPants2StandardInfo.setOp2VCut(orderPt2.getPt2VCutCd());
			optionPants2StandardInfo.setOp2HemUp(orderPt2.getPt2HemUpCd());
			optionPants2StandardInfo.setOp2DoubleWide(orderPt2.getPt2DblWidthCd());
			optionPants2StandardInfo.setOp2Stitch(orderPt2.getPt2AmfStitchCd());
			optionPants2StandardInfo.setOp2StitchModify(orderPt2.getPt2StitchPlcType());
			if ("0002001".equals(orderPt2.getPt2StitchPlcType())) {
				optionPants2StandardInfo.setOp2StitchModifyPlace(null);
			} else {
				optionPants2StandardInfo.setOp2StitchModifyPlace(orderPt2.getPt2StitchPlcCd());
			}
			optionPants2StandardInfo.setOp2DStitch(orderPt2.getPt2DblstitchPlcType());
			optionPants2StandardInfo.setOp2DStitchPlace(orderPt2.getPt2DblstitchPlcCd());
			optionPants2StandardInfo.setOp2AmfColor(orderPt2.getPt2AmfColorType());
			optionPants2StandardInfo.setOp2AmfColorPlace(orderPt2.getPt2AmfColorPlcCd());
			optionPants2StandardInfo.setOp2AmfAllColor(orderPt2.getPt2AmfColorCd());
			optionPants2StandardInfo.setOp2BhColor(orderPt2.getPt2BtnholeColorType());
			optionPants2StandardInfo.setOp2BhColorPlace(orderPt2.getPt2BtnholeColorPlcCd());
			optionPants2StandardInfo.setOp2BhAllColor(orderPt2.getPt2BtnholeColorCd());
			optionPants2StandardInfo.setOp2ByColor(orderPt2.getPt2BtnthreadColorType());
			optionPants2StandardInfo.setOp2ByColorPlace(orderPt2.getPt2BtnthreadColorPlcCd());
			optionPants2StandardInfo.setOp2ByAllColor(orderPt2.getPt2BtnthreadColorCd());
			optionPants2StandardInfo.setOp2Button(orderPt2.getPt2BtnMaterialType());
			optionPants2StandardInfo.setOp2BtnMateStkNo(orderPt2.getPt2BtnMaterialCd());
			optionPants2StandardInfo.setOp2SuspenderBtn(orderPt2.getPt2SuspenderBtnCd());
			optionPants2StandardInfo.setOp2Eight(orderPt2.getPt2NonSlipCd());
			optionPants2StandardInfo.setOp2ShapeMemory(orderPt2.getPt2ShapeMemoryCd());
			optionPants2StandardInfo.setOp2Blister(orderPt2.getPt2ShoeSoreCd());
			optionPants2StandardInfo.setOp2Thick(orderPt2.getPt2ChicSlipCd());
			
			pluralPt2StandardOptionItem(optionPants2StandardInfo,orderPt2);
		} else if ("9000102".equals(productCategory)) {
			// タキシード
			CoOptionPants2TuxedoInfo optionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();

			optionPants2TuxedoInfo.setTp2PantsModel(orderPt2.getPt2ModelCd());
			optionPants2TuxedoInfo.setTp2Tack(orderPt2.getPt2TackCd());
			optionPants2TuxedoInfo.setTp2KneeBack(orderPt2.getPt2KneeinnerTypeCd());
			if ("0000202".equals(orderPt2.getPt2KneeinnerTypeCd())) {
				optionPants2TuxedoInfo.setTp2KneeBackMate("0000301");
			} else {
				optionPants2TuxedoInfo.setTp2KneeBackMate(orderPt2.getPt2KneeinnerClothCd());
			}
			optionPants2TuxedoInfo.setTp2FrontSpec(orderPt2.getPt2FrtTypeCd());
			optionPants2TuxedoInfo.setTp2Pancherina(orderPt2.getPt2PancherinaCd());
			optionPants2TuxedoInfo.setTp2Adjuster(orderPt2.getPt2AdjusterCd());
			optionPants2TuxedoInfo.setTp2BeltLoop(orderPt2.getPt2BeltloopType());
			optionPants2TuxedoInfo.setTp2BeltLoopPlace(orderPt2.getPt2BeltloopCd());
			optionPants2TuxedoInfo.setTp2PinLoop(orderPt2.getPt2PinloopCd());
			optionPants2TuxedoInfo.setTp2SidePkt(orderPt2.getPt2SidePktCd());
			optionPants2TuxedoInfo.setTp2SinobiPkt(orderPt2.getPt2ShinobiPktCd());
			optionPants2TuxedoInfo.setTp2CoinPkt(orderPt2.getPt2CoinPktCd());
			optionPants2TuxedoInfo.setTp2FlapCoinPkt(orderPt2.getPt2FlapcoinPktCd());
			optionPants2TuxedoInfo.setTp2PisPktUf(orderPt2.getPt2LeftPisPktCd());
			optionPants2TuxedoInfo.setTp2PisPktDf(orderPt2.getPt2RightPisPktCd());
			optionPants2TuxedoInfo.setTp2VCut(orderPt2.getPt2VCutCd());
			optionPants2TuxedoInfo.setTp2HemUp(orderPt2.getPt2HemUpCd());
			optionPants2TuxedoInfo.setTp2DoubleWide(orderPt2.getPt2DblWidthCd());
			optionPants2TuxedoInfo.setTp2Stitch(orderPt2.getPt2AmfStitchCd());
//			optionPants2TuxedoInfo.setTp2StitchModify(orderPt2.getPt2StitchPlcType());
//			optionPants2TuxedoInfo.setTp2DStitchPlace(orderPt2.getPt2DblstitchPlcCd());
//			optionPants2TuxedoInfo.setTp2AmfColor(orderPt2.getPt2AmfColorCd());
			optionPants2TuxedoInfo.setTp2BhColor(orderPt2.getPt2BtnholeColorType());
			optionPants2TuxedoInfo.setTp2BhColorPlace(orderPt2.getPt2BtnholeColorPlcCd());
			optionPants2TuxedoInfo.setTp2BhAllColor(orderPt2.getPt2BtnholeColorCd());
			// optionPantsTuxedoInfo.setTpBhColorPlaceAll(tpBhColorPlaceAll);
			optionPants2TuxedoInfo.setTp2ByColor(orderPt2.getPt2BtnthreadColorType());
			optionPants2TuxedoInfo.setTp2ByColorPlace(orderPt2.getPt2BtnthreadColorPlcCd());
			optionPants2TuxedoInfo.setTp2ByAllColor(orderPt2.getPt2BtnthreadColorCd());
			optionPants2TuxedoInfo.setTp2Button(orderPt2.getPt2BtnMaterialType());
			// optionPantsTuxedoInfo.setTpBtnMateStkNo(tpBtnMateStkNo);
			optionPants2TuxedoInfo.setTp2BtnMateStkNo(orderPt2.getPt2BtnMaterialCd());
			optionPants2TuxedoInfo.setTp2SuspenderBtn(orderPt2.getPt2SuspenderBtnCd());
			optionPants2TuxedoInfo.setTp2Eight(orderPt2.getPt2NonSlipCd());
			optionPants2TuxedoInfo.setTp2Thick(orderPt2.getPt2ChicSlipCd());
			optionPants2TuxedoInfo.setTp2ShapeMemory(orderPt2.getPt2ShapeMemoryCd());
			optionPants2TuxedoInfo.setTp2SideStripe(orderPt2.getPt2SideStripeCd());
			optionPants2TuxedoInfo.setTp2SideStripeWidth(orderPt2.getPt2SideStripeWidthCd());
			optionPants2TuxedoInfo.setTp2GlossFablic(orderPt2.getPt2LookClothCd());
			
			pluralPt2TuxedoOptionItem(optionPants2TuxedoInfo,orderPt2);
		} else if ("9000103".equals(productCategory)) {
			// ウォッシャブル
			CoOptionPants2WashableInfo optionPants2WashableInfo = orderCoForm.getCoOptionPants2WashableInfo();
			optionPants2WashableInfo.setWp2PantsModel(orderPt2.getPt2ModelCd());
			optionPants2WashableInfo.setWp2Tack(orderPt2.getPt2TackCd());
			optionPants2WashableInfo.setWp2KneeBack(orderPt2.getPt2KneeinnerTypeCd());
			if ("0000202".equals(orderPt2.getPt2KneeinnerTypeCd())) {
				optionPants2WashableInfo.setWp2KneeBackMate("0000301");
			} else {
				optionPants2WashableInfo.setWp2KneeBackMate(orderPt2.getPt2KneeinnerClothCd());
			}
			optionPants2WashableInfo.setWp2FrontSpec(orderPt2.getPt2FrtTypeCd());
			optionPants2WashableInfo.setWp2Pancherina(orderPt2.getPt2PancherinaCd());
			optionPants2WashableInfo.setWp2Adjuster(orderPt2.getPt2AdjusterCd());
			optionPants2WashableInfo.setWp2BeltLoop(orderPt2.getPt2BeltloopType());
			optionPants2WashableInfo.setWp2BeltLoopPlace(orderPt2.getPt2BeltloopCd());
			optionPants2WashableInfo.setWp2PinLoop(orderPt2.getPt2PinloopCd());
			optionPants2WashableInfo.setWp2SidePkt(orderPt2.getPt2SidePktCd());
			optionPants2WashableInfo.setWp2SinobiPkt(orderPt2.getPt2ShinobiPktCd());
			optionPants2WashableInfo.setWp2CoinPkt(orderPt2.getPt2CoinPktCd());
			optionPants2WashableInfo.setWp2FlapCoinPkt(orderPt2.getPt2FlapcoinPktCd());
			optionPants2WashableInfo.setWp2PisPktUf(orderPt2.getPt2LeftPisPktCd());
			optionPants2WashableInfo.setWp2PisPktDf(orderPt2.getPt2RightPisPktCd());
			optionPants2WashableInfo.setWp2VCut(orderPt2.getPt2VCutCd());
			optionPants2WashableInfo.setWp2HemUp(orderPt2.getPt2HemUpCd());
			optionPants2WashableInfo.setWp2DoubleWide(orderPt2.getPt2DblWidthCd());
			optionPants2WashableInfo.setWp2Stitch(orderPt2.getPt2AmfStitchCd());
			optionPants2WashableInfo.setWp2StitchModify(orderPt2.getPt2StitchPlcType());
			if ("0002001".equals(orderPt2.getPt2StitchPlcType())) {
				optionPants2WashableInfo.setWp2StitchModifyPlace(null);
			} else {
				optionPants2WashableInfo.setWp2StitchModifyPlace(orderPt2.getPt2StitchPlcCd());
			}
			optionPants2WashableInfo.setWp2DStitch(orderPt2.getPt2DblstitchPlcType());
			optionPants2WashableInfo.setWp2DStitchPlace(orderPt2.getPt2DblstitchPlcCd());
			optionPants2WashableInfo.setWp2AmfColor(orderPt2.getPt2AmfColorType());
			optionPants2WashableInfo.setWp2AmfColorPlace(orderPt2.getPt2AmfColorPlcCd());
			optionPants2WashableInfo.setWp2AmfAllColor(orderPt2.getPt2AmfColorCd());
			optionPants2WashableInfo.setWp2BhColor(orderPt2.getPt2BtnholeColorType());
			optionPants2WashableInfo.setWp2BhColorPlace(orderPt2.getPt2BtnholeColorPlcCd());
			optionPants2WashableInfo.setWp2BhAllColor(orderPt2.getPt2BtnholeColorCd());
			optionPants2WashableInfo.setWp2ByColor(orderPt2.getPt2BtnthreadColorType());
			optionPants2WashableInfo.setWp2ByColorPlace(orderPt2.getPt2BtnthreadColorPlcCd());
			optionPants2WashableInfo.setWp2ByAllColor(orderPt2.getPt2BtnthreadColorCd());
			optionPants2WashableInfo.setWp2Button(orderPt2.getPt2BtnMaterialType());
			optionPants2WashableInfo.setWp2BtnMateStkNo(orderPt2.getPt2BtnMaterialCd());
			optionPants2WashableInfo.setWp2SuspenderBtn(orderPt2.getPt2SuspenderBtnCd());
			optionPants2WashableInfo.setWp2Eight(orderPt2.getPt2NonSlipCd());
			optionPants2WashableInfo.setWp2Thick(orderPt2.getPt2ChicSlipCd());
			optionPants2WashableInfo.setWp2ShapeMemory(orderPt2.getPt2ShapeMemoryCd());
			optionPants2WashableInfo.setWp2Blister(orderPt2.getPt2ShoeSoreCd());
			
			pluralPt2WashableOptionItem(optionPants2WashableInfo,orderPt2);
		}

	}
	private void pluralPt2StandardOptionItem(CoOptionPants2StandardInfo optionPants2StandardInfo, Order orderPt2) {
		String regex = "/";
		//ベルトループ
		String pt2BeltloopCd = orderPt2.getPt2BeltloopCd();
//		if(pt2BeltloopCd != null && !"".equals(pt2BeltloopCd)&&!pt2BeltloopCd.startsWith(regex)) {
		if(pt2BeltloopCd != null && !"".equals(pt2BeltloopCd)) {
			String[] pt2BeltloopSplit = pt2BeltloopCd.split(regex);
			for (String pt2BeltloopCode : pt2BeltloopSplit) {
				if("0000801".equals(pt2BeltloopCode)) {
					optionPants2StandardInfo.setOp2BeltLoopPlace1(pt2BeltloopCode);
				}else if("0000802".equals(pt2BeltloopCode)) {
					optionPants2StandardInfo.setOp2BeltLoopPlace2(pt2BeltloopCode);
				}else if("0000803".equals(pt2BeltloopCode)) {
					optionPants2StandardInfo.setOp2BeltLoopPlace3(pt2BeltloopCode);
				}else if("0000804".equals(pt2BeltloopCode)) {
					optionPants2StandardInfo.setOp2BeltLoopPlace4(pt2BeltloopCode);
				}else if("0000805".equals(pt2BeltloopCode)) {
					optionPants2StandardInfo.setOp2BeltLoopPlace5(pt2BeltloopCode);
				}else if("0000806".equals(pt2BeltloopCode)) {
					optionPants2StandardInfo.setOp2BeltLoopPlace6(pt2BeltloopCode);
				}else if("0000807".equals(pt2BeltloopCode)) {
					optionPants2StandardInfo.setOp2BeltLoopPlace7(pt2BeltloopCode);
				}
			}
		}
		
		//ステッチ箇所変更
		String pt2StitchPlcCd = orderPt2.getPt2StitchPlcCd();
//		if(pt2StitchPlcCd != null && !"".equals(pt2StitchPlcCd)&&!pt2StitchPlcCd.startsWith(regex)) {
//		if(pt2StitchPlcCd != null && !"".equals(pt2StitchPlcCd)) {
		if(pt2StitchPlcCd != null && !"".equals(pt2StitchPlcCd) && !"0002001".equals(orderPt2.getPt2StitchPlcType())) {
			String[] pt2StitchPlcSplit = pt2StitchPlcCd.split(regex);
			for (String stitchPlcCode : pt2StitchPlcSplit) {
				if("0002101".equals(stitchPlcCode)) {
					optionPants2StandardInfo.setOp2StitchModifyPlace1(stitchPlcCode);
				}else if("0002102".equals(stitchPlcCode)) {
					optionPants2StandardInfo.setOp2StitchModifyPlace2(stitchPlcCode);
				}else if("0002103".equals(stitchPlcCode)) {
					optionPants2StandardInfo.setOp2StitchModifyPlace3(stitchPlcCode);
				}else if("0002104".equals(stitchPlcCode)) {
					optionPants2StandardInfo.setOp2StitchModifyPlace4(stitchPlcCode);
				}
			}
		}
		
		//ダブルステッチ
		String pt2DblstitchPlcCd = orderPt2.getPt2DblstitchPlcCd();
//		if(pt2DblstitchPlcCd != null && !"".equals(pt2DblstitchPlcCd)&&!pt2DblstitchPlcCd.startsWith(regex)) {
		if(pt2DblstitchPlcCd != null && !"".equals(pt2DblstitchPlcCd)) {
			String[] pt2DblstitchPlcSplit = pt2DblstitchPlcCd.split(regex);
			for (String dblstitchPlcCode : pt2DblstitchPlcSplit) {
				if("0002301".equals(dblstitchPlcCode)) {
					optionPants2StandardInfo.setOp2DStitchPlace1(dblstitchPlcCode);
				}else if("0002302".equals(dblstitchPlcCode)) {
					optionPants2StandardInfo.setOp2DStitchPlace2(dblstitchPlcCode);
				}else if("0002304".equals(dblstitchPlcCode)) {
					optionPants2StandardInfo.setOp2DStitchPlace3(dblstitchPlcCode);
				}
			}
		}
		
		//AMF色指定
		String pt2AmfColorPlcCd = orderPt2.getPt2AmfColorPlcCd();
		String pt2AmfColorCd = orderPt2.getPt2AmfColorCd();
//		if(pt2AmfColorPlcCd!=null && !"".equals(pt2AmfColorPlcCd) && pt2AmfColorCd !=null && !"".equals(pt2AmfColorCd)&&
//				!pt2AmfColorPlcCd.startsWith(regex)&&!pt2AmfColorCd.startsWith(regex)) {
		if(pt2AmfColorPlcCd!=null && !"".equals(pt2AmfColorPlcCd) && pt2AmfColorCd !=null && !"".equals(pt2AmfColorCd)) {
			String[] pt2AmfColorPlcSplit = pt2AmfColorPlcCd.split(regex);
			String[] pt2AmfColorSplit = pt2AmfColorCd.split(regex);
			pt2AmfColorSplit = BaseCheckUtil.placeColorMethod(pt2AmfColorPlcSplit.length,pt2AmfColorSplit);
			for (int i = 0;i<pt2AmfColorPlcSplit.length;i++) {
				if("0002601".equals(pt2AmfColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2AmfColorPlace1(pt2AmfColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2AmfColor1(pt2AmfColorSplit[i]);
				}else if("0002602".equals(pt2AmfColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2AmfColorPlace2(pt2AmfColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2AmfColor2(pt2AmfColorSplit[i]);
				}else if("0002603".equals(pt2AmfColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2AmfColorPlace3(pt2AmfColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2AmfColor3(pt2AmfColorSplit[i]);
				}else if("0002604".equals(pt2AmfColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2AmfColorPlace4(pt2AmfColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2AmfColor4(pt2AmfColorSplit[i]);
				}
			}
		}
		
		//ボタンホール色指定
		String pt2BtnholeColorPlcCd = orderPt2.getPt2BtnholeColorPlcCd();
		String Pt2BtnholeColorCd = orderPt2.getPt2BtnholeColorCd();
//		if(!"".equals(pt2BtnholeColorPlcCd)&&pt2BtnholeColorPlcCd!=null&&!"".equals(Pt2BtnholeColorCd)&&Pt2BtnholeColorCd!=null&&
//				!pt2BtnholeColorPlcCd.startsWith(regex)&&!Pt2BtnholeColorCd.startsWith(regex)) {
		if(!"".equals(pt2BtnholeColorPlcCd)&&pt2BtnholeColorPlcCd!=null&&!"".equals(Pt2BtnholeColorCd)&&Pt2BtnholeColorCd!=null) {
			String[] pt2BtnholeColorPlcSplit = pt2BtnholeColorPlcCd.split(regex);
			String[] Pt2BtnholeColorSplit = Pt2BtnholeColorCd.split(regex);
			Pt2BtnholeColorSplit = BaseCheckUtil.placeColorMethod(pt2BtnholeColorPlcSplit.length,Pt2BtnholeColorSplit);
			for (int i = 0; i < pt2BtnholeColorPlcSplit.length; i++) {
				if("0002901".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2BhColorPlace1(pt2BtnholeColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2BhColor1(Pt2BtnholeColorSplit[i]);
				}else if("0002902".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2BhColorPlace2(pt2BtnholeColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2BhColor2(Pt2BtnholeColorSplit[i]);
				}else if("0002903".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2BhColorPlace3(pt2BtnholeColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2BhColor3(Pt2BtnholeColorSplit[i]);
				}else if("0002904".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2BhColorPlace4(pt2BtnholeColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2BhColor4(Pt2BtnholeColorSplit[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String pt2BtnthreadColorPlcCd = orderPt2.getPt2BtnthreadColorPlcCd();
		String pt2BtnthreadColorCd = orderPt2.getPt2BtnthreadColorCd();
//		if(!"".equals(pt2BtnthreadColorPlcCd)&&pt2BtnthreadColorPlcCd!=null&&!"".equals(pt2BtnthreadColorCd)&&pt2BtnthreadColorCd!=null&&
//				!pt2BtnthreadColorPlcCd.startsWith(regex)&&!pt2BtnthreadColorCd.startsWith(regex)) {
		if(!"".equals(pt2BtnthreadColorPlcCd)&&pt2BtnthreadColorPlcCd!=null&&!"".equals(pt2BtnthreadColorCd)&&pt2BtnthreadColorCd!=null) {
			String[] pt2BtnthreadColorPlcSplit = pt2BtnthreadColorPlcCd.split(regex);
			String[] pt2BtnthreadColorSplit = pt2BtnthreadColorCd.split(regex);
			pt2BtnthreadColorSplit = BaseCheckUtil.placeColorMethod(pt2BtnthreadColorPlcSplit.length,pt2BtnthreadColorSplit);
			for (int i = 0; i < pt2BtnthreadColorPlcSplit.length; i++) {
				if("0003201".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2ByColorPlace1(pt2BtnthreadColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2ByColor1(pt2BtnthreadColorSplit[i]);
				}else if("0003202".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2ByColorPlace2(pt2BtnthreadColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2ByColor2(pt2BtnthreadColorSplit[i]);
				}else if("0003203".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2ByColorPlace3(pt2BtnthreadColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2ByColor3(pt2BtnthreadColorSplit[i]);
				}else if("0003204".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2StandardInfo.setOp2ByColorPlace4(pt2BtnthreadColorPlcSplit[i]);
					optionPants2StandardInfo.setOp2ByColor4(pt2BtnthreadColorSplit[i]);
				}
			}
		}
	}
	
	private void pluralPt2TuxedoOptionItem(CoOptionPants2TuxedoInfo optionPants2TuxedoInfo, Order orderPt2) {
		String regex = "/";
		//ベルトループ
		String pt2BeltloopCd = orderPt2.getPt2BeltloopCd();
//		if(pt2BeltloopCd != null && !"".equals(pt2BeltloopCd)&&!pt2BeltloopCd.startsWith(regex)) {
		if(pt2BeltloopCd != null && !"".equals(pt2BeltloopCd)) {
			String[] pt2BeltloopSplit = pt2BeltloopCd.split(regex);
			for (String pt2BeltloopCode : pt2BeltloopSplit) {
				if("0000801".equals(pt2BeltloopCode)) {
					optionPants2TuxedoInfo.setTp2BeltLoopPlace1(pt2BeltloopCode);
				}else if("0000802".equals(pt2BeltloopCode)) {
					optionPants2TuxedoInfo.setTp2BeltLoopPlace2(pt2BeltloopCode);
				}else if("0000803".equals(pt2BeltloopCode)) {
					optionPants2TuxedoInfo.setTp2BeltLoopPlace3(pt2BeltloopCode);
				}else if("0000804".equals(pt2BeltloopCode)) {
					optionPants2TuxedoInfo.setTp2BeltLoopPlace4(pt2BeltloopCode);
				}else if("0000805".equals(pt2BeltloopCode)) {
					optionPants2TuxedoInfo.setTp2BeltLoopPlace5(pt2BeltloopCode);
				}else if("0000806".equals(pt2BeltloopCode)) {
					optionPants2TuxedoInfo.setTp2BeltLoopPlace6(pt2BeltloopCode);
				}else if("0000807".equals(pt2BeltloopCode)) {
					optionPants2TuxedoInfo.setTp2BeltLoopPlace7(pt2BeltloopCode);
				}
			}
		}

		//ボタンホール色指定
		String pt2BtnholeColorPlcCd = orderPt2.getPt2BtnholeColorPlcCd();
		String Pt2BtnholeColorCd = orderPt2.getPt2BtnholeColorCd();
//		if(!"".equals(pt2BtnholeColorPlcCd)&&pt2BtnholeColorPlcCd!=null&&!"".equals(Pt2BtnholeColorCd)&&Pt2BtnholeColorCd!=null&&
//				!pt2BtnholeColorPlcCd.startsWith(regex)&&!Pt2BtnholeColorCd.startsWith(regex)) {
		if(!"".equals(pt2BtnholeColorPlcCd)&&pt2BtnholeColorPlcCd!=null&&!"".equals(Pt2BtnholeColorCd)&&Pt2BtnholeColorCd!=null) {
			String[] pt2BtnholeColorPlcSplit = pt2BtnholeColorPlcCd.split(regex);
			String[] Pt2BtnholeColorSplit = Pt2BtnholeColorCd.split(regex);
			Pt2BtnholeColorSplit = BaseCheckUtil.placeColorMethod(pt2BtnholeColorPlcSplit.length,Pt2BtnholeColorSplit);
			for (int i = 0; i < pt2BtnholeColorPlcSplit.length; i++) {
				if("0002901".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2TuxedoInfo.setTp2BhColorPlace1(pt2BtnholeColorPlcSplit[i]);
					optionPants2TuxedoInfo.setTp2BhColor1(Pt2BtnholeColorSplit[i]);
				}else if("0002902".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2TuxedoInfo.setTp2BhColorPlace2(pt2BtnholeColorPlcSplit[i]);
					optionPants2TuxedoInfo.setTp2BhColor2(Pt2BtnholeColorSplit[i]);
				}else if("0002903".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2TuxedoInfo.setTp2BhColorPlace3(pt2BtnholeColorPlcSplit[i]);
					optionPants2TuxedoInfo.setTp2BhColor3(Pt2BtnholeColorSplit[i]);
				}else if("0002904".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2TuxedoInfo.setTp2BhColorPlace4(pt2BtnholeColorPlcSplit[i]);
					optionPants2TuxedoInfo.setTp2BhColor4(Pt2BtnholeColorSplit[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String pt2BtnthreadColorPlcCd = orderPt2.getPt2BtnthreadColorPlcCd();
		String pt2BtnthreadColorCd = orderPt2.getPt2BtnthreadColorCd();
//		if(!"".equals(pt2BtnthreadColorPlcCd)&&pt2BtnthreadColorPlcCd!=null&&!"".equals(pt2BtnthreadColorCd)&&pt2BtnthreadColorCd!=null&&
//				!pt2BtnthreadColorPlcCd.startsWith(regex)&&!pt2BtnthreadColorCd.startsWith(regex)) {
		if(!"".equals(pt2BtnthreadColorPlcCd)&&pt2BtnthreadColorPlcCd!=null&&!"".equals(pt2BtnthreadColorCd)&&pt2BtnthreadColorCd!=null) {
			String[] pt2BtnthreadColorPlcSplit = pt2BtnthreadColorPlcCd.split(regex);
			String[] pt2BtnthreadColorSplit = pt2BtnthreadColorCd.split(regex);
			pt2BtnthreadColorSplit = BaseCheckUtil.placeColorMethod(pt2BtnthreadColorPlcSplit.length,pt2BtnthreadColorSplit);
			for (int i = 0; i < pt2BtnthreadColorPlcSplit.length; i++) {
				if("0003201".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2TuxedoInfo.setTp2ByColorPlace1(pt2BtnthreadColorPlcSplit[i]);
					optionPants2TuxedoInfo.setTp2ByColor1(pt2BtnthreadColorSplit[i]);
				}else if("0003202".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2TuxedoInfo.setTp2ByColorPlace2(pt2BtnthreadColorPlcSplit[i]);
					optionPants2TuxedoInfo.setTp2ByColor2(pt2BtnthreadColorSplit[i]);
				}else if("0003203".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2TuxedoInfo.setTp2ByColorPlace3(pt2BtnthreadColorPlcSplit[i]);
					optionPants2TuxedoInfo.setTp2ByColor3(pt2BtnthreadColorSplit[i]);
				}else if("0003204".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2TuxedoInfo.setTp2ByColorPlace4(pt2BtnthreadColorPlcSplit[i]);
					optionPants2TuxedoInfo.setTp2ByColor4(pt2BtnthreadColorSplit[i]);
				}
			}
		}
	}
	
	private void pluralPt2WashableOptionItem(CoOptionPants2WashableInfo optionPants2WashableInfo, Order orderPt2) {
		String regex = "/";
		//ベルトループ
		String pt2BeltloopCd = orderPt2.getPt2BeltloopCd();
//		if(pt2BeltloopCd != null && !"".equals(pt2BeltloopCd)&&!pt2BeltloopCd.startsWith(regex)) {
		if(pt2BeltloopCd != null && !"".equals(pt2BeltloopCd)) {
			String[] pt2BeltloopSplit = pt2BeltloopCd.split(regex);
			for (String pt2BeltloopCode : pt2BeltloopSplit) {
				if("0000801".equals(pt2BeltloopCode)) {
					optionPants2WashableInfo.setWp2BeltLoopPlace1(pt2BeltloopCode);
				}else if("0000802".equals(pt2BeltloopCode)) {
					optionPants2WashableInfo.setWp2BeltLoopPlace2(pt2BeltloopCode);
				}else if("0000803".equals(pt2BeltloopCode)) {
					optionPants2WashableInfo.setWp2BeltLoopPlace3(pt2BeltloopCode);
				}else if("0000804".equals(pt2BeltloopCode)) {
					optionPants2WashableInfo.setWp2BeltLoopPlace4(pt2BeltloopCode);
				}else if("0000805".equals(pt2BeltloopCode)) {
					optionPants2WashableInfo.setWp2BeltLoopPlace5(pt2BeltloopCode);
				}else if("0000806".equals(pt2BeltloopCode)) {
					optionPants2WashableInfo.setWp2BeltLoopPlace6(pt2BeltloopCode);
				}else if("0000807".equals(pt2BeltloopCode)) {
					optionPants2WashableInfo.setWp2BeltLoopPlace7(pt2BeltloopCode);
				}
			}
		}
		
		//ステッチ箇所変更
		String pt2StitchPlcCd = orderPt2.getPt2StitchPlcCd();
//		if(pt2StitchPlcCd != null && !"".equals(pt2StitchPlcCd)&&!pt2StitchPlcCd.startsWith(regex)) {
//		if(pt2StitchPlcCd != null && !"".equals(pt2StitchPlcCd)) {
		if(pt2StitchPlcCd != null && !"".equals(pt2StitchPlcCd) && !"0002001".equals(orderPt2.getPt2StitchPlcType())) {
			String[] pt2StitchPlcSplit = pt2StitchPlcCd.split(regex);
			for (String stitchPlcCode : pt2StitchPlcSplit) {
				if("0002101".equals(stitchPlcCode)) {
					optionPants2WashableInfo.setWp2StitchModifyPlace1(stitchPlcCode);
				}else if("0002102".equals(stitchPlcCode)) {
					optionPants2WashableInfo.setWp2StitchModifyPlace2(stitchPlcCode);
				}else if("0002103".equals(stitchPlcCode)) {
					optionPants2WashableInfo.setWp2StitchModifyPlace3(stitchPlcCode);
				}else if("0002104".equals(stitchPlcCode)) {
					optionPants2WashableInfo.setWp2StitchModifyPlace4(stitchPlcCode);
				}
			}
		}
		
		//ダブルステッチ
		String pt2DblstitchPlcCd = orderPt2.getPt2DblstitchPlcCd();
//		if(pt2DblstitchPlcCd != null && !"".equals(pt2DblstitchPlcCd)&&!pt2DblstitchPlcCd.startsWith(regex)) {
		if(pt2DblstitchPlcCd != null && !"".equals(pt2DblstitchPlcCd)) {
			String[] pt2DblstitchPlcSplit = pt2DblstitchPlcCd.split(regex);
			for (String dblstitchPlcCode : pt2DblstitchPlcSplit) {
				if("0002301".equals(dblstitchPlcCode)) {
					optionPants2WashableInfo.setWp2DStitchPlace1(dblstitchPlcCode);
				}else if("0002302".equals(dblstitchPlcCode)) {
					optionPants2WashableInfo.setWp2DStitchPlace2(dblstitchPlcCode);
				}else if("0002304".equals(dblstitchPlcCode)) {
					optionPants2WashableInfo.setWp2DStitchPlace3(dblstitchPlcCode);
				}
			}
		}
		
		//AMF色指定
		String pt2AmfColorPlcCd = orderPt2.getPt2AmfColorPlcCd();
		String pt2AmfColorCd = orderPt2.getPt2AmfColorCd();
//		if(pt2AmfColorPlcCd!=null && !"".equals(pt2AmfColorPlcCd) && pt2AmfColorCd !=null && !"".equals(pt2AmfColorCd)
//				&&!pt2AmfColorPlcCd.startsWith(regex)&&!pt2AmfColorCd.startsWith(regex)) {
		if(pt2AmfColorPlcCd!=null && !"".equals(pt2AmfColorPlcCd) && pt2AmfColorCd !=null && !"".equals(pt2AmfColorCd)) {
			String[] pt2AmfColorPlcSplit = pt2AmfColorPlcCd.split(regex);
			String[] pt2AmfColorSplit = pt2AmfColorCd.split(regex);
			pt2AmfColorSplit = BaseCheckUtil.placeColorMethod(pt2AmfColorPlcSplit.length,pt2AmfColorSplit);
			for (int i = 0;i<pt2AmfColorPlcSplit.length;i++) {
				if("0002601".equals(pt2AmfColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2AmfColorPlace1(pt2AmfColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2AmfColor1(pt2AmfColorSplit[i]);
				}else if("0002602".equals(pt2AmfColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2AmfColorPlace2(pt2AmfColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2AmfColor2(pt2AmfColorSplit[i]);
				}else if("0002603".equals(pt2AmfColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2AmfColorPlace3(pt2AmfColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2AmfColor3(pt2AmfColorSplit[i]);
				}else if("0002604".equals(pt2AmfColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2AmfColorPlace4(pt2AmfColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2AmfColor4(pt2AmfColorSplit[i]);
				}
			}
		}
		
		//ボタンホール色指定
		String pt2BtnholeColorPlcCd = orderPt2.getPt2BtnholeColorPlcCd();
		String Pt2BtnholeColorCd = orderPt2.getPt2BtnholeColorCd();
//		if(!"".equals(pt2BtnholeColorPlcCd)&&pt2BtnholeColorPlcCd!=null&&!"".equals(Pt2BtnholeColorCd)&&Pt2BtnholeColorCd!=null
//				&&!pt2BtnholeColorPlcCd.startsWith(regex)&&!Pt2BtnholeColorCd.startsWith(regex)) {
		if(!"".equals(pt2BtnholeColorPlcCd)&&pt2BtnholeColorPlcCd!=null&&!"".equals(Pt2BtnholeColorCd)&&Pt2BtnholeColorCd!=null) {
			String[] pt2BtnholeColorPlcSplit = pt2BtnholeColorPlcCd.split(regex);
			String[] Pt2BtnholeColorSplit = Pt2BtnholeColorCd.split(regex);
			Pt2BtnholeColorSplit = BaseCheckUtil.placeColorMethod(pt2BtnholeColorPlcSplit.length,Pt2BtnholeColorSplit);
			for (int i = 0; i < pt2BtnholeColorPlcSplit.length; i++) {
				if("0002901".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2BhColorPlace1(pt2BtnholeColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2BhColor1(Pt2BtnholeColorSplit[i]);
				}else if("0002902".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2BhColorPlace2(pt2BtnholeColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2BhColor2(Pt2BtnholeColorSplit[i]);
				}else if("0002903".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2BhColorPlace3(pt2BtnholeColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2BhColor3(Pt2BtnholeColorSplit[i]);
				}else if("0002904".equals(pt2BtnholeColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2BhColorPlace4(pt2BtnholeColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2BhColor4(Pt2BtnholeColorSplit[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String pt2BtnthreadColorPlcCd = orderPt2.getPt2BtnthreadColorPlcCd();
		String pt2BtnthreadColorCd = orderPt2.getPt2BtnthreadColorCd();
//		if(!"".equals(pt2BtnthreadColorPlcCd)&&pt2BtnthreadColorPlcCd!=null&&!"".equals(pt2BtnthreadColorCd)&&pt2BtnthreadColorCd!=null
//				&&!pt2BtnthreadColorPlcCd.startsWith(regex)&&!pt2BtnthreadColorCd.startsWith(regex)) {
		if(!"".equals(pt2BtnthreadColorPlcCd)&&pt2BtnthreadColorPlcCd!=null&&!"".equals(pt2BtnthreadColorCd)&&pt2BtnthreadColorCd!=null) {
			String[] pt2BtnthreadColorPlcSplit = pt2BtnthreadColorPlcCd.split(regex);
			String[] pt2BtnthreadColorSplit = pt2BtnthreadColorCd.split(regex);
			pt2BtnthreadColorSplit = BaseCheckUtil.placeColorMethod(pt2BtnthreadColorPlcSplit.length,pt2BtnthreadColorSplit);
			for (int i = 0; i < pt2BtnthreadColorPlcSplit.length; i++) {
				if("0003201".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2ByColorPlace1(pt2BtnthreadColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2ByColor1(pt2BtnthreadColorSplit[i]);
				}else if("0003202".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2ByColorPlace2(pt2BtnthreadColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2ByColor2(pt2BtnthreadColorSplit[i]);
				}else if("0003203".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2ByColorPlace3(pt2BtnthreadColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2ByColor3(pt2BtnthreadColorSplit[i]);
				}else if("0003204".equals(pt2BtnthreadColorPlcSplit[i])) {
					optionPants2WashableInfo.setWp2ByColorPlace4(pt2BtnthreadColorPlcSplit[i]);
					optionPants2WashableInfo.setWp2ByColor4(pt2BtnthreadColorSplit[i]);
				}
			}
		}
	}
}
