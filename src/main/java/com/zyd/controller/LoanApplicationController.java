package com.zyd.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.common.JsonResultDO;
import com.zyd.dto.LoanApplicationDTO;
import com.zyd.model.LoanApplicationDO;
import com.zyd.service.LoanApplicationService;

@RestController
@RequestMapping("/application/*")
public class LoanApplicationController {
	
	@Resource
	LoanApplicationService loanApplicationService;
	
	 
	 @RequestMapping("add")
	 public JsonResultDO addApplication(LoanApplicationDTO application) {
		 System.out.println(application.getStatus());
		 JsonResultDO rslt = new JsonResultDO();
		 application.setApplyId(1000L);
		 LoanApplicationDO apply = new LoanApplicationDO();
		 
		 apply.setStatus("commit");
		 apply.setLoaneeId(1000L);
		 
		 
		 rslt.setSuccessData(application);
		 rslt.setCode("0000");
		 rslt.setMessage("add successful");
		 
		 loanApplicationService.createLoanApplication(apply);
		 
		return rslt; 
	 }
}
