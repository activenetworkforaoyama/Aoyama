package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.HemwidthDegignatePtAdItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.HemwidthPtAdItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.PtAdItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.PtThreeModelItem;


public class CoAdjustPantsStandardInfo implements Serializable {
	private static final long serialVersionUID = 8082462722647632661L;
	// 号数
	private Map<String, String> sizeNumberMap;
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）の号数を入力して下さい。")
	private String sizeNumber;
	// 体型
	private Map<String, String> sizeFigureMap;
	@NotBlank(groups = {PtThreeModelItem.class}, message = "PANTS（1本目）の体型を入力して下さい。")
	private String sizeFigure;
	// ウエスト修正
	private Map<String, String> corPtWaistMap;
	// ウエスト型サイズ
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）のウエスト型サイズが不正です。")
	@Range(min=1, max=999, groups = {PtAdItem.class}, message = "PANTS（1本目）のウエスト型サイズの範囲が不正です。")
	private String corPtWaistSize;
	// ウエスト補正値
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）のウエスト補正値を入力して下さい。")
	private String corPtWaistCorrect;
	// ウエストグロス
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）のウエストグロスが不正です。")
	@Range(min=1, max=999, groups = {PtAdItem.class}, message = "PANTS（1本目）のウエストグロスの範囲が不正です。")
	private String corPtWaistGross;

	// ワタリ修正
	private Map<String, String> corPtThighMap;
	// ワタリ型サイズ
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）のワタリ型サイズが不正です。")
	@Range(min=1, max=999, groups = {PtAdItem.class}, message = "PANTS（1本目）のワタリ型サイズの範囲が不正です。")
	private String corPtThighSize;
	// ワタリ補正値
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）のワタリ補正値を入力して下さい。")
	private String corPtThighCorrect;
	// ワタリグロス
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）のワタリグロスが不正です。")
	@Range(min=1, max=999, groups = {PtAdItem.class}, message = "PANTS（1本目）のワタリグロスの範囲が不正です。")
	private String corPtThighGross;

	// 裾幅修正
	private Map<String, String> corPtHemwidthMap;
	// 裾幅修正1指定2区分
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）の裾幅修正区分が不正です。")
	private String corPtHemwidthType;
	// 裾幅型サイズ
	@NotBlank(groups = {HemwidthPtAdItem.class}, message = "PANTS（1本目）の裾幅型サイズが不正です。")
	@Range(min=1, max=999, groups = {HemwidthPtAdItem.class}, message = "PANTS（1本目）の裾幅型サイズの範囲が不正です。")
	private String corPtHemwidthSize;
	// 裾幅補正値
	@NotBlank(groups = {HemwidthPtAdItem.class}, message = "PANTS（1本目）の裾幅補正値を入力して下さい。")
	private String corPtHemwidthCorrect;
	// 裾幅グロス
	@NotBlank(groups = {HemwidthPtAdItem.class}, message = "PANTS（1本目）の裾幅グロスが不正です。")
	@Range(min=1, max=999, groups = {HemwidthPtAdItem.class}, message = "PANTS（1本目）の裾幅グロスの範囲が不正です。")
	private String corPtHemwidthGross;
	//裾幅指定値
	@NotBlank(groups = {HemwidthDegignatePtAdItem.class}, message = "PANTS（1本目）の裾幅指定値を入力して下さい。")
	private String corPtHemwidthDegignate;
	
	//ヒップ修正
	private Map<String, String> corPtHipMap;
	// ヒップ型サイズ
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）のヒップ型サイズが不正です。")
	@Range(min=1, max=999, groups = {PtAdItem.class}, message = "PANTS（1本目）のヒップ型サイズの範囲が不正です。")
	private String corPtHipSize;
	// ヒップ補正値
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）のヒップ補正値を入力して下さい。")
	private String corPtHipCorrect;
	//ヒップグロス
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）のヒップグロスが不正です。")
	@Range(min=1, max=999, groups = {PtAdItem.class}, message = "PANTS（1本目）のヒップグロスの範囲が不正です。")
	private String corPtHipGross;

