package com.zyd.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zyd.dao.IProductDao;
import com.zyd.model.ProductDO;

@Component
public class ProductService {
	@Resource
	private IProductDao productDao;
	
	public ProductDO createNewProduct(ProductDO product){
		productDao.insertProduct(product);
		
		return product;
	}

}
