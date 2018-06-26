package com.zyd.common;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesHolderTest {
	
	ApplicationContext act = null;
	
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
	}
	
	@Test
	public void suppose_get_property_from_config_file(){
		PropertiesHolder holder = act.getBean(PropertiesHolder.class);
		System.out.println(holder.getValue("zyd.jdbc.driverClassName"));
	}

}