	// 股下右型サイズ
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）の股下右型サイズが不正です。")
	@Range(min=1, max=999, groups = {PtAdItem.class}, message = "PANTS（1本目）の股下右型サイズの範囲が不正です。")
	private String corPtRightinseamSize;
	// 股下右補正値
	private String corPtRightinseamCorrect;
	// 股下右グロス
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）の股下右グロスが不正です。")
	@Range(min=50, max=110, groups = {PtAdItem.class}, message = "PANTS（1本目）の股下右グロスの範囲が不正です。")
	private String corPtRightinseamGross;

	// 股下左型サイズ
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）の股下左型サイズが不正です。")
	@Range(min=1, max=999, groups = {PtAdItem.class}, message = "PANTS（1本目）の股下左型サイズの範囲が不正です。")
	private String corPtLeftinseamSize;
	// 股下左補正値
	private String corPtLeftinseamCorrect;
	// 股下左グロス
	@NotBlank(groups = {PtAdItem.class}, message = "PANTS（1本目）の股下左グロスが不正です。")
	@Range(min=50, max=110, groups = {PtAdItem.class}, message = "PANTS（1本目）の股下左グロスの範囲が不正です。")
	private String corPtLeftinseamGross;
	
	//Pt再補正コメント
    private String corPtStoreCorrectionMemo;
	// 再補正値

	// PANTS_ウエスト_再補正値
	private String corPtWaistCorrectAgain;

	// PANTS_ウエスト_再補正値フラッグ
	private String corPtWaistCorrectAgainFlag;

	// PANTS_ヒップ_再補正値
	private String corPtHipCorrectAgain;

	// PANTS_ヒップ_再補正値フラッグ
	private String corPtHipCorrectAgainFlag;

	// PANTS_ワタリ_再補正値
	private String corPtThighwidthCorrectAgain;

	// PANTS_ワタリ_再補正値フラッグ
	private String corPtThighwidthCorrectAgainFlag;

	// PANTS_裾幅_修正_再補正値
	private String corPtHemwidthCorrectAgain;

	// PANTS_裾幅_修正_再補正値フラッグ
	private String corPtHemwidthCorrectAgainFlag;

	// PANTS_股下右_再補正値
	private String corPtRightinseamCorrectAgain;

	// PANTS_股下右_再補正値フラッグ
	private String corPtRightinseamCorrectAgainFlag;

	// PANTS_股下左_再補正値
	private String corPtLeftinseamCorrectAgain;

	// PANTS_股下左_再補正値フラッグ
	private String corPtLeftinseamCorrectAgainFlag;

	public Map<String, String> getCorPtHipMap() {
		return corPtHipMap;
	}

	public void setCorPtHipMap(Map<String, String> corPtHipMap) {
		this.corPtHipMap = corPtHipMap;
	}

	public String getCorPtHipSize() {
		return corPtHipSize;
	}

	public void setCorPtHipSize(String corPtHipSize) {
		this.corPtHipSize = corPtHipSize;
	}

	public String getCorPtHipCorrect() {
		return corPtHipCorrect;
	}

	public void setCorPtHipCorrect(String corPtHipCorrect) {
		this.corPtHipCorrect = corPtHipCorrect;
	}

	public String getCorPtHipGross() {
		return corPtHipGross;
	}

	public void setCorPtHipGross(String corPtHipGross) {
		this.corPtHipGross = corPtHipGross;
	}

	public Map<String, String> getSizeNumberMap() {
		return sizeNumberMap;
	}

	public void setSizeNumberMap(Map<String, String> sizeNumberMap) {
		this.sizeNumberMap = sizeNumberMap;
	}

	public String getSizeNumber() {
		return sizeNumber;
	}

	public void setSizeNumber(String sizeNumber) {
		this.sizeNumber = sizeNumber;
	}

	public Map<String, String> getSizeFigureMap() {
		return sizeFigureMap;
	}

	public void setSizeFigureMap(Map<String, String> sizeFigureMap) {
		this.sizeFigureMap = sizeFigureMap;
	}

	public String getSizeFigure() {
		return sizeFigure;
	}

	public void setSizeFigure(String sizeFigure) {
		this.sizeFigure = sizeFigure;
	}

	public Map<String, String> getCorPtWaistMap() {
		return corPtWaistMap;
	}

	public void setCorPtWaistMap(Map<String, String> corPtWaistMap) {
		this.corPtWaistMap = corPtWaistMap;
	}

	public String getCorPtWaistSize() {
		return corPtWaistSize;
	}

