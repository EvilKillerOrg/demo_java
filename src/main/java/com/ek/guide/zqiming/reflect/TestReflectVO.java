package com.ek.guide.zqiming.reflect;

import java.util.Date;

public class TestReflectVO {

	private Integer uuid;
	private String username;
	private Date birthday;
	
	public TestReflectVO(String username , Date birthday){
		this.username = username;
		this.birthday = birthday;
	}
	
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
