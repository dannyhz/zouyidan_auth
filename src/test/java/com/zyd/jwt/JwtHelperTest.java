package com.zyd.jwt;

import org.junit.Test;

public class JwtHelperTest {
	@Test
	public void testGenerate(){
		System.out.println(JwtHelper.createJWT("danny", "admin", "1,2,3"));
		
	}

	@Test
	public void testParse(){
		System.out.println(JwtHelper.parseJWT(JwtHelper.createJWT("danny", "admin", "1,2,3")));
	}
}
