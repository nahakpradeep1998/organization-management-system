package com.nit.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nit.model.OrganizationBO;
import com.nit.model.UserVO;
import com.nit.service.IOrganizationService;
import com.nit.service.IUserService;
import com.nit.service.impl.OrganizationServiceImpl;
import com.nit.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/loginservlet")
public class Login_Servlet extends HttpServlet {
	private static final Logger lOGGER =  Logger.getLogger(Login_Servlet.class.getName());
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		lOGGER.info("Received login request for email: " + email + " and password: " + password);
		IOrganizationService service = new OrganizationServiceImpl();
		OrganizationBO orgBo = new OrganizationBO();
		orgBo.setEmail(email);
		orgBo.setPassword(password);
		OrganizationBO dbOrgBo = service.login(orgBo);
		if (dbOrgBo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("orgId", dbOrgBo.getOrgId());
			IUserService userservice = new UserServiceImpl();
			List<UserVO> listUserVo = userservice.getUserListByOrgId(dbOrgBo.getOrgId());
			request.setAttribute("userList", listUserVo);
			request.setAttribute("successMessage", "<h4>Welcome To Dashboard</h4>");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid email or password");
			request.getRequestDispatcher("loginPage.jsp").forward(request, response);
		}
	}
}
