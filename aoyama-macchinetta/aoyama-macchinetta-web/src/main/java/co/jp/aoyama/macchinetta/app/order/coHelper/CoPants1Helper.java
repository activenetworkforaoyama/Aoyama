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
import co.jp.aoyama.macchinetta.app.order.coinfo.CoAdjustPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.coinfo.CoOptionPantsWashableInfo;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.service.order.TypeSizeService;

public class CoPants1Helper {

	@Inject
	TypeSizeService typeSizeService;

	OrderCoHelper orderCoHelper = new OrderCoHelper();

	public boolean pantsCheck(ResultMessages messages, OrderCoForm orderCoForm, String productCategory, String item,
			Map<String, List<Adjust>> adjustByItem, TypeSizeService typeSizeService) {
		String corPtHemwidthType = orderCoForm.getCoAdjustPantsStandardInfo().getCorPtHemwidthType();
		boolean pantstFlag = false;
		// 標準の場合
		if ("9000101".equals(productCategory)) {
			// PANTS モデル未選択の場合
			CoOptionPantsStandardInfo coOptionPantsStandardInfo = orderCoForm.getCoOptionPantsStandardInfo();
			String opPantsModel = coOptionPantsStandardInfo.getOpPantsModel();
			if ("".equals(opPantsModel) || null == opPantsModel) {
				messages.add("E031", "PANTS モデル");
				pantstFlag = true;
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
						&& BaseCheckUtil.isEmpty(opBeltLoopPlace5) && BaseCheckUtil.isEmpty(opBeltLoopPlace6)) {
					messages.add("E033", "PANTS ベルトループ");
					pantstFlag = true;
				}
				if (BaseCheckUtil.isEmpty(opBeltLoopPlace7) && "NZ01".equals(opPantsModel)) {
					messages.add("E033", "PANTS ベルトループ");
					pantstFlag = true;
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
					pantstFlag = true;
				}
			}
			// PANTS ダブルステッチ
			String opDStitch = coOptionPantsStandardInfo.getOpDStitch();
			if (OptionCodeKeys.PT_0002202.equals(opDStitch)) {
				String opDStitchPlace1 = coOptionPantsStandardInfo.getOpDStitchPlace1();
				String opDStitchPlace2 = coOptionPantsStandardInfo.getOpDStitchPlace2();
				String opDStitchPlace3 = coOptionPantsStandardInfo.getOpDStitchPlace3();
				String opDStitchPlace4 = coOptionPantsStandardInfo.getOpDStitchPlace4();

				if (BaseCheckUtil.isEmpty(opDStitchPlace1) && BaseCheckUtil.isEmpty(opDStitchPlace2)
						&& BaseCheckUtil.isEmpty(opDStitchPlace3) && BaseCheckUtil.isEmpty(opDStitchPlace4)) {
					messages.add("E033", "PANTS ダブルステッチ");
					pantstFlag = true;
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
					pantstFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(opAmfColorPlace1) && BaseCheckUtil.isEmpty(opAmfColor1)
						|| BaseCheckUtil.isNotEmpty(opAmfColorPlace2) && BaseCheckUtil.isEmpty(opAmfColor2)
						|| BaseCheckUtil.isNotEmpty(opAmfColorPlace3) && BaseCheckUtil.isEmpty(opAmfColor3)
						|| BaseCheckUtil.isNotEmpty(opAmfColorPlace4) && BaseCheckUtil.isEmpty(opAmfColor4)) {
					messages.add("E032", "PANTS AMF色指定");
					pantstFlag = true;
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
					pantstFlag = true;
				}

				if (BaseCheckUtil.isNotEmpty(opBhColorPlace1) && BaseCheckUtil.isEmpty(opBhColor1)
						|| BaseCheckUtil.isNotEmpty(opBhColorPlace2) && BaseCheckUtil.isEmpty(opBhColor2)
						|| BaseCheckUtil.isNotEmpty(opBhColorPlace3) && BaseCheckUtil.isEmpty(opBhColor3)
						|| BaseCheckUtil.isNotEmpty(opBhColorPlace4) && BaseCheckUtil.isEmpty(opBhColor4)) {
					messages.add("E032", "PANTS ボタンホール色指定");
					pantstFlag = true;
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
					pantstFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(opByColorPlace1) && BaseCheckUtil.isEmpty(opByColor1)
						|| BaseCheckUtil.isNotEmpty(opByColorPlace2) && BaseCheckUtil.isEmpty(opByColor2)
						|| BaseCheckUtil.isNotEmpty(opByColorPlace3) && BaseCheckUtil.isEmpty(opByColor3)
						|| BaseCheckUtil.isNotEmpty(opByColorPlace4) && BaseCheckUtil.isEmpty(opByColor4)) {
					messages.add("E032", "PANTS ボタン付け糸指定");
					pantstFlag = true;
				}
			}
			// PANTS タキシードの場合
		} else if ("9000102".equals(productCategory)) {
			// PANTS モデル未選択の場合
			CoOptionPantsTuxedoInfo coOptionPantsTuxedoInfo = orderCoForm.getCoOptionPantsTuxedoInfo();
			String tpPantsModel = coOptionPantsTuxedoInfo.getTpPantsModel();
			if ("".equals(tpPantsModel) || null == tpPantsModel) {
				messages.add("E031", "PANTS モデル");
				pantstFlag = true;
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
						&& BaseCheckUtil.isEmpty(tpBeltLoopPlace5) && BaseCheckUtil.isEmpty(tpBeltLoopPlace6)) {
					messages.add("E033", "PANTS ベルトループ");
					pantstFlag = true;
				}

				if (BaseCheckUtil.isEmpty(tpBeltLoopPlace7) && "NZ01".equals(tpPantsModel)) {
					messages.add("E033", "PANTS ベルトループ");
					pantstFlag = true;
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
					pantstFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(tpBhColorPlace1) && BaseCheckUtil.isEmpty(tpBhColor1)
						|| BaseCheckUtil.isNotEmpty(tpBhColorPlace2) && BaseCheckUtil.isEmpty(tpBhColor2)
						|| BaseCheckUtil.isNotEmpty(tpBhColorPlace3) && BaseCheckUtil.isEmpty(tpBhColor3)
						|| BaseCheckUtil.isNotEmpty(tpBhColorPlace4) && BaseCheckUtil.isEmpty(tpBhColor4)) {
					messages.add("E032", "PANTS ボタンホール色指定");
					pantstFlag = true;
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
					pantstFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(tpByColorPlace1) && BaseCheckUtil.isEmpty(tpByColor1)
						|| BaseCheckUtil.isNotEmpty(tpByColorPlace2) && BaseCheckUtil.isEmpty(tpByColor2)
						|| BaseCheckUtil.isNotEmpty(tpByColorPlace3) && BaseCheckUtil.isEmpty(tpByColor3)
						|| BaseCheckUtil.isNotEmpty(tpByColorPlace4) && BaseCheckUtil.isEmpty(tpByColor4)) {
					messages.add("E032", "PANTS ボタン付け糸指定");
					pantstFlag = true;
				}
			}
		} else if ("9000103".equals(productCategory)) {
			// PANTS モデル未選択の場合
			CoOptionPantsWashableInfo coOptionPantsWashableInfo = orderCoForm.getCoOptionPantsWashableInfo();
			String wpPantsModel = coOptionPantsWashableInfo.getWpPantsModel();
			if ("".equals(wpPantsModel) || null == wpPantsModel) {
				messages.add("E031", "PANTS モデル");
				pantstFlag = true;
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
						&& BaseCheckUtil.isEmpty(wpBeltLoopPlace5) && BaseCheckUtil.isEmpty(wpBeltLoopPlace6)) {
					messages.add("E033", "PANTS ベルトループ");
					pantstFlag = true;
				}

				if (BaseCheckUtil.isEmpty(wpBeltLoopPlace7) && "NZ01".equals(wpPantsModel)) {
					messages.add("E033", "PANTS ベルトループ");
					pantstFlag = true;
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
					pantstFlag = true;
				}
			}
			// PANTS ダブルステッチ
			String wpDStitch = coOptionPantsWashableInfo.getWpDStitch();
			if (OptionCodeKeys.PT_0002202.equals(wpDStitch)) {
				String wpDStitchPlace1 = coOptionPantsWashableInfo.getWpDStitchPlace1();
				String wpDStitchPlace2 = coOptionPantsWashableInfo.getWpDStitchPlace2();
				String wpDStitchPlace3 = coOptionPantsWashableInfo.getWpDStitchPlace3();
				String wpDStitchPlace4 = coOptionPantsWashableInfo.getWpDStitchPlace4();
				if (BaseCheckUtil.isEmpty(wpDStitchPlace1) && BaseCheckUtil.isEmpty(wpDStitchPlace2)
						&& BaseCheckUtil.isEmpty(wpDStitchPlace3) && BaseCheckUtil.isEmpty(wpDStitchPlace4)) {
					messages.add("E033", "PANTS ダブルステッチ");
					pantstFlag = true;
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
					pantstFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(wpamfColorPlace1) && BaseCheckUtil.isEmpty(wpamfColor1)
						|| BaseCheckUtil.isNotEmpty(wpamfColorPlace2) && BaseCheckUtil.isEmpty(wpamfColor2)
						|| BaseCheckUtil.isNotEmpty(wpamfColorPlace3) && BaseCheckUtil.isEmpty(wpamfColor3)
						|| BaseCheckUtil.isNotEmpty(wpamfColorPlace4) && BaseCheckUtil.isEmpty(wpamfColor4)) {
					messages.add("E032", "PANTS AMF色指定");
					pantstFlag = true;
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
					pantstFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(wpBhColorPlace1) && BaseCheckUtil.isEmpty(wpBhColor1)
						|| BaseCheckUtil.isNotEmpty(wpBhColorPlace2) && BaseCheckUtil.isEmpty(wpBhColor2)
						|| BaseCheckUtil.isNotEmpty(wpBhColorPlace3) && BaseCheckUtil.isEmpty(wpBhColor3)
						|| BaseCheckUtil.isNotEmpty(wpBhColorPlace4) && BaseCheckUtil.isEmpty(wpBhColor4)) {
					messages.add("E032", "PANTS ボタンホール色指定");
					pantstFlag = true;
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
					pantstFlag = true;
				}
				if (BaseCheckUtil.isNotEmpty(wpByColorPlace1) && BaseCheckUtil.isEmpty(wpByColor1)
						|| BaseCheckUtil.isNotEmpty(wpByColorPlace2) && BaseCheckUtil.isEmpty(wpByColor2)
						|| BaseCheckUtil.isNotEmpty(wpByColorPlace3) && BaseCheckUtil.isEmpty(wpByColor3)
						|| BaseCheckUtil.isNotEmpty(wpByColorPlace4) && BaseCheckUtil.isEmpty(wpByColor4)) {
					messages.add("E032", "PANTS  ボタン付け糸指定");
					pantstFlag = true;
				}
			}
		}

		// 補正
		CoAdjustPantsStandardInfo coAdjustPantsStandardInfo = orderCoForm.getCoAdjustPantsStandardInfo();
		if (coAdjustPantsStandardInfo == null) {
			messages.add("E031", "PANTSサイズ");
			pantstFlag = true;
		} else {
			String sizeFigure = coAdjustPantsStandardInfo.getSizeFigure();
			if ("".equals(sizeFigure) || null == sizeFigure) {
				messages.add("E031", "PANTSサイズ体型");
				pantstFlag = true;
			}
			String sizeNumber = coAdjustPantsStandardInfo.getSizeNumber();
			if ("".equals(sizeNumber) || null == sizeNumber) {
				messages.add("E031", "PANTSサイズ号数");
				pantstFlag = true;
			}
			String corPtLeftinseamGross = coAdjustPantsStandardInfo.getCorPtLeftinseamGross();

			boolean falg = BaseCheckUtil.GrossCompareTo(corPtLeftinseamGross, messages, "PANTS（1本目）左股下");
			if (falg) {
				pantstFlag = true;
			}
			String corPtRightinseamGross = coAdjustPantsStandardInfo.getCorPtRightinseamGross();
			falg = BaseCheckUtil.GrossCompareTo(corPtRightinseamGross, messages, "PANTS（1本目）右股下");
			if (falg) {
				pantstFlag = true;
			}

			if (BaseCheckUtil.isNotEmpty(sizeFigure) && BaseCheckUtil.isNotEmpty(sizeNumber)) {
				String corPtWaistSize = coAdjustPantsStandardInfo.getCorPtWaistSize();
				if ("".equals(corPtWaistSize) || "0".equals(corPtWaistSize) || corPtWaistSize == null) {
					messages.add("E034", "PANTS（1本目）のウエスト修正");
					pantstFlag = true;
				}

				String corPtHipSize = coAdjustPantsStandardInfo.getCorPtHipSize();
				if ("".equals(corPtHipSize) || "0".equals(corPtHipSize) || corPtHipSize == null) {
					messages.add("E034", "PANTS（1本目）のヒップ修正");
					pantstFlag = true;
				}

				String corPtThighSize = coAdjustPantsStandardInfo.getCorPtThighSize();
				if ("".equals(corPtThighSize) || "0".equals(corPtThighSize) || corPtThighSize == null) {
					messages.add("E034", "PANTS（1本目）のワタリ幅修正");
					pantstFlag = true;
				}

				String corPtHemwidthSize = coAdjustPantsStandardInfo.getCorPtHemwidthSize();
				if ("".equals(corPtHemwidthSize) || "0".equals(corPtHemwidthSize) || corPtHemwidthSize == null) {
					messages.add("E034", "PANTS（1本目）の裾幅");
					pantstFlag = true;
				}

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
										pantstFlag = true;
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
										pantstFlag = true;
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
										pantstFlag = true;
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
											messages.add("E035", "PANTS（1本目）のワタリ修正");
											pantstFlag = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return pantstFlag;
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
		List<TypeSizeOptimization> coPtTypeSizeOptimization = orderCoHelper.getCoTypeSizeOptimization(coTypeSizeList);
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
				String corPtWaistSize = typeSizeOptimization.getTypeSize();
				adjustPtStandardValue.put("corPtWaistSize", corPtWaistSize);
			}
			// ヒップ
			else if ("05".equals(typeSizeOptimization.getAdjustClass())) {
				String corPtHipSize = typeSizeOptimization.getTypeSize();
				adjustPtStandardValue.put("corPtHipSize", corPtHipSize);
			}
			// ワタリ修正
			else if ("07".equals(typeSizeOptimization.getAdjustClass())) {
				String corPtThighwidthSize = null;
				if ("0000101".equals(ptTackValue)) {
					corPtThighwidthSize = typeSizeOptimization.getTypeSize();
				} else if ("0000102".equals(ptTackValue)) {
					corPtThighwidthSize = typeSizeOptimization.getTypeSize1Outtack();
				} else if ("0000103".equals(ptTackValue)) {
					corPtThighwidthSize = typeSizeOptimization.getTypeSize1Intack();
				} else if ("0000104".equals(ptTackValue)) {
					corPtThighwidthSize = typeSizeOptimization.getTypeSize2Outtack();
				} else if ("0000105".equals(ptTackValue)) {
					corPtThighwidthSize = typeSizeOptimization.getTypeSize2Intack();
				}

				adjustPtStandardValue.put("corPtThighwidthSize", corPtThighwidthSize);
			}
			// 裾幅修正
			else if ("08".equals(typeSizeOptimization.getAdjustClass())) {
				String corPtHemwidthSize = typeSizeOptimization.getTypeSize();
				adjustPtStandardValue.put("corPtHemwidthSize", corPtHemwidthSize);
			}
		}
		return adjustPtStandardValue;
	}
}