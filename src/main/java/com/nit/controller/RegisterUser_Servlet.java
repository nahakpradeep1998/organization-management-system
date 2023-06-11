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

import com.nit.model.UserVO;
import com.nit.service.IUserService;
import com.nit.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/registerservlet")
public class RegisterUser_Servlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(RegisterUser_Servlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("fName");
		String lastName = req.getParameter("lName");
		String email = req.getParameter("email");
		Long phoneNo = Long.parseLong(req.getParameter("phoneNo"));
		String designation = req.getParameter("designation");
		String dateOfJoin = req.getParameter("doj");
		HttpSession session = req.getSession();
		Long orgId = (Long) session.getAttribute("orgId");
		IUserService service = new UserServiceImpl();
		Boolean isAvailable = service.checkUserByEmail(email);
		if (!isAvailable) {
			UserVO userVo = new UserVO();
			userVo.setFirstName(firstName);
			userVo.setLastName(lastName);
			userVo.setEmail(email);
			userVo.setPhoneNo(phoneNo);
			userVo.setDesignation(designation);
			userVo.setDateOfJoin(dateOfJoin);
			userVo.setOrgId(orgId);
			service.registerUser(userVo);
			List<UserVO> listUserVo = service.getUserListByOrgId(orgId);
			req.setAttribute("userList", listUserVo);
			req.setAttribute("successMessage", "<h4>You are Registered successfully :) </h4>");
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
			LOGGER.info("New user registered with email: " + email);
		} else {
			req.setAttribute("errorMessage", "<h4>An User with this emailID already Exists</h4>");
			req.getRequestDispatcher("registerUser.jsp").forward(req, resp);
			LOGGER.warning("Registration failed. User with email " + email + " already exists");
		}
	}
}
