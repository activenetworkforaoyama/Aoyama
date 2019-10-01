package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;


import org.hibernate.validator.constraints.NotBlank;

import co.jp.aoyama.macchinetta.app.order.OrderForm.GiletItem;

public class AdjustGiletStandardInfo implements Serializable {
	private static final long serialVersionUID = -4015395935551145245L;
	
	// 号数
	private Map<String, String> sizeNumberMap;
	@NotBlank(groups = {GiletItem.class}, message = "GILETの号数を入力して下さい。")
	private String sizeNumber;
	
	// 体型
	private Map<String, String> sizeFigureMap;
	@NotBlank(groups = {GiletItem.class}, message = "GILETの体型を入力して下さい。")
	private String sizeFigure;

	//再補正コメント
	private String corGlStoreCorrectionMemo;

	// GILET_着丈_再補正値
	private String corGlBodylengthCorrectAgain;
	
	// GILET_着丈_再補正値フラッグ
	private String corGlBodylengthCorrectAgainFlag;

	// GILET_バスト_再補正値
	private String corGlBustCorrectAgain;
	
	// GILET_バスト_再補正値フラッグ
	private String corGlBustCorrectAgainFlag;
	
	// GILET_ウエスト_再補正値
	private String corGlWaistCorrectAgain;
	
	// GILET_ウエスト_再補正値フラッグ
	private String corGlWaistCorrectAgainFlag;

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

	public String getCorGlBodylengthCorrectAgain() {
		return corGlBodylengthCorrectAgain;
	}

	public void setCorGlBodylengthCorrectAgain(String corGlBodylengthCorrectAgain) {
		this.corGlBodylengthCorrectAgain = corGlBodylengthCorrectAgain;
	}

	public String getCorGlBustCorrectAgain() {
		return corGlBustCorrectAgain;
	}

	public void setCorGlBustCorrectAgain(String corGlBustCorrectAgain) {
		this.corGlBustCorrectAgain = corGlBustCorrectAgain;
	}

	public String getCorGlStoreCorrectionMemo() {
		return corGlStoreCorrectionMemo;
	}

	public void setCorGlStoreCorrectionMemo(String corGlStoreCorrectionMemo) {
		this.corGlStoreCorrectionMemo = corGlStoreCorrectionMemo;
	}

	public String getCorGlWaistCorrectAgain() {
		return corGlWaistCorrectAgain;
	}

	public void setCorGlWaistCorrectAgain(String corGlWaistCorrectAgain) {
		this.corGlWaistCorrectAgain = corGlWaistCorrectAgain;
	}

	public String getCorGlBodylengthCorrectAgainFlag() {
		return corGlBodylengthCorrectAgainFlag;
	}

	public void setCorGlBodylengthCorrectAgainFlag(String corGlBodylengthCorrectAgainFlag) {
		this.corGlBodylengthCorrectAgainFlag = corGlBodylengthCorrectAgainFlag;
	}

	public String getCorGlBustCorrectAgainFlag() {
		return corGlBustCorrectAgainFlag;
	}

	public void setCorGlBustCorrectAgainFlag(String corGlBustCorrectAgainFlag) {
		this.corGlBustCorrectAgainFlag = corGlBustCorrectAgainFlag;
	}

	public String getCorGlWaistCorrectAgainFlag() {
		return corGlWaistCorrectAgainFlag;
	}

	public void setCorGlWaistCorrectAgainFlag(String corGlWaistCorrectAgainFlag) {
		this.corGlWaistCorrectAgainFlag = corGlWaistCorrectAgainFlag;
	}
	
}
