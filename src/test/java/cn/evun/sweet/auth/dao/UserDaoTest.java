package cn.evun.sweet.auth.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.dao.IUserDao;
import com.zyd.model.UserDO;

public class UserDaoTest {
	
	@Test
	public void suppose_add_new_user_successful(){
		
		ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		IUserDao ac = act.getBean(IUserDao.class);
		
		UserDO user = new UserDO();
		
		user.setUserLoginCode("mike");
		user.setStatus("A");
		user.setUserName("李雷");
		user.setPhone("13300000000");
		user.setPassword("123456");
		
		ac.insertUser(user);
		
		
	}

	
	@Test
	public void suppose_query_user_successful(){
		
		ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		IUserDao ac = act.getBean(IUserDao.class);
		
		UserDO user = new UserDO();
		
		user.setUserLoginCode("mike");
		user.setPhone("13300000000");
		user.setPassword("123456");
		
		List<UserDO> list = ac.queryUser(user);
		 
		if(list.size() > 0){
			System.out.println(list.get(0).getUserLoginCode() + "-" + list.get(0).getUserName());
		}
		
		
	}
}
