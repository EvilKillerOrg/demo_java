package com.ek.guide.connection.jdbc.mode2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static String url = "";
	private static String driverClassName = "";
	private static String username = "";
	private static String password = "";

	static{
		InputStream input = null;
		Properties properties = new Properties();
		try {
		  //在ClassPath下获取 path不能以'/'开头,最终是由ClassLoader获取资源
			input = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//path不以'/'开头时从此类所在包下获取,以'/'开头时从ClassPath下获取,最终还是由ClassLoader获取资源。
	    //inStream = DBUtil.class.getResourceAsStream("jdbc.properties");
			properties.load(input);
			url = properties.getProperty("url");
			driverClassName = properties.getProperty("driverClassName");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(driverClassName);
			return DriverManager.getConnection(url, username, password);
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