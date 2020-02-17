<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.itwill.board.Board"%>
<%@page import="com.itwill.util.BoardListPageDto"%>
<%@page import="com.itwill.board.BoardService"%>
<%@page import="com.itwill.util.PageInputDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%!public String getTitleString(Board board) {
		StringBuilder title = new StringBuilder(128);
		String t = board.getTitle();
		if (t.length() > 15) {
			//t = t.substring(0,15);
			//t = t+"...";
			t = String.format("%s...", t.substring(0, 15));
		}
		//답글공백삽입
		
		for (int i = 0; i < board.getDepth(); i++) {
			title.append("&nbsp;&nbsp;");
		}
		if (board.getDepth() > 0) {
			title.append("<img border='0' src='image/re.gif'/>");
		}
		
		title.append(t.replace(" ", "&nbsp;"));
		
		return title.toString();
	}%>

<%
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/board.css" type="text/css">
<script type="text/javascript">
	function boardCreate() {
		location.href = "board_write_form.do";
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->

			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>게시판-리스트</b>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="20" class="t1" align="right" valign="bottom">♠
										총 <font color="#FF0000">${boardListPage.getTotalRecordCount()}</font>
										건 | 현재페이지( <font color="#FF0000">${boardListPage.getSelectPageNo()}</font>
										/ <font color="#0000FF">${boardListPage.getTotalPageCount()}</font>
										)
									</td>
								</tr>
							</table> <br /> <!-- list -->
							<form name="f" method="post" action="">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">

									<tr>
										<td width=280 align=center bgcolor="E6ECDE">제목</td>
										<td width=120 align=center bgcolor="E6ECDE">글쓴이</td>
										<td width=120 align=center bgcolor="E6ECDE">글쓴날</td>
										<td width=70 align=center bgcolor="E6ECDE">본횟수</td>
									</tr>
									<c:forEach var='board' items="${boardListPage.list }">
									<tr>
										<td width=280 bgcolor="ffffff" style="padding-left: 10px" align="left"><a
											href='board_view.do?boardno=${board.getBoardNo() }&pageno=${boardListPage.getSelectPageNo() }'>${board.listTitle}</a>
										</td>
										<td width=120 align=center bgcolor="ffffff">${board.getWriter()}
										</td>
										<td width=120 bgcolor="ffffff" style="padding-left: 10px" align="left">
											${board.regDate.toString().substring(0, 10) }
										</td>
										<td width=70 align=center bgcolor="ffffff" align="left">${board.readCount }
										</td>
									</tr>
									<!-- 
									<tr>
										<td width=280 bgcolor="ffffff" style="padding-left: 10"><a
											href='board_view.jsp?boardno=532&pageno=6'>게시판타이틀514</a></td>
										<td width=120 align=center bgcolor="ffffff">김경호514</td>
										<td width=120 bgcolor="ffffff" style="padding-left: 10">2014-12-23
										</td>
										<td width=70 align=center bgcolor="ffffff">0</td>
									</tr>
									 -->
								</c:forEach>
								</table>
								<!-- /list -->
							</form> <br>
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="center">
										<c:if test="${boardListPage.isShowFirst()}"> 
											<a href="./board_list.do?pageno=1">◀◀</a>&nbsp; 
										</c:if> 
										<c:if test="${boardListPage.isShowPreviousGroup()}">
											<a href="./board_list.do?pageno=${boardListPage.getPreviousGroupStartPageNo() }">◀</a>&nbsp;&nbsp;
										</c:if> 
										<c:forEach var="i" begin="${boardListPage.getStartPageNo()}" end="${boardListPage.getEndPageNo()}" >
											<c:if test="${boardListPage.getSelectPageNo() eq i}"> 
										 		<font color='red'><strong>${i}</strong></font>&nbsp;
										 	</c:if>
										 	<c:if test="${boardListPage.getSelectPageNo() ne i}"> 
												<a href="./board_list.do?pageno=${i}"><strong>${i}</strong></a>&nbsp;
											</c:if>
										 </c:forEach>

										<c:if test="${boardListPage.isShowNextGroup()}">
											  <a href="./board_list.do?pageno=${boardListPage.getNextGroupStartPageNo()}">▶&nbsp;</a>
										</c:if>
										<c:if test="${boardListPage.isShowLast()}">
											 <a href="./board_list.do?pageno=${boardListPage.getTotalPageCount()}">▶▶</a>&nbsp;
										</c:if>
									</td>
									</td>
								</tr>
							</table> <!-- button -->
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="right"><input type="button" value="게시물 생성"
										onclick="boardCreate();" /></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>