package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;

public class AdjustGiletStandardInfo implements Serializable {
	private static final long serialVersionUID = -4015395935551145245L;
	// 号数
	private Map<String, String> sizeNumberMap;

	private String sizeNumber;
	// 体型
	private Map<String, String> sizeFigureMap;

	private String sizeFigure;
	
	//再補正値
	
	//GILET_着丈_再補正値
	private String corGlBodylengthCorrectAgain;

	//GILET_バスト_再補正値
	private String corGlBustCorrectAgain;
	
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

	
}
