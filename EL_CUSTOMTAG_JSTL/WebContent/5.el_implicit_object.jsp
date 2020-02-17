<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("path", "/page.jsp");
	request.setAttribute("path", "/request.jsp");
	session.setAttribute("path", "/session.jsp");
	application.setAttribute("path", "/application.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> EL 내장객체</h1><hr>
<ul>
	<li>param의 갯수 : ${param.size()}</li>
	<li>${param }</li>
	<li>${param.id }</li>
	<li>${param.name }</li>
	<li>${param.hobby }</li>
	<li>${paramValues }</li>
	<li>${paramValues.id[0] }</li>
	<li>${paramValues.name[0] }</li>
	<li>${paramValues.hobby[0] }</li>
	<li>${paramValues.hobby[1] }</li>
	<li>${paramValues.hobby[2] }</li>
	<li>${path}</li>
	<li>${pageScope.path}</li>
	<li>${pageScope['path']}</li>
	<li>${pageScope["path"]}</li>
	<li>${requestScope.path}</li>
	<li>${sessionScope.path}</li>
	<li>${applicationScope.path}</li>
	<li>${cookie}</li>
	<li>${cookie.JSESSIONID}</li>
	<li>${cookie.JSESSIONID.value}</li>
	<li>${cookie['JSESSIONID'].value}</li>
	<li>header map size: ${header.size()}</li>
	<li>-------------pageContext[Bean]---------</li>
	<li>${pageContext}</li>
	<li><%=pageContext%></li>
	<li>${pageContext.request.method}</li>
	<li><%=((HttpServletRequest)pageContext.getRequest()).getMethod()%></li>
	<li>${pageContext.session}</li>
	<li>${pageContext.out}</li>
	<li>${pageContext.response}</li>
	<li>${pageContext.servletContext}</li>
	<li>${pageContext.servletConfig}</li>
</ul>
<br/>
<br/>
<br/>
<ol>
	<li>pageContext 객체의 속성개체수: ${pageScope.size()}</li>
	<li>request 객체의 속성개체수:${requestScope.size()}</li>
	<li>session 객체의 속성개체수:${sessionScope.size()}</li>
	<li>application 객체의 속성개체수:${applicationScope.size()}</li>
	<li>${pageScope}</li>
	<li>${requestScope}</li>
	<li>${sessionScope}</li>
	<li>${applicationScope}</li>
</ol>	
</body>
</html>










