package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.JkAdItem;

public class CoAdjustJacketStandardInfo implements Serializable {
	private static final long serialVersionUID = 8096233544839181551L;

	// 号数 体型
	private Map<String, String> sizeNumberMap;
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの号数を入力して下さい。")
	private String sizeNumber;
	// 体型
	private Map<String, String> sizeFigureMap;
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの体型を入力して下さい。")
	private String sizeFigure;
	// 着丈修正
	private Map<String, String> corJkBodyMap;
	// 着丈型サイズ
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの着丈型サイズが不正です。")
	@Range(min=1, max=999, groups = {JkAdItem.class}, message = "JACKETの着丈型サイズの範囲が不正です。")
	private String corJkBodySize;
	// 着丈補正値
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの着丈補正値を入力して下さい。")
	private String corJkBodyCorrect;
	// 着丈グロス
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの着丈グロスが不正です。")
	@Range(min=1, max=999, groups = {JkAdItem.class}, message = "JACKETの着丈グロスの範囲が不正です。")
	private String corJkBodyGross;

	// ウエスト修正
	private Map<String, String> corJkWaistMap;
	// ウエスト型サイズ
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETのウエスト型サイズ不正です。")
	@Range(min=1, max=999, groups = {JkAdItem.class}, message = "JACKETのウエスト型サイズの範囲が不正です。")
	private String corJkWaistSize;
	// ウエスト補正値
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETのウエスト補正値を入力して下さい。")
	private String corJkWaistCorrect;
	// ウエストグロス
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETのウエストグロスが不正です。")
	@Range(min=1, max=999, groups = {JkAdItem.class}, message = "JACKETのウエストグロスの範囲が不正です。")
	private String corJkWaistGross;

	// 袖丈右修正
	private Map<String, String> corJkRightsleeveMap;
	// 袖丈右型サイズ
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの袖丈右型サイズ不正です。")
	@Range(min=1, max=999, groups = {JkAdItem.class}, message = "JACKETの袖丈右型サイズの範囲が不正です。")
	private String corJkRightsleeveSize;
	// 袖丈右補正値
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの袖丈右補正値を入力して下さい。")
	private String corJkRightsleeveCorrect;
	// 袖丈右グロス
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの袖丈右グロスが不正です。")
	@Range(min=1, max=999, groups = {JkAdItem.class}, message = "JACKETの袖丈右グロスの範囲が不正です。")
	private String corJkRightsleeveGross;

	// 袖丈左修正
	private Map<String, String> corJkLeftsleeveMap;
	// 袖丈左型サイズ
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの袖丈左型サイズ不正です。")
	@Range(min=1, max=999, groups = {JkAdItem.class}, message = "JACKETの袖丈左型サイズの範囲が不正です。")
	private String corJkLeftsleeveSize;
	// 袖丈左補正値
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの袖丈左補正値を入力して下さい。")
	private String corJkLeftsleeveCorrect;
	// 袖丈左グロス
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの袖丈左グロスが不正です。")
	@Range(min=1, max=999, groups = {JkAdItem.class}, message = "JACKETの袖丈左グロスの範囲が不正です。")
	private String corJkLeftsleeveGross;
	
	// 肩パット
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの肩パットを入力して下さい。")
	private String corJkShoulderPadCd;
	
	// 体型補正
	@NotBlank(groups = {JkAdItem.class}, message = "JACKETの体型補正を入力して下さい。")
	private String corJkFigureCorrectCd;
	
	//JK再補正コメント
	private String corJkStoreCorrectionMemo;
	
	//再補正値
	
	//JACKET_着丈_再補正値
	private String corJkBodylengthCorrectAgain;
	
	//JACKET_着丈_再補正値フラッグ
	private String corJkBodylengthCorrectAgainFlag;
	
	//JACKET_ウエスト_再補正値
	private String corJkWaistCorrectAgain;
	
	//JACKET_ウエスト_再補正値フラッグ
	private String corJkWaistCorrectAgainFlag;
	
	//JACKET_袖丈右_再補正値
	private String corJkRightsleeveCorrectAgain;
	
	//JACKET_袖丈右_再補正値フラッグ
	private String corJkRightsleeveCorrectAgainFlag;
	
