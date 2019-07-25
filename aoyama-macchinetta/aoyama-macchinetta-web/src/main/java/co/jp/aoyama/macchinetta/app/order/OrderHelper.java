package co.jp.aoyama.macchinetta.app.order;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dozer.util.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import co.jp.aoyama.macchinetta.app.order.enums.AdjustClassEnum;
import co.jp.aoyama.macchinetta.app.order.enums.ItemClassStandardEnum;
import co.jp.aoyama.macchinetta.app.order.enums.ItemClassTuxedoEnum;
import co.jp.aoyama.macchinetta.app.order.enums.ItemClassWashableEnum;
import co.jp.aoyama.macchinetta.app.order.enums.ItemTypeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.adjust.JacketAdjustCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.adjust.Pants2AdjustCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.adjust.PantsAdjustCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.coat.CoatOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionDetailStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionTuxedoCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionTuxedoColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionWashableCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionWashableColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionDetailStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionTuxedoCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionTuxedoColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionWashableCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionWashableColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionTuxedoCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionTuxedoColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionWashableCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionWashableColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.shirt.ShirtOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.info.AdjustGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletWashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketWashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsWashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionShirtStandardInfo;
import co.jp.aoyama.macchinetta.domain.model.Adjust;
import co.jp.aoyama.macchinetta.domain.model.Item;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Model;
import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;
import co.jp.aoyama.macchinetta.domain.model.OptionBranch;
import co.jp.aoyama.macchinetta.domain.model.OptionBranchDetail;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.model.OrderPrice;
import co.jp.aoyama.macchinetta.domain.model.SizeFigure;
import co.jp.aoyama.macchinetta.domain.model.SizeNumber;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;
import co.jp.aoyama.macchinetta.domain.model.Yield;

public class OrderHelper {

	private static final Logger logger = LoggerFactory.getLogger(OrderHelper.class);

