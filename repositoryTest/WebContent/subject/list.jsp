<%@page import="java.util.ArrayList"%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/include/header.jsp"/>

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
<c:forEach var="subject" items="${list}">
<tr>
<td>${subject.no}</td>
<td><a href='detail.bit?no=${subject.no}'>${subject.title}</a></td>
<tr>
</c:forEach>

</table>
</div>

<jsp:include page="/include/footer.jsp" />