	//JACKET_袖丈左_再補正値
	private String corJkLeftsleeveCorrectAgain;
	
	//JACKET_袖丈左_再補正値フラッグ
	private String corJkLeftsleeveCorrectAgainFlag;
	
	public Map<String, String> getSizeNumberMap() {
		return sizeNumberMap;
	}
	public void setSizeNumberMap(Map<String, String> sizeNumberMap) {
		this.sizeNumberMap = sizeNumberMap;
	}
	public Map<String, String> getSizeFigureMap() {
		return sizeFigureMap;
	}
	public void setSizeFigureMap(Map<String, String> sizeFigureMap) {
		this.sizeFigureMap = sizeFigureMap;
	}
	public String getSizeNumber() {
		return sizeNumber;
	}
	public void setSizeNumber(String sizeNumber) {
		this.sizeNumber = sizeNumber;
	}
	public String getSizeFigure() {
		return sizeFigure;
	}
	public void setSizeFigure(String sizeFigure) {
		this.sizeFigure = sizeFigure;
	}
	public Map<String, String> getCorJkBodyMap() {
		return corJkBodyMap;
	}
	public void setCorJkBodyMap(Map<String, String> corJkBodyMap) {
		this.corJkBodyMap = corJkBodyMap;
	}
	public String getCorJkBodySize() {
		return corJkBodySize;
	}
	public void setCorJkBodySize(String corJkBodySize) {
		this.corJkBodySize = corJkBodySize;
	}
	public String getCorJkBodyCorrect() {
		return corJkBodyCorrect;
	}
	public void setCorJkBodyCorrect(String corJkBodyCorrect) {
		this.corJkBodyCorrect = corJkBodyCorrect;
	}
	public String getCorJkBodyGross() {
		return corJkBodyGross;
	}
	public void setCorJkBodyGross(String corJkBodyGross) {
		this.corJkBodyGross = corJkBodyGross;
	}
	public Map<String, String> getCorJkWaistMap() {
		return corJkWaistMap;
	}
	public void setCorJkWaistMap(Map<String, String> corJkWaistMap) {
		this.corJkWaistMap = corJkWaistMap;
	}
	public String getCorJkWaistSize() {
		return corJkWaistSize;
	}
	public void setCorJkWaistSize(String corJkWaistSize) {
		this.corJkWaistSize = corJkWaistSize;
	}
	public String getCorJkWaistCorrect() {
		return corJkWaistCorrect;
	}
	public void setCorJkWaistCorrect(String corJkWaistCorrect) {
		this.corJkWaistCorrect = corJkWaistCorrect;
	}
	public String getCorJkWaistGross() {
		return corJkWaistGross;
	}
	public void setCorJkWaistGross(String corJkWaistGross) {
		this.corJkWaistGross = corJkWaistGross;
	}
	public Map<String, String> getCorJkRightsleeveMap() {
		return corJkRightsleeveMap;
	}
	public void setCorJkRightsleeveMap(Map<String, String> corJkRightsleeveMap) {
		this.corJkRightsleeveMap = corJkRightsleeveMap;
	}
	public String getCorJkRightsleeveSize() {
		return corJkRightsleeveSize;
	}
	public void setCorJkRightsleeveSize(String corJkRightsleeveSize) {
		this.corJkRightsleeveSize = corJkRightsleeveSize;
	}
	public String getCorJkRightsleeveCorrect() {
		return corJkRightsleeveCorrect;
	}
	public void setCorJkRightsleeveCorrect(String corJkRightsleeveCorrect) {
		this.corJkRightsleeveCorrect = corJkRightsleeveCorrect;
	}
	public String getCorJkRightsleeveGross() {
		return corJkRightsleeveGross;
	}
	public void setCorJkRightsleeveGross(String corJkRightsleeveGross) {
		this.corJkRightsleeveGross = corJkRightsleeveGross;
	}
	public Map<String, String> getCorJkLeftsleeveMap() {
		return corJkLeftsleeveMap;
	}
	public void setCorJkLeftsleeveMap(Map<String, String> corJkLeftsleeveMap) {
		this.corJkLeftsleeveMap = corJkLeftsleeveMap;
	}
	public String getCorJkLeftsleeveSize() {
		return corJkLeftsleeveSize;
	}
	public void setCorJkLeftsleeveSize(String corJkLeftsleeveSize) {
		this.corJkLeftsleeveSize = corJkLeftsleeveSize;
	}
	public String getCorJkLeftsleeveCorrect() {
		return corJkLeftsleeveCorrect;
	}
	public void setCorJkLeftsleeveCorrect(String corJkLeftsleeveCorrect) {
		this.corJkLeftsleeveCorrect = corJkLeftsleeveCorrect;
	}
	public String getCorJkLeftsleeveGross() {
		return corJkLeftsleeveGross;
	}
	public void setCorJkLeftsleeveGross(String corJkLeftsleeveGross) {
		this.corJkLeftsleeveGross = corJkLeftsleeveGross;
	}
	public String getCorJkBodylengthCorrectAgain() {
		return corJkBodylengthCorrectAgain;
	}
	public void setCorJkBodylengthCorrectAgain(String corJkBodylengthCorrectAgain) {
		this.corJkBodylengthCorrectAgain = corJkBodylengthCorrectAgain;
	}
	public String getCorJkWaistCorrectAgain() {
		return corJkWaistCorrectAgain;
	}
	public void setCorJkWaistCorrectAgain(String corJkWaistCorrectAgain) {
		this.corJkWaistCorrectAgain = corJkWaistCorrectAgain;
	}
	public String getCorJkRightsleeveCorrectAgain() {
		return corJkRightsleeveCorrectAgain;
	}
	public void setCorJkRightsleeveCorrectAgain(String corJkRightsleeveCorrectAgain) {
		this.corJkRightsleeveCorrectAgain = corJkRightsleeveCorrectAgain;
	}
	public String getCorJkLeftsleeveCorrectAgain() {
		return corJkLeftsleeveCorrectAgain;
	}
	public void setCorJkLeftsleeveCorrectAgain(String corJkLeftsleeveCorrectAgain) {
		this.corJkLeftsleeveCorrectAgain = corJkLeftsleeveCorrectAgain;
	}
	public String getCorJkBodylengthCorrectAgainFlag() {
		return corJkBodylengthCorrectAgainFlag;
	}
	public void setCorJkBodylengthCorrectAgainFlag(String corJkBodylengthCorrectAgainFlag) {
		this.corJkBodylengthCorrectAgainFlag = corJkBodylengthCorrectAgainFlag;
	}
	public String getCorJkWaistCorrectAgainFlag() {
		return corJkWaistCorrectAgainFlag;
	}
	public void setCorJkWaistCorrectAgainFlag(String corJkWaistCorrectAgainFlag) {
		this.corJkWaistCorrectAgainFlag = corJkWaistCorrectAgainFlag;
	}
	public String getCorJkRightsleeveCorrectAgainFlag() {
		return corJkRightsleeveCorrectAgainFlag;
	}
	public void setCorJkRightsleeveCorrectAgainFlag(String corJkRightsleeveCorrectAgainFlag) {
		this.corJkRightsleeveCorrectAgainFlag = corJkRightsleeveCorrectAgainFlag;
	}
	public String getCorJkLeftsleeveCorrectAgainFlag() {
		return corJkLeftsleeveCorrectAgainFlag;
	}
	public void setCorJkLeftsleeveCorrectAgainFlag(String corJkLeftsleeveCorrectAgainFlag) {
		this.corJkLeftsleeveCorrectAgainFlag = corJkLeftsleeveCorrectAgainFlag;
	}
	
	public String getCorJkShoulderPadCd() {
		return corJkShoulderPadCd;
	}
	public void setCorJkShoulderPadCd(String corJkShoulderPadCd) {
		this.corJkShoulderPadCd = corJkShoulderPadCd;
	}
	public String getCorJkFigureCorrectCd() {
		return corJkFigureCorrectCd;
	}
	public void setCorJkFigureCorrectCd(String corJkFigureCorrectCd) {
		this.corJkFigureCorrectCd = corJkFigureCorrectCd;
	}
	public String getCorJkStoreCorrectionMemo() {
		return corJkStoreCorrectionMemo;
	}
	public void setCorJkStoreCorrectionMemo(String corJkStoreCorrectionMemo) {
		this.corJkStoreCorrectionMemo = corJkStoreCorrectionMemo;
	}
	
}
