package com.tbo.utils;

public class StringUtils {
	
	private StringUtils(){
		
	}
	
	public static boolean isEmpty(String string){
		return string == null || string.length() == 0;
	}
	
	public static boolean containsXSS(String str){
		if(isEmpty(str))
			return false;
		boolean XSSDetected = false;
		XSSDetected = XSSDetected || str.contains("&");
		XSSDetected = XSSDetected || str.contains("<");
		XSSDetected = XSSDetected || str.contains(">");
		XSSDetected = XSSDetected || str.contains("/");
		XSSDetected = XSSDetected || str.contains("\"");
		return XSSDetected;	
	}

}
