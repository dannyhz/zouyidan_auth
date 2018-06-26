package com.zyd.common.model;

import org.junit.Test;

import com.zyd.model.ProductProcessDO;
import com.zyd.model.ProductProcessTemplateDO;

public class ProductProcessTemplateDOTest {
	
	@Test
	public void suppose_compare_list_get_next(){
		
		ProductProcessTemplateDO processTemplate = new ProductProcessTemplateDO();
		ProductProcessDO ppd1 = new ProductProcessDO();
		ppd1.id = "aaa";
		ppd1.sequence = 2;
		ProductProcessDO ppd2 = new ProductProcessDO();
		ppd2.id = "bbb";
		ppd2.sequence = 4;
		
		ProductProcessDO ppd3 = new ProductProcessDO();
		ppd3.id = "ccc";
		ppd3.sequence = 1;
		
		ProductProcessDO ppd4 = new ProductProcessDO();
		ppd4.id = "ddd";
		ppd4.sequence = 3;
		
		
		processTemplate.addProcess(ppd1);
		processTemplate.addProcess(ppd2);
		processTemplate.addProcess(ppd3);
		processTemplate.addProcess(ppd4);
		
		System.out.println(processTemplate.getNextProcess(2).id);
		
	}

}
