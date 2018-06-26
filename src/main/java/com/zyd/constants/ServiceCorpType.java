package com.zyd.constants;

/**
 * 
 * 服务类型
 * 
 * @author Zhu Xiang
 *
 */

public enum ServiceCorpType {

	 	phoneCheck(0,"电核"),
	    houseCheck(1,"下户");

	    public Integer type;
	    public String name;

	    ServiceCorpType(Integer type,String name){
	        this.type = type;
	        this.name = name;
	    }

	    
}
