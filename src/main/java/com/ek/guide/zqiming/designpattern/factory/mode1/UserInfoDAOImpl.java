package com.ek.guide.zqiming.designpattern.factory.mode1;

import java.util.List;

public class UserInfoDAOImpl implements IUserInfoDAO {

	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public List findUserInfo() {
		String sql = "select * from userinfo";
		//...
		return null;
	}

}
