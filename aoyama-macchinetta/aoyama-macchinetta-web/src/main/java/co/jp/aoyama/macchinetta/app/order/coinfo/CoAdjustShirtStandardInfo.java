package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.ShirtAdItem;
import co.jp.aoyama.macchinetta.app.order.OrderCoForm.ShirtBodylengthAdItem;

public class CoAdjustShirtStandardInfo implements Serializable {
	
	private static final long serialVersionUID = -211706423019474210L;
		// SHIRTサイズ
		private Map<String, String> corStSizeMap;
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのサイズを入力して下さい。")
		private String corStSize;
		// ネック
		private Map<String, String> corStNeckMap;
		// ネック型サイズ
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのネック型サイズが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTのネック型サイズの範囲が不正です。")
		private String corStNeckSize;
		// ネック補正値
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのネック補正値を入力して下さい。")
		private String corStNeckCorrect;
		// ネックグロス
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのネックグロスが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTのネックグロスの範囲が不正です。")
		private String corStNeckGross;

		// 着丈修正
		private Map<String, String> corStBodylengthMap;
		// 着丈型サイズ
		@NotBlank(groups = {ShirtBodylengthAdItem.class}, message = "SHIRTの着丈型サイズが不正です。")
		@Range(min=1, max=999, groups = {ShirtBodylengthAdItem.class}, message = "SHIRTの着丈型サイズの範囲が不正です。")
		private String corStBodylengthSize;
		// 着丈補正値
		@NotBlank(groups = {ShirtBodylengthAdItem.class}, message = "SHIRTの着丈補正値を入力して下さい。")
		private String corStBodylengthCorrect;
		// 着丈グロス
		@NotBlank(groups = {ShirtBodylengthAdItem.class}, message = "SHIRTの着丈グロスが不正です。")
		@Range(min=1, max=999, groups = {ShirtBodylengthAdItem.class}, message = "SHIRTの着丈グロスの範囲が不正です。")
		private String corStBodylengthGross;

		// 袖丈右修正
		private Map<String, String> corStRightsleeveMap;
		// 袖丈右型サイズ
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTの袖丈右型サイズが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTの袖丈右型サイズの範囲が不正です。")
		private String corStRightsleeveSize;
		// 袖丈右補正値
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTの袖丈右補正値を入力して下さい。")
		private String corStRightsleeveCorrect;
		// 袖丈右グロス
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTの袖丈右グロスが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTの袖丈右グロスの範囲が不正です。")
		private String corStRightsleeveGross;

		// 袖丈左修正
		private Map<String, String> corStLeftsleeveMap;
		// 袖丈左型サイズ
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTの袖丈左型サイズが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTの袖丈左型サイズの範囲が不正です。")
		private String corStLeftsleeveSize;
	    //袖丈左補正値
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTの袖丈左補正値を入力して下さい。")
		private String corStLeftsleeveCorrect;
	    //袖丈左グロス
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTの袖丈左グロスが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTの袖丈左グロスの範囲が不正です。")
		private String corStLeftsleeveGross;

		// 背ダーツ詰め
		private Map<String, String> corStBackdartsPackMap;
		// 背ダーツ詰め型サイズ
		private String corStBackdartsPackSize;
	    //背ダーツ詰め補正値
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTの背ダーツ詰め補正値を入力して下さい。")
		private String corStBackdartsPackCorrect;
	    //背ダーツ詰めグロス
		private String corStBackdartsPackGross;

		// 背ダーツ出し
		private Map<String, String> corStBackdartsUnpackMap;
		// 背ダーツ出し型サイズ
		private String corStBackdartsUnpackSize;
	    //背ダーツ出し補正値
		private String corStBackdartsUnpackCorrect;
	    //背ダーツ出しグロス
		private String corStBackdartsUnpackGross;

		// カフス周り右
		private Map<String, String> corStRightcuffsSurroundingMap;
		// カフス周り右型サイズ
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り右型サイズが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り右型サイズの範囲が不正です。")
		private String corStRightcuffsSurroundingSize;
	    //カフス周り右補正値
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り右補正値を入力して下さい。")
		private String corStRightcuffsSurroundingCorrect;
	    //カフス周り右グロス
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り右グロスが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り右グロスの範囲が不正です。")
		private String corStRightcuffsSurroundingGross;

