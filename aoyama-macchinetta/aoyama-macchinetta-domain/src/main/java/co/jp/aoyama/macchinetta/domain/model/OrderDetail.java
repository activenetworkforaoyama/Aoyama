package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 946167814072136738L;
	
	//工場の実在庫
	private BigDecimal actualStock;
	//生地ID
	private String fabricId;

	public BigDecimal getActualStock() {
		return actualStock;
	}

	public void setActualStock(BigDecimal actualStock) {
		this.actualStock = actualStock;
	}

	public String getFabricId() {
		return fabricId;
	}

	public void setFabricId(String fabricId) {
		this.fabricId = fabricId;
	}
	
}
