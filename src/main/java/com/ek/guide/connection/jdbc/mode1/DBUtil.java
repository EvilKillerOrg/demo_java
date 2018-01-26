package com.ek.guide.connection.jdbc.mode1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	

	private static String url = "jdbc:mysql://localhost:3306/guide_db";
	private static String driverClassName = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "admin";
	
	public static Connection getConnection(){
		try {
			Class.forName(driverClassName);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void connClose(Connection conn , Statement st , ResultSet rst){
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
	
}
