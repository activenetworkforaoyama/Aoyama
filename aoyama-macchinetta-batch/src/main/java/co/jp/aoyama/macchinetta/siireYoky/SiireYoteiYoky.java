/*
 * Copyright (C) 2017 NTT Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package co.jp.aoyama.macchinetta.siireYoky;

/**
 * Model bean of SiireYoteiYoky.
 */
public class SiireYoteiYoky {
    
    private String storeBrandCode;
    private String orderPattern;
    private String orderId;
    private String hostTransmitMakerProduct;
    private String hostTransmitItemCd;
    private String hostTransmitMakerCd;
    private String hostTransmitNenkiCd;
    private String hostTransmitColorCd;
    private String productItem;
    private String hostTransmitSize;
    private String tateSizeCd;
    private String yokoSizeCd;
    private String wsPrice;
	private String billingAmount;
    private String hostTransmitStoreCd;
    private String productOrderdDate;
    
	public String getStoreBrandCode() {
		return storeBrandCode;
	}

	public void setStoreBrandCode(String storeBrandCode) {
		this.storeBrandCode = storeBrandCode;
	}

	public String getOrderPattern() {
		return orderPattern;
	}

	public void setOrderPattern(String orderPattern) {
		this.orderPattern = orderPattern;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getHostTransmitMakerProduct() {
		return hostTransmitMakerProduct;
	}

	public void setHostTransmitMakerProduct(String hostTransmitMakerProduct) {
		this.hostTransmitMakerProduct = hostTransmitMakerProduct;
	}

	public String getHostTransmitItemCd() {
		return hostTransmitItemCd;
	}

	public void setHostTransmitItemCd(String hostTransmitItemCd) {
		this.hostTransmitItemCd = hostTransmitItemCd;
	}

	public String getHostTransmitMakerCd() {
		return hostTransmitMakerCd;
	}

	public void setHostTransmitMakerCd(String hostTransmitMakerCd) {
		this.hostTransmitMakerCd = hostTransmitMakerCd;
	}

	public String getHostTransmitNenkiCd() {
		return hostTransmitNenkiCd;
	}

	public void setHostTransmitNenkiCd(String hostTransmitNenkiCd) {
		this.hostTransmitNenkiCd = hostTransmitNenkiCd;
	}

	public String getHostTransmitColorCd() {
		return hostTransmitColorCd;
	}

	public void setHostTransmitColorCd(String hostTransmitColorCd) {
		this.hostTransmitColorCd = hostTransmitColorCd;
	}

	public String getProductItem() {
		return productItem;
	}

	public void setProductItem(String productItem) {
		this.productItem = productItem;
	}

	public String getHostTransmitSize() {
		return hostTransmitSize;
	}

	public void setHostTransmitSize(String hostTransmitSize) {
		this.hostTransmitSize = hostTransmitSize;
	}

	public String getTateSizeCd() {
		return tateSizeCd;
	}

	public void setTateSizeCd(String tateSizeCd) {
		this.tateSizeCd = tateSizeCd;
	}

	public String getYokoSizeCd() {
		return yokoSizeCd;
	}

	public void setYokoSizeCd(String yokoSizeCd) {
		this.yokoSizeCd = yokoSizeCd;
	}

	public String getWsPrice() {
		return wsPrice;
	}

	public void setWsPrice(String wsPrice) {
		this.wsPrice = wsPrice;
	}

	public String getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(String billingAmount) {
		this.billingAmount = billingAmount;
	}

	public String getHostTransmitStoreCd() {
		return hostTransmitStoreCd;
	}

	public void setHostTransmitStoreCd(String hostTransmitStoreCd) {
		this.hostTransmitStoreCd = hostTransmitStoreCd;
	}

	public String getProductOrderdDate() {
		return productOrderdDate;
	}

	public void setProductOrderdDate(String productOrderdDate) {
		this.productOrderdDate = productOrderdDate;
	}
}
