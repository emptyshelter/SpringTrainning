package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class UserMainController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) {
		String forwardPath ="";
		forwardPath= "forward:/WEB-INF/views/user_main.jsp";
		return forwardPath;
	}

}
