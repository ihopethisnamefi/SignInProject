package com.tbo.password_management;

public class SaltHash {

	private String saltObject;
	private String passwordObject;
	
	public SaltHash(String s, String p){		
		saltObject = s;
		passwordObject = p;		
	}

	
	public String getsaltObject(){
		return saltObject;
	}
	
	public void setsaltObject(String s){		
		saltObject = s;
	}
	
	
	public String getpasswordObject(){
		return passwordObject;
	}
	
	public void setpasswordObject(String p){		
		passwordObject = p;
	}
		
		
}


