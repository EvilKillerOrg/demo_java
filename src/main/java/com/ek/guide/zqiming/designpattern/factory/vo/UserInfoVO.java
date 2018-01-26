package com.ek.guide.zqiming.designpattern.factory.vo;

public class UserInfoVO {
	
	private String username;
	private String password;
	
	
	public UserInfoVO(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
