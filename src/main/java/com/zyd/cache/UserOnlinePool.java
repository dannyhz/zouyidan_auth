package com.zyd.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.evun.sweet.auth.model.MenuDo;
import cn.evun.sweet.auth.model.UserDo;
import cn.evun.sweet.core.cas.Token;

public class UserOnlinePool  {
	
	public static Map<String, UserDo> userOnlinePool = new HashMap<String, UserDo>();
	
	public static Map<String, Token> tokenOnlinePool = new HashMap<String, Token>();
	public static ThreadLocal<List<MenuDo>> currentUserMenu = new ThreadLocal<List<MenuDo>>();
	public static ThreadLocal<List<MenuDo>> currentUserMenuUnvisible = new ThreadLocal<List<MenuDo>>();

}
