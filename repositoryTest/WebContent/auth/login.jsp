<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/common.css">
</head>
<body>
<div class="container">
	<h1>로그인</h1>
	<form action="login.bit" method="post" role="form">
	<div class="form-group">
	<label for="email">이메일:</label>
	<input type="text" id="email" name="email" class="form-control" value="${cookie.loginEmail.value }"/><br>
	</div>
	
	<div class="form-group">
	<%-- 이메일: <input type="text" name="email" value="${loginEmail}"/><br> --%>
	<label for="password">암호:</label> 
	<input type="password" id="password" class="form-control" name="password"><br>
	</div>
	
	<input type="checkbox" name="saveEmail" 
	<c:if test="${cookie.loginEmail != null}">checked</c:if>>이메일 저장<br>
	<input type="submit" value="로그인" class="btn btn-primary"><br>
	</form>
</div>
</body>
</html>