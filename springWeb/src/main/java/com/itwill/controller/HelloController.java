package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	public HelloController() {
		System.out.println("### HelloController() 생성자");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/WEB-INF/views/hello.jsp");
		request.setAttribute("msg", "안녕 Spring MVC!!!");
		return mView;
	}

}
