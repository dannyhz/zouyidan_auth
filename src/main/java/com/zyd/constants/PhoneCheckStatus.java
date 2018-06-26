package com.zyd.constants;

/**
 * 
 * 服务类型
 * 
 * @author Zhu Xiang
 *
 */

public enum PhoneCheckStatus {

		WAIT_CORP_ASGN(1,"等待服务商布置"),
		WAIT_ACPT_ASGN(2,"等待办事员接受任务"),
		WAIT_PHONE_CHECK(3,"等待实际电核"),
		WAIT_REVIEW_PHONE_CHECK(4,"待平台比较"),
		PHONE_CHECK_PASS(5,"平台通过比较");
	
	    public Integer code;
	    public String description;

	    PhoneCheckStatus(Integer code,String description){
	        this.code = code;
	        this.description = description;
	    }

	    
}
