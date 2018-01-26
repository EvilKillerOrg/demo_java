package com.ek.guide.zqiming.designpattern.factory.mode1;

@SuppressWarnings("unused")
public class TestDAOFactoy {
	
	private IUserInfoDAO userDAO = DAOFactory.getUserInfoDAO(1);
	private IUserInfoDAO userDAO2 = DAOFactory.getUserInfoDAO(2);
	
	private IDeportmentDAO deptDAO = DAOFactory.getDeportmentDAO();
	
}
