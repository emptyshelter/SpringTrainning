package com.itwill.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.board.Board;
import com.itwill.board.BoardService;
import com.itwill.summer.Controller;

public class BoardViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		Integer boardno=null;
		int pageno=1;
		try{
			boardno=Integer.parseInt(request.getParameter("boardno"));
			pageno=Integer.parseInt(request.getParameter("pageno"));
		}catch(Exception e){
			
		}
		if(boardno==null){
			//목록으로이동
			forwardPath="redirect:board_list.do?pageno="+pageno;
		}
		Board board = null;
		try {
			board = BoardService.getInstance().findBoard(boardno);
			if(board==null){
				forwardPath="redirect:board_list.do?pageno="+pageno;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//읽은회수증가
		BoardService.getInstance().updateHitCount(boardno);
		request.setAttribute("board", board);
		forwardPath="forward:/WEB-INF/views/board_view.jsp";;
		return forwardPath;
	}

}
