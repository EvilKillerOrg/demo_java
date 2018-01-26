package com.ek.guide.connection.datasource.jndi.tomcat;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
private static DataSource dataSource;
	
	static{
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:/comp/env");//获得JNDI的根
			dataSource = (DataSource)envCtx.lookup("jdbc/TestDB"); //再从JNDI树上取tomcat中配置的数据源这个数据源对象是由tomcat产生的
			//D:\Development\ApacheSoftwareFoundation\Tomcat6.0\conf\context.xml
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}