package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Shop implements Serializable{

	private static final long serialVersionUID = -2776174161902796760L;
	private String shopCode;
	private String shopName;
	private String storeBrandCode;
	private Short version;
	private String createdUserId;
	private String updatedUserId;
	private Date createdAt;
	private Date updatedAt;
	private String optionType;
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}
	public String getStoreBrandCode() {
		return storeBrandCode;
	}
	public void setStoreBrandCode(String storeBrandCode) {
		this.storeBrandCode = storeBrandCode;
	}
	public String getUpdatedUserId() {
		return updatedUserId;
	}
	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public Short getVersion() {
		return version;
	}
	public void setVersion(Short version) {
		this.version = version;
	}
	
}
