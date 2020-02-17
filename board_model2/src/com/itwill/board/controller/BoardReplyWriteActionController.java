package com.itwill.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.board.Board;
import com.itwill.board.BoardService;
import com.itwill.summer.Controller;

public class BoardReplyWriteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		//Board객체를 생성하고 입력된데이타를 읽어서 객체에저장
		Board board=new Board();
		/*
		원글boardno
		*/
		board.setBoardNo(
				Integer.parseInt(request.getParameter("boardno")));
		/*
		답글 데이타
		*/
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		BoardService.getInstance().createReplay(board);
		
		String pageno = "1";
		if(request.getParameter("pageno")!=null){
			pageno=request.getParameter("pageno");
		}
		forwardPath = "forward:board_list.do";
		return forwardPath;
	}

}
