package com.zyd.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.service.BaseService;

public class BaseControllerTest {
	
	@Test
	public void suppose_get_instance(){
		 ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		 BaseService baseService = act.getBean(BaseService.class);
		 System.out.println(baseService); 
		 
	}
	
	

}
