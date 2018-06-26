package com.zyd.constants;

/**
 * 
 * 服务类型
 * 
 * @author Zhu Xiang
 *
 */

public enum ApplicationStatus {

	 	init(1,"待申请"),
	 	apply(2,"申请待校验"),
	 	waitPhoneCheck(3,"待电核"),
	 	waitFirstReview(4,"待初审"),
		waitHouseCheck(5,"待下户"),
	 	waitSecondReview(6,"待复审"),
	 	waitFinalReview(7,"待终审"),
	 	waitSign(8,"待面签"),
	 	waitLoan(9,"待放款"),
	 	loan(10,"待放款");
	
	    public Integer code;
	    public String name;

	    ApplicationStatus(Integer code,String name){
	        this.code = code;
	        this.name = name;
	    }

	    
}
