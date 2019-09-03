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

import javax.servlet.http.HttpServletRequest;

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
import co.jp.aoyama.macchinetta.app.order.enums.coat.CoatCoOptionStandardUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.coat.CoatOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletCoOptionStandardNextUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletCoOptionTuxedoUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletCoOptionWashableUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionDetailStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionTuxedoCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionTuxedoColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionWashableCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.gilet.GiletOptionWashableColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketCoOptionStandardUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketCoOptionTuxedoUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketCoOptionWashableUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionDetailStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionTuxedoCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionTuxedoColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionWashableCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.jacket.JacketOptionWashableColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionStandardUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionTuxedoPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionTuxedoUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2CoOptionWashableUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionTuxedoCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.Pants2OptionWashableCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsCoOptionStandardUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsCoOptionTuxedoUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsCoOptionWashableUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardNextGenerationPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionStandardPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionTuxedoCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionTuxedoColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionWashableCodeEnum;
import co.jp.aoyama.macchinetta.app.order.enums.pants.PantsOptionWashableColorEnum;
import co.jp.aoyama.macchinetta.app.order.enums.shirt.ShirtCoOptionStandardUpperPriceEnum;
import co.jp.aoyama.macchinetta.app.order.enums.shirt.ShirtOptionStandardCodeEnum;
import co.jp.aoyama.macchinetta.app.order.info.AdjustCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.AdjustShirtStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.CustomerMessageInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionCoatStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionGiletWashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionJacketWashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPants2TuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPants2WashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsTuxedoInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionPantsWashableInfo;
import co.jp.aoyama.macchinetta.app.order.info.OptionShirtStandardInfo;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
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
	
	// 在庫チェックなし
	private static final String IS_NOT_THEORETICAL_STOCKCECK = "0";
	
	// 工場ステータス 生産開始前
	private static final String FACTORY_STATUSF0 = "F0";
	
	// 取り消しフラグ 取り消しではない
	private static final String IS_NOT_CANCELLED = "0";
	
	// 工場自動連携ステータス 送信前
	private static final String SEND2FACTORY_STATUS0 = "0";

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
					Pants2OptionStandardColorEnum[] pants2OptionColors = Pants2OptionStandardColorEnum.values();
					for (Pants2OptionStandardColorEnum one : pants2OptionColors) {
						String[] codeVules = one.toString().split(",");
						// オプション選択肢色コード ⇒ オプション選択肢色名
						optionBranchColorData(codeVules, pt2StandardList, cls, optionPants2StandardInfo);
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
			OptionPants2TuxedoInfo optionPants2TuxedoInfo = new OptionPants2TuxedoInfo();

			List<OptionBranch> pantsTuxedoList = new ArrayList<OptionBranch>();
			List<OptionBranch> jkTuxedoList = new ArrayList<OptionBranch>();
			List<OptionBranch> giletTuxedoList = new ArrayList<OptionBranch>();
			List<OptionBranch> pants2TuxedoList = new ArrayList<OptionBranch>();

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
				// 2PANTS
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
					pants2TuxedoList.add(optionBranch);
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
			// 2PANTS
			else if (itemCodeType.equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				Pants2OptionTuxedoCodeEnum[] pants2OptionTuxedoCodeEnum = Pants2OptionTuxedoCodeEnum.values();
				for (Pants2OptionTuxedoCodeEnum one : pants2OptionTuxedoCodeEnum) {
					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					optionBranchNameData(codeVules, pants2TuxedoList, cls, optionPants2TuxedoInfo);
				}
				orderForm.setOptionPants2TuxedoInfo(optionPants2TuxedoInfo);
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
			OptionPants2WashableInfo optionPants2WashableInfo = new OptionPants2WashableInfo();

			List<OptionBranch> jkWashableList = new ArrayList<OptionBranch>();
			List<OptionBranch> ptWashableList = new ArrayList<OptionBranch>();
			List<OptionBranch> glWashableList = new ArrayList<OptionBranch>();
			List<OptionBranch> pt2WashableList = new ArrayList<OptionBranch>();

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
				// 2PANTS
				else if (optionBranch.getSubItemCode().equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
					pt2WashableList.add(optionBranch);
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
			// 2PANTS
			else if (itemCodeType.equals(ItemTypeEnum.ITEM_CODE_PANTS2.getKey())) {
				Pants2OptionWashableCodeEnum[] pants2OptionWashableCodeEnum = Pants2OptionWashableCodeEnum.values();
				for (Pants2OptionWashableCodeEnum one : pants2OptionWashableCodeEnum) {
					String[] codeVules = one.toString().split(",");
					// オプション選択肢コード ⇒ オプション選択肢名
					optionBranchNameData(codeVules, pt2WashableList, cls, optionPants2WashableInfo);
				}
				orderForm.setOptionPants2WashableInfo(optionPants2WashableInfo);
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
	 * オーダー内容確認画面JACKEのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoStandardJacketMapping(OrderForm orderForm, Order order) {

		// JACKET_フロント釦数_名
		order.setJkFrtBtnNm(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCntMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt()));
		// JACKET_ラペルデザイン_名
		order.setJkLapelDesignNm(orderForm.getOptionJacketStandardInfo().getOjLapelDesignMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjLapelDesign()));
		// JACKET_グレード_名
		order.setJkGradeNm(orderForm.getOptionJacketStandardInfo().getOjGradeMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjGrade()));
		// JACKET_裏仕様 _名
		order.setJkInnerClothNm(orderForm.getOptionJacketStandardInfo().getOjGackSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjGackSpec()));
		// JACKET_台場_名
		order.setJkDaibaNm(orderForm.getOptionJacketStandardInfo().getOjFortMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjFort()));
		// JACKET_襟裏 _名
		order.setJkCollarInnerNm(orderForm.getOptionJacketStandardInfo().getOjBackCollarMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjBackCollar()));
		// JACKET_襟吊_名
		order.setJkCollarHangNm(orderForm.getOptionJacketStandardInfo().getOjChainHangeMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjChainHange()));
		// JACKET_ラペル幅 _名
		order.setJkLapelWidthNm(orderForm.getOptionJacketStandardInfo().getOjLapelWidthMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjLapelWidth()));
		// JACKET_フラワーホール_名
		order.setJkFlowerHoleNm(orderForm.getOptionJacketStandardInfo().getOjFlowerHoleMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjFlowerHole()));
		// JACKET_胸ポケット _名
		order.setJkBreastPktNm(orderForm.getOptionJacketStandardInfo().getOjBreastPktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjBreastPkt()));
		// JACKET_腰ポケット_名
		order.setJkWaistPktNm(orderForm.getOptionJacketStandardInfo().getOjWaistPktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjWaistPkt()));
		// JACKET_チェンジポケット_名
		order.setJkChgPktNm(orderForm.getOptionJacketStandardInfo().getOjChangePktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjChangePkt()));
		// JACKET_スランテッドポケット_名
		order.setJkSlantedPktNm(orderForm.getOptionJacketStandardInfo().getOjSlantedPktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjSlantedPkt()));
		// JACKET_忍びポケット_名
		order.setJkShinobiPktNm(orderForm.getOptionJacketStandardInfo().getOjCoinPktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjCoinPkt()));
		// JACKET_袖仕様_名
		order.setJkSleeveTypeNm(orderForm.getOptionJacketStandardInfo().getOjSleeveSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjSleeveSpec()));
		// JACKET_マニカ_名
		order.setJkManicaNm(orderForm.getOptionJacketStandardInfo().getOjManicaMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjManica()));
		// JACKET_袖口_名
		order.setJkCuffNm(orderForm.getOptionJacketStandardInfo().getOjCuffSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjCuffSpec()));
		// JACKET_下前胸内ポケット仕様_名
		order.setJkRightInnerPktTypeNm(orderForm.getOptionJacketStandardInfo().getOjBreastInnerPktMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjBreastInnerPkt()));
		// JACKET_ベント_名
		order.setJkVentNm(orderForm.getOptionJacketStandardInfo().getOjVentSpecMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjVentSpec()));
		// JACKET_形状記憶_名
		order.setJkShapeMemoryNm(orderForm.getOptionJacketStandardInfo().getOjShapeMemoryMap()
				.get(orderForm.getOptionJacketStandardInfo().getOjShapeMemory()));
	}

	/**
	 * オーダー内容確認画面JACKEのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoTuxedoJacketMapping(OrderForm orderForm, Order order) {

		// JACKET_フロント釦数_名
		order.setJkFrtBtnNm(orderForm.getOptionJacketTuxedoInfo().getTjFrontBtnCntMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjFrontBtnCnt()));
		// JACKET_ラペルデザイン_名
		order.setJkLapelDesignNm(orderForm.getOptionJacketTuxedoInfo().getTjLapelDesignMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjLapelDesign()));
		// JACKET_グレード_名
		order.setJkGradeNm(orderForm.getOptionJacketTuxedoInfo().getTjGradeMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjGrade()));
		// JACKET_裏仕様 _名
		order.setJkInnerClothNm(orderForm.getOptionJacketTuxedoInfo().getTjBackSpecMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjBackSpec()));
		// JACKET_台場_名
		order.setJkDaibaNm(orderForm.getOptionJacketTuxedoInfo().getTjFortMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjFort()));
		// JACKET_拝見地_名
		order.setJkLookClothNm(orderForm.getOptionJacketTuxedoInfo().getTjGlossFablicMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjGlossFablic()));
		// JACKET_襟裏 _名
		order.setJkCollarInnerNm(orderForm.getOptionJacketTuxedoInfo().getTjBackCollarMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjBackCollar()));
		// JACKET_襟吊_名
		order.setJkCollarHangNm(orderForm.getOptionJacketTuxedoInfo().getTjChainHangeMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjChainHange()));
		// JACKET_ラペル幅 _名
		order.setJkLapelWidthNm(orderForm.getOptionJacketTuxedoInfo().getTjLapelWidthMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjLapelWidth()));
		// JACKET_フラワーホール_名
		order.setJkFlowerHoleNm(orderForm.getOptionJacketTuxedoInfo().getTjFlowerHoleMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjFlowerHole()));
		// JACKET_胸ポケット _名
		order.setJkBreastPktNm(orderForm.getOptionJacketTuxedoInfo().getTjBreastPktMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjBreastPkt()));
		// JACKET_腰ポケット_名
		order.setJkWaistPktNm(orderForm.getOptionJacketTuxedoInfo().getTjWaistPktMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjWaistPkt()));
		// JACKET_チェンジポケット_名
		order.setJkChgPktNm(orderForm.getOptionJacketTuxedoInfo().getTjChangePktMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjChangePkt()));
		// JACKET_スランテッドポケット_名
		order.setJkSlantedPktNm(orderForm.getOptionJacketTuxedoInfo().getTjSlantedPktMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjSlantedPkt()));
		// JACKET_忍びポケット_名
		order.setJkShinobiPktNm(orderForm.getOptionJacketTuxedoInfo().getTjCoinPktMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjCoinPkt()));
		// JACKET_袖仕様_名
		order.setJkSleeveTypeNm(orderForm.getOptionJacketTuxedoInfo().getTjSleeveSpecMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjSleeveSpec()));
		// JACKET_マニカ_名
		order.setJkManicaNm(orderForm.getOptionJacketTuxedoInfo().getTjManicaMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjManica()));
		// JACKET_袖口_名
		order.setJkCuffNm(orderForm.getOptionJacketTuxedoInfo().getTjCuffSpecMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjCuffSpec()));
		// JACKET_内ポケット変更_名
		order.setJkInnerPktNm(orderForm.getOptionJacketTuxedoInfo().getTjInsidePktChangeMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjInsidePktChange()));
		// JACKET_下前胸内ポケット仕様_名
		order.setJkRightInnerPktTypeNm(orderForm.getOptionJacketTuxedoInfo().getTjBreastInnerPktMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjBreastInnerPkt()));
		// JACKET_ベント_名
		order.setJkVentNm(orderForm.getOptionJacketTuxedoInfo().getTjVentSpecMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjVentSpec()));
		// JACKET_形状記憶_名
		order.setJkShapeMemoryNm(orderForm.getOptionJacketTuxedoInfo().getTjShapeMemoryMap()
				.get(orderForm.getOptionJacketTuxedoInfo().getTjShapeMemory()));
	}

	/**
	 * オーダー内容確認画面JACKEのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoWashableJacketMapping(OrderForm orderForm, Order order) {

		// JACKET_フロント釦数_名
		order.setJkFrtBtnNm(orderForm.getOptionJacketWashableInfo().getWjFrontBtnCntMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjFrontBtnCnt()));
		// JACKET_ラペルデザイン_名
		order.setJkLapelDesignNm(orderForm.getOptionJacketWashableInfo().getWjLapelDesignMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjLapelDesign()));
		// JACKET_グレード_名
		order.setJkGradeNm(orderForm.getOptionJacketWashableInfo().getWjGradeMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjGrade()));
		// JACKET_裏仕様 _名
		order.setJkInnerClothNm(orderForm.getOptionJacketWashableInfo().getWjBackSpecMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjBackSpec()));
		// JACKET_台場_名
		order.setJkDaibaNm(orderForm.getOptionJacketWashableInfo().getWjFortMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjFort()));
		// JACKET_襟裏 _名
		order.setJkCollarInnerNm(orderForm.getOptionJacketWashableInfo().getWjBackCollarMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjBackCollar()));
		// JACKET_襟吊_名
		order.setJkCollarHangNm(orderForm.getOptionJacketWashableInfo().getWjChainHangeMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjChainHange()));
		// JACKET_ラペル幅 _名
		order.setJkLapelWidthNm(orderForm.getOptionJacketWashableInfo().getWjLapelWidthMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjLapelWidth()));
		// JACKET_フラワーホール_名
		order.setJkFlowerHoleNm(orderForm.getOptionJacketWashableInfo().getWjFlowerHoleMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjFlowerHole()));
		// JACKET_胸ポケット _名
		order.setJkBreastPktNm(orderForm.getOptionJacketWashableInfo().getWjBreastPktMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjBreastPkt()));
		// JACKET_腰ポケット_名
		order.setJkWaistPktNm(orderForm.getOptionJacketWashableInfo().getWjWaistPktMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjWaistPkt()));
		// JACKET_チェンジポケット_名
		order.setJkChgPktNm(orderForm.getOptionJacketWashableInfo().getWjChangePktMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjChangePkt()));
		// JACKET_スランテッドポケット_名
		order.setJkSlantedPktNm(orderForm.getOptionJacketWashableInfo().getWjSlantedPktMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjSlantedPkt()));
		// JACKET_忍びポケット_名
		order.setJkShinobiPktNm(orderForm.getOptionJacketWashableInfo().getWjCoinPktMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjCoinPkt()));
		// JACKET_袖仕様_名
		order.setJkSleeveTypeNm(orderForm.getOptionJacketWashableInfo().getWjSleeveSpecMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjSleeveSpec()));
		// JACKET_マニカ_名
		order.setJkManicaNm(orderForm.getOptionJacketWashableInfo().getWjManicaMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjManica()));
		// JACKET_袖口_名
		order.setJkCuffNm(orderForm.getOptionJacketWashableInfo().getWjCuffSpecMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjCuffSpec()));
		// JACKET_内ポケット変更_名
		order.setJkInnerPktNm(orderForm.getOptionJacketWashableInfo().getWjInsidePktChangeMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjInsidePktChange()));
		// JACKET_下前胸内ポケット仕様_名
		order.setJkRightInnerPktTypeNm(orderForm.getOptionJacketWashableInfo().getWjBreastInnerPktMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjBreastInnerPkt()));
		// JACKET_ベント_名
		order.setJkVentNm(orderForm.getOptionJacketWashableInfo().getWjVentSpecMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjVentSpec()));
		// JACKET_形状記憶_名
		order.setJkShapeMemoryNm(orderForm.getOptionJacketWashableInfo().getWjShapeMemoryMap()
				.get(orderForm.getOptionJacketWashableInfo().getWjShapeMemory()));
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
	 * オーダー内容確認画面GILETのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoStandardGiletMapping(OrderForm orderForm, Order order) {

		// GILET_胸ポケット _名
		order.setGlBreastPktNm(orderForm.getOptionGiletStandardInfo().getOgBreastPktMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgBreastPkt()));
		// GILET_腰ポケット _名
		order.setGlWaistPktNm(orderForm.getOptionGiletStandardInfo().getOgWaistPktMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgWaistPkt()));
		// GILET_腰ポケット形状 _名
		order.setGlWaistPktShapeNm(orderForm.getOptionGiletStandardInfo().getOgWaistPktSpecMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgWaistPktSpec()));
		// GILET_AMFステッチ _名
		order.setGlAmfStitchNm(orderForm.getOptionGiletStandardInfo().getOgStitchMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgStitch()));
		// GILET_バックベルト _名
		order.setGlBackBeltNm(orderForm.getOptionGiletStandardInfo().getOgBackBeltMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgBackBelt()));
		// GILET_ウォッチチェーン_名
		order.setGlWatchChainNm(orderForm.getOptionGiletStandardInfo().getOgWatchChainMap()
				.get(orderForm.getOptionGiletStandardInfo().getOgWatchChain()));
	}

	/**
	 * オーダー内容確認画面GILETのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoTuxedoGiletMapping(OrderForm orderForm, Order order) {

		// GILET_胸ポケット _名
		order.setGlBreastPktNm(orderForm.getOptionGiletTuxedoInfo().getTgBreastPktMap()
				.get(orderForm.getOptionGiletTuxedoInfo().getTgBreastPkt()));
		// GILET_腰ポケット _名
		order.setGlWaistPktNm(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktMap()
				.get(orderForm.getOptionGiletTuxedoInfo().getTgWaistPkt()));
		// GILET_腰ポケット形状 _名
		order.setGlWaistPktShapeNm(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktSpecMap()
				.get(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktSpec()));
		// GILET_腰ポケット素材 _名
		order.setGlWaistPktClothNm(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktMateMap()
				.get(orderForm.getOptionGiletTuxedoInfo().getTgWaistPktMate()));
		// GILET_AMFステッチ _名
		order.setGlAmfStitchNm(orderForm.getOptionGiletTuxedoInfo().getTgStitchMap()
				.get(orderForm.getOptionGiletTuxedoInfo().getTgStitch()));
		// GILET_バックベルト _名
		order.setGlBackBeltNm(orderForm.getOptionGiletTuxedoInfo().getTgBackBeltMap()
				.get(orderForm.getOptionGiletTuxedoInfo().getTgBackBelt()));
		// GILET_ウォッチチェーン_名
		order.setGlWatchChainNm(orderForm.getOptionGiletTuxedoInfo().getTgWatchChainMap()
				.get(orderForm.getOptionGiletTuxedoInfo().getTgWatchChain()));
	}

	/**
	 * オーダー内容確認画面GILETのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoWashableGiletMapping(OrderForm orderForm, Order order) {

		// GILET_胸ポケット _名
		order.setGlBreastPktNm(orderForm.getOptionGiletWashableInfo().getWgBreastPktMap()
				.get(orderForm.getOptionGiletWashableInfo().getWgBreastPkt()));
		// GILET_腰ポケット _名
		order.setGlWaistPktNm(orderForm.getOptionGiletWashableInfo().getWgWaistPktMap()
				.get(orderForm.getOptionGiletWashableInfo().getWgWaistPkt()));
		// GILET_腰ポケット形状 _名
		order.setGlWaistPktShapeNm(orderForm.getOptionGiletWashableInfo().getWgWaistPktSpecMap()
				.get(orderForm.getOptionGiletWashableInfo().getWgWaistPktSpec()));
		// GILET_AMFステッチ _名
		order.setGlAmfStitchNm(orderForm.getOptionGiletWashableInfo().getWgStitchMap()
				.get(orderForm.getOptionGiletWashableInfo().getWgStitch()));
		// GILET_バックベルト _名
		order.setGlBackBeltNm(orderForm.getOptionGiletWashableInfo().getWgBackBeltMap()
				.get(orderForm.getOptionGiletWashableInfo().getWgBackBelt()));
		// GILET_ウォッチチェーン_名
		order.setGlWatchChainNm(orderForm.getOptionGiletWashableInfo().getWgWatchChainMap()
				.get(orderForm.getOptionGiletWashableInfo().getWgWatchChain()));
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
	 * オーダー内容確認画面PANTSのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoStandardPantsMapping(OrderForm orderForm, Order order) {

		// PANTS_タック_名
		order.setPtTackNm(orderForm.getOptionPantsStandardInfo().getOpTackMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpTack()));
		// PANTS_膝裏_名
		order.setPtKneeinnerTypeNm(orderForm.getOptionPantsStandardInfo().getOpKneeBackMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpKneeBack()));
		// PANTS_膝裏素材_名
		order.setPtKneeinnerClothNm(orderForm.getOptionPantsStandardInfo().getOpKneeBackMateMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpKneeBackMate()));
		// PANTS_フロント仕様_名
		order.setPtFrtTypeNm(orderForm.getOptionPantsStandardInfo().getOpFrontSpecMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpFrontSpec()));
		// PANTS_パンチェリーナ_名
		order.setPtPancherinaNm(orderForm.getOptionPantsStandardInfo().getOpPancherinaMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpPancherina()));
		// PANTS_アジャスター_名
		order.setPtAdjusterNm(orderForm.getOptionPantsStandardInfo().getOpAdjusterMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpAdjuster()));
		// PANTS_ピンループ_名
		order.setPtPinloopNm(orderForm.getOptionPantsStandardInfo().getOpPinLoopMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpPinLoop()));
		// PANTS_脇ポケット_名
		order.setPtSidePktNm(orderForm.getOptionPantsStandardInfo().getOpSidePktMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpSidePkt()));
		// PANTS_忍びポケット_名
		order.setPtShinobiPktNm(orderForm.getOptionPantsStandardInfo().getOpSinobiPktMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpSinobiPkt()));
		// PANTS_コインポケット_名
		order.setPtCoinPktNm(orderForm.getOptionPantsStandardInfo().getOpCoinPktMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpCoinPkt()));
		// PANTS_フラップ付コインポケット_名
		order.setPtFlapcoinPktNm(orderForm.getOptionPantsStandardInfo().getOpFlapCoinPktMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpFlapCoinPkt()));
		// PANTS_上前ピスポケット_名
		order.setPtLeftPisPktNm(orderForm.getOptionPantsStandardInfo().getOpPisPktUfMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpPisPktUf()));
		// PANTS_下前ピスポケット_名
		order.setPtRightPisPktNm(orderForm.getOptionPantsStandardInfo().getOpPisPktDfMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpPisPktDf()));
		// PANTS_Vカット_名
		order.setPtVCutNm(orderForm.getOptionPantsStandardInfo().getOpVCutMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpVCut()));
		// PANTS_裾上げ_名
		order.setPtHemUpNm(orderForm.getOptionPantsStandardInfo().getOpHemUpMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpHemUp()));
		// PANTS_ダブル幅_名
		order.setPtDblWidthNm(orderForm.getOptionPantsStandardInfo().getOpDoubleWideMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpDoubleWide()));
		// PANTS_AMFステッチ_名
		order.setPtAmfStitchNm(orderForm.getOptionPantsStandardInfo().getOpStitchMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpStitch()));
		// PANTS_サスペンダー釦 _名
		order.setPtSuspenderBtnNm(orderForm.getOptionPantsStandardInfo().getOpSuspenderBtnMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpSuspenderBtn()));
		// PANTS_シック（股下補強） _名
		order.setPtChicSlipNm(orderForm.getOptionPantsStandardInfo().getOpThickMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpThick()));
		// PANTS_エイト（滑り止め） _名
		order.setPtNonSlipNm(orderForm.getOptionPantsStandardInfo().getOpEightMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpEight()));
		// PANTS_形状記憶 _名
		order.setPtShapeMemoryNm(orderForm.getOptionPantsStandardInfo().getOpShapeMemoryMap()
				.get(orderForm.getOptionPantsStandardInfo().getOpShapeMemory()));
	}

	/**
	 * オーダー内容確認画面PANTSのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoTuxedoPantsMapping(OrderForm orderForm, Order order) {

		// PANTS_タック_名
		order.setPtTackNm(orderForm.getOptionPantsTuxedoInfo().getTpTackMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpTack()));
		// PANTS_膝裏_名
		order.setPtKneeinnerTypeNm(orderForm.getOptionPantsTuxedoInfo().getTpKneeBackMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpKneeBack()));
		// PANTS_膝裏素材_名
		order.setPtKneeinnerClothNm(orderForm.getOptionPantsTuxedoInfo().getTpKneeBackMateMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpKneeBackMate()));
		// PANTS_フロント仕様_名
		order.setPtFrtTypeNm(orderForm.getOptionPantsTuxedoInfo().getTpFrontSpecMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpFrontSpec()));
		// PANTS_パンチェリーナ_名
		order.setPtPancherinaNm(orderForm.getOptionPantsTuxedoInfo().getTpPancherinaMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpPancherina()));
		// PANTS_アジャスター_名
		order.setPtAdjusterNm(orderForm.getOptionPantsTuxedoInfo().getTpAdjusterMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpAdjuster()));
		// PANTS_ピンループ_名
		order.setPtPinloopNm(orderForm.getOptionPantsTuxedoInfo().getTpPinLoopMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpPinLoop()));
		// PANTS_脇ポケット_名
		order.setPtSidePktNm(orderForm.getOptionPantsTuxedoInfo().getTpSidePktMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpSidePkt()));
		// PANTS_忍びポケット_名
		order.setPtShinobiPktNm(orderForm.getOptionPantsTuxedoInfo().getTpSinobiPktMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpSinobiPkt()));
		// PANTS_コインポケット_名
		order.setPtCoinPktNm(orderForm.getOptionPantsTuxedoInfo().getTpCoinPktMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpCoinPkt()));
		// PANTS_フラップ付コインポケット_名
		order.setPtFlapcoinPktNm(orderForm.getOptionPantsTuxedoInfo().getTpFlapCoinPktMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpFlapCoinPkt()));
		// PANTS_上前ピスポケット_名
		order.setPtLeftPisPktNm(orderForm.getOptionPantsTuxedoInfo().getTpPisPktUfMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpPisPktUf()));
		// PANTS_下前ピスポケット_名
		order.setPtRightPisPktNm(orderForm.getOptionPantsTuxedoInfo().getTpPisPktDfMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpPisPktDf()));
		// PANTS_Vカット_名
		order.setPtVCutNm(orderForm.getOptionPantsTuxedoInfo().getTpVCutMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpVCut()));
		// PANTS_裾上げ_名
		order.setPtHemUpNm(orderForm.getOptionPantsTuxedoInfo().getTpHemUpMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpHemUp()));
		// PANTS_ダブル幅_名
		order.setPtDblWidthNm(orderForm.getOptionPantsTuxedoInfo().getTpDoubleWideMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpDoubleWide()));
		// PANTS_AMFステッチ_名
		order.setPtAmfStitchNm(orderForm.getOptionPantsTuxedoInfo().getTpStitchMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpStitch()));
		// PANTS_サスペンダー釦 _名
		order.setPtSuspenderBtnNm(orderForm.getOptionPantsTuxedoInfo().getTpSuspenderBtnMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpSuspenderBtn()));
		// PANTS_シック（股下補強） _名
		order.setPtChicSlipNm(orderForm.getOptionPantsTuxedoInfo().getTpThickMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpThick()));
		// PANTS_エイト（滑り止め） _名
		order.setPtNonSlipNm(orderForm.getOptionPantsTuxedoInfo().getTpEightMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpEight()));
		// PANTS_形状記憶 _名
		order.setPtShapeMemoryNm(orderForm.getOptionPantsTuxedoInfo().getTpShapeMemoryMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpShapeMemory()));
		// PANTS_側章 _名
		order.setPtSideStripeNm(orderForm.getOptionPantsTuxedoInfo().getTpSideStripeMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpSideStripe()));
		// PANTS_側章幅 _名
		order.setPtSideStripeWidthNm(orderForm.getOptionPantsTuxedoInfo().getTpSideStripeWidthMap()
				.get(orderForm.getOptionPantsTuxedoInfo().getTpSideStripeWidth()));
	}

	/**
	 * オーダー内容確認画面PANTSのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoWashablePantsMapping(OrderForm orderForm, Order order) {

		// PANTS_タック_名
		order.setPtTackNm(orderForm.getOptionPantsWashableInfo().getWpTackMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpTack()));
		// PANTS_膝裏_名
		order.setPtKneeinnerTypeNm(orderForm.getOptionPantsWashableInfo().getWpKneeBackMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpKneeBack()));
		// PANTS_膝裏素材_名
		order.setPtKneeinnerClothNm(orderForm.getOptionPantsWashableInfo().getWpKneeBackMateMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpKneeBackMate()));
		// PANTS_フロント仕様_名
		order.setPtFrtTypeNm(orderForm.getOptionPantsWashableInfo().getWpFrontSpecMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpFrontSpec()));
		// PANTS_パンチェリーナ_名
		order.setPtPancherinaNm(orderForm.getOptionPantsWashableInfo().getWpPancherinaMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpPancherina()));
		// PANTS_アジャスター_名
		order.setPtAdjusterNm(orderForm.getOptionPantsWashableInfo().getWpAdjusterMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpAdjuster()));
		// PANTS_ピンループ_名
		order.setPtPinloopNm(orderForm.getOptionPantsWashableInfo().getWpPinLoopMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpPinLoop()));
		// PANTS_脇ポケット_名
		order.setPtSidePktNm(orderForm.getOptionPantsWashableInfo().getWpSidePktMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpSidePkt()));
		// PANTS_忍びポケット_名
		order.setPtShinobiPktNm(orderForm.getOptionPantsWashableInfo().getWpSinobiPktMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpSinobiPkt()));
		// PANTS_コインポケット_名
		order.setPtCoinPktNm(orderForm.getOptionPantsWashableInfo().getWpCoinPktMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpCoinPkt()));
		// PANTS_フラップ付コインポケット_名
		order.setPtFlapcoinPktNm(orderForm.getOptionPantsWashableInfo().getWpFlapCoinPktMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpFlapCoinPkt()));
		// PANTS_上前ピスポケット_名
		order.setPtLeftPisPktNm(orderForm.getOptionPantsWashableInfo().getWpPisPktUfMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpPisPktUf()));
		// PANTS_下前ピスポケット_名
		order.setPtRightPisPktNm(orderForm.getOptionPantsWashableInfo().getWpPisPktDfMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpPisPktDf()));
		// PANTS_Vカット_名
		order.setPtVCutNm(orderForm.getOptionPantsWashableInfo().getWpVCutMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpVCut()));
		// PANTS_裾上げ_名
		order.setPtHemUpNm(orderForm.getOptionPantsWashableInfo().getWpHemUpMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpHemUp()));
		// PANTS_ダブル幅_名
		order.setPtDblWidthNm(orderForm.getOptionPantsWashableInfo().getWpDoubleWideMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpDoubleWide()));
		// PANTS_AMFステッチ_名
		order.setPtAmfStitchNm(orderForm.getOptionPantsWashableInfo().getWpStitchMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpStitch()));
		// PANTS_サスペンダー釦 _名
		order.setPtSuspenderBtnNm(orderForm.getOptionPantsWashableInfo().getWpSuspenderBtnMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpSuspenderBtn()));
		// PANTS_シック（股下補強） _名
		order.setPtChicSlipNm(orderForm.getOptionPantsWashableInfo().getWpThickMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpThick()));
		// PANTS_エイト（滑り止め） _名
		order.setPtNonSlipNm(orderForm.getOptionPantsWashableInfo().getWpEightMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpEight()));
		// PANTS_形状記憶 _名
		order.setPtShapeMemoryNm(orderForm.getOptionPantsWashableInfo().getWpShapeMemoryMap()
				.get(orderForm.getOptionPantsWashableInfo().getWpShapeMemory()));
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
	 * オーダー内容確認画面PANTS2のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoStandardPants2Mapping(OrderForm orderForm, Order order) {

		// 2PANTS_タック_名
		order.setPt2TackNm(orderForm.getOptionPants2StandardInfo().getOp2TackMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Tack()));
		// 2PANTS_膝裏_名
		order.setPt2KneeinnerTypeNm(orderForm.getOptionPants2StandardInfo().getOp2KneeBackMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2KneeBack()));
		// 2PANTS_膝裏素材_名
		order.setPt2KneeinnerClothNm(orderForm.getOptionPants2StandardInfo().getOp2KneeBackMateMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2KneeBackMate()));
		// 2PANTS_フロント仕様_名
		order.setPt2FrtTypeNm(orderForm.getOptionPants2StandardInfo().getOp2FrontSpecMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2FrontSpec()));
		// 2PANTS_パンチェリーナ_名
		order.setPt2PancherinaNm(orderForm.getOptionPants2StandardInfo().getOp2PancherinaMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Pancherina()));
		// 2PANTS_アジャスター_名
		order.setPt2AdjusterNm(orderForm.getOptionPants2StandardInfo().getOp2AdjusterMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Adjuster()));
		// 2PANTS_ピンループ_名
		order.setPt2PinloopNm(orderForm.getOptionPants2StandardInfo().getOp2PinLoopMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2PinLoop()));
		// 2PANTS_脇ポケット_名
		order.setPt2SidePktNm(orderForm.getOptionPants2StandardInfo().getOp2SidePktMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2SidePkt()));
		// 2PANTS_忍びポケット_名
		order.setPt2ShinobiPktNm(orderForm.getOptionPants2StandardInfo().getOp2SinobiPktMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2SinobiPkt()));
		// 2PANTS_コインポケット_名
		order.setPt2CoinPktNm(orderForm.getOptionPants2StandardInfo().getOp2CoinPktMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2CoinPkt()));
		// 2PANTS_フラップ付コインポケット_名
		order.setPt2FlapcoinPktNm(orderForm.getOptionPants2StandardInfo().getOp2FlapCoinPktMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2FlapCoinPkt()));
		// 2PANTS_上前ピスポケット_名
		order.setPt2LeftPisPktNm(orderForm.getOptionPants2StandardInfo().getOp2PisPktUfMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2PisPktUf()));
		// 2PANTS_下前ピスポケット_名
		order.setPt2RightPisPktNm(orderForm.getOptionPants2StandardInfo().getOp2PisPktDfMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2PisPktDf()));
		// 2PANTS_Vカット_名
		order.setPt2VCutNm(orderForm.getOptionPants2StandardInfo().getOp2VCutMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2VCut()));
		// 2PANTS_裾上げ_名
		order.setPt2HemUpNm(orderForm.getOptionPants2StandardInfo().getOp2HemUpMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2HemUp()));
		// 2PANTS_ダブル幅_名
		order.setPt2DblWidthNm(orderForm.getOptionPants2StandardInfo().getOp2DoubleWideMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2DoubleWide()));
		// 2PANTS_AMFステッチ_名
		order.setPt2AmfStitchNm(orderForm.getOptionPants2StandardInfo().getOp2StitchMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Stitch()));
		// 2PANTS_サスペンダー釦 _名
		order.setPt2SuspenderBtnNm(orderForm.getOptionPants2StandardInfo().getOp2SuspenderBtnMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2SuspenderBtn()));
		// 2PANTS_シック（股下補強） _名
		order.setPt2ChicSlipNm(orderForm.getOptionPants2StandardInfo().getOp2ThickMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Thick()));
		// 2PANTS_エイト（滑り止め） _名
		order.setPt2NonSlipNm(orderForm.getOptionPants2StandardInfo().getOp2EightMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2Eight()));
		// 2PANTS_形状記憶 _名
		order.setPt2ShapeMemoryNm(orderForm.getOptionPants2StandardInfo().getOp2ShapeMemoryMap()
				.get(orderForm.getOptionPants2StandardInfo().getOp2ShapeMemory()));
	}

	/**
	 * オーダー内容確認画面PANTS2のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoTuxedoPants2Mapping(OrderForm orderForm, Order order) {

		// 2PANTS_タック_名
		order.setPt2TackNm(orderForm.getOptionPants2TuxedoInfo().getTp2TackMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Tack()));
		// 2PANTS_膝裏_名
		order.setPt2KneeinnerTypeNm(orderForm.getOptionPants2TuxedoInfo().getTp2KneeBackMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2KneeBack()));
		// 2PANTS_膝裏素材_名
		order.setPt2KneeinnerClothNm(orderForm.getOptionPants2TuxedoInfo().getTp2KneeBackMateMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2KneeBackMate()));
		// 2PANTS_フロント仕様_名
		order.setPt2FrtTypeNm(orderForm.getOptionPants2TuxedoInfo().getTp2FrontSpecMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2FrontSpec()));
		// 2PANTS_パンチェリーナ_名
		order.setPt2PancherinaNm(orderForm.getOptionPants2TuxedoInfo().getTp2PancherinaMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Pancherina()));
		// 2PANTS_アジャスター_名
		order.setPt2AdjusterNm(orderForm.getOptionPants2TuxedoInfo().getTp2AdjusterMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Adjuster()));
		// 2PANTS_ピンループ_名
		order.setPt2PinloopNm(orderForm.getOptionPants2TuxedoInfo().getTp2PinLoopMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2PinLoop()));
		// 2PANTS_脇ポケット_名
		order.setPt2SidePktNm(orderForm.getOptionPants2TuxedoInfo().getTp2SidePktMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SidePkt()));
		// 2PANTS_忍びポケット_名
		order.setPt2ShinobiPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2SinobiPktMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SinobiPkt()));
		// 2PANTS_コインポケット_名
		order.setPt2CoinPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2CoinPktMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2CoinPkt()));
		// 2PANTS_フラップ付コインポケット_名
		order.setPt2FlapcoinPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2FlapCoinPktMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2FlapCoinPkt()));
		// 2PANTS_上前ピスポケット_名
		order.setPt2LeftPisPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2PisPktUfMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2PisPktUf()));
		// 2PANTS_下前ピスポケット_名
		order.setPt2RightPisPktNm(orderForm.getOptionPants2TuxedoInfo().getTp2PisPktDfMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2PisPktDf()));
		// 2PANTS_Vカット_名
		order.setPt2VCutNm(orderForm.getOptionPants2TuxedoInfo().getTp2VCutMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2VCut()));
		// 2PANTS_裾上げ_名
		order.setPt2HemUpNm(orderForm.getOptionPants2TuxedoInfo().getTp2HemUpMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2HemUp()));
		// 2PANTS_ダブル幅_名
		order.setPt2DblWidthNm(orderForm.getOptionPants2TuxedoInfo().getTp2DoubleWideMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2DoubleWide()));
		// 2PANTS_AMFステッチ_名
		order.setPt2AmfStitchNm(orderForm.getOptionPants2TuxedoInfo().getTp2StitchMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Stitch()));
		// 2PANTS_サスペンダー釦 _名
		order.setPt2SuspenderBtnNm(orderForm.getOptionPants2TuxedoInfo().getTp2SuspenderBtnMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SuspenderBtn()));
		// 2PANTS_シック（股下補強） _名
		order.setPt2ChicSlipNm(orderForm.getOptionPants2TuxedoInfo().getTp2ThickMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Thick()));
		// 2PANTS_エイト（滑り止め） _名
		order.setPt2NonSlipNm(orderForm.getOptionPants2TuxedoInfo().getTp2EightMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2Eight()));
		// 2PANTS_形状記憶 _名
		order.setPt2ShapeMemoryNm(orderForm.getOptionPants2TuxedoInfo().getTp2ShapeMemoryMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2ShapeMemory()));
		// 2PANTS_側章 _名
		order.setPt2SideStripeNm(orderForm.getOptionPants2TuxedoInfo().getTp2SideStripeMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SideStripe()));
		// 2PANTS_側章幅 _名
		order.setPt2SideStripeWidthNm(orderForm.getOptionPants2TuxedoInfo().getTp2SideStripeWidthMap()
				.get(orderForm.getOptionPants2TuxedoInfo().getTp2SideStripeWidth()));
	}

	/**
	 * オーダー内容確認画面PANTS2のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoWashablePants2Mapping(OrderForm orderForm, Order order) {

		// 2PANTS_タック_名
		order.setPt2TackNm(orderForm.getOptionPants2WashableInfo().getWp2TackMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2Tack()));
		// 2PANTS_膝裏_名
		order.setPt2KneeinnerTypeNm(orderForm.getOptionPants2WashableInfo().getWp2KneeBackMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2KneeBack()));
		// 2PANTS_膝裏素材_名
		order.setPt2KneeinnerClothNm(orderForm.getOptionPants2WashableInfo().getWp2KneeBackMateMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2KneeBackMate()));
		// 2PANTS_フロント仕様_名
		order.setPt2FrtTypeNm(orderForm.getOptionPants2WashableInfo().getWp2FrontSpecMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2FrontSpec()));
		// 2PANTS_パンチェリーナ_名
		order.setPt2PancherinaNm(orderForm.getOptionPants2WashableInfo().getWp2PancherinaMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2Pancherina()));
		// 2PANTS_アジャスター_名
		order.setPt2AdjusterNm(orderForm.getOptionPants2WashableInfo().getWp2AdjusterMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2Adjuster()));
		// 2PANTS_ピンループ_名
		order.setPt2PinloopNm(orderForm.getOptionPants2WashableInfo().getWp2PinLoopMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2PinLoop()));
		// 2PANTS_脇ポケット_名
		order.setPt2SidePktNm(orderForm.getOptionPants2WashableInfo().getWp2SidePktMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2SidePkt()));
		// 2PANTS_忍びポケット_名
		order.setPt2ShinobiPktNm(orderForm.getOptionPants2WashableInfo().getWp2SinobiPktMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2SinobiPkt()));
		// 2PANTS_コインポケット_名
		order.setPt2CoinPktNm(orderForm.getOptionPants2WashableInfo().getWp2CoinPktMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2CoinPkt()));
		// 2PANTS_フラップ付コインポケット_名
		order.setPt2FlapcoinPktNm(orderForm.getOptionPants2WashableInfo().getWp2FlapCoinPktMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2FlapCoinPkt()));
		// 2PANTS_上前ピスポケット_名
		order.setPt2LeftPisPktNm(orderForm.getOptionPants2WashableInfo().getWp2PisPktUfMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2PisPktUf()));
		// 2PANTS_下前ピスポケット_名
		order.setPt2RightPisPktNm(orderForm.getOptionPants2WashableInfo().getWp2PisPktDfMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2PisPktDf()));
		// 2PANTS_Vカット_名
		order.setPt2VCutNm(orderForm.getOptionPants2WashableInfo().getWp2VCutMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2VCut()));
		// 2PANTS_裾上げ_名
		order.setPt2HemUpNm(orderForm.getOptionPants2WashableInfo().getWp2HemUpMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2HemUp()));
		// 2PANTS_ダブル幅_名
		order.setPt2DblWidthNm(orderForm.getOptionPants2WashableInfo().getWp2DoubleWideMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2DoubleWide()));
		// 2PANTS_AMFステッチ_名
		order.setPt2AmfStitchNm(orderForm.getOptionPants2WashableInfo().getWp2StitchMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2Stitch()));
		// 2PANTS_サスペンダー釦 _名
		order.setPt2SuspenderBtnNm(orderForm.getOptionPants2WashableInfo().getWp2SuspenderBtnMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2SuspenderBtn()));
		// 2PANTS_シック（股下補強） _名
		order.setPt2ChicSlipNm(orderForm.getOptionPants2WashableInfo().getWp2ThickMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2Thick()));
		// 2PANTS_エイト（滑り止め） _名
		order.setPt2NonSlipNm(orderForm.getOptionPants2WashableInfo().getWp2EightMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2Eight()));
		// 2PANTS_形状記憶 _名
		order.setPt2ShapeMemoryNm(orderForm.getOptionPants2WashableInfo().getWp2ShapeMemoryMap()
				.get(orderForm.getOptionPants2WashableInfo().getWp2ShapeMemory()));
	}

	/**
	 * オーダー内容確認画面SHIRTのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoStandardShirtMapping(OrderForm orderForm, Order order) {

		// SHIRT_襟型_名
		order.setStCollarTypeNm(orderForm.getOptionShirtStandardInfo().getOsChainModelMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsChainModel()));
		// SHIRT_カフス_名
		order.setStCuffsNm(orderForm.getOptionShirtStandardInfo().getOsCuffsMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsCuffs()));
		// SHIRT_コンバーチブル_名
		order.setStConvertibleNm(orderForm.getOptionShirtStandardInfo().getOsConvertibleMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsConvertible()));
		// SHIRT_アジャスト釦_名
		order.setStAdjusterBtnNm(orderForm.getOptionShirtStandardInfo().getOsAdjustBtnMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsAdjustBtn()));
		// SHIRT_クレリック仕様_名
		order.setStClericNm(orderForm.getOptionShirtStandardInfo().getOsClericSpecMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsClericSpec()));
		// SHIRT_ダブルカフス仕様_名
		order.setStDblCuffsNm(orderForm.getOptionShirtStandardInfo().getOsDblCuffMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsDblCuff()));
		// SHIRT_カフスボタン追加_名
		order.setStCuffsBtnNm(orderForm.getOptionShirtStandardInfo().getOsAddCuffMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsAddCuff()));
		// SHIRT_タブ釦_名
		order.setStDblBtnNm(orderForm.getOptionShirtStandardInfo().getOsTabBtnMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsTabBtn()));
		// SHIRT_ガントレットボタン位置_名
		order.setStGauntletBtnPosNm(orderForm.getOptionShirtStandardInfo().getOsGaletteBtnPosMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsGaletteBtnPos()));
		// SHIRT_ピンホールピン_名
		order.setStPinholePinNm(orderForm.getOptionShirtStandardInfo().getOsPinHolePinMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsPinHolePin()));
		// SHIRT_胸ポケット置_名
		order.setStBreastPktNm(orderForm.getOptionShirtStandardInfo().getOsBreastPkMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsBreastPk()));
		// SHIRT_胸ポケット大きさ_名
		order.setStBreastSizeNm(orderForm.getOptionShirtStandardInfo().getOsBreastPkSizeMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsBreastPkSize()));
		// SHIRT_フロントデザイン_名
		order.setStFrtDesignNm(orderForm.getOptionShirtStandardInfo().getOsFrontDesignMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsFrontDesign()));
		// SHIRT_ピンタックブザム_名
		order.setStPintuckBosomNm(orderForm.getOptionShirtStandardInfo().getOsPinTackMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsPinTack()));
		// SHIRT_ステッチ_名
		order.setStStitchNm(orderForm.getOptionShirtStandardInfo().getOsStitchMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsStitch()));
		// SHIRT_カラーキーパー_名
		order.setStColarKeeperNm(orderForm.getOptionShirtStandardInfo().getOsColorKeeperMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsColorKeeper()));
		// SHIRT_ボタンホール色変更_名
		order.setStBtnholeColorNm(orderForm.getOptionShirtStandardInfo().getOsBhColorMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsBhColor()));
		// SHIRT_ボタン付け糸色変更_名
		order.setStBtnthreadColorNm(orderForm.getOptionShirtStandardInfo().getOsByColorMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsByColor()));
		// SHIRT_ボタン位置変更_名
		order.setStBtnposChgNm(orderForm.getOptionShirtStandardInfo().getOsBtnPosChgMap()
				.get(orderForm.getOptionShirtStandardInfo().getOsBtnPosChg()));
		// SHIRT_台襟釦_名
		order.setStNeckbandBtnChgNm(orderForm.getOptionShirtStandardInfo().getOsBtnPosChgCollar());
		// SHIRT_フロント第1釦_名
		order.setStFrtfirstBtnChgNm(orderForm.getOptionShirtStandardInfo().getOsBtnPosChgFront1());
		// SHIRT_フロント第2釦_名
		order.setStFrtsecondBtnChgNm(orderForm.getOptionShirtStandardInfo().getOsBtnPosChgFront2());
	}

	/**
	 * オーダー内容確認画面COATのMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderCoStandardCoatMapping(OrderForm orderForm, Order order) {

		// COAT_ラペルデザイン_名
		order.setCtLapelDesignNm(orderForm.getOptionCoatStandardInfo().getOcLapelDesignMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcLapelDesign()));
		// COAT_腰ポケット_名
		order.setCtWaistPktNm(orderForm.getOptionCoatStandardInfo().getOcWaistPktMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcWaistPkt()));
		// COAT_チェンジポケット_名
		order.setCtChgPktNm(orderForm.getOptionCoatStandardInfo().getOcChangePktMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcChangePkt()));
		// COAT_スランテッドポケット_名
		order.setCtSlantedPktNm(orderForm.getOptionCoatStandardInfo().getOcSlantedPktMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcSlantedPkt()));
		// COAT_ベント_名
		order.setCtVentNm(orderForm.getOptionCoatStandardInfo().getOcVentSpecMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcVentSpec()));
		// COAT_フロント釦数_名
		order.setCtFrtBtnNm(orderForm.getOptionCoatStandardInfo().getOcFrontBtnCntMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcFrontBtnCnt()));
		// COAT_袖口_名
		order.setCtCuffNm(orderForm.getOptionCoatStandardInfo().getOcCuffSpecMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcCuffSpec()));
		// COAT_袖釦_名
		order.setCtSleeveBtnNm(orderForm.getOptionCoatStandardInfo().getOcSleeveBtnTypeMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcSleeveBtnType()));
		// COAT_バックベルト_名
		order.setCtBackBeltNm(orderForm.getOptionCoatStandardInfo().getOcBackBeltMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcBackBelt()));
		// COAT_襟吊_名
		order.setCtCollarHangNm(orderForm.getOptionCoatStandardInfo().getOcChainHangeMap()
				.get(orderForm.getOptionCoatStandardInfo().getOcChainHange()));

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
	public void orderCoMapping(OrderForm orderForm, Order order, String userId, OrderFindFabric findStock,
			Order orderId) {

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
		
//		if("T2".equals(orderForm.getStatus()) || "T3".equals(orderForm.getStatus()) || "T4".equals(orderForm.getStatus()) || "T5".equals(orderForm.getStatus())) {
//			//業態
//			String storeBrandCode = orderId.getStoreBrandCode();
//			order.setStoreBrandCode(storeBrandCode);
//			//店舗コード
//			String shopCode = orderId.getShopCode();
//			order.setShopCode(shopCode);
//		}
//
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
//
//		// ホスト連携_店コード
//		order.setHostTransmitStoreCd(order.getShopCode());
//
//		// ホスト連携_品名コード
//		Map<String, String> hostTransmitItemCd03Map = new HashMap<String, String>();
//		Map<String, String> hostTransmitItemCd01Map = new HashMap<String, String>();
//
//		/*
//		 * 業態がTSC(03)の場合 061 スーツ 01 SUIT 062 ジャケット 02 JACKET 063 パンツ 03 PANTS 064 ジレ 04
//		 * GILET
//		 */
//		hostTransmitItemCd03Map.put("01", "061");
//		hostTransmitItemCd03Map.put("02", "062");
//		hostTransmitItemCd03Map.put("03", "063");
//		hostTransmitItemCd03Map.put("04", "064");
//		/*
//		 * 業態がTSC(01)の場合 061 スーツ 01 SUIT 062 ジャケット 02 JACKET 063 パンツ 03 PANTS 067 ジレ 04
//		 * GILET
//		 */
//		hostTransmitItemCd01Map.put("01", "061");
//		hostTransmitItemCd01Map.put("02", "062");
//		hostTransmitItemCd01Map.put("03", "063");
//		hostTransmitItemCd01Map.put("04", "067");
//
//		String hostTransmitItemCdKey = orderForm.getProductItem();
//		String storeBrandCode = order.getStoreBrandCode();
//		if ("01".equals(storeBrandCode)) {
//			String hostTransmitItemCdValue = hostTransmitItemCd01Map.get(hostTransmitItemCdKey);
//			order.setHostTransmitItemCd(hostTransmitItemCdValue);
//		} else if ("03".equals(storeBrandCode)) {
//			String hostTransmitItemCdValue = hostTransmitItemCd03Map.get(hostTransmitItemCdKey);
//			order.setHostTransmitItemCd(hostTransmitItemCdValue);
//		}
//
//		// ホスト連携_メーカーコード
//		order.setHostTransmitMakerCd(findMakerId);
//
//		// ホスト連携_年季
//		String hostTransmitNenkiCd = findStock.getSeason();
//		order.setHostTransmitNenkiCd(hostTransmitNenkiCd);
//
//		// ホスト連携_色
//		String hostTransmitColorCd = findStock.getColorAoyama();
//		String hostTransmitPatternCd = findStock.getPatternAoyama();
//		order.setHostTransmitColorCd(hostTransmitColorCd + hostTransmitPatternCd);
//
//		// 工場自動連携ステータス
//		order.setSend2factoryStatus("0");
//
//		// ホスト連携_サイズ
//		String orderItemCd = orderForm.getProductItem();
//		String suitItemCd = "01";
//		String jacketItemCd = "02";
//		String pantsItemCd = "03";
//		String giletItemCd = "04";
//		if (suitItemCd.equals(orderItemCd) || jacketItemCd.equals(orderItemCd)) {
//			String subStringSizeFigure = "";
//			String subStringSizeNumber = "";
//			String sizeNumber = orderForm.getAdjustJacketStandardInfo().getSizeNumber();
//			if (sizeNumber.indexOf("(") != -1) {
//				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
//			}
//			String sizeFigure = orderForm.getAdjustJacketStandardInfo().getSizeFigure();
//			if (sizeFigure.indexOf("(") != -1) {
//				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
//			}
//			
//			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
//			order.setHostTransmitSize(hostTransmitSize);
//		} else if (pantsItemCd.equals(orderItemCd)) {
//			String subStringSizeFigure = "";
//			String subStringSizeNumber = "";
//			String sizeNumber = orderForm.getAdjustPantsStandardInfo().getSizeNumber();
//			if (sizeNumber.indexOf("(") != -1) {
//				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
//			}
//			String sizeFigure = orderForm.getAdjustPantsStandardInfo().getSizeFigure();
//			if (sizeFigure.indexOf("(") != -1) {
//				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
//			}
//			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
//			order.setHostTransmitSize(hostTransmitSize);
//		} else if (giletItemCd.equals(orderItemCd)) {
//			String subStringSizeFigure = "";
//			String subStringSizeNumber = "";
//			String sizeNumber = orderForm.getAdjustGiletStandardInfo().getSizeNumber();
//			if (sizeNumber.indexOf("(") != -1) {
//				subStringSizeNumber = sizeNumber.substring(0, sizeNumber.indexOf("("));
//			}
//
//			String sizeFigure = orderForm.getAdjustGiletStandardInfo().getSizeFigure();
//			if (sizeFigure.indexOf("(") != -1) {
//				subStringSizeFigure = sizeFigure.substring(0, sizeFigure.indexOf("("));
//			}
//			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
//			order.setHostTransmitSize(hostTransmitSize);
//		}
//
//		// ホスト連携_メーカー品番
//		/*
//		 * 生地品番(8)＋色(1)＋柄(1)＋区分(1) 色、柄：TSC表記 区分： SUIT 単品 1 ２Pシングル J ジャケット 2 ２Pダブル W
//		 * ダブルジャケット 3 ２PPシングル G ジレ 4 ２PPダブル V ダブルジレ 5 ３Pシングル P パンツ 6 ３Pダブル D ドレスシャツ 7
//		 * ３P２PPシングル C シングルコート 8 ３P２PPダブル A ダブルコート
//		 */
//		Map<String, String> hostTransmitMakerProductMap = new HashMap<String, String>();
//		// 1 ２Pシングル
//		hostTransmitMakerProductMap.put("01", "1");
//		// 2 ２Pダブル
//		hostTransmitMakerProductMap.put("010000105", "2");
//		// 3 ２PPシングル
//		hostTransmitMakerProductMap.put("01030009902", "3");
//		// 4 ２PPダブル
//		hostTransmitMakerProductMap.put("010300099020000105", "4");
//		// 5 ３Pシングル
//		hostTransmitMakerProductMap.put("01040009902", "5");
//		// 6 ３Pダブル
//		hostTransmitMakerProductMap.put("010400099020000105", "6");
//		// 7 ３P２PPシングル
//		hostTransmitMakerProductMap.put("01040009902030009902", "7");
//		// 8 ３P２PPダブル
//		hostTransmitMakerProductMap.put("010400099020300099020000105", "8");
//		// J ジャケット
//		hostTransmitMakerProductMap.put("02", "J");
//		// W ダブルジャケット
//		hostTransmitMakerProductMap.put("020000105", "W");
//		// G ジレ
//		hostTransmitMakerProductMap.put("04", "G");
//		// P パンツ
//		hostTransmitMakerProductMap.put("03", "P");
//
//		// 商品情報_ITEM
//		String productItem = orderForm.getProductItem();
//		// 商品情報_３Piece
//		String productIs3Piece = orderForm.getProductIs3Piece();
//		// 商品情報_スペアパンツ
//		String productSparePantsClass = orderForm.getProductSparePantsClass();
//		// フロント釦数
//		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
//		String hostTransmitMakerProductMapKey = getHostTransmitMakerProductMapKey(productItem, productIs3Piece,
//				productSparePantsClass, ojFrontBtnCnt);
//
//		String productFabricNo = orderForm.getProductFabricNo();
//		String hostTransmitMakerProductMapValue = hostTransmitMakerProductMap.get(hostTransmitMakerProductMapKey);
//		String hostTransmitMakerProductValue = productFabricNo + fabricColor + fabricPattern
//				+ hostTransmitMakerProductMapValue;
//		order.setHostTransmitMakerProduct(hostTransmitMakerProductValue);
//
//		// 商品情報_刺繍ネーム、商品情報_刺繍書体、商品情報_刺繍糸色はnull値の判定
//		String productEmbroideryNecessity = orderForm.getProductEmbroideryNecessity();
//		if ("0".equals(productEmbroideryNecessity)) {
//			order.setProductEmbroideryNm(null);
//			order.setProductEmbroideryFont(null);
//			order.setProductEmbroideryThreadColor(null);
//		}
//
//		// PANTS_ダブル幅についての項目はnull値の判定
//		String opHemUp = orderForm.getOptionPantsStandardInfo().getOpHemUp();
//		if ("0001701".equals(opHemUp) || "0001704".equals(opHemUp)) {
//			order.setPtDblWidthCd(null);
//			order.setPtDblWidthNm(null);
//			order.setPtDblWidthRtPrice(null);
//			order.setPtDblWidthWsWage(null);
//			order.setPtDblWidthWsPrice(null);
//		}
//
//		// PANTS2_ダブル幅についての項目はnull値の判定
//		String op2HemUp = orderForm.getOptionPants2StandardInfo().getOp2HemUp();
//		if ("0001701".equals(op2HemUp) || "0001704".equals(op2HemUp)) {
//			order.setPt2DblWidthCd(null);
//			order.setPt2DblWidthNm(null);
//			order.setPt2DblWidthRtPrice(null);
//			order.setPt2DblWidthWsWage(null);
//			order.setPt2DblWidthWsPrice(null);
//		}
//
//		if ("01".equals(orderItemCd) || "03".equals(orderItemCd)) {
//
//			// PANTS_股下右_グロス
//			String corPtRightinseamGross = orderForm.getAdjustPantsStandardInfo().getCorPtRightinseamGross();
//			if (corPtRightinseamGross == null || "".equals(corPtRightinseamGross)) {
//				order.setCorPtRightinseamGross(new BigDecimal(0.0));
//			}
//
//			// PANTS_股下左_グロス
//			String corPtLeftinseamGross = orderForm.getAdjustPantsStandardInfo().getCorPtLeftinseamGross();
//			if (corPtLeftinseamGross == null || "".equals(corPtLeftinseamGross)) {
//				order.setCorPtLeftinseamGross(new BigDecimal(0.0));
//			}
//
//		}
//
//		// スペアパンツは有り
//		String productYes = "0009902";
////		String productSparePantsClass = orderForm.getProductSparePantsClass();
//
//		if ("01".equals(orderItemCd) && productYes.equals(productSparePantsClass)) {
//
//			// 2PANTS_股下右_グロス
//			String corPt2RightinseamGross = orderForm.getAdjustPants2StandardInfo().getCorPt2RightinseamGross();
//			if (corPt2RightinseamGross == null || "".equals(corPt2RightinseamGross)) {
//				order.setCorPt2RightinseamGross(new BigDecimal(0.0));
//			}
//
//			// 2PANTS_股下左_グロス
//			String corPt2LeftinseamGross = orderForm.getAdjustPants2StandardInfo().getCorPt2LeftinseamGross();
//			if (corPt2LeftinseamGross == null || "".equals(corPt2LeftinseamGross)) {
//				order.setCorPt2LeftinseamGross(new BigDecimal(0.0));
//			}
//
//		}
//
//		// JACKET_モデル_上代
//		Integer doubleJacketPrice = retailPriceRelatedMap.get("doubleJACKET");
//		Integer singleDoubleJacketPrice = retailPriceRelatedMap.get("singleDoubleJACKET");
////		String productItem = orderForm.getProductItem();
////		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
//		if ("0000105".equals(ojFrontBtnCnt)) {
//			if ("01".equals(productItem)) {
//				if (doubleJacketPrice != null) {
//					order.setJkModelRtPrice(doubleJacketPrice);
//				} else {
//					order.setJkModelRtPrice(0);
//				}
//			} else if ("02".equals(productItem)) {
//				if (singleDoubleJacketPrice != null) {
//					order.setJkModelRtPrice(singleDoubleJacketPrice);
//				} else {
//					order.setJkModelRtPrice(0);
//				}
//			}
//		} else {
//			if ("01".equals(productItem) || "02".equals(productItem)) {
//				order.setJkModelRtPrice(0);
//			}
//
//		}
//		// お客様情報_お客様氏名
//		order.setCustNm(null);
//		// お客様情報_フリガナ
//		order.setCustKanaNm(null);
//		// お客様備考
//		order.setCustRemark(orderForm.getCustomerMessageInfo().getCustRemark().replaceAll("\\n", ""));
//		
//		if(priceCode != null) {
//			// 生地代
//			Integer fabricPrice = priceCode.getFabricPrice();
//			order.setFabricPrice(fabricPrice);
//			// 下代調整金
//			Integer wsPriceAdjust = priceCode.getWsPriceAdjust();
//			order.setWsPriceAdjust(wsPriceAdjust);
//		}
		
	}
	
	
	/**
	 * 
	 * @param string
	 * @return
	 */
	public String complete2Digits(String string) {
		String blankSpace = " ";
		if(string.length() < 2) {
			string = string + blankSpace;
		}
		return string;
	}

	/**
	 * オーダー内容確認画面のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderMappingPo(OrderForm orderForm, Order order, String userId, OrderFindFabric findStock,
			Order orderId, String findMakerId, Map<String, Integer> retailPriceRelatedMap,NextGenerationPrice priceCode) {

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
		
		if("T2".equals(orderForm.getStatus()) || "T3".equals(orderForm.getStatus()) || "T4".equals(orderForm.getStatus()) || "T5".equals(orderForm.getStatus())) {
			//業態
			String storeBrandCode = orderId.getStoreBrandCode();
			order.setStoreBrandCode(storeBrandCode);
			//店舗コード
			String shopCode = orderId.getShopCode();
			order.setShopCode(shopCode);
		}

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
		order.setHostTransmitStoreCd(order.getShopCode());

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
			
			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
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
			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
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
			String hostTransmitSize = complete2Digits(subStringSizeFigure) + complete2Digits(subStringSizeNumber);
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
		// お客様備考
		order.setCustRemark(orderForm.getCustomerMessageInfo().getCustRemark().replaceAll("\\n", ""));
		
		if(priceCode != null) {
			// 生地代
			Integer fabricPrice = priceCode.getFabricPrice();
			order.setFabricPrice(fabricPrice);
			// 下代調整金
			Integer wsPriceAdjust = priceCode.getWsPriceAdjust();
			order.setWsPriceAdjust(wsPriceAdjust);
		}
		
	}

	/**
	 * 更新のみのデータ
	 * 
	 * @param selectExistOrder
	 * @param order
	 */
	public void onlyUpdateItem(Order selectExistOrder, Order order,String authority) {
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
		// ホスト連携_A行
		String hostTransmitARow = selectExistOrder.getHostTransmitARow();
		order.setHostTransmitARow(hostTransmitARow);
		// 出荷番号
		String shippingNumber = selectExistOrder.getShippingNumber();
		order.setShippingNumber(shippingNumber);
		
		if ("02".equals(authority)) {
			// 業態
			order.setStoreBrandCode(selectExistOrder.getStoreBrandCode());
			// 店舗コード
			order.setShopCode(selectExistOrder.getShopCode());

		}
	}

	/**
	 * オーダー内容確認画面のMapの値とorderの対応フィールドのマッピング
	 * 
	 * @param orderForm
	 * @param order
	 * @param authority
	 */
	public void orderMappingLogOn(OrderForm orderForm, Order order, SessionContent sessionContent, Order orderIsExist) {

		if(orderIsExist!=null) {
			//商品部の場合
			if ("02".equals(sessionContent.getAuthority())) {
				// 業態
				order.setStoreBrandCode(orderIsExist.getStoreBrandCode());
				// 店舗コード
				order.setShopCode(orderIsExist.getShopCode());
				
				order.setStoreNm(orderIsExist.getStoreNm());
			}
			
			order.setStoreNm(sessionContent.getBelongName());
			// オーダーパターン
			order.setOrderPattern(orderIsExist.getOrderPattern());
			// 取り消しフラグ
			order.setIsCancelled(orderIsExist.getIsCancelled());

			// 最終更新者
			order.setUpdatedUserId(sessionContent.getUserId());

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
			order.setUpdatedUserId(sessionContent.getUserId());
			
		}else {
			// 業態
			order.setStoreBrandCode(sessionContent.getStoreBrandCode());
			
			// 店舗コード
			order.setShopCode(sessionContent.getBelongCode());
			
			order.setStoreNm(sessionContent.getBelongName());
			
			// 理論在庫チェック
			order.setTheoreticalStockCheck(IS_NOT_THEORETICAL_STOCKCECK);
			
			// 工場ステータス
			order.setMakerFactoryStatus(FACTORY_STATUSF0);
			
			// 取り消しフラグ
			order.setIsCancelled(IS_NOT_CANCELLED);
			
			// 工場自動連携ステータス
			order.setSend2factoryStatus(SEND2FACTORY_STATUS0);
			
			order.setCreatedUserId(sessionContent.getUserId());
			order.setCreatedAt(new Date());
			order.setUpdatedAt(new Date());
			order.setUpdatedUserId(sessionContent.getUserId());
			order.setVersion((short)0);
		}
		
		// お客様氏名
		order.setCustNm(null);

		// お客様情報_フリガナ
		order.setCustKanaNm(null);


		// お客様備考
		order.setCustRemark(orderForm.getCustomerMessageInfo().getCustRemark().replaceAll("\\n", ""));

		// 注文承り日
		order.setProductOrderdDate(new Date());


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
	 * オーダーCO内容確認画面標準JACKETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectStandardMaterialName
	 * @param order
	 */
	public void orderCoStandardJkNameMapping(Map<String, String> selectStandardMaterialName,Order order) {

		// JACKETの胴裏素材Name表示
		String ojBodyBackMateName = selectStandardMaterialName.get("ojBodyBackMateStkNo");
		order.setJkInnerBodyClothNm(ojBodyBackMateName);
		
		// JACKETの袖裏素材Name表示
		String ojCuffBackMateName = selectStandardMaterialName.get("ojCuffBackMateStkNo");
		order.setJkInnerSleeveClothNm(ojCuffBackMateName);

		// JACKETの釦素材Name表示
		String ojBtnMateName = selectStandardMaterialName.get("ojBtnMateStkNo");
		order.setJkBtnMaterialNm(ojBtnMateName);
	}
	
	/**
	 * オーダーCO内容確認画面タキシードJACKETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectTuxedoMaterialName
	 * @param order
	 */
	public void orderCoTuxedoJkNameMapping(Map<String, String> selectTuxedoMaterialName,Order order) {

		// JACKETの胴裏素材Name表示
		String tjBodyBackMateName = selectTuxedoMaterialName.get("tjBodyBackMateStkNo");
		order.setJkInnerBodyClothNm(tjBodyBackMateName);
		
		// JACKETの袖裏素材Name表示
		String tjCuffBackMateName = selectTuxedoMaterialName.get("tjCuffBackMateStkNo");
		order.setJkInnerSleeveClothNm(tjCuffBackMateName);

		// JACKETの釦素材Name表示
		String tjBtnMateName = selectTuxedoMaterialName.get("tjBtnMateStkNo");
		order.setJkBtnMaterialNm(tjBtnMateName);
	}
	
	/**
	 * オーダーCO内容確認画面ウォッシャブルJACKETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectWashableMaterialName
	 * @param order
	 */
	public void orderCoWashableJkNameMapping(Map<String, String> selectWashableMaterialName,Order order) {

		// JACKETの胴裏素材Name表示
		String wjBodyBackMateName = selectWashableMaterialName.get("wjBodyBackMateStkNo");
		order.setJkInnerBodyClothNm(wjBodyBackMateName);
		
		// JACKETの袖裏素材Name表示
		String wjCuffBackMateName = selectWashableMaterialName.get("wjCuffBackMateStkNo");
		order.setJkInnerSleeveClothNm(wjCuffBackMateName);

		// JACKETの釦素材Name表示
		String wjBtnMateName = selectWashableMaterialName.get("wjBtnMateStkNo");
		order.setJkBtnMaterialNm(wjBtnMateName);
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
	 * オーダーCO内容確認画面標準GILETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectStandardMaterialName
	 * @param order
	 */
	public void orderCoStandardGlNameMapping(Map<String, String> selectStandardMaterialName,Order order) {

		// GILETの背裏地素材Name表示
		String ogBackLiningMateName = selectStandardMaterialName.get("ogBackLiningMateStkNo");
		order.setGlBackClothNm(ogBackLiningMateName);

		// GILETの内側裏地素材Name表示
		String ogInsideLiningMateName = selectStandardMaterialName.get("ogInsideLiningMateStkNo");
		order.setGlInnnerClothNm(ogInsideLiningMateName);

		// GILETのフロント釦Name表示
		String ogFrontBtnMateName = selectStandardMaterialName.get("ogFrontBtnMateStkNo");
		order.setGlFrtBtnNm(ogFrontBtnMateName);
	}
	
	/**
	 * オーダーCO内容確認画面タキシードGILETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectTuxedoMaterialName
	 * @param order
	 */
	public void orderCoTuxedoGlNameMapping(Map<String, String> selectTuxedoMaterialName,Order order) {

		// GILETの背裏地素材Name表示
		String tgBackLiningMateName = selectTuxedoMaterialName.get("tgBackLiningMateStkNo");
		order.setGlBackClothNm(tgBackLiningMateName);

		// GILETの内側裏地素材Name表示
		String tgInsideLiningMateName = selectTuxedoMaterialName.get("tgInsideLiningMateStkNo");
		order.setGlInnnerClothNm(tgInsideLiningMateName);

		// GILETのフロント釦Name表示
		String tgFrontBtnMateName = selectTuxedoMaterialName.get("tgFrontBtnMateStkNo");
		order.setGlFrtBtnNm(tgFrontBtnMateName);
	}
	
	/**
	 * オーダーCO内容確認画面ウォッシャブルGILETのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectWashableMaterialName
	 * @param order
	 */
	public void orderCoWashableGlNameMapping(Map<String, String> selectWashableMaterialName,Order order) {

		// GILETの背裏地素材Name表示
		String wgBackLiningMateName = selectWashableMaterialName.get("wgBackLiningMateStkNo");
		order.setGlBackClothNm(wgBackLiningMateName);

		// GILETの内側裏地素材Name表示
		String wgInsideLiningMateName = selectWashableMaterialName.get("wgInsideLiningMateStkNo");
		order.setGlInnnerClothNm(wgInsideLiningMateName);

		// GILETのフロント釦Name表示
		String wgFrontBtnMateName = selectWashableMaterialName.get("wgFrontBtnMateStkNo");
		order.setGlFrtBtnNm(wgFrontBtnMateName);
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
	 * オーダーCO内容確認画面標準PNATSのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectStandardMaterialName
	 * @param order
	 */
	public void orderCoStandardPtNameMapping(Map<String, String> selectStandardMaterialName,Order order) {

		// PANTSの釦素材Name表示
		String opBtnMateName = selectStandardMaterialName.get("opBtnMateStkNo");
		order.setPtBtnMaterialNm(opBtnMateName);
	}
	
	/**
	 * オーダーCO内容確認画面タキシードPNATSのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectTuxedoMaterialName
	 * @param order
	 */
	public void orderCoTuxedoPtNameMapping(Map<String, String> selectTuxedoMaterialName,Order order) {

		// PANTSの釦素材Name表示
		String tpBtnMateName = selectTuxedoMaterialName.get("tpBtnMateStkNo");
		order.setPtBtnMaterialNm(tpBtnMateName);
	}
	
	/**
	 * オーダーCO内容確認画面ウォッシャブルPNATSのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectWashableMaterialName
	 * @param order
	 */
	public void orderCoWashablePtNameMapping(Map<String, String> selectWashableMaterialName,Order order) {

		// PANTSの釦素材Name表示
		String wpBtnMateName = selectWashableMaterialName.get("wpBtnMateStkNo");
		order.setPtBtnMaterialNm(wpBtnMateName);
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
	 * オーダーCO内容確認画面標準PNATS2のoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectStandardMaterialName
	 * @param order
	 */
	public void orderCoStandardPt2NameMapping(Map<String, String> selectStandardMaterialName,Order order) {

		// PANTS（2本目）の釦素材Name表示
		String op2BtnMateName = selectStandardMaterialName.get("op2BtnMateStkNo");
		order.setPt2BtnMaterialNm(op2BtnMateName);
	}
	
	/**
	 * オーダーCO内容確認画面タキシードPNATS2のoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectTuxedoMaterialName
	 * @param order
	 */
	public void orderCoTuxedoPt2NameMapping(Map<String, String> selectTuxedoMaterialName,Order order) {

		// PANTS（2本目）の釦素材Name表示
		String tp2BtnMateName = selectTuxedoMaterialName.get("tp2BtnMateStkNo");
		order.setPt2BtnMaterialNm(tp2BtnMateName);
	}
	
	/**
	 * オーダーCO内容確認画面ウォッシャブルPNATS2のoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectWashableMaterialName
	 * @param order
	 */
	public void orderCoWashablePt2NameMapping(Map<String, String> selectWashableMaterialName,Order order) {

		// PANTS（2本目）の釦素材Name表示
		String wp2BtnMateName = selectWashableMaterialName.get("wp2BtnMateStkNo");
		order.setPt2BtnMaterialNm(wp2BtnMateName);
	}
	
	/**
	 * オーダーCO内容確認画面標準COATのoption_branch_detail_nameとorderの対応フィールドのマッピング
	 * 
	 * @param selectStandardMaterialName
	 * @param order
	 */
	public void orderCoStandardCtNameMapping(Map<String, String> selectStandardMaterialName,Order order) {

		// COATの胴裏地Name表示
		String ocBodyBackMateName = selectStandardMaterialName.get("ocBodyBackMateStkNo");
		order.setCtInnerBodyClothNm(ocBodyBackMateName);

		// COATの袖裏地Name表示
		String ocCuffBackMateName = selectStandardMaterialName.get("ocCuffBackMateStkNo");
		order.setCtInnerSleeveClothNm(ocCuffBackMateName);
				
		// COATの釦素材Name表示
		String ocFrontBtnMateName = selectStandardMaterialName.get("ocFrontBtnMateStkNo");
		order.setCtBtnMaterialNm(ocFrontBtnMateName);
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
	public void order3PiecePrice(OrderForm orderForm, Order order,Map<String, Integer> retailPriceRelatedMap) {
		
		String productIs3Piece = orderForm.getProductIs3Piece();
		String productIs3PieceYes = "0009902";
		if(productIs3PieceYes.equals(productIs3Piece)) {
			Integer single3PieceRetailPrice = retailPriceRelatedMap.get("price3Piece");
			order.setProductIs3pieceRtPrice(single3PieceRetailPrice);
		}
		else {
			Integer price = 0;
			order.setProductIs3pieceRtPrice(price);
		}
		
	}

	/**
	 * スペアパンツの上代をデータベースに入力する
	 * 
	 * @param orderForm
	 * @param order
	 */
	public void orderSparePantsPrice(OrderForm orderForm, Order order,Map<String, Integer> retailPriceRelatedMap) {
		
		String productSparePantsClass = orderForm.getProductSparePantsClass();
		String productSparePantsClassYes = "0009902";
		
		if(productSparePantsClassYes.equals(productSparePantsClass)) {
			Integer sparePantsPrice = retailPriceRelatedMap.get("sparePants");
			order.setProductSparePantsRtPrice(sparePantsPrice);
		}
		else {
			Integer price = 0;
			order.setProductSparePantsRtPrice(price);
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

	/**
	 * 
	 * @param orderFabric
	 * @return
	 */
	public Map<String, Integer> getCoRetailPriceRelated(OrderFindFabric orderFabric) {

		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		// 上代
		Integer retailPrice = orderFabric.getRetailPrice();
		// ダブルJACKET増額率
		Integer additionalDoubleJacketRate = orderFabric.getAdditionalDoubleJacketRate();
		// シングルGILET追加増額率
		Integer additionalSingleGiletRate = orderFabric.getAdditionalSingleGiletRate();
		// ダブルGILET追加増額率
		Integer additionalDoubleGiletRate = orderFabric.getAdditionalDoubleGiletRate();
		// PANTS追加増額率
		Integer additionalPantsRate = orderFabric.getAdditionalPantsRate();
		// 上代*ダブルJACKET増額率/100
		Integer doubleJacketRtPrice = retailPrice * additionalDoubleJacketRate / 100;
		// 上代*シングルGILET追加増額率/100
		Integer single3PieceRetailPrice = retailPrice * additionalSingleGiletRate / 100;
		// 上代*ダブルGILET追加増額率/100 - 上代*シングルGILET追加増額率/100
		Integer doubleGiletModelRtPrice = retailPrice * additionalDoubleGiletRate / 100
				- retailPrice * additionalSingleGiletRate / 100;
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

		// シングルGILET単品率
		Integer singleGiletOnlyRate = orderFabric.getSingleGiletOnlyRate();
		// ダブルGILET単品率
		Integer doubleGiletOnlyRate = orderFabric.getDoubleGiletOnlyRate();
		// シングルGILETの単品購買追加金額
		Integer glSingleOnlyPlusAlphaPrice = orderFabric.getGlSingleOnlyPlusAlphaPrice();
		// ダブルGILETの単品購買追加金額
		Integer glDoubleOnlyPlusAlphaPrice = orderFabric.getGlDoubleOnlyPlusAlphaPrice();
		// (上代*ダブルGILET単品率/100+「ダブルGILETの単品購買追加金額」) -
		// (上代*シングルGILET単品率/100+「シングルGILETの単品購買追加金額」)
		Integer singleGiletDoublePrice = (retailPrice * doubleGiletOnlyRate / 100 + glDoubleOnlyPlusAlphaPrice)
				- (retailPrice * singleGiletOnlyRate / 100 + glSingleOnlyPlusAlphaPrice);

		// シングルコート単品率
		Integer coatSingleOnlyRate = orderFabric.getCoatSingleOnlyRate();
		// ダブルコート単品率
		Integer coatDoubleOnlyRate = orderFabric.getCoatDoubleOnlyRate();
		// シングルCoatの単品購買追加金額
		Integer ctSingleOnlyPlusAlphaPrice = orderFabric.getCtSingleOnlyPlusAlphaPrice();
		// ダブルCoatの単品購買追加金額
		Integer ctDoubleOnlyPlusAlphaPrice = orderFabric.getCtDoubleOnlyPlusAlphaPrice();
		// (上代*ダブルコート単品率/100＋「ダブルCoatの単品購買追加金額」) -
		// (上代*シングルコート単品率/100＋「シングルCoatの単品購買追加金額」)
		Integer singleCoatDoublePrice = (retailPrice * coatDoubleOnlyRate / 100 + ctDoubleOnlyPlusAlphaPrice)
				- (retailPrice * coatSingleOnlyRate / 100 + ctSingleOnlyPlusAlphaPrice);

		priceMap.put("price3Piece", single3PieceRetailPrice);
		priceMap.put("sparePants", sparePantsPrice);
		priceMap.put("doubleJacketRtPrice", doubleJacketRtPrice);
		priceMap.put("doubleGiletModelRtPrice", doubleGiletModelRtPrice);
		priceMap.put("singleDoubleJACKET", singleJacketDoublePrice);
		priceMap.put("singleGiletDoublePrice", singleGiletDoublePrice);
		priceMap.put("singleCoatDoublePrice", singleCoatDoublePrice);

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

	public void orderMappingLogOn(OrderForm orderForm, Order order, SessionContent sessionContent) {
		// 業態
		order.setStoreBrandCode(sessionContent.getStoreBrandCode());

		// 店舗コード
		order.setShopCode(sessionContent.getBelongCode());
		
		order.setStoreNm(sessionContent.getBelongName());

		// 理論在庫チェック
		order.setTheoreticalStockCheck(IS_NOT_THEORETICAL_STOCKCECK);

		// 工場ステータス
		order.setMakerFactoryStatus(FACTORY_STATUSF0);

		// 取り消しフラグ
		order.setIsCancelled(IS_NOT_CANCELLED);

		// 工場自動連携ステータス
		order.setSend2factoryStatus(SEND2FACTORY_STATUS0);

		order.setCreatedUserId(sessionContent.getUserId());
		order.setCreatedAt(new Date());
		order.setUpdatedAt(new Date());
		order.setUpdatedUserId(sessionContent.getUserId());
		order.setVersion((short) 0);

		// お客様氏名
		order.setCustNm(null);

		// お客様情報_フリガナ
		order.setCustKanaNm(null);

		// お客様備考
		order.setCustRemark(orderForm.getCustomerMessageInfo().getCustRemark().replaceAll("\\n", ""));

		// 注文承り日
		order.setProductOrderdDate(new Date());

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

	public void orderModelPrice(OrderForm orderForm, Map<String, Integer> retailPriceRelatedMap, Order order) {
		// 商品情報_ITEM
		String productItem = orderForm.getProductItem();
		// フロント釦数
		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();

		// JACKET_モデル_上代
		Integer doubleJacketPrice = retailPriceRelatedMap.get("doubleJACKET");
		Integer singleDoubleJacketPrice = retailPriceRelatedMap.get("singleDoubleJACKET");
		
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

	}
	
	public void getShirtCoatSizeMap(OrderForm orderForm) {
		LinkedHashMap<String, String> coatSizeMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> shirtSizeMap = new LinkedHashMap<String, String>();
		// Coat
		coatSizeMap.put("", "選択　　　");
		// Shirt
		shirtSizeMap.put("", "選択　　　");

		AdjustShirtStandardInfo adjustShirtStandardInfo = new AdjustShirtStandardInfo();
		AdjustCoatStandardInfo adjustCoatStandardInfo = new AdjustCoatStandardInfo();
		adjustShirtStandardInfo.setCorStSizeMap(shirtSizeMap);
		adjustCoatStandardInfo.setCorCtSizeMap(coatSizeMap);
		orderForm.setAdjustShirtStandardInfo(adjustShirtStandardInfo);
		orderForm.setAdjustCoatStandardInfo(adjustCoatStandardInfo);

	}

	public List<TypeSizeOptimization> getPoTypeSizeOptimization(List<TypeSize> poTypeSizeList) {
		List<TypeSizeOptimization> typeSizeList = new ArrayList<TypeSizeOptimization>();
		for (TypeSize typeSize : poTypeSizeList) {
			TypeSizeOptimization typeSizeOptimization = new TypeSizeOptimization();
			typeSizeOptimization.setAdjustClass(typeSize.getAdjustClass());
			typeSizeOptimization.setTypeSize(typeSize.getTypeSize().toString());
			typeSizeOptimization.setTypeSize1Intack(typeSize.getTypeSize1Intack().toString());
			typeSizeOptimization.setTypeSize1Outtack(typeSize.getTypeSize1Outtack().toString());
			typeSizeOptimization.setTypeSize2Intack(typeSize.getTypeSize2Intack().toString());
			typeSizeOptimization.setTypeSize2Outtack(typeSize.getTypeSize2Outtack().toString());
			typeSizeList.add(typeSizeOptimization);
		}
		return typeSizeList;
	}

	public void setDefaultValue(OrderForm orderForm) {
		this.jacketDefaultValue(orderForm);
		this.giletDefaultValue(orderForm);
		this.coatDefaultValue(orderForm);
		this.pantsDefaultValue(orderForm);
		this.shirtDefaultValue(orderForm);
	}

	public void jacketDefaultValue(OrderForm orderForm) {
		// 標準
		OptionJacketStandardInfo optionJacketStandardInfo = orderForm.getOptionJacketStandardInfo();
		optionJacketStandardInfo.setOjJacketModel("");
		optionJacketStandardInfo.setOjFrontBtnCnt(OptionCodeKeys.JK_0000101);
		optionJacketStandardInfo.setOjLapelDesign(OptionCodeKeys.JK_0000201);
		optionJacketStandardInfo.setOjGrade(OptionCodeKeys.JK_0000301);
		optionJacketStandardInfo.setOjGackSpec(OptionCodeKeys.JK_0000401);
		optionJacketStandardInfo.setOjFort(OptionCodeKeys.JK_0000501);
		optionJacketStandardInfo.setOjBackCollar(OptionCodeKeys.JK_0000701);
		optionJacketStandardInfo.setOjChainHange(OptionCodeKeys.JK_0000801);
		optionJacketStandardInfo.setOjLapelWidth(OptionCodeKeys.JK_0000901);
		optionJacketStandardInfo.setOjFlowerHole(OptionCodeKeys.JK_0001001);
		optionJacketStandardInfo.setOjBreastPkt(OptionCodeKeys.JK_0001101);
		optionJacketStandardInfo.setOjWaistPkt(OptionCodeKeys.JK_0001201);
		optionJacketStandardInfo.setOjChangePkt(OptionCodeKeys.JK_0001301);
		optionJacketStandardInfo.setOjSlantedPkt(OptionCodeKeys.JK_0001401);
		optionJacketStandardInfo.setOjCoinPkt(OptionCodeKeys.JK_0001501);
		optionJacketStandardInfo.setOjSleeveSpec(OptionCodeKeys.JK_0001601);
		optionJacketStandardInfo.setOjManica(OptionCodeKeys.JK_0001701);
		optionJacketStandardInfo.setOjSleeveBtnType(OptionCodeKeys.JK_0001801);
		optionJacketStandardInfo.setOjSleeveBtnCnt(OptionCodeKeys.JK_SLEEVE_BTN_CNT4);
		optionJacketStandardInfo.setOjCuffSpec(OptionCodeKeys.JK_0001901);
		optionJacketStandardInfo.setOjInsidePktChange(OptionCodeKeys.JK_0002001);
		optionJacketStandardInfo.setOjBreastInnerPkt(OptionCodeKeys.JK_0002201);
		optionJacketStandardInfo.setOjStitch(OptionCodeKeys.JK_0002301);
		optionJacketStandardInfo.setOjStitchModify(OptionCodeKeys.JK_0002401);
		optionJacketStandardInfo.setOjDStitchModify(OptionCodeKeys.JK_0002601);
		optionJacketStandardInfo.setOjAmfColor(OptionCodeKeys.JK_0002801);
		optionJacketStandardInfo.setOjBhColor(OptionCodeKeys.JK_0003101);
		optionJacketStandardInfo.setOjByColor(OptionCodeKeys.JK_0003401);
		optionJacketStandardInfo.setOjVentSpec(OptionCodeKeys.JK_0003701);
		optionJacketStandardInfo.setOjBodyBackMate(OptionCodeKeys.JK_1000100);
		optionJacketStandardInfo.setOjCuffBackMate(OptionCodeKeys.JK_2000100);
		optionJacketStandardInfo.setOjBtnMate(OptionCodeKeys.JK_3000800);
		optionJacketStandardInfo.setOjShapeMemory(OptionCodeKeys.JK_0004401);

		// タキシード
		OptionJacketTuxedoInfo optionJacketTuxedoInfo = orderForm.getOptionJacketTuxedoInfo();
		optionJacketTuxedoInfo.setTjJacketModel("");
		optionJacketTuxedoInfo.setTjFrontBtnCnt(OptionCodeKeys.JK_0000101);
		optionJacketTuxedoInfo.setTjLapelDesign(OptionCodeKeys.JK_0000201);
		optionJacketTuxedoInfo.setTjGrade(OptionCodeKeys.JK_0000301);
		optionJacketTuxedoInfo.setTjBackSpec(OptionCodeKeys.JK_0000401);
		optionJacketTuxedoInfo.setTjFort(OptionCodeKeys.JK_0000502);
		optionJacketTuxedoInfo.setTjGlossFablic(OptionCodeKeys.JK_0000601);
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
		optionJacketTuxedoInfo.setTjStitch(OptionCodeKeys.JK_0002302);
		optionJacketTuxedoInfo.setTjBhColor(OptionCodeKeys.JK_0003101);
		optionJacketTuxedoInfo.setTjByColor(OptionCodeKeys.JK_0003401);
		optionJacketTuxedoInfo.setTjVentSpec(OptionCodeKeys.JK_0003701);
		optionJacketTuxedoInfo.setTjBodyBackMate(OptionCodeKeys.JK_1000100);
		optionJacketTuxedoInfo.setTjCuffBackMate(OptionCodeKeys.JK_2000100);
		optionJacketTuxedoInfo.setTjBtnMate(OptionCodeKeys.JK_3000800);
		optionJacketTuxedoInfo.setTjShapeMemory(OptionCodeKeys.JK_0004401);

		// ウォッシャブル
		OptionJacketWashableInfo optionJacketWashableInfo = orderForm.getOptionJacketWashableInfo();
		optionJacketWashableInfo.setWjJacketModel("");
		optionJacketWashableInfo.setWjFrontBtnCnt(OptionCodeKeys.JK_0000101);
		optionJacketWashableInfo.setWjLapelDesign(OptionCodeKeys.JK_0000201);
		optionJacketWashableInfo.setWjGrade(OptionCodeKeys.JK_0000301);
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
		optionJacketWashableInfo.setWjStitch(OptionCodeKeys.JK_0002304);
		optionJacketWashableInfo.setWjStitchModify(OptionCodeKeys.JK_0002401);
		optionJacketWashableInfo.setWjDStitchModify(OptionCodeKeys.JK_0002601);
		optionJacketWashableInfo.setWjAmfColor(OptionCodeKeys.JK_0002801);
		optionJacketWashableInfo.setWjBhColor(OptionCodeKeys.JK_0003101);
		optionJacketWashableInfo.setWjByColor(OptionCodeKeys.JK_0003401);
		optionJacketWashableInfo.setWjVentSpec(OptionCodeKeys.JK_0003701);
		optionJacketWashableInfo.setWjBodyBackMate(OptionCodeKeys.JK_1000100);
		optionJacketWashableInfo.setWjCuffBackMate(OptionCodeKeys.JK_2000100);
		optionJacketWashableInfo.setWjBtnMate(OptionCodeKeys.JK_3000800);
		optionJacketWashableInfo.setWjShapeMemory(OptionCodeKeys.JK_0004401);
	}
	
	public void coatDefaultValue(OrderForm orderForm) {
		OptionCoatStandardInfo optionCoatStandardInfo = orderForm.getOptionCoatStandardInfo();
		optionCoatStandardInfo.setCoatModel("");
		optionCoatStandardInfo.setOcLapelDesign(OptionCodeKeys.CT_0000101);
		optionCoatStandardInfo.setOcWaistPkt(OptionCodeKeys.CT_0000201);
		optionCoatStandardInfo.setOcChangePkt(OptionCodeKeys.CT_0000301);
		optionCoatStandardInfo.setOcSlantedPkt(OptionCodeKeys.CT_0000401);
		optionCoatStandardInfo.setOcVentSpec(OptionCodeKeys.CT_0000501);
		optionCoatStandardInfo.setOcFrontBtnCnt(OptionCodeKeys.CT_0000601);
		optionCoatStandardInfo.setOcCuffSpec(OptionCodeKeys.CT_0000701);
		optionCoatStandardInfo.setOcSleeveBtnType(OptionCodeKeys.CT_0000801);
		optionCoatStandardInfo.setOcBackBelt(OptionCodeKeys.CT_0000901);
		optionCoatStandardInfo.setOcChainHange(OptionCodeKeys.CT_0001001);
		optionCoatStandardInfo.setOcBodyBackMate(OptionCodeKeys.CT_4000100);
		optionCoatStandardInfo.setOcCuffBackMate(OptionCodeKeys.CT_5000100);
		optionCoatStandardInfo.setOcFrontBtnMate(OptionCodeKeys.CT_6000100);
		optionCoatStandardInfo.setOcSleeveSpec(OptionCodeKeys.CT_0001401);
	}
	
	public void giletDefaultValue(OrderForm orderForm) {
		//標準
		OptionGiletStandardInfo optionGiletStandardInfo = orderForm.getOptionGiletStandardInfo();
		optionGiletStandardInfo.setOgGiletModel("");
		optionGiletStandardInfo.setOgBreastPkt("");
		optionGiletStandardInfo.setOgWaistPkt("");
		optionGiletStandardInfo.setOgWaistPktSpec("");
		optionGiletStandardInfo.setOgStitch(OptionCodeKeys.GL_0000504);
		optionGiletStandardInfo.setOgStitchModify(OptionCodeKeys.GL_0000601);
		optionGiletStandardInfo.setOgDStitchModify(OptionCodeKeys.GL_0002601);
		optionGiletStandardInfo.setOgAmfColor(OptionCodeKeys.GL_0000801);
		optionGiletStandardInfo.setOgBhColor(OptionCodeKeys.GL_0001101);
		optionGiletStandardInfo.setOgByColor(OptionCodeKeys.GL_0001401);
		optionGiletStandardInfo.setOgBackLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletStandardInfo.setOgInsideLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletStandardInfo.setOgFrontBtnMate(OptionCodeKeys.GL_3000800);
		optionGiletStandardInfo.setOgBackBelt("");
		optionGiletStandardInfo.setOgWatchChain(OptionCodeKeys.GL_0002401);
		
		//タキシード
		OptionGiletTuxedoInfo optionGiletTuxedoInfo = orderForm.getOptionGiletTuxedoInfo();
		optionGiletTuxedoInfo.setTgGiletModel("");
		optionGiletTuxedoInfo.setTgBreastPkt("");
		optionGiletTuxedoInfo.setTgWaistPkt("");
		optionGiletTuxedoInfo.setTgWaistPktSpec("");
		optionGiletTuxedoInfo.setTgWaistPktMate(OptionCodeKeys.GL_0000401);
		optionGiletTuxedoInfo.setTgStitch(OptionCodeKeys.GL_0000504);
		optionGiletTuxedoInfo.setTgBhColor(OptionCodeKeys.GL_0001101);
		optionGiletTuxedoInfo.setTgByColor(OptionCodeKeys.GL_0001401);
		optionGiletTuxedoInfo.setTgBackLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletTuxedoInfo.setTgInsideLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletTuxedoInfo.setTgFrontBtnMate(OptionCodeKeys.GL_3000800);
		optionGiletTuxedoInfo.setTgBackBelt("");
		optionGiletTuxedoInfo.setTgWatchChain(OptionCodeKeys.GL_0002401);
		
		//ウォッシャブル
		OptionGiletWashableInfo optionGiletWashableInfo = orderForm.getOptionGiletWashableInfo();
		optionGiletWashableInfo.setWgGiletModel("");
		optionGiletWashableInfo.setWgBreastPkt("");
		optionGiletWashableInfo.setWgWaistPkt("");
		optionGiletWashableInfo.setWgWaistPktSpec("");
		optionGiletWashableInfo.setWgStitch(OptionCodeKeys.GL_0000504);
		optionGiletWashableInfo.setWgStitchModify(OptionCodeKeys.GL_0000601);
		optionGiletWashableInfo.setWgDStitchModify(OptionCodeKeys.GL_0002601);
		optionGiletWashableInfo.setWgAmfColor(OptionCodeKeys.GL_0000801);
		optionGiletWashableInfo.setWgBhColor(OptionCodeKeys.GL_0001101);
		optionGiletWashableInfo.setWgByColor(OptionCodeKeys.GL_0001401);
		optionGiletWashableInfo.setWgBackLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletWashableInfo.setWgInsideLiningMate(OptionCodeKeys.GL_1000100);
		optionGiletWashableInfo.setWgFrontBtnMate(OptionCodeKeys.GL_3000800);
		optionGiletWashableInfo.setWgBackBelt("");
		optionGiletWashableInfo.setWgWatchChain(OptionCodeKeys.GL_0002401);
	}

	public void pantsDefaultValue(OrderForm orderForm) {
		//標準
		OptionPantsStandardInfo optionPantsStandardInfo = orderForm.getOptionPantsStandardInfo();
		//PANTSモデル
		optionPantsStandardInfo.setOpPantsModel("");
		//タック
		optionPantsStandardInfo.setOpTack(OptionCodeKeys.PT_0000101);
		//膝裏
		optionPantsStandardInfo.setOpKneeBack(OptionCodeKeys.PT_0000201);
		//膝裏素材
		optionPantsStandardInfo.setOpKneeBackMate(OptionCodeKeys.PT_0000301);
		//フロント仕様
		optionPantsStandardInfo.setOpFrontSpec(OptionCodeKeys.PT_0000401);
		 //パンチェリーナ
		optionPantsStandardInfo.setOpPancherina(OptionCodeKeys.PT_0000501);
		//アジャスター仕様
		optionPantsStandardInfo.setOpAdjuster(OptionCodeKeys.PT_0000601);
		//ベルトループ
		optionPantsStandardInfo.setOpBeltLoop(OptionCodeKeys.PT_0000701);
		//ピンループ
		optionPantsStandardInfo.setOpPinLoop(OptionCodeKeys.PT_0000901);
		//脇ポケット
		optionPantsStandardInfo.setOpSidePkt(OptionCodeKeys.PT_0001002);
		//忍びポケット
		optionPantsStandardInfo.setOpSinobiPkt(OptionCodeKeys.PT_0001104);
		//コインポケット
		optionPantsStandardInfo.setOpCoinPkt(OptionCodeKeys.PT_0001201);
		//フラップ付コインポケット
		optionPantsStandardInfo.setOpFlapCoinPkt(OptionCodeKeys.PT_0001301);
		//上前ピスポケット
		optionPantsStandardInfo.setOpPisPktUf(OptionCodeKeys.PT_0001401);
		//下前ピスポケット
		optionPantsStandardInfo.setOpPisPktDf(OptionCodeKeys.PT_0001501);
		//Vカット
		optionPantsStandardInfo.setOpVCut(OptionCodeKeys.PT_0001602);
		//裾上げ
		optionPantsStandardInfo.setOpHemUp(OptionCodeKeys.PT_0001701);
		//ダブル幅
		optionPantsStandardInfo.setOpDoubleWide(OptionCodeKeys.PT_4);
		//ステッチ種類
		optionPantsStandardInfo.setOpStitch(OptionCodeKeys.PT_0001904);
		//ステッチ箇所変更
		optionPantsStandardInfo.setOpStitchModify(OptionCodeKeys.PT_0002001);
		//ダブルステッチ
		optionPantsStandardInfo.setOpDStitch(OptionCodeKeys.PT_0002201);
		//AMF色指定
		optionPantsStandardInfo.setOpAmfColor(OptionCodeKeys.PT_0002401);
		//ボタンホール色指定
		optionPantsStandardInfo.setOpBhColor(OptionCodeKeys.PT_0002701);
		//ボタン付け糸指定
		optionPantsStandardInfo.setOpByColor(OptionCodeKeys.PT_0003001);
		//釦素材
		optionPantsStandardInfo.setOpButton(OptionCodeKeys.PT_3000800);
		//サスペンダー釦
		optionPantsStandardInfo.setOpSuspenderBtn(OptionCodeKeys.PT_0003501);
		//シック大（股補強）
		optionPantsStandardInfo.setOpThick(OptionCodeKeys.PT_0004101);
		//エイト（滑り止め）
		optionPantsStandardInfo.setOpEight(OptionCodeKeys.PT_0003601);
		//形状記憶
		optionPantsStandardInfo.setOpShapeMemory(OptionCodeKeys.PT_0003701);
		
		
		//タキシード
		OptionPantsTuxedoInfo optionPantsTuxedoInfo = orderForm.getOptionPantsTuxedoInfo();
		//PANTSモデル
		optionPantsTuxedoInfo.setTpPantsModel("");
		//タック
		optionPantsTuxedoInfo.setTpTack(OptionCodeKeys.PT_0000101);
		//膝裏
		optionPantsTuxedoInfo.setTpKneeBack(OptionCodeKeys.PT_0000201);
		//膝裏素材
		optionPantsTuxedoInfo.setTpKneeBackMate(OptionCodeKeys.PT_0000301);
		//フロント仕様
		optionPantsTuxedoInfo.setTpFrontSpec(OptionCodeKeys.PT_0000401);
		 //パンチェリーナ
		optionPantsTuxedoInfo.setTpPancherina(OptionCodeKeys.PT_0000501);
		//アジャスター仕様
		optionPantsTuxedoInfo.setTpAdjuster(OptionCodeKeys.PT_0000601);
		//ベルトループ
		optionPantsTuxedoInfo.setTpBeltLoop(OptionCodeKeys.PT_0000701);
		//ピンループ
		optionPantsTuxedoInfo.setTpPinLoop(OptionCodeKeys.PT_0000901);
		//脇ポケット
		optionPantsTuxedoInfo.setTpSidePkt(OptionCodeKeys.PT_0001002);
		//忍びポケット
		optionPantsTuxedoInfo.setTpSinobiPkt(OptionCodeKeys.PT_0001104);
		//コインポケット
		optionPantsTuxedoInfo.setTpCoinPkt(OptionCodeKeys.PT_0001201);
		//フラップ付コインポケット
		optionPantsTuxedoInfo.setTpFlapCoinPkt(OptionCodeKeys.PT_0001301);
		//上前ピスポケット
		optionPantsTuxedoInfo.setTpPisPktUf(OptionCodeKeys.PT_0001401);
		//下前ピスポケット
		optionPantsTuxedoInfo.setTpPisPktDf(OptionCodeKeys.PT_0001501);
		//Vカット
		optionPantsTuxedoInfo.setTpVCut(OptionCodeKeys.PT_0001602);
		//裾上げ
		optionPantsTuxedoInfo.setTpHemUp(OptionCodeKeys.PT_0001701);
		//ダブル幅
		optionPantsTuxedoInfo.setTpDoubleWide(OptionCodeKeys.PT_4);
		//ステッチ種類
		optionPantsTuxedoInfo.setTpStitch(OptionCodeKeys.PT_0001903);
		//ボタンホール色指定
		optionPantsTuxedoInfo.setTpBhColor(OptionCodeKeys.PT_0002701);
		//ボタン付け糸指定
		optionPantsTuxedoInfo.setTpByColor(OptionCodeKeys.PT_0003001);
		//釦素材
		optionPantsTuxedoInfo.setTpButton(OptionCodeKeys.PT_3000800);
		//サスペンダー釦
		optionPantsTuxedoInfo.setTpSuspenderBtn(OptionCodeKeys.PT_0003501);
		//シック大（股補強）
		optionPantsTuxedoInfo.setTpThick(OptionCodeKeys.PT_0004101);
		//エイト（滑り止め）
		optionPantsTuxedoInfo.setTpEight(OptionCodeKeys.PT_0003601);
		//形状記憶
		optionPantsTuxedoInfo.setTpShapeMemory(OptionCodeKeys.PT_0003701);
		//側章
		optionPantsTuxedoInfo.setTpSideStripe(OptionCodeKeys.PT_0003902);
		//側章幅
		optionPantsTuxedoInfo.setTpSideStripeWidth(OptionCodeKeys.PT_0004001);
		
		//ウォッシャブル
		OptionPantsWashableInfo optionPantsWashableInfo = orderForm.getOptionPantsWashableInfo();
		//PANTSモデル
		optionPantsWashableInfo.setWpPantsModel("");
		//タック
		optionPantsWashableInfo.setWpTack(OptionCodeKeys.PT_0000101);
		//膝裏
		optionPantsWashableInfo.setWpKneeBack(OptionCodeKeys.PT_0000201);
		//膝裏素材
		optionPantsWashableInfo.setWpKneeBackMate(OptionCodeKeys.PT_0000301);
		//フロント仕様
		optionPantsWashableInfo.setWpFrontSpec(OptionCodeKeys.PT_0000401);
		 //パンチェリーナ
		optionPantsWashableInfo.setWpPancherina(OptionCodeKeys.PT_0000501);
		//アジャスター仕様
		optionPantsWashableInfo.setWpAdjuster(OptionCodeKeys.PT_0000601);
		//ベルトループ
		optionPantsWashableInfo.setWpBeltLoop(OptionCodeKeys.PT_0000701);
		//ピンループ
		optionPantsWashableInfo.setWpPinLoop(OptionCodeKeys.PT_0000901);
		//脇ポケット
		optionPantsWashableInfo.setWpSidePkt(OptionCodeKeys.PT_0001002);
		//忍びポケット
		optionPantsWashableInfo.setWpSinobiPkt(OptionCodeKeys.PT_0001104);
		//コインポケット
		optionPantsWashableInfo.setWpCoinPkt(OptionCodeKeys.PT_0001201);
		//フラップ付コインポケット
		optionPantsWashableInfo.setWpFlapCoinPkt(OptionCodeKeys.PT_0001301);
		//上前ピスポケット
		optionPantsWashableInfo.setWpPisPktUf(OptionCodeKeys.PT_0001401);
		//下前ピスポケット
		optionPantsWashableInfo.setWpPisPktDf(OptionCodeKeys.PT_0001501);
		//Vカット
		optionPantsWashableInfo.setWpVCut(OptionCodeKeys.PT_0001602);
		//裾上げ
		optionPantsWashableInfo.setWpHemUp(OptionCodeKeys.PT_0001701);
		//ダブル幅
		optionPantsWashableInfo.setWpDoubleWide(OptionCodeKeys.PT_4);
		//ステッチ種類
		optionPantsWashableInfo.setWpStitch(OptionCodeKeys.PT_0001901);
		//ステッチ箇所変更
		optionPantsWashableInfo.setWpStitchModify(OptionCodeKeys.PT_0002001);
		//ダブルステッチ
		optionPantsWashableInfo.setWpDStitch(OptionCodeKeys.PT_0002201);
		//AMF色指定
		optionPantsWashableInfo.setWpAmfColor(OptionCodeKeys.PT_0002401);
		//ボタンホール色指定
		optionPantsWashableInfo.setWpBhColor(OptionCodeKeys.PT_0002701);
		//ボタン付け糸指定
		optionPantsWashableInfo.setWpByColor(OptionCodeKeys.PT_0003001);
		//釦素材
		optionPantsWashableInfo.setWpButton(OptionCodeKeys.PT_3000800);
		//サスペンダー釦
		optionPantsWashableInfo.setWpSuspenderBtn(OptionCodeKeys.PT_0003501);
		//シック大（股補強）
		optionPantsWashableInfo.setWpThick(OptionCodeKeys.PT_0004101);
		//エイト（滑り止め）
		optionPantsWashableInfo.setWpEight(OptionCodeKeys.PT_0003601);
		//形状記憶
		optionPantsWashableInfo.setWpShapeMemory(OptionCodeKeys.PT_0003701);
	}
	
	public void shirtDefaultValue(OrderForm orderForm) {
		//標準
		OptionShirtStandardInfo optionShirtStandardInfo = orderForm.getOptionShirtStandardInfo();
		optionShirtStandardInfo.setOsShirtModel("");
		optionShirtStandardInfo.setOsChainModel(OptionCodeKeys.sht_0000100);
		optionShirtStandardInfo.setOsCuffs(OptionCodeKeys.sht_0000200);
		optionShirtStandardInfo.setOsConvertible(OptionCodeKeys.sht_0000301);
		optionShirtStandardInfo.setOsAdjustBtn(OptionCodeKeys.sht_0000401);
		optionShirtStandardInfo.setOsClericSpec(OptionCodeKeys.sht_0000501);
		optionShirtStandardInfo.setOsDblCuff(OptionCodeKeys.sht_0000601);
		optionShirtStandardInfo.setOsAddCuff(OptionCodeKeys.sht_0000701);
		optionShirtStandardInfo.setOsBtnMate(OptionCodeKeys.sht_0000801);
		optionShirtStandardInfo.setOsTabBtn(OptionCodeKeys.sht_0000901);
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

	public void getJacketModelMap(OrderForm orderForm, List<Model> modelList) {
		LinkedHashMap<String,String> modelMap = new LinkedHashMap<String,String>();
		for (Model model : modelList) {
			modelMap.put("","モデル選択");
			modelMap.put(model.getModelCode(),model.getModelName());
		}
		orderForm.getOptionJacketStandardInfo().setOjJacketModelMap(modelMap);
		orderForm.getOptionJacketTuxedoInfo().setTjJacketModelMap(modelMap);
		orderForm.getOptionJacketWashableInfo().setWjJacketModelMap(modelMap);
	}
	
	public void getPantsModelMap(OrderForm orderForm, List<Model> modelList) {
		LinkedHashMap<String,String> modelMap = new LinkedHashMap<String,String>();
		for (Model model : modelList) {
			modelMap.put("","モデル選択");
			modelMap.put(model.getModelCode(),model.getModelName());
		}
		orderForm.getOptionPantsStandardInfo().setOpPantsModelMap(modelMap);
		orderForm.getOptionPantsTuxedoInfo().setTpPantsModelMap(modelMap);
		orderForm.getOptionPantsWashableInfo().setWpPantsModelMap(modelMap);
	}
	
	public void getPants2ModelMap(OrderForm orderForm, List<Model> modelList) {
		LinkedHashMap<String,String> modelMap = new LinkedHashMap<String,String>();
		for (Model model : modelList) {
			modelMap.put("","モデル選択");
			modelMap.put(model.getModelCode(),model.getModelName());
		}
		orderForm.getOptionPants2StandardInfo().setOp2PantsModelMap(modelMap);
		orderForm.getOptionPants2TuxedoInfo().setTp2PantsModelMap(modelMap);
		orderForm.getOptionPants2WashableInfo().setWp2PantsModelMap(modelMap);
	}
	
	public void getCoatModelMap(OrderForm orderForm, List<Model> modelList) {
		LinkedHashMap<String,String> modelMap = new LinkedHashMap<String,String>();
		for (Model model : modelList) {
			modelMap.put("","モデル選択");
			modelMap.put(model.getModelCode(),model.getModelName());
		}
		orderForm.getOptionCoatStandardInfo().setCoatModelMap(modelMap);;;
	}
	
	public void getGiletModelMap(OrderForm orderForm, List<Model> modelList) {
		LinkedHashMap<String,String> modelMap = new LinkedHashMap<String,String>();
		for (Model model : modelList) {
			modelMap.put("","モデル選択");
			modelMap.put(model.getModelCode(),model.getModelName());
		}
		orderForm.getOptionGiletStandardInfo().setOgGiletModelMap(modelMap);
		orderForm.getOptionGiletTuxedoInfo().setTgGiletModelMap(modelMap);
		orderForm.getOptionGiletWashableInfo().setWgGiletModelMap(modelMap);
	}
	
	public void getShirtModelMap(OrderForm orderForm, List<Model> modelList) {
		LinkedHashMap<String,String> modelMap = new LinkedHashMap<String,String>();
		for (Model model : modelList) {
			modelMap.put("","モデル選択");
			modelMap.put(model.getModelCode(),model.getModelName());
		}
		orderForm.getOptionShirtStandardInfo().setOsShirtModelMap(modelMap);
	}
	
	/**
	 * 標準JACKET素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectStandardJkMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> standardJkMaterialMap = new HashMap<String,String>();
		//JK胴裏素材
		String ojBodyBackMateStkNo = orderForm.getOptionJacketStandardInfo().getOjBodyBackMateStkNo();
		String ojBodyBackMateName = orderForm.getOptionJacketStandardInfo().getOjBodyBackMateMap().get(orderForm.getOptionJacketStandardInfo().getOjBodyBackMate());
		//JK袖裏素材
		String ojCuffBackMateStkNo = orderForm.getOptionJacketStandardInfo().getOjCuffBackMateStkNo();
		String ojCuffBackMateName = orderForm.getOptionJacketStandardInfo().getOjCuffBackMateMap().get(orderForm.getOptionJacketStandardInfo().getOjCuffBackMate());
		//JK釦素材
		String ojBtnMateStkNo = orderForm.getOptionJacketStandardInfo().getOjBtnMateStkNo();
		String ojBtnMateName = orderForm.getOptionJacketStandardInfo().getOjBtnMateMap().get(orderForm.getOptionJacketStandardInfo().getOjBtnMate());
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(ojBodyBackMateStkNo != null && ojBodyBackMateStkNo.equals(optionBranchDetailCode)) {
				standardJkMaterialMap.put("ojBodyBackMateStkNo",ojBodyBackMateName + " " + optionBranchDetailName);
			}
			else if(ojCuffBackMateStkNo != null && ojCuffBackMateStkNo.equals(optionBranchDetailCode)) {
				standardJkMaterialMap.put("ojCuffBackMateStkNo",ojCuffBackMateName + " " + optionBranchDetailName);
			}
			else if(ojBtnMateStkNo != null && ojBtnMateStkNo.equals(optionBranchDetailCode)) {
				standardJkMaterialMap.put("ojBtnMateStkNo",ojBtnMateName + " " + optionBranchDetailName);
			}
		}
		return standardJkMaterialMap;
	}
	
	/**
	 * 標準GILET素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectStandardGlMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> standardGlMaterialMap = new HashMap<String,String>();
		//GL背裏地素材
		String ogBackLiningMateStkNo = orderForm.getOptionGiletStandardInfo().getOgBackLiningMateStkNo();
		String ogBackLiningMateName = orderForm.getOptionGiletStandardInfo().getOgBackLiningMateMap().get(orderForm.getOptionGiletStandardInfo().getOgBackLiningMate());
		//GL内側裏地素材
		String ogInsideLiningMateStkNo = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMateStkNo();
		String ogInsideLiningMateName = orderForm.getOptionGiletStandardInfo().getOgInsideLiningMateMap().get(orderForm.getOptionGiletStandardInfo().getOgInsideLiningMate());
		//GLフロント釦
		String ogFrontBtnMateStkNo = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMateStkNo();
		String ogFrontBtnMateName = orderForm.getOptionGiletStandardInfo().getOgFrontBtnMateMap().get(orderForm.getOptionGiletStandardInfo().getOgFrontBtnMate());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(ogBackLiningMateStkNo != null && ogBackLiningMateStkNo.equals(optionBranchDetailCode)) {
				standardGlMaterialMap.put("ogBackLiningMateStkNo",ogBackLiningMateName + " " + optionBranchDetailName);
			}
			if(ogInsideLiningMateStkNo != null && ogInsideLiningMateStkNo.equals(optionBranchDetailCode)) {
				standardGlMaterialMap.put("ogInsideLiningMateStkNo",ogInsideLiningMateName + " " + optionBranchDetailName);
			}
			if(ogFrontBtnMateStkNo != null && ogFrontBtnMateStkNo.equals(optionBranchDetailCode)) {
				standardGlMaterialMap.put("ogFrontBtnMateStkNo",ogFrontBtnMateName + " " + optionBranchDetailName);
			}
		}
		return standardGlMaterialMap;
	}
	
	/**
	 * 標準COAT素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectStandardCtMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> standardCtMaterialMap = new HashMap<String,String>();
		//CT胴裏素材
		String ocBodyBackMateStkNo = orderForm.getOptionCoatStandardInfo().getOcBodyBackMateStkNo();
		String ocBodyBackMateName = orderForm.getOptionCoatStandardInfo().getOcBodyBackMateMap().get(orderForm.getOptionCoatStandardInfo().getOcBodyBackMate());
		//CT袖裏素材
		String ocCuffBackMateStkNo = orderForm.getOptionCoatStandardInfo().getOcCuffBackMateStkNo();
		String ocCuffBackMateName = orderForm.getOptionCoatStandardInfo().getOcCuffBackMateMap().get(orderForm.getOptionCoatStandardInfo().getOcCuffBackMate());
		//CT釦素材
		String ocFrontBtnMateStkNo = orderForm.getOptionCoatStandardInfo().getOcFrontBtnMateStkNo();
		String OcFrontBtnMateName = orderForm.getOptionCoatStandardInfo().getOcFrontBtnMateMap().get(orderForm.getOptionCoatStandardInfo().getOcFrontBtnMate());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(ocBodyBackMateStkNo != null && ocBodyBackMateStkNo.equals(optionBranchDetailCode)) {
				standardCtMaterialMap.put("ocBodyBackMateStkNo",ocBodyBackMateName + " " + optionBranchDetailName);
			}
			else if(ocCuffBackMateStkNo != null && ocCuffBackMateStkNo.equals(optionBranchDetailCode)) {
				standardCtMaterialMap.put("ocCuffBackMateStkNo",ocCuffBackMateName + " " + optionBranchDetailName);
			}
			else if(ocFrontBtnMateStkNo != null && ocFrontBtnMateStkNo.equals(optionBranchDetailCode)) {
				standardCtMaterialMap.put("ocFrontBtnMateStkNo",OcFrontBtnMateName + " " + optionBranchDetailName);
			}
		}
		return standardCtMaterialMap;
	}
	
	/**
	 * 標準PANTS素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectStandardPtMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> standardPtMaterialMap = new HashMap<String,String>();
		//PT釦素材
		String opBtnMateStkNo = orderForm.getOptionPantsStandardInfo().getOpBtnMateStkNo();
		String opButtonName = orderForm.getOptionPantsStandardInfo().getOpButtonMap().get(orderForm.getOptionPantsStandardInfo().getOpButton());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(opBtnMateStkNo != null && opBtnMateStkNo.equals(optionBranchDetailCode)) {
				standardPtMaterialMap.put("opBtnMateStkNo",opButtonName + " " + optionBranchDetailName);
				break;
			}
		}
		return standardPtMaterialMap;
	}
	
	/**
	 * 標準2PANTS素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectStandardPt2MaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> standardPt2MaterialMap = new HashMap<String,String>();
		//PT2釦素材
		String op2BtnMateStkNo = orderForm.getOptionPants2StandardInfo().getOp2BtnMateStkNo();
		String op2ButtonName = orderForm.getOptionPants2StandardInfo().getOp2ButtonMap().get(orderForm.getOptionPants2StandardInfo().getOp2Button());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(op2BtnMateStkNo != null && op2BtnMateStkNo.equals(optionBranchDetailCode)) {
				standardPt2MaterialMap.put("op2BtnMateStkNo",op2ButtonName + " " + optionBranchDetailName);
				break;
			}
		}
		return standardPt2MaterialMap;
	}
	
	/**
	 * タキシードJACKET素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectTuxedoJkMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> tuxedoJkMaterialMap = new HashMap<String,String>();
		//JK胴裏素材
		String tjBodyBackMateStkNo = orderForm.getOptionJacketTuxedoInfo().getTjBodyBackMateStkNo();
		String tjBodyBackMateName = orderForm.getOptionJacketTuxedoInfo().getTjBodyBackMateMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBodyBackMate());
		//JK袖裏素材
		String tjCuffBackMateStkNo = orderForm.getOptionJacketTuxedoInfo().getTjCuffBackMateStkNo();
		String tjCuffBackMateName = orderForm.getOptionJacketTuxedoInfo().getTjCuffBackMateMap().get(orderForm.getOptionJacketTuxedoInfo().getTjCuffBackMate());
		//JK釦素材
		String tjBtnMateStkNo = orderForm.getOptionJacketTuxedoInfo().getTjBtnMateStkNo();
		String tjBtnMateName = orderForm.getOptionJacketTuxedoInfo().getTjBtnMateMap().get(orderForm.getOptionJacketTuxedoInfo().getTjBtnMate());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(tjBodyBackMateStkNo != null && tjBodyBackMateStkNo.equals(optionBranchDetailCode)) {
				tuxedoJkMaterialMap.put("tjBodyBackMateStkNo",tjBodyBackMateName + " " + optionBranchDetailName);
			}
			else if(tjCuffBackMateStkNo != null && tjCuffBackMateStkNo.equals(optionBranchDetailCode)) {
				tuxedoJkMaterialMap.put("tjCuffBackMateStkNo",tjCuffBackMateName + " " + optionBranchDetailName);
			}
			else if(tjBtnMateStkNo != null && tjBtnMateStkNo.equals(optionBranchDetailCode)) {
				tuxedoJkMaterialMap.put("tjBtnMateStkNo",tjBtnMateName + " " + optionBranchDetailName);
			}
		}
		return tuxedoJkMaterialMap;
	}
	
	/**
	 * タキシードGILET素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectTuxedoGlMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> tuxedoGlMaterialMap = new HashMap<String,String>();
		//GL背裏地素材
		String tgBackLiningMateStkNo = orderForm.getOptionGiletTuxedoInfo().getTgBackLiningMateStkNo();
		String tgBackLiningMateName = orderForm.getOptionGiletTuxedoInfo().getTgBackLiningMateMap().get(orderForm.getOptionGiletTuxedoInfo().getTgBackLiningMate());
		//GL内側裏地素材
		String tgInsideLiningMateStkNo = orderForm.getOptionGiletTuxedoInfo().getTgInsideLiningMateStkNo();
		String tgInsideLiningMateName = orderForm.getOptionGiletTuxedoInfo().getTgInsideLiningMateMap().get(orderForm.getOptionGiletTuxedoInfo().getTgInsideLiningMate());
		//GLフロント釦
		String tgFrontBtnMateStkNo = orderForm.getOptionGiletTuxedoInfo().getTgFrontBtnMateStkNo();
		String tgFrontBtnMateName = orderForm.getOptionGiletTuxedoInfo().getTgFrontBtnMateMap().get(orderForm.getOptionGiletTuxedoInfo().getTgFrontBtnMate());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(tgBackLiningMateStkNo != null && tgBackLiningMateStkNo.equals(optionBranchDetailCode)) {
				tuxedoGlMaterialMap.put("tgBackLiningMateStkNo",tgBackLiningMateName + " " + optionBranchDetailName);
			}
			if(tgInsideLiningMateStkNo != null && tgInsideLiningMateStkNo.equals(optionBranchDetailCode)) {
				tuxedoGlMaterialMap.put("tgInsideLiningMateStkNo",tgInsideLiningMateName + " " + optionBranchDetailName);
			}
			if(tgFrontBtnMateStkNo != null && tgFrontBtnMateStkNo.equals(optionBranchDetailCode)) {
				tuxedoGlMaterialMap.put("tgFrontBtnMateStkNo",tgFrontBtnMateName + " " + optionBranchDetailName);
			}
		}
		return tuxedoGlMaterialMap;
	}
	
	/**
	 * タキシードPANTS素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectTuxedoPtMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> tuxedoPtMaterialMap = new HashMap<String,String>();
		//PT釦素材
		String tpBtnMateStkNo = orderForm.getOptionPantsTuxedoInfo().getTpBtnMateStkNo();
		String tpButtonName = orderForm.getOptionPantsTuxedoInfo().getTpButtonMap().get(orderForm.getOptionPantsTuxedoInfo().getTpButton());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(tpBtnMateStkNo != null && tpBtnMateStkNo.equals(optionBranchDetailCode)) {
				tuxedoPtMaterialMap.put("tpBtnMateStkNo",tpButtonName + " " + optionBranchDetailName);
				break;
			}
		}
		return tuxedoPtMaterialMap;
	}
	
	/**
	 * タキシード2PANTS素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectTuxedoPt2MaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> tuxedoPt2MaterialMap = new HashMap<String,String>();
		//PT2釦素材
		String tp2BtnMateStkNo = orderForm.getOptionPants2TuxedoInfo().getTp2BtnMateStkNo();
		String tp2ButtonName = orderForm.getOptionPants2TuxedoInfo().getTp2ButtonMap().get(orderForm.getOptionPants2TuxedoInfo().getTp2Button());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(tp2BtnMateStkNo != null && tp2BtnMateStkNo.equals(optionBranchDetailCode)) {
				tuxedoPt2MaterialMap.put("tp2BtnMateStkNo",tp2ButtonName + " " + optionBranchDetailName);
				break;
			}
			
		}
		return tuxedoPt2MaterialMap;
	}
		
	/**
	 *  ウォッシャブルJACKET素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectWashableJkMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> washableJkMaterialMap = new HashMap<String,String>();
		//JK胴裏素材
		String wjBodyBackMateStkNo = orderForm.getOptionJacketWashableInfo().getWjBodyBackMateStkNo();
		String wjBodyBackMateName = orderForm.getOptionJacketWashableInfo().getWjBodyBackMateMap().get(orderForm.getOptionJacketWashableInfo().getWjBodyBackMate());
		//JK袖裏素材
		String wjCuffBackMateStkNo = orderForm.getOptionJacketWashableInfo().getWjCuffBackMateStkNo();
		String wjCuffBackMateName = orderForm.getOptionJacketWashableInfo().getWjCuffBackMateMap().get(orderForm.getOptionJacketWashableInfo().getWjCuffBackMate());
		//JK釦素材
		String wjBtnMateStkNo = orderForm.getOptionJacketWashableInfo().getWjBtnMateStkNo();
		String wjBtnMateName = orderForm.getOptionJacketWashableInfo().getWjBtnMateMap().get(orderForm.getOptionJacketWashableInfo().getWjBtnMate());
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(wjBodyBackMateStkNo != null && wjBodyBackMateStkNo.equals(optionBranchDetailCode)) {
				washableJkMaterialMap.put("wjBodyBackMateStkNo",wjBodyBackMateName + " " + optionBranchDetailName);
			}
			else if(wjCuffBackMateStkNo != null && wjCuffBackMateStkNo.equals(optionBranchDetailCode)) {
				washableJkMaterialMap.put("wjCuffBackMateStkNo",wjCuffBackMateName + " " + optionBranchDetailName);
			}
			else if(wjBtnMateStkNo != null && wjBtnMateStkNo.equals(optionBranchDetailCode)) {
				washableJkMaterialMap.put("wjBtnMateStkNo",wjBtnMateName + " " + optionBranchDetailName);
			}
		}
		return washableJkMaterialMap;
	}
	
	/**
	 * ウォッシャブルGILET素材名
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectWashableGlMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> washableGlMaterialMap = new HashMap<String,String>();
		//GL背裏地素材
		String wgBackLiningMateStkNo = orderForm.getOptionGiletWashableInfo().getWgBackLiningMateStkNo();
		String wgBackLiningMateName = orderForm.getOptionGiletWashableInfo().getWgBackLiningMateMap().get(orderForm.getOptionGiletWashableInfo().getWgBackLiningMate());
		//GL内側裏地素材
		String wgInsideLiningMateStkNo = orderForm.getOptionGiletWashableInfo().getWgInsideLiningMateStkNo();
		String wgInsideLiningMateName = orderForm.getOptionGiletWashableInfo().getWgInsideLiningMateMap().get(orderForm.getOptionGiletWashableInfo().getWgInsideLiningMate());
		//GLフロント釦
		String wgFrontBtnMateStkNo = orderForm.getOptionGiletWashableInfo().getWgFrontBtnMateStkNo();
		String wgFrontBtnMateName = orderForm.getOptionGiletWashableInfo().getWgFrontBtnMateMap().get(orderForm.getOptionGiletWashableInfo().getWgFrontBtnMate());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(wgBackLiningMateStkNo != null && wgBackLiningMateStkNo.equals(optionBranchDetailCode)) {
				washableGlMaterialMap.put("wgBackLiningMateStkNo",wgBackLiningMateName + " " + optionBranchDetailName);
			}
			if(wgInsideLiningMateStkNo != null && wgInsideLiningMateStkNo.equals(optionBranchDetailCode)) {
				washableGlMaterialMap.put("wgInsideLiningMateStkNo",wgInsideLiningMateName + " " + optionBranchDetailName);
			}
			if(wgFrontBtnMateStkNo != null && wgFrontBtnMateStkNo.equals(optionBranchDetailCode)) {
				washableGlMaterialMap.put("wgFrontBtnMateStkNo",wgFrontBtnMateName + " " + optionBranchDetailName);
			}
		}
		return washableGlMaterialMap;
	}
	
	/**
	 *ウォッシャブルPANTS素材名 
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectWashablePtMaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> washablePtMaterialMap = new HashMap<String,String>();
		//PT釦素材
		String wpBtnMateStkNo = orderForm.getOptionPantsWashableInfo().getWpBtnMateStkNo();
		String wpButtonName = orderForm.getOptionPantsWashableInfo().getWpButtonMap().get(orderForm.getOptionPantsWashableInfo().getWpButton());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(wpBtnMateStkNo != null && wpBtnMateStkNo.equals(optionBranchDetailCode)) {
				washablePtMaterialMap.put("wpBtnMateStkNo",wpButtonName + " " + optionBranchDetailName);
			}
		}
		return washablePtMaterialMap;
	}
	
	/**
	 * ウォッシャブル2PANTS素材名 
	 * @param mateList
	 * @param orderForm
	 * @return
	 */
	public Map<String, String> selectWashablePt2MaterialName(List<OptionBranchDetail> mateList,OrderForm orderForm) {
		Map<String,String> washablePt2MaterialMap = new HashMap<String,String>();
		//PT2釦素材
		String wp2BtnMateStkNo = orderForm.getOptionPants2WashableInfo().getWp2BtnMateStkNo();
		String wp2ButtonName = orderForm.getOptionPants2WashableInfo().getWp2ButtonMap().get(orderForm.getOptionPants2WashableInfo().getWp2Button());
		
		for(OptionBranchDetail mate : mateList) {
			String optionBranchDetailCode = mate.getOptionBranchDetailCode();
			String optionBranchDetailName = mate.getOptionBranchDetailName();
			if(wp2BtnMateStkNo != null && wp2BtnMateStkNo.equals(optionBranchDetailCode)) {
				washablePt2MaterialMap.put("wp2BtnMateStkNo",wp2ButtonName + " " + optionBranchDetailName);
			}
		}
		return washablePt2MaterialMap;
	}

	public void jacketAdjustFormDb(OrderForm orderForm, Order order) {
		orderForm.getAdjustJacketStandardInfo().setSizeNumber(order.getCorJkSize());
		orderForm.getAdjustJacketStandardInfo().setSizeFigure(order.getCorJkDrop());

		orderForm.getAdjustJacketStandardInfo().setCorJkBodySize(order.getCorJkBodylengthSize().toString());
		orderForm.getAdjustJacketStandardInfo().setCorJkBodyGross(order.getCorJkBodylengthGross().toString());
		orderForm.getAdjustJacketStandardInfo().setCorJkBodyCorrect(order.getCorJkBodylengthCorrect().toString());

		orderForm.getAdjustJacketStandardInfo().setCorJkWaistSize(order.getCorJkWaistSize().toString());
		orderForm.getAdjustJacketStandardInfo().setCorJkWaistGross(order.getCorJkWaistGross().toString());
		orderForm.getAdjustJacketStandardInfo().setCorJkWaistCorrect(order.getCorJkWaistCorrect().toString());

		orderForm.getAdjustJacketStandardInfo().setCorJkRightsleeveSize(order.getCorJkRightsleeveSize().toString());
		orderForm.getAdjustJacketStandardInfo().setCorJkRightsleeveGross(order.getCorJkRightsleeveGross().toString());
		orderForm.getAdjustJacketStandardInfo()
				.setCorJkRightsleeveCorrect(order.getCorJkRightsleeveCorrect().toString());

		orderForm.getAdjustJacketStandardInfo().setCorJkLeftsleeveSize(order.getCorJkLeftsleeveSize().toString());
		orderForm.getAdjustJacketStandardInfo().setCorJkLeftsleeveGross(order.getCorJkLeftsleeveGross().toString());
		orderForm.getAdjustJacketStandardInfo().setCorJkLeftsleeveCorrect(order.getCorJkLeftsleeveCorrect().toString());

		orderForm.getAdjustJacketStandardInfo().setCorJkShoulderPad(order.getCorJkShoulderpad());
		orderForm.getAdjustJacketStandardInfo().setCorJkFigureCorrect(order.getCorJkFigureCorrect());

		orderForm.getAdjustJacketStandardInfo().setCorJkStoreCorrectionMemo(order.getCorJkStoreCorrectionMemo());
	}

	public void pantsAdjustFormDb(OrderForm orderForm, Order order) {
		orderForm.getAdjustPantsStandardInfo().setSizeFigure(order.getCorPtDrop());
		orderForm.getAdjustPantsStandardInfo().setSizeNumber(order.getCorPtSize());

		orderForm.getAdjustPantsStandardInfo().setCorPtWaistSize(order.getCorPtWaistSize().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtWaistGross(order.getCorPtWaistGross().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtWaistCorrect(order.getCorPtWaistCorrect().toString());

		orderForm.getAdjustPantsStandardInfo().setCorPtThighSize(order.getCorPtThighwidthSize().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtThighGross(order.getCorPtThighwidthGross().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtThighCorrect(order.getCorPtThighwidthCorrect().toString());

		orderForm.getAdjustPantsStandardInfo().setCorPtHemwidthType(order.getCorPtHemwidthType());
		orderForm.getAdjustPantsStandardInfo().setCorPtHemwidthSize(order.getCorPtHemwidthSize().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtHemwidthGross(order.getCorPtHemwidthGross().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtHemwidthCorrect(order.getCorPtHemwidthCorrect().toString());

		orderForm.getAdjustPantsStandardInfo().setCorPtHipSize(order.getCorPtHipSize().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtHipGross(order.getCorPtHipGross().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtHipCorrect(order.getCorPtHipCorrect().toString());

		orderForm.getAdjustPantsStandardInfo().setCorPtRightinseamSize(order.getCorPtRightinseamSize().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtRightinseamGross(order.getCorPtRightinseamGross().toString());
		orderForm.getAdjustPantsStandardInfo()
				.setCorPtRightinseamCorrect(order.getCorPtRightinseamCorrect().toString());

		orderForm.getAdjustPantsStandardInfo().setCorPtLeftinseamSize(order.getCorPtLeftinseamSize().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtLeftinseamGross(order.getCorPtLeftinseamGross().toString());
		orderForm.getAdjustPantsStandardInfo().setCorPtLeftinseamCorrect(order.getCorPtLeftinseamCorrect().toString());

		orderForm.getAdjustPantsStandardInfo().setCorPtStoreCorrectionMemo(order.getCorPtStoreCorrectionMemo());
	}

	public void pants2AdjustFormDb(OrderForm orderForm, Order order) {
		orderForm.getAdjustPants2StandardInfo().setSizeFigure(order.getCorPtDrop());
		orderForm.getAdjustPants2StandardInfo().setSizeNumber(order.getCorPtSize());

		orderForm.getAdjustPants2StandardInfo().setCorPt2WaistSize(order.getCorPt2WaistSize().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2WaistGross(order.getCorPt2WaistGross().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2WaistCorrect(order.getCorPt2WaistCorrect().toString());

		orderForm.getAdjustPants2StandardInfo().setCorPt2ThighSize(order.getCorPt2ThighwidthSize().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2ThighGross(order.getCorPt2ThighwidthGross().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2ThighCorrect(order.getCorPt2ThighwidthCorrect().toString());

		orderForm.getAdjustPants2StandardInfo().setCorPt2HemwidthType(order.getCorPt2HemwidthType());
		orderForm.getAdjustPants2StandardInfo().setCorPt2HemwidthSize(order.getCorPt2HemwidthSize().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2HemwidthGross(order.getCorPt2HemwidthGross().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2HemwidthCorrect(order.getCorPt2HemwidthCorrect().toString());

		orderForm.getAdjustPants2StandardInfo().setCorPt2HipSize(order.getCorPt2HipSize().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2HipGross(order.getCorPt2HipGross().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2HipCorrect(order.getCorPt2HipCorrect().toString());

		orderForm.getAdjustPants2StandardInfo().setCorPt2RightinseamSize(order.getCorPt2RightinseamSize().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2RightinseamGross(order.getCorPt2RightinseamGross().toString());
		orderForm.getAdjustPants2StandardInfo()
				.setCorPt2RightinseamCorrect(order.getCorPt2RightinseamCorrect().toString());

		orderForm.getAdjustPants2StandardInfo().setCorPt2LeftinseamSize(order.getCorPt2LeftinseamSize().toString());
		orderForm.getAdjustPants2StandardInfo().setCorPt2LeftinseamGross(order.getCorPt2LeftinseamGross().toString());
		orderForm.getAdjustPants2StandardInfo()
				.setCorPt2LeftinseamCorrect(order.getCorPt2LeftinseamCorrect().toString());

		orderForm.getAdjustPants2StandardInfo().setCorPt2StoreCorrectionMemo(order.getCorPt2StoreCorrectionMemo());
		
	}

	public void giletAdjustFormDb(OrderForm orderForm, Order order) {
		orderForm.getAdjustGiletStandardInfo().setSizeFigure(order.getCorGlDrop());
		orderForm.getAdjustGiletStandardInfo().setSizeNumber(order.getCorGlSize());

		orderForm.getAdjustGiletStandardInfo().setCorGlBodySize(order.getCorGlBodylengthSize().toString());
		orderForm.getAdjustGiletStandardInfo().setCorGlBodyGross(order.getCorGlBodylengthGross().toString());
		orderForm.getAdjustGiletStandardInfo().setCorGlBodyCorrect(order.getCorGlBodylengthCorrect().toString());

		orderForm.getAdjustGiletStandardInfo().setCorGlBustSize(order.getCorGlBustSize().toString());
		orderForm.getAdjustGiletStandardInfo().setCorGlBustGross(order.getCorGlBustGross().toString());
		orderForm.getAdjustGiletStandardInfo().setCorGlBustCorrect(order.getCorGlBustCorrect().toString());

		orderForm.getAdjustGiletStandardInfo().setCorGlWaistSize(order.getCorGlWaistSize().toString());
		orderForm.getAdjustGiletStandardInfo().setCorGlWaistCorrect(order.getCorGlWaistGross().toString());
		orderForm.getAdjustGiletStandardInfo().setCorGlWaistGross(order.getCorGlWaistCorrect().toString());
	}

	public void shirtAdjustFormDb(OrderForm orderForm, Order order) {
		orderForm.getAdjustShirtStandardInfo().setCorStSize(order.getCorStSize());

		orderForm.getAdjustShirtStandardInfo().setCorStNeckSize(order.getCorStNeckSize().toString());
		orderForm.getAdjustShirtStandardInfo().setCorStNeckGross(order.getCorStNeckGross().toString());
		orderForm.getAdjustShirtStandardInfo().setCorStNeckCorrect(order.getCorStNeckCorrect().toString());

		orderForm.getAdjustShirtStandardInfo().setCorStBodylengthSize(order.getCorStBodylengthSize().toString());
		orderForm.getAdjustShirtStandardInfo().setCorStBodylengthGross(order.getCorStBodylengthGross().toString());
		orderForm.getAdjustShirtStandardInfo().setCorStBodylengthCorrect(order.getCorStBodylengthCorrect().toString());

		orderForm.getAdjustShirtStandardInfo().setCorStRightsleeveSize(order.getCorStRightsleeveSize().toString());
		orderForm.getAdjustShirtStandardInfo().setCorStRightsleeveGross(order.getCorStRightsleeveGross().toString());
		orderForm.getAdjustShirtStandardInfo()
				.setCorStRightsleeveCorrect(order.getCorStRightsleeveCorrect().toString());

		orderForm.getAdjustShirtStandardInfo().setCorStLeftsleeveSize(order.getCorStLeftsleeveSize().toString());
		orderForm.getAdjustShirtStandardInfo().setCorStLeftsleeveGross(order.getCorStLeftsleeveGross().toString());
		orderForm.getAdjustShirtStandardInfo().setCorStLeftsleeveCorrect(order.getCorStLeftsleeveCorrect().toString());

		orderForm.getAdjustShirtStandardInfo().setCorStBackdartsPackSize(order.getCorStBackdartsPackSize().toString());
		orderForm.getAdjustShirtStandardInfo()
				.setCorStBackdartsPackGross(order.getCorStBackdartsPackGross().toString());
		orderForm.getAdjustShirtStandardInfo()
				.setCorStBackdartsPackCorrect(order.getCorStBackdartsPackCorrect().toString());

		orderForm.getAdjustShirtStandardInfo()
				.setCorStBackdartsUnpackSize(order.getCorStBackdartsUnpackSize().toString());
		orderForm.getAdjustShirtStandardInfo()
				.setCorStBackdartsUnpackGross(order.getCorStBackdartsUnpackGross().toString());
		orderForm.getAdjustShirtStandardInfo()
				.setCorStBackdartsUnpackCorrect(order.getCorStBackdartsUnpackCorrect().toString());

		orderForm.getAdjustShirtStandardInfo()
				.setCorStRightcuffsSurroundingSize(order.getCorStRightcuffsSurroundingSize().toString());
		orderForm.getAdjustShirtStandardInfo()
				.setCorStRightcuffsSurroundingGross(order.getCorStRightcuffsSurroundingGross().toString());
		orderForm.getAdjustShirtStandardInfo()
				.setCorStRightcuffsSurroundingCorrect(order.getCorStRightcuffsSurroundingCorrect().toString());

		orderForm.getAdjustShirtStandardInfo()
				.setCorStLeftcuffsSurroundingSize(order.getCorStLeftcuffsSurroundingSize().toString());
		orderForm.getAdjustShirtStandardInfo()
				.setCorStLeftcuffsSurroundingGross(order.getCorStLeftcuffsSurroundingGross().toString());
		orderForm.getAdjustShirtStandardInfo()
				.setCorStLeftcuffsSurroundingCorrect(order.getCorStLeftcuffsSurroundingCorrect().toString());
	}

	public void coatAdjustFormDb(OrderForm orderForm, Order order) {
		orderForm.getAdjustCoatStandardInfo().setCorCtSize(order.getCorCtSize());

		orderForm.getAdjustCoatStandardInfo().setCorCtBodylengthSize(order.getCorCtBodylengthSize().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtBodylengthGross(order.getCorCtBodylengthGross().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtBodylengthCorrect(order.getCorCtBodylengthCorrect().toString());

		orderForm.getAdjustCoatStandardInfo().setCorCtWaistSize(order.getCorCtWaistSize().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtWaistGross(order.getCorCtWaistGross().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtWaistCorrect(order.getCorCtWaistCorrect().toString());

		orderForm.getAdjustCoatStandardInfo().setCorCtRightsleeveSize(order.getCorCtRightsleeveSize().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtRightsleeveGross(order.getCorCtRightsleeveGross().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtRightsleeveCorrect(order.getCorCtRightsleeveCorrect().toString());

		orderForm.getAdjustCoatStandardInfo().setCorCtLeftsleeveSize(order.getCorCtLeftsleeveSize().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtLeftsleeveGross(order.getCorCtLeftsleeveGross().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtLeftsleeveCorrect(order.getCorCtLeftsleeveCorrect().toString());

		orderForm.getAdjustCoatStandardInfo().setCorCtVenthightSize(order.getCorCtVenthightSize().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtVenthightGross(order.getCorCtVenthightGross().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtVenthightCorrect(order.getCorCtVenthightCorrect().toString());

		orderForm.getAdjustCoatStandardInfo().setCorCtPktposSize(order.getCorCtPktposSize().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtPktposGross(order.getCorCtPktposGross().toString());
		orderForm.getAdjustCoatStandardInfo().setCorCtPktposCorrect(order.getCorCtPktposCorrect().toString());
	}

	public void setCustomerMessageInfo(HttpServletRequest req, OrderForm orderForm) {
		CustomerMessageInfo customerMessageInfo = new CustomerMessageInfo();
		Order order = (Order) req.getAttribute("order");
		customerMessageInfo.setOrderId(order.getOrderId());
		customerMessageInfo.setCustCd(order.getCustCd());
		
		customerMessageInfo.setCustIsDeliverShortning(order.getCustIsDeliverShortning());
		
		customerMessageInfo.setCustIsEarlyDiscount(order.getCustIsEarlyDiscount());
		
		customerMessageInfo.setCustStaff(order.getCustStaff());
		
		customerMessageInfo.setCustType(order.getCustType());
		
		customerMessageInfo.setCustShippingDestination(order.getCustShippingDestination());
		
		customerMessageInfo.setCustShippingDestnationOtherstore(order.getCustShippingDestnationOtherstore());
		
		orderForm.setCustomerMessageInfo(customerMessageInfo);
	}
	
	/**
	 * 
	 * @param price
	 * @return
	 */
	public String formatPrice(String price) {  
		  
        price = new StringBuffer(price).reverse().toString();
        String str2 = "";  
        int size = (price.length() % 3 == 0) ? (price.length() / 3) : (price.length() / 3 + 1);
        if (price.length() < 3) { 
            str2 = price;  
        } else {  
            for (int i = 0; i < size - 1; i++) {// 前n-1段  
                str2 += price.substring(i * 3, i * 3 + 3) + ",";  
            }  
            for (int i = size - 1; i < size; i++) {// 第n段  
                str2 += price.substring(i * 3, price.length());  
            }  
        }  
        str2 = new StringBuffer(str2).reverse().toString();// 再将字符串颠倒顺序  
        return str2;
    }  
	
	/**
	 * オーダー内容確認画面標準のPANTS上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> standardPantsUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// PANTSのsubItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS.getKey();
		//PANTSのmodelCodeの取得
		String modelCode = orderForm.getOptionPantsStandardInfo().getOpPantsModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS.getValue();
		
		Map<String,String> pantsUpperPriceMap = new HashMap<String,String>();
				
		PantsCoOptionStandardUpperPriceEnum[] pantsCoOptionStandardUpperPriceEnum = PantsCoOptionStandardUpperPriceEnum.values();
		
		for(PantsCoOptionStandardUpperPriceEnum PantsCoOptionStandardUpperPrice : pantsCoOptionStandardUpperPriceEnum) {
			String optionCode = PantsCoOptionStandardUpperPrice.getKey();
			String optionBranchCode = PantsCoOptionStandardUpperPrice.getValueOne();
			String optionBranchDetailCode = PantsCoOptionStandardUpperPrice.getValueTwo();
			String mapOfKey = PantsCoOptionStandardUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPantsStandardInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
							pantsUpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							pantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
						}
						break;
					}
					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
							pantsUpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							pantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
						}
						break;
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return pantsUpperPriceMap;
	}
	
	/**
	 * オーダー内容確認画面標準の2PANTS上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> standardPants2UpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// 2PANTSのsubItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_PANTS2.getKey();
		//2PANTSのmodelCodeの取得
		String modelCode = orderForm.getOptionPants2StandardInfo().getOp2PantsModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPants2StandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_PANTS2.getValue();
		
		Map<String,String> pants2UpperPriceMap = new HashMap<String,String>();
				
		Pants2CoOptionStandardUpperPriceEnum[] pants2CoOptionStandardUpperPriceEnum = Pants2CoOptionStandardUpperPriceEnum.values();
		
		for(Pants2CoOptionStandardUpperPriceEnum pants2CoOptionStandardUpperPrice : pants2CoOptionStandardUpperPriceEnum) {
			String optionCode = pants2CoOptionStandardUpperPrice.getKey();
			String optionBranchCode = pants2CoOptionStandardUpperPrice.getValueOne();
			String optionBranchDetailCode = pants2CoOptionStandardUpperPrice.getValueTwo();
			String mapOfKey = pants2CoOptionStandardUpperPrice.getValueTwo();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2StandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPants2StandardInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
							pants2UpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							pants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
						}
						break;
					}
					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
							pants2UpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							pants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
						}
						break;
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return pants2UpperPriceMap;
	}
	
	/**
	 * オーダー内容確認画面標準のjacket上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> standardJacketUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		
		Map<String,String> jacketUpperPriceMap = new HashMap<String,String>();
		
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// JACKETのsubItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_JACKET.getKey();
		//JACKETのmodelCodeの取得
		String modelCode = orderForm.getOptionJacketStandardInfo().getOjJacketModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_JACKET.getValue();
		//フロント釦数
		String ojFrontBtnCnt = orderForm.getOptionJacketStandardInfo().getOjFrontBtnCnt();
		//0000105(ダブル6つボタン)
		String ojFrontBtnCntdoubleSixButton = "0000105";
		//0000106(ダブル4つボタン)
		String ojFrontBtnCntdoubleFourButton = "0000106";
				
		JacketCoOptionStandardUpperPriceEnum[] jacketCoOptionStandardUpperPriceEnum = JacketCoOptionStandardUpperPriceEnum.values();
		
		for(JacketCoOptionStandardUpperPriceEnum jacketCoOptionStandardUpperPrice : jacketCoOptionStandardUpperPriceEnum) {
			String optionCode = jacketCoOptionStandardUpperPrice.getKey();
			String optionBranchCode = jacketCoOptionStandardUpperPrice.getValueOne();
			String OptionBranchDetailCode = jacketCoOptionStandardUpperPrice.getValueTwo();
			String mapOfKey = jacketCoOptionStandardUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, OptionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketStandardInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(ojFrontBtnCntdoubleSixButton.equals(ojFrontBtnCnt) || ojFrontBtnCntdoubleFourButton.equals(ojFrontBtnCnt)) {
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
								jacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								jacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
								jacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								jacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
							}
							break;
						}
					}
					else{
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
								jacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								jacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
								jacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								jacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
							}
							break;
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return jacketUpperPriceMap;
	}
	
	/**
	 * オーダー内容確認画面標準のGILET上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> standardGiletUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// GILETのsubItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_GILET.getKey();
		//GILETのmodelCodeの取得
		String modelCode = orderForm.getOptionGiletStandardInfo().getOgGiletModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_GILET.getValue();
		//GILETモデル
		String OgGiletModel = orderForm.getOptionGiletStandardInfo().getOgGiletModelMap().get(orderForm.getOptionGiletStandardInfo().getOgGiletModel());
		//BS01-D
		String bs01dModel = "BS01-D";
		//ET15-D
		String et15dModel = "ET15-D";
		
		Map<String,String> giletUpperPriceMap = new HashMap<String,String>();
				
		GiletCoOptionStandardNextUpperPriceEnum[] giletCoOptionStandardNextUpperPriceEnum = GiletCoOptionStandardNextUpperPriceEnum.values();
		
		for(GiletCoOptionStandardNextUpperPriceEnum giletCoOptionStandardNextUpperPrice : giletCoOptionStandardNextUpperPriceEnum) {
			String optionCode = giletCoOptionStandardNextUpperPrice.getKey();
			String optionBranchCode = giletCoOptionStandardNextUpperPrice.getValueOne();
			String optionBranchDetailCode = giletCoOptionStandardNextUpperPrice.getValueTwo();
			String mapOfKey = giletCoOptionStandardNextUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletStandardInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo !=null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(bs01dModel.equals(OgGiletModel) || et15dModel.equals(OgGiletModel)) {
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
								giletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								giletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
								giletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								giletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
							}
							break;
						}
					}
					else{
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
								giletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								giletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
								giletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								giletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
							}
							break;
						}
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return giletUpperPriceMap;
	}
	
	/**
	 * オーダー内容確認画面標準のCOAT上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> standardCoatUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// COATのsubItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_COAT.getKey();
		//COATのmodelCodeの取得
		String modelCode = orderForm.getOptionCoatStandardInfo().getCoatModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionCoatStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_COAT.getValue();
		//DoubleChester(ダブルチェスター)
		String DoubleChester = "DoubleChester";
		//DoublePolo(ダブルポロ)
		String DoublePolo = "DoublePolo";
		
		Map<String,String> coatUpperPriceMap = new HashMap<String,String>();
				
		CoatCoOptionStandardUpperPriceEnum[] coatCoOptionStandardUpperPriceEnum = CoatCoOptionStandardUpperPriceEnum.values();
		
		for(CoatCoOptionStandardUpperPriceEnum coatCoOptionStandardUpperPrice : coatCoOptionStandardUpperPriceEnum) {
			String optionCode = coatCoOptionStandardUpperPrice.getKey();
			String optionBranchCode = coatCoOptionStandardUpperPrice.getValueOne();
			String optionBranchDetailCode = coatCoOptionStandardUpperPrice.getValueTwo();
			String mapOfKey = coatCoOptionStandardUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionCoatStandardInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionCoatStandardInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(DoubleChester.equals(modelCode) || DoublePolo.equals(modelCode)) {
						if(priceKeyCode.equals(orderCodePrice.getOrderBranchDoublePrice())) {
							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
								coatUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								coatUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
								coatUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								coatUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
							}
							break;
						}
					}
					else {
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
								coatUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								coatUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
								coatUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								coatUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
							}
							break;
						}
						
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		return coatUpperPriceMap;
	}

	public void jacketDefaultValueFromDb(OrderForm orderForm, Order orderJK) {
		// 標準
		OptionJacketStandardInfo optionJacketStandardInfo = orderForm.getOptionJacketStandardInfo();
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
		optionJacketStandardInfo.setOjSleeveBtnType(orderJK.getJkSleeveBtnType());
		optionJacketStandardInfo.setOjSleeveBtnCnt(String.valueOf(orderJK.getJkSleeveBtnNumber()));
		optionJacketStandardInfo.setOjCuffSpec(orderJK.getJkCuffCd());
		optionJacketStandardInfo.setOjInsidePktChange(orderJK.getJkInnerPktType());
		optionJacketStandardInfo.setOjBreastInnerPkt(orderJK.getJkRightInnerPktTypeCd());
		optionJacketStandardInfo.setOjStitch(orderJK.getJkStitchTypeCd());
		optionJacketStandardInfo.setOjStitchModify(orderJK.getJkStitchPlcType());
		optionJacketStandardInfo.setOjDStitchModify(orderJK.getJkDblstitchPlcType());
		optionJacketStandardInfo.setOjAmfColor(orderJK.getJkAmfColorType());
		optionJacketStandardInfo.setOjBhColor(orderJK.getJkBtnholeColorType());
		optionJacketStandardInfo.setOjByColor(orderJK.getJkBtnthreadColorType());
		optionJacketStandardInfo.setOjVentSpec(orderJK.getJkVentCd());
		optionJacketStandardInfo.setOjBodyBackMate(orderJK.getJkInnerBodyClothType());
		optionJacketStandardInfo.setOjCuffBackMate(orderJK.getJkInnerSleeveClothType());
		optionJacketStandardInfo.setOjBtnMate(orderJK.getJkBtnMaterialType());
		optionJacketStandardInfo.setOjShapeMemory(orderJK.getJkShapeMemoryCd());

		// タキシード
		OptionJacketTuxedoInfo optionJacketTuxedoInfo = orderForm.getOptionJacketTuxedoInfo();
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
		optionJacketTuxedoInfo.setTjSleeveBtnType(orderJK.getJkSleeveBtnType());
		optionJacketTuxedoInfo.setTjSleeveBtnCnt(String.valueOf(orderJK.getJkSleeveBtnNumber()));
		optionJacketTuxedoInfo.setTjCuffSpec(orderJK.getJkCuffCd());
		optionJacketTuxedoInfo.setTjInsidePktChange(orderJK.getJkInnerPktType());
		optionJacketTuxedoInfo.setTjBreastInnerPkt(orderJK.getJkRightInnerPktTypeCd());
		optionJacketTuxedoInfo.setTjStitch(orderJK.getJkStitchTypeCd());
		optionJacketTuxedoInfo.setTjBhColor(orderJK.getJkBtnholeColorType());
		optionJacketTuxedoInfo.setTjByColor(orderJK.getJkBtnthreadColorType());
		optionJacketTuxedoInfo.setTjVentSpec(orderJK.getJkVentCd());
		optionJacketTuxedoInfo.setTjBodyBackMate(orderJK.getJkInnerBodyClothType());
		optionJacketTuxedoInfo.setTjCuffBackMate(orderJK.getJkInnerSleeveClothType());
		optionJacketTuxedoInfo.setTjBtnMate(orderJK.getJkBtnMaterialType());
		optionJacketTuxedoInfo.setTjShapeMemory(orderJK.getJkShapeMemoryCd());

		// ウォッシャブル
		OptionJacketWashableInfo optionJacketWashableInfo = orderForm.getOptionJacketWashableInfo();
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
		optionJacketWashableInfo.setWjSleeveBtnType(orderJK.getJkSleeveBtnType());
		optionJacketWashableInfo.setWjSleeveBtnCnt(String.valueOf(orderJK.getJkSleeveBtnNumber()));
		optionJacketWashableInfo.setWjCuffSpec(orderJK.getJkCuffCd());
		optionJacketWashableInfo.setWjInsidePktChange(orderJK.getJkInnerPktType());
		optionJacketWashableInfo.setWjBreastInnerPkt(orderJK.getJkRightInnerPktTypeCd());
		optionJacketWashableInfo.setWjStitch(orderJK.getJkStitchTypeCd());
		optionJacketWashableInfo.setWjStitchModify(orderJK.getJkStitchPlcType());
		optionJacketWashableInfo.setWjDStitchModify(orderJK.getJkDblstitchPlcType());
		optionJacketWashableInfo.setWjAmfColor(orderJK.getJkAmfColorType());
		optionJacketWashableInfo.setWjBhColor(orderJK.getJkBtnholeColorType());
		optionJacketWashableInfo.setWjByColor(orderJK.getJkBtnthreadColorType());
		optionJacketWashableInfo.setWjVentSpec(orderJK.getJkVentCd());
		optionJacketWashableInfo.setWjBodyBackMate(orderJK.getJkInnerBodyClothType());
		optionJacketWashableInfo.setWjCuffBackMate(orderJK.getJkInnerSleeveClothType());
		optionJacketWashableInfo.setWjBtnMate(orderJK.getJkBtnMaterialType());
		optionJacketWashableInfo.setWjShapeMemory(orderJK.getJkShapeMemoryCd());
	}
	
	/**
	 * オーダー内容確認画面標準のSHIRT上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> standardShirtUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// SHIRTのsubItemCodeの取得
		String subItemCode = ItemClassStandardEnum.ITEM_CODE_SHIRTS.getKey();
		//SHIRTのmodelCodeの取得
		String modelCode = orderForm.getOptionShirtStandardInfo().getOsShirtModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionShirtStandardInfoの取得
		String className = ItemClassStandardEnum.ITEM_CODE_SHIRTS.getValue();
		
		Map<String,String> shirtUpperPriceMap = new HashMap<String,String>();
				
		ShirtCoOptionStandardUpperPriceEnum[] shirtCoOptionStandardUpperPriceEnum = ShirtCoOptionStandardUpperPriceEnum.values();
		
		for(ShirtCoOptionStandardUpperPriceEnum shirtCoOptionStandardUpperPrice : shirtCoOptionStandardUpperPriceEnum) {
			String optionCode = shirtCoOptionStandardUpperPrice.getKey();
			String optionBranchCode = shirtCoOptionStandardUpperPrice.getValueOne();
			String mapOfKey = shirtCoOptionStandardUpperPrice.getValueTwo();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Object[] args = {};
				Object resultOne = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionShirtStandardInfo(), args);
				}
				
				String priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
							shirtUpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							shirtUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
						}
						break;
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return shirtUpperPriceMap;
	}
	
	/**
	 * オーダー内容確認画面タキシードのjacket上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> tuxedoJacketUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		
		Map<String,String> tuxedoJacketUpperPriceMap = new HashMap<String,String>();
		
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// JACKETのsubItemCodeの取得
		String subItemCode = ItemClassTuxedoEnum.ITEM_CODE_JACKET.getKey();
		//JACKETのmodelCodeの取得
		String modelCode = orderForm.getOptionJacketTuxedoInfo().getTjJacketModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
		String className = ItemClassTuxedoEnum.ITEM_CODE_JACKET.getValue();
		//フロント釦数
		String tjFrontBtnCnt = orderForm.getOptionJacketTuxedoInfo().getTjFrontBtnCnt();
		//0000105(ダブル6つボタン)
		String tjFrontBtnCntdoubleSixButton = "0000105";
		//0000106(ダブル4つボタン)
		String tjFrontBtnCntdoubleFourButton = "0000106";
				
		JacketCoOptionTuxedoUpperPriceEnum[] jacketCoOptionTuxedoUpperPriceEnum = JacketCoOptionTuxedoUpperPriceEnum.values();
		
		for(JacketCoOptionTuxedoUpperPriceEnum jacketCoOptionTuxedoUpperPrice : jacketCoOptionTuxedoUpperPriceEnum) {
			String optionCode = jacketCoOptionTuxedoUpperPrice.getKey();
			String optionBranchCode = jacketCoOptionTuxedoUpperPrice.getValueOne();
			String optionBranchDetailCode = jacketCoOptionTuxedoUpperPrice.getValueTwo();
			String mapOfKey = jacketCoOptionTuxedoUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketTuxedoInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketTuxedoInfo(), argsT);
				}
				
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(tjFrontBtnCntdoubleSixButton.equals(tjFrontBtnCnt) || tjFrontBtnCntdoubleFourButton.equals(tjFrontBtnCnt)) {
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
								tuxedoJacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								tuxedoJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())){
							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
								tuxedoJacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								tuxedoJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
							}
							break;
						}
					}
					else{
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
								tuxedoJacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								tuxedoJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())){
							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
								tuxedoJacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								tuxedoJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
							}
							break;
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return tuxedoJacketUpperPriceMap;
	}
	
	
	/**
	 * オーダー内容確認画面タキシードのGILET上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> tuxedoGiletUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// GILETのsubItemCodeの取得
		String subItemCode = ItemClassTuxedoEnum.ITEM_CODE_GILET.getKey();
		//GILETのmodelCodeの取得
		String modelCode = orderForm.getOptionGiletTuxedoInfo().getTgGiletModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
		String className = ItemClassTuxedoEnum.ITEM_CODE_GILET.getValue();
		//GILETモデル
		String tgGiletModel = orderForm.getOptionGiletTuxedoInfo().getTgGiletModelMap().get(orderForm.getOptionGiletTuxedoInfo().getTgGiletModel());
		//BS01-D
		String bs01dModel = "BS01-D";
		//ET15-D
		String et15dModel = "ET15-D";
		
		Map<String,String> tuxedoGiletUpperPriceMap = new HashMap<String,String>();
				
		GiletCoOptionTuxedoUpperPriceEnum[] giletCoOptionTuxedoUpperPriceEnum = GiletCoOptionTuxedoUpperPriceEnum.values();
		
		for(GiletCoOptionTuxedoUpperPriceEnum giletCoOptionTuxedoUpperPrice : giletCoOptionTuxedoUpperPriceEnum) {
			String optionCode = giletCoOptionTuxedoUpperPrice.getKey();
			String optionBranchCode = giletCoOptionTuxedoUpperPrice.getValueOne();
			String optionBranchDetailCode = giletCoOptionTuxedoUpperPrice.getValueTwo();
			String mapOfKey = giletCoOptionTuxedoUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletTuxedoInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletTuxedoInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(bs01dModel.equals(tgGiletModel) || et15dModel.equals(tgGiletModel)) {
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
								tuxedoGiletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								tuxedoGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
								tuxedoGiletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								tuxedoGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
							}
							break;
						}
					}
					else{
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
								tuxedoGiletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								tuxedoGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
								tuxedoGiletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								tuxedoGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
							}
							break;
						}
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return tuxedoGiletUpperPriceMap;
	}
	public void pants2DefaultValue(OrderForm orderForm) {
		//標準
		OptionPants2StandardInfo optionPants2StandardInfo = orderForm.getOptionPants2StandardInfo();
		//PANTSモデル
		optionPants2StandardInfo.setOp2PantsModel("");
		//タック
		optionPants2StandardInfo.setOp2Tack(OptionCodeKeys.PT2_0000101);
		//膝裏
		optionPants2StandardInfo.setOp2KneeBack(OptionCodeKeys.PT2_0000201);
		//膝裏素材
		optionPants2StandardInfo.setOp2KneeBackMate(OptionCodeKeys.PT2_0000301);
		//フロント仕様
		optionPants2StandardInfo.setOp2FrontSpec(OptionCodeKeys.PT2_0000401);
		 //パンチェリーナ
		optionPants2StandardInfo.setOp2Pancherina(OptionCodeKeys.PT2_0000501);
		//アジャスター仕様
		optionPants2StandardInfo.setOp2Adjuster(OptionCodeKeys.PT2_0000601);
		//ベルトループ
		optionPants2StandardInfo.setOp2BeltLoop(OptionCodeKeys.PT2_0000701);
		//ピンループ
		optionPants2StandardInfo.setOp2PinLoop(OptionCodeKeys.PT2_0000901);
		//脇ポケット
		optionPants2StandardInfo.setOp2SidePkt(OptionCodeKeys.PT2_0001002);
		//忍びポケット
		optionPants2StandardInfo.setOp2SinobiPkt(OptionCodeKeys.PT2_0001104);
		//コインポケット
		optionPants2StandardInfo.setOp2CoinPkt(OptionCodeKeys.PT2_0001201);
		//フラップ付コインポケット
		optionPants2StandardInfo.setOp2FlapCoinPkt(OptionCodeKeys.PT2_0001301);
		//上前ピスポケット
		optionPants2StandardInfo.setOp2PisPktUf(OptionCodeKeys.PT2_0001401);
		//下前ピスポケット
		optionPants2StandardInfo.setOp2PisPktDf(OptionCodeKeys.PT2_0001501);
		//Vカット
		optionPants2StandardInfo.setOp2VCut(OptionCodeKeys.PT2_0001602);
		//裾上げ
		optionPants2StandardInfo.setOp2HemUp(OptionCodeKeys.PT2_0001701);
		//ダブル幅
		optionPants2StandardInfo.setOp2DoubleWide(OptionCodeKeys.PT2_4);
		//ステッチ種類
		optionPants2StandardInfo.setOp2Stitch(OptionCodeKeys.PT2_0001904);
		//ステッチ箇所変更
		optionPants2StandardInfo.setOp2StitchModify(OptionCodeKeys.PT2_0002001);
		//ダブルステッチ
		optionPants2StandardInfo.setOp2DStitch(OptionCodeKeys.PT2_0002201);
		//AMF色指定
		optionPants2StandardInfo.setOp2AmfColor(OptionCodeKeys.PT2_0002401);
		//ボタンホール色指定
		optionPants2StandardInfo.setOp2BhColor(OptionCodeKeys.PT2_0002701);
		//ボタン付け糸指定
		optionPants2StandardInfo.setOp2ByColor(OptionCodeKeys.PT2_0003001);
		//釦素材
		optionPants2StandardInfo.setOp2Button(OptionCodeKeys.PT2_3000800);
		//サスペンダー釦
		optionPants2StandardInfo.setOp2SuspenderBtn(OptionCodeKeys.PT2_0003501);
		//シック大（股補強）
		optionPants2StandardInfo.setOp2Thick(OptionCodeKeys.PT2_0004101);
		//エイト（滑り止め）
		optionPants2StandardInfo.setOp2Eight(OptionCodeKeys.PT2_0003601);
		//形状記憶
		optionPants2StandardInfo.setOp2ShapeMemory(OptionCodeKeys.PT2_0003701);
		
		
		//タキシード
		OptionPants2TuxedoInfo optionPants2TuxedoInfo = orderForm.getOptionPants2TuxedoInfo();
		//PANTSモデル
		optionPants2TuxedoInfo.setTp2PantsModel("");
		//タック
		optionPants2TuxedoInfo.setTp2Tack(OptionCodeKeys.PT2_0000101);
		//膝裏
		optionPants2TuxedoInfo.setTp2KneeBack(OptionCodeKeys.PT2_0000201);
		//膝裏素材
		optionPants2TuxedoInfo.setTp2KneeBackMate(OptionCodeKeys.PT2_0000301);
		//フロント仕様
		optionPants2TuxedoInfo.setTp2FrontSpec(OptionCodeKeys.PT2_0000401);
		 //パンチェリーナ
		optionPants2TuxedoInfo.setTp2Pancherina(OptionCodeKeys.PT2_0000501);
		//アジャスター仕様
		optionPants2TuxedoInfo.setTp2Adjuster(OptionCodeKeys.PT2_0000601);
		//ベルトループ
		optionPants2TuxedoInfo.setTp2BeltLoop(OptionCodeKeys.PT2_0000701);
		//ピンループ
		optionPants2TuxedoInfo.setTp2PinLoop(OptionCodeKeys.PT2_0000901);
		//脇ポケット
		optionPants2TuxedoInfo.setTp2SidePkt(OptionCodeKeys.PT2_0001002);
		//忍びポケット
		optionPants2TuxedoInfo.setTp2SinobiPkt(OptionCodeKeys.PT2_0001104);
		//コインポケット
		optionPants2TuxedoInfo.setTp2CoinPkt(OptionCodeKeys.PT2_0001201);
		//フラップ付コインポケット
		optionPants2TuxedoInfo.setTp2FlapCoinPkt(OptionCodeKeys.PT2_0001301);
		//上前ピスポケット
		optionPants2TuxedoInfo.setTp2PisPktUf(OptionCodeKeys.PT2_0001401);
		//下前ピスポケット
		optionPants2TuxedoInfo.setTp2PisPktDf(OptionCodeKeys.PT2_0001501);
		//Vカット
		optionPants2TuxedoInfo.setTp2VCut(OptionCodeKeys.PT2_0001602);
		//裾上げ
		optionPants2TuxedoInfo.setTp2HemUp(OptionCodeKeys.PT2_0001701);
		//ダブル幅
		optionPants2TuxedoInfo.setTp2DoubleWide(OptionCodeKeys.PT2_4);
		//ステッチ種類
		optionPants2TuxedoInfo.setTp2Stitch(OptionCodeKeys.PT2_0001903);
		//ボタンホール色指定
		optionPants2TuxedoInfo.setTp2BhColor(OptionCodeKeys.PT2_0002701);
		//ボタン付け糸指定
		optionPants2TuxedoInfo.setTp2ByColor(OptionCodeKeys.PT2_0003001);
		//釦素材
		optionPants2TuxedoInfo.setTp2Button(OptionCodeKeys.PT2_3000800);
		//サスペンダー釦
		optionPants2TuxedoInfo.setTp2SuspenderBtn(OptionCodeKeys.PT2_0003501);
		//シック大（股補強）
		optionPants2TuxedoInfo.setTp2Thick(OptionCodeKeys.PT2_0004101);
		//エイト（滑り止め）
		optionPants2TuxedoInfo.setTp2Eight(OptionCodeKeys.PT2_0003601);
		//形状記憶
		optionPants2TuxedoInfo.setTp2ShapeMemory(OptionCodeKeys.PT2_0003701);
		//側章
		optionPants2TuxedoInfo.setTp2SideStripe(OptionCodeKeys.PT2_0003902);
		//側章幅
		optionPants2TuxedoInfo.setTp2SideStripeWidth(OptionCodeKeys.PT2_0004001);
		
		//ウォッシャブル
		OptionPants2WashableInfo optionPants2WashableInfo = orderForm.getOptionPants2WashableInfo();
		//PANTSモデル
		optionPants2WashableInfo.setWp2PantsModel("");
		//タック
		optionPants2WashableInfo.setWp2Tack(OptionCodeKeys.PT2_0000101);
		//膝裏
		optionPants2WashableInfo.setWp2KneeBack(OptionCodeKeys.PT2_0000201);
		//膝裏素材
		optionPants2WashableInfo.setWp2KneeBackMate(OptionCodeKeys.PT2_0000301);
		//フロント仕様
		optionPants2WashableInfo.setWp2FrontSpec(OptionCodeKeys.PT2_0000401);
		 //パンチェリーナ
		optionPants2WashableInfo.setWp2Pancherina(OptionCodeKeys.PT2_0000501);
		//アジャスター仕様
		optionPants2WashableInfo.setWp2Adjuster(OptionCodeKeys.PT2_0000601);
		//ベルトループ
		optionPants2WashableInfo.setWp2BeltLoop(OptionCodeKeys.PT2_0000701);
		//ピンループ
		optionPants2WashableInfo.setWp2PinLoop(OptionCodeKeys.PT2_0000901);
		//脇ポケット
		optionPants2WashableInfo.setWp2SidePkt(OptionCodeKeys.PT2_0001002);
		//忍びポケット
		optionPants2WashableInfo.setWp2SinobiPkt(OptionCodeKeys.PT2_0001104);
		//コインポケット
		optionPants2WashableInfo.setWp2CoinPkt(OptionCodeKeys.PT2_0001201);
		//フラップ付コインポケット
		optionPants2WashableInfo.setWp2FlapCoinPkt(OptionCodeKeys.PT2_0001301);
		//上前ピスポケット
		optionPants2WashableInfo.setWp2PisPktUf(OptionCodeKeys.PT2_0001401);
		//下前ピスポケット
		optionPants2WashableInfo.setWp2PisPktDf(OptionCodeKeys.PT2_0001501);
		//Vカット
		optionPants2WashableInfo.setWp2VCut(OptionCodeKeys.PT2_0001602);
		//裾上げ
		optionPants2WashableInfo.setWp2HemUp(OptionCodeKeys.PT2_0001701);
		//ダブル幅
		optionPants2WashableInfo.setWp2DoubleWide(OptionCodeKeys.PT2_4);
		//ステッチ種類
		optionPants2WashableInfo.setWp2Stitch(OptionCodeKeys.PT2_0001901);
		//ステッチ箇所変更
		optionPants2WashableInfo.setWp2StitchModify(OptionCodeKeys.PT2_0002001);
		//ダブルステッチ
		optionPants2WashableInfo.setWp2DStitch(OptionCodeKeys.PT2_0002201);
		//AMF色指定
		optionPants2WashableInfo.setWp2AmfColor(OptionCodeKeys.PT2_0002401);
		//ボタンホール色指定
		optionPants2WashableInfo.setWp2BhColor(OptionCodeKeys.PT2_0002701);
		//ボタン付け糸指定
		optionPants2WashableInfo.setWp2ByColor(OptionCodeKeys.PT2_0003001);
		//釦素材
		optionPants2WashableInfo.setWp2Button(OptionCodeKeys.PT2_3000800);
		//サスペンダー釦
		optionPants2WashableInfo.setWp2SuspenderBtn(OptionCodeKeys.PT2_0003501);
		//シック大（股補強）
		optionPants2WashableInfo.setWp2Thick(OptionCodeKeys.PT2_0004101);
		//エイト（滑り止め）
		optionPants2WashableInfo.setWp2Eight(OptionCodeKeys.PT2_0003601);
		//形状記憶
		optionPants2WashableInfo.setWp2ShapeMemory(OptionCodeKeys.PT2_0003701);
	}
	
	/**
	 * オーダー内容確認画面タキシードのPANTS上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> tuxedoPantsUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// PANTSのsubItemCodeの取得
		String subItemCode = ItemClassTuxedoEnum.ITEM_CODE_PANTS.getKey();
		//PANTSのmodelCodeの取得
		String modelCode = orderForm.getOptionPantsTuxedoInfo().getTpPantsModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
		String className = ItemClassTuxedoEnum.ITEM_CODE_PANTS.getValue();
		
		Map<String,String> tuxedoPantsUpperPriceMap = new HashMap<String,String>();
				
		PantsCoOptionTuxedoUpperPriceEnum[] pantsCoOptionTuxedoUpperPriceEnum = PantsCoOptionTuxedoUpperPriceEnum.values();
		
		for(PantsCoOptionTuxedoUpperPriceEnum pantsCoOptionTuxedoUpperPrice : pantsCoOptionTuxedoUpperPriceEnum) {
			String optionCode = pantsCoOptionTuxedoUpperPrice.getKey();
			String optionBranchCode = pantsCoOptionTuxedoUpperPrice.getValueOne();
			String optionBranchDetailCode = pantsCoOptionTuxedoUpperPrice.getValueTwo();
			String mapOfKey = pantsCoOptionTuxedoUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsTuxedoInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPantsTuxedoInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
							tuxedoPantsUpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							tuxedoPantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
						}
						break;
					}
					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
							tuxedoPantsUpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							tuxedoPantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
						}
						break;
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return tuxedoPantsUpperPriceMap;
	}
	
	/**
	 * オーダー内容確認画面タキシードの2PANTS上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> tuxedoPants2UpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// PANTSのsubItemCodeの取得
		String subItemCode = ItemClassTuxedoEnum.ITEM_CODE_PANTS2.getKey();
		//PANTSのmodelCodeの取得
		String modelCode = orderForm.getOptionPants2TuxedoInfo().getTp2PantsModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
		String className = ItemClassTuxedoEnum.ITEM_CODE_PANTS2.getValue();
		
		Map<String,String> tuxedoPants2UpperPriceMap = new HashMap<String,String>();
				
		Pants2CoOptionTuxedoUpperPriceEnum[] pants2CoOptionTuxedoUpperPriceEnum = Pants2CoOptionTuxedoUpperPriceEnum.values();
		
		for(Pants2CoOptionTuxedoUpperPriceEnum pants2CoOptionTuxedoUpperPrice : pants2CoOptionTuxedoUpperPriceEnum) {
			String optionCode = pants2CoOptionTuxedoUpperPrice.getKey();
			String optionBranchCode = pants2CoOptionTuxedoUpperPrice.getValueOne();
			String optionBranchDetailCode = pants2CoOptionTuxedoUpperPrice.getValueTwo();
			String mapOfKey = pants2CoOptionTuxedoUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2TuxedoInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPants2TuxedoInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
							tuxedoPants2UpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							tuxedoPants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
						}
						break;
					}
					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
							tuxedoPants2UpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							tuxedoPants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
						}
						break;
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return tuxedoPants2UpperPriceMap;
	}
	
	/**
	 * オーダー内容確認画面ウォッシャブルのjacket上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> washableJacketUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		
		Map<String,String> washableJacketUpperPriceMap = new HashMap<String,String>();
		
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// JACKETのsubItemCodeの取得
		String subItemCode = ItemClassWashableEnum.ITEM_CODE_JACKET.getKey();
		//JACKETのmodelCodeの取得
		String modelCode = orderForm.getOptionJacketWashableInfo().getWjJacketModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionJacketStandardInfoの取得
		String className = ItemClassWashableEnum.ITEM_CODE_JACKET.getValue();
		//フロント釦数
		String WjFrontBtnCnt = orderForm.getOptionJacketWashableInfo().getWjFrontBtnCnt();
		//0000105(ダブル6つボタン)
		String wjFrontBtnCntdoubleSixButton = "0000105";
		//0000106(ダブル4つボタン)
		String wjFrontBtnCntdoubleFourButton = "0000106";
				
		JacketCoOptionWashableUpperPriceEnum[] jacketCoOptionWashableUpperPriceEnum = JacketCoOptionWashableUpperPriceEnum.values();
		
		for(JacketCoOptionWashableUpperPriceEnum jacketCoOptionWashableUpperPrice : jacketCoOptionWashableUpperPriceEnum) {
			String optionCode = jacketCoOptionWashableUpperPrice.getKey();
			String optionBranchCode = jacketCoOptionWashableUpperPrice.getValueOne();
			String optionBranchDetailCode = jacketCoOptionWashableUpperPrice.getValueTwo();
			String mapOfKey = jacketCoOptionWashableUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionJacketWashableInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionJacketWashableInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(wjFrontBtnCntdoubleSixButton.equals(WjFrontBtnCnt) || wjFrontBtnCntdoubleFourButton.equals(WjFrontBtnCnt)) {
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
								washableJacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								washableJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
								washableJacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								washableJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
							}
							break;
						}
					}
					else{
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
								washableJacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								washableJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
								washableJacketUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								washableJacketUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
							}
							break;
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return washableJacketUpperPriceMap;
	}
	
	
	/**
	 * オーダー内容確認画面ウォッシャブルのGILET上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> washableGiletUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// GILETのsubItemCodeの取得
		String subItemCode = ItemClassWashableEnum.ITEM_CODE_GILET.getKey();
		//GILETのmodelCodeの取得
		String modelCode = orderForm.getOptionGiletWashableInfo().getWgGiletModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionGiletStandardInfoの取得
		String className = ItemClassWashableEnum.ITEM_CODE_GILET.getValue();
		//GILETモデル
		String wgGiletModel = orderForm.getOptionGiletWashableInfo().getWgGiletModelMap().get(orderForm.getOptionGiletWashableInfo().getWgGiletModel());
		//BS01-D
		String bs01dModel = "BS01-D";
		//ET15-D
		String et15dModel = "ET15-D";
		
		Map<String,String> washableGiletUpperPriceMap = new HashMap<String,String>();
				
		GiletCoOptionWashableUpperPriceEnum[] giletCoOptionWashableUpperPriceEnum = GiletCoOptionWashableUpperPriceEnum.values();
		
		for(GiletCoOptionWashableUpperPriceEnum giletCoOptionWashableUpperPrice : giletCoOptionWashableUpperPriceEnum) {
			String optionCode = giletCoOptionWashableUpperPrice.getKey();
			String optionBranchCode = giletCoOptionWashableUpperPrice.getValueOne();
			String optionBranchDetailCode = giletCoOptionWashableUpperPrice.getValueTwo();
			String mapOfKey = giletCoOptionWashableUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionGiletWashableInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionGiletWashableInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(bs01dModel.equals(wgGiletModel) || et15dModel.equals(wgGiletModel)) {
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDoublePrice())) {
								washableGiletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								washableGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDoublePrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailDoublePrice())) {
								washableGiletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								washableGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailDoublePrice()));
							}
							break;
						}
					}
					else{
						if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchPrice())) {
								washableGiletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								washableGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
							}
							break;
						}
						else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
							if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
								washableGiletUpperPriceMap.put(mapOfKey, "無料");
							}
							else {
								washableGiletUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
							}
							break;
						}
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return washableGiletUpperPriceMap;
	}
	
	/**
	 * オーダー内容確認画面ウォッシャブルのPANTS上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> washablePantsUpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// PANTSのsubItemCodeの取得
		String subItemCode = ItemClassWashableEnum.ITEM_CODE_PANTS.getKey();
		//PANTSのmodelCodeの取得
		String modelCode = orderForm.getOptionPantsWashableInfo().getWpPantsModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
		String className = ItemClassWashableEnum.ITEM_CODE_PANTS.getValue();
		
		Map<String,String> washablePantsUpperPriceMap = new HashMap<String,String>();
				
		PantsCoOptionWashableUpperPriceEnum[] pantsCoOptionWashableUpperPriceEnum = PantsCoOptionWashableUpperPriceEnum.values();
		
		for(PantsCoOptionWashableUpperPriceEnum pantsCoOptionWashableUpperPrice : pantsCoOptionWashableUpperPriceEnum) {
			String optionCode = pantsCoOptionWashableUpperPrice.getKey();
			String optionBranchCode = pantsCoOptionWashableUpperPrice.getValueOne();
			String optionBranchDetailCode = pantsCoOptionWashableUpperPrice.getValueTwo();
			String mapOfKey = pantsCoOptionWashableUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPantsWashableInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPantsWashableInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
							washablePantsUpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							washablePantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
						}
						break;
					}
					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
							washablePantsUpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							washablePantsUpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
						}
						break;
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return washablePantsUpperPriceMap;
	}
	
	/**
	 * オーダー内容確認画面ウォッシャブルの2PANTS上代
	 * @param orderForm
	 * @param optionBranchPriceList
	 * @return
	 */
	public Map<String,String> washablePants2UpperPrice(OrderForm orderForm,List<OrderCodePrice> optionBranchPriceList){
		// itemCodeの取得
		String itemCode = orderForm.getProductItem();
		// PANTSのsubItemCodeの取得
		String subItemCode = ItemClassWashableEnum.ITEM_CODE_PANTS2.getKey();
		//PANTSのmodelCodeの取得
		String modelCode = orderForm.getOptionPants2WashableInfo().getWp2PantsModel();
		// co.jp.aoyama.macchinetta.app.order.info.OptionPantsStandardInfoの取得
		String className = ItemClassWashableEnum.ITEM_CODE_PANTS2.getValue();
		
		Map<String,String> washablePants2UpperPriceMap = new HashMap<String,String>();
				
		Pants2CoOptionWashableUpperPriceEnum[] pants2CoOptionWashableUpperPriceEnum = Pants2CoOptionWashableUpperPriceEnum.values();
		
		for(Pants2CoOptionWashableUpperPriceEnum pants2CoOptionWashableUpperPrice : pants2CoOptionWashableUpperPriceEnum) {
			String optionCode = pants2CoOptionWashableUpperPrice.getKey();
			String optionBranchCode = pants2CoOptionWashableUpperPrice.getValueOne();
			String optionBranchDetailCode = pants2CoOptionWashableUpperPrice.getValueTwo();
			String mapOfKey = pants2CoOptionWashableUpperPrice.getValueThree();
			
			Class<?> cls;
			try {
				cls = Class.forName(className);
				Method myMethodOne = getMethod(cls, optionBranchCode);
				Method myMethodTwo = getMethod(cls, optionBranchDetailCode);
				Object[] args = {};
				Object[] argsT = {};
				Object resultOne = null;
				Object resultTwo = null;
				if (myMethodOne != null) {
					resultOne = ReflectionUtils.invoke(myMethodOne, orderForm.getOptionPants2WashableInfo(), args);
				}
				if (myMethodTwo != null) {
					resultTwo = ReflectionUtils.invoke(myMethodTwo, orderForm.getOptionPants2WashableInfo(), argsT);
				}
				String priceKeyCode = null;
				if(resultTwo != null) {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne + resultTwo;
				}
				else {
					priceKeyCode = itemCode + subItemCode + modelCode + optionCode + resultOne;
				}
				
				for(OrderCodePrice orderCodePrice : optionBranchPriceList) {
					if(priceKeyCode.equals(orderCodePrice.getOrderKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchPrice())) {
							washablePants2UpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							washablePants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchPrice()));
						}
						break;
					}
					else if(priceKeyCode.equals(orderCodePrice.getOrderDetailKeyCode())) {
						if("0".equals(orderCodePrice.getOrderBranchDetailPrice())) {
							washablePants2UpperPriceMap.put(mapOfKey, "無料");
						}
						else {
							washablePants2UpperPriceMap.put(mapOfKey, "￥" + formatPrice(orderCodePrice.getOrderBranchDetailPrice()));
						}
						break;
					}
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
		return washablePants2UpperPriceMap;
	}
}	
