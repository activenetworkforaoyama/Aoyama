package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;

public class OptionCoatStandardInfo implements Serializable {
	private static final long serialVersionUID = 8096233544839181551L;
	
	//COATモデル
	private String coatModel;
	
	private Map<String, String> coatModelMap;
	
	private String coatModelRtPrice;

	// ラペルデザイン
	private String ocLapelDesign;

	private Map<String, String> ocLapelDesignMap;
	
	private String ctLapelDesignRtPrice;
	
	// 袖仕様
	private String ocSleeveSpec;

	private Map<String, String> ocSleeveSpecMap;
	
	private String ctSleeveTypeRtPrice;

	// 腰ポケット
	private String ocWaistPkt;

	private Map<String, String> ocWaistPktMap;
	
	private String ctWaistPktRtPrice;

	// チェンジポケット
	private String ocChangePkt;

	private Map<String, String> ocChangePktMap;
	
	private String ctChgPktRtPrice;

	// スランテッドポケット
	private String ocSlantedPkt;

	private Map<String, String> ocSlantedPktMap;
	
	private String ctSlantedPktRtPrice;

	// ベント
	private String ocVentSpec;

	private Map<String, String> ocVentSpecMap;
	
	private String ctVentRtPrice;

	// フロント釦数
	private String ocFrontBtnCnt;

	private Map<String, String> ocFrontBtnCntMap;
	
	private String ctFrtBtnRtPrice;

	// 袖口
	private String ocCuffSpec;

	private Map<String, String> ocCuffSpecMap;
	
	private String ctCuffRtPrice;

	// 袖釦
	private String ocSleeveBtnType;

	private Map<String, String> ocSleeveBtnTypeMap;
	
	private String ctSleeveBtnRtPrice;

	// バックベルト
	private String ocBackBelt;

	private Map<String, String> ocBackBeltMap;
	
	private String ctBackBeltRtPrice;

	// 襟吊
	private String ocChainHange;

	private Map<String, String> ocChainHangeMap;
	
	private String ctCollarHangRtPrice;

	// 胴裏素材
	private String ocBodyBackMate;

	private Map<String, String> ocBodyBackMateMap;
	
	//胴裏素材品番
	private String ocBodyBackMateStkNo;
	
	private String ctInnerBodyClothRtPrice;

	// 袖裏素材
	private String ocCuffBackMate;

	private Map<String, String> ocCuffBackMateMap;
	
	//袖裏素材品番
	private String ocCuffBackMateStkNo;
	
	private String ctInnerSleeveClothRtPrice;

	// 釦素材
	private String ocFrontBtnMate;

	private Map<String, String> ocFrontBtnMateMap;
	
	//釦素材品番
	private String ocFrontBtnMateStkNo;
	
	private String ctBtnMaterialRtPrice;

	public String getCoatModel() {
		return coatModel;
	}

	public void setCoatModel(String coatModel) {
		this.coatModel = coatModel;
	}

	public Map<String, String> getCoatModelMap() {
		return coatModelMap;
	}

	public void setCoatModelMap(Map<String, String> coatModelMap) {
		this.coatModelMap = coatModelMap;
	}

	public String getCoatModelRtPrice() {
		return coatModelRtPrice;
	}

	public void setCoatModelRtPrice(String coatModelRtPrice) {
		this.coatModelRtPrice = coatModelRtPrice;
	}

	public String getOcLapelDesign() {
		return ocLapelDesign;
	}

	public void setOcLapelDesign(String ocLapelDesign) {
		this.ocLapelDesign = ocLapelDesign;
	}

	public Map<String, String> getOcLapelDesignMap() {
		return ocLapelDesignMap;
	}

	public void setOcLapelDesignMap(Map<String, String> ocLapelDesignMap) {
		this.ocLapelDesignMap = ocLapelDesignMap;
	}

	public String getCtLapelDesignRtPrice() {
		return ctLapelDesignRtPrice;
	}

	public void setCtLapelDesignRtPrice(String ctLapelDesignRtPrice) {
		this.ctLapelDesignRtPrice = ctLapelDesignRtPrice;
	}

	public String getOcSleeveSpec() {
		return ocSleeveSpec;
	}

	public void setOcSleeveSpec(String ocSleeveSpec) {
		this.ocSleeveSpec = ocSleeveSpec;
	}

	public Map<String, String> getOcSleeveSpecMap() {
		return ocSleeveSpecMap;
	}

	public void setOcSleeveSpecMap(Map<String, String> ocSleeveSpecMap) {
		this.ocSleeveSpecMap = ocSleeveSpecMap;
	}

	public String getCtSleeveTypeRtPrice() {
		return ctSleeveTypeRtPrice;
	}

	public void setCtSleeveTypeRtPrice(String ctSleeveTypeRtPrice) {
		this.ctSleeveTypeRtPrice = ctSleeveTypeRtPrice;
	}

