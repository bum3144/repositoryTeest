<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jQuery UI -->
<link rel="stylesheet" href="../css/ui-lightness/jquery-ui-1.10.4.custom.css">
  <script src="../js/jquery-1.10.2.js"></script>
  <script src="../js/jquery-ui-1.10.4.custom.js"></script>
<link rel='stylesheet' type='text/css' href='../css.css'>
<script>
  $(function() {
	    $( "input[type=button], button" )
	      .button()
	      .click(function( event ) {
	        event.preventDefault();
	      });
	    $( "input[type=submit], button" )
	      .button()
	      .click(function( event ) {
	        event.preventDefault();
	      });
	    $( "input[type=reset], button" )
	      .button()
	      .click(function( event ) {
	        event.preventDefault();
	      });
  });
  
  
  $('#my-table').dynatable();  
 </script>

  <title> 관리 </title>
</head>
<body>
<div id="header" 
  style="border: 1px solid white; background-color: darkgray; font-weight: bold; font-size: 18px; color: white;">
${loginUser.name}(${loginUser.email})
<a href="${pageContext.request.contextPath}/auth/logout.bit">로그아웃</a>
</div> 
