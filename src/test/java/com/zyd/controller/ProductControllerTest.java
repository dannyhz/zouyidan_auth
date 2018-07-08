package com.zyd.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.model.ProductDO;
import com.zyd.service.UserService;

import cn.evun.sweet.core.common.JsonResultDO;

public class ProductControllerTest {
	
	@Test
	public void suppose_list_product(){
		 ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		 ProductController controller = act.getBean(ProductController.class);
		 ProductDO prooductDO = new ProductDO();
		 JsonResultDO resultDO = controller.list(prooductDO, 2, 1);
		 List<ProductDO> list = (List<ProductDO>)resultDO.getDatas().get(JsonResultDO.RETURN_OBJECT_KEY);
		 System.out.println(list.size()); 
		 
	}
	
	

}
