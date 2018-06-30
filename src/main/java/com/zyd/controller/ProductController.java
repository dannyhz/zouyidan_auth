package com.zyd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.evun.sweet.core.common.JsonResultDO;

import com.zyd.dto.AuthDTO;
import com.zyd.model.ProductDO;
import com.zyd.service.ProductService;

@RestController
public class ProductController {
	
	@Resource
	private ProductService productService;
	
	 
	 @RequestMapping("/product/add")
	 public JsonResultDO addProduct(ProductDO prooductDO) {
		 
		 System.out.println("");
		 JsonResultDO rslt = new JsonResultDO();
		 productService.createNewProduct(prooductDO);
		 
		 
		 
		 return rslt; 
	 }
	 
	 @RequestMapping("/product/publish")
	 public JsonResultDO publish(AuthDTO authDTO) {
		 return null;
	 }
	 
	 @RequestMapping(value= "/product/query/{productId}", method = RequestMethod.GET)
	 public JsonResultDO query(@PathVariable String productId) {
		 
		 System.out.println("productId = " + productId);
		 return null;
	 }
}
