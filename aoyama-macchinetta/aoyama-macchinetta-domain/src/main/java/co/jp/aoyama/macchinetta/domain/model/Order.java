package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Order implements Serializable {
	
	private static final long serialVersionUID = -1801078148057771L;

	private String orderId;

    private String orderPattern;

    private String storeBrandCode;

    private String shopCode;

    private Integer billingAmount;

    private Integer productPrice;

    private Integer optionPrice;

    private Integer totalPrice;

    private Integer consumptionTaxAmount;

    private Integer salesAmount;

    private Integer wsPrice;

    private String cashId;

    private Integer cashDiscountPrice;

    private Integer cashProductPrice;

    private Integer cashContailTaxProductPrice;

    private String storeNm;

    private String storeStaffNm;

    private String printoutCustRomaNm;

    private String printoutStoreStaffRomaNm;

    private String custCd;

    private String custNm;

    private String custKanaNm;

    private Date custDeliverDate;

    private String custIsDeliverShortning;

    private String custIsEarlyDiscount;

    private Date custShopDeliveryDate;

    private String custStaff;

    private String custType;

    private String custShippingDestination;

    private String custShippingDestnationOtherstore;

    private String custRemark;

    private String productItem;

    private String productItemDisplaycode;

    private String productIs3piece;

    private Integer productIs3pieceRtPrice;

    private BigDecimal productIs3pieceWsWage;

    private Integer productIs3pieceWsPrice;

    private String productSparePantsClass;

    private Integer productSparePantsRtPrice;

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

    private Integer productEmbroideryGazetteRtPrice;

    private BigDecimal productEmbroideryGazetteWsWage;

    private Integer productEmbroideryGazetteWsPrice;

    private String productEmbroideryNmPos;

    private Integer productEmbroideryNmPosRtPrice;

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

    private Integer jkModelRtPrice;

    private BigDecimal jkModelWsWage;

    private Integer jkModelWsPrice;

    private String jkFrtBtnCd;

    private String jkFrtBtnNm;

    private Integer jkFrtBtnRtPrice;

    private BigDecimal jkFrtBtnWsWage;

    private Integer jkFrtBtnWsPrice;

    private String jkLapelDesignCd;

    private String jkLapelDesignNm;

    private Integer jkLapelDesignRtPrice;

    private BigDecimal jkLapelDesignWsWage;

    private Integer jkLapelDesignWsPrice;

    private String jkLapelModelCd;

    private String jkLapelModelNm;

    private Integer jkLapelModelRtPrice;

    private BigDecimal jkLapelModelWsWage;

    private Integer jkLapelModelWsPrice;

    private String jkGradeCd;

    private String jkGradeNm;

    private Integer jkGradeRtPrice;

    private BigDecimal jkGradeWsWage;

    private Integer jkGradeWsPrice;

    private String jkInnerClothCd;

    private String jkInnerClothNm;

    private Integer jkInnerClothRtPrice;

    private BigDecimal jkInnerClothWsWage;

    private Integer jkInnerClothWsPrice;

    private String jkDaibaCd;

    private String jkDaibaNm;

    private Integer jkDaibaRtPrice;

    private BigDecimal jkDaibaWsWage;

    private Integer jkDaibaWsPrice;

    private String jkLookClothCd;

    private String jkLookClothNm;

    private Integer jkLookClothRtPrice;

    private BigDecimal jkLookClothWsWage;

    private Integer jkLookClothWsPrice;

    private String jkCollarInnerCd;

    private String jkCollarInnerNm;

    private Integer jkCollarInnerRtPrice;

    private BigDecimal jkCollarInnerWsWage;

    private Integer jkCollarInnerWsPrice;

    private String jkCollarHangCd;

    private String jkCollarHangNm;

    private Integer jkCollarHangRtPrice;

    private BigDecimal jkCollarHangWsWage;

    private Integer jkCollarHangWsPrice;

    private String jkLapelWidthCd;

    private String jkLapelWidthNm;

    private Integer jkLapelWidthRtPrice;

    private BigDecimal jkLapelWidthWsWage;

    private Integer jkLapelWidthWsPrice;

    private String jkFlowerHoleCd;

    private String jkFlowerHoleNm;

    private Integer jkFlowerHoleRtPrice;

    private BigDecimal jkFlowerHoleWsWage;

    private Integer jkFlowerHoleWsPrice;

    private String jkBreastPktCd;

    private String jkBreastPktNm;

    private Integer jkBreastPktRtPrice;

    private BigDecimal jkBreastPktWsWage;

    private Integer jkBreastPktWsPrice;

    private String jkWaistPktCd;

    private String jkWaistPktNm;

    private Integer jkWaistPktRtPrice;

    private BigDecimal jkWaistPktWsWage;

    private Integer jkWaistPktWsPrice;

    private String jkChgPktCd;

    private String jkChgPktNm;

    private Integer jkChgPktRtPrice;

    private BigDecimal jkChgPktWsWage;

    private Integer jkChgPktWsPrice;

    private String jkSlantedPktCd;

    private String jkSlantedPktNm;

    private Integer jkSlantedPktRtPrice;

    private BigDecimal jkSlantedPktWsWage;

    private Integer jkSlantedPktWsPrice;

    private String jkShinobiPktCd;

    private String jkShinobiPktNm;

    private Integer jkShinobiPktRtPrice;

    private BigDecimal jkShinobiPktWsWage;

    private Integer jkShinobiPktWsPrice;

    private String jkSleeveTypeCd;

    private String jkSleeveTypeNm;

    private Integer jkSleeveTypeRtPrice;

    private BigDecimal jkSleeveTypeWsWage;

    private Integer jkSleeveTypeWsPrice;

    private String jkManicaCd;

    private String jkManicaNm;

    private Integer jkManicaRtPrice;

    private BigDecimal jkManicaWsWage;

    private Integer jkManicaWsPrice;

    private String jkSleeveBtnType;

    private Short jkSleeveBtnNumber;

    private String jkSleeveBtnCd;

    private String jkSleeveBtnNm;

    private Integer jkSleeveBtnRtPrice;

    private BigDecimal jkSleeveBtnWsWage;

    private Integer jkSleeveBtnWsPrice;

    private String jkCuffCd;

    private String jkCuffNm;

    private Integer jkCuffRtPrice;

    private BigDecimal jkCuffWsWage;

    private Integer jkCuffWsPrice;

    private String jkInnerPktType;

    private String jkInnerPktCd;

    private String jkInnerPktNm;

    private Integer jkInnerPktRtPrice;

    private BigDecimal jkInnerPktWsWage;

    private Integer jkInnerPktWsPrice;

    private String jkRightInnerPktTypeCd;

    private String jkRightInnerPktTypeNm;

    private Integer jkRightInnerPktTypeRtPrice;

    private BigDecimal jkRightInnerPktTypeWsWage;

    private Integer jkRightInnerPktTypeWsPrice;

    private String jkStitchTypeCd;

    private String jkStitchTypeNm;

    private Integer jkStitchTypeRtPrice;

    private BigDecimal jkStitchTypeWsWage;

    private Integer jkStitchTypeWsPrice;

    private String jkStitchPlcType;

    private String jkStitchPlcCd;

    private String jkStitchPlcNm;

    private Integer jkStitchPlcRtPrice;

    private BigDecimal jkStitchPlcWsWage;

    private Integer jkStitchPlcWsPrice;

    private String jkDblstitchPlcType;

    private String jkDblstitchPlcCd;

    private String jkDblstitchPlcNm;

    private Integer jkDblstitchPlcRtPrice;

    private BigDecimal jkDblstitchPlcWsWage;

    private Integer jkDblstitchPlcWsPrice;

    private String jkAmfColorType;

    private String jkAmfColorPlcCd;

    private String jkAmfColorPlcNm;

    private String jkAmfColorCd;

    private String jkAmfColorNm;

    private Integer jkAmfColorRtPrice;

    private BigDecimal jkAmfColorWsWage;

    private Integer jkAmfColorWsPrice;

    private String jkBtnholeColorType;

    private String jkBtnholeColorPlcCd;

    private String jkBtnholeColorPlcN;

    private String jkBtnholeColorCd;

    private String jkBtnholeColorNm;

    private Integer jkBtnholePlcColorRtPrice;

    private BigDecimal jkBtnholePlcColorWsWage;

    private Integer jkBtnholePlcColorWsPrice;

    private String jkBtnthreadColorType;

    private String jkBtnthreadColorPlcCd;

    private String jkBtnthreadColorPlcN;

    private String jkBtnthreadColorCd;

    private String jkBtnthreadColorNm;

    private Integer jkBtnthreadPlcColorRtPrice;

    private BigDecimal jkBtnthreadPlcColorWsWage;

    private Integer jkBtnthreadPlcColorWsPrice;

    private String jkVentCd;

    private String jkVentNm;

    private Integer jkVentRtPrice;

    private BigDecimal jkVentWsWage;

    private Integer jkVentWsPrice;

    private String jkInnerBodyClothType;

    private String jkInnerBodyClothCd;

    private String jkInnerBodyClothNm;

    private Integer jkInnerBodyClothRtPrice;

    private BigDecimal jkInnerBodyClothWsWage;

    private Integer jkInnerBodyClothWsPrice;

    private String jkInnerSleeveClothType;

    private String jkInnerSleeveClothCd;

    private String jkInnerSleeveClothNm;

    private Integer jkInnerSleeveClothRtPrice;

    private BigDecimal jkInnerSleeveClothWsWage;

    private Integer jkInnerSleeveClothWsPrice;

    private String jkBtnMaterialType;

    private String jkBtnMaterialCd;

    private String jkBtnMaterialNm;

    private Integer jkBtnMaterialRtPrice;

    private BigDecimal jkBtnMaterialWsWage;

    private Integer jkBtnMaterialWsPrice;

    private String jkShapeMemoryCd;

    private String jkShapeMemoryNm;

    private Integer jkShapeMemoryRtPrice;

    private BigDecimal jkShapeMemoryWsWage;

    private Integer jkShapeMemoryWsPrice;

    private String ptModelCd;

    private String ptModelNm;

    private Integer ptModelRtPrice;

    private BigDecimal ptModelWsWage;

    private Integer ptModelWsPrice;

    private String ptTackCd;

    private String ptTackNm;

    private Integer ptTackRtPrice;

    private BigDecimal ptTackWsWage;

    private Integer ptTackWsPrice;

    private String ptKneeinnerTypeCd;

    private String ptKneeinnerTypeNm;

    private Integer ptKneeinnerTypeRtPrice;

    private BigDecimal ptKneeinnerTypeWsWage;

    private Integer ptKneeinnerTypeWsPrice;

    private String ptKneeinnerClothCd;

    private String ptKneeinnerClothNm;

    private Integer ptKneeinnerClothRtPrice;

    private BigDecimal ptKneeinnerClothWsWage;

    private Integer ptKneeinnerClothWsPrice;

    private String ptFrtTypeCd;

    private String ptFrtTypeNm;

    private Integer ptFrtTypeRtPrice;

    private BigDecimal ptFrtTypeWsWage;

    private Integer ptFrtTypeWsPrice;

    private String ptPancherinaCd;

    private String ptPancherinaNm;

    private Integer ptPancherinaRtPrice;

    private BigDecimal ptPancherinaWsWage;

    private Integer ptPancherinaWsPrice;

    private String ptAdjusterCd;

    private String ptAdjusterNm;

    private Integer ptAdjusterRtPrice;

    private BigDecimal ptAdjusterWsWage;

    private Integer ptAdjusterWsPrice;

    private String ptBeltloopType;

    private String ptBeltloopCd;

    private String ptBeltloopNm;

    private Integer ptBeltloopRtPrice;

    private BigDecimal ptBeltloopWsWage;

    private Integer ptBeltloopWsPrice;

    private String ptPinloopCd;

    private String ptPinloopNm;

    private Integer ptPinloopRtPrice;

    private BigDecimal ptPinloopWsWage;

    private Integer ptPinloopWsPrice;

    private String ptSidePktCd;

    private String ptSidePktNm;

    private Integer ptSidePktRtPrice;

    private BigDecimal ptSidePktWsWage;

    private Integer ptSidePktWsPrice;

    private String ptShinobiPktCd;

    private String ptShinobiPktNm;

    private Integer ptShinobiPktRtPrice;

    private BigDecimal ptShinobiPktWsWage;

    private Integer ptShinobiPktWsPrice;

    private String ptCoinPktCd;

    private String ptCoinPktNm;

    private Integer ptCoinPktRtPrice;

    private BigDecimal ptCoinPktWsWage;

    private Integer ptCoinPktWsPrice;

    private String ptFlapcoinPktCd;

    private String ptFlapcoinPktNm;

    private Integer ptFlapcoinPktRtPrice;

    private BigDecimal ptFlapcoinPktWsWage;

    private Integer ptFlapcoinPktWsPrice;

    private String ptLeftPisPktCd;

    private String ptLeftPisPktNm;

    private Integer ptLeftPisPktRtPrice;

    private BigDecimal ptLeftPisPktWsWage;

    private Integer ptLeftPisPktWsPrice;

    private String ptRightPisPktCd;

    private String ptRightPisPktNm;

    private Integer ptRightPisPktRtPrice;

    private BigDecimal ptRightPisPktWsWage;

    private Integer ptRightPisPktWsPrice;

    private String ptVCutCd;

    private String ptVCutNm;

    private Integer ptVCutRtPrice;

    private BigDecimal ptVCutWsWage;

    private Integer ptVCutWsPrice;

    private String ptHemUpCd;

    private String ptHemUpNm;

    private Integer ptHemUpRtPrice;

    private BigDecimal ptHemUpWsWage;

    private Integer ptHemUpWsPrice;

    private String ptDblWidthCd;

    private String ptDblWidthNm;

    private Integer ptDblWidthRtPrice;

    private BigDecimal ptDblWidthWsWage;

    private Integer ptDblWidthWsPrice;

    private String ptAmfStitchCd;

    private String ptAmfStitchNm;

    private Integer ptAmfStitchRtPrice;

    private BigDecimal ptAmfStitchWsWage;

    private Integer ptAmfStitchWsPrice;

    private String ptStitchPlcType;

    private String ptStitchPlcCd;

    private String ptStitchPlcNm;

    private Integer ptStitchPlcRtPrice;

    private BigDecimal ptStitchPlcWsWage;

    private Integer ptStitchPlcWsPrice;

    private String ptDblstitchPlcType;

    private String ptDblstitchPlcCd;

    private String ptDblstitchPlcNm;

    private Integer ptDblstitchPlcRtPrice;

    private BigDecimal ptDblstitchPlcWsWage;

    private Integer ptDblstitchPlcWsPrice;

    private String ptAmfColorType;

    private String ptAmfColorPlcCd;

    private String ptAmfColorPlcNm;

    private String ptAmfColorCd;

    private String ptAmfColorNm;

    private Integer ptAmfColorRtPrice;

    private BigDecimal ptAmfColorWsWage;

    private Integer ptAmfColorWsPrice;

    private String ptBtnholeColorType;

    private String ptBtnholeColorPlcCd;

    private String ptBtnholeColorPlcNm;

    private String ptBtnholeColorCd;

    private String ptBtnholeColorNm;

    private Integer ptBtnholeColorRtPrice;

    private BigDecimal ptBtnholeColorWsWage;

    private Integer ptBtnholeColorWsPrice;

    private String ptBtnthreadColorType;

    private String ptBtnthreadColorPlcCd;

    private String ptBtnthreadColorPlcNm;

    private String ptBtnthreadColorCd;

    private String ptBtnthreadColorNm;

    private Integer ptBtnthreadColorRtPrice;

    private BigDecimal ptBtnthreadColorWsWage;

    private Integer ptBtnthreadColorWsPrice;

    private String ptBtnMaterialType;

    private String ptBtnMaterialCd;

    private String ptBtnMaterialNm;

    private Integer ptBtnMaterialRtPrice;

    private BigDecimal ptBtnMaterialWsWage;

    private Integer ptBtnMaterialWsPrice;

    private String ptSuspenderBtnCd;

    private String ptSuspenderBtnNm;

    private Integer ptSuspenderBtnRtPrice;

    private BigDecimal ptSuspenderBtnWsWage;

    private Integer ptSuspenderBtnWsPrice;

    private String ptNonSlipCd;

    private String ptNonSlipNm;

    private Integer ptNonSlipRtPrice;

    private BigDecimal ptNonSlipWsWage;

    private Integer ptNonSlipWsPrice;

    private String ptChicSlipCd;

    private String ptChicSlipNm;

    private Integer ptChicSlipRtPrice;

    private BigDecimal ptChicSlipWsWage;

    private Integer ptChicSlipWsPrice;

    private String ptShapeMemoryCd;

    private String ptShapeMemoryNm;

    private Integer ptShapeMemoryRtPrice;

    private BigDecimal ptShapeMemoryWsWage;

    private Integer ptShapeMemoryWsPrice;

    private String ptShoeSoreCd;

    private String ptShoeSoreNm;

    private Integer ptShoeSoreRtPrice;

    private BigDecimal ptShoeSoreWsWage;

    private Integer ptShoeSoreWsPrice;

    private String ptSideStripeCd;

    private String ptSideStripeNm;

    private Integer ptSideStripeRtPrice;

    private BigDecimal ptSideStripeWsWage;

    private Integer ptSideStripeWsPrice;

    private String ptSideStripeWidthCd;

    private String ptSideStripeWidthNm;

    private Integer ptSideStripeWidthRtPrice;

    private BigDecimal ptSideStripeWidthWsWage;

    private Integer ptSideStripeWidthWsPrice;

    private String pt2ModelCd;

    private String pt2ModelNm;

    private Integer pt2ModelRtPrice;

    private BigDecimal pt2ModelWsWage;

    private Integer pt2ModelWsPrice;

    private String pt2TackCd;

    private String pt2TackNm;

    private Integer pt2TackRtPrice;

    private BigDecimal pt2TackWsWage;

    private Integer pt2TackWsPrice;

    private String pt2KneeinnerTypeCd;

    private String pt2KneeinnerTypeNm;

    private Integer pt2KneeinnerTypeRtPrice;

    private BigDecimal pt2KneeinnerTypeWsWage;

    private Integer pt2KneeinnerTypeWsPrice;

    private String pt2KneeinnerClothCd;

    private String pt2KneeinnerClothNm;

    private Integer pt2KneeinnerClothRtPrice;

    private BigDecimal pt2KneeinnerClothWsWage;

    private Integer pt2KneeinnerClothWsPrice;

    private String pt2FrtTypeCd;

    private String pt2FrtTypeNm;

    private Integer pt2FrtTypeRtPrice;

    private BigDecimal pt2FrtTypeWsWage;

    private Integer pt2FrtTypeWsPrice;

    private String pt2PancherinaCd;

    private String pt2PancherinaNm;

    private Integer pt2PancherinaRtPrice;

    private BigDecimal pt2PancherinaWsWage;

    private Integer pt2PancherinaWsPrice;

    private String pt2AdjusterCd;

    private String pt2AdjusterNm;

    private Integer pt2AdjusterRtPrice;

    private BigDecimal pt2AdjusterWsWage;

    private Integer pt2AdjusterWsPrice;

    private String pt2BeltloopType;

    private String pt2BeltloopCd;

    private String pt2BeltloopNm;

    private Integer pt2BeltloopRtPrice;

    private BigDecimal pt2BeltloopWsWage;

    private Integer pt2BeltloopWsPrice;

    private String pt2PinloopCd;

    private String pt2PinloopNm;

    private Integer pt2PinloopRtPrice;

    private BigDecimal pt2PinloopWsWage;

    private Integer pt2PinloopWsPrice;

    private String pt2SidePktCd;

    private String pt2SidePktNm;

    private Integer pt2SidePktRtPrice;

    private BigDecimal pt2SidePktWsWage;

    private Integer pt2SidePktWsPrice;

    private String pt2ShinobiPktCd;

    private String pt2ShinobiPktNm;

    private Integer pt2ShinobiPktRtPrice;

    private BigDecimal pt2ShinobiPktWsWage;

    private Integer pt2ShinobiPktWsPrice;

    private String pt2CoinPktCd;

    private String pt2CoinPktNm;

    private Integer pt2CoinPktRtPrice;

    private BigDecimal pt2CoinPktWsWage;

    private Integer pt2CoinPktWsPrice;

    private String pt2FlapcoinPktCd;

    private String pt2FlapcoinPktNm;

    private Integer pt2FlapcoinPktRtPrice;

    private BigDecimal pt2FlapcoinPktWsWage;

    private Integer pt2FlapcoinPktWsPrice;

    private String pt2LeftPisPktCd;

    private String pt2LeftPisPktNm;

    private Integer pt2LeftPisPktRtPrice;

    private BigDecimal pt2LeftPisPktWsWage;

    private Integer pt2LeftPisPktWsPrice;

    private String pt2RightPisPktCd;

    private String pt2RightPisPktNm;

    private Integer pt2RightPisPktRtPrice;

    private BigDecimal pt2RightPisPktWsWage;

    private Integer pt2RightPisPktWsPrice;

    private String pt2VCutCd;

    private String pt2VCutNm;

    private Integer pt2VCutRtPrice;

    private BigDecimal pt2VCutWsWage;

    private Integer pt2VCutWsPrice;

    private String pt2HemUpCd;

    private String pt2HemUpNm;

    private Integer pt2HemUpRtPrice;

    private BigDecimal pt2HemUpWsWage;

    private Integer pt2HemUpWsPrice;

    private String pt2DblWidthCd;

    private String pt2DblWidthNm;

    private Integer pt2DblWidthRtPrice;

    private BigDecimal pt2DblWidthWsWage;

    private Integer pt2DblWidthWsPrice;

    private String pt2AmfStitchCd;

    private String pt2AmfStitchNm;

    private Integer pt2AmfStitchRtPrice;

    private BigDecimal pt2AmfStitchWsWage;

    private Integer pt2AmfStitchWsPrice;

    private String pt2StitchPlcType;

    private String pt2StitchPlcCd;

    private String pt2StitchPlcNm;

    private Integer pt2StitchPlcRtPrice;

    private BigDecimal pt2StitchPlcWsWage;

    private Integer pt2StitchPlcWsPrice;

    private String pt2DblstitchPlcType;

    private String pt2DblstitchPlcCd;

    private String pt2DblstitchPlcNm;

    private Integer pt2DblstitchPlcRtPrice;

    private BigDecimal pt2DblstitchPlcWsWage;

    private Integer pt2DblstitchPlcWsPrice;

    private String pt2AmfColorType;

    private String pt2AmfColorPlcCd;

    private String pt2AmfColorPlcNm;

    private String pt2AmfColorCd;

    private String pt2AmfColorNm;

    private Integer pt2AmfColorRtPrice;

    private BigDecimal pt2AmfColorWsWage;

    private Integer pt2AmfColorWsPrice;

    private String pt2BtnholeColorType;

    private String pt2BtnholeColorPlcCd;

    private String pt2BtnholeColorPlcNm;

    private String pt2BtnholeColorCd;

    private String pt2BtnholeColorNm;

    private Integer pt2BtnholeColorRtPrice;

    private BigDecimal pt2BtnholeColorWsWage;

    private Integer pt2BtnholeColorWsPrice;

    private String pt2BtnthreadColorType;

    private String pt2BtnthreadColorPlcCd;

    private String pt2BtnthreadColorPlcNm;

    private String pt2BtnthreadColorCd;

    private String pt2BtnthreadColorNm;

    private Integer pt2BtnthreadColorRtPrice;

    private BigDecimal pt2BtnthreadColorWsWage;

    private Integer pt2BtnthreadColorWsPrice;

    private String pt2BtnMaterialType;

    private String pt2BtnMaterialCd;

    private String pt2BtnMaterialNm;

    private Integer pt2BtnMaterialRtPrice;

    private BigDecimal pt2BtnMaterialWsWage;

    private Integer pt2BtnMaterialWsPrice;

    private String pt2SuspenderBtnCd;

    private String pt2SuspenderBtnNm;

    private Integer pt2SuspenderBtnRtPrice;

    private BigDecimal pt2SuspenderBtnWsWage;

    private Integer pt2SuspenderBtnWsPrice;

    private String pt2NonSlipCd;

    private String pt2NonSlipNm;

    private Integer pt2NonSlipRtPrice;

    private BigDecimal pt2NonSlipWsWage;

    private Integer pt2NonSlipWsPrice;

    private String pt2ChicSlipCd;

    private String pt2ChicSlipNm;

    private Integer pt2ChicSlipRtPrice;

    private BigDecimal pt2ChicSlipWsWage;

    private Integer pt2ChicSlipWsPrice;

    private String pt2ShapeMemoryCd;

    private String pt2ShapeMemoryNm;

    private Integer pt2ShapeMemoryRtPrice;

    private BigDecimal pt2ShapeMemoryWsWage;

    private Integer pt2ShapeMemoryWsPrice;

    private String pt2ShoeSoreCd;

    private String pt2ShoeSoreNm;

    private Integer pt2ShoeSoreRtPrice;

    private BigDecimal pt2ShoeSoreWsWage;

    private Integer pt2ShoeSoreWsPrice;

    private String pt2SideStripeCd;

    private String pt2SideStripeNm;

    private Integer pt2SideStripeRtPrice;

    private BigDecimal pt2SideStripeWsWage;

    private Integer pt2SideStripeWsPrice;

    private String pt2SideStripeWidthCd;

    private String pt2SideStripeWidthNm;

    private Integer pt2SideStripeWidthRtPrice;

    private BigDecimal pt2SideStripeWidthWsWage;

    private Integer pt2SideStripeWidthWsPrice;

    private String pt3ModelCd;

    private String pt3ModelNm;

    private Integer pt3ModelRtPrice;

    private BigDecimal pt3ModelWsWage;

    private Integer pt3ModelWsPrice;

    private String pt3TackCd;

    private String pt3TackNm;

    private Integer pt3TackRtPrice;

    private BigDecimal pt3TackWsWage;

    private Integer pt3TackWsPrice;

    private String pt3KneeinnerTypeCd;

    private String pt3KneeinnerTypeNm;

    private Integer pt3KneeinnerTypeRtPrice;

    private BigDecimal pt3KneeinnerTypeWsWage;

    private Integer pt3KneeinnerTypeWsPrice;

    private String pt3KneeinnerClothCd;

    private String pt3KneeinnerClothNm;

    private Integer pt3KneeinnerClothRtPrice;

    private BigDecimal pt3KneeinnerClothWsWage;

    private Integer pt3KneeinnerClothWsPrice;

    private String pt3FrtTypeCd;

    private String pt3FrtTypeNm;

    private Integer pt3FrtTypeRtPrice;

    private BigDecimal pt3FrtTypeWsWage;

    private Integer pt3FrtTypeWsPrice;

    private String pt3PancherinaCd;

    private String pt3PancherinaNm;

    private Integer pt3PancherinaRtPrice;

    private BigDecimal pt3PancherinaWsWage;

    private Integer pt3PancherinaWsPrice;

    private String pt3AdjusterCd;

    private String pt3AdjusterNm;

    private Integer pt3AdjusterRtPrice;

    private BigDecimal pt3AdjusterWsWage;

    private Integer pt3AdjusterWsPrice;

    private String pt3BeltloopType;

    private String pt3BeltloopCd;

    private String pt3BeltloopNm;

    private Integer pt3BeltloopRtPrice;

    private BigDecimal pt3BeltloopWsWage;

    private Integer pt3BeltloopWsPrice;

    private String pt3PinloopCd;

    private String pt3PinloopNm;

    private Integer pt3PinloopRtPrice;

    private BigDecimal pt3PinloopWsWage;

    private Integer pt3PinloopWsPrice;

    private String pt3SidePktCd;

    private String pt3SidePktNm;

    private Integer pt3SidePktRtPrice;

    private BigDecimal pt3SidePktWsWage;

    private Integer pt3SidePktWsPrice;

    private String pt3ShinobiPktCd;

    private String pt3ShinobiPktNm;

    private Integer pt3ShinobiPktRtPrice;

    private BigDecimal pt3ShinobiPktWsWage;

    private Integer pt3ShinobiPktWsPrice;

    private String pt3CoinPktCd;

    private String pt3CoinPktNm;

    private Integer pt3CoinPktRtPrice;

    private BigDecimal pt3CoinPktWsWage;

    private Integer pt3CoinPktWsPrice;

    private String pt3FlapcoinPktCd;

    private String pt3FlapcoinPktNm;

    private Integer pt3FlapcoinPktRtPrice;

    private BigDecimal pt3FlapcoinPktWsWage;

    private Integer pt3FlapcoinPktWsPrice;

    private String pt3LeftPisPktCd;

    private String pt3LeftPisPktNm;

    private Integer pt3LeftPisPktRtPrice;

    private BigDecimal pt3LeftPisPktWsWage;

    private Integer pt3LeftPisPktWsPrice;

    private String pt3RightPisPktCd;

    private String pt3RightPisPktNm;

    private Integer pt3RightPisPktRtPrice;

    private BigDecimal pt3RightPisPktWsWage;

    private Integer pt3RightPisPktWsPrice;

    private String pt3VCutCd;

    private String pt3VCutNm;

    private Integer pt3VCutRtPrice;

    private BigDecimal pt3VCutWsWage;

    private Integer pt3VCutWsPrice;

    private String pt3HemUpCd;

    private String pt3HemUpNm;

    private Integer pt3HemUpRtPrice;

    private BigDecimal pt3HemUpWsWage;

    private Integer pt3HemUpWsPrice;

    private String pt3DblWidthCd;

    private String pt3DblWidthNm;

    private Integer pt3DblWidthRtPrice;

    private BigDecimal pt3DblWidthWsWage;

    private Integer pt3DblWidthWsPrice;

    private String pt3AmfStitchCd;

    private String pt3AmfStitchNm;

    private Integer pt3AmfStitchRtPrice;

    private BigDecimal pt3AmfStitchWsWage;

    private Integer pt3AmfStitchWsPrice;

    private String pt3StitchPlcType;

    private String pt3StitchPlcCd;

    private String pt3StitchPlcNm;

    private Integer pt3StitchPlcRtPrice;

    private BigDecimal pt3StitchPlcWsWage;

    private Integer pt3StitchPlcWsPrice;

    private String pt3DblstitchPlcType;

    private String pt3DblstitchPlcCd;

    private String pt3DblstitchPlcNm;

    private Integer pt3DblstitchPlcRtPrice;

    private BigDecimal pt3DblstitchPlcWsWage;

    private Integer pt3DblstitchPlcWsPrice;

    private String pt3AmfColorType;

    private String pt3AmfColorPlcCd;

    private String pt3AmfColorPlcNm;

    private String pt3AmfColorCd;

    private String pt3AmfColorNm;

    private Integer pt3AmfColorRtPrice;

    private BigDecimal pt3AmfColorWsWage;

    private Integer pt3AmfColorWsPrice;

    private String pt3BtnholeColorType;

    private String pt3BtnholeColorPlcCd;

    private String pt3BtnholeColorPlcNm;

    private String pt3BtnholeColorCd;

    private String pt3BtnholeColorNm;

    private Integer pt3BtnholeColorRtPrice;

    private BigDecimal pt3BtnholeColorWsWage;

    private Integer pt3BtnholeColorWsPrice;

    private String pt3BtnthreadColorType;

    private String pt3BtnthreadColorPlcCd;

    private String pt3BtnthreadColorPlcNm;

    private String pt3BtnthreadColorCd;

    private String pt3BtnthreadColorNm;

    private Integer pt3BtnthreadColorRtPrice;

    private BigDecimal pt3BtnthreadColorWsWage;

    private Integer pt3BtnthreadColorWsPrice;

    private String pt3BtnMaterialType;

    private String pt3BtnMaterialCd;

    private String pt3BtnMaterialNm;

    private Integer pt3BtnMaterialRtPrice;

    private BigDecimal pt3BtnMaterialWsWage;

    private Integer pt3BtnMaterialWsPrice;

    private String pt3SuspenderBtnCd;

    private String pt3SuspenderBtnNm;

    private Integer pt3SuspenderBtnRtPrice;

    private BigDecimal pt3SuspenderBtnWsWage;

    private Integer pt3SuspenderBtnWsPrice;

    private String pt3NonSlipCd;

    private String pt3NonSlipNm;

    private Integer pt3NonSlipRtPrice;

    private BigDecimal pt3NonSlipWsWage;

    private Integer pt3NonSlipWsPrice;

    private String pt3ChicSlipCd;

    private String pt3ChicSlipNm;

    private Integer pt3ChicSlipRtPrice;

    private BigDecimal pt3ChicSlipWsWage;

    private Integer pt3ChicSlipWsPrice;

    private String pt3ShapeMemoryCd;

    private String pt3ShapeMemoryNm;

    private Integer pt3ShapeMemoryRtPrice;

    private BigDecimal pt3ShapeMemoryWsWage;

    private Integer pt3ShapeMemoryWsPrice;

    private String pt3ShoeSoreCd;

    private String pt3ShoeSoreNm;

    private Integer pt3ShoeSoreRtPrice;

    private BigDecimal pt3ShoeSoreWsWage;

    private Integer pt3ShoeSoreWsPrice;

    private String pt3SideStripeCd;

    private String pt3SideStripeNm;

    private Integer pt3SideStripeRtPrice;

    private BigDecimal pt3SideStripeWsWage;

    private Integer pt3SideStripeWsPrice;

    private String pt3SideStripeWidthCd;

    private String pt3SideStripeWidthNm;

    private Integer pt3SideStripeWidthRtPrice;

    private BigDecimal pt3SideStripeWidthWsWage;

    private Integer pt3SideStripeWidthWsPrice;

    private String glModelCd;

    private String glModelNm;

    private Integer glModelRtPrice;

    private BigDecimal glModelWsWage;

    private Integer glModelWsPrice;

    private String glBreastPktCd;

    private String glBreastPktNm;

    private Integer glBreastPktRtPrice;

    private BigDecimal glBreastPktWsWage;

    private Integer glBreastPktWsPrice;

    private String glWaistPktCd;

    private String glWaistPktNm;

    private Integer glWaistPktRtPrice;

    private BigDecimal glWaistPktWsWage;

    private Integer glWaistPktWsPrice;

    private String glWaistPktShapeCd;

    private String glWaistPktShapeNm;

    private Integer glWaistPktShapeRtPrice;

    private BigDecimal glWaistPktShapeWsWage;

    private Integer glWaistPktShapeWsPrice;

    private String glWaistPktClothCd;

    private String glWaistPktClothNm;

    private Integer glWaistPktClothRtPrice;

    private BigDecimal glWaistPktClothWsWage;

    private Integer glWaistPktClothWsPrice;

    private String glAmfStitchCd;

    private String glAmfStitchNm;

    private Integer glAmfStitchRtPrice;

    private BigDecimal glAmfStitchWsWage;

    private Integer glAmfStitchWsPrice;

    private String glStitchPlcType;

    private String glStitchPlcCd;

    private String glStitchPlcNm;

    private Integer glStitchPlcRtPrice;

    private BigDecimal glStitchPlcWsWage;

    private Integer glStitchPlcWsPrice;

    private String glDblstitchPlcType;

    private String glDblstitchPlcCd;

    private String glDblstitchPlcNm;

    private Integer glDblstitchPlcRtPrice;

    private BigDecimal glDblstitchPlcWsWage;

    private Integer glDblstitchPlcWsPrice;

    private String glAmfColorType;

    private String glAmfColorPlcCd;

    private String glAmfColorPlcNm;

    private String glAmfColorCd;

    private String glAmfColorNm;

    private Integer glAmfColorRtPrice;

    private BigDecimal glAmfColorWsWage;

    private Integer glAmfColorWsPrice;

    private String glBtnholeColorType;

    private String glBtnholeColorPlcCd;

    private String glBtnholeColorPlcNm;

    private String glBtnholeColorCd;

    private String glBtnholeColorNm;

    private Integer glBtnholeColorRtPrice;

    private BigDecimal glBtnholeColorWsWage;

    private Integer glBtnholeColorWsPrice;

    private String glBtnthreadColorType;

    private String glBtnthreadColorPlcCd;

    private String glBtnthreadColorPlcNm;

    private String glBtnthreadColorCd;

    private String glBtnthreadColorNm;

    private Integer glBtnthreadColorRtPrice;

    private BigDecimal glBtnthreadColorWsWage;

    private Integer glBtnthreadColorWsPrice;

    private String glBackClothType;

    private String glBackClothCd;

    private String glBackClothNm;

    private Integer glBackClothRtPrice;

    private BigDecimal glBackClothWsWage;

    private Integer glBackClothWsPrice;

    private String glInnnerClothType;

    private String glInnnerClothCd;

    private String glInnnerClothNm;

    private Integer glInnnerClothRtPrice;

    private BigDecimal glInnnerClothWsWage;

    private Integer glInnnerClothWsPrice;

    private String glFrtBtnType;

    private String glFrtBtnCd;

    private String glFrtBtnNm;

    private Integer glFrtBtnRtPrice;

    private BigDecimal glFrtBtnWsWage;

    private Integer glFrtBtnWsPrice;

    private String glBackBeltCd;

    private String glBackBeltNm;

    private Integer glBackBeltRtPrice;

    private BigDecimal glBackBeltWsWage;

    private Integer glBackBeltWsPrice;

    private String glWatchChainCd;

    private String glWatchChainNm;

    private Integer glWatchChainRtPrice;

    private BigDecimal glWatchChainWsWage;

    private Integer glWatchChainWsPrice;

    private String ctModelCd;

    private String ctModelNm;

    private Integer ctModelRtPrice;

    private BigDecimal ctModelWsWage;

    private Integer ctModelWsPrice;

    private String ctLapelDesignCd;

    private String ctLapelDesignNm;

    private Integer ctLapelDesignRtPrice;

    private BigDecimal ctLapelDesignWsWage;

    private Integer ctLapelDesignWsPrice;

    private String ctSleeveTypeCd;

    private String ctSleeveTypeNm;

    private Integer ctSleeveTypeRtPrice;

    private BigDecimal ctSleeveTypeWsWage;

    private Integer ctSleeveTypeWsPrice;

    private String ctWaistPktCd;

    private String ctWaistPktNm;

    private Integer ctWaistPktRtPrice;

    private BigDecimal ctWaistPktWsWage;

    private Integer ctWaistPktWsPrice;

    private String ctChgPktCd;

    private String ctChgPktNm;

    private Integer ctChgPktRtPrice;

    private BigDecimal ctChgPktWsWage;

    private Integer ctChgPktWsPrice;

    private String ctSlantedPktCd;

    private String ctSlantedPktNm;

    private Integer ctSlantedPktRtPrice;

    private BigDecimal ctSlantedPktWsWage;

    private Integer ctSlantedPktWsPrice;

    private String ctVentCd;

    private String ctVentNm;

    private Integer ctVentRtPrice;

    private BigDecimal ctVentWsWage;

    private Integer ctVentWsPrice;

    private String ctFrtBtnCd;

    private String ctFrtBtnNm;

    private Integer ctFrtBtnRtPrice;

    private BigDecimal ctFrtBtnWsWage;

    private Integer ctFrtBtnWsPrice;

    private String ctCuffCd;

    private String ctCuffNm;

    private Integer ctCuffRtPrice;

    private BigDecimal ctCuffWsWage;

    private Integer ctCuffWsPrice;

    private String ctSleeveBtnCd;

    private String ctSleeveBtnNm;

    private Integer ctSleeveBtnRtPrice;

    private BigDecimal ctSleeveBtnWsWage;

    private Integer ctSleeveBtnWsPrice;

    private String ctBackBeltCd;

    private String ctBackBeltNm;

    private Integer ctBackBeltRtPrice;

    private BigDecimal ctBackBeltWsWage;

    private Integer ctBackBeltWsPrice;

    private String ctCollarHangCd;

    private String ctCollarHangNm;

    private Integer ctCollarHangRtPrice;

    private BigDecimal ctCollarHangWsWage;

    private Integer ctCollarHangWsPrice;

    private String ctInnerBodyClothCd;

    private String ctInnerBodyClothNm;

    private Integer ctInnerBodyClothRtPrice;

    private BigDecimal ctInnerBodyClothWsWage;

    private Integer ctInnerBodyClothWsPrice;

    private String ctInnerSleeveClothCd;

    private String ctInnerSleeveClothNm;

    private Integer ctInnerSleeveClothRtPrice;

    private BigDecimal ctInnerSleeveClothWsWage;

    private Integer ctInnerSleeveClothWsPrice;

    private String ctBtnMaterialCd;

    private String ctBtnMaterialNm;

    private Integer ctBtnMaterialRtPrice;

    private BigDecimal ctBtnMaterialWsWage;

    private Integer ctBtnMaterialWsPrice;

    private String stModelCd;

    private String stModelNm;

    private Integer stModelRtPrice;

    private BigDecimal stModelWsWage;

    private Integer stModelWsPrice;

    private String stCasualHemlineCd;

    private BigDecimal stCasualHemlineSize;

    private String stCasualHemlineNm;

    private Integer stCasualHemlineRtPrice;

    private BigDecimal stCasualHemlineWsWage;

    private Integer stCasualHemlineWsPrice;

    private String stCollarTypeCd;

    private String stCollarTypeNm;

    private Integer stCollarTypeRtPrice;

    private BigDecimal stCollarTypeWsWage;

    private Integer stCollarTypeWsPrice;

    private String stCuffsCd;

    private String stCuffsNm;

    private Integer stCuffsRtPrice;

    private BigDecimal stCuffsWsWage;

    private Integer stCuffsWsPrice;

    private String stConvertibleCd;

    private String stConvertibleNm;

    private Integer stConvertibleRtPrice;

    private BigDecimal stConvertibleWsWage;

    private Integer stConvertibleWsPrice;

    private String stAdjusterBtnCd;

    private String stAdjusterBtnNm;

    private Integer stAdjusterBtnRtPrice;

    private BigDecimal stAdjusterBtnWsWage;

    private Integer stAdjusterBtnWsPrice;

    private String stDblCuffsCd;

    private String stDblCuffsNm;

    private Integer stDblCuffsRtPrice;

    private BigDecimal stDblCuffsWsWage;

    private Integer stDblCuffsWsPrice;

    private String stClericCd;

    private String stClericNm;

    private Integer stClericRtPrice;

    private BigDecimal stClericWsWage;

    private Integer stClericWsPrice;

    private String stCuffsBtnCd;

    private String stCuffsBtnNm;

    private Integer stCuffsBtnRtPrice;

    private BigDecimal stCuffsBtnWsWage;

    private Integer stCuffsBtnWsPrice;

    private String stSleeveClericcd;

    private String stSleeveClericnm;

    private Integer stSleeveClericrtPrice;

    private BigDecimal stSleeveClericwsWage;

    private Integer stSleeveClericwsPrice;

    private String stBtnMaterialCd;

    private String stBtnMaterialNm;

    private Integer stBtnMaterialRtPrice;

    private BigDecimal stBtnMaterialWsWage;

    private Integer stBtnMaterialWsPrice;

    private String stDblBtnCd;

    private String stDblBtnNm;

    private Integer stDblBtnRtPrice;

    private BigDecimal stDblBtnWsWage;

    private Integer stDblBtnWsPrice;

    private String stGauntletBtnPosCd;

    private String stGauntletBtnPosNm;

    private Integer stGauntletBtnPosRtPrice;

    private BigDecimal stGauntletBtnPosWsWage;

    private Integer stGauntletBtnPosWsPrice;

    private String stPinholePinCd;

    private String stPinholePinNm;

    private Integer stPinholePinRtPrice;

    private BigDecimal stPinholePinWsWage;

    private Integer stPinholePinWsPrice;

    private String stBreastPktCd;

    private String stBreastPktNm;

    private Integer stBreastPktRtPrice;

    private BigDecimal stBreastPktWsWage;

    private Integer stBreastPktWsPrice;

    private String stBreastSizeCd;

    private String stBreastSizeNm;

    private Integer stBreastSizeRtPrice;

    private BigDecimal stBreastSizeWsWage;

    private Integer stBreastSizeWsPrice;

    private String stFrtDesignCd;

    private String stFrtDesignNm;

    private Integer stFrtDesignRtPrice;

    private BigDecimal stFrtDesignWsWage;

    private Integer stFrtDesignWsPrice;

    private String stPintuckBosomCd;

    private String stPintuckBosomNm;

    private Integer stPintuckBosomRtPrice;

    private BigDecimal stPintuckBosomWsWage;

    private Integer stPintuckBosomWsPrice;

    private String stStitchCd;

    private String stStitchNm;

    private Integer stStitchRtPrice;

    private BigDecimal stStitchWsWage;

    private Integer stStitchWsPrice;

    private String stColarKeeperCd;

    private String stColarKeeperNm;

    private Integer stColarKeeperRtPrice;

    private BigDecimal stColarKeeperWsWage;

    private Integer stColarKeeperWsPrice;

    private String stBtnthreadColorCd;

    private String stBtnthreadColorNm;

    private Integer stBtnthreadColorRtPrice;

    private BigDecimal stBtnthreadColorWsWage;

    private Integer stBtnthreadColorWsPrice;

    private String stBtnholeColorCd;

    private String stBtnholeColorNm;

    private Integer stBtnholeColorRtPrice;

    private BigDecimal stBtnholeColorWsWage;

    private Integer stBtnholeColorWsPrice;

    private String stBtnposChgCd;

    private String stBtnposChgNm;

    private Integer stBtnposChgRtPrice;

    private BigDecimal stBtnposChgWsWage;

    private Integer stBtnposChgWsPrice;

    private String stNeckbandBtnChgCd;

    private String stNeckbandBtnChgNm;

    private Integer stNeckbandBtnChgRtPrice;

    private BigDecimal stNeckbandBtnChgWsWage;

    private Integer stNeckbandBtnChgWsPrice;

    private BigDecimal stNeckbandBtnPosChg;

    private String stFrtfirstBtnChgCd;

    private String stFrtfirstBtnChgNm;

    private Integer stFrtfirstBtnChgRtPrice;

    private BigDecimal stFrtfirstBtnChgWsWage;

    private Integer stFrtfirstBtnChgWsPrice;

    private BigDecimal stFrtfirstBtnPosChg;

    private String stFrtsecondBtnChgCd;

    private String stFrtsecondBtnChgNm;

    private Integer stFrtsecondBtnChgRtPrice;

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

    private String hostTransmitStoreCd;

    private String hostTransmitItemCd;

    private String hostTransmitMakerCd;

    private String hostTransmitNenkiCd;

    private String hostTransmitColorCd;

    private String hostTransmitSize;

    private String hostTransmitMakerProduct;

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
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderPattern() {
        return orderPattern;
    }

    public void setOrderPattern(String orderPattern) {
        this.orderPattern = orderPattern == null ? null : orderPattern.trim();
    }

    public String getStoreBrandCode() {
        return storeBrandCode;
    }

    public void setStoreBrandCode(String storeBrandCode) {
        this.storeBrandCode = storeBrandCode == null ? null : storeBrandCode.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public Integer getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(Integer billingAmount) {
        this.billingAmount = billingAmount;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(Integer optionPrice) {
        this.optionPrice = optionPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getConsumptionTaxAmount() {
        return consumptionTaxAmount;
    }

    public void setConsumptionTaxAmount(Integer consumptionTaxAmount) {
        this.consumptionTaxAmount = consumptionTaxAmount;
    }

    public Integer getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Integer getWsPrice() {
        return wsPrice;
    }

    public void setWsPrice(Integer wsPrice) {
        this.wsPrice = wsPrice;
    }

    public String getCashId() {
        return cashId;
    }

    public void setCashId(String cashId) {
        this.cashId = cashId == null ? null : cashId.trim();
    }

    public Integer getCashDiscountPrice() {
        return cashDiscountPrice;
    }

    public void setCashDiscountPrice(Integer cashDiscountPrice) {
        this.cashDiscountPrice = cashDiscountPrice;
    }

    public Integer getCashProductPrice() {
        return cashProductPrice;
    }

    public void setCashProductPrice(Integer cashProductPrice) {
        this.cashProductPrice = cashProductPrice;
    }

    public Integer getCashContailTaxProductPrice() {
        return cashContailTaxProductPrice;
    }

    public void setCashContailTaxProductPrice(Integer cashContailTaxProductPrice) {
        this.cashContailTaxProductPrice = cashContailTaxProductPrice;
    }

    public String getStoreNm() {
        return storeNm;
    }

    public void setStoreNm(String storeNm) {
        this.storeNm = storeNm == null ? null : storeNm.trim();
    }

    public String getStoreStaffNm() {
        return storeStaffNm;
    }

    public void setStoreStaffNm(String storeStaffNm) {
        this.storeStaffNm = storeStaffNm == null ? null : storeStaffNm.trim();
    }

    public String getPrintoutCustRomaNm() {
        return printoutCustRomaNm;
    }

    public void setPrintoutCustRomaNm(String printoutCustRomaNm) {
        this.printoutCustRomaNm = printoutCustRomaNm == null ? null : printoutCustRomaNm.trim();
    }

    public String getPrintoutStoreStaffRomaNm() {
        return printoutStoreStaffRomaNm;
    }

    public void setPrintoutStoreStaffRomaNm(String printoutStoreStaffRomaNm) {
        this.printoutStoreStaffRomaNm = printoutStoreStaffRomaNm == null ? null : printoutStoreStaffRomaNm.trim();
    }

    public String getCustCd() {
        return custCd;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd == null ? null : custCd.trim();
    }

    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm == null ? null : custNm.trim();
    }

    public String getCustKanaNm() {
        return custKanaNm;
    }

    public void setCustKanaNm(String custKanaNm) {
        this.custKanaNm = custKanaNm == null ? null : custKanaNm.trim();
    }

    public Date getCustDeliverDate() {
        return custDeliverDate;
    }

    public void setCustDeliverDate(Date custDeliverDate) {
        this.custDeliverDate = custDeliverDate;
    }

    public String getCustIsDeliverShortning() {
        return custIsDeliverShortning;
    }

    public void setCustIsDeliverShortning(String custIsDeliverShortning) {
        this.custIsDeliverShortning = custIsDeliverShortning == null ? null : custIsDeliverShortning.trim();
    }

    public String getCustIsEarlyDiscount() {
        return custIsEarlyDiscount;
    }

    public void setCustIsEarlyDiscount(String custIsEarlyDiscount) {
        this.custIsEarlyDiscount = custIsEarlyDiscount == null ? null : custIsEarlyDiscount.trim();
    }

    public Date getCustShopDeliveryDate() {
        return custShopDeliveryDate;
    }

    public void setCustShopDeliveryDate(Date custShopDeliveryDate) {
        this.custShopDeliveryDate = custShopDeliveryDate;
    }

    public String getCustStaff() {
        return custStaff;
    }

    public void setCustStaff(String custStaff) {
        this.custStaff = custStaff == null ? null : custStaff.trim();
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
    }

    public String getCustShippingDestination() {
        return custShippingDestination;
    }

    public void setCustShippingDestination(String custShippingDestination) {
        this.custShippingDestination = custShippingDestination == null ? null : custShippingDestination.trim();
    }

    public String getCustShippingDestnationOtherstore() {
        return custShippingDestnationOtherstore;
    }

    public void setCustShippingDestnationOtherstore(String custShippingDestnationOtherstore) {
        this.custShippingDestnationOtherstore = custShippingDestnationOtherstore == null ? null : custShippingDestnationOtherstore.trim();
    }

    public String getCustRemark() {
        return custRemark;
    }

    public void setCustRemark(String custRemark) {
        this.custRemark = custRemark == null ? null : custRemark.trim();
    }

    public String getProductItem() {
        return productItem;
    }

    public void setProductItem(String productItem) {
        this.productItem = productItem == null ? null : productItem.trim();
    }

    public String getProductItemDisplaycode() {
        return productItemDisplaycode;
    }

    public void setProductItemDisplaycode(String productItemDisplaycode) {
        this.productItemDisplaycode = productItemDisplaycode == null ? null : productItemDisplaycode.trim();
    }

    public String getProductIs3piece() {
        return productIs3piece;
    }

    public void setProductIs3piece(String productIs3piece) {
        this.productIs3piece = productIs3piece == null ? null : productIs3piece.trim();
    }

    public Integer getProductIs3pieceRtPrice() {
        return productIs3pieceRtPrice;
    }

    public void setProductIs3pieceRtPrice(Integer productIs3pieceRtPrice) {
        this.productIs3pieceRtPrice = productIs3pieceRtPrice;
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
        this.productSparePantsClass = productSparePantsClass == null ? null : productSparePantsClass.trim();
    }

    public Integer getProductSparePantsRtPrice() {
        return productSparePantsRtPrice;
    }

    public void setProductSparePantsRtPrice(Integer productSparePantsRtPrice) {
        this.productSparePantsRtPrice = productSparePantsRtPrice;
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
        this.productFabricNo = productFabricNo == null ? null : productFabricNo.trim();
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory == null ? null : productCategory.trim();
    }

    public String getProductBrandType() {
        return productBrandType;
    }

    public void setProductBrandType(String productBrandType) {
        this.productBrandType = productBrandType == null ? null : productBrandType.trim();
    }

    public String getProductBrandNm() {
        return productBrandNm;
    }

    public void setProductBrandNm(String productBrandNm) {
        this.productBrandNm = productBrandNm == null ? null : productBrandNm.trim();
    }

    public String getProductFabricNmNecessity() {
        return productFabricNmNecessity;
    }

    public void setProductFabricNmNecessity(String productFabricNmNecessity) {
        this.productFabricNmNecessity = productFabricNmNecessity == null ? null : productFabricNmNecessity.trim();
    }

    public String getProductEmbroideryNecessity() {
        return productEmbroideryNecessity;
    }

    public void setProductEmbroideryNecessity(String productEmbroideryNecessity) {
        this.productEmbroideryNecessity = productEmbroideryNecessity == null ? null : productEmbroideryNecessity.trim();
    }

    public String getProductEmbroideryNm() {
        return productEmbroideryNm;
    }

    public void setProductEmbroideryNm(String productEmbroideryNm) {
        this.productEmbroideryNm = productEmbroideryNm == null ? null : productEmbroideryNm.trim();
    }

    public String getProductEmbroideryFont() {
        return productEmbroideryFont;
    }

    public void setProductEmbroideryFont(String productEmbroideryFont) {
        this.productEmbroideryFont = productEmbroideryFont == null ? null : productEmbroideryFont.trim();
    }

    public String getProductEmbroideryThreadColor() {
        return productEmbroideryThreadColor;
    }

    public void setProductEmbroideryThreadColor(String productEmbroideryThreadColor) {
        this.productEmbroideryThreadColor = productEmbroideryThreadColor == null ? null : productEmbroideryThreadColor.trim();
    }

    public String getProductEmbroideryGazette() {
        return productEmbroideryGazette;
    }

    public void setProductEmbroideryGazette(String productEmbroideryGazette) {
        this.productEmbroideryGazette = productEmbroideryGazette == null ? null : productEmbroideryGazette.trim();
    }

    public Integer getProductEmbroideryGazetteRtPrice() {
        return productEmbroideryGazetteRtPrice;
    }

    public void setProductEmbroideryGazetteRtPrice(Integer productEmbroideryGazetteRtPrice) {
        this.productEmbroideryGazetteRtPrice = productEmbroideryGazetteRtPrice;
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
        this.productEmbroideryNmPos = productEmbroideryNmPos == null ? null : productEmbroideryNmPos.trim();
    }

    public Integer getProductEmbroideryNmPosRtPrice() {
        return productEmbroideryNmPosRtPrice;
    }

    public void setProductEmbroideryNmPosRtPrice(Integer productEmbroideryNmPosRtPrice) {
        this.productEmbroideryNmPosRtPrice = productEmbroideryNmPosRtPrice;
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
        this.productRemainingClothType = productRemainingClothType == null ? null : productRemainingClothType.trim();
    }

    public String getProductRemainingClothNm() {
        return productRemainingClothNm;
    }

    public void setProductRemainingClothNm(String productRemainingClothNm) {
        this.productRemainingClothNm = productRemainingClothNm == null ? null : productRemainingClothNm.trim();
    }

    public String getProductFabricBrandNm() {
        return productFabricBrandNm;
    }

    public void setProductFabricBrandNm(String productFabricBrandNm) {
        this.productFabricBrandNm = productFabricBrandNm == null ? null : productFabricBrandNm.trim();
    }

    public String getProductServiceNm() {
        return productServiceNm;
    }

    public void setProductServiceNm(String productServiceNm) {
        this.productServiceNm = productServiceNm == null ? null : productServiceNm.trim();
    }

    public String getProductComposFrtFabric() {
        return productComposFrtFabric;
    }

    public void setProductComposFrtFabric(String productComposFrtFabric) {
        this.productComposFrtFabric = productComposFrtFabric == null ? null : productComposFrtFabric.trim();
    }

    public String getProductComposBodyLiner() {
        return productComposBodyLiner;
    }

    public void setProductComposBodyLiner(String productComposBodyLiner) {
        this.productComposBodyLiner = productComposBodyLiner == null ? null : productComposBodyLiner.trim();
    }

    public String getProductComposSleeveLiner() {
        return productComposSleeveLiner;
    }

    public void setProductComposSleeveLiner(String productComposSleeveLiner) {
        this.productComposSleeveLiner = productComposSleeveLiner == null ? null : productComposSleeveLiner.trim();
    }

    public String getProductNotice() {
        return productNotice;
    }

    public void setProductNotice(String productNotice) {
        this.productNotice = productNotice == null ? null : productNotice.trim();
    }

    public String getProductFactoryCd() {
        return productFactoryCd;
    }

    public void setProductFactoryCd(String productFactoryCd) {
        this.productFactoryCd = productFactoryCd == null ? null : productFactoryCd.trim();
    }

    public String getProductMakerCode() {
        return productMakerCode;
    }

    public void setProductMakerCode(String productMakerCode) {
        this.productMakerCode = productMakerCode == null ? null : productMakerCode.trim();
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
        this.jkModelCd = jkModelCd == null ? null : jkModelCd.trim();
    }

    public String getJkModelNm() {
        return jkModelNm;
    }

    public void setJkModelNm(String jkModelNm) {
        this.jkModelNm = jkModelNm == null ? null : jkModelNm.trim();
    }

    public Integer getJkModelRtPrice() {
        return jkModelRtPrice;
    }

    public void setJkModelRtPrice(Integer jkModelRtPrice) {
        this.jkModelRtPrice = jkModelRtPrice;
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
        this.jkFrtBtnCd = jkFrtBtnCd == null ? null : jkFrtBtnCd.trim();
    }

    public String getJkFrtBtnNm() {
        return jkFrtBtnNm;
    }

    public void setJkFrtBtnNm(String jkFrtBtnNm) {
        this.jkFrtBtnNm = jkFrtBtnNm == null ? null : jkFrtBtnNm.trim();
    }

    public Integer getJkFrtBtnRtPrice() {
        return jkFrtBtnRtPrice;
    }

    public void setJkFrtBtnRtPrice(Integer jkFrtBtnRtPrice) {
        this.jkFrtBtnRtPrice = jkFrtBtnRtPrice;
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
        this.jkLapelDesignCd = jkLapelDesignCd == null ? null : jkLapelDesignCd.trim();
    }

    public String getJkLapelDesignNm() {
        return jkLapelDesignNm;
    }

    public void setJkLapelDesignNm(String jkLapelDesignNm) {
        this.jkLapelDesignNm = jkLapelDesignNm == null ? null : jkLapelDesignNm.trim();
    }

    public Integer getJkLapelDesignRtPrice() {
        return jkLapelDesignRtPrice;
    }

    public void setJkLapelDesignRtPrice(Integer jkLapelDesignRtPrice) {
        this.jkLapelDesignRtPrice = jkLapelDesignRtPrice;
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
        this.jkLapelModelCd = jkLapelModelCd == null ? null : jkLapelModelCd.trim();
    }

    public String getJkLapelModelNm() {
        return jkLapelModelNm;
    }

    public void setJkLapelModelNm(String jkLapelModelNm) {
        this.jkLapelModelNm = jkLapelModelNm == null ? null : jkLapelModelNm.trim();
    }

    public Integer getJkLapelModelRtPrice() {
        return jkLapelModelRtPrice;
    }

    public void setJkLapelModelRtPrice(Integer jkLapelModelRtPrice) {
        this.jkLapelModelRtPrice = jkLapelModelRtPrice;
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
        this.jkGradeCd = jkGradeCd == null ? null : jkGradeCd.trim();
    }

    public String getJkGradeNm() {
        return jkGradeNm;
    }

    public void setJkGradeNm(String jkGradeNm) {
        this.jkGradeNm = jkGradeNm == null ? null : jkGradeNm.trim();
    }

    public Integer getJkGradeRtPrice() {
        return jkGradeRtPrice;
    }

    public void setJkGradeRtPrice(Integer jkGradeRtPrice) {
        this.jkGradeRtPrice = jkGradeRtPrice;
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
        this.jkInnerClothCd = jkInnerClothCd == null ? null : jkInnerClothCd.trim();
    }

    public String getJkInnerClothNm() {
        return jkInnerClothNm;
    }

    public void setJkInnerClothNm(String jkInnerClothNm) {
        this.jkInnerClothNm = jkInnerClothNm == null ? null : jkInnerClothNm.trim();
    }

    public Integer getJkInnerClothRtPrice() {
        return jkInnerClothRtPrice;
    }

    public void setJkInnerClothRtPrice(Integer jkInnerClothRtPrice) {
        this.jkInnerClothRtPrice = jkInnerClothRtPrice;
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
        this.jkDaibaCd = jkDaibaCd == null ? null : jkDaibaCd.trim();
    }

    public String getJkDaibaNm() {
        return jkDaibaNm;
    }

    public void setJkDaibaNm(String jkDaibaNm) {
        this.jkDaibaNm = jkDaibaNm == null ? null : jkDaibaNm.trim();
    }

    public Integer getJkDaibaRtPrice() {
        return jkDaibaRtPrice;
    }

    public void setJkDaibaRtPrice(Integer jkDaibaRtPrice) {
        this.jkDaibaRtPrice = jkDaibaRtPrice;
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
        this.jkLookClothCd = jkLookClothCd == null ? null : jkLookClothCd.trim();
    }

    public String getJkLookClothNm() {
        return jkLookClothNm;
    }

    public void setJkLookClothNm(String jkLookClothNm) {
        this.jkLookClothNm = jkLookClothNm == null ? null : jkLookClothNm.trim();
    }

    public Integer getJkLookClothRtPrice() {
        return jkLookClothRtPrice;
    }

    public void setJkLookClothRtPrice(Integer jkLookClothRtPrice) {
        this.jkLookClothRtPrice = jkLookClothRtPrice;
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
        this.jkCollarInnerCd = jkCollarInnerCd == null ? null : jkCollarInnerCd.trim();
    }

    public String getJkCollarInnerNm() {
        return jkCollarInnerNm;
    }

    public void setJkCollarInnerNm(String jkCollarInnerNm) {
        this.jkCollarInnerNm = jkCollarInnerNm == null ? null : jkCollarInnerNm.trim();
    }

    public Integer getJkCollarInnerRtPrice() {
        return jkCollarInnerRtPrice;
    }

    public void setJkCollarInnerRtPrice(Integer jkCollarInnerRtPrice) {
        this.jkCollarInnerRtPrice = jkCollarInnerRtPrice;
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
        this.jkCollarHangCd = jkCollarHangCd == null ? null : jkCollarHangCd.trim();
    }

    public String getJkCollarHangNm() {
        return jkCollarHangNm;
    }

    public void setJkCollarHangNm(String jkCollarHangNm) {
        this.jkCollarHangNm = jkCollarHangNm == null ? null : jkCollarHangNm.trim();
    }

    public Integer getJkCollarHangRtPrice() {
        return jkCollarHangRtPrice;
    }

    public void setJkCollarHangRtPrice(Integer jkCollarHangRtPrice) {
        this.jkCollarHangRtPrice = jkCollarHangRtPrice;
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
        this.jkLapelWidthCd = jkLapelWidthCd == null ? null : jkLapelWidthCd.trim();
    }

    public String getJkLapelWidthNm() {
        return jkLapelWidthNm;
    }

    public void setJkLapelWidthNm(String jkLapelWidthNm) {
        this.jkLapelWidthNm = jkLapelWidthNm == null ? null : jkLapelWidthNm.trim();
    }

    public Integer getJkLapelWidthRtPrice() {
        return jkLapelWidthRtPrice;
    }

    public void setJkLapelWidthRtPrice(Integer jkLapelWidthRtPrice) {
        this.jkLapelWidthRtPrice = jkLapelWidthRtPrice;
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
        this.jkFlowerHoleCd = jkFlowerHoleCd == null ? null : jkFlowerHoleCd.trim();
    }

    public String getJkFlowerHoleNm() {
        return jkFlowerHoleNm;
    }

    public void setJkFlowerHoleNm(String jkFlowerHoleNm) {
        this.jkFlowerHoleNm = jkFlowerHoleNm == null ? null : jkFlowerHoleNm.trim();
    }

    public Integer getJkFlowerHoleRtPrice() {
        return jkFlowerHoleRtPrice;
    }

    public void setJkFlowerHoleRtPrice(Integer jkFlowerHoleRtPrice) {
        this.jkFlowerHoleRtPrice = jkFlowerHoleRtPrice;
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
        this.jkBreastPktCd = jkBreastPktCd == null ? null : jkBreastPktCd.trim();
    }

    public String getJkBreastPktNm() {
        return jkBreastPktNm;
    }

    public void setJkBreastPktNm(String jkBreastPktNm) {
        this.jkBreastPktNm = jkBreastPktNm == null ? null : jkBreastPktNm.trim();
    }

    public Integer getJkBreastPktRtPrice() {
        return jkBreastPktRtPrice;
    }

    public void setJkBreastPktRtPrice(Integer jkBreastPktRtPrice) {
        this.jkBreastPktRtPrice = jkBreastPktRtPrice;
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
        this.jkWaistPktCd = jkWaistPktCd == null ? null : jkWaistPktCd.trim();
    }

    public String getJkWaistPktNm() {
        return jkWaistPktNm;
    }

    public void setJkWaistPktNm(String jkWaistPktNm) {
        this.jkWaistPktNm = jkWaistPktNm == null ? null : jkWaistPktNm.trim();
    }

    public Integer getJkWaistPktRtPrice() {
        return jkWaistPktRtPrice;
    }

    public void setJkWaistPktRtPrice(Integer jkWaistPktRtPrice) {
        this.jkWaistPktRtPrice = jkWaistPktRtPrice;
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
        this.jkChgPktCd = jkChgPktCd == null ? null : jkChgPktCd.trim();
    }

    public String getJkChgPktNm() {
        return jkChgPktNm;
    }

    public void setJkChgPktNm(String jkChgPktNm) {
        this.jkChgPktNm = jkChgPktNm == null ? null : jkChgPktNm.trim();
    }

    public Integer getJkChgPktRtPrice() {
        return jkChgPktRtPrice;
    }

    public void setJkChgPktRtPrice(Integer jkChgPktRtPrice) {
        this.jkChgPktRtPrice = jkChgPktRtPrice;
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
        this.jkSlantedPktCd = jkSlantedPktCd == null ? null : jkSlantedPktCd.trim();
    }

    public String getJkSlantedPktNm() {
        return jkSlantedPktNm;
    }

    public void setJkSlantedPktNm(String jkSlantedPktNm) {
        this.jkSlantedPktNm = jkSlantedPktNm == null ? null : jkSlantedPktNm.trim();
    }

    public Integer getJkSlantedPktRtPrice() {
        return jkSlantedPktRtPrice;
    }

    public void setJkSlantedPktRtPrice(Integer jkSlantedPktRtPrice) {
        this.jkSlantedPktRtPrice = jkSlantedPktRtPrice;
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
        this.jkShinobiPktCd = jkShinobiPktCd == null ? null : jkShinobiPktCd.trim();
    }

    public String getJkShinobiPktNm() {
        return jkShinobiPktNm;
    }

    public void setJkShinobiPktNm(String jkShinobiPktNm) {
        this.jkShinobiPktNm = jkShinobiPktNm == null ? null : jkShinobiPktNm.trim();
    }

    public Integer getJkShinobiPktRtPrice() {
        return jkShinobiPktRtPrice;
    }

    public void setJkShinobiPktRtPrice(Integer jkShinobiPktRtPrice) {
        this.jkShinobiPktRtPrice = jkShinobiPktRtPrice;
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
        this.jkSleeveTypeCd = jkSleeveTypeCd == null ? null : jkSleeveTypeCd.trim();
    }

    public String getJkSleeveTypeNm() {
        return jkSleeveTypeNm;
    }

    public void setJkSleeveTypeNm(String jkSleeveTypeNm) {
        this.jkSleeveTypeNm = jkSleeveTypeNm == null ? null : jkSleeveTypeNm.trim();
    }

    public Integer getJkSleeveTypeRtPrice() {
        return jkSleeveTypeRtPrice;
    }

    public void setJkSleeveTypeRtPrice(Integer jkSleeveTypeRtPrice) {
        this.jkSleeveTypeRtPrice = jkSleeveTypeRtPrice;
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
        this.jkManicaCd = jkManicaCd == null ? null : jkManicaCd.trim();
    }

    public String getJkManicaNm() {
        return jkManicaNm;
    }

    public void setJkManicaNm(String jkManicaNm) {
        this.jkManicaNm = jkManicaNm == null ? null : jkManicaNm.trim();
    }

    public Integer getJkManicaRtPrice() {
        return jkManicaRtPrice;
    }

    public void setJkManicaRtPrice(Integer jkManicaRtPrice) {
        this.jkManicaRtPrice = jkManicaRtPrice;
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
        this.jkSleeveBtnType = jkSleeveBtnType == null ? null : jkSleeveBtnType.trim();
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
        this.jkSleeveBtnCd = jkSleeveBtnCd == null ? null : jkSleeveBtnCd.trim();
    }

    public String getJkSleeveBtnNm() {
        return jkSleeveBtnNm;
    }

    public void setJkSleeveBtnNm(String jkSleeveBtnNm) {
        this.jkSleeveBtnNm = jkSleeveBtnNm == null ? null : jkSleeveBtnNm.trim();
    }

    public Integer getJkSleeveBtnRtPrice() {
        return jkSleeveBtnRtPrice;
    }

    public void setJkSleeveBtnRtPrice(Integer jkSleeveBtnRtPrice) {
        this.jkSleeveBtnRtPrice = jkSleeveBtnRtPrice;
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
        this.jkCuffCd = jkCuffCd == null ? null : jkCuffCd.trim();
    }

    public String getJkCuffNm() {
        return jkCuffNm;
    }

    public void setJkCuffNm(String jkCuffNm) {
        this.jkCuffNm = jkCuffNm == null ? null : jkCuffNm.trim();
    }

    public Integer getJkCuffRtPrice() {
        return jkCuffRtPrice;
    }

    public void setJkCuffRtPrice(Integer jkCuffRtPrice) {
        this.jkCuffRtPrice = jkCuffRtPrice;
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
        this.jkInnerPktType = jkInnerPktType == null ? null : jkInnerPktType.trim();
    }

    public String getJkInnerPktCd() {
        return jkInnerPktCd;
    }

    public void setJkInnerPktCd(String jkInnerPktCd) {
        this.jkInnerPktCd = jkInnerPktCd == null ? null : jkInnerPktCd.trim();
    }

    public String getJkInnerPktNm() {
        return jkInnerPktNm;
    }

    public void setJkInnerPktNm(String jkInnerPktNm) {
        this.jkInnerPktNm = jkInnerPktNm == null ? null : jkInnerPktNm.trim();
    }

    public Integer getJkInnerPktRtPrice() {
        return jkInnerPktRtPrice;
    }

    public void setJkInnerPktRtPrice(Integer jkInnerPktRtPrice) {
        this.jkInnerPktRtPrice = jkInnerPktRtPrice;
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
        this.jkRightInnerPktTypeCd = jkRightInnerPktTypeCd == null ? null : jkRightInnerPktTypeCd.trim();
    }

    public String getJkRightInnerPktTypeNm() {
        return jkRightInnerPktTypeNm;
    }

    public void setJkRightInnerPktTypeNm(String jkRightInnerPktTypeNm) {
        this.jkRightInnerPktTypeNm = jkRightInnerPktTypeNm == null ? null : jkRightInnerPktTypeNm.trim();
    }

    public Integer getJkRightInnerPktTypeRtPrice() {
        return jkRightInnerPktTypeRtPrice;
    }

    public void setJkRightInnerPktTypeRtPrice(Integer jkRightInnerPktTypeRtPrice) {
        this.jkRightInnerPktTypeRtPrice = jkRightInnerPktTypeRtPrice;
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
        this.jkStitchTypeCd = jkStitchTypeCd == null ? null : jkStitchTypeCd.trim();
    }

    public String getJkStitchTypeNm() {
        return jkStitchTypeNm;
    }

    public void setJkStitchTypeNm(String jkStitchTypeNm) {
        this.jkStitchTypeNm = jkStitchTypeNm == null ? null : jkStitchTypeNm.trim();
    }

    public Integer getJkStitchTypeRtPrice() {
        return jkStitchTypeRtPrice;
    }

    public void setJkStitchTypeRtPrice(Integer jkStitchTypeRtPrice) {
        this.jkStitchTypeRtPrice = jkStitchTypeRtPrice;
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
        this.jkStitchPlcType = jkStitchPlcType == null ? null : jkStitchPlcType.trim();
    }

    public String getJkStitchPlcCd() {
        return jkStitchPlcCd;
    }

    public void setJkStitchPlcCd(String jkStitchPlcCd) {
        this.jkStitchPlcCd = jkStitchPlcCd == null ? null : jkStitchPlcCd.trim();
    }

    public String getJkStitchPlcNm() {
        return jkStitchPlcNm;
    }

    public void setJkStitchPlcNm(String jkStitchPlcNm) {
        this.jkStitchPlcNm = jkStitchPlcNm == null ? null : jkStitchPlcNm.trim();
    }

    public Integer getJkStitchPlcRtPrice() {
        return jkStitchPlcRtPrice;
    }

    public void setJkStitchPlcRtPrice(Integer jkStitchPlcRtPrice) {
        this.jkStitchPlcRtPrice = jkStitchPlcRtPrice;
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
        this.jkDblstitchPlcType = jkDblstitchPlcType == null ? null : jkDblstitchPlcType.trim();
    }

    public String getJkDblstitchPlcCd() {
        return jkDblstitchPlcCd;
    }

    public void setJkDblstitchPlcCd(String jkDblstitchPlcCd) {
        this.jkDblstitchPlcCd = jkDblstitchPlcCd == null ? null : jkDblstitchPlcCd.trim();
    }

    public String getJkDblstitchPlcNm() {
        return jkDblstitchPlcNm;
    }

    public void setJkDblstitchPlcNm(String jkDblstitchPlcNm) {
        this.jkDblstitchPlcNm = jkDblstitchPlcNm == null ? null : jkDblstitchPlcNm.trim();
    }

    public Integer getJkDblstitchPlcRtPrice() {
        return jkDblstitchPlcRtPrice;
    }

    public void setJkDblstitchPlcRtPrice(Integer jkDblstitchPlcRtPrice) {
        this.jkDblstitchPlcRtPrice = jkDblstitchPlcRtPrice;
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
        this.jkAmfColorType = jkAmfColorType == null ? null : jkAmfColorType.trim();
    }

    public String getJkAmfColorPlcCd() {
        return jkAmfColorPlcCd;
    }

    public void setJkAmfColorPlcCd(String jkAmfColorPlcCd) {
        this.jkAmfColorPlcCd = jkAmfColorPlcCd == null ? null : jkAmfColorPlcCd.trim();
    }

    public String getJkAmfColorPlcNm() {
        return jkAmfColorPlcNm;
    }

    public void setJkAmfColorPlcNm(String jkAmfColorPlcNm) {
        this.jkAmfColorPlcNm = jkAmfColorPlcNm == null ? null : jkAmfColorPlcNm.trim();
    }

    public String getJkAmfColorCd() {
        return jkAmfColorCd;
    }

    public void setJkAmfColorCd(String jkAmfColorCd) {
        this.jkAmfColorCd = jkAmfColorCd == null ? null : jkAmfColorCd.trim();
    }

    public String getJkAmfColorNm() {
        return jkAmfColorNm;
    }

    public void setJkAmfColorNm(String jkAmfColorNm) {
        this.jkAmfColorNm = jkAmfColorNm == null ? null : jkAmfColorNm.trim();
    }

    public Integer getJkAmfColorRtPrice() {
        return jkAmfColorRtPrice;
    }

    public void setJkAmfColorRtPrice(Integer jkAmfColorRtPrice) {
        this.jkAmfColorRtPrice = jkAmfColorRtPrice;
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
        this.jkBtnholeColorType = jkBtnholeColorType == null ? null : jkBtnholeColorType.trim();
    }

    public String getJkBtnholeColorPlcCd() {
        return jkBtnholeColorPlcCd;
    }

    public void setJkBtnholeColorPlcCd(String jkBtnholeColorPlcCd) {
        this.jkBtnholeColorPlcCd = jkBtnholeColorPlcCd == null ? null : jkBtnholeColorPlcCd.trim();
    }

    public String getJkBtnholeColorPlcN() {
        return jkBtnholeColorPlcN;
    }

    public void setJkBtnholeColorPlcN(String jkBtnholeColorPlcN) {
        this.jkBtnholeColorPlcN = jkBtnholeColorPlcN == null ? null : jkBtnholeColorPlcN.trim();
    }

    public String getJkBtnholeColorCd() {
        return jkBtnholeColorCd;
    }

    public void setJkBtnholeColorCd(String jkBtnholeColorCd) {
        this.jkBtnholeColorCd = jkBtnholeColorCd == null ? null : jkBtnholeColorCd.trim();
    }

    public String getJkBtnholeColorNm() {
        return jkBtnholeColorNm;
    }

    public void setJkBtnholeColorNm(String jkBtnholeColorNm) {
        this.jkBtnholeColorNm = jkBtnholeColorNm == null ? null : jkBtnholeColorNm.trim();
    }

    public Integer getJkBtnholePlcColorRtPrice() {
        return jkBtnholePlcColorRtPrice;
    }

    public void setJkBtnholePlcColorRtPrice(Integer jkBtnholePlcColorRtPrice) {
        this.jkBtnholePlcColorRtPrice = jkBtnholePlcColorRtPrice;
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
        this.jkBtnthreadColorType = jkBtnthreadColorType == null ? null : jkBtnthreadColorType.trim();
    }

    public String getJkBtnthreadColorPlcCd() {
        return jkBtnthreadColorPlcCd;
    }

    public void setJkBtnthreadColorPlcCd(String jkBtnthreadColorPlcCd) {
        this.jkBtnthreadColorPlcCd = jkBtnthreadColorPlcCd == null ? null : jkBtnthreadColorPlcCd.trim();
    }

    public String getJkBtnthreadColorPlcN() {
        return jkBtnthreadColorPlcN;
    }

    public void setJkBtnthreadColorPlcN(String jkBtnthreadColorPlcN) {
        this.jkBtnthreadColorPlcN = jkBtnthreadColorPlcN == null ? null : jkBtnthreadColorPlcN.trim();
    }

    public String getJkBtnthreadColorCd() {
        return jkBtnthreadColorCd;
    }

    public void setJkBtnthreadColorCd(String jkBtnthreadColorCd) {
        this.jkBtnthreadColorCd = jkBtnthreadColorCd == null ? null : jkBtnthreadColorCd.trim();
    }

    public String getJkBtnthreadColorNm() {
        return jkBtnthreadColorNm;
    }

    public void setJkBtnthreadColorNm(String jkBtnthreadColorNm) {
        this.jkBtnthreadColorNm = jkBtnthreadColorNm == null ? null : jkBtnthreadColorNm.trim();
    }

    public Integer getJkBtnthreadPlcColorRtPrice() {
        return jkBtnthreadPlcColorRtPrice;
    }

    public void setJkBtnthreadPlcColorRtPrice(Integer jkBtnthreadPlcColorRtPrice) {
        this.jkBtnthreadPlcColorRtPrice = jkBtnthreadPlcColorRtPrice;
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
        this.jkVentCd = jkVentCd == null ? null : jkVentCd.trim();
    }

    public String getJkVentNm() {
        return jkVentNm;
    }

    public void setJkVentNm(String jkVentNm) {
        this.jkVentNm = jkVentNm == null ? null : jkVentNm.trim();
    }

    public Integer getJkVentRtPrice() {
        return jkVentRtPrice;
    }

    public void setJkVentRtPrice(Integer jkVentRtPrice) {
        this.jkVentRtPrice = jkVentRtPrice;
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
        this.jkInnerBodyClothType = jkInnerBodyClothType == null ? null : jkInnerBodyClothType.trim();
    }

    public String getJkInnerBodyClothCd() {
        return jkInnerBodyClothCd;
    }

    public void setJkInnerBodyClothCd(String jkInnerBodyClothCd) {
        this.jkInnerBodyClothCd = jkInnerBodyClothCd == null ? null : jkInnerBodyClothCd.trim();
    }

    public String getJkInnerBodyClothNm() {
        return jkInnerBodyClothNm;
    }

    public void setJkInnerBodyClothNm(String jkInnerBodyClothNm) {
        this.jkInnerBodyClothNm = jkInnerBodyClothNm == null ? null : jkInnerBodyClothNm.trim();
    }

    public Integer getJkInnerBodyClothRtPrice() {
        return jkInnerBodyClothRtPrice;
    }

    public void setJkInnerBodyClothRtPrice(Integer jkInnerBodyClothRtPrice) {
        this.jkInnerBodyClothRtPrice = jkInnerBodyClothRtPrice;
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
        this.jkInnerSleeveClothType = jkInnerSleeveClothType == null ? null : jkInnerSleeveClothType.trim();
    }

    public String getJkInnerSleeveClothCd() {
        return jkInnerSleeveClothCd;
    }

    public void setJkInnerSleeveClothCd(String jkInnerSleeveClothCd) {
        this.jkInnerSleeveClothCd = jkInnerSleeveClothCd == null ? null : jkInnerSleeveClothCd.trim();
    }

    public String getJkInnerSleeveClothNm() {
        return jkInnerSleeveClothNm;
    }

    public void setJkInnerSleeveClothNm(String jkInnerSleeveClothNm) {
        this.jkInnerSleeveClothNm = jkInnerSleeveClothNm == null ? null : jkInnerSleeveClothNm.trim();
    }

    public Integer getJkInnerSleeveClothRtPrice() {
        return jkInnerSleeveClothRtPrice;
    }

    public void setJkInnerSleeveClothRtPrice(Integer jkInnerSleeveClothRtPrice) {
        this.jkInnerSleeveClothRtPrice = jkInnerSleeveClothRtPrice;
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
        this.jkBtnMaterialType = jkBtnMaterialType == null ? null : jkBtnMaterialType.trim();
    }

    public String getJkBtnMaterialCd() {
        return jkBtnMaterialCd;
    }

    public void setJkBtnMaterialCd(String jkBtnMaterialCd) {
        this.jkBtnMaterialCd = jkBtnMaterialCd == null ? null : jkBtnMaterialCd.trim();
    }

    public String getJkBtnMaterialNm() {
        return jkBtnMaterialNm;
    }

    public void setJkBtnMaterialNm(String jkBtnMaterialNm) {
        this.jkBtnMaterialNm = jkBtnMaterialNm == null ? null : jkBtnMaterialNm.trim();
    }

    public Integer getJkBtnMaterialRtPrice() {
        return jkBtnMaterialRtPrice;
    }

    public void setJkBtnMaterialRtPrice(Integer jkBtnMaterialRtPrice) {
        this.jkBtnMaterialRtPrice = jkBtnMaterialRtPrice;
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
        this.jkShapeMemoryCd = jkShapeMemoryCd == null ? null : jkShapeMemoryCd.trim();
    }

    public String getJkShapeMemoryNm() {
        return jkShapeMemoryNm;
    }

    public void setJkShapeMemoryNm(String jkShapeMemoryNm) {
        this.jkShapeMemoryNm = jkShapeMemoryNm == null ? null : jkShapeMemoryNm.trim();
    }

    public Integer getJkShapeMemoryRtPrice() {
        return jkShapeMemoryRtPrice;
    }

    public void setJkShapeMemoryRtPrice(Integer jkShapeMemoryRtPrice) {
        this.jkShapeMemoryRtPrice = jkShapeMemoryRtPrice;
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
        this.ptModelCd = ptModelCd == null ? null : ptModelCd.trim();
    }

    public String getPtModelNm() {
        return ptModelNm;
    }

    public void setPtModelNm(String ptModelNm) {
        this.ptModelNm = ptModelNm == null ? null : ptModelNm.trim();
    }

    public Integer getPtModelRtPrice() {
        return ptModelRtPrice;
    }

    public void setPtModelRtPrice(Integer ptModelRtPrice) {
        this.ptModelRtPrice = ptModelRtPrice;
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
        this.ptTackCd = ptTackCd == null ? null : ptTackCd.trim();
    }

    public String getPtTackNm() {
        return ptTackNm;
    }

    public void setPtTackNm(String ptTackNm) {
        this.ptTackNm = ptTackNm == null ? null : ptTackNm.trim();
    }

    public Integer getPtTackRtPrice() {
        return ptTackRtPrice;
    }

    public void setPtTackRtPrice(Integer ptTackRtPrice) {
        this.ptTackRtPrice = ptTackRtPrice;
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
        this.ptKneeinnerTypeCd = ptKneeinnerTypeCd == null ? null : ptKneeinnerTypeCd.trim();
    }

    public String getPtKneeinnerTypeNm() {
        return ptKneeinnerTypeNm;
    }

    public void setPtKneeinnerTypeNm(String ptKneeinnerTypeNm) {
        this.ptKneeinnerTypeNm = ptKneeinnerTypeNm == null ? null : ptKneeinnerTypeNm.trim();
    }

    public Integer getPtKneeinnerTypeRtPrice() {
        return ptKneeinnerTypeRtPrice;
    }

    public void setPtKneeinnerTypeRtPrice(Integer ptKneeinnerTypeRtPrice) {
        this.ptKneeinnerTypeRtPrice = ptKneeinnerTypeRtPrice;
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
        this.ptKneeinnerClothCd = ptKneeinnerClothCd == null ? null : ptKneeinnerClothCd.trim();
    }

    public String getPtKneeinnerClothNm() {
        return ptKneeinnerClothNm;
    }

    public void setPtKneeinnerClothNm(String ptKneeinnerClothNm) {
        this.ptKneeinnerClothNm = ptKneeinnerClothNm == null ? null : ptKneeinnerClothNm.trim();
    }

    public Integer getPtKneeinnerClothRtPrice() {
        return ptKneeinnerClothRtPrice;
    }

    public void setPtKneeinnerClothRtPrice(Integer ptKneeinnerClothRtPrice) {
        this.ptKneeinnerClothRtPrice = ptKneeinnerClothRtPrice;
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
        this.ptFrtTypeCd = ptFrtTypeCd == null ? null : ptFrtTypeCd.trim();
    }

    public String getPtFrtTypeNm() {
        return ptFrtTypeNm;
    }

    public void setPtFrtTypeNm(String ptFrtTypeNm) {
        this.ptFrtTypeNm = ptFrtTypeNm == null ? null : ptFrtTypeNm.trim();
    }

    public Integer getPtFrtTypeRtPrice() {
        return ptFrtTypeRtPrice;
    }

    public void setPtFrtTypeRtPrice(Integer ptFrtTypeRtPrice) {
        this.ptFrtTypeRtPrice = ptFrtTypeRtPrice;
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
        this.ptPancherinaCd = ptPancherinaCd == null ? null : ptPancherinaCd.trim();
    }

    public String getPtPancherinaNm() {
        return ptPancherinaNm;
    }

    public void setPtPancherinaNm(String ptPancherinaNm) {
        this.ptPancherinaNm = ptPancherinaNm == null ? null : ptPancherinaNm.trim();
    }

    public Integer getPtPancherinaRtPrice() {
        return ptPancherinaRtPrice;
    }

    public void setPtPancherinaRtPrice(Integer ptPancherinaRtPrice) {
        this.ptPancherinaRtPrice = ptPancherinaRtPrice;
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
        this.ptAdjusterCd = ptAdjusterCd == null ? null : ptAdjusterCd.trim();
    }

    public String getPtAdjusterNm() {
        return ptAdjusterNm;
    }

    public void setPtAdjusterNm(String ptAdjusterNm) {
        this.ptAdjusterNm = ptAdjusterNm == null ? null : ptAdjusterNm.trim();
    }

    public Integer getPtAdjusterRtPrice() {
        return ptAdjusterRtPrice;
    }

    public void setPtAdjusterRtPrice(Integer ptAdjusterRtPrice) {
        this.ptAdjusterRtPrice = ptAdjusterRtPrice;
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
        this.ptBeltloopType = ptBeltloopType == null ? null : ptBeltloopType.trim();
    }

    public String getPtBeltloopCd() {
        return ptBeltloopCd;
    }

    public void setPtBeltloopCd(String ptBeltloopCd) {
        this.ptBeltloopCd = ptBeltloopCd == null ? null : ptBeltloopCd.trim();
    }

    public String getPtBeltloopNm() {
        return ptBeltloopNm;
    }

    public void setPtBeltloopNm(String ptBeltloopNm) {
        this.ptBeltloopNm = ptBeltloopNm == null ? null : ptBeltloopNm.trim();
    }

    public Integer getPtBeltloopRtPrice() {
        return ptBeltloopRtPrice;
    }

    public void setPtBeltloopRtPrice(Integer ptBeltloopRtPrice) {
        this.ptBeltloopRtPrice = ptBeltloopRtPrice;
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
        this.ptPinloopCd = ptPinloopCd == null ? null : ptPinloopCd.trim();
    }

    public String getPtPinloopNm() {
        return ptPinloopNm;
    }

    public void setPtPinloopNm(String ptPinloopNm) {
        this.ptPinloopNm = ptPinloopNm == null ? null : ptPinloopNm.trim();
    }

    public Integer getPtPinloopRtPrice() {
        return ptPinloopRtPrice;
    }

    public void setPtPinloopRtPrice(Integer ptPinloopRtPrice) {
        this.ptPinloopRtPrice = ptPinloopRtPrice;
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
        this.ptSidePktCd = ptSidePktCd == null ? null : ptSidePktCd.trim();
    }

    public String getPtSidePktNm() {
        return ptSidePktNm;
    }

    public void setPtSidePktNm(String ptSidePktNm) {
        this.ptSidePktNm = ptSidePktNm == null ? null : ptSidePktNm.trim();
    }

    public Integer getPtSidePktRtPrice() {
        return ptSidePktRtPrice;
    }

    public void setPtSidePktRtPrice(Integer ptSidePktRtPrice) {
        this.ptSidePktRtPrice = ptSidePktRtPrice;
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
        this.ptShinobiPktCd = ptShinobiPktCd == null ? null : ptShinobiPktCd.trim();
    }

    public String getPtShinobiPktNm() {
        return ptShinobiPktNm;
    }

    public void setPtShinobiPktNm(String ptShinobiPktNm) {
        this.ptShinobiPktNm = ptShinobiPktNm == null ? null : ptShinobiPktNm.trim();
    }

    public Integer getPtShinobiPktRtPrice() {
        return ptShinobiPktRtPrice;
    }

    public void setPtShinobiPktRtPrice(Integer ptShinobiPktRtPrice) {
        this.ptShinobiPktRtPrice = ptShinobiPktRtPrice;
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
        this.ptCoinPktCd = ptCoinPktCd == null ? null : ptCoinPktCd.trim();
    }

    public String getPtCoinPktNm() {
        return ptCoinPktNm;
    }

    public void setPtCoinPktNm(String ptCoinPktNm) {
        this.ptCoinPktNm = ptCoinPktNm == null ? null : ptCoinPktNm.trim();
    }

    public Integer getPtCoinPktRtPrice() {
        return ptCoinPktRtPrice;
    }

    public void setPtCoinPktRtPrice(Integer ptCoinPktRtPrice) {
        this.ptCoinPktRtPrice = ptCoinPktRtPrice;
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
        this.ptFlapcoinPktCd = ptFlapcoinPktCd == null ? null : ptFlapcoinPktCd.trim();
    }

    public String getPtFlapcoinPktNm() {
        return ptFlapcoinPktNm;
    }

    public void setPtFlapcoinPktNm(String ptFlapcoinPktNm) {
        this.ptFlapcoinPktNm = ptFlapcoinPktNm == null ? null : ptFlapcoinPktNm.trim();
    }

    public Integer getPtFlapcoinPktRtPrice() {
        return ptFlapcoinPktRtPrice;
    }

    public void setPtFlapcoinPktRtPrice(Integer ptFlapcoinPktRtPrice) {
        this.ptFlapcoinPktRtPrice = ptFlapcoinPktRtPrice;
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
        this.ptLeftPisPktCd = ptLeftPisPktCd == null ? null : ptLeftPisPktCd.trim();
    }

    public String getPtLeftPisPktNm() {
        return ptLeftPisPktNm;
    }

    public void setPtLeftPisPktNm(String ptLeftPisPktNm) {
        this.ptLeftPisPktNm = ptLeftPisPktNm == null ? null : ptLeftPisPktNm.trim();
    }

    public Integer getPtLeftPisPktRtPrice() {
        return ptLeftPisPktRtPrice;
    }

    public void setPtLeftPisPktRtPrice(Integer ptLeftPisPktRtPrice) {
        this.ptLeftPisPktRtPrice = ptLeftPisPktRtPrice;
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
        this.ptRightPisPktCd = ptRightPisPktCd == null ? null : ptRightPisPktCd.trim();
    }

    public String getPtRightPisPktNm() {
        return ptRightPisPktNm;
    }

    public void setPtRightPisPktNm(String ptRightPisPktNm) {
        this.ptRightPisPktNm = ptRightPisPktNm == null ? null : ptRightPisPktNm.trim();
    }

    public Integer getPtRightPisPktRtPrice() {
        return ptRightPisPktRtPrice;
    }

    public void setPtRightPisPktRtPrice(Integer ptRightPisPktRtPrice) {
        this.ptRightPisPktRtPrice = ptRightPisPktRtPrice;
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
        this.ptVCutCd = ptVCutCd == null ? null : ptVCutCd.trim();
    }

    public String getPtVCutNm() {
        return ptVCutNm;
    }

    public void setPtVCutNm(String ptVCutNm) {
        this.ptVCutNm = ptVCutNm == null ? null : ptVCutNm.trim();
    }

    public Integer getPtVCutRtPrice() {
        return ptVCutRtPrice;
    }

    public void setPtVCutRtPrice(Integer ptVCutRtPrice) {
        this.ptVCutRtPrice = ptVCutRtPrice;
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
        this.ptHemUpCd = ptHemUpCd == null ? null : ptHemUpCd.trim();
    }

    public String getPtHemUpNm() {
        return ptHemUpNm;
    }

    public void setPtHemUpNm(String ptHemUpNm) {
        this.ptHemUpNm = ptHemUpNm == null ? null : ptHemUpNm.trim();
    }

    public Integer getPtHemUpRtPrice() {
        return ptHemUpRtPrice;
    }

    public void setPtHemUpRtPrice(Integer ptHemUpRtPrice) {
        this.ptHemUpRtPrice = ptHemUpRtPrice;
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
        this.ptDblWidthCd = ptDblWidthCd == null ? null : ptDblWidthCd.trim();
    }

    public String getPtDblWidthNm() {
        return ptDblWidthNm;
    }

    public void setPtDblWidthNm(String ptDblWidthNm) {
        this.ptDblWidthNm = ptDblWidthNm == null ? null : ptDblWidthNm.trim();
    }

    public Integer getPtDblWidthRtPrice() {
        return ptDblWidthRtPrice;
    }

    public void setPtDblWidthRtPrice(Integer ptDblWidthRtPrice) {
        this.ptDblWidthRtPrice = ptDblWidthRtPrice;
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
        this.ptAmfStitchCd = ptAmfStitchCd == null ? null : ptAmfStitchCd.trim();
    }

    public String getPtAmfStitchNm() {
        return ptAmfStitchNm;
    }

    public void setPtAmfStitchNm(String ptAmfStitchNm) {
        this.ptAmfStitchNm = ptAmfStitchNm == null ? null : ptAmfStitchNm.trim();
    }

    public Integer getPtAmfStitchRtPrice() {
        return ptAmfStitchRtPrice;
    }

    public void setPtAmfStitchRtPrice(Integer ptAmfStitchRtPrice) {
        this.ptAmfStitchRtPrice = ptAmfStitchRtPrice;
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
        this.ptStitchPlcType = ptStitchPlcType == null ? null : ptStitchPlcType.trim();
    }

    public String getPtStitchPlcCd() {
        return ptStitchPlcCd;
    }

    public void setPtStitchPlcCd(String ptStitchPlcCd) {
        this.ptStitchPlcCd = ptStitchPlcCd == null ? null : ptStitchPlcCd.trim();
    }

    public String getPtStitchPlcNm() {
        return ptStitchPlcNm;
    }

    public void setPtStitchPlcNm(String ptStitchPlcNm) {
        this.ptStitchPlcNm = ptStitchPlcNm == null ? null : ptStitchPlcNm.trim();
    }

    public Integer getPtStitchPlcRtPrice() {
        return ptStitchPlcRtPrice;
    }

    public void setPtStitchPlcRtPrice(Integer ptStitchPlcRtPrice) {
        this.ptStitchPlcRtPrice = ptStitchPlcRtPrice;
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
        this.ptDblstitchPlcType = ptDblstitchPlcType == null ? null : ptDblstitchPlcType.trim();
    }

    public String getPtDblstitchPlcCd() {
        return ptDblstitchPlcCd;
    }

    public void setPtDblstitchPlcCd(String ptDblstitchPlcCd) {
        this.ptDblstitchPlcCd = ptDblstitchPlcCd == null ? null : ptDblstitchPlcCd.trim();
    }

    public String getPtDblstitchPlcNm() {
        return ptDblstitchPlcNm;
    }

    public void setPtDblstitchPlcNm(String ptDblstitchPlcNm) {
        this.ptDblstitchPlcNm = ptDblstitchPlcNm == null ? null : ptDblstitchPlcNm.trim();
    }

    public Integer getPtDblstitchPlcRtPrice() {
        return ptDblstitchPlcRtPrice;
    }

    public void setPtDblstitchPlcRtPrice(Integer ptDblstitchPlcRtPrice) {
        this.ptDblstitchPlcRtPrice = ptDblstitchPlcRtPrice;
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
        this.ptAmfColorType = ptAmfColorType == null ? null : ptAmfColorType.trim();
    }

    public String getPtAmfColorPlcCd() {
        return ptAmfColorPlcCd;
    }

    public void setPtAmfColorPlcCd(String ptAmfColorPlcCd) {
        this.ptAmfColorPlcCd = ptAmfColorPlcCd == null ? null : ptAmfColorPlcCd.trim();
    }

    public String getPtAmfColorPlcNm() {
        return ptAmfColorPlcNm;
    }

    public void setPtAmfColorPlcNm(String ptAmfColorPlcNm) {
        this.ptAmfColorPlcNm = ptAmfColorPlcNm == null ? null : ptAmfColorPlcNm.trim();
    }

    public String getPtAmfColorCd() {
        return ptAmfColorCd;
    }

    public void setPtAmfColorCd(String ptAmfColorCd) {
        this.ptAmfColorCd = ptAmfColorCd == null ? null : ptAmfColorCd.trim();
    }

    public String getPtAmfColorNm() {
        return ptAmfColorNm;
    }

    public void setPtAmfColorNm(String ptAmfColorNm) {
        this.ptAmfColorNm = ptAmfColorNm == null ? null : ptAmfColorNm.trim();
    }

    public Integer getPtAmfColorRtPrice() {
        return ptAmfColorRtPrice;
    }

    public void setPtAmfColorRtPrice(Integer ptAmfColorRtPrice) {
        this.ptAmfColorRtPrice = ptAmfColorRtPrice;
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
        this.ptBtnholeColorType = ptBtnholeColorType == null ? null : ptBtnholeColorType.trim();
    }

    public String getPtBtnholeColorPlcCd() {
        return ptBtnholeColorPlcCd;
    }

    public void setPtBtnholeColorPlcCd(String ptBtnholeColorPlcCd) {
        this.ptBtnholeColorPlcCd = ptBtnholeColorPlcCd == null ? null : ptBtnholeColorPlcCd.trim();
    }

    public String getPtBtnholeColorPlcNm() {
        return ptBtnholeColorPlcNm;
    }

    public void setPtBtnholeColorPlcNm(String ptBtnholeColorPlcNm) {
        this.ptBtnholeColorPlcNm = ptBtnholeColorPlcNm == null ? null : ptBtnholeColorPlcNm.trim();
    }

    public String getPtBtnholeColorCd() {
        return ptBtnholeColorCd;
    }

    public void setPtBtnholeColorCd(String ptBtnholeColorCd) {
        this.ptBtnholeColorCd = ptBtnholeColorCd == null ? null : ptBtnholeColorCd.trim();
    }

    public String getPtBtnholeColorNm() {
        return ptBtnholeColorNm;
    }

    public void setPtBtnholeColorNm(String ptBtnholeColorNm) {
        this.ptBtnholeColorNm = ptBtnholeColorNm == null ? null : ptBtnholeColorNm.trim();
    }

    public Integer getPtBtnholeColorRtPrice() {
        return ptBtnholeColorRtPrice;
    }

    public void setPtBtnholeColorRtPrice(Integer ptBtnholeColorRtPrice) {
        this.ptBtnholeColorRtPrice = ptBtnholeColorRtPrice;
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
        this.ptBtnthreadColorType = ptBtnthreadColorType == null ? null : ptBtnthreadColorType.trim();
    }

    public String getPtBtnthreadColorPlcCd() {
        return ptBtnthreadColorPlcCd;
    }

    public void setPtBtnthreadColorPlcCd(String ptBtnthreadColorPlcCd) {
        this.ptBtnthreadColorPlcCd = ptBtnthreadColorPlcCd == null ? null : ptBtnthreadColorPlcCd.trim();
    }

    public String getPtBtnthreadColorPlcNm() {
        return ptBtnthreadColorPlcNm;
    }

    public void setPtBtnthreadColorPlcNm(String ptBtnthreadColorPlcNm) {
        this.ptBtnthreadColorPlcNm = ptBtnthreadColorPlcNm == null ? null : ptBtnthreadColorPlcNm.trim();
    }

    public String getPtBtnthreadColorCd() {
        return ptBtnthreadColorCd;
    }

    public void setPtBtnthreadColorCd(String ptBtnthreadColorCd) {
        this.ptBtnthreadColorCd = ptBtnthreadColorCd == null ? null : ptBtnthreadColorCd.trim();
    }

    public String getPtBtnthreadColorNm() {
        return ptBtnthreadColorNm;
    }

    public void setPtBtnthreadColorNm(String ptBtnthreadColorNm) {
        this.ptBtnthreadColorNm = ptBtnthreadColorNm == null ? null : ptBtnthreadColorNm.trim();
    }

    public Integer getPtBtnthreadColorRtPrice() {
        return ptBtnthreadColorRtPrice;
    }

    public void setPtBtnthreadColorRtPrice(Integer ptBtnthreadColorRtPrice) {
        this.ptBtnthreadColorRtPrice = ptBtnthreadColorRtPrice;
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
        this.ptBtnMaterialType = ptBtnMaterialType == null ? null : ptBtnMaterialType.trim();
    }

    public String getPtBtnMaterialCd() {
        return ptBtnMaterialCd;
    }

    public void setPtBtnMaterialCd(String ptBtnMaterialCd) {
        this.ptBtnMaterialCd = ptBtnMaterialCd == null ? null : ptBtnMaterialCd.trim();
    }

    public String getPtBtnMaterialNm() {
        return ptBtnMaterialNm;
    }

    public void setPtBtnMaterialNm(String ptBtnMaterialNm) {
        this.ptBtnMaterialNm = ptBtnMaterialNm == null ? null : ptBtnMaterialNm.trim();
    }

    public Integer getPtBtnMaterialRtPrice() {
        return ptBtnMaterialRtPrice;
    }

    public void setPtBtnMaterialRtPrice(Integer ptBtnMaterialRtPrice) {
        this.ptBtnMaterialRtPrice = ptBtnMaterialRtPrice;
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
        this.ptSuspenderBtnCd = ptSuspenderBtnCd == null ? null : ptSuspenderBtnCd.trim();
    }

    public String getPtSuspenderBtnNm() {
        return ptSuspenderBtnNm;
    }

    public void setPtSuspenderBtnNm(String ptSuspenderBtnNm) {
        this.ptSuspenderBtnNm = ptSuspenderBtnNm == null ? null : ptSuspenderBtnNm.trim();
    }

    public Integer getPtSuspenderBtnRtPrice() {
        return ptSuspenderBtnRtPrice;
    }

    public void setPtSuspenderBtnRtPrice(Integer ptSuspenderBtnRtPrice) {
        this.ptSuspenderBtnRtPrice = ptSuspenderBtnRtPrice;
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
        this.ptNonSlipCd = ptNonSlipCd == null ? null : ptNonSlipCd.trim();
    }

    public String getPtNonSlipNm() {
        return ptNonSlipNm;
    }

    public void setPtNonSlipNm(String ptNonSlipNm) {
        this.ptNonSlipNm = ptNonSlipNm == null ? null : ptNonSlipNm.trim();
    }

    public Integer getPtNonSlipRtPrice() {
        return ptNonSlipRtPrice;
    }

    public void setPtNonSlipRtPrice(Integer ptNonSlipRtPrice) {
        this.ptNonSlipRtPrice = ptNonSlipRtPrice;
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
        this.ptChicSlipCd = ptChicSlipCd == null ? null : ptChicSlipCd.trim();
    }

    public String getPtChicSlipNm() {
        return ptChicSlipNm;
    }

    public void setPtChicSlipNm(String ptChicSlipNm) {
        this.ptChicSlipNm = ptChicSlipNm == null ? null : ptChicSlipNm.trim();
    }

    public Integer getPtChicSlipRtPrice() {
        return ptChicSlipRtPrice;
    }

    public void setPtChicSlipRtPrice(Integer ptChicSlipRtPrice) {
        this.ptChicSlipRtPrice = ptChicSlipRtPrice;
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
        this.ptShapeMemoryCd = ptShapeMemoryCd == null ? null : ptShapeMemoryCd.trim();
    }

    public String getPtShapeMemoryNm() {
        return ptShapeMemoryNm;
    }

    public void setPtShapeMemoryNm(String ptShapeMemoryNm) {
        this.ptShapeMemoryNm = ptShapeMemoryNm == null ? null : ptShapeMemoryNm.trim();
    }

    public Integer getPtShapeMemoryRtPrice() {
        return ptShapeMemoryRtPrice;
    }

    public void setPtShapeMemoryRtPrice(Integer ptShapeMemoryRtPrice) {
        this.ptShapeMemoryRtPrice = ptShapeMemoryRtPrice;
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
        this.ptShoeSoreCd = ptShoeSoreCd == null ? null : ptShoeSoreCd.trim();
    }

    public String getPtShoeSoreNm() {
        return ptShoeSoreNm;
    }

    public void setPtShoeSoreNm(String ptShoeSoreNm) {
        this.ptShoeSoreNm = ptShoeSoreNm == null ? null : ptShoeSoreNm.trim();
    }

    public Integer getPtShoeSoreRtPrice() {
        return ptShoeSoreRtPrice;
    }

    public void setPtShoeSoreRtPrice(Integer ptShoeSoreRtPrice) {
        this.ptShoeSoreRtPrice = ptShoeSoreRtPrice;
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
        this.ptSideStripeCd = ptSideStripeCd == null ? null : ptSideStripeCd.trim();
    }

    public String getPtSideStripeNm() {
        return ptSideStripeNm;
    }

    public void setPtSideStripeNm(String ptSideStripeNm) {
        this.ptSideStripeNm = ptSideStripeNm == null ? null : ptSideStripeNm.trim();
    }

    public Integer getPtSideStripeRtPrice() {
        return ptSideStripeRtPrice;
    }

    public void setPtSideStripeRtPrice(Integer ptSideStripeRtPrice) {
        this.ptSideStripeRtPrice = ptSideStripeRtPrice;
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
        this.ptSideStripeWidthCd = ptSideStripeWidthCd == null ? null : ptSideStripeWidthCd.trim();
    }

    public String getPtSideStripeWidthNm() {
        return ptSideStripeWidthNm;
    }

    public void setPtSideStripeWidthNm(String ptSideStripeWidthNm) {
        this.ptSideStripeWidthNm = ptSideStripeWidthNm == null ? null : ptSideStripeWidthNm.trim();
    }

    public Integer getPtSideStripeWidthRtPrice() {
        return ptSideStripeWidthRtPrice;
    }

    public void setPtSideStripeWidthRtPrice(Integer ptSideStripeWidthRtPrice) {
        this.ptSideStripeWidthRtPrice = ptSideStripeWidthRtPrice;
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
        this.pt2ModelCd = pt2ModelCd == null ? null : pt2ModelCd.trim();
    }

    public String getPt2ModelNm() {
        return pt2ModelNm;
    }

    public void setPt2ModelNm(String pt2ModelNm) {
        this.pt2ModelNm = pt2ModelNm == null ? null : pt2ModelNm.trim();
    }

    public Integer getPt2ModelRtPrice() {
        return pt2ModelRtPrice;
    }

    public void setPt2ModelRtPrice(Integer pt2ModelRtPrice) {
        this.pt2ModelRtPrice = pt2ModelRtPrice;
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
        this.pt2TackCd = pt2TackCd == null ? null : pt2TackCd.trim();
    }

    public String getPt2TackNm() {
        return pt2TackNm;
    }

    public void setPt2TackNm(String pt2TackNm) {
        this.pt2TackNm = pt2TackNm == null ? null : pt2TackNm.trim();
    }

    public Integer getPt2TackRtPrice() {
        return pt2TackRtPrice;
    }

    public void setPt2TackRtPrice(Integer pt2TackRtPrice) {
        this.pt2TackRtPrice = pt2TackRtPrice;
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
        this.pt2KneeinnerTypeCd = pt2KneeinnerTypeCd == null ? null : pt2KneeinnerTypeCd.trim();
    }

    public String getPt2KneeinnerTypeNm() {
        return pt2KneeinnerTypeNm;
    }

    public void setPt2KneeinnerTypeNm(String pt2KneeinnerTypeNm) {
        this.pt2KneeinnerTypeNm = pt2KneeinnerTypeNm == null ? null : pt2KneeinnerTypeNm.trim();
    }

    public Integer getPt2KneeinnerTypeRtPrice() {
        return pt2KneeinnerTypeRtPrice;
    }

    public void setPt2KneeinnerTypeRtPrice(Integer pt2KneeinnerTypeRtPrice) {
        this.pt2KneeinnerTypeRtPrice = pt2KneeinnerTypeRtPrice;
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
        this.pt2KneeinnerClothCd = pt2KneeinnerClothCd == null ? null : pt2KneeinnerClothCd.trim();
    }

    public String getPt2KneeinnerClothNm() {
        return pt2KneeinnerClothNm;
    }

    public void setPt2KneeinnerClothNm(String pt2KneeinnerClothNm) {
        this.pt2KneeinnerClothNm = pt2KneeinnerClothNm == null ? null : pt2KneeinnerClothNm.trim();
    }

    public Integer getPt2KneeinnerClothRtPrice() {
        return pt2KneeinnerClothRtPrice;
    }

    public void setPt2KneeinnerClothRtPrice(Integer pt2KneeinnerClothRtPrice) {
        this.pt2KneeinnerClothRtPrice = pt2KneeinnerClothRtPrice;
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
        this.pt2FrtTypeCd = pt2FrtTypeCd == null ? null : pt2FrtTypeCd.trim();
    }

    public String getPt2FrtTypeNm() {
        return pt2FrtTypeNm;
    }

    public void setPt2FrtTypeNm(String pt2FrtTypeNm) {
        this.pt2FrtTypeNm = pt2FrtTypeNm == null ? null : pt2FrtTypeNm.trim();
    }

    public Integer getPt2FrtTypeRtPrice() {
        return pt2FrtTypeRtPrice;
    }

    public void setPt2FrtTypeRtPrice(Integer pt2FrtTypeRtPrice) {
        this.pt2FrtTypeRtPrice = pt2FrtTypeRtPrice;
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
        this.pt2PancherinaCd = pt2PancherinaCd == null ? null : pt2PancherinaCd.trim();
    }

    public String getPt2PancherinaNm() {
        return pt2PancherinaNm;
    }

    public void setPt2PancherinaNm(String pt2PancherinaNm) {
        this.pt2PancherinaNm = pt2PancherinaNm == null ? null : pt2PancherinaNm.trim();
    }

    public Integer getPt2PancherinaRtPrice() {
        return pt2PancherinaRtPrice;
    }

    public void setPt2PancherinaRtPrice(Integer pt2PancherinaRtPrice) {
        this.pt2PancherinaRtPrice = pt2PancherinaRtPrice;
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
        this.pt2AdjusterCd = pt2AdjusterCd == null ? null : pt2AdjusterCd.trim();
    }

    public String getPt2AdjusterNm() {
        return pt2AdjusterNm;
    }

    public void setPt2AdjusterNm(String pt2AdjusterNm) {
        this.pt2AdjusterNm = pt2AdjusterNm == null ? null : pt2AdjusterNm.trim();
    }

    public Integer getPt2AdjusterRtPrice() {
        return pt2AdjusterRtPrice;
    }

    public void setPt2AdjusterRtPrice(Integer pt2AdjusterRtPrice) {
        this.pt2AdjusterRtPrice = pt2AdjusterRtPrice;
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
        this.pt2BeltloopType = pt2BeltloopType == null ? null : pt2BeltloopType.trim();
    }

    public String getPt2BeltloopCd() {
        return pt2BeltloopCd;
    }

    public void setPt2BeltloopCd(String pt2BeltloopCd) {
        this.pt2BeltloopCd = pt2BeltloopCd == null ? null : pt2BeltloopCd.trim();
    }

    public String getPt2BeltloopNm() {
        return pt2BeltloopNm;
    }

    public void setPt2BeltloopNm(String pt2BeltloopNm) {
        this.pt2BeltloopNm = pt2BeltloopNm == null ? null : pt2BeltloopNm.trim();
    }

    public Integer getPt2BeltloopRtPrice() {
        return pt2BeltloopRtPrice;
    }

    public void setPt2BeltloopRtPrice(Integer pt2BeltloopRtPrice) {
        this.pt2BeltloopRtPrice = pt2BeltloopRtPrice;
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
        this.pt2PinloopCd = pt2PinloopCd == null ? null : pt2PinloopCd.trim();
    }

    public String getPt2PinloopNm() {
        return pt2PinloopNm;
    }

    public void setPt2PinloopNm(String pt2PinloopNm) {
        this.pt2PinloopNm = pt2PinloopNm == null ? null : pt2PinloopNm.trim();
    }

    public Integer getPt2PinloopRtPrice() {
        return pt2PinloopRtPrice;
    }

    public void setPt2PinloopRtPrice(Integer pt2PinloopRtPrice) {
        this.pt2PinloopRtPrice = pt2PinloopRtPrice;
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
        this.pt2SidePktCd = pt2SidePktCd == null ? null : pt2SidePktCd.trim();
    }

    public String getPt2SidePktNm() {
        return pt2SidePktNm;
    }

    public void setPt2SidePktNm(String pt2SidePktNm) {
        this.pt2SidePktNm = pt2SidePktNm == null ? null : pt2SidePktNm.trim();
    }

    public Integer getPt2SidePktRtPrice() {
        return pt2SidePktRtPrice;
    }

    public void setPt2SidePktRtPrice(Integer pt2SidePktRtPrice) {
        this.pt2SidePktRtPrice = pt2SidePktRtPrice;
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
        this.pt2ShinobiPktCd = pt2ShinobiPktCd == null ? null : pt2ShinobiPktCd.trim();
    }

    public String getPt2ShinobiPktNm() {
        return pt2ShinobiPktNm;
    }

    public void setPt2ShinobiPktNm(String pt2ShinobiPktNm) {
        this.pt2ShinobiPktNm = pt2ShinobiPktNm == null ? null : pt2ShinobiPktNm.trim();
    }

    public Integer getPt2ShinobiPktRtPrice() {
        return pt2ShinobiPktRtPrice;
    }

    public void setPt2ShinobiPktRtPrice(Integer pt2ShinobiPktRtPrice) {
        this.pt2ShinobiPktRtPrice = pt2ShinobiPktRtPrice;
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
        this.pt2CoinPktCd = pt2CoinPktCd == null ? null : pt2CoinPktCd.trim();
    }

    public String getPt2CoinPktNm() {
        return pt2CoinPktNm;
    }

    public void setPt2CoinPktNm(String pt2CoinPktNm) {
        this.pt2CoinPktNm = pt2CoinPktNm == null ? null : pt2CoinPktNm.trim();
    }

    public Integer getPt2CoinPktRtPrice() {
        return pt2CoinPktRtPrice;
    }

    public void setPt2CoinPktRtPrice(Integer pt2CoinPktRtPrice) {
        this.pt2CoinPktRtPrice = pt2CoinPktRtPrice;
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
        this.pt2FlapcoinPktCd = pt2FlapcoinPktCd == null ? null : pt2FlapcoinPktCd.trim();
    }

    public String getPt2FlapcoinPktNm() {
        return pt2FlapcoinPktNm;
    }

    public void setPt2FlapcoinPktNm(String pt2FlapcoinPktNm) {
        this.pt2FlapcoinPktNm = pt2FlapcoinPktNm == null ? null : pt2FlapcoinPktNm.trim();
    }

    public Integer getPt2FlapcoinPktRtPrice() {
        return pt2FlapcoinPktRtPrice;
    }

    public void setPt2FlapcoinPktRtPrice(Integer pt2FlapcoinPktRtPrice) {
        this.pt2FlapcoinPktRtPrice = pt2FlapcoinPktRtPrice;
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
        this.pt2LeftPisPktCd = pt2LeftPisPktCd == null ? null : pt2LeftPisPktCd.trim();
    }

    public String getPt2LeftPisPktNm() {
        return pt2LeftPisPktNm;
    }

    public void setPt2LeftPisPktNm(String pt2LeftPisPktNm) {
        this.pt2LeftPisPktNm = pt2LeftPisPktNm == null ? null : pt2LeftPisPktNm.trim();
    }

    public Integer getPt2LeftPisPktRtPrice() {
        return pt2LeftPisPktRtPrice;
    }

    public void setPt2LeftPisPktRtPrice(Integer pt2LeftPisPktRtPrice) {
        this.pt2LeftPisPktRtPrice = pt2LeftPisPktRtPrice;
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
        this.pt2RightPisPktCd = pt2RightPisPktCd == null ? null : pt2RightPisPktCd.trim();
    }

    public String getPt2RightPisPktNm() {
        return pt2RightPisPktNm;
    }

    public void setPt2RightPisPktNm(String pt2RightPisPktNm) {
        this.pt2RightPisPktNm = pt2RightPisPktNm == null ? null : pt2RightPisPktNm.trim();
    }

    public Integer getPt2RightPisPktRtPrice() {
        return pt2RightPisPktRtPrice;
    }

    public void setPt2RightPisPktRtPrice(Integer pt2RightPisPktRtPrice) {
        this.pt2RightPisPktRtPrice = pt2RightPisPktRtPrice;
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

    public void setPt2VCutCd(String pt2VCutCd) {
        this.pt2VCutCd = pt2VCutCd == null ? null : pt2VCutCd.trim();
    }

    public String getPt2VCutNm() {
        return pt2VCutNm;
    }

    public void setPt2VCutNm(String pt2VCutNm) {
        this.pt2VCutNm = pt2VCutNm == null ? null : pt2VCutNm.trim();
    }

    public Integer getPt2VCutRtPrice() {
        return pt2VCutRtPrice;
    }

    public void setPt2VCutRtPrice(Integer pt2VCutRtPrice) {
        this.pt2VCutRtPrice = pt2VCutRtPrice;
    }

    public BigDecimal getPt2VCutWsWage() {
        return pt2VCutWsWage;
    }

    public void setPt2VCutWsWage(BigDecimal pt2VCutWsWage) {
        this.pt2VCutWsWage = pt2VCutWsWage;
    }

    public Integer getPt2VCutWsPrice() {
        return pt2VCutWsPrice;
    }

    public void setPt2VCutWsPrice(Integer pt2VCutWsPrice) {
        this.pt2VCutWsPrice = pt2VCutWsPrice;
    }

    public String getPt2HemUpCd() {
        return pt2HemUpCd;
    }

    public void setPt2HemUpCd(String pt2HemUpCd) {
        this.pt2HemUpCd = pt2HemUpCd == null ? null : pt2HemUpCd.trim();
    }

    public String getPt2HemUpNm() {
        return pt2HemUpNm;
    }

    public void setPt2HemUpNm(String pt2HemUpNm) {
        this.pt2HemUpNm = pt2HemUpNm == null ? null : pt2HemUpNm.trim();
    }

    public Integer getPt2HemUpRtPrice() {
        return pt2HemUpRtPrice;
    }

    public void setPt2HemUpRtPrice(Integer pt2HemUpRtPrice) {
        this.pt2HemUpRtPrice = pt2HemUpRtPrice;
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
        this.pt2DblWidthCd = pt2DblWidthCd == null ? null : pt2DblWidthCd.trim();
    }

    public String getPt2DblWidthNm() {
        return pt2DblWidthNm;
    }

    public void setPt2DblWidthNm(String pt2DblWidthNm) {
        this.pt2DblWidthNm = pt2DblWidthNm == null ? null : pt2DblWidthNm.trim();
    }

    public Integer getPt2DblWidthRtPrice() {
        return pt2DblWidthRtPrice;
    }

    public void setPt2DblWidthRtPrice(Integer pt2DblWidthRtPrice) {
        this.pt2DblWidthRtPrice = pt2DblWidthRtPrice;
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
        this.pt2AmfStitchCd = pt2AmfStitchCd == null ? null : pt2AmfStitchCd.trim();
    }

    public String getPt2AmfStitchNm() {
        return pt2AmfStitchNm;
    }

    public void setPt2AmfStitchNm(String pt2AmfStitchNm) {
        this.pt2AmfStitchNm = pt2AmfStitchNm == null ? null : pt2AmfStitchNm.trim();
    }

    public Integer getPt2AmfStitchRtPrice() {
        return pt2AmfStitchRtPrice;
    }

    public void setPt2AmfStitchRtPrice(Integer pt2AmfStitchRtPrice) {
        this.pt2AmfStitchRtPrice = pt2AmfStitchRtPrice;
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
        this.pt2StitchPlcType = pt2StitchPlcType == null ? null : pt2StitchPlcType.trim();
    }

    public String getPt2StitchPlcCd() {
        return pt2StitchPlcCd;
    }

    public void setPt2StitchPlcCd(String pt2StitchPlcCd) {
        this.pt2StitchPlcCd = pt2StitchPlcCd == null ? null : pt2StitchPlcCd.trim();
    }

    public String getPt2StitchPlcNm() {
        return pt2StitchPlcNm;
    }

    public void setPt2StitchPlcNm(String pt2StitchPlcNm) {
        this.pt2StitchPlcNm = pt2StitchPlcNm == null ? null : pt2StitchPlcNm.trim();
    }

    public Integer getPt2StitchPlcRtPrice() {
        return pt2StitchPlcRtPrice;
    }

    public void setPt2StitchPlcRtPrice(Integer pt2StitchPlcRtPrice) {
        this.pt2StitchPlcRtPrice = pt2StitchPlcRtPrice;
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
        this.pt2DblstitchPlcType = pt2DblstitchPlcType == null ? null : pt2DblstitchPlcType.trim();
    }

    public String getPt2DblstitchPlcCd() {
        return pt2DblstitchPlcCd;
    }

    public void setPt2DblstitchPlcCd(String pt2DblstitchPlcCd) {
        this.pt2DblstitchPlcCd = pt2DblstitchPlcCd == null ? null : pt2DblstitchPlcCd.trim();
    }

    public String getPt2DblstitchPlcNm() {
        return pt2DblstitchPlcNm;
    }

    public void setPt2DblstitchPlcNm(String pt2DblstitchPlcNm) {
        this.pt2DblstitchPlcNm = pt2DblstitchPlcNm == null ? null : pt2DblstitchPlcNm.trim();
    }

    public Integer getPt2DblstitchPlcRtPrice() {
        return pt2DblstitchPlcRtPrice;
    }

    public void setPt2DblstitchPlcRtPrice(Integer pt2DblstitchPlcRtPrice) {
        this.pt2DblstitchPlcRtPrice = pt2DblstitchPlcRtPrice;
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
        this.pt2AmfColorType = pt2AmfColorType == null ? null : pt2AmfColorType.trim();
    }

    public String getPt2AmfColorPlcCd() {
        return pt2AmfColorPlcCd;
    }

    public void setPt2AmfColorPlcCd(String pt2AmfColorPlcCd) {
        this.pt2AmfColorPlcCd = pt2AmfColorPlcCd == null ? null : pt2AmfColorPlcCd.trim();
    }

    public String getPt2AmfColorPlcNm() {
        return pt2AmfColorPlcNm;
    }

    public void setPt2AmfColorPlcNm(String pt2AmfColorPlcNm) {
        this.pt2AmfColorPlcNm = pt2AmfColorPlcNm == null ? null : pt2AmfColorPlcNm.trim();
    }

    public String getPt2AmfColorCd() {
        return pt2AmfColorCd;
    }

    public void setPt2AmfColorCd(String pt2AmfColorCd) {
        this.pt2AmfColorCd = pt2AmfColorCd == null ? null : pt2AmfColorCd.trim();
    }

    public String getPt2AmfColorNm() {
        return pt2AmfColorNm;
    }

    public void setPt2AmfColorNm(String pt2AmfColorNm) {
        this.pt2AmfColorNm = pt2AmfColorNm == null ? null : pt2AmfColorNm.trim();
    }

    public Integer getPt2AmfColorRtPrice() {
        return pt2AmfColorRtPrice;
    }

    public void setPt2AmfColorRtPrice(Integer pt2AmfColorRtPrice) {
        this.pt2AmfColorRtPrice = pt2AmfColorRtPrice;
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
        this.pt2BtnholeColorType = pt2BtnholeColorType == null ? null : pt2BtnholeColorType.trim();
    }

    public String getPt2BtnholeColorPlcCd() {
        return pt2BtnholeColorPlcCd;
    }

    public void setPt2BtnholeColorPlcCd(String pt2BtnholeColorPlcCd) {
        this.pt2BtnholeColorPlcCd = pt2BtnholeColorPlcCd == null ? null : pt2BtnholeColorPlcCd.trim();
    }

    public String getPt2BtnholeColorPlcNm() {
        return pt2BtnholeColorPlcNm;
    }

    public void setPt2BtnholeColorPlcNm(String pt2BtnholeColorPlcNm) {
        this.pt2BtnholeColorPlcNm = pt2BtnholeColorPlcNm == null ? null : pt2BtnholeColorPlcNm.trim();
    }

    public String getPt2BtnholeColorCd() {
        return pt2BtnholeColorCd;
    }

    public void setPt2BtnholeColorCd(String pt2BtnholeColorCd) {
        this.pt2BtnholeColorCd = pt2BtnholeColorCd == null ? null : pt2BtnholeColorCd.trim();
    }

    public String getPt2BtnholeColorNm() {
        return pt2BtnholeColorNm;
    }

    public void setPt2BtnholeColorNm(String pt2BtnholeColorNm) {
        this.pt2BtnholeColorNm = pt2BtnholeColorNm == null ? null : pt2BtnholeColorNm.trim();
    }

    public Integer getPt2BtnholeColorRtPrice() {
        return pt2BtnholeColorRtPrice;
    }

    public void setPt2BtnholeColorRtPrice(Integer pt2BtnholeColorRtPrice) {
        this.pt2BtnholeColorRtPrice = pt2BtnholeColorRtPrice;
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
        this.pt2BtnthreadColorType = pt2BtnthreadColorType == null ? null : pt2BtnthreadColorType.trim();
    }

    public String getPt2BtnthreadColorPlcCd() {
        return pt2BtnthreadColorPlcCd;
    }

    public void setPt2BtnthreadColorPlcCd(String pt2BtnthreadColorPlcCd) {
        this.pt2BtnthreadColorPlcCd = pt2BtnthreadColorPlcCd == null ? null : pt2BtnthreadColorPlcCd.trim();
    }

    public String getPt2BtnthreadColorPlcNm() {
        return pt2BtnthreadColorPlcNm;
    }

    public void setPt2BtnthreadColorPlcNm(String pt2BtnthreadColorPlcNm) {
        this.pt2BtnthreadColorPlcNm = pt2BtnthreadColorPlcNm == null ? null : pt2BtnthreadColorPlcNm.trim();
    }

    public String getPt2BtnthreadColorCd() {
        return pt2BtnthreadColorCd;
    }

    public void setPt2BtnthreadColorCd(String pt2BtnthreadColorCd) {
        this.pt2BtnthreadColorCd = pt2BtnthreadColorCd == null ? null : pt2BtnthreadColorCd.trim();
    }

    public String getPt2BtnthreadColorNm() {
        return pt2BtnthreadColorNm;
    }

    public void setPt2BtnthreadColorNm(String pt2BtnthreadColorNm) {
        this.pt2BtnthreadColorNm = pt2BtnthreadColorNm == null ? null : pt2BtnthreadColorNm.trim();
    }

    public Integer getPt2BtnthreadColorRtPrice() {
        return pt2BtnthreadColorRtPrice;
    }

    public void setPt2BtnthreadColorRtPrice(Integer pt2BtnthreadColorRtPrice) {
        this.pt2BtnthreadColorRtPrice = pt2BtnthreadColorRtPrice;
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
        this.pt2BtnMaterialType = pt2BtnMaterialType == null ? null : pt2BtnMaterialType.trim();
    }

    public String getPt2BtnMaterialCd() {
        return pt2BtnMaterialCd;
    }

    public void setPt2BtnMaterialCd(String pt2BtnMaterialCd) {
        this.pt2BtnMaterialCd = pt2BtnMaterialCd == null ? null : pt2BtnMaterialCd.trim();
    }

    public String getPt2BtnMaterialNm() {
        return pt2BtnMaterialNm;
    }

    public void setPt2BtnMaterialNm(String pt2BtnMaterialNm) {
        this.pt2BtnMaterialNm = pt2BtnMaterialNm == null ? null : pt2BtnMaterialNm.trim();
    }

    public Integer getPt2BtnMaterialRtPrice() {
        return pt2BtnMaterialRtPrice;
    }

    public void setPt2BtnMaterialRtPrice(Integer pt2BtnMaterialRtPrice) {
        this.pt2BtnMaterialRtPrice = pt2BtnMaterialRtPrice;
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
        this.pt2SuspenderBtnCd = pt2SuspenderBtnCd == null ? null : pt2SuspenderBtnCd.trim();
    }

    public String getPt2SuspenderBtnNm() {
        return pt2SuspenderBtnNm;
    }

    public void setPt2SuspenderBtnNm(String pt2SuspenderBtnNm) {
        this.pt2SuspenderBtnNm = pt2SuspenderBtnNm == null ? null : pt2SuspenderBtnNm.trim();
    }

    public Integer getPt2SuspenderBtnRtPrice() {
        return pt2SuspenderBtnRtPrice;
    }

    public void setPt2SuspenderBtnRtPrice(Integer pt2SuspenderBtnRtPrice) {
        this.pt2SuspenderBtnRtPrice = pt2SuspenderBtnRtPrice;
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
        this.pt2NonSlipCd = pt2NonSlipCd == null ? null : pt2NonSlipCd.trim();
    }

    public String getPt2NonSlipNm() {
        return pt2NonSlipNm;
    }

    public void setPt2NonSlipNm(String pt2NonSlipNm) {
        this.pt2NonSlipNm = pt2NonSlipNm == null ? null : pt2NonSlipNm.trim();
    }

    public Integer getPt2NonSlipRtPrice() {
        return pt2NonSlipRtPrice;
    }

    public void setPt2NonSlipRtPrice(Integer pt2NonSlipRtPrice) {
        this.pt2NonSlipRtPrice = pt2NonSlipRtPrice;
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
        this.pt2ChicSlipCd = pt2ChicSlipCd == null ? null : pt2ChicSlipCd.trim();
    }

    public String getPt2ChicSlipNm() {
        return pt2ChicSlipNm;
    }

    public void setPt2ChicSlipNm(String pt2ChicSlipNm) {
        this.pt2ChicSlipNm = pt2ChicSlipNm == null ? null : pt2ChicSlipNm.trim();
    }

    public Integer getPt2ChicSlipRtPrice() {
        return pt2ChicSlipRtPrice;
    }

    public void setPt2ChicSlipRtPrice(Integer pt2ChicSlipRtPrice) {
        this.pt2ChicSlipRtPrice = pt2ChicSlipRtPrice;
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
        this.pt2ShapeMemoryCd = pt2ShapeMemoryCd == null ? null : pt2ShapeMemoryCd.trim();
    }

    public String getPt2ShapeMemoryNm() {
        return pt2ShapeMemoryNm;
    }

    public void setPt2ShapeMemoryNm(String pt2ShapeMemoryNm) {
        this.pt2ShapeMemoryNm = pt2ShapeMemoryNm == null ? null : pt2ShapeMemoryNm.trim();
    }

    public Integer getPt2ShapeMemoryRtPrice() {
        return pt2ShapeMemoryRtPrice;
    }

    public void setPt2ShapeMemoryRtPrice(Integer pt2ShapeMemoryRtPrice) {
        this.pt2ShapeMemoryRtPrice = pt2ShapeMemoryRtPrice;
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
        this.pt2ShoeSoreCd = pt2ShoeSoreCd == null ? null : pt2ShoeSoreCd.trim();
    }

    public String getPt2ShoeSoreNm() {
        return pt2ShoeSoreNm;
    }

    public void setPt2ShoeSoreNm(String pt2ShoeSoreNm) {
        this.pt2ShoeSoreNm = pt2ShoeSoreNm == null ? null : pt2ShoeSoreNm.trim();
    }

    public Integer getPt2ShoeSoreRtPrice() {
        return pt2ShoeSoreRtPrice;
    }

    public void setPt2ShoeSoreRtPrice(Integer pt2ShoeSoreRtPrice) {
        this.pt2ShoeSoreRtPrice = pt2ShoeSoreRtPrice;
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
        this.pt2SideStripeCd = pt2SideStripeCd == null ? null : pt2SideStripeCd.trim();
    }

    public String getPt2SideStripeNm() {
        return pt2SideStripeNm;
    }

    public void setPt2SideStripeNm(String pt2SideStripeNm) {
        this.pt2SideStripeNm = pt2SideStripeNm == null ? null : pt2SideStripeNm.trim();
    }

    public Integer getPt2SideStripeRtPrice() {
        return pt2SideStripeRtPrice;
    }

    public void setPt2SideStripeRtPrice(Integer pt2SideStripeRtPrice) {
        this.pt2SideStripeRtPrice = pt2SideStripeRtPrice;
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
        this.pt2SideStripeWidthCd = pt2SideStripeWidthCd == null ? null : pt2SideStripeWidthCd.trim();
    }

    public String getPt2SideStripeWidthNm() {
        return pt2SideStripeWidthNm;
    }

    public void setPt2SideStripeWidthNm(String pt2SideStripeWidthNm) {
        this.pt2SideStripeWidthNm = pt2SideStripeWidthNm == null ? null : pt2SideStripeWidthNm.trim();
    }

    public Integer getPt2SideStripeWidthRtPrice() {
        return pt2SideStripeWidthRtPrice;
    }

    public void setPt2SideStripeWidthRtPrice(Integer pt2SideStripeWidthRtPrice) {
        this.pt2SideStripeWidthRtPrice = pt2SideStripeWidthRtPrice;
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
        this.pt3ModelCd = pt3ModelCd == null ? null : pt3ModelCd.trim();
    }

    public String getPt3ModelNm() {
        return pt3ModelNm;
    }

    public void setPt3ModelNm(String pt3ModelNm) {
        this.pt3ModelNm = pt3ModelNm == null ? null : pt3ModelNm.trim();
    }

    public Integer getPt3ModelRtPrice() {
        return pt3ModelRtPrice;
    }

    public void setPt3ModelRtPrice(Integer pt3ModelRtPrice) {
        this.pt3ModelRtPrice = pt3ModelRtPrice;
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
        this.pt3TackCd = pt3TackCd == null ? null : pt3TackCd.trim();
    }

    public String getPt3TackNm() {
        return pt3TackNm;
    }

    public void setPt3TackNm(String pt3TackNm) {
        this.pt3TackNm = pt3TackNm == null ? null : pt3TackNm.trim();
    }

    public Integer getPt3TackRtPrice() {
        return pt3TackRtPrice;
    }

    public void setPt3TackRtPrice(Integer pt3TackRtPrice) {
        this.pt3TackRtPrice = pt3TackRtPrice;
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
        this.pt3KneeinnerTypeCd = pt3KneeinnerTypeCd == null ? null : pt3KneeinnerTypeCd.trim();
    }

    public String getPt3KneeinnerTypeNm() {
        return pt3KneeinnerTypeNm;
    }

    public void setPt3KneeinnerTypeNm(String pt3KneeinnerTypeNm) {
        this.pt3KneeinnerTypeNm = pt3KneeinnerTypeNm == null ? null : pt3KneeinnerTypeNm.trim();
    }

    public Integer getPt3KneeinnerTypeRtPrice() {
        return pt3KneeinnerTypeRtPrice;
    }

    public void setPt3KneeinnerTypeRtPrice(Integer pt3KneeinnerTypeRtPrice) {
        this.pt3KneeinnerTypeRtPrice = pt3KneeinnerTypeRtPrice;
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
        this.pt3KneeinnerClothCd = pt3KneeinnerClothCd == null ? null : pt3KneeinnerClothCd.trim();
    }

    public String getPt3KneeinnerClothNm() {
        return pt3KneeinnerClothNm;
    }

    public void setPt3KneeinnerClothNm(String pt3KneeinnerClothNm) {
        this.pt3KneeinnerClothNm = pt3KneeinnerClothNm == null ? null : pt3KneeinnerClothNm.trim();
    }

    public Integer getPt3KneeinnerClothRtPrice() {
        return pt3KneeinnerClothRtPrice;
    }

    public void setPt3KneeinnerClothRtPrice(Integer pt3KneeinnerClothRtPrice) {
        this.pt3KneeinnerClothRtPrice = pt3KneeinnerClothRtPrice;
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
        this.pt3FrtTypeCd = pt3FrtTypeCd == null ? null : pt3FrtTypeCd.trim();
    }

    public String getPt3FrtTypeNm() {
        return pt3FrtTypeNm;
    }

    public void setPt3FrtTypeNm(String pt3FrtTypeNm) {
        this.pt3FrtTypeNm = pt3FrtTypeNm == null ? null : pt3FrtTypeNm.trim();
    }

    public Integer getPt3FrtTypeRtPrice() {
        return pt3FrtTypeRtPrice;
    }

    public void setPt3FrtTypeRtPrice(Integer pt3FrtTypeRtPrice) {
        this.pt3FrtTypeRtPrice = pt3FrtTypeRtPrice;
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
        this.pt3PancherinaCd = pt3PancherinaCd == null ? null : pt3PancherinaCd.trim();
    }

    public String getPt3PancherinaNm() {
        return pt3PancherinaNm;
    }

    public void setPt3PancherinaNm(String pt3PancherinaNm) {
        this.pt3PancherinaNm = pt3PancherinaNm == null ? null : pt3PancherinaNm.trim();
    }

    public Integer getPt3PancherinaRtPrice() {
        return pt3PancherinaRtPrice;
    }

    public void setPt3PancherinaRtPrice(Integer pt3PancherinaRtPrice) {
        this.pt3PancherinaRtPrice = pt3PancherinaRtPrice;
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
        this.pt3AdjusterCd = pt3AdjusterCd == null ? null : pt3AdjusterCd.trim();
    }

    public String getPt3AdjusterNm() {
        return pt3AdjusterNm;
    }

    public void setPt3AdjusterNm(String pt3AdjusterNm) {
        this.pt3AdjusterNm = pt3AdjusterNm == null ? null : pt3AdjusterNm.trim();
    }

    public Integer getPt3AdjusterRtPrice() {
        return pt3AdjusterRtPrice;
    }

    public void setPt3AdjusterRtPrice(Integer pt3AdjusterRtPrice) {
        this.pt3AdjusterRtPrice = pt3AdjusterRtPrice;
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
        this.pt3BeltloopType = pt3BeltloopType == null ? null : pt3BeltloopType.trim();
    }

    public String getPt3BeltloopCd() {
        return pt3BeltloopCd;
    }

    public void setPt3BeltloopCd(String pt3BeltloopCd) {
        this.pt3BeltloopCd = pt3BeltloopCd == null ? null : pt3BeltloopCd.trim();
    }

    public String getPt3BeltloopNm() {
        return pt3BeltloopNm;
    }

    public void setPt3BeltloopNm(String pt3BeltloopNm) {
        this.pt3BeltloopNm = pt3BeltloopNm == null ? null : pt3BeltloopNm.trim();
    }

    public Integer getPt3BeltloopRtPrice() {
        return pt3BeltloopRtPrice;
    }

    public void setPt3BeltloopRtPrice(Integer pt3BeltloopRtPrice) {
        this.pt3BeltloopRtPrice = pt3BeltloopRtPrice;
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
        this.pt3PinloopCd = pt3PinloopCd == null ? null : pt3PinloopCd.trim();
    }

    public String getPt3PinloopNm() {
        return pt3PinloopNm;
    }

    public void setPt3PinloopNm(String pt3PinloopNm) {
        this.pt3PinloopNm = pt3PinloopNm == null ? null : pt3PinloopNm.trim();
    }

    public Integer getPt3PinloopRtPrice() {
        return pt3PinloopRtPrice;
    }

    public void setPt3PinloopRtPrice(Integer pt3PinloopRtPrice) {
        this.pt3PinloopRtPrice = pt3PinloopRtPrice;
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
        this.pt3SidePktCd = pt3SidePktCd == null ? null : pt3SidePktCd.trim();
    }

    public String getPt3SidePktNm() {
        return pt3SidePktNm;
    }

    public void setPt3SidePktNm(String pt3SidePktNm) {
        this.pt3SidePktNm = pt3SidePktNm == null ? null : pt3SidePktNm.trim();
    }

    public Integer getPt3SidePktRtPrice() {
        return pt3SidePktRtPrice;
    }

    public void setPt3SidePktRtPrice(Integer pt3SidePktRtPrice) {
        this.pt3SidePktRtPrice = pt3SidePktRtPrice;
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
        this.pt3ShinobiPktCd = pt3ShinobiPktCd == null ? null : pt3ShinobiPktCd.trim();
    }

    public String getPt3ShinobiPktNm() {
        return pt3ShinobiPktNm;
    }

    public void setPt3ShinobiPktNm(String pt3ShinobiPktNm) {
        this.pt3ShinobiPktNm = pt3ShinobiPktNm == null ? null : pt3ShinobiPktNm.trim();
    }

    public Integer getPt3ShinobiPktRtPrice() {
        return pt3ShinobiPktRtPrice;
    }

    public void setPt3ShinobiPktRtPrice(Integer pt3ShinobiPktRtPrice) {
        this.pt3ShinobiPktRtPrice = pt3ShinobiPktRtPrice;
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
        this.pt3CoinPktCd = pt3CoinPktCd == null ? null : pt3CoinPktCd.trim();
    }

    public String getPt3CoinPktNm() {
        return pt3CoinPktNm;
    }

    public void setPt3CoinPktNm(String pt3CoinPktNm) {
        this.pt3CoinPktNm = pt3CoinPktNm == null ? null : pt3CoinPktNm.trim();
    }

    public Integer getPt3CoinPktRtPrice() {
        return pt3CoinPktRtPrice;
    }

    public void setPt3CoinPktRtPrice(Integer pt3CoinPktRtPrice) {
        this.pt3CoinPktRtPrice = pt3CoinPktRtPrice;
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
        this.pt3FlapcoinPktCd = pt3FlapcoinPktCd == null ? null : pt3FlapcoinPktCd.trim();
    }

    public String getPt3FlapcoinPktNm() {
        return pt3FlapcoinPktNm;
    }

    public void setPt3FlapcoinPktNm(String pt3FlapcoinPktNm) {
        this.pt3FlapcoinPktNm = pt3FlapcoinPktNm == null ? null : pt3FlapcoinPktNm.trim();
    }

    public Integer getPt3FlapcoinPktRtPrice() {
        return pt3FlapcoinPktRtPrice;
    }

    public void setPt3FlapcoinPktRtPrice(Integer pt3FlapcoinPktRtPrice) {
        this.pt3FlapcoinPktRtPrice = pt3FlapcoinPktRtPrice;
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
        this.pt3LeftPisPktCd = pt3LeftPisPktCd == null ? null : pt3LeftPisPktCd.trim();
    }

    public String getPt3LeftPisPktNm() {
        return pt3LeftPisPktNm;
    }

    public void setPt3LeftPisPktNm(String pt3LeftPisPktNm) {
        this.pt3LeftPisPktNm = pt3LeftPisPktNm == null ? null : pt3LeftPisPktNm.trim();
    }

    public Integer getPt3LeftPisPktRtPrice() {
        return pt3LeftPisPktRtPrice;
    }

    public void setPt3LeftPisPktRtPrice(Integer pt3LeftPisPktRtPrice) {
        this.pt3LeftPisPktRtPrice = pt3LeftPisPktRtPrice;
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
        this.pt3RightPisPktCd = pt3RightPisPktCd == null ? null : pt3RightPisPktCd.trim();
    }

    public String getPt3RightPisPktNm() {
        return pt3RightPisPktNm;
    }

    public void setPt3RightPisPktNm(String pt3RightPisPktNm) {
        this.pt3RightPisPktNm = pt3RightPisPktNm == null ? null : pt3RightPisPktNm.trim();
    }

    public Integer getPt3RightPisPktRtPrice() {
        return pt3RightPisPktRtPrice;
    }

    public void setPt3RightPisPktRtPrice(Integer pt3RightPisPktRtPrice) {
        this.pt3RightPisPktRtPrice = pt3RightPisPktRtPrice;
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

    public void setPt3VCutCd(String pt3VCutCd) {
        this.pt3VCutCd = pt3VCutCd == null ? null : pt3VCutCd.trim();
    }

    public String getPt3VCutNm() {
        return pt3VCutNm;
    }

    public void setPt3VCutNm(String pt3VCutNm) {
        this.pt3VCutNm = pt3VCutNm == null ? null : pt3VCutNm.trim();
    }

    public Integer getPt3VCutRtPrice() {
        return pt3VCutRtPrice;
    }

    public void setPt3VCutRtPrice(Integer pt3VCutRtPrice) {
        this.pt3VCutRtPrice = pt3VCutRtPrice;
    }

    public BigDecimal getPt3VCutWsWage() {
        return pt3VCutWsWage;
    }

    public void setPt3VCutWsWage(BigDecimal pt3VCutWsWage) {
        this.pt3VCutWsWage = pt3VCutWsWage;
    }

    public Integer getPt3VCutWsPrice() {
        return pt3VCutWsPrice;
    }

    public void setPt3VCutWsPrice(Integer pt3VCutWsPrice) {
        this.pt3VCutWsPrice = pt3VCutWsPrice;
    }

    public String getPt3HemUpCd() {
        return pt3HemUpCd;
    }

    public void setPt3HemUpCd(String pt3HemUpCd) {
        this.pt3HemUpCd = pt3HemUpCd == null ? null : pt3HemUpCd.trim();
    }

    public String getPt3HemUpNm() {
        return pt3HemUpNm;
    }

    public void setPt3HemUpNm(String pt3HemUpNm) {
        this.pt3HemUpNm = pt3HemUpNm == null ? null : pt3HemUpNm.trim();
    }

    public Integer getPt3HemUpRtPrice() {
        return pt3HemUpRtPrice;
    }

    public void setPt3HemUpRtPrice(Integer pt3HemUpRtPrice) {
        this.pt3HemUpRtPrice = pt3HemUpRtPrice;
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
        this.pt3DblWidthCd = pt3DblWidthCd == null ? null : pt3DblWidthCd.trim();
    }

    public String getPt3DblWidthNm() {
        return pt3DblWidthNm;
    }

    public void setPt3DblWidthNm(String pt3DblWidthNm) {
        this.pt3DblWidthNm = pt3DblWidthNm == null ? null : pt3DblWidthNm.trim();
    }

    public Integer getPt3DblWidthRtPrice() {
        return pt3DblWidthRtPrice;
    }

    public void setPt3DblWidthRtPrice(Integer pt3DblWidthRtPrice) {
        this.pt3DblWidthRtPrice = pt3DblWidthRtPrice;
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
        this.pt3AmfStitchCd = pt3AmfStitchCd == null ? null : pt3AmfStitchCd.trim();
    }

    public String getPt3AmfStitchNm() {
        return pt3AmfStitchNm;
    }

    public void setPt3AmfStitchNm(String pt3AmfStitchNm) {
        this.pt3AmfStitchNm = pt3AmfStitchNm == null ? null : pt3AmfStitchNm.trim();
    }

    public Integer getPt3AmfStitchRtPrice() {
        return pt3AmfStitchRtPrice;
    }

    public void setPt3AmfStitchRtPrice(Integer pt3AmfStitchRtPrice) {
        this.pt3AmfStitchRtPrice = pt3AmfStitchRtPrice;
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
        this.pt3StitchPlcType = pt3StitchPlcType == null ? null : pt3StitchPlcType.trim();
    }

    public String getPt3StitchPlcCd() {
        return pt3StitchPlcCd;
    }

    public void setPt3StitchPlcCd(String pt3StitchPlcCd) {
        this.pt3StitchPlcCd = pt3StitchPlcCd == null ? null : pt3StitchPlcCd.trim();
    }

    public String getPt3StitchPlcNm() {
        return pt3StitchPlcNm;
    }

    public void setPt3StitchPlcNm(String pt3StitchPlcNm) {
        this.pt3StitchPlcNm = pt3StitchPlcNm == null ? null : pt3StitchPlcNm.trim();
    }

    public Integer getPt3StitchPlcRtPrice() {
        return pt3StitchPlcRtPrice;
    }

    public void setPt3StitchPlcRtPrice(Integer pt3StitchPlcRtPrice) {
        this.pt3StitchPlcRtPrice = pt3StitchPlcRtPrice;
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
        this.pt3DblstitchPlcType = pt3DblstitchPlcType == null ? null : pt3DblstitchPlcType.trim();
    }

    public String getPt3DblstitchPlcCd() {
        return pt3DblstitchPlcCd;
    }

    public void setPt3DblstitchPlcCd(String pt3DblstitchPlcCd) {
        this.pt3DblstitchPlcCd = pt3DblstitchPlcCd == null ? null : pt3DblstitchPlcCd.trim();
    }

    public String getPt3DblstitchPlcNm() {
        return pt3DblstitchPlcNm;
    }

    public void setPt3DblstitchPlcNm(String pt3DblstitchPlcNm) {
        this.pt3DblstitchPlcNm = pt3DblstitchPlcNm == null ? null : pt3DblstitchPlcNm.trim();
    }

    public Integer getPt3DblstitchPlcRtPrice() {
        return pt3DblstitchPlcRtPrice;
    }

    public void setPt3DblstitchPlcRtPrice(Integer pt3DblstitchPlcRtPrice) {
        this.pt3DblstitchPlcRtPrice = pt3DblstitchPlcRtPrice;
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
        this.pt3AmfColorType = pt3AmfColorType == null ? null : pt3AmfColorType.trim();
    }

    public String getPt3AmfColorPlcCd() {
        return pt3AmfColorPlcCd;
    }

    public void setPt3AmfColorPlcCd(String pt3AmfColorPlcCd) {
        this.pt3AmfColorPlcCd = pt3AmfColorPlcCd == null ? null : pt3AmfColorPlcCd.trim();
    }

    public String getPt3AmfColorPlcNm() {
        return pt3AmfColorPlcNm;
    }

    public void setPt3AmfColorPlcNm(String pt3AmfColorPlcNm) {
        this.pt3AmfColorPlcNm = pt3AmfColorPlcNm == null ? null : pt3AmfColorPlcNm.trim();
    }

    public String getPt3AmfColorCd() {
        return pt3AmfColorCd;
    }

    public void setPt3AmfColorCd(String pt3AmfColorCd) {
        this.pt3AmfColorCd = pt3AmfColorCd == null ? null : pt3AmfColorCd.trim();
    }

    public String getPt3AmfColorNm() {
        return pt3AmfColorNm;
    }

    public void setPt3AmfColorNm(String pt3AmfColorNm) {
        this.pt3AmfColorNm = pt3AmfColorNm == null ? null : pt3AmfColorNm.trim();
    }

    public Integer getPt3AmfColorRtPrice() {
        return pt3AmfColorRtPrice;
    }

    public void setPt3AmfColorRtPrice(Integer pt3AmfColorRtPrice) {
        this.pt3AmfColorRtPrice = pt3AmfColorRtPrice;
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
        this.pt3BtnholeColorType = pt3BtnholeColorType == null ? null : pt3BtnholeColorType.trim();
    }

    public String getPt3BtnholeColorPlcCd() {
        return pt3BtnholeColorPlcCd;
    }

    public void setPt3BtnholeColorPlcCd(String pt3BtnholeColorPlcCd) {
        this.pt3BtnholeColorPlcCd = pt3BtnholeColorPlcCd == null ? null : pt3BtnholeColorPlcCd.trim();
    }

    public String getPt3BtnholeColorPlcNm() {
        return pt3BtnholeColorPlcNm;
    }

    public void setPt3BtnholeColorPlcNm(String pt3BtnholeColorPlcNm) {
        this.pt3BtnholeColorPlcNm = pt3BtnholeColorPlcNm == null ? null : pt3BtnholeColorPlcNm.trim();
    }

    public String getPt3BtnholeColorCd() {
        return pt3BtnholeColorCd;
    }

    public void setPt3BtnholeColorCd(String pt3BtnholeColorCd) {
        this.pt3BtnholeColorCd = pt3BtnholeColorCd == null ? null : pt3BtnholeColorCd.trim();
    }

    public String getPt3BtnholeColorNm() {
        return pt3BtnholeColorNm;
    }

    public void setPt3BtnholeColorNm(String pt3BtnholeColorNm) {
        this.pt3BtnholeColorNm = pt3BtnholeColorNm == null ? null : pt3BtnholeColorNm.trim();
    }

    public Integer getPt3BtnholeColorRtPrice() {
        return pt3BtnholeColorRtPrice;
    }

    public void setPt3BtnholeColorRtPrice(Integer pt3BtnholeColorRtPrice) {
        this.pt3BtnholeColorRtPrice = pt3BtnholeColorRtPrice;
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
        this.pt3BtnthreadColorType = pt3BtnthreadColorType == null ? null : pt3BtnthreadColorType.trim();
    }

    public String getPt3BtnthreadColorPlcCd() {
        return pt3BtnthreadColorPlcCd;
    }

    public void setPt3BtnthreadColorPlcCd(String pt3BtnthreadColorPlcCd) {
        this.pt3BtnthreadColorPlcCd = pt3BtnthreadColorPlcCd == null ? null : pt3BtnthreadColorPlcCd.trim();
    }

    public String getPt3BtnthreadColorPlcNm() {
        return pt3BtnthreadColorPlcNm;
    }

    public void setPt3BtnthreadColorPlcNm(String pt3BtnthreadColorPlcNm) {
        this.pt3BtnthreadColorPlcNm = pt3BtnthreadColorPlcNm == null ? null : pt3BtnthreadColorPlcNm.trim();
    }

    public String getPt3BtnthreadColorCd() {
        return pt3BtnthreadColorCd;
    }

    public void setPt3BtnthreadColorCd(String pt3BtnthreadColorCd) {
        this.pt3BtnthreadColorCd = pt3BtnthreadColorCd == null ? null : pt3BtnthreadColorCd.trim();
    }

    public String getPt3BtnthreadColorNm() {
        return pt3BtnthreadColorNm;
    }

    public void setPt3BtnthreadColorNm(String pt3BtnthreadColorNm) {
        this.pt3BtnthreadColorNm = pt3BtnthreadColorNm == null ? null : pt3BtnthreadColorNm.trim();
    }

    public Integer getPt3BtnthreadColorRtPrice() {
        return pt3BtnthreadColorRtPrice;
    }

    public void setPt3BtnthreadColorRtPrice(Integer pt3BtnthreadColorRtPrice) {
        this.pt3BtnthreadColorRtPrice = pt3BtnthreadColorRtPrice;
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
        this.pt3BtnMaterialType = pt3BtnMaterialType == null ? null : pt3BtnMaterialType.trim();
    }

    public String getPt3BtnMaterialCd() {
        return pt3BtnMaterialCd;
    }

    public void setPt3BtnMaterialCd(String pt3BtnMaterialCd) {
        this.pt3BtnMaterialCd = pt3BtnMaterialCd == null ? null : pt3BtnMaterialCd.trim();
    }

    public String getPt3BtnMaterialNm() {
        return pt3BtnMaterialNm;
    }

    public void setPt3BtnMaterialNm(String pt3BtnMaterialNm) {
        this.pt3BtnMaterialNm = pt3BtnMaterialNm == null ? null : pt3BtnMaterialNm.trim();
    }

    public Integer getPt3BtnMaterialRtPrice() {
        return pt3BtnMaterialRtPrice;
    }

    public void setPt3BtnMaterialRtPrice(Integer pt3BtnMaterialRtPrice) {
        this.pt3BtnMaterialRtPrice = pt3BtnMaterialRtPrice;
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
        this.pt3SuspenderBtnCd = pt3SuspenderBtnCd == null ? null : pt3SuspenderBtnCd.trim();
    }

    public String getPt3SuspenderBtnNm() {
        return pt3SuspenderBtnNm;
    }

    public void setPt3SuspenderBtnNm(String pt3SuspenderBtnNm) {
        this.pt3SuspenderBtnNm = pt3SuspenderBtnNm == null ? null : pt3SuspenderBtnNm.trim();
    }

    public Integer getPt3SuspenderBtnRtPrice() {
        return pt3SuspenderBtnRtPrice;
    }

    public void setPt3SuspenderBtnRtPrice(Integer pt3SuspenderBtnRtPrice) {
        this.pt3SuspenderBtnRtPrice = pt3SuspenderBtnRtPrice;
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
        this.pt3NonSlipCd = pt3NonSlipCd == null ? null : pt3NonSlipCd.trim();
    }

    public String getPt3NonSlipNm() {
        return pt3NonSlipNm;
    }

    public void setPt3NonSlipNm(String pt3NonSlipNm) {
        this.pt3NonSlipNm = pt3NonSlipNm == null ? null : pt3NonSlipNm.trim();
    }

    public Integer getPt3NonSlipRtPrice() {
        return pt3NonSlipRtPrice;
    }

    public void setPt3NonSlipRtPrice(Integer pt3NonSlipRtPrice) {
        this.pt3NonSlipRtPrice = pt3NonSlipRtPrice;
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
        this.pt3ChicSlipCd = pt3ChicSlipCd == null ? null : pt3ChicSlipCd.trim();
    }

    public String getPt3ChicSlipNm() {
        return pt3ChicSlipNm;
    }

    public void setPt3ChicSlipNm(String pt3ChicSlipNm) {
        this.pt3ChicSlipNm = pt3ChicSlipNm == null ? null : pt3ChicSlipNm.trim();
    }

    public Integer getPt3ChicSlipRtPrice() {
        return pt3ChicSlipRtPrice;
    }

    public void setPt3ChicSlipRtPrice(Integer pt3ChicSlipRtPrice) {
        this.pt3ChicSlipRtPrice = pt3ChicSlipRtPrice;
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
        this.pt3ShapeMemoryCd = pt3ShapeMemoryCd == null ? null : pt3ShapeMemoryCd.trim();
    }

    public String getPt3ShapeMemoryNm() {
        return pt3ShapeMemoryNm;
    }

    public void setPt3ShapeMemoryNm(String pt3ShapeMemoryNm) {
        this.pt3ShapeMemoryNm = pt3ShapeMemoryNm == null ? null : pt3ShapeMemoryNm.trim();
    }

    public Integer getPt3ShapeMemoryRtPrice() {
        return pt3ShapeMemoryRtPrice;
    }

    public void setPt3ShapeMemoryRtPrice(Integer pt3ShapeMemoryRtPrice) {
        this.pt3ShapeMemoryRtPrice = pt3ShapeMemoryRtPrice;
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
        this.pt3ShoeSoreCd = pt3ShoeSoreCd == null ? null : pt3ShoeSoreCd.trim();
    }

    public String getPt3ShoeSoreNm() {
        return pt3ShoeSoreNm;
    }

    public void setPt3ShoeSoreNm(String pt3ShoeSoreNm) {
        this.pt3ShoeSoreNm = pt3ShoeSoreNm == null ? null : pt3ShoeSoreNm.trim();
    }

    public Integer getPt3ShoeSoreRtPrice() {
        return pt3ShoeSoreRtPrice;
    }

    public void setPt3ShoeSoreRtPrice(Integer pt3ShoeSoreRtPrice) {
        this.pt3ShoeSoreRtPrice = pt3ShoeSoreRtPrice;
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
        this.pt3SideStripeCd = pt3SideStripeCd == null ? null : pt3SideStripeCd.trim();
    }

    public String getPt3SideStripeNm() {
        return pt3SideStripeNm;
    }

    public void setPt3SideStripeNm(String pt3SideStripeNm) {
        this.pt3SideStripeNm = pt3SideStripeNm == null ? null : pt3SideStripeNm.trim();
    }

    public Integer getPt3SideStripeRtPrice() {
        return pt3SideStripeRtPrice;
    }

    public void setPt3SideStripeRtPrice(Integer pt3SideStripeRtPrice) {
        this.pt3SideStripeRtPrice = pt3SideStripeRtPrice;
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
        this.pt3SideStripeWidthCd = pt3SideStripeWidthCd == null ? null : pt3SideStripeWidthCd.trim();
    }

    public String getPt3SideStripeWidthNm() {
        return pt3SideStripeWidthNm;
    }

    public void setPt3SideStripeWidthNm(String pt3SideStripeWidthNm) {
        this.pt3SideStripeWidthNm = pt3SideStripeWidthNm == null ? null : pt3SideStripeWidthNm.trim();
    }

    public Integer getPt3SideStripeWidthRtPrice() {
        return pt3SideStripeWidthRtPrice;
    }

    public void setPt3SideStripeWidthRtPrice(Integer pt3SideStripeWidthRtPrice) {
        this.pt3SideStripeWidthRtPrice = pt3SideStripeWidthRtPrice;
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
        this.glModelCd = glModelCd == null ? null : glModelCd.trim();
    }

    public String getGlModelNm() {
        return glModelNm;
    }

    public void setGlModelNm(String glModelNm) {
        this.glModelNm = glModelNm == null ? null : glModelNm.trim();
    }

    public Integer getGlModelRtPrice() {
        return glModelRtPrice;
    }

    public void setGlModelRtPrice(Integer glModelRtPrice) {
        this.glModelRtPrice = glModelRtPrice;
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
        this.glBreastPktCd = glBreastPktCd == null ? null : glBreastPktCd.trim();
    }

    public String getGlBreastPktNm() {
        return glBreastPktNm;
    }

    public void setGlBreastPktNm(String glBreastPktNm) {
        this.glBreastPktNm = glBreastPktNm == null ? null : glBreastPktNm.trim();
    }

    public Integer getGlBreastPktRtPrice() {
        return glBreastPktRtPrice;
    }

    public void setGlBreastPktRtPrice(Integer glBreastPktRtPrice) {
        this.glBreastPktRtPrice = glBreastPktRtPrice;
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
        this.glWaistPktCd = glWaistPktCd == null ? null : glWaistPktCd.trim();
    }

    public String getGlWaistPktNm() {
        return glWaistPktNm;
    }

    public void setGlWaistPktNm(String glWaistPktNm) {
        this.glWaistPktNm = glWaistPktNm == null ? null : glWaistPktNm.trim();
    }

    public Integer getGlWaistPktRtPrice() {
        return glWaistPktRtPrice;
    }

    public void setGlWaistPktRtPrice(Integer glWaistPktRtPrice) {
        this.glWaistPktRtPrice = glWaistPktRtPrice;
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
        this.glWaistPktShapeCd = glWaistPktShapeCd == null ? null : glWaistPktShapeCd.trim();
    }

    public String getGlWaistPktShapeNm() {
        return glWaistPktShapeNm;
    }

    public void setGlWaistPktShapeNm(String glWaistPktShapeNm) {
        this.glWaistPktShapeNm = glWaistPktShapeNm == null ? null : glWaistPktShapeNm.trim();
    }

    public Integer getGlWaistPktShapeRtPrice() {
        return glWaistPktShapeRtPrice;
    }

    public void setGlWaistPktShapeRtPrice(Integer glWaistPktShapeRtPrice) {
        this.glWaistPktShapeRtPrice = glWaistPktShapeRtPrice;
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
        this.glWaistPktClothCd = glWaistPktClothCd == null ? null : glWaistPktClothCd.trim();
    }

    public String getGlWaistPktClothNm() {
        return glWaistPktClothNm;
    }

    public void setGlWaistPktClothNm(String glWaistPktClothNm) {
        this.glWaistPktClothNm = glWaistPktClothNm == null ? null : glWaistPktClothNm.trim();
    }

    public Integer getGlWaistPktClothRtPrice() {
        return glWaistPktClothRtPrice;
    }

    public void setGlWaistPktClothRtPrice(Integer glWaistPktClothRtPrice) {
        this.glWaistPktClothRtPrice = glWaistPktClothRtPrice;
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
        this.glAmfStitchCd = glAmfStitchCd == null ? null : glAmfStitchCd.trim();
    }

    public String getGlAmfStitchNm() {
        return glAmfStitchNm;
    }

    public void setGlAmfStitchNm(String glAmfStitchNm) {
        this.glAmfStitchNm = glAmfStitchNm == null ? null : glAmfStitchNm.trim();
    }

    public Integer getGlAmfStitchRtPrice() {
        return glAmfStitchRtPrice;
    }

    public void setGlAmfStitchRtPrice(Integer glAmfStitchRtPrice) {
        this.glAmfStitchRtPrice = glAmfStitchRtPrice;
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
        this.glStitchPlcType = glStitchPlcType == null ? null : glStitchPlcType.trim();
    }

    public String getGlStitchPlcCd() {
        return glStitchPlcCd;
    }

    public void setGlStitchPlcCd(String glStitchPlcCd) {
        this.glStitchPlcCd = glStitchPlcCd == null ? null : glStitchPlcCd.trim();
    }

    public String getGlStitchPlcNm() {
        return glStitchPlcNm;
    }

    public void setGlStitchPlcNm(String glStitchPlcNm) {
        this.glStitchPlcNm = glStitchPlcNm == null ? null : glStitchPlcNm.trim();
    }

    public Integer getGlStitchPlcRtPrice() {
        return glStitchPlcRtPrice;
    }

    public void setGlStitchPlcRtPrice(Integer glStitchPlcRtPrice) {
        this.glStitchPlcRtPrice = glStitchPlcRtPrice;
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
        this.glDblstitchPlcType = glDblstitchPlcType == null ? null : glDblstitchPlcType.trim();
    }

    public String getGlDblstitchPlcCd() {
        return glDblstitchPlcCd;
    }

    public void setGlDblstitchPlcCd(String glDblstitchPlcCd) {
        this.glDblstitchPlcCd = glDblstitchPlcCd == null ? null : glDblstitchPlcCd.trim();
    }

    public String getGlDblstitchPlcNm() {
        return glDblstitchPlcNm;
    }

    public void setGlDblstitchPlcNm(String glDblstitchPlcNm) {
        this.glDblstitchPlcNm = glDblstitchPlcNm == null ? null : glDblstitchPlcNm.trim();
    }

    public Integer getGlDblstitchPlcRtPrice() {
        return glDblstitchPlcRtPrice;
    }

    public void setGlDblstitchPlcRtPrice(Integer glDblstitchPlcRtPrice) {
        this.glDblstitchPlcRtPrice = glDblstitchPlcRtPrice;
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
        this.glAmfColorType = glAmfColorType == null ? null : glAmfColorType.trim();
    }

    public String getGlAmfColorPlcCd() {
        return glAmfColorPlcCd;
    }

    public void setGlAmfColorPlcCd(String glAmfColorPlcCd) {
        this.glAmfColorPlcCd = glAmfColorPlcCd == null ? null : glAmfColorPlcCd.trim();
    }

    public String getGlAmfColorPlcNm() {
        return glAmfColorPlcNm;
    }

    public void setGlAmfColorPlcNm(String glAmfColorPlcNm) {
        this.glAmfColorPlcNm = glAmfColorPlcNm == null ? null : glAmfColorPlcNm.trim();
    }

    public String getGlAmfColorCd() {
        return glAmfColorCd;
    }

    public void setGlAmfColorCd(String glAmfColorCd) {
        this.glAmfColorCd = glAmfColorCd == null ? null : glAmfColorCd.trim();
    }

    public String getGlAmfColorNm() {
        return glAmfColorNm;
    }

    public void setGlAmfColorNm(String glAmfColorNm) {
        this.glAmfColorNm = glAmfColorNm == null ? null : glAmfColorNm.trim();
    }

    public Integer getGlAmfColorRtPrice() {
        return glAmfColorRtPrice;
    }

    public void setGlAmfColorRtPrice(Integer glAmfColorRtPrice) {
        this.glAmfColorRtPrice = glAmfColorRtPrice;
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
        this.glBtnholeColorType = glBtnholeColorType == null ? null : glBtnholeColorType.trim();
    }

    public String getGlBtnholeColorPlcCd() {
        return glBtnholeColorPlcCd;
    }

    public void setGlBtnholeColorPlcCd(String glBtnholeColorPlcCd) {
        this.glBtnholeColorPlcCd = glBtnholeColorPlcCd == null ? null : glBtnholeColorPlcCd.trim();
    }

    public String getGlBtnholeColorPlcNm() {
        return glBtnholeColorPlcNm;
    }

    public void setGlBtnholeColorPlcNm(String glBtnholeColorPlcNm) {
        this.glBtnholeColorPlcNm = glBtnholeColorPlcNm == null ? null : glBtnholeColorPlcNm.trim();
    }

    public String getGlBtnholeColorCd() {
        return glBtnholeColorCd;
    }

    public void setGlBtnholeColorCd(String glBtnholeColorCd) {
        this.glBtnholeColorCd = glBtnholeColorCd == null ? null : glBtnholeColorCd.trim();
    }

    public String getGlBtnholeColorNm() {
        return glBtnholeColorNm;
    }

    public void setGlBtnholeColorNm(String glBtnholeColorNm) {
        this.glBtnholeColorNm = glBtnholeColorNm == null ? null : glBtnholeColorNm.trim();
    }

    public Integer getGlBtnholeColorRtPrice() {
        return glBtnholeColorRtPrice;
    }

    public void setGlBtnholeColorRtPrice(Integer glBtnholeColorRtPrice) {
        this.glBtnholeColorRtPrice = glBtnholeColorRtPrice;
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
        this.glBtnthreadColorType = glBtnthreadColorType == null ? null : glBtnthreadColorType.trim();
    }

    public String getGlBtnthreadColorPlcCd() {
        return glBtnthreadColorPlcCd;
    }

    public void setGlBtnthreadColorPlcCd(String glBtnthreadColorPlcCd) {
        this.glBtnthreadColorPlcCd = glBtnthreadColorPlcCd == null ? null : glBtnthreadColorPlcCd.trim();
    }

    public String getGlBtnthreadColorPlcNm() {
        return glBtnthreadColorPlcNm;
    }

    public void setGlBtnthreadColorPlcNm(String glBtnthreadColorPlcNm) {
        this.glBtnthreadColorPlcNm = glBtnthreadColorPlcNm == null ? null : glBtnthreadColorPlcNm.trim();
    }

    public String getGlBtnthreadColorCd() {
        return glBtnthreadColorCd;
    }

    public void setGlBtnthreadColorCd(String glBtnthreadColorCd) {
        this.glBtnthreadColorCd = glBtnthreadColorCd == null ? null : glBtnthreadColorCd.trim();
    }

    public String getGlBtnthreadColorNm() {
        return glBtnthreadColorNm;
    }

    public void setGlBtnthreadColorNm(String glBtnthreadColorNm) {
        this.glBtnthreadColorNm = glBtnthreadColorNm == null ? null : glBtnthreadColorNm.trim();
    }

    public Integer getGlBtnthreadColorRtPrice() {
        return glBtnthreadColorRtPrice;
    }

    public void setGlBtnthreadColorRtPrice(Integer glBtnthreadColorRtPrice) {
        this.glBtnthreadColorRtPrice = glBtnthreadColorRtPrice;
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
        this.glBackClothType = glBackClothType == null ? null : glBackClothType.trim();
    }

    public String getGlBackClothCd() {
        return glBackClothCd;
    }

    public void setGlBackClothCd(String glBackClothCd) {
        this.glBackClothCd = glBackClothCd == null ? null : glBackClothCd.trim();
    }

    public String getGlBackClothNm() {
        return glBackClothNm;
    }

    public void setGlBackClothNm(String glBackClothNm) {
        this.glBackClothNm = glBackClothNm == null ? null : glBackClothNm.trim();
    }

    public Integer getGlBackClothRtPrice() {
        return glBackClothRtPrice;
    }

    public void setGlBackClothRtPrice(Integer glBackClothRtPrice) {
        this.glBackClothRtPrice = glBackClothRtPrice;
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
        this.glInnnerClothType = glInnnerClothType == null ? null : glInnnerClothType.trim();
    }

    public String getGlInnnerClothCd() {
        return glInnnerClothCd;
    }

    public void setGlInnnerClothCd(String glInnnerClothCd) {
        this.glInnnerClothCd = glInnnerClothCd == null ? null : glInnnerClothCd.trim();
    }

    public String getGlInnnerClothNm() {
        return glInnnerClothNm;
    }

    public void setGlInnnerClothNm(String glInnnerClothNm) {
        this.glInnnerClothNm = glInnnerClothNm == null ? null : glInnnerClothNm.trim();
    }

    public Integer getGlInnnerClothRtPrice() {
        return glInnnerClothRtPrice;
    }

    public void setGlInnnerClothRtPrice(Integer glInnnerClothRtPrice) {
        this.glInnnerClothRtPrice = glInnnerClothRtPrice;
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
        this.glFrtBtnType = glFrtBtnType == null ? null : glFrtBtnType.trim();
    }

    public String getGlFrtBtnCd() {
        return glFrtBtnCd;
    }

    public void setGlFrtBtnCd(String glFrtBtnCd) {
        this.glFrtBtnCd = glFrtBtnCd == null ? null : glFrtBtnCd.trim();
    }

    public String getGlFrtBtnNm() {
        return glFrtBtnNm;
    }

    public void setGlFrtBtnNm(String glFrtBtnNm) {
        this.glFrtBtnNm = glFrtBtnNm == null ? null : glFrtBtnNm.trim();
    }

    public Integer getGlFrtBtnRtPrice() {
        return glFrtBtnRtPrice;
    }

    public void setGlFrtBtnRtPrice(Integer glFrtBtnRtPrice) {
        this.glFrtBtnRtPrice = glFrtBtnRtPrice;
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
        this.glBackBeltCd = glBackBeltCd == null ? null : glBackBeltCd.trim();
    }

    public String getGlBackBeltNm() {
        return glBackBeltNm;
    }

    public void setGlBackBeltNm(String glBackBeltNm) {
        this.glBackBeltNm = glBackBeltNm == null ? null : glBackBeltNm.trim();
    }

    public Integer getGlBackBeltRtPrice() {
        return glBackBeltRtPrice;
    }

    public void setGlBackBeltRtPrice(Integer glBackBeltRtPrice) {
        this.glBackBeltRtPrice = glBackBeltRtPrice;
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
        this.glWatchChainCd = glWatchChainCd == null ? null : glWatchChainCd.trim();
    }

    public String getGlWatchChainNm() {
        return glWatchChainNm;
    }

    public void setGlWatchChainNm(String glWatchChainNm) {
        this.glWatchChainNm = glWatchChainNm == null ? null : glWatchChainNm.trim();
    }

    public Integer getGlWatchChainRtPrice() {
        return glWatchChainRtPrice;
    }

    public void setGlWatchChainRtPrice(Integer glWatchChainRtPrice) {
        this.glWatchChainRtPrice = glWatchChainRtPrice;
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
        this.ctModelCd = ctModelCd == null ? null : ctModelCd.trim();
    }

    public String getCtModelNm() {
        return ctModelNm;
    }

    public void setCtModelNm(String ctModelNm) {
        this.ctModelNm = ctModelNm == null ? null : ctModelNm.trim();
    }

    public Integer getCtModelRtPrice() {
        return ctModelRtPrice;
    }

    public void setCtModelRtPrice(Integer ctModelRtPrice) {
        this.ctModelRtPrice = ctModelRtPrice;
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
        this.ctLapelDesignCd = ctLapelDesignCd == null ? null : ctLapelDesignCd.trim();
    }

    public String getCtLapelDesignNm() {
        return ctLapelDesignNm;
    }

    public void setCtLapelDesignNm(String ctLapelDesignNm) {
        this.ctLapelDesignNm = ctLapelDesignNm == null ? null : ctLapelDesignNm.trim();
    }

    public Integer getCtLapelDesignRtPrice() {
        return ctLapelDesignRtPrice;
    }

    public void setCtLapelDesignRtPrice(Integer ctLapelDesignRtPrice) {
        this.ctLapelDesignRtPrice = ctLapelDesignRtPrice;
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
        this.ctSleeveTypeCd = ctSleeveTypeCd == null ? null : ctSleeveTypeCd.trim();
    }

    public String getCtSleeveTypeNm() {
        return ctSleeveTypeNm;
    }

    public void setCtSleeveTypeNm(String ctSleeveTypeNm) {
        this.ctSleeveTypeNm = ctSleeveTypeNm == null ? null : ctSleeveTypeNm.trim();
    }

    public Integer getCtSleeveTypeRtPrice() {
        return ctSleeveTypeRtPrice;
    }

    public void setCtSleeveTypeRtPrice(Integer ctSleeveTypeRtPrice) {
        this.ctSleeveTypeRtPrice = ctSleeveTypeRtPrice;
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
        this.ctWaistPktCd = ctWaistPktCd == null ? null : ctWaistPktCd.trim();
    }

    public String getCtWaistPktNm() {
        return ctWaistPktNm;
    }

    public void setCtWaistPktNm(String ctWaistPktNm) {
        this.ctWaistPktNm = ctWaistPktNm == null ? null : ctWaistPktNm.trim();
    }

    public Integer getCtWaistPktRtPrice() {
        return ctWaistPktRtPrice;
    }

    public void setCtWaistPktRtPrice(Integer ctWaistPktRtPrice) {
        this.ctWaistPktRtPrice = ctWaistPktRtPrice;
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
        this.ctChgPktCd = ctChgPktCd == null ? null : ctChgPktCd.trim();
    }

    public String getCtChgPktNm() {
        return ctChgPktNm;
    }

    public void setCtChgPktNm(String ctChgPktNm) {
        this.ctChgPktNm = ctChgPktNm == null ? null : ctChgPktNm.trim();
    }

    public Integer getCtChgPktRtPrice() {
        return ctChgPktRtPrice;
    }

    public void setCtChgPktRtPrice(Integer ctChgPktRtPrice) {
        this.ctChgPktRtPrice = ctChgPktRtPrice;
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
        this.ctSlantedPktCd = ctSlantedPktCd == null ? null : ctSlantedPktCd.trim();
    }

    public String getCtSlantedPktNm() {
        return ctSlantedPktNm;
    }

    public void setCtSlantedPktNm(String ctSlantedPktNm) {
        this.ctSlantedPktNm = ctSlantedPktNm == null ? null : ctSlantedPktNm.trim();
    }

    public Integer getCtSlantedPktRtPrice() {
        return ctSlantedPktRtPrice;
    }

    public void setCtSlantedPktRtPrice(Integer ctSlantedPktRtPrice) {
        this.ctSlantedPktRtPrice = ctSlantedPktRtPrice;
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
        this.ctVentCd = ctVentCd == null ? null : ctVentCd.trim();
    }

    public String getCtVentNm() {
        return ctVentNm;
    }

    public void setCtVentNm(String ctVentNm) {
        this.ctVentNm = ctVentNm == null ? null : ctVentNm.trim();
    }

    public Integer getCtVentRtPrice() {
        return ctVentRtPrice;
    }

    public void setCtVentRtPrice(Integer ctVentRtPrice) {
        this.ctVentRtPrice = ctVentRtPrice;
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
        this.ctFrtBtnCd = ctFrtBtnCd == null ? null : ctFrtBtnCd.trim();
    }

    public String getCtFrtBtnNm() {
        return ctFrtBtnNm;
    }

    public void setCtFrtBtnNm(String ctFrtBtnNm) {
        this.ctFrtBtnNm = ctFrtBtnNm == null ? null : ctFrtBtnNm.trim();
    }

    public Integer getCtFrtBtnRtPrice() {
        return ctFrtBtnRtPrice;
    }

    public void setCtFrtBtnRtPrice(Integer ctFrtBtnRtPrice) {
        this.ctFrtBtnRtPrice = ctFrtBtnRtPrice;
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
        this.ctCuffCd = ctCuffCd == null ? null : ctCuffCd.trim();
    }

    public String getCtCuffNm() {
        return ctCuffNm;
    }

    public void setCtCuffNm(String ctCuffNm) {
        this.ctCuffNm = ctCuffNm == null ? null : ctCuffNm.trim();
    }

    public Integer getCtCuffRtPrice() {
        return ctCuffRtPrice;
    }

    public void setCtCuffRtPrice(Integer ctCuffRtPrice) {
        this.ctCuffRtPrice = ctCuffRtPrice;
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
        this.ctSleeveBtnCd = ctSleeveBtnCd == null ? null : ctSleeveBtnCd.trim();
    }

    public String getCtSleeveBtnNm() {
        return ctSleeveBtnNm;
    }

    public void setCtSleeveBtnNm(String ctSleeveBtnNm) {
        this.ctSleeveBtnNm = ctSleeveBtnNm == null ? null : ctSleeveBtnNm.trim();
    }

    public Integer getCtSleeveBtnRtPrice() {
        return ctSleeveBtnRtPrice;
    }

    public void setCtSleeveBtnRtPrice(Integer ctSleeveBtnRtPrice) {
        this.ctSleeveBtnRtPrice = ctSleeveBtnRtPrice;
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
        this.ctBackBeltCd = ctBackBeltCd == null ? null : ctBackBeltCd.trim();
    }

    public String getCtBackBeltNm() {
        return ctBackBeltNm;
    }

    public void setCtBackBeltNm(String ctBackBeltNm) {
        this.ctBackBeltNm = ctBackBeltNm == null ? null : ctBackBeltNm.trim();
    }

    public Integer getCtBackBeltRtPrice() {
        return ctBackBeltRtPrice;
    }

    public void setCtBackBeltRtPrice(Integer ctBackBeltRtPrice) {
        this.ctBackBeltRtPrice = ctBackBeltRtPrice;
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
        this.ctCollarHangCd = ctCollarHangCd == null ? null : ctCollarHangCd.trim();
    }

    public String getCtCollarHangNm() {
        return ctCollarHangNm;
    }

    public void setCtCollarHangNm(String ctCollarHangNm) {
        this.ctCollarHangNm = ctCollarHangNm == null ? null : ctCollarHangNm.trim();
    }

    public Integer getCtCollarHangRtPrice() {
        return ctCollarHangRtPrice;
    }

    public void setCtCollarHangRtPrice(Integer ctCollarHangRtPrice) {
        this.ctCollarHangRtPrice = ctCollarHangRtPrice;
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
        this.ctInnerBodyClothCd = ctInnerBodyClothCd == null ? null : ctInnerBodyClothCd.trim();
    }

    public String getCtInnerBodyClothNm() {
        return ctInnerBodyClothNm;
    }

    public void setCtInnerBodyClothNm(String ctInnerBodyClothNm) {
        this.ctInnerBodyClothNm = ctInnerBodyClothNm == null ? null : ctInnerBodyClothNm.trim();
    }

    public Integer getCtInnerBodyClothRtPrice() {
        return ctInnerBodyClothRtPrice;
    }

    public void setCtInnerBodyClothRtPrice(Integer ctInnerBodyClothRtPrice) {
        this.ctInnerBodyClothRtPrice = ctInnerBodyClothRtPrice;
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
        this.ctInnerSleeveClothCd = ctInnerSleeveClothCd == null ? null : ctInnerSleeveClothCd.trim();
    }

    public String getCtInnerSleeveClothNm() {
        return ctInnerSleeveClothNm;
    }

    public void setCtInnerSleeveClothNm(String ctInnerSleeveClothNm) {
        this.ctInnerSleeveClothNm = ctInnerSleeveClothNm == null ? null : ctInnerSleeveClothNm.trim();
    }

    public Integer getCtInnerSleeveClothRtPrice() {
        return ctInnerSleeveClothRtPrice;
    }

    public void setCtInnerSleeveClothRtPrice(Integer ctInnerSleeveClothRtPrice) {
        this.ctInnerSleeveClothRtPrice = ctInnerSleeveClothRtPrice;
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
        this.ctBtnMaterialCd = ctBtnMaterialCd == null ? null : ctBtnMaterialCd.trim();
    }

    public String getCtBtnMaterialNm() {
        return ctBtnMaterialNm;
    }

    public void setCtBtnMaterialNm(String ctBtnMaterialNm) {
        this.ctBtnMaterialNm = ctBtnMaterialNm == null ? null : ctBtnMaterialNm.trim();
    }

    public Integer getCtBtnMaterialRtPrice() {
        return ctBtnMaterialRtPrice;
    }

    public void setCtBtnMaterialRtPrice(Integer ctBtnMaterialRtPrice) {
        this.ctBtnMaterialRtPrice = ctBtnMaterialRtPrice;
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
        this.stModelCd = stModelCd == null ? null : stModelCd.trim();
    }

    public String getStModelNm() {
        return stModelNm;
    }

    public void setStModelNm(String stModelNm) {
        this.stModelNm = stModelNm == null ? null : stModelNm.trim();
    }

    public Integer getStModelRtPrice() {
        return stModelRtPrice;
    }

    public void setStModelRtPrice(Integer stModelRtPrice) {
        this.stModelRtPrice = stModelRtPrice;
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
        this.stCasualHemlineCd = stCasualHemlineCd == null ? null : stCasualHemlineCd.trim();
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
        this.stCasualHemlineNm = stCasualHemlineNm == null ? null : stCasualHemlineNm.trim();
    }

    public Integer getStCasualHemlineRtPrice() {
        return stCasualHemlineRtPrice;
    }

    public void setStCasualHemlineRtPrice(Integer stCasualHemlineRtPrice) {
        this.stCasualHemlineRtPrice = stCasualHemlineRtPrice;
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
        this.stCollarTypeCd = stCollarTypeCd == null ? null : stCollarTypeCd.trim();
    }

    public String getStCollarTypeNm() {
        return stCollarTypeNm;
    }

    public void setStCollarTypeNm(String stCollarTypeNm) {
        this.stCollarTypeNm = stCollarTypeNm == null ? null : stCollarTypeNm.trim();
    }

    public Integer getStCollarTypeRtPrice() {
        return stCollarTypeRtPrice;
    }

    public void setStCollarTypeRtPrice(Integer stCollarTypeRtPrice) {
        this.stCollarTypeRtPrice = stCollarTypeRtPrice;
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
        this.stCuffsCd = stCuffsCd == null ? null : stCuffsCd.trim();
    }

    public String getStCuffsNm() {
        return stCuffsNm;
    }

    public void setStCuffsNm(String stCuffsNm) {
        this.stCuffsNm = stCuffsNm == null ? null : stCuffsNm.trim();
    }

    public Integer getStCuffsRtPrice() {
        return stCuffsRtPrice;
    }

    public void setStCuffsRtPrice(Integer stCuffsRtPrice) {
        this.stCuffsRtPrice = stCuffsRtPrice;
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
        this.stConvertibleCd = stConvertibleCd == null ? null : stConvertibleCd.trim();
    }

    public String getStConvertibleNm() {
        return stConvertibleNm;
    }

    public void setStConvertibleNm(String stConvertibleNm) {
        this.stConvertibleNm = stConvertibleNm == null ? null : stConvertibleNm.trim();
    }

    public Integer getStConvertibleRtPrice() {
        return stConvertibleRtPrice;
    }

    public void setStConvertibleRtPrice(Integer stConvertibleRtPrice) {
        this.stConvertibleRtPrice = stConvertibleRtPrice;
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
        this.stAdjusterBtnCd = stAdjusterBtnCd == null ? null : stAdjusterBtnCd.trim();
    }

    public String getStAdjusterBtnNm() {
        return stAdjusterBtnNm;
    }

    public void setStAdjusterBtnNm(String stAdjusterBtnNm) {
        this.stAdjusterBtnNm = stAdjusterBtnNm == null ? null : stAdjusterBtnNm.trim();
    }

    public Integer getStAdjusterBtnRtPrice() {
        return stAdjusterBtnRtPrice;
    }

    public void setStAdjusterBtnRtPrice(Integer stAdjusterBtnRtPrice) {
        this.stAdjusterBtnRtPrice = stAdjusterBtnRtPrice;
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
        this.stDblCuffsCd = stDblCuffsCd == null ? null : stDblCuffsCd.trim();
    }

    public String getStDblCuffsNm() {
        return stDblCuffsNm;
    }

    public void setStDblCuffsNm(String stDblCuffsNm) {
        this.stDblCuffsNm = stDblCuffsNm == null ? null : stDblCuffsNm.trim();
    }

    public Integer getStDblCuffsRtPrice() {
        return stDblCuffsRtPrice;
    }

    public void setStDblCuffsRtPrice(Integer stDblCuffsRtPrice) {
        this.stDblCuffsRtPrice = stDblCuffsRtPrice;
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
        this.stClericCd = stClericCd == null ? null : stClericCd.trim();
    }

    public String getStClericNm() {
        return stClericNm;
    }

    public void setStClericNm(String stClericNm) {
        this.stClericNm = stClericNm == null ? null : stClericNm.trim();
    }

    public Integer getStClericRtPrice() {
        return stClericRtPrice;
    }

    public void setStClericRtPrice(Integer stClericRtPrice) {
        this.stClericRtPrice = stClericRtPrice;
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
        this.stCuffsBtnCd = stCuffsBtnCd == null ? null : stCuffsBtnCd.trim();
    }

    public String getStCuffsBtnNm() {
        return stCuffsBtnNm;
    }

    public void setStCuffsBtnNm(String stCuffsBtnNm) {
        this.stCuffsBtnNm = stCuffsBtnNm == null ? null : stCuffsBtnNm.trim();
    }

    public Integer getStCuffsBtnRtPrice() {
        return stCuffsBtnRtPrice;
    }

    public void setStCuffsBtnRtPrice(Integer stCuffsBtnRtPrice) {
        this.stCuffsBtnRtPrice = stCuffsBtnRtPrice;
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
        this.stSleeveClericcd = stSleeveClericcd == null ? null : stSleeveClericcd.trim();
    }

    public String getStSleeveClericnm() {
        return stSleeveClericnm;
    }

    public void setStSleeveClericnm(String stSleeveClericnm) {
        this.stSleeveClericnm = stSleeveClericnm == null ? null : stSleeveClericnm.trim();
    }

    public Integer getStSleeveClericrtPrice() {
        return stSleeveClericrtPrice;
    }

    public void setStSleeveClericrtPrice(Integer stSleeveClericrtPrice) {
        this.stSleeveClericrtPrice = stSleeveClericrtPrice;
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
        this.stBtnMaterialCd = stBtnMaterialCd == null ? null : stBtnMaterialCd.trim();
    }

    public String getStBtnMaterialNm() {
        return stBtnMaterialNm;
    }

    public void setStBtnMaterialNm(String stBtnMaterialNm) {
        this.stBtnMaterialNm = stBtnMaterialNm == null ? null : stBtnMaterialNm.trim();
    }

    public Integer getStBtnMaterialRtPrice() {
        return stBtnMaterialRtPrice;
    }

    public void setStBtnMaterialRtPrice(Integer stBtnMaterialRtPrice) {
        this.stBtnMaterialRtPrice = stBtnMaterialRtPrice;
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
        this.stDblBtnCd = stDblBtnCd == null ? null : stDblBtnCd.trim();
    }

    public String getStDblBtnNm() {
        return stDblBtnNm;
    }

    public void setStDblBtnNm(String stDblBtnNm) {
        this.stDblBtnNm = stDblBtnNm == null ? null : stDblBtnNm.trim();
    }

    public Integer getStDblBtnRtPrice() {
        return stDblBtnRtPrice;
    }

    public void setStDblBtnRtPrice(Integer stDblBtnRtPrice) {
        this.stDblBtnRtPrice = stDblBtnRtPrice;
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
        this.stGauntletBtnPosCd = stGauntletBtnPosCd == null ? null : stGauntletBtnPosCd.trim();
    }

    public String getStGauntletBtnPosNm() {
        return stGauntletBtnPosNm;
    }

    public void setStGauntletBtnPosNm(String stGauntletBtnPosNm) {
        this.stGauntletBtnPosNm = stGauntletBtnPosNm == null ? null : stGauntletBtnPosNm.trim();
    }

    public Integer getStGauntletBtnPosRtPrice() {
        return stGauntletBtnPosRtPrice;
    }

    public void setStGauntletBtnPosRtPrice(Integer stGauntletBtnPosRtPrice) {
        this.stGauntletBtnPosRtPrice = stGauntletBtnPosRtPrice;
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
        this.stPinholePinCd = stPinholePinCd == null ? null : stPinholePinCd.trim();
    }

    public String getStPinholePinNm() {
        return stPinholePinNm;
    }

    public void setStPinholePinNm(String stPinholePinNm) {
        this.stPinholePinNm = stPinholePinNm == null ? null : stPinholePinNm.trim();
    }

    public Integer getStPinholePinRtPrice() {
        return stPinholePinRtPrice;
    }

    public void setStPinholePinRtPrice(Integer stPinholePinRtPrice) {
        this.stPinholePinRtPrice = stPinholePinRtPrice;
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
        this.stBreastPktCd = stBreastPktCd == null ? null : stBreastPktCd.trim();
    }

    public String getStBreastPktNm() {
        return stBreastPktNm;
    }

    public void setStBreastPktNm(String stBreastPktNm) {
        this.stBreastPktNm = stBreastPktNm == null ? null : stBreastPktNm.trim();
    }

    public Integer getStBreastPktRtPrice() {
        return stBreastPktRtPrice;
    }

    public void setStBreastPktRtPrice(Integer stBreastPktRtPrice) {
        this.stBreastPktRtPrice = stBreastPktRtPrice;
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
        this.stBreastSizeCd = stBreastSizeCd == null ? null : stBreastSizeCd.trim();
    }

    public String getStBreastSizeNm() {
        return stBreastSizeNm;
    }

    public void setStBreastSizeNm(String stBreastSizeNm) {
        this.stBreastSizeNm = stBreastSizeNm == null ? null : stBreastSizeNm.trim();
    }

    public Integer getStBreastSizeRtPrice() {
        return stBreastSizeRtPrice;
    }

    public void setStBreastSizeRtPrice(Integer stBreastSizeRtPrice) {
        this.stBreastSizeRtPrice = stBreastSizeRtPrice;
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
        this.stFrtDesignCd = stFrtDesignCd == null ? null : stFrtDesignCd.trim();
    }

    public String getStFrtDesignNm() {
        return stFrtDesignNm;
    }

    public void setStFrtDesignNm(String stFrtDesignNm) {
        this.stFrtDesignNm = stFrtDesignNm == null ? null : stFrtDesignNm.trim();
    }

    public Integer getStFrtDesignRtPrice() {
        return stFrtDesignRtPrice;
    }

    public void setStFrtDesignRtPrice(Integer stFrtDesignRtPrice) {
        this.stFrtDesignRtPrice = stFrtDesignRtPrice;
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
        this.stPintuckBosomCd = stPintuckBosomCd == null ? null : stPintuckBosomCd.trim();
    }

    public String getStPintuckBosomNm() {
        return stPintuckBosomNm;
    }

    public void setStPintuckBosomNm(String stPintuckBosomNm) {
        this.stPintuckBosomNm = stPintuckBosomNm == null ? null : stPintuckBosomNm.trim();
    }

    public Integer getStPintuckBosomRtPrice() {
        return stPintuckBosomRtPrice;
    }

    public void setStPintuckBosomRtPrice(Integer stPintuckBosomRtPrice) {
        this.stPintuckBosomRtPrice = stPintuckBosomRtPrice;
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
        this.stStitchCd = stStitchCd == null ? null : stStitchCd.trim();
    }

    public String getStStitchNm() {
        return stStitchNm;
    }

    public void setStStitchNm(String stStitchNm) {
        this.stStitchNm = stStitchNm == null ? null : stStitchNm.trim();
    }

    public Integer getStStitchRtPrice() {
        return stStitchRtPrice;
    }

    public void setStStitchRtPrice(Integer stStitchRtPrice) {
        this.stStitchRtPrice = stStitchRtPrice;
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
        this.stColarKeeperCd = stColarKeeperCd == null ? null : stColarKeeperCd.trim();
    }

    public String getStColarKeeperNm() {
        return stColarKeeperNm;
    }

    public void setStColarKeeperNm(String stColarKeeperNm) {
        this.stColarKeeperNm = stColarKeeperNm == null ? null : stColarKeeperNm.trim();
    }

    public Integer getStColarKeeperRtPrice() {
        return stColarKeeperRtPrice;
    }

    public void setStColarKeeperRtPrice(Integer stColarKeeperRtPrice) {
        this.stColarKeeperRtPrice = stColarKeeperRtPrice;
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
        this.stBtnthreadColorCd = stBtnthreadColorCd == null ? null : stBtnthreadColorCd.trim();
    }

    public String getStBtnthreadColorNm() {
        return stBtnthreadColorNm;
    }

    public void setStBtnthreadColorNm(String stBtnthreadColorNm) {
        this.stBtnthreadColorNm = stBtnthreadColorNm == null ? null : stBtnthreadColorNm.trim();
    }

    public Integer getStBtnthreadColorRtPrice() {
        return stBtnthreadColorRtPrice;
    }

    public void setStBtnthreadColorRtPrice(Integer stBtnthreadColorRtPrice) {
        this.stBtnthreadColorRtPrice = stBtnthreadColorRtPrice;
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
        this.stBtnholeColorCd = stBtnholeColorCd == null ? null : stBtnholeColorCd.trim();
    }

    public String getStBtnholeColorNm() {
        return stBtnholeColorNm;
    }

    public void setStBtnholeColorNm(String stBtnholeColorNm) {
        this.stBtnholeColorNm = stBtnholeColorNm == null ? null : stBtnholeColorNm.trim();
    }

    public Integer getStBtnholeColorRtPrice() {
        return stBtnholeColorRtPrice;
    }

    public void setStBtnholeColorRtPrice(Integer stBtnholeColorRtPrice) {
        this.stBtnholeColorRtPrice = stBtnholeColorRtPrice;
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
        this.stBtnposChgCd = stBtnposChgCd == null ? null : stBtnposChgCd.trim();
    }

    public String getStBtnposChgNm() {
        return stBtnposChgNm;
    }

    public void setStBtnposChgNm(String stBtnposChgNm) {
        this.stBtnposChgNm = stBtnposChgNm == null ? null : stBtnposChgNm.trim();
    }

    public Integer getStBtnposChgRtPrice() {
        return stBtnposChgRtPrice;
    }

    public void setStBtnposChgRtPrice(Integer stBtnposChgRtPrice) {
        this.stBtnposChgRtPrice = stBtnposChgRtPrice;
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
        this.stNeckbandBtnChgCd = stNeckbandBtnChgCd == null ? null : stNeckbandBtnChgCd.trim();
    }

    public String getStNeckbandBtnChgNm() {
        return stNeckbandBtnChgNm;
    }

    public void setStNeckbandBtnChgNm(String stNeckbandBtnChgNm) {
        this.stNeckbandBtnChgNm = stNeckbandBtnChgNm == null ? null : stNeckbandBtnChgNm.trim();
    }

    public Integer getStNeckbandBtnChgRtPrice() {
        return stNeckbandBtnChgRtPrice;
    }

    public void setStNeckbandBtnChgRtPrice(Integer stNeckbandBtnChgRtPrice) {
        this.stNeckbandBtnChgRtPrice = stNeckbandBtnChgRtPrice;
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
        this.stFrtfirstBtnChgCd = stFrtfirstBtnChgCd == null ? null : stFrtfirstBtnChgCd.trim();
    }

    public String getStFrtfirstBtnChgNm() {
        return stFrtfirstBtnChgNm;
    }

    public void setStFrtfirstBtnChgNm(String stFrtfirstBtnChgNm) {
        this.stFrtfirstBtnChgNm = stFrtfirstBtnChgNm == null ? null : stFrtfirstBtnChgNm.trim();
    }

    public Integer getStFrtfirstBtnChgRtPrice() {
        return stFrtfirstBtnChgRtPrice;
    }

    public void setStFrtfirstBtnChgRtPrice(Integer stFrtfirstBtnChgRtPrice) {
        this.stFrtfirstBtnChgRtPrice = stFrtfirstBtnChgRtPrice;
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
        this.stFrtsecondBtnChgCd = stFrtsecondBtnChgCd == null ? null : stFrtsecondBtnChgCd.trim();
    }

    public String getStFrtsecondBtnChgNm() {
        return stFrtsecondBtnChgNm;
    }

    public void setStFrtsecondBtnChgNm(String stFrtsecondBtnChgNm) {
        this.stFrtsecondBtnChgNm = stFrtsecondBtnChgNm == null ? null : stFrtsecondBtnChgNm.trim();
    }

    public Integer getStFrtsecondBtnChgRtPrice() {
        return stFrtsecondBtnChgRtPrice;
    }

    public void setStFrtsecondBtnChgRtPrice(Integer stFrtsecondBtnChgRtPrice) {
        this.stFrtsecondBtnChgRtPrice = stFrtsecondBtnChgRtPrice;
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
        this.corJkDrop = corJkDrop == null ? null : corJkDrop.trim();
    }

    public String getCorJkSize() {
        return corJkSize;
    }

    public void setCorJkSize(String corJkSize) {
        this.corJkSize = corJkSize == null ? null : corJkSize.trim();
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
        this.corJkShoulderpad = corJkShoulderpad == null ? null : corJkShoulderpad.trim();
    }

    public String getCorJkFigureCorrect() {
        return corJkFigureCorrect;
    }

    public void setCorJkFigureCorrect(String corJkFigureCorrect) {
        this.corJkFigureCorrect = corJkFigureCorrect == null ? null : corJkFigureCorrect.trim();
    }

    public String getCorPtDrop() {
        return corPtDrop;
    }

    public void setCorPtDrop(String corPtDrop) {
        this.corPtDrop = corPtDrop == null ? null : corPtDrop.trim();
    }

    public String getCorPtSize() {
        return corPtSize;
    }

    public void setCorPtSize(String corPtSize) {
        this.corPtSize = corPtSize == null ? null : corPtSize.trim();
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
        this.corPtHemwidthType = corPtHemwidthType == null ? null : corPtHemwidthType.trim();
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
        this.corPt2Drop = corPt2Drop == null ? null : corPt2Drop.trim();
    }

    public String getCorPt2Size() {
        return corPt2Size;
    }

    public void setCorPt2Size(String corPt2Size) {
        this.corPt2Size = corPt2Size == null ? null : corPt2Size.trim();
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
        this.corPt2HemwidthType = corPt2HemwidthType == null ? null : corPt2HemwidthType.trim();
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
        this.corGlDrop = corGlDrop == null ? null : corGlDrop.trim();
    }

    public String getCorGlSize() {
        return corGlSize;
    }

    public void setCorGlSize(String corGlSize) {
        this.corGlSize = corGlSize == null ? null : corGlSize.trim();
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
        this.corCtSize = corCtSize == null ? null : corCtSize.trim();
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
        this.corStSize = corStSize == null ? null : corStSize.trim();
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
        this.corStoreCorrectionMemo = corStoreCorrectionMemo == null ? null : corStoreCorrectionMemo.trim();
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
        this.corStoreCorrectionMemoAgain = corStoreCorrectionMemoAgain == null ? null : corStoreCorrectionMemoAgain.trim();
    }

    public String getHostTransmitARow() {
        return hostTransmitARow;
    }

    public void setHostTransmitARow(String hostTransmitARow) {
        this.hostTransmitARow = hostTransmitARow == null ? null : hostTransmitARow.trim();
    }

    public String getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        this.shippingNumber = shippingNumber == null ? null : shippingNumber.trim();
    }

    public String getHostTransmitStoreCd() {
        return hostTransmitStoreCd;
    }

    public void setHostTransmitStoreCd(String hostTransmitStoreCd) {
        this.hostTransmitStoreCd = hostTransmitStoreCd == null ? null : hostTransmitStoreCd.trim();
    }

    public String getHostTransmitItemCd() {
        return hostTransmitItemCd;
    }

    public void setHostTransmitItemCd(String hostTransmitItemCd) {
        this.hostTransmitItemCd = hostTransmitItemCd == null ? null : hostTransmitItemCd.trim();
    }

    public String getHostTransmitMakerCd() {
        return hostTransmitMakerCd;
    }

    public void setHostTransmitMakerCd(String hostTransmitMakerCd) {
        this.hostTransmitMakerCd = hostTransmitMakerCd == null ? null : hostTransmitMakerCd.trim();
    }

    public String getHostTransmitNenkiCd() {
        return hostTransmitNenkiCd;
    }

    public void setHostTransmitNenkiCd(String hostTransmitNenkiCd) {
        this.hostTransmitNenkiCd = hostTransmitNenkiCd == null ? null : hostTransmitNenkiCd.trim();
    }

    public String getHostTransmitColorCd() {
        return hostTransmitColorCd;
    }

    public void setHostTransmitColorCd(String hostTransmitColorCd) {
        this.hostTransmitColorCd = hostTransmitColorCd == null ? null : hostTransmitColorCd.trim();
    }

    public String getHostTransmitSize() {
        return hostTransmitSize;
    }

    public void setHostTransmitSize(String hostTransmitSize) {
        this.hostTransmitSize = hostTransmitSize == null ? null : hostTransmitSize;
    }

    public String getHostTransmitMakerProduct() {
        return hostTransmitMakerProduct;
    }

    public void setHostTransmitMakerProduct(String hostTransmitMakerProduct) {
        this.hostTransmitMakerProduct = hostTransmitMakerProduct == null ? null : hostTransmitMakerProduct.trim();
    }

    public String getFactoryShippingMethod() {
        return factoryShippingMethod;
    }

    public void setFactoryShippingMethod(String factoryShippingMethod) {
        this.factoryShippingMethod = factoryShippingMethod == null ? null : factoryShippingMethod.trim();
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
        this.tscStatus = tscStatus == null ? null : tscStatus.trim();
    }

    public String getMakerFactoryStatus() {
        return makerFactoryStatus;
    }

    public void setMakerFactoryStatus(String makerFactoryStatus) {
        this.makerFactoryStatus = makerFactoryStatus == null ? null : makerFactoryStatus.trim();
    }

    public String getSend2factoryStatus() {
        return send2factoryStatus;
    }

    public void setSend2factoryStatus(String send2factoryStatus) {
        this.send2factoryStatus = send2factoryStatus == null ? null : send2factoryStatus.trim();
    }

    public String getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(String isCancelled) {
        this.isCancelled = isCancelled == null ? null : isCancelled.trim();
    }

    public String getTheoreticalStockCheck() {
        return theoreticalStockCheck;
    }

    public void setTheoreticalStockCheck(String theoreticalStockCheck) {
        this.theoreticalStockCheck = theoreticalStockCheck == null ? null : theoreticalStockCheck.trim();
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
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
        this.updatedUserId = updatedUserId == null ? null : updatedUserId.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFabricColor() {
        return fabricColor;
    }

    public void setFabricColor(String fabricColor) {
        this.fabricColor = fabricColor == null ? null : fabricColor.trim();
    }

    public String getFabricPattern() {
        return fabricPattern;
    }

    public void setFabricPattern(String fabricPattern) {
        this.fabricPattern = fabricPattern == null ? null : fabricPattern.trim();
    }
    
	public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
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
		builder.append(billingAmount == null ? "" : billingAmount);
		builder.append(",");
		builder.append(productPrice == null ? "" : productPrice);
		builder.append(",");
		builder.append(optionPrice == null ? "" : optionPrice);
		builder.append(",");
		builder.append(totalPrice == null ? "" : totalPrice);
		builder.append(",");
		builder.append(consumptionTaxAmount == null ? "" : consumptionTaxAmount);
		builder.append(",");
		builder.append(salesAmount == null ? "" : salesAmount);
		builder.append(",");
		builder.append(wsPrice == null ? "" : wsPrice);
		builder.append(",");
		builder.append(cashId == null ? "" : cashId);
		builder.append(",");
		builder.append(cashDiscountPrice == null ? "" : cashDiscountPrice);
		builder.append(",");
		builder.append(cashProductPrice == null ? "" : cashProductPrice);
		builder.append(",");
		builder.append(cashContailTaxProductPrice == null ? "" : cashContailTaxProductPrice);
		builder.append(",");
		builder.append(storeNm == null ? "" : storeNm);
		builder.append(",");
		builder.append(storeStaffNm == null ? "" : storeStaffNm);
		builder.append(",");
		builder.append(printoutCustRomaNm == null ? "" : printoutCustRomaNm);
		builder.append(",");
		builder.append(printoutStoreStaffRomaNm == null ? "" : printoutStoreStaffRomaNm);
		builder.append(",");
		builder.append(custCd == null ? "" : custCd);
		builder.append(",");
		builder.append(custNm == null ? "" : custNm);
		builder.append(",");
		builder.append(custKanaNm == null ? "" : custKanaNm);
		builder.append(",");
		builder.append(custDeliverDate == null ? "" : custDeliverDate);
		builder.append(",");
		builder.append(custIsDeliverShortning == null ? "" : custIsDeliverShortning);
		builder.append(",");
		builder.append(custIsEarlyDiscount == null ? "" : custIsEarlyDiscount);
		builder.append(",");
		builder.append(custShopDeliveryDate == null ? "" : custShopDeliveryDate);
		builder.append(",");
		builder.append(custStaff == null ? "" : custStaff);
		builder.append(",");
		builder.append(custType == null ? "" : custType);
		builder.append(",");
		builder.append(custShippingDestination == null ? "" : custShippingDestination);
		builder.append(",");
		builder.append(custShippingDestnationOtherstore == null ? "" : custShippingDestnationOtherstore);
		builder.append(",");
		builder.append(custRemark == null ? "" : custRemark);
		builder.append(",");
		builder.append(productItem == null ? "" : productItem);
		builder.append(",");
		builder.append(productIs3piece == null ? "" : productIs3piece);
		builder.append(",");
		builder.append(productIs3pieceRtPrice == null ? "" : productIs3pieceRtPrice);
		builder.append(",");
		builder.append(productIs3pieceWsWage == null ? "" : productIs3pieceWsWage);
		builder.append(",");
		builder.append(productIs3pieceWsPrice == null ? "" : productIs3pieceWsPrice);
		builder.append(",");
		builder.append(productSparePantsClass == null ? "" : productSparePantsClass);
		builder.append(",");
		builder.append(productSparePantsRtPrice == null ? "" : productSparePantsRtPrice);
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
		builder.append(productEmbroideryGazetteRtPrice == null ? "" : productEmbroideryGazetteRtPrice);
		builder.append(",");
		builder.append(productEmbroideryGazetteWsWage == null ? "" : productEmbroideryGazetteWsWage);
		builder.append(",");
		builder.append(productEmbroideryGazetteWsPrice == null ? "" : productEmbroideryGazetteWsPrice);
		builder.append(",");
		builder.append(productEmbroideryNmPos == null ? "" : productEmbroideryNmPos);
		builder.append(",");
		builder.append(productEmbroideryNmPosRtPrice == null ? "" : productEmbroideryNmPosRtPrice);
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
		builder.append(jkModelRtPrice == null ? "" : jkModelRtPrice);
		builder.append(",");
		builder.append(jkModelWsWage == null ? "" : jkModelWsWage);
		builder.append(",");
		builder.append(jkModelWsPrice == null ? "" : jkModelWsPrice);
		builder.append(",");
		builder.append(jkFrtBtnCd == null ? "" : jkFrtBtnCd);
		builder.append(",");
		builder.append(jkFrtBtnNm == null ? "" : jkFrtBtnNm);
		builder.append(",");
		builder.append(jkFrtBtnRtPrice == null ? "" : jkFrtBtnRtPrice);
		builder.append(",");
		builder.append(jkFrtBtnWsWage == null ? "" : jkFrtBtnWsWage);
		builder.append(",");
		builder.append(jkFrtBtnWsPrice == null ? "" : jkFrtBtnWsPrice);
		builder.append(",");
		builder.append(jkLapelDesignCd == null ? "" : jkLapelDesignCd);
		builder.append(",");
		builder.append(jkLapelDesignNm == null ? "" : jkLapelDesignNm);
		builder.append(",");
		builder.append(jkLapelDesignRtPrice == null ? "" : jkLapelDesignRtPrice);
		builder.append(",");
		builder.append(jkLapelDesignWsWage == null ? "" : jkLapelDesignWsWage);
		builder.append(",");
		builder.append(jkLapelDesignWsPrice == null ? "" : jkLapelDesignWsPrice);
		builder.append(",");
		builder.append(jkLapelModelCd == null ? "" : jkLapelModelCd);
		builder.append(",");
		builder.append(jkLapelModelNm == null ? "" : jkLapelModelNm);
		builder.append(",");
		builder.append(jkLapelModelRtPrice == null ? "" : jkLapelModelRtPrice);
		builder.append(",");
		builder.append(jkLapelModelWsWage == null ? "" : jkLapelModelWsWage);
		builder.append(",");
		builder.append(jkLapelModelWsPrice == null ? "" : jkLapelModelWsPrice);
		builder.append(",");
		builder.append(jkGradeCd == null ? "" : jkGradeCd);
		builder.append(",");
		builder.append(jkGradeNm == null ? "" : jkGradeNm);
		builder.append(",");
		builder.append(jkGradeRtPrice == null ? "" : jkGradeRtPrice);
		builder.append(",");
		builder.append(jkGradeWsWage == null ? "" : jkGradeWsWage);
		builder.append(",");
		builder.append(jkGradeWsPrice == null ? "" : jkGradeWsPrice);
		builder.append(",");
		builder.append(jkInnerClothCd == null ? "" : jkInnerClothCd);
		builder.append(",");
		builder.append(jkInnerClothNm == null ? "" : jkInnerClothNm);
		builder.append(",");
		builder.append(jkInnerClothRtPrice == null ? "" : jkInnerClothRtPrice);
		builder.append(",");
		builder.append(jkInnerClothWsWage == null ? "" : jkInnerClothWsWage);
		builder.append(",");
		builder.append(jkInnerClothWsPrice == null ? "" : jkInnerClothWsPrice);
		builder.append(",");
		builder.append(jkDaibaCd == null ? "" : jkDaibaCd);
		builder.append(",");
		builder.append(jkDaibaNm == null ? "" : jkDaibaNm);
		builder.append(",");
		builder.append(jkDaibaRtPrice == null ? "" : jkDaibaRtPrice);
		builder.append(",");
		builder.append(jkDaibaWsWage == null ? "" : jkDaibaWsWage);
		builder.append(",");
		builder.append(jkDaibaWsPrice == null ? "" : jkDaibaWsPrice);
		builder.append(",");
		builder.append(jkLookClothCd == null ? "" : jkLookClothCd);
		builder.append(",");
		builder.append(jkLookClothNm == null ? "" : jkLookClothNm);
		builder.append(",");
		builder.append(jkLookClothRtPrice == null ? "" : jkLookClothRtPrice);
		builder.append(",");
		builder.append(jkLookClothWsWage == null ? "" : jkLookClothWsWage);
		builder.append(",");
		builder.append(jkLookClothWsPrice == null ? "" : jkLookClothWsPrice);
		builder.append(",");
		builder.append(jkCollarInnerCd == null ? "" : jkCollarInnerCd);
		builder.append(",");
		builder.append(jkCollarInnerNm == null ? "" : jkCollarInnerNm);
		builder.append(",");
		builder.append(jkCollarInnerRtPrice == null ? "" : jkCollarInnerRtPrice);
		builder.append(",");
		builder.append(jkCollarInnerWsWage == null ? "" : jkCollarInnerWsWage);
		builder.append(",");
		builder.append(jkCollarInnerWsPrice == null ? "" : jkCollarInnerWsPrice);
		builder.append(",");
		builder.append(jkCollarHangCd == null ? "" : jkCollarHangCd);
		builder.append(",");
		builder.append(jkCollarHangNm == null ? "" : jkCollarHangNm);
		builder.append(",");
		builder.append(jkCollarHangRtPrice == null ? "" : jkCollarHangRtPrice);
		builder.append(",");
		builder.append(jkCollarHangWsWage == null ? "" : jkCollarHangWsWage);
		builder.append(",");
		builder.append(jkCollarHangWsPrice == null ? "" : jkCollarHangWsPrice);
		builder.append(",");
		builder.append(jkLapelWidthCd == null ? "" : jkLapelWidthCd);
		builder.append(",");
		builder.append(jkLapelWidthNm == null ? "" : jkLapelWidthNm);
		builder.append(",");
		builder.append(jkLapelWidthRtPrice == null ? "" : jkLapelWidthRtPrice);
		builder.append(",");
		builder.append(jkLapelWidthWsWage == null ? "" : jkLapelWidthWsWage);
		builder.append(",");
		builder.append(jkLapelWidthWsPrice == null ? "" : jkLapelWidthWsPrice);
		builder.append(",");
		builder.append(jkFlowerHoleCd == null ? "" : jkFlowerHoleCd);
		builder.append(",");
		builder.append(jkFlowerHoleNm == null ? "" : jkFlowerHoleNm);
		builder.append(",");
		builder.append(jkFlowerHoleRtPrice == null ? "" : jkFlowerHoleRtPrice);
		builder.append(",");
		builder.append(jkFlowerHoleWsWage == null ? "" : jkFlowerHoleWsWage);
		builder.append(",");
		builder.append(jkFlowerHoleWsPrice == null ? "" : jkFlowerHoleWsPrice);
		builder.append(",");
		builder.append(jkBreastPktCd == null ? "" : jkBreastPktCd);
		builder.append(",");
		builder.append(jkBreastPktNm == null ? "" : jkBreastPktNm);
		builder.append(",");
		builder.append(jkBreastPktRtPrice == null ? "" : jkBreastPktRtPrice);
		builder.append(",");
		builder.append(jkBreastPktWsWage == null ? "" : jkBreastPktWsWage);
		builder.append(",");
		builder.append(jkBreastPktWsPrice == null ? "" : jkBreastPktWsPrice);
		builder.append(",");
		builder.append(jkWaistPktCd == null ? "" : jkWaistPktCd);
		builder.append(",");
		builder.append(jkWaistPktNm == null ? "" : jkWaistPktNm);
		builder.append(",");
		builder.append(jkWaistPktRtPrice == null ? "" : jkWaistPktRtPrice);
		builder.append(",");
		builder.append(jkWaistPktWsWage == null ? "" : jkWaistPktWsWage);
		builder.append(",");
		builder.append(jkWaistPktWsPrice == null ? "" : jkWaistPktWsPrice);
		builder.append(",");
		builder.append(jkChgPktCd == null ? "" : jkChgPktCd);
		builder.append(",");
		builder.append(jkChgPktNm == null ? "" : jkChgPktNm);
		builder.append(",");
		builder.append(jkChgPktRtPrice == null ? "" : jkChgPktRtPrice);
		builder.append(",");
		builder.append(jkChgPktWsWage == null ? "" : jkChgPktWsWage);
		builder.append(",");
		builder.append(jkChgPktWsPrice == null ? "" : jkChgPktWsPrice);
		builder.append(",");
		builder.append(jkSlantedPktCd == null ? "" : jkSlantedPktCd);
		builder.append(",");
		builder.append(jkSlantedPktNm == null ? "" : jkSlantedPktNm);
		builder.append(",");
		builder.append(jkSlantedPktRtPrice == null ? "" : jkSlantedPktRtPrice);
		builder.append(",");
		builder.append(jkSlantedPktWsWage == null ? "" : jkSlantedPktWsWage);
		builder.append(",");
		builder.append(jkSlantedPktWsPrice == null ? "" : jkSlantedPktWsPrice);
		builder.append(",");
		builder.append(jkShinobiPktCd == null ? "" : jkShinobiPktCd);
		builder.append(",");
		builder.append(jkShinobiPktNm == null ? "" : jkShinobiPktNm);
		builder.append(",");
		builder.append(jkShinobiPktRtPrice == null ? "" : jkShinobiPktRtPrice);
		builder.append(",");
		builder.append(jkShinobiPktWsWage == null ? "" : jkShinobiPktWsWage);
		builder.append(",");
		builder.append(jkShinobiPktWsPrice == null ? "" : jkShinobiPktWsPrice);
		builder.append(",");
		builder.append(jkSleeveTypeCd == null ? "" : jkSleeveTypeCd);
		builder.append(",");
		builder.append(jkSleeveTypeNm == null ? "" : jkSleeveTypeNm);
		builder.append(",");
		builder.append(jkSleeveTypeRtPrice == null ? "" : jkSleeveTypeRtPrice);
		builder.append(",");
		builder.append(jkSleeveTypeWsWage == null ? "" : jkSleeveTypeWsWage);
		builder.append(",");
		builder.append(jkSleeveTypeWsPrice == null ? "" : jkSleeveTypeWsPrice);
		builder.append(",");
		builder.append(jkManicaCd == null ? "" : jkManicaCd);
		builder.append(",");
		builder.append(jkManicaNm == null ? "" : jkManicaNm);
		builder.append(",");
		builder.append(jkManicaRtPrice == null ? "" : jkManicaRtPrice);
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
		builder.append(jkSleeveBtnRtPrice == null ? "" : jkSleeveBtnRtPrice);
		builder.append(",");
		builder.append(jkSleeveBtnWsWage == null ? "" : jkSleeveBtnWsWage);
		builder.append(",");
		builder.append(jkSleeveBtnWsPrice == null ? "" : jkSleeveBtnWsPrice);
		builder.append(",");
		builder.append(jkCuffCd == null ? "" : jkCuffCd);
		builder.append(",");
		builder.append(jkCuffNm == null ? "" : jkCuffNm);
		builder.append(",");
		builder.append(jkCuffRtPrice == null ? "" : jkCuffRtPrice);
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
		builder.append(jkInnerPktRtPrice == null ? "" : jkInnerPktRtPrice);
		builder.append(",");
		builder.append(jkInnerPktWsWage == null ? "" : jkInnerPktWsWage);
		builder.append(",");
		builder.append(jkInnerPktWsPrice == null ? "" : jkInnerPktWsPrice);
		builder.append(",");
		builder.append(jkRightInnerPktTypeCd == null ? "" : jkRightInnerPktTypeCd);
		builder.append(",");
		builder.append(jkRightInnerPktTypeNm == null ? "" : jkRightInnerPktTypeNm);
		builder.append(",");
		builder.append(jkRightInnerPktTypeRtPrice == null ? "" : jkRightInnerPktTypeRtPrice);
		builder.append(",");
		builder.append(jkRightInnerPktTypeWsWage == null ? "" : jkRightInnerPktTypeWsWage);
		builder.append(",");
		builder.append(jkRightInnerPktTypeWsPrice == null ? "" : jkRightInnerPktTypeWsPrice);
		builder.append(",");
		builder.append(jkStitchTypeCd == null ? "" : jkStitchTypeCd);
		builder.append(",");
		builder.append(jkStitchTypeNm == null ? "" : jkStitchTypeNm);
		builder.append(",");
		builder.append(jkStitchTypeRtPrice == null ? "" : jkStitchTypeRtPrice);
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
		builder.append(jkStitchPlcRtPrice == null ? "" : jkStitchPlcRtPrice);
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
		builder.append(jkDblstitchPlcRtPrice == null ? "" : jkDblstitchPlcRtPrice);
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
		builder.append(jkAmfColorRtPrice == null ? "" : jkAmfColorRtPrice);
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
		builder.append(jkBtnholePlcColorRtPrice == null ? "" : jkBtnholePlcColorRtPrice);
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
		builder.append(jkBtnthreadPlcColorRtPrice == null ? "" : jkBtnthreadPlcColorRtPrice);
		builder.append(",");
		builder.append(jkBtnthreadPlcColorWsWage == null ? "" : jkBtnthreadPlcColorWsWage);
		builder.append(",");
		builder.append(jkBtnthreadPlcColorWsPrice == null ? "" : jkBtnthreadPlcColorWsPrice);
		builder.append(",");
		builder.append(jkVentCd == null ? "" : jkVentCd);
		builder.append(",");
		builder.append(jkVentNm == null ? "" : jkVentNm);
		builder.append(",");
		builder.append(jkVentRtPrice == null ? "" : jkVentRtPrice);
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
		builder.append(jkInnerBodyClothRtPrice == null ? "" : jkInnerBodyClothRtPrice);
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
		builder.append(jkInnerSleeveClothRtPrice == null ? "" : jkInnerSleeveClothRtPrice);
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
		builder.append(jkBtnMaterialRtPrice == null ? "" : jkBtnMaterialRtPrice);
		builder.append(",");
		builder.append(jkBtnMaterialWsWage == null ? "" : jkBtnMaterialWsWage);
		builder.append(",");
		builder.append(jkBtnMaterialWsPrice == null ? "" : jkBtnMaterialWsPrice);
		builder.append(",");
		builder.append(jkShapeMemoryCd == null ? "" : jkShapeMemoryCd);
		builder.append(",");
		builder.append(jkShapeMemoryNm == null ? "" : jkShapeMemoryNm);
		builder.append(",");
		builder.append(jkShapeMemoryRtPrice == null ? "" : jkShapeMemoryRtPrice);
		builder.append(",");
		builder.append(jkShapeMemoryWsWage == null ? "" : jkShapeMemoryWsWage);
		builder.append(",");
		builder.append(jkShapeMemoryWsPrice == null ? "" : jkShapeMemoryWsPrice);
		builder.append(",");
		builder.append(ptModelCd == null ? "" : ptModelCd);
		builder.append(",");
		builder.append(ptModelNm == null ? "" : ptModelNm);
		builder.append(",");
		builder.append(ptModelRtPrice == null ? "" : ptModelRtPrice);
		builder.append(",");
		builder.append(ptModelWsWage == null ? "" : ptModelWsWage);
		builder.append(",");
		builder.append(ptModelWsPrice == null ? "" : ptModelWsPrice);
		builder.append(",");
		builder.append(ptTackCd == null ? "" : ptTackCd);
		builder.append(",");
		builder.append(ptTackNm == null ? "" : ptTackNm);
		builder.append(",");
		builder.append(ptTackRtPrice == null ? "" : ptTackRtPrice);
		builder.append(",");
		builder.append(ptTackWsWage == null ? "" : ptTackWsWage);
		builder.append(",");
		builder.append(ptTackWsPrice == null ? "" : ptTackWsPrice);
		builder.append(",");
		builder.append(ptKneeinnerTypeCd == null ? "" : ptKneeinnerTypeCd);
		builder.append(",");
		builder.append(ptKneeinnerTypeNm == null ? "" : ptKneeinnerTypeNm);
		builder.append(",");
		builder.append(ptKneeinnerTypeRtPrice == null ? "" : ptKneeinnerTypeRtPrice);
		builder.append(",");
		builder.append(ptKneeinnerTypeWsWage == null ? "" : ptKneeinnerTypeWsWage);
		builder.append(",");
		builder.append(ptKneeinnerTypeWsPrice == null ? "" : ptKneeinnerTypeWsPrice);
		builder.append(",");
		builder.append(ptKneeinnerClothCd == null ? "" : ptKneeinnerClothCd);
		builder.append(",");
		builder.append(ptKneeinnerClothNm == null ? "" : ptKneeinnerClothNm);
		builder.append(",");
		builder.append(ptKneeinnerClothRtPrice == null ? "" : ptKneeinnerClothRtPrice);
		builder.append(",");
		builder.append(ptKneeinnerClothWsWage == null ? "" : ptKneeinnerClothWsWage);
		builder.append(",");
		builder.append(ptKneeinnerClothWsPrice == null ? "" : ptKneeinnerClothWsPrice);
		builder.append(",");
		builder.append(ptFrtTypeCd == null ? "" : ptFrtTypeCd);
		builder.append(",");
		builder.append(ptFrtTypeNm == null ? "" : ptFrtTypeNm);
		builder.append(",");
		builder.append(ptFrtTypeRtPrice == null ? "" : ptFrtTypeRtPrice);
		builder.append(",");
		builder.append(ptFrtTypeWsWage == null ? "" : ptFrtTypeWsWage);
		builder.append(",");
		builder.append(ptFrtTypeWsPrice == null ? "" : ptFrtTypeWsPrice);
		builder.append(",");
		builder.append(ptPancherinaCd == null ? "" : ptPancherinaCd);
		builder.append(",");
		builder.append(ptPancherinaNm == null ? "" : ptPancherinaNm);
		builder.append(",");
		builder.append(ptPancherinaRtPrice == null ? "" : ptPancherinaRtPrice);
		builder.append(",");
		builder.append(ptPancherinaWsWage == null ? "" : ptPancherinaWsWage);
		builder.append(",");
		builder.append(ptPancherinaWsPrice == null ? "" : ptPancherinaWsPrice);
		builder.append(",");
		builder.append(ptAdjusterCd == null ? "" : ptAdjusterCd);
		builder.append(",");
		builder.append(ptAdjusterNm == null ? "" : ptAdjusterNm);
		builder.append(",");
		builder.append(ptAdjusterRtPrice == null ? "" : ptAdjusterRtPrice);
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
		builder.append(ptBeltloopRtPrice == null ? "" : ptBeltloopRtPrice);
		builder.append(",");
		builder.append(ptBeltloopWsWage == null ? "" : ptBeltloopWsWage);
		builder.append(",");
		builder.append(ptBeltloopWsPrice == null ? "" : ptBeltloopWsPrice);
		builder.append(",");
		builder.append(ptPinloopCd == null ? "" : ptPinloopCd);
		builder.append(",");
		builder.append(ptPinloopNm == null ? "" : ptPinloopNm);
		builder.append(",");
		builder.append(ptPinloopRtPrice == null ? "" : ptPinloopRtPrice);
		builder.append(",");
		builder.append(ptPinloopWsWage == null ? "" : ptPinloopWsWage);
		builder.append(",");
		builder.append(ptPinloopWsPrice == null ? "" : ptPinloopWsPrice);
		builder.append(",");
		builder.append(ptSidePktCd == null ? "" : ptSidePktCd);
		builder.append(",");
		builder.append(ptSidePktNm == null ? "" : ptSidePktNm);
		builder.append(",");
		builder.append(ptSidePktRtPrice == null ? "" : ptSidePktRtPrice);
		builder.append(",");
		builder.append(ptSidePktWsWage == null ? "" : ptSidePktWsWage);
		builder.append(",");
		builder.append(ptSidePktWsPrice == null ? "" : ptSidePktWsPrice);
		builder.append(",");
		builder.append(ptShinobiPktCd == null ? "" : ptShinobiPktCd);
		builder.append(",");
		builder.append(ptShinobiPktNm == null ? "" : ptShinobiPktNm);
		builder.append(",");
		builder.append(ptShinobiPktRtPrice == null ? "" : ptShinobiPktRtPrice);
		builder.append(",");
		builder.append(ptShinobiPktWsWage == null ? "" : ptShinobiPktWsWage);
		builder.append(",");
		builder.append(ptShinobiPktWsPrice == null ? "" : ptShinobiPktWsPrice);
		builder.append(",");
		builder.append(ptCoinPktCd == null ? "" : ptCoinPktCd);
		builder.append(",");
		builder.append(ptCoinPktNm == null ? "" : ptCoinPktNm);
		builder.append(",");
		builder.append(ptCoinPktRtPrice == null ? "" : ptCoinPktRtPrice);
		builder.append(",");
		builder.append(ptCoinPktWsWage == null ? "" : ptCoinPktWsWage);
		builder.append(",");
		builder.append(ptCoinPktWsPrice == null ? "" : ptCoinPktWsPrice);
		builder.append(",");
		builder.append(ptFlapcoinPktCd == null ? "" : ptFlapcoinPktCd);
		builder.append(",");
		builder.append(ptFlapcoinPktNm == null ? "" : ptFlapcoinPktNm);
		builder.append(",");
		builder.append(ptFlapcoinPktRtPrice == null ? "" : ptFlapcoinPktRtPrice);
		builder.append(",");
		builder.append(ptFlapcoinPktWsWage == null ? "" : ptFlapcoinPktWsWage);
		builder.append(",");
		builder.append(ptFlapcoinPktWsPrice == null ? "" : ptFlapcoinPktWsPrice);
		builder.append(",");
		builder.append(ptLeftPisPktCd == null ? "" : ptLeftPisPktCd);
		builder.append(",");
		builder.append(ptLeftPisPktNm == null ? "" : ptLeftPisPktNm);
		builder.append(",");
		builder.append(ptLeftPisPktRtPrice == null ? "" : ptLeftPisPktRtPrice);
		builder.append(",");
		builder.append(ptLeftPisPktWsWage == null ? "" : ptLeftPisPktWsWage);
		builder.append(",");
		builder.append(ptLeftPisPktWsPrice == null ? "" : ptLeftPisPktWsPrice);
		builder.append(",");
		builder.append(ptRightPisPktCd == null ? "" : ptRightPisPktCd);
		builder.append(",");
		builder.append(ptRightPisPktNm == null ? "" : ptRightPisPktNm);
		builder.append(",");
		builder.append(ptRightPisPktRtPrice == null ? "" : ptRightPisPktRtPrice);
		builder.append(",");
		builder.append(ptRightPisPktWsWage == null ? "" : ptRightPisPktWsWage);
		builder.append(",");
		builder.append(ptRightPisPktWsPrice == null ? "" : ptRightPisPktWsPrice);
		builder.append(",");
		builder.append(ptVCutCd == null ? "" : ptVCutCd);
		builder.append(",");
		builder.append(ptVCutNm == null ? "" : ptVCutNm);
		builder.append(",");
		builder.append(ptVCutRtPrice == null ? "" : ptVCutRtPrice);
		builder.append(",");
		builder.append(ptVCutWsWage == null ? "" : ptVCutWsWage);
		builder.append(",");
		builder.append(ptVCutWsPrice == null ? "" : ptVCutWsPrice);
		builder.append(",");
		builder.append(ptHemUpCd == null ? "" : ptHemUpCd);
		builder.append(",");
		builder.append(ptHemUpNm == null ? "" : ptHemUpNm);
		builder.append(",");
		builder.append(ptHemUpRtPrice == null ? "" : ptHemUpRtPrice);
		builder.append(",");
		builder.append(ptHemUpWsWage == null ? "" : ptHemUpWsWage);
		builder.append(",");
		builder.append(ptHemUpWsPrice == null ? "" : ptHemUpWsPrice);
		builder.append(",");
		builder.append(ptDblWidthCd == null ? "" : ptDblWidthCd);
		builder.append(",");
		builder.append(ptDblWidthNm == null ? "" : ptDblWidthNm);
		builder.append(",");
		builder.append(ptDblWidthRtPrice == null ? "" : ptDblWidthRtPrice);
		builder.append(",");
		builder.append(ptDblWidthWsWage == null ? "" : ptDblWidthWsWage);
		builder.append(",");
		builder.append(ptDblWidthWsPrice == null ? "" : ptDblWidthWsPrice);
		builder.append(",");
		builder.append(ptAmfStitchCd == null ? "" : ptAmfStitchCd);
		builder.append(",");
		builder.append(ptAmfStitchNm == null ? "" : ptAmfStitchNm);
		builder.append(",");
		builder.append(ptAmfStitchRtPrice == null ? "" : ptAmfStitchRtPrice);
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
		builder.append(ptStitchPlcRtPrice == null ? "" : ptStitchPlcRtPrice);
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
		builder.append(ptDblstitchPlcRtPrice == null ? "" : ptDblstitchPlcRtPrice);
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
		builder.append(ptAmfColorRtPrice == null ? "" : ptAmfColorRtPrice);
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
		builder.append(ptBtnholeColorRtPrice == null ? "" : ptBtnholeColorRtPrice);
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
		builder.append(ptBtnthreadColorRtPrice == null ? "" : ptBtnthreadColorRtPrice);
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
		builder.append(ptBtnMaterialRtPrice == null ? "" : ptBtnMaterialRtPrice);
		builder.append(",");
		builder.append(ptBtnMaterialWsWage == null ? "" : ptBtnMaterialWsWage);
		builder.append(",");
		builder.append(ptBtnMaterialWsPrice == null ? "" : ptBtnMaterialWsPrice);
		builder.append(",");
		builder.append(ptSuspenderBtnCd == null ? "" : ptSuspenderBtnCd);
		builder.append(",");
		builder.append(ptSuspenderBtnNm == null ? "" : ptSuspenderBtnNm);
		builder.append(",");
		builder.append(ptSuspenderBtnRtPrice == null ? "" : ptSuspenderBtnRtPrice);
		builder.append(",");
		builder.append(ptSuspenderBtnWsWage == null ? "" : ptSuspenderBtnWsWage);
		builder.append(",");
		builder.append(ptSuspenderBtnWsPrice == null ? "" : ptSuspenderBtnWsPrice);
		builder.append(",");
		builder.append(ptNonSlipCd == null ? "" : ptNonSlipCd);
		builder.append(",");
		builder.append(ptNonSlipNm == null ? "" : ptNonSlipNm);
		builder.append(",");
		builder.append(ptNonSlipRtPrice == null ? "" : ptNonSlipRtPrice);
		builder.append(",");
		builder.append(ptNonSlipWsWage == null ? "" : ptNonSlipWsWage);
		builder.append(",");
		builder.append(ptNonSlipWsPrice == null ? "" : ptNonSlipWsPrice);
		builder.append(",");
		builder.append(ptChicSlipCd == null ? "" : ptChicSlipCd);
		builder.append(",");
		builder.append(ptChicSlipNm == null ? "" : ptChicSlipNm);
		builder.append(",");
		builder.append(ptChicSlipRtPrice == null ? "" : ptChicSlipRtPrice);
		builder.append(",");
		builder.append(ptChicSlipWsWage == null ? "" : ptChicSlipWsWage);
		builder.append(",");
		builder.append(ptChicSlipWsPrice == null ? "" : ptChicSlipWsPrice);
		builder.append(",");
		builder.append(ptShapeMemoryCd == null ? "" : ptShapeMemoryCd);
		builder.append(",");
		builder.append(ptShapeMemoryNm == null ? "" : ptShapeMemoryNm);
		builder.append(",");
		builder.append(ptShapeMemoryRtPrice == null ? "" : ptShapeMemoryRtPrice);
		builder.append(",");
		builder.append(ptShapeMemoryWsWage == null ? "" : ptShapeMemoryWsWage);
		builder.append(",");
		builder.append(ptShapeMemoryWsPrice == null ? "" : ptShapeMemoryWsPrice);
		builder.append(",");
		builder.append(ptShoeSoreCd == null ? "" : ptShoeSoreCd);
		builder.append(",");
		builder.append(ptShoeSoreNm == null ? "" : ptShoeSoreNm);
		builder.append(",");
		builder.append(ptShoeSoreRtPrice == null ? "" : ptShoeSoreRtPrice);
		builder.append(",");
		builder.append(ptShoeSoreWsWage == null ? "" : ptShoeSoreWsWage);
		builder.append(",");
		builder.append(ptShoeSoreWsPrice == null ? "" : ptShoeSoreWsPrice);
		builder.append(",");
		builder.append(ptSideStripeCd == null ? "" : ptSideStripeCd);
		builder.append(",");
		builder.append(ptSideStripeNm == null ? "" : ptSideStripeNm);
		builder.append(",");
		builder.append(ptSideStripeRtPrice == null ? "" : ptSideStripeRtPrice);
		builder.append(",");
		builder.append(ptSideStripeWsWage == null ? "" : ptSideStripeWsWage);
		builder.append(",");
		builder.append(ptSideStripeWsPrice == null ? "" : ptSideStripeWsPrice);
		builder.append(",");
		builder.append(ptSideStripeWidthCd == null ? "" : ptSideStripeWidthCd);
		builder.append(",");
		builder.append(ptSideStripeWidthNm == null ? "" : ptSideStripeWidthNm);
		builder.append(",");
		builder.append(ptSideStripeWidthRtPrice == null ? "" : ptSideStripeWidthRtPrice);
		builder.append(",");
		builder.append(ptSideStripeWidthWsWage == null ? "" : ptSideStripeWidthWsWage);
		builder.append(",");
		builder.append(ptSideStripeWidthWsPrice == null ? "" : ptSideStripeWidthWsPrice);
		builder.append(",");
		builder.append(pt2ModelCd == null ? "" : pt2ModelCd);
		builder.append(",");
		builder.append(pt2ModelNm == null ? "" : pt2ModelNm);
		builder.append(",");
		builder.append(pt2ModelRtPrice == null ? "" : pt2ModelRtPrice);
		builder.append(",");
		builder.append(pt2ModelWsWage == null ? "" : pt2ModelWsWage);
		builder.append(",");
		builder.append(pt2ModelWsPrice == null ? "" : pt2ModelWsPrice);
		builder.append(",");
		builder.append(pt2TackCd == null ? "" : pt2TackCd);
		builder.append(",");
		builder.append(pt2TackNm == null ? "" : pt2TackNm);
		builder.append(",");
		builder.append(pt2TackRtPrice == null ? "" : pt2TackRtPrice);
		builder.append(",");
		builder.append(pt2TackWsWage == null ? "" : pt2TackWsWage);
		builder.append(",");
		builder.append(pt2TackWsPrice == null ? "" : pt2TackWsPrice);
		builder.append(",");
		builder.append(pt2KneeinnerTypeCd == null ? "" : pt2KneeinnerTypeCd);
		builder.append(",");
		builder.append(pt2KneeinnerTypeNm == null ? "" : pt2KneeinnerTypeNm);
		builder.append(",");
		builder.append(pt2KneeinnerTypeRtPrice == null ? "" : pt2KneeinnerTypeRtPrice);
		builder.append(",");
		builder.append(pt2KneeinnerTypeWsWage == null ? "" : pt2KneeinnerTypeWsWage);
		builder.append(",");
		builder.append(pt2KneeinnerTypeWsPrice == null ? "" : pt2KneeinnerTypeWsPrice);
		builder.append(",");
		builder.append(pt2KneeinnerClothCd == null ? "" : pt2KneeinnerClothCd);
		builder.append(",");
		builder.append(pt2KneeinnerClothNm == null ? "" : pt2KneeinnerClothNm);
		builder.append(",");
		builder.append(pt2KneeinnerClothRtPrice == null ? "" : pt2KneeinnerClothRtPrice);
		builder.append(",");
		builder.append(pt2KneeinnerClothWsWage == null ? "" : pt2KneeinnerClothWsWage);
		builder.append(",");
		builder.append(pt2KneeinnerClothWsPrice == null ? "" : pt2KneeinnerClothWsPrice);
		builder.append(",");
		builder.append(pt2FrtTypeCd == null ? "" : pt2FrtTypeCd);
		builder.append(",");
		builder.append(pt2FrtTypeNm == null ? "" : pt2FrtTypeNm);
		builder.append(",");
		builder.append(pt2FrtTypeRtPrice == null ? "" : pt2FrtTypeRtPrice);
		builder.append(",");
		builder.append(pt2FrtTypeWsWage == null ? "" : pt2FrtTypeWsWage);
		builder.append(",");
		builder.append(pt2FrtTypeWsPrice == null ? "" : pt2FrtTypeWsPrice);
		builder.append(",");
		builder.append(pt2PancherinaCd == null ? "" : pt2PancherinaCd);
		builder.append(",");
		builder.append(pt2PancherinaNm == null ? "" : pt2PancherinaNm);
		builder.append(",");
		builder.append(pt2PancherinaRtPrice == null ? "" : pt2PancherinaRtPrice);
		builder.append(",");
		builder.append(pt2PancherinaWsWage == null ? "" : pt2PancherinaWsWage);
		builder.append(",");
		builder.append(pt2PancherinaWsPrice == null ? "" : pt2PancherinaWsPrice);
		builder.append(",");
		builder.append(pt2AdjusterCd == null ? "" : pt2AdjusterCd);
		builder.append(",");
		builder.append(pt2AdjusterNm == null ? "" : pt2AdjusterNm);
		builder.append(",");
		builder.append(pt2AdjusterRtPrice == null ? "" : pt2AdjusterRtPrice);
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
		builder.append(pt2BeltloopRtPrice == null ? "" : pt2BeltloopRtPrice);
		builder.append(",");
		builder.append(pt2BeltloopWsWage == null ? "" : pt2BeltloopWsWage);
		builder.append(",");
		builder.append(pt2BeltloopWsPrice == null ? "" : pt2BeltloopWsPrice);
		builder.append(",");
		builder.append(pt2PinloopCd == null ? "" : pt2PinloopCd);
		builder.append(",");
		builder.append(pt2PinloopNm == null ? "" : pt2PinloopNm);
		builder.append(",");
		builder.append(pt2PinloopRtPrice == null ? "" : pt2PinloopRtPrice);
		builder.append(",");
		builder.append(pt2PinloopWsWage == null ? "" : pt2PinloopWsWage);
		builder.append(",");
		builder.append(pt2PinloopWsPrice == null ? "" : pt2PinloopWsPrice);
		builder.append(",");
		builder.append(pt2SidePktCd == null ? "" : pt2SidePktCd);
		builder.append(",");
		builder.append(pt2SidePktNm == null ? "" : pt2SidePktNm);
		builder.append(",");
		builder.append(pt2SidePktRtPrice == null ? "" : pt2SidePktRtPrice);
		builder.append(",");
		builder.append(pt2SidePktWsWage == null ? "" : pt2SidePktWsWage);
		builder.append(",");
		builder.append(pt2SidePktWsPrice == null ? "" : pt2SidePktWsPrice);
		builder.append(",");
		builder.append(pt2ShinobiPktCd == null ? "" : pt2ShinobiPktCd);
		builder.append(",");
		builder.append(pt2ShinobiPktNm == null ? "" : pt2ShinobiPktNm);
		builder.append(",");
		builder.append(pt2ShinobiPktRtPrice == null ? "" : pt2ShinobiPktRtPrice);
		builder.append(",");
		builder.append(pt2ShinobiPktWsWage == null ? "" : pt2ShinobiPktWsWage);
		builder.append(",");
		builder.append(pt2ShinobiPktWsPrice == null ? "" : pt2ShinobiPktWsPrice);
		builder.append(",");
		builder.append(pt2CoinPktCd == null ? "" : pt2CoinPktCd);
		builder.append(",");
		builder.append(pt2CoinPktNm == null ? "" : pt2CoinPktNm);
		builder.append(",");
		builder.append(pt2CoinPktRtPrice == null ? "" : pt2CoinPktRtPrice);
		builder.append(",");
		builder.append(pt2CoinPktWsWage == null ? "" : pt2CoinPktWsWage);
		builder.append(",");
		builder.append(pt2CoinPktWsPrice == null ? "" : pt2CoinPktWsPrice);
		builder.append(",");
		builder.append(pt2FlapcoinPktCd == null ? "" : pt2FlapcoinPktCd);
		builder.append(",");
		builder.append(pt2FlapcoinPktNm == null ? "" : pt2FlapcoinPktNm);
		builder.append(",");
		builder.append(pt2FlapcoinPktRtPrice == null ? "" : pt2FlapcoinPktRtPrice);
		builder.append(",");
		builder.append(pt2FlapcoinPktWsWage == null ? "" : pt2FlapcoinPktWsWage);
		builder.append(",");
		builder.append(pt2FlapcoinPktWsPrice == null ? "" : pt2FlapcoinPktWsPrice);
		builder.append(",");
		builder.append(pt2LeftPisPktCd == null ? "" : pt2LeftPisPktCd);
		builder.append(",");
		builder.append(pt2LeftPisPktNm == null ? "" : pt2LeftPisPktNm);
		builder.append(",");
		builder.append(pt2LeftPisPktRtPrice == null ? "" : pt2LeftPisPktRtPrice);
		builder.append(",");
		builder.append(pt2LeftPisPktWsWage == null ? "" : pt2LeftPisPktWsWage);
		builder.append(",");
		builder.append(pt2LeftPisPktWsPrice == null ? "" : pt2LeftPisPktWsPrice);
		builder.append(",");
		builder.append(pt2RightPisPktCd == null ? "" : pt2RightPisPktCd);
		builder.append(",");
		builder.append(pt2RightPisPktNm == null ? "" : pt2RightPisPktNm);
		builder.append(",");
		builder.append(pt2RightPisPktRtPrice == null ? "" : pt2RightPisPktRtPrice);
		builder.append(",");
		builder.append(pt2RightPisPktWsWage == null ? "" : pt2RightPisPktWsWage);
		builder.append(",");
		builder.append(pt2RightPisPktWsPrice == null ? "" : pt2RightPisPktWsPrice);
		builder.append(",");
		builder.append(pt2VCutCd == null ? "" : pt2VCutCd);
		builder.append(",");
		builder.append(pt2VCutNm == null ? "" : pt2VCutNm);
		builder.append(",");
		builder.append(pt2VCutRtPrice == null ? "" : pt2VCutRtPrice);
		builder.append(",");
		builder.append(pt2VCutWsWage == null ? "" : pt2VCutWsWage);
		builder.append(",");
		builder.append(pt2VCutWsPrice == null ? "" : pt2VCutWsPrice);
		builder.append(",");
		builder.append(pt2HemUpCd == null ? "" : pt2HemUpCd);
		builder.append(",");
		builder.append(pt2HemUpNm == null ? "" : pt2HemUpNm);
		builder.append(",");
		builder.append(pt2HemUpRtPrice == null ? "" : pt2HemUpRtPrice);
		builder.append(",");
		builder.append(pt2HemUpWsWage == null ? "" : pt2HemUpWsWage);
		builder.append(",");
		builder.append(pt2HemUpWsPrice == null ? "" : pt2HemUpWsPrice);
		builder.append(",");
		builder.append(pt2DblWidthCd == null ? "" : pt2DblWidthCd);
		builder.append(",");
		builder.append(pt2DblWidthNm == null ? "" : pt2DblWidthNm);
		builder.append(",");
		builder.append(pt2DblWidthRtPrice == null ? "" : pt2DblWidthRtPrice);
		builder.append(",");
		builder.append(pt2DblWidthWsWage == null ? "" : pt2DblWidthWsWage);
		builder.append(",");
		builder.append(pt2DblWidthWsPrice == null ? "" : pt2DblWidthWsPrice);
		builder.append(",");
		builder.append(pt2AmfStitchCd == null ? "" : pt2AmfStitchCd);
		builder.append(",");
		builder.append(pt2AmfStitchNm == null ? "" : pt2AmfStitchNm);
		builder.append(",");
		builder.append(pt2AmfStitchRtPrice == null ? "" : pt2AmfStitchRtPrice);
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
		builder.append(pt2StitchPlcRtPrice == null ? "" : pt2StitchPlcRtPrice);
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
		builder.append(pt2DblstitchPlcRtPrice == null ? "" : pt2DblstitchPlcRtPrice);
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
		builder.append(pt2AmfColorRtPrice == null ? "" : pt2AmfColorRtPrice);
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
		builder.append(pt2BtnholeColorRtPrice == null ? "" : pt2BtnholeColorRtPrice);
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
		builder.append(pt2BtnthreadColorRtPrice == null ? "" : pt2BtnthreadColorRtPrice);
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
		builder.append(pt2BtnMaterialRtPrice == null ? "" : pt2BtnMaterialRtPrice);
		builder.append(",");
		builder.append(pt2BtnMaterialWsWage == null ? "" : pt2BtnMaterialWsWage);
		builder.append(",");
		builder.append(pt2BtnMaterialWsPrice == null ? "" : pt2BtnMaterialWsPrice);
		builder.append(",");
		builder.append(pt2SuspenderBtnCd == null ? "" : pt2SuspenderBtnCd);
		builder.append(",");
		builder.append(pt2SuspenderBtnNm == null ? "" : pt2SuspenderBtnNm);
		builder.append(",");
		builder.append(pt2SuspenderBtnRtPrice == null ? "" : pt2SuspenderBtnRtPrice);
		builder.append(",");
		builder.append(pt2SuspenderBtnWsWage == null ? "" : pt2SuspenderBtnWsWage);
		builder.append(",");
		builder.append(pt2SuspenderBtnWsPrice == null ? "" : pt2SuspenderBtnWsPrice);
		builder.append(",");
		builder.append(pt2NonSlipCd == null ? "" : pt2NonSlipCd);
		builder.append(",");
		builder.append(pt2NonSlipNm == null ? "" : pt2NonSlipNm);
		builder.append(",");
		builder.append(pt2NonSlipRtPrice == null ? "" : pt2NonSlipRtPrice);
		builder.append(",");
		builder.append(pt2NonSlipWsWage == null ? "" : pt2NonSlipWsWage);
		builder.append(",");
		builder.append(pt2NonSlipWsPrice == null ? "" : pt2NonSlipWsPrice);
		builder.append(",");
		builder.append(pt2ChicSlipCd == null ? "" : pt2ChicSlipCd);
		builder.append(",");
		builder.append(pt2ChicSlipNm == null ? "" : pt2ChicSlipNm);
		builder.append(",");
		builder.append(pt2ChicSlipRtPrice == null ? "" : pt2ChicSlipRtPrice);
		builder.append(",");
		builder.append(pt2ChicSlipWsWage == null ? "" : pt2ChicSlipWsWage);
		builder.append(",");
		builder.append(pt2ChicSlipWsPrice == null ? "" : pt2ChicSlipWsPrice);
		builder.append(",");
		builder.append(pt2ShapeMemoryCd == null ? "" : pt2ShapeMemoryCd);
		builder.append(",");
		builder.append(pt2ShapeMemoryNm == null ? "" : pt2ShapeMemoryNm);
		builder.append(",");
		builder.append(pt2ShapeMemoryRtPrice == null ? "" : pt2ShapeMemoryRtPrice);
		builder.append(",");
		builder.append(pt2ShapeMemoryWsWage == null ? "" : pt2ShapeMemoryWsWage);
		builder.append(",");
		builder.append(pt2ShapeMemoryWsPrice == null ? "" : pt2ShapeMemoryWsPrice);
		builder.append(",");
		builder.append(pt2ShoeSoreCd == null ? "" : pt2ShoeSoreCd);
		builder.append(",");
		builder.append(pt2ShoeSoreNm == null ? "" : pt2ShoeSoreNm);
		builder.append(",");
		builder.append(pt2ShoeSoreRtPrice == null ? "" : pt2ShoeSoreRtPrice);
		builder.append(",");
		builder.append(pt2ShoeSoreWsWage == null ? "" : pt2ShoeSoreWsWage);
		builder.append(",");
		builder.append(pt2ShoeSoreWsPrice == null ? "" : pt2ShoeSoreWsPrice);
		builder.append(",");
		builder.append(pt2SideStripeCd == null ? "" : pt2SideStripeCd);
		builder.append(",");
		builder.append(pt2SideStripeNm == null ? "" : pt2SideStripeNm);
		builder.append(",");
		builder.append(pt2SideStripeRtPrice == null ? "" : pt2SideStripeRtPrice);
		builder.append(",");
		builder.append(pt2SideStripeWsWage == null ? "" : pt2SideStripeWsWage);
		builder.append(",");
		builder.append(pt2SideStripeWsPrice == null ? "" : pt2SideStripeWsPrice);
		builder.append(",");
		builder.append(pt2SideStripeWidthCd == null ? "" : pt2SideStripeWidthCd);
		builder.append(",");
		builder.append(pt2SideStripeWidthNm == null ? "" : pt2SideStripeWidthNm);
		builder.append(",");
		builder.append(pt2SideStripeWidthRtPrice == null ? "" : pt2SideStripeWidthRtPrice);
		builder.append(",");
		builder.append(pt2SideStripeWidthWsWage == null ? "" : pt2SideStripeWidthWsWage);
		builder.append(",");
		builder.append(pt2SideStripeWidthWsPrice == null ? "" : pt2SideStripeWidthWsPrice);
		builder.append(",");
		builder.append(pt3ModelCd == null ? "" : pt3ModelCd);
		builder.append(",");
		builder.append(pt3ModelNm == null ? "" : pt3ModelNm);
		builder.append(",");
		builder.append(pt3ModelRtPrice == null ? "" : pt3ModelRtPrice);
		builder.append(",");
		builder.append(pt3ModelWsWage == null ? "" : pt3ModelWsWage);
		builder.append(",");
		builder.append(pt3ModelWsPrice == null ? "" : pt3ModelWsPrice);
		builder.append(",");
		builder.append(pt3TackCd == null ? "" : pt3TackCd);
		builder.append(",");
		builder.append(pt3TackNm == null ? "" : pt3TackNm);
		builder.append(",");
		builder.append(pt3TackRtPrice == null ? "" : pt3TackRtPrice);
		builder.append(",");
		builder.append(pt3TackWsWage == null ? "" : pt3TackWsWage);
		builder.append(",");
		builder.append(pt3TackWsPrice == null ? "" : pt3TackWsPrice);
		builder.append(",");
		builder.append(pt3KneeinnerTypeCd == null ? "" : pt3KneeinnerTypeCd);
		builder.append(",");
		builder.append(pt3KneeinnerTypeNm == null ? "" : pt3KneeinnerTypeNm);
		builder.append(",");
		builder.append(pt3KneeinnerTypeRtPrice == null ? "" : pt3KneeinnerTypeRtPrice);
		builder.append(",");
		builder.append(pt3KneeinnerTypeWsWage == null ? "" : pt3KneeinnerTypeWsWage);
		builder.append(",");
		builder.append(pt3KneeinnerTypeWsPrice == null ? "" : pt3KneeinnerTypeWsPrice);
		builder.append(",");
		builder.append(pt3KneeinnerClothCd == null ? "" : pt3KneeinnerClothCd);
		builder.append(",");
		builder.append(pt3KneeinnerClothNm == null ? "" : pt3KneeinnerClothNm);
		builder.append(",");
		builder.append(pt3KneeinnerClothRtPrice == null ? "" : pt3KneeinnerClothRtPrice);
		builder.append(",");
		builder.append(pt3KneeinnerClothWsWage == null ? "" : pt3KneeinnerClothWsWage);
		builder.append(",");
		builder.append(pt3KneeinnerClothWsPrice == null ? "" : pt3KneeinnerClothWsPrice);
		builder.append(",");
		builder.append(pt3FrtTypeCd == null ? "" : pt3FrtTypeCd);
		builder.append(",");
		builder.append(pt3FrtTypeNm == null ? "" : pt3FrtTypeNm);
		builder.append(",");
		builder.append(pt3FrtTypeRtPrice == null ? "" : pt3FrtTypeRtPrice);
		builder.append(",");
		builder.append(pt3FrtTypeWsWage == null ? "" : pt3FrtTypeWsWage);
		builder.append(",");
		builder.append(pt3FrtTypeWsPrice == null ? "" : pt3FrtTypeWsPrice);
		builder.append(",");
		builder.append(pt3PancherinaCd == null ? "" : pt3PancherinaCd);
		builder.append(",");
		builder.append(pt3PancherinaNm == null ? "" : pt3PancherinaNm);
		builder.append(",");
		builder.append(pt3PancherinaRtPrice == null ? "" : pt3PancherinaRtPrice);
		builder.append(",");
		builder.append(pt3PancherinaWsWage == null ? "" : pt3PancherinaWsWage);
		builder.append(",");
		builder.append(pt3PancherinaWsPrice == null ? "" : pt3PancherinaWsPrice);
		builder.append(",");
		builder.append(pt3AdjusterCd == null ? "" : pt3AdjusterCd);
		builder.append(",");
		builder.append(pt3AdjusterNm == null ? "" : pt3AdjusterNm);
		builder.append(",");
		builder.append(pt3AdjusterRtPrice == null ? "" : pt3AdjusterRtPrice);
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
		builder.append(pt3BeltloopRtPrice == null ? "" : pt3BeltloopRtPrice);
		builder.append(",");
		builder.append(pt3BeltloopWsWage == null ? "" : pt3BeltloopWsWage);
		builder.append(",");
		builder.append(pt3BeltloopWsPrice == null ? "" : pt3BeltloopWsPrice);
		builder.append(",");
		builder.append(pt3PinloopCd == null ? "" : pt3PinloopCd);
		builder.append(",");
		builder.append(pt3PinloopNm == null ? "" : pt3PinloopNm);
		builder.append(",");
		builder.append(pt3PinloopRtPrice == null ? "" : pt3PinloopRtPrice);
		builder.append(",");
		builder.append(pt3PinloopWsWage == null ? "" : pt3PinloopWsWage);
		builder.append(",");
		builder.append(pt3PinloopWsPrice == null ? "" : pt3PinloopWsPrice);
		builder.append(",");
		builder.append(pt3SidePktCd == null ? "" : pt3SidePktCd);
		builder.append(",");
		builder.append(pt3SidePktNm == null ? "" : pt3SidePktNm);
		builder.append(",");
		builder.append(pt3SidePktRtPrice == null ? "" : pt3SidePktRtPrice);
		builder.append(",");
		builder.append(pt3SidePktWsWage == null ? "" : pt3SidePktWsWage);
		builder.append(",");
		builder.append(pt3SidePktWsPrice == null ? "" : pt3SidePktWsPrice);
		builder.append(",");
		builder.append(pt3ShinobiPktCd == null ? "" : pt3ShinobiPktCd);
		builder.append(",");
		builder.append(pt3ShinobiPktNm == null ? "" : pt3ShinobiPktNm);
		builder.append(",");
		builder.append(pt3ShinobiPktRtPrice == null ? "" : pt3ShinobiPktRtPrice);
		builder.append(",");
		builder.append(pt3ShinobiPktWsWage == null ? "" : pt3ShinobiPktWsWage);
		builder.append(",");
		builder.append(pt3ShinobiPktWsPrice == null ? "" : pt3ShinobiPktWsPrice);
		builder.append(",");
		builder.append(pt3CoinPktCd == null ? "" : pt3CoinPktCd);
		builder.append(",");
		builder.append(pt3CoinPktNm == null ? "" : pt3CoinPktNm);
		builder.append(",");
		builder.append(pt3CoinPktRtPrice == null ? "" : pt3CoinPktRtPrice);
		builder.append(",");
		builder.append(pt3CoinPktWsWage == null ? "" : pt3CoinPktWsWage);
		builder.append(",");
		builder.append(pt3CoinPktWsPrice == null ? "" : pt3CoinPktWsPrice);
		builder.append(",");
		builder.append(pt3FlapcoinPktCd == null ? "" : pt3FlapcoinPktCd);
		builder.append(",");
		builder.append(pt3FlapcoinPktNm == null ? "" : pt3FlapcoinPktNm);
		builder.append(",");
		builder.append(pt3FlapcoinPktRtPrice == null ? "" : pt3FlapcoinPktRtPrice);
		builder.append(",");
		builder.append(pt3FlapcoinPktWsWage == null ? "" : pt3FlapcoinPktWsWage);
		builder.append(",");
		builder.append(pt3FlapcoinPktWsPrice == null ? "" : pt3FlapcoinPktWsPrice);
		builder.append(",");
		builder.append(pt3LeftPisPktCd == null ? "" : pt3LeftPisPktCd);
		builder.append(",");
		builder.append(pt3LeftPisPktNm == null ? "" : pt3LeftPisPktNm);
		builder.append(",");
		builder.append(pt3LeftPisPktRtPrice == null ? "" : pt3LeftPisPktRtPrice);
		builder.append(",");
		builder.append(pt3LeftPisPktWsWage == null ? "" : pt3LeftPisPktWsWage);
		builder.append(",");
		builder.append(pt3LeftPisPktWsPrice == null ? "" : pt3LeftPisPktWsPrice);
		builder.append(",");
		builder.append(pt3RightPisPktCd == null ? "" : pt3RightPisPktCd);
		builder.append(",");
		builder.append(pt3RightPisPktNm == null ? "" : pt3RightPisPktNm);
		builder.append(",");
		builder.append(pt3RightPisPktRtPrice == null ? "" : pt3RightPisPktRtPrice);
		builder.append(",");
		builder.append(pt3RightPisPktWsWage == null ? "" : pt3RightPisPktWsWage);
		builder.append(",");
		builder.append(pt3RightPisPktWsPrice == null ? "" : pt3RightPisPktWsPrice);
		builder.append(",");
		builder.append(pt3VCutCd == null ? "" : pt3VCutCd);
		builder.append(",");
		builder.append(pt3VCutNm == null ? "" : pt3VCutNm);
		builder.append(",");
		builder.append(pt3VCutRtPrice == null ? "" : pt3VCutRtPrice);
		builder.append(",");
		builder.append(pt3VCutWsWage == null ? "" : pt3VCutWsWage);
		builder.append(",");
		builder.append(pt3VCutWsPrice == null ? "" : pt3VCutWsPrice);
		builder.append(",");
		builder.append(pt3HemUpCd == null ? "" : pt3HemUpCd);
		builder.append(",");
		builder.append(pt3HemUpNm == null ? "" : pt3HemUpNm);
		builder.append(",");
		builder.append(pt3HemUpRtPrice == null ? "" : pt3HemUpRtPrice);
		builder.append(",");
		builder.append(pt3HemUpWsWage == null ? "" : pt3HemUpWsWage);
		builder.append(",");
		builder.append(pt3HemUpWsPrice == null ? "" : pt3HemUpWsPrice);
		builder.append(",");
		builder.append(pt3DblWidthCd == null ? "" : pt3DblWidthCd);
		builder.append(",");
		builder.append(pt3DblWidthNm == null ? "" : pt3DblWidthNm);
		builder.append(",");
		builder.append(pt3DblWidthRtPrice == null ? "" : pt3DblWidthRtPrice);
		builder.append(",");
		builder.append(pt3DblWidthWsWage == null ? "" : pt3DblWidthWsWage);
		builder.append(",");
		builder.append(pt3DblWidthWsPrice == null ? "" : pt3DblWidthWsPrice);
		builder.append(",");
		builder.append(pt3AmfStitchCd == null ? "" : pt3AmfStitchCd);
		builder.append(",");
		builder.append(pt3AmfStitchNm == null ? "" : pt3AmfStitchNm);
		builder.append(",");
		builder.append(pt3AmfStitchRtPrice == null ? "" : pt3AmfStitchRtPrice);
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
		builder.append(pt3StitchPlcRtPrice == null ? "" : pt3StitchPlcRtPrice);
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
		builder.append(pt3DblstitchPlcRtPrice == null ? "" : pt3DblstitchPlcRtPrice);
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
		builder.append(pt3AmfColorRtPrice == null ? "" : pt3AmfColorRtPrice);
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
		builder.append(pt3BtnholeColorRtPrice == null ? "" : pt3BtnholeColorRtPrice);
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
		builder.append(pt3BtnthreadColorRtPrice == null ? "" : pt3BtnthreadColorRtPrice);
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
		builder.append(pt3BtnMaterialRtPrice == null ? "" : pt3BtnMaterialRtPrice);
		builder.append(",");
		builder.append(pt3BtnMaterialWsWage == null ? "" : pt3BtnMaterialWsWage);
		builder.append(",");
		builder.append(pt3BtnMaterialWsPrice == null ? "" : pt3BtnMaterialWsPrice);
		builder.append(",");
		builder.append(pt3SuspenderBtnCd == null ? "" : pt3SuspenderBtnCd);
		builder.append(",");
		builder.append(pt3SuspenderBtnNm == null ? "" : pt3SuspenderBtnNm);
		builder.append(",");
		builder.append(pt3SuspenderBtnRtPrice == null ? "" : pt3SuspenderBtnRtPrice);
		builder.append(",");
		builder.append(pt3SuspenderBtnWsWage == null ? "" : pt3SuspenderBtnWsWage);
		builder.append(",");
		builder.append(pt3SuspenderBtnWsPrice == null ? "" : pt3SuspenderBtnWsPrice);
		builder.append(",");
		builder.append(pt3NonSlipCd == null ? "" : pt3NonSlipCd);
		builder.append(",");
		builder.append(pt3NonSlipNm == null ? "" : pt3NonSlipNm);
		builder.append(",");
		builder.append(pt3NonSlipRtPrice == null ? "" : pt3NonSlipRtPrice);
		builder.append(",");
		builder.append(pt3NonSlipWsWage == null ? "" : pt3NonSlipWsWage);
		builder.append(",");
		builder.append(pt3NonSlipWsPrice == null ? "" : pt3NonSlipWsPrice);
		builder.append(",");
		builder.append(pt3ChicSlipCd == null ? "" : pt3ChicSlipCd);
		builder.append(",");
		builder.append(pt3ChicSlipNm == null ? "" : pt3ChicSlipNm);
		builder.append(",");
		builder.append(pt3ChicSlipRtPrice == null ? "" : pt3ChicSlipRtPrice);
		builder.append(",");
		builder.append(pt3ChicSlipWsWage == null ? "" : pt3ChicSlipWsWage);
		builder.append(",");
		builder.append(pt3ChicSlipWsPrice == null ? "" : pt3ChicSlipWsPrice);
		builder.append(",");
		builder.append(pt3ShapeMemoryCd == null ? "" : pt3ShapeMemoryCd);
		builder.append(",");
		builder.append(pt3ShapeMemoryNm == null ? "" : pt3ShapeMemoryNm);
		builder.append(",");
		builder.append(pt3ShapeMemoryRtPrice == null ? "" : pt3ShapeMemoryRtPrice);
		builder.append(",");
		builder.append(pt3ShapeMemoryWsWage == null ? "" : pt3ShapeMemoryWsWage);
		builder.append(",");
		builder.append(pt3ShapeMemoryWsPrice == null ? "" : pt3ShapeMemoryWsPrice);
		builder.append(",");
		builder.append(pt3ShoeSoreCd == null ? "" : pt3ShoeSoreCd);
		builder.append(",");
		builder.append(pt3ShoeSoreNm == null ? "" : pt3ShoeSoreNm);
		builder.append(",");
		builder.append(pt3ShoeSoreRtPrice == null ? "" : pt3ShoeSoreRtPrice);
		builder.append(",");
		builder.append(pt3ShoeSoreWsWage == null ? "" : pt3ShoeSoreWsWage);
		builder.append(",");
		builder.append(pt3ShoeSoreWsPrice == null ? "" : pt3ShoeSoreWsPrice);
		builder.append(",");
		builder.append(pt3SideStripeCd == null ? "" : pt3SideStripeCd);
		builder.append(",");
		builder.append(pt3SideStripeNm == null ? "" : pt3SideStripeNm);
		builder.append(",");
		builder.append(pt3SideStripeRtPrice == null ? "" : pt3SideStripeRtPrice);
		builder.append(",");
		builder.append(pt3SideStripeWsWage == null ? "" : pt3SideStripeWsWage);
		builder.append(",");
		builder.append(pt3SideStripeWsPrice == null ? "" : pt3SideStripeWsPrice);
		builder.append(",");
		builder.append(pt3SideStripeWidthCd == null ? "" : pt3SideStripeWidthCd);
		builder.append(",");
		builder.append(pt3SideStripeWidthNm == null ? "" : pt3SideStripeWidthNm);
		builder.append(",");
		builder.append(pt3SideStripeWidthRtPrice == null ? "" : pt3SideStripeWidthRtPrice);
		builder.append(",");
		builder.append(pt3SideStripeWidthWsWage == null ? "" : pt3SideStripeWidthWsWage);
		builder.append(",");
		builder.append(pt3SideStripeWidthWsPrice == null ? "" : pt3SideStripeWidthWsPrice);
		builder.append(",");
		builder.append(glModelCd == null ? "" : glModelCd);
		builder.append(",");
		builder.append(glModelNm == null ? "" : glModelNm);
		builder.append(",");
		builder.append(glModelRtPrice == null ? "" : glModelRtPrice);
		builder.append(",");
		builder.append(glModelWsWage == null ? "" : glModelWsWage);
		builder.append(",");
		builder.append(glModelWsPrice == null ? "" : glModelWsPrice);
		builder.append(",");
		builder.append(glBreastPktCd == null ? "" : glBreastPktCd);
		builder.append(",");
		builder.append(glBreastPktNm == null ? "" : glBreastPktNm);
		builder.append(",");
		builder.append(glBreastPktRtPrice == null ? "" : glBreastPktRtPrice);
		builder.append(",");
		builder.append(glBreastPktWsWage == null ? "" : glBreastPktWsWage);
		builder.append(",");
		builder.append(glBreastPktWsPrice == null ? "" : glBreastPktWsPrice);
		builder.append(",");
		builder.append(glWaistPktCd == null ? "" : glWaistPktCd);
		builder.append(",");
		builder.append(glWaistPktNm == null ? "" : glWaistPktNm);
		builder.append(",");
		builder.append(glWaistPktRtPrice == null ? "" : glWaistPktRtPrice);
		builder.append(",");
		builder.append(glWaistPktWsWage == null ? "" : glWaistPktWsWage);
		builder.append(",");
		builder.append(glWaistPktWsPrice == null ? "" : glWaistPktWsPrice);
		builder.append(",");
		builder.append(glWaistPktShapeCd == null ? "" : glWaistPktShapeCd);
		builder.append(",");
		builder.append(glWaistPktShapeNm == null ? "" : glWaistPktShapeNm);
		builder.append(",");
		builder.append(glWaistPktShapeRtPrice == null ? "" : glWaistPktShapeRtPrice);
		builder.append(",");
		builder.append(glWaistPktShapeWsWage == null ? "" : glWaistPktShapeWsWage);
		builder.append(",");
		builder.append(glWaistPktShapeWsPrice == null ? "" : glWaistPktShapeWsPrice);
		builder.append(",");
		builder.append(glWaistPktClothCd == null ? "" : glWaistPktClothCd);
		builder.append(",");
		builder.append(glWaistPktClothNm == null ? "" : glWaistPktClothNm);
		builder.append(",");
		builder.append(glWaistPktClothRtPrice == null ? "" : glWaistPktClothRtPrice);
		builder.append(",");
		builder.append(glWaistPktClothWsWage == null ? "" : glWaistPktClothWsWage);
		builder.append(",");
		builder.append(glWaistPktClothWsPrice == null ? "" : glWaistPktClothWsPrice);
		builder.append(",");
		builder.append(glAmfStitchCd == null ? "" : glAmfStitchCd);
		builder.append(",");
		builder.append(glAmfStitchNm == null ? "" : glAmfStitchNm);
		builder.append(",");
		builder.append(glAmfStitchRtPrice == null ? "" : glAmfStitchRtPrice);
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
		builder.append(glStitchPlcRtPrice == null ? "" : glStitchPlcRtPrice);
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
		builder.append(glDblstitchPlcRtPrice == null ? "" : glDblstitchPlcRtPrice);
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
		builder.append(glAmfColorRtPrice == null ? "" : glAmfColorRtPrice);
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
		builder.append(glBtnholeColorRtPrice == null ? "" : glBtnholeColorRtPrice);
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
		builder.append(glBtnthreadColorRtPrice == null ? "" : glBtnthreadColorRtPrice);
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
		builder.append(glBackClothRtPrice == null ? "" : glBackClothRtPrice);
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
		builder.append(glInnnerClothRtPrice == null ? "" : glInnnerClothRtPrice);
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
		builder.append(glFrtBtnRtPrice == null ? "" : glFrtBtnRtPrice);
		builder.append(",");
		builder.append(glFrtBtnWsWage == null ? "" : glFrtBtnWsWage);
		builder.append(",");
		builder.append(glFrtBtnWsPrice == null ? "" : glFrtBtnWsPrice);
		builder.append(",");
		builder.append(glBackBeltCd == null ? "" : glBackBeltCd);
		builder.append(",");
		builder.append(glBackBeltNm == null ? "" : glBackBeltNm);
		builder.append(",");
		builder.append(glBackBeltRtPrice == null ? "" : glBackBeltRtPrice);
		builder.append(",");
		builder.append(glBackBeltWsWage == null ? "" : glBackBeltWsWage);
		builder.append(",");
		builder.append(glBackBeltWsPrice == null ? "" : glBackBeltWsPrice);
		builder.append(",");
		builder.append(glWatchChainCd == null ? "" : glWatchChainCd);
		builder.append(",");
		builder.append(glWatchChainNm == null ? "" : glWatchChainNm);
		builder.append(",");
		builder.append(glWatchChainRtPrice == null ? "" : glWatchChainRtPrice);
		builder.append(",");
		builder.append(glWatchChainWsWage == null ? "" : glWatchChainWsWage);
		builder.append(",");
		builder.append(glWatchChainWsPrice == null ? "" : glWatchChainWsPrice);
		builder.append(",");
		builder.append(ctModelCd == null ? "" : ctModelCd);
		builder.append(",");
		builder.append(ctModelNm == null ? "" : ctModelNm);
		builder.append(",");
		builder.append(ctModelRtPrice == null ? "" : ctModelRtPrice);
		builder.append(",");
		builder.append(ctModelWsWage == null ? "" : ctModelWsWage);
		builder.append(",");
		builder.append(ctModelWsPrice == null ? "" : ctModelWsPrice);
		builder.append(",");
		builder.append(ctLapelDesignCd == null ? "" : ctLapelDesignCd);
		builder.append(",");
		builder.append(ctLapelDesignNm == null ? "" : ctLapelDesignNm);
		builder.append(",");
		builder.append(ctLapelDesignRtPrice == null ? "" : ctLapelDesignRtPrice);
		builder.append(",");
		builder.append(ctLapelDesignWsWage == null ? "" : ctLapelDesignWsWage);
		builder.append(",");
		builder.append(ctLapelDesignWsPrice == null ? "" : ctLapelDesignWsPrice);
		builder.append(",");
		builder.append(ctSleeveTypeCd == null ? "" : ctSleeveTypeCd);
		builder.append(",");
		builder.append(ctSleeveTypeNm == null ? "" : ctSleeveTypeNm);
		builder.append(",");
		builder.append(ctSleeveTypeRtPrice == null ? "" : ctSleeveTypeRtPrice);
		builder.append(",");
		builder.append(ctSleeveTypeWsWage == null ? "" : ctSleeveTypeWsWage);
		builder.append(",");
		builder.append(ctSleeveTypeWsPrice == null ? "" : ctSleeveTypeWsPrice);
		builder.append(",");
		builder.append(ctWaistPktCd == null ? "" : ctWaistPktCd);
		builder.append(",");
		builder.append(ctWaistPktNm == null ? "" : ctWaistPktNm);
		builder.append(",");
		builder.append(ctWaistPktRtPrice == null ? "" : ctWaistPktRtPrice);
		builder.append(",");
		builder.append(ctWaistPktWsWage == null ? "" : ctWaistPktWsWage);
		builder.append(",");
		builder.append(ctWaistPktWsPrice == null ? "" : ctWaistPktWsPrice);
		builder.append(",");
		builder.append(ctChgPktCd == null ? "" : ctChgPktCd);
		builder.append(",");
		builder.append(ctChgPktNm == null ? "" : ctChgPktNm);
		builder.append(",");
		builder.append(ctChgPktRtPrice == null ? "" : ctChgPktRtPrice);
		builder.append(",");
		builder.append(ctChgPktWsWage == null ? "" : ctChgPktWsWage);
		builder.append(",");
		builder.append(ctChgPktWsPrice == null ? "" : ctChgPktWsPrice);
		builder.append(",");
		builder.append(ctSlantedPktCd == null ? "" : ctSlantedPktCd);
		builder.append(",");
		builder.append(ctSlantedPktNm == null ? "" : ctSlantedPktNm);
		builder.append(",");
		builder.append(ctSlantedPktRtPrice == null ? "" : ctSlantedPktRtPrice);
		builder.append(",");
		builder.append(ctSlantedPktWsWage == null ? "" : ctSlantedPktWsWage);
		builder.append(",");
		builder.append(ctSlantedPktWsPrice == null ? "" : ctSlantedPktWsPrice);
		builder.append(",");
		builder.append(ctVentCd == null ? "" : ctVentCd);
		builder.append(",");
		builder.append(ctVentNm == null ? "" : ctVentNm);
		builder.append(",");
		builder.append(ctVentRtPrice == null ? "" : ctVentRtPrice);
		builder.append(",");
		builder.append(ctVentWsWage == null ? "" : ctVentWsWage);
		builder.append(",");
		builder.append(ctVentWsPrice == null ? "" : ctVentWsPrice);
		builder.append(",");
		builder.append(ctFrtBtnCd == null ? "" : ctFrtBtnCd);
		builder.append(",");
		builder.append(ctFrtBtnNm == null ? "" : ctFrtBtnNm);
		builder.append(",");
		builder.append(ctFrtBtnRtPrice == null ? "" : ctFrtBtnRtPrice);
		builder.append(",");
		builder.append(ctFrtBtnWsWage == null ? "" : ctFrtBtnWsWage);
		builder.append(",");
		builder.append(ctFrtBtnWsPrice == null ? "" : ctFrtBtnWsPrice);
		builder.append(",");
		builder.append(ctCuffCd == null ? "" : ctCuffCd);
		builder.append(",");
		builder.append(ctCuffNm == null ? "" : ctCuffNm);
		builder.append(",");
		builder.append(ctCuffRtPrice == null ? "" : ctCuffRtPrice);
		builder.append(",");
		builder.append(ctCuffWsWage == null ? "" : ctCuffWsWage);
		builder.append(",");
		builder.append(ctCuffWsPrice == null ? "" : ctCuffWsPrice);
		builder.append(",");
		builder.append(ctSleeveBtnCd == null ? "" : ctSleeveBtnCd);
		builder.append(",");
		builder.append(ctSleeveBtnNm == null ? "" : ctSleeveBtnNm);
		builder.append(",");
		builder.append(ctSleeveBtnRtPrice == null ? "" : ctSleeveBtnRtPrice);
		builder.append(",");
		builder.append(ctSleeveBtnWsWage == null ? "" : ctSleeveBtnWsWage);
		builder.append(",");
		builder.append(ctSleeveBtnWsPrice == null ? "" : ctSleeveBtnWsPrice);
		builder.append(",");
		builder.append(ctBackBeltCd == null ? "" : ctBackBeltCd);
		builder.append(",");
		builder.append(ctBackBeltNm == null ? "" : ctBackBeltNm);
		builder.append(",");
		builder.append(ctBackBeltRtPrice == null ? "" : ctBackBeltRtPrice);
		builder.append(",");
		builder.append(ctBackBeltWsWage == null ? "" : ctBackBeltWsWage);
		builder.append(",");
		builder.append(ctBackBeltWsPrice == null ? "" : ctBackBeltWsPrice);
		builder.append(",");
		builder.append(ctCollarHangCd == null ? "" : ctCollarHangCd);
		builder.append(",");
		builder.append(ctCollarHangNm == null ? "" : ctCollarHangNm);
		builder.append(",");
		builder.append(ctCollarHangRtPrice == null ? "" : ctCollarHangRtPrice);
		builder.append(",");
		builder.append(ctCollarHangWsWage == null ? "" : ctCollarHangWsWage);
		builder.append(",");
		builder.append(ctCollarHangWsPrice == null ? "" : ctCollarHangWsPrice);
		builder.append(",");
		builder.append(ctInnerBodyClothCd == null ? "" : ctInnerBodyClothCd);
		builder.append(",");
		builder.append(ctInnerBodyClothNm == null ? "" : ctInnerBodyClothNm);
		builder.append(",");
		builder.append(ctInnerBodyClothRtPrice == null ? "" : ctInnerBodyClothRtPrice);
		builder.append(",");
		builder.append(ctInnerBodyClothWsWage == null ? "" : ctInnerBodyClothWsWage);
		builder.append(",");
		builder.append(ctInnerBodyClothWsPrice == null ? "" : ctInnerBodyClothWsPrice);
		builder.append(",");
		builder.append(ctInnerSleeveClothCd == null ? "" : ctInnerSleeveClothCd);
		builder.append(",");
		builder.append(ctInnerSleeveClothNm == null ? "" : ctInnerSleeveClothNm);
		builder.append(",");
		builder.append(ctInnerSleeveClothRtPrice == null ? "" : ctInnerSleeveClothRtPrice);
		builder.append(",");
		builder.append(ctInnerSleeveClothWsWage == null ? "" : ctInnerSleeveClothWsWage);
		builder.append(",");
		builder.append(ctInnerSleeveClothWsPrice == null ? "" : ctInnerSleeveClothWsPrice);
		builder.append(",");
		builder.append(ctBtnMaterialCd == null ? "" : ctBtnMaterialCd);
		builder.append(",");
		builder.append(ctBtnMaterialNm == null ? "" : ctBtnMaterialNm);
		builder.append(",");
		builder.append(ctBtnMaterialRtPrice == null ? "" : ctBtnMaterialRtPrice);
		builder.append(",");
		builder.append(ctBtnMaterialWsWage == null ? "" : ctBtnMaterialWsWage);
		builder.append(",");
		builder.append(ctBtnMaterialWsPrice == null ? "" : ctBtnMaterialWsPrice);
		builder.append(",");
		builder.append(stModelCd == null ? "" : stModelCd);
		builder.append(",");
		builder.append(stModelNm == null ? "" : stModelNm);
		builder.append(",");
		builder.append(stModelRtPrice == null ? "" : stModelRtPrice);
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
		builder.append(stCasualHemlineRtPrice == null ? "" : stCasualHemlineRtPrice);
		builder.append(",");
		builder.append(stCasualHemlineWsWage == null ? "" : stCasualHemlineWsWage);
		builder.append(",");
		builder.append(stCasualHemlineWsPrice == null ? "" : stCasualHemlineWsPrice);
		builder.append(",");
		builder.append(stCollarTypeCd == null ? "" : stCollarTypeCd);
		builder.append(",");
		builder.append(stCollarTypeNm == null ? "" : stCollarTypeNm);
		builder.append(",");
		builder.append(stCollarTypeRtPrice == null ? "" : stCollarTypeRtPrice);
		builder.append(",");
		builder.append(stCollarTypeWsWage == null ? "" : stCollarTypeWsWage);
		builder.append(",");
		builder.append(stCollarTypeWsPrice == null ? "" : stCollarTypeWsPrice);
		builder.append(",");
		builder.append(stCuffsCd == null ? "" : stCuffsCd);
		builder.append(",");
		builder.append(stCuffsNm == null ? "" : stCuffsNm);
		builder.append(",");
		builder.append(stCuffsRtPrice == null ? "" : stCuffsRtPrice);
		builder.append(",");
		builder.append(stCuffsWsWage == null ? "" : stCuffsWsWage);
		builder.append(",");
		builder.append(stCuffsWsPrice == null ? "" : stCuffsWsPrice);
		builder.append(",");
		builder.append(stConvertibleCd == null ? "" : stConvertibleCd);
		builder.append(",");
		builder.append(stConvertibleNm == null ? "" : stConvertibleNm);
		builder.append(",");
		builder.append(stConvertibleRtPrice == null ? "" : stConvertibleRtPrice);
		builder.append(",");
		builder.append(stConvertibleWsWage == null ? "" : stConvertibleWsWage);
		builder.append(",");
		builder.append(stConvertibleWsPrice == null ? "" : stConvertibleWsPrice);
		builder.append(",");
		builder.append(stAdjusterBtnCd == null ? "" : stAdjusterBtnCd);
		builder.append(",");
		builder.append(stAdjusterBtnNm == null ? "" : stAdjusterBtnNm);
		builder.append(",");
		builder.append(stAdjusterBtnRtPrice == null ? "" : stAdjusterBtnRtPrice);
		builder.append(",");
		builder.append(stAdjusterBtnWsWage == null ? "" : stAdjusterBtnWsWage);
		builder.append(",");
		builder.append(stAdjusterBtnWsPrice == null ? "" : stAdjusterBtnWsPrice);
		builder.append(",");
		builder.append(stDblCuffsCd == null ? "" : stDblCuffsCd);
		builder.append(",");
		builder.append(stDblCuffsNm == null ? "" : stDblCuffsNm);
		builder.append(",");
		builder.append(stDblCuffsRtPrice == null ? "" : stDblCuffsRtPrice);
		builder.append(",");
		builder.append(stDblCuffsWsWage == null ? "" : stDblCuffsWsWage);
		builder.append(",");
		builder.append(stDblCuffsWsPrice == null ? "" : stDblCuffsWsPrice);
		builder.append(",");
		builder.append(stClericCd == null ? "" : stClericCd);
		builder.append(",");
		builder.append(stClericNm == null ? "" : stClericNm);
		builder.append(",");
		builder.append(stClericRtPrice == null ? "" : stClericRtPrice);
		builder.append(",");
		builder.append(stClericWsWage == null ? "" : stClericWsWage);
		builder.append(",");
		builder.append(stClericWsPrice == null ? "" : stClericWsPrice);
		builder.append(",");
		builder.append(stCuffsBtnCd == null ? "" : stCuffsBtnCd);
		builder.append(",");
		builder.append(stCuffsBtnNm == null ? "" : stCuffsBtnNm);
		builder.append(",");
		builder.append(stCuffsBtnRtPrice == null ? "" : stCuffsBtnRtPrice);
		builder.append(",");
		builder.append(stCuffsBtnWsWage == null ? "" : stCuffsBtnWsWage);
		builder.append(",");
		builder.append(stCuffsBtnWsPrice == null ? "" : stCuffsBtnWsPrice);
		builder.append(",");
		builder.append(stSleeveClericcd == null ? "" : stSleeveClericcd);
		builder.append(",");
		builder.append(stSleeveClericnm == null ? "" : stSleeveClericnm);
		builder.append(",");
		builder.append(stSleeveClericrtPrice == null ? "" : stSleeveClericrtPrice);
		builder.append(",");
		builder.append(stSleeveClericwsWage == null ? "" : stSleeveClericwsWage);
		builder.append(",");
		builder.append(stSleeveClericwsPrice == null ? "" : stSleeveClericwsPrice);
		builder.append(",");
		builder.append(stBtnMaterialCd == null ? "" : stBtnMaterialCd);
		builder.append(",");
		builder.append(stBtnMaterialNm == null ? "" : stBtnMaterialNm);
		builder.append(",");
		builder.append(stBtnMaterialRtPrice == null ? "" : stBtnMaterialRtPrice);
		builder.append(",");
		builder.append(stBtnMaterialWsWage == null ? "" : stBtnMaterialWsWage);
		builder.append(",");
		builder.append(stBtnMaterialWsPrice == null ? "" : stBtnMaterialWsPrice);
		builder.append(",");
		builder.append(stDblBtnCd == null ? "" : stDblBtnCd);
		builder.append(",");
		builder.append(stDblBtnNm == null ? "" : stDblBtnNm);
		builder.append(",");
		builder.append(stDblBtnRtPrice == null ? "" : stDblBtnRtPrice);
		builder.append(",");
		builder.append(stDblBtnWsWage == null ? "" : stDblBtnWsWage);
		builder.append(",");
		builder.append(stDblBtnWsPrice == null ? "" : stDblBtnWsPrice);
		builder.append(",");
		builder.append(stGauntletBtnPosCd == null ? "" : stGauntletBtnPosCd);
		builder.append(",");
		builder.append(stGauntletBtnPosNm == null ? "" : stGauntletBtnPosNm);
		builder.append(",");
		builder.append(stGauntletBtnPosRtPrice == null ? "" : stGauntletBtnPosRtPrice);
		builder.append(",");
		builder.append(stGauntletBtnPosWsWage == null ? "" : stGauntletBtnPosWsWage);
		builder.append(",");
		builder.append(stGauntletBtnPosWsPrice == null ? "" : stGauntletBtnPosWsPrice);
		builder.append(",");
		builder.append(stPinholePinCd == null ? "" : stPinholePinCd);
		builder.append(",");
		builder.append(stPinholePinNm == null ? "" : stPinholePinNm);
		builder.append(",");
		builder.append(stPinholePinRtPrice == null ? "" : stPinholePinRtPrice);
		builder.append(",");
		builder.append(stPinholePinWsWage == null ? "" : stPinholePinWsWage);
		builder.append(",");
		builder.append(stPinholePinWsPrice == null ? "" : stPinholePinWsPrice);
		builder.append(",");
		builder.append(stBreastPktCd == null ? "" : stBreastPktCd);
		builder.append(",");
		builder.append(stBreastPktNm == null ? "" : stBreastPktNm);
		builder.append(",");
		builder.append(stBreastPktRtPrice == null ? "" : stBreastPktRtPrice);
		builder.append(",");
		builder.append(stBreastPktWsWage == null ? "" : stBreastPktWsWage);
		builder.append(",");
		builder.append(stBreastPktWsPrice == null ? "" : stBreastPktWsPrice);
		builder.append(",");
		builder.append(stBreastSizeCd == null ? "" : stBreastSizeCd);
		builder.append(",");
		builder.append(stBreastSizeNm == null ? "" : stBreastSizeNm);
		builder.append(",");
		builder.append(stBreastSizeRtPrice == null ? "" : stBreastSizeRtPrice);
		builder.append(",");
		builder.append(stBreastSizeWsWage == null ? "" : stBreastSizeWsWage);
		builder.append(",");
		builder.append(stBreastSizeWsPrice == null ? "" : stBreastSizeWsPrice);
		builder.append(",");
		builder.append(stFrtDesignCd == null ? "" : stFrtDesignCd);
		builder.append(",");
		builder.append(stFrtDesignNm == null ? "" : stFrtDesignNm);
		builder.append(",");
		builder.append(stFrtDesignRtPrice == null ? "" : stFrtDesignRtPrice);
		builder.append(",");
		builder.append(stFrtDesignWsWage == null ? "" : stFrtDesignWsWage);
		builder.append(",");
		builder.append(stFrtDesignWsPrice == null ? "" : stFrtDesignWsPrice);
		builder.append(",");
		builder.append(stPintuckBosomCd == null ? "" : stPintuckBosomCd);
		builder.append(",");
		builder.append(stPintuckBosomNm == null ? "" : stPintuckBosomNm);
		builder.append(",");
		builder.append(stPintuckBosomRtPrice == null ? "" : stPintuckBosomRtPrice);
		builder.append(",");
		builder.append(stPintuckBosomWsWage == null ? "" : stPintuckBosomWsWage);
		builder.append(",");
		builder.append(stPintuckBosomWsPrice == null ? "" : stPintuckBosomWsPrice);
		builder.append(",");
		builder.append(stStitchCd == null ? "" : stStitchCd);
		builder.append(",");
		builder.append(stStitchNm == null ? "" : stStitchNm);
		builder.append(",");
		builder.append(stStitchRtPrice == null ? "" : stStitchRtPrice);
		builder.append(",");
		builder.append(stStitchWsWage == null ? "" : stStitchWsWage);
		builder.append(",");
		builder.append(stStitchWsPrice == null ? "" : stStitchWsPrice);
		builder.append(",");
		builder.append(stColarKeeperCd == null ? "" : stColarKeeperCd);
		builder.append(",");
		builder.append(stColarKeeperNm == null ? "" : stColarKeeperNm);
		builder.append(",");
		builder.append(stColarKeeperRtPrice == null ? "" : stColarKeeperRtPrice);
		builder.append(",");
		builder.append(stColarKeeperWsWage == null ? "" : stColarKeeperWsWage);
		builder.append(",");
		builder.append(stColarKeeperWsPrice == null ? "" : stColarKeeperWsPrice);
		builder.append(",");
		builder.append(stBtnthreadColorCd == null ? "" : stBtnthreadColorCd);
		builder.append(",");
		builder.append(stBtnthreadColorNm == null ? "" : stBtnthreadColorNm);
		builder.append(",");
		builder.append(stBtnthreadColorRtPrice == null ? "" : stBtnthreadColorRtPrice);
		builder.append(",");
		builder.append(stBtnthreadColorWsWage == null ? "" : stBtnthreadColorWsWage);
		builder.append(",");
		builder.append(stBtnthreadColorWsPrice == null ? "" : stBtnthreadColorWsPrice);
		builder.append(",");
		builder.append(stBtnholeColorCd == null ? "" : stBtnholeColorCd);
		builder.append(",");
		builder.append(stBtnholeColorNm == null ? "" : stBtnholeColorNm);
		builder.append(",");
		builder.append(stBtnholeColorRtPrice == null ? "" : stBtnholeColorRtPrice);
		builder.append(",");
		builder.append(stBtnholeColorWsWage == null ? "" : stBtnholeColorWsWage);
		builder.append(",");
		builder.append(stBtnholeColorWsPrice == null ? "" : stBtnholeColorWsPrice);
		builder.append(",");
		builder.append(stBtnposChgCd == null ? "" : stBtnposChgCd);
		builder.append(",");
		builder.append(stBtnposChgNm == null ? "" : stBtnposChgNm);
		builder.append(",");
		builder.append(stBtnposChgRtPrice == null ? "" : stBtnposChgRtPrice);
		builder.append(",");
		builder.append(stBtnposChgWsWage == null ? "" : stBtnposChgWsWage);
		builder.append(",");
		builder.append(stBtnposChgWsPrice == null ? "" : stBtnposChgWsPrice);
		builder.append(",");
		builder.append(stNeckbandBtnChgCd == null ? "" : stNeckbandBtnChgCd);
		builder.append(",");
		builder.append(stNeckbandBtnChgNm == null ? "" : stNeckbandBtnChgNm);
		builder.append(",");
		builder.append(stNeckbandBtnChgRtPrice == null ? "" : stNeckbandBtnChgRtPrice);
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
		builder.append(stFrtfirstBtnChgRtPrice == null ? "" : stFrtfirstBtnChgRtPrice);
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
		builder.append(stFrtsecondBtnChgRtPrice == null ? "" : stFrtsecondBtnChgRtPrice);
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
		builder.append(hostTransmitStoreCd == null ? "" : hostTransmitStoreCd);
		builder.append(",");
		builder.append(hostTransmitItemCd == null ? "" : hostTransmitItemCd);
		builder.append(",");
		builder.append(hostTransmitMakerCd == null ? "" : hostTransmitMakerCd);
		builder.append(",");
		builder.append(hostTransmitNenkiCd == null ? "" : hostTransmitNenkiCd);
		builder.append(",");
		builder.append(hostTransmitColorCd == null ? "" : hostTransmitColorCd);
		builder.append(",");
		builder.append(hostTransmitSize == null ? "" : hostTransmitSize);
		builder.append(",");
		builder.append(hostTransmitMakerProduct == null ? "" : hostTransmitMakerProduct);
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