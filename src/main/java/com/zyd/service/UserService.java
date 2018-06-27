package com.zyd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zyd.dao.IUserDao;
import com.zyd.model.UserDO;

@Service
public class UserService {
	@Resource
	private IUserDao userDao;
	
	public UserDO getUserByPhone(String phoneNo){
		UserDO userQuery = new UserDO();
		userQuery.setPhone(phoneNo);
		List<UserDO> userList = userDao.queryUser(userQuery);
		if(userList.size() > 0){
			return userList.get(0);
		}
		return null;
	}
	
	public UserDO getUserByLoginUserCode(String userLoginCode){
		UserDO userQuery = new UserDO();
		userQuery.setUserLoginCode(userLoginCode);
		List<UserDO> userList = userDao.queryUser(userQuery);
		if(userList.size() > 0){
			return userList.get(0);
		}
		return null;
	}
	
	public boolean isUserExistedByPhone(String phoneNo){
		UserDO userQuery = new UserDO();
		userQuery.setPhone(phoneNo);
		List<UserDO> userList = userDao.queryUser(userQuery);
		if(userList.size() > 0){
			return true;
		}
		return false;
	}

}
