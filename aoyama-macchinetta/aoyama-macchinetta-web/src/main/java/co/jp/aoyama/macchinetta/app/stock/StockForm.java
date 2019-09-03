package co.jp.aoyama.macchinetta.app.stock;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StockForm implements Serializable {

	private static final long serialVersionUID = -3518896881528527494L;

    private String fabricId;
	
	private String fabricNo;
	
	private String color;
	
	private String pattern;
	
	private String brandName;
	
	private String makerName;
	
	private String factoryName;
	
	private Integer retailPrice;
	
	private Integer retailPriceTo;
	
	private BigDecimal reservationStock;

	private BigDecimal theoreticalStock;

    private BigDecimal actualStock;

    private Date createdAt;

    private Date updatedAt;
    
	private String updType;
	
	private String optionType;
	
	private String version;
	
	private String orderPattern;
	
	private BigDecimal theoretical;
	
	public String getFabricId() {
		return fabricId;
	}

	public void setFabricId(String fabricId) {
		this.fabricId = fabricId;
	}

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

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
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
	
	public BigDecimal getReservationStock() {
		return reservationStock;
	}

	public void setReservationStock(BigDecimal reservationStock) {
		this.reservationStock = reservationStock;
	}

	public void setRetailPriceTo(Integer retailPriceTo) {
		this.retailPriceTo = retailPriceTo;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOrderPattern() {
		return orderPattern;
	}

	public void setOrderPattern(String orderPattern) {
		this.orderPattern = orderPattern;
	}

	public BigDecimal getTheoretical() {
		return theoretical;
	}

	public void setTheoretical(BigDecimal theoretical) {
		this.theoretical = theoretical;
	}
	
}