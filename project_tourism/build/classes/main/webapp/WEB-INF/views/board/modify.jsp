<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
	<form action="/board/modify" method="post">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${detail.title}"></td>
				<th>글쓴이</th>
				<td>${detail.userId}</td>
				<th>조회수</th>
				<td>${detail.hit}</td>
				<th>추천</th>
				<td>${detail.recommend}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="7"><textarea name="content"  style="width: 1000px;height: 100px;">${detail.content }</textarea></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td colspan="7">${detail.regDate}</td>
			</tr>
			<tr>
				<th>수정일</th>
				<td colspan="7">${detail.updateDate}</td>
			</tr>
			<tr>
				<th colspan="8">댓글</th>
			</tr>
		</table>
		<input type="hidden" name="id" value="${detail.id }">
		<input type="submit" value="수정하기">
	</form>
	<br>
	<button onclick="self.location='/board/list'">뒤로가기</button>
</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>