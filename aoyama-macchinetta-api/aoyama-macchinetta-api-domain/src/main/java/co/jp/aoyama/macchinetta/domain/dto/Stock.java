package co.jp.aoyama.macchinetta.domain.dto;

import java.math.BigDecimal;

public class Stock {

	private String ftno;
	private String ftcode;
	private BigDecimal order_stock;
	private BigDecimal factory_stock;
	private String material_status;

	public String getFtno() {
		return ftno;
	}

	public void setFtno(String ftno) {
		this.ftno = ftno;
	}

	public String getFtcode() {
		return ftcode;
	}

	public void setFtcode(String ftcode) {
		this.ftcode = ftcode;
	}

	public BigDecimal getOrder_stock() {
		return order_stock;
	}

	public void setOrder_stock(BigDecimal order_stock) {
		this.order_stock = order_stock;
	}

	public BigDecimal getFactory_stock() {
		return factory_stock;
	}

	public void setFactory_stock(BigDecimal factory_stock) {
		this.factory_stock = factory_stock;
	}

	public String getMaterial_status() {
		return material_status;
	}

	public void setMaterial_status(String material_status) {
		this.material_status = material_status;
	}

	@Override
	public String toString() {
		return "Stock [ftno=" + ftno + ", ftcode=" + ftcode + ", order_stock=" + order_stock + ", factory_stock="
				+ factory_stock + ", material_status=" + material_status + "]";
	}

}
