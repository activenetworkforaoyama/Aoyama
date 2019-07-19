package co.jp.aoyama.macchinetta.app.factory;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class FactoryForm implements Serializable {

	private static final long serialVersionUID = -3870073943092462615L;

	private String factoryCode;
	private String makerCode;
	private String factoryName;
	private Date createdAt;
	private Date updatedAt;
	private String createdUserId;
	private String updatedUserId;
	private boolean delType;
	private String optionType;
	private String num;
	private String updateFlag;
    private String isNewData;
    private String version;
    
    private Boolean displayIdentify;

	public boolean getDelType() {
		return delType;
	}

	public void setDelType(boolean delType) {
		this.delType = delType;
	}

	public String getFactoryCode() {
		return factoryCode;
	}

	public void setFactoryCode(String factoryCode) {
		this.factoryCode = factoryCode;
	}

	public String getMakerCode() {
		return makerCode;
	}

	public void setMakerCode(String makerCode) {
		this.makerCode = makerCode;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
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
