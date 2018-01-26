package com.ek.guide.exception.demo2;

import java.sql.SQLException;

import com.ek.guide.connection.vo.UserInfoVO;

public class UserInfoDAO {
	public void addUserInfo(UserInfoVO userinfo){
		// DBUtil中有自定义exception 要首先 像行9那样定义 , 因为DBUtil在实例化的时候就会涉及到他的异常抛出
		DBUtil dbUtil = null;
		
		try {
			dbUtil = new DBUtil();
			dbUtil.getPreparedStatement("insert into xxx");
			// dbUtil.setPreparedStatement(values, types);
		} catch (SQLException e) {
			throw new EXCPDAOException("add userinfo error!",e); //非运行时异常转换为运行时异常
		}finally{
			if(dbUtil!=null){
				dbUtil.free();
			}
		}
		
		
	}
}