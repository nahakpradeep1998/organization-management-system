package com.nit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.model.UserVO;
import com.nit.service.IUserService;
import com.nit.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/editservlet")
public class EditUser_Servlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long userIdParam = Long.parseLong(request.getParameter("userId"));
		IUserService userService = new UserServiceImpl();
		UserVO userVo = userService.getUserByUserId(userIdParam);
		request.setAttribute("user", userVo);
		request.getRequestDispatcher("registerUser.jsp").forward(request, response);
	}
}
//		doGet(request, response);
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//		try {
//			switch (action) {
//			case "/edit":
//				EditRegisterForm(request, response);
//				break;
//			case "/update":
//				updateUser(request, response);
//				break;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void EditRegisterForm(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		Long userIdParam = Long.parseLong(request.getParameter("userId"));
//		IUserService userService = new UserServiceImpl();
//		int count = userService.getUserByUserId(userIdParam);
//		request.setAttribute("user", count);
//		request.getRequestDispatcher("registerUser.jsp").forward(request, response);
//	}
//
//	private void updateUser(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//		IUserService userService = new UserServiceImpl();
//		UserVO userVo = new UserVO();
//		userVo.setFirstName(request.getParameter("fName"));
//		userVo.setLastName(request.getParameter("lName"));
//		userVo.setEmail(request.getParameter("email"));
//		userVo.setPhoneNo(Long.parseLong(request.getParameter("phoneNo")));
//		userVo.setDesignation(request.getParameter("designation"));
//		userVo.setDateOfJoin(request.getParameter("doj"));
//		userVo.setOrgId(Long.parseLong(request.getParameter("orgId")));
//		userVo.setUserId(Long.parseLong(request.getParameter("userId")));
//		userService.updateUser(userVo);
//		request.setAttribute("successMessage", "User updated successfully");
//		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
//	}
//}

//	if (userIdParam == null) {
//	request.setAttribute("errorMessage", "User ID parameter is missing or empty");
//	request.getRequestDispatcher("dashboard.jsp").forward(request, response);
//	return;
//