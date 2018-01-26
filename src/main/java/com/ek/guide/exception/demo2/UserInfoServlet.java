package com.ek.guide.exception.demo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoServlet extends HttpServlet{
	private static final long serialVersionUID = 109047002720957877L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfoService userInfoService = new UserInfoService();
		//UserinfoVO user = new UserinfoVO();
		userInfoService.addUserInfo(null);
	}

	
}
