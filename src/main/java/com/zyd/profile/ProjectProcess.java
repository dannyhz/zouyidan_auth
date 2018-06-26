package com.zyd.profile;

public class ProjectProcess {
	
	public int sequence;
	public String id;
	public String code;
	public String operator;
	public String roleId;
	public String scanPreStts;//进入模块的被扫描的状态
	public String waitStts;//进入模块的第一个被转化的状态 第一个都是等待 ， 等到处理完才是 pass ，如果失败终结 就是 fail
	public String passStts;
	public String failStts;
	public String unit;//角色  还是  某个人
	
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getScanPreStts() {
		return scanPreStts;
	}
	public void setScanPreStts(String scanPreStts) {
		this.scanPreStts = scanPreStts;
	}
	public String getWaitStts() {
		return waitStts;
	}
	public void setWaitStts(String waitStts) {
		this.waitStts = waitStts;
	}
	public String getPassStts() {
		return passStts;
	}
	public void setPassStts(String passStts) {
		this.passStts = passStts;
	}
	public String getFailStts() {
		return failStts;
	}
	public void setFailStts(String failStts) {
		this.failStts = failStts;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
