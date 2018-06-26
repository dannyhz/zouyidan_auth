package com.zyd.profile;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.common.quartz.QuartzManager;
import com.zyd.common.quartz.StartNewSubProcessTaskJob;
import com.zyd.dao.ILoanApplicationDao;

public class ProfileMechanismTest {
	
	@Test
	public void suppose_save_new_task_success(){
		
		ProjectProfileManager manager = new ProjectProfileManager();
	
		ProjectSetting ps = new ProjectSetting();
		
		ps.cityId = "hangzhou";
		
		ProjectProcess pp1 = new ProjectProcess();
		pp1.sequence = 1;
		pp1.id = "first_review";
		pp1.code = "FR";
		pp1.scanPreStts = "COMMIT";
		pp1.passStts = "FR_PASS";
		pp1.waitStts = "FR_WAIT";
		pp1.failStts = "FR_FAIL";
		
		ProjectProcess pp2 = new ProjectProcess();
		pp2.sequence = 2;
		pp2.id = "phone_check";
		pp2.code = "PC";
		pp2.scanPreStts = "FR_PASS";
		pp2.passStts = "PC_PASS";
		pp2.waitStts = "PC_WAIT";
		pp2.failStts = "PC_FAIL";
		
		ps.processList.add(pp1);
		ps.processList.add(pp2);
		
		manager.profileMap.put("fdt_common", ps);
		
		ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		
		QuartzManager qm = act.getBean(QuartzManager.class);
		 ILoanApplicationDao loanAppDao = act.getBean(ILoanApplicationDao.class);
		 
		 Map map = new HashMap();
		 map.put("applicationDao", loanAppDao);
		 map.put("profileManager", manager);
		 
		 qm.addJob("newProcessTaskJob", "newProcessTaskJobGroup", "newProcessTaskJobTrigger", 
					"newProcessTaskJobTriggerGroup", StartNewSubProcessTaskJob.class,"0/10 * * * * ?", map); // 每分钟 检查一次 状态是 commit的
		 qm.startJobs();
		 
		 while(true){
			 
		 }
		
	}

}
