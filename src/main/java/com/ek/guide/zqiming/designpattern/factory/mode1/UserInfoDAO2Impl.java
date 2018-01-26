package com.ek.guide.zqiming.designpattern.factory.mode1;

import java.util.List;

public class UserInfoDAO2Impl implements IUserInfoDAO{

	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public List findUserInfo() {
		String sql = "select * from userinfo2";
		//...
		return null;
	}

}
