package com.itwill.user.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

public class UserLoginActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		String userId = "";
		String password = "";
		
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "redirect:user_main.do";
		} else {
			try {
				// request.setCharacterEncoding("UTF-8");
				userId = request.getParameter("userId");
				password = request.getParameter("password");
				UserService userService = UserService.getInstance();
				User loginUser = userService.login(userId, password);
				request.getSession().setAttribute("sUserId", userId);
				request.getSession().setAttribute("sUser", loginUser);
				forwardPath = "forward:user_main.do";

			} catch (UserNotFoundException e) {
				request.setAttribute("msg1", e.getMessage());
				request.setAttribute("fUser", new User(userId,password,"","" ));
				forwardPath = "forward:user_login_form.do";
			} catch (PasswordMismatchException e) {
				request.setAttribute("msg2", e.getMessage());
				request.setAttribute("fUser", new User(userId,password,"","" ));
				forwardPath = "forward:user_login_form.do";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:user_main.do";
			}
		}
		return forwardPath;
	}

}
