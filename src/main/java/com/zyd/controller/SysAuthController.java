package com.zyd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.dto.AuthDTO;
import com.zyd.service.SysAuthService;

import cn.evun.sweet.core.common.JsonResultDO;

@RestController
public class SysAuthController {
	
	@Resource
	private SysAuthService sysAuthService;
	
	 
	 @RequestMapping("/sysauth/add")
	 public JsonResultDO addRoleAuth(AuthDTO authDTO) {
		 
		 System.out.println(authDTO.getRoleId());
		 JsonResultDO rslt = new JsonResultDO();
		 
		 
		 return rslt; 
	 }
	 
	 
}
