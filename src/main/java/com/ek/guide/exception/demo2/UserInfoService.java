package com.ek.guide.exception.demo2;

import com.ek.guide.connection.vo.UserInfoVO;

public class UserInfoService {
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	
	public void addUserInfo(UserInfoVO userinfo){
		if(userinfo==null){
			//可以用自定义异常(继承runtime)在需要的时候抛出异常
			throw new EXCPServiceException("addUserInfo failed , userinfo is null!");
		}
		
		//userinfoDAO中的方法是运行时异常,这里不用捕获异常了,必须捕获异常就行不行
		userInfoDAO.addUserInfo(userinfo);
	}
}