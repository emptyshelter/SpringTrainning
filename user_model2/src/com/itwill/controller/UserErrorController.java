package com.itwill.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class UserErrorController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) {
		String forwardPath = "";
		forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		return forwardPath;
	}

}
