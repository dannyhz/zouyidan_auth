package com.zyd.dao;

import java.util.List;

import com.zyd.model.TaskDO;
import com.zyd.model.auth.SysAuth;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Zhu Xiang
 */
public interface ITaskDao extends Mapper<TaskDO>{
	
	/**
	 * @param order
	 * @return
	 *
	 */
	int insertTask(TaskDO application);
	
	/**
	 * @param query
	 * @return
	 *
	 */
	int isExist(TaskDO query);
	
	/**
	 * @param queryDO
	 * @return
	 *
	 */
	List<TaskDO> queryTaskById(TaskDO queryDO);
	
	/**
	 * @param queryDO
	 * @return
	 *
	 */
	List<TaskDO> queryTaskByStatus(TaskDO queryDO);

}
