package com.zyd.dto;

import java.util.List;

import com.zyd.model.LoanApplicationDO;

public class LoanApplicationDTO {
	private Long applyId;
	private Long personId;
	private String status;
	private List<LoanApplicationDO> appList;
	
	public List<LoanApplicationDO> getAppList() {
		return appList;
	}

	public void setAppList(List<LoanApplicationDO> appList) {
		this.appList = appList;
	}

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

}
