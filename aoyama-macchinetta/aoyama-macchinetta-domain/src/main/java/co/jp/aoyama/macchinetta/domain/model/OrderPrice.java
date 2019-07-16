package co.jp.aoyama.macchinetta.domain.model;

public class OrderPrice {
	private String branchItemCode;
	private String branchModelCode;
	private String branchOptionCode;
	private String optinBranchCode;
	private Integer optionBranchPrice;
	private Integer optionBranchDoublePrice;
	private String detailItemCode;
	private String detailOptionCode;
	private String detailOptionBranchCode;
	private String optionBranchDetailCode;
	private Integer detailBranchPrice;
	private Integer detailBranchDoublePrice;
	public String getBranchItemCode() {
		return branchItemCode;
	}
	public void setBranchItemCode(String branchItemCode) {
		this.branchItemCode = branchItemCode;
	}
	public String getBranchModelCode() {
		return branchModelCode;
	}
	public void setBranchModelCode(String branchModelCode) {
		this.branchModelCode = branchModelCode;
	}
	public String getBranchOptionCode() {
		return branchOptionCode;
	}
	public void setBranchOptionCode(String branchOptionCode) {
		this.branchOptionCode = branchOptionCode;
	}
	public String getOptinBranchCode() {
		return optinBranchCode;
	}
	public void setOptinBranchCode(String optinBranchCode) {
		this.optinBranchCode = optinBranchCode;
	}
	public Integer getOptionBranchDoublePrice() {
		return optionBranchDoublePrice;
	}
	public void setOptionBranchDoublePrice(Integer optionBranchDoublePrice) {
		this.optionBranchDoublePrice = optionBranchDoublePrice;
	}
	public String getDetailItemCode() {
		return detailItemCode;
	}
	public void setDetailItemCode(String detailItemCode) {
		this.detailItemCode = detailItemCode;
	}
	public String getDetailOptionCode() {
		return detailOptionCode;
	}
	public void setDetailOptionCode(String detailOptionCode) {
		this.detailOptionCode = detailOptionCode;
	}
	public String getDetailOptionBranchCode() {
		return detailOptionBranchCode;
	}
	public void setDetailOptionBranchCode(String detailOptionBranchCode) {
		this.detailOptionBranchCode = detailOptionBranchCode;
	}
	public String getOptionBranchDetailCode() {
		return optionBranchDetailCode;
	}
	public void setOptionBranchDetailCode(String optionBranchDetailCode) {
		this.optionBranchDetailCode = optionBranchDetailCode;
	}
	public Integer getDetailBranchPrice() {
		return detailBranchPrice;
	}
	public void setDetailBranchPrice(Integer detailBranchPrice) {
		this.detailBranchPrice = detailBranchPrice;
	}
	public Integer getDetailBranchDoublePrice() {
		return detailBranchDoublePrice;
	}
	public void setDetailBranchDoublePrice(Integer detailBranchDoublePrice) {
		this.detailBranchDoublePrice = detailBranchDoublePrice;
	}
	public Integer getOptionBranchPrice() {
		return optionBranchPrice;
	}
	public void setOptionBranchPrice(Integer optionBranchPrice) {
		this.optionBranchPrice = optionBranchPrice;
	}
	
}
