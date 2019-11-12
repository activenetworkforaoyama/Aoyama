package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.CoatAdItem;

public class CoAdjustCoatStandardInfo implements Serializable {
	private static final long serialVersionUID = -8877129976059721540L;
	// COATサイズ
	private Map<String, String> corCtSizeMap;
	@NotBlank(groups = {CoatAdItem.class}, message = "COATのサイズを入力して下さい。")
	private String corCtSize;
	// 着丈修正
	private Map<String, String> corCtBodylengthMap;
	// 着丈型サイズ
	@NotBlank(groups = {CoatAdItem.class}, message = "COATの着丈型サイズが不正です。")
	@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATの着丈型サイズの範囲が不正です。")
	private String corCtBodylengthSize;
	// 着丈補正値
	@NotBlank(groups = {CoatAdItem.class}, message = "COATの着丈補正値を入力して下さい。")
	private String corCtBodylengthCorrect;
	// 着丈グロス
	@NotBlank(groups = {CoatAdItem.class}, message = "COATの着丈グロスが不正です。")
	@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATの着丈グロスの範囲が不正です。")
	private String corCtBodylengthGross;

	// ウエスト修正
	private Map<String, String> corCtWaistMap;
	// ウエスト型サイズ
	@NotBlank(groups = {CoatAdItem.class}, message = "COATのウエスト型サイズが不正です。")
	@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATのウエスト型サイズの範囲が不正です。")
	private String corCtWaistSize;
	// ウエスト補正値
	@NotBlank(groups = {CoatAdItem.class}, message = "COATのウエスト補正値を入力して下さい。")
	private String corCtWaistCorrect;
	// ウエストグロス
	@NotBlank(groups = {CoatAdItem.class}, message = "COATのウエストグロスが不正です。")
	@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATのウエストグロスの範囲が不正です。")
	private String corCtWaistGross;

	// 袖丈右修正
	private Map<String, String> corCtRightsleeveMap;
	// 袖丈右型サイズ
	@NotBlank(groups = {CoatAdItem.class}, message = "COATの袖丈右型サイズが不正です。")
	@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATの袖丈右型サイズの範囲が不正です。")
	private String corCtRightsleeveSize;
	// 袖丈右補正値
	@NotBlank(groups = {CoatAdItem.class}, message = "COATの袖丈右補正値を入力して下さい。")
	private String corCtRightsleeveCorrect;
	// 袖丈右グロス
	@NotBlank(groups = {CoatAdItem.class}, message = "COATの袖丈右グロスが不正です。")
	@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATの袖丈右グロスの範囲が不正です。")
	private String corCtRightsleeveGross;

	// 袖丈左修正
	private Map<String, String> corCtLeftsleeveMap;
	// 袖丈左型サイズ
	@NotBlank(groups = {CoatAdItem.class}, message = "COATの袖丈左型サイズが不正です。")
	@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATの袖丈左型サイズの範囲が不正です。")
	private String corCtLeftsleeveSize;
	// 袖丈左補正値
	@NotBlank(groups = {CoatAdItem.class}, message = "COATの袖丈左補正値を入力して下さい。")
	private String corCtLeftsleeveCorrect;
	// 袖丈左グロス
	@NotBlank(groups = {CoatAdItem.class}, message = "COATの袖丈左グロスが不正です。")
	@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATの袖丈左グロスの範囲が不正です。")
	private String corCtLeftsleeveGross;

	// ベント修正（高さ）
	private Map<String, String> corCtVenthightMap;

	// ベント修正（高さ）型サイズ
	//@NotBlank(groups = {CoatAdItem.class}, message = "COATのベント修正（高さ）型サイズが不正です。")
	//@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATのベント修正（高さ）型サイズの範囲が不正です。")
	private String corCtVenthightSize;
	// ベント修正（高さ）補正値
	//@NotBlank(groups = {CoatAdItem.class}, message = "COATのベント修正（高さ）補正値を入力して下さい。")
	private String corCtVenthightCorrect;
	// ベント修正（高さ）グロス
	//@NotBlank(groups = {CoatAdItem.class}, message = "COATのベント修正（高さ）グロスが不正です。")
	//@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATのベント修正（高さ）グロスの範囲が不正です。")
	private String corCtVenthightGross;

	// ポケット位置
	private Map<String, String> corCtPktposMap;
	// ポケット位置型サイズ
	//@NotBlank(groups = {CoatAdItem.class}, message = "COATのポケット位置型サイズが不正です。")
	//@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATのポケット位置型サイズの範囲が不正です。")
	private String corCtPktposSize;
	// ポケット位置補正値
	//@NotBlank(groups = {CoatAdItem.class}, message = "COATのポケット位置補正値を入力して下さい。")
	private String corCtPktposCorrect;
	// ポケット位置グロス
	//@NotBlank(groups = {CoatAdItem.class}, message = "COATのポケット位置グロスが不正です。")
	//@Range(min=1, max=999, groups = {CoatAdItem.class}, message = "COATのポケット位置グロスの範囲が不正です。")
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
