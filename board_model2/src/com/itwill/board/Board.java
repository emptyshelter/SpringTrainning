package com.itwill.board;

import java.sql.Date;
import java.util.ArrayList;

public class Board {
	
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int readCount;
	//글의 논리적인 순서번호를 관리하기 위한 필드 (3개)
	private int groupNo;
	private int step;
	private int depth;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
//	public String getTitleString(Board board) {
//		StringBuilder title = new StringBuilder(128);
//		String t = board.getTitle();
//		if (t.length() > 15) {
//			//t = t.substring(0,15);
//			//t = t+"...";
//			t = String.format("%s...", t.substring(0, 15));
//		}
//		//답글공백삽입
//		
//		for (int i = 0; i < board.getDepth(); i++) {
//			title.append("&nbsp;&nbsp;");
//		}
//		if (board.getDepth() > 0) {
//			title.append("<img border='0' src='image/re.gif'/>");
//		}
//		
//		title.append(t.replace(" ", "&nbsp;"));
//		
//		return title.toString();
//	}
	public String getListTitle() {
		//게시물타이틀 공백, 답변처리
		StringBuilder sbTitle = new StringBuilder(128);
		if (title.length() > 15) {
			title = String.format("%s...", title.substring(0, 15));
		}
		//답글공백삽입
		for (int i = 0; i < depth; i++) {
			sbTitle.append("&nbsp;&nbsp;");
		}
		if (depth > 0) {
			sbTitle.append("<img border='0' src='image/re.gif'/>");
		}
		
		sbTitle.append(title.replace(" ", "&nbsp;"));
		
		return sbTitle.toString();
	}
	
}
