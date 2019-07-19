package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Maker implements Serializable {

	private static final long serialVersionUID = -4177282622265810534L;

	private String makerCode;
	private String makerName;
	private String makerId;
	private Date createdAt;
	private Date updatedAt;
	private String createdUserId;
	private String updatedUserId;
	private String optionType;
	private Short version;

	public String getMakerCode() {
		return makerCode;
	}

	public void setMakerCode(String makerCode) {
		this.makerCode = makerCode;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getMakerId() {
		return makerId;
	}

	public void setMakerId(String makerId) {
		this.makerId = makerId;
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

	public Short getVersion() {
		return version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

}
