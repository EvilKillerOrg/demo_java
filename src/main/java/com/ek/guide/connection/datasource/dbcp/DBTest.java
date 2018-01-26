package com.ek.guide.connection.datasource.dbcp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ek.guide.connection.vo.UserInfoVO;

public class DBTest {
	public static void main(String[] args){
		DBUtil dbUtil = null ; 
		ResultSet rst = null;
		String select = "select * from userinfo_dbconn";
		List<UserInfoVO> list = new ArrayList<UserInfoVO>();
		
		try {
			dbUtil = new DBUtil();
			rst = dbUtil.queryWithResultSet(select);
			while(rst.next()){
				UserInfoVO userInfo = new UserInfoVO();
				userInfo.setUuid(rst.getInt("uuid"));
				userInfo.setUsername(rst.getString("username"));
				userInfo.setPassword(rst.getString("password"));
				list.add(userInfo);
			}
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(dbUtil!=null){
				dbUtil.free();
			}
		}
	}
}