	public void setCorPtWaistSize(String corPtWaistSize) {
		this.corPtWaistSize = corPtWaistSize;
	}

	public String getCorPtWaistCorrect() {
		return corPtWaistCorrect;
	}

	public void setCorPtWaistCorrect(String corPtWaistCorrect) {
		this.corPtWaistCorrect = corPtWaistCorrect;
	}

	public String getCorPtWaistGross() {
		return corPtWaistGross;
	}

	public void setCorPtWaistGross(String corPtWaistGross) {
		this.corPtWaistGross = corPtWaistGross;
	}

	public Map<String, String> getCorPtThighMap() {
		return corPtThighMap;
	}

	public void setCorPtThighMap(Map<String, String> corPtThighMap) {
		this.corPtThighMap = corPtThighMap;
	}

	public String getCorPtThighSize() {
		return corPtThighSize;
	}

	public void setCorPtThighSize(String corPtThighSize) {
		this.corPtThighSize = corPtThighSize;
	}

	public String getCorPtThighCorrect() {
		return corPtThighCorrect;
	}

	public void setCorPtThighCorrect(String corPtThighCorrect) {
		this.corPtThighCorrect = corPtThighCorrect;
	}

	public String getCorPtThighGross() {
		return corPtThighGross;
	}

	public void setCorPtThighGross(String corPtThighGross) {
		this.corPtThighGross = corPtThighGross;
	}

	public Map<String, String> getCorPtHemwidthMap() {
		return corPtHemwidthMap;
	}

	public void setCorPtHemwidthMap(Map<String, String> corPtHemwidthMap) {
		this.corPtHemwidthMap = corPtHemwidthMap;
	}

	public String getCorPtHemwidthType() {
		return corPtHemwidthType;
	}

	public void setCorPtHemwidthType(String corPtHemwidthType) {
		this.corPtHemwidthType = corPtHemwidthType;
	}

	public String getCorPtHemwidthSize() {
		return corPtHemwidthSize;
	}

	public void setCorPtHemwidthSize(String corPtHemwidthSize) {
		this.corPtHemwidthSize = corPtHemwidthSize;
	}

	public String getCorPtHemwidthCorrect() {
		return corPtHemwidthCorrect;
	}

	public void setCorPtHemwidthCorrect(String corPtHemwidthCorrect) {
		this.corPtHemwidthCorrect = corPtHemwidthCorrect;
	}

	public String getCorPtHemwidthGross() {
		return corPtHemwidthGross;
	}

	public void setCorPtHemwidthGross(String corPtHemwidthGross) {
		this.corPtHemwidthGross = corPtHemwidthGross;
	}

	public String getCorPtRightinseamSize() {
		return corPtRightinseamSize;
	}

	public void setCorPtRightinseamSize(String corPtRightinseamSize) {
		this.corPtRightinseamSize = corPtRightinseamSize;
	}

	public String getCorPtRightinseamCorrect() {
		return corPtRightinseamCorrect;
	}

	public void setCorPtRightinseamCorrect(String corPtRightinseamCorrect) {
		this.corPtRightinseamCorrect = corPtRightinseamCorrect;
	}

	public String getCorPtRightinseamGross() {
		return corPtRightinseamGross;
	}

	public void setCorPtRightinseamGross(String corPtRightinseamGross) {
		this.corPtRightinseamGross = corPtRightinseamGross;
	}

	public String getCorPtLeftinseamSize() {
		return corPtLeftinseamSize;
	}

	public void setCorPtLeftinseamSize(String corPtLeftinseamSize) {
		this.corPtLeftinseamSize = corPtLeftinseamSize;
	}

	public String getCorPtLeftinseamCorrect() {
		return corPtLeftinseamCorrect;
	}

	public void setCorPtLeftinseamCorrect(String corPtLeftinseamCorrect) {
		this.corPtLeftinseamCorrect = corPtLeftinseamCorrect;
	}

	public String getCorPtLeftinseamGross() {
		return corPtLeftinseamGross;
	}

	public void setCorPtLeftinseamGross(String corPtLeftinseamGross) {
		this.corPtLeftinseamGross = corPtLeftinseamGross;
	}

	public String getCorPtWaistCorrectAgain() {
		return corPtWaistCorrectAgain;
	}

