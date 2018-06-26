package com.zyd.model;

import org.apache.ibatis.type.Alias;

/**
 * 借款申请
 * @author Zhu Xiang
 *
 */
@Alias("LoanApplication")
public class LoanApplicationDO {
	
	private Long loanApplicationId; 
	private String applicationNo;
	private String status;
	private Long loaneeId;	
	
	//product
	private Long processTemplateId;
	
	//process_template
	private String templateCode;
	
	private Long productId;
	
	public Long getProcessTemplateId() {
		return processTemplateId;
	}
	public void setProcessTemplateId(Long processTemplateId) {
		this.processTemplateId = processTemplateId;
	}
	
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public Long getLoanApplicationId() {
		return loanApplicationId;
	}
	public void setLoanApplicationId(Long loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public Long getLoaneeId() {
		return loaneeId;
	}
	public void setLoaneeId(Long loaneeId) {
		this.loaneeId = loaneeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
