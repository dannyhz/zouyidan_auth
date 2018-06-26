package com.zyd.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.dto.LoanApplicationDTO;
import com.zyd.model.LoanApplicationDO;
import com.zyd.service.BaseService;

public class LoanApplicationDaoTest {
	ApplicationContext act = null;
	
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });	
	}
	
	@Test
	public void suppose_insert_loan_application_success(){
		 ILoanApplicationDao loanAppDao = act.getBean(ILoanApplicationDao.class);
		 //System.out.println(loanAppDao);
		 LoanApplicationDO loanApp = new LoanApplicationDO();
		 loanApp.setLoaneeId(1000L);
		 loanApp.setStatus("COMMIT");
		 loanAppDao.insert(loanApp);
		
	}

	@Test
	public void suppose_query_loan_application_by_person_id(){
		 ILoanApplicationDao loanAppDao = act.getBean(ILoanApplicationDao.class);
		 LoanApplicationDO loanAppDO = new LoanApplicationDO();
		 loanAppDO.setLoanApplicationId(1L);
		 List<LoanApplicationDO> list =  loanAppDao.queryApplicationById(loanAppDO);
		 System.out.println(list.size()); 
	}
	
	@Test
	public void suppose_query_loan_application_by_status(){
		 ILoanApplicationDao loanAppDao = act.getBean(ILoanApplicationDao.class);
		 LoanApplicationDO loanAppDO = new LoanApplicationDO();
		 
		 List<LoanApplicationDO> list =  loanAppDao.queryLoanApplicationByStatus(loanAppDO);
		 LoanApplicationDO application = list.get(0);
		 
		 
		 System.out.println(application.getTemplateCode()); 
	}
	
	@Test
	public void suppose_update_status_by_application_Id(){
		ILoanApplicationDao loanAppDao = act.getBean(ILoanApplicationDao.class);
		LoanApplicationDO loanAppDO = new LoanApplicationDO();
		loanAppDO.setLoanApplicationId(1L);
		loanAppDO.setStatus("COMMIT");
		System.out.println("return = " + loanAppDao.updateById(loanAppDO));
	}
	
}
