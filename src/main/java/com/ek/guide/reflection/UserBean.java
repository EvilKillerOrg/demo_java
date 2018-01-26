package com.ek.guide.reflection;

public class UserBean {

	private String uname;
	private int age;
	
	
	public UserBean() {
	}
	public UserBean(String uname, int age) {
		this.uname = uname;
		this.age = age;
	}


	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
