package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.UserService;

public class UserRemoveController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath = "redirect:user_main.do";
		}
		String userId = request.getParameter("userId");
		try{
			UserService userService=new UserService();
			userService.remove(userId);
			String sUserId = (String)request.getSession().getAttribute("sUserId");
			if (sUserId.equals(userId)) {
				forwardPath = "redirect:user_logout_action.do";
			}else {
				forwardPath = "redirect:user_list.do";
			}
			
		}catch(Exception e){
			request.setAttribute("msg", e.getMessage());
			forwardPath = "redirect:user_list.do";
		}
		return forwardPath;
	}

}
