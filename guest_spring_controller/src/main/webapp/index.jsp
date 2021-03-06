<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${!empty(param.language)}">
	<fmt:setLocale value="${param.language}" scope="session"/>
</c:if>
<c:if test="${empty(param.language)}">
	<fmt:setLocale value="ko" scope="session"/>
</c:if>
<fmt:setBundle basename="com/itwill/guest/guest" scope="session"/>
<script>
	if(window.document.referrer){
		location.href=window.document.referrer;
	}else{
		location.href="guest_main.do";
	}
</script> 
<%--       
<c:redirect url="guest_main.do"/>
--%>