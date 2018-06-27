package com.zyd.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
import cn.evun.sweet.core.cache.CacheAccessor;
import cn.evun.sweet.core.cas.Token;
import cn.evun.sweet.core.common.JsonResultDO;
import cn.evun.sweet.core.common.R;
import cn.evun.sweet.core.exception.ValidateException;
import cn.evun.sweet.core.validation.ValidateStep;

@RestController
public class BizLoginController {
	
	@Resource
	private UserService userService;
	@Resource
	private CacheManager cacheManager;
	@Resource
	private ComponentService componentService;
	
	  @ResponseBody
	  @RequestMapping(value = "/biz/helloWorld" , method = RequestMethod.GET)
	  public String sayHello(String hello) {
		  
		  System.out.println("---buy buy buy----");
		  
		  return null;
	  }	
	
	  @ResponseBody
	  @RequestMapping("/biz/namepass.do") 
	  public String login(HttpServletRequest request){ 
	    String name = request.getParameter("name"); 
	    String pass = request.getParameter("pass");
	    System.out.println("name = " + name);
	    return name;
	  } 
	  
	  
	  //---------------------
	  @RequestMapping(value="/biz/reqVerifyCode", method=RequestMethod.GET)
	  public void verifyCode(HttpServletRequest request, HttpServletResponse response){
		  try {
	            String checkId = UUIDGenerator.genUUID();
	            CookieHelper cookieHelper = new CookieHelper();
	            cookieHelper.setCookieName(cacheManager.ZYD_LOGIN_VERIFY_CODE);
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
	    public JsonResultDO loginajax(HttpServletRequest request, HttpServletResponse response, 
	    							String verifyCode, UserDO user) {
	        JsonResultDO result = new JsonResultDO();
	        if (!StringUtils.hasText(user.getPassword()) || !StringUtils.hasText(user.getPhone())) {
	            throw new ValidateException("trans.login.error.noneinput", "请输入账号和密码");
	        }

	        if (!componentService.checkVerifyCode(request, verifyCode)) {
	            throw new ValidateException("trans.login.error.verifycode", "验证码错误");
	        }      
	        String errCode = checkLoginUser(user);//用户账户校验
	        if (StringUtils.isEmpty(errCode)) {
	            throw new ValidateException(errCode, "用户账户校验未通过");
	        }
	        
	        /*验证都通过，开始创建JWT内容*/
//	        Token token = new Token();
//	        token.setUserIp(String.valueOf(request.getAttribute(R.request.mdc_ip)));//在filter中植入的ip地址信息
//	        token.setUserId(String.valueOf(user.getUserId()));
//	        token.setClientId(request.getHeader("AppClientId"));//手机端登录时通过请求头携带

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
	    private String checkLoginUser(UserDO userParam) {
	        UserDO loginUser = userService.getUserByPhone(userParam.getPhone());
	        if (loginUser == null) {//手机号码获取不到，用登录名获取
	        	if(!StringUtils.isEmpty(userParam.getUserLoginCode())){
	        		loginUser = userService.getUserByLoginUserCode(userParam.getUserLoginCode());
	        	}
	        }
	        if(loginUser == null){
	        	return "trans.login.error.notexist"; //账号不存在
	        }
	        return null;
	    }
}
