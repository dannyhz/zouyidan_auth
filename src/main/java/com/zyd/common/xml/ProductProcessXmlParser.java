package com.zyd.common.xml;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import com.zyd.model.ProductProcessDO;
import com.zyd.model.ProductProcessTemplateDO;

public class ProductProcessXmlParser {
	
	private final static Logger	LOGGER	= Logger.getLogger(ProductProcessXmlParser.class);
	
	public static ProductProcessTemplateDO parse(String configFile) {
		
		ProductProcessTemplateDO model = new ProductProcessTemplateDO();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            InputStream in = ProductProcessXmlParser.class.getClassLoader().getResourceAsStream(configFile);
            Document doc = builder.parse(in);
            // root 
            Element root = doc.getDocumentElement();
            if (root == null) {
            	return model;
            }
            model.id = root.getAttribute("id");
            model.city = root.getAttribute("city");
            
            // all 'process' node
            NodeList processNodeList = root.getElementsByTagName("process");
            //process node 数目
            System.out.println(processNodeList.getLength());
            for(int i = 0; i < processNodeList.getLength(); i++) {
            	
            	ProductProcessDO ppd = new ProductProcessDO();
            	
            	  Node processNode = processNodeList.item(i);
            	  //System.out.println(processNode.getTextContent());
            	  if (processNode != null && processNode.getNodeType() == Node.ELEMENT_NODE) {
            		  ppd.id = processNode.getAttributes().getNamedItem("id").getNodeValue();
            		  String seq = processNode.getAttributes().getNamedItem("sequence").getNodeValue();
            		  ppd.sequence = seq != null ? Integer.parseInt(seq) : 0;
            		  ppd.operator = processNode.getAttributes().getNamedItem("operator").getNodeValue();
            	  }
            	  model.addProcess(ppd);
            	  
            }
            
           
           
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		return model;
	}
	

}
