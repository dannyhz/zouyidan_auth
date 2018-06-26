package com.zyd.model;

import java.util.Date;

public class TaskDO {
	
	Long taskId;
	Long serviceRecordId;
	String serviceType;
	Long nextOper;
	String nextOperType;
	Long crntOper;
	String crntOperType;
	Date createdAt;
	String status;
	
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public Long getServiceRecordId() {
		return serviceRecordId;
	}
	public void setServiceRecordId(Long serviceRecordId) {
		this.serviceRecordId = serviceRecordId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Long getNextOper() {
		return nextOper;
	}
	public void setNextOper(Long nextOper) {
		this.nextOper = nextOper;
	}
	public String getNextOperType() {
		return nextOperType;
	}
	public void setNextOperType(String nextOperType) {
		this.nextOperType = nextOperType;
	}
	public Long getCrntOper() {
		return crntOper;
	}
	public void setCrntOper(Long crntOper) {
		this.crntOper = crntOper;
	}
	public String getCrntOperType() {
		return crntOperType;
	}
	public void setCrntOperType(String crntOperType) {
		this.crntOperType = crntOperType;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
