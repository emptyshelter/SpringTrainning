<%@page import="java.util.Date"%>
<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Guest"%>
<%@page import="com.itwill.bean.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Car car = new Car(1,"람보르기니레벤톤","BLACK");
	Guest guest = new Guest(1,"KIM","2020","mint@naver.com","https://www.itwill.com","제목은","귀찮아!");
	Student student = new Student(1000,"KKK",32,new Car(1101,"Bentz","black"));
	Date d = new Date();
	request.setAttribute("car", car);
	request.setAttribute("guest", guest);
	request.setAttribute("student", student);
	request.setAttribute("date", d);
	/*
	public int guest_no;
	public String guest_name;
	public String guest_date;
	public String guest_email;
	public String guest_homepage;
	public String guest_title;
	public String guest_content;
	
	private int no;
	private String name;
	private int age;
	private Car car;
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ol>
	<li>차번호: ${car.no} </li>
	<li>차모델: ${car.model} </li>
	<li>차색상: ${car.color} </li>
	<li>회원이름: ${guest.guest_name} </li>
	<li>글작성날짜: ${guest.guest_date} </li>
	<li>이메일: ${guest.guest_email} </li>
	<li>홈페이지: ${guest.guest_homepage} </li>
	<li>제목: ${guest.guest_title} </li>
	<li>내용: ${guest.guest_content} </li>
	<li>---------------------------------------------------</li>
	<li>학생: ${student} </li>
	<li>학생번호: ${student.no} </li>
	<li>학생이름: ${student.name} </li>
	<li>학생나이: ${student.age} </li>
	<li>학생차: ${student.car} </li>
	<li>학생차번호: ${student.car.no} </li>
	<li>학생차모델: ${student.car.model} </li>
	<li>학생차색상: ${student.car.color} </li>
	<li>---------------------------------------------------<br></li>
	<li>${date} </li>
	<li>${date.year} </li>
	<li>${date.month} </li>
	<li>${date.day}</li>
	<li>${date.toLocaleString()} </li>
</ol>	
	El_Bean 출력
</body>
</html>