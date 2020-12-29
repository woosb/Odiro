<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.boardBody {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
</style>
</head>
<body class="boardBoady">
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
	<c:if test="${pageMaker.prev }">
		<a href="/board/list?pageNum=${pageMaker.startPage-1 }"><c:out value="prev"/></a>
	</c:if>
	<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="page">
		<a href="/board/list?pageNum=${page }"><c:out value="${page }"/></a>
	</c:forEach>
	<c:if test="${pageMaker.next }">
		<a href="/board/list?pageNum=${pageMaker.endPage+1 }"><c:out value="next"/></a>
	</c:if>
	<br><br>
	<form id='searchForm' action="/board/list" method='get' >
		<select name='type'>
			<option value="" <c:out value="${pageMaker.cri.type == null? 'selected ' : ''}"/>>--</option>
			<option value="T" <c:out value="${pageMaker.cri.type eq 'T'? 'selected ' : ''}"/>>제목</option>
			<option value="C" <c:out value="${pageMaker.cri.type eq 'C'? 'selected ' : ''}"/>>내용</option>
			<option value="W" <c:out value="${pageMaker.cri.type eq 'W'? 'selected ' : ''}"/>>글쓴이</option>
		</select>
		<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword }"/>'/>
		<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum }"/>'/>
		<input type="submit" value="Search">
	</form>
</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>