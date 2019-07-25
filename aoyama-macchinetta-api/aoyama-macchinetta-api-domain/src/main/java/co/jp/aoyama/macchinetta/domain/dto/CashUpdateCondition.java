package co.jp.aoyama.macchinetta.domain.dto;

import java.util.Date;
import java.util.List;

import co.jp.aoyama.macchinetta.domain.consts.DomainConst;

public class CashUpdateCondition {

	/** 会計ステータス */
	private String cashStatus;
	/** 最終更新者 */
	private String updatedUserId;
	/** 最終更新日時 */
	private Date updatedAt;
	/** 会計IDリスト */
	private List<String> cashIds;

	public CashUpdateCondition() {
		setUpdatedUserId(DomainConst.BATCH_UPDATE_USERID);
		setUpdatedAt(new Date());
	}

	public String getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(String cashStatus) {
		this.cashStatus = cashStatus;
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

	public List<String> getCashIds() {
		return cashIds;
	}

	public void setCashIds(List<String> cashIds) {
		this.cashIds = cashIds;
	}

}
