package com.zyd.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.zyd.model.UserDO;
import cn.evun.sweet.auth.model.MenuDo;
import cn.evun.sweet.auth.model.UserDo;
import cn.evun.sweet.core.cas.Token;

@Component
public class CacheManagerWithMap implements CacheManager{
	
	//public static Map<String, UserDo> userOnlinePool = new HashMap<String, UserDo>();
	public static Map<String, UserDO> userOnlinePool = new HashMap<String, UserDO>();
	public static Map<String, Token> tokenOnlinePool = new HashMap<String, Token>();
	public static ThreadLocal<List<MenuDo>> currentUserMenu = new ThreadLocal<List<MenuDo>>();
	public static ThreadLocal<List<MenuDo>> currentUserMenuUnvisible = new ThreadLocal<List<MenuDo>>();
	
	public static Map<String, String> verifyCodeMap = new HashMap<String, String>();
	
	@Override
	public void storeOnlineUser(String id, UserDO userDO) {
		userOnlinePool.put(id, userDO);
	}
	@Override
	public UserDO retrieveOnlineUser(String id) {
		return userOnlinePool.get(id);
	}
	
	@Override
	public void clearOnlineUser(String id) {
		userOnlinePool.remove(id);
	}
	
	@Override
	public void storeVerifyCode(String id, String verifyCode) {
		verifyCodeMap.put(id, verifyCode);
	}
	@Override
	public String retrieveVerifyCode(String id) {
		return verifyCodeMap.get(id);
	}
	
	@Override
	public void clearVerifyCode(String id) {
		verifyCodeMap.remove(id);
	}

	
}
