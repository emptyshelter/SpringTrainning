package com.itwill.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		} else {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			try {
				UserService userService = new UserService();
				int updateRowCount = userService.update(new User(userId, password, name, email));
				if (updateRowCount == 1) {
					forwardPath = "redirect:user_list.do";
				} else {
					forwardPath = "forward:user_error.do";
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", e.getMessage());
				forwardPath = "redirect:user_error.do";
			}

		}
		return forwardPath;
	}

}
