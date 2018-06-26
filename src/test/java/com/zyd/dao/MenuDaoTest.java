package com.zyd.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.zyd.model.auth.MenuDo;
import com.zyd.model.auth.SysAuth;
import com.zyd.model.auth.SysRole;

public class MenuDaoTest {
	ApplicationContext act = null;
	
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });	
	}
	
	@Test
	public void suppose_insert_menu_success(){
		IMenuDao menuDao = act.getBean(IMenuDao.class);
		
		MenuDo menuDo = new MenuDo();
		menuDo.setMenuId(100L);
		menuDo.setItemURL("user/assets/detail/");
		menuDo.setMenuParentId(null);
		menuDo.setMenuName("根节点");
		
		menuDao.insert(menuDo);
		
	}
	
	@Test
	public void suppose_delete_sys_auth_by_role_success(){
		ISysAuthDao sysAuthDao = act.getBean(ISysAuthDao.class);
		SysRole role = new SysRole();
		role.setRoleId(100L);
		sysAuthDao.deleteAuthByRole(role);
	}
	

	@Test
	public void suppose_get_json(){
		
		List<SysAuth> authList = new ArrayList();
		
		SysAuth auth = new SysAuth();
		auth.setAuthLevel(2);
		auth.setMenuId(1L);
		auth.setMenuCode("cwb");
		auth.setName("财务部");
		auth.setParentId(null);
		auth.setPath("/cwb/");
		auth.setRoleId(100L);
		authList.add(auth);
		
		auth = new SysAuth();
		auth.setAuthLevel(3);
		auth.setMenuId(2L);
		auth.setMenuCode("cwb/1g");
		auth.setName("财务部一组");
		auth.setParentId(1L);
		auth.setPath("/cwb/1");
		auth.setRoleId(100L);
		authList.add(auth);
		
		auth = new SysAuth();
		auth.setAuthLevel(3);
		auth.setMenuId(3L);
		auth.setMenuCode("cwb/2g");
		auth.setName("财务部二组");
		auth.setParentId(1L);
		auth.setPath("/cwb/2");
		auth.setRoleId(100L);
		authList.add(auth);
		
		
		System.out.println(JSON.toJSONString(authList));
		
		
	}
	
	
	@Test
	public void suppose_get_list(){
		String content = "[{\"authLevel\":2,\"menuCode\":\"cwb\",\"menuId\":1,\"name\":\"财务部\",\"path\":\"/cwb/\",\"roleId\":100},{\"authLevel\":3,\"menuCode\":\"cwb/1g\",\"menuId\":2,\"name\":\"财务部一组\",\"parentId\":1,\"path\":\"/cwb/1\",\"roleId\":100},{\"authLevel\":3,\"menuCode\":\"cwb/2g\",\"menuId\":3,\"name\":\"财务部二组\",\"parentId\":1,\"path\":\"/cwb/2\",\"roleId\":100}]";
		List<SysAuth> list = JSON.parseArray(content, SysAuth.class);
		System.out.println(list.size());
		System.out.println(list.get(1).getName());
	}
}
