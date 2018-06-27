package cn.evun.sweet.auth.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.evun.sweet.auth.model.dto.TenantDTO;
import cn.evun.sweet.core.common.JsonResultDO;

public class AuthControllerTest {
	
	@Test
	public void suppose_query_all_tenantList_successful(){
		 ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		 AuthController ac = act.getBean(AuthController.class);
		 TenantDTO param = new TenantDTO();
		 
		 JsonResultDO rsltDo = ac.tenantList(param,1,2);
		 
		 System.out.println(rsltDo.getDatas().size());
		
	}

	///auth/item/tablist
	@Test
	public void suppose_query_all_tabList_successful(){
		 ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		 AuthController ac = act.getBean(AuthController.class);
		 TenantDTO param = new TenantDTO();
		 
		 JsonResultDO rsltDo = ac.itemTabList();
		 
		 System.out.println(rsltDo.getDatas().size());
		
	}
	
	
}
