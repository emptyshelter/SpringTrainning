<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--@ taglib prefix="simple" uri="http://www.itwill.co.kr/jsp/simpleTag" --%>    
<%@ taglib prefix="simple" uri="/WEB-INF/simpleTag.tld" %>    
<%
	session.setAttribute("sUserId", "mint");
	request.setAttribute("id","xxxx");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	--------hello---------<br>
	<simple:hello /><br/>
	--------helloAttr---------<br>
	<simple:helloAttr name="김민태"/>
	<simple:helloAttr name="김태민"/>
	<simple:helloAttr name='${id }'/>
	<simple:helloAttr />
	--------IfBodyTag---------<br>
	<simple:If test="true">
		반드시실행<br>
	</simple:If>
	<simple:If test="false">
		반드시안실행<br>
	</simple:If>
	<simple:If test="${sUserId!=null }">
		${sUserId } 님 안녕하세요!<br/>
	</simple:If>
	<simple:If test="${sUserId==null }">
		Guest 님 안녕하세요!<br/>
	</simple:If>
	<simple:If test="${empty(id) }">
		Guest 님 안녕하세요!<br/>
	</simple:If>
	<simple:If test="${!empty(id) }">
		${id } 님 안녕하세요!<br/>
	</simple:If>
	<simple:If test="${empty(sUserId) }">
		로그인<br/>
	</simple:If>
	<simple:If test="${!empty(sUserId) }">
		${sUserId } 님 로그아웃<br/>
	</simple:If>

</body>
</html>