<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="simple" uri="http://www.itwill.co.kr/jsp/simpleTag"%>
<%
	session.setAttribute("sUserId", "mint");
	session.setAttribute("level", 5);
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
	<simple:If test='${false}'>
	2.항상안실행<br>
	</simple:If>
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
		<a href='logout_action.jsp'>${sUserId} 님 로그아웃</a>
		<br>
	</c:if>
	<c:if test="${!empty(level)}">
		<c:if test="${level>=5 }">
		고수이군요[${level}]<br>
		</c:if>
	</c:if>
</body>
</html>