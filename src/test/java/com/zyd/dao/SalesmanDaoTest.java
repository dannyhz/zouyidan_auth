package com.zyd.dao;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.model.SalesmanDO;
import com.zyd.util.DateUtil;

public class SalesmanDaoTest {
	ApplicationContext act = null;
	
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });	
	}
	
	@Test
	public void suppose_insert_salesman_success(){
		ISalesmanDao salesmanDao = act.getBean(ISalesmanDao.class);
		SalesmanDO sm = new SalesmanDO();
		sm.setChannelId(100L);
		sm.setMemo("每屏秀秀 yeyeye");
		sm.setContactAddress("皇后大道东213号");
		sm.setEmail("jack@qq.com");
		sm.setPhoneNo("13758487541");
		sm.setRegisterDate(new Date());
		salesmanDao.insert(sm);
	}

	
	@Test
	public void suppose_update_salesman_success(){
		ISalesmanDao salesmanDao = act.getBean(ISalesmanDao.class);
		SalesmanDO sm = new SalesmanDO();
		sm.setChannelId(100L);
		sm.setMemo("每屏秀秀 yeyeye");
		sm.setContactAddress("皇后大道东213号");
		sm.setEmail("jack@qq.com");
		sm.setPhoneNo("13758487541");
		sm.setLastUpdatedAt(DateUtil.getFormatedDate("20180624 171212","yyyyMMdd HHmmss"));
		
		sm.setSalesmanId(40002L);
		System.out.println(salesmanDao.update(sm));
	}
	
	@Test
	public void suppose_query_salesman_success(){
		ISalesmanDao salesmanDao = act.getBean(ISalesmanDao.class);
		SalesmanDO sm = new SalesmanDO();
		sm.setChannelId(1L);
		
		sm.setSalesmanId(40002L);
		
		sm.setUserName("业务员B");
		
		List<SalesmanDO> salesmanList = salesmanDao.queryList(sm);
		System.out.println(salesmanList.size());
		if(salesmanList.size() > 0){
			System.out.println(salesmanList.get(0).getChannelId());
			System.out.println(salesmanList.get(0).getUserName());
			System.out.println(salesmanList.get(0).getChannelName());
		}
	}
}
