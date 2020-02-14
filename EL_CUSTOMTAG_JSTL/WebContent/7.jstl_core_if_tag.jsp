<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	session.setAttribute("sUserId", "mint");
	session.setAttribute("level", 2);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>JSTL core if tag</H1>
	<hr>
	<c:if test='${true}'>
	1.항상실행<br>
	</c:if>
	<c:if test='${false}'>
	2.항상안실행<br>
	</c:if>
	<c:if test='true'>
	1.항상실행<br>
	</c:if>
	<c:if test='false'>
	2.항상안실행<br>
	</c:if>
	<c:if test='${sUserId==null}'>
		<a href='login_form.jsp'>로그인</a>
		<br>
	</c:if>
	<c:if test='${sUserId!=null}'>
		<a href='logout_action.jsp'>로그아웃</a>
		<br>
	</c:if>
	<c:if test='${!empty(level) && level >=3}'>
	고수님 레벨이 ${level} 이상이시군요 <br>
	</c:if>
	<c:if test='${!(!empty(level) && level >=3)}'>
	하수님 레벨이 3이하 시군요 [${level}] 혹은 null <br>
	</c:if>
</body>
</html>