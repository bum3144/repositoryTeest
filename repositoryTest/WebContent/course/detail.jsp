<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
CourseVo course = (CourseVo) request.getAttribute("course");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' type='text/css' href='../css.css'>
<title>과정 상세 정보(by JSP)</title>
</head>
<body>
	<h1>과정 상세 정보(by JSP)</h1>
	<table border='1'>
		<tr>
			<th>번호</th>
			<td><%=course.getNo()%></td>
		<tr>
		<tr>
			<th>과정명</th>
			<td><%=course.getTitle()%></td>
		<tr>
		<tr>
			<th>내용</th>
			<td><textarea rows=5 cols=60 readonly onFocus='this.blur()'><%=course.getDescription()%></textarea> </td>
		<tr>
		<tr>
			<th>시간</th>
			<td><%=course.getHour()%></td>
		<tr>
	</table>
	<br>
			<input type="button" value="목록" onclick="location.href='list.bit?pageNo=1&pageSize=10'">
			<input type="button" value="삭제" onclick="location.href='delete.bit?no=<%=course.getNo()%>'">
			<input type="button" value="변경" onclick="location.href='update.bit?no=<%=course.getNo()%>'">
</body>
</html>
