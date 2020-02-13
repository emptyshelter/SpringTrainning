<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.itwill.bean.Car"%>
<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Guest g1 = new Guest(1,"KIM","2020","mint@naver.com","https://www.itwill.com","제목은","귀찮아!");
	Guest g2 = new Guest(2,"KoM","2341","TMI@naver.com","https://www.itwall.com","은목제","아귀찮!");
	Guest g3 = new Guest(3,"KING","3119","TNIM@naver.com","https://www.itkill.com","목은제","찮아귀!");
	ArrayList<Guest>guestList = new ArrayList<Guest>();
	guestList.add(g1);
	guestList.add(g2);
	guestList.add(g3);
	Guest [] guestArray = new Guest[3];
	guestArray[0]=g1;
	guestArray[1]=g2;
	guestArray[2]=g3;
	
	request.setAttribute("guestList", guestList);
	request.setAttribute("guestArray", guestArray);
	int no = 2;
	pageContext.setAttribute("no", no);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	EL Array,List객체출력
</h1><hr/>
<ol>
	<li>----List----</li>	
	<li>${guestList }</li>
	<li>${guestList[0]}</li>
	<li>＄{guestList[0].guest_no}  :${guestList[0].guest_no}</li>
	<li>＄{guestList['0'].guest_no}  :${guestList['0'].guest_no}</li>
	<li>＄{guestList["0"].guest_no}  :${guestList["0"].guest_no}</li>
	
	
		
	<li>${guestList[0].guest_name}</li>	
	<li>${guestList[0].guest_email}</li>	
	<li>${guestList[0].guest_homepage}</li>	
	<li>${guestList[0].guest_title}</li>	
	<li>${guestList[0].guest_content}</li>	
	<li>${guestList[1].guest_no}</li>	
	<li>${guestList[1].guest_name}</li>	
	<li>${guestList[1].guest_email}</li>	
	<li>${guestList[1].guest_homepage}</li>	
	<li>${guestList[1].guest_title}</li>	
	<li>${guestList[1].guest_content}</li>	
	<li>${guestList[no].guest_no}</li>	
	<li>${guestList[no].guest_name}</li>	
	<li>${guestList[no].guest_email}</li>	
	<li>${guestList[no].guest_homepage}</li>	
	<li>${guestList[no].guest_title}</li>	
	<li>${guestList[no].guest_content}</li>	
	<li>---------------------Array------------------</li>	
	<li>${guestArray}</li>	
	<li>${guestArray[0].guest_no}</li>	
	<li>${guestArray[0].guest_name}</li>	
	<li>${guestArray[0].guest_email}</li>	
	<li>${guestArray[0].guest_homepage}</li>	
	<li>${guestArray[0].guest_title}</li>	
	<li>${guestArray[0].guest_content}</li>	
	<li>${guestArray[1].guest_no}</li>	
	<li>${guestArray[1].guest_name}</li>	
	<li>${guestArray[1].guest_email}</li>	
	<li>${guestArray[1].guest_homepage}</li>	
	<li>${guestArray[1].guest_title}</li>	
	<li>${guestArray[1].guest_content}</li>	
	<li>${guestArray[no].guest_no}</li>	
	<li>${guestArray[no].guest_name}</li>	
	<li>${guestArray[no].guest_email}</li>	
	<li>${guestArray[no].guest_homepage}</li>	
	<li>${guestArray[no].guest_title}</li>	
	<li>${guestArray[no].guest_content}</li>	
	<%
		for(int i=0; i<3 ; i++){
			pageContext.setAttribute("i", i);
	%>
	<li>${guestArray[i].guest_no} ,${guestArray[i].guest_name}</li>	
	<%
	}
	%>
</ol>


</body>
</html>










