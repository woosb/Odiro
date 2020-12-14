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
	<table border="1">
		<tr>
			<th>번호</th>	
			<th>제목</th>	
			<th>글쓴이	</th>	
			<th>작성일</th>	
			<th>조회수</th>	
			<th>추천</th>	
			<th>ref</th>	
			<th>step</th>	
			<th>refOrder</th>	
			<th>answerNum</th>	
			<th>parentNum</th>	
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<td><c:out value="${list.id }"/></td>
				<td><a href="/board/detail?id=${list.id }&ref=${list.ref }"><c:out value="${list.title }"/></a></td>
				<td><c:out value="${list.userId }"/></td>
				<td><c:out value="${list.regDate }"/></td>
				<td><c:out value="${list.hit }"/></td>
				<td><c:out value="${list.recommend }"/></td>
				<td><c:out value="${list.ref }"/></td>
				<td><c:out value="${list.step }"/></td>
				<td><c:out value="${list.refOrder }"/></td>
				<td><c:out value="${list.answerNum }"/></td>
				<td><c:out value="${list.parentNum }"/></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/board/register" >글 작성</a>
</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>