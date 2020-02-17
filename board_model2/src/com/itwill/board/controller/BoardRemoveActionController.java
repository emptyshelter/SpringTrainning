package com.itwill.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.board.BoardException;
import com.itwill.board.BoardService;
import com.itwill.summer.Controller;

public class BoardRemoveActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		Integer boardno=null;
		Integer pageno=null;
		try{
			boardno=Integer.valueOf(request.getParameter("boardno"));	
			pageno=Integer.valueOf(request.getParameter("pageno"));	
		}catch(Exception ex){
		}
		boolean result=true;
		String msg="";
		if(boardno==null){
			result=false;
			msg="삭제실패";
		}else{
			try{
				BoardService.getInstance().remove(boardno);
				result=true;
				msg="삭제성공";
			}catch(BoardException e){
				result=false;
				msg="삭제실패:"+e.getMessage();
				forwardPath="redirect:board_view.do";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		forwardPath="redirect:board_list.do";
		return forwardPath;
	}

}
