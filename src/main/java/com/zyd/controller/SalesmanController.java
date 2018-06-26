package com.zyd.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.common.JsonResultDO;
import com.zyd.model.SalesmanDO;
import com.zyd.service.LoanApplicationService;

@RestController
@RequestMapping("/salesman/*")
public class SalesmanController {
	
	@Resource
	LoanApplicationService loanApplicationService;
	
	 
	 @RequestMapping("add")
	 public JsonResultDO addNewSalesman(SalesmanDO salesman) {
		 
		 JsonResultDO rslt = new JsonResultDO();
		
		 rslt.setCode("0000");
		 rslt.setMessage("add successful");
		 
		 
		return rslt; 
	 }
}
