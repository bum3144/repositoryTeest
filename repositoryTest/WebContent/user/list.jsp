<%@page import="users.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
 List<UserVo> list = (List<UserVo>)request.getAttribute("list"); 
%>

<html><head>
<link rel='stylesheet' type='text/css' href='/web01/css.css'>
<meta charset="UTF-8">
<title>사용자목록</title>
</head>


<body>
<h1>사용자 목록 test</h1>
<script src='//code.jquery.com/jquery-1.11.0.min.js'></script>
<a href='/repositoryTest/'>HOME</a> 
<a href='/web01/users/form.html'>사용자추가</a><br>
<table>
<tr>
	<th>번호</th>
	<th>이름</th>
	<th>이메일</th>
</tr>
 
<%  for(UserVo user : list){%>
<tr>
	<td><%=user.getNo() %></td>
	<td><a href='detail.bit?no=<%=user.getNo()%>'><%=user.getName() %></a></td>
	<td><a href='detail.bit?no=<%=user.getNo()%>'><%=user.getEmail()%></a></td>
</tr>
<%}%>
</table>
</body></html>
