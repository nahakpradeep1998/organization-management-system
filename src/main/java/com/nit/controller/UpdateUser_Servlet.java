package com.nit.controller;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/updateservlet")
public class UpdateUser_Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		UserVO userVo = new UserVO();
		userVo.setFirstName(request.getParameter("fName"));
		userVo.setLastName(request.getParameter("lName"));
		userVo.setEmail(request.getParameter("email"));
		userVo.setPhoneNo(Long.parseLong(request.getParameter("phoneNo")));
		userVo.setDesignation(request.getParameter("designation"));
		userVo.setDateOfJoin(request.getParameter("doj"));
		userVo.setUserId(Long.parseLong(request.getParameter("userId")));
		int status = userService.updateUser(userVo);
		HttpSession session = request.getSession();
		Long orgId = (Long) session.getAttribute("orgId");
		if (status > 0) {
			request.setAttribute("successMessage", "User updated successfully");
			List<UserVO> listUserVo = userService.getUserListByOrgId(orgId);
			request.setAttribute("userList", listUserVo);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Sorry, unable to update record");
			List<UserVO> listUserVo = userService.getUserListByOrgId(orgId);
			request.setAttribute("userList", listUserVo);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
	}

}