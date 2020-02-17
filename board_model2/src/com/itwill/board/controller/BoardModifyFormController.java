package com.itwill.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.board.Board;
import com.itwill.board.BoardService;
import com.itwill.summer.Controller;

public class BoardModifyFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		Integer boardno = null;
		try {
			boardno = Integer.valueOf(request.getParameter("boardno"));
		} catch (Exception ex) {
		}
		//글번호가 없다면
		if (boardno == null) {
			//목록으로 이동
			return "redirect:board_list.do";
		}
		Board board=null;
		try {
			board = BoardService.getInstance().findBoard(boardno);
			if (board == null) {
				return "redirect:board_list.do";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("board", board);
		forwardPath="forward:/WEB-INF/views/board_modify.jsp";
		return forwardPath;
	}

}
