package com.itwill.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.board.Board;
import com.itwill.board.BoardService;
import com.itwill.summer.Controller;

public class BoardReplyWriteFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		//댓글의 대상글번호를 읽어서 변수에 저장
		if(request.getParameter("boardno")==null){
			forwardPath = "redirect:board_list.do";
		}
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		Board board= null;
		try {
			board = BoardService.getInstance().findBoard(boardno);
			System.out.println(board+"nulllllll");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(board==null){
			forwardPath = "redirect:board_list.do";
		}
		String pageno="1";
		if(request.getParameter("pageno")!=null){
			pageno = request.getParameter("pageno");
		}
		request.setAttribute("board", board );
		forwardPath = "forward:/WEB-INF/views/board_reply_write.jsp";
		return forwardPath;
	}

}
