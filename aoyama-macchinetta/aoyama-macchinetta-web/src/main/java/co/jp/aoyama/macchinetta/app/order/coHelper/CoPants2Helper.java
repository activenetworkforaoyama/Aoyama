package co.jp.aoyama.macchinetta.app.order.coHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2TuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPants2WashableInfo;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionWashablePriceEnum;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;

public class CoPants2Helper {
	@Inject
	TypeSizeService typeSizeService;

	CoTypeSizeOptimization coTypeSizeOptimization = new CoTypeSizeOptimization();

	public boolean pants2Check(ResultMessages messages, OrderCoForm orderCoForm, String productCategory, String item,
			Map<String, List<Adjust>> adjustByItem, TypeSizeService typeSizeService) {
		String corPt2HemwidthType = orderCoForm.getCoAdjustPants2StandardInfo().getCorPt2HemwidthType();
		boolean pants2Flag = false;
		// 標準の場合
		if ("9000101".equals(productCategory)) {
			// PANTS2 モデル未選択の場合
			CoOptionPants2StandardInfo coOptionPants2StandardInfo = orderCoForm.getCoOptionPants2StandardInfo();
			String op2PantsModel = coOptionPants2StandardInfo.getOp2PantsModel();
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
					messages.add("E033", "PANTS（2本目）    ベルトループ");
					pants2Flag = true;
				}
				if ("NZ01".equals(op2PantsModel) && BaseCheckUtil.isEmpty(op2BeltLoopPlace7)) {
					messages.add("E033", "PANTS（2本目）    ベルトループ");
					pants2Flag = true;
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
				String op2DStitchPlace4 = coOptionPants2StandardInfo.getOp2DStitchPlace4();

				if (BaseCheckUtil.isEmpty(op2DStitchPlace1) && BaseCheckUtil.isEmpty(op2DStitchPlace2)
						&& BaseCheckUtil.isEmpty(op2DStitchPlace3) && BaseCheckUtil.isEmpty(op2DStitchPlace4)) {
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
					messages.add("E033", "PANTS（2本目）   ボタン付け糸指定");
					pants2Flag = true;
				}
				if (BaseCheckUtil.isNotEmpty(op2ByColorPlace1) && BaseCheckUtil.isEmpty(op2ByColor1)
						|| BaseCheckUtil.isNotEmpty(op2ByColorPlace2) && BaseCheckUtil.isEmpty(op2ByColor2)
						|| BaseCheckUtil.isNotEmpty(op2ByColorPlace3) && BaseCheckUtil.isEmpty(op2ByColor3)
						|| BaseCheckUtil.isNotEmpty(op2ByColorPlace4) && BaseCheckUtil.isEmpty(op2ByColor4)) {
					messages.add("E033", "PANTS（2本目）   ボタン付け糸指定");
					pants2Flag = true;
				}
			}
			// PANTS タキシードの場合
		} else if ("9000102".equals(productCategory)) {
			// PANTS モデル未選択の場合
			CoOptionPants2TuxedoInfo coOptionPants2TuxedoInfo = orderCoForm.getCoOptionPants2TuxedoInfo();
			String tp2PantsModel = coOptionPants2TuxedoInfo.getTp2PantsModel();
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
					messages.add("E033", "PANTS（2本目）   ベルトループ");
					pants2Flag = true;
				}

				if ("NZ01".equals(tp2PantsModel) && BaseCheckUtil.isEmpty(tp2BeltLoopPlace7)) {
					messages.add("E033", "PANTS（2本目）   ベルトループ");
					pants2Flag = true;
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
					messages.add("E033", "PANTS（2本目）   ベルトループ");
					pants2Flag = true;
				}

