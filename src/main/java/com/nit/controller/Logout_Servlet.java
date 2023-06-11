package com.nit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@SuppressWarnings("serial")
@WebServlet("/logoutServlet")
public class Logout_Servlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(Logout_Servlet.class.getName());
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		logger.info("User logged out");
		response.sendRedirect("loginPage.jsp");
	}
}
