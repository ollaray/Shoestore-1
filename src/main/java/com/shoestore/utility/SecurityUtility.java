//package com.shoestore.utility;
//
//import java.security.SecureRandom;
//import java.util.Random;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SecurityUtility {
//	private static final String SALT = "One2One2Many";
//	
//	@Bean
//	public static BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
//	}
//	
//	@Bean
//	public static String randomPassword() {
//		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
//		StringBuilder salt = new StringBuilder();
//		Random randomNo = new Random();
//		while(salt.length()<18) {
//			int i = (int)(randomNo.nextFloat() * SALTCHARS.length());
//			salt.append(SALTCHARS.charAt(i));
//		}
//		String saltStr = salt.toString();
//		return saltStr;
//	}
//	
//}
