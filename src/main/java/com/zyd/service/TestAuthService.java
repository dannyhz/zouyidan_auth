package com.zyd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zyd.dao.ISysAuthDao;
import com.zyd.model.auth.SysAuth;
import com.zyd.model.auth.SysRole;

@Component
public class TestAuthService {
	
	@Resource
	private ISysAuthDao authDao;
	
	public void createRoleMenuAuth(List<SysAuth> roleSysAuthList){
		
		for(SysAuth auth : roleSysAuthList){
			authDao.insert(auth);
		}
	}
	
	public void updateRoleMenuAuth(SysRole role , List<SysAuth> roleSysAuthList){
		
		authDao.deleteAuthByRole(role);
		
		for(SysAuth auth : roleSysAuthList){
			authDao.insert(auth);
		}
	}

}
