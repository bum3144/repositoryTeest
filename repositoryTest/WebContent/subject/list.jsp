<%@page import="vo.SubjectVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
List<SubjectVo> list = (List<SubjectVo>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel='stylesheet' type='text/css' href='../css.css'>
<title>과목 목록(byJSP)</title>
</head>
<body>
<div>
<h1>과목 목록(byJSP)</h1>
<input type="button" value="홈" onclick="location.href='../index.html'">
<input type="button" value="새과목" onclick="location.href='form.html'">
	
<br>
<table border='1'>

<tr>
<th>번호</th>
<th>과목명</th>
<tr>
<% for(SubjectVo subject : list) {%>
<tr>
<td><%=subject.getNo()%></td>
<td><a href='detail.bit?no=<%=subject.getNo()%>'><%=subject.getTitle()%></a></td>
<tr>
<%}%>

</table>
</div>
</body></html>
    