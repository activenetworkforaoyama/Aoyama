package co.jp.aoyama.macchinetta.app.order.info;

import java.io.Serializable;
import java.util.Map;

public class AdjustCoatStandardInfo implements Serializable {
	private static final long serialVersionUID = -8877129976059721540L;
	// COATサイズ
	private Map<String, String> corCtSizeMap;
	private String corCtSize;

	// 着丈修正
	private Map<String, String> corCtBodylengthMap;
	// COAT_着丈_型サイズ
	private String corCtBodylengthSize;
	// COAT_着丈_補正値
	private String corCtBodylengthCorrect;
	// COAT_着丈_グロス
	private String corCtBodylengthGross;

	// ウエスト修正
	private Map<String, String> corCtWaistMap;
	// COAT_ウエスト_型サイズ
	private String corCtWaistSize;
	// COAT_ウエスト_補正値
	private String corCtWaistCorrect;
	// COAT_ウエスト_グロス
	private String corCtWaistGross;

	// 袖丈右修正
	private Map<String, String> corCtRightsleeveMap;
	// COAT_袖丈右_型サイズ
	private String corCtRightsleeveSize;
	// COAT_袖丈右_補正値
	private String corCtRightsleeveCorrect;
	// COAT_袖丈右_グロス
	private String corCtRightsleeveGross;

	// 袖丈左修正
	private Map<String, String> corCtLeftsleeveMap;
	// COAT_袖丈左_型サイズ
	private String corCtLeftsleeveSize;
	// COAT_袖丈左_補正値
	private String corCtLeftsleeveCorrect;
	// COAT_袖丈左_グロス
	private String corCtLeftsleeveGross;

	// ベント修正（高さ）
	private Map<String, String> corCtVenthightMap;

	// COAT_ベント修正（高さ）_型サイズ
	private String corCtVenthightSize;
	// COAT_ベント修正（高さ）_補正値
	private String corCtVenthightCorrect;
	// COAT_ベント修正（高さ）_グロス
	private String corCtVenthightGross;

	// ポケット位置
	private Map<String, String> corCtPktposMap;
	// COAT_ポケット位置_型サイズ
	private String corCtPktposSize;
	// COAT_ポケット位置_補正値
	private String corCtPktposCorrect;
	// COAT_ポケット位置_グロス
	private String corCtPktposGross;
	
