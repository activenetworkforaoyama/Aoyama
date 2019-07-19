package co.jp.aoyama.macchinetta.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Stock implements Serializable {

	private static final long serialVersionUID = 3117939473881415294L;
	
	private String fabricNo;
	
	private String color;
	
	private String pattern;
	
	private String brandName;
	
	private String makerName;
	
	private String factoryName;
	
	private Integer retailPrice;
	
	private Integer retailPriceTo;

	private BigDecimal theoreticalStock;

    private BigDecimal actualStock;
    
    private BigDecimal reservationStock;
    
    private String createdUserId;
    
    private String updatedUserId;

    private Date createdAt;

    private Date updatedAt;
    
    private String updType;
    
    private String optionType;
    
    private String fablicBrandNo;

	public String getFabricNo() {
		return fabricNo;
	}

	public void setFabricNo(String fabricNo) {
		this.fabricNo = fabricNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public Integer getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Integer retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Integer getRetailPriceTo() {
		return retailPriceTo;
	}

	public void setRetailPriceTo(Integer retailPriceTo) {
		this.retailPriceTo = retailPriceTo;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
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
		this.createdUserId = createdUserId;
	}

	public String getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdType() {
		return updType;
	}

	public void setUpdType(String updType) {
		this.updType = updType;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getFablicBrandNo() {
		return fablicBrandNo;
	}

	public void setFablicBrandNo(String fablicBrandNo) {
		this.fablicBrandNo = fablicBrandNo;
	}
    
}
