<%@page import="vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
List<CourseVo> list = (List<CourseVo>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel='stylesheet' type='text/css' href='../css.css'>
<title>과정 목록(byJSP)</title>
</head>
<body>
<h1>과정 목록(byJSP)</h1>
<input type="button" value="홈" onclick="location.href='../index.html'">
<input type="button" value="새과정" onclick="location.href='form.html'">
	
<br>
<table border='1'>

<tr>
<th>번호</th>
<th>과정명</th>
<tr>
<% for(CourseVo course : list) {%>
<tr>
<td><%=course.getNo()%></td>
<td><a href='detail.bit?no=<%=course.getNo()%>'><%=course.getTitle()%></a></td>
<tr>
<%}%>

</table>
</body></html>
    