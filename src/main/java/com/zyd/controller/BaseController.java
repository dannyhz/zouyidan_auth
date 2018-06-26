package com.zyd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
	  @ResponseBody
	  @RequestMapping(value = "/helloWorld" , method = RequestMethod.GET)
	  public String sayHello(String hello) {
		  
		  System.out.println("---buy buy buy----");
		  
		  return null;
	  }	
	
	  @ResponseBody
	  @RequestMapping("/login.do") 
	  public String login(HttpServletRequest request){ 
	    String name = request.getParameter("name"); 
	    String pass = request.getParameter("pass");
	    System.out.println("name = " + name);
	    return name;
	  } 
}
