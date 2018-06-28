package com.zyd.cache;

import com.zyd.model.UserDO;

public interface CacheManager {
	
	public static String ZYD_LOGIN_VERIFY_CODE = "zyd_login_verify_code";
	
	public void storeOnlineUser(String id, UserDO userDO);
	public UserDO retrieveOnlineUser(String id);
	public void clearOnlineUser(String id);
	
	public void storeVerifyCode(String id, String verifyCode);
	public String retrieveVerifyCode(String id);
	public void clearVerifyCode(String id);
	
	

}
