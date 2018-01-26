package com.ek.guide.zqiming.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * 数据对象操作类 
 */

public class UserInfoDAO {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List queryUserInfo(){
		List list = new ArrayList();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from userinfo_dbconn";
		
		conn = JdbcUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args){
		UserInfoDAO dao = new UserInfoDAO();
		List list = dao.queryUserInfo();
		System.out.println(list.size());
	}
}
