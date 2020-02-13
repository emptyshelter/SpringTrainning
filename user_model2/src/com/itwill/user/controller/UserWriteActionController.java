package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;

public class UserWriteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		User newUser = null;
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "redirect:guest_main.do";
		} else {
			try {
				UserService userService = UserService.getInstance();
				newUser = new User(userId, password, name, email);
				int insertRowCount = userService.create(newUser);
				if (insertRowCount == 1) {
					forwardPath = "redirect:user_login_form.do";
				} else {
					forwardPath = "forward:user_error.do";
				}
			} catch (ExistedUserException e) {
				request.setAttribute("msg", e.getMessage());
				request.setAttribute("fuser", newUser);
				forwardPath = "redirect:user_error.do";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "redirect:user_error.do";
			}
		}
		return forwardPath;
	}

}
