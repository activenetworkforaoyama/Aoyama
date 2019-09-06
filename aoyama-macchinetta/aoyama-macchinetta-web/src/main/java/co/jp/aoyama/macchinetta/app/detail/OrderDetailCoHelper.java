package co.jp.aoyama.macchinetta.app.detail;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderDetailFormat;

public class OrderDetailCoHelper {
	
	//半角スペースの定義
	private static final String half_space = " ";
	
	//半角コンマの定義
	private static final String half_conma = ",";

	/**
	 * 項目変換処理
	 * @param 注文情報
	 */
	public void getOptionDataFormat(Order order, OrderDetailFormat orderFm) {
		
		//ベルトループ、内ポケット変更、ステッチ箇所変更、ダブルステッチ変更、
		//AMF色指定、ボタンホール色指定、ボタン付け糸指定の分割処理
		
		//JACKETモデル
		order.setJkInnerPktNm(getHalfReplaceValue(order.getJkInnerPktNm()));
		order.setJkStitchTypeNm(getHalfReplaceValue(order.getJkStitchTypeNm()));
		order.setJkDblstitchPlcNm(getHalfReplaceValue(order.getJkDblstitchPlcNm()));
		order.setJkAmfColorPlcNm(getHalfReplaceValue(order.getJkAmfColorPlcNm()));
		order.setJkBtnholeColorPlcN(getHalfReplaceValue(order.getJkBtnholeColorPlcN()));
		order.setJkBtnthreadColorPlcN(getHalfReplaceValue(order.getJkBtnthreadColorPlcN()));

		//GILETモデル
		order.setGlStitchPlcNm(getHalfReplaceValue(order.getGlStitchPlcNm()));
		order.setGlDblstitchPlcNm(getHalfReplaceValue(order.getGlDblstitchPlcNm()));
		order.setGlBtnholeColorPlcNm(getHalfReplaceValue(order.getGlBtnholeColorPlcNm()));
		order.setGlBtnthreadColorPlcNm(getHalfReplaceValue(order.getGlBtnthreadColorPlcNm()));
		
		//PANTSモデル
		order.setPtBeltloopNm(getHalfReplaceValue(order.getPtBeltloopNm()));
		order.setPtStitchPlcNm(getHalfReplaceValue(order.getPtStitchPlcNm()));
		order.setPtDblstitchPlcNm(getHalfReplaceValue(order.getPtDblstitchPlcNm()));
		order.setPtAmfColorPlcNm(getHalfReplaceValue(order.getPtAmfColorPlcNm()));
		order.setPtBtnholeColorPlcNm(getHalfReplaceValue(order.getPtBtnholeColorPlcNm()));
		order.setPtBtnthreadColorPlcNm(getHalfReplaceValue(order.getPtBtnthreadColorPlcNm()));
		
		//2PANTSモデル
		order.setPt2BeltloopNm(getHalfReplaceValue(order.getPt2BeltloopNm()));
		order.setPt2StitchPlcNm(getHalfReplaceValue(order.getPt2StitchPlcNm()));
		order.setPt2DblstitchPlcNm(getHalfReplaceValue(order.getPt2DblstitchPlcNm()));
		order.setPt2AmfColorPlcNm(getHalfReplaceValue(order.getPt2AmfColorPlcNm()));
		order.setPt2BtnholeColorPlcNm(getHalfReplaceValue(order.getPt2BtnholeColorPlcNm()));
		order.setPt2BtnthreadColorPlcNm(getHalfReplaceValue(order.getPt2BtnthreadColorPlcNm()));

		//上代価格の変換
		orderFm.setProductIs3pieceRtPriceFm(getRtValue(order.getProductIs3pieceRtPrice()));
		orderFm.setProductSparePantsRtPriceFm(getRtValue(order.getProductSparePantsRtPrice()));
		orderFm.setJkFrtBtnRtPriceFm(getRtValue(order.getJkFrtBtnRtPrice()));
		orderFm.setJkLapelDesignRtPriceFm(getRtValue(order.getJkLapelDesignRtPrice()));
		orderFm.setJkGradeRtPriceFm(getRtValue(order.getJkGradeRtPrice()));
		orderFm.setJkDaibaRtPriceFm(getRtValue(order.getJkDaibaRtPrice()));
		orderFm.setJkCollarInnerRtPriceFm(getRtValue(order.getJkCollarInnerRtPrice()));
		orderFm.setJkLookClothRtPriceFm(getRtValue(order.getJkLookClothRtPrice()));
		orderFm.setJkCollarHangRtPriceFm(getRtValue(order.getJkCollarHangRtPrice()));
		orderFm.setJkLapelWidthRtPriceFm(getRtValue(order.getJkLapelWidthRtPrice()));
		orderFm.setJkFlowerHoleRtPriceFm(getRtValue(order.getJkFlowerHoleRtPrice()));
		orderFm.setJkBreastPktRtPriceFm(getRtValue(order.getJkBreastPktRtPrice()));
		orderFm.setJkInnerClothRtPriceFm(getRtValue(order.getJkInnerClothRtPrice()));
		orderFm.setJkWaistPktRtPriceFm(getRtValue(order.getJkWaistPktRtPrice()));
		orderFm.setJkChgPktRtPriceFm(getRtValue(order.getJkChgPktRtPrice()));
		orderFm.setJkSlantedPktRtPriceFm(getRtValue(order.getJkSlantedPktRtPrice()));
		orderFm.setJkShinobiPktRtPriceFm(getRtValue(order.getJkShinobiPktRtPrice()));
		orderFm.setJkSleeveTypeRtPriceFm(getRtValue(order.getJkSleeveTypeRtPrice()));
		orderFm.setJkManicaRtPriceFm(getRtValue(order.getJkManicaRtPrice()));
		orderFm.setJkSleeveBtnRtPriceFm(getRtValue(order.getJkSleeveBtnRtPrice()));
		orderFm.setJkCuffRtPriceFm(getRtValue(order.getJkCuffRtPrice()));
		orderFm.setJkInnerPktRtPriceFm(getRtValue(order.getJkInnerPktRtPrice()));
		orderFm.setJkRightInnerPktTypeRtPriceFm(getRtValue(order.getJkRightInnerPktTypeRtPrice()));
		orderFm.setJkStitchTypeRtPriceFm(getRtValue(order.getJkStitchTypeRtPrice()));
		orderFm.setJkStitchPlcRtPriceFm(getRtValue(order.getJkStitchPlcRtPrice()));
		orderFm.setJkDblstitchPlcRtPriceFm(getRtValue(order.getJkDblstitchPlcRtPrice()));
		orderFm.setJkAmfColorRtPriceFm(getRtValue(order.getJkAmfColorRtPrice()));
		orderFm.setJkBtnholePlcColorRtPriceFm(getRtValue(order.getJkBtnholePlcColorRtPrice()));
		orderFm.setJkBtnthreadPlcColorRtPriceFm(getRtValue(order.getJkBtnthreadPlcColorRtPrice()));
		orderFm.setJkVentRtPriceFm(getRtValue(order.getJkVentRtPrice()));
		orderFm.setJkInnerBodyClothRtPriceFm(getRtValue(order.getJkInnerBodyClothRtPrice()));
		orderFm.setJkInnerSleeveClothRtPriceFm(getRtValue(order.getJkInnerSleeveClothRtPrice()));
		orderFm.setJkBtnMaterialRtPriceFm(getRtValue(order.getJkBtnMaterialRtPrice()));
		orderFm.setJkShapeMemoryRtPriceFm(getRtValue(order.getJkShapeMemoryRtPrice()));
		orderFm.setGlBreastPktRtPriceFm(getRtValue(order.getGlBreastPktRtPrice()));
		orderFm.setGlWaistPktRtPriceFm(getRtValue(order.getGlWaistPktRtPrice()));
		orderFm.setGlWaistPktShapeRtPriceFm(getRtValue(order.getGlWaistPktShapeRtPrice()));
		orderFm.setGlWaistPktShapeRtPriceFm(getRtValue(order.getGlWaistPktShapeRtPrice()));
		orderFm.setGlAmfStitchRtPriceFm(getRtValue(order.getGlAmfStitchRtPrice()));
		orderFm.setGlStitchPlcRtPriceFm(getRtValue(order.getGlStitchPlcRtPrice()));
		orderFm.setGlDblstitchPlcRtPriceFm(getRtValue(order.getGlDblstitchPlcRtPrice()));
		orderFm.setGlAmfColorRtPriceFm(getRtValue(order.getGlAmfColorRtPrice()));
		orderFm.setGlBtnholeColorRtPriceFm(getRtValue(order.getGlBtnholeColorRtPrice()));
		orderFm.setGlBtnthreadColorRtPriceFm(getRtValue(order.getGlBtnthreadColorRtPrice()));
		orderFm.setGlBackClothRtPriceFm(getRtValue(order.getGlBackClothRtPrice()));
		orderFm.setGlInnnerClothRtPriceFm(getRtValue(order.getGlInnnerClothRtPrice()));
		orderFm.setGlFrtBtnRtPriceFm(getRtValue(order.getGlFrtBtnRtPrice()));
		orderFm.setGlBackBeltRtPriceFm(getRtValue(order.getGlBackBeltRtPrice()));
		orderFm.setGlWatchChainRtPriceFm(getRtValue(order.getGlWatchChainRtPrice()));
		orderFm.setPtTackRtPriceFm(getRtValue(order.getPtTackRtPrice()));
		orderFm.setPtKneeinnerTypeRtPriceFm(getRtValue(order.getPtKneeinnerTypeRtPrice()));
		orderFm.setPtKneeinnerClothRtPriceFm(getRtValue(order.getPtKneeinnerClothRtPrice()));
		orderFm.setPtFrtTypeRtPriceFm(getRtValue(order.getPtFrtTypeRtPrice()));
		orderFm.setPtPancherinaRtPriceFm(getRtValue(order.getPtPancherinaRtPrice()));
		orderFm.setPtAdjusterRtPriceFm(getRtValue(order.getPtAdjusterRtPrice()));
		orderFm.setPtBeltloopRtPriceFm(getRtValue(order.getPtBeltloopRtPrice()));
		orderFm.setPtPinloopRtPriceFm(getRtValue(order.getPtPinloopRtPrice()));
		orderFm.setPtSidePktRtPriceFm(getRtValue(order.getPtSidePktRtPrice()));
		orderFm.setPtShinobiPktRtPriceFm(getRtValue(order.getPtShinobiPktRtPrice()));
		orderFm.setPtCoinPktRtPriceFm(getRtValue(order.getPtCoinPktRtPrice()));
		orderFm.setPtFlapcoinPktRtPriceFm(getRtValue(order.getPtFlapcoinPktRtPrice()));
		orderFm.setPtLeftPisPktRtPriceFm(getRtValue(order.getPtLeftPisPktRtPrice()));
		orderFm.setPtRightPisPktRtPriceFm(getRtValue(order.getPtRightPisPktRtPrice()));
		orderFm.setPtVCutRtPriceFm(getRtValue(order.getPtVCutRtPrice()));
		orderFm.setPtHemUpRtPriceFm(getRtValue(order.getPtHemUpRtPrice()));
		orderFm.setPtDblWidthRtPriceFm(getRtValue(order.getPtDblWidthRtPrice()));
		orderFm.setPtAmfStitchRtPriceFm(getRtValue(order.getPtAmfStitchRtPrice()));
		orderFm.setPtStitchPlcRtPriceFm(getRtValue(order.getPtStitchPlcRtPrice()));
		orderFm.setPtDblstitchPlcRtPriceFm(getRtValue(order.getPtDblstitchPlcRtPrice()));
		orderFm.setPtAmfColorRtPriceFm(getRtValue(order.getPtAmfColorRtPrice()));
		orderFm.setPtBtnholeColorRtPriceFm(getRtValue(order.getPtBtnholeColorRtPrice()));
		orderFm.setPtBtnthreadColorRtPriceFm(getRtValue(order.getPtBtnthreadColorRtPrice()));
		orderFm.setPtBtnMaterialRtPriceFm(getRtValue(order.getPtBtnMaterialRtPrice()));
		orderFm.setPtSuspenderBtnRtPriceFm(getRtValue(order.getPtSuspenderBtnRtPrice()));
		orderFm.setPtNonSlipRtPriceFm(getRtValue(order.getPtNonSlipRtPrice()));
		orderFm.setPtChicSlipRtPriceFm(getRtValue(order.getPtChicSlipRtPrice()));
		orderFm.setPtShapeMemoryRtPriceFm(getRtValue(order.getPtShapeMemoryRtPrice()));
		orderFm.setPt2HemUpRtPriceFm(getRtValue(order.getPt2HemUpRtPrice()));
		orderFm.setPt2DblWidthRtPriceFm(getRtValue(order.getPt2DblWidthRtPrice()));
		orderFm.setPt2TackRtPriceFm(getRtValue(order.getPt2TackRtPrice()));
		orderFm.setPt2AdjusterRtPriceFm(getRtValue(order.getPt2AdjusterRtPrice()));
		orderFm.setPt2KneeinnerTypeRtPriceFm(getRtValue(order.getPt2KneeinnerTypeRtPrice()));
		orderFm.setPt2KneeinnerClothRtPriceFm(getRtValue(order.getPt2KneeinnerClothRtPrice()));
		orderFm.setPt2FrtTypeRtPriceFm(getRtValue(order.getPt2FrtTypeRtPrice()));
		orderFm.setPt2PancherinaRtPriceFm(getRtValue(order.getPt2PancherinaRtPrice()));
		orderFm.setPt2BeltloopRtPriceFm(getRtValue(order.getPt2BeltloopRtPrice()));
		orderFm.setPt2PinloopRtPriceFm(getRtValue(order.getPt2PinloopRtPrice()));
		orderFm.setPt2SidePktRtPriceFm(getRtValue(order.getPt2SidePktRtPrice()));
		orderFm.setPt2ShinobiPktRtPriceFm(getRtValue(order.getPt2ShinobiPktRtPrice()));
		orderFm.setPt2CoinPktRtPriceFm(getRtValue(order.getPt2CoinPktRtPrice()));
		orderFm.setPt2FlapcoinPktRtPriceFm(getRtValue(order.getPt2FlapcoinPktRtPrice()));
		orderFm.setPt2LeftPisPktRtPriceFm(getRtValue(order.getPt2LeftPisPktRtPrice()));
		orderFm.setPt2RightPisPktRtPriceFm(getRtValue(order.getPt2RightPisPktRtPrice()));
		orderFm.setPt2VCutRtPriceFm(getRtValue(order.getPt2VCutRtPrice()));
		orderFm.setPt2AmfStitchRtPriceFm(getRtValue(order.getPt2AmfStitchRtPrice()));
		orderFm.setPt2StitchPlcRtPriceFm(getRtValue(order.getPt2StitchPlcRtPrice()));
		orderFm.setPt2DblstitchPlcRtPriceFm(getRtValue(order.getPt2DblstitchPlcRtPrice()));
		orderFm.setPt2AmfColorRtPriceFm(getRtValue(order.getPt2AmfColorRtPrice()));
		orderFm.setPt2BtnholeColorRtPriceFm(getRtValue(order.getPt2BtnholeColorRtPrice()));
		orderFm.setPt2BtnthreadColorRtPriceFm(getRtValue(order.getPt2BtnthreadColorRtPrice()));
		orderFm.setPt2SuspenderBtnRtPriceFm(getRtValue(order.getPt2SuspenderBtnRtPrice()));
		orderFm.setPt2BtnMaterialRtPriceFm(getRtValue(order.getPt2BtnMaterialRtPrice()));
		orderFm.setPt2NonSlipRtPriceFm(getRtValue(order.getPt2NonSlipRtPrice()));
		orderFm.setPt2ChicSlipRtPriceFm(getRtValue(order.getPt2ChicSlipRtPrice()));
		orderFm.setPt2ShapeMemoryRtPriceFm(getRtValue(order.getPt2ShapeMemoryRtPrice()));
		orderFm.setCtLapelDesignRtPriceFm(getRtValue(order.getCtLapelDesignRtPrice()));
		orderFm.setCtSleeveTypeRtPriceFm(getRtValue(order.getCtSleeveTypeRtPrice()));
		orderFm.setCtWaistPktRtPriceFm(getRtValue(order.getCtWaistPktRtPrice()));
		orderFm.setCtChgPktRtPriceFm(getRtValue(order.getCtChgPktRtPrice()));
		orderFm.setCtSlantedPktRtPriceFm(getRtValue(order.getCtSlantedPktRtPrice()));
		orderFm.setCtVentRtPriceFm(getRtValue(order.getCtVentRtPrice()));
		orderFm.setCtFrtBtnRtPriceFm(getRtValue(order.getCtFrtBtnRtPrice()));
		orderFm.setCtCuffRtPriceFm(getRtValue(order.getCtCuffRtPrice()));
		orderFm.setCtSleeveBtnRtPriceFm(getRtValue(order.getCtSleeveBtnRtPrice()));
		orderFm.setCtBackBeltRtPriceFm(getRtValue(order.getCtBackBeltRtPrice()));
		orderFm.setCtCollarHangRtPriceFm(getRtValue(order.getCtCollarHangRtPrice()));
		orderFm.setCtInnerBodyClothRtPriceFm(getRtValue(order.getCtInnerBodyClothRtPrice()));
		orderFm.setCtInnerSleeveClothRtPriceFm(getRtValue(order.getCtInnerSleeveClothRtPrice()));
		orderFm.setCtBtnMaterialRtPriceFm(getRtValue(order.getCtBtnMaterialRtPrice()));
		orderFm.setStCollarTypeRtPriceFm(getRtValue(order.getStCollarTypeRtPrice()));
		orderFm.setStCuffsRtPriceFm(getRtValue(order.getStCuffsRtPrice()));
		orderFm.setStConvertibleRtPriceFm(getRtValue(order.getStConvertibleRtPrice()));
		orderFm.setStAdjusterBtnRtPriceFm(getRtValue(order.getStAdjusterBtnRtPrice()));
		orderFm.setStClericRtPriceFm(getRtValue(order.getStClericRtPrice()));
		orderFm.setStDblCuffsRtPriceFm(getRtValue(order.getStDblCuffsRtPrice()));
		orderFm.setStCuffsBtnRtPriceFm(getRtValue(order.getStCuffsBtnRtPrice()));
		orderFm.setStBtnMaterialRtPriceFm(getRtValue(order.getStBtnMaterialRtPrice()));
		orderFm.setStDblBtnRtPriceFm(getRtValue(order.getStDblBtnRtPrice()));
		orderFm.setStGauntletBtnPosRtPriceFm(getRtValue(order.getStGauntletBtnPosRtPrice()));
		orderFm.setStPinholePinRtPriceFm(getRtValue(order.getStPinholePinRtPrice()));
		orderFm.setStBreastPktRtPriceFm(getRtValue(order.getStBreastPktRtPrice()));
		orderFm.setStBreastSizeRtPriceFm(getRtValue(order.getStBreastSizeRtPrice()));
		orderFm.setStFrtDesignRtPriceFm(getRtValue(order.getStFrtDesignRtPrice()));
		orderFm.setStPintuckBosomRtPriceFm(getRtValue(order.getStPintuckBosomRtPrice()));
		orderFm.setStStitchRtPriceFm(getRtValue(order.getStStitchRtPrice()));
		orderFm.setStColarKeeperRtPriceFm(getRtValue(order.getStColarKeeperRtPrice()));
		orderFm.setStBtnholeColorRtPriceFm(getRtValue(order.getStBtnholeColorRtPrice()));
		orderFm.setStBtnthreadColorRtPriceFm(getRtValue(order.getStBtnthreadColorRtPrice()));
		orderFm.setStCasualHemlineRtPriceFm(getRtValue(order.getStCasualHemlineRtPrice()));
		orderFm.setStBtnposChgRtPriceFm(getRtValue(order.getStBtnposChgRtPrice()));
		orderFm.setStNeckbandBtnChgRtPriceFm(getRtValue(order.getStNeckbandBtnChgRtPrice()));
		orderFm.setStFrtfirstBtnChgRtPriceFm(getRtValue(order.getStFrtfirstBtnChgRtPrice()));
		orderFm.setStFrtsecondBtnChgRtPriceFm(getRtValue(order.getStFrtsecondBtnChgRtPrice()));
		orderFm.setPtSideStripeRtPriceFm(getRtValue(order.getPtSideStripeRtPrice()));
		orderFm.setPtSideStripeWidthRtPriceFm(getRtValue(order.getPtSideStripeWidthRtPrice()));
		orderFm.setPt2SideStripeRtPriceFm(getRtValue(order.getPt2SideStripeRtPrice()));
		orderFm.setPt2SideStripeWidthRtPriceFm(getRtValue(order.getPt2SideStripeWidthRtPrice()));
		
		//下代価格
		orderFm.setWsPriceFm(getFormatMoneyValue(order.getWsPrice()));
		
		//ご請求金額
		orderFm.setBillingAmountFm(getFormatMoneyValue(order.getBillingAmount()));
		orderFm.setConsumptionTaxAmountFm(getFormatMoneyValue(order.getConsumptionTaxAmount()));
		orderFm.setProductPriceFm(getFormatMoneyValue(order.getProductPrice()));
		orderFm.setOptionPriceFm(getFormatMoneyValue(order.getOptionPrice()));
		orderFm.setTotalPriceFm(getFormatMoneyValue(order.getTotalPrice()));
		
		//補正値
		//JACKET補正
		orderFm.setCorJkBodylengthCorrectFm(getCorrectValue(order.getCorJkBodylengthCorrect()));
		orderFm.setCorJkWaistCorrectFm(getCorrectValue(order.getCorJkWaistCorrect()));
		orderFm.setCorJkRightsleeveCorrectFm(getCorrectValue(order.getCorJkRightsleeveCorrect()));
		orderFm.setCorJkLeftsleeveCorrectFm(getCorrectValue(order.getCorJkLeftsleeveCorrect()));

		//GILET補正
		orderFm.setCorGlBodylengthCorrectFm(getCorrectValue(order.getCorGlBodylengthCorrect()));
		orderFm.setCorGlBustCorrectFm(getCorrectValue(order.getCorGlBustCorrect()));
		orderFm.setCorGlWaistCorrectFm(getCorrectValue(order.getCorGlWaistCorrect()));

		//PANTS補正
		orderFm.setCorPtWaistCorrectFm(getCorrectValue(order.getCorPtWaistCorrect()));
		orderFm.setCorPtHipCorrectFm(getCorrectValue(order.getCorPtHipCorrect()));
		orderFm.setCorPtThighwidthCorrectFm(getCorrectValue(order.getCorPtThighwidthCorrect()));
		orderFm.setCorPtHemwidthCorrectFm(getCorrectValue(order.getCorPtHemwidthCorrect()));

		//PANTS補正
		orderFm.setCorPt2WaistCorrectFm(getCorrectValue(order.getCorPt2WaistCorrect()));
		orderFm.setCorPt2HipCorrectFm(getCorrectValue(order.getCorPt2HipCorrect()));
		orderFm.setCorPt2ThighwidthCorrectFm(getCorrectValue(order.getCorPt2ThighwidthCorrect()));
		orderFm.setCorPt2HemwidthCorrectFm(getCorrectValue(order.getCorPt2HemwidthCorrect()));

		//COAT補正
		orderFm.setCorCtBodylengthCorrectFm(getCorrectValue(order.getCorCtBodylengthCorrect()));
		orderFm.setCorCtWaistCorrectFm(getCorrectValue(order.getCorCtWaistCorrect()));
		orderFm.setCorCtRightsleeveCorrectFm(getCorrectValue(order.getCorCtRightsleeveCorrect()));
		orderFm.setCorCtLeftsleeveCorrectFm(getCorrectValue(order.getCorCtLeftsleeveCorrect()));
		orderFm.setCorCtVenthightCorrectFm(getCorrectValue(order.getCorCtVenthightCorrect()));
		orderFm.setCorCtPktposCorrectFm(getCorrectValue(order.getCorCtPktposCorrect()));

		//SHIRT補正
		orderFm.setCorStNeckCorrectFm(getCorrectValue(order.getCorStNeckCorrect()));
		orderFm.setCorStBodylengthCorrectFm(getCorrectValue(order.getCorStBodylengthCorrect()));
		orderFm.setCorStRightsleeveCorrectFm(getCorrectValue(order.getCorStRightsleeveCorrect()));
		orderFm.setCorStLeftsleeveCorrectFm(getCorrectValue(order.getCorStLeftsleeveCorrect()));
		orderFm.setCorStBackdartsPackCorrectFm(getCorrectValue(order.getCorStBackdartsPackCorrect()));
		orderFm.setCorStBackdartsUnpackCorrectFm(getCorrectValue(order.getCorStBackdartsUnpackCorrect()));
		orderFm.setCorStRightcuffsSurroundingCorrectFm(getCorrectValue(order.getCorStRightcuffsSurroundingCorrect()));
		orderFm.setCorStLeftcuffsSurroundingCorrectFm(getCorrectValue(order.getCorStLeftcuffsSurroundingCorrect()));
		
		//注文内容確認書と工場指示書の標示設定
		String productItem = order.getProductItem();
		
		//SUIT（01）、JACKET（02）、PANTS（03）、GILET（04）の場合
		if ("01".equals(productItem) || "02".equals(productItem) || "03".equals(productItem) || "04".equals(productItem)) {
			//注文内容確認書
			orderFm.setOrderKakuninSign("1");
			//注文内容確認書_お客様向け
			orderFm.setOrderKakuninKyakSign("2");
			//工場指示書
			orderFm.setFactorySijiSign("3");
			
		//SHIRT（05）の場合
		} else if ("05".equals(productItem)) {
			//注文内容確認書
			orderFm.setOrderKakuninSign("7");
			//注文内容確認書_お客様向け
			orderFm.setOrderKakuninKyakSign("8");
			//工場指示書
			orderFm.setFactorySijiSign("9");
			
		//COAT（06）の場合
		}  else if ("06".equals(productItem)) {
			//注文内容確認書
			orderFm.setOrderKakuninSign("4");
			//注文内容確認書_お客様向け
			orderFm.setOrderKakuninKyakSign("5");
			//工場指示書
			orderFm.setFactorySijiSign("6");
		}
		
	}
	
