package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import co.jp.aoyama.macchinetta.app.order.OrderForm.Pt2Item;

public class AdjustPants2StandardInfo implements Serializable {
	private static final long serialVersionUID = 8082462722647632661L;
	// 号数
	private Map<String, String> sizeNumberMap;
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）の号数を入力して下さい。")
	private String sizeNumber;
	// 体型
	private Map<String, String> sizeFigureMap;
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）の体型を入力して下さい。")
	private String sizeFigure;

	// ウエスト修正2
	private Map<String, String> corPt2WaistMap;
	// ウエスト型サイズ2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）のウエスト型サイズが不正です。")
	@Range(min=1, max=999, groups = {Pt2Item.class}, message = "PANTS（2本目）のウエスト型サイズの範囲が不正です。")
	private String corPt2WaistSize;
	// ウエスト補正値2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）のウエスト補正値を入力して下さい。")
	private String corPt2WaistCorrect;
	// ウエストグロス2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）のウエストグロスが不正です。")
	@Range(min=1, max=999, groups = {Pt2Item.class}, message = "PANTS（2本目）のウエストグロスの範囲が不正です。")
	private String corPt2WaistGross;

	// ワタリ修正2
	private Map<String, String> corPt2ThighMap;
	// ワタリ型サイズ2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）のワタリ型サイズが不正です。")
	@Range(min=1, max=999, groups = {Pt2Item.class}, message = "PANTS（2本目）のワタリ型サイズの範囲が不正です。")
	private String corPt2ThighSize;
	// ワタリ補正値2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）のワタリ補正値を入力して下さい。")
	private String corPt2ThighCorrect;
	// ワタリグロス2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）のワタリグロスが不正です。")
	@Range(min=1, max=999, groups = {Pt2Item.class}, message = "PANTS（2本目）のワタリグロスの範囲が不正です。")
	private String corPt2ThighGross;
	
	// 裾幅修正2
	private Map<String, String> corPt2HemwidthMap;
	// 裾幅修正1指定2区分2
	private String corPt2HemwidthType;
	// 裾幅型サイズ2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）の裾幅型サイズが不正です。")
	@Range(min=1, max=999, groups = {Pt2Item.class}, message = "PANTS（2本目）の裾幅型サイズの範囲が不正です。")
	private String corPt2HemwidthSize;
	// 裾幅補正値2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）の裾幅補正値を入力して下さい。")
	private String corPt2HemwidthCorrect;
	// 裾幅グロス2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）の裾幅グロスが不正です。")
	@Range(min=1, max=999, groups = {Pt2Item.class}, message = "PANTS（2本目）の裾幅グロスの範囲が不正です。")
	private String corPt2HemwidthGross;

	// 股下右型サイズ2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）の股下右型サイズが不正です。")
	@Range(min=1, max=999, groups = {Pt2Item.class}, message = "PANTS（2本目）の股下右型サイズの範囲が不正です。")
	private String corPt2RightinseamSize;
	// 股下右補正値2
	private String corPt2RightinseamCorrect;
	// 股下右グロス2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）の股下右グロスが不正です。")
	@Range(min=50, max=110, groups = {Pt2Item.class}, message = "PANTS（2本目）の股下右グロスの範囲が不正です。")
	private String corPt2RightinseamGross;

	// 股下左型サイズ2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）の股下左型サイズが不正です。")
	@Range(min=1, max=999, groups = {Pt2Item.class}, message = "PANTS（2本目）の股下左型サイズの範囲が不正です。")
	private String corPt2LeftinseamSize;
	// 股下左補正値2
	private String corPt2LeftinseamCorrect;
	// 股下左グロス2
	@NotBlank(groups = {Pt2Item.class}, message = "PANTS（2本目）の股下左グロスが不正です。")
	@Range(min=50, max=110, groups = {Pt2Item.class}, message = "PANTS（2本目）の股下左グロスの範囲が不正です。")
	private String corPt2LeftinseamGross;

	//Pt2再補正コメント
	private String corPt2StoreCorrectionMemo;
	// 再補正値

	// ２PANTS_ウエスト_再補正値
	private String corPt2WaistCorrectAgain;

	// ２PANTS_ウエスト_再補正値フラッグ
	private String corPt2WaistCorrectAgainFlag;
	
	// ２PANTS_ヒップ_再補正値
	private String corPt2HipCorrectAgain;

	// ２PANTS_ヒップ_再補正値フラッグ
	private String corPt2HipCorrectAgainFlag;

	// ２PANTS_ワタリ_再補正値
	private String corPt2ThighwidthCorrectAgain;

	// ２PANTS_ワタリ_再補正値フラッグ
	private String corPt2ThighwidthCorrectAgainFlag;

	// ２PANTS_裾幅_修正_再補正値
	private String corPt2HemwidthCorrectAgain;

