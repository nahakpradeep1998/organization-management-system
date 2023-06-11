package com.nit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.service.IUserService;
import com.nit.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/deleteservlet")
public class DeleteUserServlet extends HttpServlet {
	private IUserService userService;

	public void init() {
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userIdParam = request.getParameter("userId");
		if (userIdParam == null) {
			request.setAttribute("errorMessage", "User ID parameter is missing or empty");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			return;
		}
		Long userId = Long.parseLong(userIdParam);
		boolean deleted = false;
		try {
			deleted = userService.deleteUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (deleted) 
			request.setAttribute("successMessage", "User deleted successfully");
		 else 
			request.setAttribute("errorMessage", "Failed to delete user");
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}
}
