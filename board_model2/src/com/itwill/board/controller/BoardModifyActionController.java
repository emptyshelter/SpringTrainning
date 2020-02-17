package com.itwill.board.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.board.Board;
import com.itwill.board.BoardService;
import com.itwill.summer.Controller;

public class BoardModifyActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath= "";
		 //post 요청인 경우 요청 데이터에 한글 문자셋으로 설정
		if (request.getMethod().toLowerCase().equals("post")) {
			 
		}

		//1. Board 객체를 만들고 사용자가 입력한 데이터를 저장
		Board board = new Board();
		board.setBoardNo(
			Integer.parseInt(request.getParameter("boardno")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));

		//2. 데이터베이스에 변경된 내용 적용
		try {
			BoardService.getInstance().update(board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pageno = "1";
		if (request.getParameter("pageno") != null) {
			pageno = request.getParameter("pageno");
		}
//		3. boardview.jsp로 이동
//		response.sendRedirect(
//			String.format("board_view.jsp?boardno=%d&pageno=%s",
//			board.getBoardNo(), pageno));
		forwardPath = "forward:board_view.do"; 
		return forwardPath;
	}

}
