package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;
import java.util.Date;

public class CoMeasuringInfo implements Serializable {

	private static final long serialVersionUID = 1955728351343722331L;

	// 注文ID
	private String orderId;

	// フルレングス
	private String fullLength;

	// ショルダー
	private String shoulder;

	// リーチ（右）
	private String reachRight;

	// リーチ（左）
	private String reachLeft;

	// アウトバスト
	private String outBust;

	// バスト
	private String bust;

	// JKウエスト
	private String jacketWaist;

	// PTウエスト
	private String pantsWaist;

	// ヒップ
	private String hip;

	// ワタリ（右）
	private String spanRight;

	// ワタリ（左）
	private String spanLeft;

	// ふくらはぎ（右）
	private String calfRight;

	// ふくらはぎ（左）
	private String calfLeft;

	// ネック
	private String neck;

	//登録者
	private String createdUserId;

    //登録日時
	private Date createdAt;

    //最終更新者
	private String updatedUserId;

	//最終更新日時
	private Date updatedAt;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getFullLength() {
		return fullLength;
	}

	public void setFullLength(String fullLength) {
		this.fullLength = fullLength;
	}

	public String getShoulder() {
		return shoulder;
	}

	public void setShoulder(String shoulder) {
		this.shoulder = shoulder;
	}

	public String getReachRight() {
		return reachRight;
	}

	public void setReachRight(String reachRight) {
		this.reachRight = reachRight;
	}

	public String getReachLeft() {
		return reachLeft;
	}

	public void setReachLeft(String reachLeft) {
		this.reachLeft = reachLeft;
	}

	public String getOutBust() {
		return outBust;
	}

	public void setOutBust(String outBust) {
		this.outBust = outBust;
	}

	public String getBust() {
		return bust;
	}

	public void setBust(String bust) {
		this.bust = bust;
	}

	public String getJacketWaist() {
		return jacketWaist;
	}

	public void setJacketWaist(String jacketWaist) {
		this.jacketWaist = jacketWaist;
	}

	public String getPantsWaist() {
		return pantsWaist;
	}

	public void setPantsWaist(String pantsWaist) {
		this.pantsWaist = pantsWaist;
	}

	public String getHip() {
		return hip;
	}

	public void setHip(String hip) {
		this.hip = hip;
	}

	public String getSpanRight() {
		return spanRight;
	}

	public void setSpanRight(String spanRight) {
		this.spanRight = spanRight;
	}

	public String getSpanLeft() {
		return spanLeft;
	}

	public void setSpanLeft(String spanLeft) {
		this.spanLeft = spanLeft;
	}

	public String getCalfRight() {
		return calfRight;
	}

	public void setCalfRight(String calfRight) {
		this.calfRight = calfRight;
	}

	public String getCalfLeft() {
		return calfLeft;
	}

	public void setCalfLeft(String calfLeft) {
		this.calfLeft = calfLeft;
	}

	public String getNeck() {
		return neck;
	}

	public void setNeck(String neck) {
		this.neck = neck;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
