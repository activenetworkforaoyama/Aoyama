package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;

public class OptionCoatStandardInfo implements Serializable {
	private static final long serialVersionUID = 8096233544839181551L;
	
	//COATモデル
	private String coatModel;
	
	private Map<String, String> coatModelMap;

	// ラペルデザイン
	private String ocLapelDesign;

	private Map<String, String> ocLapelDesignMap;

	// 腰ポケット
	private String ocWaistPkt;

	private Map<String, String> ocWaistPktMap;

	// チェンジポケット
	private String ocChangePkt;

	private Map<String, String> ocChangePktMap;

	// スランテッドポケット
	private String ocSlantedPkt;

	private Map<String, String> ocSlantedPktMap;

	// ベント
	private String ocVentSpec;

	private Map<String, String> ocVentSpecMap;

	// フロント釦数
	private String ocFrontBtnCnt;

	private Map<String, String> ocFrontBtnCntMap;

	// 袖口
	private String ocCuffSpec;

	private Map<String, String> ocCuffSpecMap;

	// 袖釦
	private String ocSleeveBtnType;

	private Map<String, String> ocSleeveBtnTypeMap;

	// バックベルト
	private String ocBackBelt;

	private Map<String, String> ocBackBeltMap;

	// 襟吊
	private String ocChainHange;

	private Map<String, String> ocChainHangeMap;

	// 胴裏素材
	private String ocBodyBackMate;

	private Map<String, String> ocBodyBackMateMap;
	
	//胴裏素材品番
	private String ocBodyBackMateStkNo;

	// 袖裏素材
	private String ocCuffBackMate;

	private Map<String, String> ocCuffBackMateMap;
	
	//袖裏素材品番
	private String ocCuffBackMateStkNo;

	// 釦素材
	private String ocFrontBtnMate;

	private Map<String, String> ocFrontBtnMateMap;
	
	//釦素材品番
	private String ocFrontBtnMateStkNo;

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

	public String getOcBodyBackMateStkNo() {
		return ocBodyBackMateStkNo;
	}

	public void setOcBodyBackMateStkNo(String ocBodyBackMateStkNo) {
		this.ocBodyBackMateStkNo = ocBodyBackMateStkNo;
	}

	public String getOcCuffBackMateStkNo() {
		return ocCuffBackMateStkNo;
	}

	public void setOcCuffBackMateStkNo(String ocCuffBackMateStkNo) {
		this.ocCuffBackMateStkNo = ocCuffBackMateStkNo;
	}

	public String getOcFrontBtnMateStkNo() {
		return ocFrontBtnMateStkNo;
	}

	public void setOcFrontBtnMateStkNo(String ocFrontBtnMateStkNo) {
		this.ocFrontBtnMateStkNo = ocFrontBtnMateStkNo;
	}

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

}