		// カフス周り左
		private Map<String, String> corStLeftcuffsSurroundingMap;
		// カフス周り左型サイズ
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り左型サイズが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り左型サイズの範囲が不正です。")
		private String corStLeftcuffsSurroundingSize;
	    //カフス周り左補正値
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り左補正値を入力して下さい。")
		private String corStLeftcuffsSurroundingCorrect;
	    //カフス周り左グロス
		@NotBlank(groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り左グロスが不正です。")
		@Range(min=1, max=999, groups = {ShirtAdItem.class}, message = "SHIRTのカフス周り左グロスの範囲が不正です。")
		private String corStLeftcuffsSurroundingGross;
		// 店舗補正入力欄
		private String corStoreCorrectionMemo;
		
		//刺繍サイズ  縦
		private String embroideryHeightSize;
		
		private String embroideryHeightCorrect;
		
		private String embroideryHeightGross;
		
		//刺繍サイズ  横
		private String embroideryWidthSize;
		
		private String embroideryWidthCorrect;
		
		private String embroideryWidthGross;
		
		private String corStBackdartsUnpackCd;
		    
		private String corStBackdartsUnpackNm;
				
		
		public String getCorStBackdartsUnpackCd() {
			return corStBackdartsUnpackCd;
		}
		public void setCorStBackdartsUnpackCd(String corStBackdartsUnpackCd) {
			this.corStBackdartsUnpackCd = corStBackdartsUnpackCd;
		}
		public String getCorStBackdartsUnpackNm() {
			return corStBackdartsUnpackNm;
		}
		public void setCorStBackdartsUnpackNm(String corStBackdartsUnpackNm) {
			this.corStBackdartsUnpackNm = corStBackdartsUnpackNm;
		}
		public String getEmbroideryHeightSize() {
			return embroideryHeightSize;
		}
		public void setEmbroideryHeightSize(String embroideryHeightSize) {
			this.embroideryHeightSize = embroideryHeightSize;
		}
		public String getEmbroideryHeightCorrect() {
			return embroideryHeightCorrect;
		}
		public void setEmbroideryHeightCorrect(String embroideryHeightCorrect) {
			this.embroideryHeightCorrect = embroideryHeightCorrect;
		}
		public String getEmbroideryHeightGross() {
			return embroideryHeightGross;
		}
		public void setEmbroideryHeightGross(String embroideryHeightGross) {
			this.embroideryHeightGross = embroideryHeightGross;
		}
		public String getEmbroideryWidthSize() {
			return embroideryWidthSize;
		}
		public void setEmbroideryWidthSize(String embroideryWidthSize) {
			this.embroideryWidthSize = embroideryWidthSize;
		}
		public String getEmbroideryWidthCorrect() {
			return embroideryWidthCorrect;
		}
		public void setEmbroideryWidthCorrect(String embroideryWidthCorrect) {
			this.embroideryWidthCorrect = embroideryWidthCorrect;
		}
		public String getEmbroideryWidthGross() {
			return embroideryWidthGross;
		}
		public void setEmbroideryWidthGross(String embroideryWidthGross) {
			this.embroideryWidthGross = embroideryWidthGross;
		}
		public Map<String, String> getCorStSizeMap() {
			return corStSizeMap;
		}
		public void setCorStSizeMap(Map<String, String> corStSizeMap) {
			this.corStSizeMap = corStSizeMap;
		}
		public String getCorStSize() {
			return corStSize;
		}
		public void setCorStSize(String corStSize) {
			this.corStSize = corStSize;
		}
		public Map<String, String> getCorStNeckMap() {
			return corStNeckMap;
		}
		public void setCorStNeckMap(Map<String, String> corStNeckMap) {
			this.corStNeckMap = corStNeckMap;
		}
		public String getCorStNeckSize() {
			return corStNeckSize;
		}
		public void setCorStNeckSize(String corStNeckSize) {
			this.corStNeckSize = corStNeckSize;
		}
		public String getCorStNeckCorrect() {
			return corStNeckCorrect;
		}
		public void setCorStNeckCorrect(String corStNeckCorrect) {
			this.corStNeckCorrect = corStNeckCorrect;
		}
		public String getCorStNeckGross() {
			return corStNeckGross;
		}
		public void setCorStNeckGross(String corStNeckGross) {
			this.corStNeckGross = corStNeckGross;
		}
		public Map<String, String> getCorStBodylengthMap() {
			return corStBodylengthMap;
		}
		public void setCorStBodylengthMap(Map<String, String> corStBodylengthMap) {
			this.corStBodylengthMap = corStBodylengthMap;
		}
		public String getCorStBodylengthSize() {
			return corStBodylengthSize;
		}
		public void setCorStBodylengthSize(String corStBodylengthSize) {
			this.corStBodylengthSize = corStBodylengthSize;
		}
		public String getCorStBodylengthCorrect() {
			return corStBodylengthCorrect;
		}
		public void setCorStBodylengthCorrect(String corStBodylengthCorrect) {
			this.corStBodylengthCorrect = corStBodylengthCorrect;
		}
		public String getCorStBodylengthGross() {
			return corStBodylengthGross;
		}
		public void setCorStBodylengthGross(String corStBodylengthGross) {
			this.corStBodylengthGross = corStBodylengthGross;
		}
		public Map<String, String> getCorStRightsleeveMap() {
			return corStRightsleeveMap;
		}
		public void setCorStRightsleeveMap(Map<String, String> corStRightsleeveMap) {
			this.corStRightsleeveMap = corStRightsleeveMap;
		}
		public String getCorStRightsleeveSize() {
			return corStRightsleeveSize;
		}
		public void setCorStRightsleeveSize(String corStRightsleeveSize) {
			this.corStRightsleeveSize = corStRightsleeveSize;
		}
		public String getCorStRightsleeveCorrect() {
			return corStRightsleeveCorrect;
		}
		public void setCorStRightsleeveCorrect(String corStRightsleeveCorrect) {
			this.corStRightsleeveCorrect = corStRightsleeveCorrect;
		}
		public String getCorStRightsleeveGross() {
			return corStRightsleeveGross;
		}
		public void setCorStRightsleeveGross(String corStRightsleeveGross) {
			this.corStRightsleeveGross = corStRightsleeveGross;
		}
		public Map<String, String> getCorStLeftsleeveMap() {
			return corStLeftsleeveMap;
		}
		public void setCorStLeftsleeveMap(Map<String, String> corStLeftsleeveMap) {
			this.corStLeftsleeveMap = corStLeftsleeveMap;
		}
		public String getCorStLeftsleeveSize() {
			return corStLeftsleeveSize;
		}
		public void setCorStLeftsleeveSize(String corStLeftsleeveSize) {
			this.corStLeftsleeveSize = corStLeftsleeveSize;
		}
		public String getCorStLeftsleeveCorrect() {
			return corStLeftsleeveCorrect;
		}
		public void setCorStLeftsleeveCorrect(String corStLeftsleeveCorrect) {
			this.corStLeftsleeveCorrect = corStLeftsleeveCorrect;
		}
		public String getCorStLeftsleeveGross() {
			return corStLeftsleeveGross;
		}
		public void setCorStLeftsleeveGross(String corStLeftsleeveGross) {
			this.corStLeftsleeveGross = corStLeftsleeveGross;
		}
		public Map<String, String> getCorStBackdartsPackMap() {
			return corStBackdartsPackMap;
		}
		public void setCorStBackdartsPackMap(Map<String, String> corStBackdartsPackMap) {
			this.corStBackdartsPackMap = corStBackdartsPackMap;
		}
		public String getCorStBackdartsPackSize() {
			return corStBackdartsPackSize;
		}
		public void setCorStBackdartsPackSize(String corStBackdartsPackSize) {
			this.corStBackdartsPackSize = corStBackdartsPackSize;
		}
		public String getCorStBackdartsPackCorrect() {
			return corStBackdartsPackCorrect;
		}
		public void setCorStBackdartsPackCorrect(String corStBackdartsPackCorrect) {
			this.corStBackdartsPackCorrect = corStBackdartsPackCorrect;
		}
		public String getCorStBackdartsPackGross() {
			return corStBackdartsPackGross;
		}
		public void setCorStBackdartsPackGross(String corStBackdartsPackGross) {
			this.corStBackdartsPackGross = corStBackdartsPackGross;
		}
		public Map<String, String> getCorStBackdartsUnpackMap() {
			return corStBackdartsUnpackMap;
		}
		public void setCorStBackdartsUnpackMap(Map<String, String> corStBackdartsUnpackMap) {
			this.corStBackdartsUnpackMap = corStBackdartsUnpackMap;
		}
		public String getCorStBackdartsUnpackSize() {
			return corStBackdartsUnpackSize;
		}
		public void setCorStBackdartsUnpackSize(String corStBackdartsUnpackSize) {
			this.corStBackdartsUnpackSize = corStBackdartsUnpackSize;
		}
		public String getCorStBackdartsUnpackCorrect() {
			return corStBackdartsUnpackCorrect;
		}
		public void setCorStBackdartsUnpackCorrect(String corStBackdartsUnpackCorrect) {
			this.corStBackdartsUnpackCorrect = corStBackdartsUnpackCorrect;
		}
		public String getCorStBackdartsUnpackGross() {
			return corStBackdartsUnpackGross;
		}
		public void setCorStBackdartsUnpackGross(String corStBackdartsUnpackGross) {
			this.corStBackdartsUnpackGross = corStBackdartsUnpackGross;
		}
		public Map<String, String> getCorStRightcuffsSurroundingMap() {
			return corStRightcuffsSurroundingMap;
		}
		public void setCorStRightcuffsSurroundingMap(Map<String, String> corStRightcuffsSurroundingMap) {
			this.corStRightcuffsSurroundingMap = corStRightcuffsSurroundingMap;
		}
		public String getCorStRightcuffsSurroundingSize() {
			return corStRightcuffsSurroundingSize;
		}
		public void setCorStRightcuffsSurroundingSize(String corStRightcuffsSurroundingSize) {
			this.corStRightcuffsSurroundingSize = corStRightcuffsSurroundingSize;
		}
		public String getCorStRightcuffsSurroundingCorrect() {
			return corStRightcuffsSurroundingCorrect;
		}
		public void setCorStRightcuffsSurroundingCorrect(String corStRightcuffsSurroundingCorrect) {
			this.corStRightcuffsSurroundingCorrect = corStRightcuffsSurroundingCorrect;
		}
		public String getCorStRightcuffsSurroundingGross() {
			return corStRightcuffsSurroundingGross;
		}
		public void setCorStRightcuffsSurroundingGross(String corStRightcuffsSurroundingGross) {
			this.corStRightcuffsSurroundingGross = corStRightcuffsSurroundingGross;
		}
		public Map<String, String> getCorStLeftcuffsSurroundingMap() {
			return corStLeftcuffsSurroundingMap;
		}
		public void setCorStLeftcuffsSurroundingMap(Map<String, String> corStLeftcuffsSurroundingMap) {
			this.corStLeftcuffsSurroundingMap = corStLeftcuffsSurroundingMap;
		}
		public String getCorStLeftcuffsSurroundingSize() {
			return corStLeftcuffsSurroundingSize;
		}
		public void setCorStLeftcuffsSurroundingSize(String corStLeftcuffsSurroundingSize) {
			this.corStLeftcuffsSurroundingSize = corStLeftcuffsSurroundingSize;
		}
		public String getCorStLeftcuffsSurroundingCorrect() {
			return corStLeftcuffsSurroundingCorrect;
		}
		public void setCorStLeftcuffsSurroundingCorrect(String corStLeftcuffsSurroundingCorrect) {
			this.corStLeftcuffsSurroundingCorrect = corStLeftcuffsSurroundingCorrect;
		}
		public String getCorStLeftcuffsSurroundingGross() {
			return corStLeftcuffsSurroundingGross;
		}
		public void setCorStLeftcuffsSurroundingGross(String corStLeftcuffsSurroundingGross) {
			this.corStLeftcuffsSurroundingGross = corStLeftcuffsSurroundingGross;
		}
		public String getCorStoreCorrectionMemo() {
			return corStoreCorrectionMemo;
		}
		public void setCorStoreCorrectionMemo(String corStoreCorrectionMemo) {
			this.corStoreCorrectionMemo = corStoreCorrectionMemo;
		}
}
