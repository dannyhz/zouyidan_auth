package cn.evun.sweet.core.cas;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用来维护在线用户的服务，提供登陆唯一性支持
 * 维护一个userId和Token键值对的map
 * @author yangw
 */
@Component
public class OnlineUserManager{

	protected static final Logger LOGGER = LogManager.getLogger();	
	
	@Value("${user.login.onlineCheck}")
	private Boolean onlineCheck; 
	
//	@Resource(name="redisTemplate")
//	private HashOperations<String, String, Token> cacheOps;
	
	private HashMap<String, Token> cacheOps;
	
	@Autowired
	private SSOConfig ssoconfig;

	/**
	 * 判断是否已在其他地方登陆过
	 */
	public boolean isLoser(Token token){
		if(!onlineCheck){
			return false;
		}
		if(token == null){
			return true;
		}
		Token cacheToken = this.getToken(token.getUserId());
		if(cacheToken!= null && !token.getId().equals(cacheToken.getId())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据设备号踢出在线用户(客户端APP启动时调用)。主要用于APP的非正常退出。
	 * @param clientId
	 */
	public void kick(String clientId){
		if(cacheOps.containsKey(clientId)){
			cacheOps.remove(clientId);
		}
	}
	
	/**
	 * 根据userId获取ClientId
	 */
	public String getClientId(String userId){
		Token token = getToken(userId);
		if(token == null){
			return null;
		}
		return token.getClientId();
	}
	
	/**
	 * 替换token
	 */
	public void replaceToken(String userId,Token token){
		if(!onlineCheck){
			return;
		}
		cacheOps.put(userId, token);
	}
	
	
	/**
	 * 将userId对应的token从map中移除
	 * @param request
	 */
	public void removeTokenFromOnlineMap(String userId) {
		if(!onlineCheck){
			return;
		}
		cacheOps.remove(userId);
	}

	/**
	 * 取token
	 * @param userId
	 * @return
	 */
	public Token getToken(String userId){
		if(!onlineCheck){
			return null;
		}
		return cacheOps.get(userId);
	}
	
	public Boolean getOnlineCheck() {
		return onlineCheck;
	}
	
}
