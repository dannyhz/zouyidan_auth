package com.zyd.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.service.UserService;

public class BaseControllerTest {
	
	@Test
	public void suppose_get_instance(){
		 ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		 UserService baseService = act.getBean(UserService.class);
		 System.out.println(baseService); 
		 
	}
	
	

}