	public void setCorPtWaistCorrectAgain(String corPtWaistCorrectAgain) {
		this.corPtWaistCorrectAgain = corPtWaistCorrectAgain;
	}

	public String getCorPtHipCorrectAgain() {
		return corPtHipCorrectAgain;
	}

	public void setCorPtHipCorrectAgain(String corPtHipCorrectAgain) {
		this.corPtHipCorrectAgain = corPtHipCorrectAgain;
	}

	public String getCorPtThighwidthCorrectAgain() {
		return corPtThighwidthCorrectAgain;
	}

	public void setCorPtThighwidthCorrectAgain(String corPtThighwidthCorrectAgain) {
		this.corPtThighwidthCorrectAgain = corPtThighwidthCorrectAgain;
	}

	public String getCorPtHemwidthCorrectAgain() {
		return corPtHemwidthCorrectAgain;
	}

	public void setCorPtHemwidthCorrectAgain(String corPtHemwidthCorrectAgain) {
		this.corPtHemwidthCorrectAgain = corPtHemwidthCorrectAgain;
	}

	public String getCorPtRightinseamCorrectAgain() {
		return corPtRightinseamCorrectAgain;
	}

	public void setCorPtRightinseamCorrectAgain(String corPtRightinseamCorrectAgain) {
		this.corPtRightinseamCorrectAgain = corPtRightinseamCorrectAgain;
	}

	public String getCorPtLeftinseamCorrectAgain() {
		return corPtLeftinseamCorrectAgain;
	}

	public void setCorPtLeftinseamCorrectAgain(String corPtLeftinseamCorrectAgain) {
		this.corPtLeftinseamCorrectAgain = corPtLeftinseamCorrectAgain;
	}

	public String getCorPtWaistCorrectAgainFlag() {
		return corPtWaistCorrectAgainFlag;
	}

	public void setCorPtWaistCorrectAgainFlag(String corPtWaistCorrectAgainFlag) {
		this.corPtWaistCorrectAgainFlag = corPtWaistCorrectAgainFlag;
	}

	public String getCorPtHipCorrectAgainFlag() {
		return corPtHipCorrectAgainFlag;
	}

	public void setCorPtHipCorrectAgainFlag(String corPtHipCorrectAgainFlag) {
		this.corPtHipCorrectAgainFlag = corPtHipCorrectAgainFlag;
	}

	public String getCorPtThighwidthCorrectAgainFlag() {
		return corPtThighwidthCorrectAgainFlag;
	}

	public void setCorPtThighwidthCorrectAgainFlag(String corPtThighwidthCorrectAgainFlag) {
		this.corPtThighwidthCorrectAgainFlag = corPtThighwidthCorrectAgainFlag;
	}

	public String getCorPtHemwidthCorrectAgainFlag() {
		return corPtHemwidthCorrectAgainFlag;
	}

	public void setCorPtHemwidthCorrectAgainFlag(String corPtHemwidthCorrectAgainFlag) {
		this.corPtHemwidthCorrectAgainFlag = corPtHemwidthCorrectAgainFlag;
	}

	public String getCorPtRightinseamCorrectAgainFlag() {
		return corPtRightinseamCorrectAgainFlag;
	}

	public void setCorPtRightinseamCorrectAgainFlag(String corPtRightinseamCorrectAgainFlag) {
		this.corPtRightinseamCorrectAgainFlag = corPtRightinseamCorrectAgainFlag;
	}

	public String getCorPtLeftinseamCorrectAgainFlag() {
		return corPtLeftinseamCorrectAgainFlag;
	}

	public void setCorPtLeftinseamCorrectAgainFlag(String corPtLeftinseamCorrectAgainFlag) {
		this.corPtLeftinseamCorrectAgainFlag = corPtLeftinseamCorrectAgainFlag;
	}

	public String getCorPtStoreCorrectionMemo() {
		return corPtStoreCorrectionMemo;
	}

	public void setCorPtStoreCorrectionMemo(String corPtStoreCorrectionMemo) {
		this.corPtStoreCorrectionMemo = corPtStoreCorrectionMemo;
	}

	public String getCorPtHemwidthDegignate() {
		return corPtHemwidthDegignate;
	}

	public void setCorPtHemwidthDegignate(String corPtHemwidthDegignate) {
		this.corPtHemwidthDegignate = corPtHemwidthDegignate;
	}
	
}
