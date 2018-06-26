package com.zyd.model;

import java.sql.Date;

public class PhoneCheckDO {
	
	Long phoneCheckRecordId;
	Long loanApplicatiionId;
	String phoneCheckRecordNo;
	String status;
	String memo;
	Date createdAt;
	String createdBy;
	Date lastUpdatedAt;
	String lastUpdatedBy;
	public Long getPhoneCheckRecordId() {
		return phoneCheckRecordId;
	}
	public void setPhoneCheckRecordId(Long phoneCheckRecordId) {
		this.phoneCheckRecordId = phoneCheckRecordId;
	}
	public Long getLoanApplicatiionId() {
		return loanApplicatiionId;
	}
	public void setLoanApplicatiionId(Long loanApplicatiionId) {
		this.loanApplicatiionId = loanApplicatiionId;
	}
	public String getPhoneCheckRecordNo() {
		return phoneCheckRecordNo;
	}
	public void setPhoneCheckRecordNo(String phoneCheckRecordNo) {
		this.phoneCheckRecordNo = phoneCheckRecordNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	

}
