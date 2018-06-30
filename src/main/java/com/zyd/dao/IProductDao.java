package com.zyd.dao;

import java.util.List;

import com.zyd.model.ProductDO;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author Zhu Xiang
 */
public interface IProductDao extends Mapper<ProductDO>{
	
	int insertProduct(ProductDO product);
	
	int updateProduct(ProductDO product);
	
	List<ProductDO> queryProduct(ProductDO productDO);

}
