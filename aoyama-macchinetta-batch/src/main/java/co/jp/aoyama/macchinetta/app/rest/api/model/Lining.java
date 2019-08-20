package co.jp.aoyama.macchinetta.app.rest.api.model;

import java.io.Serializable;

public class Lining implements Serializable {

	
	private static final long serialVersionUID = -7972391410178227134L;
	private String sku;
	private String mode;
	private String Vendor;
	private String Description;
	private String Composition;
	private String Length;
	
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getVendor() {
		return Vendor;
	}
	public void setVendor(String vendor) {
		Vendor = vendor;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getComposition() {
		return Composition;
	}
	public void setComposition(String composition) {
		Composition = composition;
	}
	public String getLength() {
		return Length;
	}
	public void setLength(String length) {
		Length = length;
	}
}