	public String getOcWaistPkt() {
		return ocWaistPkt;
	}

	public void setOcWaistPkt(String ocWaistPkt) {
		this.ocWaistPkt = ocWaistPkt;
	}

	public Map<String, String> getOcWaistPktMap() {
		return ocWaistPktMap;
	}

	public void setOcWaistPktMap(Map<String, String> ocWaistPktMap) {
		this.ocWaistPktMap = ocWaistPktMap;
	}

	public String getCtWaistPktRtPrice() {
		return ctWaistPktRtPrice;
	}

	public void setCtWaistPktRtPrice(String ctWaistPktRtPrice) {
		this.ctWaistPktRtPrice = ctWaistPktRtPrice;
	}

	public String getOcChangePkt() {
		return ocChangePkt;
	}

	public void setOcChangePkt(String ocChangePkt) {
		this.ocChangePkt = ocChangePkt;
	}

	public Map<String, String> getOcChangePktMap() {
		return ocChangePktMap;
	}

	public void setOcChangePktMap(Map<String, String> ocChangePktMap) {
		this.ocChangePktMap = ocChangePktMap;
	}

	public String getCtChgPktRtPrice() {
		return ctChgPktRtPrice;
	}

	public void setCtChgPktRtPrice(String ctChgPktRtPrice) {
		this.ctChgPktRtPrice = ctChgPktRtPrice;
	}

	public String getOcSlantedPkt() {
		return ocSlantedPkt;
	}

	public void setOcSlantedPkt(String ocSlantedPkt) {
		this.ocSlantedPkt = ocSlantedPkt;
	}

	public Map<String, String> getOcSlantedPktMap() {
		return ocSlantedPktMap;
	}

	public void setOcSlantedPktMap(Map<String, String> ocSlantedPktMap) {
		this.ocSlantedPktMap = ocSlantedPktMap;
	}

	public String getCtSlantedPktRtPrice() {
		return ctSlantedPktRtPrice;
	}

	public void setCtSlantedPktRtPrice(String ctSlantedPktRtPrice) {
		this.ctSlantedPktRtPrice = ctSlantedPktRtPrice;
	}

	public String getOcVentSpec() {
		return ocVentSpec;
	}

	public void setOcVentSpec(String ocVentSpec) {
		this.ocVentSpec = ocVentSpec;
	}

	public Map<String, String> getOcVentSpecMap() {
		return ocVentSpecMap;
	}

	public void setOcVentSpecMap(Map<String, String> ocVentSpecMap) {
		this.ocVentSpecMap = ocVentSpecMap;
	}

	public String getCtVentRtPrice() {
		return ctVentRtPrice;
	}

	public void setCtVentRtPrice(String ctVentRtPrice) {
		this.ctVentRtPrice = ctVentRtPrice;
	}

	public String getOcFrontBtnCnt() {
		return ocFrontBtnCnt;
	}

	public void setOcFrontBtnCnt(String ocFrontBtnCnt) {
		this.ocFrontBtnCnt = ocFrontBtnCnt;
	}

	public Map<String, String> getOcFrontBtnCntMap() {
		return ocFrontBtnCntMap;
	}

	public void setOcFrontBtnCntMap(Map<String, String> ocFrontBtnCntMap) {
		this.ocFrontBtnCntMap = ocFrontBtnCntMap;
	}

	public String getCtFrtBtnRtPrice() {
		return ctFrtBtnRtPrice;
	}

	public void setCtFrtBtnRtPrice(String ctFrtBtnRtPrice) {
		this.ctFrtBtnRtPrice = ctFrtBtnRtPrice;
	}

	public String getOcCuffSpec() {
		return ocCuffSpec;
	}

	public void setOcCuffSpec(String ocCuffSpec) {
		this.ocCuffSpec = ocCuffSpec;
	}

	public Map<String, String> getOcCuffSpecMap() {
		return ocCuffSpecMap;
	}

	public void setOcCuffSpecMap(Map<String, String> ocCuffSpecMap) {
		this.ocCuffSpecMap = ocCuffSpecMap;
	}

	public String getCtCuffRtPrice() {
		return ctCuffRtPrice;
	}

	public void setCtCuffRtPrice(String ctCuffRtPrice) {
		this.ctCuffRtPrice = ctCuffRtPrice;
	}

	public String getOcSleeveBtnType() {
		return ocSleeveBtnType;
	}

	public void setOcSleeveBtnType(String ocSleeveBtnType) {
		this.ocSleeveBtnType = ocSleeveBtnType;
	}

	public Map<String, String> getOcSleeveBtnTypeMap() {
		return ocSleeveBtnTypeMap;
	}

	public void setOcSleeveBtnTypeMap(Map<String, String> ocSleeveBtnTypeMap) {
		this.ocSleeveBtnTypeMap = ocSleeveBtnTypeMap;
	}

	public String getCtSleeveBtnRtPrice() {
		return ctSleeveBtnRtPrice;
	}

