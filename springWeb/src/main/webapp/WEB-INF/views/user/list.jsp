<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>user/list.jsp</h1>
	<hr />
	<ol>
		<li><a href='view.do'>KIM</a></li>
		<li><a href='view.do'>MIN</a></li>
		<li><a href='view.do'>TAE</a></li>
		<li>--------------------</li>
		<li><a href='/springWeb/user/view.do'>KIM</a></li>
		<li><a href='/springWeb/user/view.do'>MIN</a></li>
		<li><a href='/springWeb/user/view.do'>TAE</a></li>
		<li>--------------------</li>
		<li><a href="<c:url value='/user/view.do'/>">KIM</a></li>
		<li><a href="<c:url value='/user/view.do'/>">MIN</a></li>
		<li><a href="<c:url value='/user/view.do'/>">TAE</a></li>
		<li>--------------------</li>
	</ol>
</body>
</html>