package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderMakerUse implements Serializable {

	private static final long serialVersionUID = 5791366667212000605L;
	private String orderId;
	private String orderPattern;
	private String storeBrandCode;
	private String shopCode;
	private Integer wsPrice;
	private String storeNm;
	private String printoutCustRomaNm;
	private String printoutStoreStaffRomaNm;
	private String productItem;
	private String productIs3piece;
	private BigDecimal productIs3pieceWsWage;
	private Integer productIs3pieceWsPrice;
	private String productSparePantsClass;
	private BigDecimal productSparePantsWsWage;
	private Integer productSparePantsWsPrice;
	private String productFabricNo;
	private String fabricColor;
	private String fabricPattern;
	private String productCategory;
	private String productBrandType;
	private String productBrandNm;
	private String productFabricNmNecessity;
	private String productEmbroideryNecessity;
	private String productEmbroideryNm;
	private String productEmbroideryFont;
	private String productEmbroideryThreadColor;
	private String productEmbroideryGazette;
	private BigDecimal productEmbroideryGazetteWsWage;
	private Integer productEmbroideryGazetteWsPrice;
	private String productEmbroideryNmPos;
	private BigDecimal productEmbroideryNmPosWsWage;
	private Integer productEmbroideryNmPosWsPrice;
	private BigDecimal productEmbroideryLength;
	private BigDecimal productEmbroideryWidth;
	private String productRemainingClothType;
	private String productRemainingClothNm;
	private String productFabricBrandNm;
	private String productServiceNm;
	private String productComposFrtFabric;
	private String productComposBodyLiner;
	private String productComposSleeveLiner;
	private String productNotice;
	private String productFactoryCd;
	private String productMakerCode;
	private Date productOrderdDate;
	private String jkModelCd;
	private String jkModelNm;
	private BigDecimal jkModelWsWage;
	private Integer jkModelWsPrice;
	private String jkFrtBtnCd;
	private String jkFrtBtnNm;
	private BigDecimal jkFrtBtnWsWage;
	private Integer jkFrtBtnWsPrice;
	private String jkLapelDesignCd;
	private String jkLapelDesignNm;
	private BigDecimal jkLapelDesignWsWage;
	private Integer jkLapelDesignWsPrice;
	private String jkLapelModelCd;
	private String jkLapelModelNm;
	private BigDecimal jkLapelModelWsWage;
	private Integer jkLapelModelWsPrice;
	private String jkGradeCd;
	private String jkGradeNm;
	private BigDecimal jkGradeWsWage;
	private Integer jkGradeWsPrice;
	private String jkInnerClothCd;
	private String jkInnerClothNm;
	private BigDecimal jkInnerClothWsWage;
	private Integer jkInnerClothWsPrice;
	private String jkDaibaCd;
	private String jkDaibaNm;
	private BigDecimal jkDaibaWsWage;
	private Integer jkDaibaWsPrice;
	private String jkLookClothCd;
	private String jkLookClothNm;
	private BigDecimal jkLookClothWsWage;
	private Integer jkLookClothWsPrice;
	private String jkCollarInnerCd;
	private String jkCollarInnerNm;
	private BigDecimal jkCollarInnerWsWage;
	private Integer jkCollarInnerWsPrice;
	private String jkCollarHangCd;
	private String jkCollarHangNm;
	private BigDecimal jkCollarHangWsWage;
	private Integer jkCollarHangWsPrice;
	private String jkLapelWidthCd;
	private String jkLapelWidthNm;
	private BigDecimal jkLapelWidthWsWage;
	private Integer jkLapelWidthWsPrice;
	private String jkFlowerHoleCd;
	private String jkFlowerHoleNm;
	private BigDecimal jkFlowerHoleWsWage;
	private Integer jkFlowerHoleWsPrice;
	private String jkBreastPktCd;
	private String jkBreastPktNm;
	private BigDecimal jkBreastPktWsWage;
	private Integer jkBreastPktWsPrice;
	private String jkWaistPktCd;
	private String jkWaistPktNm;
	private BigDecimal jkWaistPktWsWage;
	private Integer jkWaistPktWsPrice;
	private String jkChgPktCd;
	private String jkChgPktNm;
	private BigDecimal jkChgPktWsWage;
	private Integer jkChgPktWsPrice;
	private String jkSlantedPktCd;
	private String jkSlantedPktNm;
	private BigDecimal jkSlantedPktWsWage;
	private Integer jkSlantedPktWsPrice;
	private String jkShinobiPktCd;
	private String jkShinobiPktNm;
	private BigDecimal jkShinobiPktWsWage;
	private Integer jkShinobiPktWsPrice;
	private String jkSleeveTypeCd;
	private String jkSleeveTypeNm;
	private BigDecimal jkSleeveTypeWsWage;
	private Integer jkSleeveTypeWsPrice;
	private String jkManicaCd;
	private String jkManicaNm;
	private BigDecimal jkManicaWsWage;
	private Integer jkManicaWsPrice;
	private String jkSleeveBtnType;
	private Short jkSleeveBtnNumber;
	private String jkSleeveBtnCd;
	private String jkSleeveBtnNm;
	private BigDecimal jkSleeveBtnWsWage;
	private Integer jkSleeveBtnWsPrice;
	private String jkCuffCd;
	private String jkCuffNm;
	private BigDecimal jkCuffWsWage;
	private Integer jkCuffWsPrice;
	private String jkInnerPktType;
	private String jkInnerPktCd;
	private String jkInnerPktNm;
	private BigDecimal jkInnerPktWsWage;
	private Integer jkInnerPktWsPrice;
	private String jkRightInnerPktTypeCd;
	private String jkRightInnerPktTypeNm;
	private BigDecimal jkRightInnerPktTypeWsWage;
	private Integer jkRightInnerPktTypeWsPrice;
	private String jkStitchTypeCd;
	private String jkStitchTypeNm;
	private BigDecimal jkStitchTypeWsWage;
	private Integer jkStitchTypeWsPrice;
	private String jkStitchPlcType;
	private String jkStitchPlcCd;
	private String jkStitchPlcNm;
	private BigDecimal jkStitchPlcWsWage;
	private Integer jkStitchPlcWsPrice;
	private String jkDblstitchPlcType;
	private String jkDblstitchPlcCd;
	private String jkDblstitchPlcNm;
	private BigDecimal jkDblstitchPlcWsWage;
	private Integer jkDblstitchPlcWsPrice;
	private String jkAmfColorType;
	private String jkAmfColorPlcCd;
	private String jkAmfColorPlcNm;
	private String jkAmfColorCd;
	private String jkAmfColorNm;
	private BigDecimal jkAmfColorWsWage;
	private Integer jkAmfColorWsPrice;
	private String jkBtnholeColorType;
	private String jkBtnholeColorPlcCd;
	private String jkBtnholeColorPlcN;
	private String jkBtnholeColorCd;
	private String jkBtnholeColorNm;
	private BigDecimal jkBtnholePlcColorWsWage;
	private Integer jkBtnholePlcColorWsPrice;
	private String jkBtnthreadColorType;
	private String jkBtnthreadColorPlcCd;
	private String jkBtnthreadColorPlcN;
	private String jkBtnthreadColorCd;
	private String jkBtnthreadColorNm;
	private BigDecimal jkBtnthreadPlcColorWsWage;
	private Integer jkBtnthreadPlcColorWsPrice;
	private String jkVentCd;
	private String jkVentNm;
	private BigDecimal jkVentWsWage;
	private Integer jkVentWsPrice;
	private String jkInnerBodyClothType;
	private String jkInnerBodyClothCd;
	private String jkInnerBodyClothNm;
	private BigDecimal jkInnerBodyClothWsWage;
	private Integer jkInnerBodyClothWsPrice;
	private String jkInnerSleeveClothType;
	private String jkInnerSleeveClothCd;
	private String jkInnerSleeveClothNm;
	private BigDecimal jkInnerSleeveClothWsWage;
	private Integer jkInnerSleeveClothWsPrice;
	private String jkBtnMaterialType;
	private String jkBtnMaterialCd;
	private String jkBtnMaterialNm;
	private BigDecimal jkBtnMaterialWsWage;
	private Integer jkBtnMaterialWsPrice;
	private String jkShapeMemoryCd;
	private String jkShapeMemoryNm;
	private BigDecimal jkShapeMemoryWsWage;
	private Integer jkShapeMemoryWsPrice;
	private String ptModelCd;
	private String ptModelNm;
	private BigDecimal ptModelWsWage;
	private Integer ptModelWsPrice;
	private String ptTackCd;
	private String ptTackNm;
	private BigDecimal ptTackWsWage;
	private Integer ptTackWsPrice;
	private String ptKneeinnerTypeCd;
	private String ptKneeinnerTypeNm;
	private BigDecimal ptKneeinnerTypeWsWage;
	private Integer ptKneeinnerTypeWsPrice;
	private String ptKneeinnerClothCd;
	private String ptKneeinnerClothNm;
	private BigDecimal ptKneeinnerClothWsWage;
	private Integer ptKneeinnerClothWsPrice;
	private String ptFrtTypeCd;
	private String ptFrtTypeNm;
	private BigDecimal ptFrtTypeWsWage;
	private Integer ptFrtTypeWsPrice;
	private String ptPancherinaCd;
	private String ptPancherinaNm;
	private BigDecimal ptPancherinaWsWage;
	private Integer ptPancherinaWsPrice;
	private String ptAdjusterCd;
	private String ptAdjusterNm;
	private BigDecimal ptAdjusterWsWage;
	private Integer ptAdjusterWsPrice;
	private String ptBeltloopType;
	private String ptBeltloopCd;
	private String ptBeltloopNm;
	private BigDecimal ptBeltloopWsWage;
	private Integer ptBeltloopWsPrice;
	private String ptPinloopCd;
	private String ptPinloopNm;
	private BigDecimal ptPinloopWsWage;
	private Integer ptPinloopWsPrice;
	private String ptSidePktCd;
	private String ptSidePktNm;
	private BigDecimal ptSidePktWsWage;
	private Integer ptSidePktWsPrice;
	private String ptShinobiPktCd;
	private String ptShinobiPktNm;
	private BigDecimal ptShinobiPktWsWage;
	private Integer ptShinobiPktWsPrice;
	private String ptCoinPktCd;
	private String ptCoinPktNm;
	private BigDecimal ptCoinPktWsWage;
	private Integer ptCoinPktWsPrice;
	private String ptFlapcoinPktCd;
	private String ptFlapcoinPktNm;
	private BigDecimal ptFlapcoinPktWsWage;
	private Integer ptFlapcoinPktWsPrice;
	private String ptLeftPisPktCd;
	private String ptLeftPisPktNm;
	private BigDecimal ptLeftPisPktWsWage;
	private Integer ptLeftPisPktWsPrice;
	private String ptRightPisPktCd;
	private String ptRightPisPktNm;
	private BigDecimal ptRightPisPktWsWage;
	private Integer ptRightPisPktWsPrice;
	private String ptVCutCd;
	private String ptVCutNm;
	private BigDecimal ptVCutWsWage;
	private Integer ptVCutWsPrice;
	private String ptHemUpCd;
	private String ptHemUpNm;
	private BigDecimal ptHemUpWsWage;
	private Integer ptHemUpWsPrice;
	private String ptDblWidthCd;
	private String ptDblWidthNm;
	private BigDecimal ptDblWidthWsWage;
	private Integer ptDblWidthWsPrice;
	private String ptAmfStitchCd;
	private String ptAmfStitchNm;
	private BigDecimal ptAmfStitchWsWage;
	private Integer ptAmfStitchWsPrice;
	private String ptStitchPlcType;
	private String ptStitchPlcCd;
	private String ptStitchPlcNm;
	private BigDecimal ptStitchPlcWsWage;
	private Integer ptStitchPlcWsPrice;
	private String ptDblstitchPlcType;
	private String ptDblstitchPlcCd;
	private String ptDblstitchPlcNm;
	private BigDecimal ptDblstitchPlcWsWage;
	private Integer ptDblstitchPlcWsPrice;
	private String ptAmfColorType;
	private String ptAmfColorPlcCd;
	private String ptAmfColorPlcNm;
	private String ptAmfColorCd;
	private String ptAmfColorNm;
	private BigDecimal ptAmfColorWsWage;
	private Integer ptAmfColorWsPrice;
	private String ptBtnholeColorType;
	private String ptBtnholeColorPlcCd;
	private String ptBtnholeColorPlcNm;
	private String ptBtnholeColorCd;
	private String ptBtnholeColorNm;
	private BigDecimal ptBtnholeColorWsWage;
	private Integer ptBtnholeColorWsPrice;
	private String ptBtnthreadColorType;
	private String ptBtnthreadColorPlcCd;
	private String ptBtnthreadColorPlcNm;
	private String ptBtnthreadColorCd;
	private String ptBtnthreadColorNm;
	private BigDecimal ptBtnthreadColorWsWage;
	private Integer ptBtnthreadColorWsPrice;
	private String ptBtnMaterialType;
	private String ptBtnMaterialCd;
	private String ptBtnMaterialNm;
	private BigDecimal ptBtnMaterialWsWage;
	private Integer ptBtnMaterialWsPrice;
	private String ptSuspenderBtnCd;
	private String ptSuspenderBtnNm;
	private BigDecimal ptSuspenderBtnWsWage;
	private Integer ptSuspenderBtnWsPrice;
	private String ptNonSlipCd;
	private String ptNonSlipNm;
	private BigDecimal ptNonSlipWsWage;
	private Integer ptNonSlipWsPrice;
	private String ptChicSlipCd;
	private String ptChicSlipNm;
	private BigDecimal ptChicSlipWsWage;
	private Integer ptChicSlipWsPrice;
	private String ptShapeMemoryCd;
	private String ptShapeMemoryNm;
	private BigDecimal ptShapeMemoryWsWage;
	private Integer ptShapeMemoryWsPrice;
	private String ptShoeSoreCd;
	private String ptShoeSoreNm;
	private BigDecimal ptShoeSoreWsWage;
	private Integer ptShoeSoreWsPrice;
	private String ptSideStripeCd;
	private String ptSideStripeNm;
	private BigDecimal ptSideStripeWsWage;
	private Integer ptSideStripeWsPrice;
	private String ptSideStripeWidthCd;
	private String ptSideStripeWidthNm;
	private BigDecimal ptSideStripeWidthWsWage;
	private Integer ptSideStripeWidthWsPrice;
	private String pt2ModelCd;
	private String pt2ModelNm;
	private BigDecimal pt2ModelWsWage;
	private Integer pt2ModelWsPrice;
	private String pt2TackCd;
	private String pt2TackNm;
	private BigDecimal pt2TackWsWage;
	private Integer pt2TackWsPrice;
	private String pt2KneeinnerTypeCd;
	private String pt2KneeinnerTypeNm;
	private BigDecimal pt2KneeinnerTypeWsWage;
	private Integer pt2KneeinnerTypeWsPrice;
	private String pt2KneeinnerClothCd;
	private String pt2KneeinnerClothNm;
	private BigDecimal pt2KneeinnerClothWsWage;
	private Integer pt2KneeinnerClothWsPrice;
	private String pt2FrtTypeCd;
	private String pt2FrtTypeNm;
	private BigDecimal pt2FrtTypeWsWage;
	private Integer pt2FrtTypeWsPrice;
	private String pt2PancherinaCd;
	private String pt2PancherinaNm;
	private BigDecimal pt2PancherinaWsWage;
	private Integer pt2PancherinaWsPrice;
	private String pt2AdjusterCd;
	private String pt2AdjusterNm;
	private BigDecimal pt2AdjusterWsWage;
	private Integer pt2AdjusterWsPrice;
	private String pt2BeltloopType;
	private String pt2BeltloopCd;
	private String pt2BeltloopNm;
	private BigDecimal pt2BeltloopWsWage;
	private Integer pt2BeltloopWsPrice;
	private String pt2PinloopCd;
	private String pt2PinloopNm;
	private BigDecimal pt2PinloopWsWage;
	private Integer pt2PinloopWsPrice;
	private String pt2SidePktCd;
	private String pt2SidePktNm;
	private BigDecimal pt2SidePktWsWage;
	private Integer pt2SidePktWsPrice;
	private String pt2ShinobiPktCd;
	private String pt2ShinobiPktNm;
	private BigDecimal pt2ShinobiPktWsWage;
	private Integer pt2ShinobiPktWsPrice;
	private String pt2CoinPktCd;
	private String pt2CoinPktNm;
	private BigDecimal pt2CoinPktWsWage;
	private Integer pt2CoinPktWsPrice;
	private String pt2FlapcoinPktCd;
	private String pt2FlapcoinPktNm;
	private BigDecimal pt2FlapcoinPktWsWage;
	private Integer pt2FlapcoinPktWsPrice;
	private String pt2LeftPisPktCd;
	private String pt2LeftPisPktNm;
	private BigDecimal pt2LeftPisPktWsWage;
	private Integer pt2LeftPisPktWsPrice;
	private String pt2RightPisPktCd;
	private String pt2RightPisPktNm;
	private BigDecimal pt2RightPisPktWsWage;
	private Integer pt2RightPisPktWsPrice;
	private String pt2VCutCd;
	private String pt2VCutNm;
	private BigDecimal pt2VCutWsWage;
	private Integer pt2VCutWsPrice;
	private String pt2HemUpCd;
	private String pt2HemUpNm;
	private BigDecimal pt2HemUpWsWage;
	private Integer pt2HemUpWsPrice;
	private String pt2DblWidthCd;
	private String pt2DblWidthNm;
	private BigDecimal pt2DblWidthWsWage;
	private Integer pt2DblWidthWsPrice;
	private String pt2AmfStitchCd;
	private String pt2AmfStitchNm;
	private BigDecimal pt2AmfStitchWsWage;
	private Integer pt2AmfStitchWsPrice;
	private String pt2StitchPlcType;
	private String pt2StitchPlcCd;
	private String pt2StitchPlcNm;
	private BigDecimal pt2StitchPlcWsWage;
	private Integer pt2StitchPlcWsPrice;
	private String pt2DblstitchPlcType;
	private String pt2DblstitchPlcCd;
	private String pt2DblstitchPlcNm;
	private BigDecimal pt2DblstitchPlcWsWage;
	private Integer pt2DblstitchPlcWsPrice;
	private String pt2AmfColorType;
	private String pt2AmfColorPlcCd;
	private String pt2AmfColorPlcNm;
	private String pt2AmfColorCd;
	private String pt2AmfColorNm;
	private BigDecimal pt2AmfColorWsWage;
	private Integer pt2AmfColorWsPrice;
	private String pt2BtnholeColorType;
	private String pt2BtnholeColorPlcCd;
	private String pt2BtnholeColorPlcNm;
	private String pt2BtnholeColorCd;
	private String pt2BtnholeColorNm;
	private BigDecimal pt2BtnholeColorWsWage;
	private Integer pt2BtnholeColorWsPrice;
	private String pt2BtnthreadColorType;
	private String pt2BtnthreadColorPlcCd;
	private String pt2BtnthreadColorPlcNm;
	private String pt2BtnthreadColorCd;
	private String pt2BtnthreadColorNm;
	private BigDecimal pt2BtnthreadColorWsWage;
	private Integer pt2BtnthreadColorWsPrice;
	private String pt2BtnMaterialType;
	private String pt2BtnMaterialCd;
	private String pt2BtnMaterialNm;
	private BigDecimal pt2BtnMaterialWsWage;
	private Integer pt2BtnMaterialWsPrice;
	private String pt2SuspenderBtnCd;
	private String pt2SuspenderBtnNm;
	private BigDecimal pt2SuspenderBtnWsWage;
	private Integer pt2SuspenderBtnWsPrice;
	private String pt2NonSlipCd;
	private String pt2NonSlipNm;
	private BigDecimal pt2NonSlipWsWage;
	private Integer pt2NonSlipWsPrice;
	private String pt2ChicSlipCd;
	private String pt2ChicSlipNm;
	private BigDecimal pt2ChicSlipWsWage;
	private Integer pt2ChicSlipWsPrice;
	private String pt2ShapeMemoryCd;
	private String pt2ShapeMemoryNm;
	private BigDecimal pt2ShapeMemoryWsWage;
	private Integer pt2ShapeMemoryWsPrice;
	private String pt2ShoeSoreCd;
	private String pt2ShoeSoreNm;
	private BigDecimal pt2ShoeSoreWsWage;
	private Integer pt2ShoeSoreWsPrice;
	private String pt2SideStripeCd;
	private String pt2SideStripeNm;
	private BigDecimal pt2SideStripeWsWage;
	private Integer pt2SideStripeWsPrice;
	private String pt2SideStripeWidthCd;
	private String pt2SideStripeWidthNm;
	private BigDecimal pt2SideStripeWidthWsWage;
	private Integer pt2SideStripeWidthWsPrice;
	private String pt3ModelCd;
	private String pt3ModelNm;
	private BigDecimal pt3ModelWsWage;
	private Integer pt3ModelWsPrice;
	private String pt3TackCd;
	private String pt3TackNm;
	private BigDecimal pt3TackWsWage;
	private Integer pt3TackWsPrice;
	private String pt3KneeinnerTypeCd;
	private String pt3KneeinnerTypeNm;
	private BigDecimal pt3KneeinnerTypeWsWage;
	private Integer pt3KneeinnerTypeWsPrice;
	private String pt3KneeinnerClothCd;
	private String pt3KneeinnerClothNm;
	private BigDecimal pt3KneeinnerClothWsWage;
	private Integer pt3KneeinnerClothWsPrice;
	private String pt3FrtTypeCd;
	private String pt3FrtTypeNm;
	private BigDecimal pt3FrtTypeWsWage;
	private Integer pt3FrtTypeWsPrice;
	private String pt3PancherinaCd;
	private String pt3PancherinaNm;
	private BigDecimal pt3PancherinaWsWage;
	private Integer pt3PancherinaWsPrice;
	private String pt3AdjusterCd;
	private String pt3AdjusterNm;
	private BigDecimal pt3AdjusterWsWage;
	private Integer pt3AdjusterWsPrice;
	private String pt3BeltloopType;
	private String pt3BeltloopCd;
	private String pt3BeltloopNm;
	private BigDecimal pt3BeltloopWsWage;
	private Integer pt3BeltloopWsPrice;
	private String pt3PinloopCd;
	private String pt3PinloopNm;
	private BigDecimal pt3PinloopWsWage;
	private Integer pt3PinloopWsPrice;
	private String pt3SidePktCd;
	private String pt3SidePktNm;
	private BigDecimal pt3SidePktWsWage;
	private Integer pt3SidePktWsPrice;
	private String pt3ShinobiPktCd;
	private String pt3ShinobiPktNm;
	private BigDecimal pt3ShinobiPktWsWage;
	private Integer pt3ShinobiPktWsPrice;
	private String pt3CoinPktCd;
	private String pt3CoinPktNm;
	private BigDecimal pt3CoinPktWsWage;
	private Integer pt3CoinPktWsPrice;
	private String pt3FlapcoinPktCd;
	private String pt3FlapcoinPktNm;
	private BigDecimal pt3FlapcoinPktWsWage;
	private Integer pt3FlapcoinPktWsPrice;
	private String pt3LeftPisPktCd;
	private String pt3LeftPisPktNm;
	private BigDecimal pt3LeftPisPktWsWage;
	private Integer pt3LeftPisPktWsPrice;
	private String pt3RightPisPktCd;
	private String pt3RightPisPktNm;
	private BigDecimal pt3RightPisPktWsWage;
	private Integer pt3RightPisPktWsPrice;
	private String pt3VCutCd;
	private String pt3VCutNm;
	private BigDecimal pt3VCutWsWage;
	private Integer pt3VCutWsPrice;
	private String pt3HemUpCd;
	private String pt3HemUpNm;
	private BigDecimal pt3HemUpWsWage;
	private Integer pt3HemUpWsPrice;
	private String pt3DblWidthCd;
	private String pt3DblWidthNm;
	private BigDecimal pt3DblWidthWsWage;
	private Integer pt3DblWidthWsPrice;
	private String pt3AmfStitchCd;
	private String pt3AmfStitchNm;
	private BigDecimal pt3AmfStitchWsWage;
	private Integer pt3AmfStitchWsPrice;
	private String pt3StitchPlcType;
	private String pt3StitchPlcCd;
	private String pt3StitchPlcNm;
	private BigDecimal pt3StitchPlcWsWage;
	private Integer pt3StitchPlcWsPrice;
	private String pt3DblstitchPlcType;
	private String pt3DblstitchPlcCd;
	private String pt3DblstitchPlcNm;
	private BigDecimal pt3DblstitchPlcWsWage;
	private Integer pt3DblstitchPlcWsPrice;
	private String pt3AmfColorType;
	private String pt3AmfColorPlcCd;
	private String pt3AmfColorPlcNm;
	private String pt3AmfColorCd;
	private String pt3AmfColorNm;
	private BigDecimal pt3AmfColorWsWage;
	private Integer pt3AmfColorWsPrice;
	private String pt3BtnholeColorType;
	private String pt3BtnholeColorPlcCd;
	private String pt3BtnholeColorPlcNm;
	private String pt3BtnholeColorCd;
	private String pt3BtnholeColorNm;
	private BigDecimal pt3BtnholeColorWsWage;
	private Integer pt3BtnholeColorWsPrice;
	private String pt3BtnthreadColorType;
	private String pt3BtnthreadColorPlcCd;
	private String pt3BtnthreadColorPlcNm;
	private String pt3BtnthreadColorCd;
	private String pt3BtnthreadColorNm;
	private BigDecimal pt3BtnthreadColorWsWage;
	private Integer pt3BtnthreadColorWsPrice;
	private String pt3BtnMaterialType;
	private String pt3BtnMaterialCd;
	private String pt3BtnMaterialNm;
	private BigDecimal pt3BtnMaterialWsWage;
	private Integer pt3BtnMaterialWsPrice;
	private String pt3SuspenderBtnCd;
	private String pt3SuspenderBtnNm;
	private BigDecimal pt3SuspenderBtnWsWage;
	private Integer pt3SuspenderBtnWsPrice;
	private String pt3NonSlipCd;
	private String pt3NonSlipNm;
	private BigDecimal pt3NonSlipWsWage;
	private Integer pt3NonSlipWsPrice;
	private String pt3ChicSlipCd;
	private String pt3ChicSlipNm;
	private BigDecimal pt3ChicSlipWsWage;
	private Integer pt3ChicSlipWsPrice;
	private String pt3ShapeMemoryCd;
	private String pt3ShapeMemoryNm;
	private BigDecimal pt3ShapeMemoryWsWage;
	private Integer pt3ShapeMemoryWsPrice;
	private String pt3ShoeSoreCd;
	private String pt3ShoeSoreNm;
	private BigDecimal pt3ShoeSoreWsWage;
	private Integer pt3ShoeSoreWsPrice;
	private String pt3SideStripeCd;
	private String pt3SideStripeNm;
	private BigDecimal pt3SideStripeWsWage;
	private Integer pt3SideStripeWsPrice;
	private String pt3SideStripeWidthCd;
	private String pt3SideStripeWidthNm;
	private BigDecimal pt3SideStripeWidthWsWage;
	private Integer pt3SideStripeWidthWsPrice;
	private String glModelCd;
	private String glModelNm;
	private BigDecimal glModelWsWage;
	private Integer glModelWsPrice;
	private String glBreastPktCd;
	private String glBreastPktNm;
	private BigDecimal glBreastPktWsWage;
	private Integer glBreastPktWsPrice;
	private String glWaistPktCd;
	private String glWaistPktNm;
	private BigDecimal glWaistPktWsWage;
	private Integer glWaistPktWsPrice;
	private String glWaistPktShapeCd;
	private String glWaistPktShapeNm;
	private BigDecimal glWaistPktShapeWsWage;
	private Integer glWaistPktShapeWsPrice;
	private String glWaistPktClothCd;
	private String glWaistPktClothNm;
	private BigDecimal glWaistPktClothWsWage;
	private Integer glWaistPktClothWsPrice;
	private String glAmfStitchCd;
	private String glAmfStitchNm;
	private BigDecimal glAmfStitchWsWage;
	private Integer glAmfStitchWsPrice;
	private String glStitchPlcType;
	private String glStitchPlcCd;
	private String glStitchPlcNm;
	private BigDecimal glStitchPlcWsWage;
	private Integer glStitchPlcWsPrice;
	private String glDblstitchPlcType;
	private String glDblstitchPlcCd;
	private String glDblstitchPlcNm;
	private BigDecimal glDblstitchPlcWsWage;
	private Integer glDblstitchPlcWsPrice;
	private String glAmfColorType;
	private String glAmfColorPlcCd;
	private String glAmfColorPlcNm;
	private String glAmfColorCd;
	private String glAmfColorNm;
	private BigDecimal glAmfColorWsWage;
	private Integer glAmfColorWsPrice;
	private String glBtnholeColorType;
	private String glBtnholeColorPlcCd;
	private String glBtnholeColorPlcNm;
	private String glBtnholeColorCd;
	private String glBtnholeColorNm;
	private BigDecimal glBtnholeColorWsWage;
	private Integer glBtnholeColorWsPrice;
	private String glBtnthreadColorType;
	private String glBtnthreadColorPlcCd;
	private String glBtnthreadColorPlcNm;
	private String glBtnthreadColorCd;
	private String glBtnthreadColorNm;
	private BigDecimal glBtnthreadColorWsWage;
	private Integer glBtnthreadColorWsPrice;
	private String glBackClothType;
	private String glBackClothCd;
	private String glBackClothNm;
	private BigDecimal glBackClothWsWage;
	private Integer glBackClothWsPrice;
	private String glInnnerClothType;
	private String glInnnerClothCd;
	private String glInnnerClothNm;
	private BigDecimal glInnnerClothWsWage;
	private Integer glInnnerClothWsPrice;
	private String glFrtBtnType;
	private String glFrtBtnCd;
	private String glFrtBtnNm;
	private BigDecimal glFrtBtnWsWage;
	private Integer glFrtBtnWsPrice;
	private String glBackBeltCd;
	private String glBackBeltNm;
	private BigDecimal glBackBeltWsWage;
	private Integer glBackBeltWsPrice;
	private String glWatchChainCd;
	private String glWatchChainNm;
	private BigDecimal glWatchChainWsWage;
	private Integer glWatchChainWsPrice;
	private String ctModelCd;
	private String ctModelNm;
	private BigDecimal ctModelWsWage;
	private Integer ctModelWsPrice;
	private String ctLapelDesignCd;
	private String ctLapelDesignNm;
	private BigDecimal ctLapelDesignWsWage;
	private Integer ctLapelDesignWsPrice;
	private String ctSleeveTypeCd;
	private String ctSleeveTypeNm;
	private BigDecimal ctSleeveTypeWsWage;
	private Integer ctSleeveTypeWsPrice;
	private String ctWaistPktCd;
	private String ctWaistPktNm;
	private BigDecimal ctWaistPktWsWage;
	private Integer ctWaistPktWsPrice;
	private String ctChgPktCd;
	private String ctChgPktNm;
	private BigDecimal ctChgPktWsWage;
	private Integer ctChgPktWsPrice;
	private String ctSlantedPktCd;
	private String ctSlantedPktNm;
	private BigDecimal ctSlantedPktWsWage;
	private Integer ctSlantedPktWsPrice;
	private String ctVentCd;
	private String ctVentNm;
	private BigDecimal ctVentWsWage;
	private Integer ctVentWsPrice;
	private String ctFrtBtnCd;
	private String ctFrtBtnNm;
	private BigDecimal ctFrtBtnWsWage;
	private Integer ctFrtBtnWsPrice;
	private String ctCuffCd;
	private String ctCuffNm;
	private BigDecimal ctCuffWsWage;
	private Integer ctCuffWsPrice;
	private String ctSleeveBtnCd;
	private String ctSleeveBtnNm;
	private BigDecimal ctSleeveBtnWsWage;
	private Integer ctSleeveBtnWsPrice;
	private String ctBackBeltCd;
	private String ctBackBeltNm;
	private BigDecimal ctBackBeltWsWage;
	private Integer ctBackBeltWsPrice;
	private String ctCollarHangCd;
	private String ctCollarHangNm;
	private BigDecimal ctCollarHangWsWage;
	private Integer ctCollarHangWsPrice;
	private String ctInnerBodyClothCd;
	private String ctInnerBodyClothNm;
	private BigDecimal ctInnerBodyClothWsWage;
	private Integer ctInnerBodyClothWsPrice;
	private String ctInnerSleeveClothCd;
	private String ctInnerSleeveClothNm;
	private BigDecimal ctInnerSleeveClothWsWage;
	private Integer ctInnerSleeveClothWsPrice;
	private String ctBtnMaterialCd;
	private String ctBtnMaterialNm;
	private BigDecimal ctBtnMaterialWsWage;
	private Integer ctBtnMaterialWsPrice;
	private String stModelCd;
	private String stModelNm;
	private BigDecimal stModelWsWage;
	private Integer stModelWsPrice;
	private String stCasualHemlineCd;
	private BigDecimal stCasualHemlineSize;
	private String stCasualHemlineNm;
	private BigDecimal stCasualHemlineWsWage;
	private Integer stCasualHemlineWsPrice;
	private String stCollarTypeCd;
	private String stCollarTypeNm;
	private BigDecimal stCollarTypeWsWage;
	private Integer stCollarTypeWsPrice;
	private String stCuffsCd;
	private String stCuffsNm;
	private BigDecimal stCuffsWsWage;
	private Integer stCuffsWsPrice;
	private String stConvertibleCd;
	private String stConvertibleNm;
	private BigDecimal stConvertibleWsWage;
	private Integer stConvertibleWsPrice;
	private String stAdjusterBtnCd;
	private String stAdjusterBtnNm;
	private BigDecimal stAdjusterBtnWsWage;
	private Integer stAdjusterBtnWsPrice;
	private String stDblCuffsCd;
	private String stDblCuffsNm;
	private BigDecimal stDblCuffsWsWage;
	private Integer stDblCuffsWsPrice;
	private String stClericCd;
	private String stClericNm;
	private BigDecimal stClericWsWage;
	private Integer stClericWsPrice;
	private String stCuffsBtnCd;
	private String stCuffsBtnNm;
	private BigDecimal stCuffsBtnWsWage;
	private Integer stCuffsBtnWsPrice;
	private String stSleeveClericcd;
	private String stSleeveClericnm;
	private BigDecimal stSleeveClericwsWage;
	private Integer stSleeveClericwsPrice;
	private String stBtnMaterialCd;
	private String stBtnMaterialNm;
	private BigDecimal stBtnMaterialWsWage;
	private Integer stBtnMaterialWsPrice;
	private String stDblBtnCd;
	private String stDblBtnNm;
	private BigDecimal stDblBtnWsWage;
	private Integer stDblBtnWsPrice;
	private String stGauntletBtnPosCd;
	private String stGauntletBtnPosNm;
	private BigDecimal stGauntletBtnPosWsWage;
	private Integer stGauntletBtnPosWsPrice;
	private String stPinholePinCd;
	private String stPinholePinNm;
	private BigDecimal stPinholePinWsWage;
	private Integer stPinholePinWsPrice;
	private String stBreastPktCd;
	private String stBreastPktNm;
	private BigDecimal stBreastPktWsWage;
	private Integer stBreastPktWsPrice;
	private String stBreastSizeCd;
	private String stBreastSizeNm;
	private BigDecimal stBreastSizeWsWage;
	private Integer stBreastSizeWsPrice;
	private String stFrtDesignCd;
	private String stFrtDesignNm;
	private BigDecimal stFrtDesignWsWage;
	private Integer stFrtDesignWsPrice;
	private String stPintuckBosomCd;
	private String stPintuckBosomNm;
	private BigDecimal stPintuckBosomWsWage;
	private Integer stPintuckBosomWsPrice;
	private String stStitchCd;
	private String stStitchNm;
	private BigDecimal stStitchWsWage;
	private Integer stStitchWsPrice;
	private String stColarKeeperCd;
	private String stColarKeeperNm;
	private BigDecimal stColarKeeperWsWage;
	private Integer stColarKeeperWsPrice;
	private String stBtnthreadColorCd;
	private String stBtnthreadColorNm;
	private BigDecimal stBtnthreadColorWsWage;
	private Integer stBtnthreadColorWsPrice;
	private String stBtnholeColorCd;
	private String stBtnholeColorNm;
	private BigDecimal stBtnholeColorWsWage;
	private Integer stBtnholeColorWsPrice;
	private String stBtnposChgCd;
	private String stBtnposChgNm;
	private BigDecimal stBtnposChgWsWage;
	private Integer stBtnposChgWsPrice;
	private String stNeckbandBtnChgCd;
	private String stNeckbandBtnChgNm;
	private BigDecimal stNeckbandBtnChgWsWage;
	private Integer stNeckbandBtnChgWsPrice;
	private BigDecimal stNeckbandBtnPosChg;
	private String stFrtfirstBtnChgCd;
	private String stFrtfirstBtnChgNm;
	private BigDecimal stFrtfirstBtnChgWsWage;
	private Integer stFrtfirstBtnChgWsPrice;
	private BigDecimal stFrtfirstBtnPosChg;
	private String stFrtsecondBtnChgCd;
	private String stFrtsecondBtnChgNm;
	private BigDecimal stFrtsecondBtnChgWsWage;
	private Integer stFrtsecondBtnChgWsPrice;
	private BigDecimal stFrtsecondBtnPosChg;
	private String corJkDrop;
	private String corJkSize;
	private BigDecimal corJkBodylengthSize;
	private BigDecimal corJkBodylengthCorrect;
	private BigDecimal corJkBodylengthGross;
	private BigDecimal corJkWaistSize;
	private BigDecimal corJkWaistCorrect;
	private BigDecimal corJkWaistGross;
	private BigDecimal corJkRightsleeveSize;
	private BigDecimal corJkRightsleeveCorrect;
	private BigDecimal corJkRightsleeveGross;
	private BigDecimal corJkLeftsleeveSize;
	private BigDecimal corJkLeftsleeveCorrect;
	private BigDecimal corJkLeftsleeveGross;
	private String corJkShoulderpad;
	private String corJkFigureCorrect;
	private String corPtDrop;
	private String corPtSize;
	private BigDecimal corPtWaistSize;
	private BigDecimal corPtWaistCorrect;
	private BigDecimal corPtWaistGross;
	private BigDecimal corPtHipSize;
	private BigDecimal corPtHipCorrect;
	private BigDecimal corPtHipGross;
	private BigDecimal corPtThighwidthSize;
	private BigDecimal corPtThighwidthCorrect;
	private BigDecimal corPtThighwidthGross;
	private String corPtHemwidthType;
	private BigDecimal corPtHemwidthSize;
	private BigDecimal corPtHemwidthCorrect;
	private BigDecimal corPtHemwidthGross;
	private BigDecimal corPtHemwidthDegignate;
	private BigDecimal corPtRightinseamSize;
	private BigDecimal corPtRightinseamCorrect;
	private BigDecimal corPtRightinseamGross;
	private BigDecimal corPtLeftinseamSize;
	private BigDecimal corPtLeftinseamCorrect;
	private BigDecimal corPtLeftinseamGross;
	private String corPt2Drop;
	private String corPt2Size;
	private BigDecimal corPt2WaistSize;
	private BigDecimal corPt2WaistCorrect;
	private BigDecimal corPt2WaistGross;
	private BigDecimal corPt2HipSize;
	private BigDecimal corPt2HipCorrect;
	private BigDecimal corPt2HipGross;
	private BigDecimal corPt2ThighwidthSize;
	private BigDecimal corPt2ThighwidthCorrect;
	private BigDecimal corPt2ThighwidthGross;
	private String corPt2HemwidthType;
	private BigDecimal corPt2HemwidthSize;
	private BigDecimal corPt2HemwidthCorrect;
	private BigDecimal corPt2HemwidthGross;
	private BigDecimal corPt2HemwidthDegignate;
	private BigDecimal corPt2RightinseamSize;
	private BigDecimal corPt2RightinseamCorrect;
	private BigDecimal corPt2RightinseamGross;
	private BigDecimal corPt2LeftinseamSize;
	private BigDecimal corPt2LeftinseamCorrect;
	private BigDecimal corPt2LeftinseamGross;
	private String corGlDrop;
	private String corGlSize;
	private BigDecimal corGlBodylengthSize;
	private BigDecimal corGlBodylengthCorrect;
	private BigDecimal corGlBodylengthGross;
	private BigDecimal corGlBustSize;
	private BigDecimal corGlBustCorrect;
	private BigDecimal corGlBustGross;
	private BigDecimal corGlWaistSize;
	private BigDecimal corGlWaistCorrect;
	private BigDecimal corGlWaistGross;
	private String corCtSize;
	private BigDecimal corCtBodylengthSize;
	private BigDecimal corCtBodylengthCorrect;
	private BigDecimal corCtBodylengthGross;
	private BigDecimal corCtWaistSize;
	private BigDecimal corCtWaistCorrect;
	private BigDecimal corCtWaistGross;
	private BigDecimal corCtRightsleeveSize;
	private BigDecimal corCtRightsleeveCorrect;
	private BigDecimal corCtRightsleeveGross;
	private BigDecimal corCtLeftsleeveSize;
	private BigDecimal corCtLeftsleeveCorrect;
	private BigDecimal corCtLeftsleeveGross;
	private BigDecimal corCtVenthightSize;
	private BigDecimal corCtVenthightCorrect;
	private BigDecimal corCtVenthightGross;
	private BigDecimal corCtPktposSize;
	private BigDecimal corCtPktposCorrect;
	private BigDecimal corCtPktposGross;
	private String corStSize;
	private BigDecimal corStNeckSize;
	private BigDecimal corStNeckCorrect;
	private BigDecimal corStNeckGross;
	private BigDecimal corStBodylengthSize;
	private BigDecimal corStBodylengthCorrect;
	private BigDecimal corStBodylengthGross;
	private BigDecimal corStRightsleeveSize;
	private BigDecimal corStRightsleeveCorrect;
	private BigDecimal corStRightsleeveGross;
	private BigDecimal corStLeftsleeveSize;
	private BigDecimal corStLeftsleeveCorrect;
	private BigDecimal corStLeftsleeveGross;
	private BigDecimal corStBackdartsPackSize;
	private BigDecimal corStBackdartsPackCorrect;
	private BigDecimal corStBackdartsPackGross;
	private BigDecimal corStBackdartsUnpackSize;
	private BigDecimal corStBackdartsUnpackCorrect;
	private BigDecimal corStBackdartsUnpackGross;
	private BigDecimal corStRightcuffsSurroundingSize;
	private BigDecimal corStRightcuffsSurroundingCorrect;
	private BigDecimal corStRightcuffsSurroundingGross;
	private BigDecimal corStLeftcuffsSurroundingSize;
	private BigDecimal corStLeftcuffsSurroundingCorrect;
	private BigDecimal corStLeftcuffsSurroundingGross;
	private String corStoreCorrectionMemo;
	private BigDecimal corJkBodylengthCorrectAgain;
	private BigDecimal corJkWaistCorrectAgain;
	private BigDecimal corJkRightsleeveCorrectAgain;
	private BigDecimal corJkLeftsleeveCorrectAgain;
	private BigDecimal corGlBodylengthCorrectAgain;
	private BigDecimal corGlBustCorrectAgain;
	private BigDecimal corGlWaistCorrectAgain;
	private BigDecimal corPtWaistCorrectAgain;
	private BigDecimal corPtHipCorrectAgain;
	private BigDecimal corPtThighwidthCorrectAgain;
	private BigDecimal corPtHemwidthCorrectAgain;
	private BigDecimal corPtRightinseamCorrectAgain;
	private BigDecimal corPtLeftinseamCorrectAgain;
	private BigDecimal corPt2WaistCorrectAgain;
	private BigDecimal corPt2HipCorrectAgain;
	private BigDecimal corPt2ThighwidthCorrectAgain;
	private BigDecimal corPt2HemwidthCorrectAgain;
	private BigDecimal corPt2RightinseamCorrectAgain;
	private BigDecimal corPt2LeftinseamCorrectAgain;
	private String corStoreCorrectionMemoAgain;
	private String hostTransmitARow;
	private String shippingNumber;
	private String factoryShippingMethod;
	private Date shippingDate;
	private Date loadingDate;
	private BigDecimal fabricUsedMount;
	private BigDecimal theoryFabricUsedMount;
	private String tscStatus;
	private String makerFactoryStatus;
	private String send2factoryStatus;
	private String isCancelled;
	private String theoreticalStockCheck;
	private String scheduleDataTransmitStatus;
	private String shippingTransmitStatus;
	private Short version;
	private String createdUserId;
	private Date createdAt;
	private String updatedUserId;
	private Date updatedAt;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderPattern() {
		return orderPattern;
	}
	public void setOrderPattern(String orderPattern) {
		this.orderPattern = orderPattern;
	}
	public String getStoreBrandCode() {
		return storeBrandCode;
	}
	public void setStoreBrandCode(String storeBrandCode) {
		this.storeBrandCode = storeBrandCode;
	}
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public Integer getWsPrice() {
		return wsPrice;
	}
	public void setWsPrice(Integer wsPrice) {
		this.wsPrice = wsPrice;
	}
	public String getStoreNm() {
		return storeNm;
	}
	public void setStoreNm(String storeNm) {
		this.storeNm = storeNm;
	}
	public String getPrintoutCustRomaNm() {
		return printoutCustRomaNm;
	}
	public void setPrintoutCustRomaNm(String printoutCustRomaNm) {
		this.printoutCustRomaNm = printoutCustRomaNm;
	}
	public String getPrintoutStoreStaffRomaNm() {
		return printoutStoreStaffRomaNm;
	}
	public void setPrintoutStoreStaffRomaNm(String printoutStoreStaffRomaNm) {
		this.printoutStoreStaffRomaNm = printoutStoreStaffRomaNm;
	}
	public String getProductItem() {
		return productItem;
	}
	public void setProductItem(String productItem) {
		this.productItem = productItem;
	}
	public String getProductIs3piece() {
		return productIs3piece;
	}
	public void setProductIs3piece(String productIs3piece) {
		this.productIs3piece = productIs3piece;
	}
	public BigDecimal getProductIs3pieceWsWage() {
		return productIs3pieceWsWage;
	}
	public void setProductIs3pieceWsWage(BigDecimal productIs3pieceWsWage) {
		this.productIs3pieceWsWage = productIs3pieceWsWage;
	}
	public Integer getProductIs3pieceWsPrice() {
		return productIs3pieceWsPrice;
	}
	public void setProductIs3pieceWsPrice(Integer productIs3pieceWsPrice) {
		this.productIs3pieceWsPrice = productIs3pieceWsPrice;
	}
	public String getProductSparePantsClass() {
		return productSparePantsClass;
	}
	public void setProductSparePantsClass(String productSparePantsClass) {
		this.productSparePantsClass = productSparePantsClass;
	}
	public BigDecimal getProductSparePantsWsWage() {
		return productSparePantsWsWage;
	}
	public void setProductSparePantsWsWage(BigDecimal productSparePantsWsWage) {
		this.productSparePantsWsWage = productSparePantsWsWage;
	}
	public Integer getProductSparePantsWsPrice() {
		return productSparePantsWsPrice;
	}
	public void setProductSparePantsWsPrice(Integer productSparePantsWsPrice) {
		this.productSparePantsWsPrice = productSparePantsWsPrice;
	}
	public String getProductFabricNo() {
		return productFabricNo;
	}
	public void setProductFabricNo(String productFabricNo) {
		this.productFabricNo = productFabricNo;
	}
	public String getFabricColor() {
		return fabricColor;
	}
	public void setFabricColor(String fabricColor) {
		this.fabricColor = fabricColor;
	}
	public String getFabricPattern() {
		return fabricPattern;
	}
	public void setFabricPattern(String fabricPattern) {
		this.fabricPattern = fabricPattern;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductBrandType() {
		return productBrandType;
	}
	public void setProductBrandType(String productBrandType) {
		this.productBrandType = productBrandType;
	}
	public String getProductBrandNm() {
		return productBrandNm;
	}
	public void setProductBrandNm(String productBrandNm) {
		this.productBrandNm = productBrandNm;
	}
	public String getProductFabricNmNecessity() {
		return productFabricNmNecessity;
	}
	public void setProductFabricNmNecessity(String productFabricNmNecessity) {
		this.productFabricNmNecessity = productFabricNmNecessity;
	}
	public String getProductEmbroideryNecessity() {
		return productEmbroideryNecessity;
	}
	public void setProductEmbroideryNecessity(String productEmbroideryNecessity) {
		this.productEmbroideryNecessity = productEmbroideryNecessity;
	}
	public String getProductEmbroideryNm() {
		return productEmbroideryNm;
	}
	public void setProductEmbroideryNm(String productEmbroideryNm) {
		this.productEmbroideryNm = productEmbroideryNm;
	}
	public String getProductEmbroideryFont() {
		return productEmbroideryFont;
	}
	public void setProductEmbroideryFont(String productEmbroideryFont) {
		this.productEmbroideryFont = productEmbroideryFont;
	}
	public String getProductEmbroideryThreadColor() {
		return productEmbroideryThreadColor;
	}
	public void setProductEmbroideryThreadColor(String productEmbroideryThreadColor) {
		this.productEmbroideryThreadColor = productEmbroideryThreadColor;
	}
	public String getProductEmbroideryGazette() {
		return productEmbroideryGazette;
	}
	public void setProductEmbroideryGazette(String productEmbroideryGazette) {
		this.productEmbroideryGazette = productEmbroideryGazette;
	}
	public BigDecimal getProductEmbroideryGazetteWsWage() {
		return productEmbroideryGazetteWsWage;
	}
	public void setProductEmbroideryGazetteWsWage(BigDecimal productEmbroideryGazetteWsWage) {
		this.productEmbroideryGazetteWsWage = productEmbroideryGazetteWsWage;
	}
	public Integer getProductEmbroideryGazetteWsPrice() {
		return productEmbroideryGazetteWsPrice;
	}
	public void setProductEmbroideryGazetteWsPrice(Integer productEmbroideryGazetteWsPrice) {
		this.productEmbroideryGazetteWsPrice = productEmbroideryGazetteWsPrice;
	}
	public String getProductEmbroideryNmPos() {
		return productEmbroideryNmPos;
	}
	public void setProductEmbroideryNmPos(String productEmbroideryNmPos) {
		this.productEmbroideryNmPos = productEmbroideryNmPos;
	}
	public BigDecimal getProductEmbroideryNmPosWsWage() {
		return productEmbroideryNmPosWsWage;
	}
	public void setProductEmbroideryNmPosWsWage(BigDecimal productEmbroideryNmPosWsWage) {
		this.productEmbroideryNmPosWsWage = productEmbroideryNmPosWsWage;
	}
	public Integer getProductEmbroideryNmPosWsPrice() {
		return productEmbroideryNmPosWsPrice;
	}
	public void setProductEmbroideryNmPosWsPrice(Integer productEmbroideryNmPosWsPrice) {
		this.productEmbroideryNmPosWsPrice = productEmbroideryNmPosWsPrice;
	}
	public BigDecimal getProductEmbroideryLength() {
		return productEmbroideryLength;
	}
	public void setProductEmbroideryLength(BigDecimal productEmbroideryLength) {
		this.productEmbroideryLength = productEmbroideryLength;
	}
	public BigDecimal getProductEmbroideryWidth() {
		return productEmbroideryWidth;
	}
	public void setProductEmbroideryWidth(BigDecimal productEmbroideryWidth) {
		this.productEmbroideryWidth = productEmbroideryWidth;
	}
	public String getProductRemainingClothType() {
		return productRemainingClothType;
	}
	public void setProductRemainingClothType(String productRemainingClothType) {
		this.productRemainingClothType = productRemainingClothType;
	}
	public String getProductRemainingClothNm() {
		return productRemainingClothNm;
	}
	public void setProductRemainingClothNm(String productRemainingClothNm) {
		this.productRemainingClothNm = productRemainingClothNm;
	}
	public String getProductFabricBrandNm() {
		return productFabricBrandNm;
	}
	public void setProductFabricBrandNm(String productFabricBrandNm) {
		this.productFabricBrandNm = productFabricBrandNm;
	}
	public String getProductServiceNm() {
		return productServiceNm;
	}
	public void setProductServiceNm(String productServiceNm) {
		this.productServiceNm = productServiceNm;
	}
	public String getProductComposFrtFabric() {
		return productComposFrtFabric;
	}
	public void setProductComposFrtFabric(String productComposFrtFabric) {
		this.productComposFrtFabric = productComposFrtFabric;
	}
	public String getProductComposBodyLiner() {
		return productComposBodyLiner;
	}
	public void setProductComposBodyLiner(String productComposBodyLiner) {
		this.productComposBodyLiner = productComposBodyLiner;
	}
	public String getProductComposSleeveLiner() {
		return productComposSleeveLiner;
	}
	public void setProductComposSleeveLiner(String productComposSleeveLiner) {
		this.productComposSleeveLiner = productComposSleeveLiner;
	}
	public String getProductNotice() {
		return productNotice;
	}
	public void setProductNotice(String productNotice) {
		this.productNotice = productNotice;
	}
	public String getProductFactoryCd() {
		return productFactoryCd;
	}
	public void setProductFactoryCd(String productFactoryCd) {
		this.productFactoryCd = productFactoryCd;
	}
	public String getProductMakerCode() {
		return productMakerCode;
	}
	public void setProductMakerCode(String productMakerCode) {
		this.productMakerCode = productMakerCode;
	}
	public Date getProductOrderdDate() {
		return productOrderdDate;
	}
	public void setProductOrderdDate(Date productOrderdDate) {
		this.productOrderdDate = productOrderdDate;
	}
	public String getJkModelCd() {
		return jkModelCd;
	}
	public void setJkModelCd(String jkModelCd) {
		this.jkModelCd = jkModelCd;
	}
	public String getJkModelNm() {
		return jkModelNm;
	}
	public void setJkModelNm(String jkModelNm) {
		this.jkModelNm = jkModelNm;
	}
	public BigDecimal getJkModelWsWage() {
		return jkModelWsWage;
	}
	public void setJkModelWsWage(BigDecimal jkModelWsWage) {
		this.jkModelWsWage = jkModelWsWage;
	}
	public Integer getJkModelWsPrice() {
		return jkModelWsPrice;
	}
	public void setJkModelWsPrice(Integer jkModelWsPrice) {
		this.jkModelWsPrice = jkModelWsPrice;
	}
	public String getJkFrtBtnCd() {
		return jkFrtBtnCd;
	}
	public void setJkFrtBtnCd(String jkFrtBtnCd) {
		this.jkFrtBtnCd = jkFrtBtnCd;
	}
	public String getJkFrtBtnNm() {
		return jkFrtBtnNm;
	}
	public void setJkFrtBtnNm(String jkFrtBtnNm) {
		this.jkFrtBtnNm = jkFrtBtnNm;
	}
	public BigDecimal getJkFrtBtnWsWage() {
		return jkFrtBtnWsWage;
	}
	public void setJkFrtBtnWsWage(BigDecimal jkFrtBtnWsWage) {
		this.jkFrtBtnWsWage = jkFrtBtnWsWage;
	}
	public Integer getJkFrtBtnWsPrice() {
		return jkFrtBtnWsPrice;
	}
	public void setJkFrtBtnWsPrice(Integer jkFrtBtnWsPrice) {
		this.jkFrtBtnWsPrice = jkFrtBtnWsPrice;
	}
	public String getJkLapelDesignCd() {
		return jkLapelDesignCd;
	}
	public void setJkLapelDesignCd(String jkLapelDesignCd) {
		this.jkLapelDesignCd = jkLapelDesignCd;
	}
	public String getJkLapelDesignNm() {
		return jkLapelDesignNm;
	}
	public void setJkLapelDesignNm(String jkLapelDesignNm) {
		this.jkLapelDesignNm = jkLapelDesignNm;
	}
	public BigDecimal getJkLapelDesignWsWage() {
		return jkLapelDesignWsWage;
	}
	public void setJkLapelDesignWsWage(BigDecimal jkLapelDesignWsWage) {
		this.jkLapelDesignWsWage = jkLapelDesignWsWage;
	}
	public Integer getJkLapelDesignWsPrice() {
		return jkLapelDesignWsPrice;
	}
	public void setJkLapelDesignWsPrice(Integer jkLapelDesignWsPrice) {
		this.jkLapelDesignWsPrice = jkLapelDesignWsPrice;
	}
	public String getJkLapelModelCd() {
		return jkLapelModelCd;
	}
	public void setJkLapelModelCd(String jkLapelModelCd) {
		this.jkLapelModelCd = jkLapelModelCd;
	}
	public String getJkLapelModelNm() {
		return jkLapelModelNm;
	}
	public void setJkLapelModelNm(String jkLapelModelNm) {
		this.jkLapelModelNm = jkLapelModelNm;
	}
	public BigDecimal getJkLapelModelWsWage() {
		return jkLapelModelWsWage;
	}
	public void setJkLapelModelWsWage(BigDecimal jkLapelModelWsWage) {
		this.jkLapelModelWsWage = jkLapelModelWsWage;
	}
	public Integer getJkLapelModelWsPrice() {
		return jkLapelModelWsPrice;
	}
	public void setJkLapelModelWsPrice(Integer jkLapelModelWsPrice) {
		this.jkLapelModelWsPrice = jkLapelModelWsPrice;
	}
	public String getJkGradeCd() {
		return jkGradeCd;
	}
	public void setJkGradeCd(String jkGradeCd) {
		this.jkGradeCd = jkGradeCd;
	}
	public String getJkGradeNm() {
		return jkGradeNm;
	}
	public void setJkGradeNm(String jkGradeNm) {
		this.jkGradeNm = jkGradeNm;
	}
	public BigDecimal getJkGradeWsWage() {
		return jkGradeWsWage;
	}
	public void setJkGradeWsWage(BigDecimal jkGradeWsWage) {
		this.jkGradeWsWage = jkGradeWsWage;
	}
	public Integer getJkGradeWsPrice() {
		return jkGradeWsPrice;
	}
	public void setJkGradeWsPrice(Integer jkGradeWsPrice) {
		this.jkGradeWsPrice = jkGradeWsPrice;
	}
	public String getJkInnerClothCd() {
		return jkInnerClothCd;
	}
	public void setJkInnerClothCd(String jkInnerClothCd) {
		this.jkInnerClothCd = jkInnerClothCd;
	}
	public String getJkInnerClothNm() {
		return jkInnerClothNm;
	}
	public void setJkInnerClothNm(String jkInnerClothNm) {
		this.jkInnerClothNm = jkInnerClothNm;
	}
	public BigDecimal getJkInnerClothWsWage() {
		return jkInnerClothWsWage;
	}
	public void setJkInnerClothWsWage(BigDecimal jkInnerClothWsWage) {
		this.jkInnerClothWsWage = jkInnerClothWsWage;
	}
	public Integer getJkInnerClothWsPrice() {
		return jkInnerClothWsPrice;
	}
	public void setJkInnerClothWsPrice(Integer jkInnerClothWsPrice) {
		this.jkInnerClothWsPrice = jkInnerClothWsPrice;
	}
	public String getJkDaibaCd() {
		return jkDaibaCd;
	}
	public void setJkDaibaCd(String jkDaibaCd) {
		this.jkDaibaCd = jkDaibaCd;
	}
	public String getJkDaibaNm() {
		return jkDaibaNm;
	}
	public void setJkDaibaNm(String jkDaibaNm) {
		this.jkDaibaNm = jkDaibaNm;
	}
	public BigDecimal getJkDaibaWsWage() {
		return jkDaibaWsWage;
	}
	public void setJkDaibaWsWage(BigDecimal jkDaibaWsWage) {
		this.jkDaibaWsWage = jkDaibaWsWage;
	}
	public Integer getJkDaibaWsPrice() {
		return jkDaibaWsPrice;
	}
	public void setJkDaibaWsPrice(Integer jkDaibaWsPrice) {
		this.jkDaibaWsPrice = jkDaibaWsPrice;
	}
	public String getJkLookClothCd() {
		return jkLookClothCd;
	}
	public void setJkLookClothCd(String jkLookClothCd) {
		this.jkLookClothCd = jkLookClothCd;
	}
	public String getJkLookClothNm() {
		return jkLookClothNm;
	}
	public void setJkLookClothNm(String jkLookClothNm) {
		this.jkLookClothNm = jkLookClothNm;
	}
	public BigDecimal getJkLookClothWsWage() {
		return jkLookClothWsWage;
	}
	public void setJkLookClothWsWage(BigDecimal jkLookClothWsWage) {
		this.jkLookClothWsWage = jkLookClothWsWage;
	}
	public Integer getJkLookClothWsPrice() {
		return jkLookClothWsPrice;
	}
	public void setJkLookClothWsPrice(Integer jkLookClothWsPrice) {
		this.jkLookClothWsPrice = jkLookClothWsPrice;
	}
	public String getJkCollarInnerCd() {
		return jkCollarInnerCd;
	}
	public void setJkCollarInnerCd(String jkCollarInnerCd) {
		this.jkCollarInnerCd = jkCollarInnerCd;
	}
	public String getJkCollarInnerNm() {
		return jkCollarInnerNm;
	}
	public void setJkCollarInnerNm(String jkCollarInnerNm) {
		this.jkCollarInnerNm = jkCollarInnerNm;
	}
	public BigDecimal getJkCollarInnerWsWage() {
		return jkCollarInnerWsWage;
	}
	public void setJkCollarInnerWsWage(BigDecimal jkCollarInnerWsWage) {
		this.jkCollarInnerWsWage = jkCollarInnerWsWage;
	}
	public Integer getJkCollarInnerWsPrice() {
		return jkCollarInnerWsPrice;
	}
	public void setJkCollarInnerWsPrice(Integer jkCollarInnerWsPrice) {
		this.jkCollarInnerWsPrice = jkCollarInnerWsPrice;
	}
	public String getJkCollarHangCd() {
		return jkCollarHangCd;
	}
	public void setJkCollarHangCd(String jkCollarHangCd) {
		this.jkCollarHangCd = jkCollarHangCd;
	}
	public String getJkCollarHangNm() {
		return jkCollarHangNm;
	}
	public void setJkCollarHangNm(String jkCollarHangNm) {
		this.jkCollarHangNm = jkCollarHangNm;
	}
	public BigDecimal getJkCollarHangWsWage() {
		return jkCollarHangWsWage;
	}
	public void setJkCollarHangWsWage(BigDecimal jkCollarHangWsWage) {
		this.jkCollarHangWsWage = jkCollarHangWsWage;
	}
	public Integer getJkCollarHangWsPrice() {
		return jkCollarHangWsPrice;
	}
	public void setJkCollarHangWsPrice(Integer jkCollarHangWsPrice) {
		this.jkCollarHangWsPrice = jkCollarHangWsPrice;
	}
	public String getJkLapelWidthCd() {
		return jkLapelWidthCd;
	}
	public void setJkLapelWidthCd(String jkLapelWidthCd) {
		this.jkLapelWidthCd = jkLapelWidthCd;
	}
	public String getJkLapelWidthNm() {
		return jkLapelWidthNm;
	}
	public void setJkLapelWidthNm(String jkLapelWidthNm) {
		this.jkLapelWidthNm = jkLapelWidthNm;
	}
	public BigDecimal getJkLapelWidthWsWage() {
		return jkLapelWidthWsWage;
	}
	public void setJkLapelWidthWsWage(BigDecimal jkLapelWidthWsWage) {
		this.jkLapelWidthWsWage = jkLapelWidthWsWage;
	}
	public Integer getJkLapelWidthWsPrice() {
		return jkLapelWidthWsPrice;
	}
	public void setJkLapelWidthWsPrice(Integer jkLapelWidthWsPrice) {
		this.jkLapelWidthWsPrice = jkLapelWidthWsPrice;
	}
	public String getJkFlowerHoleCd() {
		return jkFlowerHoleCd;
	}
	public void setJkFlowerHoleCd(String jkFlowerHoleCd) {
		this.jkFlowerHoleCd = jkFlowerHoleCd;
	}
	public String getJkFlowerHoleNm() {
		return jkFlowerHoleNm;
	}
	public void setJkFlowerHoleNm(String jkFlowerHoleNm) {
		this.jkFlowerHoleNm = jkFlowerHoleNm;
	}
	public BigDecimal getJkFlowerHoleWsWage() {
		return jkFlowerHoleWsWage;
	}
	public void setJkFlowerHoleWsWage(BigDecimal jkFlowerHoleWsWage) {
		this.jkFlowerHoleWsWage = jkFlowerHoleWsWage;
	}
	public Integer getJkFlowerHoleWsPrice() {
		return jkFlowerHoleWsPrice;
	}
	public void setJkFlowerHoleWsPrice(Integer jkFlowerHoleWsPrice) {
		this.jkFlowerHoleWsPrice = jkFlowerHoleWsPrice;
	}
	public String getJkBreastPktCd() {
		return jkBreastPktCd;
	}
	public void setJkBreastPktCd(String jkBreastPktCd) {
		this.jkBreastPktCd = jkBreastPktCd;
	}
	public String getJkBreastPktNm() {
		return jkBreastPktNm;
	}
	public void setJkBreastPktNm(String jkBreastPktNm) {
		this.jkBreastPktNm = jkBreastPktNm;
	}
	public BigDecimal getJkBreastPktWsWage() {
		return jkBreastPktWsWage;
	}
	public void setJkBreastPktWsWage(BigDecimal jkBreastPktWsWage) {
		this.jkBreastPktWsWage = jkBreastPktWsWage;
	}
	public Integer getJkBreastPktWsPrice() {
		return jkBreastPktWsPrice;
	}
	public void setJkBreastPktWsPrice(Integer jkBreastPktWsPrice) {
		this.jkBreastPktWsPrice = jkBreastPktWsPrice;
	}
	public String getJkWaistPktCd() {
		return jkWaistPktCd;
	}
	public void setJkWaistPktCd(String jkWaistPktCd) {
		this.jkWaistPktCd = jkWaistPktCd;
	}
	public String getJkWaistPktNm() {
		return jkWaistPktNm;
	}
	public void setJkWaistPktNm(String jkWaistPktNm) {
		this.jkWaistPktNm = jkWaistPktNm;
	}
	public BigDecimal getJkWaistPktWsWage() {
		return jkWaistPktWsWage;
	}
	public void setJkWaistPktWsWage(BigDecimal jkWaistPktWsWage) {
		this.jkWaistPktWsWage = jkWaistPktWsWage;
	}
	public Integer getJkWaistPktWsPrice() {
		return jkWaistPktWsPrice;
	}
	public void setJkWaistPktWsPrice(Integer jkWaistPktWsPrice) {
		this.jkWaistPktWsPrice = jkWaistPktWsPrice;
	}
	public String getJkChgPktCd() {
		return jkChgPktCd;
	}
	public void setJkChgPktCd(String jkChgPktCd) {
		this.jkChgPktCd = jkChgPktCd;
	}
	public String getJkChgPktNm() {
		return jkChgPktNm;
	}
	public void setJkChgPktNm(String jkChgPktNm) {
		this.jkChgPktNm = jkChgPktNm;
	}
	public BigDecimal getJkChgPktWsWage() {
		return jkChgPktWsWage;
	}
	public void setJkChgPktWsWage(BigDecimal jkChgPktWsWage) {
		this.jkChgPktWsWage = jkChgPktWsWage;
	}
	public Integer getJkChgPktWsPrice() {
		return jkChgPktWsPrice;
	}
	public void setJkChgPktWsPrice(Integer jkChgPktWsPrice) {
		this.jkChgPktWsPrice = jkChgPktWsPrice;
	}
	public String getJkSlantedPktCd() {
		return jkSlantedPktCd;
	}
	public void setJkSlantedPktCd(String jkSlantedPktCd) {
		this.jkSlantedPktCd = jkSlantedPktCd;
	}
	public String getJkSlantedPktNm() {
		return jkSlantedPktNm;
	}
	public void setJkSlantedPktNm(String jkSlantedPktNm) {
		this.jkSlantedPktNm = jkSlantedPktNm;
	}
	public BigDecimal getJkSlantedPktWsWage() {
		return jkSlantedPktWsWage;
	}
	public void setJkSlantedPktWsWage(BigDecimal jkSlantedPktWsWage) {
		this.jkSlantedPktWsWage = jkSlantedPktWsWage;
	}
	public Integer getJkSlantedPktWsPrice() {
		return jkSlantedPktWsPrice;
	}
	public void setJkSlantedPktWsPrice(Integer jkSlantedPktWsPrice) {
		this.jkSlantedPktWsPrice = jkSlantedPktWsPrice;
	}
	public String getJkShinobiPktCd() {
		return jkShinobiPktCd;
	}
	public void setJkShinobiPktCd(String jkShinobiPktCd) {
		this.jkShinobiPktCd = jkShinobiPktCd;
	}
	public String getJkShinobiPktNm() {
		return jkShinobiPktNm;
	}
	public void setJkShinobiPktNm(String jkShinobiPktNm) {
		this.jkShinobiPktNm = jkShinobiPktNm;
	}
	public BigDecimal getJkShinobiPktWsWage() {
		return jkShinobiPktWsWage;
	}
	public void setJkShinobiPktWsWage(BigDecimal jkShinobiPktWsWage) {
		this.jkShinobiPktWsWage = jkShinobiPktWsWage;
	}
	public Integer getJkShinobiPktWsPrice() {
		return jkShinobiPktWsPrice;
	}
	public void setJkShinobiPktWsPrice(Integer jkShinobiPktWsPrice) {
		this.jkShinobiPktWsPrice = jkShinobiPktWsPrice;
	}
	public String getJkSleeveTypeCd() {
		return jkSleeveTypeCd;
	}
	public void setJkSleeveTypeCd(String jkSleeveTypeCd) {
		this.jkSleeveTypeCd = jkSleeveTypeCd;
	}
	public String getJkSleeveTypeNm() {
		return jkSleeveTypeNm;
	}
	public void setJkSleeveTypeNm(String jkSleeveTypeNm) {
		this.jkSleeveTypeNm = jkSleeveTypeNm;
	}
	public BigDecimal getJkSleeveTypeWsWage() {
		return jkSleeveTypeWsWage;
	}
	public void setJkSleeveTypeWsWage(BigDecimal jkSleeveTypeWsWage) {
		this.jkSleeveTypeWsWage = jkSleeveTypeWsWage;
	}
	public Integer getJkSleeveTypeWsPrice() {
		return jkSleeveTypeWsPrice;
	}
	public void setJkSleeveTypeWsPrice(Integer jkSleeveTypeWsPrice) {
		this.jkSleeveTypeWsPrice = jkSleeveTypeWsPrice;
	}
	public String getJkManicaCd() {
		return jkManicaCd;
	}
	public void setJkManicaCd(String jkManicaCd) {
		this.jkManicaCd = jkManicaCd;
	}
	public String getJkManicaNm() {
		return jkManicaNm;
	}
	public void setJkManicaNm(String jkManicaNm) {
		this.jkManicaNm = jkManicaNm;
	}
	public BigDecimal getJkManicaWsWage() {
		return jkManicaWsWage;
	}
	public void setJkManicaWsWage(BigDecimal jkManicaWsWage) {
		this.jkManicaWsWage = jkManicaWsWage;
	}
	public Integer getJkManicaWsPrice() {
		return jkManicaWsPrice;
	}
	public void setJkManicaWsPrice(Integer jkManicaWsPrice) {
		this.jkManicaWsPrice = jkManicaWsPrice;
	}
	public String getJkSleeveBtnType() {
		return jkSleeveBtnType;
	}
	public void setJkSleeveBtnType(String jkSleeveBtnType) {
		this.jkSleeveBtnType = jkSleeveBtnType;
	}
	public Short getJkSleeveBtnNumber() {
		return jkSleeveBtnNumber;
	}
	public void setJkSleeveBtnNumber(Short jkSleeveBtnNumber) {
		this.jkSleeveBtnNumber = jkSleeveBtnNumber;
	}
	public String getJkSleeveBtnCd() {
		return jkSleeveBtnCd;
	}
	public void setJkSleeveBtnCd(String jkSleeveBtnCd) {
		this.jkSleeveBtnCd = jkSleeveBtnCd;
	}
	public String getJkSleeveBtnNm() {
		return jkSleeveBtnNm;
	}
	public void setJkSleeveBtnNm(String jkSleeveBtnNm) {
		this.jkSleeveBtnNm = jkSleeveBtnNm;
	}
	public BigDecimal getJkSleeveBtnWsWage() {
		return jkSleeveBtnWsWage;
	}
	public void setJkSleeveBtnWsWage(BigDecimal jkSleeveBtnWsWage) {
		this.jkSleeveBtnWsWage = jkSleeveBtnWsWage;
	}
	public Integer getJkSleeveBtnWsPrice() {
		return jkSleeveBtnWsPrice;
	}
	public void setJkSleeveBtnWsPrice(Integer jkSleeveBtnWsPrice) {
		this.jkSleeveBtnWsPrice = jkSleeveBtnWsPrice;
	}
	public String getJkCuffCd() {
		return jkCuffCd;
	}
	public void setJkCuffCd(String jkCuffCd) {
		this.jkCuffCd = jkCuffCd;
	}
	public String getJkCuffNm() {
		return jkCuffNm;
	}
	public void setJkCuffNm(String jkCuffNm) {
		this.jkCuffNm = jkCuffNm;
	}
	public BigDecimal getJkCuffWsWage() {
		return jkCuffWsWage;
	}
	public void setJkCuffWsWage(BigDecimal jkCuffWsWage) {
		this.jkCuffWsWage = jkCuffWsWage;
	}
	public Integer getJkCuffWsPrice() {
		return jkCuffWsPrice;
	}
	public void setJkCuffWsPrice(Integer jkCuffWsPrice) {
		this.jkCuffWsPrice = jkCuffWsPrice;
	}
	public String getJkInnerPktType() {
		return jkInnerPktType;
	}
	public void setJkInnerPktType(String jkInnerPktType) {
		this.jkInnerPktType = jkInnerPktType;
	}
	public String getJkInnerPktCd() {
		return jkInnerPktCd;
	}
	public void setJkInnerPktCd(String jkInnerPktCd) {
		this.jkInnerPktCd = jkInnerPktCd;
	}
	public String getJkInnerPktNm() {
		return jkInnerPktNm;
	}
	public void setJkInnerPktNm(String jkInnerPktNm) {
		this.jkInnerPktNm = jkInnerPktNm;
	}
	public BigDecimal getJkInnerPktWsWage() {
		return jkInnerPktWsWage;
	}
	public void setJkInnerPktWsWage(BigDecimal jkInnerPktWsWage) {
		this.jkInnerPktWsWage = jkInnerPktWsWage;
	}
	public Integer getJkInnerPktWsPrice() {
		return jkInnerPktWsPrice;
	}
	public void setJkInnerPktWsPrice(Integer jkInnerPktWsPrice) {
		this.jkInnerPktWsPrice = jkInnerPktWsPrice;
	}
	public String getJkRightInnerPktTypeCd() {
		return jkRightInnerPktTypeCd;
	}
	public void setJkRightInnerPktTypeCd(String jkRightInnerPktTypeCd) {
		this.jkRightInnerPktTypeCd = jkRightInnerPktTypeCd;
	}
	public String getJkRightInnerPktTypeNm() {
		return jkRightInnerPktTypeNm;
	}
	public void setJkRightInnerPktTypeNm(String jkRightInnerPktTypeNm) {
		this.jkRightInnerPktTypeNm = jkRightInnerPktTypeNm;
	}
	public BigDecimal getJkRightInnerPktTypeWsWage() {
		return jkRightInnerPktTypeWsWage;
	}
	public void setJkRightInnerPktTypeWsWage(BigDecimal jkRightInnerPktTypeWsWage) {
		this.jkRightInnerPktTypeWsWage = jkRightInnerPktTypeWsWage;
	}
	public Integer getJkRightInnerPktTypeWsPrice() {
		return jkRightInnerPktTypeWsPrice;
	}
	public void setJkRightInnerPktTypeWsPrice(Integer jkRightInnerPktTypeWsPrice) {
		this.jkRightInnerPktTypeWsPrice = jkRightInnerPktTypeWsPrice;
	}
	public String getJkStitchTypeCd() {
		return jkStitchTypeCd;
	}
	public void setJkStitchTypeCd(String jkStitchTypeCd) {
		this.jkStitchTypeCd = jkStitchTypeCd;
	}
	public String getJkStitchTypeNm() {
		return jkStitchTypeNm;
	}
	public void setJkStitchTypeNm(String jkStitchTypeNm) {
		this.jkStitchTypeNm = jkStitchTypeNm;
	}
	public BigDecimal getJkStitchTypeWsWage() {
		return jkStitchTypeWsWage;
	}
	public void setJkStitchTypeWsWage(BigDecimal jkStitchTypeWsWage) {
		this.jkStitchTypeWsWage = jkStitchTypeWsWage;
	}
	public Integer getJkStitchTypeWsPrice() {
		return jkStitchTypeWsPrice;
	}
	public void setJkStitchTypeWsPrice(Integer jkStitchTypeWsPrice) {
		this.jkStitchTypeWsPrice = jkStitchTypeWsPrice;
	}
	public String getJkStitchPlcType() {
		return jkStitchPlcType;
	}
	public void setJkStitchPlcType(String jkStitchPlcType) {
		this.jkStitchPlcType = jkStitchPlcType;
	}
	public String getJkStitchPlcCd() {
		return jkStitchPlcCd;
	}
	public void setJkStitchPlcCd(String jkStitchPlcCd) {
		this.jkStitchPlcCd = jkStitchPlcCd;
	}
	public String getJkStitchPlcNm() {
		return jkStitchPlcNm;
	}
	public void setJkStitchPlcNm(String jkStitchPlcNm) {
		this.jkStitchPlcNm = jkStitchPlcNm;
	}
	public BigDecimal getJkStitchPlcWsWage() {
		return jkStitchPlcWsWage;
	}
	public void setJkStitchPlcWsWage(BigDecimal jkStitchPlcWsWage) {
		this.jkStitchPlcWsWage = jkStitchPlcWsWage;
	}
	public Integer getJkStitchPlcWsPrice() {
		return jkStitchPlcWsPrice;
	}
	public void setJkStitchPlcWsPrice(Integer jkStitchPlcWsPrice) {
		this.jkStitchPlcWsPrice = jkStitchPlcWsPrice;
	}
	public String getJkDblstitchPlcType() {
		return jkDblstitchPlcType;
	}
	public void setJkDblstitchPlcType(String jkDblstitchPlcType) {
		this.jkDblstitchPlcType = jkDblstitchPlcType;
	}
	public String getJkDblstitchPlcCd() {
		return jkDblstitchPlcCd;
	}
	public void setJkDblstitchPlcCd(String jkDblstitchPlcCd) {
		this.jkDblstitchPlcCd = jkDblstitchPlcCd;
	}
	public String getJkDblstitchPlcNm() {
		return jkDblstitchPlcNm;
	}
	public void setJkDblstitchPlcNm(String jkDblstitchPlcNm) {
		this.jkDblstitchPlcNm = jkDblstitchPlcNm;
	}
	public BigDecimal getJkDblstitchPlcWsWage() {
		return jkDblstitchPlcWsWage;
	}
	public void setJkDblstitchPlcWsWage(BigDecimal jkDblstitchPlcWsWage) {
		this.jkDblstitchPlcWsWage = jkDblstitchPlcWsWage;
	}
	public Integer getJkDblstitchPlcWsPrice() {
		return jkDblstitchPlcWsPrice;
	}
	public void setJkDblstitchPlcWsPrice(Integer jkDblstitchPlcWsPrice) {
		this.jkDblstitchPlcWsPrice = jkDblstitchPlcWsPrice;
	}
	public String getJkAmfColorType() {
		return jkAmfColorType;
	}
	public void setJkAmfColorType(String jkAmfColorType) {
		this.jkAmfColorType = jkAmfColorType;
	}
	public String getJkAmfColorPlcCd() {
		return jkAmfColorPlcCd;
	}
	public void setJkAmfColorPlcCd(String jkAmfColorPlcCd) {
		this.jkAmfColorPlcCd = jkAmfColorPlcCd;
	}
	public String getJkAmfColorPlcNm() {
		return jkAmfColorPlcNm;
	}
	public void setJkAmfColorPlcNm(String jkAmfColorPlcNm) {
		this.jkAmfColorPlcNm = jkAmfColorPlcNm;
	}
	public String getJkAmfColorCd() {
		return jkAmfColorCd;
	}
	public void setJkAmfColorCd(String jkAmfColorCd) {
		this.jkAmfColorCd = jkAmfColorCd;
	}
	public String getJkAmfColorNm() {
		return jkAmfColorNm;
	}
	public void setJkAmfColorNm(String jkAmfColorNm) {
		this.jkAmfColorNm = jkAmfColorNm;
	}
	public BigDecimal getJkAmfColorWsWage() {
		return jkAmfColorWsWage;
	}
	public void setJkAmfColorWsWage(BigDecimal jkAmfColorWsWage) {
		this.jkAmfColorWsWage = jkAmfColorWsWage;
	}
	public Integer getJkAmfColorWsPrice() {
		return jkAmfColorWsPrice;
	}
	public void setJkAmfColorWsPrice(Integer jkAmfColorWsPrice) {
		this.jkAmfColorWsPrice = jkAmfColorWsPrice;
	}
	public String getJkBtnholeColorType() {
		return jkBtnholeColorType;
	}
	public void setJkBtnholeColorType(String jkBtnholeColorType) {
		this.jkBtnholeColorType = jkBtnholeColorType;
	}
	public String getJkBtnholeColorPlcCd() {
		return jkBtnholeColorPlcCd;
	}
	public void setJkBtnholeColorPlcCd(String jkBtnholeColorPlcCd) {
		this.jkBtnholeColorPlcCd = jkBtnholeColorPlcCd;
	}
	public String getJkBtnholeColorPlcN() {
		return jkBtnholeColorPlcN;
	}
	public void setJkBtnholeColorPlcN(String jkBtnholeColorPlcN) {
		this.jkBtnholeColorPlcN = jkBtnholeColorPlcN;
	}
	public String getJkBtnholeColorCd() {
		return jkBtnholeColorCd;
	}
	public void setJkBtnholeColorCd(String jkBtnholeColorCd) {
		this.jkBtnholeColorCd = jkBtnholeColorCd;
	}
	public String getJkBtnholeColorNm() {
		return jkBtnholeColorNm;
	}
	public void setJkBtnholeColorNm(String jkBtnholeColorNm) {
		this.jkBtnholeColorNm = jkBtnholeColorNm;
	}
	public BigDecimal getJkBtnholePlcColorWsWage() {
		return jkBtnholePlcColorWsWage;
	}
	public void setJkBtnholePlcColorWsWage(BigDecimal jkBtnholePlcColorWsWage) {
		this.jkBtnholePlcColorWsWage = jkBtnholePlcColorWsWage;
	}
	public Integer getJkBtnholePlcColorWsPrice() {
		return jkBtnholePlcColorWsPrice;
	}
	public void setJkBtnholePlcColorWsPrice(Integer jkBtnholePlcColorWsPrice) {
		this.jkBtnholePlcColorWsPrice = jkBtnholePlcColorWsPrice;
	}
	public String getJkBtnthreadColorType() {
		return jkBtnthreadColorType;
	}
	public void setJkBtnthreadColorType(String jkBtnthreadColorType) {
		this.jkBtnthreadColorType = jkBtnthreadColorType;
	}
	public String getJkBtnthreadColorPlcCd() {
		return jkBtnthreadColorPlcCd;
	}
	public void setJkBtnthreadColorPlcCd(String jkBtnthreadColorPlcCd) {
		this.jkBtnthreadColorPlcCd = jkBtnthreadColorPlcCd;
	}
	public String getJkBtnthreadColorPlcN() {
		return jkBtnthreadColorPlcN;
	}
	public void setJkBtnthreadColorPlcN(String jkBtnthreadColorPlcN) {
		this.jkBtnthreadColorPlcN = jkBtnthreadColorPlcN;
	}
	public String getJkBtnthreadColorCd() {
		return jkBtnthreadColorCd;
	}
	public void setJkBtnthreadColorCd(String jkBtnthreadColorCd) {
		this.jkBtnthreadColorCd = jkBtnthreadColorCd;
	}
	public String getJkBtnthreadColorNm() {
		return jkBtnthreadColorNm;
	}
	public void setJkBtnthreadColorNm(String jkBtnthreadColorNm) {
		this.jkBtnthreadColorNm = jkBtnthreadColorNm;
	}
	public BigDecimal getJkBtnthreadPlcColorWsWage() {
		return jkBtnthreadPlcColorWsWage;
	}
	public void setJkBtnthreadPlcColorWsWage(BigDecimal jkBtnthreadPlcColorWsWage) {
		this.jkBtnthreadPlcColorWsWage = jkBtnthreadPlcColorWsWage;
	}
	public Integer getJkBtnthreadPlcColorWsPrice() {
		return jkBtnthreadPlcColorWsPrice;
	}
	public void setJkBtnthreadPlcColorWsPrice(Integer jkBtnthreadPlcColorWsPrice) {
		this.jkBtnthreadPlcColorWsPrice = jkBtnthreadPlcColorWsPrice;
	}
	public String getJkVentCd() {
		return jkVentCd;
	}
	public void setJkVentCd(String jkVentCd) {
		this.jkVentCd = jkVentCd;
	}
	public String getJkVentNm() {
		return jkVentNm;
	}
	public void setJkVentNm(String jkVentNm) {
		this.jkVentNm = jkVentNm;
	}
	public BigDecimal getJkVentWsWage() {
		return jkVentWsWage;
	}
	public void setJkVentWsWage(BigDecimal jkVentWsWage) {
		this.jkVentWsWage = jkVentWsWage;
	}
	public Integer getJkVentWsPrice() {
		return jkVentWsPrice;
	}
	public void setJkVentWsPrice(Integer jkVentWsPrice) {
		this.jkVentWsPrice = jkVentWsPrice;
	}
	public String getJkInnerBodyClothType() {
		return jkInnerBodyClothType;
	}
	public void setJkInnerBodyClothType(String jkInnerBodyClothType) {
		this.jkInnerBodyClothType = jkInnerBodyClothType;
	}
	public String getJkInnerBodyClothCd() {
		return jkInnerBodyClothCd;
	}
	public void setJkInnerBodyClothCd(String jkInnerBodyClothCd) {
		this.jkInnerBodyClothCd = jkInnerBodyClothCd;
	}
	public String getJkInnerBodyClothNm() {
		return jkInnerBodyClothNm;
	}
	public void setJkInnerBodyClothNm(String jkInnerBodyClothNm) {
		this.jkInnerBodyClothNm = jkInnerBodyClothNm;
	}
	public BigDecimal getJkInnerBodyClothWsWage() {
		return jkInnerBodyClothWsWage;
	}
	public void setJkInnerBodyClothWsWage(BigDecimal jkInnerBodyClothWsWage) {
		this.jkInnerBodyClothWsWage = jkInnerBodyClothWsWage;
	}
	public Integer getJkInnerBodyClothWsPrice() {
		return jkInnerBodyClothWsPrice;
	}
	public void setJkInnerBodyClothWsPrice(Integer jkInnerBodyClothWsPrice) {
		this.jkInnerBodyClothWsPrice = jkInnerBodyClothWsPrice;
	}
	public String getJkInnerSleeveClothType() {
		return jkInnerSleeveClothType;
	}
	public void setJkInnerSleeveClothType(String jkInnerSleeveClothType) {
		this.jkInnerSleeveClothType = jkInnerSleeveClothType;
	}
	public String getJkInnerSleeveClothCd() {
		return jkInnerSleeveClothCd;
	}
	public void setJkInnerSleeveClothCd(String jkInnerSleeveClothCd) {
		this.jkInnerSleeveClothCd = jkInnerSleeveClothCd;
	}
	public String getJkInnerSleeveClothNm() {
		return jkInnerSleeveClothNm;
	}
	public void setJkInnerSleeveClothNm(String jkInnerSleeveClothNm) {
		this.jkInnerSleeveClothNm = jkInnerSleeveClothNm;
	}
	public BigDecimal getJkInnerSleeveClothWsWage() {
		return jkInnerSleeveClothWsWage;
	}
	public void setJkInnerSleeveClothWsWage(BigDecimal jkInnerSleeveClothWsWage) {
		this.jkInnerSleeveClothWsWage = jkInnerSleeveClothWsWage;
	}
	public Integer getJkInnerSleeveClothWsPrice() {
		return jkInnerSleeveClothWsPrice;
	}
	public void setJkInnerSleeveClothWsPrice(Integer jkInnerSleeveClothWsPrice) {
		this.jkInnerSleeveClothWsPrice = jkInnerSleeveClothWsPrice;
	}
	public String getJkBtnMaterialType() {
		return jkBtnMaterialType;
	}
	public void setJkBtnMaterialType(String jkBtnMaterialType) {
		this.jkBtnMaterialType = jkBtnMaterialType;
	}
	public String getJkBtnMaterialCd() {
		return jkBtnMaterialCd;
	}
	public void setJkBtnMaterialCd(String jkBtnMaterialCd) {
		this.jkBtnMaterialCd = jkBtnMaterialCd;
	}
	public String getJkBtnMaterialNm() {
		return jkBtnMaterialNm;
	}
	public void setJkBtnMaterialNm(String jkBtnMaterialNm) {
		this.jkBtnMaterialNm = jkBtnMaterialNm;
	}
	public BigDecimal getJkBtnMaterialWsWage() {
		return jkBtnMaterialWsWage;
	}
	public void setJkBtnMaterialWsWage(BigDecimal jkBtnMaterialWsWage) {
		this.jkBtnMaterialWsWage = jkBtnMaterialWsWage;
	}
	public Integer getJkBtnMaterialWsPrice() {
		return jkBtnMaterialWsPrice;
	}
	public void setJkBtnMaterialWsPrice(Integer jkBtnMaterialWsPrice) {
		this.jkBtnMaterialWsPrice = jkBtnMaterialWsPrice;
	}
	public String getJkShapeMemoryCd() {
		return jkShapeMemoryCd;
	}
	public void setJkShapeMemoryCd(String jkShapeMemoryCd) {
		this.jkShapeMemoryCd = jkShapeMemoryCd;
	}
	public String getJkShapeMemoryNm() {
		return jkShapeMemoryNm;
	}
	public void setJkShapeMemoryNm(String jkShapeMemoryNm) {
		this.jkShapeMemoryNm = jkShapeMemoryNm;
	}
	public BigDecimal getJkShapeMemoryWsWage() {
		return jkShapeMemoryWsWage;
	}
	public void setJkShapeMemoryWsWage(BigDecimal jkShapeMemoryWsWage) {
		this.jkShapeMemoryWsWage = jkShapeMemoryWsWage;
	}
	public Integer getJkShapeMemoryWsPrice() {
		return jkShapeMemoryWsPrice;
	}
	public void setJkShapeMemoryWsPrice(Integer jkShapeMemoryWsPrice) {
		this.jkShapeMemoryWsPrice = jkShapeMemoryWsPrice;
	}
	public String getPtModelCd() {
		return ptModelCd;
	}
	public void setPtModelCd(String ptModelCd) {
		this.ptModelCd = ptModelCd;
	}
	public String getPtModelNm() {
		return ptModelNm;
	}
	public void setPtModelNm(String ptModelNm) {
		this.ptModelNm = ptModelNm;
	}
	public BigDecimal getPtModelWsWage() {
		return ptModelWsWage;
	}
	public void setPtModelWsWage(BigDecimal ptModelWsWage) {
		this.ptModelWsWage = ptModelWsWage;
	}
	public Integer getPtModelWsPrice() {
		return ptModelWsPrice;
	}
	public void setPtModelWsPrice(Integer ptModelWsPrice) {
		this.ptModelWsPrice = ptModelWsPrice;
	}
	public String getPtTackCd() {
		return ptTackCd;
	}
	public void setPtTackCd(String ptTackCd) {
		this.ptTackCd = ptTackCd;
	}
	public String getPtTackNm() {
		return ptTackNm;
	}
	public void setPtTackNm(String ptTackNm) {
		this.ptTackNm = ptTackNm;
	}
	public BigDecimal getPtTackWsWage() {
		return ptTackWsWage;
	}
	public void setPtTackWsWage(BigDecimal ptTackWsWage) {
		this.ptTackWsWage = ptTackWsWage;
	}
	public Integer getPtTackWsPrice() {
		return ptTackWsPrice;
	}
	public void setPtTackWsPrice(Integer ptTackWsPrice) {
		this.ptTackWsPrice = ptTackWsPrice;
	}
	public String getPtKneeinnerTypeCd() {
		return ptKneeinnerTypeCd;
	}
	public void setPtKneeinnerTypeCd(String ptKneeinnerTypeCd) {
		this.ptKneeinnerTypeCd = ptKneeinnerTypeCd;
	}
	public String getPtKneeinnerTypeNm() {
		return ptKneeinnerTypeNm;
	}
	public void setPtKneeinnerTypeNm(String ptKneeinnerTypeNm) {
		this.ptKneeinnerTypeNm = ptKneeinnerTypeNm;
	}
	public BigDecimal getPtKneeinnerTypeWsWage() {
		return ptKneeinnerTypeWsWage;
	}
	public void setPtKneeinnerTypeWsWage(BigDecimal ptKneeinnerTypeWsWage) {
		this.ptKneeinnerTypeWsWage = ptKneeinnerTypeWsWage;
	}
	public Integer getPtKneeinnerTypeWsPrice() {
		return ptKneeinnerTypeWsPrice;
	}
	public void setPtKneeinnerTypeWsPrice(Integer ptKneeinnerTypeWsPrice) {
		this.ptKneeinnerTypeWsPrice = ptKneeinnerTypeWsPrice;
	}
	public String getPtKneeinnerClothCd() {
		return ptKneeinnerClothCd;
	}
	public void setPtKneeinnerClothCd(String ptKneeinnerClothCd) {
		this.ptKneeinnerClothCd = ptKneeinnerClothCd;
	}
	public String getPtKneeinnerClothNm() {
		return ptKneeinnerClothNm;
	}
	public void setPtKneeinnerClothNm(String ptKneeinnerClothNm) {
		this.ptKneeinnerClothNm = ptKneeinnerClothNm;
	}
	public BigDecimal getPtKneeinnerClothWsWage() {
		return ptKneeinnerClothWsWage;
	}
	public void setPtKneeinnerClothWsWage(BigDecimal ptKneeinnerClothWsWage) {
		this.ptKneeinnerClothWsWage = ptKneeinnerClothWsWage;
	}
	public Integer getPtKneeinnerClothWsPrice() {
		return ptKneeinnerClothWsPrice;
	}
	public void setPtKneeinnerClothWsPrice(Integer ptKneeinnerClothWsPrice) {
		this.ptKneeinnerClothWsPrice = ptKneeinnerClothWsPrice;
	}
	public String getPtFrtTypeCd() {
		return ptFrtTypeCd;
	}
	public void setPtFrtTypeCd(String ptFrtTypeCd) {
		this.ptFrtTypeCd = ptFrtTypeCd;
	}
	public String getPtFrtTypeNm() {
		return ptFrtTypeNm;
	}
	public void setPtFrtTypeNm(String ptFrtTypeNm) {
		this.ptFrtTypeNm = ptFrtTypeNm;
	}
	public BigDecimal getPtFrtTypeWsWage() {
		return ptFrtTypeWsWage;
	}
	public void setPtFrtTypeWsWage(BigDecimal ptFrtTypeWsWage) {
		this.ptFrtTypeWsWage = ptFrtTypeWsWage;
	}
	public Integer getPtFrtTypeWsPrice() {
		return ptFrtTypeWsPrice;
	}
	public void setPtFrtTypeWsPrice(Integer ptFrtTypeWsPrice) {
		this.ptFrtTypeWsPrice = ptFrtTypeWsPrice;
	}
	public String getPtPancherinaCd() {
		return ptPancherinaCd;
	}
	public void setPtPancherinaCd(String ptPancherinaCd) {
		this.ptPancherinaCd = ptPancherinaCd;
	}
	public String getPtPancherinaNm() {
		return ptPancherinaNm;
	}
	public void setPtPancherinaNm(String ptPancherinaNm) {
		this.ptPancherinaNm = ptPancherinaNm;
	}
	public BigDecimal getPtPancherinaWsWage() {
		return ptPancherinaWsWage;
	}
	public void setPtPancherinaWsWage(BigDecimal ptPancherinaWsWage) {
		this.ptPancherinaWsWage = ptPancherinaWsWage;
	}
	public Integer getPtPancherinaWsPrice() {
		return ptPancherinaWsPrice;
	}
	public void setPtPancherinaWsPrice(Integer ptPancherinaWsPrice) {
		this.ptPancherinaWsPrice = ptPancherinaWsPrice;
	}
	public String getPtAdjusterCd() {
		return ptAdjusterCd;
	}
	public void setPtAdjusterCd(String ptAdjusterCd) {
		this.ptAdjusterCd = ptAdjusterCd;
	}
	public String getPtAdjusterNm() {
		return ptAdjusterNm;
	}
	public void setPtAdjusterNm(String ptAdjusterNm) {
		this.ptAdjusterNm = ptAdjusterNm;
	}
	public BigDecimal getPtAdjusterWsWage() {
		return ptAdjusterWsWage;
	}
	public void setPtAdjusterWsWage(BigDecimal ptAdjusterWsWage) {
		this.ptAdjusterWsWage = ptAdjusterWsWage;
	}
	public Integer getPtAdjusterWsPrice() {
		return ptAdjusterWsPrice;
	}
	public void setPtAdjusterWsPrice(Integer ptAdjusterWsPrice) {
		this.ptAdjusterWsPrice = ptAdjusterWsPrice;
	}
	public String getPtBeltloopType() {
		return ptBeltloopType;
	}
	public void setPtBeltloopType(String ptBeltloopType) {
		this.ptBeltloopType = ptBeltloopType;
	}
	public String getPtBeltloopCd() {
		return ptBeltloopCd;
	}
	public void setPtBeltloopCd(String ptBeltloopCd) {
		this.ptBeltloopCd = ptBeltloopCd;
	}
	public String getPtBeltloopNm() {
		return ptBeltloopNm;
	}
	public void setPtBeltloopNm(String ptBeltloopNm) {
		this.ptBeltloopNm = ptBeltloopNm;
	}
	public BigDecimal getPtBeltloopWsWage() {
		return ptBeltloopWsWage;
	}
	public void setPtBeltloopWsWage(BigDecimal ptBeltloopWsWage) {
		this.ptBeltloopWsWage = ptBeltloopWsWage;
	}
	public Integer getPtBeltloopWsPrice() {
		return ptBeltloopWsPrice;
	}
	public void setPtBeltloopWsPrice(Integer ptBeltloopWsPrice) {
		this.ptBeltloopWsPrice = ptBeltloopWsPrice;
	}
	public String getPtPinloopCd() {
		return ptPinloopCd;
	}
	public void setPtPinloopCd(String ptPinloopCd) {
		this.ptPinloopCd = ptPinloopCd;
	}
	public String getPtPinloopNm() {
		return ptPinloopNm;
	}
	public void setPtPinloopNm(String ptPinloopNm) {
		this.ptPinloopNm = ptPinloopNm;
	}
	public BigDecimal getPtPinloopWsWage() {
		return ptPinloopWsWage;
	}
	public void setPtPinloopWsWage(BigDecimal ptPinloopWsWage) {
		this.ptPinloopWsWage = ptPinloopWsWage;
	}
	public Integer getPtPinloopWsPrice() {
		return ptPinloopWsPrice;
	}
	public void setPtPinloopWsPrice(Integer ptPinloopWsPrice) {
		this.ptPinloopWsPrice = ptPinloopWsPrice;
	}
	public String getPtSidePktCd() {
		return ptSidePktCd;
	}
	public void setPtSidePktCd(String ptSidePktCd) {
		this.ptSidePktCd = ptSidePktCd;
	}
	public String getPtSidePktNm() {
		return ptSidePktNm;
	}
	public void setPtSidePktNm(String ptSidePktNm) {
		this.ptSidePktNm = ptSidePktNm;
	}
	public BigDecimal getPtSidePktWsWage() {
		return ptSidePktWsWage;
	}
	public void setPtSidePktWsWage(BigDecimal ptSidePktWsWage) {
		this.ptSidePktWsWage = ptSidePktWsWage;
	}
	public Integer getPtSidePktWsPrice() {
		return ptSidePktWsPrice;
	}
	public void setPtSidePktWsPrice(Integer ptSidePktWsPrice) {
		this.ptSidePktWsPrice = ptSidePktWsPrice;
	}
	public String getPtShinobiPktCd() {
		return ptShinobiPktCd;
	}
	public void setPtShinobiPktCd(String ptShinobiPktCd) {
		this.ptShinobiPktCd = ptShinobiPktCd;
	}
	public String getPtShinobiPktNm() {
		return ptShinobiPktNm;
	}
	public void setPtShinobiPktNm(String ptShinobiPktNm) {
		this.ptShinobiPktNm = ptShinobiPktNm;
	}
	public BigDecimal getPtShinobiPktWsWage() {
		return ptShinobiPktWsWage;
	}
	public void setPtShinobiPktWsWage(BigDecimal ptShinobiPktWsWage) {
		this.ptShinobiPktWsWage = ptShinobiPktWsWage;
	}
	public Integer getPtShinobiPktWsPrice() {
		return ptShinobiPktWsPrice;
	}
	public void setPtShinobiPktWsPrice(Integer ptShinobiPktWsPrice) {
		this.ptShinobiPktWsPrice = ptShinobiPktWsPrice;
	}
	public String getPtCoinPktCd() {
		return ptCoinPktCd;
	}
	public void setPtCoinPktCd(String ptCoinPktCd) {
		this.ptCoinPktCd = ptCoinPktCd;
	}
	public String getPtCoinPktNm() {
		return ptCoinPktNm;
	}
	public void setPtCoinPktNm(String ptCoinPktNm) {
		this.ptCoinPktNm = ptCoinPktNm;
	}
	public BigDecimal getPtCoinPktWsWage() {
		return ptCoinPktWsWage;
	}
	public void setPtCoinPktWsWage(BigDecimal ptCoinPktWsWage) {
		this.ptCoinPktWsWage = ptCoinPktWsWage;
	}
	public Integer getPtCoinPktWsPrice() {
		return ptCoinPktWsPrice;
	}
	public void setPtCoinPktWsPrice(Integer ptCoinPktWsPrice) {
		this.ptCoinPktWsPrice = ptCoinPktWsPrice;
	}
	public String getPtFlapcoinPktCd() {
		return ptFlapcoinPktCd;
	}
	public void setPtFlapcoinPktCd(String ptFlapcoinPktCd) {
		this.ptFlapcoinPktCd = ptFlapcoinPktCd;
	}
	public String getPtFlapcoinPktNm() {
		return ptFlapcoinPktNm;
	}
	public void setPtFlapcoinPktNm(String ptFlapcoinPktNm) {
		this.ptFlapcoinPktNm = ptFlapcoinPktNm;
	}
	public BigDecimal getPtFlapcoinPktWsWage() {
		return ptFlapcoinPktWsWage;
	}
	public void setPtFlapcoinPktWsWage(BigDecimal ptFlapcoinPktWsWage) {
		this.ptFlapcoinPktWsWage = ptFlapcoinPktWsWage;
	}
	public Integer getPtFlapcoinPktWsPrice() {
		return ptFlapcoinPktWsPrice;
	}
	public void setPtFlapcoinPktWsPrice(Integer ptFlapcoinPktWsPrice) {
		this.ptFlapcoinPktWsPrice = ptFlapcoinPktWsPrice;
	}
	public String getPtLeftPisPktCd() {
		return ptLeftPisPktCd;
	}
	public void setPtLeftPisPktCd(String ptLeftPisPktCd) {
		this.ptLeftPisPktCd = ptLeftPisPktCd;
	}
	public String getPtLeftPisPktNm() {
		return ptLeftPisPktNm;
	}
	public void setPtLeftPisPktNm(String ptLeftPisPktNm) {
		this.ptLeftPisPktNm = ptLeftPisPktNm;
	}
	public BigDecimal getPtLeftPisPktWsWage() {
		return ptLeftPisPktWsWage;
	}
	public void setPtLeftPisPktWsWage(BigDecimal ptLeftPisPktWsWage) {
		this.ptLeftPisPktWsWage = ptLeftPisPktWsWage;
	}
	public Integer getPtLeftPisPktWsPrice() {
		return ptLeftPisPktWsPrice;
	}
	public void setPtLeftPisPktWsPrice(Integer ptLeftPisPktWsPrice) {
		this.ptLeftPisPktWsPrice = ptLeftPisPktWsPrice;
	}
	public String getPtRightPisPktCd() {
		return ptRightPisPktCd;
	}
	public void setPtRightPisPktCd(String ptRightPisPktCd) {
		this.ptRightPisPktCd = ptRightPisPktCd;
	}
	public String getPtRightPisPktNm() {
		return ptRightPisPktNm;
	}
	public void setPtRightPisPktNm(String ptRightPisPktNm) {
		this.ptRightPisPktNm = ptRightPisPktNm;
	}
	public BigDecimal getPtRightPisPktWsWage() {
		return ptRightPisPktWsWage;
	}
	public void setPtRightPisPktWsWage(BigDecimal ptRightPisPktWsWage) {
		this.ptRightPisPktWsWage = ptRightPisPktWsWage;
	}
	public Integer getPtRightPisPktWsPrice() {
		return ptRightPisPktWsPrice;
	}
	public void setPtRightPisPktWsPrice(Integer ptRightPisPktWsPrice) {
		this.ptRightPisPktWsPrice = ptRightPisPktWsPrice;
	}
	public String getPtVCutCd() {
		return ptVCutCd;
	}
	public void setPtVCutCd(String ptVCutCd) {
		this.ptVCutCd = ptVCutCd;
	}
	public String getPtVCutNm() {
		return ptVCutNm;
	}
	public void setPtVCutNm(String ptVCutNm) {
		this.ptVCutNm = ptVCutNm;
	}
	public BigDecimal getPtVCutWsWage() {
		return ptVCutWsWage;
	}
	public void setPtVCutWsWage(BigDecimal ptVCutWsWage) {
		this.ptVCutWsWage = ptVCutWsWage;
	}
	public Integer getPtVCutWsPrice() {
		return ptVCutWsPrice;
	}
	public void setPtVCutWsPrice(Integer ptVCutWsPrice) {
		this.ptVCutWsPrice = ptVCutWsPrice;
	}
	public String getPtHemUpCd() {
		return ptHemUpCd;
	}
	public void setPtHemUpCd(String ptHemUpCd) {
		this.ptHemUpCd = ptHemUpCd;
	}
	public String getPtHemUpNm() {
		return ptHemUpNm;
	}
	public void setPtHemUpNm(String ptHemUpNm) {
		this.ptHemUpNm = ptHemUpNm;
	}
	public BigDecimal getPtHemUpWsWage() {
		return ptHemUpWsWage;
	}
	public void setPtHemUpWsWage(BigDecimal ptHemUpWsWage) {
		this.ptHemUpWsWage = ptHemUpWsWage;
	}
	public Integer getPtHemUpWsPrice() {
		return ptHemUpWsPrice;
	}
	public void setPtHemUpWsPrice(Integer ptHemUpWsPrice) {
		this.ptHemUpWsPrice = ptHemUpWsPrice;
	}
	public String getPtDblWidthCd() {
		return ptDblWidthCd;
	}
	public void setPtDblWidthCd(String ptDblWidthCd) {
		this.ptDblWidthCd = ptDblWidthCd;
	}
	public String getPtDblWidthNm() {
		return ptDblWidthNm;
	}
	public void setPtDblWidthNm(String ptDblWidthNm) {
		this.ptDblWidthNm = ptDblWidthNm;
	}
	public BigDecimal getPtDblWidthWsWage() {
		return ptDblWidthWsWage;
	}
	public void setPtDblWidthWsWage(BigDecimal ptDblWidthWsWage) {
		this.ptDblWidthWsWage = ptDblWidthWsWage;
	}
	public Integer getPtDblWidthWsPrice() {
		return ptDblWidthWsPrice;
	}
	public void setPtDblWidthWsPrice(Integer ptDblWidthWsPrice) {
		this.ptDblWidthWsPrice = ptDblWidthWsPrice;
	}
	public String getPtAmfStitchCd() {
		return ptAmfStitchCd;
	}
	public void setPtAmfStitchCd(String ptAmfStitchCd) {
		this.ptAmfStitchCd = ptAmfStitchCd;
	}
	public String getPtAmfStitchNm() {
		return ptAmfStitchNm;
	}
	public void setPtAmfStitchNm(String ptAmfStitchNm) {
		this.ptAmfStitchNm = ptAmfStitchNm;
	}
	public BigDecimal getPtAmfStitchWsWage() {
		return ptAmfStitchWsWage;
	}
	public void setPtAmfStitchWsWage(BigDecimal ptAmfStitchWsWage) {
		this.ptAmfStitchWsWage = ptAmfStitchWsWage;
	}
	public Integer getPtAmfStitchWsPrice() {
		return ptAmfStitchWsPrice;
	}
	public void setPtAmfStitchWsPrice(Integer ptAmfStitchWsPrice) {
		this.ptAmfStitchWsPrice = ptAmfStitchWsPrice;
	}
	public String getPtStitchPlcType() {
		return ptStitchPlcType;
	}
	public void setPtStitchPlcType(String ptStitchPlcType) {
		this.ptStitchPlcType = ptStitchPlcType;
	}
	public String getPtStitchPlcCd() {
		return ptStitchPlcCd;
	}
	public void setPtStitchPlcCd(String ptStitchPlcCd) {
		this.ptStitchPlcCd = ptStitchPlcCd;
	}
	public String getPtStitchPlcNm() {
		return ptStitchPlcNm;
	}
	public void setPtStitchPlcNm(String ptStitchPlcNm) {
		this.ptStitchPlcNm = ptStitchPlcNm;
	}
	public BigDecimal getPtStitchPlcWsWage() {
		return ptStitchPlcWsWage;
	}
	public void setPtStitchPlcWsWage(BigDecimal ptStitchPlcWsWage) {
		this.ptStitchPlcWsWage = ptStitchPlcWsWage;
	}
	public Integer getPtStitchPlcWsPrice() {
		return ptStitchPlcWsPrice;
	}
	public void setPtStitchPlcWsPrice(Integer ptStitchPlcWsPrice) {
		this.ptStitchPlcWsPrice = ptStitchPlcWsPrice;
	}
	public String getPtDblstitchPlcType() {
		return ptDblstitchPlcType;
	}
	public void setPtDblstitchPlcType(String ptDblstitchPlcType) {
		this.ptDblstitchPlcType = ptDblstitchPlcType;
	}
	public String getPtDblstitchPlcCd() {
		return ptDblstitchPlcCd;
	}
	public void setPtDblstitchPlcCd(String ptDblstitchPlcCd) {
		this.ptDblstitchPlcCd = ptDblstitchPlcCd;
	}
	public String getPtDblstitchPlcNm() {
		return ptDblstitchPlcNm;
	}
	public void setPtDblstitchPlcNm(String ptDblstitchPlcNm) {
		this.ptDblstitchPlcNm = ptDblstitchPlcNm;
	}
	public BigDecimal getPtDblstitchPlcWsWage() {
		return ptDblstitchPlcWsWage;
	}
	public void setPtDblstitchPlcWsWage(BigDecimal ptDblstitchPlcWsWage) {
		this.ptDblstitchPlcWsWage = ptDblstitchPlcWsWage;
	}
	public Integer getPtDblstitchPlcWsPrice() {
		return ptDblstitchPlcWsPrice;
	}
	public void setPtDblstitchPlcWsPrice(Integer ptDblstitchPlcWsPrice) {
		this.ptDblstitchPlcWsPrice = ptDblstitchPlcWsPrice;
	}
	public String getPtAmfColorType() {
		return ptAmfColorType;
	}
	public void setPtAmfColorType(String ptAmfColorType) {
		this.ptAmfColorType = ptAmfColorType;
	}
	public String getPtAmfColorPlcCd() {
		return ptAmfColorPlcCd;
	}
	public void setPtAmfColorPlcCd(String ptAmfColorPlcCd) {
		this.ptAmfColorPlcCd = ptAmfColorPlcCd;
	}
	public String getPtAmfColorPlcNm() {
		return ptAmfColorPlcNm;
	}
	public void setPtAmfColorPlcNm(String ptAmfColorPlcNm) {
		this.ptAmfColorPlcNm = ptAmfColorPlcNm;
	}
	public String getPtAmfColorCd() {
		return ptAmfColorCd;
	}
	public void setPtAmfColorCd(String ptAmfColorCd) {
		this.ptAmfColorCd = ptAmfColorCd;
	}
	public String getPtAmfColorNm() {
		return ptAmfColorNm;
	}
	public void setPtAmfColorNm(String ptAmfColorNm) {
		this.ptAmfColorNm = ptAmfColorNm;
	}
	public BigDecimal getPtAmfColorWsWage() {
		return ptAmfColorWsWage;
	}
	public void setPtAmfColorWsWage(BigDecimal ptAmfColorWsWage) {
		this.ptAmfColorWsWage = ptAmfColorWsWage;
	}
	public Integer getPtAmfColorWsPrice() {
		return ptAmfColorWsPrice;
	}
	public void setPtAmfColorWsPrice(Integer ptAmfColorWsPrice) {
		this.ptAmfColorWsPrice = ptAmfColorWsPrice;
	}
	public String getPtBtnholeColorType() {
		return ptBtnholeColorType;
	}
	public void setPtBtnholeColorType(String ptBtnholeColorType) {
		this.ptBtnholeColorType = ptBtnholeColorType;
	}
	public String getPtBtnholeColorPlcCd() {
		return ptBtnholeColorPlcCd;
	}
	public void setPtBtnholeColorPlcCd(String ptBtnholeColorPlcCd) {
		this.ptBtnholeColorPlcCd = ptBtnholeColorPlcCd;
	}
	public String getPtBtnholeColorPlcNm() {
		return ptBtnholeColorPlcNm;
	}
	public void setPtBtnholeColorPlcNm(String ptBtnholeColorPlcNm) {
		this.ptBtnholeColorPlcNm = ptBtnholeColorPlcNm;
	}
	public String getPtBtnholeColorCd() {
		return ptBtnholeColorCd;
	}
	public void setPtBtnholeColorCd(String ptBtnholeColorCd) {
		this.ptBtnholeColorCd = ptBtnholeColorCd;
	}
	public String getPtBtnholeColorNm() {
		return ptBtnholeColorNm;
	}
	public void setPtBtnholeColorNm(String ptBtnholeColorNm) {
		this.ptBtnholeColorNm = ptBtnholeColorNm;
	}
	public BigDecimal getPtBtnholeColorWsWage() {
		return ptBtnholeColorWsWage;
	}
	public void setPtBtnholeColorWsWage(BigDecimal ptBtnholeColorWsWage) {
		this.ptBtnholeColorWsWage = ptBtnholeColorWsWage;
	}
	public Integer getPtBtnholeColorWsPrice() {
		return ptBtnholeColorWsPrice;
	}
	public void setPtBtnholeColorWsPrice(Integer ptBtnholeColorWsPrice) {
		this.ptBtnholeColorWsPrice = ptBtnholeColorWsPrice;
	}
	public String getPtBtnthreadColorType() {
		return ptBtnthreadColorType;
	}
	public void setPtBtnthreadColorType(String ptBtnthreadColorType) {
		this.ptBtnthreadColorType = ptBtnthreadColorType;
	}
	public String getPtBtnthreadColorPlcCd() {
		return ptBtnthreadColorPlcCd;
	}
	public void setPtBtnthreadColorPlcCd(String ptBtnthreadColorPlcCd) {
		this.ptBtnthreadColorPlcCd = ptBtnthreadColorPlcCd;
	}
	public String getPtBtnthreadColorPlcNm() {
		return ptBtnthreadColorPlcNm;
	}
	public void setPtBtnthreadColorPlcNm(String ptBtnthreadColorPlcNm) {
		this.ptBtnthreadColorPlcNm = ptBtnthreadColorPlcNm;
	}
	public String getPtBtnthreadColorCd() {
		return ptBtnthreadColorCd;
	}
	public void setPtBtnthreadColorCd(String ptBtnthreadColorCd) {
		this.ptBtnthreadColorCd = ptBtnthreadColorCd;
	}
	public String getPtBtnthreadColorNm() {
		return ptBtnthreadColorNm;
	}
	public void setPtBtnthreadColorNm(String ptBtnthreadColorNm) {
		this.ptBtnthreadColorNm = ptBtnthreadColorNm;
	}
	public BigDecimal getPtBtnthreadColorWsWage() {
		return ptBtnthreadColorWsWage;
	}
	public void setPtBtnthreadColorWsWage(BigDecimal ptBtnthreadColorWsWage) {
		this.ptBtnthreadColorWsWage = ptBtnthreadColorWsWage;
	}
	public Integer getPtBtnthreadColorWsPrice() {
		return ptBtnthreadColorWsPrice;
	}
	public void setPtBtnthreadColorWsPrice(Integer ptBtnthreadColorWsPrice) {
		this.ptBtnthreadColorWsPrice = ptBtnthreadColorWsPrice;
	}
	public String getPtBtnMaterialType() {
		return ptBtnMaterialType;
	}
	public void setPtBtnMaterialType(String ptBtnMaterialType) {
		this.ptBtnMaterialType = ptBtnMaterialType;
	}
	public String getPtBtnMaterialCd() {
		return ptBtnMaterialCd;
	}
	public void setPtBtnMaterialCd(String ptBtnMaterialCd) {
		this.ptBtnMaterialCd = ptBtnMaterialCd;
	}
	public String getPtBtnMaterialNm() {
		return ptBtnMaterialNm;
	}
	public void setPtBtnMaterialNm(String ptBtnMaterialNm) {
		this.ptBtnMaterialNm = ptBtnMaterialNm;
	}
	public BigDecimal getPtBtnMaterialWsWage() {
		return ptBtnMaterialWsWage;
	}
	public void setPtBtnMaterialWsWage(BigDecimal ptBtnMaterialWsWage) {
		this.ptBtnMaterialWsWage = ptBtnMaterialWsWage;
	}
	public Integer getPtBtnMaterialWsPrice() {
		return ptBtnMaterialWsPrice;
	}
	public void setPtBtnMaterialWsPrice(Integer ptBtnMaterialWsPrice) {
		this.ptBtnMaterialWsPrice = ptBtnMaterialWsPrice;
	}
	public String getPtSuspenderBtnCd() {
		return ptSuspenderBtnCd;
	}
	public void setPtSuspenderBtnCd(String ptSuspenderBtnCd) {
		this.ptSuspenderBtnCd = ptSuspenderBtnCd;
	}
	public String getPtSuspenderBtnNm() {
		return ptSuspenderBtnNm;
	}
	public void setPtSuspenderBtnNm(String ptSuspenderBtnNm) {
		this.ptSuspenderBtnNm = ptSuspenderBtnNm;
	}
	public BigDecimal getPtSuspenderBtnWsWage() {
		return ptSuspenderBtnWsWage;
	}
	public void setPtSuspenderBtnWsWage(BigDecimal ptSuspenderBtnWsWage) {
		this.ptSuspenderBtnWsWage = ptSuspenderBtnWsWage;
	}
	public Integer getPtSuspenderBtnWsPrice() {
		return ptSuspenderBtnWsPrice;
	}
	public void setPtSuspenderBtnWsPrice(Integer ptSuspenderBtnWsPrice) {
		this.ptSuspenderBtnWsPrice = ptSuspenderBtnWsPrice;
	}
	public String getPtNonSlipCd() {
		return ptNonSlipCd;
	}
	public void setPtNonSlipCd(String ptNonSlipCd) {
		this.ptNonSlipCd = ptNonSlipCd;
	}
	public String getPtNonSlipNm() {
		return ptNonSlipNm;
	}
	public void setPtNonSlipNm(String ptNonSlipNm) {
		this.ptNonSlipNm = ptNonSlipNm;
	}
	public BigDecimal getPtNonSlipWsWage() {
		return ptNonSlipWsWage;
	}
	public void setPtNonSlipWsWage(BigDecimal ptNonSlipWsWage) {
		this.ptNonSlipWsWage = ptNonSlipWsWage;
	}
	public Integer getPtNonSlipWsPrice() {
		return ptNonSlipWsPrice;
	}
	public void setPtNonSlipWsPrice(Integer ptNonSlipWsPrice) {
		this.ptNonSlipWsPrice = ptNonSlipWsPrice;
	}
	public String getPtChicSlipCd() {
		return ptChicSlipCd;
	}
	public void setPtChicSlipCd(String ptChicSlipCd) {
		this.ptChicSlipCd = ptChicSlipCd;
	}
	public String getPtChicSlipNm() {
		return ptChicSlipNm;
	}
	public void setPtChicSlipNm(String ptChicSlipNm) {
		this.ptChicSlipNm = ptChicSlipNm;
	}
	public BigDecimal getPtChicSlipWsWage() {
		return ptChicSlipWsWage;
	}
	public void setPtChicSlipWsWage(BigDecimal ptChicSlipWsWage) {
		this.ptChicSlipWsWage = ptChicSlipWsWage;
	}
	public Integer getPtChicSlipWsPrice() {
		return ptChicSlipWsPrice;
	}
	public void setPtChicSlipWsPrice(Integer ptChicSlipWsPrice) {
		this.ptChicSlipWsPrice = ptChicSlipWsPrice;
	}
	public String getPtShapeMemoryCd() {
		return ptShapeMemoryCd;
	}
	public void setPtShapeMemoryCd(String ptShapeMemoryCd) {
		this.ptShapeMemoryCd = ptShapeMemoryCd;
	}
	public String getPtShapeMemoryNm() {
		return ptShapeMemoryNm;
	}
	public void setPtShapeMemoryNm(String ptShapeMemoryNm) {
		this.ptShapeMemoryNm = ptShapeMemoryNm;
	}
	public BigDecimal getPtShapeMemoryWsWage() {
		return ptShapeMemoryWsWage;
	}
	public void setPtShapeMemoryWsWage(BigDecimal ptShapeMemoryWsWage) {
		this.ptShapeMemoryWsWage = ptShapeMemoryWsWage;
	}
	public Integer getPtShapeMemoryWsPrice() {
		return ptShapeMemoryWsPrice;
	}
	public void setPtShapeMemoryWsPrice(Integer ptShapeMemoryWsPrice) {
		this.ptShapeMemoryWsPrice = ptShapeMemoryWsPrice;
	}
	public String getPtShoeSoreCd() {
		return ptShoeSoreCd;
	}
	public void setPtShoeSoreCd(String ptShoeSoreCd) {
		this.ptShoeSoreCd = ptShoeSoreCd;
	}
	public String getPtShoeSoreNm() {
		return ptShoeSoreNm;
	}
	public void setPtShoeSoreNm(String ptShoeSoreNm) {
		this.ptShoeSoreNm = ptShoeSoreNm;
	}
	public BigDecimal getPtShoeSoreWsWage() {
		return ptShoeSoreWsWage;
	}
	public void setPtShoeSoreWsWage(BigDecimal ptShoeSoreWsWage) {
		this.ptShoeSoreWsWage = ptShoeSoreWsWage;
	}
	public Integer getPtShoeSoreWsPrice() {
		return ptShoeSoreWsPrice;
	}
	public void setPtShoeSoreWsPrice(Integer ptShoeSoreWsPrice) {
		this.ptShoeSoreWsPrice = ptShoeSoreWsPrice;
	}
	public String getPtSideStripeCd() {
		return ptSideStripeCd;
	}
	public void setPtSideStripeCd(String ptSideStripeCd) {
		this.ptSideStripeCd = ptSideStripeCd;
	}
	public String getPtSideStripeNm() {
		return ptSideStripeNm;
	}
	public void setPtSideStripeNm(String ptSideStripeNm) {
		this.ptSideStripeNm = ptSideStripeNm;
	}
	public BigDecimal getPtSideStripeWsWage() {
		return ptSideStripeWsWage;
	}
	public void setPtSideStripeWsWage(BigDecimal ptSideStripeWsWage) {
		this.ptSideStripeWsWage = ptSideStripeWsWage;
	}
	public Integer getPtSideStripeWsPrice() {
		return ptSideStripeWsPrice;
	}
	public void setPtSideStripeWsPrice(Integer ptSideStripeWsPrice) {
		this.ptSideStripeWsPrice = ptSideStripeWsPrice;
	}
	public String getPtSideStripeWidthCd() {
		return ptSideStripeWidthCd;
	}
	public void setPtSideStripeWidthCd(String ptSideStripeWidthCd) {
		this.ptSideStripeWidthCd = ptSideStripeWidthCd;
	}
	public String getPtSideStripeWidthNm() {
		return ptSideStripeWidthNm;
	}
	public void setPtSideStripeWidthNm(String ptSideStripeWidthNm) {
		this.ptSideStripeWidthNm = ptSideStripeWidthNm;
	}
	public BigDecimal getPtSideStripeWidthWsWage() {
		return ptSideStripeWidthWsWage;
	}
	public void setPtSideStripeWidthWsWage(BigDecimal ptSideStripeWidthWsWage) {
		this.ptSideStripeWidthWsWage = ptSideStripeWidthWsWage;
	}
	public Integer getPtSideStripeWidthWsPrice() {
		return ptSideStripeWidthWsPrice;
	}
	public void setPtSideStripeWidthWsPrice(Integer ptSideStripeWidthWsPrice) {
		this.ptSideStripeWidthWsPrice = ptSideStripeWidthWsPrice;
	}
	public String getPt2ModelCd() {
		return pt2ModelCd;
	}
	public void setPt2ModelCd(String pt2ModelCd) {
		this.pt2ModelCd = pt2ModelCd;
	}
	public String getPt2ModelNm() {
		return pt2ModelNm;
	}
	public void setPt2ModelNm(String pt2ModelNm) {
		this.pt2ModelNm = pt2ModelNm;
	}
	public BigDecimal getPt2ModelWsWage() {
		return pt2ModelWsWage;
	}
	public void setPt2ModelWsWage(BigDecimal pt2ModelWsWage) {
		this.pt2ModelWsWage = pt2ModelWsWage;
	}
	public Integer getPt2ModelWsPrice() {
		return pt2ModelWsPrice;
	}
	public void setPt2ModelWsPrice(Integer pt2ModelWsPrice) {
		this.pt2ModelWsPrice = pt2ModelWsPrice;
	}
	public String getPt2TackCd() {
		return pt2TackCd;
	}
	public void setPt2TackCd(String pt2TackCd) {
		this.pt2TackCd = pt2TackCd;
	}
	public String getPt2TackNm() {
		return pt2TackNm;
	}
	public void setPt2TackNm(String pt2TackNm) {
		this.pt2TackNm = pt2TackNm;
	}
	public BigDecimal getPt2TackWsWage() {
		return pt2TackWsWage;
	}
	public void setPt2TackWsWage(BigDecimal pt2TackWsWage) {
		this.pt2TackWsWage = pt2TackWsWage;
	}
	public Integer getPt2TackWsPrice() {
		return pt2TackWsPrice;
	}
	public void setPt2TackWsPrice(Integer pt2TackWsPrice) {
		this.pt2TackWsPrice = pt2TackWsPrice;
	}
	public String getPt2KneeinnerTypeCd() {
		return pt2KneeinnerTypeCd;
	}
	public void setPt2KneeinnerTypeCd(String pt2KneeinnerTypeCd) {
		this.pt2KneeinnerTypeCd = pt2KneeinnerTypeCd;
	}
	public String getPt2KneeinnerTypeNm() {
		return pt2KneeinnerTypeNm;
	}
	public void setPt2KneeinnerTypeNm(String pt2KneeinnerTypeNm) {
		this.pt2KneeinnerTypeNm = pt2KneeinnerTypeNm;
	}
	public BigDecimal getPt2KneeinnerTypeWsWage() {
		return pt2KneeinnerTypeWsWage;
	}
	public void setPt2KneeinnerTypeWsWage(BigDecimal pt2KneeinnerTypeWsWage) {
		this.pt2KneeinnerTypeWsWage = pt2KneeinnerTypeWsWage;
	}
	public Integer getPt2KneeinnerTypeWsPrice() {
		return pt2KneeinnerTypeWsPrice;
	}
	public void setPt2KneeinnerTypeWsPrice(Integer pt2KneeinnerTypeWsPrice) {
		this.pt2KneeinnerTypeWsPrice = pt2KneeinnerTypeWsPrice;
	}
	public String getPt2KneeinnerClothCd() {
		return pt2KneeinnerClothCd;
	}
	public void setPt2KneeinnerClothCd(String pt2KneeinnerClothCd) {
		this.pt2KneeinnerClothCd = pt2KneeinnerClothCd;
	}
	public String getPt2KneeinnerClothNm() {
		return pt2KneeinnerClothNm;
	}
	public void setPt2KneeinnerClothNm(String pt2KneeinnerClothNm) {
		this.pt2KneeinnerClothNm = pt2KneeinnerClothNm;
	}
	public BigDecimal getPt2KneeinnerClothWsWage() {
		return pt2KneeinnerClothWsWage;
	}
	public void setPt2KneeinnerClothWsWage(BigDecimal pt2KneeinnerClothWsWage) {
		this.pt2KneeinnerClothWsWage = pt2KneeinnerClothWsWage;
	}
	public Integer getPt2KneeinnerClothWsPrice() {
		return pt2KneeinnerClothWsPrice;
	}
	public void setPt2KneeinnerClothWsPrice(Integer pt2KneeinnerClothWsPrice) {
		this.pt2KneeinnerClothWsPrice = pt2KneeinnerClothWsPrice;
	}
	public String getPt2FrtTypeCd() {
		return pt2FrtTypeCd;
	}
	public void setPt2FrtTypeCd(String pt2FrtTypeCd) {
		this.pt2FrtTypeCd = pt2FrtTypeCd;
	}
	public String getPt2FrtTypeNm() {
		return pt2FrtTypeNm;
	}
	public void setPt2FrtTypeNm(String pt2FrtTypeNm) {
		this.pt2FrtTypeNm = pt2FrtTypeNm;
	}
	public BigDecimal getPt2FrtTypeWsWage() {
		return pt2FrtTypeWsWage;
	}
	public void setPt2FrtTypeWsWage(BigDecimal pt2FrtTypeWsWage) {
		this.pt2FrtTypeWsWage = pt2FrtTypeWsWage;
	}
	public Integer getPt2FrtTypeWsPrice() {
		return pt2FrtTypeWsPrice;
	}
	public void setPt2FrtTypeWsPrice(Integer pt2FrtTypeWsPrice) {
		this.pt2FrtTypeWsPrice = pt2FrtTypeWsPrice;
	}
	public String getPt2PancherinaCd() {
		return pt2PancherinaCd;
	}
	public void setPt2PancherinaCd(String pt2PancherinaCd) {
		this.pt2PancherinaCd = pt2PancherinaCd;
	}
	public String getPt2PancherinaNm() {
		return pt2PancherinaNm;
	}
	public void setPt2PancherinaNm(String pt2PancherinaNm) {
		this.pt2PancherinaNm = pt2PancherinaNm;
	}
	public BigDecimal getPt2PancherinaWsWage() {
		return pt2PancherinaWsWage;
	}
	public void setPt2PancherinaWsWage(BigDecimal pt2PancherinaWsWage) {
		this.pt2PancherinaWsWage = pt2PancherinaWsWage;
	}
	public Integer getPt2PancherinaWsPrice() {
		return pt2PancherinaWsPrice;
	}
	public void setPt2PancherinaWsPrice(Integer pt2PancherinaWsPrice) {
		this.pt2PancherinaWsPrice = pt2PancherinaWsPrice;
	}
	public String getPt2AdjusterCd() {
		return pt2AdjusterCd;
	}
	public void setPt2AdjusterCd(String pt2AdjusterCd) {
		this.pt2AdjusterCd = pt2AdjusterCd;
	}
	public String getPt2AdjusterNm() {
		return pt2AdjusterNm;
	}
	public void setPt2AdjusterNm(String pt2AdjusterNm) {
		this.pt2AdjusterNm = pt2AdjusterNm;
	}
	public BigDecimal getPt2AdjusterWsWage() {
		return pt2AdjusterWsWage;
	}
	public void setPt2AdjusterWsWage(BigDecimal pt2AdjusterWsWage) {
		this.pt2AdjusterWsWage = pt2AdjusterWsWage;
	}
	public Integer getPt2AdjusterWsPrice() {
		return pt2AdjusterWsPrice;
	}
	public void setPt2AdjusterWsPrice(Integer pt2AdjusterWsPrice) {
		this.pt2AdjusterWsPrice = pt2AdjusterWsPrice;
	}
	public String getPt2BeltloopType() {
		return pt2BeltloopType;
	}
	public void setPt2BeltloopType(String pt2BeltloopType) {
		this.pt2BeltloopType = pt2BeltloopType;
	}
	public String getPt2BeltloopCd() {
		return pt2BeltloopCd;
	}
	public void setPt2BeltloopCd(String pt2BeltloopCd) {
		this.pt2BeltloopCd = pt2BeltloopCd;
	}
	public String getPt2BeltloopNm() {
		return pt2BeltloopNm;
	}
	public void setPt2BeltloopNm(String pt2BeltloopNm) {
		this.pt2BeltloopNm = pt2BeltloopNm;
	}
	public BigDecimal getPt2BeltloopWsWage() {
		return pt2BeltloopWsWage;
	}
	public void setPt2BeltloopWsWage(BigDecimal pt2BeltloopWsWage) {
		this.pt2BeltloopWsWage = pt2BeltloopWsWage;
	}
	public Integer getPt2BeltloopWsPrice() {
		return pt2BeltloopWsPrice;
	}
	public void setPt2BeltloopWsPrice(Integer pt2BeltloopWsPrice) {
		this.pt2BeltloopWsPrice = pt2BeltloopWsPrice;
	}
	public String getPt2PinloopCd() {
		return pt2PinloopCd;
	}
	public void setPt2PinloopCd(String pt2PinloopCd) {
		this.pt2PinloopCd = pt2PinloopCd;
	}
	public String getPt2PinloopNm() {
		return pt2PinloopNm;
	}
	public void setPt2PinloopNm(String pt2PinloopNm) {
		this.pt2PinloopNm = pt2PinloopNm;
	}
	public BigDecimal getPt2PinloopWsWage() {
		return pt2PinloopWsWage;
	}
	public void setPt2PinloopWsWage(BigDecimal pt2PinloopWsWage) {
		this.pt2PinloopWsWage = pt2PinloopWsWage;
	}
	public Integer getPt2PinloopWsPrice() {
		return pt2PinloopWsPrice;
	}
	public void setPt2PinloopWsPrice(Integer pt2PinloopWsPrice) {
		this.pt2PinloopWsPrice = pt2PinloopWsPrice;
	}
	public String getPt2SidePktCd() {
		return pt2SidePktCd;
	}
	public void setPt2SidePktCd(String pt2SidePktCd) {
		this.pt2SidePktCd = pt2SidePktCd;
	}
	public String getPt2SidePktNm() {
		return pt2SidePktNm;
	}
	public void setPt2SidePktNm(String pt2SidePktNm) {
		this.pt2SidePktNm = pt2SidePktNm;
	}
	public BigDecimal getPt2SidePktWsWage() {
		return pt2SidePktWsWage;
	}
	public void setPt2SidePktWsWage(BigDecimal pt2SidePktWsWage) {
		this.pt2SidePktWsWage = pt2SidePktWsWage;
	}
	public Integer getPt2SidePktWsPrice() {
		return pt2SidePktWsPrice;
	}
	public void setPt2SidePktWsPrice(Integer pt2SidePktWsPrice) {
		this.pt2SidePktWsPrice = pt2SidePktWsPrice;
	}
	public String getPt2ShinobiPktCd() {
		return pt2ShinobiPktCd;
	}
	public void setPt2ShinobiPktCd(String pt2ShinobiPktCd) {
		this.pt2ShinobiPktCd = pt2ShinobiPktCd;
	}
	public String getPt2ShinobiPktNm() {
		return pt2ShinobiPktNm;
	}
	public void setPt2ShinobiPktNm(String pt2ShinobiPktNm) {
		this.pt2ShinobiPktNm = pt2ShinobiPktNm;
	}
	public BigDecimal getPt2ShinobiPktWsWage() {
		return pt2ShinobiPktWsWage;
	}
	public void setPt2ShinobiPktWsWage(BigDecimal pt2ShinobiPktWsWage) {
		this.pt2ShinobiPktWsWage = pt2ShinobiPktWsWage;
	}
	public Integer getPt2ShinobiPktWsPrice() {
		return pt2ShinobiPktWsPrice;
	}
	public void setPt2ShinobiPktWsPrice(Integer pt2ShinobiPktWsPrice) {
		this.pt2ShinobiPktWsPrice = pt2ShinobiPktWsPrice;
	}
	public String getPt2CoinPktCd() {
		return pt2CoinPktCd;
	}
	public void setPt2CoinPktCd(String pt2CoinPktCd) {
		this.pt2CoinPktCd = pt2CoinPktCd;
	}
	public String getPt2CoinPktNm() {
		return pt2CoinPktNm;
	}
	public void setPt2CoinPktNm(String pt2CoinPktNm) {
		this.pt2CoinPktNm = pt2CoinPktNm;
	}
	public BigDecimal getPt2CoinPktWsWage() {
		return pt2CoinPktWsWage;
	}
	public void setPt2CoinPktWsWage(BigDecimal pt2CoinPktWsWage) {
		this.pt2CoinPktWsWage = pt2CoinPktWsWage;
	}
	public Integer getPt2CoinPktWsPrice() {
		return pt2CoinPktWsPrice;
	}
	public void setPt2CoinPktWsPrice(Integer pt2CoinPktWsPrice) {
		this.pt2CoinPktWsPrice = pt2CoinPktWsPrice;
	}
	public String getPt2FlapcoinPktCd() {
		return pt2FlapcoinPktCd;
	}
	public void setPt2FlapcoinPktCd(String pt2FlapcoinPktCd) {
		this.pt2FlapcoinPktCd = pt2FlapcoinPktCd;
	}
	public String getPt2FlapcoinPktNm() {
		return pt2FlapcoinPktNm;
	}
	public void setPt2FlapcoinPktNm(String pt2FlapcoinPktNm) {
		this.pt2FlapcoinPktNm = pt2FlapcoinPktNm;
	}
	public BigDecimal getPt2FlapcoinPktWsWage() {
		return pt2FlapcoinPktWsWage;
	}
	public void setPt2FlapcoinPktWsWage(BigDecimal pt2FlapcoinPktWsWage) {
		this.pt2FlapcoinPktWsWage = pt2FlapcoinPktWsWage;
	}
	public Integer getPt2FlapcoinPktWsPrice() {
		return pt2FlapcoinPktWsPrice;
	}
	public void setPt2FlapcoinPktWsPrice(Integer pt2FlapcoinPktWsPrice) {
		this.pt2FlapcoinPktWsPrice = pt2FlapcoinPktWsPrice;
	}
	public String getPt2LeftPisPktCd() {
		return pt2LeftPisPktCd;
	}
	public void setPt2LeftPisPktCd(String pt2LeftPisPktCd) {
		this.pt2LeftPisPktCd = pt2LeftPisPktCd;
	}
	public String getPt2LeftPisPktNm() {
		return pt2LeftPisPktNm;
	}
	public void setPt2LeftPisPktNm(String pt2LeftPisPktNm) {
		this.pt2LeftPisPktNm = pt2LeftPisPktNm;
	}
	public BigDecimal getPt2LeftPisPktWsWage() {
		return pt2LeftPisPktWsWage;
	}
	public void setPt2LeftPisPktWsWage(BigDecimal pt2LeftPisPktWsWage) {
		this.pt2LeftPisPktWsWage = pt2LeftPisPktWsWage;
	}
	public Integer getPt2LeftPisPktWsPrice() {
		return pt2LeftPisPktWsPrice;
	}
	public void setPt2LeftPisPktWsPrice(Integer pt2LeftPisPktWsPrice) {
		this.pt2LeftPisPktWsPrice = pt2LeftPisPktWsPrice;
	}
	public String getPt2RightPisPktCd() {
		return pt2RightPisPktCd;
	}
	public void setPt2RightPisPktCd(String pt2RightPisPktCd) {
		this.pt2RightPisPktCd = pt2RightPisPktCd;
	}
	public String getPt2RightPisPktNm() {
		return pt2RightPisPktNm;
	}
	public void setPt2RightPisPktNm(String pt2RightPisPktNm) {
		this.pt2RightPisPktNm = pt2RightPisPktNm;
	}
	public BigDecimal getPt2RightPisPktWsWage() {
		return pt2RightPisPktWsWage;
	}
	public void setPt2RightPisPktWsWage(BigDecimal pt2RightPisPktWsWage) {
		this.pt2RightPisPktWsWage = pt2RightPisPktWsWage;
	}
	public Integer getPt2RightPisPktWsPrice() {
		return pt2RightPisPktWsPrice;
	}
	public void setPt2RightPisPktWsPrice(Integer pt2RightPisPktWsPrice) {
		this.pt2RightPisPktWsPrice = pt2RightPisPktWsPrice;
	}
	public String getPt2VCutCd() {
		return pt2VCutCd;
	}
	public void setPt2VCutCd(String pt2vCutCd) {
		pt2VCutCd = pt2vCutCd;
	}
	public String getPt2VCutNm() {
		return pt2VCutNm;
	}
	public void setPt2VCutNm(String pt2vCutNm) {
		pt2VCutNm = pt2vCutNm;
	}
	public BigDecimal getPt2VCutWsWage() {
		return pt2VCutWsWage;
	}
	public void setPt2VCutWsWage(BigDecimal pt2vCutWsWage) {
		pt2VCutWsWage = pt2vCutWsWage;
	}
	public Integer getPt2VCutWsPrice() {
		return pt2VCutWsPrice;
	}
	public void setPt2VCutWsPrice(Integer pt2vCutWsPrice) {
		pt2VCutWsPrice = pt2vCutWsPrice;
	}
	public String getPt2HemUpCd() {
		return pt2HemUpCd;
	}
	public void setPt2HemUpCd(String pt2HemUpCd) {
		this.pt2HemUpCd = pt2HemUpCd;
	}
	public String getPt2HemUpNm() {
		return pt2HemUpNm;
	}
	public void setPt2HemUpNm(String pt2HemUpNm) {
		this.pt2HemUpNm = pt2HemUpNm;
	}
	public BigDecimal getPt2HemUpWsWage() {
		return pt2HemUpWsWage;
	}
	public void setPt2HemUpWsWage(BigDecimal pt2HemUpWsWage) {
		this.pt2HemUpWsWage = pt2HemUpWsWage;
	}
	public Integer getPt2HemUpWsPrice() {
		return pt2HemUpWsPrice;
	}
	public void setPt2HemUpWsPrice(Integer pt2HemUpWsPrice) {
		this.pt2HemUpWsPrice = pt2HemUpWsPrice;
	}
	public String getPt2DblWidthCd() {
		return pt2DblWidthCd;
	}
	public void setPt2DblWidthCd(String pt2DblWidthCd) {
		this.pt2DblWidthCd = pt2DblWidthCd;
	}
	public String getPt2DblWidthNm() {
		return pt2DblWidthNm;
	}
	public void setPt2DblWidthNm(String pt2DblWidthNm) {
		this.pt2DblWidthNm = pt2DblWidthNm;
	}
	public BigDecimal getPt2DblWidthWsWage() {
		return pt2DblWidthWsWage;
	}
	public void setPt2DblWidthWsWage(BigDecimal pt2DblWidthWsWage) {
		this.pt2DblWidthWsWage = pt2DblWidthWsWage;
	}
	public Integer getPt2DblWidthWsPrice() {
		return pt2DblWidthWsPrice;
	}
	public void setPt2DblWidthWsPrice(Integer pt2DblWidthWsPrice) {
		this.pt2DblWidthWsPrice = pt2DblWidthWsPrice;
	}
	public String getPt2AmfStitchCd() {
		return pt2AmfStitchCd;
	}
	public void setPt2AmfStitchCd(String pt2AmfStitchCd) {
		this.pt2AmfStitchCd = pt2AmfStitchCd;
	}
	public String getPt2AmfStitchNm() {
		return pt2AmfStitchNm;
	}
	public void setPt2AmfStitchNm(String pt2AmfStitchNm) {
		this.pt2AmfStitchNm = pt2AmfStitchNm;
	}
	public BigDecimal getPt2AmfStitchWsWage() {
		return pt2AmfStitchWsWage;
	}
	public void setPt2AmfStitchWsWage(BigDecimal pt2AmfStitchWsWage) {
		this.pt2AmfStitchWsWage = pt2AmfStitchWsWage;
	}
	public Integer getPt2AmfStitchWsPrice() {
		return pt2AmfStitchWsPrice;
	}
	public void setPt2AmfStitchWsPrice(Integer pt2AmfStitchWsPrice) {
		this.pt2AmfStitchWsPrice = pt2AmfStitchWsPrice;
	}
	public String getPt2StitchPlcType() {
		return pt2StitchPlcType;
	}
	public void setPt2StitchPlcType(String pt2StitchPlcType) {
		this.pt2StitchPlcType = pt2StitchPlcType;
	}
	public String getPt2StitchPlcCd() {
		return pt2StitchPlcCd;
	}
	public void setPt2StitchPlcCd(String pt2StitchPlcCd) {
		this.pt2StitchPlcCd = pt2StitchPlcCd;
	}
	public String getPt2StitchPlcNm() {
		return pt2StitchPlcNm;
	}
	public void setPt2StitchPlcNm(String pt2StitchPlcNm) {
		this.pt2StitchPlcNm = pt2StitchPlcNm;
	}
	public BigDecimal getPt2StitchPlcWsWage() {
		return pt2StitchPlcWsWage;
	}
	public void setPt2StitchPlcWsWage(BigDecimal pt2StitchPlcWsWage) {
		this.pt2StitchPlcWsWage = pt2StitchPlcWsWage;
	}
	public Integer getPt2StitchPlcWsPrice() {
		return pt2StitchPlcWsPrice;
	}
	public void setPt2StitchPlcWsPrice(Integer pt2StitchPlcWsPrice) {
		this.pt2StitchPlcWsPrice = pt2StitchPlcWsPrice;
	}
	public String getPt2DblstitchPlcType() {
		return pt2DblstitchPlcType;
	}
	public void setPt2DblstitchPlcType(String pt2DblstitchPlcType) {
		this.pt2DblstitchPlcType = pt2DblstitchPlcType;
	}
	public String getPt2DblstitchPlcCd() {
		return pt2DblstitchPlcCd;
	}
	public void setPt2DblstitchPlcCd(String pt2DblstitchPlcCd) {
		this.pt2DblstitchPlcCd = pt2DblstitchPlcCd;
	}
	public String getPt2DblstitchPlcNm() {
		return pt2DblstitchPlcNm;
	}
	public void setPt2DblstitchPlcNm(String pt2DblstitchPlcNm) {
		this.pt2DblstitchPlcNm = pt2DblstitchPlcNm;
	}
	public BigDecimal getPt2DblstitchPlcWsWage() {
		return pt2DblstitchPlcWsWage;
	}
	public void setPt2DblstitchPlcWsWage(BigDecimal pt2DblstitchPlcWsWage) {
		this.pt2DblstitchPlcWsWage = pt2DblstitchPlcWsWage;
	}
	public Integer getPt2DblstitchPlcWsPrice() {
		return pt2DblstitchPlcWsPrice;
	}
	public void setPt2DblstitchPlcWsPrice(Integer pt2DblstitchPlcWsPrice) {
		this.pt2DblstitchPlcWsPrice = pt2DblstitchPlcWsPrice;
	}
	public String getPt2AmfColorType() {
		return pt2AmfColorType;
	}
	public void setPt2AmfColorType(String pt2AmfColorType) {
		this.pt2AmfColorType = pt2AmfColorType;
	}
	public String getPt2AmfColorPlcCd() {
		return pt2AmfColorPlcCd;
	}
	public void setPt2AmfColorPlcCd(String pt2AmfColorPlcCd) {
		this.pt2AmfColorPlcCd = pt2AmfColorPlcCd;
	}
	public String getPt2AmfColorPlcNm() {
		return pt2AmfColorPlcNm;
	}
	public void setPt2AmfColorPlcNm(String pt2AmfColorPlcNm) {
		this.pt2AmfColorPlcNm = pt2AmfColorPlcNm;
	}
	public String getPt2AmfColorCd() {
		return pt2AmfColorCd;
	}
	public void setPt2AmfColorCd(String pt2AmfColorCd) {
		this.pt2AmfColorCd = pt2AmfColorCd;
	}
	public String getPt2AmfColorNm() {
		return pt2AmfColorNm;
	}
	public void setPt2AmfColorNm(String pt2AmfColorNm) {
		this.pt2AmfColorNm = pt2AmfColorNm;
	}
	public BigDecimal getPt2AmfColorWsWage() {
		return pt2AmfColorWsWage;
	}
	public void setPt2AmfColorWsWage(BigDecimal pt2AmfColorWsWage) {
		this.pt2AmfColorWsWage = pt2AmfColorWsWage;
	}
	public Integer getPt2AmfColorWsPrice() {
		return pt2AmfColorWsPrice;
	}
	public void setPt2AmfColorWsPrice(Integer pt2AmfColorWsPrice) {
		this.pt2AmfColorWsPrice = pt2AmfColorWsPrice;
	}
	public String getPt2BtnholeColorType() {
		return pt2BtnholeColorType;
	}
	public void setPt2BtnholeColorType(String pt2BtnholeColorType) {
		this.pt2BtnholeColorType = pt2BtnholeColorType;
	}
	public String getPt2BtnholeColorPlcCd() {
		return pt2BtnholeColorPlcCd;
	}
	public void setPt2BtnholeColorPlcCd(String pt2BtnholeColorPlcCd) {
		this.pt2BtnholeColorPlcCd = pt2BtnholeColorPlcCd;
	}
	public String getPt2BtnholeColorPlcNm() {
		return pt2BtnholeColorPlcNm;
	}
	public void setPt2BtnholeColorPlcNm(String pt2BtnholeColorPlcNm) {
		this.pt2BtnholeColorPlcNm = pt2BtnholeColorPlcNm;
	}
	public String getPt2BtnholeColorCd() {
		return pt2BtnholeColorCd;
	}
	public void setPt2BtnholeColorCd(String pt2BtnholeColorCd) {
		this.pt2BtnholeColorCd = pt2BtnholeColorCd;
	}
	public String getPt2BtnholeColorNm() {
		return pt2BtnholeColorNm;
	}
	public void setPt2BtnholeColorNm(String pt2BtnholeColorNm) {
		this.pt2BtnholeColorNm = pt2BtnholeColorNm;
	}
	public BigDecimal getPt2BtnholeColorWsWage() {
		return pt2BtnholeColorWsWage;
	}
	public void setPt2BtnholeColorWsWage(BigDecimal pt2BtnholeColorWsWage) {
		this.pt2BtnholeColorWsWage = pt2BtnholeColorWsWage;
	}
	public Integer getPt2BtnholeColorWsPrice() {
		return pt2BtnholeColorWsPrice;
	}
	public void setPt2BtnholeColorWsPrice(Integer pt2BtnholeColorWsPrice) {
		this.pt2BtnholeColorWsPrice = pt2BtnholeColorWsPrice;
	}
	public String getPt2BtnthreadColorType() {
		return pt2BtnthreadColorType;
	}
	public void setPt2BtnthreadColorType(String pt2BtnthreadColorType) {
		this.pt2BtnthreadColorType = pt2BtnthreadColorType;
	}
	public String getPt2BtnthreadColorPlcCd() {
		return pt2BtnthreadColorPlcCd;
	}
	public void setPt2BtnthreadColorPlcCd(String pt2BtnthreadColorPlcCd) {
		this.pt2BtnthreadColorPlcCd = pt2BtnthreadColorPlcCd;
	}
	public String getPt2BtnthreadColorPlcNm() {
		return pt2BtnthreadColorPlcNm;
	}
	public void setPt2BtnthreadColorPlcNm(String pt2BtnthreadColorPlcNm) {
		this.pt2BtnthreadColorPlcNm = pt2BtnthreadColorPlcNm;
	}
	public String getPt2BtnthreadColorCd() {
		return pt2BtnthreadColorCd;
	}
	public void setPt2BtnthreadColorCd(String pt2BtnthreadColorCd) {
		this.pt2BtnthreadColorCd = pt2BtnthreadColorCd;
	}
	public String getPt2BtnthreadColorNm() {
		return pt2BtnthreadColorNm;
	}
	public void setPt2BtnthreadColorNm(String pt2BtnthreadColorNm) {
		this.pt2BtnthreadColorNm = pt2BtnthreadColorNm;
	}
	public BigDecimal getPt2BtnthreadColorWsWage() {
		return pt2BtnthreadColorWsWage;
	}
	public void setPt2BtnthreadColorWsWage(BigDecimal pt2BtnthreadColorWsWage) {
		this.pt2BtnthreadColorWsWage = pt2BtnthreadColorWsWage;
	}
	public Integer getPt2BtnthreadColorWsPrice() {
		return pt2BtnthreadColorWsPrice;
	}
	public void setPt2BtnthreadColorWsPrice(Integer pt2BtnthreadColorWsPrice) {
		this.pt2BtnthreadColorWsPrice = pt2BtnthreadColorWsPrice;
	}
	public String getPt2BtnMaterialType() {
		return pt2BtnMaterialType;
	}
	public void setPt2BtnMaterialType(String pt2BtnMaterialType) {
		this.pt2BtnMaterialType = pt2BtnMaterialType;
	}
	public String getPt2BtnMaterialCd() {
		return pt2BtnMaterialCd;
	}
	public void setPt2BtnMaterialCd(String pt2BtnMaterialCd) {
		this.pt2BtnMaterialCd = pt2BtnMaterialCd;
	}
	public String getPt2BtnMaterialNm() {
		return pt2BtnMaterialNm;
	}
	public void setPt2BtnMaterialNm(String pt2BtnMaterialNm) {
		this.pt2BtnMaterialNm = pt2BtnMaterialNm;
	}
	public BigDecimal getPt2BtnMaterialWsWage() {
		return pt2BtnMaterialWsWage;
	}
	public void setPt2BtnMaterialWsWage(BigDecimal pt2BtnMaterialWsWage) {
		this.pt2BtnMaterialWsWage = pt2BtnMaterialWsWage;
	}
	public Integer getPt2BtnMaterialWsPrice() {
		return pt2BtnMaterialWsPrice;
	}
	public void setPt2BtnMaterialWsPrice(Integer pt2BtnMaterialWsPrice) {
		this.pt2BtnMaterialWsPrice = pt2BtnMaterialWsPrice;
	}
	public String getPt2SuspenderBtnCd() {
		return pt2SuspenderBtnCd;
	}
	public void setPt2SuspenderBtnCd(String pt2SuspenderBtnCd) {
		this.pt2SuspenderBtnCd = pt2SuspenderBtnCd;
	}
	public String getPt2SuspenderBtnNm() {
		return pt2SuspenderBtnNm;
	}
	public void setPt2SuspenderBtnNm(String pt2SuspenderBtnNm) {
		this.pt2SuspenderBtnNm = pt2SuspenderBtnNm;
	}
	public BigDecimal getPt2SuspenderBtnWsWage() {
		return pt2SuspenderBtnWsWage;
	}
	public void setPt2SuspenderBtnWsWage(BigDecimal pt2SuspenderBtnWsWage) {
		this.pt2SuspenderBtnWsWage = pt2SuspenderBtnWsWage;
	}
	public Integer getPt2SuspenderBtnWsPrice() {
		return pt2SuspenderBtnWsPrice;
	}
	public void setPt2SuspenderBtnWsPrice(Integer pt2SuspenderBtnWsPrice) {
		this.pt2SuspenderBtnWsPrice = pt2SuspenderBtnWsPrice;
	}
	public String getPt2NonSlipCd() {
		return pt2NonSlipCd;
	}
	public void setPt2NonSlipCd(String pt2NonSlipCd) {
		this.pt2NonSlipCd = pt2NonSlipCd;
	}
	public String getPt2NonSlipNm() {
		return pt2NonSlipNm;
	}
	public void setPt2NonSlipNm(String pt2NonSlipNm) {
		this.pt2NonSlipNm = pt2NonSlipNm;
	}
	public BigDecimal getPt2NonSlipWsWage() {
		return pt2NonSlipWsWage;
	}
	public void setPt2NonSlipWsWage(BigDecimal pt2NonSlipWsWage) {
		this.pt2NonSlipWsWage = pt2NonSlipWsWage;
	}
	public Integer getPt2NonSlipWsPrice() {
		return pt2NonSlipWsPrice;
	}
	public void setPt2NonSlipWsPrice(Integer pt2NonSlipWsPrice) {
		this.pt2NonSlipWsPrice = pt2NonSlipWsPrice;
	}
	public String getPt2ChicSlipCd() {
		return pt2ChicSlipCd;
	}
	public void setPt2ChicSlipCd(String pt2ChicSlipCd) {
		this.pt2ChicSlipCd = pt2ChicSlipCd;
	}
	public String getPt2ChicSlipNm() {
		return pt2ChicSlipNm;
	}
	public void setPt2ChicSlipNm(String pt2ChicSlipNm) {
		this.pt2ChicSlipNm = pt2ChicSlipNm;
	}
	public BigDecimal getPt2ChicSlipWsWage() {
		return pt2ChicSlipWsWage;
	}
	public void setPt2ChicSlipWsWage(BigDecimal pt2ChicSlipWsWage) {
		this.pt2ChicSlipWsWage = pt2ChicSlipWsWage;
	}
	public Integer getPt2ChicSlipWsPrice() {
		return pt2ChicSlipWsPrice;
	}
	public void setPt2ChicSlipWsPrice(Integer pt2ChicSlipWsPrice) {
		this.pt2ChicSlipWsPrice = pt2ChicSlipWsPrice;
	}
	public String getPt2ShapeMemoryCd() {
		return pt2ShapeMemoryCd;
	}
	public void setPt2ShapeMemoryCd(String pt2ShapeMemoryCd) {
		this.pt2ShapeMemoryCd = pt2ShapeMemoryCd;
	}
	public String getPt2ShapeMemoryNm() {
		return pt2ShapeMemoryNm;
	}
	public void setPt2ShapeMemoryNm(String pt2ShapeMemoryNm) {
		this.pt2ShapeMemoryNm = pt2ShapeMemoryNm;
	}
	public BigDecimal getPt2ShapeMemoryWsWage() {
		return pt2ShapeMemoryWsWage;
	}
	public void setPt2ShapeMemoryWsWage(BigDecimal pt2ShapeMemoryWsWage) {
		this.pt2ShapeMemoryWsWage = pt2ShapeMemoryWsWage;
	}
	public Integer getPt2ShapeMemoryWsPrice() {
		return pt2ShapeMemoryWsPrice;
	}
	public void setPt2ShapeMemoryWsPrice(Integer pt2ShapeMemoryWsPrice) {
		this.pt2ShapeMemoryWsPrice = pt2ShapeMemoryWsPrice;
	}
	public String getPt2ShoeSoreCd() {
		return pt2ShoeSoreCd;
	}
	public void setPt2ShoeSoreCd(String pt2ShoeSoreCd) {
		this.pt2ShoeSoreCd = pt2ShoeSoreCd;
	}
	public String getPt2ShoeSoreNm() {
		return pt2ShoeSoreNm;
	}
	public void setPt2ShoeSoreNm(String pt2ShoeSoreNm) {
		this.pt2ShoeSoreNm = pt2ShoeSoreNm;
	}
	public BigDecimal getPt2ShoeSoreWsWage() {
		return pt2ShoeSoreWsWage;
	}
	public void setPt2ShoeSoreWsWage(BigDecimal pt2ShoeSoreWsWage) {
		this.pt2ShoeSoreWsWage = pt2ShoeSoreWsWage;
	}
	public Integer getPt2ShoeSoreWsPrice() {
		return pt2ShoeSoreWsPrice;
	}
	public void setPt2ShoeSoreWsPrice(Integer pt2ShoeSoreWsPrice) {
		this.pt2ShoeSoreWsPrice = pt2ShoeSoreWsPrice;
	}
	public String getPt2SideStripeCd() {
		return pt2SideStripeCd;
	}
	public void setPt2SideStripeCd(String pt2SideStripeCd) {
		this.pt2SideStripeCd = pt2SideStripeCd;
	}
	public String getPt2SideStripeNm() {
		return pt2SideStripeNm;
	}
	public void setPt2SideStripeNm(String pt2SideStripeNm) {
		this.pt2SideStripeNm = pt2SideStripeNm;
	}
	public BigDecimal getPt2SideStripeWsWage() {
		return pt2SideStripeWsWage;
	}
	public void setPt2SideStripeWsWage(BigDecimal pt2SideStripeWsWage) {
		this.pt2SideStripeWsWage = pt2SideStripeWsWage;
	}
	public Integer getPt2SideStripeWsPrice() {
		return pt2SideStripeWsPrice;
	}
	public void setPt2SideStripeWsPrice(Integer pt2SideStripeWsPrice) {
		this.pt2SideStripeWsPrice = pt2SideStripeWsPrice;
	}
	public String getPt2SideStripeWidthCd() {
		return pt2SideStripeWidthCd;
	}
	public void setPt2SideStripeWidthCd(String pt2SideStripeWidthCd) {
		this.pt2SideStripeWidthCd = pt2SideStripeWidthCd;
	}
	public String getPt2SideStripeWidthNm() {
		return pt2SideStripeWidthNm;
	}
	public void setPt2SideStripeWidthNm(String pt2SideStripeWidthNm) {
		this.pt2SideStripeWidthNm = pt2SideStripeWidthNm;
	}
	public BigDecimal getPt2SideStripeWidthWsWage() {
		return pt2SideStripeWidthWsWage;
	}
	public void setPt2SideStripeWidthWsWage(BigDecimal pt2SideStripeWidthWsWage) {
		this.pt2SideStripeWidthWsWage = pt2SideStripeWidthWsWage;
	}
	public Integer getPt2SideStripeWidthWsPrice() {
		return pt2SideStripeWidthWsPrice;
	}
	public void setPt2SideStripeWidthWsPrice(Integer pt2SideStripeWidthWsPrice) {
		this.pt2SideStripeWidthWsPrice = pt2SideStripeWidthWsPrice;
	}
	public String getPt3ModelCd() {
		return pt3ModelCd;
	}
	public void setPt3ModelCd(String pt3ModelCd) {
		this.pt3ModelCd = pt3ModelCd;
	}
	public String getPt3ModelNm() {
		return pt3ModelNm;
	}
	public void setPt3ModelNm(String pt3ModelNm) {
		this.pt3ModelNm = pt3ModelNm;
	}
	public BigDecimal getPt3ModelWsWage() {
		return pt3ModelWsWage;
	}
	public void setPt3ModelWsWage(BigDecimal pt3ModelWsWage) {
		this.pt3ModelWsWage = pt3ModelWsWage;
	}
	public Integer getPt3ModelWsPrice() {
		return pt3ModelWsPrice;
	}
	public void setPt3ModelWsPrice(Integer pt3ModelWsPrice) {
		this.pt3ModelWsPrice = pt3ModelWsPrice;
	}
	public String getPt3TackCd() {
		return pt3TackCd;
	}
	public void setPt3TackCd(String pt3TackCd) {
		this.pt3TackCd = pt3TackCd;
	}
	public String getPt3TackNm() {
		return pt3TackNm;
	}
	public void setPt3TackNm(String pt3TackNm) {
		this.pt3TackNm = pt3TackNm;
	}
	public BigDecimal getPt3TackWsWage() {
		return pt3TackWsWage;
	}
	public void setPt3TackWsWage(BigDecimal pt3TackWsWage) {
		this.pt3TackWsWage = pt3TackWsWage;
	}
	public Integer getPt3TackWsPrice() {
		return pt3TackWsPrice;
	}
	public void setPt3TackWsPrice(Integer pt3TackWsPrice) {
		this.pt3TackWsPrice = pt3TackWsPrice;
	}
	public String getPt3KneeinnerTypeCd() {
		return pt3KneeinnerTypeCd;
	}
	public void setPt3KneeinnerTypeCd(String pt3KneeinnerTypeCd) {
		this.pt3KneeinnerTypeCd = pt3KneeinnerTypeCd;
	}
	public String getPt3KneeinnerTypeNm() {
		return pt3KneeinnerTypeNm;
	}
	public void setPt3KneeinnerTypeNm(String pt3KneeinnerTypeNm) {
		this.pt3KneeinnerTypeNm = pt3KneeinnerTypeNm;
	}
	public BigDecimal getPt3KneeinnerTypeWsWage() {
		return pt3KneeinnerTypeWsWage;
	}
	public void setPt3KneeinnerTypeWsWage(BigDecimal pt3KneeinnerTypeWsWage) {
		this.pt3KneeinnerTypeWsWage = pt3KneeinnerTypeWsWage;
	}
	public Integer getPt3KneeinnerTypeWsPrice() {
		return pt3KneeinnerTypeWsPrice;
	}
	public void setPt3KneeinnerTypeWsPrice(Integer pt3KneeinnerTypeWsPrice) {
		this.pt3KneeinnerTypeWsPrice = pt3KneeinnerTypeWsPrice;
	}
	public String getPt3KneeinnerClothCd() {
		return pt3KneeinnerClothCd;
	}
	public void setPt3KneeinnerClothCd(String pt3KneeinnerClothCd) {
		this.pt3KneeinnerClothCd = pt3KneeinnerClothCd;
	}
	public String getPt3KneeinnerClothNm() {
		return pt3KneeinnerClothNm;
	}
	public void setPt3KneeinnerClothNm(String pt3KneeinnerClothNm) {
		this.pt3KneeinnerClothNm = pt3KneeinnerClothNm;
	}
	public BigDecimal getPt3KneeinnerClothWsWage() {
		return pt3KneeinnerClothWsWage;
	}
	public void setPt3KneeinnerClothWsWage(BigDecimal pt3KneeinnerClothWsWage) {
		this.pt3KneeinnerClothWsWage = pt3KneeinnerClothWsWage;
	}
	public Integer getPt3KneeinnerClothWsPrice() {
		return pt3KneeinnerClothWsPrice;
	}
	public void setPt3KneeinnerClothWsPrice(Integer pt3KneeinnerClothWsPrice) {
		this.pt3KneeinnerClothWsPrice = pt3KneeinnerClothWsPrice;
	}
	public String getPt3FrtTypeCd() {
		return pt3FrtTypeCd;
	}
	public void setPt3FrtTypeCd(String pt3FrtTypeCd) {
		this.pt3FrtTypeCd = pt3FrtTypeCd;
	}
	public String getPt3FrtTypeNm() {
		return pt3FrtTypeNm;
	}
	public void setPt3FrtTypeNm(String pt3FrtTypeNm) {
		this.pt3FrtTypeNm = pt3FrtTypeNm;
	}
	public BigDecimal getPt3FrtTypeWsWage() {
		return pt3FrtTypeWsWage;
	}
	public void setPt3FrtTypeWsWage(BigDecimal pt3FrtTypeWsWage) {
		this.pt3FrtTypeWsWage = pt3FrtTypeWsWage;
	}
	public Integer getPt3FrtTypeWsPrice() {
		return pt3FrtTypeWsPrice;
	}
	public void setPt3FrtTypeWsPrice(Integer pt3FrtTypeWsPrice) {
		this.pt3FrtTypeWsPrice = pt3FrtTypeWsPrice;
	}
	public String getPt3PancherinaCd() {
		return pt3PancherinaCd;
	}
	public void setPt3PancherinaCd(String pt3PancherinaCd) {
		this.pt3PancherinaCd = pt3PancherinaCd;
	}
	public String getPt3PancherinaNm() {
		return pt3PancherinaNm;
	}
	public void setPt3PancherinaNm(String pt3PancherinaNm) {
		this.pt3PancherinaNm = pt3PancherinaNm;
	}
	public BigDecimal getPt3PancherinaWsWage() {
		return pt3PancherinaWsWage;
	}
	public void setPt3PancherinaWsWage(BigDecimal pt3PancherinaWsWage) {
		this.pt3PancherinaWsWage = pt3PancherinaWsWage;
	}
	public Integer getPt3PancherinaWsPrice() {
		return pt3PancherinaWsPrice;
	}
	public void setPt3PancherinaWsPrice(Integer pt3PancherinaWsPrice) {
		this.pt3PancherinaWsPrice = pt3PancherinaWsPrice;
	}
	public String getPt3AdjusterCd() {
		return pt3AdjusterCd;
	}
	public void setPt3AdjusterCd(String pt3AdjusterCd) {
		this.pt3AdjusterCd = pt3AdjusterCd;
	}
	public String getPt3AdjusterNm() {
		return pt3AdjusterNm;
	}
	public void setPt3AdjusterNm(String pt3AdjusterNm) {
		this.pt3AdjusterNm = pt3AdjusterNm;
	}
	public BigDecimal getPt3AdjusterWsWage() {
		return pt3AdjusterWsWage;
	}
	public void setPt3AdjusterWsWage(BigDecimal pt3AdjusterWsWage) {
		this.pt3AdjusterWsWage = pt3AdjusterWsWage;
	}
	public Integer getPt3AdjusterWsPrice() {
		return pt3AdjusterWsPrice;
	}
	public void setPt3AdjusterWsPrice(Integer pt3AdjusterWsPrice) {
		this.pt3AdjusterWsPrice = pt3AdjusterWsPrice;
	}
	public String getPt3BeltloopType() {
		return pt3BeltloopType;
	}
	public void setPt3BeltloopType(String pt3BeltloopType) {
		this.pt3BeltloopType = pt3BeltloopType;
	}
	public String getPt3BeltloopCd() {
		return pt3BeltloopCd;
	}
	public void setPt3BeltloopCd(String pt3BeltloopCd) {
		this.pt3BeltloopCd = pt3BeltloopCd;
	}
	public String getPt3BeltloopNm() {
		return pt3BeltloopNm;
	}
	public void setPt3BeltloopNm(String pt3BeltloopNm) {
		this.pt3BeltloopNm = pt3BeltloopNm;
	}
	public BigDecimal getPt3BeltloopWsWage() {
		return pt3BeltloopWsWage;
	}
	public void setPt3BeltloopWsWage(BigDecimal pt3BeltloopWsWage) {
		this.pt3BeltloopWsWage = pt3BeltloopWsWage;
	}
	public Integer getPt3BeltloopWsPrice() {
		return pt3BeltloopWsPrice;
	}
	public void setPt3BeltloopWsPrice(Integer pt3BeltloopWsPrice) {
		this.pt3BeltloopWsPrice = pt3BeltloopWsPrice;
	}
	public String getPt3PinloopCd() {
		return pt3PinloopCd;
	}
	public void setPt3PinloopCd(String pt3PinloopCd) {
		this.pt3PinloopCd = pt3PinloopCd;
	}
	public String getPt3PinloopNm() {
		return pt3PinloopNm;
	}
	public void setPt3PinloopNm(String pt3PinloopNm) {
		this.pt3PinloopNm = pt3PinloopNm;
	}
	public BigDecimal getPt3PinloopWsWage() {
		return pt3PinloopWsWage;
	}
	public void setPt3PinloopWsWage(BigDecimal pt3PinloopWsWage) {
		this.pt3PinloopWsWage = pt3PinloopWsWage;
	}
	public Integer getPt3PinloopWsPrice() {
		return pt3PinloopWsPrice;
	}
	public void setPt3PinloopWsPrice(Integer pt3PinloopWsPrice) {
		this.pt3PinloopWsPrice = pt3PinloopWsPrice;
	}
	public String getPt3SidePktCd() {
		return pt3SidePktCd;
	}
	public void setPt3SidePktCd(String pt3SidePktCd) {
		this.pt3SidePktCd = pt3SidePktCd;
	}
	public String getPt3SidePktNm() {
		return pt3SidePktNm;
	}
	public void setPt3SidePktNm(String pt3SidePktNm) {
		this.pt3SidePktNm = pt3SidePktNm;
	}
	public BigDecimal getPt3SidePktWsWage() {
		return pt3SidePktWsWage;
	}
	public void setPt3SidePktWsWage(BigDecimal pt3SidePktWsWage) {
		this.pt3SidePktWsWage = pt3SidePktWsWage;
	}
	public Integer getPt3SidePktWsPrice() {
		return pt3SidePktWsPrice;
	}
	public void setPt3SidePktWsPrice(Integer pt3SidePktWsPrice) {
		this.pt3SidePktWsPrice = pt3SidePktWsPrice;
	}
	public String getPt3ShinobiPktCd() {
		return pt3ShinobiPktCd;
	}
	public void setPt3ShinobiPktCd(String pt3ShinobiPktCd) {
		this.pt3ShinobiPktCd = pt3ShinobiPktCd;
	}
	public String getPt3ShinobiPktNm() {
		return pt3ShinobiPktNm;
	}
	public void setPt3ShinobiPktNm(String pt3ShinobiPktNm) {
		this.pt3ShinobiPktNm = pt3ShinobiPktNm;
	}
	public BigDecimal getPt3ShinobiPktWsWage() {
		return pt3ShinobiPktWsWage;
	}
	public void setPt3ShinobiPktWsWage(BigDecimal pt3ShinobiPktWsWage) {
		this.pt3ShinobiPktWsWage = pt3ShinobiPktWsWage;
	}
	public Integer getPt3ShinobiPktWsPrice() {
		return pt3ShinobiPktWsPrice;
	}
	public void setPt3ShinobiPktWsPrice(Integer pt3ShinobiPktWsPrice) {
		this.pt3ShinobiPktWsPrice = pt3ShinobiPktWsPrice;
	}
	public String getPt3CoinPktCd() {
		return pt3CoinPktCd;
	}
	public void setPt3CoinPktCd(String pt3CoinPktCd) {
		this.pt3CoinPktCd = pt3CoinPktCd;
	}
	public String getPt3CoinPktNm() {
		return pt3CoinPktNm;
	}
	public void setPt3CoinPktNm(String pt3CoinPktNm) {
		this.pt3CoinPktNm = pt3CoinPktNm;
	}
	public BigDecimal getPt3CoinPktWsWage() {
		return pt3CoinPktWsWage;
	}
	public void setPt3CoinPktWsWage(BigDecimal pt3CoinPktWsWage) {
		this.pt3CoinPktWsWage = pt3CoinPktWsWage;
	}
	public Integer getPt3CoinPktWsPrice() {
		return pt3CoinPktWsPrice;
	}
	public void setPt3CoinPktWsPrice(Integer pt3CoinPktWsPrice) {
		this.pt3CoinPktWsPrice = pt3CoinPktWsPrice;
	}
	public String getPt3FlapcoinPktCd() {
		return pt3FlapcoinPktCd;
	}
	public void setPt3FlapcoinPktCd(String pt3FlapcoinPktCd) {
		this.pt3FlapcoinPktCd = pt3FlapcoinPktCd;
	}
	public String getPt3FlapcoinPktNm() {
		return pt3FlapcoinPktNm;
	}
	public void setPt3FlapcoinPktNm(String pt3FlapcoinPktNm) {
		this.pt3FlapcoinPktNm = pt3FlapcoinPktNm;
	}
	public BigDecimal getPt3FlapcoinPktWsWage() {
		return pt3FlapcoinPktWsWage;
	}
	public void setPt3FlapcoinPktWsWage(BigDecimal pt3FlapcoinPktWsWage) {
		this.pt3FlapcoinPktWsWage = pt3FlapcoinPktWsWage;
	}
	public Integer getPt3FlapcoinPktWsPrice() {
		return pt3FlapcoinPktWsPrice;
	}
	public void setPt3FlapcoinPktWsPrice(Integer pt3FlapcoinPktWsPrice) {
		this.pt3FlapcoinPktWsPrice = pt3FlapcoinPktWsPrice;
	}
	public String getPt3LeftPisPktCd() {
		return pt3LeftPisPktCd;
	}
	public void setPt3LeftPisPktCd(String pt3LeftPisPktCd) {
		this.pt3LeftPisPktCd = pt3LeftPisPktCd;
	}
	public String getPt3LeftPisPktNm() {
		return pt3LeftPisPktNm;
	}
	public void setPt3LeftPisPktNm(String pt3LeftPisPktNm) {
		this.pt3LeftPisPktNm = pt3LeftPisPktNm;
	}
	public BigDecimal getPt3LeftPisPktWsWage() {
		return pt3LeftPisPktWsWage;
	}
	public void setPt3LeftPisPktWsWage(BigDecimal pt3LeftPisPktWsWage) {
		this.pt3LeftPisPktWsWage = pt3LeftPisPktWsWage;
	}
	public Integer getPt3LeftPisPktWsPrice() {
		return pt3LeftPisPktWsPrice;
	}
	public void setPt3LeftPisPktWsPrice(Integer pt3LeftPisPktWsPrice) {
		this.pt3LeftPisPktWsPrice = pt3LeftPisPktWsPrice;
	}
	public String getPt3RightPisPktCd() {
		return pt3RightPisPktCd;
	}
	public void setPt3RightPisPktCd(String pt3RightPisPktCd) {
		this.pt3RightPisPktCd = pt3RightPisPktCd;
	}
	public String getPt3RightPisPktNm() {
		return pt3RightPisPktNm;
	}
	public void setPt3RightPisPktNm(String pt3RightPisPktNm) {
		this.pt3RightPisPktNm = pt3RightPisPktNm;
	}
	public BigDecimal getPt3RightPisPktWsWage() {
		return pt3RightPisPktWsWage;
	}
	public void setPt3RightPisPktWsWage(BigDecimal pt3RightPisPktWsWage) {
		this.pt3RightPisPktWsWage = pt3RightPisPktWsWage;
	}
	public Integer getPt3RightPisPktWsPrice() {
		return pt3RightPisPktWsPrice;
	}
	public void setPt3RightPisPktWsPrice(Integer pt3RightPisPktWsPrice) {
		this.pt3RightPisPktWsPrice = pt3RightPisPktWsPrice;
	}
	public String getPt3VCutCd() {
		return pt3VCutCd;
	}
	public void setPt3VCutCd(String pt3vCutCd) {
		pt3VCutCd = pt3vCutCd;
	}
	public String getPt3VCutNm() {
		return pt3VCutNm;
	}
	public void setPt3VCutNm(String pt3vCutNm) {
		pt3VCutNm = pt3vCutNm;
	}
	public BigDecimal getPt3VCutWsWage() {
		return pt3VCutWsWage;
	}
	public void setPt3VCutWsWage(BigDecimal pt3vCutWsWage) {
		pt3VCutWsWage = pt3vCutWsWage;
	}
	public Integer getPt3VCutWsPrice() {
		return pt3VCutWsPrice;
	}
	public void setPt3VCutWsPrice(Integer pt3vCutWsPrice) {
		pt3VCutWsPrice = pt3vCutWsPrice;
	}
	public String getPt3HemUpCd() {
		return pt3HemUpCd;
	}
	public void setPt3HemUpCd(String pt3HemUpCd) {
		this.pt3HemUpCd = pt3HemUpCd;
	}
	public String getPt3HemUpNm() {
		return pt3HemUpNm;
	}
	public void setPt3HemUpNm(String pt3HemUpNm) {
		this.pt3HemUpNm = pt3HemUpNm;
	}
	public BigDecimal getPt3HemUpWsWage() {
		return pt3HemUpWsWage;
	}
	public void setPt3HemUpWsWage(BigDecimal pt3HemUpWsWage) {
		this.pt3HemUpWsWage = pt3HemUpWsWage;
	}
	public Integer getPt3HemUpWsPrice() {
		return pt3HemUpWsPrice;
	}
	public void setPt3HemUpWsPrice(Integer pt3HemUpWsPrice) {
		this.pt3HemUpWsPrice = pt3HemUpWsPrice;
	}
	public String getPt3DblWidthCd() {
		return pt3DblWidthCd;
	}
	public void setPt3DblWidthCd(String pt3DblWidthCd) {
		this.pt3DblWidthCd = pt3DblWidthCd;
	}
	public String getPt3DblWidthNm() {
		return pt3DblWidthNm;
	}
	public void setPt3DblWidthNm(String pt3DblWidthNm) {
		this.pt3DblWidthNm = pt3DblWidthNm;
	}
	public BigDecimal getPt3DblWidthWsWage() {
		return pt3DblWidthWsWage;
	}
	public void setPt3DblWidthWsWage(BigDecimal pt3DblWidthWsWage) {
		this.pt3DblWidthWsWage = pt3DblWidthWsWage;
	}
	public Integer getPt3DblWidthWsPrice() {
		return pt3DblWidthWsPrice;
	}
	public void setPt3DblWidthWsPrice(Integer pt3DblWidthWsPrice) {
		this.pt3DblWidthWsPrice = pt3DblWidthWsPrice;
	}
	public String getPt3AmfStitchCd() {
		return pt3AmfStitchCd;
	}
	public void setPt3AmfStitchCd(String pt3AmfStitchCd) {
		this.pt3AmfStitchCd = pt3AmfStitchCd;
	}
	public String getPt3AmfStitchNm() {
		return pt3AmfStitchNm;
	}
	public void setPt3AmfStitchNm(String pt3AmfStitchNm) {
		this.pt3AmfStitchNm = pt3AmfStitchNm;
	}
	public BigDecimal getPt3AmfStitchWsWage() {
		return pt3AmfStitchWsWage;
	}
	public void setPt3AmfStitchWsWage(BigDecimal pt3AmfStitchWsWage) {
		this.pt3AmfStitchWsWage = pt3AmfStitchWsWage;
	}
	public Integer getPt3AmfStitchWsPrice() {
		return pt3AmfStitchWsPrice;
	}
	public void setPt3AmfStitchWsPrice(Integer pt3AmfStitchWsPrice) {
		this.pt3AmfStitchWsPrice = pt3AmfStitchWsPrice;
	}
	public String getPt3StitchPlcType() {
		return pt3StitchPlcType;
	}
	public void setPt3StitchPlcType(String pt3StitchPlcType) {
		this.pt3StitchPlcType = pt3StitchPlcType;
	}
	public String getPt3StitchPlcCd() {
		return pt3StitchPlcCd;
	}
	public void setPt3StitchPlcCd(String pt3StitchPlcCd) {
		this.pt3StitchPlcCd = pt3StitchPlcCd;
	}
	public String getPt3StitchPlcNm() {
		return pt3StitchPlcNm;
	}
	public void setPt3StitchPlcNm(String pt3StitchPlcNm) {
		this.pt3StitchPlcNm = pt3StitchPlcNm;
	}
	public BigDecimal getPt3StitchPlcWsWage() {
		return pt3StitchPlcWsWage;
	}
	public void setPt3StitchPlcWsWage(BigDecimal pt3StitchPlcWsWage) {
		this.pt3StitchPlcWsWage = pt3StitchPlcWsWage;
	}
	public Integer getPt3StitchPlcWsPrice() {
		return pt3StitchPlcWsPrice;
	}
	public void setPt3StitchPlcWsPrice(Integer pt3StitchPlcWsPrice) {
		this.pt3StitchPlcWsPrice = pt3StitchPlcWsPrice;
	}
	public String getPt3DblstitchPlcType() {
		return pt3DblstitchPlcType;
	}
	public void setPt3DblstitchPlcType(String pt3DblstitchPlcType) {
		this.pt3DblstitchPlcType = pt3DblstitchPlcType;
	}
	public String getPt3DblstitchPlcCd() {
		return pt3DblstitchPlcCd;
	}
	public void setPt3DblstitchPlcCd(String pt3DblstitchPlcCd) {
		this.pt3DblstitchPlcCd = pt3DblstitchPlcCd;
	}
	public String getPt3DblstitchPlcNm() {
		return pt3DblstitchPlcNm;
	}
	public void setPt3DblstitchPlcNm(String pt3DblstitchPlcNm) {
		this.pt3DblstitchPlcNm = pt3DblstitchPlcNm;
	}
	public BigDecimal getPt3DblstitchPlcWsWage() {
		return pt3DblstitchPlcWsWage;
	}
	public void setPt3DblstitchPlcWsWage(BigDecimal pt3DblstitchPlcWsWage) {
		this.pt3DblstitchPlcWsWage = pt3DblstitchPlcWsWage;
	}
	public Integer getPt3DblstitchPlcWsPrice() {
		return pt3DblstitchPlcWsPrice;
	}
	public void setPt3DblstitchPlcWsPrice(Integer pt3DblstitchPlcWsPrice) {
		this.pt3DblstitchPlcWsPrice = pt3DblstitchPlcWsPrice;
	}
	public String getPt3AmfColorType() {
		return pt3AmfColorType;
	}
	public void setPt3AmfColorType(String pt3AmfColorType) {
		this.pt3AmfColorType = pt3AmfColorType;
	}
	public String getPt3AmfColorPlcCd() {
		return pt3AmfColorPlcCd;
	}
	public void setPt3AmfColorPlcCd(String pt3AmfColorPlcCd) {
		this.pt3AmfColorPlcCd = pt3AmfColorPlcCd;
	}
	public String getPt3AmfColorPlcNm() {
		return pt3AmfColorPlcNm;
	}
	public void setPt3AmfColorPlcNm(String pt3AmfColorPlcNm) {
		this.pt3AmfColorPlcNm = pt3AmfColorPlcNm;
	}
	public String getPt3AmfColorCd() {
		return pt3AmfColorCd;
	}
	public void setPt3AmfColorCd(String pt3AmfColorCd) {
		this.pt3AmfColorCd = pt3AmfColorCd;
	}
	public String getPt3AmfColorNm() {
		return pt3AmfColorNm;
	}
	public void setPt3AmfColorNm(String pt3AmfColorNm) {
		this.pt3AmfColorNm = pt3AmfColorNm;
	}
	public BigDecimal getPt3AmfColorWsWage() {
		return pt3AmfColorWsWage;
	}
	public void setPt3AmfColorWsWage(BigDecimal pt3AmfColorWsWage) {
		this.pt3AmfColorWsWage = pt3AmfColorWsWage;
	}
	public Integer getPt3AmfColorWsPrice() {
		return pt3AmfColorWsPrice;
	}
	public void setPt3AmfColorWsPrice(Integer pt3AmfColorWsPrice) {
		this.pt3AmfColorWsPrice = pt3AmfColorWsPrice;
	}
	public String getPt3BtnholeColorType() {
		return pt3BtnholeColorType;
	}
	public void setPt3BtnholeColorType(String pt3BtnholeColorType) {
		this.pt3BtnholeColorType = pt3BtnholeColorType;
	}
	public String getPt3BtnholeColorPlcCd() {
		return pt3BtnholeColorPlcCd;
	}
	public void setPt3BtnholeColorPlcCd(String pt3BtnholeColorPlcCd) {
		this.pt3BtnholeColorPlcCd = pt3BtnholeColorPlcCd;
	}
	public String getPt3BtnholeColorPlcNm() {
		return pt3BtnholeColorPlcNm;
	}
	public void setPt3BtnholeColorPlcNm(String pt3BtnholeColorPlcNm) {
		this.pt3BtnholeColorPlcNm = pt3BtnholeColorPlcNm;
	}
	public String getPt3BtnholeColorCd() {
		return pt3BtnholeColorCd;
	}
	public void setPt3BtnholeColorCd(String pt3BtnholeColorCd) {
		this.pt3BtnholeColorCd = pt3BtnholeColorCd;
	}
	public String getPt3BtnholeColorNm() {
		return pt3BtnholeColorNm;
	}
	public void setPt3BtnholeColorNm(String pt3BtnholeColorNm) {
		this.pt3BtnholeColorNm = pt3BtnholeColorNm;
	}
	public BigDecimal getPt3BtnholeColorWsWage() {
		return pt3BtnholeColorWsWage;
	}
	public void setPt3BtnholeColorWsWage(BigDecimal pt3BtnholeColorWsWage) {
		this.pt3BtnholeColorWsWage = pt3BtnholeColorWsWage;
	}
	public Integer getPt3BtnholeColorWsPrice() {
		return pt3BtnholeColorWsPrice;
	}
	public void setPt3BtnholeColorWsPrice(Integer pt3BtnholeColorWsPrice) {
		this.pt3BtnholeColorWsPrice = pt3BtnholeColorWsPrice;
	}
	public String getPt3BtnthreadColorType() {
		return pt3BtnthreadColorType;
	}
	public void setPt3BtnthreadColorType(String pt3BtnthreadColorType) {
		this.pt3BtnthreadColorType = pt3BtnthreadColorType;
	}
	public String getPt3BtnthreadColorPlcCd() {
		return pt3BtnthreadColorPlcCd;
	}
	public void setPt3BtnthreadColorPlcCd(String pt3BtnthreadColorPlcCd) {
		this.pt3BtnthreadColorPlcCd = pt3BtnthreadColorPlcCd;
	}
	public String getPt3BtnthreadColorPlcNm() {
		return pt3BtnthreadColorPlcNm;
	}
	public void setPt3BtnthreadColorPlcNm(String pt3BtnthreadColorPlcNm) {
		this.pt3BtnthreadColorPlcNm = pt3BtnthreadColorPlcNm;
	}
	public String getPt3BtnthreadColorCd() {
		return pt3BtnthreadColorCd;
	}
	public void setPt3BtnthreadColorCd(String pt3BtnthreadColorCd) {
		this.pt3BtnthreadColorCd = pt3BtnthreadColorCd;
	}
	public String getPt3BtnthreadColorNm() {
		return pt3BtnthreadColorNm;
	}
	public void setPt3BtnthreadColorNm(String pt3BtnthreadColorNm) {
		this.pt3BtnthreadColorNm = pt3BtnthreadColorNm;
	}
	public BigDecimal getPt3BtnthreadColorWsWage() {
		return pt3BtnthreadColorWsWage;
	}
	public void setPt3BtnthreadColorWsWage(BigDecimal pt3BtnthreadColorWsWage) {
		this.pt3BtnthreadColorWsWage = pt3BtnthreadColorWsWage;
	}
	public Integer getPt3BtnthreadColorWsPrice() {
		return pt3BtnthreadColorWsPrice;
	}
	public void setPt3BtnthreadColorWsPrice(Integer pt3BtnthreadColorWsPrice) {
		this.pt3BtnthreadColorWsPrice = pt3BtnthreadColorWsPrice;
	}
	public String getPt3BtnMaterialType() {
		return pt3BtnMaterialType;
	}
	public void setPt3BtnMaterialType(String pt3BtnMaterialType) {
		this.pt3BtnMaterialType = pt3BtnMaterialType;
	}
	public String getPt3BtnMaterialCd() {
		return pt3BtnMaterialCd;
	}
	public void setPt3BtnMaterialCd(String pt3BtnMaterialCd) {
		this.pt3BtnMaterialCd = pt3BtnMaterialCd;
	}
	public String getPt3BtnMaterialNm() {
		return pt3BtnMaterialNm;
	}
	public void setPt3BtnMaterialNm(String pt3BtnMaterialNm) {
		this.pt3BtnMaterialNm = pt3BtnMaterialNm;
	}
	public BigDecimal getPt3BtnMaterialWsWage() {
		return pt3BtnMaterialWsWage;
	}
	public void setPt3BtnMaterialWsWage(BigDecimal pt3BtnMaterialWsWage) {
		this.pt3BtnMaterialWsWage = pt3BtnMaterialWsWage;
	}
	public Integer getPt3BtnMaterialWsPrice() {
		return pt3BtnMaterialWsPrice;
	}
	public void setPt3BtnMaterialWsPrice(Integer pt3BtnMaterialWsPrice) {
		this.pt3BtnMaterialWsPrice = pt3BtnMaterialWsPrice;
	}
	public String getPt3SuspenderBtnCd() {
		return pt3SuspenderBtnCd;
	}
	public void setPt3SuspenderBtnCd(String pt3SuspenderBtnCd) {
		this.pt3SuspenderBtnCd = pt3SuspenderBtnCd;
	}
	public String getPt3SuspenderBtnNm() {
		return pt3SuspenderBtnNm;
	}
	public void setPt3SuspenderBtnNm(String pt3SuspenderBtnNm) {
		this.pt3SuspenderBtnNm = pt3SuspenderBtnNm;
	}
	public BigDecimal getPt3SuspenderBtnWsWage() {
		return pt3SuspenderBtnWsWage;
	}
	public void setPt3SuspenderBtnWsWage(BigDecimal pt3SuspenderBtnWsWage) {
		this.pt3SuspenderBtnWsWage = pt3SuspenderBtnWsWage;
	}
	public Integer getPt3SuspenderBtnWsPrice() {
		return pt3SuspenderBtnWsPrice;
	}
	public void setPt3SuspenderBtnWsPrice(Integer pt3SuspenderBtnWsPrice) {
		this.pt3SuspenderBtnWsPrice = pt3SuspenderBtnWsPrice;
	}
	public String getPt3NonSlipCd() {
		return pt3NonSlipCd;
	}
	public void setPt3NonSlipCd(String pt3NonSlipCd) {
		this.pt3NonSlipCd = pt3NonSlipCd;
	}
	public String getPt3NonSlipNm() {
		return pt3NonSlipNm;
	}
	public void setPt3NonSlipNm(String pt3NonSlipNm) {
		this.pt3NonSlipNm = pt3NonSlipNm;
	}
	public BigDecimal getPt3NonSlipWsWage() {
		return pt3NonSlipWsWage;
	}
	public void setPt3NonSlipWsWage(BigDecimal pt3NonSlipWsWage) {
		this.pt3NonSlipWsWage = pt3NonSlipWsWage;
	}
	public Integer getPt3NonSlipWsPrice() {
		return pt3NonSlipWsPrice;
	}
	public void setPt3NonSlipWsPrice(Integer pt3NonSlipWsPrice) {
		this.pt3NonSlipWsPrice = pt3NonSlipWsPrice;
	}
	public String getPt3ChicSlipCd() {
		return pt3ChicSlipCd;
	}
	public void setPt3ChicSlipCd(String pt3ChicSlipCd) {
		this.pt3ChicSlipCd = pt3ChicSlipCd;
	}
	public String getPt3ChicSlipNm() {
		return pt3ChicSlipNm;
	}
	public void setPt3ChicSlipNm(String pt3ChicSlipNm) {
		this.pt3ChicSlipNm = pt3ChicSlipNm;
	}
	public BigDecimal getPt3ChicSlipWsWage() {
		return pt3ChicSlipWsWage;
	}
	public void setPt3ChicSlipWsWage(BigDecimal pt3ChicSlipWsWage) {
		this.pt3ChicSlipWsWage = pt3ChicSlipWsWage;
	}
	public Integer getPt3ChicSlipWsPrice() {
		return pt3ChicSlipWsPrice;
	}
	public void setPt3ChicSlipWsPrice(Integer pt3ChicSlipWsPrice) {
		this.pt3ChicSlipWsPrice = pt3ChicSlipWsPrice;
	}
	public String getPt3ShapeMemoryCd() {
		return pt3ShapeMemoryCd;
	}
	public void setPt3ShapeMemoryCd(String pt3ShapeMemoryCd) {
		this.pt3ShapeMemoryCd = pt3ShapeMemoryCd;
	}
	public String getPt3ShapeMemoryNm() {
		return pt3ShapeMemoryNm;
	}
	public void setPt3ShapeMemoryNm(String pt3ShapeMemoryNm) {
		this.pt3ShapeMemoryNm = pt3ShapeMemoryNm;
	}
	public BigDecimal getPt3ShapeMemoryWsWage() {
		return pt3ShapeMemoryWsWage;
	}
	public void setPt3ShapeMemoryWsWage(BigDecimal pt3ShapeMemoryWsWage) {
		this.pt3ShapeMemoryWsWage = pt3ShapeMemoryWsWage;
	}
	public Integer getPt3ShapeMemoryWsPrice() {
		return pt3ShapeMemoryWsPrice;
	}
	public void setPt3ShapeMemoryWsPrice(Integer pt3ShapeMemoryWsPrice) {
		this.pt3ShapeMemoryWsPrice = pt3ShapeMemoryWsPrice;
	}
	public String getPt3ShoeSoreCd() {
		return pt3ShoeSoreCd;
	}
	public void setPt3ShoeSoreCd(String pt3ShoeSoreCd) {
		this.pt3ShoeSoreCd = pt3ShoeSoreCd;
	}
	public String getPt3ShoeSoreNm() {
		return pt3ShoeSoreNm;
	}
	public void setPt3ShoeSoreNm(String pt3ShoeSoreNm) {
		this.pt3ShoeSoreNm = pt3ShoeSoreNm;
	}
	public BigDecimal getPt3ShoeSoreWsWage() {
		return pt3ShoeSoreWsWage;
	}
	public void setPt3ShoeSoreWsWage(BigDecimal pt3ShoeSoreWsWage) {
		this.pt3ShoeSoreWsWage = pt3ShoeSoreWsWage;
	}
	public Integer getPt3ShoeSoreWsPrice() {
		return pt3ShoeSoreWsPrice;
	}
	public void setPt3ShoeSoreWsPrice(Integer pt3ShoeSoreWsPrice) {
		this.pt3ShoeSoreWsPrice = pt3ShoeSoreWsPrice;
	}
	public String getPt3SideStripeCd() {
		return pt3SideStripeCd;
	}
	public void setPt3SideStripeCd(String pt3SideStripeCd) {
		this.pt3SideStripeCd = pt3SideStripeCd;
	}
	public String getPt3SideStripeNm() {
		return pt3SideStripeNm;
	}
	public void setPt3SideStripeNm(String pt3SideStripeNm) {
		this.pt3SideStripeNm = pt3SideStripeNm;
	}
	public BigDecimal getPt3SideStripeWsWage() {
		return pt3SideStripeWsWage;
	}
	public void setPt3SideStripeWsWage(BigDecimal pt3SideStripeWsWage) {
		this.pt3SideStripeWsWage = pt3SideStripeWsWage;
	}
	public Integer getPt3SideStripeWsPrice() {
		return pt3SideStripeWsPrice;
	}
	public void setPt3SideStripeWsPrice(Integer pt3SideStripeWsPrice) {
		this.pt3SideStripeWsPrice = pt3SideStripeWsPrice;
	}
	public String getPt3SideStripeWidthCd() {
		return pt3SideStripeWidthCd;
	}
	public void setPt3SideStripeWidthCd(String pt3SideStripeWidthCd) {
		this.pt3SideStripeWidthCd = pt3SideStripeWidthCd;
	}
	public String getPt3SideStripeWidthNm() {
		return pt3SideStripeWidthNm;
	}
	public void setPt3SideStripeWidthNm(String pt3SideStripeWidthNm) {
		this.pt3SideStripeWidthNm = pt3SideStripeWidthNm;
	}
	public BigDecimal getPt3SideStripeWidthWsWage() {
		return pt3SideStripeWidthWsWage;
	}
	public void setPt3SideStripeWidthWsWage(BigDecimal pt3SideStripeWidthWsWage) {
		this.pt3SideStripeWidthWsWage = pt3SideStripeWidthWsWage;
	}
	public Integer getPt3SideStripeWidthWsPrice() {
		return pt3SideStripeWidthWsPrice;
	}
	public void setPt3SideStripeWidthWsPrice(Integer pt3SideStripeWidthWsPrice) {
		this.pt3SideStripeWidthWsPrice = pt3SideStripeWidthWsPrice;
	}
	public String getGlModelCd() {
		return glModelCd;
	}
	public void setGlModelCd(String glModelCd) {
		this.glModelCd = glModelCd;
	}
	public String getGlModelNm() {
		return glModelNm;
	}
	public void setGlModelNm(String glModelNm) {
		this.glModelNm = glModelNm;
	}
	public BigDecimal getGlModelWsWage() {
		return glModelWsWage;
	}
	public void setGlModelWsWage(BigDecimal glModelWsWage) {
		this.glModelWsWage = glModelWsWage;
	}
	public Integer getGlModelWsPrice() {
		return glModelWsPrice;
	}
	public void setGlModelWsPrice(Integer glModelWsPrice) {
		this.glModelWsPrice = glModelWsPrice;
	}
	public String getGlBreastPktCd() {
		return glBreastPktCd;
	}
	public void setGlBreastPktCd(String glBreastPktCd) {
		this.glBreastPktCd = glBreastPktCd;
	}
	public String getGlBreastPktNm() {
		return glBreastPktNm;
	}
	public void setGlBreastPktNm(String glBreastPktNm) {
		this.glBreastPktNm = glBreastPktNm;
	}
	public BigDecimal getGlBreastPktWsWage() {
		return glBreastPktWsWage;
	}
	public void setGlBreastPktWsWage(BigDecimal glBreastPktWsWage) {
		this.glBreastPktWsWage = glBreastPktWsWage;
	}
	public Integer getGlBreastPktWsPrice() {
		return glBreastPktWsPrice;
	}
	public void setGlBreastPktWsPrice(Integer glBreastPktWsPrice) {
		this.glBreastPktWsPrice = glBreastPktWsPrice;
	}
	public String getGlWaistPktCd() {
		return glWaistPktCd;
	}
	public void setGlWaistPktCd(String glWaistPktCd) {
		this.glWaistPktCd = glWaistPktCd;
	}
	public String getGlWaistPktNm() {
		return glWaistPktNm;
	}
	public void setGlWaistPktNm(String glWaistPktNm) {
		this.glWaistPktNm = glWaistPktNm;
	}
	public BigDecimal getGlWaistPktWsWage() {
		return glWaistPktWsWage;
	}
	public void setGlWaistPktWsWage(BigDecimal glWaistPktWsWage) {
		this.glWaistPktWsWage = glWaistPktWsWage;
	}
	public Integer getGlWaistPktWsPrice() {
		return glWaistPktWsPrice;
	}
	public void setGlWaistPktWsPrice(Integer glWaistPktWsPrice) {
		this.glWaistPktWsPrice = glWaistPktWsPrice;
	}
	public String getGlWaistPktShapeCd() {
		return glWaistPktShapeCd;
	}
	public void setGlWaistPktShapeCd(String glWaistPktShapeCd) {
		this.glWaistPktShapeCd = glWaistPktShapeCd;
	}
	public String getGlWaistPktShapeNm() {
		return glWaistPktShapeNm;
	}
	public void setGlWaistPktShapeNm(String glWaistPktShapeNm) {
		this.glWaistPktShapeNm = glWaistPktShapeNm;
	}
	public BigDecimal getGlWaistPktShapeWsWage() {
		return glWaistPktShapeWsWage;
	}
	public void setGlWaistPktShapeWsWage(BigDecimal glWaistPktShapeWsWage) {
		this.glWaistPktShapeWsWage = glWaistPktShapeWsWage;
	}
	public Integer getGlWaistPktShapeWsPrice() {
		return glWaistPktShapeWsPrice;
	}
	public void setGlWaistPktShapeWsPrice(Integer glWaistPktShapeWsPrice) {
		this.glWaistPktShapeWsPrice = glWaistPktShapeWsPrice;
	}
	public String getGlWaistPktClothCd() {
		return glWaistPktClothCd;
	}
	public void setGlWaistPktClothCd(String glWaistPktClothCd) {
		this.glWaistPktClothCd = glWaistPktClothCd;
	}
	public String getGlWaistPktClothNm() {
		return glWaistPktClothNm;
	}
	public void setGlWaistPktClothNm(String glWaistPktClothNm) {
		this.glWaistPktClothNm = glWaistPktClothNm;
	}
	public BigDecimal getGlWaistPktClothWsWage() {
		return glWaistPktClothWsWage;
	}
	public void setGlWaistPktClothWsWage(BigDecimal glWaistPktClothWsWage) {
		this.glWaistPktClothWsWage = glWaistPktClothWsWage;
	}
	public Integer getGlWaistPktClothWsPrice() {
		return glWaistPktClothWsPrice;
	}
	public void setGlWaistPktClothWsPrice(Integer glWaistPktClothWsPrice) {
		this.glWaistPktClothWsPrice = glWaistPktClothWsPrice;
	}
	public String getGlAmfStitchCd() {
		return glAmfStitchCd;
	}
	public void setGlAmfStitchCd(String glAmfStitchCd) {
		this.glAmfStitchCd = glAmfStitchCd;
	}
	public String getGlAmfStitchNm() {
		return glAmfStitchNm;
	}
	public void setGlAmfStitchNm(String glAmfStitchNm) {
		this.glAmfStitchNm = glAmfStitchNm;
	}
	public BigDecimal getGlAmfStitchWsWage() {
		return glAmfStitchWsWage;
	}
	public void setGlAmfStitchWsWage(BigDecimal glAmfStitchWsWage) {
		this.glAmfStitchWsWage = glAmfStitchWsWage;
	}
	public Integer getGlAmfStitchWsPrice() {
		return glAmfStitchWsPrice;
	}
	public void setGlAmfStitchWsPrice(Integer glAmfStitchWsPrice) {
		this.glAmfStitchWsPrice = glAmfStitchWsPrice;
	}
	public String getGlStitchPlcType() {
		return glStitchPlcType;
	}
	public void setGlStitchPlcType(String glStitchPlcType) {
		this.glStitchPlcType = glStitchPlcType;
	}
	public String getGlStitchPlcCd() {
		return glStitchPlcCd;
	}
	public void setGlStitchPlcCd(String glStitchPlcCd) {
		this.glStitchPlcCd = glStitchPlcCd;
	}
	public String getGlStitchPlcNm() {
		return glStitchPlcNm;
	}
	public void setGlStitchPlcNm(String glStitchPlcNm) {
		this.glStitchPlcNm = glStitchPlcNm;
	}
	public BigDecimal getGlStitchPlcWsWage() {
		return glStitchPlcWsWage;
	}
	public void setGlStitchPlcWsWage(BigDecimal glStitchPlcWsWage) {
		this.glStitchPlcWsWage = glStitchPlcWsWage;
	}
	public Integer getGlStitchPlcWsPrice() {
		return glStitchPlcWsPrice;
	}
	public void setGlStitchPlcWsPrice(Integer glStitchPlcWsPrice) {
		this.glStitchPlcWsPrice = glStitchPlcWsPrice;
	}
	public String getGlDblstitchPlcType() {
		return glDblstitchPlcType;
	}
	public void setGlDblstitchPlcType(String glDblstitchPlcType) {
		this.glDblstitchPlcType = glDblstitchPlcType;
	}
	public String getGlDblstitchPlcCd() {
		return glDblstitchPlcCd;
	}
	public void setGlDblstitchPlcCd(String glDblstitchPlcCd) {
		this.glDblstitchPlcCd = glDblstitchPlcCd;
	}
	public String getGlDblstitchPlcNm() {
		return glDblstitchPlcNm;
	}
	public void setGlDblstitchPlcNm(String glDblstitchPlcNm) {
		this.glDblstitchPlcNm = glDblstitchPlcNm;
	}
	public BigDecimal getGlDblstitchPlcWsWage() {
		return glDblstitchPlcWsWage;
	}
	public void setGlDblstitchPlcWsWage(BigDecimal glDblstitchPlcWsWage) {
		this.glDblstitchPlcWsWage = glDblstitchPlcWsWage;
	}
	public Integer getGlDblstitchPlcWsPrice() {
		return glDblstitchPlcWsPrice;
	}
	public void setGlDblstitchPlcWsPrice(Integer glDblstitchPlcWsPrice) {
		this.glDblstitchPlcWsPrice = glDblstitchPlcWsPrice;
	}
	public String getGlAmfColorType() {
		return glAmfColorType;
	}
	public void setGlAmfColorType(String glAmfColorType) {
		this.glAmfColorType = glAmfColorType;
	}
	public String getGlAmfColorPlcCd() {
		return glAmfColorPlcCd;
	}
	public void setGlAmfColorPlcCd(String glAmfColorPlcCd) {
		this.glAmfColorPlcCd = glAmfColorPlcCd;
	}
	public String getGlAmfColorPlcNm() {
		return glAmfColorPlcNm;
	}
	public void setGlAmfColorPlcNm(String glAmfColorPlcNm) {
		this.glAmfColorPlcNm = glAmfColorPlcNm;
	}
	public String getGlAmfColorCd() {
		return glAmfColorCd;
	}
	public void setGlAmfColorCd(String glAmfColorCd) {
		this.glAmfColorCd = glAmfColorCd;
	}
	public String getGlAmfColorNm() {
		return glAmfColorNm;
	}
	public void setGlAmfColorNm(String glAmfColorNm) {
		this.glAmfColorNm = glAmfColorNm;
	}
	public BigDecimal getGlAmfColorWsWage() {
		return glAmfColorWsWage;
	}
	public void setGlAmfColorWsWage(BigDecimal glAmfColorWsWage) {
		this.glAmfColorWsWage = glAmfColorWsWage;
	}
	public Integer getGlAmfColorWsPrice() {
		return glAmfColorWsPrice;
	}
	public void setGlAmfColorWsPrice(Integer glAmfColorWsPrice) {
		this.glAmfColorWsPrice = glAmfColorWsPrice;
	}
	public String getGlBtnholeColorType() {
		return glBtnholeColorType;
	}
	public void setGlBtnholeColorType(String glBtnholeColorType) {
		this.glBtnholeColorType = glBtnholeColorType;
	}
	public String getGlBtnholeColorPlcCd() {
		return glBtnholeColorPlcCd;
	}
	public void setGlBtnholeColorPlcCd(String glBtnholeColorPlcCd) {
		this.glBtnholeColorPlcCd = glBtnholeColorPlcCd;
	}
	public String getGlBtnholeColorPlcNm() {
		return glBtnholeColorPlcNm;
	}
	public void setGlBtnholeColorPlcNm(String glBtnholeColorPlcNm) {
		this.glBtnholeColorPlcNm = glBtnholeColorPlcNm;
	}
	public String getGlBtnholeColorCd() {
		return glBtnholeColorCd;
	}
	public void setGlBtnholeColorCd(String glBtnholeColorCd) {
		this.glBtnholeColorCd = glBtnholeColorCd;
	}
	public String getGlBtnholeColorNm() {
		return glBtnholeColorNm;
	}
	public void setGlBtnholeColorNm(String glBtnholeColorNm) {
		this.glBtnholeColorNm = glBtnholeColorNm;
	}
	public BigDecimal getGlBtnholeColorWsWage() {
		return glBtnholeColorWsWage;
	}
	public void setGlBtnholeColorWsWage(BigDecimal glBtnholeColorWsWage) {
		this.glBtnholeColorWsWage = glBtnholeColorWsWage;
	}
	public Integer getGlBtnholeColorWsPrice() {
		return glBtnholeColorWsPrice;
	}
	public void setGlBtnholeColorWsPrice(Integer glBtnholeColorWsPrice) {
		this.glBtnholeColorWsPrice = glBtnholeColorWsPrice;
	}
	public String getGlBtnthreadColorType() {
		return glBtnthreadColorType;
	}
	public void setGlBtnthreadColorType(String glBtnthreadColorType) {
		this.glBtnthreadColorType = glBtnthreadColorType;
	}
	public String getGlBtnthreadColorPlcCd() {
		return glBtnthreadColorPlcCd;
	}
	public void setGlBtnthreadColorPlcCd(String glBtnthreadColorPlcCd) {
		this.glBtnthreadColorPlcCd = glBtnthreadColorPlcCd;
	}
	public String getGlBtnthreadColorPlcNm() {
		return glBtnthreadColorPlcNm;
	}
	public void setGlBtnthreadColorPlcNm(String glBtnthreadColorPlcNm) {
		this.glBtnthreadColorPlcNm = glBtnthreadColorPlcNm;
	}
	public String getGlBtnthreadColorCd() {
		return glBtnthreadColorCd;
	}
	public void setGlBtnthreadColorCd(String glBtnthreadColorCd) {
		this.glBtnthreadColorCd = glBtnthreadColorCd;
	}
	public String getGlBtnthreadColorNm() {
		return glBtnthreadColorNm;
	}
	public void setGlBtnthreadColorNm(String glBtnthreadColorNm) {
		this.glBtnthreadColorNm = glBtnthreadColorNm;
	}
	public BigDecimal getGlBtnthreadColorWsWage() {
		return glBtnthreadColorWsWage;
	}
	public void setGlBtnthreadColorWsWage(BigDecimal glBtnthreadColorWsWage) {
		this.glBtnthreadColorWsWage = glBtnthreadColorWsWage;
	}
	public Integer getGlBtnthreadColorWsPrice() {
		return glBtnthreadColorWsPrice;
	}
	public void setGlBtnthreadColorWsPrice(Integer glBtnthreadColorWsPrice) {
		this.glBtnthreadColorWsPrice = glBtnthreadColorWsPrice;
	}
	public String getGlBackClothType() {
		return glBackClothType;
	}
	public void setGlBackClothType(String glBackClothType) {
		this.glBackClothType = glBackClothType;
	}
	public String getGlBackClothCd() {
		return glBackClothCd;
	}
	public void setGlBackClothCd(String glBackClothCd) {
		this.glBackClothCd = glBackClothCd;
	}
	public String getGlBackClothNm() {
		return glBackClothNm;
	}
	public void setGlBackClothNm(String glBackClothNm) {
		this.glBackClothNm = glBackClothNm;
	}
	public BigDecimal getGlBackClothWsWage() {
		return glBackClothWsWage;
	}
	public void setGlBackClothWsWage(BigDecimal glBackClothWsWage) {
		this.glBackClothWsWage = glBackClothWsWage;
	}
	public Integer getGlBackClothWsPrice() {
		return glBackClothWsPrice;
	}
	public void setGlBackClothWsPrice(Integer glBackClothWsPrice) {
		this.glBackClothWsPrice = glBackClothWsPrice;
	}
	public String getGlInnnerClothType() {
		return glInnnerClothType;
	}
	public void setGlInnnerClothType(String glInnnerClothType) {
		this.glInnnerClothType = glInnnerClothType;
	}
	public String getGlInnnerClothCd() {
		return glInnnerClothCd;
	}
	public void setGlInnnerClothCd(String glInnnerClothCd) {
		this.glInnnerClothCd = glInnnerClothCd;
	}
	public String getGlInnnerClothNm() {
		return glInnnerClothNm;
	}
	public void setGlInnnerClothNm(String glInnnerClothNm) {
		this.glInnnerClothNm = glInnnerClothNm;
	}
	public BigDecimal getGlInnnerClothWsWage() {
		return glInnnerClothWsWage;
	}
	public void setGlInnnerClothWsWage(BigDecimal glInnnerClothWsWage) {
		this.glInnnerClothWsWage = glInnnerClothWsWage;
	}
	public Integer getGlInnnerClothWsPrice() {
		return glInnnerClothWsPrice;
	}
	public void setGlInnnerClothWsPrice(Integer glInnnerClothWsPrice) {
		this.glInnnerClothWsPrice = glInnnerClothWsPrice;
	}
	public String getGlFrtBtnType() {
		return glFrtBtnType;
	}
	public void setGlFrtBtnType(String glFrtBtnType) {
		this.glFrtBtnType = glFrtBtnType;
	}
	public String getGlFrtBtnCd() {
		return glFrtBtnCd;
	}
	public void setGlFrtBtnCd(String glFrtBtnCd) {
		this.glFrtBtnCd = glFrtBtnCd;
	}
	public String getGlFrtBtnNm() {
		return glFrtBtnNm;
	}
	public void setGlFrtBtnNm(String glFrtBtnNm) {
		this.glFrtBtnNm = glFrtBtnNm;
	}
	public BigDecimal getGlFrtBtnWsWage() {
		return glFrtBtnWsWage;
	}
	public void setGlFrtBtnWsWage(BigDecimal glFrtBtnWsWage) {
		this.glFrtBtnWsWage = glFrtBtnWsWage;
	}
	public Integer getGlFrtBtnWsPrice() {
		return glFrtBtnWsPrice;
	}
	public void setGlFrtBtnWsPrice(Integer glFrtBtnWsPrice) {
		this.glFrtBtnWsPrice = glFrtBtnWsPrice;
	}
	public String getGlBackBeltCd() {
		return glBackBeltCd;
	}
	public void setGlBackBeltCd(String glBackBeltCd) {
		this.glBackBeltCd = glBackBeltCd;
	}
	public String getGlBackBeltNm() {
		return glBackBeltNm;
	}
	public void setGlBackBeltNm(String glBackBeltNm) {
		this.glBackBeltNm = glBackBeltNm;
	}
	public BigDecimal getGlBackBeltWsWage() {
		return glBackBeltWsWage;
	}
	public void setGlBackBeltWsWage(BigDecimal glBackBeltWsWage) {
		this.glBackBeltWsWage = glBackBeltWsWage;
	}
	public Integer getGlBackBeltWsPrice() {
		return glBackBeltWsPrice;
	}
	public void setGlBackBeltWsPrice(Integer glBackBeltWsPrice) {
		this.glBackBeltWsPrice = glBackBeltWsPrice;
	}
	public String getGlWatchChainCd() {
		return glWatchChainCd;
	}
	public void setGlWatchChainCd(String glWatchChainCd) {
		this.glWatchChainCd = glWatchChainCd;
	}
	public String getGlWatchChainNm() {
		return glWatchChainNm;
	}
	public void setGlWatchChainNm(String glWatchChainNm) {
		this.glWatchChainNm = glWatchChainNm;
	}
	public BigDecimal getGlWatchChainWsWage() {
		return glWatchChainWsWage;
	}
	public void setGlWatchChainWsWage(BigDecimal glWatchChainWsWage) {
		this.glWatchChainWsWage = glWatchChainWsWage;
	}
	public Integer getGlWatchChainWsPrice() {
		return glWatchChainWsPrice;
	}
	public void setGlWatchChainWsPrice(Integer glWatchChainWsPrice) {
		this.glWatchChainWsPrice = glWatchChainWsPrice;
	}
	public String getCtModelCd() {
		return ctModelCd;
	}
	public void setCtModelCd(String ctModelCd) {
		this.ctModelCd = ctModelCd;
	}
	public String getCtModelNm() {
		return ctModelNm;
	}
	public void setCtModelNm(String ctModelNm) {
		this.ctModelNm = ctModelNm;
	}
	public BigDecimal getCtModelWsWage() {
		return ctModelWsWage;
	}
	public void setCtModelWsWage(BigDecimal ctModelWsWage) {
		this.ctModelWsWage = ctModelWsWage;
	}
	public Integer getCtModelWsPrice() {
		return ctModelWsPrice;
	}
	public void setCtModelWsPrice(Integer ctModelWsPrice) {
		this.ctModelWsPrice = ctModelWsPrice;
	}
	public String getCtLapelDesignCd() {
		return ctLapelDesignCd;
	}
	public void setCtLapelDesignCd(String ctLapelDesignCd) {
		this.ctLapelDesignCd = ctLapelDesignCd;
	}
	public String getCtLapelDesignNm() {
		return ctLapelDesignNm;
	}
	public void setCtLapelDesignNm(String ctLapelDesignNm) {
		this.ctLapelDesignNm = ctLapelDesignNm;
	}
	public BigDecimal getCtLapelDesignWsWage() {
		return ctLapelDesignWsWage;
	}
	public void setCtLapelDesignWsWage(BigDecimal ctLapelDesignWsWage) {
		this.ctLapelDesignWsWage = ctLapelDesignWsWage;
	}
	public Integer getCtLapelDesignWsPrice() {
		return ctLapelDesignWsPrice;
	}
	public void setCtLapelDesignWsPrice(Integer ctLapelDesignWsPrice) {
		this.ctLapelDesignWsPrice = ctLapelDesignWsPrice;
	}
	public String getCtSleeveTypeCd() {
		return ctSleeveTypeCd;
	}
	public void setCtSleeveTypeCd(String ctSleeveTypeCd) {
		this.ctSleeveTypeCd = ctSleeveTypeCd;
	}
	public String getCtSleeveTypeNm() {
		return ctSleeveTypeNm;
	}
	public void setCtSleeveTypeNm(String ctSleeveTypeNm) {
		this.ctSleeveTypeNm = ctSleeveTypeNm;
	}
	public BigDecimal getCtSleeveTypeWsWage() {
		return ctSleeveTypeWsWage;
	}
	public void setCtSleeveTypeWsWage(BigDecimal ctSleeveTypeWsWage) {
		this.ctSleeveTypeWsWage = ctSleeveTypeWsWage;
	}
	public Integer getCtSleeveTypeWsPrice() {
		return ctSleeveTypeWsPrice;
	}
	public void setCtSleeveTypeWsPrice(Integer ctSleeveTypeWsPrice) {
		this.ctSleeveTypeWsPrice = ctSleeveTypeWsPrice;
	}
	public String getCtWaistPktCd() {
		return ctWaistPktCd;
	}
	public void setCtWaistPktCd(String ctWaistPktCd) {
		this.ctWaistPktCd = ctWaistPktCd;
	}
	public String getCtWaistPktNm() {
		return ctWaistPktNm;
	}
	public void setCtWaistPktNm(String ctWaistPktNm) {
		this.ctWaistPktNm = ctWaistPktNm;
	}
	public BigDecimal getCtWaistPktWsWage() {
		return ctWaistPktWsWage;
	}
	public void setCtWaistPktWsWage(BigDecimal ctWaistPktWsWage) {
		this.ctWaistPktWsWage = ctWaistPktWsWage;
	}
	public Integer getCtWaistPktWsPrice() {
		return ctWaistPktWsPrice;
	}
	public void setCtWaistPktWsPrice(Integer ctWaistPktWsPrice) {
		this.ctWaistPktWsPrice = ctWaistPktWsPrice;
	}
	public String getCtChgPktCd() {
		return ctChgPktCd;
	}
	public void setCtChgPktCd(String ctChgPktCd) {
		this.ctChgPktCd = ctChgPktCd;
	}
	public String getCtChgPktNm() {
		return ctChgPktNm;
	}
	public void setCtChgPktNm(String ctChgPktNm) {
		this.ctChgPktNm = ctChgPktNm;
	}
	public BigDecimal getCtChgPktWsWage() {
		return ctChgPktWsWage;
	}
	public void setCtChgPktWsWage(BigDecimal ctChgPktWsWage) {
		this.ctChgPktWsWage = ctChgPktWsWage;
	}
	public Integer getCtChgPktWsPrice() {
		return ctChgPktWsPrice;
	}
	public void setCtChgPktWsPrice(Integer ctChgPktWsPrice) {
		this.ctChgPktWsPrice = ctChgPktWsPrice;
	}
	public String getCtSlantedPktCd() {
		return ctSlantedPktCd;
	}
	public void setCtSlantedPktCd(String ctSlantedPktCd) {
		this.ctSlantedPktCd = ctSlantedPktCd;
	}
	public String getCtSlantedPktNm() {
		return ctSlantedPktNm;
	}
	public void setCtSlantedPktNm(String ctSlantedPktNm) {
		this.ctSlantedPktNm = ctSlantedPktNm;
	}
	public BigDecimal getCtSlantedPktWsWage() {
		return ctSlantedPktWsWage;
	}
	public void setCtSlantedPktWsWage(BigDecimal ctSlantedPktWsWage) {
		this.ctSlantedPktWsWage = ctSlantedPktWsWage;
	}
	public Integer getCtSlantedPktWsPrice() {
		return ctSlantedPktWsPrice;
	}
	public void setCtSlantedPktWsPrice(Integer ctSlantedPktWsPrice) {
		this.ctSlantedPktWsPrice = ctSlantedPktWsPrice;
	}
	public String getCtVentCd() {
		return ctVentCd;
	}
	public void setCtVentCd(String ctVentCd) {
		this.ctVentCd = ctVentCd;
	}
	public String getCtVentNm() {
		return ctVentNm;
	}
	public void setCtVentNm(String ctVentNm) {
		this.ctVentNm = ctVentNm;
	}
	public BigDecimal getCtVentWsWage() {
		return ctVentWsWage;
	}
	public void setCtVentWsWage(BigDecimal ctVentWsWage) {
		this.ctVentWsWage = ctVentWsWage;
	}
	public Integer getCtVentWsPrice() {
		return ctVentWsPrice;
	}
	public void setCtVentWsPrice(Integer ctVentWsPrice) {
		this.ctVentWsPrice = ctVentWsPrice;
	}
	public String getCtFrtBtnCd() {
		return ctFrtBtnCd;
	}
	public void setCtFrtBtnCd(String ctFrtBtnCd) {
		this.ctFrtBtnCd = ctFrtBtnCd;
	}
	public String getCtFrtBtnNm() {
		return ctFrtBtnNm;
	}
	public void setCtFrtBtnNm(String ctFrtBtnNm) {
		this.ctFrtBtnNm = ctFrtBtnNm;
	}
	public BigDecimal getCtFrtBtnWsWage() {
		return ctFrtBtnWsWage;
	}
	public void setCtFrtBtnWsWage(BigDecimal ctFrtBtnWsWage) {
		this.ctFrtBtnWsWage = ctFrtBtnWsWage;
	}
	public Integer getCtFrtBtnWsPrice() {
		return ctFrtBtnWsPrice;
	}
	public void setCtFrtBtnWsPrice(Integer ctFrtBtnWsPrice) {
		this.ctFrtBtnWsPrice = ctFrtBtnWsPrice;
	}
	public String getCtCuffCd() {
		return ctCuffCd;
	}
	public void setCtCuffCd(String ctCuffCd) {
		this.ctCuffCd = ctCuffCd;
	}
	public String getCtCuffNm() {
		return ctCuffNm;
	}
	public void setCtCuffNm(String ctCuffNm) {
		this.ctCuffNm = ctCuffNm;
	}
	public BigDecimal getCtCuffWsWage() {
		return ctCuffWsWage;
	}
	public void setCtCuffWsWage(BigDecimal ctCuffWsWage) {
		this.ctCuffWsWage = ctCuffWsWage;
	}
	public Integer getCtCuffWsPrice() {
		return ctCuffWsPrice;
	}
	public void setCtCuffWsPrice(Integer ctCuffWsPrice) {
		this.ctCuffWsPrice = ctCuffWsPrice;
	}
	public String getCtSleeveBtnCd() {
		return ctSleeveBtnCd;
	}
	public void setCtSleeveBtnCd(String ctSleeveBtnCd) {
		this.ctSleeveBtnCd = ctSleeveBtnCd;
	}
	public String getCtSleeveBtnNm() {
		return ctSleeveBtnNm;
	}
	public void setCtSleeveBtnNm(String ctSleeveBtnNm) {
		this.ctSleeveBtnNm = ctSleeveBtnNm;
	}
	public BigDecimal getCtSleeveBtnWsWage() {
		return ctSleeveBtnWsWage;
	}
	public void setCtSleeveBtnWsWage(BigDecimal ctSleeveBtnWsWage) {
		this.ctSleeveBtnWsWage = ctSleeveBtnWsWage;
	}
	public Integer getCtSleeveBtnWsPrice() {
		return ctSleeveBtnWsPrice;
	}
	public void setCtSleeveBtnWsPrice(Integer ctSleeveBtnWsPrice) {
		this.ctSleeveBtnWsPrice = ctSleeveBtnWsPrice;
	}
	public String getCtBackBeltCd() {
		return ctBackBeltCd;
	}
	public void setCtBackBeltCd(String ctBackBeltCd) {
		this.ctBackBeltCd = ctBackBeltCd;
	}
	public String getCtBackBeltNm() {
		return ctBackBeltNm;
	}
	public void setCtBackBeltNm(String ctBackBeltNm) {
		this.ctBackBeltNm = ctBackBeltNm;
	}
	public BigDecimal getCtBackBeltWsWage() {
		return ctBackBeltWsWage;
	}
	public void setCtBackBeltWsWage(BigDecimal ctBackBeltWsWage) {
		this.ctBackBeltWsWage = ctBackBeltWsWage;
	}
	public Integer getCtBackBeltWsPrice() {
		return ctBackBeltWsPrice;
	}
	public void setCtBackBeltWsPrice(Integer ctBackBeltWsPrice) {
		this.ctBackBeltWsPrice = ctBackBeltWsPrice;
	}
	public String getCtCollarHangCd() {
		return ctCollarHangCd;
	}
	public void setCtCollarHangCd(String ctCollarHangCd) {
		this.ctCollarHangCd = ctCollarHangCd;
	}
	public String getCtCollarHangNm() {
		return ctCollarHangNm;
	}
	public void setCtCollarHangNm(String ctCollarHangNm) {
		this.ctCollarHangNm = ctCollarHangNm;
	}
	public BigDecimal getCtCollarHangWsWage() {
		return ctCollarHangWsWage;
	}
	public void setCtCollarHangWsWage(BigDecimal ctCollarHangWsWage) {
		this.ctCollarHangWsWage = ctCollarHangWsWage;
	}
	public Integer getCtCollarHangWsPrice() {
		return ctCollarHangWsPrice;
	}
	public void setCtCollarHangWsPrice(Integer ctCollarHangWsPrice) {
		this.ctCollarHangWsPrice = ctCollarHangWsPrice;
	}
	public String getCtInnerBodyClothCd() {
		return ctInnerBodyClothCd;
	}
	public void setCtInnerBodyClothCd(String ctInnerBodyClothCd) {
		this.ctInnerBodyClothCd = ctInnerBodyClothCd;
	}
	public String getCtInnerBodyClothNm() {
		return ctInnerBodyClothNm;
	}
	public void setCtInnerBodyClothNm(String ctInnerBodyClothNm) {
		this.ctInnerBodyClothNm = ctInnerBodyClothNm;
	}
	public BigDecimal getCtInnerBodyClothWsWage() {
		return ctInnerBodyClothWsWage;
	}
	public void setCtInnerBodyClothWsWage(BigDecimal ctInnerBodyClothWsWage) {
		this.ctInnerBodyClothWsWage = ctInnerBodyClothWsWage;
	}
	public Integer getCtInnerBodyClothWsPrice() {
		return ctInnerBodyClothWsPrice;
	}
	public void setCtInnerBodyClothWsPrice(Integer ctInnerBodyClothWsPrice) {
		this.ctInnerBodyClothWsPrice = ctInnerBodyClothWsPrice;
	}
	public String getCtInnerSleeveClothCd() {
		return ctInnerSleeveClothCd;
	}
	public void setCtInnerSleeveClothCd(String ctInnerSleeveClothCd) {
		this.ctInnerSleeveClothCd = ctInnerSleeveClothCd;
	}
	public String getCtInnerSleeveClothNm() {
		return ctInnerSleeveClothNm;
	}
	public void setCtInnerSleeveClothNm(String ctInnerSleeveClothNm) {
		this.ctInnerSleeveClothNm = ctInnerSleeveClothNm;
	}
	public BigDecimal getCtInnerSleeveClothWsWage() {
		return ctInnerSleeveClothWsWage;
	}
	public void setCtInnerSleeveClothWsWage(BigDecimal ctInnerSleeveClothWsWage) {
		this.ctInnerSleeveClothWsWage = ctInnerSleeveClothWsWage;
	}
	public Integer getCtInnerSleeveClothWsPrice() {
		return ctInnerSleeveClothWsPrice;
	}
	public void setCtInnerSleeveClothWsPrice(Integer ctInnerSleeveClothWsPrice) {
		this.ctInnerSleeveClothWsPrice = ctInnerSleeveClothWsPrice;
	}
	public String getCtBtnMaterialCd() {
		return ctBtnMaterialCd;
	}
	public void setCtBtnMaterialCd(String ctBtnMaterialCd) {
		this.ctBtnMaterialCd = ctBtnMaterialCd;
	}
	public String getCtBtnMaterialNm() {
		return ctBtnMaterialNm;
	}
	public void setCtBtnMaterialNm(String ctBtnMaterialNm) {
		this.ctBtnMaterialNm = ctBtnMaterialNm;
	}
	public BigDecimal getCtBtnMaterialWsWage() {
		return ctBtnMaterialWsWage;
	}
	public void setCtBtnMaterialWsWage(BigDecimal ctBtnMaterialWsWage) {
		this.ctBtnMaterialWsWage = ctBtnMaterialWsWage;
	}
	public Integer getCtBtnMaterialWsPrice() {
		return ctBtnMaterialWsPrice;
	}
	public void setCtBtnMaterialWsPrice(Integer ctBtnMaterialWsPrice) {
		this.ctBtnMaterialWsPrice = ctBtnMaterialWsPrice;
	}
	public String getStModelCd() {
		return stModelCd;
	}
	public void setStModelCd(String stModelCd) {
		this.stModelCd = stModelCd;
	}
	public String getStModelNm() {
		return stModelNm;
	}
	public void setStModelNm(String stModelNm) {
		this.stModelNm = stModelNm;
	}
	public BigDecimal getStModelWsWage() {
		return stModelWsWage;
	}
	public void setStModelWsWage(BigDecimal stModelWsWage) {
		this.stModelWsWage = stModelWsWage;
	}
	public Integer getStModelWsPrice() {
		return stModelWsPrice;
	}
	public void setStModelWsPrice(Integer stModelWsPrice) {
		this.stModelWsPrice = stModelWsPrice;
	}
	public String getStCasualHemlineCd() {
		return stCasualHemlineCd;
	}
	public void setStCasualHemlineCd(String stCasualHemlineCd) {
		this.stCasualHemlineCd = stCasualHemlineCd;
	}
	public BigDecimal getStCasualHemlineSize() {
		return stCasualHemlineSize;
	}
	public void setStCasualHemlineSize(BigDecimal stCasualHemlineSize) {
		this.stCasualHemlineSize = stCasualHemlineSize;
	}
	public String getStCasualHemlineNm() {
		return stCasualHemlineNm;
	}
	public void setStCasualHemlineNm(String stCasualHemlineNm) {
		this.stCasualHemlineNm = stCasualHemlineNm;
	}
	public BigDecimal getStCasualHemlineWsWage() {
		return stCasualHemlineWsWage;
	}
	public void setStCasualHemlineWsWage(BigDecimal stCasualHemlineWsWage) {
		this.stCasualHemlineWsWage = stCasualHemlineWsWage;
	}
	public Integer getStCasualHemlineWsPrice() {
		return stCasualHemlineWsPrice;
	}
	public void setStCasualHemlineWsPrice(Integer stCasualHemlineWsPrice) {
		this.stCasualHemlineWsPrice = stCasualHemlineWsPrice;
	}
	public String getStCollarTypeCd() {
		return stCollarTypeCd;
	}
	public void setStCollarTypeCd(String stCollarTypeCd) {
		this.stCollarTypeCd = stCollarTypeCd;
	}
	public String getStCollarTypeNm() {
		return stCollarTypeNm;
	}
	public void setStCollarTypeNm(String stCollarTypeNm) {
		this.stCollarTypeNm = stCollarTypeNm;
	}
	public BigDecimal getStCollarTypeWsWage() {
		return stCollarTypeWsWage;
	}
	public void setStCollarTypeWsWage(BigDecimal stCollarTypeWsWage) {
		this.stCollarTypeWsWage = stCollarTypeWsWage;
	}
	public Integer getStCollarTypeWsPrice() {
		return stCollarTypeWsPrice;
	}
	public void setStCollarTypeWsPrice(Integer stCollarTypeWsPrice) {
		this.stCollarTypeWsPrice = stCollarTypeWsPrice;
	}
	public String getStCuffsCd() {
		return stCuffsCd;
	}
	public void setStCuffsCd(String stCuffsCd) {
		this.stCuffsCd = stCuffsCd;
	}
	public String getStCuffsNm() {
		return stCuffsNm;
	}
	public void setStCuffsNm(String stCuffsNm) {
		this.stCuffsNm = stCuffsNm;
	}
	public BigDecimal getStCuffsWsWage() {
		return stCuffsWsWage;
	}
	public void setStCuffsWsWage(BigDecimal stCuffsWsWage) {
		this.stCuffsWsWage = stCuffsWsWage;
	}
	public Integer getStCuffsWsPrice() {
		return stCuffsWsPrice;
	}
	public void setStCuffsWsPrice(Integer stCuffsWsPrice) {
		this.stCuffsWsPrice = stCuffsWsPrice;
	}
	public String getStConvertibleCd() {
		return stConvertibleCd;
	}
	public void setStConvertibleCd(String stConvertibleCd) {
		this.stConvertibleCd = stConvertibleCd;
	}
	public String getStConvertibleNm() {
		return stConvertibleNm;
	}
	public void setStConvertibleNm(String stConvertibleNm) {
		this.stConvertibleNm = stConvertibleNm;
	}
	public BigDecimal getStConvertibleWsWage() {
		return stConvertibleWsWage;
	}
	public void setStConvertibleWsWage(BigDecimal stConvertibleWsWage) {
		this.stConvertibleWsWage = stConvertibleWsWage;
	}
	public Integer getStConvertibleWsPrice() {
		return stConvertibleWsPrice;
	}
	public void setStConvertibleWsPrice(Integer stConvertibleWsPrice) {
		this.stConvertibleWsPrice = stConvertibleWsPrice;
	}
	public String getStAdjusterBtnCd() {
		return stAdjusterBtnCd;
	}
	public void setStAdjusterBtnCd(String stAdjusterBtnCd) {
		this.stAdjusterBtnCd = stAdjusterBtnCd;
	}
	public String getStAdjusterBtnNm() {
		return stAdjusterBtnNm;
	}
	public void setStAdjusterBtnNm(String stAdjusterBtnNm) {
		this.stAdjusterBtnNm = stAdjusterBtnNm;
	}
	public BigDecimal getStAdjusterBtnWsWage() {
		return stAdjusterBtnWsWage;
	}
	public void setStAdjusterBtnWsWage(BigDecimal stAdjusterBtnWsWage) {
		this.stAdjusterBtnWsWage = stAdjusterBtnWsWage;
	}
	public Integer getStAdjusterBtnWsPrice() {
		return stAdjusterBtnWsPrice;
	}
	public void setStAdjusterBtnWsPrice(Integer stAdjusterBtnWsPrice) {
		this.stAdjusterBtnWsPrice = stAdjusterBtnWsPrice;
	}
	public String getStDblCuffsCd() {
		return stDblCuffsCd;
	}
	public void setStDblCuffsCd(String stDblCuffsCd) {
		this.stDblCuffsCd = stDblCuffsCd;
	}
	public String getStDblCuffsNm() {
		return stDblCuffsNm;
	}
	public void setStDblCuffsNm(String stDblCuffsNm) {
		this.stDblCuffsNm = stDblCuffsNm;
	}
	public BigDecimal getStDblCuffsWsWage() {
		return stDblCuffsWsWage;
	}
	public void setStDblCuffsWsWage(BigDecimal stDblCuffsWsWage) {
		this.stDblCuffsWsWage = stDblCuffsWsWage;
	}
	public Integer getStDblCuffsWsPrice() {
		return stDblCuffsWsPrice;
	}
	public void setStDblCuffsWsPrice(Integer stDblCuffsWsPrice) {
		this.stDblCuffsWsPrice = stDblCuffsWsPrice;
	}
	public String getStClericCd() {
		return stClericCd;
	}
	public void setStClericCd(String stClericCd) {
		this.stClericCd = stClericCd;
	}
	public String getStClericNm() {
		return stClericNm;
	}
	public void setStClericNm(String stClericNm) {
		this.stClericNm = stClericNm;
	}
	public BigDecimal getStClericWsWage() {
		return stClericWsWage;
	}
	public void setStClericWsWage(BigDecimal stClericWsWage) {
		this.stClericWsWage = stClericWsWage;
	}
	public Integer getStClericWsPrice() {
		return stClericWsPrice;
	}
	public void setStClericWsPrice(Integer stClericWsPrice) {
		this.stClericWsPrice = stClericWsPrice;
	}
	public String getStCuffsBtnCd() {
		return stCuffsBtnCd;
	}
	public void setStCuffsBtnCd(String stCuffsBtnCd) {
		this.stCuffsBtnCd = stCuffsBtnCd;
	}
	public String getStCuffsBtnNm() {
		return stCuffsBtnNm;
	}
	public void setStCuffsBtnNm(String stCuffsBtnNm) {
		this.stCuffsBtnNm = stCuffsBtnNm;
	}
	public BigDecimal getStCuffsBtnWsWage() {
		return stCuffsBtnWsWage;
	}
	public void setStCuffsBtnWsWage(BigDecimal stCuffsBtnWsWage) {
		this.stCuffsBtnWsWage = stCuffsBtnWsWage;
	}
	public Integer getStCuffsBtnWsPrice() {
		return stCuffsBtnWsPrice;
	}
	public void setStCuffsBtnWsPrice(Integer stCuffsBtnWsPrice) {
		this.stCuffsBtnWsPrice = stCuffsBtnWsPrice;
	}
	public String getStSleeveClericcd() {
		return stSleeveClericcd;
	}
	public void setStSleeveClericcd(String stSleeveClericcd) {
		this.stSleeveClericcd = stSleeveClericcd;
	}
	public String getStSleeveClericnm() {
		return stSleeveClericnm;
	}
	public void setStSleeveClericnm(String stSleeveClericnm) {
		this.stSleeveClericnm = stSleeveClericnm;
	}
	public BigDecimal getStSleeveClericwsWage() {
		return stSleeveClericwsWage;
	}
	public void setStSleeveClericwsWage(BigDecimal stSleeveClericwsWage) {
		this.stSleeveClericwsWage = stSleeveClericwsWage;
	}
	public Integer getStSleeveClericwsPrice() {
		return stSleeveClericwsPrice;
	}
	public void setStSleeveClericwsPrice(Integer stSleeveClericwsPrice) {
		this.stSleeveClericwsPrice = stSleeveClericwsPrice;
	}
	public String getStBtnMaterialCd() {
		return stBtnMaterialCd;
	}
	public void setStBtnMaterialCd(String stBtnMaterialCd) {
		this.stBtnMaterialCd = stBtnMaterialCd;
	}
	public String getStBtnMaterialNm() {
		return stBtnMaterialNm;
	}
	public void setStBtnMaterialNm(String stBtnMaterialNm) {
		this.stBtnMaterialNm = stBtnMaterialNm;
	}
	public BigDecimal getStBtnMaterialWsWage() {
		return stBtnMaterialWsWage;
	}
	public void setStBtnMaterialWsWage(BigDecimal stBtnMaterialWsWage) {
		this.stBtnMaterialWsWage = stBtnMaterialWsWage;
	}
	public Integer getStBtnMaterialWsPrice() {
		return stBtnMaterialWsPrice;
	}
	public void setStBtnMaterialWsPrice(Integer stBtnMaterialWsPrice) {
		this.stBtnMaterialWsPrice = stBtnMaterialWsPrice;
	}
	public String getStDblBtnCd() {
		return stDblBtnCd;
	}
	public void setStDblBtnCd(String stDblBtnCd) {
		this.stDblBtnCd = stDblBtnCd;
	}
	public String getStDblBtnNm() {
		return stDblBtnNm;
	}
	public void setStDblBtnNm(String stDblBtnNm) {
		this.stDblBtnNm = stDblBtnNm;
	}
	public BigDecimal getStDblBtnWsWage() {
		return stDblBtnWsWage;
	}
	public void setStDblBtnWsWage(BigDecimal stDblBtnWsWage) {
		this.stDblBtnWsWage = stDblBtnWsWage;
	}
	public Integer getStDblBtnWsPrice() {
		return stDblBtnWsPrice;
	}
	public void setStDblBtnWsPrice(Integer stDblBtnWsPrice) {
		this.stDblBtnWsPrice = stDblBtnWsPrice;
	}
	public String getStGauntletBtnPosCd() {
		return stGauntletBtnPosCd;
	}
	public void setStGauntletBtnPosCd(String stGauntletBtnPosCd) {
		this.stGauntletBtnPosCd = stGauntletBtnPosCd;
	}
	public String getStGauntletBtnPosNm() {
		return stGauntletBtnPosNm;
	}
	public void setStGauntletBtnPosNm(String stGauntletBtnPosNm) {
		this.stGauntletBtnPosNm = stGauntletBtnPosNm;
	}
	public BigDecimal getStGauntletBtnPosWsWage() {
		return stGauntletBtnPosWsWage;
	}
	public void setStGauntletBtnPosWsWage(BigDecimal stGauntletBtnPosWsWage) {
		this.stGauntletBtnPosWsWage = stGauntletBtnPosWsWage;
	}
	public Integer getStGauntletBtnPosWsPrice() {
		return stGauntletBtnPosWsPrice;
	}
	public void setStGauntletBtnPosWsPrice(Integer stGauntletBtnPosWsPrice) {
		this.stGauntletBtnPosWsPrice = stGauntletBtnPosWsPrice;
	}
	public String getStPinholePinCd() {
		return stPinholePinCd;
	}
	public void setStPinholePinCd(String stPinholePinCd) {
		this.stPinholePinCd = stPinholePinCd;
	}
	public String getStPinholePinNm() {
		return stPinholePinNm;
	}
	public void setStPinholePinNm(String stPinholePinNm) {
		this.stPinholePinNm = stPinholePinNm;
	}
	public BigDecimal getStPinholePinWsWage() {
		return stPinholePinWsWage;
	}
	public void setStPinholePinWsWage(BigDecimal stPinholePinWsWage) {
		this.stPinholePinWsWage = stPinholePinWsWage;
	}
	public Integer getStPinholePinWsPrice() {
		return stPinholePinWsPrice;
	}
	public void setStPinholePinWsPrice(Integer stPinholePinWsPrice) {
		this.stPinholePinWsPrice = stPinholePinWsPrice;
	}
	public String getStBreastPktCd() {
		return stBreastPktCd;
	}
	public void setStBreastPktCd(String stBreastPktCd) {
		this.stBreastPktCd = stBreastPktCd;
	}
	public String getStBreastPktNm() {
		return stBreastPktNm;
	}
	public void setStBreastPktNm(String stBreastPktNm) {
		this.stBreastPktNm = stBreastPktNm;
	}
	public BigDecimal getStBreastPktWsWage() {
		return stBreastPktWsWage;
	}
	public void setStBreastPktWsWage(BigDecimal stBreastPktWsWage) {
		this.stBreastPktWsWage = stBreastPktWsWage;
	}
	public Integer getStBreastPktWsPrice() {
		return stBreastPktWsPrice;
	}
	public void setStBreastPktWsPrice(Integer stBreastPktWsPrice) {
		this.stBreastPktWsPrice = stBreastPktWsPrice;
	}
	public String getStBreastSizeCd() {
		return stBreastSizeCd;
	}
	public void setStBreastSizeCd(String stBreastSizeCd) {
		this.stBreastSizeCd = stBreastSizeCd;
	}
	public String getStBreastSizeNm() {
		return stBreastSizeNm;
	}
	public void setStBreastSizeNm(String stBreastSizeNm) {
		this.stBreastSizeNm = stBreastSizeNm;
	}
	public BigDecimal getStBreastSizeWsWage() {
		return stBreastSizeWsWage;
	}
	public void setStBreastSizeWsWage(BigDecimal stBreastSizeWsWage) {
		this.stBreastSizeWsWage = stBreastSizeWsWage;
	}
	public Integer getStBreastSizeWsPrice() {
		return stBreastSizeWsPrice;
	}
	public void setStBreastSizeWsPrice(Integer stBreastSizeWsPrice) {
		this.stBreastSizeWsPrice = stBreastSizeWsPrice;
	}
	public String getStFrtDesignCd() {
		return stFrtDesignCd;
	}
	public void setStFrtDesignCd(String stFrtDesignCd) {
		this.stFrtDesignCd = stFrtDesignCd;
	}
	public String getStFrtDesignNm() {
		return stFrtDesignNm;
	}
	public void setStFrtDesignNm(String stFrtDesignNm) {
		this.stFrtDesignNm = stFrtDesignNm;
	}
	public BigDecimal getStFrtDesignWsWage() {
		return stFrtDesignWsWage;
	}
	public void setStFrtDesignWsWage(BigDecimal stFrtDesignWsWage) {
		this.stFrtDesignWsWage = stFrtDesignWsWage;
	}
	public Integer getStFrtDesignWsPrice() {
		return stFrtDesignWsPrice;
	}
	public void setStFrtDesignWsPrice(Integer stFrtDesignWsPrice) {
		this.stFrtDesignWsPrice = stFrtDesignWsPrice;
	}
	public String getStPintuckBosomCd() {
		return stPintuckBosomCd;
	}
	public void setStPintuckBosomCd(String stPintuckBosomCd) {
		this.stPintuckBosomCd = stPintuckBosomCd;
	}
	public String getStPintuckBosomNm() {
		return stPintuckBosomNm;
	}
	public void setStPintuckBosomNm(String stPintuckBosomNm) {
		this.stPintuckBosomNm = stPintuckBosomNm;
	}
	public BigDecimal getStPintuckBosomWsWage() {
		return stPintuckBosomWsWage;
	}
	public void setStPintuckBosomWsWage(BigDecimal stPintuckBosomWsWage) {
		this.stPintuckBosomWsWage = stPintuckBosomWsWage;
	}
	public Integer getStPintuckBosomWsPrice() {
		return stPintuckBosomWsPrice;
	}
	public void setStPintuckBosomWsPrice(Integer stPintuckBosomWsPrice) {
		this.stPintuckBosomWsPrice = stPintuckBosomWsPrice;
	}
	public String getStStitchCd() {
		return stStitchCd;
	}
	public void setStStitchCd(String stStitchCd) {
		this.stStitchCd = stStitchCd;
	}
	public String getStStitchNm() {
		return stStitchNm;
	}
	public void setStStitchNm(String stStitchNm) {
		this.stStitchNm = stStitchNm;
	}
	public BigDecimal getStStitchWsWage() {
		return stStitchWsWage;
	}
	public void setStStitchWsWage(BigDecimal stStitchWsWage) {
		this.stStitchWsWage = stStitchWsWage;
	}
	public Integer getStStitchWsPrice() {
		return stStitchWsPrice;
	}
	public void setStStitchWsPrice(Integer stStitchWsPrice) {
		this.stStitchWsPrice = stStitchWsPrice;
	}
	public String getStColarKeeperCd() {
		return stColarKeeperCd;
	}
	public void setStColarKeeperCd(String stColarKeeperCd) {
		this.stColarKeeperCd = stColarKeeperCd;
	}
	public String getStColarKeeperNm() {
		return stColarKeeperNm;
	}
	public void setStColarKeeperNm(String stColarKeeperNm) {
		this.stColarKeeperNm = stColarKeeperNm;
	}
	public BigDecimal getStColarKeeperWsWage() {
		return stColarKeeperWsWage;
	}
	public void setStColarKeeperWsWage(BigDecimal stColarKeeperWsWage) {
		this.stColarKeeperWsWage = stColarKeeperWsWage;
	}
	public Integer getStColarKeeperWsPrice() {
		return stColarKeeperWsPrice;
	}
	public void setStColarKeeperWsPrice(Integer stColarKeeperWsPrice) {
		this.stColarKeeperWsPrice = stColarKeeperWsPrice;
	}
	public String getStBtnthreadColorCd() {
		return stBtnthreadColorCd;
	}
	public void setStBtnthreadColorCd(String stBtnthreadColorCd) {
		this.stBtnthreadColorCd = stBtnthreadColorCd;
	}
	public String getStBtnthreadColorNm() {
		return stBtnthreadColorNm;
	}
	public void setStBtnthreadColorNm(String stBtnthreadColorNm) {
		this.stBtnthreadColorNm = stBtnthreadColorNm;
	}
	public BigDecimal getStBtnthreadColorWsWage() {
		return stBtnthreadColorWsWage;
	}
	public void setStBtnthreadColorWsWage(BigDecimal stBtnthreadColorWsWage) {
		this.stBtnthreadColorWsWage = stBtnthreadColorWsWage;
	}
	public Integer getStBtnthreadColorWsPrice() {
		return stBtnthreadColorWsPrice;
	}
	public void setStBtnthreadColorWsPrice(Integer stBtnthreadColorWsPrice) {
		this.stBtnthreadColorWsPrice = stBtnthreadColorWsPrice;
	}
	public String getStBtnholeColorCd() {
		return stBtnholeColorCd;
	}
	public void setStBtnholeColorCd(String stBtnholeColorCd) {
		this.stBtnholeColorCd = stBtnholeColorCd;
	}
	public String getStBtnholeColorNm() {
		return stBtnholeColorNm;
	}
	public void setStBtnholeColorNm(String stBtnholeColorNm) {
		this.stBtnholeColorNm = stBtnholeColorNm;
	}
	public BigDecimal getStBtnholeColorWsWage() {
		return stBtnholeColorWsWage;
	}
	public void setStBtnholeColorWsWage(BigDecimal stBtnholeColorWsWage) {
		this.stBtnholeColorWsWage = stBtnholeColorWsWage;
	}
	public Integer getStBtnholeColorWsPrice() {
		return stBtnholeColorWsPrice;
	}
	public void setStBtnholeColorWsPrice(Integer stBtnholeColorWsPrice) {
		this.stBtnholeColorWsPrice = stBtnholeColorWsPrice;
	}
	public String getStBtnposChgCd() {
		return stBtnposChgCd;
	}
	public void setStBtnposChgCd(String stBtnposChgCd) {
		this.stBtnposChgCd = stBtnposChgCd;
	}
	public String getStBtnposChgNm() {
		return stBtnposChgNm;
	}
	public void setStBtnposChgNm(String stBtnposChgNm) {
		this.stBtnposChgNm = stBtnposChgNm;
	}
	public BigDecimal getStBtnposChgWsWage() {
		return stBtnposChgWsWage;
	}
	public void setStBtnposChgWsWage(BigDecimal stBtnposChgWsWage) {
		this.stBtnposChgWsWage = stBtnposChgWsWage;
	}
	public Integer getStBtnposChgWsPrice() {
		return stBtnposChgWsPrice;
	}
	public void setStBtnposChgWsPrice(Integer stBtnposChgWsPrice) {
		this.stBtnposChgWsPrice = stBtnposChgWsPrice;
	}
	public String getStNeckbandBtnChgCd() {
		return stNeckbandBtnChgCd;
	}
	public void setStNeckbandBtnChgCd(String stNeckbandBtnChgCd) {
		this.stNeckbandBtnChgCd = stNeckbandBtnChgCd;
	}
	public String getStNeckbandBtnChgNm() {
		return stNeckbandBtnChgNm;
	}
	public void setStNeckbandBtnChgNm(String stNeckbandBtnChgNm) {
		this.stNeckbandBtnChgNm = stNeckbandBtnChgNm;
	}
	public BigDecimal getStNeckbandBtnChgWsWage() {
		return stNeckbandBtnChgWsWage;
	}
	public void setStNeckbandBtnChgWsWage(BigDecimal stNeckbandBtnChgWsWage) {
		this.stNeckbandBtnChgWsWage = stNeckbandBtnChgWsWage;
	}
	public Integer getStNeckbandBtnChgWsPrice() {
		return stNeckbandBtnChgWsPrice;
	}
	public void setStNeckbandBtnChgWsPrice(Integer stNeckbandBtnChgWsPrice) {
		this.stNeckbandBtnChgWsPrice = stNeckbandBtnChgWsPrice;
	}
	public BigDecimal getStNeckbandBtnPosChg() {
		return stNeckbandBtnPosChg;
	}
	public void setStNeckbandBtnPosChg(BigDecimal stNeckbandBtnPosChg) {
		this.stNeckbandBtnPosChg = stNeckbandBtnPosChg;
	}
	public String getStFrtfirstBtnChgCd() {
		return stFrtfirstBtnChgCd;
	}
	public void setStFrtfirstBtnChgCd(String stFrtfirstBtnChgCd) {
		this.stFrtfirstBtnChgCd = stFrtfirstBtnChgCd;
	}
	public String getStFrtfirstBtnChgNm() {
		return stFrtfirstBtnChgNm;
	}
	public void setStFrtfirstBtnChgNm(String stFrtfirstBtnChgNm) {
		this.stFrtfirstBtnChgNm = stFrtfirstBtnChgNm;
	}
	public BigDecimal getStFrtfirstBtnChgWsWage() {
		return stFrtfirstBtnChgWsWage;
	}
	public void setStFrtfirstBtnChgWsWage(BigDecimal stFrtfirstBtnChgWsWage) {
		this.stFrtfirstBtnChgWsWage = stFrtfirstBtnChgWsWage;
	}
	public Integer getStFrtfirstBtnChgWsPrice() {
		return stFrtfirstBtnChgWsPrice;
	}
	public void setStFrtfirstBtnChgWsPrice(Integer stFrtfirstBtnChgWsPrice) {
		this.stFrtfirstBtnChgWsPrice = stFrtfirstBtnChgWsPrice;
	}
	public BigDecimal getStFrtfirstBtnPosChg() {
		return stFrtfirstBtnPosChg;
	}
	public void setStFrtfirstBtnPosChg(BigDecimal stFrtfirstBtnPosChg) {
		this.stFrtfirstBtnPosChg = stFrtfirstBtnPosChg;
	}
	public String getStFrtsecondBtnChgCd() {
		return stFrtsecondBtnChgCd;
	}
	public void setStFrtsecondBtnChgCd(String stFrtsecondBtnChgCd) {
		this.stFrtsecondBtnChgCd = stFrtsecondBtnChgCd;
	}
	public String getStFrtsecondBtnChgNm() {
		return stFrtsecondBtnChgNm;
	}
	public void setStFrtsecondBtnChgNm(String stFrtsecondBtnChgNm) {
		this.stFrtsecondBtnChgNm = stFrtsecondBtnChgNm;
	}
	public BigDecimal getStFrtsecondBtnChgWsWage() {
		return stFrtsecondBtnChgWsWage;
	}
	public void setStFrtsecondBtnChgWsWage(BigDecimal stFrtsecondBtnChgWsWage) {
		this.stFrtsecondBtnChgWsWage = stFrtsecondBtnChgWsWage;
	}
	public Integer getStFrtsecondBtnChgWsPrice() {
		return stFrtsecondBtnChgWsPrice;
	}
	public void setStFrtsecondBtnChgWsPrice(Integer stFrtsecondBtnChgWsPrice) {
		this.stFrtsecondBtnChgWsPrice = stFrtsecondBtnChgWsPrice;
	}
	public BigDecimal getStFrtsecondBtnPosChg() {
		return stFrtsecondBtnPosChg;
	}
	public void setStFrtsecondBtnPosChg(BigDecimal stFrtsecondBtnPosChg) {
		this.stFrtsecondBtnPosChg = stFrtsecondBtnPosChg;
	}
	public String getCorJkDrop() {
		return corJkDrop;
	}
	public void setCorJkDrop(String corJkDrop) {
		this.corJkDrop = corJkDrop;
	}
	public String getCorJkSize() {
		return corJkSize;
	}
	public void setCorJkSize(String corJkSize) {
		this.corJkSize = corJkSize;
	}
	public BigDecimal getCorJkBodylengthSize() {
		return corJkBodylengthSize;
	}
	public void setCorJkBodylengthSize(BigDecimal corJkBodylengthSize) {
		this.corJkBodylengthSize = corJkBodylengthSize;
	}
	public BigDecimal getCorJkBodylengthCorrect() {
		return corJkBodylengthCorrect;
	}
	public void setCorJkBodylengthCorrect(BigDecimal corJkBodylengthCorrect) {
		this.corJkBodylengthCorrect = corJkBodylengthCorrect;
	}
	public BigDecimal getCorJkBodylengthGross() {
		return corJkBodylengthGross;
	}
	public void setCorJkBodylengthGross(BigDecimal corJkBodylengthGross) {
		this.corJkBodylengthGross = corJkBodylengthGross;
	}
	public BigDecimal getCorJkWaistSize() {
		return corJkWaistSize;
	}
	public void setCorJkWaistSize(BigDecimal corJkWaistSize) {
		this.corJkWaistSize = corJkWaistSize;
	}
	public BigDecimal getCorJkWaistCorrect() {
		return corJkWaistCorrect;
	}
	public void setCorJkWaistCorrect(BigDecimal corJkWaistCorrect) {
		this.corJkWaistCorrect = corJkWaistCorrect;
	}
	public BigDecimal getCorJkWaistGross() {
		return corJkWaistGross;
	}
	public void setCorJkWaistGross(BigDecimal corJkWaistGross) {
		this.corJkWaistGross = corJkWaistGross;
	}
	public BigDecimal getCorJkRightsleeveSize() {
		return corJkRightsleeveSize;
	}
	public void setCorJkRightsleeveSize(BigDecimal corJkRightsleeveSize) {
		this.corJkRightsleeveSize = corJkRightsleeveSize;
	}
	public BigDecimal getCorJkRightsleeveCorrect() {
		return corJkRightsleeveCorrect;
	}
	public void setCorJkRightsleeveCorrect(BigDecimal corJkRightsleeveCorrect) {
		this.corJkRightsleeveCorrect = corJkRightsleeveCorrect;
	}
	public BigDecimal getCorJkRightsleeveGross() {
		return corJkRightsleeveGross;
	}
	public void setCorJkRightsleeveGross(BigDecimal corJkRightsleeveGross) {
		this.corJkRightsleeveGross = corJkRightsleeveGross;
	}
	public BigDecimal getCorJkLeftsleeveSize() {
		return corJkLeftsleeveSize;
	}
	public void setCorJkLeftsleeveSize(BigDecimal corJkLeftsleeveSize) {
		this.corJkLeftsleeveSize = corJkLeftsleeveSize;
	}
	public BigDecimal getCorJkLeftsleeveCorrect() {
		return corJkLeftsleeveCorrect;
	}
	public void setCorJkLeftsleeveCorrect(BigDecimal corJkLeftsleeveCorrect) {
		this.corJkLeftsleeveCorrect = corJkLeftsleeveCorrect;
	}
	public BigDecimal getCorJkLeftsleeveGross() {
		return corJkLeftsleeveGross;
	}
	public void setCorJkLeftsleeveGross(BigDecimal corJkLeftsleeveGross) {
		this.corJkLeftsleeveGross = corJkLeftsleeveGross;
	}
	public String getCorJkShoulderpad() {
		return corJkShoulderpad;
	}
	public void setCorJkShoulderpad(String corJkShoulderpad) {
		this.corJkShoulderpad = corJkShoulderpad;
	}
	public String getCorJkFigureCorrect() {
		return corJkFigureCorrect;
	}
	public void setCorJkFigureCorrect(String corJkFigureCorrect) {
		this.corJkFigureCorrect = corJkFigureCorrect;
	}
	public String getCorPtDrop() {
		return corPtDrop;
	}
	public void setCorPtDrop(String corPtDrop) {
		this.corPtDrop = corPtDrop;
	}
	public String getCorPtSize() {
		return corPtSize;
	}
	public void setCorPtSize(String corPtSize) {
		this.corPtSize = corPtSize;
	}
	public BigDecimal getCorPtWaistSize() {
		return corPtWaistSize;
	}
	public void setCorPtWaistSize(BigDecimal corPtWaistSize) {
		this.corPtWaistSize = corPtWaistSize;
	}
	public BigDecimal getCorPtWaistCorrect() {
		return corPtWaistCorrect;
	}
	public void setCorPtWaistCorrect(BigDecimal corPtWaistCorrect) {
		this.corPtWaistCorrect = corPtWaistCorrect;
	}
	public BigDecimal getCorPtWaistGross() {
		return corPtWaistGross;
	}
	public void setCorPtWaistGross(BigDecimal corPtWaistGross) {
		this.corPtWaistGross = corPtWaistGross;
	}
	public BigDecimal getCorPtHipSize() {
		return corPtHipSize;
	}
	public void setCorPtHipSize(BigDecimal corPtHipSize) {
		this.corPtHipSize = corPtHipSize;
	}
	public BigDecimal getCorPtHipCorrect() {
		return corPtHipCorrect;
	}
	public void setCorPtHipCorrect(BigDecimal corPtHipCorrect) {
		this.corPtHipCorrect = corPtHipCorrect;
	}
	public BigDecimal getCorPtHipGross() {
		return corPtHipGross;
	}
	public void setCorPtHipGross(BigDecimal corPtHipGross) {
		this.corPtHipGross = corPtHipGross;
	}
	public BigDecimal getCorPtThighwidthSize() {
		return corPtThighwidthSize;
	}
	public void setCorPtThighwidthSize(BigDecimal corPtThighwidthSize) {
		this.corPtThighwidthSize = corPtThighwidthSize;
	}
	public BigDecimal getCorPtThighwidthCorrect() {
		return corPtThighwidthCorrect;
	}
	public void setCorPtThighwidthCorrect(BigDecimal corPtThighwidthCorrect) {
		this.corPtThighwidthCorrect = corPtThighwidthCorrect;
	}
	public BigDecimal getCorPtThighwidthGross() {
		return corPtThighwidthGross;
	}
	public void setCorPtThighwidthGross(BigDecimal corPtThighwidthGross) {
		this.corPtThighwidthGross = corPtThighwidthGross;
	}
	public String getCorPtHemwidthType() {
		return corPtHemwidthType;
	}
	public void setCorPtHemwidthType(String corPtHemwidthType) {
		this.corPtHemwidthType = corPtHemwidthType;
	}
	public BigDecimal getCorPtHemwidthSize() {
		return corPtHemwidthSize;
	}
	public void setCorPtHemwidthSize(BigDecimal corPtHemwidthSize) {
		this.corPtHemwidthSize = corPtHemwidthSize;
	}
	public BigDecimal getCorPtHemwidthCorrect() {
		return corPtHemwidthCorrect;
	}
	public void setCorPtHemwidthCorrect(BigDecimal corPtHemwidthCorrect) {
		this.corPtHemwidthCorrect = corPtHemwidthCorrect;
	}
	public BigDecimal getCorPtHemwidthGross() {
		return corPtHemwidthGross;
	}
	public void setCorPtHemwidthGross(BigDecimal corPtHemwidthGross) {
		this.corPtHemwidthGross = corPtHemwidthGross;
	}
	public BigDecimal getCorPtHemwidthDegignate() {
		return corPtHemwidthDegignate;
	}
	public void setCorPtHemwidthDegignate(BigDecimal corPtHemwidthDegignate) {
		this.corPtHemwidthDegignate = corPtHemwidthDegignate;
	}
	public BigDecimal getCorPtRightinseamSize() {
		return corPtRightinseamSize;
	}
	public void setCorPtRightinseamSize(BigDecimal corPtRightinseamSize) {
		this.corPtRightinseamSize = corPtRightinseamSize;
	}
	public BigDecimal getCorPtRightinseamCorrect() {
		return corPtRightinseamCorrect;
	}
	public void setCorPtRightinseamCorrect(BigDecimal corPtRightinseamCorrect) {
		this.corPtRightinseamCorrect = corPtRightinseamCorrect;
	}
	public BigDecimal getCorPtRightinseamGross() {
		return corPtRightinseamGross;
	}
	public void setCorPtRightinseamGross(BigDecimal corPtRightinseamGross) {
		this.corPtRightinseamGross = corPtRightinseamGross;
	}
	public BigDecimal getCorPtLeftinseamSize() {
		return corPtLeftinseamSize;
	}
	public void setCorPtLeftinseamSize(BigDecimal corPtLeftinseamSize) {
		this.corPtLeftinseamSize = corPtLeftinseamSize;
	}
	public BigDecimal getCorPtLeftinseamCorrect() {
		return corPtLeftinseamCorrect;
	}
	public void setCorPtLeftinseamCorrect(BigDecimal corPtLeftinseamCorrect) {
		this.corPtLeftinseamCorrect = corPtLeftinseamCorrect;
	}
	public BigDecimal getCorPtLeftinseamGross() {
		return corPtLeftinseamGross;
	}
	public void setCorPtLeftinseamGross(BigDecimal corPtLeftinseamGross) {
		this.corPtLeftinseamGross = corPtLeftinseamGross;
	}
	public String getCorPt2Drop() {
		return corPt2Drop;
	}
	public void setCorPt2Drop(String corPt2Drop) {
		this.corPt2Drop = corPt2Drop;
	}
	public String getCorPt2Size() {
		return corPt2Size;
	}
	public void setCorPt2Size(String corPt2Size) {
		this.corPt2Size = corPt2Size;
	}
	public BigDecimal getCorPt2WaistSize() {
		return corPt2WaistSize;
	}
	public void setCorPt2WaistSize(BigDecimal corPt2WaistSize) {
		this.corPt2WaistSize = corPt2WaistSize;
	}
	public BigDecimal getCorPt2WaistCorrect() {
		return corPt2WaistCorrect;
	}
	public void setCorPt2WaistCorrect(BigDecimal corPt2WaistCorrect) {
		this.corPt2WaistCorrect = corPt2WaistCorrect;
	}
	public BigDecimal getCorPt2WaistGross() {
		return corPt2WaistGross;
	}
	public void setCorPt2WaistGross(BigDecimal corPt2WaistGross) {
		this.corPt2WaistGross = corPt2WaistGross;
	}
	public BigDecimal getCorPt2HipSize() {
		return corPt2HipSize;
	}
	public void setCorPt2HipSize(BigDecimal corPt2HipSize) {
		this.corPt2HipSize = corPt2HipSize;
	}
	public BigDecimal getCorPt2HipCorrect() {
		return corPt2HipCorrect;
	}
	public void setCorPt2HipCorrect(BigDecimal corPt2HipCorrect) {
		this.corPt2HipCorrect = corPt2HipCorrect;
	}
	public BigDecimal getCorPt2HipGross() {
		return corPt2HipGross;
	}
	public void setCorPt2HipGross(BigDecimal corPt2HipGross) {
		this.corPt2HipGross = corPt2HipGross;
	}
	public BigDecimal getCorPt2ThighwidthSize() {
		return corPt2ThighwidthSize;
	}
	public void setCorPt2ThighwidthSize(BigDecimal corPt2ThighwidthSize) {
		this.corPt2ThighwidthSize = corPt2ThighwidthSize;
	}
	public BigDecimal getCorPt2ThighwidthCorrect() {
		return corPt2ThighwidthCorrect;
	}
	public void setCorPt2ThighwidthCorrect(BigDecimal corPt2ThighwidthCorrect) {
		this.corPt2ThighwidthCorrect = corPt2ThighwidthCorrect;
	}
	public BigDecimal getCorPt2ThighwidthGross() {
		return corPt2ThighwidthGross;
	}
	public void setCorPt2ThighwidthGross(BigDecimal corPt2ThighwidthGross) {
		this.corPt2ThighwidthGross = corPt2ThighwidthGross;
	}
	public String getCorPt2HemwidthType() {
		return corPt2HemwidthType;
	}
	public void setCorPt2HemwidthType(String corPt2HemwidthType) {
		this.corPt2HemwidthType = corPt2HemwidthType;
	}
	public BigDecimal getCorPt2HemwidthSize() {
		return corPt2HemwidthSize;
	}
	public void setCorPt2HemwidthSize(BigDecimal corPt2HemwidthSize) {
		this.corPt2HemwidthSize = corPt2HemwidthSize;
	}
	public BigDecimal getCorPt2HemwidthCorrect() {
		return corPt2HemwidthCorrect;
	}
	public void setCorPt2HemwidthCorrect(BigDecimal corPt2HemwidthCorrect) {
		this.corPt2HemwidthCorrect = corPt2HemwidthCorrect;
	}
	public BigDecimal getCorPt2HemwidthGross() {
		return corPt2HemwidthGross;
	}
	public void setCorPt2HemwidthGross(BigDecimal corPt2HemwidthGross) {
		this.corPt2HemwidthGross = corPt2HemwidthGross;
	}
	public BigDecimal getCorPt2HemwidthDegignate() {
		return corPt2HemwidthDegignate;
	}
	public void setCorPt2HemwidthDegignate(BigDecimal corPt2HemwidthDegignate) {
		this.corPt2HemwidthDegignate = corPt2HemwidthDegignate;
	}
	public BigDecimal getCorPt2RightinseamSize() {
		return corPt2RightinseamSize;
	}
	public void setCorPt2RightinseamSize(BigDecimal corPt2RightinseamSize) {
		this.corPt2RightinseamSize = corPt2RightinseamSize;
	}
	public BigDecimal getCorPt2RightinseamCorrect() {
		return corPt2RightinseamCorrect;
	}
	public void setCorPt2RightinseamCorrect(BigDecimal corPt2RightinseamCorrect) {
		this.corPt2RightinseamCorrect = corPt2RightinseamCorrect;
	}
	public BigDecimal getCorPt2RightinseamGross() {
		return corPt2RightinseamGross;
	}
	public void setCorPt2RightinseamGross(BigDecimal corPt2RightinseamGross) {
		this.corPt2RightinseamGross = corPt2RightinseamGross;
	}
	public BigDecimal getCorPt2LeftinseamSize() {
		return corPt2LeftinseamSize;
	}
	public void setCorPt2LeftinseamSize(BigDecimal corPt2LeftinseamSize) {
		this.corPt2LeftinseamSize = corPt2LeftinseamSize;
	}
	public BigDecimal getCorPt2LeftinseamCorrect() {
		return corPt2LeftinseamCorrect;
	}
	public void setCorPt2LeftinseamCorrect(BigDecimal corPt2LeftinseamCorrect) {
		this.corPt2LeftinseamCorrect = corPt2LeftinseamCorrect;
	}
	public BigDecimal getCorPt2LeftinseamGross() {
		return corPt2LeftinseamGross;
	}
	public void setCorPt2LeftinseamGross(BigDecimal corPt2LeftinseamGross) {
		this.corPt2LeftinseamGross = corPt2LeftinseamGross;
	}
	public String getCorGlDrop() {
		return corGlDrop;
	}
	public void setCorGlDrop(String corGlDrop) {
		this.corGlDrop = corGlDrop;
	}
	public String getCorGlSize() {
		return corGlSize;
	}
	public void setCorGlSize(String corGlSize) {
		this.corGlSize = corGlSize;
	}
	public BigDecimal getCorGlBodylengthSize() {
		return corGlBodylengthSize;
	}
	public void setCorGlBodylengthSize(BigDecimal corGlBodylengthSize) {
		this.corGlBodylengthSize = corGlBodylengthSize;
	}
	public BigDecimal getCorGlBodylengthCorrect() {
		return corGlBodylengthCorrect;
	}
	public void setCorGlBodylengthCorrect(BigDecimal corGlBodylengthCorrect) {
		this.corGlBodylengthCorrect = corGlBodylengthCorrect;
	}
	public BigDecimal getCorGlBodylengthGross() {
		return corGlBodylengthGross;
	}
	public void setCorGlBodylengthGross(BigDecimal corGlBodylengthGross) {
		this.corGlBodylengthGross = corGlBodylengthGross;
	}
	public BigDecimal getCorGlBustSize() {
		return corGlBustSize;
	}
	public void setCorGlBustSize(BigDecimal corGlBustSize) {
		this.corGlBustSize = corGlBustSize;
	}
	public BigDecimal getCorGlBustCorrect() {
		return corGlBustCorrect;
	}
	public void setCorGlBustCorrect(BigDecimal corGlBustCorrect) {
		this.corGlBustCorrect = corGlBustCorrect;
	}
	public BigDecimal getCorGlBustGross() {
		return corGlBustGross;
	}
	public void setCorGlBustGross(BigDecimal corGlBustGross) {
		this.corGlBustGross = corGlBustGross;
	}
	public BigDecimal getCorGlWaistSize() {
		return corGlWaistSize;
	}
	public void setCorGlWaistSize(BigDecimal corGlWaistSize) {
		this.corGlWaistSize = corGlWaistSize;
	}
	public BigDecimal getCorGlWaistCorrect() {
		return corGlWaistCorrect;
	}
	public void setCorGlWaistCorrect(BigDecimal corGlWaistCorrect) {
		this.corGlWaistCorrect = corGlWaistCorrect;
	}
	public BigDecimal getCorGlWaistGross() {
		return corGlWaistGross;
	}
	public void setCorGlWaistGross(BigDecimal corGlWaistGross) {
		this.corGlWaistGross = corGlWaistGross;
	}
	public String getCorCtSize() {
		return corCtSize;
	}
	public void setCorCtSize(String corCtSize) {
		this.corCtSize = corCtSize;
	}
	public BigDecimal getCorCtBodylengthSize() {
		return corCtBodylengthSize;
	}
	public void setCorCtBodylengthSize(BigDecimal corCtBodylengthSize) {
		this.corCtBodylengthSize = corCtBodylengthSize;
	}
	public BigDecimal getCorCtBodylengthCorrect() {
		return corCtBodylengthCorrect;
	}
	public void setCorCtBodylengthCorrect(BigDecimal corCtBodylengthCorrect) {
		this.corCtBodylengthCorrect = corCtBodylengthCorrect;
	}
	public BigDecimal getCorCtBodylengthGross() {
		return corCtBodylengthGross;
	}
	public void setCorCtBodylengthGross(BigDecimal corCtBodylengthGross) {
		this.corCtBodylengthGross = corCtBodylengthGross;
	}
	public BigDecimal getCorCtWaistSize() {
		return corCtWaistSize;
	}
	public void setCorCtWaistSize(BigDecimal corCtWaistSize) {
		this.corCtWaistSize = corCtWaistSize;
	}
	public BigDecimal getCorCtWaistCorrect() {
		return corCtWaistCorrect;
	}
	public void setCorCtWaistCorrect(BigDecimal corCtWaistCorrect) {
		this.corCtWaistCorrect = corCtWaistCorrect;
	}
	public BigDecimal getCorCtWaistGross() {
		return corCtWaistGross;
	}
	public void setCorCtWaistGross(BigDecimal corCtWaistGross) {
		this.corCtWaistGross = corCtWaistGross;
	}
	public BigDecimal getCorCtRightsleeveSize() {
		return corCtRightsleeveSize;
	}
	public void setCorCtRightsleeveSize(BigDecimal corCtRightsleeveSize) {
		this.corCtRightsleeveSize = corCtRightsleeveSize;
	}
	public BigDecimal getCorCtRightsleeveCorrect() {
		return corCtRightsleeveCorrect;
	}
	public void setCorCtRightsleeveCorrect(BigDecimal corCtRightsleeveCorrect) {
		this.corCtRightsleeveCorrect = corCtRightsleeveCorrect;
	}
	public BigDecimal getCorCtRightsleeveGross() {
		return corCtRightsleeveGross;
	}
	public void setCorCtRightsleeveGross(BigDecimal corCtRightsleeveGross) {
		this.corCtRightsleeveGross = corCtRightsleeveGross;
	}
	public BigDecimal getCorCtLeftsleeveSize() {
		return corCtLeftsleeveSize;
	}
	public void setCorCtLeftsleeveSize(BigDecimal corCtLeftsleeveSize) {
		this.corCtLeftsleeveSize = corCtLeftsleeveSize;
	}
	public BigDecimal getCorCtLeftsleeveCorrect() {
		return corCtLeftsleeveCorrect;
	}
	public void setCorCtLeftsleeveCorrect(BigDecimal corCtLeftsleeveCorrect) {
		this.corCtLeftsleeveCorrect = corCtLeftsleeveCorrect;
	}
	public BigDecimal getCorCtLeftsleeveGross() {
		return corCtLeftsleeveGross;
	}
	public void setCorCtLeftsleeveGross(BigDecimal corCtLeftsleeveGross) {
		this.corCtLeftsleeveGross = corCtLeftsleeveGross;
	}
	public BigDecimal getCorCtVenthightSize() {
		return corCtVenthightSize;
	}
	public void setCorCtVenthightSize(BigDecimal corCtVenthightSize) {
		this.corCtVenthightSize = corCtVenthightSize;
	}
	public BigDecimal getCorCtVenthightCorrect() {
		return corCtVenthightCorrect;
	}
	public void setCorCtVenthightCorrect(BigDecimal corCtVenthightCorrect) {
		this.corCtVenthightCorrect = corCtVenthightCorrect;
	}
	public BigDecimal getCorCtVenthightGross() {
		return corCtVenthightGross;
	}
	public void setCorCtVenthightGross(BigDecimal corCtVenthightGross) {
		this.corCtVenthightGross = corCtVenthightGross;
	}
	public BigDecimal getCorCtPktposSize() {
		return corCtPktposSize;
	}
	public void setCorCtPktposSize(BigDecimal corCtPktposSize) {
		this.corCtPktposSize = corCtPktposSize;
	}
	public BigDecimal getCorCtPktposCorrect() {
		return corCtPktposCorrect;
	}
	public void setCorCtPktposCorrect(BigDecimal corCtPktposCorrect) {
		this.corCtPktposCorrect = corCtPktposCorrect;
	}
	public BigDecimal getCorCtPktposGross() {
		return corCtPktposGross;
	}
	public void setCorCtPktposGross(BigDecimal corCtPktposGross) {
		this.corCtPktposGross = corCtPktposGross;
	}
	public String getCorStSize() {
		return corStSize;
	}
	public void setCorStSize(String corStSize) {
		this.corStSize = corStSize;
	}
	public BigDecimal getCorStNeckSize() {
		return corStNeckSize;
	}
	public void setCorStNeckSize(BigDecimal corStNeckSize) {
		this.corStNeckSize = corStNeckSize;
	}
	public BigDecimal getCorStNeckCorrect() {
		return corStNeckCorrect;
	}
	public void setCorStNeckCorrect(BigDecimal corStNeckCorrect) {
		this.corStNeckCorrect = corStNeckCorrect;
	}
	public BigDecimal getCorStNeckGross() {
		return corStNeckGross;
	}
	public void setCorStNeckGross(BigDecimal corStNeckGross) {
		this.corStNeckGross = corStNeckGross;
	}
	public BigDecimal getCorStBodylengthSize() {
		return corStBodylengthSize;
	}
	public void setCorStBodylengthSize(BigDecimal corStBodylengthSize) {
		this.corStBodylengthSize = corStBodylengthSize;
	}
	public BigDecimal getCorStBodylengthCorrect() {
		return corStBodylengthCorrect;
	}
	public void setCorStBodylengthCorrect(BigDecimal corStBodylengthCorrect) {
		this.corStBodylengthCorrect = corStBodylengthCorrect;
	}
	public BigDecimal getCorStBodylengthGross() {
		return corStBodylengthGross;
	}
	public void setCorStBodylengthGross(BigDecimal corStBodylengthGross) {
		this.corStBodylengthGross = corStBodylengthGross;
	}
	public BigDecimal getCorStRightsleeveSize() {
		return corStRightsleeveSize;
	}
	public void setCorStRightsleeveSize(BigDecimal corStRightsleeveSize) {
		this.corStRightsleeveSize = corStRightsleeveSize;
	}
	public BigDecimal getCorStRightsleeveCorrect() {
		return corStRightsleeveCorrect;
	}
	public void setCorStRightsleeveCorrect(BigDecimal corStRightsleeveCorrect) {
		this.corStRightsleeveCorrect = corStRightsleeveCorrect;
	}
	public BigDecimal getCorStRightsleeveGross() {
		return corStRightsleeveGross;
	}
	public void setCorStRightsleeveGross(BigDecimal corStRightsleeveGross) {
		this.corStRightsleeveGross = corStRightsleeveGross;
	}
	public BigDecimal getCorStLeftsleeveSize() {
		return corStLeftsleeveSize;
	}
	public void setCorStLeftsleeveSize(BigDecimal corStLeftsleeveSize) {
		this.corStLeftsleeveSize = corStLeftsleeveSize;
	}
	public BigDecimal getCorStLeftsleeveCorrect() {
		return corStLeftsleeveCorrect;
	}
	public void setCorStLeftsleeveCorrect(BigDecimal corStLeftsleeveCorrect) {
		this.corStLeftsleeveCorrect = corStLeftsleeveCorrect;
	}
	public BigDecimal getCorStLeftsleeveGross() {
		return corStLeftsleeveGross;
	}
	public void setCorStLeftsleeveGross(BigDecimal corStLeftsleeveGross) {
		this.corStLeftsleeveGross = corStLeftsleeveGross;
	}
	public BigDecimal getCorStBackdartsPackSize() {
		return corStBackdartsPackSize;
	}
	public void setCorStBackdartsPackSize(BigDecimal corStBackdartsPackSize) {
		this.corStBackdartsPackSize = corStBackdartsPackSize;
	}
	public BigDecimal getCorStBackdartsPackCorrect() {
		return corStBackdartsPackCorrect;
	}
	public void setCorStBackdartsPackCorrect(BigDecimal corStBackdartsPackCorrect) {
		this.corStBackdartsPackCorrect = corStBackdartsPackCorrect;
	}
	public BigDecimal getCorStBackdartsPackGross() {
		return corStBackdartsPackGross;
	}
	public void setCorStBackdartsPackGross(BigDecimal corStBackdartsPackGross) {
		this.corStBackdartsPackGross = corStBackdartsPackGross;
	}
	public BigDecimal getCorStBackdartsUnpackSize() {
		return corStBackdartsUnpackSize;
	}
	public void setCorStBackdartsUnpackSize(BigDecimal corStBackdartsUnpackSize) {
		this.corStBackdartsUnpackSize = corStBackdartsUnpackSize;
	}
	public BigDecimal getCorStBackdartsUnpackCorrect() {
		return corStBackdartsUnpackCorrect;
	}
	public void setCorStBackdartsUnpackCorrect(BigDecimal corStBackdartsUnpackCorrect) {
		this.corStBackdartsUnpackCorrect = corStBackdartsUnpackCorrect;
	}
	public BigDecimal getCorStBackdartsUnpackGross() {
		return corStBackdartsUnpackGross;
	}
	public void setCorStBackdartsUnpackGross(BigDecimal corStBackdartsUnpackGross) {
		this.corStBackdartsUnpackGross = corStBackdartsUnpackGross;
	}
	public BigDecimal getCorStRightcuffsSurroundingSize() {
		return corStRightcuffsSurroundingSize;
	}
	public void setCorStRightcuffsSurroundingSize(BigDecimal corStRightcuffsSurroundingSize) {
		this.corStRightcuffsSurroundingSize = corStRightcuffsSurroundingSize;
	}
	public BigDecimal getCorStRightcuffsSurroundingCorrect() {
		return corStRightcuffsSurroundingCorrect;
	}
	public void setCorStRightcuffsSurroundingCorrect(BigDecimal corStRightcuffsSurroundingCorrect) {
		this.corStRightcuffsSurroundingCorrect = corStRightcuffsSurroundingCorrect;
	}
	public BigDecimal getCorStRightcuffsSurroundingGross() {
		return corStRightcuffsSurroundingGross;
	}
	public void setCorStRightcuffsSurroundingGross(BigDecimal corStRightcuffsSurroundingGross) {
		this.corStRightcuffsSurroundingGross = corStRightcuffsSurroundingGross;
	}
	public BigDecimal getCorStLeftcuffsSurroundingSize() {
		return corStLeftcuffsSurroundingSize;
	}
	public void setCorStLeftcuffsSurroundingSize(BigDecimal corStLeftcuffsSurroundingSize) {
		this.corStLeftcuffsSurroundingSize = corStLeftcuffsSurroundingSize;
	}
	public BigDecimal getCorStLeftcuffsSurroundingCorrect() {
		return corStLeftcuffsSurroundingCorrect;
	}
	public void setCorStLeftcuffsSurroundingCorrect(BigDecimal corStLeftcuffsSurroundingCorrect) {
		this.corStLeftcuffsSurroundingCorrect = corStLeftcuffsSurroundingCorrect;
	}
	public BigDecimal getCorStLeftcuffsSurroundingGross() {
		return corStLeftcuffsSurroundingGross;
	}
	public void setCorStLeftcuffsSurroundingGross(BigDecimal corStLeftcuffsSurroundingGross) {
		this.corStLeftcuffsSurroundingGross = corStLeftcuffsSurroundingGross;
	}
	public String getCorStoreCorrectionMemo() {
		return corStoreCorrectionMemo;
	}
	public void setCorStoreCorrectionMemo(String corStoreCorrectionMemo) {
		this.corStoreCorrectionMemo = corStoreCorrectionMemo;
	}
	public BigDecimal getCorJkBodylengthCorrectAgain() {
		return corJkBodylengthCorrectAgain;
	}
	public void setCorJkBodylengthCorrectAgain(BigDecimal corJkBodylengthCorrectAgain) {
		this.corJkBodylengthCorrectAgain = corJkBodylengthCorrectAgain;
	}
	public BigDecimal getCorJkWaistCorrectAgain() {
		return corJkWaistCorrectAgain;
	}
	public void setCorJkWaistCorrectAgain(BigDecimal corJkWaistCorrectAgain) {
		this.corJkWaistCorrectAgain = corJkWaistCorrectAgain;
	}
	public BigDecimal getCorJkRightsleeveCorrectAgain() {
		return corJkRightsleeveCorrectAgain;
	}
	public void setCorJkRightsleeveCorrectAgain(BigDecimal corJkRightsleeveCorrectAgain) {
		this.corJkRightsleeveCorrectAgain = corJkRightsleeveCorrectAgain;
	}
	public BigDecimal getCorJkLeftsleeveCorrectAgain() {
		return corJkLeftsleeveCorrectAgain;
	}
	public void setCorJkLeftsleeveCorrectAgain(BigDecimal corJkLeftsleeveCorrectAgain) {
		this.corJkLeftsleeveCorrectAgain = corJkLeftsleeveCorrectAgain;
	}
	public BigDecimal getCorGlBodylengthCorrectAgain() {
		return corGlBodylengthCorrectAgain;
	}
	public void setCorGlBodylengthCorrectAgain(BigDecimal corGlBodylengthCorrectAgain) {
		this.corGlBodylengthCorrectAgain = corGlBodylengthCorrectAgain;
	}
	public BigDecimal getCorGlBustCorrectAgain() {
		return corGlBustCorrectAgain;
	}
	public void setCorGlBustCorrectAgain(BigDecimal corGlBustCorrectAgain) {
		this.corGlBustCorrectAgain = corGlBustCorrectAgain;
	}
	public BigDecimal getCorGlWaistCorrectAgain() {
		return corGlWaistCorrectAgain;
	}
	public void setCorGlWaistCorrectAgain(BigDecimal corGlWaistCorrectAgain) {
		this.corGlWaistCorrectAgain = corGlWaistCorrectAgain;
	}
	public BigDecimal getCorPtWaistCorrectAgain() {
		return corPtWaistCorrectAgain;
	}
	public void setCorPtWaistCorrectAgain(BigDecimal corPtWaistCorrectAgain) {
		this.corPtWaistCorrectAgain = corPtWaistCorrectAgain;
	}
	public BigDecimal getCorPtHipCorrectAgain() {
		return corPtHipCorrectAgain;
	}
	public void setCorPtHipCorrectAgain(BigDecimal corPtHipCorrectAgain) {
		this.corPtHipCorrectAgain = corPtHipCorrectAgain;
	}
	public BigDecimal getCorPtThighwidthCorrectAgain() {
		return corPtThighwidthCorrectAgain;
	}
	public void setCorPtThighwidthCorrectAgain(BigDecimal corPtThighwidthCorrectAgain) {
		this.corPtThighwidthCorrectAgain = corPtThighwidthCorrectAgain;
	}
	public BigDecimal getCorPtHemwidthCorrectAgain() {
		return corPtHemwidthCorrectAgain;
	}
	public void setCorPtHemwidthCorrectAgain(BigDecimal corPtHemwidthCorrectAgain) {
		this.corPtHemwidthCorrectAgain = corPtHemwidthCorrectAgain;
	}
	public BigDecimal getCorPtRightinseamCorrectAgain() {
		return corPtRightinseamCorrectAgain;
	}
	public void setCorPtRightinseamCorrectAgain(BigDecimal corPtRightinseamCorrectAgain) {
		this.corPtRightinseamCorrectAgain = corPtRightinseamCorrectAgain;
	}
	public BigDecimal getCorPtLeftinseamCorrectAgain() {
		return corPtLeftinseamCorrectAgain;
	}
	public void setCorPtLeftinseamCorrectAgain(BigDecimal corPtLeftinseamCorrectAgain) {
		this.corPtLeftinseamCorrectAgain = corPtLeftinseamCorrectAgain;
	}
	public BigDecimal getCorPt2WaistCorrectAgain() {
		return corPt2WaistCorrectAgain;
	}
	public void setCorPt2WaistCorrectAgain(BigDecimal corPt2WaistCorrectAgain) {
		this.corPt2WaistCorrectAgain = corPt2WaistCorrectAgain;
	}
	public BigDecimal getCorPt2HipCorrectAgain() {
		return corPt2HipCorrectAgain;
	}
	public void setCorPt2HipCorrectAgain(BigDecimal corPt2HipCorrectAgain) {
		this.corPt2HipCorrectAgain = corPt2HipCorrectAgain;
	}
	public BigDecimal getCorPt2ThighwidthCorrectAgain() {
		return corPt2ThighwidthCorrectAgain;
	}
	public void setCorPt2ThighwidthCorrectAgain(BigDecimal corPt2ThighwidthCorrectAgain) {
		this.corPt2ThighwidthCorrectAgain = corPt2ThighwidthCorrectAgain;
	}
	public BigDecimal getCorPt2HemwidthCorrectAgain() {
		return corPt2HemwidthCorrectAgain;
	}
	public void setCorPt2HemwidthCorrectAgain(BigDecimal corPt2HemwidthCorrectAgain) {
		this.corPt2HemwidthCorrectAgain = corPt2HemwidthCorrectAgain;
	}
	public BigDecimal getCorPt2RightinseamCorrectAgain() {
		return corPt2RightinseamCorrectAgain;
	}
	public void setCorPt2RightinseamCorrectAgain(BigDecimal corPt2RightinseamCorrectAgain) {
		this.corPt2RightinseamCorrectAgain = corPt2RightinseamCorrectAgain;
	}
	public BigDecimal getCorPt2LeftinseamCorrectAgain() {
		return corPt2LeftinseamCorrectAgain;
	}
	public void setCorPt2LeftinseamCorrectAgain(BigDecimal corPt2LeftinseamCorrectAgain) {
		this.corPt2LeftinseamCorrectAgain = corPt2LeftinseamCorrectAgain;
	}
	public String getCorStoreCorrectionMemoAgain() {
		return corStoreCorrectionMemoAgain;
	}
	public void setCorStoreCorrectionMemoAgain(String corStoreCorrectionMemoAgain) {
		this.corStoreCorrectionMemoAgain = corStoreCorrectionMemoAgain;
	}
	public String getHostTransmitARow() {
		return hostTransmitARow;
	}
	public void setHostTransmitARow(String hostTransmitARow) {
		this.hostTransmitARow = hostTransmitARow;
	}
	public String getShippingNumber() {
		return shippingNumber;
	}
	public void setShippingNumber(String shippingNumber) {
		this.shippingNumber = shippingNumber;
	}
	public String getFactoryShippingMethod() {
		return factoryShippingMethod;
	}
	public void setFactoryShippingMethod(String factoryShippingMethod) {
		this.factoryShippingMethod = factoryShippingMethod;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Date getLoadingDate() {
		return loadingDate;
	}
	public void setLoadingDate(Date loadingDate) {
		this.loadingDate = loadingDate;
	}
	public BigDecimal getFabricUsedMount() {
		return fabricUsedMount;
	}
	public void setFabricUsedMount(BigDecimal fabricUsedMount) {
		this.fabricUsedMount = fabricUsedMount;
	}
	public BigDecimal getTheoryFabricUsedMount() {
		return theoryFabricUsedMount;
	}
	public void setTheoryFabricUsedMount(BigDecimal theoryFabricUsedMount) {
		this.theoryFabricUsedMount = theoryFabricUsedMount;
	}
	public String getTscStatus() {
		return tscStatus;
	}
	public void setTscStatus(String tscStatus) {
		this.tscStatus = tscStatus;
	}
	public String getMakerFactoryStatus() {
		return makerFactoryStatus;
	}
	public void setMakerFactoryStatus(String makerFactoryStatus) {
		this.makerFactoryStatus = makerFactoryStatus;
	}
	public String getSend2factoryStatus() {
		return send2factoryStatus;
	}
	public void setSend2factoryStatus(String send2factoryStatus) {
		this.send2factoryStatus = send2factoryStatus;
	}
	public String getIsCancelled() {
		return isCancelled;
	}
	public void setIsCancelled(String isCancelled) {
		this.isCancelled = isCancelled;
	}
	public String getTheoreticalStockCheck() {
		return theoreticalStockCheck;
	}
	public void setTheoreticalStockCheck(String theoreticalStockCheck) {
		this.theoreticalStockCheck = theoreticalStockCheck;
	}
	public String getScheduleDataTransmitStatus() {
		return scheduleDataTransmitStatus;
	}
	public void setScheduleDataTransmitStatus(String scheduleDataTransmitStatus) {
		this.scheduleDataTransmitStatus = scheduleDataTransmitStatus;
	}
	public String getShippingTransmitStatus() {
		return shippingTransmitStatus;
	}
	public void setShippingTransmitStatus(String shippingTransmitStatus) {
		this.shippingTransmitStatus = shippingTransmitStatus;
	}
	public Short getVersion() {
		return version;
	}
	public void setVersion(Short version) {
		this.version = version;
	}
	public String getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedUserId() {
		return updatedUserId;
	}
	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(orderId == null ? "" : orderId);
		builder.append(",");
		builder.append(orderPattern == null ? "" : orderPattern);
		builder.append(",");
		builder.append(storeBrandCode == null ? "" : storeBrandCode);
		builder.append(",");
		builder.append(shopCode == null ? "" : shopCode);
		builder.append(",");
		builder.append(wsPrice == null ? "" : wsPrice);
		builder.append(",");
		builder.append(storeNm == null ? "" : storeNm);
		builder.append(",");
		builder.append(printoutCustRomaNm == null ? "" : printoutCustRomaNm);
		builder.append(",");
		builder.append(printoutStoreStaffRomaNm == null ? "" : printoutStoreStaffRomaNm);
		builder.append(",");
		builder.append(productItem == null ? "" : productItem);
		builder.append(",");
		builder.append(productIs3piece == null ? "" : productIs3piece);
		builder.append(",");
		builder.append(productIs3pieceWsWage == null ? "" : productIs3pieceWsWage);
		builder.append(",");
		builder.append(productIs3pieceWsPrice == null ? "" : productIs3pieceWsPrice);
		builder.append(",");
		builder.append(productSparePantsClass == null ? "" : productSparePantsClass);
		builder.append(",");
		builder.append(productSparePantsWsWage == null ? "" : productSparePantsWsWage);
		builder.append(",");
		builder.append(productSparePantsWsPrice == null ? "" : productSparePantsWsPrice);
		builder.append(",");
		builder.append(productFabricNo == null ? "" : productFabricNo);
		builder.append(",");
		builder.append(fabricColor == null ? "" : fabricColor);
		builder.append(",");
		builder.append(fabricPattern == null ? "" : fabricPattern);
		builder.append(",");
		builder.append(productCategory == null ? "" : productCategory);
		builder.append(",");
		builder.append(productBrandType == null ? "" : productBrandType);
		builder.append(",");
		builder.append(productBrandNm == null ? "" : productBrandNm);
		builder.append(",");
		builder.append(productFabricNmNecessity == null ? "" : productFabricNmNecessity);
		builder.append(",");
		builder.append(productEmbroideryNecessity == null ? "" : productEmbroideryNecessity);
		builder.append(",");
		builder.append(productEmbroideryNm == null ? "" : productEmbroideryNm);
		builder.append(",");
		builder.append(productEmbroideryFont == null ? "" : productEmbroideryFont);
		builder.append(",");
		builder.append(productEmbroideryThreadColor == null ? "" : productEmbroideryThreadColor);
		builder.append(",");
		builder.append(productEmbroideryGazette == null ? "" : productEmbroideryGazette);
		builder.append(",");
		builder.append(productEmbroideryGazetteWsWage == null ? "" : productEmbroideryGazetteWsWage);
		builder.append(",");
		builder.append(productEmbroideryGazetteWsPrice == null ? "" : productEmbroideryGazetteWsPrice);
		builder.append(",");
		builder.append(productEmbroideryNmPos == null ? "" : productEmbroideryNmPos);
		builder.append(",");
		builder.append(productEmbroideryNmPosWsWage == null ? "" : productEmbroideryNmPosWsWage);
		builder.append(",");
		builder.append(productEmbroideryNmPosWsPrice == null ? "" : productEmbroideryNmPosWsPrice);
		builder.append(",");
		builder.append(productEmbroideryLength == null ? "" : productEmbroideryLength);
		builder.append(",");
		builder.append(productEmbroideryWidth == null ? "" : productEmbroideryWidth);
		builder.append(",");
		builder.append(productRemainingClothType == null ? "" : productRemainingClothType);
		builder.append(",");
		builder.append(productRemainingClothNm == null ? "" : productRemainingClothNm);
		builder.append(",");
		builder.append(productFabricBrandNm == null ? "" : productFabricBrandNm);
		builder.append(",");
		builder.append(productServiceNm == null ? "" : productServiceNm);
		builder.append(",");
		builder.append(productComposFrtFabric == null ? "" : productComposFrtFabric);
		builder.append(",");
		builder.append(productComposBodyLiner == null ? "" : productComposBodyLiner);
		builder.append(",");
		builder.append(productComposSleeveLiner == null ? "" : productComposSleeveLiner);
		builder.append(",");
		builder.append(productNotice == null ? "" : productNotice);
		builder.append(",");
		builder.append(productFactoryCd == null ? "" : productFactoryCd);
		builder.append(",");
		builder.append(productMakerCode == null ? "" : productMakerCode);
		builder.append(",");
		builder.append(productOrderdDate == null ? "" : productOrderdDate);
		builder.append(",");
		builder.append(jkModelCd == null ? "" : jkModelCd);
		builder.append(",");
		builder.append(jkModelNm == null ? "" : jkModelNm);
		builder.append(",");
		builder.append(jkModelWsWage == null ? "" : jkModelWsWage);
		builder.append(",");
		builder.append(jkModelWsPrice == null ? "" : jkModelWsPrice);
		builder.append(",");
		builder.append(jkFrtBtnCd == null ? "" : jkFrtBtnCd);
		builder.append(",");
		builder.append(jkFrtBtnNm == null ? "" : jkFrtBtnNm);
		builder.append(",");
		builder.append(jkFrtBtnWsWage == null ? "" : jkFrtBtnWsWage);
		builder.append(",");
		builder.append(jkFrtBtnWsPrice == null ? "" : jkFrtBtnWsPrice);
		builder.append(",");
		builder.append(jkLapelDesignCd == null ? "" : jkLapelDesignCd);
		builder.append(",");
		builder.append(jkLapelDesignNm == null ? "" : jkLapelDesignNm);
		builder.append(",");
		builder.append(jkLapelDesignWsWage == null ? "" : jkLapelDesignWsWage);
		builder.append(",");
		builder.append(jkLapelDesignWsPrice == null ? "" : jkLapelDesignWsPrice);
		builder.append(",");
		builder.append(jkLapelModelCd == null ? "" : jkLapelModelCd);
		builder.append(",");
		builder.append(jkLapelModelNm == null ? "" : jkLapelModelNm);
		builder.append(",");
		builder.append(jkLapelModelWsWage == null ? "" : jkLapelModelWsWage);
		builder.append(",");
		builder.append(jkLapelModelWsPrice == null ? "" : jkLapelModelWsPrice);
		builder.append(",");
		builder.append(jkGradeCd == null ? "" : jkGradeCd);
		builder.append(",");
		builder.append(jkGradeNm == null ? "" : jkGradeNm);
		builder.append(",");
		builder.append(jkGradeWsWage == null ? "" : jkGradeWsWage);
		builder.append(",");
		builder.append(jkGradeWsPrice == null ? "" : jkGradeWsPrice);
		builder.append(",");
		builder.append(jkInnerClothCd == null ? "" : jkInnerClothCd);
		builder.append(",");
		builder.append(jkInnerClothNm == null ? "" : jkInnerClothNm);
		builder.append(",");
		builder.append(jkInnerClothWsWage == null ? "" : jkInnerClothWsWage);
		builder.append(",");
		builder.append(jkInnerClothWsPrice == null ? "" : jkInnerClothWsPrice);
		builder.append(",");
		builder.append(jkDaibaCd == null ? "" : jkDaibaCd);
		builder.append(",");
		builder.append(jkDaibaNm == null ? "" : jkDaibaNm);
		builder.append(",");
		builder.append(jkDaibaWsWage == null ? "" : jkDaibaWsWage);
		builder.append(",");
		builder.append(jkDaibaWsPrice == null ? "" : jkDaibaWsPrice);
		builder.append(",");
		builder.append(jkLookClothCd == null ? "" : jkLookClothCd);
		builder.append(",");
		builder.append(jkLookClothNm == null ? "" : jkLookClothNm);
		builder.append(",");
		builder.append(jkLookClothWsWage == null ? "" : jkLookClothWsWage);
		builder.append(",");
		builder.append(jkLookClothWsPrice == null ? "" : jkLookClothWsPrice);
		builder.append(",");
		builder.append(jkCollarInnerCd == null ? "" : jkCollarInnerCd);
		builder.append(",");
		builder.append(jkCollarInnerNm == null ? "" : jkCollarInnerNm);
		builder.append(",");
		builder.append(jkCollarInnerWsWage == null ? "" : jkCollarInnerWsWage);
		builder.append(",");
		builder.append(jkCollarInnerWsPrice == null ? "" : jkCollarInnerWsPrice);
		builder.append(",");
		builder.append(jkCollarHangCd == null ? "" : jkCollarHangCd);
		builder.append(",");
		builder.append(jkCollarHangNm == null ? "" : jkCollarHangNm);
		builder.append(",");
		builder.append(jkCollarHangWsWage == null ? "" : jkCollarHangWsWage);
		builder.append(",");
		builder.append(jkCollarHangWsPrice == null ? "" : jkCollarHangWsPrice);
		builder.append(",");
		builder.append(jkLapelWidthCd == null ? "" : jkLapelWidthCd);
		builder.append(",");
		builder.append(jkLapelWidthNm == null ? "" : jkLapelWidthNm);
		builder.append(",");
		builder.append(jkLapelWidthWsWage == null ? "" : jkLapelWidthWsWage);
		builder.append(",");
		builder.append(jkLapelWidthWsPrice == null ? "" : jkLapelWidthWsPrice);
		builder.append(",");
		builder.append(jkFlowerHoleCd == null ? "" : jkFlowerHoleCd);
		builder.append(",");
		builder.append(jkFlowerHoleNm == null ? "" : jkFlowerHoleNm);
		builder.append(",");
		builder.append(jkFlowerHoleWsWage == null ? "" : jkFlowerHoleWsWage);
		builder.append(",");
		builder.append(jkFlowerHoleWsPrice == null ? "" : jkFlowerHoleWsPrice);
		builder.append(",");
		builder.append(jkBreastPktCd == null ? "" : jkBreastPktCd);
		builder.append(",");
		builder.append(jkBreastPktNm == null ? "" : jkBreastPktNm);
		builder.append(",");
		builder.append(jkBreastPktWsWage == null ? "" : jkBreastPktWsWage);
		builder.append(",");
		builder.append(jkBreastPktWsPrice == null ? "" : jkBreastPktWsPrice);
		builder.append(",");
		builder.append(jkWaistPktCd == null ? "" : jkWaistPktCd);
		builder.append(",");
		builder.append(jkWaistPktNm == null ? "" : jkWaistPktNm);
		builder.append(",");
		builder.append(jkWaistPktWsWage == null ? "" : jkWaistPktWsWage);
		builder.append(",");
		builder.append(jkWaistPktWsPrice == null ? "" : jkWaistPktWsPrice);
		builder.append(",");
		builder.append(jkChgPktCd == null ? "" : jkChgPktCd);
		builder.append(",");
		builder.append(jkChgPktNm == null ? "" : jkChgPktNm);
		builder.append(",");
		builder.append(jkChgPktWsWage == null ? "" : jkChgPktWsWage);
		builder.append(",");
		builder.append(jkChgPktWsPrice == null ? "" : jkChgPktWsPrice);
		builder.append(",");
		builder.append(jkSlantedPktCd == null ? "" : jkSlantedPktCd);
		builder.append(",");
		builder.append(jkSlantedPktNm == null ? "" : jkSlantedPktNm);
		builder.append(",");
		builder.append(jkSlantedPktWsWage == null ? "" : jkSlantedPktWsWage);
		builder.append(",");
		builder.append(jkSlantedPktWsPrice == null ? "" : jkSlantedPktWsPrice);
		builder.append(",");
		builder.append(jkShinobiPktCd == null ? "" : jkShinobiPktCd);
		builder.append(",");
		builder.append(jkShinobiPktNm == null ? "" : jkShinobiPktNm);
		builder.append(",");
		builder.append(jkShinobiPktWsWage == null ? "" : jkShinobiPktWsWage);
		builder.append(",");
		builder.append(jkShinobiPktWsPrice == null ? "" : jkShinobiPktWsPrice);
		builder.append(",");
		builder.append(jkSleeveTypeCd == null ? "" : jkSleeveTypeCd);
		builder.append(",");
		builder.append(jkSleeveTypeNm == null ? "" : jkSleeveTypeNm);
		builder.append(",");
		builder.append(jkSleeveTypeWsWage == null ? "" : jkSleeveTypeWsWage);
		builder.append(",");
		builder.append(jkSleeveTypeWsPrice == null ? "" : jkSleeveTypeWsPrice);
		builder.append(",");
		builder.append(jkManicaCd == null ? "" : jkManicaCd);
		builder.append(",");
		builder.append(jkManicaNm == null ? "" : jkManicaNm);
		builder.append(",");
		builder.append(jkManicaWsWage == null ? "" : jkManicaWsWage);
		builder.append(",");
		builder.append(jkManicaWsPrice == null ? "" : jkManicaWsPrice);
		builder.append(",");
		builder.append(jkSleeveBtnType == null ? "" : jkSleeveBtnType);
		builder.append(",");
		builder.append(jkSleeveBtnNumber == null ? "" : jkSleeveBtnNumber);
		builder.append(",");
		builder.append(jkSleeveBtnCd == null ? "" : jkSleeveBtnCd);
		builder.append(",");
		builder.append(jkSleeveBtnNm == null ? "" : jkSleeveBtnNm);
		builder.append(",");
		builder.append(jkSleeveBtnWsWage == null ? "" : jkSleeveBtnWsWage);
		builder.append(",");
		builder.append(jkSleeveBtnWsPrice == null ? "" : jkSleeveBtnWsPrice);
		builder.append(",");
		builder.append(jkCuffCd == null ? "" : jkCuffCd);
		builder.append(",");
		builder.append(jkCuffNm == null ? "" : jkCuffNm);
		builder.append(",");
		builder.append(jkCuffWsWage == null ? "" : jkCuffWsWage);
		builder.append(",");
		builder.append(jkCuffWsPrice == null ? "" : jkCuffWsPrice);
		builder.append(",");
		builder.append(jkInnerPktType == null ? "" : jkInnerPktType);
		builder.append(",");
		builder.append(jkInnerPktCd == null ? "" : jkInnerPktCd);
		builder.append(",");
		builder.append(jkInnerPktNm == null ? "" : jkInnerPktNm);
		builder.append(",");
		builder.append(jkInnerPktWsWage == null ? "" : jkInnerPktWsWage);
		builder.append(",");
		builder.append(jkInnerPktWsPrice == null ? "" : jkInnerPktWsPrice);
		builder.append(",");
		builder.append(jkRightInnerPktTypeCd == null ? "" : jkRightInnerPktTypeCd);
		builder.append(",");
		builder.append(jkRightInnerPktTypeNm == null ? "" : jkRightInnerPktTypeNm);
		builder.append(",");
		builder.append(jkRightInnerPktTypeWsWage == null ? "" : jkRightInnerPktTypeWsWage);
		builder.append(",");
		builder.append(jkRightInnerPktTypeWsPrice == null ? "" : jkRightInnerPktTypeWsPrice);
		builder.append(",");
		builder.append(jkStitchTypeCd == null ? "" : jkStitchTypeCd);
		builder.append(",");
		builder.append(jkStitchTypeNm == null ? "" : jkStitchTypeNm);
		builder.append(",");
		builder.append(jkStitchTypeWsWage == null ? "" : jkStitchTypeWsWage);
		builder.append(",");
		builder.append(jkStitchTypeWsPrice == null ? "" : jkStitchTypeWsPrice);
		builder.append(",");
		builder.append(jkStitchPlcType == null ? "" : jkStitchPlcType);
		builder.append(",");
		builder.append(jkStitchPlcCd == null ? "" : jkStitchPlcCd);
		builder.append(",");
		builder.append(jkStitchPlcNm == null ? "" : jkStitchPlcNm);
		builder.append(",");
		builder.append(jkStitchPlcWsWage == null ? "" : jkStitchPlcWsWage);
		builder.append(",");
		builder.append(jkStitchPlcWsPrice == null ? "" : jkStitchPlcWsPrice);
		builder.append(",");
		builder.append(jkDblstitchPlcType == null ? "" : jkDblstitchPlcType);
		builder.append(",");
		builder.append(jkDblstitchPlcCd == null ? "" : jkDblstitchPlcCd);
		builder.append(",");
		builder.append(jkDblstitchPlcNm == null ? "" : jkDblstitchPlcNm);
		builder.append(",");
		builder.append(jkDblstitchPlcWsWage == null ? "" : jkDblstitchPlcWsWage);
		builder.append(",");
		builder.append(jkDblstitchPlcWsPrice == null ? "" : jkDblstitchPlcWsPrice);
		builder.append(",");
		builder.append(jkAmfColorType == null ? "" : jkAmfColorType);
		builder.append(",");
		builder.append(jkAmfColorPlcCd == null ? "" : jkAmfColorPlcCd);
		builder.append(",");
		builder.append(jkAmfColorPlcNm == null ? "" : jkAmfColorPlcNm);
		builder.append(",");
		builder.append(jkAmfColorCd == null ? "" : jkAmfColorCd);
		builder.append(",");
		builder.append(jkAmfColorNm == null ? "" : jkAmfColorNm);
		builder.append(",");
		builder.append(jkAmfColorWsWage == null ? "" : jkAmfColorWsWage);
		builder.append(",");
		builder.append(jkAmfColorWsPrice == null ? "" : jkAmfColorWsPrice);
		builder.append(",");
		builder.append(jkBtnholeColorType == null ? "" : jkBtnholeColorType);
		builder.append(",");
		builder.append(jkBtnholeColorPlcCd == null ? "" : jkBtnholeColorPlcCd);
		builder.append(",");
		builder.append(jkBtnholeColorPlcN == null ? "" : jkBtnholeColorPlcN);
		builder.append(",");
		builder.append(jkBtnholeColorCd == null ? "" : jkBtnholeColorCd);
		builder.append(",");
		builder.append(jkBtnholeColorNm == null ? "" : jkBtnholeColorNm);
		builder.append(",");
		builder.append(jkBtnholePlcColorWsWage == null ? "" : jkBtnholePlcColorWsWage);
		builder.append(",");
		builder.append(jkBtnholePlcColorWsPrice == null ? "" : jkBtnholePlcColorWsPrice);
		builder.append(",");
		builder.append(jkBtnthreadColorType == null ? "" : jkBtnthreadColorType);
		builder.append(",");
		builder.append(jkBtnthreadColorPlcCd == null ? "" : jkBtnthreadColorPlcCd);
		builder.append(",");
		builder.append(jkBtnthreadColorPlcN == null ? "" : jkBtnthreadColorPlcN);
		builder.append(",");
		builder.append(jkBtnthreadColorCd == null ? "" : jkBtnthreadColorCd);
		builder.append(",");
		builder.append(jkBtnthreadColorNm == null ? "" : jkBtnthreadColorNm);
		builder.append(",");
		builder.append(jkBtnthreadPlcColorWsWage == null ? "" : jkBtnthreadPlcColorWsWage);
		builder.append(",");
		builder.append(jkBtnthreadPlcColorWsPrice == null ? "" : jkBtnthreadPlcColorWsPrice);
		builder.append(",");
		builder.append(jkVentCd == null ? "" : jkVentCd);
		builder.append(",");
		builder.append(jkVentNm == null ? "" : jkVentNm);
		builder.append(",");
		builder.append(jkVentWsWage == null ? "" : jkVentWsWage);
		builder.append(",");
		builder.append(jkVentWsPrice == null ? "" : jkVentWsPrice);
		builder.append(",");
		builder.append(jkInnerBodyClothType == null ? "" : jkInnerBodyClothType);
		builder.append(",");
		builder.append(jkInnerBodyClothCd == null ? "" : jkInnerBodyClothCd);
		builder.append(",");
		builder.append(jkInnerBodyClothNm == null ? "" : jkInnerBodyClothNm);
		builder.append(",");
		builder.append(jkInnerBodyClothWsWage == null ? "" : jkInnerBodyClothWsWage);
		builder.append(",");
		builder.append(jkInnerBodyClothWsPrice == null ? "" : jkInnerBodyClothWsPrice);
		builder.append(",");
		builder.append(jkInnerSleeveClothType == null ? "" : jkInnerSleeveClothType);
		builder.append(",");
		builder.append(jkInnerSleeveClothCd == null ? "" : jkInnerSleeveClothCd);
		builder.append(",");
		builder.append(jkInnerSleeveClothNm == null ? "" : jkInnerSleeveClothNm);
		builder.append(",");
		builder.append(jkInnerSleeveClothWsWage == null ? "" : jkInnerSleeveClothWsWage);
		builder.append(",");
		builder.append(jkInnerSleeveClothWsPrice == null ? "" : jkInnerSleeveClothWsPrice);
		builder.append(",");
		builder.append(jkBtnMaterialType == null ? "" : jkBtnMaterialType);
		builder.append(",");
		builder.append(jkBtnMaterialCd == null ? "" : jkBtnMaterialCd);
		builder.append(",");
		builder.append(jkBtnMaterialNm == null ? "" : jkBtnMaterialNm);
		builder.append(",");
		builder.append(jkBtnMaterialWsWage == null ? "" : jkBtnMaterialWsWage);
		builder.append(",");
		builder.append(jkBtnMaterialWsPrice == null ? "" : jkBtnMaterialWsPrice);
		builder.append(",");
		builder.append(jkShapeMemoryCd == null ? "" : jkShapeMemoryCd);
		builder.append(",");
		builder.append(jkShapeMemoryNm == null ? "" : jkShapeMemoryNm);
		builder.append(",");
		builder.append(jkShapeMemoryWsWage == null ? "" : jkShapeMemoryWsWage);
		builder.append(",");
		builder.append(jkShapeMemoryWsPrice == null ? "" : jkShapeMemoryWsPrice);
		builder.append(",");
		builder.append(ptModelCd == null ? "" : ptModelCd);
		builder.append(",");
		builder.append(ptModelNm == null ? "" : ptModelNm);
		builder.append(",");
		builder.append(ptModelWsWage == null ? "" : ptModelWsWage);
		builder.append(",");
		builder.append(ptModelWsPrice == null ? "" : ptModelWsPrice);
		builder.append(",");
		builder.append(ptTackCd == null ? "" : ptTackCd);
		builder.append(",");
		builder.append(ptTackNm == null ? "" : ptTackNm);
		builder.append(",");
		builder.append(ptTackWsWage == null ? "" : ptTackWsWage);
		builder.append(",");
		builder.append(ptTackWsPrice == null ? "" : ptTackWsPrice);
		builder.append(",");
		builder.append(ptKneeinnerTypeCd == null ? "" : ptKneeinnerTypeCd);
		builder.append(",");
		builder.append(ptKneeinnerTypeNm == null ? "" : ptKneeinnerTypeNm);
		builder.append(",");
		builder.append(ptKneeinnerTypeWsWage == null ? "" : ptKneeinnerTypeWsWage);
		builder.append(",");
		builder.append(ptKneeinnerTypeWsPrice == null ? "" : ptKneeinnerTypeWsPrice);
		builder.append(",");
		builder.append(ptKneeinnerClothCd == null ? "" : ptKneeinnerClothCd);
		builder.append(",");
		builder.append(ptKneeinnerClothNm == null ? "" : ptKneeinnerClothNm);
		builder.append(",");
		builder.append(ptKneeinnerClothWsWage == null ? "" : ptKneeinnerClothWsWage);
		builder.append(",");
		builder.append(ptKneeinnerClothWsPrice == null ? "" : ptKneeinnerClothWsPrice);
		builder.append(",");
		builder.append(ptFrtTypeCd == null ? "" : ptFrtTypeCd);
		builder.append(",");
		builder.append(ptFrtTypeNm == null ? "" : ptFrtTypeNm);
		builder.append(",");
		builder.append(ptFrtTypeWsWage == null ? "" : ptFrtTypeWsWage);
		builder.append(",");
		builder.append(ptFrtTypeWsPrice == null ? "" : ptFrtTypeWsPrice);
		builder.append(",");
		builder.append(ptPancherinaCd == null ? "" : ptPancherinaCd);
		builder.append(",");
		builder.append(ptPancherinaNm == null ? "" : ptPancherinaNm);
		builder.append(",");
		builder.append(ptPancherinaWsWage == null ? "" : ptPancherinaWsWage);
		builder.append(",");
		builder.append(ptPancherinaWsPrice == null ? "" : ptPancherinaWsPrice);
		builder.append(",");
		builder.append(ptAdjusterCd == null ? "" : ptAdjusterCd);
		builder.append(",");
		builder.append(ptAdjusterNm == null ? "" : ptAdjusterNm);
		builder.append(",");
		builder.append(ptAdjusterWsWage == null ? "" : ptAdjusterWsWage);
		builder.append(",");
		builder.append(ptAdjusterWsPrice == null ? "" : ptAdjusterWsPrice);
		builder.append(",");
		builder.append(ptBeltloopType == null ? "" : ptBeltloopType);
		builder.append(",");
		builder.append(ptBeltloopCd == null ? "" : ptBeltloopCd);
		builder.append(",");
		builder.append(ptBeltloopNm == null ? "" : ptBeltloopNm);
		builder.append(",");
		builder.append(ptBeltloopWsWage == null ? "" : ptBeltloopWsWage);
		builder.append(",");
		builder.append(ptBeltloopWsPrice == null ? "" : ptBeltloopWsPrice);
		builder.append(",");
		builder.append(ptPinloopCd == null ? "" : ptPinloopCd);
		builder.append(",");
		builder.append(ptPinloopNm == null ? "" : ptPinloopNm);
		builder.append(",");
		builder.append(ptPinloopWsWage == null ? "" : ptPinloopWsWage);
		builder.append(",");
		builder.append(ptPinloopWsPrice == null ? "" : ptPinloopWsPrice);
		builder.append(",");
		builder.append(ptSidePktCd == null ? "" : ptSidePktCd);
		builder.append(",");
		builder.append(ptSidePktNm == null ? "" : ptSidePktNm);
		builder.append(",");
		builder.append(ptSidePktWsWage == null ? "" : ptSidePktWsWage);
		builder.append(",");
		builder.append(ptSidePktWsPrice == null ? "" : ptSidePktWsPrice);
		builder.append(",");
		builder.append(ptShinobiPktCd == null ? "" : ptShinobiPktCd);
		builder.append(",");
		builder.append(ptShinobiPktNm == null ? "" : ptShinobiPktNm);
		builder.append(",");
		builder.append(ptShinobiPktWsWage == null ? "" : ptShinobiPktWsWage);
		builder.append(",");
		builder.append(ptShinobiPktWsPrice == null ? "" : ptShinobiPktWsPrice);
		builder.append(",");
		builder.append(ptCoinPktCd == null ? "" : ptCoinPktCd);
		builder.append(",");
		builder.append(ptCoinPktNm == null ? "" : ptCoinPktNm);
		builder.append(",");
		builder.append(ptCoinPktWsWage == null ? "" : ptCoinPktWsWage);
		builder.append(",");
		builder.append(ptCoinPktWsPrice == null ? "" : ptCoinPktWsPrice);
		builder.append(",");
		builder.append(ptFlapcoinPktCd == null ? "" : ptFlapcoinPktCd);
		builder.append(",");
		builder.append(ptFlapcoinPktNm == null ? "" : ptFlapcoinPktNm);
		builder.append(",");
		builder.append(ptFlapcoinPktWsWage == null ? "" : ptFlapcoinPktWsWage);
		builder.append(",");
		builder.append(ptFlapcoinPktWsPrice == null ? "" : ptFlapcoinPktWsPrice);
		builder.append(",");
		builder.append(ptLeftPisPktCd == null ? "" : ptLeftPisPktCd);
		builder.append(",");
		builder.append(ptLeftPisPktNm == null ? "" : ptLeftPisPktNm);
		builder.append(",");
		builder.append(ptLeftPisPktWsWage == null ? "" : ptLeftPisPktWsWage);
		builder.append(",");
		builder.append(ptLeftPisPktWsPrice == null ? "" : ptLeftPisPktWsPrice);
		builder.append(",");
		builder.append(ptRightPisPktCd == null ? "" : ptRightPisPktCd);
		builder.append(",");
		builder.append(ptRightPisPktNm == null ? "" : ptRightPisPktNm);
		builder.append(",");
		builder.append(ptRightPisPktWsWage == null ? "" : ptRightPisPktWsWage);
		builder.append(",");
		builder.append(ptRightPisPktWsPrice == null ? "" : ptRightPisPktWsPrice);
		builder.append(",");
		builder.append(ptVCutCd == null ? "" : ptVCutCd);
		builder.append(",");
		builder.append(ptVCutNm == null ? "" : ptVCutNm);
		builder.append(",");
		builder.append(ptVCutWsWage == null ? "" : ptVCutWsWage);
		builder.append(",");
		builder.append(ptVCutWsPrice == null ? "" : ptVCutWsPrice);
		builder.append(",");
		builder.append(ptHemUpCd == null ? "" : ptHemUpCd);
		builder.append(",");
		builder.append(ptHemUpNm == null ? "" : ptHemUpNm);
		builder.append(",");
		builder.append(ptHemUpWsWage == null ? "" : ptHemUpWsWage);
		builder.append(",");
		builder.append(ptHemUpWsPrice == null ? "" : ptHemUpWsPrice);
		builder.append(",");
		builder.append(ptDblWidthCd == null ? "" : ptDblWidthCd);
		builder.append(",");
		builder.append(ptDblWidthNm == null ? "" : ptDblWidthNm);
		builder.append(",");
		builder.append(ptDblWidthWsWage == null ? "" : ptDblWidthWsWage);
		builder.append(",");
		builder.append(ptDblWidthWsPrice == null ? "" : ptDblWidthWsPrice);
		builder.append(",");
		builder.append(ptAmfStitchCd == null ? "" : ptAmfStitchCd);
		builder.append(",");
		builder.append(ptAmfStitchNm == null ? "" : ptAmfStitchNm);
		builder.append(",");
		builder.append(ptAmfStitchWsWage == null ? "" : ptAmfStitchWsWage);
		builder.append(",");
		builder.append(ptAmfStitchWsPrice == null ? "" : ptAmfStitchWsPrice);
		builder.append(",");
		builder.append(ptStitchPlcType == null ? "" : ptStitchPlcType);
		builder.append(",");
		builder.append(ptStitchPlcCd == null ? "" : ptStitchPlcCd);
		builder.append(",");
		builder.append(ptStitchPlcNm == null ? "" : ptStitchPlcNm);
		builder.append(",");
		builder.append(ptStitchPlcWsWage == null ? "" : ptStitchPlcWsWage);
		builder.append(",");
		builder.append(ptStitchPlcWsPrice == null ? "" : ptStitchPlcWsPrice);
		builder.append(",");
		builder.append(ptDblstitchPlcType == null ? "" : ptDblstitchPlcType);
		builder.append(",");
		builder.append(ptDblstitchPlcCd == null ? "" : ptDblstitchPlcCd);
		builder.append(",");
		builder.append(ptDblstitchPlcNm == null ? "" : ptDblstitchPlcNm);
		builder.append(",");
		builder.append(ptDblstitchPlcWsWage == null ? "" : ptDblstitchPlcWsWage);
		builder.append(",");
		builder.append(ptDblstitchPlcWsPrice == null ? "" : ptDblstitchPlcWsPrice);
		builder.append(",");
		builder.append(ptAmfColorType == null ? "" : ptAmfColorType);
		builder.append(",");
		builder.append(ptAmfColorPlcCd == null ? "" : ptAmfColorPlcCd);
		builder.append(",");
		builder.append(ptAmfColorPlcNm == null ? "" : ptAmfColorPlcNm);
		builder.append(",");
		builder.append(ptAmfColorCd == null ? "" : ptAmfColorCd);
		builder.append(",");
		builder.append(ptAmfColorNm == null ? "" : ptAmfColorNm);
		builder.append(",");
		builder.append(ptAmfColorWsWage == null ? "" : ptAmfColorWsWage);
		builder.append(",");
		builder.append(ptAmfColorWsPrice == null ? "" : ptAmfColorWsPrice);
		builder.append(",");
		builder.append(ptBtnholeColorType == null ? "" : ptBtnholeColorType);
		builder.append(",");
		builder.append(ptBtnholeColorPlcCd == null ? "" : ptBtnholeColorPlcCd);
		builder.append(",");
		builder.append(ptBtnholeColorPlcNm == null ? "" : ptBtnholeColorPlcNm);
		builder.append(",");
		builder.append(ptBtnholeColorCd == null ? "" : ptBtnholeColorCd);
		builder.append(",");
		builder.append(ptBtnholeColorNm == null ? "" : ptBtnholeColorNm);
		builder.append(",");
		builder.append(ptBtnholeColorWsWage == null ? "" : ptBtnholeColorWsWage);
		builder.append(",");
		builder.append(ptBtnholeColorWsPrice == null ? "" : ptBtnholeColorWsPrice);
		builder.append(",");
		builder.append(ptBtnthreadColorType == null ? "" : ptBtnthreadColorType);
		builder.append(",");
		builder.append(ptBtnthreadColorPlcCd == null ? "" : ptBtnthreadColorPlcCd);
		builder.append(",");
		builder.append(ptBtnthreadColorPlcNm == null ? "" : ptBtnthreadColorPlcNm);
		builder.append(",");
		builder.append(ptBtnthreadColorCd == null ? "" : ptBtnthreadColorCd);
		builder.append(",");
		builder.append(ptBtnthreadColorNm == null ? "" : ptBtnthreadColorNm);
		builder.append(",");
		builder.append(ptBtnthreadColorWsWage == null ? "" : ptBtnthreadColorWsWage);
		builder.append(",");
		builder.append(ptBtnthreadColorWsPrice == null ? "" : ptBtnthreadColorWsPrice);
		builder.append(",");
		builder.append(ptBtnMaterialType == null ? "" : ptBtnMaterialType);
		builder.append(",");
		builder.append(ptBtnMaterialCd == null ? "" : ptBtnMaterialCd);
		builder.append(",");
		builder.append(ptBtnMaterialNm == null ? "" : ptBtnMaterialNm);
		builder.append(",");
		builder.append(ptBtnMaterialWsWage == null ? "" : ptBtnMaterialWsWage);
		builder.append(",");
		builder.append(ptBtnMaterialWsPrice == null ? "" : ptBtnMaterialWsPrice);
		builder.append(",");
		builder.append(ptSuspenderBtnCd == null ? "" : ptSuspenderBtnCd);
		builder.append(",");
		builder.append(ptSuspenderBtnNm == null ? "" : ptSuspenderBtnNm);
		builder.append(",");
		builder.append(ptSuspenderBtnWsWage == null ? "" : ptSuspenderBtnWsWage);
		builder.append(",");
		builder.append(ptSuspenderBtnWsPrice == null ? "" : ptSuspenderBtnWsPrice);
		builder.append(",");
		builder.append(ptNonSlipCd == null ? "" : ptNonSlipCd);
		builder.append(",");
		builder.append(ptNonSlipNm == null ? "" : ptNonSlipNm);
		builder.append(",");
		builder.append(ptNonSlipWsWage == null ? "" : ptNonSlipWsWage);
		builder.append(",");
		builder.append(ptNonSlipWsPrice == null ? "" : ptNonSlipWsPrice);
		builder.append(",");
		builder.append(ptChicSlipCd == null ? "" : ptChicSlipCd);
		builder.append(",");
		builder.append(ptChicSlipNm == null ? "" : ptChicSlipNm);
		builder.append(",");
		builder.append(ptChicSlipWsWage == null ? "" : ptChicSlipWsWage);
		builder.append(",");
		builder.append(ptChicSlipWsPrice == null ? "" : ptChicSlipWsPrice);
		builder.append(",");
		builder.append(ptShapeMemoryCd == null ? "" : ptShapeMemoryCd);
		builder.append(",");
		builder.append(ptShapeMemoryNm == null ? "" : ptShapeMemoryNm);
		builder.append(",");
		builder.append(ptShapeMemoryWsWage == null ? "" : ptShapeMemoryWsWage);
		builder.append(",");
		builder.append(ptShapeMemoryWsPrice == null ? "" : ptShapeMemoryWsPrice);
		builder.append(",");
		builder.append(ptShoeSoreCd == null ? "" : ptShoeSoreCd);
		builder.append(",");
		builder.append(ptShoeSoreNm == null ? "" : ptShoeSoreNm);
		builder.append(",");
		builder.append(ptShoeSoreWsWage == null ? "" : ptShoeSoreWsWage);
		builder.append(",");
		builder.append(ptShoeSoreWsPrice == null ? "" : ptShoeSoreWsPrice);
		builder.append(",");
		builder.append(ptSideStripeCd == null ? "" : ptSideStripeCd);
		builder.append(",");
		builder.append(ptSideStripeNm == null ? "" : ptSideStripeNm);
		builder.append(",");
		builder.append(ptSideStripeWsWage == null ? "" : ptSideStripeWsWage);
		builder.append(",");
		builder.append(ptSideStripeWsPrice == null ? "" : ptSideStripeWsPrice);
		builder.append(",");
		builder.append(ptSideStripeWidthCd == null ? "" : ptSideStripeWidthCd);
		builder.append(",");
		builder.append(ptSideStripeWidthNm == null ? "" : ptSideStripeWidthNm);
		builder.append(",");
		builder.append(ptSideStripeWidthWsWage == null ? "" : ptSideStripeWidthWsWage);
		builder.append(",");
		builder.append(ptSideStripeWidthWsPrice == null ? "" : ptSideStripeWidthWsPrice);
		builder.append(",");
		builder.append(pt2ModelCd == null ? "" : pt2ModelCd);
		builder.append(",");
		builder.append(pt2ModelNm == null ? "" : pt2ModelNm);
		builder.append(",");
		builder.append(pt2ModelWsWage == null ? "" : pt2ModelWsWage);
		builder.append(",");
		builder.append(pt2ModelWsPrice == null ? "" : pt2ModelWsPrice);
		builder.append(",");
		builder.append(pt2TackCd == null ? "" : pt2TackCd);
		builder.append(",");
		builder.append(pt2TackNm == null ? "" : pt2TackNm);
		builder.append(",");
		builder.append(pt2TackWsWage == null ? "" : pt2TackWsWage);
		builder.append(",");
		builder.append(pt2TackWsPrice == null ? "" : pt2TackWsPrice);
		builder.append(",");
		builder.append(pt2KneeinnerTypeCd == null ? "" : pt2KneeinnerTypeCd);
		builder.append(",");
		builder.append(pt2KneeinnerTypeNm == null ? "" : pt2KneeinnerTypeNm);
		builder.append(",");
		builder.append(pt2KneeinnerTypeWsWage == null ? "" : pt2KneeinnerTypeWsWage);
		builder.append(",");
		builder.append(pt2KneeinnerTypeWsPrice == null ? "" : pt2KneeinnerTypeWsPrice);
		builder.append(",");
		builder.append(pt2KneeinnerClothCd == null ? "" : pt2KneeinnerClothCd);
		builder.append(",");
		builder.append(pt2KneeinnerClothNm == null ? "" : pt2KneeinnerClothNm);
		builder.append(",");
		builder.append(pt2KneeinnerClothWsWage == null ? "" : pt2KneeinnerClothWsWage);
		builder.append(",");
		builder.append(pt2KneeinnerClothWsPrice == null ? "" : pt2KneeinnerClothWsPrice);
		builder.append(",");
		builder.append(pt2FrtTypeCd == null ? "" : pt2FrtTypeCd);
		builder.append(",");
		builder.append(pt2FrtTypeNm == null ? "" : pt2FrtTypeNm);
		builder.append(",");
		builder.append(pt2FrtTypeWsWage == null ? "" : pt2FrtTypeWsWage);
		builder.append(",");
		builder.append(pt2FrtTypeWsPrice == null ? "" : pt2FrtTypeWsPrice);
		builder.append(",");
		builder.append(pt2PancherinaCd == null ? "" : pt2PancherinaCd);
		builder.append(",");
		builder.append(pt2PancherinaNm == null ? "" : pt2PancherinaNm);
		builder.append(",");
		builder.append(pt2PancherinaWsWage == null ? "" : pt2PancherinaWsWage);
		builder.append(",");
		builder.append(pt2PancherinaWsPrice == null ? "" : pt2PancherinaWsPrice);
		builder.append(",");
		builder.append(pt2AdjusterCd == null ? "" : pt2AdjusterCd);
		builder.append(",");
		builder.append(pt2AdjusterNm == null ? "" : pt2AdjusterNm);
		builder.append(",");
		builder.append(pt2AdjusterWsWage == null ? "" : pt2AdjusterWsWage);
		builder.append(",");
		builder.append(pt2AdjusterWsPrice == null ? "" : pt2AdjusterWsPrice);
		builder.append(",");
		builder.append(pt2BeltloopType == null ? "" : pt2BeltloopType);
		builder.append(",");
		builder.append(pt2BeltloopCd == null ? "" : pt2BeltloopCd);
		builder.append(",");
		builder.append(pt2BeltloopNm == null ? "" : pt2BeltloopNm);
		builder.append(",");
		builder.append(pt2BeltloopWsWage == null ? "" : pt2BeltloopWsWage);
		builder.append(",");
		builder.append(pt2BeltloopWsPrice == null ? "" : pt2BeltloopWsPrice);
		builder.append(",");
		builder.append(pt2PinloopCd == null ? "" : pt2PinloopCd);
		builder.append(",");
		builder.append(pt2PinloopNm == null ? "" : pt2PinloopNm);
		builder.append(",");
		builder.append(pt2PinloopWsWage == null ? "" : pt2PinloopWsWage);
		builder.append(",");
		builder.append(pt2PinloopWsPrice == null ? "" : pt2PinloopWsPrice);
		builder.append(",");
		builder.append(pt2SidePktCd == null ? "" : pt2SidePktCd);
		builder.append(",");
		builder.append(pt2SidePktNm == null ? "" : pt2SidePktNm);
		builder.append(",");
		builder.append(pt2SidePktWsWage == null ? "" : pt2SidePktWsWage);
		builder.append(",");
		builder.append(pt2SidePktWsPrice == null ? "" : pt2SidePktWsPrice);
		builder.append(",");
		builder.append(pt2ShinobiPktCd == null ? "" : pt2ShinobiPktCd);
		builder.append(",");
		builder.append(pt2ShinobiPktNm == null ? "" : pt2ShinobiPktNm);
		builder.append(",");
		builder.append(pt2ShinobiPktWsWage == null ? "" : pt2ShinobiPktWsWage);
		builder.append(",");
		builder.append(pt2ShinobiPktWsPrice == null ? "" : pt2ShinobiPktWsPrice);
		builder.append(",");
		builder.append(pt2CoinPktCd == null ? "" : pt2CoinPktCd);
		builder.append(",");
		builder.append(pt2CoinPktNm == null ? "" : pt2CoinPktNm);
		builder.append(",");
		builder.append(pt2CoinPktWsWage == null ? "" : pt2CoinPktWsWage);
		builder.append(",");
		builder.append(pt2CoinPktWsPrice == null ? "" : pt2CoinPktWsPrice);
		builder.append(",");
		builder.append(pt2FlapcoinPktCd == null ? "" : pt2FlapcoinPktCd);
		builder.append(",");
		builder.append(pt2FlapcoinPktNm == null ? "" : pt2FlapcoinPktNm);
		builder.append(",");
		builder.append(pt2FlapcoinPktWsWage == null ? "" : pt2FlapcoinPktWsWage);
		builder.append(",");
		builder.append(pt2FlapcoinPktWsPrice == null ? "" : pt2FlapcoinPktWsPrice);
		builder.append(",");
		builder.append(pt2LeftPisPktCd == null ? "" : pt2LeftPisPktCd);
		builder.append(",");
		builder.append(pt2LeftPisPktNm == null ? "" : pt2LeftPisPktNm);
		builder.append(",");
		builder.append(pt2LeftPisPktWsWage == null ? "" : pt2LeftPisPktWsWage);
		builder.append(",");
		builder.append(pt2LeftPisPktWsPrice == null ? "" : pt2LeftPisPktWsPrice);
		builder.append(",");
		builder.append(pt2RightPisPktCd == null ? "" : pt2RightPisPktCd);
		builder.append(",");
		builder.append(pt2RightPisPktNm == null ? "" : pt2RightPisPktNm);
		builder.append(",");
		builder.append(pt2RightPisPktWsWage == null ? "" : pt2RightPisPktWsWage);
		builder.append(",");
		builder.append(pt2RightPisPktWsPrice == null ? "" : pt2RightPisPktWsPrice);
		builder.append(",");
		builder.append(pt2VCutCd == null ? "" : pt2VCutCd);
		builder.append(",");
		builder.append(pt2VCutNm == null ? "" : pt2VCutNm);
		builder.append(",");
		builder.append(pt2VCutWsWage == null ? "" : pt2VCutWsWage);
		builder.append(",");
		builder.append(pt2VCutWsPrice == null ? "" : pt2VCutWsPrice);
		builder.append(",");
		builder.append(pt2HemUpCd == null ? "" : pt2HemUpCd);
		builder.append(",");
		builder.append(pt2HemUpNm == null ? "" : pt2HemUpNm);
		builder.append(",");
		builder.append(pt2HemUpWsWage == null ? "" : pt2HemUpWsWage);
		builder.append(",");
		builder.append(pt2HemUpWsPrice == null ? "" : pt2HemUpWsPrice);
		builder.append(",");
		builder.append(pt2DblWidthCd == null ? "" : pt2DblWidthCd);
		builder.append(",");
		builder.append(pt2DblWidthNm == null ? "" : pt2DblWidthNm);
		builder.append(",");
		builder.append(pt2DblWidthWsWage == null ? "" : pt2DblWidthWsWage);
		builder.append(",");
		builder.append(pt2DblWidthWsPrice == null ? "" : pt2DblWidthWsPrice);
		builder.append(",");
		builder.append(pt2AmfStitchCd == null ? "" : pt2AmfStitchCd);
		builder.append(",");
		builder.append(pt2AmfStitchNm == null ? "" : pt2AmfStitchNm);
		builder.append(",");
		builder.append(pt2AmfStitchWsWage == null ? "" : pt2AmfStitchWsWage);
		builder.append(",");
		builder.append(pt2AmfStitchWsPrice == null ? "" : pt2AmfStitchWsPrice);
		builder.append(",");
		builder.append(pt2StitchPlcType == null ? "" : pt2StitchPlcType);
		builder.append(",");
		builder.append(pt2StitchPlcCd == null ? "" : pt2StitchPlcCd);
		builder.append(",");
		builder.append(pt2StitchPlcNm == null ? "" : pt2StitchPlcNm);
		builder.append(",");
		builder.append(pt2StitchPlcWsWage == null ? "" : pt2StitchPlcWsWage);
		builder.append(",");
		builder.append(pt2StitchPlcWsPrice == null ? "" : pt2StitchPlcWsPrice);
		builder.append(",");
		builder.append(pt2DblstitchPlcType == null ? "" : pt2DblstitchPlcType);
		builder.append(",");
		builder.append(pt2DblstitchPlcCd == null ? "" : pt2DblstitchPlcCd);
		builder.append(",");
		builder.append(pt2DblstitchPlcNm == null ? "" : pt2DblstitchPlcNm);
		builder.append(",");
		builder.append(pt2DblstitchPlcWsWage == null ? "" : pt2DblstitchPlcWsWage);
		builder.append(",");
		builder.append(pt2DblstitchPlcWsPrice == null ? "" : pt2DblstitchPlcWsPrice);
		builder.append(",");
		builder.append(pt2AmfColorType == null ? "" : pt2AmfColorType);
		builder.append(",");
		builder.append(pt2AmfColorPlcCd == null ? "" : pt2AmfColorPlcCd);
		builder.append(",");
		builder.append(pt2AmfColorPlcNm == null ? "" : pt2AmfColorPlcNm);
		builder.append(",");
		builder.append(pt2AmfColorCd == null ? "" : pt2AmfColorCd);
		builder.append(",");
		builder.append(pt2AmfColorNm == null ? "" : pt2AmfColorNm);
		builder.append(",");
		builder.append(pt2AmfColorWsWage == null ? "" : pt2AmfColorWsWage);
		builder.append(",");
		builder.append(pt2AmfColorWsPrice == null ? "" : pt2AmfColorWsPrice);
		builder.append(",");
		builder.append(pt2BtnholeColorType == null ? "" : pt2BtnholeColorType);
		builder.append(",");
		builder.append(pt2BtnholeColorPlcCd == null ? "" : pt2BtnholeColorPlcCd);
		builder.append(",");
		builder.append(pt2BtnholeColorPlcNm == null ? "" : pt2BtnholeColorPlcNm);
		builder.append(",");
		builder.append(pt2BtnholeColorCd == null ? "" : pt2BtnholeColorCd);
		builder.append(",");
		builder.append(pt2BtnholeColorNm == null ? "" : pt2BtnholeColorNm);
		builder.append(",");
		builder.append(pt2BtnholeColorWsWage == null ? "" : pt2BtnholeColorWsWage);
		builder.append(",");
		builder.append(pt2BtnholeColorWsPrice == null ? "" : pt2BtnholeColorWsPrice);
		builder.append(",");
		builder.append(pt2BtnthreadColorType == null ? "" : pt2BtnthreadColorType);
		builder.append(",");
		builder.append(pt2BtnthreadColorPlcCd == null ? "" : pt2BtnthreadColorPlcCd);
		builder.append(",");
		builder.append(pt2BtnthreadColorPlcNm == null ? "" : pt2BtnthreadColorPlcNm);
		builder.append(",");
		builder.append(pt2BtnthreadColorCd == null ? "" : pt2BtnthreadColorCd);
		builder.append(",");
		builder.append(pt2BtnthreadColorNm == null ? "" : pt2BtnthreadColorNm);
		builder.append(",");
		builder.append(pt2BtnthreadColorWsWage == null ? "" : pt2BtnthreadColorWsWage);
		builder.append(",");
		builder.append(pt2BtnthreadColorWsPrice == null ? "" : pt2BtnthreadColorWsPrice);
		builder.append(",");
		builder.append(pt2BtnMaterialType == null ? "" : pt2BtnMaterialType);
		builder.append(",");
		builder.append(pt2BtnMaterialCd == null ? "" : pt2BtnMaterialCd);
		builder.append(",");
		builder.append(pt2BtnMaterialNm == null ? "" : pt2BtnMaterialNm);
		builder.append(",");
		builder.append(pt2BtnMaterialWsWage == null ? "" : pt2BtnMaterialWsWage);
		builder.append(",");
		builder.append(pt2BtnMaterialWsPrice == null ? "" : pt2BtnMaterialWsPrice);
		builder.append(",");
		builder.append(pt2SuspenderBtnCd == null ? "" : pt2SuspenderBtnCd);
		builder.append(",");
		builder.append(pt2SuspenderBtnNm == null ? "" : pt2SuspenderBtnNm);
		builder.append(",");
		builder.append(pt2SuspenderBtnWsWage == null ? "" : pt2SuspenderBtnWsWage);
		builder.append(",");
		builder.append(pt2SuspenderBtnWsPrice == null ? "" : pt2SuspenderBtnWsPrice);
		builder.append(",");
		builder.append(pt2NonSlipCd == null ? "" : pt2NonSlipCd);
		builder.append(",");
		builder.append(pt2NonSlipNm == null ? "" : pt2NonSlipNm);
		builder.append(",");
		builder.append(pt2NonSlipWsWage == null ? "" : pt2NonSlipWsWage);
		builder.append(",");
		builder.append(pt2NonSlipWsPrice == null ? "" : pt2NonSlipWsPrice);
		builder.append(",");
		builder.append(pt2ChicSlipCd == null ? "" : pt2ChicSlipCd);
		builder.append(",");
		builder.append(pt2ChicSlipNm == null ? "" : pt2ChicSlipNm);
		builder.append(",");
		builder.append(pt2ChicSlipWsWage == null ? "" : pt2ChicSlipWsWage);
		builder.append(",");
		builder.append(pt2ChicSlipWsPrice == null ? "" : pt2ChicSlipWsPrice);
		builder.append(",");
		builder.append(pt2ShapeMemoryCd == null ? "" : pt2ShapeMemoryCd);
		builder.append(",");
		builder.append(pt2ShapeMemoryNm == null ? "" : pt2ShapeMemoryNm);
		builder.append(",");
		builder.append(pt2ShapeMemoryWsWage == null ? "" : pt2ShapeMemoryWsWage);
		builder.append(",");
		builder.append(pt2ShapeMemoryWsPrice == null ? "" : pt2ShapeMemoryWsPrice);
		builder.append(",");
		builder.append(pt2ShoeSoreCd == null ? "" : pt2ShoeSoreCd);
		builder.append(",");
		builder.append(pt2ShoeSoreNm == null ? "" : pt2ShoeSoreNm);
		builder.append(",");
		builder.append(pt2ShoeSoreWsWage == null ? "" : pt2ShoeSoreWsWage);
		builder.append(",");
		builder.append(pt2ShoeSoreWsPrice == null ? "" : pt2ShoeSoreWsPrice);
		builder.append(",");
		builder.append(pt2SideStripeCd == null ? "" : pt2SideStripeCd);
		builder.append(",");
		builder.append(pt2SideStripeNm == null ? "" : pt2SideStripeNm);
		builder.append(",");
		builder.append(pt2SideStripeWsWage == null ? "" : pt2SideStripeWsWage);
		builder.append(",");
		builder.append(pt2SideStripeWsPrice == null ? "" : pt2SideStripeWsPrice);
		builder.append(",");
		builder.append(pt2SideStripeWidthCd == null ? "" : pt2SideStripeWidthCd);
		builder.append(",");
		builder.append(pt2SideStripeWidthNm == null ? "" : pt2SideStripeWidthNm);
		builder.append(",");
		builder.append(pt2SideStripeWidthWsWage == null ? "" : pt2SideStripeWidthWsWage);
		builder.append(",");
		builder.append(pt2SideStripeWidthWsPrice == null ? "" : pt2SideStripeWidthWsPrice);
		builder.append(",");
		builder.append(pt3ModelCd == null ? "" : pt3ModelCd);
		builder.append(",");
		builder.append(pt3ModelNm == null ? "" : pt3ModelNm);
		builder.append(",");
		builder.append(pt3ModelWsWage == null ? "" : pt3ModelWsWage);
		builder.append(",");
		builder.append(pt3ModelWsPrice == null ? "" : pt3ModelWsPrice);
		builder.append(",");
		builder.append(pt3TackCd == null ? "" : pt3TackCd);
		builder.append(",");
		builder.append(pt3TackNm == null ? "" : pt3TackNm);
		builder.append(",");
		builder.append(pt3TackWsWage == null ? "" : pt3TackWsWage);
		builder.append(",");
		builder.append(pt3TackWsPrice == null ? "" : pt3TackWsPrice);
		builder.append(",");
		builder.append(pt3KneeinnerTypeCd == null ? "" : pt3KneeinnerTypeCd);
		builder.append(",");
		builder.append(pt3KneeinnerTypeNm == null ? "" : pt3KneeinnerTypeNm);
		builder.append(",");
		builder.append(pt3KneeinnerTypeWsWage == null ? "" : pt3KneeinnerTypeWsWage);
		builder.append(",");
		builder.append(pt3KneeinnerTypeWsPrice == null ? "" : pt3KneeinnerTypeWsPrice);
		builder.append(",");
		builder.append(pt3KneeinnerClothCd == null ? "" : pt3KneeinnerClothCd);
		builder.append(",");
		builder.append(pt3KneeinnerClothNm == null ? "" : pt3KneeinnerClothNm);
		builder.append(",");
		builder.append(pt3KneeinnerClothWsWage == null ? "" : pt3KneeinnerClothWsWage);
		builder.append(",");
		builder.append(pt3KneeinnerClothWsPrice == null ? "" : pt3KneeinnerClothWsPrice);
		builder.append(",");
		builder.append(pt3FrtTypeCd == null ? "" : pt3FrtTypeCd);
		builder.append(",");
		builder.append(pt3FrtTypeNm == null ? "" : pt3FrtTypeNm);
		builder.append(",");
		builder.append(pt3FrtTypeWsWage == null ? "" : pt3FrtTypeWsWage);
		builder.append(",");
		builder.append(pt3FrtTypeWsPrice == null ? "" : pt3FrtTypeWsPrice);
		builder.append(",");
		builder.append(pt3PancherinaCd == null ? "" : pt3PancherinaCd);
		builder.append(",");
		builder.append(pt3PancherinaNm == null ? "" : pt3PancherinaNm);
		builder.append(",");
		builder.append(pt3PancherinaWsWage == null ? "" : pt3PancherinaWsWage);
		builder.append(",");
		builder.append(pt3PancherinaWsPrice == null ? "" : pt3PancherinaWsPrice);
		builder.append(",");
		builder.append(pt3AdjusterCd == null ? "" : pt3AdjusterCd);
		builder.append(",");
		builder.append(pt3AdjusterNm == null ? "" : pt3AdjusterNm);
		builder.append(",");
		builder.append(pt3AdjusterWsWage == null ? "" : pt3AdjusterWsWage);
		builder.append(",");
		builder.append(pt3AdjusterWsPrice == null ? "" : pt3AdjusterWsPrice);
		builder.append(",");
		builder.append(pt3BeltloopType == null ? "" : pt3BeltloopType);
		builder.append(",");
		builder.append(pt3BeltloopCd == null ? "" : pt3BeltloopCd);
		builder.append(",");
		builder.append(pt3BeltloopNm == null ? "" : pt3BeltloopNm);
		builder.append(",");
		builder.append(pt3BeltloopWsWage == null ? "" : pt3BeltloopWsWage);
		builder.append(",");
		builder.append(pt3BeltloopWsPrice == null ? "" : pt3BeltloopWsPrice);
		builder.append(",");
		builder.append(pt3PinloopCd == null ? "" : pt3PinloopCd);
		builder.append(",");
		builder.append(pt3PinloopNm == null ? "" : pt3PinloopNm);
		builder.append(",");
		builder.append(pt3PinloopWsWage == null ? "" : pt3PinloopWsWage);
		builder.append(",");
		builder.append(pt3PinloopWsPrice == null ? "" : pt3PinloopWsPrice);
		builder.append(",");
		builder.append(pt3SidePktCd == null ? "" : pt3SidePktCd);
		builder.append(",");
		builder.append(pt3SidePktNm == null ? "" : pt3SidePktNm);
		builder.append(",");
		builder.append(pt3SidePktWsWage == null ? "" : pt3SidePktWsWage);
		builder.append(",");
		builder.append(pt3SidePktWsPrice == null ? "" : pt3SidePktWsPrice);
		builder.append(",");
		builder.append(pt3ShinobiPktCd == null ? "" : pt3ShinobiPktCd);
		builder.append(",");
		builder.append(pt3ShinobiPktNm == null ? "" : pt3ShinobiPktNm);
		builder.append(",");
		builder.append(pt3ShinobiPktWsWage == null ? "" : pt3ShinobiPktWsWage);
		builder.append(",");
		builder.append(pt3ShinobiPktWsPrice == null ? "" : pt3ShinobiPktWsPrice);
		builder.append(",");
		builder.append(pt3CoinPktCd == null ? "" : pt3CoinPktCd);
		builder.append(",");
		builder.append(pt3CoinPktNm == null ? "" : pt3CoinPktNm);
		builder.append(",");
		builder.append(pt3CoinPktWsWage == null ? "" : pt3CoinPktWsWage);
		builder.append(",");
		builder.append(pt3CoinPktWsPrice == null ? "" : pt3CoinPktWsPrice);
		builder.append(",");
		builder.append(pt3FlapcoinPktCd == null ? "" : pt3FlapcoinPktCd);
		builder.append(",");
		builder.append(pt3FlapcoinPktNm == null ? "" : pt3FlapcoinPktNm);
		builder.append(",");
		builder.append(pt3FlapcoinPktWsWage == null ? "" : pt3FlapcoinPktWsWage);
		builder.append(",");
		builder.append(pt3FlapcoinPktWsPrice == null ? "" : pt3FlapcoinPktWsPrice);
		builder.append(",");
		builder.append(pt3LeftPisPktCd == null ? "" : pt3LeftPisPktCd);
		builder.append(",");
		builder.append(pt3LeftPisPktNm == null ? "" : pt3LeftPisPktNm);
		builder.append(",");
		builder.append(pt3LeftPisPktWsWage == null ? "" : pt3LeftPisPktWsWage);
		builder.append(",");
		builder.append(pt3LeftPisPktWsPrice == null ? "" : pt3LeftPisPktWsPrice);
		builder.append(",");
		builder.append(pt3RightPisPktCd == null ? "" : pt3RightPisPktCd);
		builder.append(",");
		builder.append(pt3RightPisPktNm == null ? "" : pt3RightPisPktNm);
		builder.append(",");
		builder.append(pt3RightPisPktWsWage == null ? "" : pt3RightPisPktWsWage);
		builder.append(",");
		builder.append(pt3RightPisPktWsPrice == null ? "" : pt3RightPisPktWsPrice);
		builder.append(",");
		builder.append(pt3VCutCd == null ? "" : pt3VCutCd);
		builder.append(",");
		builder.append(pt3VCutNm == null ? "" : pt3VCutNm);
		builder.append(",");
		builder.append(pt3VCutWsWage == null ? "" : pt3VCutWsWage);
		builder.append(",");
		builder.append(pt3VCutWsPrice == null ? "" : pt3VCutWsPrice);
		builder.append(",");
		builder.append(pt3HemUpCd == null ? "" : pt3HemUpCd);
		builder.append(",");
		builder.append(pt3HemUpNm == null ? "" : pt3HemUpNm);
		builder.append(",");
		builder.append(pt3HemUpWsWage == null ? "" : pt3HemUpWsWage);
		builder.append(",");
		builder.append(pt3HemUpWsPrice == null ? "" : pt3HemUpWsPrice);
		builder.append(",");
		builder.append(pt3DblWidthCd == null ? "" : pt3DblWidthCd);
		builder.append(",");
		builder.append(pt3DblWidthNm == null ? "" : pt3DblWidthNm);
		builder.append(",");
		builder.append(pt3DblWidthWsWage == null ? "" : pt3DblWidthWsWage);
		builder.append(",");
		builder.append(pt3DblWidthWsPrice == null ? "" : pt3DblWidthWsPrice);
		builder.append(",");
		builder.append(pt3AmfStitchCd == null ? "" : pt3AmfStitchCd);
		builder.append(",");
		builder.append(pt3AmfStitchNm == null ? "" : pt3AmfStitchNm);
		builder.append(",");
		builder.append(pt3AmfStitchWsWage == null ? "" : pt3AmfStitchWsWage);
		builder.append(",");
		builder.append(pt3AmfStitchWsPrice == null ? "" : pt3AmfStitchWsPrice);
		builder.append(",");
		builder.append(pt3StitchPlcType == null ? "" : pt3StitchPlcType);
		builder.append(",");
		builder.append(pt3StitchPlcCd == null ? "" : pt3StitchPlcCd);
		builder.append(",");
		builder.append(pt3StitchPlcNm == null ? "" : pt3StitchPlcNm);
		builder.append(",");
		builder.append(pt3StitchPlcWsWage == null ? "" : pt3StitchPlcWsWage);
		builder.append(",");
		builder.append(pt3StitchPlcWsPrice == null ? "" : pt3StitchPlcWsPrice);
		builder.append(",");
		builder.append(pt3DblstitchPlcType == null ? "" : pt3DblstitchPlcType);
		builder.append(",");
		builder.append(pt3DblstitchPlcCd == null ? "" : pt3DblstitchPlcCd);
		builder.append(",");
		builder.append(pt3DblstitchPlcNm == null ? "" : pt3DblstitchPlcNm);
		builder.append(",");
		builder.append(pt3DblstitchPlcWsWage == null ? "" : pt3DblstitchPlcWsWage);
		builder.append(",");
		builder.append(pt3DblstitchPlcWsPrice == null ? "" : pt3DblstitchPlcWsPrice);
		builder.append(",");
		builder.append(pt3AmfColorType == null ? "" : pt3AmfColorType);
		builder.append(",");
		builder.append(pt3AmfColorPlcCd == null ? "" : pt3AmfColorPlcCd);
		builder.append(",");
		builder.append(pt3AmfColorPlcNm == null ? "" : pt3AmfColorPlcNm);
		builder.append(",");
		builder.append(pt3AmfColorCd == null ? "" : pt3AmfColorCd);
		builder.append(",");
		builder.append(pt3AmfColorNm == null ? "" : pt3AmfColorNm);
		builder.append(",");
		builder.append(pt3AmfColorWsWage == null ? "" : pt3AmfColorWsWage);
		builder.append(",");
		builder.append(pt3AmfColorWsPrice == null ? "" : pt3AmfColorWsPrice);
		builder.append(",");
		builder.append(pt3BtnholeColorType == null ? "" : pt3BtnholeColorType);
		builder.append(",");
		builder.append(pt3BtnholeColorPlcCd == null ? "" : pt3BtnholeColorPlcCd);
		builder.append(",");
		builder.append(pt3BtnholeColorPlcNm == null ? "" : pt3BtnholeColorPlcNm);
		builder.append(",");
		builder.append(pt3BtnholeColorCd == null ? "" : pt3BtnholeColorCd);
		builder.append(",");
		builder.append(pt3BtnholeColorNm == null ? "" : pt3BtnholeColorNm);
		builder.append(",");
		builder.append(pt3BtnholeColorWsWage == null ? "" : pt3BtnholeColorWsWage);
		builder.append(",");
		builder.append(pt3BtnholeColorWsPrice == null ? "" : pt3BtnholeColorWsPrice);
		builder.append(",");
		builder.append(pt3BtnthreadColorType == null ? "" : pt3BtnthreadColorType);
		builder.append(",");
		builder.append(pt3BtnthreadColorPlcCd == null ? "" : pt3BtnthreadColorPlcCd);
		builder.append(",");
		builder.append(pt3BtnthreadColorPlcNm == null ? "" : pt3BtnthreadColorPlcNm);
		builder.append(",");
		builder.append(pt3BtnthreadColorCd == null ? "" : pt3BtnthreadColorCd);
		builder.append(",");
		builder.append(pt3BtnthreadColorNm == null ? "" : pt3BtnthreadColorNm);
		builder.append(",");
		builder.append(pt3BtnthreadColorWsWage == null ? "" : pt3BtnthreadColorWsWage);
		builder.append(",");
		builder.append(pt3BtnthreadColorWsPrice == null ? "" : pt3BtnthreadColorWsPrice);
		builder.append(",");
		builder.append(pt3BtnMaterialType == null ? "" : pt3BtnMaterialType);
		builder.append(",");
		builder.append(pt3BtnMaterialCd == null ? "" : pt3BtnMaterialCd);
		builder.append(",");
		builder.append(pt3BtnMaterialNm == null ? "" : pt3BtnMaterialNm);
		builder.append(",");
		builder.append(pt3BtnMaterialWsWage == null ? "" : pt3BtnMaterialWsWage);
		builder.append(",");
		builder.append(pt3BtnMaterialWsPrice == null ? "" : pt3BtnMaterialWsPrice);
		builder.append(",");
		builder.append(pt3SuspenderBtnCd == null ? "" : pt3SuspenderBtnCd);
		builder.append(",");
		builder.append(pt3SuspenderBtnNm == null ? "" : pt3SuspenderBtnNm);
		builder.append(",");
		builder.append(pt3SuspenderBtnWsWage == null ? "" : pt3SuspenderBtnWsWage);
		builder.append(",");
		builder.append(pt3SuspenderBtnWsPrice == null ? "" : pt3SuspenderBtnWsPrice);
		builder.append(",");
		builder.append(pt3NonSlipCd == null ? "" : pt3NonSlipCd);
		builder.append(",");
		builder.append(pt3NonSlipNm == null ? "" : pt3NonSlipNm);
		builder.append(",");
		builder.append(pt3NonSlipWsWage == null ? "" : pt3NonSlipWsWage);
		builder.append(",");
		builder.append(pt3NonSlipWsPrice == null ? "" : pt3NonSlipWsPrice);
		builder.append(",");
		builder.append(pt3ChicSlipCd == null ? "" : pt3ChicSlipCd);
		builder.append(",");
		builder.append(pt3ChicSlipNm == null ? "" : pt3ChicSlipNm);
		builder.append(",");
		builder.append(pt3ChicSlipWsWage == null ? "" : pt3ChicSlipWsWage);
		builder.append(",");
		builder.append(pt3ChicSlipWsPrice == null ? "" : pt3ChicSlipWsPrice);
		builder.append(",");
		builder.append(pt3ShapeMemoryCd == null ? "" : pt3ShapeMemoryCd);
		builder.append(",");
		builder.append(pt3ShapeMemoryNm == null ? "" : pt3ShapeMemoryNm);
		builder.append(",");
		builder.append(pt3ShapeMemoryWsWage == null ? "" : pt3ShapeMemoryWsWage);
		builder.append(",");
		builder.append(pt3ShapeMemoryWsPrice == null ? "" : pt3ShapeMemoryWsPrice);
		builder.append(",");
		builder.append(pt3ShoeSoreCd == null ? "" : pt3ShoeSoreCd);
		builder.append(",");
		builder.append(pt3ShoeSoreNm == null ? "" : pt3ShoeSoreNm);
		builder.append(",");
		builder.append(pt3ShoeSoreWsWage == null ? "" : pt3ShoeSoreWsWage);
		builder.append(",");
		builder.append(pt3ShoeSoreWsPrice == null ? "" : pt3ShoeSoreWsPrice);
		builder.append(",");
		builder.append(pt3SideStripeCd == null ? "" : pt3SideStripeCd);
		builder.append(",");
		builder.append(pt3SideStripeNm == null ? "" : pt3SideStripeNm);
		builder.append(",");
		builder.append(pt3SideStripeWsWage == null ? "" : pt3SideStripeWsWage);
		builder.append(",");
		builder.append(pt3SideStripeWsPrice == null ? "" : pt3SideStripeWsPrice);
		builder.append(",");
		builder.append(pt3SideStripeWidthCd == null ? "" : pt3SideStripeWidthCd);
		builder.append(",");
		builder.append(pt3SideStripeWidthNm == null ? "" : pt3SideStripeWidthNm);
		builder.append(",");
		builder.append(pt3SideStripeWidthWsWage == null ? "" : pt3SideStripeWidthWsWage);
		builder.append(",");
		builder.append(pt3SideStripeWidthWsPrice == null ? "" : pt3SideStripeWidthWsPrice);
		builder.append(",");
		builder.append(glModelCd == null ? "" : glModelCd);
		builder.append(",");
		builder.append(glModelNm == null ? "" : glModelNm);
		builder.append(",");
		builder.append(glModelWsWage == null ? "" : glModelWsWage);
		builder.append(",");
		builder.append(glModelWsPrice == null ? "" : glModelWsPrice);
		builder.append(",");
		builder.append(glBreastPktCd == null ? "" : glBreastPktCd);
		builder.append(",");
		builder.append(glBreastPktNm == null ? "" : glBreastPktNm);
		builder.append(",");
		builder.append(glBreastPktWsWage == null ? "" : glBreastPktWsWage);
		builder.append(",");
		builder.append(glBreastPktWsPrice == null ? "" : glBreastPktWsPrice);
		builder.append(",");
		builder.append(glWaistPktCd == null ? "" : glWaistPktCd);
		builder.append(",");
		builder.append(glWaistPktNm == null ? "" : glWaistPktNm);
		builder.append(",");
		builder.append(glWaistPktWsWage == null ? "" : glWaistPktWsWage);
		builder.append(",");
		builder.append(glWaistPktWsPrice == null ? "" : glWaistPktWsPrice);
		builder.append(",");
		builder.append(glWaistPktShapeCd == null ? "" : glWaistPktShapeCd);
		builder.append(",");
		builder.append(glWaistPktShapeNm == null ? "" : glWaistPktShapeNm);
		builder.append(",");
		builder.append(glWaistPktShapeWsWage == null ? "" : glWaistPktShapeWsWage);
		builder.append(",");
		builder.append(glWaistPktShapeWsPrice == null ? "" : glWaistPktShapeWsPrice);
		builder.append(",");
		builder.append(glWaistPktClothCd == null ? "" : glWaistPktClothCd);
		builder.append(",");
		builder.append(glWaistPktClothNm == null ? "" : glWaistPktClothNm);
		builder.append(",");
		builder.append(glWaistPktClothWsWage == null ? "" : glWaistPktClothWsWage);
		builder.append(",");
		builder.append(glWaistPktClothWsPrice == null ? "" : glWaistPktClothWsPrice);
		builder.append(",");
		builder.append(glAmfStitchCd == null ? "" : glAmfStitchCd);
		builder.append(",");
		builder.append(glAmfStitchNm == null ? "" : glAmfStitchNm);
		builder.append(",");
		builder.append(glAmfStitchWsWage == null ? "" : glAmfStitchWsWage);
		builder.append(",");
		builder.append(glAmfStitchWsPrice == null ? "" : glAmfStitchWsPrice);
		builder.append(",");
		builder.append(glStitchPlcType == null ? "" : glStitchPlcType);
		builder.append(",");
		builder.append(glStitchPlcCd == null ? "" : glStitchPlcCd);
		builder.append(",");
		builder.append(glStitchPlcNm == null ? "" : glStitchPlcNm);
		builder.append(",");
		builder.append(glStitchPlcWsWage == null ? "" : glStitchPlcWsWage);
		builder.append(",");
		builder.append(glStitchPlcWsPrice == null ? "" : glStitchPlcWsPrice);
		builder.append(",");
		builder.append(glDblstitchPlcType == null ? "" : glDblstitchPlcType);
		builder.append(",");
		builder.append(glDblstitchPlcCd == null ? "" : glDblstitchPlcCd);
		builder.append(",");
		builder.append(glDblstitchPlcNm == null ? "" : glDblstitchPlcNm);
		builder.append(",");
		builder.append(glDblstitchPlcWsWage == null ? "" : glDblstitchPlcWsWage);
		builder.append(",");
		builder.append(glDblstitchPlcWsPrice == null ? "" : glDblstitchPlcWsPrice);
		builder.append(",");
		builder.append(glAmfColorType == null ? "" : glAmfColorType);
		builder.append(",");
		builder.append(glAmfColorPlcCd == null ? "" : glAmfColorPlcCd);
		builder.append(",");
		builder.append(glAmfColorPlcNm == null ? "" : glAmfColorPlcNm);
		builder.append(",");
		builder.append(glAmfColorCd == null ? "" : glAmfColorCd);
		builder.append(",");
		builder.append(glAmfColorNm == null ? "" : glAmfColorNm);
		builder.append(",");
		builder.append(glAmfColorWsWage == null ? "" : glAmfColorWsWage);
		builder.append(",");
		builder.append(glAmfColorWsPrice == null ? "" : glAmfColorWsPrice);
		builder.append(",");
		builder.append(glBtnholeColorType == null ? "" : glBtnholeColorType);
		builder.append(",");
		builder.append(glBtnholeColorPlcCd == null ? "" : glBtnholeColorPlcCd);
		builder.append(",");
		builder.append(glBtnholeColorPlcNm == null ? "" : glBtnholeColorPlcNm);
		builder.append(",");
		builder.append(glBtnholeColorCd == null ? "" : glBtnholeColorCd);
		builder.append(",");
		builder.append(glBtnholeColorNm == null ? "" : glBtnholeColorNm);
		builder.append(",");
		builder.append(glBtnholeColorWsWage == null ? "" : glBtnholeColorWsWage);
		builder.append(",");
		builder.append(glBtnholeColorWsPrice == null ? "" : glBtnholeColorWsPrice);
		builder.append(",");
		builder.append(glBtnthreadColorType == null ? "" : glBtnthreadColorType);
		builder.append(",");
		builder.append(glBtnthreadColorPlcCd == null ? "" : glBtnthreadColorPlcCd);
		builder.append(",");
		builder.append(glBtnthreadColorPlcNm == null ? "" : glBtnthreadColorPlcNm);
		builder.append(",");
		builder.append(glBtnthreadColorCd == null ? "" : glBtnthreadColorCd);
		builder.append(",");
		builder.append(glBtnthreadColorNm == null ? "" : glBtnthreadColorNm);
		builder.append(",");
		builder.append(glBtnthreadColorWsWage == null ? "" : glBtnthreadColorWsWage);
		builder.append(",");
		builder.append(glBtnthreadColorWsPrice == null ? "" : glBtnthreadColorWsPrice);
		builder.append(",");
		builder.append(glBackClothType == null ? "" : glBackClothType);
		builder.append(",");
		builder.append(glBackClothCd == null ? "" : glBackClothCd);
		builder.append(",");
		builder.append(glBackClothNm == null ? "" : glBackClothNm);
		builder.append(",");
		builder.append(glBackClothWsWage == null ? "" : glBackClothWsWage);
		builder.append(",");
		builder.append(glBackClothWsPrice == null ? "" : glBackClothWsPrice);
		builder.append(",");
		builder.append(glInnnerClothType == null ? "" : glInnnerClothType);
		builder.append(",");
		builder.append(glInnnerClothCd == null ? "" : glInnnerClothCd);
		builder.append(",");
		builder.append(glInnnerClothNm == null ? "" : glInnnerClothNm);
		builder.append(",");
		builder.append(glInnnerClothWsWage == null ? "" : glInnnerClothWsWage);
		builder.append(",");
		builder.append(glInnnerClothWsPrice == null ? "" : glInnnerClothWsPrice);
		builder.append(",");
		builder.append(glFrtBtnType == null ? "" : glFrtBtnType);
		builder.append(",");
		builder.append(glFrtBtnCd == null ? "" : glFrtBtnCd);
		builder.append(",");
		builder.append(glFrtBtnNm == null ? "" : glFrtBtnNm);
		builder.append(",");
		builder.append(glFrtBtnWsWage == null ? "" : glFrtBtnWsWage);
		builder.append(",");
		builder.append(glFrtBtnWsPrice == null ? "" : glFrtBtnWsPrice);
		builder.append(",");
		builder.append(glBackBeltCd == null ? "" : glBackBeltCd);
		builder.append(",");
		builder.append(glBackBeltNm == null ? "" : glBackBeltNm);
		builder.append(",");
		builder.append(glBackBeltWsWage == null ? "" : glBackBeltWsWage);
		builder.append(",");
		builder.append(glBackBeltWsPrice == null ? "" : glBackBeltWsPrice);
		builder.append(",");
		builder.append(glWatchChainCd == null ? "" : glWatchChainCd);
		builder.append(",");
		builder.append(glWatchChainNm == null ? "" : glWatchChainNm);
		builder.append(",");
		builder.append(glWatchChainWsWage == null ? "" : glWatchChainWsWage);
		builder.append(",");
		builder.append(glWatchChainWsPrice == null ? "" : glWatchChainWsPrice);
		builder.append(",");
		builder.append(ctModelCd == null ? "" : ctModelCd);
		builder.append(",");
		builder.append(ctModelNm == null ? "" : ctModelNm);
		builder.append(",");
		builder.append(ctModelWsWage == null ? "" : ctModelWsWage);
		builder.append(",");
		builder.append(ctModelWsPrice == null ? "" : ctModelWsPrice);
		builder.append(",");
		builder.append(ctLapelDesignCd == null ? "" : ctLapelDesignCd);
		builder.append(",");
		builder.append(ctLapelDesignNm == null ? "" : ctLapelDesignNm);
		builder.append(",");
		builder.append(ctLapelDesignWsWage == null ? "" : ctLapelDesignWsWage);
		builder.append(",");
		builder.append(ctLapelDesignWsPrice == null ? "" : ctLapelDesignWsPrice);
		builder.append(",");
		builder.append(ctSleeveTypeCd == null ? "" : ctSleeveTypeCd);
		builder.append(",");
		builder.append(ctSleeveTypeNm == null ? "" : ctSleeveTypeNm);
		builder.append(",");
		builder.append(ctSleeveTypeWsWage == null ? "" : ctSleeveTypeWsWage);
		builder.append(",");
		builder.append(ctSleeveTypeWsPrice == null ? "" : ctSleeveTypeWsPrice);
		builder.append(",");
		builder.append(ctWaistPktCd == null ? "" : ctWaistPktCd);
		builder.append(",");
		builder.append(ctWaistPktNm == null ? "" : ctWaistPktNm);
		builder.append(",");
		builder.append(ctWaistPktWsWage == null ? "" : ctWaistPktWsWage);
		builder.append(",");
		builder.append(ctWaistPktWsPrice == null ? "" : ctWaistPktWsPrice);
		builder.append(",");
		builder.append(ctChgPktCd == null ? "" : ctChgPktCd);
		builder.append(",");
		builder.append(ctChgPktNm == null ? "" : ctChgPktNm);
		builder.append(",");
		builder.append(ctChgPktWsWage == null ? "" : ctChgPktWsWage);
		builder.append(",");
		builder.append(ctChgPktWsPrice == null ? "" : ctChgPktWsPrice);
		builder.append(",");
		builder.append(ctSlantedPktCd == null ? "" : ctSlantedPktCd);
		builder.append(",");
		builder.append(ctSlantedPktNm == null ? "" : ctSlantedPktNm);
		builder.append(",");
		builder.append(ctSlantedPktWsWage == null ? "" : ctSlantedPktWsWage);
		builder.append(",");
		builder.append(ctSlantedPktWsPrice == null ? "" : ctSlantedPktWsPrice);
		builder.append(",");
		builder.append(ctVentCd == null ? "" : ctVentCd);
		builder.append(",");
		builder.append(ctVentNm == null ? "" : ctVentNm);
		builder.append(",");
		builder.append(ctVentWsWage == null ? "" : ctVentWsWage);
		builder.append(",");
		builder.append(ctVentWsPrice == null ? "" : ctVentWsPrice);
		builder.append(",");
		builder.append(ctFrtBtnCd == null ? "" : ctFrtBtnCd);
		builder.append(",");
		builder.append(ctFrtBtnNm == null ? "" : ctFrtBtnNm);
		builder.append(",");
		builder.append(ctFrtBtnWsWage == null ? "" : ctFrtBtnWsWage);
		builder.append(",");
		builder.append(ctFrtBtnWsPrice == null ? "" : ctFrtBtnWsPrice);
		builder.append(",");
		builder.append(ctCuffCd == null ? "" : ctCuffCd);
		builder.append(",");
		builder.append(ctCuffNm == null ? "" : ctCuffNm);
		builder.append(",");
		builder.append(ctCuffWsWage == null ? "" : ctCuffWsWage);
		builder.append(",");
		builder.append(ctCuffWsPrice == null ? "" : ctCuffWsPrice);
		builder.append(",");
		builder.append(ctSleeveBtnCd == null ? "" : ctSleeveBtnCd);
		builder.append(",");
		builder.append(ctSleeveBtnNm == null ? "" : ctSleeveBtnNm);
		builder.append(",");
		builder.append(ctSleeveBtnWsWage == null ? "" : ctSleeveBtnWsWage);
		builder.append(",");
		builder.append(ctSleeveBtnWsPrice == null ? "" : ctSleeveBtnWsPrice);
		builder.append(",");
		builder.append(ctBackBeltCd == null ? "" : ctBackBeltCd);
		builder.append(",");
		builder.append(ctBackBeltNm == null ? "" : ctBackBeltNm);
		builder.append(",");
		builder.append(ctBackBeltWsWage == null ? "" : ctBackBeltWsWage);
		builder.append(",");
		builder.append(ctBackBeltWsPrice == null ? "" : ctBackBeltWsPrice);
		builder.append(",");
		builder.append(ctCollarHangCd == null ? "" : ctCollarHangCd);
		builder.append(",");
		builder.append(ctCollarHangNm == null ? "" : ctCollarHangNm);
		builder.append(",");
		builder.append(ctCollarHangWsWage == null ? "" : ctCollarHangWsWage);
		builder.append(",");
		builder.append(ctCollarHangWsPrice == null ? "" : ctCollarHangWsPrice);
		builder.append(",");
		builder.append(ctInnerBodyClothCd == null ? "" : ctInnerBodyClothCd);
		builder.append(",");
		builder.append(ctInnerBodyClothNm == null ? "" : ctInnerBodyClothNm);
		builder.append(",");
		builder.append(ctInnerBodyClothWsWage == null ? "" : ctInnerBodyClothWsWage);
		builder.append(",");
		builder.append(ctInnerBodyClothWsPrice == null ? "" : ctInnerBodyClothWsPrice);
		builder.append(",");
		builder.append(ctInnerSleeveClothCd == null ? "" : ctInnerSleeveClothCd);
		builder.append(",");
		builder.append(ctInnerSleeveClothNm == null ? "" : ctInnerSleeveClothNm);
		builder.append(",");
		builder.append(ctInnerSleeveClothWsWage == null ? "" : ctInnerSleeveClothWsWage);
		builder.append(",");
		builder.append(ctInnerSleeveClothWsPrice == null ? "" : ctInnerSleeveClothWsPrice);
		builder.append(",");
		builder.append(ctBtnMaterialCd == null ? "" : ctBtnMaterialCd);
		builder.append(",");
		builder.append(ctBtnMaterialNm == null ? "" : ctBtnMaterialNm);
		builder.append(",");
		builder.append(ctBtnMaterialWsWage == null ? "" : ctBtnMaterialWsWage);
		builder.append(",");
		builder.append(ctBtnMaterialWsPrice == null ? "" : ctBtnMaterialWsPrice);
		builder.append(",");
		builder.append(stModelCd == null ? "" : stModelCd);
		builder.append(",");
		builder.append(stModelNm == null ? "" : stModelNm);
		builder.append(",");
		builder.append(stModelWsWage == null ? "" : stModelWsWage);
		builder.append(",");
		builder.append(stModelWsPrice == null ? "" : stModelWsPrice);
		builder.append(",");
		builder.append(stCasualHemlineCd == null ? "" : stCasualHemlineCd);
		builder.append(",");
		builder.append(stCasualHemlineSize == null ? "" : stCasualHemlineSize);
		builder.append(",");
		builder.append(stCasualHemlineNm == null ? "" : stCasualHemlineNm);
		builder.append(",");
		builder.append(stCasualHemlineWsWage == null ? "" : stCasualHemlineWsWage);
		builder.append(",");
		builder.append(stCasualHemlineWsPrice == null ? "" : stCasualHemlineWsPrice);
		builder.append(",");
		builder.append(stCollarTypeCd == null ? "" : stCollarTypeCd);
		builder.append(",");
		builder.append(stCollarTypeNm == null ? "" : stCollarTypeNm);
		builder.append(",");
		builder.append(stCollarTypeWsWage == null ? "" : stCollarTypeWsWage);
		builder.append(",");
		builder.append(stCollarTypeWsPrice == null ? "" : stCollarTypeWsPrice);
		builder.append(",");
		builder.append(stCuffsCd == null ? "" : stCuffsCd);
		builder.append(",");
		builder.append(stCuffsNm == null ? "" : stCuffsNm);
		builder.append(",");
		builder.append(stCuffsWsWage == null ? "" : stCuffsWsWage);
		builder.append(",");
		builder.append(stCuffsWsPrice == null ? "" : stCuffsWsPrice);
		builder.append(",");
		builder.append(stConvertibleCd == null ? "" : stConvertibleCd);
		builder.append(",");
		builder.append(stConvertibleNm == null ? "" : stConvertibleNm);
		builder.append(",");
		builder.append(stConvertibleWsWage == null ? "" : stConvertibleWsWage);
		builder.append(",");
		builder.append(stConvertibleWsPrice == null ? "" : stConvertibleWsPrice);
		builder.append(",");
		builder.append(stAdjusterBtnCd == null ? "" : stAdjusterBtnCd);
		builder.append(",");
		builder.append(stAdjusterBtnNm == null ? "" : stAdjusterBtnNm);
		builder.append(",");
		builder.append(stAdjusterBtnWsWage == null ? "" : stAdjusterBtnWsWage);
		builder.append(",");
		builder.append(stAdjusterBtnWsPrice == null ? "" : stAdjusterBtnWsPrice);
		builder.append(",");
		builder.append(stDblCuffsCd == null ? "" : stDblCuffsCd);
		builder.append(",");
		builder.append(stDblCuffsNm == null ? "" : stDblCuffsNm);
		builder.append(",");
		builder.append(stDblCuffsWsWage == null ? "" : stDblCuffsWsWage);
		builder.append(",");
		builder.append(stDblCuffsWsPrice == null ? "" : stDblCuffsWsPrice);
		builder.append(",");
		builder.append(stClericCd == null ? "" : stClericCd);
		builder.append(",");
		builder.append(stClericNm == null ? "" : stClericNm);
		builder.append(",");
		builder.append(stClericWsWage == null ? "" : stClericWsWage);
		builder.append(",");
		builder.append(stClericWsPrice == null ? "" : stClericWsPrice);
		builder.append(",");
		builder.append(stCuffsBtnCd == null ? "" : stCuffsBtnCd);
		builder.append(",");
		builder.append(stCuffsBtnNm == null ? "" : stCuffsBtnNm);
		builder.append(",");
		builder.append(stCuffsBtnWsWage == null ? "" : stCuffsBtnWsWage);
		builder.append(",");
		builder.append(stCuffsBtnWsPrice == null ? "" : stCuffsBtnWsPrice);
		builder.append(",");
		builder.append(stSleeveClericcd == null ? "" : stSleeveClericcd);
		builder.append(",");
		builder.append(stSleeveClericnm == null ? "" : stSleeveClericnm);
		builder.append(",");
		builder.append(stSleeveClericwsWage == null ? "" : stSleeveClericwsWage);
		builder.append(",");
		builder.append(stSleeveClericwsPrice == null ? "" : stSleeveClericwsPrice);
		builder.append(",");
		builder.append(stBtnMaterialCd == null ? "" : stBtnMaterialCd);
		builder.append(",");
		builder.append(stBtnMaterialNm == null ? "" : stBtnMaterialNm);
		builder.append(",");
		builder.append(stBtnMaterialWsWage == null ? "" : stBtnMaterialWsWage);
		builder.append(",");
		builder.append(stBtnMaterialWsPrice == null ? "" : stBtnMaterialWsPrice);
		builder.append(",");
		builder.append(stDblBtnCd == null ? "" : stDblBtnCd);
		builder.append(",");
		builder.append(stDblBtnNm == null ? "" : stDblBtnNm);
		builder.append(",");
		builder.append(stDblBtnWsWage == null ? "" : stDblBtnWsWage);
		builder.append(",");
		builder.append(stDblBtnWsPrice == null ? "" : stDblBtnWsPrice);
		builder.append(",");
		builder.append(stGauntletBtnPosCd == null ? "" : stGauntletBtnPosCd);
		builder.append(",");
		builder.append(stGauntletBtnPosNm == null ? "" : stGauntletBtnPosNm);
		builder.append(",");
		builder.append(stGauntletBtnPosWsWage == null ? "" : stGauntletBtnPosWsWage);
		builder.append(",");
		builder.append(stGauntletBtnPosWsPrice == null ? "" : stGauntletBtnPosWsPrice);
		builder.append(",");
		builder.append(stPinholePinCd == null ? "" : stPinholePinCd);
		builder.append(",");
		builder.append(stPinholePinNm == null ? "" : stPinholePinNm);
		builder.append(",");
		builder.append(stPinholePinWsWage == null ? "" : stPinholePinWsWage);
		builder.append(",");
		builder.append(stPinholePinWsPrice == null ? "" : stPinholePinWsPrice);
		builder.append(",");
		builder.append(stBreastPktCd == null ? "" : stBreastPktCd);
		builder.append(",");
		builder.append(stBreastPktNm == null ? "" : stBreastPktNm);
		builder.append(",");
		builder.append(stBreastPktWsWage == null ? "" : stBreastPktWsWage);
		builder.append(",");
		builder.append(stBreastPktWsPrice == null ? "" : stBreastPktWsPrice);
		builder.append(",");
		builder.append(stBreastSizeCd == null ? "" : stBreastSizeCd);
		builder.append(",");
		builder.append(stBreastSizeNm == null ? "" : stBreastSizeNm);
		builder.append(",");
		builder.append(stBreastSizeWsWage == null ? "" : stBreastSizeWsWage);
		builder.append(",");
		builder.append(stBreastSizeWsPrice == null ? "" : stBreastSizeWsPrice);
		builder.append(",");
		builder.append(stFrtDesignCd == null ? "" : stFrtDesignCd);
		builder.append(",");
		builder.append(stFrtDesignNm == null ? "" : stFrtDesignNm);
		builder.append(",");
		builder.append(stFrtDesignWsWage == null ? "" : stFrtDesignWsWage);
		builder.append(",");
		builder.append(stFrtDesignWsPrice == null ? "" : stFrtDesignWsPrice);
		builder.append(",");
		builder.append(stPintuckBosomCd == null ? "" : stPintuckBosomCd);
		builder.append(",");
		builder.append(stPintuckBosomNm == null ? "" : stPintuckBosomNm);
		builder.append(",");
		builder.append(stPintuckBosomWsWage == null ? "" : stPintuckBosomWsWage);
		builder.append(",");
		builder.append(stPintuckBosomWsPrice == null ? "" : stPintuckBosomWsPrice);
		builder.append(",");
		builder.append(stStitchCd == null ? "" : stStitchCd);
		builder.append(",");
		builder.append(stStitchNm == null ? "" : stStitchNm);
		builder.append(",");
		builder.append(stStitchWsWage == null ? "" : stStitchWsWage);
		builder.append(",");
		builder.append(stStitchWsPrice == null ? "" : stStitchWsPrice);
		builder.append(",");
		builder.append(stColarKeeperCd == null ? "" : stColarKeeperCd);
		builder.append(",");
		builder.append(stColarKeeperNm == null ? "" : stColarKeeperNm);
		builder.append(",");
		builder.append(stColarKeeperWsWage == null ? "" : stColarKeeperWsWage);
		builder.append(",");
		builder.append(stColarKeeperWsPrice == null ? "" : stColarKeeperWsPrice);
		builder.append(",");
		builder.append(stBtnthreadColorCd == null ? "" : stBtnthreadColorCd);
		builder.append(",");
		builder.append(stBtnthreadColorNm == null ? "" : stBtnthreadColorNm);
		builder.append(",");
		builder.append(stBtnthreadColorWsWage == null ? "" : stBtnthreadColorWsWage);
		builder.append(",");
		builder.append(stBtnthreadColorWsPrice == null ? "" : stBtnthreadColorWsPrice);
		builder.append(",");
		builder.append(stBtnholeColorCd == null ? "" : stBtnholeColorCd);
		builder.append(",");
		builder.append(stBtnholeColorNm == null ? "" : stBtnholeColorNm);
		builder.append(",");
		builder.append(stBtnholeColorWsWage == null ? "" : stBtnholeColorWsWage);
		builder.append(",");
		builder.append(stBtnholeColorWsPrice == null ? "" : stBtnholeColorWsPrice);
		builder.append(",");
		builder.append(stBtnposChgCd == null ? "" : stBtnposChgCd);
		builder.append(",");
		builder.append(stBtnposChgNm == null ? "" : stBtnposChgNm);
		builder.append(",");
		builder.append(stBtnposChgWsWage == null ? "" : stBtnposChgWsWage);
		builder.append(",");
		builder.append(stBtnposChgWsPrice == null ? "" : stBtnposChgWsPrice);
		builder.append(",");
		builder.append(stNeckbandBtnChgCd == null ? "" : stNeckbandBtnChgCd);
		builder.append(",");
		builder.append(stNeckbandBtnChgNm == null ? "" : stNeckbandBtnChgNm);
		builder.append(",");
		builder.append(stNeckbandBtnChgWsWage == null ? "" : stNeckbandBtnChgWsWage);
		builder.append(",");
		builder.append(stNeckbandBtnChgWsPrice == null ? "" : stNeckbandBtnChgWsPrice);
		builder.append(",");
		builder.append(stNeckbandBtnPosChg == null ? "" : stNeckbandBtnPosChg);
		builder.append(",");
		builder.append(stFrtfirstBtnChgCd == null ? "" : stFrtfirstBtnChgCd);
		builder.append(",");
		builder.append(stFrtfirstBtnChgNm == null ? "" : stFrtfirstBtnChgNm);
		builder.append(",");
		builder.append(stFrtfirstBtnChgWsWage == null ? "" : stFrtfirstBtnChgWsWage);
		builder.append(",");
		builder.append(stFrtfirstBtnChgWsPrice == null ? "" : stFrtfirstBtnChgWsPrice);
		builder.append(",");
		builder.append(stFrtfirstBtnPosChg == null ? "" : stFrtfirstBtnPosChg);
		builder.append(",");
		builder.append(stFrtsecondBtnChgCd == null ? "" : stFrtsecondBtnChgCd);
		builder.append(",");
		builder.append(stFrtsecondBtnChgNm == null ? "" : stFrtsecondBtnChgNm);
		builder.append(",");
		builder.append(stFrtsecondBtnChgWsWage == null ? "" : stFrtsecondBtnChgWsWage);
		builder.append(",");
		builder.append(stFrtsecondBtnChgWsPrice == null ? "" : stFrtsecondBtnChgWsPrice);
		builder.append(",");
		builder.append(stFrtsecondBtnPosChg == null ? "" : stFrtsecondBtnPosChg);
		builder.append(",");
		builder.append(corJkDrop == null ? "" : corJkDrop);
		builder.append(",");
		builder.append(corJkSize == null ? "" : corJkSize);
		builder.append(",");
		builder.append(corJkBodylengthSize == null ? "" : corJkBodylengthSize);
		builder.append(",");
		builder.append(corJkBodylengthCorrect == null ? "" : corJkBodylengthCorrect);
		builder.append(",");
		builder.append(corJkBodylengthGross == null ? "" : corJkBodylengthGross);
		builder.append(",");
		builder.append(corJkWaistSize == null ? "" : corJkWaistSize);
		builder.append(",");
		builder.append(corJkWaistCorrect == null ? "" : corJkWaistCorrect);
		builder.append(",");
		builder.append(corJkWaistGross == null ? "" : corJkWaistGross);
		builder.append(",");
		builder.append(corJkRightsleeveSize == null ? "" : corJkRightsleeveSize);
		builder.append(",");
		builder.append(corJkRightsleeveCorrect == null ? "" : corJkRightsleeveCorrect);
		builder.append(",");
		builder.append(corJkRightsleeveGross == null ? "" : corJkRightsleeveGross);
		builder.append(",");
		builder.append(corJkLeftsleeveSize == null ? "" : corJkLeftsleeveSize);
		builder.append(",");
		builder.append(corJkLeftsleeveCorrect == null ? "" : corJkLeftsleeveCorrect);
		builder.append(",");
		builder.append(corJkLeftsleeveGross == null ? "" : corJkLeftsleeveGross);
		builder.append(",");
		builder.append(corJkShoulderpad == null ? "" : corJkShoulderpad);
		builder.append(",");
		builder.append(corJkFigureCorrect == null ? "" : corJkFigureCorrect);
		builder.append(",");
		builder.append(corPtDrop == null ? "" : corPtDrop);
		builder.append(",");
		builder.append(corPtSize == null ? "" : corPtSize);
		builder.append(",");
		builder.append(corPtWaistSize == null ? "" : corPtWaistSize);
		builder.append(",");
		builder.append(corPtWaistCorrect == null ? "" : corPtWaistCorrect);
		builder.append(",");
		builder.append(corPtWaistGross == null ? "" : corPtWaistGross);
		builder.append(",");
		builder.append(corPtHipSize == null ? "" : corPtHipSize);
		builder.append(",");
		builder.append(corPtHipCorrect == null ? "" : corPtHipCorrect);
		builder.append(",");
		builder.append(corPtHipGross == null ? "" : corPtHipGross);
		builder.append(",");
		builder.append(corPtThighwidthSize == null ? "" : corPtThighwidthSize);
		builder.append(",");
		builder.append(corPtThighwidthCorrect == null ? "" : corPtThighwidthCorrect);
		builder.append(",");
		builder.append(corPtThighwidthGross == null ? "" : corPtThighwidthGross);
		builder.append(",");
		builder.append(corPtHemwidthType == null ? "" : corPtHemwidthType);
		builder.append(",");
		builder.append(corPtHemwidthSize == null ? "" : corPtHemwidthSize);
		builder.append(",");
		builder.append(corPtHemwidthCorrect == null ? "" : corPtHemwidthCorrect);
		builder.append(",");
		builder.append(corPtHemwidthGross == null ? "" : corPtHemwidthGross);
		builder.append(",");
		builder.append(corPtHemwidthDegignate == null ? "" : corPtHemwidthDegignate);
		builder.append(",");
		builder.append(corPtRightinseamSize == null ? "" : corPtRightinseamSize);
		builder.append(",");
		builder.append(corPtRightinseamCorrect == null ? "" : corPtRightinseamCorrect);
		builder.append(",");
		builder.append(corPtRightinseamGross == null ? "" : corPtRightinseamGross);
		builder.append(",");
		builder.append(corPtLeftinseamSize == null ? "" : corPtLeftinseamSize);
		builder.append(",");
		builder.append(corPtLeftinseamCorrect == null ? "" : corPtLeftinseamCorrect);
		builder.append(",");
		builder.append(corPtLeftinseamGross == null ? "" : corPtLeftinseamGross);
		builder.append(",");
		builder.append(corPt2Drop == null ? "" : corPt2Drop);
		builder.append(",");
		builder.append(corPt2Size == null ? "" : corPt2Size);
		builder.append(",");
		builder.append(corPt2WaistSize == null ? "" : corPt2WaistSize);
		builder.append(",");
		builder.append(corPt2WaistCorrect == null ? "" : corPt2WaistCorrect);
		builder.append(",");
		builder.append(corPt2WaistGross == null ? "" : corPt2WaistGross);
		builder.append(",");
		builder.append(corPt2HipSize == null ? "" : corPt2HipSize);
		builder.append(",");
		builder.append(corPt2HipCorrect == null ? "" : corPt2HipCorrect);
		builder.append(",");
		builder.append(corPt2HipGross == null ? "" : corPt2HipGross);
		builder.append(",");
		builder.append(corPt2ThighwidthSize == null ? "" : corPt2ThighwidthSize);
		builder.append(",");
		builder.append(corPt2ThighwidthCorrect == null ? "" : corPt2ThighwidthCorrect);
		builder.append(",");
		builder.append(corPt2ThighwidthGross == null ? "" : corPt2ThighwidthGross);
		builder.append(",");
		builder.append(corPt2HemwidthType == null ? "" : corPt2HemwidthType);
		builder.append(",");
		builder.append(corPt2HemwidthSize == null ? "" : corPt2HemwidthSize);
		builder.append(",");
		builder.append(corPt2HemwidthCorrect == null ? "" : corPt2HemwidthCorrect);
		builder.append(",");
		builder.append(corPt2HemwidthGross == null ? "" : corPt2HemwidthGross);
		builder.append(",");
		builder.append(corPt2HemwidthDegignate == null ? "" : corPt2HemwidthDegignate);
		builder.append(",");
		builder.append(corPt2RightinseamSize == null ? "" : corPt2RightinseamSize);
		builder.append(",");
		builder.append(corPt2RightinseamCorrect == null ? "" : corPt2RightinseamCorrect);
		builder.append(",");
		builder.append(corPt2RightinseamGross == null ? "" : corPt2RightinseamGross);
		builder.append(",");
		builder.append(corPt2LeftinseamSize == null ? "" : corPt2LeftinseamSize);
		builder.append(",");
		builder.append(corPt2LeftinseamCorrect == null ? "" : corPt2LeftinseamCorrect);
		builder.append(",");
		builder.append(corPt2LeftinseamGross == null ? "" : corPt2LeftinseamGross);
		builder.append(",");
		builder.append(corGlDrop == null ? "" : corGlDrop);
		builder.append(",");
		builder.append(corGlSize == null ? "" : corGlSize);
		builder.append(",");
		builder.append(corGlBodylengthSize == null ? "" : corGlBodylengthSize);
		builder.append(",");
		builder.append(corGlBodylengthCorrect == null ? "" : corGlBodylengthCorrect);
		builder.append(",");
		builder.append(corGlBodylengthGross == null ? "" : corGlBodylengthGross);
		builder.append(",");
		builder.append(corGlBustSize == null ? "" : corGlBustSize);
		builder.append(",");
		builder.append(corGlBustCorrect == null ? "" : corGlBustCorrect);
		builder.append(",");
		builder.append(corGlBustGross == null ? "" : corGlBustGross);
		builder.append(",");
		builder.append(corGlWaistSize == null ? "" : corGlWaistSize);
		builder.append(",");
		builder.append(corGlWaistCorrect == null ? "" : corGlWaistCorrect);
		builder.append(",");
		builder.append(corGlWaistGross == null ? "" : corGlWaistGross);
		builder.append(",");
		builder.append(corCtSize == null ? "" : corCtSize);
		builder.append(",");
		builder.append(corCtBodylengthSize == null ? "" : corCtBodylengthSize);
		builder.append(",");
		builder.append(corCtBodylengthCorrect == null ? "" : corCtBodylengthCorrect);
		builder.append(",");
		builder.append(corCtBodylengthGross == null ? "" : corCtBodylengthGross);
		builder.append(",");
		builder.append(corCtWaistSize == null ? "" : corCtWaistSize);
		builder.append(",");
		builder.append(corCtWaistCorrect == null ? "" : corCtWaistCorrect);
		builder.append(",");
		builder.append(corCtWaistGross == null ? "" : corCtWaistGross);
		builder.append(",");
		builder.append(corCtRightsleeveSize == null ? "" : corCtRightsleeveSize);
		builder.append(",");
		builder.append(corCtRightsleeveCorrect == null ? "" : corCtRightsleeveCorrect);
		builder.append(",");
		builder.append(corCtRightsleeveGross == null ? "" : corCtRightsleeveGross);
		builder.append(",");
		builder.append(corCtLeftsleeveSize == null ? "" : corCtLeftsleeveSize);
		builder.append(",");
		builder.append(corCtLeftsleeveCorrect == null ? "" : corCtLeftsleeveCorrect);
		builder.append(",");
		builder.append(corCtLeftsleeveGross == null ? "" : corCtLeftsleeveGross);
		builder.append(",");
		builder.append(corCtVenthightSize == null ? "" : corCtVenthightSize);
		builder.append(",");
		builder.append(corCtVenthightCorrect == null ? "" : corCtVenthightCorrect);
		builder.append(",");
		builder.append(corCtVenthightGross == null ? "" : corCtVenthightGross);
		builder.append(",");
		builder.append(corCtPktposSize == null ? "" : corCtPktposSize);
		builder.append(",");
		builder.append(corCtPktposCorrect == null ? "" : corCtPktposCorrect);
		builder.append(",");
		builder.append(corCtPktposGross == null ? "" : corCtPktposGross);
		builder.append(",");
		builder.append(corStSize == null ? "" : corStSize);
		builder.append(",");
		builder.append(corStNeckSize == null ? "" : corStNeckSize);
		builder.append(",");
		builder.append(corStNeckCorrect == null ? "" : corStNeckCorrect);
		builder.append(",");
		builder.append(corStNeckGross == null ? "" : corStNeckGross);
		builder.append(",");
		builder.append(corStBodylengthSize == null ? "" : corStBodylengthSize);
		builder.append(",");
		builder.append(corStBodylengthCorrect == null ? "" : corStBodylengthCorrect);
		builder.append(",");
		builder.append(corStBodylengthGross == null ? "" : corStBodylengthGross);
		builder.append(",");
		builder.append(corStRightsleeveSize == null ? "" : corStRightsleeveSize);
		builder.append(",");
		builder.append(corStRightsleeveCorrect == null ? "" : corStRightsleeveCorrect);
		builder.append(",");
		builder.append(corStRightsleeveGross == null ? "" : corStRightsleeveGross);
		builder.append(",");
		builder.append(corStLeftsleeveSize == null ? "" : corStLeftsleeveSize);
		builder.append(",");
		builder.append(corStLeftsleeveCorrect == null ? "" : corStLeftsleeveCorrect);
		builder.append(",");
		builder.append(corStLeftsleeveGross == null ? "" : corStLeftsleeveGross);
		builder.append(",");
		builder.append(corStBackdartsPackSize == null ? "" : corStBackdartsPackSize);
		builder.append(",");
		builder.append(corStBackdartsPackCorrect == null ? "" : corStBackdartsPackCorrect);
		builder.append(",");
		builder.append(corStBackdartsPackGross == null ? "" : corStBackdartsPackGross);
		builder.append(",");
		builder.append(corStBackdartsUnpackSize == null ? "" : corStBackdartsUnpackSize);
		builder.append(",");
		builder.append(corStBackdartsUnpackCorrect == null ? "" : corStBackdartsUnpackCorrect);
		builder.append(",");
		builder.append(corStBackdartsUnpackGross == null ? "" : corStBackdartsUnpackGross);
		builder.append(",");
		builder.append(corStRightcuffsSurroundingSize == null ? "" : corStRightcuffsSurroundingSize);
		builder.append(",");
		builder.append(corStRightcuffsSurroundingCorrect == null ? "" : corStRightcuffsSurroundingCorrect);
		builder.append(",");
		builder.append(corStRightcuffsSurroundingGross == null ? "" : corStRightcuffsSurroundingGross);
		builder.append(",");
		builder.append(corStLeftcuffsSurroundingSize == null ? "" : corStLeftcuffsSurroundingSize);
		builder.append(",");
		builder.append(corStLeftcuffsSurroundingCorrect == null ? "" : corStLeftcuffsSurroundingCorrect);
		builder.append(",");
		builder.append(corStLeftcuffsSurroundingGross == null ? "" : corStLeftcuffsSurroundingGross);
		builder.append(",");
		builder.append(corStoreCorrectionMemo == null ? "" : corStoreCorrectionMemo);
		builder.append(",");
		builder.append(corJkBodylengthCorrectAgain == null ? "" : corJkBodylengthCorrectAgain);
		builder.append(",");
		builder.append(corJkWaistCorrectAgain == null ? "" : corJkWaistCorrectAgain);
		builder.append(",");
		builder.append(corJkRightsleeveCorrectAgain == null ? "" : corJkRightsleeveCorrectAgain);
		builder.append(",");
		builder.append(corJkLeftsleeveCorrectAgain == null ? "" : corJkLeftsleeveCorrectAgain);
		builder.append(",");
		builder.append(corGlBodylengthCorrectAgain == null ? "" : corGlBodylengthCorrectAgain);
		builder.append(",");
		builder.append(corGlBustCorrectAgain == null ? "" : corGlBustCorrectAgain);
		builder.append(",");
		builder.append(corGlWaistCorrectAgain == null ? "" : corGlWaistCorrectAgain);
		builder.append(",");
		builder.append(corPtWaistCorrectAgain == null ? "" : corPtWaistCorrectAgain);
		builder.append(",");
		builder.append(corPtHipCorrectAgain == null ? "" : corPtHipCorrectAgain);
		builder.append(",");
		builder.append(corPtThighwidthCorrectAgain == null ? "" : corPtThighwidthCorrectAgain);
		builder.append(",");
		builder.append(corPtHemwidthCorrectAgain == null ? "" : corPtHemwidthCorrectAgain);
		builder.append(",");
		builder.append(corPtRightinseamCorrectAgain == null ? "" : corPtRightinseamCorrectAgain);
		builder.append(",");
		builder.append(corPtLeftinseamCorrectAgain == null ? "" : corPtLeftinseamCorrectAgain);
		builder.append(",");
		builder.append(corPt2WaistCorrectAgain == null ? "" : corPt2WaistCorrectAgain);
		builder.append(",");
		builder.append(corPt2HipCorrectAgain == null ? "" : corPt2HipCorrectAgain);
		builder.append(",");
		builder.append(corPt2ThighwidthCorrectAgain == null ? "" : corPt2ThighwidthCorrectAgain);
		builder.append(",");
		builder.append(corPt2HemwidthCorrectAgain == null ? "" : corPt2HemwidthCorrectAgain);
		builder.append(",");
		builder.append(corPt2RightinseamCorrectAgain == null ? "" : corPt2RightinseamCorrectAgain);
		builder.append(",");
		builder.append(corPt2LeftinseamCorrectAgain == null ? "" : corPt2LeftinseamCorrectAgain);
		builder.append(",");
		builder.append(corStoreCorrectionMemoAgain == null ? "" : corStoreCorrectionMemoAgain);
		builder.append(",");
		builder.append(hostTransmitARow == null ? "" : hostTransmitARow);
		builder.append(",");
		builder.append(shippingNumber == null ? "" : shippingNumber);
		builder.append(",");
		builder.append(factoryShippingMethod == null ? "" : factoryShippingMethod);
		builder.append(",");
		builder.append(shippingDate == null ? "" : shippingDate);
		builder.append(",");
		builder.append(loadingDate == null ? "" : loadingDate);
		builder.append(",");
		builder.append(fabricUsedMount == null ? "" : fabricUsedMount);
		builder.append(",");
		builder.append(theoryFabricUsedMount == null ? "" : theoryFabricUsedMount);
		builder.append(",");
		builder.append(tscStatus == null ? "" : tscStatus);
		builder.append(",");
		builder.append(makerFactoryStatus == null ? "" : makerFactoryStatus);
		builder.append(",");
		builder.append(send2factoryStatus == null ? "" : send2factoryStatus);
		builder.append(",");
		builder.append(isCancelled == null ? "" : isCancelled);
		builder.append(",");
		builder.append(theoreticalStockCheck == null ? "" : theoreticalStockCheck);
		builder.append(",");
		builder.append(scheduleDataTransmitStatus == null ? "" : scheduleDataTransmitStatus);
		builder.append(",");
		builder.append(shippingTransmitStatus == null ? "" : shippingTransmitStatus);
		builder.append(",");
		builder.append(version == null ? "" : version);
		builder.append(",");
		builder.append(createdUserId == null ? "" : createdUserId);
		builder.append(",");
		builder.append(createdAt == null ? "" : createdAt);
		builder.append(",");
		builder.append(updatedUserId == null ? "" : updatedUserId);
		builder.append(",");
		builder.append(updatedAt == null ? "" : updatedAt);
		return builder.toString();
	}

}