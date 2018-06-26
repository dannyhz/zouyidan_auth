package com.zyd.common.xml;

import java.io.File;

import org.junit.Test;


public class ProductProcessTemplateTest {
	
	@Test
	public void parseTempate(){
		//String path = System.getProperty("user.dir");
		String path = "template/fdt01.xml";
		//String filePath = path + File.separator + "template" + File.separator + "fdt01.xml";
		//String filePath = path + File.separator + "template" + File.separator + "template.xml";
		//System.out.println(path);
		
		ProductProcessXmlParser.parse(path);
	}

}
