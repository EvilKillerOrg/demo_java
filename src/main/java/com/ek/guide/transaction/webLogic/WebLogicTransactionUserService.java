package com.ek.guide.transaction.webLogic;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ek.guide.transaction.webLogic.DeptDAO;
import com.ek.guide.transaction.webLogic.UserDAO;
import com.ek.guide.transaction.webLogic.DeptVO;
import com.ek.guide.transaction.webLogic.UserVO;

public class WebLogicTransactionUserService {
	
	private DeptDAO deptDAO = new DeptDAO();
	private UserDAO userInfoDAO =new UserDAO();
	
	private UserTransaction utx = null;
	
	public WebLogicTransactionUserService(){ //构造这个Service的时候产生事务接口
		try {
			Context initCtx = new InitialContext(); //weblogic不需要获得JNDI根
			utx = (UserTransaction)initCtx.lookup("javax/transaction/UserTransaction"); // (从weblogic的JNDI上获得transaction对象)
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addUser(UserVO userInfo){
	 
			try {
				utx.begin();//开启事务
			} catch (NotSupportedException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			try {
				userInfoDAO.addUserInfo(userInfo); //添加user
				List<DeptVO> deptList = userInfo.getDeptList();
				if(deptList!=null&&deptList.size()>0){
					for (DeptVO dept : deptList) {
						deptDAO.addDept(dept); //添加部门
					}
				}
				utx.commit(); //完成后提交事务
			} catch (Exception e) {
				if(utx!=null){
					try {
						utx.rollback(); //异常时回滚
					} catch (IllegalStateException e1) {
						e1.printStackTrace();
					} catch (SecurityException e1) {
						e1.printStackTrace();
					} catch (SystemException e1) {
						e1.printStackTrace();
					}
				}
				e.printStackTrace();
			}
	 
	}
}