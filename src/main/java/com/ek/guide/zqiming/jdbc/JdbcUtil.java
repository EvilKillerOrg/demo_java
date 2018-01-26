package com.ek.guide.zqiming.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil {
	
	private static String dirverClassName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/guide_db";
	private static String user="root";
	private static String password="admin";
	
	public static Connection getConnection(){
		Connection conn = null;
		 	try {
				Class.forName(dirverClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return conn;
		 
	}

}
