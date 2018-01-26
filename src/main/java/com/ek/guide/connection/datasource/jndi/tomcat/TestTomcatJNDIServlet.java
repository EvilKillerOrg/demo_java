package com.ek.guide.connection.datasource.jndi.tomcat;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ek.guide.connection.vo.UserInfoVO;

@WebServlet("/servlet/TestTomcatJNDIServlet")
public class TestTomcatJNDIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter()
				.append("Served at: ")
				.append(request.getContextPath())
				.append("com.ek.guide.dbconnection.datasource.jndi.tomcat.TestTomcatJNDIServlet");
		
		UserinfoDAO dao = new UserinfoDAO();
		List<UserInfoVO> userList = dao.queryUserInfoList();
		
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		//response.sendRedirect("");
	}

}
