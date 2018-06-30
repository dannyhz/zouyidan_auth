package com.zyd.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.model.ProductDO;
import com.zyd.model.SalesmanDO;
import com.zyd.util.DateUtil;

public class ProductDaoTest {
	ApplicationContext act = null;
	
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });	
	}
	
	@Test
	public void suppose_insert_product_success(){
		IProductDao productDao = act.getBean(IProductDao.class);
		ProductDO pd = new ProductDO();
		pd.setChannelId(100L);
		pd.setCityId(110);
		pd.setStatus("W");
		pd.setProductDesc("ABCD");
		pd.setProductLoaneeDesc("sdfsdf");
		pd.setProductUsageDesc("33333");
		productDao.insertProduct(pd);
	}

	
	@Test
	public void suppose_update_product_success(){
		IProductDao productDao = act.getBean(IProductDao.class);
		ProductDO pd = new ProductDO();
		pd.setStatus("A");
		pd.setProductId(80002L);
		System.out.println(productDao.updateProduct(pd));
	}
	
	@Test
	public void suppose_query_salesman_success(){
		IProductDao productDao = act.getBean(IProductDao.class);
		ProductDO pd = new ProductDO();
		pd.setProductId(80002L);
		
		List<ProductDO> productList = productDao.queryProduct(pd);
		System.out.println(productList.size());
		if(productList.size() > 0){
			System.out.println(productList.get(0).getChannelId());
			System.out.println(productList.get(0).getProductDesc());
			System.out.println(productList.get(0).getStatus());
		}
	}
}
