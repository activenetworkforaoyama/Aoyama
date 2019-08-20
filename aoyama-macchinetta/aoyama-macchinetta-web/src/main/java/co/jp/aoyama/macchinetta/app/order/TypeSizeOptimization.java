package co.jp.aoyama.macchinetta.app.order;

import java.io.Serializable;

public class TypeSizeOptimization implements Serializable{
	
	private static final long serialVersionUID = 4321859902265026398L;

	private String adjustClass;
	private String typeSize;
	private String typeSize1Intack;
	private String typeSize2Intack;
	private String typeSize1Outtack;
	private String typeSize2Outtack;
	public String getAdjustClass() {
		return adjustClass;
	}
	public void setAdjustClass(String adjustClass) {
		this.adjustClass = adjustClass;
	}
	public String getTypeSize() {
		return typeSize;
	}
	public void setTypeSize(String typeSize) {
		this.typeSize = typeSize;
	}
	public String getTypeSize1Intack() {
		return typeSize1Intack;
	}
	public void setTypeSize1Intack(String typeSize1Intack) {
		this.typeSize1Intack = typeSize1Intack;
	}
	public String getTypeSize2Intack() {
		return typeSize2Intack;
	}
	public void setTypeSize2Intack(String typeSize2Intack) {
		this.typeSize2Intack = typeSize2Intack;
	}
	public String getTypeSize1Outtack() {
		return typeSize1Outtack;
	}
	public void setTypeSize1Outtack(String typeSize1Outtack) {
		this.typeSize1Outtack = typeSize1Outtack;
	}
	public String getTypeSize2Outtack() {
		return typeSize2Outtack;
	}
	public void setTypeSize2Outtack(String typeSize2Outtack) {
		this.typeSize2Outtack = typeSize2Outtack;
	}
}
