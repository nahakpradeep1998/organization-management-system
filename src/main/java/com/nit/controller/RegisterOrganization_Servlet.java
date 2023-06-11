package com.nit.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.model.OrganizationVO;
import com.nit.service.IOrganizationService;
import com.nit.service.impl.OrganizationServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterOrganization_Servlet extends HttpServlet {
	private static final Logger lOGGER = Logger.getLogger(RegisterOrganization_Servlet.class.getName());
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orgName = request.getParameter("orgName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		IOrganizationService service = new OrganizationServiceImpl();
		Boolean isAvailable = service.checkOrganizationByEmail(email);
		if (!isAvailable) {
			OrganizationVO orgVo = new OrganizationVO();
			orgVo.setOrgName(orgName);
			orgVo.setEmail(email);
			orgVo.setPassword(password);
			service.registerOrganization(orgVo);
			request.setAttribute("successMessage", "Your organization is created successfully");
			request.getRequestDispatcher("loginPage.jsp").forward(request, response);
			lOGGER.info("Organization registered successfully with email: " + email);
		} else {
			request.setAttribute("errorMessage", "An organization with this email already exists");
			request.getRequestDispatcher("loginPage.jsp").forward(request, response);
			lOGGER.info("Organization registration failed - email already exists: " + email);
		}
	}
}
