package com.zyd.dao;

import com.zyd.model.LoanApplicationDO;
import com.zyd.model.auth.MenuDo;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Zhu Xiang
 */
public interface IMenuDao extends Mapper<MenuDo>{
	
	int insertMenu(MenuDo menuDo);
	
}
