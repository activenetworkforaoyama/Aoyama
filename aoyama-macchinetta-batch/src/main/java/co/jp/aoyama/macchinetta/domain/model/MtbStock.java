package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MtbStock implements Serializable {
    private String fabricId;

    private BigDecimal theoreticalStock;

    private BigDecimal actualStock;

    private BigDecimal reservationStock;

    private String createdUserId;

    private Date createdAt;

    private String updatedUserId;

    private Date updatedAt;

    private static final long serialVersionUID = 1L;

    public String getFabricId() {
        return fabricId;
    }

    public void setFabricId(String fabricId) {
        this.fabricId = fabricId == null ? null : fabricId.trim();
    }

    public BigDecimal getTheoreticalStock() {
        return theoreticalStock;
    }

    public void setTheoreticalStock(BigDecimal theoreticalStock) {
        this.theoreticalStock = theoreticalStock;
    }

    public BigDecimal getActualStock() {
        return actualStock;
    }

    public void setActualStock(BigDecimal actualStock) {
        this.actualStock = actualStock;
    }

    public BigDecimal getReservationStock() {
        return reservationStock;
    }

    public void setReservationStock(BigDecimal reservationStock) {
        this.reservationStock = reservationStock;
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