	// ２PANTS_裾幅_修正_再補正値フラッグ
	private String corPt2HemwidthCorrectAgainFlag;

	// ２PANTS_股下右_再補正値
	private String corPt2RightinseamCorrectAgain;

	// ２PANTS_股下右_再補正値フラッグ
	private String corPt2RightinseamCorrectAgainFlag;

	// ２PANTS_股下左_再補正値
	private String corPt2LeftinseamCorrectAgain;

	// ２PANTS_股下左_再補正値フラッグ
	private String corPt2LeftinseamCorrectAgainFlag;

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

	public Map<String, String> getCorPt2WaistMap() {
		return corPt2WaistMap;
	}

	public void setCorPt2WaistMap(Map<String, String> corPt2WaistMap) {
		this.corPt2WaistMap = corPt2WaistMap;
	}

	public String getCorPt2WaistSize() {
		return corPt2WaistSize;
	}

	public void setCorPt2WaistSize(String corPt2WaistSize) {
		this.corPt2WaistSize = corPt2WaistSize;
	}

	public String getCorPt2WaistCorrect() {
		return corPt2WaistCorrect;
	}

	public void setCorPt2WaistCorrect(String corPt2WaistCorrect) {
		this.corPt2WaistCorrect = corPt2WaistCorrect;
	}

	public String getCorPt2WaistGross() {
		return corPt2WaistGross;
	}

	public void setCorPt2WaistGross(String corPt2WaistGross) {
		this.corPt2WaistGross = corPt2WaistGross;
	}

	public Map<String, String> getCorPt2ThighMap() {
		return corPt2ThighMap;
	}

	public void setCorPt2ThighMap(Map<String, String> corPt2ThighMap) {
		this.corPt2ThighMap = corPt2ThighMap;
	}

	public String getCorPt2ThighSize() {
		return corPt2ThighSize;
	}

	public void setCorPt2ThighSize(String corPt2ThighSize) {
		this.corPt2ThighSize = corPt2ThighSize;
	}

	public String getCorPt2ThighCorrect() {
		return corPt2ThighCorrect;
	}

	public void setCorPt2ThighCorrect(String corPt2ThighCorrect) {
		this.corPt2ThighCorrect = corPt2ThighCorrect;
	}

	public String getCorPt2ThighGross() {
		return corPt2ThighGross;
	}

	public void setCorPt2ThighGross(String corPt2ThighGross) {
		this.corPt2ThighGross = corPt2ThighGross;
	}

	public Map<String, String> getCorPt2HemwidthMap() {
		return corPt2HemwidthMap;
	}

	public void setCorPt2HemwidthMap(Map<String, String> corPt2HemwidthMap) {
		this.corPt2HemwidthMap = corPt2HemwidthMap;
	}

	public String getCorPt2HemwidthType() {
		return corPt2HemwidthType;
	}

	public void setCorPt2HemwidthType(String corPt2HemwidthType) {
		this.corPt2HemwidthType = corPt2HemwidthType;
	}

	public String getCorPt2HemwidthSize() {
		return corPt2HemwidthSize;
	}

	public void setCorPt2HemwidthSize(String corPt2HemwidthSize) {
		this.corPt2HemwidthSize = corPt2HemwidthSize;
	}

	public String getCorPt2HemwidthCorrect() {
		return corPt2HemwidthCorrect;
	}

	public void setCorPt2HemwidthCorrect(String corPt2HemwidthCorrect) {
		this.corPt2HemwidthCorrect = corPt2HemwidthCorrect;
	}

	public String getCorPt2HemwidthGross() {
		return corPt2HemwidthGross;
	}

	public void setCorPt2HemwidthGross(String corPt2HemwidthGross) {
		this.corPt2HemwidthGross = corPt2HemwidthGross;
	}

	public String getCorPt2RightinseamSize() {
		return corPt2RightinseamSize;
	}

	public void setCorPt2RightinseamSize(String corPt2RightinseamSize) {
		this.corPt2RightinseamSize = corPt2RightinseamSize;
	}

	public String getCorPt2RightinseamCorrect() {
		return corPt2RightinseamCorrect;
	}

	public void setCorPt2RightinseamCorrect(String corPt2RightinseamCorrect) {
		this.corPt2RightinseamCorrect = corPt2RightinseamCorrect;
	}

	public String getCorPt2RightinseamGross() {
		return corPt2RightinseamGross;
	}

	public void setCorPt2RightinseamGross(String corPt2RightinseamGross) {
		this.corPt2RightinseamGross = corPt2RightinseamGross;
	}

	public String getCorPt2LeftinseamSize() {
		return corPt2LeftinseamSize;
	}

	public void setCorPt2LeftinseamSize(String corPt2LeftinseamSize) {
		this.corPt2LeftinseamSize = corPt2LeftinseamSize;
	}

	public String getCorPt2LeftinseamCorrect() {
		return corPt2LeftinseamCorrect;
	}

