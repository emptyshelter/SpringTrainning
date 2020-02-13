package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.UserNotFoundException;

public class UserViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		String userId = request.getParameter("userId");
		if (userId == null || userId.equals("")) {
			forwardPath = "redirect:user_main.do";
		} else {
			try {
				User user = null;
				UserService userService = UserService.getInstance();
				user = userService.findUser(userId);
				request.setAttribute("user", user);
				forwardPath="forward:/WEB-INF/views/user_view.jsp";
			} catch (UserNotFoundException e) {
				e.printStackTrace();
				request.setAttribute("msg1", e.getMessage());
				forwardPath = "redirect:user_error.do";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg2", e.getMessage());
				forwardPath = "redirect:user_error.do";
			}
		}
		return forwardPath;
	}

}
