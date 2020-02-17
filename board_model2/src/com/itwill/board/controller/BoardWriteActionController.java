package com.itwill.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.board.Board;
import com.itwill.board.BoardService;
import com.itwill.summer.Controller;

public class BoardWriteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath = "redirect:board_write_form.do";
		}
		 
		Board board=new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		
		BoardService.getInstance().create(board);
		forwardPath = "redirect:board_list.do";
		return forwardPath;
	}

}
