package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TypeSize implements Serializable {
	private static final long serialVersionUID = 5933054916108402420L;

	private String subItemCode;

    private String modelCode;

    private String figure;

    private String sizeNumber;

    private String adjustClass;

    private String orderPattern;

    private BigDecimal typeSize;

    private BigDecimal typeSize1Intack;

    private BigDecimal typeSize2Intack;

    private BigDecimal typeSize1Outtack;

    private BigDecimal typeSize2Outtack;

    private String createdUserId;

    private Date createdAt;

    private String updatedUserId;

    private Date updatedAt;
    
    public String getOrderPattern() {
		return orderPattern;
	}

	public void setOrderPattern(String orderPattern) {
		this.orderPattern = orderPattern;
	}

	public String getSubItemCode() {
        return subItemCode;
    }

    public void setSubItemCode(String subItemCode) {
        this.subItemCode = subItemCode == null ? null : subItemCode.trim();
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure == null ? null : figure.trim();
    }

    public String getSizeNumber() {
        return sizeNumber;
    }

    public void setSizeNumber(String sizeNumber) {
        this.sizeNumber = sizeNumber == null ? null : sizeNumber.trim();
    }

    public String getAdjustClass() {
        return adjustClass;
    }

    public void setAdjustClass(String adjustClass) {
        this.adjustClass = adjustClass == null ? null : adjustClass.trim();
    }


    public BigDecimal getTypeSize() {
        return typeSize;
    }

    public void setTypeSize(BigDecimal typeSize) {
        this.typeSize = typeSize;
    }

    public BigDecimal getTypeSize1Intack() {
		return typeSize1Intack;
	}

	public void setTypeSize1Intack(BigDecimal typeSize1Intack) {
		this.typeSize1Intack = typeSize1Intack;
	}

	public BigDecimal getTypeSize2Intack() {
		return typeSize2Intack;
	}

	public void setTypeSize2Intack(BigDecimal typeSize2Intack) {
		this.typeSize2Intack = typeSize2Intack;
	}

	public BigDecimal getTypeSize1Outtack() {
		return typeSize1Outtack;
	}

	public void setTypeSize1Outtack(BigDecimal typeSize1Outtack) {
		this.typeSize1Outtack = typeSize1Outtack;
	}

	public BigDecimal getTypeSize2Outtack() {
		return typeSize2Outtack;
	}

	public void setTypeSize2Outtack(BigDecimal typeSize2Outtack) {
		this.typeSize2Outtack = typeSize2Outtack;
	}

	public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId == null ? null : updatedUserId.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}