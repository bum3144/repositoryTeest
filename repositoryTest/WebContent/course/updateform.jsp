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
<title>과정 변경폼</title>
<link rel='stylesheet' type='text/css' href='../css.css'>
</head>
<body>
	<h1>과정 변경폼</h1>
	<form action='update.bit' method='post'>
		<table>
			<tr>
				<th>번호</th>
				<td style='text-align: left;'><input type='text' name='no'
					value='<%=course.getNo()%>' readonly></td>
			</tr>
			<tr>
				<th>과정명</th>
				<td style='text-align: left;'><input type='text' name='title'
					value='<%=course.getTitle()%>'></td>
			</tr>
			<tr>
				<th>설명</th>
				<td style='text-align: left;'><textarea name="description" rows="10" cols="60"><%=course.getDescription()%></textarea></td>
			</tr>
			<tr>
				<th>시간</th>
				<td style='text-align: left;'><input type='text' name='hour'
					value='<%=course.getHour()%>'></td>
			</tr>
			<tr>
				<td colspan='2'><input type='submit' value='변경'> <input
					type='button' value='취소' onclick="location.href='detail.bit?no=<%=course.getNo()%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
