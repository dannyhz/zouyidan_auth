package com.zyd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyd.dto.LoanApplicationDTO;
import com.zyd.model.LoanApplicationDO;
import com.zyd.model.auth.MenuDo;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Zhu Xiang
 */
public interface ILoanApplicationDao extends Mapper<LoanApplicationDO>{
	
	/**
	 * @param order
	 * @return
	 *
	 */
	int insertApplication(LoanApplicationDO application);
	
	/**
	 * @param query
	 * @return
	 *
	 */
	int isExist(LoanApplicationDTO query);
	
	/**
	 * @param queryDO
	 * @return
	 *
	 */
	List<LoanApplicationDO> queryApplicationById(LoanApplicationDO queryDO);
	
	/**
	 * @param queryDO
	 * @return
	 *
	 */
	List<LoanApplicationDO> queryLoanApplicationByStatus(LoanApplicationDO queryDO);
	
	int updateById(LoanApplicationDO queryDO);
	
	List<LoanApplicationDO> queryApplicationByDate(LoanApplicationDO queryDO);

}