	/**
	 * 半角コンマを半角スペースに置換する
	 * @return　置換後の文字列
	 */
	public String getHalfReplaceValue(String src) {
		String sourceString = "";
		
		//文字列が空もしくはnullの場合、空を返す
		if (null == src || 0 == src.length()) {
			sourceString = src;
			
		} else {
			sourceString = src.replace(half_conma,half_space);
		}
		
		return sourceString;
	}
	
	
	/**
	 * 上代価格の変換
	 * @return　変換後の上代価格
	 */
	public String getRtValue(Integer src) {
		
		String sourceString = "";
		
		//上代価格が空もしくは0の場合、無料を返す
		if (null == src || 0 == src) {
			sourceString = "無料";
			
		} else {
			try {
				BigDecimal value=new BigDecimal(src);
				DecimalFormat df=new DecimalFormat(",###");
				sourceString = "￥" + df.format(value);
				
			} catch (NumberFormatException e) {
				sourceString = "無料";
			}
		}
		
		return sourceString;
	}
	
	/**
	 * オプション金額の変換
	 * @return　変換後のオプション金額
	 */
	public String getFormatMoneyValue(Integer src) {
		
		String sourceString = "";
		
		//オプション金額が空もしくは0以外の場合、変換処理を行う
		if (!(null == src)) {
			try {
				BigDecimal value=new BigDecimal(src);
				DecimalFormat df=new DecimalFormat(",###");
				sourceString = "￥" + df.format(value);
				
			} catch (NumberFormatException e) {
				//何にもなし
			}
		}
		
		return sourceString;
	}
	
	/**
	 * 補正値の設定
	 * @return 変換後の補正値
	 */
	public String getCorrectValue(BigDecimal src) {
		
		String sourceString = "";
		
		//上代価格が空もしくは0の場合、無料を返す
		if (null != src) {
			if(src.toString().indexOf("-") == -1){
				sourceString = "+" + src;
			}
			else{
				sourceString = src.toString();
			}
		} else {
			sourceString = "0.0";
		}
		
		return sourceString + "cm";
	}
	
}
