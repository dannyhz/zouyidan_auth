package com.zyd.model;

import java.sql.Date;

public class HouseCheckDO {
	
	Long houseCheckRecordId;
	Long loanApplicationId;
	String houseCheckRecordNo;
	String status;
	String memo;
	Date createdAt;
	String createdBy;
	Date lastUpdatedAt;
	String lastUpdatedBy;
	public Long getHouseCheckRecordId() {
		return houseCheckRecordId;
	}
	public void setHouseCheckRecordId(Long houseCheckRecordId) {
		this.houseCheckRecordId = houseCheckRecordId;
	}
	public Long getLoanApplicationId() {
		return loanApplicationId;
	}
	public void setLoanApplicationId(Long loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}
	public String getHouseCheckRecordNo() {
		return houseCheckRecordNo;
	}
	public void setHouseCheckRecordNo(String houseCheckRecordNo) {
		this.houseCheckRecordNo = houseCheckRecordNo;
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
