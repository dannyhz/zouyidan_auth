package com.zyd.dao;

import java.util.List;

import com.zyd.model.UserDO;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Zhu Xiang
 */
public interface IUserDao extends Mapper<UserDO>{
	
	/**
	 * @param 
	 * @return
	 *
	 */
	int insertUser(UserDO userDO);

	
	/**
	 * @param queryUser
	 * @return
	 *
	 */
	List<UserDO> queryUser(UserDO userDO);
	


}
