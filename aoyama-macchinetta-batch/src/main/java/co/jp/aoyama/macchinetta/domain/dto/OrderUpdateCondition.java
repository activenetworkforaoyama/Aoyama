package co.jp.aoyama.macchinetta.domain.dto;

import java.util.Date;
import java.util.List;

import co.jp.aoyama.macchinetta.domain.consts.DomainConst;

public class OrderUpdateCondition {

	/** TSCステータス */
	private String tscStatus;
	/** 工場自動連携ステータス */
	private String send2factoryStatus;
	/** 工場ステータス */
	private String makerFactoryStatus;
	/** 最終更新者 */
	private String updatedUserId;
	/** 最終更新日時 */
	private Date updatedAt;
	/** 注文IDリスト */
	private List<String> orderIds;

	public OrderUpdateCondition() {
		setUpdatedUserId(DomainConst.BATCH_UPDATE_USERID);
		setUpdatedAt(new Date());
	}

	public List<String> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<String> orderIds) {
		this.orderIds = orderIds;
	}

	public String getTscStatus() {
		return tscStatus;
	}

	public void setTscStatus(String tscStatus) {
		this.tscStatus = tscStatus;
	}

	public String getSend2factoryStatus() {
		return send2factoryStatus;
	}

	public void setSend2factoryStatus(String send2factoryStatus) {
		this.send2factoryStatus = send2factoryStatus;
	}

	public String getMakerFactoryStatus() {
		return makerFactoryStatus;
	}

	public void setMakerFactoryStatus(String makerFactoryStatus) {
		this.makerFactoryStatus = makerFactoryStatus;
	}

	public String getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