	/**
	 * 標準のオプション内容処理
	 * 
	 * @param standardOptionList
	 * @param orderForm
	 */
	public void getOptionStandardData(List<OptionBranch> standardOptionList, OrderForm orderForm) throws Exception {
		try {

			// ITEMの値
			ItemClassStandardEnum[] itemClassStandardEnum = ItemClassStandardEnum.values();
			// クラス名
			String classPath = "";
			// ITEMコードの種類
			String subItemCodeType = "";
			for (ItemClassStandardEnum one : itemClassStandardEnum) {
				// サブアイテムコード
				subItemCodeType = one.getKey();
				classPath = ItemClassStandardEnum.getValue(one.getKey());
				if (!classPath.isEmpty()) {
					// 標準可のデーター
					optionStandardData(classPath, orderForm, subItemCodeType, standardOptionList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * タキシードのオプション内容処理
	 * 
	 * @param tuxedoOptionList
	 * @param orderForm
	 */
	public void getOptionTuxedoData(List<OptionBranch> tuxedoOptionList, OrderForm orderForm) {
		try {

			// ITEMの値
			ItemClassTuxedoEnum[] itemClassTuxedoEnum = ItemClassTuxedoEnum.values();
			// クラス名
			String classPath = "";
			// ITEMコードの種類
			String subItemCodeType = "";
			for (ItemClassTuxedoEnum one : itemClassTuxedoEnum) {

				subItemCodeType = one.getKey();
				classPath = ItemClassTuxedoEnum.getValue(one.getKey());
				if (!classPath.isEmpty()) {
					// タキシード可のデーター
					optionDataTuxedo(classPath, subItemCodeType, orderForm, tuxedoOptionList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * ウォッシャブルのオプション内容処理
	 * 
	 * @param washableOptionList
	 * @param orderForm
	 */
	public void getOptionWashableData(List<OptionBranch> washableOptionList, OrderForm orderForm) {
		try {

			// ITEMの値
			ItemClassWashableEnum[] itemClassWashableEnum = ItemClassWashableEnum.values();
			// クラス名
			String classPath = "";
			// ITEMコードの種類
			String itemCodeType = "";
			for (ItemClassWashableEnum one : itemClassWashableEnum) {

				itemCodeType = one.getKey();
				classPath = ItemClassWashableEnum.getValue(one.getKey());
				if (!classPath.isEmpty()) {
					// ウォッシャブル可のデーター
					optionDataWashable(classPath, itemCodeType, orderForm, washableOptionList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 列挙によって標準のオプションデーターを設定
	 * 
	 * @param classPath
	 * @param orderForm
	 * @param subItemCode
	 * @param standardOptionList
	 * @throws Exception
	 */
	public void optionStandardData(String classPath, OrderForm orderForm, String subItemCode,
			List<OptionBranch> standardOptionList) throws Exception {
		try {
			// getClass
			Class<?> cls = Class.forName(classPath);

			OptionJacketStandardInfo optionJacketStandardInfo = new OptionJacketStandardInfo();
			OptionPantsStandardInfo optionStandardPantsInfo = new OptionPantsStandardInfo();
			OptionPants2StandardInfo optionPants2StandardInfo = new OptionPants2StandardInfo();
			OptionGiletStandardInfo optionGiletStandardInfo = new OptionGiletStandardInfo();
			OptionShirtStandardInfo optionShirtStandardInfo = new OptionShirtStandardInfo();
			OptionCoatStandardInfo optionCoatStandardInfo = new OptionCoatStandardInfo();

			List<OptionBranch> ptStandardList = new ArrayList<OptionBranch>();
			List<OptionBranch> jkStandardList = new ArrayList<OptionBranch>();
			List<OptionBranch> glStandardList = new ArrayList<OptionBranch>();
			List<OptionBranch> shStandardList = new ArrayList<OptionBranch>();
			List<OptionBranch> coStandardList = new ArrayList<OptionBranch>();
			List<OptionBranch> pt2StandardList = new ArrayList<OptionBranch>();

			for (OptionBranch optionBranch : standardOptionList) {
				// SUIT
				if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_SUIT.getKey())) {

				}
				// JACKET
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
					jkStandardList.add(optionBranch);
				}
				// PANTS
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
					ptStandardList.add(optionBranch);
				}
				// GILET
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
					glStandardList.add(optionBranch);
				}
				// SHIRT
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_SHIRTS.getKey())) {
					shStandardList.add(optionBranch);
				}
				// COAT
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_COAT.getKey())) {
					coStandardList.add(optionBranch);
				}
				// 2PANTS
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
					pt2StandardList.add(optionBranch);
				}
			}

			if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_SUIT.getKey())) {

			}
			// JACKET
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				if (!jkStandardList.isEmpty()) {
					JacketOptionStandardCodeEnum[] jacketOptionStandardEnum = JacketOptionStandardCodeEnum.values();
					for (JacketOptionStandardCodeEnum one : jacketOptionStandardEnum) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, jkStandardList, cls, optionJacketStandardInfo);
					}
					JacketOptionStandardColorEnum[] jkOptionColors = JacketOptionStandardColorEnum.values();
					for (JacketOptionStandardColorEnum one : jkOptionColors) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢色コード ⇒ オプション選択肢色名
						optionBranchColorData(codeVules, jkStandardList, cls, optionJacketStandardInfo);
					}
					orderForm.setOptionJacketStandardInfo(optionJacketStandardInfo);
				}
			}
			// PANTS
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				if (!ptStandardList.isEmpty()) {
					PantsOptionStandardCodeEnum[] pantsOptionCodes = PantsOptionStandardCodeEnum.values();
					for (PantsOptionStandardCodeEnum one : pantsOptionCodes) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, ptStandardList, cls, optionStandardPantsInfo);
					}
					PantsOptionStandardColorEnum[] pantsOptionColors = PantsOptionStandardColorEnum.values();
					for (PantsOptionStandardColorEnum one : pantsOptionColors) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢色コード ⇒ オプション選択肢色名
						optionBranchColorData(codeVules, ptStandardList, cls, optionStandardPantsInfo);
					}
					orderForm.setOptionPantsStandardInfo(optionStandardPantsInfo);
				}
			}
			// GILET
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				if (!glStandardList.isEmpty()) {
					GiletOptionStandardCodeEnum[] giletOptionCodes = GiletOptionStandardCodeEnum.values();
					for (GiletOptionStandardCodeEnum one : giletOptionCodes) {

						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, glStandardList, cls, optionGiletStandardInfo);
					}
					GiletOptionStandardColorEnum[] giletOptionColors = GiletOptionStandardColorEnum.values();
					for (GiletOptionStandardColorEnum one : giletOptionColors) {

						String[] codeVules = one.toString().split(",");
						// オプション選択肢色コード ⇒ オプション選択肢色名
						optionBranchColorData(codeVules, glStandardList, cls, optionGiletStandardInfo);
					}
					orderForm.setOptionGiletStandardInfo(optionGiletStandardInfo);
				}
			}
			// SHIRT
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_SHIRTS.getKey())) {
				if (!shStandardList.isEmpty()) {
					ShirtOptionStandardCodeEnum[] shirtOptionCodeEnum = ShirtOptionStandardCodeEnum.values();
					for (ShirtOptionStandardCodeEnum one : shirtOptionCodeEnum) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, shStandardList, cls, optionShirtStandardInfo);
					}
					orderForm.setOptionShirtStandardInfo(optionShirtStandardInfo);
				}
			}
			// COAT
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_COAT.getKey())) {
				if (!coStandardList.isEmpty()) {
					CoatOptionStandardCodeEnum[] coatOptionCodeEnum = CoatOptionStandardCodeEnum.values();
					for (CoatOptionStandardCodeEnum one : coatOptionCodeEnum) {

						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, coStandardList, cls, optionCoatStandardInfo);
					}
					orderForm.setOptionCoatStandardInfo(optionCoatStandardInfo);
				}
			}
			// 2PANTS
			else if (subItemCode.equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				if (!pt2StandardList.isEmpty()) {
					Pants2OptionStandardCodeEnum[] pants2OptionStandardCodeEnum = Pants2OptionStandardCodeEnum.values();
					for (Pants2OptionStandardCodeEnum one : pants2OptionStandardCodeEnum) {

						String[] codeVules = one.toString().split(",");
						// オプション選択肢コード ⇒ オプション選択肢名
						optionBranchNameData(codeVules, pt2StandardList, cls, optionPants2StandardInfo);
					}
					orderForm.setOptionPants2StandardInfo(optionPants2StandardInfo);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 列挙によってタキシードのオプションデーターを設定
	 * 
	 * @param classPath
	 * @param itemCodeType
	 * @param orderForm
	 * @param tuxedoOptionList
	 */
	private void optionDataTuxedo(String classPath, String itemCodeType, OrderForm orderForm,
			List<OptionBranch> tuxedoOptionList) {
		try {

			Class<?> cls = Class.forName(classPath);

			OptionPantsTuxedoInfo optionPantsTuxedoInfo = new OptionPantsTuxedoInfo();
			OptionJacketTuxedoInfo optionJacketTuxedoInfo = new OptionJacketTuxedoInfo();
			OptionGiletTuxedoInfo optionGiletTuxedoInfo = new OptionGiletTuxedoInfo();

			List<OptionBranch> pantsTuxedoList = new ArrayList<OptionBranch>();
			List<OptionBranch> jkTuxedoList = new ArrayList<OptionBranch>();
			List<OptionBranch> giletTuxedoList = new ArrayList<OptionBranch>();

			for (OptionBranch optionBranch : tuxedoOptionList) {
				// JACKET
				if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
					jkTuxedoList.add(optionBranch);
				}
				// PANTS
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
					pantsTuxedoList.add(optionBranch);
				}
				// GILET
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
					giletTuxedoList.add(optionBranch);
				}
			}

			// JACKET
			if (itemCodeType.equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				JacketOptionTuxedoCodeEnum[] jacketOptionTuxedoEnum = JacketOptionTuxedoCodeEnum.values();
				for (JacketOptionTuxedoCodeEnum one : jacketOptionTuxedoEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					optionBranchNameData(codeVules, jkTuxedoList, cls, optionJacketTuxedoInfo);
				}
				JacketOptionTuxedoColorEnum[] jacketOptionTuxdoColors = JacketOptionTuxedoColorEnum.values();
				for (JacketOptionTuxedoColorEnum one : jacketOptionTuxdoColors) {
					String[] codeVules = one.toString().split(",");
					// オプション選択肢色コード ⇒ オプション選択肢色名
					optionBranchColorData(codeVules, jkTuxedoList, cls, optionJacketTuxedoInfo);
				}
				orderForm.setOptionJacketTuxedoInfo(optionJacketTuxedoInfo);
			}
			// PANTS
			else if (itemCodeType.equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				PantsOptionTuxedoCodeEnum[] pantsOptionTuxedoEnum = PantsOptionTuxedoCodeEnum.values();
				for (PantsOptionTuxedoCodeEnum one : pantsOptionTuxedoEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					optionBranchNameData(codeVules, pantsTuxedoList, cls, optionPantsTuxedoInfo);
				}
				PantsOptionTuxedoColorEnum[] pantsOptionTuxdoColors = PantsOptionTuxedoColorEnum.values();
				for (PantsOptionTuxedoColorEnum one : pantsOptionTuxdoColors) {
					String[] codeVules = one.toString().split(",");
					// オプション選択肢色コード ⇒ オプション選択肢色名
					optionBranchColorData(codeVules, pantsTuxedoList, cls, optionPantsTuxedoInfo);
				}
				orderForm.setOptionPantsTuxedoInfo(optionPantsTuxedoInfo);
			}
			// GILET
			else if (itemCodeType.equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				GiletOptionTuxedoCodeEnum[] giletOptionTuxedoCodeEnum = GiletOptionTuxedoCodeEnum.values();
				for (GiletOptionTuxedoCodeEnum one : giletOptionTuxedoCodeEnum) {
					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					optionBranchNameData(codeVules, giletTuxedoList, cls, optionGiletTuxedoInfo);
				}
				GiletOptionTuxedoColorEnum[] giletOptionTuxedoColorEnum = GiletOptionTuxedoColorEnum.values();
				for (GiletOptionTuxedoColorEnum one : giletOptionTuxedoColorEnum) {
					String[] codeVules = one.toString().split(",");
					// オプション選択肢色コード ⇒ オプション選択肢色名
					optionBranchColorData(codeVules, giletTuxedoList, cls, optionGiletTuxedoInfo);
				}
				orderForm.setOptionGiletTuxedoInfo(optionGiletTuxedoInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 列挙によってウォッシャブルのオプションデーターを設定
	 * 
	 * @param classPath
	 * @param itemCodeType
	 * @param orderForm
	 * @param washableOptionList
	 */
	private void optionDataWashable(String classPath, String itemCodeType, OrderForm orderForm,
			List<OptionBranch> washableOptionList) {
		try {

			Class<?> cls = Class.forName(classPath);

			OptionPantsWashableInfo optionPantsWashableInfo = new OptionPantsWashableInfo();
			OptionJacketWashableInfo optionJacketWashableInfo = new OptionJacketWashableInfo();
			OptionGiletWashableInfo optionGiletWashableInfo = new OptionGiletWashableInfo();

			List<OptionBranch> jkWashableList = new ArrayList<OptionBranch>();
			List<OptionBranch> ptWashableList = new ArrayList<OptionBranch>();
			List<OptionBranch> glWashableList = new ArrayList<OptionBranch>();

			for (OptionBranch optionBranch : washableOptionList) {
				// JACKET
				if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
					jkWashableList.add(optionBranch);
				}
				// PANTS
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
					ptWashableList.add(optionBranch);
				}
				// GILET
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
					glWashableList.add(optionBranch);
				}
			}

			// JACKET
			if (itemCodeType.equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				JacketOptionWashableCodeEnum[] jkOptionCodes = JacketOptionWashableCodeEnum.values();
				for (JacketOptionWashableCodeEnum one : jkOptionCodes) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					optionBranchNameData(codeVules, jkWashableList, cls, optionJacketWashableInfo);
				}
				JacketOptionWashableColorEnum[] jkOptionWashabiColors = JacketOptionWashableColorEnum.values();
				for (JacketOptionWashableColorEnum one : jkOptionWashabiColors) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢色コード ⇒ オプション選択肢色名
					optionBranchColorData(codeVules, jkWashableList, cls, optionJacketWashableInfo);
				}
				orderForm.setOptionJacketWashableInfo(optionJacketWashableInfo);
			}
			// PANTS
			else if (itemCodeType.equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				PantsOptionWashableCodeEnum[] pantsOptionCodes = PantsOptionWashableCodeEnum.values();
				for (PantsOptionWashableCodeEnum one : pantsOptionCodes) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					optionBranchNameData(codeVules, ptWashableList, cls, optionPantsWashableInfo);
				}
				PantsOptionWashableColorEnum[] pantsOptionWashabiColors = PantsOptionWashableColorEnum.values();
				for (PantsOptionWashableColorEnum one : pantsOptionWashabiColors) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢色コード ⇒ オプション選択肢色名
					optionBranchColorData(codeVules, ptWashableList, cls, optionPantsWashableInfo);
				}
				orderForm.setOptionPantsWashableInfo(optionPantsWashableInfo);
			}
			// GILET
			else if (itemCodeType.equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				GiletOptionWashableCodeEnum[] giletOptionWashabiCodeEnum = GiletOptionWashableCodeEnum.values();
				for (GiletOptionWashableCodeEnum one : giletOptionWashabiCodeEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					optionBranchNameData(codeVules, glWashableList, cls, optionGiletWashableInfo);
				}
				GiletOptionWashableColorEnum[] giletOptionWashabiColorEnum = GiletOptionWashableColorEnum.values();
				for (GiletOptionWashableColorEnum one : giletOptionWashabiColorEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢色コード ⇒ オプション選択肢色名
					optionBranchColorData(codeVules, glWashableList, cls, optionGiletWashableInfo);
				}
				orderForm.setOptionGiletWashableInfo(optionGiletWashableInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * オプション選択肢コードとオプション選択肢名を設定する
	 * 
	 * @param codeVules
	 * @param optionBranchList
	 * @param cls
	 * @param obj
	 */
	private void optionBranchNameData(String[] codeVules, List<OptionBranch> optionBranchList, Class<?> cls,
			Object obj) {
		// 選択肢名Map
		Map<String, String> optionBranchNameMap = new LinkedHashMap<String, String>();

		for (OptionBranch detail : optionBranchList) {
			// 列挙のkeyがオプションコードの場合
			if (codeVules[0].equals(detail.getOptionCode())) {
				optionBranchNameMap.put(detail.getOptionBranchCode(), detail.getOptionBranchName());
			}
		}
		// オプションコード対応方法を取得
		Method myMethod = getMethod(cls, codeVules[1]);
		Object[] args = { optionBranchNameMap };
		if (myMethod != null) {
			ReflectionUtils.invoke(myMethod, obj, args);
		}

	}

	/**
	 * オプション選択肢色コードとオプション選択肢色名を設定する
	 * 
	 * @param codeVules
	 * @param optionBranchList
	 * @param cls
	 * @param obj
	 */
	private void optionBranchColorData(String[] codeVules, List<OptionBranch> optionBranchList, Class<?> cls,
			Object obj) {
		// 選択肢名Map
		Map<String, String> optionBranchNameMap = new LinkedHashMap<String, String>();

		for (OptionBranch detail : optionBranchList) {
			if (codeVules[0].equals(detail.getOptionCode())) {
				optionBranchNameMap.put(detail.getOptionBranchCode(), detail.getOptionBranchName());
			}
		}
		// get OptionCode method
		Method myMethod = getMethod(cls, codeVules[1]);
		Object[] args = { optionBranchNameMap };
		if (myMethod != null) {
			// use OptionCode method
			ReflectionUtils.invoke(myMethod, obj, args);
		}

	}

	/**
	 * オプション選択肢とオプション選択肢詳細の料金を取得
	 * 
	 * @param priceList
	 * @return
	 */
	public List<OrderCodePrice> optionBranchPriceData(List<OrderPrice> priceList) {

		// オプション価格List
		List<OrderCodePrice> optionCodePriceList = new ArrayList<OrderCodePrice>();

		if (priceList.size() > 0) {

			for (OrderPrice detail : priceList) {

				OrderCodePrice price = new OrderCodePrice();
				// オプション選択肢:item_code
				String branchItemCode = detail.getBranchItemCode();
				// オプション選択肢:sub_item_code
				String branchSubItemCode = detail.getBranchSubItemCode();
				// オプション選択肢:model_code
				String branchModelCode = detail.getBranchModelCode();
				// オプション選択肢:option_code
				String branchOptionCode = detail.getBranchOptionCode();
				// オプション選択肢:option_branch_code
				String optinBranchCode = detail.getOptinBranchCode();

				String key = branchItemCode.concat(branchSubItemCode).concat(branchModelCode).concat(branchOptionCode)
						.concat(optinBranchCode);
				// branchItemCode + branchSubItemCode + branchModelCode + branchOptionCode +
				// optinBranchCode;

				price.setOrderKeyCode(key);
				price.setOrderBranchPrice(detail.getOptionBranchPrice().toString());
				price.setOrderBranchDoublePrice(detail.getOptionBranchDoublePrice().toString());

				// オプション選択肢詳細:item_code
				String detailItemCode = detail.getDetailItemCode();
				// オプション選択肢詳細:sub_item_code
				String detailSubItemCode = detail.getDetailSubItemCode();
				// オプション選択肢詳細:option_code
				String detailOptionCode = detail.getDetailOptionCode();
				// オプション選択肢詳細:option_branch_code
				String detailOptionBranchCode = detail.getDetailOptionBranchCode();
				// オプション選択肢詳細:option_branch_detail_code
				String optionBranchDetailCode = detail.getOptionBranchDetailCode();

				if (detailItemCode != null && detailSubItemCode != null && detailOptionCode != null
						&& detailOptionBranchCode != null && optionBranchDetailCode != null) {

					String detailKey = detailItemCode.concat(detailSubItemCode).concat(branchModelCode)
							.concat(detailOptionCode).concat(detailOptionBranchCode).concat(optionBranchDetailCode);

//					detailItemCode + detailSubItemCode + branchModelCode + detailOptionCode + detailOptionBranchCode
//							+ optionBranchDetailCode;

					price.setOrderDetailKeyCode(detailKey);
					price.setOrderBranchDetailPrice(detail.getDetailBranchPrice().toString());
					price.setOrderBranchDetailDoublePrice(detail.getDetailBranchDoublePrice().toString());
				}

				optionCodePriceList.add(price);
			}

		}
		return optionCodePriceList;

	}

	/**
	 * クラスと列挙の方法名によって、方法を取得
	 * 
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	private Method getMethod(Class<?> clazz, String methodName) {
		Method[] methods = clazz.getMethods();
		Method result = null;
		for (Method method : methods) {

			if (method.getName().equals(methodName)) {
				result = method;
				break;
			}
		}
		return result;
	}

	/**
	 * 素材品番を処理
	 * 
	 * @param buttonsList
	 * @return
	 */
	public LinkedHashMap<String, String> getButtons(List<OptionBranchDetail> buttonsList) {
		LinkedHashMap<String, String> buttonsMap = new LinkedHashMap<String, String>();
		for (OptionBranchDetail optionBranchDetail : buttonsList) {
			buttonsMap.put(optionBranchDetail.getOptionBranchDetailCode(),
					optionBranchDetail.getOptionBranchDetailName());
		}
		return buttonsMap;
	}

	/**
	 * 補正の体型と号数を取得
	 * 
	 * @param figureList
	 * @param numberList
	 * @param orderForm
	 */
	public void getFigureNumberMap(List<SizeFigure> figureList, List<SizeNumber> numberList, OrderForm orderForm) {

		LinkedHashMap<String, String> jkFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> ptFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> glFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> pt2FigureMap = new LinkedHashMap<String, String>();

		// 体型
		for (SizeFigure sizeFigure : figureList) {
			// JACKET
			if (sizeFigure.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				jkFigureMap.put("", "選択　　　");
				// jkFigureMap.put(sizeFigure.getFigure(), sizeFigure.getFigure());
			}
			// PANTS
			else if (sizeFigure.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				ptFigureMap.put("", "選択　　　");
				// ptFigureMap.put(sizeFigure.getFigure(), sizeFigure.getFigure());
			}
			// GILET
			else if (sizeFigure.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				glFigureMap.put("", "選択　　　");
				// glFigureMap.put(sizeFigure.getFigure(), sizeFigure.getFigure());
			}
			// 2PANTS
			else if (sizeFigure.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				pt2FigureMap.put("", "選択　　　");
				// pt2FigureMap.put(sizeFigure.getFigure(), sizeFigure.getFigure());
			}
		}

		// 号数
		LinkedHashMap<String, String> jkNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> ptNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> glNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> pt2NumberMap = new LinkedHashMap<String, String>();

		for (SizeNumber sizeNumber : numberList) {
			// JACKET
			if (sizeNumber.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				jkNumberMap.put("", "選択　　　");
				// jkNumberMap.put(sizeNumber.getSizeNumber(), sizeNumber.getSizeNumber());
			}
			// PANTS
			else if (sizeNumber.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				ptNumberMap.put("", "選択　　　");
				// ptNumberMap.put(sizeNumber.getSizeNumber(), sizeNumber.getSizeNumber());
			}
			// GILET
			else if (sizeNumber.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				glNumberMap.put("", "選択　　　");
				// glNumberMap.put(sizeNumber.getSizeNumber(), sizeNumber.getSizeNumber());
			}
			// 2PANTS
			else if (sizeNumber.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				pt2NumberMap.put("", "選択　　　");
				// pt2NumberMap.put(sizeNumber.getSizeNumber(), sizeNumber.getSizeNumber());
			}
		}

		AdjustJacketStandardInfo adjustJacketStandardInfo = new AdjustJacketStandardInfo();
		adjustJacketStandardInfo.setSizeFigureMap(jkFigureMap);
		adjustJacketStandardInfo.setSizeNumberMap(jkNumberMap);
		orderForm.setAdjustJacketStandardInfo(adjustJacketStandardInfo);

		AdjustPantsStandardInfo adjustPantsStandardInfo = new AdjustPantsStandardInfo();
		adjustPantsStandardInfo.setSizeFigureMap(ptFigureMap);
		adjustPantsStandardInfo.setSizeNumberMap(ptNumberMap);
		orderForm.setAdjustPantsStandardInfo(adjustPantsStandardInfo);

		AdjustGiletStandardInfo adjustGiletStandardInfo = new AdjustGiletStandardInfo();
		adjustGiletStandardInfo.setSizeFigureMap(glFigureMap);
		adjustGiletStandardInfo.setSizeNumberMap(glNumberMap);
		orderForm.setAdjustGiletStandardInfo(adjustGiletStandardInfo);

		AdjustPants2StandardInfo adjustPants2StandardInfo = new AdjustPants2StandardInfo();
		adjustPants2StandardInfo.setSizeFigureMap(pt2FigureMap);
		adjustPants2StandardInfo.setSizeNumberMap(pt2NumberMap);
		orderForm.setAdjustPants2StandardInfo(adjustPants2StandardInfo);
	}

	/**
	 * 型サイズを取得
	 * 
	 * @param poTypeSizeList
	 * @return
	 */
	public List<TypeSizeForm> getPoTypeSizeList(List<TypeSize> poTypeSizeList) {
		List<TypeSizeForm> typeSizeFormList = new ArrayList<TypeSizeForm>();
		for (TypeSize typeSize : poTypeSizeList) {
			TypeSizeForm typeSizeForm = new TypeSizeForm();

			// 型サイズ:sub_item_code
			String subItemCode = typeSize.getSubItemCode();
			// 型サイズ:model_code
			String modelCode = typeSize.getModelCode();
			// 型サイズ:体型
			String figure = typeSize.getFigure();
			// 型サイズ:号数
			String sizeNumber = typeSize.getSizeNumber();
			// 型サイズ:補正区分
			String adjustClass = typeSize.getAdjustClass();

			String key = subItemCode + modelCode + figure + sizeNumber + adjustClass;

			typeSizeForm.setKey(key);
			typeSizeForm.setValue(typeSize.getTypeSize().toString());
			typeSizeForm.setInTack1Value(typeSize.getTypeSize1Intack().toString());
			typeSizeForm.setInTack2Value(typeSize.getTypeSize2Intack().toString());
			typeSizeForm.setOutTack1Value(typeSize.getTypeSize1Outtack().toString());
			typeSizeForm.setOutTack2Value(typeSize.getTypeSize2Outtack().toString());

			typeSizeFormList.add(typeSizeForm);
		}
		return typeSizeFormList;
	}

	/**
	 * 補正の上限値処理
	 * 
	 * @param adjustList
	 * @param orderForm
	 */
	public void getAdjust(List<Adjust> adjustList, OrderForm orderForm) {
		try {

			// ITEMの値
			AdjustClassEnum[] adjustClassEnum = AdjustClassEnum.values();
			// クラス名
			String classPath = "";
			// ITEMコードの種類
			String subItemCodeType = "";
			for (AdjustClassEnum one : adjustClassEnum) {

				subItemCodeType = one.getKey();
				classPath = AdjustClassEnum.getValue(one.getKey());
				if (!classPath.isEmpty()) {
					//
					changeAdjustData(classPath, orderForm, subItemCodeType, adjustList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 列挙によって補正寸上限値と補正寸下限値のMapを取得
	 * 
	 * @param classPath
	 * @param orderForm
	 * @param subItemCodeType
	 * @param adjustList
	 */
	private void changeAdjustData(String classPath, OrderForm orderForm, String subItemCodeType,
			List<Adjust> adjustList) {
		try {

			// getClass
			Class<?> cls = Class.forName(classPath);

			AdjustJacketStandardInfo adjustJacketStandardInfo = orderForm.getAdjustJacketStandardInfo();
			AdjustPantsStandardInfo adjustPantsStandardInfo = orderForm.getAdjustPantsStandardInfo();
			AdjustPants2StandardInfo adjustPants2StandardInfo = orderForm.getAdjustPants2StandardInfo();

			List<Adjust> jkAdjustList = new ArrayList<Adjust>();
			List<Adjust> ptAdjustList = new ArrayList<Adjust>();
			List<Adjust> pt2AdjustList = new ArrayList<Adjust>();

			for (Adjust adjust : adjustList) {
				// JACKET
				if (adjust.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
					jkAdjustList.add(adjust);
				}
				// PANTS
				else if (adjust.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
					ptAdjustList.add(adjust);
				}
				// 2PANTS
				else if (adjust.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
					pt2AdjustList.add(adjust);
				}
			}

			// JACKET
			if (subItemCodeType.equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				JacketAdjustCodeEnum[] jacketAdjustCodeEnum = JacketAdjustCodeEnum.values();
				for (JacketAdjustCodeEnum one : jacketAdjustCodeEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					adjustData(codeVules, jkAdjustList, cls, adjustJacketStandardInfo);
				}
				orderForm.setAdjustJacketStandardInfo(adjustJacketStandardInfo);
			}
			// PANTS
			else if (subItemCodeType.equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				PantsAdjustCodeEnum[] pantsAdjustCodeEnum = PantsAdjustCodeEnum.values();
				for (PantsAdjustCodeEnum one : pantsAdjustCodeEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					adjustData(codeVules, ptAdjustList, cls, adjustPantsStandardInfo);
				}
				orderForm.setAdjustPantsStandardInfo(adjustPantsStandardInfo);
			}
			// 2PANTS
			else if (subItemCodeType.equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				Pants2AdjustCodeEnum[] pants2AdjustCodeEnum = Pants2AdjustCodeEnum.values();
				for (Pants2AdjustCodeEnum one : pants2AdjustCodeEnum) {

					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					adjustData(codeVules, pt2AdjustList, cls, adjustPants2StandardInfo);
				}
				orderForm.setAdjustPants2StandardInfo(adjustPants2StandardInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

	/**
	 * 補正寸上限値と補正寸下限値を設定
	 * 
	 * @param codeVules
	 * @param adjustList
	 * @param cls
	 * @param obj
	 */
	private void adjustData(String[] codeVules, List<Adjust> adjustList, Class<?> cls, Object obj) {
		// max min map
		Map<String, String> adjectMap = new LinkedHashMap<String, String>();

		for (Adjust detail : adjustList) {
			// 列挙のkeyが補正区分の場合
			if (codeVules[0].equals(detail.getAdjusteClass())) {
				adjectMap.put(detail.getAdjusteMin().toString(), detail.getAdjusteMax().toString());
			}
		}
		Method myMethod = getMethod(cls, codeVules[1]);
		Object[] args = { adjectMap };
		if (myMethod != null) {
			ReflectionUtils.invoke(myMethod, obj, args);
		}

	}

	/**
	 * 「オーダー登録」画面、商品のサブアイテムコードの処理
	 * 
	 * @param itemList
	 * @param orderForm
	 */
	public void getItem(List<Item> itemList, OrderForm orderForm) {
		Map<String, String> itemMap = new LinkedHashMap<String, String>();
		for (Item item : itemList) {
			itemMap.put(item.getItemCode(), item.getItemName());
		}
		orderForm.setProductItemMap(itemMap);
	}

	/**
	 * 「オーダー登録」画面、オプションのモデルコードの処理
	 * 
	 * @param modelList
	 * @param orderForm
	 */
	public void getModel(List<Model> modelList, OrderForm orderForm) {
		Map<String, String> ojJacketModelMap = new LinkedHashMap<String, String>();
		Map<String, String> opPantsModelMap = new LinkedHashMap<String, String>();
		Map<String, String> op2PantsModelMap = new LinkedHashMap<String, String>();
		Map<String, String> ogGiletModelMap = new LinkedHashMap<String, String>();

		for (Model model : modelList) {
			if (model.getSubItemCode().equals("02")) {
				ojJacketModelMap.put("", "モデル選択");
				ojJacketModelMap.put(model.getModelCode(), model.getModelName());
			} else if (model.getSubItemCode().equals("03")) {
				opPantsModelMap.put("", "モデル選択");
				opPantsModelMap.put(model.getModelCode(), model.getModelName());
			} else if (model.getSubItemCode().equals("04")) {
				ogGiletModelMap.put("", "モデル選択");
				ogGiletModelMap.put(model.getModelCode(), model.getModelName());
			} else if (model.getSubItemCode().equals("07")) {
				op2PantsModelMap.put("", "モデル選択");
				op2PantsModelMap.put(model.getModelCode(), model.getModelName());
			}
		}
		orderForm.getOptionGiletStandardInfo().setOgGiletModelMap(ogGiletModelMap);
		orderForm.getOptionJacketStandardInfo().setOjJacketModelMap(ojJacketModelMap);
		orderForm.getOptionPantsStandardInfo().setOpPantsModelMap(opPantsModelMap);
		orderForm.getOptionPants2StandardInfo().setOp2PantsModelMap(op2PantsModelMap);

	}

	/**
	 * オーダー内容確認画面JACKEのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderJacketMappingPo(OrderForm orderForm, Order order) {

		// JACKET_フロント釦数_名
		order.setJkFrtBtnNm(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCntMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt()));
		// JACKET_ラペルデザイン_名
		order.setJkLapelDesignNm(orderForm.getOptionJacketStandardInfo().getOjLapelDesignMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjLapelDesign()));
		// JACKET_台場_名
		order.setJkDaibaNm(orderForm.getOptionJacketStandardInfo().getOjFortMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjFort()));
		// JACKET_裏仕様 _名
		order.setJkInnerClothNm(orderForm.getOptionJacketStandardInfo().getOjGackSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjGackSpec()));
		// JACKET_腰ポケット_名
		order.setJkWaistPktNm(orderForm.getOptionJacketStandardInfo().getOjWaistPktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjWaistPkt()));
		// JACKET_チェンジポケット_名
		order.setJkChgPktNm(orderForm.getOptionJacketStandardInfo().getOjChangePktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjChangePkt()));
		// JACKET_スランテッドポケット_名
		order.setJkSlantedPktNm(orderForm.getOptionJacketStandardInfo().getOjSlantedPktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjSlantedPkt()));
		// JACKET_袖口_名
		order.setJkCuffNm(orderForm.getOptionJacketStandardInfo().getOjCuffSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjCuffSpec()));
		// JACKET_ステッチ種類_名
		order.setJkStitchTypeNm(orderForm.getOptionJacketStandardInfo().getOjStitchMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjStitch()));
		// JACKET_ベント_名
		order.setJkVentNm(orderForm.getOptionJacketStandardInfo().getOjVentSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjVentSpec()));

		// JACKET_Drop
		order.setCorJkDrop(orderForm.getAdjustGiletStandardInfo().getSizeFigureMap()
				.get(orderForm.getAdjustGiletStandardInfo().getSizeFigure()));
		// JACKET_号数
		order.setCorJkSize(orderForm.getAdjustGiletStandardInfo().getSizeNumberMap()
				.get(orderForm.getAdjustGiletStandardInfo().getSizeNumber()));
	}

	/**
	 * オーダー内容確認画面GILETのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderGiletMappingPo(OrderForm orderForm, Order order) {

		// GILET_胸ポケット _名
		order.setGlBreastPktNm(orderForm.getOptionGiletStandardInfo().getOgBreastPktMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgBreastPkt()));
		// GILET_AMFステッチ _名
		order.setGlAmfStitchNm(orderForm.getOptionGiletStandardInfo().getOgStitchMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgStitch()));
		// GILET_Drop
		order.setCorGlDrop(orderForm.getAdjustGiletStandardInfo().getSizeFigureMap()
				.get(orderForm.getAdjustGiletStandardInfo().getSizeFigure()));
		// GILET_号数
		order.setCorGlSize(orderForm.getAdjustGiletStandardInfo().getSizeNumberMap()
				.get(orderForm.getAdjustGiletStandardInfo().getSizeNumber()));
	}

	/**
	 * オーダー内容確認画面PANTSのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPantsMappingPo(OrderForm orderForm, Order order) {
		// PANTS_タック_名
		order.setPtTackNm(orderForm.getOptionPantsStandardInfo().getOpTackMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpTack()));
		// PANTS_アジャスター_名
		order.setPtAdjusterNm(orderForm.getOptionPantsStandardInfo().getOpAdjusterMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpAdjuster()));
		// PANTS_裾上げ_名
		order.setPtHemUpNm(orderForm.getOptionPantsStandardInfo().getOpHemUpMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpHemUp()));
		// PANTS_ダブル幅_名
		order.setPtDblWidthNm(orderForm.getOptionPantsStandardInfo().getOpDoubleWideMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpDoubleWide()));
		// PANTS_エイト（滑り止め） _名
		order.setPtNonSlipNm(orderForm.getOptionPantsStandardInfo().getOpEightMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpEight()));
		// PANTS_シック（股下補強） _名
		order.setPtChicSlipNm(orderForm.getOptionPantsStandardInfo().getOpThickMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpThick()));
		// PANTS_形状記憶 _名
		order.setPtShapeMemoryNm(orderForm.getOptionPantsStandardInfo().getOpShapeMemoryMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpShapeMemory()));
		// PANTS_靴ずれ _名
		order.setPtShoeSoreNm(orderForm.getOptionPantsStandardInfo().getOpBlisterMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpBlister()));

		// PANTS_Drop
		order.setCorPtDrop(orderForm.getAdjustPantsStandardInfo().getSizeFigureMap()
				.get(orderForm.getAdjustPantsStandardInfo().getSizeFigure()));
		// PANTS_号数
		order.setCorPtSize(orderForm.getAdjustPantsStandardInfo().getSizeNumberMap()
				.get(orderForm.getAdjustPantsStandardInfo().getSizeNumber()));
	}

	/**
	 * オーダー内容確認画面PANTS2のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPants2MappingPo(OrderForm orderForm, Order order) {

		// 2PANTS_タック_名
		order.setPt2TackNm(orderForm.getOptionPants2StandardInfo().getOp2TackMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Tack()));
		// 2PANTS_アジャスター_名
		order.setPt2AdjusterNm(orderForm.getOptionPants2StandardInfo().getOp2AdjusterMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Adjuster()));
		// 2PANTS_裾上げ_名
		order.setPt2HemUpNm(orderForm.getOptionPants2StandardInfo().getOp2HemUpMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2HemUp()));
		// 2PANTS_ダブル幅_名
		order.setPt2DblWidthNm(orderForm.getOptionPants2StandardInfo().getOp2DoubleWideMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2DoubleWide()));
		// 2PANTS_エイト（滑り止め） _名
		order.setPt2NonSlipNm(orderForm.getOptionPants2StandardInfo().getOp2EightMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Eight()));
		// 2PANTS_シック（股下補強） _名
		order.setPt2ChicSlipNm(orderForm.getOptionPants2StandardInfo().getOp2ThickMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Thick()));
		// 2PANTS_形状記憶 _名
		order.setPt2ShapeMemoryNm(orderForm.getOptionPants2StandardInfo().getOp2ShapeMemoryMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2ShapeMemory()));
		// 2PANTS_靴ずれ _名
		order.setPt2ShoeSoreNm(orderForm.getOptionPants2StandardInfo().getOp2BlisterMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Blister()));

		// 2PANTS_Drop
		order.setCorPt2Drop(orderForm.getAdjustPants2StandardInfo().getSizeFigureMap()
				.get(orderForm.getAdjustPants2StandardInfo().getSizeFigure()));
		// 2PANTS_号数
		order.setCorPt2Size(orderForm.getAdjustPants2StandardInfo().getSizeNumberMap()
				.get(orderForm.getAdjustPants2StandardInfo().getSizeNumber()));
	}

	/**
	 * 
	 * @param productItem
	 * @param productIs3Piece
	 * @param productSparePantsClass
	 * @param ojFrontBtnCnt
	 * @return
	 */
	public String getHostTransmitMakerProductMapKey(String productItem, String productIs3Piece,
			String productSparePantsClass, String ojFrontBtnCnt) {
		// スペアパンツは有り
		String productSparePantsClassYes = "0009902";
		// ３Pieceは有り
		String productIs3PieceYes = "0009902";
		// フロント釦数はダブル
		String ojFrontBtnCntDouble = "0000105";
		// SUIT:01 JACKET:02 PANTS:03 GILET:04
		String suitItemCd = "01";
		String jacketItemCd = "02";

		String itemAnd = "";
		String is3PieceAnd = "";
		String sparePantsClassAnd = "";
		String ojFrontBtnCntAnd = "";

		if (suitItemCd.equals(productItem)) {
			// ２Pシングル
			if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && !productIs3PieceYes.equals(productIs3Piece)
					&& !productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
			}
			// ２Pダブル
			else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && !productIs3PieceYes.equals(productIs3Piece)
					&& !productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				ojFrontBtnCntAnd = "0000105";
			}
			// ２PPシングル
			else if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && !productIs3PieceYes.equals(productIs3Piece)
					&& productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				sparePantsClassAnd = "030009902";
			}
			// ２PPダブル
			else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && !productIs3PieceYes.equals(productIs3Piece)
					&& productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				sparePantsClassAnd = "030009902";
				ojFrontBtnCntAnd = "0000105";
			}
			// ３Pシングル
			else if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && productIs3PieceYes.equals(productIs3Piece)
					&& !productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				is3PieceAnd = "040009902";
			}
			// ３Pダブル
			else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && productIs3PieceYes.equals(productIs3Piece)
					&& !productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				is3PieceAnd = "040009902";
				ojFrontBtnCntAnd = "0000105";
			}
			// ３P２PPシングル
			else if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && productIs3PieceYes.equals(productIs3Piece)
					&& productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				is3PieceAnd = "040009902";
				sparePantsClassAnd = "030009902";
			}
			// ３P２PPダブル
			else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt) && productIs3PieceYes.equals(productIs3Piece)
					&& productSparePantsClassYes.equals(productSparePantsClass)) {
				itemAnd = "01";
				is3PieceAnd = "040009902";
				sparePantsClassAnd = "030009902";
				ojFrontBtnCntAnd = "0000105";
			}
		} else if (jacketItemCd.equals(productItem)) {
			// J ジャケット
			if (!ojFrontBtnCntDouble.equals(ojFrontBtnCnt)) {
				itemAnd = "02";
			} else if (ojFrontBtnCntDouble.equals(ojFrontBtnCnt)) {
				itemAnd = "02";
				ojFrontBtnCntAnd = "0000105";
			}
		} else {
			itemAnd = productItem;
		}
		String hostTransmitMakerProductKey = itemAnd + is3PieceAnd + sparePantsClassAnd + ojFrontBtnCntAnd;
		return hostTransmitMakerProductKey;
	}

	/**
	 * オーダー内容確認画面のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderMappingPo(OrderForm orderForm, Order order, String userId, OrderFindFabric findStock,
			Order orderId, String findMakerId, Map<String, Integer> retailPriceRelatedMap) {

		// オーダーパターン
		order.setOrderPattern(orderForm.getOrderPattern());

		// 注文承り日
		order.setProductOrderdDate(new Date());

		// TSCステータス
		order.setTscStatus("T2");

		// 取り消しフラグ
		order.setIsCancelled("0");

		// 登録者
		String createdUserId = orderId.getCreatedUserId();
		order.setCreatedUserId(createdUserId);

		// 登録日時
		Date createdAt = orderId.getCreatedAt();
		order.setCreatedAt(createdAt);

		// 最終更新者
		order.setUpdatedUserId(userId);

		// 最終更新日時
		Date updatedAt = new Date();
		order.setUpdatedAt(updatedAt);

		// 工場ステータス 生産開始前
		order.setMakerFactoryStatus("F0");

		// tsc stutas
		order.setTheoreticalStockCheck("1");

		// 商品情報_工場
		String productFactoryCd = findStock.getFactoryCode();
		order.setProductFactoryCd(productFactoryCd);

		// 商品情報_メーカーコード
		String productMakerCode = findStock.getMakerCode();
		order.setProductMakerCode(productMakerCode);

		// 生地_色
		String fabricColor = findStock.getColor();
		order.setFabricColor(fabricColor);

		// 生地_柄
		String fabricPattern = findStock.getPattern();
		order.setFabricPattern(fabricPattern);

		// ホスト連携_店コード
		order.setHostTransmitStoreCd(orderForm.getShopCode());

		// ホスト連携_品名コード
		Map<String, String> hostTransmitItemCd03Map = new HashMap<String, String>();
		Map<String, String> hostTransmitItemCd01Map = new HashMap<String, String>();

		/*
		 * 業態がTSC(03)の場合 061 スーツ 01 SUIT 062 ジャケット 02 JACKET 063 パンツ 03 PANTS 064 ジレ 04
		 * GILET
		 */
		hostTransmitItemCd03Map.put("01", "061");
		hostTransmitItemCd03Map.put("02", "062");
		hostTransmitItemCd03Map.put("03", "063");
		hostTransmitItemCd03Map.put("04", "064");
		/*
		 * 業態がTSC(01)の場合 061 スーツ 01 SUIT 062 ジャケット 02 JACKET 063 パンツ 03 PANTS 067 ジレ 04
		 * GILET
		 */
		hostTransmitItemCd01Map.put("01", "061");
		hostTransmitItemCd01Map.put("02", "062");
		hostTransmitItemCd01Map.put("03", "063");
		hostTransmitItemCd01Map.put("04", "067");

		String hostTransmitItemCdKey = orderForm.getProductItem();
		String storeBrandCode = order.getStoreBrandCode();
		if ("01".equals(storeBrandCode)) {
			String hostTransmitItemCdValue = hostTransmitItemCd01Map.get(hostTransmitItemCdKey);
			order.setHostTransmitItemCd(hostTransmitItemCdValue);
		} else if ("03".equals(storeBrandCode)) {
			String hostTransmitItemCdValue = hostTransmitItemCd03Map.get(hostTransmitItemCdKey);
			order.setHostTransmitItemCd(hostTransmitItemCdValue);
		}

		// ホスト連携_メーカーコード
		order.setHostTransmitMakerCd(findMakerId);

		// ホスト連携_年季
		String hostTransmitNenkiCd = findStock.getSeason();
		order.setHostTransmitNenkiCd(hostTransmitNenkiCd);

		// ホスト連携_色
		String hostTransmitColorCd = findStock.getColorAoyama();
		String hostTransmitPatternCd = findStock.getPatternAoyama();
		order.setHostTransmitColorCd(hostTransmitColorCd + hostTransmitPatternCd);

		// 工場自動連携ステータス
		order.setSend2factoryStatus("0");

		// ホスト連携_サイズ
		String orderItemCd = orderForm.getProductItem();
		String suitItemCd = "01";
		String jacketItemCd = "02";
		String pantsItemCd = "03";
		String giletItemCd = "04";
		if (suitItemCd.equals(orderItemCd) || jacketItemCd.equals(orderItemCd)) {
			String subStringSizeFigure = "";
			String subStringSizeNumber = "";
			String sizeNumber = orderForm.getAdjustJacketStandardInfo().getSizeNumber();
			if (sizeNumber.indexOf("(") != -1) {
				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
			}
			String sizeFigure = orderForm.getAdjustJacketStandardInfo().getSizeFigure();
			if (sizeFigure.indexOf("(") != -1) {
				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
			}

			String hostTransmitSize = subStringSizeFigure + subStringSizeNumber;
			order.setHostTransmitSize(hostTransmitSize);
		} else if (pantsItemCd.equals(orderItemCd)) {
			String subStringSizeFigure = "";
			String subStringSizeNumber = "";
			String sizeNumber = orderForm.getAdjustPantsStandardInfo().getSizeNumber();
			if (sizeNumber.indexOf("(") != -1) {
				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
			}
			String sizeFigure = orderForm.getAdjustPantsStandardInfo().getSizeFigure();
			if (sizeFigure.indexOf("(") != -1) {
				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
			}
			String hostTransmitSize = subStringSizeFigure + subStringSizeNumber;
			order.setHostTransmitSize(hostTransmitSize);
		} else if (giletItemCd.equals(orderItemCd)) {
			String subStringSizeFigure = "";
			String subStringSizeNumber = "";
			String sizeNumber = orderForm.getAdjustGiletStandardInfo().getSizeNumber();
			if (sizeNumber.indexOf("(") != -1) {
				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
			}

			String sizeFigure = orderForm.getAdjustGiletStandardInfo().getSizeFigure();
			if (sizeFigure.indexOf("(") != -1) {
				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
			}
			String hostTransmitSize = subStringSizeFigure + subStringSizeNumber;
			order.setHostTransmitSize(hostTransmitSize);
		}

		// ホスト連携_メーカー品番
		/*
		 * 生地品番(8)＋色(1)＋柄(1)＋区分(1) 色、柄：TSC表記 区分： SUIT 単品 1 ２Pシングル J ジャケット 2 ２Pダブル W
		 * ダブルジャケット 3 ２PPシングル G ジレ 4 ２PPダブル V ダブルジレ 5 ３Pシングル P パンツ 6 ３Pダブル D ドレスシャツ 7
		 * ３P２PPシングル C シングルコート 8 ３P２PPダブル A ダブルコート
		 */
		Map<String, String> hostTransmitMakerProductMap = new HashMap<String, String>();
		// 1 ２Pシングル
		hostTransmitMakerProductMap.put("01", "1");
		// 2 ２Pダブル
		hostTransmitMakerProductMap.put("010000105", "2");
		// 3 ２PPシングル
		hostTransmitMakerProductMap.put("01030009902", "3");
		// 4 ２PPダブル
		hostTransmitMakerProductMap.put("010300099020000105", "4");
		// 5 ３Pシングル
		hostTransmitMakerProductMap.put("01040009902", "5");
		// 6 ３Pダブル
		hostTransmitMakerProductMap.put("010400099020000105", "6");
		// 7 ３P２PPシングル
		hostTransmitMakerProductMap.put("01040009902030009902", "7");
		// 8 ３P２PPダブル
		hostTransmitMakerProductMap.put("010400099020300099020000105", "8");
		// J ジャケット
		hostTransmitMakerProductMap.put("02", "J");
		// W ダブルジャケット
		hostTransmitMakerProductMap.put("020000105", "W");
		// G ジレ
		hostTransmitMakerProductMap.put("04", "G");
		// P パンツ
		hostTransmitMakerProductMap.put("03", "P");

		// 商品情報_ITEM
		String productItem = orderForm.getProductItem();
		// 商品情報_３Piece
		String productIs3Piece = orderForm.getProductIs3Piece();
		// 商品情報_スペアパンツ
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		// フロント釦数
		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
		String hostTransmitMakerProductMapKey = getHostTransmitMakerProductMapKey(productItem, productIs3Piece,
				productSparePantsClass, ojFrontBtnCnt);

		String productFabricNo = orderForm.getProductFabricNo();
		String hostTransmitMakerProductMapValue = hostTransmitMakerProductMap.get(hostTransmitMakerProductMapKey);
		String hostTransmitMakerProductValue = productFabricNo + fabricColor + fabricPattern
				+ hostTransmitMakerProductMapValue;
		order.setHostTransmitMakerProduct(hostTransmitMakerProductValue);

		// 商品情報_刺繍ネーム、商品情報_刺繍書体、商品情報_刺繍糸色はnull値の判定
		String productEmbroideryNecessity = orderForm.getProductEmbroideryNecessity();
		if ("0".equals(productEmbroideryNecessity)) {
			order.setProductEmbroideryNm(null);
			order.setProductEmbroideryFont(null);
			order.setProductEmbroideryThreadColor(null);
		}

		// PANTS_ダブル幅についての項目はnull値の判定
		String opHemUp = orderForm.getOptionPantsStandardInfo().getOpHemUp();
		if ("0001701".equals(opHemUp) || "0001704".equals(opHemUp)) {
			order.setPtDblWidthCd(null);
			order.setPtDblWidthNm(null);
			order.setPtDblWidthRtPrice(null);
			order.setPtDblWidthWsWage(null);
			order.setPtDblWidthWsPrice(null);
		}

		// PANTS2_ダブル幅についての項目はnull値の判定
		String op2HemUp = orderForm.getOptionPants2StandardInfo().getOp2HemUp();
		if ("0001701".equals(op2HemUp) || "0001704".equals(op2HemUp)) {
			order.setPt2DblWidthCd(null);
			order.setPt2DblWidthNm(null);
			order.setPt2DblWidthRtPrice(null);
			order.setPt2DblWidthWsWage(null);
			order.setPt2DblWidthWsPrice(null);
		}

		if ("01".equals(orderItemCd) || "03".equals(orderItemCd)) {

			// PANTS_股下右_グロス
			String corPtRightinseamGross = orderForm.getAdjustPantsStandardInfo().getCorPtRightinseamGross();
			if (corPtRightinseamGross == null || "".equals(corPtRightinseamGross)) {
				order.setCorPtRightinseamGross(new BigDecimal(0.0));
			}

			// PANTS_股下左_グロス
			String corPtLeftinseamGross = orderForm.getAdjustPantsStandardInfo().getCorPtLeftinseamGross();
			if (corPtLeftinseamGross == null || "".equals(corPtLeftinseamGross)) {
				order.setCorPtLeftinseamGross(new BigDecimal(0.0));
			}

		}

		// スペアパンツは有り
		String productYes = "0009902";
//		String productSparePantsClass = orderForm.getProductSparePantsClass();

		if ("01".equals(orderItemCd) && productYes.equals(productSparePantsClass)) {

			// 2PANTS_股下右_グロス
			String corPt2RightinseamGross = orderForm.getAdjustPants2StandardInfo().getCorPt2RightinseamGross();
			if (corPt2RightinseamGross == null || "".equals(corPt2RightinseamGross)) {
				order.setCorPt2RightinseamGross(new BigDecimal(0.0));
			}

			// 2PANTS_股下左_グロス
			String corPt2LeftinseamGross = orderForm.getAdjustPants2StandardInfo().getCorPt2LeftinseamGross();
			if (corPt2LeftinseamGross == null || "".equals(corPt2LeftinseamGross)) {
				order.setCorPt2LeftinseamGross(new BigDecimal(0.0));
			}

		}

		// JACKET_モデル_上代
		Integer doubleJacketPrice = retailPriceRelatedMap.get("doubleJACKET");
		Integer singleDoubleJacketPrice = retailPriceRelatedMap.get("singleDoubleJACKET");
//		String productItem = orderForm.getProductItem();
//		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
		if ("0000105".equals(ojFrontBtnCnt)) {
			if ("01".equals(productItem)) {
				if (doubleJacketPrice != null) {
					order.setJkModelRtPrice(doubleJacketPrice);
				} else {
					order.setJkModelRtPrice(0);
				}
			} else if ("02".equals(productItem)) {
				if (singleDoubleJacketPrice != null) {
					order.setJkModelRtPrice(singleDoubleJacketPrice);
				} else {
					order.setJkModelRtPrice(0);
				}
			}
		} else {
			if ("01".equals(productItem) || "02".equals(productItem)) {
				order.setJkModelRtPrice(0);
			}

		}

		// お客様情報_お客様氏名
		order.setCustNm(null);
		// お客様情報_フリガナ
		order.setCustKanaNm(null);
	}

	/**
	 * 更新のみのデータ
	 * 
	 * @param selectExistOrder
	 * @param order
	 */
	public void onlyUpdateItem(Order selectExistOrder, Order order) {
		// 売上金額
		Integer salesAmount = selectExistOrder.getSalesAmount();
		order.setSalesAmount(salesAmount);
		// 会計ID
		String cashId = selectExistOrder.getCashId();
		order.setCashId(cashId);
		// 値引き後金額
		Integer cashDiscountPrice = selectExistOrder.getCashDiscountPrice();
		order.setCashDiscountPrice(cashDiscountPrice);
		// 会計後商品金額（税抜き）
		Integer cashProductPrice = selectExistOrder.getCashProductPrice();
		order.setCashProductPrice(cashProductPrice);
		// 会計後商品金額（税込み）
		Integer cashContailTaxProductPrice = selectExistOrder.getCashContailTaxProductPrice();
		order.setCashContailTaxProductPrice(cashContailTaxProductPrice);
		// 店舗・担当_店舗名
		String storeNm = selectExistOrder.getStoreNm();
		order.setStoreNm(storeNm);
		// 店舗・担当_営業担当者
		String storeStaffNm = selectExistOrder.getStoreStaffNm();
		order.setStoreStaffNm(storeStaffNm);
		// 証紙印字情報_お客様名ローマ字
		String printoutCustRomaNm = selectExistOrder.getPrintoutCustRomaNm();
		order.setPrintoutCustRomaNm(printoutCustRomaNm);
		// 証紙印字情報_営業担当者ローマ字
		String printoutStoreStaffRomaNm = selectExistOrder.getPrintoutStoreStaffRomaNm();
		order.setPrintoutStoreStaffRomaNm(printoutStoreStaffRomaNm);
		// お客様情報_お客様氏名
		String custNm = selectExistOrder.getCustNm();
		order.setCustNm(custNm);
		// お客様情報_フリガナ
		String custKanaNm = selectExistOrder.getCustKanaNm();
		order.setCustKanaNm(custKanaNm);
		// お客様情報_お客様備考
		String custRemark = selectExistOrder.getCustRemark();
		order.setCustRemark(custRemark);
		// ホスト連携_A行
		String hostTransmitARow = selectExistOrder.getHostTransmitARow();
		order.setHostTransmitARow(hostTransmitARow);
		// 出荷番号
		String shippingNumber = selectExistOrder.getShippingNumber();
		order.setShippingNumber(shippingNumber);
	}

	/**
	 * オーダー内容確認画面のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 * @param authority
	 */
	public void orderMappingLogOn(OrderForm orderForm, Order order, String userId, Order orderIsExist,
			String authority) {

		if ("02".equals(authority)) {
			// 業態
			order.setStoreBrandCode(orderIsExist.getStoreBrandCode());
			// 店舗コード
			order.setShopCode(orderIsExist.getShopCode());

		}
		// お客様氏名
		order.setCustNm(null);

		// お客様情報_フリガナ
		order.setCustKanaNm(null);

		// order.setVersion(orderIsExist.getVersion());

		// オーダーパターン
		order.setOrderPattern(orderIsExist.getOrderPattern());

		// お客様備考
		order.setCustRemark(orderForm.getCustomerMessageInfo().getCustRemark().replaceAll("\\n", ""));

		// 注文承り日
		order.setProductOrderdDate(new Date());

		// 取り消しフラグ
		order.setIsCancelled(orderIsExist.getIsCancelled());

		// 最終更新者
		order.setUpdatedUserId(userId);

		// 工場ステータス 生産開始前
		order.setMakerFactoryStatus(orderIsExist.getMakerFactoryStatus());

		// 登録日時
		order.setCreatedAt(orderIsExist.getCreatedAt());

		// 登録者
		order.setCreatedUserId(orderIsExist.getCreatedUserId());

		// 工場自動連携ステータス
		order.setSend2factoryStatus(orderIsExist.getSend2factoryStatus());

		// 理論在庫チェック
		order.setTheoreticalStockCheck(orderIsExist.getTheoreticalStockCheck());

		// 最終更新日時
		order.setUpdatedAt(new Date());

		// 最終更新者
		order.setUpdatedUserId(userId);

		// 商品情報_刺繍ネーム、商品情報_刺繍書体、商品情報_刺繍糸色はnull値の判定
		String productEmbroideryNecessity = orderForm.getProductEmbroideryNecessity();
		if ("0".equals(productEmbroideryNecessity)) {
			order.setProductEmbroideryNm(null);
			order.setProductEmbroideryFont(null);
			order.setProductEmbroideryThreadColor(null);
		}

		// PANTS_ダブル幅についての項目はnull値の判定
		String opHemUp = orderForm.getOptionPantsStandardInfo().getOpHemUp();
		if ("0001701".equals(opHemUp) || "0001704".equals(opHemUp)) {
			order.setPtDblWidthCd(null);
			order.setPtDblWidthNm(null);
			order.setPtDblWidthRtPrice(null);
			order.setPtDblWidthWsWage(null);
			order.setPtDblWidthWsPrice(null);
		}

		// PANTS2_ダブル幅についての項目はnull値の判定
		String op2HemUp = orderForm.getOptionPants2StandardInfo().getOp2HemUp();
		if ("0001701".equals(op2HemUp) || "0001704".equals(op2HemUp)) {
			order.setPt2DblWidthCd(null);
			order.setPt2DblWidthNm(null);
			order.setPt2DblWidthRtPrice(null);
			order.setPt2DblWidthWsWage(null);
			order.setPt2DblWidthWsPrice(null);
		}
	}

	/**
	 * 空とnullの変換
	 * 
	 * @param measuring
	 * @return
	 */
	public BigDecimal convertBigDecimal(String measuring) {
		BigDecimal result = new BigDecimal(0.0);
		if ("".equals(measuring) || measuring == null) {
			return result;
		}
		return new BigDecimal(measuring);
	}

	/**
	 * オーダー内容確認画面のメジャーリングの値とmeasuringの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param measuring
	 * @param userId
	 */
	public void measuringMapping(OrderForm orderForm, Measuring measuring, String userId) {

		// 注文ID
		measuring.setOrderId(orderForm.getCustomerMessageInfo().getOrderId());
		// フルレングス
		measuring.setFullLength(convertBigDecimal(orderForm.getMeasuringInfo().getFullLength()));
		// ショルダー
		measuring.setShoulder(convertBigDecimal(orderForm.getMeasuringInfo().getShoulder()));
		// リーチ（右）
		measuring.setReachRight(convertBigDecimal(orderForm.getMeasuringInfo().getReachRight()));
		// リーチ（左）
		measuring.setReachLeft(convertBigDecimal(orderForm.getMeasuringInfo().getReachLeft()));
		// アウトバスト
		measuring.setOutBust(convertBigDecimal(orderForm.getMeasuringInfo().getOutBust()));
		// バスト
		measuring.setBust(convertBigDecimal(orderForm.getMeasuringInfo().getBust()));
		// JKウエスト
		measuring.setJacketWaist(convertBigDecimal(orderForm.getMeasuringInfo().getJacketWaist()));
		// PTウエスト
		measuring.setPantsWaist(convertBigDecimal(orderForm.getMeasuringInfo().getPantsWaist()));
		// ヒップ
		measuring.setHip(convertBigDecimal(orderForm.getMeasuringInfo().getHip()));
		// ワタリ（右）
		measuring.setSpanRight(convertBigDecimal(orderForm.getMeasuringInfo().getSpanRight()));
		// ワタリ（左）
		measuring.setSpanLeft(convertBigDecimal(orderForm.getMeasuringInfo().getSpanLeft()));
		// ふくらはぎ（右）
		measuring.setCalfRight(convertBigDecimal(orderForm.getMeasuringInfo().getCalfRight()));
		// ふくらはぎ（左）
		measuring.setCalfLeft(convertBigDecimal(orderForm.getMeasuringInfo().getCalfLeft()));
		// ネック
		measuring.setNeck(convertBigDecimal(orderForm.getMeasuringInfo().getNeck()));

		measuring.setUpdatedUserId(userId);

		measuring.setUpdatedAt(new Date());
	}

	/**
	 * 素材品番のMapを取得
	 * 
	 * @param orderForm
	 * @param detailList
	 */
	public void dealWithDetailCode(OrderForm orderForm, List<OptionBranchDetail> detailList) {
		Map<String, String> jkMateMap = new HashMap<String, String>();
		Map<String, String> ptMateMap = new HashMap<String, String>();
		Map<String, String> pt2MateMap = new HashMap<String, String>();
		Map<String, String> glMateMap = new HashMap<String, String>();

		for (OptionBranchDetail optionBranchDetail : detailList) {
			if (optionBranchDetail.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_JACKET.getKey())) {
				jkMateMap.put(optionBranchDetail.getSubItemCode() + optionBranchDetail.getOptionCode()
						+ optionBranchDetail.getOptionBranchCode() + optionBranchDetail.getOptionBranchDetailCode(),
						optionBranchDetail.getOptionBranchDetailName());
			} else if (optionBranchDetail.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS.getKey())) {
				ptMateMap.put(optionBranchDetail.getSubItemCode() + optionBranchDetail.getOptionCode()
						+ optionBranchDetail.getOptionBranchCode() + optionBranchDetail.getOptionBranchDetailCode(),
						optionBranchDetail.getOptionBranchDetailName());
			} else if (optionBranchDetail.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_GILET.getKey())) {
				glMateMap.put(optionBranchDetail.getSubItemCode() + optionBranchDetail.getOptionCode()
						+ optionBranchDetail.getOptionBranchCode() + optionBranchDetail.getOptionBranchDetailCode(),
						optionBranchDetail.getOptionBranchDetailName());
			} else if (optionBranchDetail.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				pt2MateMap.put(optionBranchDetail.getSubItemCode() + optionBranchDetail.getOptionCode()
						+ optionBranchDetail.getOptionBranchCode() + optionBranchDetail.getOptionBranchDetailCode(),
						optionBranchDetail.getOptionBranchDetailName());
			}
		}
		orderForm.getOptionJacketStandardInfo().setJacketMateMap(jkMateMap);
		orderForm.getOptionPantsStandardInfo().setPantsMateMap(ptMateMap);
		orderForm.getOptionPants2StandardInfo().setPants2MateMap(pt2MateMap);
		orderForm.getOptionGiletStandardInfo().setGiletMateMap(glMateMap);
	}

	/**
	 * オーダー内容確認画面JACKETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderJkNameMappingPo(OrderForm orderForm, Order order) {

		// subItemCode
		String jacketSubItemCode = "02";

		// JACKETの胴裏素材Name表示
		String ojBodyBackMateOptionCode = "00038";
		String ojBodyBackMateCode = orderForm.getOptionJacketStandardInfo().getOjBodyBackMate();
		String ojBodyBackMateStkNoCode = orderForm.getOptionJacketStandardInfo().getOjBodyBackMateStkNo();

		String jkInnerBodyClothNmCode = jacketSubItemCode + ojBodyBackMateOptionCode + ojBodyBackMateCode
				+ ojBodyBackMateStkNoCode;
		String jkInnerClothNm = orderForm.getOptionJacketStandardInfo().getOjBodyBackMateMap().get(ojBodyBackMateCode);
		String jkInnerBodyClothNm = orderForm.getOptionJacketStandardInfo().getJacketMateMap()
				.get(jkInnerBodyClothNmCode);
		order.setJkInnerBodyClothNm(jkInnerClothNm + " " + jkInnerBodyClothNm);

		// JACKETの袖裏素材Name表示
		String ojCuffBackMateOptionCode = "00040";
		String ojCuffBackMateCode = orderForm.getOptionJacketStandardInfo().getOjCuffBackMate();
		String ojCuffBackMateStkNoCode = orderForm.getOptionJacketStandardInfo().getOjCuffBackMateStkNo();

		String jkInnerSleeveClothNmCode = jacketSubItemCode + ojCuffBackMateOptionCode + ojCuffBackMateCode
				+ ojCuffBackMateStkNoCode;
		String jkInnerSleeveBodyClothNm = orderForm.getOptionJacketStandardInfo().getOjCuffBackMateMap()
				.get(ojCuffBackMateCode);
		String jkInnerSleeveClothNm = orderForm.getOptionJacketStandardInfo().getJacketMateMap()
				.get(jkInnerSleeveClothNmCode);
		order.setJkInnerSleeveClothNm(jkInnerSleeveBodyClothNm + " " + jkInnerSleeveClothNm);

		// JACKETの釦素材Name表示
		String ojBtnMateOptionCode = "00042";
		String ojBtnMateCode = orderForm.getOptionJacketStandardInfo().getOjBtnMate();
		String ojBtnMateStkNoCode = orderForm.getOptionJacketStandardInfo().getOjBtnMateStkNo();

		String jkBtnMaterialNmCode = jacketSubItemCode + ojBtnMateOptionCode + ojBtnMateCode + ojBtnMateStkNoCode;
		String jkBtnMaterialBodyNm = orderForm.getOptionJacketStandardInfo().getOjBtnMateMap().get(ojBtnMateCode);
		String jkBtnMaterialNm = orderForm.getOptionJacketStandardInfo().getJacketMateMap().get(jkBtnMaterialNmCode);
		order.setJkBtnMaterialNm(jkBtnMaterialBodyNm + " " + jkBtnMaterialNm);
	}

	/**
	 * オーダー内容確認画面GILETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderGlNameMappingPo(OrderForm orderForm, Order order) {

		// subItemCode
		String giletSubItemCode = "04";

		// GILETの背裏地素材Name表示
		String ogBackLiningMateOptionCode = "00017";
		String ogBackLiningMateCode = orderForm.getOptionGiletStandardInfo().getOgBackLiningMate();
		String ogBackLiningMateStkNoCode = orderForm.getOptionGiletStandardInfo().getOgBackLiningMateStkNo();

		String glBackClothNmCode = giletSubItemCode + ogBackLiningMateOptionCode + ogBackLiningMateCode
				+ ogBackLiningMateStkNoCode;
		String glBackBodyClothNm = orderForm.getOptionGiletStandardInfo().getOgBackLiningMateMap()
				.get(ogBackLiningMateCode);
		String glBackClothNm = orderForm.getOptionGiletStandardInfo().getGiletMateMap().get(glBackClothNmCode);
		order.setGlBackClothNm(glBackBodyClothNm + " " + glBackClothNm);

		// GILETの内側裏地素材Name表示
		String ogInsideLiningMateOptionCode = "00019";
		String ogInsideLiningMateCode = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMate();
		String ogInsideLiningMateStkNoCode = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMateStkNo();

		String glInnnerClothNmCode = giletSubItemCode + ogInsideLiningMateOptionCode + ogInsideLiningMateCode
				+ ogInsideLiningMateStkNoCode;
		String glInnnerBodyClothNm = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMateMap()
				.get(ogInsideLiningMateCode);
		String glInnnerClothNm = orderForm.getOptionGiletStandardInfo().getGiletMateMap().get(glInnnerClothNmCode);
		order.setGlInnnerClothNm(glInnnerBodyClothNm + " " + glInnnerClothNm);

		// GILETのフロント釦Name表示
		String ogFrontBtnMateOptionCode = "00021";
		String ogFrontBtnMateCode = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMate();
		String ogFrontBtnMateStkNoCode = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMateStkNo();

		String glFrtBtnNmCode = giletSubItemCode + ogFrontBtnMateOptionCode + ogFrontBtnMateCode
				+ ogFrontBtnMateStkNoCode;
		String glFrtBodyBtnNm = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMateMap().get(ogFrontBtnMateCode);
		String glFrtBtnNm = orderForm.getOptionGiletStandardInfo().getGiletMateMap().get(glFrtBtnNmCode);
		order.setGlFrtBtnNm(glFrtBodyBtnNm + " " + glFrtBtnNm);
	}

	/**
	 * オーダー内容確認画面PNATSのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPtNameMappingPo(OrderForm orderForm, Order order) {

		// subItemCode
		String pantsSubItemCode = "03";

		// PANTSの釦素材Name表示
		String opButtonOptionCode = "00033";
		String opButtonCode = orderForm.getOptionPantsStandardInfo().getOpButton();
		String opBtnMateStkNoCode = orderForm.getOptionPantsStandardInfo().getOpBtnMateStkNo();

		String ptBtnMaterialNmCode = pantsSubItemCode + opButtonOptionCode + opButtonCode + opBtnMateStkNoCode;
		String ptBtnMaterialBodyNm = orderForm.getOptionPantsStandardInfo().getOpButtonMap().get(opButtonCode);
		String ptBtnMaterialNm = orderForm.getOptionPantsStandardInfo().getPantsMateMap().get(ptBtnMaterialNmCode);
		order.setPtBtnMaterialNm(ptBtnMaterialBodyNm + " " + ptBtnMaterialNm);
	}

	/**
	 * オーダー内容確認画面PNATS2のoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPt2NameMappingPo(OrderForm orderForm, Order order) {

		// subItemCode
		String pants2SubItemCode = "07";

		// PANTS（2本目）の釦素材Name表示
		String op2ButtonOptionCode = "00033";
		String op2ButtonCode = orderForm.getOptionPants2StandardInfo().getOp2Button();
		String op2BtnMateStkNoCode = orderForm.getOptionPants2StandardInfo().getOp2BtnMateStkNo();

		String pt2BtnMaterialNmCode = pants2SubItemCode + op2ButtonOptionCode + op2ButtonCode + op2BtnMateStkNoCode;
		String pt2BtnMaterialBodyNm = orderForm.getOptionPants2StandardInfo().getOp2ButtonMap().get(op2ButtonCode);
		String pt2BtnMaterialNm = orderForm.getOptionPants2StandardInfo().getPants2MateMap().get(pt2BtnMaterialNmCode);
		order.setPt2BtnMaterialNm(pt2BtnMaterialBodyNm + " " + pt2BtnMaterialNm);

	}

	/**
	 * JACKETの上代価額をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @return
	 */
	public void orderJacketPrice(OrderForm orderForm, Order order) {

		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_JACKET.getValue();
		String branchModelCode = orderForm.getOptionJacketStandardInfo().getOjJacketModel();

		JacketOptionStandardPriceEnum[] priceEnum = JacketOptionStandardPriceEnum.values();

		for (JacketOptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValue();
			String valueTwo = price.getValue2();
			String valueThree = price.getValue3();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object result = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					result = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketStandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + result;

				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + result + resultTwo;

				List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
				for (OrderCodePrice orderCodePrice : orderCodePriceList) {
					if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { 0 };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice()) };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null
									&& orderCodePrice.getOrderBranchDetailDoublePrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Object[] argsDetailValue = { 0 };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailDoublePrice());
								Object[] argsDetailValue = { OrderDoublePrice };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							}
							break;
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
					} else {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchPrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { 0 };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchPrice()) };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchPrice() == null
									&& orderCodePrice.getOrderBranchDetailPrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Object[] argsDetailValue = { 0 };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
								Object[] argsDetailValue = { OrderDoublePrice };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							}
							break;
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * GILETの上代価額をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderGiletPrice(OrderForm orderForm, Order order) {

		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_GILET.getValue();
		String branchModelCode = orderForm.getOptionGiletStandardInfo().getOgGiletModel();

		GiletOptionStandardPriceEnum[] priceEnum = GiletOptionStandardPriceEnum.values();
		for (GiletOptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletStandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + resultOne;
				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + resultOne + resultTwo;

				List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
				for (OrderCodePrice orderCodePrice : orderCodePriceList) {
					if ("CH14-D".equals(orderForm.getOptionGiletStandardInfo().getOgGiletModel())) {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { 0 };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice()) };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchDoublePrice() == null
									&& orderCodePrice.getOrderBranchDetailDoublePrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Object[] argsDetailValue = { 0 };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchDoublePrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailDoublePrice());
								Object[] argsDetailValue = { OrderDoublePrice };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							}
							break;
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
					} else {
						if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderCodePrice.getOrderDetailKeyCode() == null) {
							if (orderCodePrice.getOrderBranchPrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { 0 };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethod = getMethod(cls, valueThree);
								Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchPrice()) };
								if (myMethod != null) {
									ReflectionUtils.invoke(myMethod, order, argsValue);
								}
							}
							break;
						} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
								&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if (orderCodePrice.getOrderBranchPrice() == null
									&& orderCodePrice.getOrderBranchDetailPrice() == null) {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Object[] argsDetailValue = { 0 };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							} else {
								cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
								Method myMethodT = getMethod(cls, valueThree);
								Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
										+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
								Object[] argsDetailValue = { OrderDoublePrice };
								if (myMethodT != null) {
									ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
								}
							}
							break;
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTSの上代価額をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPantsPrice(OrderForm orderForm, Order order) {

		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS.getValue();
		String branchModelCode = orderForm.getOptionPantsStandardInfo().getOpPantsModel();

		PantsOptionStandardPriceEnum[] priceEnum = PantsOptionStandardPriceEnum.values();
		for (PantsOptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPantsStandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + resultOne;
				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + resultOne + resultTwo;

				List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
				for (OrderCodePrice orderCodePrice : orderCodePriceList) {
					if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderCodePrice.getOrderDetailKeyCode() == null) {
						if (orderCodePrice.getOrderBranchPrice() == null) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethod = getMethod(cls, valueThree);
							Object[] argsValue = { 0 };
							if (myMethod != null) {
								ReflectionUtils.invoke(myMethod, order, argsValue);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethod = getMethod(cls, valueThree);
							Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchPrice()) };
							if (myMethod != null) {
								ReflectionUtils.invoke(myMethod, order, argsValue);
							}
						}
						break;
					} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if (orderCodePrice.getOrderBranchPrice() == null
								&& orderCodePrice.getOrderBranchDetailPrice() == null) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
									+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
							Object[] argsDetailValue = { OrderDoublePrice };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodT = getMethod(cls, valueThree);
						Object[] argsDetailValue = { 0 };
						if (myMethodT != null) {
							ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTS2の上代価額をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderPants2Price(OrderForm orderForm, Order order) {

		String orderItemCode = orderForm.getProductItem();
		String item = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS2.getValue();
		String branchModelCode = orderForm.getOptionPants2StandardInfo().getOp2PantsModel();

		Pants2OptionStandardPriceEnum[] priceEnum = Pants2OptionStandardPriceEnum.values();
		for (Pants2OptionStandardPriceEnum price : priceEnum) {

			String key = price.getKey();
			String valueOne = price.getValueOne();
			String valueTwo = price.getValueTwo();
			String valueThree = price.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2StandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPants2StandardInfo(), argsTwo);
				}

				String orderKeyCode = orderItemCode + item + branchModelCode + key + resultOne;
				String orderDetailKeyCode = orderItemCode + item + branchModelCode + key + resultOne + resultTwo;

				List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
				for (OrderCodePrice orderCodePrice : orderCodePriceList) {
					if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderCodePrice.getOrderDetailKeyCode() == null) {
						if (orderCodePrice.getOrderBranchPrice() == null) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethod = getMethod(cls, valueThree);
							Object[] argsValue = { 0 };
							if (myMethod != null) {
								ReflectionUtils.invoke(myMethod, order, argsValue);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethod = getMethod(cls, valueThree);
							Object[] argsValue = { Integer.parseInt(orderCodePrice.getOrderBranchPrice()) };
							if (myMethod != null) {
								ReflectionUtils.invoke(myMethod, order, argsValue);
							}
						}
						break;
					} else if (orderKeyCode.equals(orderCodePrice.getOrderKeyCode())
							&& orderDetailKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if (orderCodePrice.getOrderBranchPrice() == null
								&& orderCodePrice.getOrderBranchDetailPrice() == null) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Object[] argsDetailValue = { 0 };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodT = getMethod(cls, valueThree);
							Integer OrderDoublePrice = Integer.parseInt(orderCodePrice.getOrderBranchPrice())
									+ Integer.parseInt(orderCodePrice.getOrderBranchDetailPrice());
							Object[] argsDetailValue = { OrderDoublePrice };
							if (myMethodT != null) {
								ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodT = getMethod(cls, valueThree);
						Object[] argsDetailValue = { 0 };
						if (myMethodT != null) {
							ReflectionUtils.invoke(myMethodT, order, argsDetailValue);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * オーダーのitemCodeとsubItemCode
	 * 
	 * @param orderForm
	 * @param jkSubItemCode
	 * @param gtSubItemCode
	 * @param ptSubItemCode
	 * @param pt2SubItemCode
	 * @return
	 */
	public Map<String, String> subItemCodeValue(OrderForm orderForm, String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode) {
		String itemCode = orderForm.getProductItem();
		String productIs3Piece = orderForm.getProductIs3Piece();
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		Map<String, String> valueSubItemCodeMap = new HashMap<String, String>();
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";
		// 01:SUIT
		String suitCode = "01";
		// 02:JACKET
		String jacketCode = "02";
		// 03:PANTS
		String pantsCode = "03";
		// 04:GILET
		String giletCode = "04";
		// 07:PANTS2
		String pants2Code = "07";
		if (itemCode.equals(suitCode)) {
			if (productIs3Piece.equals(productYes) && productSparePantsClass.equals(productYes)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = giletCode;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = pants2Code;
			} else if (productIs3Piece.equals(productYes) && productSparePantsClass.equals(productNo)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = giletCode;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = null;
			} else if (productIs3Piece.equals(productNo) && productSparePantsClass.equals(productYes)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = null;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = pants2Code;
			} else if (productIs3Piece.equals(productNo) && productSparePantsClass.equals(productNo)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = null;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = null;
			}
		} else if (itemCode.equals(jacketCode)) {
			jkSubItemCode = jacketCode;
			gtSubItemCode = null;
			ptSubItemCode = null;
			pt2SubItemCode = null;
		} else if (itemCode.equals(pantsCode)) {
			jkSubItemCode = null;
			gtSubItemCode = null;
			ptSubItemCode = pantsCode;
			pt2SubItemCode = null;
		} else if (itemCode.equals(giletCode)) {
			jkSubItemCode = null;
			gtSubItemCode = giletCode;
			ptSubItemCode = null;
			pt2SubItemCode = null;
		}
		valueSubItemCodeMap.put("jkSubItemCode", jkSubItemCode);
		valueSubItemCodeMap.put("gtSubItemCode", gtSubItemCode);
		valueSubItemCodeMap.put("ptSubItemCode", ptSubItemCode);
		valueSubItemCodeMap.put("pt2SubItemCode", pt2SubItemCode);
		return valueSubItemCodeMap;
	}

	/**
	 * オーダーのitemCodeとsubItemCode
	 * 
	 * @param order
	 * @param jkSubItemCode
	 * @param gtSubItemCode
	 * @param ptSubItemCode
	 * @param pt2SubItemCode
	 * @return
	 */
	public Map<String, String> subItemCodeValue(Order order, String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode) {
		String itemCode = order.getProductItem();
		String productIs3Piece = order.getProductIs3piece();
		String productSparePantsClass = order.getProductSparePantsClass();
		Map<String, String> valueSubItemCodeMap = new HashMap<String, String>();
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";
		// 01:SUIT
		String suitCode = "01";
		// 02:JACKET
		String jacketCode = "02";
		// 03:PANTS
		String pantsCode = "03";
		// 04:GILET
		String giletCode = "04";
		// 07:PANTS2
		String pants2Code = "07";
		if (itemCode.equals(suitCode)) {
			if (productIs3Piece.equals(productYes) && productSparePantsClass.equals(productYes)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = giletCode;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = pants2Code;
			} else if (productIs3Piece.equals(productYes) && productSparePantsClass.equals(productNo)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = giletCode;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = null;
			} else if (productIs3Piece.equals(productNo) && productSparePantsClass.equals(productYes)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = null;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = pants2Code;
			} else if (productIs3Piece.equals(productNo) && productSparePantsClass.equals(productNo)) {
				jkSubItemCode = jacketCode;
				gtSubItemCode = null;
				ptSubItemCode = pantsCode;
				pt2SubItemCode = null;
			}
		} else if (itemCode.equals(jacketCode)) {
			jkSubItemCode = jacketCode;
			gtSubItemCode = null;
			ptSubItemCode = null;
			pt2SubItemCode = null;
		} else if (itemCode.equals(pantsCode)) {
			jkSubItemCode = null;
			gtSubItemCode = null;
			ptSubItemCode = pantsCode;
			pt2SubItemCode = null;
		} else if (itemCode.equals(giletCode)) {
			jkSubItemCode = null;
			gtSubItemCode = giletCode;
			ptSubItemCode = null;
			pt2SubItemCode = null;
		}
		valueSubItemCodeMap.put("jkSubItemCode", jkSubItemCode);
		valueSubItemCodeMap.put("gtSubItemCode", gtSubItemCode);
		valueSubItemCodeMap.put("ptSubItemCode", ptSubItemCode);
		valueSubItemCodeMap.put("pt2SubItemCode", pt2SubItemCode);
		return valueSubItemCodeMap;
	}

	/**
	 * 基本工賃価格の取得
	 * 
	 * @param itemCode
	 * @param subItemCode
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public BigDecimal getWage(String itemCode, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String keyItemCode = itemCode;
		BigDecimal mbwWage = null;
		for (NextGenerationPrice basicNextGenerationPrice : basicNextGenerationPriceList) {
			if (keyItemCode.equals(basicNextGenerationPrice.getKeyItemCode().substring(0, 2))) {
				mbwWage = basicNextGenerationPrice.getMbwWage();
				break;
			} else {
				mbwWage = new BigDecimal(0.0);
			}
		}
		return mbwWage;
	}

	/**
	 * ダブルブレスト工賃価格の取得
	 * 
	 * @param itemCode
	 * @param subItemCode
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public BigDecimal getDoubleWage(String itemCode, String subItemCode,
			List<NextGenerationPrice> basicNextGenerationPriceList) {
		String keyItemCode = itemCode + subItemCode;
		BigDecimal mdbwWage = null;
		for (NextGenerationPrice basicNextGenerationPrice : basicNextGenerationPriceList) {
			if (keyItemCode.equals(basicNextGenerationPrice.getKeyItemCode())) {
				mdbwWage = basicNextGenerationPrice.getMdbwWage();
				break;
			} else {
				mdbwWage = new BigDecimal(0.0);
			}
		}
		return mdbwWage;
	}

	/**
	 * 基本付属価格の取得
	 * 
	 * @param itemCode
	 * @param subItemCode
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public Integer getPrice(String itemCode, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String keyItemCode = itemCode;
		Integer mnapPrice = null;
		for (NextGenerationPrice basicNextGenerationPrice : basicNextGenerationPriceList) {
			if (keyItemCode.equals(basicNextGenerationPrice.getKeyItemCode().substring(0, 2))) {
				mnapPrice = basicNextGenerationPrice.getMnapPrice();
				break;
			} else {
				mnapPrice = 0;
			}
		}
		return mnapPrice;
	}

	/**
	 * ダブルブレスト付属価格
	 * 
	 * @param itemCode
	 * @param subItemCode
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public Integer getDoublePrice(String itemCode, String subItemCode,
			List<NextGenerationPrice> basicNextGenerationPriceList) {
		String keyItemCode = itemCode + subItemCode;
		Integer mdbapPrice = null;
		for (NextGenerationPrice basicNextGenerationPrice : basicNextGenerationPriceList) {
			if (keyItemCode.equals(basicNextGenerationPrice.getKeyItemCode())) {
				mdbapPrice = basicNextGenerationPrice.getMdbapPrice();
				break;
			} else {
				mdbapPrice = 0;
			}
		}
		return mdbapPrice;
	}

	/**
	 * JACKET_下代工賃とJACKET_下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param optionNextGenerationPriceList
	 * @param basicNextGenerationPriceList
	 */
	public void getJkNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> optionNextGenerationPriceList,
			List<NextGenerationPrice> basicNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_JACKET.getValue();

		JacketOptionStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = JacketOptionStandardNextGenerationPriceEnum
				.values();
		for (JacketOptionStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Object[] args = {};
				Object resultOne = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketStandardInfo(), args);
				}

				String keyCode = itemCode + subItemCode + key + resultOne;

				for (NextGenerationPrice jkNextGenerationPrice : optionNextGenerationPriceList) {
					if (keyCode.equals(jkNextGenerationPrice.getKeyCode())) {
						// フロント釦数はダブル6つボタンの場合、該当itemはダブル
						if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodTwo = getMethod(cls, valueTwo);
							Method myMethodThree = getMethod(cls, valueThree);
							// オプション工賃
							BigDecimal optionWage = jkNextGenerationPrice.getMowWage();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属
							Integer optionDoublePrice = jkNextGenerationPrice.getMoapDoublePrice();
							Integer nextGenerationPriceValue = optionDoublePrice;
							Object[] argsValueTwo = { nextGenerationWageValue };
							Object[] argsValueThree = { nextGenerationPriceValue };
							if (myMethodTwo != null) {
								ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
							}
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
						}
						// 該当itemはダブル以外の場合
						else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodTwo = getMethod(cls, valueTwo);
							Method myMethodThree = getMethod(cls, valueThree);
							// オプション工賃
							BigDecimal optionWage = jkNextGenerationPrice.getMowWage();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属
							Integer optionPrice = jkNextGenerationPrice.getMoapPrice();
							Integer nextGenerationPriceValue = optionPrice;
							Object[] argsValueTwo = { nextGenerationWageValue };
							Object[] argsValueThree = { nextGenerationPriceValue };
							if (myMethodTwo != null) {
								ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
							}
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						Object[] argsValueTwo = { new BigDecimal(0.0) };
						Object[] argsValueThree = { 0 };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * GILET_下代工賃とGILET_下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param optionNextGenerationPriceList
	 * @param basicNextGenerationPriceList
	 */
	public void getGlNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> optionNextGenerationPriceList,
			List<NextGenerationPrice> basicNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_GILET.getValue();

		GiletOptionStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = GiletOptionStandardNextGenerationPriceEnum
				.values();
		for (GiletOptionStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Object[] args = {};
				Object resultOne = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletStandardInfo(), args);
				}

				String keyCode = itemCode + subItemCode + key + resultOne;

				for (NextGenerationPrice glNextGenerationPrice : optionNextGenerationPriceList) {
					if (keyCode.equals(glNextGenerationPrice.getKeyCode())) {
						if ("CH14-D".equals(orderForm.getOptionGiletStandardInfo().getOgGiletModel())) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodTwo = getMethod(cls, valueTwo);
							Method myMethodThree = getMethod(cls, valueThree);
							// オプション工賃
							BigDecimal optionWage = glNextGenerationPrice.getMowWage();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属
							Integer optionDoublePrice = glNextGenerationPrice.getMoapDoublePrice();
							Integer nextGenerationPriceValue = optionDoublePrice;
							Object[] argsValueTwo = { nextGenerationWageValue };
							Object[] argsValueThree = { nextGenerationPriceValue };
							if (myMethodTwo != null) {
								ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
							}
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodTwo = getMethod(cls, valueTwo);
							Method myMethodThree = getMethod(cls, valueThree);
							// オプション工賃
							BigDecimal optionWage = glNextGenerationPrice.getMowWage();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属
							Integer optionPrice = glNextGenerationPrice.getMoapPrice();
							Integer nextGenerationPriceValue = optionPrice;
							Object[] argsValueTwo = { nextGenerationWageValue };
							Object[] argsValueThree = { nextGenerationPriceValue };
							if (myMethodTwo != null) {
								ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
							}
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						Object[] argsValueTwo = { new BigDecimal(0.0) };
						Object[] argsValueThree = { 0 };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTS_下代工賃とPANTS_下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param optionNextGenerationPriceList
	 * @param basicNextGenerationPriceList
	 */
	public void getPtNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> optionNextGenerationPriceList,
			List<NextGenerationPrice> basicNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS.getValue();

		PantsOptionStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = PantsOptionStandardNextGenerationPriceEnum
				.values();
		for (PantsOptionStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Object[] args = {};
				Object resultOne = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsStandardInfo(), args);
				}

				String keyCode = itemCode + subItemCode + key + resultOne;

				for (NextGenerationPrice ptNextGenerationPrice : optionNextGenerationPriceList) {
					if (keyCode.equals(ptNextGenerationPrice.getKeyCode())) {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						// オプション工賃
						BigDecimal optionWage = ptNextGenerationPrice.getMowWage();
						BigDecimal nextGenerationWageValue = optionWage;
						// オプション付属
						Integer optionPrice = ptNextGenerationPrice.getMoapPrice();
						Integer nextGenerationPriceValue = optionPrice;
						Object[] argsValueTwo = { nextGenerationWageValue };
						Object[] argsValueThree = { nextGenerationPriceValue };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						Object[] argsValueTwo = { new BigDecimal(0.0) };
						Object[] argsValueThree = { 0 };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTS2_下代工賃とPANTS2_下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param optionNextGenerationPriceList
	 * @param basicNextGenerationPriceList
	 * 
	 */
	public void getPt2NextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> optionNextGenerationPriceList,
			List<NextGenerationPrice> basicNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS2.getValue();

		Pants2OptionStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = Pants2OptionStandardNextGenerationPriceEnum
				.values();
		for (Pants2OptionStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Object[] args = {};
				Object resultOne = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2StandardInfo(), args);
				}

				String keyCode = itemCode + subItemCode + key + resultOne;

				for (NextGenerationPrice pt2NextGenerationPrice : optionNextGenerationPriceList) {
					if (keyCode.equals(pt2NextGenerationPrice.getKeyCode())) {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						// オプション工賃
						BigDecimal optionWage = pt2NextGenerationPrice.getMowWage();
						BigDecimal nextGenerationWageValue = optionWage;
						// オプション付属
						Integer optionPrice = pt2NextGenerationPrice.getMoapPrice();
						Integer nextGenerationPriceValue = optionPrice;
						Object[] argsValueTwo = { nextGenerationWageValue };
						Object[] argsValueThree = { nextGenerationPriceValue };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodTwo = getMethod(cls, valueTwo);
						Method myMethodThree = getMethod(cls, valueThree);
						Object[] argsValueTwo = { new BigDecimal(0.0) };
						Object[] argsValueThree = { 0 };
						if (myMethodTwo != null) {
							ReflectionUtils.invoke(myMethodTwo, order, argsValueTwo);
						}
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * JACKETのオプション付属詳細価格
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param detailNextGenerationPriceList
	 */
	public void getJkDetailNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> detailNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_JACKET.getValue();

		JacketOptionDetailStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = JacketOptionDetailStandardNextGenerationPriceEnum
				.values();

		for (JacketOptionDetailStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {

			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();
			String valueFour = nextGenerationPrice.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketStandardInfo(), args);
				}

				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketStandardInfo(), argsTwo);
				}

				String keyDetailCode = itemCode + subItemCode + key + resultOne + resultTwo;
				for (NextGenerationPrice detailNextGenerationPrice : detailNextGenerationPriceList) {
					if (keyDetailCode.equals(detailNextGenerationPrice.getKeyDetailCode())) {
						// フロント釦数はダブル6つボタンの場合、該当itemはダブル
						if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodThree = getMethod(cls, valueThree);
							Method myMethodFour = getMethod(cls, valueFour);
							// オプション工賃
							BigDecimal optionWage = detailNextGenerationPrice.getMowWageT();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属 + オプション付属詳細
							Integer optionDoublePrice = detailNextGenerationPrice.getMoapDoublePriceT();
							Integer optionDetailDoublePrice = detailNextGenerationPrice.getMoadpDoublePrice();
							Integer nextGenerationPriceValue = optionDoublePrice + optionDetailDoublePrice;
							Object[] argsValueThree = { nextGenerationWageValue };
							Object[] argsValueFour = { nextGenerationPriceValue };
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
							if (myMethodFour != null) {
								ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodThree = getMethod(cls, valueThree);
							Method myMethodFour = getMethod(cls, valueFour);
							// オプション工賃
							BigDecimal optionWage = detailNextGenerationPrice.getMowWageT();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属 + オプション付属詳細
							Integer optionPrice = detailNextGenerationPrice.getMoapPriceT();
							Integer optionDetailPrice = detailNextGenerationPrice.getMoadpPrice();
							Integer nextGenerationPriceValue = optionPrice + optionDetailPrice;
							Object[] argsValueThree = { nextGenerationWageValue };
							Object[] argsValueFour = { nextGenerationPriceValue };
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
							if (myMethodFour != null) {
								ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodThree = getMethod(cls, valueThree);
						Method myMethodFour = getMethod(cls, valueFour);
						Object[] argsValueThree = { new BigDecimal(0.0) };
						Object[] argsValueFour = { 0 };
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
						if (myMethodFour != null) {
							ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
						}
					}
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * GILETのオプション付属詳細価格
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param detailNextGenerationPriceList
	 */
	public void getGlDetailNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> detailNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_GILET.getValue();

		GiletOptionDetailStandardNextGenerationPriceEnum[] nextGenerationPriceEnum = GiletOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (GiletOptionDetailStandardNextGenerationPriceEnum nextGenerationPrice : nextGenerationPriceEnum) {
			String key = nextGenerationPrice.getKey();
			String valueOne = nextGenerationPrice.getValueOne();
			String valueTwo = nextGenerationPrice.getValueTwo();
			String valueThree = nextGenerationPrice.getValueThree();
			String valueFour = nextGenerationPrice.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName(className);

				Method myMethodOne = getMethod(cls, valueOne);
				Method myMethodTwo = getMethod(cls, valueTwo);
				Object[] args = {};
				Object[] argsTwo = {};
				Object resultOne = null;
				Object resultTwo = null;

				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletStandardInfo(), args);
				}

				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletStandardInfo(), argsTwo);
				}

				String keyDetailCode = itemCode + subItemCode + key + resultOne + resultTwo;
				for (NextGenerationPrice detailNextGenerationPrice : detailNextGenerationPriceList) {
					if (keyDetailCode.equals(detailNextGenerationPrice.getKeyDetailCode())) {
						// GILETモデルはCH14-Dの場合、該当itemはダブル
						if ("CH14-D".equals(orderForm.getOptionGiletStandardInfo().getOgGiletModel())) {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodThree = getMethod(cls, valueThree);
							Method myMethodFour = getMethod(cls, valueFour);
							// オプション工賃
							BigDecimal optionWage = detailNextGenerationPrice.getMowWageT();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属 + オプション付属詳細
							Integer optionDoublePrice = detailNextGenerationPrice.getMoapDoublePriceT();
							Integer optionDetailDoublePrice = detailNextGenerationPrice.getMoadpDoublePrice();
							Integer nextGenerationPriceValue = optionDoublePrice + optionDetailDoublePrice;
							Object[] argsValueThree = { nextGenerationWageValue };
							Object[] argsValueFour = { nextGenerationPriceValue };
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
							if (myMethodFour != null) {
								ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
							}
						} else {
							cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
							Method myMethodThree = getMethod(cls, valueThree);
							Method myMethodFour = getMethod(cls, valueFour);
							// オプション工賃
							BigDecimal optionWage = detailNextGenerationPrice.getMowWageT();
							BigDecimal nextGenerationWageValue = optionWage;
							// オプション付属 + オプション付属詳細
							Integer optionPrice = detailNextGenerationPrice.getMoapPriceT();
							Integer optionDetailPrice = detailNextGenerationPrice.getMoadpPrice();
							Integer nextGenerationPriceValue = optionPrice + optionDetailPrice;
							Object[] argsValueThree = { nextGenerationWageValue };
							Object[] argsValueFour = { nextGenerationPriceValue };
							if (myMethodThree != null) {
								ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
							}
							if (myMethodFour != null) {
								ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
							}
						}
						break;
					} else {
						cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
						Method myMethodThree = getMethod(cls, valueThree);
						Method myMethodFour = getMethod(cls, valueFour);
						Object[] argsValueThree = { new BigDecimal(0.0) };
						Object[] argsValueFour = { 0 };
						if (myMethodThree != null) {
							ReflectionUtils.invoke(myMethodThree, order, argsValueThree);
						}
						if (myMethodFour != null) {
							ReflectionUtils.invoke(myMethodFour, order, argsValueFour);
						}
					}
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

	/**
	 * PANTSのオプション付属詳細価格
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param detailNextGenerationPriceList
	 */
	public void getPtDetailNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> detailNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();

		String optionCode = "00033";
		String optionBranchCode = orderForm.getOptionPantsStandardInfo().getOpButton();
		String optionBranchDetailCode = orderForm.getOptionPantsStandardInfo().getOpBtnMateStkNo();

		String keyDetailCode = itemCode + subItemCode + optionCode + optionBranchCode + optionBranchDetailCode;
		for (NextGenerationPrice detailNextGenerationPrice : detailNextGenerationPriceList) {
			if (keyDetailCode.equals(detailNextGenerationPrice.getKeyDetailCode())) {
				// オプション工賃
				BigDecimal mowWageT = detailNextGenerationPrice.getMowWageT();
				BigDecimal nextGenerationWageValue = mowWageT;
				// オプション付属 + オプション付属詳細
				Integer moapPriceT = detailNextGenerationPrice.getMoapPriceT();
				Integer moadpPrice = detailNextGenerationPrice.getMoadpPrice();
				Integer nextGenerationPriceValue = moapPriceT + moadpPrice;
				order.setPtBtnMaterialWsWage(nextGenerationWageValue);
				order.setPtBtnMaterialWsPrice(nextGenerationPriceValue);
				break;
			} else {
				order.setPtBtnMaterialWsWage(new BigDecimal(0.0));
				order.setPtBtnMaterialWsPrice(0);
			}
		}
	}

	/**
	 * PANTS2のオプション付属詳細価格
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param detailNextGenerationPriceList
	 */
	public void getPt2DetailNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> detailNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		String optionCode = "00033";
		String optionBranchCode = orderForm.getOptionPants2StandardInfo().getOp2Button();
		String optionBranchDetailCode = orderForm.getOptionPants2StandardInfo().getOp2BtnMateStkNo();

		String keyDetailCode = itemCode + subItemCode + optionCode + optionBranchCode + optionBranchDetailCode;
		for (NextGenerationPrice detailNextGenerationPrice : detailNextGenerationPriceList) {
			if (keyDetailCode.equals(detailNextGenerationPrice.getKeyDetailCode())) {
				// オプション工賃
				BigDecimal mowWageT = detailNextGenerationPrice.getMowWageT();
				BigDecimal nextGenerationWageValue = mowWageT;
				// オプション付属 + オプション付属詳細
				Integer moapPriceT = detailNextGenerationPrice.getMoapPriceT();
				Integer moadpPrice = detailNextGenerationPrice.getMoadpPrice();
				Integer nextGenerationPriceValue = moapPriceT + moadpPrice;
				order.setPt2BtnMaterialWsWage(nextGenerationWageValue);
				order.setPt2BtnMaterialWsPrice(nextGenerationPriceValue);
				break;
			} else {
				order.setPt2BtnMaterialWsWage(new BigDecimal(0.0));
				order.setPt2BtnMaterialWsPrice(0);
			}
		}
	}

	/**
	 * ３Pieceの上代をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * 
	 */
	public void order3PiecePrice(OrderForm orderForm, Order order) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		// modelCodeの取得
		String branchModelCode = orderForm.getOptionGiletStandardInfo().getOgGiletModel();
		// optionCodeの取得
		String optionCode = "00099";
		// optionBranchCodeの取得
		String optionBranchCode = orderForm.getProductIs3Piece();

		String keyCode = itemCode + subItemCode + branchModelCode + optionCode + optionBranchCode;
		List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : orderCodePriceList) {
			if (keyCode.equals(orderCodePrice.getOrderKeyCode())) {
				if (orderCodePrice.getOrderBranchPrice() != null) {
					Integer price = Integer.parseInt(orderCodePrice.getOrderBranchPrice());
					order.setProductIs3pieceRtPrice(price);
				} else if (orderCodePrice.getOrderBranchPrice() != null) {
					Integer price = 0;
					order.setProductIs3pieceRtPrice(price);
				}
				break;
			} else {
				Integer price = 0;
				order.setProductIs3pieceRtPrice(price);
			}
		}
	}

	/**
	 * スペアパンツの上代をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderSparePantsPrice(OrderForm orderForm, Order order) {
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
		// modelCodeの取得
		String branchModelCode = orderForm.getOptionPantsStandardInfo().getOpPantsModel();
		// optionCodeの取得
		String optionCode = "00099";
		// optionBranchCodeの取得
		String optionBranchCode = orderForm.getProductSparePantsClass();

		String keyCode = itemCode + subItemCode + branchModelCode + optionCode + optionBranchCode;
		List<OrderCodePrice> orderCodePriceList = orderForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : orderCodePriceList) {
			if (keyCode.equals(orderCodePrice.getOrderKeyCode())) {
				if (orderCodePrice.getOrderBranchPrice() != null) {
					Integer price = Integer.parseInt(orderCodePrice.getOrderBranchPrice());
					order.setProductSparePantsRtPrice(price);
				} else if (orderCodePrice.getOrderBranchPrice() != null) {
					Integer price = 0;
					order.setProductSparePantsRtPrice(price);
				}
				break;
			} else {
				Integer price = 0;
				order.setProductSparePantsRtPrice(price);
			}
		}
	}

	/**
	 * 商品情報_３Piece_下代工賃と下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param optionNextGenerationPriceList
	 */
	public void getGl3PieceNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> optionNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();

		String optionCode = "00099";
		String optionBranchCode = orderForm.getProductIs3Piece();

		String keyCode = itemCode + subItemCode + optionCode + optionBranchCode;
		for (NextGenerationPrice optionNextGenerationPrice : optionNextGenerationPriceList) {
			if (keyCode.equals(optionNextGenerationPrice.getKeyCode())) {
				if ("CH14-D".equals(orderForm.getOptionGiletStandardInfo().getOgGiletModel())) {
					BigDecimal mowWage = optionNextGenerationPrice.getMowWage();
					BigDecimal nextGenerationWageValue = mowWage;

					Integer moapDoublePrice = optionNextGenerationPrice.getMoapDoublePrice();
					Integer nextGenerationPriceValue = moapDoublePrice;
					order.setProductIs3pieceWsWage(nextGenerationWageValue);
					order.setProductIs3pieceWsPrice(nextGenerationPriceValue);
				} else {
					Integer moapPrice = optionNextGenerationPrice.getMoapPrice();
					BigDecimal mowWage = optionNextGenerationPrice.getMowWage();
					BigDecimal nextGenerationWageValue = mowWage;
					Integer nextGenerationPriceValue = moapPrice;
					order.setProductIs3pieceWsWage(nextGenerationWageValue);
					order.setProductIs3pieceWsPrice(nextGenerationPriceValue);
				}
				break;
			} else {
				order.setProductIs3pieceWsWage(new BigDecimal(0.0));
				order.setProductIs3pieceWsPrice(0);
			}
		}
	}

	/**
	 * 商品情報_スペアパンツ_下代工賃と下代付属をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 * @param basicNextGenerationPriceList
	 * @param optionNextGenerationPriceList
	 */
	public void getSparePantsNextGenerationPrice(OrderForm orderForm, Order order,
			List<NextGenerationPrice> basicNextGenerationPriceList,
			List<NextGenerationPrice> optionNextGenerationPriceList) {

		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// subItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();

		String optionCode = "00099";
		String optionBranchCode = orderForm.getProductSparePantsClass();

		String keyCode = itemCode + subItemCode + optionCode + optionBranchCode;
		for (NextGenerationPrice optionNextGenerationPrice : optionNextGenerationPriceList) {
			if (keyCode.equals(optionNextGenerationPrice.getKeyCode())) {

				BigDecimal mowWage = optionNextGenerationPrice.getMowWage();
				BigDecimal nextGenerationWageValue = mowWage;

				Integer moapPrice = optionNextGenerationPrice.getMoapPrice();
				Integer nextGenerationPriceValue = moapPrice;
				order.setProductSparePantsWsWage(nextGenerationWageValue);
				order.setProductSparePantsWsPrice(nextGenerationPriceValue);
				break;
			} else {
				order.setProductSparePantsWsWage(new BigDecimal(0.0));
				order.setProductSparePantsWsPrice(0);
			}
		}
	}

	/**
	 * 商品情報_ITEM表示用をデータベースに入力する
	 * 
	 * @param
	 *
	 */
	public void setProductItemDisplayCode(OrderForm orderForm, Order order) {
		// 商品情報_ITEM
		String itemCode = orderForm.getProductItem();
		// 商品情報_３Piece
		String product3Piece = orderForm.getProductIs3Piece();
		// 商品情報_スペアパンツ
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		// 01:SUIT
		String suitCode = "01";
		// ３Pieceまたはスペアパンツは有り
		String productYes = "0009902";
		// ３Pieceまたはスペアパンツは無し
		String productNo = "0009901";
		// SUIT(2p)：21
		String item2p = "21";
		// SUIT(2pp)：22
		String item2pp = "22";
		// SUIT(3p)：31
		String item3p = "31";
		// SUIT(3p2pp)：32
		String item3p2pp = "32";
		if (itemCode.equals(suitCode)) {
			if (productYes.equals(product3Piece) && productYes.equals(productSparePantsClass)) {
				order.setProductItemDisplaycode(item3p2pp);
			} else if (productYes.equals(product3Piece) && productNo.equals(productSparePantsClass)) {
				order.setProductItemDisplaycode(item3p);
			} else if (productNo.equals(product3Piece) && productYes.equals(productSparePantsClass)) {
				order.setProductItemDisplaycode(item2pp);
			} else if (productNo.equals(product3Piece) && productNo.equals(productSparePantsClass)) {
				order.setProductItemDisplaycode(item2p);
			}
		} else {
			order.setProductItemDisplaycode(null);
		}
	}

	/**
	 * Integerの変換
	 * 
	 * @param result
	 * @return
	 */
	public Integer commonTransfer(Object result) {
		Integer resultReturn = 0;
		if (result == null || "".equals(result)) {
			return resultReturn;
		}
		resultReturn = Integer.parseInt(result.toString());
		return resultReturn;
	}

	/**
	 * BigDecimalの変換
	 * 
	 * @param result
	 * @return
	 */
	public BigDecimal BigDecimalCommonTransfer(Object result) {
		BigDecimal resultReturn = new BigDecimal(0.0);
		if (result == null || "".equals(result)) {
			return resultReturn;
		}
		resultReturn = new BigDecimal(result.toString());
		return resultReturn;
	}

	/**
	 * JACKET_下代工賃合計
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal jkNextGenerationWageTotal(Order order) {

		BigDecimal jkWageTotal = new BigDecimal(0.0);
		JacketOptionStandardNextGenerationPriceEnum[] priceEnum = JacketOptionStandardNextGenerationPriceEnum.values();
		for (JacketOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFour = price.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFour = getMethod(cls, valueFour);
				Object[] args = {};
				Object resultFour = null;

				if (myMethodFour != null) {
					resultFour = ReflectionUtils.invoke(myMethodFour, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFour);
				jkWageTotal = result.add(jkWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return jkWageTotal;
	}

	/**
	 * JACKET_下代付属合計
	 * 
	 * @param order
	 * @return
	 */
	public Integer jkNextGenerationPriceTotal(Order order) {

		Integer jkPriceTotal = 0;
		JacketOptionStandardNextGenerationPriceEnum[] priceEnum = JacketOptionStandardNextGenerationPriceEnum.values();
		for (JacketOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] argsTwo = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, argsTwo);
				}

				Integer result = commonTransfer(resultFive);
				jkPriceTotal = result + jkPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return jkPriceTotal;
	}

	/**
	 * JACKET_下代工賃合計 (オプション付属詳細価格を含む)
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal jkNextGenerationDetailWageTotal(Order order) {

		BigDecimal jkDetailWageTotal = new BigDecimal(0.0);
		JacketOptionDetailStandardNextGenerationPriceEnum[] priceEnum = JacketOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (JacketOptionDetailStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFive);
				jkDetailWageTotal = result.add(jkDetailWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return jkDetailWageTotal;
	}

	/**
	 * JACKET_下代付属合計 (オプション付属詳細価格を含む)
	 * 
	 * @param order
	 * @return
	 */
	public Integer jkNextGenerationDetailPriceTotal(Order order) {

		Integer jkDetailPriceTotal = 0;
		JacketOptionDetailStandardNextGenerationPriceEnum[] priceEnum = JacketOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (JacketOptionDetailStandardNextGenerationPriceEnum price : priceEnum) {

			String valueSix = price.getValueSix();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodSix = getMethod(cls, valueSix);
				Object[] args = {};
				Object resultSix = null;

				if (myMethodSix != null) {
					resultSix = ReflectionUtils.invoke(myMethodSix, order, args);
				}

				Integer result = commonTransfer(resultSix);
				jkDetailPriceTotal = result + jkDetailPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return jkDetailPriceTotal;
	}

	/**
	 * PANTS_下代工賃合計
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal ptNextGenerationWageTotal(Order order) {

		BigDecimal ptWageTotal = new BigDecimal(0.0);
		PantsOptionStandardNextGenerationPriceEnum[] priceEnum = PantsOptionStandardNextGenerationPriceEnum.values();
		for (PantsOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFour = price.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFour = getMethod(cls, valueFour);
				Object[] args = {};
				Object resultFour = null;

				if (myMethodFour != null) {
					resultFour = ReflectionUtils.invoke(myMethodFour, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFour);
				ptWageTotal = result.add(ptWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		BigDecimal ptBtnMaterialWsWage;
		if (order.getPtBtnMaterialWsWage() == null) {
			ptBtnMaterialWsWage = new BigDecimal(0.0);
			ptWageTotal = ptBtnMaterialWsWage.add(ptWageTotal);
		} else {
			ptBtnMaterialWsWage = order.getPtBtnMaterialWsWage();
			ptWageTotal = ptBtnMaterialWsWage.add(ptWageTotal);
		}
		return ptWageTotal;
	}

	/**
	 * PANTS_下代付属合計
	 * 
	 * @param order
	 * @return
	 */
	public Integer ptNextGenerationPriceTotal(Order order) {

		Integer ptPriceTotal = 0;
		PantsOptionStandardNextGenerationPriceEnum[] priceEnum = PantsOptionStandardNextGenerationPriceEnum.values();
		for (PantsOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				Integer result = commonTransfer(resultFive);
				ptPriceTotal = result + ptPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		Integer ptBtnMaterialWsPrice;
		if (order.getPtBtnMaterialWsPrice() == null) {
			ptBtnMaterialWsPrice = 0;
			ptPriceTotal = ptBtnMaterialWsPrice + ptPriceTotal;
		} else {
			ptBtnMaterialWsPrice = order.getPtBtnMaterialWsPrice();
			ptPriceTotal = ptBtnMaterialWsPrice + ptPriceTotal;
		}
		return ptPriceTotal;
	}

	/**
	 * GILET_下代工賃合計
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal glNextGenerationWageTotal(Order order) {

		BigDecimal glWageTotal = new BigDecimal(0.0);
		GiletOptionStandardNextGenerationPriceEnum[] priceEnum = GiletOptionStandardNextGenerationPriceEnum.values();
		for (GiletOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFour = price.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFour = getMethod(cls, valueFour);
				Object[] args = {};
				Object resultFour = null;

				if (myMethodFour != null) {
					resultFour = ReflectionUtils.invoke(myMethodFour, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFour);
				glWageTotal = result.add(glWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return glWageTotal;
	}

	/**
	 * GILET_下代付属合計
	 * 
	 * @param order
	 * @return
	 */
	public Integer glNextGenerationPriceTotal(Order order) {

		Integer glPriceTotal = 0;
		GiletOptionStandardNextGenerationPriceEnum[] priceEnum = GiletOptionStandardNextGenerationPriceEnum.values();
		for (GiletOptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				Integer result = commonTransfer(resultFive);
				glPriceTotal = result + glPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return glPriceTotal;
	}

	/**
	 * GILET_下代工賃合計 (オプション付属詳細価格を含む)
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal glNextGenerationDetailWageTotal(Order order) {

		BigDecimal glDetailWageTotal = new BigDecimal(0.0);
		GiletOptionDetailStandardNextGenerationPriceEnum[] priceEnum = GiletOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (GiletOptionDetailStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFive);
				glDetailWageTotal = result.add(glDetailWageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return glDetailWageTotal;
	}

	/**
	 * GILET_下代付属合計 (オプション付属詳細価格を含む)
	 * 
	 * @param order
	 * @return
	 */
	public Integer glNextGenerationDetailPriceTotal(Order order) {

		Integer glDetailPriceTotal = 0;
		GiletOptionDetailStandardNextGenerationPriceEnum[] priceEnum = GiletOptionDetailStandardNextGenerationPriceEnum
				.values();
		for (GiletOptionDetailStandardNextGenerationPriceEnum price : priceEnum) {

			String valueSix = price.getValueSix();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodSix = getMethod(cls, valueSix);
				Object[] args = {};
				Object resultSix = null;

				if (myMethodSix != null) {
					resultSix = ReflectionUtils.invoke(myMethodSix, order, args);
				}

				Integer result = commonTransfer(resultSix);
				glDetailPriceTotal = result + glDetailPriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return glDetailPriceTotal;
	}

	/**
	 * PANTS2_下代工賃合計
	 * 
	 * @param order
	 * @return
	 */
	public BigDecimal pt2NextGenerationWageTotal(Order order) {

		BigDecimal pt2WageTotal = new BigDecimal(0.0);
		Pants2OptionStandardNextGenerationPriceEnum[] priceEnum = Pants2OptionStandardNextGenerationPriceEnum.values();
		for (Pants2OptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFour = price.getValueFour();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFour = getMethod(cls, valueFour);
				Object[] args = {};
				Object resultFour = null;

				if (myMethodFour != null) {
					resultFour = ReflectionUtils.invoke(myMethodFour, order, args);
				}

				BigDecimal result = BigDecimalCommonTransfer(resultFour);
				pt2WageTotal = result.add(pt2WageTotal);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		BigDecimal pt2BtnMaterialWsWage;
		if (order.getPt2BtnMaterialWsWage() == null) {
			pt2BtnMaterialWsWage = new BigDecimal(0.0);
			pt2WageTotal = pt2BtnMaterialWsWage.add(pt2WageTotal);
		} else {
			pt2BtnMaterialWsWage = order.getPt2BtnMaterialWsWage();
			pt2WageTotal = pt2BtnMaterialWsWage.add(pt2WageTotal);
		}
		return pt2WageTotal;
	}

	/**
	 * PANTS2_下代付属合計
	 * 
	 * @param order
	 * @return
	 */
	public Integer pt2NextGenerationPriceTotal(Order order) {

		Integer pt2PriceTotal = 0;
		Pants2OptionStandardNextGenerationPriceEnum[] priceEnum = Pants2OptionStandardNextGenerationPriceEnum.values();
		for (Pants2OptionStandardNextGenerationPriceEnum price : priceEnum) {

			String valueFive = price.getValueFive();

			Class<?> cls;
			try {
				cls = Class.forName("co.jp.aoyama.macchinetta.domain.model.Order");
				Method myMethodFive = getMethod(cls, valueFive);
				Object[] args = {};
				Object resultFive = null;

				if (myMethodFive != null) {
					resultFive = ReflectionUtils.invoke(myMethodFive, order, args);
				}

				Integer result = commonTransfer(resultFive);
				pt2PriceTotal = result + pt2PriceTotal;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		Integer pt2BtnMaterialWsPrice;
		if (order.getPt2BtnMaterialWsPrice() == null) {
			pt2BtnMaterialWsPrice = 0;
			pt2PriceTotal = pt2BtnMaterialWsPrice + pt2PriceTotal;
		} else {
			pt2BtnMaterialWsPrice = order.getPt2BtnMaterialWsPrice();
			pt2PriceTotal = pt2BtnMaterialWsPrice + pt2PriceTotal;
		}
		return pt2PriceTotal;
	}

	/**
	 * JACKET要尺の取得
	 * 
	 * @param orderForm
	 * @param yieldList
	 * @return
	 */
	public Integer getJacketYield(OrderForm orderForm, List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String jkSubItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		String ojFrontBtnCnt = "0000105";
		for (NextGenerationPrice yield : yieldList) {
			if (jkSubItemCode.equals(yield.getSubItemCode())) {
				// フロント釦数はダブル6つボタンの場合、該当itemはダブル
				if (ojFrontBtnCnt.equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
					jkYield = yield.getDoubleBreastedFabricAmount();
					return jkYield;
				} else {
					jkYield = yield.getNomalFabricAmount();
					return jkYield;
				}
			}
		}
		return jkYield;
	}

	/**
	 * JACKET要尺の取得
	 * 
	 * @param orderForm
	 * @param yieldList
	 * @return
	 */
	public Integer getJacketYield(Order order, List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String jkSubItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		String ojFrontBtnCnt = "0000105";
		for (NextGenerationPrice yield : yieldList) {
			if (jkSubItemCode.equals(yield.getSubItemCode())) {
				// フロント釦数はダブル6つボタンの場合、該当itemはダブル
				if (ojFrontBtnCnt.equals(order.getJkFrtBtnCd())) {
					jkYield = yield.getDoubleBreastedFabricAmount();
					return jkYield;
				} else {
					jkYield = yield.getNomalFabricAmount();
					return jkYield;
				}
			}
		}
		return jkYield;
	}

	/**
	 * GILET要尺の取得
	 * 
	 * @param yieldList
	 * @return
	 */
	public Integer getGiletYield(List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String glSubItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		for (NextGenerationPrice yield : yieldList) {
			if (glSubItemCode.equals(yield.getSubItemCode())) {
				jkYield = yield.getNomalFabricAmount();
				return jkYield;
			}
		}
		return jkYield;
	}

	/**
	 * PANTS要尺の取得
	 * 
	 * @param yieldList
	 * @return
	 */
	public Integer getPantsYield(List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String ptSubItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
		for (NextGenerationPrice yield : yieldList) {
			if (ptSubItemCode.equals(yield.getSubItemCode())) {
				jkYield = yield.getNomalFabricAmount();
				return jkYield;
			}
		}
		return jkYield;
	}

	/**
	 * PANTS2要尺の取得
	 * 
	 * @param yieldList
	 * @return
	 */
	public Integer getPants2Yield(List<NextGenerationPrice> yieldList) {

		Integer jkYield = 0;
		String pt2SubItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		for (NextGenerationPrice yield : yieldList) {
			if (pt2SubItemCode.equals(yield.getSubItemCode())) {
				jkYield = yield.getNomalFabricAmount();
				return jkYield;
			}
		}
		return jkYield;
	}

	/**
	 * ドル為替の取得
	 * 
	 * @param wholesalePieceList
	 * @return
	 */
	public BigDecimal getDollarExchange(OrderForm orderForm, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = orderForm.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		BigDecimal productDollarExchange = new BigDecimal(0.0);

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productDollarExchange = wholesalePiece.getDollarExchange();
				return productDollarExchange;
			} else {
				productDollarExchange = new BigDecimal(100.0);
			}
		}
		return productDollarExchange;
	}

	/**
	 * ドル為替の取得
	 * 
	 * @param wholesalePieceList
	 * @return
	 */
	public BigDecimal getDollarExchange(Order order, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = order.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		BigDecimal productDollarExchange = new BigDecimal(0.0);

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productDollarExchange = wholesalePiece.getDollarExchange();
				return productDollarExchange;
			} else {
				productDollarExchange = new BigDecimal(100.0);
			}
		}
		return productDollarExchange;
	}

	/**
	 * 製品関税の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Double getProductTariff(OrderForm orderForm, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = orderForm.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Double productTariff = 0.0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productTariff = wholesalePiece.getProductTariff();
				return productTariff;
			} else {
				productTariff = 100.0;
			}
		}
		return productTariff;
	}

	/**
	 * 製品関税の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Double getProductTariff(Order order, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = order.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Double productTariff = 0.0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productTariff = wholesalePiece.getProductTariff();
				return productTariff;
			} else {
				productTariff = 100.0;
			}
		}
		return productTariff;
	}

	/**
	 * 製品運賃の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Integer getProductShipping(OrderForm orderForm, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = orderForm.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Integer productShipping = 0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productShipping = wholesalePiece.getProductShipping();
				return productShipping;
			}
		}
		return productShipping;
	}

	/**
	 * 製品運賃の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Integer getProductShipping(Order order, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = order.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Integer productShipping = 0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				productShipping = wholesalePiece.getProductShipping();
				return productShipping;
			}
		}
		return productShipping;
	}

	/**
	 * 運賃誤差の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Integer getShippingError(OrderForm orderForm, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = orderForm.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Integer shippingError = 0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				shippingError = wholesalePiece.getShippingError();
				return shippingError;
			}
		}
		return shippingError;
	}

	/**
	 * 運賃誤差の取得
	 * 
	 * @param orderForm
	 * @param wholesalePieceList
	 * @param factoryCode
	 * @return
	 */
	public Integer getShippingError(Order order, List<NextGenerationPrice> wholesalePieceList,
			NextGenerationPrice priceCode) {

		String mfaFactoryCode = priceCode.getMfaFactoryCode();
		String productItem = order.getProductItem();
		String wholesaleKeyCode = mfaFactoryCode + productItem;
		Integer shippingError = 0;

		for (NextGenerationPrice wholesalePiece : wholesalePieceList) {
			if (wholesaleKeyCode.equals(wholesalePiece.getWholesaleKeyCode())) {
				shippingError = wholesalePiece.getShippingError();
				return shippingError;
			}
		}
		return shippingError;
	}

	/**
	 * 基本工賃合計
	 * 
	 * @param orderForm
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public BigDecimal baseWageCount(OrderForm orderForm, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String itemCode = orderForm.getProductItem();
		String jkSubItemCode = "02";
		BigDecimal baseWageTotal = new BigDecimal(0.0);

		if ("01".equals(itemCode)) {
			if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				BigDecimal mdbwWage = this.getDoubleWage(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage).add(mdbwWage);
			} else {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage);
			}
		} else if ("02".equals(itemCode)) {
			if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				BigDecimal mdbwWage = this.getDoubleWage(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage).add(mdbwWage);
			} else {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage);
			}

		} else if ("03".equals(itemCode)) {
			BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
			baseWageTotal = baseWageTotal.add(mbwWage);
		} else if ("04".equals(itemCode)) {
			BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
			baseWageTotal = baseWageTotal.add(mbwWage);
		}
		return baseWageTotal;
	}

	/**
	 * 基本工賃合計
	 * 
	 * @param orderForm
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public BigDecimal baseWageCount(Order order, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String itemCode = order.getProductItem();
		String jkSubItemCode = "02";
		BigDecimal baseWageTotal = new BigDecimal(0.0);

		if ("01".equals(itemCode)) {
			if ("0000105".equals(order.getJkFrtBtnCd())) {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				BigDecimal mdbwWage = this.getDoubleWage(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage).add(mdbwWage);
			} else {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage);
			}
		} else if ("02".equals(itemCode)) {
			if ("0000105".equals(order.getJkFrtBtnCd())) {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				BigDecimal mdbwWage = this.getDoubleWage(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage).add(mdbwWage);
			} else {
				BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
				baseWageTotal = baseWageTotal.add(mbwWage);
			}

		} else if ("03".equals(itemCode)) {
			BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
			baseWageTotal = baseWageTotal.add(mbwWage);
		} else if ("04".equals(itemCode)) {
			BigDecimal mbwWage = this.getWage(itemCode, basicNextGenerationPriceList);
			baseWageTotal = baseWageTotal.add(mbwWage);
		}
		return baseWageTotal;
	}

	/**
	 * 基本付属合計
	 * 
	 * @param orderForm
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public Integer basePriceCount(OrderForm orderForm, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String itemCode = orderForm.getProductItem();
		String jkSubItemCode = "02";
		Integer basePriceTotal = 0;

		if ("01".equals(itemCode)) {
			if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				Integer mdbapPrice = this.getDoublePrice(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice + mdbapPrice;
			} else {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice;
			}
		} else if ("02".equals(itemCode)) {
			if ("0000105".equals(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt())) {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				Integer mdbapPrice = this.getDoublePrice(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice + mdbapPrice;
			} else {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice;
			}

		} else if ("03".equals(itemCode)) {
			Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
			basePriceTotal = basePriceTotal + mnapPrice;
		} else if ("04".equals(itemCode)) {
			Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
			basePriceTotal = basePriceTotal + mnapPrice;
		}
		return basePriceTotal;
	}

	/**
	 * 基本付属合計
	 * 
	 * @param orderForm
	 * @param basicNextGenerationPriceList
	 * @return
	 */
	public Integer basePriceCount(Order order, List<NextGenerationPrice> basicNextGenerationPriceList) {
		String itemCode = order.getProductItem();
		String jkSubItemCode = "02";
		Integer basePriceTotal = 0;

		if ("01".equals(itemCode)) {
			if ("0000105".equals(order.getJkFrtBtnCd())) {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				Integer mdbapPrice = this.getDoublePrice(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice + mdbapPrice;
			} else {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice;
			}
		} else if ("02".equals(itemCode)) {
			if ("0000105".equals(order.getJkFrtBtnCd())) {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				Integer mdbapPrice = this.getDoublePrice(itemCode, jkSubItemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice + mdbapPrice;
			} else {
				Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
				basePriceTotal = basePriceTotal + mnapPrice;
			}

		} else if ("03".equals(itemCode)) {
			Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
			basePriceTotal = basePriceTotal + mnapPrice;
		} else if ("04".equals(itemCode)) {
			Integer mnapPrice = this.getPrice(itemCode, basicNextGenerationPriceList);
			basePriceTotal = basePriceTotal + mnapPrice;
		}
		return basePriceTotal;
	}

	/**
	 * 下代関連計算方法
	 * 
	 * @param order
	 * @param yieldList
	 * @param wholesalePieceList
	 * @param priceCode
	 * @param marginRate
	 * @return
	 */
	public Integer nextGenerationRelationCount(Order order, List<NextGenerationPrice> yieldList,
			List<NextGenerationPrice> wholesalePieceList, List<NextGenerationPrice> basicNextGenerationPriceList,
			NextGenerationPrice priceCode, NextGenerationPrice marginRate) {
		// 下代関連計算方法の オプション工賃
		BigDecimal jkNextGenerationWageTotal = this.jkNextGenerationWageTotal(order);
		BigDecimal jkNextGenerationDetailWageTotal = this.jkNextGenerationDetailWageTotal(order);
		BigDecimal glNextGenerationWageTotal = this.glNextGenerationWageTotal(order);
		BigDecimal glNextGenerationDetailWageTotal = this.glNextGenerationDetailWageTotal(order);
		BigDecimal ptNextGenerationWageTotal = this.ptNextGenerationWageTotal(order);
		BigDecimal pt2NextGenerationWageTotal = this.pt2NextGenerationWageTotal(order);

		// 基本工賃
		BigDecimal baseWageCount = this.baseWageCount(order, basicNextGenerationPriceList);
		// 商品情報_３Piece下代工賃
		BigDecimal productIs3pieceWsWage = order.getProductIs3pieceWsWage();
		// 商品情報_スペアパンツ下代工賃
		BigDecimal productSparePantsWsWage = order.getProductSparePantsWsWage();
		// 基本工賃 + オプション工賃合計
		BigDecimal NextGenerationWageTotal = baseWageCount.add(jkNextGenerationWageTotal)
				.add(jkNextGenerationDetailWageTotal).add(glNextGenerationWageTotal)
				.add(glNextGenerationDetailWageTotal).add(ptNextGenerationWageTotal).add(pt2NextGenerationWageTotal)
				.add(productIs3pieceWsWage).add(productSparePantsWsWage);

		// 下代関連計算方法の オプション付属
		Integer jkNextGenerationPriceTotal = this.jkNextGenerationPriceTotal(order);
		Integer jkNextGenerationDetailPriceTotal = this.jkNextGenerationDetailPriceTotal(order);
		Integer glNextGenerationPriceTotal = this.glNextGenerationPriceTotal(order);
		Integer glNextGenerationDetailPriceTotal = this.glNextGenerationDetailPriceTotal(order);
		Integer ptNextGenerationPriceTotal = this.ptNextGenerationPriceTotal(order);
		Integer pt2NextGenerationPriceTotal = this.pt2NextGenerationPriceTotal(order);

		// 基本付属代
		Integer basePriceCount = this.basePriceCount(order, basicNextGenerationPriceList);
		// 商品情報_３Piece_下代付属
		Integer productIs3pieceWsPrice = order.getProductIs3pieceWsPrice();
		// 商品情報_スペアパンツ下代付属
		Integer productSparePantsWsPrice = order.getProductSparePantsWsPrice();
		// オプション付属合計
		Integer NextGenerationPriceTotal = basePriceCount + jkNextGenerationPriceTotal
				+ jkNextGenerationDetailPriceTotal + glNextGenerationPriceTotal + glNextGenerationDetailPriceTotal
				+ ptNextGenerationPriceTotal + pt2NextGenerationPriceTotal + productIs3pieceWsPrice
				+ productSparePantsWsPrice;

		// 下代関連計算方法の要尺
		Integer jacketYield = this.getJacketYield(order, yieldList);
		Integer giletYield = this.getGiletYield(yieldList);
		Integer pants2Yield = this.getPants2Yield(yieldList);
		Integer pantsYield = this.getPantsYield(yieldList);
		// 要尺合計
		Double yieldTotal = (double) (jacketYield + giletYield + pantsYield + pants2Yield) / 1000;

		// 下代関連計算方法の生地代
		Integer fabricPrice = priceCode.getFabricPrice();

		// 下代関連計算方法の下代調整金
		Integer wsPriceAdjust = priceCode.getWsPriceAdjust();

		// 下代関連計算方法の為替
		BigDecimal dollarExchange = this.getDollarExchange(order, wholesalePieceList, priceCode);

		// 下代関連計算方法の製品関税
		Double productTariff = this.getProductTariff(order, wholesalePieceList, priceCode);

		// 下代関連計算方法の製品運賃
		Integer productShipping = this.getProductShipping(order, wholesalePieceList, priceCode);

		// 下代関連計算方法の運賃誤差
		Integer shippingError = this.getShippingError(order, wholesalePieceList, priceCode);

		// 下代関連計算方法のメーカーマージン
		Double makerMarginRate = marginRate.getMarginRate();

		/*
		 * ( ( ( (生地代×要尺) + (基本工賃 + オプション工賃) * 為替 + (基本付属代 ＋ オプション付属) )*製品関税 ) ＋
		 * 製品運賃＋運賃誤差 )*メーカーマージン+ 下代調整金
		 */

		// 生地代×要尺
		BigDecimal fabricPriceYieldTotal = BigDecimalCommonTransfer((fabricPrice * yieldTotal));
		// (基本付属代 ＋ オプション付属)
		BigDecimal NextGenerationPriceTotalTransfer = BigDecimalCommonTransfer(NextGenerationPriceTotal);
		// 製品関税
		BigDecimal productTariffTransfer = BigDecimalCommonTransfer((productTariff / 100));
		// 製品運賃＋運賃誤差
		BigDecimal productShippingShippingError = BigDecimalCommonTransfer(productShipping + shippingError);
		// メーカーマージン
		BigDecimal makerMarginRateTransfer = BigDecimalCommonTransfer((makerMarginRate / 100));
		// 下代調整金
		BigDecimal wsPriceAdjustTransfer = BigDecimalCommonTransfer(wsPriceAdjust);

		BigDecimal nextGenerationRelationCount = (((fabricPriceYieldTotal
				.add(NextGenerationWageTotal.multiply(dollarExchange)).add(NextGenerationPriceTotalTransfer))
						.multiply(productTariffTransfer)).add(productShippingShippingError))
								.multiply(makerMarginRateTransfer).add(wsPriceAdjustTransfer);
		Integer convertNumber = this.convertNumber(nextGenerationRelationCount);
		return convertNumber;
	}

	/**
	 * 下代関連計算方法
	 * 
	 * @param orderForm
	 * @param order
	 * @param yieldList
	 * @param wholesalePieceList
	 * @param priceCode
	 * @param marginRate
	 */
	public void nextGenerationRelationCount(OrderForm orderForm, Order order, List<NextGenerationPrice> yieldList,
			List<NextGenerationPrice> wholesalePieceList, List<NextGenerationPrice> basicNextGenerationPriceList,
			NextGenerationPrice priceCode, NextGenerationPrice marginRate) {
		// 下代関連計算方法のオプション工賃
		BigDecimal jkNextGenerationWageTotal = this.jkNextGenerationWageTotal(order);
		BigDecimal jkNextGenerationDetailWageTotal = this.jkNextGenerationDetailWageTotal(order);
		BigDecimal glNextGenerationWageTotal = this.glNextGenerationWageTotal(order);
		BigDecimal glNextGenerationDetailWageTotal = this.glNextGenerationDetailWageTotal(order);
		BigDecimal ptNextGenerationWageTotal = this.ptNextGenerationWageTotal(order);
		BigDecimal pt2NextGenerationWageTotal = this.pt2NextGenerationWageTotal(order);
		// 基本工賃
		BigDecimal baseWageCount = this.baseWageCount(orderForm, basicNextGenerationPriceList);
		// 商品情報_３Piece下代工賃
		BigDecimal productIs3pieceWsWage = order.getProductIs3pieceWsWage();
		// 商品情報_スペアパンツ下代工賃
		BigDecimal productSparePantsWsWage = order.getProductSparePantsWsWage();
		// 基本工賃 + オプション工賃合計
		BigDecimal NextGenerationWageTotal = baseWageCount.add(jkNextGenerationWageTotal)
				.add(jkNextGenerationDetailWageTotal).add(glNextGenerationWageTotal)
				.add(glNextGenerationDetailWageTotal).add(ptNextGenerationWageTotal).add(pt2NextGenerationWageTotal)
				.add(productIs3pieceWsWage).add(productSparePantsWsWage);

		// 下代関連計算方法のオプション付属
		Integer jkNextGenerationPriceTotal = this.jkNextGenerationPriceTotal(order);
		Integer jkNextGenerationDetailPriceTotal = this.jkNextGenerationDetailPriceTotal(order);
		Integer glNextGenerationPriceTotal = this.glNextGenerationPriceTotal(order);
		Integer glNextGenerationDetailPriceTotal = this.glNextGenerationDetailPriceTotal(order);
		Integer ptNextGenerationPriceTotal = this.ptNextGenerationPriceTotal(order);
		Integer pt2NextGenerationPriceTotal = this.pt2NextGenerationPriceTotal(order);

		// 基本付属代
		Integer basePriceCount = this.basePriceCount(orderForm, basicNextGenerationPriceList);
		// 商品情報_３Piece_下代付属
		Integer productIs3pieceWsPrice = order.getProductIs3pieceWsPrice();
		// 商品情報_スペアパンツ下代付属
		Integer productSparePantsWsPrice = order.getProductSparePantsWsPrice();
		// 基本付属代 ＋ オプション付属合計
		Integer NextGenerationPriceTotal = basePriceCount + jkNextGenerationPriceTotal
				+ jkNextGenerationDetailPriceTotal + glNextGenerationPriceTotal + glNextGenerationDetailPriceTotal
				+ ptNextGenerationPriceTotal + pt2NextGenerationPriceTotal + productIs3pieceWsPrice
				+ productSparePantsWsPrice;

		// 下代関連計算方法の要尺
		Integer jacketYield = this.getJacketYield(orderForm, yieldList);
		Integer giletYield = this.getGiletYield(yieldList);
		Integer pants2Yield = this.getPants2Yield(yieldList);
		Integer pantsYield = this.getPantsYield(yieldList);
		// 要尺合計
		Double yieldTotal = (double) (jacketYield + giletYield + pantsYield + pants2Yield) / 1000;

		// 下代関連計算方法の生地代
		Integer fabricPrice = priceCode.getFabricPrice();

		// 下代関連計算方法の下代調整金
		Integer wsPriceAdjust = priceCode.getWsPriceAdjust();

		// 下代関連計算方法の為替
		BigDecimal dollarExchange = this.getDollarExchange(orderForm, wholesalePieceList, priceCode);

		// 下代関連計算方法の製品関税
		Double productTariff = this.getProductTariff(orderForm, wholesalePieceList, priceCode);

		// 下代関連計算方法の製品運賃
		Integer productShipping = this.getProductShipping(orderForm, wholesalePieceList, priceCode);

		// 下代関連計算方法の運賃誤差
		Integer shippingError = this.getShippingError(orderForm, wholesalePieceList, priceCode);

		// 下代関連計算方法のメーカーマージン
		Double makerMarginRate = marginRate.getMarginRate();

		/*
		 * ( ( ( (生地代×要尺) + (基本工賃 + オプション工賃) * 為替 + (基本付属代 ＋ オプション付属) )*製品関税 ) ＋
		 * 製品運賃＋運賃誤差 )*メーカーマージン + 下代調整金
		 */

		// (生地代×要尺)
		BigDecimal fabricPriceYieldTotal = BigDecimalCommonTransfer((fabricPrice * yieldTotal));
		// (基本付属代 ＋ オプション付属)
		BigDecimal NextGenerationPriceTotalTransfer = BigDecimalCommonTransfer(NextGenerationPriceTotal);
		// 製品関税
		BigDecimal productTariffTransfer = BigDecimalCommonTransfer((productTariff / 100));
		// 製品運賃＋運賃誤差
		BigDecimal productShippingShippingError = BigDecimalCommonTransfer(productShipping + shippingError);
		// メーカーマージン
		BigDecimal makerMarginRateTransfer = BigDecimalCommonTransfer((makerMarginRate / 100));
		// 下代調整金
		BigDecimal wsPriceAdjustTransfer = BigDecimalCommonTransfer(wsPriceAdjust);
		BigDecimal nextGenerationRelationCount = (((fabricPriceYieldTotal
				.add(NextGenerationWageTotal.multiply(dollarExchange)).add(NextGenerationPriceTotalTransfer))
						.multiply(productTariffTransfer)).add(productShippingShippingError))
								.multiply(makerMarginRateTransfer).add(wsPriceAdjustTransfer);
		Integer convertNumber = this.convertNumber(nextGenerationRelationCount);
		order.setWsPrice(convertNumber);
	}

	/**
	 * 計算結果の1円の桁は切り捨て
	 * 
	 * @return
	 */
	public Integer convertNumber(BigDecimal nextGenerationRelationCount) {
		BigDecimal nextGenerationCount = nextGenerationRelationCount.setScale(0, RoundingMode.DOWN);
		Integer nextGeneration = Integer.parseInt(nextGenerationCount.toString());
		nextGeneration = nextGeneration - (nextGeneration % 10);
		return nextGeneration;
	}

	/**
	 * 再補正値が「お渡し時再補正入力」画面からオーダー詳細画面に伝わる
	 * 
	 * @param orderForm
	 * @param order
	 * @param userId
	 */
	public void dealWithCorrectAgain(OrderForm orderForm, Order order, String userId) {
		String suitItemCode = "01";
		String jacketItemCode = "02";
		String pantsItemCode = "03";
		String suit2PP = "22";
		String suit3P2PP = "32";
		String productItemDisplaycode = order.getProductItemDisplaycode();
		String productItem = order.getProductItem();
		if (suitItemCode.equals(productItem)) {
			// JACKET_着丈_再補正値
			String corJkBodylengthCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkBodylengthCorrectAgain();
			BigDecimal corJkBodylengthCorrectA = convertBigDecimal(corJkBodylengthCorrectAgain);
			// JACKET_着丈_再補正値フラッグ
			String corJkBodylengthCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkBodylengthCorrectAgainFlag();
			BigDecimal corJkBodylengthCorrectAgainF = new BigDecimal(corJkBodylengthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkBodylengthCorrect = corJkBodylengthCorrectA.multiply(corJkBodylengthCorrectAgainF);
			// JACKET_着丈_再補正値
			order.setCorJkBodylengthCorrectAgain(corJkBodylengthCorrect);

			// JACKET_ウエスト_再補正値
			String corJkWaistCorrectAgain = orderForm.getAdjustJacketStandardInfo().getCorJkWaistCorrectAgain();
			BigDecimal corJkWaistCorrectA = convertBigDecimal(corJkWaistCorrectAgain);
			// JACKET_ウエスト_再補正値フラッグ
			String corJkWaistCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo().getCorJkWaistCorrectAgainFlag();
			BigDecimal corJkWaistCorrectAgainF = new BigDecimal(corJkWaistCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkWaistCorrect = corJkWaistCorrectA.multiply(corJkWaistCorrectAgainF);
			// JACKET_ウエスト_再補正値
			order.setCorJkWaistCorrectAgain(corJkWaistCorrect);

			// JACKET_袖丈右_再補正値
			String corJkRightsleeveCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkRightsleeveCorrectAgain();
			BigDecimal corJkRightsleeveCorrectA = convertBigDecimal(corJkRightsleeveCorrectAgain);
			// JACKET_袖丈右_再補正値フラッグ
			String corJkRightsleeveCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkRightsleeveCorrectAgainFlag();
			BigDecimal corJkRightsleeveCorrectAgainF = new BigDecimal(corJkRightsleeveCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkRightsleeveCorrect = corJkRightsleeveCorrectA.multiply(corJkRightsleeveCorrectAgainF);
			// JACKET_袖丈右_再補正値
			order.setCorJkRightsleeveCorrectAgain(corJkRightsleeveCorrect);

			// JACKET_袖丈左_再補正値
			String corJkLeftsleeveCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkLeftsleeveCorrectAgain();
			BigDecimal corJkLeftsleeveCorrectA = convertBigDecimal(corJkLeftsleeveCorrectAgain);
			// JACKET_袖丈左_再補正値フラッグ
			String corJkLeftsleeveCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkLeftsleeveCorrectAgainFlag();
			BigDecimal corJkLeftsleeveCorrectAgainF = new BigDecimal(corJkLeftsleeveCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkLeftsleeveCorrect = corJkLeftsleeveCorrectA.multiply(corJkLeftsleeveCorrectAgainF);
			// JACKET_袖丈左_再補正値
			order.setCorJkLeftsleeveCorrectAgain(corJkLeftsleeveCorrect);

			// PANTS_ウエスト_再補正値
			String corPtWaistCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtWaistCorrectAgain();
			BigDecimal corPtWaistCorrectA = convertBigDecimal(corPtWaistCorrectAgain);
			// PANTS_ウエスト_再補正値フラッグ
			String corPtWaistCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo().getCorPtWaistCorrectAgainFlag();
			BigDecimal corPtWaistCorrectAgainF = new BigDecimal(corPtWaistCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtWaistCorrect = corPtWaistCorrectA.multiply(corPtWaistCorrectAgainF);
			// PANTS_ウエスト_再補正値
			order.setCorPtWaistCorrectAgain(corPtWaistCorrect);

			// PANTS_ヒップ_再補正値
			String corPtHipCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtHipCorrectAgain();
			BigDecimal corPtHipCorrectA = convertBigDecimal(corPtHipCorrectAgain);
			// PANTS_ヒップ_再補正値フラッグ
			String corPtHipCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo().getCorPtHipCorrectAgainFlag();
			BigDecimal corPtHipCorrectAgainF = new BigDecimal(corPtHipCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtHipCorrect = corPtHipCorrectA.multiply(corPtHipCorrectAgainF);
			// PANTS_ヒップ_再補正値
			order.setCorPtHipCorrectAgain(corPtHipCorrect);

			// PANTS_ワタリ_再補正値
			String corPtThighwidthCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtThighwidthCorrectAgain();
			BigDecimal corPtThighwidthCorrectA = convertBigDecimal(corPtThighwidthCorrectAgain);
			// PANTS_ワタリ_再補正値フラッグ
			String corPtThighwidthCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtThighwidthCorrectAgainFlag();
			BigDecimal corPtThighwidthCorrectAgainF = new BigDecimal(corPtThighwidthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtThighwidthCorrect = corPtThighwidthCorrectA.multiply(corPtThighwidthCorrectAgainF);
			// PANTS_ワタリ_再補正値
			order.setCorPtThighwidthCorrectAgain(corPtThighwidthCorrect);

			// PANTS_裾幅_修正_再補正値
			String corPtHemwidthCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtHemwidthCorrectAgain();
			BigDecimal corPtHemwidthCorrectA = convertBigDecimal(corPtHemwidthCorrectAgain);
			// PANTS_裾幅_修正_再補正値フラッグ
			String corPtHemwidthCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtHemwidthCorrectAgainFlag();
			BigDecimal corPtHemwidthCorrectAgainF = new BigDecimal(corPtHemwidthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtHemwidthCorrect = corPtHemwidthCorrectA.multiply(corPtHemwidthCorrectAgainF);
			// PANTS_裾幅_修正_再補正値
			order.setCorPtHemwidthCorrectAgain(corPtHemwidthCorrect);

			// PANTS_股下右_再補正値
			String corPtRightinseamCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtRightinseamCorrectAgain();
			BigDecimal corPtRightinseamCorrectA = convertBigDecimal(corPtRightinseamCorrectAgain);
			// PANTS_股下右_再補正値フラッグ
			String corPtRightinseamCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtRightinseamCorrectAgainFlag();
			BigDecimal corPtRightinseamCorrectAgainF = new BigDecimal(corPtRightinseamCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtRightinseamCorrect = corPtRightinseamCorrectA.multiply(corPtRightinseamCorrectAgainF);
			// PANTS_股下右_再補正値
			order.setCorPtRightinseamCorrectAgain(corPtRightinseamCorrect);

			// PANTS_股下左_再補正値
			String corPtLeftinseamCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtLeftinseamCorrectAgain();
			BigDecimal corPtLeftinseamCorrectA = convertBigDecimal(corPtLeftinseamCorrectAgain);
			// PANTS_股下左_再補正値フラッグ
			String corPtLeftinseamCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtLeftinseamCorrectAgainFlag();
			BigDecimal corPtLeftinseamCorrectAgainF = new BigDecimal(corPtLeftinseamCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtLeftinseamCorrect = corPtLeftinseamCorrectA.multiply(corPtLeftinseamCorrectAgainF);
			// PANTS_股下左_再補正値
			order.setCorPtLeftinseamCorrectAgain(corPtLeftinseamCorrect);

			if (suit2PP.equals(productItemDisplaycode) || suit3P2PP.equals(productItemDisplaycode)) {
				// ２PANTS_ウエスト_再補正値
				String corPt2WaistCorrectAgain = orderForm.getAdjustPants2StandardInfo().getCorPt2WaistCorrectAgain();
				BigDecimal corPt2WaistCorrectA = convertBigDecimal(corPt2WaistCorrectAgain);
				// ２PANTS_ウエスト_再補正値フラッグ
				String corPt2WaistCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2WaistCorrectAgainFlag();
				BigDecimal corPt2WaistCorrectAgainF = new BigDecimal(corPt2WaistCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2WaistCorrect = corPt2WaistCorrectA.multiply(corPt2WaistCorrectAgainF);
				// ２PANTS_ウエスト_再補正値
				order.setCorPt2WaistCorrectAgain(corPt2WaistCorrect);

				// ２PANTS_ヒップ_再補正値
				String corPt2HipCorrectAgain = orderForm.getAdjustPants2StandardInfo().getCorPt2HipCorrectAgain();
				BigDecimal corPt2HipCorrectA = convertBigDecimal(corPt2HipCorrectAgain);
				// ２PANTS_ヒップ_再補正値フラッグ
				String corPt2HipCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2HipCorrectAgainFlag();
				BigDecimal corPt2HipCorrectAgainF = new BigDecimal(corPt2HipCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2HipCorrect = corPt2HipCorrectA.multiply(corPt2HipCorrectAgainF);
				// ２PANTS_ヒップ_再補正値
				order.setCorPt2HipCorrectAgain(corPt2HipCorrect);

				// 2PANTS_ワタリ_再補正値
				String corPt2ThighwidthCorrectAgain = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2ThighwidthCorrectAgain();
				BigDecimal corPt2ThighwidthCorrectA = convertBigDecimal(corPt2ThighwidthCorrectAgain);
				// 2PANTS_ワタリ_再補正値フラッグ
				String corPt2ThighwidthCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2ThighwidthCorrectAgainFlag();
				BigDecimal corPt2ThighwidthCorrectAgainF = new BigDecimal(corPt2ThighwidthCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2ThighwidthCorrect = corPt2ThighwidthCorrectA.multiply(corPt2ThighwidthCorrectAgainF);
				// 2PANTS_ワタリ_再補正値
				order.setCorPt2ThighwidthCorrectAgain(corPt2ThighwidthCorrect);

				// 2PANTS_裾幅_修正_再補正値
				String corPt2HemwidthCorrectAgain = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2HemwidthCorrectAgain();
				BigDecimal corPt2HemwidthCorrectA = convertBigDecimal(corPt2HemwidthCorrectAgain);
				// 2PANTS_裾幅_修正_再補正値フラッグ
				String corPt2HemwidthCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2HemwidthCorrectAgainFlag();
				BigDecimal corPt2HemwidthCorrectAgainF = new BigDecimal(corPt2HemwidthCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2HemwidthCorrect = corPt2HemwidthCorrectA.multiply(corPt2HemwidthCorrectAgainF);
				// 2PANTS_裾幅_修正_再補正値
				order.setCorPt2HemwidthCorrectAgain(corPt2HemwidthCorrect);

				// 2PANTS_股下右_再補正値
				String corPt2RightinseamCorrectAgain = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2RightinseamCorrectAgain();
				BigDecimal corPt2RightinseamCorrectA = convertBigDecimal(corPt2RightinseamCorrectAgain);
				// 2PANTS_股下右_再補正値フラッグ
				String corPt2RightinseamCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2RightinseamCorrectAgainFlag();
				BigDecimal corPt2RightinseamCorrectAgainF = new BigDecimal(corPt2RightinseamCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2RightinseamCorrect = corPt2RightinseamCorrectA
						.multiply(corPt2RightinseamCorrectAgainF);
				// 2PANTS_股下右_再補正値
				order.setCorPt2RightinseamCorrectAgain(corPt2RightinseamCorrect);

				// 2PANTS_股下左_再補正値
				String corPt2LeftinseamCorrectAgain = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2LeftinseamCorrectAgain();
				BigDecimal corPt2LeftinseamCorrectA = convertBigDecimal(corPt2LeftinseamCorrectAgain);
				// 2PANTS_股下左_再補正値フラッグ
				String corPt2LeftinseamCorrectAgainFlag = orderForm.getAdjustPants2StandardInfo()
						.getCorPt2LeftinseamCorrectAgainFlag();
				BigDecimal corPt2LeftinseamCorrectAgainF = new BigDecimal(corPt2LeftinseamCorrectAgainFlag);
				// 再補正値*再補正値フラッグ
				BigDecimal corPt2LeftinseamCorrect = corPt2LeftinseamCorrectA.multiply(corPt2LeftinseamCorrectAgainF);
				// 2PANTS_股下左_再補正値
				order.setCorPt2LeftinseamCorrectAgain(corPt2LeftinseamCorrect);
			}
		} else if (jacketItemCode.equals(productItem)) {
			// JACKET_着丈_再補正値
			String corJkBodylengthCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkBodylengthCorrectAgain();
			BigDecimal corJkBodylengthCorrectA = convertBigDecimal(corJkBodylengthCorrectAgain);
			// JACKET_着丈_再補正値フラッグ
			String corJkBodylengthCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkBodylengthCorrectAgainFlag();
			BigDecimal corJkBodylengthCorrectAgainF = new BigDecimal(corJkBodylengthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkBodylengthCorrect = corJkBodylengthCorrectA.multiply(corJkBodylengthCorrectAgainF);
			// JACKET_着丈_再補正値
			order.setCorJkBodylengthCorrectAgain(corJkBodylengthCorrect);

			// JACKET_ウエスト_再補正値
			String corJkWaistCorrectAgain = orderForm.getAdjustJacketStandardInfo().getCorJkWaistCorrectAgain();
			BigDecimal corJkWaistCorrectA = convertBigDecimal(corJkWaistCorrectAgain);
			// JACKET_ウエスト_再補正値フラッグ
			String corJkWaistCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo().getCorJkWaistCorrectAgainFlag();
			BigDecimal corJkWaistCorrectAgainF = new BigDecimal(corJkWaistCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkWaistCorrect = corJkWaistCorrectA.multiply(corJkWaistCorrectAgainF);
			// JACKET_ウエスト_再補正値
			order.setCorJkWaistCorrectAgain(corJkWaistCorrect);

			// JACKET_袖丈右_再補正値
			String corJkRightsleeveCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkRightsleeveCorrectAgain();
			BigDecimal corJkRightsleeveCorrectA = convertBigDecimal(corJkRightsleeveCorrectAgain);
			// JACKET_袖丈右_再補正値フラッグ
			String corJkRightsleeveCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkRightsleeveCorrectAgainFlag();
			BigDecimal corJkRightsleeveCorrectAgainF = new BigDecimal(corJkRightsleeveCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkRightsleeveCorrect = corJkRightsleeveCorrectA.multiply(corJkRightsleeveCorrectAgainF);
			// JACKET_袖丈右_再補正値
			order.setCorJkRightsleeveCorrectAgain(corJkRightsleeveCorrect);

			// JACKET_袖丈左_再補正値
			String corJkLeftsleeveCorrectAgain = orderForm.getAdjustJacketStandardInfo()
					.getCorJkLeftsleeveCorrectAgain();
			BigDecimal corJkLeftsleeveCorrectA = convertBigDecimal(corJkLeftsleeveCorrectAgain);
			// JACKET_袖丈左_再補正値フラッグ
			String corJkLeftsleeveCorrectAgainFlag = orderForm.getAdjustJacketStandardInfo()
					.getCorJkLeftsleeveCorrectAgainFlag();
			BigDecimal corJkLeftsleeveCorrectAgainF = new BigDecimal(corJkLeftsleeveCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corJkLeftsleeveCorrect = corJkLeftsleeveCorrectA.multiply(corJkLeftsleeveCorrectAgainF);
			// JACKET_袖丈左_再補正値
			order.setCorJkLeftsleeveCorrectAgain(corJkLeftsleeveCorrect);
		} else if (pantsItemCode.equals(productItem)) {
			// PANTS_ウエスト_再補正値
			String corPtWaistCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtWaistCorrectAgain();
			BigDecimal corPtWaistCorrectA = convertBigDecimal(corPtWaistCorrectAgain);
			// PANTS_ウエスト_再補正値フラッグ
			String corPtWaistCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo().getCorPtWaistCorrectAgainFlag();
			BigDecimal corPtWaistCorrectAgainF = new BigDecimal(corPtWaistCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtWaistCorrect = corPtWaistCorrectA.multiply(corPtWaistCorrectAgainF);
			// PANTS_ウエスト_再補正値
			order.setCorPtWaistCorrectAgain(corPtWaistCorrect);

			// PANTS_ヒップ_再補正値
			String corPtHipCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtHipCorrectAgain();
			BigDecimal corPtHipCorrectA = convertBigDecimal(corPtHipCorrectAgain);
			// PANTS_ヒップ_再補正値フラッグ
			String corPtHipCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo().getCorPtHipCorrectAgainFlag();
			BigDecimal corPtHipCorrectAgainF = new BigDecimal(corPtHipCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtHipCorrect = corPtHipCorrectA.multiply(corPtHipCorrectAgainF);
			// PANTS_ヒップ_再補正値
			order.setCorPtHipCorrectAgain(corPtHipCorrect);

			// PANTS_ワタリ_再補正値
			String corPtThighwidthCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtThighwidthCorrectAgain();
			BigDecimal corPtThighwidthCorrectA = convertBigDecimal(corPtThighwidthCorrectAgain);
			// PANTS_ワタリ_再補正値フラッグ
			String corPtThighwidthCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtThighwidthCorrectAgainFlag();
			BigDecimal corPtThighwidthCorrectAgainF = new BigDecimal(corPtThighwidthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtThighwidthCorrect = corPtThighwidthCorrectA.multiply(corPtThighwidthCorrectAgainF);
			// PANTS_ワタリ_再補正値
			order.setCorPtThighwidthCorrectAgain(corPtThighwidthCorrect);

			// PANTS_裾幅_修正_再補正値
			String corPtHemwidthCorrectAgain = orderForm.getAdjustPantsStandardInfo().getCorPtHemwidthCorrectAgain();
			BigDecimal corPtHemwidthCorrectA = convertBigDecimal(corPtHemwidthCorrectAgain);
			// PANTS_裾幅_修正_再補正値フラッグ
			String corPtHemwidthCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtHemwidthCorrectAgainFlag();
			BigDecimal corPtHemwidthCorrectAgainF = new BigDecimal(corPtHemwidthCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtHemwidthCorrect = corPtHemwidthCorrectA.multiply(corPtHemwidthCorrectAgainF);
			// PANTS_裾幅_修正_再補正値
			order.setCorPtHemwidthCorrectAgain(corPtHemwidthCorrect);

			// PANTS_股下右_再補正値
			String corPtRightinseamCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtRightinseamCorrectAgain();
			BigDecimal corPtRightinseamCorrectA = convertBigDecimal(corPtRightinseamCorrectAgain);
			// PANTS_股下右_再補正値フラッグ
			String corPtRightinseamCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtRightinseamCorrectAgainFlag();
			BigDecimal corPtRightinseamCorrectAgainF = new BigDecimal(corPtRightinseamCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtRightinseamCorrect = corPtRightinseamCorrectA.multiply(corPtRightinseamCorrectAgainF);
			// PANTS_股下右_再補正値
			order.setCorPtRightinseamCorrectAgain(corPtRightinseamCorrect);

			// PANTS_股下左_再補正値
			String corPtLeftinseamCorrectAgain = orderForm.getAdjustPantsStandardInfo()
					.getCorPtLeftinseamCorrectAgain();
			BigDecimal corPtLeftinseamCorrectA = convertBigDecimal(corPtLeftinseamCorrectAgain);
			// PANTS_股下左_再補正値フラッグ
			String corPtLeftinseamCorrectAgainFlag = orderForm.getAdjustPantsStandardInfo()
					.getCorPtLeftinseamCorrectAgainFlag();
			BigDecimal corPtLeftinseamCorrectAgainF = new BigDecimal(corPtLeftinseamCorrectAgainFlag);
			// 再補正値*再補正値フラッグ
			BigDecimal corPtLeftinseamCorrect = corPtLeftinseamCorrectA.multiply(corPtLeftinseamCorrectAgainF);
			// PANTS_股下左_再補正値
			order.setCorPtLeftinseamCorrectAgain(corPtLeftinseamCorrect);
		}
		order.setUpdatedUserId(userId);
		order.setUpdatedAt(new Date());
		String corStoreCorrectionMemoAgain = orderForm.getCorStoreCorrectionMemoAgain().replaceAll("\\n", "");
		order.setCorStoreCorrectionMemoAgain(corStoreCorrectionMemoAgain);
	}

	/**
	 * 消費税を取得
	 * 
	 * @param taxRate
	 * @param orderForm
	 */
	public void getTaxRate(int taxRate, OrderForm orderForm) {
		String taxRateStr = String.valueOf(taxRate);
		orderForm.setTaxRate(taxRateStr);
	}

	/**
	 * 要尺を取得
	 * 
	 * @param taxRate
	 * @param orderForm
	 */
	public void getYield(List<Yield> yieldList, OrderForm orderForm) {
		orderForm.setYield(new Gson().toJson(yieldList));
	}

	/**
	 * 
	 * @param orderFabric
	 * @return
	 */
	public Map<String, Integer> getRetailPriceRelated(OrderFindFabric orderFabric) {

		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		// 上代
		Integer retailPrice = orderFabric.getRetailPrice();
		// ダブルJACKET増額率
		Integer additionalDoubleJacketRate = orderFabric.getAdditionalDoubleJacketRate();
		// シングルGILET追加増額率
		Integer additionalSingleGiletRate = orderFabric.getAdditionalSingleGiletRate();
		// PANTS追加増額率
		Integer additionalPantsRate = orderFabric.getAdditionalPantsRate();
		// 上代*シングルGILET追加増額率/100
		Integer single3PieceRetailPrice = retailPrice * additionalSingleGiletRate / 100;
		// 上代*PANTS追加増額率/100
		Integer sparePantsPrice = retailPrice * additionalPantsRate / 100;
		// ダブルJACKET単品率
		Integer doubleJacketOnlyRate = orderFabric.getDoubleJacketOnlyRate();
		// ダブルJacketの単品購買追加金額
		Integer jkDoubleOnlyPlusAlphaPrice = orderFabric.getJkDoubleOnlyPlusAlphaPrice();
		// シングルJACKET単品率
		Integer singleJacketOnlyRate = orderFabric.getSingleJacketOnlyRate();
		// シングルJacketの単品購買追加金額
		Integer jkSingleOnlyPlusAlphaPrice = orderFabric.getJkSingleOnlyPlusAlphaPrice();
		// (上代*ダブルJACKET単品率/100+「ダブルJacketの単品購買追加金額」) -
		// (上代*シングルJACKET単品率/100+「シングルJacketの単品購買追加金額」)
		Integer singleJacketDoublePrice = (retailPrice * doubleJacketOnlyRate / 100 + jkDoubleOnlyPlusAlphaPrice)
				- (retailPrice * singleJacketOnlyRate / 100 + jkSingleOnlyPlusAlphaPrice);

		priceMap.put("doubleJACKET", additionalDoubleJacketRate);
		priceMap.put("price3Piece", single3PieceRetailPrice);
		priceMap.put("sparePants", sparePantsPrice);
		priceMap.put("singleDoubleJACKET", singleJacketDoublePrice);

		return priceMap;

	}

	public void getFigureNumberMap(OrderForm orderForm) {
		LinkedHashMap<String, String> jkFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> ptFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> glFigureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> pt2FigureMap = new LinkedHashMap<String, String>();

		// 体型
		// JACKET
		jkFigureMap.put("", "選択　　　");
		// PANTS
		ptFigureMap.put("", "選択　　　");
		// GILET
		glFigureMap.put("", "選択　　　");
		// 2PANTS
		pt2FigureMap.put("", "選択　　　");

		// 号数
		LinkedHashMap<String, String> jkNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> ptNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> glNumberMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> pt2NumberMap = new LinkedHashMap<String, String>();

		// JACKET
		jkNumberMap.put("", "選択　　　");
		// PANTS
		ptNumberMap.put("", "選択　　　");
		// GILET
		glNumberMap.put("", "選択　　　");
		// 2PANTS
		pt2NumberMap.put("", "選択　　　");
		AdjustJacketStandardInfo adjustJacketStandardInfo = new AdjustJacketStandardInfo();
		adjustJacketStandardInfo.setSizeFigureMap(jkFigureMap);
		adjustJacketStandardInfo.setSizeNumberMap(jkNumberMap);
		orderForm.setAdjustJacketStandardInfo(adjustJacketStandardInfo);

		AdjustPantsStandardInfo adjustPantsStandardInfo = new AdjustPantsStandardInfo();
		adjustPantsStandardInfo.setSizeFigureMap(ptFigureMap);
		adjustPantsStandardInfo.setSizeNumberMap(ptNumberMap);
		orderForm.setAdjustPantsStandardInfo(adjustPantsStandardInfo);

		AdjustGiletStandardInfo adjustGiletStandardInfo = new AdjustGiletStandardInfo();
		adjustGiletStandardInfo.setSizeFigureMap(glFigureMap);
		adjustGiletStandardInfo.setSizeNumberMap(glNumberMap);
		orderForm.setAdjustGiletStandardInfo(adjustGiletStandardInfo);

		AdjustPants2StandardInfo adjustPants2StandardInfo = new AdjustPants2StandardInfo();
		adjustPants2StandardInfo.setSizeFigureMap(pt2FigureMap);
		adjustPants2StandardInfo.setSizeNumberMap(pt2NumberMap);
		orderForm.setAdjustPants2StandardInfo(adjustPants2StandardInfo);

	}
}
