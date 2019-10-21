package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.io.Serializable;

import javax.validation.groups.Default;

import org.hibernate.validator.constraints.NotBlank;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm.ShippingDestinationItem;

public class CoCustomerMessageInfo implements Serializable{
	
	private static final long serialVersionUID = 424631093056161171L;

	//注文ID
	private String orderId;
	
	//会員番号
	@NotBlank(groups = {Default.class},message = "会員番号を入力して下さい。")
	private String custCd;
	
	//お客様氏名
	private String custNm;
	
	//お客様情報_フリガナ
	private String custKanaNm;
	
	//名簿納期
	@NotBlank(groups = {Default.class},message = "名簿納期を入力して下さい。")
	private String custDeliverDate;
	
//	//納期短縮
//	private String custIsDeliverShortning;
//	
//	//早割
//	private String custIsEarlyDiscount;
	
	//お渡し日
	@NotBlank(groups = {Default.class},message = "お渡し日を入力して下さい。")
	private String custShopDeliveryDate;
	
	//スタッフ
	@NotBlank(groups = {Default.class},message = "スタッフを入力して下さい。")
	private String custStaff;
	
	//区分
	@NotBlank(groups = {Default.class},message = "区分を入力して下さい。")
	private String custType;
	
	//出荷先
	@NotBlank(groups = {Default.class},message = "出荷先を入力して下さい。")
	private String custShippingDestination;
	
	//出荷先_他店舗コード
	@NotBlank(groups = {ShippingDestinationItem.class},message = "出荷先他店舗コードを入力して下さい。")
	private String custShippingDestnationOtherstore;
	
	//お客様備考
	private String custRemark;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getCustKanaNm() {
		return custKanaNm;
	}

	public void setCustKanaNm(String custKanaNm) {
		this.custKanaNm = custKanaNm;
	}

	public String getCustStaff() {
		return custStaff;
	}

	public void setCustStaff(String custStaff) {
		this.custStaff = custStaff;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustShippingDestination() {
		return custShippingDestination;
	}

	public void setCustShippingDestination(String custShippingDestination) {
		this.custShippingDestination = custShippingDestination;
	}

	public String getCustShippingDestnationOtherstore() {
		return custShippingDestnationOtherstore;
	}

	public void setCustShippingDestnationOtherstore(String custShippingDestnationOtherstore) {
		this.custShippingDestnationOtherstore = custShippingDestnationOtherstore;
	}

	public String getCustRemark() {
		return custRemark;
	}

	public void setCustRemark(String custRemark) {
		this.custRemark = custRemark;
	}

	public String getCustDeliverDate() {
		return custDeliverDate;
	}

	public void setCustDeliverDate(String custDeliverDate) {
		this.custDeliverDate = custDeliverDate;
	}

	public String getCustShopDeliveryDate() {
		return custShopDeliveryDate;
	}

	public void setCustShopDeliveryDate(String custShopDeliveryDate) {
		this.custShopDeliveryDate = custShopDeliveryDate;
	}

//	public String getCustIsDeliverShortning() {
//		return custIsDeliverShortning;
//	}
//
//	public void setCustIsDeliverShortning(String custIsDeliverShortning) {
//		this.custIsDeliverShortning = custIsDeliverShortning;
//	}
//
//	public String getCustIsEarlyDiscount() {
//		return custIsEarlyDiscount;
//	}
//
//	public void setCustIsEarlyDiscount(String custIsEarlyDiscount) {
//		this.custIsEarlyDiscount = custIsEarlyDiscount;
//	}
	
}

