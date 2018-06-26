package com.zyd.dao;

import java.util.List;

import com.zyd.model.SalesmanDO;
import com.zyd.model.auth.MenuDo;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Zhu Xiang
 */
public interface ISalesmanDao extends Mapper<SalesmanDO>{
	
	int insertSalesman(SalesmanDO salesmanDo);
	
	int update(SalesmanDO salesmanDo);
	
	List<SalesmanDO> queryList(SalesmanDO salesmanDo);
}
