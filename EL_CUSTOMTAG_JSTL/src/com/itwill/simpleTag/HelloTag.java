package com.itwill.simpleTag;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import netscape.javascript.JSException;

public class HelloTag  extends TagSupport{
	public HelloTag() {
		System.out.println("1. HelloTag() 생성자");
	}
	@Override
	public int doStartTag() throws JspException {
		System.out.println("2.doStartTag()");
		JspWriter out = pageContext.getOut();
		HttpSession session = pageContext.getSession();
		String sUserId = (String)session.getAttribute("sUserId");
		if(sUserId==null) {
			sUserId ="Guest";
		}
		
		try {
			out.print(sUserId+"님 안녕하세요!");
		} catch (IOException e) {
			e.printStackTrace();
			throw new JSException(e.getMessage());
		}
		return super.doStartTag();
	}
	
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("2.doEndTag()");
		JspWriter out = pageContext.getOut();
		try {
			out.print("<hr>");
		} catch (IOException e) {
			throw new JSException(e.getMessage());
		}
		return EVAL_PAGE;
	}
	
}
