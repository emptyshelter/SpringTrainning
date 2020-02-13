package com.itwill.user.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class UserLoginFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) {
		String forwardPath = "";
		forwardPath="forward:/WEB-INF/views/user_login_form.jsp";
		return forwardPath;
	}

}
