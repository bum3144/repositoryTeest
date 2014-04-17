<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
SubjectVo subject = (SubjectVo) request.getAttribute("subject");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 변경폼</title>
<link rel='stylesheet' type='text/css' href='../css.css'>
</head>
<body>
	<h1>과목 변경폼</h1>
	<form action='update.bit' method='post'>
		<table>
			<tr>
				<th>번호</th>
				<td style='text-align: left;'><input type='text' name='no'
					value='<%=subject.getNo()%>' readonly></td>
			</tr>
			<tr>
				<th>과목명</th>
				<td style='text-align: left;'><input type='text' name='title'
					value='<%=subject.getTitle()%>'></td>
			</tr>
			<tr>
				<th>설명</th>
				<td style='text-align: left;'><textarea name="description" rows="10" cols="60"><%=subject.getDescription()%></textarea></td>
			</tr>
			<tr>
				<td colspan='2'><input type='submit' value='변경'> <input
					type='button' value='취소' onclick="location.href='detail.bit?no=<%=subject.getNo()%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
</body>
</html>
