package com.ek.guide.transaction.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
//jdbc事务
public class JDBCTransactionTest {
	@SuppressWarnings("null")
	public static void main(String[] args){
		Connection conn = null;
		Statement st = null;
		
		try {
			conn.setAutoCommit(false);//不自动提交
			st = conn.createStatement();
			st.execute("insert into aaa...");
			st.execute("insert into bbb...");
			conn.commit(); //这里提交事务
		} catch (SQLException e) {
			try {
				if(conn!=null){
					conn.rollback(); //提交出现异常这里就回滚
				}
			} catch (SQLException e1) {
				e1.printStackTrace(); 
			}
			e.printStackTrace();
		}finally{
			
		}
	}
}