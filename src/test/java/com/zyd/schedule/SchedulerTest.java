package com.zyd.schedule;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.common.quartz.QuartzManager;
import com.zyd.common.quartz.StartNewSubProcessTaskJob;
import com.zyd.dao.ILoanApplicationDao;
import com.zyd.model.LoanApplicationDO;

public class SchedulerTest {
	
	ApplicationContext act = null;
	
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });	
	}
	
	
	@Test
	public void scheduleTest(){
		 ILoanApplicationDao loanAppDao = act.getBean(ILoanApplicationDao.class);
		 
		 QuartzManager qm = act.getBean(QuartzManager.class);
		 
		 Map map = new HashMap();
		 map.put("applicationDao", loanAppDao);
		 
		 qm.addJob("newProcessTaskJob", "newProcessTaskJobGroup", "newProcessTaskJobTrigger", 
					"newProcessTaskJobTriggerGroup", StartNewSubProcessTaskJob.class,"0 * * * * ?", map); // 每分钟 检查一次 状态是 commit的
		 qm.startJobs();
		 
		 while(true){
			 
		 }
	}

}
