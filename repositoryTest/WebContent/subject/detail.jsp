<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="headTitle" value="과목 상세 정보(by JSP)1" scope="request" />

<jsp:include page="/include/header.jsp" />

<h1>과목 상세 정보</h1>
<table border='1'>
	<tr>
		<th>번호</th>
		<td>${subject.no}</td>
	<tr>
	<tr>
		<th>과목명</th>
		<td>${subject.title}</td>
	<tr>
	<tr>
		<th>내용</th>
		<td><textarea rows=5 cols=60 readonly 
		onFocus='this.blur()'>${subject.description}</textarea>
		</td>
	<tr>
</table>
<br>
<input type="button" value="목록"
	onclick="location.href='list.bit?pageNo=1&pageSize=10'">
<input type="button" value="삭제"
	onclick="location.href='delete.bit?no=${subject.no}'">
<input type="button" value="변경"
	onclick="location.href='update.bit?no=${subject.no}'">
	
<jsp:include page="/include/footer.jsp" />

