<%@page import="java.util.Date"%>
<%@page import="com.itwill.bean.Car"%>
<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("sUserId", "Mint");
	request.setAttribute("name", "김민태");
	request.setAttribute("age", new Integer(34));
	request.setAttribute("married", new Boolean(true));
	request.setAttribute("weight", new Double(65.89));
	double height = 181.53;
	String address = "경기도민";
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	EL String,Wrapper객체출력
</h1><hr/>
<ol>
	<li>${sUserId}</li>
	<li>${name}</li>
	<li>${name.substring(1)}</li>
	<li>${age}</li>
	<li>${married}</li>
	<li>${weight}</li>
	<li>${height}</li>
	<li>${address}</li>
	<li><%=height %></li>
	<li><%=address %></li>
	
</ol>


</body>
</html>










