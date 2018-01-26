package com.ek.guide.junit;

import org.junit.Assert;
import org.junit.Test;
//新建suite可以一次run多个test类 
public class UserInfoServiceTest  {

	
	
	//用来加载一些在运行测试方法之前需要加载的资源(例如连接数据库等)
	 

	@Test
	public void testAddUserInfo() {
		UserInfoService us = new UserInfoService();
		us.addUserInfo();
		
		Assert.assertNotNull(null); //断言(测试是否与预期的一样 , 不一样就会 failures 异常是errors)
	}
	
	@Test
	public void testGetUserAge() {
		UserInfoService us = new UserInfoService();
		int age = us.getUserAge();
		Assert.assertEquals(18, age); //断言 期望18 , 真实是12
	}
	
	
	
	

}