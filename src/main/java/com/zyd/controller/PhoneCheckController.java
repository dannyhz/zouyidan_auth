package com.zyd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.common.JsonResultDO;
import com.zyd.dto.LoanApplicationDTO;

@RestController
@RequestMapping("/phoneCheck/*")
public class PhoneCheckController {
	 
	 @RequestMapping("assignToAssistant")
	 public JsonResultDO assignToAssistant(LoanApplicationDTO apply) {
		return null; 
	 }
}
