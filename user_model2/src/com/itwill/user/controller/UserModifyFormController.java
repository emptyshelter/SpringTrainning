package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		String userId=request.getParameter("userId");
		System.out.println(userId+"uuuuuuuuuuuuuuu저아이디");
		try{
			User user=null;
			UserService userService=UserService.getInstance();
			user = userService.findUser(userId);
			request.setAttribute("user", user);
			forwardPath = "forward:/WEB-INF/views/user_modify_form.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			forwardPath = "redirect:user_error.do";
		}
		return forwardPath;
	}
}
