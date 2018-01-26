package com.ek.guide.connection.datasource.jndi.tomcat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ek.guide.connection.vo.UserInfoVO;

public class UserinfoDAO {
	
	public List<UserInfoVO> queryUserInfoList(){
		String sql ="select * from userinfo_dbconn";
		List<UserInfoVO> userList = new ArrayList<UserInfoVO>();
		Connection conn = null;
		Statement st = null;
		ResultSet rst = null;
		
		
		try {
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rst = st.executeQuery(sql);
			while(rst.next()){
				UserInfoVO user = new UserInfoVO();
				user.setUuid(rst.getInt("uuid"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return userList;
	}

}
