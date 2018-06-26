package com.zyd.dao;

import com.zyd.model.auth.MenuDo;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Zhu Xiang
 */
public interface IAuthItemDao extends Mapper<MenuDo>{
	
	int insertAuthItem(MenuDo menuDo);
	
}