	//ct再補正コメント
	private String corCtStoreCorrectionMemo;
	public Map<String, String> getCorCtSizeMap() {
		return corCtSizeMap;
	}
	public void setCorCtSizeMap(Map<String, String> corCtSizeMap) {
		this.corCtSizeMap = corCtSizeMap;
	}
	public String getCorCtSize() {
		return corCtSize;
	}
	public void setCorCtSize(String corCtSize) {
		this.corCtSize = corCtSize;
	}
	public Map<String, String> getCorCtBodylengthMap() {
		return corCtBodylengthMap;
	}
	public void setCorCtBodylengthMap(Map<String, String> corCtBodylengthMap) {
		this.corCtBodylengthMap = corCtBodylengthMap;
	}
	public String getCorCtBodylengthSize() {
		return corCtBodylengthSize;
	}
	public void setCorCtBodylengthSize(String corCtBodylengthSize) {
		this.corCtBodylengthSize = corCtBodylengthSize;
	}
	public String getCorCtBodylengthCorrect() {
		return corCtBodylengthCorrect;
	}
	public void setCorCtBodylengthCorrect(String corCtBodylengthCorrect) {
		this.corCtBodylengthCorrect = corCtBodylengthCorrect;
	}
	public String getCorCtBodylengthGross() {
		return corCtBodylengthGross;
	}
	public void setCorCtBodylengthGross(String corCtBodylengthGross) {
		this.corCtBodylengthGross = corCtBodylengthGross;
	}
	public Map<String, String> getCorCtWaistMap() {
		return corCtWaistMap;
	}
	public void setCorCtWaistMap(Map<String, String> corCtWaistMap) {
		this.corCtWaistMap = corCtWaistMap;
	}
	public String getCorCtWaistSize() {
		return corCtWaistSize;
	}
	public void setCorCtWaistSize(String corCtWaistSize) {
		this.corCtWaistSize = corCtWaistSize;
	}
	public String getCorCtWaistCorrect() {
		return corCtWaistCorrect;
	}
	public void setCorCtWaistCorrect(String corCtWaistCorrect) {
		this.corCtWaistCorrect = corCtWaistCorrect;
	}
	public String getCorCtWaistGross() {
		return corCtWaistGross;
	}
	public void setCorCtWaistGross(String corCtWaistGross) {
		this.corCtWaistGross = corCtWaistGross;
	}
	public Map<String, String> getCorCtRightsleeveMap() {
		return corCtRightsleeveMap;
	}
	public void setCorCtRightsleeveMap(Map<String, String> corCtRightsleeveMap) {
		this.corCtRightsleeveMap = corCtRightsleeveMap;
	}
	public String getCorCtRightsleeveSize() {
		return corCtRightsleeveSize;
	}
	public void setCorCtRightsleeveSize(String corCtRightsleeveSize) {
		this.corCtRightsleeveSize = corCtRightsleeveSize;
	}
	public String getCorCtRightsleeveCorrect() {
		return corCtRightsleeveCorrect;
	}
	public void setCorCtRightsleeveCorrect(String corCtRightsleeveCorrect) {
		this.corCtRightsleeveCorrect = corCtRightsleeveCorrect;
	}
	public String getCorCtRightsleeveGross() {
		return corCtRightsleeveGross;
	}
	public void setCorCtRightsleeveGross(String corCtRightsleeveGross) {
		this.corCtRightsleeveGross = corCtRightsleeveGross;
	}
	public Map<String, String> getCorCtLeftsleeveMap() {
		return corCtLeftsleeveMap;
	}
	public void setCorCtLeftsleeveMap(Map<String, String> corCtLeftsleeveMap) {
		this.corCtLeftsleeveMap = corCtLeftsleeveMap;
	}
	public String getCorCtLeftsleeveSize() {
		return corCtLeftsleeveSize;
	}
	public void setCorCtLeftsleeveSize(String corCtLeftsleeveSize) {
		this.corCtLeftsleeveSize = corCtLeftsleeveSize;
	}
	public String getCorCtLeftsleeveCorrect() {
		return corCtLeftsleeveCorrect;
	}
	public void setCorCtLeftsleeveCorrect(String corCtLeftsleeveCorrect) {
		this.corCtLeftsleeveCorrect = corCtLeftsleeveCorrect;
	}
	public String getCorCtLeftsleeveGross() {
		return corCtLeftsleeveGross;
	}
	public void setCorCtLeftsleeveGross(String corCtLeftsleeveGross) {
		this.corCtLeftsleeveGross = corCtLeftsleeveGross;
	}
	public Map<String, String> getCorCtVenthightMap() {
		return corCtVenthightMap;
	}
	public void setCorCtVenthightMap(Map<String, String> corCtVenthightMap) {
		this.corCtVenthightMap = corCtVenthightMap;
	}
	public String getCorCtVenthightSize() {
		return corCtVenthightSize;
	}
	public void setCorCtVenthightSize(String corCtVenthightSize) {
		this.corCtVenthightSize = corCtVenthightSize;
	}
	public String getCorCtVenthightCorrect() {
		return corCtVenthightCorrect;
	}
	public void setCorCtVenthightCorrect(String corCtVenthightCorrect) {
		this.corCtVenthightCorrect = corCtVenthightCorrect;
	}
	public String getCorCtVenthightGross() {
		return corCtVenthightGross;
	}
	public void setCorCtVenthightGross(String corCtVenthightGross) {
		this.corCtVenthightGross = corCtVenthightGross;
	}
	public Map<String, String> getCorCtPktposMap() {
		return corCtPktposMap;
	}
	public void setCorCtPktposMap(Map<String, String> corCtPktposMap) {
		this.corCtPktposMap = corCtPktposMap;
	}
	public String getCorCtPktposSize() {
		return corCtPktposSize;
	}
	public void setCorCtPktposSize(String corCtPktposSize) {
		this.corCtPktposSize = corCtPktposSize;
	}
	public String getCorCtPktposCorrect() {
		return corCtPktposCorrect;
	}
	public void setCorCtPktposCorrect(String corCtPktposCorrect) {
		this.corCtPktposCorrect = corCtPktposCorrect;
	}
	public String getCorCtPktposGross() {
		return corCtPktposGross;
	}
	public void setCorCtPktposGross(String corCtPktposGross) {
		this.corCtPktposGross = corCtPktposGross;
	}
	public String getCorCtStoreCorrectionMemo() {
		return corCtStoreCorrectionMemo;
	}
	public void setCorCtStoreCorrectionMemo(String corCtStoreCorrectionMemo) {
		this.corCtStoreCorrectionMemo = corCtStoreCorrectionMemo;
	}

}
