package co.jp.aoyama.macchinetta.app.order;

import java.io.Serializable;

public class TypeSizeForm implements Serializable{

	private static final long serialVersionUID = 3617757855160376262L;
	
	private String key;
	private String value;
	private String inTack1Value;
	private String inTack2Value;
	private String outTack1Value;
	private String outTack2Value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getInTack1Value() {
		return inTack1Value;
	}
	public void setInTack1Value(String inTack1Value) {
		this.inTack1Value = inTack1Value;
	}
	public String getInTack2Value() {
		return inTack2Value;
	}
	public void setInTack2Value(String inTack2Value) {
		this.inTack2Value = inTack2Value;
	}
	public String getOutTack1Value() {
		return outTack1Value;
	}
	public void setOutTack1Value(String outTack1Value) {
		this.outTack1Value = outTack1Value;
	}
	public String getOutTack2Value() {
		return outTack2Value;
	}
	public void setOutTack2Value(String outTack2Value) {
		this.outTack2Value = outTack2Value;
	}
	
}