	public void setCorPt2LeftinseamCorrect(String corPt2LeftinseamCorrect) {
		this.corPt2LeftinseamCorrect = corPt2LeftinseamCorrect;
	}

	public String getCorPt2LeftinseamGross() {
		return corPt2LeftinseamGross;
	}

	public void setCorPt2LeftinseamGross(String corPt2LeftinseamGross) {
		this.corPt2LeftinseamGross = corPt2LeftinseamGross;
	}

	public String getCorPt2WaistCorrectAgain() {
		return corPt2WaistCorrectAgain;
	}

	public void setCorPt2WaistCorrectAgain(String corPt2WaistCorrectAgain) {
		this.corPt2WaistCorrectAgain = corPt2WaistCorrectAgain;
	}

	public String getCorPt2ThighwidthCorrectAgain() {
		return corPt2ThighwidthCorrectAgain;
	}

	public void setCorPt2ThighwidthCorrectAgain(String corPt2ThighwidthCorrectAgain) {
		this.corPt2ThighwidthCorrectAgain = corPt2ThighwidthCorrectAgain;
	}

	public String getCorPt2HemwidthCorrectAgain() {
		return corPt2HemwidthCorrectAgain;
	}

	public void setCorPt2HemwidthCorrectAgain(String corPt2HemwidthCorrectAgain) {
		this.corPt2HemwidthCorrectAgain = corPt2HemwidthCorrectAgain;
	}

	public String getCorPt2RightinseamCorrectAgain() {
		return corPt2RightinseamCorrectAgain;
	}

	public void setCorPt2RightinseamCorrectAgain(String corPt2RightinseamCorrectAgain) {
		this.corPt2RightinseamCorrectAgain = corPt2RightinseamCorrectAgain;
	}

	public String getCorPt2LeftinseamCorrectAgain() {
		return corPt2LeftinseamCorrectAgain;
	}

	public void setCorPt2LeftinseamCorrectAgain(String corPt2LeftinseamCorrectAgain) {
		this.corPt2LeftinseamCorrectAgain = corPt2LeftinseamCorrectAgain;
	}

	public String getCorPt2WaistCorrectAgainFlag() {
		return corPt2WaistCorrectAgainFlag;
	}

	public void setCorPt2WaistCorrectAgainFlag(String corPt2WaistCorrectAgainFlag) {
		this.corPt2WaistCorrectAgainFlag = corPt2WaistCorrectAgainFlag;
	}

	public String getCorPt2ThighwidthCorrectAgainFlag() {
		return corPt2ThighwidthCorrectAgainFlag;
	}

	public void setCorPt2ThighwidthCorrectAgainFlag(String corPt2ThighwidthCorrectAgainFlag) {
		this.corPt2ThighwidthCorrectAgainFlag = corPt2ThighwidthCorrectAgainFlag;
	}

	public String getCorPt2HemwidthCorrectAgainFlag() {
		return corPt2HemwidthCorrectAgainFlag;
	}

	public void setCorPt2HemwidthCorrectAgainFlag(String corPt2HemwidthCorrectAgainFlag) {
		this.corPt2HemwidthCorrectAgainFlag = corPt2HemwidthCorrectAgainFlag;
	}

	public String getCorPt2RightinseamCorrectAgainFlag() {
		return corPt2RightinseamCorrectAgainFlag;
	}

	public void setCorPt2RightinseamCorrectAgainFlag(String corPt2RightinseamCorrectAgainFlag) {
		this.corPt2RightinseamCorrectAgainFlag = corPt2RightinseamCorrectAgainFlag;
	}

	public String getCorPt2LeftinseamCorrectAgainFlag() {
		return corPt2LeftinseamCorrectAgainFlag;
	}

	public void setCorPt2LeftinseamCorrectAgainFlag(String corPt2LeftinseamCorrectAgainFlag) {
		this.corPt2LeftinseamCorrectAgainFlag = corPt2LeftinseamCorrectAgainFlag;
	}

	public String getCorPt2StoreCorrectionMemo() {
		return corPt2StoreCorrectionMemo;
	}

	public void setCorPt2StoreCorrectionMemo(String corPt2StoreCorrectionMemo) {
		this.corPt2StoreCorrectionMemo = corPt2StoreCorrectionMemo;
	}

	public String getCorPt2HipCorrectAgain() {
		return corPt2HipCorrectAgain;
	}

	public void setCorPt2HipCorrectAgain(String corPt2HipCorrectAgain) {
		this.corPt2HipCorrectAgain = corPt2HipCorrectAgain;
	}

	public String getCorPt2HipCorrectAgainFlag() {
		return corPt2HipCorrectAgainFlag;
	}

	public void setCorPt2HipCorrectAgainFlag(String corPt2HipCorrectAgainFlag) {
		this.corPt2HipCorrectAgainFlag = corPt2HipCorrectAgainFlag;
	}
	
}
