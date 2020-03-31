package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.Addressing;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Component
@Aspect
public class LoginCheckAdvice {
	@Pointcut("execution(* com.itwill.user.controller.UserController.user_view(..))||"+
			  "execution(* com.itwill.user.controller.UserController.user_list(..))||"+
			  "execution(* com.itwill.user.controller.UserController.user_modify_form(..))||"+
			  "execution(* com.itwill.user.controller.UserController.user_modify_action(..))||"+
			  "execution(* com.itwill.user.controller.UserController.user_remove_action(..))")
	public void user_login_check_pointcut() {
	}

	@Pointcut("execution(* com.itwill.user.controller.UserController.user_logout_action(..))")
	public void user_logout_action_pointcut() {
	}

	


	@Around("user_login_check_pointcut()||user_logout_action_pointcut()")
	public Object login_check(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("*************************<<aop>> login_check**********************");
		HttpSession session = 
				 ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
		HttpServletRequest request = 
				((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
		Object result = null;
		/*
		HttpSession session = null;
		HttpServletRequest request = null;
		String type = pjp.getSignature().getDeclaringTypeName();
		for (Object o : pjp.getArgs()) {
			if (o instanceof HttpSession) {
				session = (HttpSession) o;
			} else if (o instanceof HttpServletRequest) {
				request = (HttpServletRequest) o;
			}
		}*/
		if (session.getAttribute("sUserId")==null) {
			session.setAttribute("redirectUrl", request.getServletPath());
			return "redirect:user_main";
		} else {
			if (session.getAttribute("redirectUrl") != null) {
				session.removeAttribute("redirectUrl");
			}
			result = pjp.proceed();
		}
		
		return result;
	}
}
