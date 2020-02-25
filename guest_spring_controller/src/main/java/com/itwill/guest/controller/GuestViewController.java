package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestViewController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		ModelAndView mv = new ModelAndView();
		String guest_noStr1 = request.getParameter("guest_no");
		if(guest_noStr1==null||guest_noStr1.equals("")){
			//response.sendRedirect("guest_main.jsp");
			forwardPath="redirect:guest_main.do";
		}else {
			try {
				GuestService guestService=new GuestService();
				Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr1));
				if(guest==null){
					
					forwardPath="redirect:guest_list.do";
					//forwardPath="forward:guest_list.do";
				}else {
					request.setAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_view.jsp";
				}
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}
		mv.setViewName(forwardPath);
		return mv;
	}

}
