package com.ek.guide.connection.jdbc.mode1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ek.guide.connection.vo.UserInfoVO;

public class DBTest {
	public static void main(String[] args){
		Connection conn = null;
		Statement st = null;
		ResultSet rst = null;
		String sql = "select * from userinfo_dbconn";
		
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rst = st.executeQuery(sql);
			while(rst.next()){
				UserInfoVO user = new UserInfoVO();
				user.setUuid(rst.getInt("uuid"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				System.out.println("JDBCmode1: UUID: "+user.getUuid()+", UserName: "+user.getUsername()+", Password: "+user.getPassword());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.connClose(conn, st, rst);
		}
		
		
	}
}
