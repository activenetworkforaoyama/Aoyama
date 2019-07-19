package co.jp.aoyama.macchinetta.app.shop;

import java.io.Serializable;
import java.util.Date;

public class ShopForm implements Serializable{

	private static final long serialVersionUID = 1011533287100444103L;
	
	private String shopCode;
	private String shopName;
	private String storeBrandCode;
	private String version;
	private String createdUserId;
	private String updatedUserId;
	private Date createdAt;
	private Date updatedAt;
	private Boolean delType;
	private String optionType;
	private String num;
    private String updateFlag;
    private String isNewData;
    
    private Boolean displayIdentify;

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
	public Boolean getDelType() {
		return delType;
	}
	public void setDelType(Boolean delType) {
		this.delType = delType;
	}
	public String getStoreBrandCode() {
		return storeBrandCode;
	}
	public void setStoreBrandCode(String storeBrandCode) {
		this.storeBrandCode = storeBrandCode;
	}
	public String getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getIsNewData() {
		return isNewData;
	}
	public void setIsNewData(String isNewData) {
		this.isNewData = isNewData;
	}
	public String getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}
	public Boolean getDisplayIdentify() {
		return displayIdentify;
	}
	public void setDisplayIdentify(Boolean displayIdentify) {
		this.displayIdentify = displayIdentify;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}
