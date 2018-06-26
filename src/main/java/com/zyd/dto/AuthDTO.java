package com.zyd.dto;

import java.util.List;

import com.zyd.model.auth.SysAuth;

public class AuthDTO {
	
	private Long roleId;
	private List<SysAuth> sysAuthList;
	private String sysAuthContent;
	
	public String getSysAuthContent() {
		return sysAuthContent;
	}
	public void setSysAuthContent(String sysAuthContent) {
		this.sysAuthContent = sysAuthContent;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public List<SysAuth> getSysAuthList() {
		return sysAuthList;
	}
	public void setSysAuthList(List<SysAuth> sysAuthList) {
		this.sysAuthList = sysAuthList;
	}
	

}
