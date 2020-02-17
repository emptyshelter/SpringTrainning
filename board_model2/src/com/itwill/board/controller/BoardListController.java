package com.itwill.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.board.BoardService;
import com.itwill.summer.Controller;
import com.itwill.util.BoardListPageDto;
import com.itwill.util.PageInputDto;

public class BoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		//1.요청페이지번호	
		String pageno = request.getParameter("pageno");
		if (pageno == null || pageno.equals("")) {
			pageno = "1";
		}
		//2.한페이지에표시할 게시물수 
		int rowCountPerPage = 10;
		//3.한페이지에보여줄 페이지번호갯수(<< 1 2 3 4 5 >>)
		int pageCountPerPage = 10;
		//페이징(계산)을위한DTO,VO
		PageInputDto pageInputDto = new PageInputDto(rowCountPerPage, pageCountPerPage, pageno, "", "");
		//게시물조회
		BoardListPageDto boardListPage = BoardService.getInstance().findBoardList(pageInputDto);
		request.setAttribute("boardListPage", boardListPage);
		forwardPath = "forward:WEB-INF/views/board_list.jsp";
		return forwardPath;
	}

}
