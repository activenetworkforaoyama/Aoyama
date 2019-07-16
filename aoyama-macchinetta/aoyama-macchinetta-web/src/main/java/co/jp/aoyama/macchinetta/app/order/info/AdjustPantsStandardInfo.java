package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;

public class AdjustPantsStandardInfo implements Serializable {
	private static final long serialVersionUID = 8082462722647632661L;
	// 号数
	private Map<String, String> sizeNumberMap;

	private String sizeNumber;
	// 体型
	private Map<String, String> sizeFigureMap;

	private String sizeFigure;
	// ウエスト修正
	private Map<String, String> corPtWaistMap;
	// ウエスト型サイズ
	private String corPtWaistSize;
	// ウエスト補正値
	private String corPtWaistCorrect;
	// ウエストグロス
	private String corPtWaistGross;

	// ワタリ修正
	private Map<String, String> corPtThighMap;
	// ワタリ型サイズ
	private String corPtThighSize;
	// ワタリ補正値
	private String corPtThighCorrect;
	// ワタリグロス
	private String corPtThighGross;

	// 裾幅修正
	private Map<String, String> corPtHemwidthMap;
	// 裾幅修正1指定2区分
	private String corPtHemwidthType;
	// 裾幅型サイズ
	private String corPtHemwidthSize;
	// 裾幅補正値
	private String corPtHemwidthCorrect;
	// 裾幅グロス
	private String corPtHemwidthGross;

	// 股下右型サイズ
	private String corPtRightinseamSize;
	// 股下右補正値
	private String corPtRightinseamCorrect;
	// 股下右グロス
	private String corPtRightinseamGross;

	// 股下左型サイズ
	private String corPtLeftinseamSize;
	// 股下左補正値
	private String corPtLeftinseamCorrect;
	// 股下左グロス
	private String corPtLeftinseamGross;

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
}
