package co.jp.aoyama.macchinetta.app.delivery;

import java.io.Serializable;
import java.util.Date;

public class ShopDeliveryForm implements Serializable{

	private static final long serialVersionUID = -6508738907424643070L;
	
	private Date orderOnStartDate;
    private Date orderOnEndDate;
    private String shopDeliveryClass;
    private Date shopDeliveryOn;
    private String createdUserId;
    private Date createdAt;
    private String updatedUserId;
    private Date updatedAt;
    
    private String orderOnStartDateStr;
    private String orderOnEndDateStr;
    private String shopDeliveryOnStr;
    private String errorIdentification;
    private Date blankIntervalStart;
    private Date blankIntervalEnd;
    private String blankIntervalStartStr;
    private String blankIntervalEndStr;

    private Boolean delType;
	private String optionType;
	private String updateFailure;
	private String num;
    private String isNewData;
    
    public Date getOrderOnStartDate() {
        return orderOnStartDate;
    }

    public void setOrderOnStartDate(Date orderOnStartDate) {
        this.orderOnStartDate = orderOnStartDate;
    }

    public Date getOrderOnEndDate() {
        return orderOnEndDate;
    }

    public void setOrderOnEndDate(Date orderOnEndDate) {
        this.orderOnEndDate = orderOnEndDate;
    }

    public String getShopDeliveryClass() {
        return shopDeliveryClass;
    }

    public void setShopDeliveryClass(String shopDeliveryClass) {
        this.shopDeliveryClass = shopDeliveryClass == null ? null : shopDeliveryClass.trim();
    }

    public Date getShopDeliveryOn() {
        return shopDeliveryOn;
    }

    public void setShopDeliveryOn(Date shopDeliveryOn) {
        this.shopDeliveryOn = shopDeliveryOn;
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

	public Boolean getDelType() {
		return delType;
	}

	public void setDelType(Boolean delType) {
		this.delType = delType;
	}

	public String getOrderOnStartDateStr() {
		return orderOnStartDateStr;
	}

	public void setOrderOnStartDateStr(String orderOnStartDateStr) {
		this.orderOnStartDateStr = orderOnStartDateStr;
	}

	public String getOrderOnEndDateStr() {
		return orderOnEndDateStr;
	}

	public void setOrderOnEndDateStr(String orderOnEndDateStr) {
		this.orderOnEndDateStr = orderOnEndDateStr;
	}

	public String getShopDeliveryOnStr() {
		return shopDeliveryOnStr;
	}

	public void setShopDeliveryOnStr(String shopDeliveryOnStr) {
		this.shopDeliveryOnStr = shopDeliveryOnStr;
	}

	public String getErrorIdentification() {
		return errorIdentification;
	}

	public void setErrorIdentification(String errorIdentification) {
		this.errorIdentification = errorIdentification;
	}

	public Date getBlankIntervalStart() {
		return blankIntervalStart;
	}

	public void setBlankIntervalStart(Date blankIntervalStart) {
		this.blankIntervalStart = blankIntervalStart;
	}

	public Date getBlankIntervalEnd() {
		return blankIntervalEnd;
	}

	public void setBlankIntervalEnd(Date blankIntervalEnd) {
		this.blankIntervalEnd = blankIntervalEnd;
	}

	public String getBlankIntervalStartStr() {
		return blankIntervalStartStr;
	}

	public void setBlankIntervalStartStr(String blankIntervalStartStr) {
		this.blankIntervalStartStr = blankIntervalStartStr;
	}

	public String getBlankIntervalEndStr() {
		return blankIntervalEndStr;
	}

	public void setBlankIntervalEndStr(String blankIntervalEndStr) {
		this.blankIntervalEndStr = blankIntervalEndStr;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getUpdateFailure() {
		return updateFailure;
	}

	public void setUpdateFailure(String updateFailure) {
		this.updateFailure = updateFailure;
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
	
}
