package com.zyd.aeskey;

import javax.crypto.spec.SecretKeySpec;

public class GenerateAesKey {
	
	public static void main(String[] args) {
		SecretKeySpec aesKey = new SecretKeySpec("1234567812345678".getBytes(), "AES");
		System.out.println(aesKey);
		System.out.println(aesKey.getAlgorithm());
		System.out.println(aesKey.getFormat());
	}

}
