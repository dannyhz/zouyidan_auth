package com.zyd.dao;

import com.zyd.model.auth.SysAuth;
import com.zyd.model.auth.SysRole;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Zhu Xiang
 */
public interface ISysAuthDao extends Mapper<SysAuth>{
	
	int insertSysAuth(SysAuth sysAuth);
	
	int deleteAuthByRole(SysRole sysRole);
}
