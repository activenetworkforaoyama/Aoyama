package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;

public class CoSizeNumber implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer num;
	
	private String sizeNumber;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getSizeNumber() {
		return sizeNumber;
	}

	public void setSizeNumber(String sizeNumber) {
		this.sizeNumber = sizeNumber;
	}
	
	
}
