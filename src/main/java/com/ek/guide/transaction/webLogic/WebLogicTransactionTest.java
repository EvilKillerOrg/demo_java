package com.ek.guide.transaction.webLogic;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
//容器级事务 容器实现的 JTA 事务 (JTA是开发者完成实现的 JTS是容器完成实现的)
public class WebLogicTransactionTest {

	public static void main(String[] args){
		
		javax.transaction.UserTransaction tx = null;
		try {
			Context initCtx = new InitialContext(); //weblogic不需要获得JNDI根
			tx = (UserTransaction)initCtx.lookup("javax/transaction/UserTransaction"); // (从weblogic的JNDI上获得transaction对象)
			tx.begin(); //开启事务
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		try{
			//userDAO.add(xxx);  //业务DAO
			//deptDAO.add(xxx);  //业务DAO
			tx.commit();//提交事务
		}catch(Exception e){
			if(tx!=null){
				try {
					tx.rollback(); //回滚
				} catch (IllegalStateException e1) {
					e1.printStackTrace();
				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (SystemException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}