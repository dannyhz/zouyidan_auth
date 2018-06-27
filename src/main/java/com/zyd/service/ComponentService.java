package com.zyd.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zyd.cache.CacheManager;

import cn.evun.sweet.common.util.StringUtils;
import cn.evun.sweet.common.util.web.CookieHelper;

/**
 * 配合ComponentController使用的公共业务组件服务类
 *
 * @author yangw
 * @since 1.0.0
 */
@Service
public class ComponentService {

    protected static final Logger LOGGER = LogManager.getLogger();

    @Value("${ons.topic:}")
    private String topic;
    @Value("${payment.appkey:}")
    private String appkey;
    @Value("${payment.url:}")
    private String url;
    @Value("${payment.queryUrl:}")
    private String queryUrl;
    @Value("${payment.queryAccountCheckingUrl:}")
    private String queryAccountCheckingUrl;
    @Value("${app.env:dev}")
    private String appEnv;//应用环境
    
    @Resource
    private CacheManager cacheManager;

    public String getAppEnv() {
        return appEnv;
    }


    /**
     * 检查图片验证码是否正确，使用前请先调用发送图片验证码接口。
     */
    public boolean checkVerifyCode(HttpServletRequest request, String reqVerifyCode) {
        String checkId = CookieHelper.getCookieValue(request, CacheManager.ZYD_LOGIN_VERIFY_CODE);
        if (StringUtils.isEmpty(checkId)) {//无法获取存放验证码的位置，所以这里做false处理。
            return false;
        }
        String storedVerifyCode = cacheManager.retrieveVerifyCode(CacheManager.ZYD_LOGIN_VERIFY_CODE + "_" + checkId);
        if (StringUtils.hasText(reqVerifyCode) && reqVerifyCode.equalsIgnoreCase(storedVerifyCode)) {
            cacheManager.clearVerifyCode(CacheManager.ZYD_LOGIN_VERIFY_CODE + "_" + checkId);//验证后立即清除验证码
            return true;
        }
        return false;
    }

 
    

    /**
     * 生成投订单号
     */
//    public String generateOrderNO() {
//        return System.currentTimeMillis() + String.format("%07d", RedisTemplateUtil.atomicLong("balanceDetailId"));
//    }

    /**
     * 使用默认topic发送ONS消息
     *
     * @param tag 消息标签
     * @param obj 消息体
     */
//    public void sendOnsMessage(String tag, Object obj) {
//        onsMQService.sendAsync(new OnsMessage(topic, tag, obj), null);
//    }

}
