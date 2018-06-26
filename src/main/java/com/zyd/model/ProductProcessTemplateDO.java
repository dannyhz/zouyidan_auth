package com.zyd.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//product id="fdt01" city="hangzhou" memo="房贷通_杭州版"
public class ProductProcessTemplateDO {
	
	public String id;
	public String city;
	public String memo;
	
	public ArrayList<ProductProcessDO> processList = new ArrayList<ProductProcessDO>();
	
	public void addProcess(ProductProcessDO processDO){
		processList.add(processDO);
	}
	
	public ProductProcessDO getNextProcess(int processSeq){
		Collections.sort(processList, new Comparator<ProductProcessDO>(){

			@Override
			public int compare(ProductProcessDO o1, ProductProcessDO o2) {
				return o1.sequence > o2.sequence ? 1:-1;
			}
			
		});
		
		
		for(ProductProcessDO  process : processList){
			if(process.sequence > processSeq){
				return process;
			}
		}
		
		return null;
	}
	
	
}