				if ("NZ01".equals(wp2PantsModel) && BaseCheckUtil.isEmpty(wp2BeltLoopPlace7)) {
					messages.add("E033", "PANTS（2本目）   ベルトループ");
					pants2Flag = true;
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
				String wp2DStitchPlace4 = coOptionPants2WashableInfo.getWp2DStitchPlace4();
				if (BaseCheckUtil.isEmpty(wp2DStitchPlace1) && BaseCheckUtil.isEmpty(wp2DStitchPlace2)
						&& BaseCheckUtil.isEmpty(wp2DStitchPlace3) && BaseCheckUtil.isEmpty(wp2DStitchPlace4)) {
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
			String sizeFigure = coAdjustPants2StandardInfo.getSizeFigure();
			if ("".equals(sizeFigure) || null == sizeFigure) {
				messages.add("E031", "PANTS（2本目）サイズ体型");
				pants2Flag = true;
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
			/*
			 * String corPt2HemwidthSize =
			 * coAdjustPants2StandardInfo.getCorPt2HemwidthSize(); if
			 * ("".equals(corPt2HemwidthSize) || "0".equals(corPt2HemwidthSize) ||
			 * corPt2HemwidthSize == null) { messages.add("E034", "PANTS（2本目）の裾幅");
			 * pants2Flag = true; }
			 */

			if (BaseCheckUtil.isNotEmpty(sizeFigure) && BaseCheckUtil.isNotEmpty(sizeNumber)) {
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
				String corPt2WaistSize = typeSizeOptimization.getTypeSize();
				adjustPt2StandardValue.put("corPt2WaistSize", corPt2WaistSize);
			}
			// ヒップ
			else if ("05".equals(typeSizeOptimization.getAdjustClass())) {
				String corPt2HipSize = typeSizeOptimization.getTypeSize();
				adjustPt2StandardValue.put("corPt2HipSize", corPt2HipSize);
			}
			// ワタリ修正
			else if ("07".equals(typeSizeOptimization.getAdjustClass())) {
				String corPt2ThighwidthSize = null;
				if ("0000101".equals(pt2TackValue)) {
					corPt2ThighwidthSize = typeSizeOptimization.getTypeSize();
				} else if ("0000102".equals(pt2TackValue)) {
					corPt2ThighwidthSize = typeSizeOptimization.getTypeSize1Outtack();
				} else if ("0000103".equals(pt2TackValue)) {
					corPt2ThighwidthSize = typeSizeOptimization.getTypeSize1Intack();
				} else if ("0000104".equals(pt2TackValue)) {
					corPt2ThighwidthSize = typeSizeOptimization.getTypeSize2Outtack();
				} else if ("0000105".equals(pt2TackValue)) {
					corPt2ThighwidthSize = typeSizeOptimization.getTypeSize2Intack();
				}
				adjustPt2StandardValue.put("corPt2ThighwidthSize", corPt2ThighwidthSize);
			}
			// 裾幅修正
			else if ("08".equals(typeSizeOptimization.getAdjustClass())) {
				String corPt2HemwidthSize = typeSizeOptimization.getTypeSize();
				adjustPt2StandardValue.put("corPt2HemwidthSize", corPt2HemwidthSize);
			}
		}
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
						List<String> stitchModifyList = new ArrayList<String>();
						String op2StitchModifyPlace1 = coOptionPants2StandardInfo.getOp2StitchModifyPlace1();
						stitchModifyList.add(op2StitchModifyPlace1);
						String op2StitchModifyPlace2 = coOptionPants2StandardInfo.getOp2StitchModifyPlace2();
						stitchModifyList.add(op2StitchModifyPlace2);
						String op2StitchModifyPlace3 = coOptionPants2StandardInfo.getOp2StitchModifyPlace3();
						stitchModifyList.add(op2StitchModifyPlace3);
						String op2StitchModifyPlace4 = coOptionPants2StandardInfo.getOp2StitchModifyPlace4();
						stitchModifyList.add(op2StitchModifyPlace4);

						stitchModifyList.removeAll(Collections.singleton(null));
						if (stitchModifyList.isEmpty() || OptionCodeKeys.PT2_0002001.equals(invokeOne)) {
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

					if ("op2_dStitch_id".equals(valueFour)) {
						List<String> stitchModifyList = new ArrayList<String>();
						String op2DStitchPlace1 = coOptionPants2StandardInfo.getOp2DStitchPlace1();
						stitchModifyList.add(op2DStitchPlace1);
						String op2DStitchPlace2 = coOptionPants2StandardInfo.getOp2DStitchPlace2();
						stitchModifyList.add(op2DStitchPlace2);
						String op2DStitchPlace3 = coOptionPants2StandardInfo.getOp2DStitchPlace3();
						stitchModifyList.add(op2DStitchPlace3);
						String op2DStitchPlace4 = coOptionPants2StandardInfo.getOp2DStitchPlace4();
						stitchModifyList.add(op2DStitchPlace4);
						stitchModifyList.removeAll(Collections.singleton(null));
						if (stitchModifyList.isEmpty() || OptionCodeKeys.PT2_0002201.equals(invokeOne)) {
							splicingCodeForFindUniquePrice = code + key + invokeOne;
						} else {
							Integer orderPriceInt = 0;
							for (int i = 0; i < stitchModifyList.size(); i++) {
								String projectPriceCode = code + "00023" + stitchModifyList.get(i);
								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
										orderCoForm);
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
							}
							orderPrice = String.valueOf(orderPriceInt);
						}
					}

					if ("op2_amfColor_id".equals(valueFour)) {
						HashSet<String> amfColorSet = new HashSet<String>();
						String op2AmfColorPlace1 = coOptionPants2StandardInfo.getOp2AmfColorPlace1();
						amfColorSet.add(op2AmfColorPlace1);
						String op2AmfColorPlace2 = coOptionPants2StandardInfo.getOp2AmfColorPlace2();
						amfColorSet.add(op2AmfColorPlace2);
						String op2AmfColorPlace3 = coOptionPants2StandardInfo.getOp2AmfColorPlace3();
						amfColorSet.add(op2AmfColorPlace3);
						String op2AmfColorPlace4 = coOptionPants2StandardInfo.getOp2AmfColorPlace4();
						amfColorSet.add(op2AmfColorPlace4);
						amfColorSet.removeAll(Collections.singleton(null));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						if (OptionCodeKeys.PT2_0002401.equals(invokeOne)
								|| (OptionCodeKeys.PT2_0002402.equals(invokeOne) && amfColorSet.isEmpty())) {
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
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						if (OptionCodeKeys.PT2_0002701.equals(invokeOne)
								|| (OptionCodeKeys.PT2_0002702.equals(invokeOne) && bhColorSet.isEmpty())) {
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
						List<String> byColorList = new ArrayList<String>(byColorSet);
						if (OptionCodeKeys.PT2_0003001.equals(invokeOne)
								|| (OptionCodeKeys.PT2_0003002.equals(invokeOne) && byColorSet.isEmpty())) {
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
					orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice,
							splicingCodeDetail, orderCoForm);
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
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						if (OptionCodeKeys.PT2_0002701.equals(invokeOne)
								|| (OptionCodeKeys.PT2_0002702.equals(invokeOne) && bhColorSet.isEmpty())) {
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
						List<String> byColorList = new ArrayList<String>(byColorSet);
						if (OptionCodeKeys.PT2_0003001.equals(invokeOne)
								|| (OptionCodeKeys.PT2_0003002.equals(invokeOne) && byColorSet.isEmpty())) {
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
					orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice,
							splicingCodeDetail, orderCoForm);
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
						String wp2StitchModifyPlace1 = coOptionPants2WashableInfo.getWp2StitchModifyPlace1();
						stitchModifyList.add(wp2StitchModifyPlace1);
						String wp2StitchModifyPlace2 = coOptionPants2WashableInfo.getWp2StitchModifyPlace2();
						stitchModifyList.add(wp2StitchModifyPlace2);
						String wp2StitchModifyPlace3 = coOptionPants2WashableInfo.getWp2StitchModifyPlace3();
						stitchModifyList.add(wp2StitchModifyPlace3);
						String wp2StitchModifyPlace4 = coOptionPants2WashableInfo.getWp2StitchModifyPlace4();
						stitchModifyList.add(wp2StitchModifyPlace4);

						stitchModifyList.removeAll(Collections.singleton(null));
						if (stitchModifyList.isEmpty() || OptionCodeKeys.PT2_0002001.equals(invokeOne)) {
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

					if ("wp2_dStitch_id".equals(valueFour)) {
						List<String> stitchModifyList = new ArrayList<String>();
						String wp2DStitchPlace1 = coOptionPants2WashableInfo.getWp2DStitchPlace1();
						stitchModifyList.add(wp2DStitchPlace1);
						String wp2DStitchPlace2 = coOptionPants2WashableInfo.getWp2DStitchPlace2();
						stitchModifyList.add(wp2DStitchPlace2);
						String wp2DStitchPlace3 = coOptionPants2WashableInfo.getWp2DStitchPlace3();
						stitchModifyList.add(wp2DStitchPlace3);
						String wp2DStitchPlace4 = coOptionPants2WashableInfo.getWp2DStitchPlace4();
						stitchModifyList.add(wp2DStitchPlace4);
						stitchModifyList.removeAll(Collections.singleton(null));
						if (stitchModifyList.isEmpty() || OptionCodeKeys.PT2_0002201.equals(invokeOne)) {
							splicingCodeForFindUniquePrice = code + key + invokeOne;
						} else {
							Integer orderPriceInt = 0;
							for (int i = 0; i < stitchModifyList.size(); i++) {
								String projectPriceCode = code + "00023" + stitchModifyList.get(i);
								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "",
										orderCoForm);
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
							}
							orderPrice = String.valueOf(orderPriceInt);
						}
					}

					if ("wp2_amfColor_id".equals(valueFour)) {
						HashSet<String> amfColorSet = new HashSet<String>();
						String wp2AmfColorPlace1 = coOptionPants2WashableInfo.getWp2AmfColorPlace1();
						amfColorSet.add(wp2AmfColorPlace1);
						String wp2AmfColorPlace2 = coOptionPants2WashableInfo.getWp2AmfColorPlace2();
						amfColorSet.add(wp2AmfColorPlace2);
						String wp2AmfColorPlace3 = coOptionPants2WashableInfo.getWp2AmfColorPlace3();
						amfColorSet.add(wp2AmfColorPlace3);
						String wp2AmfColorPlace4 = coOptionPants2WashableInfo.getWp2AmfColorPlace4();
						amfColorSet.add(wp2AmfColorPlace4);
						amfColorSet.removeAll(Collections.singleton(null));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						if (OptionCodeKeys.PT2_0002401.equals(invokeOne)
								|| (OptionCodeKeys.PT2_0002402.equals(invokeOne) && amfColorSet.isEmpty())) {
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
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						if (OptionCodeKeys.PT2_0002701.equals(invokeOne)
								|| (OptionCodeKeys.PT2_0002702.equals(invokeOne) && bhColorSet.isEmpty())) {
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
						List<String> byColorList = new ArrayList<String>(byColorSet);
						if (OptionCodeKeys.PT2_0003001.equals(invokeOne)
								|| (OptionCodeKeys.PT2_0003002.equals(invokeOne) && byColorSet.isEmpty())) {
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
					orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice,
							splicingCodeDetail, orderCoForm);
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
}
