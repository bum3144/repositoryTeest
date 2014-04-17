
<%@page import="vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
 UserVo user = (UserVo)request.getAttribute("user");
%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../css.css'>
<title>사용자상세정보</title>
<meta charset="UTF-8">
</head>

<body>
<h1>사용자 상세정보</h1>
<table border='1'>

<tr>
	<th>번호</th>
	<td style='text-align:left;'><%=user.getNo()%></td>
</tr>

<tr>
	<th>이름</th>
	<td style='text-align:left;'><%=user.getName()%></td>
</tr>

<tr>
	<th>전화번호</th>
	<td style='text-align:left;'><%=user.getTel()%></td>
</tr>

<tr>
	<th>이메일</th>
	<td style='text-align:left;'><%=user.getEmail()%></td>
</tr>

<tr>
	<th>팩스번호</th>
	<td style='text-align:left;'><%=user.getFax()%></td>
</tr>

<tr>
	<th>주소</th>
	<td style='text-align:left;'><%=user.getAddress()%></td>
</tr>

<tr>
	<th>사진경로</th>
	<td style='text-align:left;'><%=user.getPostno()%></td>
</tr>
</table>
<a href='list.bit?pageNo=1&pageSize=10'>목록</a>
<a href='delete.bit?no=<%=user.getNo()%>'>삭제</a>
<a href='update.bit?no=<%=user.getNo()%>'>변경</a><br>
</body></html>
