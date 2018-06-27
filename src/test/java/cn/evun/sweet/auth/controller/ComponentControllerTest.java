package cn.evun.sweet.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.controller.ComponentController;

public class ComponentControllerTest {
	
	@Test
	public void suppose_generate_verifycode_successful(){
		 ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		 ComponentController cc = act.getBean(ComponentController.class);
		 
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);  
		 
		
		 
		
	}

	
	
	
}
