package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

public class CoAdjustJacketStandardInfo implements Serializable {
	private static final long serialVersionUID = 8096233544839181551L;

	// 号数 体型
	private Map<String, String> sizeNumberMap;
	
	private String sizeNumber;
	// 体型
	private Map<String, String> sizeFigureMap;

	private String sizeFigure;
	// 着丈修正
	private Map<String, String> corJkBodyMap;
	// 着丈型サイズ
	private String corJkBodySize;
	// 着丈補正値
	private String corJkBodyCorrect;
	// 着丈グロス
	private String corJkBodyGross;

	// ウエスト修正
	private Map<String, String> corJkWaistMap;
	// ウエスト型サイズ
	private String corJkWaistSize;
	// ウエスト補正値
	private String corJkWaistCorrect;
	// ウエストグロス
	private String corJkWaistGross;

	// 袖丈右修正
	private Map<String, String> corJkRightsleeveMap;
	// 袖丈右型サイズ
	private String corJkRightsleeveSize;
	// 袖丈右補正値
	private String corJkRightsleeveCorrect;
	// 袖丈右グロス
	private String corJkRightsleeveGross;

	// 袖丈左修正
	private Map<String, String> corJkLeftsleeveMap;
	// 袖丈左型サイズ
	private String corJkLeftsleeveSize;
	// 袖丈左補正値
	private String corJkLeftsleeveCorrect;
	// 袖丈左グロス
	private String corJkLeftsleeveGross;
	
	// 肩パット
	private String corJkShoulderPadCd;
	
	// 体型補正
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
