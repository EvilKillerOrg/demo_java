package com.ek.guide.transaction.webLogic;

import java.util.List;

public class UserVO {
	
	private int uuid;
	private String userName;
	private String password;
	private List<DeptVO> deptList; //对应多部门
	
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<DeptVO> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<DeptVO> deptList) {
		this.deptList = deptList;
	}
}