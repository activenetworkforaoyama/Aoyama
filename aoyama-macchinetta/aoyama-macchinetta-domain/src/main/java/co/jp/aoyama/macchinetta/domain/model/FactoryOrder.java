package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangyingrui
 *
 */
public class FactoryOrder implements Serializable {

	private static final long serialVersionUID = 4170765039218552949L;

	private String orderId;

	private String productItem;
	
	private String productItemDisplaycode;

	private String productFabricNo;
	
	private String  fabricColor;
	
	private String  fabricPattern;

	private String tscStatus;

	private String productOrderdDate;

	private String custShopDeliveryDate;

	private String updatedAt;
	
	private String send2factoryStatus;
	
	private String makerFactoryStatus;
	
	private String printStatus;

	// 印刷準備中
	private boolean printReadyStatus;

	// 印刷準備済
	private boolean printReadyOk;

	// 再印刷
	private boolean rePrint;

	private List<Order> orderList;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTscStatus() {
		return tscStatus;
	}

	public void setTscStatus(String tscStatus) {
		this.tscStatus = tscStatus;
	}

	public String getProductItem() {
		return productItem;
	}

	public void setProductItem(String productItem) {
		this.productItem = productItem;
	}

	public String getProductFabricNo() {
		return productFabricNo;
	}

	public void setProductFabricNo(String productFabricNo) {
		this.productFabricNo = productFabricNo;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean getPrintReadyStatus() {
		return printReadyStatus;
	}

	public void setPrintReadyStatus(boolean printReadyStatus) {
		this.printReadyStatus = printReadyStatus;
	}

	public boolean getPrintReadyOk() {
		return printReadyOk;
	}

	public void setPrintReadyOk(boolean printReadyOk) {
		this.printReadyOk = printReadyOk;
	}

	public boolean getRePrint() {
		return rePrint;
	}

	public void setRePrint(boolean rePrint) {
		this.rePrint = rePrint;
	}

	public String getProductOrderdDate() {
		return productOrderdDate;
	}

	public void setProductOrderdDate(String productOrderdDate) {
		this.productOrderdDate = productOrderdDate;
	}

	public String getCustShopDeliveryDate() {
		return custShopDeliveryDate;
	}

	public void setCustShopDeliveryDate(String custShopDeliveryDate) {
		this.custShopDeliveryDate = custShopDeliveryDate;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

	public String getFabricColor() {
		return fabricColor;
	}

	public void setFabricColor(String fabricColor) {
		this.fabricColor = fabricColor;
	}

	public String getFabricPattern() {
		return fabricPattern;
	}

	public void setFabricPattern(String fabricPattern) {
		this.fabricPattern = fabricPattern;
	}

	public String getSend2factoryStatus() {
		return send2factoryStatus;
	}

	public void setSend2factoryStatus(String send2factoryStatus) {
		this.send2factoryStatus = send2factoryStatus;
	}

	public String getMakerFactoryStatus() {
		return makerFactoryStatus;
	}

	public void setMakerFactoryStatus(String makerFactoryStatus) {
		this.makerFactoryStatus = makerFactoryStatus;
	}

	public String getProductItemDisplaycode() {
		return productItemDisplaycode;
	}

	public void setProductItemDisplaycode(String productItemDisplaycode) {
		this.productItemDisplaycode = productItemDisplaycode;
	}

}