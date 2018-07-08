package com.zyd.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.cache.CacheManager;
import com.zyd.model.UserDO;
import com.zyd.service.ComponentService;
import com.zyd.service.UserService;

import cn.evun.sweet.common.util.StringUtils;
import cn.evun.sweet.common.util.UUIDGenerator;
import cn.evun.sweet.common.util.VerifyCodeUtils;
import cn.evun.sweet.common.util.network.NetUtils;
import cn.evun.sweet.common.util.web.CookieHelper;
import cn.evun.sweet.core.cas.ContextHolder;
import cn.evun.sweet.core.cas.LoginCookieHelper;
import cn.evun.sweet.core.cas.LoginToken;
import cn.evun.sweet.core.common.JsonResultDO;
import cn.evun.sweet.core.common.R;

@RestController
public class BizLoginController {
	
	@Resource
	private UserService userService;
	@Resource
	private CacheManager cacheManager;
	@Resource
	private ComponentService componentService;
	//@Resource
	//private JwtHelper jwtHelper;
	
	
	  @ResponseBody
	  @RequestMapping(value = "/biz/checkPhoneNo" , method = RequestMethod.GET)
	  public JsonResultDO chekPhoneNo(UserDO user) {
		  JsonResultDO result = new JsonResultDO();
		  if(userService.getUserByPhone(user.getPhone()) == null){
			  result.addAttribute(JsonResultDO.RETURN_OBJECT_KEY, "success");  
		      result.setSuccess(false);
		      result.setStatusCode("0");
		      result.setMessage("此手机号码账户不存在");
		      return result;
		  }
		  
		  result.setSuccess(true);
		  return result;
	  }	
	
	  //---------------------
	  @RequestMapping(value="/biz/reqVerifyCode", method=RequestMethod.GET)
	  public void verifyCode(HttpServletRequest request, HttpServletResponse response){
		  try {
	            String checkId = UUIDGenerator.genUUID();
	            CookieHelper cookieHelper = new CookieHelper();
	            cookieHelper.setCookieName(CacheManager.ZYD_LOGIN_VERIFY_CODE);
	            if (!NetUtils.isValidAddress(request.getServerName()) && !NetUtils.isLocalHost(request.getServerName())) {
	                String domain = "." + resolveTopDomain(request.getServerName());
	                cookieHelper.setCookieDomain(domain);
	            }
	            cookieHelper.addCookie(response, checkId);

	            String verifyCode = VerifyCodeUtils.outputVerifyImage(85, 35, response.getOutputStream(), 4);
	            
	            System.out.println(verifyCode);
	            
	            cacheManager.storeVerifyCode(CacheManager.ZYD_LOGIN_VERIFY_CODE + "_" + checkId, verifyCode);
	        } catch (IOException e) {
	            //LOGGER.error(R_Transaction.Log.log_marker_component, "Catch exception when creat verify code! error:{}" + e.getMessage());
	        }
	  }
	  
	  private String resolveTopDomain(String domain) {
	        String[] strs = domain.split("\\.");
	        if (strs.length < 2) {
	            domain = strs[0];
	        } else if (strs.length == 2) {
	            domain = strs[0] + "." + strs[1];
	        } else {
	            domain = domain.substring(domain.indexOf(".") + 1);
	        }
	        return domain;
	    }
	 
	  
	  @ResponseBody
	  @RequestMapping(value = "/biz/login", method = RequestMethod.POST)
	    public JsonResultDO loginajax(@RequestBody UserDO user,HttpServletRequest request, HttpServletResponse response) {
	        JsonResultDO result = new JsonResultDO();
	        if (!StringUtils.hasText(user.getPassword()) || !StringUtils.hasText(user.getUserLoginCode())) {
	            //throw new ValidateException("trans.login.error.noneinput", "请输入账号和密码");
	        	result.setSuccess(false);
	        	result.setMessage("请输入账号和密码");
	        	return result;
	        }

	        if (!componentService.checkVerifyCode(request, user.getVerifyCode())) {
	        	result.setSuccess(false);
	        	result.setMessage("验证码错误");
	        	return result;
	        }      
	        UserDO loginUser = checkLoginUser(user);//用户账户校验
	        if (loginUser == null) {
	            result.setSuccess(false);
	        	result.setMessage("用户账户校验未通过");
	        	return result;
	        }
	        
	        if(loginUser.getPassword().equals(user.getPassword())){
	        	/*验证通过后开始创建Session内容*/
	    		LoginToken token = new LoginToken();
	    		token.setUserIp(String.valueOf(request.getAttribute(R.request.mdc_ip)));//在filter中植入的ip地址信息
	    		token.setUserId(String.valueOf(loginUser.getUserId()));//要求业务层必须有userId字段。
	    		token.setSessionid(request.getSession(true).getId());//同时创建了session
	    		token.setClientId(request.getHeader("AppClientId"));//手机端登录时通过请求头携带
	    		try{
	    			LoginCookieHelper.generateCookie(request, response, token);
	    		}catch(Exception ex){
	    			System.out.println("Failed to generate custom cookie[token.getUserId()]. ex.getMessage()");
	    		}
	    		//ContextHolder.setSession((DistributedSession)request.getSession(false));//绑定当前线程
	    		HttpSession currentSession = request.getSession(false);
	    		ContextHolder.setSession(currentSession);//绑定当前线程
	        	
	    		
	    		//UserOnlinePool.tokenOnlinePool.put(currentSession.getId(), token);
	    		cacheManager.storeOnlineUser(request.getSession(true).getId(), loginUser);
	    		
	        }else{
	        	result.setSuccess(false);
	        	result.setMessage("用户密码不正确");
	        	return result;
	        }
	        
	        result.addAttribute(JsonResultDO.RETURN_OBJECT_KEY, "success");  
	        result.setSuccess(true);
	        result.setStatusCode("0");
	        
	        //loginOperator(request, user);//登录成功后相关操作
	        return result;
	    }
	  
	  	/**
	     * 用户账户校验
	     *
	     * @param userParam 用户账户信息
	     */
	    private UserDO checkLoginUser(UserDO userParam) {
	        UserDO loginUser = userService.getUserByPhone(userParam.getPhone());
	        if (loginUser == null) {//手机号码获取不到，用登录名获取
	        	if(!StringUtils.isEmpty(userParam.getUserLoginCode())){
	        		loginUser = userService.getUserByLoginUserCode(userParam.getUserLoginCode());
	        	}
	        }
	        
	        if(loginUser != null){
	        	return loginUser;
	        }
	        return null;// 验证 用户不存在 
	    }
	    
	    
}
