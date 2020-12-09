<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	<c:import url="../default/header.jsp"/>
		<table border="1">
			<colgroup>
				<col style="width:5%;">
				<col style="width:auto;">
				<col style="width:10%;">
				<col style="width:10%;">
			</colgroup>
			<thead>
				<tr>
					<th>NO</th>
					<th>글제목</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
				<c:choose>
					<c:when test="${noticeList.size() != 0}">
						<c:forEach var="brd" items="${noticeList}">
							<tr>
								<td>${brd.notice_no }</td>
								<td>
								<a href="getDetail?no=${brd.notice_no }">
								${brd.notice_title }
								</a>
								</td>
								<td>${brd.notice_hit }</td>
								<td>${brd.notice_reg_date }</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<th colspan="4">
							현재 작성된 글이 없습니다.
							</th>
						</tr>
					</c:otherwise>					
				</c:choose>
			<tr>
				<td colspan="4" style="text-align: right;">
						<a href ="regForm">글작성</a>
					</td>
			</tr>
		</table>
		
	<c:import url="../default/footer.jsp"/>
</body>
</html>