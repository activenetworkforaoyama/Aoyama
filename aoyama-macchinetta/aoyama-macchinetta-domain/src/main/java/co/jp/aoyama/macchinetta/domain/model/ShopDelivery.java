package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class ShopDelivery implements Serializable{

	private static final long serialVersionUID = 2634720543325011319L;

	private Date orderOnStartDate;
    private Date orderOnEndDate;
    private String shopDeliveryClass;
    private Date shopDeliveryOn;
    private String createdUserId;
    private Date createdAt;
    private String updatedUserId;
    private Date updatedAt;
    private Short version;
    
    private String codeName;
    
    private boolean delType;
    private String optionType;

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

	public Short getVersion() {
		return version;
	}

	public void setVersion(Short version) {
		this.version = version;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public boolean isDelType() {
		return delType;
	}

	public void setDelType(boolean delType) {
		this.delType = delType;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	
}
