package co.jp.aoyama.macchinetta.app.orderlist;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import co.jp.aoyama.macchinetta.domain.model.Order;

/**
 * @author wangyingrui
 *
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderListForm implements Serializable {

	private static final long serialVersionUID = 3782971582083340403L;

	private String orderId;
    
    private String custCd;

    private String tscStatus;

    private String storeStaffNm;
    
    private String productItem;
    
    private String productFabricNo;
    
    private String productOrderdDateFrom;
    
    private String productOrderdDateTo;

    private Date productOrderdDate2From;
    
    private Date productOrderdDate2To;

    private String custShopDeliveryDateFrom;
    
    private String custShopDeliveryDateTo;

    private Date custShopDeliveryDate2From;
    
    private Date custShopDeliveryDate2To;

    private String updatedAtFrom;
    
    private String updatedAtTo;

    private Date updatedAt2From;
    
    private Date updatedAt2To;

    private String custDeliverDateFrom;
    
    private String custDeliverDateTo;

    private Date custDeliverDate2From;
    
    private Date custDeliverDate2To;
    
    private boolean isCancelled;   

    private boolean isAccount;
    
    private boolean isConfirm;
    
    private boolean isSendFailure;
    
    private boolean isOtherShop;
    
    private String authority;
    
    private String belongCode;
    
    private String fablicImporter;
    
    
    private List<Order> orderList;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public String getTscStatus() {
		return tscStatus;
	}

	public void setTscStatus(String tscStatus) {
		this.tscStatus = tscStatus;
	}

	public String getStoreStaffNm() {
		return storeStaffNm;
	}

	public void setStoreStaffNm(String storeStaffNm) {
		this.storeStaffNm = storeStaffNm;
	}

	public String getProductItem() {
		return productItem;
	}

	public void setProductItem(String productItem) {
		this.productItem = productItem;
	}

	public String getProductFabricNo() {
		return productFabricNo;
	}

	public void setProductFabricNo(String productFabricNo) {
		this.productFabricNo = productFabricNo;
	}

	public String getProductOrderdDateFrom() {
		return productOrderdDateFrom;
	}

	public void setProductOrderdDateFrom(String productOrderdDateFrom) {
		this.productOrderdDateFrom = productOrderdDateFrom;
	}

	public String getProductOrderdDateTo() {
		return productOrderdDateTo;
	}

	public void setProductOrderdDateTo(String productOrderdDateTo) {
		this.productOrderdDateTo = productOrderdDateTo;
	}

	public Date getProductOrderdDate2From() {
		return productOrderdDate2From;
	}

	public void setProductOrderdDate2From(Date productOrderdDate2From) {
		this.productOrderdDate2From = productOrderdDate2From;
	}

	public Date getProductOrderdDate2To() {
		return productOrderdDate2To;
	}

	public void setProductOrderdDate2To(Date productOrderdDate2To) {
		this.productOrderdDate2To = productOrderdDate2To;
	}

	public String getCustShopDeliveryDateFrom() {
		return custShopDeliveryDateFrom;
	}

	public void setCustShopDeliveryDateFrom(String custShopDeliveryDateFrom) {
		this.custShopDeliveryDateFrom = custShopDeliveryDateFrom;
	}

	public String getCustShopDeliveryDateTo() {
		return custShopDeliveryDateTo;
	}

	public void setCustShopDeliveryDateTo(String custShopDeliveryDateTo) {
		this.custShopDeliveryDateTo = custShopDeliveryDateTo;
	}

	public Date getCustShopDeliveryDate2From() {
		return custShopDeliveryDate2From;
	}

	public void setCustShopDeliveryDate2From(Date custShopDeliveryDate2From) {
		this.custShopDeliveryDate2From = custShopDeliveryDate2From;
	}

	public Date getCustShopDeliveryDate2To() {
		return custShopDeliveryDate2To;
	}

	public void setCustShopDeliveryDate2To(Date custShopDeliveryDate2To) {
		this.custShopDeliveryDate2To = custShopDeliveryDate2To;
	}

	public String getUpdatedAtFrom() {
		return updatedAtFrom;
	}

	public void setUpdatedAtFrom(String updatedAtFrom) {
		this.updatedAtFrom = updatedAtFrom;
	}

	public String getUpdatedAtTo() {
		return updatedAtTo;
	}

	public void setUpdatedAtTo(String updatedAtTo) {
		this.updatedAtTo = updatedAtTo;
	}

	public Date getUpdatedAt2From() {
		return updatedAt2From;
	}

	public void setUpdatedAt2From(Date updatedAt2From) {
		this.updatedAt2From = updatedAt2From;
	}

	public Date getUpdatedAt2To() {
		return updatedAt2To;
	}

	public void setUpdatedAt2To(Date updatedAt2To) {
		this.updatedAt2To = updatedAt2To;
	}

	public String getCustDeliverDateFrom() {
		return custDeliverDateFrom;
	}

	public void setCustDeliverDateFrom(String custDeliverDateFrom) {
		this.custDeliverDateFrom = custDeliverDateFrom;
	}

	public String getCustDeliverDateTo() {
		return custDeliverDateTo;
	}

	public void setCustDeliverDateTo(String custDeliverDateTo) {
		this.custDeliverDateTo = custDeliverDateTo;
	}

	public Date getCustDeliverDate2From() {
		return custDeliverDate2From;
	}

	public void setCustDeliverDate2From(Date custDeliverDate2From) {
		this.custDeliverDate2From = custDeliverDate2From;
	}

	public Date getCustDeliverDate2To() {
		return custDeliverDate2To;
	}

	public void setCustDeliverDate2To(Date custDeliverDate2To) {
		this.custDeliverDate2To = custDeliverDate2To;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public boolean getIsAccount() {
		return isAccount;
	}

	public void setIsAccount(boolean isAccount) {
		this.isAccount = isAccount;
	}

	public boolean getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(boolean isConfirm) {
		this.isConfirm = isConfirm;
	}

	public boolean getIsSendFailure() {
		return isSendFailure;
	}

	public void setIsSendFailure(boolean isSendFailure) {
		this.isSendFailure = isSendFailure;
	}

	public boolean getIsOtherShop() {
		return isOtherShop;
	}

	public void setIsOtherShop(boolean isOtherShop) {
		this.isOtherShop = isOtherShop;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getBelongCode() {
		return belongCode;
	}

	public void setBelongCode(String belongCode) {
		this.belongCode = belongCode;
	}

	public String getFablicImporter() {
		return fablicImporter;
	}

	public void setFablicImporter(String fablicImporter) {
		this.fablicImporter = fablicImporter;
	}

    
	

}