package com.zyd.model.auth;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.zyd.model.auth.MenuDo;
import com.zyd.model.auth.MenuNode;

public class MenuNodeTest {
	
	@Test
	public void generateMenuNode(){
		
		MenuDo menuParent = new MenuDo();
		menuParent.itemURL="product";
		menuParent.menuId=100384L;
		menuParent.menuName = "产品详情查询";
		menuParent.menuAuthLevel = 2;
		
		
		MenuDo childMenu = new MenuDo();
		childMenu.itemURL="product/{productId}";
		childMenu.menuId=100385L;
		childMenu.menuName = "*散标产品详情查询";
		childMenu.menuAuthLevel = 3;
		childMenu.menuParentId = 100384L;
		List<MenuDo> menuList = new ArrayList<MenuDo>();
		
		menuList.add(childMenu);
		
		MenuNode mn = MenuNode.genMenuNode(menuList, menuParent, 3);
		
		System.out.println(JSON.toJSONString(mn));
		
		
	}

}
