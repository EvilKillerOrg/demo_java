package com.ek.guide.zqiming.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicConnection {
	public static void main(String[] args){
		
		
		//step1: 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//step2: 编写连接数据库时需要的URl username password
		String url="jdbc:mysql://localhost:3306/guide_db";
		String user="root";
		String password="admin";
		
		
		//step3: 创建连接对象
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//查询对象
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from userinfo_dbconn";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				System.out.println("用户名 :"+rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}