package com.ek.guide.exception.demo2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;

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
			dataSource = (DataSource)envCtx.lookup("jdbc/TestDB"); //再从JNDI树上取tomcat中配置的数据源 
			//D:\Development\ApacheSoftwareFoundation\Tomcat6.0\conf\context.xml
		} catch (NamingException e) {
			//throw e; 这样报错
			throw new EXCPDAOException("Get jdbc/TestDB dataSource is error!",e); //非运行时异常转换为运行时异常
			
		} 
	}
	
	
	private Connection conn = null; 
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rst = null;
	
	//构造方法初始化
	public DBUtil()throws SQLException{
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw e;
		}
	}
	
	
	public PreparedStatement getPreparedStatement(String insert)throws SQLException{
		try {
			pst = conn.prepareStatement(insert);
		} catch (Exception e) {
			throw e;
		}
		return pst;
	}
	
	
	public void setPreparedStatement(Object[] values , String[] types)throws SQLException{
		int i=0;
		 for (Object object : values) {
			if("string".equals(types[i])){
				if(object!=null){
					pst.setString(i+1, (String)object);
				}else{
					pst.setNull(i+1, Types.VARCHAR);
				}
			}
			if("date".equals(types[i])){
				if(object!=null){
					java.sql.Date tempDate = new java.sql.Date(((Date)object).getTime());
					pst.setDate(i+1, tempDate);
				}else{
					pst.setNull(i+1, Types.DATE);
				}
			}
			if("byte[]".equals(types[i])){
				if(object!=null){
					pst.setBytes(i+1, (byte[])object);
				}else{
					pst.setNull(i+1, Types.BINARY);
				}
			}
			//...
			i++;
		}
	}
	
	
	public ResultSet queryWithResultSet(String select)throws SQLException{
		st = conn.createStatement();
		rst = st.executeQuery(select);
		return rst;
	}
	
	
	public void free(){
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
		if(pst!=null){
			try {
				pst.close();
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
 