	public void setCtSleeveBtnRtPrice(String ctSleeveBtnRtPrice) {
		this.ctSleeveBtnRtPrice = ctSleeveBtnRtPrice;
	}

	public String getOcBackBelt() {
		return ocBackBelt;
	}

	public void setOcBackBelt(String ocBackBelt) {
		this.ocBackBelt = ocBackBelt;
	}

	public Map<String, String> getOcBackBeltMap() {
		return ocBackBeltMap;
	}

	public void setOcBackBeltMap(Map<String, String> ocBackBeltMap) {
		this.ocBackBeltMap = ocBackBeltMap;
	}

	public String getCtBackBeltRtPrice() {
		return ctBackBeltRtPrice;
	}

	public void setCtBackBeltRtPrice(String ctBackBeltRtPrice) {
		this.ctBackBeltRtPrice = ctBackBeltRtPrice;
	}

	public String getOcChainHange() {
		return ocChainHange;
	}

	public void setOcChainHange(String ocChainHange) {
		this.ocChainHange = ocChainHange;
	}

	public Map<String, String> getOcChainHangeMap() {
		return ocChainHangeMap;
	}

	public void setOcChainHangeMap(Map<String, String> ocChainHangeMap) {
		this.ocChainHangeMap = ocChainHangeMap;
	}

	public String getCtCollarHangRtPrice() {
		return ctCollarHangRtPrice;
	}

	public void setCtCollarHangRtPrice(String ctCollarHangRtPrice) {
		this.ctCollarHangRtPrice = ctCollarHangRtPrice;
	}

	public String getOcBodyBackMate() {
		return ocBodyBackMate;
	}

	public void setOcBodyBackMate(String ocBodyBackMate) {
		this.ocBodyBackMate = ocBodyBackMate;
	}

	public Map<String, String> getOcBodyBackMateMap() {
		return ocBodyBackMateMap;
	}

	public void setOcBodyBackMateMap(Map<String, String> ocBodyBackMateMap) {
		this.ocBodyBackMateMap = ocBodyBackMateMap;
	}

	public String getOcBodyBackMateStkNo() {
		return ocBodyBackMateStkNo;
	}

	public void setOcBodyBackMateStkNo(String ocBodyBackMateStkNo) {
		this.ocBodyBackMateStkNo = ocBodyBackMateStkNo;
	}

	public String getCtInnerBodyClothRtPrice() {
		return ctInnerBodyClothRtPrice;
	}

	public void setCtInnerBodyClothRtPrice(String ctInnerBodyClothRtPrice) {
		this.ctInnerBodyClothRtPrice = ctInnerBodyClothRtPrice;
	}

	public String getOcCuffBackMate() {
		return ocCuffBackMate;
	}

	public void setOcCuffBackMate(String ocCuffBackMate) {
		this.ocCuffBackMate = ocCuffBackMate;
	}

	public Map<String, String> getOcCuffBackMateMap() {
		return ocCuffBackMateMap;
	}

	public void setOcCuffBackMateMap(Map<String, String> ocCuffBackMateMap) {
		this.ocCuffBackMateMap = ocCuffBackMateMap;
	}

	public String getOcCuffBackMateStkNo() {
		return ocCuffBackMateStkNo;
	}

	public void setOcCuffBackMateStkNo(String ocCuffBackMateStkNo) {
		this.ocCuffBackMateStkNo = ocCuffBackMateStkNo;
	}

	public String getCtInnerSleeveClothRtPrice() {
		return ctInnerSleeveClothRtPrice;
	}

	public void setCtInnerSleeveClothRtPrice(String ctInnerSleeveClothRtPrice) {
		this.ctInnerSleeveClothRtPrice = ctInnerSleeveClothRtPrice;
	}

	public String getOcFrontBtnMate() {
		return ocFrontBtnMate;
	}

	public void setOcFrontBtnMate(String ocFrontBtnMate) {
		this.ocFrontBtnMate = ocFrontBtnMate;
	}

	public Map<String, String> getOcFrontBtnMateMap() {
		return ocFrontBtnMateMap;
	}

	public void setOcFrontBtnMateMap(Map<String, String> ocFrontBtnMateMap) {
		this.ocFrontBtnMateMap = ocFrontBtnMateMap;
	}

	public String getOcFrontBtnMateStkNo() {
		return ocFrontBtnMateStkNo;
	}

	public void setOcFrontBtnMateStkNo(String ocFrontBtnMateStkNo) {
		this.ocFrontBtnMateStkNo = ocFrontBtnMateStkNo;
	}

	public String getCtBtnMaterialRtPrice() {
		return ctBtnMaterialRtPrice;
	}

	public void setCtBtnMaterialRtPrice(String ctBtnMaterialRtPrice) {
		this.ctBtnMaterialRtPrice = ctBtnMaterialRtPrice;
	}

}
