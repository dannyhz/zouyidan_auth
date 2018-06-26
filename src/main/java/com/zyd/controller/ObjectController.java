package com.zyd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zyd.common.JsonResultDO;
import com.zyd.dto.LoanApplicationDTO;
import com.zyd.model.LoanApplicationDO;

@RestController
@RequestMapping("/apply/*")
public class ObjectController {
	
	  @RequestMapping("addApply")
	  public JsonResultDO addApply(LoanApplicationDTO apply) {
		  
		  System.out.println("--- buy buy buy ---");
		  apply.setPersonId(100L);
		  apply.setApplyId(30L);
		  apply.setStatus("END");
		  System.out.println("json str [ " +JSON.toJSONString(apply) + "]");
		  
		  List<LoanApplicationDO> applyList = new ArrayList<LoanApplicationDO>();
		  LoanApplicationDO apply1 = new LoanApplicationDO();
		  apply1.setStatus("111");
		  apply1.setApplicationNo("app00000001");
		  
		  LoanApplicationDO apply2 = new LoanApplicationDO();
		  apply2.setStatus("222");
		  apply2.setApplicationNo("app0000002");
		  
		  applyList.add(apply1);
		  applyList.add(apply2);
		  apply.setAppList(applyList);
		  JsonResultDO result = new JsonResultDO();
		  result.setSuccessData(apply);
		  return result;
	  }	
	
	  @RequestMapping("query") 
	  public String login(LoanApplicationDTO apply){ 
		  JsonResultDO jsonResult = new JsonResultDO();
		  System.out.println(apply.getPersonId());
		  jsonResult.setData(apply);
		  jsonResult.parseData(LoanApplicationDTO.class);
	    
	    return String.valueOf(apply.getPersonId());
	  } 

	  @RequestMapping("add")
		 public JsonResultDO addApplication(LoanApplicationDTO application) {
			 System.out.println(application.getStatus());
			 JsonResultDO rslt = new JsonResultDO();
			 application.setApplyId(1000L);
			 ArrayList aList = new ArrayList();
			 LoanApplicationDO apply = new LoanApplicationDO();
			 apply.setStatus("READY");
			 aList.add(apply);
			 application.setAppList(aList);
			 rslt.setSuccessData(application);
			 rslt.setCode("0000");
			 rslt.setMessage("add successful");
			 
			// loanApplicationService.createLoanApplication(apply);
			 
			return rslt; 
		 }


}
