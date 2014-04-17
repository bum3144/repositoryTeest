
<%@page import="vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 UserVo user = (UserVo)request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<link rel='stylesheet' type='text/css' href='../css.css'>
<title>사용자변경폼</title>
</head>
<body>
<h1>사용자변경</h1>
<form action='update.bit' method='post'>
<table>
<tr>
<th>번호</th><td style='text-align:left;'><input type='text' name='no' value='<%=user.getNo()%>' readonly></td>
</tr><tr>
<th>이메일</th><td style='text-align:left;'><input type='text' name='email' value='<%=user.getEmail()%>'></td>
</tr><tr>
<th>비밀번호</th><td style='text-align:left;'><input type='password' name='passwd' value='<%=user.getPasswd()%>'></td>
</tr><tr>
<th>이름</th><td style='text-align:left;'><input type='text' name='name' value='<%=user.getName()%>'></td>
</tr><tr>
<th>전화번호</th><td style='text-align:left;'><input type='text' name='tel' value='<%=user.getPasswd()%>'></td>
</tr>
</tr><tr>
<th>팩스번호</th><td style='text-align:left;'><input type='text' name='fax' value='<%=user.getFax()%>'></td>
</tr>
</tr><tr>
<th>우편번호</th><td style='text-align:left;'><input type='text' name='postno' value='<%=user.getPostno()%>'></td>
</tr>
</tr><tr>
<th>주소</th><td style='text-align:left;'><input type='text' name='address' value='<%=user.getAddress()%>'></td>
</tr>
</tr><tr>
<th>사진</th><td style='text-align:left;'><input type='text' name='photo' value='<%=user.getPhoto()%>'></td>
</tr>
<tr><td colspan='2'>
<input type='submit' value='변경'>
<input type='button' value='취소' onclick="location.href='detail.bit?no=<%=user.getNo()%>'">
</td></tr>
</table>
</form>
</body>
</html>
</body></html>
