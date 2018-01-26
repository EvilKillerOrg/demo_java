package com.ek.guide.connection.datasource.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
//注意dbcp2和dbcp1对jdk版本要求是不一样的。
//除此之外还需要comms-logging包和commons-pool2包
//同时mysql-connector包版本要在5.0以上，否则使用时会报错。
public class DBUtil {
	private static DataSource dataSource;
	
	static{
		Properties properties = new Properties();
		InputStream input = null ; 
		try {
			input = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(input);
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	private Connection conn = null; 
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rst = null;
	
	//构造方法初始化
	public DBUtil()throws SQLException{
		try {
			this.conn = dataSource.getConnection();
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
 