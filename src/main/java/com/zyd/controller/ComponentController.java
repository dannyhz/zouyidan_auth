package com.zyd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.service.ComponentService;

import cn.evun.sweet.common.util.UUIDGenerator;
import cn.evun.sweet.common.util.VerifyCodeUtils;
import cn.evun.sweet.common.util.network.NetUtils;
import cn.evun.sweet.common.util.web.CookieHelper;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 通用基础业务组件，一般情况下，可以需要结合ComponentService使用。
 *
 * @author xuzj
 * @since 1.0.0
 */
@RestController
public class ComponentController {

    protected static final Logger LOGGER = LogManager.getLogger();

    private static final int CODE_EFFECTIVE_TIME = 600;//验证码失效时间10分钟

    @Autowired
    private ComponentService componentService;
//    @Autowired
//    private UserService userService;

//    /**************************************短信验证码业务*********************************************/
//    /**
//     * 验证手机验证码，适用于手机获取验证码并提交验证码没有其他业务的情况。
//     *
//     * @param mobile     手机号
//     * @param code       使用验证码的业务场景编号，用于话术模板
//     * @param verifyCode 手机验证码
//     */
//    @RequestMapping(value = "/public/smscode/verify/{code}", method = RequestMethod.GET)
//    public JsonResultDO checkVerifyCode(@RequestParam("verifyCode") String verifyCode, 
//    			@RequestParam("mobile")String mobile, @PathVariable String code) {
//        if (!componentService.checkSMSVerifyCode(mobile, code, verifyCode)) {
//            throw new ValidateException("user.sms.verifycode");
//        }
//        return JsonResultDO.EMPTY_RESULT;
//    } 
//
//    /**
//     * 发送验证码短信
//     *
//     * @param mobile 手机号码
//     * @param code   使用验证码的业务场景编号，用于话术模板。
//     * @param randomCode 
//     * @param verifyImgCode  图形验证码
//     * @see MessageCodeEnum
//     */
//    @RequestMapping(value = "/public/smscode/{code}", method = RequestMethod.GET)
//    @HystrixCommand(ignoreExceptions = {RuntimeException.class})
//    public JsonResultDO verifyCodeSms(HttpServletRequest request, @RequestParam("mobile") String mobile, @PathVariable String code, @RequestParam String randomCode, String verifyImgCode) {
//    	String cacheRepeatKey = "verifyCodeSms_" + mobile + "_" + code;
//		String value = RedisTemplateUtil.get(cacheRepeatKey);
//		if (!StringUtils.isEmpty(value)) {
//			return JsonResultDO.EMPTY_RESULT;
//		}
//    	String smsCountKey = null;
//        String errorCountKey = null;
//    	if(!randomCode.equals("dsf4r08glxu5u34534fLJIE3a")){
//	    	smsCountKey = R_Transaction.Cache.NEED_IMAGECODE_INPUT + code + "_" + mobile;
//	        errorCountKey = R_Transaction.Cache.IMAGECODE_ERRORINPUT + code + "_" + randomCode;
//	        /*手机验证码获取两次需要输入图片验证码*/
//	        String errorCount = RedisTemplateUtil.getString(errorCountKey);
//	        String smsCount = RedisTemplateUtil.getString(smsCountKey);
//	       
//	        if ((StringUtils.hasLength(smsCount) && Integer.parseInt(smsCount) > R_Transaction.Constant.VERIFYCODE_IMAGE_ERRORCOUNT)
//	        		|| (StringUtils.hasLength(errorCount) && Integer.parseInt(errorCount) > R_Transaction.Constant.VERIFYCODE_IMAGE_ERRORCOUNT)
//	        		) {
//	        	 if (!componentService.checkVerifyCode(request, verifyImgCode)) {
//		                throw new ValidateException("user.sms.verifycode.image");
//	        	 }else{
//	        	   	 RedisTemplateUtil.delete(smsCountKey);
//	        	   	 RedisTemplateUtil.delete(errorCountKey);
//	        	 }
//	        }
//    	}
//        if (!CommonUtil.checkMobile(mobile)) {
//            throw new ValidateException("user.sms.mobile.format");
//        }
//        //过滤私有的code
//        String[] codes = new String[]{"0001","0003","0005","0009","0024","0025","0036"};
//        if(!ObjectUtils.containsElement(codes, code)){
//        	throw new ValidateException("base.operation.auth");
//        }
//        
//        if (MessageCodeEnum.FORGETLOGIN_PWD.getCode().equals(code)){
//        	if (!userService.checkMobileExist(mobile)){
//        		throw new ValidateException("user.sms.mobile.notexist");
//        	}
//        }
//        /*发送短信并登记验证码,设置有效时间*/
//        String smscode = componentService.sendSms(mobile, code);
//        RedisTemplateUtil.set(PRINAME + code + "_" + mobile, smscode, CODE_EFFECTIVE_TIME);//10分钟有效时间
//        /*记录获取次数*/
//        if(!randomCode.equals("dsf4r08glxu5u34534fLJIE3a")){
//	        RedisTemplateUtil.atomicLongExpire(smsCountKey, 1800);
//	        RedisTemplateUtil.atomicLongExpire(errorCountKey, 1800);
//        }
//        RedisTemplateUtil.set(cacheRepeatKey, "1", 60);
//        return new JsonResultDO();
//    }
//    
//    /**
//     * 发送验证码短信(需要登录)
//     *
//     * @param mobile 手机号码
//     * @param code   使用验证码的业务场景编号，用于话术模板。
//     * @param randomCode
//     * @param verifyImgCode  图形验证码
//     * @see MessageCodeEnum
//     */
//    @RequestMapping(value = "/smscode/{code}", method = RequestMethod.GET)
//    @HystrixCommand(ignoreExceptions = {RuntimeException.class})
//    public JsonResultDO verifyCodeSmsLogin(HttpServletRequest request, @RequestParam String mobile, @PathVariable String code) {
//      	String cacheRepeatKey = "verifyCodeSmsLogin_" + mobile + "_" + code;
//		String value = RedisTemplateUtil.get(cacheRepeatKey);
//		if (!StringUtils.isEmpty(value)) {
//			return JsonResultDO.EMPTY_RESULT;
//		}
//    	if (MessageCodeEnum.BALANCE_OPEN.getCode().equals(code) || MessageCodeEnum.BIND_CARD.getCode().equals(code)){
//    		LOGGER.warn(R_Transaction.Log.log_marker_component, "绑卡或开户【code:{}】，发送验证码到手机号{}]", code, mobile);
//    	}
//    	if (!CommonUtil.checkMobile(mobile)) {
//            throw new ValidateException("user.sms.mobile.format");
//        }
//    	
//        /*发送短信并登记验证码,设置有效时间*/
//        String smscode = componentService.sendSms(mobile, code);
//        RedisTemplateUtil.set(PRINAME + code + "_" + mobile, smscode, CODE_EFFECTIVE_TIME);//10分钟有效时间
//        RedisTemplateUtil.set(cacheRepeatKey, "1", 60);
//        return new JsonResultDO();
//    }
//
//
//    /******************************************************图片验证码业务*************************************************************/
//
//    /**
//     * 查询用户是否需要输入图片验证码：针对在n次输入错误后需要出现图片验证码的场景
//     *
//     * @param randomCode 唯一标识
//     * @param code       使用验证码的业务场景编号，用于话术模板。
//     */
//    @RequestMapping(value = "/public/needverifycode/{code}", method = RequestMethod.GET)
//    public JsonResultDO needVerifyCode(@PathVariable String code, @RequestParam String randomCode, String mobile) {
//        /*手机验证码错误两次需要输入图片验证码*/
//        String smsCountKey = R_Transaction.Cache.NEED_IMAGECODE_INPUT + code + "_" + mobile;
//        String smsCount = RedisTemplateUtil.getString(smsCountKey);
//        String errorCount = RedisTemplateUtil.getString(R_Transaction.Cache.IMAGECODE_ERRORINPUT + code + "_" + randomCode);
//        boolean flag = false;
//        if ((StringUtils.hasLength(smsCount) && Integer.parseInt(smsCount) > R_Transaction.Constant.VERIFYCODE_IMAGE_ERRORCOUNT)
//        		|| (StringUtils.hasLength(errorCount) && Integer.parseInt(errorCount) > R_Transaction.Constant.VERIFYCODE_IMAGE_ERRORCOUNT)
//        		) {
//        	flag = true;
//        }    
//        JsonResultDO result = new JsonResultDO();
//        result.addAttribute(JsonResultDO.RETURN_OBJECT_KEY, flag);
//        return result;
//    }

    /******************************************************上传类业务*************************************************************/
    
    /**
     * 文件上传
     *
     * @param file 文件流
     */
//    @RequestMapping(value = "/file/upl", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonResultDO fileUpload(MultipartFile file) {
//        JsonResultDO result = new JsonResultDO();
//        String fileKey = FileUploadUtil.checkAndUpload(file);
//        result.addAttribute(JsonResultDO.RETURN_OBJECT_KEY, fileKey);
//        return result;
//    }
    

    /*******************************************************************************************************************/
    
  

}
