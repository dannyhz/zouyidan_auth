package com.zyd.common.quartz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.zyd.dao.ILoanApplicationDao;
import com.zyd.model.LoanApplicationDO;
import com.zyd.model.ProductDO;
import com.zyd.profile.ProjectProcess;
import com.zyd.profile.ProjectProfileManager;
import com.zyd.profile.ProjectSetting;


public class StartNewSubProcessTaskJob implements Job{

	//private static final Logger LOGGER = StartNewSubProcessTaskJob.getLogger();

	
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		//LOGGER.info("开始执行 - 每日跑明细凭证的任务 ， 执行时间 ：  " + DateUtils.getDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		
		ILoanApplicationDao applicationDao = (ILoanApplicationDao)jobContext.getJobDetail().getJobDataMap().get("applicationDao");
		ProjectProfileManager manager = (ProjectProfileManager)jobContext.getJobDetail().getJobDataMap().get("profileManager");
		
		LoanApplicationDO application = new LoanApplicationDO();
		//application.setLoanApplicationId(1L);
		List<LoanApplicationDO> list = applicationDao.queryApplicationByDate(application);
		System.out.println("size = " + list.size());
        
		ProjectSetting ps = manager.profileMap.get("fdt_common");
		Map processMap = new HashMap();
		for(ProjectProcess pp : ps.processList){
			processMap.put(pp.getScanPreStts(), pp);
		}
		
		for(LoanApplicationDO app : list){
			
			//app.getProductId();
			ProductDO pdo = new ProductDO();
			
			ProjectProcess pp = (ProjectProcess) processMap.get(app.getStatus());
			
			//updateNextStatus(app, pp.waitStts);
			
			//assignNewScenarioTask(pdo,pdo.getCityId(),pp.getRoleId(),pp.getOperator(),pp.getUnit());
		}
		
		
        //LOGGER.info("完成执行 ， 完成时间 ：  " + DateUtils.getDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}

}
