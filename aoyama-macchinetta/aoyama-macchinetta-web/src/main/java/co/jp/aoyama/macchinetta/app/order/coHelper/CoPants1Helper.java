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
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsCoOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsCoOptionTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsCoOptionWashablePriceEnum;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Model;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.ModelService;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;

public class CoPants1Helper {

	@Inject
	TypeSizeService typeSizeService;

	CoTypeSizeOptimization coTypeSizeOptimization = new CoTypeSizeOptimization();

	public boolean pantsCheck(ResultMessages messages, OrderCoForm orderCoForm, String productCategory, String item,
			Map<String, List<Adjust>> adjustByItem, TypeSizeService typeSizeService) {
		String corPtHemwidthType = orderCoForm.getCoAdjustPantsStandardInfo().getCorPtHemwidthType();
		String pantsModel="";
		boolean pantsFlag = false;
		// 標準の場合
		if ("9000101".equals(productCategory)) {
			// PANTS モデル未選択の場合
			CoOptionPantsStandardInfo coOptionPantsStandardInfo = orderCoForm.getCoOptionPantsStandardInfo();
			String opPantsModel = coOptionPantsStandardInfo.getOpPantsModel();
			pantsModel=opPantsModel;
			if ("".equals(opPantsModel) || null == opPantsModel) {
				messages.add("E031", "PANTS モデル");
				pantsFlag = true;
			}
			// PANTS ベルトループ
			String opBeltLoop = coOptionPantsStandardInfo.getOpBeltLoop();
			if (OptionCodeKeys.PT_0000701.equals(opBeltLoop)) {
				String opBeltLoopPlace1 = coOptionPantsStandardInfo.getOpBeltLoopPlace1();
				String opBeltLoopPlace2 = coOptionPantsStandardInfo.getOpBeltLoopPlace2();
				String opBeltLoopPlace3 = coOptionPantsStandardInfo.getOpBeltLoopPlace3();
				String opBeltLoopPlace4 = coOptionPantsStandardInfo.getOpBeltLoopPlace4();
				String opBeltLoopPlace5 = coOptionPantsStandardInfo.getOpBeltLoopPlace5();
				String opBeltLoopPlace6 = coOptionPantsStandardInfo.getOpBeltLoopPlace6();
				String opBeltLoopPlace7 = coOptionPantsStandardInfo.getOpBeltLoopPlace7();

				if (BaseCheckUtil.isEmpty(opBeltLoopPlace1) && BaseCheckUtil.isEmpty(opBeltLoopPlace2)
						&& BaseCheckUtil.isEmpty(opBeltLoopPlace3) && BaseCheckUtil.isEmpty(opBeltLoopPlace4)
						&& BaseCheckUtil.isEmpty(opBeltLoopPlace5) && BaseCheckUtil.isEmpty(opBeltLoopPlace6)
						&& !"NZ01".equals(opPantsModel)) {
					messages.add("E033", "PANTS ベルトループ");
					pantsFlag = true;
				}
				if ((BaseCheckUtil.isEmpty(opBeltLoopPlace1) && BaseCheckUtil.isEmpty(opBeltLoopPlace2)
						&& BaseCheckUtil.isEmpty(opBeltLoopPlace3) && BaseCheckUtil.isEmpty(opBeltLoopPlace4)
						&& BaseCheckUtil.isEmpty(opBeltLoopPlace5) && BaseCheckUtil.isEmpty(opBeltLoopPlace6)
						&& BaseCheckUtil.isEmpty(opBeltLoopPlace7) && "NZ01".equals(opPantsModel))) {
					messages.add("E033", "PANTS ベルトループ");
					pantsFlag = true;
				}
			}
			// PANTS ステッチ箇所変更
			String opStitchModify = coOptionPantsStandardInfo.getOpStitchModify();
			if (OptionCodeKeys.PT_0002002.equals(opStitchModify)) {
				String opStitchModifyPlace1 = coOptionPantsStandardInfo.getOpStitchModifyPlace1();
				String opStitchModifyPlace2 = coOptionPantsStandardInfo.getOpStitchModifyPlace2();
				String opStitchModifyPlace3 = coOptionPantsStandardInfo.getOpStitchModifyPlace3();
				String opStitchModifyPlace4 = coOptionPantsStandardInfo.getOpStitchModifyPlace4();

				if (BaseCheckUtil.isEmpty(opStitchModifyPlace1) && BaseCheckUtil.isEmpty(opStitchModifyPlace2)
						&& BaseCheckUtil.isEmpty(opStitchModifyPlace3) && BaseCheckUtil.isEmpty(opStitchModifyPlace4)) {
					messages.add("E033", "PANTS ステッチ箇所変更");
					pantsFlag = true;
				}
			}
			// PANTS ダブルステッチ
			String opDStitch = coOptionPantsStandardInfo.getOpDStitch();
			if (OptionCodeKeys.PT_0002202.equals(opDStitch)) {
				String opDStitchPlace1 = coOptionPantsStandardInfo.getOpDStitchPlace1();
				String opDStitchPlace2 = coOptionPantsStandardInfo.getOpDStitchPlace2();
				String opDStitchPlace3 = coOptionPantsStandardInfo.getOpDStitchPlace3();

				if (BaseCheckUtil.isEmpty(opDStitchPlace1) && BaseCheckUtil.isEmpty(opDStitchPlace2)
						&& BaseCheckUtil.isEmpty(opDStitchPlace3)) {
					messages.add("E033", "PANTS ダブルステッチ");
					pantsFlag = true;
				}
			}
			// PANTS AMF色指定
			String opAmfColor = coOptionPantsStandardInfo.getOpAmfColor();
			if (OptionCodeKeys.PT_0002402.equals(opAmfColor)) {
				String opAmfColorPlace1 = coOptionPantsStandardInfo.getOpAmfColorPlace1();
				String opAmfColorPlace2 = coOptionPantsStandardInfo.getOpAmfColorPlace2();
				String opAmfColorPlace3 = coOptionPantsStandardInfo.getOpAmfColorPlace3();
				String opAmfColorPlace4 = coOptionPantsStandardInfo.getOpAmfColorPlace4();

				String opAmfColor1 = coOptionPantsStandardInfo.getOpAmfColor1();
				String opAmfColor2 = coOptionPantsStandardInfo.getOpAmfColor2();
				String opAmfColor3 = coOptionPantsStandardInfo.getOpAmfColor3();
				String opAmfColor4 = coOptionPantsStandardInfo.getOpAmfColor4();
				if (BaseCheckUtil.isEmpty(opAmfColorPlace1) && BaseCheckUtil.isEmpty(opAmfColorPlace2)
						&& BaseCheckUtil.isEmpty(opAmfColorPlace3) && BaseCheckUtil.isEmpty(opAmfColorPlace4)) {
					messages.add("E032", "PANTS AMF色指定");
					pantsFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(opAmfColorPlace1) && BaseCheckUtil.isEmpty(opAmfColor1)
						|| BaseCheckUtil.isNotEmpty(opAmfColorPlace2) && BaseCheckUtil.isEmpty(opAmfColor2)
						|| BaseCheckUtil.isNotEmpty(opAmfColorPlace3) && BaseCheckUtil.isEmpty(opAmfColor3)
						|| BaseCheckUtil.isNotEmpty(opAmfColorPlace4) && BaseCheckUtil.isEmpty(opAmfColor4)) {
					messages.add("E032", "PANTS AMF色指定");
					pantsFlag = true;
				}
			}
			// ボタンホール色指定
			String opBhColor = coOptionPantsStandardInfo.getOpBhColor();
			if (OptionCodeKeys.PT_0002702.equals(opBhColor)) {
				String opBhColorPlace1 = coOptionPantsStandardInfo.getOpBhColorPlace1();
				String opBhColorPlace2 = coOptionPantsStandardInfo.getOpBhColorPlace2();
				String opBhColorPlace3 = coOptionPantsStandardInfo.getOpBhColorPlace3();
				String opBhColorPlace4 = coOptionPantsStandardInfo.getOpBhColorPlace4();

				String opBhColor1 = coOptionPantsStandardInfo.getOpBhColor1();
				String opBhColor2 = coOptionPantsStandardInfo.getOpBhColor2();
				String opBhColor3 = coOptionPantsStandardInfo.getOpBhColor3();
				String opBhColor4 = coOptionPantsStandardInfo.getOpBhColor4();

				if (BaseCheckUtil.isEmpty(opBhColorPlace1) && BaseCheckUtil.isEmpty(opBhColorPlace2)
						&& BaseCheckUtil.isEmpty(opBhColorPlace3) && BaseCheckUtil.isEmpty(opBhColorPlace4)) {
					messages.add("E032", "PANTS ボタンホール色指定");
					pantsFlag = true;
				}

				if (BaseCheckUtil.isNotEmpty(opBhColorPlace1) && BaseCheckUtil.isEmpty(opBhColor1)
						|| BaseCheckUtil.isNotEmpty(opBhColorPlace2) && BaseCheckUtil.isEmpty(opBhColor2)
						|| BaseCheckUtil.isNotEmpty(opBhColorPlace3) && BaseCheckUtil.isEmpty(opBhColor3)
						|| BaseCheckUtil.isNotEmpty(opBhColorPlace4) && BaseCheckUtil.isEmpty(opBhColor4)) {
					messages.add("E032", "PANTS ボタンホール色指定");
					pantsFlag = true;
				}
			}

			// ボタン付け糸指定
			String opByColor = coOptionPantsStandardInfo.getOpByColor();
			if (OptionCodeKeys.PT_0003002.equals(opByColor)) {
				String opByColorPlace1 = coOptionPantsStandardInfo.getOpByColorPlace1();
				String opByColorPlace2 = coOptionPantsStandardInfo.getOpByColorPlace2();
				String opByColorPlace3 = coOptionPantsStandardInfo.getOpByColorPlace3();
				String opByColorPlace4 = coOptionPantsStandardInfo.getOpByColorPlace4();

				String opByColor1 = coOptionPantsStandardInfo.getOpByColor1();
				String opByColor2 = coOptionPantsStandardInfo.getOpByColor2();
				String opByColor3 = coOptionPantsStandardInfo.getOpByColor3();
				String opByColor4 = coOptionPantsStandardInfo.getOpByColor4();
				if (BaseCheckUtil.isEmpty(opByColorPlace1) && BaseCheckUtil.isEmpty(opByColorPlace2)
						&& BaseCheckUtil.isEmpty(opByColorPlace3) && BaseCheckUtil.isEmpty(opByColorPlace4)) {
					messages.add("E032", "PANTS ボタン付け糸指定");
					pantsFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(opByColorPlace1) && BaseCheckUtil.isEmpty(opByColor1)
						|| BaseCheckUtil.isNotEmpty(opByColorPlace2) && BaseCheckUtil.isEmpty(opByColor2)
						|| BaseCheckUtil.isNotEmpty(opByColorPlace3) && BaseCheckUtil.isEmpty(opByColor3)
						|| BaseCheckUtil.isNotEmpty(opByColorPlace4) && BaseCheckUtil.isEmpty(opByColor4)) {
					messages.add("E032", "PANTS ボタン付け糸指定");
					pantsFlag = true;
				}
			}
			// PANTS タキシードの場合
		} else if ("9000102".equals(productCategory)) {
			// PANTS モデル未選択の場合
			CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo = orderCoForm.getCoOptionPantsTuxedoInfo();
			String tpPantsModel = coOptionPantsTuxedoInfo.getTpPantsModel();
			pantsModel=tpPantsModel;
			if ("".equals(tpPantsModel) || null == tpPantsModel) {
				messages.add("E031", "PANTS モデル");
				pantsFlag = true;
			}
			// PANTS ベルトループ
			String tpBeltLoop = coOptionPantsTuxedoInfo.getTpBeltLoop();
			if (OptionCodeKeys.PT_0000701.equals(tpBeltLoop)) {
				String tpBeltLoopPlace1 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace1();
				String tpBeltLoopPlace2 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace2();
				String tpBeltLoopPlace3 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace3();
				String tpBeltLoopPlace4 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace4();
				String tpBeltLoopPlace5 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace5();
				String tpBeltLoopPlace6 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace6();
				String tpBeltLoopPlace7 = coOptionPantsTuxedoInfo.getTpBeltLoopPlace7();

				if (BaseCheckUtil.isEmpty(tpBeltLoopPlace1) && BaseCheckUtil.isEmpty(tpBeltLoopPlace2)
						&& BaseCheckUtil.isEmpty(tpBeltLoopPlace3) && BaseCheckUtil.isEmpty(tpBeltLoopPlace4)
						&& BaseCheckUtil.isEmpty(tpBeltLoopPlace5) && BaseCheckUtil.isEmpty(tpBeltLoopPlace6)
						&& !"NZ01".equals(tpPantsModel)) {
					messages.add("E033", "PANTS ベルトループ");
					pantsFlag = true;
				}

				if (BaseCheckUtil.isEmpty(tpBeltLoopPlace1) && BaseCheckUtil.isEmpty(tpBeltLoopPlace2)
						&& BaseCheckUtil.isEmpty(tpBeltLoopPlace3) && BaseCheckUtil.isEmpty(tpBeltLoopPlace4)
						&& BaseCheckUtil.isEmpty(tpBeltLoopPlace5) && BaseCheckUtil.isEmpty(tpBeltLoopPlace6)
						&& BaseCheckUtil.isEmpty(tpBeltLoopPlace7) && "NZ01".equals(tpPantsModel)) {
					messages.add("E033", "PANTS ベルトループ");
					pantsFlag = true;
				}
			}

			// PANTS ボタンホール色指定
			String opBhColor = coOptionPantsTuxedoInfo.getTpBhColor();
			if (OptionCodeKeys.PT_0002702.equals(opBhColor)) {
				String tpBhColorPlace1 = coOptionPantsTuxedoInfo.getTpBhColorPlace1();
				String tpBhColorPlace2 = coOptionPantsTuxedoInfo.getTpBhColorPlace2();
				String tpBhColorPlace3 = coOptionPantsTuxedoInfo.getTpBhColorPlace3();
				String tpBhColorPlace4 = coOptionPantsTuxedoInfo.getTpBhColorPlace4();

				String tpBhColor1 = coOptionPantsTuxedoInfo.getTpBhColor1();
				String tpBhColor2 = coOptionPantsTuxedoInfo.getTpBhColor2();
				String tpBhColor3 = coOptionPantsTuxedoInfo.getTpBhColor3();
				String tpBhColor4 = coOptionPantsTuxedoInfo.getTpBhColor4();

				if (BaseCheckUtil.isEmpty(tpBhColorPlace1) && BaseCheckUtil.isEmpty(tpBhColorPlace2)
						&& BaseCheckUtil.isEmpty(tpBhColorPlace3) && BaseCheckUtil.isEmpty(tpBhColorPlace4)) {
					messages.add("E032", "PANTS ボタンホール色指定");
					pantsFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(tpBhColorPlace1) && BaseCheckUtil.isEmpty(tpBhColor1)
						|| BaseCheckUtil.isNotEmpty(tpBhColorPlace2) && BaseCheckUtil.isEmpty(tpBhColor2)
						|| BaseCheckUtil.isNotEmpty(tpBhColorPlace3) && BaseCheckUtil.isEmpty(tpBhColor3)
						|| BaseCheckUtil.isNotEmpty(tpBhColorPlace4) && BaseCheckUtil.isEmpty(tpBhColor4)) {
					messages.add("E032", "PANTS ボタンホール色指定");
					pantsFlag = true;
				}
			}
			// ボタン付け糸指定
			String tpByColor = coOptionPantsTuxedoInfo.getTpByColor();
			if (OptionCodeKeys.PT_0003002.equals(tpByColor)) {
				String tpByColorPlace1 = coOptionPantsTuxedoInfo.getTpByColorPlace1();
				String tpByColorPlace2 = coOptionPantsTuxedoInfo.getTpByColorPlace2();
				String tpByColorPlace3 = coOptionPantsTuxedoInfo.getTpByColorPlace3();
				String tpByColorPlace4 = coOptionPantsTuxedoInfo.getTpByColorPlace4();

				String tpByColor1 = coOptionPantsTuxedoInfo.getTpByColor1();
				String tpByColor2 = coOptionPantsTuxedoInfo.getTpByColor2();
				String tpByColor3 = coOptionPantsTuxedoInfo.getTpByColor3();
				String tpByColor4 = coOptionPantsTuxedoInfo.getTpByColor4();

				if (BaseCheckUtil.isEmpty(tpByColorPlace1) && BaseCheckUtil.isEmpty(tpByColorPlace2)
						&& BaseCheckUtil.isEmpty(tpByColorPlace3) && BaseCheckUtil.isEmpty(tpByColorPlace4)) {
					messages.add("E032", "PANTS ボタン付け糸指定");
					pantsFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(tpByColorPlace1) && BaseCheckUtil.isEmpty(tpByColor1)
						|| BaseCheckUtil.isNotEmpty(tpByColorPlace2) && BaseCheckUtil.isEmpty(tpByColor2)
						|| BaseCheckUtil.isNotEmpty(tpByColorPlace3) && BaseCheckUtil.isEmpty(tpByColor3)
						|| BaseCheckUtil.isNotEmpty(tpByColorPlace4) && BaseCheckUtil.isEmpty(tpByColor4)) {
					messages.add("E032", "PANTS ボタン付け糸指定");
					pantsFlag = true;
				}
			}
		} else if ("9000103".equals(productCategory)) {
			// PANTS モデル未選択の場合
			CoOptionPantsWashableInfo coOptionPantsWashableInfo = orderCoForm.getCoOptionPantsWashableInfo();
			String wpPantsModel = coOptionPantsWashableInfo.getWpPantsModel();
			pantsModel=wpPantsModel;
			if ("".equals(wpPantsModel) || null == wpPantsModel) {
				messages.add("E031", "PANTS モデル");
				pantsFlag = true;
			}

			// PANTS ベルトループ
			String wpBeltLoop = coOptionPantsWashableInfo.getWpBeltLoop();
			if (OptionCodeKeys.PT_0000701.equals(wpBeltLoop)) {
				String wpBeltLoopPlace1 = coOptionPantsWashableInfo.getWpBeltLoopPlace1();
				String wpBeltLoopPlace2 = coOptionPantsWashableInfo.getWpBeltLoopPlace2();
				String wpBeltLoopPlace3 = coOptionPantsWashableInfo.getWpBeltLoopPlace3();
				String wpBeltLoopPlace4 = coOptionPantsWashableInfo.getWpBeltLoopPlace4();
				String wpBeltLoopPlace5 = coOptionPantsWashableInfo.getWpBeltLoopPlace5();
				String wpBeltLoopPlace6 = coOptionPantsWashableInfo.getWpBeltLoopPlace6();
				String wpBeltLoopPlace7 = coOptionPantsWashableInfo.getWpBeltLoopPlace7();

				if (BaseCheckUtil.isEmpty(wpBeltLoopPlace1) && BaseCheckUtil.isEmpty(wpBeltLoopPlace2)
						&& BaseCheckUtil.isEmpty(wpBeltLoopPlace3) && BaseCheckUtil.isEmpty(wpBeltLoopPlace4)
						&& BaseCheckUtil.isEmpty(wpBeltLoopPlace5) && BaseCheckUtil.isEmpty(wpBeltLoopPlace6)
						&& !"NZ01".equals(wpPantsModel)) {
					messages.add("E033", "PANTS ベルトループ");
					pantsFlag = true;
				}

				if (BaseCheckUtil.isEmpty(wpBeltLoopPlace1) && BaseCheckUtil.isEmpty(wpBeltLoopPlace2)
						&& BaseCheckUtil.isEmpty(wpBeltLoopPlace3) && BaseCheckUtil.isEmpty(wpBeltLoopPlace4)
						&& BaseCheckUtil.isEmpty(wpBeltLoopPlace5) && BaseCheckUtil.isEmpty(wpBeltLoopPlace6)
						&& BaseCheckUtil.isEmpty(wpBeltLoopPlace7) && "NZ01".equals(wpPantsModel)) {
					messages.add("E033", "PANTS ベルトループ");
					pantsFlag = true;
				}
			}
			// PANTS ステッチ箇所変更
			String wpStitchModify = coOptionPantsWashableInfo.getWpStitchModify();
			if (OptionCodeKeys.PT_0002002.equals(wpStitchModify)) {
				String wpStitchModifyPlace1 = coOptionPantsWashableInfo.getWpStitchModifyPlace1();
				String wpStitchModifyPlace2 = coOptionPantsWashableInfo.getWpStitchModifyPlace2();
				String wpStitchModifyPlace3 = coOptionPantsWashableInfo.getWpStitchModifyPlace3();
				String wpStitchModifyPlace4 = coOptionPantsWashableInfo.getWpStitchModifyPlace4();
				if (BaseCheckUtil.isEmpty(wpStitchModifyPlace1) && BaseCheckUtil.isEmpty(wpStitchModifyPlace2)
						&& BaseCheckUtil.isEmpty(wpStitchModifyPlace3) && BaseCheckUtil.isEmpty(wpStitchModifyPlace4)) {
					messages.add("E033", "PANTS ステッチ箇所変更");
					pantsFlag = true;
				}
			}
			// PANTS ダブルステッチ
			String wpDStitch = coOptionPantsWashableInfo.getWpDStitch();
			if (OptionCodeKeys.PT_0002202.equals(wpDStitch)) {
				String wpDStitchPlace1 = coOptionPantsWashableInfo.getWpDStitchPlace1();
				String wpDStitchPlace2 = coOptionPantsWashableInfo.getWpDStitchPlace2();
				String wpDStitchPlace3 = coOptionPantsWashableInfo.getWpDStitchPlace3();
				if (BaseCheckUtil.isEmpty(wpDStitchPlace1) && BaseCheckUtil.isEmpty(wpDStitchPlace2)
						&& BaseCheckUtil.isEmpty(wpDStitchPlace3)) {
					messages.add("E033", "PANTS ダブルステッチ");
					pantsFlag = true;
				}
			}

			// PANTS AMF色指定
			String wpamfColor = coOptionPantsWashableInfo.getWpAmfColor();
			if (OptionCodeKeys.PT_0002402.equals(wpamfColor)) {
				String wpamfColorPlace1 = coOptionPantsWashableInfo.getWpAmfColorPlace1();
				String wpamfColorPlace2 = coOptionPantsWashableInfo.getWpAmfColorPlace2();
				String wpamfColorPlace3 = coOptionPantsWashableInfo.getWpAmfColorPlace3();
				String wpamfColorPlace4 = coOptionPantsWashableInfo.getWpAmfColorPlace4();

				String wpamfColor1 = coOptionPantsWashableInfo.getWpAmfColor1();
				String wpamfColor2 = coOptionPantsWashableInfo.getWpAmfColor2();
				String wpamfColor3 = coOptionPantsWashableInfo.getWpAmfColor3();
				String wpamfColor4 = coOptionPantsWashableInfo.getWpAmfColor4();

				if (BaseCheckUtil.isEmpty(wpamfColorPlace1) && BaseCheckUtil.isEmpty(wpamfColorPlace2)
						&& BaseCheckUtil.isEmpty(wpamfColorPlace3) && BaseCheckUtil.isEmpty(wpamfColorPlace4)) {
					messages.add("E032", "PANTS AMF色指定");
					pantsFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(wpamfColorPlace1) && BaseCheckUtil.isEmpty(wpamfColor1)
						|| BaseCheckUtil.isNotEmpty(wpamfColorPlace2) && BaseCheckUtil.isEmpty(wpamfColor2)
						|| BaseCheckUtil.isNotEmpty(wpamfColorPlace3) && BaseCheckUtil.isEmpty(wpamfColor3)
						|| BaseCheckUtil.isNotEmpty(wpamfColorPlace4) && BaseCheckUtil.isEmpty(wpamfColor4)) {
					messages.add("E032", "PANTS AMF色指定");
					pantsFlag = true;
				}
			}

			// PANTS ボタンホール色指定
			String wpBhColor = coOptionPantsWashableInfo.getWpBhColor();
			if (OptionCodeKeys.PT_0002702.equals(wpBhColor)) {
				String wpBhColorPlace1 = coOptionPantsWashableInfo.getWpBhColorPlace1();
				String wpBhColorPlace2 = coOptionPantsWashableInfo.getWpBhColorPlace2();
				String wpBhColorPlace3 = coOptionPantsWashableInfo.getWpBhColorPlace3();
				String wpBhColorPlace4 = coOptionPantsWashableInfo.getWpBhColorPlace4();

				String wpBhColor1 = coOptionPantsWashableInfo.getWpBhColor1();
				String wpBhColor2 = coOptionPantsWashableInfo.getWpBhColor2();
				String wpBhColor3 = coOptionPantsWashableInfo.getWpBhColor3();
				String wpBhColor4 = coOptionPantsWashableInfo.getWpBhColor4();

				if (BaseCheckUtil.isEmpty(wpBhColorPlace1) && BaseCheckUtil.isEmpty(wpBhColorPlace2)
						&& BaseCheckUtil.isEmpty(wpBhColorPlace3) && BaseCheckUtil.isEmpty(wpBhColorPlace4)) {
					messages.add("E032", "PANTS ボタンホール色指定");
					pantsFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(wpBhColorPlace1) && BaseCheckUtil.isEmpty(wpBhColor1)
						|| BaseCheckUtil.isNotEmpty(wpBhColorPlace2) && BaseCheckUtil.isEmpty(wpBhColor2)
						|| BaseCheckUtil.isNotEmpty(wpBhColorPlace3) && BaseCheckUtil.isEmpty(wpBhColor3)
						|| BaseCheckUtil.isNotEmpty(wpBhColorPlace4) && BaseCheckUtil.isEmpty(wpBhColor4)) {
					messages.add("E032", "PANTS ボタンホール色指定");
					pantsFlag = true;
				}
			}

			// ボタン付け糸指定
			String wpByColor = coOptionPantsWashableInfo.getWpByColor();
			if (OptionCodeKeys.PT_0003002.equals(wpByColor)) {
				String wpByColorPlace1 = coOptionPantsWashableInfo.getWpByColorPlace1();
				String wpByColorPlace2 = coOptionPantsWashableInfo.getWpByColorPlace2();
				String wpByColorPlace3 = coOptionPantsWashableInfo.getWpByColorPlace3();
				String wpByColorPlace4 = coOptionPantsWashableInfo.getWpByColorPlace4();

				String wpByColor1 = coOptionPantsWashableInfo.getWpByColor1();
				String wpByColor2 = coOptionPantsWashableInfo.getWpByColor2();
				String wpByColor3 = coOptionPantsWashableInfo.getWpByColor3();
				String wpByColor4 = coOptionPantsWashableInfo.getWpByColor4();

				if (BaseCheckUtil.isEmpty(wpByColorPlace1) && BaseCheckUtil.isEmpty(wpByColorPlace2)
						&& BaseCheckUtil.isEmpty(wpByColorPlace3) && BaseCheckUtil.isEmpty(wpByColorPlace4)) {
					messages.add("E032", "PANTS  ボタン付け糸指定");
					pantsFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(wpByColorPlace1) && BaseCheckUtil.isEmpty(wpByColor1)
						|| BaseCheckUtil.isNotEmpty(wpByColorPlace2) && BaseCheckUtil.isEmpty(wpByColor2)
						|| BaseCheckUtil.isNotEmpty(wpByColorPlace3) && BaseCheckUtil.isEmpty(wpByColor3)
						|| BaseCheckUtil.isNotEmpty(wpByColorPlace4) && BaseCheckUtil.isEmpty(wpByColor4)) {
					messages.add("E032", "PANTS  ボタン付け糸指定");
					pantsFlag = true;
				}
			}
		}

		// 補正
		CoAdjustPantsStandardInfo coAdjustPantsStandardInfo = orderCoForm.getCoAdjustPantsStandardInfo();
		if (coAdjustPantsStandardInfo == null) {
			messages.add("E031", "PANTSサイズ");
			pantsFlag = true;
		} else {
			if(!"".equals(pantsModel) || null != pantsModel) {
				if("RS01".equals(pantsModel) || "JW21".equals(pantsModel) || "AY01".equals(pantsModel)) {
					
				}else {
					String sizeFigure = coAdjustPantsStandardInfo.getSizeFigure();
					if ("".equals(sizeFigure) || null == sizeFigure) {
						messages.add("E031", "PANTSサイズ体型");
						pantsFlag = true;
					}
				}
			}
			String sizeNumber = coAdjustPantsStandardInfo.getSizeNumber();
			if ("".equals(sizeNumber) || null == sizeNumber) {
				messages.add("E031", "PANTSサイズ号数");
				pantsFlag = true;
			}
			String corPtLeftinseamGross = coAdjustPantsStandardInfo.getCorPtLeftinseamGross();

			boolean falg = BaseCheckUtil.GrossCompareTo(corPtLeftinseamGross, messages, "PANTS（1本目）左股下");
			if (falg) {
				pantsFlag = true;
			}
			String corPtRightinseamGross = coAdjustPantsStandardInfo.getCorPtRightinseamGross();
			falg = BaseCheckUtil.GrossCompareTo(corPtRightinseamGross, messages, "PANTS（1本目）右股下");
			if (falg) {
				pantsFlag = true;
			}

			if (BaseCheckUtil.isNotEmpty(sizeNumber)) {
				String corPtWaistSize = coAdjustPantsStandardInfo.getCorPtWaistSize();
				if ("".equals(corPtWaistSize) || "0".equals(corPtWaistSize) || corPtWaistSize == null) {
					messages.add("E034", "PANTS（1本目）のウエスト修正");
					pantsFlag = true;
				}

				String corPtHipSize = coAdjustPantsStandardInfo.getCorPtHipSize();
				if ("".equals(corPtHipSize) || "0".equals(corPtHipSize) || corPtHipSize == null) {
					messages.add("E034", "PANTS（1本目）のヒップ修正");
					pantsFlag = true;
				}

				String corPtThighSize = coAdjustPantsStandardInfo.getCorPtThighSize();
				if ("".equals(corPtThighSize) || "0".equals(corPtThighSize) || corPtThighSize == null) {
					messages.add("E034", "PANTS（1本目）のワタリ幅修正");
					pantsFlag = true;
				}
				String corPtHemwidthType2 = coAdjustPantsStandardInfo.getCorPtHemwidthType();
				if ("".equals(corPtHemwidthType2) || "0".equals(corPtHemwidthType2) || corPtHemwidthType2 == null) {
					messages.add("E034", "PANTS（1本目）の裾幅");
					pantsFlag = true;	
				}else {
					if("1".equals(corPtHemwidthType2)) {
						String corPt2HemwidthSize = coAdjustPantsStandardInfo.getCorPtHemwidthSize();
						if ("".equals(corPt2HemwidthSize) || "0".equals(corPt2HemwidthSize) || corPt2HemwidthSize == null) {
							messages.add("E034", "PANTS（1本目）の裾幅");
							pantsFlag = true;
						}
					}else if("2".equals(corPtHemwidthType2)) {
						String corPt2HemwidthDegignate = coAdjustPantsStandardInfo.getCorPtHemwidthDegignate();
						if ("".equals(corPt2HemwidthDegignate) || "0".equals(corPt2HemwidthDegignate) || corPt2HemwidthDegignate == null) {
							messages.add("E034", "PANTS（1本目）の裾幅");
							pantsFlag = true;
						}
					}
				}

				/*
				 * String corPtHemwidthSize = coAdjustPantsStandardInfo.getCorPtHemwidthSize();
				 * if ("".equals(corPtHemwidthSize) || "0".equals(corPtHemwidthSize) ||
				 * corPtHemwidthSize == null) { messages.add("E034", "PANTS（1本目）の裾幅");
				 * pantsFlag = true; }
				 */

				List<TypeSizeOptimization> coPtTypeSizeOptimization = getCoPtTypeSizeOptimization(orderCoForm,
						typeSizeService);
				List<Adjust> ptAdjustList = adjustByItem.get("03");
				if (!ptAdjustList.isEmpty() && !coPtTypeSizeOptimization.isEmpty()) {
					for (Adjust adjust : ptAdjustList) {
						Map<String, String> ptStandardValue = getPtStandardValue(orderCoForm, coPtTypeSizeOptimization);
						// PANTS_ウエスト_型サイズ
						String stringCorPtWaistSize = ptStandardValue.get("corPtWaistSize");
						BigDecimal corPtWaistlengthSize = new BigDecimal(stringCorPtWaistSize);

						// PANTS_ヒップ_型サイズ
						String stringCorPtHipSize = ptStandardValue.get("corPtHipSize");
						BigDecimal corPtHiplengthSize = new BigDecimal(stringCorPtHipSize);

						// PANTS_ワタリ_型サイズ
						String stringCorPtThighwidthSize = ptStandardValue.get("corPtThighwidthSize");
						BigDecimal corPtThighlengthSize = new BigDecimal(stringCorPtThighwidthSize);

						// PANTS_裾幅_修正_型サイズ
						String stringCorPtHemwidthSize = ptStandardValue.get("corPtHemwidthSize");
						BigDecimal corPtHemlengthSize = new BigDecimal(stringCorPtHemwidthSize);

						// PANTS_ウエスト_グロス
						BigDecimal corPtWaistGross = new BigDecimal(coAdjustPantsStandardInfo.getCorPtWaistGross());

						// PANTS_ヒップ_グロス
						BigDecimal corPtHipGross = new BigDecimal(coAdjustPantsStandardInfo.getCorPtHipGross());

						// PANTS_ワタリ_グロス
						BigDecimal corPtThighwidthGross = new BigDecimal(
								coAdjustPantsStandardInfo.getCorPtThighGross());

						// PANTS_裾幅_修正_グロス
						BigDecimal corPtHemwidthGross = null;
						if ("1".equals(corPtHemwidthType)) {
							corPtHemwidthGross = new BigDecimal(coAdjustPantsStandardInfo.getCorPtHemwidthGross());
						}
						if (item.equals(adjust.getItemCode())) {
							if ("03".equals(adjust.getSubItemCode())) {
								// ウエスト修正
								if ("06".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corPtWaistlengthSize);
									BigDecimal addMax = adjusteMax.add(corPtWaistlengthSize);
									if (corPtWaistGross.compareTo(addMin) == -1
											|| corPtWaistGross.compareTo(addMax) == 1) {
										messages.add("E035", "PANTS（1本目）のウエスト修正");
										pantsFlag = true;
									}
								}
								// ヒップ修正
								if ("05".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corPtHiplengthSize);
									BigDecimal addMax = adjusteMax.add(corPtHiplengthSize);
									if (corPtHipGross.compareTo(addMin) == -1 || corPtHipGross.compareTo(addMax) == 1) {
										messages.add("E035", "PANTS（1本目）のヒップ修正");
										pantsFlag = true;
									}
								}
								// ワタリ修正
								if ("07".equals(adjust.getAdjusteClass())) {
									BigDecimal adjusteMax = adjust.getAdjusteMax();
									BigDecimal adjusteMin = adjust.getAdjusteMin();
									BigDecimal addMin = adjusteMin.add(corPtThighlengthSize);
									BigDecimal addMax = adjusteMax.add(corPtThighlengthSize);
									if (corPtThighwidthGross.compareTo(addMin) == -1
											|| corPtThighwidthGross.compareTo(addMax) == 1) {
										messages.add("E035", "PANTS（1本目）のワタリ修正");
										pantsFlag = true;
									}
								}
								if ("1".equals(corPtHemwidthType)) {
									// 裾幅修正
									if ("08".equals(adjust.getAdjusteClass())) {
										BigDecimal adjusteMax = adjust.getAdjusteMax();
										BigDecimal adjusteMin = adjust.getAdjusteMin();
										BigDecimal addMin = adjusteMin.add(corPtHemlengthSize);
										BigDecimal addMax = adjusteMax.add(corPtHemlengthSize);
										if (corPtHemwidthGross.compareTo(addMin) == -1
												|| corPtHemwidthGross.compareTo(addMax) == 1) {
											messages.add("E035", "PANTS（1本目）の裾幅修正");
											pantsFlag = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return pantsFlag;
	}

	/**
	 * PANTSの標準値取得
	 * 
	 * @param orderCoForm
	 * @return
	 */
	private List<TypeSizeOptimization> getCoPtTypeSizeOptimization(OrderCoForm orderCoForm,
			TypeSizeService typeSizeService) {
		String orderPattern = orderCoForm.getOrderPattern();
		String productCategory = orderCoForm.getProductCategory();
		String subItemCode = "03";
		String modelCode = null;
		if ("9000101".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPantsStandardInfo().getOpPantsModel();
		} else if ("9000102".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPantsTuxedoInfo().getTpPantsModel();
		} else if ("9000103".equals(productCategory)) {
			modelCode = orderCoForm.getCoOptionPantsWashableInfo().getWpPantsModel();
		}

		String figure = orderCoForm.getCoAdjustPantsStandardInfo().getSizeFigure();
		String number = orderCoForm.getCoAdjustPantsStandardInfo().getSizeNumber();
		List<TypeSize> coTypeSizeList = typeSizeService.getPoTypeSizeOptimization(orderPattern, subItemCode, modelCode,
				figure, number);
		List<TypeSizeOptimization> coPtTypeSizeOptimization = coTypeSizeOptimization.getCoTypeSizeOptimization(coTypeSizeList);
		return coPtTypeSizeOptimization;
	}

	/**
	 * PANTSの補正標準値
	 * 
	 * @param coJkTypeSizeOptimization
	 * @return
	 */
	private Map<String, String> getPtStandardValue(OrderCoForm orderCoForm,
			List<TypeSizeOptimization> coPtTypeSizeOptimization) {
		Map<String, String> adjustPtStandardValue = new HashMap<String, String>();
		String productCategory = orderCoForm.getProductCategory();
		String ptTackValue = null;
		if ("9000101".equals(productCategory)) {
			ptTackValue = orderCoForm.getCoOptionPantsStandardInfo().getOpTack();
		} else if ("9000102".equals(productCategory)) {
			ptTackValue = orderCoForm.getCoOptionPantsTuxedoInfo().getTpTack();
		} else if ("9000103".equals(productCategory)) {
			ptTackValue = orderCoForm.getCoOptionPantsWashableInfo().getWpTack();
		}

		for (TypeSizeOptimization typeSizeOptimization : coPtTypeSizeOptimization) {
			// ウエスト修正
			if ("06".equals(typeSizeOptimization.getAdjustClass())) {
				String corPtWaistSize = "corPtWaistSize";
				adjustPtStandardValue =getPtStandardValueByptTackValue(ptTackValue,adjustPtStandardValue,corPtWaistSize,typeSizeOptimization);
			}
			// ヒップ
			else if ("05".equals(typeSizeOptimization.getAdjustClass())) {
				String corPtHipSize = "corPtHipSize";
				adjustPtStandardValue =getPtStandardValueByptTackValue(ptTackValue,adjustPtStandardValue,corPtHipSize,typeSizeOptimization);
			}
			// ワタリ修正
			else if ("07".equals(typeSizeOptimization.getAdjustClass())) {
				String corPtThighwidthSize = "corPtThighwidthSize";
				adjustPtStandardValue =getPtStandardValueByptTackValue(ptTackValue,adjustPtStandardValue,corPtThighwidthSize,typeSizeOptimization);
			}
			// 裾幅修正
			else if ("08".equals(typeSizeOptimization.getAdjustClass())) {
				String corPtHemwidthSize = "corPtHemwidthSize";
				adjustPtStandardValue =getPtStandardValueByptTackValue(ptTackValue,adjustPtStandardValue,corPtHemwidthSize,typeSizeOptimization);
			}
		}
		return adjustPtStandardValue;
	}
	
	public Map<String, String> getPtStandardValueByptTackValue(String ptTackValue,Map<String, String> adjustPtStandardValue,String val,
			TypeSizeOptimization typeSizeOptimization){
		String value="";
		if ("0000101".equals(ptTackValue)) {
			value = typeSizeOptimization.getTypeSize();
		} else if ("0000102".equals(ptTackValue)) {
			value = typeSizeOptimization.getTypeSize1Outtack();
		} else if ("0000103".equals(ptTackValue)) {
			value = typeSizeOptimization.getTypeSize1Intack();
		} else if ("0000104".equals(ptTackValue)) {
			value = typeSizeOptimization.getTypeSize2Outtack();
		} else if ("0000105".equals(ptTackValue)) {
			value = typeSizeOptimization.getTypeSize2Intack();
		}
		adjustPtStandardValue.put(val, value);
		return adjustPtStandardValue;
	}
	

	public Map<String, Object> getOrderPriceForPantsModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionPantsStandardInfo coOptionPantsStandardInfo =orderCoForm.getCoOptionPantsStandardInfo();
		PantsCoOptionStandardPriceEnum[] priceEnum = PantsCoOptionStandardPriceEnum.values();
		String opStitch = coOptionPantsStandardInfo.getOpStitch();
		for (PantsCoOptionStandardPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueFour = price.getValueFour();
			String valueThree = price.getValueThree();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionPantsStandardInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPantsStandardInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPantsStandardInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPantsStandardInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if( "op_stitchModify_id".equals(valueFour)) {
						
						//PT_0005001:無し
						if(OptionCodeKeys.PT_0005101.equals(opStitch)) {
							coOptionPantsStandardInfo.setOpStitchModify(OptionCodeKeys.PT_0002001);
							coOptionPantsStandardInfo.setOpStitchModifyPlace(null);
							coOptionPantsStandardInfo.setOpStitchModifyPlace1(null);
							coOptionPantsStandardInfo.setOpStitchModifyPlace2(null);
							coOptionPantsStandardInfo.setOpStitchModifyPlace3(null);
							coOptionPantsStandardInfo.setOpStitchModifyPlace4(null);
							splicingCodeForFindUniquePrice = code + key + OptionCodeKeys.PT_0002001;
						}else {
							List<String> stitchModifyList = new ArrayList<String>();
							String opStitchModifyPlace1 = coOptionPantsStandardInfo.getOpStitchModifyPlace1();
							stitchModifyList.add(opStitchModifyPlace1);
							String opStitchModifyPlace2 = coOptionPantsStandardInfo.getOpStitchModifyPlace2();
							stitchModifyList.add(opStitchModifyPlace2);
							String opStitchModifyPlace3 = coOptionPantsStandardInfo.getOpStitchModifyPlace3();
							stitchModifyList.add(opStitchModifyPlace3);
							String opStitchModifyPlace4 = coOptionPantsStandardInfo.getOpStitchModifyPlace4();
							stitchModifyList.add(opStitchModifyPlace4);
							
							stitchModifyList.removeAll(Collections.singleton(null));
							stitchModifyList.removeAll(Collections.singleton(""));
							if(stitchModifyList.isEmpty()|| OptionCodeKeys.PT_0002001.equals(invokeOne)) {
								splicingCodeForFindUniquePrice = code + key + invokeOne;
							}else {
								Integer orderPriceInt = 0;
								for (int i = 0; i < stitchModifyList.size(); i++) {
									String projectPriceCode = code + "00021" + stitchModifyList.get(i);
									String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
									orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
								}
								orderPrice = String.valueOf(orderPriceInt);
							}
						}
					}
					
					if( "op_dStitch_id".equals(valueFour)) {
						if(OptionCodeKeys.PT_0005101.equals(opStitch)||OptionCodeKeys.PT_0005103.equals(opStitch)
								||OptionCodeKeys.PT_0005104.equals(opStitch)) {
							coOptionPantsStandardInfo.setOpDStitch(OptionCodeKeys.PT_0002201);
							coOptionPantsStandardInfo.setOpDStitchPlace(null);
							coOptionPantsStandardInfo.setOpDStitchPlace1(null);
							coOptionPantsStandardInfo.setOpDStitchPlace2(null);
							coOptionPantsStandardInfo.setOpDStitchPlace3(null);
							splicingCodeForFindUniquePrice = code + key + OptionCodeKeys.PT_0002201;
						}
//						List<String> stitchModifyList = new ArrayList<String>();
//						String opDStitchPlace1 = coOptionPantsStandardInfo.getOpDStitchPlace1();
//						stitchModifyList.add(opDStitchPlace1);
//						String opDStitchPlace2 = coOptionPantsStandardInfo.getOpDStitchPlace2();
//						stitchModifyList.add(opDStitchPlace2);
//						String opDStitchPlace3 = coOptionPantsStandardInfo.getOpDStitchPlace3();
//						stitchModifyList.add(opDStitchPlace3);
//						String opDStitchPlace4 = coOptionPantsStandardInfo.getOpDStitchPlace4();
//						stitchModifyList.add(opDStitchPlace4);
//						stitchModifyList.removeAll(Collections.singleton(null));
//						stitchModifyList.removeAll(Collections.singleton(""));
//						if(stitchModifyList.isEmpty()|| OptionCodeKeys.PT_0002201.equals(invokeOne)) {
//							splicingCodeForFindUniquePrice = code + key + invokeOne;
//						}else {
//							Integer orderPriceInt = 0;
//							for (int i = 0; i < stitchModifyList.size(); i++) {
//								String projectPriceCode = code + "00023" + stitchModifyList.get(i);
//								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
//								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
//							}
//							orderPrice = String.valueOf(orderPriceInt);
//						}
					}
					
					if ("op_amfColor_id".equals(valueFour)) {
						
						if(OptionCodeKeys.PT_0005101.equals(opStitch) || OptionCodeKeys.PT_0005104.equals(opStitch)) {
							coOptionPantsStandardInfo.setOpAmfColor(OptionCodeKeys.PT_0002401);
							coOptionPantsStandardInfo.setOpAmfColorPlace1(null);
							coOptionPantsStandardInfo.setOpAmfColor1(null);
							coOptionPantsStandardInfo.setOpAmfColorPlace2(null);
							coOptionPantsStandardInfo.setOpAmfColor2(null);
							coOptionPantsStandardInfo.setOpAmfColorPlace3(null);
							coOptionPantsStandardInfo.setOpAmfColor3(null);
							coOptionPantsStandardInfo.setOpAmfColorPlace4(null);
							coOptionPantsStandardInfo.setOpAmfColor4(null);
							invokeOne = coOptionPantsStandardInfo.getOpAmfColor();
						}
						HashSet<String> amfColorSet = new HashSet<String>();
						String opAmfColor1 = coOptionPantsStandardInfo.getOpAmfColor1();
						amfColorSet.add(opAmfColor1);
						String opAmfColor2 = coOptionPantsStandardInfo.getOpAmfColor2();
						amfColorSet.add(opAmfColor2);
						String opAmfColor3 = coOptionPantsStandardInfo.getOpAmfColor3();
						amfColorSet.add(opAmfColor3);
						String opAmfColor4 = coOptionPantsStandardInfo.getOpAmfColor4();
						amfColorSet.add(opAmfColor4);
						amfColorSet.removeAll(Collections.singleton(null));
						amfColorSet.removeAll(Collections.singleton(""));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						if (OptionCodeKeys.PT_0002401.equals(invokeOne)||(OptionCodeKeys.PT_0002402.equals(invokeOne)&&amfColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00025" + amfColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(amfColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}	
						
					}
					
					if ("op_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String opBhColor1 = coOptionPantsStandardInfo.getOpBhColor1();
						bhColorSet.add(opBhColor1);
						String opBhColor2 = coOptionPantsStandardInfo.getOpBhColor2();
						bhColorSet.add(opBhColor2);
						String opBhColor3 = coOptionPantsStandardInfo.getOpBhColor3();
						bhColorSet.add(opBhColor3);
						String opBhColor4 = coOptionPantsStandardInfo.getOpBhColor4();
						bhColorSet.add(opBhColor4);
						bhColorSet.removeAll(Collections.singleton(null));
						bhColorSet.removeAll(Collections.singleton(""));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						if (OptionCodeKeys.PT_0002701.equals(invokeOne)||(OptionCodeKeys.PT_0002702.equals(invokeOne)&&bhColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00028" + bhColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("op_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String opByColor1 = coOptionPantsStandardInfo.getOpByColor1();
						byColorSet.add(opByColor1);
						String opByColor2 = coOptionPantsStandardInfo.getOpByColor2();
						byColorSet.add(opByColor2);
						String opByColor3 = coOptionPantsStandardInfo.getOpByColor3();
						byColorSet.add(opByColor3);
						String opByColor4 = coOptionPantsStandardInfo.getOpByColor4();
						byColorSet.add(opByColor4);
						byColorSet.removeAll(Collections.singleton(null));
						byColorSet.removeAll(Collections.singleton(""));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						if (OptionCodeKeys.PT_0003001.equals(invokeOne)||(OptionCodeKeys.PT_0003002.equals(invokeOne)&&byColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00031" + byColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				
				if("".equals(orderPrice)) {
					String subOptionBranchCode = null;
					int length = splicingCodeForFindUniquePrice.length();
					if(length >= 14) {
						subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
					}
					// 裾上げ
					String opHemUp = orderCoForm.getCoOptionPantsStandardInfo().getOpHemUp();
					// 膝裏
					String opKneeBack = orderCoForm.getCoOptionPantsStandardInfo().getOpKneeBack();
					if("00018".equals(subOptionBranchCode) && !"0001702".equals(opHemUp) && !"0001703".equals(opHemUp)) {
						orderPrice = "0";
					}
					else if("00003".equals(subOptionBranchCode) && "0000202".equals(opKneeBack)) {
						orderPrice = "0";
					}
					else {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);						
					}
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);				
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsStandardInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (PantsCoOptionStandardPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPantsStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsStandardInfo);
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
		orderCoForm.setPtOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, Object> getOrderPriceForPantsTuModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo =orderCoForm.getCoOptionPantsTuxedoInfo();
		PantsCoOptionTuxedoPriceEnum[] priceEnum = PantsCoOptionTuxedoPriceEnum.values();
		
		for (PantsCoOptionTuxedoPriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionPantsTuxedoInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPantsTuxedoInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPantsTuxedoInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPantsTuxedoInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				
				if("tp_btnMate".equals(valueFour)&&"3000700".equals(invokeOne)) {
					splicingCodeDetail = "";
				}
				
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if ("tp_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String tpBhColor1 = coOptionPantsTuxedoInfo.getTpBhColor1();
						bhColorSet.add(tpBhColor1);
						String tpBhColor2 = coOptionPantsTuxedoInfo.getTpBhColor2();
						bhColorSet.add(tpBhColor2);
						String tpBhColor3 = coOptionPantsTuxedoInfo.getTpBhColor3();
						bhColorSet.add(tpBhColor3);
						String tpBhColor4 = coOptionPantsTuxedoInfo.getTpBhColor4();
						bhColorSet.add(tpBhColor4);
						bhColorSet.removeAll(Collections.singleton(null));
						bhColorSet.removeAll(Collections.singleton(""));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						if (OptionCodeKeys.PT_0002701.equals(invokeOne)||(OptionCodeKeys.PT_0002702.equals(invokeOne)&&bhColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00028" + bhColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("tp_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String tpByColor1 = coOptionPantsTuxedoInfo.getTpByColor1();
						byColorSet.add(tpByColor1);
						String tpByColor2 = coOptionPantsTuxedoInfo.getTpByColor2();
						byColorSet.add(tpByColor2);
						String tpByColor3 = coOptionPantsTuxedoInfo.getTpByColor3();
						byColorSet.add(tpByColor3);
						String tpByColor4 = coOptionPantsTuxedoInfo.getTpByColor4();
						byColorSet.add(tpByColor4);
						byColorSet.removeAll(Collections.singleton(null));
						byColorSet.removeAll(Collections.singleton(""));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						if (OptionCodeKeys.PT_0003001.equals(invokeOne)||(OptionCodeKeys.PT_0003002.equals(invokeOne)&&byColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00031" + byColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				
				
				if("".equals(orderPrice)) {
					String subOptionBranchCode = null;
					int length = splicingCodeForFindUniquePrice.length();
					if(length >= 14) {
						subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
					}
					// 裾上げ
					String tpHemUp = orderCoForm.getCoOptionPantsTuxedoInfo().getTpHemUp();
					// 膝裏
					String tpKneeBack = orderCoForm.getCoOptionPantsTuxedoInfo().getTpKneeBack();
					// 側章
					String tpSideStripe = orderCoForm.getCoOptionPantsTuxedoInfo().getTpSideStripe();
					if("00018".equals(subOptionBranchCode) && !"0001702".equals(tpHemUp) && !"0001703".equals(tpHemUp)) {
						orderPrice = "0";
					}
					else if("00003".equals(subOptionBranchCode) && "0000202".equals(tpKneeBack)) {
						orderPrice = "0";
					}
					else if("00040".equals(subOptionBranchCode) && "0003901".equals(tpSideStripe)) {
						orderPrice = "0";
					}
					else {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);						
					}
				}
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);				
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsTuxedoInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (PantsCoOptionTuxedoPriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPantsTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsTuxedoInfo);
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
		orderCoForm.setPtOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, Object> getOrderPriceForPantsWPModel(OrderCoForm orderCoForm, String code, String orderFlag) {
		CoOptionPantsWashableInfo coOptionPantsWashableInfo =orderCoForm.getCoOptionPantsWashableInfo();
		PantsCoOptionWashablePriceEnum[] priceEnum = PantsCoOptionWashablePriceEnum.values();
		String wpStitch = coOptionPantsWashableInfo.getWpStitch();
		for (PantsCoOptionWashablePriceEnum price : priceEnum) {
			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();
			String valueFour = price.getValueFour();
			String splicingCodeForFindUniquePrice = "";
			String splicingCodeDetail = "";
			String orderPrice = "";
			try {
				Method methodOne = coOptionPantsWashableInfo.getClass().getMethod(valueOne);
				Object invokeOne = methodOne.invoke(coOptionPantsWashableInfo);
				Object invokeTwo = "";
				if(!("".equals(valueTwo))) {
					Method methodTwo = coOptionPantsWashableInfo.getClass().getMethod(valueTwo);
					invokeTwo = methodTwo.invoke(coOptionPantsWashableInfo);
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				splicingCodeForFindUniquePrice = code + key + invokeOne;
				if("orderLink".equals(orderFlag) || "orderDetail".equals(orderFlag) || "orderDivert".equals(orderFlag)) {
					
				}else {
					if( "wp_stitchModify_id".equals(valueFour)) {
						List<String> stitchModifyList = new ArrayList<String>();
						String opStitchModifyPlace1 = coOptionPantsWashableInfo.getWpStitchModifyPlace1();
						stitchModifyList.add(opStitchModifyPlace1);
						String opStitchModifyPlace2 = coOptionPantsWashableInfo.getWpStitchModifyPlace2();
						stitchModifyList.add(opStitchModifyPlace2);
						String opStitchModifyPlace3 = coOptionPantsWashableInfo.getWpStitchModifyPlace3();
						stitchModifyList.add(opStitchModifyPlace3);
						String opStitchModifyPlace4 = coOptionPantsWashableInfo.getWpStitchModifyPlace4();
						stitchModifyList.add(opStitchModifyPlace4);

						stitchModifyList.removeAll(Collections.singleton(null));
						stitchModifyList.removeAll(Collections.singleton(""));
						if (stitchModifyList.isEmpty() || OptionCodeKeys.PT_0002001.equals(invokeOne)) {
							splicingCodeForFindUniquePrice = code + key + invokeOne;
						} else {
							Integer orderPriceInt = 0;
							for (int i = 0; i < stitchModifyList.size(); i++) {
								String projectPriceCode = code + "00021" + stitchModifyList.get(i);
								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode,
										"", orderCoForm);
								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
							}
							orderPrice = String.valueOf(orderPriceInt);
						}
						
					}
					
					if( "wp_dStitch_id".equals(valueFour)) {
						if(OptionCodeKeys.PT_0005103.equals(wpStitch) || OptionCodeKeys.PT_0005104.equals(wpStitch)) {
							coOptionPantsWashableInfo.setWpDStitch(OptionCodeKeys.PT_0002201);
							coOptionPantsWashableInfo.setWpDStitchPlace(null);
							coOptionPantsWashableInfo.setWpDStitchPlace1(null);
							coOptionPantsWashableInfo.setWpDStitchPlace2(null);
							coOptionPantsWashableInfo.setWpDStitchPlace3(null);
							splicingCodeForFindUniquePrice = code + key + OptionCodeKeys.PT_0002201;
						}
//						List<String> stitchModifyList = new ArrayList<String>();
//						String opDStitchPlace1 = coOptionPantsWashableInfo.getWpDStitchPlace1();
//						stitchModifyList.add(opDStitchPlace1);
//						String opDStitchPlace2 = coOptionPantsWashableInfo.getWpDStitchPlace2();
//						stitchModifyList.add(opDStitchPlace2);
//						String opDStitchPlace3 = coOptionPantsWashableInfo.getWpDStitchPlace3();
//						stitchModifyList.add(opDStitchPlace3);
//						String opDStitchPlace4 = coOptionPantsWashableInfo.getWpDStitchPlace4();
//						stitchModifyList.add(opDStitchPlace4);
//						stitchModifyList.removeAll(Collections.singleton(null));
//						stitchModifyList.removeAll(Collections.singleton(""));
//						if(stitchModifyList.isEmpty()|| OptionCodeKeys.PT_0002201.equals(invokeOne)) {
//							splicingCodeForFindUniquePrice = code + key + invokeOne;
//						}else {
//							Integer orderPriceInt = 0;
//							for (int i = 0; i < stitchModifyList.size(); i++) {
//								String projectPriceCode = code + "00023" + stitchModifyList.get(i);
//								String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
//								orderPriceInt = orderPriceInt + Integer.valueOf(orderPriceInner);
//							}
//							orderPrice = String.valueOf(orderPriceInt);
//						}
					}
					
					if ("wp_amfColor_id".equals(valueFour)) {
						if(OptionCodeKeys.PT_0005104.equals(wpStitch)) {
							coOptionPantsWashableInfo.setWpAmfColor(OptionCodeKeys.PT_0002401);
							coOptionPantsWashableInfo.setWpAmfColorPlace1(null);
							coOptionPantsWashableInfo.setWpAmfColor1(null);
							coOptionPantsWashableInfo.setWpAmfColorPlace2(null);
							coOptionPantsWashableInfo.setWpAmfColor2(null);
							coOptionPantsWashableInfo.setWpAmfColorPlace3(null);
							coOptionPantsWashableInfo.setWpAmfColor3(null);
							coOptionPantsWashableInfo.setWpAmfColorPlace4(null);
							coOptionPantsWashableInfo.setWpAmfColor4(null);
							invokeOne = coOptionPantsWashableInfo.getWpAmfColor();
						}
						HashSet<String> amfColorSet = new HashSet<String>();
						String wpAmfColor1 = coOptionPantsWashableInfo.getWpAmfColor1();
						amfColorSet.add(wpAmfColor1);
						String wpAmfColor2 = coOptionPantsWashableInfo.getWpAmfColor2();
						amfColorSet.add(wpAmfColor2);
						String wpAmfColor3 = coOptionPantsWashableInfo.getWpAmfColor3();
						amfColorSet.add(wpAmfColor3);
						String wpAmfColor4 = coOptionPantsWashableInfo.getWpAmfColor4();
						amfColorSet.add(wpAmfColor4);
						amfColorSet.removeAll(Collections.singleton(null));
						amfColorSet.removeAll(Collections.singleton(""));
						List<String> amfColorList = new ArrayList<String>(amfColorSet);
						if (OptionCodeKeys.PT_0002401.equals(invokeOne)||(OptionCodeKeys.PT_0002402.equals(invokeOne)&&amfColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00025" + amfColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(amfColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("wp_bhColor_id".equals(valueFour)) {
						HashSet<String> bhColorSet = new HashSet<String>();
						String wpBhColor1 = coOptionPantsWashableInfo.getWpBhColor1();
						bhColorSet.add(wpBhColor1);
						String wpBhColor2 = coOptionPantsWashableInfo.getWpBhColor2();
						bhColorSet.add(wpBhColor2);
						String wpBhColor3 = coOptionPantsWashableInfo.getWpBhColor3();
						bhColorSet.add(wpBhColor3);
						String wpBhColor4 = coOptionPantsWashableInfo.getWpBhColor4();
						bhColorSet.add(wpBhColor4);
						bhColorSet.removeAll(Collections.singleton(null));
						bhColorSet.removeAll(Collections.singleton(""));
						List<String> bhColorList = new ArrayList<String>(bhColorSet);
						if (OptionCodeKeys.PT_0002701.equals(invokeOne)||(OptionCodeKeys.PT_0002702.equals(invokeOne)&&bhColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00028" + bhColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(bhColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
					
					if ("wp_byColor_id".equals(valueFour)) {
						HashSet<String> byColorSet = new HashSet<String>();
						String wpByColor1 = coOptionPantsWashableInfo.getWpByColor1();
						byColorSet.add(wpByColor1);
						String wpByColor2 = coOptionPantsWashableInfo.getWpByColor2();
						byColorSet.add(wpByColor2);
						String wpByColor3 = coOptionPantsWashableInfo.getWpByColor3();
						byColorSet.add(wpByColor3);
						String wpByColor4 = coOptionPantsWashableInfo.getWpByColor4();
						byColorSet.add(wpByColor4);
						byColorSet.removeAll(Collections.singleton(null));
						byColorSet.removeAll(Collections.singleton(""));
						List<String> byColorList = new ArrayList<String>(byColorSet);
						if (OptionCodeKeys.PT_0003001.equals(invokeOne)||(OptionCodeKeys.PT_0003002.equals(invokeOne)&&byColorSet.isEmpty())) {
							String projectPriceCode = code + key + invokeOne;
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							orderPrice = orderPriceInner;
						} else {
							String projectPriceCode = code + "00031" + byColorList.get(0);
							String orderPriceInner = CoContorllerPublicMethodUtil.getOrderPrice(projectPriceCode, "", orderCoForm);
							Integer colorPrice = Integer.valueOf(orderPriceInner) * Integer.valueOf(byColorList.size());
							orderPrice = String.valueOf(colorPrice);
						}
					}
				}
				
				if("".equals(orderPrice)) {
					String subOptionBranchCode = null;
					int length = splicingCodeForFindUniquePrice.length();
					if(length >= 14) {
						subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
					}
					// 裾上げ
					String wpHemUp = orderCoForm.getCoOptionPantsWashableInfo().getWpHemUp();
					// 膝裏
					String wpKneeBack = orderCoForm.getCoOptionPantsWashableInfo().getWpKneeBack();
					if("00018".equals(subOptionBranchCode) && !"0001702".equals(wpHemUp) && !"0001703".equals(wpHemUp)) {
						orderPrice = "0";
					}
					else if("00003".equals(subOptionBranchCode) && "0000202".equals(wpKneeBack)) {
						orderPrice = "0";
					}
					else {
						orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);						
					}
				}
				
				
				Class<?> cls;
				Object[] args = {orderPrice};
				cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo");
				Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);				
				ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsWashableInfo(), args);
			} catch (NoSuchMethodException | SecurityException | 
					IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
					ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> priceMap = new HashMap<String, String>();
		Integer optionPriceInt = 0;
		for (PantsCoOptionWashablePriceEnum price : priceEnum) {
			String valueFour = price.getValueFour();
			String valueSix = price.getValueSix();
			
			try {
				Method methodSix = coOptionPantsWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsWashableInfo);
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
		orderCoForm.setPtOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForPantsSTuProject(OrderCoForm orderCoForm, String code, String idValueName, String jspOptionCodeAndBranchCode,
			String colorCount, String countArr, String thisVal, String thisValStkNo,String valueHemUpId,String valueOpKneeBack,String valueSideStripe) {
		CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo =orderCoForm.getCoOptionPantsTuxedoInfo();
		PantsCoOptionTuxedoPriceEnum[] priceEnum = PantsCoOptionTuxedoPriceEnum.values();
		
		String orderPrice = "";
		for (PantsCoOptionTuxedoPriceEnum price : priceEnum) {
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
					Method methodOne = coOptionPantsTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsTuxedoInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionPantsTuxedoInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPantsTuxedoInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionPantsTuxedoInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsTuxedoInfo);
					Method methodTwo = coOptionPantsTuxedoInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPantsTuxedoInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				if(("tp_stitchModify_id".equals(idValueName) && "tp_stitchModify_id".equals(valueFour))|| ("tp_dStitch_id".equals(idValueName) &&"tp_dStitch_id".equals(valueFour))) {
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
				if(("tp_bhColor_id".equals(idValueName)&&"tp_bhColor_id".equals(valueFour))||
					("tp_byColor_id".equals(idValueName)&&"tp_byColor_id".equals(valueFour))) {
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
				if (hasIdvalueName == true) {
				    if("".equals(orderPrice)) {
				    	String subOptionBranchCode = null;
						int length = splicingCodeForFindUniquePrice.length();
						if(length >= 14) {
							subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
						}
						if("00018".equals(subOptionBranchCode) && !"0001702".equals(valueHemUpId) && !"0001703".equals(valueHemUpId)) {
							orderPrice = "0";
						}
						else if("00003".equals(subOptionBranchCode) && "0000202".equals(valueOpKneeBack)) {
							orderPrice = "0";
						}
						else if("00040".equals(subOptionBranchCode) && "0003901".equals(valueSideStripe)) {
							orderPrice = "0";
						}
						else {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsTuxedoInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Integer optionPriceInt = 0;
		for (PantsCoOptionTuxedoPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			try {
				Method methodSix = coOptionPantsTuxedoInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsTuxedoInfo);
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
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setPtOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForPantsSWPProject(OrderCoForm orderCoForm, String code, String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal,
			String thisValStkNo,String valueHemUpId,String valueOpKneeBack) {
		CoOptionPantsWashableInfo coOptionPantsWashableInfo =orderCoForm.getCoOptionPantsWashableInfo();
		PantsCoOptionWashablePriceEnum[] priceEnum = PantsCoOptionWashablePriceEnum.values();
		
		String orderPrice = "";
		for (PantsCoOptionWashablePriceEnum price : priceEnum) {
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
					Method methodOne = coOptionPantsWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsWashableInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionPantsWashableInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPantsWashableInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionPantsWashableInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsWashableInfo);
					Method methodTwo = coOptionPantsWashableInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPantsWashableInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				if(("wp_stitchModify_id".equals(idValueName) && "wp_stitchModify_id".equals(valueFour))) {
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
				if(("wp_amfColor_id".equals(idValueName)&&"wp_amfColor_id".equals(valueFour))||
				   ("wp_bhColor_id".equals(idValueName)&&"wp_bhColor_id".equals(valueFour))||
				   ("wp_byColor_id".equals(idValueName)&&"wp_byColor_id".equals(valueFour))) {
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

				if (hasIdvalueName == true) {
					if("".equals(orderPrice)) {
						String subOptionBranchCode = null;
						int length = splicingCodeForFindUniquePrice.length();
						if(length >= 14) {
							subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
						}
						if("00018".equals(subOptionBranchCode) && !"0001702".equals(valueHemUpId) && !"0001703".equals(valueHemUpId)) {
							orderPrice = "0";
						}
						else if("00003".equals(subOptionBranchCode) && "0000202".equals(valueOpKneeBack)) {
							orderPrice = "0";
						}
						else {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsWashableInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Integer optionPriceInt = 0;
		for (PantsCoOptionWashablePriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();
			try {
				Method methodSix = coOptionPantsWashableInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsWashableInfo);
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
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setPtOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public Map<String, String> getOrderPriceForPantsSProject(OrderCoForm orderCoForm, String code, String idValueName,
			String jspOptionCodeAndBranchCode, String colorCount, String countArr, String thisVal,
			String thisValStkNo,String valueHemUpId,String valueOpKneeBack) {
		CoOptionPantsStandardInfo coOptionPantsStandardInfo =orderCoForm.getCoOptionPantsStandardInfo();
		PantsCoOptionStandardPriceEnum[] priceEnum = PantsCoOptionStandardPriceEnum.values();
		
		String orderPrice = "";
		for (PantsCoOptionStandardPriceEnum price : priceEnum) {
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
					Method methodOne = coOptionPantsStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsStandardInfo);
					Object invokeTwo = null;
					hasIdvalueName = true;
					if (!("".equals(valueTwo))) {
						Method methodTwo = coOptionPantsStandardInfo.getClass().getMethod(valueTwo);
						invokeTwo = methodTwo.invoke(coOptionPantsStandardInfo);
					}
					splicingCodeForFindUniquePrice = code + key + thisVal;
					if (thisValStkNo != null&&!"".equals(thisValStkNo)) {
						splicingCodeDetail = code + key + thisVal + thisValStkNo;
					}
				} else if (idValueName.equals(valueFive)) {
					hasIdvalueName = true;
					Method methodOne = coOptionPantsStandardInfo.getClass().getMethod(valueOne);
					Object invokeOne = methodOne.invoke(coOptionPantsStandardInfo);
					Method methodTwo = coOptionPantsStandardInfo.getClass().getMethod(valueTwo);
					Object invokeTwo = methodTwo.invoke(coOptionPantsStandardInfo);
					splicingCodeForFindUniquePrice = code + key + invokeOne;
					splicingCodeDetail = code + key + invokeOne + invokeTwo;
				}
				
				if(("op_stitchModify_id".equals(idValueName) && "op_stitchModify_id".equals(valueFour))) {
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
				if(("op_amfColor_id".equals(idValueName)&&"op_amfColor_id".equals(valueFour))||
					("op_bhColor_id".equals(idValueName)&&"op_bhColor_id".equals(valueFour))||
					("op_byColor_id".equals(idValueName)&&"op_byColor_id".equals(valueFour))) {
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

				if (hasIdvalueName == true) {
					if("".equals(orderPrice)) {
						String subOptionBranchCode = null;
						int length = splicingCodeForFindUniquePrice.length();
						if(length >= 14) {
							subOptionBranchCode = splicingCodeForFindUniquePrice.substring(8, 13);
						}
						if("00018".equals(subOptionBranchCode) && !"0001702".equals(valueHemUpId) && !"0001703".equals(valueHemUpId)) {
							orderPrice = "0";
						}
						else if("00003".equals(subOptionBranchCode) && "0000202".equals(valueOpKneeBack)) {
							orderPrice = "0";
						}
						else {
							orderPrice = CoContorllerPublicMethodUtil.getOrderPrice(splicingCodeForFindUniquePrice, splicingCodeDetail, orderCoForm);
						}
					}
					Class<?> cls;
					Object[] args = { orderPrice };
					cls = Class.forName("co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo");
					Method methodThree = CoContorllerPublicMethodUtil.getMethod(cls, valueThree);
					ReflectionUtils.invoke(methodThree, orderCoForm.getCoOptionPantsStandardInfo(), args);
					break;
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		Integer optionPriceInt = 0;
		for (PantsCoOptionStandardPriceEnum price : priceEnum) {
			String valueSix = price.getValueSix();

			try {
				Method methodSix = coOptionPantsStandardInfo.getClass().getMethod(valueSix);
				Object invokeSix = methodSix.invoke(coOptionPantsStandardInfo);
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
		resultMap.put("idValuePrice", orderPrice);
		resultMap.put("optionPrice", String.valueOf(optionPriceInt));
		orderCoForm.setPtOptionPrice(String.valueOf(optionPriceInt));
		return resultMap;
	}

	public void optionPantsDbToOrder(String productItem, String productCategory,
			Order order, OrderCoForm orderCoForm, OrderListService orderListService, ModelService modelService,
			String orderFlag) {

		Order orderPt = orderListService.findOrderPtOptionByOrderId(order.getOrderId());
		if(orderPt !=null ) {
			// PANTS_膝裏_コード
			String ptKneeinnerTypeCd = orderPt.getPtKneeinnerTypeCd();
			// PANTS_フロント仕様_コード
			String ptFrtTypeCd = orderPt.getPtFrtTypeCd();
			// PANTS_パンチェリーナ_コード
			String ptPancherinaCd = orderPt.getPtPancherinaCd();
			if(ptKneeinnerTypeCd != null && !"".equals(ptKneeinnerTypeCd) && ptFrtTypeCd != null
					&& !"".equals(ptFrtTypeCd) && ptPancherinaCd != null && !"".equals(ptPancherinaCd)) {
				this.pantsDefaultValueFromDb(orderCoForm, orderPt);
			}
			else {
				this.pantsDefaultValue(orderCoForm);
			}
		}else {
			this.pantsDefaultValue(orderCoForm);
		}
		
		Order orderPtAd = orderListService.findOrderPtByPk(order.getOrderId());
		CoAdjustPantsStandardInfo coAdjustPantsStandardInfo = orderCoForm.getCoAdjustPantsStandardInfo();
		if(coAdjustPantsStandardInfo == null ) {
			coAdjustPantsStandardInfo = new CoAdjustPantsStandardInfo();
			orderCoForm.setCoAdjustPantsStandardInfo(coAdjustPantsStandardInfo);
		}
		if (orderPtAd != null) {
			this.pantsAdjustFromDb(orderCoForm, orderPtAd);
		}
		
		if("9000101".equals(productCategory)) {
			CoOptionPantsStandardInfo coOptionPantsStandardInfo = orderCoForm.getCoOptionPantsStandardInfo();
			String opPantsModel = coOptionPantsStandardInfo.getOpPantsModel();
			if(opPantsModel!=null&&!"".equals(opPantsModel)) {
				String code = productItem.concat("03").concat(coOptionPantsStandardInfo.getOpPantsModel());
				this.getOrderPriceForPantsModel(orderCoForm, code,orderFlag);
				//ステッチ箇所変更
				String stitchModifyValue = coOptionPantsStandardInfo.getOpStitchModify();
				String stitchModifyCountArr = coOptionPantsStandardInfo.getOpStitchModifyPlace();
				if(OptionCodeKeys.PT_0002002.equals(stitchModifyValue)&&BaseCheckUtil.isNotEmpty(stitchModifyCountArr)) {
					String stitchModifyCode = productItem.concat("03").concat(coOptionPantsStandardInfo.getOpPantsModel()).concat("00021");
					String stitchModifyValueName = "op_stitchModify_id";
					//if(!stitchModifyCountArr.startsWith("/")) {
					this.getOrderPriceForPantsSProject(orderCoForm, stitchModifyCode, stitchModifyValueName, "", "", stitchModifyCountArr, stitchModifyValue, "","","");
					//}
				}
				
//				//ダブルステッチ変更
//				String dSitchModifyValue = coOptionPantsStandardInfo.getOpDStitch();
//				String dSitchModifyCountArr = coOptionPantsStandardInfo.getOpDStitchPlace();
//				if(OptionCodeKeys.PT_0002202.equals(dSitchModifyValue)&&BaseCheckUtil.isNotEmpty(dSitchModifyCountArr)) {
//					String dStitchModifyCode = productItem.concat("03").concat(coOptionPantsStandardInfo.getOpPantsModel()).concat("00023");
//					String dSitchModifyValueName = "op_dStitch_id";
//					//if(!dSitchModifyCountArr.startsWith("/")) {
//					this.getOrderPriceForPantsSProject(orderCoForm, dStitchModifyCode, dSitchModifyValueName, "", "", dSitchModifyCountArr, dSitchModifyValue, "","","");
//					//}
//				}
				
				//AMF色指定
				String ptAmfColorCd = coOptionPantsStandardInfo.getOpAmfAllColor();
				if (ptAmfColorCd != null && !"".equals(ptAmfColorCd)) {
				String ptAmfTemp = ptAmfColorCd.replaceAll("/", "");
					if(!"".equals(ptAmfTemp)) {
						String amfValueName = "op_amfColor_id";
						String amfCode = productItem.concat("03").concat(coOptionPantsStandardInfo.getOpPantsModel());
						Map<String, String> amfColorMap = new HashMap<String, String>();
						
						String[] ptAmfColorSplit = ptAmfColorCd.split("/");
						for (String amfColor : ptAmfColorSplit) {
							amfColorMap.put(amfColor, amfColor);
						}
						
						List<String> amfValuesList = new ArrayList<String>(amfColorMap.values());
						amfValuesList.removeAll(Collections.singleton(null));
						amfValuesList.removeAll(Collections.singleton(""));
						String amfColorCount = String.valueOf(amfValuesList.size());
						String amfColorCode = "00025".concat(amfValuesList.get(0));
						this.getOrderPriceForPantsSProject(orderCoForm, amfCode, amfValueName, amfColorCode,
								amfColorCount, "", "", "","","");
					}
				}
				//ボタンホール色指定
				String ptBtnholeColorCd = coOptionPantsStandardInfo.getOpBhAllColor();
				if (ptBtnholeColorCd != null && !"".equals(ptBtnholeColorCd)) {
				String ptBtnholeTemp = ptBtnholeColorCd.replaceAll("/", "");
					if(!"".equals(ptBtnholeTemp)) {
						String bhValueName = "op_bhColor_id";
						String bhCode = productItem.concat("03").concat(coOptionPantsStandardInfo.getOpPantsModel());
						Map<String, String> bhColorMap = new HashMap<String, String>();
						String[] ptBtnholeColorSplit = ptBtnholeColorCd.split("/");
						for (String btnholeColor : ptBtnholeColorSplit) {
							bhColorMap.put(btnholeColor, btnholeColor);
						}
						
						List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
						bhValuesList.removeAll(Collections.singleton(null));
						bhValuesList.removeAll(Collections.singleton(""));
						String bhColorCount = String.valueOf(bhValuesList.size());
						String bhColorCode = "00028".concat(bhValuesList.get(0));
						this.getOrderPriceForPantsSProject(orderCoForm, bhCode, bhValueName, bhColorCode,
								bhColorCount, "", "", "","","");
					}
				}
				//ボタン付け糸指定
				String ptBtnthreadColorCd = coOptionPantsStandardInfo.getOpByAllColor();
				if (ptBtnthreadColorCd != null && !"".equals(ptBtnthreadColorCd)) {
				String ptBtnthreadTemp = ptBtnthreadColorCd.replaceAll("/", "");
					if(!"".equals(ptBtnthreadTemp)) {
						String byValueName = "op_byColor_id";
						String byCode = productItem.concat("03").concat(coOptionPantsStandardInfo.getOpPantsModel());
						Map<String, String> byColorMap = new HashMap<String, String>();
						
						String[] ptBtnthreadColorSplit = ptBtnthreadColorCd.split("/");
						for (String btnthreadColor : ptBtnthreadColorSplit) {
							byColorMap.put(btnthreadColor, btnthreadColor);
						}
											
						List<String> byValuesList = new ArrayList<String>(byColorMap.values());
						byValuesList.removeAll(Collections.singleton(null));
						byValuesList.removeAll(Collections.singleton(""));
						String byColorCount = String.valueOf(byValuesList.size());
						String byColorCode = "00031".concat(byValuesList.get(0));
						this.getOrderPriceForPantsSProject(orderCoForm, byCode, byValueName, byColorCode,
								byColorCount, "", "", "","","");
					}
				}
			}else {
				orderCoForm.setPtOptionPrice("0");
			}
			
		}else if("9000102".equals(productCategory)) {
			
			CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo = orderCoForm.getCoOptionPantsTuxedoInfo();
			String tpPantsModel = coOptionPantsTuxedoInfo.getTpPantsModel();
			if(tpPantsModel!=null&&!"".equals(tpPantsModel)) {
				String code = productItem.concat("03").concat(coOptionPantsTuxedoInfo.getTpPantsModel());
				this.getOrderPriceForPantsTuModel(orderCoForm, code,orderFlag);
				
				//ボタンホール色指定
				String ptBtnholeColorCd = coOptionPantsTuxedoInfo.getTpBhAllColor();
				if (ptBtnholeColorCd != null && !"".equals(ptBtnholeColorCd)) {
				String ptBtnholeTemp = ptBtnholeColorCd.replaceAll("/", "");
					if(!"".equals(ptBtnholeTemp)) {
						String bhValueName = "tp_bhColor_id";
						String bhCode = productItem.concat("03").concat(coOptionPantsTuxedoInfo.getTpPantsModel());
						Map<String, String> bhColorMap = new HashMap<String, String>();
						
						String[] ptBtnholeColorSplit = ptBtnholeColorCd.split("/");
						for (String btnholeColor : ptBtnholeColorSplit) {
							bhColorMap.put(btnholeColor, btnholeColor);
						}
						
						List<String> bhvaluesList = new ArrayList<String>(bhColorMap.values());
						bhvaluesList.removeAll(Collections.singleton(null));
						bhvaluesList.removeAll(Collections.singleton(""));
						String bhColorCount = String.valueOf(bhvaluesList.size());
						String bhColorCode = "00028".concat(bhvaluesList.get(0));
						this.getOrderPriceForPantsSTuProject(orderCoForm, bhCode, bhValueName, bhColorCode,
								bhColorCount, "", "", "","","","");
					}
				}
				
				// ボタン付け糸指定
				String ptBtnthreadColorCd = coOptionPantsTuxedoInfo.getTpByAllColor();
				if (ptBtnthreadColorCd != null && !"".equals(ptBtnthreadColorCd)) {
				String ptBtnthreadTemp = ptBtnthreadColorCd.replaceAll("/", "");
					if(!"".equals(ptBtnthreadTemp)) {
						String byValueName = "tp_byColor_id";
						String byCode = productItem.concat("03").concat(coOptionPantsTuxedoInfo.getTpPantsModel());
						Map<String, String> byColorMap = new HashMap<String, String>();
						
						String[] ptBtnthreadColorSplit = ptBtnthreadColorCd.split("/");
						for (String btnthreadColor : ptBtnthreadColorSplit) {
							byColorMap.put(btnthreadColor, btnthreadColor);
						}
						
						List<String> byValuesList = new ArrayList<String>(byColorMap.values());
						byValuesList.removeAll(Collections.singleton(null));
						byValuesList.removeAll(Collections.singleton(""));
						String byColorCount = String.valueOf(byValuesList.size());
						String byColorCode = "00031".concat(byValuesList.get(0));
						this.getOrderPriceForPantsSTuProject(orderCoForm, byCode, byValueName, byColorCode,
								byColorCount, "", "","","","","");
					}
				}
			}else {
				orderCoForm.setPtOptionPrice("0");
			}
		}else if("9000103".equals(productCategory)) {
			CoOptionPantsWashableInfo coOptionPantsWashableInfo = orderCoForm.getCoOptionPantsWashableInfo();
			String wpPantsModel = coOptionPantsWashableInfo.getWpPantsModel();
			if (wpPantsModel != null && !"".equals(wpPantsModel)) {
				String code = productItem.concat("03").concat(coOptionPantsWashableInfo.getWpPantsModel());
				this.getOrderPriceForPantsWPModel(orderCoForm, code,orderFlag);
				// ステッチ箇所変更
				String stitchModifyValue = coOptionPantsWashableInfo.getWpStitchModify();
				String stitchModifyCountArr = coOptionPantsWashableInfo.getWpStitchModifyPlace();
				if(OptionCodeKeys.PT_0002002.equals(stitchModifyValue)&&BaseCheckUtil.isNotEmpty(stitchModifyCountArr)) {
					String stitchModifyCode = productItem.concat("03").concat(coOptionPantsWashableInfo.getWpPantsModel())
							.concat("00021");
					String stitchModifyValueName = "wp_stitchModify_id";
					//if(!stitchModifyCountArr.startsWith("/")) {
					this.getOrderPriceForPantsSWPProject(orderCoForm, stitchModifyCode, stitchModifyValueName,
								"", "", stitchModifyCountArr, stitchModifyValue, "","","");
					//}
				}
				
//				// ダブルステッチ変更
//				String dSitchModifyValue = coOptionPantsWashableInfo.getWpDStitch();
//				String dSitchModifyCountArr = coOptionPantsWashableInfo.getWpDStitchPlace();
//				if(OptionCodeKeys.PT_0002202.equals(dSitchModifyValue)&&BaseCheckUtil.isNotEmpty(dSitchModifyCountArr)) {
//					String dStitchModifyCode = productItem.concat("03").concat(coOptionPantsWashableInfo.getWpPantsModel())
//							.concat("00023");
//					String dSitchModifyValueName = "wp_dStitch_id";
//					//if(!dSitchModifyCountArr.startsWith("/")) {
//					this.getOrderPriceForPantsSWPProject(orderCoForm, dStitchModifyCode, dSitchModifyValueName,
//								"", "", dSitchModifyCountArr, dSitchModifyValue, "","","");
//					//}
//				}
				// AMF色指定
				String ptAmfColorCd = coOptionPantsWashableInfo.getWpAmfAllColor();
				if (ptAmfColorCd != null && !"".equals(ptAmfColorCd)) {
				String ptAmfTemp = ptAmfColorCd.replaceAll("/", "");
					if(!"".equals(ptAmfTemp)) {
						String amfValueName = "wp_amfColor_id";
						String amfCode = productItem.concat("03").concat(coOptionPantsWashableInfo.getWpPantsModel());
						Map<String, String> amfColorMap = new HashMap<String, String>();
						
						String[] ptAmfColorSplit = ptAmfColorCd.split("/");
						for (String amfColor : ptAmfColorSplit) {
							amfColorMap.put(amfColor, amfColor);
						}
						
						List<String> amfValuesList = new ArrayList<String>(amfColorMap.values());
						amfValuesList.removeAll(Collections.singleton(null));
						amfValuesList.removeAll(Collections.singleton(""));
						String amfColorCount = String.valueOf(amfValuesList.size());
						String amfColorCode = "00025".concat(amfValuesList.get(0));
						this.getOrderPriceForPantsSWPProject(orderCoForm, amfCode, amfValueName, amfColorCode,
								amfColorCount, "", "", "","","");
					}
				}
				// ボタンホール色指定
				String ptBtnholeColorCd = coOptionPantsWashableInfo.getWpBhAllColor();
				if (ptBtnholeColorCd != null && !"".equals(ptBtnholeColorCd)) {
				String ptBtnholeTemp = ptBtnholeColorCd.replaceAll("/", "");
					if(!"".equals(ptBtnholeTemp)) {
						String bhValueName = "wp_bhColor_id";
						String bhCode = productItem.concat("03").concat(coOptionPantsWashableInfo.getWpPantsModel());
						Map<String, String> bhColorMap = new HashMap<String, String>();
						
							String[] ptBtnholeColorSplit = ptBtnholeColorCd.split("/");
							for (String btnholeColor : ptBtnholeColorSplit) {
								bhColorMap.put(btnholeColor, btnholeColor);
							}
						
						List<String> bhValuesList = new ArrayList<String>(bhColorMap.values());
						bhValuesList.removeAll(Collections.singleton(null));
						bhValuesList.removeAll(Collections.singleton(""));
						String bhColorCount = String.valueOf(bhValuesList.size());
						String bhColorCode = "00028".concat(bhValuesList.get(0));
						this.getOrderPriceForPantsSWPProject(orderCoForm, bhCode, bhValueName, bhColorCode,
								bhColorCount, "", "", "","","");
					}
				}
				// ボタン付け糸指定
				String ptBtnthreadColorCd = coOptionPantsWashableInfo.getWpByAllColor();
				if (ptBtnthreadColorCd != null && !"".equals(ptBtnthreadColorCd)) {
				String ptBtnthreadTemp = ptBtnthreadColorCd.replaceAll("/", "");
					if(!"".equals(ptBtnthreadTemp)) {
						String byValueName = "wp_byColor_id";
						String byCode = productItem.concat("03").concat(coOptionPantsWashableInfo.getWpPantsModel());
						Map<String, String> byColorMap = new HashMap<String, String>();
						
							String[] ptBtnthreadColorSplit = ptBtnthreadColorCd.split("/");
							for (String btnthreadColor : ptBtnthreadColorSplit) {
								byColorMap.put(btnthreadColor, btnthreadColor);
							}
						
						List<String> byValuesList = new ArrayList<String>(byColorMap.values());
						byValuesList.removeAll(Collections.singleton(null));
						byValuesList.removeAll(Collections.singleton(""));
						String byColorCount = String.valueOf(byValuesList.size());
						String byColorCode = "00031".concat(byValuesList.get(0));
						this.getOrderPriceForPantsSWPProject(orderCoForm, byCode, byValueName, byColorCode,
								byColorCount, "", "", "","","");
					}
				}
			}else {
				orderCoForm.setPtOptionPrice("0");
			}
		}
		List<co.jp.aoyama.macchinetta.domain.model.Model> modelList = modelService.getItemModel(order.getOrderPattern(), productItem,
				"03");
		this.getPantsModelMap(orderCoForm, modelList);
	}

	public void pantsDefaultValueFromDb(OrderCoForm orderCoForm, Order orderPt) {
		String productCategory = orderCoForm.getProductCategory();
		if ("9000101".equals(productCategory)) {
			// 標準
			CoOptionPantsStandardInfo optionPantsStandardInfo = orderCoForm.getCoOptionPantsStandardInfo();
			optionPantsStandardInfo.setOpPantsModel(orderPt.getPtModelCd());
			optionPantsStandardInfo.setOpTack(orderPt.getPtTackCd());
			optionPantsStandardInfo.setOpKneeBack(orderPt.getPtKneeinnerTypeCd());
			optionPantsStandardInfo.setOpKneeBackMate(orderPt.getPtKneeinnerClothCd());
			optionPantsStandardInfo.setOpFrontSpec(orderPt.getPtFrtTypeCd());
			optionPantsStandardInfo.setOpPancherina(orderPt.getPtPancherinaCd());
			optionPantsStandardInfo.setOpAdjuster(orderPt.getPtAdjusterCd());
			optionPantsStandardInfo.setOpBeltLoop(orderPt.getPtBeltloopType());
			optionPantsStandardInfo.setOpBeltLoopPlace(orderPt.getPtBeltloopCd());
			optionPantsStandardInfo.setOpPinLoop(orderPt.getPtPinloopCd());
			optionPantsStandardInfo.setOpSidePkt(orderPt.getPtSidePktCd());
			optionPantsStandardInfo.setOpSinobiPkt(orderPt.getPtShinobiPktCd());
			optionPantsStandardInfo.setOpCoinPkt(orderPt.getPtCoinPktCd());
			optionPantsStandardInfo.setOpFlapCoinPkt(orderPt.getPtFlapcoinPktCd());
			optionPantsStandardInfo.setOpPisPktUf(orderPt.getPtLeftPisPktCd());
			optionPantsStandardInfo.setOpPisPktDf(orderPt.getPtRightPisPktCd());
			optionPantsStandardInfo.setOpVCut(orderPt.getPtVCutCd());
			optionPantsStandardInfo.setOpHemUp(orderPt.getPtHemUpCd());
			optionPantsStandardInfo.setOpDoubleWide(orderPt.getPtDblWidthCd());
			optionPantsStandardInfo.setOpStitch(orderPt.getPtAmfStitchCd());
			optionPantsStandardInfo.setOpStitchModify(orderPt.getPtStitchPlcType());
			if ("0002001".equals(orderPt.getPtStitchPlcType())) {
				optionPantsStandardInfo.setOpStitchModifyPlace(null);
			} else {
				optionPantsStandardInfo.setOpStitchModifyPlace(orderPt.getPtStitchPlcCd());
			}
			optionPantsStandardInfo.setOpDStitch(orderPt.getPtDblstitchPlcType());
			optionPantsStandardInfo.setOpDStitchPlace(orderPt.getPtDblstitchPlcCd());
			optionPantsStandardInfo.setOpAmfColor(orderPt.getPtAmfColorType());
			optionPantsStandardInfo.setOpAmfAllColor(orderPt.getPtAmfColorCd());
			optionPantsStandardInfo.setOpAmfColorPlace(orderPt.getPtAmfColorPlcCd());
			optionPantsStandardInfo.setOpBhColor(orderPt.getPtBtnholeColorType());
			optionPantsStandardInfo.setOpBhAllColor(orderPt.getPtBtnholeColorCd());
			optionPantsStandardInfo.setOpBhColorPlace(orderPt.getPtBtnholeColorPlcCd());
			optionPantsStandardInfo.setOpByColor(orderPt.getPtBtnthreadColorType());
			optionPantsStandardInfo.setOpByAllColor(orderPt.getPtBtnthreadColorCd());
			optionPantsStandardInfo.setOpByColorPlace(orderPt.getPtBtnthreadColorPlcCd());
			optionPantsStandardInfo.setOpButton(orderPt.getPtBtnMaterialType());
			optionPantsStandardInfo.setOpBtnMateStkNo(orderPt.getPtBtnMaterialCd());
			optionPantsStandardInfo.setOpSuspenderBtn(orderPt.getPtSuspenderBtnCd());
			optionPantsStandardInfo.setOpEight(orderPt.getPtNonSlipCd());
			optionPantsStandardInfo.setOpShapeMemory(orderPt.getPtShapeMemoryCd());
			optionPantsStandardInfo.setOpBlister(orderPt.getPtShoeSoreCd());
			optionPantsStandardInfo.setOpThick(orderPt.getPtChicSlipCd());
			
			pluralPtStandardOptionItem(optionPantsStandardInfo,orderPt);
		} else if ("9000102".equals(productCategory)) {
			// タキシード
			CoOptionPantsTuxedoInfo optionPantsTuxedoInfo = orderCoForm.getCoOptionPantsTuxedoInfo();

			optionPantsTuxedoInfo.setTpPantsModel(orderPt.getPtModelCd());
			optionPantsTuxedoInfo.setTpTack(orderPt.getPtTackCd());
			optionPantsTuxedoInfo.setTpKneeBack(orderPt.getPtKneeinnerTypeCd());
			optionPantsTuxedoInfo.setTpKneeBackMate(orderPt.getPtKneeinnerClothCd());
			optionPantsTuxedoInfo.setTpFrontSpec(orderPt.getPtFrtTypeCd());
			optionPantsTuxedoInfo.setTpGlossFablic(orderPt.getPtLookClothCd());
			optionPantsTuxedoInfo.setTpPancherina(orderPt.getPtPancherinaCd());
			optionPantsTuxedoInfo.setTpAdjuster(orderPt.getPtAdjusterCd());
			optionPantsTuxedoInfo.setTpBeltLoop(orderPt.getPtBeltloopType());
			optionPantsTuxedoInfo.setTpBeltLoopPlace(orderPt.getPtBeltloopCd());
			optionPantsTuxedoInfo.setTpPinLoop(orderPt.getPtPinloopCd());
			optionPantsTuxedoInfo.setTpSidePkt(orderPt.getPtSidePktCd());
			optionPantsTuxedoInfo.setTpSinobiPkt(orderPt.getPtShinobiPktCd());
			optionPantsTuxedoInfo.setTpCoinPkt(orderPt.getPtCoinPktCd());
			optionPantsTuxedoInfo.setTpFlapCoinPkt(orderPt.getPtFlapcoinPktCd());
			optionPantsTuxedoInfo.setTpPisPktUf(orderPt.getPtLeftPisPktCd());
			optionPantsTuxedoInfo.setTpPisPktDf(orderPt.getPtRightPisPktCd());
			optionPantsTuxedoInfo.setTpVCut(orderPt.getPtVCutCd());
			optionPantsTuxedoInfo.setTpHemUp(orderPt.getPtHemUpCd());
			optionPantsTuxedoInfo.setTpDoubleWide(orderPt.getPtDblWidthCd());
			optionPantsTuxedoInfo.setTpStitch(orderPt.getPtAmfStitchCd());
			optionPantsTuxedoInfo.setTpStitchModify(orderPt.getPtStitchPlcType());
			optionPantsTuxedoInfo.setTpDStitchPlace(orderPt.getPtDblstitchPlcCd());
			optionPantsTuxedoInfo.setTpAmfColor(orderPt.getPtAmfColorCd());
			optionPantsTuxedoInfo.setTpBhColor(orderPt.getPtBtnholeColorType());
			optionPantsTuxedoInfo.setTpBhColorPlace(orderPt.getPtBtnholeColorPlcCd());
			optionPantsTuxedoInfo.setTpBhAllColor(orderPt.getPtBtnholeColorCd());
			optionPantsTuxedoInfo.setTpByColor(orderPt.getPtBtnthreadColorType());
			optionPantsTuxedoInfo.setTpByColorPlace(orderPt.getPtBtnthreadColorPlcCd());
			optionPantsTuxedoInfo.setTpByAllColor(orderPt.getPtBtnthreadColorCd());
			optionPantsTuxedoInfo.setTpButton(orderPt.getPtBtnMaterialType());
			optionPantsTuxedoInfo.setTpBtnMateStkNo(orderPt.getPtBtnMaterialCd());
			optionPantsTuxedoInfo.setTpSuspenderBtn(orderPt.getPtSuspenderBtnCd());
			optionPantsTuxedoInfo.setTpEight(orderPt.getPtNonSlipCd());
			optionPantsTuxedoInfo.setTpThick(orderPt.getPtChicSlipCd());
			optionPantsTuxedoInfo.setTpShapeMemory(orderPt.getPtShapeMemoryCd());
			optionPantsTuxedoInfo.setTpSideStripe(orderPt.getPtSideStripeCd());
			optionPantsTuxedoInfo.setTpSideStripeWidth(orderPt.getPtSideStripeWidthCd());
			
			pluralPtTuxedoOptionItem(optionPantsTuxedoInfo,orderPt);
		} else if ("9000103".equals(productCategory)) {
			// ウォッシャブル
			CoOptionPantsWashableInfo optionPantsWashableInfo = orderCoForm.getCoOptionPantsWashableInfo();
			optionPantsWashableInfo.setWpPantsModel(orderPt.getPtModelCd());
			optionPantsWashableInfo.setWpTack(orderPt.getPtTackCd());
			optionPantsWashableInfo.setWpKneeBack(orderPt.getPtKneeinnerTypeCd());
			optionPantsWashableInfo.setWpKneeBackMate(orderPt.getPtKneeinnerClothCd());
			optionPantsWashableInfo.setWpFrontSpec(orderPt.getPtFrtTypeCd());
			optionPantsWashableInfo.setWpPancherina(orderPt.getPtPancherinaCd());
			optionPantsWashableInfo.setWpAdjuster(orderPt.getPtAdjusterCd());
			optionPantsWashableInfo.setWpBeltLoop(orderPt.getPtBeltloopType());
			optionPantsWashableInfo.setWpBeltLoopPlace(orderPt.getPtBeltloopCd());
			optionPantsWashableInfo.setWpPinLoop(orderPt.getPtPinloopCd());
			optionPantsWashableInfo.setWpSidePkt(orderPt.getPtSidePktCd());
			optionPantsWashableInfo.setWpSinobiPkt(orderPt.getPtShinobiPktCd());
			optionPantsWashableInfo.setWpCoinPkt(orderPt.getPtCoinPktCd());
			optionPantsWashableInfo.setWpFlapCoinPkt(orderPt.getPtFlapcoinPktCd());
			optionPantsWashableInfo.setWpPisPktUf(orderPt.getPtLeftPisPktCd());
			optionPantsWashableInfo.setWpPisPktDf(orderPt.getPtRightPisPktCd());
			optionPantsWashableInfo.setWpVCut(orderPt.getPtVCutCd());
			optionPantsWashableInfo.setWpHemUp(orderPt.getPtHemUpCd());
			optionPantsWashableInfo.setWpDoubleWide(orderPt.getPtDblWidthCd());
			optionPantsWashableInfo.setWpStitch(orderPt.getPtAmfStitchCd());
			optionPantsWashableInfo.setWpStitchModify(orderPt.getPtStitchPlcType());
			if ("0002001".equals(orderPt.getPtStitchPlcType())) {
				optionPantsWashableInfo.setWpStitchModifyPlace(null);
			} else {
				optionPantsWashableInfo.setWpStitchModifyPlace(orderPt.getPtStitchPlcCd());
			}
			optionPantsWashableInfo.setWpDStitch(orderPt.getPtDblstitchPlcType());
			optionPantsWashableInfo.setWpDStitchPlace(orderPt.getPtDblstitchPlcCd());
			optionPantsWashableInfo.setWpAmfColor(orderPt.getPtAmfColorType());
			optionPantsWashableInfo.setWpAmfColorPlace(orderPt.getPtAmfColorPlcCd());
			optionPantsWashableInfo.setWpAmfAllColor(orderPt.getPtAmfColorCd());
			optionPantsWashableInfo.setWpBhColor(orderPt.getPtBtnholeColorType());
			optionPantsWashableInfo.setWpBhColorPlace(orderPt.getPtBtnholeColorPlcCd());
			optionPantsWashableInfo.setWpBhAllColor(orderPt.getPtBtnholeColorCd());
			optionPantsWashableInfo.setWpByColor(orderPt.getPtBtnthreadColorType());
			optionPantsWashableInfo.setWpByColorPlace(orderPt.getPtBtnthreadColorPlcCd());
			optionPantsWashableInfo.setWpByAllColor(orderPt.getPtBtnthreadColorCd());
			optionPantsWashableInfo.setWpButton(orderPt.getPtBtnMaterialType());
			optionPantsWashableInfo.setWpBtnMateStkNo(orderPt.getPtBtnMaterialCd());		
			optionPantsWashableInfo.setWpSuspenderBtn(orderPt.getPtSuspenderBtnCd());
			optionPantsWashableInfo.setWpEight(orderPt.getPtNonSlipCd());
			optionPantsWashableInfo.setWpThick(orderPt.getPtChicSlipCd());
			optionPantsWashableInfo.setWpShapeMemory(orderPt.getPtShapeMemoryCd());
			optionPantsWashableInfo.setWpBlister(orderPt.getPtShoeSoreCd());
			
			pluralPtWashableOptionItem(optionPantsWashableInfo,orderPt);
		}

	}
	public void pantsDefaultValue(OrderCoForm orderCoForm) {
		// 標準
		CoOptionPantsStandardInfo optionPantsStandardInfo = orderCoForm.getCoOptionPantsStandardInfo();
		// PANTSモデル
		optionPantsStandardInfo.setOpPantsModel("");
		// タック
		optionPantsStandardInfo.setOpTack(OptionCodeKeys.PT_0000101);
		// 膝裏
		optionPantsStandardInfo.setOpKneeBack(OptionCodeKeys.PT_0000201);
		// 膝裏素材
		optionPantsStandardInfo.setOpKneeBackMate(OptionCodeKeys.PT_0000301);
		// フロント仕様
		optionPantsStandardInfo.setOpFrontSpec(OptionCodeKeys.PT_0000401);
		// パンチェリーナ
		optionPantsStandardInfo.setOpPancherina(OptionCodeKeys.PT_0000501);
		// アジャスター仕様
		optionPantsStandardInfo.setOpAdjuster(OptionCodeKeys.PT_0000601);
		// ベルトループ
		optionPantsStandardInfo.setOpBeltLoop(OptionCodeKeys.PT_0000701);
		
		optionPantsStandardInfo.setOpBeltLoopPlace1(OptionCodeKeys.PT_0000801);
		
		optionPantsStandardInfo.setOpBeltLoopPlace2(OptionCodeKeys.PT_0000802);
		
		optionPantsStandardInfo.setOpBeltLoopPlace3(OptionCodeKeys.PT_0000803);
		
		optionPantsStandardInfo.setOpBeltLoopPlace4(OptionCodeKeys.PT_0000804);
		
		optionPantsStandardInfo.setOpBeltLoopPlace5(OptionCodeKeys.PT_0000805);
		
		optionPantsStandardInfo.setOpBeltLoopPlace6(OptionCodeKeys.PT_0000806);
		
		optionPantsStandardInfo.setOpBeltLoopPlace(null);
		// ピンループ
		optionPantsStandardInfo.setOpPinLoop(OptionCodeKeys.PT_0000901);
		// 脇ポケット
		optionPantsStandardInfo.setOpSidePkt(OptionCodeKeys.PT_0001002);
		// 忍びポケット
		optionPantsStandardInfo.setOpSinobiPkt(OptionCodeKeys.PT_0001104);
		// コインポケット
		optionPantsStandardInfo.setOpCoinPkt(OptionCodeKeys.PT_0001201);
		// フラップ付コインポケット
		optionPantsStandardInfo.setOpFlapCoinPkt(OptionCodeKeys.PT_0001301);
		// 上前ピスポケット
		optionPantsStandardInfo.setOpPisPktUf(OptionCodeKeys.PT_0001401);
		// 下前ピスポケット
		optionPantsStandardInfo.setOpPisPktDf(OptionCodeKeys.PT_0001501);
		// Vカット
		optionPantsStandardInfo.setOpVCut(OptionCodeKeys.PT_0001602);
		// 裾上げ
		optionPantsStandardInfo.setOpHemUp(OptionCodeKeys.PT_0001701);
		// ダブル幅
		optionPantsStandardInfo.setOpDoubleWide(OptionCodeKeys.PT_4);
		// ステッチ種類
		optionPantsStandardInfo.setOpStitch(OptionCodeKeys.PT_0001904);
		// ステッチ箇所変更
		optionPantsStandardInfo.setOpStitchModify(OptionCodeKeys.PT_0002001);
		optionPantsStandardInfo.setOpStitchModifyPlace(null);
		optionPantsStandardInfo.setOpStitchModifyPlace1(null);
		optionPantsStandardInfo.setOpStitchModifyPlace2(null);
		optionPantsStandardInfo.setOpStitchModifyPlace3(null);
		optionPantsStandardInfo.setOpStitchModifyPlace4(null);
		// ダブルステッチ
		optionPantsStandardInfo.setOpDStitch(OptionCodeKeys.PT_0002201);
		optionPantsStandardInfo.setOpDStitchPlace(null);
		optionPantsStandardInfo.setOpDStitchPlace1(null);
		optionPantsStandardInfo.setOpDStitchPlace2(null);
		optionPantsStandardInfo.setOpDStitchPlace3(null);
		// AMF色指定
		optionPantsStandardInfo.setOpAmfColor(OptionCodeKeys.PT_0002401);
		optionPantsStandardInfo.setOpAmfColorPlace(null);
		optionPantsStandardInfo.setOpAmfColorPlace1(null);
		optionPantsStandardInfo.setOpAmfColorPlace2(null);
		optionPantsStandardInfo.setOpAmfColorPlace3(null);
		optionPantsStandardInfo.setOpAmfColorPlace4(null);
		optionPantsStandardInfo.setOpAmfColor1(null);
		optionPantsStandardInfo.setOpAmfColor2(null);
		optionPantsStandardInfo.setOpAmfColor3(null);
		optionPantsStandardInfo.setOpAmfColor4(null);
		optionPantsStandardInfo.setOpAmfAllColor(null);
		// ボタンホール色指定
		optionPantsStandardInfo.setOpBhColor(OptionCodeKeys.PT_0002701);
		optionPantsStandardInfo.setOpBhColorPlace1(null);
		optionPantsStandardInfo.setOpBhColorPlace2(null);
		optionPantsStandardInfo.setOpBhColorPlace3(null);
		optionPantsStandardInfo.setOpBhColorPlace4(null);
		optionPantsStandardInfo.setOpBhColor1(null);
		optionPantsStandardInfo.setOpBhColor2(null);
		optionPantsStandardInfo.setOpBhColor3(null);
		optionPantsStandardInfo.setOpBhColor4(null);
		optionPantsStandardInfo.setOpBhColorPlace(null);
		optionPantsStandardInfo.setOpBhAllColor(null);
		// ボタン付け糸指定
		optionPantsStandardInfo.setOpByColor(OptionCodeKeys.PT_0003001);
		optionPantsStandardInfo.setOpByColorPlace(null);
		optionPantsStandardInfo.setOpByAllColor(null);
		// 釦素材
		if("1".equals(orderCoForm.getOjBtnMatePtFlag())) {
			
		}else {
			optionPantsStandardInfo.setOpButton(OptionCodeKeys.PT_3000800);
			
			optionPantsStandardInfo.setOpBtnMateStkNo(null);
		}
		//optionPantsStandardInfo.setOpButton(OptionCodeKeys.PT_3000800);		
		//optionPantsStandardInfo.setOpBtnMateStkNo(null);
		// サスペンダー釦
		optionPantsStandardInfo.setOpSuspenderBtn(OptionCodeKeys.PT_0003501);
		// シック大（股補強）
		optionPantsStandardInfo.setOpThick(OptionCodeKeys.PT_0004101);
		// エイト（滑り止め）
		optionPantsStandardInfo.setOpEight(OptionCodeKeys.PT_0003601);
		// 形状記憶
		optionPantsStandardInfo.setOpShapeMemory(OptionCodeKeys.PT_0003701);

		// タキシード
		CoOptionPantsTuxedoInfo optionPantsTuxedoInfo = orderCoForm.getCoOptionPantsTuxedoInfo();
		// PANTSモデル
		optionPantsTuxedoInfo.setTpPantsModel("");
		// タック
		optionPantsTuxedoInfo.setTpTack(OptionCodeKeys.PT_0000101);
		// 膝裏
		optionPantsTuxedoInfo.setTpKneeBack(OptionCodeKeys.PT_0000201);
		// 膝裏素材
		optionPantsTuxedoInfo.setTpKneeBackMate(OptionCodeKeys.PT_0000301);
		// フロント仕様
		optionPantsTuxedoInfo.setTpFrontSpec(OptionCodeKeys.PT_0000401);
		// パンチェリーナ
		optionPantsTuxedoInfo.setTpPancherina(OptionCodeKeys.PT_0000501);
		// アジャスター仕様
		optionPantsTuxedoInfo.setTpAdjuster(OptionCodeKeys.PT_0000601);
		// ベルトループ
		optionPantsTuxedoInfo.setTpBeltLoop(OptionCodeKeys.PT_0000701);
		
		optionPantsTuxedoInfo.setTpBeltLoopPlace1(OptionCodeKeys.PT_0000801);
		
		optionPantsTuxedoInfo.setTpBeltLoopPlace2(OptionCodeKeys.PT_0000802);
		
		optionPantsTuxedoInfo.setTpBeltLoopPlace3(OptionCodeKeys.PT_0000803);
		
		optionPantsTuxedoInfo.setTpBeltLoopPlace4(OptionCodeKeys.PT_0000804);
		
		optionPantsTuxedoInfo.setTpBeltLoopPlace5(OptionCodeKeys.PT_0000805);
		
		optionPantsTuxedoInfo.setTpBeltLoopPlace6(OptionCodeKeys.PT_0000806);
		optionPantsTuxedoInfo.setTpBeltLoopPlace(null);
		// ピンループ
		optionPantsTuxedoInfo.setTpPinLoop(OptionCodeKeys.PT_0000901);
		// 脇ポケット
		optionPantsTuxedoInfo.setTpSidePkt(OptionCodeKeys.PT_0001002);
		// 忍びポケット
		optionPantsTuxedoInfo.setTpSinobiPkt(OptionCodeKeys.PT_0001104);
		// コインポケット
		optionPantsTuxedoInfo.setTpCoinPkt(OptionCodeKeys.PT_0001201);
		// フラップ付コインポケット
		optionPantsTuxedoInfo.setTpFlapCoinPkt(OptionCodeKeys.PT_0001301);
		// 上前ピスポケット
		optionPantsTuxedoInfo.setTpPisPktUf(OptionCodeKeys.PT_0001401);
		// 下前ピスポケット
		optionPantsTuxedoInfo.setTpPisPktDf(OptionCodeKeys.PT_0001501);
		// Vカット
		optionPantsTuxedoInfo.setTpVCut(OptionCodeKeys.PT_0001602);
		// 裾上げ
		optionPantsTuxedoInfo.setTpHemUp(OptionCodeKeys.PT_0001701);
		// ダブル幅
		optionPantsTuxedoInfo.setTpDoubleWide(OptionCodeKeys.PT_4);
		// ステッチ種類
		optionPantsTuxedoInfo.setTpStitch(OptionCodeKeys.PT_0001903);
		// ボタンホール色指定
		optionPantsTuxedoInfo.setTpBhColor(OptionCodeKeys.PT_0002701);
		optionPantsTuxedoInfo.setTpBhColorPlace(null);
		optionPantsTuxedoInfo.setTpBhColorPlace1(null);
		optionPantsTuxedoInfo.setTpBhColorPlace2(null);
		optionPantsTuxedoInfo.setTpBhColorPlace3(null);
		optionPantsTuxedoInfo.setTpBhColorPlace4(null);
		optionPantsTuxedoInfo.setTpBhColor1(null);
		optionPantsTuxedoInfo.setTpBhColor2(null);
		optionPantsTuxedoInfo.setTpBhColor3(null);
		optionPantsTuxedoInfo.setTpBhColor4(null);
		optionPantsTuxedoInfo.setTpBhAllColor(null);
		// ボタン付け糸指定
		optionPantsTuxedoInfo.setTpByColor(OptionCodeKeys.PT_0003001);
		optionPantsTuxedoInfo.setTpByColorPlace(null);
		optionPantsTuxedoInfo.setTpByColorPlace1(null);
		optionPantsTuxedoInfo.setTpByColorPlace2(null);
		optionPantsTuxedoInfo.setTpByColorPlace3(null);
		optionPantsTuxedoInfo.setTpByColorPlace4(null);
		optionPantsTuxedoInfo.setTpByColor1(null);
		optionPantsTuxedoInfo.setTpByColor2(null);
		optionPantsTuxedoInfo.setTpByColor3(null);
		optionPantsTuxedoInfo.setTpByColor4(null);
		optionPantsTuxedoInfo.setTpByAllColor(null);
		// 釦素材
		if("1".equals(orderCoForm.getOjBtnMatePtFlag())) {
			
		}else {
		    optionPantsTuxedoInfo.setTpButton(OptionCodeKeys.PT_3000800);
		    optionPantsTuxedoInfo.setTpBtnMateStkNo(null);
		}
		// サスペンダー釦
		optionPantsTuxedoInfo.setTpSuspenderBtn(OptionCodeKeys.PT_0003501);
		// シック大（股補強）
		optionPantsTuxedoInfo.setTpThick(OptionCodeKeys.PT_0004101);
		// エイト（滑り止め）
		optionPantsTuxedoInfo.setTpEight(OptionCodeKeys.PT_0003601);
		// 形状記憶
		optionPantsTuxedoInfo.setTpShapeMemory(OptionCodeKeys.PT_0003701);
		// 側章
		optionPantsTuxedoInfo.setTpSideStripe(OptionCodeKeys.PT_0003902);
		// 側章幅
		optionPantsTuxedoInfo.setTpSideStripeWidth(OptionCodeKeys.PT_0004001);
		
		optionPantsTuxedoInfo.setTpGlossFablic(OptionCodeKeys.PT_0005001);

		// ウォッシャブル
		CoOptionPantsWashableInfo optionPantsWashableInfo = orderCoForm.getCoOptionPantsWashableInfo();
		// PANTSモデル
		optionPantsWashableInfo.setWpPantsModel("");
		// タック
		optionPantsWashableInfo.setWpTack(OptionCodeKeys.PT_0000101);
		// 膝裏
		optionPantsWashableInfo.setWpKneeBack(OptionCodeKeys.PT_0000201);
		// 膝裏素材
		optionPantsWashableInfo.setWpKneeBackMate(OptionCodeKeys.PT_0000301);
		// フロント仕様
		optionPantsWashableInfo.setWpFrontSpec(OptionCodeKeys.PT_0000401);
		// パンチェリーナ
		optionPantsWashableInfo.setWpPancherina(OptionCodeKeys.PT_0000501);
		// アジャスター仕様
		optionPantsWashableInfo.setWpAdjuster(OptionCodeKeys.PT_0000601);
		// ベルトループ
		optionPantsWashableInfo.setWpBeltLoop(OptionCodeKeys.PT_0000701);
		
		optionPantsWashableInfo.setWpBeltLoopPlace1(OptionCodeKeys.PT_0000801);
		
		optionPantsWashableInfo.setWpBeltLoopPlace2(OptionCodeKeys.PT_0000802);
		
		optionPantsWashableInfo.setWpBeltLoopPlace3(OptionCodeKeys.PT_0000803);
		
		optionPantsWashableInfo.setWpBeltLoopPlace4(OptionCodeKeys.PT_0000804);
		
		optionPantsWashableInfo.setWpBeltLoopPlace5(OptionCodeKeys.PT_0000805);
		
		optionPantsWashableInfo.setWpBeltLoopPlace6(OptionCodeKeys.PT_0000806);
		
		optionPantsWashableInfo.setWpBeltLoopPlace(null);
		// ピンループ
		optionPantsWashableInfo.setWpPinLoop(OptionCodeKeys.PT_0000901);
		// 脇ポケット
		optionPantsWashableInfo.setWpSidePkt(OptionCodeKeys.PT_0001002);
		// 忍びポケット
		optionPantsWashableInfo.setWpSinobiPkt(OptionCodeKeys.PT_0001104);
		// コインポケット
		optionPantsWashableInfo.setWpCoinPkt(OptionCodeKeys.PT_0001201);
		// フラップ付コインポケット
		optionPantsWashableInfo.setWpFlapCoinPkt(OptionCodeKeys.PT_0001301);
		// 上前ピスポケット
		optionPantsWashableInfo.setWpPisPktUf(OptionCodeKeys.PT_0001401);
		// 下前ピスポケット
		optionPantsWashableInfo.setWpPisPktDf(OptionCodeKeys.PT_0001501);
		// Vカット
		optionPantsWashableInfo.setWpVCut(OptionCodeKeys.PT_0001602);
		// 裾上げ
		optionPantsWashableInfo.setWpHemUp(OptionCodeKeys.PT_0001701);
		// ダブル幅
		optionPantsWashableInfo.setWpDoubleWide(OptionCodeKeys.PT_4);
		// ステッチ種類
		optionPantsWashableInfo.setWpStitch(OptionCodeKeys.PT_0001901);
		// ステッチ箇所変更
		optionPantsWashableInfo.setWpStitchModify(OptionCodeKeys.PT_0002001);
		optionPantsWashableInfo.setWpStitchModifyPlace(null);
		optionPantsWashableInfo.setWpStitchModifyPlace1(null);
		optionPantsWashableInfo.setWpStitchModifyPlace2(null);
		optionPantsWashableInfo.setWpStitchModifyPlace3(null);
		optionPantsWashableInfo.setWpStitchModifyPlace4(null);
		// ダブルステッチ
		optionPantsWashableInfo.setWpDStitch(OptionCodeKeys.PT_0002201);
		optionPantsWashableInfo.setWpDStitchPlace(null);
		optionPantsWashableInfo.setWpDStitchPlace1(null);
		optionPantsWashableInfo.setWpDStitchPlace2(null);
		optionPantsWashableInfo.setWpDStitchPlace3(null);
		// AMF色指定
		optionPantsWashableInfo.setWpAmfColor(OptionCodeKeys.PT_0002401);
		optionPantsWashableInfo.setWpAmfColorPlace(null);
		optionPantsWashableInfo.setWpAmfColorPlace1(null);
		optionPantsWashableInfo.setWpAmfColorPlace2(null);
		optionPantsWashableInfo.setWpAmfColorPlace3(null);
		optionPantsWashableInfo.setWpAmfColorPlace4(null);
		optionPantsWashableInfo.setWpAmfColor1(null);
		optionPantsWashableInfo.setWpAmfColor2(null);
		optionPantsWashableInfo.setWpAmfColor3(null);
		optionPantsWashableInfo.setWpAmfColor4(null);
		optionPantsWashableInfo.setWpAmfAllColor(null);
		// ボタンホール色指定
		optionPantsWashableInfo.setWpBhColor(OptionCodeKeys.PT_0002701);
		optionPantsWashableInfo.setWpBhColorPlace(null);
		optionPantsWashableInfo.setWpBhColorPlace1(null);
		optionPantsWashableInfo.setWpBhColorPlace2(null);
		optionPantsWashableInfo.setWpBhColorPlace3(null);
		optionPantsWashableInfo.setWpBhColorPlace4(null);
		optionPantsWashableInfo.setWpBhColor1(null);
		optionPantsWashableInfo.setWpBhColor2(null);
		optionPantsWashableInfo.setWpBhColor3(null);
		optionPantsWashableInfo.setWpBhColor4(null);
		optionPantsWashableInfo.setWpBhAllColor(null);
		// ボタン付け糸指定
		optionPantsWashableInfo.setWpByColor(OptionCodeKeys.PT_0003001);
		optionPantsWashableInfo.setWpByColorPlace(null);
		optionPantsWashableInfo.setWpByAllColor(null);
		// 釦素材
		if("1".equals(orderCoForm.getOjBtnMatePtFlag())) {
			
		}else {
		    optionPantsWashableInfo.setWpButton(OptionCodeKeys.PT_3000800);
		
		    optionPantsWashableInfo.setWpBtnMateStkNo(null);
		}
		// サスペンダー釦
		optionPantsWashableInfo.setWpSuspenderBtn(OptionCodeKeys.PT_0003501);
		// シック大（股補強）
		optionPantsWashableInfo.setWpThick(OptionCodeKeys.PT_0004101);
		// エイト（滑り止め）
		optionPantsWashableInfo.setWpEight(OptionCodeKeys.PT_0003601);
		// 形状記憶
		optionPantsWashableInfo.setWpShapeMemory(OptionCodeKeys.PT_0003702);

	}
	
	public void pantsAdjustFromDb(OrderCoForm orderCoForm, Order order) {
		if("9000101".equals(order.getProductCategory())) {
			orderCoForm.getCoOptionPantsStandardInfo().setOpPantsModel(order.getPtModelCd());
		}else if("9000102".equals(order.getProductCategory())) {
			orderCoForm.getCoOptionPantsTuxedoInfo().setTpPantsModel(order.getPtModelCd());
		}else if("9000103".equals(order.getProductCategory())) {
			orderCoForm.getCoOptionPantsWashableInfo().setWpPantsModel(order.getPtModelCd());
		}
		
		orderCoForm.getCoAdjustPantsStandardInfo().setSizeFigure(order.getCorPtDrop());
		orderCoForm.getCoAdjustPantsStandardInfo().setSizeNumber(order.getCorPtSize());

		BigDecimal corPtWaistSize = order.getCorPtWaistSize();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtWaistSize)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtWaistSize(String.valueOf(corPtWaistSize));
		}
		
		BigDecimal corPtWaistGross = order.getCorPtWaistGross();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtWaistSize)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtWaistGross(String.valueOf(corPtWaistGross));
		}
		
		BigDecimal corPtWaistCorrect = order.getCorPtWaistCorrect();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtWaistSize)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtWaistCorrect(String.valueOf(corPtWaistCorrect));
		}
		
		BigDecimal corPtThighwidthSize = order.getCorPtThighwidthSize();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtThighwidthSize)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtThighSize(String.valueOf(corPtThighwidthSize));
		}
		
		BigDecimal corPtThighwidthGross = order.getCorPtThighwidthGross();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtThighwidthGross)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtThighGross(String.valueOf(corPtThighwidthGross));
		}
		
		BigDecimal corPtThighwidthCorrect = order.getCorPtThighwidthCorrect();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtThighwidthCorrect)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtThighCorrect(String.valueOf(corPtThighwidthCorrect));
		}

		orderCoForm.getCoAdjustPantsStandardInfo().setCorPtHemwidthType(order.getCorPtHemwidthType());
		if("1".equals(order.getCorPtHemwidthType())) {
			BigDecimal corPtHemwidthSize = order.getCorPtHemwidthSize();
			if(BaseCheckUtil.isNotBigDecimalNull(corPtHemwidthSize)) {
				orderCoForm.getCoAdjustPantsStandardInfo().setCorPtHemwidthSize(String.valueOf(corPtHemwidthSize));
			}
			BigDecimal corPtHemwidthGross = order.getCorPtHemwidthGross();
			if(BaseCheckUtil.isNotBigDecimalNull(corPtHemwidthGross)) {
				orderCoForm.getCoAdjustPantsStandardInfo().setCorPtHemwidthGross(String.valueOf(corPtHemwidthGross));
			}
			BigDecimal corPtHemwidthCorrect = order.getCorPtHemwidthCorrect();
			if(BaseCheckUtil.isNotBigDecimalNull(corPtHemwidthCorrect)) {
				orderCoForm.getCoAdjustPantsStandardInfo().setCorPtHemwidthCorrect(String.valueOf(corPtHemwidthCorrect));
			}
		}else if("2".equals(order.getCorPtHemwidthType())) {
			BigDecimal corPtHemwidthDegignate = order.getCorPtHemwidthDegignate();
			if(BaseCheckUtil.isNotBigDecimalNull(corPtHemwidthDegignate)) {
				orderCoForm.getCoAdjustPantsStandardInfo().setCorPtHemwidthDegignate(String.valueOf(corPtHemwidthDegignate));
			}
		}

		BigDecimal corPtHipSize = order.getCorPtHipSize();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtHipSize)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtHipSize(String.valueOf(corPtHipSize));
		}
		BigDecimal corPtHipGross = order.getCorPtHipGross();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtHipGross)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtHipGross(String.valueOf(corPtHipGross));
		}
		BigDecimal corPtHipCorrect = order.getCorPtHipCorrect();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtHipCorrect)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtHipCorrect(String.valueOf(corPtHipCorrect));
		}

		BigDecimal corPtRightinseamSize = order.getCorPtRightinseamSize();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtRightinseamSize)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtRightinseamSize(String.valueOf(corPtRightinseamSize));
		}
		BigDecimal corPtRightinseamGross = order.getCorPtRightinseamGross();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtRightinseamGross)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtRightinseamGross(String.valueOf(corPtRightinseamGross));
		}
		//orderCoForm.getCoAdjustPantsStandardInfo()
				//.setCorPtRightinseamCorrect(order.getCorPtRightinseamCorrect().toString());

		BigDecimal corPtLeftinseamSize = order.getCorPtLeftinseamSize();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtLeftinseamSize)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtLeftinseamSize(String.valueOf(corPtLeftinseamSize));
		}
		BigDecimal corPtLeftinseamGross = order.getCorPtLeftinseamGross();
		if(BaseCheckUtil.isNotBigDecimalNull(corPtLeftinseamGross)) {
			orderCoForm.getCoAdjustPantsStandardInfo().setCorPtLeftinseamGross(String.valueOf(corPtLeftinseamGross));
		}
		//orderCoForm.getCoAdjustPantsStandardInfo()
				//.setCorPtLeftinseamCorrect(order.getCorPtLeftinseamCorrect().toString());

		//orderCoForm.setCorStoreCorrectionMemoAgain(order.getCorStoreCorrectionMemo());

	}
	
	public void getPantsModelMap(OrderCoForm orderCoForm, List<Model> modelList) {
		LinkedHashMap<String, String> modelMap = new LinkedHashMap<String, String>();
		for (Model model : modelList) {
			modelMap.put("", "モデル選択");
			modelMap.put(model.getModelCode(), model.getModelName());
		}
		orderCoForm.getCoOptionPantsStandardInfo().setOpPantsModelMap(modelMap);
		orderCoForm.getCoOptionPantsTuxedoInfo().setTpPantsModelMap(modelMap);
		orderCoForm.getCoOptionPantsWashableInfo().setWpPantsModelMap(modelMap);

	}
	
	private void pluralPtStandardOptionItem(CoOptionPantsStandardInfo optionPantsStandardInfo, Order orderPt) {
		String regex = "/";
		//ベルトループ
		String ptBeltloopCd = orderPt.getPtBeltloopCd();
		if(ptBeltloopCd != null && !"".equals(ptBeltloopCd)) {
			String[] ptBeltloopSplit = ptBeltloopCd.split(regex);
			for (String ptBeltloopCode : ptBeltloopSplit) {
				if("0000801".equals(ptBeltloopCode)) {
					optionPantsStandardInfo.setOpBeltLoopPlace1(ptBeltloopCode);
				}else if("0000802".equals(ptBeltloopCode)) {
					optionPantsStandardInfo.setOpBeltLoopPlace2(ptBeltloopCode);
				}else if("0000803".equals(ptBeltloopCode)) {
					optionPantsStandardInfo.setOpBeltLoopPlace3(ptBeltloopCode);
				}else if("0000804".equals(ptBeltloopCode)) {
					optionPantsStandardInfo.setOpBeltLoopPlace4(ptBeltloopCode);
				}else if("0000805".equals(ptBeltloopCode)) {
					optionPantsStandardInfo.setOpBeltLoopPlace5(ptBeltloopCode);
				}else if("0000806".equals(ptBeltloopCode)) {
					optionPantsStandardInfo.setOpBeltLoopPlace6(ptBeltloopCode);
				}else if("0000807".equals(ptBeltloopCode)) {
					optionPantsStandardInfo.setOpBeltLoopPlace7(ptBeltloopCode);
				}
			}
		}
		
		//ステッチ箇所変更
		String ptStitchPlcCd = orderPt.getPtStitchPlcCd();
		if(ptStitchPlcCd != null && !"".equals(ptStitchPlcCd) && !"0002001".equals(orderPt.getPtStitchPlcType())) {
			String[] ptStitchPlcSplit = ptStitchPlcCd.split(regex);
			for (String stitchPlcCode : ptStitchPlcSplit) {
				if("0002101".equals(stitchPlcCode)) {
					optionPantsStandardInfo.setOpStitchModifyPlace1(stitchPlcCode);
				}else if("0002102".equals(stitchPlcCode)) {
					optionPantsStandardInfo.setOpStitchModifyPlace2(stitchPlcCode);
				}else if("0002103".equals(stitchPlcCode)) {
					optionPantsStandardInfo.setOpStitchModifyPlace3(stitchPlcCode);
				}else if("0002104".equals(stitchPlcCode)) {
					optionPantsStandardInfo.setOpStitchModifyPlace4(stitchPlcCode);
				}
			}
		}
		
		//ダブルステッチ
		String ptDblstitchPlcCd = orderPt.getPtDblstitchPlcCd();
		if(ptDblstitchPlcCd != null && !"".equals(ptDblstitchPlcCd)) {
			String[] ptDblstitchPlcSplit = ptDblstitchPlcCd.split(regex);
			for (String dblstitchPlcCode : ptDblstitchPlcSplit) {
				if("0002301".equals(dblstitchPlcCode)) {
					optionPantsStandardInfo.setOpDStitchPlace1(dblstitchPlcCode);
				}else if("0002302".equals(dblstitchPlcCode)) {
					optionPantsStandardInfo.setOpDStitchPlace2(dblstitchPlcCode);
				}else if("0002304".equals(dblstitchPlcCode)) {
					optionPantsStandardInfo.setOpDStitchPlace3(dblstitchPlcCode);
				}
			}
		}
		
		//AMF色指定
		String ptAmfColorPlcCd = orderPt.getPtAmfColorPlcCd();
		String ptAmfColorCd = orderPt.getPtAmfColorCd();
		if(ptAmfColorPlcCd!=null && !"".equals(ptAmfColorPlcCd) && ptAmfColorCd !=null && !"".equals(ptAmfColorCd)) {
			String[] ptAmfColorPlcSplit = ptAmfColorPlcCd.split(regex);
			String[] ptAmfColorSplit = ptAmfColorCd.split(regex);
			ptAmfColorSplit = BaseCheckUtil.placeColorMethod(ptAmfColorPlcSplit.length,ptAmfColorSplit);
			for (int i = 0;i<ptAmfColorPlcSplit.length;i++) {
				if("0002601".equals(ptAmfColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpAmfColorPlace1(ptAmfColorPlcSplit[i]);
					optionPantsStandardInfo.setOpAmfColor1(ptAmfColorSplit[i]);
				}else if("0002602".equals(ptAmfColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpAmfColorPlace2(ptAmfColorPlcSplit[i]);
					optionPantsStandardInfo.setOpAmfColor2(ptAmfColorSplit[i]);
				}else if("0002603".equals(ptAmfColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpAmfColorPlace3(ptAmfColorPlcSplit[i]);
					optionPantsStandardInfo.setOpAmfColor3(ptAmfColorSplit[i]);
				}else if("0002604".equals(ptAmfColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpAmfColorPlace4(ptAmfColorPlcSplit[i]);
					optionPantsStandardInfo.setOpAmfColor4(ptAmfColorSplit[i]);
				}
			}
		}
		
		//ボタンホール色指定
		String ptBtnholeColorPlcCd = orderPt.getPtBtnholeColorPlcCd();
		String PtBtnholeColorCd = orderPt.getPtBtnholeColorCd();
		if(!"".equals(ptBtnholeColorPlcCd)&&ptBtnholeColorPlcCd!=null&&!"".equals(PtBtnholeColorCd)&&PtBtnholeColorCd!=null) {
			String[] ptBtnholeColorPlcSplit = ptBtnholeColorPlcCd.split(regex);
			String[] PtBtnholeColorSplit = PtBtnholeColorCd.split(regex);
			PtBtnholeColorSplit = BaseCheckUtil.placeColorMethod(ptBtnholeColorPlcSplit.length,PtBtnholeColorSplit);
			for (int i = 0; i < ptBtnholeColorPlcSplit.length; i++) {
				if("0002901".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpBhColorPlace1(ptBtnholeColorPlcSplit[i]);
					optionPantsStandardInfo.setOpBhColor1(PtBtnholeColorSplit[i]);
				}else if("0002902".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpBhColorPlace2(ptBtnholeColorPlcSplit[i]);
					optionPantsStandardInfo.setOpBhColor2(PtBtnholeColorSplit[i]);
				}else if("0002903".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpBhColorPlace3(ptBtnholeColorPlcSplit[i]);
					optionPantsStandardInfo.setOpBhColor3(PtBtnholeColorSplit[i]);
				}else if("0002904".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpBhColorPlace4(ptBtnholeColorPlcSplit[i]);
					optionPantsStandardInfo.setOpBhColor4(PtBtnholeColorSplit[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String ptBtnthreadColorPlcCd = orderPt.getPtBtnthreadColorPlcCd();
		String ptBtnthreadColorCd = orderPt.getPtBtnthreadColorCd();
		if(!"".equals(ptBtnthreadColorPlcCd)&&ptBtnthreadColorPlcCd!=null&&!"".equals(ptBtnthreadColorCd)&&ptBtnthreadColorCd!=null) {
			String[] ptBtnthreadColorPlcSplit = ptBtnthreadColorPlcCd.split(regex);
			String[] ptBtnthreadColorSplit = ptBtnthreadColorCd.split(regex);
			ptBtnthreadColorSplit = BaseCheckUtil.placeColorMethod(ptBtnthreadColorPlcSplit.length,ptBtnthreadColorSplit);
			for (int i = 0; i < ptBtnthreadColorPlcSplit.length; i++) {
				if("0003201".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpByColorPlace1(ptBtnthreadColorPlcSplit[i]);
					optionPantsStandardInfo.setOpByColor1(ptBtnthreadColorSplit[i]);
				}else if("0003202".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpByColorPlace2(ptBtnthreadColorPlcSplit[i]);
					optionPantsStandardInfo.setOpByColor2(ptBtnthreadColorSplit[i]);
				}else if("0003203".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpByColorPlace3(ptBtnthreadColorPlcSplit[i]);
					optionPantsStandardInfo.setOpByColor3(ptBtnthreadColorSplit[i]);
				}else if("0003204".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsStandardInfo.setOpByColorPlace4(ptBtnthreadColorPlcSplit[i]);
					optionPantsStandardInfo.setOpByColor4(ptBtnthreadColorSplit[i]);
				}
			}
		}
	}
	
	private void pluralPtTuxedoOptionItem(CoOptionPantsTuxedoInfo optionPantsTuxedoInfo, Order orderPt) {
		String regex = "/";
		//ベルトループ
		String ptBeltloopCd = orderPt.getPtBeltloopCd();
		if(ptBeltloopCd != null && !"".equals(ptBeltloopCd)) {
			String[] ptBeltloopSplit = ptBeltloopCd.split(regex);
			for (String ptBeltloopCode : ptBeltloopSplit) {
				if("0000801".equals(ptBeltloopCode)) {
					optionPantsTuxedoInfo.setTpBeltLoopPlace1(ptBeltloopCode);
				}else if("0000802".equals(ptBeltloopCode)) {
					optionPantsTuxedoInfo.setTpBeltLoopPlace2(ptBeltloopCode);
				}else if("0000803".equals(ptBeltloopCode)) {
					optionPantsTuxedoInfo.setTpBeltLoopPlace3(ptBeltloopCode);
				}else if("0000804".equals(ptBeltloopCode)) {
					optionPantsTuxedoInfo.setTpBeltLoopPlace4(ptBeltloopCode);
				}else if("0000805".equals(ptBeltloopCode)) {
					optionPantsTuxedoInfo.setTpBeltLoopPlace5(ptBeltloopCode);
				}else if("0000806".equals(ptBeltloopCode)) {
					optionPantsTuxedoInfo.setTpBeltLoopPlace6(ptBeltloopCode);
				}else if("0000807".equals(ptBeltloopCode)) {
					optionPantsTuxedoInfo.setTpBeltLoopPlace7(ptBeltloopCode);
				}
			}
		}

		//ボタンホール色指定
		String ptBtnholeColorPlcCd = orderPt.getPtBtnholeColorPlcCd();
		String PtBtnholeColorCd = orderPt.getPtBtnholeColorCd();
		if(!"".equals(ptBtnholeColorPlcCd)&&ptBtnholeColorPlcCd!=null&&!"".equals(PtBtnholeColorCd)&&PtBtnholeColorCd!=null) {
			String[] ptBtnholeColorPlcSplit = ptBtnholeColorPlcCd.split(regex);
			String[] PtBtnholeColorSplit = PtBtnholeColorCd.split(regex);
			PtBtnholeColorSplit = BaseCheckUtil.placeColorMethod(ptBtnholeColorPlcSplit.length,PtBtnholeColorSplit);
			for (int i = 0; i < ptBtnholeColorPlcSplit.length; i++) {
				if("0002901".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsTuxedoInfo.setTpBhColorPlace1(ptBtnholeColorPlcSplit[i]);
					optionPantsTuxedoInfo.setTpBhColor1(PtBtnholeColorSplit[i]);
				}else if("0002902".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsTuxedoInfo.setTpBhColorPlace2(ptBtnholeColorPlcSplit[i]);
					optionPantsTuxedoInfo.setTpBhColor2(PtBtnholeColorSplit[i]);
				}else if("0002903".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsTuxedoInfo.setTpBhColorPlace3(ptBtnholeColorPlcSplit[i]);
					optionPantsTuxedoInfo.setTpBhColor3(PtBtnholeColorSplit[i]);
				}else if("0002904".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsTuxedoInfo.setTpBhColorPlace4(ptBtnholeColorPlcSplit[i]);
					optionPantsTuxedoInfo.setTpBhColor4(PtBtnholeColorSplit[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String ptBtnthreadColorPlcCd = orderPt.getPtBtnthreadColorPlcCd();
		String ptBtnthreadColorCd = orderPt.getPtBtnthreadColorCd();
		if(!"".equals(ptBtnthreadColorPlcCd)&&ptBtnthreadColorPlcCd!=null&&!"".equals(ptBtnthreadColorCd)&&ptBtnthreadColorCd!=null) {
			String[] ptBtnthreadColorPlcSplit = ptBtnthreadColorPlcCd.split(regex);
			String[] ptBtnthreadColorSplit = ptBtnthreadColorCd.split(regex);
			ptBtnthreadColorSplit = BaseCheckUtil.placeColorMethod(ptBtnthreadColorPlcSplit.length,ptBtnthreadColorSplit);
			for (int i = 0; i < ptBtnthreadColorPlcSplit.length; i++) {
				if("0003201".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsTuxedoInfo.setTpByColorPlace1(ptBtnthreadColorPlcSplit[i]);
					optionPantsTuxedoInfo.setTpByColor1(ptBtnthreadColorSplit[i]);
				}else if("0003202".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsTuxedoInfo.setTpByColorPlace2(ptBtnthreadColorPlcSplit[i]);
					optionPantsTuxedoInfo.setTpByColor2(ptBtnthreadColorSplit[i]);
				}else if("0003203".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsTuxedoInfo.setTpByColorPlace3(ptBtnthreadColorPlcSplit[i]);
					optionPantsTuxedoInfo.setTpByColor3(ptBtnthreadColorSplit[i]);
				}else if("0003204".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsTuxedoInfo.setTpByColorPlace4(ptBtnthreadColorPlcSplit[i]);
					optionPantsTuxedoInfo.setTpByColor4(ptBtnthreadColorSplit[i]);
				}
			}
		}
	}

	private void pluralPtWashableOptionItem(CoOptionPantsWashableInfo optionPantsWashableInfo, Order orderPt) {
		String regex = "/";
		//ベルトループ
		String ptBeltloopCd = orderPt.getPtBeltloopCd();
		if(ptBeltloopCd != null && !"".equals(ptBeltloopCd)) {
			String[] ptBeltloopSplit = ptBeltloopCd.split(regex);
			for (String ptBeltloopCode : ptBeltloopSplit) {
				if("0000801".equals(ptBeltloopCode)) {
					optionPantsWashableInfo.setWpBeltLoopPlace1(ptBeltloopCode);
				}else if("0000802".equals(ptBeltloopCode)) {
					optionPantsWashableInfo.setWpBeltLoopPlace2(ptBeltloopCode);
				}else if("0000803".equals(ptBeltloopCode)) {
					optionPantsWashableInfo.setWpBeltLoopPlace3(ptBeltloopCode);
				}else if("0000804".equals(ptBeltloopCode)) {
					optionPantsWashableInfo.setWpBeltLoopPlace4(ptBeltloopCode);
				}else if("0000805".equals(ptBeltloopCode)) {
					optionPantsWashableInfo.setWpBeltLoopPlace5(ptBeltloopCode);
				}else if("0000806".equals(ptBeltloopCode)) {
					optionPantsWashableInfo.setWpBeltLoopPlace6(ptBeltloopCode);
				}else if("0000807".equals(ptBeltloopCode)) {
					optionPantsWashableInfo.setWpBeltLoopPlace7(ptBeltloopCode);
				}
			}
		}
		
		//ステッチ箇所変更
		String ptStitchPlcCd = orderPt.getPtStitchPlcCd();
		if(ptStitchPlcCd != null && !"".equals(ptStitchPlcCd) && !"0002001".equals(orderPt.getPtStitchPlcType())) {
			String[] ptStitchPlcSplit = ptStitchPlcCd.split(regex);
			for (String stitchPlcCode : ptStitchPlcSplit) {
				if("0002101".equals(stitchPlcCode)) {
					optionPantsWashableInfo.setWpStitchModifyPlace1(stitchPlcCode);
				}else if("0002102".equals(stitchPlcCode)) {
					optionPantsWashableInfo.setWpStitchModifyPlace2(stitchPlcCode);
				}else if("0002103".equals(stitchPlcCode)) {
					optionPantsWashableInfo.setWpStitchModifyPlace3(stitchPlcCode);
				}else if("0002104".equals(stitchPlcCode)) {
					optionPantsWashableInfo.setWpStitchModifyPlace4(stitchPlcCode);
				}
			}
		}
		
		//ダブルステッチ
		String ptDblstitchPlcCd = orderPt.getPtDblstitchPlcCd();
		if(ptDblstitchPlcCd != null && !"".equals(ptDblstitchPlcCd)) {
			String[] ptDblstitchPlcSplit = ptDblstitchPlcCd.split(regex);
			for (String dblstitchPlcCode : ptDblstitchPlcSplit) {
				if("0002301".equals(dblstitchPlcCode)) {
					optionPantsWashableInfo.setWpDStitchPlace1(dblstitchPlcCode);
				}else if("0002302".equals(dblstitchPlcCode)) {
					optionPantsWashableInfo.setWpDStitchPlace2(dblstitchPlcCode);
				}else if("0002304".equals(dblstitchPlcCode)) {
					optionPantsWashableInfo.setWpDStitchPlace3(dblstitchPlcCode);
				}
			}
		}
		
		//AMF色指定
		String ptAmfColorPlcCd = orderPt.getPtAmfColorPlcCd();
		String ptAmfColorCd = orderPt.getPtAmfColorCd();
		if(ptAmfColorPlcCd!=null && !"".equals(ptAmfColorPlcCd) && ptAmfColorCd !=null && !"".equals(ptAmfColorCd)) {
			String[] ptAmfColorPlcSplit = ptAmfColorPlcCd.split(regex);
			String[] ptAmfColorSplit = ptAmfColorCd.split(regex);
			ptAmfColorSplit = BaseCheckUtil.placeColorMethod(ptAmfColorPlcSplit.length,ptAmfColorSplit);
			for (int i = 0;i<ptAmfColorPlcSplit.length;i++) {
				if("0002601".equals(ptAmfColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpAmfColorPlace1(ptAmfColorPlcSplit[i]);
					optionPantsWashableInfo.setWpAmfColor1(ptAmfColorSplit[i]);
				}else if("0002602".equals(ptAmfColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpAmfColorPlace2(ptAmfColorPlcSplit[i]);
					optionPantsWashableInfo.setWpAmfColor2(ptAmfColorSplit[i]);
				}else if("0002603".equals(ptAmfColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpAmfColorPlace3(ptAmfColorPlcSplit[i]);
					optionPantsWashableInfo.setWpAmfColor3(ptAmfColorSplit[i]);
				}else if("0002604".equals(ptAmfColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpAmfColorPlace4(ptAmfColorPlcSplit[i]);
					optionPantsWashableInfo.setWpAmfColor4(ptAmfColorSplit[i]);
				}
			}
		}
		
		//ボタンホール色指定
		String ptBtnholeColorPlcCd = orderPt.getPtBtnholeColorPlcCd();
		String PtBtnholeColorCd = orderPt.getPtBtnholeColorCd();
		if(!"".equals(ptBtnholeColorPlcCd)&&ptBtnholeColorPlcCd!=null&&!"".equals(PtBtnholeColorCd)&&PtBtnholeColorCd!=null) {
			String[] ptBtnholeColorPlcSplit = ptBtnholeColorPlcCd.split(regex);
			String[] PtBtnholeColorSplit = PtBtnholeColorCd.split(regex);
			PtBtnholeColorSplit = BaseCheckUtil.placeColorMethod(ptBtnholeColorPlcSplit.length,PtBtnholeColorSplit);
			for (int i = 0; i < ptBtnholeColorPlcSplit.length; i++) {
				if("0002901".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpBhColorPlace1(ptBtnholeColorPlcSplit[i]);
					optionPantsWashableInfo.setWpBhColor1(PtBtnholeColorSplit[i]);
				}else if("0002902".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpBhColorPlace2(ptBtnholeColorPlcSplit[i]);
					optionPantsWashableInfo.setWpBhColor2(PtBtnholeColorSplit[i]);
				}else if("0002903".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpBhColorPlace3(ptBtnholeColorPlcSplit[i]);
					optionPantsWashableInfo.setWpBhColor3(PtBtnholeColorSplit[i]);
				}else if("0002904".equals(ptBtnholeColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpBhColorPlace4(ptBtnholeColorPlcSplit[i]);
					optionPantsWashableInfo.setWpBhColor4(PtBtnholeColorSplit[i]);
				}
			}
		}
		
		//ボタン付け糸指定
		String ptBtnthreadColorPlcCd = orderPt.getPtBtnthreadColorPlcCd();
		String ptBtnthreadColorCd = orderPt.getPtBtnthreadColorCd();
		if(!"".equals(ptBtnthreadColorPlcCd)&&ptBtnthreadColorPlcCd!=null&&!"".equals(ptBtnthreadColorCd)&&ptBtnthreadColorCd!=null) {
			String[] ptBtnthreadColorPlcSplit = ptBtnthreadColorPlcCd.split(regex);
			String[] ptBtnthreadColorSplit = ptBtnthreadColorCd.split(regex);
			ptBtnthreadColorSplit = BaseCheckUtil.placeColorMethod(ptBtnthreadColorPlcSplit.length,ptBtnthreadColorSplit);
			for (int i = 0; i < ptBtnthreadColorPlcSplit.length; i++) {
				if("0003201".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpByColorPlace1(ptBtnthreadColorPlcSplit[i]);
					optionPantsWashableInfo.setWpByColor1(ptBtnthreadColorSplit[i]);
				}else if("0003202".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpByColorPlace2(ptBtnthreadColorPlcSplit[i]);
					optionPantsWashableInfo.setWpByColor2(ptBtnthreadColorSplit[i]);
				}else if("0003203".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpByColorPlace3(ptBtnthreadColorPlcSplit[i]);
					optionPantsWashableInfo.setWpByColor3(ptBtnthreadColorSplit[i]);
				}else if("0003204".equals(ptBtnthreadColorPlcSplit[i])) {
					optionPantsWashableInfo.setWpByColorPlace4(ptBtnthreadColorPlcSplit[i]);
					optionPantsWashableInfo.setWpByColor4(ptBtnthreadColorSplit[i]);
				}
			}
		}
	}
}
