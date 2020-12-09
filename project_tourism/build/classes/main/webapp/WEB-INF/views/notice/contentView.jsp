<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../default/header.jsp"/>
<div align="center">
	<h1>글 내용</h1>
	<table border="1">
		<colgroup>
			<col style="width:10%;">
			<col style="width:auto;">
			<col style="width:10%;">
			<col style="width:5%;">
		</colgroup>
		
		<tr>
			<th>제목</th>
			<td>${contentView.notice_title}</td>
			<th>조회수</th>
			<td>${contentView.notice_hit}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea name="content" style="width: 99.7%; min-height: 200px;"readonly>${contentView.notice_content }</textarea>
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td colspan="3">${contentView.notice_reg_date}</td>
		</tr>
		<c:choose>
			<c:when test="${contentView.notice_upt_date ne null}">
				<th>수정일</th>
				<td colspan="3">${contentView.notice_upt_date}</td>
			</c:when>
		</c:choose>
		<tr>
			<td colspan="4" style="text-align: right;"> <!-- 관리자로 접근했을때 이 곳 활성화되도록 추후 수정 -->
				<a href="noticeList">목록보기</a> &nbsp;
				<a href="modifyForm?no=${contentView.notice_no }">수정</a> &nbsp; 
				<a href="delete?no=${contentView.notice_no }">삭제</a> &nbsp;
			</td>
		</tr>
	</table>
</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>