<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<jsp:include page="/include/header.jsp"/>

	<h1>과목 변경폼</h1>
	
	<form action='update.bit' method='post'>
		<table>
			<tr>
				<th>번호</th>
				<td style='text-align: left;'><input type='text' name='no'
					value='${subject.no}' readonly></td>
			</tr>
			<tr>
				<th>과목명</th>
				<td style='text-align: left;'><input type='text' name='title'
					value='${subject.title}'></td>
			</tr>
			<tr>
				<th>설명</th>
				<td style='text-align: left;'><textarea name="description" 
				rows="10" cols="60">${subject.description}</textarea></td>
			</tr>
			<tr>
				<td colspan='2'> <input type="submit" value="변경"> <input
					type='button' value='뒤로' 
					onclick="location.href='detail.bit?no=${subject.no}'">
				<td colspan='2'><input type='submit' value='변경'> <input
					type='button' value='취소' onclick="location.href='detail.bit?no=${subject.no}'">
				</td>
			</tr>
		</table>	
	</form>

<jsp:include page="/include/footer.jsp"/>
