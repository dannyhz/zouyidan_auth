package com.zyd.service;

import java.util.List;

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
	
	public ProductDO publish(ProductDO product){
		product.setStatus("A");
		productDao.updateProduct(product);
		return product;
	}
	
	public ProductDO shutdown(ProductDO product){
		product.setStatus("T");
		productDao.updateProduct(product);
		return product;
	}

	
	public ProductDO queryProduct(ProductDO product){
		List<ProductDO> productList = productDao.queryProduct(product);
		
		if(productList != null && productList.size() > 0){
			return productList.get(0);
		}
		return null;
	}
	
	public List<ProductDO> list(ProductDO product){
		List<ProductDO> productList = productDao.queryProduct(product);
		System.out.println(productList.size());
		return productList;
	}
}
