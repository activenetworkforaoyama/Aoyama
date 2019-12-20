package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.util.Date;

public class ShopTel implements Serializable {
    private String shopCode;

    private String shopName;
    
    private String shopTel;
    
    private Integer gyotai;

    private Short version;

    private String createdUserId;

    private Date createdAt;

    private String updatedUserId;

    private Date updatedAt;

    private static final long serialVersionUID = 1L;
    
    public Integer getGyotai() {
		return gyotai;
	}

	public void setGyotai(Integer gyotai) {
		this.gyotai = gyotai;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel == null ? null : shopTel.trim();
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
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