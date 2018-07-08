package com.zyd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.evun.sweet.common.util.BeanUtils;
import cn.evun.sweet.core.common.JsonResultDO;
import cn.evun.sweet.core.mybatis.page.PageDTO;
import cn.evun.sweet.core.mybatis.page.PageHelper;

import com.zyd.dto.AuthDTO;
import com.zyd.model.ProductDO;
import com.zyd.service.ProductService;

@RestController
public class ProductController {
	
	@Resource
	private ProductService productService;
	
	 
	 @RequestMapping("/product/add")
	 public JsonResultDO addProduct(ProductDO prooductDO) {
		 
		 JsonResultDO rslt = new JsonResultDO();
		 productService.createNewProduct(prooductDO);
		 
		 return rslt; 
	 }
	 
	 @RequestMapping("/product/publish")
	 public JsonResultDO publish(ProductDO prooductDO) {
		 
		 JsonResultDO resultDO = new JsonResultDO();
		 
		 ProductDO product = productService.queryProduct(prooductDO);
		 if(product == null){
			 resultDO.setSuccess(false);
			 resultDO.setMessage("查询不到产品");
	         return resultDO;
		 }
		 productService.publish(product);
		 
		 resultDO.setSuccess(true);
		 resultDO.setMessage("发布成功");
		 
		 return resultDO;
	 }
	 
	 @RequestMapping("/product/shutdown")
	 public JsonResultDO shutdown(ProductDO prooductDO) {
		 
		 JsonResultDO resultDO = new JsonResultDO();
		 
		 ProductDO product = productService.queryProduct(prooductDO);
		 if(product == null){
			 resultDO.setSuccess(false);
			 resultDO.setMessage("查询不到产品");
	         return resultDO;
		 }
		 productService.shutdown(product);
		 
		 resultDO.setSuccess(true);
		 resultDO.setMessage("发布成功");
		 
		 return resultDO;
	 }
	 
	 @RequestMapping(value= "/product/list", method = RequestMethod.GET)
	 public JsonResultDO list(ProductDO prooductDO, 
			    @RequestParam(value="pageNum",defaultValue="1")Integer pageNum, 
				@RequestParam(value="pageSize",defaultValue="5")Integer pageSize) {
		 	
		 	JsonResultDO resultDO = new JsonResultDO();

		 	PageHelper.startPage(pageNum, pageSize);

		 	List<ProductDO> list = productService.list(new ProductDO());

			PageDTO pagebar = new PageDTO();
			BeanUtils.copyProperties(list, pagebar);
			resultDO.addAttribute(JsonResultDO.RETURN_OBJECT_KEY, list);
			resultDO.addAttribute(JsonResultDO.RETURN_PAGEBAR_KEY, pagebar);
			return resultDO;

	 }
}
