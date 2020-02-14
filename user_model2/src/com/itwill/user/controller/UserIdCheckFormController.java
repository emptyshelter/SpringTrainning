package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.UserService;

public class UserIdCheckFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forward = "";
		boolean isDuplicate = false;
		String msg = "";
		String userId = request.getParameter("userId");
		if (userId == null || userId.equals("")) {
			userId = "";
			msg = "";
			isDuplicate = true;
			request.setAttribute("userId", userId);
			request.setAttribute("msg", msg);
			request.setAttribute("isDuplicate", isDuplicate);
			forward = "forward:/WEB-INF/views/user_id_check_form.jsp";
		} else {
			try {
				UserService userService = new UserService();
				isDuplicate = userService.isDuplcateUserId(userId);
				if (isDuplicate) {
					msg = "사용 불가능한 아이디입니다.";
				} else {
					msg = "사용 가능한 아이디입니다.";
				}
				request.setAttribute("userId", userId);
				request.setAttribute("msg", msg);
				request.setAttribute("isDuplicate", isDuplicate);
				forward = "forward:/WEB-INF/views/user_id_check_form.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				forward = "forward:/WEB-INF/views/user_error.jsp";
			}
		}
		return forward;
	}

}
