package com.nit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nit.model.UserVO;
import com.nit.service.IUserService;
import com.nit.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
public class DashboardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Long orgId = (Long) session.getAttribute("orgId");
		IUserService userservice = new UserServiceImpl();
		List<UserVO> listUserVo = userservice.getUserListByOrgId(orgId);
		request.setAttribute("userList", listUserVo);
		try {
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Error while retrieving users from database!");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
	}

}
